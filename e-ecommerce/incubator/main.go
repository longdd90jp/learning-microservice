package main

import (
	"fmt"
	"os"
	"os/exec"
	"strings"

	"io/ioutil"

	"path/filepath"

	"encoding/json"

	"bufio"
	"log"
	"syscall"

	"github.com/google/go-github/github"
	"github.com/pkg/errors"
	"golang.org/x/crypto/ssh/terminal"
	"golang.org/x/net/context"
)

type services struct {
	Services []string
}

func main() {
	usr, pwd, client := newGithubClient()
	ctx := context.Background()
	_, _, err := client.Users.Get(ctx, "")
	if err != nil {
		log.Fatalf("error: %+v\n", err)
	}

	cloneServices(ctx, usr, pwd, client)
}

func newGithubClient() (string, string, *github.Client) {
	r := bufio.NewReader(os.Stdin)
	fmt.Print("Github Username: ")
	usr, _ := r.ReadString('\n')

	fmt.Print("Github Password: ")
	bytePassword, _ := terminal.ReadPassword(int(syscall.Stdin))
	pwd := string(bytePassword)

	fmt.Println()

	tp := github.BasicAuthTransport{
		Username: strings.TrimSpace(usr),
		Password: strings.TrimSpace(pwd),
	}

	return usr, pwd, github.NewClient(tp.Client())
}

func loadJSON() ([]string, error) {
	data, err := ioutil.ReadFile("./services.json")
	if err != nil {
		return nil, errors.Wrap(err, "failed to open service.json")
	}

	services := new(services)

	if err := json.Unmarshal(data, services); err != nil {
		return nil, errors.Wrap(err, "failed to parse service.json")
	}

	return services.Services, nil
}

func mkDestDir(repo *github.Repository) (string, error) {
	dir, err := os.Getwd()
	if err != nil {
		return "", err
	}

	cloneDir, _ := filepath.Split(dir)
	cloneDir = filepath.Join(cloneDir, "ec-services", *repo.Name)

	return cloneDir, nil
}

func cloneServices(ctx context.Context, usr, pwd string, client *github.Client) {
	services, err := loadJSON()
	if err != nil {
		log.Fatalf("fail to load service.json: %+v", err)
	}

	for _, s := range services {
		repo, _, err := client.Repositories.Get(ctx, "dr-joy", s)
		if err != nil {
			log.Printf("faield to get repository: %s \n %v", s, err)
			continue
		}

		if clone(usr, pwd, repo); err != nil {
			log.Printf("failed to clone. service: %s, %v", s, err)
		}
	}

}

func clone(user, pass string, repo *github.Repository) error {
	dest, err := mkDestDir(repo)
	if err != nil {
		return err
	}

	if _, err := os.Stat(dest); os.IsNotExist(err) {
		cmd := exec.Command("git", "clone", *repo.SSHURL, dest)
		log.Printf("git clone %v %v\n", *repo.SSHURL, dest)
		if err := cmd.Run(); err != nil {
			return err
		}
	} else {
		log.Printf("skip clone %v\n", *repo.Name)
	}
	return nil
}

package dr.app.backend.attendance;

import dr.app.backend.attendance.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AttendanceApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(AttendanceApplication.class, args);
    }

    @Autowired
    RegistrationService registrationService;

    @Override
    public void run(String... args) throws Exception {
        registrationService.listInstallationBeacon();
    }
}

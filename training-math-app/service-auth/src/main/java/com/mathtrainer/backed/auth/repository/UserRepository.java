package com.mathtrainer.backed.auth.repository;

import com.mathtrainer.backed.auth.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findFirstByUsername(String username);
    Optional<User> findFirstByUsernameAndAndPassword(String username, String password);
}

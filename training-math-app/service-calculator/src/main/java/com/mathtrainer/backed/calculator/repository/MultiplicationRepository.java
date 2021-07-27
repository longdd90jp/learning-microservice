package com.mathtrainer.backed.calculator.repository;

import com.mathtrainer.backed.calculator.domain.Multiplication;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MultiplicationRepository extends MongoRepository<Multiplication, String> {
}

package com.example.exampleproject.repository;

import com.example.exampleproject.model.TestModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestModelRepository extends JpaRepository<TestModel, Integer> {
}

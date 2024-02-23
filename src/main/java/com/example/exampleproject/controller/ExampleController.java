package com.example.exampleproject.controller;

import com.example.exampleproject.dto.utils.Response;
import com.example.exampleproject.dto.utils.ResponseUtils;
import com.example.exampleproject.exception.EntityNotFoundException;
import com.example.exampleproject.model.TestModel;
import com.example.exampleproject.repository.TestModelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/example-api")
public class ExampleController {

    private final TestModelRepository testModelRepository;

    @GetMapping("/get-data")
    public ResponseEntity<Response> getDataExamples() {
        return ResponseUtils.ok(testModelRepository.findAll());
    }

    @PostMapping("/create-data/{name}")
    public ResponseEntity<Response> createDataExamples(@PathVariable String name) {
        var testModel = new TestModel();
        testModel.setName(name);
        return ResponseUtils.ok(testModelRepository.save(testModel));
    }

    @PostMapping("/update-data/{id}/name/{name}")
    public ResponseEntity<Response> updateDataExamples(@PathVariable String name, @PathVariable Integer id) {
        var testModel = testModelRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(TestModel.class.toString(), id.toString()));
        testModel.setName(name);
        return ResponseUtils.ok(testModelRepository.save(testModel));
    }
}

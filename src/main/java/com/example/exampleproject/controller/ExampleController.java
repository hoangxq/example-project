package com.example.exampleproject.controller;

import com.example.exampleproject.dto.utils.Response;
import com.example.exampleproject.dto.utils.ResponseUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/example-api")
public class ExampleController {

    @GetMapping("/get-data")
    public ResponseEntity<Response> getDatExamples() {
        return ResponseUtils.ok("Ok message", 200);
    }
}

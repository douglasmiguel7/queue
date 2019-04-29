package com.github.douglasmiguel7.queue.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hello-world")
public class HelloWorldAPI {

    @GetMapping
    public ResponseEntity helloWorld() {
        return ResponseEntity.ok("HelloWorld !");
    }

}

package com.example.datatypes_image;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/string")
    public String getString() {
        return "Hello, World!";
    }

    @GetMapping("/integer")
    public Integer getInteger() {
        return 42;
    }

    @GetMapping("/list")
    public List<String> getList() {
        return Arrays.asList("Apple", "Banana", "Cherry");
    }

    @GetMapping("/object")
    public CustomObject getObject() {
        return new CustomObject("John Doe", 30);
    }

    @GetMapping("/text")
    public ResponseEntity<String> getText() {
        return new ResponseEntity<>("Hello, this is a text response!", HttpStatus.OK);
    }

    @GetMapping("/json")
    public ResponseEntity<MyData> getJson() {
        MyData data = new MyData("John", 30);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/image")
    public ResponseEntity<byte[]> getImage() throws IOException {
        Resource resource = new ClassPathResource("static/image.jpg");
        byte[] imageBytes = Files.readAllBytes(resource.getFile().toPath());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "image/jpeg");

        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }

    static class CustomObject {
        private String name;
        private int age;

        public CustomObject(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
    static class MyData {
        private String name;
        private int age;

        public MyData(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Getters and setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}

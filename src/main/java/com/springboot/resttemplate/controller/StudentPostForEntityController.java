package com.springboot.resttemplate.controller;

import com.springboot.resttemplate.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping(path = "post-for-entity")
public class StudentPostForEntityController {

  @Autowired
  private RestTemplate restTemplate;

  @PostMapping(path = "/student")
  public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
    ResponseEntity<Student> response = restTemplate.postForEntity("http://localhost:8585/student",student,Student.class);
    return ResponseEntity.ok(response.getBody());
  }

  @PostMapping(path = "/students")
  public ResponseEntity<String> saveStudents(@RequestBody Student student) {
    ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8585/student",student,String.class);
    return ResponseEntity.ok(response.getBody());
  }
}

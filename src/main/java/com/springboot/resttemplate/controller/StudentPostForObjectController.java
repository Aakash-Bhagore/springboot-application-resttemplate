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
@RequestMapping(path = "post-for-object")
public class StudentPostForObjectController {

  @Autowired
  private RestTemplate restTemplate;

  @PostMapping(path = "/students")
  public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
    Student response = restTemplate.postForObject("http://localhost:8585/student",student,Student.class);
    return ResponseEntity.ok(response!=null?response:null);
  }

  @PostMapping(path = "/student")
  public ResponseEntity<String> saveStudents(@RequestBody Student student) {
    String response = restTemplate.postForObject("http://localhost:8585/student",student,String.class);
    return ResponseEntity.ok(!response.trim().isBlank()?response:null);
  }
}

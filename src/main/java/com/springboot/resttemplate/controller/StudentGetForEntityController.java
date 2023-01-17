package com.springboot.resttemplate.controller;

import com.springboot.resttemplate.entity.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping(path = "/get")
public class StudentGetForEntityController {

  //getting Student object back from resTemplate using getForEntity()
  @GetMapping(path = "/student/{studentId}")
  public ResponseEntity<Student> findStudent(@PathVariable("studentId") int studentId) {
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<Student> response = restTemplate.getForEntity("http://localhost:8585/students/"+studentId,Student.class);
    return ResponseEntity.ok(response.getBody());
  }
}

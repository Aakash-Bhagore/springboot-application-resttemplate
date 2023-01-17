package com.springboot.resttemplate.controller;

import com.springboot.resttemplate.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping(path = "/get-for-object")
public class StudentGetForObjectController {

  @Autowired
  private RestTemplate restTemplate;

  //getting Student object back from resTemplate using getForEntity()
  @GetMapping(path = "/student/{studentId}")
  public ResponseEntity<Student> findStudent(@PathVariable("studentId") int studentId) {
    Student response = restTemplate.getForObject("http://localhost:8585/students/"+studentId,Student.class);
    return ResponseEntity.ok(response);
  }

  @GetMapping(path = "/students")
  public ResponseEntity<List<Student>> getStudents() {
    List response = restTemplate.getForObject("http://localhost:8585/students", List.class);
//    List<Student> students = response;
    return ResponseEntity.ok(response);
  }

  @GetMapping(path = "/student")
  public ResponseEntity<Student[]> getStudent_s() {
    Student[] response = restTemplate.getForObject("http://localhost:8585/students", Student[].class);
    return ResponseEntity.ok(response);
  }

  @GetMapping(path = "/students/{studentId}")
  public ResponseEntity<String> getStudentByStudentId(@PathVariable("studentId") int studentId) {
    String student = restTemplate.getForObject("http://localhost:8585/student/"+studentId, String.class);
    return ResponseEntity.ok(student!=null?student:null);
  }
}

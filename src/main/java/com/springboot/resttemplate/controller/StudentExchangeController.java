package com.springboot.resttemplate.controller;

import com.springboot.resttemplate.entity.Student;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Controller
@RequestMapping(path = "/exchange")
public class StudentExchangeController {


  //Getting List<Student> as a response back using RestTemplate exchange()
  @GetMapping(path = "/students")
  public ResponseEntity<List<Student>> getStudents() {
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<List> response = restTemplate.exchange("http://localhost:8585/students", HttpMethod.GET, null, List.class);
    List<Student> students = response.getBody();
    return ResponseEntity.ok(students);
  }

  //Getting Student[] as a response back using RestTemplate exchange()
  @GetMapping(path = "/students")
  public ResponseEntity<Student[]> getStudent() {
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<Student[]> response = restTemplate.exchange("http://localhost:8585/students", HttpMethod.GET, null, Student[].class);
    Student[] students = response.getBody();
    return ResponseEntity.ok(students!=null?students:null);
  }

  //getting Student Object as response back from restTemplate using exchange()
  @GetMapping(path = "/students/{studentId}")
  public ResponseEntity<Student> getStudentByStudentId(@PathVariable("studentId") int studentId) {
    RestTemplate restTemplate = new RestTemplate();
    Student student = restTemplate.exchange("http://localhost:8585/students/" + studentId, HttpMethod.GET, null, Student.class).getBody();
    return ResponseEntity.ok(student != null ? student : null);
  }

  //Getting String as response using RestTemplate exchange()
  @GetMapping(path = "/student/{studentId}")
  public ResponseEntity<String> getStudent(@PathVariable("studentId") int studentId) {
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> restTemplateResponse = restTemplate.exchange("http://localhost:8585/student/" + studentId, HttpMethod.GET, null, String.class);
    String student = restTemplateResponse.getBody().toString();
    return ResponseEntity.ok(student);
  }


}

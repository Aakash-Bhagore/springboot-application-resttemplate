package com.springboot.resttemplate.controller;

import com.springboot.resttemplate.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Controller
@RequestMapping(path = "/exchange")
public class StudentExchangeController {

   @Autowired
   private RestTemplate restTemplate;

  //Getting List<Student> as a response back using RestTemplate exchange()
  @GetMapping(path = "/students")
  public ResponseEntity<List<Student>> getStudents() {
    ResponseEntity<List> response = restTemplate.exchange("http://localhost:8585/students", HttpMethod.GET, null, List.class);
    List<Student> students = response.getBody();
    return ResponseEntity.ok(students);
  }

  //Getting Student[] as a response back using RestTemplate exchange()
  @GetMapping(path = "/student")
  public ResponseEntity<Student[]> getStudent() {
    ResponseEntity<Student[]> response = restTemplate.exchange("http://localhost:8585/students", HttpMethod.GET, null, Student[].class);
    Student[] students = response.getBody();
    return ResponseEntity.ok(students!=null?students:null);
  }

  //getting Student Object as response back from restTemplate using exchange()
  @GetMapping(path = "/students/{studentId}")
  public ResponseEntity<Student> getStudentByStudentId(@PathVariable("studentId") int studentId) {
    Student student = restTemplate.exchange("http://localhost:8585/students/" + studentId, HttpMethod.GET, null, Student.class).getBody();
    return ResponseEntity.ok(student != null ? student : null);
  }

  //Getting String as response using RestTemplate exchange()
  @GetMapping(path = "/student/{studentId}")
  public ResponseEntity<String> getStudent(@PathVariable("studentId") int studentId) {
    ResponseEntity<String> restTemplateResponse = restTemplate.exchange("http://localhost:8585/student/" + studentId, HttpMethod.GET, null, String.class);
    String student = restTemplateResponse.getBody().toString();
    return ResponseEntity.ok(student);
  }


  @PostMapping(path = "/student")
  public ResponseEntity<Student> saveStudent(@RequestBody Student student){
   ResponseEntity<Student> response = restTemplate.exchange("http://localhost:8585/student", HttpMethod.POST, new HttpEntity<>(student), Student.class);
   return ResponseEntity.ok(response.getBody());
  }

  @PutMapping(path = "/student")
  public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
    Student updatedStudent = restTemplate.exchange("http://localhost:8585/student", HttpMethod.PUT, new HttpEntity<>(student), Student.class).getBody();
    return ResponseEntity.ok(updatedStudent!=null?updatedStudent:null);
  }

  @DeleteMapping(path = "/student/{studentId}")
  public ResponseEntity<String> deleteStudent(@PathVariable("studentId") int studentId) {
    ResponseEntity<String> response = restTemplate.exchange("http://localhost:8585/student/"+studentId, HttpMethod.DELETE, null, String.class);
    return ResponseEntity.ok(response.getBody());
  }
}

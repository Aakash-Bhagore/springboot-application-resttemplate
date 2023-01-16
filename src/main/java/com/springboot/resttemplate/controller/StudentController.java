package com.springboot.resttemplate.controller;

import com.springboot.resttemplate.entity.Student;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class StudentController {


  //Getting List<Student> as a response using RestTemplate exchange()
  @GetMapping(path = "/students")
  public ResponseEntity<List<Student>> getStudents() {
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<List>  response = restTemplate.exchange("http://localhost:8585/students", HttpMethod.GET,null, List.class);
    List<Student> students = response.getBody();
    return ResponseEntity.ok(students);
  }

  //Getting String as response using RestTemplate exchange()
  @GetMapping(path = "/student/{studentId}")
  public ResponseEntity<String> getStudent(@PathVariable("studentId") int studentId) {
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> restTemplateResponse = restTemplate.exchange("http://localhost:8585/student/"+studentId, HttpMethod.GET,null, String.class);
    String student = restTemplateResponse.getBody().toString();
    return ResponseEntity.ok(student);
  };

  //getting Student Object as response back from restTemplate using exchange()
  @GetMapping(path = "/students/{studentId}")
  public ResponseEntity<Student> getStudentByStudentId(@PathVariable("studentId") int studentId) {
   RestTemplate restTemplate = new RestTemplate();
   Student student = restTemplate.exchange("http://localhost:8585/students/"+studentId, HttpMethod.GET, null, Student.class).getBody();
   return ResponseEntity.ok(student!=null?student:null);
  };

  //getting Student object back from resTemplate calling using getForEntity()
  @GetMapping(path = "studentid/{studentId}")
  public ResponseEntity<Student> findStudent(@PathVariable("studentId") int studentId) {
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<Student> response = restTemplate.getForEntity("http://localhost:8585/students/"+studentId,Student.class);
    return ResponseEntity.ok(response.getBody());
  }
}

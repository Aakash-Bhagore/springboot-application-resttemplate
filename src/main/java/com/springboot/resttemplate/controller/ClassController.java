package com.springboot.resttemplate.controller;

import com.springboot.resttemplate.entity.Class;
import com.springboot.resttemplate.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/class")
public class ClassController {

  @Autowired
  private ClassService classService;

  @GetMapping(path = "/all")
  public ResponseEntity getAllClasses(){
    try{
      return ResponseEntity.ok(this.classService.getAllClasses());
    } catch(Exception e) {
      return ResponseEntity.ok("Something went wrong with following message "+e.getMessage());
    }
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity getClassById(@PathVariable("id") long id){
    try{
      return ResponseEntity.ok(this.classService.getClass(id));
    } catch(Exception e) {
      return ResponseEntity.ok("Something went wrong with following message "+e.getMessage());
    }
  }

  @PostMapping(path = "/save")
  public ResponseEntity saveClass(@RequestBody Class cls){
    try{
      return ResponseEntity.ok(this.classService.saveClass(cls));
    } catch(Exception e) {
      return ResponseEntity.ok("Something went wrong with following message "+e.getMessage());
    }
  }

  @PutMapping(path = "/update")
  public ResponseEntity updateClass(@RequestBody Class cls){
    try{
      return ResponseEntity.ok(this.classService.updateClassData(cls));
    } catch(Exception e) {
      return ResponseEntity.ok("Something went wrong with following message "+e.getMessage());
    }
  }

  @DeleteMapping(path = "/delete/{id}")
  public ResponseEntity deleteClassById(@PathVariable("id") long id){
    try{
      return ResponseEntity.ok(this.classService.deleteClass(id));
    } catch(Exception e) {
      return ResponseEntity.ok("Something went wrong with following message "+e.getMessage());
    }
  }
}

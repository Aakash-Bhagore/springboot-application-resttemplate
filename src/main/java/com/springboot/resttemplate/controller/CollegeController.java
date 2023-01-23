package com.springboot.resttemplate.controller;

import com.springboot.resttemplate.entity.Class;
import com.springboot.resttemplate.entity.College;
import com.springboot.resttemplate.service.ClassService;
import com.springboot.resttemplate.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/college")
public class CollegeController {


  @Autowired
  private CollegeService collegeService;

  @GetMapping(path = "/all")
  public ResponseEntity getAllColleges(){
    try{
      return ResponseEntity.ok(this.collegeService.getAllColleges());
    } catch(Exception e) {
      return ResponseEntity.ok("Something went wrong with following message "+e.getMessage());
    }
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity getCollegeById(@PathVariable("id") long id){
    try{
      return ResponseEntity.ok(this.collegeService.getCollege(id));
    } catch(Exception e) {
      return ResponseEntity.ok("Something went wrong with following message "+e.getMessage());
    }
  }

  @PostMapping(path = "/save")
  public ResponseEntity saveCollege(@RequestBody College cls){
    try{
      return ResponseEntity.ok(this.collegeService.saveCollege(cls));
    } catch(Exception e) {
      return ResponseEntity.ok("Something went wrong with following message "+e.getMessage());
    }
  }

  @PutMapping(path = "/update")
  public ResponseEntity updateCollege(@RequestBody College cls){
    try{
      return ResponseEntity.ok(this.collegeService.updateCollegeData(cls));
    } catch(Exception e) {
      return ResponseEntity.ok("Something went wrong with following message "+e.getMessage());
    }
  }

  @DeleteMapping(path = "/delete/{id}")
  public ResponseEntity deleteCollegeById(@PathVariable("id") long id){
    try{
      return ResponseEntity.ok(this.collegeService.deleteCollege(id));
    } catch(Exception e) {
      return ResponseEntity.ok("Something went wrong with following message "+e.getMessage());
    }
  }

}

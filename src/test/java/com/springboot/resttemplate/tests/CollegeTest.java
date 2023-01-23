package com.springboot.resttemplate.tests;

import com.springboot.resttemplate.entity.College;
import com.springboot.resttemplate.service.CollegeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

/*
JUnit testcases
*/
@SpringBootTest
public class CollegeTest {

  @Autowired
  private CollegeService collegeService;

  @Test
  void getColleges() {
    College college = new College(1l,"RGPV", LocalDate.now());
    List<College> colleges = collegeService.getAllColleges();
    Assertions.assertNotNull(colleges);
    Assertions.assertTrue(!colleges.isEmpty());

    Assertions.assertSame(colleges.get(0).getId(),2L);
  }
}

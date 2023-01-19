package com.springboot.resttemplate.dto;

import com.springboot.resttemplate.entity.Class;

import java.time.LocalDate;
import java.util.List;

public class CollegeDto {
  private Long id;
  private String collegeName;
  private LocalDate collegeOpenDate;
  private List<Class> classes;
}

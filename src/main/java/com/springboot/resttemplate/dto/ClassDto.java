package com.springboot.resttemplate.dto;

import com.springboot.resttemplate.entity.Student;

import java.util.List;

public class ClassDto {
  private Long id;
  private String className;
  private String classCode;
  private List<Student> students;
}

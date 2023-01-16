package com.springboot.resttemplate.entity;

import java.time.LocalDate;

public class Student {
  private int studentId;
  private String studentName;
  private LocalDate studentDOB;
  private String studentQuote;

  public Student(int studentId, String studentName, LocalDate studentDOB, String studentQuote) {
    this.studentId = studentId;
    this.studentName = studentName;
    this.studentDOB = studentDOB;
    this.studentQuote = studentQuote;
  }
  public Student(){super();};

  public int getStudentId() {
    return studentId;
  }

  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }

  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public LocalDate getStudentDOB() {
    return studentDOB;
  }

  public void setStudentDOB(LocalDate studentDOB) {
    this.studentDOB = studentDOB;
  }

  public String getStudentQuote() {
    return studentQuote;
  }

  public void setStudentQuote(String studentQuote) {
    this.studentQuote = studentQuote;
  }

  @Override
  public String toString() {
    return "Student{" +
        "studentId=" + studentId +
        ", studentName='" + studentName + '\'' +
        ", studentDOB=" + studentDOB +
        ", studentQuote='" + studentQuote + '\'' +
        '}';
  }
}

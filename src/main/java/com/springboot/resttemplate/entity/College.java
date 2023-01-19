package com.springboot.resttemplate.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table
public class College {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  private Long id;
  private String collegeName;
  private LocalDate collegeOpenDate;

  public College() {
  }

}

package com.springboot.resttemplate.service;

import com.springboot.resttemplate.entity.College;

import java.util.List;

public interface CollegeService {

  public College saveCollege(College college);

  public College getCollege(long id);

  public List<College> getAllColleges();

  public College updateCollegeData(College college);

  public String deleteCollege(long id);
}

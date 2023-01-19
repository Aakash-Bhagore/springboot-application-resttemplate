package com.springboot.resttemplate.serviceimpl;

import com.springboot.resttemplate.entity.College;
import com.springboot.resttemplate.repository.CollegeRepository;
import com.springboot.resttemplate.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CollegeServiceImpl implements CollegeService {


  @Autowired
  private CollegeRepository collegeRepository;

  @Override
  public College saveCollege(College college) {
    college.setCollegeOpenDate(LocalDate.now());
    return this.collegeRepository.save(college);
  }

  @Override
  public College getCollege(long id) {
    return this.collegeRepository.findById(id).get();
  }

  @Override
  public List<College> getAllColleges() {
    return (List<College>)this.collegeRepository.findAll();
  }

  @Override
  public College updateCollegeData(College college) {
    college.setCollegeOpenDate(LocalDate.now());
    return this.collegeRepository.save(college);
  }

  @Override
  public String deleteCollege(long id) {
    if(id<=0){
      throw new RuntimeException("Please provide valid id");
    } else {
      this.collegeRepository.deleteById(id);
      return "Class deleted successfully ";
    }
  }
}

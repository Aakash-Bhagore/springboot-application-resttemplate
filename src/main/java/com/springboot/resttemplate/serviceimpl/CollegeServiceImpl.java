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
    if (college.getCollegeName().isBlank()){
      throw new RuntimeException("Data not found: "+college);
    }
    college.setCollegeOpenDate(LocalDate.now());
    return this.collegeRepository.save(college);
  }

  @Override
  public College getCollege(long id) {
    College college = this.collegeRepository.findById(id).get();
    if(college!=null) throw new RuntimeException("Data not found for Id: "+id);
    return college;
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


  private List<College> saveCollegeTestingPurpose(College college) {

    if (college.getCollegeName().isBlank()) {
       College savedCollege = this.collegeRepository.save(college);
        if (savedCollege.getCollegeName().isBlank()){
          throw new RuntimeException("RequestBody is empty "+college);
      }
    }
    return (List<College>)this.collegeRepository.findAll();
  }
}

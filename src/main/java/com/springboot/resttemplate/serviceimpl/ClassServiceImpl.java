package com.springboot.resttemplate.serviceimpl;

import com.springboot.resttemplate.entity.Class;
import com.springboot.resttemplate.repository.ClassRepository;
import com.springboot.resttemplate.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

  @Autowired
  private ClassRepository classRepository;

  @Override
  public Class saveClass(Class cls) {
    return this.classRepository.save(cls);
  }

  @Override
  public Class getClass(long id) {
    return this.classRepository.findById(id).get();
  }

  @Override
  public List<Class> getAllClasses() {
    List<Class> classList = (List<Class>) this.classRepository.findAll();
    return !classList.isEmpty()?classList:null;
  }

  @Override
  public Class updateClassData(Class cls) {
    return this.classRepository.saveAndFlush(cls);
  }

  @Override
  public String deleteClass(long id) {
    if(id<=0){
      throw new RuntimeException("Please provide valid id");
    } else {
      this.classRepository.deleteById(id);
      return "Class deleted successfully ";
    }
  }

  private List<Class> getAllClass() {
    List<Class> classList = (List<Class>) this.classRepository.findAll();
      if(classList.isEmpty()) {
        throw new RuntimeException("Something went wrong");
      } else if (classList.get(0).getId()==0) {
        throw new RuntimeException("Something went wrong");
      }
    return !classList.isEmpty()?classList:null;
  }
}

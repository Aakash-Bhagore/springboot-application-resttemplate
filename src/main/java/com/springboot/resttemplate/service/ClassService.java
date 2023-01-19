package com.springboot.resttemplate.service;

import com.springboot.resttemplate.entity.Class;
import com.springboot.resttemplate.entity.College;

import java.util.List;

public interface ClassService {

  public Class saveClass(Class clas);

  public Class getClass(long id);

  public List<Class> getAllClasses();

  public Class updateClassData(Class cls);

  public String deleteClass(long id);

}

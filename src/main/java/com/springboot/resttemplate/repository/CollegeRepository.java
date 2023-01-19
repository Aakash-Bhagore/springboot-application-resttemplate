package com.springboot.resttemplate.repository;

import com.springboot.resttemplate.entity.College;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeRepository extends CrudRepository<College,Long> {
}

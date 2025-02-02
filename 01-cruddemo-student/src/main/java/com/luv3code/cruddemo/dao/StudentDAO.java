package com.luv3code.cruddemo.dao;

import com.luv3code.cruddemo.entity.Student;

import java.util.List;


public interface StudentDAO {

    void save(Student theStudent);
    Student find(int id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
    void update(Student theStudent);

    Student findById(int i);
    void delete(Student theStudent);
    int deleteAll();

}

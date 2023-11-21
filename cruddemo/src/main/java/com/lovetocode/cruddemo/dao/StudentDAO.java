package com.lovetocode.cruddemo.dao;

import com.lovetocode.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save (Student theStudent);
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String theLastname);
    void update(Student student);
    void delete(int id);
    int deleteAll();
}

package com.dao;

import java.util.List;

import com.entities.Student;

public interface StudentDao {
    public int insert(Student student);
    public void update(Student student);
    public void delete(int studentId);
    public Student getOneStudent(int studentId);
    public List<Student> getAll();
}

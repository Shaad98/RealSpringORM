package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.entities.Student;

public class StudentDaoImpl implements StudentDao{
    private HibernateTemplate hibernateTemplate;
    @Transactional
    public int insert(Student student)
    {
        int r = (Integer)this.hibernateTemplate.save(student);
        System.out.println(r+" row inserted!");
        return r;
    }
    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
    @Override
    @Transactional
    public void update(Student student) {
        this.hibernateTemplate.update(student);
        System.out.println("1 row updated!");
    }
    @Override
    @Transactional
    public void delete(int studentId) {
        Student student = this.hibernateTemplate.get(Student.class,studentId);
        this.hibernateTemplate.delete(student);
        System.out.println("1 row deleted!");
    }
    @Override
    public Student getOneStudent(int studentId) {
        Student student = this.hibernateTemplate.get(Student.class, studentId);
        return student;
    }
    @Override
    public List<Student> getAll() {
      List<Student> students = this.hibernateTemplate.loadAll(Student.class);
      return students;
    }
    
}

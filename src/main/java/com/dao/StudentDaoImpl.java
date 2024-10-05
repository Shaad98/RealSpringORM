package com.dao;

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
    
}

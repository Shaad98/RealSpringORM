package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
// import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.dao.*;

// import o;

// import ;

// import;
import com.entities.*;
import java.util.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // DriverManagerDataSource
        Scanner sc = new Scanner(System.in);
        // HibernateTemplate
        // LocalSessionFactoryBean
        // PostgreSQLDialect
        // System.out.println( "Hello World!" );

        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        int ch,id;
        String name , city;
        Student student = new Student();
        StudentDao studentDao = context.getBean("s",StudentDao.class);
        while(true)
        {
            System.out.print("\n1.Insert\n2.Update\n3.Delete\n4.Select One\n5.Select All\n6.Exit\nEnter Your Choice : ");
            ch = sc.nextInt();
            sc.nextLine();
            switch(ch)
            {
                case 1->{
                    System.out.print("Enter name : ");
                    name = sc.nextLine();
                    System.out.print("Enter city : ");
                    city = sc.nextLine();
                    student.setCity(city);
                    student.setName(name);
                    studentDao.insert(student);
                }
                case 2->{
                    System.out.print("Enter id : ");
                    id = sc.nextInt();
                    sc.nextLine();
                    student.setId(id);
                    System.out.print("Enter new name : ");
                    name = sc.nextLine();
                    System.out.print("Enter new city : ");
                    city = sc.nextLine();
                    student.setId(id);
                    student.setCity(city);
                    student.setName(name);
                    studentDao.update(student);
                }
                case 3->{
                    System.out.print("Enter id : ");
                    id = sc.nextInt();
                    sc.nextLine();
                    studentDao.delete(id);
                }
                case 4->{
                    System.out.print("Enter id : ");
                    id = sc.nextInt();
                    sc.nextLine();
                    Student st = studentDao.getOneStudent(id);
                    System.out.println("The details are as follows : ");
                    System.out.println(st);
                }
                case 5->{
                    List<Student> students = studentDao.getAll();
                    System.out.println("Details of all students are as follows : ");
                    for (Student student2 : students) {
                        System.out.println(student2);
                    }
                }
                
                case 6->{
                    sc.close();
                    System.exit(0);
                }
            }
        }
    }
}

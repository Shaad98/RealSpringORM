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
        int ch;
        String name , city;
        Student student = new Student();
        StudentDao studentDao = context.getBean("s",StudentDao.class);
        while(true)
        {
            System.out.print("\n1.Insert\n6.Display\nEnter Your Choice : ");
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
                case 6->{
                    sc.close();
                    System.exit(0);
                }
            }
        }
    }
}

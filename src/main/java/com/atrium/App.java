package com.atrium;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.support.DaoSupport;

import com.atrium.dao.StudentDao;
import com.atrium.entities.Student;

/**
 * @author Ash
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/atrium/config.xml");
        StudentDao studentdao = context.getBean("studentDao",StudentDao.class );
        
       System.out.println("-----------------------------------------------------------read---------------------------------------------------------------------------------------");
        //read
        Student student = studentdao.getStudent(2);
        System.out.println(student);
        
        System.out.println("-----------------------------------------------------------read all------------------------------------------------------------------------------------");
        //readAll
        List<Student> allStudents = studentdao.getAllStudents();
        System.out.println(allStudents);
        
        System.out.println("-----------------------------------------------------------update------------------------------------------------------------------------------------");
        Student student2 = studentdao.getStudent(3);
        student2.setStudentId(3);
        student2.setStudentName("Ram");
        student2.setStudentCity("Alaska");
        studentdao.updateStudent(student2);
        
        System.out.println("-----------------------------------------------------------delete------------------------------------------------------------------------------------");
        System.out.println(studentdao.deleteStudent(3));
    }
}

package com.atrium;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        Student s = new Student(1,"Ash","Delhi");
        Integer r =studentdao.insert(s);
        System.out.println(r);

    }
}

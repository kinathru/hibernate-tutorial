package com.kinath.udemy;

import com.kinath.udemy.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo
{
    public static void main( String[] args )
    {
        SessionFactory factory = new Configuration().configure( "hibernate.cfg.xml" ).addAnnotatedClass( Student.class ).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try
        {
            System.out.println( "Creating student...." );
            Student student = new Student( "Kinath", "Rupasinghe", "kinath@gmail.com" );
            session.beginTransaction();

            System.out.println( "Saving student : " + student.toString() );
            session.save( student );

            session.getTransaction().commit();
            System.out.println( "Student saved....." );
        }
        finally
        {
            factory.close();
        }
    }
}

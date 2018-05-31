package com.kinath.udemy;

import com.kinath.udemy.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo
{
    public static void main( String[] args )
    {
        SessionFactory factory = new Configuration().configure( "hibernate.cfg.xml" ).addAnnotatedClass( Student.class ).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try
        {
            System.out.println( "Creating student...." );
            Student student1 = new Student( "Kinath", "Rupasinghe", "kinath@gmail.com" );
            Student student2 = new Student( "Upulie", "Mahagamage", "upulie@gmail.com" );
            Student student3 = new Student( "Mary", "Atkinson", "mary@gmail.com" );
            session.beginTransaction();

            session.save( student1 );
            session.save( student2 );
            session.save( student3 );

            session.getTransaction().commit();
            System.out.println( "Student saved....." );
        }
        finally
        {
            factory.close();
        }
    }
}

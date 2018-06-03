package com.kinath.udemy;

import com.kinath.udemy.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo
{
    public static void main( String[] args )
    {
        SessionFactory factory = new Configuration().configure( "hibernate.cfg.xml" ).addAnnotatedClass( Student.class ).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try
        {
            System.out.println( "Creating student...." );
            Student student = new Student( "Daffy", "Duck", "daffy@gmail.com" );
            session.beginTransaction();

            System.out.println( "Saving student : " + student.toString() );
            session.save( student );

            session.getTransaction().commit();
            System.out.println( "Student saved....." );

            int id = student.getId();
            System.out.println( "Saved student ID : " + id );

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println( "Read student from the database : " );
            Student savedStudent = session.get( Student.class, id );
            if( savedStudent != null )
            {
                System.out.println( student.toString() );
            }
        }
        finally
        {
            factory.close();
        }
    }
}

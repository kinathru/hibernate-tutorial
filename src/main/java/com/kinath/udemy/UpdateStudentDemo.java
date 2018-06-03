package com.kinath.udemy;

import com.kinath.udemy.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo
{
    public static void main( String[] args )
    {
        SessionFactory factory = new Configuration().configure( "hibernate.cfg.xml" ).addAnnotatedClass( Student.class ).buildSessionFactory();
        try
        {
            Session session = factory.getCurrentSession();

            int studentId = 1;
            System.out.println( "Updating Student : " + studentId );
            session.beginTransaction();
            Student student = session.get( Student.class, studentId );
            student.setFirstName( "Madhawa" );
            session.getTransaction().commit();
            System.out.println( "Done!!!" );


            System.out.println("\n\n Bulk update email with query");
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery( "update Student set email='test@test.com '" ).executeUpdate();
            session.getTransaction().commit();
            System.out.println("Update Completed....");
        }
        finally
        {
            factory.close();
        }
    }
}

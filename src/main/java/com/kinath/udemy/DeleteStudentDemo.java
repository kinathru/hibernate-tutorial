package com.kinath.udemy;

import com.kinath.udemy.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo
{
    public static void main( String[] args )
    {
        SessionFactory factory = new Configuration().configure( "hibernate.cfg.xml" ).addAnnotatedClass( Student.class ).buildSessionFactory();
        try
        {
            Session session = factory.getCurrentSession();

            int studentId = 1;
            System.out.println( "Deleting Student : " + studentId );
            session.beginTransaction();
            Student student = session.get( Student.class, studentId );
            session.delete( student );
            session.getTransaction().commit();
            System.out.println( "Deleting Student Done!!!" );


            System.out.println("\n\n Delete student with query");
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery( "delete Student where id = 3" ).executeUpdate();
            session.getTransaction().commit();
            System.out.println("Delete Completed....");
        }
        finally
        {
            factory.close();
        }
    }
}

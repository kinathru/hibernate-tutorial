package com.kinath.udemy;

import com.kinath.udemy.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo
{
    public static void main( String[] args )
    {
        SessionFactory factory = new Configuration().configure( "hibernate.cfg.xml" ).addAnnotatedClass( Student.class ).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try
        {
            // start transaction
            session.beginTransaction();

            // query the students
            List studentList = session.createQuery( "from Student" ).getResultList();

            // display students
            System.out.println( "Displaying all students" );
            displayStudents( studentList );

            // query students with last name = 'Mahagamage'
            List studentList2 = session.createQuery( "from Student s where s.lastName = 'Mahagamage'" ).getResultList();
            System.out.println( "\n\nDisplaying all students with last name Mahagamage" );
            displayStudents( studentList2 );

            // query students with last name = 'Mahagamage' or firstname = 'Kinath'
            List studentList3 = session.createQuery( "from Student s where s.lastName='Mahagamage' or s.firstName='Kinath'" ).getResultList();
            System.out.println("\n\nDisplaying all students with given first name and last name");
            displayStudents( studentList3 );

            //using like query
            List studentList4 = session.createQuery( "from Student s where s.email like '%@ymail.com'" ).getResultList();
            System.out.println("\n\nFilter with email");
            displayStudents( studentList4 );

            // commit transaction
            session.getTransaction().commit();
        }
        finally
        {
            factory.close();
        }
    }

    private static void displayStudents( List studentList )
    {
        for( Object o : studentList )
        {
            System.out.println( o.toString() );
        }
    }
}

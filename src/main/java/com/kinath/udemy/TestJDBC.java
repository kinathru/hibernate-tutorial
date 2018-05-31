package com.kinath.udemy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC
{
    public static void main( String[] args )
    {
        String jdbcURL = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
        String user = "hbstudent";
        String password = "hbstudent";

        Connection myConn = null;
        try
        {
            System.out.println("Connecting to Database : " + jdbcURL);
            myConn = DriverManager.getConnection( jdbcURL, user, password );
            System.out.println("Successfully Connected");
        }
        catch( SQLException e )
        {
            System.out.println("Error connecting to Database : " + e.getMessage());
            e.printStackTrace();
        }
        finally
        {
            if( myConn != null )
            {
                try
                {
                    myConn.close();
                }
                catch( SQLException e )
                {
                    e.printStackTrace();
                }
            }
        }
    }
}

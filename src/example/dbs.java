package example;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class dbs {

    Connection conn = null;
    public static Connection java_db(){
        try{
            Class.forName("org.sqlite.JDBC"); //använder mig av JDBC för att ansluta till databasen
            Connection conn = DriverManager.getConnection("jdbc:sqlite://localhost/databas");
            return conn;
//C:\Users\Swagmaster\IdeaProjects\testbajs\databas.sqlite
        } catch (Exception e) {
            System.out.println("Not able to connect");
            return null;
        }
        }
    }


package jm.task.core.jdbc.util;

import com.mysql.cj.jdbc.Driver;
import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Parol#23";

    Util() {
    }
    public static Connection getConnectionJDBS() {
        Connection connection;
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException q) {
            System.out.println("Create driver is failed");
        }                                                                   //creating driver
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Data base has been opened");
            return connection;
        } catch (SQLException e) {
            System.err.println("Connection is failed" + " " + e.getMessage());
            return null;

        }


    }
    public static SessionFactory getConnectionHiber(){
        SessionFactory sessionFactory;
        Configuration con = new Configuration().configure();
        con.addAnnotatedClass(User.class);
        StandardServiceRegistryBuilder sBuild = new StandardServiceRegistryBuilder()
                .applySettings(con.getProperties());
        return con.buildSessionFactory(sBuild.build());
    }
}

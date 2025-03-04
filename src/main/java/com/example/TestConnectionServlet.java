package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestConnectionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // Get environment variables for MySQL connection
        String dbHost = System.getenv("DB_HOST");  // MySQL service name in OKE
        String dbPort = System.getenv("DB_PORT");  // Default is 3306
        String dbName = System.getenv("DB_NAME");  // Database name
        String user = System.getenv("DB_USER");    // MySQL username
        String password = System.getenv("DB_PASS"); // MySQL password

        // Construct the database URL dynamically
        String url = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Load MySQL driver (it might not be necessary in newer versions, but let's be explicit)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection conn = DriverManager.getConnection(url, user, password);
            out.println("Tomcat is running<br>");
            out.println("MySQL Connection Status: Successful");
            conn.close();
        } catch (ClassNotFoundException e) {
            out.println("MySQL Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            out.println("MySQL Connection Status: Failed to connect: " + e.getMessage());
        }
    }
}



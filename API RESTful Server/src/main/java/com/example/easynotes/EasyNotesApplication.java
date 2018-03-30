package com.example.easynotes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;



import javax.swing.JOptionPane;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing

public class EasyNotesApplication {

	public static void main(String[] args) {
	    try {
	        String databaseName = "tasks_app";
	        String userName = "root";
	        String password = "root";

	        String url = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
	        Connection connection = (Connection) DriverManager.getConnection(url,userName, password);

	        String sql = "CREATE DATABASE " + databaseName;

	        Statement statement = connection.createStatement();
	        statement.executeUpdate(sql);
	        statement.close();
	        JOptionPane.showMessageDialog(null, databaseName + " Database has been created successfully", "System Message", JOptionPane.INFORMATION_MESSAGE);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		SpringApplication.run(EasyNotesApplication.class, args);
	}
}

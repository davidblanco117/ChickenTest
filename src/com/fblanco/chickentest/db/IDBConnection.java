package com.fblanco.chickentest.db;

import java.sql.Connection;
import java.sql.DriverManager;
import static com.fblanco.chickentest.db.DataBase.*;

public interface IDBConnection {

	default Connection connectionToDB() {
		Connection connection =null;
		
		try {
			Class.forName("com.mtsql.jdbc.Driver");
			connection = DriverManager.getConnection(URL + DB, USER, PASS);
			if(connection !=null) {
				System.out.println("Establecida la conexion");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
				return connection;
		}
	
		
	}
	
	
	
}

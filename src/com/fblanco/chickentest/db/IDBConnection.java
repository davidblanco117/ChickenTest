package com.fblanco.chickentest.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.TimeZone;

import primaryPackage.Parametros;

import static com.fblanco.chickentest.db.DataBase.*;

public interface IDBConnection {

	//IMPORTANTE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!11
	//El metodo connection to DB tiene una variable booleana llamada modoTesting.
	//Si esa variable esta en true, la base de datos utilizada será una copia de la real con datos especificos para las pruebas
	
	
	
	default Connection connectionToDB() {
		Connection connection =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		//	Class.forName("com.mysql.cj.jdbc.Driver");
			if(Parametros.modoTesting)
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ DBTESTING+"?serverTimezone=" + TimeZone.getDefault().getID(), USER, PASS);
			else
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ DB+"?serverTimezone=" + TimeZone.getDefault().getID(), USER, PASS);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {	
		}
		return connection;
		
	}
	
	
	
	
	
}

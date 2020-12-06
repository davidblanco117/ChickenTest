package com.fblanco.chickentest.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fblanco.chickentest.db.IDBConnection;
import static com.fblanco.chickentest.db.DataBase.*;

import primaryPackage.*;

public interface ChickenDao extends IDBConnection{

	default ArrayList<Chicken> read(){
		ArrayList<Chicken> chickens = new ArrayList<Chicken>();
		
		try(Connection connection = connectionToDB()){
			String query = "SELECT + FROM " + TCHICKEN;
			PreparedStatement preparedStatement =  connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Chicken ck = new Chicken();
			}
			
			
		}catch(SQLException e) {
			
		}
		
		
		
		return chickens;
	}
	


	
	
}

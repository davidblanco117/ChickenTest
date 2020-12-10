package com.fblanco.chickentest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fblanco.chickentest.db.IDBConnection;
import static com.fblanco.chickentest.db.DataBase.*;

import primaryPackage.*;

public interface ChickenDao extends IDBConnection {

	default ArrayList<Chicken> readChickens(int idGranja) {
		ArrayList<Chicken> chickens = new ArrayList<Chicken>();

		try (Connection connection = connectionToDB()) {
			String query = "SELECT * FROM " + TCHICKEN + " WHERE " + TCHICKEN_ID_GRANJA + " = " + idGranja ;
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Chicken ck = new Chicken(Double.valueOf(rs.getString("precio")),
						Integer.valueOf(rs.getString("dias_de_vida")), Integer.valueOf(rs.getString("id_granja")));
				ck.setDaysToPutAnEgg(Integer.valueOf(rs.getString(TCHICKEN_DIAS_HASTA_PROXIMOS_HUEVOS)));
				chickens.add(ck);
			}

		} catch (SQLException e) {
			System.out.println("Error en la conexion");
			e.printStackTrace();
		}
		return chickens;
	}

	default boolean insertChicken(Chicken chicken) {

		try (Connection connection = connectionToDB()) {
			Statement statement = connection.createStatement();

			String query = "INSERT INTO " + TCHICKEN + "( " + TCHICKEN_DIAS_DE_VIDA + ", " + TCHICKEN_PRECIO + ", " +
					TEGGS_ID_GRANJA + "," + TCHICKEN_DIAS_HASTA_PROXIMOS_HUEVOS + ")" + " VALUES(0," + chicken.getPrice() + ", " +
					chicken.getIdGranja() + ", " +  chicken.getDaysToPutAnEgg() + ")";

			statement.executeUpdate(query);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return false;
	}
	
	
	default boolean updateChickensNewDay(Farm farm) {
		
		
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	default boolean deleteChicken(int cant, int idGranja) {

		try (Connection connection = connectionToDB()) {
			Statement statement = connection.createStatement();

			String query = "DELETE FROM " + TCHICKEN +  " WHERE "+ TCHICKEN_ID_GRANJA +" = " + idGranja +" LIMIT " + cant ;
			System.out.println(query);
			statement.executeUpdate(query);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return false;
	}

}

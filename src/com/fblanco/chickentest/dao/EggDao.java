package com.fblanco.chickentest.dao;

import static com.fblanco.chickentest.db.DataBase.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fblanco.chickentest.db.IDBConnection;

import primaryPackage.Egg;

public interface EggDao extends IDBConnection {

	default ArrayList<Egg> readEggs(int idGranja) {
		ArrayList<Egg> eggs = new ArrayList<Egg>();

		try (Connection connection = connectionToDB()) {
			String query = "SELECT * FROM " + TEGGS + " WHERE " + TEGGS_ID_GRANJA + " = " + idGranja;
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Egg egg = new Egg();
				eggs.add(egg);
			}

		} catch (SQLException e) {
			System.out.println("Error en la conexion");
			e.printStackTrace();
		}
		return eggs;
	}

	default boolean insertEgg(Egg egg) {

		try (Connection connection = connectionToDB()) {
			Statement statement = connection.createStatement();

			String query = "INSERT INTO " + TEGGS + "( " + TEGGS_DIAS_DE_VIDA + ", " + TEGGS_PRECIO + ", "
					+ TEGGS_ID_GRANJA + ")" + " VALUES(1," + egg.getPrice() + ", " + egg.getIdGranja() + ")";
			System.out.println(query);
			statement.executeUpdate(query);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return false;
	}

	default boolean deleteEggs(int cant, int idGranja) {

		try (Connection connection = connectionToDB()) {
			Statement statement = connection.createStatement();

			String query = "DELETE FROM " + TEGGS + " WHERE " + TEGGS_ID_GRANJA + " = " + idGranja + " LIMIT " + cant;
			System.out.println(query);
			statement.executeUpdate(query);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return false;
	}
}

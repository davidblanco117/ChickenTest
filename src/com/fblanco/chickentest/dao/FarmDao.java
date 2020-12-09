package com.fblanco.chickentest.dao;

import static com.fblanco.chickentest.db.DataBase.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.fblanco.chickentest.db.IDBConnection;

import primaryPackage.Farm;

public interface FarmDao extends IDBConnection {

	default Farm validateUserPass(String user, String pass) {

		try (Connection connection = connectionToDB()) {
			String query = "SELECT * FROM " + TFARM + " WHERE " + TFARM_USUARIO + " = " + "\"" + user + "\"" + " AND "
					+ TFARM_PASS + " = " + "\"" + pass + "\"";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				Farm farm = new Farm(Integer.valueOf(rs.getString("id_granja")),
						Double.valueOf(rs.getString("dinero")));
				return farm;
			}

		} catch (SQLException e) {
			System.out.println("Error en la conexion");
			e.printStackTrace();
		}

		return null;
	}

	default Farm readFarm(String user, String pass) {

		Farm farm = null;
		try (Connection connection = connectionToDB()) {
			String query = "SELECT * FROM " + TFARM + " WHERE " + TFARM_USUARIO + " = " + "\"" + user + "\"" + " AND "
					+ TFARM_PASS + " = " + "\"" + pass + "\"";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				farm = new Farm(Integer.valueOf(rs.getString(TFARM_ID_GRANJA)),
						Double.valueOf(rs.getString(TFARM_DINERO)));
				return farm;
			}

		} catch (SQLException e) {
			System.out.println("Error en la conexion");
			e.printStackTrace();
		}
		return null;

	}

	default boolean validateUser(String user) {

		try (Connection connection = connectionToDB()) {
			String query = "SELECT * FROM " + TFARM + " WHERE " + TFARM_USUARIO + " = " + "\"" + user + "\"";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			System.out.println("Error en la conexion");
			e.printStackTrace();
		}

		return false;
	}

	default void insertNewUser(Farm farm, String user, String pass) {

		try (Connection connection = connectionToDB()) {
			Statement statement = connection.createStatement();

			String query = "INSERT INTO " + TFARM + "( " + TFARM_DINERO + ", " + TFARM_USUARIO + ", " + TFARM_PASS + ")"
					+ " VALUES(" + farm.getMoney() + ", \"" + user + "\", \"" + pass + "\")";
			statement.executeUpdate(query);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}

	default void updateNewDay(Farm farm) {
		try (Connection connection = connectionToDB()) {
			Statement statement = connection.createStatement();
			String query = "UPDATE " + TPARAMETROS + " SET " + TPARAMETROS_DIA + " = " + farm.getDay() + 1;

			System.out.println(query);
			statement.executeUpdate(query);
			query = "UPDATE " + TCHICKEN + " SET " + TCHICKEN_DIAS_DE_VIDA + " = " + TCHICKEN_DIAS_DE_VIDA
					+ " + 1 ";

			System.out.println(query);
			statement.executeUpdate(query);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	default void updateMoney(Farm farm, double money) {
		try (Connection connection = connectionToDB()) {
			Statement statement = connection.createStatement();

			String query = "UPDATE " + TFARM + " SET " + TFARM_DINERO + " = " + money + " WHERE " + TFARM_ID_GRANJA
					+ " = " + farm.getId();
			statement.executeUpdate(query);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}

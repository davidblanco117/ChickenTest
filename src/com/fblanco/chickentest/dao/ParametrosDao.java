package com.fblanco.chickentest.dao;

import static com.fblanco.chickentest.db.DataBase.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fblanco.chickentest.db.IDBConnection;

import primaryPackage.Parametros;

public interface ParametrosDao extends IDBConnection {

	default Parametros readParams() {
		Parametros param = null;
		try (Connection connection = connectionToDB()) {
			String query = "SELECT * FROM " + TPARAMETROS + " LIMIT 1";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				param = new Parametros(Integer.valueOf(rs.getString(TPARAMETROS_DIA)),
						Double.valueOf(rs.getString(TPARAMETROS_PRECIO_POLLOS)),
						Double.valueOf(rs.getString(TPARAMETROS_PRECIO_HUEVOS)),
						Integer.valueOf(rs.getString(TPARAMETROS_CANT_DIAS_VIDA_POLLO)),
						Integer.valueOf(rs.getString(TPARAMETROS_CANT_DIAS_PONER_HUEVOS)),
						Integer.valueOf(rs.getString(TPARAMETROS_CANT_HUEVOS_DE_UN_POLLO)),
						Integer.valueOf(rs.getString(TPARAMETROS_CANT_DIAS_ECLOSIONAR_HUEVOS)),
						Integer.valueOf(rs.getString(TPARAMETROS_ID)));
			}

		} catch (SQLException e) {
			System.out.println("Error en la conexion");
			e.printStackTrace();
		}
		return param;
	}

}

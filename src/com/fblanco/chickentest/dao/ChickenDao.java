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

	default ArrayList<Chicken> readChickens() {
		ArrayList<Chicken> chickens = new ArrayList<Chicken>();

		try (Connection connection = connectionToDB()) {
			String query = "SELECT * FROM " + TCHICKEN;
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Chicken ck = new Chicken(Double.valueOf(rs.getString("precio")),
						Integer.valueOf(rs.getString("dias_de_vida")), Integer.valueOf(rs.getString("id_granja")));
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

			String query = "INSERT INTO " + TCHICKEN + "( " + TCHICKEN_DIAS_DE_VIDA + ", " + TCHICKEN_PRECIO + ", "
					+ TEGGS_ID_GRANJA + ")" + " VALUES(1," + chicken.getPrice() + ", " + chicken.getIdGranja() + ")";
			System.out.println(query);
			statement.executeUpdate(query);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return false;
	}

	default boolean saveChickensInDB(ArrayList<Chicken> chickens) {

		try (Connection connection = connectionToDB()) {
			Statement statement = connection.createStatement();

			for (Chicken chicken : chickens) {

				String query = "INSERT INTO " + TCHICKEN + "( " + TCHICKEN_DIAS_DE_VIDA + ", " + TCHICKEN_PRECIO + ", "
						+ TEGGS_ID_GRANJA + ")" + " VALUES(1," + chicken.getPrice() + ", " + chicken.getIdGranja()
						+ ")";
				System.out.println(query);
				statement.executeUpdate(query);

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return false;
	}

}

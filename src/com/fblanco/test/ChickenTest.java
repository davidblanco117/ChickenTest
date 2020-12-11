package com.fblanco.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;

import com.fblanco.chickentest.db.IDBConnection;

import primaryPackage.Chicken;
import primaryPackage.Parametros;
import static com.fblanco.chickentest.db.DataBase.*;

public class ChickenTest implements IDBConnection {

	Chicken chicken;
	Parametros params;
	

	
	
	
	@Before
	public void prepararDato() {


		/*
		 *                  PARAMETROS UTILIZADOS
		 * 
		 * 	DIA INICIAL ---> 0 
		 *  PRECIO POLLOS ---> 100
		 *  PRECIO HUEVOS ---> 30
		 *  CANT DIAS VIDA POLLO ---> 5
		 *  CANT DIAS PONER HUEVOS ---> 2
		 *  CANT HUEVOS QUE PONE UN POLLO ---> 3
		 *  CANT DIAS ECLOSIONAR HUEVOS ---> 5 
		 * 
		 * 
		 * 		SE SETEA EN TRUE LA VARIABLE MODOTESTING, QUE PERMITE UTILIZAR UNA BASE DE DATOS DE PRUEBA EN LUGAR DE LA REAL
		 * 
		 */
		
		
		try (Connection connection = connectionToDB()) {
			Statement statement = connection.createStatement();

			String query = "DELETE FROM " + TPARAMETROS;
			statement.executeUpdate(query);
			query = "INSERT INTO " + TPARAMETROS + "( " + TPARAMETROS_DIA + ", " + TPARAMETROS_PRECIO_POLLOS + ", " +
					TPARAMETROS_PRECIO_HUEVOS + "," + TPARAMETROS_CANT_DIAS_VIDA_POLLO+ "," + TPARAMETROS_CANT_DIAS_PONER_HUEVOS
					+ "," + TPARAMETROS_CANT_HUEVOS_DE_UN_POLLO
					+ "," + TPARAMETROS_CANT_DIAS_ECLOSIONAR_HUEVOS+ "," + TPARAMETROS_ID
					+ ")" + " VALUES(0,100,30,5,2,3,5,1)";
			statement.executeUpdate(query);
			

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		params = new Parametros();
		Parametros.modoTesting=true;
		
		chicken = new Chicken(1);
	}
	
	
	
	@Test
	public void testGetIdGranja() {
		// Prueba del metodo getId(), el constructor de chicken en el parrafo Before asigna 1 como idGranja
		assertEquals(1, chicken.getIdGranja());
		
		
	}
	
	
	@Test
	public void getDaysToPutAnEgg() {
		//Prueba del metodo getDaysToPutAnEgg, debe coincidir con el valor en la tabla de parametros
		assertEquals(2, chicken.getDaysToPutAnEgg());
	}
	
	
	@Test
	public void setDaysToPutAnEgg() {
		//Prueba del metodo setDaysToPutAnEgg, el valor del set debe coincidir con el regresado en el get
		chicken.setDaysToPutAnEgg(7);
		assertEquals(7, chicken.getDaysToPutAnEgg());
	}
	

} 

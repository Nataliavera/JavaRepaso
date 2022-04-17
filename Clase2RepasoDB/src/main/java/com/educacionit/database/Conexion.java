package com.educacionit.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

	static String db = "dbprueba";//NOMBRE DE MI DB
	static String login = "root";
	static String password = "";
	static String url = "jdbc:mysql://localhost/" + db;
	
//	*ODO EN JAVA ES UN OBJETO 
	Connection conn = null;

	public Conexion() {
		try {
//		OBTENEMOS EL DRIVER PARA MYSQL
//		Class.forName("")
			
//		OBTENEMOS LA CONEXION 
			conn = DriverManager.getConnection(url, login, password);
			if(conn != null) {
				System.out.println("Se conectó a la base de datos "+db);
			}
		} catch (SQLException e) {
			System.out.println("SQLException");
			e.printStackTrace();
		}
//		catch (ClassNotFoundException e) {
//			System.out.println("ClassNotFoundException");
//			e.printStackTrace();
//		}
	catch (Exception e) {
			System.out.println("Exceptionn");
			e.printStackTrace();
		}
	
	} 

	public Connection  getConnection() {
		return conn ;
	}
}

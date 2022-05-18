package it.sp.job.inv.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	private static Connection conn = null;
	//private static final String DbDriver = "easysoft.sql.esMdbDriver";	

	/*---------------------------------------------LOCALHOST CONNECTION-----------------------------------------------------*/
	
	private static final String DbURL = "jdbc:ucanaccess://C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\inventario.accdb";
	private static final String username = "";
	private static final String password = "";
	
	/*
	private static final String DbURL = "jdbc:easysoft:mdb?DBQ=C://Users//samue//Desktop//inventario.accdb";
	private static final String username = "";
	private static final String password = "";
	*/

	private DBManager() {}

	/**
	 * Metododo che restituisce true se la connessione è aperta.
	 */
	public static boolean isOpen() {
		// if (conn == null)
		// return false;
		// else
		// return true;
		return (conn != null);
	}

	public static Connection startConnection() {
		if (isOpen())
			return conn;
		try {
			//Class.forName(DbDriver);// Carica il Driver del DBMS
			conn = DriverManager.getConnection(DbURL, username, password);// Apertura connessione
		} catch (Exception e) {
			String s = e.toString();
			System.out.println(s);
			if(s.contains("file does not exist"))
				System.out.println("Manca il DB");
			return null;
		}
		return conn;
	}
	
	public static boolean closeConnection() {
		if (!isOpen())
			return true;
		try {
			conn.close();
			conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
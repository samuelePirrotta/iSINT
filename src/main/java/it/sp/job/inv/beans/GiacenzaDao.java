package it.sp.job.inv.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import it.sp.job.inv.utils.DBManager;

public class GiacenzaDao {
	private static Connection conn;
	
	public Vector<Giacenza> getAll() {
		String query = "SELECT * FROM giacenza";
		conn = DBManager.startConnection();
		Giacenza res = null;
		Vector<Giacenza> result = new Vector<Giacenza>();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				res = new Giacenza();
				res.setArticolo(rs.getString("codice"));
				res.setGiacenza(rs.getDouble("giacenza"));
				res.setDeposito(rs.getString("deposito"));
				result.add(res);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return result;
	}
	
	public Vector<Giacenza> get(String codice) {
		String query = "SELECT * FROM giacenza WHERE codice=?";
		conn = DBManager.startConnection();
		Giacenza res = null;
		Vector<Giacenza> result = new Vector<Giacenza>();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, codice);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				res = new Giacenza();
				res.setArticolo(rs.getString("codice"));
				res.setGiacenza(rs.getDouble("giacenza"));
				res.setDeposito(rs.getString("deposito"));
				result.add(res);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return result;
	}
	
	public boolean save(Giacenza g) {
		String query = "INSERT INTO giacenza (codice, giacenza, deposito) VALUES (?, ?, ?)";
		conn = DBManager.startConnection();
		boolean esito = false;
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, g.getArticolo());
			ps.setDouble(2, g.getGiacenza());
			ps.setString(3, g.getDeposito());
			int tmp = ps.executeUpdate();
			if(tmp == 1) {
				esito = true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}
}

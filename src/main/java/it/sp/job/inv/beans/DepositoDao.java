package it.sp.job.inv.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import it.sp.job.inv.utils.DBManager;

public class DepositoDao {
	
	private static Connection conn;
	
	public Vector<Deposito> getAll() {
		Vector<Deposito> result = new Vector<Deposito>();
		Deposito res = null;
		conn = DBManager.startConnection();
		try {
			String query = "SELECT * FROM deposito";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				res = new Deposito();
				res.setId(rs.getInt("id"));
				res.setNome(rs.getString("nome"));
				result.add(res);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return result;
	}
}

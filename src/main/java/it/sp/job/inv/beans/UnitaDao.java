package it.sp.job.inv.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import it.sp.job.inv.utils.DBManager;

public class UnitaDao {
	
	private static Connection conn;
	
	public Vector<Unita> get() {
		Vector<Unita> result = new Vector<Unita>();
		Unita res = null;
		conn = DBManager.startConnection();
		try {
			String query = "SELECT * FROM unita_di_misura";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				res = new Unita();
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

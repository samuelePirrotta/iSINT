package it.sp.job.inv.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Vector;

import it.sp.job.inv.utils.DBManager;

public class RecordDao {
	private Connection conn;
	
	public Record cerca(String codice) {
		String query = "SELECT * FROM articolo WHERE codice=?";
		conn = DBManager.startConnection();
		Record res = null;
		try {
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, codice);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				res = new Record();
				res.setArticolo(rs.getString("codice"));
				res.setEan(rs.getString("ean"));
				res.setDescrizione(rs.getString("descrizione"));
				res.setUnita(rs.getString("unita"));
				res.setNuovo(rs.getInt("nuovo"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}
	
	public Vector<Record> get(Record art) {
		String query = "SELECT * FROM articolo WHERE 1=1";
		conn = DBManager.startConnection();
		Record res = null;
		Vector<Record> result = new Vector<Record>();
		/* Creo l'HashMap nel modo più generico possibile, utilizzando String per la chiave che riporta il nome dell'attributo della tabella
		 * del DB e come valore un generico Object 
		 */
		HashMap<String, Object> hm = new HashMap<String, Object>();
		// Setto tutti i possibili campi dell'HashMap
		hm.put("codice", art.getArticolo());
		hm.put("descrizione", art.getDescrizione());
		hm.put("ean", art.getEan());
		// questo contatore conta quanti parametri sono presenti all'interno della query
		int cont = 1;
		// Scorro l'HashMap e se il valore cossispondente ad un elemento non è nullo aggiungo il parametro alla query
		for(Entry<String, Object> e: hm.entrySet()) {			
			if(e.getValue() != null) {
				if(e.getKey().equals("descrizione") || e.getKey().equals("codice")) {
					query += " AND "+e.getKey()+" LIKE ?";
				}
				else {
					query += " AND "+e.getKey()+"=?";
				}
			}	
		}
		/* Preparo lo statement di SQL, scorro l'HashMap e se il valore contenuto in un elemento non è nullo lo setto come valore del suo
		 * corrispondente parametro
		 */
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			for(Entry<String, Object> e: hm.entrySet()) {
				if(e.getValue() != null) {
					if(e.getKey().equals("descrizione") || e.getKey().equals("codice")) {
						String s = "%"+e.getValue()+"%";
						ps.setString(cont, s);
					}
					else
						ps.setObject(cont, e.getValue());
					cont++;
				}
			}
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				res = new Record();
				res.setArticolo(rs.getString("codice"));
				res.setEan(rs.getString("ean"));
				res.setDescrizione(rs.getString("descrizione"));
				res.setUnita(rs.getString("unita"));
				res.setNuovo(rs.getInt("nuovo"));
				result.add(res);			
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return result;	
	}
	
	public boolean save(Record art) {
		String query = "INSERT INTO articolo (ean, codice, descrizione, nuovo, unita) VALUES (?, ?, ?, ?, ?)";
		boolean esito = false;
		conn = DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, art.getEan());
			ps.setString(2, art.getArticolo());
			ps.setString(3, art.getDescrizione());
			ps.setInt(4, art.getNuovo());
			ps.setString(5, art.getUnita());
			int tmp = ps.executeUpdate();
			if (tmp == 1) {
				esito = true;
			}	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}
	
	public boolean update(Record art) {
		String query = "UPDATE articolo SET ean=?, unita=? WHERE codice=?";
		boolean esito = false;
		conn = DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(3, art.getArticolo());
			ps.setString(1, art.getEan());
			ps.setString(2, art.getUnita());
			int tmp = ps.executeUpdate();
			if (tmp == 1) {
				esito = true;				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}
}

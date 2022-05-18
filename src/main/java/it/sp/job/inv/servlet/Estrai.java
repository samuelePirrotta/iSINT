package it.sp.job.inv.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.sp.job.inv.beans.Giacenza;
import it.sp.job.inv.beans.GiacenzaDao;
import it.sp.job.inv.beans.Record;
import it.sp.job.inv.beans.RecordDao;
import it.sp.job.inv.utils.ExcelConvert;
import jxl.write.WriteException;

/**
 * Servlet implementation class Estrai
 */
@WebServlet("/Estrai")
public class Estrai extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Estrai() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Acquisisco i dati dei soli articoli che hanno giacenza
		RecordDao aDao = new RecordDao();
		
		Vector<Record> vendita = new Vector<Record>();
		Vector<Record> rotture = new Vector<Record>();
		Vector<Record> usoInterno = new Vector<Record>();
		Vector<Record> svalorizzazione = new Vector<Record>();
		Vector<Record> contoVendita = new Vector<Record>();
				
		GiacenzaDao gDao = new GiacenzaDao();
		Vector<Giacenza> giacenze = gDao.getAll();
		for(Giacenza g: giacenze) {
			Record art = aDao.cerca(g.getArticolo());
			art.setDeposito(g.getDeposito());
			art.setGiacenza(g.getGiacenza());
			if(g.getDeposito().equals("Vendita"))
				vendita.add(art);
			else if(g.getDeposito().equals("Rotture"))
				rotture.add(art);
			else if(g.getDeposito().equals("Uso Interno"))
				usoInterno.add(art);
			else if(g.getDeposito().equals("Svalorizzazione"))
				svalorizzazione.add(art);
			else if(g.getDeposito().equals("Conto Vendita"))
				contoVendita.add(art);
		}
		
		Object[] dati = {vendita, rotture, usoInterno, svalorizzazione, contoVendita};
				
		//Scrivo sul foglio excel
		String[] columnData = {"Ean", "Codice Articolo", "Descrizione", "Giacenza Rilevata", "Unità di Misura", "Deposito", "Articolo Nuovo"};
		ExcelConvert ex = new ExcelConvert();
		//String username = System.getProperty("user.name");
		String position;
		position = "C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\Estrazione.xls";
		/*
		if(username.equals("Samuele"))
			position = "C:\\Users\\samue\\Desktop\\Estrazione.xls";
		else
			position = "C:\\Users\\"+username+"\\Desktop\\Estrazione.xls";*/
		try {				
			ex.create(position, columnData, dati);					
		} catch (WriteException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		response.sendRedirect("/fileEstratto.html");
	}
}
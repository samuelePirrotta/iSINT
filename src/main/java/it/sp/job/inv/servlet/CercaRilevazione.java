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

/**
 * Servlet implementation class CercaRilevazione
 */
@WebServlet("/CercaRilevazione")
public class CercaRilevazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CercaRilevazione() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String c = request.getParameter("codice");
		String d = request.getParameter("descrizione");
		String e = request.getParameter("ean");

		Record a = new Record();
		
		if(c != "")
			a.setArticolo(c);
		if(d != "")
			a.setDescrizione(d);
		if(e != "")
			a.setEan(e);
		
		RecordDao aDao = new RecordDao();
		Vector<Record> art = aDao.get(a);		
		
		/*GiacenzaDao gDao = new GiacenzaDao();
		Vector<Giacenza> giacenze = gDao.getAll();
		
		Vector<Record> articoli = new Vector<Record>(); 
		
		for(Giacenza g: giacenze) {
			for(Record r: record) {
				if(g.getArticolo().equals(r.getArticolo())) {
					r.setGiacenza(g.getGiacenza());
					r.setDeposito(g.getDeposito());
					articoli.add(r);
				}
			}
		}*/
		
		
		Vector<Record> articoli = new Vector<Record>();
		Vector<Giacenza> giace = new Vector<Giacenza>();
		GiacenzaDao gDao = new GiacenzaDao();
		Record item = null;
		for(Record r: art) {
			giace = gDao.get(r.getArticolo());
			for(Giacenza g: giace) {
				item = new Record();
				item.setArticolo(r.getArticolo());
				item.setDescrizione(r.getDescrizione());
				item.setEan(r.getEan());
				item.setGiacenza(g.getGiacenza());
				item.setDeposito(g.getDeposito());
				articoli.add(item);
			}
		}
		
		request.setAttribute("articoli", articoli);
		request.getRequestDispatcher("/anagrafica/rilevazioni.jsp").forward(request, response);	
	}
}
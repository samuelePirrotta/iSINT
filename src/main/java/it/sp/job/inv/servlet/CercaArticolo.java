package it.sp.job.inv.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.sp.job.inv.beans.Record;
import it.sp.job.inv.beans.RecordDao;

/**
 * Servlet implementation class CercaArticolo
 */
@WebServlet("/CercaArticolo")
public class CercaArticolo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CercaArticolo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
		Vector<Record> articoli = aDao.get(a);
		for(Record b: articoli) {
			if(b.getEan() == null) {
				b.setEan("");			
			}
		}
		
		request.setAttribute("articoli", articoli);
		request.getRequestDispatcher("/anagrafica/CercaArticolo.jsp").forward(request, response);	
		
	}
}
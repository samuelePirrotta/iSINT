package it.sp.job.inv.servlet;

import java.io.IOException;
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
 * Servlet implementation class ModificaArticolo
 */
@WebServlet("/ModificaArticolo")
public class ModificaArticolo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaArticolo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean esito1 = false;
		boolean esito2 = false;
		
		String codice = request.getParameter("codice");
		Double giacenza =  Double.parseDouble(request.getParameter("giacenza"));
		String ean = request.getParameter("ean");
		String unita = request.getParameter("unita");
		String deposito = request.getParameter("deposito");
		
		Giacenza g = new Giacenza(); 
		g.setArticolo(codice);
		g.setGiacenza(giacenza);
		g.setDeposito(deposito);
		
		Record r = new Record();
		r.setArticolo(codice);
		r.setEan(ean);
		r.setUnita(unita);
		
		if(giacenza > 0) {
			GiacenzaDao gDao = new GiacenzaDao();
			esito1 = gDao.save(g);
		}
		
		RecordDao rDao = new RecordDao();
		if(rDao.update(r)) {
			esito1 = true;
			esito2 = true;
		}
		
		request.setAttribute("codice", codice);
		
		if(esito1 && esito2)
			response.sendRedirect("/RichiediCercaArticolo");
		else 
			response.sendRedirect("/erroreGenerico.html");	
	}
}
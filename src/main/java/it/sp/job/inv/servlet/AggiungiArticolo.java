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
 * Servlet implementation class AggiungiArticolo
 */
@WebServlet("/AggiungiArticolo")
public class AggiungiArticolo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiArticolo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codice = request.getParameter("codice");
		String descrizione = request.getParameter("descrizione");
		String ean = request.getParameter("ean");
		Double giacenza = Double.parseDouble(request.getParameter("giacenza"));
		String unita = request.getParameter("unita");
		String deposito = request.getParameter("deposito");
		
		Record a = new Record();
		a.setArticolo(codice);
		a.setDescrizione(descrizione);
		a.setEan(ean);
		a.setNuovo(1);
		a.setUnita(unita);
		
		Giacenza g = new Giacenza();
		g.setArticolo(codice);
		g.setGiacenza(giacenza);
		g.setDeposito(deposito);
		
		RecordDao aDao = new RecordDao();
		boolean esito1 = aDao.save(a);
		
		boolean esito2 = false;
		
		if(esito1) {
			if(giacenza > 0) {
				GiacenzaDao gDao = new GiacenzaDao();
				esito2 = gDao.save(g);
			}
			else {
				esito2 = true;
			}
			
			if(esito2) {
				response.sendRedirect("/errori/articoloSalvato.html");
			}
			else 
				response.sendRedirect("/erroreGenerico.html");
		}
	}
}
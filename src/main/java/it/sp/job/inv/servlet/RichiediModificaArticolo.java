package it.sp.job.inv.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.sp.job.inv.beans.Deposito;
import it.sp.job.inv.beans.DepositoDao;
import it.sp.job.inv.beans.Record;
import it.sp.job.inv.beans.RecordDao;
import it.sp.job.inv.beans.Unita;
import it.sp.job.inv.beans.UnitaDao;

/**
 * Servlet implementation class RichiediModificaArticolo
 */
@WebServlet("/RichiediModificaArticolo")
public class RichiediModificaArticolo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RichiediModificaArticolo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codice = request.getParameter("codice");
		
		RecordDao aDao = new RecordDao();
		Record a = aDao.cerca(codice);
		if(a.getEan() == null)
			a.setEan("");
		
		UnitaDao uDao = new UnitaDao();
		Vector<Unita> unita = uDao.get();
		
		DepositoDao dDao = new DepositoDao();
		Vector<Deposito> depositi = dDao.getAll();
		
		request.setAttribute("articolo", a);
		request.setAttribute("unita", unita);
		request.setAttribute("depositi", depositi);
		
		request.getRequestDispatcher("/anagrafica/modificaArticolo.jsp").forward(request, response);
	}
}
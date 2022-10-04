package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.CreditMetierImpl;
import metier.ICreditMetier;


@WebServlet(name="cs", urlPatterns={"/controleurServlet","*.do"})
public class ControleurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICreditMetier metier;
	
	@Override
	public void init() throws ServletException{
		metier = new CreditMetierImpl();
	}
   
    public ControleurServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("creditModel", new CreditModel());
		request.getRequestDispatcher("VueCredit.jsp").forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Lire les donnees de la requete
		 */
		
		double montant = Double.parseDouble(request.getParameter("montant"));
		double taux = Double.parseDouble(request.getParameter("taux"));
		int duree = Integer.parseInt(request.getParameter("duree"));
		
		/*
		 * Valider les donnees de la requete
		 */
		/*
		 * Stocker les donnees saisies dans le model
		 */
		CreditModel model = new CreditModel();
		model.setMontant(montant);
		model.setTaux(taux);
		model.setDuree(duree);
		/*
		 * Faire appel à la couche metier pour effectuer les traitements
		 */
		double res = metier.calculMensualiteCredit(montant, taux, duree);
		/*
		 * Stocker le resultat dans le model
		 */
		model.setMensualite(res);
		/*
		 * Stocker le modele dans l'objet request
		 */
		request.setAttribute("creditModel", model);
		/*
		 * Faire un forward (redirection) vers la vue jsp
		 */
		request.getRequestDispatcher("VueCredit.jsp").forward(request, response);
		//doGet(request, response);
	}

}

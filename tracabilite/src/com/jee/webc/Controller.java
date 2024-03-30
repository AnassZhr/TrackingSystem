package com.jee.webc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jee.business.DefaultManager;
import com.jee.business.Manager;
import com.jee.dao.DataSource;
import com.jee.dao.Database;
import com.jee.dao.DossierDao;
import com.jee.dao.DossierDaoJdbc;
import com.jee.dao.MySqlDataSource;
import com.jee.dao.*;

import com.jee.dao.DossierDaoMemory;
import com.jee.web.actions.AdminActions;
import com.jee.web.actions.ClientActions;
import com.jee.web.actions.DossierActions;
import com.jee.web.actions.EmployeActions;
import com.jee.web.actions.PersonneActions;
import com.jee.web.actions.SuperAdminActions;
import com.jee.web.actions.TacheActions;

/**
 * Servlet implementation class ControllerMod
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DossierActions dossierActions;
	private TacheActions tacheActions;
	private PersonneActions personneActions;
	private EmployeActions employeActions;
	private ClientActions clientActions;
	private AdminActions adminActions;
	private SuperAdminActions superAdminActions;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
   
        DataSource ds = new MySqlDataSource("tracabilite");
		Database db = new Database(ds);
		
		DossierDao dossierDao = new DossierDaoJdbc(db);
		TacheDao tacheDao = new TacheDaoJdbc(db);
		PersonneDao personneDao = new PersonneDaoJdbc(db);
		EmployeDao employeDao = new EmployeDaoJdbc(db);
		ClientDao clientDao = new ClientDaoJdbc(db);
		AdminDao adminDao = new AdminDaoJdbc(db);
		SuperAdminDao superAdminDao = new SuperAdminDaoJdbc(db);
		
		Manager Manager = new DefaultManager(dossierDao);
		
		Manager.setTacheDao(tacheDao);
		Manager.setDossierDao(dossierDao);
		Manager.setEmployeDao(employeDao);
		Manager.setPersonneDao(personneDao);
		Manager.setClientDao(clientDao);
		Manager.setAdminDao(adminDao);
		Manager.setSuperAdminDao(superAdminDao);
	
		tacheActions = new TacheActions(Manager);
		
	
		
		personneActions = new PersonneActions(Manager); 
		
		
	
		employeActions = new EmployeActions(Manager); 
		
		dossierActions = new DossierActions(Manager);
		
		clientActions = new ClientActions(Manager);
		
		adminActions = new AdminActions(Manager);
		
		superAdminActions = new SuperAdminActions(Manager);
		
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		System.out.println("tata");
		 /*
		  * http://localhost:8080/cc/NouveauProduit.do   :URL
		  */
		 /*
		  * /cc/NouveauProduit.do   :URI
		  */
		System.out.println("> Controller :uri "+uri);
		int i = uri.lastIndexOf('/') + 1;
		System.out.println("i="+i);
		int j = uri.lastIndexOf('.');
		System.out.println("j="+j);
		String key = uri.substring(i, j);
		System.out.println("> Controller : " + key);
		String view = "/views/error.jsp";
		if (key.equals("NouveauDossier")) {
			view = dossierActions.add(request);
		}
		else if (key.equals("ChercherDossier")) {
			view = dossierActions.get(request);
		}
		else if (key.equals("ListeDeDossier")) {
			view = dossierActions.list(request);
		}else if(key.equals("SupprimerDossier")) {
			view = dossierActions.delete(request);
		}else if(key.equals("rechercheModifierDossier")) {
			view=dossierActions.RechercheModifier(request);
		}else if(key.equals("validerModifierDossier")) {
			view=dossierActions.validerModifier(request);
		}else if(key.equals("PreChercherDossier")) {
			view=dossierActions.PreChercherDossier(request);
	    }else if(key.equals("PreAjoutDossier")) {
			view=dossierActions.PreAjoutDossier(request);
	    }
	    else if(key.equals("PreModifierDossier")) {
			view=dossierActions.PreModifierDossier(request);
	    }
		
	    else if(key.equals("ConsulterDossier")) {
			view=dossierActions.ConsulterDossier(request);
	    }
		
		else if (key.equals("NouvelleTache")) {
			view = tacheActions.add(request);
		}else if (key.equals("NouvelleTache2")) {
			view = tacheActions.add2(request);
		}
		else if (key.equals("ChercherTache")) {
			view = tacheActions.get(request);
		}
		else if (key.equals("ListeDeTache")) {
			view = tacheActions.list(request);
		}else if(key.equals("SupprimerTache")) {
			view = tacheActions.delete(request);
		}else if(key.equals("RechercheModifierTache")) {
			view=tacheActions.RechercheModifierTache(request);
		}else if(key.equals("validerModifierTache")) {
			view=tacheActions.validerModifierTache(request);
		}else if(key.equals("PreChercherTache")) {
			view=tacheActions.PreChercherTache(request);
		}else if(key.equals("PreAjoutTache")) {
			view=tacheActions.PreAjoutTache(request);
	    }else if(key.equals("tachesParDossier")) {
			view=tacheActions.TacheDossier(request);
			
	    }else if(key.equals("preAjoutTache2")) {
			view=tacheActions.PreAjoutTache2(request);
	    }
	    else if(key.equals("tachesParEmploye")) {
			view=tacheActions.TacheEmploye(request);
			
	    }else if(key.equals("validerTache")) {
			view=tacheActions.validerTache(request);
			
	    }else if(key.equals("SupprimerTacheDossier")) {
			view = tacheActions.delete2(request);
		}else if(key.equals("tachesParEmploye2")) {
			view=tacheActions.TacheEmploye2(request);
			
	    }
		else if(key.equals("tachesValider")) {
			view=tacheActions.TacheValider(request);
			
	    }
		
		
		else if (key.equals("NouvellePersonne")) {
			view = personneActions.add(request);
		}
		else if (key.equals("ChercherPersonne")) {
			view = personneActions.get(request);
		}
		else if (key.equals("ListeDePersonne")) {
			view = personneActions.list(request);
		}else if(key.equals("SupprimerPersonne")) {
			view = personneActions.delete(request);
		}else if(key.equals("rechercheModifier")) {
			view= personneActions.RechercheModifier(request);
		}else if(key.equals("validerModifier")) {
			view=personneActions.validerModifier(request);
		}else if(key.equals("PreChercherPersonne")) {
			view=personneActions.PreChercherPersonne(request);
		}
		
		else if (key.equals("NouvelleEmploye")) {
			view = employeActions.add(request);
		}
		else if (key.equals("ChercherEmploye")) {
			view = employeActions.get(request);
		}
		else if (key.equals("ListeDesEmployes")) {
			view = employeActions.list(request);
		}else if(key.equals("SupprimerEmploye")) {
			view = employeActions.delete(request);
		}else if(key.equals("rechercheModifierEmploye")) {
			view= employeActions.RechercheModifier(request);
		}else if(key.equals("validerModifierEmploye")) {
			view=employeActions.validerModifier(request);
		}else if(key.equals("PreChercherEmploye")) {
			
			view=employeActions.PreChercherEmploye(request);
			
		}
		
		else if (key.equals("NouvelleClient")) {
			view = clientActions.add(request);
		}
		else if (key.equals("NouvelleClient2")) {
			view = clientActions.add2(request);
		}
		else if (key.equals("ChercherClient")) {
			view = clientActions.get(request);
		}
		else if (key.equals("ListeDesClient")) {
			view = clientActions.list(request);
		}else if(key.equals("SupprimerClient")) {
			view = clientActions.delete(request);
		}else if(key.equals("rechercheModifierClient")) {
			view= clientActions.RechercheModifier(request);
		}else if(key.equals("validerModifierClient")) {
			view=clientActions.validerModifier(request);
		}else if(key.equals("PreChercherClient")) {
			view=clientActions.PreChercherClient(request);
		}
		
		else if (key.equals("NouvelleAdmin")) {
			view = adminActions.add(request);
		}
		else if (key.equals("ChercherAdmin")) {
			view = adminActions.get(request);
		}
		else if (key.equals("ListeDesadmin")) {
			view = adminActions.list(request);
		}else if(key.equals("SupprimerAdmin")) {
			view = adminActions.delete(request);
		}else if(key.equals("rechercheModifierAdmin")) {
			view= adminActions.RechercheModifier(request);
		}else if(key.equals("validerModifierAdmin")) {
			view= adminActions.validerModifier(request);
		}else if(key.equals("PreChercherAdmin")) {
			view=adminActions.PreChercherAdmin(request);
		}
		
		else if (key.equals("NouveauSuperAdmin")) {
			view = superAdminActions.add(request);
		}
		else if (key.equals("ChercherSuperAdmin")) {
			view = superAdminActions.get(request);
		}
		else if (key.equals("ListeDesSuperAdmin")) {
			view = superAdminActions.list(request);
		}else if(key.equals("SupprimerSuperAdmin")) {
			view = superAdminActions.delete(request);
		}else if(key.equals("rechercheModifierSuperAdmin")) {
			view= superAdminActions.RechercheModifier(request);
		}else if(key.equals("validerModifierSuperAdmin")) {
			view= superAdminActions.validerModifier(request);
		}

		
		else if(key.equals("AuthentificationAdmin")) {
			view=adminActions.AuthentificationAdmin(request);
		}
		else if(key.equals("AuthentificationEmploye")) {
			view=employeActions.AuthentificationEmploye(request);
		}
		else if(key.equals("rechercherProbleme")) {
			view=tacheActions.rechercherProbleme(request);
		}else if(key.equals("validerProbleme")) {
			view=tacheActions.validerProbleme(request);
		}
		
		
		
		
		request.getServletContext().getRequestDispatcher(view).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

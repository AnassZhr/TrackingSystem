package com.jee.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.jee.business.Manager;

import mrtier.entities.client;
import mrtier.entities.dossier;
import mrtier.entities.employe;
import mrtier.entities.tache;

public class TacheActions {
	private Manager tacheManager;
	private tache Tache;

	public TacheActions() {};

	public TacheActions(Manager tacheManager) {
		super();
		this.tacheManager = tacheManager;
	}
	public void setTacheManager(Manager tacheManager) {
		this.tacheManager = tacheManager;
	}
	public String add(HttpServletRequest request) {
		System.out.println("> Action ajouter()");
		
		Tache = new tache();
		Tache.setId(0);
		Tache.setObjet(request.getParameter("Objet"));
		Tache.setDescription(request.getParameter("description"));
		Tache.setEtat("non traiter");
		Tache.setOrdre(Integer.parseInt(request.getParameter("ordre")));
		Tache.setProbleme(request.getParameter("probleme"));
		Tache.setDecrpt_prob(request.getParameter("dcrpt_prob"));
		Tache.setId_dossier(Integer.parseInt(request.getParameter("IdDossier")));
		Tache.setId_employe(Integer.parseInt(request.getParameter("IdEmploye")));
		
		if (tacheManager.addTache(Tache)>0) {
			request.setAttribute("o1",Tache);
			return list(request);
		}
		else {
			return "/views/error.jsp";
		}
	}
	public String add2(HttpServletRequest request) {
		System.out.println("> Action ajouter()");
		
		Tache = new tache();
		Tache.setId(0);
		Tache.setObjet(request.getParameter("Objet"));
		Tache.setDescription(request.getParameter("description"));
		Tache.setEtat("non traiter");
		Tache.setOrdre(Integer.parseInt(request.getParameter("ordre")));
		Tache.setProbleme("");
		Tache.setDecrpt_prob("");
		Tache.setId_dossier(Integer.parseInt(request.getParameter("id_dossier")));
		Tache.setId_employe(Integer.parseInt(request.getParameter("IdEmploye")));
		
		if (tacheManager.addTache(Tache)>0) {
			List<tache> listTache = tacheManager.getTacheDossier(request.getParameter("id_dossier"));
			request.setAttribute("list", listTache);
			return "/examples/Liste_TacheDossier.jsp";
		}
		else {
			return "/views/error.jsp";
		}
	}
	
	public String get(HttpServletRequest request) {
		String id = request.getParameter("id");
		Tache = tacheManager.getTache(id);
		if (Tache == null) {
			return "/views/TacheNotFound.jsp";
		}
		else {
			request.setAttribute("o1", Tache);
			return "/views/AfficherTache.jsp";
		}
	}
	public String list(HttpServletRequest request) {
		
		List<tache> listTache = tacheManager.listTache();
		request.setAttribute("listTache", listTache);
		return "/examples/Liste_Tache.jsp";
	}
	public String delete(HttpServletRequest request) {
		String id=request.getParameter("id");
		tacheManager.deleteTache(id);
		// TODO Auto-generated method stub
		return list(request);
	}
	
	public String delete2(HttpServletRequest request) {
		String id=request.getParameter("id");
		tacheManager.deleteTache(id);
		// TODO Auto-generated method stub
		return TacheDossier(request);
	}
	
	public String RechercheModifierTache(HttpServletRequest request) {
		String id = request.getParameter("id");
		Tache = tacheManager.getTache(id);
		if (Tache == null) {
			return "/examples/TacheNotFound.jsp";
		}
		else {
			List<dossier> listDossier = tacheManager.list();
			request.setAttribute("list",listDossier);
			List<employe> listEmploye = tacheManager.listEmploye();
			request.setAttribute("listEmploye", listEmploye);
			request.setAttribute("tache", Tache);
			return "/examples/form_modifierTache.jsp";
		}
	}
	public String rechercherProbleme(HttpServletRequest request) {
		String id = request.getParameter("id");
		Tache = tacheManager.getTache(id);
		if (Tache == null) {
			return "/examples/TacheNotFound.jsp";
		}
		else {
		
			request.setAttribute("tache", Tache);
			return "/examples/form_DeclarationProbeme.jsp";
		}
	}
	public String validerModifierTache(HttpServletRequest request) {
		System.out.println("> Action Modifier()");
				
				Tache = new tache();
				Tache.setId(Integer.parseInt(request.getParameter("id")));
				Tache.setObjet(request.getParameter("objet"));
				Tache.setDescription(request.getParameter("description"));
				Tache.setEtat(request.getParameter("etat"));
				Tache.setOrdre(Integer.parseInt(request.getParameter("ordre")));
				Tache.setProbleme(request.getParameter("probleme"));
				Tache.setDecrpt_prob(request.getParameter("decrpt_prob"));
				Tache.setId_dossier(Integer.parseInt(request.getParameter("id_dossier")));
				Tache.setId_employe(Integer.parseInt(request.getParameter("id_employe")));
				
				
				
				if (tacheManager.updateTache(Tache)>0) {
					
					return list(request);
				}
				else {
					return "/views/error.jsp";
				}
			}
	public String validerProbleme(HttpServletRequest request) {
		System.out.println("> Action ModifierProb()");
				
		String id = request.getParameter("id");
		Tache = tacheManager.getTache(id);
				
				Tache.setProbleme(request.getParameter("probleme"));
				Tache.setDecrpt_prob(request.getParameter("dcrpt_prob"));
			
				
				
				
				if (tacheManager.updateTache(Tache)>0) {
					
					return TacheEmploye2(request);
				}
				else {
					return "/views/error.jsp";
				}
			}
	public String PreChercherTache(HttpServletRequest request) {
		List<tache> listTache = tacheManager.listTache();
		request.setAttribute("list", listTache);
		return "/examples/ChercherTache.jsp";
	}
	public String PreAjoutTache(HttpServletRequest request) {
		List<employe> listEmploye = tacheManager.listEmploye();
		List<dossier> list = tacheManager.list();
		request.setAttribute("listEmploye", listEmploye);
		request.setAttribute("list", list);
		return "/examples/form_ajoutTache.jsp";
	}
	public String TacheDossier(HttpServletRequest request) {
		String id_dossier=request.getParameter("id_dossier");
		List<tache> listTache = tacheManager.getTacheDossier(id_dossier);
		request.setAttribute("list", listTache);
		return "/examples/Liste_TacheDossier.jsp";
		
	}
	public String TacheEmploye(HttpServletRequest request) {
		String id_employe=request.getParameter("id_employe");
		List<tache> listTache = tacheManager.getTacheEmploye(id_employe);
		System.out.println(listTache);
		request.setAttribute("list", listTache);
		return "/examples/Liste_TacheEmploye.jsp";
		
	}
	public String TacheEmploye2(HttpServletRequest request) {
		 HttpSession session = request.getSession(true);
		 employe e=(employe)session.getAttribute("employe");
		List<tache> listTache = tacheManager.getTacheEmploye0rdre(e.getId()+"");
		System.out.println(listTache);
		request.setAttribute("list", listTache);
		return "/examples/Liste_TacheEmploye2.jsp";
		
	}
	public String TacheValider(HttpServletRequest request) {
		 HttpSession session = request.getSession(true);
		 employe e=(employe)session.getAttribute("employe");
		List<tache> listTache = tacheManager.tachesValider(e.getId()+"");
		System.out.println(listTache);
		request.setAttribute("list", listTache);
		return "/examples/Liste_TacheValider.jsp";
		
	}
	
	public String PreAjoutTache2(HttpServletRequest request) {
		List<employe> listEmploye = tacheManager.listEmploye();
		
		request.setAttribute("listEmploye", listEmploye);
		
		return "/examples/form_ajoutTache2.jsp";
	}
	public String validerTache(HttpServletRequest request) {
		String id=request.getParameter("id");
		tache t=tacheManager.getTache(id);
		
		tacheManager.validerTache(id,t.getId_dossier());
		// TODO Auto-generated method stub
		return TacheEmploye(request);
	}
	
	
	}
	
	
	
	
	
	
	
	


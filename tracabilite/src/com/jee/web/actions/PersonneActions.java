package com.jee.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.jee.business.Manager;

import mrtier.entities.dossier;
import mrtier.entities.personne;
import mrtier.entities.tache;

public class PersonneActions {
	private Manager personneManager;
	private personne Personne;

	public PersonneActions() {};

	public PersonneActions(Manager personneManager) {
		super();
		this.personneManager = personneManager;
	}
	public void setPersonneManager(Manager personneManager) {
		this.personneManager = personneManager;
	}
	public String add(HttpServletRequest request) {
		System.out.println("> Action ajouter()");
		
		Personne = new personne();
		Personne.setId(0);
		Personne.setNom(request.getParameter("nom"));
		Personne.setPrenom(request.getParameter("prenom"));
		Personne.setEmail(request.getParameter("email"));
		Personne.setPassword(request.getParameter("password"));
		Personne.setTel(request.getParameter("tel"));
		Personne.setFonction("Client");
		if (personneManager.addPersonne(Personne)>0) {
			request.setAttribute("o1",Personne);
			return "/views/NouvellePersonneSuccess.jsp";
		}
		else {
			return "/views/error.jsp";
		}
	}
	
	public String get(HttpServletRequest request) {
		String id = request.getParameter("id");
		Personne = personneManager.getPersonne(id);
		if (Personne == null) {
			return "/views/PersonneNotFound.jsp";
		}
		else {
			request.setAttribute("o1", Personne);
			return "/views/AfficherPersonne.jsp";
		}
	}
	public String list(HttpServletRequest request) {
		List<personne> listPersonne = personneManager.listPersonne();
		request.setAttribute("list", listPersonne);
		return "/views/ListeDes.jsp";
	}
	public String delete(HttpServletRequest request) {
		String id=request.getParameter("id");
		personneManager.deletePersonne(id);
		// TODO Auto-generated method stub
		return "/views/deletePersonnesuccess.jsp";
	}
	public String RechercheModifier(HttpServletRequest request) {
		String id = request.getParameter("id");
		Personne = personneManager.getPersonne(id);
		if (Personne == null) {
			return "/views/PersonneNotFound.jsp";
		}
		else {
			request.setAttribute("o1", Personne);
			return "/views/ModifierPersonne.jsp";
		}
	}
	public String validerModifier(HttpServletRequest request) {
		System.out.println("> Action Modifier()");
				
		Personne = new personne();
		Personne.setId(0);
		Personne.setNom(request.getParameter("nom"));
		Personne.setPrenom(request.getParameter("prenom"));
		Personne.setEmail(request.getParameter("email"));
		Personne.setPassword(request.getParameter("password"));
		Personne.setTel(request.getParameter("tel"));
		Personne.setFonction(request.getParameter("fonction"));
				
				
				if (personneManager.updatePersonne(Personne)>0) {
					
					return list(request);
				}
				else {
					return "/views/error.jsp";
				}
			}
	public String PreChercherPersonne(HttpServletRequest request) {
		List<personne> listPersonne = personneManager.listPersonne();
		request.setAttribute("list", listPersonne);
		return "/views/ChercherPersonne.jsp";
	}

}

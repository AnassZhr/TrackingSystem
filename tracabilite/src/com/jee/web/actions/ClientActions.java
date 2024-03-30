package com.jee.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.jee.business.Manager;

import mrtier.entities.client;
import mrtier.entities.employe;


public class ClientActions {
	private Manager clientManager;
	private client Client;

	public ClientActions() {};

	public ClientActions(Manager clientManager) {
		super();
		this.clientManager = clientManager;
	}
	public void setClientManager(Manager clientManager) {
		this.clientManager = clientManager;
	}
	
	public String add(HttpServletRequest request) {
		System.out.println("> Action ajouter()");
		
		Client = new client();
		Client.setId(0);
		Client.setNom(request.getParameter("nom"));
		Client.setPrenom(request.getParameter("prenom"));
		Client.setEmail(request.getParameter("email"));
		Client.setPassword(request.getParameter("password"));
		Client.setTel(request.getParameter("tel"));
		Client.setFonction("Client");
		Client.setObjet(request.getParameter("objet"));
		if (clientManager.addClient(Client)>0) {
			request.setAttribute("o1",Client);
			return list(request);
		}
		else {
			return "/views/error.jsp";
		}
	}
	public String add2(HttpServletRequest request) {
		System.out.println("> Action ajouter()");
		
		Client = new client();
		Client.setId(0);
		Client.setNom(request.getParameter("nom"));
		Client.setPrenom(request.getParameter("prenom"));
		Client.setEmail(request.getParameter("email"));
		Client.setPassword(request.getParameter("password"));
		Client.setTel(request.getParameter("tel"));
		Client.setFonction("Client");
		Client.setObjet(request.getParameter("objet"));
		if (clientManager.addClient(Client)>0) {
			request.setAttribute("o1",Client);
			return "/examples/DossierSucces.jsp";
		}
		else {
			return "/views/error.jsp";
		}
	}
	
	public String get(HttpServletRequest request) {
		String id = request.getParameter("id");
		Client = clientManager.getClient(id);
		if (Client == null) {
			return "/views/ClientNotFound.jsp";
		}
		else {
			request.setAttribute("o1", Client);
			return "/views/AfficherClient.jsp";
		}
	}
	public String list(HttpServletRequest request) {
		List<client> listClient = clientManager.listClient();
		request.setAttribute("listClient", listClient);
		return "/examples/Liste_Client.jsp";
	}
	
	
	public String delete(HttpServletRequest request) {
		String id=request.getParameter("id");
		clientManager.deleteClient(id);
		// TODO Auto-generated method stub
		return list(request);
	}
	public String RechercheModifier(HttpServletRequest request) {
		String id = request.getParameter("id");
		Client = clientManager.getClient(id);
		if (Client == null) {
			return "/views/ClientNotFound.jsp";
		}
		else {
			request.setAttribute("client", Client);
			return "/examples/form_modifierClient.jsp";
		}
	}
	public String validerModifier(HttpServletRequest request) {
		System.out.println("> Action Modifier()");
				
		Client = new client();
		Client.setId(Integer.parseInt(request.getParameter("id")));
		Client.setNom(request.getParameter("nom"));
		Client.setPrenom(request.getParameter("prenom"));
		Client.setEmail(request.getParameter("email"));
		Client.setPassword(request.getParameter("password"));
		Client.setTel(request.getParameter("tel"));
		Client.setFonction(request.getParameter("fonction"));
		Client.setObjet("objet");
				
				
				if (clientManager.updateClient(Client)>0) {
					
					return list(request);
				}
				else {
					return "/views/error.jsp";
				}
			}
	public String PreChercherClient(HttpServletRequest request) {
		List<client> listClient = clientManager.listClient();
		request.setAttribute("list", listClient);
		return "/views/ChercherClient.jsp";
	}
	


}

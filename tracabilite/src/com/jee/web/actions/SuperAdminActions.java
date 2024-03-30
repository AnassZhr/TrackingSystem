package com.jee.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.jee.business.Manager;

import mrtier.entities.admin;
import mrtier.entities.employe;
import mrtier.entities.superAdmin;


public class SuperAdminActions {
	private Manager superAdminManager;
	private superAdmin SuperAdmin;
	
public SuperAdminActions() {};

public SuperAdminActions(Manager superAdminManager) {
	super();
	this.superAdminManager = superAdminManager;
}
public void setAdminManager(Manager superAdminManager) {
	this.superAdminManager = superAdminManager;
}
public String add(HttpServletRequest request) {
	System.out.println("> Action ajouter()");
	
	SuperAdmin = new superAdmin();
	SuperAdmin.setId(0);
	SuperAdmin.setNom(request.getParameter("nom"));
	SuperAdmin.setPrenom(request.getParameter("prenom"));
	SuperAdmin.setEmail(request.getParameter("email"));
	SuperAdmin.setPassword(request.getParameter("password"));
	SuperAdmin.setTel(request.getParameter("tel"));
	SuperAdmin.setFonction("SuperAdmin");
	if (superAdminManager.addSuperAdmin(SuperAdmin)>0) {
		request.setAttribute("o1",SuperAdmin);
		return list(request);
	}
	else {
		return "/views/error.jsp";
	}
}

public String get(HttpServletRequest request) {
	String id = request.getParameter("id");
	SuperAdmin = superAdminManager.getSuperAdmin(id);
	if (SuperAdmin == null) {
		return "/views/AdminNotFound.jsp";
	}
	else {
		request.setAttribute("o1", SuperAdmin);
		return "/views/AfficherAdmin.jsp";
	}
}
public String list(HttpServletRequest request) {
	List<superAdmin> listSuperAdmin = superAdminManager.listSuperAdmin();
	request.setAttribute("listSuperAdmin", listSuperAdmin);
	return "/examples/Liste_SuperAdmin.jsp";
}
public String delete(HttpServletRequest request) {
	String id=request.getParameter("id");
	superAdminManager.deleteSuperAdmin(id);
	// TODO Auto-generated method stub
	return list(request);
}
public String RechercheModifier(HttpServletRequest request) {
	String id = request.getParameter("id");
	SuperAdmin = superAdminManager.getSuperAdmin(id);
	if (SuperAdmin == null) {
		return "/views/AdminNotFound.jsp";
	}
	else {
		request.setAttribute("superAdmin", SuperAdmin);
		return "/examples/form_modifierSuperAdmin.jsp";
	}
}public String validerModifier(HttpServletRequest request) {
	System.out.println("> Action Modifier()");
			
	SuperAdmin = new superAdmin();
	SuperAdmin.setId(Integer.parseInt(request.getParameter("id")));
	SuperAdmin.setNom(request.getParameter("nom"));
	SuperAdmin.setPrenom(request.getParameter("prenom"));
	SuperAdmin.setEmail(request.getParameter("email"));
	SuperAdmin.setPassword(request.getParameter("password"));
	SuperAdmin.setTel(request.getParameter("tel"));
	SuperAdmin.setFonction(request.getParameter("fonction"));
			
			
			if (superAdminManager.updateSuperAdmin(SuperAdmin)>0) {
				
				return list(request);
			}
			else {
				return "/views/error.jsp";
			}
		}
public String PreChercherSuperAdmin(HttpServletRequest request) {
	List<superAdmin> listSuperAdmin = superAdminManager.listSuperAdmin();
	request.setAttribute("list", listSuperAdmin);
	return "/views/ChercherSuperAdmin.jsp";
}
	


}

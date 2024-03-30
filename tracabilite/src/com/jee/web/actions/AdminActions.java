package com.jee.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.jee.business.Manager;

import mrtier.entities.admin;
import mrtier.entities.employe;


public class AdminActions {
	private Manager adminManager;
	private admin Admin;
	
public AdminActions() {};

public AdminActions(Manager adminManager) {
	super();
	this.adminManager = adminManager;
}
public void setAdminManager(Manager adminManager) {
	this.adminManager = adminManager;
}
public String add(HttpServletRequest request) {
	System.out.println("> Action ajouter()");
	
	Admin = new admin();
	Admin.setId(0);
	Admin.setNom(request.getParameter("nom"));
	Admin.setPrenom(request.getParameter("prenom"));
	Admin.setEmail(request.getParameter("email"));
	Admin.setPassword(request.getParameter("password"));
	Admin.setTel(request.getParameter("tel"));
	Admin.setFonction("Admin");
	if (adminManager.addAdmin(Admin)>0) {
		request.setAttribute("o1",Admin);
		return list(request);
	}
	else {
		return "/views/error.jsp";
	}
}

public String get(HttpServletRequest request) {
	String id = request.getParameter("id");
	Admin = adminManager.getAdmin(id);
	if (Admin == null) {
		return "/views/AdminNotFound.jsp";
	}
	else {
		request.setAttribute("o1", Admin);
		return "/views/AfficherAdmin.jsp";
	}
}
public String list(HttpServletRequest request) {
	List<admin> listAdmin = adminManager.listAdmin();
	request.setAttribute("listAdmin", listAdmin);
	return "/examples/Liste_Admin.jsp";
}
public String delete(HttpServletRequest request) {
	String id=request.getParameter("id");
	adminManager.deleteAdmin(id);
	// TODO Auto-generated method stub
	return list(request);
}
public String RechercheModifier(HttpServletRequest request) {
	String id = request.getParameter("id");
	Admin = adminManager.getAdmin(id);
	if (Admin == null) {
		return "/views/AdminNotFound.jsp";
	}
	else {
		request.setAttribute("admin", Admin);
		return "/examples/form_modifierAdmin.jsp";
	}
}public String validerModifier(HttpServletRequest request) {
	System.out.println("> Action Modifier()");
			
	Admin = new admin();
	Admin.setId(Integer.parseInt(request.getParameter("id")));
	Admin.setNom(request.getParameter("nom"));
	Admin.setPrenom(request.getParameter("prenom"));
	Admin.setEmail(request.getParameter("email"));
	Admin.setPassword(request.getParameter("password"));
	Admin.setTel(request.getParameter("tel"));
	Admin.setFonction(request.getParameter("fonction"));
			
			
			if (adminManager.updateAdmin(Admin)>0) {
				
				return list(request);
			}
			else {
				return "/views/error.jsp";
			}
		}
public String PreChercherAdmin(HttpServletRequest request) {
	List<admin> listAdmin = adminManager.listAdmin();
	request.setAttribute("list", listAdmin);
	return "/views/ChercherAdmin.jsp";
}
public String AuthentificationAdmin(HttpServletRequest request) {
	
String email = request.getParameter("email");
String password = request.getParameter("password");

admin a = adminManager.authentificationAdmin(email, password);
if(a!=null) {
	return "/examples/indexAdmin.jsp";
	
}else return "/examples/AuthentificationAdmin.jsp";
}

}

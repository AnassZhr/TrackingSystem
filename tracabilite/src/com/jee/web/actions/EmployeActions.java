package com.jee.web.actions;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.jee.business.Manager;

import mrtier.entities.admin;
import mrtier.entities.employe;

public class EmployeActions {
private Manager employeManager;
private employe Employe;

public EmployeActions() {};

public EmployeActions(Manager employeManager) {
	super();
	this.employeManager = employeManager;
}
public void setEmployeManager(Manager employeManager) {
	this.employeManager = employeManager;
}
public String add(HttpServletRequest request) {
	System.out.println("> Action ajouter()");
	
	Employe = new employe();
	Employe.setId(0);
	Employe.setNom(request.getParameter("nom"));
	Employe.setPrenom(request.getParameter("prenom"));
	Employe.setEmail(request.getParameter("email"));
	Employe.setPassword(request.getParameter("password"));
	Employe.setTel(request.getParameter("tel"));
	Employe.setFonction("Employe");
	if (employeManager.addEmploye(Employe)>0) {
		request.setAttribute("o1",Employe);
		return list(request);
	}
	else {
		return "/views/error.jsp";
	}
}

public String get(HttpServletRequest request) {
	String id = request.getParameter("id");
	Employe = employeManager.getEmploye(id);
	if (Employe == null) {
		return "/views/EmployeNotFound.jsp";
	}
	else {
		request.setAttribute("o1", Employe);
		return "/views/AfficherEmploye.jsp";
	}
}
public String list(HttpServletRequest request) {
	List<employe> listEmploye = employeManager.listEmploye();
	request.setAttribute("listEmploye", listEmploye);
	return "/examples/Liste_Employe.jsp";
}
public String delete(HttpServletRequest request) {
	String id=request.getParameter("id");
	employeManager.deleteEmploye(id);
	// TODO Auto-generated method stub
	return list(request);
}
public String RechercheModifier(HttpServletRequest request) {
	String id = request.getParameter("id");
	Employe = employeManager.getEmploye(id);
	if (Employe == null) {
		return "/views/EmployeNotFound.jsp";
	}
	else {
		request.setAttribute("employe", Employe);
		return "/examples/form_modifierEmploye.jsp";
	}
}
public String validerModifier(HttpServletRequest request) {
	System.out.println("> Action Modifier()");
			
	Employe = new employe();
	Employe.setId(Integer.parseInt(request.getParameter("id")));
	Employe.setNom(request.getParameter("nom"));
	Employe.setPrenom(request.getParameter("prenom"));
	Employe.setEmail(request.getParameter("email"));
	Employe.setPassword(request.getParameter("password"));
	Employe.setTel(request.getParameter("tel"));
	Employe.setFonction(request.getParameter("fonction"));
			
			
			if (employeManager.updateEmploye(Employe)>0) {
				
				return list(request);
			}
			else {
				return "/views/error.jsp";
			}
		}
public String PreChercherEmploye(HttpServletRequest request) {
	List<employe> listEmploye = employeManager.listEmploye();
	request.setAttribute("list", listEmploye);
	return "/views/ChercherEmploye.jsp";
}
public String AuthentificationEmploye(HttpServletRequest request) {
	
String email = request.getParameter("email");
String password = request.getParameter("password");

employe e = employeManager.authentificationEmploye(email, password);
if(e!=null) {
	
	 HttpSession session = request.getSession(true);
	 session.setAttribute("employe", e);
	return "/examples/indexEmploye2.jsp";
	
}else return "/examples/AuthentificationEmploye.jsp";
}



}

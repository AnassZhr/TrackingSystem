package com.jee.web.actions;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.jee.business.Manager;

import mrtier.entities.client;
import mrtier.entities.dossier;
import mrtier.entities.personne;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class DossierActions {
private Manager dossierManager;
private dossier Dossier;

public DossierActions() {};

public DossierActions(Manager dossierManager) {
	super();
	this.dossierManager = dossierManager;
}
public void sendMail(String idclient, String tn) {
	
	client c=dossierManager.getClient(idclient);
	  // Recipient's email ID needs to be mentioned.
    String to = c.getEmail();

    // Sender's email ID needs to be mentioned
    String from = "anouchzahraoui@gmail.com";

    // Assuming you are sending email from through gmails smtp
    String host = "smtp.gmail.com";

    // Get system properties
    Properties properties = System.getProperties();

    // Setup mail server
    properties.put("mail.smtp.host", host);
    properties.put("mail.smtp.port", "465");
    properties.put("mail.smtp.ssl.enable", "true");
    properties.put("mail.smtp.auth", "true");

    // Get the Session object.// and pass username and password
    Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

        protected PasswordAuthentication getPasswordAuthentication() {

            return new PasswordAuthentication("anouchzahraoui@gmail.com", "0611958330");

        }

    });

    // Used to debug SMTP issues
    session.setDebug(true);

    try {
        // Create a default MimeMessage object.
        MimeMessage message = new MimeMessage(session);

        // Set From: header field of the header.
        message.setFrom(new InternetAddress(from));

        // Set To: header field of the header.
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

        // Set Subject: header field
        message.setSubject("Dossier");

        // Now set the actual message
        message.setText("Le numero de tracking est "+tn);

        System.out.println("sending...");
        // Send message
        Transport.send(message);
        System.out.println("Sent message successfully....");
    } catch (MessagingException mex) {
        mex.printStackTrace();
    }

}
public void setDossierManager(Manager dossierManager) {
	this.dossierManager = dossierManager;
}
public String add(HttpServletRequest request) {
	System.out.println("> Action ajouter()");
	sendMail(request.getParameter("IdClient"),request.getParameter("numTracking"));
	Dossier = new dossier();
	Dossier.setId(0);
	Dossier.setObjet(request.getParameter("Objet"));
	Dossier.setDescription(request.getParameter("description"));
	Dossier.setId_client(Integer.parseInt(request.getParameter("IdClient")));
	Dossier.setNumTracking(request.getParameter("numTracking"));
	if (dossierManager.add(Dossier)>0) {
		request.setAttribute("o1",Dossier);
		return list(request);
	}
	else {
		return "/views/error.jsp";
	}
}
public String get(HttpServletRequest request) {
	String id = request.getParameter("id");
	Dossier = dossierManager.get(id);
	if (Dossier == null) {
		return "/views/ProduitNotFound.jsp";
	}
	else {
		request.setAttribute("o1", Dossier);
		return "/views/AfficherDossier.jsp";
	}
}
public String list(HttpServletRequest request) {
	List<dossier> list = dossierManager.list();
	request.setAttribute("list", list);
	return "/examples/Liste_Dossier.jsp";
}
public String delete(HttpServletRequest request) {
	String id=request.getParameter("id");
	dossierManager.delete(id);
	// TODO Auto-generated method stub
	return list(request);
}
public String RechercheModifier(HttpServletRequest request) {
	String id = request.getParameter("id");
	Dossier = dossierManager.get(id);
	if (Dossier == null) {
		
		
		return "/views/DossierNotFound.jsp";
	}
	else {
		List<client> listClient = dossierManager.listClient();
		request.setAttribute("listClient", listClient);
		
		request.setAttribute("dossier", Dossier);
		return "/examples/form_modifierDossier.jsp";
	}
}
public String validerModifier(HttpServletRequest request) {
System.out.println("> Action Modifier()");
		
		Dossier = new dossier();
		Dossier.setId(Integer.parseInt(request.getParameter("id")));
		Dossier.setObjet(request.getParameter("Objet"));
		Dossier.setDescription(request.getParameter("description"));
		Dossier.setId_client(Integer.parseInt(request.getParameter("id_client")));
		Dossier.setNumTracking(request.getParameter("numTracking"));
		
		if (dossierManager.updateProduct(Dossier)>0) {
			
			return list(request);
		}
		else {
			return "/views/error.jsp";
		}
	}

public String PreChercherDossier(HttpServletRequest request) {
	List<dossier> list = dossierManager.list();
	request.setAttribute("list", list);
	return "/views/ChercherDossier.jsp";
}
public String PreAjoutDossier(HttpServletRequest request) {
	List<client> listClient = dossierManager.listClient();
	request.setAttribute("listClient", listClient);
	return "/examples/form_ajoutDossier.jsp";
}
public String PreModifierDossier(HttpServletRequest request) {
	List<client> listClient = dossierManager.listClient();
	request.setAttribute("listClient", listClient);
	return "/examples/form_modifierDossier.jsp";
}
public String ConsulterDossier(HttpServletRequest request) {
	String NumTracking= request.getParameter("numTracking");
	dossier d= dossierManager.getDossierParNum(NumTracking);
	float p=dossierManager.getProgreession(d.getId());
	request.setAttribute("progression", p);
	return "/examples/ProgressionBar2.jsp";
}




}


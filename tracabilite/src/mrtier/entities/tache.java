package mrtier.entities;

public class tache {
	private int id;
	private String objet;
	private String description;
	private String etat;
	private int ordre;
	private String probleme;
	private String decrpt_prob;
	private int id_dossier;
	private int id_employe;
	private employe Employe;
	private dossier Dossier;
	
	
	
	
	
	public dossier getDossier() {
		return Dossier;
	}


	public void setDossier(dossier dossier) {
		Dossier = dossier;
	}


	public employe getEmploye() {
		return Employe;
	}


	public void setEmploye(employe employe) {
		Employe = employe;
	}


	public tache (String row[]) {   
	id = Integer.parseInt(row[0]);
	objet = row[1];
	description=row[2];
	etat=row[3];
	ordre=Integer.parseInt(row[4]);
	probleme=row[5];
	decrpt_prob=row[6];
	id_dossier=Integer.parseInt(row[7]);
	id_employe=Integer.parseInt(row[8]);
	}
	

	public tache() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public tache(int id, String objet, String description, String etat, int ordre, String probleme, String decrpt_prob,
			int id_dossier, int id_employe) {
		super();
		this.id = id;
		this.objet = objet;
		this.description = description;
		this.etat = etat;
		this.ordre = ordre;
		this.probleme = probleme;
		this.decrpt_prob = decrpt_prob;
		this.id_dossier = id_dossier;
		this.id_employe = id_employe;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public int getOrdre() {
		return ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

	public String getProbleme() {
		return probleme;
	}

	public void setProbleme(String probleme) {
		this.probleme = probleme;
	}

	public String getDecrpt_prob() {
		return decrpt_prob;
	}

	public void setDecrpt_prob(String decrpt_prob) {
		this.decrpt_prob = decrpt_prob;
	}

	public int getId_dossier() {
		return id_dossier;
	}

	public void setId_dossier(int id_dossier) {
		this.id_dossier = id_dossier;
	}

	public int getId_employe() {
		return id_employe;
	}

	public void setId_employe(int id_employe) {
		this.id_employe = id_employe;
	}

	@Override
	public String toString() {
		return "tache [id=" + id + ", objet=" + objet + ", description=" + description + ", etat=" + etat + ", ordre="
				+ ordre + ", probleme=" + probleme + ", decrpt_prob=" + decrpt_prob + ", id_dossier=" + id_dossier
				+ ", id_employe=" + id_employe + ", employe=" + Employe + "]";
	}
	

}

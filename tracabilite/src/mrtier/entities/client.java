package mrtier.entities;

public class client {

	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private String tel;
	private String fonction;
	private String objet;
	
	public client (String row[]) {   
		id = Integer.parseInt(row[0]);
		nom = row[1];
		prenom=row[2];
		email=row[3];
		password=row[4];
		tel=row[5];
		fonction=row[6];
		objet=row[7];
				}
	
	
	
	
	public client(int id, String nom, String prenom, String email, String password, String tel, String fonction,String objet) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.tel = tel;
		this.fonction = fonction;
		this.objet = objet;
	}

	 



	public client() {
		super();
		// TODO Auto-generated constructor stub
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFonction() {
		return fonction;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	




	public String getObjet() {
		return objet;
	}




	public void setObjet(String objet) {
		this.objet = objet;
	}




	@Override
	public String toString() {
		return "client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password="
				+ password + ", tel=" + tel + ", fonction=" + fonction + "]";
	}
	
	
	
	
}
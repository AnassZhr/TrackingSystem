package mrtier.entities;

public class personne {
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private String tel;
	private String fonction;
	
	public personne (String row[]) {   
		id = Integer.parseInt(row[0]);
		nom = row[1];
		prenom=row[2];
		password=row[3];
		tel=row[4];
		password=row[5];
		fonction=row[6];
		
		
		}
	

	public personne(int id, String nom, String prenom, String email, String password, String tel, String fonction) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.tel = tel;
		this.fonction = fonction;
	}


	public personne() {
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

	@Override
	public String toString() {
		return "personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password="
				+ password + ", tel=" + tel + ", fonction=" + fonction + "]";
	}
	
	

}

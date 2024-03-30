package mrtier.entities;



public class dossier {
	private int id;
	private String objet;
	private String description;
	private int id_client;
	private client Client;
	private String numTracking;
	
	
	
	public client getClient() {
		return Client;
	}

	public void setClient(client client) {
		Client = client;
	}

	public dossier(String row[]) {
		id = Integer.parseInt(row[0]);
		objet = row[1];
		description=row[2];
		id_client=Integer.parseInt(row[3]);
		numTracking=row[4];
	}
	
	public dossier() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public dossier(int id, String objet, String description, int id_client) {
		super();
		this.id = id;
		this.objet = objet;
		this.description = description;
		this.id_client = id_client;
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
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	
	
	public String getNumTracking() {
		return numTracking;
	}

	public void setNumTracking(String numTracking) {
		this.numTracking = numTracking;
	}

	@Override
	public String toString() {
		return "dossier [id=" + id + ", objet=" + objet + ", description=" + description + ", id_client=" + id_client
				+ "]";
	}
	

}

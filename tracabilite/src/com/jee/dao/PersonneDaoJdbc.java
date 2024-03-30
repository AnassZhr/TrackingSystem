package com.jee.dao;

import java.util.List;
import java.util.Vector;

import mrtier.entities.personne;


public class PersonneDaoJdbc implements PersonneDao {
	
	private Database db;

	public PersonneDaoJdbc() {
		super();
	}

	public PersonneDaoJdbc(Database db) {
		super();
		this.db = db;
	}

	public void setDatabase(Database db) {
		this.db = db;
		}

	@Override
	public int insert(personne Personne) {
		String row[] = {
				Personne.getId()+"",
				Personne.getNom(),
				Personne.getPrenom(),
				Personne.getEmail(),
				Personne.getPassword()+"",
				Personne.getTel(),
				Personne.getFonction(),
				
			};
			return db.insert("personne", row);
	}

	@Override
	public personne select(String id) {
		String row[] = db.select("personne", "id", id);
		if (row == null) return null;
		personne p = new personne(row);
		return p;
	}

	@Override
	public List<personne> selectAll() {
		Vector<personne> list = new Vector<>();
		String data[][] = db.select("personne");
		if (data == null) return list;
		
		for (int i = 0; i < data.length; i++) {
			personne p = new personne(data[i]);
			list.add(p);
		}
		return list;
	}

	@Override
	public void delete(String id) {
		db.delete("personne","id",id);
		}

	@Override
	public int updatePersonne(personne Personne) {
		return db.executUpdate("update dossier set objet='"+Personne.getNom()+"' , prenom="+Personne.getPrenom() +" , email="+Personne.getEmail()+", password="+Personne.getPassword()+" , tel="+Personne.getTel()+" , fonction="+Personne.getFonction() +" where id='"+Personne.getId() +"'");
	}
	

}

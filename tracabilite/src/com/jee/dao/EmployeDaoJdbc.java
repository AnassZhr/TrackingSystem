package com.jee.dao;

import java.util.List;
import java.util.Vector;

import mrtier.entities.admin;
import mrtier.entities.employe;


public class EmployeDaoJdbc implements EmployeDao {

	private Database db;

	public EmployeDaoJdbc() {
		super();
	}

	public EmployeDaoJdbc(Database db) {
		super();
		this.db = db;
	}

	public void setDatabase(Database db) {
		this.db = db;
		}
	
	@Override
	public int insert(employe Employe) {
		String row[] = {
				Employe.getId()+"",
				Employe.getNom(),
				Employe.getPrenom(),
				Employe.getEmail(),
				Employe.getPassword()+"",
				Employe.getTel(),
				Employe.getFonction(),
				""
				
			};
			return db.insert("personne", row);
	}

	@Override
	public employe select(String id) {
		String row[] = db.select("personne", "id", id);
		if (row == null) return null;
		employe e = new employe(row);
		return e;
	}

	@Override
	public List<employe> selectAll() {
		Vector<employe> list = new Vector<>();
		String data[][] = db.selectByKey("personne","fonction","employe");
		if (data == null) return list;
		
		for (int i = 0; i < data.length; i++) {
			employe e = new employe(data[i]);
			list.add(e);
		}
		return list;
	}

	@Override
	public void delete(String id) {
		db.delete("personne","id",id);
		
	}

	@Override
	public int updateEmploye(employe Employe) {
		return db.executUpdate("update personne set nom='"+Employe.getNom()+"' , prenom='"+Employe.getPrenom() +"' , email='"+Employe.getEmail()+"', password='"+Employe.getPassword()+"' , tel='"+Employe.getTel()+"' , fonction='"+Employe.getFonction() +"' where id='"+Employe.getId() +"'");
	}
	public employe authentificationEmploye(String email , String password) {
		String query ="select * from personne where fonction='employe' and password='"+password+"'and email='"+email+"'";
		String [] row = db.selectQuery(query);
		if (row==null)return null;
		return new employe(row);
	}

}

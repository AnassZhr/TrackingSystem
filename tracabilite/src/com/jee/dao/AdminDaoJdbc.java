package com.jee.dao;

import java.util.List;
import java.util.Vector;

import mrtier.entities.admin;
import mrtier.entities.employe;

public class AdminDaoJdbc implements AdminDao{
	
	
	private Database db;
	
	public AdminDaoJdbc() {
		super();
	}
	
	public AdminDaoJdbc(Database db) {
		super();
		this.db = db;
	}
	
	public void setDatabase(Database db) {
		this.db = db;
		}
	
	
	
	

	@Override
	public int insert(admin Admin) {
		String row[] = {
				Admin.getId()+"",
				Admin.getNom(),
				Admin.getPrenom(),
				Admin.getEmail(),
				Admin.getPassword()+"",
				Admin.getTel(),
				Admin.getFonction(),
				""
				
			};
			return db.insert("personne", row);

		
	}

	@Override
	public admin select(String id) {
		String row[] = db.select("personne", "id", id);
		if (row == null) return null;
		admin a = new admin(row);
		return a;
	}

	@Override
	public List<admin> selectAll() {
		Vector<admin> list = new Vector<>();
		String data[][] = db.selectByKey("personne","fonction","admin");
		if (data == null) return list;
		
		for (int i = 0; i < data.length; i++) {
			admin a = new admin(data[i]);
			list.add(a);
		}
		return list;	
	}

	@Override
	public void delete(String id) {
		db.delete("personne","id",id);
		
	}

	@Override
	public int updateAdmin(admin Admin) {
		return db.executUpdate("update personne set nom='"+Admin.getNom()+"' , prenom='"+Admin.getPrenom() +"' , email='"+Admin.getEmail()+"', password='"+Admin.getPassword()+"' , tel='"+Admin.getTel()+"' , fonction='"+Admin.getFonction() +"' where id='"+Admin.getId() +"'");

	}
	public admin authentificationAdmin(String email , String password) {
		String query ="select * from personne where fonction='admin' and password='"+password+"'and email='"+email+"'";
		String [] row = db.selectQuery(query);
		if (row==null)return null;
		return new admin(row);
	}

}

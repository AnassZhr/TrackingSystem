package com.jee.dao;

import java.util.List;
import java.util.Vector;

import mrtier.entities.superAdmin;
import mrtier.entities.employe;

public class SuperAdminDaoJdbc implements SuperAdminDao{
	
	
	private Database db;
	
	public SuperAdminDaoJdbc() {
		super();
	}
	
	public SuperAdminDaoJdbc(Database db) {
		super();
		this.db = db;
	}
	
	public void setDatabase(Database db) {
		this.db = db;
		}
	
	
	
	

	@Override
	public int insert(superAdmin SuperAdmin) {
		String row[] = {
				SuperAdmin.getId()+"",
				SuperAdmin.getNom(),
				SuperAdmin.getPrenom(),
				SuperAdmin.getEmail(),
				SuperAdmin.getPassword()+"",
				SuperAdmin.getTel(),
				SuperAdmin.getFonction(),
				
			};
			return db.insert("personne", row);

		
	}

	@Override
	public superAdmin select(String id) {
		String row[] = db.select("personne", "id", id);
		if (row == null) return null;
		superAdmin a = new superAdmin(row);
		return a;
	}

	@Override
	public List<superAdmin> selectAll() {
		Vector<superAdmin> list = new Vector<>();
		String data[][] = db.selectByKey("personne","fonction","superAdmin");
		if (data == null) return list;
		
		for (int i = 0; i < data.length; i++) {
			superAdmin a = new superAdmin(data[i]);
			list.add(a);
		}
		return list;	
	}

	@Override
	public void delete(String id) {
		db.delete("personne","id",id);
		
	}

	@Override
	public int updateSuperAdmin(superAdmin SuperAdmin) {
		return db.executUpdate("update personne set nom='"+SuperAdmin.getNom()+"' , prenom='"+SuperAdmin.getPrenom() +"' , email='"+SuperAdmin.getEmail()+"', password='"+SuperAdmin.getPassword()+"' , tel='"+SuperAdmin.getTel()+"' , fonction='"+SuperAdmin.getFonction() +"' where id='"+SuperAdmin.getId() +"'");

	}
	

}

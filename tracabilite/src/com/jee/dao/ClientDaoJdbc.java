package com.jee.dao;

import java.util.List;
import java.util.Vector;

import mrtier.entities.client;
import mrtier.entities.employe;


public class ClientDaoJdbc implements ClientDao {
    
	private Database db;
	
	public ClientDaoJdbc() {
		super();
		
	}
	
	public ClientDaoJdbc(Database db) {
		super();
		this.db=db;
		
	}
	public void setDatabase(Database db) {
		this.db = db;
		}

	@Override
	public int insert(client Client) {
		String row[] = {
				Client.getId()+"",
				Client.getNom(),
				Client.getPrenom(),
				Client.getEmail(),
				Client.getPassword()+"",
				Client.getTel(),
				Client.getFonction(),
				Client.getObjet()
				
			};
			return db.insert("personne", row);
	}

	@Override
	public client select(String id) {
		String row[] = db.select("personne", "id", id);
		if (row == null) return null;
		client c = new client(row);
		return c;
	}

	@Override
	public List<client> selectAll() {
		Vector<client> list = new Vector<>();
		String data[][] = db.selectByKey("personne","fonction","client");
		if (data == null) return list;
		
		for (int i = 0; i < data.length; i++) {
			client c = new client(data[i]);
			list.add(c);
		}
		return list;
	}

	@Override
	public void delete(String id) {
		db.delete("personne","id",id);
		
	}

	@Override
	public int updateClient(client Client) {
		return db.executUpdate("update personne set nom='"+Client.getNom()+"' , prenom='"+Client.getPrenom() +"' , email='"+Client.getEmail()+"', password='"+Client.getPassword()+"' , tel='"+Client.getTel()+"' , fonction='"+Client.getFonction() +"' where id='"+Client.getId() +"'");
	}
	

}

package com.jee.dao;

import java.util.List;
import java.util.Vector;


import mrtier.entities.tache;

public class TacheDaoJdbc implements TacheDao {
    
	private Database db;

	public TacheDaoJdbc() {
		super();
	}

	public TacheDaoJdbc(Database db) {
		super();
		this.db = db;
	}

	public void setDatabase(Database db) {
		this.db = db;
		}

	@Override
	public int insert(tache Tache) {
		String row[] = {
				Tache.getId()+"",
				Tache.getObjet(),
				Tache.getDescription(),
				Tache.getEtat(),
				Tache.getOrdre()+"",
				Tache.getProbleme(),
				Tache.getDecrpt_prob(),
				Tache.getId_dossier()+"",
				Tache.getId_employe()+"",
			};
			return db.insert("tache", row);
	}

	@Override
	public tache select(String id) {
		String row[] = db.select("tache", "id", id);
		if (row == null) return null;
		tache t = new tache(row);
		return t;
		
	}

	@Override
	public List<tache> selectAll() {
		Vector<tache> list = new Vector<>();
		String data[][] = db.select("tache");
		if (data == null) return list;
		
		for (int i = 0; i < data.length; i++) {
			tache t = new tache(data[i]);
			list.add(t);
		}
		return list;
	}

	@Override
	public void delete(String id) {
		db.delete("tache","id",id);
		
	}

	@Override
	public int updateTache(tache Tache) {
		return db.executUpdate("update tache set objet='"+Tache.getObjet()+"' , description='"+Tache.getDescription() +"'  , etat='"+Tache.getEtat()+"' , ordre='"+Tache.getOrdre()+"'  , probleme='"+Tache.getProbleme()+"'  , decrpt_prob='"+Tache.getDecrpt_prob()+"'  , id_dossier='"+Tache.getId_dossier()+"'  , id_employe="+Tache.getId_employe() +"  where id='"+Tache.getId() +"'");
	}

	@Override
	//retourne une list des taches qui contient les id dossier du dossier selectionner
	public List<tache> tachesParDossier(String id_dossier) {
		// TODO Auto-generated method stub
		Vector<tache> list = new Vector<>();
		String data[][] = db.selectByKey("tache","id_dossier", id_dossier);
		if (data == null) return list;
		
		for (int i = 0; i < data.length; i++) {
			tache t = new tache(data[i]);
			list.add(t);
		}
		return list;
	}
	public List<tache> tachesParEmploye(String id_employe) {
		// TODO Auto-generated method stub
		Vector<tache> list = new Vector<>();
		String data[][] = db.selectByKey("tache","id_employe", id_employe);
		if (data == null) return list;
		
		for (int i = 0; i < data.length; i++) {
			tache t = new tache(data[i]);
			list.add(t);
		}
		return list;
	}
	public List<tache> tachesParEmployeOrdre(String id_employe) {
		// TODO Auto-generated method stub
		Vector<tache> list = new Vector<>();
		String req = "SELECT * FROM tache where id_employe='"+id_employe+"' and ordre=1 and etat='non traiter'";
		String data[][] = db.selectQuery2(req);
		if (data == null) return list;
		
		for (int i = 0; i < data.length; i++) {
			tache t = new tache(data[i]);
			list.add(t);
		}
		return list;
	}
	public List<tache> tachesValider(String id_employe) {
		// TODO Auto-generated method stub
		Vector<tache> list = new Vector<>();
		String req = "SELECT * FROM tache where id_employe='"+id_employe+"'  and etat='valider'";
		String data[][] = db.selectQuery2(req);
		if (data == null) return list;
		
		for (int i = 0; i < data.length; i++) {
			tache t = new tache(data[i]);
			list.add(t);
		}
		return list;
	}

	@Override
	public void validerTache(String id, int id_dossier) {
		// TODO Auto-generated method stub
		db.executUpdate("update tache set etat='valider' where id="+id);
		db.executUpdate("update tache set ordre=ordre-1 where id_dossier="+id_dossier);
	}
	

}

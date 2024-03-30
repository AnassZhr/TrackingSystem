package com.jee.dao;

import java.util.List;
import java.util.Vector;

import mrtier.entities.dossier;

public class DossierDaoJdbc implements DossierDao {
	private Database db;

	public DossierDaoJdbc() {
		super();
	}

	public DossierDaoJdbc(Database db) {
		super();
		this.db = db;
	}

	public void setDatabase(Database db) {
		this.db = db;
	}
	@Override
	public int insert(dossier Dossier) {
		String row[] = {
				Dossier.getId()+"",
				Dossier.getObjet(),
				Dossier.getDescription(),
			    Dossier.getId_client()+"",
			    Dossier.getNumTracking(),
			};
			return db.insert("dossier", row);
	}

	@Override
	public dossier select(String id) {
		String row[] = db.select("dossier", "id", id);
		if (row == null) return null;
		dossier d = new dossier(row);
		return d;
		
	}
	public dossier selectNumTracking(String numTracking) {
		String row[] = db.select("dossier", "numTracking", numTracking);
		if (row == null) return null;
		dossier d = new dossier(row);
		return d;
		
	}

	@Override
	public List<dossier> selectAll() {
		Vector<dossier> list = new Vector<>();
		String data[][] = db.select("dossier");
		if (data == null) return list;
		
		for (int i = 0; i < data.length; i++) {
			dossier d = new dossier(data[i]);
			list.add(d);
		}
		return list;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		db.delete("dossier","id",id);
	}

	@Override
	public int updateDossier(dossier Dossier) {
		return db.executUpdate("update dossier set objet='"+Dossier.getObjet()+"' , description='"+Dossier.getDescription() +"' , id_client='"+Dossier.getId_client() +"' , numTracking='"+Dossier.getNumTracking()+"' where id='"+Dossier.getId() +"'");
	}

	@Override
	public float getProgression(int id_dossier) {
	String[] t =db.selectQuery("select count(*) from tache where id_dossier="+id_dossier);
	float nb=Float.parseFloat(t[0]);
	System.out.println("nb tache= "+nb);
	String[] t1 =db.selectQuery("select count(*) from tache where id_dossier="+id_dossier +" and etat='valider'");
	
	float nbv=Float.parseFloat(t1[0]);
	System.out.println("nb tache valide= "+nbv);		
		return nbv/nb;
	}

}

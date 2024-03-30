package com.jee.dao;

import java.util.List;

import mrtier.entities.dossier;

public interface DossierDao {
	public int insert(dossier Dossier);
	public dossier select(String id);
	public List<dossier> selectAll();
	public void delete(String id);
	public int updateDossier(dossier d);
	float getProgression(int id_dossier);
	public dossier selectNumTracking(String numTracking);

}

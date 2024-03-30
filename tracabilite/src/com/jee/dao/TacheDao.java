package com.jee.dao;

import java.util.List;


import mrtier.entities.tache;

public interface TacheDao {
	public int insert(tache Tache);
	public tache select(String id);
	public List<tache> selectAll();
	public void delete(String id);
	public int updateTache(tache Tache);
	public List<tache> tachesParDossier(String id_dossier);
	public List<tache> tachesParEmploye(String id_employe);
	public void validerTache(String id, int id_dossier);
	public List<tache> tachesParEmployeOrdre(String id_employe);
	public List<tache> tachesValider(String id_employe);

}

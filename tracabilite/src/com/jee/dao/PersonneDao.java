package com.jee.dao;

import java.util.List;

import mrtier.entities.personne;

public interface PersonneDao {
	public int insert(personne personne);
	public personne select(String id);
	public List<personne> selectAll();
	public void delete(String id);
	public int updatePersonne(personne Personne);


}

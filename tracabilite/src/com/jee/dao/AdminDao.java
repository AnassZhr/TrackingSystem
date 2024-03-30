package com.jee.dao;

import java.util.List;

import mrtier.entities.admin;

public interface AdminDao {
	
	public int insert(admin Admin);
	public admin select(String id);
	public List<admin> selectAll();
	public void delete(String id);
	public int updateAdmin(admin Admin);
	public admin authentificationAdmin(String email , String password);

}

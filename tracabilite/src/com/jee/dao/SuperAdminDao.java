package com.jee.dao;

import java.util.List;

import mrtier.entities.superAdmin;

public interface SuperAdminDao {
	
	public int insert(superAdmin SuperAdmin);
	public superAdmin select(String id);
	public List<superAdmin> selectAll();
	public void delete(String id);
	public int updateSuperAdmin(superAdmin SuperAdmin);

}

package com.jee.dao;

import java.util.List;


import mrtier.entities.employe;

public interface EmployeDao {
	public int insert(employe Employe);
	public employe select(String id);
	public List<employe> selectAll();
	public void delete(String id);
	public int updateEmploye(employe Employe);
	public employe authentificationEmploye(String email , String password);

}

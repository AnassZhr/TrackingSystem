package com.jee.dao;

import java.util.List;

import mrtier.entities.client;

public interface ClientDao {
	public int insert(client Client);
	public client select(String id);
	public List<client> selectAll();
	public void delete(String id);
	public int updateClient(client Client);

}

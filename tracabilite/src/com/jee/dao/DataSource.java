package com.jee.dao;

import java.sql.Connection;

import java.sql.DriverManager;

public class DataSource {
	private String url;
	private String driver;
	private String user;
	private String password;
	
	public DataSource() {
	}

	public DataSource(String url, String driver, String user, String password) {
		super();
		this.url = url;
		this.driver = driver;
		this.user = user;
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Connection getConnection() {
		try {
			//1. Chargement du Driver
			Class.forName(driver);
			//2. Etablissement de la connexion
			Connection db = DriverManager.getConnection(url, user, password);
			System.out.println("Connexion bien établie");
		//	DatabaseMetaData dbm = db.getMetaData();
			//dbm.getTables(arg0, arg1, arg2, arg3)
			return db;
		}
		catch(Exception e) {
			System.out.println("Erreur : " + e.getMessage());
			return null;
		}
	}
}

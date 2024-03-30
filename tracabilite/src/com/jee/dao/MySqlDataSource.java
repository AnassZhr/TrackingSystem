package com.jee.dao;

public class MySqlDataSource extends DataSource {
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String bridge = "jdbc:mysql:";
	
	public MySqlDataSource(String host, String source, String user, String password) {
		super(bridge + "//" + host + "/"+source, driver, user, password);
	}
	
	public MySqlDataSource(String source, String user, String password) {
		super(bridge + "//localhost/"+source , driver, user, password);
	}
	
	public MySqlDataSource(String source, String user) {
		super(bridge + "//localhost/" + source, driver, user, "");
	}
	
	public MySqlDataSource(String source) {
		super(bridge + "//localhost/" + source, driver, "root", "");
	}
}

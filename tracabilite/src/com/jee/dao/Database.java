package com.jee.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Database {
	private DataSource dataSource;
	
	private Connection db;
	
	public Database() {
	}
	
	public Database(DataSource dataSource) {
		setDataSource(dataSource);
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		db = dataSource.getConnection();
	}
/*
	public void testSelect() {
		String req = "SELECT * FROM Produit";
		try {
			Statement sql = db.createStatement();
			ResultSet rs = sql.executeQuery(req);
			while (rs.next()) {
				for (int i = 1; i<= 4; i++) {
					System.out.print("\t" + rs.getString(i));
				}
				System.out.println();
			}
			rs.close();
		}
		catch(Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}
*/
	public String []select(String tableName, String key, String value) {
		String req = "SELECT * FROM " + tableName + " WHERE " + key + "='" + value + "'";
		try {
			Statement sql = db.createStatement();
			ResultSet rs = sql.executeQuery(req);
			ResultSetMetaData rsm = rs.getMetaData();
			String row[] = new String[rsm.getColumnCount()];
			if (rs.next()) {
				for (int i = 1; i<= rsm.getColumnCount(); i++) {
					row[i-1] = rs.getString(i);
				}
				rs.close();
				return row;
			}
			rs.close();
		}
		catch(Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
		return null;
	}
	public String []selectQuery(String query) {

		try {
			Statement sql = db.createStatement();
			ResultSet rs = sql.executeQuery(query);
			ResultSetMetaData rsm = rs.getMetaData();
			String row[] = new String[rsm.getColumnCount()];
			if (rs.next()) {
				for (int i = 1; i<= rsm.getColumnCount(); i++) {
					row[i-1] = rs.getString(i);
				}
				rs.close();
				return row;
			}
			rs.close();
		}
		catch(Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
		return null;
	}
	
	public String[][]select(String tableName) {
		String req = "SELECT * FROM " + tableName;
		try {
			Statement sql = db.createStatement();
			ResultSet rs = sql.executeQuery(req);
			ResultSetMetaData rsm = rs.getMetaData();
			int cols = rsm.getColumnCount();
			rs.last();
			int rows = rs.getRow();
			rs.beforeFirst();
			String data[][] = new String[rows][cols];
			int row = 0;
			while (rs.next()) {
				for (int i = 1; i<= cols; i++) {
					data[row][i-1] = rs.getString(i);
				}
				row++;
			}
			rs.close();
			return data;
		}
		catch(Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
		return null;
	}
	public String[][]selectByKey(String tableName,String key,String value) {
		String req = "SELECT * FROM " + tableName +" where "+key+"='"+value+"'";
		System.out.println(req);
		try {
			Statement sql = db.createStatement();
			ResultSet rs = sql.executeQuery(req);
			ResultSetMetaData rsm = rs.getMetaData();
			int cols = rsm.getColumnCount();
			rs.last();
			int rows = rs.getRow();
			rs.beforeFirst();
			String data[][] = new String[rows][cols];
			int row = 0;
			while (rs.next()) {
				for (int i = 1; i<= cols; i++) {
					data[row][i-1] = rs.getString(i);
				}
				row++;
			}
			rs.close();
			return data;
		}
		catch(Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
		return null;
	}
	public String[][]selectQuery2(String req) {
		
		System.out.println(req);
		try {
			Statement sql = db.createStatement();
			ResultSet rs = sql.executeQuery(req);
			ResultSetMetaData rsm = rs.getMetaData();
			int cols = rsm.getColumnCount();
			rs.last();
			int rows = rs.getRow();
			rs.beforeFirst();
			String data[][] = new String[rows][cols];
			int row = 0;
			while (rs.next()) {
				for (int i = 1; i<= cols; i++) {
					data[row][i-1] = rs.getString(i);
				}
				row++;
			}
			rs.close();
			return data;
		}
		catch(Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
		return null;
	}

	public int insert(String tableName, String row[]) {
		try {
			StringBuffer req = new StringBuffer("INSERT INTO " + tableName + " VALUES(");
			req.append("'" + row[0] + "'");
			for (int i = 1; i < row.length; i++) {
				req.append("," + "'" + row[i] + "'");
			}
			req.append(")");
			System.out.println(req);
			Statement sql = db.createStatement();
			return sql.executeUpdate(req.toString());
		}
		catch(Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
		return 0;
	}
	public int delete(String tableName, String key,String value) {
		try {
			String req = "delete from "+tableName +" where "+key+"='"+value+"'";
			
	
			System.out.println(req);
			Statement sql = db.createStatement();
			return sql.executeUpdate(req);
		}
		catch(Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
		return 0;
	}
	public int executUpdate(String query) {
		try {
		
			
	
			System.out.println(query);
			Statement sql = db.createStatement();
			return sql.executeUpdate(query);
		}
		catch(Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
		return 0;
	}
}

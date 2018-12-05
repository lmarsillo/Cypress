package org.cypress;

import java.sql.*;

public class QueryHandler {

	Connection dbConnect;
	Statement sqlStatement;
	String sql;
	ResultSet results;// = null;
	MapPanel object;
	
	
	public Statement dbInitConnect() {
		try {
			Class.forName("org.sqlite.JDBC");
			dbConnect = DriverManager.getConnection("jdbc:sqlite:cypress.db");
			dbConnect.setAutoCommit(false);
			sqlStatement = dbConnect.createStatement();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return sqlStatement;
	}

	public boolean loginQuery(String login, String pass) {
		boolean matchFound = false;
		dbInitConnect();
		sql = "SELECT * FROM ACCOUNT WHERE LOGIN = '" + login
				+ "'" + "AND PASSWORD = '" + pass + "';";
		try {
		results = sqlStatement.executeQuery(sql);
			while (results.next()) {
				int id = results.getInt("accountid");
				String l = results.getString("login");
				String p = results.getString("password");

				matchFound = true;
			}
			results.close();
			sqlStatement.close();
			dbConnect.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		if (!matchFound) {
			return false;
		}
		return matchFound;
	}
	
	
	
	
	
	
	
	
	public void selectFlags(MapPanel panel) {
		
		
		dbInitConnect();
		sql = "SELECT * FROM PROBLEM;";
		
		try {
			//object = MapPanel.getInstance();
			
			
			results = sqlStatement.executeQuery(sql);
			while (results.next()) {
				int xPos = results.getInt("xcoord");
				int yPos = results.getInt("ycoord");
				String type = results.getString("type");
				int priority = results.getInt("priority");
				String status = results.getString("status");
				int reported = results.getInt("reported");
				String description = results.getString("description");

				ProblemFlag f = new ProblemFlag(type, xPos, yPos, priority,
						status, reported, description);
				panel.drawFlag(f);
				System.out.println("record: " + type + "." + xPos + "." + yPos + "." + priority
						 + "." + status + "." + reported + "." + description);
				
			}
			results.close();
			sqlStatement.close();
			dbConnect.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
	
	public void insertProblem(String type, int x, int y, int priority, String status, int reported, String description) {
		dbInitConnect();
		sql = "INSERT INTO PROBLEM (TYPE,XCOORD,YCOORD,PRIORITY,STATUS,REPORTED,DESCRIPTION)"
				+ "VALUES ("
				+ "'" + type + "',"
				+ x + ","
				+ y + ","
				+ priority + ","
				+ "'" + status + "',"
				+ reported + ","
				+ "'" + description + "');";
		try {
			sqlStatement.executeUpdate(sql);
			dbConnect.commit();
			sqlStatement.close();
			dbConnect.close();
			
			object = MapPanel.getInstance();
			//selectFlags(object);
			
			ProblemFlag f = new ProblemFlag(type, x, y, priority, status, reported, description);
			object.drawFlag(f);
			System.out.println("NEW: " + type + "." + x + "." + y + "." + priority
					 + "." + status + "." + reported + "." + description);
			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
	
}
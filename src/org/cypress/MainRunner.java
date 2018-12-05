package org.cypress;

import javax.swing.JFrame;


//idea: check for db existing & then create if not there?
import java.sql.*;

public class MainRunner {

	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.setVisible(true);

		
		
		/*
		
		Connection dbConnect = null;
		Statement sqlStatement = null;
		String sql;
		try {
			Class.forName("org.sqlite.JDBC");
			dbConnect = DriverManager.getConnection("jdbc:sqlite:cypress.db");
			dbConnect.setAutoCommit(false);
			System.out.println("Opened database successfully");
			sqlStatement = dbConnect.createStatement();
			
			
			sql = "CREATE TABLE ACCOUNT ("
					+ " ACCOUNTID INTEGER PRIMARY KEY	AUTOINCREMENT,"
					+ " FIRSTNAME	TEXT	NOT NULL, "
					+ " LASTNAME	TEXT	NOT NULL, "
					+ " LOGIN	TEXT	NOT NULL, "
					+ " PASSWORD	TEXT	NOT NULL )";
			sqlStatement.executeUpdate(sql);
			
			sql = "CREATE TABLE PROBLEM ("
					+ " PROBLEMID INTEGER PRIMARY KEY	AUTOINCREMENT,"
					+ " AID INTEGER, "
					+ " TYPE	TEXT	NOT NULL, "
					+ " XCOORD	INTEGER	NOT NULL, "
					+ " YCOORD	INTEGER	NOT NULL, "
					+ " PRIORITY	INTEGER	NOT NULL, "
					+ " SUBSCRIBED	TEXT, "	//list of comma delimited emails subscribed
					+ " STATUS	TEXT	NOT NULL, "	//false report, unverified, verified, dispatched
					+ " REPORTED	INTEGER	NOT NULL, "	//number of seconds since 1970
					+ " DESCRIPTION	TEXT	NOT NULL, "
					+ "FOREIGN KEY(AID) REFERENCES ACCOUNT(ACCOUNTID) );";	//use for authority contacted
			sqlStatement.executeUpdate(sql);
			
			sql = "CREATE TABLE AUDIT ("
					+ " AUDITID INTEGER PRIMARY KEY	AUTOINCREMENT,"
					+ " AID INTEGER NOT NULL, "
					+ " PID	INTEGER	NOT NULL, "
					+ "FOREIGN KEY(AID) REFERENCES ACCOUNT(ACCOUNTID),"
					+ "FOREIGN KEY(PID) REFERENCES PROBLEM(PROBLEMID) );";
			sqlStatement.executeUpdate(sql);
			
			
			// remember to enforce primary key restraint or else crash
			sql = "INSERT INTO ACCOUNT (FIRSTNAME,LASTNAME,LOGIN,PASSWORD) "
					+ "VALUES ('FIRST', 'LAST', 'admin', 'admin0');";
			sqlStatement.executeUpdate(sql);
			
			
			sql = "INSERT INTO PROBLEM (TYPE,XCOORD,YCOORD,PRIORITY,STATUS,REPORTED,DESCRIPTION) "
					+ "VALUES ('Electrical Outage', 386, 156, 1, 'Verified', 24322, 'BLAHBLAH');";
			sqlStatement.executeUpdate(sql);
			
			sql = "INSERT INTO PROBLEM (AID,TYPE,XCOORD,YCOORD,PRIORITY,STATUS,REPORTED,DESCRIPTION) "
					+ "VALUES (1, 'Waterline Failure', 287, 61, 2, 'Unverified', 2433322, 'BLAH33342BLAH');";
			sqlStatement.executeUpdate(sql);
			
			sql = "INSERT INTO PROBLEM (AID,TYPE,XCOORD,YCOORD,PRIORITY,STATUS,REPORTED,DESCRIPTION) "
					+ "VALUES (1, 'Electrical Outage', 596, 128, 3, 'Dispatched', 443222, 'BLAH23423BLAH');";
			sqlStatement.executeUpdate(sql);
			
			sql = "INSERT INTO PROBLEM (TYPE,XCOORD,YCOORD,PRIORITY,STATUS,REPORTED,DESCRIPTION) "
					+ "VALUES ('Sewage Failure', 504, 32, 4, 'Verified', 8743222, 'BLAH23423BLAH');";
			sqlStatement.executeUpdate(sql);
			
			sql = "INSERT INTO PROBLEM (TYPE,XCOORD,YCOORD,PRIORITY,STATUS,REPORTED,DESCRIPTION) "
					+ "VALUES ('Road Work', 293, 525, 5, 'False', 99983222, 'BLAH23423BLAH');";
			sqlStatement.executeUpdate(sql);
			dbConnect.commit();
			
			
			sql = "SELECT * FROM ACCOUNT;";
			ResultSet rs = sqlStatement.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("accountid");
				String l = rs.getString("login");
				String p = rs.getString("password");
				String fn = rs.getString("firstname");
				String ln = rs.getString("lastname");
				System.out.println("---FOUND---");
				System.out.println("ID = " + id);
				System.out.println("login = " + l);
				System.out.println("pass = " + p);
				System.out.println("first = " + fn);
				System.out.println("last = " + ln);
				System.out.println();
			}
			sql = "SELECT * FROM PROBLEM;";
			rs = sqlStatement.executeQuery(sql);
			while (rs.next()) {
				System.out.println("---FOUND---");
				System.out.println("probID = " + rs.getInt("problemid"));
				System.out.println("type = " + rs.getString("type"));
				System.out.println("coord = " + rs.getInt("xcoord") + "," + rs.getInt("ycoord"));
				//System.out.println("priority = " + rs.getInt("priority"));
				//System.out.println("emails = " + rs.getString("subscribed"));
				System.out.println("status = " + rs.getString("status"));
				System.out.println("reported = " + rs.getInt("reported"));
				System.out.println("desc = " + rs.getString("description"));
				System.out.println();
			}
			
			rs.close();
			
			
			sqlStatement.close();
			dbConnect.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		
		
		*/
		
	}

}
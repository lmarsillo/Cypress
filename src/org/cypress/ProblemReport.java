package org.cypress;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ProblemReport
{	
	// Problem Report Details
	private String problemType; 
	private String firstName;
	private String lastName;
	private String email;
	private Date date;
	private DateFormat df;
	private String time;
	private String description;
	private int x;
	private int y;
	private int priority;
	private QueryHandler queryDB = new QueryHandler();
	
	public ProblemReport()
	{
		problemType = "";
		firstName = "";
		lastName = "";
		email = "";
	    date = Calendar.getInstance().getTime();
	    df = new SimpleDateFormat("EEE, MMM dd YY HH:mm");
	    time = df.format(date);
	    x = -1;
	    y = -1;
	}
	
	// Print the report
	public void printReport()
	{
		System.out.println("-----Report Details-----");
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Date: " + time);
		System.out.println("Location: " + x + ", " + y);
		System.out.println("Email: " + email);
		System.out.println("Problem Type: " + problemType);
		System.out.println("Description: " + description);
		
		//need to make time compatible with SQLite format
		//need to feed in priority calculation (currently setting all to 1)
		//the x & y coordinates are relative to the frame, and not the map panel
		//	x seems to be off by a little (5) but y is off by approx 170..
		//	taking off the difference for now
		queryDB.insertProblem(problemType, (x-5), (y-170), 1, "Unverified", 60, description);
		
	}
	
	// All the setter and getter methods
	public void setProblemType(String problemType)
	{
		this.problemType = problemType;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public void setXY(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public String getProblemType()
	{
		return problemType;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public String getDate()
	{
		return time;
	}
}
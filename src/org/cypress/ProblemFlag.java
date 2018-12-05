package org.cypress;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ProblemFlag extends JLabel {
	private static final long serialVersionUID = 1L;
	private String path = "/resources/flag.png";
	private ImageIcon flag = new ImageIcon(getClass().getResource(path));
	public String type;
	private int xPos;
	private int yPos;
	private int priority;
	private String subscribed;
	private String status;
	private int reportedTime;
	private String description;
	//private String firstName;
	//private String lastName;
	//private String email;
	//private Date date;
	//private DateFormat df;
	//private String time;
	
	class FlagMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent event) {
			// TODO Auto-generated method stub
			System.out.println(type + " " + event.getX() + " " + event.getY() + " " + priority);
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	public ProblemFlag(String type, int x, int y, int priority, String status, int reported, String description) {
		this.type = type;
		xPos = x;
		yPos = y;
		setPriority(type);
		this.status = status;
		reportedTime = reported;
		this.description = description;
		setFlagColor(status);
		
		MouseListener listener = new FlagMouseListener();
		addMouseListener(listener);
	}
	
	public int getPriority(){
		return priority;
	}
	
	public int getXMap() {
		return xPos;
	}
	
	public int getYMap() {
		return yPos;
	}
	
	public void setXY(int x, int y) {
		xPos = x;
		yPos = y;
	}
	
	public void setPriority(String type) {
		//arbitrarily chose priority numbers. Priority number also depends on date added, so will have to compare to other reports in db
		switch (type){
		case "Electrical Outage":
			priority = 1;
			break;
		case "Waterline Failure":
			priority = 2;
			break;
		case "Sewage Failure":
			priority = 3;
			break;
		case "Road Work":
			priority = 4;
			break;
		case "Other":
			priority = 5;
			break;
		}
	}
	
	public void setFlagColor(String status) {
		switch (status) {
		case "Verified":
			path = "/resources/redFlag.png";
			break;
		case "Unverified":
			path = "/resources/greenFlag.png";
			break;
		case "Dispatched":
			path = "/resources/blueFlag.png";
			break;
		case "False":
			path = "/resources/greyFlag.png";
			break;
		default:
			break;
		}
		flag = new ImageIcon(getClass().getResource(path));
		setIcon(flag);
	}
	
}
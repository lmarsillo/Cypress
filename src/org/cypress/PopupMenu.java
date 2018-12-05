package org.cypress;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PopupMenu extends JPopupMenu
{
	private JMenuItem item;
	private int x, y;
	
	public PopupMenu()
	{
		// Make a popup menu with new problem report option
		item = new JMenuItem("New Problem Report", new ImageIcon("./src/resources/report_icon.png"));
		
		ActionListener menuListener = new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				ProblemReport report = new ProblemReport();
				report.setXY(x, y);
				
				// Make a problem report window, save all data
				try 
				{
		            ReportWindow dialog = new ReportWindow(report);
		            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		            dialog.setVisible(true);
		        } 
				catch (Exception e) 
				{
		            e.printStackTrace();
		        }
		    }
		};
		item.addActionListener(menuListener);
		add(item);
	}
	
	public void setXY(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}

class PopupMenuListener extends MouseAdapter
{
	private PopupMenu menu;
	private Robot robot;
	private Color colour;
	
	public PopupMenuListener(PopupMenu menu)
	{
		this.menu = menu;
		try 
		{
			robot = new Robot();
		} 
		catch (AWTException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void mousePressed(MouseEvent e) 
	{
		checkPopup(e);
	}

	public void mouseClicked(MouseEvent e) 
	{
		checkPopup(e);
	}
	
	public void mouseReleased(MouseEvent e)
	{
		checkPopup(e);
	}
	
	// Popup menu if the conditions are met
	private void checkPopup(MouseEvent e) 
	{
		Point p = e.getLocationOnScreen();
		if (e.isPopupTrigger() && condition(p.x, p.y))
			menu.show(e.getComponent(), e.getX(), e.getY());
	}
	
	// Check if robot is on a 'white' pixel
	public boolean condition(int x, int y)
	{
		colour = robot.getPixelColor(x, y);
		int r = colour.getRed();
		int g = colour.getGreen();
		int b = colour.getBlue();
		int white = 255;
		int grey = 240;
		if(r <= white && g <= white && b <= white && r >= grey && g >= grey && b >= grey)
		{
			menu.setXY(x, y);
			return true;
		}
		return false;
	}
}
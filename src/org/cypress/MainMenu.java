package org.cypress;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu extends JPanel implements ActionListener {
protected JButton b1,b2,b3;
	public MainMenu() {
		
		super(new BorderLayout());
		setPreferredSize(new Dimension(750, 590));
		
		//make the menu instead of the map
		JPanel buttons = new JPanel();
		final JButton b1 = new JButton("Map");
		final JButton b2 = new JButton("About");
		
		final JButton b3 = new JButton("Report an Issue");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		buttons.add(b1);
		buttons.add(b2);
		buttons.add(b3);
	        
	        add(buttons);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String action = e.getActionCommand();
		if(action.equals("Map")){
			//when map button is pushed it coverts the bottom side
			//to the map like the original code
			MapPanel mapPanel = MapPanel.getInstance();
			add(mapPanel, BorderLayout.SOUTH);
			
			PopupMenu menu = new PopupMenu();
			mapPanel.addMouseListener(new PopupMenuListener(menu));
			revalidate();
		}
		if(action.equals("About")){
			
			
			// the about button just describes the program
			//and make new panel appear
			
			JFrame panel = new JFrame();
			panel.setVisible(true);
			panel.setTitle("About The Program");
			panel.setResizable(false);
			panel.setSize(500, 150);
			
			
			String info = " This is a program which allows a user to see "+
						  " and report problems within the city."+
						  " Anyone can access it but only users with a Civil "+
						  " servant account can change anything major.";
			JLabel label = new JLabel("<html>"+info+"</html>");
			panel.add(label,BorderLayout.CENTER);
		}
		if(action.equals("Report an Issue")){
			
		}
	}
}
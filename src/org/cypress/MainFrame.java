package org.cypress;

import java.awt.*;
import javax.swing.JFrame;

/*
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import javax.swing.ImageIcon;
*/


public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	// Constant height + width of the frame
	private static final int FRAME_WIDTH = 750;
	private static final int FRAME_HEIGHT = 750;

	/**
	 * Constructs the frame.
	 */
	public MainFrame() {
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Cypress System");
		setResizable(false);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);

		HeaderPanel mainPanel = new HeaderPanel();
		add(mainPanel, BorderLayout.NORTH);

		LoginPanel loginPanel = new LoginPanel();
		add(loginPanel, BorderLayout.CENTER);

		MainMenu mainMenu = new MainMenu();
		add(mainMenu,BorderLayout.SOUTH);
		
		//moved the code to MainMenu, and implemented it to the map
		//button
		
		//MapPanel mapPanel = new MapPanel(); 
		//add(mapPanel, BorderLayout.SOUTH);
		
		//PopupMenu menu = new PopupMenu();
		//mapPanel.addMouseListener(new PopupMenuListener(menu));
	}
}
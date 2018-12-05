package org.cypress;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel loginLabel = new JLabel("Login ID: ");
	private JLabel passLabel = new JLabel("Password: ");
	private JTextField loginField = new JTextField(20);
	private JPasswordField passField = new JPasswordField(20);
	private JButton buttonLogin = new JButton("Login");
	private JButton buttonLogout = new JButton("Logout");
	private JLabel logStatus = new JLabel("");
	private GridBagConstraints constraints = new GridBagConstraints();
	private QueryHandler queryDB = new QueryHandler();

	// Listener for the login button
	class loginListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String loginEntered = loginField.getText();
			String passEntered = String.valueOf(passField.getPassword());

			validateLogin(loginEntered, passEntered);
		}
	}

	// Listener for the logout button
	class logoutListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			logStatus.setText("");
			notLoggedInLayout();
		}
	}

	public LoginPanel() {
		super(new GridBagLayout());
		setPreferredSize(new Dimension(750, 100));
		notLoggedInLayout();
		setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
		
		// Add listeners to components
		ActionListener loginListener = new loginListener();
        buttonLogin.addActionListener(loginListener);     
        ActionListener logoutListener = new logoutListener();
        buttonLogout.addActionListener(logoutListener);
	}

	// Customizes the panel to the view when a user is logged in
	public void notLoggedInLayout() {
		clearGrid();
		constraints.anchor = GridBagConstraints.NORTHWEST;
		// Padding of 1 pixel left & 5 pixels bottom.
		constraints.insets = new Insets(1, 5, 0, 0);
		setGridPosition(0, 0, loginLabel);
		setGridPosition(1, 0, loginField);
		setGridPosition(0, 1, passLabel);
		setGridPosition(1, 1, passField);
		setGridPosition(0, 2, buttonLogin);
		addWeight();
		setGridPosition(1, 2, logStatus);

		revalidate();
		repaint();
	}

	// Customizes the panel to the view when a user isn't logged in
	public void loggedInLayout() {
		clearGrid();
		
		setGridPosition(0, 0, logStatus);
		addWeight();
		setGridPosition(0, 1, buttonLogout);

		revalidate();
		repaint();
	}

	// Adds components to the panel
	public void setGridPosition(int x, int y, Component field) {
		constraints.gridx = x;
		constraints.gridy = y;
		add(field, constraints);
	}

	

	// Sets weight to 1 so that all components attached to the panel are pushed
	// up; otherwise they'll be centered
	public void addWeight() {
		constraints.weightx = 1;
		constraints.weighty = 1;
	}

	// Removes all components from the panel & sets the weight to 0
		public void clearGrid () {
			constraints.weightx = 0;
			constraints.weighty = 0;
			remove(loginLabel);
			remove(loginField);
			remove(passLabel);
			remove(passField);
			remove(buttonLogin);
			remove(buttonLogout);
			remove(logStatus);
		}
	
	// Updates the text for a successful / unsuccessful login attempt
	public void updateLoginMsg(boolean results, String user) {
		if (results) {
			logStatus.setForeground(Color.BLACK);
			logStatus.setText("Welcome. You are logged in as: " + user);
		} else {
			logStatus.setForeground(Color.RED);
			logStatus.setText("Login or Password is incorrect.");
		}
	}

	// Validates the login credentials against the database
	public void validateLogin(String login, String pass) {
		if (queryDB.loginQuery(login, pass) == true) {
			updateLoginMsg(true, login);
			loginField.setText("");
			passField.setText("");
			loggedInLayout();
		} else {
			updateLoginMsg(false, login);
		}
	}

}
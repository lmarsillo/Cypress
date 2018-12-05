package org.cypress;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EmailPanel extends JPanel
{
	// Labels
	private JLabel emailLabel = new JLabel("Email (Optional):", JLabel.CENTER);
	
	// Fields
	private JTextField email = new JTextField(30);
	
	public EmailPanel()
	{
		setLayout(new BorderLayout());
		
		// Email
		email.setHorizontalAlignment(JTextField.CENTER);

	    // Bottom Panel
		JPanel emailPanel = new JPanel(new BorderLayout());
		emailPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		emailPanel.add(emailLabel, BorderLayout.PAGE_START);
		emailPanel.add(email, BorderLayout.CENTER);
		add(emailPanel, BorderLayout.PAGE_START);
	}
	
	public String getEmail()
	{
		return email.getText();
	}
}
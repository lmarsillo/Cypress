package org.cypress;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InformationPanel extends JPanel
{
	// Labels
	private JLabel firstNameLabel = new JLabel("First Name: ", JLabel.CENTER);
	private JLabel lastNameLabel = new JLabel("Last Name: ", JLabel.CENTER);
	private JLabel firstNameMissing = new JLabel("               ", JLabel.CENTER);
	private JLabel lastNameMissing = new JLabel("               ", JLabel.CENTER);
	private JLabel problemTypeLabel = new JLabel("Problem Type: ", JLabel.CENTER);
	private JLabel dateLabel = new JLabel("Date: ", JLabel.CENTER);
	private JLabel locationLabel = new JLabel("Location: ", JLabel.CENTER);
	
	// Fields
	private JTextField firstName = new JTextField(15);
	private JTextField lastName = new JTextField(15);
	private String[] problemTypes = {"Electrical Outage", "Waterline Failure", "Sewage Failure", "Road Work", "Other"};
	private JComboBox<String> problemType = new JComboBox<String>(problemTypes);
	private JLabel location;
	private JLabel date;
	
	public InformationPanel(ProblemReport report)
	{	
		setLayout(new BorderLayout());
		
		// Name
		firstName.setHorizontalAlignment(JTextField.CENTER);
		lastName.setHorizontalAlignment(JTextField.CENTER);
		firstNameMissing.setHorizontalAlignment(JTextField.CENTER);
		lastNameMissing.setHorizontalAlignment(JTextField.CENTER);
		firstNameMissing.setForeground(Color.RED);
		lastNameMissing.setForeground(Color.RED);
		
		// Problem Type
		DefaultListCellRenderer dlcr = new DefaultListCellRenderer(); 
		dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER); 
		problemType.setRenderer(dlcr);
		
		// Date and location
		date = new JLabel(report.getDate(), JLabel.CENTER);
		location = new JLabel(report.getX() + ", " + report.getY(), JLabel.CENTER);
		
		// Set up for info panel
		JPanel firstNamePanel = new JPanel(new BorderLayout());
		JPanel secondNamePanel = new JPanel(new BorderLayout());
		JPanel topRow = new JPanel(new BorderLayout());
		firstNamePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		secondNamePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		topRow.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		// Add name to panel
		firstNamePanel.add(firstNameLabel, BorderLayout.PAGE_START);
		firstNamePanel.add(firstName, BorderLayout.CENTER);
		firstNamePanel.add(firstNameMissing, BorderLayout.PAGE_END);
		secondNamePanel.add(lastNameLabel, BorderLayout.PAGE_START);
		secondNamePanel.add(lastName, BorderLayout.CENTER);
		secondNamePanel.add(lastNameMissing, BorderLayout.PAGE_END);
		topRow.add(firstNamePanel, BorderLayout.LINE_START);
		topRow.add(secondNamePanel, BorderLayout.LINE_END);
		add(topRow, BorderLayout.PAGE_START);
		
		// Add problem, date, location to panel
		JPanel problemPanel = new JPanel(new BorderLayout());
		JPanel datePanel = new JPanel(new BorderLayout());
		JPanel locationPanel = new JPanel(new BorderLayout());
		JPanel middleRow = new JPanel(new BorderLayout());
		problemPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		datePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		locationPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		middleRow.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		problemPanel.add(problemTypeLabel, BorderLayout.PAGE_START);
		problemPanel.add(problemType, BorderLayout.PAGE_END);
		datePanel.add(dateLabel, BorderLayout.PAGE_START);
		datePanel.add(date, BorderLayout.PAGE_END);
		locationPanel.add(locationLabel, BorderLayout.PAGE_START);
		locationPanel.add(location, BorderLayout.PAGE_END);
		
		// Add everything to info panel
		middleRow.add(datePanel, BorderLayout.LINE_START);
		middleRow.add(locationPanel, BorderLayout.CENTER);
		middleRow.add(problemPanel, BorderLayout.LINE_END);
		add(middleRow, BorderLayout.CENTER);
	}
	
	// All the getters and setters
	
	public String getFirstName()
	{
		return firstName.getText();
	}

	public String getLastName()
	{
		return lastName.getText();
	}
	
	public String getProblemType()
	{
		return problemType.getSelectedItem().toString();
	}
	
	public void setFirstName(String name)
	{
		firstName.setText(name);
	}
	
	public void setLastName(String name)
	{
		lastName.setText(name);
	}
	
	public void setfirstNameMissing(String text)
	{
		firstNameMissing.setText(text);
	}
	
	public void setLastNameMissing(String text)
	{
		lastNameMissing.setText(text);
	}
}
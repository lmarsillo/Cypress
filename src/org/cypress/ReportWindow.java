package org.cypress;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class ReportWindow extends JDialog
{
	// Fields
	private JTextArea description = new JTextArea(2, 5);
	private JButton submitButton = new JButton("Submit");
    private JButton cancelButton = new JButton("Cancel");
	
	public ReportWindow(final ProblemReport report)
	{
		setTitle("Problem Report");
		setBounds(150, 125, 450, 500);
		
		// Text description
		description.setLineWrap(true);
		description.setWrapStyleWord(true);
		
		// Report panel
		final JPanel fullPanel = new JPanel(new BorderLayout());
		final InformationPanel topPanel = new InformationPanel(report);
		final JPanel middlePanel = new JPanel(new BorderLayout());
		final EmailPanel bottomPanel = new EmailPanel();
		
		// Middle Panel
		Border outsideBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		Border insideBorder = BorderFactory.createTitledBorder("Description");
		Border theBorder = BorderFactory.createCompoundBorder(outsideBorder, insideBorder);
		middlePanel.setBorder(theBorder);
		middlePanel.add(description);
		
		JPanel buttonPanel = new JPanel();
	    buttonPanel.add(submitButton);
	    buttonPanel.add(cancelButton);
	    bottomPanel.add(buttonPanel, BorderLayout.PAGE_END);
	    
	    // Submit Button
	    submitButton.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		boolean missing = false;
	    		boolean first = false;
	    		boolean last = false;
	    		
	    		// Report Details
    			report.setFirstName(topPanel.getFirstName());
    			report.setLastName(topPanel.getLastName());
    			report.setProblemType(topPanel.getProblemType());
    			report.setDescription(description.getText());
    			report.setEmail(bottomPanel.getEmail());
    			
    			// If first or last name is null
	    		if(topPanel.getFirstName().equals(""))
	    			first = true;
	    		if(topPanel.getLastName().equals(""))
		    		last = true;
	    		
	    		if(first || last)
	    			missing = true;
	    		
	    		// If first name is null
	    		if(first)
    				topPanel.setfirstNameMissing("*Required Field");
	    		else
    				topPanel.setfirstNameMissing("               ");
	    			
	    		// If last name is null
	    		if(last)
	   				topPanel.setLastNameMissing("*Required Field");
	    		else
	   				topPanel.setLastNameMissing("               ");
	    		
	    		// If name is filled in, submit report
	    		if(!missing)
	    		{
	    			report.printReport();
	    			dispose();
	    		}
	    	}
	    });
		
	    // Cancel Button
	    cancelButton.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		dispose();
	    	}
	    });
	    
		// Add all of them to final panel
		fullPanel.add(topPanel, BorderLayout.PAGE_START);
		fullPanel.add(middlePanel, BorderLayout.CENTER);
		fullPanel.add(bottomPanel, BorderLayout.PAGE_END);
	    getContentPane().add(fullPanel);
	}
}
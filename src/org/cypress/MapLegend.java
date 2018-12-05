package org.cypress;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MapLegend extends JPanel {
	
	private String verifiedFlag = "/resources/redFlag.png";
	private String unverifiedFlag = "/resources/greenFlag.png";
	private String dispatchedFlag = "/resources/blueFlag.png";
	private String falseFlag = "/resources/greyFlag.png";
	private ImageIcon redFlag = new ImageIcon(getClass().getResource(verifiedFlag));
	private ImageIcon greenFlag = new ImageIcon(getClass().getResource(unverifiedFlag));
	private ImageIcon blueFlag = new ImageIcon(getClass().getResource(dispatchedFlag));
	private ImageIcon greyFlag = new ImageIcon(getClass().getResource(falseFlag));
	private JLabel red = new JLabel(redFlag);
	private JLabel green = new JLabel(greenFlag);
	private JLabel blue = new JLabel(blueFlag);
	private JLabel grey = new JLabel(greyFlag);
	private JLabel redFText = new JLabel(" = Verified");
	private JLabel greenFText = new JLabel(" = Unverified");
	private JLabel blueFText = new JLabel(" = Dispatched");
	private JLabel greyFText = new JLabel(" = False Report");
	
	private GridBagConstraints constraints = new GridBagConstraints();
	
	public MapLegend() {
		super(new GridBagLayout());
		setPreferredSize(new Dimension(200, 100));
		setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, Color.BLACK));
		
		constraints.anchor = GridBagConstraints.NORTHWEST;
		// Padding of 1 pixel left & 5 pixels bottom.
		constraints.insets = new Insets(2, 2, 0, 0);
		//setIcon(flag);
		setGridPosition(0, 0, green);
		setGridPosition(1, 0, greenFText);
		setGridPosition(0, 1, red);
		setGridPosition(1, 1, redFText);
		setGridPosition(0, 2, blue);
		setGridPosition(1, 2, blueFText);
		setGridPosition(0, 3, grey);
		//addWeight();
		setGridPosition(1, 3, greyFText);
		

	}
	
	public void setGridPosition(int x, int y, Component field) {
		constraints.gridx = x;
		constraints.gridy = y;
		add(field, constraints);
	}
	
	public void addWeight() {
		constraints.weightx = 1;
		constraints.weighty = 1;
	}
}
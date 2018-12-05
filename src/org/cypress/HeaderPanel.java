package org.cypress;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class HeaderPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel cypressText = new JLabel("CYPRESS");

	
	public HeaderPanel() {
		super(new BorderLayout());
		setPreferredSize(new Dimension(750, 50));
		add(cypressText, BorderLayout.NORTH);
		cypressText.setHorizontalAlignment(SwingConstants.CENTER);
		cypressText.setFont(cypressText.getFont().deriveFont(24.0f));
	}
}

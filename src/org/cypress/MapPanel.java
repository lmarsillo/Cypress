package org.cypress;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLayeredPane;

public class MapPanel extends JLayeredPane {
	private static final long serialVersionUID = 1L;
	private Map torontoMap = new Map();
	private MapLegend legend = new MapLegend();
	private QueryHandler queryDB = new QueryHandler();
		
	//Private constructor combined with getInstance method uses Singleton pattern - There's only 1 map panel
	private MapPanel() {
		setPreferredSize(new Dimension(750, 590));
		add(torontoMap, new Integer(0));
		torontoMap.setBounds(145, 0,  600, 600);
		add(legend, new Integer(0));
		legend.setBounds(0, 0, 145, 200);
		
		
		queryDB.selectFlags(this);
	}
	
	public void drawFlag(ProblemFlag flag) {
		flag.setBounds(flag.getXMap(), flag.getYMap(), 15, 15);
		add(flag, new Integer(1));
		revalidate();
		repaint();
		//System.out.println("draw new flag @ " + flag.getXMap() + "," + flag.getYMap());
	}
	
	
	public void refresh() {
		revalidate();
		repaint();
	}
	
	
	private static volatile MapPanel instance;
	
	public static MapPanel getInstance() {
	    if (instance == null ) {
	       instance = new MapPanel();
	    }

	    return instance;
	}
	
	
	
}
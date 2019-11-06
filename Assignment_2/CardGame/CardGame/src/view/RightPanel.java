package view;

import java.awt.GridLayout;

import javax.swing.JPanel;

import model.interfaces.GameEngine;
import model.interfaces.Player;

public class RightPanel extends JPanel
{	
	private HousePanel housePanel;
	private SummaryPanel summaryPanel;
	
	public RightPanel(Frame frame, GameEngine gameEngine)
	{
		setLayout(new GridLayout(2, 1));
		
		//Create the components
		housePanel = new HousePanel(frame, gameEngine);
		summaryPanel = new SummaryPanel(gameEngine);
		
		//Add the components to the panel
		add(housePanel);
		add(summaryPanel);
	}
	
	public SummaryPanel getSummaryPanel()
	{
		return summaryPanel;
	}

	public HousePanel getHousePanel()
	{
		return housePanel;
	}
	
	public void addPlayer(Player player) //Forward to another method 
	{
		summaryPanel.addPlayer(player);
	}
}
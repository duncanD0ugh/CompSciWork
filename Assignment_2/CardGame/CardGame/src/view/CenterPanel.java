package view;

import java.awt.GridLayout;

import javax.swing.JPanel;

import model.interfaces.GameEngine;
import model.interfaces.Player;

public class CenterPanel extends JPanel
{
	private PlayerContainer playerContainer;
	private RightPanel rightPanel;
	
	public CenterPanel(Frame frame, GameEngine gameEngine)
	{
		setLayout(new GridLayout(1, 2));
		
		playerContainer = new PlayerContainer(frame, gameEngine);
		rightPanel = new RightPanel(frame, gameEngine);
		
		add(playerContainer);
		add(rightPanel);
	}
	
	public RightPanel getRightPanel()
	{
		return rightPanel;
	}
	
	public PlayerContainer getPlayerContainer()
	{
		return playerContainer;
	}
	
	public void swapPlayerPanel(Player player) //Forward to another method
	{
		playerContainer.swapPlayerPanel(player);
	}

	public void addPlayer(Player player) //Forward to another method
	{
		rightPanel.addPlayer(player);
	}
}
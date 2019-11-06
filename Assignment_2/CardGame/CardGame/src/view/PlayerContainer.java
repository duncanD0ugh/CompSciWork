package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.interfaces.GameEngine;
import model.interfaces.Player;

public class PlayerContainer extends JPanel
{
	private PlayerPanel playerPanel;
	private Frame frame;
	private GameEngine gameEngine;
	private Map<Player, PlayerPanel> panels = new HashMap<Player, PlayerPanel>();
	private Player player;
	
	public PlayerContainer(Frame frame, GameEngine gameEngine)
	{
		this.frame = frame;
		Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
		this.setBorder(border);
	}
	
	public PlayerPanel getPlayerPanel()
	{
		return panels.get(player);
	}
	
	public void swapPlayerPanel(Player player) //Change the player panel (When a different player is selected in the combo box)
	{
		Player oldPlayer = frame.getCurrentPlayer();
		PlayerPanel oldPlayerPanel = panels.get(oldPlayer);

		//If the user is changing from a different player panel, remove that panel (to put the newly selected player panel in it's place)
		if(oldPlayerPanel != null)
		{
			remove(oldPlayerPanel);
		}
		
		//Ensure the new player panel exists, if not; make one
		PlayerPanel newPlayerPanel = panels.get(player);
		if(newPlayerPanel == null)
		{
			newPlayerPanel = new PlayerPanel(frame, gameEngine);
			panels.put(player, newPlayerPanel);
		}
		playerPanel = newPlayerPanel;
		this.player = player;
		
		//Add the new player panel
		add(newPlayerPanel, BorderLayout.CENTER);
		this.revalidate();
		this.repaint();
	}
}
package view;

import java.util.Collection;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JToolBar;

import controller.BetButtonListener;
import controller.ComboBoxListener;
import controller.DealButtonListener;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class ToolBar extends JToolBar
{
	private JComboBox<Player> comboBox;
	private GameEngine gameEngine;
	private GUIButton deal, placeBet;
		
	public ToolBar(Collection<Player> players, GameEngine gameEngine, Frame frame)
	{
		this.gameEngine = gameEngine;
		
		//Create the components
		deal = new GUIButton(String.format("%-10s Deal %-10s", "", ""));
		placeBet = new GUIButton(String.format("%-10s Place Bet %-10s", "", ""));
		comboBox = new JComboBox<Player>();		

		//Add the listeners for the components
		deal.addActionListener(new DealButtonListener(gameEngine, frame));
		placeBet.addActionListener(new BetButtonListener(gameEngine, frame));
		comboBox.addActionListener(new ComboBoxListener(frame));
		
		setFloatable(false);
		
		//Adding components to the tool bar
		add(placeBet);
		addSeparator();
		add(deal);
		addSeparator();
		add(comboBox);
	}

	public JComboBox<Player> getComboBox()
	{
		return comboBox;
	}
	
	public GUIButton getDealButton()
	{
		return deal;
	}
	
	public void addPlayer(Player player) //Add a player to the combo box
	{
		comboBox.addItem(player);
		updateComboBox();
		//Set the visible thing in the combo box to the player's name rather than the entire player
		comboBox.setRenderer(new ComboBoxRenderer());
	}
	
	private void updateComboBox() //Every time a (new)player is added to the combo box, remove all old players and 
									//re-add all the players
	{
		//Clear the combo box
		comboBox.removeAllItems();
		
		//Re-populate the combo box with the updated version of ALL players
		for(Player player : gameEngine.getAllPlayers())
		{
			comboBox.addItem(player);;
		}
	}

	public GUIButton getBetButton() 
	{
		return placeBet;
	}
}
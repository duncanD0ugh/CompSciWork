package view;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.AddPlayerListener;
import controller.BetButtonListener;
import controller.ExitActionListener;
import model.interfaces.GameEngine;

public class MenuBar extends JMenuBar
{
	private Menu file, player;
	private JMenuItem addPlayer, exit;

	public MenuBar(GameEngine gameEngine, Frame frame)
	{
		//Construct the different menus
		file = new Menu("File");
		player = new Menu("Player");

		//Add the menus to the menu bar
		add(file);
		add(player);
		
		//Create the menu items for the menus
		exit = new JMenuItem("Exit");
		addPlayer = new JMenuItem("Add Player");
		
		//Add the listeners to the menu items
		addPlayer.addActionListener(new AddPlayerListener(gameEngine, frame));
		exit.addActionListener(new ExitActionListener());
		
		//Add the menu items to appropriate menus
		file.add(exit);
		player.add(addPlayer);
	}
}
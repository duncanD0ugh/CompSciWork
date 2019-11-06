package view;

import view.MenuBar;
import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import model.interfaces.GameEngine;
import model.interfaces.Player;

public class Frame extends JFrame
{
	private ToolBar toolBar;
	private CenterPanel centerPanel;
	private StatusBar statusBar;
	private Player currentPlayer;
	private MenuBar menuBar;
	private Map<Player, Boolean> playerDealtMap = new HashMap<Player, Boolean>();
	private GameEngine gameEngine;
	
	public Frame(GameEngine gameEngine)
	{
		super("SADI Assignment 2");
		this.gameEngine = gameEngine;
		
		setBounds(100, 100, 640, 480);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Create Status Bar
		statusBar = new StatusBar();
		//Set the initial state of the status Bar
		setInitial(gameEngine);
		
		//Create the rest of the components
		centerPanel = new CenterPanel(this, gameEngine);
		toolBar = new ToolBar(gameEngine.getAllPlayers(), gameEngine, this);
		menuBar = new MenuBar(gameEngine, this);

		//Adding components to the frame
		this.setJMenuBar(menuBar);
		add(toolBar, BorderLayout.NORTH);
		add(statusBar, BorderLayout.SOUTH);
		add(centerPanel, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	public Map<Player, Boolean> getPlayerDealtMap()
	{
		return playerDealtMap;
	}
	
	public CenterPanel getCenterPanel()
	{
		return centerPanel;
	}

	public StatusBar getStatusBar() 
	{
		return statusBar;
	}
	
	public ToolBar getToolBar()
	{
		return toolBar;
	}

	public void setCurrentPlayer(Player currentPlayer) 
	{
		this.currentPlayer = currentPlayer;
	}
	
	public Player getCurrentPlayer()
	{
		return currentPlayer;
	}
	
	public void setInitial(GameEngine gameEngine) //Set the initial state of the status bar
	{
		if(gameEngine.getAllPlayers().isEmpty())
		{
			statusBar.setStatusOne("No one is playing");
		}
		
		else
		{
			statusBar.setStatusOne(currentPlayer.getPlayerName() + " is playing");
		}
	}
	
	public void addPlayer(Player player) //Forward to other methods
	{
		centerPanel.addPlayer(player);
		toolBar.addPlayer(player);
	}
	
	public Boolean getPlayerState(Player player) //Return whether the player has been dealt to or not
	{
		return playerDealtMap.get(player);
	}
	
	public void addToPlayerDealtMap(Player player, boolean a) //Add a player to the map, indicating whether they have been dealt to or not
	{
		playerDealtMap.put(player, a);
	}
	
	public Boolean dealHouse() //Check if the house is allowed to deal (i.e. All players have been dealt to)
	{
		for(Player player : gameEngine.getAllPlayers())
		{
			if(!getPlayerState(player))
			{
				return false;
			}
		}
		return true;
	}
}
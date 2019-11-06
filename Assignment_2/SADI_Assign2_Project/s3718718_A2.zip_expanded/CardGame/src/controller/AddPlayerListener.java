package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.Frame;

public class AddPlayerListener implements ActionListener 
{
	private Frame frame;
	private GameEngine gameEngine;
	
	public AddPlayerListener(GameEngine gameEngine, Frame frame)
	{
		this.frame = frame;
		this.gameEngine = gameEngine;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//User inputs player name
		String name = JOptionPane.showInputDialog(JOptionPane.getRootFrame(),"Add player name","Add player",JOptionPane.QUESTION_MESSAGE);
		if(name == null)
		{
			return;
		}
		
		//User inputs player ID
		String id = JOptionPane.showInputDialog(JOptionPane.getRootFrame(),"Enter player ID","Enter ID",JOptionPane.QUESTION_MESSAGE);
		if(id == null)
		{
			return;
		}
		
		//User inputs player points
		String points = JOptionPane.showInputDialog(JOptionPane.getRootFrame(),"Set player points","Set points",JOptionPane.QUESTION_MESSAGE);
		if(points == null)
		{
			return;
		}
		
		//Make a player from the inputs
		Player player = new SimplePlayer(id, name, Integer.valueOf(points));
		
		new Thread()
		{
			@Override
			public void run()
			{
				//Add the player to the collection
				gameEngine.addPlayer(player);
			}
		}.start();
		
		//Note that the player has not been dealt yet
		frame.addToPlayerDealtMap(player, false);
		//Add the player to the necessary GUI components
		frame.addPlayer(player);
	}
}
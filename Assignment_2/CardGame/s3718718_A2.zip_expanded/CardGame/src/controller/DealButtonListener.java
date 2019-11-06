package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.Frame;

public class DealButtonListener implements ActionListener
{
	private GameEngine gameEngine;
	private Frame frame;
	
	public DealButtonListener(GameEngine gameEngine, Frame frame)
	{
		this.gameEngine = gameEngine;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{		
		new Thread()
		{
			@Override
			public void run()
			{
				Player player = gameEngine.getPlayer(frame.getCurrentPlayer().getPlayerId());
				//As soon as the deal button for this player has been clicked, do not allow them to deal again or bet
				frame.getToolBar().getDealButton().setEnabled(false);
				frame.getToolBar().getBetButton().setEnabled(false);
				//Deal the player
				gameEngine.dealPlayer(gameEngine.getPlayer(player.getPlayerId()), 1000);
				//Note that the player has been dealt to
				frame.addToPlayerDealtMap(player, true);
				//Check if the house is allowed to deal (i.e. All players have been dealt to)
				if(frame.dealHouse())
				{
					//Deal the house
					gameEngine.dealHouse(1000);
				}
			}
		}.start();
	}
}
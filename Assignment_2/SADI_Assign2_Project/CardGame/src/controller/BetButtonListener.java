package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import view.Frame;

public class BetButtonListener implements ActionListener 
{
	private Frame frame;
	private GameEngine gameEngine;
	
	public BetButtonListener(GameEngine gameEngine, Frame frame)
	{
		this.frame = frame;
		this.gameEngine = gameEngine;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//User inputs a bet
		String points = JOptionPane.showInputDialog(JOptionPane.getRootFrame(),"Place Bet:","Set Bet",JOptionPane.QUESTION_MESSAGE);
		if(points == null)
		{
			return;
		}
		int bet = Integer.valueOf(points);
		
		//Check if the bet is valid
		if(bet <= 0)
		{
			JOptionPane.showMessageDialog(frame, "ERROR: Bet is less than 0");
		}
		
		//Check if there is a player to put the bet on
		if(frame.getCurrentPlayer() == null)
		{
			JOptionPane.showMessageDialog(frame, "ERROR: Bet is being placed on no player");
		}
		
		//If the bet is valid
		if((frame.getCurrentPlayer() != null) && (bet >= 0))
		{
			new Thread()
			{
				@Override
				public void run()
				{
					//Place the bet on the current player
					gameEngine.getPlayer(frame.getCurrentPlayer().getPlayerId()).placeBet(bet);
				}
			}.start();
		}
	}
}
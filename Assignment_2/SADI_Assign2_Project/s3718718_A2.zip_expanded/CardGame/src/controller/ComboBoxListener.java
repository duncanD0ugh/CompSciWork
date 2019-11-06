package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import model.interfaces.Player;
import view.Frame;
import view.PlayerContainer;

public class ComboBoxListener implements ActionListener
{
	private Frame frame;
	
	public ComboBoxListener(Frame frame)
	{
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//When changing players, allow the player changed to to deal and place a bet
		frame.getToolBar().getDealButton().setEnabled(true);
		frame.getToolBar().getBetButton().setEnabled(true);

		JComboBox<Player> comboBox = (JComboBox<Player>) e.getSource();
		Player currentPlayer = (Player)comboBox.getSelectedItem();
		
		//Check if the player changed to is empty
		if(currentPlayer != null)
		{
			//If the player has already been dealt to
			if(frame.getPlayerState(currentPlayer) == true)
			{
				//Do not allow them to bet or deal again
				frame.getToolBar().getBetButton().setEnabled(false);
				frame.getToolBar().getDealButton().setEnabled(false);
			}
			
			//Update the relevant GUI components of the player changed to
			frame.getStatusBar().setStatusOne(currentPlayer.getPlayerName());
			frame.getCenterPanel().swapPlayerPanel(currentPlayer);
			frame.setCurrentPlayer((Player)currentPlayer);
		}
	}
}
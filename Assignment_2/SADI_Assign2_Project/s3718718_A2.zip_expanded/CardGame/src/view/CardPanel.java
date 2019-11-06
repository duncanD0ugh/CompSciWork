package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.PlayingCard;

public class CardPanel extends JPanel
{
	private JLabel newCard;
	private Frame frame;

	public CardPanel(Frame frame, GameEngine gameEngine)
	{
		this.frame = frame;
		setLayout(new GridLayout(0, 1));
	}
	
	public void addCard(PlayingCard card, Player player) //Ensure that a players cards are not being dealt to another players panel

	{
		Player currentPlayer = (Player) frame.getToolBar().getComboBox().getSelectedItem();
		if(currentPlayer.equals(player))
		{
			//Create and add the card
			Border border = BorderFactory.createRaisedBevelBorder();
			newCard = new JLabel(card.getValue() + " of " + card.getSuit());
			newCard.setBorder(border);
			newCard.setBackground(Color.GRAY);
			add(newCard);
			this.revalidate();
			this.repaint();
		}
	}
	
	public void addCard(PlayingCard card) //House version of addCard() because the house doesn't concern itself with player panels
	{
		//Create and add the card
		Border border = BorderFactory.createRaisedBevelBorder();
		newCard = new JLabel(card.getValue() + " of " + card.getSuit());
		newCard.setBorder(border);
		newCard.setBackground(Color.GRAY);
		add(newCard);
		this.revalidate();
		this.repaint();
	}
}
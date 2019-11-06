package view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.interfaces.GameEngine;
import model.interfaces.PlayingCard;

public class PlayerPanel extends JPanel
{
	private DialogueBox dialogueBox;
	private CardPanel cardPanel;
	
	public PlayerPanel(Frame frame, GameEngine gameEngine)
	{
		setLayout(new BorderLayout());
		
		//Create the components
		dialogueBox = new DialogueBox();
		cardPanel = new CardPanel(frame, gameEngine);
		
		//Add the components to the player panel
		add(cardPanel, BorderLayout.NORTH);
		add(dialogueBox, BorderLayout.SOUTH);
		dialogueBox.append("PLAYER PANEL \n");
	}
	
	public DialogueBox getDialogueBox()
	{
		return dialogueBox;
	}
	
	public CardPanel getCardPanel()
	{
		return cardPanel;
	}
}
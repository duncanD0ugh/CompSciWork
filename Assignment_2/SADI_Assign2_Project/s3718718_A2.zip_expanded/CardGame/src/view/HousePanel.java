package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import model.interfaces.GameEngine;

public class HousePanel extends JPanel 
{
	private DialogueBox dialogueBox;
	private CardPanel cardPanel;

	public HousePanel(Frame frame, GameEngine gameEngine)
	{					
		Border border = BorderFactory.createLineBorder(Color.GRAY, 5);
		this.setBorder(border);
		
		//Create the components
		cardPanel = new CardPanel(frame, gameEngine);
		dialogueBox = new DialogueBox();
		
		//Add the components to the house panel
		add(cardPanel, BorderLayout.SOUTH);
		add(dialogueBox, BorderLayout.NORTH);
		dialogueBox.append("HOUSE PANEL \n");

	}

	public CardPanel getCardPanel()
	{
		return cardPanel;
	}
	
	public DialogueBox getDialogueBox() 
	{
		return dialogueBox;
	}
}
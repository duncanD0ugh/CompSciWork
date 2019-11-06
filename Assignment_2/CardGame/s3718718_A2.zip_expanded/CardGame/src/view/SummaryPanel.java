package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.interfaces.GameEngine;
import model.interfaces.Player;

public class SummaryPanel extends JPanel
{
	private DialogueBox dialogueBox;
	private GameEngine gameEngine;
	
	public SummaryPanel(GameEngine gameEngine)
	{	
		Border border = BorderFactory.createLineBorder(Color.WHITE, 5);
		this.setBorder(border);
		this.gameEngine = gameEngine;
		setBounds(100, 50, 640, 240);
		
		//Create the components
		dialogueBox = new DialogueBox();
		
		//Add the components to the panel
		add(dialogueBox, BorderLayout.CENTER);
		dialogueBox.append("SUMMARY PANEL \n");
	}
	
	public DialogueBox getDialogueBox()
	{
		return dialogueBox;
	}

	public void addPlayer(Player player) //Add a player's information to the panel
	{
		dialogueBox.append(String.format("%-20s \n %-20s %s \n %-20s %s \n", "New Player!", "Player Name:", player.getPlayerName()
				, "Player Points:", player.getPoints()));

		updateSummaryPanel();
	}
	
	private void updateSummaryPanel() //Every time a (new)player's information is added to the panel, remove all old information and 
										//re-append every player's information
	{
		//Clear the dialogue box
		dialogueBox.setText(null);
		
		//Re-populate the dialogue box with the updated version of ALL player's information
		for(Player player : gameEngine.getAllPlayers())
		{
			dialogueBox.append(String.format("%-20s \n %-20s %s \n %-20s %s \n", "New Player!", "Player Name:", player.getPlayerName()
					, "Player Points:", player.getPoints()));
		}
	}
}
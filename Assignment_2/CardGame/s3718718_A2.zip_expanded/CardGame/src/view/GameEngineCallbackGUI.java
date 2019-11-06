package view;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.PlayingCard;
import view.interfaces.GameEngineCallback;

public class GameEngineCallbackGUI implements GameEngineCallback
{
	private Frame frame;
	
	public GameEngineCallbackGUI(GameEngine gameEngine, Frame frame)
	{
		this.frame = frame;
	}
	
	@Override
	public void nextCard(Player player, PlayingCard card, GameEngine engine) {
		frame.getCenterPanel().getPlayerContainer().getPlayerPanel().getCardPanel().addCard(card, player);
	}

	@Override
	public void bustCard(Player player, PlayingCard card, GameEngine engine) {
		frame.getCenterPanel().getPlayerContainer().getPlayerPanel().getCardPanel().addCard(card, player);
		
		//Checking that the text is being appended to the correct player's dialogue box
		Player currentPlayer = (Player) frame.getToolBar().getComboBox().getSelectedItem();
		if(currentPlayer.equals(player))
		{
			frame.getCenterPanel().getPlayerContainer().getPlayerPanel().getDialogueBox().append(String.format("YOU BUSTED!"));
		}
		
		frame.getStatusBar().setStatusTwo(player.getPlayerName());
	}

	@Override
	public void result(Player player, int result, GameEngine engine) {
		frame.getCenterPanel().getRightPanel().getSummaryPanel().getDialogueBox().append(String.format("%s's final result= %d \n", 
				player.getPlayerName(), result));		
	}

	@Override
	public void nextHouseCard(PlayingCard card, GameEngine engine) {
		frame.getCenterPanel().getRightPanel().getHousePanel().getCardPanel().addCard(card);
		frame.getStatusBar().setStatusOne("The House");
	}

	@Override
	public void houseBustCard(PlayingCard card, GameEngine engine) {
		frame.getCenterPanel().getRightPanel().getHousePanel().getCardPanel().addCard(card);
		frame.getCenterPanel().getRightPanel().getHousePanel().getDialogueBox().append(String.format("HOUSE BUSTED!"));
		frame.getStatusBar().setStatusTwo("The House");
	}

	@Override
	public void houseResult(int result, GameEngine engine) {
		frame.getCenterPanel().getRightPanel().getSummaryPanel().getDialogueBox().append(String.format("House's final result= %d \n", result));
		StringBuffer buffer = new StringBuffer();
		buffer.append("Final Player Results \n");
		
		//looping through all the players in the game to append to the string buffer
		for (Player player : engine.getAllPlayers())
		{
			buffer.append(player.toString() + "\n");
		}
		frame.getCenterPanel().getRightPanel().getSummaryPanel().getDialogueBox().append(buffer.toString() + "\n");
		frame.getStatusBar().setStatusThree();
	}
}
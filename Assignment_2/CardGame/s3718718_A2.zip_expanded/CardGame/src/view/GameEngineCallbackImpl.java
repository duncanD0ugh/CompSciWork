package view;

import java.util.logging.Level;
import java.util.logging.Logger;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.PlayingCard;
import view.interfaces.GameEngineCallback;

/**
 * 
 * Skeleton/Partial example implementation of GameEngineCallback showing Java
 * logging behaviour
 * 
 * @author Caspar Ryan
 * @see view.interfaces.GameEngineCallback
 * 
 */
public class GameEngineCallbackImpl implements GameEngineCallback 
{
	private final Logger logger = Logger.getLogger(this.getClass().getName());

	public GameEngineCallbackImpl() 
	{
		logger.setLevel(Level.FINE);
	}

	@Override
	public void nextCard(Player player, PlayingCard card, GameEngine engine) 
	{
		logger.log(Level.FINE, String.format("Card Dealt to %s .. Suit: %s, Value: %s, Score: %s",
				player.getPlayerName(), card.getSuit(), card.getValue(), card.getScore()));
	}

	@Override
	public void result(Player player, int result, GameEngine engine) 
	{
		logger.log(Level.INFO, String.format("%s, final result=%d", player.getPlayerName(), result));
	}

	@Override
	public void bustCard(Player player, PlayingCard card, GameEngine engine) 
	{
		logger.log(Level.FINE, String.format("Card Dealt to %s .. Suit: %s, Value: %s, Score: %s ... YOU BUSTED!",
				player.getPlayerName(), card.getSuit(), card.getValue(), card.getScore()));
	}

	@Override
	public void nextHouseCard(PlayingCard card, GameEngine engine) 
	{
		logger.log(Level.FINE, String.format("Card Dealt to House .. Suit: %s, Value: %s, Score: %s", card.getSuit(),
				card.getValue(), card.getScore()));
	}

	@Override
	public void houseBustCard(PlayingCard card, GameEngine engine) 
	{
		logger.log(Level.FINE, String.format("Card Dealt to House .. Suit: %s, Value: %s, Score: %s ... HOUSE BUSTED!",
				card.getSuit(), card.getValue(), card.getScore()));
	}

	@Override
	public void houseResult(int result, GameEngine engine) 
	{	
		logger.log(Level.INFO, String.format("House, final result=%s", result));
		StringBuffer buffer = new StringBuffer();
		buffer.append("Final Player Results \n");
		
		//looping through all the players in the game to append to the string buffer
		for (Player player : engine.getAllPlayers())
		{
			buffer.append(player.toString() + "\n");
		}
		logger.log(Level.INFO, buffer.toString());
	}
}
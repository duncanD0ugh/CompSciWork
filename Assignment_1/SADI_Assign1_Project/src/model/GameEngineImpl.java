package model;

import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.PlayingCard;
import view.interfaces.GameEngineCallback;

public class GameEngineImpl implements GameEngine
{
	private LinkedList<Player> players = new LinkedList<Player>();
	private LinkedList<PlayingCard> deck = new LinkedList<PlayingCard>();
	private LinkedList<GameEngineCallback> callbacks = new LinkedList<GameEngineCallback>();

	@Override
	public void dealPlayer(Player player, int delay) 
	{
		int total = 0;
		
		//looping/dealing the cards of the deck
		for(PlayingCard card: getShuffledDeck())
		{
			renewDeck(card);
			total += card.getScore();
			
			//actions for when the player does not bust
			if(BUST_LEVEL > total)
			{	
				for(GameEngineCallback callback: callbacks)
				{
					callback.nextCard(player, card, this);
					cardIntermission(delay);
				}
			}
			
			//actions for when the player busts
			else
			{
				for(GameEngineCallback callback: callbacks)
				{
					total -= card.getScore();
					callback.bustCard(player, card, this);
					cardIntermission(delay);
					callback.result(player, total, this);
					player.setResult(total);
				}
				break;
			}
		}
	}

	@Override
	public void dealHouse(int delay) 
	{
		int houseTotal = 0;
		
		//looping/dealing the cards of the deck
		for(PlayingCard card: getShuffledDeck())
		{
			renewDeck(card);
			houseTotal += card.getScore();
			
			//actions for when the house does not bust
			if(BUST_LEVEL > houseTotal)
			{
				for(GameEngineCallback callback: callbacks)
				{
					callback.nextHouseCard(card, this);
					cardIntermission(delay);
				}
			}
			
			//actions for when the house busts/game ends
			else
			{
				for(GameEngineCallback callback: callbacks)
				{
					houseTotal -= card.getScore();
					callback.houseBustCard(card, this);
					cardIntermission(delay);
					
					for(Player player : players)
					{
						if(player.getResult() > houseTotal)
						{
							player.setPoints(player.getPoints() + player.getBet());
						}
						
						else if(houseTotal > player.getResult())
						{
							player.setPoints(player.getPoints() - player.getBet());
						}
						player.resetBet();
					}			
					callback.houseResult(houseTotal, this);
				}
				break;
			}
		}
	}

	@Override
	public void addPlayer(Player player) 
	{
		//Iterate through the collection while there is something still in the collection
		for (Iterator<Player> iterator = players.iterator(); iterator.hasNext();) 
		{
			Player previousPlayer =  iterator.next();
			
			//if the collection has a player with the same ID as the parameter player, remove it and add the parameter player
			if(player.getPlayerId().equals(previousPlayer.getPlayerId()))
			{
				iterator.remove();
			}
		}
		players.add(player);
	}

	@Override
	public Player getPlayer(String id) 
	{
		//loop through the players collection until a player has the same ID as the parameter
		for(Player player: players)
		{
			if(player.getPlayerId().equals(id))
			{
				return player;
			}
		}
		return null;
	}

	@Override
	public boolean removePlayer(Player player) 
	{
		/*loop through the players collection until the collection player matches the parameter, 
		and remove it from the collection*/
		for(Player playerX: players)
		{
			if(player.equals(playerX))
			{
				players.remove(playerX);
				return true;
			}
		}
		return false;
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) 
	{
		callbacks.add(gameEngineCallback);
	}
	
	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) 
	{
		/*loop through the callback collection until the collection callback matches the parameter, 
		and remove it from the collection*/
		for(GameEngineCallback callback: callbacks)
		{
			if(callback.equals(gameEngineCallback))
			{
				callbacks.remove(callback);
				return true;
			}
		}
		return false;
	}

	@Override
	public Collection<Player> getAllPlayers() 
	{
		//Ensuring the returning collection cannot be changed
		return Collections.unmodifiableCollection(players);
	}

	@Override
	public boolean placeBet(Player player, int bet) 
	{
		//looping through the players collection to find the player that matches the parameter
		for(Player collectionPlayer: players)
		{
			if(collectionPlayer.getPlayerId().equals(player.getPlayerId()))
			{
				//forwarding to the SimplePlayer method to handle the bet
				return collectionPlayer.placeBet(bet);
			}
		}
		return false;
	}

	@Override
	public Deque<PlayingCard> getShuffledDeck() 
	{
		deck.clear();
		
		//looping through every value of every suit to add to the deck
		for(PlayingCard.Suit suit: PlayingCard.Suit.values())
		{
			for(PlayingCard.Value value: PlayingCard.Value.values())
			{
				deck.add(new PlayingCardImpl(suit,value));
			}
		}
		Collections.shuffle(deck);					
		return new LinkedList<PlayingCard>(deck);
	}
	
	private void cardIntermission(int delay) //private method to handle activity between cards being dealt
	{
		try 
		{
			Thread.sleep(delay);
		} 
		
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		deck.pop();
	}
	
	private void renewDeck(PlayingCard card) //private method to get a new deck when cards run out
	{
		if(card == null)
		{
			deck = new LinkedList<PlayingCard>(getShuffledDeck());
		}
	}
}
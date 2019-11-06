package model;

import model.interfaces.Player;

public class SimplePlayer implements Player
{
	private String playerName, playerId;
	private int points, bet, result;
	
	public SimplePlayer(String playerId, String playerName, int initialPoints)
	{
		this.playerId = playerId;
		this.playerName = playerName;
		this.points = initialPoints;
	}
	
	@Override
	public String getPlayerName() 
	{
		return playerName;
	}

	@Override
	public void setPlayerName(String playerName) 
	{
		this.playerName = playerName;
	}

	@Override
	public int getPoints() 
	{
		return points;
	}

	@Override
	public void setPoints(int points) 
	{
		this.points = points;
	}

	@Override
	public String getPlayerId() 
	{
		return playerId;
	}

	@Override
	public boolean placeBet(int bet) 
	{
		//checking if the bet is at least 0 and if it is smaller than the player's points
		if((bet >= 0) && (this.points >= bet))
		{
			this.bet = bet;
			return true;
		}
		
		else
		{
			return false;
		}
	}

	@Override
	public int getBet() 
	{
		return bet;
	}

	@Override
	public void resetBet() 
	{
		this.bet = 0;
	}

	@Override
	public int getResult() 
	{
		return result;
	}

	@Override
	public void setResult(int result) 
	{
		this.result = result;
	}
	
	@Override
	public String toString()
	{
		return String.format("Player: id=%s, name=%s, points=%d", playerId, playerName, points);
	}
}
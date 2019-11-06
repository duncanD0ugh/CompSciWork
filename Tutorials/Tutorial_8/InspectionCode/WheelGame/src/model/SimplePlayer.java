package model;

import java.util.Objects;

import model.enumeration.BetType;
import model.interfaces.Player;

public class SimplePlayer implements Player {
	private String playerId;
	private String playerName;
	private int initialPoints;
	private int bet;
	private BetType betType;
	private StringBuilder sb;
	
	public SimplePlayer(String playerId, String playerName, int initialPoints) {
		this.playerId = playerId;
		this.playerName = playerName;
		this.initialPoints = initialPoints;
	}

	@Override
	public String getPlayerName() {
		return this.playerName;
	}

	@Override
	public void setPlayerName(String playerName) {
		this.playerName = playerName;

	}

	@Override
	public int getPoints() {
		return this.initialPoints;
	}

	@Override
	public void setPoints(int points) {
		this.initialPoints = points;
	}

	@Override
	public String getPlayerId() {
		return this.playerId;
	}

	@Override
	public boolean setBet(int bet) {
		if (bet <= initialPoints && bet > 0) {
			this.bet = bet;
			return true;
		}
		return false;
	}

	@Override
	public int getBet() {
		return this.bet;
	}

	@Override
	public void setBetType(BetType betType) {
		this.betType = betType;

	}

	@Override
	public BetType getBetType() {
		return this.betType;
	}

	@Override
	public void resetBet() {
		this.bet = 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(playerId);
	}

	@Override
	public String toString() {
		sb = new StringBuilder();
		return sb.append("player: id=").append(playerId)
				.append(", name: ").append(playerName)
				.append(", bet: ").append(bet)
				.append(", betType: ").append(betType)
				.append(", points: ").append(initialPoints)
				.append('\n')
				.toString();
	}

}

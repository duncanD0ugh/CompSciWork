package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.enumeration.BetType;
import model.enumeration.Color;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.Slot;
import view.interfaces.GameEngineCallback;

public class GameEngineImpl implements GameEngine {
	private int slotInc;
	private List<Slot> wheel;
	private Map<String, Player> players;
	private Set<GameEngineCallback> callbacks;

	public GameEngineImpl() {
		createWheel();
		players = new HashMap<String, Player>();
		callbacks = new HashSet<GameEngineCallback>();
	}

	private void sleeper(int delay) {
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void spin(int initialDelay, int finalDelay, int delayIncrement) {
		int delay = 0;
		Slot otherSlots = null;

		sleeper(initialDelay);

		while (delay <= finalDelay) {
			sleeper(delay);
			if (slotInc == (Slot.WHEEL_SIZE))
				slotInc = (0);
			otherSlots = wheel.get(slotInc++);
			for (GameEngineCallback c : callbacks)
				c.nextSlot(otherSlots, this);
			delay += delayIncrement;
		}

		this.calculateResult(otherSlots);
		for (GameEngineCallback c : callbacks)
			c.result(otherSlots, this);
	}

	@Override
	public void calculateResult(Slot winningSlot) {
		for (Player p : getAllPlayers()) {
			BetType type = p.getBetType();
			if (type != null) {
				type.applyWinLoss(p, winningSlot);
			}
		}
	}

	@Override
	public void addPlayer(Player player) {
		players.put(player.getPlayerId(), player);
	}

	@Override
	public Player getPlayer(String id) {
		return players.get(id);
	}

	@Override
	public boolean removePlayer(Player player) {
		return players.remove(player.getPlayerId(), player);
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		callbacks.add(gameEngineCallback);
	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		return callbacks.remove(gameEngineCallback);
	}

	@Override
	public Collection<Player> getAllPlayers() {
		return Collections.unmodifiableCollection(players.values());
	}

	@Override
	public boolean placeBet(Player player, int bet, BetType betType) {
		if (player.setBet(bet)) {
			player.setBetType(betType);
		}
		return player.setBet(bet);
	}

	@Override
	public Collection<Slot> getWheelSlots() {
		return wheel;
	}

	private void createWheel() {
		int[] num = new int[] { 0, 27, 10, 25, 29, 12, 8, 19, 31, 18, 6, 21, 33, 16, 4, 23, 35, 14, 2, 0, 28, 9, 26, 30,
				11, 7, 20, 32, 17, 5, 22, 34, 15, 3, 24, 36, 13, 1 };
		wheel = new ArrayList<Slot>();
		wheel.add(new SlotImpl(0, Color.GREEN00, 0));
		for (int i = 1; i < Slot.WHEEL_SIZE; i++) {
			wheel.add(new SlotImpl(i,
					(i % (Slot.WHEEL_SIZE / 2) == 0 ? Color.GREEN0 : (i % 2 == 0 ? Color.BLACK : Color.RED)), num[i]));
		}
	}
}

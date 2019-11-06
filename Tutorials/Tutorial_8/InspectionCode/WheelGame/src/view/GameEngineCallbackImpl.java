package view;

import java.util.logging.Level;
import java.util.logging.Logger;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.Slot;
import view.interfaces.GameEngineCallback;

public class GameEngineCallbackImpl implements GameEngineCallback {
	private static final Logger logger = Logger.getLogger(GameEngineCallback.class.getName());

	public GameEngineCallbackImpl() {
		logger.setLevel(Level.FINE);
	}

	@Override
	public void nextSlot(Slot slot, GameEngine engine) {
		logger.log(Level.FINE, slot.toString());
	}

	@Override
	public void result(Slot result, GameEngine engine) {
		String playerResults = null;
		logger.log(Level.INFO, "RESULT="+result.toString()+'\n');
		logger.log(Level.INFO, " FINAL PLAYER POINT BALANCES");
		for (Player player : engine.getAllPlayers()) {
			playerResults = player.toString();
			logger.log(Level.INFO, '\n'+playerResults.toString());
		}
	}
}

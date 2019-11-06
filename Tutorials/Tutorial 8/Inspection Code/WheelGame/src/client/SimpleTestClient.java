package client;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.GameEngineImpl;
import model.SimplePlayer;
import model.enumeration.BetType;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.Slot;
import validate.Validator;
import view.GameEngineCallbackImpl;

public class SimpleTestClient {
	private static final Logger logger = Logger.getLogger(SimpleTestClient.class.getName());

	public static void main(String args[]) {
		final GameEngine gameEngine = new GameEngineImpl();

		Validator.validate(true);

		// create some test players
		Player[] players = new Player[] { new SimplePlayer("1", "Come In Spinner", 1000),
				new SimplePlayer("2", "The Loser", 750), new SimplePlayer("3", "The Dabbler", 500)};

		gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());

		logWheel(gameEngine.getWheelSlots());

		int enumOrdinal = 0;
		for (Player player : players) {
			gameEngine.addPlayer(player);
			gameEngine.placeBet(player, 100, BetType.values()[enumOrdinal++ % BetType.values().length]);
		}

		logger.log(Level.INFO, "SPINNING ...");
		
		gameEngine.spin(1, 200, 4);
	}

	private static void logWheel(Collection<Slot> wheel) {
		logger.log(Level.INFO, "LOGGING WHEEL DATA CREATED BY GameEngineImpl");
		for (Slot slot : wheel)
			logger.log(Level.INFO, slot.toString());
		logger.log(Level.INFO, "END WHEEL LOG\n");
	}
}

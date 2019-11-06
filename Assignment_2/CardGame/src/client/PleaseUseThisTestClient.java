package client;

import model.GameEngineImpl;
import model.interfaces.GameEngine;
import validate.Validator;
import view.Frame;
import view.GameEngineCallbackGUI;
import view.GameEngineCallbackImpl;

public class PleaseUseThisTestClient 
{
	public static void main(String[] args) 
	{
	      final GameEngine gameEngine = new GameEngineImpl();
	      Validator.validate(true);
	      Frame frame = new Frame(gameEngine);
	      gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());
	      gameEngine.addGameEngineCallback(new GameEngineCallbackGUI(gameEngine, frame));
	}
}
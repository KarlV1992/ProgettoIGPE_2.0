package gui.event;

import core.element.character.Direction;
import core.gameManagers.PlayManager;
import gui.singlePlayer.SinglePlayerPane;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyboardPressedEvent implements EventHandler<KeyEvent>{

	private PlayManager manager;
	private SinglePlayerPane gamePane;

	public KeyboardPressedEvent(SinglePlayerPane p) {
		gamePane = p;
		manager = PlayManager.getInstance();
	}

	@Override
	public void handle(KeyEvent event) {
//		System.out.println("ciao");
		KeyCode keyPressed = event.getCode();
		
		switch (keyPressed) {
		case RIGHT:
//			System.out.println("muovo destra");
			manager.movePlayer(Direction.RIGHT);
			break;
		case LEFT:
//			System.out.println("muovo sinistra");
			manager.movePlayer(Direction.LEFT);			
			break;
		case SPACE:
			//manager.movePlayer(Direction.UP);
			manager.playerJump();
			break;
			
		default:
			break;
		}
		
	}
}

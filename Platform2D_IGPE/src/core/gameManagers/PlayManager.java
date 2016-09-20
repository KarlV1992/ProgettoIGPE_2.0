package core.gameManagers;

import java.util.List;

import core.World.AbstractWorld;
import core.World.World;
import core.element.Item;
import core.element.block.Block;
import core.element.character.Direction;
import core.element.character.Player;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;

public class PlayManager {

	private static PlayManager instance;

	private World world;

	private boolean running = false;
	private boolean pause = false;

	private List<Player> players;
	private Player currentPlayer;
	private boolean isDead = false;

	private PlayManager() {
	}

	public static PlayManager getInstance() {
		if (instance == null)
			instance = new PlayManager();

		return instance;
	}

	public void init() {

		world = new AbstractWorld();
		world.loadMap("resources/Levels/levelTest");
		world.initialize();
		this.players = world.getPlayers();

	}

	public void start() {
		running = true;
	}

	public void pause() {
		pause = true;
	}

	public void resume() {
		if (pause)
			pause = false;
	}

	public void update() {
		for (Player player : players) {
			if (!player.isDead()) {
				player.update();
			} else {
				System.out.println("si muartu");
			}
		}

	}

	public void movePlayer(Direction direction) {
		currentPlayer.setDirection(direction);
	}

	public double getLevelWidth() {
		return world.getWidth();
	}

	public double getLevelHeight() {
		return world.getHeight();
	}

	// public List<Block> getBlocks() {
	// return world.getBlocks();
	// }

	public Block[][] getBlocksMatrix() {
		return world.getMatrix();
	}

	public Player getPlayer() {
		return currentPlayer; // temporaneamente null
		// return players;
	}

	public void playerJump() {

		if (currentPlayer.canJump() && currentPlayer.canDoubleJump()) {
			currentPlayer.jump();
		} else if (currentPlayer.canDoubleJump())
			currentPlayer.doubleJump();
	}

	public List<Item> getGemList() {
		return world.getGems();
	}

}

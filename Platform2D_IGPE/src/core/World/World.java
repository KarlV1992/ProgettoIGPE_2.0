package core.World;


import java.util.List;
import core.element.block.Block;
import core.element.character.Character;
import javafx.geometry.Point2D;
import core.element.character.*;

public interface World {
	
	// world size 
	abstract public float getWidth();
	abstract public float getHeight();
	abstract public void setDimension(float h, float w);
	
	// player and enemies
	abstract public Player getPlayer();
	abstract public List<Character> getEnemies();
	
	// world function
	abstract public void initialize();
	abstract public void update();
	abstract public void reset();
	
	// map function
	abstract public void loadMap(String path); // forse non serve ?
	abstract public BlockMap getMap();
	abstract public List<Block> getNearBlocks();
	abstract public Block[][] getMatrix();
	
	abstract public boolean checkPlayerCollision(double x , double y);
	// checkpoint
	
	abstract public Point2D getCheckPoint();
	
	
}

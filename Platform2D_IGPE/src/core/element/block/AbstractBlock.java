package core.element.block;

import core.World.World;
import core.element.Position;
import core.element.character.Character;

public class AbstractBlock implements Block {

	protected double WIDTH = 50;
	protected double HEIGHT = 50;
	protected boolean animated = false;
	private int code;
	private String color;
	protected boolean inside = false;
	protected boolean collided = false;

	protected World world;

	@Override
	public int getCode() {
		return code;
	}

	public double getWIDTH() {
		return WIDTH;
	}

	public double getHEIGHT() {
		return HEIGHT;
	}

	public void setWidth(double width) {
		this.WIDTH = width;
	}

	protected Position position;

	public AbstractBlock(World w, Position position, int code) {
		this.world = w;
		this.position = position;
		this.code = code;
	}

	@Override
	public double getX() {
		return position.getX();
	}

	@Override
	public double getY() {
		return position.getY();
	}

	// il punto in esame appartiene al blocco?
	protected boolean collide(double x, double y, int height, int width) {

		if ((this.position.getX() + WIDTH) < x)
			return false;
		if (this.position.getX() > (x + width))
			return false;
		if ((this.position.getY() + HEIGHT) < y)
			return false;
		if (this.position.getY() > (y + height))
			return false;

		return true;
	}

	@Override
	public boolean collision(double x, double y, int height, int width) {
		return collide(x, y, height, width);
	}

	@Override
	public void setHeight(double d) {
		this.HEIGHT = d;
	}

	@Override
	public void update() {

	}

	@Override
	public void restart() {

	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public boolean isPlayerInsideBlock() {
		return inside;
	}

	@Override
	public void setPlayerState(Character c) {
	}

	@Override
	public boolean isAnimated() {
		return animated;
	}

	@Override
	public void setAnimated(boolean a) {
		animated = a;

	}

	@Override
	public void setX(double x) {
		position.setX(x);

	}

	@Override
	public void setY(double y) {
		position.setY(y);

	}

	@Override
	public int getMovingDirection() {
		return 1;
	}

}

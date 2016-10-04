package core.element.character;

import core.element.Position;

public interface Character {

	public abstract void hurt();

	public abstract boolean isDead();
	
	public abstract void kill();
	
	public abstract void setPosition(Position p);

	public abstract Direction getDirection();

	public abstract void setDirection(Direction direction);

	public abstract double getX();

	public abstract double getY();

	public abstract int getLife();

	public abstract void setLife(int life);

	public abstract int getWidth();

	public abstract int getHeight();

	public abstract int getDamage();
	
	public abstract String getName();

	public abstract void setDamage(int damage);

	public abstract void jump();

	public abstract void doubleJump();

	public abstract void shoot();

	public abstract void hit();

	public abstract void update();
	
	public abstract boolean isJumping();

	public abstract boolean canJump();

	public abstract boolean canDoubleJump();
	
	public abstract boolean isFalling();
	
	public abstract void collectGem();
	public abstract int getCollectedGems();

}

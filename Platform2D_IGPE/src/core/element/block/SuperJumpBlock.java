package core.element.block;

import core.element.Position;
import core.element.character.Character;
import core.element.character.Player;
import core.gameManagers.PlayManager;

public class SuperJumpBlock extends AbstractBlock {

	private double xSuperJump;
	private double ySuperJump;

	public SuperJumpBlock(Position position) {
		super(position, 12);
	}

	@Override
	public boolean collision(double x, double y, int height, int width) {
		if (super.collision(x, y, height, width)) {
			System.out.println("PlayerX: " + x + " PlayerY: " + y+" width: "+width +" height: "+height);
			System.out.println("CuboX: " + this.getX() + " CuboY: " + (this.getY())+" larghezza/altezza "+this.getWIDTH());
			if (x < this.getX() + this.getWIDTH()) {
				xSuperJump = 1;
				System.out.println("sono a destra");
			}
			if (x + width > this.getX()) {
				xSuperJump = -1;
				System.out.println("sono a sinstra");
			}
			if (y + height >= this.getY()) {
				ySuperJump = -1;
				System.out.println("sono sopra");
			}
			if (y <= this.getY() + this.getHEIGHT()) {
				ySuperJump = 1;
				System.out.println("sono sotto");
			}

			animated = true;
		}

		return super.collision(x, y, height, width);
	}

	@Override
	public void setPlayerState(Character c) {
		c.setSuperJumpDirection(xSuperJump, ySuperJump);
		c.superJump();
	}

	@Override
	public void update() {
		/*
		 * if (collided) { animated = true; collided = false; }
		 */

	}
}

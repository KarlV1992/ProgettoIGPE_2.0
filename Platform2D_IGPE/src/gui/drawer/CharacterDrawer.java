package gui.drawer;

import core.element.character.Character;
import core.element.character.Direction;
import gui.animation.CharacterAnimation;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;

public class CharacterDrawer extends ImageView {

	private Character character;
	private CharacterAnimation animation;
	private Direction oldDirection;
	private Rotate rotation = new Rotate();

	public CharacterDrawer(Character c) {
		character = c;
		animation = loadAnimation(c);
		oldDirection = Direction.RIGHT;
		this.getTransforms().add(rotation);
		rotation.setAxis(Rotate.Y_AXIS);
		this.setFitWidth(character.getWidth());
		this.setFitHeight(character.getHeight());
		// TODO Auto-generated constructor stub
	}

	private CharacterAnimation loadAnimation(Character c) {
		String name = "gui.animation." + c.getType() + "Animation";

		Class animation;
		try {

			animation = Class.forName(name);
			return (CharacterAnimation) animation.newInstance();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void draw(){
		this.setLayoutX(character.getX());
		this.setLayoutY(character.getY());
		
		rotation.setPivotX(this.getX()+(character.getWidth()/2));
		
		if(oldDirection == Direction.RIGHT && character.getDirection() == Direction.LEFT){
			rotation.setAngle(180);
			oldDirection = character.getDirection();
		}
		
		if(oldDirection == Direction.LEFT && character.getDirection() == Direction.RIGHT){
			rotation.setAngle(0);
			oldDirection = character.getDirection();
		}
		if (character.isJumping() || character.isDoubleJumping() || character.isSuperJumping()){
			this.setImage(animation.getCharacterJumpAnimation());    
		}else if(character.isFalling()){
			this.setImage(animation.getCharacterFallAnimation());
		}else if(character.getDirection() == Direction.STOP)
			this.setImage(animation.getCharacterIdleAnimation());
		else
			this.setImage(animation.getCharacterMoveAnimation());
	 
	}
}

package gui.element.block;

import core.element.block.Block;
import gui.ImageProvider;

public class EndingLevelBlockGraphic extends AbstractGraphicBlock {

	public EndingLevelBlockGraphic(Block logic) {
		super(logic);
		this.setImage(ImageProvider.getInstance().getSpecialBlock("EndingLevel"));
		this.setFitHeight(130);
		this.setFitWidth(75);
//		this.setLayoutX(getLayoutX() + 30);
		this.setLayoutY(getLayoutY() - 70);
	}

}

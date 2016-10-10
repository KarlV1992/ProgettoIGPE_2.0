package gui.panel.singlePlayer;

import java.util.ArrayList;
import java.util.List;

import gui.ImageProvider;
import gui.panel.AbstractGamePage;
import gui.panel.UpdatablePane;
import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Screen;

public class SelectPlayer extends AbstractGamePage {

//	private Rectangle2D screen = Screen.getPrimary().getBounds();
//	private Rectangle background = new Rectangle(screen.getWidth(), screen.getHeight());
	private List<Image> previews = new ArrayList<>();
	private ImageView preview;
	private ImageView previewBackground = new ImageView();
	private CustomButton leftArrow = new CustomButton(); 
	private CustomButton rightArrow = new CustomButton(); 
	private CustomTextField nameField = new CustomTextField();
	private ImageView next = new ImageView();
	private ImageView back = new ImageView();
//	private Text title = new Text("Select your player");
	private Text t = new Text("Choose Your Name");
	private int previewIndex = 0;
	
	public SelectPlayer() {
//		this.setHeight(screen.getHeight());
//		this.setWidth(screen.getWidth());
		this.preview = new ImageView();
//		this.background.setFill(new ImagePattern(new Image("file:resources/images/SelectPlayerMenu.png")));
//		this.setBackground("SelectPlayerMenu.png");
		this.previewBackground.setImage(new Image("file:resources/images/borderPreview.png"));
		this.leftArrow.setImage(new Image("file:resources/images/leftArrow.png"));
		this.rightArrow.setImage(new Image("file:resources/images/rightArrow.png"));
		this.next.setImage(new Image("file:resources/images/editor/Button_Next.png"));
		this.back.setImage(new Image("file:resources/images/editor/Button_Back.png"));

		previews.add(ImageProvider.getInstance().getImage("previewVincenzo"));
		previews.add(ImageProvider.getInstance().getImage("previewCarlo"));
		previews.add(ImageProvider.getInstance().getImage("previewCiccio"));

		next.setOnMouseClicked(e -> {
			if(!nameField.getText().equals("")){
				System.out.println(nameField.getText());
				System.out.println(previewIndex);
				nextPage();
		}
			else
				System.out.println("stringa vuota");
		});
		this.back.setOnMouseClicked(e -> {
			previousPage();
		});
		leftArrow.setOnMouseClicked(e -> { previewIndex--; previewIndex = (previewIndex == -1 ) ? previews.size()-1 : previewIndex;});
		rightArrow.setOnMouseClicked(e -> { previewIndex++; previewIndex = previewIndex%previews.size();});
		initComponent();
		
		this.getChildren().addAll(title,previewBackground, preview, leftArrow, rightArrow, nameField, t, next, back);
	}

	@Override
	public void update() {
		preview.setImage(previews.get(previewIndex));
	}
	
	private void initComponent(){
		this.title.setText("Select your player");
		this.title.setLayoutX(screen.getWidth()*0.5 - (title.getBoundsInLocal().getWidth()/2));
//		this.previewBackground.setFitHeight(500);
//		this.previewBackground.setFitWidth(500);
		this.previewBackground.setFitHeight(screen.getWidth()*0.3);
		this.previewBackground.setFitWidth(screen.getWidth()*0.3);
//		this.preview.setFitWidth(150);
//		this.preview.setFitHeight(300);
		this.preview.setFitWidth(previewBackground.getFitWidth()*0.3);
		this.preview.setFitHeight(previewBackground.getFitHeight()*0.5);
		this.previewBackground.setLayoutX((screen.getWidth()*0.5) - (previewBackground.getFitWidth()/2));
		this.previewBackground.setLayoutY((screen.getHeight()*0.5) - (previewBackground.getFitHeight()/2));
		this.preview.setLayoutX(previewBackground.getLayoutX() + (previewBackground.getFitWidth()*0.5) - (preview.getFitWidth()/2));
		this.preview.setLayoutY(previewBackground.getLayoutY()  + (previewBackground.getFitHeight()*0.5) - (preview.getFitHeight()/2));
		this.preview.setImage(previews.get(previewIndex));
		this.leftArrow.setLayoutX(previewBackground.getLayoutX() - leftArrow.getFitWidth());
		this.leftArrow.setLayoutY(previewBackground.getLayoutY() + (previewBackground.getFitHeight() * 0.5) - (leftArrow.getFitHeight()/2));
		this.rightArrow.setLayoutX(previewBackground.getLayoutX() + previewBackground.getFitWidth());
		this.rightArrow.setLayoutY(leftArrow.getLayoutY());
		this.t.setFont(FONT_SMALL);
		this.t.setFill(Color.web("#DC8014"));
		this.t.setStroke(Color.BLACK);
		this.t.setLayoutX(screen.getWidth()*0.5 - (t.getLayoutBounds().getWidth()/2));
		this.t.setLayoutY(previewBackground.getLayoutY() + previewBackground.getFitHeight() + 40);
		this.nameField.setLayoutX(screen.getWidth()*0.5 - (nameField.getWidth()/2));
		this.nameField.setLayoutY(previewBackground.getLayoutY() + previewBackground.getFitHeight() + 50);
		this.back.setLayoutX(screen.getWidth()*0.1);
		this.next.setLayoutX(screen.getWidth()*0.8);
		this.back.setLayoutY(screen.getHeight()*0.8);
		this.next.setLayoutY(screen.getHeight()*0.8);
		this.next.setFitWidth(screen.getWidth()*0.08);
		this.next.setFitHeight(screen.getWidth()*0.08);
		this.back.setFitWidth(screen.getWidth()*0.08);
		this.back.setFitHeight(screen.getWidth()*0.08);
		
	}
	
	

}

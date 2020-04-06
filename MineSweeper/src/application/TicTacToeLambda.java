package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToeLambda extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage theStage) {
		GridPane gp = new GridPane();
		XOButton1[][] buttons = new XOButton1[5][3];
		for(int y = 0; y < 5; y++) {
			for(int x = 0; x < 3; x++) {
				buttons[y][x] = new XOButton1();
				XOButton1 b = buttons[y][x];
				b.setOnMouseClicked(e -> {
					MouseButton button = e.getButton();
					System.out.println("Button was " + button);
					
					b.state++;
					b.state %= 3;
					System.out.println(b.state);
					
					switch(b.state) {
					case 0:
						b.setGraphic(b.imageCover);
						break;
					case 1:
						b.setGraphic(b.imageX);
						break;
					case 2:
						b.setGraphic(b.imageO);
						break;
						
					}
				});
				gp.add(b, x, y);
			}
		}
		theStage.setScene(new Scene(gp));
		theStage.show();
	}
}

class XOButton1 extends Button{
	int state; //0 means blank, 1 means X, 2 means O
	ImageView imageCover, imageX, imageO;
	
	public XOButton1() {
		state = 0;
		double size = 100;
		setMinWidth(size);
		setMaxWidth(size);
		setMinHeight(size);
		setMaxHeight(size);
		
		imageCover = new ImageView(new Image("file:res/cover.png"));
		imageX = new ImageView(new Image("file:res/X.png"));
		imageO = new ImageView(new Image("file:res/O.png"));
		
		imageCover.setFitWidth(size);
		imageCover.setFitHeight(size);
		
		imageX.setFitWidth(size);
		imageX.setFitHeight(size);
		
		imageO.setFitWidth(size);
		imageO.setFitHeight(size);
		
		setGraphic(imageCover);
	}
}

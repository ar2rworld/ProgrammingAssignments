 

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToe extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage theStage){
		GridPane gp = new GridPane();
		XOButton buttons[][] = new XOButton[3][3];
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				buttons[i][j] = new XOButton();
				//buttons[i][j].setOnAction(buttons[i][j]);
				buttons[i][j].setOnMouseClicked(e -> {
					MouseButton button = e.getButton();
					System.out.println("Button was " + button);
				});
				gp.add(buttons[i][j], i, j);
			}
		}
		
		theStage.setScene(new Scene(gp));
		theStage.show();
	}
}


class XOButton extends Button implements EventHandler<ActionEvent>{
	int state; // 0 means blank, 1 means X, 2 means O
	ImageView imageCover, imageX, imageO;
	
	public XOButton(){
		state = 0;
		double size = 100;
		setMinWidth(size);
		setMaxWidth(size);
		setMinHeight(size);
		setMaxHeight(size);
		
		imageCover = new ImageView(new Image("file:/res/grey.PNG"));
		imageX = new ImageView(new Image("file:/res/x.PNG"));
		imageO = new ImageView(new Image("file:/res/o.JFIF"));
		
		imageCover.setFitHeight(size);
		imageCover.setFitWidth(size);
		imageX.setFitHeight(size);
		imageX.setFitWidth(size);
		imageO.setFitHeight(size);
		imageO.setFitWidth(size);
		
		setGraphic(imageCover);
	}
	
	public void handle(ActionEvent e){
		state++;
		state %= 3;
		switch(state){
		case 0:
			setGraphic(imageCover);
			break;
		case 1:
			setGraphic(imageX);
			break;
		case 2:
			setGraphic(imageO);
			break;
			
		}
	}
}
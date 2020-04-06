package javaFXn.src;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ShowImage extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage theStage){
		Pane pane = new HBox(10);
		
		
		//Image image = new Image("http://www.cs.armstrong.edu/liang/image/ca.gif");
		Image image = new Image("file:1.PNG");
		pane.getChildren().add(new ImageView(image));
		
		ImageView iv2 = new ImageView(image);
		iv2.setRotate(50);
		pane.getChildren().add(iv2);
		
		Scene scene = new Scene(pane);
		
		theStage.setScene(scene);
		theStage.show();
	}
}

package javaFXn.src;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class StickMan extends Application{

	public static void main(String[] args){
		launch(args);
	}
	
	public void start(Stage theStage){
		Pane pane = new Pane();
		Circle c = new Circle();
		//c.setRadius(50);
		//c.setCenterX(100);
		//c.setCenterY(100);
		c.centerXProperty().bind(pane.widthProperty().divide(2));
		c.centerYProperty().bind(pane.widthProperty().divide(2));
		c.radiusProperty().bind(pane.widthProperty().divide(2));
		Line body = new Line(100, 150, 100, 300);
		Line leg1 = new Line(100, 300, 150, 450);
		Line leg2 = new Line(100, 300,  50, 450);
		Line arm1 = new Line(100, 200, 180, 150);
		Line arm2 = new Line(100, 200,  20, 150);
		Line lightSaber = new Line(20, 150, 5, 50);
		
		lightSaber.setStrokeWidth(5);
		lightSaber.setStroke(Color.LAWNGREEN);
		
		pane.getChildren().add(c);
		pane.getChildren().add(body);
		pane.getChildren().add(leg1);
		pane.getChildren().add(leg2);
		pane.getChildren().add(arm1);
		pane.getChildren().add(arm2);
		pane.getChildren().add(lightSaber);
		Scene scene = new Scene(pane, 200, 500);
		theStage.setTitle("Stick man");
		theStage.setScene(scene);
		theStage.show();
	}
}

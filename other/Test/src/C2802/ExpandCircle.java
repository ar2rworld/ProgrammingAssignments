 

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ExpandCircle extends Application{
	private CirclePane circlePane = new CirclePane();
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage theStage){
		HBox hbox = new HBox(12);
		hbox.setAlignment(Pos.CENTER);
		Button go = new Button("go");
		Button stop = new Button("Stop");
		hbox.getChildren().addAll(go,stop);
		
		go.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				System.out.println("go");
				circlePane.enlarge();
			}
		});
		
		stop.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				System.out.println("stop");
				circlePane.shrink();
			}
		});
		
		BorderPane bp = new BorderPane();
		bp.setCenter(circlePane);
		bp.setBottom(hbox);
		
		Scene scene = new Scene(bp, 200, 150);
		theStage.setScene(scene);
		theStage.show();
	}
}

class CirclePane extends StackPane{
	private Circle circle = new Circle(50);
	
	public CirclePane(){
		getChildren().add(circle);
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.WHITE);
		
	}
	public void enlarge() {
		circle.setRadius(circle.getRadius() + 2);
		circle.setFill(Color.LAWNGREEN);
	}
	
	public void shrink() {
		circle.setRadius(circle.getRadius() - 2);
		circle.setFill(Color.RED);
	}
	
}

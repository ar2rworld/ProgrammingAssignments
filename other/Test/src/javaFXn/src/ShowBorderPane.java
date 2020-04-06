package javaFXn.src;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ShowBorderPane extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	public void start(Stage theStage){
		BorderPane pane = new BorderPane();
		pane.setRight(new CustomPane("Right"));
		pane.setLeft(new CustomPane("Left"));
		pane.setTop(new CustomPane("Top"));
		pane.setBottom(new CustomPane("Bottom"));
		
		pane.setCenter(new CustomPane("Center"));
		
		Scene scene = new Scene(pane);
		theStage.setScene(scene);
		theStage.show();
	}
}

class CustomPane extends StackPane{
	public CustomPane(String title){
		getChildren().add(new Label(title));
		setStyle("-fx-border-color:red");
		setPadding(new Insets(12,12,12,12));
	
	}
}
	

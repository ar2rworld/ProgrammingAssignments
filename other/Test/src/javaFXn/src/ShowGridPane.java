package javaFXn.src;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ShowGridPane extends Application{

	public static void main(String[] args){
		launch(args);
	}
	
	public void start(Stage theStage){
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(12,12,12,12));
		pane.setVgap(6);
		pane.setHgap(6);
	
		pane.add(new Label("First Name:"), 0, 0);
		pane.add(new TextField(),1, 0);
		pane.add(new Label("Middle Name:"), 0, 1);
		pane.add(new TextField(),1, 1);
		pane.add(new Label("Last Name:"), 0, 2);
		pane.add(new TextField(),1, 2);
		
		Button btAdd = new Button("Add Name");
		pane.add(btAdd, 1, 3);
		GridPane.setHalignment(btAdd, HPos.RIGHT);
		Scene scene = new Scene(pane);
		theStage.setScene(scene);
		theStage.show();
		
	}
}

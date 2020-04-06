import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

	public void start(Stage theStage){
		StackPane pane = new StackPane();
		Button ok = new Button("OK");
		pane.getChildren().add(ok);
		Scene scene = new Scene(pane, 200, 200);
		theStage.setTitle("Hello World");
		theStage.setScene(scene);
		theStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}

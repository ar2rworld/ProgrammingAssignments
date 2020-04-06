 

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FirstEvents extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage theStage){
        HBox pane = new HBox(30);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10,10,10,10));
        Button ok = new Button("OK");
        Button cancel = new Button("Cancel");
        cancel.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                System.out.println("Cancel clicked");
            }
        });
        OKHandler okHand = new OKHandler();
        
        ok.setOnAction(okHand);
        
        //lambda, when implementing interface if it has only one method
        Button reset = new Button("Reset");
        reset.setOnAction(e -> {
            System.out.println("Reset Clicked");
        });
        pane.getChildren().add(reset);
        pane.getChildren().add(ok);
        pane.getChildren().add(cancel);
        
        
        Scene scene = new Scene(pane);
        theStage.setScene(scene);
        theStage.show();
    }
    
    class OKHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            System.out.println("OK clicked " + e);
        }
    }
}

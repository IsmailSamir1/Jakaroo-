package application;

import java.io.IOException;

import engine.Game;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler<ActionEvent> {
    
    private Label label;
    private Label Cpu2;
    private Label Cpu1;
    private Label Cpu3;
    private Label label2;
    private TextField field;
    private Circle marble;
    private Button Next;
    private Button Cancel;
    private HBox hbox;
    private HBox hbox1;
    private VBox vbox;
    
    private Stage primaryStage; // Store the primary stage reference
    
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage; // Store the primary stage
        try {
            createFirstScene();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    private void createFirstScene() {
        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root, 400, 400);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        
        label = new Label("Name : ");
        label.setLayoutX(10);
        label.setLayoutY(20);
        label.setPrefSize(1000, 10);
        root.getChildren().add(label);
        
        label2 = new Label("Your are going to face: ");
        label2.setLayoutX(1100);
        label2.setLayoutY(40);
        label2.setPrefSize(1000, 10);
        root.getChildren().add(label2);
        
        Cpu1 = new Label("Abo Galoom");
        Cpu1.setLayoutX(1100);
        Cpu1.setLayoutY(60);
        Cpu1.setPrefSize(1000, 10);
        root.getChildren().add(Cpu1);
        
        Cpu2 = new Label("Mostafa");
        Cpu2.setLayoutX(1100);
        Cpu2.setLayoutY(75);
        Cpu2.setPrefSize(1000, 10);
        root.getChildren().add(Cpu2);
        
        Cpu3 = new Label("Farida");
        Cpu3.setLayoutX(1100);
        Cpu3.setLayoutY(90);
        Cpu3.setPrefSize(1000, 10);
        root.getChildren().add(Cpu3);
        
        field = new TextField();
        field.setLayoutX(60);
        field.setLayoutY(20);
        field.setPrefSize(114, 10);
        root.getChildren().add(field);
        
        Next = new Button("Next");
        Next.setLayoutX(70);
        Next.setLayoutY(55);
        Next.setPrefSize(65, 10);
        root.getChildren().add(Next);
        Next.setOnAction(this);
        
        Cancel = new Button("Cancel");
        Cancel.setLayoutX(137);
        Cancel.setLayoutY(55);
        Cancel.setPrefSize(65, 10);
        root.getChildren().add(Cancel);
        Cancel.setOnAction(this);

        
        primaryStage.setScene(scene);
        primaryStage.setTitle("First Scene");
        primaryStage.show();
        
    }
    
    private void createSecondScene(String playerName) {
    	 try {
    	        Parent root = FXMLLoader.load(getClass().getResource("last.fxml"));
    	        Scene scene = new Scene(root);
    	        primaryStage.setScene(scene);
    	        primaryStage.show();
    	    } catch (IOException e) {
    	        e.printStackTrace();
    	    }
    	   
    }
   

    public void handle(ActionEvent event) {
        if (event.getSource() == Next) {
            String playerName = field.getText().trim();
            
            if (!playerName.isEmpty()) {
                createSecondScene(playerName); // Switch to second scene
            } else {
                // Show warning if name is empty (now as a modal dialog)
                Stage warningStage = new Stage();
                VBox root = new VBox(new Label("Please enter your name first."));
                Scene scene = new Scene(root, 300, 300);
                warningStage.setScene(scene);
                warningStage.setTitle("Warning");
                warningStage.initModality(Modality.APPLICATION_MODAL);
                warningStage.show();
            }
        } else if (event.getSource() == Cancel) {
            field.clear();
        }
    }
    

    public static void main(String[] args) {
        launch(args);
    }
}
import java.text.MessageFormat;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Main extends Application {
	
	String checkUser, checkPw;
	String user ,pw ;
	private TextField userTextField;
	private PasswordField pwBox;
	@Override
	public void start(Stage primaryStage) throws Exception  {
		 primaryStage.setTitle("Covid App");
		 
		 GridPane grid = new GridPane();
		 grid.setAlignment(Pos.CENTER);
		 grid.setHgap(10);
		 grid.setVgap(10);
		 grid.setPadding(new Insets(25, 25, 25, 25));
		 
		 Button btn = new Button("Sign in");
		 HBox hbBtn = new HBox(10);
		 hbBtn.setAlignment(Pos.BOTTOM_RIGHT);		//the button//
		 hbBtn.getChildren().add(btn);
		 grid.add(hbBtn, 1, 4);
		 
		 final Text actiontarget = new Text();
	        grid.add(actiontarget, 1, 6);
	        
	       
	       

		 Scene scene = new Scene(grid, 300, 275);
		 primaryStage.setScene(scene);
		 
		 Text scenetitle = new Text("Login");
		 scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		 grid.add(scenetitle, 0, 0, 2, 1);

		 Label userName = new Label("Admin:");
		 grid.add(userName, 0, 1);

		 TextField userTextField = new TextField();
		 grid.add(userTextField, 1, 1);

		 Label pw = new Label("Password:");
		 grid.add(pw, 0, 2);

		 PasswordField pwBox = new PasswordField();
		 grid.add(pwBox, 1, 2);
		 
		 btn.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
        	 
	            @Override
	            public void handle(ActionEvent e) {
				checkUser = userTextField.getText().toString();
				checkPw = pwBox.getText().toString();
	            if(checkUser.equals("user") && checkPw.equals("pw")){
	            	actiontarget.setFill(Color.GREEN);
	                actiontarget.setText("Rigth Username/Password.Welcome!");
	            }
	            else{
	            	actiontarget.setFill(Color.FIREBRICK);
	                actiontarget.setText("Wrong Username/Password.Try again!");
	            }
	            userTextField.setText("");
	            pwBox.setText("");
	           }
	              
	            });
		 
	        primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

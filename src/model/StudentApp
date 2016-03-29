package model;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class StudentApp extends Application implements EventHandler<ActionEvent> {
	private String gebruiker;
	
	@Override
	public void start(Stage primaryStage) {
		
		PrIS pris = new PrIS();

		Label lbGebruiker = new Label();

		FlowPane rootInloggen = new FlowPane();
		rootInloggen.setPadding(new Insets(10, 10, 10, 10));
		Scene inloggen = new Scene(rootInloggen, 360, 200);
		

		FlowPane rootMenu = new FlowPane();
		rootMenu.setPadding(new Insets(10, 10, 10, 10));
		Scene menu = new Scene(rootMenu, 500, 200);
		

		/* Scene inloggen */
		
		Label lbTitel = new Label("Inloggen: student");
		lbTitel.setPrefWidth(330.0);
		Label lbStudentnr = new Label("Email: ");
		lbStudentnr.setPrefWidth(150.0);
		Label lbWachtwoord = new Label("Wachtwoord");
		lbWachtwoord.setPrefWidth(150.0);
		

		TextField tfStudentnr = new TextField();
		TextField tfWachtwoord = new TextField();		

		Label lbMelding = new Label("");
		
		
		Button btnInloggen = new Button("Inloggen");
		btnInloggen.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				if(tfStudentnr.getText().isEmpty() || tfWachtwoord.getText().isEmpty())
				{
					lbMelding.setText("Vul alle gegevens in!");
				}
				else {
					if(pris.login(tfStudentnr.getText(), tfWachtwoord.getText()) == "student") {
						lbMelding.setText("");
						tfStudentnr.setText("");
						tfWachtwoord.setText("");
						primaryStage.setScene(menu);	
						gebruiker = tfStudentnr.getText();
					}
					else {
						lbMelding.setText("verkeerde gegevens!");
					}
				}
			}
		});


		HBox hbox = new HBox();
		hbox.setPrefWidth(335.0);
		hbox.setSpacing(10.0);
		hbox.setAlignment(Pos.CENTER_RIGHT);
		hbox.getChildren().addAll(lbMelding, btnInloggen);

		rootInloggen.getChildren().addAll(lbTitel, lbStudentnr, tfStudentnr, lbWachtwoord, tfWachtwoord);
		rootInloggen.getChildren().add(hbox);
		rootInloggen.setVgap(10.0);
		
		
		/* Scene menu */
		
		Button btnAfwezigMelden = new Button("Afwezigheid");
		btnAfwezigMelden.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
			
			}
		});
		
		Button btnWachtwoordWijzigen= new Button("Wachtwoord wijzigen");
		btnWachtwoordWijzigen.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
			
			}
		});	
		

		Button btnAfmelden = new Button("Afmelden");
		btnAfmelden.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				gebruiker = "";
				primaryStage.setScene(inloggen);
			}
		});	
		
		rootMenu.getChildren().addAll(lbGebruiker, btnAfwezigMelden, btnWachtwoordWijzigen, btnAfmelden);
		rootMenu.setVgap(10.0);
		
		
		/* Afwezig melden */
		
		primaryStage.setTitle("Inloggen Student");
		primaryStage.setScene(inloggen);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public void handle(ActionEvent event) {
		System.out.println("Hello World!");
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}


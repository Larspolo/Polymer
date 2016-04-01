package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class StudentApp extends Application implements EventHandler<ActionEvent> {
	private String gebruiker;

	@Override
	public void start(Stage primaryStage) throws ClassNotFoundException, IOException, NullPointerException {

		PrIS pris = new PrIS();

		Label lbGebruiker = new Label();

		FlowPane rootInloggen = new FlowPane();
		rootInloggen.setPadding(new Insets(10, 10, 10, 10));
		Scene inloggen = new Scene(rootInloggen, 360, 200);

		FlowPane rootMenu = new FlowPane();
		rootMenu.setPadding(new Insets(10, 10, 10, 10));
		Scene menu = new Scene(rootMenu, 360, 200);

		FlowPane rootAfwezigheid = new FlowPane();
		rootAfwezigheid.setPadding(new Insets(10, 10, 10, 10));
		Scene afwezigheid = new Scene(rootAfwezigheid, 360, 200);

		FlowPane rootWachtwoord = new FlowPane();
		rootWachtwoord.setPadding(new Insets(10, 10, 10, 10));
		Scene wachtwoord = new Scene(rootWachtwoord, 360, 200);

		/* Scene inloggen */

		Label lbTitel = new Label("Inloggen: student");
		lbTitel.setPrefWidth(330.0);
		Label lbStudentnr = new Label("Studentnr: ");
		lbStudentnr.setPrefWidth(150.0);
		Label lbWachtwoord = new Label("Wachtwoord");
		lbWachtwoord.setPrefWidth(150.0);

		TextField tfStudentnr = new TextField();
		TextField tfWachtwoord = new TextField();

		Label lbMelding = new Label("");

		ComboBox cbLessen = new ComboBox();

		Button btnZiekMelden = new Button("Ziek melden");
		
		Button btnInloggen = new Button("Inloggen");
		btnInloggen.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				if (tfStudentnr.getText().isEmpty() || tfWachtwoord.getText().isEmpty()) {
					lbMelding.setText("Vul alle gegevens in!");
				} else {
					if (pris.login(Integer.parseInt(tfStudentnr.getText()), tfWachtwoord.getText()) == "student") {

						gebruiker = tfStudentnr.getText();
						lbMelding.setText("");
						tfStudentnr.setText("");
						tfWachtwoord.setText("");
						primaryStage.setScene(menu);
												
						for(Les l : pris.getStudent(Integer.parseInt(gebruiker)).getMijnKlas().getMijnLessen()) {

							cbLessen.getItems().add(l);
						}
						System.out.println(pris.getStudent(Integer.parseInt(gebruiker)).getZiek());
						if(pris.getStudent(Integer.parseInt(gebruiker)).getZiek()){
							btnZiekMelden.setText("Beter melden");
						}
						else {
							btnZiekMelden.setText("Ziek melden");
						}
						
					} else {
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
		btnZiekMelden.setPrefWidth(330.0);
		btnZiekMelden.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				pris.getStudent(Integer.parseInt(gebruiker)).ziekMelden();

				System.out.println(pris.getStudent(Integer.parseInt(gebruiker)).getZiek());
				
				if(pris.getStudent(Integer.parseInt(gebruiker)).getZiek()){
					btnZiekMelden.setText("Beter melden");
				}
				else {
					btnZiekMelden.setText("Ziek melden");
				}
			}
		});
		
		Button btnAfwezigheid = new Button("Afwezigheid");
		btnAfwezigheid.setPrefWidth(330.0);
		btnAfwezigheid.setOnAction(new EventHandler<ActionEvent>() {

	public void handle(ActionEvent event) {
				primaryStage.setScene(afwezigheid);
			}
		});

		Button btnWachtwoordWijzigen = new Button("Wachtwoord wijzigen");
		btnWachtwoordWijzigen.setPrefWidth(330.0);
		btnWachtwoordWijzigen.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				primaryStage.setScene(wachtwoord);
			}
		});

		
		Button btnAfmelden = new Button("Afmelden");
		btnAfmelden.setPrefWidth(330.0);
		btnAfmelden.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				try {
					pris.loguit();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				gebruiker = "";
				primaryStage.setScene(inloggen);
			}
		});

		rootMenu.getChildren().addAll(lbGebruiker, btnZiekMelden, btnAfwezigheid, btnWachtwoordWijzigen, btnAfmelden);
		rootMenu.setVgap(10.0);

		/* Afwezig melden */
		
		Label lbTitel2 = new Label(" Afwezigheid");
		lbTitel2.setPrefWidth(280.0);

		Label lbLes = new Label("Les: ");
		lbLes.setPrefWidth(140.0);

		Label lbMelding1 = new Label("");


//		pris.getStudent(Integer.parseInt(gebruiker)).getMijnKlas().getMijnLessen().forEach(
//			les -> System.out.println("Bram heeft grote pilaar")
//		);
		
		cbLessen.setPrefWidth(185.00);

		Button btnTerug = new Button("<-");
		btnTerug.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				primaryStage.setScene(menu);
			}
		});

		Button btnAfwezigMelden = new Button("Afwezig melden");
		btnAfwezigMelden.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				
				pris.getStudent(Integer.parseInt(gebruiker)).setAfwezig(pris.getStudent(Integer.parseInt(gebruiker)), (Les) cbLessen.getValue());
				lbMelding1.setText("Succesvol gemeld");
			}
		});

		HBox hbox1 = new HBox();
		hbox1.setPrefWidth(330.0);
		hbox1.setSpacing(10.0);
		hbox1.setAlignment(Pos.CENTER_RIGHT);
		hbox1.getChildren().addAll(lbMelding1, btnAfwezigMelden);

		rootAfwezigheid.getChildren().addAll(btnTerug, lbTitel2, lbLes, cbLessen);
		rootAfwezigheid.getChildren().add(hbox1);
		rootAfwezigheid.setVgap(10.0);

		/* Wachtwoord wijzigen */
		Label lbTitel3 = new Label(" Nieuw wachtwoord");
		lbTitel3.setPrefWidth(280.0);

		Label lbNieuwWachtwoord = new Label("Nieuw wachtwoord: ");
		lbNieuwWachtwoord.setPrefWidth(140.0);

		TextField tfNieuwWachtwoord = new TextField();
		tfNieuwWachtwoord.setPrefWidth(180.0);

		Label lbMelding2 = new Label("");

		Button btnTerug2 = new Button("<-");
		btnTerug2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				primaryStage.setScene(menu);
			}
		});

		Button btnOpslaan = new Button("Opslaan");
		btnOpslaan.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) throws NumberFormatException {
				if (tfNieuwWachtwoord.getText().equals("")) {
					lbMelding2.setText("Voer een wachtwoord in!");

				} else {	
					pris.getStudent(Integer.parseInt(gebruiker)).wijzigWachtwoord(tfNieuwWachtwoord.getText());
					lbMelding2.setText("Opgeslagen!");
					tfNieuwWachtwoord.setText("");
				}
			}
		});

		HBox hbox2 = new HBox();
		hbox2.setPrefWidth(330.0);
		hbox2.setSpacing(10.0);
		hbox2.setAlignment(Pos.CENTER_RIGHT);
		hbox2.getChildren().addAll(lbMelding2, btnOpslaan);

		rootWachtwoord.getChildren().addAll(btnTerug2, lbTitel3, lbNieuwWachtwoord, tfNieuwWachtwoord);
		rootWachtwoord.getChildren().add(hbox2);
		rootWachtwoord.setVgap(10.0);

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


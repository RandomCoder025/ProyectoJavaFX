package controladores;

import application.GestionPreguntas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ControladorInicio {
	private Stage primaryStage;
	private Scene scene;
	private Parent root;

	@FXML
	private Label titleTXT;

	@FXML
	private Button btnComenzar;

	@FXML
	void comenzar(ActionEvent event) {
		GestionPreguntas gestionPreguntas = new GestionPreguntas();
		
		gestionPreguntas.siguientePregunta(event,null);
	}

}

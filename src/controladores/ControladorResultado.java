package controladores;

import java.io.IOException;
import java.util.Arrays;
import application.BaseDatos;
import application.GestionClases;
import application.GestionPreguntas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class ControladorResultado {
	private Stage primaryStage;
	private Scene scene;
	private Parent root;
	@FXML
	private Label titleTXT;

	@FXML
	private Text txtInfoNombre;

	@FXML
	private Button btnVolverInicio;

	@FXML
	private TextFlow txtInfoClase;

	@FXML
	private ImageView imgClase;

	@FXML
	void rehacerTest(ActionEvent event) {
		try {
			GestionClases.rellenarClases();

			root = FXMLLoader.load(getClass().getResource("/VistaInicio.fxml"));
			primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			primaryStage.setTitle("D&D TEST");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void initialize() {

		BaseDatos bd = new BaseDatos();
		String[] imprimir = new String[3];

		imprimir = bd.devolverClaseGanadora();

		try {
			txtInfoNombre.setText(imprimir[0]);

			txtInfoClase.getChildren().addAll(new Text(imprimir[1]));

			imgClase.setImage(new Image(imprimir[2]));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

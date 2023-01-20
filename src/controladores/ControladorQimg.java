package controladores;

import java.lang.ModuleLayer.Controller;
import java.net.URL;
import application.GestionPreguntas;
import application.Pregunta;
import application.Respuesta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ControladorQimg {
	private Stage primaryStage;
	private Scene scene;
	private Parent root;
	private final ToggleGroup grupo = new ToggleGroup();

	@FXML
	private Button btnSiguienteQ;

	@FXML
	private Label titleTXT;

	@FXML
	private ImageView imgOpcionB;

	@FXML
	private ImageView imgOpcionA;

	@FXML
	private ImageView imgOpcionC;

	@FXML
	private ImageView imgOpcionD;

	@FXML
	private RadioButton opcionD;

	@FXML
	private RadioButton opcionB;

	@FXML
	private RadioButton opcionC;

	@FXML
	private RadioButton opcionA;

	@FXML
	void siguienteQ(ActionEvent event) {
		Respuesta enviarRespuesta;
		GestionPreguntas gestionPreguntas = new GestionPreguntas();
		RadioButton resultado = (RadioButton) grupo.getSelectedToggle();
		if (resultado != null) {

			if (resultado == opcionA) {
				enviarRespuesta = GestionPreguntas.devolverPregunta().getRespuestas().get(0);

			} else if (resultado == opcionB) {
				enviarRespuesta = GestionPreguntas.devolverPregunta().getRespuestas().get(1);

			} else if (resultado == opcionC) {
				enviarRespuesta = GestionPreguntas.devolverPregunta().getRespuestas().get(2);

			} else {
				enviarRespuesta = GestionPreguntas.devolverPregunta().getRespuestas().get(3);

			}
			gestionPreguntas.siguientePregunta(event, enviarRespuesta);
		} else {
			mostrarAlertInfo(event, "Por favor, seleccione una imagen");
		}

	}

	private void mostrarAlertInfo(ActionEvent event, String mensaje) {

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText(mensaje);
		alert.showAndWait();

	}

	public void initialize() {
		opcionA.setToggleGroup(grupo);
		opcionB.setToggleGroup(grupo);
		opcionC.setToggleGroup(grupo);
		opcionD.setToggleGroup(grupo);
		
		Pregunta kuestion;
		kuestion = GestionPreguntas.devolverPregunta();

		titleTXT.setText(kuestion.getPregunta());
		switch (kuestion.getRespuestas().size()) {
//		default: DEBUGER PARA VER SI FUNKAN
//			try {
//				System.out.println(kuestion.getRespuestas().get(1).getRespuesta());
//				imgOpcionA.setImage(new Image(kuestion.getRespuestas().get(0).getRespuesta()));
//				imgOpcionB.setImage(new Image(kuestion.getRespuestas().get(1).getRespuesta()));
//			} catch (Exception e) {
//				System.err.println(kuestion.getRespuestas().get(1).getRespuesta());
//
//			}
//			
//		}
		case 3:

			imgOpcionA.setVisible(true);
			imgOpcionB.setVisible(true);
			imgOpcionC.setVisible(true);
			imgOpcionD.setVisible(false);
			opcionD.setVisible(false);

			imgOpcionA.setImage(new Image(kuestion.getRespuestas().get(0).getRespuesta()));
			imgOpcionB.setImage(new Image(kuestion.getRespuestas().get(1).getRespuesta()));
			imgOpcionC.setImage(new Image(kuestion.getRespuestas().get(2).getRespuesta()));

			break;

		case 4:

			imgOpcionA.setVisible(true);
			imgOpcionB.setVisible(true);
			imgOpcionC.setVisible(true);
			imgOpcionD.setVisible(true);

			imgOpcionA.setImage(new Image(kuestion.getRespuestas().get(0).getRespuesta()));
			imgOpcionB.setImage(new Image(kuestion.getRespuestas().get(1).getRespuesta()));
			imgOpcionC.setImage(new Image(kuestion.getRespuestas().get(2).getRespuesta()));
			imgOpcionD.setImage(new Image(kuestion.getRespuestas().get(3).getRespuesta()));

			break;
		}

	}

}

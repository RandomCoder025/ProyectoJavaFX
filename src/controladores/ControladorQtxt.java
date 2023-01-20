package controladores;

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
import javafx.stage.Stage;

public class ControladorQtxt {
	private Stage primaryStage;
	private Scene scene;
	private Parent root;
	private final ToggleGroup grupo = new ToggleGroup();

	@FXML
	private Label preguntatexto;

	@FXML
	private Button btnSiguienteQ;

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
			gestionPreguntas.siguientePregunta(event,enviarRespuesta);
		} else {
			mostrarAlertInfo(event, "Por favor, seleccione una opción");

		}

	}

	private void mostrarAlertInfo(ActionEvent event, String mensaje) {

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText(mensaje);
		alert.showAndWait();

	}

	public void initializeMAL() {
		opcionA.setToggleGroup(grupo);
		opcionB.setToggleGroup(grupo);
		opcionC.setToggleGroup(grupo);
		opcionD.setToggleGroup(grupo);

		Pregunta kuestion;
		kuestion = GestionPreguntas.devolverPregunta();

		preguntatexto.setText(kuestion.getPregunta());
		switch (kuestion.getRespuestas().size()) {
		case 2:
			opcionA.setVisible(true);
			opcionB.setVisible(true);
			opcionA.setUserData("a)" + kuestion.getRespuestas().get(0));
			opcionB.setText("b)" + kuestion.getRespuestas().get(1).getRespuesta());
			opcionC.setVisible(false);
			opcionD.setVisible(false);
			break;
		case 3:
			opcionA.setVisible(true);
			opcionB.setVisible(true);
			opcionC.setVisible(true);
			opcionA.setText("a)" + kuestion.getRespuestas().get(0).getRespuesta());
			opcionB.setText("b)" + kuestion.getRespuestas().get(1).getRespuesta());
			opcionC.setText("c)" + kuestion.getRespuestas().get(2).getRespuesta());
			opcionD.setVisible(false);
			break;

		case 4:
			opcionA.setVisible(true);
			opcionB.setVisible(true);
			opcionC.setVisible(true);
			opcionD.setVisible(true);
			opcionA.setText("a)" + kuestion.getRespuestas().get(0).getRespuesta());
			opcionB.setText("b)" + kuestion.getRespuestas().get(1).getRespuesta());
			opcionC.setText("c)" + kuestion.getRespuestas().get(2).getRespuesta());
			opcionD.setText("d)" + kuestion.getRespuestas().get(3).getRespuesta());
			break;
		}
	}

	public void initialize() {

		opcionA.setToggleGroup(grupo);
		opcionB.setToggleGroup(grupo);
		opcionC.setToggleGroup(grupo);
		opcionD.setToggleGroup(grupo);

		Pregunta kuestion;
		kuestion = GestionPreguntas.devolverPregunta();

		preguntatexto.setText(kuestion.getPregunta());
		switch (kuestion.getRespuestas().size()) {
		case 2:
			opcionA.setVisible(true);
			opcionB.setVisible(true);
			opcionA.setText("a)" + kuestion.getRespuestas().get(0).getRespuesta());
			opcionB.setText("b)" + kuestion.getRespuestas().get(1).getRespuesta());
			opcionC.setVisible(false);
			opcionD.setVisible(false);
			break;
		case 3:
			opcionA.setVisible(true);
			opcionB.setVisible(true);
			opcionC.setVisible(true);
			opcionA.setText("a)" + kuestion.getRespuestas().get(0).getRespuesta());
			opcionB.setText("b)" + kuestion.getRespuestas().get(1).getRespuesta());
			opcionC.setText("c)" + kuestion.getRespuestas().get(2).getRespuesta());
			opcionD.setVisible(false);
			break;

		case 4:
			opcionA.setVisible(true);
			opcionB.setVisible(true);
			opcionC.setVisible(true);
			opcionD.setVisible(true);
			opcionA.setText("a)" + kuestion.getRespuestas().get(0).getRespuesta());
			opcionB.setText("b)" + kuestion.getRespuestas().get(1).getRespuesta());
			opcionC.setText("c)" + kuestion.getRespuestas().get(2).getRespuesta());
			opcionD.setText("d)" + kuestion.getRespuestas().get(3).getRespuesta());
			break;
		}

	}
}

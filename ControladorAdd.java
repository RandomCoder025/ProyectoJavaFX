package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControladorAdd {

	@FXML
	private TextField txtNombre;

	@FXML
	private TextField txtDamage;

	@FXML
	private Button btnAddFinal;

	@FXML
	void addArma(ActionEvent event) {
		String fallos = "", nombreWeapon;

		Integer damageWeapon = 0;

		if (txtNombre.getText().equals("")) {
			fallos += "Inserte texto en la casilla de nombre\n";
		} else {
			nombreWeapon = txtDamage.getText();

		}

		if (txtDamage.getText().equals("")) {
			fallos += "Inserte un valor en el daño";
		} else {
			if (Validaciones.ValidarNumeros(txtDamage.getText())) {
				damageWeapon = damageWeapon.parseInt(txtDamage.getText());

			} else {
				fallos += "Inserte un número natural en la casilla de daño \n";
			}
		}

		if (fallos.equals("")) {
			Main.addArmaLista(new Arma(txtNombre.getText(), damageWeapon));
			mostrarAlertInfo(event, "Arma " + txtNombre.getText() + " añadida");

		} else {
			mostrarAlertInfo(event, fallos);
		}
	}

	private void mostrarAlertInfo(ActionEvent event, String mensaje) {

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Nueva arma");
		alert.setHeaderText(null);
		alert.setContentText(mensaje);
		alert.showAndWait();

	}
}

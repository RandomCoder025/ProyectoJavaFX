package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Parent root;
		try {
			GestionClases.rellenarClases();
			root = FXMLLoader.load(getClass().getResource("/VistaInicio.fxml"));
// Establecemos el título de la ventana
			primaryStage.setTitle("Búsqueda de personajes");
// Establecemos el ancho y el alto
			primaryStage.setScene(new Scene(root));
// Mostramos la ventana
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		launch(args);
	}
}

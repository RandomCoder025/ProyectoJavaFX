package application;

import java.util.ArrayList;
import java.util.Random;

import controladores.ControladorQimg;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GestionPreguntas {

	private Stage primaryStage;
	private Scene scene;
	private Parent root;
	private static ArrayList<Pregunta> preguntas;
	private static int contadorPregnunta;

	public GestionPreguntas() {
		super();
	}

	public ArrayList<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(ArrayList<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	@Override
	public String toString() {
		return "GestionPreguntas [preguntas=" + preguntas + "]";
	}

	public static Pregunta devolverPregunta() {
		return preguntas.get(contadorPregnunta);
	}

	public void siguientePregunta(ActionEvent event, Respuesta givenAnswer) {
		BaseDatos bd = new BaseDatos();
		String rutaVista = "";

		try {
			if (givenAnswer != null) {
				GestionClases.modificarClases(givenAnswer);

			}

			if (preguntas == null) {
				preguntas = bd.sacarPreguntas(16, 8);
			} else {
				contadorPregnunta++;

			}
			if (contadorPregnunta < 8) {
				if (preguntas.get(contadorPregnunta).isEsImagen()) {
					rutaVista = "/VistaQimg.fxml";
				} else {
					rutaVista = "/VistaQtxt.fxml";
				}
			} else {
				rutaVista = "/VistaResultado.fxml";
				contadorPregnunta = 0;
				preguntas = bd.sacarPreguntas(16, 8);
			}

			root = FXMLLoader.load(getClass().getResource(rutaVista));
			primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			primaryStage.setTitle("D&D TEST");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	/**
	 * Método que genera los índices de las preguntas aleatoriamente sin que se
	 * repitan, en caso de repetirse vuelve a generar otro índice
	 * 
	 * @author Javier Campos
	 * 
	 * @version 1.0
	 * 
	 * @param numPreguntas      Número de preguntas con las que cuenta la base de
	 *                          datos para realizar el random de manera correcta
	 * 
	 * @param preguntasDevolver Número de índices de preguntas a generar
	 * 
	 * @see Preguntas
	 * 
	 */
	public static ArrayList<Integer> generarIndicesPreguntas(int numPreguntas, int preguntasDevolver) {
		ArrayList<Integer> indices = new ArrayList<Integer>();
		int posible = 0;
		Random rand = new Random();

		for (int i = 0; i < preguntasDevolver; i++) {
			do {
				posible = rand.nextInt(numPreguntas) + 1;
			} while (indices.contains(posible));

			indices.add(posible);
		}

		return indices;

	}
}

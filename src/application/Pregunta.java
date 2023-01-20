package application;
import java.util.ArrayList;

public class Pregunta {

	private String pregunta;
	private ArrayList<Respuesta> respuestas;
	private boolean esImagen;
	
	public Pregunta(String pregunta, ArrayList<Respuesta> respuestas, boolean esImagen) {
		super();
		this.pregunta = pregunta;
		this.respuestas = respuestas;
		this.esImagen = esImagen;
	}
	
	public String getPregunta() {
		return pregunta;
	}
	
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	
	public ArrayList<Respuesta> getRespuestas() {
		return respuestas;
	}
	
	public void setRespuestas(ArrayList<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}
	
	public boolean isEsImagen() {
		return esImagen;
	}

	public void setEsImagen(boolean esImagen) {
		this.esImagen = esImagen;
	}

	@Override
	public String toString() {
		return "Pregunta [pregunta=" + pregunta + ", respuestas=" + respuestas + ", esImagen=" + esImagen + "]";
	}
	
}

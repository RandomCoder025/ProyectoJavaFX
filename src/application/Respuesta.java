package application;

public class Respuesta {

	private String respuesta = "";
	private int idPregunta = 0;

	public Respuesta(String respuesta, int idPregunta) {
		super();
		this.respuesta = respuesta;
		this.idPregunta = idPregunta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public int getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}

	@Override
	public String toString() {
		return "Respuesta [respuesta=" + respuesta + ", idPregunta=" + idPregunta + "]";
	}

	
	
}

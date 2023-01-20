package application;

public class Clase {

	private int id;
	private String nombre;
	private int puntuacion;

	
	
	public Clase(int id, String nombre, int puntuacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.puntuacion = puntuacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Clase [id=" + id + ", nombre=" + nombre + ", puntuacion=" + puntuacion + "]";
	}
	
	public void modificarPunt(int mod) {
		puntuacion += mod;
	}

}

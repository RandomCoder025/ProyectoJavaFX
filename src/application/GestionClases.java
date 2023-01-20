package application;
import java.util.ArrayList;

public class GestionClases {

	private static ArrayList<Clase> clases;
	private static BaseDatos bd = new BaseDatos();

	public static ArrayList<Clase> getClases() {
		return clases;
	}

	public static BaseDatos getBd() {
		return bd;
	}

	public static void setBd(BaseDatos bd) {
		GestionClases.bd = bd;
	}

	public static void setClases(ArrayList<Clase> clases) {
		GestionClases.clases = clases;
	}
	
	@Override
	public String toString() {
		return "GestionClases [getClases()=" + getClases() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public static void rellenarClases() {
		clases= bd.sacarClases();
		System.out.println(clases.toString());
	}
	
	public static void modificarClases(Respuesta respuestaDada) {
		clases = bd.modificarValorClase(respuestaDada, clases);
	}
}

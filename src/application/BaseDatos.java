package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.Statement;

public class BaseDatos {

	Connection conexion = null;
	Statement sentenciaSQL = null;
	ResultSet rs = null;

	public BaseDatos() {
		super();
		this.conexion = conexion;
		this.sentenciaSQL = sentenciaSQL;
		this.rs = rs;
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	public Statement getSentenciaSQL() {
		return sentenciaSQL;
	}

	public void setSentenciaSQL(Statement sentenciaSQL) {
		this.sentenciaSQL = sentenciaSQL;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	/**
	 * Método que devuelve un ArrayList con las preguntas con los índices
	 * aleatorios.
	 * 
	 * @author Javier Campos
	 * 
	 * @version 5.0
	 * 
	 * @param numPreguntas      Número de preguntas total de la BBDD
	 * 
	 * @param preguntasDevolver Cúantas preguntas queremos para devolver
	 * 
	 * @return ArrayList<Pregunta>
	 * 
	 * @see GestionPreguntas
	 * 
	 * @see GestionPreguntas.generarIndicesPreguntas
	 * 
	 * @see Pregunta
	 * 
	 * @see Respuesta
	 * 
	 * @see ArrayList
	 */
	public ArrayList<Pregunta> sacarPreguntas(int numPreguntas, int preguntasDevolver) {
		ArrayList<Integer> indices = GestionPreguntas.generarIndicesPreguntas(numPreguntas, preguntasDevolver);
		ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
		ArrayList<Respuesta> respuestas;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/hoja9", "root", "");

			sentenciaSQL = (Statement) conexion.createStatement();

			for (int i = 0; i < indices.size(); i++) {
				respuestas = new ArrayList<Respuesta>();

				rs = sentenciaSQL.executeQuery("SELECT * FROM respuestas WHERE id_preg = '" + indices.get(i) + "'");

				while (rs.next()) {
					respuestas.add(new Respuesta(rs.getString("texto"), indices.get(i)));
				}

				rs = sentenciaSQL.executeQuery("SELECT * FROM preguntas WHERE id = '" + indices.get(i) + "'");

				while (rs.next()) {
					preguntas.add(new Pregunta(rs.getString("texto"), respuestas, rs.getBoolean("esImagen")));
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (sentenciaSQL != null) {
					sentenciaSQL.close();
				}
				if (conexion != null) {
					conexion.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return preguntas;
	}

	/**
	 * Método que saca la una arraylist con todas las clases de la base de datos
	 * 
	 * @author Javier Campos
	 * 
	 * @version 8.3
	 * 
	 * @return ArrayList<Clase>
	 * 
	 * @see Clase
	 */
	public ArrayList<Clase> sacarClases() {
		ArrayList<Clase> clases = new ArrayList<Clase>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/hoja9", "root", "");

			sentenciaSQL = (Statement) conexion.createStatement();

			rs = sentenciaSQL.executeQuery("SELECT * FROM clases");

			while (rs.next()) {
				clases.add(new Clase(rs.getInt("id"), rs.getString("nombre"), 50));
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (sentenciaSQL != null) {
					sentenciaSQL.close();
				}
				if (conexion != null) {
					conexion.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return clases;
	}

	/**
	 * Método que modifica todas las clases necesarias según la respuesta dada por
	 * el usuario
	 * 
	 * @author Javier Campos
	 * 
	 * @version 2.4
	 * 
	 * @param respuestaDada Respuesta dada por el usuario
	 * 
	 * @param clases        ArrayList con las clases a modificar
	 * 
	 * @return ArrayList<Clase>
	 * 
	 * @see Clase
	 * 
	 * @see Respuesta
	 * 
	 * @see Pregunta
	 */
	public ArrayList<Clase> modificarValorClase(Respuesta respuestaDada, ArrayList<Clase> clases) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/hoja9", "root", "");

			sentenciaSQL = (Statement) conexion.createStatement();

			rs = sentenciaSQL.executeQuery("SELECT * FROM puntuacion where id_res = (SELECT id FROM respuestas"
					+ " WHERE texto = '" + respuestaDada.getRespuesta() + "')");

			while (rs.next()) {
				for (Clase clase : clases) {
					if (rs.getInt("id_clase") == clase.getId()) {
						clase.modificarPunt(rs.getInt("modpunt"));
					}
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (sentenciaSQL != null) {
					sentenciaSQL.close();
				}
				if (conexion != null) {
					conexion.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


		return clases;
	}

	public String[] devolverClaseGanadora() {
		Clase claseGanadora = new Clase(40, "", -1000);
		Clase claseDebug=null;
		String[] devolver = new String[3];
try {
	

		for (Clase clase : GestionClases.getClases()) {
			claseDebug=clase;
			System.out.println(claseGanadora.toString());
			if (clase.getPuntuacion() > claseGanadora.getPuntuacion()) {
				claseGanadora = clase;
				System.out.println(
						claseGanadora.toString() + "\n---------------------------\nSe metió, UWU\n----------------");
			}
		}
} catch (Exception e) {
	e.printStackTrace();
}

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/hoja9", "root", "");

			sentenciaSQL = (Statement) conexion.createStatement();

			rs = sentenciaSQL.executeQuery("SELECT * FROM clases where id = '" + claseGanadora.getId() + "'");

			while (rs.next()) {
				devolver[0] = rs.getString("nombre");
				devolver[1] = rs.getString("descripcion");
				devolver[2] = rs.getString("imagen");
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (sentenciaSQL != null) {
					sentenciaSQL.close();
				}
				if (conexion != null) {
					conexion.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		

		return devolver;
	}
}

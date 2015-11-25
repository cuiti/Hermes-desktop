package hermes.dao;

import hermes.db.BaseDeDatos;
import hermes.model.Nino;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class NinoDAO implements INinoDAO {

	@Override
	public List<Nino> listarNinos() {
		BaseDeDatos db = new BaseDeDatos();
	    ResultSet rs = null;
	    List<Nino> lista = new LinkedList<Nino>();
	    
		String consulta = "SELECT * FROM nino";
		
		rs = db.ejecutarConsulta(consulta);
	    
	    try {
			while (rs.next()){
				Nino nino = new Nino(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getString("apellido")
				);
				lista.add(nino);
			}
		} catch (SQLException e) {
			System.out.println("Error al acceder a la base de datos SQLite");
			e.printStackTrace();
		}
	    return lista;
	}

	@Override
	public boolean guardarNino(Nino n) {
		BaseDeDatos db = new BaseDeDatos();
	    String query = "INSERT INTO nino (id, nombre, apellido) "
	    		+ "VALUES ("		
	    		+ n.getId() + ","
	    		+ n.getNombre() + ","
	    		+ n.getApellido() + ","
	    		+ ");";
		return db.ejecutarABM(query);
	}

	@Override
	public Nino getNinoByNombre(String nombre, String apellido) {
		BaseDeDatos db = new BaseDeDatos();
	    ResultSet rs = null;	    
	    Nino nino = new Nino(-1, "", "");	
	    
		String consulta = "SELECT * FROM nino "
						+ "WHERE nombre = "+ nombre +""
						+ "AND apellido = "+ apellido + "";
		
	    rs = db.ejecutarConsulta(consulta);
		
	    try {
			if (rs.next()){
				nino = new Nino(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getString("apellido")
				);
			} 
			
		} catch (SQLException e) {
			System.out.println("Error al acceder a la base de datos SQLite");
			e.printStackTrace();
		}
	    return nino;
	}

}

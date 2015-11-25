package hermes.dao;

import hermes.db.BaseDeDatos;
import hermes.model.Contenido;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ContenidoDAO implements IContenidoDAO {

	@Override
	public List<Contenido> listarContenidos() {
		BaseDeDatos db = new BaseDeDatos();
	    ResultSet rs = null;    
	    List<Contenido> lista = new LinkedList<Contenido>();
	    
	    String consulta = "SELECT * FROM contenido";	    
	   
	    rs = db.ejecutarConsulta(consulta);
	    
	    try {
			while (rs.next()){
				Contenido contenido = new Contenido(
						rs.getInt("id"),
						rs.getString("texto")
				);
				lista.add(contenido);
			}
		} catch (SQLException e) {
			System.out.println("Error al acceder a la base de datos SQLite");
			e.printStackTrace();
		}
	    return lista;
	}

	@Override
	public boolean guardarContenido(Contenido c) {
		BaseDeDatos db = new BaseDeDatos();
	    String query = "INSERT INTO contenido (id, texto) "
	    		+ "VALUES ("		
	    		+ c.getId() + ","
	    		+ c.getTexto() + ","
	    		+ ");";
		return db.ejecutarABM(query);
	}

	@Override
	public Contenido getContenidoByNombre(String nombre) {
		BaseDeDatos db = new BaseDeDatos();
	    ResultSet rs = null;	    
	    Contenido contenido = new Contenido(-1, "contenido inexistente");	
	    
		String consulta = "SELECT * FROM contenido "
						+ "WHERE texto = "+ nombre +"";
		
	    rs = db.ejecutarConsulta(consulta);
		
	    try {
			if (rs.next()){
				contenido = new Contenido(
						rs.getInt("id"),
						rs.getString("texto")
				);
			} 
			
		} catch (SQLException e) {
			System.out.println("Error al acceder a la base de datos SQLite");
			e.printStackTrace();
		}
	    return contenido;
	}

}

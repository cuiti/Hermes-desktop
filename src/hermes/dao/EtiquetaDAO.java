package hermes.dao;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import hermes.db.BaseDeDatos;
import hermes.model.Etiqueta;

public class EtiquetaDAO implements IEtiquetaDAO {

	@Override
	public List<Etiqueta> listarEtiquetas() {
		BaseDeDatos db = new BaseDeDatos();
	    ResultSet resultados; 
	    List<Etiqueta> lista = new LinkedList<Etiqueta>();
	    
	    String consulta = "SELECT * FROM etiqueta";
	    
	    resultados = db.ejecutarConsulta(consulta);
	    
	    try {
			while (resultados.next()){
				Etiqueta etiqueta = new Etiqueta(
						resultados.getInt("id"),
						resultados.getString("texto")
				);
				lista.add(etiqueta);
			}
			resultados.close();
		} catch (SQLException e) {
			System.out.println("Error al acceder a la base de datos SQLite");
			e.printStackTrace();
		}
	    return lista;
	}

	@Override
	public boolean guardarEtiqueta(Etiqueta etiqueta) {
		BaseDeDatos db = new BaseDeDatos();
	    String query = "INSERT INTO etiqueta (texto) "
	    		+ "VALUES ('"		
	    		+ etiqueta.getTexto()
	    		+ "');";
		return db.ejecutarInsercion(query);
	}

	@Override
	public boolean eliminarEtiqueta(Etiqueta etiqueta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean renombrarEtiqueta(Etiqueta etiqueta, Etiqueta nuevaEtiqueta) {
		// TODO Auto-generated method stub
		return false;
	}

}

package hermes.dao;

import java.util.List;

import hermes.model.Etiqueta;

public interface IEtiquetaDAO {
	public List<Etiqueta> listarEtiquetas();
	public boolean guardarEtiqueta(Etiqueta etiqueta);
	public boolean eliminarEtiqueta(Etiqueta etiqueta);
	public boolean renombrarEtiqueta(Etiqueta etiqueta, Etiqueta nuevaEtiqueta);
	public boolean asignarEtiqueta(int id_notificacion, int id_etiqueta);
	public boolean desasignarEtiqueta(int id_notificacion, int id_etiqueta);	
	
}

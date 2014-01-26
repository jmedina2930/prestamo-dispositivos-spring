package co.edu.udea.PrestamoDispositivos.bl;

import java.util.List;

import co.edu.udea.PrestamoDispositivos.model.Dispositivo;
import co.edu.udea.PrestamoDispositivos.util.exception.PrestamoDispositivoException;

public interface DispositivoBL {
	
	public void guardar(String descripcion, String estado, String usuario) throws PrestamoDispositivoException;
	
	public void actualizar(Dispositivo dispositivo, String descripcion, String estado, String usuario) throws PrestamoDispositivoException;
	
	public void eliminar(Dispositivo dispositivo) throws PrestamoDispositivoException;	

	List<Dispositivo> obtener() throws PrestamoDispositivoException;

	Dispositivo obtenerPorId(Integer id) throws PrestamoDispositivoException;
}

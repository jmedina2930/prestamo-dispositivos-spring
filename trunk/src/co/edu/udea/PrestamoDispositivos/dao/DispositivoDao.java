package co.edu.udea.PrestamoDispositivos.dao;

import java.util.List;

import co.edu.udea.PrestamoDispositivos.model.Dispositivo;
import co.edu.udea.PrestamoDispositivos.util.exception.PrestamoDispositivoException;


/**
 * 
 * @author Mauricio Ortiz
 *
 */
public interface DispositivoDao {
	/**
	 * Entrega todos los dispostivos que se encuentran almacenados en el sistema, sin importar
	 * si esta eliminado o no.
	 * @return lista de dispositivos
	 * @throws PrestamoDispositivoException
	 */
	public List<Dispositivo> obtener() throws PrestamoDispositivoException; 
	
	/**
	 * Entrega los datos de un dispositivo dado su id, si el dispositivo no exite retorna null
	 * @param id id del dispositivo
	 * @return 
	 * @return instancia del dispositivo con los datos, si no existe retorna nulo.
	 * @throws PrestamoDispositivoException
	 */
	public Dispositivo obtenerPorId(Integer id) throws PrestamoDispositivoException;
	
	/**
	 * permite guardar el dispositivo pasado como parametro
	 * @param dispositivo
	 * @return el dispositivo que ha sido guardado
	 * @throws PrestamoDispositivoException
	 */
	public Dispositivo guardar(Dispositivo dispositivo) throws PrestamoDispositivoException;
	
	/**
	 * permite actualizar los valores del dispositivo pasado como parametro
	 * @param dispositivo
	 * @return el dispositivo que ha sido actualizado
	 * @throws PrestamoDispositivoException
	 */
	public Dispositivo actualizar(Dispositivo dispositivo) throws PrestamoDispositivoException;
	
	/**
	 * permite eliminar el dispositivo pasado como parametro
	 * @param dispositivo
	 * @throws PrestamoDispositivoException
	 */
	public void eliminar(Dispositivo dispositivo) throws PrestamoDispositivoException;
	
	/**
	 * permite listar todos los dispositivos que esten disponibles
	 * @return la lista con los dispositivos disponibles
	 * @throws PrestamoDispositivoException
	 */
	public List<Dispositivo> verDispositivoDisponible () throws PrestamoDispositivoException;
}

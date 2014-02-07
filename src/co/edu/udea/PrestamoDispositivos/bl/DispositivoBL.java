package co.edu.udea.PrestamoDispositivos.bl;

import java.util.List;

import co.edu.udea.PrestamoDispositivos.model.Dispositivo;
import co.edu.udea.PrestamoDispositivos.util.exception.PrestamoDispositivoException;

/**
 * esta inferface se usa para definir los metodos que seran implementados por  la DispositivoBLImpl
 * @author Jonathan Medina
 *
 */
public interface DispositivoBL {
	
	/**
	 * este metodo se usara para guardar la descripcion del dispositivo, el estado en el cual se encuentra
	 * y el usuario. 
	 * @param descripcion corresponde a la descripcion del dispositivo
	 * @param estado corresponde al estado en el cual se encuentra el dispositivo
	 * @param usuario corresponde al usuario que presta el dispositivo
	 * @throws PrestamoDispositivoException es la clase de excepciones que es llamada en caso de presentarse errores
	 */
	
	public void guardar(String descripcion, String estado, String usuario) throws PrestamoDispositivoException;
	
	/**
	 * este metodo se usara para guardar las actualizaciones que se hagan sobre el dispositivo
	 * @param dispositivo corresponde al dispositivo del cual se quiere actualizar la informacion
	 * @param descripcion corresponde a la nueva descripcion del dispositivo
	 * @param estado corresponde al nuevo estado del dispositivo
	 * @param usuario corresponde al nuevo usuario del dispositivo
	 * @throws PrestamoDispositivoException es la clase de excepciones que es llamada en caso de presentarse errores
	 */
	public void actualizar(Dispositivo dispositivo, String descripcion, String estado, String usuario) throws PrestamoDispositivoException;
	
	/**
	 * este metodo se usara para eliminar un dispositivo 
	 * @param dispositivo corresponde al dispositivo que se quiere eliminar
	 * @throws PrestamoDispositivoException es la clase de excepciones que es llamada en caso de presentarse errores
	 */
	public void eliminar(Dispositivo dispositivo, String usuario) throws PrestamoDispositivoException;	

	/**
	 * este metodo permite obtener la lista de todos los dispositivos
	 * @return una lista con todos los dispositivos almacenados
	 * @throws PrestamoDispositivoException es la clase de excepciones que es llamada en caso de presentarse errores
	 */
	List<Dispositivo> obtener() throws PrestamoDispositivoException;

	/**
	 * este metodo permite obtener un dispositivo 
	 * @param id correponde a la identificacion del dispositivo que se quiere buscar
	 * @return el dispositivo correspondiente al id pasado como parametro
	 * @throws PrestamoDispositivoException es la clase de excepciones que es llamada en caso de presentarse errores
	 */
	Dispositivo obtenerPorId(Integer id) throws PrestamoDispositivoException;
	
	/**
	 * este metodo permite obtener la lista de todos los dispositivos disponibles
	 * @return una lista con todos los dispositivos disponibles
	 * @throws PrestamoDispositivoException es la clase de excepciones que es llamada en caso de presentarse errores
	 */
	List<Dispositivo> verDispositivosDisponibles() throws PrestamoDispositivoException;
}

package co.edu.udea.PrestamoDispositivos.dao;

import java.util.List;

import co.edu.udea.PrestamoDispositivos.model.Prestamo;
import co.edu.udea.PrestamoDispositivos.util.exception.PrestamoDispositivoException;
/**
 * 
 * @author Yamit cardozo
 *
 */
public interface PrestamoDao {

	/**
	 * Entrega todos los prestamos que se encuentran almacenados en el sistema, sin importar
	 * si esta eliminado o no.
	 * @return lista de prestamos
	 * @throws PrestamoDispositivoException
	 */
	public List<Prestamo> obtener() throws PrestamoDispositivoException; 
	
		
	/**
	 * Entrega los datos de un prestamo dado su codigo_prestamo, si el prestamo no exite retorna null
	 * @param codigo_prestamo codigo_prestamo del prestamo
	 * @return 
	 * @return instancia del prestamo con los datos, si no existe retorna nulo.
	 * @throws PrestamoDispositivoException
	 */
	public Prestamo obtenerPorCodigo(Integer codigo_prestamo) throws PrestamoDispositivoException;
	
	/**
	 * permite guardar el prestamo enviado como parametro
	 * @param prestamo
	 * @return retorna el prestamos que fue almacenado
	 * @throws PrestamoDispositivoException
	 */
	public Prestamo guardar(Prestamo prestamo) throws PrestamoDispositivoException;
	
	/**
	 * permite actualizar los valores de un prestamo 
	 * @param prestamo
	 * @return el prestamo actualizado
	 * @throws PrestamoDispositivoException
	 */
	public Prestamo actualizar(Prestamo prestamo) throws PrestamoDispositivoException;
	/**
	 * permite eliminar un prestamo pasado como parametro
	 * @param prestamo
	 * @throws PrestamoDispositivoException
	 */
	public void eliminar(Prestamo prestamo) throws PrestamoDispositivoException;
	/**
	 * permite listar todos los prestamos pendientes
	 * @return la lista con los prestamos pendientes
	 * @throws PrestamoDispositivoException
	 */
	public List<Prestamo> verPrestamosPendientes () throws PrestamoDispositivoException;
	
	
}

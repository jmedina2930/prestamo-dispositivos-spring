package co.edu.udea.PrestamoDispositivos.bl;

import java.util.Date;
import java.util.List;

import co.edu.udea.PrestamoDispositivos.model.Prestamo;
import co.edu.udea.PrestamoDispositivos.util.exception.PrestamoDispositivoException;

public interface PrestamoBL {
	/**
	 * Entrega todos los prestamos que se encuentran almacenados en el sistema, sin importar
	 * si esta eliminado o no.
	 * @return lista de prestamos
	 * @throws PrestamoDispositivoException
	 */
	List<Prestamo> obtener() throws PrestamoDispositivoException; 
	
		
	/**
	 * Entrega los datos de un prestamo dado su codigo_prestamo, si el prestamo no exite retorna null
	 * @param codigo_prestamo codigo_prestamo del prestamo
	 * @return 
	 * @return instancia del prestamo con los datos, si no existe retorna nulo.
	 * @throws PrestamoDispositivoException
	 */
	Prestamo obtenerPorCodigo(Integer codigo_prestamo) throws PrestamoDispositivoException;
	
	/**
	 * permite guardar el prestamo enviado como parametro
	 * @param nUsuario Nombre del usuario que realiza el prestamo
	 * @param fecha_inicial Fecha y hora de inicio del prestamo
	 * @param fecha_final Fecha y hora de terminacion del prestamo
	 * @param estado_prestamo Estado de aprobacion del prestamo
	 * @return retorna el prestamos que fue almacenado
	 * @throws PrestamoDispositivoException
	 */
	public Prestamo guardar(String nUsuario, Date fecha_inicial, Date fecha_final, String estado_prestamo) throws PrestamoDispositivoException;
	
	/**
	 * permite actualizar los valores de un prestamo 
	 * @param nUsuario Nombre del usuario que realiza el prestamo
	 * @param fecha_inicial Fecha y hora de inicio del prestamo
	 * @param fecha_final Fecha y hora de terminacion del prestamo
	 * @param estado_prestamo Estado de aprobacion del prestamo
	 * @return el prestamo actualizado
	 * @throws PrestamoDispositivoException
	 */
	public Prestamo actualizar(Prestamo prestamo, String nUsuario, Date fecha_inicial, Date fecha_final, String estado_prestamo) throws PrestamoDispositivoException;
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
	List<Prestamo> verPrestamosPendientes () throws PrestamoDispositivoException;
}

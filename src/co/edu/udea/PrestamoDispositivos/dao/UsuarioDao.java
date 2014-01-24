package co.edu.udea.PrestamoDispositivos.dao;

import java.util.List;
import java.util.Set;

import co.edu.udea.PrestamoDispositivos.model.Prestamo;
import co.edu.udea.PrestamoDispositivos.model.Usuario;
import co.edu.udea.PrestamoDispositivos.util.exception.PrestamoDispositivoException;
/**
 * 
 * @author Jonathan Medina
 *
 */
public interface UsuarioDao {
	/**
	 * Entrega todos los usuarios que se encuentran almacenados en el sistema, sin importar
	 * si esta eliminado o no.
	 * @return lista de los usuarios
	 * @throws PrestamoDispositivoException
	 */
	public List<Usuario> obtener() throws PrestamoDispositivoException;
	
	/**
	 * Entrega los datos de un usuario dado su cedula, si el usuario no exite retorna null
	 * @param cedula cedula del usuario
	 * @return 
	 * @return instancia del usuario con los datos, si no existe retorna nulo.
	 * @throws PrestamoDispositivoException
	 */
	public Usuario obtenerPorCedula(String cedula) throws PrestamoDispositivoException;
	/**
	 * Entrega los datos de un usuario dado su Usuario (nombre usado en el login)
	 * @param usuario (nombre usado en el login)
	 * @return retorna el usuario encontrado para el parametro ingresado
	 * @throws PrestamoDispositivoException
	 */
	public Usuario obtenerPorUsuario(String usuario) throws PrestamoDispositivoException;
	/**
	 * permite guardar un usuario entregado como parametro
	 * @param usuario
	 * @return el usuario que ha sido guardado
	 * @throws PrestamoDispositivoException
	 */
	public Usuario guardar(Usuario usuario) throws PrestamoDispositivoException;
	/**
	 * permite actualizar los datos de un usuario pasado como parametro
	 * @param usuario
	 * @return el usuario que ha sido actualizado
	 * @throws PrestamoDispositivoException
	 */
	public Usuario actualizar(Usuario usuario) throws PrestamoDispositivoException;
	/**
	 * permite eliminar el usuario ingresado como parametro
	 * @param usuario 
	 * @throws PrestamoDispositivoException
	 */
	public void eliminar(Usuario usuario) throws PrestamoDispositivoException;
	
	
}

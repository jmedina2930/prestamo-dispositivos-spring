package co.edu.udea.PrestamoDispositivos.bl;

import java.util.List;

import co.edu.udea.PrestamoDispositivos.model.Usuario;
import co.edu.udea.PrestamoDispositivos.util.exception.PrestamoDispositivoException;
/**
 * esta inferface se usa para definir los metodos que seran implementados por  la UsuarioBLImpl
 * @author Andres Ortiz
 *
 */
public interface UsuarioBL {
	/**
	 * Entrega todos los usuarios que se encuentran almacenados en el sistema, sin importar
	 * si esta eliminado o no.
	 * @author Yamit Cardozo
	 * @return lista de los usuarios
	 * @throws PrestamoDispositivoException es la clase de excepciones que es llamada en caso de presentarse errores
	 */
	List<Usuario> obtener() throws PrestamoDispositivoException;
	
	/**
	 * Entrega los datos de un usuario dado su cedula, si el usuario no exite retorna null
	 * @param cedula cedula del usuario
	 * @return 
	 * @return instancia del usuario con los datos, si no existe retorna nulo.
	 * @throws PrestamoDispositivoException es la clase de excepciones que es llamada en caso de presentarse errores
	 */
	Usuario obtenerPorCedula(String cedula) throws PrestamoDispositivoException;
	/**
	 * Entrega los datos de un usuario dado su Usuario (nombre usado en el login)
	 * @param usuario (nombre usado en el login)
	 * @return retorna el usuario encontrado para el parametro ingresado
	 * @throws PrestamoDispositivoException es la clase de excepciones que es llamada en caso de presentarse errores
	 */
	Usuario obtenerPorUsuario(String usuario) throws PrestamoDispositivoException;
	/**
	 * permite guardar un usuario entregado como parametro
	 * @param cedula Identificacion del usuario
	 * @param nombre Nombre del usuario
	 * @param apellidos Apellidos del usuario
	 * @param direccion Direccion de la casa del usuario
	 * @param usuario Nombre de usuario en el sistema
	 * @param telefono Telefono del usuario
	 * @param contraseņa Contraseņa de acceso al sistema del usuario
	 * @param rol Rol del usuario en el sistema
	 * @return el usuario que ha sido guardado
	 * @throws PrestamoDispositivoException es la clase de excepciones que es llamada en caso de presentarse errores
	 */
	public void guardar(String usuarioCreador, String cedula, String nombre, String apellidos, 
			String direccion, String usuario, String telefono, String contrasena, String rol) throws PrestamoDispositivoException;
	/**
	 * permite actualizar los datos de un usuario pasado como parametro
	 * @param cedula Identificacion del usuario
	 * @param nombre Nombre del usuario
	 * @param apellidos Apellidos del usuario
	 * @param direccion Direccion de la casa del usuario
	 * @param usuario Nombre de usuario en el sistema
	 * @param telefono Telefono del usuario
	 * @param contraseņa Contraseņa de acceso al sistema del usuario
	 * @param rol Rol del usuario en el sistema
	 * @return el usuario que ha sido actualizado
	 * @throws PrestamoDispositivoException es la clase de excepciones que es llamada en caso de presentarse errores
	 */
	public void actualizar(Usuario usuarioV, String usuarioCreador, String cedula, String nombre, String apellidos, 
			String direccion, String telefono, String contrasena, String rol) throws PrestamoDispositivoException;
	/**
	 * permite eliminar el usuario ingresado como parametro
	 * @param usuario 
	 * @throws PrestamoDispositivoException es la clase de excepciones que es llamada en caso de presentarse errores
	 */
	public void eliminar(Usuario usuario) throws PrestamoDispositivoException;
}

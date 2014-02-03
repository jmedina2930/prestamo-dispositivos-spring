package co.edu.udea.PrestamoDispositivos.bl.impl;

import java.util.List;

import co.edu.udea.PrestamoDispositivos.bl.UsuarioBL;
import co.edu.udea.PrestamoDispositivos.dao.UsuarioDao;
import co.edu.udea.PrestamoDispositivos.model.Prestamo;
import co.edu.udea.PrestamoDispositivos.model.Usuario;
import co.edu.udea.PrestamoDispositivos.util.exception.PrestamoDispositivoException;

/**
 * esta clase implementa los metodos
 * encargados de manejar la logica del negocio para el manejo de los usuarios
 * @author Yamit Cardozo
 *
 */

public class UsuarioBLImpl implements UsuarioBL {
	
	UsuarioDao usuarioDAO;
	
	/**
	 * este metodo usa para obtener todos los usuarios, hace uso del metodo
	 * obtener definido en usuarioDAO
	 */
	@Override
	public List<Usuario> obtener() throws PrestamoDispositivoException {
		return usuarioDAO.obtener();
	}

	/**
	 * este metodo usa para obtener un usuario, recibe como parametro la cedula
	 * del usuario que se desea buscar se valida que la cedula no sea nula y hace uso
	 * del metodo obtenerPorCedula definido en usuarioDAO
	 */
	@Override
	public Usuario obtenerPorCedula(String cedula)
			throws PrestamoDispositivoException {
		if (cedula.equals("") || cedula==null)
			throw new PrestamoDispositivoException("El numero de cedula no puede ser nula ni vacia");
		
		return usuarioDAO.obtenerPorCedula(cedula);
	}

	
	/**
	 * este metodo usa para obtener un usuario, recibe como parametro el nombre del usuario
	 * que se desea buscar se valida que el nombre de usuario no sea nulo y hace uso
	 * del metodo obtenerPorUsuario definido en usuarioDAO
	 */
	@Override
	public Usuario obtenerPorUsuario(String usuario)
			throws PrestamoDispositivoException {
		if (usuario.equals("") || usuario==null)
			throw new PrestamoDispositivoException("El nombre de usuario no puede ser nulo ni vacio");
		
		return usuarioDAO.obtenerPorUsuario(usuario);
	}

	/**
	 * este metodo se usa para guardar un usuario nuevo, recibe como parametros el usuario
	 * quien crea, y la informacion del nuevo usuario, se valida que los datos de entrada sean
	 * correctos y se hace uso de los metodos definidos en usuarioDAO para guardar los datos
	 */
	@Override
	public void guardar(String usuarioCreador, String cedula, String nombre, String apellidos,
			String direccion, String usuario, String telefono,
			String contrasena, String rol) throws PrestamoDispositivoException {
		if(cedula == null || "".equals(cedula))
			throw new PrestamoDispositivoException("La cedula del usuario no puede ser un valor nulo no vacio");
		
		if(nombre == null 	|| "".equals(nombre))
			throw new PrestamoDispositivoException("El nombre del usuario no puede ser nulo ni un valor vacío");

		if(apellidos == null || "".equals(apellidos))
			throw new PrestamoDispositivoException("El apellido del usuario no puede ser nulo ni un valor vacío");
		
		if(direccion == null || "".equals(direccion))
			throw new PrestamoDispositivoException("La direccion del usuario no puede ser nulo ni un valor vacío");
		
		if(telefono == null || "".equals(telefono))
			throw new PrestamoDispositivoException("El telefono del usuario no puede ser nulo ni un valor vacío");
		
		if(usuario == null || "".equals(usuario))
			throw new PrestamoDispositivoException("El nombre de usuario no puede ser nulo ni un valor vacío");
		
		if(usuarioCreador == null || "".equals(usuarioCreador))
			throw new PrestamoDispositivoException("El usuario que crea el cliente no puede ser nulo ni un valor vacío");
		
		if(contrasena == null || "".equals(contrasena))
			throw new PrestamoDispositivoException("La contraseña del usuario no puede ser nulo ni un valor vacío");
		
		if(!(rol.equalsIgnoreCase("administrador") || rol.equalsIgnoreCase("investigador")))
			throw new PrestamoDispositivoException("El rol del usuario debe ser administrador o investigador");			
		
		Usuario objUsuario =  usuarioDAO.obtenerPorUsuario(usuarioCreador);		
		
		if(objUsuario == null)
			throw new PrestamoDispositivoException("El usuario que crea el usuario debe ser un usuario valido en el sistema");
		if(!(objUsuario.getRol().equalsIgnoreCase("administrador")))
			throw new PrestamoDispositivoException("El usuario que modifica el usuario debe ser administrador del sistema");
		
		Usuario usuarioNuevo = new Usuario();
		usuarioNuevo.setNombre(nombre);
		usuarioNuevo.setApellidos(apellidos);
		usuarioNuevo.setCedula(cedula);
		usuarioNuevo.setContrasena(contrasena);
		usuarioNuevo.setDireccion(direccion);
		usuarioNuevo.setRol(rol);
		usuarioNuevo.setTelefono(telefono);
		usuarioNuevo.setUsuario(usuario);
		
		
		usuarioDAO.guardar(usuarioNuevo);	
	}
	

	/**
	 * este metodo se usa para actualizar un usuario , recibe como parametros el usuario
	 * del cual se desea modificar informacion, el usuario que lo creo y los datos a modificar,
	 * se valida que los datos de entrada sean correctos y se hace uso de los metodos definidos en usuarioDAO 
	 * para guardar los cambios
	 * 
	 */
	@Override
	public void actualizar(Usuario usuarioV, String usuarioCreador, String cedula, String nombre, String apellidos,
			String direccion, String usuario, String telefono, String contrasena, String rol)
			throws PrestamoDispositivoException {
		Usuario objUsuario = null;
		if(cedula != null && !"".equals(cedula))
			usuarioV.setCedula(cedula);		
		if(nombre != null 	&& !"".equals(nombre))
			usuarioV.setNombre(nombre);
		if(apellidos != null && !"".equals(apellidos))
			usuarioV.setApellidos(apellidos);		
		if(direccion != null && !"".equals(direccion))
			usuarioV.setDireccion(direccion);		
		if(telefono != null && !"".equals(telefono))
			usuarioV.setTelefono(telefono);		
		if(usuario != null && !"".equals(usuario))
			usuarioV.setUsuario(usuario);		
		if(usuarioCreador != null && !"".equals(usuarioCreador))
			objUsuario =  usuarioDAO.obtenerPorUsuario(usuarioCreador);		
		if(contrasena != null && !"".equals(contrasena))
			usuarioV.setContrasena(contrasena);		
		if(rol.equalsIgnoreCase("administrador") || rol.equalsIgnoreCase("investigador"))			
			usuarioV.setRol(rol);			
		
		if(objUsuario == null)
			throw new PrestamoDispositivoException("El usuario que crea el usuario nuevo debe ser un usuario valido en el sistema");
		if(!(objUsuario.getRol().equalsIgnoreCase("administrador")))
			throw new PrestamoDispositivoException("El usuario que modifica el usuario debe ser administrador del sistema");
		
		usuarioDAO.actualizar(usuarioV);		
	}

	/**
	 * metodo usado para eliminar un usuario, recibe como parametro el usuario que 
	 * se desea eliminar
	 */
	@Override
	public void eliminar(Usuario usuario) throws PrestamoDispositivoException {
		if (usuario==null)
			throw new PrestamoDispositivoException("El usuario no puede nulo");
		usuarioDAO.eliminar(usuario);	
		
	}

}

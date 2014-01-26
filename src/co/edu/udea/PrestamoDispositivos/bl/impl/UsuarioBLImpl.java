package co.edu.udea.PrestamoDispositivos.bl.impl;

import java.util.List;

import co.edu.udea.PrestamoDispositivos.bl.UsuarioBL;
import co.edu.udea.PrestamoDispositivos.dao.UsuarioDao;
import co.edu.udea.PrestamoDispositivos.model.Prestamo;
import co.edu.udea.PrestamoDispositivos.model.Usuario;
import co.edu.udea.PrestamoDispositivos.util.exception.PrestamoDispositivoException;

public class UsuarioBLImpl implements UsuarioBL {
	
	UsuarioDao usuarioDao;
	@Override
	public List<Usuario> obtener() throws PrestamoDispositivoException {
		return usuarioDao.obtener();
	}

	@Override
	public Usuario obtenerPorCedula(String cedula)
			throws PrestamoDispositivoException {
		if (cedula.equals("") || cedula==null)
			throw new PrestamoDispositivoException("El numero de cedula no puede ser nula ni vacia");
		
		return usuarioDao.obtenerPorCedula(cedula);
	}

	@Override
	public Usuario obtenerPorUsuario(String usuario)
			throws PrestamoDispositivoException {
		if (usuario.equals("") || usuario==null)
			throw new PrestamoDispositivoException("El nombre de usuario no puede ser nulo ni vacio");
		
		return usuarioDao.obtenerPorUsuario(usuario);
	}

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
		
		Usuario objUsuario =  usuarioDao.obtenerPorUsuario(usuarioCreador);		
		
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
		
		
		usuarioDao.guardar(usuarioNuevo);	
	}
	

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
			objUsuario =  usuarioDao.obtenerPorUsuario(usuarioCreador);		
		if(contrasena != null && !"".equals(contrasena))
			usuarioV.setContrasena(contrasena);		
		if(rol.equalsIgnoreCase("administrador") || rol.equalsIgnoreCase("investigador"))			
			usuarioV.setRol(rol);			
		
		if(objUsuario == null)
			throw new PrestamoDispositivoException("El usuario que crea el usuario nuevo debe ser un usuario valido en el sistema");
		if(!(objUsuario.getRol().equalsIgnoreCase("administrador")))
			throw new PrestamoDispositivoException("El usuario que modifica el usuario debe ser administrador del sistema");
		
		usuarioDao.actualizar(usuarioV);		
	}

	@Override
	public void eliminar(Usuario usuario) throws PrestamoDispositivoException {
		if (usuario==null)
			throw new PrestamoDispositivoException("El usuario no puede nulo");
		usuarioDao.eliminar(usuario);	
		
	}

}

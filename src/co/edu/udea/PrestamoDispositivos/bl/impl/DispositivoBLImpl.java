package co.edu.udea.PrestamoDispositivos.bl.impl;

import java.util.List;

import co.edu.udea.PrestamoDispositivos.bl.DispositivoBL;
import co.edu.udea.PrestamoDispositivos.dao.DispositivoDao;
import co.edu.udea.PrestamoDispositivos.dao.UsuarioDao;
import co.edu.udea.PrestamoDispositivos.model.Dispositivo;
import co.edu.udea.PrestamoDispositivos.model.Usuario;
import co.edu.udea.PrestamoDispositivos.util.exception.PrestamoDispositivoException;
/**
 * esta clase implementa los metodos
 * encargados de manejar la logica del negocio para los dispositivos
 * @author 
 *
 */

public class DispositivoBLImpl implements DispositivoBL {
	
	DispositivoDao dispositivoDAO;
	UsuarioDao usuarioDAO;
	

	/**
	 * este metodo es usado para guardar la descripcion de un dispositivo,
	 * el estado en que se encuentre y el usuario que lo creo, en el se realizan 
	 * las validaciones del negocio tales como que la descripcion no sea nula, que los 
	 * valores para el estado sean validos (disponible, ocupado)
	 * este metodo hace uso de los metodos definidos en los DAOs para guardar la informacion
	 */
	@Override
	public void guardar(String descripcion, String estado, String usuario)
			throws PrestamoDispositivoException {
		if(descripcion == null || "".equals(descripcion))
			throw new PrestamoDispositivoException("La descripcion del dispositivo no puede ser un valor nulo ni vacio");
		
		if(!(estado.equalsIgnoreCase("disponible") || estado.equalsIgnoreCase("ocupado")))
			throw new PrestamoDispositivoException("El estado del dispositivo debe ser disponible u ocupado");	
		
		Dispositivo dispositivo = new Dispositivo();
		dispositivo.setDescripcion(descripcion);
		dispositivo.setEstado(estado);
		
		Usuario objUsuario =  usuarioDAO.obtenerPorUsuario(usuario);
		
		
		if(objUsuario == null)
			throw new PrestamoDispositivoException("El usuario que crea el dispositivo debe ser un usuario valido en el sistema");
		if(!(objUsuario.getRol().equals("administrador")))
			throw new PrestamoDispositivoException("El usuario que crea el dispositivo debe ser administrador del sistema");	
		
		dispositivoDAO.guardar(dispositivo);
		
	}
	
	/**
	 * este metodo se usa para actualizar la informacion de un dispositivo
	 * recibe como parametros el dispositivo del cual se desea actualizar su informacion
	 * y la informacion, tambien se realizan las validaciones de entrada de datos para este caso
	 * este metodo hace uso de los metodos definidos en los DAOs para guardar la informacion
	 */
	@Override
	public void actualizar(Dispositivo dispositivo, String descripcion,
			String estado, String usuario) throws PrestamoDispositivoException {
		if(descripcion != null && !"".equals(descripcion))
			dispositivo.setDescripcion(descripcion);
		
		if(estado.equals("disponible") || estado.equalsIgnoreCase("ocupado"))
			dispositivo.setEstado(estado);		
		
		Usuario objUsuario =  usuarioDAO.obtenerPorUsuario(usuario);
		
		
		if(objUsuario == null)
			throw new PrestamoDispositivoException("El usuario que modifica el dispositivo debe ser un usuario valido en el sistema");
		if(!(objUsuario.getRol().equals("administrador")))
			throw new PrestamoDispositivoException("El usuario que modifica el dispositivo debe ser administrador del sistema");
		
		dispositivoDAO.actualizar(dispositivo);
		
	}

	/**
	 * este metodo es usado para eliminar un dispositivo, recibe como parametro el 
	 * dispositivo que se desea eliminar
	 * este metodo hace uso de los metodos definidos en los DAOs para eliminar el dispositivo
	 */

	@Override
	public void eliminar(Dispositivo dispositivo)
			throws PrestamoDispositivoException {
		if(dispositivo==null)
			throw new PrestamoDispositivoException("El dispositivo a eliminar no puede ser nulo");
		
		dispositivoDAO.eliminar(dispositivo);
		
	}
	
	/**
	 * este metodo retorna una lista con todos los dispositivos
	 * este metodo hace uso de los metodos definidos en los DAOs para  recoger la informacion
	 */

	@Override
	public List<Dispositivo> obtener() throws PrestamoDispositivoException {
		return dispositivoDAO.obtener();
	}

	/**
	 * este metodo se usa para obtener un dispositivo usando su id 
	 * hace uso de los metodos definidos en los DAOs para  recoger la informacion
	 */
	
	@Override
	public Dispositivo obtenerPorId(Integer id)
			throws PrestamoDispositivoException {
		if (id==null)
			throw new PrestamoDispositivoException("El id del dispositivo no puede ser nulo");
		return dispositivoDAO.obtenerPorId(id);
	}	

}

	



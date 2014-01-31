package co.edu.udea.PrestamoDispositivos.bl.impl;

import java.util.List;

import co.edu.udea.PrestamoDispositivos.bl.DispositivoBL;
import co.edu.udea.PrestamoDispositivos.dao.DispositivoDao;
import co.edu.udea.PrestamoDispositivos.dao.UsuarioDao;
import co.edu.udea.PrestamoDispositivos.model.Dispositivo;
import co.edu.udea.PrestamoDispositivos.model.Usuario;
import co.edu.udea.PrestamoDispositivos.util.exception.PrestamoDispositivoException;


public class DispositivoBLImpl implements DispositivoBL {
	
	DispositivoDao dispositivoDao;
	UsuarioDao usuarioDao;
	

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
		
		Usuario objUsuario =  usuarioDao.obtenerPorUsuario(usuario);
		
		
		if(objUsuario == null)
			throw new PrestamoDispositivoException("El usuario que crea el dispositivo debe ser un usuario valido en el sistema");
		if(!(objUsuario.getRol().equals("administrador")))
			throw new PrestamoDispositivoException("El usuario que crea el dispositivo debe ser administrador del sistema");	
		
		dispositivoDao.guardar(dispositivo);
		
	}
	
	@Override
	public void actualizar(Dispositivo dispositivo, String descripcion,
			String estado, String usuario) throws PrestamoDispositivoException {
		if(descripcion != null && !"".equals(descripcion))
			dispositivo.setDescripcion(descripcion);
		
		if(estado.equals("disponible") || estado.equalsIgnoreCase("ocupado"))
			dispositivo.setEstado(estado);		
		
		Usuario objUsuario =  usuarioDao.obtenerPorUsuario(usuario);
		
		
		if(objUsuario == null)
			throw new PrestamoDispositivoException("El usuario que modifica el dispositivo debe ser un usuario valido en el sistema");
		if(!(objUsuario.getRol().equals("administrador")))
			throw new PrestamoDispositivoException("El usuario que modifica el dispositivo debe ser administrador del sistema");
		
		dispositivoDao.actualizar(dispositivo);
		
	}

	

	@Override
	public void eliminar(Dispositivo dispositivo)
			throws PrestamoDispositivoException {
		if(dispositivo==null)
			throw new PrestamoDispositivoException("El dispositivo a eliminar no puede ser nulo");
		
		dispositivoDao.eliminar(dispositivo);
		
	}

	@Override
	public List<Dispositivo> obtener() throws PrestamoDispositivoException {
		return dispositivoDao.obtener();
	}

	@Override
	public Dispositivo obtenerPorId(Integer id)
			throws PrestamoDispositivoException {
		if (id==null)
			throw new PrestamoDispositivoException("El id del dispositivo no puede ser nulo");
		return dispositivoDao.obtenerPorId(id);
	}	

}

	



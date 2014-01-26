package co.edu.udea.PrestamoDispositivos.bl.impl;

import java.util.Date;
import java.util.List;

import co.edu.udea.PrestamoDispositivos.bl.PrestamoBL;
import co.edu.udea.PrestamoDispositivos.dao.PrestamoDao;
import co.edu.udea.PrestamoDispositivos.dao.UsuarioDao;
import co.edu.udea.PrestamoDispositivos.model.Dispositivo;
import co.edu.udea.PrestamoDispositivos.model.Prestamo;
import co.edu.udea.PrestamoDispositivos.model.Usuario;
import co.edu.udea.PrestamoDispositivos.util.exception.PrestamoDispositivoException;

public class PrestamoBLImpl implements PrestamoBL {

	PrestamoDao prestamoDao;
	UsuarioDao usuarioDao;
	@Override
	public List<Prestamo> obtener() throws PrestamoDispositivoException {
		return prestamoDao.obtener(); 
	}

	@Override
	public Prestamo obtenerPorCodigo(Integer codigo_prestamo)
			throws PrestamoDispositivoException {
		if (codigo_prestamo==null)
			throw new PrestamoDispositivoException("El codigo del prestamo no puede ser nulo");
		
		return prestamoDao.obtenerPorCodigo(codigo_prestamo);
	}

	@Override
	public Prestamo guardar(String nUsuario, Date fecha_inicial,
			Date fecha_final, String estado_prestamo)
			throws PrestamoDispositivoException {
		Date fecha_actual = new Date();
		if (nUsuario == null || "".equals(nUsuario))
			throw new PrestamoDispositivoException("el usuario no puede ser un valor nulo ni vacio");		
		if (fecha_inicial==null || "".equals(fecha_inicial))
			throw new PrestamoDispositivoException("La fecha inicial no puede ser un valor nulo ni vacio");
		if (fecha_final==null || "".equals(fecha_final))
			throw new PrestamoDispositivoException("La fecha final no puede ser un valor nulo ni vacio");
		if (fecha_inicial.before(fecha_actual))
				throw new PrestamoDispositivoException("La fecha inicial no puede ser menor que la fecha actual");				
		if (fecha_final.before(fecha_inicial))
			throw new PrestamoDispositivoException("La fecha final no puede ser menor que la fecha inicial");
		if(!(estado_prestamo.equalsIgnoreCase("aprobado") || estado_prestamo.equalsIgnoreCase("pendiente")))
			throw new PrestamoDispositivoException("El estado del prestamo debe ser aprobado o pendiente");
		
		Usuario objUsuario =  usuarioDao.obtenerPorUsuario(nUsuario);		
		
		if(objUsuario == null)
			throw new PrestamoDispositivoException("El usuario que crea el dispositivo debe ser un usuario valido en el sistema");
		
		Prestamo prestamo = new Prestamo();
		prestamo.setEstado_prestamo(estado_prestamo);
		prestamo.setUsuario(objUsuario);			
		
		prestamoDao.guardar(prestamo);
		return prestamo;
	}

	@Override
	public Prestamo actualizar(Prestamo prestamo, String nUsuario, Date fecha_inicial,
			Date fecha_final, String estado_prestamo)
			throws PrestamoDispositivoException {
		Date fecha_actual = new Date();		
		Usuario objUsuario = null;
		if (nUsuario != null && !"".equals(nUsuario))
			objUsuario =  usuarioDao.obtenerPorUsuario(nUsuario);
		if (objUsuario != null)
			prestamo.setUsuario(objUsuario);					
		if (fecha_inicial!=null && !"".equals(fecha_inicial) && (fecha_inicial.before(fecha_actual)))
			prestamo.setFecha_inicial(fecha_inicial);
		if (fecha_final!=null && !"".equals(fecha_final) && (fecha_final.before(fecha_inicial)))
			prestamo.setFecha_final(fecha_final);			
		if(estado_prestamo.equalsIgnoreCase("aprobado") || estado_prestamo.equalsIgnoreCase("pendiente"))
			prestamo.setEstado_prestamo(estado_prestamo);				
		
		prestamoDao.actualizar(prestamo);
		return prestamo;
	}

	@Override
	public void eliminar(Prestamo prestamo) throws PrestamoDispositivoException {
		if (prestamo==null)
			throw new PrestamoDispositivoException("El prestamo no puede ser nulo");
		prestamoDao.eliminar(prestamo);		
	}

	@Override
	public List<Prestamo> verPrestamosPendientes()
			throws PrestamoDispositivoException {		
		return prestamoDao.verPrestamosPendientes();
	}
	
}

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

/**
 * esta clase implementa los metodos
 * encargados de manejar la logica del negocio para los prestamos
 * @author Mauricio Ortiz - Jonathan Medina
 *
 */


public class PrestamoBLImpl implements PrestamoBL {

	PrestamoDao prestamoDAO;
	UsuarioDao usuarioDAO;
	
	
	
	public PrestamoDao getPrestamoDAO() {
		return prestamoDAO;
	}

	public void setPrestamoDAO(PrestamoDao prestamoDAO) {
		this.prestamoDAO = prestamoDAO;
	}

	public UsuarioDao getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDao usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	/**
	 * este metodo obtiene la lista de prestamos, para esto usa el metodo 
	 * obtener definido en prestamoDAO
	 */
	@Override
	public List<Prestamo> obtener() throws PrestamoDispositivoException {
		return prestamoDAO.obtener(); 
	}

	/**
	 * este metodo obtiene un prestamo buscandolo por su id, recibe como parametro
	 * el id del prestamos que se desea buscar, para esto usa el metodo
	 *  obtenerPorCodigo definido en el DAO, tambien se valida que este id no sea nulo
	 */
	@Override
	public Prestamo obtenerPorCodigo(Integer codigo_prestamo)
			throws PrestamoDispositivoException {
		if (codigo_prestamo==null)
			throw new PrestamoDispositivoException("El codigo del prestamo no puede ser nulo");
		
		return prestamoDAO.obtenerPorCodigo(codigo_prestamo);
	}

	/**
	 * este metodo se usa para guardar un nuevo prestamo, recibe como parametros
	 * el nombre de usuario asociado al prestamo, la fecha y hora inicial y final 
	 * del prestamo y el estado del prestamo, se hacen las validaciones correspondientes
	 * tales como que el usuario, fecha no sean nulos y que el estado del prestamo
	 * sea aprobado o pendiente, para guardar los datos utiliza los metodos definidos en 
	 * usuarioDAO y prestamoDAO
	 *  
	 */
	
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
		
		Usuario objUsuario =  usuarioDAO.obtenerPorUsuario(nUsuario);		
		
		if(objUsuario == null)
			throw new PrestamoDispositivoException("El usuario que crea el dispositivo debe ser un usuario valido en el sistema");
		
		Prestamo prestamo = new Prestamo();
		prestamo.setEstado_prestamo(estado_prestamo);
		prestamo.setUsuario(objUsuario);			
		
		prestamoDAO.guardar(prestamo);
		return prestamo;
	}

	/**
	 * este metodo se usa para actualizar los valores de un prestamo, recibe como parametros
	 * el prestamo, el nombre de usuario asociado al prestamo, la fecha y hora inicial y final 
	 * del prestamo y el estado del prestamo, se hacen las validaciones correspondientes
	 * tales como que el usuario, fecha no sean nulos y que el estado del prestamo
	 * sea aprobado o pendiente, para guardar los datos utiliza los metodos definidos en 
	 * usuarioDAO y prestamoDAO
	 *  
	 */
	
	@Override
	public Prestamo actualizar(Prestamo prestamo, String nUsuario, Date fecha_inicial,
			Date fecha_final, String estado_prestamo)
			throws PrestamoDispositivoException {
		Date fecha_actual = new Date();		
		Usuario objUsuario = null;
		if (nUsuario != null && !"".equals(nUsuario))
			objUsuario =  usuarioDAO.obtenerPorUsuario(nUsuario);
		if (objUsuario != null)
			prestamo.setUsuario(objUsuario);					
		if (fecha_inicial!=null && !"".equals(fecha_inicial) && (fecha_inicial.before(fecha_actual)))
			prestamo.setFecha_inicial(fecha_inicial);
		if (fecha_final!=null && !"".equals(fecha_final) && (fecha_final.before(fecha_inicial)))
			prestamo.setFecha_final(fecha_final);			
		if(estado_prestamo.equalsIgnoreCase("aprobado") || estado_prestamo.equalsIgnoreCase("pendiente"))
			prestamo.setEstado_prestamo(estado_prestamo);				
		
		prestamoDAO.actualizar(prestamo);
		return prestamo;
	}

	/**
	 * este metodo se usa para eliminar un prestamo que es pasado como parametro
	 * para hacer esto realiza la validacion que el prestamo no sea nulo y hace uso del
	 * metodo eliminar definido en prestamoDAO
	 */
	@Override
	public void eliminar(Prestamo prestamo) throws PrestamoDispositivoException {
		if (prestamo==null)
			throw new PrestamoDispositivoException("El prestamo no puede ser nulo");
		prestamoDAO.eliminar(prestamo);		
	}

	/**
	 * este metodo se usa para listar todos los prestamos cuyo estado sea pendiente
	 * 
	 */
	@Override
	public List<Prestamo> verPrestamosPendientes()
			throws PrestamoDispositivoException {		
		return prestamoDAO.verPrestamosPendientes();
	}
	
}

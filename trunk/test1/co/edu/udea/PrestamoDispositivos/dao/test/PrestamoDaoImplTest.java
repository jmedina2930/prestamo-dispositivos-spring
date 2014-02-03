/**
 * 
 */
package co.edu.udea.PrestamoDispositivos.dao.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import co.edu.udea.PrestamoDispositivos.dao.PrestamoDao;
import co.edu.udea.PrestamoDispositivos.dao.impl.PrestamoDaoImpl;
import co.edu.udea.PrestamoDispositivos.model.Dispositivo;
import co.edu.udea.PrestamoDispositivos.model.Prestamo;
import co.edu.udea.PrestamoDispositivos.model.Usuario;
import co.edu.udea.PrestamoDispositivos.util.exception.PrestamoDispositivoException;


/**
 * @author Yamit Cardozo - Mauricio Ortiz
 *
 */
public class PrestamoDaoImplTest {
	
	/**
	 * prueba unitaria para obtenes toda la lista de prestamos que se han realizado.
	 * @throws PrestamoDispositivoException
	 */
	//@Test
	public void testObtener() throws PrestamoDispositivoException {
		try{
			PrestamoDao dao = new PrestamoDaoImpl();
			
			List<Prestamo> lista = dao.obtener();
			
			for(Prestamo prestamo : lista){
				
				System.out.println("codigo prestamo: " + prestamo.getCodigo_prestamo());
				System.out.println("Estado prestamo: " + prestamo.getEstado_prestamo());
				
			}
		}catch ( PrestamoDispositivoException e) {
			throw new PrestamoDispositivoException(e);
		}
	}
	
	/**
	 * prueba unitaria para obtener el prestamo especificado por el codigo.
	 * @throws PrestamoDispositivoException
	 */
	//@Test
	public void testObtenerPorCodigo() throws PrestamoDispositivoException {

		try{
			PrestamoDao dao = new PrestamoDaoImpl();
			
			Prestamo prestamo = dao.obtenerPorCodigo(4);
			
			if(prestamo != null)
				System.out.println("El codigo prestamo es: " + prestamo.getCodigo_prestamo() + " el estado es " + prestamo.getEstado_prestamo());
			
		}catch ( PrestamoDispositivoException e) {
			throw new PrestamoDispositivoException(e);
		}
	}

	/**
	 * prueba unitaria parera guardar el prestamo que se solicita
	 * @throws PrestamoDispositivoException
	 */
	@Test
	public void testGuardar() throws PrestamoDispositivoException {
	
		try{
		Date date = new Date(2014,01,19);
		date.setHours(10);
		Dispositivo d = new Dispositivo();
		Usuario u = new Usuario();
		PrestamoDao dao = new PrestamoDaoImpl();
		Prestamo a = new Prestamo();
		d.setId_dispositivo(5);
		u.setUsuario("jjonathan.medina");		
		a.setEstado_prestamo("pendiente");
		a.setFecha_inicial(date);
		date.setHours(14);
		a.setFecha_final(date);
		a.setId_dispositivo(d);
		a.setUsuario(u);
		dao.guardar(a);
		System.out.println("prestamo almacenado");
		}catch(PrestamoDispositivoException e){
			throw new PrestamoDispositivoException(e);
		}
	}
	
	/**
	 * prueba unitaria para actualizar un prestamo en la base de datos
	 * @throws PrestamoDispositivoException
	 */
	//@Test
	public void testActualizar() throws PrestamoDispositivoException {
		
		try{
			Date date = new Date(2014,01,19);
			date.setHours(10);
			Dispositivo d = new Dispositivo();
			Usuario u = new Usuario();
			PrestamoDao dao = new PrestamoDaoImpl();
			Prestamo a = new Prestamo();
			d.setId_dispositivo(4);
			a.setCodigo_prestamo(3);
			u.setUsuario("jjonathan.medina");			
			a.setEstado_prestamo("aprobado");
			a.setFecha_inicial(date);
			date.setHours(14);
			a.setFecha_final(date);
			a.setId_dispositivo(d);
			a.setUsuario(u);
			dao.actualizar(a);
			System.out.println("prestamo actualizado");
			}catch(PrestamoDispositivoException e){
				throw new PrestamoDispositivoException(e);
			}
	}
	
	/**
	 * prueba unitaria que elimina de la base  de datos un registro de prestamo.
	 * @throws PrestamoDispositivoException
	 */
	//@Test
	public void testEliminar() throws PrestamoDispositivoException {
		try{
			Date date = new Date(2014,01,19);
			date.setHours(10);
			Dispositivo d = new Dispositivo();
			Usuario u = new Usuario();
			PrestamoDao dao = new PrestamoDaoImpl();
			Prestamo a = new Prestamo();
			d.setId_dispositivo(4);
			a.setCodigo_prestamo(3);
			u.setUsuario("jjonathan.medina");			
			a.setEstado_prestamo("pendiente");
			a.setFecha_inicial(date);
			date.setHours(14);
			a.setFecha_final(date);
			a.setId_dispositivo(d);
			a.setUsuario(u);
			dao.eliminar(a);
			System.out.println(" prestamo eliminado");
			}catch(PrestamoDispositivoException e){
				throw new PrestamoDispositivoException(e);
			}
	}
	
	/**
	 * prueba unitaria que obtiene todos los prestamos pendientes.
	 * @throws PrestamoDispositivoException
	 */
	//@Test
	public void testObtenerPendientes() throws PrestamoDispositivoException {
		try{
			PrestamoDao dao = new PrestamoDaoImpl();
			
			List<Prestamo> lista = dao.verPrestamosPendientes();
			
			for(Prestamo prestamo : lista){
				
				System.out.println("codigo prestamo: " + prestamo.getCodigo_prestamo());
				System.out.println("Estado prestamo: " + prestamo.getEstado_prestamo());
				
			}
		}catch ( PrestamoDispositivoException e) {
			throw new PrestamoDispositivoException(e);
		}
	}

}

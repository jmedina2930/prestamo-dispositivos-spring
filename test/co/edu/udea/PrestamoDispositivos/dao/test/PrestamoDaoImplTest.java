/**
 * 
 */
package co.edu.udea.PrestamoDispositivos.dao.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.PrestamoDispositivos.dao.PrestamoDao;
import co.edu.udea.PrestamoDispositivos.dao.impl.PrestamoDaoImpl;
import co.edu.udea.PrestamoDispositivos.model.Dispositivo;
import co.edu.udea.PrestamoDispositivos.model.Prestamo;
import co.edu.udea.PrestamoDispositivos.model.Usuario;
import co.edu.udea.PrestamoDispositivos.util.exception.PrestamoDispositivoException;

@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
@ContextConfiguration(locations = "classpath:spring_configuration.xml")

/**
 * @author Yamit Cardozo - Mauricio Ortiz
 *
 */
public class PrestamoDaoImplTest {
	@Autowired
	PrestamoDao prestamoDao;
	
	/**
	 * prueba unitaria para obtenes toda la lista de prestamos que se han realizado.
	 * @throws PrestamoDispositivoException
	 */
	//@Test
	public void testObtener() throws PrestamoDispositivoException {
		try{
			List<Prestamo> lista = prestamoDao.obtener();
			
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
			Prestamo prestamo = prestamoDao.obtenerPorCodigo(4);
			
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
		Dispositivo dispositivo = new Dispositivo();
		Usuario usuario = new Usuario();		
		Prestamo prestamo = new Prestamo();
		dispositivo.setId_dispositivo(5);
		usuario.setUsuario("jjonathan.medina");		
		prestamo.setEstado_prestamo("pendiente");
		prestamo.setFecha_inicial(date);
		date.setHours(14);
		prestamo.setFecha_final(date);
		prestamo.setId_dispositivo(dispositivo);
		prestamo.setUsuario(usuario);
		prestamoDao.guardar(prestamo);
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
			Dispositivo dispositivo = new Dispositivo();
			Usuario usuario = new Usuario();		
			Prestamo prestamo = new Prestamo();
			dispositivo.setId_dispositivo(5);
			usuario.setUsuario("jjonathan.medina");		
			prestamo.setEstado_prestamo("pendiente");
			prestamo.setFecha_inicial(date);
			date.setHours(14);
			prestamo.setFecha_final(date);
			prestamo.setId_dispositivo(dispositivo);
			prestamo.setUsuario(usuario);			
			prestamo.setCodigo_prestamo(3);			
			prestamoDao.actualizar(prestamo);
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
			Dispositivo dispositivo = new Dispositivo();
			Usuario usuario = new Usuario();		
			Prestamo prestamo = new Prestamo();
			dispositivo.setId_dispositivo(5);
			usuario.setUsuario("jjonathan.medina");		
			prestamo.setEstado_prestamo("pendiente");
			prestamo.setFecha_inicial(date);
			date.setHours(14);
			prestamo.setFecha_final(date);
			prestamo.setId_dispositivo(dispositivo);
			prestamo.setUsuario(usuario);
			prestamo.setCodigo_prestamo(3);			
			
			prestamoDao.eliminar(prestamo);
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
			List<Prestamo> lista = prestamoDao.verPrestamosPendientes();
			
			for(Prestamo prestamo : lista){
				
				System.out.println("codigo prestamo: " + prestamo.getCodigo_prestamo());
				System.out.println("Estado prestamo: " + prestamo.getEstado_prestamo());
				
			}
		}catch ( PrestamoDispositivoException e) {
			throw new PrestamoDispositivoException(e);
		}
	}

}

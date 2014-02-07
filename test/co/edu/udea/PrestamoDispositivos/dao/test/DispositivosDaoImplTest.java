/**
 * 
 */
package co.edu.udea.PrestamoDispositivos.dao.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.PrestamoDispositivos.dao.DispositivoDao;
import co.edu.udea.PrestamoDispositivos.dao.impl.DispositivoDaoImpl;
import co.edu.udea.PrestamoDispositivos.model.Dispositivo;
import co.edu.udea.PrestamoDispositivos.util.exception.PrestamoDispositivoException;

@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
@ContextConfiguration(locations = "classpath:spring_configuration.xml")

/**
 * @author Yamit Cardozo - Jonathan Medina
 *
 */
public class DispositivosDaoImplTest {
	@Autowired 
	DispositivoDao dispositivoDao;
	/**
	 * prueba unitaria para obtener toda la lista dispositivos en la base de datos.
	 * @throws PrestamoDispositivoException
	 */
	//@Test
	public void testObtener() throws PrestamoDispositivoException {
		try{
						
			List<Dispositivo> lista = dispositivoDao.obtener();
			
			for(Dispositivo dispositivo : lista){
				
				System.out.println("IdDispositivo: " + dispositivo.getId_dispositivo());
				System.out.println("Estado dispositivo: " + dispositivo.getEstado());
				
			}
		}catch ( PrestamoDispositivoException e) {
			throw new PrestamoDispositivoException(e);
		}
	}
	
	/**
	 * prueba unitaria para obtener el dispositivo con el id especificado.
	 * @throws PrestamoDispositivoException
	 */
	//@Test
	public void testObtenerPorId() throws PrestamoDispositivoException {
		try{				
			Dispositivo dispositivo = dispositivoDao.obtenerPorId(4);
			
			if(dispositivo != null)
				System.out.println("El dispositivo es: " + dispositivo.getId_dispositivo() + " y la descripcion es: " + dispositivo.getDescripcion());
			
		}catch ( PrestamoDispositivoException e) {
			throw new PrestamoDispositivoException(e);
		}
	}

	/**
	 * prueba unitaria para  que guarda un dispositivo en la base de datos
	 * @throws PrestamoDispositivoException
	 */
	//@Test
	public void testGuardar() throws PrestamoDispositivoException {
		try{		
		Dispositivo dispositivo = new Dispositivo();		
		dispositivo.setEstado("disponible");
		dispositivo.setDescripcion("pc");
		dispositivoDao.guardar(dispositivo);
		System.out.println(" Dispositivo guardado");
		}catch(PrestamoDispositivoException e){
			throw new PrestamoDispositivoException(e);
		}
	}
	
	/**
	 * prueba unitaria para actualizar dispositivo de la base de datos
	 * @throws PrestamoDispositivoException
	 */
	//@Test
	public void testActualizar() throws PrestamoDispositivoException {
		try{		
		Dispositivo dispositivo = new Dispositivo();
		dispositivo.setId_dispositivo(7);
		dispositivo.setEstado("disponible");
		dispositivo.setDescripcion("pc2");
		dispositivoDao.actualizar(dispositivo);
		System.out.println(" Dispositivo actualizado");
		}catch(PrestamoDispositivoException e){
			throw new PrestamoDispositivoException(e);
		}
	}
	
	/**
	 * prueba unitaria para eliminar dispositivo de la base de datos 
	 * @throws PrestamoDispositivoException
	 */
	//@Test
	public void testEliminar() throws PrestamoDispositivoException {
		try{
		Dispositivo dispositivo = new Dispositivo();
		dispositivo.setId_dispositivo(7);
		dispositivo.setEstado(" ");
		dispositivo.setDescripcion(" ");
		dispositivoDao.eliminar(dispositivo);
		System.out.println(" Dispositivo eliminado");
		}catch(PrestamoDispositivoException e){
			throw new PrestamoDispositivoException(e);
		}
	}
	
	
	/**
	 * prueba unitaria para obtener la lista de dispositivos disponibles de la base de datos.
	 * @throws PrestamoDispositivoException
	 */
	//@Test
	public void testObtenerDisponible() throws PrestamoDispositivoException {
		try{			
			List<Dispositivo> lista = dispositivoDao.verDispositivoDisponible();
			
			for(Dispositivo dispositivo : lista){
				
				System.out.println("IdDispositivo: " + dispositivo.getId_dispositivo());
				System.out.println("Estado dispositivo: " + dispositivo.getEstado());
				
			}
		}catch ( PrestamoDispositivoException e) {
			throw new PrestamoDispositivoException(e);
		}
	}
}

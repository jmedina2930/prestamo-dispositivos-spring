/**
 * 
 */
package co.edu.udea.PrestamoDispositivos.dao.test;

import java.util.List;

import org.junit.Test;

import co.edu.udea.PrestamoDispositivos.dao.DispositivoDao;
import co.edu.udea.PrestamoDispositivos.dao.impl.DispositivoDaoImpl;
import co.edu.udea.PrestamoDispositivos.model.Dispositivo;
import co.edu.udea.PrestamoDispositivos.util.exception.PrestamoDispositivoException;


/**
 * @author Yamit Cardozo - Jonathan Medina
 *
 */
public class DispositivosDaoImplTest {
	
	/**
	 * prueba unitaria para obtener toda la lista dispositivos en la base de datos.
	 * @throws PrestamoDispositivoException
	 */
	//@Test
	public void testObtener() throws PrestamoDispositivoException {
		try{
			DispositivoDao dao = new DispositivoDaoImpl();
			
			List<Dispositivo> lista = dao.obtener();
			
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
			DispositivoDao dao = new DispositivoDaoImpl();
			
			Dispositivo dispositivo = dao.obtenerPorId(2);
			
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
		DispositivoDao dao = new DispositivoDaoImpl();
		Dispositivo a = new Dispositivo();		
		a.setEstado("disponible");
		a.setDescripcion("pc");
		dao.guardar(a);
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
		DispositivoDao dao = new DispositivoDaoImpl();
		Dispositivo a = new Dispositivo();
		a.setId_dispositivo(2);
		a.setEstado("disponible");
		a.setDescripcion("pc");
		dao.actualizar(a);
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
		DispositivoDao dao = new DispositivoDaoImpl();
		Dispositivo a = new Dispositivo();
		a.setId_dispositivo(3);
		a.setEstado(" ");
		a.setDescripcion(" ");
		dao.eliminar(a);
		System.out.println(" Dispositivo eliminado");
		}catch(PrestamoDispositivoException e){
			throw new PrestamoDispositivoException(e);
		}
	}
	
	
	/**
	 * prueba unitaria para obtener la lista de dispositivos disponibles de la base de datos.
	 * @throws PrestamoDispositivoException
	 */
	@Test
	public void testObtenerDisponible() throws PrestamoDispositivoException {
		try{
			DispositivoDao dao = new DispositivoDaoImpl();
			
			List<Dispositivo> lista = dao.verDispositivoDisponible();
			
			for(Dispositivo dispositivo : lista){
				
				System.out.println("IdDispositivo: " + dispositivo.getId_dispositivo());
				System.out.println("Estado dispositivo: " + dispositivo.getEstado());
				
			}
		}catch ( PrestamoDispositivoException e) {
			throw new PrestamoDispositivoException(e);
		}
	}
}

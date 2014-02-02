package test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import co.edu.udea.PrestamoDispositivos.bl.PrestamoBL;
import co.edu.udea.PrestamoDispositivos.bl.impl.PrestamoBLImpl;
import co.edu.udea.PrestamoDispositivos.model.Dispositivo;
import co.edu.udea.PrestamoDispositivos.model.Prestamo;
import co.edu.udea.PrestamoDispositivos.model.Usuario;
import co.edu.udea.PrestamoDispositivos.util.exception.PrestamoDispositivoException;

public class PrestamoBLImplTest {
	/**
	 * prueba unitaria para obtener todos los prestamos que se encuentran en la base de datos
	 * @throws PrestamoDispositivoException
	 */
	@Test
	public void testObtener() throws PrestamoDispositivoException {
		try{
		PrestamoBL pre = new PrestamoBLImpl();
		List<Prestamo> r = pre.obtener();
		int cantidad = r.size();
		for(int i=0;i<cantidad;i++){
			System.out.println("los usuarios de prestamo que hay en la base de datos son"+r.get(i).getUsuario());
		}
		System.out.println("se mostraron los usuarios de los prestamo que estan en la base de datos");
		}catch ( PrestamoDispositivoException e) {
			throw new PrestamoDispositivoException(e);
		}
	}
	/**
	 * prueba unitaria para obtener el prestamos que se encuentran en la base de datos
	 * @throws PrestamoDispositivoException
	 */
	@Test
	public void testObtenerPorCodigo() throws PrestamoDispositivoException {
		try{
		PrestamoBL pre = new PrestamoBLImpl();
		int codigo_prestamo=1234;
		Prestamo prestamo = pre.obtenerPorCodigo(codigo_prestamo);
		System.out.println("se mostrara el prestamo que estan en la base de datos con codigo"+ prestamo.getCodigo_prestamo());
		}catch ( PrestamoDispositivoException e) {
			throw new PrestamoDispositivoException(e);
		}
	}
/**
 * prueba unitaria que guarda un prestamo en la base de datos validando que los atributos esten bien ingresados y por la persona indicada.
 * @throws PrestamoDispositivoException
 */
	@Test
	public void testGuardar() throws PrestamoDispositivoException {
		try{
		Date date = new Date(2014,02,01);
		date.setHours(10);
		PrestamoBL pre = new PrestamoBLImpl();
		String nUsuario = "oli123";
		Date fecha_inicial= date;
		date.setHours(14);
		Date fecha_final = date;
		String estado_prestamo = "pendiente";
		Prestamo p =  pre.guardar(nUsuario,fecha_inicial,
				 fecha_final,  estado_prestamo);
		System.out.println("prestamo guardado correctamente con");
		System.out.println("usuario "+p.getUsuario());
		System.out.println("y con estado "+p.getEstado_prestamo());
		
		}catch ( PrestamoDispositivoException e) {
			throw new PrestamoDispositivoException(e);
		}
		}

	/**
	 * prueba unitaria que actualiza un prestamo en la base de datos validando los atributos especificos
	 * @throws PrestamoDispositivoException
	 */
	@Test
	public void testActualizar() throws PrestamoDispositivoException {
		
		try{
		Date date = new Date(2014,01,19);
		date.setHours(10);
		Dispositivo d = new Dispositivo();
		Usuario u = new Usuario();
		Prestamo prestamo = new Prestamo();
		d.setId_dispositivo(4);
		prestamo.setCodigo_prestamo(3);
		u.setUsuario("jjonathan.medina");			
		prestamo.setEstado_prestamo("aprobado");
		prestamo.setFecha_inicial(date);
		date.setHours(14);
		prestamo.setFecha_final(date);
		prestamo.setId_dispositivo(d);
		prestamo.setUsuario(u);
		
		Date date1 = new Date(2014,02,01);
		date1.setHours(10);
		PrestamoBL pre = new PrestamoBLImpl();
		String nUsuario = "oli123";
		Date fecha_inicial= date;
		date1.setHours(14);
		Date fecha_final = date;
		String estado_prestamo = "pendiente";
		
		Prestamo p =  pre.actualizar(prestamo, nUsuario, fecha_inicial,
				 fecha_final, estado_prestamo);
		System.out.println("prestamo actualizado con estado: "+ p.getEstado_prestamo());
		}catch ( PrestamoDispositivoException e) {
			throw new PrestamoDispositivoException(e);
		}
	}

	/**
	 * prueba unitaria que elimina prestamo en la base de datos validando los atributos especificos
	 * @throws PrestamoDispositivoException
	 */
	@Test
	public void testEliminar() throws PrestamoDispositivoException {
		try{
		PrestamoBL pre = new PrestamoBLImpl();	
		Date date = new Date(2014,01,19);
		date.setHours(10);
		Dispositivo d = new Dispositivo();
		Usuario u = new Usuario();
		Prestamo prestamo = new Prestamo();
		d.setId_dispositivo(4);
		prestamo.setCodigo_prestamo(3);
		u.setUsuario("jjonathan.medina");			
		prestamo.setEstado_prestamo("pendiente");
		prestamo.setFecha_inicial(date);
		date.setHours(14);
		prestamo.setFecha_final(date);
		prestamo.setId_dispositivo(d);
		prestamo.setUsuario(u);
		pre.eliminar(prestamo);
		System.out.println("prestamo eliminado");
		}catch(PrestamoDispositivoException e){
			throw new PrestamoDispositivoException(e);
		}
	}
	
	
/**
 * prueba unitaria para obtener todos los prestamos pendientes que se encuentran en la base de datos
 * @throws PrestamoDispositivoException
 */
	@Test
	public void testVerPrestamosPendientes() throws PrestamoDispositivoException {
		try{
		PrestamoBL pre = new PrestamoBLImpl();
		List<Prestamo> list = pre.verPrestamosPendientes();
		int cantidad = list.size();
		for(int i=0;i<cantidad;i++){
			System.out.println("los prestamos pendientes que hay en la base de datos con id "+list.get(i));
		}
		System.out.println("se mostraron los pretamos pendientes que estan en la base de datos");
		}catch(PrestamoDispositivoException e){
			throw new PrestamoDispositivoException(e);
		}
	}

}

package co.edu.udea.PrestamoDispositivos.bl.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.PrestamoDispositivos.bl.DispositivoBL;
import co.edu.udea.PrestamoDispositivos.bl.PrestamoBL;
import co.edu.udea.PrestamoDispositivos.bl.impl.PrestamoBLImpl;
import co.edu.udea.PrestamoDispositivos.dao.PrestamoDao;
import co.edu.udea.PrestamoDispositivos.model.Dispositivo;
import co.edu.udea.PrestamoDispositivos.model.Prestamo;
import co.edu.udea.PrestamoDispositivos.model.Usuario;
import co.edu.udea.PrestamoDispositivos.util.exception.PrestamoDispositivoException;

@RunWith(SpringJUnit4ClassRunner.class)
//wamp@Transactional
@ContextConfiguration(locations = "classpath:spring_configuration.xml")

public class PrestamoBLImplTest {
	/**
	 * prueba unitaria para obtener todos los prestamos que se encuentran en la base de datos
	 * @throws PrestamoDispositivoException
	 */
	
	@Autowired
	PrestamoBL prestamoBL;
	
	//@Test
	public void testObtener() throws PrestamoDispositivoException {
		try{
		
		List<Prestamo> prestamos = prestamoBL.obtener();
		int cantidad = prestamos.size();
		for(int i=0;i<cantidad;i++){
			System.out.println("los usuarios de prestamo que hay en la base de datos son"+prestamos.get(i).getEstado_prestamo());
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
	//@Test
	public void testObtenerPorCodigo() throws PrestamoDispositivoException {
		try{
		
		int codigo_prestamo=4;
		Prestamo prestamo = prestamoBL.obtenerPorCodigo(codigo_prestamo);
		System.out.println("se mostrara el prestamo que estan en la base de datos con codigo\t"+ prestamo.getEstado_prestamo());
		}catch ( PrestamoDispositivoException e) {
			throw new PrestamoDispositivoException(e);
		}
	}
/**
 * prueba unitaria que guarda un prestamo en la base de datos validando que los atributos esten bien ingresados y por la persona indicada.
 * @throws PrestamoDispositivoException
 */
	//@Test
	public void testGuardar() throws PrestamoDispositivoException {
		try{
		
		Dispositivo dispositivo = new Dispositivo();
		dispositivo.setId_dispositivo(5);
		Date date = new Date(2014,02,01);
		date.setHours(10);
		
		String nUsuario = "oli456";
		Date fecha_inicial= date;
		date.setHours(14);
		Date fecha_final = date;
		String estado_prestamo = "pendiente";
		Prestamo prestamo =  prestamoBL.guardar(nUsuario,fecha_inicial,
				 fecha_final,  estado_prestamo, dispositivo);
		System.out.println("prestamo guardado correctamente con");
		System.out.println("usuario\t "+prestamo.getUsuario());
		System.out.println("y con estado\t "+prestamo.getEstado_prestamo());
		
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
		Dispositivo dispositivo = new Dispositivo();
		Usuario usuario = new Usuario();
		Prestamo prestamo = new Prestamo();
		dispositivo.setId_dispositivo(8);
		prestamo.setCodigo_prestamo(4);
		usuario.setUsuario("jjonathan.medina");			
		prestamo.setEstado_prestamo("aprobado");
		prestamo.setFecha_inicial(date);
		date.setHours(14);
		prestamo.setFecha_final(date);
		prestamo.setId_dispositivo(dispositivo);
		prestamo.setUsuario(usuario);
		
		Date date1 = new Date(2014,02,01);
		date1.setHours(10);
		
		String nUsuario = "oli456";
		Date fecha_inicial= date;
		date1.setHours(14);
		Date fecha_final = date;
		String estado_prestamo = "aprobado";
		
		Prestamo resultadoprestamo =  prestamoBL.actualizar(prestamo, nUsuario, fecha_inicial,
				 fecha_final, estado_prestamo);
		System.out.println("prestamo actualizado con estado: "+ resultadoprestamo.getEstado_prestamo());
		}catch ( PrestamoDispositivoException e) {
			throw new PrestamoDispositivoException(e);
		}
	}

	/**
	 * prueba unitaria que elimina prestamo en la base de datos validando los atributos especificos
	 * @throws PrestamoDispositivoException
	 */
	//@Test
	public void testEliminar() throws PrestamoDispositivoException {
		try{
		//PrestamoBL pre = new PrestamoBLImpl();	
		Date date = new Date(2014,01,19);
		date.setHours(10);
		Dispositivo dispositivo = new Dispositivo();
		Usuario usuario = new Usuario();
		Prestamo prestamo = new Prestamo();
		dispositivo.setId_dispositivo(8);
		prestamo.setCodigo_prestamo(5);
		usuario.setUsuario("jjonathan.medina");			
		prestamo.setEstado_prestamo("pendiente");
		prestamo.setFecha_inicial(date);
		date.setHours(14);
		prestamo.setFecha_final(date);
		prestamo.setId_dispositivo(dispositivo);
		prestamo.setUsuario(usuario);
		prestamoBL.eliminar(prestamo);
		System.out.println("prestamo eliminado");
		}catch(PrestamoDispositivoException e){
			throw new PrestamoDispositivoException(e);
		}
	}
	
	
/**
 * prueba unitaria para obtener todos los prestamos pendientes que se encuentran en la base de datos
 * @throws PrestamoDispositivoException
 */
	//@Test
	public void testVerPrestamosPendientes() throws PrestamoDispositivoException {
		try{
		//PrestamoBL pre = new PrestamoBLImpl();
		List<Prestamo> list = prestamoBL.verPrestamosPendientes();
		int cantidad = list.size();
		for(int i=0;i<cantidad;i++){
			System.out.println("los prestamos pendientes que hay en la base de datos con id "+list.get(i).getFecha_final());
		}
		System.out.println("se mostraron los pretamos pendientes que estan en la base de datos");
		}catch(PrestamoDispositivoException e){
			throw new PrestamoDispositivoException(e);
		}
	}

}

package co.edu.udea.PrestamoDispositivos.bl.test;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.PrestamoDispositivos.bl.DispositivoBL;
import co.edu.udea.PrestamoDispositivos.bl.impl.DispositivoBLImpl;
import co.edu.udea.PrestamoDispositivos.model.Dispositivo;
import co.edu.udea.PrestamoDispositivos.util.exception.PrestamoDispositivoException;

@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
@ContextConfiguration(locations = "classpath:spring_configuration.xml")

public class DispositivoBLImplTest {
	
	@Autowired
	DispositivoBL dispositivoBL; 

	/**
	 * prueba unitaria que  guarda dispositivo en la base de datos validando que los atributos esten bien ingresados y por la persona indicada.
	 * @throws PrestamoDispositivoException
	 * @author Jonathan Medina- Yamit Cardozo
	 */
	//@Test
	public void testGuardar() throws PrestamoDispositivoException {
		
		try{
		
		
		String descripcion = "videobem,color rojo, buen estado para";
		String estado = "disponible";
		String usuario = "jjonathan.medina";		
		dispositivoBL.guardar(descripcion,estado,usuario);
		System.out.println("dispositivo guardado correctamente con");
		System.out.println("descripcion "+ descripcion);
		System.out.println("estado "+ estado);
		System.out.println("usuario "+ usuario);
		}catch ( PrestamoDispositivoException e) {
				throw new PrestamoDispositivoException(e);
		}
	}

	/**
	 * prueba unitaria que actualiza dispositivo en la base de datos validando los atributos especificos
	 * @throws PrestamoDispositivoException
	 */
	//@Test
	public void testActualizar() throws PrestamoDispositivoException {
		
		try{				
		Dispositivo dispositivo = new Dispositivo();
		dispositivo.setId_dispositivo(4);
		
		String descripcion = "videobeam";
		String estado = "disponible";
		String usuario = "jjonathan.medina";
		
		dispositivoBL.actualizar(dispositivo, descripcion,
				 estado, usuario);
		System.out.println("dispositivo actualizado");
		}catch ( PrestamoDispositivoException e) {
		throw new PrestamoDispositivoException(e);
}
	}

	/**
	 * prueba unitaria que elimina dispositivo en la base de datos validando los atributos especificos
	 * @throws PrestamoDispositivoException
	 */
	//@Test
	public void testEliminar() throws PrestamoDispositivoException {
		String usuario = "jjonathan.medina";
		try{
		
		
		Dispositivo dispositivo = new Dispositivo();
		dispositivo.setId_dispositivo(4);
		dispositivo.setDescripcion(" ");
		dispositivo.setEstado(" ");				
		dispositivoBL.eliminar(dispositivo, usuario);
		
		System.out.println("dispositivo eliminado");
		}catch ( PrestamoDispositivoException e) {
			throw new PrestamoDispositivoException(e);
		}
	}

	/**
	 * prueba unitaria para obtener todos los dispositivos que se encuentran en la base de datos
	 * @throws PrestamoDispositivoException
	 */
	//@Test
	public void testObtener() throws PrestamoDispositivoException {
		

		try{
		
		List<Dispositivo> dispositivos = dispositivoBL.obtener(); 
		int cantidad = dispositivos.size();
		for(int i=0;i<cantidad;i++){
			System.out.println("los id de dispositivos que hay en la base de datos son"+dispositivos.get(i).getId_dispositivo());
		}
		System.out.println("se mostraron los id de los dispositivos que estan en la base de datos");
		}catch ( PrestamoDispositivoException e) {
			throw new PrestamoDispositivoException(e);
		}
	}

	/**
	 * prueba unitaria para obtener dispositivo que se encuentran en la base de datos
	 * @throws PrestamoDispositivoException
	 */
	
	//@Test
	public void testObtenerPorId() throws PrestamoDispositivoException {
		try{
			int id = 5;
			Dispositivo r = dispositivoBL.obtenerPorId(id);
			System.out.println("se muestra el dispositivo con la descripcion "+ r.getDescripcion());
		}catch ( PrestamoDispositivoException e) {
			throw new PrestamoDispositivoException(e);
		}
	}
	
	/**
	 * prueba unitaria para obtener dispositivos disponibles que se encuentran en la base de datos
	 * @throws PrestamoDispositivoException
	 */
	//@Test
	public void testVerDispositivoDisponible() throws PrestamoDispositivoException {
		
		try{
			List<Dispositivo> dispositivos = dispositivoBL.verDispositivosDisponibles();
			int cantidad = dispositivos.size();
			for(int i=0;i<cantidad;i++){
				System.out.println("los id de dispositivos disponibles que hay en la base de datos son"+dispositivos.get(i).getId_dispositivo());
			}
			System.out.println("se mostraron los id de los dispositivos que estan en la base de datos");
		}catch (PrestamoDispositivoException e){
			throw new PrestamoDispositivoException(e);
		}
			
	}

}

package co.edu.udea.PrestamoDispositivos.bl.test;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.PrestamoDispositivos.bl.DispositivoBL;
import co.edu.udea.PrestamoDispositivos.bl.impl.DispositivoBLImpl;
import co.edu.udea.PrestamoDispositivos.model.Dispositivo;
import co.edu.udea.PrestamoDispositivos.util.exception.PrestamoDispositivoException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:spring_configuration.xml")

public class DispositivoBLImplTest {

	/**
	 * prueba unitaria que  guarda dispositivo en la base de datos validando que los atributos esten bien ingresados y por la persona indicada.
	 * @throws PrestamoDispositivoException
	 */
	@Test
	public void testGuardar() throws PrestamoDispositivoException {
		
		try{
		DispositivoBL d = new DispositivoBLImpl(); 
		
		String descripcion = "videobem,color rojo, buen estado para su utilizacion,componentes completos";
		String estado = "disponible";
		String usuario = "123wwerer";
		
		d.guardar(descripcion,estado,usuario);
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
		DispositivoBL d = new DispositivoBLImpl(); 
		
		Dispositivo dispositivo = new Dispositivo();
		dispositivo.setId_dispositivo(2);
		dispositivo.setEstado("disponible");
		dispositivo.setDescripcion("pc");
		
		String descripcion = "videobeam,color rojo, buen estado para su utilizacion,componentes completos";
		String estado = "disponible";
		String usuario = "123wwerer";
		
		d.actualizar(dispositivo, descripcion,
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
		
		try{
		DispositivoBL d = new DispositivoBLImpl();
		
		Dispositivo dispositivo = new Dispositivo();
		dispositivo.setId_dispositivo(3);
		dispositivo.setEstado(" ");
		dispositivo.setDescripcion(" ");
		
		d.eliminar(dispositivo);
		
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
		DispositivoBL d = new DispositivoBLImpl();
		List<Dispositivo> r = d.obtener(); 
		int cantidad = r.size();
		for(int i=0;i<cantidad;i++){
			System.out.println("los id de dispositivos que hay en la base de datos son"+r.get(i).getId_dispositivo());
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
			DispositivoBL d = new DispositivoBLImpl();
			int id = 1145;
		Dispositivo r = d.obtenerPorId(id);
		System.out.println("se muestra el dispositivo con el id "+ r.getId_dispositivo());
		}catch ( PrestamoDispositivoException e) {
			throw new PrestamoDispositivoException(e);
		}
	}

}

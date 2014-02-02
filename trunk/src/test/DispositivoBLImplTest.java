package test;

import static org.junit.Assert.*;

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

	@Test
	public void testGuardar() throws PrestamoDispositivoException {
		try{
			DispositivoBL dispositivoBL = new DispositivoBLImpl();
			dispositivoBL.guardar("pc","disponible","jjonathan.medina");
			System.out.println(" Dispositivo guardado");
		}catch(PrestamoDispositivoException e){
			throw new PrestamoDispositivoException(e);			
		}
		
	}

	//@Test
	public void testActualizar() {
		fail("Not yet implemented");
	}

	//@Test
	public void testEliminar() {
		fail("Not yet implemented");
	}

	//@Test
	public void testObtener() {
		fail("Not yet implemented");
	}

	//@Test
	public void testObtenerPorId() {
		fail("Not yet implemented");
	}

}

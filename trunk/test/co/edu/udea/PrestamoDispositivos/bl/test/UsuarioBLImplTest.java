package co.edu.udea.PrestamoDispositivos.bl.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.PrestamoDispositivos.bl.PrestamoBL;
import co.edu.udea.PrestamoDispositivos.bl.UsuarioBL;
import co.edu.udea.PrestamoDispositivos.bl.impl.UsuarioBLImpl;
import co.edu.udea.PrestamoDispositivos.model.Usuario;
import co.edu.udea.PrestamoDispositivos.util.exception.PrestamoDispositivoException;

@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
@ContextConfiguration(locations = "classpath:spring_configuration.xml")

public class UsuarioBLImplTest {

	/**
	 * prueba unitaria para obtener todos los Usuarios que se encuentran en la base de datos
	 * @throws PrestamoDispositivoException	
	 *  */
	@Autowired
	UsuarioBL usuarioBL;
	
	//@Test
	public void testObtener() throws PrestamoDispositivoException {
		try{
		//UsuarioBL u = new UsuarioBLImpl();
		List<Usuario> resultado =  usuarioBL.obtener();
		int cantidad = resultado.size();
		for(int i=0;i<cantidad;i++){
			System.out.println("los usuarios de Usuarios que hay en la base de datos son\t"+resultado.get(i).getUsuario());
		}
		System.out.println("se mostraron los usuarios de los Usuarios que estan en la base de datos");
		}catch ( PrestamoDispositivoException e) {
			throw new PrestamoDispositivoException(e);
		}
	}

	/**
	 * prueba unitaria para obtener el usuarios con cedula especifica que se encuentran en la base de datos
	 * @throws PrestamoDispositivoException
	 */
	//@Test
	public void testObtenerPorCedula() throws PrestamoDispositivoException {
		try{
			//UsuarioBL u = new UsuarioBLImpl();
			String cedula="1020";
			Usuario usuario = usuarioBL.obtenerPorCedula(cedula);
			System.out.println("se muestra el Usuario con cedula " +usuario.getCedula() +"estan en la base de datos\n"+usuario.getContrasena());
		}catch ( PrestamoDispositivoException e) {
			throw new PrestamoDispositivoException(e);
		}
	}
	/**
	 * prueba unitaria para obtener el Usuarios con usuario especifico que se encuentran en la base de datos
	 * @throws PrestamoDispositivoException
	 */
	//@Test
	public void testObtenerPorUsuario() throws PrestamoDispositivoException {
		try{
		//UsuarioBL u = new UsuarioBLImpl();
		String usuario="jjonathan.medina";
		Usuario usuariores = usuarioBL.obtenerPorUsuario(usuario);
		System.out.println("se muestra el Usuario con usuario " +usuariores.getUsuario() +"estan en la base de datos");
		}catch ( PrestamoDispositivoException e) {
			throw new PrestamoDispositivoException(e);
		}
	}

	/**
	 * prueba unitaria que  guarda Usuario en la base de datos validando que los atributos esten bien ingresados y por la persona indicada.
	 * @throws PrestamoDispositivoException
	 */
	@Test
	public void testGuardar() throws PrestamoDispositivoException {
		try{
		//UsuarioBL u = new UsuarioBLImpl();
		String usuarioCreador = "jjonathan.medina";
		String cedula = "123456";
		String nombre = "Jonathan";
		String apellidos = "Atom";
		String direccion = "cll 52 N1234";
		String usuario = "jjonathan.medina";
		String telefono = "4552345";
		String contrasena = "admin";
		String rol = "investigador";
		
		System.out.println("Usuario guardado correctamente con");
		System.out.println("cedula "+ cedula);
		System.out.println("nombre "+ nombre);
		System.out.println("rol "+ rol);
		
		usuarioBL.guardar(usuarioCreador, cedula, nombre, apellidos, direccion, usuario, telefono, contrasena, rol);
		System.out.println("usuario guardado");
		}catch ( PrestamoDispositivoException e) {
			throw new PrestamoDispositivoException(e);
		}
	}
	/**
	 * prueba unitaria que actualiza usuario en la base de datos validando los atributos especificos
	 * @throws PrestamoDispositivoException
	 */
	//@Test
	public void testActualizar() throws PrestamoDispositivoException {
		
		try{
		//UsuarioBL u = new UsuarioBLImpl();
		
		Usuario usuarioV = new Usuario();
		usuarioV.setUsuario("oli456");
		
		String usuarioCreador = "jjonathan.medina";
		String cedula = "9876554321";
		String nombre = "steve";
		String apellidos = "yuca";
		String direccion = "cll 52 N1234";
		String telefono = "4552345";
		String contrasena = "cielo";
		String rol = "investigador";
		
		usuarioBL.actualizar( usuarioV, usuarioCreador, cedula, nombre, apellidos,
				 direccion, telefono,  contrasena,  rol);
		System.out.println(" usuario actualizado");
		}catch ( PrestamoDispositivoException e) {
			throw new PrestamoDispositivoException(e);
		}
	}

	/**
	 * prueba unitaria que elimina usuario en la base de datos validando los atributos especificos
	 * @throws PrestamoDispositivoException
	 */
	//@Test
	public void testEliminar() throws PrestamoDispositivoException {
		
		try{
		//UsuarioBL u = new UsuarioBLImpl();
		
		Usuario usuario = new Usuario();
		usuario.setApellidos("bonaparte");
		usuario.setNombre("andres");
		usuario.setCedula("111");
		usuario.setRol("inve");
		usuario.setDireccion("cara");
		usuario.setTelefono("787");
		usuario.setContrasena("sdfsadfsdfas");
		usuario.setUsuario("oli456");
		
		 usuarioBL.eliminar(usuario);
		 System.out.println("usuario eliminado");
		}catch ( PrestamoDispositivoException e) {
			throw new PrestamoDispositivoException(e);
		}
	}

}

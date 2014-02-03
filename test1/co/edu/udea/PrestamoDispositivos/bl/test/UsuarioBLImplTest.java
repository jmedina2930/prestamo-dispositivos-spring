package co.edu.udea.PrestamoDispositivos.bl.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.PrestamoDispositivos.bl.UsuarioBL;
import co.edu.udea.PrestamoDispositivos.bl.impl.UsuarioBLImpl;
import co.edu.udea.PrestamoDispositivos.model.Usuario;
import co.edu.udea.PrestamoDispositivos.util.exception.PrestamoDispositivoException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:spring_configuration.xml")

public class UsuarioBLImplTest {

	/**
	 * prueba unitaria para obtener todos los Usuarios que se encuentran en la base de datos
	 * @throws PrestamoDispositivoException	
	 *  */
	@Test
	public void testObtener() throws PrestamoDispositivoException {
		try{
		UsuarioBL u = new UsuarioBLImpl();
		List<Usuario> r =  u.obtener();
		int cantidad = r.size();
		for(int i=0;i<cantidad;i++){
			System.out.println("los usuarios de Usuarios que hay en la base de datos son"+r.get(i).getUsuario());
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
	@Test
	public void testObtenerPorCedula() throws PrestamoDispositivoException {
		try{
			UsuarioBL u = new UsuarioBLImpl();
			String cedula="1223456";
			Usuario usuario = u.obtenerPorCedula(cedula);
			System.out.println("se muestra el Usuario con cedula " +usuario.getCedula() +"estan en la base de datos");
		}catch ( PrestamoDispositivoException e) {
			throw new PrestamoDispositivoException(e);
		}
	}
	/**
	 * prueba unitaria para obtener el Usuarios con usuario especifico que se encuentran en la base de datos
	 * @throws PrestamoDispositivoException
	 */
	@Test
	public void testObtenerPorUsuario() throws PrestamoDispositivoException {
		try{
		UsuarioBL u = new UsuarioBLImpl();
		String usuario="1233dd";
		Usuario r = u.obtenerPorUsuario(usuario);
		System.out.println("se muestra el Usuario con usuario " +r.getUsuario() +"estan en la base de datos");
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
		UsuarioBL u = new UsuarioBLImpl();
		String usuarioCreador = "adm123";
		String cedula = "123456";
		String nombre = "Oliver";
		String apellidos = "Atom";
		String direccion = "cll 52 N1234";
		String usuario = "oli456";
		String telefono = "4552345";
		String contrasena = "cielo";
		String rol = "investigador";
		
		System.out.println("Usuario guardado correctamente con");
		System.out.println("cedula "+ cedula);
		System.out.println("nombre "+ nombre);
		System.out.println("rol "+ rol);
		
		u.guardar(usuarioCreador, cedula, nombre, apellidos, direccion, usuario, telefono, contrasena, rol);
		System.out.println("usuario guardado");
		}catch ( PrestamoDispositivoException e) {
			throw new PrestamoDispositivoException(e);
		}
	}
	/**
	 * prueba unitaria que actualiza usuario en la base de datos validando los atributos especificos
	 * @throws PrestamoDispositivoException
	 */
	@Test
	public void testActualizar() throws PrestamoDispositivoException {
		
		try{
		UsuarioBL u = new UsuarioBLImpl();
		
		Usuario usuarioV = new Usuario();
		usuarioV.setApellidos("bonaparte");
		usuarioV.setCedula("111");
		usuarioV.setContrasena("123we456");
		usuarioV.setDireccion("cra 54 N 34-12");
		usuarioV.setTelefono("324567");
		usuarioV.setNombre("manuel");
		usuarioV.setRol("inve");
		usuarioV.setUsuario("manubona12");
		
		String usuarioCreador = "adm123";
		String cedula = "123456";
		String nombre = "Oliver";
		String apellidos = "Atom";
		String direccion = "cll 52 N1234";
		String usuario = "oli456";
		String telefono = "4552345";
		String contrasena = "cielo";
		String rol = "investigador";
		
		u.actualizar( usuarioV,usuarioCreador, cedula, nombre, apellidos,
				 direccion, usuario,  telefono,  contrasena,  rol);
		System.out.println(" usuario actualizado");
		}catch ( PrestamoDispositivoException e) {
			throw new PrestamoDispositivoException(e);
		}
	}

	/**
	 * prueba unitaria que elimina usuario en la base de datos validando los atributos especificos
	 * @throws PrestamoDispositivoException
	 */
	@Test
	public void testEliminar() throws PrestamoDispositivoException {
		
		try{
		UsuarioBL u = new UsuarioBLImpl();
		
		Usuario usuario = new Usuario();
		usuario.setApellidos("bonaparte");
		usuario.setCedula("111");
		usuario.setContrasena("123we456");
		usuario.setDireccion("cra 54 N 34-12");
		usuario.setTelefono("232");
		usuario.setNombre("manuel");
		usuario.setRol("inve");
		usuario.setUsuario("manubona12");
		
		 u.eliminar(usuario);
		 System.out.println("usuario eliminado");
		}catch ( PrestamoDispositivoException e) {
			throw new PrestamoDispositivoException(e);
		}
	}

}

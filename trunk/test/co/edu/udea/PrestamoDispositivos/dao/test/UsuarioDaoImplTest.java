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

import co.edu.udea.PrestamoDispositivos.dao.PrestamoDao;
import co.edu.udea.PrestamoDispositivos.dao.UsuarioDao;
import co.edu.udea.PrestamoDispositivos.dao.impl.UsuarioDaoImpl;
import co.edu.udea.PrestamoDispositivos.model.Usuario;
import co.edu.udea.PrestamoDispositivos.util.exception.PrestamoDispositivoException;

@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
@ContextConfiguration(locations = "classpath:spring_configuration.xml")

/**
 * @author Yamit Cardozo - Jonathan Medina
 *
 */
public class UsuarioDaoImplTest {

	/**
	 * prueba unitaria que muestra los usuarios que se encuentran en la base de datos,
	 * no se especifica ningun atributo especifico para busqueda. 
	 * @throws PrestamoDispositivoException
	 */
	
	@Autowired
	UsuarioDao usuarioDao;
	//@Test
	public void testObtener() throws PrestamoDispositivoException {
		try{
			//UsuarioDao dao = new UsuarioDaoImpl();
			
			List<Usuario> lista = usuarioDao.obtener();
			
			for(Usuario usuario : lista){
				
				System.out.println("Cedula: " + usuario.getCedula());
				System.out.println("Nombre completo: " + usuario.getNombre() + " " + usuario.getApellidos());
				
			}
		}catch ( PrestamoDispositivoException e) {
			throw new PrestamoDispositivoException(e);
		}
	}
	
	/**
	 * prueba unitaria que muestra los usuarios que se encuntran en la base de datos,
	 * donde se especifica el atributo cedula:"1234" para luego mostrar el nombre de dicho usuario con el rol que desempeña.
	 * @throws PrestamoDispositivoException
	 */
	//@Test
	public void testObtenerPorCedula() throws PrestamoDispositivoException {

		try{
			//UsuarioDao dao = new UsuarioDaoImpl();
			
			Usuario usuario = usuarioDao.obtenerPorCedula("1020");
			
			if(usuario != null)
				System.out.println("El usuario es: " + usuario.getNombre() + " y el rol es: " + usuario.getRol());
			
		}catch ( PrestamoDispositivoException e) {
			throw new PrestamoDispositivoException(e);
		}
	}
	/**
	 * prueba unitaria que muestra los usuarios que se encuntran en la base de datos,
	 * donde se especifica el atributo usuario:"manu12",para luego mostrar el nombre de dicho usuario con el rol que desempeña.
	 * @throws PrestamoDispositivoException
	 */
	//@Test
	public void testObtenerPorUsuario() throws PrestamoDispositivoException {

		try{
			//UsuarioDao dao = new UsuarioDaoImpl();
			
			Usuario usuario = usuarioDao.obtenerPorUsuario("jjonathan.medina");
			
			if(usuario != null)
				System.out.println("El usuario es: " + usuario.getNombre() + " y el rol es: " + usuario.getRol());
			
		}catch ( PrestamoDispositivoException e) {
			throw new PrestamoDispositivoException(e);
		}
	}
	
	/**
	 * prueba unitaria que guarda un usuario en la base de datos, con todos sus atributos especificados
	 * previamente.
	 * @throws PrestamoDispositivoException
	 */
	//@Test
		public void testGuardar() throws PrestamoDispositivoException {
			try{
			//UsuarioDao dao = new UsuarioDaoImpl();
			Usuario usuario = new Usuario();
			usuario.setApellidos("bonaparte");
			usuario.setCedula("111");
			usuario.setContrasena("123we");
			usuario.setDireccion("cra 52 N 34-12");
			usuario.setNombre("manuel");
			usuario.setRol("inve");
			usuario.setUsuario("manubona12");
			usuario.setTelefono("6007843");
			usuarioDao.guardar(usuario);
			System.out.println(" usuario guardado");
			}catch(PrestamoDispositivoException e){
				throw new PrestamoDispositivoException(e);
			}
		}
	
	/**
	 * prueba unitaria que actualiza un usuario en la base de datos, con todos sus atributos especificados
	 * previamente.
	 * @throws PrestamoDispositivoException
	 */
	//@Test
	public void testActualizar() throws PrestamoDispositivoException {
		try{
		//UsuarioDao dao = new UsuarioDaoImpl();
		Usuario usuario = new Usuario();
		usuario.setApellidos("bonaparte");
		usuario.setCedula("111");
		usuario.setContrasena("123we456");
		usuario.setDireccion("cra 54 N 34-12");
		usuario.setTelefono("324567");
		usuario.setNombre("manuel");
		usuario.setRol("inve");
		usuario.setUsuario("manubona12");
		usuarioDao.actualizar(usuario);
		System.out.println(" usuario actualizado");
		}catch(PrestamoDispositivoException e){
			throw new PrestamoDispositivoException(e);
		}
	}
	
	/**
	 * prueba unitaria que elimina un usuario en la base de datos, con todos sus atributos especificados
	 * previamente.
	 * @throws PrestamoDispositivoException
	 */
	@Test
	public void testEliminar() throws PrestamoDispositivoException {
		try{
		//UsuarioDao dao = new UsuarioDaoImpl();
		Usuario usuario = new Usuario();
		usuario.setApellidos("bonaparte");
		usuario.setCedula("111");
		usuario.setContrasena("123we456");
		usuario.setDireccion("cra 54 N 34-12");
		usuario.setTelefono("232");
		usuario.setNombre("manuel");
		usuario.setRol("inve");
		usuario.setUsuario("manubona12");
		usuarioDao.eliminar(usuario);
		System.out.println(" usuario eliminado");
		}catch(PrestamoDispositivoException e){
			throw new PrestamoDispositivoException(e);
		}
	}
	
}

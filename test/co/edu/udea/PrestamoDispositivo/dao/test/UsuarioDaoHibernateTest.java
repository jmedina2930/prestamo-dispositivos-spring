/**
 * 
 */
package co.edu.udea.PrestamoDispositivo.dao.test;

import java.util.List;

import org.junit.Test;

import co.edu.udea.PrestamoDispositivos.dao.UsuarioDao;
import co.edu.udea.PrestamoDispositivos.dao.impl.UsuarioDaoImpl;
import co.edu.udea.PrestamoDispositivos.model.Usuario;
import co.edu.udea.PrestamoDispositivos.util.exception.PrestamoDispositivoException;



/**
 * @author Yamit Cardozo - Jonathan Medina
 *
 */
public class UsuarioDaoHibernateTest {

	/**
	 * prueba unitaria que muestra los usuarios que se encuentran en la base de datos,
	 * no se especifica ningun atributo especifico para busqueda. 
	 * @throws PrestamoDispositivoException
	 */
	//@Test
	public void testObtener() throws PrestamoDispositivoException {
		try{
			UsuarioDao dao = new UsuarioDaoImpl();
			
			List<Usuario> lista = dao.obtener();
			
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
			UsuarioDao dao = new UsuarioDaoImpl();
			
			Usuario usuario = dao.obtenerPorCedula("1020");
			
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
			UsuarioDao dao = new UsuarioDaoImpl();
			
			Usuario usuario = dao.obtenerPorUsuario("jjonathan.medina");
			
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
			UsuarioDao dao = new UsuarioDaoImpl();
			Usuario a = new Usuario();
			a.setApellidos("bonaparte");
			a.setCedula("111");
			a.setContrasena("123we");
			a.setDireccion("cra 52 N 34-12");
			a.setNombre("manuel");
			a.setRol("inve");
			a.setUsuario("manubona12");
			a.setTelefono("6007843");
			dao.guardar(a);
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
		UsuarioDao dao = new UsuarioDaoImpl();
		Usuario a = new Usuario();
		a.setApellidos("bonaparte");
		a.setCedula("111");
		a.setContrasena("123we456");
		a.setDireccion("cra 54 N 34-12");
		a.setTelefono("324567");
		a.setNombre("manuel");
		a.setRol("inve");
		a.setUsuario("manubona12");
		dao.actualizar(a);
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
	//@Test
	public void testEliminar() throws PrestamoDispositivoException {
		try{
		UsuarioDao dao = new UsuarioDaoImpl();
		Usuario a = new Usuario();
		a.setApellidos("bonaparte");
		a.setCedula("111");
		a.setContrasena("123we456");
		a.setDireccion("cra 54 N 34-12");
		a.setTelefono("232");
		a.setNombre("manuel");
		a.setRol("inve");
		a.setUsuario("manubona12");
		dao.eliminar(a);
		System.out.println(" usuario eliminado");
		}catch(PrestamoDispositivoException e){
			throw new PrestamoDispositivoException(e);
		}
	}
	
}

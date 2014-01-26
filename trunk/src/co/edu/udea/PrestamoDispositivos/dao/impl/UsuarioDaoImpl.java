package co.edu.udea.PrestamoDispositivos.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;








import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.PrestamoDispositivos.dao.UsuarioDao;
import co.edu.udea.PrestamoDispositivos.model.Prestamo;
import co.edu.udea.PrestamoDispositivos.model.Usuario;
import co.edu.udea.PrestamoDispositivos.util.exception.PrestamoDispositivoException;

/**
 * 
 * @author Yamit Cardozo
 *
 */
public class UsuarioDaoImpl extends HibernateDaoSupport implements UsuarioDao {

	/**
	 * Es la implementacion del metodo declarado en la interface UsuarioDao
	 * que nos permite listar todos los usuarios
	 */
	@Override
	public List<Usuario> obtener(){
		return getSession().createCriteria(Usuario.class).list();
	}
	
	/**
	 * Es la implementacion del metodo declarado en la interface UsuarioDao
	 * que nos permite buscar un usuario por su cedula
	 */
	@Override
	public Usuario obtenerPorCedula(String cedula)
			throws PrestamoDispositivoException {
		Usuario usuario = null;
		try{
			Session sesion = getSession();
	
			usuario = (Usuario)sesion.createCriteria(Usuario.class)
					.add(Restrictions.eq("cedula", cedula))
					.uniqueResult();
		}catch (HibernateException e) {
			throw new PrestamoDispositivoException(e);
		}
	
		return usuario;
	}
	
	/**
	 * Es la implementacion del metodo declarado en la interface UsuarioDao
	 * que nos permite buscar un usuario por su usuario (nombre usado en el login)
	 */
	@Override
	public Usuario obtenerPorUsuario(String usuario)
			throws PrestamoDispositivoException {
		Usuario usuario1 = null;
		try{
			Session sesion = getSession();
	
			usuario1 = (Usuario)sesion.createCriteria(Usuario.class)
					.add(Restrictions.eq("Usuario", usuario))
					.uniqueResult();
		}catch (HibernateException e) {
			throw new PrestamoDispositivoException(e);
		}
	
		return usuario1;
	}
	
	/**
	 * Es la implementacion del metodo declarado en la interface UsuarioDao
	 * que nos permite guardar un usuario
	 */
	@Override
	public Usuario guardar(Usuario usuario) throws PrestamoDispositivoException {
		Transaction tx = null;
		try{
			Session sesion = getSession();
	
			tx = sesion.beginTransaction();
	
			sesion.save(usuario);
	
			tx.commit();
	
		}catch (HibernateException e) {
			throw new PrestamoDispositivoException(e);
		}
	
		return usuario;
	}
	
	/**
	 * Es la implementacion del metodo declarado en la interface UsuarioDao
	 * que nos permite los valores de un usuario
	 */
	@Override
	public Usuario actualizar(Usuario usuario)
			throws PrestamoDispositivoException {
		Transaction tx = null;
		try{
			Session sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.update(usuario);
			tx.commit();
		}catch (HibernateException e) {
			throw new PrestamoDispositivoException(e);
		}
	
		return usuario;
	}
	
	/**
	 * Es la implementacion del metodo declarado en la interface UsuarioDao
	 * que nos permite eliminar un usuario
	 */
	@Override
	public void eliminar(Usuario usuario) throws PrestamoDispositivoException {
		Transaction tx = null;
		try{
			Session sesion = getSession();
	
			tx = sesion.beginTransaction();
			sesion.delete(usuario);
			tx.commit();
		}catch (HibernateException e) {
			throw new PrestamoDispositivoException(e);
		}
	
	}

}
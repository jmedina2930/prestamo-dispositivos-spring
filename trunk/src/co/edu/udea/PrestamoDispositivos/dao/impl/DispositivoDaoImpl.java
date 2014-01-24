package co.edu.udea.PrestamoDispositivos.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.PrestamoDispositivos.dao.DispositivoDao;
import co.edu.udea.PrestamoDispositivos.model.Dispositivo;
import co.edu.udea.PrestamoDispositivos.util.exception.PrestamoDispositivoException;




/**
 * 
 * @author Jonathan Medina, Mauricio Ortiz
 *
 */

public class DispositivoDaoImpl extends HibernateDaoSupport implements DispositivoDao {

	/**
	 * Es la implementacion del metodo declarado en la interface DispositivoDao
	 * que nos permite listar todos los dispositivos
	 */
	@Override
	public List<Dispositivo> obtener() {
		return getSession().createCriteria(Dispositivo.class).list();
	}

	/**
	 * Es la implementacion del metodo declarado en la interface DispositivoDao
	 * que nos permite buscar un dispositivo por su id
	 */
	@Override
	public Dispositivo obtenerPorId(Integer id) throws PrestamoDispositivoException {
		Dispositivo dispositivo = null;
		try{
			Session sesion = HibernateSessionFactory.getInstance().getSession();
			
			dispositivo = (Dispositivo)sesion.createCriteria(Dispositivo.class)
							 .add(Restrictions.eq("id", id))
							 .uniqueResult();
		}catch (HibernateException e) {
			throw new PrestamoDispositivoException(e);
		}
		
		return dispositivo;
		
	}

	/**
	 * Es la implementacion del metodo declarado en la interface DispositivoDao
	 * que nos permite guardar un dispositivo
	 */
	@Override
	public Dispositivo guardar(Dispositivo dispositivo)
			throws PrestamoDispositivoException {
		Transaction tx = null;
		try{
			Session sesion = HibernateSessionFactory.getInstance().getSession();
			
			tx = sesion.beginTransaction();
			
			sesion.save(dispositivo);
			
			tx.commit();
			
		}catch (HibernateException e) {
			throw new PrestamoDispositivoException(e);
		}
		
		return dispositivo;
	}

	/**
	 * Es la implementacion del metodo declarado en la interface DispositivoDao
	 * que nos permite actualizar el valor de un dispositivo
	 */
	@Override
	public Dispositivo actualizar(Dispositivo dispositivo)
			throws PrestamoDispositivoException {
		Transaction tx = null;
		try{
			Session sesion = HibernateSessionFactory.getInstance().getSession();
			tx = sesion.beginTransaction();
			sesion.update(dispositivo);
			tx.commit();
		}catch (HibernateException e) {
			throw new PrestamoDispositivoException(e);
		}
		
		return dispositivo;
	}

	/**
	 * Es la implementacion del metodo declarado en la interface DispositivoDao
	 * que nos permite eliminar un dispositivo
	 */
	@Override
	public void eliminar(Dispositivo dispositivo)
			throws PrestamoDispositivoException {
		Transaction tx = null;
		try{
			Session sesion = HibernateSessionFactory.getInstance().getSession();			
			tx = sesion.beginTransaction();
			sesion.delete(dispositivo);
			tx.commit();
		}catch (HibernateException e) {
			throw new PrestamoDispositivoException(e);
		}
		
	}

	/**
	 * Es la implementacion del metodo declarado en la interface DispositivoDao
	 * que nos permite ver la lista de todos los dispositivos disponibles
	 */
	@Override
	public List<Dispositivo> verDispositivoDisponible()
			throws PrestamoDispositivoException {
		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		Session sesion = null;
		try{
			sesion = HibernateSessionFactory.getInstance().getSession();			
			dispositivos = sesion.createCriteria(Dispositivo.class)
					.add(Restrictions.eq("estado", "disponible")).list();
		}catch (HibernateException e) {
			throw new PrestamoDispositivoException(e);
		}
		
		return dispositivos;
	}

}

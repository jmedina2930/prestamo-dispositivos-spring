package co.edu.udea.PrestamoDispositivos.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.PrestamoDispositivos.dao.PrestamoDao;
import co.edu.udea.PrestamoDispositivos.model.Prestamo;
import co.edu.udea.PrestamoDispositivos.util.exception.PrestamoDispositivoException;


/**
 * 
 * @author Jonathan Medina, Mauricio Ortiz
 *
 */

public class PrestamoDaoImpl extends HibernateDaoSupport implements PrestamoDao{

	/**
	 * Es la implementacion del metodo declarado en la interface PrestamoDao
	 * que nos permite listar todos los prestamos
	 */
	@Override
	public List<Prestamo> obtener() throws PrestamoDispositivoException {
		try{
			return getSession().createCriteria(Prestamo.class).list();
		}catch (HibernateException e) {
			throw new PrestamoDispositivoException(e);
		}
	}

	/**
	 * Es la implementacion del metodo declarado en la interface PrestamoDao
	 * que nos permite buscar un prestamo por su codigo_prestamo
	 */
	@Override
	public Prestamo obtenerPorCodigo(Integer codigo_prestamo)
			throws PrestamoDispositivoException {
		Prestamo prestamo = null;
		try{
			Session sesion = getSession();
			
			prestamo = (Prestamo)sesion.createCriteria(Prestamo.class)
							 .add(Restrictions.eq("codigo_prestamo", codigo_prestamo))
							 .uniqueResult();
		}catch (HibernateException e) {
			throw new PrestamoDispositivoException(e);
		}
		
		return prestamo;
	}

	/**
	 * Es la implementacion del metodo declarado en la interface PrestamoDao
	 * que nos permite guardar un prestamo
	 */
	@Override
	public Prestamo guardar(Prestamo prestamo)
			throws PrestamoDispositivoException {
		Transaction tx = null;
		try{
			Session sesion = getSession();
			
			tx = sesion.beginTransaction();
			
			sesion.save(prestamo);
			
			tx.commit();
			
		}catch (HibernateException e) {
			throw new PrestamoDispositivoException(e);
		}
		
		return prestamo;
	}

	/**
	 * Es la implementacion del metodo declarado en la interface PrestamoDao
	 * que nos permite actualizar el valor de un prestamo
	 */
	@Override
	public Prestamo actualizar(Prestamo prestamo)
			throws PrestamoDispositivoException {
		Transaction tx = null;
		try{
			Session sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.update(prestamo);
			tx.commit();
		}catch (HibernateException e) {
			throw new PrestamoDispositivoException(e);
		}
		
		return prestamo;
	}

	/**
	 * Es la implementacion del metodo declarado en la interface PrestamoDao
	 * que nos permite eliminar un prestamo
	 */
	@Override
	public void eliminar(Prestamo prestamo) throws PrestamoDispositivoException {
		Transaction tx = null;
		try{
			Session sesion = getSession();			
			tx = sesion.beginTransaction();
			sesion.delete(prestamo);
			tx.commit();
		}catch (HibernateException e) {
			throw new PrestamoDispositivoException(e);
		}
		
	}

	/**
	 * Es la implementacion del metodo declarado en la interface PrestamoDao
	 * que nos permite listar todos los prestamos pendientes
	 */
	@Override
	public List<Prestamo> verPrestamosPendientes()
			throws PrestamoDispositivoException {
		List<Prestamo> prestamos = new ArrayList<Prestamo>();
		Session sesion = null;
		try{
			sesion = getSession();			
			prestamos = sesion.createCriteria(Prestamo.class)
					.add(Restrictions.eq("estado_prestamo", "pendiente")).list();
		}catch (HibernateException e) {
			throw new PrestamoDispositivoException(e);
		}
		
		return prestamos;
	}

}

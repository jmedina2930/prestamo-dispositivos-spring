package co.edu.udea.PrestamoDispositivos.model;

import java.util.Date;


/**
 * Dto en el que se recibiran los datos de la tabla Prestamo
 * @author Yamit Cardozo
 *
 */
public class Prestamo {

	/**
	 * codigo cuando se realiza un prestamo
	 */
	private Integer codigo_prestamo;	
	/**
	 * hora  y fecha final al momento de hacer el prestamo
	 */
	private Date fecha_final;
	/**
	 *  hora y fecha inicial cuando se entrega el dispositivo
	 */
	private Date fecha_inicial;
	/**
	 * estado en el cual se encuentra el prestamo 
	 */
	private String estado_prestamo;
	/**
	 * referencia al dispositivo (id) que se presto
	 */
	private Dispositivo id_dispositivo;
	/**
	 * referencia al nombre de usuario que presto el dispositivo
	 */
	private Usuario nombre_usuario;
	/**
	 * 
	 * @return el codigo del prestamo
	 */
	
	public Integer getCodigo_prestamo() {
		return codigo_prestamo;
	}
	/**
	 * 
	 * @return el dispositivo que fue prestado
	 */
	public Dispositivo getId_dispositivo() {
		return id_dispositivo;
	}
	/**
	 * asigna el dispositivo prestado
	 * @param id_dispositivo
	 */
	public void setId_dispositivo(Dispositivo id_dispositivo) {
		this.id_dispositivo = id_dispositivo;
	}
	/**
	 * 
	 * @return retorna el nombre del usuario que presto el dispositivo
	 */
	public Usuario getNombre_usuario() {
		return nombre_usuario;
	}
	/**
	 * asigna el nombre de usuario que presta el dispositivo
	 * @param nombre_usuario
	 */
	public void setNombre_usuario(Usuario nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	/**
	 * asigna el codigo del prestamo
	 * @param codigo_prestamo
	 */
	public void setCodigo_prestamo(Integer codigo_prestamo) {
		this.codigo_prestamo = codigo_prestamo;
	}
	/**
	 * 
	 * @return la fecha(con hora) final del prestamo
	 */
	public Date getFecha_final() {
		return fecha_final;
	}
	/**
	 * asigna la fecha final del prestamo
	 * @param hora_final
	 */
	public void setFecha_final(Date fecha_final) {
		this.fecha_final = fecha_final;
	}
	/**
	 * 
	 * @return la fecha(con hora) inicial del prestamo
	 */
	public Date getFecha_inicial() {
		return fecha_inicial;
	}
	/**
	 * asigna fecha inicial del prestamo
	 * @param hora_inicial
	 */
	public void setFecha_inicial(Date fecha_inicial) {
		this.fecha_inicial = fecha_inicial;
	}
	/**
	 * 
	 * @return retorna el estado en el cual se encuentra del prestamo
	 */
	public String getEstado_prestamo(){
		return estado_prestamo;
	}
	/**
	 * asigna el estado en el cual se encuentra el prestamo
	 * @param estado_prestamo
	 */
	public void setEstado_prestamo(String estado_prestamo){
		this.estado_prestamo = estado_prestamo;
	}
}


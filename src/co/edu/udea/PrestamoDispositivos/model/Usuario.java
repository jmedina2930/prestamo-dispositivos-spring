package co.edu.udea.PrestamoDispositivos.model;

import java.util.HashSet;
import java.util.Set;



/**
 * Dto en el que se recibiran los datos de la tabla Usuario
 * @author Jonathan Medina
 *
 */
public class Usuario {
	private Set<Prestamo> prestamos;	
	/**
	 * cedula de usuario
	 */
	private String cedula;
	/**
	 * nombre de usuario
	 */
	private String nombre;
	/**
	 * apellido de usuario
	 */
	private String apellidos;
	/**
	 * contraseña de usuario
	 */
	private String contrasena;
	/**
	 * direccion de usuario
	 */
	private String direccion;
	/**
	 * telefono de usuario
	 */
	private String telefono;	
	/**
	 * rol de usuario
	 */
	private String rol;
	/**
	 * asigancion de usuario
	 */
	private String Usuario;
	/**
	 * 
	 * @return la cedula del usuario
	 */
	public String getCedula() {
		return cedula;
	}
	/**
	 * asigna la cedula del usuario
	 * @param cedula
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	/**
	 * 
	 * @return retorna el nombre del usuario
	 */
	public String getNombre() {
		return nombre;
	}
    /**
     * asigna el nombre de usuario
     * @param nombre
     */

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * 
	 * @return el apellido del usuario
	 */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * asigna el apellido del usuario
	 * @param apellido
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	/**
	 * 
	 * @return retorna la contraseña del usuario
	 */
	public String getContrasena() {
		return contrasena;
	}
	/**
	 * asigna la contrasena del usuario
	 * @param contraseña
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	/**
	 * 
	 * @return retorna la direccion del usuario
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * asigna la direccion del usuario
	 * @param direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * 
	 * @return el rol del usuario
	 */
	public String getRol() {
		return rol;
	}
	/**
	 * asigna el rol del usuario 
	 * @param rol
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}
	/**
	 * 
	 * @return retorna el usuario con el que se registro en el sistema
	 */
	public String getUsuario() {
		return Usuario;
	}
	/**
	 * asigna el usuario que registro en el sistema
	 * @param usuario
	 */
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	
	public Set<Prestamo> getPrestamos() {
		return prestamos;
	}
	public void setPrestamos(Set<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}

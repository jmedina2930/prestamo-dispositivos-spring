package co.edu.udea.PrestamoDispositivos.util.exception;

import org.apache.log4j.Logger;
import co.edu.udea.PrestamoDispositivos.util.exception.PrestamoDispositivoException;

/**
 * @author Mauricio Ortiz
 * clase que extiende de Exception y es utilizada para capturar las excepciones
 * dentro de la aplicacion 
 *
 */
public class PrestamoDispositivoException extends Exception {
	Logger log = Logger.getLogger(PrestamoDispositivoException.class);
	
	public PrestamoDispositivoException() {
		super();
		log.error(this.getMessage(), this);
	}

	public PrestamoDispositivoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		log.error(arg0, arg1);
	}

	public PrestamoDispositivoException(String arg0) {
		super(arg0);
		log.error(arg0, this);
	}

	public PrestamoDispositivoException(Throwable arg0) {
		super(arg0);
		log.error(arg0.getMessage(), arg0);
	}
}

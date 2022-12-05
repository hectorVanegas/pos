package co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad;

import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.ServicioAdicionalDTO;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;

/** 
 * ********************************************************************
 * @class  ServicioClaveSeguridadDTO
 *		   Objeto DTO que encapsula los atributos requeridos para el
 *		   despliegue del servicio adicional relacionado con el proceso 
 *		   de clave de seguridad
 * @author hector.cuenca
 * @date   17/03/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class ServicioClaveSeguridadDTO extends ServicioAdicionalDTO{

	/**
	 * @variable objTerceroNuevo
	 * 			 Objeto tercero nuevo, exclusivo para la operacion de cambio 
	 * 			 de beneficiario
	 */
	private Tercero objTerceroNuevo;
	
	/** 
	 * ********************************************************************
	 * @method ServicioClaveSeguridadDTO
	 * 		   Metodo constructor que permite inicializar los atributos y
	 * 		   comportamientos requeridos para la construccion de este objeto
	 * 		   DTO
	 * @author hector.cuenca
	 * @date   17/03/2016
	 * *********************************************************************
	 */
	public ServicioClaveSeguridadDTO() {
		
	}
	
	/** 
	 * ********************************************************************
	 * @method ServicioClaveSeguridadDTO
	 * 		   Metodo constructor que permite inicializar los atributos y
	 * 		   comportamientos requeridos para la construccion de este objeto
	 * 		   DTO, sobre-carga generada para la operacion de solicitud de
	 * 		   cambio de beneficiario, en la cual se pueda vincular los 
	 * 		   atributos adicionales de interes para el proceso
	 * @param  pObjTerceroNuevo
	 * 		   Objeto tercero nuevo, exclusivo para la operacion de cambio 
	 * 		   de beneficiario
	 * @author hector.cuenca
	 * @date   17/03/2016
	 * *********************************************************************
	 */
	public ServicioClaveSeguridadDTO(Tercero pObjTerceroNuevo) {
		
		this.setObjTerceroNuevo(pObjTerceroNuevo);
	}

	/**
	 * @method getObjTerceroNuevo
	 * 		   Metodo get del atributo objTerceroNuevo
	 * @return Tercero
	 *		   Valor del atributo objTerceroNuevo devuelto
	 * @author hector.cuenca
	 * @date   17/03/2016
	 */
	public Tercero getObjTerceroNuevo() {
		return objTerceroNuevo;
	}

	/**
	 * @method setObjTerceroNuevo
	 * 		   Metodo set del atributo objTerceroNuevo
	 * @param  pObjTerceroNuevo
	 *		   Valor que tomara el atributo objTerceroNuevo
	 * @author hector.cuenca
	 * @date   17/03/2016
	 */
	public void setObjTerceroNuevo(Tercero pObjTerceroNuevo) {
		this.objTerceroNuevo = pObjTerceroNuevo;
	}

}

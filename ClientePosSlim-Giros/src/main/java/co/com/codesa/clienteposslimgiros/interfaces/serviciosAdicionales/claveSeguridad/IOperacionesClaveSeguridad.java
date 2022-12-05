package co.com.codesa.clienteposslimgiros.interfaces.serviciosAdicionales.claveSeguridad;

import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.ServicioClaveSeguridadDTO;
import co.com.codesa.clienteposslimgiros.interfaces.serviciosAdicionales.IOperacionesServiciosAdicionales;

/** 
 * ********************************************************************
 * @class  IOperacionesClaveSeguridad
 *		   Interface que describe el conjunto de operaciones disponibles
 *		   a traves del servicio de clave de seguridad, adicionando las
 *		   particulares del mismo y sumando las basicas definidas para
 *		   todo servicio adicional 
 * @author hector.cuenca
 * @date   3/03/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public interface IOperacionesClaveSeguridad extends IOperacionesServiciosAdicionales<ServicioClaveSeguridadDTO> {
	
	/**
	 * Adicionar las operaciones particulares del servicio de clave de seguridad
	 */
}


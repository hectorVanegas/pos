package co.com.codesa.clienteposslimgiros.interfaces.serviciosAdicionales;

import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.ServicioAdicionalDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.serviciosAdicionales.EnumServiciosAdicionales;



/** 
 * ********************************************************************
 * @class  IOperacionesClaveSeguridad
 *		   Interface que describe el conjunto de operaciones disponibles
 *		   a traves del contenedor de servicios adicionales
 * @author hector.cuenca
 * @date   3/03/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public interface IOperacionesContenedorServiciosAdicionales {
	
	/** 
	 * ********************************************************************
	 * @method adicionarServicio
	 * 		   Metodo que permite incluir en el contenedor de servicios 
	 * 		   adicionales un servicio particular como tal, propuesto por
	 * 		   una operacion particular de negocio y retorna la interface
	 * 		   de operaciones permitidas sobre dicho servicio
	 * @param  pEnmServicioAdicional
	 * 		   Constante de enumeracion que representa la informacion 
	 * 		   basica relacionada con el servicio adicional que se prentede
	 * 		   incluir al contenedor
	 * @param  pStrNombreComponente
	 * 		   Nombre que recibira la seccion como tal
	 * @return <T extends IOperacionesServiciosAdicionales<? extends ServicioAdicionalDTO>>
	 * 		   
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author hector.cuenca
	 * @date   18/03/2016
	 * *********************************************************************
	 */
	public <T extends IOperacionesServiciosAdicionales<? extends ServicioAdicionalDTO>> T adicionarServicio(EnumServiciosAdicionales pEnmServicioAdicional,
																											String pStrNombreComponente)throws Exception;
}


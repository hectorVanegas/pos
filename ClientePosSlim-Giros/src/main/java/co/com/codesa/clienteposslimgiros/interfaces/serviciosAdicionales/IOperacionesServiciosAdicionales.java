package co.com.codesa.clienteposslimgiros.interfaces.serviciosAdicionales;

import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.ServicioAdicionalDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.operaciones.EnumTiposOperaciones;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;

/** 
 * ********************************************************************
 * @class  IOperacionesServiciosAdicionales
 *		   Interface que describe el conjunto de operaciones disponibles
 *		   a traves de un servicio adicional
 * @param <T> 
 * 		  Representacion generica de objetos DTO del tipo 
 * 		  ServicioAdicionalDTO
 * @author hector.cuenca
 * @date   3/03/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public interface IOperacionesServiciosAdicionales<T extends ServicioAdicionalDTO> {
	
	/** 
	 * ********************************************************************
	 * @method validarEstadoServicio
	 * 		   Metodo que permite validar la disponibilidad y estado del
	 * 		   servicio para la transaccion que se encuentra ejecutando
	 * 		   el estado se otorgara de acuerdo a los parametros de entrada
	 * 		   y se notificara en pantalla a traves del componente dedicado
	 * 		   a contener el valor del servicio
	 * @param  pObjFacturaGiro
	 * 		   Objeto factura que contiene todo el detalle de la transaccion 
	 * 		   que se esta llevando a cabo
	 * @param  pEnmTipoOperacion
	 * 		   Tipo de operacion que se esta llevando a cabo
	 * @param  pObjDtoServicioAdicional
	 * 		   Objeto DTO propio del servicio adicional que se esta ejecutando
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   10/03/2016
	 * *********************************************************************
	 */ 
	public void validarEstadoServicio(FacturaGiro pObjFacturaGiro,
	  		   						  EnumTiposOperaciones pEnmTipoOperacion,
	  		   						  T pObjDtoServicioAdicional)throws Exception;
	
	/** 
	 * ********************************************************************
	 * @method validaEjecucionServicio
	 * 		   Metodo que permite validar y ejecutar el servicio, este 
	 * 		   comportamiento tiene como intencion validar y desplegar 
	 * 		   procesos adicionales requeridos, obligatorios y particulares 
	 * 		   por el servicio para completar el objetivo de este, dentro de 
	 * 		   la transaccion efectuada  
	 * @param  pObjFacturaGiro
	 * 		   Objeto factura que contiene todo el detalle de la transaccion 
	 * 		   que se esta llevando a cabo
	 * @param  pEnmTipoOperacion
	 * 		   Tipo de operacion que se esta llevando a cabo
	 * @param  pObjDtoServicioAdicional
	 * 		   Objeto DTO propio del servicio adicional que se esta ejecutando
	 * @return boolean
	 * 		   Bandera que permite identificar si la ejecucion de los procesos 
	 * 		   adicionales desplegados por la inclusion del servicio, se 
	 * 		   llevaron a cabo satisfactoriamente
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   15/03/2016
	 * *********************************************************************
	 */
	public boolean validaEjecucionServicio(FacturaGiro pObjFacturaGiro,
	  		   					 		   EnumTiposOperaciones pEnmTipoOperacion,
	  		   					 		   T pObjDtoServicioAdicional) throws Exception;
	
	/** 
	 * ********************************************************************
	 * @method restablecerServicio
	 * 		   Metodo que permite restablecer el servicio, al estado por
	 * 		   defecto
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   12/03/2016
	 * *********************************************************************
	 */
	public void restablecerEstadoServicio()throws Exception;
}


package co.com.codesa.clienteposslimgiros.interfaces.serviciosAdicionales.claveSeguridad;

import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.ConfigOfrecerClaveSeguridadDTO;
import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad.TipoClaveSeguridadDTO;
import co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.claveSeguridad.FormaOfrecerClaveSeguridad;

/**
 * ****************************************************************.
 * @autor: Roberth Martinez Vargas
 * @fecha: 25-Febrero-2016
 * @descripcion: Interface
 * @copyright: Copyright  1998-2012 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public interface IFormasTiposClaveSeguridad {
	
	/**
  	 * ****************************************************************.
  	 * @method ejecutar
  	 * 		   Permite realizar la ejecucion del tipo de clave de 
  	 * 		   seguridad seleccionado
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @author Roberth Martinez Vargas
  	 * @date   29/3/2016
  	 * ****************************************************************
  	 */
	public void ejecutar()throws Exception;

	/**
  	 * ****************************************************************.
  	 * @method configurar
  	 * 		   Permite realizar la configuracion previa que requiere
  	 * 		   el tipo de clave de seguridad especifico para operar
  	 * @param  pFrmGnrOfrecerClaveSeguridad
	 * 		   Forma principal desde donde se controla todo el proceso para
	 * 		   asginar el tipo de clave de seguridad
  	 * @param  pConfigOfrecerClaveSeguridadDTO
  	 * 		   Objeto DTO que contiene toda la configuracion relacionada con 
	 * 		   el proceso de ofrecer el servicio de clave de seguridad
  	 * @param  pTipoClaveSeguridadDTO
  	 * 		   Objeto DTO que almacena los diferentes datos requeridos
  	 * 		   para el procesamiento del tipo de clave de seguridad 
  	 * 		   especifico
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @author Roberth Martinez Vargas
  	 * @date   29/3/2016
  	 * ****************************************************************
  	 */
	public void configurar(FormaOfrecerClaveSeguridad pFrmGnrOfrecerClaveSeguridad,
						   ConfigOfrecerClaveSeguridadDTO pConfigOfrecerClaveSeguridadDTO,
						   TipoClaveSeguridadDTO pTipoClaveSeguridadDTO)throws Exception;
	
	/** 
	 * ********************************************************************
	 * @method limpiar
	 * 		   permite realizar limpieza de los componentes
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   22/3/2016
	 * *********************************************************************
	 */
	public void limpiar()throws Exception;
}


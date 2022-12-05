package co.com.codesa.clienteposslimgiros.eventos.biometria;

import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.biometria.FormaSolicitarHuellas;

/** 
 * ********************************************************************
 * @class	EventoFormaSolicitarHuellas
 *		 	Clase que representa los eventos de la forma para solicitar
 *			las huellas a un tercero en procesos de enrolamiento y/o 
 *			verificacion biometrica
 * @author	hector.cuenca
 * @date  	20/09/2017
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class EventoFormaSolicitarHuellas extends EventoAbstracto{
	
	/**
	 * ********************************************************************
	 * @method	EventoFormaSolicitarHuellas
	 * 		  	Constructor que ejecuta la inicializacion de valores y 
  	 * 		   	ejecucion de comportamientos inicales requeridos para el 
  	 * 		   	despliegue de sus acciones
	 * @param	pForma
	 * 			referencia a la GUI de la cual se estan controlando los 
  	 * 		  	eventos
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	20/09/2017
	 * *********************************************************************
	 */
	public EventoFormaSolicitarHuellas	(	FormaSolicitarHuellas pForma	) 
			throws Exception
	{
		super(pForma);
	}
	
	/** 
	 * ********************************************************************
	 * @method	castFrmSolicitarHuellas
	 * 		  	Metodo estandar para formatear el tipo de dato general a 
  	 * 		   	un tipo especifico ("Casteo"), del atributo padre frmForma
	 * @return	FormaSolicitarHuellas
  	 * 		   	valor especifico recuperado
	 * @throws	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	20/09/2017
	 * *********************************************************************
	 */
	public FormaSolicitarHuellas castFrmSolicitarHuellas()throws Exception{
		return (FormaSolicitarHuellas)super.getFrmForma(); 
	}
}

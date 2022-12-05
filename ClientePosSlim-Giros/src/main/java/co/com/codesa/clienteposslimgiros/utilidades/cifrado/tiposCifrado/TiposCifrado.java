package co.com.codesa.clienteposslimgiros.utilidades.cifrado.tiposCifrado;

import co.com.codesa.clienteposslimgiros.interfaces.cifrado.OperacionesCifrado;

/** 
 * ********************************************************************
 * @class  TiposCifrado
 *		   Clase encargada de generalizar los atributos y comportamientos 
 *		   comunes a la implementacion de los diferentes tipos de cifrado 
 * @author hector.cuenca
 * @date   3/03/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public abstract class TiposCifrado implements OperacionesCifrado{

	/** 
	 * ********************************************************************
	 * @method TiposCifrado
	 * 		   Metodo constructor que permite la inicializacion de los 
	 * 		   valores y comportamientos necesarios para la construccion de
	 * 		   este objeto
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   3/03/2016
	 * *********************************************************************
	 */
	public TiposCifrado() throws Exception{
		
		super();
	}

}

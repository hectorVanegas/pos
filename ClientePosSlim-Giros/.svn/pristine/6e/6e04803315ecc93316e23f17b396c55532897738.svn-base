package co.com.codesa.clienteposslimgiros.utilidades.biometria;

import java.util.HashMap;
import co.com.codesa.clienteposslimgiros.enumeraciones.biometria.EnumTiposBiometriaCaja;


/** 
 * ********************************************************************
 * @class	UtilTiposBiometriaCaja
 *		 	Clase utilitaria relacionada con los tipos de biometria 
 *			interpretados para la caja
 * @author	hector.cuenca
 * @date  	28/08/2017
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class UtilTiposBiometriaCaja 
{	
	/**
	 * @variable hmEnmTiposBiometriaCaja 
	 * 			 Estructura de facil acceso para administrar las constantes de enumeracion
	 * 		   	 referentes a los tipos de biometria configurados para la caja
	 **/
	private HashMap<String, EnumTiposBiometriaCaja> hmEnmTiposBiometriaCaja;
	
	/**
	 * @variable 	instancia 
	 * 				Referencia estatica de la clase utilitaria, clave para incorporar
	 * 			 	SINGLETON (patron de diseño)
	 **/
	private static UtilTiposBiometriaCaja instancia;
	
	/**
  	 * ****************************************************************.
  	 * @metodo UtilTiposBiometriaCaja
  	 * 		   Metodo constructor que permite inicializar variables y
  	 * 		   ejecutar comportamientos de interes
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private UtilTiposBiometriaCaja() 
			throws Exception
	{
		this.cargarHashEnumTiposBiometriaCaja();
	}

	/**
  	 * ****************************************************************.
  	 * @metodo getInstance
  	 * 		   Metodo clave para ejecutar el patron singleton sobre la 
  	 * 		   clase, materializando esta por unica vez y manteniendo una 
  	 * 		   sola instancia de esta
  	 * @return UtilTiposBiometriaCaja
  	 * 		   Tipo referente a la misma clase
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public static UtilTiposBiometriaCaja getInstance()throws Exception{
		
		if (instancia == null) {
			
			instancia = new UtilTiposBiometriaCaja();
		}
		
		return instancia;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	cargarHashEnumTiposBiometriaCaja
	 * 		   	Metodo que realiza el cargue de los diferentes tipos 
	 * 			implementados de biometria para la caja  
	 * @throws 	Exception
	 * 		   	Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author 	hector.cuenca
	 * @date   	28/08/2017
	 * *********************************************************************
	 */
	private void cargarHashEnumTiposBiometriaCaja() 
			throws Exception
	{
		this.hmEnmTiposBiometriaCaja = new HashMap<String,EnumTiposBiometriaCaja>();
		
		for	(	EnumTiposBiometriaCaja enmTipoBiometriaCaja : EnumTiposBiometriaCaja.values()	)
		{
			this.hmEnmTiposBiometriaCaja.put(	enmTipoBiometriaCaja.getStrValorPropiedad (), 
			                                 	enmTipoBiometriaCaja
			                                );
		}
	}
	
	/**
	 * @method	getHmEnmTiposBiometriaCaja
	 * 		  	Metodo get del atributo hmEnmTiposBiometriaCaja
	 * @return	HashMap<String,EnumTiposBiometriaCaja>
	 *		  	Valor del atributo hmEnmTiposBiometriaCaja devuelto
	 * @author	hector.cuenca
	 * @date  	28/08/2017
	 */
	public HashMap<String, EnumTiposBiometriaCaja> getHmEnmTiposBiometriaCaja ()
	{
		return hmEnmTiposBiometriaCaja;
	}

	/**
	 * @method	setHmEnmTiposBiometriaCaja
	 * 		  	Metodo set del atributo hmEnmTiposBiometriaCaja
	 * @param	pHmEnmTiposBiometriaCaja
	 * 			Valor que tomara el atributo hmEnmTiposBiometriaCaja
	 * @author	hector.cuenca
	 * @date	28/08/2017
	 */
	public void setHmEnmTiposBiometriaCaja (HashMap<String, EnumTiposBiometriaCaja> pHmEnmTiposBiometriaCaja)
	{
		this.hmEnmTiposBiometriaCaja = pHmEnmTiposBiometriaCaja;
	}
	
	
	
}

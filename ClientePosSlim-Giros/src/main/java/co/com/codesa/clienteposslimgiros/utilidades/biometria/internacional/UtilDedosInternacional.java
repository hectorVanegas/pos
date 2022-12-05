package co.com.codesa.clienteposslimgiros.utilidades.biometria.internacional;

import java.util.HashMap;

import co.com.codesa.clienteposslimgiros.enumeraciones.biometria.internacional.EnumDedosInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Dedo;

/** 
 * ********************************************************************
 * @class	UtilDedosInternacional
 *		 	Utilidad relacionada con el enumerador EnumDedosInternacional
 * @author	hector.cuenca
 * @date  	31/03/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class UtilDedosInternacional {
	
	/**
	 * @variable hmObjDedos 
	 * 			 Estructura de facil acceso para administrar las constantes de enumeracion
	 * 		   	 registradas en EnumDedosInternacional
	 **/
	private HashMap<String, Dedo> hmObjDedos;
	
	/**
	 * @variable instance
	 * 			 Referencia estatica de la clase utilitaria, clave para 
	 * 		 	 incorporar SINGLETON (patron de diseño)
	 **/
	private static UtilDedosInternacional instance;

	/**
	 * ********************************************************************
	 * @method UtilDedosInternacional
	 * 		   Metodo constructor que permite inicializar variables y
	 * 		   ejecutar comportamientos de interes
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
	 * 		   presentada 
	 * @author hector.cuenca
	 * @date   31/03/2018
	 * ********************************************************************
	 */
	private UtilDedosInternacional() throws Exception {
		this.cargarHashEnumDedosInternacional();
	}

	/** 
	 * ********************************************************************
	 * @method getInstancia
	 * 		   Metodo clave para ejecutar el patron singleton sobre la 
	 * 		   clase, materializando esta por unica vez y manteniendo una 
	 * 		   sola instancia de esta
	 * @return UtilDedosInternacional
	 * 		   Tipo referente a la misma clase
	 * @throws Exception
	 *		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author hector.cuenca
	 * @date   31/03/2018
	 * ********************************************************************
	 */
	public static UtilDedosInternacional getInstancia() throws Exception {

		if (instance == null) {

			instance = new UtilDedosInternacional();
		}

		return instance;
	}

	/** 
	 * ********************************************************************
	 * @method 	cargarHashEnumDedosInternacional
	 * 		   	Metodo que realiza el cargue de las diferentes constantes
	 * 			de enumeracion registradas en EnumDedosInternacional
	 * @throws 	Exception
	 * 		   	Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author 	hector.cuenca
	 * @date   	28/08/2017
	 * *********************************************************************
	 */
	private void cargarHashEnumDedosInternacional() 
			throws Exception
	{
		this.hmObjDedos = new HashMap<String,Dedo>();
		
		for	(	EnumDedosInternacional enmMano : EnumDedosInternacional.values()	)
		{
			this.hmObjDedos.put	(	enmMano.getStrTipoDedo(), 
			                		new Dedo	(	enmMano.getStrTipoDedo(),
			                						enmMano.getEnmDescripcionDedo().toString()
			                					)
			                    );
		}
	}

	/**
	 * @method	getHmObjDedos
	 * 		  	Metodo get del atributo hmObjDedos
	 * @return	HashMap<String,Dedo>
	 *		  	Valor del atributo hmObjDedos devuelto
	 * @author	hector.cuenca
	 * @date  	31/03/2018
	 */
	public HashMap<String, Dedo> getHmObjDedos() {
		return this.hmObjDedos;
	}

	/**
	 * @method	setHmObjDedos
	 * 		  	Metodo set del atributo hmObjDedos
	 * @param	pHmObjDedos
	 * 			Valor que tomara el atributo hmObjDedos
	 * @author	hector.cuenca
	 * @date	31/03/2018
	 */
	public void setHmObjDedos(HashMap<String, Dedo> pHmObjDedos) {
		this.hmObjDedos = pHmObjDedos;
	}
}

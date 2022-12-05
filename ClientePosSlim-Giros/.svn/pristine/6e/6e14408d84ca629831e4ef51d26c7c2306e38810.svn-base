package co.com.codesa.clienteposslimgiros.utilidades.biometria.internacional;

import java.util.HashMap;
import co.com.codesa.clienteposslimgiros.enumeraciones.biometria.internacional.EnumManosInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Mano;

/** 
 * ********************************************************************
 * @class	UtilManosInternacional
 *		 	Utilidad relacionada con el enumerador EnumManosInternacional
 * @author	hector.cuenca
 * @date  	31/03/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class UtilManosInternacional {

	/**
	 * @variable hmObjManos 
	 * 			 Estructura de facil acceso para administrar las constantes de enumeracion
	 * 		   	 registradas en EnumManosInternacional
	 **/
	private HashMap<String, Mano> hmObjManos;
	
	/**
	 * @variable instance
	 * 			 Referencia estatica de la clase utilitaria, clave para 
	 * 		 	 incorporar SINGLETON (patron de diseño)
	 **/
	private static UtilManosInternacional instance;

	/**
	 * ********************************************************************
	 * @method UtilManosInternacional
	 * 		   Metodo constructor que permite inicializar variables y
	 * 		   ejecutar comportamientos de interes
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
	 * 		   presentada 
	 * @author hector.cuenca
	 * @date   31/03/2018
	 * ********************************************************************
	 */
	private UtilManosInternacional() throws Exception {
		this.cargarHashEnumManosInternacional();
	}

	/** 
	 * ********************************************************************
	 * @method getInstancia
	 * 		   Metodo clave para ejecutar el patron singleton sobre la 
	 * 		   clase, materializando esta por unica vez y manteniendo una 
	 * 		   sola instancia de esta
	 * @return UtilManosInternacional
	 * 		   Tipo referente a la misma clase
	 * @throws Exception
	 *		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author hector.cuenca
	 * @date   31/03/2018
	 * ********************************************************************
	 */
	public static UtilManosInternacional getInstancia() throws Exception {

		if (instance == null) {

			instance = new UtilManosInternacional();
		}

		return instance;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	cargarHashEnumManosInternacional
	 * 		   	Metodo que realiza el cargue de las diferentes constantes
	 * 			de enumeracion registradas en EnumManosInternacional
	 * @throws 	Exception
	 * 		   	Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author 	hector.cuenca
	 * @date   	28/08/2017
	 * *********************************************************************
	 */
	private void cargarHashEnumManosInternacional() 
			throws Exception
	{
		this.hmObjManos = new HashMap<String,Mano>();
		
		for	(	EnumManosInternacional enmMano : EnumManosInternacional.values()	)
		{
			this.hmObjManos.put	(	enmMano.getStrTipoMano(), 
			                		new Mano	(	enmMano.getStrTipoMano(),
			                						enmMano.getEnmDescripcionMano().toString()
			                					)
			                    );
		}
	}

	/**
	 * @method	getHmObjManos
	 * 		  	Metodo get del atributo hmObjManos
	 * @return	HashMap<String,Mano>
	 *		  	Valor del atributo hmObjManos devuelto
	 * @author	hector.cuenca
	 * @date  	31/03/2018
	 */
	public HashMap<String, Mano> getHmObjManos() {
		return this.hmObjManos;
	}

	/**
	 * @method	setHmObjManos
	 * 		  	Metodo set del atributo hmObjManos
	 * @param	pHmObjManos
	 * 			Valor que tomara el atributo hmObjManos
	 * @author	hector.cuenca
	 * @date	31/03/2018
	 */
	public void setHmObjManos(HashMap<String, Mano> pHmObjManos) {
		this.hmObjManos = pHmObjManos;
	}
}

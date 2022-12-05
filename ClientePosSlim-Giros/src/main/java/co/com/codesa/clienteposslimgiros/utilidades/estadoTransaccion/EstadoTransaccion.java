package co.com.codesa.clienteposslimgiros.utilidades.estadoTransaccion;

import co.com.codesa.clienteposslim.actualizacionauto.Config;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEstadoTransaccion;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 14-abr-2015
 * @Clase EstadoTransaccion 
 * 		  Clase utilitaria relacionada con las transacciones pendientes
 * 		  gestionadas atraves de un archivo estado.cfg
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class EstadoTransaccion {
	
	/**
	 * @variable objCfgArchivoEstadoTransaccion 
	 * 			 Objeto mediante el cual se realizan las operaciones directas
	 * 			 sobre el archivo local de estado transaccional
	 **/
	private Config objCfgArchivoEstadoTransaccion;
	
	/**
	 * @variable instancia 
	 * 			 Referencia estatica de la clase utilitaria, clave para incorporar
	 * 			 SINGLETON (patron de dise�o)
	 **/
	private static EstadoTransaccion instancia;
	
	/**
  	 * ****************************************************************.
  	 * @metodo EstadoTransaccion
  	 * 		   Metodo constructor que permite inicializar variables y
  	 * 		   ejecutar comportamientos de interes
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private EstadoTransaccion() throws Exception {
		
		this.objCfgArchivoEstadoTransaccion = new Config(EnumParametrosApp.ESTADO_CFG.getValorPropiedad(), 
				  							  			 Config.no_encriptar, 
				  							  			 Config.crear);
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo getInstance
  	 * 		   Metodo clave para ejecutar el patron singleton sobre la 
  	 * 		   clase, materializando esta por unica vez y manteniendo una 
  	 * 		   sola instancia de esta
  	 * @return EstadoTransaccion
  	 * 		   Tipo referente a la misma clase
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public static EstadoTransaccion getInstance() throws Exception{
		
		if (instancia == null) {
			
			instancia = new EstadoTransaccion();
		}
		
		return instancia;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo grabarValorPropiedad
  	 * 		   metodo que permite grabar un valor sobre una propiedad
  	 * 		   dentro del archivo local de estado transaccional
  	 * @param pEnmPropiedad
  	 * 		  Constante de enumeracion que representa la propiedad de 
  	 * 		  interes sobre la cual se ejecuta el proceso de grabado
  	 * @param pStrValor
  	 * 		  Valor que se asignara a la propiedad
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void grabarValorPropiedad(EnumEstadoTransaccion pEnmPropiedad,
						             String pStrValor) throws Exception{
		
		pStrValor = (pStrValor == null)?"":pStrValor;
		
		this.objCfgArchivoEstadoTransaccion.setValor(pEnmPropiedad.getStrPropiedad(), 
													 pStrValor);

		this.objCfgArchivoEstadoTransaccion.guardarArchivo();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo obtenerValorPropiedad
  	 * 		   Metodo que permite obtener el valor asignado a una 
  	 * 		   propiedad, considerando la recepcion de un valor por
  	 * 		   defecto en caso de presentar inconvenientes en el proceso
  	 * 		   de obtener el valor
  	 * @param pEnmPropiedad
  	 * 		  Constante de enumeracion que representa la propiedad de 
  	 * 		  interes sobre la cual se desea obtener su valor asignado
  	 * @param pStrValorXDefecto
  	 * 		  Valor por defecto que devolvera el comportamiento, en caso
  	 * 		  de presentar inconvenientes para recuperar el valor de la
  	 * 		  propiedad, entre ellos: el acceso al archivo, ausencia de 
  	 * 		  la propiedad, entre otros
  	 * @return String
  	 * 		   Valor equivalente a la propiedad recibida
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public String obtenerValorPropiedad(EnumEstadoTransaccion pEnmPropiedad,
										String pStrValorXDefecto) throws Exception{
							
		String strValorPropiedad;
		
		pStrValorXDefecto = (pStrValorXDefecto==null)?"":pStrValorXDefecto;
		
		strValorPropiedad = this.objCfgArchivoEstadoTransaccion.getString	(	pEnmPropiedad.getStrPropiedad(), 
																pStrValorXDefecto
															); 
		if	(	strValorPropiedad == null	) 
		{
			this.grabarValorPropiedad(pEnmPropiedad,pStrValorXDefecto);
			strValorPropiedad = pStrValorXDefecto;
		}
		
		return strValorPropiedad;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo compararValorPropiedad
  	 * 		   Metodo que permite verificar y/o comparar el valor de una
  	 * 		   propiedad, considerando la recepcion de un valor por
  	 * 		   defecto en caso de presentar inconvenientes en el proceso
  	 * 		   de obtener el valor
  	 * @param pEnmPropiedad
  	 * 		  Constante de enumeracion que representa la propiedad de 
  	 * 		  interes sobre la cual se desea comparar su valor
  	 * @param pStrValorXDefecto
  	 * 		  Valor por defecto utilizado por el proceso de obtener el
  	 * 		  valor de la propiedad
  	 * @param pStrValorValidar
  	 * 		  Valor con el cual se desea comparar el valor asignado de 
  	 * 		  la propiedad
  	 * @return boolean
  	 * 		   Bandera que identifica el resultado del proceso de 
  	 * 		   verificacion y/o comparacion 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public boolean compararValorPropiedad(EnumEstadoTransaccion pEnmPropiedad,
            							  String pStrValorXDefecto, 
            							  String pStrValorValidar) throws Exception{
		
		String strValorPropiedad;
		
		pStrValorXDefecto = (pStrValorXDefecto == null)?"":pStrValorXDefecto;
		pStrValorValidar = (pStrValorValidar == null)?"":pStrValorValidar;
		
		strValorPropiedad = this.obtenerValorPropiedad(pEnmPropiedad, 
													   pStrValorXDefecto);
		
		return strValorPropiedad.trim().equalsIgnoreCase(pStrValorValidar);
	}

}

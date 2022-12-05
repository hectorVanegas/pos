package co.com.codesa.clienteposslimgiros.enumeraciones;

import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.MedioPago;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 14-abr-2015
 * @Clase EnumMediosPago 
 * 		  Clase enumerador, que permite administrar de forma diciente 
 * 		  los medios de pago manejados por el sistema.
 * 
 * 		  Importante: Esta clase permite almacenar las configuraciones 
 * 		  			  necesarias para la obtencion del objeto medioPago, 
 * 					  el cual puede ser obtenido bajo una constante o 
 * 					  consultado a traves de un parametro de sistema,
 * 					  en ambos casos (constante/parametro), los valores
 * 					  pueden hacer referencia al codigo o el id del 
 * 					  medioPago que se pretende referenciar, para ello
 * 					  se hace necesario indicar el valor por el cual se 
 * 					  realizara la comparacion (true: codigo | false: id) 
 *  
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public enum EnumMediosPago {
	
	EFECTIVO("efectivo",EnumMediosPago.VALIDA_X_CODIGO,"1"),
	TARJETA_DEBITO("debito",EnumMediosPago.VALIDA_X_CODIGO,"0"/*EnumParametrosSistema.CODIGO_MEDIO_PAGO_TARJETA_DEBITO*/),
	TARJETA_CREDITO("credito",EnumMediosPago.VALIDA_X_CODIGO,"0"/*EnumParametrosSistema.CODIGO_MEDIO_PAGO_TARJETA_CREDITO*/),
	;
	
	/**
	 * @variable VALIDA_X_CODIGO 
	 * 			 Bandera positiva (true), utilizada para identificar que 
	 * 			 la comparacion para la obtencion del objeto se realizara 
	 * 			 por codigo 
	 **/
	public final static boolean VALIDA_X_CODIGO = true;
	
	/**
	 * @variable VALIDA_X_ID 
	 * 			 Bandera negativa (false), utilizada para identificar que 
	 * 			 la comparacion para la obtencion del objeto se realizara 
	 * 			 por id 
	 **/
	public final static boolean VALIDA_X_ID = false;
	
	/**
	 * @variable strEtiqueta 
	 * 			 Etiqueta de enumerador
	 **/
	private final String strEtiqueta;
	
	/**
	 * @variable booTipoBusqueda 
	 * 			 Bandera que permite identificar bajo que tipo de valor se 
	 * 			 realizara la busqueda (true: codigo | false: id)
	 **/
	private boolean booTipoBusqueda;
	
	/**
	 * @variable objValorBusqueda 
	 * 			 Valor por el cual se realizara la busqueda, puede hacer
	 * 			 referencia a una constante o un parametro del sistema
	 **/
	private Object objValorBusqueda;
	
	/**
	 * @variable objMedioPago 
	 * 			 Objeto medioPago referenciado por la constante de enumeracion
	 **/
	private MedioPago objMedioPago;
	
	/**
  	 * ****************************************************************.
  	 * @metodo EnumMediosPago
  	 * 		   Inicializacion de la constante de enumeracion, configurada 
  	 * 		   por constante de busqueda
  	 * @param pStrEtiqueta
  	 * 		  Etiqueta de enumerador
  	 * @param pBooTipoBusqueda
  	 * 		  Bandera que permite identificar bajo que tipo de valor se 
	 * 		  realizara la busqueda (true: codigo | false: id)
  	 * @param pStrIdCodigo
  	 * 		  Valor constante (Id o el Codigo), por el cual se realizara 
  	 * 		  la busqueda
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private EnumMediosPago(String pStrEtiqueta,
						   boolean pBooTipoBusqueda,
						   String pStrIdCodigo){
		
		this.strEtiqueta=pStrEtiqueta;
		this.booTipoBusqueda = pBooTipoBusqueda;
		this.objValorBusqueda = pStrIdCodigo;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo EnumMediosPago
  	 * 		   Inicializacion de la constante de enumeracion, configurada 
  	 * 		   por consulta de parametro como valor de busqueda
  	 * @param pStrEtiqueta
  	 * 		  Etiqueta de enumerador
  	 * @param pBooTipoBusqueda
  	 * 		  Bandera que permite identificar bajo que tipo de valor se 
	 * 		  realizara la busqueda (true: codigo | false: id)
  	 * @param pEnmParametroSistema
  	 * 		  Constante de enumeracion de parametro de sistema, por la
  	 * 		  cual se pretende realizar la consulta del valor de busqueda
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private EnumMediosPago(String pStrEtiqueta,
						   boolean pBooTipoBusqueda,
			  			   EnumParametrosSistema pEnmParametroSistema){
		
		this.strEtiqueta=pStrEtiqueta;
		this.objValorBusqueda = pEnmParametroSistema;
		this.booTipoBusqueda = pBooTipoBusqueda;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo EnumProductos
  	 * 		   Inicializacion de la constante de enumeracion, no requiere
  	 * 		   la busqueda el objeto producto, por tal razon permite recibir
  	 * 		   este objeto de manera inicial
  	 * @param pStrEtiqueta
  	 * 		  Etiqueta de enumerador
  	 * @param pObjMedioPago
  	 * 		  Objeto medioPago referenciado 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private EnumMediosPago(String pStrEtiqueta, 
						   MedioPago pObjMedioPago){
		
		this.strEtiqueta=pStrEtiqueta;
		this.objMedioPago = pObjMedioPago;
	}

	public String getStrEtiqueta() {
		return strEtiqueta;
	}

	public MedioPago getObjMedioPago() {
		return objMedioPago;
	}

	public void setObjMedioPago(MedioPago objMedioPago) {
		this.objMedioPago = objMedioPago;
	}

	public boolean isBooTipoBusqueda() {
		return booTipoBusqueda;
	}

	public void setBooTipoBusqueda(boolean booTipoBusqueda) {
		this.booTipoBusqueda = booTipoBusqueda;
	}

	public Object getObjValorBusqueda() {
		return objValorBusqueda;
	}

	public void setObjValorBusqueda(Object objValorBusqueda) {
		this.objValorBusqueda = objValorBusqueda;
	}
}

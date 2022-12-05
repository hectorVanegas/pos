package co.com.codesa.clienteposslimgiros.enumeraciones;

import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Producto;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 14-abr-2015
 * @Clase EnumProductos 
 * 		  Clase enumerador, que permite administrar de forma diciente 
 * 		  los productos manejados por el sistema.
 * 
 * 		  Importante: Esta clase permite almacenar las configuraciones 
 * 		  			  necesarias para la obtencion del objeto producto, 
 * 					  el cual puede ser obtenido bajo una constante o 
 * 					  consultado a traves de un parametro de sistema,
 * 					  en ambos casos (constante/parametro), los valores
 * 					  pueden hacer referencia al codigo o el id del 
 * 					  producto que se pretende referenciar, para ello
 * 					  se hace necesario indicar el valor por el cual se 
 * 					  realizara la comparacion (true: codigo | false: id) 
 *  
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public enum EnumProductos {
	
	GIRO("giro",EnumProductos.VALIDA_X_CODIGO,"1"),
	SEGURO("seguro",EnumProductos.VALIDA_X_CODIGO, EnumParametrosSistema.COD_PRODUCTO_SEGURO_SMS),//2
	RECAUDO("recaudo",EnumProductos.VALIDA_X_CODIGO,"3"),
	SMS("sms",EnumProductos.VALIDA_X_CODIGO,"4"),
	BANCO_OCCIDENTE("banco_occidente",EnumProductos.VALIDA_X_CODIGO,"5"),
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
	 * @variable objDocumento 
	 * 			 Objeto producto referenciado por la constante de enumeracion
	 **/
	private Producto objProducto;
	
	/**
  	 * ****************************************************************.
  	 * @metodo EnumProductos
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
	private EnumProductos(String pStrEtiqueta,
						  boolean pBooTipoBusqueda,
						  String pStrIdCodigo){
		
		this.strEtiqueta=pStrEtiqueta;
		this.booTipoBusqueda = pBooTipoBusqueda;
		this.objValorBusqueda = pStrIdCodigo;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo EnumProductos
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
	private EnumProductos(String pStrEtiqueta,
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
  	 * @param pObjProducto
  	 * 		  Objeto producto referenciado 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private EnumProductos(String pStrEtiqueta, 
						  Producto pObjProducto){
		
		this.strEtiqueta=pStrEtiqueta;
		this.objProducto = pObjProducto;
	}

	public String getStrEtiqueta() {
		return strEtiqueta;
	}

	public Producto getObjProducto() {
		return objProducto;
	}

	public void setObjProducto(Producto objProducto) {
		this.objProducto = objProducto;
	}

	public Boolean getBooTipoBusqueda() {
		return booTipoBusqueda;
	}

	public void setBooTipoBusqueda(boolean BooTipoBusqueda) {
		this.booTipoBusqueda = BooTipoBusqueda;
	}

	public Object getObjValorBusqueda() {
		return objValorBusqueda;
	}

	public void setObjValorBusqueda(Object objValorBusqueda) {
		this.objValorBusqueda = objValorBusqueda;
	}
}

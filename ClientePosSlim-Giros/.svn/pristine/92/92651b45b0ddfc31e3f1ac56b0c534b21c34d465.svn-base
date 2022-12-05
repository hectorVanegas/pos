package co.com.codesa.clienteposslimgiros.enumeraciones;

import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Documento;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 14-abr-2015
 * @Clase EnumDocumentos 
 * 		  Clase enumerador, que permite administrar de forma diciente 
 * 		  los documentos manejados por el sistema.
 * 
 * 		  Importante: Esta clase permite almacenar las configuraciones 
 * 		  			  necesarias para la obtencion del objeto documento, 
 * 					  el cual puede ser obtenido bajo una constante o 
 * 					  consultado a traves de un parametro de sistema,
 * 					  en ambos casos (constante/parametro), los valores
 * 					  pueden hacer referencia al codigo o el id del 
 * 					  documento que se pretende referenciar, para ello
 * 					  se hace necesario indicar el valor por el cual se 
 * 					  realizara la comparacion (true: codigo | false: id) 
 *  
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public enum EnumDocumentos {
	
	FACTURA("documento_factura",EnumDocumentos.VALIDA_X_CODIGO,"1"),
	
	COMPROBANTE_CAJA("comprobante_caja",EnumDocumentos.VALIDA_X_ID,"2"),
	COMPROBANTE_DESEMBOLSO_GIROS("comprobante_desembolso_giros",EnumDocumentos.VALIDA_X_ID,"3"),
	COMPROBANTE_PROVISIONES("comprobante_provisiones",EnumDocumentos.VALIDA_X_ID,"4"),
	COMPROBANTE_DESEMBOLSO_FLETES("comprobante_desembolso_fletes",EnumDocumentos.VALIDA_X_ID,"10"),
	COMPROBANTE_DESEMBOLSO_SPN("comprobante_desembolso_spn",EnumDocumentos.VALIDA_X_ID,"11"),
	COMPROBANTE_DESEMBOLSO_CONTRIBUCION("comprobante_desembolso_contribucion",EnumDocumentos.VALIDA_X_ID,"12"),
	COMPROBANTE_DESEMBOLSO_DOMICILIO("comprobante_desembolso_domicilio",EnumDocumentos.VALIDA_X_ID,"13"),
	
	//PAQUETERIA("paqueteria"),
	
	CERTIFICADO_SEGURO("certificado_seguro",EnumDocumentos.VALIDA_X_CODIGO,"16"),
	
	//PAGO_SINIESTRO("pago_siniestro"),
	
	SMS("sms",EnumDocumentos.VALIDA_X_CODIGO,"20"),
	
	RECAUDO_BANCO_OCCIDENTE("recaudo_banco_occidente",EnumDocumentos.VALIDA_X_ID,"24"),
	RECAUDO("recaudo",EnumDocumentos.VALIDA_X_CODIGO,"27"),
	FACTURACION_VIRTUAL("documento_facturacion_virtual",EnumDocumentos.VALIDA_X_CODIGO,"41"),
	FACTURACION_GIRO_RETIRO("documento_facturacion_giro_retiro",EnumDocumentos.VALIDA_X_CODIGO,"45"),
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
	 * 			 Objeto documento referenciado por la constante de enumeracion
	 **/
	private Documento objDocumento;
	
	/**
  	 * ****************************************************************.
  	 * @metodo EnumDocumentos
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
	private EnumDocumentos(String pStrEtiqueta,
						   boolean pBooTipoBusqueda,
						   String pStrIdCodigo){
		
		this.strEtiqueta=pStrEtiqueta;
		this.booTipoBusqueda = pBooTipoBusqueda;
		this.objValorBusqueda = pStrIdCodigo;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo EnumDocumentos
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
	private EnumDocumentos(String etiqueta,
						   boolean pBooTipoBusqueda,
			  			   EnumParametrosSistema pEnmParametroSistema){
		
		this.strEtiqueta=etiqueta;
		this.objValorBusqueda = pEnmParametroSistema;
		this.booTipoBusqueda = pBooTipoBusqueda;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo EnumDocumentos
  	 * 		   Inicializacion de la constante de enumeracion, no requiere
  	 * 		   la busqueda el objeto documento, por tal razon permite recibir
  	 * 		   este objeto de manera inicial
  	 * @param pStrEtiqueta
  	 * 		  Etiqueta de enumerador
  	 * @param pObjDocumento
  	 * 		  Objeto documento referenciado 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private EnumDocumentos(String etiqueta, 
						   Documento pObjDocumento){
		
		this.strEtiqueta=etiqueta;
		this.objDocumento = pObjDocumento;
	}

	public String getStrEtiqueta() {
		return strEtiqueta;
	}

	public Documento getObjDocumento() {
		return objDocumento;
	}

	public void setObjDocumento(Documento objDocumento) {
		this.objDocumento = objDocumento;
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

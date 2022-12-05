package co.com.codesa.clienteposslimgiros.enumeraciones.proveedorServicioProducto;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumRecursosProperties;
import co.com.codesa.clienteposslimgiros.enumeraciones.operaciones.EnumTiposOperaciones;

/**
 * ********************************************************************
 * @class EnumTiposServicios
 *		  Clase enumerador, que permite administrar de forma diciente 
 * 		  los tipos de servicio configurados a nivel de la estructura 
 * 		  proveedor - servicio - producto
 * @author hector.cuenca
 * @date 2/03/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public enum EnumTiposServicios {
	
	/**
	 * @variable ENVIO_GIRO
	 * 			 Constante que representa el tipo de servicio para 
	 * 			 realizar un envio de giro
	 */
	ENVIO_GIRO("envio_giro", 
				EnumTiposOperaciones.ENVIO_FACTURACION_GIRO,
				"TISEENGI"),
	
	/**
	 * @variable PAGO_GIRO
	 * 			 Constante que representa el tipo de servicio para 
	 * 			 realizar un pago de giro
	 */
	PAGO_GIRO("pago_giro", 
			   EnumTiposOperaciones.PAGO_FACTURACION_GIRO,
			   "TISEPGGI"),
			   
   /**
	 * @variable ENVIO_GIRO_INTERNACIONAL
	 * 			 Constante que representa el tipo de servicio para 
	 * 			 realizar un envio de giro internacional
	 */
	ENVIO_GIRO_INTERNACIONAL("envio_giro_internacional", 
			   				EnumTiposOperaciones.ENVIO_FACTURACION_GIRO_INTERNACIONAL,
			   				"TISEEGIN"),
	
   /**
	 * @variable PAGO_GIRO_INTERNACIONAL
	 * 			 Constante que representa el tipo de servicio para 
	 * 			 realizar un pago de giro internacional
	 */
	PAGO_GIRO_INTERNACIONAL("pago_giro_internacional", 
			   				EnumTiposOperaciones.PAGO_FACTURACION_GIRO_INTERNACIONAL,
			   				"TISEPGIN"),
			   				
	/**
	 * @variable PAGO_GIRO_INTERNACIONAL
	 * 			 Constante que representa el tipo de servicio para 
	 * 			 realizar un protegiro internacional
	 */
	PROTEGIRO_INTERNACIONAL("protegiro_internacional", 
			   				EnumTiposOperaciones.PROTEGIRO_INTERNACIONAL,
			   				"TISESGIN"),
   /**
	 * @variable SEGURO
	 * 			 Constante que representa el tipo de servicio para
	 * 			 realizar un seguro
	 */
	SEGURO("seguro", 
			EnumTiposOperaciones.ENVIO_FACTURACION_SEGURO,
			"TISEENSG"),
			   
	/**
	 * @variable PAGO_GIRO_EXTERNO
	 * 			 Constante que representa el tipo de servicio para
	 * 		 	 realizar un pago giro externo
	 */
	PAGO_GIRO_EXTERNO("pago_giro_externo", 
					   EnumTiposOperaciones.PAGO_FACTURACION_GIRO_EXTERNO,
					   "TISEPGEX"),
	
	/**
	 * @variable RECAUDO
	 * 			 Constante que representa el tipo de servicio para 
	 * 			 realizar un recaudo
	 */
	RECAUDO("recaudo",
			 true, 
			 EnumTiposOperaciones.ENVIO_FACTURACION_RECAUDO,
			 "TISEENRE"),
	
	/**
	 * @variable PAGO_RECAUDO
	 * 			 Constante que representa el tipo de servicio para 
	 * 			 realizar un pago de recaudo
	 */
	PAGO_RECAUDO("pago_recaudo",
			      true, 
				  EnumTiposOperaciones.PAGO_FACTURACION_RECAUDO,
				  "TISEPGRE"),
	
	/**
	 * @variable ANULACION_GIRO
	 * 			 Constante que representa el tipo de servicio para 
	 * 			 realizar una anulacion de giro
	 */
	ANULACION_GIRO("anulacion_giro",
				  EnumTiposOperaciones.SOLICITUD_ANULACION_GIRO,
				  "TISEANGI"),
				  
	/**
	 * @variable ANULACION_SEGURO
	 * 			 Constante que representa el tipo de servicio para 
	 * 			 realizar una anulacion de seguro
	 */
	ANULACION_SEGURO(	"anulacion_seguro",
				  		EnumTiposOperaciones.SOLICITUD_ANULACION_SEGURO,
				  		"TISEANSG"
				  	),
				  				
	/**
	 * @variable ANULACION_SEGURO_INTERNACIONAL
	 * 			 Constante que representa el tipo de servicio para 
	 * 			 realizar una anulacion de giro internacional
	 */
	ANULACION_SEGURO_INTERNACIONAL(	"anulacion_seguro_internacional",
				  					EnumTiposOperaciones.ANULAR_PROTEGIRO_INTERNACIONAL,
				  					"TISEANSI"
				  				),
	
	;
	
	/**
	 * @variable strClave
	 * 			 Clave que representa al tipo servicio 
	 */
	private final String strCodigo;
	
	/**
	 * @variable strClave
	 * 			 Clave que representa al tipo servicio 
	 */
	private String strClave;
	
	/**
	 * @variable strClaveNueva
	 * 			 Clave alternativa que representa al tipo servicio 
	 */
	private String strClaveNueva;
	
	/**
	 * @variable strIdReglaComision
	 * 			 Identificador que representa la regla de negocio disenada para 
	 * 			 calcular la comision de la venta de un producto
	 */
	private String strIdReglaComision;
	
	/**
	 * @variable booConsideraEquivalenciaTercero
	 * 			 Bandera que permite identificar si el tipo de servicio
	 * 			 debe tener presente una equivalencia con terceros
	 */
	private boolean booConsideraEquivalenciaTercero;
	
	/**
	 * @variable enmTipoOperacion
	 * 			 Identifica el tipo de operacion
	 */
	private final EnumTiposOperaciones enmTipoOperacion;
	
	/**
	 * @variable 	strNombreParametroEmpresaVentaSIMS
	 * 			 	Parametros de sistema en empresa, que simboliza el tipo
	 * 				servicio con el que consolidara una operacion de venta
	 */
	private final String strNombreParametroEmpresaVentaSIMS;
	
	/**
	 * @variable 	strCadenaTipoServiciosImplementados
	 * 			 	Cadena que contiene todos los tipo servicios implementados
	 * 				a manera de expresion regular, para validar algun tipo
	 * 				de existencia 
	 */
	private static String strCadenaTipoServiciosImplementados;
	
	/**
	 * ********************************************************************
	 * @method 	EnumTiposServicios
	 * 		   	Inicializacion de la constante de enumeracion
	 * @param  	pStrCodigo
	 * 		   	Codigo que identifica a la constante de enumeracion
	 * @param  	pEnmTipoOperacion
	 * 		   	Enumerador de Tipo servicio
	 * @param	pStrNombreParametroEmpresaVentaSIMS
	 * 			Parametros de sistema en empresa, que simboliza el tipo
	 * 			servicio con el que consolidara una operacion de venta
	 * @author 	hector.cuenca
	 * @date   	2/03/2016
	 * *********************************************************************
	 */
	private EnumTiposServicios	(	String pStrCodigo,
									EnumTiposOperaciones pEnmTipoOperacion,
									String pStrNombreParametroEmpresaVentaSIMS
								)
	{
		this.strCodigo = pStrCodigo;
		this.enmTipoOperacion = pEnmTipoOperacion;
		this.strNombreParametroEmpresaVentaSIMS	=	pStrNombreParametroEmpresaVentaSIMS;
	}
	
	/**
	 * ********************************************************************
	 * @method 	EnumTiposServicios
	 * 		   	Inicializacion de la constante de enumeracion
	 * @param  	pStrCodigo
	 * 		   	Codigo que identifica a la constante de enumeracion
	 * @param  	pBooConsideraEquivalenciaTercero
	 * 		   	Bandera que permite identificar si el tipo de servicio debe 
	 * 		   	tener presente una equivalencia con terceros
	 * @param  	pEnmTipoOperacion
	 * 		   	Enumerador de Tipo servicio
	 * @param	pStrNombreParametroEmpresaVentaSIMS
	 * 			Parametros de sistema en empresa, que simboliza el tipo
	 * 			servicio con el que consolidara una operacion de venta
	 * @author 	hector.cuenca
	 * @date 	2/03/2016
	 * *********************************************************************
	 */
	private EnumTiposServicios	(	String pStrCodigo,
									boolean pBooConsideraEquivalenciaTercero,
									EnumTiposOperaciones pEnmTipoOperacion,
									String pStrNombreParametroEmpresaVentaSIMS
								)
	{
		this.strCodigo = pStrCodigo;
		this.setBooConsideraEquivalenciaTercero(pBooConsideraEquivalenciaTercero);
		this.enmTipoOperacion = pEnmTipoOperacion;
		this.strNombreParametroEmpresaVentaSIMS	=	pStrNombreParametroEmpresaVentaSIMS;
	}

	/**
	 * @method getStrCodigo
	 * 		   Metodo get del atributo strCodigo
	 * @return String
	 *		   Valor del atributo strCodigo devuelto
	 * @author hector.cuenca
	 * @date 2/03/2016
	 */
	public String getStrCodigo() {
		return this.strCodigo;
	}

	/**
	 * @method getStrClave
	 * 		   Metodo get del atributo strClave
	 * @return String
	 *		   Valor del atributo strClave devuelto
	 * @author hector.cuenca
	 * @date   12/08/2016
	 */
	public String getStrClave() {
		
		if(this.strClave == null){
			
			try{
				
				this.strClave	=	EnumRecursosProperties.TIPOS_SERVICIOS.getRsbRecurso().getString(this.getStrCodigo());
				
			}catch(Exception e){
			
				e.printStackTrace();
			}
		}
		
		return this.strClave;
	}

	/**
	 * @method setStrClave
	 * 		   Metodo set del atributo strClave
	 * @param  pStrClave
	 *		   Valor que tomara el atributo strClave
	 * @author hector.cuenca
	 * @date   12/08/2016
	 */
	public void setStrClave(String pStrClave) {
		this.strClave = pStrClave;
	}

	/**
	 * @method isBooConsideraEquivalenciaTercero
	 * 		   Metodo get del atributo booConsideraEquivalenciaTercero
	 * @return boolean
	 *		   Valor del atributo booConsideraEquivalenciaTercero devuelto
	 * @author hector.cuenca
	 * @date   12/08/2016
	 */
	public boolean isBooConsideraEquivalenciaTercero() {
		return booConsideraEquivalenciaTercero;
	}

	/**
	 * @method setBooConsideraEquivalenciaTercero
	 * 		   Metodo set del atributo booConsideraEquivalenciaTercero
	 * @param  pBooConsideraEquivalenciaTercero
	 *		   Valor que tomara el atributo booConsideraEquivalenciaTercero
	 * @author hector.cuenca
	 * @date   12/08/2016
	 */
	public void setBooConsideraEquivalenciaTercero(
			boolean pBooConsideraEquivalenciaTercero) {
		this.booConsideraEquivalenciaTercero = pBooConsideraEquivalenciaTercero;
	}

	/**
	 * @method getStrIdReglaComision
	 * 		   Metodo get del atributo strIdReglaComision
	 * @return String
	 *		   Valor del atributo strIdReglaComision devuelto
	 * @author hector.cuenca
	 * @date   19/08/2016
	 */
	public String getStrIdReglaComision() {
		
		if	(	this.strIdReglaComision == null){
		
			try{
				
				this.strIdReglaComision	=	EnumRecursosProperties.REGLAS_COMISION_X_TIPO_SERVICIO.getRsbRecurso().getString(this.getStrCodigo());
				
			}catch(Exception e){
			
				e.printStackTrace();
			}
		}
		
		return this.strIdReglaComision;
	}

	/**
	 * @method setStrIdReglaComision
	 * 		   Metodo set del atributo strIdReglaComision
	 * @param  pStrIdReglaComision
	 *		   Valor que tomara el atributo strIdReglaComision
	 * @author hector.cuenca
	 * @date   19/08/2016
	 */
	public void setStrIdReglaComision(String pStrIdReglaComision) {
		this.strIdReglaComision = pStrIdReglaComision;
	}

	/**
	 * @method getEnmTipoOperacion
	 * 		   Metodo get del atributo enmTipoOperacion
	 * @return EnumTiposOperaciones
	 *		   Valor del atributo enmTipoOperacion devuelto
	 * @author roberth.martinez
	 * @date   11/4/2017
	 */
	public EnumTiposOperaciones getEnmTipoOperacion() {
		return enmTipoOperacion;
	}
	
	/**
	 * @method getStrNombreParametroEmpresaVentaSIMS
	 * 		   Metodo get del atributo strNombreParametroEmpresaVentaSIMS
	 * @return String
	 *		   Valor del atributo strNombreParametroEmpresaVentaSIMS devuelto
	 * @author hector.cuenca
	 * @date   8/05/2017
	 */
	public String getStrNombreParametroEmpresaVentaSIMS() {
		return strNombreParametroEmpresaVentaSIMS;
	}

	/**
	 * @method getStrClaveNueva
	 * 		   Metodo get del atributo strClaveNueva
	 * @return String
	 *		   Valor del atributo strClaveNueva devuelto
	 * @author hector.cuenca
	 * @date   8/05/2017
	 */
	public String getStrClaveNueva() 
	{
		if	(	this.strClaveNueva	==	null	)
		{
			this.strClaveNueva	=	this.getStrClave();
		}
		return strClaveNueva;
	}

	/**
	 * @method setStrClaveNueva
	 * 		   Metodo set del atributo strClaveNueva
	 * @param  pStrClaveNueva
	 *		   Valor que tomara el atributo strClaveNueva
	 * @author hector.cuenca
	 * @date   8/05/2017
	 */
	public void setStrClaveNueva(String pStrClaveNueva) {
		this.strClaveNueva = pStrClaveNueva;
	}

	/** 
	 * ********************************************************************
	 * @method 	obtenerCadenaServiciosImplementados
	 * 		   	Metodo que permite generar la cadena de los servicios 
	 * 			implementados a nivel del PosSlimGiros a modo ideal de 
	 * 			expresion regular
	 * @return	String
	 * 			Cadena de servicios implementados en el PosSlimGiros
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	6/05/2017
	 * *********************************************************************
	 */
	public static String obtenerCadenaServiciosImplementados	()
			throws Exception
	{
		if	(	EnumTiposServicios.strCadenaTipoServiciosImplementados	==	null	)	
		{
			EnumTiposServicios.strCadenaTipoServiciosImplementados	=	EnumExpresionesRegulares.GNR_ABRE_PARENTESIS.getValor();
			
			for	(	EnumTiposServicios enmTipoServicioImplementado	:	EnumTiposServicios.values()	)
			{
				EnumTiposServicios.strCadenaTipoServiciosImplementados	+=	enmTipoServicioImplementado.getStrClave()+EnumExpresionesRegulares.GNR_O_LOGICO.getValor();
			}
			
			EnumTiposServicios.strCadenaTipoServiciosImplementados	=	EnumTiposServicios.strCadenaTipoServiciosImplementados.replaceAll	(		EnumExpresionesRegulares.GNR_ESCAPE.getValor()
																																				+	EnumExpresionesRegulares.GNR_O_LOGICO.getValor()
																																				+	EnumExpresionesRegulares.GNR_FIN.getValor()
																																				, ""
																																			);
			EnumTiposServicios.strCadenaTipoServiciosImplementados	+=	EnumExpresionesRegulares.GNR_CIERRA_PARENTESIS.getValor();
		}
		return EnumTiposServicios.strCadenaTipoServiciosImplementados;
	}
}

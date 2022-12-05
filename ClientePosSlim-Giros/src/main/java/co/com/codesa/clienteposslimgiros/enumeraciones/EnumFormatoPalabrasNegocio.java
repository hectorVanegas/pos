package co.com.codesa.clienteposslimgiros.enumeraciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 23-dic-2015
 * @Clase EnumFormatoPalabrasNegocio 
 * 		  Clase enumerador, que permite administrar de forma diciente
 * 		  las palabras claves del negocio, con la intencion inicial de 
 * 		  formatear (uso de mayusculas/minusculas), en cuanto a su 
 * 		  presentacion en etiquetas y/o mensajes sobre el sistema.
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public enum EnumFormatoPalabrasNegocio {
	
	//General
	NOMBRE_PROVEEDOR_SUPER_GIROS	(	//EnumExpresionesRegulares.PAL_NEG_NOMBRE_PROVEEDOR_SUPER_GIROS,
										"SuperGIROS",
								 		EnumEtiquetas.PAL_NEG_NOMBRE_PROVEEDOR_SUPER_GIROS
								 	),
								 	
 	SOCIEDAD_ANONIMA	(	//EnumExpresionesRegulares.PAL_NEG_NOMBRE_PROVEEDOR_SUPER_GIROS,
 							"S\\.A\\.",
 							EnumEtiquetas.PAL_NEG_SOCIEDAD_ANONIMA
 						),
	
	//Abreviatura Tipos Documento
	ABREVIATURA_TIPO_DOC_CC	(	//EnumExpresionesRegulares.PAL_NEG_ABREVIATURA_TIPO_DOC_CC,
								"CC",
								EnumEtiquetas.PAL_NEG_ABREVIATURA_TIPO_DOC_CC
							),
	
	ABREVIATURA_TIPO_DOC_TI	(	//EnumExpresionesRegulares.PAL_NEG_ABREVIATURA_TIPO_DOC_TI,
								"TI",
								EnumEtiquetas.PAL_NEG_ABREVIATURA_TIPO_DOC_TI
							),
							
	ABREVIATURA_TIPO_DOC_PA	(	//EnumExpresionesRegulares.PAL_NEG_ABREVIATURA_TIPO_DOC_PA,
								"PA",
								EnumEtiquetas.PAL_NEG_ABREVIATURA_TIPO_DOC_PA
							),
							
	ABREVIATURA_TIPO_DOC_CE	(	//EnumExpresionesRegulares.PAL_NEG_ABREVIATURA_TIPO_DOC_CE,
								"CE",
								EnumEtiquetas.PAL_NEG_ABREVIATURA_TIPO_DOC_CE
							),
							
	ABREVIATURA_TIPO_DOC_CEX(	//EnumExpresionesRegulares.PAL_NEG_ABREVIATURA_TIPO_DOC_CEX,
								"CEX",
							 	EnumEtiquetas.PAL_NEG_ABREVIATURA_TIPO_DOC_CEX
							),
							 
	ABREVIATURA_TIPO_DOC_NIT(	//EnumExpresionesRegulares.PAL_NEG_ABREVIATURA_TIPO_DOC_NIT,
								"NIT",
							 	EnumEtiquetas.PAL_NEG_ABREVIATURA_TIPO_DOC_NIT
							),
	
	/*
	ABREVIATURA_TIPO_DOC_CC_SEGUIDO_DOC(EnumExpresionesRegulares.PAL_NEG_ABREVIATURA_TIPO_DOC_CC_SEGUIDO_DOC,
										EnumEtiquetas.PAL_NEG_ABREVIATURA_TIPO_DOC_CC_SEGUIDO_DOC),
										
	ABREVIATURA_TIPO_DOC_TI_SEGUIDO_DOC(EnumExpresionesRegulares.PAL_NEG_ABREVIATURA_TIPO_DOC_TI_SEGUIDO_DOC,
										EnumEtiquetas.PAL_NEG_ABREVIATURA_TIPO_DOC_TI_SEGUIDO_DOC),
										
	ABREVIATURA_TIPO_DOC_PA_SEGUIDO_DOC(EnumExpresionesRegulares.PAL_NEG_ABREVIATURA_TIPO_DOC_PA_SEGUIDO_DOC,
										EnumEtiquetas.PAL_NEG_ABREVIATURA_TIPO_DOC_PA_SEGUIDO_DOC),
										
	ABREVIATURA_TIPO_DOC_CE_SEGUIDO_DOC(EnumExpresionesRegulares.PAL_NEG_ABREVIATURA_TIPO_DOC_CE_SEGUIDO_DOC,
										EnumEtiquetas.PAL_NEG_ABREVIATURA_TIPO_DOC_CE_SEGUIDO_DOC),
										
	ABREVIATURA_TIPO_DOC_CEX_SEGUIDO_DOC(EnumExpresionesRegulares.PAL_NEG_ABREVIATURA_TIPO_DOC_CEX_SEGUIDO_DOC,
										 EnumEtiquetas.PAL_NEG_ABREVIATURA_TIPO_DOC_CEX_SEGUIDO_DOC),
										 
	ABREVIATURA_TIPO_DOC_NIT_SEGUIDO_DOC(EnumExpresionesRegulares.PAL_NEG_ABREVIATURA_TIPO_DOC_NIT_SEGUIDO_DOC,
										 EnumEtiquetas.PAL_NEG_ABREVIATURA_TIPO_DOC_NIT_SEGUIDO_DOC),
	*/
	
	//Productos
	//SuperCOMBO
	NOMBRE_PRODUCTO_SUPER_COMBO	(	//EnumExpresionesRegulares.PAL_NEG_NOMBRE_PRODUCTO_SUPER_COMBO,
									"SuperCOMBO",
									EnumEtiquetas.PAL_NEG_NOMBRE_PROTEGIRO
								),
								
	NOMBRE_PROTEGIRO(	"PROTEGIRO",
						EnumEtiquetas.PAL_NEG_NOMBRE_PROTEGIRO
					),
								
	NOMBRE_SMS	(	"SMS",
					EnumEtiquetas.PAL_NEG_NOMBRE_SMS
				),
				
	REFERENCIA	(	"PIN",
					EnumEtiquetas.PAL_NEG_REFERENCIA
				),
	;
	
	/**
	 * @variable enmExpresionBusqueda 
	 * 			 Constante de enumeracion que permite identificar la expresion
	 * 			 de busqueda que se buscara sobre una determinada cadena
	 **/
	//private final EnumExpresionesRegulares enmExpresionBusqueda;
	
	/**
	 * @variable enmEtiquetaReemplazo 
	 * 			 Constante de enumeracion que permite identificar la etiqueta
	 * 			 de reemplazo que se ejecutara sobre las expresiones encontradas
	 **/
	private final EnumEtiquetas enmEtiquetaReemplazo;
	
	/**
	 * @variable	strPalabraNegocio 
	 * 			 	Representa la palabra de negocio de interes a estandarizar
	 * 				no importa si se coloca en mayuscula, minuscula o combinada, 
	 * 				a partir de esto se genera la expresion regular de busqueda
	 * 				que involucra todas las combinaciones posibles entre mayusculas
	 * 				y minusculas
	 **/
	private final String strPalabraNegocio;
	
	/**
	 * @variable	strExpRegBusqueda
	 * 			 	Expresion regular generada para realizar la busqueda de la
	 * 				palabra de negocio sobre el mensaje
	 */
	private	String strExpRegBusqueda;
	
	/**
	 * @variable 	strExpRegReemplaza
	 * 			 	Expresion regular generada para realizar el replaceAll, sobre
	 * 				el resultado de la busqueda de la palabra de negocio detectada
	 * 				en el mensaje
	 */
	private	String	strExpRegReemplaza;
	
	/**
	 * ********************************************************************
	 * @method 	EnumFormatoPalabrasNegocio
	 * 		   	Inicializacion de la constante de enumeracion configurada
	 * @param	pEnmExpresionBusqueda
	 * 			Constante de enumeracion que permite identificar la 
  	 * 		  	expresion de busqueda que se buscara sobre una determinada 
  	 * 		  	cadena
	 * @param 	pStrPalabraNegocio
	 * 			Representa la palabra de negocio de interes a 
	 * 			estandarizar
	 * @param 	pEnmEtiquetaReemplazo
	 * 			Constante de enumeracion que permite identificar la 
  	 * 		  	etiqueta de reemplazo que se ejecutara sobre las expresiones 
  	 * 		  	encontradas
	 * @author 	hector.cuenca
	 * @date   	13/01/2017
	 * *********************************************************************
	 */
	private	EnumFormatoPalabrasNegocio	(	//EnumExpresionesRegulares 	pEnmExpresionBusqueda,
											String						pStrPalabraNegocio,
											EnumEtiquetas 				pEnmEtiquetaReemplazo
										)
	{
		//this.enmExpresionBusqueda	= 	pEnmExpresionBusqueda;
		this.strPalabraNegocio		=	pStrPalabraNegocio;
		this.enmEtiquetaReemplazo	=	pEnmEtiquetaReemplazo;
	}

	/**
  	 * ****************************************************************.
  	 * @metodo formatearPalabraClaves
  	 * 		   Metodo que permite procesar una cadena de entrada, texto
  	 * 		   etiqueta, mensaje, etc, detectando la palabra clave de 
  	 * 		   negocio y formateandola por la etiqueta prevista para su 
  	 * 		   reemplazo 
  	 * @param pStrCadena
  	 * 		  Cadena sobre la cual se ejecutara el proceso de formatear
  	 * 		  las palabras claves del negocio
  	 * @return String
  	 * 		   Cadena procesada, con las palabras de negocio formateadas 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 		  
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public	String	formatearPalabraClaves	(	String	pStrCadena	)
			throws Exception
	{
		Pattern patPattern;
		Matcher matMatcher;
		String 	strExpRegBusqueda;
		String 	strExpRegReemplaza;
		String	strEtiquetaReemplazo;
		String 	strPalabraNegocio;
		int		intImpactarPos;
		
		strExpRegBusqueda		=	this.getStrExpRegBusqueda();
		strExpRegReemplaza		=	this.getStrExpRegReemplaza();
		strEtiquetaReemplazo	=	this.getEnmEtiquetaReemplazo().toString();
		strPalabraNegocio		=	this.getStrPalabraNegocio();
		intImpactarPos			=	0;
		
		patPattern	=	Pattern.compile(strExpRegBusqueda);
	    matMatcher	= 	patPattern.matcher(pStrCadena);
	    
	    while	(	matMatcher.find()	) 
	    {
	    	pStrCadena	=		pStrCadena.substring(	0,	matMatcher.start()+intImpactarPos	)			+
	    						matMatcher.group().replaceAll(strExpRegReemplaza, strEtiquetaReemplazo)		+
	    						pStrCadena.substring(	matMatcher.end()+intImpactarPos	)
	    				;
	    	
	    	intImpactarPos	+=	strEtiquetaReemplazo.length()-strPalabraNegocio.length();
	    }
		/*
		pStrCadena = pStrCadena.replaceAll(this.enmExpresionBusqueda.getValor(), 
										   this.enmEtiquetaReemplazo.toString());
		*/
		return pStrCadena;
	}

	/**
	 * @method getEnmExpresionBusqueda
	 * 		   Metodo get del atributo enmExpresionBusqueda
	 * @return EnumExpresionesRegulares
	 *		   Valor del atributo enmExpresionBusqueda devuelto
	 * @author hector.cuenca
	 * @date   13/01/2017
	 */
	/*public EnumExpresionesRegulares getEnmExpresionBusqueda() {
		return this.enmExpresionBusqueda;
	}*/

	/**
	 * @method getEnmEtiquetaReemplazo
	 * 		   Metodo get del atributo enmEtiquetaReemplazo
	 * @return EnumEtiquetas
	 *		   Valor del atributo enmEtiquetaReemplazo devuelto
	 * @author hector.cuenca
	 * @date   13/01/2017
	 */
	public EnumEtiquetas getEnmEtiquetaReemplazo() {
		return this.enmEtiquetaReemplazo;
	}

	/**
	 * @method getStrPalabraNegocio
	 * 		   Metodo get del atributo strPalabraNegocio
	 * @return String
	 *		   Valor del atributo strPalabraNegocio devuelto
	 * @author hector.cuenca
	 * @date   13/01/2017
	 */
	public String getStrPalabraNegocio() {
		return strPalabraNegocio;
	}

	/**
	 * @method getStrExpRegBusqueda
	 * 		   Metodo get del atributo strExpRegBusqueda
	 * @return String
	 *		   Valor del atributo strExpRegBusqueda devuelto
	 * @throws	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
	 * 			presentada 
	 * @author hector.cuenca
	 * @date   13/01/2017
	 */
	public	String	getStrExpRegBusqueda() 
			throws	Exception
	{
		String strExpRegReemplaza;
		
		if	(	(strExpRegReemplaza	=	this.getStrExpRegReemplaza())	==	null	)
		{
			this.strExpRegBusqueda	=	null;
			
		}	else	{
			
			if	(	this.strExpRegBusqueda	==	null)
			{
				this.strExpRegBusqueda	=	EnumExpresionesRegulares.PAL_NEG_INICIO.getValor()	+	
											strExpRegReemplaza									+	
											EnumExpresionesRegulares.PAL_NEG_FIN.getValor()
										;
			}
		}
		
		return this.strExpRegBusqueda;
	}

	/**
	 * @method setExpStrRegBusqueda
	 * 		   Metodo set del atributo strExpRegBusqueda
	 * @param  pStrExpRegBusqueda
	 *		   Valor que tomara el atributo strExpRegBusqueda
	 * @author hector.cuenca
	 * @date   13/01/2017
	 */
	public void setStrExpRegBusqueda(String pStrExpRegBusqueda) {
		this.strExpRegBusqueda = pStrExpRegBusqueda;
	}

	/**
	 * @method getStrExpRegReemplaza
	 * 		   Metodo get del atributo strExpRegReemplaza
	 * @return String
	 *		   Valor del atributo strExpRegReemplaza devuelto
	 * @throws	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
	 * 			presentada
	 * @author hector.cuenca
	 * @date   13/01/2017
	 */
	public String getStrExpRegReemplaza() throws Exception{
		
		EnumExpresionesRegulares	enmExpRegVocalTilde;
		String 						strLetra;
		
		if	(	this.strExpRegReemplaza	==	null	)
		{
			this.strExpRegReemplaza	=	"";
			
			for	(	char	chrCaracter	:	this.getStrPalabraNegocio().toCharArray()	)
			{
				if	(	Character.isLetter(chrCaracter)	)
				{
					strLetra	=	String.valueOf(chrCaracter);
					this.strExpRegReemplaza	+=	"("+	strLetra.toUpperCase()	+	
												"|"+	strLetra.toLowerCase()	
												;
					
					switch	(	Character.toUpperCase(chrCaracter)	) 
					{
						case 'A':
							enmExpRegVocalTilde	=	EnumExpresionesRegulares.GNR_A_TILDE;
							break;
							
						case 'E':
							enmExpRegVocalTilde	=	EnumExpresionesRegulares.GNR_E_TILDE;
							break;
							
						case 'I':
							enmExpRegVocalTilde	=	EnumExpresionesRegulares.GNR_I_TILDE;
							break;
							
						case 'O':
							enmExpRegVocalTilde	=	EnumExpresionesRegulares.GNR_O_TILDE;
							break;
							
						case 'U':
							enmExpRegVocalTilde	=	EnumExpresionesRegulares.GNR_U_TILDE;
							break;
							
						default:
							enmExpRegVocalTilde	=	null;
							break;
					}
					
					if	(	enmExpRegVocalTilde	!=	null	)
					{
						this.strExpRegReemplaza	+=	"|"+enmExpRegVocalTilde.getValor();
					}
					
					this.strExpRegReemplaza	+=	")";
					
				}	else	{
					
					this.strExpRegReemplaza	+=	chrCaracter;
				}
			}
			
			if	(	this.strExpRegReemplaza.isEmpty()	)
			{
				this.strExpRegReemplaza	=	null;
			}
		}
		
		return this.strExpRegReemplaza;
	}

	/**
	 * @method setStrExpRegReemplaza
	 * 		   Metodo set del atributo strExpRegReemplaza
	 * @param  pStrExpRegReemplaza
	 *		   Valor que tomara el atributo strExpRegReemplaza
	 * @author hector.cuenca
	 * @date   13/01/2017
	 */
	public void setStrExpRegReemplaza(String pStrExpRegReemplaza) {
		this.strExpRegReemplaza = pStrExpRegReemplaza;
	}
}

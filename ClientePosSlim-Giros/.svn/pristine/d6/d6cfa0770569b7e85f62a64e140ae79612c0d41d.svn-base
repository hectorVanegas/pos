package co.com.codesa.clienteposslimgiros.enumeraciones.biometria;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumRecursosProperties;

/**
 * ********************************************************************
 * @class	EnumTipoOperacionesISO
 *		  	Clase enumerador, que permite administrar de forma diciente 
 * 		  	los tipos de operaciones implementados para la ISO
 * @author 	hector.cuenca
 * @date 	28/08/2017
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public enum EnumTipoOperacionesISO 
{
	/**
	 * @variable 	EMITIR
	 * 			 	Constante que identifica el tipo de operacion ISO para 
	 * 				emitir una huella
	 */
	EMITIR	(	"emitir"	),
	
	/**
	 * @variable 	DESCARGAR
	 * 			 	Constante que identifica el tipo de operacion ISO para 
	 * 				descargar una huella
	 */
	DESCARGAR	(	"descargar"	),
	
	;
	
	/**
	 * @variable strCodigo
	 * 			 Codigo que identifica a la constante de enumeracion 
	 */
	private final String strCodigo;
	
	/**
	 * @variable strValorPropiedad
	 * 			 Valor de la propiedad alojada del lado del recurso .properties sincronizado
	 * 			 con el Enum
	 */
	private String strValorPropiedad;
	
	/**
	 * ********************************************************************
	 * @method EnumTiposBiometriaCaja
	 * 		   Inicializacion de la constante de enumeracion
	 * @param pStrCodigo
	 * 		  Codigo que identifica a la constante de enumeracion
	 * @author hector.cuenca
	 * @date 2/03/2016
	 * *********************************************************************
	 */
	private EnumTipoOperacionesISO(String pStrCodigo){
		
		this.strCodigo = pStrCodigo;
	}
	
	/**
	 * ********************************************************************
	 * @method cargar
	 * 		   Metodo encargado de cargar el valor de la propiedad alojada
	 * 		   del lado del recurso .properties sincronizado con el Enum
	 * @author hector.cuenca
	 * @date 2/03/2016
	 * *********************************************************************
	 */
	private void cargar(){
		
		try{
			
			this.strValorPropiedad = EnumRecursosProperties.TIPOS_OPERACIONES_ISO.getRsbRecurso().getString(this.getStrCodigo());
			
		}catch(Exception e){
		
			e.printStackTrace();
			this.setStrValorPropiedad(this.getStrCodigo());
		}
	}
	
	/**
	 * @method getStrValorPropiedad
	 * 		   Metodo get del atributo strValorPropiedad
	 * @return String
	 *		   Valor del atributo strValorPropiedad devuelto
	 * @author hector.cuenca
	 * @date 2/03/2016
	 */
	public String getStrValorPropiedad() {
		
		if(this.strValorPropiedad == null){
			
			this.cargar();
		}
		
		return this.strValorPropiedad;
	}

	/**
	 * @method setStrValorPropiedad
	 * 		   Metodo set del atributo strValorPropiedad
	 * @param pStrValorPropiedad
	 *		   Valor que tomara el atributo strValorPropiedad
	 * @author hector.cuenca
	 * @date 2/03/2016
	 */
	public void setStrValorPropiedad(String pStrValorPropiedad) {
		this.strValorPropiedad = pStrValorPropiedad;
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
}

package co.com.codesa.clienteposslimgiros.enumeraciones.biometria;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumRecursosProperties;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;

/**
 * ********************************************************************
 * @class	EnumTiposBiometriaCaja
 *		  	Clase enumerador, que permite administrar de forma diciente 
 * 		  	los tipos de biometria que puede presentar la caja
 * @author 	hector.cuenca
 * @date 	28/08/2017
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public enum EnumTiposBiometriaCaja 
{
	/**
	 * @variable CENTRAL
	 * 			 Constante que identifica el tipo de biometria central
	 */
	CENTRAL	(	"central",
	        	EnumEtiquetas.TIP_BIO_CAJ_CENTRAL
	        ),
	
    /**
	 * @variable LOCAL
	 * 			 Constante que identifica el tipo de biometria local
	 */
	LOCAL	(	"local",
	     	 	EnumEtiquetas.TIP_BIO_CAJ_LOCAL
			),
			
	/**
	 * @variable LOCAL
	 * 			 Constante que identifica el tipo de biometria local
	 */
	MULTISERVICIO	(	"multiservicio",
			     	 	EnumEtiquetas.TIP_BIO_CAJ_MULTISERVICIO
					),
	
	;
	
	/**
	 * @variable enmEtiDescripcion
	 * 			 Descripcion del tipo de transaccion
	 */
	private final EnumEtiquetas enmEtiDescripcion;
	
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
	 * @param pEnmEtiDescripcion
	 * 		  Descripcion del tipo de transaccion
	 * @author hector.cuenca
	 * @date 2/03/2016
	 * *********************************************************************
	 */
	private EnumTiposBiometriaCaja(String pStrCodigo,
								 EnumEtiquetas pEnmEtiDescripcion){
		
		this.strCodigo = pStrCodigo;
		this.enmEtiDescripcion = pEnmEtiDescripcion;
	}

	@Override
	public String toString() {
		
		String strResultado;
		
		try{
			
			strResultado = this.getEnmEtiDescripcion().toString();
			
		}catch(Exception e){
			
			UtilidadesGiros.getInstance().controlExcepcion(e, 
														   null);
			strResultado = this.name();
		}
		
		return strResultado;
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
			
			this.strValorPropiedad = EnumRecursosProperties.TIPOS_BIOMETRIA_CAJA.getRsbRecurso().getString(this.getStrCodigo());
			
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

	/**
	 * @method getEnmEtiDescripcion
	 * 		   Metodo get del atributo enmEtiDescripcion
	 * @return EnumEtiquetas
	 *		   Valor del atributo enmEtiDescripcion devuelto
	 * @author hector.cuenca
	 * @date 2/03/2016
	 */
	public EnumEtiquetas getEnmEtiDescripcion() {
		return this.enmEtiDescripcion;
	}
}

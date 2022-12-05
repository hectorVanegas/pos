package co.com.codesa.clienteposslimgiros.dto.cifrado.tiposCifrado.cifradoXBloques.AES;

import javax.crypto.spec.IvParameterSpec;

import org.apache.commons.codec.binary.Hex;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.interfaces.cifrado.ConfiguracionCifrado;
import co.com.codesa.clienteposslimgiros.utilidades.cifrado.tiposCifrado.TiposCifrado;
import co.com.codesa.clienteposslimgiros.utilidades.cifrado.tiposCifrado.cifradoXBloques.AES.CifradoXBloquesAES;

/** 
 * ********************************************************************
 * @class  ConfigCifradoXBloquesAESDTO
 *		   Clase DTO encargada de almacenar toda la informacion de 
 *		   configuracion relacionada con el proceso de cifrado por 
 *		   bloques AES (por sus siglas en ingles Advanced Encryption 
 *		   Standard)
 * @author hector.cuenca
 * @date   3/03/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class ConfigCifradoXBloquesAESDTO implements ConfiguracionCifrado{

	/**
	 * @variable CANT_CARACTERES_LLAVE
	 * 			 Cantidad de caracteres que debe tener la llave de cifrado
	 */
	private static final int CANT_CARACTERES_LLAVE;
	
	/**
	 * @variable ALGORITMO
	 * 			 Cadena que representa el algoritmo de cifrado AES utilizado
	 */
	private static final String ALGORITMO;
	
	/**
	 * @variable NOMBRE_ALGORITMO
	 * 			 Nombre del algoritmo de cifrado
	 */
	private static final String NOMBRE_ALGORITMO;
	
	/**
	 * @variable objUtlCifradoXBloquesAES
	 * 			 Objeto que referencia la utilidad para procesar el cifrado
	 * 		  	 por bloques AES
	 */
	private CifradoXBloquesAES objUtlCifradoXBloquesAES;
	
	/**
	 * @variable enmParAppLLave
	 * 			 Constante de enumeracion que referencia una parametro de 
	 * 		 	 aplicacion, el cual almacenara el valor de la llave
	 */
	private EnumParametrosApp enmParAppLLave;
	
	/**
	 * @variable enmParSisLLave
	 * 			 Constante de enumeracion que referencia un parametro de 
	 * 		 	 sistema, el cual almacenara el valor de la llave
	 */
	private EnumParametrosSistema enmParSisLLave;

	/**
	 * @variable arrBytLLave
	 * 			 Array de bytes que representa el valor de la llave de cifrado
	 * 			 recuperada bien sea a partir de un parametro de aplicacion
	 * 			 o de un parametro de sistema 
	 */
	private byte[] arrBytLLave;
	
	/**
	 * @variable strCadenaProteccionModificacion
	 * 			 Cadena de proteccion contra la modificacion posterior
	 */
	private String strCadenaProteccionModificacion;
	
	/**
	 * @variable ivInicializacionVector
	 * 			 Vector de inicializacion para el proceso de cifrado
	 */
	private IvParameterSpec ivInicializacionVector;
	
	static{
    	
		ALGORITMO = "AES/CBC/PKCS5Padding";
    	NOMBRE_ALGORITMO = "AES";
    	CANT_CARACTERES_LLAVE = 16;
    }
	
	/** 
	 * ********************************************************************
	 * @method ConfigCifradoXBloquesAESDTO
	 * 		   Metodo constructor que permite la inicializacion de los 
	 * 		   valores y comportamientos necesarios para la construccion de
	 * 		   este objeto, recibe la llave como un parametro de aplicacion
	 * @param  pEnmParAppLLave
	 * 		   Constante de enumeracion que referencia una parametro de 
	 * 		   aplicacion, el cual almacenara el valor de la llave
	 * @param  pStrCadenaProteccionModificacion
	 * 		   Cadena de proteccion contra la modificacion posterior
	 * @author hector.cuenca
	 * @date   3/03/2016
	 * *********************************************************************
	 */
	public ConfigCifradoXBloquesAESDTO(EnumParametrosApp pEnmParAppLLave,
									   String pStrCadenaProteccionModificacion) {
		
		super();
		
		this.setEnmParAppLLave(pEnmParAppLLave);
		this.setStrCadenaProteccionModificacion(pStrCadenaProteccionModificacion);
	}
	
	/** 
	 * ********************************************************************
	 * @method ConfigCifradoXBloquesAESDTO
	 * 		   Metodo constructor que permite la inicializacion de los 
	 * 		   valores y comportamientos necesarios para la construccion de
	 * 		   este objeto, recibe la llave como un parametro de sistema
	 * @param  pEnmParSisLLave
	 * 		   Constante de enumeracion que referencia un parametro de 
	 * 		   sistema, el cual almacenara el valor de la llave
	 * @param  pStrCadenaProteccionModificacion
	 * 		   Cadena de proteccion contra la modificacion posterior
	 * @author hector.cuenca
	 * @date   3/03/2016
	 * *********************************************************************
	 */
	public ConfigCifradoXBloquesAESDTO(EnumParametrosSistema pEnmParSisLLave,
									   String pStrCadenaProteccionModificacion) {
		
		super();
		
		this.setEnmParSisLLave(pEnmParSisLLave);
		this.setStrCadenaProteccionModificacion(pStrCadenaProteccionModificacion);
	}
	
	@Override
	public TiposCifrado obtenerAlgoritmo()throws Exception{
		
		return this.getObjUtlCifradoXBloquesAES();
	}
	
	/** 
	 * ********************************************************************
	 * @method calcularLLave
	 * 		   Metodo encargado de obtener la llave a partir ya sea de un 
	 * 		   parametro de sistema o de un parametro de aplicacion
	 * @return byte[]
	 * 		   LLave de cifrado calculada
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   3/03/2016
	 * *********************************************************************
	 */
	private byte[] calcularLLave()throws Exception{
		
		String strLLave;
		byte[] arrByteRespuesta;
		
		if(this.getEnmParSisLLave() == null){
			
			if(this.getEnmParAppLLave() == null){
				
				strLLave = null;
				
			}else{
				
				strLLave = this.getEnmParAppLLave().getValorPropiedad();
			}
			
		}else{
			
			strLLave = this.getEnmParSisLLave().obtenerValorCadena();
		}
		
		if(strLLave == null){
			
			arrByteRespuesta = null;
			
		}else{
			
			arrByteRespuesta = strLLave.getBytes();
		}
		
		return arrByteRespuesta;
	}
	
	/**
	 * @method getEnmParAppLLave
	 * 		   Metodo get del atributo enmParAppLLave
	 * @return EnumParametrosApp
	 *		   Valor del atributo enmParAppLLave devuelto
	 * @author hector.cuenca
	 * @date   3/03/2016
	 */
	public EnumParametrosApp getEnmParAppLLave() {
		return enmParAppLLave;
	}

	/**
	 * @method setEnmParAppLLave
	 * 		   Metodo set del atributo enmParAppLLave
	 * @param  pEnmParAppLLave
	 *		   Valor que tomara el atributo enmParAppLLave
	 * @author hector.cuenca
	 * @date   3/03/2016
	 */
	public void setEnmParAppLLave(EnumParametrosApp pEnmParAppLLave) {
		this.enmParAppLLave = pEnmParAppLLave;
	}

	/**
	 * @method getEnmParSisLLave
	 * 		   Metodo get del atributo enmParSisLLave
	 * @return EnumParametrosSistema
	 *		   Valor del atributo enmParSisLLave devuelto
	 * @author hector.cuenca
	 * @date   3/03/2016
	 */
	public EnumParametrosSistema getEnmParSisLLave() {
		return enmParSisLLave;
	}

	/**
	 * @method setEnmParSisLLave
	 * 		   Metodo set del atributo enmParSisLLave
	 * @param  pEnmParSisLLave
	 *		   Valor que tomara el atributo enmParSisLLave
	 * @author hector.cuenca
	 * @date   3/03/2016
	 */
	public void setEnmParSisLLave(EnumParametrosSistema pEnmParSisLLave) {
		this.enmParSisLLave = pEnmParSisLLave;
	}

	/**
	 * @method getStrCadenaProteccionModificacion
	 * 		   Metodo get del atributo strCadenaProteccionModificacion
	 * @return String
	 *		   Valor del atributo strCadenaProteccionModificacion devuelto
	 * @author hector.cuenca
	 * @date   3/03/2016
	 */
	public String getStrCadenaProteccionModificacion() {
		return strCadenaProteccionModificacion;
	}

	/**
	 * @method setStrCadenaProteccionModificacion
	 * 		   Metodo set del atributo strCadenaProteccionModificacion
	 * @param  pStrCadenaProteccionModificacion
	 *		   Valor que tomara el atributo strCadenaProteccionModificacion
	 * @author hector.cuenca
	 * @date   3/03/2016
	 */
	public void setStrCadenaProteccionModificacion(
			String pStrCadenaProteccionModificacion) {
		this.strCadenaProteccionModificacion = pStrCadenaProteccionModificacion;
	}

	/**
	 * @method getArrBytLLave
	 * 		   Metodo get del atributo arrBytLLave
	 * @return byte []
	 *		   Valor del atributo arrBytLLave devuelto
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   3/03/2016
	 */
	public byte[] getArrBytLLave() throws Exception{
		
		if(this.arrBytLLave == null){
			
			this.arrBytLLave = this.calcularLLave();
			
			if(this.arrBytLLave == null 
					|| this.arrBytLLave.length != ConfigCifradoXBloquesAESDTO.CANT_CARACTERES_LLAVE){
				
				throw EnumMensajes.LLAVE_CIFRADO_NO_TIENE_CANT_CARACTERES_REQUERIDA.generarExcepcion(EnumClasesMensaje.ERROR);
			}
		}
		
		return this.arrBytLLave;
	}

	/**
	 * @method setArrBytLLave
	 * 		   Metodo set del atributo arrBytLLave
	 * @param  pArrBytLLave
	 *		   Valor que tomara el atributo arrBytLLave
	 * @author hector.cuenca
	 * @date   3/03/2016
	 */
	public void setArrBytLLave(byte[] pArrBytLLave) {
		this.arrBytLLave = pArrBytLLave;
	}

	/**
	 * @method getIvInicializacionVector
	 * 		   Metodo get del atributo ivInicializacionVector
	 * @return IvParameterSpec
	 *		   Valor del atributo ivInicializacionVector devuelto
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   3/03/2016
	 */
	public IvParameterSpec getIvInicializacionVector() throws Exception{
		
		if(this.ivInicializacionVector == null){
			
			this.ivInicializacionVector = new IvParameterSpec(Hex.decodeHex(this.getStrCadenaProteccionModificacion().toCharArray()));
		}
		
		return this.ivInicializacionVector;
	}

	/**
	 * @method setIvInicializacionVector
	 * 		   Metodo set del atributo ivInicializacionVector
	 * @param  pIvInicializacionVector
	 *		   Valor que tomara el atributo ivInicializacionVector
	 * @author hector.cuenca
	 * @date   3/03/2016
	 */
	public void setIvInicializacionVector(IvParameterSpec pIvInicializacionVector) {
		this.ivInicializacionVector = pIvInicializacionVector;
	}
	
	/**
	 * @method getObjUtlCifradoXBloquesAES
	 * 		   Metodo get del atributo objUtlCifradoXBloquesAES
	 * @return CifradoXBloquesAES
	 *		   Valor del atributo objUtlCifradoXBloquesAES devuelto
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   4/03/2016
	 */
	public CifradoXBloquesAES getObjUtlCifradoXBloquesAES() throws Exception{
		
		if(this.objUtlCifradoXBloquesAES == null){
			
			this.objUtlCifradoXBloquesAES = new CifradoXBloquesAES(this);
		}
		
		return this.objUtlCifradoXBloquesAES;
	}

	/**
	 * @method setObjUtlCifradoXBloquesAES
	 * 		   Metodo set del atributo objUtlCifradoXBloquesAES
	 * @param  pObjUtlCifradoXBloquesAES
	 *		   Valor que tomara el atributo objUtlCifradoXBloquesAES
	 * @author hector.cuenca
	 * @date   4/03/2016
	 */
	public void setObjUtlCifradoXBloquesAES(CifradoXBloquesAES pObjUtlCifradoXBloquesAES) {
		this.objUtlCifradoXBloquesAES = pObjUtlCifradoXBloquesAES;
	}

	/**
	 * @method getAlgoritmo
	 * 		   Metodo get del atributo ALGORITMO
	 * @return String
	 *		   Valor del atributo ALGORITMO devuelto
	 * @author hector.cuenca
	 * @date   4/03/2016
	 */
	public static String getAlgoritmo() {
		return ALGORITMO;
	}

	/**
	 * @method getNombreAlgoritmo
	 * 		   Metodo get del atributo NOMBRE_ALGORITMO
	 * @return String
	 *		   Valor del atributo NOMBRE_ALGORITMO devuelto
	 * @author hector.cuenca
	 * @date   4/03/2016
	 */
	public static String getNombreAlgoritmo() {
		return NOMBRE_ALGORITMO;
	}
}

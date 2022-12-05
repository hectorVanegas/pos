package co.com.codesa.clienteposslimgiros.utilidades.cifrado.tiposCifrado.cifradoXBloques.AES;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Hex;
import co.com.codesa.clienteposslimgiros.dto.cifrado.tiposCifrado.cifradoXBloques.AES.ConfigCifradoXBloquesAESDTO;
import co.com.codesa.clienteposslimgiros.utilidades.cifrado.tiposCifrado.TiposCifrado;

/** 
 * ********************************************************************
 * @class  CifradoXBloquesAES
 *		   Clase utilitaria encargada de realizar el tipo de cifrado por
 *		   bloques AES (por sus siglas en ingles Advanced Encryption 
 *		   Standard)
 * @author hector.cuenca
 * @date   3/03/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class CifradoXBloquesAES extends TiposCifrado{
	
    /**
     * @variable objKeyLLave
     * 			 LLave de cifrado
     */
    private Key objKeyLLave;
    
    /**
     * @variable objCipDescifrador
     * 			 Objeto Cipher que permitira ejecutar las acciones de 
     * 			 descifrado
     */
    private Cipher objCipDescifrador;
    
    /**
     * @variable objCipCifrador
     * 			 Objeto Cipher que permitira ejecutar las acciones de 
     * 			 cifrado
     */
    private Cipher objCipCifrador;
    
    /**
     * @variable objDtoCfgCifradoXBloquesAES
     * 			 Objeto DTO que contiene toda la configuracion relacionada con 
	 * 		  	 el proceso de cifrado por bloques AES
     */
    private ConfigCifradoXBloquesAESDTO objDtoCfgCifradoXBloquesAES;
    
	/** 
	 * ********************************************************************
	 * @method CifradoXBloquesAES
	 * 		   Metodo constructor que permite la inicializacion de los 
	 * 		   valores y comportamientos necesarios para la construccion de
	 * 		   este objeto
	 * @param  pObjDtoCfgCifradoXBloquesAES
	 * 		   Objeto DTO que contiene toda la configuracion relacionada con 
	 * 		   el proceso de cifrado por bloques AES
	 * @throws Exception
	 *		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   3/03/2016
	 * *********************************************************************
	 */
	public CifradoXBloquesAES(ConfigCifradoXBloquesAESDTO pObjDtoCfgCifradoXBloquesAES) throws Exception{
		
		super();
		
		this.setObjDtoCfgCifradoXBloquesAES(pObjDtoCfgCifradoXBloquesAES);
	}

	@Override
	public String cifrar(String pStrCadena) throws Exception {
		
		byte[] arrBytCifrado;
		String strCadenaCifrada;
		
		arrBytCifrado = this.getObjCipCifrador().doFinal(pStrCadena.getBytes());
		strCadenaCifrada = Hex.encodeHexString(arrBytCifrado);
        
        return strCadenaCifrada;
	}

	@Override
	public String desCifrar(String pStrCadenaCifrada) throws Exception {
		
		byte[] arrBytDescifrado;
		String strCadenaDescifrada;
		arrBytDescifrado = this.getObjCipDescifrador().doFinal(Hex.decodeHex(pStrCadenaCifrada.toCharArray()));
     	strCadenaDescifrada = new String(arrBytDescifrado);
     	
     	return strCadenaDescifrada;
	}

	/** 
	 * ********************************************************************
	 * @method crearCifradoModo
	 * 		   Metodo que permite crear el objeto Cipher en modo des/cifrado, 
	 * 		   segun el tipo recibido
	 * @param  pIntTipoModo
	 * 		   Modo que permite identificar si el objeto Cipher ejecutara las
	 * 		   acciones de des/cifrado
	 * @return Cipher
	 * 		   Objeto Cipher gestionado
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author hector.cuenca
	 * @date   4/03/2016
	 * *********************************************************************
	 */
	private Cipher crearCifradoModo(int pIntTipoModo)throws Exception{
		
		Cipher objCifradoXModo;
		
		objCifradoXModo = Cipher.getInstance(ConfigCifradoXBloquesAESDTO.getAlgoritmo());
		
		objCifradoXModo.init(pIntTipoModo,
				 			 this.getObjKeyLLave(),
				 			 this.getObjDtoCfgCifradoXBloquesAES().getIvInicializacionVector());
		
		return objCifradoXModo;
	}
	
	/**
	 * @method getObjKeyLLave
	 * 		   Metodo get del atributo objKeyLLave
	 * @return Key
	 *		   Valor del atributo objKeyLLave devuelto
	 * @throws Exception 
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author hector.cuenca
	 * @date   3/03/2016
	 */
	public Key getObjKeyLLave() throws Exception{
		
		if(this.objKeyLLave == null){
			
			this.objKeyLLave = new SecretKeySpec(this.getObjDtoCfgCifradoXBloquesAES().getArrBytLLave(), 
												 ConfigCifradoXBloquesAESDTO.getNombreAlgoritmo());
		}
		
		return this.objKeyLLave;
	}

	/**
	 * @method setObjKeyLLave
	 * 		   Metodo set del atributo objKeyLLave
	 * @param  pObjKeyLLave
	 *		   Valor que tomara el atributo objKeyLLave
	 * @author hector.cuenca
	 * @date   3/03/2016
	 */
	public void setObjKeyLLave(Key pObjKeyLLave) {
		this.objKeyLLave = pObjKeyLLave;
	}

	/**
	 * @method getObjCipDecifrador
	 * 		   Metodo get del atributo objCipDescifrador
	 * @return Cipher
	 *		   Valor del atributo objCipDescifrador devuelto
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   3/03/2016
	 */
	public Cipher getObjCipDescifrador() throws Exception{
		
		if(this.objCipDescifrador == null){
			
			this.objCipDescifrador = this.crearCifradoModo(Cipher.DECRYPT_MODE);
		}
		
		return this.objCipDescifrador;
	}

	/**
	 * @method setObjCipDecifrador
	 * 		   Metodo set del atributo objCipDescifrador
	 * @param  pObjCipDecifrador
	 *		   Valor que tomara el atributo objCipDescifrador
	 * @author hector.cuenca
	 * @date   3/03/2016
	 */
	public void setObjCipDescifrador(Cipher pObjCipDecifrador) {
		this.objCipDescifrador = pObjCipDecifrador;
	}

	/**
	 * @method getObjCipCifrador
	 * 		   Metodo get del atributo objCipCifrador
	 * @return Cipher
	 *		   Valor del atributo objCipCifrador devuelto
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author hector.cuenca
	 * @date   3/03/2016
	 */
	public Cipher getObjCipCifrador() throws Exception{
		
		if(this.objCipCifrador == null){
			
			this.objCipCifrador = this.crearCifradoModo(Cipher.ENCRYPT_MODE);
		}
		
		return this.objCipCifrador;
	}

	/**
	 * @method setObjCipCifrador
	 * 		   Metodo set del atributo objCipCifrador
	 * @param  pObjCipCifrador
	 *		   Valor que tomara el atributo objCipCifrador
	 * @author hector.cuenca
	 * @date   3/03/2016
	 */
	public void setObjCipCifrador(Cipher pObjCipCifrador) {
		this.objCipCifrador = pObjCipCifrador;
	}

	/**
	 * @method getObjDtoCfgCifradoXBloquesAES
	 * 		   Metodo get del atributo objDtoCfgCifradoXBloquesAES
	 * @return ConfigCifradoXBloquesAESDTO
	 *		   Valor del atributo objDtoCfgCifradoXBloquesAES devuelto
	 * @author hector.cuenca
	 * @date   3/03/2016
	 */
	public ConfigCifradoXBloquesAESDTO getObjDtoCfgCifradoXBloquesAES() {
		return objDtoCfgCifradoXBloquesAES;
	}

	/**
	 * @method setObjDtoCfgCifradoXBloquesAES
	 * 		   Metodo set del atributo objDtoCfgCifradoXBloquesAES
	 * @param  pObjDtoCfgCifradoXBloquesAES
	 *		   Valor que tomara el atributo objDtoCfgCifradoXBloquesAES
	 * @author hector.cuenca
	 * @date   3/03/2016
	 */
	public void setObjDtoCfgCifradoXBloquesAES(
			ConfigCifradoXBloquesAESDTO pObjDtoCfgCifradoXBloquesAES) {
		this.objDtoCfgCifradoXBloquesAES = pObjDtoCfgCifradoXBloquesAES;
	}

}

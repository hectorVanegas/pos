package co.com.codesa.clienteposslimgiros.interfaces.cifrado;

/** 
 * ********************************************************************
 * @class  OperacionesCifrado
 *		   Interface que describe el conjunto de operaciones disponibles
 *		   para un proceso de cifrado
 * @author hector.cuenca
 * @date   3/03/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public interface OperacionesCifrado {

	/** 
	 * ********************************************************************
	 * @method cifrar
	 * 		   Metodo encargado de cifrar una cadena de texto recibida como
	 * 		   entrada
	 * @param  pStrCadena
	 * 		   Cadena de texto a cifrar
	 * @return String
	 * 		   Cadena de texto cifrada
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   3/03/2016
	 * *********************************************************************
	 */
	public String cifrar(String pStrCadena)throws Exception;
	
	/** 
	 * ********************************************************************
	 * @method desCifrar
	 * 		   Metodo encargado de des-cifrar una cadena de texto recibida 
	 * 		   como entrada
	 * @param  pStrCadenaCifrada
	 * 		   Cadena de texto a des-cifrar
	 * @return String
	 * 		   Cadena de texto des-cifrada
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   3/03/2016
	 * *********************************************************************
	 */
	public String desCifrar(String pStrCadenaCifrada)throws Exception;
	
}

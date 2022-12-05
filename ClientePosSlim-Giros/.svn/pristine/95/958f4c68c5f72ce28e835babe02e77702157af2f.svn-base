package co.com.codesa.clienteposslimgiros.enumeraciones.cifrados;

import co.com.codesa.clienteposslimgiros.dto.cifrado.tiposCifrado.cifradoXBloques.AES.ConfigCifradoXBloquesAESDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.formas.ayuda.FormaAyuda;
import co.com.codesa.clienteposslimgiros.interfaces.cifrado.ConfiguracionCifrado;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;

/** 
 * ********************************************************************
 * @class  EnumProcesosCifrado
 *		   Clase enumerador, que permite administrar de forma diciente 
 * 		   los cifrados configurados para cada proceso de negocio que
 * 		   demande del uso de estas utilidades de cifrado
 * @author hector.cuenca
 * @date   4/03/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public enum EnumProcesosCifrado {

	
	/**
	 * @variable 	CLAVE_SEGURIDAD
	 * 			 	Cifrado para el proceso de negocio relacionado con 
	 * 			 	clave de seguridad
	 */
	CLAVE_SEGURIDAD(ConfigCifradoXBloquesAESDTO.class,
					 EnumParametrosSistema.LLAVE_ALGORITMO_CIFRADO,
					 "12345678901234567890123456789012"),
				
	/**
	 * @variable 	ARCHIVOS_WSQ
	 * 			 	Cifrado para el proceso de negocio relacionado con 
	 * 			 	los procesos de biometria en cuanto a la transmision de 
	 * 				los archivos WSQ
	 */
	ARCHIVOS_WSQ	(	ConfigCifradoXBloquesAESDTO.class,
	            	 	EnumParametrosApp.LLAVE_DESCIFRAR_WSQ,
	            	 	"12345678901234567890123456789012"
	            	),
	
	;
	
	/**
	 * @variable clsConfiguracionCifrado
	 * 			 Referencia la clase de configuracion que se gestionara 
	 * 			 para el tipo de cifrado empleado
	 */
	private final Class<? extends ConfiguracionCifrado> clsConfiguracionCifrado;
	
	/**
	 * @variable arrParametros
	 * 			 Representa el listado de parametros con los cuales se 
	 * 			 llevara a cabo la construccion del objeto de configuracion 
	 */
	private Object arrParametros[];
	
	/**
	 * @variable ifcCfgCifrado
	 * 			 Interface que representa los objetos disponibles para 
	 * 			 la configuracion de cada tipo de cifrado implementado
	 */
	private ConfiguracionCifrado ifcCfgCifrado;
	
	/** 
	 * ********************************************************************
	 * @method EnumProcesosCifrado
	 * 		   Inicializacion de la constante de enumeracion
	 * @param  pClsConfiguracionCifrado
	 * 		   Referencia la clase de configuracion que se gestionara para 
	 * 		   el tipo de cifrado empleado
	 * @param  pArrParametros
	 * 		   Representa el listado de parametros con los cuales se llevara
	 * 		   a cabo la construccion del objeto de configuracion 
	 * @author hector.cuenca
	 * @date   4/03/2016
	 * *********************************************************************
	 */
	private EnumProcesosCifrado(Class<? extends ConfiguracionCifrado> pClsConfiguracionCifrado,
								Object ...pArrParametros){
		
		this.clsConfiguracionCifrado = pClsConfiguracionCifrado;
		this.setArrParametros(pArrParametros);
	}
	
	/** 
	 * ********************************************************************
	 * @method cifrar
	 * 		   Metodo que permite acceder a la interface de operaciones de 
	 * 		   cifrado y solicitar la accion particular de cifrar
	 * @param  pStrCadena
	 * 		   Cadena de texto a cifrar
	 * @return String
	 * 		   Cadena de texto cifrada
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   4/03/2016
	 * *********************************************************************
	 */
	public String cifrar(String pStrCadena)throws Exception{
		
		return this.getIfcCfgCifrado().obtenerAlgoritmo().cifrar(pStrCadena);
	}
	
	/** 
	 * ********************************************************************
	 * @method descifrar
	 * 		   Metodo que permite acceder a la interface de operaciones de 
	 * 		   cifrado y solicitar la accion particular de descifrar
	 * @param  pStrCadena
	 * 		   Cadena de texto a des-cifrar
	 * @return String
	 * 		   Cadena de texto des-cifrada
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   4/03/2016
	 * *********************************************************************
	 */
	public String descifrar(String pStrCadena)throws Exception{
		
		return this.getIfcCfgCifrado().obtenerAlgoritmo().desCifrar(pStrCadena);
	}
	
	/**
	 * @method getClsConfiguracionCifrado
	 * 		   Metodo get del atributo clsConfiguracionCifrado
	 * @return Class<? extends ConfiguracionCifrado>
	 *		   Valor del atributo clsConfiguracionCifrado devuelto
	 * @author hector.cuenca
	 * @date   4/03/2016
	 */
	public Class<? extends ConfiguracionCifrado> getClsConfiguracionCifrado() {
		return clsConfiguracionCifrado;
	}

	/**
	 * @method getIfcCfgCifrado
	 * 		   Metodo get del atributo ifcCfgCifrado
	 * @return ConfiguracionCifrado
	 *		   Valor del atributo ifcCfgCifrado devuelto
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   4/03/2016
	 */
	public ConfiguracionCifrado getIfcCfgCifrado() throws Exception{
		
		Class<?> arrClsTiposParametros[];
		
		if(this.ifcCfgCifrado == null){
			
			arrClsTiposParametros = UtilidadesGiros.getInstance().obtenerArrayClasesObjetos(this.getArrParametros());
			
			this.ifcCfgCifrado = this.getClsConfiguracionCifrado().getDeclaredConstructor(arrClsTiposParametros).newInstance(this.getArrParametros());
		}
		
		return this.ifcCfgCifrado;
	}

	/**
	 * @method setIfcCfgCifrado
	 * 		   Metodo set del atributo ifcCfgCifrado
	 * @param  pIfcCfgCifrado
	 *		   Valor que tomara el atributo ifcCfgCifrado
	 * @author hector.cuenca
	 * @date   4/03/2016
	 */
	public void setIfcCfgCifrado(ConfiguracionCifrado pIfcCfgCifrado) {
		this.ifcCfgCifrado = pIfcCfgCifrado;
	}

	/**
	 * @method getArrParametros
	 * 		   Metodo get del atributo arrParametros
	 * @return Object
	 *		   Valor del atributo arrParametros devuelto
	 * @author hector.cuenca
	 * @date   4/03/2016
	 */
	public Object[] getArrParametros() {
		return arrParametros;
	}

	/**
	 * @method setArrParametros
	 * 		   Metodo set del atributo arrParametros
	 * @param  pArrParametros
	 *		   Valor que tomara el atributo arrParametros
	 * @author hector.cuenca
	 * @date   4/03/2016
	 */
	public void setArrParametros(Object pArrParametros[]) {
		this.arrParametros = pArrParametros;
	}
	
	/** 
	 * ********************************************************************
	 * @method main
	 * 		   Metodo principal para ejecucion de pruebas internas
	 * @param  args
	 * 		   Argumentos requeridos por el metodo principal
	 * @author hector.cuenca
	 * @date   4/03/2016
	 * *********************************************************************
	 */
	public static void main(String args[]){
		
		String strCadenaCifrar = "7EY4U5FB";
		String strCadenaDescifrar = "cce079a912b164f9ab79e331e234194e";//"ec82652fae97b7909030d5b43cd05453";
									 
		boolean booTipoOperacion = false;
		String strRespuesta;
		
		try{
			
			TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaAyuda.class,
					   											   true, 
					   											   EnumDesplegarFormaConEventos.SI);
			if(booTipoOperacion){
			
				strRespuesta = EnumProcesosCifrado.CLAVE_SEGURIDAD.cifrar(strCadenaCifrar);
				
			}else{
				
				strRespuesta = EnumProcesosCifrado.CLAVE_SEGURIDAD.descifrar(strCadenaDescifrar);
			}
			
			System.out.println(strRespuesta);
			
		}catch(Exception e){
			
			UtilidadesGiros.getInstance().controlExcepcion(e, 
														   null);
			e.printStackTrace();
		}
		
	}

}

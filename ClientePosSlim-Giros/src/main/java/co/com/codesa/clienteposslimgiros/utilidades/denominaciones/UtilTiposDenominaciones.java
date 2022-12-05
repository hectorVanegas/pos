package co.com.codesa.clienteposslimgiros.utilidades.denominaciones;

import java.util.HashMap;

import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.giros.EnumTiposDenominacion;


/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 14-abr-2015
 * @Clase UtilComponentesGUI 
 * 		  Clase utilitaria relacionada con los tipos de denominacion
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class UtilTiposDenominaciones {
	
	/**
	 * @variable hmTiposDenominacionesXIdTipo 
	 * 			 Estructura de facil acceso para administrar las constantes de enumeracion
	 * 		   	 referentes a los tipos de denominacion
	 **/
	private HashMap<String, EnumTiposDenominacion> hmTiposDenominacionesXIdTipo;
	
	/**
	 * @variable instancia 
	 * 			 Referencia estatica de la clase utilitaria, clave para incorporar
	 * 			 SINGLETON (patron de diseño)
	 **/
	private static UtilTiposDenominaciones instancia;
	
	/**
  	 * ****************************************************************.
  	 * @metodo UtilComponentesGUI
  	 * 		   Metodo constructor que permite inicializar variables y
  	 * 		   ejecutar comportamientos de interes
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private UtilTiposDenominaciones() throws Exception{
		
		this.cargarHashEnumTiposDenominaciones();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo getInstance
  	 * 		   Metodo clave para ejecutar el patron singleton sobre la 
  	 * 		   clase, materializando esta por unica vez y manteniendo una 
  	 * 		   sola instancia de esta
  	 * @return UtilTiposDenominaciones
  	 * 		   Tipo referente a la misma clase
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public static UtilTiposDenominaciones getInstance(){
		
		try{
		
			if (instancia == null) {
				
				instancia = new UtilTiposDenominaciones();
			}
			
		}catch(Exception e){
			
			UtilidadesGiros.getInstance().controlExcepcion(e, 
														   null);
		}
		
		return instancia;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo cargarHashEnumTiposDenominaciones
  	 * 		   Metodo encargado de procesar todos los tipos de nominacion
  	 * 		   y fabricar a nivel de la clase una estructura para facilitar
  	 * 		   el acceso por Id (Hash)
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void cargarHashEnumTiposDenominaciones() throws Exception{
		
		this.hmTiposDenominacionesXIdTipo = new HashMap<String, EnumTiposDenominacion>();
		
		for(EnumTiposDenominacion enmTipoDenominacion : EnumTiposDenominacion.values()){
			
			this.hmTiposDenominacionesXIdTipo.put(enmTipoDenominacion.getObjDatEntTipo().getId(), enmTipoDenominacion);
		}
	}

	public HashMap<String, EnumTiposDenominacion> getHmTiposDenominacionesXIdTipo() {
		return hmTiposDenominacionesXIdTipo;
	}

	public void setHmTiposDenominacionesXIdTipo(
			HashMap<String, EnumTiposDenominacion> hmTiposDenominaciones) {
		this.hmTiposDenominacionesXIdTipo = hmTiposDenominaciones;
	}
	
}

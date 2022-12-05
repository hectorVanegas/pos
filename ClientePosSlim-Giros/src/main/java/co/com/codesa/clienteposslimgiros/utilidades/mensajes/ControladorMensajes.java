package co.com.codesa.clienteposslimgiros.utilidades.mensajes;

import java.util.HashMap;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumCodigosMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;

/**
 * ****************************************************************.
 * @autor: Hector Q-en-K
 * @fecha: 07-mar-2015
 * @descripcion: Clase encargada de ser la controladora para acceder a
 * 				 mensajes relacionados con el modulo de giros
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class ControladorMensajes {

	/**
     * @variable hasMapMensajes: estructura estatica de datos para almacenar 
     * 			 los mensajes consultados de BD teniendolos a 
     * 			 disposicion para posteriores consultas, permanece 
     * 			 estatica a nivel de sesion, y en alimentacion 
     * 			 constante conforme se vayan solicitando mensajes
     **/
	private HashMap<String,Mensaje> hasMapMensajes;
	
	/**
     * @variable modoOperacion: modo en el que operara el componente de mensajes.
     * 			 TRUE: validando contra BD
     * 			 FALSE: validando contra recursos internos (archivo propiedades)
     **/
	private boolean modoOperacion;
	
	/**
     * @variable controladorMensajes: atributo que representa a la
     * 			 clase misma para implementar el patron de diseño
     * 			 singleton
     **/
	private static ControladorMensajes controladorMensajes;
	
	
	
	 /**
     * ****************************************************************.
     * @metodo: getInstance
     * @descripcion: metodo que implementa el patron singleton sobre la
     * 				 clase misma, para generar un instancia a nivel de la
     * 				 app
     * @return: ControladorMensajes, obj que representa a la misma clase
     * @autor: Hector Q-en-K
     *         ****************************************************************
     */
	public static ControladorMensajes getInstance() {
		
		if (controladorMensajes == null) {
			
			controladorMensajes = new ControladorMensajes();
			controladorMensajes.hasMapMensajes = new HashMap<String, Mensaje>();
			
			/**
			 * TODO [Q-en-K]: implementar lectura de parametro del sistema, para 
			 * 				  reconocer el modo en el que operara el componente
			 */
			controladorMensajes.modoOperacion=false;
			
		}
		
		return controladorMensajes;
	}
	
	/**
     * ****************************************************************.
     * @param clase: Constante de enumerador, que permite identificar la 
     * 				 clase de mensaje a generar
     * @param codigo: codigo de mensaje que se solicita
     * @param parametros: parametros que se vincularan al mensaje 
     * @metodo: obtenerMensaje
     * @descripcion: Metodo que realiza el proceso requerido para solicitar 
     * 				 un mensaje, con respecto a su codigo, y setearle a este
     * 				 aspectos basicos como los parametros y la clase de mensaje
     * 				 que se espera
     * @return: Mensaje, obj que representa al mensaje consultado
     * @autor: Hector Q-en-K
     * ****************************************************************
     */
	public Mensaje obtenerMensaje(EnumClasesMensaje clase,
								  String codigo,
								  String descripcion,
								  String parametros[]){
		
		Mensaje mensaje;
		
		if	(		codigo!=null 
				&& 	!(codigo=codigo.trim()).isEmpty()
				&&	!codigo.equals("*")
			)
		{
			if(descripcion!=null && 
					!descripcion.trim().isEmpty()){//se especifico una descripcion, importante para respuesta de trama error
				
				mensaje= new Mensaje(clase,
									 codigo,
						 			 descripcion);

				mensaje.setParametros(parametros);
				
			}else{//solo se especifico codigo de mensaje
				
				mensaje=this.consultarMensaje(clase,
											  codigo,
											  parametros);
			}
			
		}else{
			
			if(descripcion!=null && 
					!descripcion.trim().isEmpty()){
				
				mensaje= new Mensaje(clase,
			 			 			 descripcion);

				mensaje.setParametros(parametros);
				
			}else{
			
				mensaje=this.consultarMensaje(clase,
						  					  EnumMensajes.MENSAJE_NO_ESPECIFICADO.getCodigo(),
						  					  parametros);
			}
		}
		
		return mensaje;
	}
	
	
	public Mensaje obtenerMensaje(EnumClasesMensaje clase,
								  String codigo,
								  String parametros[]){

		Mensaje mensaje;
		String descripcion=null;
		
		mensaje = this.obtenerMensaje(clase,
									  codigo,
									  descripcion,
									  parametros);
		
		return mensaje;

	}
	
	public Mensaje obtenerMensaje(EnumClasesMensaje clase,
								  String codigo){

		Mensaje mensaje;
		String descripcion=null;
		String parametros[]=null;
		
		mensaje = this.obtenerMensaje(clase,
						  codigo,
						  descripcion,
						  parametros);

		return mensaje;

	}
	
	public Mensaje obtenerMensaje(EnumClasesMensaje clase,
								  String codigo,
								  String descripcion){

		Mensaje mensaje;
		String parametros[]=null;

		mensaje = this.obtenerMensaje(clase,
									  codigo,
									  descripcion,
									  parametros);

		return mensaje;
	}
	
	/**
     * ****************************************************************.
     * @param clase: Constante de enumerador, que permite identificar la 
     * 				 clase de mensaje a generar
     * @param codigo: codigo del mensaje a consultar
     * @param parametros: parametros que se asociaran al mensaje
     * @metodo: consultarMensaje
     * @descripcion: Metodo que realiza la consulta de un mensaje a 
     * 				 traves de su codigo, en primera instancia sobre la 
     * 				 estructura de datos estatica, en caso de no encontrarlo, 
     * 				 solicitara la peticion de consulta del mensaje a BD
     * @return Mensaje: objeto mensaje consultado
     * @autor: Hector Q-en-K
     * ****************************************************************
     */
	private Mensaje consultarMensaje(EnumClasesMensaje clase,
									 String codigo,
									 String parametros[]){
		
		Mensaje mensaje;
		
		try{
						
			if(this.hasMapMensajes.containsKey(codigo)){
				
				mensaje=this.hasMapMensajes.get(codigo);
				
			}else{
				
				mensaje = consultaPorModoOperacion(codigo);
				
				if(mensaje==null){
					
					mensaje = new Mensaje(EnumClasesMensaje.ERROR,
										  "APP",
										  codigo,
										  null);
				}else{
					
					this.hasMapMensajes.put(codigo, mensaje);
				}
			}
			
		}catch(Exception e){
			
			mensaje = new Mensaje(EnumClasesMensaje.ERROR,
								  "APP",
								  EnumMensajes.ERROR_GENERAL.getCodigo()+"9",
								  EnumMensajes.ERROR_GENERAL.getMensaje());
			
		}
		
		mensaje.setParametros(parametros);
		
		if(clase!=null){
			mensaje.setClase(clase);
		}
		
		return mensaje;
		
	}
	
	private Mensaje consultaPorModoOperacion(String codigo)throws Exception{
		
		Mensaje mensaje=null;
		
		if(this.modoOperacion){//valida contra BD
			
			mensaje=consultarMensajeBD(codigo);
			
			if(!mensaje.getCodigo().trim().equals(EnumMensajes.MENSAJE_NO_DOCUMENTADO.getCodigo())){
				
				this.hasMapMensajes.put(codigo, mensaje);
				
			}else{
				mensaje=consultarMensajeInterno(codigo);
			}
			
		}else{//valida contra recurso interno (archivo propiedades)
			
			mensaje=consultarMensajeInterno(codigo);
			
		}					
		
		return mensaje;
		
	}
	
	private Mensaje consultarMensajeInterno(String codigo){
		
		Mensaje mensaje;
		EnumCodigosMensaje codigoMensaje;
		
		try{
			
			codigoMensaje = EnumCodigosMensaje.valueOf("_"+codigo.trim());
			
			mensaje = new Mensaje(EnumClasesMensaje.ERROR,
								  codigoMensaje.getTipo(),
								  codigoMensaje.getCodigo(),
								  codigoMensaje.getStrDescripcion());
			
		}catch(Exception e){
			
			mensaje = new Mensaje(EnumClasesMensaje.ERROR,
					  			  "APP",
					  			  codigo,
					  			  null);
		}
		
		return mensaje;
	}
	
	/**
	 * @author: Hector Q-en-K
	 * @type: Comportamiento (metodo)
	 * @name: consultarMensajeBD
	 * @description: Metodo que realiza la peticion de consulta de mensaje a la BD
	 * @param codigo: codigo del mensaje a consultar
	 * @param parametros: parametros que se asociaran al mensaje
	 * @return Mensaje: objeto mensaje consultado
	 * @exception Exception: Controla, recupera y escala, cualquier tipo de excepcion presentada
	 * @version: 07/03/2015
	 */
	private Mensaje consultarMensajeBD(String codigo)throws Exception{
		
		/**
		 * TODO [Q-en-K]: implementar peticion de consulta de mensajes a BD
		 */
		/*if(true)
		throw new Exception("error");
		*/
		return new Mensaje(null,
								"APP",
								"00226",
								null);
	}
	
}

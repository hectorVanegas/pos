package co.com.codesa.clienteposslimgiros.utilidades.mensajes;

import java.awt.Window;

import javax.swing.JDialog;
import javax.swing.JFrame;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.mensajes.FormaMensajeAlerta;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;

/**
 * ****************************************************************.
 * @autor: Hector Q-en-K
 * @fecha: 07-mar-2015
 * @descripcion: Clase encargada de administrar el objeto mensaje
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class Mensaje {

	/**
    * @variable clase: constante de enumerador que representa la clase
    * 			del mensaje (informacion, error, advertencia, entre otros)
    **/
	private EnumClasesMensaje clase;
	
	/**
    * @variable tipo: tipo de mensaje, segun la parametrizacion de base de datos
    * 			(APP,FRM, entre otras)
    **/
	private String tipo;
	
	/**
    * @variable codigo: codigo del mensaje representativo en base de datos
    **/
	private String codigo;
	
	/**
    * @variable mensajePlantilla: mensaje plantilla, sin asociacion de parametros
    **/
	private String mensajePlantilla;
	
	/**
    * @variable parametros: parametros que se asociaran al mensaje
    **/
	private String parametros[];
	
	private String mensaje;

	/**
	 * ****************************************************************.
     * @param clase: constante de enumerador que representa la clase
     * 		  		 del mensaje (informacion, error, advertencia, entre otros)
     * @param tipo: tipo de mensaje, segun la parametrizacion de base de datos
     * 			    (APP,FRM, entre otras)
     * @param codigo: codigo del mensaje representativo en base de datos
     * @param mensajePlantilla: mensaje plantilla, sin asociacion de parametros
     * @metodo: Mensaje (Constructor)
     * @descripcion: Constructor que ejecuta la inicializacion de valores y ejecucion de 
	 * 				 comportamientos inicales requeridos para la materializacion del
	 * 				 objeto de mensaje
     * @autor: Hector Q-en-K
     * ****************************************************************
     */
	public Mensaje(EnumClasesMensaje clase,
				   String tipo,
				   String codigo,
				   String mensaje){
		
		this.clase=clase;
		this.tipo=tipo;
		this.codigo=codigo;
		this.mensaje=mensaje;
		
	}
	
	public Mensaje(EnumClasesMensaje clase,
			   	   String mensaje){
	
		this.clase=clase;
		this.mensaje=mensaje;
		
	}
	
	public Mensaje(EnumClasesMensaje clase,
				   String codigo,
				   String mensaje){

		this.clase=clase;
		this.codigo=codigo;
		this.mensaje=mensaje;
	
	}
	
	/**
	 * ****************************************************************.
     * @param clase: constante de enumerador que representa la clase
     * 		  		 del mensaje (informacion, error, advertencia, entre otros)
     * @param tipo: tipo de mensaje, segun la parametrizacion de base de datos
     * 			    (APP,FRM, entre otras)
     * @param codigo: codigo del mensaje representativo en base de datos
     * @param mensajePlantilla: mensaje plantilla, sin asociacion de parametros
     * @metodo: obtenerMensajeProcesado
     * @descripcion: Metodo que realiza el procesamiento del mensaje segun la plantilla
     * 				 definida y asocia los parametros diligeniciados al mensaje
     * @return String: mensaje procesado como cadena completa
     * @autor: Hector Q-en-K
     * ****************************************************************
     */
	private String getMensajePlantilla(){
		
		if(this.mensajePlantilla==null){
		
			if(this.codigo!=null){
				
				this.mensajePlantilla=EnumParametrosApp.PLANTILLA_MENSAJE_PROCESADO.getValorPropiedad();
				this.mensajePlantilla=this.mensajePlantilla.replace("{tipo}", this.getTipo());
				this.mensajePlantilla=this.mensajePlantilla.replace("{codigo}", this.codigo);
				this.mensajePlantilla=this.mensajePlantilla.replace("{clase}", this.getClase().getStrClave());
				this.mensajePlantilla=this.mensajePlantilla.replace("{mensaje}",this.getMensaje());
				
			}else if(mensaje!=null){
				this.mensajePlantilla=mensaje;
			}
			
		}
		
		return this.mensajePlantilla;
		
	}	
	
	public String obtenerMensajeProcesado()throws Exception{
		
		String seccionMensaje;
		String mensajeProcesado;
		
		seccionMensaje=this.getMensaje();
		
		seccionMensaje = UtilidadesGiros.getInstance().procesarParametrosEnTexto(seccionMensaje, 
																				 this.parametros);
		
		seccionMensaje=UtilidadesGiros.getInstance().aplicarPresentacion(seccionMensaje,null);
		
		seccionMensaje	=	this.validarPuntoFinal(seccionMensaje);
		
		mensajeProcesado=this.getMensajePlantilla().replace(this.getMensaje(),seccionMensaje);
		
		return mensajeProcesado;
		
	}
	
	private	String	validarPuntoFinal(String pStrMensaje)
			throws Exception
	{		pStrMensaje	=	pStrMensaje.trim();
		
		if	(	!pStrMensaje.endsWith(".")	)
		{
			pStrMensaje	+=	".";
		}
		
		return pStrMensaje;
	}
	
	/**
	 * ****************************************************************.
     * @param ventana: ventana sobre la cual se implementara el despliegue de 
	 * 				   mensaje
     * @metodo: desplegarMensaje
     * @descripcion: Metodo que se encarga de desplegar el mensaje en pantalla
     * @return String: mensaje procesado como cadena completa
     * @autor: Hector Q-en-K
     * ****************************************************************
     */
	public FormaMensajeAlerta desplegarMensaje(Window ventana){
		
		FormaMensajeAlerta alerta=null;
		
		try {
			
			if(ventana!=null && 
					!ventana.isVisible() &&
					ventana instanceof FormaGenerica){
				
				ventana.setVisible(true);
			}
			
			if(ventana instanceof JDialog){
				alerta = new FormaMensajeAlerta((JDialog)ventana,
					  							this);
			}else if(ventana instanceof JFrame){
				alerta = new FormaMensajeAlerta((JFrame)ventana,
					  							this);
			}else{
				alerta = new FormaMensajeAlerta((JDialog)ventana,
					  							this);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return alerta;
		
	}
	
	/**
	 * ****************************************************************.
     * @param ventana: ventana sobre la cual se implementara el despliegue de 
	 * 				   mensaje
     * @metodo: getClase
     * @descripcion: Metodo get especializado para retornar la clase de enumerador
     * 				 de error, como valor por defecto, en caso de no tenerse 
     * 				 diligenciada 
     * @return EnumClasesMensaje: constante de enumerador que representa 
     * 								   la clase de mensaje 
     * @autor: Hector Q-en-K
     * ****************************************************************
     */
	public EnumClasesMensaje getClase() {
		if(clase==null){
			
			clase=EnumClasesMensaje.ERROR;
			
		}
		return clase;
	}

	public void setClase(EnumClasesMensaje clase) {
		this.clase = clase;
	}

	public String getTipo() {
		if(this.tipo==null){
			this.tipo="APP";
		}
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setMensajePlantilla(String mensajePlantilla) {
		this.mensajePlantilla = mensajePlantilla;
	}

	public String[] getParametros() {
		return parametros;
	}

	public void setParametros(String[] parametros) {
		this.parametros = parametros;
	}

	public String getMensaje() {
		if(this.mensaje==null){
			this.mensaje = EnumParametrosApp.MENSAJE_NO_DOCUMENTADO.getValorPropiedad();
		}
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	@Override
	public String toString() {
		
		String strPresentar;
		
		try{
			
			strPresentar = this.obtenerMensajeProcesado();
			
		}catch(Exception e){
			
			strPresentar = "Mensaje [clase="+clase.getStrClave()+","
					   			+" tipo="+tipo+","
					   			+" codigo="+codigo+","
					   			+" mensaje="+mensaje+"]";
		}
		
		return strPresentar;
	}
}

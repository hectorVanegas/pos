package co.com.codesa.clienteposslimgiros.vista.logica.terceroPeps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGiros;
import co.com.codesa.clienteposslimgiros.utilidades.terceros.peps.UtilTerceroPeps;
import co.com.codesa.clienteposslimgiros.utilidades.vistaLogica.UtilVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultarTerceroPeps;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RegistrarTerceroPeps;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultaTerceroPeps;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaRegistrarTerceroPeps;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DatoEntidad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TerceroPeps;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.terceropeps.PreguntasTerceroPepsDTO;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;

/**
 * 
 * ********************************************************************
 * @class	TerceroPepsVistaLogica
 *		 	Clase Singleton encargada de administrar los servicios
 *			de consultar y registrar informacion de un tercero PEPS
 * @author	Stiven.Garcia
 * @date  	16/04/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class TerceroPepsVistaLogica {
	
	
	/**
	 * @variable instancia
	 * 			 instancia de la clase para manejo singleton
	 */
	private static TerceroPepsVistaLogica instancia;
	
	/**
	 * ****************************************************************.
	 * @method TerceroPepsVistaLogica
	 * 		   Contructor de la logica.
	 * @author Stiven Garcia
	 * ****************************************************************
	 */
	private TerceroPepsVistaLogica(){}	
	
	/**
	 * ****************************************************************.
	 * @method getInstance
	 * 		   metodo para cumplir con el patron singleton y tener
	 * 		   una unica instancia de la clase para ser accedida.
	 * @return TerceroPepsVistaLogica
	 * @author StivenGarcia
	 * ****************************************************************
	 */
	public static TerceroPepsVistaLogica getInstance(){		
		
		if (instancia == null){
			
			instancia= new TerceroPepsVistaLogica();
		}
		
		return instancia;
	}
	
	/**
	 * @method registrarTerceroPeps
	 * 			Metodo encargado de registrar si un tercero es PEPS o no 
	 * @param pObjUsuario
	 * 			Es el usuario cajero que realiza la peticion 
	 * @param pObjTercero
	 * 			Es el tercero que se identifica como peps o no
	 * @param pBooEsTerceroPeps
	 * 			Bandera que identifica si el tercero es PEPS o no 
	 * @param pObjPreguntasTerceroPeps
	 * 			Es el objeto que contiene las preguntas por las cuales 
	 * 			el tercero se identifica como PEPS
	 * @return
	 * 			La respuesta recibida desde la base de datos
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 */
	public String registrarTerceroPeps(	Usuario pObjUsuario, 
										Tercero pObjTercero,
										boolean pBooEsTerceroPeps,
										PreguntasTerceroPepsDTO ... pObjPreguntasTerceroPeps) throws Exception{
		
		RegistrarTerceroPeps objEnvioTrama;
		
		RespuestaRegistrarTerceroPeps objRespuestaTrama;
		
		List<PreguntasTerceroPepsDTO> lPreguntasTerceroPepsDto = new ArrayList<PreguntasTerceroPepsDTO>();
		
		if(pObjPreguntasTerceroPeps != null) {
			lPreguntasTerceroPepsDto = Arrays.asList(pObjPreguntasTerceroPeps);//  pObjPreguntasTerceroPeps
		}
		
		objEnvioTrama = new RegistrarTerceroPeps(pObjUsuario, pObjTercero, pBooEsTerceroPeps, lPreguntasTerceroPepsDto);
		
		objRespuestaTrama = (RespuestaRegistrarTerceroPeps)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if(objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
			return (String)objRespuestaTrama.getValorAtributoObj("respuestaRegistroPeps");
		}else {
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
				   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
				   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"),
				   		 pObjTercero.toStringXDocumento());
		}		
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	consultaTerceroPeps
	 * 		  	[TODO - DOC]: Descripcion del metodo, cual es su uso, la 
	 * 		  	necesidad y su aporte y como se integra con la funcionalidad
	 * @param pObjUsuario
	 * 			Es el usuario cajero que realiza la peticion 
	 * @param pObjTercero
	 * 			Es el tercero que se identifica como peps o no
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author	StivenGarcia
	 * @date	14/04/2018
	 * *********************************************************************
	 */
	public void consultaTerceroPeps( 	Usuario pObjUsuario,
										Tercero pObjTercero 
								   ) 	throws Exception{
		
		ConsultarTerceroPeps objEnvioTrama;
		RespuestaConsultaTerceroPeps objRespuestaTrama;
		
		objEnvioTrama = new ConsultarTerceroPeps(pObjUsuario, pObjTercero);
		objRespuestaTrama = (RespuestaConsultaTerceroPeps)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if(objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
			
			pObjTercero.setObjTerceroPeps((TerceroPeps)objRespuestaTrama.getValorAtributoObj("objTerceroPeps"));
			
		}else {
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
				   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
				   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"),
				   		 pObjTercero.toStringXDocumento());
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		
		TestPruebasInternas.getInstance().iniciarPruebaInterna(null, true, EnumDesplegarFormaConEventos.SI);
		
		Tercero tercero = new Tercero();
		
		tercero.setTipoIdentificacion(new DatoEntidad("3"));
		tercero.setIdentificacion("44");
		
		//TerceroPepsVistaLogica.getInstance().consultaTerceroPeps(InformacionSessionGiros.getInstance().getObjUsuario(), tercero);
		
		UtilTerceroPeps.getInstancia().procesarServicioTerceroPeps(InformacionSessionGiros.getInstance().getObjUsuario(), tercero, null, false);

	}
}

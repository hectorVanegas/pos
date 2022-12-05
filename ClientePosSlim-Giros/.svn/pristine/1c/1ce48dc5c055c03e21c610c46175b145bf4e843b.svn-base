
package co.com.codesa.clienteposslimgiros.vista.logica.serviciosAdicionales.claveSeguridad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import co.com.codesa.clienteposslimcontrolador.conexion.ProcesadorTramas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.serviciosAdicionales.claveSeguridad.EnumTiposClaveSeguridad;
import co.com.codesa.clienteposslimgiros.utilidades.vistaLogica.UtilVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultaDisponibilidadServicioClaveSeguridad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultaReferenciaTieneClaveSeguridad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaCalcularPromociones;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultaDisponibilidadServicioClaveSeguridad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultaReferenciaTieneClaveSeguridad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaVerificaClaveSeguridad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.VerificaClaveSeguridad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.tokenValidacion.ClaveSeguridadDTO;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;


/** 
 * ********************************************************************
 * @class  ClaveSeguridadVistaLogica
 *		   clase encargada de manejar el llamado a las tramas de
 * 		   clave de seguridad
 * @author roberth.martinez
 * @date   01/03/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class ClaveSeguridadVistaLogica {

	/**
	 * @variable instancia
	 * 			 instancia de la clase para manejo singleton
	 */
	private static ClaveSeguridadVistaLogica instancia;
	
	/**
	 * ****************************************************************.
	 * @method ClaveSeguridadVistaLogica
	 * 		   Contructor de la logica.
	 * @author Roberth Martinez Vargas
	 * ****************************************************************
	 */
	private ClaveSeguridadVistaLogica(){}	
	
	/**
	 * ****************************************************************.
	 * @method getInstance
	 * 		   metodo para cumplir con el patron singleton y tener
	 * 		   una unica instancia de la clase para ser accedida.
	 * @return ClaveSeguridadVistaLogica
	 * @author Roberth Martinez Vargas
	 * ****************************************************************
	 */
	public static ClaveSeguridadVistaLogica getInstance(){		
		
		if (instancia == null){
			
			instancia= new ClaveSeguridadVistaLogica();
		}
		
		return instancia;
	}

	/** ********************************************************************
	 * @method consultarDisponibilidadServicioClaveSeguridad
	 * 		   Permite consultar si el servicio de clave de seguridad se 
	 * 		   encuentra habilitado para el tercero propietario apartir de 
	 * 		   la agencia y la caja
	 * @param  pObjUsuario
	 * 		   Usuario de la aplicacion
	 * @return boolean
	 * @author roberth.martinez
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @date   2/3/2016
	 * *********************************************************************
	 */
	public List<EnumTiposClaveSeguridad> consultarDisponibilidadServicioClaveSeguridad(Usuario pObjUsuario) throws Exception{
		
		/**
		 * [Trama 501 | Consultar las especificaciones del servicio de clave de seguridad]
		 */
		
		List<EnumTiposClaveSeguridad> lstTiposClaveSeguridadPermitidos;
		ConsultaDisponibilidadServicioClaveSeguridad objEnvioTrama;
		RespuestaConsultaDisponibilidadServicioClaveSeguridad objRespuestaTrama;
		
		objEnvioTrama = new ConsultaDisponibilidadServicioClaveSeguridad(pObjUsuario);
		
		//objRespuestaTrama = (RespuestaConsultaDisponibilidadServicioClaveSeguridad)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaConsultaDisponibilidadServicioClaveSeguridad)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {//respuesta positiva
			
			lstTiposClaveSeguridadPermitidos	=	new ArrayList<EnumTiposClaveSeguridad>();
			
			if	(	(Boolean) objRespuestaTrama.getValorAtributoObj("booServicioActivo")	)
			{
				if	(	(Boolean) objRespuestaTrama.getValorAtributoObj("booServicioManualActivo")	)
				{
					lstTiposClaveSeguridadPermitidos.add(EnumTiposClaveSeguridad.MANUAL);
				}
				
				if	(	(Boolean) objRespuestaTrama.getValorAtributoObj("booServicioAutomaticoActivo")	)
				{
					lstTiposClaveSeguridadPermitidos.add(EnumTiposClaveSeguridad.AUTOMATICA);
				}
				
				if	(	(Boolean) objRespuestaTrama.getValorAtributoObj("booServicioNoGraciasActivo")	)
				{
					lstTiposClaveSeguridadPermitidos.add(EnumTiposClaveSeguridad.NO_GRACIAS);
				}
			}
			
			return lstTiposClaveSeguridadPermitidos;
			
		}else{//respuesta negativa	
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
	/** ********************************************************************
	 * @method ConsultarReferenciaTieneClaveSeguridad
	 * 		   Permite consultar si la refrencia control tiene clave de 
	 * 		   seguridad y que tipo de clave tiene
	 * @param  pObjUsuario
	 * 		   Usuario de la aplicacion
	 * @param  pObjFacturaGiro
	 * 		   objeto fatura giro
	 * @param  pHmListadoTiposClaveSeguridad
	 * 		   Listado de los tipos de token de validacion implementados
	 * @return boolean
	 * 		   Bandera que identifica si la factura presenta el servicio
	 * 		   incluido de token de validacion
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @author roberth.martinez
	 * @date   5/3/2016
	 * *********************************************************************
	 */
	public boolean consultarReferenciaTieneClaveSeguridad(Usuario pObjUsuario,
											  			 FacturaGiro pObjFacturaGiro,
											  			 HashMap<String,ClaveSeguridadDTO> pHmListadoTiposClaveSeguridad) throws Exception{
		
		/**
		 * [Trama 430 | Consultar referencia tiene control de clave de seguridad asignada]
		 */

		ConsultaReferenciaTieneClaveSeguridad objEnvioTrama;
		RespuestaConsultaReferenciaTieneClaveSeguridad objRespuestaTrama;
		boolean booContieneToken;
		
		objEnvioTrama = new ConsultaReferenciaTieneClaveSeguridad(pObjUsuario, 
															 	   pObjFacturaGiro,
															 	   pHmListadoTiposClaveSeguridad);
		
		//objRespuestaTrama = (RespuestaConsultaReferenciaTieneClaveSeguridad)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaConsultaReferenciaTieneClaveSeguridad)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
			
			booContieneToken = (pObjFacturaGiro.getObjClaveSeguridad()==null)?false:true;
			
		}else{
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
				   		 									 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
				   		 									 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
		
		return booContieneToken;
	}
	
	/** ********************************************************************
	 * @method verificarClaveSeguridad
	 * 		   Permite verificar si la clave ingresada corresponde a la clave
	 * 		   asignada a la transaccion
	 * @param  pObjUsuario
	 * 		   Usuario de la aplicacion
	 * @param  pObjFacturaGiro
	 * 		   objeto fatura giro
	 * @author roberth.martinez
	 * @return boolean
	 * 		   clave correcta true
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @date   7/3/2016
	 * *********************************************************************
	 */
	public boolean verificarClaveSeguridad(Usuario pObjUsuario,
										   FacturaGiro pObjFacturaGiro) throws Exception{
		
		/**
		 * [Trama 429 | verificar clave de seguridad]
		 */
		
		boolean booValida;
		VerificaClaveSeguridad objEnvioTrama;
		RespuestaVerificaClaveSeguridad objRespuestaTrama;
		
		objEnvioTrama = new VerificaClaveSeguridad(pObjUsuario, 
													   pObjFacturaGiro);
		
		//objRespuestaTrama = (RespuestaVerificaClaveSeguridad)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaVerificaClaveSeguridad)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {//respuesta positiva
			
			if(objRespuestaTrama.getValorAtributoObj("strEstadoProceso").toString().equalsIgnoreCase(EnumParametrosApp.SRV_ADI_CLV_SEG_CLAVE_CORRECTA.getValorPropiedad())){
			
				booValida = true;
			}else{
				
				booValida = false;
			}
		}else{//respuesta negativa	
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
		return booValida;
	}
	
}

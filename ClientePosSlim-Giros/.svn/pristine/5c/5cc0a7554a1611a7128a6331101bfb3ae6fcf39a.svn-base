/** 
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
package co.com.codesa.clienteposslimgiros.vista.logica;

import java.util.HashMap;
import java.util.List;

import co.com.codesa.clienteposslim.general.InformacionSession;
import co.com.codesa.clienteposslimcontrolador.conexion.ProcesadorTramas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.utilidades.vistaLogica.UtilVistaLogica;
import co.com.codesa.codesawrapper.modelo.dominio.BuscarParametros;
import co.com.codesa.codesawrapper.modelo.dominio.RespuestaBuscarParametros;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultarParametroSistema;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaActualizaNotasGiro;
import co.com.codesa.codesawrapper.modelo.dominio.ParametroSistema;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarParametroSistema;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;

public class ParametroSistemaVistaLogica {

	private static ParametroSistemaVistaLogica instancia ;
	
	private ParametroSistemaVistaLogica(){}	
	
	public static ParametroSistemaVistaLogica getInstance(){
		
		if (instancia == null){
			
			instancia= new ParametroSistemaVistaLogica();
		}
			
		return instancia;
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String,ParametroSistema> consultarParametrosBD(Usuario pObjUsuario,
																  List<String> pLstParametrosSolicitados)throws Exception{
		
		/**
		 * [Trama 132 | Consulta parametros del sistema : permite realizar la consulta de varios parametros del sistema
		 * sobre la misma peticion] 
		 */
		
		HashMap<String,ParametroSistema> hmParametrosSistema = null;
		ConsultarParametroSistema objEnvioTrama;
		RespuestaConsultarParametroSistema objRespuestaTrama;
		
		objEnvioTrama = new ConsultarParametroSistema(pObjUsuario,
													  pLstParametrosSolicitados);
		
		//objRespuestaTrama =(RespuestaConsultarParametroSistema) ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaConsultarParametroSistema)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
		
			hmParametrosSistema = (HashMap<String,ParametroSistema>)objRespuestaTrama.getValorAtributoObj("hmParametrosSistema");
			
		}else{//respuesta negativa
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
		
		return hmParametrosSistema;
	}
	
	/** 
	 * ********************************************************************
	 * @method	consultarParametrosGamble
	 * 		  	Metodo que permite consultar parametros del sistema GAMBLE
	 * 			para ser integrados bajo la misma logica y dinamica del 
	 * 			componente propuesto para tratar parametros de SIMS
	 * @param	pObjUsuario
	 * 			Usuario que se encuentra realizando la transaccion
	 * @param	pLstParametrosSolicitados
	 * 			Listado de parametros de sistema gamble a consultar
	 * @return	HashMap<String,ParametroSistema>
	 * 			Listado indexado de parametros de sistema gamble consultados
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	2/09/2017
	 * *********************************************************************
	 */
	@SuppressWarnings("unchecked")
	public HashMap<String,ParametroSistema> consultarParametrosGamble	(	Usuario pObjUsuario,
	                                                                 	 	List<String> pLstParametrosSolicitados
	                                                               		)
	                                                               				throws Exception
	{
		/**
		 * [Trama 9978 | Consulta parametros del sistema : permite realizar la consulta de varios parametros del sistema
		 * gamble sobre la misma peticion] 
		 */
		
		HashMap<String,ParametroSistema> hmParametrosSistema = null;
		
		BuscarParametros objEnvioTrama;
		RespuestaBuscarParametros objRespuestaTrama;
		String strDocumentoGamble;
		
		strDocumentoGamble	=	(pObjUsuario.getStrDocumentoGamble () == null)?InformacionSession.getInstance ().getDocumentoUsuario ():pObjUsuario.getStrDocumentoGamble ();
		
		objEnvioTrama = new BuscarParametros();
		objEnvioTrama.setDocumentoAsesorVenta ( strDocumentoGamble );
		objEnvioTrama.setlParametros ( pLstParametrosSolicitados );
		
		//objRespuestaTrama =(RespuestaBuscarParametros) ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaBuscarParametros)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributo("tipoRespuesta").equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
		
			//objRespuestaTrama.getListaObjetos("lparametros");
			hmParametrosSistema = (HashMap<String,ParametroSistema>)objRespuestaTrama.getValorAtributoObj("hmParametrosSistema");
			
		}else{//respuesta negativa
			
			hmParametrosSistema	=	new HashMap<String,ParametroSistema>();
			
			EnumMensajes.desplegarMensajePersonalizado	(	null, 
															EnumClasesMensaje.ERROR, 
															"POS_000",//(String)objRespuestaTrama.getValorAtributoObj("codigoError"),, 
															(String)objRespuestaTrama.getValorAtributo("mensajeError")
														);
		}
		
		return hmParametrosSistema;
	}
}

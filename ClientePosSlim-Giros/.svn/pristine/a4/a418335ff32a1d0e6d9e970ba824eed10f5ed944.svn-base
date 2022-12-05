/** 
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
package co.com.codesa.clienteposslimgiros.vista.logica;

import java.util.HashMap;

import co.com.codesa.clienteposslimcontrolador.conexion.ProcesadorTramas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.utilidades.vistaLogica.UtilVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultarDocuPend;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultarDocuPendOrigen;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarDatosEntidadesPorCodigoEntidad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DocPendiente;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarDocuPend;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarDocuPendOrigen;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;

/**
 * ****************************************************************.
 * @autor: CesarO.Rendon
 * @fecha: 19-mar-2015 
 * @descripcion: clase encargada de manejar el llamado a las tramas de
 * de agencias.
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class DocumentosPendientesVistaLogica {

	private static DocumentosPendientesVistaLogica instancia ;


	/**
	 * ****************************************************************.
	 * @metodo: AgenciaVistaLogica
	 * @descripcion: contructor de la logica.
	 * @autor: CesarO.Rendon
	 * ****************************************************************
	 */
	private DocumentosPendientesVistaLogica(){}	

	/**
	 * ****************************************************************.
	 * @metodo: getInstance
	 * @descripcion: metodo para cumplir con el patron singleton y tener
	 * una unica instancia de la clase para se accedida.
	 * @autor: CesarO.Rendon
	 * ****************************************************************
	 */
	public static DocumentosPendientesVistaLogica getInstance(){		
		if (instancia == null)
			instancia= new DocumentosPendientesVistaLogica();

		return instancia;
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, DocPendiente> consultarDocumentosPendientes(Usuario pObjUsuario, 
																	   Integer pObjIntTipoOperacion)throws Exception{
		/**
		 * [Trama 128 | Consultar documentos pendientes origen]
		 */									
		
		HashMap<String, DocPendiente> mtrObjDocumentos = null;
		ConsultarDocuPend objEnvioTrama;
		RespuestaConsultarDocuPend objRespuestaTrama;
		
		objEnvioTrama = new ConsultarDocuPend(pObjUsuario,
											  pObjIntTipoOperacion);
		
		//objRespuestaTrama = (RespuestaConsultarDocuPend)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaConsultarDocuPend)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
			
			mtrObjDocumentos=(HashMap<String, DocPendiente>) objRespuestaTrama.getValorAtributoObj("hmDocPend");
			
		}else{
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}

		return mtrObjDocumentos;
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, DocPendiente> consultarDocumentosPendientesOrigen(Usuario pObjUsuario, 
																			 Integer pObjIntTipoOperacion)throws Exception{
		/**
		 * [Trama 128 | Consultar documentos pendientes origen]
		 */
		
		HashMap<String, DocPendiente> mtrObjDocumentos = null;
		ConsultarDocuPendOrigen objEnvioTrama;
		RespuestaConsultarDocuPendOrigen objRespuestaTrama;
		
		objEnvioTrama = new ConsultarDocuPendOrigen(pObjUsuario,
													pObjIntTipoOperacion);
		
		//objRespuestaTrama = (RespuestaConsultarDocuPendOrigen)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaConsultarDocuPendOrigen)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
			
			mtrObjDocumentos=(HashMap<String, DocPendiente>) objRespuestaTrama.getValorAtributoObj("hmDocPend");
			
		}else{
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}

		return mtrObjDocumentos;
	}
	
}

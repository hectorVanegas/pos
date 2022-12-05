package co.com.codesa.clienteposslimgiros.vista.logica.Internacional.tercero;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.utilidades.vistaLogica.UtilVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultarTerceroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultarTiposDocumentosInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.CreaActualizaTerceroClienteInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.CreaActualizaTerceroUsuarioInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarTerceroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarTiposDocumentosInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaCreaActualizaTerceroClienteInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaCreaActualizaTerceroUsuarioInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ServicioPeticion;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TerceroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TipoDocumentoInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;

/** 
 * ********************************************************************
 * @class	TerceroInternacionalVistaLogica
 *		 	Clase encargada de manejar el llamado a las tramas relacionadas
 * 		   	con terceros de la funcionalidad de giros internacionales
 * @author	hector.cuenca
 * @date  	27/03/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class TerceroInternacionalVistaLogica {

	/**
	 * @variable instance
	 * 			 Referencia estatica de la clase utilitaria, clave para 
	 * 		 	 incorporar SINGLETON (patron de diseño)
	 **/
	private static TerceroInternacionalVistaLogica instance;

	/**
	 * ********************************************************************
	 * @method TerceroInternacionalVistaLogica
	 * 		   Metodo constructor que permite inicializar variables y
	 * 		   ejecutar comportamientos de interes
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
	 * 		   presentada 
	 * @author hector.cuenca
	 * @date   27/03/2018
	 * ********************************************************************
	 */
	private TerceroInternacionalVistaLogica() throws Exception {

	}

	/** 
	 * ********************************************************************
	 * @method getInstancia
	 * 		   Metodo clave para ejecutar el patron singleton sobre la 
	 * 		   clase, materializando esta por unica vez y manteniendo una 
	 * 		   sola instancia de esta
	 * @return TerceroInternacionalVistaLogica
	 * 		   Tipo referente a la misma clase
	 * @throws Exception
	 *		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author hector.cuenca
	 * @date   27/03/2018
	 * ********************************************************************
	 */
	public static TerceroInternacionalVistaLogica getInstancia()
			throws Exception {

		if (instance == null) {

			instance = new TerceroInternacionalVistaLogica();
		}

		return instance;
	}
	
	/** 
	 * ********************************************************************
	 * @method	consultaTiposDocumentosInternacional
	 * 		  	metodo para consultar los tipos de documentos en FPISA
	 * @param   pObjUsuario
	 * 			Objeto usuario de la aplicacion
	 * @param   pObjServicioPeticion
	 * 			Objeto ServicioPeticion, con los datos de la consulta a FPISA
	 * @return  List<TipoDocumentoInternacional>
	 * 		    Listado de tipos de documentos
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		    presentada
	 * @author	roberth.martinez
	 * @date	19/03/2018
	 * *********************************************************************
	 */
	@SuppressWarnings("unchecked")
	public List<TipoDocumentoInternacional> consultaTiposDocumentosInternacional(Usuario pObjUsuario,
   		  														   			  	 ServicioPeticion pObjServicioPeticion)throws Exception{
		
		/**
		* [Trama 508 | Consultar Tipos documentos internacionales]
		*/
		List<TipoDocumentoInternacional> lstTiposDocumento;
		ConsultarTiposDocumentosInternacional objEnvioTrama;
		RespuestaConsultarTiposDocumentosInternacional objRespuestaTrama;
		
		objEnvioTrama = new ConsultarTiposDocumentosInternacional(pObjUsuario, pObjServicioPeticion);
		
		objRespuestaTrama = (RespuestaConsultarTiposDocumentosInternacional)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
			
			lstTiposDocumento = (List<TipoDocumentoInternacional>) objRespuestaTrama.getValorAtributoObj("lstTiposDocumentosInternacional");
			Collections.sort(lstTiposDocumento,
	                new Comparator<TipoDocumentoInternacional>() {

	                    @Override
	                    public int compare(TipoDocumentoInternacional pO1,
	                    				   TipoDocumentoInternacional pO2) {
	                       
	                    	if (pO1.getValor() == null) {
	                            return -1;
	                        }
	                        if (pO2.getValor() == null) {
	                            return 1;
	                        }
	                        if (pO1.getValor().equals( pO2.getValor() )) {
	                            return 0;
	                        }
	                        return pO1.getValor().compareTo(pO2.getValor());
	                    }

	                });
			return lstTiposDocumento;
		
		}else{//respuesta negativa
		
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
															 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
															 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
	/**
	 * ********************************************************************
	 * @method	consultarTercero
	 * 		  	Metodo que permite consultar la informacion del tercero en
	 * 			FPISA
	 * @param   pObjUsuario
	 * 			Usuario que realiza la transaccion
	 * @param   pObjServicioPeticion
	 * 			Objeto que representa la peticion multiservicio utilizada
	 * 			para realizar la solicitud
	 * @param	pObjTercero
	 * 			Tercero remitido para consulta
	 * @param	pStrIdTransaccion
	 * 			Id de transaccion utilizado en el proceso
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		    presentada
	 * @author	hector.cuenca
	 * @date	3/04/2018
	 * *********************************************************************
	 */
	public void consultarTercero(	Usuario pObjUsuario,
   			  	 					ServicioPeticion pObjServicioPeticion,
   			  	 					TerceroInternacional pObjTercero,
   			  	 					String pStrIdTransaccion
   			  	 				)
		throws Exception
	{
		
		ConsultarTerceroInternacional objEnvioTrama;
		RespuestaConsultarTerceroInternacional objRespuestaTrama;
		
		objEnvioTrama = new ConsultarTerceroInternacional	(	pObjUsuario, 
																pObjServicioPeticion,
																pObjTercero,
																pStrIdTransaccion
															);
		
		objRespuestaTrama = (RespuestaConsultarTerceroInternacional)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if	(	objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())	) 
		{
			
		}	else	{//respuesta negativa
		
			throw EnumMensajes.generarExcepcionPersonalizada(	EnumClasesMensaje.ERROR, 
																(String)objRespuestaTrama.getValorAtributoObj("codigoError"),
																(String)objRespuestaTrama.getValorAtributoObj("descripcionError")
															);
		}
	}
	
	/**
	 * ********************************************************************
	 * @method	crearActualizarTerceroUsuario
	 * 		  	Metodo que permite crear o actualizar la informacion del 
	 * 			tercero usuario en FPISA
	 * @param   pObjUsuario
	 * 			Usuario que realiza la transaccion
	 * @param   pObjServicioPeticion
	 * 			Objeto que representa la peticion multiservicio utilizada
	 * 			para realizar la solicitud
	 * @param	pObjTercero
	 * 			Tercero remitido para crear o actualizar
	 * @param	pStrIdTransaccion
	 * 			Id de transaccion utilizado en el proceso
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		    presentada
	 * @author	roberth.martinez
	 * @date	06/04/2018
	 * *********************************************************************
	 */
	public void crearActualizarTerceroUsuario(	Usuario pObjUsuario,
   			  	 								ServicioPeticion pObjServicioPeticion,
   			  	 								TerceroInternacional pObjTercero,
   			  	 								String pStrIdTransaccion)
		throws Exception
	{
		
		CreaActualizaTerceroUsuarioInternacional objEnvioTrama;
		RespuestaCreaActualizaTerceroUsuarioInternacional objRespuestaTrama;
		
		objEnvioTrama = new CreaActualizaTerceroUsuarioInternacional	(	pObjUsuario, 
																	pObjServicioPeticion,
																	pObjTercero,
																	pStrIdTransaccion
																);
		
		objRespuestaTrama = (RespuestaCreaActualizaTerceroUsuarioInternacional)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if	(	objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())	) 
		{
			
		}	else	{//respuesta negativa
		
			throw EnumMensajes.generarExcepcionPersonalizada(	EnumClasesMensaje.ERROR, 
																(String)objRespuestaTrama.getValorAtributoObj("codigoError"),
																(String)objRespuestaTrama.getValorAtributoObj("descripcionError")
															);
		}
	}
	
	/**
	 * ********************************************************************
	 * @method	crearActualizarTerceroCliente
	 * 		  	Metodo que permite crear o actualizar la informacion del 
	 * 			tercero cliente en FPISA
	 * @param   pObjUsuario
	 * 			Usuario que realiza la transaccion
	 * @param   pObjServicioPeticion
	 * 			Objeto que representa la peticion multiservicio utilizada
	 * 			para realizar la solicitud
	 * @param	pObjTercero
	 * 			Tercero remitido para crear o actualizar
	 * @param	pStrIdTransaccion
	 * 			Id de transaccion utilizado en el proceso
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		    presentada
	 * @author	roberth.martinez
	 * @date	06/04/2018
	 * *********************************************************************
	 */
	public void crearActualizarTerceroCliente(	Usuario pObjUsuario,
   			  	 								ServicioPeticion pObjServicioPeticion,
   			  	 								TerceroInternacional pObjTercero,
   			  	 								String pStrIdTransaccion)
		throws Exception
	{
		
		CreaActualizaTerceroClienteInternacional objEnvioTrama;
		RespuestaCreaActualizaTerceroClienteInternacional objRespuestaTrama;
		
		objEnvioTrama = new CreaActualizaTerceroClienteInternacional(	pObjUsuario, 
																		pObjServicioPeticion,
																		pObjTercero,
																		pStrIdTransaccion
																	);
		
		objRespuestaTrama = (RespuestaCreaActualizaTerceroClienteInternacional)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if	(	objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())	) 
		{
			
		}	else	{//respuesta negativa
		
			throw EnumMensajes.generarExcepcionPersonalizada(	EnumClasesMensaje.ERROR, 
																(String)objRespuestaTrama.getValorAtributoObj("codigoError"),
																(String)objRespuestaTrama.getValorAtributoObj("descripcionError")
															);
		}
	}
	
}

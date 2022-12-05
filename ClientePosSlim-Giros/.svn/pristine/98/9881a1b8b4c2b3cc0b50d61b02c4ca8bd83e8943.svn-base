/** 
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
package co.com.codesa.clienteposslimgiros.vista.logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.enumeraciones.operaciones.EnumTiposOperaciones;
import co.com.codesa.clienteposslimgiros.enumeraciones.proveedorServicioProducto.EnumTiposServicios;
import co.com.codesa.clienteposslimgiros.utilidades.conceptos.UtilConceptos;
import co.com.codesa.clienteposslimgiros.utilidades.proveedorServicioProducto.UtilProveedorServicioProductoGiros;
import co.com.codesa.clienteposslimgiros.utilidades.vistaLogica.UtilVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.AnularProtegiroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultarActividadesEconomicasInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultarCorresponsalesInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultarGiroBeneficiarioInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultarGiroReferenciaInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultarNumeralesEnvioInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultarNumeralesInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultarOperacionesInusualesInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultarPaisesEnvioInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultarProfesionesInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultarSenalesAlertaInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultarTiposMotivosGirosInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.CotizarGiroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.EnvioGiroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.OpcionEnvioInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.PagoGiroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.PaisesEnvioGirosInternacionales;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaAnularProtegiroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarActividadesEconomicasInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarCorresponsalesInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarGiroBeneficiarioInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarGiroReferenciaInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarNumeralesEnvioInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarNumeralesInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarPaisesEnvioInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarProfesionesInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarSenalesAlertaInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarTiposMotivosGirosInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaCotizarEnvioGiroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaEnvioGiroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaPagoGiroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaRegistrarOperacionInusual;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.TipoVinculoInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ActividadEconomicaInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Concepto;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Corresponsal;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.NumeralInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.OperacionInusualInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ProfesionInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.SenalAlertaInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ServicioPeticion;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TipoDocumentoInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TipoMotivoGiroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.bnet.ProveedorServicioProductoGirosDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionPagoGiroInternacionalDTO;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.giros.EnumTiposIdentificadorConcepto;

/** 
 * ********************************************************************
 * @class  GiroInternacionalVistaLogica
 *		   clase encargada de manejar el llamado a las tramas de giros 
 *		   internacionales
 * @author roberth.martinez
 * @date   14/03/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class GiroInternacionalVistaLogica {

	/**
	 * @variable instance
	 * 			 Referencia estatica de la clase utilitaria, clave para 
	 * 		 	 incorporar SINGLETON (patron de diseño)
	 **/
	private static GiroInternacionalVistaLogica instance;

	/**
	 * ********************************************************************
	 * @method GiroInternacionalVistaLogica
	 * 		   Metodo constructor que permite inicializar variables y
	 * 		   ejecutar comportamientos de interes
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
	 * 		   presentada 
	 * @author hector.cuenca
	 * @date   22/03/2018
	 * ********************************************************************
	 */
	private GiroInternacionalVistaLogica() throws Exception {

	}

	/** 
	 * ********************************************************************
	 * @method getInstancia
	 * 		   Metodo clave para ejecutar el patron singleton sobre la 
	 * 		   clase, materializando esta por unica vez y manteniendo una 
	 * 		   sola instancia de esta
	 * @return GiroInternacionalVistaLogica
	 * 		   Tipo referente a la misma clase
	 * @throws Exception
	 *		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author hector.cuenca
	 * @date   22/03/2018
	 * ********************************************************************
	 */
	public static GiroInternacionalVistaLogica getInstancia() throws Exception {

		if (instance == null) {

			instance = new GiroInternacionalVistaLogica();
		}

		return instance;
	}
	
	/** 
	 * ********************************************************************
	 * @method	consultaCorresponsalesInternacional
	 * 		  	metodo para consultar los corresponsales en FPISA
	 * @param   pObjUsuario
	 * 			Objeto usuario de la aplicacion
	 * @param   pObjServicioPeticion
	 * 			Objeto ServicioPeticion, con los datos de la consulta a FPISA
	 * @return  List<Corresponsal>
	 * 		    Listado de corresponsales
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		    presentada
	 * @author	roberth.martinez
	 * @date	19/03/2018
	 * *********************************************************************
	 */
	public List<Corresponsal> consultaCorresponsalesInternacional(Usuario pObjUsuario,
												 	    		  ServicioPeticion pObjServicioPeticion)throws Exception{
		/**
		 * [Trama 508 | Consultar Corresponsales internacionales]
		 */
		List<Corresponsal> lstCorresponsales;
		ConsultarCorresponsalesInternacional objEnvioTrama;
		RespuestaConsultarCorresponsalesInternacional objRespuestaTrama;

		objEnvioTrama = new ConsultarCorresponsalesInternacional(pObjUsuario, pObjServicioPeticion);

		objRespuestaTrama = (RespuestaConsultarCorresponsalesInternacional)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
			lstCorresponsales = (List<Corresponsal>) objRespuestaTrama.getValorAtributoObj("lstCorresponsales");
			
			Collections.sort(lstCorresponsales,
	                new Comparator<Corresponsal>() {

	                    @Override
	                    public int compare(Corresponsal pO1,
	                            		   Corresponsal pO2) {
	                       
	                    	if (pO1.getStrNombre() == null) {
	                            return -1;
	                        }
	                        if (pO2.getStrNombre() == null) {
	                            return 1;
	                        }
	                        if (pO1.getStrNombre().equals( pO2.getStrNombre() )) {
	                            return 0;
	                        }
	                        return pO1.getStrNombre().compareTo(pO2.getStrNombre());
	                    }

	                });
			
			
			return lstCorresponsales;
			
			
		}else{//respuesta negativa

			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}

	}
	
	/** 
	 * ********************************************************************
	 * @method	consultaActividadesEconomicasInternacional
	 * 		  	metodo para consultar los actividades economicas en FPISA
	 * @param   pObjUsuario
	 * 			Objeto usuario de la aplicacion
	 * @param   pObjServicioPeticion
	 * 			Objeto ServicioPeticion, con los datos de la consulta a FPISA
	 * @return  List<ActividadEconomicaInternacional>
	 * 		    Listado de actividades economicas
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		    presentada
	 * @author	roberth.martinez
	 * @date	19/03/2018
	 * *********************************************************************
	 */
	public List<ActividadEconomicaInternacional> consultaActividadesEconomicasInternacional(Usuario pObjUsuario,
   			  	 																			ServicioPeticion pObjServicioPeticion)throws Exception{

		/**
		* [Trama 508 | Consultar Tipos documentos internacionales]
		*/
		
		List<ActividadEconomicaInternacional> lstActividadesEconomicas;
		ConsultarActividadesEconomicasInternacional objEnvioTrama;
		RespuestaConsultarActividadesEconomicasInternacional objRespuestaTrama;
		
		objEnvioTrama = new ConsultarActividadesEconomicasInternacional(pObjUsuario, pObjServicioPeticion);
		
		objRespuestaTrama = (RespuestaConsultarActividadesEconomicasInternacional)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
		
			lstActividadesEconomicas = (List<ActividadEconomicaInternacional>) objRespuestaTrama.getValorAtributoObj("lstActividadesEconomicasInternacional");
			
			Collections.sort(lstActividadesEconomicas,
	                new Comparator<ActividadEconomicaInternacional>() {

	                    @Override
	                    public int compare(ActividadEconomicaInternacional pO1,
	                    				   ActividadEconomicaInternacional pO2) {
	                       
	                    	if (pO1.getDescripcion() == null) {
	                            return -1;
	                        }
	                        if (pO2.getDescripcion() == null) {
	                            return 1;
	                        }
	                        if (pO1.getDescripcion().equals( pO2.getDescripcion() )) {
	                            return 0;
	                        }
	                        return pO1.getDescripcion().compareTo(pO2.getDescripcion());
	                    }

	                });
			return lstActividadesEconomicas;
		
		}else{//respuesta negativa
		
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
															 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
															 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
	
	/** 
	 * ********************************************************************
	 * @method	consultaActividadesEconomicasInternacional
	 * 		  	metodo para consultar los actividades economicas en FPISA
	 * @param   pObjUsuario
	 * 			Objeto usuario de la aplicacion
	 * @param   pObjServicioPeticion
	 * 			Objeto ServicioPeticion, con los datos de la consulta a FPISA
	 * @param	pStrReferencia
	 * 			referencia del giro a consultar
	 * @param	pObjCorresponsal
	 * 			objeto Corresponsal
	 * @param	pObjTipoDocumentoInternacional
	 * 			objeto tipo documento del beneficiario
	 * @param	pStrDocumento
	 * 			numero de cocumento del beneficiario
	 * @return  FacturaGiroInternacional
	 * 		    FacturaGiroInternacional con los datos de la factura
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		    presentada
	 * @author	roberth.martinez
	 * @date	19/03/2018
	 * *********************************************************************
	 */
	public FacturaGiroInternacional consultarGiroXReferencia(Usuario pObjUsuario,
   			  	 											 ServicioPeticion pObjServicioPeticion,
   				                                             String pStrReferencia,
   				                                             Corresponsal pObjCorresponsal,
   				                                             TipoDocumentoInternacional pObjTipoDocumentoInternacional,
   				                                             String pStrDocumento)throws Exception{

		/**
		* [Trama 508 | Consultar giro por referncia internacional]
		*/
		
		ConsultarGiroReferenciaInternacional objEnvioTrama;
		RespuestaConsultarGiroReferenciaInternacional objRespuestaTrama;
		
		objEnvioTrama = new ConsultarGiroReferenciaInternacional(pObjUsuario, 
																 pObjServicioPeticion,
																 pStrReferencia, 
																 pObjCorresponsal,
																 pObjTipoDocumentoInternacional,
																 pStrDocumento);
		
		objRespuestaTrama = (RespuestaConsultarGiroReferenciaInternacional)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
		
			return (FacturaGiroInternacional) objRespuestaTrama.getValorAtributoObj("objFacturaGiroInternacional");
		
		}else{//respuesta negativa
		
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
															 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
															 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
	public FacturaGiroInternacional cotizarGiroInternacional(Usuario pObjUsuario,
																				ServicioPeticion pObjServicioPeticion,
																				TipoDocumentoInternacional pObjTipoDocumentoRemi,
																				String pStrNumDocumentoRemi,
																				OpcionEnvioInternacional pObjOpcionEnvio,
																				PaisesEnvioGirosInternacionales pObjPaisEnvio,
																				String pStrMonto) throws Exception{
		
		/**
		* [Trama 508 | Cotizar Giro Internacional]
		*/
		
		CotizarGiroInternacional objEnvioTrama;
		RespuestaCotizarEnvioGiroInternacional objRespuestaTrama;
		String strMonto = pStrMonto.replace(",", "");
		
		objEnvioTrama = new CotizarGiroInternacional(pObjUsuario, 
													 pObjServicioPeticion, 
													 pObjTipoDocumentoRemi, 
													 pStrNumDocumentoRemi, 
													 pObjOpcionEnvio, 
													 pObjPaisEnvio, 
													 strMonto);
		
		objRespuestaTrama = (RespuestaCotizarEnvioGiroInternacional) UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if(objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equals(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())){
			
			return (FacturaGiroInternacional)objRespuestaTrama.getValorAtributoObj("objResCotiGiroInter");
			
		}else{ //respuesta negativa
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
			
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	consultaActividadesEconomicasInternacional
	 * 		  	metodo para consultar los actividades economicas en FPISA
	 * @param   pObjUsuario
	 * 			Objeto usuario de la aplicacion
	 * @param   pObjServicioPeticion
	 * 			Objeto ServicioPeticion, con los datos de la consulta a FPISA
	 * @param	pObjTerceroRem
	 * 			objeto tercero remitente
	 * @param	pObjTerceroBen
	 * 			objeto tercero beneficiario
	 * @return  FacturaGiroInternacional
	 * 		    FacturaGiroInternacional con los datos de la factura
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		    presentada
	 * @author	roberth.martinez
	 * @date	28/03/2018
	 * *********************************************************************
	 */
	public List<FacturaGiroInternacional> consultarGiroXBeneficiario(Usuario pObjUsuario,
   			  	 											   		 ServicioPeticion pObjServicioPeticion,
   			  	 											   		 Tercero pObjTerceroRem,
   			  	 											   		 Tercero pObjTerceroBen)throws Exception{

		/**
		* [Trama 508 | Consultar giro por beneficiario internacional]
		*/
		
		ConsultarGiroBeneficiarioInternacional objEnvioTrama;
		RespuestaConsultarGiroBeneficiarioInternacional objRespuestaTrama;
		
		objEnvioTrama = new ConsultarGiroBeneficiarioInternacional(pObjUsuario, 
																   pObjServicioPeticion,
																   pObjTerceroRem, 
																   pObjTerceroBen);
		
		objRespuestaTrama = (RespuestaConsultarGiroBeneficiarioInternacional)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
		
			return (List<FacturaGiroInternacional>) objRespuestaTrama.getValorAtributoObj("lstFacturaGiroInternacional");
		
		}else{//respuesta negativa
		
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
															 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
															 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}

	/** 
	 * ********************************************************************
	 * @method	consultaTiposMotivosGirosInternacional
	 * 		  	metodo para consultar los tipos Motivos giros en FPISA
	 * @param   pObjUsuario
	 * 			Objeto usuario de la aplicacion
	 * @param   pObjServicioPeticion
	 * 			Objeto ServicioPeticion, con los datos de la consulta a FPISA
	 * @return  List<TipoMotivoGiro>
	 * 		    Listado de tipos Motivos Giros
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		    presentada
	 * @author	roberth.martinez
	 * @date	19/03/2018
	 * *********************************************************************
	 */
	@SuppressWarnings("unchecked")
	public List<TipoMotivoGiroInternacional> consultaTiposMotivosGirosInternacional(Usuario pObjUsuario,
   			  	 													   				ServicioPeticion pObjServicioPeticion)throws Exception{

		/**
		* [Trama 508 | Consultar Tipos motivos giros internacionales]
		*/
		
		ConsultarTiposMotivosGirosInternacional objEnvioTrama;
		RespuestaConsultarTiposMotivosGirosInternacional objRespuestaTrama;
		List<TipoMotivoGiroInternacional> lstTiposMotivoGiroInternacional;
		
		objEnvioTrama = new ConsultarTiposMotivosGirosInternacional(pObjUsuario, pObjServicioPeticion);
		
		objRespuestaTrama = (RespuestaConsultarTiposMotivosGirosInternacional)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
			
			lstTiposMotivoGiroInternacional = (List<TipoMotivoGiroInternacional>) objRespuestaTrama.getValorAtributoObj("lstTiposMotivosGiros");
			
			Collections.sort(lstTiposMotivoGiroInternacional,
	                new Comparator<TipoMotivoGiroInternacional>() {

	                    @Override
	                    public int compare(TipoMotivoGiroInternacional pO1,
	                    				   TipoMotivoGiroInternacional pO2) {
	                       
	                    	if (pO1.getStrNombre() == null) {
	                            return -1;
	                        }
	                        if (pO2.getStrNombre() == null) {
	                            return 1;
	                        }
	                        if (pO1.getStrNombre().equals( pO2.getStrNombre() )) {
	                            return 0;
	                        }
	                        return pO1.getStrNombre().compareTo(pO2.getStrNombre());
	                    }

	                });
			
			
			return lstTiposMotivoGiroInternacional;
		
		}else{//respuesta negativa
		
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
															 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
															 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	consultaNumeralesInternacional
	 * 		  	metodo para consultar los numerales pago en FPISA
	 * @param   pObjUsuario
	 * 			Objeto usuario de la aplicacion
	 * @param   pObjServicioPeticion
	 * 			Objeto ServicioPeticion, con los datos de la consulta a FPISA
	 * @param   pObjTipoMotivoGiroInternacional
	 * 			objeto TipoMotivoGiroInternacional para buscar los numerales 
	 * 			de ese motivo
	 * @return  List<NumeralInternacional>
	 * 		    Listado de numerales
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		    presentada
	 * @author	roberth.martinez
	 * @date	26/03/2018
	 * *********************************************************************
	 */
	@SuppressWarnings("unchecked")
	public List<NumeralInternacional> consultaNumeralesInternacional(Usuario pObjUsuario,
   			  	 													 ServicioPeticion pObjServicioPeticion,
   			  	 													 TipoMotivoGiroInternacional pObjTipoMotivoGiroInternacional)throws Exception{

		/**
		* [Trama 508 | Consultar numerales internacionales]
		*/
		
		ConsultarNumeralesInternacional objEnvioTrama;
		RespuestaConsultarNumeralesInternacional objRespuestaTrama;
		
		objEnvioTrama = new ConsultarNumeralesInternacional(pObjUsuario, 
															pObjServicioPeticion, 
															pObjTipoMotivoGiroInternacional);
		
		objRespuestaTrama = (RespuestaConsultarNumeralesInternacional)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
		
			return (List<NumeralInternacional>) objRespuestaTrama.getValorAtributoObj("lstNumerales");
		
		}else{//respuesta negativa
		
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
															 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
															 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	consultaSenalesAlerta
	 * 		  	metodo para consultar las senales alerta
	 * @param   pObjUsuario
	 * 			Objeto usuario de la aplicacion
	 * @param   pObjServicioPeticion
	 * 			Objeto ServicioPeticion, con los datos de la consulta a FPISA
	 * @return  List<SenalAlertaInternacional>
	 * 		    Listado de senales alerta
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		    presentada
	 * @author	roberth.martinez
	 * @date	02/04/2018
	 * *********************************************************************
	 */
	@SuppressWarnings("unchecked")
	public List<SenalAlertaInternacional> consultaSenalesAlerta(Usuario pObjUsuario,
   			  	 												ServicioPeticion pObjServicioPeticion)throws Exception{

		/**
		* [Trama 508 | Consultar senales alerta internacionales]
		*/
		List<SenalAlertaInternacional> lstSenalesAlertaInternacional;
		ConsultarSenalesAlertaInternacional objEnvioTrama;
		RespuestaConsultarSenalesAlertaInternacional objRespuestaTrama;
		
		objEnvioTrama = new ConsultarSenalesAlertaInternacional(pObjUsuario, pObjServicioPeticion);
		
		objRespuestaTrama = (RespuestaConsultarSenalesAlertaInternacional)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
		
			lstSenalesAlertaInternacional = (List<SenalAlertaInternacional>) objRespuestaTrama.getValorAtributoObj("lstSenalesAlertaInternacional");
			Collections.sort(lstSenalesAlertaInternacional,
	                new Comparator<SenalAlertaInternacional>() {

	                    @Override
	                    public int compare(SenalAlertaInternacional pO1,
	                    				   SenalAlertaInternacional pO2) {
	                       
	                    	if (pO1.getStrNombre() == null) {
	                            return -1;
	                        }
	                        if (pO2.getStrNombre() == null) {
	                            return 1;
	                        }
	                        if (pO1.getStrNombre().equals( pO2.getStrNombre() )) {
	                            return 0;
	                        }
	                        return pO1.getStrNombre().compareTo(pO2.getStrNombre());
	                    }

	                });
			
			return lstSenalesAlertaInternacional;
		
		}else{//respuesta negativa
		
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
															 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
															 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	consultaProfesionesInternacional
	 * 		  	metodo para consultar las profesiones en FPISA
	 * @param   pObjUsuario
	 * 			Objeto usuario de la aplicacion
	 * @param   pObjServicioPeticion
	 * 			Objeto ServicioPeticion, con los datos de la consulta a FPISA
	 * @return  List<ProfesionInternacional>
	 * 		    Listado de profesiones
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		    presentada
	 * @author	roberth.martinez
	 * @date	24/04/2018
	 * *********************************************************************
	 */
	public List<ProfesionInternacional> consultaProfesionesInternacional(Usuario pObjUsuario,
												 	    		  		 ServicioPeticion pObjServicioPeticion)throws Exception{
		/**
		 * [Trama 508 | Consultar Profesiones internacionales]
		 */
		List<ProfesionInternacional> lstProfesiones;
		ConsultarProfesionesInternacional objEnvioTrama;
		RespuestaConsultarProfesionesInternacional objRespuestaTrama;

		objEnvioTrama = new ConsultarProfesionesInternacional(pObjUsuario, pObjServicioPeticion);

		objRespuestaTrama = (RespuestaConsultarProfesionesInternacional)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
			lstProfesiones = (List<ProfesionInternacional>) objRespuestaTrama.getValorAtributoObj("lstProfesionesInternacional");
			
			Collections.sort(lstProfesiones,
	                new Comparator<ProfesionInternacional>() {

	                    @Override
	                    public int compare(ProfesionInternacional pO1,
	                    		ProfesionInternacional pO2) {
	                       
	                    	if (pO1.getStrNombre() == null) {
	                            return -1;
	                        }
	                        if (pO2.getStrNombre() == null) {
	                            return 1;
	                        }
	                        if (pO1.getStrNombre().equals( pO2.getStrNombre() )) {
	                            return 0;
	                        }
	                        return pO1.getStrNombre().compareTo(pO2.getStrNombre());
	                    }

	                });
			
			
			return lstProfesiones;
			
			
		}else{//respuesta negativa

			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}

	}
	
	/** 
	 * ********************************************************************
	 * @method	consultarNumeralesEnvio
	 * 		  	metodo para consultar los numerales en FPISA
	 * @param   pObjUsuario
	 * 			Objeto usuario de la aplicacion
	 * @param   pObjServicioPeticion
	 * 			Objeto ServicioPeticion, con los datos de la consulta a FPISA
	 * @return  List<NumeralesEnvioInternacional>
	 * 		    Listado de numerales
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		    presentada
	 * @author	didier.silva
	 * @date	03/05/2018
	 * *********************************************************************
	 */
	public List<NumeralInternacional> consultarNumeralesEnvio(Usuario pObjUsuario,
												 	    		  		 ServicioPeticion pObjServicioPeticion)throws Exception{
		/**
		 * [Trama 508 | Consultar Profesiones internacionales]
		 */
		List<NumeralInternacional> lstNumerales;
		ConsultarNumeralesEnvioInternacional objEnvioTrama;
		RespuestaConsultarNumeralesEnvioInternacional objRespuestaTrama;

		objEnvioTrama = new ConsultarNumeralesEnvioInternacional(pObjUsuario, pObjServicioPeticion);

		objRespuestaTrama = (RespuestaConsultarNumeralesEnvioInternacional)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
			lstNumerales = (List<NumeralInternacional>) objRespuestaTrama.getValorAtributoObj("lstNumeralesEnvio");
			
			Collections.sort(lstNumerales,
	                new Comparator<NumeralInternacional>() {

	                    @Override
	                    public int compare(NumeralInternacional pO1,
	                    		NumeralInternacional pO2) {
	                       
	                    	if (pO1.getStrNombre() == null) {
	                            return -1;
	                        }
	                        if (pO2.getStrNombre() == null) {
	                            return 1;
	                        }
	                        if (pO1.getStrNombre().equals( pO2.getStrNombre() )) {
	                            return 0;
	                        }
	                        return pO1.getStrNombre().compareTo(pO2.getStrNombre());
	                    }

	                });
			
			
			return lstNumerales;
			
			
		}else{//respuesta negativa

			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}

	}
	
	/** 
	 * ********************************************************************
	 * @method	PagarGiro
	 * 		  	metodo para pagar giro internacional
	 * @param   pObjUsuario
	 * 			Objeto usuario de la aplicacion
	 * @param   pObjServicioPeticion
	 * 			Objeto ServicioPeticion, con los datos de la transaccion a FPISA
	 * @param 	pObjFacturaGiroInternacional
	 * 			objeto factura giro, con los datos a enviar
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		    presentada
	 * @author	roberth.martinez
	 * @date	04/04/2018
	 * *********************************************************************
	 */
	public void pagarGiro(Usuario pObjUsuario,
   			  	 		  ServicioPeticion pObjServicioPeticion,
   			  	 		  FacturaGiroInternacional pObjFacturaGiroInternacional)throws Exception{

		/**
		* [Trama 508 | Realizar Pago Giro internacional]
		*/
		Concepto objConceptoSeguro;
		PagoGiroInternacional objEnvioTrama;
		RespuestaPagoGiroInternacional objRespuestaTrama;
		ProveedorServicioProductoGirosDTO objDtoProveedorServicioProducto;
		ProveedorServicioProductoGirosDTO objDtoProveedorServicioProductoProtegiro;
				
		objDtoProveedorServicioProducto = UtilProveedorServicioProductoGiros.getInstance().validarProveedorServicioProductoXTipoServicio(EnumTiposServicios.PAGO_GIRO_INTERNACIONAL,
																																		 pObjUsuario,
																																		 EnumTiposOperaciones.PAGO_FACTURACION_GIRO_INTERNACIONAL);
		
		UtilConceptos.getInstance().gestionarConceptosYMediosPago	(	pObjFacturaGiroInternacional,
																		EnumParametrosSistema.CODIGO_CONCEPTO_PAGO_GIRO_INTERNACIONAL, 
																		EnumTiposIdentificadorConcepto.CODIGO);
		if(pObjFacturaGiroInternacional.getStrProtegiroInducido().equals("S")){
		
			objDtoProveedorServicioProductoProtegiro = UtilProveedorServicioProductoGiros.getInstance().validarProveedorServicioProductoXTipoServicio(EnumTiposServicios.PROTEGIRO_INTERNACIONAL,
																																					  pObjUsuario,
																																					  EnumTiposOperaciones.PROTEGIRO_INTERNACIONAL);

			
			objConceptoSeguro	=	UtilConceptos.getInstance().generarConcepto	(
																					EnumParametrosSistema.CODIGO_CONCEPTO_PROTEGIRO_INTERNACIONAL, 
																					EnumTiposIdentificadorConcepto.CODIGO,
																					Concepto.AFECTA_CAJA);
			
			pObjFacturaGiroInternacional.getListaConceptos().get(0).setValor(pObjFacturaGiroInternacional.getTotal()-pObjFacturaGiroInternacional.getDouValorPrima());
			objConceptoSeguro.setValor(pObjFacturaGiroInternacional.getDouValorPrima());
			pObjFacturaGiroInternacional.getListaConceptos().add(objConceptoSeguro);
			
			objEnvioTrama = new PagoGiroInternacional(pObjUsuario, 
													  pObjServicioPeticion, 
													  pObjFacturaGiroInternacional,
													  objDtoProveedorServicioProducto,
													  objDtoProveedorServicioProductoProtegiro);
			
		}else{
			objEnvioTrama = new PagoGiroInternacional(pObjUsuario, 
													  pObjServicioPeticion, 
													  pObjFacturaGiroInternacional,
													  objDtoProveedorServicioProducto);
		}
		
		
		objRespuestaTrama = (RespuestaPagoGiroInternacional)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())) {
		
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					 										 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					 										 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
	public void envioGiro(Usuario pObjUsuario,
					 	  ServicioPeticion pObjServicioPeticion,
					 	  FacturaGiroInternacional pObjFacturaEnvioGiroInternacional) throws Exception{
		
		/**
		* [Trama 508 | Realizar Envio Giro internacional]
		*/
		EnvioGiroInternacional objEnvioTrama;
		RespuestaEnvioGiroInternacional objRespuestaTrama;
		ProveedorServicioProductoGirosDTO objDtoProveedorServicioProducto;
		
		objDtoProveedorServicioProducto = UtilProveedorServicioProductoGiros.getInstance().validarProveedorServicioProductoXTipoServicio(EnumTiposServicios.ENVIO_GIRO_INTERNACIONAL,
																																		 pObjUsuario,
																																		 EnumTiposOperaciones.ENVIO_FACTURACION_GIRO_INTERNACIONAL);
		
		UtilConceptos.getInstance().gestionarConceptosYMediosPago	(	pObjFacturaEnvioGiroInternacional,
																		EnumParametrosSistema.ID_CONCEPTO_ENVIO_GIRO_INTERNACIONAL, 
																		EnumTiposIdentificadorConcepto.ID);
		
		objEnvioTrama = new EnvioGiroInternacional(pObjUsuario, 
												  pObjServicioPeticion, 
												  pObjFacturaEnvioGiroInternacional,
												  objDtoProveedorServicioProducto);

		objRespuestaTrama = (RespuestaEnvioGiroInternacional)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())) {

			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
							 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
							 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
	public String registrarOperacionInusual(Usuario pObjUsuario,
										  ServicioPeticion pObjServicioPeticion,
										  OperacionInusualInternacional pObjOperInusualInter) throws Exception {
		
		/**
		* [Trama 508 | Registrar operacion inusual internacional]
		*/
		ConsultarOperacionesInusualesInternacional objEnvioTrama;
		RespuestaRegistrarOperacionInusual objRespuestaTrama;
		
		
		objEnvioTrama = new ConsultarOperacionesInusualesInternacional(pObjUsuario, 
																	   pObjServicioPeticion, 
																	   pObjOperInusualInter);
		
		objRespuestaTrama = (RespuestaRegistrarOperacionInusual) UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {

			return objRespuestaTrama.getStrRespuestaRegistroOperInusual();
			
		} else {
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	consultaPaisesEnvioInternacional
	 * 		  	metodo para consultar los paises de envio en FPISA
	 * @param   pObjUsuario
	 * 			Objeto usuario de la aplicacion
	 * @param   pObjServicioPeticion
	 * 			Objeto ServicioPeticion, con los datos de la consulta a FPISA
	 * @return  List<PaisesEnvioGirosInternacionales>
	 * 		    Listado de paises
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		    presentada
	 * @author	didier.silva
	 * @date	28/04/2018
	 * *********************************************************************
	 */
	public List<PaisesEnvioGirosInternacionales> consultaPaisesEnvioInternacional(Usuario pObjUsuario,
   		  																		  ServicioPeticion pObjServicioPeticion)throws Exception{
	/**
	* [Trama 508 | Consultar Corresponsales internacionales]
	*/
	List<PaisesEnvioGirosInternacionales> lstPaisesEnvio;
	ConsultarPaisesEnvioInternacional objEnvioTrama;
	RespuestaConsultarPaisesEnvioInternacional objRespuestaTrama;
	
	objEnvioTrama = new ConsultarPaisesEnvioInternacional(pObjUsuario, pObjServicioPeticion);
	
	objRespuestaTrama = (RespuestaConsultarPaisesEnvioInternacional)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
	
	if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
		lstPaisesEnvio = (List<PaisesEnvioGirosInternacionales>) objRespuestaTrama.getValorAtributoObj("lstPaisesEnvio");
	
		Collections.sort(lstPaisesEnvio,
				new Comparator<PaisesEnvioGirosInternacionales>() {
	
			@Override
			public int compare(PaisesEnvioGirosInternacionales pO1,
					PaisesEnvioGirosInternacionales pO2) {
	
				if (pO1.getStrNombrepais() == null) {
					return -1;
				}
				if (pO2.getStrNombrepais() == null) {
					return 1;
				}
				if (pO1.getStrNombrepais().equals( pO2.getStrNombrepais() )) {
					return 0;
				}
				return pO1.getStrNombrepais().compareTo(pO2.getStrNombrepais());
			}
	
		});
	
	
		return lstPaisesEnvio;
	
	
		}else{//respuesta negativa
	
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					(String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					(String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}

	}
	
	
	public List<TipoVinculoInternacional> ordenarTiposVinculoInternacional(List<TipoVinculoInternacional> listaTipoVinculo)throws Exception{
		
		/**
		* [Trama 508 | Consultar Corresponsales internacionales]
		*/
		
		List<TipoVinculoInternacional> lstTiposVinculo = new ArrayList<TipoVinculoInternacional>();
		
		Collections.sort(listaTipoVinculo,
		new Comparator<TipoVinculoInternacional>() {
		
		@Override
		public int compare(TipoVinculoInternacional pO1,
				TipoVinculoInternacional pO2) {
		
		if (pO1.getStrDescripcion() == null) {
		return -1;
		}
		if (pO2.getStrDescripcion() == null) {
		return 1;
		}
		if (pO1.getStrDescripcion().equals( pO2.getStrDescripcion() )) {
		return 0;
		}
		return pO1.getStrDescripcion().compareTo(pO2.getStrDescripcion());
		}
		
		});
		
		
		return listaTipoVinculo;

	}
	
	
	/** 
	 * ********************************************************************
	 * @method	anularProtegiroInternacional
	 * 		  	metodo para anular el protegiro internacional
	 * @param   pObjUsuario
	 * 			Objeto usuario de la aplicacion
	 * @param   pStrReferenciaSeguro
	 * 			referencia del giro
	 * @param 	pStrVlrGiroRemesa
	 * 			valor del giro remesa
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		    presentada
	 * @return  String
	 * 			respuesta de la tramna de anulacion
	 * @author	roberth.martinez
	 * @date	30/04/2018
	 * *********************************************************************
	 */
	public String anularProtegiroInternacional(Usuario pObjUsuario,
   			  	 		  					   String pStrReferenciaSeguro,
   			  	 		  					   String pStrVlrGiroRemesa)throws Exception{

		/**
		* [Trama 529 | Realizar anulacion del protegiro internacional]
		*/
		AnularProtegiroInternacional objEnvioTrama;
		RespuestaAnularProtegiroInternacional objRespuestaTrama;
		ProveedorServicioProductoGirosDTO objDtoProveedorServicioProductoGiro;
		FacturaGiroInternacional objFacturaInternacional;
		
		objFacturaInternacional = new FacturaGiroInternacional();
		objFacturaInternacional.setReferenciaControl(pStrReferenciaSeguro);
		objFacturaInternacional.setTotal(Double.parseDouble(pStrVlrGiroRemesa));
		
		objDtoProveedorServicioProductoGiro = UtilProveedorServicioProductoGiros.getInstance().validarProveedorServicioProductoXTipoServicio(EnumTiposServicios.ANULACION_SEGURO_INTERNACIONAL,
				 																														     pObjUsuario,
				 																														     EnumTiposOperaciones.ANULAR_PROTEGIRO_INTERNACIONAL);


		UtilConceptos.getInstance().gestionarConceptosYMediosPago	(	objFacturaInternacional,
																		EnumParametrosSistema.CODIGO_CONCEPTO_ANULACION_PROTEGIRO_INTERNACIONAL, 
																		EnumTiposIdentificadorConcepto.CODIGO);
		
		objEnvioTrama = new AnularProtegiroInternacional(pObjUsuario, 
														 objFacturaInternacional, 
														 objDtoProveedorServicioProductoGiro);
		
		objRespuestaTrama = (RespuestaAnularProtegiroInternacional)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())) {
		
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					 										 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					 										 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}else{
			return (String) objRespuestaTrama.getValorAtributoObj("strRespuestaAnulacion");
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	reimprimirPagoInternacional
	 * 		  	metodo para reimprimir pago de giro internacional
	 * @param   pObjUsuario
	 * 			Objeto usuario de la aplicacion
	 * @param   pServicioPeticion
	 * 			Objeto ServicioPeticion, con los datos de la transaccion a FPISA
	 * @param 	pGiroInternacional
	 * 			objeto factura giro, con los datos a enviar
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		    presentada
	 * @author	carlos.mora
	 * @date	10/05/2018
	 * *********************************************************************
	 */
//	public void reimprimirPagoInternacional(Usuario poUsuario,
//											ServicioPeticion pServicioPeticion, 
//											VariablesImpresionPagoGiroInternacionalDTO pGiroInternacional)throws Exception{
//
//		/**
//		* [Trama 508 | Realizar reimpresion de pago internacional]
//		*/
//		ReimprimirPagoInternacional objEnvioTrama;
//		RespuestaPagoGiroInternacional objRespuestaTrama;
//		
//		objEnvioTrama = new ReimprimirPagoInternacional(poUsuario, 
//														pServicioPeticion, 
//														pGiroInternacional);
//		
//		objRespuestaTrama = (RespuestaPagoGiroInternacional)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
//		
//		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())) {
//		
//			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
//					 										 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
//					 										 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
//		}
//	}
	
	
}

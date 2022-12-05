/** 
 * ****************************************************************
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 */
package co.com.codesa.clienteposslimgiros.vista.logica;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import co.com.codesa.clientecajams.utilidades.integracion.UtilIntegracionAccesoCajaMultiservicio;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMediosPago;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.enumeraciones.operaciones.EnumTiposOperaciones;
import co.com.codesa.clienteposslimgiros.enumeraciones.proveedorServicioProducto.EnumTiposServicios;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.conceptos.UtilConceptos;
import co.com.codesa.clienteposslimgiros.utilidades.mediosPago.UtilMediosPago;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.clienteposslimgiros.utilidades.proveedorServicioProducto.UtilProveedorServicioProductoGiros;
import co.com.codesa.clienteposslimgiros.utilidades.vistaLogica.UtilVistaLogica;
import co.com.codesa.clienteposslimgiros.utilidades.xml.XmlTerritorio;
import co.com.codesa.clienteposslimgiros.vista.logica.lector2D.Lector2DVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.CalcularConceptoGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Concepto;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultaGiroExterno;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultaInfoGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultaTotalTransaccionesTercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultaUltimaActualizacionGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.consultarActualizacionGiroReferencia;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultarFacturasPagos;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultarGiroReferencia;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DatoEntidad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.EstadoAutorizaciones;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaSeguro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.MedioPago;
import co.com.codesa.codesawrapper.modelo.dominio.ParametroSistema;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.AutorizaPreImpresionPago;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultarValorPlanTarifarioGrupo;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.EnvioGiroPostal579;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.PagoGiro583;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.PagoGiroExterno584;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RealizarAnulacionGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaAutorizaPreImpresionPago;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaCalcularConceptoGiro603;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultaGiroExterno;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultaInfoGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultaTotalTransaccionesTercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultaUltimaActualizacionGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarActualizacionGiroReferencia;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarFacturaPago;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarGiroReferencia;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaGicoAutomatico;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarValorPlanTarifarioGrupo;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaEnvioGiroPostal;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaPagoGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaPagoGiroExterno;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaRealizarAnulacionGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Territorio;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.bnet.ProveedorServicioProductoGirosDTO;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.giros.EnumTiposIdentificadorConcepto;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultarSolicitudAutomaticaReintegroGico;

/**
 * ****************************************************************.
 * @autor: CesarO.Rendon
 * @fecha: 19-mar-2015 
 * @descripcion: clase encargada de manejar el llamado a las tramas de
 * giros.
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */ 
public class GiroVistaLogica {

	private static GiroVistaLogica instancia;
	
	/**
	 * ****************************************************************.
	 * @metodo: GiroVistaLogica
	 * @descripcion: contructor de la logica.
	 * @autor: CesarO.Rendon
	 * ****************************************************************
	 */
	private GiroVistaLogica(){}	
	
	/**
	 * ****************************************************************.
	 * @metodo: getInstance
	 * @descripcion: metodo para cumplir con el patron singleton y tener
	 * una unica instancia de la clase para se accedida.
	 * @autor: CesarO.Rendon
	 * ****************************************************************
	 */
	public static GiroVistaLogica getInstance(){		
		if (instancia == null)
			instancia= new GiroVistaLogica();
		
		return instancia;
	}



	/**
	 * ****************************************************************.
	 * @metodo: consultarInfoGiro
	 * @descripcion: llama la trama de consultar inforamcion de un giro.
	 * @param pStrRefControl
	 * @return List<FacturaGiro>
	 * @throws Exception
	 * @autor: CesarO.Rendon
	 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
	 * ****************************************************************
	 */
	@SuppressWarnings("unchecked")
	public List<FacturaGiro> consultarInfoGiro(Usuario pObjUsuario,
											   String pStrRefControl) throws Exception{
		
		/**
		 * [Trama 51 | Consultar informacion giros pendientes de pago]
		 */
		
		ConsultaInfoGiro objEnvioTrama;
		RespuestaConsultaInfoGiro objRespuestaTrama;
		
		//se crea entidad de la trama que se quiere enviar con valores por default en caso de null
		objEnvioTrama = new ConsultaInfoGiro(pObjUsuario,
											 pStrRefControl);					

		//se envia la ttrmaa y se obtiene respuesta
		//objRespuestaTrama = (RespuestaConsultaInfoGiro)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaConsultaInfoGiro)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		//se valida que la trmaa no haya presentado problemas
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())) {
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
													   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
													   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
		
		return (List<FacturaGiro>) objRespuestaTrama.getValorAtributoObj("lstFacturas");
	}

	/** 
	 * ********************************************************************
	 * @method consultaGiroInterno
	 * 		   metodo para consultar los giros dependiendo el criterio de
	 * 		   busqueda
	 * @param  pObjUsuario
	 * 		   objeto usuario
	 * @param  pStrFechaInicial
	 * 		   fecha inicial
	 * @param  pStrFechaFinal
	 * 		   fecha final
	 * @param  pObjDatEntTipoIdentificacion
	 * 	       objeto dato entidad de tipo de identificacion
	 * @param  pStrIdentificacion
	 * 		   identificacion
	 * @param  pStrReferencia
	 * 		   referencia control
	 * @param  pStrApellido
	 * 		   apellido
	 * @param  pStrTipoFiltro
	 * 		   tipo filtro
	 * @param  pObjBooRemitenteDestinatario
	 * 		   objeto remitente destinatario
	 * @param  pStrCodigoMunicipioOrigen
	 * 		   codigo municipio origen
	 * @param  pStrEstado
	 * 		   estado
	 * @param  pStrValida
	 * 		   valida
	 * @return List<FacturaGiro>
	 * 		   Listado de facturas
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   8/10/2016
	 * *********************************************************************
	 */
	@SuppressWarnings("unchecked")
	public List<FacturaGiro> consultaGiroInterno(Usuario pObjUsuario,
												 String pStrFechaInicial, 
			 								  	 String pStrFechaFinal,
			 								  	 DatoEntidad pObjDatEntTipoIdentificacion,
			 								  	 String pStrIdentificacion, 
			 								  	 String pStrReferencia,
			 								  	 String pStrApellido,
			 								  	 String pStrTipoFiltro,
			 								  	 Boolean pObjBooRemitenteDestinatario, 
			 								  	 String pStrCodigoMunicipioOrigen, 
			 								  	 String pStrEstado,
			 								  	 String pStrValida) throws Exception {
		/**
		 * [Trama 457 | Consultar giros internos por criterios de busqueda]
		 */
		
		List<FacturaGiro> lstFacturasInternas = null;
		ConsultarFacturasPagos objEnvioTrama;
		RespuestaConsultarFacturaPago objRespuestaTrama;
		
		objEnvioTrama = new ConsultarFacturasPagos(pObjUsuario,
												   pStrFechaInicial,
												   pStrFechaFinal,
												   pObjDatEntTipoIdentificacion,
												   pStrIdentificacion,
												   pStrReferencia,
												   pStrApellido,
												   pStrTipoFiltro,
												   pObjBooRemitenteDestinatario,
												   pStrCodigoMunicipioOrigen,
												   pStrEstado,
												   pStrValida);

		//objRespuestaTrama = (RespuestaConsultarFacturaPago) ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaConsultarFacturaPago)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").equals(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {//respuesta positiva
			
			lstFacturasInternas = (List<FacturaGiro>)objRespuestaTrama.getValorAtributoObj("lstFacturas");
			
		}else{
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
													   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
													   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
		
		return lstFacturasInternas;
	}
	
	@SuppressWarnings("unchecked")
	public List<FacturaGiro> consultaGiroExterno(Usuario pObjUsuario,
												 String pStrFechaInicial, 
												 String pStrFechaFinal, 
												 DatoEntidad pObjDatEntTipoIdentificacionBeneficiario,
												 String pStrIdentificacionBeneficiario,
												 String pStrReferencia) throws Exception{
		/**
		 * [Trama 154 | Consultar giros externos por criterios de busqueda]
		 */
		
		List<FacturaGiro> lstFacturasExternas = null;
		ConsultaGiroExterno objEnvioTrama;
		RespuestaConsultaGiroExterno objRespuestaTrama;
		ParametroSistema objParDatoDRedExterna;
		
		objParDatoDRedExterna = UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.DATO_D_RED_EXTERNA_ENCABEZADO_TRAMA);
		
		objEnvioTrama = new ConsultaGiroExterno(pObjUsuario,
												pStrFechaInicial,
												pStrFechaFinal,
												pObjDatEntTipoIdentificacionBeneficiario,
												pStrIdentificacionBeneficiario,
												pStrReferencia,
												objParDatoDRedExterna.getValor());
		
		//objRespuestaTrama = (RespuestaConsultaGiroExterno) ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaConsultaGiroExterno)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {//respuesta positiva
			
			lstFacturasExternas = (List<FacturaGiro>)objRespuestaTrama.getValorAtributoObj("lstFacturas");
			
		}else{
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
		
		return lstFacturasExternas;
	}
	
	
	/** 
	 * ********************************************************************
	 * @method insertarMovimientoPagoFacturacionExterna
	 * 		   [TODO - DOC]: Descripcion del metodo, cual es su uso, la 
	 * 		   necesidad y su aporte y como se integra con la funcionalidad
	 * @param  pObjUsuario
	 * 		   objeto usuario que realiza la operacion
	 * @param  pObjFacturaGiroExterno
	 * 		   objeto factura giro que contiene el detalle para realizar la 
	 * 		   transaccion
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   23/5/2016
	 * *********************************************************************
	 */
	public void insertarMovimientoPagoFacturacionExterna(Usuario pObjUsuario,
														 FacturaGiro pObjFacturaGiroExterno,
														 String pStrAdmisionCRC ) throws Exception{
		/**
		 * [Trama 421 | Pago de giro externo]
		 * [Trama 557 | Pago de giro externo] Soporta supervoucher, firma biometrica
		 * [Trama 559 | Pago de giro externo] Soporta supervoucher, firma biometrica y promociones
		 */
		
		//PagoGiroExterno555 objEnvioTrama;
		//PagoGiroExterno557 objEnvioTrama;
		PagoGiroExterno584 objEnvioTrama;
		RespuestaPagoGiroExterno objRespuestaTrama;
		ProveedorServicioProductoGirosDTO objDtoProveedorServicioProducto;
		Concepto objConceptoRepresentativo;
		
		objDtoProveedorServicioProducto = UtilProveedorServicioProductoGiros.getInstance().validarProveedorServicioProductoXTipoServicio(EnumTiposServicios.PAGO_GIRO_EXTERNO,
																																		 pObjUsuario,
																																		 EnumTiposOperaciones.PAGO_FACTURACION_GIRO);
		pObjFacturaGiroExterno.setStrIdTtransaccion(UtilidadesGiros.getInstance().obtenerIdTransaccion(pObjUsuario));
		
		objConceptoRepresentativo	=	UtilConceptos.getInstance().generarConcepto	(
																						EnumParametrosSistema.ID_CONCEPTO_PAGO_GIRO, 
																						EnumTiposIdentificadorConcepto.ID,
																						Concepto.AFECTA_CAJA
																					);
		pObjFacturaGiroExterno.setObjConceptoRepresentativo(objConceptoRepresentativo);
		
		/**
		 * Concepto de utilidad, no se sincroniza con GAMBLE, por que no afecta caja. 
		 * */
		/*UtilConceptos.getInstance().gestionarConceptoUtilidadXFactura	(	pObjFacturaGiroExterno, 
																			EnumParametrosSistema.CODIGO_CONCEPTO_UTILIDAD_X_PAGO_GIRO	);*/
		
		//pObjFacturaGiroExterno.setBooAptoParaFacturar(true);
		
		/*objEnvioTrama = new PagoGiroExterno(pObjUsuario,
											pObjFacturaGiroExterno,
											objDtoProveedorServicioProducto);*/
		
		/*objEnvioTrama = new PagoGiroExterno555(pObjUsuario,
											   pObjFacturaGiroExterno,
											   pStrAdmisionCRC,
				                               objDtoProveedorServicioProducto
				                               );*/
		/*objEnvioTrama = new PagoGiroExterno557(pObjUsuario,
											   pObjFacturaGiroExterno,
											   pStrAdmisionCRC,
							                   objDtoProveedorServicioProducto
							                  );*/
		objEnvioTrama = new PagoGiroExterno584(pObjUsuario,
											   pObjFacturaGiroExterno,
											   pStrAdmisionCRC,
											   objDtoProveedorServicioProducto
							               	  );
		
		//Este fragmento de codigo completa la trama para saber que proveedor y servicio es para mover consolidados.
		/*if(InformacionSession.getInstance().getlProveedorServicioProductoGiros() != null 
				&& !InformacionSession.getInstance().getlProveedorServicioProductoGiros().isEmpty()){
			
			for(ProveedorServicioProducto tmp : InformacionSession.getInstance().getlProveedorServicioProductoGiros()){
				
				if(tmp.getServicioProductos().get(0).getTipoServicio().equals(EnumParametrosApp.REQUIERECLAVE_PAGO_EXTERNO.getValorPropiedad())){
					
					objEnvioTrama.setNitProveedor(tmp.getNitProveedor());
					objEnvioTrama.setServicioCodigo(tmp.getServicioProductos().get(0).getCodServicio());
					objEnvioTrama.setProductoCodigo(tmp.getServicioProductos().get(0).getProductos().get(0).getCodigo());
				}				
			}
			
		}else{
			objEnvioTrama.setNitProveedor("*");
			objEnvioTrama.setServicioCodigo("*");
			objEnvioTrama.setProductoCodigo("*");
		}*/
		
		//objRespuestaTrama = (RespuestaPagoGiroExterno) ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaPagoGiroExterno)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())) {
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
	public FacturaGiro consultaGiroPorReferencia(Usuario pObjUsuario,
												 String pStrReferenciaControl, 
												 boolean pBooValidaZona, 
												 String pStrValidaEstadoGiro,
												 String pStrTipoGiro,
												 String pStrProducto)throws Exception{
		/**
		 * [Trama 11 | Consultar factura por Referencia (Pin)]
		 */
		
		ConsultarGiroReferencia objEnvioTrama;
		RespuestaConsultarGiroReferencia objRespuestaTrama;
		FacturaGiro objFacturaGiro = null;
		Territorio objTerritorio;
		String strInfoDocumentoSoporte;
		
		objEnvioTrama = new ConsultarGiroReferencia(pObjUsuario,
													pStrProducto,
												 	pStrReferenciaControl,
												 	pBooValidaZona,
												 	pStrValidaEstadoGiro,
												 	pStrTipoGiro);

		//objRespuestaTrama =(RespuestaConsultarGiroReferencia) ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaConsultarGiroReferencia)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {

			objFacturaGiro = (FacturaGiro)objRespuestaTrama.getValorAtributoObj("objFacturaGiro");
			
			objTerritorio = objFacturaGiro.getAgenciaOrigen().getTerritorio();
			objFacturaGiro.getAgenciaOrigen().setTerritorio(XmlTerritorio.getInstance().obtenerMunicipio(objTerritorio.getCodigo()));
			
			objTerritorio = objFacturaGiro.getAgenciaDestino().getTerritorio();
			objFacturaGiro.getAgenciaDestino().setTerritorio(XmlTerritorio.getInstance().obtenerMunicipio(objTerritorio.getCodigo()));
			
			if(objFacturaGiro.isIncluyeSeguro()){
				
				strInfoDocumentoSoporte = (String)objRespuestaTrama.getValorAtributoObj("strInfoDocumentoSoporte");
				
				this.adjuntarDocumentoSoporte(pObjUsuario,
											  objFacturaGiro,
											  strInfoDocumentoSoporte);
			}
			
		}else{//respuesta negativa

			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}

		return objFacturaGiro;
	}
	
	/** 
	 * ********************************************************************
	 * @method EsGicoYServColabTcro
	 * 		   El proposito de esta funcion es consumir la trama 595
	 * 		   Con tipo de solicitud consulta [CONS]
	 * 		   objeto usuario que realiza la operacion
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author david.marquez
	 * @date   2020/nov/19
	 * *********************************************************************
	 */
	public Boolean EsGicoYServColabTcro(Usuario pObjUsuario, String pStrReferenciaControl) throws Exception  {
		
		/**
		 * [Trama 595 | Giro automatico | Consulta (CONS)]
		 */
		
		ConsultarSolicitudAutomaticaReintegroGico objEnvioTrama;
		RespuestaGicoAutomatico objRespuestaTrama;
		String strTipoSolicitud;
		
		//Se utiliza la solicitud CONS la cual representa la accion de consulta de la trama 595
		strTipoSolicitud = "CONS";
		
		// Se construye la trama para enviar
		objEnvioTrama = new ConsultarSolicitudAutomaticaReintegroGico(pObjUsuario, strTipoSolicitud, pStrReferenciaControl);
		// Se envia la trama y se obtiene su respectiva respuesta
		objRespuestaTrama = (RespuestaGicoAutomatico)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
			// Se retorna true solo si la trama responde S lo cual significa que
			// El pin se encuentra en giros controlados y el servicio y propiedad del colaborador 
			// estan activos
			if (objRespuestaTrama.getRespuestaEstadoDelProceso().equalsIgnoreCase("S"))
			{
				return true;
			}
			else {
				return false;
			}
		}
		else { // Respuesta negativa
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
			   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
			   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}

	}
	
	/** 
	 * ********************************************************************
	 * @method CambiarBeneficiarioDestinatarioGico
	 * 		   El proposito de esta funcion es consumir la trama 595
	 * 		   Con tipo de REMI o DEST
	 * @param  pObjUsuario
	 * 		   objeto usuario que realiza la operacion
	 * @param  pStrReferenciaControl
	 * 		   referencia control (PIN)
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author david.marquez
	 * @date   2020/nov/19
	 * *********************************************************************
	 */
	public Boolean CambiarBeneficiarioDestinatarioGico(Usuario pObjUsuario, String pStrReferenciaControl, String pStrTipoSolicitudGico) throws Exception {
		/**
		 * [Trama 595 | Giro automatico | Consulta (REMI-DEST)]
		 */
		
		ConsultarSolicitudAutomaticaReintegroGico objEnvioTrama;
		RespuestaGicoAutomatico objRespuestaTrama;
		String strTipoSolicitud;
		String strFinalizoGicoExitosamente;
		
		strTipoSolicitud = pStrTipoSolicitudGico;
		strFinalizoGicoExitosamente = "OK";
		
		switch(strTipoSolicitud) {
			case "REMITENTE":
				// Se construye la trama para enviar con tipo de solicitud REMI
				// Para realizar un cambio de beneficiario en la forma SORB
				objEnvioTrama = new ConsultarSolicitudAutomaticaReintegroGico(pObjUsuario, "REMI", pStrReferenciaControl);
				break;
			case "BENEFICIARIO":
				// Se construye la trama para enviar con tipo de solicitud DEST
				// Para realizar el estado de PAGADO en la forma SORB
				objEnvioTrama = new ConsultarSolicitudAutomaticaReintegroGico(pObjUsuario, "DEST", pStrReferenciaControl);
				break;
			default:
				objEnvioTrama = null;
				break;
		}
		
		
		if(objEnvioTrama != null) {
			// Se envia la trama y se obtiene su respectiva respuesta
			objRespuestaTrama = (RespuestaGicoAutomatico)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

			if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
				// Se retorna true solo si la trama responde OK lo cual significa que
				// Se realizo el proceso GICO exitosamente
				if (objRespuestaTrama.getRespuestaEstadoDelProceso().equalsIgnoreCase(strFinalizoGicoExitosamente))
				{
					return true;
				}
				else {
					return false;
				}
			}
			else { // Respuesta negativa
				throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
				   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
				   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
			}			
		}
		else {
			return false;
		}
	}
		
	private void adjuntarDocumentoSoporte(Usuario pObjUsuario,
										  FacturaGiro pObjFactura,
										  String pStrInfoDocumentoSoporte)throws Exception{
		
		ParametroSistema objParIdConceptoSeguroHurto;
		ParametroSistema objParIdConceptoSeguroNoCombo;
		
		FacturaSeguro objFacturaSeguro;
		String strReferenciaControlSeguro;
		String strReferenciaControlSeguroCodesa;
		String strIdConceptoSeguro;
		String strValorPrimaSeguro;
		
		StringTokenizer stkElementosTramaDocumentoSoporte;
		StringTokenizer stkElementosTramaSeguro;
		String strTramaSeguro; 
		
		UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.ID_CONCEPTO_SEGURO_HURTO,
													  EnumParametrosSistema.ID_CONCEPTO_SEGURO_NO_COMBO);
		
		objParIdConceptoSeguroHurto = EnumParametrosSistema.ID_CONCEPTO_SEGURO_HURTO.obtenerObjParametro();
		objParIdConceptoSeguroNoCombo = EnumParametrosSistema.ID_CONCEPTO_SEGURO_NO_COMBO.obtenerObjParametro();
		
		stkElementosTramaDocumentoSoporte = new StringTokenizer(pStrInfoDocumentoSoporte,
																EnumGeneralidadesTramasGiros.VIGURILLA.getValor());
		
		while(stkElementosTramaDocumentoSoporte.hasMoreElements()){
			
			strTramaSeguro = stkElementosTramaDocumentoSoporte.nextToken();
			stkElementosTramaSeguro = new StringTokenizer(strTramaSeguro,
														  EnumGeneralidadesTramasGiros.PIPE.getValor());
			
			strReferenciaControlSeguro = stkElementosTramaSeguro.nextToken();
			strReferenciaControlSeguroCodesa = stkElementosTramaSeguro.nextToken();
			strIdConceptoSeguro = stkElementosTramaSeguro.nextToken();
			strValorPrimaSeguro = stkElementosTramaSeguro.nextToken();
			
			if(strIdConceptoSeguro.equals(objParIdConceptoSeguroHurto.getValor()) ||
					strIdConceptoSeguro.equals(objParIdConceptoSeguroNoCombo.getValor())){
				
				objFacturaSeguro = new FacturaSeguro(strReferenciaControlSeguro);
				objFacturaSeguro.setReferenciaControlCodesa(strReferenciaControlSeguroCodesa);
				objFacturaSeguro.setConcepto(new Concepto(strIdConceptoSeguro));
				objFacturaSeguro.setValorPrima(Double.parseDouble(strValorPrimaSeguro));
				objFacturaSeguro.setTotal(objFacturaSeguro.getValorPrima());
				
				pObjFactura.setFacturaSeguro(objFacturaSeguro);
				break;
			}
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method insertarMovimientoPagoFacturacion
	 * 		   Metodo para realizar el pago de la factura giro
	 * @param  pObjUsuario
	 * 	       usuario que realiza la transaccion
	 * @param  pObjFacturaGiro
	 * 		   objeto factura giro
	 * @param  pStrOperacionInusual
	 * 	 	   operacion inusual
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   23/5/2016
	 * *********************************************************************
	 */
	public void insertarMovimientoPagoFacturacion(Usuario pObjUsuario,
												  FacturaGiro pObjFacturaGiro,
												  String pStrOperacionInusual,
												  String pStrAdmisionCRC)throws Exception{
		/**
		 * [Trama 469 | Insertar Movimientos de Pago Facturacion: Trama para registrar el pago de giro]
		 */
		
		PagoGiro583 objEnvioTrama;
		RespuestaPagoGiro objRespuestaTrama;
		ProveedorServicioProductoGirosDTO objDtoProveedorServicioProducto;
		Concepto objConceptoRepresentativo;
		String strMarcaLector;
				
		objDtoProveedorServicioProducto = UtilProveedorServicioProductoGiros.getInstance().validarProveedorServicioProductoXTipoServicio(EnumTiposServicios.PAGO_GIRO,
																																		 pObjUsuario,
																																		 EnumTiposOperaciones.PAGO_FACTURACION_GIRO);
		pObjFacturaGiro.setStrIdTtransaccion(UtilidadesGiros.getInstance().obtenerIdTransaccion(pObjUsuario));
		
		objConceptoRepresentativo	=	UtilConceptos.getInstance().generarConcepto	(
																						EnumParametrosSistema.ID_CONCEPTO_PAGO_GIRO, 
																						EnumTiposIdentificadorConcepto.ID,
																						Concepto.AFECTA_CAJA
																					);
		pObjFacturaGiro.setObjConceptoRepresentativo(objConceptoRepresentativo);
		
		/**
		 * Concepto de utilidad, no se sincroniza con GAMBLE, por que no afecta caja. 
		 * */
		/*UtilConceptos.getInstance().gestionarConceptoUtilidadXFactura	(	pObjFacturaGiro, 
																			EnumParametrosSistema.CODIGO_CONCEPTO_UTILIDAD_X_PAGO_GIRO	);*/
		
		//pObjFacturaGiro.setBooAptoParaFacturar(true);
		
		if (Lector2DVistaLogica.getInstance().getBooProcesoLectorOk()) {
			
			if (pObjFacturaGiro.getObjTerceroApoderado() != null) {
				strMarcaLector = "LEC|" + pObjFacturaGiro.getObjTerceroApoderado().getIdentificacion();
			}else{
				strMarcaLector = "LEC|" + pObjFacturaGiro.getTerceroDestino().getIdentificacion();
			}
			
		}else {
			strMarcaLector = "*";
		}
		
		objEnvioTrama = new PagoGiro583(pObjUsuario,
                pObjFacturaGiro,
                pStrOperacionInusual,
                pStrAdmisionCRC,
                strMarcaLector,
                objDtoProveedorServicioProducto);
		
		/*objEnvioTrama = new PagoGiro469(pObjUsuario,
		                                pObjFacturaGiro,
		                                pStrOperacionInusual,
		                                objDtoProveedorServicioProducto);*/

		//Este fragmento de codigo completa la trama para saber que proveedor y servicio es para mover consolidados.
		/*if(InformacionSession.getInstance().getlProveedorServicioProductoGiros() != null 
				&& !InformacionSession.getInstance().getlProveedorServicioProductoGiros().isEmpty()){
			
			for(ProveedorServicioProducto tmp : InformacionSession.getInstance().getlProveedorServicioProductoGiros()){
				
				if(tmp.getServicioProductos().get(0).getTipoServicio().equals(EnumParametrosApp.REQUIERECLAVE_PAGOGIRO.getValorPropiedad())){*/
					
					/*objEnvioTrama.setNitProveedor(tmp.getNitProveedor());
					objEnvioTrama.setServicioCodigo(tmp.getServicioProductos().get(0).getCodServicio());
					objEnvioTrama.setCodigoProducto(tmp.getServicioProductos().get(0).getProductos().get(0).getCodigo());*/
		/*		}				
			}
			
		}else{*/
			/*objEnvioTrama.setNitProveedor("*");
			objEnvioTrama.setServicioCodigo("*");
			objEnvioTrama.setCodigoProducto("*");*/
		//}
		
		//objRespuestaTrama = (RespuestaPagoGiro) ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaPagoGiro)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())) {//respuesta negativa
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
	
	/**
  	 * ****************************************************************.
  	 * @method calcularConceptosGiro
  	 * 		   Metodo utilizado calcular los conceptos del giro
  	 * @param  pObjUsuario
  	 *         objeto usuario
  	 * @param  pObjFacturaGiro 
  	 * 		   objeto FacturaGiro con la informacion de la cotizacion, este
  	 * 		   objeto se setea la respuesta.
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @author Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public void calcularConceptosGiro(Usuario pObjUsuario,
									  FacturaGiro pObjFacturaGiro) throws Exception{
		
		/**
		 * [Trama 144 | Cotizar: calcular conceptos de giro]
		 */
		
		CalcularConceptoGiro objEnvioTrama;
		RespuestaCalcularConceptoGiro603 objRespuestaTrama;
		
		objEnvioTrama = new CalcularConceptoGiro(pObjUsuario,
												 pObjFacturaGiro);
		
		//objRespuestaTrama = (RespuestaCalcularConceptoGiro) ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaCalcularConceptoGiro603)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if((objRespuestaTrama.getValorAtributoObj("tipoResultado")).toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())){
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo transaccionesDia
  	 * 		   Metodo utilizado para consultar las transacciones del dia 
  	 * 	       del tercero 
  	 * @param pObjTercero 
  	 * 		  objeto Tercero con la informacion del tercero a consultar
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @return String  valor de la transaccion del dia.
  	 * @autor Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public String transaccionesDia(Usuario pObjUsuario,
								   Tercero pObjTercero) throws Exception{
		
		ConsultaTotalTransaccionesTercero objEnvioTrama;
		RespuestaConsultaTotalTransaccionesTercero objRespuestaTrama;
		String strValTransaccionesDia = "0";
		
		objEnvioTrama = new ConsultaTotalTransaccionesTercero(pObjUsuario,
															  pObjTercero);
		
		//objRespuestaTrama = (RespuestaConsultaTotalTransaccionesTercero) ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaConsultaTotalTransaccionesTercero)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (((String) objRespuestaTrama.getValorAtributoObj("tipoResultado")).equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
			
			strValTransaccionesDia =(String) objRespuestaTrama.getValorAtributoObj("valorCantidadTransaccionesRealizadasDelDia");
			
		}else{
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
															 (String) objRespuestaTrama.getValorAtributoObj("codigoError"),
															 (String) objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
		
		return strValTransaccionesDia;
	}

	/**
  	 * ****************************************************************.
	 * @metodo consultarUltimoEstadoGiro
	 * 		   Metodo utilizado para ejecutar la peticion de consulta 
	 * 		   de informacion acerca de la ultima actualizacion de un 
	 * 		   giro en particular. 
	 * 		   Importante: de momento solo es usado para la funcionalidad 
	 * 		   de solicitud de anulacion de giro, para retomar la 
	 * 		   informacion de cambio de estado
	 * @param pObjFacturaGiro
	 * 		  Objeto factura de giro del cual se requiere consultar su 
	 * 		  ultima actualizacion
	 * @throws Exception: Controla, recupera y escala, cualquier tipo de 
  	 * 		   excepcion presentada
  	 *  @autor Hector Q-en-K
	 * ****************************************************************
  	 */
	public void consultarUltimaActualizacionGiro(Usuario pObjUsuario,
												 FacturaGiro pObjFacturaGiro) throws Exception{
		
		/**
		 * 	[Trama 38 | Consulta informacion de cambio de estado de giro]
		 */

		ConsultaUltimaActualizacionGiro objEnvioTrama;
		RespuestaConsultaUltimaActualizacionGiro objRespuestaTrama;

		objEnvioTrama = new ConsultaUltimaActualizacionGiro(pObjUsuario,
															pObjFacturaGiro);

		//objRespuestaTrama = (RespuestaConsultaUltimaActualizacionGiro) ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaConsultaUltimaActualizacionGiro)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())) {

			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
			   		 										 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
			   		 										 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
	/**
  	 * ****************************************************************.
	 * @metodo consultarActualizacionGiroReferencia
	 * 		   Metodo utilizado para ejecutar la peticion de consulta 
	 * 		   de informacion acerca de la ultima actualizacion de un 
	 * 		   giro en particular. 
	 * 		   Importante: Se crear este metodo con base al metodo
	 * 		   consultarUltimaActualizacionGiro para dar solucion al 
	 * 		   Ticket 489623, solucionando la mejora solicitada por
	 * 		   SuperGiros
	 * @param pObjFacturaGiro
	 * 		  Objeto factura de giro del cual se requiere consultar su 
	 * 		  ultima actualizacion
	 * @throws Exception: Controla, recupera y escala, cualquier tipo de 
  	 * 		   excepcion presentada
  	 *  @autor Jefferson Ruiz
	 * ****************************************************************
  	 */
	public void consultarActualizacionGiroReferencia(Usuario pObjUsuario,
												 	 FacturaGiro pObjFacturaGiro) throws Exception{
		
		/**
		 * 	[Trama 38 | Consulta informacion de cambio de estado de giro]
		 */

		consultarActualizacionGiroReferencia objEnvioTrama;
		RespuestaConsultarActualizacionGiroReferencia objRespuestaTrama;

		objEnvioTrama = new consultarActualizacionGiroReferencia(pObjUsuario,
																 pObjFacturaGiro);

		objRespuestaTrama = (RespuestaConsultarActualizacionGiroReferencia)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())) {

			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
			   		 										 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
			   		 										 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
	/**
  	 * ****************************************************************.
	 * @metodo consultarValorPlanTarifario
	 * 		   Metodo para consultar el valor del superCombo con base 
	 * 	  	   al valor del giro y el plan tarifario061.
	 * 
	 * @param  pObjUsuario
	 * 		   Objeto usuario autenticado
	 * @param  pStrCodPlanTarifario
	 * 		   codigo del plan tarifario
	 * @param  pDouValorGiro
	 * 		   valor giro
	 * @param  pStrTipoRespuestaValor
	 * 		   tipo respuesta valor, procesada en el pl
	 * @return String
	 * 	       valor del supercombo
	 * @throws Exception: Controla, recupera y escala, cualquier tipo de 
  	 * 		   excepcion presentada
  	 * @autor Roberth Martinez Vargas
	 * ****************************************************************
  	 */
	public String consultarValorPlanTarifario(Usuario pObjUsuario,
											  String pStrCodPlanTarifario,
											  double pDouValorGiro,
											  String pStrTipoRespuestaValor,
											  String pStrOperacion) throws Exception{
		
		/**
		 * 	[Trama 445 |  Permite consultar el valor para el super combo con base al valor del giro y el grupo del plan tarifario establecido]
		 */

		ConsultarValorPlanTarifarioGrupo objEnvioTrama;
		RespuestaConsultarValorPlanTarifarioGrupo objRespuestaTrama;
		String strValPlanTarifario = "0";

		objEnvioTrama = new ConsultarValorPlanTarifarioGrupo(pObjUsuario,
															 pStrCodPlanTarifario,
															 pDouValorGiro,
															 pStrTipoRespuestaValor,
															 pStrOperacion);

		//objRespuestaTrama = (RespuestaConsultarValorPlanTarifarioGrupo) ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaConsultarValorPlanTarifarioGrupo)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())) {

			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
			   		 										 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
			   		 										 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}else{
			strValPlanTarifario =(String) objRespuestaTrama.getValorAtributoObj("strValorTarifa");
		}
		
		return strValPlanTarifario;
	}
	
	/** 
	 * ********************************************************************
	 * @method insertarMovimientoFacturacion
	 * 		   Metodo utilizado insertar un movimiento de facturacion del 
  	 *         envio del giro postal
	 * @param  pObjUsuario
	 * 		   objeto usuario
	 * @param  pObjFacturaGiro
	 * 		   objeto factura giro
	 * @param  pStrOperacionInusual
	 * 		   cadena operacion inusual
	 * @return String
	 * @param  pStrAdmisionCRC
	 *         cadena con informacion de prueba admision
	 *         requerido por la CRC. Tiene multiformato de tipo
	 *         codigo|descripcion|valor~ ...
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de 
  	 * 		   excepcion presentada
	 * @author roberth.martinez
	 * @date   10/3/2016
	 * @author dsalazar[PlayTech]
	 * @date   23/02/2019
	 * Desc:   Se agrega nuevo parametro pStrAdmisionCRC
	 * *********************************************************************
	 */
	public String insertarMovimientoFacturacion(Usuario pObjUsuario,
												FacturaGiro pObjFacturaGiro, 
												String pStrOperacionInusual,
												String pStrAdmisionCRC) throws Exception{
		/**
		* [Trama 468 | Insertar Movimientos de Envio Facturacion: Trama para registrar el envio de giro]
		*/
		
		//EnvioGiroPostal468 objEnvioTrama;
		//Invocando la trama 547 Prueba (constancia) Admision de tirilla CRC
		EnvioGiroPostal579 objEnvioTrama;
		RespuestaEnvioGiroPostal objRespuestaTrama;
		ProveedorServicioProductoGirosDTO objDtoProveedorServicioProducto;
		MedioPago objMedioPago;
		
		pObjFacturaGiro.setStrIdTtransaccion(UtilidadesGiros.getInstance().obtenerIdTransaccion(pObjUsuario));
		
		objDtoProveedorServicioProducto = UtilProveedorServicioProductoGiros.getInstance().validarProveedorServicioProductoXTipoServicio(EnumTiposServicios.ENVIO_GIRO,
																																		 pObjUsuario,
																																		 EnumTiposOperaciones.ENVIO_FACTURACION_GIRO);
		
		/**
		 * Concepto de utilidad, no se sincroniza con GAMBLE, por que no afecta caja. 
		 * */
		/*UtilConceptos.getInstance().gestionarConceptoUtilidadXFactura	(	pObjFacturaGiro, 
																			EnumParametrosSistema.CODIGO_CONCEPTO_UTILIDAD_X_ENVIO_GIRO	);*/
		
		if	(		pObjFacturaGiro.getListMediosPago().size()	== 1
				&& 	UtilMediosPago.getInstance().isMedioPagoTipoEnum((objMedioPago = pObjFacturaGiro.getListMediosPago().get(0)), EnumMediosPago.EFECTIVO)
				&&	objMedioPago.getValor() != pObjFacturaGiro.getTotal()
			){
			
			objMedioPago.setValor(pObjFacturaGiro.getTotal());
		}
		
		//pObjFacturaGiro.setBooAptoParaFacturar(true);
		
		//autor: dsalazar[PlayTech]
		//23-feb-2019
		//Se cambia Trama EnvioGiroPostal468 * EnvioGiroPostal547
		//Por requerimiento CRC Prueba admision tirilla
		
		objEnvioTrama = new EnvioGiroPostal579(pObjUsuario, 
		                                       pObjFacturaGiro, 
		                                       pStrOperacionInusual,
		                                       pStrAdmisionCRC,
		                                       objDtoProveedorServicioProducto);
		/*
		objEnvioTrama = new EnvioGiroPostal468(pObjUsuario, 
               pObjFacturaGiro, 
                pStrOperacionInusual,
                objDtoProveedorServicioProducto);*/
		
		//Este fragmento de codigo completa la trama para saber que proveedor y servicio es para mover consolidados.
		/*if(InformacionSession.getInstance().getlProveedorServicioProductoGiros() != null 
				&& !InformacionSession.getInstance().getlProveedorServicioProductoGiros().isEmpty()){
			
			for(ProveedorServicioProducto provServProd : InformacionSession.getInstance().getlProveedorServicioProductoGiros()){
				
				if(provServProd.getServicioProductos().get(0).getTipoServicio().equals(EnumParametrosApp.REQUIERECLAVE_ENVIOGIRO.getValorPropiedad())){
					
					objEnvioTrama.setStrNitProveedor(provServProd.getNitProveedor());
					objEnvioTrama.setStrServicioCodigo(provServProd.getServicioProductos().get(0).getCodServicio());
					objEnvioTrama.setStrProductoCodigo(provServProd.getServicioProductos().get(0).getProductos().get(0).getCodigo());
				}				
			}
			
		}else{
			
			objEnvioTrama.setStrNitProveedor("*");
			objEnvioTrama.setStrServicioCodigo("*");
			objEnvioTrama.setStrProductoCodigo("*");
		}*/
		
		//objRespuestaTrama = (RespuestaEnvioGiroPostal) ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaEnvioGiroPostal)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (((String) objRespuestaTrama.getValorAtributoObj("tipoResultado")).equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())) {
		
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
								 						     (String) objRespuestaTrama.getValorAtributoObj("codigoError"),
								 						     (String) objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
		
		return "OK";
	}
	
	/**
	 * ********************************************************************
	 * @method 	realizarAnulacionGiro
	 * 		   	Metodo que permite verificar y realizar un proceso de anulacion
	 * 			de giro
	 * @param  	pObjUsuario
	 * 		   	Usuario que realiza la transaccion
	 * @param  	pObjFacturaGiro
	 * 		   	Objeto factura giro
	 * @param	pObjAutorizacion
	 * 			Autorizacion de la solicitud de anulacion
	 * @throws 	Exception
	 * 		   	Controla, recupera y escala, cualquier tipo de 
  	 * 		   	excepcion presentada
	 * @author 	hector.cuenca
	 * @date   	8/08/2016
	 * *********************************************************************
	 */
	public void realizarAnulacionGiro	(	Usuario pObjUsuario,
											FacturaGiro pObjFacturaGiro,
											EstadoAutorizaciones pObjAutorizacion
										)
												throws Exception
	{
		/**
		 * [Trama -487 | Realizar anulacion giro : permite realizar un proceso de anulacion de giro 
		 * en la empresa] 
		 */
		List<ProveedorServicioProductoGirosDTO> lstObjDtoProveedorServicioProductos;
		ProveedorServicioProductoGirosDTO[]	arrObjDtoProveedorServicioProductos;
		RealizarAnulacionGiro objEnvioTrama;
		RespuestaRealizarAnulacionGiro objRespuestaTrama;
		ProveedorServicioProductoGirosDTO objDtoProveedorServicioProductoGiro;
		ProveedorServicioProductoGirosDTO objDtoProveedorServicioProductoSeguro;
		
		lstObjDtoProveedorServicioProductos = new ArrayList<ProveedorServicioProductoGirosDTO>();
		
		pObjFacturaGiro.setStrIdTtransaccion(UtilidadesGiros.getInstance().obtenerIdTransaccion(pObjUsuario));
		
		objDtoProveedorServicioProductoGiro = UtilProveedorServicioProductoGiros.getInstance().validarProveedorServicioProductoXTipoServicio(EnumTiposServicios.ANULACION_GIRO,
																																			 pObjUsuario,
																																			 EnumTiposOperaciones.SOLICITUD_ANULACION_GIRO);
		lstObjDtoProveedorServicioProductos.add(objDtoProveedorServicioProductoGiro);
		
		UtilConceptos.getInstance().gestionarConceptosYMediosPago	(	pObjFacturaGiro,
																		EnumParametrosSistema.ID_CONCEPTO_ANULACION_GIRO, 
																		EnumTiposIdentificadorConcepto.ID
																	);
		
		if(pObjFacturaGiro.isIncluyeSeguro()){
			
			objDtoProveedorServicioProductoSeguro	=	UtilProveedorServicioProductoGiros.getInstance().validarProveedorServicioProductoXTipoServicio(EnumTiposServicios.ANULACION_SEGURO,
																																				  	   pObjUsuario,
																																				  	   EnumTiposOperaciones.SOLICITUD_ANULACION_SEGURO);
			lstObjDtoProveedorServicioProductos.add(objDtoProveedorServicioProductoSeguro);
			
			UtilConceptos.getInstance().gestionarConceptosYMediosPago	(	pObjFacturaGiro.getFacturaSeguro(),
																			EnumParametrosSistema.CODIGO_CONCEPTO_ANULACION_SEGURO, 
																			EnumTiposIdentificadorConcepto.CODIGO
																		);
		}
		
		arrObjDtoProveedorServicioProductos = lstObjDtoProveedorServicioProductos.toArray(new ProveedorServicioProductoGirosDTO[lstObjDtoProveedorServicioProductos.size()]);
			
		objEnvioTrama	=	new RealizarAnulacionGiro	(	pObjUsuario,
														  	pObjFacturaGiro,
														  	pObjAutorizacion,
														  	arrObjDtoProveedorServicioProductos
														);
		
		//objRespuestaTrama = (RespuestaRealizarAnulacionGiro)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaRealizarAnulacionGiro)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())) {
		
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	validarAutorizaPreImpresionPago
	 * 		  	Permite validar la posibilidad de pre-imprimir un comprobante 
	 * 			de pago de giro
	 * @param 	pObjUsuario
	 * 			Usuario cajero que realiza la transaccion
	 * @param	pObjFacturaGiro
	 * 			Objeto factura que representa la transaccion en proceso
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	01/02/2018
	 * *********************************************************************
	 */
	public void validarAutorizaPreImpresionPago	(	Usuario pObjUsuario,
													FacturaGiro pObjFacturaGiro
	                            				)
			throws Exception
	{
		/**
		 * [Trama 542 | Validar la autorizacion para permitir ejecutar una pre impresion de un comprobante de pago domiciliado]
		 */
		
		AutorizaPreImpresionPago objEnvioTrama;
		RespuestaAutorizaPreImpresionPago objRespuestaTrama;
		
		objEnvioTrama = new AutorizaPreImpresionPago(	pObjUsuario,
														pObjFacturaGiro
		                                 			);
		
		objRespuestaTrama = (RespuestaAutorizaPreImpresionPago)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())) 
		{
			UtilIntegracionAccesoCajaMultiservicio.getInstancia().generarExcepcionRespuestaPeticionNegativa	(	(String)objRespuestaTrama.getValorAtributoObj("codigoError"),
				   		 																						(String)objRespuestaTrama.getValorAtributoObj("descripcionError")
				   		 																					);
		}
	}
	
}

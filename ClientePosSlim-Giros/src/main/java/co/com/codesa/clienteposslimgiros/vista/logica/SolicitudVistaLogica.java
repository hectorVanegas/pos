/** 
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
package co.com.codesa.clienteposslimgiros.vista.logica;

import java.util.ArrayList;
import java.util.List;

import co.com.codesa.clienteposslimcontrolador.conexion.ProcesadorTramas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.enumeraciones.operaciones.EnumTiposOperaciones;
import co.com.codesa.clienteposslimgiros.enumeraciones.proveedorServicioProducto.EnumTiposServicios;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.conceptos.UtilConceptos;
import co.com.codesa.clienteposslimgiros.utilidades.proveedorServicioProducto.UtilProveedorServicioProductoGiros;
import co.com.codesa.clienteposslimgiros.utilidades.vistaLogica.UtilVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultarHistorialAutorizacionPorFecha;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DatoEntidad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.EstadoAutorizaciones;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Nota;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RealizarSolicitudAutorizacion;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RealizarSolicitudAutorizacion470;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RealizarSolicitudAutorizacion549;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaAnulacionRecaudo;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarHistorialAutorizacionPorFecha;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaSolicitudAutorizacion;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.bnet.ProveedorServicioProductoGirosDTO;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.giros.EnumTiposIdentificadorConcepto;

/**
 * ****************************************************************.
 * @autor: CesarO.Rendon
 * @fecha: 19-mar-2015 
 * @descripcion: clase encargada de manejar el llamado a las tramas de 
 * solicitudes autorizacion.
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class SolicitudVistaLogica {

	private static SolicitudVistaLogica instancia ;

	/**
	 * ****************************************************************.
	 * @metodo: SolicitudVistaLogica
	 * @descripcion: contructor de la logica.
	 * @autor: CesarO.Rendon
	 * ****************************************************************
	 */
	private SolicitudVistaLogica(){}	

	/**
	 * ****************************************************************.
	 * @metodo: getInstance
	 * @descripcion: metodo para cumplir con el patron singleton y tener
	 * una unica instancia de la clase para se accedida.
	 * @autor: CesarO.Rendon
	 * ****************************************************************
	 */
	public static SolicitudVistaLogica getInstance(){		
		if (instancia == null)
			instancia= new SolicitudVistaLogica();

		return instancia;
	}

	/**
	 * ********************************************************************
	 * @method realizarSolicitudAutorizacion
	 * 		   Metodo que permite realizar una solicitud de autorizacion de
	 * 		   giro
	 * @param  pObjUsuario
	 * 		   Usuario que realiza la transaccion
	 * @param  pObjFacturaGiro
	 * 		   Objeto factura giro
	 * @param  pObjTerceroNuevo
	 * 	       Tercero nuevo, solo aplica para una solicitud de cambio de 
	 * 		   beneficiario
	 * @param  pObjDatEntSolicitud
	 * 		   Dato entidad que permite identificar la solicitud de autorizacion
	 * @param  pObjNota
	 * 		   Nota relacionada a la solicitud de autorizacion
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de 
  	 * 		   excepcion presentada
	 * @author hector.cuenca
	 * @date   8/08/2016
	 * *********************************************************************
	 */
	public void realizarSolicitudAutorizacion(Usuario pObjUsuario,
											  FacturaGiro pObjFacturaGiro,
											  Tercero pObjTerceroNuevo,
											  DatoEntidad pObjDatEntSolicitud,
											  Nota pObjNota,
											  String pStrAdmisionCRC)throws Exception{
		/**
		 * [Trama 470 | Realizar solicitud : permite realizar una solicitud para un giro previamente
		 * consultado] 
		 */
		
		List<ProveedorServicioProductoGirosDTO> lstObjDtoProveedorServicioProductos;
		ProveedorServicioProductoGirosDTO[]	arrObjDtoProveedorServicioProductos;
		RealizarSolicitudAutorizacion549 objEnvioTrama;
		RespuestaSolicitudAutorizacion objRespuestaTrama;
		ProveedorServicioProductoGirosDTO objDtoProveedorServicioProductoGiro;
		ProveedorServicioProductoGirosDTO objDtoProveedorServicioProductoSeguro;
		
		lstObjDtoProveedorServicioProductos = new ArrayList<ProveedorServicioProductoGirosDTO>();
		
		pObjFacturaGiro.setStrIdTtransaccion(UtilidadesGiros.getInstance().obtenerIdTransaccion(pObjUsuario));
		
		//Exclusivo para anulacion
		if(pObjDatEntSolicitud.getId().equals(EnumParametrosApp.COD_DAT_ENT_TP_SOL_ANULACION.getValorPropiedad())){
			
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
			
		}else{
		
			arrObjDtoProveedorServicioProductos = null;
		}
		
		/*objEnvioTrama = new RealizarSolicitudAutorizacion470(pObjUsuario,
		                                                     pObjFacturaGiro,
		                                                     pObjDatEntSolicitud,
		                                                     pObjTerceroNuevo,
		                                                     pObjNota,
		                                                     arrObjDtoProveedorServicioProductos);*/
		
		objEnvioTrama = new RealizarSolicitudAutorizacion549(pObjUsuario,
											                 pObjFacturaGiro,
											                 pObjDatEntSolicitud,
											                 pObjTerceroNuevo,
											                 pObjNota,
											                 pStrAdmisionCRC,
											                 arrObjDtoProveedorServicioProductos);
		
		//objRespuestaTrama = (RespuestaSolicitudAutorizacion)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaSolicitudAutorizacion)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())) {
		
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
	/**
	 * ********************************************************************
	 * @method gestionarConceptosYMediosPago
	 * 		   Metodo que permite gestionar los conceptos y los medios de 
	 * 		   pago asociados a una transaccion en caso que esta carezca de
	 * 		   ellos 
	 * @param  pObjFactura
	 * 		   Objeto factura que representa una transaccion que se esta 
	 * 		   llevando a cabo
	 * @param  pEnmParSisIdentificadorConcepto
	 * 		   Constante de enumeracion que representa al parametro de sistema
	 * 		   del cual se recuperar el valor de identificacion del concepto a 
	 * 		   generar
	 * @param  pEnmTipoIdentificador
	 * 		   Tipo con el cual se identificara el concepto, indica si el valor
	 * 		   de identificacion (valor parametro sistema), corresponde al id
	 * 		   o codigo del concepto a generar
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de 
  	 * 		   excepcion presentada
	 * @author hector.cuenca
	 * @date   12/08/2016
	 * *********************************************************************
	 */
	/*private void gestionarConceptosYMediosPago	(	Factura pObjFactura,
													EnumParametrosSistema pEnmParSisIdentificadorConcepto,
													EnumTiposIdentificadorConcepto pEnmTipoIdentificador
												)	throws Exception{
		
		MedioPago objMedioPago;
		Concepto objConceptoRepresentativo;
		double douValorTotalTransaccion;
		
		objConceptoRepresentativo	=	UtilConceptos.getInstance().generarConcepto	(	
																						pEnmParSisIdentificadorConcepto, 
																						pEnmTipoIdentificador,
																						Concepto.AFECTA_CAJA
																					);
		pObjFactura.setObjConceptoRepresentativo(objConceptoRepresentativo);
		
		if	(	pObjFactura.gestionarListConceptos().isEmpty()	){
			
			douValorTotalTransaccion = pObjFactura.getTotal();
			objConceptoRepresentativo.setValor(douValorTotalTransaccion);
			pObjFactura.getListaConceptos().add(objConceptoRepresentativo);
			
		}else{
			
			douValorTotalTransaccion = 0;
			
			for(Concepto objConcepto : pObjFactura.getListaConceptos()){
				
				if (objConcepto.isBooAfectaCaja()) {
				
					douValorTotalTransaccion	+=	objConcepto.getValor();
				}
			}
		}
		
		if	(	pObjFactura.gestionarListMediosPago().isEmpty()	){
			
			objMedioPago	=	(MedioPago)EnumMediosPago.EFECTIVO.getObjMedioPago().clone();
			objMedioPago.setValor(douValorTotalTransaccion);
			
			pObjFactura.getListMediosPago().add(objMedioPago);
		}
	}
	*/
	
	/**
	 * ****************************************************************
	 * @throws Exception
	 * @metodo consultarHistorialAutorizacion
	 * 		   consulta el historial de autorizaciones
	 * @param  pStrFecha
	 * 	       fecha para realizar la busqueda
	 * @return List<EstadoAutorizaciones>
	 *         Listado de autorizaciones 
	 * @autor  Roberth Martinez Vargas
	 * ****************************************************************
	 */
	@SuppressWarnings("unchecked")
	public  List<EstadoAutorizaciones> consultarHistorialAutorizacion(Usuario pObjUsuario,
																	  String pStrFecha) throws Exception{
		
		ConsultarHistorialAutorizacionPorFecha objEnvioTrama;
		RespuestaConsultarHistorialAutorizacionPorFecha objRespuestaTrama;
		
		objEnvioTrama = new ConsultarHistorialAutorizacionPorFecha(pObjUsuario,
																   pStrFecha);
		
		//objRespuestaTrama = (RespuestaConsultarHistorialAutorizacionPorFecha) ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaConsultarHistorialAutorizacionPorFecha)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())) {
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
		
		return (List<EstadoAutorizaciones>) objRespuestaTrama.getValorAtributoObj("lstEstadoAutorizaciones");
	}


}

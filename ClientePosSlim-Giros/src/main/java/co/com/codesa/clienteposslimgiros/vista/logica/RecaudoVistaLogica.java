/** 
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
package co.com.codesa.clienteposslimgiros.vista.logica;

import co.com.codesa.clienteposslimcontrolador.conexion.ProcesadorTramas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMediosPago;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.enumeraciones.operaciones.EnumTiposOperaciones;
import co.com.codesa.clienteposslimgiros.enumeraciones.proveedorServicioProducto.EnumTiposServicios;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.conceptos.UtilConceptos;
import co.com.codesa.clienteposslimgiros.utilidades.proveedorServicioProducto.UtilProveedorServicioProductoGiros;
import co.com.codesa.clienteposslimgiros.utilidades.vistaLogica.UtilVistaLogica;
import co.com.codesa.codesawrapper.modelo.dominio.RespuestaBuscarParametros;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Concepto;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DatoEntidad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.MedioPago;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Nota;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.AnulacionRecaudo;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.EnvioRecaudo;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.PagoRecaudo;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaAnulacionRecaudo;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaEnvioRecaudo;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaPagoRecaudo;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.bnet.ProveedorServicioProductoGirosDTO;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.giros.EnumTiposIdentificadorConcepto;

/** 
 * ********************************************************************
 * @class  RecaudoVistaLogica
 *		   Contiene las tramas relacionadas con el recaudo
 * @author roberth.martinez
 * @date   22/6/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class RecaudoVistaLogica {

	/**
	 * @variable instancia
	 * 			 manejo de clase singleton
	 */
	private static RecaudoVistaLogica instancia;
	
	/** 
	 * ********************************************************************
	 * @method RecaudoVistaLogica
	 * 		   constructor de la clase RecaudoVistaLogica
	 * @author roberth.martinez
	 * @date   22/6/2016
	 * *********************************************************************
	 */
	private RecaudoVistaLogica(){}	
	
	/** 
	 * ********************************************************************
	 * @method getInstance
	 * 		   patron singleton de la clase RecaudoVistaLogica
	 * @return RecaudoVistaLogica
	 * @author roberth.martinez
	 * @date   22/6/2016
	 * *********************************************************************
	 */
	public static RecaudoVistaLogica getInstance(){
	
		if (instancia == null){
			
			instancia= new RecaudoVistaLogica();
		}
			
		return instancia;
	}
	
	/**
	 * 
	 * Comportamiento migrado a la utilidad UtilProveedorServicioProductoGiros
	 */
	
	/*private ProveedorServicioProductoGirosDTO validarProveedorServicioProducto(Usuario pObjUsuario,
																			   Tercero pObjTercero,
																			   String pStrTipoServicio)throws Exception{
		
		ProveedorServicioProductoGirosDTO objDtoProveedorServicioProducto = null;
		
		//Necesario validar que exista configurado el proveedor - servicio - producto, referente al convenio que se va a ejecutar
		if(!pObjUsuario.getLstProveedorServicioProducto().isEmpty()){
			
			objDtoProveedorServicioProducto = pObjUsuario.buscarProveedorServicioProductoXTercero(pObjTercero,
																								  pStrTipoServicio);
		}
		
		if(objDtoProveedorServicioProducto == null){
			
			throw EnumMensajes.OPERACION_NO_CONFIGURADA_COMO_PROVEEDOR_SERVICIO_PRODUCTO.generarExcepcion(EnumClasesMensaje.ERROR);
		}
		
		return objDtoProveedorServicioProducto;
	}*/
	
	/** 
	 * ********************************************************************
	 * @method realizarEnvioRecaudo
	 * 		   realiza el envio de la trama Envio de recaudo
	 * @param  pObjFacturaGiro
	 * 		   Objeto factura que contiene informacion de la transaccion
	 * @param  pStrOperacionInusual
	 * 		   operacion inusual
	 * @param  pObjUsuario
	 *         objeto usuario
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   22/6/2016
	 * *********************************************************************
	 */
	public void realizarEnvioRecaudo(FacturaGiro pObjFacturaGiro,
									 String pStrOperacionInusual,
									 Usuario pObjUsuario) throws Exception{
		/**
		 * [Trama 491 | Envio de Recaudo]
		 */
		
		EnvioRecaudo objEnvioTrama;
		RespuestaEnvioRecaudo objRespuestaTrama;
		ProveedorServicioProductoGirosDTO objDtoProveedorServicioProducto;

		objDtoProveedorServicioProducto = UtilProveedorServicioProductoGiros.getInstance().validarProveedorServicioProductoXTercero(pObjFacturaGiro.getObjConvenio().getTercero(),
																		   															EnumTiposServicios.RECAUDO,
																		   															pObjUsuario,
																		   															EnumTiposOperaciones.ENVIO_FACTURACION_RECAUDO);
		
		pObjFacturaGiro.setStrIdTtransaccion(UtilidadesGiros.getInstance().obtenerIdTransaccion(pObjUsuario));
		
		/**
		 * Concepto de utilidad, no se sincroniza con GAMBLE, por que no afecta caja. 
		 * */
		/*UtilConceptos.getInstance().gestionarConceptoUtilidadXFactura	(	pObjFacturaGiro, 
																			EnumParametrosSistema.CODIGO_CONCEPTO_UTILIDAD_X_RECAUDO	);*/
		
		objEnvioTrama = new EnvioRecaudo(pObjUsuario,
										 pObjFacturaGiro,
										 pStrOperacionInusual,
										 objDtoProveedorServicioProducto);
		
		/*
		objEnvioTrama.setNitProveedor(objDtoProveedorServicioProducto.getStrNitProveedor());
		objEnvioTrama.setServicioCodigo(objDtoProveedorServicioProducto.getStrCodigoServicio());
		objEnvioTrama.setProductoCodigo(objDtoProveedorServicioProducto.getStrCodigoProducto());
		*/
		
		//objRespuestaTrama = (RespuestaEnvioRecaudo) ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaEnvioRecaudo)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())) {
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method realizarPagoRecaudo
	 * 		   realiza el envio de la trama de pago de recaudo
	 * @param  pObjFacturaGiro
	 * 		   objeto factura con la informacion de la transaccion
	 * @param  pStrOperacionInusual
	 * 	       operacion inusual
	 * @param  pObjUsuario
	 * 		   objeto factura giro
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   22/6/2016
	 * *********************************************************************
	 */
	public void realizarPagoRecaudo(FacturaGiro pObjFacturaGiro,
			 						String pStrOperacionInusual,
			 						Usuario pObjUsuario) throws Exception{
		/**
		 * [Trama 490 | Pago de Recaudo de Dispersion]
		 */
		
		PagoRecaudo objEnvioTrama;
		RespuestaPagoRecaudo objRespuestaTrama;
		ProveedorServicioProductoGirosDTO objDtoProveedorServicioProducto;
		Concepto objConceptoRepresentativo;

		objDtoProveedorServicioProducto = UtilProveedorServicioProductoGiros.getInstance().validarProveedorServicioProductoXTercero(pObjFacturaGiro.getTerceroOrigen(),
																		   															EnumTiposServicios.PAGO_RECAUDO,
																		   															pObjUsuario,
																		   															EnumTiposOperaciones.PAGO_FACTURACION_RECAUDO);
		pObjFacturaGiro.setStrIdTtransaccion(UtilidadesGiros.getInstance().obtenerIdTransaccion(pObjUsuario));
		
		objConceptoRepresentativo	=	UtilConceptos.getInstance().generarConcepto	(
																						EnumParametrosSistema.CODIGO_CONCEPTO_PAGO_RECAUDO, 
																						EnumTiposIdentificadorConcepto.CODIGO,
																						Concepto.AFECTA_CAJA
																					);
		pObjFacturaGiro.setObjConceptoRepresentativo(objConceptoRepresentativo);
		
		/**
		 * Concepto de utilidad, no se sincroniza con GAMBLE, por que no afecta caja. 
		 * */
		/*UtilConceptos.getInstance().gestionarConceptoUtilidadXFactura	(	pObjFacturaGiro, 
																			EnumParametrosSistema.CODIGO_CONCEPTO_UTILIDAD_X_RECAUDO	);*/
		
		objEnvioTrama = new PagoRecaudo(pObjUsuario,
										pObjFacturaGiro,
										pStrOperacionInusual,
										objDtoProveedorServicioProducto);
		/*
		objEnvioTrama.setNitProveedor(objDtoProveedorServicioProducto.getStrNitProveedor());
		objEnvioTrama.setServicioCodigo(objDtoProveedorServicioProducto.getStrCodigoServicio());
		objEnvioTrama.setProductoCodigo(objDtoProveedorServicioProducto.getStrCodigoProducto());
		*/
		
		//objRespuestaTrama = (RespuestaPagoRecaudo) ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaPagoRecaudo)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())) {
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method realizarAnulacionRecaudo
	 * 		   realiza el envio de la trama de anulacion del recaudo
	 * @param  pObjFacturaGiro
	 * 		   objeto factura con la informacion de la transaccion
	 * @param  pObjTercero
	 * 		   objeto tercero
	 * @param  pObjDatEntSolicitud
	 * 		   objeto DatoEntidad de la solicitud
	 * @param  pObjNota
	 * 		   objeto nota
	 * @param  pObjUsuario
	 * 		   objeto usuario
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   22/6/2016
	 * *********************************************************************
	 */
	public void realizarAnulacionRecaudo(FacturaGiro pObjFacturaGiro,
										 Tercero pObjTercero, 
										 DatoEntidad pObjDatEntSolicitud,
										 Nota pObjNota,
										 Usuario pObjUsuario)throws Exception{
		/**
		 * [Trama 488 | Realizar anulacion recaudo: permite realizar la anulacion de un recaudo] 
		 */

		AnulacionRecaudo objEnvioTrama;
		RespuestaAnulacionRecaudo objRespuestaTrama;
		ProveedorServicioProductoGirosDTO objDtoProveedorServicioProducto;
		MedioPago objMedioPago;
		Concepto objConceptoRepresentativo;

		pObjFacturaGiro.setStrIdTtransaccion(UtilidadesGiros.getInstance().obtenerIdTransaccion(pObjUsuario));
		
		//Exclusivo para anulacion
		if(pObjDatEntSolicitud.getId().equals(EnumParametrosApp.COD_DAT_ENT_TP_SOL_ANULACION.getValorPropiedad())){
		
			objDtoProveedorServicioProducto = UtilProveedorServicioProductoGiros.getInstance().validarProveedorServicioProductoXTercero(pObjFacturaGiro.getTerceroDestino(),
																																		EnumTiposServicios.RECAUDO,
																																		pObjUsuario,
																																		EnumTiposOperaciones.SOLICITUD_ANULACION_RECAUDO);
			objConceptoRepresentativo	=	UtilConceptos.getInstance().generarConcepto	(
																							EnumParametrosSistema.CODIGO_CONCEPTO_ANULACION_RECAUDO, 
																							EnumTiposIdentificadorConcepto.CODIGO,
																							Concepto.AFECTA_CAJA
																						);
			pObjFacturaGiro.setObjConceptoRepresentativo(objConceptoRepresentativo);
			
			if(pObjFacturaGiro.gestionarListMediosPago().isEmpty()){
				
				objMedioPago	=	(MedioPago)EnumMediosPago.EFECTIVO.getObjMedioPago().clone();
				objMedioPago.setValor(pObjFacturaGiro.getTotal());
				
				pObjFacturaGiro.getListMediosPago().add(objMedioPago);
			}
			
		}else{
			
			objDtoProveedorServicioProducto = null;
		}
		
		objEnvioTrama = new AnulacionRecaudo(pObjUsuario,
											 pObjFacturaGiro,
								  			 pObjDatEntSolicitud,
								  			 pObjTercero,
								  			 pObjNota,
								  			 objDtoProveedorServicioProducto);

		/*
		objEnvioTrama.setNitProveedor(objDtoProveedorServicioProducto.getStrNitProveedor());
		objEnvioTrama.setServicioCodigo(objDtoProveedorServicioProducto.getStrCodigoServicio());
		objEnvioTrama.setProductoCodigo(objDtoProveedorServicioProducto.getStrCodigoProducto());
		*/
		
		//objRespuestaTrama = (RespuestaAnulacionRecaudo)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaAnulacionRecaudo)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())) {

			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
		 							 						 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
		 							 						 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
}

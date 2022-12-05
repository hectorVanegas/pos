package co.com.codesa.clienteposslimgiros.vista.logica.superCombo;

import java.util.HashMap;
import java.util.List;

import co.com.codesa.clienteposslimcontrolador.conexion.ProcesadorTramas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.enumeraciones.operaciones.EnumTiposOperaciones;
import co.com.codesa.clienteposslimgiros.enumeraciones.proveedorServicioProducto.EnumTiposServicios;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.conceptos.UtilConceptos;
import co.com.codesa.clienteposslimgiros.utilidades.mediosPago.UtilMediosPago;
import co.com.codesa.clienteposslimgiros.utilidades.proveedorServicioProducto.UtilProveedorServicioProductoGiros;
import co.com.codesa.clienteposslimgiros.utilidades.validaciones.ValidacionesSuperCombo;
import co.com.codesa.clienteposslimgiros.utilidades.vistaLogica.UtilVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.CalcularConceptoSeguro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Concepto;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultarListaNegraSeguro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaSeguro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.PlanTarifario;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Promocion;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RegistrarEnviarSMS;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RegistrarSeguro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RegistrarSeguroDestino;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RegistrarSeguroOrigen;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaCalcularConceptoSeguro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaCambiarContrasena;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarListaNegraSeguro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaRegistrarEnviarSMS;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaRegistrarSeguro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaRegistrarSeguroDestino;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaRegistrarSeguroOrigen;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaValidaAgencianDocumentoConcepto;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ValidaAgencianDocumentoConcepto;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.bnet.ProveedorServicioProductoGirosDTO;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.giros.EnumTiposIdentificadorConcepto;


/**
 * ****************************************************************.
 * @autor: Roberth Martinez Vargas
 * @fecha: 26-may-2015 
 * @descripcion: Clase implementada con patron de diseño singleton, 
 * 				 que permite acceder a las diferentes funcionalidades
 * 				 del proceso de negocio de SuperCombo
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class SuperComboVistaLogica {

	/**
	 * @variable: instancia, atributo que vuelve estatico los accesos 
	 * 			  hacia las funciones que agrupa la clase de 
	 * 			  SuperComboVistaLogica
	 **/
	private static SuperComboVistaLogica instancia;
	
	private SuperComboVistaLogica() {}
	
	/**
  	 * ****************************************************************.
  	 * @metodo  getInstance (Metodo)
  	 * 			Metodo encargado de controlar e inicializar la 
  	 * 			instancia de la clase, para instanciarla una unica
  	 * 			vez durante todo el ciclo de vida de la aplicacion
  	 * 			(patron singleton)
  	 * @return SuperComboVistaLogica
  	 *         tipo de obj que representa a la clase misma
  	 * @autor: Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public static SuperComboVistaLogica getInstance(){
		
		if(instancia==null){
			instancia = new SuperComboVistaLogica();
		}
		
		return instancia;
	}
	
	/**
     * ****************************************************************
     * @throws Exception 
     * @metodo validaAgenciaDocumentoConcepto
     * 		   metodo utilizado para validar si un documento concepto 
     * 		   esta asociado a la agencia
     * @param  pStrIdDocumento
  	 * 		   pStrIdConceptoparametro que indica el id del documento.
  	 * @param 
     * @return String: respuesta trama
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */
	public boolean validaAgenciaDocumentoConcepto(Usuario pObjUsuario,
												  String pStrIdDocumento,
										  	   	  String pStrIdConcepto) throws Exception{
		
		/**
		 * Trama 127
		 * */
		
		ValidaAgencianDocumentoConcepto objEnvioTrama;
		RespuestaValidaAgencianDocumentoConcepto objRespuestaTrama;
		boolean booRespuesta = false;
		
		objEnvioTrama = new ValidaAgencianDocumentoConcepto(pObjUsuario,
															pStrIdDocumento, 
														    pStrIdConcepto);

		//objRespuestaTrama = (RespuestaValidaAgencianDocumentoConcepto)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaValidaAgencianDocumentoConcepto)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
		
			booRespuesta = ((String) objRespuestaTrama.getValorAtributoObj("strRespuesta")).equals("SI")? true : false;
			
		}else{
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
													   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
													   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
		
		return booRespuesta;
	}
	
	/**
     * ****************************************************************
     * @throws Exception 
     * @metodo validarListaNegraSeguro
     * 		   metodo utilizado para validar si tercero esta en la lista
     * 	       negra de la aseguradora
     * @param  pObjUsuarioSistema
     * 		   tercero a validar en la lista negra del seguro
     * @param  pObjTercero
     * 		   tercero a validar en la lista negra del seguro
     * @return String respuesta trama
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */
	public String validarListaNegraSeguro(Usuario pObjUsuario,
										  Tercero pObjTercero) throws Exception{
		/**
		 * Trama 87
		 * */
		
		ConsultarListaNegraSeguro objEnvioTrama;
		RespuestaConsultarListaNegraSeguro objRespuestaTrama;
		String strRespuesta = null;
		
		objEnvioTrama = new ConsultarListaNegraSeguro(pObjUsuario,
													  pObjTercero);

		//objRespuestaTrama = (RespuestaConsultarListaNegraSeguro)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaConsultarListaNegraSeguro)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
			
			strRespuesta = ((String) objRespuestaTrama.getValorAtributoObj("strResValidacion"));
			
		}else{
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}		
		
		return strRespuesta;
	}
	
	/** 
	 * ********************************************************************
	 * @method calcularConceptosSeguro
	 * 		   metodo utilizado para enviar la trama 9 de calcular 
     * 		   conceptos al seguro
	 * @param  pObjUsuario
	 * 		   objeto usuario
	 * @param  pObjFacturaSeguro
	 * 		   factura seguro con la informacion que se ha cargado
	 * @param  pBooOperacionPago
	 * 		   bandera indicando si es operacion de pago
	 * @return String
	 * 	       respuesta trama
	 * @throws Exception
	 * 	       Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   18/8/2016
	 * *********************************************************************
	 */
	@SuppressWarnings("unchecked")
	public String calcularConceptosSeguro(Usuario pObjUsuario,
										  FacturaSeguro pObjFacturaSeguro, 
										  boolean pBooOperacionPago) throws Exception{
		/**
		 * Trama 9
		 * */
		
		CalcularConceptoSeguro objEnvioTrama;
		RespuestaCalcularConceptoSeguro objRespuestaTrama;
		
		objEnvioTrama = new CalcularConceptoSeguro(pObjUsuario,
												   pObjFacturaSeguro, 
												   pBooOperacionPago);

		//objRespuestaTrama = (RespuestaCalcularConceptoSeguro)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaCalcularConceptoSeguro)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
			
			pObjFacturaSeguro.setPlanTarifario((PlanTarifario) objRespuestaTrama.getValorAtributoObj("objPlantarifario"));
			pObjFacturaSeguro.setListaConceptos((List<Concepto>) objRespuestaTrama.getValorAtributoObj("lstConcepto"));
			pObjFacturaSeguro.setListPromociones((HashMap<String,Promocion>) objRespuestaTrama.getValorAtributoObj("lstPromociones"));
			pObjFacturaSeguro.setTotal((Double) objRespuestaTrama.getValorAtributoObj("douVlrTotal"));
			
		}else{
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
		
		return "OK";
	}
	
	/** 
	 * ********************************************************************
	 * @method crearSeguro
	 * 		   invoca la entidad trama para la creacion del seguro
	 * @param  pObjUsuario
	 * 		   objeto usuario que realiza la operacion
	 * @param  pObjFacturaSeguro
	 * 		   objeto factura seguro que contiene el detalle para realizar la 
	 * 		   transaccion
	 * @param  pStrOperacionInusual
	 * 		   operacion inusual dada por el cajero
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   11/8/2016
	 * *********************************************************************
	 */
	public void crearSeguro(Usuario pObjUsuario,
			  			    FacturaSeguro pObjFacturaSeguro, 
			  			    String pStrOperacionInusual) throws Exception{
		/**
		 * Trama 485
		 * */
		
		RegistrarSeguro objEnvioTrama;
		RespuestaRegistrarSeguro objRespuestaTrama;
		ProveedorServicioProductoGirosDTO objDtoProveedorServicioProducto;
		
		objDtoProveedorServicioProducto = UtilProveedorServicioProductoGiros.getInstance().validarProveedorServicioProductoXTipoServicio(EnumTiposServicios.SEGURO,
																																		 pObjUsuario,
																																		 EnumTiposOperaciones.ENVIO_FACTURACION_SEGURO);
		
		/**
		 * Concepto de utilidad, no se sincroniza con GAMBLE, por que no afecta caja. 
		 * */
		/*UtilConceptos.getInstance().gestionarConceptoUtilidadXFactura	(	pObjFacturaSeguro, 
																			EnumParametrosSistema.CODIGO_CONCEPTO_UTILIDAD_X_SEGURO	);*/
		
		UtilMediosPago.getInstance().gestionarMediosPagoXFactura(pObjFacturaSeguro);
		
		pObjFacturaSeguro.setStrIdTtransaccion(UtilidadesGiros.getInstance().obtenerIdTransaccion(pObjUsuario));
		
		objEnvioTrama = new RegistrarSeguro(pObjUsuario,
											pObjFacturaSeguro, 
											pStrOperacionInusual,
											objDtoProveedorServicioProducto);
		

		//objRespuestaTrama = (RespuestaRegistrarSeguro)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaRegistrarSeguro)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
			
			pObjFacturaSeguro.setFechaBD((String) objRespuestaTrama.getValorAtributoObj("FechaBD"));
			pObjFacturaSeguro.setNumero((String) objRespuestaTrama.getValorAtributoObj("consecDocumentoConsecutivo"));
			pObjFacturaSeguro.setCertificadoNum((String) objRespuestaTrama.getValorAtributoObj("strNumeroCertificado"));
			pObjFacturaSeguro.setFechaSeguro((String) objRespuestaTrama.getValorAtributoObj("fechaSeguro"));
			pObjFacturaSeguro.setPolizaNumMatriz((String) objRespuestaTrama.getValorAtributoObj("strNumeroPoliza"));
			pObjFacturaSeguro.setRazonSocial((String) objRespuestaTrama.getValorAtributoObj("razonSocialAseguradora"));
			pObjFacturaSeguro.setNitAseguradora((String) objRespuestaTrama.getValorAtributoObj("strNitAseguradora"));
			
		}else{
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
	/**
     * ****************************************************************
     * @throws Exception 
     * @metodo crearSeguroOrigen
     * 		   metodo utilizado para enviar la trama 81 crear el seguro 
     * 		   origen
     * @autor Roberth Martinez Vargas
     * ****************************************************************
     */
	public void crearSeguroOrigen(Usuario pObjUsuario,
								  FacturaSeguro pObjFacturaSeguro, 
								  String pStrOperacionInusual) throws Exception{
		/**
		 * Trama 451
		 * */
		
		RegistrarSeguroOrigen objEnvioTrama;
		RespuestaRegistrarSeguroOrigen objRespuestaTrama;
		
		objEnvioTrama = new RegistrarSeguroOrigen(pObjUsuario,
												  pObjFacturaSeguro, 
												  pStrOperacionInusual);

		//objRespuestaTrama = (RespuestaRegistrarSeguroOrigen)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaRegistrarSeguroOrigen)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
			
			pObjFacturaSeguro.setNumero((String) objRespuestaTrama.getValorAtributoObj("consecDocumentoConsecutivo"));
			pObjFacturaSeguro.setPinSeguro((String) objRespuestaTrama.getValorAtributoObj("refControl"));
			pObjFacturaSeguro.setFechaBD((String) objRespuestaTrama.getValorAtributoObj("FechaBD"));
			pObjFacturaSeguro.setHoraBD((String) objRespuestaTrama.getValorAtributoObj("HoraBD"));
			pObjFacturaSeguro.setNitRC((String) objRespuestaTrama.getValorAtributoObj("NitRC"));
			pObjFacturaSeguro.setFechaSeguro((String) objRespuestaTrama.getValorAtributoObj("fechaSeguro"));
			
		}else{
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
	/**
     * ****************************************************************
     * @throws Exception 
     * @metodo crearSeguroDestino
     * 		   metodo utilizado para enviar la trama 82 crear el seguro 
     * 		   destino
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */
	public void crearSeguroDestino(Usuario pObjUsuario,
								   FacturaSeguro pObjFacturaSeguro) throws Exception{
		/**
		 * Trama 450
		 * */
		
		RegistrarSeguroDestino objEnvioTrama;
		RespuestaRegistrarSeguroDestino objRespuestaTrama;
		
		objEnvioTrama = new RegistrarSeguroDestino(pObjUsuario,
												   pObjFacturaSeguro);

		//objRespuestaTrama = (RespuestaRegistrarSeguroDestino)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaRegistrarSeguroDestino)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
			
			pObjFacturaSeguro.setCertificadoNum((String) objRespuestaTrama.getValorAtributoObj("numeroCertificado"));
			pObjFacturaSeguro.setFechaExpCert((String) objRespuestaTrama.getValorAtributoObj("fechaExpedicionCertificado"));
			pObjFacturaSeguro.setHoraExpCert((String) objRespuestaTrama.getValorAtributoObj("horaExpedicionCertificado"));
			pObjFacturaSeguro.setVigenciaSeg((String) objRespuestaTrama.getValorAtributoObj("VigenciaSeguro"));
			pObjFacturaSeguro.setSerieNumOtrosServNuevo((String) objRespuestaTrama.getValorAtributoObj("serieOtrosServicios"));
			pObjFacturaSeguro.setPolizaNumMatriz((String) objRespuestaTrama.getValorAtributoObj("numeroPoliza"));
			pObjFacturaSeguro.setRazonSocial((String) objRespuestaTrama.getValorAtributoObj("razonSocialAseguradora"));
			pObjFacturaSeguro.setNitAseguradora((String) objRespuestaTrama.getValorAtributoObj("nitAseguradora"));
			pObjFacturaSeguro.setDeducible((String) objRespuestaTrama.getValorAtributoObj("deducible"));
			
		}else{
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
	/**
     * ****************************************************************
     * @throws Exception 
     * @metodo enviarSMS
     * 		   metodo utilizado para enviar la trama 94 crear el movimiento 
     * 		   SMS y enviando el mensaje al tercero
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */
	@Deprecated
	public void enviarSMS(Usuario pObjUsuario,
						  FacturaGiro pObjFacturaGiroSMS, 
						  String strMensaje) throws Exception{
		/**
		 * Trama 94
		 * */
		
		RegistrarEnviarSMS objEnvioTrama;
		RespuestaRegistrarEnviarSMS objRespuestaTrama;
		
		objEnvioTrama = new RegistrarEnviarSMS(pObjUsuario,
											   pObjFacturaGiroSMS,
											   ValidacionesSuperCombo.getObjSuperCombo().getStrTipoSMSTrama(), 
											   strMensaje);

		//objRespuestaTrama = (RespuestaRegistrarEnviarSMS)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaRegistrarEnviarSMS)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())) {
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
}

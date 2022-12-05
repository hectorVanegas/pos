package co.com.codesa.clienteposslimgiros.eventos.envioRemesaInternacional;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.TableColumn;

import co.com.codesa.clienteposslimexception.exceptions.ClientePosSlimGirosException;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDocumentos;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEstadoTransaccion;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumImpresiones;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMediosPago;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumReimpresiones;
import co.com.codesa.clienteposslimgiros.enumeraciones.operaciones.EnumTiposOperaciones;
import co.com.codesa.clienteposslimgiros.enumeraciones.peticionMultiservicio.EnumPeticionesMultiservicio;
import co.com.codesa.clienteposslimgiros.enumeraciones.serviciosAdicionales.claveSeguridad.EnumTiposClaveSeguridad;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.caja.FormaDiligenciarMedioPago;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.GrillaUtil;
import co.com.codesa.clienteposslimgiros.formas.envioRemesaInternacional.FormaMovimientoCajaInternacional;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.reimpresion.FormaReimpresion;
import co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.SMSGiro.FormaPanelSMSGiro;
import co.com.codesa.clienteposslimgiros.interfaces.serviciosAdicionales.claveSeguridad.IOperacionesClaveSeguridad;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.utilidades.documentos.UtilDocumentos;
import co.com.codesa.clienteposslimgiros.utilidades.estadoTransaccion.EstadoTransaccion;
import co.com.codesa.clienteposslimgiros.utilidades.mediosPago.UtilMediosPago;
import co.com.codesa.clienteposslimgiros.utilidades.mensajes.Mensaje;
import co.com.codesa.clienteposslimgiros.utilidades.serviciosAdicionales.SMSGiro.UtilSMSGiro;
import co.com.codesa.clienteposslimgiros.utilidades.validaciones.ValidacionesROE;
import co.com.codesa.clienteposslimgiros.utilidades.validaciones.ValidacionesSuperCombo;
import co.com.codesa.clienteposslimgiros.vista.logica.GiroInternacionalVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.GiroVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Documento;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaSeguro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.MedioPago;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.NumeralInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.OperacionInusual;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TerceroInternacional;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

public class EventoFormaMovimientoCajaInternacional extends EventoAbstracto {

	/**
	 * @variable hmMediosPagoIngresados
	 * 			 Estructura hash que almacena el listado de los medios 
	 * 			 de pago ingresados sobre la funcionalidad 
	 **/
	private HashMap<String,MedioPago> hmMediosPagoIngresados;
	
	/**
	 * @variable lstMediosPagoHabilitados
	 * 			 Listado de medios de pago habilitados para la operacion
	 * 			 que se requiere realizar
	 **/
	private List<MedioPago> lstMediosPagoHabilitados;
	
	/**
	 * @variable objFacturaGiro
	 * 			 objeto factura de giro, sobre el cual se realizara 
	 * 			 el movimiento
	 **/
	private FacturaGiroInternacional objFacturaGiro;
	
	/**
	 * @variable strOperacionInusual
	 * 			 Cadena que almacena el diligenciamiento de una operacion
	 * 			 inusual
	 **/
	private String strOperacionInusual;
	
	/**
	 * @variable objFacturaSMS
	 * 			 objeto factura de SMS, sobre el cual se realizara 
	 * 			 el movimiento
	 **/
	//private FacturaGiro objFacturaGiroSMS;
	
	/**
	 * @variable objFacturaSeguro
	 * 			 objeto factura de Seguro, sobre el cual se realizara 
	 * 			 el movimiento
	 **/
	private FacturaSeguro objFacturaSeguro;
	
	/**
	 * @variable objMedioPagoEfectivo
	 * 			 objeto medio de pago para efectivo
	 */
	private MedioPago objMedioPagoEfectivo;
	
	/**
	 * @variable booValidaTransaccion
	 * 			 bandera que permite identificar si la transaccion de
	 * 			 movimiento fue completada o no durante el proceso de
	 * 			 confirmacion de la operacion
	 **/
	private boolean booValidaTransaccion;
	
	/**
	 * @variable douVlrTotal
	 * 			 Valor total de la operacion que se esta diligenciando
	 * 			 total a cobrar o total a pagar, dependiendo de la 
	 * 			 operacion
	 **/
	private double douVlrTotal;
	
	/**
	 * @variable douValorRecibido
	 * 			 Valor acumulado referente a los ingresos que se han 
	 * 			 realizado
	 **/
	private double douValorRecibido;
	
	/**
	 * @variable douValorCambio
	 * 			 Valor de diferencia, calculado automaticamente de la resta del 
	 * 			 valor del total de la operacion con respecto al valor recibido
	 **/
	private double douValorCambio;
	
	/**
	 * @variable objDouTotalIngresoXTarjetas
	 * 			 Valor total ingresado por tarjetas como medio de pago
	 **/
	private double douTotalIngresoXTarjetas;
	
	/**
	 * @variable intConsecutivoMedioPagoIngresado
	 * 			 Consecutivo que identifica el medio de pago que ha sido 
	 * 			 ingresado
	 **/
	private int intConsecutivoMedioPagoIngresado;
	
	/**
	 * @variable objOperacionInusual
	 * 			 objeto de operacion inusual, para almacenar el dato entidad
	 * 	 		 de la operacion inusual y la nota.
	 **/
	private OperacionInusual objOperacionInusual;
	
	/**
	 * @variable enmTipoOperacion
	 * 			 Tipo de operacion que se esta llevando a cabo
	 */
	private EnumTiposOperaciones enmTipoOperacion;
	
	/**
	 * @variable operacionesClaveSeguridad
	 * 			 interfaz de operaciones relacionadas con el servicio
	 * 		     de clave de seguridad
	 */
	private IOperacionesClaveSeguridad operacionesClaveSeguridad;
	
	/**
	 * @variable lstCodMsgXConfirmarTransaccion
	 * 			 Listado de mensajes que ameritan confirmar la transaccion para un
	 * 			 proceso de venta
	 */
	private static final List<String> lstCodMsgXConfirmarTransaccion;
	
	private FacturaGiroInternacional ObjEnvioGiroInternacional;
	
	static
	{
		lstCodMsgXConfirmarTransaccion	=	new ArrayList<String>();
		
		lstCodMsgXConfirmarTransaccion.add(EnumMensajes.ERROR_GENERAL.getCodigo());
		lstCodMsgXConfirmarTransaccion.add(EnumMensajes.EJB_ERROR_NO_CONTROLADO.getCodigo());
		lstCodMsgXConfirmarTransaccion.add(EnumMensajes.SOCKET_SIMS_AGOTO_TIEMPO_ESPERA_.getCodigo());
		lstCodMsgXConfirmarTransaccion.add(EnumMensajes.SOCKET_EMPRESA_AGOTO_TIEMPO_ESPERA.getCodigo());
		lstCodMsgXConfirmarTransaccion.add(EnumMensajes.SOCKET_EMPRESA_ERROR_NO_CONTROLADO.getCodigo());
		lstCodMsgXConfirmarTransaccion.add(EnumMensajes.EJB_ERROR_NO_CONTROLADO2.getCodigo());
		lstCodMsgXConfirmarTransaccion.add(EnumMensajes.EJB_AGOTO_TIEMPO_ESPERA.getCodigo());
	}
	
	
	/**
	 * @variable strCRCAdmisionEntregaTirilla
	 * 			 cadena que contiene datos multiregistro con el formato
	 *           IDPropiedad|DescripcionPropiedad|Respuesta1~ ...
	 * 			 proceso de venta
	 */
	 private String strCRCAdmisionEntregaTirilla;
	
	
	/**
  	 * ****************************************************************.
  	 * @method EventoFormaMovimientoCaja
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de sus acciones
  	 * @param  pForma
  	 * 		   referencia a la GUI de la cual se estan controlando los 
  	 * 		   eventos
  	 * @param  pObjFacturaGiro
  	 * 		   objeto factura de giro, sobre el cual se realizara el 
  	 * 		   movimiento
  	 * @param  pObjFacturaSeguro
  	 * 		   objeto facura seguro para supercombo
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @author hector.cuenca
  	 * ****************************************************************
  	 */
	public EventoFormaMovimientoCajaInternacional(FormaGenerica pForma,
									 FacturaGiroInternacional pObjFacturaGiro) throws Exception{
		super(pForma);
		this.objFacturaGiro = pObjFacturaGiro;
		this.booValidaTransaccion = true;
//		this.objFacturaSeguro = pObjFacturaSeguro;
		this.intConsecutivoMedioPagoIngresado = 0;
		this.douTotalIngresoXTarjetas = 0;
		this.hmMediosPagoIngresados = new HashMap<String,MedioPago>();
		this.objOperacionInusual = new OperacionInusual();
	}
	
	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma) throws Exception{
		
		this.cargarFormulario();
	}
	
	@Override
	public void accionarVentanaDesplegada(WindowEvent pEvtWindowOpened) throws Exception {
		
//		this.operacionesClaveSeguridad.validarEstadoServicio(this.objFacturaGiro, 
//														     this.enmTipoOperacion,
//														     null);
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo cargarFormulario
  	 * 		   Metodo que se encarga de gestionar el cargue de la 
  	 * 		   informacion sobre el formulario
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void cargarFormulario()throws Exception{
		
		Format frtFormato;
			
		this.douVlrTotal = this.objFacturaGiro.getDouTotalMovimiento();
		
		frtFormato = UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO();
		
		this.castFrmMovimientoCajaInternacional().getTxtValorPagar().setText(frtFormato.format(this.douVlrTotal));
		this.castFrmMovimientoCajaInternacional().getTxtTotalMovimiento().setText(frtFormato.format(0.0));
		
		this.cargarSegunDocumento(this.objFacturaGiro.getDocumento());
		
//		this.operacionesClaveSeguridad = this.castFrmMovimientoCajaInternacional().getScpServiciosAdicionales().getOperaciones().adicionarServicio(EnumServiciosAdicionales.CLAVE_SEGURIDAD, 
//				  																													  "pnlClaveSeguridad");
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo cargarSegunDocumento
  	 * 		   Condiciona el cargue y los valores iniciales sobre la
  	 * 		   funcionalidad dependiendo del documento que se encuentre
  	 * 		   procesando
  	 * @param pObjDocumentoRecibido
  	 * 		  Documento asociado a la operacion 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void cargarSegunDocumento(Documento pObjDocumentoRecibido)throws Exception{
		
//		if(pObjDocumentoRecibido.getNaturaleza().equals(EnumParametrosApp.DOCUMENTO_NATURALEZA_NEGATIVA.getValorPropiedad())){
			
//			this.castFrmMovimientoCajaInternacional().getLblValorPagar().setText(EnumEtiquetas.LBL_MVC_VALOR_PAGAR.getValor(true));
//			this.castFrmMovimientoCajaInternacional().getLblTotalMovimiento().setText(EnumEtiquetas.LBL_MVC_TOTAL_MOVIMIENTO_PAGO.getValor(true));
//			this.castFrmMovimientoCajaInternacional().setTituloForma(EnumEtiquetas.TTL_MVC_VENTANA_SALIDA);
//			
//			this.castFrmMovimientoCajaInternacional().getBtnAdicionarMedioPago().setEnabled(true);
//			this.castFrmMovimientoCajaInternacional().getBtnEliminarMedioPago().setEnabled(true);
//			this.castFrmMovimientoCajaInternacional().getBtnVerEditarMedioPago().setEnabled(true);
//			
//			this.objMedioPagoEfectivo = EnumMediosPago.EFECTIVO.getObjMedioPago();
//			
//			if(this.objMedioPagoEfectivo != null){
//			
//				this.objMedioPagoEfectivo = (MedioPago)this.objMedioPagoEfectivo.clone();
//				this.objMedioPagoEfectivo.setValor(this.douVlrTotal);
//				
//				this.actualizarGrillaMediosPago(this.objMedioPagoEfectivo,
//												false);
//			}
//			
//			this.actualizarMovimiento(0,
//									  this.douVlrTotal);
//			
//			if(UtilDocumentos.isDocumentoTipoEnum(pObjDocumentoRecibido,
//				   	  EnumDocumentos.FACTURA)){
//			
//				this.enmTipoOperacion = EnumTiposOperaciones.PAGO_FACTURACION_GIRO;
//				
//			}else if(UtilDocumentos.isDocumentoTipoEnum(pObjDocumentoRecibido, 
//					EnumDocumentos.RECAUDO)){
//				
//				this.enmTipoOperacion = EnumTiposOperaciones.PAGO_FACTURACION_RECAUDO;
//			}
//			
////		}
		
//		else{
			
			this.cargarMediosPagoHabilitados(pObjDocumentoRecibido);
			
			this.actualizarMovimiento(0,
	  				  				  0);
//		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo cargarMediosPagoHabilitados
  	 * 		   Define segun el documento y el tipo de operacion que se 
  	 * 		   encuentra realizando, el listado de medios de pago autorizados
  	 * 		   para colocar a disposicion del usuario sobre la funcionalidad
  	 * @param pObjDocumentoRecibido
  	 * 		  Documento asociado a la operacion 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void cargarMediosPagoHabilitados(Documento pObjDocumentoRecibido)throws Exception{
		
		MedioPago objMedioPagoEfectivo;
		
//		if(UtilDocumentos.isDocumentoTipoEnum(pObjDocumentoRecibido,
//										   	  EnumDocumentos.FACTURA)){
			
			this.lstMediosPagoHabilitados = new ArrayList<MedioPago>();
			
			objMedioPagoEfectivo = EnumMediosPago.EFECTIVO.getObjMedioPago();
			
			if(objMedioPagoEfectivo != null){
				
				this.lstMediosPagoHabilitados.add(objMedioPagoEfectivo);
			}
			
			this.enmTipoOperacion = EnumTiposOperaciones.ENVIO_FACTURACION_GIRO;
			
//		}
//		else if(UtilDocumentos.isDocumentoTipoEnum(pObjDocumentoRecibido, 
//													EnumDocumentos.RECAUDO)){
//			
//			this.lstMediosPagoHabilitados = super.getObjUsuario().getMediosPago();
//			
//			this.enmTipoOperacion = EnumTiposOperaciones.ENVIO_FACTURACION_RECAUDO;
//		}
	}
	
	@Override
	public void accionarEjecucion(Component pComponent,
								  AWTEvent pEvtEjecucion) throws Exception {
		
		if(pComponent.equals(this.castFrmMovimientoCajaInternacional().getBtnAdicionarMedioPago())){
			
			this.diligenciarMedioPago(null);
			
		}else if(pComponent.equals(this.castFrmMovimientoCajaInternacional().getBtnVerEditarMedioPago())){
			
			this.editarEliminarMedioPago(true);
			
		}else if(pComponent.equals(this.castFrmMovimientoCajaInternacional().getBtnEliminarMedioPago())){
			
			this.editarEliminarMedioPago(false);
			
		}else{
			super.accionarEjecucion(pComponent,pEvtEjecucion);
		}
	}
	
	@Override
	public void confirmar() throws Exception{
		
		UtilComponentesGUI.getInstance().validarCamposObligatorios	(	this.getFrmForma(), 
																		true, 
																		true
																	);
		if(this.douValorCambio>0){
			//existe faltante
			
			throw EnumMensajes.VALOR_RECIBIDO_INFERIOR_VALOR_COBRADO.generarExcepcion(EnumClasesMensaje.ERROR);
			
		}else{
			
//			UtilSMSGiro.getInstancia().validarSMSGiro	(	super.getFrmForma(), 
//															this.objFacturaGiro.getTerceroDestino(),
//															this.objFacturaGiro
//														);
			this.realizarOperacionInternacional();
		}
	}
	
	@Override
	public void validaDatosAdicionales(JPanel pnlSeccionAdicional) 
		throws Exception 
	{
		if	(	pnlSeccionAdicional instanceof FormaPanelSMSGiro	)
		{
			((FormaPanelSMSGiro)pnlSeccionAdicional).getEvaControlEventos().ejecutar();
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo realizarOperacion
  	 * 		   Despliega el proceso logico requerido para realizar la
  	 * 		   operacion deseada, segun la naturaleza (envio / pago) y 
  	 * 		   tipo de documento 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void realizarOperacion()throws Exception{
		
		Documento objDocumento;
		
		this.objFacturaGiro.setListMediosPago(new ArrayList<MedioPago>(this.hmMediosPagoIngresados.values()));
		
		objDocumento = this.objFacturaGiro.getDocumento();
		
		if(this.objMedioPagoEfectivo!=null){
			
			this.objMedioPagoEfectivo.setValor(this.objMedioPagoEfectivo.getValor()-Math.abs(this.douValorCambio));
		}
		
		try{
			
			if(objDocumento.getNaturaleza().equals(EnumParametrosApp.DOCUMENTO_NATURALEZA_POSITIVA.getValorPropiedad())){
				
				if(UtilDocumentos.isDocumentoTipoEnum(objDocumento, 
													  EnumDocumentos.FACTURA)){
					this.facturarEnvioGiro();
					
				}else if(UtilDocumentos.isDocumentoTipoEnum(objDocumento, 
						  									EnumDocumentos.RECAUDO)){
					
//					this.realizarEnvioRecaudo(this.douValorRecibido,
//											   this.douValorCambio);
				}
				
			}else if(objDocumento.getNaturaleza().equals(EnumParametrosApp.DOCUMENTO_NATURALEZA_NEGATIVA.getValorPropiedad())){
				
			}
		
		}catch(Exception e){
			
			if(this.objMedioPagoEfectivo!=null){
			
				this.objMedioPagoEfectivo.setValor(this.objMedioPagoEfectivo.getValor()+Math.abs(this.douValorCambio));
			}
			
			throw e;
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo realizarOperacionInternacional
  	 * 		   Despliega el proceso logico requerido para realizar la
  	 * 		   operacion deseada.
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor didier.silva
  	 * ****************************************************************
  	 */
	private void realizarOperacionInternacional() throws Exception{
		
		this.enviarGiro();
		
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo enviarGiro
  	 * 		   Realiza el proceso de envio de remesa internacional
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor didier.silva
  	 * ****************************************************************
  	 */
	private void enviarGiro() throws Exception{
			
		GiroInternacionalVistaLogica.getInstancia().envioGiro(	getObjUsuario(), 
																EnumPeticionesMultiservicio.GIN_ENVIO_GIRO.getObjServicioPeticion(), 
																this.objFacturaGiro);
		
		EnumMensajes.GIRO_ENVIADO_EXITOSAMENTE.desplegarMensaje(super.getFrmForma(), 
				   EnumClasesMensaje.INFORMACION, 
				   this.objFacturaGiro.getReferenciaControl());
		
		this.getTasaDolar();
	
		boolean imprimio;
		
		imprimio = EnumImpresiones.ENVIO_GIRO_INTERNACIONAL.ejecutarImpresion(super.getFrmForma(), 
									  		 false,
									  		 this.objFacturaGiro,
									  		 super.getObjUsuario(),
									  		 EnumPeticionesMultiservicio.GIN_ENVIO_GIRO.getObjServicioPeticion());
		
		super.cerrarForma();
//		this.limpiarObjTemporales();
	}
	
	private void getTasaDolar() throws Exception{
		
		Format frtFormat = UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO_DECIMAL_REMESAS();
		
		double strTasaDolar;
		String strValor;
		
		strTasaDolar = Double.valueOf(this.objFacturaGiro.getDouValorEnvio()) / Double.valueOf(this.objFacturaGiro.getDouValorEnDolar());
		strValor = String.valueOf(frtFormat.format(strTasaDolar)).replace(",", ".");
		this.objFacturaGiro.setStrTMR(strValor);
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo controlExcepcionPersonalizado
  	 * 		   metodo que permite centralizar el control de excepciones
  	 * 		   se personaliza este control ya que debe considerarse un
  	 * 		   control especial para validacion de transaccion
  	 * @param e
  	 * 		  Excepcion general, que puede representar una excepcion
  	 * 		  personalizada o general del sistema
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public void controlExcepcion(Exception e){
	
		super.controlExcepcion(e);
		
		try{
//			this.validarTransaccion();
		}catch(Exception e1){
			super.controlExcepcion(e1);
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo diligenciarMedioPago
  	 * 		   Despliega la forma para diligenciar un medio de pago,
  	 * 		   segun el escenario este permite el ingreso o la edicion 
  	 * 		   de este
  	 * @param pObjMedioPago 
  	 * 		  Medio de pago que sera diligenciado, en caso de estar nulo
  	 * 		  simbolizara un ingreso, en caso contrario se asume que es 
  	 * 		  una edicion
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void diligenciarMedioPago(MedioPago pObjMedioPago)throws Exception{
		
		FormaDiligenciarMedioPago frmDiligenciarMedioPago;
		double douValorMedioPagoActual = 0;
		boolean booEditaMedioPago;
		
		if(pObjMedioPago != null){
			
			douValorMedioPagoActual = pObjMedioPago.getValor();
			booEditaMedioPago=true;
			
		}else{
			
			booEditaMedioPago=false;
		}
		
		frmDiligenciarMedioPago = new FormaDiligenciarMedioPago(super.getFrmForma(), 
					 									  		true, 
					 									  		pObjMedioPago,
					 									  		this.hmMediosPagoIngresados,
					 									  		this.douTotalIngresoXTarjetas,
					 									  		this.douVlrTotal,
					 									  		this.lstMediosPagoHabilitados);
		
		if(frmDiligenciarMedioPago.getEnmBotEncAccionSolicitada().equals(EnumBotonesEncabezado.BTNGUARDAR)){
			
			pObjMedioPago = frmDiligenciarMedioPago.castEvaFrmDiligenciarMedioPago().getObjMedioPagoDiligenciado();
			
			this.actualizarGrillaMediosPago(pObjMedioPago,
											booEditaMedioPago);
			
			this.actualizarMovimiento(douValorMedioPagoActual,
									  pObjMedioPago.getValor());
			
			if(UtilMediosPago.getInstance().isMedioPagoTipoEnum(pObjMedioPago,
																EnumMediosPago.TARJETA_CREDITO,
																EnumMediosPago.TARJETA_DEBITO)){
			
				this.douTotalIngresoXTarjetas += pObjMedioPago.getValor();
			
			}else if(UtilMediosPago.getInstance().isMedioPagoTipoEnum(pObjMedioPago,
									  								  EnumMediosPago.EFECTIVO)){
			
				this.objMedioPagoEfectivo = pObjMedioPago;
			}
		}
		
		this.habilitarIngresoMedioPago();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo habilitarIngresoMedioPago
  	 * 		   Metodo que permite validar si habilita o des-habilita la
  	 * 		   opcion para ingresar y/o diligenciar el ingreso de un
  	 * 		   medio de pago
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void habilitarIngresoMedioPago()throws Exception{
		
		if(this.lstMediosPagoHabilitados.size()==1
				&& this.hmMediosPagoIngresados.size()==1){
			
			this.castFrmMovimientoCajaInternacional().getBtnAdicionarMedioPago().setEnabled(false);
			
		}else{
			
			this.castFrmMovimientoCajaInternacional().getBtnAdicionarMedioPago().setEnabled(true);
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo editarMedioPago
  	 * 		   Permite realizar la slicitud de edicion o eliminacion de
  	 * 		   un medio de pago previamente ingresado
  	 * @param pBooEditaElimina
  	 * 		  Bandera que permite identificar si la operacion que se 
  	 * 		  desea ejecutar es una edicion (true), o una eliminacion 
  	 * 		  (false), de un medio de pago previamente ingresado
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void editarEliminarMedioPago(boolean pBooEditaElimina)throws Exception{
		
		MedioPago objMedioPagoSeleccionado;
		GrillaUtil tblMediosPago;
		TableColumn objColumnaMedioPago;
		int intFilaSeleccionada;
		
		tblMediosPago = this.castFrmMovimientoCajaInternacional().getTblMediosPago();
		
		if(tblMediosPago.getModel().getRowCount() > 0){
			
			intFilaSeleccionada = tblMediosPago.getSelectedRow();
			
			if(intFilaSeleccionada >=0 ){
				
				objColumnaMedioPago = tblMediosPago.getColumn(EnumEtiquetas.TTL_MVC_GRILLA_MEDPAGO_DESCRIPCION.toString());
				
				objMedioPagoSeleccionado = (MedioPago)tblMediosPago.getValueAt(intFilaSeleccionada, 
										 									   objColumnaMedioPago.getModelIndex());
				
				this.hmMediosPagoIngresados.remove(objMedioPagoSeleccionado.getStrConsecutivoIngreso());
				
				if(UtilMediosPago.getInstance().isMedioPagoTipoEnum(objMedioPagoSeleccionado,
													  				EnumMediosPago.TARJETA_CREDITO,
													  				EnumMediosPago.TARJETA_DEBITO)){
					
					this.douTotalIngresoXTarjetas -= objMedioPagoSeleccionado.getValor();
				}
				
				if(pBooEditaElimina){
				
					this.diligenciarMedioPago(objMedioPagoSeleccionado);
					
				}else{
					
					tblMediosPago.getPropiedades().removerFilaGrilla(intFilaSeleccionada);
					
					this.actualizarMovimiento(objMedioPagoSeleccionado.getValor(),
							  				  0);
					
					if(UtilMediosPago.getInstance().isMedioPagoTipoEnum(objMedioPagoSeleccionado,
							  											EnumMediosPago.EFECTIVO)){

						this.objMedioPagoEfectivo = null;
					}
				}
				
			}else{
				
				throw EnumMensajes.DEBE_SELECCIONAR_REGISTRO_PARA_OPERACION.generarExcepcion(EnumClasesMensaje.ERROR);
			}
			
		}else{
			
			throw EnumMensajes.SE_NECESITAN_REGISTROS_EN_TABLA.generarExcepcion(EnumClasesMensaje.ERROR);
		}
		
		if(!pBooEditaElimina){
			
			this.habilitarIngresoMedioPago();
		}
	}
	
	
	/** 
	 * ********************************************************************
	 * @method actualizarGrillaMediosPago
	 * 		   Permite actualizar la grilla de medios de pago, adicionando
  	 * 		   o actualizando un registro de medio de pago 
  	 * @param  pObjMedioPagoDiligenciado
  	 * 		   Medio de pago diligenciado, referente a un ingreso nuevo
  	 * 		   o una actualizacion de uno previamente cargado
  	 * @param  pBooEditaMedioPago
  	 * 		   Bandera que permite identificar si la operacion que se llevo 
  	 * 		   a cabo es una edicion (true), o un ingreso nuevo (false)
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   1/12/2016
	 * *********************************************************************
	 */
	private void actualizarGrillaMediosPago(MedioPago pObjMedioPagoDiligenciado,
											boolean pBooEditaMedioPago)throws Exception{
		GrillaUtil tblGrillaMediosPago;
		TableColumn objColumnaId;
		TableColumn objColumnaValor;
		TableColumn objColumnaDescripcion;
		int intFilaSeleccionada;
		
		tblGrillaMediosPago = this.castFrmMovimientoCajaInternacional().getTblMediosPago();
		
		if(pBooEditaMedioPago){
		
			objColumnaId = tblGrillaMediosPago.getColumn(EnumEtiquetas.TTL_MVC_GRILLA_MEDPAGO_ID.toString());
			objColumnaDescripcion = tblGrillaMediosPago.getColumn(EnumEtiquetas.TTL_MVC_GRILLA_MEDPAGO_DESCRIPCION.toString());
			objColumnaValor = tblGrillaMediosPago.getColumn(EnumEtiquetas.TTL_MVC_GRILLA_MEDPAGO_VALOR.toString());
			
			intFilaSeleccionada = tblGrillaMediosPago.getSelectedRow();
			
			tblGrillaMediosPago.setValueAt(pObjMedioPagoDiligenciado.getId(), 
										   intFilaSeleccionada, 
										   objColumnaId.getModelIndex());
			
			tblGrillaMediosPago.setValueAt(pObjMedioPagoDiligenciado, 
					  					   intFilaSeleccionada, 
					  					   objColumnaDescripcion.getModelIndex());
			
			tblGrillaMediosPago.setValueAt(pObjMedioPagoDiligenciado.getValor(), 
					  					   intFilaSeleccionada, 
					  					   objColumnaValor.getModelIndex());
		}else{
			
			this.intConsecutivoMedioPagoIngresado++;
			
			pObjMedioPagoDiligenciado.setStrConsecutivoIngreso(String.valueOf(this.intConsecutivoMedioPagoIngresado));
			
			tblGrillaMediosPago.getPropiedades().adicionarFilaGrilla(new Object[]{pObjMedioPagoDiligenciado.getStrConsecutivoIngreso(),
																				  pObjMedioPagoDiligenciado.getId(),
																				  pObjMedioPagoDiligenciado,
																				  pObjMedioPagoDiligenciado.getValor()});
			
			this.hmMediosPagoIngresados.put(pObjMedioPagoDiligenciado.getStrConsecutivoIngreso(), 
											pObjMedioPagoDiligenciado);
		}
	}
	
	
	/** 
	 * ********************************************************************
	 * @method actualizarMovimiento
	 * 		   Metodo que se encarga de actualizar automaticamente el
  	 * 		   valor de cambio una vez es producido un ingreso en el
  	 * 		   valor recibido
	 * @param  pDouValorAporteActual
	 * 		   valor double actual
	 * @param  pDouValorAporteNuevo
	 * 		   valor double nuevo
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   1/12/2016
	 * *********************************************************************
	 */
	private void actualizarMovimiento(double pDouValorAporteActual,
									  double pDouValorAporteNuevo)throws Exception{
		
		NumberFormat frtFormato;
		
		frtFormato = UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO();
		
		this.douValorRecibido = frtFormato.parse(this.castFrmMovimientoCajaInternacional().getTxtTotalMovimiento().getText()).doubleValue();
		this.douValorRecibido += (pDouValorAporteNuevo - pDouValorAporteActual);
		
		this.castFrmMovimientoCajaInternacional().getTxtTotalMovimiento().setText(frtFormato.format(this.douValorRecibido));
		
		this.douValorCambio = this.douVlrTotal - this.douValorRecibido;
		
		this.castFrmMovimientoCajaInternacional().getTxtFaltante().setText(frtFormato.format(Math.abs(this.douValorCambio)));
		
		if(this.douValorCambio<0){//sobra
			
			this.castFrmMovimientoCajaInternacional().getLblCambio().setText(EnumEtiquetas.LBL_FCG_CAMBIO_SOBRA.getValor(true));
			this.castFrmMovimientoCajaInternacional().getTxtFaltante().setForeground(Color.blue);
			
		}else if(this.douValorCambio>0){//falta
			
			this.castFrmMovimientoCajaInternacional().getLblCambio().setText(EnumEtiquetas.LBL_FCG_CAMBIO_FALTA.getValor(true));
			this.castFrmMovimientoCajaInternacional().getTxtFaltante().setForeground(Color.red);
			
		}else{//exacto
			
			this.castFrmMovimientoCajaInternacional().getLblCambio().setText(EnumEtiquetas.LBL_FCG_CAMBIO_EXACTO.getValor(true));
			this.castFrmMovimientoCajaInternacional().getTxtFaltante().setForeground(Color.black);
			
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo validarTransaccion
  	 * 		   metodo que permite ejecutar ciertos comportamientos especiales
  	 * 		   cuando el proceso de confirmacion de la operacion ha sido 
  	 * 		   interrumpido
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void validarTransaccion()throws Exception{
		
		Long transaccionId;
		Documento objDocumento;
		
		if(!this.booValidaTransaccion){//Se genero interrupcion sobre operacion de registro
			
			objDocumento = this.objFacturaGiro.getDocumento();
			
			if(objDocumento.getNaturaleza().equals(EnumParametrosApp.DOCUMENTO_NATURALEZA_POSITIVA.getValorPropiedad())){
				
				transaccionId = super.getObjUsuario().getPrevTransaccId();
				super.getObjUsuario().setTransaccId(transaccionId);
				
				EnumMensajes.VERIFIQUE_TRANSACCION.desplegarMensaje(super.getFrmForma(), 
																	EnumClasesMensaje.ADVERTENCIA);
				
				if	(		ValidacionesSuperCombo.getObjSuperCombo().isBooRealizaSeguro()
						&& 	this.objFacturaSeguro != null
					)
				{
					EnumMensajes.NO_REALIZA_SEGURO_X_GIRO_NO_CONFIRMADO.desplegarMensaje(super.getFrmForma(), 
					                                                                     EnumClasesMensaje.ADVERTENCIA);
				}
				
				EstadoTransaccion.getInstance().grabarValorPropiedad(EnumEstadoTransaccion.VERIFICADO,
												 				     "false");
				this.generarReImpresionEnvio();
				
			}else if(objDocumento.getNaturaleza().equals(EnumParametrosApp.DOCUMENTO_NATURALEZA_NEGATIVA.getValorPropiedad())){
				
				if(this.objFacturaGiro.isExterno()){
					
					EstadoTransaccion.getInstance().grabarValorPropiedad(EnumEstadoTransaccion.PIN_EXT,
													 					 this.objFacturaGiro.getReferenciaControl());
					
					EnumMensajes.PAGO_EXTERNO_REQUIERE_CONFIRMACION_DEL_PROVEEDOR.desplegarMensaje(super.getFrmForma(), 
																								   EnumClasesMensaje.ERROR);
				}else{
					EnumMensajes.VERIFIQUE_TRANSACCION.desplegarMensaje(super.getFrmForma(), 
																		EnumClasesMensaje.ADVERTENCIA);
				}
				
				this.generarReImpresionPago();
			}
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method facturarEnvioGiro
	 * 		   metodo exclusivo del proceso de envio de giro, que realiza
  	 * 		   los procesos necesarios para facturar el envio de giro
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   1/12/2016
	 * *********************************************************************
	 */
	private void facturarEnvioGiro() throws Exception{
		
		this.realizarEnvioGiro(this.douValorRecibido,
				   			   this.douValorCambio);
		
		this.realizarEnvioSeguro();
		
		ValidacionesROE.getInstance().validarROE(this, 
												 this.objFacturaGiro);
		super.cerrarForma();
	}
	
	/**
  	 * ****************************************************************.
  	 * @method realizarEnvioGiro
  	 * 		   metodo que permite realizar la transaccion para un 
  	 * 		   movimiento del tipo envio de giro
  	 * @param  pDouValorRecibido
  	 * 		   Valor recibido por el sistema para cubrir la transaccion
  	 * @param  pDouValorDevuelto
  	 * 		   Valor calculado por el sistema segun el valor recibido
  	 * 		   para cubrir la transaccion con respecto al valor y/o 
  	 * 		   costo total de la operacion
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @author Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void realizarEnvioGiro(double pDouValorRecibido,
								   double pDouValorDevuelto)throws Exception{
		
		Mensaje objMensaje;
		
		try{
			//pObjFacturaGiro.setBooAptoParaFacturar(true);
			
			//autor: dsalazar[PlayTech]
			//23-feb-2019
			//Se cambia Trama EnvioGiroPostal468 * EnvioGiroPostal547
			//Por requerimiento CRC Prueba admision tirilla 
			GiroVistaLogica.getInstance().insertarMovimientoFacturacion(super.getObjUsuario(),
																	    this.objFacturaGiro, 
																	    this.strOperacionInusual,
																	    this.strCRCAdmisionEntregaTirilla);
		}catch(Exception e){
			
			if (e instanceof ClientePosSlimGirosException) {
				
				objMensaje = (Mensaje)((ClientePosSlimGirosException)e).getObjMensaje();
				
				if	(	EventoFormaMovimientoCajaInternacional.lstCodMsgXConfirmarTransaccion.contains(objMensaje.getCodigo())	)
				{
					this.aplicaParaVerificarTransaccion();
				}
				
			}else{
				this.aplicaParaVerificarTransaccion();
			}
			
			throw e;
		}
		
		this.generarImpresionEnvio();
	}
		
	/**
  	 * ****************************************************************.
  	 * @metodo generarImpresionEnvio
  	 * 		   metodo que permite generar la impresion del envio de giro
  	 * 		   notificando la finalizacion de la transaccion como tal
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void generarImpresionEnvio()throws Exception{
		
		boolean imprimio;
		if ((this.objFacturaGiro.getTerceroOrigen().getObjBiometria().isBooValidadoBiometricamente() &&
			 this.objFacturaGiro.getTerceroOrigen().getObjBiometria().gestionarObjFirmaBiometrica().getStrId().equals("*")) ||
					(this.objFacturaGiro.getTerceroTramitador() != null) &&
					 this.objFacturaGiro.getTerceroTramitador().getObjBiometria().isBooValidadoBiometricamente() &&
					 this.objFacturaGiro.getTerceroTramitador().getObjBiometria().gestionarObjFirmaBiometrica().getStrId().equals("*")) {
			
			EnumMensajes.SOLICITAR_HUELLA_HUMEDA.desplegarMensaje(super.getFrmForma(), 
					  												 EnumClasesMensaje.INFORMACION);
		}	
		imprimio = EnumImpresiones.ENVIO_GIRO_POSTAL.ejecutarImpresion(super.getFrmForma(), 
																	   false, 
																	   this.objFacturaGiro,
		   															   super.getObjUsuario());
		if(imprimio){
			
			EnumMensajes.GIRO_REALIZADO_EXITOSAMENTE.desplegarMensaje(super.getFrmForma(), 
																	  EnumClasesMensaje.INFORMACION, 
																	  this.objFacturaGiro.getDocumento().getAbreviatura(),
																	  this.objFacturaGiro.getNumero(),
																	  this.objFacturaGiro.getReferenciaControl());
		}else{
			
			EnumMensajes.GIRO_REALIZADO_PERO_IMPRESION_ERROR.desplegarMensaje(super.getFrmForma(), 
																			  EnumClasesMensaje.ADVERTENCIA, 
																			  this.objFacturaGiro.getReferenciaControl());
		}
		
		if (this.objFacturaGiro.getObjClaveSeguridad() != null 
				&& (this.objFacturaGiro.getObjClaveSeguridad().getEnmTipoClaveSeguridad().equals(EnumTiposClaveSeguridad.MANUAL)
						|| this.objFacturaGiro.getObjClaveSeguridad().getEnmTipoClaveSeguridad().equals(EnumTiposClaveSeguridad.AUTOMATICA))) {
			
			EnumMensajes.GIRO_CON_CLAVE_SEGURIDAD.desplegarMensaje(super.getFrmForma(), 
					  											   EnumClasesMensaje.INFORMACION, 
					  											   ((EnumTiposClaveSeguridad)this.objFacturaGiro.getObjClaveSeguridad().getEnmTipoClaveSeguridad()).getEnmEtiNombre().toString());
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method generarReImpresionPago
	 * 		   genera la invocacion de la reimpresion del pago de giro
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   1/12/2016
	 * *********************************************************************
	 */
	private void generarReImpresionPago()throws Exception{
		
		new FormaReimpresion((JFrame)super.cerrarForma(), 
							  true,
							  EnumReimpresiones.REIMPRIMIR_ULTIMO_PAGO_GIRO);
	}
	
	/** 
	 * ********************************************************************
	 * @method generarReImpresionEnvio
	 * 		   genera la invocacion de la reimpresion del envio de giro
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   1/12/2016
	 * *********************************************************************
	 */
	private void generarReImpresionEnvio()throws Exception{
		
		new FormaReimpresion((JFrame)super.cerrarForma(), 
				  			 true,
				  			 EnumReimpresiones.REIMPRIMIR_ULTIMO_ENVIO_GIRO);
	}
	

	/** 
	 * ********************************************************************
	 * @method realizarEnvioSeguro
	 * 		   metodo que permite realizar la transaccion para un 
  	 * 		   movimiento del tipo seguro
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   1/12/2016
	 * *********************************************************************
	 */
	private void realizarEnvioSeguro() throws Exception{
		
		if (ValidacionesSuperCombo.getObjSuperCombo().isBooRealizaSeguro()
				&& this.objFacturaSeguro != null) {
			
			try{
			
				this.objFacturaSeguro.setPin(this.objFacturaGiro.getReferenciaControl());
				this.objFacturaSeguro.setReferenciaControl(this.objFacturaGiro.getReferenciaControl());
				
				ValidacionesSuperCombo.getInstance().cargarMedioPagoSeguro(this.objFacturaSeguro);
				
				ValidacionesSuperCombo.getInstance().crearMovimientoSeguro(super.getObjUsuario(),
																		   this.objFacturaSeguro);

				
				this.generarImpresionEnvioSeguro();
				
			}catch(Exception e){
				
				if (e instanceof ClientePosSlimGirosException) {
					
					super.controlExcepcion(e);
					e.printStackTrace();
				}

				if (!ValidacionesSuperCombo.getObjSuperCombo().isBooRealizaSeguro() ||
						this.objFacturaSeguro.getCertificadoNum() == null || 
						this.objFacturaSeguro.getCertificadoNum().isEmpty()) {
					
					EnumMensajes.SPC_GIRO_EXITOSO_ERROR_SEGURO.desplegarMensaje(super.getFrmForma(), 
																		 	    EnumClasesMensaje.INFORMACION);
				}
				
			}
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo generarImpresionEnvioSeguro
  	 * 		   metodo que permite generar la impresion del envio de 
  	 * 			seguro
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	private void generarImpresionEnvioSeguro()throws Exception{
			
		boolean imprimio;
		
		imprimio = EnumImpresiones.SEGURO.ejecutarImpresion(super.getFrmForma(), 
															false, 
															this.objFacturaSeguro,
				 											super.getObjUsuario());
		if(imprimio){
			
			EnumMensajes.SEGURO_REALIZADO_EXITOSAMENTE.desplegarMensaje(super.getFrmForma(), 
																		EnumClasesMensaje.INFORMACION, 
																		this.objFacturaSeguro.getCertificadoNum());
		}else{
			
			EnumMensajes.SEGURO_REALIZADO_PERO_IMPRESION_ERROR.desplegarMensaje(super.getFrmForma(), 
																				EnumClasesMensaje.ADVERTENCIA, 
																				this.objFacturaSeguro.getCertificadoNum());
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo generarImpresionSMS
  	 * 		   metodo que permite generar la impresion del	SMS
  	 * @param	pObjTerceroNotificado
  	 * 			Tercero a notificar mediante un SMS que el giro fue 
  	 * 			pagado
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor  Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	private void generarImpresionSMS(Tercero pObjTerceroNotificado)throws Exception{
			
		boolean imprimio;
		
		imprimio = EnumImpresiones.SMS.ejecutarImpresion(super.getFrmForma(), 
														 false, 
														 this.objFacturaGiro,
														 pObjTerceroNotificado,
														 super.getObjUsuario());
		if(imprimio){
			
			EnumMensajes.SMS_REALIZADO_EXITOSAMENTE.desplegarMensaje(super.getFrmForma(), 
																	 EnumClasesMensaje.INFORMACION, 
																	 this.objFacturaGiro.getReferenciaControl());
		}else{
			
			EnumMensajes.SMS_REALIZADO_PERO_IMPRESION_ERROR.desplegarMensaje(super.getFrmForma(), 
																			 EnumClasesMensaje.ADVERTENCIA, 
																			 this.objFacturaGiro.getReferenciaControl());
		}
	}
	
	/**
	 * ********************************************************************
	 * @method 	aplicaParaVerificarTransaccion
	 * 		   	Metodo que permite validar si el error emitido en el proceso 
	 * 			de facturacion amerita para realizar un proceso de verificacion
	 * 			de la misma a traves de la re-impresion
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	12/01/2017
	 * *********************************************************************
	 */
	private	void	aplicaParaVerificarTransaccion()
			throws Exception
	{
		//if	(	!this.objFacturaGiro.isBooAptoParaFacturar()	)
		//{
			this.booValidaTransaccion = false;
		//}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo castFrmMovimientoCaja
  	 * 		   Metodo estandar para formatear el tipo de dato general a 
  	 * 		   un tipo especifico ("Casteo"), del atributo padre frmForma
  	 * @return FormaMovimientoCaja
  	 * 		   valor especifico recuperado
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private FormaMovimientoCajaInternacional castFrmMovimientoCajaInternacional()throws Exception{
		return (FormaMovimientoCajaInternacional)super.getFrmForma();
	}

	/**
	 * @method getOperacionesClaveSeguridad
	 * 		   Metodo get del atributo operacionesClaveSeguridad
	 * @return IOperacionesClaveSeguridad
	 *		   Valor del atributo operacionesClaveSeguridad devuelto
	 * @author roberth.martinez
	 * @date   23/3/2016
	 */
	public IOperacionesClaveSeguridad getOperacionesClaveSeguridad() {
		return operacionesClaveSeguridad;
	}

	/**
	 * @method setOperacionesClaveSeguridad
	 * 		   Metodo set del atributo operacionesClaveSeguridad
	 * @param  pOperacionesClaveSeguridad
	 *		   Valor que tomara el atributo operacionesClaveSeguridad
	 * @author roberth.martinez
	 * @date   23/3/2016
	 */
	public void setOperacionesClaveSeguridad(IOperacionesClaveSeguridad pOperacionesClaveSeguridad) {
		this.operacionesClaveSeguridad = pOperacionesClaveSeguridad;
	}
}

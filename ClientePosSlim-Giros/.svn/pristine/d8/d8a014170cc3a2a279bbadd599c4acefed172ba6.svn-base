package co.com.codesa.clienteposslimgiros.eventos.caja;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.WindowEvent;
import java.text.Format;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.TableColumn;

import co.com.codesa.clienteposslimexception.exceptions.ClientePosSlimGirosException;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDocumentos;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEstadoTransaccion;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumImpresiones;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMediosPago;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumReimpresiones;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.enumeraciones.operaciones.EnumTiposOperaciones;
import co.com.codesa.clienteposslimgiros.enumeraciones.serviciosAdicionales.EnumServiciosAdicionales;
import co.com.codesa.clienteposslimgiros.enumeraciones.serviciosAdicionales.claveSeguridad.EnumTiposClaveSeguridad;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.caja.FormaDiligenciarMedioPago;
import co.com.codesa.clienteposslimgiros.formas.caja.FormaMovimientoCaja;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.GrillaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.operacioninusual.FormaGiroOperInusual;
import co.com.codesa.clienteposslimgiros.formas.reimpresion.FormaReimpresion;
import co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.SMSGiro.FormaPanelSMSGiro;
import co.com.codesa.clienteposslimgiros.interfaces.serviciosAdicionales.claveSeguridad.IOperacionesClaveSeguridad;
import co.com.codesa.clienteposslimgiros.utilidades.biometria.UtilBiometria;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.utilidades.documentos.UtilDocumentos;
import co.com.codesa.clienteposslimgiros.utilidades.estadoTransaccion.EstadoTransaccion;
import co.com.codesa.clienteposslimgiros.utilidades.mediosPago.UtilMediosPago;
import co.com.codesa.clienteposslimgiros.utilidades.mensajes.Mensaje;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.clienteposslimgiros.utilidades.serviciosAdicionales.SMSGiro.UtilSMSGiro;
import co.com.codesa.clienteposslimgiros.utilidades.validaciones.ValidacionesROE;
import co.com.codesa.clienteposslimgiros.utilidades.validaciones.ValidacionesSuperCombo;
import co.com.codesa.clienteposslimgiros.vista.logica.ControlConsultaPasiVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.GiroVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.RecaudoVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.impresion.ImpresionVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.propiedadesPruebaAdmisionEntregaTirilla.UtilidadPruebaAdmisionEntregaTirilla;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Concepto;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Documento;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaSeguro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.MedioPago;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.OperacionInusual;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.PruebaCRCAdmisionEntrega;
import co.com.codesa.codesawrapper.modelo.dominio.ParametroSistema;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.pruebacrcadmisionentrega.PruebaCRC;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

/**
 * ****************************************************************.
 * 
 * @autor Hector Q-en-K
 * @fecha 24-sep-2015
 * @clase EventoFormaMovimientoCaja Clase encargada de controlar los eventos de
 *        la forma de movimiento de caja
 * @copyright: Copyright 1998-2012 Codesa, Todos los derechos reservados.
 *             ****************************************************************
 */
public class EventoFormaMovimientoCaja extends EventoAbstracto {

	/**
	 * @variable hmMediosPagoIngresados Estructura hash que almacena el listado
	 *           de los medios de pago ingresados sobre la funcionalidad
	 **/
	private HashMap<String, MedioPago> hmMediosPagoIngresados;

	/**
	 * @variable lstMediosPagoHabilitados Listado de medios de pago habilitados
	 *           para la operacion que se requiere realizar
	 **/
	private List<MedioPago> lstMediosPagoHabilitados;

	/**
	 * @variable objFacturaGiro objeto factura de giro, sobre el cual se
	 *           realizara el movimiento
	 **/
	private FacturaGiro objFacturaGiro;

	/**
	 * @variable strOperacionInusual Cadena que almacena el diligenciamiento de
	 *           una operacion inusual
	 **/
	private String strOperacionInusual;

	/**
	 * @variable objFacturaSMS objeto factura de SMS, sobre el cual se realizara
	 *           el movimiento
	 **/
	// private FacturaGiro objFacturaGiroSMS;

	/**
	 * @variable objFacturaSeguro objeto factura de Seguro, sobre el cual se
	 *           realizara el movimiento
	 **/
	private FacturaSeguro objFacturaSeguro;

	/**
	 * @variable objMedioPagoEfectivo objeto medio de pago para efectivo
	 */
	private MedioPago objMedioPagoEfectivo;

	/**
	 * @variable booValidaTransaccion bandera que permite identificar si la
	 *           transaccion de movimiento fue completada o no durante el
	 *           proceso de confirmacion de la operacion
	 **/
	private boolean booValidaTransaccion;

	/**
	 * @variable douVlrTotal Valor total de la operacion que se esta
	 *           diligenciando total a cobrar o total a pagar, dependiendo de la
	 *           operacion
	 **/
	private double douVlrTotal;

	/**
	 * @variable douValorRecibido Valor acumulado referente a los ingresos que
	 *           se han realizado
	 **/
	private double douValorRecibido;

	/**
	 * @variable douValorCambio Valor de diferencia, calculado automaticamente
	 *           de la resta del valor del total de la operacion con respecto al
	 *           valor recibido
	 **/
	private double douValorCambio;

	/**
	 * @variable objDouTotalIngresoXTarjetas Valor total ingresado por tarjetas
	 *           como medio de pago
	 **/
	private double douTotalIngresoXTarjetas;

	/**
	 * @variable intConsecutivoMedioPagoIngresado Consecutivo que identifica el
	 *           medio de pago que ha sido ingresado
	 **/
	private int intConsecutivoMedioPagoIngresado;

	/**
	 * @variable objOperacionInusual objeto de operacion inusual, para almacenar
	 *           el dato entidad de la operacion inusual y la nota.
	 **/
	private OperacionInusual objOperacionInusual;

	/**
	 * @variable enmTipoOperacion Tipo de operacion que se esta llevando a cabo
	 */
	private EnumTiposOperaciones enmTipoOperacion;

	/**
	 * @variable operacionesClaveSeguridad interfaz de operaciones relacionadas
	 *           con el servicio de clave de seguridad
	 */
	private IOperacionesClaveSeguridad operacionesClaveSeguridad;

	/**
	 * @variable douVlrTotalMenosProtegiro Valor total de la operacion pago giro
	 * 			 con protegiro
	 **/
	private double douVlrTotalMenosProtegiro;

	/**
	 * @variable lstCodMsgXConfirmarTransaccion Listado de mensajes que ameritan
	 *           confirmar la transaccion para un proceso de venta
	 */
	private static final List<String> lstCodMsgXConfirmarTransaccion;

	static {
		lstCodMsgXConfirmarTransaccion = new ArrayList<String>();

		lstCodMsgXConfirmarTransaccion.add(EnumMensajes.ERROR_GENERAL
				.getCodigo());
		lstCodMsgXConfirmarTransaccion.add(EnumMensajes.EJB_ERROR_NO_CONTROLADO
				.getCodigo());
		lstCodMsgXConfirmarTransaccion
				.add(EnumMensajes.SOCKET_SIMS_AGOTO_TIEMPO_ESPERA_.getCodigo());
		lstCodMsgXConfirmarTransaccion
				.add(EnumMensajes.SOCKET_EMPRESA_AGOTO_TIEMPO_ESPERA
						.getCodigo());
		lstCodMsgXConfirmarTransaccion
				.add(EnumMensajes.SOCKET_EMPRESA_ERROR_NO_CONTROLADO
						.getCodigo());
		lstCodMsgXConfirmarTransaccion
				.add(EnumMensajes.EJB_ERROR_NO_CONTROLADO2.getCodigo());
		lstCodMsgXConfirmarTransaccion.add(EnumMensajes.EJB_AGOTO_TIEMPO_ESPERA
				.getCodigo());
	}

	/**
	 * @variable strCRCAdmisionEntregaTirilla objeto pruebacrc que contiene el
	 *           tipo [FISICO, ELECTRONICO ...] y datos multiregistro con el
	 *           formato IDPropiedad|DescripcionPropiedad|Respuesta1~ ...
	 *           proceso de venta
	 */
	private PruebaCRC objCRCAdmisionEntregaTirilla;

	/**
	 * ****************************************************************.
	 * 
	 * @method EventoFormaMovimientoCaja Constructor que ejecuta la
	 *         inicializacion de valores y ejecucion de comportamientos inicales
	 *         requeridos para el despliegue de sus acciones
	 * @param pForma
	 *            referencia a la GUI de la cual se estan controlando los
	 *            eventos
	 * @param pObjFacturaGiro
	 *            objeto factura de giro, sobre el cual se realizara el
	 *            movimiento
	 * @param pObjFacturaSeguro
	 *            objeto facura seguro para supercombo
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author hector.cuenca
	 *         ****************************************************************
	 */
	public EventoFormaMovimientoCaja(FormaGenerica pForma,
			FacturaGiro pObjFacturaGiro, FacturaSeguro pObjFacturaSeguro)
			throws Exception {
		super(pForma);
		this.objFacturaGiro = pObjFacturaGiro;
		this.booValidaTransaccion = true;
		this.objFacturaSeguro = pObjFacturaSeguro;
		this.intConsecutivoMedioPagoIngresado = 0;
		this.douTotalIngresoXTarjetas = 0;
		this.hmMediosPagoIngresados = new HashMap<String, MedioPago>();
		this.objOperacionInusual = new OperacionInusual();
	}

	@Override
	public void iniciarValores(Object... pArrObjParametrosForma)
			throws Exception {

		this.cargarFormulario();
	}

	@Override
	public void accionarVentanaDesplegada(WindowEvent pEvtWindowOpened)
			throws Exception {

		this.operacionesClaveSeguridad.validarEstadoServicio(
				this.objFacturaGiro, this.enmTipoOperacion, null);
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo cargarFormulario Metodo que se encarga de gestionar el cargue de
	 *         la informacion sobre el formulario
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private void cargarFormulario() throws Exception {

		Format frtFormato;

		if (this.objFacturaSeguro != null) {

			if (this.objFacturaGiro.getReferenciaControl() == null) {
			this.douVlrTotal = this.objFacturaGiro.getTotal()
					+ this.objFacturaSeguro.getValorPrima();
			} else {
			this.douVlrTotal = this.objFacturaGiro.getTotal();
			this.douVlrTotalMenosProtegiro = this.objFacturaGiro.getTotal()
			- this.objFacturaSeguro.getValorPrima();
			/*this.douVlrTotal = this.objFacturaGiro.getTotal()
					- this.objFacturaSeguro.getValorPrima();*/
			}// + this.objFacturaGiroSMS.getTotal();
		} else {

			this.douVlrTotal = this.objFacturaGiro.getTotal();
		}

		frtFormato = UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO();
 
		if (this.objFacturaSeguro != null) {
			
			if (this.objFacturaGiro.getReferenciaControl() == null){
				this.castFrmMovimientoCaja().getTxtValorPagar()
				.setText(frtFormato.format(this.douVlrTotal));
				
			} else {
				this.castFrmMovimientoCaja().getTxtValorPagar()
				.setText(frtFormato.format(this.douVlrTotalMenosProtegiro));
			}
		} else {

			this.castFrmMovimientoCaja().getTxtValorPagar()
			.setText(frtFormato.format(this.douVlrTotal));
		}
		
		this.castFrmMovimientoCaja().getTxtTotalMovimiento()
				.setText(frtFormato.format(0.0));

		this.cargarSegunDocumento(this.objFacturaGiro.getDocumento());

		this.operacionesClaveSeguridad = this
				.castFrmMovimientoCaja()
				.getScpServiciosAdicionales()
				.getOperaciones()
				.adicionarServicio(EnumServiciosAdicionales.CLAVE_SEGURIDAD,
						"pnlClaveSeguridad");
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo cargarSegunDocumento Condiciona el cargue y los valores iniciales
	 *         sobre la funcionalidad dependiendo del documento que se encuentre
	 *         procesando
	 * @param pObjDocumentoRecibido
	 *            Documento asociado a la operacion
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private void cargarSegunDocumento(Documento pObjDocumentoRecibido)
			throws Exception {

		if (pObjDocumentoRecibido.getNaturaleza().equals(
				EnumParametrosApp.DOCUMENTO_NATURALEZA_NEGATIVA
						.getValorPropiedad())) {
			
			this.castFrmMovimientoCaja().getLblValorPagar()
			.setText(EnumEtiquetas.LBL_MVC_VALOR_PAGAR.getValor(true));
			
			this.castFrmMovimientoCaja()
					.getLblTotalMovimiento()
					.setText(
							EnumEtiquetas.LBL_MVC_TOTAL_MOVIMIENTO_PAGO
									.getValor(true));
			this.castFrmMovimientoCaja().setTituloForma(
					EnumEtiquetas.TTL_MVC_VENTANA_SALIDA);

			this.castFrmMovimientoCaja().getBtnAdicionarMedioPago()
					.setEnabled(false);
			this.castFrmMovimientoCaja().getBtnEliminarMedioPago()
					.setEnabled(false);
			this.castFrmMovimientoCaja().getBtnVerEditarMedioPago()
					.setEnabled(false);

			this.objMedioPagoEfectivo = EnumMediosPago.EFECTIVO
					.getObjMedioPago();

			if (this.objMedioPagoEfectivo != null) {

				this.objMedioPagoEfectivo = (MedioPago) this.objMedioPagoEfectivo
						.clone();
				this.objMedioPagoEfectivo.setValor(this.douVlrTotal);

				this.actualizarGrillaMediosPago(this.objMedioPagoEfectivo,
						false);
			}

			this.actualizarMovimiento(0, this.douVlrTotal);
		

			if (UtilDocumentos.isDocumentoTipoEnum(pObjDocumentoRecibido,EnumDocumentos.FACTURA)) {

				this.enmTipoOperacion = EnumTiposOperaciones.PAGO_FACTURACION_GIRO;

			} else if (UtilDocumentos.isDocumentoTipoEnum(
					pObjDocumentoRecibido, EnumDocumentos.RECAUDO)) {

				this.enmTipoOperacion = EnumTiposOperaciones.PAGO_FACTURACION_RECAUDO;
			}
			
			//HU:8935 
			//david.marquez
			//2020/08/24
			//Se adiciona validacion para los nuevos documentos facturacion giro virtual y facturacion giro retiro
			else if (pObjDocumentoRecibido.getDescripcion().equals("FACTURACION VIRTUAL") ||
					 pObjDocumentoRecibido.getDescripcion().equals("FACTURACION GIRO RETIRO")) {

				this.enmTipoOperacion = EnumTiposOperaciones.PAGO_FACTURACION_GIRO;
			}
			
			
			

		} else {

			this.cargarMediosPagoHabilitados(pObjDocumentoRecibido);

			this.actualizarMovimiento(0, 0);
		}
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo cargarMediosPagoHabilitados Define segun el documento y el tipo
	 *         de operacion que se encuentra realizando, el listado de medios de
	 *         pago autorizados para colocar a disposicion del usuario sobre la
	 *         funcionalidad
	 * @param pObjDocumentoRecibido
	 *            Documento asociado a la operacion
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private void cargarMediosPagoHabilitados(Documento pObjDocumentoRecibido)
			throws Exception {

		MedioPago objMedioPagoEfectivo;

		if (UtilDocumentos.isDocumentoTipoEnum(pObjDocumentoRecibido,
				EnumDocumentos.FACTURA)) {

			this.lstMediosPagoHabilitados = new ArrayList<MedioPago>();

			objMedioPagoEfectivo = EnumMediosPago.EFECTIVO.getObjMedioPago();

			if (objMedioPagoEfectivo != null) {

				this.lstMediosPagoHabilitados.add(objMedioPagoEfectivo);
			}

			this.enmTipoOperacion = EnumTiposOperaciones.ENVIO_FACTURACION_GIRO;

		} else if (UtilDocumentos.isDocumentoTipoEnum(pObjDocumentoRecibido,
				EnumDocumentos.RECAUDO)) {

			this.lstMediosPagoHabilitados = super.getObjUsuario()
					.getMediosPago();

			this.enmTipoOperacion = EnumTiposOperaciones.ENVIO_FACTURACION_RECAUDO;
		}
	}

	@Override
	public void accionarEjecucion(Component pComponent, AWTEvent pEvtEjecucion)
			throws Exception {

		if (pComponent.equals(this.castFrmMovimientoCaja()
				.getBtnAdicionarMedioPago())) {

			this.diligenciarMedioPago(null);

		} else if (pComponent.equals(this.castFrmMovimientoCaja()
				.getBtnVerEditarMedioPago())) {

			this.editarEliminarMedioPago(true);

		} else if (pComponent.equals(this.castFrmMovimientoCaja()
				.getBtnEliminarMedioPago())) {

			this.editarEliminarMedioPago(false);

		} else {
			super.accionarEjecucion(pComponent, pEvtEjecucion);
		}
	}

	@Override
	public void confirmar() throws Exception {

		UtilComponentesGUI.getInstance().validarCamposObligatorios(
				this.getFrmForma(), true, true);
		if (this.douValorCambio > 0) {
			// existe faltante

			throw EnumMensajes.VALOR_RECIBIDO_INFERIOR_VALOR_COBRADO
					.generarExcepcion(EnumClasesMensaje.ERROR);

		} else {

			this.realizarOperacion();
		}
	}

	@Override
	public void validaDatosAdicionales(JPanel pnlSeccionAdicional)
			throws Exception {
		if (pnlSeccionAdicional instanceof FormaPanelSMSGiro) {
			((FormaPanelSMSGiro) pnlSeccionAdicional).getEvaControlEventos()
					.ejecutar();
		}
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo realizarOperacion Despliega el proceso logico requerido para
	 *         realizar la operacion deseada, segun la naturaleza (envio / pago)
	 *         y tipo de documento
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private void realizarOperacion() throws Exception {

		Documento objDocumento;

		this.objFacturaGiro.setListMediosPago(new ArrayList<MedioPago>(
				this.hmMediosPagoIngresados.values()));

		objDocumento = this.objFacturaGiro.getDocumento();

		if (this.objMedioPagoEfectivo != null) {

			this.objMedioPagoEfectivo.setValor(this.objMedioPagoEfectivo
					.getValor() - Math.abs(this.douValorCambio));
		}

		try {

			if (objDocumento.getNaturaleza().equals(
					EnumParametrosApp.DOCUMENTO_NATURALEZA_POSITIVA
							.getValorPropiedad())) {

				if (UtilDocumentos.isDocumentoTipoEnum(objDocumento,
						EnumDocumentos.FACTURA)) {
					this.facturarEnvioGiro();

				} else if (UtilDocumentos.isDocumentoTipoEnum(objDocumento,
						EnumDocumentos.RECAUDO)) {

					this.realizarEnvioRecaudo(this.douValorRecibido,
							this.douValorCambio);
				}

			} else if (objDocumento.getNaturaleza().equals(
					EnumParametrosApp.DOCUMENTO_NATURALEZA_NEGATIVA
							.getValorPropiedad())) {

				if (this.validaVerificarClaveSegurida()) {

					if (UtilDocumentos.isDocumentoTipoEnum(objDocumento,
							EnumDocumentos.FACTURA)) {

						this.realizarPagoGiro();

					} else if (UtilDocumentos.isDocumentoTipoEnum(objDocumento,
							EnumDocumentos.RECAUDO)) {
						this.realizarPagoRecaudo();
					}
					
					//HU:8935 
					//david.marquez
					//2020/08/24
					//Se adiciona validacion para los nuevos documentos facturacion giro virtual y facturacion giro retiro
					else if (objDocumento.getDescripcion().equals("FACTURACION VIRTUAL") ||
							 objDocumento.getDescripcion().equals("FACTURACION GIRO RETIRO")) {

						this.realizarPagoGiro();
					}
				}
			}

		} catch (Exception e) {

			if (this.objMedioPagoEfectivo != null) {

				this.objMedioPagoEfectivo.setValor(this.objMedioPagoEfectivo
						.getValor() + Math.abs(this.douValorCambio));
			}

			throw e;
		}
	}

	/**
	 * ********************************************************************
	 * 
	 * @method validaVerificarClaveSegurida metodo para validar si tiene clave
	 *         de seguridad, y verifica la clave asignada.
	 * @return boolean resultado de validacion
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 11/3/2016
	 *       **********************************************************
	 *       ***********
	 */
	private boolean validaVerificarClaveSegurida() throws Exception {

		boolean booVerificar;

		if (this.objFacturaGiro.getObjClaveSeguridad() == null) {

			booVerificar = true;
		} else {

			booVerificar = this.operacionesClaveSeguridad
					.validaEjecucionServicio(this.objFacturaGiro,
							this.enmTipoOperacion, null);

			if (this.objFacturaGiro.getObjClaveSeguridad().isBooRevalidar()) {
				this.regresar();
			}
		}

		return booVerificar;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo anotar Metodo que ejecuta las acciones referentes al boton de
	 *         operacion representativo para anotar, normalmente utilizado para
	 *         la anotacion de operaciones inusuales
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	@Override
	public void anotar() throws Exception {

		FormaGiroOperInusual objFrmOperacionesInusuales;

		objFrmOperacionesInusuales = new FormaGiroOperInusual(
				this.getFrmForma(), true, this.objOperacionInusual);

		if (objFrmOperacionesInusuales.getEnmBotEncAccionSolicitada().equals(
				EnumBotonesEncabezado.BTNGUARDAR)) {

			this.objOperacionInusual
					.setObjDaenOperacionInusual(objFrmOperacionesInusuales
							.castEvaFrmOperacionInusual()
							.getObjDatEntOperacionInusual());
			this.objOperacionInusual.setStrNota(objFrmOperacionesInusuales
					.castEvaFrmOperacionInusual().getStrAnotacion());
			this.strOperacionInusual = this.objOperacionInusual
					.getStrOperacionInusual();

		} else if (objFrmOperacionesInusuales.getEnmBotEncAccionSolicitada()
				.equals(EnumBotonesEncabezado.BTN_ANULAR)) {

			this.objOperacionInusual.setObjDaenOperacionInusual(null);
			this.objOperacionInusual.setStrNota(null);
			this.strOperacionInusual = null;
		}
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo controlExcepcionPersonalizado metodo que permite centralizar el
	 *         control de excepciones se personaliza este control ya que debe
	 *         considerarse un control especial para validacion de transaccion
	 * @param e
	 *            Excepcion general, que puede representar una excepcion
	 *            personalizada o general del sistema
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	@Override
	public void controlExcepcion(Exception e) {

		super.controlExcepcion(e);

		try {
			this.validarTransaccion();
		} catch (Exception e1) {
			super.controlExcepcion(e1);
		}
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo diligenciarMedioPago Despliega la forma para diligenciar un medio
	 *         de pago, segun el escenario este permite el ingreso o la edicion
	 *         de este
	 * @param pObjMedioPago
	 *            Medio de pago que sera diligenciado, en caso de estar nulo
	 *            simbolizara un ingreso, en caso contrario se asume que es una
	 *            edicion
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	public void diligenciarMedioPago(MedioPago pObjMedioPago) throws Exception {

		FormaDiligenciarMedioPago frmDiligenciarMedioPago;
		double douValorMedioPagoActual = 0;
		boolean booEditaMedioPago;

		if (pObjMedioPago != null) {

			douValorMedioPagoActual = pObjMedioPago.getValor();
			booEditaMedioPago = true;

		} else {

			booEditaMedioPago = false;
		}

		frmDiligenciarMedioPago = new FormaDiligenciarMedioPago(
				super.getFrmForma(), true, pObjMedioPago,
				this.hmMediosPagoIngresados, this.douTotalIngresoXTarjetas,
				this.douVlrTotal, this.lstMediosPagoHabilitados);

		if (frmDiligenciarMedioPago.getEnmBotEncAccionSolicitada().equals(
				EnumBotonesEncabezado.BTNGUARDAR)) {

			pObjMedioPago = frmDiligenciarMedioPago
					.castEvaFrmDiligenciarMedioPago()
					.getObjMedioPagoDiligenciado();

			this.actualizarGrillaMediosPago(pObjMedioPago, booEditaMedioPago);

			this.actualizarMovimiento(douValorMedioPagoActual,
					pObjMedioPago.getValor());

			if (UtilMediosPago.getInstance().isMedioPagoTipoEnum(pObjMedioPago,
					EnumMediosPago.TARJETA_CREDITO,
					EnumMediosPago.TARJETA_DEBITO)) {

				this.douTotalIngresoXTarjetas += pObjMedioPago.getValor();

			} else if (UtilMediosPago.getInstance().isMedioPagoTipoEnum(
					pObjMedioPago, EnumMediosPago.EFECTIVO)) {

				this.objMedioPagoEfectivo = pObjMedioPago;
			}
		}

		this.habilitarIngresoMedioPago();
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo habilitarIngresoMedioPago Metodo que permite validar si habilita
	 *         o des-habilita la opcion para ingresar y/o diligenciar el ingreso
	 *         de un medio de pago
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private void habilitarIngresoMedioPago() throws Exception {

		if (this.lstMediosPagoHabilitados.size() == 1
				&& this.hmMediosPagoIngresados.size() == 1) {

			this.castFrmMovimientoCaja().getBtnAdicionarMedioPago()
					.setEnabled(false);

		} else {

			this.castFrmMovimientoCaja().getBtnAdicionarMedioPago()
					.setEnabled(true);
		}
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo editarMedioPago Permite realizar la slicitud de edicion o
	 *         eliminacion de un medio de pago previamente ingresado
	 * @param pBooEditaElimina
	 *            Bandera que permite identificar si la operacion que se desea
	 *            ejecutar es una edicion (true), o una eliminacion (false), de
	 *            un medio de pago previamente ingresado
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private void editarEliminarMedioPago(boolean pBooEditaElimina)
			throws Exception {

		MedioPago objMedioPagoSeleccionado;
		GrillaUtil tblMediosPago;
		TableColumn objColumnaMedioPago;
		int intFilaSeleccionada;

		tblMediosPago = this.castFrmMovimientoCaja().getTblMediosPago();

		if (tblMediosPago.getModel().getRowCount() > 0) {

			intFilaSeleccionada = tblMediosPago.getSelectedRow();

			if (intFilaSeleccionada >= 0) {

				objColumnaMedioPago = tblMediosPago
						.getColumn(EnumEtiquetas.TTL_MVC_GRILLA_MEDPAGO_DESCRIPCION
								.toString());

				objMedioPagoSeleccionado = (MedioPago) tblMediosPago
						.getValueAt(intFilaSeleccionada,
								objColumnaMedioPago.getModelIndex());

				this.hmMediosPagoIngresados.remove(objMedioPagoSeleccionado
						.getStrConsecutivoIngreso());

				if (UtilMediosPago.getInstance().isMedioPagoTipoEnum(
						objMedioPagoSeleccionado,
						EnumMediosPago.TARJETA_CREDITO,
						EnumMediosPago.TARJETA_DEBITO)) {

					this.douTotalIngresoXTarjetas -= objMedioPagoSeleccionado
							.getValor();
				}

				if (pBooEditaElimina) {

					this.diligenciarMedioPago(objMedioPagoSeleccionado);

				} else {

					tblMediosPago.getPropiedades().removerFilaGrilla(
							intFilaSeleccionada);

					this.actualizarMovimiento(
							objMedioPagoSeleccionado.getValor(), 0);

					if (UtilMediosPago.getInstance().isMedioPagoTipoEnum(
							objMedioPagoSeleccionado, EnumMediosPago.EFECTIVO)) {

						this.objMedioPagoEfectivo = null;
					}
				}

			} else {

				throw EnumMensajes.DEBE_SELECCIONAR_REGISTRO_PARA_OPERACION
						.generarExcepcion(EnumClasesMensaje.ERROR);
			}

		} else {

			throw EnumMensajes.SE_NECESITAN_REGISTROS_EN_TABLA
					.generarExcepcion(EnumClasesMensaje.ERROR);
		}

		if (!pBooEditaElimina) {

			this.habilitarIngresoMedioPago();
		}
	}

	/**
	 * ********************************************************************
	 * 
	 * @method actualizarGrillaMediosPago Permite actualizar la grilla de medios
	 *         de pago, adicionando o actualizando un registro de medio de pago
	 * @param pObjMedioPagoDiligenciado
	 *            Medio de pago diligenciado, referente a un ingreso nuevo o una
	 *            actualizacion de uno previamente cargado
	 * @param pBooEditaMedioPago
	 *            Bandera que permite identificar si la operacion que se llevo a
	 *            cabo es una edicion (true), o un ingreso nuevo (false)
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 1/12/2016
	 *       **********************************************************
	 *       ***********
	 */
	private void actualizarGrillaMediosPago(
			MedioPago pObjMedioPagoDiligenciado, boolean pBooEditaMedioPago)
			throws Exception {
		GrillaUtil tblGrillaMediosPago;
		TableColumn objColumnaId;
		TableColumn objColumnaValor;
		TableColumn objColumnaDescripcion;
		int intFilaSeleccionada;

		tblGrillaMediosPago = this.castFrmMovimientoCaja().getTblMediosPago();

		if (pBooEditaMedioPago) {

			objColumnaId = tblGrillaMediosPago
					.getColumn(EnumEtiquetas.TTL_MVC_GRILLA_MEDPAGO_ID
							.toString());
			objColumnaDescripcion = tblGrillaMediosPago
					.getColumn(EnumEtiquetas.TTL_MVC_GRILLA_MEDPAGO_DESCRIPCION
							.toString());
			objColumnaValor = tblGrillaMediosPago
					.getColumn(EnumEtiquetas.TTL_MVC_GRILLA_MEDPAGO_VALOR
							.toString());

			intFilaSeleccionada = tblGrillaMediosPago.getSelectedRow();

			tblGrillaMediosPago.setValueAt(pObjMedioPagoDiligenciado.getId(),
					intFilaSeleccionada, objColumnaId.getModelIndex());

			tblGrillaMediosPago.setValueAt(pObjMedioPagoDiligenciado,
					intFilaSeleccionada, objColumnaDescripcion.getModelIndex());

			tblGrillaMediosPago.setValueAt(
					pObjMedioPagoDiligenciado.getValor(), intFilaSeleccionada,
					objColumnaValor.getModelIndex());
		} else {

			this.intConsecutivoMedioPagoIngresado++;

			pObjMedioPagoDiligenciado.setStrConsecutivoIngreso(String
					.valueOf(this.intConsecutivoMedioPagoIngresado));

			tblGrillaMediosPago.getPropiedades().adicionarFilaGrilla(
					new Object[] {
							pObjMedioPagoDiligenciado
									.getStrConsecutivoIngreso(),
							pObjMedioPagoDiligenciado.getId(),
							pObjMedioPagoDiligenciado,
							pObjMedioPagoDiligenciado.getValor() });

			this.hmMediosPagoIngresados.put(
					pObjMedioPagoDiligenciado.getStrConsecutivoIngreso(),
					pObjMedioPagoDiligenciado);
		}
	}

	/**
	 * ********************************************************************
	 * 
	 * @method actualizarMovimiento Metodo que se encarga de actualizar
	 *         automaticamente el valor de cambio una vez es producido un
	 *         ingreso en el valor recibido
	 * @param pDouValorAporteActual
	 *            valor double actual
	 * @param pDouValorAporteNuevo
	 *            valor double nuevo
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 1/12/2016
	 *       **********************************************************
	 *       ***********
	 */
	private void actualizarMovimiento(double pDouValorAporteActual,
			double pDouValorAporteNuevo) throws Exception {

		NumberFormat frtFormato;

		frtFormato = UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO();

		this.douValorRecibido = frtFormato.parse(
				this.castFrmMovimientoCaja().getTxtTotalMovimiento().getText())
				.doubleValue();
		this.douValorRecibido += (pDouValorAporteNuevo - pDouValorAporteActual);

		this.castFrmMovimientoCaja().getTxtTotalMovimiento()
				.setText(frtFormato.format(this.douValorRecibido));

		this.douValorCambio = this.douVlrTotal - this.douValorRecibido;

		this.castFrmMovimientoCaja().getTxtFaltante()
				.setText(frtFormato.format(Math.abs(this.douValorCambio)));

		if (this.douValorCambio < 0) {// sobra

			this.castFrmMovimientoCaja().getLblCambio()
					.setText(EnumEtiquetas.LBL_FCG_CAMBIO_SOBRA.getValor(true));
			this.castFrmMovimientoCaja().getTxtFaltante()
					.setForeground(Color.blue);

		} else if (this.douValorCambio > 0) {// falta

			this.castFrmMovimientoCaja().getLblCambio()
					.setText(EnumEtiquetas.LBL_FCG_CAMBIO_FALTA.getValor(true));
			this.castFrmMovimientoCaja().getTxtFaltante()
					.setForeground(Color.red);

		} else {// exacto

			this.castFrmMovimientoCaja()
					.getLblCambio()
					.setText(EnumEtiquetas.LBL_FCG_CAMBIO_EXACTO.getValor(true));
			this.castFrmMovimientoCaja().getTxtFaltante()
					.setForeground(Color.black);

		}
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo validarTransaccion metodo que permite ejecutar ciertos
	 *         comportamientos especiales cuando el proceso de confirmacion de
	 *         la operacion ha sido interrumpido
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private void validarTransaccion() throws Exception {

		Long transaccionId;
		Documento objDocumento;

		if (!this.booValidaTransaccion) {// Se genero interrupcion sobre
											// operacion de registro

			objDocumento = this.objFacturaGiro.getDocumento();

			if (objDocumento.getNaturaleza().equals(
					EnumParametrosApp.DOCUMENTO_NATURALEZA_POSITIVA
							.getValorPropiedad())) {

				transaccionId = super.getObjUsuario().getPrevTransaccId();
				super.getObjUsuario().setTransaccId(transaccionId);

				EnumMensajes.VERIFIQUE_TRANSACCION.desplegarMensaje(
						super.getFrmForma(), EnumClasesMensaje.ADVERTENCIA);

				if (ValidacionesSuperCombo.getObjSuperCombo()
						.isBooRealizaSeguro() && this.objFacturaSeguro != null) {
					EnumMensajes.NO_REALIZA_SEGURO_X_GIRO_NO_CONFIRMADO
							.desplegarMensaje(super.getFrmForma(),
									EnumClasesMensaje.ADVERTENCIA);
				}

				EstadoTransaccion.getInstance().grabarValorPropiedad(
						EnumEstadoTransaccion.VERIFICADO, "false");
				this.generarReImpresionEnvio();

			} else if (objDocumento.getNaturaleza().equals(
					EnumParametrosApp.DOCUMENTO_NATURALEZA_NEGATIVA
							.getValorPropiedad())) {

				if (this.objFacturaGiro.isExterno()) {

					EstadoTransaccion.getInstance().grabarValorPropiedad(
							EnumEstadoTransaccion.PIN_EXT,
							this.objFacturaGiro.getReferenciaControl());
					
					EstadoTransaccion.getInstance().grabarValorPropiedad(
							EnumEstadoTransaccion.MARCA_CRC,
							 this.objFacturaGiro.getObjCRCMedioEntrega().getStrRespuesta());

					EnumMensajes.PAGO_EXTERNO_REQUIERE_CONFIRMACION_DEL_PROVEEDOR
							.desplegarMensaje(super.getFrmForma(),
									EnumClasesMensaje.ERROR);
				} else {
					EnumMensajes.VERIFIQUE_TRANSACCION.desplegarMensaje(
							super.getFrmForma(), EnumClasesMensaje.ADVERTENCIA);
				}

				this.generarReImpresionPago();
			}
		}
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo realizarPagoRecaudo metodo que permite realizar la transaccion
	 *         para un movimiento del tipo pago de recaudo (dispersion)
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private void realizarPagoRecaudo() throws Exception {

		RecaudoVistaLogica.getInstance().realizarPagoRecaudo(
				this.objFacturaGiro, this.strOperacionInusual,
				super.getObjUsuario());
		this.generarImpresionPagoRecaudo();

		super.cerrarForma();
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo realizarPagoGiro metodo que permite realizar la transaccion para
	 *         un movimiento del tipo pago de giro
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
private void realizarPagoGiro()throws Exception{
		

		Mensaje objMensaje;
		//Invocando pantalla para presentar pregunta de prueba(constancia) de Admision/Entrega giro
		//Capturando el tercero involucrado en el envio del giro postal
		Tercero tercero;
		boolean blnImpresionFisicaTirilla = true;
		
		if(this.objFacturaGiro.isExterno()){
			
			//Imprimir la tirilla
			//Obtenga el valor definido en PASI como fisico
			/*ParametroSistema psPASI = UtilParametrosSistema.getInstance().consultar(
				EnumParametrosSistema.ID_PRUEBA_EN_FORMATO_FISICO);
			String strFormatoFisico = psPASI.getValor();*/
			String strFormatoFisico = ControlConsultaPasiVistaLogica.getInstance().getCodcrcpr();
			
			if (this.objFacturaGiro.getTerceroTramitador()!=null){
				tercero = this.objFacturaGiro.getTerceroTramitador();
			}else{
				tercero = this.objFacturaGiro.getTerceroOrigen();
			}
			
			PruebaCRCAdmisionEntrega pobjPruebaCRC = new PruebaCRCAdmisionEntrega();
			this.objCRCAdmisionEntregaTirilla = UtilidadPruebaAdmisionEntregaTirilla
					.getInstancia().realizarPreguntaPruebaAdmisionEnvioTirilla(
							this.getFrmForma(), super.getObjUsuario(), tercero,
							pobjPruebaCRC,
							EnumTiposOperaciones.PAGO_FACTURACION_GIRO_EXTERNO);
			
			if (this.objCRCAdmisionEntregaTirilla != null
					&& this.objCRCAdmisionEntregaTirilla.getStrTipo() != null
					&& this.objCRCAdmisionEntregaTirilla.getStrRespuesta() != null)	{
				
				this.objFacturaGiro.setObjCRCMedioEntrega(objCRCAdmisionEntregaTirilla);
			}
			
			if (this.objCRCAdmisionEntregaTirilla != null
					&& this.objCRCAdmisionEntregaTirilla.getStrTipo() != null
					&& this.objCRCAdmisionEntregaTirilla.getStrRespuesta() != null
					&&
					!this.objCRCAdmisionEntregaTirilla.getStrTipo().equalsIgnoreCase(
					strFormatoFisico) && !this.objCRCAdmisionEntregaTirilla.getStrTipo().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ASTERISCO.getValor()) ) {
				blnImpresionFisicaTirilla = false;
			}
		
			if (this.objCRCAdmisionEntregaTirilla != null
					&& this.objCRCAdmisionEntregaTirilla.getStrTipo() != null
					&& this.objCRCAdmisionEntregaTirilla.getStrRespuesta() != null) {
				this.realizarPagoGiroExterno();
			}
			
		}else{

			// Imprimir la tirilla
			// Obtenga el valor definido en PASI como fisico
			/*ParametroSistema psPASI = UtilParametrosSistema.getInstance()
					.consultar(
							EnumParametrosSistema.ID_PRUEBA_EN_FORMATO_FISICO);
			String strFormatoFisico = psPASI.getValor();*/
			String strFormatoFisico = ControlConsultaPasiVistaLogica.getInstance().getCodcrcpr();

			if (this.objFacturaGiro.getTerceroTramitador() != null) {
				tercero = this.objFacturaGiro.getTerceroTramitador();
			} else {
				tercero = this.objFacturaGiro.getTerceroDestino();
			}

			PruebaCRCAdmisionEntrega pobjPruebaCRC = new PruebaCRCAdmisionEntrega();
			this.objCRCAdmisionEntregaTirilla = UtilidadPruebaAdmisionEntregaTirilla
					.getInstancia().realizarPreguntaPruebaAdmisionEnvioTirilla(
							this.getFrmForma(), super.getObjUsuario(), tercero,
							pobjPruebaCRC,
							EnumTiposOperaciones.PAGO_FACTURACION_GIRO);

			if (this.objCRCAdmisionEntregaTirilla != null
					&&
					this.objCRCAdmisionEntregaTirilla.getStrTipo() != null &&
					this.objCRCAdmisionEntregaTirilla.getStrRespuesta()!=null) {
				this.objFacturaGiro
						.setObjCRCMedioEntrega(objCRCAdmisionEntregaTirilla);
			}

			if (this.objCRCAdmisionEntregaTirilla != null &&
					this.objCRCAdmisionEntregaTirilla.getStrTipo() != null &&
					!this.objCRCAdmisionEntregaTirilla.getStrTipo()
					.equalsIgnoreCase(strFormatoFisico) &&
					!this.objCRCAdmisionEntregaTirilla.getStrTipo()
					.equalsIgnoreCase(EnumGeneralidadesTramasGiros.ASTERISCO.getValor())) {
				blnImpresionFisicaTirilla = false;
				
			}

			if (this.objCRCAdmisionEntregaTirilla != null
					&& this.objCRCAdmisionEntregaTirilla.getStrTipo() != null
					&& this.objCRCAdmisionEntregaTirilla.getStrRespuesta() != null) {
				this.realizarPagoGiroInterno();
			}
			
		}

		
		if (this.objCRCAdmisionEntregaTirilla != null
				&& this.objCRCAdmisionEntregaTirilla.getStrRespuesta() != null
				&& this.objCRCAdmisionEntregaTirilla.getStrTipo() != null) {
			this.generarImpresionPago(blnImpresionFisicaTirilla);
			this.realizarEnvioSeguro();			

			if (this.objFacturaGiro.getFacturaSeguro() != null
					&& this.objFacturaGiro.getFacturaSeguro()
							.getReferenciaControl() != null
					&& !this.objFacturaGiro.getFacturaSeguro()
							.getReferenciaControl().isEmpty()
					&& this.objFacturaGiro.getTerceroOrigen().getTelefono2() != null
					&& !this.objFacturaGiro.getTerceroOrigen().getTelefono2()
							.isEmpty()) {
				this.generarImpresionSMS(this.objFacturaGiro.getTerceroOrigen());
			}
		}

		// La forma de pago se cierra siempre y cuando se haya obtenido una
		// respuesta
		// por parte de la CRC prueba de entrega de tirilla
		if (this.objCRCAdmisionEntregaTirilla != null
				&& this.objCRCAdmisionEntregaTirilla.getStrRespuesta() != null
				&& this.objCRCAdmisionEntregaTirilla.getStrTipo() != null) {
			super.cerrarForma();
		}
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo realizarPagoGiroInterno [TODO - Documentacion]
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor ****************************************************************
	 */
	private void realizarPagoGiroInterno() throws Exception {

		Mensaje objMensaje;

		try {

			UtilBiometria.getInstance().registrarFirmaBiometricaBiometriaLocal(
					super.getObjUsuario(), this.objFacturaGiro,
					EnumTiposOperaciones.PAGO_FACTURACION_GIRO);
			/*
			double douVlrTotal;
			
			if (this.objFacturaGiro.isIncluyeSeguroPago()) {
				
				douVlrTotal = this.objFacturaGiro.getTotal() - this.objFacturaSeguro.getTotal();
				this.objFacturaGiro.setTotal(douVlrTotal);
				
				} 
			*/
			GiroVistaLogica.getInstance().insertarMovimientoPagoFacturacion(
					super.getObjUsuario(), 
					this.objFacturaGiro,
					this.strOperacionInusual,
					this.objCRCAdmisionEntregaTirilla.getStrRespuesta()
					);

			if (this.objFacturaGiro.isIncluyeSeguro()) {

				this.objFacturaGiro.getObjNota().setStrDescripcion(
						EnumParametrosApp.SPC_GIRO_ASEGURADO_REMITENTE
								.getObjConstante());

				EnumMensajes.SPC_GIRO_ASEGURADO_REMITENTE.desplegarMensaje(
						super.getFrmForma(), EnumClasesMensaje.INFORMACION);
			}
			if (this.objFacturaGiro.isIncluyeSeguroPago()) {

				this.objFacturaGiro.getObjNota().setStrDescripcion(
						EnumParametrosApp.SPC_GIRO_ASEGURADO_BENEFICIARIO
								.getObjConstante());

				EnumMensajes.SPC_GIRO_ASEGURADO_BENEFICIARIO.desplegarMensaje(
						super.getFrmForma(), EnumClasesMensaje.INFORMACION);
			}
		} catch (Exception e) {
			// RMV- Se ajusta para validar el mensaje que llega y genere la
			// reimpresion solo en casos siguientes.
			if (e instanceof ClientePosSlimGirosException) {

				objMensaje = (Mensaje) ((ClientePosSlimGirosException) e)
						.getObjMensaje();

				if (EventoFormaMovimientoCaja.lstCodMsgXConfirmarTransaccion
						.contains(objMensaje.getCodigo())) {

					/*
					 * if(objMensaje.getCodigo().equals(EnumMensajes.
					 * EJB_ERROR_NO_CONTROLADO.getCodigo()) ||
					 * objMensaje.getCodigo
					 * ().equals(EnumMensajes.ERROR_GENERAL.getCodigo()) ||
					 * objMensaje.getCodigo().equals(EnumMensajes.
					 * SOCKET_SIMS_AGOTO_TIEMPO_ESPERA_.getCodigo()) ||
					 * objMensaje.getCodigo().equals(EnumMensajes.
					 * SOCKET_EMPRESA_AGOTO_TIEMPO_ESPERA.getCodigo())){
					 */

					this.aplicaParaVerificarTransaccion();
				}

			} else {
				this.aplicaParaVerificarTransaccion();
			}

			throw e;
		}
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo realizarPagoGiroExterno [TODO - Documentacion]
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor ****************************************************************
	 */
	private void realizarPagoGiroExterno() throws Exception {

		Mensaje objMensaje;
		ParametroSistema objParMensajeReconfirmacion;

		try {

			UtilBiometria.getInstance().registrarFirmaBiometricaBiometriaLocal(
					super.getObjUsuario(), this.objFacturaGiro,
					EnumTiposOperaciones.PAGO_FACTURACION_GIRO);

			GiroVistaLogica.getInstance()
					.insertarMovimientoPagoFacturacionExterna(
							super.getObjUsuario(), this.objFacturaGiro, this.objFacturaGiro.getObjCRCMedioEntrega().getStrRespuesta());

		} catch (Exception e) {

			if (e instanceof ClientePosSlimGirosException) {

				objMensaje = (Mensaje) ((ClientePosSlimGirosException) e)
						.getObjMensaje();

				objParMensajeReconfirmacion = UtilParametrosSistema
						.getInstance()
						.consultar(
								EnumParametrosSistema.CODIGOS_MENSAJES_RECONFIRMACION_PAGO_EXTERNO);

				if (!objParMensajeReconfirmacion.getValor().equalsIgnoreCase(
						EnumParametrosApp.NO_APLICA.getObjConstante())) {

					if (objParMensajeReconfirmacion.getValor()
							.equalsIgnoreCase(
									EnumParametrosApp.TODO_APLICA
											.getObjConstante())
							|| objParMensajeReconfirmacion.getValor().contains(
									"|" + objMensaje.getCodigo() + "|")) {

						this.aplicaParaVerificarTransaccion();
					}
				}
			} else {
				this.aplicaParaVerificarTransaccion();
			}

			throw e;
		}
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo realizarEnvioRecaudo metodo que permite realizar la transaccion
	 *         para un movimiento del tipo envio de recaudo
	 * @param pDouValorRecibido
	 *            Valor recibido por el sistema para cubrir la transaccion
	 * @param pDouValorDevuelto
	 *            Valor calculado por el sistema segun el valor recibido para
	 *            cubrir la transaccion con respecto al valor y/o costo total de
	 *            la operacion
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private void realizarEnvioRecaudo(double pDouValorRecibido,
			double pDouValorDevuelto) throws Exception {

		this.generarListaConceptosRecaudo();

		RecaudoVistaLogica.getInstance().realizarEnvioRecaudo(
				this.objFacturaGiro, this.strOperacionInusual,
				super.getObjUsuario());
		this.generarImpresionEnvioRecaudo();

		super.cerrarForma();
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo generarListaConceptosRecaudo Permite generar y asociar el listado
	 *         de conceptos exclusivos para una operacion de recaudo
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private void generarListaConceptosRecaudo() throws Exception {

		HashMap<String, Concepto> hmConceptos;
		Concepto objConcepto;
		ParametroSistema objParSisCodConceptoRecaudoXEfectivo;
		ParametroSistema objParSisCodConceptoRecaudoXTarjetas;
		ParametroSistema objParSisCodConceptoRecaudoDetectado;
		// EnumParametrosApp enmParAppConceptoAfectaCaja = null;
		String strIdAfectaCaja;
		String strDescripcion = null;

		UtilParametrosSistema.getInstance().consultar(
				EnumParametrosSistema.CODIGO_CONCEPTO_RECAUDO_X_EFECTIVO,
				EnumParametrosSistema.CODIGO_CONCEPTO_RECAUDO_X_TARJETAS);

		objParSisCodConceptoRecaudoXEfectivo = EnumParametrosSistema.CODIGO_CONCEPTO_RECAUDO_X_EFECTIVO
				.obtenerObjParametro();
		objParSisCodConceptoRecaudoXTarjetas = EnumParametrosSistema.CODIGO_CONCEPTO_RECAUDO_X_TARJETAS
				.obtenerObjParametro();

		hmConceptos = new HashMap<String, Concepto>();

		for (MedioPago objMedioPago : this.hmMediosPagoIngresados.values()) {

			objParSisCodConceptoRecaudoDetectado = null;

			if (UtilMediosPago.getInstance().isMedioPagoTipoEnum(objMedioPago,
					EnumMediosPago.EFECTIVO)) {

				objParSisCodConceptoRecaudoDetectado = objParSisCodConceptoRecaudoXEfectivo;
				// enmParAppConceptoAfectaCaja =
				// EnumParametrosApp.COD_AFECTA_CAJA_CONCEPTO;//31
				strIdAfectaCaja = Concepto.ID_AFECTA_CAJA;
				strDescripcion = EnumParametrosSistema.CODIGO_CONCEPTO_RECAUDO_X_EFECTIVO
						.getEnmEtiDescripcion().toString();

			} else if (UtilMediosPago.getInstance().isMedioPagoTipoEnum(
					objMedioPago, EnumMediosPago.TARJETA_CREDITO,
					EnumMediosPago.TARJETA_DEBITO)) {

				objParSisCodConceptoRecaudoDetectado = objParSisCodConceptoRecaudoXTarjetas;
				// enmParAppConceptoAfectaCaja =
				// EnumParametrosApp.COD_NO_AFECTA_CAJA_CONCEPTO;//32
				strIdAfectaCaja = Concepto.ID_NO_AFECTA_CAJA;
				strDescripcion = EnumParametrosSistema.CODIGO_CONCEPTO_RECAUDO_X_TARJETAS
						.getEnmEtiDescripcion().toString();

			} else {

				strIdAfectaCaja = null;
			}

			if (objParSisCodConceptoRecaudoDetectado != null) {

				if (hmConceptos
						.containsKey(objParSisCodConceptoRecaudoDetectado
								.getValor())) {

					objConcepto = hmConceptos
							.get(objParSisCodConceptoRecaudoDetectado
									.getValor());
					objConcepto.setValor(objConcepto.getValor()
							+ objMedioPago.getValor());

				} else {

					objConcepto = new Concepto();
					objConcepto.setCodigo(objParSisCodConceptoRecaudoDetectado
							.getValor());
					objConcepto.setDescripcion(strDescripcion);
					objConcepto.setCantidad(1);
					objConcepto.setValor(objMedioPago.getValor());
					objConcepto.setStrIdAfectaCaja(strIdAfectaCaja);// enmParAppConceptoAfectaCaja.getObjConstante()

					hmConceptos.put(objConcepto.getCodigo(), objConcepto);
				}
			}
		}

		this.objFacturaGiro.setListaConceptos(new ArrayList<Concepto>(
				hmConceptos.values()));
	}

	/**
	 * ********************************************************************
	 * 
	 * @method facturarEnvioGiro metodo exclusivo del proceso de envio de giro,
	 *         que realiza los procesos necesarios para facturar el envio de
	 *         giro
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author hector.cuenca
	 * @date 1/12/2016
	 *       **********************************************************
	 *       ***********
	 */
	private void facturarEnvioGiro() throws Exception {

		UtilSMSGiro.getInstancia().validarSMSGiro(super.getFrmForma(),
				this.objFacturaGiro.getTerceroDestino(), this.objFacturaGiro);
		this.presentarPantallaCRC();
		if (this.objCRCAdmisionEntregaTirilla != null
				&& this.objCRCAdmisionEntregaTirilla.getStrRespuesta() != null
				&& this.objCRCAdmisionEntregaTirilla.getStrTipo() != null) {
			ParametroSistema psPASI;
			boolean blnImpresionTirillaFisica = false;
			/*psPASI = UtilParametrosSistema.getInstance().consultar(
					EnumParametrosSistema.ID_PRUEBA_EN_FORMATO_FISICO);*/
			if (this.objCRCAdmisionEntregaTirilla.getStrTipo().equals(ControlConsultaPasiVistaLogica.getInstance().getCodcrcpr())  || 
					// psPASI.getValor()) || 
				this.objCRCAdmisionEntregaTirilla.getStrTipo().equals(EnumGeneralidadesTramasGiros.ASTERISCO.getValor()) ) {
				blnImpresionTirillaFisica = true;
			}
			this.realizarEnvioGiro(this.douValorRecibido, this.douValorCambio,
					blnImpresionTirillaFisica);

			this.realizarEnvioSeguro();

			this.realizarEnvioSMS();

//			ValidacionesROE.getInstance().validarROE(this, this.objFacturaGiro);
			super.cerrarForma();
		}
	}

	/**
	 * ****************************************************************.
	 * 
	 * @method realizarEnvioGiro metodo que permite realizar la transaccion para
	 *         un movimiento del tipo envio de giro
	 * @param pDouValorRecibido
	 *            Valor recibido por el sistema para cubrir la transaccion
	 * @param pDouValorDevuelto
	 *            Valor calculado por el sistema segun el valor recibido para
	 *            cubrir la transaccion con respecto al valor y/o costo total de
	 *            la operacion
	 * @param blnImpresionFisicaTirilla
	 *            Boolean para imprimir o no la tirilla fisica
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author Hector Q-en-K
	 *         ****************************************************************
	 */
	private void realizarEnvioGiro(double pDouValorRecibido,
			double pDouValorDevuelto, boolean blnImpresionFisicaTirilla)
			throws Exception {

		Mensaje objMensaje;

		// ***************************************************************************

		try {

			UtilBiometria.getInstance().registrarFirmaBiometricaBiometriaLocal(
					super.getObjUsuario(), this.objFacturaGiro,
					EnumTiposOperaciones.ENVIO_FACTURACION_GIRO);

			GiroVistaLogica.getInstance().insertarMovimientoFacturacion(
					super.getObjUsuario(), this.objFacturaGiro,
					this.strOperacionInusual,
					this.objCRCAdmisionEntregaTirilla.getStrRespuesta());
		} catch (Exception e) {

			if (e instanceof ClientePosSlimGirosException) {

				objMensaje = (Mensaje) ((ClientePosSlimGirosException) e)
						.getObjMensaje();

				if (EventoFormaMovimientoCaja.lstCodMsgXConfirmarTransaccion
						.contains(objMensaje.getCodigo())) {
					this.aplicaParaVerificarTransaccion();
				}

			} else {
				this.aplicaParaVerificarTransaccion();
			}

			throw e;
		}

		this.generarImpresionEnvio(blnImpresionFisicaTirilla);

	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo generarImpresionEnvio metodo que permite generar la impresion del
	 *         envio de giro notificando la finalizacion de la transaccion como
	 *         tal
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @parameter : blnImpresionFisicaTirilla boolean permite presentar o no los
	 *            dialogos relacionados con la impresion
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private void generarImpresionEnvio(boolean blnImpresionFisicaTirilla)
			throws Exception {

		boolean imprimio;

		if (this.objFacturaGiro.getTerceroTramitador() != null
				&& !this.objFacturaGiro.getTerceroTramitador().equals(
						this.objFacturaGiro.getTerceroOrigen())
				|| !this.objFacturaGiro.getTerceroOrigen().getObjBiometria()
						.isBooValidadoBiometricamente()
				|| this.objFacturaGiro.getTerceroOrigen().getObjBiometria()
						.gestionarObjFirmaBiometrica().getStrId().equals("*")) {
			if (blnImpresionFisicaTirilla) {
				EnumMensajes.SOLICITAR_HUELLA_HUMEDA.desplegarMensaje(
						super.getFrmForma(), EnumClasesMensaje.INFORMACION);
			}
		}
		if (blnImpresionFisicaTirilla) {
			imprimio = EnumImpresiones.ENVIO_GIRO_POSTAL.ejecutarImpresion(
					super.getFrmForma(), false, this.objFacturaGiro,
					super.getObjUsuario());
		} else {
			imprimio = true; // El cliente del giro NO solicta la tirilla, no
								// hay impresion fisica
		}
		if (imprimio) {

			EnumMensajes.GIRO_REALIZADO_EXITOSAMENTE.desplegarMensaje(
					super.getFrmForma(), EnumClasesMensaje.INFORMACION,
					this.objFacturaGiro.getDocumento().getAbreviatura(),
					this.objFacturaGiro.getNumero(),
					this.objFacturaGiro.getReferenciaControl());
		} else {

			EnumMensajes.GIRO_REALIZADO_PERO_IMPRESION_ERROR.desplegarMensaje(
					super.getFrmForma(), EnumClasesMensaje.ADVERTENCIA,
					this.objFacturaGiro.getReferenciaControl());
		}

		if (this.objFacturaGiro.getObjClaveSeguridad() != null
				&& (this.objFacturaGiro.getObjClaveSeguridad()
						.getEnmTipoClaveSeguridad()
						.equals(EnumTiposClaveSeguridad.MANUAL) || this.objFacturaGiro
						.getObjClaveSeguridad().getEnmTipoClaveSeguridad()
						.equals(EnumTiposClaveSeguridad.AUTOMATICA))) {

			EnumMensajes.GIRO_CON_CLAVE_SEGURIDAD.desplegarMensaje(super
					.getFrmForma(), EnumClasesMensaje.INFORMACION,
					((EnumTiposClaveSeguridad) this.objFacturaGiro
							.getObjClaveSeguridad().getEnmTipoClaveSeguridad())
							.getEnmEtiNombre().toString());
		}
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo generarImpresionEnvioRecaudo metodo que permite generar la
	 *         impresion del envio de recuado notificando la finalizacion de la
	 *         transaccion como tal
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private void generarImpresionEnvioRecaudo() throws Exception {

		boolean imprimio;

		imprimio = EnumImpresiones.ENVIO_RECAUDO.ejecutarImpresion(super
				.getFrmForma(), false, this.objFacturaGiro, super
				.getObjUsuario().getCaja(), super.getObjUsuario());
		if (imprimio) {

			EnumMensajes.RECAUDO_REALIZADO_EXITOSAMENTE.desplegarMensaje(
					super.getFrmForma(), EnumClasesMensaje.INFORMACION,
					this.objFacturaGiro.getDocumento().getAbreviatura(),
					this.objFacturaGiro.getNumero(),
					this.objFacturaGiro.getReferenciaControl());
		} else {

			EnumMensajes.RECAUDO_REALIZADO_PERO_IMPRESION_ERROR
					.desplegarMensaje(super.getFrmForma(),
							EnumClasesMensaje.ADVERTENCIA,
							this.objFacturaGiro.getReferenciaControl());
		}
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo generarImpresionPagoRecaudo metodo que permite generar la
	 *         impresion del pago de recaudo (dispersion) notificando la
	 *         finalizacion de la transaccion como tal
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private void generarImpresionPagoRecaudo() throws Exception {

		boolean imprimio;

		imprimio = EnumImpresiones.PAGO_RECAUDO.ejecutarImpresion(
				super.getFrmForma(), false, this.objFacturaGiro,
				super.getObjUsuario());
		if (imprimio) {

			EnumMensajes.RECAUDO_PAGADO_EXITOSAMENTE.desplegarMensaje(
					super.getFrmForma(), EnumClasesMensaje.INFORMACION,
					this.objFacturaGiro.getReferenciaControl());
		} else {

			EnumMensajes.RECAUDO_PAGADO_PERO_IMPRESION_ERROR.desplegarMensaje(
					super.getFrmForma(), EnumClasesMensaje.ADVERTENCIA,
					this.objFacturaGiro.getReferenciaControl());
		}
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo generarImpresionPago metodo que permite generar la impresion del
	 *         pago de giro notificando la finalizacion de la transaccion como
	 *         tal
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private void generarImpresionPago(boolean blnImpresionFisicaTirilla)
			throws Exception {

		Tercero objTercero;
		boolean imprimio;

		// dsalazar[PlayTech]
		// Implementacion mejoras cliente: 6-SuperVoucher(mensaje huella humeda)
		// 02-may-2018
		objTercero = this.objFacturaGiro.getObjTerceroApoderado() == null ? this.objFacturaGiro
				.getTerceroDestino() : this.objFacturaGiro
				.getObjTerceroApoderado();

		if (!objTercero.getObjBiometria().isBooValidadoBiometricamente()
				|| objTercero.getObjBiometria().gestionarObjFirmaBiometrica()
						.getStrId().equals("*")) {
			if (blnImpresionFisicaTirilla) {
				EnumMensajes.SOLICITAR_HUELLA_HUMEDA.desplegarMensaje(
						super.getFrmForma(), EnumClasesMensaje.INFORMACION);
			}
		}

		if (blnImpresionFisicaTirilla) {
			imprimio = EnumImpresiones.PAGO_GIRO_POSTAL.ejecutarImpresion(super.getFrmForma(), false,
					this.objFacturaGiro, super.getObjUsuario());

			if (this.objFacturaGiro.getObjTerceroApoderado() != null
					&& ImpresionVistaLogica.getInstancia().isBooRealizarDobleImpresion()) {

				ImpresionVistaLogica.getInstancia().setBooRealizarDobleImpresion(false);
				imprimio = EnumImpresiones.PAGO_GIRO_POSTAL.ejecutarImpresion(super.getFrmForma(), false,
						this.objFacturaGiro, super.getObjUsuario());

			}

		} else {
			imprimio = true; // El cliente del giro NO solicta la tirilla, no
								// hay impresion fisica
		}

		if (imprimio) {

			EnumMensajes.GIRO_PAGADO_EXITOSAMENTE
					.desplegarMensaje(
							super.getFrmForma(),
							EnumClasesMensaje.INFORMACION,
							this.objFacturaGiro.getReferenciaControl(),
							(this.objFacturaGiro.getObjTerceroApoderado() == null ? null
									: "Apoderado "
											+ this.objFacturaGiro
													.getObjTerceroApoderado()
													.toStringXDocumento()));
		} else {

			EnumMensajes.GIRO_PAGADO_PERO_IMPRESION_ERROR
					.desplegarMensaje(
							super.getFrmForma(),
							EnumClasesMensaje.ADVERTENCIA,
							this.objFacturaGiro.getReferenciaControl(),
							(this.objFacturaGiro.getObjTerceroApoderado() == null ? null
									: "Apoderado "
											+ this.objFacturaGiro
													.getObjTerceroApoderado()
													.toStringXDocumento()));
		}
	}

	/**
	 * ********************************************************************
	 * 
	 * @method generarReImpresionPago genera la invocacion de la reimpresion del
	 *         pago de giro
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 1/12/2016
	 *       **********************************************************
	 *       ***********
	 */
	private void generarReImpresionPago() throws Exception {

		new FormaReimpresion((JFrame) super.cerrarForma(), true,
				EnumReimpresiones.REIMPRIMIR_ULTIMO_PAGO_GIRO);
	}

	/**
	 * ********************************************************************
	 * 
	 * @method generarReImpresionEnvio genera la invocacion de la reimpresion
	 *         del envio de giro
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 1/12/2016
	 *       **********************************************************
	 *       ***********
	 */
	private void generarReImpresionEnvio() throws Exception {

		new FormaReimpresion((JFrame) super.cerrarForma(), true,
				EnumReimpresiones.REIMPRIMIR_ULTIMO_ENVIO_GIRO);
	}

	/**
	 * ********************************************************************
	 * 
	 * @method realizarEnvioSeguro metodo que permite realizar la transaccion
	 *         para un movimiento del tipo seguro
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 1/12/2016
	 *       **********************************************************
	 *       ***********
	 */
	private void realizarEnvioSeguro() throws Exception {

		if (ValidacionesSuperCombo.getObjSuperCombo().isBooRealizaSeguro()
				&& this.objFacturaSeguro != null) {

			try {

			    if(objFacturaGiro.isExterno()){
				//Logica pin externo para el protegiro

				this.objFacturaSeguro.setPin(this.objFacturaGiro
						.getReferenciaControlHomologado());
				this.objFacturaSeguro.setReferenciaControl(this.objFacturaGiro
						.getReferenciaControlHomologado());
				
			    }else {
			    	
				this.objFacturaSeguro.setPin(this.objFacturaGiro
							.getReferenciaControl());
				this.objFacturaSeguro.setReferenciaControl(this.objFacturaGiro
							.getReferenciaControl());
			    	
			    }
				ValidacionesSuperCombo.getInstance().cargarMedioPagoSeguro(
						this.objFacturaSeguro);

				ValidacionesSuperCombo.getInstance().crearMovimientoSeguro(
						super.getObjUsuario(), this.objFacturaSeguro);

				this.generarImpresionEnvioSeguro();

			} catch (Exception e) {

				if (e instanceof ClientePosSlimGirosException) {

					super.controlExcepcion(e);
					e.printStackTrace();
				}

				if (!ValidacionesSuperCombo.getObjSuperCombo()
						.isBooRealizaSeguro()
						|| this.objFacturaSeguro.getCertificadoNum() == null
						|| this.objFacturaSeguro.getCertificadoNum().isEmpty()) {

					EnumMensajes.SPC_GIRO_EXITOSO_ERROR_SEGURO
							.desplegarMensaje(super.getFrmForma(),
									EnumClasesMensaje.INFORMACION);
				}

			}
		}
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo generarImpresionEnvioSeguro metodo que permite generar la
	 *         impresion del envio de seguro
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Roberth Martinez Vargas
	 *        ****************************************************************
	 */
	private void generarImpresionEnvioSeguro() throws Exception {

		boolean imprimio;

		imprimio = EnumImpresiones.SEGURO.ejecutarImpresion(
				super.getFrmForma(), false, this.objFacturaSeguro,
				super.getObjUsuario());
		if (imprimio) {

			EnumMensajes.SEGURO_REALIZADO_EXITOSAMENTE.desplegarMensaje(
					super.getFrmForma(), EnumClasesMensaje.INFORMACION,
					this.objFacturaSeguro.getCertificadoNum());
		} else {

			EnumMensajes.SEGURO_REALIZADO_PERO_IMPRESION_ERROR
					.desplegarMensaje(super.getFrmForma(),
							EnumClasesMensaje.ADVERTENCIA,
							this.objFacturaSeguro.getCertificadoNum());
		}
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo realizarEnvioSMS metodo que permite realizar la transaccion para
	 *         un movimiento del tipo SMS
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Roberth Martinez Vargas
	 *        ****************************************************************
	 */
	private void realizarEnvioSMS() throws Exception {

		if (ValidacionesSuperCombo.getObjSuperCombo().isBooRealizaSeguro()
				&& this.objFacturaSeguro.getCertificadoNum() != null
				&& !this.objFacturaSeguro.getCertificadoNum().isEmpty()) {

			try {

				/*
				 * ValidacionesSuperCombo.getInstance().crearMovimientoSMS(super.
				 * getObjUsuario(), this.objFacturaGiroSMS,
				 * this.objFacturaGiro);
				 */

				if (!this.objFacturaGiro.getTerceroDestino().getTelefono2()
						.isEmpty()) {
					// Solo se imprime cuando el tercero destino tiene numero de
					// celular
					this.generarImpresionSMS(this.objFacturaGiro
							.getTerceroDestino());
				}

			} catch (Exception e) {
				e.printStackTrace();

				EnumMensajes.SPC_GIRO_EXITOSO_ERROR_SMS.desplegarMensaje(
						super.getFrmForma(), EnumClasesMensaje.INFORMACION);
			}
		}
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo generarImpresionSMS metodo que permite generar la impresion del
	 *         SMS
	 * @param pObjTerceroNotificado
	 *            Tercero a notificar mediante un SMS que el giro fue pagado
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Roberth Martinez Vargas
	 *        ****************************************************************
	 */
	private void generarImpresionSMS(Tercero pObjTerceroNotificado)
			throws Exception {

		boolean imprimio;

		imprimio = EnumImpresiones.SMS.ejecutarImpresion(super.getFrmForma(),
				false, this.objFacturaGiro, pObjTerceroNotificado,
				super.getObjUsuario());
		if (imprimio) {

			EnumMensajes.SMS_REALIZADO_EXITOSAMENTE.desplegarMensaje(
					super.getFrmForma(), EnumClasesMensaje.INFORMACION,
					this.objFacturaGiro.getReferenciaControl());
		} else {

			EnumMensajes.SMS_REALIZADO_PERO_IMPRESION_ERROR.desplegarMensaje(
					super.getFrmForma(), EnumClasesMensaje.ADVERTENCIA,
					this.objFacturaGiro.getReferenciaControl());
		}
	}

	/**
	 * ********************************************************************
	 * 
	 * @method aplicaParaVerificarTransaccion Metodo que permite validar si el
	 *         error emitido en el proceso de facturacion amerita para realizar
	 *         un proceso de verificacion de la misma a traves de la
	 *         re-impresion
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author hector.cuenca
	 * @date 12/01/2017
	 *       *********************************************************
	 *       ************
	 */
	private void aplicaParaVerificarTransaccion() throws Exception {
		// if ( !this.objFacturaGiro.isBooAptoParaFacturar() )
		// {
		this.booValidaTransaccion = false;
		// }
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo castFrmMovimientoCaja Metodo estandar para formatear el tipo de
	 *         dato general a un tipo especifico ("Casteo"), del atributo padre
	 *         frmForma
	 * @return FormaMovimientoCaja valor especifico recuperado
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private FormaMovimientoCaja castFrmMovimientoCaja() throws Exception {
		return (FormaMovimientoCaja) super.getFrmForma();
	}

	/**
	 * @method getOperacionesClaveSeguridad Metodo get del atributo
	 *         operacionesClaveSeguridad
	 * @return IOperacionesClaveSeguridad Valor del atributo
	 *         operacionesClaveSeguridad devuelto
	 * @author roberth.martinez
	 * @date 23/3/2016
	 */
	public IOperacionesClaveSeguridad getOperacionesClaveSeguridad() {
		return operacionesClaveSeguridad;
	}

	/**
	 * @method setOperacionesClaveSeguridad Metodo set del atributo
	 *         operacionesClaveSeguridad
	 * @param pOperacionesClaveSeguridad
	 *            Valor que tomara el atributo operacionesClaveSeguridad
	 * @author roberth.martinez
	 * @date 23/3/2016
	 */
	public void setOperacionesClaveSeguridad(
			IOperacionesClaveSeguridad pOperacionesClaveSeguridad) {
		this.operacionesClaveSeguridad = pOperacionesClaveSeguridad;
	}

	/**
	 * @method presentarPantallaCRC Metodo permite presentar la pantalla para
	 *         presentar la prueba o evidencia de seleccion de admision o
	 *         entrega de tirilla
	 * @param ninguno
	 * @author dsalazar[PlayTech]
	 * @date 05-marzo-2019
	 */
	private boolean presentarPantallaCRC() throws Exception {
		// ***************************************************************************
		// Invocando pantalla para presentar pregunta de prueba(constancia) de
		// Admision/Entrega giro
		// Capturando el tercero involucrado en el envio del giro postal
		PruebaCRCAdmisionEntrega pobjPruebaCRC = new PruebaCRCAdmisionEntrega();
		boolean blnImpresionFisicaTirilla = true; // Imprimir la tirilla
		Tercero tercero;
		// Obtenga el valor definido en PASI como fisico
		/*ParametroSistema psPASI = UtilParametrosSistema.getInstance()
				.consultar(EnumParametrosSistema.ID_PRUEBA_EN_FORMATO_FISICO);
		String strFormatoFisico = psPASI.getValor();*/
		
		String strFormatoFisico = ControlConsultaPasiVistaLogica.getInstance().getCodcrcpr();

		if (this.objFacturaGiro.getTerceroTramitador() != null) {
			tercero = this.objFacturaGiro.getTerceroTramitador();
		} else {
			tercero = this.objFacturaGiro.getTerceroOrigen();
		}
		this.objCRCAdmisionEntregaTirilla = UtilidadPruebaAdmisionEntregaTirilla
				.getInstancia().realizarPreguntaPruebaAdmisionEnvioTirilla(
						this.getFrmForma(), super.getObjUsuario(), tercero,
						pobjPruebaCRC,
						EnumTiposOperaciones.ENVIO_FACTURACION_GIRO);

		if (this.objCRCAdmisionEntregaTirilla != null
				&& this.objCRCAdmisionEntregaTirilla.getStrRespuesta() != null
				&& this.objCRCAdmisionEntregaTirilla.getStrTipo() != null) {
			this.objFacturaGiro
					.setObjCRCMedioEntrega(objCRCAdmisionEntregaTirilla);
		}

		// Comparar si el tipo es diferente de FISICO.
		if (this.objCRCAdmisionEntregaTirilla != null
				&& this.objCRCAdmisionEntregaTirilla.getStrRespuesta() != null
				&& this.objCRCAdmisionEntregaTirilla.getStrTipo() != null
				&& !this.objCRCAdmisionEntregaTirilla.getStrTipo()
						.equalsIgnoreCase(strFormatoFisico)
				&& !this.objCRCAdmisionEntregaTirilla.getStrTipo().equalsIgnoreCase("*")) {
			blnImpresionFisicaTirilla = false;
		}

		return blnImpresionFisicaTirilla;
	}
	
}

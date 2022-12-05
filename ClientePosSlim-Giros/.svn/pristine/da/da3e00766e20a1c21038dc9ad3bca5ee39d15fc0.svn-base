package co.com.codesa.clienteposslimgiros.eventos.pago;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumImpresiones;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumReimpresiones;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.facturacion.FormaGicoAutomatico;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelBusqueda;
import co.com.codesa.clienteposslimgiros.formas.pago.FormaConsultaGiro;
import co.com.codesa.clienteposslimgiros.formas.pago.FormaPagoGiro;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.utilidades.integracion.slimGiros.UtilIntegracionSlimGiros;
import co.com.codesa.clienteposslimgiros.vista.logica.GiroVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.NotaVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.TerceroVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.impresion.ImpresionVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DatoAdicional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DatoEntidad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Factura;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.reimpresion.resultado.ProcesarResultadosReimpresionDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionEnvioGiroPostalDTO;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

/**
 * ****************************************************************.
 * 
 * @autor: Roberth Martinez Vargas
 * @fecha: 10-mar-2015
 * @descripcion: Clase que representa los eventos de forma consulta giro
 *               nacional
 * @copyright: Copyright 1998-2012 Codesa, Todos los derechos reservados.
 *             ****************************************************************
 */
public class EventoFormaConsultaGiro extends EventoAbstracto {

	/**
	 * @variable hmAllFacturas hashmap de factura giro
	 **/
	private HashMap<String, FacturaGiro> hmAllFacturas;

	/**
	 * @variable lFacturas listado de factura giro
	 **/
	private List<FacturaGiro> lFacturas;

	/**
	 * @variable factura objeto factura giro
	 **/
	private FacturaGiro factura;

	/**
	 * @variable strReferenciaSeleccionada referencia seleccionada de la grilla
	 **/
	private String strReferenciaSeleccionada;

	public EventoFormaConsultaGiro(FormaConsultaGiro pForma) throws Exception {

		super(pForma);
	}

	@Override
	public void accionarVentanaDesplegada(WindowEvent pEvtWindowOpened) throws Exception {

		this.castFrmConsultaGiroNacional().getPnlBusquedaGiros().getCmbBusqueda().getLblObligatorio()
				.aplicarObligatoriedad(true);
		this.castFrmConsultaGiroNacional().getPnlBusquedaGiros().getCmbTiposIdentificacion().getLblObligatorio()
				.aplicarObligatoriedad(true);
		this.castFrmConsultaGiroNacional().getPnlBusquedaGiros().getTxtReferencia().getLblObligatorio()
				.aplicarObligatoriedad(true);
		this.castFrmConsultaGiroNacional().getPnlBusquedaGiros().getTxtIdentificacion().getLblObligatorio()
				.aplicarObligatoriedad(true);
		this.castFrmConsultaGiroNacional().getPnlBusquedaGiros().getDtcFechaInicial().getLblObligatorio()
				.aplicarObligatoriedad(true);
		this.castFrmConsultaGiroNacional().getPnlBusquedaGiros().getDtcFechaFinal().getLblObligatorio()
				.aplicarObligatoriedad(true);

		super.configurarLimpiarXCamposAccionados(this.castFrmConsultaGiroNacional().getTblGiros(),
				this.castFrmConsultaGiroNacional().getPnlBusquedaGiros().getCmbBusqueda(),
				this.castFrmConsultaGiroNacional().getPnlBusquedaGiros().getCmbTiposIdentificacion(),
				this.castFrmConsultaGiroNacional().getPnlBusquedaGiros().getTxtReferencia(),
				this.castFrmConsultaGiroNacional().getPnlBusquedaGiros().getTxtIdentificacion(),
				this.castFrmConsultaGiroNacional().getPnlBusquedaGiros().getDtcFechaInicial(),
				this.castFrmConsultaGiroNacional().getPnlBusquedaGiros().getDtcFechaFinal(),
				this.castFrmConsultaGiroNacional().getPnlBusquedaGiros().getChkDestinatario(),
				this.castFrmConsultaGiroNacional().getPnlBusquedaGiros().getChkRemitente(),
				this.castFrmConsultaGiroNacional().getPnlBusquedaGiros().getChkExterno());
	}

	@Override
	public void accionarCambioRegistro(ListSelectionModel pObjLisSelectionModel, ListSelectionEvent pEvtValueChanged)
			throws Exception {

		if (pObjLisSelectionModel.equals(this.castFrmConsultaGiroNacional().getTblGiros().getSelectionModel())) {

			this.seleccionarGiroGrilla();

		} else {

			super.accionarCambioRegistro(pObjLisSelectionModel, pEvtValueChanged);
		}
	}

	@Override
	public void accionarDobleClick(Component pObjComponent, MouseEvent pEvtMouseClicked) throws Exception {

		if (pObjComponent.equals(this.castFrmConsultaGiroNacional().getTblGiros())) {

			this.despliegueInfoCelda();

		} else {

			super.accionarDobleClick(pObjComponent, pEvtMouseClicked);
		}
	}

	@Override
	public void confirmar() throws Exception {

		FacturaGiro facturaGiro;
		Boolean blnEsGicoYServColabTcro;
		Boolean blnProcesoExitosoGico;
		FormaGicoAutomatico objFormaGicoAutomatico; // Forma modal
		Boolean blnPuedeContinuarPagoGiro = true;

		if (!this.castFrmConsultaGiroNacional().getTblGiros().getSelectionModel().isSelectionEmpty()) {

			facturaGiro = this.hmAllFacturas.get(this.strReferenciaSeleccionada);

			if (facturaGiro.getEstado().getValor()
					.equalsIgnoreCase(EnumParametrosApp.DESCRIPCION_ESTADO_GIRO_PENDIENTE.getValorPropiedad())) {

				// david.marquez
				// HU 11152 (AzureDevOps)
				// Fecha: 2020/nov/19
				
				// Se valida si el pin es gico y si el servicio por colaborador esta activo
				blnEsGicoYServColabTcro = GiroVistaLogica.getInstance().EsGicoYServColabTcro(super.getObjUsuario(), facturaGiro.getReferenciaControl());
			
				// Si el pin a pagar es GICO y el servicio por colaborador esta activo
				// Entonces realiza el cambio  beneficiario o destinatario segun seleccion
				// del usuario
				// Si no es gico o si el servicio por colaborador no esta activo entonces
				// Continua como le venia haciendo, es decir, mostrando el mensaje de mesa de ayuda 
				if(blnEsGicoYServColabTcro) {
					// Se muestra PopUp
					objFormaGicoAutomatico = new FormaGicoAutomatico(super.getFrmForma(),true);
					
					if(objFormaGicoAutomatico.strSeleccionUsuario != null) {
						// Se valida que el usuario selecciono una opción 
						if(!objFormaGicoAutomatico.strSeleccionUsuario.equals("") && (objFormaGicoAutomatico.strSeleccionUsuario.equals("REMITENTE") || objFormaGicoAutomatico.strSeleccionUsuario.equals("BENEFICIARIO"))) {
							
							// Realiza gico automatico
							blnProcesoExitosoGico = GiroVistaLogica.getInstance().CambiarBeneficiarioDestinatarioGico(super.getObjUsuario(), 
																				  facturaGiro.getReferenciaControl(), 
																				  objFormaGicoAutomatico.strSeleccionUsuario);
	
						}
						else {
							blnPuedeContinuarPagoGiro = false;
						}
					}
					else {
						blnPuedeContinuarPagoGiro = false;
					}
				}
					
				if(blnPuedeContinuarPagoGiro) {
					new FormaPagoGiro(this.castFrmConsultaGiroNacional(), true, facturaGiro);
				}
				
			} else {

				throw EnumMensajes.GIRO_DEBE_ESTAR_PENDIENTE_PARA_CONTINUAR.generarExcepcion(EnumClasesMensaje.ERROR);
			}

		} else {

			throw EnumMensajes.DEBE_SELECCIONAR_UN_GIRO_PARA_PAGO.generarExcepcion(EnumClasesMensaje.ERROR);
		}
	}

	@Override
	public void consultar() throws Exception {

		this.limpiarXCampo(null, this.castFrmConsultaGiroNacional().getTblGiros());
		this.validarDatosConsulta();
		this.realizarConsultaGiros();

		if (lFacturas != null && !lFacturas.isEmpty()) {

			this.hmAllFacturas = getHmAllFacturas();
			this.cargaDatos(this.castFrmConsultaGiroNacional().getFiltro() + "", this.lFacturas);

		} else {

			throw EnumMensajes.NO_HAY_DATOS.generarExcepcion(EnumClasesMensaje.ERROR);
		}
	}

	@Override
	public void imprimir() 
		throws Exception 
	{
		if	(	this.castFrmConsultaGiroNacional().getTblGiros().getModel().getRowCount()>0	) 
		{
			if	(	this.castFrmConsultaGiroNacional().getTblGiros().getSelectedRow() >= 0	) 
			{
				this.realizarPreImpresion();

			}	else	{
				throw EnumMensajes.DEBE_SELECCIONAR_REGISTRO_PARA_OPERACION.generarExcepcion(EnumClasesMensaje.ADVERTENCIA);
			}
		}	else	{
			throw EnumMensajes.PRIMERO_DEBE_CONSULTAR.generarExcepcion(EnumClasesMensaje.ADVERTENCIA);
		}
	}
	
	@Override
	public void limpiarXCampo(Component pObjCmpAccionaLimpieza, Component... pArrObjCmpALimpiar) throws Exception {
		super.limpiarXCampo(pObjCmpAccionaLimpieza, pArrObjCmpALimpiar);

		this.limpiarObjTemporales();
	}

	/** 
	 * ********************************************************************
	 * @method 	realizarPreImpresion
	 * 		   	Metodo que permite validar si el sistema puede generar un 
	 * 			comprobante pre-impreso de la operacion, y en caso de permitir
	 * 			desplegar el debido proceso
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	30/11/2018
	 * *********************************************************************
	 */
	private void realizarPreImpresion()
		throws Exception
	{
		FacturaGiro objFacturaGiro;
		
		objFacturaGiro = this.hmAllFacturas.get(this.strReferenciaSeleccionada);
		
		GiroVistaLogica.getInstance().validarAutorizaPreImpresionPago	(	super.getObjUsuario(),
																			objFacturaGiro
																		);
		
		objFacturaGiro = this.consultarDetalleGiroParaImpresion(objFacturaGiro);
		
		EnumImpresiones.PRE_IMPRESION_PAGO_GIRO_DOMICILIADO.ejecutarImpresion	(	super.getFrmForma(), 
				  																	false,
				  																	objFacturaGiro,
				  																	super.getObjUsuario()
				  																);
	}
	
	/** 
	 * ********************************************************************
	 * @method 	consultarDetalleGiroParaImpresion
	 * 		   	Metodo que permite recuperar la informacion detallada del giro
	 * 			a traves de una consulta de reimpresion por pin
	 * @param	pObjFacturaGiro
	 * 			Objeto factura que representa la transaccion en proceso
	 * @return	FacturaGiro
	 * 			Objeto factura giro consultado
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	30/11/2018
	 * *********************************************************************
	 */
	private FacturaGiro consultarDetalleGiroParaImpresion(FacturaGiro pObjFacturaGiro)
		throws Exception
	{
		FacturaGiro objFacturaGiro;
		VariablesImpresionEnvioGiroPostalDTO pObjVariablesImpresion;
		ProcesarResultadosReimpresionDTO pObjResultadosReimpresion;
		EnumReimpresiones enmReimpresion;
		DatoAdicional objDatAdiPinGiro;
		Tercero objTerceroRemitente;
		Tercero objTerceroBeneficiario;
		
		objDatAdiPinGiro = new DatoAdicional(	"PIN",
												"PIN GIRO",
												this.strReferenciaSeleccionada
											);
		enmReimpresion = EnumReimpresiones.REIMPRIMIR_X_PIN_ENVIO_GIRO;
		enmReimpresion.getObjParametrosReimpresion().getHmDatosAdicionales().put(	objDatAdiPinGiro.getStrId(), 
																					objDatAdiPinGiro
																				);
		pObjVariablesImpresion = new VariablesImpresionEnvioGiroPostalDTO();
		pObjResultadosReimpresion = new ProcesarResultadosReimpresionDTO();
		
		ImpresionVistaLogica.getInstancia().consultarParaReimpresion(	super.getObjUsuario(), 
																		EnumReimpresiones.REIMPRIMIR_X_PIN_ENVIO_GIRO, 
																		pObjVariablesImpresion, 
																		pObjResultadosReimpresion
																	);
		objFacturaGiro = pObjVariablesImpresion.getObjFacturaGiro();
		
		objTerceroRemitente = TerceroVistaLogica.getInstance().consultarTercero	(	super.getObjUsuario(),
																					objFacturaGiro.getTerceroOrigen().getTipoIdentificacion(),
																					objFacturaGiro.getTerceroOrigen().getIdentificacion(), 
																					false
																				);
		objTerceroBeneficiario = TerceroVistaLogica.getInstance().consultarTercero	(	super.getObjUsuario(),
																						objFacturaGiro.getTerceroDestino().getTipoIdentificacion(),
																						objFacturaGiro.getTerceroDestino().getIdentificacion(), 
																						false
																					);
		objFacturaGiro.setTerceroOrigen(objTerceroRemitente);
		objFacturaGiro.setTerceroDestino(objTerceroBeneficiario);
		
		return objFacturaGiro;
	}
	
	/**
	 * ********************************************************************
	 * 
	 * @method limpiarObjTemporales Metodo encargado de considerar labores de
	 *         limpieza en los objetos temporales de la funcionalidad
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author hector.cuenca
	 * @date 12/06/2017
	 *       *********************************************************************
	 */
	private void limpiarObjTemporales() throws Exception {
		if (lFacturas != null) {
			lFacturas.clear();
		}
		if (hmAllFacturas != null && !hmAllFacturas.isEmpty()) {
			hmAllFacturas.clear();
		}
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo despliegueInfoCelda Metodo utilizado para desplegar el valor interno
	 *         de cada celda visible de la grilla de giros consultados
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private void despliegueInfoCelda() throws Exception {

		int intColumnaNotas;
		int intColumnaSeleccionada;
		int intFilaSeleccionada;
		Object objValorCelda;

		intFilaSeleccionada = this.castFrmConsultaGiroNacional().getTblGiros().getSelectedRow();
		intColumnaSeleccionada = this.castFrmConsultaGiroNacional().getTblGiros().getSelectedColumn();
		intColumnaNotas = this.castFrmConsultaGiroNacional().getTblGiros().getColumnModel()
				.getColumnIndex(EnumEtiquetas.TTL_CGN_GRILLA_GIROS_NOTAS.toString());

		if (intColumnaSeleccionada == intColumnaNotas) {

			this.mostrarNotasGiro();

		} else {

			objValorCelda = this.castFrmConsultaGiroNacional().getTblGiros().getValueAt(intFilaSeleccionada,
					intColumnaSeleccionada);
			this.mostrarInfoOtrasColumnas(objValorCelda);
		}
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo seleccionarGiroGrilla Metodo utilizado
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private void seleccionarGiroGrilla() throws Exception {

		int intFilaSeleccionada;
		int intColumnaReferencia;

		intColumnaReferencia = 0;
		intFilaSeleccionada = this.castFrmConsultaGiroNacional().getTblGiros().getSelectedRow();

		this.strReferenciaSeleccionada = this.castFrmConsultaGiroNacional().getTblGiros()
				.getValueAt(intFilaSeleccionada, intColumnaReferencia).toString();
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo validarDatosConsulta Metodo que ejecuta las validaciones sobre los
	 *         criterios de busqueda, que alimentaran el proceso de consulta
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private void validarDatosConsulta() throws Exception {

		FormaPanelBusqueda pnlBusqueda;

		UtilComponentesGUI.getInstance().validarCamposObligatorios(super.getFrmForma(), true, true);

		pnlBusqueda = this.castFrmConsultaGiroNacional().getPnlBusquedaGiros();
		/*
		 * UtilComponentesGUI.getInstance().validarObligatoriedadCampo(pnlBusqueda.
		 * getCmbBusqueda(), pnlBusqueda.getLblBusqueda().getTextoOriginal(), true,
		 * true);
		 */

		if (this.castFrmConsultaGiroNacional().getPnlBusquedaGiros().getCmbBusqueda().getSelectedItem()
				.equals(EnumEtiquetas.LBL_BUS_ITEM_BUSQUEDA_POR_DOCUMENTO)) {

			this.validarConsultaXDocumento(pnlBusqueda);

		} /*
			 * else{
			 * 
			 * this.validarConsultaXReferencia(pnlBusqueda); }
			 */
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo validarConsultaXReferencia Metodo que ejecuta las validaciones cuando
	 *         se consulta por pin
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Roberth Martinez Vargas
	 *        ****************************************************************
	 */
	/*
	 * private void validarConsultaXReferencia(FormaPanelBusqueda
	 * pPnlBusqueda)throws Exception{
	 * 
	 * UtilComponentesGUI.getInstance().validarObligatoriedadCampo(pPnlBusqueda.
	 * getTxtReferencia(),
	 * pPnlBusqueda.getCmbBusqueda().getSelectedItem().toString(), true, true); }
	 */

	/**
	 * ****************************************************************.
	 * 
	 * @metodo validarConsultaXDocumento Metodo que ejecuta las validaciones cuando
	 *         se consulta por documento
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Roberth Martinez Vargas
	 *        ****************************************************************
	 */
	private void validarConsultaXDocumento(FormaPanelBusqueda pPnlBusqueda) throws Exception {

		Date datFechaInicial;
		Date datFechaFinal;
		Date datFechaActual;

		/*
		 * UtilComponentesGUI.getInstance().validarObligatoriedadCampo(pPnlBusqueda.
		 * getCmbTiposIdentificacion(),
		 * EnumEtiquetas.LBL_BUS_TIPOS_IDENTIFICACION.toString(), true, true);
		 * 
		 * UtilComponentesGUI.getInstance().validarObligatoriedadCampo(pPnlBusqueda.
		 * getTxtReferencia(),
		 * pPnlBusqueda.getCmbBusqueda().getSelectedItem().toString(), true, true);
		 * 
		 * UtilComponentesGUI.getInstance().validarObligatoriedadCampo(pPnlBusqueda.
		 * getDtcFechaInicial(), pPnlBusqueda.getLblFechaInicial().getTextoOriginal(),
		 * true, true);
		 * 
		 * UtilComponentesGUI.getInstance().validarObligatoriedadCampo(pPnlBusqueda.
		 * getDtcFechaFinal(), pPnlBusqueda.getLblFechaFinal().getTextoOriginal(), true,
		 * true);
		 * 
		 */

		datFechaInicial = pPnlBusqueda.getDtcFechaInicial().getDate();
		datFechaFinal = pPnlBusqueda.getDtcFechaFinal().getDate();
		datFechaActual = UtilidadGiros.getInstancia().obtenerFechaSinHora(UtilIntegracionSlimGiros.getInstance().obtenerFechaHoraActualPosSlim());

		if (datFechaInicial.compareTo(datFechaActual) > 0) {

			throw EnumMensajes.FECHA_1_MAYOR_FECHA_2.generarExcepcion(EnumClasesMensaje.ERROR,
					pPnlBusqueda.getLblFechaInicial().getTextoOriginal(), EnumEtiquetas.LBL_FECHA_ACTUAL.toString());
		}

		if (datFechaFinal.compareTo(datFechaActual) > 0) {

			throw EnumMensajes.FECHA_1_MAYOR_FECHA_2.generarExcepcion(EnumClasesMensaje.ERROR,
					pPnlBusqueda.getLblFechaFinal().getTextoOriginal(), EnumEtiquetas.LBL_FECHA_ACTUAL.toString());
		}

		if (datFechaInicial.compareTo(datFechaFinal) > 0) {

			throw EnumMensajes.FECHA_1_MAYOR_FECHA_2.generarExcepcion(EnumClasesMensaje.ERROR,
					pPnlBusqueda.getLblFechaInicial().getTextoOriginal(),
					pPnlBusqueda.getLblFechaFinal().getTextoOriginal());
		}
	}

	/**
	 * ****************************************************************
	 * 
	 * @metodo realizarConsultaGiros Metodo encargado para realizar la consulta de
	 *         giros, la cual puede ser interna o externa
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Roberth Martinez Vargas
	 *        ****************************************************************
	 */
	private void realizarConsultaGiros() throws Exception {

		FormaPanelBusqueda pnlBusqueda;
		DatoEntidad objDatEntTipoIdentificacion;
		Boolean objBooRemitenteDestinatario;
		String strIdentificacion;
		String strReferencia;

		pnlBusqueda = this.castFrmConsultaGiroNacional().getPnlBusquedaGiros();

		if (pnlBusqueda.getCmbBusqueda().getSelectedItem().equals(EnumEtiquetas.LBL_BUS_ITEM_BUSQUEDA_POR_DOCUMENTO)) {

			strIdentificacion = pnlBusqueda.getTxtIdentificacion().getText();
			strReferencia = null;
			objDatEntTipoIdentificacion = pnlBusqueda.getEvtFrmBusqueda().obtenerTipoIdentificacion();
			objBooRemitenteDestinatario = pnlBusqueda.getChkRemitente().isSelected();

		} else {

			strIdentificacion = null;
			strReferencia = pnlBusqueda.getTxtReferencia().getText();
			objDatEntTipoIdentificacion = null;
			objBooRemitenteDestinatario = null;
		}

		if (pnlBusqueda.getDtcFechaInicial().toString() == null) {
			pnlBusqueda.getDtcFechaInicial().setDate(UtilIntegracionSlimGiros.getInstance().obtenerFechaHoraActualPosSlim());
		}

		if (pnlBusqueda.getDtcFechaFinal().toString() == null) {
			pnlBusqueda.getDtcFechaFinal().setDate(UtilIntegracionSlimGiros.getInstance().obtenerFechaHoraActualPosSlim());
		}

		if (pnlBusqueda.getChkExterno().isSelected()) {

			// Consultar en sistema externo

			this.lFacturas = GiroVistaLogica.getInstance().consultaGiroExterno(super.getObjUsuario(),
					pnlBusqueda.getDtcFechaInicial().toString(), pnlBusqueda.getDtcFechaFinal().toString(),
					objDatEntTipoIdentificacion, strIdentificacion, strReferencia);
		} else {

			// Consultar en sistema interno

			this.lFacturas = GiroVistaLogica.getInstance().consultaGiroInterno(super.getObjUsuario(),
					pnlBusqueda.getDtcFechaInicial().toString(), pnlBusqueda.getDtcFechaFinal().toString(),
					objDatEntTipoIdentificacion, strIdentificacion, strReferencia, "*", "ESP",
					objBooRemitenteDestinatario, "*", "5", "0");
		}		
	}

	/**
	 * ****************************************************************
	 * 
	 * @metodo getHmAllFacturas metodo para manejar el hashmap de facturas que
	 *         arroja la consulta
	 * @return HashMap<String,Factura> que contiene las facturas disponibles en la
	 *         grilla
	 * @autor Roberth Martinez Vargas
	 *        ****************************************************************
	 */
	private HashMap<String, FacturaGiro> getHmAllFacturas() throws Exception {
		if (hmAllFacturas == null) {
			hmAllFacturas = new HashMap<String, FacturaGiro>(1, 1);
		} else {
			hmAllFacturas.clear();
		}

		return hmAllFacturas;
	}

	/**
	 * ****************************************************************
	 * 
	 * @param filtro
	 * @param listFacturas
	 * @metodo cargaDatos metodo para cargar las facturas retornadas en la consulta
	 *         al hashmap
	 * @autor Roberth Martinez Vargas
	 *        ****************************************************************
	 */
	private void cargaDatos(String filtro, List<FacturaGiro> listFacturas) throws Exception {

	Iterator<FacturaGiro> iter = listFacturas.iterator();
		boolean blnAgregarRegistro = false;
		int intContadorPinRecaudo  = 0;
		FormaPanelBusqueda pnlBusqueda;
		Tercero tmpTerc = new Tercero(); //Para poder consultar tipo de tercero ¿Recaudador?
		
		pnlBusqueda = this.castFrmConsultaGiroNacional().getPnlBusquedaGiros();
		
		while (iter.hasNext()) {

			factura = iter.next();

			if (hmAllFacturas.get("" + factura.getReferenciaControl()) == null) {

				hmAllFacturas.put("" + factura.getReferenciaControl(), factura);

				// dsalazar[PlayTech]
				// 19-abr-2018
				// 447902- Gestion Desarrollo Funcionalidades Bnet Cliente Giros (cierre brecha funcional)
				// VISUALIZACION DE RECAUDOS EN PAGO DE GIROS convenio no se agrega
				blnAgregarRegistro = true;
				
				// esta validaciones se realizan para el Ticket 491808 - Homologacion de Terceros Red Externa
				// Se valida si el giro es de la red externa
				if (pnlBusqueda.getChkExterno().isSelected()) {
					// Si es de la red externa de consulta al tercero beneficiario 
					tmpTerc = TerceroVistaLogica.getInstance().consultarTerceroExterno(super.getObjUsuario(),
																					   factura.getTerceroDestino().getTipoIdentificacion(),
																					   factura.getTerceroDestino().getIdentificacion());
					// Si el tercero beneficiario no existe se sigue trabjando con los datos traidos de matrix
					if (tmpTerc == null) {
						tmpTerc = factura.getTerceroDestino();
					}else {
						// si existe se deja la logia existente 
						tmpTerc = TerceroVistaLogica.getInstance().consultarTercero(super.getObjUsuario(),
																					factura.getTerceroDestino().getTipoIdentificacion(),
																					factura.getTerceroDestino().getIdentificacion(), false);
					}
				} else {
					tmpTerc = TerceroVistaLogica.getInstance().consultarTercero(super.getObjUsuario(),
																				factura.getTerceroDestino().getTipoIdentificacion(),
																				factura.getTerceroDestino().getIdentificacion(), false);
				}
				
				
				
				if (tmpTerc.getTipoTecero().getId().equals(EnumParametrosSistema.ID_TIPO_TERCERO_CONVENIO.obtenerValorCadena())) {
					blnAgregarRegistro = false;
					intContadorPinRecaudo += 1;
				}
				
				if (blnAgregarRegistro) {
					this.castFrmConsultaGiroNacional().getTblGiros().getPropiedades().adicionarFilaGrilla(factura.getRow(filtro));
				}
			}
		}
		
		if (intContadorPinRecaudo == listFacturas.size()) {
			throw EnumMensajes.NO_HAY_DATOS.generarExcepcion(EnumClasesMensaje.ERROR);
		}
	}

	/**
	 * ****************************************************************
	 * 
	 * @metodo mostrarOtrasColumnas metodo para mostrar la informacion de las
	 *         columnas excepto la columna notas
	 * @param pObjValorCelda
	 *            valor de la celda clickeada sobre la grilla
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Roberth Martinez Vargas
	 *        ****************************************************************
	 */
	private void mostrarInfoOtrasColumnas(Object pObjValorCelda) throws Exception {

		String strValorMostrar = null;

		if (pObjValorCelda != null) {

			if (pObjValorCelda instanceof Number) {

				strValorMostrar = UtilidadGiros.getInstancia().formatoPresentacionNumero(pObjValorCelda);

			} else {

				strValorMostrar = pObjValorCelda.toString();
			}

			if (strValorMostrar != null && !strValorMostrar.isEmpty()) {

				EnumMensajes.desplegarMensajePersonalizado(super.getFrmForma(), EnumClasesMensaje.INFORMACION, null,
						"{1}", strValorMostrar);
			}
		}
	}

	/**
	 * ****************************************************************
	 * 
	 * @metodo mostrarNotas metodo para mostrar la informacion de la columna notas
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Roberth Martinez Vargas
	 *        ****************************************************************
	 */
	private void mostrarNotasGiro() throws Exception {

		String strNotas = null;

		Factura fact = hmAllFacturas.get(this.strReferenciaSeleccionada);
		getObserOr(fact);

		strNotas = "Referencia Giro: " + this.strReferenciaSeleccionada + "\nNotas: " + fact.getObjNota();

		fact.setLastComunic("");

		EnumMensajes.desplegarMensajePersonalizado(this.castFrmConsultaGiroNacional(), EnumClasesMensaje.INFORMACION,
				null, "'" + strNotas + "'");
	}

	/**
	 * ****************************************************************
	 * 
	 * @metodo getObserOr metodo para obtener las notas de una factura, valida si la
	 *         factura no tiene notas, de ser asi manda una trama para consultar las
	 *         notas del giro
	 * @return Factura, factura con las notas del giro actualizadas
	 * @autor Roberth Martinez Vargas
	 *        ****************************************************************
	 */
	private void getObserOr(Factura fact) throws Exception {

		if (fact.getObjNota().getStrDescripcion().equals("*")) {

			NotaVistaLogica.getInstance().consultaNotasGiro(super.getObjUsuario(), fact);

		}
	}

	/**
	 * ****************************************************************
	 * 
	 * @throws Exception
	 * @metodo limpiarGrilla metodo para limpiar la grilla de consulta de giros
	 * @autor Roberth Martinez Vargas
	 *        ****************************************************************
	 */
	/*
	 * private void limpiarGrilla()throws Exception{
	 * 
	 * if(lFacturas!=null){ lFacturas.clear(); } if(hmAllFacturas!=null &&
	 * !hmAllFacturas.isEmpty()){ hmAllFacturas.clear(); }
	 * 
	 * this.castFrmConsultaGiroNacional().getTblGiros().getPropiedades().
	 * limpiarGrilla(); }
	 */

	public FormaConsultaGiro castFrmConsultaGiroNacional() throws Exception {
		return (FormaConsultaGiro) super.getFrmForma();
	}

}

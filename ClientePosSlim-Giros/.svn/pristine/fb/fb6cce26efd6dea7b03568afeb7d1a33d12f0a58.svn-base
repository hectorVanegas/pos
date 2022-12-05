package co.com.codesa.clienteposslimgiros.eventos.facturacion;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;

import co.com.codesa.clienteposslimexception.exceptions.ClientePosSlimGirosException;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDocumentos;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEstadoTransaccion;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumProductos;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumReimpresiones;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.enumeraciones.operaciones.EnumTiposOperaciones;
import co.com.codesa.clienteposslimgiros.enumeraciones.proveedorServicioProducto.EnumTiposServicios;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.caja.FormaMovimientoCaja;
import co.com.codesa.clienteposslimgiros.formas.convenio.FormaConvenioPropiedades;
import co.com.codesa.clienteposslimgiros.formas.convenio.FormaConvenioSedes;
import co.com.codesa.clienteposslimgiros.formas.declaraionorigenesfondo.FormaDeclaracionOrigenesFondos;
import co.com.codesa.clienteposslimgiros.formas.facturacion.FormaEnvioFacturacion;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaDatosAdicionales;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.mensajes.FormaMensajeAlerta;
import co.com.codesa.clienteposslimgiros.formas.reimpresion.FormaReimpresion;
import co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.FormaPanelConfirmarNormativa;
import co.com.codesa.clienteposslimgiros.formas.superCombo.FormaSuperComboOrigen;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.utilidades.estadoTransaccion.EstadoTransaccion;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.clienteposslimgiros.utilidades.terceros.peps.UtilTerceroPeps;
import co.com.codesa.clienteposslimgiros.utilidades.validaciones.ValidacionesBiometria;
import co.com.codesa.clienteposslimgiros.utilidades.validaciones.ValidacionesSuperCombo;
import co.com.codesa.clienteposslimgiros.utilidades.validaciones.ValidacionesTercero;
import co.com.codesa.clienteposslimgiros.vista.logica.DatoEntidadVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.GiroVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.TerceroVistaLogica;
import co.com.codesa.codesawrapper.modelo.dominio.ParametroSistema;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Agencia;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Concepto;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DatoEntidad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Documento;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Factura;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaSeguro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Producto;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Convenio;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

/** 
 * ********************************************************************
 * @class  EventoFormaEnvioFacturacion
 *		   Clase que representa los eventos de forma envio facturacion
 * @author roberth.martinez
 * @date   18/3/2015
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class EventoFormaEnvioFacturacion extends EventoAbstracto{

	/**
	 * @variable intNumeroItems
	 * 		     numero de items de la factura
	 **/
	private int intNumeroItems;
	
	/**
	 * @variable douValorGiro
	 * 		     valor del giro en formato double
	 **/
	private double douValorGiro;
	
	/**
	 * @variable strValGiro
	 * 		     valor actual del giro
	 **/
	private String strValGiro;
	
	/**
	 * @variable strValGiroAnterior
	 * 		     valor temporal del giro
	 **/
	private String strValGiroAnterior;
	
	/**
	 * @variable arrConv
	 * 		     array de convenios
	 **/
	private String[] arrConv;
	
	/**
	 * @variable vecConvenio
	 * 		     vector de convenios
	 **/
	private Vector<Convenio> vecConvenio;
	
	/**
	 * @variable objFacturaGiro
	 * 		     objeto facturaGiro del cual se esta llevando a cabo la transaccion
	 **/
	private FacturaGiro objFacturaGiro;
	
	/**
	 * @variable objFacturaGiroSMS
	 * 		     objeto facturaGiro para el SMS del cual se esta llevando a cabo la transaccion
	 **/
	//private FacturaGiro objFacturaGiroSMS;
	
	/**
	 * @variable objFacturaGiroSMS
	 * 		     objeto factura para el el seguro del cual se esta llevando a cabo la transaccion
	 **/
	private FacturaSeguro objFacturaSeguro;
	
	/**
	 * @variable objTerceroOrigen
	 * 		     objeto tercero para el tercero origen
	 **/
	private Tercero objTerceroOrigen;
	
	/**
	 * @variable objTerceroDestino
	 * 		     objeto tercero para el tercero destino
	 **/
	private Tercero objTerceroDestino;
	
	/**
	 * @variable objTerceroTramitador
	 * 		     objeto tercero para el tercero tramitador
	 **/
	private Tercero objTerceroTramitador;
	
	/**
	 * @variable frmConvenioSedes
	 * 		     objeto de la forma FormaConvenioSedes para seleccionar la sede del convenio
	 **/
	private FormaConvenioSedes frmConvenioSedes;
	
	/**
     * ****************************************************************
     * @method EventoFormaEnvioFacturacion
     * 		   Constructor de la clase EventoFormaConsultaGiro
     * @param  pForma 
  	 * 		   referencia a la GUI de la cual se estan controlando los 
  	 * 		   eventos
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada 
     * @author Roberth Martinez Vargas
     * ****************************************************************
     */
	public EventoFormaEnvioFacturacion(FormaGenerica pForma) throws Exception{
		
		super(pForma);
		this.objFacturaGiro = new FacturaGiro();
	}
	
	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma) throws Exception{
		
		this.configuracionCampoTexto();
		this.llenarInformacionFormulario();
		this.consultarConvenios();
		ValidacionesBiometria.getInstance().setStrIdentificacionTerceroValidado("");//Se limpia esta variable por transaccion
	}
	
	@Override
	public void accionarVentanaDesplegada(WindowEvent pEvtWindowOpened) throws Exception {
		
		this.castfrmEnvioGiroPostal().getPnlTerceroOrg().castEvaFrmTercero().aplicarObligatoriedad(true);
		this.castfrmEnvioGiroPostal().getPnlTerceroDes().castEvaFrmTercero().aplicarObligatoriedad(true);
		this.castfrmEnvioGiroPostal().getPnlTerceroTra().castEvaFrmTercero().aplicarObligatoriedad(true);
		this.castfrmEnvioGiroPostal().getTxtValorGiro().getLblObligatorio().aplicarObligatoriedad(true);
		this.castfrmEnvioGiroPostal().getPnlTerritorioAgenciaDestino().getCmbDepartamento().getLblObligatorio().aplicarObligatoriedad(true);
		this.castfrmEnvioGiroPostal().getPnlTerritorioAgenciaDestino().getCmbMunicipio().getLblObligatorio().aplicarObligatoriedad(true);
		this.castfrmEnvioGiroPostal().getPnlTerritorioAgenciaDestino().getCmbAgencia().getLblObligatorio().aplicarObligatoriedad(true);
		
		this.castfrmEnvioGiroPostal().getTxtValorGiro().setNextFocusableComponent(this.castfrmEnvioGiroPostal().getPnlTerritorioAgenciaDestino().getCmbDepartamento());
		this.castfrmEnvioGiroPostal().getPnlTerceroOrg().getTxtIdentificacion().requestFocus();
	}
	
	@Override
	public void accionarCambioItem(Component pComponent,
								   ItemEvent pEvtItemStateChanged) throws Exception {
		
		if(pComponent.equals(this.castfrmEnvioGiroPostal().getChkIncluyeTramitador())){
			
			this.validaCheckTramitador(this.castfrmEnvioGiroPostal().getChkIncluyeTramitador().isSelected());
			
		}else if(pComponent.equals(this.castfrmEnvioGiroPostal().getChkDomicilio())){
			
			this.validaCheckDomicilio(this.castfrmEnvioGiroPostal().getChkDomicilio().isSelected());
			
		}else if(pComponent.equals(this.castfrmEnvioGiroPostal().getChkIncluyeOtros())){
			
			this.limpiaDatosCambio();
			
		}else if(pComponent.equals(this.castfrmEnvioGiroPostal().getChkIncluyeFlete())){
			
			this.limpiaDatosCambio();
			
		}else if(pComponent.equals(this.castfrmEnvioGiroPostal().getChkIncluyeDomicilio())){
			
			this.limpiaDatosCambio();
			
		}else if(pComponent.equals(this.castfrmEnvioGiroPostal().getPnlTerritorioAgenciaDestino().getCmbDepartamento())){
			
			this.limpiaDatosCambio();
			
		}else if(pComponent.equals(this.castfrmEnvioGiroPostal().getPnlTerritorioAgenciaDestino().getCmbMunicipio())){
			
			this.limpiaDatosCambio();
			
		}else if(pComponent.equals(this.castfrmEnvioGiroPostal().getPnlTerritorioAgenciaDestino().getCmbAgencia())){
			
			this.limpiaDatosCambio();
			
		}else{
			
			super.accionarCambioItem(pComponent,
									 pEvtItemStateChanged);
		}
	}
	
	@Override
	public void accionarEjecucion(Component pComponent,
								  AWTEvent pEvtEjecucion) throws Exception {
		
		if(pComponent.equals(this.castfrmEnvioGiroPostal().getBtnCotizar())){
			
			this.cotizar();
			
		}else{
			
			super.accionarEjecucion(pComponent,pEvtEjecucion);
		}
	}

	@Override
	public void accionarUnClick(Component pObjComponent,
								MouseEvent pEvtMouseClicked) throws Exception {
		
		if(pObjComponent.equals(this.castfrmEnvioGiroPostal().getLstConvenio())){
			
			this.validacionConvenio();
			
		}else{
			
			super.accionarUnClick(pObjComponent,pEvtMouseClicked);
		}
	}
	
	@Override
	public void accionarFocoPerdido(Component pComponent,
									FocusEvent pEvtFocusLost)throws Exception{
		
		if (pComponent.getName().equalsIgnoreCase(this.castfrmEnvioGiroPostal().getTxtValorGiro().getName())) {
			
			validarValorgiro();
			
		} else if (pComponent.equals(this.castfrmEnvioGiroPostal().getPnlTerceroOrg().getTxtIdentificacion())) {
			
			this.validaProcesoTerceroPeps();
			
			this.validaCambioTercero(this.objTerceroOrigen, 
									 this.castfrmEnvioGiroPostal().getPnlTerceroOrg().castEvaFrmTercero().getObjTercero());
			
			this.objTerceroOrigen = this.castfrmEnvioGiroPostal().getPnlTerceroOrg().castEvaFrmTercero().getObjTercero();
			
		} else if (pComponent.equals(this.castfrmEnvioGiroPostal().getPnlTerceroTra().getTxtIdentificacion())) {
			
			this.validaProcesoTerceroPeps();
			
			this.validaCambioTercero(this.objTerceroTramitador, 
									 this.castfrmEnvioGiroPostal().getPnlTerceroTra().castEvaFrmTercero().getObjTercero());
			
			this.objTerceroTramitador = this.castfrmEnvioGiroPostal().getPnlTerceroTra().castEvaFrmTercero().getObjTercero();
			
		}else if (pComponent.equals(this.castfrmEnvioGiroPostal().getPnlTerceroDes().getTxtIdentificacion())) {
			this.validaCambioTercero(this.objTerceroDestino, 
					 				 this.castfrmEnvioGiroPostal().getPnlTerceroDes().castEvaFrmTercero().getObjTercero());
		}else{
			
			super.accionarFocoPerdido(pComponent,pEvtFocusLost);
		}
	}
	
	@Override
	public void confirmar() throws Exception{
		if (this.validarAccionContinuar()) {
			
			this.mostrarMovimientoCaja();
		}
	}
	
	/**
     * ****************************************************************
     * @method llenarInformacionFormulario
     * 		   metodo utilizado para inicializar los datos de la forma 
     * 		   envio giro postal
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
     * @author Roberth Martinez Vargas
     * ****************************************************************
     */
	private void llenarInformacionFormulario()throws Exception{
		
		Producto productoGiro;
		
		productoGiro = super.getObjUsuario().getProductos().get(0);
		
		this.castfrmEnvioGiroPostal().getPnlEncabezadoFactura().getEvaFrmPnlFactura().cargarPanel(productoGiro, 
																								  productoGiro.getDocumentos().get(0), 
																								  null);
		
		this.castfrmEnvioGiroPostal().getPnlTerritorioAgenciaOrigen().castEventosForma().definirTerritorioBase(super.getObjUsuario().getAgencia().getTerritorio());
		this.castfrmEnvioGiroPostal().getPnlTerritorioAgenciaOrigen().getCmbAgencia().addItem(super.getObjUsuario().getAgencia());
		this.castfrmEnvioGiroPostal().getPnlTerritorioAgenciaOrigen().getCmbAgencia().setSelectedItem(super.getObjUsuario().getAgencia());
		
		this.aplicaBiometriaPanelTercero(false);//inicia con valor false, por que el tramitador no esta senalado
		
		this.cargarDatosMsjPredeterminados();
		
	}
	
	/**
     * ****************************************************************
     * @method configuracionCampoTexto
     *		   metodo utilizado para inicializar los datos de la forma 
     *		   envio giro postal
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
     * @author Roberth Martinez Vargas
     * ****************************************************************
     */
	private void configuracionCampoTexto()throws Exception{
		
		this.castfrmEnvioGiroPostal().getTxtValorGiro().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_DINERO_GIRO.getValor());
		this.castfrmEnvioGiroPostal().getTxtValorGiro().getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.EXP_REG_FORMATO_DINERO_GIRO.getValor());
		this.castfrmEnvioGiroPostal().getTxtTotal().getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.EXP_REG_FORMATO_DINERO_GIRO.getValor());
		this.castfrmEnvioGiroPostal().getTxtValorGiro().getPropiedades().setFormatoSalida(UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO());
	}
	
	/**
     * ****************************************************************
     * @method cargarDatosMsjPredeterminados
     * 		   metodo utilizado para cargar los datos al combo de 
     * 		   mensajes predeterminados
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
     * @author Roberth Martinez Vargas
     * ****************************************************************
     */	
	public void cargarDatosMsjPredeterminados()throws Exception{
		
		List<DatoEntidad> lMensajes;
		
		lMensajes = DatoEntidadVistaLogica.getInstance().consultarDatosPorEntidad(super.getObjUsuario(),
																				  EnumParametrosApp.ENT_ANOTACIONES_GIRO.getObjConstante());
		
		this.castfrmEnvioGiroPostal().getCmbMensajesPredeterminados().getPropiedades().cargarCombo(lMensajes.toArray(), 
												 								   					false, 
												 								   					EnumEtiquetas.LBL_SIN_OBSERVACION);
	}
	
	/**
     * ****************************************************************
     * @method validarValorgiro
     * 		   metodo utilizado para controlar el formato del valor del
     * 		   giro, si el valor del giro cambia, limpia los datos de la
     *         cotizacion, se activa los combox de la agencia destino.
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
     * @author Roberth Martinez Vargas
     * ****************************************************************
     */
	private void validarValorgiro() throws Exception{
		
		this.strValGiro = this.castfrmEnvioGiroPostal().getTxtValorGiro().getText();
		
		if (this.strValGiroAnterior==null) {
			
			this.strValGiroAnterior = this.strValGiro;
			
			if (!this.strValGiro.isEmpty()) {
				
				this.douValorGiro =  UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO().parse(this.castfrmEnvioGiroPostal().getTxtValorGiro().getText()).doubleValue();
			}
			
			if (this.castfrmEnvioGiroPostal().getLstConvenio().getSelectedIndex()<1) {
				this.activarTerritorioDestino(true);
			}
			this.limpiaDatosCambio();
		}else{
			
			if (!this.strValGiroAnterior.equals(this.strValGiro)) {
				
				this.strValGiroAnterior = this.strValGiro;
				if (!this.strValGiro.isEmpty()) {
					
					this.douValorGiro =  UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO().parse(this.castfrmEnvioGiroPostal().getTxtValorGiro().getText()).doubleValue();
				}
				
				if (this.castfrmEnvioGiroPostal().getLstConvenio().getSelectedIndex()<1) {
					
					this.activarTerritorioDestino(true);
				}
				this.limpiaDatosCambio();
			}
		}
	}
	
	/**
     * ****************************************************************
     * @method validaCheckTramitador
     * 		   metodo utilizado para controlar el evento del check de 
     * 	       incluye tramitador
     * @param  pBooSeleccionado
     * 		   estado del check de tramitador
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
     * @author Roberth Martinez Vargas
     * ****************************************************************
     */
	private void validaCheckTramitador(boolean pBooSeleccionado) throws Exception{
		
		limpiaDatosCambio();
		this.castfrmEnvioGiroPostal().getPnlTerceroTra().setVisible(pBooSeleccionado);
		this.aplicaBiometriaPanelTercero(pBooSeleccionado);
		this.validaProcesoTerceroPeps();
		if (pBooSeleccionado) {
			
			this.castfrmEnvioGiroPostal().getPnlTerceroTra().castEvaFrmTercero().restablecer(true);
			this.castfrmEnvioGiroPostal().getPnlTerceroOrg().castEvaFrmTercero().setBooActivaValidacionTerceroPeps(false);
		}else{
			//limpia el tercero tramitador 
			this.setObjTerceroTramitador(null);
			this.limpiarPnlTerceroTramitador();
			this.castfrmEnvioGiroPostal().getPnlTerceroOrg().castEvaFrmTercero().setBooActivaValidacionTerceroPeps(true);
		}
	}
	
	
	/*private void validaProcesoTerceroPeps() throws Exception {
			
		if ( this.castfrmEnvioGiroPostal().getPnlTerceroOrg().castEvaFrmTercero().isBooRealizoProcesoTerceroPeps() ) {
			this.castfrmEnvioGiroPostal().getPnlTerceroTra().castEvaFrmTercero().setBooActivaValidacionTerceroPeps(false);
		}else{
			this.castfrmEnvioGiroPostal().getPnlTerceroTra().castEvaFrmTercero().setBooActivaValidacionTerceroPeps(true);
		}			
	
		if ( this.castfrmEnvioGiroPostal().getPnlTerceroTra().castEvaFrmTercero().isBooRealizoProcesoTerceroPeps() ) {
			this.castfrmEnvioGiroPostal().getPnlTerceroOrg().castEvaFrmTercero().setBooActivaValidacionTerceroPeps(false);
		}else{
			this.castfrmEnvioGiroPostal().getPnlTerceroOrg().castEvaFrmTercero().setBooActivaValidacionTerceroPeps(true);
		}	
	}*/
	private void validaProcesoTerceroPeps() throws Exception {
		
		if ( this.castfrmEnvioGiroPostal().getPnlTerceroOrg().castEvaFrmTercero().isBooRealizoProcesoTerceroPeps() ) {
			this.castfrmEnvioGiroPostal().getPnlTerceroTra().castEvaFrmTercero().setBooActivaValidacionTerceroPeps(false);
		}else{
			this.castfrmEnvioGiroPostal().getPnlTerceroTra().castEvaFrmTercero().setBooActivaValidacionTerceroPeps(true);
		}			
	
		if ( this.castfrmEnvioGiroPostal().getPnlTerceroTra().castEvaFrmTercero().isBooRealizoProcesoTerceroPeps() ) {
			this.castfrmEnvioGiroPostal().getPnlTerceroOrg().castEvaFrmTercero().setBooActivaValidacionTerceroPeps(false);
		}else{
			this.castfrmEnvioGiroPostal().getPnlTerceroOrg().castEvaFrmTercero().setBooActivaValidacionTerceroPeps(true);
		}
		
		if ( this.castfrmEnvioGiroPostal().getChkIncluyeTramitador().isSelected() ) {
			this.castfrmEnvioGiroPostal().getPnlTerceroOrg().castEvaFrmTercero().setBooActivaValidacionTerceroPeps(false);
		}
	}
	
	/**
     * ****************************************************************
     * @method validaCheckDomicilio
     *  	   metodo utilizado para controlar el evento del check de 
     *  	   domicilio
     * @param  pBooSeleccionado
     * 		   estado del check de Domicilio 
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
     * @author Roberth Martinez Vargas
     * ****************************************************************
     */
	private void validaCheckDomicilio(boolean pBooSeleccionado) throws Exception{
		limpiaDatosCambio();
		if (pBooSeleccionado) {
			//activa el check de incluye domicilio
			this.castfrmEnvioGiroPostal().getChkIncluyeDomicilio().setEnabled(true);
		}else{
			//descativa el check de incluye domicilio
			this.castfrmEnvioGiroPostal().getChkIncluyeDomicilio().setEnabled(false);
			this.castfrmEnvioGiroPostal().getChkIncluyeDomicilio().setSelected(false);
		}
	}
	
	/**
     * ****************************************************************
     * @method activarTerritorioDestino
     *  	   metodo utilizado para activar o desactivar el componente 
     *  	   del territorio destino
     * @param  pBooActiva
     * 		   bandera para activar o desactivar el panel agencia 
     *  	   destino
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
     * @author Roberth Martinez Vargas
     * ****************************************************************
     */
	private void activarTerritorioDestino(boolean pBooActiva) throws Exception{
		
		this.castfrmEnvioGiroPostal().getPnlTerritorioAgenciaDestino().habilitarCombo("cmbDeptoDestino", pBooActiva);
		this.castfrmEnvioGiroPostal().getPnlTerritorioAgenciaDestino().habilitarCombo("cmbMunicipioDestino", pBooActiva);
		this.castfrmEnvioGiroPostal().getPnlTerritorioAgenciaDestino().habilitarCombo("cmbAgenciaDestino", pBooActiva);
		
		if (this.douValorGiro!=0) {
			
			this.castfrmEnvioGiroPostal().getPnlTerritorioAgenciaDestino().castEventosForma()
				.setValorGiro((UtilidadGiros.getInstancia().formatearABigDecimal(this.douValorGiro)));
		}
	}
	
	/**
     * ****************************************************************
     * @method aplicaBiometriaPanelTercero
     * 	       metodo ultilizado para activar o desactivar la bandera 
     * 		   al panel tercero para validar biometria
     * @param  pBooAplicaBiometriaPanelTercero
     *    	   bandera para activar biometria al tercero origen o 
     *    	   tramitador
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
     * @author Roberth Martinez Vargas
     * ****************************************************************
     */
	private void aplicaBiometriaPanelTercero(boolean pBooAplicaBiometriaPanelTercero) throws Exception{
		
		Tercero objTerceroOrigen;
		
		this.castfrmEnvioGiroPostal().getPnlTerceroOrg().castEvaFrmTercero().setBooAplicaBiometria(!pBooAplicaBiometriaPanelTercero);
		this.castfrmEnvioGiroPostal().getPnlTerceroTra().castEvaFrmTercero().setBooAplicaBiometria(pBooAplicaBiometriaPanelTercero);
		
		if	(	(	objTerceroOrigen	=	this.castfrmEnvioGiroPostal().getPnlTerceroOrg().castEvaFrmTercero().getObjTercero()	)	!=	null	)
		{
			objTerceroOrigen.getObjBiometria().setObjBooApto(!pBooAplicaBiometriaPanelTercero);
		}
	}
	
	/**
     * ****************************************************************
     * @method consultarConvenios
     * 		   metodo utilizado para consultar los convenio, cargalos 
     *  	   en la lista de convenios
     * @author Roberth Martinez Vargas
     * ****************************************************************
     */
	private void consultarConvenios(){
		
		try {
			this.vecConvenio = TerceroVistaLogica.getInstance().consultarConvenios(super.getObjUsuario());
			this.validaConvenioConBnet();
			if(this.vecConvenio == null || this.vecConvenio.isEmpty()){
				this.arrConv = new String[1];
				this.arrConv [0] = "Sel. Convenio";
			}else{
				this.arrConv = new String[this.vecConvenio.size()+1];
				this.arrConv [0] = "Sel. Convenio";
				for (int i = 0; i < this.vecConvenio.size(); i++) {
					
					this.arrConv[i+1]=this.vecConvenio.get(i).getNombreCorto();
				}
			}
			this.castfrmEnvioGiroPostal().getLstConvenio().setListData(this.arrConv);
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	/**
     * ****************************************************************
     * @method validaConvenioConBnet
     * 		   valida los convenios configurados en gamble, si existe 
     * 		   la equivalencia se carga el convenio, sino existe la 
     * 		   equivalencia, no se carga el convenio
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
     * @author Roberth Martinez Vargas
     * ****************************************************************
     */
	@SuppressWarnings("unchecked")
	private void validaConvenioConBnet()throws Exception{
		
		Vector<Convenio> vecConvenioTmp;
		
		vecConvenioTmp = (Vector<Convenio>)this.vecConvenio.clone();
		
		for(Convenio objConvenio : vecConvenioTmp){
			
			if(objConvenio.isBooRecaudo()){
			
				if(super.getObjUsuario().buscarProveedorServicioProductoXTercero(objConvenio.getTercero(),
																				 EnumTiposServicios.RECAUDO.getStrClave()) == null){
					this.vecConvenio.remove(objConvenio);
				}
			}
		}
	}
	
	/**
     * ****************************************************************
     * @method cotizar
     * 		   metodo utilizado para validar los campos necesarios para 
     * 		   la cotizacion, valida que los terceros cumplan con los 
     * 		   datos
     * @throws Exception
     * 	       Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
     * @author Roberth Martinez Vargas
     * ****************************************************************
     */
	private void cotizar()throws Exception{
		
		if (this.validarDatosTerceros()) {
			
			this.cotizarFactura();
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @method validarDatosTerceros
  	 * 	       valida que los terceros esten diligenciados y cumplan 
  	 * 		   con los datos obligatorios
  	 * @return boolean, bandera para indicar el estado de la validacion
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
  	 * @author Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	private boolean validarDatosTerceros()throws Exception{
		
		boolean booContinua;
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castfrmEnvioGiroPostal().getPnlTerceroOrg().getTxtIdentificacion(), 
																	this.castfrmEnvioGiroPostal().getPnlTerceroOrg().getLblEtiqueta().getTextoOriginal(), 
																	true, 
																	true);
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castfrmEnvioGiroPostal().getPnlTerceroDes().getTxtIdentificacion(), 
																	this.castfrmEnvioGiroPostal().getPnlTerceroDes().getLblEtiqueta().getTextoOriginal(), 
																	true, 
																	true);
		
		if (this.castfrmEnvioGiroPostal().getChkIncluyeTramitador().isSelected()) {
			
			UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castfrmEnvioGiroPostal().getPnlTerceroTra().getTxtIdentificacion(), 
																		this.castfrmEnvioGiroPostal().getPnlTerceroTra().getLblEtiqueta().getTextoOriginal(), 
																		true, 
																		true);
		}
		
		this.objTerceroOrigen = this.castfrmEnvioGiroPostal().getPnlTerceroOrg().castEvaFrmTercero().getObjTercero();
		this.objTerceroDestino = this.castfrmEnvioGiroPostal().getPnlTerceroDes().castEvaFrmTercero().getObjTercero();
		this.objTerceroTramitador = this.castfrmEnvioGiroPostal().getPnlTerceroTra().castEvaFrmTercero().getObjTercero();
		booContinua = false;
		
		if(ValidacionesTercero.getInstance().validacionesXTransaccion(this.objTerceroOrigen, 
		 	 	  													  EnumTiposOperaciones.ENVIO_FACTURACION, 
		 	 	  													  this,
		 	 	  													  this.castfrmEnvioGiroPostal().getPnlTerceroOrg())){
			
			if(ValidacionesTercero.getInstance().validacionesXTransaccion(this.objTerceroDestino, 
																		  EnumTiposOperaciones.ENVIO_FACTURACION, 
						  												  this,
						  												  this.castfrmEnvioGiroPostal().getPnlTerceroDes())){
				
				if (this.castfrmEnvioGiroPostal().getChkIncluyeTramitador().isSelected()) {
					
					if(ValidacionesTercero.getInstance().validacionesXTransaccion(this.objTerceroTramitador, 
																				  EnumTiposOperaciones.ENVIO_FACTURACION, 
							  													  this,
							  													  this.castfrmEnvioGiroPostal().getPnlTerceroTra())){
						
						booContinua = true;
						
					}else{
						
						this.limpiarPnlTerceroTramitador();
					}
				}else{
					booContinua = true;
				}
			}else {
				this.limpiarPnlTerceroDestino();
			}
		}else{
			this.limpiarPnlTerceroOrigen();
		}
		
		return booContinua;
		
	}
	
	/**
     * ****************************************************************
     * @method cotizarFactura
     * 		   metodo utilizado realizar el calculo de conceptos, envia 
     * 		   trama de cotizacion, alimenta el objeto facturagiro
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
     * @author Roberth Martinez Vargas
     * ****************************************************************
     */
	private void cotizarFactura() throws Exception{
		
		boolean booValorTotalValido;
		
		this.limpiaDatosCambio();
		
		if(!this.verificarUltimaTran()){
			return;
		}
		
		this.diligenciarDatosFactura();
		
		this.objFacturaGiro.addConcepto(this.getConceptoGiro());
		//Realizamos el envio de la trama de cotizacion para el giro postal
		GiroVistaLogica.getInstance().calcularConceptosGiro(super.getObjUsuario(),
															this.objFacturaGiro);
		
		this.castfrmEnvioGiroPostal().getTxtCodigoPlan().setText(this.objFacturaGiro.getPlanTarifario().getCodigo());
		this.castfrmEnvioGiroPostal().getTxtDescripcionPlan().setText(this.objFacturaGiro.getPlanTarifario().getDescripcion());
		this.castfrmEnvioGiroPostal().getTxtTotal().setText(UtilidadGiros.getInstancia().formatoPresentacionNumero(this.objFacturaGiro.getTotal()));
		
		booValorTotalValido = this.castfrmEnvioGiroPostal().getTxtTotal().getPropiedades().validaFormatoFinal(false,
				  																							  this.castfrmEnvioGiroPostal().getLblTotal().getTextoOriginal());
		
		if (!booValorTotalValido) {
			this.limpiaDatosCambio();
			this.castfrmEnvioGiroPostal().getTxtValorGiro().requestFocus();
			throw EnumMensajes.VALOR_EXCEDE_LIMITE.generarExcepcion(EnumClasesMensaje.ADVERTENCIA);
		}
		
		this.calcularNumeroItemsFactura(this.objFacturaGiro, 1);
		
		this.adicionarConceptos(this.objFacturaGiro, true);
		
		this.castfrmEnvioGiroPostal().getScpPromociones().getOperaciones().adicionarPromociones(this.objFacturaGiro.getListPromociones());
		
		this.procesoSuperCombo();
	}
	
	/**
     * ****************************************************************
     * @method diligenciarDatosFactura
     * 		   metodo que valida los datos de la factura y los setea al
     * 		   objeto FacturaGiro
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
     * @author Roberth Martinez Vargas
     * ****************************************************************
     */
	private void diligenciarDatosFactura() throws Exception{
		
		Producto producto;
		Documento documento;
		Agencia agenDestino; 
		
		//Validar si los terceros requieren biometria
		ValidacionesTercero.getInstance().validarBiometria(this.castfrmEnvioGiroPostal().getPnlTerceroOrg());
		if(this.castfrmEnvioGiroPostal().getChkIncluyeTramitador().isSelected()){
			ValidacionesTercero.getInstance().validarBiometria(this.castfrmEnvioGiroPostal().getPnlTerceroTra());
		}
		
		agenDestino = this.castfrmEnvioGiroPostal().getPnlTerritorioAgenciaDestino().obtenerAgenciaCombo();
		
		if(!this.castfrmEnvioGiroPostal().getTxtValorGiro().getText().equals("")){
			
			//validamos que el valor del giro cumpla con el formato final
			this.castfrmEnvioGiroPostal().getTxtValorGiro().getPropiedades().validaFormatoFinal(true,
																								this.castfrmEnvioGiroPostal().getLblValorGirar().getTextoOriginal());
			
			if(agenDestino !=null){
				
				producto = this.castfrmEnvioGiroPostal().getPnlEncabezadoFactura().getEvaFrmPnlFactura().getObjProducto();
				documento = this.castfrmEnvioGiroPostal().getPnlEncabezadoFactura().getEvaFrmPnlFactura().getObjDocumento();
				documento.setNaturaleza("+");
				
				this.objFacturaGiro.setAgenciaDestino(agenDestino);
				this.objFacturaGiro.setAgenciaOrigen(super.getObjUsuario().getAgencia());
				this.objFacturaGiro.setDocumento(documento);
				this.objFacturaGiro.setProducto(producto);
				this.objFacturaGiro.setIncluyeFlete(this.castfrmEnvioGiroPostal().getChkIncluyeFlete().isSelected());
				this.objFacturaGiro.setDomicilio(this.castfrmEnvioGiroPostal().getChkDomicilio().isSelected());
				this.objFacturaGiro.setIncluyeOtros(this.castfrmEnvioGiroPostal().getChkIncluyeOtros().isSelected());
				this.objFacturaGiro.setIncluyeDomicilio(this.castfrmEnvioGiroPostal().getChkIncluyeDomicilio().isSelected());
				this.objFacturaGiro.setTerceroOrigen(this.objTerceroOrigen);
				this.objFacturaGiro.setTerceroDestino(this.objTerceroDestino);
				this.objFacturaGiro.setTerceroTramitador(this.objTerceroTramitador);
				
			}else{
				
				throw EnumMensajes.SEL_AGENCIA_DESTINO.generarExcepcion(EnumClasesMensaje.ERROR);
			}
		}else{
			
			throw EnumMensajes.INGRESE_VALOR.generarExcepcion(EnumClasesMensaje.ERROR);
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @method validarAccionContinuar
  	 * 		   Metodo que valida si puede continuar la transaccion, si
  	 *         es un recaudo diligencia datos factura y valida las 
  	 *         propiedades del convenio, si es un giro postal valida se
  	 *         halla realizado previamente la cotizacion, luego valida 
  	 *         que las promosiones hallan sido diligenciadas
  	 * @return boolean, bandera indicando el estado de la validacion
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
  	 * @author Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	private boolean validarAccionContinuar()throws Exception{
		
		boolean booContinuar;
		 
		if (this.objFacturaGiro.getObjConvenio() != null 
				&& this.objFacturaGiro.getObjConvenio().isBooRecaudo()) {
			
			this.validarDatosTerceros();
			this.diligenciarDatosFactura();
			objFacturaGiro.setTotal(UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO().parse(this.castfrmEnvioGiroPostal().getTxtValorGiro().getText()).doubleValue());
			booContinuar = this.validarPropiedadesConvenio();
			
		}else{
			
			if (this.booCambioTercero(this.objTerceroOrigen, 
									  this.castfrmEnvioGiroPostal().getPnlTerceroOrg().castEvaFrmTercero().getObjTercero())) {
				this.limpiaDatosCambio();
			}
			if (this.booCambioTercero(this.objTerceroDestino, 
					  				  this.castfrmEnvioGiroPostal().getPnlTerceroDes().castEvaFrmTercero().getObjTercero())) {
				this.limpiaDatosCambio();
			}
			
			if (this.castfrmEnvioGiroPostal().getChkIncluyeTramitador().isSelected()
					&& this.booCambioTercero(this.objTerceroTramitador, 
			  				  				 this.castfrmEnvioGiroPostal().getPnlTerceroTra().castEvaFrmTercero().getObjTercero())) {
				this.limpiaDatosCambio();
			}
			
			
			if (this.castfrmEnvioGiroPostal().getGrillaConceptos().getRowCount()==0) {
				
				throw EnumMensajes.FAVOR_COTICE.generarExcepcion(EnumClasesMensaje.ERROR);
			}
			
			this.castfrmEnvioGiroPostal().getScpPromociones().getOperaciones().validarPromocionesDiligenciadas(true);
			
			booContinuar = validarMarcacionPeps();
			
		}
		
		objFacturaGiro.setTipoSolicitudDOF("*");
		if(objFacturaGiro.getDeclaraDOF().equals("S") ) {
			FormaDeclaracionOrigenesFondos dof = new FormaDeclaracionOrigenesFondos(super.getFrmForma(), true);
			
			objFacturaGiro.setRespuestaDOF(dof.getTxtRespuesta().getText());
		
			objFacturaGiro.setTipoSolicitudDOF("A");
		}

		else if(objFacturaGiro.getTerceroOrigen().getStrMarcaDOF().equals("S") ||
				(objFacturaGiro.getTerceroTramitador() != null && objFacturaGiro.getTerceroTramitador().getStrMarcaDOF().equals("S"))
				) {
			
			FormaDeclaracionOrigenesFondos dof = new  FormaDeclaracionOrigenesFondos(super.getFrmForma(), true);
			
			objFacturaGiro.setRespuestaDOF(dof.getTxtRespuesta().getText());
			
			objFacturaGiro.setTipoSolicitudDOF("M");
		}
		
		if(objFacturaGiro.getDeclaraDOF().equals("N")) {
			objFacturaGiro.setDeclaraDOF("*");
		}
		
		if(objFacturaGiro.getMarcaDOFO().equals("S")) {
			
			ParametroSistema parametroSistema = null;
			if(objFacturaGiro.getTerceroOrigen().getTipoTercero().equals("9")) {
				parametroSistema = UtilParametrosSistema
						.getInstance()
						.consultar(EnumParametrosSistema.MENSAJE_ALERTA_DECLARACION_NORMATIVA_NATURAL);
			}
			else  {
				parametroSistema = UtilParametrosSistema
						.getInstance()
						.consultar(EnumParametrosSistema.MENSAJE_ALERTA_DECLARACION_NORMATIVA_JURIDICA);
			}
			
			String mensajeAlerta = parametroSistema.getValor();
			
			EnumMensajes
			.desplegarMensajePersonalizado(getFrmForma(),
					EnumClasesMensaje.INFORMACION,
					null,
					"{1}",
					mensajeAlerta);
			
			
			FormaMensajeAlerta frmMensajeAlerta = EnumMensajes
					.desplegarMensajePersonalizado(getFrmForma(),
							EnumClasesMensaje.CONFIRMACION,
							null,
							"Actualmente el tercero Remitente presenta el numero de celular: {1} y el numero telefono: {2}. ¿Desea actualizarlo?",
							objFacturaGiro.getTerceroOrigen().getTelefono2(),
							objFacturaGiro.getTerceroOrigen().getTelefono1());
			
			if(frmMensajeAlerta.isOpcion()) {
				
				FormaPanelConfirmarNormativa frmNormativa = new FormaPanelConfirmarNormativa(getFrmForma(),
						objFacturaGiro.getTerceroOrigen().getTelefono2(),
						objFacturaGiro.getTerceroOrigen().getTelefono1(),
						objFacturaGiro.getTerceroOrigen());
				
			}
		}
		
		/* roberth.martinez
		 * Se realiza el seteo de la variable booValidadoBiometricamente al tercero origen solo cuando en la transaccion
		 * existe el tramitador, esto para poder indentificar al momento del envio de la trama de envio giro postal, 
		 * cual de los dos terceros, origen o tramitador fueron validados biometricamente 
		 **/
		if (objFacturaGiro.getTerceroTramitador() != null) {
			objFacturaGiro.getTerceroOrigen().getObjBiometria().setBooValidadoBiometricamente(false);
		}
		
		return booContinuar;
	}
	
	/**
  	 * ****************************************************************.
  	 * @method validarPropiedadesConvenio
  	 * 		   Metodo que valida si el convenio es recaudo y tiene 
  	 * 	       propiedades, despliega la ventana para diligenciar las 
  	 * 		   propiedades
  	 * @return boolean, bandera indicando el estado de la validacion
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
  	 * @author Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	private boolean validarPropiedadesConvenio()throws Exception{
		
		boolean booContinua = true;
		FormaConvenioPropiedades frmConvenioPropiedades;
		try {
			if (this.objFacturaGiro.getObjConvenio().getLstPropiedades() == null 
					|| this.objFacturaGiro.getObjConvenio().getLstPropiedades().isEmpty()) {
				
				TerceroVistaLogica.getInstance().consultarPropiedadesConvenio(super.getObjUsuario(),
																			  this.objFacturaGiro);
			}
			
		} catch (ClientePosSlimGirosException cpsge) {
			throw cpsge;
		}catch (Exception e) {
			
			throw EnumMensajes.CNV_ERROR_CONSULTA_PROPIEDADES_CONVENIO.generarExcepcion(EnumClasesMensaje.ERROR);
		}
		
		if (this.objFacturaGiro.getObjConvenio().getLstPropiedades() != null 
				&& !this.objFacturaGiro.getObjConvenio().getLstPropiedades().isEmpty()) {
			
			
			frmConvenioPropiedades = new FormaConvenioPropiedades(super.getFrmForma(), 
														          true, 
														          this.objFacturaGiro);
			
			if(frmConvenioPropiedades.getEnmBotEncAccionSolicitada().equals(EnumBotonesEncabezado.BTNGUARDAR)){
				
				booContinua = true;
				
			}else{
				booContinua = false;
			}
		}
		return booContinua;
		
	}
	
	/**
  	 * ****************************************************************.
  	 * @method mostrarMovimientoCaja
  	 * 		   Metodo que invoca la forma de movimiento caja
  	 * @throws Exception
  	 * 	  	   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
  	 * @author Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	private void mostrarMovimientoCaja() throws Exception {

		String strNotas = null;
		
		strNotas = this.castfrmEnvioGiroPostal().getCmbMensajesPredeterminados().getSelectedItem() + " - ";
		this.objFacturaGiro.getObjNota().setStrDescripcion(strNotas);
		
		new FormaMovimientoCaja(this.castfrmEnvioGiroPostal(), 
							    true,
								this.objFacturaGiro,
								this.objFacturaSeguro);

		
	}
	
	/**
  	 * ****************************************************************.
  	 * @method adicionarConceptos
  	 * 		   Metodo que adiciona los conceptos calculados a la grilla
  	 * 		   de conceptos.
  	 * @param  pFactura
  	 * 		   objeto con el detalle de la Factura
  	 * @param  pBoolimpiar
  	 * 	       bandera para limpiar grilla conceptos
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
  	 * @author Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	private void adicionarConceptos(Factura pFactura, boolean pBoolimpiar) throws Exception{
		Iterator<Concepto> iter = pFactura.getListaConceptos().iterator();
		if(pBoolimpiar){
			
			this.castfrmEnvioGiroPostal().getGrillaConceptos().getPropiedades().limpiarGrilla();
		}
		
		Concepto concepto = null;

		while (iter.hasNext()) {
			concepto = iter.next();
			if (concepto.getStrIdAfectaCaja().equals(Concepto.ID_AFECTA_CAJA)) {
				
				this.castfrmEnvioGiroPostal().getGrillaConceptos().getPropiedades().adicionarFilaGrilla(getArrayConcepto(concepto));
				
				if (concepto.getCodigo().equals(EnumParametrosApp.CODIGO_CONCEPTO_ENVIO_GIRO_POSTAL.getObjConstante())) {
					
					this.douValorGiro = concepto.getValor(); // El valor del giro es el retornado en la cotizacion 
					
				}
			}
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @method getArrayConcepto
  	 * 		   Metodo recibe un concepto y lo retorna en forma de array.
  	 * @param  pObjConcepto
  	 * 		   objeto del concepto
  	 * @return Object
  	 * 		   array del concepto
  	 * @author Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	private Object[] getArrayConcepto(Concepto pObjConcepto){
		
		Object objConcepto[] = new Object[]{pObjConcepto.getCodigo(),
										    pObjConcepto.getDescripcion(),
										    pObjConcepto.getValor()};
		
		return objConcepto;
		
	}
	
	/**
  	 * ****************************************************************.
  	 * @method limpiaDatosCambio
  	 * 		   Metodo utilizado para limpiar los datos de la cotizacion
  	 *         cuando algun dato requerido por la cotizacion ha cambiado
  	 * @throws Exception
  	 *   	   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
  	 * @author Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	private void limpiaDatosCambio() throws Exception{
		
		this.castfrmEnvioGiroPostal().getGrillaConceptos().getPropiedades().limpiarGrilla();
		//this.castfrmEnvioGiroPostal().getGrillaPromo().getPropiedades().limpiarGrilla();
		this.castfrmEnvioGiroPostal().getScpPromociones().getOperaciones().limpiarPromociones();
		this.intNumeroItems = 0;
		this.castfrmEnvioGiroPostal().getTxtCodigoPlan().setText("");
		this.castfrmEnvioGiroPostal().getTxtDescripcionPlan().setText("");
		this.castfrmEnvioGiroPostal().getTxtNumeroItems().setText("");
		this.castfrmEnvioGiroPostal().getTxtTotal().setText("");
		this.eliminarSuperCombo(false);
	}
	
	/**
  	 * ****************************************************************.
  	 * @method getConceptoGiro
  	 * 		   Metodo utilizado para crear un concepto de envio de giro
  	 * @return Concepto
  	 *         objeto concepto de giro
  	 * @throws Exception
  	 * 	       Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
  	 * @author Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	private Concepto getConceptoGiro() throws Exception {
		Concepto objConcepto;
		objConcepto = new Concepto();
		objConcepto.setCodigo("2");
		objConcepto.setCantidad(1);
		objConcepto.setDescripcion("");
		objConcepto.setId("2");
		objConcepto.setValor(UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO().parse(this.castfrmEnvioGiroPostal().getTxtValorGiro().getText()).doubleValue());
		return objConcepto;
	}
	
	/**
     * ****************************************************************
     * @method validacionConvenio
     *		   metodo utilizado para realizar las validaciones de los 
     *		   convenios, cuando de selecciona o se quita la seleccion
     *		   del convenio.
     * @throws Exception
     * 	       Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
     * @author Roberth Martinez Vargas
     * ****************************************************************
     */
	private void validacionConvenio() throws Exception {
		
		boolean cargaAgencia;
		
		this.castfrmEnvioGiroPostal().getTxtValorGiro().setEnabled(true);
		this.limpiaDatosCambio();
		
		if (this.castfrmEnvioGiroPostal().getLstConvenio().getSelectedIndex()==0) {
			
			this.limpiarConvenio();
			this.establecerDocumento(EnumProductos.GIRO, EnumDocumentos.FACTURA);
			this.castfrmEnvioGiroPostal().getPnlTerceroOrg().castEvaFrmTercero().setBooConsultaTerceroRecaudo(false);
			this.castfrmEnvioGiroPostal().getPnlTerceroDes().castEvaFrmTercero().setBooConsultaTerceroRecaudo(false);
			
		}else{
			
			this.objFacturaGiro.setObjConvenio(null);
			this.objFacturaGiro.setObjConvenio(this.vecConvenio.get(this.castfrmEnvioGiroPostal().getLstConvenio().getSelectedIndex()-1));
			
			if (this.objFacturaGiro.getObjConvenio().getLstPropiedades() != null) {
				
				this.objFacturaGiro.getObjConvenio().getLstPropiedades().clear();
			}
			
			if (this.objFacturaGiro.getObjConvenio().isBooRecaudo()) {
				
				this.habilitaOpcionesCotizar(false);
				this.establecerDocumento(EnumProductos.RECAUDO, EnumDocumentos.RECAUDO);
				this.castfrmEnvioGiroPostal().getPnlTerceroOrg().castEvaFrmTercero().setBooConsultaTerceroRecaudo(true);
				this.castfrmEnvioGiroPostal().getPnlTerceroDes().castEvaFrmTercero().setBooConsultaTerceroRecaudo(true);
				
			}else{
				
				this.habilitaOpcionesCotizar(true);
				this.establecerDocumento(EnumProductos.GIRO, EnumDocumentos.FACTURA);
				this.castfrmEnvioGiroPostal().getPnlTerceroOrg().castEvaFrmTercero().setBooConsultaTerceroRecaudo(false);
				this.castfrmEnvioGiroPostal().getPnlTerceroDes().castEvaFrmTercero().setBooConsultaTerceroRecaudo(false);
			}
			
			//Muestra los detalles del convenio
			if(this.objFacturaGiro.getObjConvenio().isBooDetalleConvenioPlan()){
				
				this.frmConvenioSedes = new FormaConvenioSedes(this.castfrmEnvioGiroPostal(), 
															   true, 
															   this.objFacturaGiro.getObjConvenio(), 
															   super.getObjUsuario().getAgencia());
				
				if (this.frmConvenioSedes.castEvaFrmConvenioSedes().getSedeSeleccionada()!=null) {
					
					this.objFacturaGiro.getObjConvenio().setObjSedeSeleccionada(this.frmConvenioSedes.castEvaFrmConvenioSedes().getSedeSeleccionada());
					this.setConvenioSede();
					cargaAgencia = true;
					
				}else{
					
					this.restablecerLstConvenio();
					cargaAgencia = false;
				}
				
			}else{
				
				cargaAgencia = true;
				this.castfrmEnvioGiroPostal().getPnlTerceroDes().castEvaFrmTercero().forzarTercero(this.objFacturaGiro.getObjConvenio().getTercero().getTipoIdentificacion(), 
						  																		   this.objFacturaGiro.getObjConvenio().getTercero().getIdentificacion());
			}
			
			if (cargaAgencia) {
				
				this.castfrmEnvioGiroPostal().getPnlTerritorioAgenciaDestino().castEventosForma().definirTerritorioBase(EnumParametrosApp.CODIGO_TIPO_TERRITORIO_MUNICIPIO.getValorEntero(),
																												   	    this.objFacturaGiro.getObjConvenio().getAgencia().getTerritorio().getCodigo());
				
				/**
				 * Para cargar la agencia destino propia del convenio, se tuvo que hacer publico el metodo de cargarComboAgencia() de la funcionalidad utilitaria
				 * de PanelTerritorio, debido a que la intencion inicial de hacerlo a traves de la asignacion de foco, el cual repercute a este mismo metodo
				 * (cargarComboAgencia), no funciono para versiones de java posteriores a 1.6, desconociendo la razon
				 * 
				 * Se intentaron estrategias para evitar hacer ajustes particulares a la funcionalidad transversal de PanelTerritorio, pero no se consiguieron
				 * los resultados esperados:
				 * 
				 * carga "null(###)", sobre el combo 
				 * this.castfrmEnvioGiroPostal().getPnlTerritorioAgenciaDestino().getCmbAgencia().addItem(this.objFacturaGiro.getObjConvenio().getAgencia());
				 */
				
				this.castfrmEnvioGiroPostal().getPnlTerritorioAgenciaDestino().castEventosForma().cargarComboAgencia(this.castfrmEnvioGiroPostal().getPnlTerritorioAgenciaDestino().getCmbAgencia());
				this.castfrmEnvioGiroPostal().getPnlTerritorioAgenciaDestino().getCmbAgencia().setSelectedItem(this.objFacturaGiro.getObjConvenio().getAgencia());
				this.castfrmEnvioGiroPostal().getLstConvenio().requestFocus();
				this.activarTerritorioDestino(false);
				
				this.castfrmEnvioGiroPostal().getPnlTerceroDes().castEvaFrmTercero().habilitarComponenteCompleto(false);
				this.castfrmEnvioGiroPostal().getPnlTerceroDes().castEvaFrmTercero().habilitarItemComponente(this.castfrmEnvioGiroPostal().getPnlTerceroDes().getBtnMantenimiento().getName(), 
																								    	     true);
			}
		}
	}
	
	/**
     * ****************************************************************
     * @method restablecerLstConvenio
     * 		   metodo utilizado para restablecer la lista de convenios
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
     * @author Roberth Martinez Vargas
     * ****************************************************************
     */
	private void restablecerLstConvenio() throws Exception{
		this.castfrmEnvioGiroPostal().getLstConvenio().setSelectedIndex(0);
		this.castfrmEnvioGiroPostal().getScrollConvenios().getVerticalScrollBar().setValue(0);
		this.validacionConvenio();
	}
	
	/**
     * ****************************************************************
     * @method limpiarConvenio
     * 		   metodo utilizado para limpiar la informacion que se 
     * 		   registro al seleccionar un convenio
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
     * @author Roberth Martinez Vargas
     * ****************************************************************
     */
	private void limpiarConvenio() throws Exception{
		
		if (this.objFacturaGiro.getObjConvenio() != null) {
			
			if (this.objFacturaGiro.getObjConvenio().getObjSedeSeleccionada() != null) {
				
				this.castfrmEnvioGiroPostal().getTxtValorGiro().setText("");
			}
			
			this.castfrmEnvioGiroPostal().getPnlTerritorioAgenciaDestino().castEventosForma().reestablecerFormaTerritorios();
			this.objFacturaGiro.setObjConvenio(null);
			activarTerritorioDestino(true);
			limpiarPnlTerceroDestino();
			this.habilitaOpcionesCotizar(true);
		}
	}
	
	/**
     * ****************************************************************
     * @method setConvenioSede
     * 		   metodo utilizado para setiar la informacion del convenio 
     * 		   cuando este tiene sedes asociadas
     * @throws Exception
     * 	       Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
     * @author Roberth Martinez Vargas
     * ****************************************************************
     */
	public void setConvenioSede() throws Exception{
	
		double douValGiro = 0;
		String strValGiro = "";

		//Valida si el valor del giro esta asignado automaticamente
		if (this.objFacturaGiro.getObjConvenio().isBooPrecioAutomatico()) {
			douValGiro = Double.parseDouble(this.objFacturaGiro.getObjConvenio().getObjSedeSeleccionada().getPrecio());
			strValGiro = UtilidadGiros.getInstancia().formatoPresentacionNumero(douValGiro);
			this.castfrmEnvioGiroPostal().getTxtValorGiro().setEnabled(false);
		}
		
		this.castfrmEnvioGiroPostal().getTxtValorGiro().setText(strValGiro);
		this.castfrmEnvioGiroPostal().getTxtTotal().setText(strValGiro);
		this.objFacturaGiro.setTotal(douValGiro);
		
		if (this.castfrmEnvioGiroPostal().getTxtValorGiro().getText().equals("0")) {
			this.castfrmEnvioGiroPostal().getTxtValorGiro().setEnabled(true);
			this.restablecerLstConvenio();
			this.validacionConvenio();
			
			throw EnumMensajes.VAL_GIRO_ERRONEO.generarExcepcion(EnumClasesMensaje.ERROR);
		}
		
		//Si el valor de tercero hijo esta activado toma la identificacion del
		//tercero hijo de lo contrario toma la del papa
		if (this.objFacturaGiro.getObjConvenio().isBooTerceroBeneficiarioHijo()) {
			this.castfrmEnvioGiroPostal().getPnlTerceroDes().castEvaFrmTercero().forzarTercero(this.objFacturaGiro.getObjConvenio().getObjSedeSeleccionada().getTerceroCrc().getTipoIdentificacion(), 
																							   this.objFacturaGiro.getObjConvenio().getObjSedeSeleccionada().getTerceroCrc().getIdentificacion());
		}else{
			this.castfrmEnvioGiroPostal().getPnlTerceroDes().castEvaFrmTercero().forzarTercero(this.objFacturaGiro.getObjConvenio().getObjSedeSeleccionada().getTerceroResponsable().getTipoIdentificacion(), 
																							   this.objFacturaGiro.getObjConvenio().getObjSedeSeleccionada().getTerceroResponsable().getIdentificacion());
		}
	}
	
	/**
     * ****************************************************************
     * @method verificarUltimaTran
     * 		   metodo utilizado para verificar si la ultima transaccion
     * 	       fue exitoso, si hubo error cierra la ventana de envio y
     *         se abre la ventana de Reimprimir ultima facturacion
     * @return boolean, bandera del estado de la validacion
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
     * @author Roberth Martinez Vargas
     * ****************************************************************
     */
	private boolean verificarUltimaTran() throws Exception{
		
		boolean booVerificado = true;
		
		if(EstadoTransaccion.getInstance().compararValorPropiedad(EnumEstadoTransaccion.VERIFICADO, 
																  "true", 
																  "false")){
			
			new FormaReimpresion((JFrame)super.cerrarForma(), 
								 true,
								 EnumReimpresiones.REIMPRIMIR_ULTIMO_ENVIO_GIRO);
			
			booVerificado = false;
		}
		
		return booVerificado;
	}
	
	/**
  	 * ****************************************************************
  	 * @method procesoSuperCombo
  	 * 		   Metodo que ofrece supercombo si el producto esta activo
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
  	 * @author Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	private void procesoSuperCombo() throws Exception{
		String strTelRemitente;
		String strTelDestino;
		boolean booValidacionCotizacionSC;
		
		try{
			this.objFacturaSeguro = null;
			booValidacionCotizacionSC = ValidacionesSuperCombo.getInstance().validarSuperComboCotizacion(this, 
																										 this.objTerceroOrigen, 
																										 this.objTerceroDestino, 
																										 this.douValorGiro,
																										 this.objFacturaGiro);
			
			if (booValidacionCotizacionSC) {
				
				strTelRemitente = this.objFacturaGiro.getTerceroOrigen().getTelefono2();
				strTelDestino = this.objFacturaGiro.getTerceroDestino().getTelefono2();
				FormaSuperComboOrigen objFrmSuperCombo;
				objFrmSuperCombo = new FormaSuperComboOrigen(this.getFrmForma(), 
										  					 true, 
										  					 UtilidadGiros.getInstancia().formatoPresentacionNumero(ValidacionesSuperCombo.getObjSuperCombo().getDouVlrSuperCombo()),
										  					 this.objFacturaGiro);
				
				if(objFrmSuperCombo.getEnmBotEncAccionSolicitada().equals(EnumBotonesEncabezado.BTNGUARDAR)){
					
					this.aceptarSuperCombo(strTelRemitente, strTelDestino);
					
				}else{
					this.eliminarSuperCombo(true);
				}
			}else {
				this.eliminarSuperCombo(true);
			}
		
		}catch(Exception e){
			this.eliminarSuperCombo(true);
			super.controlExcepcion(e);
		}
	}
	
	/**
     * ****************************************************************
     * @method aceptarSuperCombo
     * 		   metodo utilizado para realizar el calculo de conceptos
     * 		   del seguro y SMS, llenar los objetos facturagiroSMS, 
     * 		   facturaSeguro.
     * @param  pStrTelRemitente 
     * 		   telefono remitente
     * @param  pStrTelDestino
     * 		   telefono destino
     * @throws Exception
     *         Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
     * @author Roberth Martinez Vargas
     * ****************************************************************
     */
	private void aceptarSuperCombo(String pStrTelRemitente, String pStrTelDestino) throws Exception{
		boolean booCalcularConceptoSeguro;
		//boolean booCalcularConceptoSMS = false;
		double douVlrTotal;
		
		this.actualizarCelularTerceroSuperCombo(pStrTelRemitente, this.objFacturaGiro.getTerceroOrigen());
		this.actualizarCelularTerceroSuperCombo(pStrTelDestino, this.objFacturaGiro.getTerceroDestino());

		this.objFacturaSeguro = new FacturaSeguro();
		
		ValidacionesSuperCombo.getObjSuperCombo().setBooRealizaSeguro(true);
		//siempre el beneficiario del seguro de vida es el tercero destino
		ValidacionesSuperCombo.getObjSuperCombo().setTerceroBeneficiarioSeguro(this.objFacturaGiro.getTerceroDestino());
		this.objFacturaSeguro.setIdTerceroBene(this.objFacturaGiro.getTerceroDestino().getIdentificacion());
		
		booCalcularConceptoSeguro = ValidacionesSuperCombo.getInstance().cotizarSeguro(this, 
															   					   	   this.douValorGiro, 
															   					   	   ValidacionesSuperCombo.getInstance().obtenerVlrSeguroAccidente(this.douValorGiro), 
															   					   	   this.objFacturaSeguro,
															   					   	   this.objFacturaGiro);
		if (booCalcularConceptoSeguro) {
			
			this.adicionarConceptos(this.objFacturaSeguro, false);
			douVlrTotal = this.objFacturaGiro.getTotal() + this.objFacturaSeguro.getTotal();
			this.castfrmEnvioGiroPostal().getTxtTotal().setText(UtilidadGiros.getInstancia().formatoPresentacionNumero(douVlrTotal));
			this.calcularNumeroItemsFactura(this.objFacturaSeguro, 1);
			this.objFacturaGiro.setIncluyeSeguro(true);
			
			ValidacionesSuperCombo.getInstance().validaTipoSMS(this);
			
			/*booCalcularConceptoSMS = ValidacionesSuperCombo.getInstance().cotizarSMS(this, 
					 				 												 this.objFacturaGiroSMS, 
						 				 											 this.objFacturaGiro);
			
			if (booCalcularConceptoSMS) {
				
				this.adicionarConceptos(this.objFacturaGiroSMS, false);
				douVlrTotal = this.objFacturaGiro.getTotal() + this.objFacturaSeguro.getTotal() + this.objFacturaGiroSMS.getTotal();
				
				this.castfrmEnvioGiroPostal().getTxtTotal().setText(UtilidadGiros.getInstancia().formatoPresentacionNumero(douVlrTotal));
				this.calcularNumeroItemsFactura(this.objFacturaGiroSMS, 1);
				
			}else{
				
				this.calcularNumeroItemsFactura(this.objFacturaSeguro, -1);
				this.eliminarSuperCombo(true);
				this.castfrmEnvioGiroPostal().getGrillaConceptos().getPropiedades().removerFilaGrilla(this.castfrmEnvioGiroPostal().getGrillaConceptos().getRowCount()-1);
			}*/
			
		}else{
			this.eliminarSuperCombo(true);
		}
	}
	
	/**
     * ****************************************************************
     * @metodo  eliminarSuperCombo
     * 			metodo utilizado para quitar el producto supercombo, 
     * 		    limpia variables
     * @param   pBooReinicia
     * 			bandera indicando si reinicia el valor total de la 
     *   		forma
     * @throws  Exception
     * 		    Controla, recupera y escala, cualquier tipo de excepcion
	 *		    presentada
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */
	private void eliminarSuperCombo(boolean pBooReinicia) throws Exception{
		this.objFacturaGiro.setIncluyeSeguro(false);
		this.objFacturaSeguro = null;
		ValidacionesSuperCombo.getInstance().reiniciaSuperCombo();
		if (pBooReinicia) {
			this.castfrmEnvioGiroPostal().getTxtTotal().setText(UtilidadGiros.getInstancia().formatoPresentacionNumero(this.objFacturaGiro.getTotal()));
		}
	}
	
	/**
     * **************************************************************** 
     * @method actualizarCelularTerceroSuperCombo
     * 		   metodo utilizado para actualizar el telefono celular
     * 		   del tercero
     * @param  pStrTelefono
     * 	       telefono original del tercero
     * @param  pTercero
     * 		   objeto tercero a comparar
     * @throws Exception
     *  	   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
     * @author Roberth Martinez Vargas
     * ****************************************************************
     */
	private void actualizarCelularTerceroSuperCombo(String pStrTelefono, Tercero pTercero) throws Exception{
		
		if (!pTercero.getTelefono2().equals(pStrTelefono)) {
			
			EnumMensajes.SPC_ACTUALIZA_CEL_TERCERO.desplegarMensaje(super.getFrmForma(), 
																	EnumClasesMensaje.INFORMACION, 
																	pTercero.getDescripcion());

			TerceroVistaLogica.getInstance().actualizarTercero(super.getObjUsuario(),
															   pTercero);
			
			pTercero.setBooActualizoCelular(true);
		}
	}
	
	/**
     * ****************************************************************
     * @method calcularNumeroItemsFactura
     * 		   metodo utilizado para calcular el numero de items de 
     * 		   la factura
     * @param  pFactura
     * 		   objeto factura
     * @param  pIntValor
     * 		   indica el valor que acumula al numero de items
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
     * @author Roberth Martinez Vargas
     * ****************************************************************
     */
	private void calcularNumeroItemsFactura(Factura pFactura, int pIntValor) throws Exception{
		
		for (int i = 0; i < pFactura.getListaConceptos().size(); i++) {
			Concepto concepto = pFactura.getListaConceptos().get(i);
			if (concepto.getStrIdAfectaCaja().equals(Concepto.ID_AFECTA_CAJA)) {
				this.intNumeroItems += pIntValor;
			}
		}
		this.castfrmEnvioGiroPostal().getTxtNumeroItems().setText(this.intNumeroItems+"");
	}
	
	/** 
	 * ********************************************************************
	 * @method booCambioTercero
	 * 		   Metodo utilizado para validar si los terceros pasados como 
	 * 		   parametros son diferentes
	 * @param  pTerceroLocal
	 * 		   objeto tercero inicial
	 * @param  pTerceroPanel
	 * 		   objeto tercero consultado en el panel
	 * @return boolean
	 * 		   bandera que indica true si los terceros son diferentes
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author roberth.martinez
	 * @date   10/4/2017
	 * *********************************************************************
	 */
	private boolean booCambioTercero(Tercero pTerceroLocal, Tercero pTerceroPanel) throws Exception{
		
		if (pTerceroLocal != pTerceroPanel) {
			return true;
		}else{
			return false;
		}
	}
	
	/**
     * ****************************************************************
     * @method validaCambioTercero
     * 		   metodo utilizado para comparar si el tecero ha cambiado
     * 		   al momento de perder el foco el componente, de ser asi, 
     * 		   limpia los datos de la pantalla para que sea neceseario 
     * 		   cotizar.
     * @param  pTerceroLocal
     *         objeto tercero inicial
     * @param  pTerceroPanel
     * 		   objeto tercero consultado en el panel
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
     * @author Roberth Martinez Vargas
     * ****************************************************************
     */
	private void validaCambioTercero(Tercero pTerceroLocal, Tercero pTerceroPanel) throws Exception{
		
		if (this.booCambioTercero(pTerceroLocal, pTerceroPanel)) {
			this.limpiaDatosCambio();
		}
	}
	
	/**
     * ****************************************************************
     * @method establecerDocumento
     * 		   Establece el documento y producto por el cual se realiza
     * 		   la transaccion
     * @param  pEnmProducto
     * 		   enumerador de producto
     * @param  pEnumDocumento
     * 		   enumerador de documento
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
     * @author Roberth Martinez Vargas
     * ****************************************************************
     */
	private void establecerDocumento(EnumProductos pEnmProducto, EnumDocumentos pEnumDocumento) throws Exception{
		
		try {
			this.castfrmEnvioGiroPostal().getPnlEncabezadoFactura().getEvaFrmPnlFactura().cargarPanel(pEnmProducto, 
					  																				  pEnumDocumento, 
					  																				  null);
		} catch (Exception e) {
			
			this.restablecerLstConvenio();
			throw e;
		}
	}
	
	/**
     * ****************************************************************
     * @method habilitaOpcionesCotizar
     * 		   metodo usado para habilitar las opciones cuando es un 
     * 		   giro o un recaudo
     * @param  booHabilita
     *    	   bandera para indicar si activa o desactiva los 
     *    	   componentes
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
     * @author Roberth Martinez Vargas
     * ****************************************************************
     */
	private void habilitaOpcionesCotizar(boolean booHabilita) throws Exception{
		
		this.castfrmEnvioGiroPostal().getChkIncluyeFlete().setEnabled(booHabilita);
		this.castfrmEnvioGiroPostal().getChkDomicilio().setEnabled(booHabilita);
		this.castfrmEnvioGiroPostal().getChkIncluyeDomicilio().setEnabled(booHabilita);
		this.castfrmEnvioGiroPostal().getChkIncluyeOtros().setEnabled(booHabilita);
		this.castfrmEnvioGiroPostal().getChkIncluyeTramitador().setEnabled(booHabilita);
		
		this.castfrmEnvioGiroPostal().getChkIncluyeFlete().setSelected(false);
		this.castfrmEnvioGiroPostal().getChkDomicilio().setSelected(false);
		this.castfrmEnvioGiroPostal().getChkIncluyeDomicilio().setSelected(false);
		this.castfrmEnvioGiroPostal().getChkIncluyeOtros().setSelected(false);
		this.castfrmEnvioGiroPostal().getChkIncluyeTramitador().setSelected(false);
		
		this.castfrmEnvioGiroPostal().getBtnCotizar().setEnabled(booHabilita);

	}
	
	/**
     * **************************************************************** 
     * @method limpiarPnlTerceroDestino
     * 		   metodo utilizado para el panel tercero destino
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
     * @author Roberth Martinez Vargas
     * ****************************************************************
     */
	private void limpiarPnlTerceroDestino() throws Exception {
		this.castfrmEnvioGiroPostal().getPnlTerceroDes().castEvaFrmTercero().restablecer(true);
	}
	
	/**
     * **************************************************************** 
     * @method limpiarPnlTerceroOrigen
     *         metodo utilizado para el panel tercero destino
     * @throws Exception
     *     	   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
     * @author Roberth Martinez Vargas
     * ****************************************************************
     */
	private void limpiarPnlTerceroOrigen() throws Exception {
		this.castfrmEnvioGiroPostal().getPnlTerceroOrg().castEvaFrmTercero().restablecer(true);
	}
	
	/**
     * ****************************************************************
     * @method limpiarPnlTerceroTramitador
     *         metodo utilizado para el panel tercero tramitador
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
     * @author Roberth Martinez Vargas
     * ****************************************************************
     */
	private void limpiarPnlTerceroTramitador() throws Exception {
		this.castfrmEnvioGiroPostal().getPnlTerceroTra().castEvaFrmTercero().restablecer(true);
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	validarMarcacionPeps
	 * 		  	metodo encargado de validar si se realizo la validacion de 
	 * 			Tercero Peps para los terceros involucrados en la transacicon
	 * @return
	 * 			Booleano indicando si se realizo o no la validacion.
	 * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author	stiven.garcia
	 * @date	2/05/2018
	 * *********************************************************************
	 */
	private boolean validarMarcacionPeps() throws Exception {
		
		return UtilTerceroPeps.getInstancia().validarContinuarProceso(this.getObjUsuario(), 
																	  this.castfrmEnvioGiroPostal().getPnlTerceroOrg(), 
																	  this.castfrmEnvioGiroPostal().getPnlTerceroTra(), 
																	  this.castfrmEnvioGiroPostal());
		
	}
	
	/**
  	 * ****************************************************************.
  	 * @method castcastfrmEnvioGiroPostal()
  	 * 		   Metodo estandar para formatear el tipo de dato general 
  	 * 		   a un tipo especifico ("Casteo"), del atributo
  	 * 		   super.getFrmForma()
  	 * @return FormaEnvioFacturacion 
  	 * 		   valor especifico recuperado
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de 
  	 * 		   excepcion presentada
  	 * @autor  Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public FormaEnvioFacturacion castfrmEnvioGiroPostal()throws Exception{
		return (FormaEnvioFacturacion)super.getFrmForma();
	}

	/**
	 * @method getObjTerceroTramitador
	 * 		   Metodo get del atributo objTerceroTramitador
	 * @return Tercero
	 *		   Valor del atributo objTerceroTramitador devuelto
	 * @author roberth.martinez
	 * @date   17/3/2016
	 */
	public Tercero getObjTerceroTramitador() {
		return this.objTerceroTramitador;
	}

	/**
	 * @method setObjTerceroTramitador
	 * 		   Metodo set del atributo objTerceroTramitador
	 * @param  pObjTerceroTramitador
	 *		   Valor que tomara el atributo objTerceroTramitador
	 * @author roberth.martinez
	 * @date   17/3/2016
	 */
	public void setObjTerceroTramitador(Tercero pObjTerceroTramitador) {
		this.objTerceroTramitador = pObjTerceroTramitador;
	}

}

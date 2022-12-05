package co.com.codesa.clienteposslimgiros.eventos.documentacion;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.WindowEvent;
import java.util.List;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMediosPago;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.documentacion.FormaConfirmarDocumentosRecibidos;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.mensajes.FormaMensajeAlerta;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.vista.logica.caja.CajaVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Concepto;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DocPendiente;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.MedioPago;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

public class EventoFormaConfirmarDocumentosRecibidos extends EventoAbstracto{

	private DocPendiente objDocumentoPendiente;

	public EventoFormaConfirmarDocumentosRecibidos(FormaGenerica pForma,
										  DocPendiente pObjDocumentoPendiente){
		
		super(pForma);
		this.objDocumentoPendiente = pObjDocumentoPendiente;
	}

	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma)throws Exception{

		this.cargarFormulario();
		this.configuracionCampos();
		this.accionarCambioItemConcepto();
	}
	
	@Override
	public void accionarVentanaDesplegada(WindowEvent pEvtWindowOpened) throws Exception {
		
		this.castFrmConfirmarDocumentosRecibidos().getCmbListaConceptos().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmConfirmarDocumentosRecibidos().getCmbListaMediosPago().getLblObligatorio().aplicarObligatoriedad(true);		
	}
	
	@Override
	public void accionarCambioItem(Component pComponent, 
								   ItemEvent pEvtItemStateChanged) throws Exception {
		
		if(pComponent.equals(this.castFrmConfirmarDocumentosRecibidos().getCmbListaConceptos())){
			
			this.accionarCambioItemConcepto();
			
		}else{
			
			super.accionarCambioItem(pComponent, 
									 pEvtItemStateChanged);
		}
	}

	@Override
	public void confirmar() throws Exception {
		
		this.ejecutarOperacion(true);//aceptarDocumento
	}
	
	@Override
	public void cancelar() throws Exception {
		
		this.ejecutarOperacion(false);//rechazarDocumento
	}
	
	private void accionarCambioItemConcepto()throws Exception{
		
		String strConceptoSeleccionado;
		
		strConceptoSeleccionado = this.castFrmConfirmarDocumentosRecibidos().getCmbListaConceptos().getSelectedItem().toString();
		
		if(strConceptoSeleccionado.contains("RECHAZO") 
				|| strConceptoSeleccionado.equals(EnumEtiquetas.LBL_NO_SELECCIONADO.toString())){
			
			this.castFrmConfirmarDocumentosRecibidos().getPnlNotaAdicional().setVisible(false);
			
		}else{
			
			this.castFrmConfirmarDocumentosRecibidos().getPnlNotaAdicional().setVisible(true);
		}
	}
	
	private void ejecutarOperacion(boolean pBooTipoOperacion)throws Exception{
		
		this.validarDatosIngresados();
		
		if(pBooTipoOperacion){
		
			this.aceptarDocumento();
			
		}else{
		
			this.rechazarDocumento();
		}
	}

	private void cargarFormulario()throws Exception{
		
		this.cargarInformacionDestino();
	}
	
	private void cargarInformacionDestino()throws Exception{
	
		this.cargarConceptos();
		this.cargarMediosPago();
		
		this.castFrmConfirmarDocumentosRecibidos().getTxtReferencia().setText(this.objDocumentoPendiente.getRefControl());
		this.castFrmConfirmarDocumentosRecibidos().getTxtValor().setText(UtilidadGiros.getInstancia().formatoPresentacionDinero(this.objDocumentoPendiente.getDValue()));
		
		if (!this.objDocumentoPendiente.getNotas().equals("*")){
			
			this.castFrmConfirmarDocumentosRecibidos().getTxaNotas().setText(this.objDocumentoPendiente.getNotas());
		}
	}
	
	private void cargarConceptos()throws Exception{
		
		List<Concepto> lstConceptos;
		
		CajaVistaLogica.getInstance().consultaConceptosMovCaja(super.getObjUsuario(),
															   EnumParametrosApp.CONCEPTO_NATURALEZA_INGRESO.getValorEntero(), 
															   EnumParametrosApp.COMPROBANTE_PROVISION.getValorEntero());

		lstConceptos = super.getObjUsuario().getEmpresa().getLstConceptosIngresos();

		this.castFrmConfirmarDocumentosRecibidos().getCmbListaConceptos().getPropiedades().cargarCombo(lstConceptos.toArray(), 
																								   true, 
																								   null);
	}
	
	private void cargarMediosPago()throws Exception{
		
		/**
		 * Se ajusta los medios de pago para solo permitir Efectivo, 
		 * ya que la operacion relacionada con provisionamiento solo
		 * debe soportar este medio de pago
		 * 04/01/2016
		 */
		//List<MedioPago> lstMedioPago;
		
		//lstMedioPago= super.getObjUsuarioAutenticado().getMediosPago();
		this.castFrmConfirmarDocumentosRecibidos().getCmbListaMediosPago().getPropiedades().cargarCombo(new Object[]{EnumMediosPago.EFECTIVO.getObjMedioPago()}, 
																							  			true, 
																							  			null);
	}
	
	private void configuracionCampos()throws Exception{
		
		this.castFrmConfirmarDocumentosRecibidos().getTxaNotaAdicional().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_NOTAS.getValor());
	}
	
	private void validarDatosIngresados()throws Exception{
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmConfirmarDocumentosRecibidos().getCmbListaConceptos(), 
																	this.castFrmConfirmarDocumentosRecibidos().getLblConcepto().getTextoOriginal(), 
																	true, 
																	true);
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmConfirmarDocumentosRecibidos().getCmbListaMediosPago(), 
																	this.castFrmConfirmarDocumentosRecibidos().getLblMedioPago().getTextoOriginal(), 
																	true, 
																	true);
	}
	
	private void aceptarDocumento() throws Exception {
		
		FormaMensajeAlerta frmMsgAlerta;
		String strNotas;
		
		frmMsgAlerta = EnumMensajes.CONFIRMAR_ACEPTAR_DOCUMENTO.desplegarMensaje(super.getFrmForma(), 
 		  																		 EnumClasesMensaje.CONFIRMACION, 
 		  																		 this.castFrmConfirmarDocumentosRecibidos().getCmbListaConceptos().getSelectedItem().toString());
		if(frmMsgAlerta.isOpcion()){
		
			strNotas = this.objDocumentoPendiente.getNotas();
			
			if(!this.castFrmConfirmarDocumentosRecibidos().getTxaNotaAdicional().getText().trim().isEmpty()){
				
				strNotas += " - "+this.castFrmConfirmarDocumentosRecibidos().getTxaNotaAdicional().getText();
			}
			
			CajaVistaLogica.getInstance().aceptarDesembolso(super.getObjUsuario(),this.objDocumentoPendiente.getRefControl(), 
															strNotas, 
															(Concepto) this.castFrmConfirmarDocumentosRecibidos().getCmbListaConceptos().getSelectedItem(),
															(MedioPago) this.castFrmConfirmarDocumentosRecibidos().getCmbListaMediosPago().getSelectedItem(),  
															Integer.parseInt(EnumParametrosApp.ACEPTAR_DESEMBOLO.getObjConstante()),
															EnumParametrosApp.COMPROBANTE_PROVISION.getValorEntero(), 
															"1");
				
			EnumMensajes.DOCUMENTO_ACEPTADO.desplegarMensaje(super.getFrmForma(), 
															 EnumClasesMensaje.INFORMACION);
			super.regresarFormaPadre();
		}
	}

	private void rechazarDocumento() throws Exception {
		
		FormaMensajeAlerta frmMsgAlerta;
		
		frmMsgAlerta = EnumMensajes.CONFIRMAR_RECHAZAR_DOCUMENTO.desplegarMensaje(super.getFrmForma(), 
																 		    	  EnumClasesMensaje.CONFIRMACION, 
																 		    	  this.castFrmConfirmarDocumentosRecibidos().getCmbListaConceptos().getSelectedItem().toString());
		if(frmMsgAlerta.isOpcion()){
			
			CajaVistaLogica.getInstance().aceptarDesembolso(super.getObjUsuario(),
															this.objDocumentoPendiente.getRefControl(), 
															this.objDocumentoPendiente.getNotas(), 
															(Concepto) this.castFrmConfirmarDocumentosRecibidos().getCmbListaConceptos().getSelectedItem(),
															(MedioPago) this.castFrmConfirmarDocumentosRecibidos().getCmbListaMediosPago().getSelectedItem(),  
															Integer.parseInt(EnumParametrosApp.RECHAZAR_DESEMBOLO.getObjConstante()),
															EnumParametrosApp.COMPROBANTE_PROVISION.getValorEntero(), 
															"1");
			
			EnumMensajes.DOCUMENTO_RECHAZADO.desplegarMensaje(super.getFrmForma(), 
															  EnumClasesMensaje.INFORMACION);
			super.regresarFormaPadre();
		}		
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo castFrmConfirmarDocumentosRecibidos
  	 * 		   Metodo estandar para formatear el tipo de dato general a 
  	 * 		   un tipo especifico ("Casteo"), del atributo padre frmForma
  	 * @return FormaGiroAceptaProvisiones
  	 * 		   valor especifico recuperado
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaConfirmarDocumentosRecibidos castFrmConfirmarDocumentosRecibidos()throws Exception{
		return (FormaConfirmarDocumentosRecibidos)super.getFrmForma();
	}
}

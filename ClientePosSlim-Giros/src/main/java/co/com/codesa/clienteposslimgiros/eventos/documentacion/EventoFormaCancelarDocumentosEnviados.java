package co.com.codesa.clienteposslimgiros.eventos.documentacion;

import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMediosPago;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.documentacion.FormaCancelarDocumentosEnviados;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.mensajes.FormaMensajeAlerta;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.vista.logica.DatoEntidadVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.caja.CajaVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Concepto;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DatoEntidad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DocPendiente;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.MedioPago;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

public class EventoFormaCancelarDocumentosEnviados extends EventoAbstracto{

	private DocPendiente objDocumentoPendiente;

	public EventoFormaCancelarDocumentosEnviados(FormaGenerica pForma,
										   DocPendiente pObjDocumentoPendiente){
		super(pForma);		
		this.objDocumentoPendiente = pObjDocumentoPendiente;
	}

	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma)throws Exception{

		this.cargarFormulario();
	}
	
	@Override
	public void accionarVentanaDesplegada(WindowEvent pEvtWindowOpened) throws Exception {
	
		this.castFrmCancelarDocumentosEnviados().getCmbListaConceptos().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmCancelarDocumentosEnviados().getCmbListaMediosPago().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmCancelarDocumentosEnviados().getCmbListaRazon().getLblObligatorio().aplicarObligatoriedad(true);
	}

	@Override
	public void confirmar() throws Exception {
		
		this.validarDatosIngresados();
		this.rechazarProvision();
	}
	
	private void validarDatosIngresados()throws Exception{
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmCancelarDocumentosEnviados().getCmbListaConceptos(), 
																	this.castFrmCancelarDocumentosEnviados().getLblConcepto().getTextoOriginal(), 
																	true, 
																	true);
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmCancelarDocumentosEnviados().getCmbListaMediosPago(), 
																	this.castFrmCancelarDocumentosEnviados().getLblMedioPago().getTextoOriginal(), 
																	true, 
																	true);
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmCancelarDocumentosEnviados().getCmbListaRazon(), 
																	this.castFrmCancelarDocumentosEnviados().getLblRazon().getTextoOriginal(), 
																	true, 
																	true);
	}

	private void cargarFormulario()throws Exception{
		
		this.cargarInformacionOrigen();
		this.cargarInformacionDestino();
	}
	
	private void cargarInformacionDestino()throws Exception{
		
		this.castFrmCancelarDocumentosEnviados().getTxtCodigoAgenciaDestino().setText(this.objDocumentoPendiente.getCodAgcDest());
		this.castFrmCancelarDocumentosEnviados().getTxtDescripcionAgenciaDestino().setText(this.objDocumentoPendiente.getDescAgcDestino());
		this.castFrmCancelarDocumentosEnviados().getTxtCodigoCajaDestino().setText(String.valueOf(this.objDocumentoPendiente.getIdCajaDest()));
		this.castFrmCancelarDocumentosEnviados().getTxtDescripcionCajaDestino().setText(this.objDocumentoPendiente.getDescCajaDest());
	}
	
	private void cargarInformacionOrigen()throws Exception{
		
		this.cargarConceptos();
		this.cargarRazon();
		this.cargarMediosPago();
		
		this.castFrmCancelarDocumentosEnviados().getTxtReferencia().setText(this.objDocumentoPendiente.getRefControl());
		this.castFrmCancelarDocumentosEnviados().getTxtValor().setText(UtilidadGiros.getInstancia().formatoPresentacionDinero(this.objDocumentoPendiente.getDValue()));
		
		if (!this.objDocumentoPendiente.getNotas().equals("*")){
			
			this.castFrmCancelarDocumentosEnviados().getTxaNotas().setText(this.objDocumentoPendiente.getNotas());
		}
	}
	
	private void cargarConceptos()throws Exception{
		
		List<Concepto> lstConceptos;
		List<Concepto> lstConceptosRechazo;
		
		if (this.objDocumentoPendiente.getTipoDoc() == EnumParametrosApp.COMPROBANTE_DESEMBOLSO.getValorEntero()){
			
			CajaVistaLogica.getInstance().consultaConceptosMovCaja(super.getObjUsuario(),
																   EnumParametrosApp.CONCEPTO_NATURALEZA_INGRESO.getValorEntero(), 
																   this.objDocumentoPendiente.getDocumId());

		}else if (this.objDocumentoPendiente.getTipoDoc() == EnumParametrosApp.COMPROBANTE_PROVISION.getValorEntero()){
			
			CajaVistaLogica.getInstance().consultaConceptosMovCaja(super.getObjUsuario(),
																   EnumParametrosApp.CONCEPTO_NATURALEZA_INGRESO.getValorEntero(), 
																   EnumParametrosApp.COMPROBANTE_PROVISION.getValorEntero());
		}
		
		lstConceptos = super.getObjUsuario().getEmpresa().getLstConceptosIngresos();
		
		lstConceptosRechazo = new ArrayList<Concepto>();
		
		for(Concepto objConcepto : lstConceptos){
			
			if(objConcepto.getDescripcion().contains("RECHAZO")){
			
				lstConceptosRechazo.add(objConcepto);
			}
		}
		
		this.castFrmCancelarDocumentosEnviados().getCmbListaConceptos().getPropiedades().cargarCombo(lstConceptosRechazo.toArray(), 
																							 true, 
																							 null);
	}
	
	private void cargarRazon()throws Exception{
		
		List<DatoEntidad> lstRazon;
		
		lstRazon = DatoEntidadVistaLogica.getInstance().consultarDatosPorEntidad(super.getObjUsuario(),
				 																 "30");//[TODO: pasar codigo a constante enumerador de aplicacion]

		this.castFrmCancelarDocumentosEnviados().getCmbListaRazon().getPropiedades().cargarCombo(lstRazon.toArray(), 
						 																 true, 
						 																 null);
	}
	
	private void cargarMediosPago()throws Exception{
		
		/**
		 * Se ajusta los medios de pago para solo permitir Efectivo, 
		 * ya que la operacion relacionada con provisionamiento solo
		 * debe soportar este medio de pago
		 * 30/12/2015
		 */
		//List<MedioPago> lstMedioPago;
		
		//lstMedioPago= super.getObjUsuarioAutenticado().getMediosPago();
		this.castFrmCancelarDocumentosEnviados().getCmbListaMediosPago().getPropiedades().cargarCombo(new Object[]{EnumMediosPago.EFECTIVO.getObjMedioPago()}, 
																							  true, 
																							  null);
	}
	
	private void rechazarProvision() throws Exception {

		FormaMensajeAlerta frmMsgAlerta;
		String strNotas;

		frmMsgAlerta = EnumMensajes.CONFIRMAR_RECHAZAR_DOCUMENTO.desplegarMensaje(super.getFrmForma(), 
																 		  		EnumClasesMensaje.CONFIRMACION, 
																 		  		this.castFrmCancelarDocumentosEnviados().getCmbListaConceptos().getSelectedItem().toString());
		if(frmMsgAlerta.isOpcion()){
			
			strNotas = this.objDocumentoPendiente.getNotas() + " - "
							+ this.castFrmCancelarDocumentosEnviados().getCmbListaRazon().getSelectedItem();

			CajaVistaLogica.getInstance().aceptarDesembolso(super.getObjUsuario(),
															this.objDocumentoPendiente.getRefControl(), 
															strNotas, 
															(Concepto) this.castFrmCancelarDocumentosEnviados().getCmbListaConceptos().getSelectedItem(),
															(MedioPago) this.castFrmCancelarDocumentosEnviados().getCmbListaMediosPago().getSelectedItem(),  
															Integer.parseInt(EnumParametrosApp.RECHAZAR_DESEMBOLO.getObjConstante()),
															this.objDocumentoPendiente.getTipoDoc(), 
															"2");//[TODO: pasar codigo a constante enumerador de aplicacion]

			EnumMensajes.DOCUMENTO_RECHAZADO.desplegarMensaje(super.getFrmForma(), 
															  EnumClasesMensaje.INFORMACION);
			super.regresarFormaPadre();
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo castFrmCancelarDocumentosEnviados
  	 * 		   Metodo estandar para formatear el tipo de dato general a 
  	 * 		   un tipo especifico ("Casteo"), del atributo padre frmForma
  	 * @return FormaCancelarDocumentosEnviados
  	 * 		   valor especifico recuperado
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaCancelarDocumentosEnviados castFrmCancelarDocumentosEnviados()throws Exception{
		return (FormaCancelarDocumentosEnviados)super.getFrmForma();
	}
}

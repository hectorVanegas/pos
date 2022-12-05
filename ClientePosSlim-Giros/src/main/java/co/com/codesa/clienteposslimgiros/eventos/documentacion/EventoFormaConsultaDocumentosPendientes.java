package co.com.codesa.clienteposslimgiros.eventos.documentacion;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.WindowEvent;
import java.util.HashMap;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.GrillaUtil;
import co.com.codesa.clienteposslimgiros.formas.documentacion.FormaConfirmarDocumentosRecibidos;
import co.com.codesa.clienteposslimgiros.formas.documentacion.FormaConsultaDocumentosPendientes;
import co.com.codesa.clienteposslimgiros.formas.documentacion.FormaCancelarDocumentosEnviados;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.vista.logica.DocumentosPendientesVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DocPendiente;

public class EventoFormaConsultaDocumentosPendientes extends EventoAbstracto {

	private HashMap<String, DocPendiente> hmDocumentosPendientes;
	private EnumEtiquetas enmTipoOperacion;

	public EventoFormaConsultaDocumentosPendientes(FormaGenerica pForma) {
		
		super(pForma);
	}

	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma) throws Exception {
		
		this.cargarFormulario();
		this.accionarCambioItemTipoOperacion();
	}
	
	@Override
	public void accionarVentanaDesplegada(WindowEvent pEvtWindowOpened) throws Exception {
		
		this.castFrmConsultaDocumentosPendientes().getCmbTipoOperacion().getLblObligatorio().aplicarObligatoriedad(true);
	}
	
	@Override
	public void accionarCambioItem(Component pComponent, 
								   ItemEvent pEvtItemStateChanged) throws Exception {
		
		if(pComponent.equals(this.castFrmConsultaDocumentosPendientes().getCmbTipoOperacion())){
			
			this.accionarCambioItemTipoOperacion();
			
		}else{
			
			super.accionarCambioItem(pComponent, 
									 pEvtItemStateChanged);
		}
	}
	
	@Override
	public void confirmar() throws Exception {
		
		GrillaUtil tblConsulta;
		DocPendiente objDocumentoPendiente;
		Object objValor;
		int intFilaSeleccionada;
		int intColumna;
		
		tblConsulta = this.castFrmConsultaDocumentosPendientes().getTblConsulta();
		
		if(tblConsulta.getRowCount()>0){
		
			if(!tblConsulta.getSelectionModel().isSelectionEmpty()){
				
				intColumna = 0;
				intFilaSeleccionada = tblConsulta.getSelectedRow();

				objValor = tblConsulta.getValueAt(intFilaSeleccionada, 
												  intColumna);
				
				objDocumentoPendiente = this.hmDocumentosPendientes.get(objValor.toString());

				switch (this.enmTipoOperacion) {
				
					case LBL_CDP_CONFIRMAR_PROVISION_RECIBIDA:
						
						this.desplegarConfirmaDocumentosRecibidos(objDocumentoPendiente);
						break;
		
					case LBL_CDP_RECHAZAR_PROVISION_ENVIADA:
						
						this.desplegarCancelarDocumentosEnviados(objDocumentoPendiente);
						break;
						
					default:
						break;
				}
				
			}else{
				
				throw EnumMensajes.DEBE_SELECCIONAR_REGISTRO_PARA_OPERACION.generarExcepcion(EnumClasesMensaje.ERROR);
			}
			
		}else{
			
			throw EnumMensajes.SE_NECESITAN_REGISTROS_EN_TABLA.generarExcepcion(EnumClasesMensaje.ERROR);
		}
	}
	
	@Override
	public void consultar() throws Exception {
		
		this.consultarDocumentosPendientes();
	}
	
	private void cargarFormulario()throws Exception{
		
		this.castFrmConsultaDocumentosPendientes().getCmbTipoOperacion().getPropiedades().cargarCombo(new Object[]{EnumEtiquetas.LBL_CDP_CONFIRMAR_PROVISION_RECIBIDA,
																												   EnumEtiquetas.LBL_CDP_RECHAZAR_PROVISION_ENVIADA}, 
																									  true, 
																									  null);
	}
	
	private void accionarCambioItemTipoOperacion()throws Exception{
		
		this.detectarTipoOperacionSeleccionada();
		this.castFrmConsultaDocumentosPendientes().getTblConsulta().getPropiedades().limpiarGrilla();
	}
	
	private void detectarTipoOperacionSeleccionada()throws Exception{
	
		Object objTipoOperacionSeleccionada;
		
		objTipoOperacionSeleccionada = this.castFrmConsultaDocumentosPendientes().getCmbTipoOperacion().getSelectedItem();
		
		if (objTipoOperacionSeleccionada.equals(EnumEtiquetas.LBL_CDP_CONFIRMAR_PROVISION_RECIBIDA)) {
			
			this.enmTipoOperacion = EnumEtiquetas.LBL_CDP_CONFIRMAR_PROVISION_RECIBIDA;
			
		}else if(objTipoOperacionSeleccionada.equals(EnumEtiquetas.LBL_CDP_RECHAZAR_PROVISION_ENVIADA)) {
			
			this.enmTipoOperacion = EnumEtiquetas.LBL_CDP_RECHAZAR_PROVISION_ENVIADA;
			
		}else{
			
			this.enmTipoOperacion = null;
		}
	}
	
	private Object[][] obtenerTablaDocumento(HashMap<String, DocPendiente> pHmDocumentosPendientes) {
		
		Object[][] mtrObjResultado;
		int intContadorFila;
		int intCantFilas;
		String data;
		
		intCantFilas = pHmDocumentosPendientes==null?0:pHmDocumentosPendientes.size();
		
		mtrObjResultado = new Object[intCantFilas][4];
		intContadorFila = 0;

		if(pHmDocumentosPendientes != null){
		
			for(DocPendiente objDocumentoPendiente : pHmDocumentosPendientes.values()){
				
				mtrObjResultado[intContadorFila][0] = objDocumentoPendiente.getRefControl();

				switch (this.enmTipoOperacion) {
				
					case LBL_CDP_CONFIRMAR_PROVISION_RECIBIDA:
						
						mtrObjResultado[intContadorFila][1] = objDocumentoPendiente.getDescAgcOrigen();
						
						if (objDocumentoPendiente.getDescConcepto().contains("DESEMBOLSO")) {
							
							data = objDocumentoPendiente.getDescConcepto().substring(objDocumentoPendiente.getDescConcepto().indexOf("DESEMBOLSO"),
																		 objDocumentoPendiente.getDescConcepto().length());
						} else {
							
							data = (objDocumentoPendiente.getTipoDoc() == 0 ? "DESEMBOLSO": "PROVISION");
						}
						
						break;
		
					case LBL_CDP_RECHAZAR_PROVISION_ENVIADA:
						
						mtrObjResultado[intContadorFila][1] = objDocumentoPendiente.getDescAgcDestino();
						data = objDocumentoPendiente.getDescConcepto();
						break;
						
					default:
						
						data = null;
						break;
				}
				
				mtrObjResultado[intContadorFila][2] = objDocumentoPendiente.getDValue();
				mtrObjResultado[intContadorFila][3] = data;
				intContadorFila++;
			}
		}
		
		return mtrObjResultado;
	}

	private void desplegarConfirmaDocumentosRecibidos(DocPendiente pObjDocumentoPendiente) throws Exception {
		
		FormaConfirmarDocumentosRecibidos frmConfirmarDocumentosRecibidos;
		String tipoDoc = String.valueOf(pObjDocumentoPendiente.getTipoDoc());
		
		if (tipoDoc.equals(EnumParametrosApp.ACEPTACION_PROVISION.getObjConstante())) {
			
			frmConfirmarDocumentosRecibidos = new FormaConfirmarDocumentosRecibidos(this.castFrmConsultaDocumentosPendientes(), 
																  true, 
																  pObjDocumentoPendiente);
			
			if(frmConfirmarDocumentosRecibidos.getEnmBotEncAccionSolicitada().equals(EnumBotonesEncabezado.BTNGUARDAR)){
			
				this.castFrmConsultaDocumentosPendientes().getTblConsulta().getPropiedades().limpiarGrilla();
			}
		}
	}
	
	private void desplegarCancelarDocumentosEnviados(DocPendiente pObjDocumentoPendiente) throws Exception {
		
		FormaCancelarDocumentosEnviados frmCancelarDocumentosEnviados;
		
		frmCancelarDocumentosEnviados = new FormaCancelarDocumentosEnviados(this.castFrmConsultaDocumentosPendientes(), 
																	true, 
																	pObjDocumentoPendiente);
		
		if(frmCancelarDocumentosEnviados.getEnmBotEncAccionSolicitada().equals(EnumBotonesEncabezado.BTNGUARDAR)){
		
			this.castFrmConsultaDocumentosPendientes().getTblConsulta().getPropiedades().limpiarGrilla();
		}
	}
	
	public void consultarDocumentosPendientes()throws Exception{
		
		GrillaUtil tblConsulta;
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmConsultaDocumentosPendientes().getCmbTipoOperacion(), 
																	this.castFrmConsultaDocumentosPendientes().getLblTipoOperacion().getText(), 
																	true, 
																	true);
		
		tblConsulta = this.castFrmConsultaDocumentosPendientes().getTblConsulta();

		tblConsulta.getPropiedades().limpiarGrilla();
		
		switch (this.enmTipoOperacion) {
		
			case LBL_CDP_RECHAZAR_PROVISION_ENVIADA:
				
				tblConsulta.getColumnModel().getColumn(1).setHeaderValue(EnumEtiquetas.TTL_CDP_GRILLA_AGENCIA_DESTINO.toString());
				
				this.hmDocumentosPendientes = DocumentosPendientesVistaLogica.getInstance().consultarDocumentosPendientesOrigen(super.getObjUsuario(), 
																													 2);
				break;
	
			case LBL_CDP_CONFIRMAR_PROVISION_RECIBIDA:
				
				tblConsulta.getColumnModel().getColumn(1).setHeaderValue(EnumEtiquetas.TTL_CDP_GRILLA_AGENCIA_ORIGEN.toString());
				
				this.hmDocumentosPendientes = DocumentosPendientesVistaLogica.getInstance().consultarDocumentosPendientes(super.getObjUsuario(), 
																											   1);
				break;
				
			default:
				this.hmDocumentosPendientes = null;
				break;
		}
		
		this.castFrmConsultaDocumentosPendientes().getTblConsulta().getPropiedades().adicionarFilasGrilla(this.obtenerTablaDocumento(this.hmDocumentosPendientes));
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo castFrmConsultaDocumentosPendientes
  	 * 		   Metodo estandar para formatear el tipo de dato general a 
  	 * 		   un tipo especifico ("Casteo"), del atributo padre frmForma
  	 * @return FormaGiroConsultaDocuPend
  	 * 		   valor especifico recuperado
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaConsultaDocumentosPendientes castFrmConsultaDocumentosPendientes()throws Exception{
		return (FormaConsultaDocumentosPendientes)super.getFrmForma();
	}
}

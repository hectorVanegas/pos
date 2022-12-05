package co.com.codesa.clienteposslimgiros.eventos.caja;

import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.List;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMediosPago;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.caja.FormaProvisionCaja;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.mensajes.FormaMensajeAlerta;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.vista.logica.AgenciaVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.caja.CajaVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Agencia;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Caja;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Concepto;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.MedioPago;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Territorio;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

/**
 * ****************************************************************.
 * @autor: Roberth Martinez Vargas
 * @fecha: 17-abril-2015
 * @descripcion: Clase que representa los eventos de forma consulta 
 * 				 desembolsos provisiones
 * @copyright: Copyright  1998-2012 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class EventoFormaProvisionCaja extends EventoAbstracto{
	
	private Number numValoregreso;
	private Agencia agenciaDestino;
	private Caja cajaDestino;
	private Concepto conceptoEgreso;
	private MedioPago medioPago;
	private Object objMunicipio;
	private Object objAgencia;
	
	public EventoFormaProvisionCaja(FormaGenerica pForma) {
		super(pForma);
	}
	
	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma) throws Exception{
		
		this.cargarFormulario();
		this.configuracionCampos();
	}
	
	@Override
	public void accionarVentanaDesplegada(WindowEvent pEvtWindowOpened) throws Exception {
		
		this.castfrmProvisionCaja().getCmbConceptoEgreso().getLblObligatorio().aplicarObligatoriedad(true);
		this.castfrmProvisionCaja().getTxtValorEgreso().getLblObligatorio().aplicarObligatoriedad(true);
		this.castfrmProvisionCaja().getCmbMedioPago().getLblObligatorio().aplicarObligatoriedad(true);
		this.castfrmProvisionCaja().getCmbAgenciaDestino().getLblObligatorio().aplicarObligatoriedad(true);
		this.castfrmProvisionCaja().getCmbCajaDestino().getLblObligatorio().aplicarObligatoriedad(true);
		this.castfrmProvisionCaja().getPnlTerritorioAgenciaDestino().getCmbDepartamento().getLblObligatorio().aplicarObligatoriedad(true);
		this.castfrmProvisionCaja().getPnlTerritorioAgenciaDestino().getCmbMunicipio().getLblObligatorio().aplicarObligatoriedad(true);
		
	}
	
	@Override
	public void accionarCambioItem(Component pComponent, 
								   ItemEvent pEvtItemStateChanged) throws Exception {
		
		if (pComponent.equals(this.castfrmProvisionCaja().getPnlTerritorioAgenciaDestino().getCmbDepartamento())
				|| pComponent.equals(this.castfrmProvisionCaja().getPnlTerritorioAgenciaDestino().getCmbMunicipio())) {
			
			this.limpiaAgenciaDestino();
			this.limpiaCajaDestino();
			
		}else if (pComponent.equals(this.castfrmProvisionCaja().getCmbAgenciaDestino())) {
			
			this.limpiaCajaDestino();
		
		}else{
			
			super.accionarCambioItem(pComponent, 
									 pEvtItemStateChanged);
		}
	}
	
	@Override
	public void accionarFocoAdquirido(Component pComponent, 
									  FocusEvent pEvtFocusGained) throws Exception {
		
		if (pComponent.equals(this.castfrmProvisionCaja().getCmbAgenciaDestino())) {
			
			this.cargarAgenciaDestino();
		
		}else if (pComponent.equals(this.castfrmProvisionCaja().getCmbCajaDestino())) {
		
			this.cargarCajaDestino();
			
		}else{
			
			super.accionarFocoAdquirido(pComponent, 
										pEvtFocusGained);
		}
	}
	
	@Override
	public void accionarIngresoLiberado(Component pComponent, 
								  	    KeyEvent pEvtKeyReleased)throws Exception{
		
		if(pComponent.equals(this.castfrmProvisionCaja().getTxtValorEgreso())){
			
			this.castfrmProvisionCaja().getTxtValorIngreso().setText(this.castfrmProvisionCaja().getTxtValorEgreso().getText());
			
		}else if (pComponent.equals(this.castfrmProvisionCaja().getTxaNotasEgreso())) {
			
			this.castfrmProvisionCaja().getTxaNotasIngreso().setText(this.castfrmProvisionCaja().getTxaNotasEgreso().getText());
			
		}else{
			
			super.accionarIngresoLiberado(pComponent, 
										  pEvtKeyReleased);
		}
	}
	
	@Override
	public void confirmar()throws Exception{
		
		FormaMensajeAlerta objFrmMsjAlerta;
		
		this.validaDatos();//Validamos los datos obligatorios
		
		//Mostrar mensaje de confirmacion de la transaccion
		objFrmMsjAlerta = EnumMensajes.CONFIRMA_REALIZA_PROVISION.desplegarMensaje(super.getFrmForma(), 
																 				   EnumClasesMensaje.CONFIRMACION, 
																 				   this.conceptoEgreso.getDescripcion());
		if (objFrmMsjAlerta.isOpcion()) {
			CajaVistaLogica.getInstance().provisionCaja(super.getObjUsuario(),
														this.conceptoEgreso, 
														this.agenciaDestino, 
														this.cajaDestino, 
														this.numValoregreso, 
														this.medioPago, 
														this.castfrmProvisionCaja().getTxtDocumentoAuxiliar().getText(), 
														this.castfrmProvisionCaja().getTxaNotasEgreso().getText(), 
														"4", 
														"S", 
														"1");
			
			EnumMensajes.TRANSACCION_EXITOSA_PROVISION.desplegarMensaje(super.getFrmForma(), 
																		EnumClasesMensaje.INFORMACION);
			
			this.cerrarForma();
		}
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  llenarInformacionFormulario
     * 			metodo utilizado para inicializar los datos de la forma 
     * 			provision caja
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */
	private void cargarFormulario()throws Exception{
		
		this.castfrmProvisionCaja().getPnlTerritorioAgenciaOrigen().castEventosForma().definirTerritorioBase(super.getObjUsuario().getAgencia().getTerritorio());
		
		this.castfrmProvisionCaja().getPnlTerritorioAgenciaDestino().castEventosForma().definirTerritorioBase(super.getObjUsuario().getAgencia().getTerritorio());
		
		this.castfrmProvisionCaja().getCmbAgenciaDestino().getPropiedades().cargarCombo(null, 
																						true, 
																						EnumEtiquetas.LBL_NO_SELECCIONADO);
		
		this.castfrmProvisionCaja().getCmbCajaDestino().getPropiedades().cargarCombo(null, 
																					 true, 
																					 EnumEtiquetas.LBL_NO_SELECCIONADO);
		
		CajaVistaLogica.getInstance().consultaConceptosMovCaja(super.getObjUsuario(),
															   EnumParametrosApp.CONCEPTO_NATURALEZA_EGRESO.getValorEntero(), 
															   EnumParametrosApp.COMPROBANTE_PROVISION.getValorEntero());
		
		CajaVistaLogica.getInstance().consultaConceptosMovCaja(super.getObjUsuario(),
															   EnumParametrosApp.CONCEPTO_NATURALEZA_INGRESO.getValorEntero(), 
				   											   EnumParametrosApp.COMPROBANTE_PROVISION.getValorEntero());
		
		this.cargarConceptosEgreso();
		this.cargarConceptosIngreso();
		this.cargarMedioPago();
		
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo configuracionCampos
  	 * 		   encargado de gestionar la configuracion personalizada
  	 * 		   para los campos del formulario
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void configuracionCampos()throws Exception{
		this.configuracionCamposTexto();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo configuracionCamposTexto
  	 * 		   encargado de gestionar la configuracion personalizada
  	 * 		   para los diferentes campos de texto del formulario
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void configuracionCamposTexto()throws Exception{
		
		this.castfrmProvisionCaja().getTxtDocumentoAuxiliar().getPropiedades().setActivaMayusculaMinuscula(true);
		this.castfrmProvisionCaja().getTxtDocumentoAuxiliar().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.CODIGO_APROBACION_TARJETAS_INGRESO.getValor());
		this.castfrmProvisionCaja().getTxtDocumentoAuxiliar().getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.CODIGO_APROBACION_TARJETAS_FINAL.getValor());
		
		this.castfrmProvisionCaja().getTxtValorEgreso().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.FORMATO_DINERO_SIN_CERO.getValor());
		this.castfrmProvisionCaja().getTxtValorEgreso().getPropiedades().setFormatoSalida(UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO());
		this.castfrmProvisionCaja().getTxtValorEgreso().getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.FORMATO_DINERO_SIN_CERO.getValor());
		
		this.castfrmProvisionCaja().getTxaNotasEgreso().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_NOTAS.getValor());
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  cargarConceptosEgreso
     * 			metodo utilizado para cargar los datos al combo de 
     * 			conceptos egresos
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */	
	public void cargarConceptosEgreso()throws Exception{
		List<Concepto> lstConceptos;
		lstConceptos = super.getObjUsuario().getEmpresa().getLstConceptosEgresos();
		
		this.castfrmProvisionCaja().getCmbConceptoEgreso().getPropiedades().cargarCombo(lstConceptos.toArray(), 
												 										true, 
												 										EnumEtiquetas.LBL_NO_SELECCIONADO);
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  cargarConceptosEgreso
     * 			metodo utilizado para cargar los datos al combo de 
     * 			conceptos egresos
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */	
	public void cargarConceptosIngreso()throws Exception{
		List<Concepto> lstConceptos;
		lstConceptos = super.getObjUsuario().getEmpresa().getLstConceptosIngresos();
		
		this.castfrmProvisionCaja().getCmbConceptoIngreso().getPropiedades().cargarCombo(lstConceptos.toArray(), 
												 										 true, 
												 										 null);
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  cargarMedioPago
     * 			metodo utilizado para cargar los datos al combo de 
     * 			medios de pago
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */	
	public void cargarMedioPago()throws Exception{
		
		/**
		 * Roberth Martinez Vargas
		 * Se ajusta los medios de pago para solo permitir Efectivo, 
		 * ya que la operacion solo soporta este
		 * 21/10/2015
		 */
		//List<MedioPago> lstMediosPago = this.usuarioAutenticado.getMediosPago();
		
		this.castfrmProvisionCaja().getCmbMedioPago().getPropiedades().cargarCombo(new Object[]{EnumMediosPago.EFECTIVO.getObjMedioPago()},//lstMediosPago
												 								   true, 
												 								   null);
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  cargarAgenciaDestino
     * 			metodo utilizado para cargar los datos al combo de 
     * 			agencia destino, estos datos son cargados al enviar la 
     * 			trama 100, para las agencias disponibles para provisiones
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */	
	public void cargarAgenciaDestino()throws Exception{
		
		Object objMunicipio;
		Territorio municipio;
		List<Agencia> lstAgencias;
		Object arrAgencias[];
		Object objValorInicial;
		
		objMunicipio = this.castfrmProvisionCaja().getPnlTerritorioAgenciaDestino().getCmbMunicipio().getSelectedItem();
		
		if (this.objMunicipio == null 
				|| this.objMunicipio != objMunicipio) {
			
			this.objMunicipio = objMunicipio;
			this.objAgencia = null;
			
			if (objMunicipio instanceof Territorio) {
				
				municipio = (Territorio) objMunicipio;
				
				lstAgencias = null;
				
				try{				
					
					lstAgencias = AgenciaVistaLogica.getInstance().consultarAgenciasPrivisiones(super.getObjUsuario(),
																								municipio, 
																								false, 
																								"0", 
																								super.getObjUsuario().getCaja().getCodigo());
				}catch(Exception e){
					
					throw e;
					
				}finally{
					
					arrAgencias = lstAgencias == null ? null : lstAgencias.toArray();
					
					objValorInicial = (arrAgencias == null 
											|| arrAgencias.length == 0)?EnumEtiquetas.LBL_NO_SELECCIONADO:null;
					
					this.castfrmProvisionCaja().getCmbAgenciaDestino().getPropiedades().cargarCombo(arrAgencias, 
															 										true, 
															 										objValorInicial);
				}
			}
		}
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  cargarCajaDestino
     * 			metodo utilizado para cargar los datos al combo de caja
     * 			destino, estos datos son cargados al enviar la trama 23,
     * 			para las caja disponibles para provisiones
     * @autor   Roberth Martinez Vargas 
     * ****************************************************************
     */	
	public void cargarCajaDestino()throws Exception{
		
		Object objAgencia;
		Agencia agenciaDest;
		List<Caja> lstCajas;
		
		objAgencia = this.castfrmProvisionCaja().getCmbAgenciaDestino().getSelectedItem();
		
		if (this.objAgencia == null 
				|| this.objAgencia != objAgencia) {
			
			//this.limpiaCajaDestino();
			this.objAgencia = objAgencia;
			
			if (objAgencia instanceof Agencia) {
				
				agenciaDest = (Agencia) objAgencia;
				
				lstCajas = CajaVistaLogica.getInstance().consultaCajasProvisiones(super.getObjUsuario(),
																				  agenciaDest);
				
				this.castfrmProvisionCaja().getCmbCajaDestino().getPropiedades().cargarCombo(lstCajas.toArray(), 
														 									 true, 
														 									 null);
			}
		}
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  limpiaAgenciaDestino
     * 			metodo utilizado para limpiar los datos del combo agencia
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */
	private void limpiaAgenciaDestino()throws Exception{
		
		this.castfrmProvisionCaja().getCmbAgenciaDestino().getPropiedades().removerListaCombo(true);
		this.objMunicipio = null;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  limpiaCajaDestino
     * 			metodo utilizado para limpiar los datos del combo caja
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */
	private void limpiaCajaDestino()throws Exception{
		
		this.castfrmProvisionCaja().getCmbCajaDestino().getPropiedades().removerListaCombo(true);
		this.objAgencia = null;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  validaDatos
     * 			metodo utilizado para realizar la validacion de los 
     * 			datos enviados en la provision
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */
	private void validaDatos()throws Exception{		
		
		//Validamos campos obligatorios
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castfrmProvisionCaja().getCmbConceptoEgreso(), 
																	EnumEtiquetas.LBL_PVC_CONCEPTO_EGRESO.toString()+" - "+EnumEtiquetas.LBL_PVC_AGENCIA_ORG.toString(), 
																	true, 
																	true);
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castfrmProvisionCaja().getTxtValorEgreso(), 
																	EnumEtiquetas.LBL_PVC_VALOR_EGRESO.toString()+" - "+EnumEtiquetas.LBL_PVC_AGENCIA_ORG.toString(), 
																	true, 
																	true);
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castfrmProvisionCaja().getCmbMedioPago(), 
																	EnumEtiquetas.LBL_PVC_MEDIO_PAGO.toString()+" - "+EnumEtiquetas.LBL_PVC_AGENCIA_ORG.toString(), 
																	true, 
																	true);
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castfrmProvisionCaja().getCmbAgenciaDestino(), 
																	EnumEtiquetas.LBL_PVC_AGENCIA_DESTINO.toString()+" - "+EnumEtiquetas.LBL_PVC_AGENCIA_DES.toString(), 
																	true, 
																	false);//No se redirige foco debido a que esto provoca una consulta de agencias automaticamente
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castfrmProvisionCaja().getCmbCajaDestino(), 
																	EnumEtiquetas.LBL_PVC_CAJA_DESTINO.toString()+" - "+EnumEtiquetas.LBL_PVC_AGENCIA_DES.toString(), 
																	true, 
																	false);//No se redirige foco debido a que esto provoca una consulta de cajas automaticamente
		
		//validamos que el valor del giro cumpla con el formato final
		this.castfrmProvisionCaja().getTxtValorEgreso().getPropiedades().validaFormatoFinal(true,
																							this.castfrmProvisionCaja().getLblValorEgreso().getTextoOriginal());
		
		this.agenciaDestino = (Agencia)this.castfrmProvisionCaja().getCmbAgenciaDestino().getSelectedItem();
		this.cajaDestino = (Caja)this.castfrmProvisionCaja().getCmbCajaDestino().getSelectedItem();
		
		//Validar que la caja destino este abierta
		CajaVistaLogica.getInstance().validaCaja(super.getObjUsuario(),
												 this.agenciaDestino, 
												 this.cajaDestino);
		
		this.conceptoEgreso = (Concepto) this.castfrmProvisionCaja().getCmbConceptoEgreso().getSelectedItem();
		this.medioPago = (MedioPago) this.castfrmProvisionCaja().getCmbMedioPago().getSelectedItem();
		this.numValoregreso = UtilidadesGiros.getInstance().getValorFormato(this.castfrmProvisionCaja().getTxtValorEgreso().getText());
	}
	
	
	/**
  	 * ****************************************************************.
  	 * @throws  Exception
  	 * @metodo  castfrmProvisionCaja
  	 * 			Metodo estandar para formatear el tipo de dato general 
  	 * 			a un tipo especifico ("Casteo"), del atributo 
  	 * 			super.getFrmForma()
  	 * @return  FormaProvisionCaja, valor especifico recuperado
  	 * @autor   Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public FormaProvisionCaja castfrmProvisionCaja()throws Exception{
		return (FormaProvisionCaja)super.getFrmForma();
	}
}

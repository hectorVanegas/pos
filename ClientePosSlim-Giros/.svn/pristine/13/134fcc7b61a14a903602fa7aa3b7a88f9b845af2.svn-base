package co.com.codesa.clienteposslimgiros.eventos.caja;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumImpresiones;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.caja.FormaGiroIngresoEgreso;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.mensajes.FormaMensajeAlerta;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGiros;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.clienteposslimgiros.vista.logica.caja.CajaVistaLogica;
import co.com.codesa.codesawrapper.modelo.dominio.ParametroSistema;
import co.com.codesa.codesawrapper.utilidades.Utilidades;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Concepto;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Factura;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.MedioPago;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Nota;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.IngresoEgreso;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;


public class EventoFormaGiroIngresoEgreso extends EventoAbstracto {

	private MedioPago objMedioPago;
	private IngresoEgreso ingresoEgreso;
	private String operacion;

	public EventoFormaGiroIngresoEgreso(FormaGenerica pForma) throws Exception{
		
		super(pForma);
	}
	
	@Override
	public void iniciarValores(Object... pArrObjParametrosForma) throws Exception {
		
		this.configuracionCampoTexto();
		this.castfrmGiroIngresoEgreso().getRbtIngreso().setSelected(true);
		this.castfrmGiroIngresoEgreso().getCmbMedioPago().getPropiedades().cargarCombo(super.getObjUsuario().getMediosPago().toArray(), 
																					   true, 
																					   null);
	}
	
	@Override
	public void accionarVentanaDesplegada(WindowEvent pEvtWindowOpened) throws Exception {
		
		this.castfrmGiroIngresoEgreso().getPnlTercero().castEvaFrmTercero().aplicarObligatoriedad(true);
		this.castfrmGiroIngresoEgreso().getCmbConcepto().getLblObligatorio().aplicarObligatoriedad(true);
		this.castfrmGiroIngresoEgreso().getCmbMedioPago().getLblObligatorio().aplicarObligatoriedad(true);
		this.castfrmGiroIngresoEgreso().getTxtValor().getLblObligatorio().aplicarObligatoriedad(true);
		this.castfrmGiroIngresoEgreso().getTxtDocumentoAuxiliar().getLblObligatorio().aplicarObligatoriedad(true);
		this.castfrmGiroIngresoEgreso().getTxaNotas().getLblObligatorio().aplicarObligatoriedad(true);
	}
	
	@Override
	public void accionarCambioItem(Component pComponent, 
								   ItemEvent pEvtItemStateChanged)throws Exception{
		
		if (pComponent.equals(this.castfrmGiroIngresoEgreso().getCmbMedioPago())) {

			this.seleccionarMedioPago();
			
		}else if (pComponent.equals(this.castfrmGiroIngresoEgreso().getRbtEgreso())
				  	&& this.castfrmGiroIngresoEgreso().getRbtEgreso().isSelected()) {
			
			this.cargarConceptos(super.getObjUsuario().getEmpresa().getLstConceptosEgresos(),
								 EnumParametrosApp.CONCEPTO_NATURALEZA_EGRESO.getValorEntero());
			this.operacion="Egreso";

		}else if (pComponent.equals(this.castfrmGiroIngresoEgreso().getRbtIngreso())
					&& this.castfrmGiroIngresoEgreso().getRbtIngreso().isSelected()) {
			
			this.cargarConceptos(super.getObjUsuario().getEmpresa().getLstConceptosIngresos(),
					 			 EnumParametrosApp.CONCEPTO_NATURALEZA_INGRESO.getValorEntero());
			this.operacion="Ingreso";

		}else{
			
			super.accionarCambioItem(pComponent, 
					   				 pEvtItemStateChanged);
		}
	}
	
	@Override
	public void confirmar() throws Exception {
		
		this.realizarOperacion();
	}
	
	@Override
	public	void	limpiar	()	
			throws Exception 
	{
		super.limpiar();
		
		//this.castfrmGiroIngresoEgreso().getTxtDocumentoAuxiliar().setText(null);
		//this.castfrmGiroIngresoEgreso().getTxaNotas().setText(null);
		//this.castfrmGiroIngresoEgreso().getTxtValor().setText(null);
		
		//this.castfrmGiroIngresoEgreso().getCmbConcepto().setSelectedItem(EnumEtiquetas.LBL_NO_SELECCIONADO);
		//this.castfrmGiroIngresoEgreso().getCmbMedioPago().setSelectedItem(EnumEtiquetas.LBL_NO_SELECCIONADO);
		this.castfrmGiroIngresoEgreso().getPnlTercero().castEvaFrmTercero().restablecer(null);
	}
	
	/**
     * ****************************************************************
     * @metodo  configuracionCampoTexto
     *			metodo utilizado para los campos de texto el formato de 
     *			ingreso, salida, final
     * @throws  Exception
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */
	private void configuracionCampoTexto()throws Exception{
		
		this.castfrmGiroIngresoEgreso().getTxtValor().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.FORMATO_DINERO_SIN_CERO_IED.getValor());
		this.castfrmGiroIngresoEgreso().getTxtValor().getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.FORMATO_DINERO_SIN_CERO_IED.getValor());
		this.castfrmGiroIngresoEgreso().getTxtValor().getPropiedades().setFormatoSalida(UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO());
	}
	
	private void cargarConceptos(List<Concepto> pLstConceptos,
								 int pIntTipoOperacion)throws Exception{
		
		Object arrConceptos[];
		
		if(pLstConceptos == null
				|| pLstConceptos.isEmpty()){
			
			pLstConceptos = this.consultaConceptos(pIntTipoOperacion);
		}
		
		if(pLstConceptos == null
				|| pLstConceptos.isEmpty()){
			
			arrConceptos = null;
			
		}else{
		
			arrConceptos = pLstConceptos.toArray();
		}
		
		this.castfrmGiroIngresoEgreso().getCmbConcepto().getPropiedades().cargarCombo(arrConceptos, 
																					  true, 
																					  null);
	}
	
	private void seleccionarMedioPago()throws Exception{
		
		if(!this.castfrmGiroIngresoEgreso().getCmbMedioPago().getSelectedItem().equals(EnumEtiquetas.LBL_NO_SELECCIONADO)){

			this.objMedioPago = (MedioPago) this.castfrmGiroIngresoEgreso().getCmbMedioPago().getSelectedItem();
			
			if (this.objMedioPago.getDatenIdTipo().trim().equals("13")) {
				
				this.castfrmGiroIngresoEgreso().getTxtDocumentoAuxiliar().setEnabled(false);
				this.castfrmGiroIngresoEgreso().getTxtDocumentoAuxiliar().setText("*");
				
			} else{
				
				this.castfrmGiroIngresoEgreso().getTxtDocumentoAuxiliar().setEnabled(true);
				this.castfrmGiroIngresoEgreso().getTxtDocumentoAuxiliar().setText("");
			}
			
		}else{
			
			this.castfrmGiroIngresoEgreso().getTxtDocumentoAuxiliar().setEnabled(false);
		}
	}

	private void validarOperacion()throws Exception{
	
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castfrmGiroIngresoEgreso().getPnlTercero().getTxtIdentificacion(), 
																	this.castfrmGiroIngresoEgreso().getPnlTercero().getLblEtiqueta().getTextoOriginal(), 
																	true, 
																	true);

		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castfrmGiroIngresoEgreso().getCmbConcepto(),
																	this.castfrmGiroIngresoEgreso().getLblConcepto().getTextoOriginal(),
																	true,
																	true);
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castfrmGiroIngresoEgreso().getTxtValor(),
																	this.castfrmGiroIngresoEgreso().getLblValor().getTextoOriginal(),
																	true,
																	true);
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castfrmGiroIngresoEgreso().getCmbMedioPago(),
																	this.castfrmGiroIngresoEgreso().getLblMedioPago().getTextoOriginal(),
																	true,
																	true);
		
		if(this.castfrmGiroIngresoEgreso().getTxtDocumentoAuxiliar().isEnabled() 
				&& this.castfrmGiroIngresoEgreso().getTxtDocumentoAuxiliar().isEditable()){
		
			UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castfrmGiroIngresoEgreso().getTxtDocumentoAuxiliar(),
																		this.castfrmGiroIngresoEgreso().getLblDocumentoAuxiliar().getTextoOriginal(),
																		true,
																		true);
		}
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castfrmGiroIngresoEgreso().getTxaNotas(),
																	this.castfrmGiroIngresoEgreso().getLblNotas().getTextoOriginal(),
																	true,
																	true);
		
		//validamos que el valor del giro cumpla con el formato final
		this.castfrmGiroIngresoEgreso().getTxtValor().getPropiedades().validaFormatoFinal(true,
																						  this.castfrmGiroIngresoEgreso().getLblValor().getTextoOriginal());
	}
	
	private void realizarOperacion() throws Exception {
		
		List<Concepto> lstConceptos;
		Concepto objConcepto;
		MedioPago objMedioPago;
		Tercero objTercero;
		NumberFormat frtFormato;
		String strDocAuxiliar;
		String strNotas;
		Factura objFactura;
		Nota objNota;
		ParametroSistema psPASI;
		String strIdentColaborador;
		boolean booImprime = true;
		
		this.validarOperacion();
		
		strDocAuxiliar = this.castfrmGiroIngresoEgreso().getTxtDocumentoAuxiliar().getText();
		strNotas = this.castfrmGiroIngresoEgreso().getTxaNotas().getText();
		objTercero = this.castfrmGiroIngresoEgreso().getPnlTercero().castEvaFrmTercero().getObjTercero();
		objMedioPago = (MedioPago) this.castfrmGiroIngresoEgreso().getCmbMedioPago().getSelectedItem();
		objConcepto = (Concepto) this.castfrmGiroIngresoEgreso().getCmbConcepto().getSelectedItem();

		frtFormato = UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO();
		objConcepto.setValor(frtFormato.parse(this.castfrmGiroIngresoEgreso().getTxtValor().getText()).doubleValue());
		
		objFactura = new Factura();
		objNota = new Nota(strNotas);
		
		objFactura.setTerceroOrigen(objTercero);
		objFactura.gestionarListConceptos().add(objConcepto);
		objFactura.gestionarListMediosPago().add(objMedioPago);
		objFactura.setObjNota(objNota);
		objFactura.setDocAux(strDocAuxiliar);
		objFactura.setTotal(objConcepto.getValor());
		
		psPASI = UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.IDENTIFICACIONES_COLABORADORES_RESTRINGIDOS_INGRESOS);
		
		validarParametroSistemaIDREOPIE(psPASI.getValor());
		
		this.ingresoEgreso=CajaVistaLogica.getInstance().ingresoEgreso(super.getObjUsuario(),
																  	   objFactura,
																  	   this.operacion);

		EnumMensajes.EXITO_INGRESO_EGRESO.desplegarMensaje(super.getFrmForma(), 
														   EnumClasesMensaje.INFORMACION,
														   this.operacion);
		
		
		strIdentColaborador = InformacionSessionGiros.getInstance().getObjUsuario().getEmpresa().getRcNit();
		psPASI = UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.IDENTIFICACIONES_COLABORADORES_RESTRINGIDOS_INGRESOS);
		booImprime = validarColaboradoresImpresion(psPASI.getValor(), strIdentColaborador);
		
		this.limpiar();

		lstConceptos = new ArrayList<Concepto>();
		lstConceptos.add(objConcepto);

		if (this.ingresoEgreso != null) {

			this.ingresoEgreso.setTercero(objTercero);
			this.ingresoEgreso.setNotas(strNotas);
			this.ingresoEgreso.setDocAux(strDocAuxiliar);
			this.ingresoEgreso.setTipo(this.operacion);
			this.ingresoEgreso.setListConceptos(lstConceptos);

			if (booImprime) {
				this.generarImpresionOperacion(this.operacion);
			}
		}
	}
	
	private void validarParametroSistemaIDREOPIE(String strpIDREOPIE) throws Exception{
		
		if (strpIDREOPIE != null) {
			
			if (strpIDREOPIE.contains(EnumGeneralidadesTramasGiros.PUNTO_Y_COMA.getValor())) {
				
				StringTokenizer stk_pStrIDREOPIE = new StringTokenizer(strpIDREOPIE, ";");
				
				while (stk_pStrIDREOPIE.hasMoreElements()) {
					
					String registro = "";
					String strIdentificacion = "";
					String strImprimeIngreso = "";
					String strImprimeEgreso  = "";
					
					registro = stk_pStrIDREOPIE.nextToken();
					
					if (!registro.contains(EnumGeneralidadesTramasGiros.PIPE.getValor())) {
						
						throw EnumMensajes.ESTRUCTURA_PARAMETRO_IDREOPIE.generarExcepcion(EnumClasesMensaje.ERROR);
					}
					
					StringTokenizer stkRegistro = new StringTokenizer(registro, "|");
					
					try {
						strIdentificacion = stkRegistro.nextToken();
						strImprimeIngreso = stkRegistro.nextToken();
						strImprimeEgreso = stkRegistro.nextToken();
					} catch (NoSuchElementException e) {
						
						throw EnumMensajes.TOKEN_DE_PARAMETRO_VACIO.generarExcepcion(EnumClasesMensaje.ERROR);
					}
					
					validaDatosParameroIDREOPIE(strIdentificacion, strImprimeIngreso, strImprimeEgreso);
				}
				
			} else {
				
				String strIdentificacion = "";
				String strImprimeIngreso = "";
				String strImprimeEgreso  = "";
				
				if (!strpIDREOPIE.contains(EnumGeneralidadesTramasGiros.PIPE.getValor())) {
					
					throw EnumMensajes.ESTRUCTURA_PARAMETRO_IDREOPIE.generarExcepcion(EnumClasesMensaje.ERROR);
				}
				
				StringTokenizer stk_pStrIDREOPIE = new StringTokenizer(strpIDREOPIE, "|");
				
				try {
					strIdentificacion = stk_pStrIDREOPIE.nextToken();
					strImprimeIngreso = stk_pStrIDREOPIE.nextToken();
					strImprimeEgreso  = stk_pStrIDREOPIE.nextToken();
				} catch (NullPointerException e) {
					
					throw EnumMensajes.TOKEN_DE_PARAMETRO_VACIO.generarExcepcion(EnumClasesMensaje.ERROR);
				}
				
				validaDatosParameroIDREOPIE(strIdentificacion, strImprimeIngreso, strImprimeEgreso);
				
			}
		}
	}

	private void generarImpresionOperacion(String operacion) throws Exception {

		FormaMensajeAlerta opcion;
		
		opcion = EnumMensajes.IMPRIMIR_COMPROBANTE_INGRESO_EGRESO.desplegarMensaje(super.getFrmForma(), 
																		  		   EnumClasesMensaje.CONFIRMACION, 
																		  		   operacion);
		if(opcion.isOpcion()){
			
			EnumImpresiones.INGRESO_EGRESO.ejecutarImpresion(super.getFrmForma(), 
															 false,
															 this.ingresoEgreso,
															 super.getObjUsuario());
		}				
	}

	private List<Concepto> consultaConceptos(int pIntTipoConcepto) throws Exception {
		
		List<Concepto> lstConceptos;
		
		CajaVistaLogica.getInstance().consultaConceptosMovCaja(super.getObjUsuario(),
				   											   pIntTipoConcepto,
				   											   EnumParametrosApp.COMPROBANTE_CAJA.getValorEntero());
		
		if (pIntTipoConcepto == EnumParametrosApp.CONCEPTO_NATURALEZA_INGRESO.getValorEntero()) {
			
			lstConceptos = super.getObjUsuario().getEmpresa().getLstConceptosIngresos();
			
		}else if(pIntTipoConcepto == EnumParametrosApp.CONCEPTO_NATURALEZA_EGRESO.getValorEntero()){
			
			lstConceptos = super.getObjUsuario().getEmpresa().getLstConceptosEgresos();
			
		}else{
			
			lstConceptos = null;
		}

		return lstConceptos;
	}
	
	/**
     * ****************************************************************
     * @metodo  validarColaboradoresImpresion
     *			metodo que valida el colaborador dependiendo de la configuracion
     *			en el parametro IDREOPIE
     * @throws  Exception
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */
	private boolean validarColaboradoresImpresion(String pStrIDREOPIE, String strIdentColaborador) throws Exception {
		
		boolean booImprimeT = true;
		
		if (pStrIDREOPIE != null) {
			
			if (pStrIDREOPIE.contains(EnumGeneralidadesTramasGiros.PUNTO_Y_COMA.getValor())) {
				
				StringTokenizer stk_pStrIDREOPIE = new StringTokenizer(pStrIDREOPIE, ";");
				
				while (stk_pStrIDREOPIE.hasMoreElements()) {
					
					String registro = "";
					String strIdentificacion = "";
					String strImprimeIngreso = "";
					String strImprimeEgreso  = "";
					
					registro = stk_pStrIDREOPIE.nextToken();
					
					if (!registro.contains(EnumGeneralidadesTramasGiros.PIPE.getValor())) {
						
						throw EnumMensajes.ESTRUCTURA_PARAMETRO_IDREOPIE.generarExcepcion(EnumClasesMensaje.ERROR);
					}
					
					StringTokenizer stkRegistro = new StringTokenizer(registro, "|");
					
					strIdentificacion = stkRegistro.nextToken();
					strImprimeIngreso = stkRegistro.nextToken();
					strImprimeEgreso = stkRegistro.nextToken();
					
					validaDatosParameroIDREOPIE(strIdentificacion, strImprimeIngreso, strImprimeEgreso);
					
					if (this.castfrmGiroIngresoEgreso().getRbtIngreso().isSelected()) {
						
						if (	strIdentificacion.equals(strIdentColaborador) && strImprimeIngreso.equals("N") ) {
							booImprimeT = false;
						} else if (	strIdentificacion.equals(strIdentColaborador) && strImprimeIngreso.equals("S") ) {
							booImprimeT = true;
						}
					}
					
					if (this.castfrmGiroIngresoEgreso().getRbtEgreso().isSelected()) {
						
						if (	strIdentificacion.equals(strIdentColaborador) && strImprimeEgreso.equals("N") ) {
							booImprimeT = false;
						} else if (	strIdentificacion.equals(strIdentColaborador) && strImprimeEgreso.equals("S") ) {
							booImprimeT = true;
						}
					}
					
				}
				
			} else {
				
				if (!pStrIDREOPIE.contains(EnumGeneralidadesTramasGiros.PIPE.getValor())) {
					
					throw EnumMensajes.ESTRUCTURA_PARAMETRO_IDREOPIE.generarExcepcion(EnumClasesMensaje.ERROR);
				}
				
				StringTokenizer stk_pStrIDREOPIE = new StringTokenizer(pStrIDREOPIE, "|");
				
				String strIdentificacion = "";
				String strImprimeIngreso = "";
				String strImprimeEgreso  = "";
				strIdentificacion = stk_pStrIDREOPIE.nextToken();
				strImprimeIngreso = stk_pStrIDREOPIE.nextToken();
				strImprimeEgreso = stk_pStrIDREOPIE.nextToken();
				
				if (this.castfrmGiroIngresoEgreso().getRbtIngreso().isSelected()) {
					
					if (	strIdentificacion.equals(strIdentColaborador) && strImprimeIngreso.equals("N") ) {
						booImprimeT = false;
					} else if (	strIdentificacion.equals(strIdentColaborador) && strImprimeIngreso.equals("S") ) {
						booImprimeT = true;
					}
				}
				
				if (this.castfrmGiroIngresoEgreso().getRbtEgreso().isSelected()) {
					
					if (	strIdentificacion.equals(strIdentColaborador) && strImprimeEgreso.equals("N") ) {
						booImprimeT = false;
					} else if (	strIdentificacion.equals(strIdentColaborador) && strImprimeEgreso.equals("S") ) {
						booImprimeT = true;
					}
				}
			}
			
		} 
		
		return booImprimeT;
	}
	
	private void validaDatosParameroIDREOPIE(String strIdent, String strImprIngreso, String strImprEgreso) throws Exception {		
		
		if (!Utilidades.esStringConTamanoMinimo(strImprIngreso, 1)) {
			throw EnumMensajes.VALOR_TOKEN_INGRESOS_PARAM_IDREOPIE.generarExcepcion(EnumClasesMensaje.ERROR);
		}
		
		if ( !strImprIngreso.equals("S") && !strImprIngreso.equals("N")) {
			throw EnumMensajes.VALOR_TOKEN_INGRESOS_PARAM_IDREOPIE.generarExcepcion(EnumClasesMensaje.ERROR);
		}
		
		if (!Utilidades.esStringConTamanoMinimo(strImprEgreso, 1)) {
			throw EnumMensajes.VALOR_TOKEN_EGRESOS_PARAM_IDREOPIE.generarExcepcion(EnumClasesMensaje.ERROR);
		}
		
		if (!strImprEgreso.equals("S") && !strImprEgreso.equals("N")) {
			throw EnumMensajes.VALOR_TOKEN_EGRESOS_PARAM_IDREOPIE.generarExcepcion(EnumClasesMensaje.ERROR);
		}
	}
	
	/*
	private void limpiarCampos() throws Exception {
		
		this.castfrmGiroIngresoEgreso().getTxtDocumentoAuxiliar().setText(null);
		this.castfrmGiroIngresoEgreso().getTxaNotas().setText(null);
		this.castfrmGiroIngresoEgreso().getTxtValor().setText(null);
		
		this.castfrmGiroIngresoEgreso().getCmbConcepto().setSelectedItem(EnumEtiquetas.LBL_NO_SELECCIONADO);
		this.castfrmGiroIngresoEgreso().getCmbMedioPago().setSelectedItem(EnumEtiquetas.LBL_NO_SELECCIONADO);
		this.castfrmGiroIngresoEgreso().getPnlTercero().castEvaFrmTercero().restablecer(null);
	}
	*/
	
	/**
  	 * ****************************************************************.
  	 * @metodo castfrmGiroIngresoEgreso()
  	 * 		   Metodo estandar para formatear el tipo de dato general 
  	 * 		   a un tipo especifico ("Casteo"), del atributo
  	 * 		   super.getFrmForma()
  	 * @return FormaGiroIngresoEgreso, valor especifico recuperado
  	 * @throws Exception: Controla, recupera y escala, cualquier tipo de 
  	 * 		   excepcion presentada
  	 * @autor  Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public FormaGiroIngresoEgreso castfrmGiroIngresoEgreso()throws Exception{
		return (FormaGiroIngresoEgreso)super.getFrmForma();
	}
}
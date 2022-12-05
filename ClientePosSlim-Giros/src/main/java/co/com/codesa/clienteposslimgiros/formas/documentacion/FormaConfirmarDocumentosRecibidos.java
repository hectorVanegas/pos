package co.com.codesa.clienteposslimgiros.formas.documentacion;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import co.com.codesa.clienteposslim.logger.Logger;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.documentacion.EventoFormaConfirmarDocumentosRecibidos;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.AreaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelEncabezadoGeneral;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DocPendiente;

public class FormaConfirmarDocumentosRecibidos extends FormaGenerica{

	private static final long serialVersionUID = 1L;	
	
	private FormaPanelEncabezadoGeneral pnlEncabezadoGeneralDestino;
	private SeccionUtil pnlNotaAdicional;

	private CajaComboUtil cmbListaMediosPago;
	private CajaComboUtil cmbListaConceptos;
	
	private AreaTextoUtil txaNotas;
	private AreaTextoUtil txaNotaAdicional;
	private CajaTextoUtil txtReferencia;
	private CajaTextoUtil txtValor;
	
	private EtiquetaUtil lblReferencia;
	private EtiquetaUtil lblConcepto;
	private EtiquetaUtil lblMedioPago;
	private EtiquetaUtil lblValor;
	private EtiquetaUtil lblNotas;
	private EtiquetaUtil lblNotaAdicional;


	public FormaConfirmarDocumentosRecibidos(FormaGenerica pFrmPadre,	 
									  boolean pBooModal, 
									  DocPendiente pObjDocumentoPendiente)throws Exception{

		super(pFrmPadre, 
			  pBooModal);
		
		super.setEventoForma(new EventoFormaConfirmarDocumentosRecibidos(this,
																pObjDocumentoPendiente));
		this.inicializarForma();
	}

	@Override
	public void inicializarForma(Object ...pArrObjParametrosForma) throws Exception{
		
		super.setTituloForma(EnumEtiquetas.TTL_ADP_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.GUI_ADP_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.GUI_ADP_VENTANA.getAlto());
		
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
								EnumBotonesEncabezado.BTN_ANULAR,
								EnumBotonesEncabezado.BTNVOLVER);
		
		super.iniciar(pArrObjParametrosForma);
	}

	@Override
	public JPanel inicializarEncabezado(Object ...pArrObjParametrosEncabezado) throws Exception{
		return null;
	}

	@Override
	public JPanel inicializarCuerpo(Object ...pArrObjParametrosCuerpo) throws Exception{

		JPanel pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_ADP_PANEL_CUERPO, 
																"pnlCuerpo",
		 														null,
		 														EnumEtiquetas.LBL_ADP_SECCION_DESTINO,
		 														null);
		
		pnlCuerpo.add(this.iniciarPropPnlEncabezadoGeneralDestino());
		pnlCuerpo.add(this.iniciarPropLblReferencia());
		pnlCuerpo.add(this.iniciarPropTxtReferencia());
		pnlCuerpo.add(this.iniciarPropLblConcepto());
		pnlCuerpo.add(this.iniciarPropCmbListaConceptos());
		pnlCuerpo.add(this.iniciarPropLblMedioPago());
		pnlCuerpo.add(this.iniciarPropCmbListaMediosPago());
		pnlCuerpo.add(this.iniciarPropLblValor());
		pnlCuerpo.add(this.iniciarPropTxtValor());
		pnlCuerpo.add(this.iniciarPropLblNotas());
		pnlCuerpo.add(this.iniciarPropTxaNotas());
		pnlCuerpo.add(this.iniciarPropPnlNotaAdicional());
		
		return pnlCuerpo;
	}
	
	@Override
	public JPanel inicializarPiePagina(Object ...pArrObjParametrosPiePagina) throws Exception{
		return null;
	}		

	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropPnlEncabezadoGeneralDestino 
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pnlEncabezadoGeneralDestino
  	 * @return FormaPanelEncabezadoGeneral
  	 * 		   seccion de encabezado general gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaPanelEncabezadoGeneral iniciarPropPnlEncabezadoGeneralDestino() throws Exception{
		
		if(this.pnlEncabezadoGeneralDestino==null){
			
			this.pnlEncabezadoGeneralDestino = new FormaPanelEncabezadoGeneral(null, 
																			  super.getObjUsuario().getAgencia(),
																			  super.getObjUsuario().getCaja(), 
																			  EnumDimensionesComponentes.PNL_ADP_ENCABEZADO_GENERAL_DESTINO,
																			  "pnlEncabezadoGeneralDestino");
		}
		
		return this.pnlEncabezadoGeneralDestino;
	}
	
	/**
	 * ****************************************************************.
	 * @metodo iniciarPropPnlNotaAdicional 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   pnlNotaAdicional
	 * @return SeccionUtil 
	 * 		   Seccion diligenciada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public SeccionUtil iniciarPropPnlNotaAdicional() throws Exception {

		if (this.pnlNotaAdicional == null) {

			this.pnlNotaAdicional = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_ADP_SECCION_NOTAS_ADICIONALES,
																				"pnlNotaAdicional",
																			    BorderFactory.createEmptyBorder(),
																			    null,
																			    null);
			this.pnlNotaAdicional.add(this.iniciarPropLblNotaAdicional());
			this.pnlNotaAdicional.add(this.iniciarPropTxaNotaAdicional());
		}

		return this.pnlNotaAdicional;
	}
	
	/**
	 * ****************************************************************.
	 * @metodo iniciarPropCmbListaConceptos 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   cmbListaConceptos
	 * @return CajaComboUtil 
	 * 		   lista de valores gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public CajaComboUtil iniciarPropCmbListaConceptos() throws Exception {

		if (this.cmbListaConceptos == null) {

			this.cmbListaConceptos = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_ADP_LISTA_CONCEPTOS, 
																				    "cmbListaConceptos", 
																				    true, 
																				    true, 
																				    super.getEventoForma(),
																				    EnumEtiquetas.LBL_ADP_CONCEPTO);
		}
		
		return this.cmbListaConceptos;
	}
	
	/**
	 * ****************************************************************.
	 * @metodo iniciarPropCmbListaMediosPago 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   cmbListaMediosPago
	 * @return CajaComboUtil 
	 * 		   lista de valores gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public CajaComboUtil iniciarPropCmbListaMediosPago() throws Exception {

		if (this.cmbListaMediosPago == null) {

			this.cmbListaMediosPago = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_ADP_LISTA_MEDIOS_PAGO, 
																					 "cmbListaMediosPago", 
																					 true, 
																					 true, 
																					 super.getEventoForma(),
																					 EnumEtiquetas.LBL_ADP_MEDIO_PAGO);
		}
		
		return this.cmbListaMediosPago;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropTxaNotas
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   txaNotas
  	 * @return AreaTextoUtil
  	 * 		   area de texto gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public AreaTextoUtil iniciarPropTxaNotas()throws Exception{
	
		if(this.txaNotas==null){
			
			this.txaNotas = UtilComponentesGUI.getInstance().crearTextArea(EnumDimensionesComponentes.TXA_ADP_NOTAS, 
																		   "txtNotas", 
																		   null, 
																		   true, 
																		   false, 
																		   true, 
																		   super.getEventoForma(),
																		   EnumEtiquetas.LBL_ADP_NOTAS);
		}
		
		return this.txaNotas;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropTxaNotaAdicional
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   txaNotaAdicional
  	 * @return AreaTextoUtil
  	 * 		   area de texto gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public AreaTextoUtil iniciarPropTxaNotaAdicional()throws Exception{
	
		if(this.txaNotaAdicional==null){
			
			this.txaNotaAdicional = UtilComponentesGUI.getInstance().crearTextArea(EnumDimensionesComponentes.TXA_ADP_NOTA_ADICIONAL, 
																		   		   "txaNotaAdicional", 
																		   		   null, 
																		   		   true, 
																		   		   true, 
																		   		   true, 
																		   		   super.getEventoForma(),
																		   		   EnumEtiquetas.LBL_ADP_NOTA_ADICIONAL);
		}
		
		return this.txaNotaAdicional;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropTxtReferencia
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   txtReferencia
  	 * @return CajaTextoUtil
  	 * 		   caja de texto gestionada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaTextoUtil iniciarPropTxtReferencia()throws Exception{
		
		if(this.txtReferencia==null){
			
			this.txtReferencia = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_ADP_REFERENCIA, 
																				 "txtReferencia", 
																				 null, 
																				 true, 
																				 false, 
																				 true, 
																				 null,
																				 EnumEtiquetas.LBL_ADP_REFERENCIA);
		}
		
		return this.txtReferencia;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropTxtValor
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   txtValor
  	 * @return CajaTextoUtil
  	 * 		   caja de texto gestionada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaTextoUtil iniciarPropTxtValor()throws Exception{
		
		if(this.txtValor==null){
			
			this.txtValor = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_ADP_VALOR, 
																			"txtValor", 
																			null, 
																			true, 
																			false, 
																			true, 
																			null,
																			EnumEtiquetas.LBL_ADP_VALOR);
			this.txtValor.setHorizontalAlignment(SwingConstants.TRAILING);
			this.txtValor.setForeground(Color.red);
		}
		
		return this.txtValor;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblReferencia
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblReferencia
  	 * @return EtiquetaUtil 
  	 * 		   etiqueta gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblReferencia() throws Exception{
		
		if (this.lblReferencia == null) {
			
			this.lblReferencia = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_ADP_REFERENCIA, 
																		  	 "lblReferencia", 
																		  	 EnumEtiquetas.LBL_ADP_REFERENCIA,
																		  	 true,
																		  	 null,
																		  	 true);
		}

		return this.lblReferencia;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblConcepto
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblConcepto
  	 * @return EtiquetaUtil 
  	 * 		   etiqueta gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblConcepto() throws Exception{
		
		if (this.lblConcepto == null) {
			
			this.lblConcepto = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_ADP_CONCEPTO, 
																		   "lblConcepto", 
																		   EnumEtiquetas.LBL_ADP_CONCEPTO,
																		   true,
																		   null, 
																		   true);
		}

		return this.lblConcepto;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblMedioPago
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblMedioPago
  	 * @return EtiquetaUtil 
  	 * 		   etiqueta gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblMedioPago() throws Exception{
		
		if (this.lblMedioPago == null) {
			
			this.lblMedioPago = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_ADP_MEDIO_PAGO, 
																			"lblMedioPago", 
																			EnumEtiquetas.LBL_ADP_MEDIO_PAGO,
																			true,
																			null, 
																			true);
		}

		return this.lblMedioPago;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblValor
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblValor
  	 * @return EtiquetaUtil 
  	 * 		   etiqueta gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblValor() throws Exception{
		
		if (this.lblValor == null) {
			
			this.lblValor = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_ADP_VALOR, 
																		"lblValor", 
																		EnumEtiquetas.LBL_ADP_VALOR,
																		true,
																		null, 
																		true);
		}

		return this.lblValor;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblNotas
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblNotas
  	 * @return EtiquetaUtil 
  	 * 		   etiqueta gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblNotas() throws Exception{
		
		if (this.lblNotas == null) {
			
			this.lblNotas = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_ADP_NOTAS, 
																		"lblNotas", 
																		EnumEtiquetas.LBL_ADP_NOTAS,
																		true,
																		null, 
																		true);
		}

		return this.lblNotas;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblNotaAdicional
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblNotaAdicional
  	 * @return EtiquetaUtil 
  	 * 		   etiqueta gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblNotaAdicional() throws Exception{
		
		if (this.lblNotaAdicional == null) {
			
			this.lblNotaAdicional = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_ADP_NOTA_ADICIONAL, 
																				"lblNotas", 
																				EnumEtiquetas.LBL_ADP_NOTA_ADICIONAL,
																				true,
																				null, 
																				true);
		}

		return this.lblNotaAdicional;
	}
	
	public FormaPanelEncabezadoGeneral getPnlEncabezadoGeneralDestino() {
		return pnlEncabezadoGeneralDestino;
	}

	public void setPnlEncabezadoGeneralDestino(
			FormaPanelEncabezadoGeneral pnlEncabezadoGeneralDestino) {
		this.pnlEncabezadoGeneralDestino = pnlEncabezadoGeneralDestino;
	}

	public CajaComboUtil getCmbListaMediosPago() {
		return cmbListaMediosPago;
	}

	public void setCmbListaMediosPago(CajaComboUtil cmbListaMediosPago) {
		this.cmbListaMediosPago = cmbListaMediosPago;
	}

	public CajaComboUtil getCmbListaConceptos() {
		return cmbListaConceptos;
	}

	public void setCmbListaConceptos(CajaComboUtil cmbListaConceptos) {
		this.cmbListaConceptos = cmbListaConceptos;
	}

	public AreaTextoUtil getTxaNotas() {
		return txaNotas;
	}

	public void setTxaNotas(AreaTextoUtil txaNotas) {
		this.txaNotas = txaNotas;
	}

	public CajaTextoUtil getTxtReferencia() {
		return txtReferencia;
	}

	public void setTxtReferencia(CajaTextoUtil txtReferencia) {
		this.txtReferencia = txtReferencia;
	}

	public CajaTextoUtil getTxtValor() {
		return txtValor;
	}

	public void setTxtValor(CajaTextoUtil txtValor) {
		this.txtValor = txtValor;
	}

	public EtiquetaUtil getLblReferencia() {
		return lblReferencia;
	}

	public void setLblReferencia(EtiquetaUtil lblReferencia) {
		this.lblReferencia = lblReferencia;
	}

	public EtiquetaUtil getLblConcepto() {
		return lblConcepto;
	}

	public void setLblConcepto(EtiquetaUtil lblConcepto) {
		this.lblConcepto = lblConcepto;
	}

	public EtiquetaUtil getLblMedioPago() {
		return lblMedioPago;
	}

	public void setLblMedioPago(EtiquetaUtil lblMedioPago) {
		this.lblMedioPago = lblMedioPago;
	}

	public EtiquetaUtil getLblValor() {
		return lblValor;
	}

	public void setLblValor(EtiquetaUtil lblValor) {
		this.lblValor = lblValor;
	}

	public EtiquetaUtil getLblNotas() {
		return lblNotas;
	}

	public void setLblNotas(EtiquetaUtil lblNotas) {
		this.lblNotas = lblNotas;
	}
	
	public AreaTextoUtil getTxaNotaAdicional() {
		return txaNotaAdicional;
	}

	public void setTxaNotaAdicional(AreaTextoUtil txaNotaAdicional) {
		this.txaNotaAdicional = txaNotaAdicional;
	}

	public EtiquetaUtil getLblNotaAdicional() {
		return lblNotaAdicional;
	}

	public void setLblNotaAdicional(EtiquetaUtil lblNotaAdicional) {
		this.lblNotaAdicional = lblNotaAdicional;
	}

	public SeccionUtil getPnlNotaAdicional() {
		return pnlNotaAdicional;
	}

	public void setPnlNotaAdicional(SeccionUtil pnlNotaAdicional) {
		this.pnlNotaAdicional = pnlNotaAdicional;
	}

	public static void main(String args[]){		
		
		try{
	        
			TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaConfirmarDocumentosRecibidos.class,
																   true, 
																   EnumDesplegarFormaConEventos.SI);
			new FormaConfirmarDocumentosRecibidos(null,
											true,
											null);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			Logger.getInstance().error(e.getMessage());
			
		}
	}
}
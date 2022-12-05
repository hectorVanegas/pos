package co.com.codesa.clienteposslimgiros.formas.caja;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import co.com.codesa.clienteposslim.logger.Logger;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.caja.EventoFormaProvisionCaja;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.AreaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelEncabezadoGeneral;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelTerritorio;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

/**
 * ****************************************************************.
 * @autor: Roberth Martinez Vargas
 * @fecha: 17-abr-2015
 * @descripcion: Clase para consultar realizar las provisiones de caja
 * @copyright: Copyright  1998-2012 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class FormaProvisionCaja extends FormaGenerica{
	
	private EtiquetaUtil lblConceptoEgreso;
	private EtiquetaUtil lblConceptoIngreso;
	private EtiquetaUtil lblValorEgreso;
	private EtiquetaUtil lblValorIngreso;
	private EtiquetaUtil lblMedioPago;
	private EtiquetaUtil lblDocumentoAuxiliar;
	private EtiquetaUtil lblNotasEgreso;
	private EtiquetaUtil lblNotasIngreso;
	private EtiquetaUtil lblAgenciaDestino;
	private EtiquetaUtil lblCajaDestino;
	private CajaComboUtil cmbConceptoIngreso;
	private CajaComboUtil cmbConceptoEgreso;
	private CajaComboUtil cmbMedioPago;
	private CajaComboUtil cmbAgenciaDestino;
	private CajaComboUtil cmbCajaDestino;
	private JScrollPane scpNotasEgreso;
	private JScrollPane scpNotasIngreso;
	private JPanel pnlEncabezadoGeneralEmp;
	
	private AreaTextoUtil txaNotasEgreso;
	private AreaTextoUtil txaNotasIngreso;
	private CajaTextoUtil txtValorEgreso;
	private CajaTextoUtil txtValorIngreso;
	private CajaTextoUtil txtDocumentoAuxiliar;
	private FormaPanelTerritorio pnlTerritorioAgenciaOrigen;
	private FormaPanelTerritorio pnlTerritorioAgenciaDestino;
	
	private static final long serialVersionUID = 1L;

	public FormaProvisionCaja(JFrame pFrmPadre, boolean pBooModal) throws Exception {
		super(pFrmPadre, pBooModal);
		
		super.setEventoForma(new EventoFormaProvisionCaja(this));
		
		this.inicializarForma();
	}

	@Override
	public void inicializarForma(Object... pArrObjParametrosForma) throws Exception {
		super.setTituloForma(EnumEtiquetas.TTL_PVC_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.FRM_PVC_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.FRM_PVC_VENTANA.getAlto());
        
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
								EnumBotonesEncabezado.BTNSALIR);
		
		super.iniciar(pArrObjParametrosForma);
	}

	@Override
	public JPanel inicializarEncabezado(Object... pArrObjParametrosForma) throws Exception {
		
		JPanel pnlEncabezado;
		
		pnlEncabezado = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_PVC_PANEL_ENCABEZADO,
																	"pnlEncabezado",
	  														 	 	null,
	  														 	 	null,
	  														 	 	null);
		pnlEncabezado.add(this.iniciarPropPnlEncabezadoGeneralEmp());
		
		
		return pnlEncabezado;
	}

	@Override
	public JPanel inicializarCuerpo(Object... pArrObjParametrosForma) throws Exception {
		
		JPanel pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_PVC_PANEL_CUERPO,
																"pnlCuerpo",
		  													 	null,
		  													 	EnumEtiquetas.LBL_PVC_AGENCIA_ORG,
		  													 	null);
		pnlCuerpo.add(this.iniciarPropPnlTerritorioAgenciaOrigen());
		pnlCuerpo.add(this.iniciarPropLblConceptoEgreso());
		pnlCuerpo.add(this.iniciarPropCmbConceptoEgreso());
		pnlCuerpo.add(this.iniciarPropLblValorEgreso());
		pnlCuerpo.add(this.iniciarPropTxtValorEgreso());
		pnlCuerpo.add(this.iniciarPropLblMedioPago());
		pnlCuerpo.add(this.iniciarPropCmbMedioPago());
		pnlCuerpo.add(this.iniciarPropLblDocumentoAuxiliar());
		pnlCuerpo.add(this.iniciarPropTxtDocumentoAuxiliar());
		pnlCuerpo.add(this.iniciarPropLblNotasEgreso());
		pnlCuerpo.add(this.iniciarPropScpNotasEgreso());
		
		return pnlCuerpo;
	}

	@Override
	public JPanel inicializarPiePagina(Object... pArrObjParametrosForma) throws Exception {
		
		JPanel pnlPie;
		
		pnlPie = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_PVC_PANEL_PIE,
															 "pnlPie",
	  												  	  	 null,
	  												  	  	 EnumEtiquetas.LBL_PVC_AGENCIA_DES,
	  												  	  	 null);
		pnlPie.add(this.iniciarPropPnlTerritorioAgenciaDestino());
		pnlPie.add(this.iniciarPropLblConceptoIngreso());
		pnlPie.add(this.iniciarPropCmbConceptoIngreso());
		pnlPie.add(this.iniciarPropLblValorIngreso());
		pnlPie.add(this.iniciarPropTxtValorIngreso());
		pnlPie.add(this.iniciarPropLblNotasIngreso());
		pnlPie.add(this.iniciarPropScpNotasIngreso());
		pnlPie.add(this.iniciarPropLblAgenciaDestino());
		pnlPie.add(this.iniciarPropCmbAgenciaDestino());
		pnlPie.add(this.iniciarPropLblCajaDestino());
		pnlPie.add(this.iniciarPropCmbCajaDestino());
		
		return pnlPie;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropPnlEncabezadoGeneralEmp
     * 		    metodo utilizado para inicializar el componente panel 
     * 			de Empresa
     * @return  JPanel componente JPanel
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */
	public JPanel iniciarPropPnlEncabezadoGeneralEmp() throws Exception{
		
		if(this.pnlEncabezadoGeneralEmp==null){
			
			this.pnlEncabezadoGeneralEmp = new FormaPanelEncabezadoGeneral(super.getObjUsuario().getEmpresa(),
																		   super.getObjUsuario().getAgencia(),
																		   super.getObjUsuario().getCaja(),
														  			       EnumDimensionesComponentes.PNL_PVC_ENCABEZADOGRAL,
														  			       "pnlEncabezadoGeneralEmp");
		}
		
		return this.pnlEncabezadoGeneralEmp;
		
	}
	
	/**
  	 * ****************************************************************
  	 * @throws  Exception
  	 * @metodo  iniciarPropPnlTerritorioAgenciaOrigen (Metodo)
  	 * 			Metodo estandar para autogestionar el valor del 
  	 * 			atributo pnlTerritorioAgenciaOrigen
  	 * @return  JPanel, seccion de territorio y agencia origen gestionada
  	 * @autor   Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public JPanel iniciarPropPnlTerritorioAgenciaOrigen() throws Exception{
		
		if(this.pnlTerritorioAgenciaOrigen==null){
			
			this.pnlTerritorioAgenciaOrigen = new FormaPanelTerritorio("pnlTerritorioAgenciaOrigen",
																	  false,//pTitulos
					 												  true,//pTituloCombo
					 												  new String[]{"cmbPaisOrigen",
																				   "cmbDeptoOrigen",
																				   "cmbMunicipioOrigen"},
					 												  2,//pCategoria
					 												  false,//pAPartir
					 												  false,//pActivaAgencia
					 												  EnumDimensionesComponentes.JPN_PVC_PANEL_AGENCIA_ORG,//rectangulo
					 												  null);//deptoBase
			
			this.castPnlTerritorioAgenciaOrigen().habilitarComponenteCompleto(false);
		}
		
		return this.pnlTerritorioAgenciaOrigen;
		
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropLblConceptoEgreso
     * 			metodo utilizado para inicializar el componente EtiquetaUtil 
     * 			de concepto egreso
     * @return  EtiquetaUtil componente EtiquetaUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblConceptoEgreso() throws Exception{
		if (this.lblConceptoEgreso == null) {
			this.lblConceptoEgreso = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PVC_CONCEPTO_EGRESO, 
																			 	 "lblConceptoEgreso", 
																			 	 EnumEtiquetas.LBL_PVC_CONCEPTO_EGRESO,
																			 	 true,
																			 	 null,
																			 	 true);
		}
		return this.lblConceptoEgreso;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropCmbConceptoEgreso
     * 			metodo utilizado para inicializar el componente 
     * 			CajaComboUtil de conceptos Egreso
     * @return  CajaComboUtil componente CajaComboUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */	
	public CajaComboUtil iniciarPropCmbConceptoEgreso() throws Exception{
		
		if (this.cmbConceptoEgreso == null) {
			
			this.cmbConceptoEgreso = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_PVC_CONCEPTO_EGRESO,
																					"cmbConceptoEgreso",
																					true, 
																					true, 
																					null,
																					EnumEtiquetas.LBL_PVC_CONCEPTO_EGRESO,
																					EnumEtiquetas.LBL_PVC_AGENCIA_ORG.getValor(false));
		}

		return this.cmbConceptoEgreso;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropLblValorEgreso
     * 			metodo utilizado para inicializar el componente EtiquetaUtil
     * 			de VALOR egreso
     * @return  EtiquetaUtil componente EtiquetaUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblValorEgreso() throws Exception{
		if (this.lblValorEgreso == null) {
			this.lblValorEgreso = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PVC_VALOR_EGRESO, 
																		  	  "lblValorEgreso", 
																		  	  EnumEtiquetas.LBL_PVC_VALOR_EGRESO,
																		  	  true,
																		  	  null,
																		  	  true);
		}
		return this.lblValorEgreso;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropTxtValorEgreso
     * 			metodo utilizado para inicializar el componente text 
     * 			para el valor del egreso
     * @return  CajaTextoUtil componente CajaTextoUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */
	public CajaTextoUtil iniciarPropTxtValorEgreso()throws Exception{
		
		if(this.txtValorEgreso==null){
			
			this.txtValorEgreso = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_PVC_VALOR_EGRESO, 
																			  	  "txtValorEgreso", 
																			  	  "",
																			  	  true, 
																			  	  true, 
																			  	  true, 
																			  	  super.getEventoForma(),
																			  	  EnumEtiquetas.LBL_PVC_VALOR_EGRESO);
			
			this.txtValorEgreso.setHorizontalAlignment(SwingConstants.TRAILING);
			this.txtValorEgreso.setForeground(new java.awt.Color(0, 0, 0));
			this.txtValorEgreso.setBackground(new java.awt.Color(164, 164, 255));
		}
		
		return this.txtValorEgreso;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropLblMedioPago
     * 			metodo utilizado para inicializar el componente EtiquetaUtil
     * 			de medio de pago egreso
     * @return  EtiquetaUtil componente EtiquetaUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblMedioPago() throws Exception{
		if (this.lblMedioPago == null) {
			this.lblMedioPago = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PVC_MEDIO_PAGO, 
																			"lblMedioPago", 
																			EnumEtiquetas.LBL_PVC_MEDIO_PAGO,
																			true,
																			null,
																			true);
		}
		return this.lblMedioPago;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropCmbMedioPago
     * 			metodo utilizado para inicializar el componente 
     * 			CajaComboUtil de Medio de pago Egreso
     * @return  CajaComboUtil componente CajaComboUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */	
	public CajaComboUtil iniciarPropCmbMedioPago() throws Exception{
		if (this.cmbMedioPago == null) {
			this.cmbMedioPago = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_PVC_MEDIO_PAGO,
																		   	   "cmbMedioPago",
																		   	   true, 
																		   	   true, 
																		   	   null,
																		   	   EnumEtiquetas.LBL_PVC_MEDIO_PAGO,
																		   	   EnumEtiquetas.LBL_PVC_AGENCIA_ORG.getValor(false));
		}

		return this.cmbMedioPago;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropLblDocumentoAuxiliar
     * 			metodo utilizado para inicializar el componente EtiquetaUtil 
     * 			de documento auxiliar
     * @return  EtiquetaUtil componente EtiquetaUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblDocumentoAuxiliar() throws Exception{
		if (this.lblDocumentoAuxiliar == null) {
			this.lblDocumentoAuxiliar = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PVC_DOCUMENTO_AUXILIAR, 
																					"lblDocAuxiliar", 
																					EnumEtiquetas.LBL_PVC_DOCUMENTO_AUXILIAR,
																					true,
																					null,
																					true);
		}
		return this.lblDocumentoAuxiliar;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropTxtDocumentoAuxiliar
     * 			metodo utilizado para inicializar el componente text
     * 			para el valor de documento auxiliar
     * @return  CajaTextoUtil componente CajaTextoUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */
	public CajaTextoUtil iniciarPropTxtDocumentoAuxiliar()throws Exception{
		
		if(this.txtDocumentoAuxiliar==null){
			
			this.txtDocumentoAuxiliar = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_PVC_DOCUMENTO_AUXILIAR, 
																						"txtDocAuxiliar", 
																						"",
																						true, 
																						true, 
																						true, 
																						super.getEventoForma(),
																						EnumEtiquetas.LBL_PVC_DOCUMENTO_AUXILIAR);
		}
		
		return this.txtDocumentoAuxiliar;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropLblNotasEgreso
     * 			metodo utilizado para inicializar el componente EtiquetaUtil 
     * 			de notas egreso
     * @return  EtiquetaUtil componente EtiquetaUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblNotasEgreso() throws Exception{
		if (this.lblNotasEgreso == null) {
			this.lblNotasEgreso = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PVC_NOTAS_EGRESO, 
																		  	  "lblNotasEgreso", 
																		  	  EnumEtiquetas.LBL_PVC_NOTAS_EGRESO,
																		  	  true,
																		  	  null,
																		  	  true);
		}
		return this.lblNotasEgreso;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropScpNotasEgreso
     * 			metodo utilizado para inicializar el componente de 
     * 			scrollPanel para el area de texto de notas egreso
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */
	public JScrollPane iniciarPropScpNotasEgreso() throws Exception{
		
		if(this.scpNotasEgreso==null){
			
			this.scpNotasEgreso = UtilComponentesGUI.getInstance().crearScroll("scpNotasEgreso",
													 					   	   EnumDimensionesComponentes.SCP_PVC_NOTAS_EGRESO,
													 					   	   null);
			
			this.scpNotasEgreso.setViewportView(this.iniciarPropTxaNotasEgreso());
		}
		
		return this.scpNotasEgreso;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropTxaNotasEgreso
     * 			metodo utilizado para inicializar el componente 
     * 			AreaTextoUtil de notas egreso
     * @return  AreaTextoUtil componente AreaTextoUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */	
	public AreaTextoUtil iniciarPropTxaNotasEgreso() throws Exception{
		if (this.txaNotasEgreso == null) {
			this.txaNotasEgreso = UtilComponentesGUI.getInstance().crearTextArea(EnumDimensionesComponentes.LBL_PVC_VALOR_EGRESO, 
																			 	 "txaNotasEgreso", 
																			 	 "", 
																			 	 true, 
																			 	 true, 
																			 	 true, 
																			 	 super.getEventoForma(),
																			 	 EnumEtiquetas.LBL_PVC_NOTAS_EGRESO);
		}
		
		return this.txaNotasEgreso;
	}
	
	/**
  	 * ****************************************************************.
  	 * @throws  Exception
  	 * @metodo  iniciarPropPnlTerritorioAgenciaDestino (Metodo)
  	 * 			Metodo estandar para autogestionar el valor del 
  	 * 			atributo pnlTerritorioAgenciaDestino
  	 * @return  JPanel, seccion de territorio y agencia origen gestionada
  	 * @autor   Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public JPanel iniciarPropPnlTerritorioAgenciaDestino() throws Exception{
		
		if(this.pnlTerritorioAgenciaDestino==null){
			
			this.pnlTerritorioAgenciaDestino = new FormaPanelTerritorio("pnlTerritorioAgenciaDestino",
																		false,//pTitulos
					 												   true,//pTituloCombo
					 												   new String[]{"cmbPaisDestino",
																					"cmbDeptoDestino",
																					"cmbMunicipioDestino"},
					 												   2,//pCategoria
					 												   false,//pAPartir
					 												   false,//pActivaAgencia
					 												   EnumDimensionesComponentes.JPN_PVC_PANEL_AGENCIA_DES,//rectangulo
					 												   null);//deptoBase
			
			this.castPnlTerritorioAgenciaDestino().habilitarComponenteCompleto(true);
			this.castPnlTerritorioAgenciaDestino().habilitarCombo("cmbPaisDestino", 
																  false);
			
			this.castPnlTerritorioAgenciaDestino().getCmbDepartamento().addItemListener(super.getEventoForma());
			this.castPnlTerritorioAgenciaDestino().getCmbMunicipio().addItemListener(super.getEventoForma());
		}
		
		return this.pnlTerritorioAgenciaDestino;
		
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropLblAgenciaDestino
     * 			metodo utilizado para inicializar el componente EtiquetaUtil 
     * 			de agencia destino
     * @return  EtiquetaUtil componente EtiquetaUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblAgenciaDestino() throws Exception{
		
		if (this.lblAgenciaDestino == null) {
			
			this.lblAgenciaDestino = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PVC_AGENCIA_DESTINO, 
																			 	 "lblAgenciaDestino", 
																			 	 EnumEtiquetas.LBL_PVC_AGENCIA_DESTINO,
																			 	 true,
																			 	 null,
																			 	 true);
		}
		return this.lblAgenciaDestino;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropCmbAgenciaDestino
     * 			metodo utilizado para inicializar el componente 
     * 			CajaComboUtil de agencia destino
     * @return  CajaComboUtil componente CajaComboUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */	
	public CajaComboUtil iniciarPropCmbAgenciaDestino() throws Exception{
		
		if (this.cmbAgenciaDestino == null) {
			
			this.cmbAgenciaDestino = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_PVC_AGENCIA_DESTINO,
																					"cmbAgenciaDestino",
																					true, 
																					true, 
																					super.getEventoForma(),
																					EnumEtiquetas.LBL_PVC_AGENCIA_DESTINO,
																					EnumEtiquetas.LBL_PVC_AGENCIA_DES.getValor(false));
		}

		return this.cmbAgenciaDestino;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropLblCajaDestino
     * 			metodo utilizado para inicializar el componente EtiquetaUtil 
     * 			de caja destino
     * @return  EtiquetaUtil componente EtiquetaUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblCajaDestino() throws Exception{
		
		if (this.lblCajaDestino == null) {
			
			this.lblCajaDestino = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PVC_CAJA_DESTINO, 
																		  	  "lblCajaDestino", 
																		  	  EnumEtiquetas.LBL_PVC_CAJA_DESTINO,
																		  	  true,
																		  	  null,
																		  	  true);
		}
		return this.lblCajaDestino;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropCmbCajaDestino
     * 			metodo utilizado para inicializar el componente 
     * 			CajaComboUtil de CAJA destino
     * @return  CajaComboUtil componente CajaComboUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */	
	public CajaComboUtil iniciarPropCmbCajaDestino() throws Exception{
		
		if (this.cmbCajaDestino == null) {
			
			this.cmbCajaDestino = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_PVC_CAJA_DESTINO,
																			 	 "cmbCajaDestino",
																			 	 true, 
																			 	 true, 
																			 	 super.getEventoForma(),
																			 	 EnumEtiquetas.LBL_PVC_CAJA_DESTINO,
																			 	 EnumEtiquetas.LBL_PVC_AGENCIA_DES.getValor(false));
		}

		return this.cmbCajaDestino;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropLblConceptoIngreso
     * 			metodo utilizado para inicializar el componente EtiquetaUtil 
     * 			de concepto ingreso
     * @return  EtiquetaUtil componente EtiquetaUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblConceptoIngreso() throws Exception{
		
		if (this.lblConceptoIngreso == null) {
			
			this.lblConceptoIngreso = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PVC_CONCEPTO_INGRESO, 
																			  	  "lblConceptoIngreso", 
																			  	  EnumEtiquetas.LBL_PVC_CONCEPTO_INGRESO,
																			  	  true,
																			  	  null,
																			  	  true);
		}
		return this.lblConceptoIngreso;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropCmbConceptoIngreso
     * 			metodo utilizado para inicializar el componente 
     * 			CajaComboUtil de conceptos ingreso
     * @return  CajaComboUtil componente CajaComboUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */	
	public CajaComboUtil iniciarPropCmbConceptoIngreso() throws Exception{
		
		if (this.cmbConceptoIngreso == null) {
			
			this.cmbConceptoIngreso = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_PVC_CONCEPTO_INGRESO, 
																				 	 "cmbConceptoIngreso",
																				 	 true, 
																				 	 true,  
																				 	 null,
																				 	 EnumEtiquetas.LBL_PVC_CONCEPTO_INGRESO);
		}

		return this.cmbConceptoIngreso;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropLblValorIngreso
     * 			metodo utilizado para inicializar el componente EtiquetaUtil 
     * 			de VALOR ingreso
     * @return  EtiquetaUtil componente EtiquetaUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblValorIngreso() throws Exception{
		
		if (this.lblValorIngreso == null) {
			
			this.lblValorIngreso = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PVC_VALOR_INGRESO, 
																		   	   "lblValorIngreso", 
																		   	   EnumEtiquetas.LBL_PVC_VALOR_INGRESO,
																		   	   true,
																		   	   null,
																		   	   true);
		}
		return this.lblValorIngreso;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropTxtValorIngreso
     *			metodo utilizado para inicializar el componente text 
     * 			para el valor del ingreso
     * @return  CajaTextoUtil componente CajaTextoUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */
	public CajaTextoUtil iniciarPropTxtValorIngreso()throws Exception{
		
		if(this.txtValorIngreso==null){
			
			this.txtValorIngreso = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_PVC_VALOR_INGRESO, 
																			   	   "txtValorIngreso", 
																			   	   "",
																			   	   true, 
																			   	   false, 
																			   	   true, 
																			   	   null,
																			   	   EnumEtiquetas.LBL_PVC_VALOR_INGRESO);
			
			this.txtValorIngreso.setHorizontalAlignment(SwingConstants.TRAILING);
			this.txtValorIngreso.setForeground(new java.awt.Color(0, 0, 0));
			this.txtValorIngreso.setBackground(new java.awt.Color(164, 164, 255));
		}
		
		return this.txtValorIngreso;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropLblNotasIngreso
     * 			metodo utilizado para inicializar el componente EtiquetaUtil 
     * 			de notas ingreso
     * @return  EtiquetaUtil componente EtiquetaUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblNotasIngreso() throws Exception{
		if (this.lblNotasIngreso == null) {
			this.lblNotasIngreso = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PVC_NOTAS_INGRESO, 
																		   	   "lblNotasIngreso", 
																		   	   EnumEtiquetas.LBL_PVC_NOTAS_INGRESO,
																		   	   true,
																		   	   null,
																		   	   true);
		}
		return this.lblNotasIngreso;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropScpNotasIngreso
     * 			metodo utilizado para inicializar el componente de 
     * 			scrollPanel para el area de texto de notas ingreso
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */
	public JScrollPane iniciarPropScpNotasIngreso() throws Exception{
		
		if(this.scpNotasIngreso==null){
			
			this.scpNotasIngreso = UtilComponentesGUI.getInstance().crearScroll("scpNotasIngreso",
													 					    	EnumDimensionesComponentes.SCP_PVC_NOTAS_INGRESO,
													 					    	null);
			
			this.scpNotasIngreso.setViewportView(this.iniciarPropTxtNotasIngreso());
		}
		
		return this.scpNotasIngreso;
	}
	
	/**
     * ****************************************************************
     * @metodo  iniciarPropTxaNotasIngreso
     * 			metodo utilizado para inicializar el componente 
     * 			AreaTextoUtil de notas ingreso
     * @return  AreaTextoUtil componente AreaTextoUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */	
	public AreaTextoUtil iniciarPropTxtNotasIngreso() throws Exception{
		
		if (this.txaNotasIngreso == null) {
			
			this.txaNotasIngreso = UtilComponentesGUI.getInstance().crearTextArea(EnumDimensionesComponentes.LBL_PVC_VALOR_INGRESO, 
																			  	  "txaNotasIngreso", 
																			  	  "", 
																			  	  true, 
																			  	  false, 
																			  	  true, 
																			  	  null,
																			  	  EnumEtiquetas.LBL_PVC_NOTAS_INGRESO);
					
		}
		return this.txaNotasIngreso;
	}
	
	/**
  	 * ****************************************************************
  	 * @throws  Exception
  	 * @metodo  castPnlTerritorioAgenciaOrigen
  	 * 			Metodo estandar para formatear el tipo de dato general 
  	 * 			a un tipo especifico ("Casteo"), del atributo
  	 * 			pnlTerritorioAgenciaOrigen
  	 * @return  FormaPanelTerritorio, valor especifico recuperado
  	 * @autor   Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public FormaPanelTerritorio castPnlTerritorioAgenciaOrigen()throws Exception{
		return (FormaPanelTerritorio) this.pnlTerritorioAgenciaOrigen;
	}
	
	/**
  	 * ****************************************************************
  	 * @throws  Exception
  	 * @metodo  castPnlTerritorioAgenciaDestino (Metodo)
  	 * 			Metodo estandar para formatear el tipo de dato general 
  	 * 			a un tipo especifico ("Casteo"), del atributo
				pnlTerritorioAgenciaDestino
  	 * @return  FormaPanelTerritorio, valor especifico recuperado
  	 * @autor   Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public FormaPanelTerritorio castPnlTerritorioAgenciaDestino()throws Exception{
		return (FormaPanelTerritorio) this.pnlTerritorioAgenciaDestino;
	}

	public FormaPanelTerritorio getPnlTerritorioAgenciaOrigen() {
		return pnlTerritorioAgenciaOrigen;
	}

	public void setPnlTerritorioAgenciaOrigen(
			FormaPanelTerritorio pnlTerritorioAgenciaOrigen) {
		this.pnlTerritorioAgenciaOrigen = pnlTerritorioAgenciaOrigen;
	}

	public CajaComboUtil getCmbConceptoIngreso() {
		return cmbConceptoIngreso;
	}

	public void setCmbConceptoIngreso(CajaComboUtil cmbConceptoIngreso) {
		this.cmbConceptoIngreso = cmbConceptoIngreso;
	}

	public CajaComboUtil getCmbConceptoEgreso() {
		return cmbConceptoEgreso;
	}

	public void setCmbConceptoEgreso(CajaComboUtil cmbConceptoEgreso) {
		this.cmbConceptoEgreso = cmbConceptoEgreso;
	}

	public CajaTextoUtil getTxtValorIngreso() {
		return txtValorIngreso;
	}

	public void setTxtValorIngreso(CajaTextoUtil txtValorIngreso) {
		this.txtValorIngreso = txtValorIngreso;
	}

	public CajaComboUtil getCmbMedioPago() {
		return cmbMedioPago;
	}

	public void setCmbMedioPago(CajaComboUtil cmbMedioPago) {
		this.cmbMedioPago = cmbMedioPago;
	}

	public CajaTextoUtil getTxtValorEgreso() {
		return txtValorEgreso;
	}

	public void setTxtValorEgreso(CajaTextoUtil txtValorEgreso) {
		this.txtValorEgreso = txtValorEgreso;
	}

	public AreaTextoUtil getTxaNotasEgreso() {
		return txaNotasEgreso;
	}

	public void setTxaNotasEgreso(AreaTextoUtil txaNotasEgreso) {
		this.txaNotasEgreso = txaNotasEgreso;
	}

	public CajaTextoUtil getTxtDocumentoAuxiliar() {
		return txtDocumentoAuxiliar;
	}

	public void setTxtDocumentoAuxiliar(CajaTextoUtil txtDocumentoAuxiliar) {
		this.txtDocumentoAuxiliar = txtDocumentoAuxiliar;
	}

	public FormaPanelTerritorio getPnlTerritorioAgenciaDestino() {
		return pnlTerritorioAgenciaDestino;
	}

	public void setPnlTerritorioAgenciaDestino(
			FormaPanelTerritorio pnlTerritorioAgenciaDestino) {
		this.pnlTerritorioAgenciaDestino = pnlTerritorioAgenciaDestino;
	}

	public AreaTextoUtil getTxaNotasIngreso() {
		return txaNotasIngreso;
	}

	public void setTxaNotasIngreso(AreaTextoUtil txaNotasIngreso) {
		this.txaNotasIngreso = txaNotasIngreso;
	}

	public CajaComboUtil getCmbAgenciaDestino() {
		return cmbAgenciaDestino;
	}

	public void setCmbAgenciaDestino(CajaComboUtil cmbAgenciaDestino) {
		this.cmbAgenciaDestino = cmbAgenciaDestino;
	}

	public CajaComboUtil getCmbCajaDestino() {
		return cmbCajaDestino;
	}

	public void setCmbCajaDestino(CajaComboUtil cmbCajaDestino) {
		this.cmbCajaDestino = cmbCajaDestino;
	}

	public EtiquetaUtil getLblValorEgreso() {
		return lblValorEgreso;
	}

	public void setLblValorEgreso(EtiquetaUtil lblValorEgreso) {
		this.lblValorEgreso = lblValorEgreso;
	}
	
	public static void main(String[] args) throws Exception {
		
		JFrame jframe = null;
		
		try{
	        
			jframe = TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaProvisionCaja.class,
																			true, 
																			EnumDesplegarFormaConEventos.SI);
			new FormaProvisionCaja(jframe,
								   true); 
			
		} catch (Exception e) {
			
			e.printStackTrace();
			Logger.getInstance().error(e.getMessage());
			
		}
	}
}

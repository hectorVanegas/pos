package co.com.codesa.clienteposslimgiros.formas.notas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.notas.EventoFormaGiroNotas;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.AreaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelEncabezadoGeneral;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

public class FormaGiroNotas extends FormaGenerica{

	private JPanel pnlEncabezadoGeneralEmp;

	private EtiquetaUtil lblReferencia;
	private EtiquetaUtil lblAgenciaOr ;
	private EtiquetaUtil lblAgenciaDe ;
	private EtiquetaUtil lblRemitente ;
	private EtiquetaUtil lblBeneficiario ;
	private EtiquetaUtil lblFechaGiro ;
	private EtiquetaUtil lblNotas;
	
	private CajaTextoUtil txtReferencia;
	private CajaTextoUtil txtCodAgenOr;
	private CajaTextoUtil txtNomAgenOr;
	private CajaTextoUtil txtCodAgenDe;
	private CajaTextoUtil txtNomAgenDe;
	private CajaTextoUtil txtRemitente;
	private CajaTextoUtil txtBeneficiario;
	private CajaTextoUtil txtFechaGiro;
	private AreaTextoUtil txaNotas;
	
	private EtiquetaUtil lblNuevaNota;
	private CajaComboUtil cmbNuevaNota;
	//private JScrollPane scpNotas; 
	
	
	public FormaGiroNotas(JFrame pFrmPadre,
						  boolean pBooModal)throws Exception{
		
		super(pFrmPadre,
			  pBooModal);
		
		super.setEventoForma(new EventoFormaGiroNotas(this));
		
		inicializarForma();
		
	}

	private static final long serialVersionUID = 1L;

	public void inicializarForma(Object ...pArrObjParametrosForma) throws Exception{
		
		super.setTituloForma(EnumEtiquetas.TTL_EDN_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.FRM_EDN_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.FRM_EDN_VENTANA.getAlto());
        
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
								EnumBotonesEncabezado.BTNCONSULTAR,
								EnumBotonesEncabezado.BTNSALIR);
		
		super.iniciar(pArrObjParametrosForma);
		
	}
	
	public JPanel inicializarEncabezado(Object ...pArrObjParametrosEncabezado) throws Exception{
		
		JPanel pnlEncabezado;
		
		pnlEncabezado = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_EDN_PANEL_ENCABEZADO,
																	"pnlEncabezado",
		  														 	null,
		  														 	null,
		  														 	null);
		pnlEncabezado.add(this.iniciarPropPnlEncabezadoGeneralEmp());
		
		
		return pnlEncabezado;
		
	}
	
	public JPanel inicializarCuerpo(Object ...pArrObjParametrosCuerpo) throws Exception{
		
		JPanel pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_EDN_PANEL_CUERPO,
																"pnlCuerpo",
		  													 	null,
		  													 	EnumEtiquetas.TTL_EDN_PANEL_CUERPO,
		  													 	null);
		
		pnlCuerpo.add(this.iniciarPropLblReferencia());
		pnlCuerpo.add(this.iniciarPropTxtReferencia());
		pnlCuerpo.add(this.iniciarPropLblAgenciaOr());
		pnlCuerpo.add(this.iniciarPropTxtCodAgenOr());
		pnlCuerpo.add(this.iniciarPropTxtNomAgenOr());
		pnlCuerpo.add(this.iniciarPropLblAgenciaDe());
		pnlCuerpo.add(this.iniciarPropTxtCodAgenDe());
		pnlCuerpo.add(this.iniciarPropTxtNomAgenDe());
		pnlCuerpo.add(this.iniciarPropLblRemitente());
		pnlCuerpo.add(this.iniciarPropTxtRemitente());
		pnlCuerpo.add(this.iniciarPropLblBeneficiario());
		pnlCuerpo.add(this.iniciarPropTxtBeneficiario());
		pnlCuerpo.add(this.iniciarPropLblFechaGiro());
		pnlCuerpo.add(this.iniciarPropTxtFechaGiro());
		pnlCuerpo.add(this.iniciarPropLblNotas());
		pnlCuerpo.add(this.iniciarPropTxaNotas().getScpContenedor());
		
		return pnlCuerpo;
		
	}

	
	public JPanel inicializarPiePagina(Object ...pArrObjParametrosPiePagina) throws Exception{
		
		JPanel pnlPiePagina;
		
		pnlPiePagina = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_EDN_PANEL_PIE,
																   "pnlPiePagina",
																   null,
																   EnumEtiquetas.LBL_EDN_ADINOTA,
																   null);
		pnlPiePagina.add(this.iniciarPropLblNuevaNota());
		pnlPiePagina.add(this.iniciarPropCmbNuevaNota());
		
		return pnlPiePagina;
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
																		   null,
																		   super.getObjUsuario().getCaja(),
														  			       EnumDimensionesComponentes.PNL_EDN_ENCABEZADOGRAL,
														  			       "pnlEncabezadoGeneralEmp");
		}
		
		return this.pnlEncabezadoGeneralEmp;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropLblReferencia
     * 			metodo utilizado para inicializar el componente EtiquetaUtil 
     * 			de Referencia
     * @return  EtiquetaUtil componente EtiquetaUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblReferencia() throws Exception{
		
		if (this.lblReferencia == null) {
			this.lblReferencia = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_EDN_REFERENCIA, 
																		 	 "lblReferencia", 
																		 	 EnumEtiquetas.LBL_EDN_REFERENCIA,
																		 	 true,
																		 	 null,
																		 	 true);
		}
		return this.lblReferencia;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropTxtReferencia
     *			metodo utilizado para inicializar el componente text 
     * 			para la refrencia
     * @return  CajaTextoUtil componente CajaTextoUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */
	public CajaTextoUtil iniciarPropTxtReferencia()throws Exception{
		
		if(this.txtReferencia==null){
			
			this.txtReferencia = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_EDN_REFERENCIA, 
																			 	 "txtReferencia", 
																			 	 "",
																			 	 true, 
																			 	 true, 
																			 	 true, 
																			 	 super.getEventoForma(),
																			 	 null);
			
			this.txtReferencia.getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_PIN_GIRO.getValor());
		}
		
		return this.txtReferencia;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropLblAgenciaOr
     * 			metodo utilizado para inicializar el componente EtiquetaUtil 
     * 			de agencia Origen
     * @return  EtiquetaUtil componente EtiquetaUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblAgenciaOr() throws Exception{
		
		if (this.lblAgenciaOr == null) {
			this.lblAgenciaOr = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_EDN_AGENCIA_ORIGEN, 
																			"lblAgenciaOr", 
																			EnumEtiquetas.LBL_EDN_AGENORI,
																			true,
																			null,
																			true);
		}
		return this.lblAgenciaOr;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropTxtCodAgenOr
     *			metodo utilizado para inicializar el componente text 
     * 			para codigo agencia origen
     * @return  CajaTextoUtil componente CajaTextoUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */
	public CajaTextoUtil iniciarPropTxtCodAgenOr()throws Exception{
		
		if(this.txtCodAgenOr==null){
			
			this.txtCodAgenOr = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_EDN_COD_AGEN_ORG, 
																				"txtCodAgenOr", 
																				"",
																				true, 
																				false, 
																				true, 
																				null,
																				null);
			
			this.txtCodAgenOr.setToolTipText(EnumEtiquetas.TLT_EDN_AGEN_COD);
		}
		
		return this.txtCodAgenOr;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropTxtNomAgenOr
     *			metodo utilizado para inicializar el componente text 
     * 			para nombre agencia origen
     * @return  CajaTextoUtil componente CajaTextoUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */
	public CajaTextoUtil iniciarPropTxtNomAgenOr()throws Exception{
		
		if(this.txtNomAgenOr==null){
			
			this.txtNomAgenOr = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_EDN_NOM_AGEN_ORG, 
																			 	"txtNomAgenOr", 
																			 	"",
																			 	true, 
																			 	false, 
																			 	true, 
																			 	null,
																			 	null);
			
			this.txtNomAgenOr.setToolTipText(EnumEtiquetas.TLT_EDN_AGEN_DESC);
		}
		
		return this.txtNomAgenOr;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropLblAgenciaDe
     * 			metodo utilizado para inicializar el componente EtiquetaUtil 
     * 			de agencia destino
     * @return  EtiquetaUtil componente EtiquetaUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblAgenciaDe() throws Exception{
		
		if (this.lblAgenciaDe == null) {
			this.lblAgenciaDe = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_EDN_AGENCIA_DESTINO, 
																			"lblAgenciaDe", 
																			EnumEtiquetas.LBL_EDN_AGENDES,
																			true,
																			null,
																			true);
		}
		return this.lblAgenciaDe;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropTxtCodAgenDe
     *			metodo utilizado para inicializar el componente text 
     * 			para codigo agencia origen
     * @return  CajaTextoUtil componente CajaTextoUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */
	public CajaTextoUtil iniciarPropTxtCodAgenDe()throws Exception{
		
		if(this.txtCodAgenDe==null){
			
			this.txtCodAgenDe = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_EDN_COD_AGEN_DEST, 
																				"txtCodAgenDe", 
																				"",
																				true, 
																				false, 
																				true, 
																				null,
																				null);
			
			this.txtCodAgenDe.setToolTipText(EnumEtiquetas.TLT_EDN_AGEN_COD);
		}
		
		return this.txtCodAgenDe;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropTxtNomAgenDe
     *			metodo utilizado para inicializar el componente text 
     * 			para nombre agencia origen
     * @return  CajaTextoUtil componente CajaTextoUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */
	public CajaTextoUtil iniciarPropTxtNomAgenDe()throws Exception{
		
		if(this.txtNomAgenDe==null){
			
			this.txtNomAgenDe = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_EDN_NOM_AGEN_DEST, 
																			 	"txtNomAgenDe", 
																			 	"",
																			 	true, 
																			 	false, 
																			 	true, 
																			 	null,
																			 	null);
			
			this.txtNomAgenDe.setToolTipText(EnumEtiquetas.TLT_EDN_AGEN_DESC);
		}
		
		return this.txtNomAgenDe;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropLblRemitente
     * 			metodo utilizado para inicializar el componente EtiquetaUtil 
     * 			de remitente
     * @return  EtiquetaUtil componente EtiquetaUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblRemitente() throws Exception{
		
		if (this.lblRemitente == null) {
			this.lblRemitente = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_EDN_REMITENTE, 
																			"lblRemitente", 
																			EnumEtiquetas.LBL_EDN_REMITENTE,
																			true,
																			null,
																			true);
		}
		return this.lblRemitente;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropTxtRemitente
     *			metodo utilizado para inicializar el componente text 
     * 			para remitente
     * @return  CajaTextoUtil componente CajaTextoUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */
	public CajaTextoUtil iniciarPropTxtRemitente()throws Exception{
		
		if(this.txtRemitente==null){
			
			this.txtRemitente = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_EDN_REMITENTE, 
																				"txtRemitente", 
																				"",
																				true, 
																				false, 
																				true, 
																				null,
																				null);
		}
		
		return this.txtRemitente;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropLblBeneficiario
     * 			metodo utilizado para inicializar el componente EtiquetaUtil 
     * 			de Beneficiario
     * @return  EtiquetaUtil componente EtiquetaUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblBeneficiario() throws Exception{
		
		if (this.lblBeneficiario == null) {
			this.lblBeneficiario = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_EDN_BENEFICIARIO, 
																		   	   "lblBeneficiario", 
																		   	   EnumEtiquetas.LBL_EDN_BENEFICIARIO,
																		   	   true,
																		   	   null,
																		   	   true);
		}
		return this.lblBeneficiario;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropTxtBeneficiario
     *			metodo utilizado para inicializar el componente text 
     * 			para Beneficiario
     * @return  CajaTextoUtil componente CajaTextoUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */
	public CajaTextoUtil iniciarPropTxtBeneficiario()throws Exception{
		
		if(this.txtBeneficiario==null){
			
			this.txtBeneficiario = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_EDN_BENEFICIARIO, 
																				   "txtBeneficiario", 
																				   "",
																				   true, 
																				   false, 
																				   true, 
																				   null,
																				   null);
		}
		
		return this.txtBeneficiario;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropLblFechaGiro
     * 			metodo utilizado para inicializar el componente EtiquetaUtil 
     * 			de Fecha Giro
     * @return  EtiquetaUtil componente EtiquetaUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblFechaGiro() throws Exception{
		
		if (this.lblFechaGiro == null) {
			this.lblFechaGiro = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_EDN_FECHA_GIRO, 
																			"lblFechaGiro", 
																			EnumEtiquetas.LBL_EDN_FECHAGIRO,
																			true,
																			null,
																			true);
		}
		return this.lblFechaGiro;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropTxtFechaGiro
     *			metodo utilizado para inicializar el componente text 
     * 			para Fecha Giro
     * @return  CajaTextoUtil componente CajaTextoUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */
	public CajaTextoUtil iniciarPropTxtFechaGiro()throws Exception{
		
		if(this.txtFechaGiro==null){
			
			this.txtFechaGiro = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_EDN_FECHA_GIRO, 
																				"txtFechaGiro", 
																				"",
																				true, 
																				false, 
																				true, 
																				null,
																				null);
		}
		
		return this.txtFechaGiro;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropLblNotas
     * 			metodo utilizado para inicializar el componente EtiquetaUtil 
     * 			de Notas
     * @return  EtiquetaUtil componente EtiquetaUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblNotas() throws Exception{
		
		if (this.lblNotas == null) {
			this.lblNotas = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_EDN_NOTAS, 
																 		"lblNotas", 
																 		EnumEtiquetas.LBL_EDN_NOTAS,
																 		true,
																 		null,
																 		true);
		}
		return this.lblNotas;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropScpNotas
     * 			metodo utilizado para inicializar el componente de 
     * 			scrollPanel para el area de texto de notas
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */
	/*public JScrollPane iniciarPropScpNotas() throws Exception{
		
		if(this.scpNotas==null){
			
			this.scpNotas = UtilComponentesGUI.getInstance().crearScroll("scpNotas",
																	 	 EnumDimensionesComponentes.SCP_EDN_NOTAS,
																	 	 null);
			this.scpNotas.setViewportView(this.iniciarPropTxaNotas());
		}
		
		return this.scpNotas;
	}*/
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropTxaNotas
     * 			metodo utilizado para inicializar el componente 
     * 			txaNotas de notas 
     * @return  AreaTextoUtil componente AreaTextoUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */	
	public AreaTextoUtil iniciarPropTxaNotas() throws Exception{
		
		if (this.txaNotas == null) {
			
			this.txaNotas = UtilComponentesGUI.getInstance().crearTextArea(EnumDimensionesComponentes.TXA_EDN_NOTAS, 
																	   	   "txaNotas", 
																	   	   "", 	
																	   	   true, 
																	   	   false, 
																	   	   true, 
																	   	   null,
																	   	   EnumEtiquetas.LBL_EDN_NOTAS);
			
			this.txaNotas.getScpContenedorRound(EnumDimensionesComponentes.SCP_EDN_NOTAS);
		}
		
		return this.txaNotas;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropLblNuevaNota
     * 			metodo utilizado para inicializar el componente EtiquetaUtil 
     * 			de Nueva nota
     * @return  EtiquetaUtil componente EtiquetaUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblNuevaNota() throws Exception{
		
		if (this.lblNuevaNota == null) {
			this.lblNuevaNota = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_EDN_NUEVA_NOTA, 
																 	  		"lblNuevaNota", 
																 	  		EnumEtiquetas.LBL_EDN_NUENOTA,
																 	  		true,
																 	  		null,
																 	  		true);
		}
		return this.lblNuevaNota;
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo iniciarPropCmbNuevaNota
     * 		   metodo utilizado para inicializar el componente 
     * 		   CajaComboUtil de mensajes predeterminados
     * @return CajaComboUtil componente CajaComboUtil
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */	
	public CajaComboUtil iniciarPropCmbNuevaNota() throws Exception{
		
		if (this.cmbNuevaNota == null) {
			this.cmbNuevaNota = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_EDN_NUEVA_NOTA, 
																		   	   "cmbNuevaNota",	
																		   	   true, 
																		   	   true, 
																		   	   null,
																		   	   EnumEtiquetas.LBL_EDN_NUENOTA);
		}

		return this.cmbNuevaNota;
	}

	public CajaTextoUtil getTxtReferencia() {
		return txtReferencia;
	}

	public void setTxtReferencia(CajaTextoUtil txtReferencia) {
		this.txtReferencia = txtReferencia;
	}

	public CajaTextoUtil getTxtCodAgenOr() {
		return txtCodAgenOr;
	}

	public void setTxtCodAgenOr(CajaTextoUtil txtCodAgenOr) {
		this.txtCodAgenOr = txtCodAgenOr;
	}

	public CajaTextoUtil getTxtNomAgenOr() {
		return txtNomAgenOr;
	}

	public void setTxtNomAgenOr(CajaTextoUtil txtNomAgenOr) {
		this.txtNomAgenOr = txtNomAgenOr;
	}

	public CajaTextoUtil getTxtCodAgenDe() {
		return txtCodAgenDe;
	}

	public void setTxtCodAgenDe(CajaTextoUtil txtCodAgenDe) {
		this.txtCodAgenDe = txtCodAgenDe;
	}

	public CajaTextoUtil getTxtNomAgenDe() {
		return txtNomAgenDe;
	}

	public void setTxtNomAgenDe(CajaTextoUtil txtNomAgenDe) {
		this.txtNomAgenDe = txtNomAgenDe;
	}

	public CajaTextoUtil getTxtRemitente() {
		return txtRemitente;
	}

	public void setTxtRemitente(CajaTextoUtil txtRemitente) {
		this.txtRemitente = txtRemitente;
	}

	public CajaTextoUtil getTxtBeneficiario() {
		return txtBeneficiario;
	}
	
	public void setTxtBeneficiario(CajaTextoUtil txtBeneficiario) {
		this.txtBeneficiario = txtBeneficiario;
	}

	public CajaTextoUtil getTxtFechaGiro() {
		return txtFechaGiro;
	}

	public void setTxtFechaGiro(CajaTextoUtil txtFechaGiro) {
		this.txtFechaGiro = txtFechaGiro;
	}

	public AreaTextoUtil getTxaNotas() {
		return txaNotas;
	}
	
	public void setTxaNotas(AreaTextoUtil txaNotas) {
		this.txaNotas = txaNotas;
	}
	
	public CajaComboUtil getCmbNuevaNota() {
		return cmbNuevaNota;
	}

	public void setCmbNuevaNota(CajaComboUtil pCmbNuevaNota) {
		this.cmbNuevaNota = pCmbNuevaNota;
	}
	
	public EtiquetaUtil getLblNuevaNota() {
		return lblNuevaNota;
	}

	public void setLblNuevaNota(EtiquetaUtil lblNuevaNota) {
		this.lblNuevaNota = lblNuevaNota;
	}

	public EtiquetaUtil getLblReferencia() {
		return lblReferencia;
	}

	public void setLblReferencia(EtiquetaUtil lblReferencia) {
		this.lblReferencia = lblReferencia;
	}
	
	public static void main(String[] args) {
		
		JFrame jframe = null;
		
		try{
	        
			jframe = TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaGiroNotas.class,
																			true, 
																			EnumDesplegarFormaConEventos.SI);
			new FormaGiroNotas(jframe, true);
			
		} catch (Exception e) {
			
			UtilidadesGiros.getInstance().controlExcepcion(e, 
														   null);
		}
	}
}

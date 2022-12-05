package co.com.codesa.clienteposslimgiros.formas.operacioninusual;

import java.awt.Font;
import java.awt.HeadlessException;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import co.com.codesa.clienteposslim.enumeraciones.EstadoAplicacionEnum;
import co.com.codesa.clienteposslim.formas.FormaLogin;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.operacioninusual.EventoFormaGiroOperInusualInternacional;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.BotonUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EditorCeldaGrilla;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.GrillaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionDesplazableUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.operacioninusual.paneles.FormaPanelExisteTransaccion;
import co.com.codesa.clienteposslimgiros.formas.operacioninusual.paneles.FormaPanelSenalesAlerta;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

public class FormaGiroOperInusualInternacional extends FormaGenerica {

	/**
	 *  @variable	serialVersionUID
	 *  			Variable serialVersionUID
	 */
	private static final long serialVersionUID = 788357040932395410L;

	/**
	 * @variable pnlDocumento
	 * 			 componente panel sobre la forma para manejar la funcionalida de
	 * 			 gestion de operaciones inusuales
	 **/
	private JPanel pnlDocumento;

	/**
	 * @variable pnlProdTransaccion
	 * 			 componente panel sobre la forma para manejar la funcionalida de
	 * 			 gestion de operaciones inusuales
	 **/
	private JPanel pnlProdTransaccion;

	/**
	 * @variable pnlSenalesAlerta
	 * 			 componente panel sobre la forma para manejar la funcionalida de
	 * 			 gestion de operaciones inusuales
	 **/
	private JPanel pnlSenalesAlerta;

	/**
	 * @variable pnlTransaccionExiste
	 * 			 componente panel sobre la forma para manejar la funcionalida de
	 * 			 gestion de operaciones inusuales
	 **/
	private JPanel pnlTransaccionExiste;
	
	/**
	 * @variable pnlSenalAlerta
	 * 			 componente panel sobre la forma para manejar la funcionalida de
	 * 			 gestion de operaciones inusuales
	 **/
	private FormaPanelSenalesAlerta pnlSenalAlerta;
	
	/**
	 * @variable pnlExisteTransaccion
	 * 			 componente panel sobre la forma para manejar la funcionalida de
	 * 			 gestion de operaciones inusuales
	 **/
	private FormaPanelExisteTransaccion pnlExisteTransaccion;
	
//	private FormaSenalAlertaInternacional pnlSenalAlertaInternacional;
	
	/**
	 * @variable scrollGrillaSenalesAlerta
	 * 			 componente scroll sobre la forma para manejar la funcionalida de
	 * 			 gestion de operaciones inusuales
	 **/
	private SeccionDesplazableUtil scrollGrillaSenalesAlerta;
	
	/**
	 * @variable scrollGrillaSenalesAlerta
	 * 			 componente grilla sobre la forma para manejar las señales de alerta de la funcionalida de
	 * 			 gestion de operaciones inusuales
	 **/
	private GrillaUtil grillaSenalesAlerta;

	//Elementos de la forma documento
	
	/**
	 * @variable lblTipoDocumento
	 * 			 componente label sobre la forma para manejar la funcionalida de
	 * 			 gestion de operaciones inusuales
	 **/
	private EtiquetaUtil lblTipoDocumento;
	
	private CajaComboUtil cmbTipoDocumento;
	
	private EtiquetaUtil lblDocumento;
	
	private CajaTextoUtil txtNumDocumento;
	
	//Elementos de la forma panel Producto transaccion
	
	private EtiquetaUtil lblProducto;

	private CajaComboUtil cmbProducto;

	private EtiquetaUtil lblCorresponsal;

	private CajaComboUtil cmbCorresponsal;

	private EtiquetaUtil lblNoOperacion;

	private CajaTextoUtil txtNoOperacion;

	private EtiquetaUtil lblValorOperacion;

	private CajaTextoUtil txtValorOperacion;

	private EtiquetaUtil lblMoneda;

	private CajaComboUtil cmbMoneda;
	
	//Elementos de la forma panel transaccion existe
	
	private EtiquetaUtil lblCliUsuario;

	private CajaTextoUtil txtCliUsuario;

	private EtiquetaUtil lblNumOperacion;

	private CajaTextoUtil txtNumOperacion;

	private EtiquetaUtil lblProductoTE;

	private CajaComboUtil cmbProductoTE;

	private EtiquetaUtil lblCorresponsalTE;

	private CajaComboUtil cmbCorresponsalTE;

	private EtiquetaUtil lblTipoVinculo;

	private CajaComboUtil cmbTipoVinculo;
	
	private BotonUtil btnAgregar;
	
	private BotonUtil btnEliminar;
	
	private GrillaUtil grillaExisteTransaccion;
	
	private SeccionDesplazableUtil scrollGrillaExisteTransaccion;
	
	private EtiquetaUtil lblCamposObligatorios;
	
	/**
	 * @variable 	hmEditorCeldaSenalesAlerta
	 * 			 	Listado de los componentes de edicion configurados y exclusivos 
	 * 				para cada senal alerta, indexado por el codigo de estas
	 */
	private HashMap<String,EditorCeldaGrilla>	hmEditorCeldaSenalesAlerta;
	
	/**
	 * @variable	txtSenalAlerta
	 * 			 	Caja de texto para ingresar el dato de cada promocion
	 */
	private CajaTextoUtil txtSenalAlerta;

	public FormaGiroOperInusualInternacional(JFrame pFrmPadre, 
											 boolean pBooModal) throws Exception {

		super(pFrmPadre, 
			  pBooModal);

		super.setEventoForma(new EventoFormaGiroOperInusualInternacional(this, 
																		 this.getHmEditorCeldaSenalesAlerta()));

		this.inicializarForma();
		
		this.add(iniciarPropLblCamposObligatorios());
	}



	@Override
	public void inicializarForma(Object... pArrObjParametrosForma)
			throws Exception {

		super.setTituloForma(EnumEtiquetas.TTL_OII_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.FRM_OII_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.FRM_OII_VENTANA.getAlto());

		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
								EnumBotonesEncabezado.BTNSALIR);

		super.iniciar(pArrObjParametrosForma);
		
	}




	@Override
	public JPanel inicializarEncabezado(Object... pArrObjParametrosForma)
			throws Exception {
		
		return null;
		
	}
	
	@Override
	public JPanel inicializarCuerpo(Object... pArrObjParametrosForma)
			throws Exception {


		JPanel pnlCuerpo;

		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.JPN_OII_PANEL_CUERPO, 
				"pnlCuerpo", 
				null, 
				null, 
				null);

		pnlCuerpo.add(this.iniciarPropPnlDocumento());
		pnlCuerpo.add(this.iniciarPropPnlProdTransaccion());
		pnlCuerpo.add(this.iniciarPropLblCamposObligatorios());
		pnlCuerpo.add(this.iniciarPropScrollGrillaTiposEnvio());
		pnlCuerpo.add(this.iniciarPropPnlTransaccionExiste());

		return pnlCuerpo;

	}
	
	@Override
	public JPanel inicializarPiePagina(Object... pArrObjParametrosForma)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public EtiquetaUtil iniciarPropLblTipoDocumento() throws Exception{
		
		if(this.lblTipoDocumento == null){
			
			this.lblTipoDocumento = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_OII_PNL_TIPO_DOCUMENTO, 
																					 "lbl_oii_pnl_tipo_documento", 
																					 EnumEtiquetas.LBL_OII_TIPO_DOCUMENTO, 
																					 true, 
																					 null, 
																					 true);
		}
		
		return this.lblTipoDocumento;
	}


	public EtiquetaUtil iniciarPropLblDocumento() throws Exception{
	
		if(this.lblDocumento == null){
		
			this.lblDocumento = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_OII_PNL_DOCUMENTO, 
																			   "lblDocumento", 
																			   EnumEtiquetas.LBL_OII_DOCUMENTO, 
																			   true, 
																			   null, 
																			   true);
		}
	
		return this.lblDocumento;
	}
	
	private EtiquetaUtil iniciarPropLblCamposObligatorios() throws Exception{
		
		if(this.lblCamposObligatorios == null){
		
			this.lblCamposObligatorios = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_OII_PNL_CAMPOS_OBLIGATORIOS, 
																			   "lblCamposObligatorios", 
																			   EnumEtiquetas.LBL_OII_CAMPOS_OBLIGATORIOS, 
																			   false, 
																			   null, 
																			   true);
		}
	
		return this.lblCamposObligatorios;
	}

	public CajaComboUtil iniciarPropCmbTipoDocumento() throws Exception{
		
		if(this.cmbTipoDocumento == null){
			
			this.cmbTipoDocumento = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_OII_PNL_TIPO_DOCUMENTO,
																				   EnumEtiquetas.LBL_OII_TIPO_DOCUMENTO.getValor(false),
																				   true,
																				   true,
																				   this.getEventoForma(),
																				   null);
		}
		
		this.cmbTipoDocumento.setToolTipText(EnumEtiquetas.LBL_OII_TIPO_DOCUMENTO);
		
		return this.cmbTipoDocumento;
	}

	public CajaTextoUtil iniciarPropTxtNumDocRemitente() throws Exception{
		
		if(this.txtNumDocumento == null){
			
			this.txtNumDocumento = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_OII_PNL_DOCUMENTO, 
																				   EnumEtiquetas.LBL_OII_DOCUMENTO.getValor(false), 
																			      "", 
																			      true, 
																			      true, 
																			      true, 
																			      this.getEventoForma(), 
																			      null);
		}
		
		this.txtNumDocumento.setToolTipText(EnumEtiquetas.LBL_OII_DOCUMENTO);
	
		return this.txtNumDocumento;
	}

	public JPanel iniciarPropPnlDocumento() throws Exception{

		if(this.pnlDocumento==null){			

			this.pnlDocumento = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_OII_PANEL_DOCUMENTO, 
																			"pnlDocumento", 
																			null, 
																			EnumEtiquetas.TTL_OII_PNL_DOCUMENTO, 
																			TitledBorder.LEFT);

			this.pnlDocumento.add(this.iniciarPropLblTipoDocumento());
			this.pnlDocumento.add(this.iniciarPropCmbTipoDocumento());
			this.pnlDocumento.add(this.iniciarPropLblDocumento());
			this.pnlDocumento.add(this.iniciarPropTxtNumDocRemitente());

		}

		return this.pnlDocumento;
	}
	
	public EtiquetaUtil iniciarPropLblProducto() throws Exception{

		if(this.lblProducto == null){

			this.lblProducto = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_OII_PNL_PRODUCTO, 
																			"lblProducto", 
																			EnumEtiquetas.LBL_OII_PRODUCTO, 
																			true, 
																			null, 
																			true);
		}

		return this.lblProducto;
	}


	public CajaComboUtil iniciarPropCmbProducto() throws Exception{

		if(this.cmbProducto == null){

			this.cmbProducto = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_OII_PNL_PRODUCTO,
					EnumEtiquetas.LBL_OII_PRODUCTO.getValor(false),
					true,
					true,
					this.getEventoForma(),
					null);
		}
		
		this.cmbProducto.setToolTipText(EnumEtiquetas.LBL_OII_PRODUCTO);

		return this.cmbProducto;
	}


	public EtiquetaUtil iniciarPropLblCorresponsal() throws Exception{

		if(this.lblCorresponsal == null){

			this.lblCorresponsal = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_OII_PNL_CORRESPONSAL, 
					"lblCorresponsal", 
					EnumEtiquetas.LBL_OII_CORRESPONSAL, 
					true, 
					null, 
					true);
		}

		return this.lblCorresponsal;
	}


	public CajaComboUtil iniciarPropCmbCorresponsal() throws Exception{

		if(this.cmbCorresponsal == null){

			this.cmbCorresponsal = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_OII_PNL_CORRESPONSAL,
					EnumEtiquetas.LBL_OII_CORRESPONSAL.getValor(false),
					true,
					true,
					null,
					null);
		}
		
		this.cmbCorresponsal.setToolTipText(EnumEtiquetas.LBL_OII_CORRESPONSAL);

		return this.cmbCorresponsal;
	}
	
	
	
	public EtiquetaUtil iniciarPropLblNoOperacion() throws Exception{

		if(this.lblNoOperacion == null){

			this.lblNoOperacion = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_OII_PNL_NOOPERACION, 
					"lblNoOperacion", 
					EnumEtiquetas.LBL_OII_NO_DE_OPERACION, 
					true, 
					null, 
					true);
		}

		return this.lblNoOperacion;
	}


	public CajaTextoUtil iniciarPropTxtNoOperacion() throws Exception{
		
		if(this.txtNoOperacion == null){
			
			this.txtNoOperacion = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_OII_PNL_NOOPERACION, 
																				  EnumEtiquetas.LBL_OII_NO_DE_OPERACION.getValor(false), 
																				  "", 
																				  true, 
																				  true, 
																				  true, 
																				  this.getEventoForma(), 
																				  null);
		}
		
		this.txtNoOperacion.setToolTipText(EnumEtiquetas.LBL_OII_NO_DE_OPERACION);
		
		return this.txtNoOperacion;
	}
	
	public EtiquetaUtil iniciarPropLblValorOperacion() throws Exception{

		if(this.lblValorOperacion == null){

			this.lblValorOperacion = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_OII_PNL_VALOROPERACION, 
																				"lblValorOperacion", 
																				EnumEtiquetas.LBL_OII_VALOR_OPERACION, 
																				true, 
																				null, 
																				true);
		}

		return this.lblValorOperacion;
	}
	
	public CajaTextoUtil iniciarPropTxtValorOperacion() throws Exception{
		
		if(this.txtValorOperacion == null){
			
			this.txtValorOperacion = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_OII_PNL_VALOROPERACION, 
																				     EnumEtiquetas.LBL_OII_VALOR_OPERACION.getValor(false), 
																				      "", 
																				      true, 
																				      true, 
																				      true, 
																				      this.getEventoForma(), 
																				      null);
			
			this.txtValorOperacion.setHorizontalAlignment(SwingConstants.TRAILING);
			this.txtValorOperacion.setForeground(new java.awt.Color(0, 0, 0));
			this.txtValorOperacion.setBackground(new java.awt.Color(164, 164, 255));
			this.txtValorOperacion.setToolTipText(EnumEtiquetas.LBL_OII_VALOR_OPERACION);
		}
		
		return this.txtValorOperacion;
	}
	
	public EtiquetaUtil iniciarPropLblMoneda() throws Exception{

		if(this.lblMoneda == null){

			this.lblMoneda = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_OII_PNL_MONEDA, 
																		"lblMoneda", 
																		EnumEtiquetas.LBL_OII_MONEDA, 
																		true, 
																		null, 
																		true);
		}

		return this.lblMoneda;
	}
	
	public CajaComboUtil iniciarPropCmbMoneda() throws Exception{

		if(this.cmbMoneda == null){

			this.cmbMoneda = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_OII_PNL_MONEDA,
					EnumEtiquetas.LBL_OII_MONEDA.getValor(false),
					true,
					true,
					null,
					null);
		}
		
		this.cmbMoneda.setToolTipText(EnumEtiquetas.LBL_OII_MONEDA);

		return this.cmbMoneda;
	}

	public JPanel iniciarPropPnlProdTransaccion() throws Exception{

		if(this.pnlProdTransaccion==null){			

			this.pnlProdTransaccion = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_OII_PANEL_PRODTRANSACCION, 
																				"PNL_OII_PANEL_PRODTRANSACCION", 
																				null, 
																				EnumEtiquetas.TTL_OII_PNL_PRODUCTO_TRANSACCION, 
																				TitledBorder.LEFT);

			this.pnlProdTransaccion.add(this.iniciarPropLblProducto());
			this.pnlProdTransaccion.add(this.iniciarPropCmbProducto());
			this.pnlProdTransaccion.add(this.iniciarPropLblCorresponsal());
			this.pnlProdTransaccion.add(this.iniciarPropCmbCorresponsal());
			this.pnlProdTransaccion.add(this.iniciarPropLblNoOperacion());
			this.pnlProdTransaccion.add(this.iniciarPropTxtNoOperacion());
			this.pnlProdTransaccion.add(this.iniciarPropLblValorOperacion());
			this.pnlProdTransaccion.add(this.iniciarPropTxtValorOperacion());
			this.pnlProdTransaccion.add(this.iniciarPropLblMoneda());
			this.pnlProdTransaccion.add(this.iniciarPropCmbMoneda());

		}

		return this.pnlProdTransaccion;
	}
	
	public JPanel iniciarPropPnlSenalesAlerta() throws Exception{

		if(this.pnlSenalesAlerta==null){			

			this.pnlSenalesAlerta = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_OII_PANEL_SENALES_ALERTA, 
					"pnlSenalesAlerta", 
					null, 
					EnumEtiquetas.TTL_OII_PNL_SENALES_ALERTA, 
					TitledBorder.LEFT);

			this.pnlSenalesAlerta.add(PropPnlSenalesAlerta());
		}

		return this.pnlSenalesAlerta;
	}
	
	public FormaPanelSenalesAlerta PropPnlSenalesAlerta() throws Exception{
		
		if(this.pnlSenalAlerta == null){

			this.pnlSenalAlerta = new FormaPanelSenalesAlerta(this, EnumDimensionesComponentes.PNL_OII_PANEL_SENALES_ALERTA_INTERNO, 
					"pnlSenalAlertaInterno");
		}

		return this.pnlSenalAlerta;
	}
	
	public EtiquetaUtil iniciarPropLblClienteUsuario() throws Exception{

		if(this.lblCliUsuario == null){

			this.lblCliUsuario = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_OII_PNL_DOC_CLI_USUARIO, 
					"lblCliUsuario", 
					EnumEtiquetas.LBL_OII_EXISTE_TRANS_DOC_CLIENTE, 
					true, 
					null, 
					true);
		}

		return this.lblCliUsuario;
	}


	public CajaTextoUtil iniciarPropTxtClienteUsuario() throws Exception{

		if(this.txtCliUsuario == null){

			this.txtCliUsuario = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_OII_PNL_DOC_CLI_USUARIO, 
																				 EnumEtiquetas.LBL_OII_EXISTE_TRANS_DOC_CLIENTE.getValor(false), 
																			     "", 
																			     true, 
																			     true, 
																			     true, 
																			     this.getEventoForma(), 
																			     null);
		}
		
		this.txtCliUsuario.setToolTipText(EnumEtiquetas.LBL_OII_EXISTE_TRANS_DOC_CLIENTE);

		return this.txtCliUsuario;
	}
	
	
	
	public EtiquetaUtil iniciarPropLblNumOperacion() throws Exception{

		if(this.lblNumOperacion == null){

			this.lblNumOperacion = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_OII_PNL_NO_OPERACION, 
					"lblNumOperacion", 
					EnumEtiquetas.LBL_OII_EXISTE_TRANS_NO_OPERACION, 
					true, 
					null, 
					true);
		}

		return this.lblNumOperacion;
	}


	public CajaTextoUtil iniciarPropTxtNumOperacion() throws Exception{

		if(this.txtNumOperacion == null){

			this.txtNumOperacion = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_OII_PNL_NO_OPERACION, 
																					  EnumEtiquetas.LBL_OII_EXISTE_TRANS_NO_OPERACION.getValor(false), 
																				      "", 
																				      true, 
																				      true, 
																				      true, 
																				      this.getEventoForma(), 
																				      null);
		}
		
		this.txtNumOperacion.setToolTipText(EnumEtiquetas.LBL_OII_EXISTE_TRANS_NO_OPERACION);

		return this.txtNumOperacion;
	}
	
	
	public EtiquetaUtil iniciarPropLblProductoTE() throws Exception{

		if(this.lblProductoTE == null){

			this.lblProductoTE = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_OII_PNL_TE_PRODUCTO, 
					"lblProductoTE", 
					EnumEtiquetas.LBL_OII_PRODUCTO,
					true,
					null,
					true);
		}

		return this.lblProductoTE;
	}
	
	
	public CajaComboUtil iniciarPropCmbProductoTE() throws Exception{

		if(this.cmbProductoTE == null){

			this.cmbProductoTE = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_OII_PNL_TE_PRODUCTO,
					EnumEtiquetas.LBL_OII_PRODUCTO.getValor(false),
					true,
					true,
					this.getEventoForma(),
					null);
		}
		
		this.cmbProductoTE.setToolTipText(EnumEtiquetas.LBL_OII_PRODUCTO);

		return this.cmbProductoTE;
	}
	
	
	public EtiquetaUtil iniciarPropLblCorresponsalTE() throws Exception{

		if(this.lblCorresponsalTE == null){

			this.lblCorresponsalTE = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_OII_PNL_TE_CORRESPONSAL, 
					"lblCorresponsalTE", 
					EnumEtiquetas.LBL_OII_CORRESPONSAL, 
					true, 
					null, 
					true);
		}

		return this.lblCorresponsalTE;
	}
	
	
	public CajaComboUtil iniciarPropCmbCorresponsalTE() throws Exception{

		if(this.cmbCorresponsalTE == null){

			this.cmbCorresponsalTE = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_OII_PNL_TE_CORRESPONSAL,
					EnumEtiquetas.LBL_OII_CORRESPONSAL.getValor(false),
					true,
					true,
					this.getEventoForma(),
					null);
		}
		
		this.cmbCorresponsalTE.setToolTipText(EnumEtiquetas.LBL_OII_CORRESPONSAL);

		return this.cmbCorresponsalTE;
	}
	
	
	public EtiquetaUtil iniciarPropLblTipoVinculo() throws Exception{

		if(this.lblTipoVinculo == null){

			this.lblTipoVinculo = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_OII_PNL_TIPO_VINCULO, 
					"lblTipoVinculo", 
					EnumEtiquetas.LBL_OII_TIPO_VINCULO, 
					true, 
					null, 
					true);
		}

		return this.lblTipoVinculo;
	}
	
	
	public CajaComboUtil iniciarPropCmbTipoVinculo() throws Exception{

		if(this.cmbTipoVinculo == null){

			this.cmbTipoVinculo = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_OII_PNL_TIPO_VINCULO,
																				EnumEtiquetas.LBL_OII_TIPO_VINCULO.getValor(false),
																				true,
																				true,
																				this.getEventoForma(),
																				null);
		}

		this.cmbTipoVinculo.setToolTipText(EnumEtiquetas.LBL_OII_TIPO_VINCULO);
		
		return this.cmbTipoVinculo;
	}
	
	
	public BotonUtil iniciarPropBtnAgregar() throws Exception{
		if (this.btnAgregar == null) {
			this.btnAgregar = UtilComponentesGUI.getInstance().crearBoton(EnumDimensionesComponentes.BTN_OII_PNL_TE_AGREGAR, 
																	  	  "btnAgregar", 
																	  	  EnumEtiquetas.BTN_OII_AGREGAR_TRX_ASOCIADA, 
																	  	  true, 
																	  	  true, 
																	  	  this.getEventoForma(),  
																	  	  null);
			this.btnAgregar.setBorder(BorderFactory.createEmptyBorder());
		}

		return this.btnAgregar;
	}
	
	public BotonUtil iniciarPropBtnEliminar() throws Exception{
		if (this.btnEliminar == null) {
			this.btnEliminar = UtilComponentesGUI.getInstance().crearBoton(EnumDimensionesComponentes.BTN_OII_PNL_TE_ELIMINAR, 
																	  	  "btnEliminar", 
																	  	  EnumEtiquetas.BTN_OII_ELIMINAR_TRX_ASOCIADA, 
																	  	  true, 
																	  	  true, 
																	      this.getEventoForma(),  
																	  	  null);
			this.btnEliminar.setBorder(BorderFactory.createEmptyBorder());
		}

		return this.btnEliminar;
	}
	
	
	public SeccionDesplazableUtil iniciarPropScrollGrillaExisteTransaccion() throws Exception{
		
		if(this.scrollGrillaExisteTransaccion == null){
			
			this.scrollGrillaExisteTransaccion = UtilComponentesGUI.getInstance().crearScroll("scrollGrillaExisteTransaccion", 
																					   EnumDimensionesComponentes.GRI_OII_GRID_EXISTE_TRANSACCION, 
																					   null);
			
			this.scrollGrillaExisteTransaccion.setViewportView(this.iniciarPropGrillaExisteTransaccion());
		}
		
		return this.scrollGrillaExisteTransaccion;
	}
	
	public GrillaUtil iniciarPropGrillaExisteTransaccion() throws Exception{
		
		if(this.grillaExisteTransaccion == null){
			
			this.grillaExisteTransaccion = UtilComponentesGUI.getInstance().crearGrilla("grillaExisteTransaccion", 
																				 new EnumEtiquetas []{EnumEtiquetas.TTL_OII_GRILLA_TRX_ASOCIADAS_NUM_DOC_CLIENTE_USUARIO,
																								      EnumEtiquetas.TTL_OII_GRILLA_TRX_ASOCIADAS_NUM_OPERACION,
																								      EnumEtiquetas.TTL_OII_GRILLA_TRX_ASOCIADAS_PRODUCTO,
																								      EnumEtiquetas.TTL_OII_GRILLA_TRX_ASOCIADAS_CORRESPONSAL,
																								      EnumEtiquetas.TTL_OII_GRILLA_TRX_ASOCIADAS_TIPO_VINCULO
																									 }, 
																				 null,//invisibles
																				 new boolean[] {false,
																								false,
																								false},//editable por columna 
																				 new int[]{40,
																						   80,
																						   80,
																						   80,
																						   80,
																						   100,
																						   100},//Dimensiones 
																				 null);//evento
		}
		
		return this.grillaExisteTransaccion;
	}
	
	public JPanel iniciarPropPnlTransaccionExiste() throws Exception{

		if(this.pnlTransaccionExiste==null){			

			this.pnlTransaccionExiste = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_OII_PANEL_EXISTE_TRANSACCION, 
																					"pnlTransaccionExiste", 
																					null, 
																					EnumEtiquetas.TTL_OII_PNL_TRANSACCION_EXISTENTE, 
																					TitledBorder.LEFT);

			this.pnlTransaccionExiste.add(this.iniciarPropLblClienteUsuario());
			this.pnlTransaccionExiste.add(this.iniciarPropTxtClienteUsuario());
			this.pnlTransaccionExiste.add(this.iniciarPropLblNumOperacion());
			this.pnlTransaccionExiste.add(this.iniciarPropTxtNumOperacion());
			this.pnlTransaccionExiste.add(this.iniciarPropLblProductoTE());
			this.pnlTransaccionExiste.add(this.iniciarPropCmbProductoTE());
			this.pnlTransaccionExiste.add(this.iniciarPropLblCorresponsalTE());
			this.pnlTransaccionExiste.add(this.iniciarPropCmbCorresponsalTE());
			this.pnlTransaccionExiste.add(this.iniciarPropLblTipoVinculo());
			this.pnlTransaccionExiste.add(this.iniciarPropCmbTipoVinculo());
			this.pnlTransaccionExiste.add(this.iniciarPropBtnAgregar());
			this.pnlTransaccionExiste.add(this.iniciarPropBtnEliminar());
			this.pnlTransaccionExiste.add(this.iniciarPropScrollGrillaExisteTransaccion());
//			this.pnlTransaccionExiste.add(propPnlTransaccionExiste());

		}

		return this.pnlTransaccionExiste;
	}
	
	public FormaPanelExisteTransaccion propPnlTransaccionExiste() throws Exception{

		if(this.pnlExisteTransaccion == null){

			this.pnlExisteTransaccion = new FormaPanelExisteTransaccion(this, EnumDimensionesComponentes.PNL_OII_PANEL_EXISTE_TRANSACCION_INT, 
					"pnlExisteTransaccion");
		}

		return this.pnlExisteTransaccion;
	}	
	
	public SeccionDesplazableUtil iniciarPropScrollGrillaTiposEnvio() throws Exception{
			
			if(this.scrollGrillaSenalesAlerta == null){
				
				this.scrollGrillaSenalesAlerta = UtilComponentesGUI.getInstance().crearScroll("scrollGrillaSenalesAlerta", 
																						      EnumDimensionesComponentes.GRI_OII_GRID_SENALES_ALERTA, 
																						      BorderFactory.createTitledBorder(EnumEtiquetas.TTL_OII_PNL_SENALES_ALERTA.getValor(false)));
				
				this.scrollGrillaSenalesAlerta.setViewportView(this.iniciarPropGrillaTiposEnvio());
			}
			
			return this.scrollGrillaSenalesAlerta;
		}
	
	public GrillaUtil iniciarPropGrillaTiposEnvio() throws Exception{
		
		if(this.grillaSenalesAlerta == null){
			
			this.grillaSenalesAlerta = UtilComponentesGUI.getInstance().crearGrilla("tblGrillaSenalesAlerta", 
																				 new EnumEtiquetas []{EnumEtiquetas.TTL_OII_GRILLA_SENAL_ALERTA_CODIGO,
																									  EnumEtiquetas.TTL_OII_GRILLA_SENAL_ALERTA_SENAL,
																									  EnumEtiquetas.TTL_OII_GRILLA_SENAL_ALERTA_COMENTARIO
																									  }, 
																				 null,//invisibles
																				 new boolean[] {false,
																								false,
																								true},//editable por columna 
																				 new int[]{30,
																						   150,
																						   100
																						   },//Dimensiones 
																				 super.getEventoForma());//evento
		}
		
		return this.grillaSenalesAlerta;
	}
	
	/**
     * ****************************************************************
     * @method	iniciarPropTxtSenalAlerta
     * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtSenalAlerta
     * @return 	CajaTextoUtil
     * 		   	Caja de texto gestionada
     * @throws 	Exception
     * 		   	Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
     * @author 	roberth.martinez
	 * @date	03/04/2018
     * ****************************************************************
     */
	public	CajaTextoUtil	iniciarPropTxtSenalAlerta	()	throws	Exception
	{
		
		this.txtSenalAlerta	=	UtilComponentesGUI.getInstance().crearTextField	(null, 
																     		 	 "txtSenalAlerta", 
																     		 	 "",
																     		 	 true, 
																     		 	 true, 
																     		 	 true, 
																     		 	 super.getEventoForma(),
																     		 	 null);
		this.txtSenalAlerta.setBorder(BorderFactory.createEmptyBorder());
		
		/**
		 * La fuente (Font) recuperada de la grilla no funciona como se espera, sobre
		 * la caja de texto, por tal razon, para estandarizar la visual de las celdas,
		 * se personaliza la fuente de la caja de texto que se adjuntara a la celda de 
		 * ingreso, con 11 puntos como el equivalente al propuesto por la grilla
		 */
		this.txtSenalAlerta.setFont(this.txtSenalAlerta.getFont().deriveFont(Font.PLAIN, 11));
		
		this.txtSenalAlerta.setHorizontalAlignment(SwingConstants.CENTER);
		
		return this.txtSenalAlerta;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		try {



			JFrame jframe = null;

			try{

				jframe = TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaGiroOperInusualInternacional.class,
						true, 
						EnumDesplegarFormaConEventos.SI);
				
				FormaLogin.estadoAplicacion = EstadoAplicacionEnum.PRODUCCION;
				new FormaGiroOperInusualInternacional(jframe,
						true);

			} catch (Exception e) {

				UtilidadesGiros.getInstance().controlExcepcion(e, 
						null);
			}


		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public CajaComboUtil getCmbTipoDocumento() {
		return cmbTipoDocumento;
	}
	
	public void setCmbTipoDocumento(CajaComboUtil pCmbTipoDocumento) {
		this.cmbTipoDocumento = pCmbTipoDocumento;
	}



	public CajaComboUtil getCmbCorresponsal() {
		return cmbCorresponsal;
	}



	public void setCmbCorresponsal(CajaComboUtil pCmbCorresponsal) {
		this.cmbCorresponsal = pCmbCorresponsal;
	}



	public CajaComboUtil getCmbCorresponsalTE() {
		return cmbCorresponsalTE;
	}



	public void setCmbCorresponsalTE(CajaComboUtil cmbCorresponsalTE) {
		this.cmbCorresponsalTE = cmbCorresponsalTE;
	}



	public CajaComboUtil getCmbProducto() {
		return cmbProducto;
	}



	public void setCmbProducto(CajaComboUtil pCmbProducto) {
		this.cmbProducto = pCmbProducto;
	}



	public CajaComboUtil getCmbProductoTE() {
		return cmbProductoTE;
	}



	public void setCmbProductoTE(CajaComboUtil pCmbProductoTE) {
		this.cmbProductoTE = pCmbProductoTE;
	}



	public CajaComboUtil getCmbMoneda() {
		return cmbMoneda;
	}



	public void setCmbMoneda(CajaComboUtil pCmbMoneda) {
		this.cmbMoneda = pCmbMoneda;
	}



	public CajaComboUtil getCmbTipoVinculo() {
		return cmbTipoVinculo;
	}



	public void setCmbTipoVinculo(CajaComboUtil pCmbTipoVinculo) {
		this.cmbTipoVinculo = pCmbTipoVinculo;
	}



	public GrillaUtil getGrillaSenalesAlerta() {
		return grillaSenalesAlerta;
	}



	public void setGrillaSenalesAlerta(GrillaUtil pGrillaSenalesAlerta) {
		this.grillaSenalesAlerta = pGrillaSenalesAlerta;
	}



	public CajaTextoUtil getTxtSenalAlerta() {
		return txtSenalAlerta;
	}



	public void setTxtSenalAlerta(CajaTextoUtil pTxtSenalAlerta) {
		this.txtSenalAlerta = pTxtSenalAlerta;
	}
	
	/**
	 * @method	getHmEditorCeldaSenalesAlerta
	 * 		  	Metodo get del atributo hmEditorCeldaSenalesAlerta
	 * @return	HashMap<String,EditorCeldaGrilla>
	 *		  	Valor del atributo hmEditorCeldaSenalesAlerta devuelto
	 * @author	roberth.martinez
	 * @date  	3/04/2018
	 */
	public HashMap<String,EditorCeldaGrilla> getHmEditorCeldaSenalesAlerta() {
		
		if	(	this.hmEditorCeldaSenalesAlerta	==	null)
		{
			this.hmEditorCeldaSenalesAlerta	=	new HashMap<String, EditorCeldaGrilla>();
		}
		return hmEditorCeldaSenalesAlerta;
	}

	/**
	 * @method	setHmEditorCeldaSenalesAlerta
	 * 		  	Metodo set del atributo hmEditorCeldaSenalesAlerta
	 * @param	pHmEditorCeldaSenalesAlerta
	 * 			Valor que tomara el atributo hmEditorCeldaSenalesAlerta
	 * @author	roberth.martinez
	 * @date	3/04/2018
	 */
	public void setHmEditorCeldaSenalesAlerta(
			HashMap<String,EditorCeldaGrilla> pHmEditorCeldaSenalesAlerta) {
		this.hmEditorCeldaSenalesAlerta = pHmEditorCeldaSenalesAlerta;
	}



	public CajaTextoUtil getTxtNumDocumento() {
		return txtNumDocumento;
	}



	public void setTxtNumDocumento(CajaTextoUtil pTxtNumDocumento) {
		this.txtNumDocumento = pTxtNumDocumento;
	}



	public CajaTextoUtil getTxtNoOperacion() {
		return txtNoOperacion;
	}



	public void setTxtNoOperacion(CajaTextoUtil pTxtNoOperacion) {
		this.txtNoOperacion = pTxtNoOperacion;
	}



	public CajaTextoUtil getTxtValorOperacion() {
		return txtValorOperacion;
	}



	public void setTxtValorOperacion(CajaTextoUtil pTxtValorOperacion) {
		this.txtValorOperacion = pTxtValorOperacion;
	}



	public CajaTextoUtil getTxtCliUsuario() {
		return txtCliUsuario;
	}



	public void setTxtCliUsuario(CajaTextoUtil pTxtCliUsuario) {
		this.txtCliUsuario = pTxtCliUsuario;
	}



	public CajaTextoUtil getTxtNumOperacion() {
		return txtNumOperacion;
	}



	public void setTxtNumOperacion(CajaTextoUtil pTxtNumOperacion) {
		this.txtNumOperacion = pTxtNumOperacion;
	}



	public GrillaUtil getGrillaExisteTransaccion() {
		return grillaExisteTransaccion;
	}



	public void setGrillaExisteTransaccion(GrillaUtil pGrillaExisteTransaccion) {
		this.grillaExisteTransaccion = pGrillaExisteTransaccion;
	}



	public BotonUtil getBtnAgregar() {
		return btnAgregar;
	}



	public void setBtnAgregar(BotonUtil pBtnAgregar) {
		this.btnAgregar = pBtnAgregar;
	}



	public BotonUtil getBtnEliminar() {
		return btnEliminar;
	}



	public void setBtnEliminar(BotonUtil pBtnEliminar) {
		this.btnEliminar = pBtnEliminar;
	}

}

package co.com.codesa.clienteposslimgiros.formas.documentacion;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import co.com.codesa.clienteposslim.logger.Logger;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.documentacion.EventoFormaCancelarDocumentosEnviados;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.AreaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelEncabezadoGeneral;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DocPendiente;

public class FormaCancelarDocumentosEnviados extends FormaGenerica{

	private static final long serialVersionUID = 1L;	
	
	private FormaPanelEncabezadoGeneral pnlEncabezadoGeneralOrigen;
	
	private CajaComboUtil cmbListaMediosPago;
	private CajaComboUtil cmbListaConceptos;
	private CajaComboUtil cmbListaRazon;
	
	private AreaTextoUtil txaNotas;
	private CajaTextoUtil txtReferencia;
	private CajaTextoUtil txtValor;
	private CajaTextoUtil txtCodigoAgenciaDestino;
	private CajaTextoUtil txtDescripcionAgenciaDestino;
	private CajaTextoUtil txtCodigoCajaDestino;
	private CajaTextoUtil txtDescripcionCajaDestino;
	
	private EtiquetaUtil lblAgenciaDestino;
	private EtiquetaUtil lblCajaDestino;
	private EtiquetaUtil lblReferencia;
	private EtiquetaUtil lblConcepto;
	private EtiquetaUtil lblMedioPago;
	private EtiquetaUtil lblValor;
	private EtiquetaUtil lblRazon;
	private EtiquetaUtil lblNotas;

	public FormaCancelarDocumentosEnviados(FormaGenerica pFrmPadre, 
									   boolean pBooModal, 
									   DocPendiente pObjDocumentoPendiente)throws Exception{
		super(pFrmPadre, 
			  pBooModal);
		
		super.setEventoForma(new EventoFormaCancelarDocumentosEnviados(this,
															     	   pObjDocumentoPendiente));
		this.inicializarForma();
	}

	@Override
	public void inicializarForma(Object ...pArrObjParametrosForma) throws Exception{
		
		super.setTituloForma(EnumEtiquetas.TTL_RDP_RECHAZO);
		super.setAnchoForma(EnumDimensionesComponentes.GUI_RDP_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.GUI_RDP_VENTANA.getAlto());
		
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
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
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_RDP_PANEL_CUERPO, 
																"pnlCuerpo",
													 			null,
													 			EnumEtiquetas.LBL_RDP_SECCION_ORIGEN,
													 			null);
		
		pnlCuerpo.add(this.iniciarPropPnlEncabezadoGeneralOrigen());
		pnlCuerpo.add(this.iniciarPropLblReferencia());
		pnlCuerpo.add(this.iniciarPropTxtReferencia());
		pnlCuerpo.add(this.iniciarPropLblConcepto());
		pnlCuerpo.add(this.iniciarPropCmbListaConceptos());
		pnlCuerpo.add(this.iniciarPropLblMedioPago());
		pnlCuerpo.add(this.iniciarPropCmbListaMediosPago());
		pnlCuerpo.add(this.iniciarPropLblValor());
		pnlCuerpo.add(this.iniciarPropTxtValor());
		pnlCuerpo.add(this.iniciarPropLblRazon());
		pnlCuerpo.add(this.iniciarPropCmbListaRazon());
		pnlCuerpo.add(this.iniciarPropLblNotas());
		pnlCuerpo.add(this.iniciarPropTxaNotas());
		
		return pnlCuerpo;
	}
	
	@Override
	public JPanel inicializarPiePagina(Object ...pArrObjParametrosPiePagina) throws Exception{
		
		JPanel pnlPiePagina;
		
		pnlPiePagina = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_RDP_PANEL_PIE_PAGINA, 
																   "pnlPiePagina",
	 															   null,
	 															   EnumEtiquetas.LBL_RDP_SECCION_DESTINO,
	 															   null);
		
		pnlPiePagina.add(this.iniciarPropLblAgenciaDestino());
		pnlPiePagina.add(this.iniciarPropTxtCodigoAgenciaDestino());
		pnlPiePagina.add(this.iniciarPropTxtDescripcionAgenciaDestino());
		pnlPiePagina.add(this.iniciarPropLblCajaDestino());
		pnlPiePagina.add(this.iniciarPropTxtCodigoCajaDestino());
		pnlPiePagina.add(this.iniciarPropTxtDescripcionCajaDestino());
		
		return pnlPiePagina;
	}		

	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropPnlEncabezadoGeneralOrigen 
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pnlEncabezadoGeneralOrigen
  	 * @return FormaPanelEncabezadoGeneral
  	 * 		   seccion de encabezado general gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaPanelEncabezadoGeneral iniciarPropPnlEncabezadoGeneralOrigen() throws Exception{
		
		if(this.pnlEncabezadoGeneralOrigen==null){
			
			this.pnlEncabezadoGeneralOrigen = new FormaPanelEncabezadoGeneral(null, 
																			  super.getObjUsuario().getAgencia(),
																			  super.getObjUsuario().getCaja(), 
																			  EnumDimensionesComponentes.PNL_RDP_ENCABEZADO_GENERAL_ORIGEN,
																			  "pnlEncabezadoGeneralOrigen");
		}
		
		return this.pnlEncabezadoGeneralOrigen;
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

			this.cmbListaConceptos = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_RDP_LISTA_CONCEPTOS, 
																				    "cmbListaConceptos", 
																				    true, 
																				    true, 
																				    super.getEventoForma(),
																				    EnumEtiquetas.LBL_RDP_CONCEPTO);
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

			this.cmbListaMediosPago = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_RDP_LISTA_MEDIOS_PAGO, 
																					 "cmbListaMediosPago", 
																					 true, 
																					 true, 
																					 super.getEventoForma(),
																					 EnumEtiquetas.LBL_RDP_MEDIO_PAGO);
		}
		
		return this.cmbListaMediosPago;
	}
	
	/**
	 * ****************************************************************.
	 * @metodo iniciarPropCmbListaRazon 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   cmbListaRazon
	 * @return CajaComboUtil 
	 * 		   lista de valores gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public CajaComboUtil iniciarPropCmbListaRazon() throws Exception {

		if (this.cmbListaRazon == null) {

			this.cmbListaRazon = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_RDP_LISTA_RAZON, 
																				"cmbListaRazon", 
																				true, 
																				true, 
																				super.getEventoForma(),
																				EnumEtiquetas.LBL_RDP_RAZON);
		}
		
		return this.cmbListaRazon;
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
			
			this.txaNotas = UtilComponentesGUI.getInstance().crearTextArea(EnumDimensionesComponentes.TXA_RDP_NOTAS, 
																		   "txtNotas", 
																		   null, 
																		   true, 
																		   false, 
																		   true, 
																		   super.getEventoForma(),
																		   EnumEtiquetas.LBL_RDP_NOTAS);
		}
		
		return this.txaNotas;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropTxtCodigoAgenciaDestino
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   txtCodigoAgenciaDestino
  	 * @return CajaTextoUtil
  	 * 		   caja de texto gestionada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaTextoUtil iniciarPropTxtCodigoAgenciaDestino()throws Exception{
		
		if(this.txtCodigoAgenciaDestino==null){
			
			this.txtCodigoAgenciaDestino = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_RDP_CODIGO_AGENCIA_DESTINO, 
																						   "txtCodigoAgenciaDestino", 
																						   null, 
																						   true, 
																						   false, 
																						   true, 
																						   null,
																						   EnumEtiquetas.LBL_RDP_AGENCIA_DESTINO,
																						   EnumEtiquetas.LBL_CODIGO.toString(),
																						   EnumEtiquetas.LBL_RDP_SECCION_DESTINO.toString());
		}
		
		return this.txtCodigoAgenciaDestino;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropTxtDescripcionAgenciaDestino
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   txtDescripcionAgenciaDestino
  	 * @return CajaTextoUtil
  	 * 		   caja de texto gestionada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaTextoUtil iniciarPropTxtDescripcionAgenciaDestino()throws Exception{
		
		if(this.txtDescripcionAgenciaDestino==null){
			
			this.txtDescripcionAgenciaDestino = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_RDP_DESCRIPCION_AGENCIA_DESTINO, 
																								"txtDescripcionAgenciaDestino", 
																								null, 
																								true, 
																								false, 
																								true, 
																								null,
																								EnumEtiquetas.LBL_RDP_AGENCIA_DESTINO,
																								EnumEtiquetas.LBL_DESCRIPCION.toString(),
																								EnumEtiquetas.LBL_RDP_SECCION_DESTINO.toString());
		}
		
		return this.txtDescripcionAgenciaDestino;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropTxtCodigoCajaDestino
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   txtCodigoCajaDestino
  	 * @return CajaTextoUtil
  	 * 		   caja de texto gestionada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaTextoUtil iniciarPropTxtCodigoCajaDestino()throws Exception{
		
		if(this.txtCodigoCajaDestino==null){
			
			this.txtCodigoCajaDestino = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_RDP_CODIGO_CAJA_DESTINO, 
																						"txtCodigoCajaDestino", 
																						null, 
																						true, 
																						false, 
																						true, 
																						null,
																						EnumEtiquetas.LBL_RDP_CAJA_DESTINO,
																						EnumEtiquetas.LBL_CODIGO.toString(),
																						EnumEtiquetas.LBL_RDP_SECCION_DESTINO.toString());
		}
		
		return this.txtCodigoCajaDestino;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropTxtDescripcionCajaDestino
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   txtDescripcionCajaDestino
  	 * @return CajaTextoUtil
  	 * 		   caja de texto gestionada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaTextoUtil iniciarPropTxtDescripcionCajaDestino()throws Exception{
		
		if(this.txtDescripcionCajaDestino==null){
			
			this.txtDescripcionCajaDestino = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_RDP_DESCRIPCION_CAJA_DESTINO, 
																							 "txtDescripcionCajaDestino", 
																							 null, 
																							 true, 
																							 false, 
																							 true, 
																							 null,
																							 EnumEtiquetas.LBL_RDP_CAJA_DESTINO,
																							 EnumEtiquetas.LBL_DESCRIPCION.toString(),
																							 EnumEtiquetas.LBL_RDP_SECCION_DESTINO.toString());
		}
		
		return this.txtDescripcionCajaDestino;
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
			
			this.txtReferencia = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_RDP_REFERENCIA, 
																				 "txtReferencia", 
																				 null, 
																				 true, 
																				 false, 
																				 true, 
																				 null,
																				 EnumEtiquetas.LBL_RDP_REFERENCIA);
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
			
			this.txtValor = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_RDP_VALOR, 
																			"txtValor", 
																			null, 
																			true, 
																			false, 
																			true, 
																			null,
																			EnumEtiquetas.LBL_RDP_VALOR);
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
			
			this.lblReferencia = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_RDP_REFERENCIA, 
																		  	 "lblReferencia", 
																		  	 EnumEtiquetas.LBL_RDP_REFERENCIA,
																		  	 true,
																		  	 null,
																		  	 true);
		}

		return this.lblReferencia;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblAgenciaDestino
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblAgenciaDestino
  	 * @return EtiquetaUtil 
  	 * 		   etiqueta gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblAgenciaDestino() throws Exception{
		
		if (this.lblAgenciaDestino == null) {
			
			this.lblAgenciaDestino = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_RDP_AGENCIA_DESTINO, 
																				 "lblAgenciaDestino", 
																				 EnumEtiquetas.LBL_RDP_AGENCIA_DESTINO,
																				 true,
																				 null, 
																				 true);
		}

		return this.lblAgenciaDestino;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblCajaDestino
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblCajaDestino
  	 * @return EtiquetaUtil 
  	 * 		   etiqueta gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblCajaDestino() throws Exception{
		
		if (this.lblCajaDestino == null) {
			
			this.lblCajaDestino = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_RDP_CAJA_DESTINO, 
																			  "lblCajaDestino", 
																			  EnumEtiquetas.LBL_RDP_CAJA_DESTINO,
																			  true,
																			  null, 
																			  true);
		}

		return this.lblCajaDestino;
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
			
			this.lblConcepto = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_RDP_CONCEPTO, 
																		   "lblConcepto", 
																		   EnumEtiquetas.LBL_RDP_CONCEPTO,
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
			
			this.lblMedioPago = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_RDP_MEDIO_PAGO, 
																			"lblMedioPago", 
																			EnumEtiquetas.LBL_RDP_MEDIO_PAGO,
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
			
			this.lblValor = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_RDP_VALOR, 
																		"lblValor", 
																		EnumEtiquetas.LBL_RDP_VALOR,
																		true,
																		null, 
																		true);
		}

		return this.lblValor;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblRazon
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblRazon
  	 * @return EtiquetaUtil 
  	 * 		   etiqueta gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblRazon() throws Exception{
		
		if (this.lblRazon == null) {
			
			this.lblRazon = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_RDP_RAZON, 
																		"lblRazon", 
																		EnumEtiquetas.LBL_RDP_RAZON,
																		true,
																		null, 
																		true);
		}

		return this.lblRazon;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblNotas
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   EtiquetaUtil
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
			
			this.lblNotas = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_RDP_NOTAS, 
																		"lblNotas", 
																		EnumEtiquetas.LBL_RDP_NOTAS,
																		true,
																		null, 
																		true);
		}

		return this.lblNotas;
	}

	public CajaComboUtil getCmbListaConceptos() {
		return cmbListaConceptos;
	}

	public void setCmbListaConceptos(CajaComboUtil comboConcepto) {
		this.cmbListaConceptos = comboConcepto;
	}

	public CajaComboUtil getCmbListaMediosPago() {
		return cmbListaMediosPago;
	}

	public void setCmbListaMediosPago(CajaComboUtil comboMedioPago) {
		this.cmbListaMediosPago = comboMedioPago;
	}

	public AreaTextoUtil getTxaNotas() {
		return txaNotas;
	}

	public void setTxaNotas(AreaTextoUtil txtNotas) {
		this.txaNotas = txtNotas;
	}

	public CajaComboUtil getCmbListaRazon() {
		return cmbListaRazon;
	}

	public void setCmbListaRazon(CajaComboUtil cmbRazon) {
		this.cmbListaRazon = cmbRazon;
	}

	public FormaPanelEncabezadoGeneral getPnlEncabezadoGeneralOrigen() {
		return pnlEncabezadoGeneralOrigen;
	}

	public void setPnlEncabezadoGeneralOrigen(
			FormaPanelEncabezadoGeneral pnlEncabezadoGeneralOrigen) {
		this.pnlEncabezadoGeneralOrigen = pnlEncabezadoGeneralOrigen;
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

	public EtiquetaUtil getLblRazon() {
		return lblRazon;
	}

	public void setLblRazon(EtiquetaUtil lblRazon) {
		this.lblRazon = lblRazon;
	}

	public EtiquetaUtil getLblNotas() {
		return lblNotas;
	}

	public void setLblNotas(EtiquetaUtil lblNotas) {
		this.lblNotas = lblNotas;
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
	
	public CajaTextoUtil getTxtCodigoAgenciaDestino() {
		return txtCodigoAgenciaDestino;
	}

	public void setTxtCodigoAgenciaDestino(CajaTextoUtil txtCodigoAgenciaDestino) {
		this.txtCodigoAgenciaDestino = txtCodigoAgenciaDestino;
	}

	public CajaTextoUtil getTxtDescripcionAgenciaDestino() {
		return txtDescripcionAgenciaDestino;
	}

	public void setTxtDescripcionAgenciaDestino(
			CajaTextoUtil txtDescripcionAgenciaDestino) {
		this.txtDescripcionAgenciaDestino = txtDescripcionAgenciaDestino;
	}

	public CajaTextoUtil getTxtCodigoCajaDestino() {
		return txtCodigoCajaDestino;
	}

	public void setTxtCodigoCajaDestino(CajaTextoUtil txtCodigoCajaDestino) {
		this.txtCodigoCajaDestino = txtCodigoCajaDestino;
	}

	public CajaTextoUtil getTxtDescripcionCajaDestino() {
		return txtDescripcionCajaDestino;
	}

	public void setTxtDescripcionCajaDestino(CajaTextoUtil txtDescripcionCajaDestino) {
		this.txtDescripcionCajaDestino = txtDescripcionCajaDestino;
	}

	public EtiquetaUtil getLblAgenciaDestino() {
		return lblAgenciaDestino;
	}

	public void setLblAgenciaDestino(EtiquetaUtil lblAgenciaDestino) {
		this.lblAgenciaDestino = lblAgenciaDestino;
	}

	public EtiquetaUtil getLblCajaDestino() {
		return lblCajaDestino;
	}

	public void setLblCajaDestino(EtiquetaUtil lblCajaDestino) {
		this.lblCajaDestino = lblCajaDestino;
	}

	public static void main(String args[]){		
		
		try{
	        
			TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaCancelarDocumentosEnviados.class,
																   true, 
																   EnumDesplegarFormaConEventos.SI);
			new FormaCancelarDocumentosEnviados(null,
											true,
											null);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			Logger.getInstance().error(e.getMessage());
			
		}
	}
}
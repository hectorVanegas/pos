package co.com.codesa.clienteposslimgiros.formas.caja;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import co.com.codesa.clienteposslim.logger.Logger;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.eventos.caja.EventoFormaGiroIngresoEgreso;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.AreaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.BotonRadioUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelEncabezadoGeneral;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelTercero;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

/**
 * 
 * ********************************************************************
 * @class 	FormaGiroIngresoEgreso
 *		   	Clase que genera y administra la forma (GUI) para la 
 *			funcionalidad de ingresos/egresos de caja
 * @author 	hector.cuenca
 * @date   	30/11/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class FormaGiroIngresoEgreso extends FormaGenerica {
	
	/**
	 * @variable 	serialVersionUID
	 * 			 	Variable serialVersionUID
	 */
	private static final long serialVersionUID = -1499231920021257974L;
	
	/**
	 * @variable pnlEncabezadoGeneral
	 * 			 seccion que aloja el encabezado general para las formas, 
	 * 			 que contiene los valores de agencia, empresa y caja, 
	 * 			 normalmente recuperados del usuario autenticado
	 **/
	private FormaPanelEncabezadoGeneral pnlEncabezadoGeneral;
	
	/**
	 * @variable	pnlTercero
	 * 			 	Seccion que permite el diligenciamiento y gestion de
	 * 				un tercero
	 */
	private FormaPanelTercero pnlTercero;	
	
	/**
	 * @variable 	txaNotas
	 * 			 	Area de texto para relacionar las anotaciones adicionales 
	 * 				a la operacion que se esta llevando a cabo
	 */
	private AreaTextoUtil txaNotas;
	
	/**
	 * @variable 	cmbConcepto
	 * 			 	Lista desplegable para seleccionar el concepto asociado
	 * 				al tipo de operacion
	 */
	private CajaComboUtil cmbConcepto;
	
	/**
	 * @variable 	cmbMedioPago
	 * 			 	Lista desplegable para seleccionar el medio de pago bajo el
	 * 				cual se realizara la operacion
	 */
	private CajaComboUtil cmbMedioPago;

	/**
	 * @variable 	txtValor
	 * 			 	Caja de texto para ingresar el valor por el cual se realizara 
	 * 				la transaccion
	 */
	private CajaTextoUtil txtValor;
	
	/**
	 * @variable 	txtDocumentoAuxiliar
	 * 			 	Caja de texto disponible para ingresar un documento auxiliar
	 * 				en caso que el medio de pago asi lo requiera
	 */
	private CajaTextoUtil txtDocumentoAuxiliar;
	
	/**
	 * @variable 	btnGrpTipoOperacion
	 * 			 	Contenedor que permite agrupar los botones radio, para realizar
	 * 				su dinamica de seleccion unica
	 */
	private ButtonGroup btnGrpTipoOperacion;
	
	/**
	 * @variable 	rbtIngreso
	 * 			 	Boton radio que permite la seleccion del tipo de operacion ingreso 
	 */
	private BotonRadioUtil rbtIngreso;
	
	/**
	 * @variable 	rbtEgreso
	 * 			 	Boton radio que permite la seleccion del tipo de operacion egreso
	 */
	private BotonRadioUtil rbtEgreso;
	
	/**
	 * @variable 	lblConcepto
	 * 			 	Etiqueta que identifica el componente grafico para seleccionar 
	 * 				el concepto
	 */
	private EtiquetaUtil lblConcepto;
	
	/**
	 * @variable 	lblTipoMovimiento
	 * 			 	Etiqueta que identifica el componente grafico para tipo de movimiento 
	 */
	private EtiquetaUtil lblTipoMovimiento;
	
	/**
	 * @variable 	lblValor
	 * 			 	Etiqueta que identifica el componente grafico para diligenciar 
	 * 				el valor de la operacion
	 */
	private EtiquetaUtil lblValor;
	
	/**
	 * @variable 	lblMedioPago
	 * 			 	Etiqueta que identifica el componente grafico para seleccionar el
	 * 				medio de pago
	 */
	private EtiquetaUtil lblMedioPago;
	
	/**
	 * @variable 	lblDocumentoAuxiliar
	 * 			 	Etiqueta que identifica el componente grafico para diligenciar el
	 * 				documento auxiliar en caso que este se habilite segun el medio de pago
	 * 				seleccionado
	 */
	private EtiquetaUtil lblDocumentoAuxiliar;
	
	/**
	 * @variable 	lblNotas
	 * 			 	Etiqueta que identifica el componente grafico para diligenciar las 
	 * 				notas asociadas a la operacion
	 */
	private EtiquetaUtil lblNotas;

	/**
  	 * ****************************************************************.
  	 * @method	FormaConsultaMovimientosCajaGiros
  	 * 		   	Constructor que ejecuta la inicializacion de valores y 
  	 * 		   	ejecucion de comportamientos inicales requeridos para el 
  	 * 		   	despliegue de la forma
  	 * @param  	pFrmPadre
  	 * 		   	ventana de la cual extiende esta forma
  	 * @param  	pBooModal 
  	 * 		   	bandera que permite efectuar la forma de manera modal sobre 
  	 * 		   	la ventana de la cual extiende
  	 * @throws 	Exception 
  	 * 		   	Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
  	 * @author 	hector.cuenca
  	 * ****************************************************************
  	 */
	public FormaGiroIngresoEgreso(JFrame pFrmPadre, 
								  boolean pBooModal)throws Exception {
		
		super(pFrmPadre, 
			  pBooModal);
		
		super.setEventoForma(new EventoFormaGiroIngresoEgreso(this));
		
		this.inicializarForma();
	}

	@Override
	public void inicializarForma(Object... pArrObjParametrosForma) throws Exception {
		
		super.setTituloForma(EnumEtiquetas.TTL_IN_VENTANA);
		
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
								EnumBotonesEncabezado.BTN_LIMPIAR,
							    EnumBotonesEncabezado.BTNSALIR);
		
		super.setAnchoForma(EnumDimensionesComponentes.GUI_VENTANA_INGEGR.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.GUI_VENTANA_INGEGR.getAlto());
		
		super.iniciar(pArrObjParametrosForma);
	}

	@Override
	public JPanel inicializarEncabezado(Object... pArrObjParametrosEncabezado) throws Exception {

		JPanel pnlEncabezado;
		
		pnlEncabezado = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_CONTENCABEZADO_INGEGR, 
																	"pnlEncabezado",
																	null,
																	null,
																	null);

		pnlEncabezado.add(this.iniciarPropPnlEncabezadoGeneral());
		
		return pnlEncabezado;
	}

	@Override
	public JPanel inicializarCuerpo(Object... pArrObjParametrosCuerpo) throws Exception {

		JPanel pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_CONTENCENTRO_INGEGR, 
																"pnlCuerpo",
															 	null,
																null,
																null);
		pnlCuerpo.add(this.iniciarPropPnlTercero());
		pnlCuerpo.add(this.iniciarPropRbtIngreso());
		pnlCuerpo.add(this.iniciarPropRbtEgreso());
		pnlCuerpo.add(this.iniciarPropCmbConcepto());
		pnlCuerpo.add(this.iniciarPropCmbMedioPago());
		
		pnlCuerpo.add(this.iniciarPropLblTipoMovimiento());
		pnlCuerpo.add(this.iniciarPropLblConcepto());
		pnlCuerpo.add(this.iniciarPropLblDocumentoAuxiliar());
		pnlCuerpo.add(this.iniciarPropLblMedioPago());
		pnlCuerpo.add(this.iniciarPropLblNotas());
		pnlCuerpo.add(this.iniciarPropLblValor());
		
		pnlCuerpo.add(this.iniciarPropTxtDocumentoAuxiliar());
		pnlCuerpo.add(this.iniciarPropTxaNotas().getScpContenedor());
		pnlCuerpo.add(this.iniciarPropTxtValor());
		
		this.iniciarPropBtnGrpTipoOperacion();

		return pnlCuerpo;
	}
	
	@Override
	public JPanel inicializarPiePagina(Object... pArrObjParametrosPiePagina)throws Exception {
		return null;
	}

	/**
  	 * ****************************************************************.
  	 * @method iniciarPropTxaNotas 
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   txaNotas
  	 * @return AreaTextoUtil
  	 * 		   Area de texto gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor  hector.cuenca
  	 * @date   9/03/2016
  	 * ****************************************************************
  	 */
	public AreaTextoUtil iniciarPropTxaNotas()throws Exception{
		
		if(this.txaNotas == null){
			
			this.txaNotas = UtilComponentesGUI.getInstance().crearTextArea(null, 
																		   "txtNotas", 
																		   "", 
																		   true, 
																		   true,
																		   true, 
																		   super.getEventoForma(),
																		   EnumEtiquetas.LBL_IN_NOTAS);
			
			this.txaNotas.getScpContenedorRound(EnumDimensionesComponentes.TXT_SCROLL_INGEGR);
			//this.txaNotas.setBorder(BorderFactory.createEmptyBorder());
			this.txaNotas.getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_NOTAS.getValor());
		}
		
		return this.txaNotas;
	}
	
	/**
  	 * ****************************************************************.
  	 * @method iniciarPropTxtDocumentoAuxiliar 
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   txtDocumentoAuxiliar
  	 * @return CajaTextoUtil
  	 * 		   Caja de texto gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor  hector.cuenca
  	 * @date   9/03/2016
  	 * ****************************************************************
  	 */
	public CajaTextoUtil iniciarPropTxtDocumentoAuxiliar()throws Exception{
		
		if(this.txtDocumentoAuxiliar == null){
			
			this.txtDocumentoAuxiliar = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_DOCAUX_INGEGR, 
				    														 "txtDocumentoAuxiliar", 
				    														 "", 
				    														 true, 
				    														 true,
				    														 true, 
				    														 null,
				    														 EnumEtiquetas.LBL_IN_DOCAUX);
			
			this.txtDocumentoAuxiliar.getPropiedades().setActivaMayusculaMinuscula(true);
			this.txtDocumentoAuxiliar.getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.CODIGO_APROBACION_TARJETAS_INGRESO.getValor());
			this.txtDocumentoAuxiliar.getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.CODIGO_APROBACION_TARJETAS_FINAL.getValor());
		}
		
		return this.txtDocumentoAuxiliar;
	}
	
	/**
  	 * ****************************************************************.
  	 * @method iniciarPropTxtValor 
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   txtValor
  	 * @return CajaTextoUtil
  	 * 		   Caja de texto gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor  hector.cuenca
  	 * @date   9/03/2016
  	 * ****************************************************************
  	 */
	public CajaTextoUtil iniciarPropTxtValor()throws Exception{
		
		if(this.txtValor == null){
			
			this.txtValor = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_VALOR_INGEGR, 
																			"txtValor", 
																			"", 
																			true, 
																			true,
																			true, 
																			null,
																			EnumEtiquetas.LBL_IN_VALOR);
			
			this.txtValor.getPropiedades().setFormatoSalida(UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO());
			this.txtValor.getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.FORMATO_DINERO_SIN_CERO_IED.getValor());	
			this.txtValor.setHorizontalAlignment(SwingConstants.TRAILING);
			this.txtValor.setBackground(new Color(164, 164, 255));
		}
		
		return txtValor;
	}
	
	/**
  	 * ****************************************************************.
  	 * @method iniciarPropLblValor 
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblValor
  	 * @return EtiquetaUtil
  	 * 		   Etiqueta gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor  hector.cuenca
  	 * @date   9/03/2016
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblValor()throws Exception{
		
		if(this.lblValor == null){
			
			this.lblValor = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_VALOR_INGEGR, 
																		"lblValor", 
																		EnumEtiquetas.LBL_IN_VALOR,
																		false,
																		null,
																		true);
		}
		
		return this.lblValor;
	}
	
	/**
  	 * ****************************************************************.
  	 * @method iniciarPropLblNotas 
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblNotas
  	 * @return EtiquetaUtil
  	 * 		   Etiqueta gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor  hector.cuenca
  	 * @date   9/03/2016
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblNotas()throws Exception{
		
		if(this.lblNotas == null){
			
			this.lblNotas = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_NOTAS_INGEGR, 
																		"lblNotas", 
																		EnumEtiquetas.LBL_IN_NOTAS,
																		false,
																		null,
																		true);
		}
		
		return this.lblNotas;
	}
	
	/**
  	 * ****************************************************************.
  	 * @method iniciarPropLblDocumentoAuxiliar 
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblDocumentoAuxiliar
  	 * @return EtiquetaUtil
  	 * 		   Etiqueta gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor  hector.cuenca
  	 * @date   9/03/2016
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblDocumentoAuxiliar()throws Exception{
		
		if(this.lblDocumentoAuxiliar == null){
			
			this.lblDocumentoAuxiliar = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_DOCAUX_INGEGR, 
																		 "lblDocumentoAuxiliar",
																		 EnumEtiquetas.LBL_IN_DOCAUX,
																		 false,
																		 null, 
																		 true);
		}
		
		return this.lblDocumentoAuxiliar;
	}
	
	/**
  	 * ****************************************************************.
  	 * @method iniciarPropLblMedioPago 
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblMedioPago
  	 * @return EtiquetaUtil
  	 * 		   Etiqueta gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor  hector.cuenca
  	 * @date   9/03/2016
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblMedioPago()throws Exception{
		
		if(this.lblMedioPago == null){
			
			this.lblMedioPago = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_MEDIOPAGO_INGEGR, 
																			"lblMedioPago",
																			EnumEtiquetas.LBL_IN_MEDIPAGO,
																			false,
																			null, 
																			true);
		}
		
		return this.lblMedioPago;
	}
	
	/**
  	 * ****************************************************************.
  	 * @method iniciarPropLblTipoMovimiento 
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblTipoMovimiento
  	 * @return EtiquetaUtil
  	 * 		   Etiqueta gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @author roberth.martinez
  	 * @date   9/03/2016
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblTipoMovimiento()throws Exception{
		
		if(this.lblTipoMovimiento == null){
			
			this.lblTipoMovimiento = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_TIPO_MOVIMIENTO_INGEGR, 
																	  	   "lblTipoMovimiento", 
																	  	   EnumEtiquetas.LBL_IN_TIPO_MOVIMIENTO,
																	  	   false,
																	  	   null, 
																	  	   true);
		}
		
		return this.lblTipoMovimiento;
	}
	
	/**
  	 * ****************************************************************.
  	 * @method iniciarPropLblConcepto 
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblConcepto
  	 * @return EtiquetaUtil
  	 * 		   Etiqueta gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor  hector.cuenca
  	 * @date   9/03/2016
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblConcepto()throws Exception{
		
		if(this.lblConcepto == null){
			
			this.lblConcepto = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_CONCEPTO_INGEGR, 
																	  	   "lblConcepto", 
																	  	   EnumEtiquetas.LBL_IN_CONCEPTO,
																	  	   false,
																	  	   null, 
																	  	   true);
		}
		
		return this.lblConcepto;
	}
	
	/**
  	 * ****************************************************************.
  	 * @method iniciarPropCmbMedioPago 
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   cmbMedioPago
  	 * @return CajaComboUtil
  	 * 		   Lista desplegable gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor  hector.cuenca
  	 * @date   9/03/2016
  	 * ****************************************************************
  	 */
	public CajaComboUtil iniciarPropCmbMedioPago()throws Exception{
		
		if(this.cmbMedioPago == null){
			
			this.cmbMedioPago = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.JCB_MEDIOPAGO_INGEGR, 
																			   "cmbMedioPago", 
																			   true, 
																			   true,
																			   super.getEventoForma(),
																			   EnumEtiquetas.LBL_IN_MEDIPAGO);
		}
		
		return this.cmbMedioPago;
	}
	
	/**
  	 * ****************************************************************.
  	 * @method iniciarPropCmbConcepto 
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   cmbConcepto
  	 * @return CajaComboUtil
  	 * 		   Lista desplegable gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor  hector.cuenca
  	 * @date   9/03/2016
  	 * ****************************************************************
  	 */
	public CajaComboUtil iniciarPropCmbConcepto()throws Exception{
		
		if(this.cmbConcepto == null){
			
			this.cmbConcepto = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.JCB_CONCEPTO_INGEGR, 
																			  "cmbConcepto", 
																			  true, 
																			  true,
																			  super.getEventoForma(),
																			  EnumEtiquetas.LBL_IN_CONCEPTO);
		}
		
		return this.cmbConcepto;
	}
	
	/**
  	 * ****************************************************************.
  	 * @method iniciarPropRbtIngreso 
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   rbtIngreso
  	 * @return BotonRadioUtil
  	 * 		   Boton radio gestionado
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor  hector.cuenca
  	 * @date   9/03/2016
  	 * ****************************************************************
  	 */
	public BotonRadioUtil iniciarPropRbtIngreso()throws Exception{
		
		if(this.rbtIngreso == null){
			
			this.rbtIngreso = UtilComponentesGUI.getInstance().crearRadioButton(EnumDimensionesComponentes.JRB_INGRESO_INGEGR, 
																				"rbtIngreso", 
																				EnumEtiquetas.LBL_IN_INGRESO,
																				false,
																				true,
																				true, 
																				false, 
																				null, 
																				super.getEventoForma());
			
		}
		
		return this.rbtIngreso;
	}
	
	/**
  	 * ****************************************************************.
  	 * @method iniciarPropRbtEgreso 
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   rbtEgreso
  	 * @return BotonRadioUtil
  	 * 		   Boton radio gestionado
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor  hector.cuenca
  	 * @date   9/03/2016
  	 * ****************************************************************
  	 */
	public BotonRadioUtil iniciarPropRbtEgreso()throws Exception{
		
		if(this.rbtEgreso == null){
			
			this.rbtEgreso = UtilComponentesGUI.getInstance().crearRadioButton(EnumDimensionesComponentes.JRB_EGRESO_INGEGR, 
																			   "rbtEgreso", 
																			   EnumEtiquetas.LBL_IN_EGRESO,
																			   false,
																			   true,
																			   true, 
																			   false, 
																			   null, 
																			   super.getEventoForma());
			
		}
		
		return this.rbtEgreso;
	}
	
	/**
  	 * ****************************************************************.
  	 * @method iniciarPropBtnGrpTipoOperacion 
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   btnGrpTipoOperacion
  	 * @return ButtonGroup
  	 * 		   Contenedor de grupo de botones radio gestionado
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor  hector.cuenca
  	 * @date   9/03/2016
  	 * ****************************************************************
  	 */
	public ButtonGroup iniciarPropBtnGrpTipoOperacion()throws Exception{
		
		if(this.btnGrpTipoOperacion == null){
		
			this.btnGrpTipoOperacion = new ButtonGroup();
			this.btnGrpTipoOperacion.add(this.rbtIngreso);
			this.btnGrpTipoOperacion.add(this.rbtEgreso);
		}
		
		return this.btnGrpTipoOperacion;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropPnlEncabezadoGeneral
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pnlEncabezadoGeneral
  	 * @return FormaPanelEncabezadoGeneral
  	 * 		   seccion de encabezado general gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaPanelEncabezadoGeneral iniciarPropPnlEncabezadoGeneral() throws Exception{
		
		if(this.pnlEncabezadoGeneral==null){
			
			this.pnlEncabezadoGeneral = new FormaPanelEncabezadoGeneral(super.getObjUsuario().getEmpresa(),
																	   	super.getObjUsuario().getAgencia(),
																	   	super.getObjUsuario().getCaja(),
																	   	EnumDimensionesComponentes.PNL_EMPRESA_INGEGR,
																	   	"pnlEncabezadoGeneral");
		}
		
		return this.pnlEncabezadoGeneral;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropPnlTercero
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pnlTercero
  	 * @return FormaPanelTercero
  	 * 		   seccion de tercero gestionada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaPanelTercero iniciarPropPnlTercero()throws Exception{
		
		if(this.pnlTercero==null){
			
			this.pnlTercero = new FormaPanelTercero("pnlTercero",
													EnumEtiquetas.LBL_PNL_TERC_TERCERO,
													this,
													EnumDimensionesComponentes.JPN_RTT_PANEL_TERCERO_INGEGR,
													null,
													null,
													"",
													null);
			
			this.pnlTercero.castEvaFrmTercero().cargarTiposIdentificacion(EnumParametrosApp.ENT_TIPOS_IDENTIFICACION_INGRESO_EGRSO.getValorPropiedad());
			this.pnlTercero.castEvaFrmTercero().setBooActivaValidacionBloqueadoXRiesgos(true);
		}
		
		return this.pnlTercero;
	}

	/**
	 * @method getPnlEncabezadoGeneral
	 * 		   Metodo get del atributo pnlEncabezadoGeneral
	 * @return FormaPanelEncabezadoGeneral
	 *		   Valor del atributo pnlEncabezadoGeneral devuelto
	 * @author hector.cuenca
	 * @date   1/12/2016
	 */
	public FormaPanelEncabezadoGeneral getPnlEncabezadoGeneral() {
		return this.pnlEncabezadoGeneral;
	}

	/**
	 * @method setPnlEncabezadoGeneral
	 * 		   Metodo set del atributo pnlEncabezadoGeneral
	 * @param  pPnlEncabezadoGeneral
	 *		   Valor que tomara el atributo pnlEncabezadoGeneral
	 * @author hector.cuenca
	 * @date   1/12/2016
	 */
	public void setPnlEncabezadoGeneral(
			FormaPanelEncabezadoGeneral pPnlEncabezadoGeneral) {
		this.pnlEncabezadoGeneral = pPnlEncabezadoGeneral;
	}

	/**
	 * @method getPnlTercero
	 * 		   Metodo get del atributo pnlTercero
	 * @return FormaPanelTercero
	 *		   Valor del atributo pnlTercero devuelto
	 * @author hector.cuenca
	 * @date   1/12/2016
	 */
	public FormaPanelTercero getPnlTercero() {
		return this.pnlTercero;
	}

	/**
	 * @method setPnlTercero
	 * 		   Metodo set del atributo pnlTercero
	 * @param  pPnlTercero
	 *		   Valor que tomara el atributo pnlTercero
	 * @author hector.cuenca
	 * @date   1/12/2016
	 */
	public void setPnlTercero(FormaPanelTercero pPnlTercero) {
		this.pnlTercero = pPnlTercero;
	}

	/**
	 * @method getTxaNotas
	 * 		   Metodo get del atributo txaNotas
	 * @return AreaTextoUtil
	 *		   Valor del atributo txaNotas devuelto
	 * @author hector.cuenca
	 * @date   1/12/2016
	 */
	public AreaTextoUtil getTxaNotas() {
		return this.txaNotas;
	}

	/**
	 * @method setTxaNotas
	 * 		   Metodo set del atributo txaNotas
	 * @param  pTxaNotas
	 *		   Valor que tomara el atributo txaNotas
	 * @author hector.cuenca
	 * @date   1/12/2016
	 */
	public void setTxaNotas(AreaTextoUtil pTxaNotas) {
		this.txaNotas = pTxaNotas;
	}

	/**
	 * @method getCmbConcepto
	 * 		   Metodo get del atributo cmbConcepto
	 * @return CajaComboUtil
	 *		   Valor del atributo cmbConcepto devuelto
	 * @author hector.cuenca
	 * @date   1/12/2016
	 */
	public CajaComboUtil getCmbConcepto() {
		return this.cmbConcepto;
	}

	/**
	 * @method setCmbConcepto
	 * 		   Metodo set del atributo cmbConcepto
	 * @param  pCmbConcepto
	 *		   Valor que tomara el atributo cmbConcepto
	 * @author hector.cuenca
	 * @date   1/12/2016
	 */
	public void setCmbConcepto(CajaComboUtil pCmbConcepto) {
		this.cmbConcepto = pCmbConcepto;
	}

	/**
	 * @method getCmbMedioPago
	 * 		   Metodo get del atributo cmbMedioPago
	 * @return CajaComboUtil
	 *		   Valor del atributo cmbMedioPago devuelto
	 * @author hector.cuenca
	 * @date   1/12/2016
	 */
	public CajaComboUtil getCmbMedioPago() {
		return this.cmbMedioPago;
	}

	/**
	 * @method setCmbMedioPago
	 * 		   Metodo set del atributo cmbMedioPago
	 * @param  pCmbMedioPago
	 *		   Valor que tomara el atributo cmbMedioPago
	 * @author hector.cuenca
	 * @date   1/12/2016
	 */
	public void setCmbMedioPago(CajaComboUtil pCmbMedioPago) {
		this.cmbMedioPago = pCmbMedioPago;
	}

	/**
	 * @method getTxtValor
	 * 		   Metodo get del atributo txtValor
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtValor devuelto
	 * @author hector.cuenca
	 * @date   1/12/2016
	 */
	public CajaTextoUtil getTxtValor() {
		return this.txtValor;
	}

	/**
	 * @method setTxtValor
	 * 		   Metodo set del atributo txtValor
	 * @param  pTxtValor
	 *		   Valor que tomara el atributo txtValor
	 * @author hector.cuenca
	 * @date   1/12/2016
	 */
	public void setTxtValor(CajaTextoUtil pTxtValor) {
		this.txtValor = pTxtValor;
	}

	/**
	 * @method getTxtDocumentoAuxiliar
	 * 		   Metodo get del atributo txtDocumentoAuxiliar
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtDocumentoAuxiliar devuelto
	 * @author hector.cuenca
	 * @date   1/12/2016
	 */
	public CajaTextoUtil getTxtDocumentoAuxiliar() {
		return this.txtDocumentoAuxiliar;
	}

	/**
	 * @method setTxtDocumentoAuxiliar
	 * 		   Metodo set del atributo txtDocumentoAuxiliar
	 * @param  pTxtDocumentoAuxiliar
	 *		   Valor que tomara el atributo txtDocumentoAuxiliar
	 * @author hector.cuenca
	 * @date   1/12/2016
	 */
	public void setTxtDocumentoAuxiliar(CajaTextoUtil pTxtDocumentoAuxiliar) {
		this.txtDocumentoAuxiliar = pTxtDocumentoAuxiliar;
	}

	/**
	 * @method getBtnGrpTipoOperacion
	 * 		   Metodo get del atributo btnGrpTipoOperacion
	 * @return ButtonGroup
	 *		   Valor del atributo btnGrpTipoOperacion devuelto
	 * @author hector.cuenca
	 * @date   1/12/2016
	 */
	public ButtonGroup getBtnGrpTipoOperacion() {
		return this.btnGrpTipoOperacion;
	}

	/**
	 * @method setBtnGrpTipoOperacion
	 * 		   Metodo set del atributo btnGrpTipoOperacion
	 * @param  pBtnGrpTipoOperacion
	 *		   Valor que tomara el atributo btnGrpTipoOperacion
	 * @author hector.cuenca
	 * @date   1/12/2016
	 */
	public void setBtnGrpTipoOperacion(ButtonGroup pBtnGrpTipoOperacion) {
		this.btnGrpTipoOperacion = pBtnGrpTipoOperacion;
	}

	/**
	 * @method getRbtIngreso
	 * 		   Metodo get del atributo rbtIngreso
	 * @return BotonRadioUtil
	 *		   Valor del atributo rbtIngreso devuelto
	 * @author hector.cuenca
	 * @date   1/12/2016
	 */
	public BotonRadioUtil getRbtIngreso() {
		return this.rbtIngreso;
	}

	/**
	 * @method setRbtIngreso
	 * 		   Metodo set del atributo rbtIngreso
	 * @param  pRbtIngreso
	 *		   Valor que tomara el atributo rbtIngreso
	 * @author hector.cuenca
	 * @date   1/12/2016
	 */
	public void setRbtIngreso(BotonRadioUtil pRbtIngreso) {
		this.rbtIngreso = pRbtIngreso;
	}

	/**
	 * @method getRbtEgreso
	 * 		   Metodo get del atributo rbtEgreso
	 * @return BotonRadioUtil
	 *		   Valor del atributo rbtEgreso devuelto
	 * @author hector.cuenca
	 * @date   1/12/2016
	 */
	public BotonRadioUtil getRbtEgreso() {
		return this.rbtEgreso;
	}

	/**
	 * @method setRbtEgreso
	 * 		   Metodo set del atributo rbtEgreso
	 * @param  pRbtEgreso
	 *		   Valor que tomara el atributo rbtEgreso
	 * @author hector.cuenca
	 * @date   1/12/2016
	 */
	public void setRbtEgreso(BotonRadioUtil pRbtEgreso) {
		this.rbtEgreso = pRbtEgreso;
	}

	/**
	 * @method getLblConcepto
	 * 		   Metodo get del atributo lblConcepto
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblConcepto devuelto
	 * @author hector.cuenca
	 * @date   1/12/2016
	 */
	public EtiquetaUtil getLblConcepto() {
		return this.lblConcepto;
	}

	/**
	 * @method setLblConcepto
	 * 		   Metodo set del atributo lblConcepto
	 * @param  pLblConcepto
	 *		   Valor que tomara el atributo lblConcepto
	 * @author hector.cuenca
	 * @date   1/12/2016
	 */
	public void setLblConcepto(EtiquetaUtil pLblConcepto) {
		this.lblConcepto = pLblConcepto;
	}

	/**
	 * @method getLblTipoMovimiento
	 * 		   Metodo get del atributo lblTipoMovimiento
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblTipoMovimiento devuelto
	 * @author roberth.martinez
	 * @date   23/2/2017
	 */
	public EtiquetaUtil getLblTipoMovimiento() {
		return lblTipoMovimiento;
	}

	/**
	 * @method setLblTipoMovimiento
	 * 		   Metodo set del atributo lblTipoMovimiento
	 * @param  lblTipoMovimiento
	 *		   Valor que tomara el atributo lblTipoMovimiento
	 * @author roberth.martinez
	 * @date   23/2/2017
	 */
	public void setLblTipoMovimiento(EtiquetaUtil lblTipoMovimiento) {
		this.lblTipoMovimiento = lblTipoMovimiento;
	}

	/**
	 * @method getLblValor
	 * 		   Metodo get del atributo lblValor
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblValor devuelto
	 * @author hector.cuenca
	 * @date   1/12/2016
	 */
	public EtiquetaUtil getLblValor() {
		return this.lblValor;
	}

	/**
	 * @method setLblValor
	 * 		   Metodo set del atributo lblValor
	 * @param  pLblValor
	 *		   Valor que tomara el atributo lblValor
	 * @author hector.cuenca
	 * @date   1/12/2016
	 */
	public void setLblValor(EtiquetaUtil pLblValor) {
		this.lblValor = pLblValor;
	}

	/**
	 * @method getLblMedioPago
	 * 		   Metodo get del atributo lblMedioPago
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblMedioPago devuelto
	 * @author hector.cuenca
	 * @date   1/12/2016
	 */
	public EtiquetaUtil getLblMedioPago() {
		return this.lblMedioPago;
	}

	/**
	 * @method setLblMedioPago
	 * 		   Metodo set del atributo lblMedioPago
	 * @param  pLblMedioPago
	 *		   Valor que tomara el atributo lblMedioPago
	 * @author hector.cuenca
	 * @date   1/12/2016
	 */
	public void setLblMedioPago(EtiquetaUtil pLblMedioPago) {
		this.lblMedioPago = pLblMedioPago;
	}

	/**
	 * @method getLblDocumentoAuxiliar
	 * 		   Metodo get del atributo lblDocumentoAuxiliar
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblDocumentoAuxiliar devuelto
	 * @author hector.cuenca
	 * @date   1/12/2016
	 */
	public EtiquetaUtil getLblDocumentoAuxiliar() {
		return this.lblDocumentoAuxiliar;
	}

	/**
	 * @method setLblDocumentoAuxiliar
	 * 		   Metodo set del atributo lblDocumentoAuxiliar
	 * @param  pLblDocumentoAuxiliar
	 *		   Valor que tomara el atributo lblDocumentoAuxiliar
	 * @author hector.cuenca
	 * @date   1/12/2016
	 */
	public void setLblDocumentoAuxiliar(EtiquetaUtil pLblDocumentoAuxiliar) {
		this.lblDocumentoAuxiliar = pLblDocumentoAuxiliar;
	}

	/**
	 * @method getLblNotas
	 * 		   Metodo get del atributo lblNotas
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblNotas devuelto
	 * @author hector.cuenca
	 * @date   1/12/2016
	 */
	public EtiquetaUtil getLblNotas() {
		return this.lblNotas;
	}

	/**
	 * @method setLblNotas
	 * 		   Metodo set del atributo lblNotas
	 * @param  pLblNotas
	 *		   Valor que tomara el atributo lblNotas
	 * @author hector.cuenca
	 * @date   1/12/2016
	 */
	public void setLblNotas(EtiquetaUtil pLblNotas) {
		this.lblNotas = pLblNotas;
	}

	/** 
	 * ********************************************************************
	 * @method 	main
	 * 		   	Metodo principal (main), para realizar una prueba de unidad
	 * 			de la forma
	 * @param 	args
	 * 			Cadena de argumentos demandada por el metodo principal (main)
	 * @author 	hector.cuenca
	 * @date   	23/11/2016
	 * *********************************************************************
	 */
	public static void main(String[] args) {
		
		JFrame jframe = null;
		
		try{
	        
			jframe = TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaGiroIngresoEgreso.class,
																			true, 
																			EnumDesplegarFormaConEventos.SI);
			new FormaGiroIngresoEgreso(jframe, true);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			Logger.getInstance().error(e.getMessage());
			
		}
	}
}

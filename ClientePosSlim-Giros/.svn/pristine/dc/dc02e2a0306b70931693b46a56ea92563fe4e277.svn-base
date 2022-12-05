package co.com.codesa.clienteposslimgiros.formas.facturacion;

import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumImagenes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.operaciones.EnumTiposOperaciones;
import co.com.codesa.clienteposslimgiros.eventos.facturacion.EventoFormaEnvioFacturacion;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.BotonUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaVerificadaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.GrillaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionDesplazableUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelEncabezadoGeneral;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelFactura;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelTercero;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelTerritorio;
import co.com.codesa.clienteposslimgiros.formas.genericas.promocion.FormaPanelPromocion;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilControlCargueDataMemoria;

/**
 * ****************************************************************
 * @autor: Roberth Martinez Vargas
 * @fecha: 17-mar-2015
 * @descripcion: Clase para diligenciar los datos necesarios para 
 * 			  	 enviar giros nacionales, recaudos.
 * @copyright: Copyright  1998-2012 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class FormaEnvioFacturacion extends FormaGenerica{
	
	/**
	 * @variable 	serialVersionUID
	 * 			 	Variable serialVersionUID
	 */
	private static final long serialVersionUID = 788357040932395409L;

	/**
	 * @variable lblValorGirar
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 contiene el valor a girar
	 **/
	private EtiquetaUtil lblValorGirar;
	
	/**
	 * @variable lblPlan
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 contiene el plan tarifario
	 **/
	private EtiquetaUtil lblPlan;
	
	/**
	 * @variable lblNumeroItems
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 contiene el numero de items de la factura
	 **/
	private EtiquetaUtil lblNumeroItems;
	
	/**
	 * @variable lblTotal
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 contiene el total  de la factura
	 **/
	private EtiquetaUtil lblTotal;
	
	/**
	 * @variable lblMsgPredeterminado
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 contiene los mensajes predeterminados
	 **/
	private EtiquetaUtil lblMsgPredeterminado;
	
	/**
	 * @variable lblPromociones
	 * 			 etiqueta para indicar el componente grafico sobre la forma para 
	 * 			 la grilla promociones
	 **/
	private EtiquetaUtil lblPromociones;
	
	/**
	 * @variable lblConvenio
	 * 			 etiqueta para indicar el componente grafico sobre la forma para 
	 * 			 los convenios
	 **/
	private EtiquetaUtil lblConvenio;
	
	/**
	 * @variable lblCotizar
	 * 			 etiqueta para indicar el componente grafico sobre la forma para 
	 *           el boton cotizar
	 **/
	private EtiquetaUtil lblCotizar;
	
	/**
	 * @variable txtCodigoPlan
	 * 			 campo de texto sobre la forma que contiene el codigo del plan
	 **/
	private CajaTextoUtil txtCodigoPlan;
	
	/**
	 * @variable txtDescripcionPlan
	 * 			 campo de texto sobre la forma que contiene la descripcion 
	 * 			 del plan
	 **/
	private CajaTextoUtil txtDescripcionPlan;
	
	/**
	 * @variable txtNumeroItems
	 * 			 campo de texto sobre la forma que  contiene el numero de 
	 * 			 items de la factura
	 **/
	private CajaTextoUtil txtNumeroItems;
	
	/**
	 * @variable txtTotal
	 * 			 campo de texto sobre la forma que contiene el total de la factura
	 **/
	private CajaTextoUtil txtTotal;
	
	/**
	 * @variable txtValorGiro
	 * 			 campo de texto sobre la forma que contiene el valor a girar
	 **/
	private CajaTextoUtil txtValorGiro;
	
	/**
	 * @variable chkIncluyeFlete
	 * 			 comoponente de chequeo sobre la forma para incluir flete sobre 
	 * 		     el valor girado
	 **/
	private CajaVerificadaUtil chkIncluyeFlete;
	
	/**
	 * @variable chkDomicilio
	 * 			 comoponente de chequeo sobre la forma para activar domicilio
	 **/
	private CajaVerificadaUtil chkDomicilio;
	
	/**
	 * @variable chkIncluyeOtros
	 * 			 comoponente de chequeo sobre la forma para incluir otros cobros 
	 * 			 sobre el valor girado
	 **/
	private CajaVerificadaUtil chkIncluyeOtros;
	
	/**
	 * @variable chkIncluyeDomicilio
	 * 			 comoponente de chequeo sobre la forma para incluir domicilio 
	 * 		     sobre el valor girado
	 **/
	private CajaVerificadaUtil chkIncluyeDomicilio;
	
	/**
	 * @variable chkIncluyeTramitador
	 * 			 comoponente de chequeo sobre la forma para activar el 
	 * 			 diligenciamiento del tramitador
	 **/
	private CajaVerificadaUtil chkIncluyeTramitador;
	
	/**
	 * @variable cmbMensajesPredeterminados
	 * 			 componente de combo sobre la forma que  contiene el listado 
	 * 		     de mensajes prederterminados para la transaccion
	 **/
	private CajaComboUtil cmbMensajesPredeterminados;
	
	/**
	 * @variable grillaConceptos
	 * 			 componente grilla sobre la forma que contiene el listado 
	 * 	   	     de conceptos de la factura
	 **/
	private GrillaUtil grillaConceptos;
	
	/**
	 * @variable scrollGrillaConceptos
	 * 			 componente scrol sobre la forma para manejar el scroll 
	 * 			 del listado de conceptos de la factura
	 **/
	private SeccionDesplazableUtil scrollGrillaConceptos;
	
	/**
	 * @variable scrollConvenios
	 * 			 componente scrol sobre la forma para manejar el scroll 
	 * 			 del listado de convenios
	 **/
	private JScrollPane scrollConvenios;
	
	/**
	 * @variable lstConvenio
	 * 			 componente de lista sobre la forma que contiene el listado 
	 * 	 		 de convenios
	 **/
	private JList lstConvenio;

	/**
	 * @variable btnCotizar
	 * 			 componente boton sobre la forma para manejar la funcionalida cotizar
	 **/
	private BotonUtil btnCotizar;
	
	/**
	 * @variable pnlTerceroOrg
	 * 			 seccion que aloja los diferentes componentes graficos para 
	 * 			 gestionar la informacion asociada al tercero origen (consulta 
	 * 			 de tercero)
	 **/
	private FormaPanelTercero pnlTerceroOrg;
	
	/**
	 * @variable pnlTerceroDes
	 * 			 seccion que aloja los diferentes componentes graficos para 
	 * 			 gestionar la informacion asociada al tercero destino (consulta 
	 * 			 de tercero)
	 **/
	private FormaPanelTercero pnlTerceroDes;
	
	/**
	 * @variable pnlTerceroTramitador
	 * 			 seccion que aloja los diferentes componentes graficos para 
	 * 			 gestionar la informacion asociada al tercero tramitador (consulta 
	 * 			 de tercero)
	 **/
	private FormaPanelTercero pnlTerceroTramitador;
	
	/**
	 * @variable pnlEncabezadoFactura
	 * 			 seccion que aloja el encabezado general de factura, que 
	 * 		 	 consolida los valores de documento producto, prefijo de 
	 * 			 factura y numero de factura
	 **/
	private FormaPanelFactura pnlEncabezadoFactura;
	
	/**
	 * @variable pnlTerritorioAgenciaOrigen
	 * 			 seccion que aloja los diferentes componentes graficos que 
	 * 		 	 describen jerarquicamente el territorio al que pertenece
	 * 			 la agencia Origen
	 **/
	private FormaPanelTerritorio pnlTerritorioAgenciaOrigen;
	
	/**
	 * @variable pnlTerritorioAgenciaDestino
	 * 			 seccion que aloja los diferentes componentes graficos que 
	 * 		 	 describen jerarquicamente el territorio al que pertenece
	 * 			 la agencia destino
	 **/
	private FormaPanelTerritorio pnlTerritorioAgenciaDestino;

	/**
	 * @variable pnlEncabezadoGeneral
	 * 			 seccion que aloja el encabezado general para las formas, 
	 * 			 que contiene los valores de agencia, empresa y caja, 
	 * 			 normalmente recuperados del usuario autenticado
	 */
	private FormaPanelEncabezadoGeneral pnlEncabezadoGeneral;
	
	/**
	 * @variable 	scpPromociones
	 * 			 	Contenedor exclusivo para la gestion de promociones
	 */
	private FormaPanelPromocion	scpPromociones;
	
	/**
  	 * ****************************************************************.
  	 * @metodo FormaEnvioFacturacion
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de la forma
  	 * @param pFrmPadre 
  	 * 		  ventana de la cual extiende la pantalla de pago de giro
  	 * @param pBooModal 
  	 * 		  bandera que permite efectuar la forma de manera modal sobre 
  	 * 		  la ventana de la cual extiende
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public FormaEnvioFacturacion(JFrame pFrmPadre,
								boolean pBooModal) throws Exception{
		
		super(pFrmPadre,
			  pBooModal);
		
		UtilControlCargueDataMemoria.getInstance().verificarControlConfiguracionPasi(super.getObjUsuario(), "IDSERVEV");
		
		super.setEventoForma(new EventoFormaEnvioFacturacion(this));
		
		this.inicializarForma();
	}
	
	@Override
	public void inicializarForma(Object ...pArrObjParametrosForma) throws Exception{
		
		super.setTituloForma(EnumEtiquetas.TTL_EGP_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.FRM_EGP_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.FRM_EGP_VENTANA.getAlto());
        
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR, EnumBotonesEncabezado.BTNSALIR);
		
		super.iniciar(pArrObjParametrosForma);
	}
	
	@Override
	public JPanel inicializarEncabezado(Object ...pArrObjParametrosForma) throws Exception{
		
		JPanel pnlEncabezado;
		
		pnlEncabezado = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.JPN_EGP_PANEL_ENCABEZADO,
																	"pnlEncabezado",
		  														    null,
		  														    null,
		  														    null);
		pnlEncabezado.add(this.iniciarPropPnlEncabezadoGeneral());
		pnlEncabezado.add(this.iniciarPropPnlEncabezadoFactura());
		
		return pnlEncabezado;
	}

	@Override
	public JPanel inicializarCuerpo(Object ...pArrObjParametrosForma) throws Exception{
		
		JPanel pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.JPN_EGP_PANEL_CUERPO,
																"pnlCuerpo",
		  													 	null,
		  													 	null,
		  													 	null);
		pnlCuerpo.add(this.iniciarPropPnlTerritorioAgenciaOrigen());
		pnlCuerpo.add(this.iniciarPropPnlTerritorioAgenciaDestino());
		pnlCuerpo.add(this.iniciarPropLblConvenio());
		pnlCuerpo.add(this.iniciarPropScrollConvenios());
		
		return pnlCuerpo;
	}

	@Override
	public JPanel inicializarPiePagina(Object ...pArrObjParametrosForma) throws Exception{
		
		JPanel pnlPiePagina;
		
		pnlPiePagina = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.JPN_EGP_PANEL_PIE,
																   "pnlPiePagina",
																   null,
																   null,
																   null);
		pnlPiePagina.add(this.iniciarPropPnlTerceroOrg());
		pnlPiePagina.add(this.iniciarPropPnlTerceroDes());
		pnlPiePagina.add(this.iniciarPropPnlTerceroTramitador());
		pnlPiePagina.add(this.iniciarPropTxtValorGiro());
		pnlPiePagina.add(this.iniciarPropLblValorGirar());
		pnlPiePagina.add(this.iniciarPropLblPlan());
		pnlPiePagina.add(this.iniciarPropTxtCodigoPlan());
		pnlPiePagina.add(this.iniciarPropTxtDescripcionPlan());
		pnlPiePagina.add(this.iniciarPropChkIncluyeFlete());
		pnlPiePagina.add(this.iniciarPropChkIncluyeOtros());
		pnlPiePagina.add(this.iniciarPropChkDomicilio());
		pnlPiePagina.add(this.iniciarPropChkIncluyeDomicilio());
		pnlPiePagina.add(this.iniciarPropScrollGrillaConceptos());
		pnlPiePagina.add(this.iniciarPropLblNumeroItems());
		pnlPiePagina.add(this.iniciarPropTxtNumeroItems());
		pnlPiePagina.add(this.iniciarPropLblTotal());
		pnlPiePagina.add(this.iniciarPropTxtTotal());
		pnlPiePagina.add(this.iniciarPropLblMsgPredeterminado());
		pnlPiePagina.add(this.iniciarPropCmbMsjPred());
		pnlPiePagina.add(this.iniciarPropScpPromociones());
		pnlPiePagina.add(this.iniciarPropLblPromociones());
		pnlPiePagina.add(this.iniciarPropBtnCotizar());
		pnlPiePagina.add(this.iniciarPropLblCotizar());
		pnlPiePagina.add(this.iniciarPropChkIncluyeTramitador());
		
		this.iniciarPropPnlTerceroTramitador().setVisible(false);
		
		return pnlPiePagina;
	}
	
	/**
     * ****************************************************************
     * @method inicializarPanelEmpresaCaja
     * 		   metodo utilizado para inicializar el componente panel de 
     * 		   Empresa y caja
     * @return JPanel componente JPanel
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   4/3/2015
     * ****************************************************************
     */
	public JPanel iniciarPropPnlEncabezadoGeneral() throws Exception{
		
		if(this.pnlEncabezadoGeneral==null){
			
			this.pnlEncabezadoGeneral = new FormaPanelEncabezadoGeneral(super.getObjUsuario().getEmpresa(),
														  			    null,
														  			    super.getObjUsuario().getCaja(),
														  			    EnumDimensionesComponentes.JPN_EGP_PANEL_EMPRESACAJA,
														  			    "pnlEncabezadoGeneral");
		}
		
		return this.pnlEncabezadoGeneral;
	}
	
	/**
     * ****************************************************************
     * @method iniciarPropPnlEncabezadoFactura
     * 		   metodo utilizado para inicializar el componente panel de 
     * 		   documento Producto Numero
     * @return JPanel componente JPanel
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   4/3/2015
     * ****************************************************************
     */
	public JPanel iniciarPropPnlEncabezadoFactura() throws Exception{
		
		if(this.pnlEncabezadoFactura==null){
			
			this.pnlEncabezadoFactura = new FormaPanelFactura(this,
														  	  EnumDimensionesComponentes.JPN_EGP_PANEL_DOCFACTNUM,
														  	  "pnlEncabezadoFactura");
		}
		
		return this.pnlEncabezadoFactura;
	}
	
	/**
  	 * ****************************************************************
  	 * @method iniciarPropPnlTerritorioAgenciaOrigen
  	 * 		   Metodo estandar para autogestionar el valor del 
  	 * 		   atributo pnlTerritorioAgenciaOrigen
  	 * @return JPanel, seccion de territorio y agencia origen gestionada 
  	 * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   4/3/2015
  	 * ****************************************************************
  	 */
	public JPanel iniciarPropPnlTerritorioAgenciaOrigen() throws Exception{
		
		if(this.pnlTerritorioAgenciaOrigen==null){
			
			this.pnlTerritorioAgenciaOrigen = new FormaPanelTerritorio("pnlTerritorioAgenciaOrigen",
																	   true,//pTitulos
					   												   true,//pTituloCombo
					   												   new String[]{"cmbPaisOrigen",
																					"cmbDeptoOrigen",
																					"cmbMunicipioOrigen",
																					"cmbAgenciaOrigen"},
																	   2,//pCategoria
																	   false,//pAPartir
																	   true,//pActivaAgencia
																	   EnumDimensionesComponentes.JPN_EGP_PANEL_AGENCIA_ORG,//rectangulo
																	   null);//deptoBase
			
			this.pnlTerritorioAgenciaOrigen.getLblTituloCombos().setText(EnumEtiquetas.LBL_EGP_AGENCIA_ORG.toString());
			this.pnlTerritorioAgenciaOrigen.habilitarComponenteCompleto(false);
		}
		
		return this.pnlTerritorioAgenciaOrigen;
	}
	
	/**
  	 * ****************************************************************
  	 * @method iniciarPropPnlTerritorioAgenciaDestino
  	 * 		   Metodo estandar para autogestionar el valor del 
  	 * 		   atributo pnlTerritorioAgenciaDestino
  	 * @return JPanel, seccion de territorio y agencia destino gestionada
  	 * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   4/3/2015
  	 * ****************************************************************
  	 */
	public JPanel iniciarPropPnlTerritorioAgenciaDestino() throws Exception{
		
		if(this.pnlTerritorioAgenciaDestino==null){
			
			this.pnlTerritorioAgenciaDestino = new FormaPanelTerritorio("pnlTerritorioAgenciaDestino",
																		true,//pTitulos
																	 	false,//pTituloCombo
																	 	new String[]{"cmbPaisDestino",
								 													 "cmbDeptoDestino",
								 													 "cmbMunicipioDestino",
								 													 "cmbAgenciaDestino"},
								 										2,//pCategoria
								 										false,//pAPartir
								 										true,//pActivaAgencia
								 										EnumDimensionesComponentes.JPN_EGP_PANEL_AGENCIA_DES,//rectangulo
								 										null);//deptoBase
			
			this.pnlTerritorioAgenciaDestino.getLblTituloCombos().setText(EnumEtiquetas.LBL_EGP_AGENCIA_DES.toString());
			this.pnlTerritorioAgenciaDestino.habilitarComponenteCompleto(false);
			this.pnlTerritorioAgenciaDestino.getCmbDepartamento().addItemListener(super.getEventoForma());
			this.pnlTerritorioAgenciaDestino.getCmbMunicipio().addItemListener(super.getEventoForma());
			this.pnlTerritorioAgenciaDestino.getCmbAgencia().addItemListener(super.getEventoForma());
		}
		
		return this.pnlTerritorioAgenciaDestino;
		
	}
	
	/**
     * ****************************************************************
     * @method iniciarPropLblConvenio
     * 		   metodo utilizado para inicializar el componente EtiquetaUtil 
     * 		   de convenios
     * @return EtiquetaUtil componente EtiquetaUtil
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   4/3/2015
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblConvenio() throws Exception{
		if (this.lblConvenio == null) {
			this.lblConvenio = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_EGP_CONVENIOS, 
																	   	   "lblConvenio", 
																	   	   EnumEtiquetas.LBL_EGP_CONVENIOS,
																	   	   false,
																	   	   null,
																	   	   true);
		}

		return this.lblConvenio;
	}
	
	/**
     * ****************************************************************
     * @method iniciarPropScrollConvenios
     * 		   metodo utilizado para inicializar el componente de 
     * 		   scrollPanel para la lista de convenios
     * @return JScrollPane componente JScrollPane
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   4/3/2015
     * ****************************************************************
     */
	public JScrollPane iniciarPropScrollConvenios() throws Exception{
		
		if(this.scrollConvenios==null){
			
			this.scrollConvenios = UtilComponentesGUI.getInstance().crearScroll("scrollConvenios",
																				EnumDimensionesComponentes.SCR_EGP_LIST_CONVENIO,
																				null//BorderFactory.createEmptyBorder()
																				);
			
			this.scrollConvenios.setViewportView(this.iniciarPropLstConvenio());
		}
		return this.scrollConvenios;
	}
	
	/**
     * ****************************************************************
     * @method iniciarPropLstConvenio
     *         metodo utilizado para inicializar el componente de JList
     * 		   para la lista de convenios
     * @return JList componente JList
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   4/3/2015
     * ****************************************************************
     */
	public JList iniciarPropLstConvenio() throws Exception{
		
		if(this.lstConvenio==null){
			this.lstConvenio = UtilComponentesGUI.getInstance().crearList("lstConvenio", 
																	  	  true, 
																	  	  true, 
																	  	  ListSelectionModel.SINGLE_SELECTION, 
																	  	  super.getEventoForma());
			
		}
		return this.lstConvenio;
	}
	
	/**
     * ****************************************************************
     * @method iniciarPropPnlTerceroOrg
     *   	   metodo utilizado para inicializar el componente panel tercero origen
     * @return JPanel componente JPanel
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   4/3/2015
     * ****************************************************************
     */
	public FormaPanelTercero iniciarPropPnlTerceroOrg()throws Exception{
		
		if(this.pnlTerceroOrg==null){
			
			this.pnlTerceroOrg = new FormaPanelTercero("pnlTerceroOrg",
													   EnumEtiquetas.LBL_EGP_REMITENTE,
													   this,
													   EnumDimensionesComponentes.JPN_EGP_PANEL_TERCERO_ORG,
													   new EnumDimensionesComponentes[] {null, 
																	  					 null, 
																	  					 null, 
																	  					 EnumDimensionesComponentes.JPN_EGP_PNL_TERC_ORG_DESC, 
																	  					 EnumDimensionesComponentes.JPN_EGP_PNL_TERC_ORG_MTO},
													   null,
													   EnumParametrosApp.DESCRIPCION_TERCERO_REMITENTE.getValorPropiedad(),
													   EnumTiposOperaciones.ENVIO_FACTURACION);
			
			this.pnlTerceroOrg.getTxtIdentificacion().setName("txtIdentificacionOrg");
			this.pnlTerceroOrg.getTxtIdentificacion().addFocusListener(super.getEventoForma());
			this.pnlTerceroOrg.castEvaFrmTercero().setBooActivaValidacionBloqueadoXRiesgos(true);
			this.pnlTerceroOrg.castEvaFrmTercero().setBooActivaValidacionTerceroPeps(true);
		}
		
		return this.pnlTerceroOrg;
	}
	
	/**
     * ****************************************************************
     * @method iniciarPropPnlTerceroDes
     * 	   	   metodo utilizado para inicializar el componente panel tercero Destino
     * @return JPanel componente JPanel
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   4/3/2015
     * ****************************************************************
     */
	public JPanel iniciarPropPnlTerceroDes()throws Exception{
		
		if(this.pnlTerceroDes==null){

			this.pnlTerceroDes = new FormaPanelTercero("pnlTerceroDes",
													   EnumEtiquetas.LBL_EGP_BENEFICIARIO,
													   this,
													   EnumDimensionesComponentes.JPN_EGP_PANEL_TERCERO_DES,
													   new EnumDimensionesComponentes[] {null, 
																	  					 null, 
																	  					 null, 
																	  					 EnumDimensionesComponentes.JPN_EGP_PNL_TERC_DES_DESC, 
																	  					 EnumDimensionesComponentes.JPN_EGP_PNL_TERC_DES_MTO},
													   null,
													   EnumParametrosApp.DESCRIPCION_TERCERO_BENEFICIARIO.getValorPropiedad(),
													   EnumTiposOperaciones.ENVIO_FACTURACION);
			
			this.pnlTerceroDes.getTxtIdentificacion().setName("txtIdentificacionDes");
			this.pnlTerceroDes.getTxtIdentificacion().addFocusListener(super.getEventoForma());
			this.pnlTerceroDes.castEvaFrmTercero().setBooTerceroPresente(false);
			this.pnlTerceroDes.castEvaFrmTercero().setBooActivaValidacionBloqueadoXRiesgos(true);
			this.pnlTerceroOrg.castEvaFrmTercero().setBooActivaValidacionTerceroPeps(false);
		}
		
		return this.pnlTerceroDes;
	}
	
	/**
     * ****************************************************************
     * @method iniciarPropPnlTerceroTramitador
     * 		   metodo utilizado para inicializar el componente panel 
     * 		   tercero Tramitador
     * @return JPanel componente JPanel
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   4/3/2015
     * ****************************************************************
     */
	public JPanel iniciarPropPnlTerceroTramitador()throws Exception{
		
		if(this.pnlTerceroTramitador==null){
			  
			this.pnlTerceroTramitador = new FormaPanelTercero("pnlTerceroTramitador",
															   EnumEtiquetas.LBL_RTT_TRAMITADOR,
															   this,
															   EnumDimensionesComponentes.JPN_EGP_PANEL_TERCERO_TRA,
															   new EnumDimensionesComponentes[] {null, 
																			  					 null, 
																			  					 null, 
																			  					 EnumDimensionesComponentes.JPN_EGP_PNL_TERC_TRA_DESC, 
																			  					 EnumDimensionesComponentes.JPN_EGP_PNL_TERC_TRA_MTO},
															   null,
															   EnumParametrosApp.DESCRIPCION_TERCERO_TRAMITADOR.getValorPropiedad(),
															   EnumTiposOperaciones.ENVIO_FACTURACION);
			
			this.pnlTerceroTramitador.getTxtIdentificacion().addFocusListener(super.getEventoForma());
			this.pnlTerceroTramitador.castEvaFrmTercero().setBooTerceroPresente(true);
			this.pnlTerceroTramitador.castEvaFrmTercero().setBooActivaValidacionBloqueadoXRiesgos(true);
		}
		
		return this.pnlTerceroTramitador;
	}
	
	/**
     * ****************************************************************
     * @method iniciarPropTxtValorGiro
     * 		   metodo utilizado para inicializar el componente text 
     * 		   para el valor del giro
     * @return CajaTextoUtil componente CajaTextoUtil
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   4/3/2015
     * ****************************************************************
     */
	public CajaTextoUtil iniciarPropTxtValorGiro()throws Exception{
		
		if(this.txtValorGiro==null){
			
			this.txtValorGiro = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_EGP_VALOR_GIRO, 
																			    "txtValorGiro", 
																			    "",
																			    true, 
																			    true, 
																			    true, 
																			    super.getEventoForma(),
																			    EnumEtiquetas.LBL_EGP_VALOR_GIRAR);
			this.txtValorGiro.setHorizontalAlignment(SwingConstants.TRAILING);
			this.txtValorGiro.setForeground(new java.awt.Color(0, 0, 0));
			this.txtValorGiro.setBackground(new java.awt.Color(164, 164, 255));
		}
		
		return this.txtValorGiro;
	}
	
	/**
     * ****************************************************************
     * @method iniciarPropLblValorGirar
     *         metodo utilizado para inicializar el componente EtiquetaUtil valor a girar
     * @return EtiquetaUtil componente EtiquetaUtil
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   4/3/2015
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblValorGirar() throws Exception{
		if (this.lblValorGirar == null) {
			this.lblValorGirar = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_EGP_VALOR_GIRAR, 
																		     "lblValorGirar", 
																		     EnumEtiquetas.LBL_EGP_VALOR_GIRAR,
																		     true,
																		     null,
																		     true);
		}

		return this.lblValorGirar;
	}
	
	/**
     * ****************************************************************
     * @method iniciarPropLblPlan
     * 		   metodo utilizado para inicializar el componente EtiquetaUtil de plan tarifario
     * @return EtiquetaUtil componente EtiquetaUtil
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   4/3/2015
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblPlan() throws Exception{
		
		if (this.lblPlan == null) {
			this.lblPlan = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_EGP_PLAN_TARIFARIO, 
																   	   "lblPlan", 
																   	   EnumEtiquetas.LBL_EGP_PLAN_TARIFARIO,
																   	   true,
																   	   null,
																   	   true);
		}
		return this.lblPlan;
	}
	
	/**
     * ****************************************************************
     * @method iniciarPropTxtCodigoPlan
     * 		   metodo utilizado para inicializar el componente text para el codigo del plan tarifario
     * @return CajaTextoUtil componente CajaTextoUtil
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   4/3/2015
     * ****************************************************************
     */
	public CajaTextoUtil iniciarPropTxtCodigoPlan() throws Exception{
		
		if(this.txtCodigoPlan==null){
			
			this.txtCodigoPlan = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_EGP_COD_PLANT, 
																			     "txtCodigoPlan", 
																			     "",
																			     true, false, true, 
																			     super.getEventoForma(),
																			     null);
			
			this.txtCodigoPlan.setBackground(new java.awt.Color(164, 164, 255));
			this.txtCodigoPlan.setForeground(new java.awt.Color(0, 0, 0));
			this.txtCodigoPlan.setToolTipText(EnumEtiquetas.TLT_EGP_CODIGO_PLAN_TARIFARIO);
		}
		
		return this.txtCodigoPlan;
	}
	
	/**
     * ****************************************************************
     * @method iniciarPropTxtCodigoPlan
     * 		   metodo utilizado para inicializar el componente text 
     * 	 	   para el codigo del plan tarifario
     * @return CajaTextoUtil componente CajaTextoUtil
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   4/3/2015
     * ****************************************************************
     */
	public CajaTextoUtil iniciarPropTxtDescripcionPlan() throws Exception{
		
		if(this.txtDescripcionPlan==null){
			
			this.txtDescripcionPlan = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_EGP_DES_PLANT, 
																				      "txtDescripcionPlan", 
																				      "",
																				      true, 
																				      false, 
																				      true, 
																				      super.getEventoForma(),
																				      null);
				
			this.txtDescripcionPlan.setBackground(new java.awt.Color(164, 164, 255));
			this.txtDescripcionPlan.setForeground(new java.awt.Color(0, 0, 0));
			this.txtDescripcionPlan.setToolTipText(EnumEtiquetas.TLT_EGP_DESC_PLAN_TARIFARIO);
		}
		
		return this.txtDescripcionPlan;
	}
	
	/**
     * ****************************************************************
     * @method iniciarPropChkIncluyeFlete
     * 		   metodo utilizado para inicializar el componente 
     * 		   CajaVerificadaUtil para seleccionar si el giro incluye flete
     * @return CajaVerificadaUtil componente CajaVerificadaUtil
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   4/3/2015
     * ****************************************************************
     */	
	public CajaVerificadaUtil iniciarPropChkIncluyeFlete() throws Exception{
		if (this.chkIncluyeFlete == null) {
			this.chkIncluyeFlete = UtilComponentesGUI.getInstance().crearCheckBox(EnumDimensionesComponentes.CHK_EGP_INCLU_FLETE, 
																			  	  "chkIncluyeFlete", 
																			  	  EnumEtiquetas.CHK_EGP_INCLU_FLETE,
																			  	  true,
																			  	  true, 
																			  	  true, 
																			  	  false, 
																			  	  super.getEventoForma(),
																			  	  SwingConstants.LEFT,
																			  	  true);
		}

		return this.chkIncluyeFlete;
	}
	
	/**
     * ****************************************************************
     * @method iniciarPropChkIncluyeOtros
     * 	       metodo utilizado para inicializar el componente 
     * 		   CajaVerificadaUtil para seleccionar si el giro incluye otros
     * @return CajaVerificadaUtil componente CajaVerificadaUtil
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   4/3/2015
     * ****************************************************************
     */	
	public CajaVerificadaUtil iniciarPropChkIncluyeOtros() throws Exception{
		if (this.chkIncluyeOtros == null) {
			this.chkIncluyeOtros = UtilComponentesGUI.getInstance().crearCheckBox(EnumDimensionesComponentes.CHK_EGP_INCLU_OTROS, 
																			      "chkIncluyeOtros", 
																			      EnumEtiquetas.CHK_EGP_INCLU_OTROS,
																			      true,
																			      false, 
																			      true, 
																			      false, 
																			      super.getEventoForma(),
																			      SwingConstants.LEFT,
																			      true);
			this.chkIncluyeOtros.setText(this.chkIncluyeOtros.getText()+" ");
		}

		return this.chkIncluyeOtros;
	}
	
	/**
     * ****************************************************************
     * @method iniciarPropChkDomicilio
     * 		   metodo utilizado para inicializar el componente 
     * 	   	   CajaVerificadaUtil para seleccionar si el giro se calcula el 
     *         domicilio
     * @return CajaVerificadaUtil componente CajaVerificadaUtil
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   4/3/2015
     * ****************************************************************
     */	
	public CajaVerificadaUtil iniciarPropChkDomicilio() throws Exception{
		if (this.chkDomicilio == null) {
			this.chkDomicilio = UtilComponentesGUI.getInstance().crearCheckBox(EnumDimensionesComponentes.CHK_EGP_DOMICILIO, 
																		       "chkDomicilio", 
																		       EnumEtiquetas.CHK_EGP_DOMICILIO,
																		       true,
																		       true, 
																		       true, 
																		       false, 
																		       super.getEventoForma(),
																		       SwingConstants.LEFT,
																		       true);
			this.chkDomicilio.setText(this.chkDomicilio.getText()+"    ");
		}

		return this.chkDomicilio;
	}
	
	/**
     * ****************************************************************
     * @method iniciarPropChkIncluyeDomicilio
     * 		   metodo utilizado para inicializar el componente 
     * 		   CajaVerificadaUtil para seleccionar si el giro incluye el domicilio
     * @return CajaVerificadaUtil componente CajaVerificadaUtil
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   4/3/2015
     * ****************************************************************
     */	
	public CajaVerificadaUtil iniciarPropChkIncluyeDomicilio() throws Exception{
		if (this.chkIncluyeDomicilio == null) {
			this.chkIncluyeDomicilio = UtilComponentesGUI.getInstance().crearCheckBox(EnumDimensionesComponentes.CHK_EGP_INCLU_DOMICILIO, 
																				      "chkIncluyeDomicilio", 
																				      EnumEtiquetas.CHK_EGP_INCLU_DOMICILIO,
																				      true,
																				      false, 
																				      true, 
																				      false, 	
																				      super.getEventoForma(),
																				      SwingConstants.LEFT,
																				      true);
		}

		return this.chkIncluyeDomicilio;
	}
	
	/**
     * ****************************************************************
     * @method iniciarPropScrollGrillaConceptos
     * 		   metodo utilizado para inicializar el componente de 
     * 		   scrollPanel para la grilla de conceptos
     * @return JScrollPane
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   4/3/2015
     * ****************************************************************
     */
	public SeccionDesplazableUtil iniciarPropScrollGrillaConceptos() throws Exception{
		
		if(this.scrollGrillaConceptos==null){
			
			this.scrollGrillaConceptos = UtilComponentesGUI.getInstance().crearScroll("scrGrillaConceptos",
													 					 		  	  EnumDimensionesComponentes.GRI_EGP_GRID_CONCEPTOS,
													 					 		  	  null);
			
			this.scrollGrillaConceptos.setViewportView(this.iniciarPropGrillaConceptos());
		}
		
		return this.scrollGrillaConceptos;
	}
	
	/**
     * ****************************************************************
     * @method iniciarPropGrillaConceptos
     * 	   	   metodo utilizado para inicializar el componente de 
     * 		   grilla de conceptos
     * @return GrillaUtil
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   4/3/2015
     * ****************************************************************
     */
	public GrillaUtil iniciarPropGrillaConceptos() throws Exception{
		
		if(this.grillaConceptos==null){
			
			this.grillaConceptos = UtilComponentesGUI.getInstance().crearGrilla("tblGrillaConceptos",
															   					new EnumEtiquetas []{EnumEtiquetas.TTL_EGP_GRILLA_CONCEPTOS_CODIGO,
																							  		 EnumEtiquetas.TTL_EGP_GRILLA_CONCEPTOS_CONCEPTO,
																							  		 EnumEtiquetas.TTL_EGP_GRILLA_CONCEPTOS_VALOR},
															   					null,//invisibles
															   					new boolean[] {false, 
																							   false, 
																							   false},//editable por columna
																				new int[] {80,
																						   256,
																						   132},//dimensiones
																				null);//evento
		}
		
		return this.grillaConceptos;
	}
	
	/**
     * ****************************************************************
     * @method iniciarPropLblNumeroItems
     * 		   metodo utilizado para inicializar el componente EtiquetaUtil 
     * 		   de numero de items asociados a la factura
     * @return EtiquetaUtil componente EtiquetaUtil
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   4/3/2015
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblNumeroItems() throws Exception{
		if (this.lblNumeroItems == null) {
			this.lblNumeroItems = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_EGP_NUMER_ITEMS, 
																		  	  "lblNumeroItems", 
																		  	  EnumEtiquetas.LBL_EGP_NUMER_ITEMS,
																		  	  true,
																		  	  null,
																		  	  true);
		}

		return this.lblNumeroItems;
	}
	
	/**
     * ****************************************************************
     * @method iniciarPropTxtNumeroItems
     *    	   metodo utilizado para inicializar el componente text 
     *    	   para el numero de item de la factura
     * @return CajaTextoUtil componente CajaTextoUtil
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   4/3/2015
     * ****************************************************************
     */
	public CajaTextoUtil iniciarPropTxtNumeroItems()throws Exception{
		
		if(this.txtNumeroItems==null){
			
			this.txtNumeroItems = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_EGP_NUMER_ITEMS, 
																			  	  "txtNumeroItems", 
																			  	  "",
																			  	  true, 
																			  	  false, 
																			  	  true, 
																			  	  super.getEventoForma(),
																			  	  null);
			
			this.txtNumeroItems.setBackground(new java.awt.Color(164, 164, 255));
			this.txtNumeroItems.setForeground(new java.awt.Color(0, 0, 0));
			this.txtNumeroItems.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		
		return this.txtNumeroItems;
	}
	
	/**
     * ****************************************************************
     * @method iniciarPropLblTotal
     * 		   metodo utilizado para inicializar el componente EtiquetaUtil de total de la factura
     * @return EtiquetaUtil componente EtiquetaUtil
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   4/3/2015
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblTotal() throws Exception{
		if (this.lblTotal == null) {
			this.lblTotal = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_EGP_TOTAL, 
																		"lblTotal", 
																		EnumEtiquetas.LBL_EGP_TOTAL,
																		true,
																		null,
																		true);
		}

		return this.lblTotal;
	}
	
	/**
     * ****************************************************************
     * @method iniciarPropTxtTotal
     * 		   metodo utilizado para inicializar el componente 
     * 		   txtTotal para el total del envio
     * @return CajaTextoUtil 
     *         componente CajaTextoUtil
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   4/3/2015
     * ****************************************************************
     */
	@SuppressWarnings("static-access")
	public CajaTextoUtil iniciarPropTxtTotal()throws Exception{
		
		if(this.txtTotal==null){
			
			this.txtTotal = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_EGP_TOTAL, 
																			"txtTotal", 
																			"",
																			true, 
																			false, 
																			true, 
																			super.getEventoForma(),
																			null);
			
			this.txtTotal.setBackground(new java.awt.Color(164, 164, 255));
			this.txtTotal.setForeground(new java.awt.Color(0, 0, 0));
			this.txtTotal.setHorizontalAlignment(SwingConstants.TRAILING);
			this.txtTotal.setDefaultLocale(Locale.ENGLISH);
		}
		
		return this.txtTotal;
	}
	
	/**
     * ****************************************************************
     * @method iniciarPropLblMsgPredeterminado
     * 	       metodo utilizado para inicializar el componente EtiquetaUtil 
     * 	       de mensajes predeterminados
     * @return EtiquetaUtil componente EtiquetaUtil
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   4/3/2015
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblMsgPredeterminado() throws Exception{
		if (this.lblMsgPredeterminado == null) {
			this.lblMsgPredeterminado = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_EGP_MSG_PREDETERMINADO, 
																					"lblMsgPredeterminado", 
																					EnumEtiquetas.LBL_EGP_MSG_PREDETERMINADO,
																					true,
																					null,
																					true);
		}

		return this.lblMsgPredeterminado;
	}
	
	/**
     * ****************************************************************
     * @method iniciarPropCmbMsjPred
     * 		   metodo utilizado para inicializar el componente 
     * 		   CajaComboUtil de mensajes predeterminados
     * @return CajaComboUtil 
     * 		   componente CajaComboUtil
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   4/3/2015
     * ****************************************************************
     */	
	public CajaComboUtil iniciarPropCmbMsjPred() throws Exception{
		if (this.cmbMensajesPredeterminados == null) {
			this.cmbMensajesPredeterminados = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_EGP_MSG_PREDETERMINADO, 
																						 	 "cmbMensajesPredeterminados",
																						 	 true, 
																						 	 true,  
																						 	 null,
																						 	 EnumEtiquetas.LBL_EGP_MSG_PREDETERMINADO);
			
		}

		return this.cmbMensajesPredeterminados;
	}
	
	/**
     * ****************************************************************
     * @method iniciarPropLblPromociones
     * 		   metodo utilizado para inicializar el componente EtiquetaUtil 
     * 		   de promociones
     * @return EtiquetaUtil componente EtiquetaUtil
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   4/3/2015
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblPromociones() throws Exception{
		if (this.lblPromociones == null) {
			this.lblPromociones = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_EGP_PROMOCIONES, 
																		  	  "lblPromociones", 
																		  	  EnumEtiquetas.LBL_EGP_PROMOCIONES,
																		  	  true,
																		  	  null,
																		  	  true);
		}

		return this.lblPromociones;
	}
	
	/**
	 * ********************************************************************
	 * @method 	iniciarPropScpPromociones
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	scpPromociones
	 * @return	FormaPanelPromocion
	 * 			Contenedor para el control de promociones gestionado
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	hector.cuenca
	 * @date   	10/12/2016
	 * *********************************************************************
	 */
	public	FormaPanelPromocion	iniciarPropScpPromociones	()	throws	Exception
	{
		if	(	this.scpPromociones	==	null	)
		{
			this.scpPromociones	=	new	FormaPanelPromocion	(	this,
																EnumDimensionesComponentes.GRI_EGP_GRID_PROMO,
																"scpPromociones"
															);
		}
		
		return this.scpPromociones;
	}
	
	/**
     * ****************************************************************
     * @method iniciarPropBtnCotizar
     * 		   metodo utilizado para inicializar el componente BotonUtil 
     * 		   para cotizar giro
     * @return BotonUtil
     *         componente BotonUtil
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   4/3/2015
     * ****************************************************************
     */	
	public BotonUtil iniciarPropBtnCotizar() throws Exception{
		if (this.btnCotizar == null) {
			this.btnCotizar = UtilComponentesGUI.getInstance().crearBoton(EnumDimensionesComponentes.BTN_EGP_COTIZAR_GIRO, 
																	  	  "btnCotizar", 
																	  	  null, 
																	  	  true, 
																	  	  true, 
																	  	  super.getEventoForma(),  
																	  	  EnumImagenes.OP_COTIZAR.ajustarIcono(EnumDimensionesComponentes.BTN_EGP_COTIZAR_GIRO));
			this.btnCotizar.setBorder(BorderFactory.createEmptyBorder());
		}

		return this.btnCotizar;
	}
	
	/**
     * ****************************************************************
     * @method iniciarPropLblCotizar
     * 		   metodo utilizado para inicializar el componente EtiquetaUtil 
     * 		   cotizar giro
     * @return EtiquetaUtil 
     * 		   componente EtiquetaUtil
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   4/3/2015
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblCotizar() throws Exception{
		if (this.lblCotizar == null) {
			this.lblCotizar = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_EGP_COTIZAR_GIRO, 
																	  	  "lblCotizar", 
																	  	  EnumEtiquetas.LBL_EGP_COTIZAR_GIRO,
																	  	  false,
																	  	  null,
																	  	  true);
			this.lblCotizar.setHorizontalAlignment(SwingConstants.CENTER);
		}

		return this.lblCotizar;
	}
	
	/**
     * ****************************************************************
     * @method iniciarPropChkIncluyeTramitador
     * 		   metodo utilizado para inicializar el componente CajaVerificadaUtil 
     * 		   para seleccionar si el giro incluye tramitador
     * @return CajaVerificadaUtil componente CajaVerificadaUtil
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   4/3/2015
     * ****************************************************************
     */	
	public CajaVerificadaUtil iniciarPropChkIncluyeTramitador() throws Exception{
		if (this.chkIncluyeTramitador == null) {
			this.chkIncluyeTramitador = UtilComponentesGUI.getInstance().crearCheckBox(EnumDimensionesComponentes.CHK_EGP_INCLU_TRAMITADOR, 
																					   "chkIncluyeTramitador", 
																					   EnumEtiquetas.CHK_EGP_INCLU_TRAMITADOR, 
																					   false,
																					   true, 
																					   true, 
																					   false, 
																					   super.getEventoForma(),
																					   SwingConstants.LEFT,
																					   true);
		}

		return this.chkIncluyeTramitador;
	}
	
	/**
  	 * ****************************************************************.
  	 * @method castEvaFrmEnvioGiroPostal()
  	 * 		   Metodo estandar para formatear el tipo de dato general 
  	 * 		   a un tipo especifico ("Casteo"), del atributo
  	 * 		   super.getEventoForma()
  	 * @return EventoFormaEnvioFacturacion 
  	 * 		   valor especifico recuperado
  	 * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   4/3/2015
  	 * ****************************************************************
  	 */
	public EventoFormaEnvioFacturacion castEvaFrmEnvioGiroPostal()throws Exception{
		return (EventoFormaEnvioFacturacion)super.getEventoForma();
	}

	/**
	 * @method getPnlTerceroOrg
	 * 		   Metodo get del atributo pnlTerceroOrg
	 * @return FormaPanelTercero
	 *		   Valor del atributo pnlTerceroOrg devuelto
	 * @author roberth.martinez
	 * @date   23/3/2016
	 */
	public FormaPanelTercero getPnlTerceroOrg() {
		return this.pnlTerceroOrg;
	}

	/**
	 * @method setPnlTerceroOrg
	 * 		   Metodo set del atributo pnlTerceroOrg
	 * @param  pPnlTerceroOrg
	 *		   Valor que tomara el atributo pnlTerceroOrg
	 * @author roberth.martinez
	 * @date   23/3/2016
	 */
	public void setPnlTerceroOrg(FormaPanelTercero pPnlTerceroOrg) {
		this.pnlTerceroOrg = pPnlTerceroOrg;
	}

	/**
	 * @method getLblValorGirar
	 * 		   Metodo get del atributo lblValorGirar
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblValorGirar devuelto
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public EtiquetaUtil getLblValorGirar() {
		return this.lblValorGirar;
	}

	/**
	 * @method setLblValorGirar
	 * 		   Metodo set del atributo lblValorGirar
	 * @param  pLblValorGirar
	 *		   Valor que tomara el atributo lblValorGirar
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public void setLblValorGirar(EtiquetaUtil pLblValorGirar) {
		this.lblValorGirar = pLblValorGirar;
	}

	/**
	 * @method getLblPlan
	 * 		   Metodo get del atributo lblPlan
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblPlan devuelto
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public EtiquetaUtil getLblPlan() {
		return this.lblPlan;
	}

	/**
	 * @method setLblPlan
	 * 		   Metodo set del atributo lblPlan
	 * @param  pLblPlan
	 *		   Valor que tomara el atributo lblPlan
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public void setLblPlan(EtiquetaUtil pLblPlan) {
		this.lblPlan = pLblPlan;
	}

	/**
	 * @method getLblNumeroItems
	 * 		   Metodo get del atributo lblNumeroItems
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblNumeroItems devuelto
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public EtiquetaUtil getLblNumeroItems() {
		return this.lblNumeroItems;
	}

	/**
	 * @method setLblNumeroItems
	 * 		   Metodo set del atributo lblNumeroItems
	 * @param  pLblNumeroItems
	 *		   Valor que tomara el atributo lblNumeroItems
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public void setLblNumeroItems(EtiquetaUtil pLblNumeroItems) {
		this.lblNumeroItems = pLblNumeroItems;
	}

	/**
	 * @method getLblTotal
	 * 		   Metodo get del atributo lblTotal
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblTotal devuelto
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public EtiquetaUtil getLblTotal() {
		return this.lblTotal;
	}

	/**
	 * @method setLblTotal
	 * 		   Metodo set del atributo lblTotal
	 * @param  pLblTotal
	 *		   Valor que tomara el atributo lblTotal
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public void setLblTotal(EtiquetaUtil pLblTotal) {
		this.lblTotal = pLblTotal;
	}

	/**
	 * @method getLblMsgPredeterminado
	 * 		   Metodo get del atributo lblMsgPredeterminado
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblMsgPredeterminado devuelto
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public EtiquetaUtil getLblMsgPredeterminado() {
		return this.lblMsgPredeterminado;
	}

	/**
	 * @method setLblMsgPredeterminado
	 * 		   Metodo set del atributo lblMsgPredeterminado
	 * @param  pLblMsgPredeterminado
	 *		   Valor que tomara el atributo lblMsgPredeterminado
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public void setLblMsgPredeterminado(EtiquetaUtil pLblMsgPredeterminado) {
		this.lblMsgPredeterminado = pLblMsgPredeterminado;
	}

	/**
	 * @method getLblPromociones
	 * 		   Metodo get del atributo lblPromociones
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblPromociones devuelto
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public EtiquetaUtil getLblPromociones() {
		return this.lblPromociones;
	}

	/**
	 * @method setLblPromociones
	 * 		   Metodo set del atributo lblPromociones
	 * @param  pLblPromociones
	 *		   Valor que tomara el atributo lblPromociones
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public void setLblPromociones(EtiquetaUtil pLblPromociones) {
		this.lblPromociones = pLblPromociones;
	}

	/**
	 * @method getLblConvenio
	 * 		   Metodo get del atributo lblConvenio
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblConvenio devuelto
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public EtiquetaUtil getLblConvenio() {
		return this.lblConvenio;
	}

	/**
	 * @method setLblConvenio
	 * 		   Metodo set del atributo lblConvenio
	 * @param  pLblConvenio
	 *		   Valor que tomara el atributo lblConvenio
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public void setLblConvenio(EtiquetaUtil pLblConvenio) {
		this.lblConvenio = pLblConvenio;
	}

	/**
	 * @method getLblCotizar
	 * 		   Metodo get del atributo lblCotizar
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblCotizar devuelto
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public EtiquetaUtil getLblCotizar() {
		return this.lblCotizar;
	}

	/**
	 * @method setLblCotizar
	 * 		   Metodo set del atributo lblCotizar
	 * @param  pLblCotizar
	 *		   Valor que tomara el atributo lblCotizar
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public void setLblCotizar(EtiquetaUtil pLblCotizar) {
		this.lblCotizar = pLblCotizar;
	}

	/**
	 * @method getTxtCodigoPlan
	 * 		   Metodo get del atributo txtCodigoPlan
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtCodigoPlan devuelto
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public CajaTextoUtil getTxtCodigoPlan() {
		return this.txtCodigoPlan;
	}

	/**
	 * @method setTxtCodigoPlan
	 * 		   Metodo set del atributo txtCodigoPlan
	 * @param  pTxtCodigoPlan
	 *		   Valor que tomara el atributo txtCodigoPlan
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public void setTxtCodigoPlan(CajaTextoUtil pTxtCodigoPlan) {
		this.txtCodigoPlan = pTxtCodigoPlan;
	}

	/**
	 * @method getTxtDescripcionPlan
	 * 		   Metodo get del atributo txtDescripcionPlan
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtDescripcionPlan devuelto
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public CajaTextoUtil getTxtDescripcionPlan() {
		return this.txtDescripcionPlan;
	}

	/**
	 * @method setTxtDescripcionPlan
	 * 		   Metodo set del atributo txtDescripcionPlan
	 * @param  pTxtDescripcionPlan
	 *		   Valor que tomara el atributo txtDescripcionPlan
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public void setTxtDescripcionPlan(CajaTextoUtil pTxtDescripcionPlan) {
		this.txtDescripcionPlan = pTxtDescripcionPlan;
	}

	/**
	 * @method getTxtNumeroItems
	 * 		   Metodo get del atributo txtNumeroItems
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtNumeroItems devuelto
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public CajaTextoUtil getTxtNumeroItems() {
		return this.txtNumeroItems;
	}

	/**
	 * @method setTxtNumeroItems
	 * 		   Metodo set del atributo txtNumeroItems
	 * @param  pTxtNumeroItems
	 *		   Valor que tomara el atributo txtNumeroItems
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public void setTxtNumeroItems(CajaTextoUtil pTxtNumeroItems) {
		this.txtNumeroItems = pTxtNumeroItems;
	}

	/**
	 * @method getTxtTotal
	 * 		   Metodo get del atributo txtTotal
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtTotal devuelto
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public CajaTextoUtil getTxtTotal() {
		return this.txtTotal;
	}

	/**
	 * @method setTxtTotal
	 * 		   Metodo set del atributo txtTotal
	 * @param  pTxtTotal
	 *		   Valor que tomara el atributo txtTotal
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public void setTxtTotal(CajaTextoUtil pTxtTotal) {
		this.txtTotal = pTxtTotal;
	}

	/**
	 * @method getTxtValorGiro
	 * 		   Metodo get del atributo txtValorGiro
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtValorGiro devuelto
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public CajaTextoUtil getTxtValorGiro() {
		return this.txtValorGiro;
	}

	/**
	 * @method setTxtValorGiro
	 * 		   Metodo set del atributo txtValorGiro
	 * @param  pTxtValorGiro
	 *		   Valor que tomara el atributo txtValorGiro
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public void setTxtValorGiro(CajaTextoUtil pTxtValorGiro) {
		this.txtValorGiro = pTxtValorGiro;
	}

	/**
	 * @method getChkIncluyeFlete
	 * 		   Metodo get del atributo chkIncluyeFlete
	 * @return CajaVerificadaUtil
	 *		   Valor del atributo chkIncluyeFlete devuelto
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public CajaVerificadaUtil getChkIncluyeFlete() {
		return this.chkIncluyeFlete;
	}

	/**
	 * @method setChkIncluyeFlete
	 * 		   Metodo set del atributo chkIncluyeFlete
	 * @param  pChkIncluyeFlete
	 *		   Valor que tomara el atributo chkIncluyeFlete
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public void setChkIncluyeFlete(CajaVerificadaUtil pChkIncluyeFlete) {
		this.chkIncluyeFlete = pChkIncluyeFlete;
	}

	/**
	 * @method getChkDomicilio
	 * 		   Metodo get del atributo chkDomicilio
	 * @return CajaVerificadaUtil
	 *		   Valor del atributo chkDomicilio devuelto
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public CajaVerificadaUtil getChkDomicilio() {
		return this.chkDomicilio;
	}

	/**
	 * @method setChkDomicilio
	 * 		   Metodo set del atributo chkDomicilio
	 * @param  pChkDomicilio
	 *		   Valor que tomara el atributo chkDomicilio
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public void setChkDomicilio(CajaVerificadaUtil pChkDomicilio) {
		this.chkDomicilio = pChkDomicilio;
	}

	/**
	 * @method getChkIncluyeOtros
	 * 		   Metodo get del atributo chkIncluyeOtros
	 * @return CajaVerificadaUtil
	 *		   Valor del atributo chkIncluyeOtros devuelto
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public CajaVerificadaUtil getChkIncluyeOtros() {
		return this.chkIncluyeOtros;
	}

	/**
	 * @method setChkIncluyeOtros
	 * 		   Metodo set del atributo chkIncluyeOtros
	 * @param  pChkIncluyeOtros
	 *		   Valor que tomara el atributo chkIncluyeOtros
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public void setChkIncluyeOtros(CajaVerificadaUtil pChkIncluyeOtros) {
		this.chkIncluyeOtros = pChkIncluyeOtros;
	}

	/**
	 * @method getChkIncluyeDomicilio
	 * 		   Metodo get del atributo chkIncluyeDomicilio
	 * @return CajaVerificadaUtil
	 *		   Valor del atributo chkIncluyeDomicilio devuelto
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public CajaVerificadaUtil getChkIncluyeDomicilio() {
		return this.chkIncluyeDomicilio;
	}

	/**
	 * @method setChkIncluyeDomicilio
	 * 		   Metodo set del atributo chkIncluyeDomicilio
	 * @param  pChkIncluyeDomicilio
	 *		   Valor que tomara el atributo chkIncluyeDomicilio
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public void setChkIncluyeDomicilio(CajaVerificadaUtil pChkIncluyeDomicilio) {
		this.chkIncluyeDomicilio = pChkIncluyeDomicilio;
	}

	/**
	 * @method getChkIncluyeTramitador
	 * 		   Metodo get del atributo chkIncluyeTramitador
	 * @return CajaVerificadaUtil
	 *		   Valor del atributo chkIncluyeTramitador devuelto
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public CajaVerificadaUtil getChkIncluyeTramitador() {
		return this.chkIncluyeTramitador;
	}

	/**
	 * @method setChkIncluyeTramitador
	 * 		   Metodo set del atributo chkIncluyeTramitador
	 * @param  pChkIncluyeTramitador
	 *		   Valor que tomara el atributo chkIncluyeTramitador
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public void setChkIncluyeTramitador(CajaVerificadaUtil pChkIncluyeTramitador) {
		this.chkIncluyeTramitador = pChkIncluyeTramitador;
	}

	/**
	 * @method getCmbMensajesPredeterminados
	 * 		   Metodo get del atributo cmbMensajesPredeterminados
	 * @return CajaComboUtil
	 *		   Valor del atributo cmbMensajesPredeterminados devuelto
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public CajaComboUtil getCmbMensajesPredeterminados() {
		return this.cmbMensajesPredeterminados;
	}

	/**
	 * @method setCmbMensajesPredeterminados
	 * 		   Metodo set del atributo cmbMensajesPredeterminados
	 * @param  pCmbMensajesPredeterminados
	 *		   Valor que tomara el atributo cmbMensajesPredeterminados
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public void setCmbMensajesPredeterminados(
			CajaComboUtil pCmbMensajesPredeterminados) {
		this.cmbMensajesPredeterminados = pCmbMensajesPredeterminados;
	}

	/**
	 * @method getGrillaConceptos
	 * 		   Metodo get del atributo grillaConceptos
	 * @return GrillaUtil
	 *		   Valor del atributo grillaConceptos devuelto
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public GrillaUtil getGrillaConceptos() {
		return this.grillaConceptos;
	}

	/**
	 * @method setGrillaConceptos
	 * 		   Metodo set del atributo grillaConceptos
	 * @param  pGrillaConceptos
	 *		   Valor que tomara el atributo grillaConceptos
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public void setGrillaConceptos(GrillaUtil pGrillaConceptos) {
		this.grillaConceptos = pGrillaConceptos;
	}

	/**
	 * @method getScrollGrillaConceptos
	 * 		   Metodo get del atributo scrollGrillaConceptos
	 * @return SeccionDesplazableUtil
	 *		   Valor del atributo scrollGrillaConceptos devuelto
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public SeccionDesplazableUtil getScrollGrillaConceptos() {
		return this.scrollGrillaConceptos;
	}

	/**
	 * @method setScrollGrillaConceptos
	 * 		   Metodo set del atributo scrollGrillaConceptos
	 * @param  pScrollGrillaConceptos
	 *		   Valor que tomara el atributo scrollGrillaConceptos
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public void setScrollGrillaConceptos(
			SeccionDesplazableUtil pScrollGrillaConceptos) {
		this.scrollGrillaConceptos = pScrollGrillaConceptos;
	}

	/**
	 * @method getScrollConvenios
	 * 		   Metodo get del atributo scrollConvenios
	 * @return JScrollPane
	 *		   Valor del atributo scrollConvenios devuelto
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public JScrollPane getScrollConvenios() {
		return this.scrollConvenios;
	}

	/**
	 * @method setScrollConvenios
	 * 		   Metodo set del atributo scrollConvenios
	 * @param  pScrollConvenios
	 *		   Valor que tomara el atributo scrollConvenios
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public void setScrollConvenios(JScrollPane pScrollConvenios) {
		this.scrollConvenios = pScrollConvenios;
	}

	/**
	 * @method getLstConvenio
	 * 		   Metodo get del atributo lstConvenio
	 * @return JList
	 *		   Valor del atributo lstConvenio devuelto
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public JList getLstConvenio() {
		return this.lstConvenio;
	}

	/**
	 * @method setLstConvenio
	 * 		   Metodo set del atributo lstConvenio
	 * @param  pLstConvenio
	 *		   Valor que tomara el atributo lstConvenio
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public void setLstConvenio(JList pLstConvenio) {
		this.lstConvenio = pLstConvenio;
	}

	/**
	 * @method getBtnCotizar
	 * 		   Metodo get del atributo btnCotizar
	 * @return BotonUtil
	 *		   Valor del atributo btnCotizar devuelto
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public BotonUtil getBtnCotizar() {
		return this.btnCotizar;
	}

	/**
	 * @method setBtnCotizar
	 * 		   Metodo set del atributo btnCotizar
	 * @param  pBtnCotizar
	 *		   Valor que tomara el atributo btnCotizar
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public void setBtnCotizar(BotonUtil pBtnCotizar) {
		this.btnCotizar = pBtnCotizar;
	}

	/**
	 * @method getPnlTerceroDes
	 * 		   Metodo get del atributo pnlTerceroDes
	 * @return FormaPanelTercero
	 *		   Valor del atributo pnlTerceroDes devuelto
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public FormaPanelTercero getPnlTerceroDes() {
		return this.pnlTerceroDes;
	}

	/**
	 * @method setPnlTerceroDes
	 * 		   Metodo set del atributo pnlTerceroDes
	 * @param  pPnlTerceroDes
	 *		   Valor que tomara el atributo pnlTerceroDes
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public void setPnlTerceroDes(FormaPanelTercero pPnlTerceroDes) {
		this.pnlTerceroDes = pPnlTerceroDes;
	}

	/**
	 * @method getPnlTerceroTra
	 * 		   Metodo get del atributo pnlTerceroTramitador
	 * @return FormaPanelTercero
	 *		   Valor del atributo pnlTerceroTramitador devuelto
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public FormaPanelTercero getPnlTerceroTra() {
		return this.pnlTerceroTramitador;
	}

	/**
	 * @method setPnlTerceroTra
	 * 		   Metodo set del atributo pnlTerceroTramitador
	 * @param  pPnlTerceroTra
	 *		   Valor que tomara el atributo pnlTerceroTramitador
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public void setPnlTerceroTra(FormaPanelTercero pPnlTerceroTra) {
		this.pnlTerceroTramitador = pPnlTerceroTra;
	}

	/**
	 * @method getPnlEncabezadoFactura
	 * 		   Metodo get del atributo pnlEncabezadoFactura
	 * @return FormaPanelFactura
	 *		   Valor del atributo pnlEncabezadoFactura devuelto
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public FormaPanelFactura getPnlEncabezadoFactura() {
		return this.pnlEncabezadoFactura;
	}

	/**
	 * @method setPnlEncabezadoFactura
	 * 		   Metodo set del atributo pnlEncabezadoFactura
	 * @param  pPnlEncabezadoFactura
	 *		   Valor que tomara el atributo pnlEncabezadoFactura
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public void setPnlEncabezadoFactura(FormaPanelFactura pPnlEncabezadoFactura) {
		this.pnlEncabezadoFactura = pPnlEncabezadoFactura;
	}

	/**
	 * @method getPnlTerritorioAgenciaOrigen
	 * 		   Metodo get del atributo pnlTerritorioAgenciaOrigen
	 * @return FormaPanelTerritorio
	 *		   Valor del atributo pnlTerritorioAgenciaOrigen devuelto
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public FormaPanelTerritorio getPnlTerritorioAgenciaOrigen() {
		return this.pnlTerritorioAgenciaOrigen;
	}

	/**
	 * @method setPnlTerritorioAgenciaOrigen
	 * 		   Metodo set del atributo pnlTerritorioAgenciaOrigen
	 * @param  pPnlTerritorioAgenciaOrigen
	 *		   Valor que tomara el atributo pnlTerritorioAgenciaOrigen
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public void setPnlTerritorioAgenciaOrigen(
			FormaPanelTerritorio pPnlTerritorioAgenciaOrigen) {
		this.pnlTerritorioAgenciaOrigen = pPnlTerritorioAgenciaOrigen;
	}

	/**
	 * @method getPnlTerritorioAgenciaDestino
	 * 		   Metodo get del atributo pnlTerritorioAgenciaDestino
	 * @return FormaPanelTerritorio
	 *		   Valor del atributo pnlTerritorioAgenciaDestino devuelto
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public FormaPanelTerritorio getPnlTerritorioAgenciaDestino() {
		return this.pnlTerritorioAgenciaDestino;
	}

	/**
	 * @method setPnlTerritorioAgenciaDestino
	 * 		   Metodo set del atributo pnlTerritorioAgenciaDestino
	 * @param  pPnlTerritorioAgenciaDestino
	 *		   Valor que tomara el atributo pnlTerritorioAgenciaDestino
	 * @author hector.cuenca
	 * @date   5/12/2016
	 */
	public void setPnlTerritorioAgenciaDestino(
			FormaPanelTerritorio pPnlTerritorioAgenciaDestino) {
		this.pnlTerritorioAgenciaDestino = pPnlTerritorioAgenciaDestino;
	}

	/**
	 * @method getPnlEncabezadoGeneral
	 * 		   Metodo get del atributo pnlEncabezadoGeneral
	 * @return FormaPanelEncabezadoGeneral
	 *		   Valor del atributo pnlEncabezadoGeneral devuelto
	 * @author hector.cuenca
	 * @date   5/12/2016
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
	 * @date   5/12/2016
	 */
	public void setPnlEncabezadoGeneral(
			FormaPanelEncabezadoGeneral pPnlEncabezadoGeneral) {
		this.pnlEncabezadoGeneral = pPnlEncabezadoGeneral;
	}

	/**
	 * @method getScpPromociones
	 * 		   Metodo get del atributo scpPromociones
	 * @return FormaPanelPromocion
	 *		   Valor del atributo scpPromociones devuelto
	 * @author hector.cuenca
	 * @date   9/12/2016
	 */
	public FormaPanelPromocion getScpPromociones() {
		return scpPromociones;
	}

	/**
	 * @method setScpPromociones
	 * 		   Metodo set del atributo scpPromociones
	 * @param  pScpPromociones
	 *		   Valor que tomara el atributo scpPromociones
	 * @author hector.cuenca
	 * @date   9/12/2016
	 */
	public void setScpPromociones(FormaPanelPromocion pScpPromociones) {
		this.scpPromociones = pScpPromociones;
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
			
			jframe = TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaEnvioFacturacion.class,
																			true, 
																			EnumDesplegarFormaConEventos.SI);
			new FormaEnvioFacturacion(jframe,
									  true);
			
		} catch (Exception e) {
			
			UtilidadesGiros.getInstance().controlExcepcion(e, 
														   null);
		}
	}
}

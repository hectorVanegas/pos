package co.com.codesa.clienteposslimgiros.formas.pago;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.operaciones.EnumTiposOperaciones;
import co.com.codesa.clienteposslimgiros.eventos.pago.EventoFormaPagoGiro;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.AreaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaVerificadaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.GrillaUtil;
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
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;

/**
 * ****************************************************************.
 * @autor: Hector Q-en-K
 * @fecha: 24-mar-2015 
 * @descripcion: Clase que genera la forma (GUI) para el proceso de 
 * 				 pago de giro
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class FormaPagoGiro extends FormaGenerica{

	/**
	 * @variable serialVersionUID
	 * 			 variable serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @variable 	scpPromociones
	 * 			 	Contenedor exclusivo para la gestion de promociones
	 */
	private FormaPanelPromocion	scpPromociones;
	
	/**
	 * @variable pnlEncabezadoGeneral
	 * 			 seccion que aloja el encabezado general para las formas, 
	 * 			 que contiene los valores de agencia, empresa y caja, 
	 * 			 normalmente recuperados del usuario autenticado
	 **/
	private FormaPanelEncabezadoGeneral pnlEncabezadoGeneral;
	
	/**
	 * @variable pnlEncabezadoFactura
	 * 			 seccion que aloja el encabezado general de factura, que 
	 * 		 	 consolida los valores de documento producto, prefijo de 
	 * 			 factura y numero de factura
	 **/
	private FormaPanelFactura pnlEncabezadoFactura;
	
	/**
	 * @variable pnlTerritorioAgenciaPago
	 * 			 seccion que aloja los diferentes componentes graficos que 
	 * 		 	 describen jerarquicamente el territorio al que pertenece
	 * 			 la agencia de pago
	 **/
	private FormaPanelTerritorio pnlTerritorioAgenciaPago;
	
	/**
	 * @variable pnlTerritorioAgenciaOrigen
	 * 			 seccion que aloja los diferentes componentes graficos que 
	 * 			 describen jerarquicamente el territorio al que pertenece
	 * 			 la agencia origen de la transaccion
	 **/
	private FormaPanelTerritorio pnlTerritorioAgenciaOrigen;
	
	/**
	 * @variable pnlTerritorioAgenciaDestino
	 * 			 seccion que aloja los diferentes componentes graficos que 
	 * 			 describen jerarquicamente el territorio al que pertenece
	 * 			 la agencia destino de la transaccion
	 **/
	private FormaPanelTerritorio pnlTerritorioAgenciaDestino;
	
	/**
	 * @variable pnlTerceroOrigen
	 * 			 seccion que aloja los diferentes componentes graficos para 
	 * 			 gestionar la informacion asociada al tercero origen (consulta 
	 * 			 de tercero)
	 **/
	private FormaPanelTercero pnlTerceroOrigen;
	
	/**
	 * @variable pnlTerceroDestino
	 * 			 seccion que aloja los diferentes componentes graficos para 
	 * 			 gestionar la informacion asociada al tercero destino (consulta 
	 * 			 de tercero)
	 **/
	private FormaPanelTercero pnlTerceroDestino;
	
	/**
	 * @variable lblGrillaConceptos
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 contiene el listado de conceptos involucrados en la transaccion
	 **/
	private EtiquetaUtil lblGrillaConceptos;
	
	/**
	 * @variable scpGrillaConceptos 
	 * 			 componente grafico que permite incluir barras de desplazamiento 
	 * 			 para facilitar el despliegue de la grilla de conceptos
	 **/
	private JScrollPane scpGrillaConceptos;
	
	/**
	 * @variable tblConceptos
	 * 			 grilla donde se relaciona la informacion asociada a los conceptos 
	 * 			 involucrados en la transaccion
	 **/
	private GrillaUtil tblConceptos;
	
	/**
	 * @variable lblReferencia
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 contiene la referencia del giro (pin)
	 **/
	private EtiquetaUtil lblReferencia;
	
	/**
	 * @variable txtReferencia
	 * 			 componente dedicado a contener el valor de la referencia o pin del 
	 * 			 giro en el proceso de pago
	 **/
	private CajaTextoUtil txtReferencia;
	
	/**
	 * @variable lblNumeroItems
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 contiene la cantidad total de items listados sobre la grilla de 
	 * 			 conceptos
	 **/
	private EtiquetaUtil lblNumeroItems;
	
	/**
	 * @variable txtNumeroItems
	 * 			 componente dedicado a contener la cantidad total de items listados 
	 * 			 sobre la grilla de conceptos
	 **/
	private CajaTextoUtil txtNumeroItems;
	
	/**
	 * @variable lblTotalXItems
	 * 			 etiqueta para indicar el componente grafico sobre la forma que contiene 
	 * 			 el valor total que presenta los conceptos involucrados en la grilla
	 **/
	private EtiquetaUtil lblTotalXItems;
	
	/**
	 * @variable txtTotalXItems
	 * 			 componente dedicado a contener el valor total que presenta los conceptos 
	 * 			 involucrados en la grilla
	 **/
	private CajaTextoUtil txtTotalXItems;
	
	/**
	 * @variable lblGrillaPromociones
	 * 			 etiqueta para indicar el componente grafico sobre la forma que contiene 
	 * 			 el listado de promociones involucradas en la transaccion
	 **/
	private EtiquetaUtil lblGrillaPromociones;
	
	/**
	 * @variable scpGrillaPromociones
	 * 			 componente grafico que permite incluir barras de desplazamiento para 
	 * 			 facilitar el despliegue de la grilla de promociones
	 **/
	//private JScrollPane scpGrillaPromociones;
	
	/**
	 * @variable tblPromociones
	 * 			 grilla donde se relaciona la informacion asociada a las promociones 
	 * 			 involucradas en la transaccion
	 **/
	//private GrillaUtil tblPromociones;
	
	/**
	 * @variable chkIncluyeApoderado
	 * 			 comoponente de chequeo sobre la forma para activar el 
	 * 			 diligenciamiento del apoderado
	 **/
	private CajaVerificadaUtil chkIncluyeApoderado;
	
	/**
	 * @variable pnlTerceroApoderado
	 * 			 seccion que aloja los diferentes componentes graficos para 
	 * 			 gestionar la informacion asociada al tercero Apoderado (consulta 
	 * 			 de tercero)
	 **/
	private FormaPanelTercero pnlTerceroApoderado;
	
	/**
	 * @variable lblNotas
	 * 			 etiqueta para indicar el componente grafico sobre la forma que contiene 
	 * 			 las notas asociadas al giro
	 **/
	private EtiquetaUtil lblNotas;
	
	/**
	 * @variable scpAreaTextoNotas
	 * 			 componente grafico que permite incluir barras de desplazamiento para 
	 * 			 facilitar el despliegue del area de texto para notas
	 **/
	private JScrollPane scpAreaTextoNotas;
	
	/**
	 * @variable txaNotas
	 * 			 campo de texto donde se relacionara la informacion de las notas asociadas 
	 * 			 al giro
	 **/
	private AreaTextoUtil txaNotas;

	/**
  	 * ****************************************************************.
  	 * @metodo FormaPagoGiro
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de la forma
  	 * @param pFrmPadre 
  	 * 		  ventana de la cual extiende la pantalla de pago de giro
  	 * @param pBooModal 
  	 * 		  bandera que permite efectuar la forma de manera modal sobre 
  	 * 		  la ventana de la cual extiende
  	 * @param pFacturaGiro 
  	 * 		  objeto factura, recuperado previamente bajo la opcion de 
  	 * 		  consulta
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaPagoGiro(FormaGenerica pFrmPadre,
						 boolean pBooModal,
						 FacturaGiro pFacturaGiro) throws Exception{
		
		super(pFrmPadre,
			  pBooModal);
		
		UtilControlCargueDataMemoria.getInstance().verificarControlConfiguracionPasi(super.getObjUsuario(), "IDSERVEV");
		
		super.setBooDesaparecerVentanaPadre(true);
		
		super.setEventoForma(new EventoFormaPagoGiro(this,
													 pFacturaGiro));
		this.inicializarForma();
	}

	/**
  	 * ****************************************************************.
  	 * @metodo inicializarForma
  	 * 		   Metodo propuesto por la forma generica, para inicializar 
  	 * 		   todos los aspectos de la forma
  	 * @param pArrObjParametrosForma
  	 * 		  lista de posibles parametros a incluir sobre la inicializacion 
  	 * 		  de la forma
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public void inicializarForma(Object ...pArrObjParametrosForma) throws Exception{
		
		super.setTituloForma(EnumEtiquetas.TTL_PG_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.GUI_PG_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.GUI_PG_VENTANA.getAlto());
		
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
								EnumBotonesEncabezado.BTNVOLVER,
						  		EnumBotonesEncabezado.BTNSALIR);
		
		super.iniciar(pArrObjParametrosForma);		
	}

	/**
  	 * ****************************************************************.
  	 * @metodo inicializarEncabezado
  	 * 		   Metodo dedicado a inicializar y gestionar el encabezado 
  	 * 		   de la forma (seccion superior)
  	 * @param pArrObjParametrosEncabezado
  	 * 		  lista de posibles parametros a incluir sobre la inicializacion 
  	 * 		  de la seccion del encabezado
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public JPanel inicializarEncabezado(Object ...pArrObjParametrosEncabezado) throws Exception {
		
		JPanel pnlEncabezado;
		
		pnlEncabezado = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_PG_ENCABEZADO,
																	"pnlEncabezado",
		  														 	null,
		  														 	null,
		  														 	null);
		pnlEncabezado.add(this.iniciarPropPnlEncabezadoGeneral());
		pnlEncabezado.add(this.iniciarPropPnlEncabezadoFactura());
		pnlEncabezado.add(this.iniciarPropLblReferencia());
		pnlEncabezado.add(this.iniciarPropTxtReferencia());
		
		return pnlEncabezado;
	}

	/**
  	 * ****************************************************************.
  	 * @metodo inicializarCuerpo
  	 * 		   Metodo dedicado a inicializar y gestionar el cuerpo de la 
  	 * 		   forma (seccion media)
  	 * @param pArrObjParametrosCuerpo
  	 * 		  lista de posibles parametros a incluir sobre la inicializacion 
  	 * 		  de la seccion del cuerpo
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public JPanel inicializarCuerpo(Object ...pArrObjParametrosCuerpo) throws Exception{
		
		JPanel pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_PG_CUERPO,
																"pnlCuerpo",
			  													null,
			  													null,
			  													null);
		pnlCuerpo.add(this.iniciarPropPnlTerritorioAgenciaPago());
		pnlCuerpo.add(this.iniciarPropPnlTerritorioAgenciaOrigen());
		pnlCuerpo.add(this.iniciarPropPnlTerritorioAgenciaDestino());
		
		return pnlCuerpo;
	}

	/**
  	 * ****************************************************************.
  	 * @metodo inicializarPiePagina
  	 * 		   Metodo dedicado a inicializar y gestionar el pie de pagina 
  	 * 		   de la forma (seccion inferior)
  	 * @param pArrObjParametrosPiePagina
  	 * 		  lista de posibles parametros a incluir sobre la inicializacion 
  	 * 		  de la seccion de pie de pagina
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public JPanel inicializarPiePagina(Object ...pArrObjParametrosPiePagina) throws Exception{
		
		JPanel pnlPiePagina;
		
		pnlPiePagina = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_PG_PIE_PAGINA,
																   "pnlPiePagina",
	  	 														   null,
	  	 														   null,
	  	 														   null);
		pnlPiePagina.add(this.iniciarPropPnlTerceroOrigen());
		pnlPiePagina.add(this.iniciarPropPnlTerceroDestino());
		pnlPiePagina.add(this.iniciarPropPnlTerceroApoderado());
		pnlPiePagina.add(this.iniciarPropLblGrillaConceptos());
		pnlPiePagina.add(this.iniciarPropScpGrillaConceptos());
		pnlPiePagina.add(this.iniciarPropLblNumeroItems());
		pnlPiePagina.add(this.iniciarPropTxtNumeroItems());
		pnlPiePagina.add(this.iniciarPropLblTotalXItems());
		pnlPiePagina.add(this.iniciarPropTxtTotalXItems());
		pnlPiePagina.add(this.iniciarPropLblGrillaPromociones());
		pnlPiePagina.add(this.iniciarPropScpPromociones());
		pnlPiePagina.add(this.iniciarPropChkIncluyeApoderado());
		pnlPiePagina.add(this.iniciarPropScpAreaTextoNotas());

		return pnlPiePagina;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropPnlEncabezadoGeneral
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pnlEncabezadoGeneral
  	 * @return JPanel 
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
														  			   null,
														  			   super.getObjUsuario().getCaja(),
														  			   EnumDimensionesComponentes.PNL_PG_ENCABEZADO_GENERAL,
														  			   "pnlEncabezadoGeneral");
		}
		
		return this.pnlEncabezadoGeneral;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropPnlEncabezadoFactura
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pnlEncabezadoFactura
  	 * @return FormaPanelFactura
  	 * 		   seccion de encabezado factura gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaPanelFactura iniciarPropPnlEncabezadoFactura() throws Exception{
		
		if(this.pnlEncabezadoFactura==null){
			
			this.pnlEncabezadoFactura = new FormaPanelFactura(this,
														  	  EnumDimensionesComponentes.PNL_PG_ENCABEZADO_FACTURA,
														  	  "pnlEncabezadoFactura");
		}
		
		return this.pnlEncabezadoFactura;
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
	public EtiquetaUtil iniciarPropLblReferencia()throws Exception{

		if(this.lblReferencia==null){

			this.lblReferencia = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PG_REFERENCIA,
																		 	 "lblReferencia",
																		 	 EnumEtiquetas.LBL_PG_REFERENCIA,
																		 	 true,
																		 	 null,
																		 	 true);
		}

		return this.lblReferencia;
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
			
			this.txtReferencia = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_PG_REFERENCIA, 
																		   	 	 "txtReferencia", 
																		   	 	 "", 
																		   	 	 true, 
																		   	 	 false, 
																		   	 	 true, 
																		   	 	 null,
																		   	 	 null);
		}
		
		return this.txtReferencia;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropPnlTerritorioAgenciaPago 
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pnlTerritorioAgenciaPago
  	 * @return JPanel
  	 * 		   seccion de territorio y agencia pago gestionada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaPanelTerritorio iniciarPropPnlTerritorioAgenciaPago() throws Exception{
		
		if(this.pnlTerritorioAgenciaPago==null){
			
			this.pnlTerritorioAgenciaPago = new FormaPanelTerritorio("pnlTerritorioAgenciaPago",
																	 true,//pTitulos
					 												 true,//pTituloCombo
					 												 new String[]{"cmbPaisPago",
																				  "cmbDeptoPago",
																				  "cmbMunicipioPago",
																				  "cmbAgenciaPago"},
					 												 2,//pCategoria
					 												 false,//pAPartir
					 												 true,//pActivaAgencia
					 												 EnumDimensionesComponentes.PNL_PG_TERR_AGENCIA_PAGO,//rectangulo
					 												 null);//deptoBase
			
			this.pnlTerritorioAgenciaPago.getLblTituloCombos().setText(EnumEtiquetas.LBL_PG_TTL_PNL_TERR_AGE_PAGO.toString());
			this.pnlTerritorioAgenciaPago.habilitarComponenteCompleto(false);
		}
		
		return this.pnlTerritorioAgenciaPago;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropPnlTerritorioAgenciaOrigen
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pnlTerritorioAgenciaOrigen
  	 * @return JPanel
  	 * 		   seccion de territorio y agencia origen gestionada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaPanelTerritorio iniciarPropPnlTerritorioAgenciaOrigen() throws Exception{
		
		if(this.pnlTerritorioAgenciaOrigen==null){
			
			this.pnlTerritorioAgenciaOrigen = new FormaPanelTerritorio("pnlTerritorioAgenciaOrigen",
																	   true,//pTitulos
					 												   false,//pTituloCombo
					 												   new String[]{"cmbPaisOrigen",
																				    "cmbDeptoOrigen",
																				    "cmbMunicipioOrigen",
																				    "cmbAgenciaOrigen"},
					 												   2,//pCategoria
					 												   false,//pAPartir
					 												   true,//pActivaAgencia
					 												   EnumDimensionesComponentes.PNL_PG_TERR_AGENCIA_ORIGEN,//rectangulo
					 												   null);//deptoBase
			
			this.pnlTerritorioAgenciaOrigen.getLblTituloCombos().setText(EnumEtiquetas.LBL_PG_TTL_PNL_TERR_AGE_ORIGEN.toString());
			this.pnlTerritorioAgenciaOrigen.habilitarComponenteCompleto(false);
		}
		
		return this.pnlTerritorioAgenciaOrigen;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropPnlTerritorioAgenciaDestino
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pnlTerritorioAgenciaDestino
  	 * @return JPanel
  	 * 		   seccion de territorio y agencia destino gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
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
					   													EnumDimensionesComponentes.PNL_PG_TERR_AGENCIA_DESTINO,//rectangulo
					   													null);//deptoBase
			
			this.pnlTerritorioAgenciaDestino.getLblTituloCombos().setText(EnumEtiquetas.LBL_PG_TTL_PNL_TERR_AGE_DESTINO.toString());
			this.pnlTerritorioAgenciaDestino.habilitarComponenteCompleto(false);
		}
		
		return this.pnlTerritorioAgenciaDestino;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropPnlTerceroOrigen
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pnlTerceroOrigen
  	 * @return FormaPanelTercero
  	 * 		   seccion de tercero origen gestionada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaPanelTercero iniciarPropPnlTerceroOrigen()throws Exception{
		
		if(this.pnlTerceroOrigen==null){
			
			this.pnlTerceroOrigen = new FormaPanelTercero("pnlTerceroOrigen",
														  EnumEtiquetas.LBL_PG_TTL_PNL_TERC_ORIGEN,
														  this,
														  EnumDimensionesComponentes.PNL_PG_TERC_TERCERO_ORIGEN,
														  null,
														  null,
														  EnumParametrosApp.DESCRIPCION_TERCERO_REMITENTE.getValorPropiedad(),
														  EnumTiposOperaciones.PAGO_FACTURACION);
			
			this.pnlTerceroOrigen.castEvaFrmTercero().habilitarComponenteCompleto(false);
		}
		
		return this.pnlTerceroOrigen;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropPnlTerceroDestino
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pnlTerceroDestino
  	 * @return FormaPanelTercero
  	 * 		   seccion de tercero destino gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaPanelTercero iniciarPropPnlTerceroDestino()throws Exception{
		
		if(this.pnlTerceroDestino==null){
			
			this.pnlTerceroDestino = new FormaPanelTercero("pnlTerceroDestino",
														   EnumEtiquetas.LBL_PG_TTL_PNL_TERC_DESTINO,
														   this,
														   EnumDimensionesComponentes.PNL_PG_TERC_TERCERO_DESTINO,
														   null,
														   null,
														   EnumParametrosApp.DESCRIPCION_TERCERO_BENEFICIARIO.getValorPropiedad(),
														   EnumTiposOperaciones.PAGO_FACTURACION);
			
			this.pnlTerceroDestino.castEvaFrmTercero().habilitarItemComponente(this.pnlTerceroDestino.getCmbEntidadTiposIdentificacion().getName(), 
																 			   false);
			
			this.pnlTerceroDestino.castEvaFrmTercero().habilitarItemComponente(this.pnlTerceroDestino.getTxtIdentificacion().getName(), 
																 			   false);
			
			this.pnlTerceroDestino.castEvaFrmTercero().setBooActivaValidacionBloqueadoXRiesgos(true);
		}
		
		return this.pnlTerceroDestino;
	}
	
	/**
     * ****************************************************************
     * @method iniciarPropPnlTerceroApoderado
     * 		   metodo utilizado para inicializar el componente panel 
     * 		   tercero apoderado
     * @return JPanel componente JPanel
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   11/10/2016
     * ****************************************************************
     */
	public JPanel iniciarPropPnlTerceroApoderado()throws Exception{
		
		if(this.pnlTerceroApoderado==null){
			  
			this.pnlTerceroApoderado = new FormaPanelTercero("pnlTerceroApoderado",
													   		 EnumEtiquetas.LBL_PG_TTL_PNL_TERC_APODERADO,
													   		 this,
													   		 EnumDimensionesComponentes.PNL_PG_TERC_TERCERO_APODERADO,
													   		 null,
															 null,
															 EnumParametrosApp.DESCRIPCION_TERCERO_APODERADO.getValorPropiedad(),
															 EnumTiposOperaciones.PAGO_FACTURACION);
			
			this.pnlTerceroApoderado.getTxtIdentificacion().addFocusListener(super.getEventoForma());
			this.pnlTerceroApoderado.castEvaFrmTercero().setBooTerceroPresente(true);
			this.pnlTerceroApoderado.castEvaFrmTercero().setBooActivaValidacionBloqueadoXRiesgos(true);
			this.pnlTerceroApoderado.castEvaFrmTercero().setBooActivaValidacionTerceroPeps(true);
			this.pnlTerceroApoderado.castEvaFrmTercero().cargarTiposIdentificacion(EnumParametrosApp.ENT_TIPOS_IDENTIFICACION_APODERADO.getValorPropiedad());
		}
		
		return this.pnlTerceroApoderado;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblGrillaConceptos (Metodo)
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblGrillaConceptos
  	 * @return EtiquetaUtil 
  	 * 		   etiqueta gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblGrillaConceptos() throws Exception{
		
		if (this.lblGrillaConceptos == null) {
			
			this.lblGrillaConceptos = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PG_CONCEPTOS, 
																		  	  	  "lblGrillaConceptos", 
																		  	  	  EnumEtiquetas.LBL_PG_CONCEPTOS,
																		  	  	  true,
																		  	  	  null,
																		  	  	  true);
		}

		return this.lblGrillaConceptos;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropScpGrillaConceptos
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   scpGrillaConceptos
  	 * @return JScrollPane
  	 * 		   contenedor para el despliegue de grilla gestionado
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public JScrollPane iniciarPropScpGrillaConceptos() throws Exception{
		
		if(this.scpGrillaConceptos==null){
			
			this.scpGrillaConceptos = UtilComponentesGUI.getInstance().crearScroll("scpGrillaConceptos",
													 					 	   	   EnumDimensionesComponentes.SCP_PG_SCROLL_GRILLA_CONCEPTOS,
													 					 	   	   null);
			
			this.scpGrillaConceptos.setViewportView(this.iniciarPropTblConceptos());
		}
		
		return this.scpGrillaConceptos;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropTblConceptos
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   tblConceptos
  	 * @return GrillaUtil
  	 * 		   grilla gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public GrillaUtil iniciarPropTblConceptos() throws Exception{
		
		if(this.tblConceptos==null){
			
			this.tblConceptos = UtilComponentesGUI.getInstance().crearGrilla("tblConceptos",
																   		 	 new EnumEtiquetas[]{EnumEtiquetas.TTL_PG_GRILLA_CONCEPTOS_CODIGO,
																					  	  		 EnumEtiquetas.TTL_PG_GRILLA_CONCEPTOS_CONCEPTO,
																					  	  		 EnumEtiquetas.TTL_PG_GRILLA_CONCEPTOS_VALOR},
																   		     null,//invisibles
																   		     new boolean[] {false, 
																							false, 
																							false},//editable por columna
																   		     new int[] {50,
																						256,
																						132},//dimensiones
																   		     super.getEventoForma()//evento
																   		 	 );
		}
		
		return this.tblConceptos;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblNumeroItems
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblNumeroItems
  	 * @return EtiquetaUtil
  	 * 		   etiqueta gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblNumeroItems() throws Exception{
		
		if (this.lblNumeroItems == null) {
			
			this.lblNumeroItems = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PG_NUMERO_ITEMS, 
																		  	  "lblNumeroItems", 
																		  	  EnumEtiquetas.LBL_PG_NUMERO_ITEMS,
																		  	  true,
																		  	  null,
																		  	  true);
		}

		return this.lblNumeroItems;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropTxtNumeroItems
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   txtNumeroItems
  	 * @return CajaTextoUtil
  	 * 		   caja de texto gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaTextoUtil iniciarPropTxtNumeroItems()throws Exception{
		
		if(this.txtNumeroItems==null){
			
			this.txtNumeroItems = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_PG_NUMERO_ITEMS, 
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
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblTotalXItems
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblTotalXItems
  	 * @return EtiquetaUtil
  	 * 		   etiqueta gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblTotalXItems() throws Exception{
		
		if (this.lblTotalXItems == null) {
			
			this.lblTotalXItems = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PG_TOTAL_X_ITEMS, 
																		  	  "lblTotalXItems", 
																		  	  EnumEtiquetas.LBL_PG_TOTAL_X_ITEMS,
																		  	  true,
																		  	  null,
																		  	  true);
		}

		return this.lblTotalXItems;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropTxtTotalXItems
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   txtTotalXItems
  	 * @return CajaTextoUtil
  	 * 		   caja de texto gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaTextoUtil iniciarPropTxtTotalXItems()throws Exception{
		
		if(this.txtTotalXItems==null){
			
			this.txtTotalXItems = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_PG_TOTAL_X_ITEMS, 
																			  	  "txtTotalXItems", 
																			  	  "",
																			  	  true, 
																			  	  false, 
																			  	  true, 
																			  	  super.getEventoForma(),
																			  	  null);
			
			this.txtTotalXItems.setBackground(new java.awt.Color(164, 164, 255));
			this.txtTotalXItems.setForeground(new java.awt.Color(0, 0, 0));
			this.txtTotalXItems.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		
		return this.txtTotalXItems;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblGrillaPromociones
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblGrillaPromociones
  	 * @return EtiquetaUtil
  	 * 		   etiqueta gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblGrillaPromociones() throws Exception{
		
		if (this.lblGrillaPromociones == null) {
			
			this.lblGrillaPromociones = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PG_PROMOCIONES, 
																		  	  		"lblGrillaPromociones", 
																		  	  		EnumEtiquetas.LBL_PG_PROMOCIONES,
																		  	  		true,
																		  	  		null,
																		  	  		true);
		}

		return this.lblGrillaPromociones;
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
																EnumDimensionesComponentes.SCP_PG_SCROLL_GRILLA_PROMOCIONES,
																"scpPromociones"
															);
		}
		
		return this.scpPromociones;
	}
	
	/**
     * ****************************************************************
     * @method iniciarPropChkIncluyeApoderado
     * 		   metodo utilizado para inicializar el componente CajaVerificadaUtil 
     * 		   para seleccionar si el giro incluye apoderado
     * @return CajaVerificadaUtil componente CajaVerificadaUtil
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   11/10/2016
     * ****************************************************************
     */	
	public CajaVerificadaUtil iniciarPropChkIncluyeApoderado() throws Exception{
		if (this.chkIncluyeApoderado == null) {
			this.chkIncluyeApoderado = UtilComponentesGUI.getInstance().crearCheckBox(EnumDimensionesComponentes.CHK_PG_INCLU_APODERADO, 
																					   "chkIncluyeApoderado", 
																					   EnumEtiquetas.CHK_PG_INCLU_APODERADO, 
																					   false,
																					   true, 
																					   false, 
																					   false, 
																					   super.getEventoForma(),
																					   SwingConstants.LEFT,
																					   true);
		}

		return this.chkIncluyeApoderado;
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
			
			this.lblNotas = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PG_NOTAS, 
																		"lblNotas", 
																		EnumEtiquetas.LBL_PG_NOTAS,
																		false,
																		null,
																		true);
			
			this.lblNotas.setHorizontalAlignment(SwingConstants.CENTER);
		}

		return this.lblNotas;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropScpAreaTextoNotas
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   scpAreaTextoNotas
  	 * @return JScrollPane
  	 * 		   contenedor para el despliegue de grilla gestionado
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public JScrollPane iniciarPropScpAreaTextoNotas() throws Exception{
		
		if(this.scpAreaTextoNotas==null){
			
			/*this.scpAreaTextoNotas = UtilComponentesGUI.getInstance().crearScroll("scpAreaTextoNotas",
													 					 	  	  EnumDimensionesComponentes.SCP_PG_SCROLL_AREA_TEXTO_NOTAS,
													 					 	  	  null);*/
			
			this.scpAreaTextoNotas	=	this.iniciarPropTxaNotas().getScpContenedorRound(EnumDimensionesComponentes.SCP_PG_SCROLL_AREA_TEXTO_NOTAS);
			
			this.scpAreaTextoNotas.setBorder	(	BorderFactory.createTitledBorder(	null,
																						EnumEtiquetas.LBL_PG_NOTAS.toString(),
																						TitledBorder.CENTER,
																						TitledBorder.TOP
																					)
												);
			
			//this.scpAreaTextoNotas.setViewportView(this.iniciarPropTxaNotas());
		}
		
		return this.scpAreaTextoNotas;
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
			
			this.txaNotas = UtilComponentesGUI.getInstance().crearTextArea(null, 
																	   	   "txaNotas", 
																	   	   "", 
																	   	   true, 
																	   	   false, 
																	   	   true, 
																	   	   super.getEventoForma(),
																	   	   EnumEtiquetas.LBL_PG_NOTAS);
		}
		
		return this.txaNotas;
	}

	/**
	 * @method getScpPromociones
	 * 		   Metodo get del atributo scpPromociones
	 * @return FormaPanelPromocion
	 *		   Valor del atributo scpPromociones devuelto
	 * @author hector.cuenca
	 * @date   10/12/2016
	 */
	public FormaPanelPromocion getScpPromociones() {
		return this.scpPromociones;
	}

	/**
	 * @method setScpPromociones
	 * 		   Metodo set del atributo scpPromociones
	 * @param  pScpPromociones
	 *		   Valor que tomara el atributo scpPromociones
	 * @author hector.cuenca
	 * @date   10/12/2016
	 */
	public void setScpPromociones(FormaPanelPromocion pScpPromociones) {
		this.scpPromociones = pScpPromociones;
	}

	/**
	 * @method getPnlEncabezadoGeneral
	 * 		   Metodo get del atributo pnlEncabezadoGeneral
	 * @return FormaPanelEncabezadoGeneral
	 *		   Valor del atributo pnlEncabezadoGeneral devuelto
	 * @author hector.cuenca
	 * @date   10/12/2016
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
	 * @date   10/12/2016
	 */
	public void setPnlEncabezadoGeneral(
			FormaPanelEncabezadoGeneral pPnlEncabezadoGeneral) {
		this.pnlEncabezadoGeneral = pPnlEncabezadoGeneral;
	}

	/**
	 * @method getPnlEncabezadoFactura
	 * 		   Metodo get del atributo pnlEncabezadoFactura
	 * @return FormaPanelFactura
	 *		   Valor del atributo pnlEncabezadoFactura devuelto
	 * @author hector.cuenca
	 * @date   10/12/2016
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
	 * @date   10/12/2016
	 */
	public void setPnlEncabezadoFactura(FormaPanelFactura pPnlEncabezadoFactura) {
		this.pnlEncabezadoFactura = pPnlEncabezadoFactura;
	}

	/**
	 * @method getPnlTerritorioAgenciaPago
	 * 		   Metodo get del atributo pnlTerritorioAgenciaPago
	 * @return FormaPanelTerritorio
	 *		   Valor del atributo pnlTerritorioAgenciaPago devuelto
	 * @author hector.cuenca
	 * @date   10/12/2016
	 */
	public FormaPanelTerritorio getPnlTerritorioAgenciaPago() {
		return this.pnlTerritorioAgenciaPago;
	}

	/**
	 * @method setPnlTerritorioAgenciaPago
	 * 		   Metodo set del atributo pnlTerritorioAgenciaPago
	 * @param  pPnlTerritorioAgenciaPago
	 *		   Valor que tomara el atributo pnlTerritorioAgenciaPago
	 * @author hector.cuenca
	 * @date   10/12/2016
	 */
	public void setPnlTerritorioAgenciaPago(
			FormaPanelTerritorio pPnlTerritorioAgenciaPago) {
		this.pnlTerritorioAgenciaPago = pPnlTerritorioAgenciaPago;
	}

	/**
	 * @method getPnlTerritorioAgenciaOrigen
	 * 		   Metodo get del atributo pnlTerritorioAgenciaOrigen
	 * @return FormaPanelTerritorio
	 *		   Valor del atributo pnlTerritorioAgenciaOrigen devuelto
	 * @author hector.cuenca
	 * @date   10/12/2016
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
	 * @date   10/12/2016
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
	 * @date   10/12/2016
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
	 * @date   10/12/2016
	 */
	public void setPnlTerritorioAgenciaDestino(
			FormaPanelTerritorio pPnlTerritorioAgenciaDestino) {
		this.pnlTerritorioAgenciaDestino = pPnlTerritorioAgenciaDestino;
	}

	/**
	 * @method getPnlTerceroOrigen
	 * 		   Metodo get del atributo pnlTerceroOrigen
	 * @return FormaPanelTercero
	 *		   Valor del atributo pnlTerceroOrigen devuelto
	 * @author hector.cuenca
	 * @date   10/12/2016
	 */
	public FormaPanelTercero getPnlTerceroOrigen() {
		return this.pnlTerceroOrigen;
	}

	/**
	 * @method setPnlTerceroOrigen
	 * 		   Metodo set del atributo pnlTerceroOrigen
	 * @param  pPnlTerceroOrigen
	 *		   Valor que tomara el atributo pnlTerceroOrigen
	 * @author hector.cuenca
	 * @date   10/12/2016
	 */
	public void setPnlTerceroOrigen(FormaPanelTercero pPnlTerceroOrigen) {
		this.pnlTerceroOrigen = pPnlTerceroOrigen;
	}

	/**
	 * @method getPnlTerceroDestino
	 * 		   Metodo get del atributo pnlTerceroDestino
	 * @return FormaPanelTercero
	 *		   Valor del atributo pnlTerceroDestino devuelto
	 * @author hector.cuenca
	 * @date   10/12/2016
	 */
	public FormaPanelTercero getPnlTerceroDestino() {
		return this.pnlTerceroDestino;
	}

	/**
	 * @method setPnlTerceroDestino
	 * 		   Metodo set del atributo pnlTerceroDestino
	 * @param  pPnlTerceroDestino
	 *		   Valor que tomara el atributo pnlTerceroDestino
	 * @author hector.cuenca
	 * @date   10/12/2016
	 */
	public void setPnlTerceroDestino(FormaPanelTercero pPnlTerceroDestino) {
		this.pnlTerceroDestino = pPnlTerceroDestino;
	}

	/**
	 * @method getLblGrillaConceptos
	 * 		   Metodo get del atributo lblGrillaConceptos
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblGrillaConceptos devuelto
	 * @author hector.cuenca
	 * @date   10/12/2016
	 */
	public EtiquetaUtil getLblGrillaConceptos() {
		return this.lblGrillaConceptos;
	}

	/**
	 * @method setLblGrillaConceptos
	 * 		   Metodo set del atributo lblGrillaConceptos
	 * @param  pLblGrillaConceptos
	 *		   Valor que tomara el atributo lblGrillaConceptos
	 * @author hector.cuenca
	 * @date   10/12/2016
	 */
	public void setLblGrillaConceptos(EtiquetaUtil pLblGrillaConceptos) {
		this.lblGrillaConceptos = pLblGrillaConceptos;
	}

	/**
	 * @method getScpGrillaConceptos
	 * 		   Metodo get del atributo scpGrillaConceptos
	 * @return JScrollPane
	 *		   Valor del atributo scpGrillaConceptos devuelto
	 * @author hector.cuenca
	 * @date   10/12/2016
	 */
	public JScrollPane getScpGrillaConceptos() {
		return this.scpGrillaConceptos;
	}

	/**
	 * @method setScpGrillaConceptos
	 * 		   Metodo set del atributo scpGrillaConceptos
	 * @param  pScpGrillaConceptos
	 *		   Valor que tomara el atributo scpGrillaConceptos
	 * @author hector.cuenca
	 * @date   10/12/2016
	 */
	public void setScpGrillaConceptos(JScrollPane pScpGrillaConceptos) {
		this.scpGrillaConceptos = pScpGrillaConceptos;
	}

	/**
	 * @method getTblConceptos
	 * 		   Metodo get del atributo tblConceptos
	 * @return GrillaUtil
	 *		   Valor del atributo tblConceptos devuelto
	 * @author hector.cuenca
	 * @date   10/12/2016
	 */
	public GrillaUtil getTblConceptos() {
		return this.tblConceptos;
	}

	/**
	 * @method setTblConceptos
	 * 		   Metodo set del atributo tblConceptos
	 * @param  pTblConceptos
	 *		   Valor que tomara el atributo tblConceptos
	 * @author hector.cuenca
	 * @date   10/12/2016
	 */
	public void setTblConceptos(GrillaUtil pTblConceptos) {
		this.tblConceptos = pTblConceptos;
	}

	/**
	 * @method getLblReferencia
	 * 		   Metodo get del atributo lblReferencia
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblReferencia devuelto
	 * @author hector.cuenca
	 * @date   10/12/2016
	 */
	public EtiquetaUtil getLblReferencia() {
		return this.lblReferencia;
	}

	/**
	 * @method setLblReferencia
	 * 		   Metodo set del atributo lblReferencia
	 * @param  pLblReferencia
	 *		   Valor que tomara el atributo lblReferencia
	 * @author hector.cuenca
	 * @date   10/12/2016
	 */
	public void setLblReferencia(EtiquetaUtil pLblReferencia) {
		this.lblReferencia = pLblReferencia;
	}

	/**
	 * @method getTxtReferencia
	 * 		   Metodo get del atributo txtReferencia
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtReferencia devuelto
	 * @author hector.cuenca
	 * @date   10/12/2016
	 */
	public CajaTextoUtil getTxtReferencia() {
		return this.txtReferencia;
	}

	/**
	 * @method setTxtReferencia
	 * 		   Metodo set del atributo txtReferencia
	 * @param  pTxtReferencia
	 *		   Valor que tomara el atributo txtReferencia
	 * @author hector.cuenca
	 * @date   10/12/2016
	 */
	public void setTxtReferencia(CajaTextoUtil pTxtReferencia) {
		this.txtReferencia = pTxtReferencia;
	}

	/**
	 * @method getLblNumeroItems
	 * 		   Metodo get del atributo lblNumeroItems
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblNumeroItems devuelto
	 * @author hector.cuenca
	 * @date   10/12/2016
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
	 * @date   10/12/2016
	 */
	public void setLblNumeroItems(EtiquetaUtil pLblNumeroItems) {
		this.lblNumeroItems = pLblNumeroItems;
	}

	/**
	 * @method getTxtNumeroItems
	 * 		   Metodo get del atributo txtNumeroItems
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtNumeroItems devuelto
	 * @author hector.cuenca
	 * @date   10/12/2016
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
	 * @date   10/12/2016
	 */
	public void setTxtNumeroItems(CajaTextoUtil pTxtNumeroItems) {
		this.txtNumeroItems = pTxtNumeroItems;
	}

	/**
	 * @method getLblTotalXItems
	 * 		   Metodo get del atributo lblTotalXItems
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblTotalXItems devuelto
	 * @author hector.cuenca
	 * @date   10/12/2016
	 */
	public EtiquetaUtil getLblTotalXItems() {
		return this.lblTotalXItems;
	}

	/**
	 * @method setLblTotalXItems
	 * 		   Metodo set del atributo lblTotalXItems
	 * @param  pLblTotalXItems
	 *		   Valor que tomara el atributo lblTotalXItems
	 * @author hector.cuenca
	 * @date   10/12/2016
	 */
	public void setLblTotalXItems(EtiquetaUtil pLblTotalXItems) {
		this.lblTotalXItems = pLblTotalXItems;
	}

	/**
	 * @method getTxtTotalXItems
	 * 		   Metodo get del atributo txtTotalXItems
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtTotalXItems devuelto
	 * @author hector.cuenca
	 * @date   10/12/2016
	 */
	public CajaTextoUtil getTxtTotalXItems() {
		return this.txtTotalXItems;
	}

	/**
	 * @method setTxtTotalXItems
	 * 		   Metodo set del atributo txtTotalXItems
	 * @param  pTxtTotalXItems
	 *		   Valor que tomara el atributo txtTotalXItems
	 * @author hector.cuenca
	 * @date   10/12/2016
	 */
	public void setTxtTotalXItems(CajaTextoUtil pTxtTotalXItems) {
		this.txtTotalXItems = pTxtTotalXItems;
	}

	/**
	 * @method getLblGrillaPromociones
	 * 		   Metodo get del atributo lblGrillaPromociones
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblGrillaPromociones devuelto
	 * @author hector.cuenca
	 * @date   10/12/2016
	 */
	public EtiquetaUtil getLblGrillaPromociones() {
		return this.lblGrillaPromociones;
	}

	/**
	 * @method setLblGrillaPromociones
	 * 		   Metodo set del atributo lblGrillaPromociones
	 * @param  pLblGrillaPromociones
	 *		   Valor que tomara el atributo lblGrillaPromociones
	 * @author hector.cuenca
	 * @date   10/12/2016
	 */
	public void setLblGrillaPromociones(EtiquetaUtil pLblGrillaPromociones) {
		this.lblGrillaPromociones = pLblGrillaPromociones;
	}

	/**
	 * @method getChkIncluyeApoderado
	 * 		   Metodo get del atributo chkIncluyeApoderado
	 * @return CajaVerificadaUtil
	 *		   Valor del atributo chkIncluyeApoderado devuelto
	 * @author hector.cuenca
	 * @date   10/12/2016
	 */
	public CajaVerificadaUtil getChkIncluyeApoderado() {
		return this.chkIncluyeApoderado;
	}

	/**
	 * @method setChkIncluyeApoderado
	 * 		   Metodo set del atributo chkIncluyeApoderado
	 * @param  pChkIncluyeApoderado
	 *		   Valor que tomara el atributo chkIncluyeApoderado
	 * @author hector.cuenca
	 * @date   10/12/2016
	 */
	public void setChkIncluyeApoderado(CajaVerificadaUtil pChkIncluyeApoderado) {
		this.chkIncluyeApoderado = pChkIncluyeApoderado;
	}

	/**
	 * @method getPnlTerceroApoderado
	 * 		   Metodo get del atributo pnlTerceroApoderado
	 * @return FormaPanelTercero
	 *		   Valor del atributo pnlTerceroApoderado devuelto
	 * @author hector.cuenca
	 * @date   10/12/2016
	 */
	public FormaPanelTercero getPnlTerceroApoderado() {
		return this.pnlTerceroApoderado;
	}

	/**
	 * @method setPnlTerceroApoderado
	 * 		   Metodo set del atributo pnlTerceroApoderado
	 * @param  pPnlTerceroApoderado
	 *		   Valor que tomara el atributo pnlTerceroApoderado
	 * @author hector.cuenca
	 * @date   10/12/2016
	 */
	public void setPnlTerceroApoderado(FormaPanelTercero pPnlTerceroApoderado) {
		this.pnlTerceroApoderado = pPnlTerceroApoderado;
	}

	/**
	 * @method getLblNotas
	 * 		   Metodo get del atributo lblNotas
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblNotas devuelto
	 * @author hector.cuenca
	 * @date   10/12/2016
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
	 * @date   10/12/2016
	 */
	public void setLblNotas(EtiquetaUtil pLblNotas) {
		this.lblNotas = pLblNotas;
	}

	/**
	 * @method getScpAreaTextoNotas
	 * 		   Metodo get del atributo scpAreaTextoNotas
	 * @return JScrollPane
	 *		   Valor del atributo scpAreaTextoNotas devuelto
	 * @author hector.cuenca
	 * @date   10/12/2016
	 */
	public JScrollPane getScpAreaTextoNotas() {
		return this.scpAreaTextoNotas;
	}

	/**
	 * @method setScpAreaTextoNotas
	 * 		   Metodo set del atributo scpAreaTextoNotas
	 * @param  pScpAreaTextoNotas
	 *		   Valor que tomara el atributo scpAreaTextoNotas
	 * @author hector.cuenca
	 * @date   10/12/2016
	 */
	public void setScpAreaTextoNotas(JScrollPane pScpAreaTextoNotas) {
		this.scpAreaTextoNotas = pScpAreaTextoNotas;
	}

	/**
	 * @method getTxaNotas
	 * 		   Metodo get del atributo txaNotas
	 * @return AreaTextoUtil
	 *		   Valor del atributo txaNotas devuelto
	 * @author hector.cuenca
	 * @date   10/12/2016
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
	 * @date   10/12/2016
	 */
	public void setTxaNotas(AreaTextoUtil pTxaNotas) {
		this.txaNotas = pTxaNotas;
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
		
		try{
	        FacturaGiro objFacturaGiro = new FacturaGiro();
	        objFacturaGiro.setBooPermiteApoderado(true);
			TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaPagoGiro.class,
																   true, 
																   EnumDesplegarFormaConEventos.NO);
			new FormaPagoGiro(null,
							  true,
							  objFacturaGiro);
			
		} catch (Exception e) {
			
			UtilidadesGiros.getInstance().controlExcepcion(e, 
														   null);
		}
	}
}

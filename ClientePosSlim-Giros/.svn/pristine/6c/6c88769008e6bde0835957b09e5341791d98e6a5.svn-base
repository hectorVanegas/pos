package co.com.codesa.clienteposslimgiros.formas.solicitud;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.operaciones.EnumTiposOperaciones;
import co.com.codesa.clienteposslimgiros.eventos.solicitud.EventoFormaSolicitudAutorizacion;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.AreaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelEncabezadoGeneral;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelFactura;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelTercero;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelTerritorio;
import co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.FormaPanelDesplazableServiciosAdicionales;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilControlCargueDataMemoria;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 14-abr-2015
 * @Clase FormaSolicitudAutorizacion 
 * 		  Clase que genera la forma (GUI) para el proceso de solicitudes
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class FormaSolicitudAutorizacion extends FormaGenerica{

	/**
	 * @variable serialVersionUID
	 * 			 Variable serial version
	 */
	private static final long serialVersionUID = 6570862104764091509L;
	
	/**
	 * @variable pnlEncabezadoGeneral
	 * 			 seccion que aloja el encabezado general para las formas, 
	 * 			 que contiene los valores de agencia, empresa y caja, 
	 * 			 normalmente recuperados del usuario autenticado
	 **/
	private JPanel pnlEncabezadoGeneral;
	
	/**
	 * @variable pnlEncabezadoFactura
	 * 			 seccion que aloja el encabezado general de factura, que 
	 * 			 consolida los valores de documento producto, prefijo de 
	 * 			 factura y numero de factura
	 **/
	private FormaPanelFactura pnlEncabezadoFactura;
	
	/**
	 * @variable pnlNotas
	 * 			 seccion que aloja los componentes graficos para mostrar
	 * 			 las notas asociadas a la transaccion
	 **/
	//private JPanel pnlNotas;
	
	/**
	 * @variable pnlNotaAdicional
	 * 			 seccion que aloja los componentes graficos para ingresar
	 * 			 las notas adicionales
	 **/
	//private JPanel pnlNotaAdicional;
	
	/**
	 * @variable pnlTerritorioAgenciaPago 
	 * 			 seccion que aloja los diferentes componentes graficos que 
	 * 		     describen jerarquicamente el territorio al que pertenece
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
	 * 		  	 gestionar la informacion asociada al tercero origen (consulta 
	 * 			 de tercero)
	 **/
	private FormaPanelTercero pnlTerceroOrigen;
	
	/**
	 * @variable pnlTerceroNuevo
	 * 			 seccion que aloja los diferentes componentes graficos para 
	 * 		  	 gestionar la informacion asociada al tercero nuevo (consulta 
	 * 			 de tercero)
	 **/
	private FormaPanelTercero pnlTerceroNuevo;
	
	/**
	 * @variable pnlTerceroDestino
	 * 			 seccion que aloja los diferentes componentes graficos para 
	 * 			 gestionar la informacion asociada al tercero destino (consulta de 
	 * 			 tercero)
	 **/
	private FormaPanelTercero pnlTerceroDestino;
	
	/**
	 * @variable scpServiciosAdicionales
	 * 			 contenedor de servicios adicionales
	 */
	private FormaPanelDesplazableServiciosAdicionales scpServiciosAdicionales;
	
	/**
	 * @variable scpAreaTextoNotas
	 * 			 componente grafico que permite incluir barras de desplazamiento para 
	 * 			 facilitar el despliegue del area de texto para notas
	 **/
	private JScrollPane scpAreaTextoNotas;
	
	/**
	 * @variable scpAreaTextoNotaAdicional
	 * 			 componente grafico que permite incluir barras de desplazamiento para 
	 * 			 facilitar el despliegue del area de texto para notas adicionales
	 **/
	private JScrollPane scpAreaTextoNotaAdicional;
	
	/**
	 * @variable cmbListaAnotaciones
	 * 			 lista de valores (combo), que contiene los mensajes predeterminados
	 * 			 (anotaciones), segun el tipo de solicitud seleccionada
	 **/
	private CajaComboUtil cmbListaAnotaciones;
	
	/**
	 * @variable cmbListaSolicitudes
	 * 			 lista de valores (combo), que contiene los diferentes tipos de solicitud
	 * 			 que se pueden ejecutar
	 **/
	private CajaComboUtil cmbListaSolicitudes;
	
	/**
	 * @variable txaNotas
	 * 			 campo de texto donde se relacionara la informacion de las notas asociadas 
	 * 			 al giro
	 **/
	private AreaTextoUtil txaNotas;
	
	/**
	 * @variable txaNotaAdicional
	 * 		  	 campo de texto donde se relacionara la informacion de las notas asociadas 
	 * 			 al giro
	 **/
	private AreaTextoUtil txaNotaAdicional;
	
	/**
	 * @variable txtReferencia
	 * 			 caja de texto para diligenciar la referencia del giro interesado
	 * 			 en realizar un tipo de solicitud
	 **/
	private CajaTextoUtil txtReferencia;
	
	/**
	 * @variable lblListaSolicitudes
	 * 			 etiqueta que identifica el componente grafico en donde se listan 
	 * 			 los diferentes tipos de solicitudes que se pueden ejecutar
	 **/
	private EtiquetaUtil lblListaSolicitudes;
	
	/**
	 * @variable lblReferencia
	 * 			 etiqueta que identifica el componente grafico para diligenciar 
	 * 			 la referencia o pin del giro
	 **/
	private EtiquetaUtil lblReferencia;
	
	/**
	 * @variable lblListaAnotaciones
	 * 			 etiqueta que identifica el componente grafico en donde se listan 
	 * 			 los diferentes mensajes predeterminados (anotaciones), segun el
	 * 			 tipo de solicitud seleccionada
	 **/
	private EtiquetaUtil lblListaAnotaciones;

	/**
  	 * ****************************************************************.
  	 * @metodo FormaSolicitudAutorizacion
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de la forma
  	 * @param pFrmPadre
  	 * 		  ventana de la cual extiende esta forma
  	 * @param pBooModal 
  	 * 		  bandera que permite efectuar la forma de manera modal sobre 
  	 * 		  la ventana de la cual extiende
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaSolicitudAutorizacion(JFrame pFrmPadre,
								   boolean pBooModal)throws Exception{
		super(pFrmPadre,
			  pBooModal);
		
		UtilControlCargueDataMemoria.getInstance().verificarControlConfiguracionPasi(super.getObjUsuario(), "IDSERVEV");
		
		super.setEventoForma(new EventoFormaSolicitudAutorizacion(this));
		
		this.inicializarForma();
	}

	@Override
	public void inicializarForma(Object ...pArrObjParametrosForma) throws Exception{
		
		super.setTituloForma(EnumEtiquetas.TTL_SAT_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.GUI_SAT_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.GUI_SAT_VENTANA.getAlto());
		
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
								EnumBotonesEncabezado.BTNCONSULTAR,
								EnumBotonesEncabezado.BTNSALIR);
		
		super.iniciar(pArrObjParametrosForma);
	}
	
	@Override
	public JPanel inicializarEncabezado(Object ...pArrObjParametrosEncabezado) throws Exception{
		
		JPanel pnlEncabezado;
		
		pnlEncabezado = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_SAT_ENCABEZADO,
																	"pnlEncabezado",
		 													 	 	null,
		 													 	 	null,
		 													 	 	null);
		pnlEncabezado.add(this.iniciarPropPnlEncabezadoGeneral());
		pnlEncabezado.add(this.iniciarPropPnlEncabezadoFactura());
		pnlEncabezado.add(this.iniciarPropLblListaSolicitudes());
		pnlEncabezado.add(this.iniciarPropCmbListaSolicitudes());
		pnlEncabezado.add(this.iniciarPropLblReferencia());
		pnlEncabezado.add(this.iniciarPropTxtReferencia());
		
		return pnlEncabezado;
	}
	
	@Override
	public JPanel inicializarCuerpo(Object ...pArrObjParametrosCuerpo) throws Exception{
		
		JPanel pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_SAT_CUERPO,
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
  	 * @param  pArrObjParametrosPiePagina
  	 * 		   lista de posibles parametros a incluir sobre esta etapa
  	 * 		   [x]: descripcion del valor enviado en la posicion [x]
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor  Hector Q-en-K
  	 * ****************************************************************
  	 */
	public JPanel inicializarPiePagina(Object ...pArrObjParametrosPiePagina) throws Exception{

		JPanel pnlPiePagina;
		
		pnlPiePagina = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_SAT_PIE_PAGINA,
																   "pnlPiePagina",
		 														   null,
		 														   null,
		 														   null);
		pnlPiePagina.add(this.iniciarPropPnlTerceroOrigen());
		pnlPiePagina.add(this.iniciarPropPnlTerceroDestino());
		pnlPiePagina.add(this.iniciarPropPnlTerceroNuevo());
		pnlPiePagina.add(this.iniciarPropLblListaAnotaciones());
		pnlPiePagina.add(this.iniciarPropCmbListaAnotaciones());
		pnlPiePagina.add(this.iniciarPropScpAreaTextoNotas());
		pnlPiePagina.add(this.iniciarPropScpAreaTextoNotaAdicional());
		pnlPiePagina.add(this.iniciarPropScpServiciosAdicionales());
		
		this.iniciarPropPnlTerceroNuevo().setVisible(false);
		
		return pnlPiePagina;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropPnlNotas
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pnlNotas
  	 * @return JPanel 
  	 * 		   seccion de cuerpo gestionada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	/*public JPanel iniciarPropPnlNotas()throws Exception{

		if(this.pnlNotas==null){

			this.pnlNotas = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_SAT_NOTAS, 
																		"pnlNotas",
																	 	null, 
																	 	EnumEtiquetas.TTL_SAT_PNL_NOTAS,
																	 	null);
			this.pnlNotas.add(this.iniciarPropScpAreaTextoNotas());
		}
		return this.pnlNotas;
	}*/
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropPnlNotaAdicional
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pnlNotaAdicional
  	 * @return JPanel 
  	 * 		   seccion de cuerpo gestionada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	/*public JPanel iniciarPropPnlNotaAdicional()throws Exception{

		if(this.pnlNotaAdicional==null){

			this.pnlNotaAdicional = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_SAT_NOTAS_ADICIONALES, 
																				"pnlNotaAdicional",
																			 	null, 
																			 	EnumEtiquetas.TTL_SAT_PNL_NOTAS_ADICIONALES,
																			 	null);
			this.pnlNotaAdicional.add(this.iniciarPropScpAreaTextoNotaAdicional());
		}
		return this.pnlNotaAdicional;
	}*/
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropScpServiciosAdicionales 
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   scpServiciosAdicionales
  	 * @return FormaPanelDesplazableServiciosAdicionales
  	 * 		   contenedor de servicios adicionales
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor  hector.cuenca
  	 * @date   9/03/2016
  	 * ****************************************************************
  	 */
	public FormaPanelDesplazableServiciosAdicionales iniciarPropScpServiciosAdicionales()throws Exception{
		
		if(this.scpServiciosAdicionales == null){
			
			this.scpServiciosAdicionales = new FormaPanelDesplazableServiciosAdicionales(this,
																			   			 EnumDimensionesComponentes.SCP_SAT_SERVICIOS_ADICIONALES,
																			   			 2,
																			   			 "scpServiciosAdicionales",
																			   			 null,
																			   			 null,
																			   			 EnumEtiquetas.TTL_SRV_ADI_SCP_SERVICIOS_ADICIONALES);
		}
		
		return this.scpServiciosAdicionales;
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
													 					 	  	  EnumDimensionesComponentes.SCP_SAT_SCROLL_AREA_TEXTO_NOTAS,
													 					 	  	  null);*/
			
			this.scpAreaTextoNotas	=	this.iniciarPropTxaNotas().getScpContenedorRound(EnumDimensionesComponentes.PNL_SAT_NOTAS);
			
			this.scpAreaTextoNotas.setBorder	(	BorderFactory.createTitledBorder(	null,
																						EnumEtiquetas.TTL_SAT_PNL_NOTAS.toString(),
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
  	 * @metodo iniciarPropScpAreaTextoNotaAdicional
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
	public JScrollPane iniciarPropScpAreaTextoNotaAdicional() throws Exception{
		
		if(this.scpAreaTextoNotaAdicional==null){
			
			/*this.scpAreaTextoNotaAdicional = UtilComponentesGUI.getInstance().crearScroll("scpAreaTextoNotaAdicional",
													 					 	  		  	  EnumDimensionesComponentes.SCP_SAT_SCROLL_AREA_TEXTO_NOTAS_ADICIONALES,
													 					 	  		  	  null);*/
			
			this.scpAreaTextoNotaAdicional	=	this.iniciarPropTxaNotaAdicional().getScpContenedorRound(EnumDimensionesComponentes.PNL_SAT_NOTAS_ADICIONALES);
			
			this.scpAreaTextoNotaAdicional.setBorder	(	BorderFactory.createTitledBorder(	null,
																								EnumEtiquetas.TTL_SAT_PNL_NOTAS_ADICIONALES.toString(),
																								TitledBorder.CENTER,
																								TitledBorder.TOP
																							)
														);
			
			//this.scpAreaTextoNotaAdicional.setViewportView(this.iniciarPropTxaNotaAdicional());
		}
		
		return this.scpAreaTextoNotaAdicional;
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
																	   	   EnumEtiquetas.TTL_SAT_PNL_NOTAS);
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
			
			this.txaNotaAdicional = UtilComponentesGUI.getInstance().crearTextArea(null, 
																	   		       "txaNotaAdicional", 
																	   		       "", 
																	   		       true, 
																	   		       true, 
																	   		       true, 
																	   		       super.getEventoForma(),
																	   		       EnumEtiquetas.TTL_SAT_PNL_NOTAS_ADICIONALES);
		}
		return this.txaNotaAdicional;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropCmbListaAnotaciones
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   cmbListaAnotaciones
  	 * @return CajaComboUtil 
  	 * 		   lista de valores gestionada 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaComboUtil iniciarPropCmbListaAnotaciones()throws Exception{

		if(this.cmbListaAnotaciones==null){

			this.cmbListaAnotaciones = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_SAT_LISTA_ANOTACIONES,
																		  	   	  	  "cmbListaAnotaciones",
																		  	   	  	  true, 
																		  	   	  	  true, 
																		  	   	  	  super.getEventoForma(),
																		  	   	  	  EnumEtiquetas.LBL_SAT_LISTA_ANOTACIONES);
		}
		return this.cmbListaAnotaciones;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblListaAnotaciones
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblListaAnotaciones
  	 * @return EtiquetaUtil
  	 * 		   etiqueta gestionada 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblListaAnotaciones()throws Exception{

		if(this.lblListaAnotaciones==null){

			this.lblListaAnotaciones = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_SAT_LISTA_ANOTACIONES,
																		  	   	   "lblListaAnotaciones",
																		  	   	   EnumEtiquetas.LBL_SAT_LISTA_ANOTACIONES,
																		  	   	   true,
																		  	   	   null,
																		  	   	   true);
		}
		return this.lblListaAnotaciones;
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
														  EnumEtiquetas.LBL_SAT_TTL_PNL_TERC_ORIGEN,
														  this,
														  EnumDimensionesComponentes.PNL_SAT_TERC_TERCERO_ORIGEN,
														  null,
														  null,
														  EnumParametrosApp.DESCRIPCION_TERCERO_REMITENTE.getValorPropiedad(),
														  EnumTiposOperaciones.SOLICITUD_CAMBIO_BENEFICIARIO);
			
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
														   EnumEtiquetas.LBL_SAT_TTL_PNL_TERC_DESTINO,
														   this,
														   EnumDimensionesComponentes.PNL_SAT_TERC_TERCERO_DESTINO,
														   null,
														   null,
														   EnumParametrosApp.DESCRIPCION_TERCERO_BENEFICIARIO.getValorPropiedad(),
														   null);
			
			this.pnlTerceroDestino.castEvaFrmTercero().habilitarComponenteCompleto(false);
		}
		
		return this.pnlTerceroDestino;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropPnlTerceroNuevo
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pnlTerceroNuevo
  	 * @return FormaPanelTercero
  	 * 		   seccion de tercero destino gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaPanelTercero iniciarPropPnlTerceroNuevo()throws Exception{
		
		if(this.pnlTerceroNuevo==null){
			
			this.pnlTerceroNuevo = new FormaPanelTercero("pnlTerceroNuevo",
														 EnumEtiquetas.LBL_SAT_TTL_PNL_TERC_NUEVO,
														 this,
														 EnumDimensionesComponentes.PNL_SAT_TERC_TERCERO_NUEVO,
														 null,
														 null,
														 EnumParametrosApp.DESCRIPCION_TERCERO_BENEFICIARIO.getValorPropiedad(),
														 EnumTiposOperaciones.SOLICITUD_CAMBIO_BENEFICIARIO);
			
			this.pnlTerceroNuevo.castEvaFrmTercero().setBooTerceroPresente(false);
			this.pnlTerceroNuevo.castEvaFrmTercero().setBooActivaValidacionBloqueadoXRiesgos(true);
			this.pnlTerceroNuevo.castEvaFrmTercero().setBooActivaValidacionTerceroPeps(false);
		}
		
		return this.pnlTerceroNuevo;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropPnlTerritorioAgenciaPago
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pnlTerritorioAgenciaPago
  	 * @return FormaPanelTerritorio
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
					 												 EnumDimensionesComponentes.PNL_SAT_TERR_AGENCIA_PAGO,//rectangulo
					 												 null);//deptoBase
			
			this.pnlTerritorioAgenciaPago.getLblTituloCombos().setText(EnumEtiquetas.LBL_SAT_TTL_PNL_TERR_AGE_PAGO.toString());
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
	public JPanel iniciarPropPnlTerritorioAgenciaOrigen() throws Exception{
		
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
					 												   EnumDimensionesComponentes.PNL_SAT_TERR_AGENCIA_ORIGEN,//rectangulo
					 												   null);//deptoBase
			
			this.pnlTerritorioAgenciaOrigen.getLblTituloCombos().setText(EnumEtiquetas.LBL_SAT_TTL_PNL_TERR_AGE_ORIGEN.toString());
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
					   													EnumDimensionesComponentes.PNL_SAT_TERR_AGENCIA_DESTINO,//rectangulo
					   													null);//deptoBase
			
			this.pnlTerritorioAgenciaDestino.getLblTituloCombos().setText(EnumEtiquetas.LBL_SAT_TTL_PNL_TERR_AGE_DESTINO.toString());
			this.pnlTerritorioAgenciaDestino.habilitarComponenteCompleto(false);
		}
		
		return this.pnlTerritorioAgenciaDestino;
		
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
			
			this.txtReferencia = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_SAT_REFERENCIA, 
																		   	 	 "txtReferencia", 
																		   	 	 "", 
																		   	 	 true, 
																		   	 	 true, 
																		   	 	 true, 
																		   	 	 super.getEventoForma(),
																		   	 	 null);
		}
		return this.txtReferencia;
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

			this.lblReferencia = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_SAT_REFERENCIA,
																		 	 "lblReferencia",
																		 	 EnumEtiquetas.LBL_SAT_REFERENCIA,
																		 	 true,
																		 	 null,
																		 	 true);
		}
		return this.lblReferencia;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropCmbListaSolicitudes
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   cmbListaSolicitudes
  	 * @return CajaComboUtil 
  	 * 		   lista de valores gestionada 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaComboUtil iniciarPropCmbListaSolicitudes()throws Exception{

		if(this.cmbListaSolicitudes==null){

			this.cmbListaSolicitudes = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_SAT_LISTA_SOLICITUDES,
																		  	   	  	  "cmbListaSolicitudes",
																		  	   	  	  true, 
																		  	   	  	  true, 
																		  	   	  	  super.getEventoForma(),
																		  	   	  	  EnumEtiquetas.LBL_SAT_LISTA_SOLICITUDES);
		}
		return this.cmbListaSolicitudes;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblListaSolicitudes
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblListaSolicitudes
  	 * @return EtiquetaUtil
  	 * 		   etiqueta gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblListaSolicitudes()throws Exception{

		if(this.lblListaSolicitudes==null){

			this.lblListaSolicitudes = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_SAT_LISTA_SOLICITUDES,
																		 	   	   "lblListaSolicitudes",
																		 	   	   EnumEtiquetas.LBL_SAT_LISTA_SOLICITUDES,
																		 	   	   false,
																		 	   	   null,
																		 	   	   true);
		}
		return this.lblListaSolicitudes;
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
	public JPanel iniciarPropPnlEncabezadoGeneral() throws Exception{
		
		if(this.pnlEncabezadoGeneral==null){
			
			this.pnlEncabezadoGeneral = new FormaPanelEncabezadoGeneral(super.getObjUsuario().getEmpresa(),
														  			   null,
														  			   super.getObjUsuario().getCaja(),
														  			   EnumDimensionesComponentes.PNL_SAT_ENCABEZADO_GENERAL,
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
															  EnumDimensionesComponentes.PNL_SAT_ENCABEZADO_FACTURA,
															  "pnlEncabezadoFactura");
		}
		return this.pnlEncabezadoFactura;
	}

	/**
	 * @method getTxaNotas
	 * 		   Metodo get del atributo txaNotas
	 * @return AreaTextoUtil
	 *		   Valor del atributo txaNotas devuelto
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	public AreaTextoUtil getTxaNotas() {
		return this.txaNotas;
	}

	/**
	 * @method setTxaNotas
	 * 		   Metodo set del atributo txaNotas
	 * @param  pTxaNotas
	 *		   Valor que tomara el atributo txaNotas
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	public void setTxaNotas(AreaTextoUtil pTxaNotas) {
		this.txaNotas = pTxaNotas;
	}

	/**
	 * @method getTxaNotaAdicional
	 * 		   Metodo get del atributo txaNotaAdicional
	 * @return AreaTextoUtil
	 *		   Valor del atributo txaNotaAdicional devuelto
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	public AreaTextoUtil getTxaNotaAdicional() {
		return this.txaNotaAdicional;
	}

	/**
	 * @method setTxaNotaAdicional
	 * 		   Metodo set del atributo txaNotaAdicional
	 * @param  pTxaNotaAdicional
	 *		   Valor que tomara el atributo txaNotaAdicional
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	public void setTxaNotaAdicional(AreaTextoUtil pTxaNotaAdicional) {
		this.txaNotaAdicional = pTxaNotaAdicional;
	}

	/**
	 * @method getTxtReferencia
	 * 		   Metodo get del atributo txtReferencia
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtReferencia devuelto
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	public CajaTextoUtil getTxtReferencia() {
		return this.txtReferencia;
	}

	/**
	 * @method setTxtReferencia
	 * 		   Metodo set del atributo txtReferencia
	 * @param  pTxtReferencia
	 *		   Valor que tomara el atributo txtReferencia
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	public void setTxtReferencia(CajaTextoUtil pTxtReferencia) {
		this.txtReferencia = pTxtReferencia;
	}
	
	/**
	 * @method getPnlEncabezadoGeneral
	 * 		   Metodo get del atributo pnlEncabezadoGeneral
	 * @return JPanel
	 *		   Valor del atributo pnlEncabezadoGeneral devuelto
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	public JPanel getPnlEncabezadoGeneral() {
		return this.pnlEncabezadoGeneral;
	}

	/**
	 * @method setPnlEncabezadoGeneral
	 * 		   Metodo set del atributo pnlEncabezadoGeneral
	 * @param  pPnlEncabezadoGeneral
	 *		   Valor que tomara el atributo pnlEncabezadoGeneral
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	public void setPnlEncabezadoGeneral(JPanel pPnlEncabezadoGeneral) {
		this.pnlEncabezadoGeneral = pPnlEncabezadoGeneral;
	}

	/**
	 * @method getPnlEncabezadoFactura
	 * 		   Metodo get del atributo pnlEncabezadoFactura
	 * @return FormaPanelFactura
	 *		   Valor del atributo pnlEncabezadoFactura devuelto
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	public FormaPanelFactura getPnlEncabezadoFactura() {
		return this.pnlEncabezadoFactura;
	}

	/**
	 * @method setPnlEncabezadoFactura
	 * 		   Metodo set del atributo pnlEncabezadoFactura
	 * @param  pPnlEncabezadoFactura
	 *		   Valor que tomara el atributo pnlEncabezadoFactura
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	public void setPnlEncabezadoFactura(FormaPanelFactura pPnlEncabezadoFactura) {
		this.pnlEncabezadoFactura = pPnlEncabezadoFactura;
	}

	/**
	 * @method getPnlNotas
	 * 		   Metodo get del atributo pnlNotas
	 * @return JPanel
	 *		   Valor del atributo pnlNotas devuelto
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	/*public JPanel getPnlNotas() {
		return this.pnlNotas;
	}*/

	/**
	 * @method setPnlNotas
	 * 		   Metodo set del atributo pnlNotas
	 * @param  pPnlNotas
	 *		   Valor que tomara el atributo pnlNotas
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	/*public void setPnlNotas(JPanel pPnlNotas) {
		this.pnlNotas = pPnlNotas;
	}*/

	/**
	 * @method getPnlNotaAdicional
	 * 		   Metodo get del atributo pnlNotaAdicional
	 * @return JPanel
	 *		   Valor del atributo pnlNotaAdicional devuelto
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	/*public JPanel getPnlNotaAdicional() {
		return this.pnlNotaAdicional;
	}*/

	/**
	 * @method setPnlNotaAdicional
	 * 		   Metodo set del atributo pnlNotaAdicional
	 * @param  pPnlNotaAdicional
	 *		   Valor que tomara el atributo pnlNotaAdicional
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	/*public void setPnlNotaAdicional(JPanel pPnlNotaAdicional) {
		this.pnlNotaAdicional = pPnlNotaAdicional;
	}*/

	/**
	 * @method getPnlTerritorioAgenciaPago
	 * 		   Metodo get del atributo pnlTerritorioAgenciaPago
	 * @return FormaPanelTerritorio
	 *		   Valor del atributo pnlTerritorioAgenciaPago devuelto
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	public FormaPanelTerritorio getPnlTerritorioAgenciaPago() {
		return this.pnlTerritorioAgenciaPago;
	}

	/**
	 * @method setPnlTerritorioAgenciaPago
	 * 		   Metodo set del atributo pnlTerritorioAgenciaPago
	 * @param  pPnlTerritorioAgenciaPago
	 *		   Valor que tomara el atributo pnlTerritorioAgenciaPago
	 * @author roberth.martinez
	 * @date   11/3/2016
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
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	public FormaPanelTerritorio getPnlTerritorioAgenciaOrigen() {
		return this.pnlTerritorioAgenciaOrigen;
	}

	/**
	 * @method setPnlTerritorioAgenciaOrigen
	 * 		   Metodo set del atributo pnlTerritorioAgenciaOrigen
	 * @param  pPnlTerritorioAgenciaOrigen
	 *		   Valor que tomara el atributo pnlTerritorioAgenciaOrigen
	 * @author roberth.martinez
	 * @date   11/3/2016
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
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	public FormaPanelTerritorio getPnlTerritorioAgenciaDestino() {
		return this.pnlTerritorioAgenciaDestino;
	}

	/**
	 * @method setPnlTerritorioAgenciaDestino
	 * 		   Metodo set del atributo pnlTerritorioAgenciaDestino
	 * @param  pPnlTerritorioAgenciaDestino
	 *		   Valor que tomara el atributo pnlTerritorioAgenciaDestino
	 * @author roberth.martinez
	 * @date   11/3/2016
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
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	public FormaPanelTercero getPnlTerceroOrigen() {
		return this.pnlTerceroOrigen;
	}

	/**
	 * @method setPnlTerceroOrigen
	 * 		   Metodo set del atributo pnlTerceroOrigen
	 * @param  pPnlTerceroOrigen
	 *		   Valor que tomara el atributo pnlTerceroOrigen
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	public void setPnlTerceroOrigen(FormaPanelTercero pPnlTerceroOrigen) {
		this.pnlTerceroOrigen = pPnlTerceroOrigen;
	}

	/**
	 * @method getPnlTerceroNuevo
	 * 		   Metodo get del atributo pnlTerceroNuevo
	 * @return FormaPanelTercero
	 *		   Valor del atributo pnlTerceroNuevo devuelto
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	public FormaPanelTercero getPnlTerceroNuevo() {
		return this.pnlTerceroNuevo;
	}

	/**
	 * @method setPnlTerceroNuevo
	 * 		   Metodo set del atributo pnlTerceroNuevo
	 * @param  pPnlTerceroNuevo
	 *		   Valor que tomara el atributo pnlTerceroNuevo
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	public void setPnlTerceroNuevo(FormaPanelTercero pPnlTerceroNuevo) {
		this.pnlTerceroNuevo = pPnlTerceroNuevo;
	}

	/**
	 * @method getPnlTerceroDestino
	 * 		   Metodo get del atributo pnlTerceroDestino
	 * @return FormaPanelTercero
	 *		   Valor del atributo pnlTerceroDestino devuelto
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	public FormaPanelTercero getPnlTerceroDestino() {
		return this.pnlTerceroDestino;
	}

	/**
	 * @method setPnlTerceroDestino
	 * 		   Metodo set del atributo pnlTerceroDestino
	 * @param  pPnlTerceroDestino
	 *		   Valor que tomara el atributo pnlTerceroDestino
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	public void setPnlTerceroDestino(FormaPanelTercero pPnlTerceroDestino) {
		this.pnlTerceroDestino = pPnlTerceroDestino;
	}

	/**
	 * @method getScpAreaTextoNotas
	 * 		   Metodo get del atributo scpAreaTextoNotas
	 * @return JScrollPane
	 *		   Valor del atributo scpAreaTextoNotas devuelto
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	public JScrollPane getScpAreaTextoNotas() {
		return this.scpAreaTextoNotas;
	}

	/**
	 * @method setScpAreaTextoNotas
	 * 		   Metodo set del atributo scpAreaTextoNotas
	 * @param  pScpAreaTextoNotas
	 *		   Valor que tomara el atributo scpAreaTextoNotas
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	public void setScpAreaTextoNotas(JScrollPane pScpAreaTextoNotas) {
		this.scpAreaTextoNotas = pScpAreaTextoNotas;
	}

	/**
	 * @method getScpAreaTextoNotaAdicional
	 * 		   Metodo get del atributo scpAreaTextoNotaAdicional
	 * @return JScrollPane
	 *		   Valor del atributo scpAreaTextoNotaAdicional devuelto
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	public JScrollPane getScpAreaTextoNotaAdicional() {
		return this.scpAreaTextoNotaAdicional;
	}

	/**
	 * @method setScpAreaTextoNotaAdicional
	 * 		   Metodo set del atributo scpAreaTextoNotaAdicional
	 * @param  pScpAreaTextoNotaAdicional
	 *		   Valor que tomara el atributo scpAreaTextoNotaAdicional
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	public void setScpAreaTextoNotaAdicional(JScrollPane pScpAreaTextoNotaAdicional) {
		this.scpAreaTextoNotaAdicional = pScpAreaTextoNotaAdicional;
	}

	/**
	 * @method getCmbListaAnotaciones
	 * 		   Metodo get del atributo cmbListaAnotaciones
	 * @return CajaComboUtil
	 *		   Valor del atributo cmbListaAnotaciones devuelto
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	public CajaComboUtil getCmbListaAnotaciones() {
		return this.cmbListaAnotaciones;
	}

	/**
	 * @method setCmbListaAnotaciones
	 * 		   Metodo set del atributo cmbListaAnotaciones
	 * @param  pCmbListaAnotaciones
	 *		   Valor que tomara el atributo cmbListaAnotaciones
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	public void setCmbListaAnotaciones(CajaComboUtil pCmbListaAnotaciones) {
		this.cmbListaAnotaciones = pCmbListaAnotaciones;
	}

	/**
	 * @method getCmbListaSolicitudes
	 * 		   Metodo get del atributo cmbListaSolicitudes
	 * @return CajaComboUtil
	 *		   Valor del atributo cmbListaSolicitudes devuelto
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	public CajaComboUtil getCmbListaSolicitudes() {
		return this.cmbListaSolicitudes;
	}

	/**
	 * @method setCmbListaSolicitudes
	 * 		   Metodo set del atributo cmbListaSolicitudes
	 * @param  pCmbListaSolicitudes
	 *		   Valor que tomara el atributo cmbListaSolicitudes
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	public void setCmbListaSolicitudes(CajaComboUtil pCmbListaSolicitudes) {
		this.cmbListaSolicitudes = pCmbListaSolicitudes;
	}

	/**
	 * @method getLblListaSolicitudes
	 * 		   Metodo get del atributo lblListaSolicitudes
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblListaSolicitudes devuelto
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	public EtiquetaUtil getLblListaSolicitudes() {
		return this.lblListaSolicitudes;
	}

	/**
	 * @method setLblListaSolicitudes
	 * 		   Metodo set del atributo lblListaSolicitudes
	 * @param  pLblListaSolicitudes
	 *		   Valor que tomara el atributo lblListaSolicitudes
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	public void setLblListaSolicitudes(EtiquetaUtil pLblListaSolicitudes) {
		this.lblListaSolicitudes = pLblListaSolicitudes;
	}

	/**
	 * @method getLblReferencia
	 * 		   Metodo get del atributo lblReferencia
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblReferencia devuelto
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	public EtiquetaUtil getLblReferencia() {
		return this.lblReferencia;
	}

	/**
	 * @method setLblReferencia
	 * 		   Metodo set del atributo lblReferencia
	 * @param  pLblReferencia
	 *		   Valor que tomara el atributo lblReferencia
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	public void setLblReferencia(EtiquetaUtil pLblReferencia) {
		this.lblReferencia = pLblReferencia;
	}

	/**
	 * @method getLblListaAnotaciones
	 * 		   Metodo get del atributo lblListaAnotaciones
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblListaAnotaciones devuelto
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	public EtiquetaUtil getLblListaAnotaciones() {
		return this.lblListaAnotaciones;
	}

	/**
	 * @method setLblListaAnotaciones
	 * 		   Metodo set del atributo lblListaAnotaciones
	 * @param  pLblListaAnotaciones
	 *		   Valor que tomara el atributo lblListaAnotaciones
	 * @author roberth.martinez
	 * @date   11/3/2016
	 */
	public void setLblListaAnotaciones(EtiquetaUtil pLblListaAnotaciones) {
		this.lblListaAnotaciones = pLblListaAnotaciones;
	}

	/**
	 * @method getScpServiciosAdicionales
	 * 		   Metodo get del atributo scpServiciosAdicionales
	 * @return FormaPanelDesplazableServiciosAdicionales
	 *		   Valor del atributo scpServiciosAdicionales devuelto
	 * @author roberth.martinez
	 * @date   23/3/2016
	 */
	public FormaPanelDesplazableServiciosAdicionales getScpServiciosAdicionales() {
		return this.scpServiciosAdicionales;
	}

	/**
	 * @method setScpServiciosAdicionales
	 * 		   Metodo set del atributo scpServiciosAdicionales
	 * @param  pScpServiciosAdicionales
	 *		   Valor que tomara el atributo scpServiciosAdicionales
	 * @author roberth.martinez
	 * @date   23/3/2016
	 */
	public void setScpServiciosAdicionales(
			FormaPanelDesplazableServiciosAdicionales pScpServiciosAdicionales) {
		this.scpServiciosAdicionales = pScpServiciosAdicionales;
	}

	/** 
	 * ********************************************************************
	 * @method main
	 * 		   metodo main
	 * @param  args
	 * 		   argumentos main
	 * @author roberth.martinez
	 * @date   11/3/2016
	 * *********************************************************************
	 */
	public static void main(String[] args) {
		
		JFrame jframe = null;
		
		try{
	        
			jframe = TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaSolicitudAutorizacion.class,
																			true, 
																			EnumDesplegarFormaConEventos.SI);
			new FormaSolicitudAutorizacion(jframe,true);
			
		} catch (Exception e) {
			
			UtilidadesGiros.getInstance().controlExcepcion(e, 
														   null);
		}
	}

}

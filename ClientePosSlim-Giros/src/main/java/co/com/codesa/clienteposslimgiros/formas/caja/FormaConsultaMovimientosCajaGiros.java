package co.com.codesa.clienteposslimgiros.formas.caja;

import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import co.com.codesa.clienteposslim.general.InformacionSession;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.caja.EventoFormaConsultaMovimientosCajaGiros;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaFechaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.GrillaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelEncabezadoGeneral;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.utilidades.integracion.slimGiros.UtilIntegracionSlimGiros;

/**
 * 
 * ********************************************************************
 * @class 	FormaConsultaMovimientosCajaGiros
 *		   	Clase que genera y administra la forma (GUI) para la 
 *			funcionalidad de consulta movimientos de caja
 * @author 	Roberth Martinez Vargas
 * @date   	30/11/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class FormaConsultaMovimientosCajaGiros extends FormaGenerica{

	/**
	 * @variable 	serialVersionUID
	 * 			 	Variable serialVersionUID
	 */
	private static final long serialVersionUID = 2475173309802427311L;
	
	/**
	 * @variable 	pnlEncabezadoGeneral
	 * 			 	seccion que aloja el encabezado general para las formas, que contiene 
	 * 			 	los valores de agencia, empresa y caja, normalmente recuperados del 
	 * 			 	usuario autenticado
	 **/
	private FormaPanelEncabezadoGeneral pnlEncabezadoGeneral;
	
	/**
	 * @variable 	scpTblSaldosMedioPago
	 * 			 	Contenedor con desplazable que contiene la tabla de los saldos de 
	 * 				medios de pago 
	 **/
	private JScrollPane scpTblSaldosMedioPago;
	
	/**
	 * @variable 	scpTblDetalleMovimientos
	 * 			 	Contenedor desplazable que contiene la tabla del detalle de 
	 * 				movimientos 
	 **/
	private JScrollPane scpTblDetalleMovimientos;
	
	/**
	 * @variable 	scpTblTotalXmedioPagoConcepto
	 * 			 	Contenedor desplazable que contiene la tabla de los totales x medio
	 * 				de pago y concepto
	 **/
	private JScrollPane scpTblTotalXmedioPagoConcepto;
	
	/**
	 * @variable 	tblSaldosMedioPago
	 * 			 	Tabla que representa los saldos de medios de pago consultados
	 **/
	private GrillaUtil tblSaldosMedioPago;
	
	/**
	 * @variable 	tblDetalleMovimientos
	 * 			 	Tabla que representa el detalle de los movimientos consultados 
	 **/
	private GrillaUtil tblDetalleMovimientos;
	
	/**
	 * @variable 	tblTotalXmedioPagoConcepto
	 * 			 	Tabla que representa el detalle de los totales x medio de pago y 
	 * 				concepto
	 **/
	private GrillaUtil tblTotalXmedioPagoConcepto;
	
	/**
	 * @variable 	dtcFechaConsulta
	 * 			 	Campo para diligenciar la fecha de consulta
	 **/
	private CajaFechaUtil dtcFechaConsulta;
	
	/**
	 * @variable 	lblFechaConsulta
	 * 			 	Etiqueta que identifica el campo para diligenciar la fecha de 
	 * 				consulta
	 */
	private EtiquetaUtil lblFechaConsulta;

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
  	 * @author 	Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public FormaConsultaMovimientosCajaGiros(JFrame pFrmPadre,
											 boolean pBooModal) throws Exception 
	{
		super(pFrmPadre,
			  pBooModal);
		
		super.setEventoForma(new EventoFormaConsultaMovimientosCajaGiros(this));
		
		this.inicializarForma();
	}

	@Override
	public void inicializarForma(Object ...pArrObjParametrosForma) throws Exception {
		
		super.setTituloForma(EnumEtiquetas.TTL_MCG_VENTANA);
		
		super.setAnchoForma(EnumDimensionesComponentes.FRM_MCG_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.FRM_MCG_VENTANA.getAlto());
        
		super.adicionarAcciones(EnumBotonesEncabezado.BTNCONSULTAR,
								EnumBotonesEncabezado.BTN_LIMPIAR,
								EnumBotonesEncabezado.BTNSALIR);
		
		super.iniciar(pArrObjParametrosForma);
	}
	
	@Override
	public JPanel  inicializarEncabezado(Object ...pArrObjParametrosEncabezado) throws Exception {
		
		SeccionUtil pnlEncabezado;
		
		pnlEncabezado = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_MCG_PANEL_ENCABEZADO,
																	"pnlEncabezado",
																	null,
																	null,
																	null);
		pnlEncabezado.setBooAplicarTransparenciaFondo(true);
		
		pnlEncabezado.add(this.iniciarPropPnlEncabezadoGeneral());
		pnlEncabezado.add(this.iniciarPropLblFechaConsulta());
		pnlEncabezado.add(this.iniciarPropDtcFechaConsulta());
		
		return pnlEncabezado;
	}

	@Override
	public JPanel inicializarCuerpo(Object ...pArrObjParametrosCuerpo) throws Exception {
		
		SeccionUtil pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_MCG_PANEL_CUERPO,
																"pnlCuerpo",
																BorderFactory.createEmptyBorder(),
				  												null,
				  												null);
		pnlCuerpo.setBooAplicarTransparenciaFondo(true);
		
		pnlCuerpo.add(this.iniciarPropScpTblDetalleMovimientos());
		pnlCuerpo.add(this.iniciarPropScpTblTotalXmedioPagoConcepto());

		return pnlCuerpo;
	}

	@Override
	public	JPanel	inicializarPiePagina	(	Object ...pArrObjParametrosPiePagina	)	throws	Exception 
	{
		
		SeccionUtil pnlPiePagina;
		
		pnlPiePagina = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_MCG_PANEL_PIE,
																   "pnlPiePagina",
																   BorderFactory.createEmptyBorder(),
			   	  												   null,
			   	  												   null);
		pnlPiePagina.setBooAplicarTransparenciaFondo(true);
		
		pnlPiePagina.add(this.iniciarPropScpTblSaldosMedioPago());
		
		return pnlPiePagina;
	}
	
	/**
  	 * ****************************************************************.
  	 * @method iniciarPropPnlEncabezadoGeneral 
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pnlEncabezadoGeneral
  	 * @return FormaPanelEncabezadoGeneral
  	 * 		   seccion de encabezado general gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor  Roberth Martinez Vargas
  	 * @date   9/03/2016
  	 * ****************************************************************
  	 */
	public FormaPanelEncabezadoGeneral iniciarPropPnlEncabezadoGeneral() throws Exception{
		
		if(this.pnlEncabezadoGeneral==null){
			
			this.pnlEncabezadoGeneral = new FormaPanelEncabezadoGeneral(super.getObjUsuario().getEmpresa(),
														  			   null,
														  			   super.getObjUsuario().getCaja(),
														  			   EnumDimensionesComponentes.PNL_MCG_PANEL_ENCABEZADOGRAL,
														  			   "pnlEncabezadoGeneral");
		}
		
		return this.pnlEncabezadoGeneral;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo 	iniciarPropLblFechaConsulta
  	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblFechaConsulta
  	 * @return 	EtiquetaUtil
  	 * 		   	etiqueta gestionada 
  	 * @throws 	Exception
  	 * 		   	Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
  	 * @autor 	Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblFechaConsulta() throws Exception{
		
		if (this.lblFechaConsulta == null) {
			
			this.lblFechaConsulta = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_MCG_BUSQUEDA, 
																		   "lblFechaConsulta", 
																		   EnumEtiquetas.LBL_MCG_BUSQUEDA,
																		   true,
																		   null,
																		   true);
		}

		return this.lblFechaConsulta;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo 	iniciarPropDtcFechaConsulta
  	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	dtcFechaConsulta
  	 * @return 	EtiquetaUtil
  	 * 		   	etiqueta gestionada 
  	 * @throws 	Exception
  	 * 		   	Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
  	 * @autor 	Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public CajaFechaUtil iniciarPropDtcFechaConsulta() throws Exception{
		
		if (this.dtcFechaConsulta == null) {
			
			this.dtcFechaConsulta	=	UtilComponentesGUI.getInstance().crearCalendar	(	EnumDimensionesComponentes.DTC_MCG_FECHA_BUS, 
																		  	  				"dtcFechaConsulta", 
																		  	  				UtilIntegracionSlimGiros.getInstance().obtenerFechaHoraActualPosSlim(), 
																		  	  				true, 
																		  	  				super.getEventoForma(),
																		  	  				EnumEtiquetas.LBL_MCG_BUSQUEDA
																		  	  			);
		}
		
		return this.dtcFechaConsulta;
	}
	
	/**
  	 * ****************************************************************.
  	 * @method 	iniciarPropScpTblDetalleMovimientos
  	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	scpTblDetalleMovimientos
  	 * @return 	JScrollPane
  	 * 		   	contenedor para el despliegue de grilla gestionado
  	 * @throws 	Exception
  	 * 		   	Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
  	 * @autor 	Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public JScrollPane iniciarPropScpTblDetalleMovimientos() throws Exception{
		
		if	(	this.scpTblDetalleMovimientos	==	null	)
		{
			this.scpTblDetalleMovimientos	=	this.iniciarPropTblDetalleMovimientos().getScpContenedorRound(EnumDimensionesComponentes.SCP_MCG_GRID_DETALLE_MOVIMIENTOS);
			
			this.scpTblDetalleMovimientos.setBorder	(	BorderFactory.createTitledBorder(	null,
																							EnumEtiquetas.PNL_MCG_DETALLE_MOVIMIENTOS.toString(),
																							TitledBorder.CENTER,
																							TitledBorder.TOP
																						)
														);
		}
		
		return this.scpTblDetalleMovimientos;
	}
	
	/**
  	 * ****************************************************************.
  	 * @method	iniciarPropTblDetalleMovimientos
  	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	tblDetalleMovimientos
  	 * @return 	GrillaUtil 
  	 * 		   	grilla gestionada
  	 * @throws 	Exception 
  	 * 		   	Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
  	 * @autor 	Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public GrillaUtil iniciarPropTblDetalleMovimientos() throws Exception{
		
		if(this.tblDetalleMovimientos==null){
			
			this.tblDetalleMovimientos = UtilComponentesGUI.getInstance().crearGrilla("tblDetalleMovimientos",
															   						  new EnumEtiquetas[]{EnumEtiquetas.TTL_MCG_GRILLA_DETALLE_MOVIMIENTOS_MONEDA,
																								   		  EnumEtiquetas.TTL_MCG_GRILLA_DETALLE_MOVIMIENTOS_MEDIO_PAGO,
																								   		  EnumEtiquetas.TTL_MCG_GRILLA_DETALLE_MOVIMIENTOS_CONCEPTO,
																								   		  EnumEtiquetas.TTL_MCG_GRILLA_DETALLE_MOVIMIENTOS_FECHA,
																								   		  EnumEtiquetas.TTL_MCG_GRILLA_DETALLE_MOVIMIENTOS_HORA,
																								   		  EnumEtiquetas.TTL_MCG_GRILLA_DETALLE_MOVIMIENTOS_REFERENCIA,
																								   		  EnumEtiquetas.TTL_MCG_GRILLA_DETALLE_MOVIMIENTOS_INGRESOS,
																								   		  EnumEtiquetas.TTL_MCG_GRILLA_DETALLE_MOVIMIENTOS_EGRESOS},
															   						  null,//invisibles
															   						  null,
																				      new int[] {54,
																								 65,
																								 70,
																								 62,
																								 60,
																								 90,
																								 80,
																								 80},//dimensiones
																				      null//evento
																					   );
			this.tblDetalleMovimientos.activarOrdenamiento(true);
		}
		
		return this.tblDetalleMovimientos;
	}
	
	/**
  	 * ****************************************************************.
  	 * @method 	iniciarPropScpTblTotalXmedioPagoConcepto
  	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	scpTblTotalXmedioPagoConcepto
  	 * @return 	JScrollPane
  	 * 		   	contenedor para el despliegue de grilla gestionado
  	 * @throws 	Exception
  	 * 		   	Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
  	 * @autor 	Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public JScrollPane iniciarPropScpTblTotalXmedioPagoConcepto() throws Exception{
		
		if	(	this.scpTblTotalXmedioPagoConcepto	==	null	)
		{
			this.scpTblTotalXmedioPagoConcepto = this.iniciarPropTblTotalXmedioPagoConcepto().getScpContenedorRound(EnumDimensionesComponentes.SCP_MCG_GRID_TOTAL_X_CONCEPTO);
			
			this.scpTblTotalXmedioPagoConcepto.setBorder	(	BorderFactory.createTitledBorder(	null,
																									EnumEtiquetas.PNL_MCG_TOTAL_X_CONCEPTO.toString(),
																									TitledBorder.CENTER,
																									TitledBorder.TOP
																								)
													);
		}
		
		return this.scpTblTotalXmedioPagoConcepto;
	}
	
	/**
  	 * ****************************************************************.
  	 * @method	iniciarPropTblTotalXmedioPagoConcepto
  	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	tblTotalXmedioPagoConcepto
  	 * @return 	GrillaUtil 
  	 * 		   	grilla gestionada
  	 * @throws 	Exception 
  	 * 		   	Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
  	 * @autor 	Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public GrillaUtil iniciarPropTblTotalXmedioPagoConcepto() throws Exception{
		
		if(this.tblTotalXmedioPagoConcepto==null){
			
			this.tblTotalXmedioPagoConcepto = UtilComponentesGUI.getInstance().crearGrilla("tblTotalXmedioPagoConcepto",
															   							   new EnumEtiquetas[]{EnumEtiquetas.TTL_MCG_GRILLA_TOTAL_X_CONCEPTO_NUMERO,
																											   EnumEtiquetas.TTL_MCG_GRILLA_TOTAL_X_CONCEPTO_MEDIO_PAGO,
																											   EnumEtiquetas.TTL_MCG_GRILLA_TOTAL_X_CONCEPTO_CONCEPTO,
																											   EnumEtiquetas.TTL_MCG_GRILLA_TOTAL_X_CONCEPTO_INGRESOS,
																											   EnumEtiquetas.TTL_MCG_GRILLA_TOTAL_X_CONCEPTO_EGRESOS},
															   							   null,//invisibles
															   							   null,/*new boolean[] {false, 
																										  false, 
																										  false,
																										  false, 
																										  false},//editable por columna*/
																						   new int[] {19,
																									  45,
																									  52,
																									  64,
																									  64},//dimensiones
																					       null//evento
																						   );
			this.tblTotalXmedioPagoConcepto.activarOrdenamiento(true);
		}
		
		return this.tblTotalXmedioPagoConcepto;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo 	iniciarPropScpTblSaldosMedioPago
  	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	scpTblSaldosMedioPago
  	 * @return 	JScrollPane
  	 * 		   	contenedor para el despliegue de grilla gestionado
  	 * @throws 	Exception
  	 * 		   	Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
  	 * @autor 	Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public JScrollPane iniciarPropScpTblSaldosMedioPago() throws Exception{
		
		if	(	this.scpTblSaldosMedioPago	==	null	)
		{
			this.scpTblSaldosMedioPago	=	this.iniciarPropTblSaldosMedioPago().getScpContenedorRound(EnumDimensionesComponentes.SCP_MCG_GRID_SALDOSMEDIOPAGO);
			
			this.scpTblSaldosMedioPago.setBorder	(	BorderFactory.createTitledBorder(	null,
																							EnumEtiquetas.PNL_MCG_SALDOSMEDIOPAGO.toString(),
																							TitledBorder.CENTER,
																							TitledBorder.TOP
																						)
													);
		}
		
		return this.scpTblSaldosMedioPago;
	}
	
	/**
  	 * ****************************************************************.
  	 * @method	iniciarPropTblSaldosMedioPago
  	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	tblSaldosMedioPago
  	 * @return 	GrillaUtil 
  	 * 		   	grilla gestionada
  	 * @throws 	Exception 
  	 * 		   	Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
  	 * @autor 	Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public GrillaUtil iniciarPropTblSaldosMedioPago() throws Exception{
		
		if(this.tblSaldosMedioPago==null){
			
			this.tblSaldosMedioPago = UtilComponentesGUI.getInstance().crearGrilla("tblSaldosMedioPago",
															   					   new EnumEtiquetas[]{EnumEtiquetas.TTL_MCG_GRILLA_SALDOS_MEDIO_PAGO,
																									   EnumEtiquetas.TTL_MCG_GRILLA_SALDOS_MONEDA,
																									   EnumEtiquetas.TTL_MCG_GRILLA_SALDOS_SALDO_INICIAL,
																									   EnumEtiquetas.TTL_MCG_GRILLA_SALDOS_INGRESOS,
																									   EnumEtiquetas.TTL_MCG_GRILLA_SALDOS_EGRESOS,
																									   EnumEtiquetas.TTL_MCG_GRILLA_SALDOS_TRASLADOS,
																									   EnumEtiquetas.TTL_MCG_GRILLA_SALDOS_SALDO_FINAL},
															   					   null,//invisibles
															   					   null,/*new boolean[] {false, 
																								  false, 
																								  false,
																								  false, 
																								  false, 
																								  false},//editable por columna*/
																				   new int[] {185,
																							  140,
																							  115,
																							  90,
																							  90,
																							  115},//dimensiones
															   		               null//evento
																				   );
			this.tblSaldosMedioPago.activarOrdenamiento(true);
		}
		
		return this.tblSaldosMedioPago;
	}
	
	/**
	 * @method getPnlEncabezadoGeneral
	 * 		   Metodo get del atributo pnlEncabezadoGeneral
	 * @return FormaPanelEncabezadoGeneral
	 *		   Valor del atributo pnlEncabezadoGeneral devuelto
	 * @author hector.cuenca
	 * @date   30/11/2016
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
	 * @date   30/11/2016
	 */
	public void setPnlEncabezadoGeneral(
			FormaPanelEncabezadoGeneral pPnlEncabezadoGeneral) {
		this.pnlEncabezadoGeneral = pPnlEncabezadoGeneral;
	}

	/**
	 * @method getScpTblSaldosMedioPago
	 * 		   Metodo get del atributo scpTblSaldosMedioPago
	 * @return JScrollPane
	 *		   Valor del atributo scpTblSaldosMedioPago devuelto
	 * @author hector.cuenca
	 * @date   30/11/2016
	 */
	public JScrollPane getScpTblSaldosMedioPago() {
		return this.scpTblSaldosMedioPago;
	}

	/**
	 * @method setScpTblSaldosMedioPago
	 * 		   Metodo set del atributo scpTblSaldosMedioPago
	 * @param  pScpTblSaldosMedioPago
	 *		   Valor que tomara el atributo scpTblSaldosMedioPago
	 * @author hector.cuenca
	 * @date   30/11/2016
	 */
	public void setScpTblSaldosMedioPago(JScrollPane pScpTblSaldosMedioPago) {
		this.scpTblSaldosMedioPago = pScpTblSaldosMedioPago;
	}

	/**
	 * @method getScpTblDetalleMovimientos
	 * 		   Metodo get del atributo scpTblDetalleMovimientos
	 * @return JScrollPane
	 *		   Valor del atributo scpTblDetalleMovimientos devuelto
	 * @author hector.cuenca
	 * @date   30/11/2016
	 */
	public JScrollPane getScpTblDetalleMovimientos() {
		return this.scpTblDetalleMovimientos;
	}

	/**
	 * @method setScpTblDetalleMovimientos
	 * 		   Metodo set del atributo scpTblDetalleMovimientos
	 * @param  pScpTblDetalleMovimientos
	 *		   Valor que tomara el atributo scpTblDetalleMovimientos
	 * @author hector.cuenca
	 * @date   30/11/2016
	 */
	public void setScpTblDetalleMovimientos(JScrollPane pScpTblDetalleMovimientos) {
		this.scpTblDetalleMovimientos = pScpTblDetalleMovimientos;
	}

	/**
	 * @method getScpTblTotalXmedioPagoConcepto
	 * 		   Metodo get del atributo scpTblTotalXmedioPagoConcepto
	 * @return JScrollPane
	 *		   Valor del atributo scpTblTotalXmedioPagoConcepto devuelto
	 * @author hector.cuenca
	 * @date   30/11/2016
	 */
	public JScrollPane getScpTblTotalXmedioPagoConcepto() {
		return this.scpTblTotalXmedioPagoConcepto;
	}

	/**
	 * @method setScpTblTotalXmedioPagoConcepto
	 * 		   Metodo set del atributo scpTblTotalXmedioPagoConcepto
	 * @param  pScpTblTotalXmedioPagoConcepto
	 *		   Valor que tomara el atributo scpTblTotalXmedioPagoConcepto
	 * @author hector.cuenca
	 * @date   30/11/2016
	 */
	public void setScpTblTotalXmedioPagoConcepto(
			JScrollPane pScpTblTotalXmedioPagoConcepto) {
		this.scpTblTotalXmedioPagoConcepto = pScpTblTotalXmedioPagoConcepto;
	}

	/**
	 * @method getTblSaldosMedioPago
	 * 		   Metodo get del atributo tblSaldosMedioPago
	 * @return GrillaUtil
	 *		   Valor del atributo tblSaldosMedioPago devuelto
	 * @author hector.cuenca
	 * @date   30/11/2016
	 */
	public GrillaUtil getTblSaldosMedioPago() {
		return this.tblSaldosMedioPago;
	}

	/**
	 * @method setTblSaldosMedioPago
	 * 		   Metodo set del atributo tblSaldosMedioPago
	 * @param  pTblSaldosMedioPago
	 *		   Valor que tomara el atributo tblSaldosMedioPago
	 * @author hector.cuenca
	 * @date   30/11/2016
	 */
	public void setTblSaldosMedioPago(GrillaUtil pTblSaldosMedioPago) {
		this.tblSaldosMedioPago = pTblSaldosMedioPago;
	}

	/**
	 * @method getTblDetalleMovimientos
	 * 		   Metodo get del atributo tblDetalleMovimientos
	 * @return GrillaUtil
	 *		   Valor del atributo tblDetalleMovimientos devuelto
	 * @author hector.cuenca
	 * @date   30/11/2016
	 */
	public GrillaUtil getTblDetalleMovimientos() {
		return this.tblDetalleMovimientos;
	}

	/**
	 * @method setTblDetalleMovimientos
	 * 		   Metodo set del atributo tblDetalleMovimientos
	 * @param  pTblDetalleMovimientos
	 *		   Valor que tomara el atributo tblDetalleMovimientos
	 * @author hector.cuenca
	 * @date   30/11/2016
	 */
	public void setTblDetalleMovimientos(GrillaUtil pTblDetalleMovimientos) {
		this.tblDetalleMovimientos = pTblDetalleMovimientos;
	}

	/**
	 * @method getTblTotalXmedioPagoConcepto
	 * 		   Metodo get del atributo tblTotalXmedioPagoConcepto
	 * @return GrillaUtil
	 *		   Valor del atributo tblTotalXmedioPagoConcepto devuelto
	 * @author hector.cuenca
	 * @date   30/11/2016
	 */
	public GrillaUtil getTblTotalXmedioPagoConcepto() {
		return this.tblTotalXmedioPagoConcepto;
	}

	/**
	 * @method setTblTotalXmedioPagoConcepto
	 * 		   Metodo set del atributo tblTotalXmedioPagoConcepto
	 * @param  pTblTotalXmedioPagoConcepto
	 *		   Valor que tomara el atributo tblTotalXmedioPagoConcepto
	 * @author hector.cuenca
	 * @date   30/11/2016
	 */
	public void setTblTotalXmedioPagoConcepto(GrillaUtil pTblTotalXmedioPagoConcepto) {
		this.tblTotalXmedioPagoConcepto = pTblTotalXmedioPagoConcepto;
	}

	/**
	 * @method getDtcFechaConsulta
	 * 		   Metodo get del atributo dtcFechaConsulta
	 * @return CajaFechaUtil
	 *		   Valor del atributo dtcFechaConsulta devuelto
	 * @author hector.cuenca
	 * @date   30/11/2016
	 */
	public CajaFechaUtil getDtcFechaConsulta() {
		return this.dtcFechaConsulta;
	}

	/**
	 * @method setDtcFechaConsulta
	 * 		   Metodo set del atributo dtcFechaConsulta
	 * @param  pDtcFechaConsulta
	 *		   Valor que tomara el atributo dtcFechaConsulta
	 * @author hector.cuenca
	 * @date   30/11/2016
	 */
	public void setDtcFechaConsulta(CajaFechaUtil pDtcFechaConsulta) {
		this.dtcFechaConsulta = pDtcFechaConsulta;
	}

	/**
	 * @method getLblFechaConsulta
	 * 		   Metodo get del atributo lblFechaConsulta
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblFechaConsulta devuelto
	 * @author hector.cuenca
	 * @date   30/11/2016
	 */
	public EtiquetaUtil getLblFechaConsulta() {
		return this.lblFechaConsulta;
	}

	/**
	 * @method setLblFechaConsulta
	 * 		   Metodo set del atributo lblFechaConsulta
	 * @param  pLblFechaConsulta
	 *		   Valor que tomara el atributo lblFechaConsulta
	 * @author hector.cuenca
	 * @date   30/11/2016
	 */
	public void setLblFechaConsulta(EtiquetaUtil pLblFechaConsulta) {
		this.lblFechaConsulta = pLblFechaConsulta;
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
	public static void main(String[] args){
		
		JFrame jframe = null;
		
		try{
	        
			jframe = TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaConsultaMovimientosCajaGiros.class,
																			true, 
																			EnumDesplegarFormaConEventos.SI);
			new FormaConsultaMovimientosCajaGiros(jframe,true);
			
		} catch (Exception e) {
			
			UtilidadesGiros.getInstance().controlExcepcion(e, 
														   null);
		}
	}
	
}

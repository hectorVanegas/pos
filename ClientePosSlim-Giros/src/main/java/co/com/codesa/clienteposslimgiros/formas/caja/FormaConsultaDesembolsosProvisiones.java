package co.com.codesa.clienteposslimgiros.formas.caja;

import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.caja.EventoFormaConsultaDesembolsosProvisiones;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaFechaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.GrillaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelEncabezadoGeneral;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.utilidades.integracion.slimGiros.UtilIntegracionSlimGiros;

/**
 * ****************************************************************.
 * @autor: Roberth Martinez Vargas
 * @fecha: 14-abr-2015
 * @descripcion: Clase para consultar los movimientos provisiones de la caja 
 * 				 de giros postales
 * @copyright: Copyright  1998-2012 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class FormaConsultaDesembolsosProvisiones extends FormaGenerica{
	
	private JPanel pnlEncabezadoGeneral;
	private JPanel pnlTotalConcepto;
	private JPanel pnlTotalMoneda;
	private EtiquetaUtil lblBusqueda;
	private CajaFechaUtil dtcFechaBus;
	private JScrollPane scpTblMovProvisiones;
	private JScrollPane scpTblTotalMoneda;
	private JScrollPane scpTblTotalConcepto;
	private GrillaUtil tblMovProvisiones;
	private GrillaUtil tblMoneda;
	private GrillaUtil tblConcepto;
	
	private static final long serialVersionUID = 1L;

	public FormaConsultaDesembolsosProvisiones(JFrame pFrmPadre, 
											   boolean pBooModal) throws Exception {
		super(pFrmPadre, pBooModal);
		
		super.setEventoForma(new EventoFormaConsultaDesembolsosProvisiones(this));
		
		this.inicializarForma();
	}

	@Override
	public void inicializarForma(Object... pArrObjParametrosForma) throws Exception {
		
		super.setTituloForma(EnumEtiquetas.TTL_CMP_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.FRM_CMP_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.FRM_CMP_VENTANA.getAlto());
        
		super.adicionarAcciones(EnumBotonesEncabezado.BTNCONSULTAR,
								EnumBotonesEncabezado.BTNSALIR);
		
		super.iniciar(pArrObjParametrosForma);
	}

	@Override
	public JPanel inicializarEncabezado(Object ...pArrObjParametrosEncabezado) throws Exception {
		
		JPanel pnlEncabezado;
		
		pnlEncabezado = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_CMP_PANEL_ENCABEZADO,
																	"pnlEncabezado",
				  													null,
				  													null,
				  													null);
		pnlEncabezado.add(this.iniciarPropPnlEncabezadoGeneral());
		pnlEncabezado.add(this.iniciarPropLblBusqueda());
		pnlEncabezado.add(this.iniciarPropJdcFechaBus());
		
		return pnlEncabezado;
	}

	@Override
	public JPanel inicializarCuerpo(Object ...pArrObjParametrosCuerpo) throws Exception {
		
		JPanel pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_CMP_PANEL_CUERPO,
																"pnlCuerpo",
				  												BorderFactory.createBevelBorder(BevelBorder.LOWERED),
				  												null,
				  												null);
		pnlCuerpo.add(this.iniciarPropScpTblMovProvisiones());
		return pnlCuerpo;
	}

	@Override
	public JPanel inicializarPiePagina(Object ...pArrObjParametrosPiePagina) throws Exception {
		
		JPanel pnlPiePagina;
		
		pnlPiePagina = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_CMP_PANEL_PIE,
																   "pnlPiePagina",
				 												   BorderFactory.createBevelBorder(BevelBorder.LOWERED),
				 												   null,
				 												   null);
		pnlPiePagina.add(this.iniciarPropPnlTotalConcepto());
		pnlPiePagina.add(this.iniciarPropPnlTotalMoneda());
		return pnlPiePagina;
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo: iniciarPropPnlEncabezadoGeneral
     * @descripcion: metodo utilizado para inicializar el componente panel de Empresa y caja
     * @return: JPanel componente JPanel
     * @autor: Roberth Martinez Vargas
     * ****************************************************************
     */
	public JPanel iniciarPropPnlEncabezadoGeneral() throws Exception{
		
		if(this.pnlEncabezadoGeneral==null){
			
			this.pnlEncabezadoGeneral = new FormaPanelEncabezadoGeneral(super.getObjUsuario().getEmpresa(),
														  			   null,
														  			   super.getObjUsuario().getCaja(),
														  			   EnumDimensionesComponentes.PNL_CMP_PANEL_ENCABEZADOGRAL,
														  			   "pnlEncabezadoGeneral");
		}
		
		return this.pnlEncabezadoGeneral;
		
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo: iniciarPropPnlTotalConcepto
     * @descripcion: metodo utilizado para inicializar el componente panel 
     * 				que esta dentro del pie, como panel para la tabla Total Concepto
     * @return: JPanel componente JPanel
     * @autor: Roberth Martinez Vargas
     * ****************************************************************
     */
	public JPanel iniciarPropPnlTotalConcepto() throws Exception{
		
		if(this.pnlTotalConcepto==null){
			
			this.pnlTotalConcepto = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_CMP_TOTAL_CONCEPTO,
																				"pnlTotalConcepto",
																				null,
																				EnumEtiquetas.PNL_CMP_TOTAL_CONCEPTO,
																				null);
			
			this.pnlTotalConcepto.add(this.iniciarPropScpTblTotalConcepto());
			
		}
		return this.pnlTotalConcepto;
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo: iniciarPropPnlTotalMoneda
     * @descripcion: metodo utilizado para inicializar el componente panel 
     * 				que esta dentro del pie, como panel para la tabla Total Moneda
     * @return: JPanel componente JPanel
     * @autor: Roberth Martinez Vargas
     * ****************************************************************
     */
	public JPanel iniciarPropPnlTotalMoneda() throws Exception{
		
		if(this.pnlTotalMoneda==null){
			
			
			this.pnlTotalMoneda = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_CMP_TOTAL_MONEDA,
																			  "pnlTotalMoneda",
																			  null,
																			  EnumEtiquetas.PNL_CMP_TOTAL_MONEDA,
																			  null);
			
			this.pnlTotalMoneda.add(this.iniciarPropScpTblTotalMoneda());
			
		}
		return this.pnlTotalMoneda;
	}
	
	/**
     * ****************************************************************
     * @metodo: iniciarPropLblBusqueda
     * @descripcion: metodo utilizado para inicializar el componente EtiquetaUtil busqueda por fecha
     * @return: EtiquetaUtil componente EtiquetaUtil
     * @autor: Roberth Martinez Vargas
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblBusqueda() throws Exception{
		
		if (this.lblBusqueda == null) {
			
			this.lblBusqueda = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_CMP_BUSQUEDA, 
																		   "lblBusqueda", 
																		   EnumEtiquetas.LBL_CMP_BUSQUEDA,
																		   true,
																		   null,
																		   true);
		}

		return this.lblBusqueda;
	}
	
	/**
     * ****************************************************************
     * @metodo: iniciarPropJdcFechaBus
     * @descripcion: metodo utilizado para inicializar el componente CajaFechaUtil para 
     * 				fecha de busqueda
     * @return: CajaFechaUtil componente CajaFechaUtil
     * @autor: Roberth Martinez Vargas
     * ****************************************************************
     */	
	public CajaFechaUtil iniciarPropJdcFechaBus() throws Exception{
		
		if (this.dtcFechaBus == null) {
			
			this.dtcFechaBus = UtilComponentesGUI.getInstance().crearCalendar(EnumDimensionesComponentes.DTC_CMP_FECHA_BUS, 
																			  "dtcFechaBus", 
																			  UtilIntegracionSlimGiros.getInstance().obtenerFechaHoraActualPosSlim(), 
																			  true, 
																			  super.getEventoForma(),
																			  EnumEtiquetas.LBL_CMP_BUSQUEDA);
		}
		
		return this.dtcFechaBus;
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo: iniciarPropScpTblMovProvisiones
     * @descripcion: metodo utilizado para inicializar el componente de scrollPanel
     * 				para la grilla de movimientos provisiones
     * @autor: Roberth Martinez Vargas
     * ****************************************************************
     */
	public JScrollPane iniciarPropScpTblMovProvisiones() throws Exception{
		
		if(this.scpTblMovProvisiones==null){
			
			this.scpTblMovProvisiones = UtilComponentesGUI.getInstance().crearScroll("scpTblMovProvisiones",
													 					 		 	 EnumDimensionesComponentes.SCP_CMP_MOVIMIENTOS_PROVISIONES,
													 					 		 	 null);
			
			this.scpTblMovProvisiones.setViewportView(this.iniciarPropTblMovProvisiones());
		}
		
		return this.scpTblMovProvisiones;
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo: iniciarPropTblMovProvisiones
     * @descripcion: metodo utilizado para inicializar el componente de grillade de movimientos provisiones
     * @autor: Roberth Martinez Vargas
     * ****************************************************************
     */
	public GrillaUtil iniciarPropTblMovProvisiones() throws Exception{
		
		if(this.tblMovProvisiones==null){
			
			this.tblMovProvisiones = UtilComponentesGUI.getInstance().crearGrilla("tblMovProvisiones",
																	   		  	  new EnumEtiquetas[]{EnumEtiquetas.TTL_CMP_GRILLA_MOV_PROVISIONES_MONEDA,
																							   		  EnumEtiquetas.TTL_CMP_GRILLA_MOV_PROVISIONES_MEDIO_PAGO,
																							   		  EnumEtiquetas.TTL_CMP_GRILLA_MOV_PROVISIONES_CONCEPTO,
																							   		  EnumEtiquetas.TTL_CMP_GRILLA_MOV_PROVISIONES_FECHA,
																							   		  EnumEtiquetas.TTL_CMP_GRILLA_MOV_PROVISIONES_HORA,
																							   		  EnumEtiquetas.TTL_CMP_GRILLA_MOV_PROVISIONES_REFERENCIA,
																							   		  EnumEtiquetas.TTL_CMP_GRILLA_MOV_PROVISIONES_CAJA_DESTINO,
																							   		  EnumEtiquetas.TTL_CMP_GRILLA_MOV_PROVISIONES_ESTADO,
																							   		  EnumEtiquetas.TTL_CMP_GRILLA_MOV_PROVISIONES_OBSERVACIONES,
																							   		  EnumEtiquetas.TTL_CMP_GRILLA_MOV_PROVISIONES_VALOR},
																	   		  	  null,//invisibles
																	   		  	  null,//editable por columna
																	   		  	  new int[] {60,
																							 100,
																							 70,
																							 70,
																							 70,
																							 100,
																							 150,
																							 70,
																							 150,
																							 90},//dimensiones
																	   		      super.getEventoForma()//evento
																			  	  );
		}
		
		return this.tblMovProvisiones;
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo: iniciarPropScpTblTotalConcepto
     * @descripcion: metodo utilizado para inicializar el componente de scrollPanel
     * 				para la grilla de total concepto
     * @autor: Roberth Martinez Vargas
     * ****************************************************************
     */
	public JScrollPane iniciarPropScpTblTotalConcepto() throws Exception{
		
		if(this.scpTblTotalConcepto==null){
			
			this.scpTblTotalConcepto = UtilComponentesGUI.getInstance().crearScroll("scpTblTotalConcepto",
													 					 			EnumDimensionesComponentes.SCP_CMP_TOTAL_CONCEPTO,
													 					 			null);
			
			this.scpTblTotalConcepto.setViewportView(this.iniciarPropTblConcepto());
		}
		
		return this.scpTblTotalConcepto;
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo: iniciarPropTblConcepto
     * @descripcion: metodo utilizado para inicializar el componente de grillade de total concepto
     * @autor: Roberth Martinez Vargas
     * ****************************************************************
     */
	public GrillaUtil iniciarPropTblConcepto() throws Exception{
		
		if(this.tblConcepto==null){
			
			this.tblConcepto = UtilComponentesGUI.getInstance().crearGrilla("tblConcepto",
																	   		new EnumEtiquetas[]{EnumEtiquetas.TTL_CMP_GRILLA_TOTAL_CONCEPTO_NUMERO,
																						 		EnumEtiquetas.TTL_CMP_GRILLA_TOTAL_CONCEPTO_DESCRIPCION,
																						 		EnumEtiquetas.TTL_CMP_GRILLA_TOTAL_CONCEPTO_VALOR},
																	   		null,//invisibles
																	   		null,//editable por columna
																	   		new int[] {1,
																					   150,
																					   170},//dimensiones
																			null//evento
																			);
		}
		
		return this.tblConcepto;
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo: iniciarPropScpTblTotalMoneda
     * @descripcion: metodo utilizado para inicializar el componente de scrollPanel
     * 				para la grilla de total moneda
     * @autor: Roberth Martinez Vargas
     * ****************************************************************
     */
	public JScrollPane iniciarPropScpTblTotalMoneda() throws Exception{
		
		if(this.scpTblTotalMoneda==null){
			
			this.scpTblTotalMoneda = UtilComponentesGUI.getInstance().crearScroll("scpTblTotalMoneda",
													 					 	  	  EnumDimensionesComponentes.SCP_CMP_TOTAL_MONEDA,
													 					 	  	  null);
			
			this.scpTblTotalMoneda.setViewportView(this.iniciarPropTblMoneda());
		}
		
		return this.scpTblTotalMoneda;
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo: iniciarPropTblMoneda
     * @descripcion: metodo utilizado para inicializar el componente de grillade de total Moneda
     * @autor: Roberth Martinez Vargas
     * ****************************************************************
     */
	public GrillaUtil iniciarPropTblMoneda() throws Exception{
		
		if(this.tblMoneda==null){
			
			this.tblMoneda = UtilComponentesGUI.getInstance().crearGrilla("tblMoneda",
																	  	  new EnumEtiquetas[]{EnumEtiquetas.TTL_CMP_GRILLA_TOTAL_MONEDA_DESCRIPCION,
																					   		  EnumEtiquetas.TTL_CMP_GRILLA_TOTAL_MONEDA_MEDIO_PAGO,
																					   		  EnumEtiquetas.TTL_CMP_GRILLA_TOTAL_MONEDA_VALOR},
																	  	  null,//invisibles
																	  	  null,//editable por columna
																	  	  new int[] {30,
																					 100,
																					 170},//dimensiones
																	  	  null//evento
																		  );
		}
		
		return this.tblMoneda;
	}

	public CajaFechaUtil getDtcFechaBus() {
		return dtcFechaBus;
	}

	public void setDtcFechaBus(CajaFechaUtil dtcFechaBus) {
		this.dtcFechaBus = dtcFechaBus;
	}

	public GrillaUtil getTblMovProvisiones() {
		return tblMovProvisiones;
	}

	public void setTblMovProvisiones(GrillaUtil tblMovProvisiones) {
		this.tblMovProvisiones = tblMovProvisiones;
	}

	public GrillaUtil getTblMoneda() {
		return tblMoneda;
	}

	public void setTblMoneda(GrillaUtil tblMoneda) {
		this.tblMoneda = tblMoneda;
	}

	public GrillaUtil getTblConcepto() {
		return tblConcepto;
	}

	public void setTblConcepto(GrillaUtil tblConcepto) {
		this.tblConcepto = tblConcepto;
	}
	
	public static void main(String[] args) {
		
		JFrame jframe = null;
		
		try{
	        
			jframe = TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaConsultaDesembolsosProvisiones.class,
																			true, 
																			EnumDesplegarFormaConEventos.SI);
			new FormaConsultaDesembolsosProvisiones(jframe,true);
			
		} catch (Exception e) {
			
			UtilidadesGiros.getInstance().controlExcepcion(e, 
														   null);
		}
	}
}

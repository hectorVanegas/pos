package co.com.codesa.clienteposslimgiros.formas.autorizacion;

import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.autorizacion.EventoFormaHistorialAutorizacion;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaFechaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
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
 * ********************************************************************
 * @class  	FormaHistorialAutorizacion
 *		   	Forma por la cual el cajero puede consultar el historial de 
 *			sus autorizaciones
 * @author 	hector.cuenca
 * @date   	4/05/2017
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class FormaHistorialAutorizacion extends FormaGenerica {
	
	private static final long serialVersionUID = 1L;
	
	private FormaPanelEncabezadoGeneral pnlEncabezadoGeneralEmp;
	private JScrollPane scrAutorizaciones;
	private GrillaUtil tblAutorizaciones;
	private CajaComboUtil cmbFiltroSolicitud;
	private CajaComboUtil cmbFiltroEstado;
	private CajaFechaUtil dtcFecha;
	private CajaTextoUtil txtFiltroReferencia;
	private EtiquetaUtil lblFecha;
	private EtiquetaUtil lblFiltroSolicitud;
	private EtiquetaUtil lblFiltroEstado;
	private EtiquetaUtil lblFiltroReferencia;

	public FormaHistorialAutorizacion	(	JFrame pFrmPadre, 
									  		boolean pBooModal,
									  		String pStrReferencia
									  	) 
									  			throws Exception 
	{
		super	(	pFrmPadre, 
					pBooModal
				);
		
		super.setEventoForma(new EventoFormaHistorialAutorizacion	(	this,
																		pStrReferencia
																	)
							);

		this.inicializarForma();
	}
	
	public FormaHistorialAutorizacion	(	JFrame pFrmPadre, 
			  								boolean pBooModal
			  							) 
			  									throws Exception 
	{
		this(	pFrmPadre, 
				pBooModal,
				null
			);
	}

	@Override
	public void inicializarForma(Object... pArrObjParametrosForma) throws Exception {
		
		super.setTituloForma(EnumEtiquetas.TTL_HAU_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.FRM_HAU_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.FRM_HAU_VENTANA.getAlto());
        
		super.adicionarAcciones(EnumBotonesEncabezado.BTNCONSULTAR,
								EnumBotonesEncabezado.BTNIMPRIMIR,
								EnumBotonesEncabezado.BTN_LIMPIAR,
								EnumBotonesEncabezado.BTNSALIR
								);
		
		super.iniciar(pArrObjParametrosForma);
	}

	@Override
	public JPanel inicializarEncabezado(Object... pArrObjParametrosEncabezado) throws Exception {
		
		JPanel pnlEncabezado = null;
		
		pnlEncabezado = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_HAU_PANEL_ENCABEZADO,
																	"pnlEncabezado",
				  													null,
				  													null,
				  													null);
		pnlEncabezado.add(this.iniciarPropPnlEncabezadoGeneralEmp());
		pnlEncabezado.add(this.iniciarPropLblFecha());
		pnlEncabezado.add(this.iniciarPropDtcFecha());
		
		return pnlEncabezado;
	}

	@Override
	public JPanel inicializarCuerpo(Object... pArrObjParametrosCuerpo) throws Exception {
		
		JPanel pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_HAU_PANEL_CUERPO,
																"pnlCuerpo",
				  												null,
				  												EnumEtiquetas.LBL_HAU_FILTRO,
				  												TitledBorder.LEFT);
		pnlCuerpo.add(this.iniciarPropLblFiltroSolicitud());
		pnlCuerpo.add(this.iniciarPropCmbFiltroSolicitud());
		pnlCuerpo.add(this.iniciarPropLblFiltroEstado());
		pnlCuerpo.add(this.iniciarPropCmbFiltroEstado());
		pnlCuerpo.add(this.iniciarPropLblFiltroReferencia());
		pnlCuerpo.add(this.iniciarPropTxtFiltroReferencia());
		
		return pnlCuerpo;
	}

	@Override
	public JPanel inicializarPiePagina(Object... pArrObjParametrosPiePagina) throws Exception 
	{
		JPanel pnlPiePagina;
		
		pnlPiePagina	=	UtilComponentesGUI.getInstance().crearPanel	(	EnumDimensionesComponentes.PNL_HAU_PANEL_PIE_PAGINA,
																			"pnlPiePagina",
																			BorderFactory.createEmptyBorder(),
																			null,
																			null
																		);
		pnlPiePagina.add(this.iniciarPropScrollGrillaAutorizaciones());
		
		return pnlPiePagina;
	}
	
	/**
     * ****************************************************************
     * @metodo  iniciarPropPnlEncabezadoGeneralEmp
     * 		    metodo utilizado para inicializar el componente panel 
     * 			de Empresa
     * @return  FormaPanelEncabezadoGeneral componente FormaPanelEncabezadoGeneral
     * @throws  Exception
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */
	public FormaPanelEncabezadoGeneral iniciarPropPnlEncabezadoGeneralEmp() throws Exception{
		
		if(this.pnlEncabezadoGeneralEmp==null){
			
			this.pnlEncabezadoGeneralEmp = new FormaPanelEncabezadoGeneral(super.getObjUsuario().getEmpresa(),
																		   null,
																		   super.getObjUsuario().getCaja(),
														  			       EnumDimensionesComponentes.PNL_HAU_ENCABEZADOGRAL,
														  			       "pnlEncabezadoGeneralEmp");
		}
		
		return this.pnlEncabezadoGeneralEmp;
	}
	
	/**
     * ****************************************************************
     * @metodo  iniciarPropLblFecha
     * 			metodo utilizado para inicializar el componente EtiquetaUtil 
     * 			de Fecha
     * @return  EtiquetaUtil componente EtiquetaUtil
     * @throws  Exception
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblFecha() throws Exception{
		
		if (this.lblFecha == null) {
			this.lblFecha = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_HAU_FECHA, 
																    	"lblFecha", 
																    	EnumEtiquetas.LBL_HAU_FECHA,
																    	true,
																    	null,
																    	true);
		}
		return this.lblFecha;
	}
	
	/**
     * ****************************************************************
     * @metodo iniciarPropDtcFecha
     * 		   metodo utilizado para inicializar el componente 
     * 		   CajaFechaUtil de fecha
     * @return CajaFechaUtil componente CajaFechaUtil
     * @throws Exception
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */
	public CajaFechaUtil iniciarPropDtcFecha()throws Exception {

		if (this.dtcFecha == null) {
			
			this.dtcFecha = UtilComponentesGUI.getInstance().crearCalendar(EnumDimensionesComponentes.DTC_HAU_FECHA, 
																	   	   "dtcFecha", 
																	   	   UtilIntegracionSlimGiros.getInstance().obtenerFechaHoraActualPosSlim(), 
																	   	   true, 
																	   	   null,
																	   	   EnumEtiquetas.LBL_HAU_FECHA);
				
		}
		
		return this.dtcFecha;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblFiltroSolicitud
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblFiltroSolicitud
	 * @return	EtiquetaUtil
	 * 			etiqueta gestionada 
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	hector.cuenca
	 * @date   	5/05/2017
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblFiltroSolicitud() 
			throws Exception
	{
		if	(	this.lblFiltroSolicitud	==	null	) 
		{
			this.lblFiltroSolicitud	=	UtilComponentesGUI.getInstance().crearLabel	(	EnumDimensionesComponentes.LBL_HAU_FILTRO_SOLICITUD, 
																      	 				"lblFiltroSolicitud", 
																      	 				EnumEtiquetas.TTL_HAU_GRILLA_SOLICITUD,
																      	 				false,
																      	 				null,
																      	 				true
																      	 			);
			this.lblFiltroSolicitud.setHorizontalAlignment(SwingConstants.CENTER);
		}
		
		return this.lblFiltroSolicitud;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblFiltroEstado
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblFiltroEstado
	 * @return	EtiquetaUtil
	 * 			etiqueta gestionada 
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	hector.cuenca
	 * @date   	5/05/2017
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblFiltroEstado() 
			throws Exception
	{
		if	(	this.lblFiltroEstado	==	null	) 
		{
			this.lblFiltroEstado	=	UtilComponentesGUI.getInstance().crearLabel	(	EnumDimensionesComponentes.LBL_HAU_FILTRO_ESTADO, 
																      	 				"lblFiltroEstado", 
																      	 				EnumEtiquetas.TTL_HAU_GRILLA_ESTADO,
																      	 				false,
																      	 				null,
																      	 				true
																      	 			);
			this.lblFiltroEstado.setHorizontalAlignment(SwingConstants.CENTER);
		}
		
		return this.lblFiltroEstado;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblFiltroReferencia
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblFiltroReferencia
	 * @return	EtiquetaUtil
	 * 			etiqueta gestionada 
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	hector.cuenca
	 * @date   	5/05/2017
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblFiltroReferencia	() 
			throws Exception
	{
		if	(	this.lblFiltroReferencia	==	null	) 
		{
			this.lblFiltroReferencia	=	UtilComponentesGUI.getInstance().crearLabel	(	EnumDimensionesComponentes.LBL_HAU_FILTRO_REFERENCIA, 
																      	 					"lblFiltroReferencia", 
																      	 					EnumEtiquetas.TTL_HAU_GRILLA_REFERENCIA,
																      	 					false,
																      	 					null,
																      	 					true
																      	 				);
			this.lblFiltroReferencia.setHorizontalAlignment(SwingConstants.CENTER);
		}
		
		return this.lblFiltroReferencia;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropCmbFiltroSolicitud
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	cmbFiltroSolicitud
	 * @return	EtiquetaUtil
	 * 			Lista de valores gestionada 
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	hector.cuenca
	 * @date   	5/05/2017
	 * *********************************************************************
	 */	
	public CajaComboUtil iniciarPropCmbFiltroSolicitud() 
			throws Exception
	{
		if	(	this.cmbFiltroSolicitud	==	null	) 
		{
			this.cmbFiltroSolicitud	=	UtilComponentesGUI.getInstance().crearComboBox	(	EnumDimensionesComponentes.CMB_HAU_FILTRO_SOLICITUD, 
																							"cmbFiltroSolicitud",
																							true, 
																							true,
																							super.getEventoForma(),
																							EnumEtiquetas.TTL_HAU_GRILLA_SOLICITUD
																						);
		}
		
		return this.cmbFiltroSolicitud;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropCmbFiltroEstado
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	cmbFiltroEstado
	 * @return	EtiquetaUtil
	 * 			Lista de valores gestionada 
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	hector.cuenca
	 * @date   	5/05/2017
	 * *********************************************************************
	 */	
	public CajaComboUtil iniciarPropCmbFiltroEstado() 
			throws Exception
	{
		if	(	this.cmbFiltroEstado	==	null	) 
		{
			this.cmbFiltroEstado	=	UtilComponentesGUI.getInstance().crearComboBox	(	EnumDimensionesComponentes.CMB_HAU_FILTRO_ESTADO, 
																							"cmbFiltroEstado",
																							true, 
																							true,
																							super.getEventoForma(),
																							EnumEtiquetas.TTL_HAU_GRILLA_ESTADO
																						);
		}
		
		return this.cmbFiltroEstado;
	}
	
	/**
  	 * ****************************************************************.
  	 * @method 	iniciarPropTxtFiltroReferencia 
  	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtFiltroReferencia
  	 * @return 	CajaTextoUtil
  	 * 		   	Caja de texto gestionada
  	 * @throws 	Exception
  	 * 		   	Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
  	 * @autor  	hector.cuenca
  	 * @date   	5/05/2017
  	 * ****************************************************************
  	 */
	public CajaTextoUtil iniciarPropTxtFiltroReferencia	()
			throws Exception
	{
		if	(	this.txtFiltroReferencia	==	null	)
		{
			this.txtFiltroReferencia	=	UtilComponentesGUI.getInstance().crearTextField	(	EnumDimensionesComponentes.TXT_HAU_FILTRO_REFERENCIA, 
																								"txtFiltroReferencia", 
																								"", 
																								true, 
																								true,
																								true, 
																								super.getEventoForma(),
																								EnumEtiquetas.TTL_HAU_GRILLA_REFERENCIA
																							);
		}
		
		return txtFiltroReferencia;
	}
	
	/**
     * ****************************************************************
     * @metodo iniciarPropScrollGrillaAutorizaciones
     * 		   metodo utilizado para inicializar el componente de 
     * 		   scrollPanel para la grilla de autorizacione
     * @return JScrollPane, componente scroll
     * @throws Exception
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */
	public JScrollPane iniciarPropScrollGrillaAutorizaciones() throws Exception{
		
		if(this.scrAutorizaciones==null){
			
			/*this.scrAutorizaciones = UtilComponentesGUI.getInstance().crearScroll("scrAutorizaciones",
													 					 	  	  EnumDimensionesComponentes.GRI_HAU_AUTORIZACIONES,
													 					 	  	  null);*/
			
			this.scrAutorizaciones	=	this.iniciarPropGrillaAutorizaciones().getScpContenedorRound(EnumDimensionesComponentes.GRI_HAU_AUTORIZACIONES);
			
			this.scrAutorizaciones.setBorder	(	BorderFactory.createTitledBorder(	null,
																						EnumEtiquetas.TTL_HAU_PANEL_CUERPO.toString(),
																						TitledBorder.CENTER,
																						TitledBorder.TOP
																					)
												);
			
			//this.scrAutorizaciones.setViewportView(this.iniciarPropGrillaAutorizaciones());
		}
		
		return this.scrAutorizaciones;
	}
	
	/**
     * ****************************************************************
     * @metodo iniciarPropGrillaAutorizaciones
     * 		   metodo utilizado para inicializar el componente de 
     * 		   grilla de autorizaciones
     * @return 
     * @throws Exception
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */
	public GrillaUtil iniciarPropGrillaAutorizaciones() throws Exception{

		if(this.tblAutorizaciones==null){
			
			this.tblAutorizaciones = UtilComponentesGUI.getInstance().crearGrilla("tblAutorizaciones", 
																			      new EnumEtiquetas[]{EnumEtiquetas.TTL_HAU_GRILLA_FILA,
																									  EnumEtiquetas.TTL_HAU_GRILLA_HORA,
																							   		  EnumEtiquetas.TTL_HAU_GRILLA_REFERENCIA,
																							   		  EnumEtiquetas.TTL_HAU_GRILLA_SOLICITUD,
																							   		  EnumEtiquetas.TTL_HAU_GRILLA_ORIGEN,
																							   		  EnumEtiquetas.TTL_HAU_GRILLA_DESTINO,
																							   		  EnumEtiquetas.TTL_HAU_GRILLA_TERCERO_INICIAL,
																							   		  EnumEtiquetas.TTL_HAU_GRILLA_TERCERO_CAMBIO,
																							   		  EnumEtiquetas.TTL_HAU_GRILLA_ESTADO,
																							   		  EnumEtiquetas.TTL_HAU_GRILLA_NOTAS},
																				  new EnumEtiquetas[]{EnumEtiquetas.TTL_HAU_GRILLA_FILA},//invisibles
																				  null, //editable por columna
																				  new int[] {80, 
																						     150, 
																						     200, 
																						     80, 
																						     80, 
																						     200, 
																						     200, 
																						     80, 
																						     80, 
																						     200}, //dimensiones
																				  super.getEventoForma());
			this.tblAutorizaciones.activarOrdenamiento(true);
		}
		
		return this.tblAutorizaciones;
	}

	public CajaFechaUtil getDtcFecha() {
		return dtcFecha;
	}
	public void setDtcFecha(CajaFechaUtil dtcFecha) {
		this.dtcFecha = dtcFecha;
	}
	
	
	public GrillaUtil getTblAutorizaciones() {
		return tblAutorizaciones;
	}

	public void setTblAutorizaciones(GrillaUtil tblAutorizaciones) {
		this.tblAutorizaciones = tblAutorizaciones;
	}

	public CajaComboUtil getCmbFiltroSolicitud() {
		return cmbFiltroSolicitud;
	}

	public void setCmbFiltroSolicitud(CajaComboUtil cmbFiltroSolicitud) {
		this.cmbFiltroSolicitud = cmbFiltroSolicitud;
	}

	public EtiquetaUtil getLblFecha() {
		return lblFecha;
	}

	public void setLblFecha(EtiquetaUtil lblFecha) {
		this.lblFecha = lblFecha;
	}
	
	/**
	 * @method getTxtFiltroReferencia
	 * 		   Metodo get del atributo txtFiltroReferencia
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtFiltroReferencia devuelto
	 * @author hector.cuenca
	 * @date   5/05/2017
	 */
	public CajaTextoUtil getTxtFiltroReferencia() {
		return txtFiltroReferencia;
	}

	/**
	 * @method setTxtFiltroReferencia
	 * 		   Metodo set del atributo txtFiltroReferencia
	 * @param  pTxtFiltroReferencia
	 *		   Valor que tomara el atributo txtFiltroReferencia
	 * @author hector.cuenca
	 * @date   5/05/2017
	 */
	public void setTxtFiltroReferencia(CajaTextoUtil pTxtFiltroReferencia) {
		this.txtFiltroReferencia = pTxtFiltroReferencia;
	}

	/**
	 * @method getLblFiltroReferencia
	 * 		   Metodo get del atributo lblFiltroReferencia
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblFiltroReferencia devuelto
	 * @author hector.cuenca
	 * @date   5/05/2017
	 */
	public EtiquetaUtil getLblFiltroReferencia() {
		return lblFiltroReferencia;
	}

	/**
	 * @method setLblFiltroReferencia
	 * 		   Metodo set del atributo lblFiltroReferencia
	 * @param  pLblFiltroReferencia
	 *		   Valor que tomara el atributo lblFiltroReferencia
	 * @author hector.cuenca
	 * @date   5/05/2017
	 */
	public void setLblFiltroReferencia(EtiquetaUtil pLblFiltroReferencia) {
		this.lblFiltroReferencia = pLblFiltroReferencia;
	}

	/**
	 * @method getCmbFiltroEstado
	 * 		   Metodo get del atributo cmbFiltroEstado
	 * @return CajaComboUtil
	 *		   Valor del atributo cmbFiltroEstado devuelto
	 * @author hector.cuenca
	 * @date   5/05/2017
	 */
	public CajaComboUtil getCmbFiltroEstado() {
		return this.cmbFiltroEstado;
	}

	/**
	 * @method setCmbFiltroEstado
	 * 		   Metodo set del atributo cmbFiltroEstado
	 * @param  pCmbFiltroEstado
	 *		   Valor que tomara el atributo cmbFiltroEstado
	 * @author hector.cuenca
	 * @date   5/05/2017
	 */
	public void setCmbFiltroEstado(CajaComboUtil pCmbFiltroEstado) {
		this.cmbFiltroEstado = pCmbFiltroEstado;
	}

	public static void main(String[] args) {
		
		JFrame jframe = null;
		
		try{
	        
			jframe = TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaHistorialAutorizacion.class,
																			true, 
																			EnumDesplegarFormaConEventos.SI);
			new FormaHistorialAutorizacion(jframe, true,"18703861140105287939");
			
		} catch (Exception e) {
			
			UtilidadesGiros.getInstance().controlExcepcion(e, 
														   null);
		}
	}
}

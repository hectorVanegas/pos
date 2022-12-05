package co.com.codesa.clienteposslimgiros.formas.documentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.documentacion.EventoFormaConsultaDocumentosPendientes;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.GrillaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelEncabezadoGeneral;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

public class FormaConsultaDocumentosPendientes extends FormaGenerica {

	private static final long serialVersionUID = 1L;
	
	/**
	 * @variable pnlEncabezadoGeneral
	 * 			 seccion que aloja el encabezado general para las formas, que contiene 
	 * 			 los valores de agencia, empresa y caja, normalmente recuperados del 
	 * 			 usuario autenticado
	 **/
	private JPanel pnlEncabezadoGeneral;
	
	private JScrollPane scpGrillaConsulta;
	private GrillaUtil tblConsulta;
	private CajaComboUtil cmbTipoOperacion;
	private EtiquetaUtil lblTipoOperacion;

	public FormaConsultaDocumentosPendientes(JFrame pFrmPadre, 
									 boolean pBooModal)throws Exception {
		
		super(pFrmPadre, 
			  pBooModal);
		
		super.setEventoForma(new EventoFormaConsultaDocumentosPendientes(this));
		this.inicializarForma();
	}

	@Override
	public void inicializarForma(Object... pArrObjParametrosForma)throws Exception {
		
		super.setTituloForma(EnumEtiquetas.TTL_CDP_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.GUI_CDP_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.GUI_CDP_VENTANA.getAlto());
		
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
								EnumBotonesEncabezado.BTNCONSULTAR,
								EnumBotonesEncabezado.BTNSALIR);
		
		super.iniciar(pArrObjParametrosForma);
	}

	@Override
	public JPanel inicializarEncabezado(Object... pArrObjParametrosEncabezado)throws Exception {

		JPanel pnlEncabezado;
		
		pnlEncabezado = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_CDP_PANEL_ENCABEZADO,
																	"pnlEncabezado",
																	null,
																	null,
																	null);
		pnlEncabezado.add(this.iniciarPropPnlEncabezadoGeneral());
		pnlEncabezado.add(this.iniciarPropLblTipoOperacion());
		pnlEncabezado.add(this.iniciarPropCmbTipoOperacion());
		
		return pnlEncabezado;
	}

	@Override
	public JPanel inicializarCuerpo(Object... pArrObjParametrosCuerpo)throws Exception {

		JPanel pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_CDP_PANEL_CUERPO, 
																"pnlCuerpo",
																null,
																null,
																null);
		pnlCuerpo.add(this.iniciarPropScpGrillaConsulta());
		
		return pnlCuerpo;
	}

	@Override
	public JPanel inicializarPiePagina(Object... pArrObjParametrosPiePagina)throws Exception {
		return null;
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
																	    EnumDimensionesComponentes.PNL_CDP_ENCABEZADO_GENERAL,
																	    "pnlEncabezadoGeneral");
		}
		
		return this.pnlEncabezadoGeneral;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropScpGrillaConsulta
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   scpGrillaConsulta
  	 * @return JScrollPane
  	 * 		   contenedor para el despliegue de grilla gestionado
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public JScrollPane iniciarPropScpGrillaConsulta() throws Exception{
		
		if(this.scpGrillaConsulta==null){
			
			this.scpGrillaConsulta = UtilComponentesGUI.getInstance().crearScroll("scpGrillaConsulta",
													 					   		  EnumDimensionesComponentes.SCP_CDP_GRILLA_CONSULTA,
													 					   		  null);
			
			this.scpGrillaConsulta.setViewportView(this.iniciarPropTblConsulta());
		}
		
		return this.scpGrillaConsulta;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropTblConsulta
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   tblConsulta
  	 * @return GrillaUtil
  	 * 		   grilla gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public GrillaUtil iniciarPropTblConsulta() throws Exception{
		
		if(this.tblConsulta==null){
			
			this.tblConsulta = UtilComponentesGUI.getInstance().crearGrilla("tblConsulta", 
																		    new EnumEtiquetas[]{EnumEtiquetas.TTL_CDP_GRILLA_REFERENCIA,
																					 	 		EnumEtiquetas.TTL_CDP_GRILLA_AGENCIA_ORIGEN,
																					 	 		EnumEtiquetas.TTL_CDP_GRILLA_VALOR,
																					 	 		EnumEtiquetas.TTL_CDP_GRILLA_CONCEPTO},
																		    null, 
																		    null,
																		    new int[] { 80, 
																					    80, 
																					    80, 
																					    80, 
																					    80, 
																					    80, 
																					    200, 
																					    80, 
																					    200, 
																					    80 },
																		    super.getEventoForma());
		}
		
		return this.tblConsulta;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropCmbTipoOperacion
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   cmbTipoOperacion
  	 * @return CajaComboUtil 
  	 * 		   lista de valores gestionada 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaComboUtil iniciarPropCmbTipoOperacion()throws Exception{

		if(this.cmbTipoOperacion==null){

			this.cmbTipoOperacion = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_DCP_TIPO_OPERACION,
																		  	   	   "cmbTipoOperacion",
																		  	   	   true, 
																		  	   	   true, 
																		  	   	   super.getEventoForma(),
																		  	   	   EnumEtiquetas.LBL_CDP_TIPO_OPERACION);
		}
		
		return this.cmbTipoOperacion;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblTipoOperacion
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblTipoOperacion
  	 * @return EtiquetaUtil
  	 * 		   etiqueta gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblTipoOperacion() throws Exception{
		
		if (this.lblTipoOperacion == null) {
			
			this.lblTipoOperacion = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_DCP_TIPO_OPERACION, 
																		 		"lblTipoOperacion",
																		 		EnumEtiquetas.LBL_CDP_TIPO_OPERACION,
																		 		true,
																		 		null,
																		 		true);
		}
		
		return this.lblTipoOperacion;
	}
	
	public GrillaUtil getTblConsulta() {
		return tblConsulta;
	}

	public void setTblConsulta(GrillaUtil tbDocumentos) {
		this.tblConsulta = tbDocumentos;
	}

	public CajaComboUtil getCmbTipoOperacion() {
		return cmbTipoOperacion;
	}

	public void setCmbTipoOperacion(CajaComboUtil comboTipoOperacion) {
		this.cmbTipoOperacion = comboTipoOperacion;
	}

	public JPanel getPnlEncabezadoGeneral() {
		return pnlEncabezadoGeneral;
	}

	public void setPnlEncabezadoGeneral(JPanel pnlEncabezadoGeneral) {
		this.pnlEncabezadoGeneral = pnlEncabezadoGeneral;
	}

	public JScrollPane getScpGrillaConsulta() {
		return scpGrillaConsulta;
	}

	public void setScpGrillaConsulta(JScrollPane scpGrillaConsulta) {
		this.scpGrillaConsulta = scpGrillaConsulta;
	}

	public EtiquetaUtil getLblTipoOperacion() {
		return lblTipoOperacion;
	}

	public void setLblTipoOperacion(EtiquetaUtil lblTipoOperacion) {
		this.lblTipoOperacion = lblTipoOperacion;
	}

	public static void main(String[] args) {
		
		JFrame jframe = null;
		
		try{
	        
			jframe = TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaConsultaDocumentosPendientes.class,
																			true, 
																			EnumDesplegarFormaConEventos.SI);
			new FormaConsultaDocumentosPendientes(jframe, 
												  true);
			
		} catch (Exception e) {
			
			UtilidadesGiros.getInstance().controlExcepcion(e, 
														   null);
		}
	}
}

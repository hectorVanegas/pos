package co.com.codesa.clienteposslimgiros.formas.reimpresion;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import co.com.codesa.clienteposslim.logger.Logger;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumReimpresiones;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.reimpresion.EventoFormaReimpresion;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.GrillaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelDatosAdicionales;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelEncabezadoGeneral;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 04-mar-2015
 * @clase FormaReimpresion
 * 		  Forma para ejecutar las reimpresiones del sistema
 * @copyright: Copyright  1998-2012 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class FormaReimpresion extends FormaGenerica{
	
	/**
	 * @variable 	serialVersionUID
	 * 			 	Variable serialVersionUID
	 */
	private static final long serialVersionUID = -6008766807282397749L;

	/**
	 * @variable pnlEncabezadoGeneral
	 * 			 seccion que aloja el encabezado general para las formas, que contiene 
	 * 			 los valores de agencia, empresa y caja, normalmente recuperados del 
	 * 			 usuario autenticado
	 **/
	private FormaPanelEncabezadoGeneral pnlEncabezadoGeneral;
	
	/**
	 * @variable pnlDatosAdicionales
	 * 			 Seccion a contener los componentes graficos requeridos para diligeniciar
	 * 			 los posibles parametros asociados a la reimpresion
	 */
	private FormaPanelDatosAdicionales pnlDatosAdicionales;
	
	/**
	 * @variable pnlSeccionResultado
	 * 			 Seccion a contener los componentes graficos para notificar las variables
	 * 			 mas relevantes relacionadas en el comprobante. Ejemplo: fecha transaccion,
	 * 			 nombre de los terceros, valor de transaccion, entre otros
	 */
	//private JPanel pnlSeccionResultado;
	
	/**
	 * @variable scpGrillaResultado
	 * 			 componente de scroll que contiene la grilla de resultados de la 
	 * 			 operacion de reimpresion ejecutada
	 **/
	private JScrollPane scpGrillaResultado;
	
	/**
	 * @variable tblResultado
	 * 			 grilla que contiene los resultados de la operacion de reimpresion
	 * 			 ejecutada
	 **/
	private GrillaUtil tblResultado;
	
	/**
	 * @variable cmbTipoReimpresion 
	 * 			 Lista de valores a contener los diferentes tipos de reimpresiones 
	 * 			 definidas para el sistema
	 **/
	private CajaComboUtil cmbTipoReimpresion;
	
	/**
	 * @variable cmbListaReimpresiones 
	 * 			 lista de valores a contener las diferentes reimprsiones que se pueden
	 * 			 ejecutar
	 **/
	private CajaComboUtil cmbListaReimpresiones;
	
	/**
	 * @variable lblTipoReimpresion
	 * 			 Etiqueta que identifica el componnete grafico que contiene el tipo
	 * 			 de reimpresion
	 **/
	private EtiquetaUtil lblTipoReimpresion;
	
	/**
	 * @variable lblListaReimpresiones
	 * 			 etiqueta que identifica el componnete grafico que contiene el listado
	 * 			 de reimpresiones
	 **/
	private EtiquetaUtil lblListaReimpresiones;
	
	/**
  	 * ****************************************************************.
  	 * @metodo FormaReimpresion
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
	public FormaReimpresion(JFrame pFrmPadre,
							boolean pBooModal) throws Exception {
		
		super(pFrmPadre,
			  pBooModal);
		
		super.setEventoForma(new EventoFormaReimpresion(this,
														null));
		this.inicializarForma();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo FormaReimpresion
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de la forma
  	 * @param pFrmPadre
  	 * 		  ventana de la cual extiende esta forma
  	 * @param pBooModal 
  	 * 		  bandera que permite efectuar la forma de manera modal sobre 
  	 * 		  la ventana de la cual extiende
  	 * @param pEnmReimpresionXDefecto
  	 * 		  Constante de enumeracion que representa una reimpresion.
  	 * 		  con el fin de cargar una reimpresion de manera inicial
  	 * 		  sobre la forma
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaReimpresion(JFrame pFrmPadre,
							boolean pBooModal,
							EnumReimpresiones pEnmReimpresionXDefecto) throws Exception {

		super(pFrmPadre,
			  pBooModal);

		super.setEventoForma(new EventoFormaReimpresion(this,
														pEnmReimpresionXDefecto));
		this.inicializarForma();
	}

	@Override
	public void inicializarForma(Object ...pArrObjParametrosForma) throws Exception{
		
		super.setTituloForma(EnumEtiquetas.TTL_RMP_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.GUI_RMP_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.GUI_RMP_VENTANA.getAlto());
        
		super.adicionarAcciones(EnumBotonesEncabezado.BTNIMPRIMIR,
						  		EnumBotonesEncabezado.BTNSALIR);
		
		super.iniciar(pArrObjParametrosForma);
	}

	@Override
	public JPanel inicializarEncabezado(Object ...pArrObjParametrosForma) throws Exception{
		
		JPanel pnlEncabezado;
		
		pnlEncabezado = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_RMP_ENCABEZADO,
																	"pnlEncabezado",
		  														 	BorderFactory.createEtchedBorder(),
		  														 	null,
		  														 	null);
		pnlEncabezado.add(this.iniciarPropPnlEncabezadoGeneral());
		
		return pnlEncabezado;
	}

	@Override
	public JPanel inicializarCuerpo(Object ...pArrObjParametrosCuerpo) throws Exception{
		
		JPanel pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_RMP_CUERPO,
																"pnlCuerpo",
	  													 		BorderFactory.createEtchedBorder(),
	  													 		null,
	  													 		null);
		pnlCuerpo.add(this.iniciarPropLblTipoReimpresion());
		pnlCuerpo.add(this.iniciarPropCmbTipoReimpresion());
		pnlCuerpo.add(this.iniciarPropLblListaReimpresiones());
		pnlCuerpo.add(this.iniciarPropCmbListaReimpresiones());
		pnlCuerpo.add(this.iniciarPropPnlDatosAdicionales());
		pnlCuerpo.add(this.iniciarPropScrollGrillaResultado());
		
		return pnlCuerpo;
	}

	@Override
	public JPanel inicializarPiePagina(Object ...pArrObjParametrosPiePagina) throws Exception{
		
		/*JPanel pnlPiePagina = null;
		
		pnlPiePagina = UtilComponentesGUI.getInstance().crearPanelSinTitulo(pnlPiePagina, 
					 													EnumDimensionesComponentes.PNL_RMP_PIE_PAGINA.getRectangulo(),
					 													BorderFactory.createEtchedBorder());
		pnlPiePagina.add(this.iniciarPropPnlSeccionResultado());
		
		return pnlPiePagina;*/
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
	public FormaPanelEncabezadoGeneral iniciarPropPnlEncabezadoGeneral() throws Exception{
		
		if(this.pnlEncabezadoGeneral==null){
			
			this.pnlEncabezadoGeneral = new FormaPanelEncabezadoGeneral(super.getObjUsuario().getEmpresa(),
														  			   null,
														  			   super.getObjUsuario().getCaja(),
														  			   EnumDimensionesComponentes.PNL_RMP_ENCABEZADO_GENERAL,
														  			   "pnlEncabezadoGeneral");
		}
		
		return this.pnlEncabezadoGeneral;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropPnlDatosAdicionales
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pnlDatosAdicionales
  	 * @return FormaPanelDatosAdicionales 
  	 * 		   seccion datos adicionales gestionada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaPanelDatosAdicionales iniciarPropPnlDatosAdicionales() throws Exception{
		
		if(this.pnlDatosAdicionales == null){
			
			this.pnlDatosAdicionales = new FormaPanelDatosAdicionales(this, 
																	  EnumDimensionesComponentes.PNL_RMP_PARAMETROS, 
																	  null,
																	  "pnlDatosAdicionales",
																	  EnumEtiquetas.TTL_RMP_PARAMETROS);
		}
		
		return this.pnlDatosAdicionales;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropPnlSeccionResultado
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pnlSeccionResultado
  	 * @return JPanel 
  	 * 		   seccion de cuerpo gestionada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	/*public JPanel iniciarPropPnlSeccionResultado() throws Exception{
		
		if(this.pnlSeccionResultado == null){
			
			this.pnlSeccionResultado = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_RMP_RESULTADO,
																				   "pnlSeccionResultado",
																	  		  	   null,
																	  		  	   EnumEtiquetas.TTL_RMP_PNL_RESULTADO,
																	  		  	   null);
			this.pnlSeccionResultado.add(this.iniciarPropScrollGrillaResultado());
		}
		
		return this.pnlSeccionResultado;
	}*/
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropScrollGrillaResultado
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   scpGrillaResultado
  	 * @return JScrollPane
  	 * 		   contenedor para el despliegue de grilla gestionado
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public JScrollPane iniciarPropScrollGrillaResultado() throws Exception{
		
		if(this.scpGrillaResultado == null){
			
			/*this.scpGrillaResultado = UtilComponentesGUI.getInstance().crearScroll("scpGrillaResultado",
													 					 		   EnumDimensionesComponentes.SCP_RMP_GRILLA_RESULTADO,
													 					 		   null);*/
			
			this.scpGrillaResultado	=	this.iniciarPropGrillaResultado().getScpContenedorRound(EnumDimensionesComponentes.SCP_RMP_GRILLA_RESULTADO);
			
			this.scpGrillaResultado.setBorder	(	BorderFactory.createTitledBorder(	null,
																						EnumEtiquetas.TTL_RMP_PNL_RESULTADO.toString(),
																						TitledBorder.CENTER,
																						TitledBorder.TOP
																					)
												);
			
			//this.scpGrillaResultado.setViewportView(this.iniciarPropGrillaResultado());			
		}
		
		return this.scpGrillaResultado;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropGrillaResultado
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   tblResultado
  	 * @return GrillaUtil 
  	 * 		   grilla gestionada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public GrillaUtil iniciarPropGrillaResultado() throws Exception{
		
		if(this.tblResultado == null){
			
			this.tblResultado = UtilComponentesGUI.getInstance().crearGrilla("tblResultado",
														  				 	 new EnumEtiquetas[]{EnumEtiquetas.TTL_RMP_GRILLA_RESULTADO_DATO,
																	   				  	  		 EnumEtiquetas.TTL_RMP_GRILLA_RESULTADO_VALOR},
																	   	     null,//invisibles
																	   	     new boolean[] {false, 
																		 					false},//editable por columna
																		 	 new int[] {20,
																	 			    	50},//dimensiones
																	 	     super.getEventoForma());
			
			this.tblResultado.getObjRender().setIntJustificacionAlfanumerico(SwingConstants.LEFT);
			this.tblResultado.getObjRender().setIntJustificacionNumerico(SwingConstants.LEFT);
		}
		
		return this.tblResultado;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropCmbTipoReimpresion
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   cmbTipoReimpresion
  	 * @return CajaComboUtil 
  	 * 		   lista de valores gestionada 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaComboUtil iniciarPropCmbTipoReimpresion()throws Exception{

		if(this.cmbTipoReimpresion == null){

			this.cmbTipoReimpresion = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_RMP_TIPO_REIMPRESION,
																	  	   	 	 	 "cmbTipoReimpresion",
																	  	   	 	 	 true, 
																	  	   	 	 	 true, 
																	  	   	 	 	 super.getEventoForma(),
																	  	   	 	 	 EnumEtiquetas.LBL_RMP_TIPO_REIMPRESION);
		}
		
		return this.cmbTipoReimpresion;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropCmbListaReimpresiones
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   cmbListaReimpresiones
  	 * @return CajaComboUtil 
  	 * 		   lista de valores gestionada 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaComboUtil iniciarPropCmbListaReimpresiones()throws Exception{

		if(this.cmbListaReimpresiones == null){

			this.cmbListaReimpresiones = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_RMP_LISTA_REIMPRESIONES,
																		  	   	 		"cmbListaReimpresiones",
																		  	   	 		true, 
																		  	   	 		true, 
																		  	   	 		super.getEventoForma(),
																		  	   	 		EnumEtiquetas.LBL_RMP_LISTA_REIMPRESIONES);
		}
		
		return this.cmbListaReimpresiones;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblListaReimpresiones
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblListaReimpresiones
  	 * @return EtiquetaUtil
  	 * 		   etiqueta gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblListaReimpresiones() throws Exception{
		
		if (this.lblListaReimpresiones == null) {
			
			this.lblListaReimpresiones = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_RMP_LISTA_REIMPRESIONES, 
																		 		 	 "lblListaReimpresiones",
																		 		 	 EnumEtiquetas.LBL_RMP_LISTA_REIMPRESIONES,
																		 		 	 true,
																		 		 	 null,
																		 		 	 true);
		}
		
		return this.lblListaReimpresiones;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblTipoReimpresion
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblTipoReimpresion
  	 * @return EtiquetaUtil
  	 * 		   etiqueta gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblTipoReimpresion() throws Exception{
		
		if (this.lblTipoReimpresion == null) {
			
			this.lblTipoReimpresion = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_RMP_TIPO_REIMPRESION, 
																			  	  "lblTipoReimpresion",
																			  	  EnumEtiquetas.LBL_RMP_TIPO_REIMPRESION,
																			  	  true,
																			  	  null,
																			  	  true);
		}
		
		return this.lblTipoReimpresion;
	}

	/**
	 * @method getPnlEncabezadoGeneral
	 * 		   Metodo get del atributo pnlEncabezadoGeneral
	 * @return FormaPanelEncabezadoGeneral
	 *		   Valor del atributo pnlEncabezadoGeneral devuelto
	 * @author hector.cuenca
	 * @date   3/12/2016
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
	 * @date   3/12/2016
	 */
	public void setPnlEncabezadoGeneral(
			FormaPanelEncabezadoGeneral pPnlEncabezadoGeneral) {
		this.pnlEncabezadoGeneral = pPnlEncabezadoGeneral;
	}

	/**
	 * @method getPnlDatosAdicionales
	 * 		   Metodo get del atributo pnlDatosAdicionales
	 * @return FormaPanelDatosAdicionales
	 *		   Valor del atributo pnlDatosAdicionales devuelto
	 * @author hector.cuenca
	 * @date   3/12/2016
	 */
	public FormaPanelDatosAdicionales getPnlDatosAdicionales() {
		return this.pnlDatosAdicionales;
	}

	/**
	 * @method setPnlDatosAdicionales
	 * 		   Metodo set del atributo pnlDatosAdicionales
	 * @param  pPnlDatosAdicionales
	 *		   Valor que tomara el atributo pnlDatosAdicionales
	 * @author hector.cuenca
	 * @date   3/12/2016
	 */
	public void setPnlDatosAdicionales(
			FormaPanelDatosAdicionales pPnlDatosAdicionales) {
		this.pnlDatosAdicionales = pPnlDatosAdicionales;
	}

	/**
	 * @method getPnlSeccionResultado
	 * 		   Metodo get del atributo pnlSeccionResultado
	 * @return JPanel
	 *		   Valor del atributo pnlSeccionResultado devuelto
	 * @author hector.cuenca
	 * @date   3/12/2016
	 */
	/*public JPanel getPnlSeccionResultado() {
		return this.pnlSeccionResultado;
	}*/

	/**
	 * @method setPnlSeccionResultado
	 * 		   Metodo set del atributo pnlSeccionResultado
	 * @param  pPnlSeccionResultado
	 *		   Valor que tomara el atributo pnlSeccionResultado
	 * @author hector.cuenca
	 * @date   3/12/2016
	 */
	/*public void setPnlSeccionResultado(JPanel pPnlSeccionResultado) {
		this.pnlSeccionResultado = pPnlSeccionResultado;
	}*/

	/**
	 * @method getScpGrillaResultado
	 * 		   Metodo get del atributo scpGrillaResultado
	 * @return JScrollPane
	 *		   Valor del atributo scpGrillaResultado devuelto
	 * @author hector.cuenca
	 * @date   3/12/2016
	 */
	public JScrollPane getScpGrillaResultado() {
		return this.scpGrillaResultado;
	}

	/**
	 * @method setScpGrillaResultado
	 * 		   Metodo set del atributo scpGrillaResultado
	 * @param  pScpGrillaResultado
	 *		   Valor que tomara el atributo scpGrillaResultado
	 * @author hector.cuenca
	 * @date   3/12/2016
	 */
	public void setScpGrillaResultado(JScrollPane pScpGrillaResultado) {
		this.scpGrillaResultado = pScpGrillaResultado;
	}

	/**
	 * @method getTblResultado
	 * 		   Metodo get del atributo tblResultado
	 * @return GrillaUtil
	 *		   Valor del atributo tblResultado devuelto
	 * @author hector.cuenca
	 * @date   3/12/2016
	 */
	public GrillaUtil getTblResultado() {
		return this.tblResultado;
	}

	/**
	 * @method setTblResultado
	 * 		   Metodo set del atributo tblResultado
	 * @param  pTblResultado
	 *		   Valor que tomara el atributo tblResultado
	 * @author hector.cuenca
	 * @date   3/12/2016
	 */
	public void setTblResultado(GrillaUtil pTblResultado) {
		this.tblResultado = pTblResultado;
	}

	/**
	 * @method getCmbTipoReimpresion
	 * 		   Metodo get del atributo cmbTipoReimpresion
	 * @return CajaComboUtil
	 *		   Valor del atributo cmbTipoReimpresion devuelto
	 * @author hector.cuenca
	 * @date   3/12/2016
	 */
	public CajaComboUtil getCmbTipoReimpresion() {
		return this.cmbTipoReimpresion;
	}

	/**
	 * @method setCmbTipoReimpresion
	 * 		   Metodo set del atributo cmbTipoReimpresion
	 * @param  pCmbTipoReimpresion
	 *		   Valor que tomara el atributo cmbTipoReimpresion
	 * @author hector.cuenca
	 * @date   3/12/2016
	 */
	public void setCmbTipoReimpresion(CajaComboUtil pCmbTipoReimpresion) {
		this.cmbTipoReimpresion = pCmbTipoReimpresion;
	}

	/**
	 * @method getCmbListaReimpresiones
	 * 		   Metodo get del atributo cmbListaReimpresiones
	 * @return CajaComboUtil
	 *		   Valor del atributo cmbListaReimpresiones devuelto
	 * @author hector.cuenca
	 * @date   3/12/2016
	 */
	public CajaComboUtil getCmbListaReimpresiones() {
		return this.cmbListaReimpresiones;
	}

	/**
	 * @method setCmbListaReimpresiones
	 * 		   Metodo set del atributo cmbListaReimpresiones
	 * @param  pCmbListaReimpresiones
	 *		   Valor que tomara el atributo cmbListaReimpresiones
	 * @author hector.cuenca
	 * @date   3/12/2016
	 */
	public void setCmbListaReimpresiones(CajaComboUtil pCmbListaReimpresiones) {
		this.cmbListaReimpresiones = pCmbListaReimpresiones;
	}

	/**
	 * @method getLblTipoReimpresion
	 * 		   Metodo get del atributo lblTipoReimpresion
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblTipoReimpresion devuelto
	 * @author hector.cuenca
	 * @date   3/12/2016
	 */
	public EtiquetaUtil getLblTipoReimpresion() {
		return this.lblTipoReimpresion;
	}

	/**
	 * @method setLblTipoReimpresion
	 * 		   Metodo set del atributo lblTipoReimpresion
	 * @param  pLblTipoReimpresion
	 *		   Valor que tomara el atributo lblTipoReimpresion
	 * @author hector.cuenca
	 * @date   3/12/2016
	 */
	public void setLblTipoReimpresion(EtiquetaUtil pLblTipoReimpresion) {
		this.lblTipoReimpresion = pLblTipoReimpresion;
	}

	/**
	 * @method getLblListaReimpresiones
	 * 		   Metodo get del atributo lblListaReimpresiones
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblListaReimpresiones devuelto
	 * @author hector.cuenca
	 * @date   3/12/2016
	 */
	public EtiquetaUtil getLblListaReimpresiones() {
		return this.lblListaReimpresiones;
	}

	/**
	 * @method setLblListaReimpresiones
	 * 		   Metodo set del atributo lblListaReimpresiones
	 * @param  pLblListaReimpresiones
	 *		   Valor que tomara el atributo lblListaReimpresiones
	 * @author hector.cuenca
	 * @date   3/12/2016
	 */
	public void setLblListaReimpresiones(EtiquetaUtil pLblListaReimpresiones) {
		this.lblListaReimpresiones = pLblListaReimpresiones;
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
	        
			jframe = TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaReimpresion.class,
																			true, 
																			EnumDesplegarFormaConEventos.SI);
			new FormaReimpresion(jframe,
								 true
								 //,EnumReimpresiones.REIMPRIMIR_ULTIMO_PAGO_GIRO
								 );
			
		} catch (Exception e) {
			
			e.printStackTrace();
			Logger.getInstance().error(e.getMessage());
			
		}
	}
	
}

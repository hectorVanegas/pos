package co.com.codesa.clienteposslimgiros.formas.pago;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import co.com.codesa.clienteposslim.logger.Logger;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.pago.EventoFormaConsultaGiro;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.GrillaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelBusqueda;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelEncabezadoGeneral;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

/**
 * ****************************************************************.
 * @autor Roberth Martinez Vargas
 * @fecha 04-mar-2015
 * @clase FormaConsultaGiro
 * 		  Clase para consultar giros nacionales internos o externos, 
 * 		  por pin o documento de identidad
 * @copyright: Copyright  1998-2012 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class FormaConsultaGiro extends FormaGenerica{
	
	/**
	 * @variable serialVersionUID
	 * 			 variable
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @variable pnlBusquedaGiros
	 * 			 seccion dinamica que agrupa los componentes graficos requeridos 
	 * 			 para realizar una busqueda de giros por documento de tercero o 
	 * 			 pin 
	 **/
	private FormaPanelBusqueda pnlBusquedaGiros;
	
	/**
	 * @variable pnlEncabezadoGeneral
	 * 			 seccion que aloja el encabezado general para las formas, que 
	 * 			 contiene los valores de agencia, empresa y caja, normalmente 
	 * 			 recuperados del usuario autenticado
	 **/
	private FormaPanelEncabezadoGeneral pnlEncabezadoGeneral;
	
	/**
	 * @variable scpGrillaGiros
	 * 			 componente grafico que permite incluir barras de desplazamiento 
	 * 			 para facilitar el despliegue de la grilla
	 **/
	private JScrollPane scpGrillaGiros;
	
	/**
	 * @variable tblGiros
	 * 			 grilla donde se relaciona la informacion asociada a los giros 
	 * 			 que cumplen la condicion filtrada en el panel de busqueda
	 **/
	private GrillaUtil tblGiros;	
	
	/**
	 * @variable filtro
	 * 		     Valor Fijo enviado a la Base de datos (8)
	 **/
	private int filtro;
	
	/**
	 * @variable estadoSeek
	 * 		     Valor Fijo enviado a la Base de datos (5)
	 **/
	private int estadoSeek;	

	/**
  	 * ****************************************************************.
  	 * @metodo FormaConsultaGiro
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
	public FormaConsultaGiro(JFrame pFrmPadre,
							 boolean pBooModal) throws Exception {
		
		super(pFrmPadre,
			  pBooModal);
		
		super.setEventoForma(new EventoFormaConsultaGiro(this));
		this.inicializarForma();
	}

	@Override
	public void inicializarForma(Object ...pArrObjParametrosForma) throws Exception{
		
		super.setTituloForma(EnumEtiquetas.TTL_BUS_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.FRM_CGN_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.FRM_CGN_VENTANA.getAlto());
        
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
								EnumBotonesEncabezado.BTNCONSULTAR,
								EnumBotonesEncabezado.BTNIMPRIMIR,
						  		EnumBotonesEncabezado.BTNSALIR
						  		);
		
		this.filtro = 8;
		this.estadoSeek = 5;
		
		super.iniciar(pArrObjParametrosForma);
	}

	@Override
	public JPanel inicializarEncabezado(Object ...pArrObjParametrosForma) throws Exception{
		
		JPanel pnlEncabezado;
		
		pnlEncabezado = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_CGN_ENCABEZADO,
																	"pnlEncabezado",
		  														 	null,
		  														 	null,
		  														 	null);
		pnlEncabezado.add(this.iniciarPropPnlEncabezadoGeneral());
		
		return pnlEncabezado;
	}

	@Override
	public JPanel inicializarCuerpo(Object ...pArrObjParametrosCuerpo) throws Exception{
		
		JPanel pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_CGN_CUERPO,
																"pnlCuerpo",
	  													 	 	null,
	  													 	 	null,
	  													 	 	null);
		pnlCuerpo.add(this.iniciarPropPnlBusquedaGiros());
		
		return pnlCuerpo;
	}

	@Override
	public JPanel inicializarPiePagina(Object ...pArrObjParametrosPiePagina) throws Exception{
		
		JPanel pnlPiePagina;
		
		pnlPiePagina = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_CGN_PIE_PAGINA,
																   "pnlPiePagina",
			 	 												   BorderFactory.createEmptyBorder(),
			 	 												   null,
			 	 												   null);
		pnlPiePagina.add(this.iniciarPropTblGiros().getScpContenedor());
		
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
														  			   EnumDimensionesComponentes.PNL_CGN_ENCABEZADO_GENERAL,
														  			   "pnlEncabezadoGeneral");
		}
		
		return this.pnlEncabezadoGeneral;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropPnlBusquedaGiros
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pnlBusquedaGiros
  	 * @return JPanel
  	 * 		   seccion de busqueda gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaPanelBusqueda iniciarPropPnlBusquedaGiros() throws Exception{
		
		if(this.pnlBusquedaGiros==null){
			
			this.pnlBusquedaGiros = new FormaPanelBusqueda(this, 
													       EnumDimensionesComponentes.PNL_CGN_BUSQUEDA,
													       "pnlBusquedaGiros");
		}
		
		return this.pnlBusquedaGiros;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropScrGrillaGiros
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   scpGrillaGiros
  	 * @return JScrollPane
  	 * 		   contenedor para el despliegue de grilla gestionado
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public JScrollPane iniciarPropScpGrillaGiros() throws Exception{
		
		if(this.scpGrillaGiros==null){
			
			this.scpGrillaGiros = UtilComponentesGUI.getInstance().crearScroll("scrGrillaGiros",
													 					   	   EnumDimensionesComponentes.SCP_CGN_GIROS_CONSULTADOS,
													 					   	   null);
			
			this.scpGrillaGiros.setViewportView(this.iniciarPropTblGiros());
		}
		
		return this.scpGrillaGiros;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropTblGiros
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   tblGiros
  	 * @return GrillaUtil
  	 * 		   grilla gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public GrillaUtil iniciarPropTblGiros() throws Exception{
		
		if(this.tblGiros==null){
			
			this.tblGiros = UtilComponentesGUI.getInstance().crearGrilla("tblGiros",
															   		 	 new EnumEtiquetas[]{EnumEtiquetas.TTL_CGN_GRILLA_GIROS_REFERENCIA,
																				  	  		 EnumEtiquetas.TTL_CGN_GRILLA_GIROS_VALOR,
																				  	  		 EnumEtiquetas.TTL_CGN_GRILLA_GIROS_ID_TERCERO_DESTINO,
																				  	  		 EnumEtiquetas.TTL_CGN_GRILLA_GIROS_NOMBRES_TERCERO_DESTINO,
																				  	  		 EnumEtiquetas.TTL_CGN_GRILLA_GIROS_APELLIDOS_TERCERO_DESTINO,
																				  	  		 EnumEtiquetas.TTL_CGN_GRILLA_GIROS_NOMBRE_AGENCIA_ORIGEN,
																				  	  		 EnumEtiquetas.TTL_CGN_GRILLA_GIROS_ID_TERCERO_ORIGEN,
																				  	  		 EnumEtiquetas.TTL_CGN_GRILLA_GIROS_NOMBRES_TERCERO_ORIGEN,
																				  	  		 EnumEtiquetas.TTL_CGN_GRILLA_GIROS_APELLIDOS_TERCERO_ORIGEN,
																				  	  		 EnumEtiquetas.TTL_CGN_GRILLA_GIROS_DOMICILIO,
																				  	  		 EnumEtiquetas.TTL_CGN_GRILLA_GIROS_NOTAS,
																				  	  		 EnumEtiquetas.TTL_CGN_GRILLA_GIROS_ESTADO},//visibles
															   		     new EnumEtiquetas[]{EnumEtiquetas.TTL_CGN_GRILLA_GIROS_REFERENCIA,
																				  	  		 EnumEtiquetas.TTL_CGN_GRILLA_GIROS_ID_TERCERO_DESTINO,
																				  	  		 EnumEtiquetas.TTL_CGN_GRILLA_GIROS_ID_TERCERO_ORIGEN,
																				  	  		 EnumEtiquetas.TTL_CGN_GRILLA_GIROS_DOMICILIO,
																				  	  		 EnumEtiquetas.TTL_CGN_GRILLA_GIROS_ESTADO},//invisibles
																	     null,/*new boolean []{false,
																						false,
																						false,
																						false,
																						false,
																						false,
																						false,
																						false,
																						false,
																						false,
																						false,	
																						false}*///editable por columna
															   		     null,
															   		     super.getEventoForma());
			this.tblGiros.getScpContenedorRound(EnumDimensionesComponentes.SCP_CGN_GIROS_CONSULTADOS);
		}
		
		return this.tblGiros;
	}

	/**
	 * @method getPnlBusquedaGiros
	 * 		   Metodo get del atributo pnlBusquedaGiros
	 * @return FormaPanelBusqueda
	 *		   Valor del atributo pnlBusquedaGiros devuelto
	 * @author roberth.martinez
	 * @date   8/6/2016
	 */
	public FormaPanelBusqueda getPnlBusquedaGiros() {
		return this.pnlBusquedaGiros;
	}

	/**
	 * @method setPnlBusquedaGiros
	 * 		   Metodo set del atributo pnlBusquedaGiros
	 * @param  pPnlBusquedaGiros
	 *		   Valor que tomara el atributo pnlBusquedaGiros
	 * @author roberth.martinez
	 * @date   8/6/2016
	 */
	public void setPnlBusquedaGiros(FormaPanelBusqueda pPnlBusquedaGiros) {
		this.pnlBusquedaGiros = pPnlBusquedaGiros;
	}
	
	/**
	 * @method getPnlEncabezadoGeneral
	 * 		   Metodo get del atributo pnlEncabezadoGeneral
	 * @return FormaPanelEncabezadoGeneral
	 *		   Valor del atributo pnlEncabezadoGeneral devuelto
	 * @author roberth.martinez
	 * @date   8/6/2016
	 */
	public FormaPanelEncabezadoGeneral getPnlEncabezadoGeneral() {
		return this.pnlEncabezadoGeneral;
	}

	/**
	 * @method setPnlEncabezadoGeneral
	 * 		   Metodo set del atributo pnlEncabezadoGeneral
	 * @param  pPnlEncabezadoGeneral
	 *		   Valor que tomara el atributo pnlEncabezadoGeneral
	 * @author roberth.martinez
	 * @date   8/6/2016
	 */
	public void setPnlEncabezadoGeneral(
			FormaPanelEncabezadoGeneral pPnlEncabezadoGeneral) {
		this.pnlEncabezadoGeneral = pPnlEncabezadoGeneral;
	}

	/**
	 * @method getFiltro
	 * 		   Metodo get del atributo filtro
	 * @return int
	 *		   Valor del atributo filtro devuelto
	 * @author roberth.martinez
	 * @date   8/6/2016
	 */
	public int getFiltro() {
		return this.filtro;
	}

	/**
	 * @method setFiltro
	 * 		   Metodo set del atributo filtro
	 * @param  pFiltro
	 *		   Valor que tomara el atributo filtro
	 * @author roberth.martinez
	 * @date   8/6/2016
	 */
	public void setFiltro(int pFiltro) {
		this.filtro = pFiltro;
	}
	
	/**
	 * @method getScpGrillaGiros
	 * 		   Metodo get del atributo scpGrillaGiros
	 * @return JScrollPane
	 *		   Valor del atributo scpGrillaGiros devuelto
	 * @author roberth.martinez
	 * @date   8/6/2016
	 */
	public JScrollPane getScpGrillaGiros() {
		return this.scpGrillaGiros;
	}

	/**
	 * @method setScpGrillaGiros
	 * 		   Metodo set del atributo scpGrillaGiros
	 * @param  pScpGrillaGiros
	 *		   Valor que tomara el atributo scpGrillaGiros
	 * @author roberth.martinez
	 * @date   8/6/2016
	 */
	public void setScpGrillaGiros(JScrollPane pScpGrillaGiros) {
		this.scpGrillaGiros = pScpGrillaGiros;
	}

	/**
	 * @method getTblGiros
	 * 		   Metodo get del atributo tblGiros
	 * @return GrillaUtil
	 *		   Valor del atributo tblGiros devuelto
	 * @author roberth.martinez
	 * @date   8/6/2016
	 */
	public GrillaUtil getTblGiros() {
		return this.tblGiros;
	}

	/**
	 * @method setTblGiros
	 * 		   Metodo set del atributo tblGiros
	 * @param  pTblGiros
	 *		   Valor que tomara el atributo tblGiros
	 * @author roberth.martinez
	 * @date   8/6/2016
	 */
	public void setTblGiros(GrillaUtil pTblGiros) {
		this.tblGiros = pTblGiros;
	}

	/**
	 * @method getEstadoSeek
	 * 		   Metodo get del atributo estadoSeek
	 * @return int
	 *		   Valor del atributo estadoSeek devuelto
	 * @author roberth.martinez
	 * @date   8/6/2016
	 */
	public int getEstadoSeek() {
		return this.estadoSeek;
	}

	/**
	 * @method setEstadoSeek
	 * 		   Metodo set del atributo estadoSeek
	 * @param  pEstadoSeek
	 *		   Valor que tomara el atributo estadoSeek
	 * @author roberth.martinez
	 * @date   8/6/2016
	 */
	public void setEstadoSeek(int pEstadoSeek) {
		this.estadoSeek = pEstadoSeek;
	}

	/** 
	 * ********************************************************************
	 * @method main
	 * 		   metodo para ejcutar la forma
	 * @param  args
	 * 		   parametros entrada
	 * @author roberth.martinez
	 * @date   8/6/2016
	 * *********************************************************************
	 */
	public static void main(String[] args) {
		
		JFrame jframe = null;
		
		try{
	        
			jframe = TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaConsultaGiro.class,
																		    true, 
																		    EnumDesplegarFormaConEventos.SI);
			new FormaConsultaGiro(jframe,true);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			Logger.getInstance().error(e.getMessage());
			
		}
	}
	
}

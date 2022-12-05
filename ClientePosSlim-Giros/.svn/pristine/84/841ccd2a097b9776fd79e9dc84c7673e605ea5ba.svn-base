package co.com.codesa.clienteposslimgiros.formas.caja;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import co.com.codesa.clienteposslim.logger.Logger;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.caja.EventoFormaCierreCaja;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.GrillaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelEncabezadoGeneral;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 13-abr-2015
 * @Clase FormaCierreCaja 
 * 		  Clase que genera la forma (GUI) para el proceso de cierre
 * 		  de caja 
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class FormaCierreCaja extends FormaGenerica{

	/**
	 * @variable 	serialVersionUID
	 * 			 	Variable serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @variable pnlEncabezadoGeneral
	 * 			 seccion que aloja el encabezado general para las formas, 
	 * 			 que contiene los valores de agencia, empresa y caja, 
	 * 			 normalmente recuperados del usuario autenticado
	 **/
	private FormaPanelEncabezadoGeneral pnlEncabezadoGeneral;
	
	/**
	 * @variable tblMediosPago 
	 * 			 grilla donde se relaciona la informacion asociada a 
	 * 			 los medios de pago configurados para el usuario
	 **/
	private GrillaUtil tblMediosPago;
	
	/**
	 * @variable scpGrillaMediosPago 
	 * 			 componente grafico que permite incluir barras de 
	 * 			 desplazamiento para facilitar el despliegue de la 
	 * 			 grilla
	 **/
	//private JScrollPane scpGrillaMediosPago;
	
	/**
  	 * ****************************************************************.
  	 * @metodo FormaCierreCaja
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
	public FormaCierreCaja(JFrame pFrmPadre,
						   boolean pBooModal) throws Exception{
		
		super(pFrmPadre,
			  pBooModal);
		
		super.setEventoForma(new EventoFormaCierreCaja(this));
		
		this.inicializarForma();
	}

	/**
  	 * ****************************************************************.
  	 * @metodo inicializarForma
  	 * 		   Metodo propuesto por la forma generica, para inicializar 
  	 * 		   todos los aspectos de la forma
  	 * @param pArrObjParametrosForma 
  	 * 		  lista de posibles parametros a incluir sobre esta etapa
  	 * 		  [x]: descripcion del valor enviado en la posicion [x]
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public void inicializarForma(Object ...pArrObjParametrosForma) throws Exception{
		
		super.setTituloForma(EnumEtiquetas.TTL_CC_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.GUI_CC_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.GUI_CC_VENTANA.getAlto());
		
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
						  		EnumBotonesEncabezado.BTNSALIR);
		
		super.iniciar(pArrObjParametrosForma);
	}

	/**
  	 * ****************************************************************.
  	 * @metodo inicializarEncabezado
  	 * 		   Metodo dedicado a inicializar y gestionar el encabezado 
  	 * 		   de la forma (seccion superior)
  	 * @param pArrObjParametrosForma
  	 * 		  lista de posibles parametros a incluir sobre esta etapa
  	 * 		  [x]: descripcion del valor enviado en la posicion [x]
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public JPanel inicializarEncabezado(Object ...pArrObjParametrosForma) throws Exception {
		
		JPanel pnlEncabezado;
		
		pnlEncabezado = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_CC_ENCABEZADO,
																	"pnlEncabezado",
				  													BorderFactory.createEmptyBorder(),
				  													null,
				  													null);
		pnlEncabezado.add(this.iniciarPropPnlEncabezadoGeneral());
		
		return pnlEncabezado;
	}

	/**
  	 * ****************************************************************.
  	 * @metodo inicializarCuerpo
  	 * 		   Metodo dedicado a inicializar y gestionar el cuerpo 
  	 * 		   de la forma (seccion central)
  	 * @param pArrObjParametrosForma
  	 * 		  lista de posibles parametros a incluir sobre esta etapa
  	 * 		  [x]: descripcion del valor enviado en la posicion [x]
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public JPanel inicializarCuerpo(Object ...pArrObjParametrosForma) throws Exception{
		
		JPanel pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_CC_CUERPO,
																"pnlCuerpo",
																BorderFactory.createEmptyBorder(),
				  												null,
				  												null);
		
		pnlCuerpo.add(this.iniciarPropTblMediosPago().getScpContenedor());		
		
		return pnlCuerpo;
	}

	/**
  	 * ****************************************************************.
  	 * @metodo inicializarPiePagina
  	 * 		   Metodo dedicado a inicializar y gestionar el pie de pagina 
  	 * 		   de la forma (seccion inferior)
  	 * @param pArrObjParametrosForma
  	 * 		  lista de posibles parametros a incluir sobre esta etapa
  	 * 		  [x]: descripcion del valor enviado en la posicion [x]
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public JPanel inicializarPiePagina(Object ...pArrObjParametrosForma) throws Exception{
		return null;
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
			
			this.pnlEncabezadoGeneral = new FormaPanelEncabezadoGeneral(null,
																	   super.getObjUsuario().getAgencia(),
																	   super.getObjUsuario().getCaja(),
														  			   EnumDimensionesComponentes.PNL_CC_ENCABEZADO_GENERAL,
														  			   "pnlEncabezadoGeneral");
		}
		
		return this.pnlEncabezadoGeneral;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropScpGrillaMediosPago
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   scpGrillaMediosPago
  	 * @return JScrollPane 
  	 * 		   contenedor para el despliegue de grilla gestionado
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	/*public JScrollPane iniciarPropScpGrillaMediosPago() throws Exception{
		
		if(this.scpGrillaMediosPago==null){
			
			this.scpGrillaMediosPago = UtilComponentesGUI.getInstance().crearScroll("scpGrillaMediosPago",
													 				  				EnumDimensionesComponentes.SCP_CC_SCROLL_GRILLA,
													 				  				null);
			
			this.scpGrillaMediosPago.setViewportView(this.iniciarPropTblMediosPago());
		}
		
		return this.scpGrillaMediosPago;
	}*/
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropTblMediosPago
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   tblMediosPago
  	 * @return GrillaUtil 
  	 * 		   grilla gestionada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public GrillaUtil iniciarPropTblMediosPago() throws Exception{
		
		if(this.tblMediosPago==null){
			
			this.tblMediosPago = UtilComponentesGUI.getInstance().crearGrilla("tblMediosPago",
															   		  	  	  new EnumEtiquetas[]{EnumEtiquetas.TTL_CC_GRILLA_MEDIO_PAGO,
																				   	   	   		  EnumEtiquetas.TTL_CC_GRILLA_MONEDA,
																				   	   	   		  EnumEtiquetas.TTL_CC_GRILLA_SALDO_INICIAL,
																				   	   	   		  EnumEtiquetas.TTL_CC_GRILLA_INGRESOS,
																				   	   	   		  EnumEtiquetas.TTL_CC_GRILLA_EGRESOS,
																				   	   	   		  EnumEtiquetas.TTL_CC_GRILLA_TRASLADOS,
																				   	   	   		  EnumEtiquetas.TTL_CC_GRILLA_SALDO_FINAL},
																		      null,
																		      null,
																		      new int[]{150,
																						100,
																						100,
																						100,
																						100,
																						100,
																						100},//[TODO Q-en-K]: trarar de migrar a componente de dimensiones
																		      null);
			this.tblMediosPago.getScpContenedorRound(EnumDimensionesComponentes.SCP_CC_SCROLL_GRILLA);
		}
		
		return this.tblMediosPago;
	}

	/*public JScrollPane getScpGrillaMediosPago() {
		return scpGrillaMediosPago;
	}

	public void setScpGrillaMediosPago(JScrollPane scpGrillaMediosPago) {
		this.scpGrillaMediosPago = scpGrillaMediosPago;
	}*/

	/**
	 * @method getPnlEncabezadoGeneral
	 * 		   Metodo get del atributo pnlEncabezadoGeneral
	 * @return FormaPanelEncabezadoGeneral
	 *		   Valor del atributo pnlEncabezadoGeneral devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
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
	 * @date   28/11/2016
	 */
	public void setPnlEncabezadoGeneral(
			FormaPanelEncabezadoGeneral pPnlEncabezadoGeneral) {
		this.pnlEncabezadoGeneral = pPnlEncabezadoGeneral;
	}

	/**
	 * @method getTblMediosPago
	 * 		   Metodo get del atributo tblMediosPago
	 * @return GrillaUtil
	 *		   Valor del atributo tblMediosPago devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public GrillaUtil getTblMediosPago() {
		return this.tblMediosPago;
	}

	/**
	 * @method setTblMediosPago
	 * 		   Metodo set del atributo tblMediosPago
	 * @param  pTblMediosPago
	 *		   Valor que tomara el atributo tblMediosPago
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setTblMediosPago(GrillaUtil pTblMediosPago) {
		this.tblMediosPago = pTblMediosPago;
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
	        
			jframe = TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaCierreCaja.class,
																			true, 
																			EnumDesplegarFormaConEventos.SI);
			new FormaCierreCaja(jframe,true);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			Logger.getInstance().error(e.getMessage());
			
		}
	}
}

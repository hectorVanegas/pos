package co.com.codesa.clienteposslimgiros.formas.caja;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import co.com.codesa.clienteposslim.logger.Logger;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.caja.EventoFormaAperturarCaja;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.GrillaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelEncabezadoGeneral;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 09-mar-2015 
 * @clase FormaAperturarCaja
 * 		  Clase que genera la forma (GUI) para el proceso de apertura 
 * 		  de caja 
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class FormaAperturarCaja extends FormaGenerica{

	/**
	 * @variable serialVersionUID
	 * 			 Variable serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @variable pnlEncabezadoGeneral
	 * 			 seccion que aloja el encabezado general para las formas, 
	 * 			 que contiene los valores de agencia, empresa y caja, 
	 * 			 normalmente recuperados del usuario autenticado
	 **/
	private JPanel pnlEncabezadoGeneral;
	
	/**
	 * @variable scpGrillaMediosPago 
	 * 			 componente grafico que permite incluir barras de 
	 * 			 desplazamiento para facilitar el despliegue de la 
	 * 			 grilla
	 **/
	//private JScrollPane scpGrillaMediosPago;
	
	/**
	 * @variable tblMediosPago 
	 * 			 grilla donde se relaciona la informacion asociada a 
	 * 			 los medios de pago configurados para el usuario
	 **/
	private GrillaUtil tblMediosPago;
	
	/**
  	 * ****************************************************************.
  	 * @metodo FormaAperturarCaja
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
	public FormaAperturarCaja(JFrame pFrmPadre,
							  boolean pBooModal) throws Exception{
		
		super(pFrmPadre,
			  pBooModal);
		
		super.setEventoForma(new EventoFormaAperturarCaja(this));
		
		this.inicializarForma(pBooModal);
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo FormaAperturarCaja
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
	public FormaAperturarCaja(JDialog pFrmPadre,
							  boolean pBooModal) throws Exception{
		
		super(pFrmPadre,
			  pBooModal);
		
		super.setEventoForma(new EventoFormaAperturarCaja(this));
		
		this.inicializarForma(pBooModal);
	}

	/**
  	 * ****************************************************************.
  	 * @metodo inicializarForma
  	 * 		   Metodo propuesto por la forma generica, para inicializar 
  	 * 		   todos los aspectos de la forma
  	 * @param pArrObjParametrosForma 
  	 * 		  lista de posibles parametros a incluir sobre la inicializacion 
  	 * 		  de la forma
  	 * 		  [x]: descripcion del valor enviado en la posicion [x]
  	 * 		  [0]: bandera modal para finalizar la inicializacion de la 
  	 * 			   forma en aspectos modales. Estrategia para permitir
  	 * 			   ejecutar el inicio de valores posteriores a la 
  	 * 			   construccion de la forma
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public void inicializarForma(Object ...pArrObjParametrosForma) throws Exception{
		
		super.setTituloForma(EnumEtiquetas.TTL_APC_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.GUI_APC_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.GUI_APC_VENTANA.getAlto());
		
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
						  		EnumBotonesEncabezado.BTNSALIR);
		
		super.iniciar(pArrObjParametrosForma);
	}

	@Override
	public JPanel inicializarEncabezado(Object ...pArrObjParametrosEncabezado) throws Exception {
		
		JPanel pnlEncabezado;
		
		pnlEncabezado = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_APC_ENCABEZADO,
																	"pnlEncabezado",
																	BorderFactory.createEmptyBorder(),
	  	  														 	null,
	  	  														 	null);
		pnlEncabezado.add(this.iniciarPropPnlEncabezadoGeneral());
		
		return pnlEncabezado;
	}

	@Override
	public JPanel inicializarCuerpo(Object ...pArrObjParametrosCuerpo) throws Exception{
		
		JPanel pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_APC_CUERPO,
																"pnlCuerpo",
				  												BorderFactory.createEmptyBorder(),
				  												null,
				  												null);
		
		pnlCuerpo.add(this.iniciarPropTblMediosPago().getScpContenedor());
		
		return pnlCuerpo;
	}

	@Override
	public JPanel inicializarPiePagina(Object ...pArrObjParametrosPiePagina) throws Exception{
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
			
			this.pnlEncabezadoGeneral = new FormaPanelEncabezadoGeneral(null,
																	    super.getObjUsuario().getAgencia(),
																	    super.getObjUsuario().getCaja(),
														  			    EnumDimensionesComponentes.PNL_APC_ENCABEZADO_GENERAL,
														  			  	"FormaPanelEncabezadoGeneral");
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
													 				  				EnumDimensionesComponentes.SCP_APC_SCROLL_GRILLA,
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
															   		  	  	  new EnumEtiquetas[]{EnumEtiquetas.TTL_APC_GRILLA_MEDIO_PAGO,
																				   	   	   		  EnumEtiquetas.TTL_APC_GRILLA_MONEDA,
																				   	   	   		  EnumEtiquetas.TTL_APC_GRILLA_SALDO_INICIAL},
																		      null,
																		      null,
																		      new int[]{150,
																					    100,
																					    100},//[TODO Q-en-K]: trarar de migrar a componente de dimensiones
																			  null);
			
			this.tblMediosPago.getScpContenedorRound(EnumDimensionesComponentes.SCP_APC_SCROLL_GRILLA);
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
	 * @return JPanel
	 *		   Valor del atributo pnlEncabezadoGeneral devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public JPanel getPnlEncabezadoGeneral() {
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
	public void setPnlEncabezadoGeneral(JPanel pPnlEncabezadoGeneral) {
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
	        
			jframe = TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaAperturarCaja.class,
																			true, 
																			EnumDesplegarFormaConEventos.SI);
			new FormaAperturarCaja(jframe,true);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			Logger.getInstance().error(e.getMessage());
			
		}
	}
}

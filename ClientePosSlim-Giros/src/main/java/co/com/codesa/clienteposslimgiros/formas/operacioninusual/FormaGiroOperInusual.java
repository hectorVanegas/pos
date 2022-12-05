package co.com.codesa.clienteposslimgiros.formas.operacioninusual;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.eventos.operacioninusual.EventoFormaGiroOperInusual;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.AreaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.OperacionInusual;

public class FormaGiroOperInusual extends FormaGenerica {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @variable lblOperInusual
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 contiene la operacion inusual
	 **/
	private EtiquetaUtil lblOperInusual;
	
	/**
	 * @variable cmbOperInusual
	 * 			 componente de combo sobre la forma que  contiene el listado 
	 * 		     de mensajes de operaciones predeterminadas
	 **/
	private CajaComboUtil cmbOperInusual;
	
	/**
	 * @variable lblNotas
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 contiene la nota de la operacion inusual
	 **/
	private EtiquetaUtil lblNotas;
	
	/**
	 * @variable txaNotas
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 contiene el area de texto para la nota de la operacion inusual
	 **/
	private AreaTextoUtil txaNotas;

	public FormaGiroOperInusual(FormaGenerica pFrmPadre, 
							    boolean pBooModal,
							    OperacionInusual pObjOperacionInusual) throws Exception {
		
		super(pFrmPadre, 
			  pBooModal);
		
		super.setEventoForma(new EventoFormaGiroOperInusual(this, pObjOperacionInusual));
		
		inicializarForma();
	}

	@Override
	public void inicializarForma(Object... pArrObjParametrosForma) throws Exception {
		
		super.setTituloForma(EnumEtiquetas.TTL_OI_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.GUI_VENTANA_OPERINU.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.GUI_VENTANA_OPERINU.getAlto());
		
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
								EnumBotonesEncabezado.BTN_ANULAR,
								EnumBotonesEncabezado.BTNVOLVER);
		
		super.iniciar(pArrObjParametrosForma);
	}

	@Override
	public JPanel inicializarEncabezado(Object... pArrObjParametrosEncabezado) throws Exception {
		return null;
	}

	@Override
	public JPanel inicializarCuerpo(Object... pArrObjParametrosCuerpo) throws Exception {
		
		JPanel pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_CONTENCENTRO_OPERINU,
																"pnlCuerpo",
	  													 		null,
	  													 		null,
	  													 		null);
		pnlCuerpo.add(this.iniciarPropLblOperInusual());
		pnlCuerpo.add(this.iniciarPropCmbOperInusual());
		pnlCuerpo.add(this.iniciarPropLblNotas());
		pnlCuerpo.add(this.iniciarPropTxaNotas().getScpContenedor());
		
		return pnlCuerpo;
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo iniciarPropLblOperInusual
     * 		   metodo utilizado para inicializar el componente EtiquetaUtil 
     * 		   de operacion inusual
     * @return EtiquetaUtil componente EtiquetaUtil
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblOperInusual() throws Exception{
		
		if (this.lblOperInusual == null) {
			
			this.lblOperInusual = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_OPERINU_OPERINU, 
																	   		  "lblOperInusual", 
																	   		  EnumEtiquetas.LBL_OI_OPERINUSUAL,
																	   		  true,
																	   		  null,
																	   		  true);
		}
		return this.lblOperInusual;
	}
	
	/**
     * ****************************************************************
     * @metodo iniciarPropCmbMsjPred
     * 		   metodo utilizado para inicializar el componente 
     * 		   CajaComboUtil de mensajes de operaciones inusuales
     * @return CajaComboUtil 
     * 		   componente CajaComboUtil
     * @throws Exception
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */	
	public CajaComboUtil iniciarPropCmbOperInusual() throws Exception{
		
		if (this.cmbOperInusual == null) {
			
			this.cmbOperInusual = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.JCB_OPERINU_OPERINU, 
																				 "cmbOperInusual",
																				 true, 
																				 true, 
																				 super.getEventoForma(),
																				 EnumEtiquetas.LBL_OI_OPERINUSUAL);
			
		}

		return this.cmbOperInusual;
	}

	/**
     * ****************************************************************
     * @throws Exception
     * @metodo iniciarPropLblNotas
     * 		   metodo utilizado para inicializar el componente EtiquetaUtil 
     * 		   de notas
     * @return EtiquetaUtil componente EtiquetaUtil
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblNotas() throws Exception{
		
		if (this.lblNotas == null) {
			
			this.lblNotas = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_NOTAS_OPERINU, 
																	    "lblNotas", 
																	    EnumEtiquetas.LBL_OI_ANOTACIONES,
																	    true,
																	    null,
																	    true);
		}
		return this.lblNotas;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  iniciarPropTxaNotas
     * 			metodo utilizado para inicializar el componente 
     * 			AreaTextoUtil de notas 
     * @return  AreaTextoUtil componente AreaTextoUtil
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */	
	public AreaTextoUtil iniciarPropTxaNotas() throws Exception{
		
		if (this.txaNotas == null) {
			
			this.txaNotas = UtilComponentesGUI.getInstance().crearTextArea(null,//EnumDimensionesComponentes.SCR_NOTAS_OPERINU, 
																	   	   "txaNotas", 
																	   	   "", 	
																	   	   true, 
																	   	   true, 
																	   	   true, 
																	   	   super.getEventoForma(),
																	   	   EnumEtiquetas.LBL_OI_ANOTACIONES);
			
			this.txaNotas.getScpContenedorRound(EnumDimensionesComponentes.SCR_NOTAS_OPERINU);
			this.txaNotas.getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_NOTAS.getValor());
		}
		
		return this.txaNotas;
	}
	
	
	public JPanel inicializarPiePagina(Object... pArrObjParametrosPiePagina)
			throws Exception {
		return null;
	}

	public CajaComboUtil getJcbOperInusual() {
		return cmbOperInusual;
	}

	public EtiquetaUtil getLblNotas() {
		return lblNotas;
	}

	public void setLblNotas(EtiquetaUtil lblNotas) {
		this.lblNotas = lblNotas;
	}

	public void setJcbOperInusual(CajaComboUtil jcbOperInusual) {
		this.cmbOperInusual = jcbOperInusual;
	}

	public AreaTextoUtil getTxtNotas() {
		return txaNotas;
	}

	public void setTxtNotas(AreaTextoUtil txtNotas) {
		this.txaNotas = txtNotas;
	}

	public EtiquetaUtil getLblOperInusual() {
		return lblOperInusual;
	}

	public void setLblOperInusual(EtiquetaUtil lblOperInusual) {
		this.lblOperInusual = lblOperInusual;
	}
	
	public EventoFormaGiroOperInusual castEvaFrmOperacionInusual()throws Exception{
		return (EventoFormaGiroOperInusual)super.getEventoForma();
	}

	public static void main(String[] args) {
		
		try{
	    
			TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaGiroOperInusual.class,
																   true, 
																   EnumDesplegarFormaConEventos.NO);
			new FormaGiroOperInusual(null, 
									 true, 
									 null);
			
		} catch (Exception e) {
			
			UtilidadesGiros.getInstance().controlExcepcion(e, 
														   null);
		}
	}
}
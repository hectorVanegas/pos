package co.com.codesa.clienteposslimgiros.formas.operacioninusual;

import javax.swing.JPanel;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.eventos.operacioninusual.EventoFormaGestionReclamoInternacional;
import co.com.codesa.clienteposslimgiros.eventos.operacioninusual.EventoFormaGiroOperInusual;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.AreaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiroInternacional;

/**
 * 
 * ********************************************************************
 * @class	FormaGestionReclamoInternacional
 *		 	Forma para la gestion de reclamos en giros internacionales
 * @author	stiven.garcia
 * @date  	24/03/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class FormaGestionReclamoInternacional extends FormaGenerica {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @variable lblGestionReclamos
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 contiene la gestion de reclamos
	 **/
	private EtiquetaUtil lblGestionReclamos;
	
	/**
	 * @variable cmbGestionReclamos
	 * 			 componente de combo sobre la forma que  contiene el listado 
	 * 		     de reclamos predeterminadas
	 **/
	private CajaComboUtil cmbGestionReclamos;
	
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
	
	/**
	 * @variable objFacturaGiroInternacional
	 * 			 objeto factura giro internacional que contiene
	 * 			 idTransacion para la operacion de pago remesa
	 */
	private FacturaGiroInternacional objFacturaGiroInternacional;

	/**
	 * 
	 * ********************************************************************
	 * @method	FormaGestionReclamoInternacional
	 * 		  	Constructor de la forma para la gestion de reclamos
	 * @param pFrmPadre
	 * @param pFacturaGiroInternacional
	 * 			Factura giro internacional para la cual aplica el reclamo
	 * @param pBooModal
	 * @throws Exception	
	 * 		   Controla, 
	 * @author	usuario
	 * @date	24/03/2018
	 * *********************************************************************
	 */
	public FormaGestionReclamoInternacional(FormaGenerica pFrmPadre,
										FacturaGiroInternacional pFacturaGiroInternacional,
										boolean pBooModal) throws Exception {
		
		super(pFrmPadre, 
			  pBooModal);
		
		super.setEventoForma(new EventoFormaGestionReclamoInternacional(this));
		
		this.objFacturaGiroInternacional = pFacturaGiroInternacional;
		
		inicializarForma();
	}

	@Override
	public void inicializarForma(Object... pArrObjParametrosForma) throws Exception {
		
		super.setTituloForma(EnumEtiquetas.TTL_GRI_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.GUI_GRI_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.GUI_GRI_VENTANA.getAlto());
		
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
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_GRI_CUERPO,
																"pnlCuerpo",
	  													 		null,
	  													 		null,
	  													 		null);
		pnlCuerpo.add(this.iniciarPropLblGestionReclamo());
		pnlCuerpo.add(this.iniciarPropCmbGestionReclamo());
		pnlCuerpo.add(this.iniciarPropLblNotas());
		pnlCuerpo.add(this.iniciarPropTxaNotas().getScpContenedor());
		
		return pnlCuerpo;
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * 	  	   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @metodo iniciarPropLblGestionReclamo
     * 		   metodo utilizado para inicializar el componente EtiquetaUtil 
     * 		   de operacion inusual
     * @return EtiquetaUtil componente EtiquetaUtil
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblGestionReclamo() throws Exception{
		
		if (this.lblGestionReclamos == null) {
			
			this.lblGestionReclamos = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_GRI_MENSAJE, 
																	   		  "lblGestionReclamo", 
																	   		  EnumEtiquetas.LBL_GRI_MENSAJE,
																	   		  true,
																	   		  null,
																	   		  true);
		}
		return this.lblGestionReclamos;
	}
	
	/**
     * ****************************************************************
     * @metodo iniciarPropCmbGestionReclamo
     * 		   metodo utilizado para inicializar el componente 
     * 		   CajaComboUtil de mensajes de operaciones inusuales
     * @return CajaComboUtil 
     * 		   componente CajaComboUtil
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */	
	public CajaComboUtil iniciarPropCmbGestionReclamo() throws Exception{
		
		if (this.cmbGestionReclamos == null) {
			
			this.cmbGestionReclamos = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_GRI_MENSAJE, 
																				 "cmbGestionReclamos",
																				 true, 
																				 true, 
																				 super.getEventoForma(),
																				 EnumEtiquetas.LBL_GRI_MENSAJE);
			
		}

		return this.cmbGestionReclamos;
	}

	/**
     * ****************************************************************
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @metodo iniciarPropLblNotas
     * 		   metodo utilizado para inicializar el componente EtiquetaUtil 
     * 		   de notas
     * @return EtiquetaUtil componente EtiquetaUtil
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblNotas() throws Exception{
		
		if (this.lblNotas == null) {
			
			this.lblNotas = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_GRI_COMENTARIO, 
																	    "lblNotas", 
																	    EnumEtiquetas.LBL_GRI_COMENTARIO,
																	    true,
																	    null,
																	    true);
		}
		return this.lblNotas;
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
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
																	   	   EnumEtiquetas.LBL_GRI_COMENTARIO);
			
			this.txaNotas.getScpContenedorRound(EnumDimensionesComponentes.SCP_GRI_COMENTARIO);
			this.txaNotas.getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.GRI_COMENTARIO.getValor());
		}
		
		return this.txaNotas;
	}
	
	
	public JPanel inicializarPiePagina(Object... pArrObjParametrosPiePagina)
			throws Exception {
		return null;
	}

	public CajaComboUtil getJcbGestionReclamos() {
		return cmbGestionReclamos;
	}

	public EtiquetaUtil getLblNotas() {
		return lblNotas;
	}

	public void setLblNotas(EtiquetaUtil lblNotas) {
		this.lblNotas = lblNotas;
	}

	public void setJcbGestionReclamos(CajaComboUtil jcbGestionReclamo) {
		this.cmbGestionReclamos = jcbGestionReclamo;
	}

	public AreaTextoUtil getTxtNotas() {
		return txaNotas;
	}

	public void setTxtNotas(AreaTextoUtil txtNotas) {
		this.txaNotas = txtNotas;
	}

	public EtiquetaUtil getLblOperInusual() {
		return lblGestionReclamos;
	}

	public void setLblOperInusual(EtiquetaUtil lblGestionReclamo) {
		this.lblGestionReclamos = lblGestionReclamo;
	}
	
	public EventoFormaGiroOperInusual castEvaFrmOperacionInusual()throws Exception{
		return (EventoFormaGiroOperInusual)super.getEventoForma();
	}	

	public FacturaGiroInternacional getObjFacturaGiroInternacional() {
		return objFacturaGiroInternacional;
	}

	public void setObjFacturaGiroInternacional(FacturaGiroInternacional objFacturaGiroInternacional) {
		this.objFacturaGiroInternacional = objFacturaGiroInternacional;
	}

	public static void main(String[] args) {
		
		try{
	    
			TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaGestionReclamoInternacional.class,
																   true, 
																   EnumDesplegarFormaConEventos.SI);
			FacturaGiroInternacional factura = new FacturaGiroInternacional();
			factura.setStrIdTtransaccion("123456");
			
			new FormaGestionReclamoInternacional(null,factura,true);
			
		} catch (Exception e) {
			
			UtilidadesGiros.getInstance().controlExcepcion(e, 
														   null);
		}
	}
}
package co.com.codesa.clienteposslimgiros.formas.biometria;

import javax.swing.JDialog;
import javax.swing.JPanel;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.eventos.biometria.EventoFormaEnrolarTercero;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.BotonUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelTercero;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DatoEntidad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;

/**
 * ****************************************************************.
 * @autor: Roberth Martinez Vargas
 * @fecha: 08-may-2015
 * @descripcion: Clase para enrolar un tercero
 * @copyright: Copyright  1998-2012 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class FormaEnrolarTercero extends FormaGenerica{

	private EtiquetaUtil lblHuellaDerecha;
	private EtiquetaUtil lblHuellaDerExitoso;
	private EtiquetaUtil lblHuellaIzquierda;
	private EtiquetaUtil lblHuellaIzqExitoso;
	private BotonUtil btnHuellaDerecha;
	private BotonUtil btnHuellaIzquierda;
	private JPanel pnlTercero;
	private Tercero tercero;
	
	private static final long serialVersionUID = 1L;

	public FormaEnrolarTercero(JDialog pFrmPadre, 
							   boolean pBooModal, 
							   Tercero pTercero) throws Exception {
		
		super(pFrmPadre, 
			  pBooModal);
		
		this.tercero = pTercero;
		super.setEventoForma(new EventoFormaEnrolarTercero(this));
		this.inicializarForma();
		
	}

	@Override
	public void inicializarForma(Object... pArrObjParametrosForma) throws Exception {
		super.setTituloForma(EnumEtiquetas.TTL_ETC_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.FRM_ETC_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.FRM_ETC_VENTANA.getAlto());
        
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
								EnumBotonesEncabezado.BTNVOLVER);
		
		super.iniciar(pArrObjParametrosForma);
	}

	@Override
	public JPanel inicializarEncabezado(Object... pArrObjParametrosForma) throws Exception {
		JPanel pnlEncabezado = null;
		
		pnlEncabezado = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_ETC_PANEL_ENCABEZADO,
																	"pnlEncabezado",
				  													null,
				  													null,
				  													null);
		pnlEncabezado.add(this.iniciarPropPnlTercero());
		
		pnlEncabezado.add(this.iniciarPropLblHuellaDerecha());
		pnlEncabezado.add(this.iniciarPropBtnHuellaDerecha());
		pnlEncabezado.add(this.iniciarPropLblHuellaDerExitoso());
		
		pnlEncabezado.add(this.iniciarPropLblHuellaIzquierda());
		pnlEncabezado.add(this.iniciarPropBtnHuellaIzquierda());
		pnlEncabezado.add(this.iniciarPropLblHuellaIzqExitoso());
		
		
		return pnlEncabezado;
	}

	@Override
	public JPanel inicializarCuerpo(Object... pArrObjParametrosForma) throws Exception {
		return null;
	}

	@Override
	public JPanel inicializarPiePagina(Object... pArrObjParametrosForma) throws Exception {
		return null;
	}
	
	/**
     * ****************************************************************
     * @metodo: iniciarPropPnlTercero
     * @descripcion: metodo utilizado para inicializar el componente 
     * 				 panel tercero 
     * @return: JPanel componente JPanel
     * @autor: Roberth Martinez Vargas
     * ****************************************************************
     */
	public JPanel iniciarPropPnlTercero()throws Exception{
		
		if(this.pnlTercero==null){
			
			this.pnlTercero = new FormaPanelTercero("pnlTercero",
													EnumEtiquetas.LBL_ETC_TERCERO,
												   this,
												   EnumDimensionesComponentes.JPN_ETC_PANEL_TERCERO,
												   new EnumDimensionesComponentes[] {EnumDimensionesComponentes.JPN_ETC_PNL_TERC_LBL, 
																					 EnumDimensionesComponentes.JPN_ETC_PNL_TERC_TIID, 
																					 EnumDimensionesComponentes.JPN_ETC_PNL_TERC_IDEN, 
																					 EnumDimensionesComponentes.JPN_ETC_PNL_TERC_DESC, 
																					 EnumDimensionesComponentes.JPN_ETC_PNL_TERC_MTO},
												   null,
												   EnumParametrosApp.DESCRIPCION_TERCERO_REMITENTE.getValorPropiedad(),
												   null);
			
		}
		
		this.castPnlTercero().getBtnMantenimiento().setEnabled(false);
		this.castPnlTercero().getBtnMantenimiento().setVisible(false);
		this.castPnlTercero().castEvaFrmTercero().habilitarComponenteCompleto(false);
		return this.pnlTercero;
	}
	
	/**
     * ****************************************************************
     * @metodo: iniciarPropLblHuellaDerecha
     * @descripcion: metodo utilizado para inicializar el componente EtiquetaUtil 
     * 				 de huella derecha
     * @return: EtiquetaUtil componente EtiquetaUtil
     * @autor: Roberth Martinez Vargas
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblHuellaDerecha() throws Exception{
		if (this.lblHuellaDerecha == null) {
			this.lblHuellaDerecha = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_ETC_HUELLA_DERECHA, 
																				"lblHuellaDerecha", 
																				EnumEtiquetas.LBL_ETC_HUELLA_DERECHA,
																				true,
																				null,
																				true);
		}

		return this.lblHuellaDerecha;
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo: iniciarPropBtnHuellaDerecha
     * @descripcion: metodo utilizado para inicializar el componente 
     * 				 BotonUtil para capturar la huella derecha
     * @return: BotonUtil componente BotonUtil
     * @autor: Roberth Martinez Vargas
     * ****************************************************************
     */	
	public BotonUtil iniciarPropBtnHuellaDerecha() throws Exception{
		if (this.btnHuellaDerecha == null) {
			this.btnHuellaDerecha = UtilComponentesGUI.getInstance().crearBoton(EnumDimensionesComponentes.BTN_ETC_HUELLA_DERECHA, 
																				"btnHuellaDerecha", 
																				EnumEtiquetas.BTN_ETC_HUELLA_DERECHA, 
																				true, 
																				true, 
																				super.getEventoForma(),  
																				null);
		}

		return this.btnHuellaDerecha;
	}
	
	/**
     * ****************************************************************
     * @metodo: iniciarPropLblHuellaDerExitoso
     * @descripcion: metodo utilizado para inicializar el componente EtiquetaUtil 
     * 				 de huella derecha exitoso
     * @return: EtiquetaUtil componente EtiquetaUtil
     * @autor: Roberth Martinez Vargas
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblHuellaDerExitoso() throws Exception{
		if (this.lblHuellaDerExitoso == null) {
			this.lblHuellaDerExitoso = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_ETC_HUELLA_DER_EXITO, 
																			   	   "lblHuellaDerExitoso", 
																			   	   null,
																			   	   false,
																			   	   null,
																			   	   true);
		}

		return this.lblHuellaDerExitoso;
	}
	
	/**
     * ****************************************************************
     * @metodo: iniciarPropLblHuellaIzquierda
     * @descripcion: metodo utilizado para inicializar el componente EtiquetaUtil 
     * 				 de huella Izquierda
     * @return: EtiquetaUtil componente EtiquetaUtil
     * @autor: Roberth Martinez Vargas
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblHuellaIzquierda() throws Exception{
		if (this.lblHuellaIzquierda == null) {
			this.lblHuellaIzquierda = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_ETC_HUELLA_IZQUIERDA, 
																			  	  "lblHuellaizquierda", 
																			  	  EnumEtiquetas.LBL_ETC_HUELLA_IZQUIERDA,
																			  	  true,
																			  	  null,
																			  	  true);
		}

		return this.lblHuellaIzquierda;
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo: iniciarPropBtnHuellaIzquierda
     * @descripcion: metodo utilizado para inicializar el componente 
     * 				 BotonUtil para capturar la huella Izquierda
     * @return: BotonUtil componente BotonUtil
     * @autor: Roberth Martinez Vargas
     * ****************************************************************
     */	
	public BotonUtil iniciarPropBtnHuellaIzquierda() throws Exception{
		if (this.btnHuellaIzquierda == null) {
			this.btnHuellaIzquierda = UtilComponentesGUI.getInstance().crearBoton(EnumDimensionesComponentes.BTN_ETC_HUELLA_IZQUIERDA, 
																			  	  "btnHuellaizquierda", 
																			  	  EnumEtiquetas.BTN_ETC_HUELLA_IZQUIERDA, 
																			  	  true, 
																			  	  true, 
																			  	  super.getEventoForma(),  
																			  	  null);
		}

		return this.btnHuellaIzquierda;
	}
	
	/**
     * ****************************************************************
     * @metodo: iniciarPropLblHuellaIzqExitoso
     * @descripcion: metodo utilizado para inicializar el componente EtiquetaUtil 
     * 				 de huella izquierda exitoso
     * @return: EtiquetaUtil componente EtiquetaUtil
     * @autor: Roberth Martinez Vargas
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblHuellaIzqExitoso() throws Exception{
		if (this.lblHuellaIzqExitoso == null) {
			this.lblHuellaIzqExitoso = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_ETC_HUELLA_IZQ_EXITO, 
																			   	   "lblHuellaIzqExitoso", 
																			   	   null,
																			   	   false,
																			   	   null,
																			   	   true);
		}

		return this.lblHuellaIzqExitoso;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo: castPnlTercero (Metodo)
  	 * @descripcion: Metodo estandar para formatear el tipo de dato 
  	 * 				 general a un tipo especifico ("Casteo"), del atributo
  	 * 				 pnlTercero
  	 * @return: FormaPanelTercero, valor especifico recuperado
  	 * @throws Exception: Controla, recupera y escala, cualquier tipo de 
  	 * 		   excepcion presentada
  	 * @autor: Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public FormaPanelTercero castPnlTercero()throws Exception{
		return (FormaPanelTercero)this.pnlTercero;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo: castEvaEnrolarTercero (Metodo)
  	 * @descripcion: Metodo estandar para formatear el tipo de dato 
  	 * 				 general a un tipo especifico ("Casteo"), del atributo
  	 * 				 super.getEventoForma()
  	 * @return: EventoFormaEnrolarTercero, valor especifico recuperado
  	 * @throws Exception: Controla, recupera y escala, cualquier tipo de 
  	 * 		   excepcion presentada
  	 * @autor: Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public EventoFormaEnrolarTercero castEvaEnrolarTercero()throws Exception{
		return (EventoFormaEnrolarTercero)super.getEventoForma();
	}

	public EtiquetaUtil getLblHuellaDerExitoso() {
		return lblHuellaDerExitoso;
	}

	public void setLblHuellaDerExitoso(EtiquetaUtil lblHuellaDerExitoso) {
		this.lblHuellaDerExitoso = lblHuellaDerExitoso;
	}

	public EtiquetaUtil getLblHuellaIzqExitoso() {
		return lblHuellaIzqExitoso;
	}

	public void setLblHuellaIzqExitoso(EtiquetaUtil lblHuellaIzqExitoso) {
		this.lblHuellaIzqExitoso = lblHuellaIzqExitoso;
	}

	public BotonUtil getBtnHuellaDerecha() {
		return btnHuellaDerecha;
	}

	public void setBtnHuellaDerecha(BotonUtil btnHuellaDerecha) {
		this.btnHuellaDerecha = btnHuellaDerecha;
	}

	public BotonUtil getBtnHuellaIzquierda() {
		return btnHuellaIzquierda;
	}

	public void setBtnHuellaIzquierda(BotonUtil btnHuellaIzquierda) {
		this.btnHuellaIzquierda = btnHuellaIzquierda;
	}

	public Tercero getTercero() {
		return tercero;
	}

	public void setTercero(Tercero tercero) {
		this.tercero = tercero;
	}

	public static void main(String[] args) {
		
		try{
	        
			TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaEnrolarTercero.class,
																   true, 
																   EnumDesplegarFormaConEventos.SI);
			Tercero objTercero = new Tercero();
	        objTercero.setIdentificacion("1234");
	        objTercero.setNombres("MARIA EUGENIA");
	        objTercero.setApellido1("REYES");
	        objTercero.setApellido2("");
	        DatoEntidad objDE = new DatoEntidad();
	        objDE.setId("4");
	        objDE.setTipoDato("4");
	        objTercero.setTipoIdentificacion(objDE);
			new FormaEnrolarTercero(null, true, objTercero);
			
		} catch (Exception e) {
			
			UtilidadesGiros.getInstance().controlExcepcion(e, 
														   null);
		}
	}

}

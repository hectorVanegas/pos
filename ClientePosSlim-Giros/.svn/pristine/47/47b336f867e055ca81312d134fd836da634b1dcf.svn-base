package co.com.codesa.clienteposslimgiros.formas.impresion;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import co.com.codesa.clienteposslim.logger.Logger;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumImagenes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.eventos.impresion.EventoFormaConfigurarTipoImpresora;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.BotonRadioUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;


/**
 * ****************************************************************.
 * @autor: Roberth Martinez Vargas
 * @fecha: 28-abr-2015
 * @descripcion: Clase para cambiar el tipo de impresora por TMU o MC
 * @copyright: Copyright  1998-2012 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class FormaConfigurarTipoImpresora extends FormaGenerica{

	private static final long serialVersionUID = 1L;
	
	private EtiquetaUtil lblImgTMU;
	private EtiquetaUtil lblImgMC;
	private BotonRadioUtil rbtTMU;
	private BotonRadioUtil rbtMC;
	private ButtonGroup btgGrupoImpresora;
	private CajaTextoUtil txtNombreImpresoraTMU;
	private CajaTextoUtil txtNombreImpresoraMC;

	public FormaConfigurarTipoImpresora(JFrame pFrmPadre, 
										boolean pBooModal) throws Exception {
		super(pFrmPadre, 
			  pBooModal);

		super.setEventoForma(new EventoFormaConfigurarTipoImpresora(this));
		
		this.inicializarForma();
	}

	@Override
	public void inicializarForma(Object... pArrObjParametrosForma) throws Exception {
		
		super.setTituloForma(EnumEtiquetas.TTL_CTI_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.FRM_CTI_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.FRM_CTI_VENTANA.getAlto());
        
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
								EnumBotonesEncabezado.BTNSALIR);
		
		super.iniciar(pArrObjParametrosForma);
	}

	@Override
	public JPanel inicializarEncabezado(Object... pArrObjParametrosForma) throws Exception {
		
		JPanel pnlEncabezado;
		
		pnlEncabezado = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_CTI_PANEL_ENCABEZADO,
																	"pnlEncabezado",
		  														 	null,
		  														 	null,
		  														 	null);
		pnlEncabezado.add(this.iniciarPropRbtMC());
		pnlEncabezado.add(this.iniciarPropTxtNombreImpresoraMC());
		pnlEncabezado.add(this.iniciarPropLblImgMC());
		pnlEncabezado.add(this.iniciarPropRbtTMU());
		pnlEncabezado.add(this.iniciarPropTxtNombreImpresoraTMU());
		pnlEncabezado.add(this.iniciarPropLblImgTMU());
		
		this.iniciarPropBtgGrupoImpresora();
		
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
     * @metodo: iniciarPropBtgGrupoImpresora
     * @descripcion: metodo utilizado para inicializar el componente 
     * 				ButtonGroup de impresora
     * @return: ButtonGroup componente ButtonGroup
     * @autor: Roberth Martinez Vargas
     * ****************************************************************
     */	
	public ButtonGroup iniciarPropBtgGrupoImpresora() throws Exception{
		
		if (this.btgGrupoImpresora == null) {
			
			this.btgGrupoImpresora = new ButtonGroup();
			this.btgGrupoImpresora.add(this.getRbtTMU());
			this.btgGrupoImpresora.add(this.getRbtMC());
			
		}
		return this.btgGrupoImpresora;
	}
	
	/**
     * ****************************************************************
     * @metodo: iniciarPropRbtTMU
     * @descripcion: metodo utilizado para inicializar el componente 
     * 				BotonRadioUtil de impresora TMU
     * @return: BotonRadioUtil componente BotonRadioUtil
     * @autor: Roberth Martinez Vargas
     * ****************************************************************
     */	
	public BotonRadioUtil iniciarPropRbtTMU() throws Exception{
		if (this.rbtTMU == null) {
			
			this.rbtTMU = UtilComponentesGUI.getInstance().crearRadioButton(EnumDimensionesComponentes.RBT_CTI_TMU, 
																			"rbtTMU", 
																			EnumEtiquetas.LBL_TIPO_IMPRESION_TIRILLA,
																			false,
																			true, 
																			true, 
																			false, 
																			null, //ControladorImagen.getImagen(EnumParametrosApp.IMG_IMPRESORA_TMU.getValorCadena()), 
																			super.getEventoForma());
			
			
		}
		return this.rbtTMU;
	}
	
	/**
     * ****************************************************************
     * @metodo: iniciarPropRbtTMC
     * @descripcion: metodo utilizado para inicializar el componente 
     * 				BotonRadioUtil de impresora MC
     * @return: BotonRadioUtil componente BotonRadioUtil
     * @autor: Roberth Martinez Vargas
     * ****************************************************************
     */	
	public BotonRadioUtil iniciarPropRbtMC() throws Exception{
		
		if (this.rbtMC == null) {
			
			this.rbtMC = UtilComponentesGUI.getInstance().crearRadioButton(EnumDimensionesComponentes.RBT_CTI_MC, 
																		   "rbtMC", 
																		   EnumEtiquetas.LBL_TIPO_IMPRESION_MEDIA_CARTA,
																		   false,
																		   true, 
																		   true, 
																		   false, 
																		   null, //ControladorImagen.getImagen(EnumParametrosApp.IMG_IMPRESORA_MC.getValorCadena()), 
																		   super.getEventoForma());
		}
		
		return this.rbtMC;
	}
	
	/**
     * ****************************************************************
     * @metodo: iniciarPropLblImgTMU
     * @descripcion: metodo utilizado para inicializar el componente 
     * 				EtiquetaUtil imagen TMU
     * @return: EtiquetaUtil componente EtiquetaUtil
     * @autor: Roberth Martinez Vargas
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblImgTMU() throws Exception{
		
		if (this.lblImgTMU == null) {
			
			this.lblImgTMU = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_CTI_TMU, 
																	 	 "rbtTMU", 
																	 	 null,
																	 	 false,
																	 	 EnumImagenes.APP_IMP_IMPRESORA_TMU.ajustarIcono(EnumDimensionesComponentes.LBL_CTI_TMU),
																	 	 true);
		}
		
		return this.lblImgTMU;
	}
	
	/**
     * ****************************************************************
     * @metodo: iniciarPropLblImgMC
     * @descripcion: metodo utilizado para inicializar el componente 
     * 				EtiquetaUtil imagen MC
     * @return: EtiquetaUtil componente EtiquetaUtil
     * @autor: Roberth Martinez Vargas
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblImgMC() throws Exception{
		
		if (this.lblImgMC == null) {
			
			this.lblImgMC = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_CTI_MC, 
																	 	"lblImgTMU", 
																	 	null,
																	 	false,
																	 	EnumImagenes.APP_IMP_IMPRESORA_MC.ajustarIcono(EnumDimensionesComponentes.LBL_CTI_MC),
																	 	true);
		}
		
		return this.lblImgMC;
	}
	
	public CajaTextoUtil iniciarPropTxtNombreImpresoraTMU()throws Exception{

		if(this.txtNombreImpresoraTMU == null){
		
			this.txtNombreImpresoraTMU = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_CTI_NOMBRE_IMPRESORA_TMU, 
																				 	 	 "txtNombreImpresoraTMU", 
																				 	 	 EnumParametrosApp.NOMBRE_IMPRESORA_NO_CONFIGURADA.getValorPropiedad(), 
																				 	 	 true, 
																				 	 	 false, 
																				 	 	 true, 
																				 	 	 super.getEventoForma(),
																				 	 	 null);
			
			this.txtNombreImpresoraTMU.setToolTipText(EnumEtiquetas.TLT_CTI_NOMBRE_IMP);
		}
		
		return this.txtNombreImpresoraTMU;
	}
	
	public CajaTextoUtil iniciarPropTxtNombreImpresoraMC()throws Exception{

		if(this.txtNombreImpresoraMC == null){
		
			this.txtNombreImpresoraMC = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_CTI_NOMBRE_IMPRESORA_MC, 
																				 	 	"txtNombreImpresoraMC", 
																				 	 	EnumParametrosApp.NOMBRE_IMPRESORA_NO_CONFIGURADA.getValorPropiedad(), 
																				 	 	true, 
																				 	 	false, 
																				 	 	true, 
																				 	 	super.getEventoForma(),
																				 	 	null);
			
			this.txtNombreImpresoraMC.setToolTipText(EnumEtiquetas.TLT_CTI_NOMBRE_IMP);
		}
		
		return this.txtNombreImpresoraMC;
	}
	
	public BotonRadioUtil getRbtTMU() {
		return rbtTMU;
	}

	public void setRbtTMU(BotonRadioUtil rbtTMU) {
		this.rbtTMU = rbtTMU;
	}

	public BotonRadioUtil getRbtMC() {
		return rbtMC;
	}

	public void setRbtMC(BotonRadioUtil rbtMC) {
		this.rbtMC = rbtMC;
	}

	public CajaTextoUtil getTxtNombreImpresoraTMU() {
		return txtNombreImpresoraTMU;
	}

	public void setTxtNombreImpresoraTMU(CajaTextoUtil txtNombreImpresoraTMU) {
		this.txtNombreImpresoraTMU = txtNombreImpresoraTMU;
	}

	public CajaTextoUtil getTxtNombreImpresoraMC() {
		return txtNombreImpresoraMC;
	}

	public void setTxtNombreImpresoraMC(CajaTextoUtil txtNombreImpresoraMC) {
		this.txtNombreImpresoraMC = txtNombreImpresoraMC;
	}

	public static void main(String[] args) throws Exception {
		
		JFrame jframe = null;
		
		try{
	        
			jframe = TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaConfigurarTipoImpresora.class,
																			true, 
																			EnumDesplegarFormaConEventos.SI);
			new FormaConfigurarTipoImpresora(jframe, true);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			Logger.getInstance().error(e.getMessage());
			
		}
	}
}

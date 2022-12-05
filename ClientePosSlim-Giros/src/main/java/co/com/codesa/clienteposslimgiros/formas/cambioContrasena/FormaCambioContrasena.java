package co.com.codesa.clienteposslimgiros.formas.cambioContrasena;

import javax.swing.JFrame;
import javax.swing.JPanel;
import co.com.codesa.clienteposslim.logger.Logger;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.cambioContrasena.EventoFormaCambioContrasena;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaClaveUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelCajaTextoProtegida;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

public class FormaCambioContrasena extends FormaGenerica {

	private static final long serialVersionUID = 1L;
	
	private EtiquetaUtil lblUsuario;
	private EtiquetaUtil lblContrasenaAnterior;
	private EtiquetaUtil lblContrasenaNueva;
	private EtiquetaUtil lblConfirmaContrasena;
	private CajaTextoUtil txtUsuario;
	private FormaPanelCajaTextoProtegida pfiContrasenaAnterior;
	private FormaPanelCajaTextoProtegida pfiContrasenaNueva;
	private FormaPanelCajaTextoProtegida pfiConfirmaContrasena;

	public FormaCambioContrasena(JFrame pFrmPadre, 
								 boolean pBooModal)throws Exception {
		super(pFrmPadre, 
			  pBooModal);
		
		super.setEventoForma(new EventoFormaCambioContrasena(this,
															 null,
															 true));
		this.inicializarForma();
	}

	public FormaCambioContrasena(FormaGenerica pFrmPadre, 
								 boolean pBooModal,
								 String pStrContrasenaActual)throws Exception {
		super(pFrmPadre, 
			  pBooModal);
		
		super.setEventoForma(new EventoFormaCambioContrasena(this,
															 pStrContrasenaActual,
															 false));
		this.inicializarForma();
	}
	
	@Override
	public void inicializarForma(Object... pArrObjParametrosForma)throws Exception {
		
		super.setTituloForma(EnumEtiquetas.TTL_CMB_CNTRSN_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.GUI_CMB_CNTRSN_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.GUI_CMB_CNTRSN_VENTANA.getAlto());
		
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
								EnumBotonesEncabezado.BTNSALIR);
		
		super.iniciar(pArrObjParametrosForma);
	}
	
	@Override
	public JPanel inicializarEncabezado(Object... pArrObjParametrosForma)throws Exception {
		return null;
	}

	@Override
	public JPanel inicializarCuerpo(Object... pArrObjParametrosForma)throws Exception {
		
		JPanel pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_CMB_CNTRSN_CUERPO,
																"pnlCuerpo",
															 	null,
															 	null,
															 	null);
		pnlCuerpo.add(this.iniciarPropLblUsuario());
		pnlCuerpo.add(this.iniciarPropTxtUsuario());
		pnlCuerpo.add(this.iniciarPropLblContrasenaAnterior());
		pnlCuerpo.add(this.iniciarPropPfiContrasenaAnterior());
		pnlCuerpo.add(this.iniciarPropLblContrasenaNueva());
		pnlCuerpo.add(this.iniciarPropPfiContrasenaNueva());
		pnlCuerpo.add(this.iniciarPropLblConfirmaContrasena());
		pnlCuerpo.add(this.iniciarPropPfiConfirmaContrasena());
		
		return pnlCuerpo;
	}

	@Override
	public JPanel inicializarPiePagina(Object... pArrObjParametrosForma)throws Exception {
		return null;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblUsuario
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblUsuario
  	 * @return EtiquetaUtil
  	 * 		   etiqueta gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblUsuario()throws Exception {
		
		if(this.lblUsuario==null){
			
			this.lblUsuario = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_CMB_CNTRSN_USUARIO, 
																	  	  "lblUsuario", 
																	  	  EnumEtiquetas.LBL_CMB_CNTRSN_USUARIO,
																	  	  true,
																	  	  null,
																	  	  true);
		}
		
		return lblUsuario;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblContrasenaAnterior
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblContrasenaAnterior
  	 * @return EtiquetaUtil
  	 * 		   etiqueta gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblContrasenaAnterior()throws Exception {
		
		if(this.lblContrasenaAnterior==null){
			
			this.lblContrasenaAnterior = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_CMB_CNTRSN_CONTRASENA_ANTERIOR, 
																	  				 "lblContrasenaAnterior", 
																	  				 EnumEtiquetas.LBL_CMB_CNTRSN_CONTRASENA_ANTERIOR,
																	  				 true,
																	  				 null,
																	  				 true);
		}
		
		return this.lblContrasenaAnterior;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblContrasenaNueva
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblContrasenaNueva
  	 * @return EtiquetaUtil
  	 * 		   etiqueta gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblContrasenaNueva()throws Exception {
		
		if(this.lblContrasenaNueva==null){
			
			this.lblContrasenaNueva = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_CMB_CNTRSN_CONTRASENA_NUEVA, 
																	  	 		  "lblContrasenaNueva", 
																	  	 		  EnumEtiquetas.LBL_CMB_CNTRSN_CONTRASENA_NUEVA,
																	  	 		  true,
																	  	 		  null,
																	  	 		  true);
		}
		
		return this.lblContrasenaNueva;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblConfirmaContrasena
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblConfirmaContrasena
  	 * @return EtiquetaUtil
  	 * 		   etiqueta gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblConfirmaContrasena()throws Exception {
		
		if(this.lblConfirmaContrasena==null){
			
			this.lblConfirmaContrasena = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_CMB_CNTRSN_CONFIRMA_CONTRASENA, 
																	  	 			 "lblConfirmaContrasena", 
																	  	 			 EnumEtiquetas.LBL_CMB_CNTRSN_CONFIRMA_CONTRASENA,
																	  	 			 true,
																	  	 			 null,
																	  	 			 true);
		}
		
		return this.lblConfirmaContrasena;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropTxtUsuario
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   txtUsuario
  	 * @return CajaTextoUtil
  	 * 		   caja de texto gestionada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaTextoUtil iniciarPropTxtUsuario()throws Exception {
		
		if(this.txtUsuario==null){
			
			this.txtUsuario = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_CMB_CNTRSN_USUARIO, 
																	 	  	  "txtUsuario", 
																	 	  	  "", 
																	 	  	  true, 
																	 	  	  false, 
																	 	  	  true,
																	 	  	  super.getEventoForma(),
																	 	  	  EnumEtiquetas.LBL_CMB_CNTRSN_USUARIO);
		}
		
		return this.txtUsuario;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropPfiContrasenaAnterior
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pfiContrasenaAnterior
  	 * @return FormaPanelCajaTextoProtegida
  	 * 		   caja protegida de texto gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaPanelCajaTextoProtegida iniciarPropPfiContrasenaAnterior()throws Exception {
		
		if(this.pfiContrasenaAnterior==null){
			
			this.pfiContrasenaAnterior = new FormaPanelCajaTextoProtegida(this,
																		  EnumDimensionesComponentes.PFI_CMB_CNTRSN_CONTRASENA_ANTERIOR,
																		  "pfiContrasenaAnterior",
																		  EnumEtiquetas.LBL_CMB_CNTRSN_CONFIRMA_CONTRASENA);
		}
		
		return this.pfiContrasenaAnterior;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropPfiContrasenaNueva
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pfiContrasenaNueva
  	 * @return FormaPanelCajaTextoProtegida
  	 * 		   caja protegida de texto gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaPanelCajaTextoProtegida iniciarPropPfiContrasenaNueva()throws Exception {
		
		if(this.pfiContrasenaNueva==null){
			
			this.pfiContrasenaNueva = new FormaPanelCajaTextoProtegida(this,
					  												   EnumDimensionesComponentes.PFI_CMB_CNTRSN_CONTRASENA_NUEVA,
					  												   "pfiContrasenaNueva",
					  												   EnumEtiquetas.LBL_CMB_CNTRSN_CONTRASENA_NUEVA);
		}
		
		return this.pfiContrasenaNueva;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropPfiConfirmaContrasena
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pfiConfirmaContrasena
  	 * @return FormaPanelCajaTextoProtegida
  	 * 		   caja protegida de texto gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaPanelCajaTextoProtegida iniciarPropPfiConfirmaContrasena()throws Exception {
		
		if(this.pfiConfirmaContrasena==null){
			
			this.pfiConfirmaContrasena = new FormaPanelCajaTextoProtegida(this,
					   													  EnumDimensionesComponentes.PFI_CMB_CNTRSN_CONFIRMA_CONTRASENA,
					   													  "pfiConfirmaContrasena",
					   													  EnumEtiquetas.LBL_CMB_CNTRSN_CONFIRMA_CONTRASENA);
		}
		
		return this.pfiConfirmaContrasena;
	}
	
	public EventoFormaCambioContrasena castEvtFrmCambioContrasena()throws Exception{
		return (EventoFormaCambioContrasena)super.getEventoForma();
	}
	
	public EtiquetaUtil getLblUsuario() {
		return lblUsuario;
	}

	public void setLblUsuario(EtiquetaUtil lblUsuario) {
		this.lblUsuario = lblUsuario;
	}

	public EtiquetaUtil getLblContrasenaAnterior() {
		return lblContrasenaAnterior;
	}

	public void setLblContrasenaAnterior(EtiquetaUtil lblContrasenaAnterior) {
		this.lblContrasenaAnterior = lblContrasenaAnterior;
	}

	public EtiquetaUtil getLblContrasenaNueva() {
		return lblContrasenaNueva;
	}

	public void setLblContrasenaNueva(EtiquetaUtil lblContrasenaNueva) {
		this.lblContrasenaNueva = lblContrasenaNueva;
	}

	public EtiquetaUtil getLblConfirmaContrasena() {
		return lblConfirmaContrasena;
	}

	public void setLblConfirmaContrasena(EtiquetaUtil lblConfirmaContrasena) {
		this.lblConfirmaContrasena = lblConfirmaContrasena;
	}

	public CajaTextoUtil getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(CajaTextoUtil txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public CajaClaveUtil getPfiContrasenaNueva() {
		return pfiContrasenaNueva.getPfiCajaClave();
	}

	public CajaClaveUtil getPfiConfirmaContrasena() {
		return pfiConfirmaContrasena.getPfiCajaClave();
	}

	public void setPfiContrasenaNueva(FormaPanelCajaTextoProtegida txtContrasenaNueva) {
		this.pfiContrasenaNueva = txtContrasenaNueva;
	}

	public void setPfiConfirmaContrasena(FormaPanelCajaTextoProtegida txtConfirmaContrasena) {
		this.pfiConfirmaContrasena = txtConfirmaContrasena;
	}

	public CajaClaveUtil getPfiContrasenaAnterior() {
		return pfiContrasenaAnterior.getPfiCajaClave();
	}

	public void setPfiContrasenaAnterior(
			FormaPanelCajaTextoProtegida pfiContrasenaAnterior) {
		this.pfiContrasenaAnterior = pfiContrasenaAnterior;
	}

	public static void main(String[] args) {
		
		JFrame jframe = null;
		
		try{
	        
			jframe = TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaCambioContrasena.class,
																			true, 
																			EnumDesplegarFormaConEventos.SI);
			new FormaCambioContrasena(jframe,
									  true);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			Logger.getInstance().error(e.getMessage());
		}
	}
}

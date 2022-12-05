package co.com.codesa.clienteposslimgiros.formas.genericas;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumImagenes;
import co.com.codesa.clienteposslimgiros.enumeraciones.gui.EnumColores;
import co.com.codesa.clienteposslimgiros.eventos.generico.EventoFormaPanelDireccion;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.BotonUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionUtil;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;


public class FormaPanelDireccion extends SeccionUtil{

	private static final long serialVersionUID = 1L;
	
	private EtiquetaUtil lblEtiqueta;
	private CajaTextoUtil txtDescripcion;
	private BotonUtil btnMantenimiento;
	private BotonUtil btnLimpiar;
	private EventoFormaPanelDireccion evaFrmPnlDireccion;
	private FormaGenerica formaPadre;
	
	public FormaPanelDireccion(EnumEtiquetas pEnmEtiquetaComponente,
							   FormaGenerica pFrmPadre,
							   EnumDimensionesComponentes pEnmDimensionPanel,
							   EnumDimensionesComponentes pEnmDimensionesComponentes[],
							   String pStrNombreComponente)throws Exception{
		
		super	(	pEnmDimensionPanel,
					pStrNombreComponente,
					BorderFactory.createEmptyBorder(),
					null,
					null
				);
		
		super.setBooAplicarTransparenciaFondo(true);
		
		this.setLayout(null);		
		
		if(pEnmDimensionPanel!=null){
		
			this.setBounds(pEnmDimensionPanel.getRectangulo());
		}
		
		this.inicializarForma(pFrmPadre,
							  pEnmEtiquetaComponente,
							  pEnmDimensionesComponentes);
		
		this.iniciarValores();
	}
	
	private void iniciarValores()throws Exception{
		
		this.evaFrmPnlDireccion.iniciarValores();
	}
	
	private void inicializarForma(FormaGenerica pFrmPadre,
								  EnumEtiquetas pEnmEtiquetaComponente,
								  EnumDimensionesComponentes pEnmDimensionesComponentes[])throws Exception{
		
		this.formaPadre = pFrmPadre;
		this.evaFrmPnlDireccion = new EventoFormaPanelDireccion(pFrmPadre,
																this); 
		
		EnumDimensionesComponentes recLblEtiqueta = null;
		EnumDimensionesComponentes recTxtDescripcion = null;
		EnumDimensionesComponentes recBtnMantenimiento = null;
		EnumDimensionesComponentes recBtnLimpiar = null;
		
		if(pEnmDimensionesComponentes!=null){
			
			try{
				
				recLblEtiqueta = pEnmDimensionesComponentes[0];
				recTxtDescripcion = pEnmDimensionesComponentes[1];
				recBtnMantenimiento = pEnmDimensionesComponentes[2];
				recBtnLimpiar = pEnmDimensionesComponentes[3];
				
			}catch(ArrayIndexOutOfBoundsException aiobe){}
		}
		
		this.add(this.iniciarPropLblEtiqueta(recLblEtiqueta,
											 pEnmEtiquetaComponente));
		
		this.add(this.iniciarPropTxtDescripcion(recTxtDescripcion));
		this.add(this.iniciarPropBtnMantenimiento(recBtnMantenimiento));
		this.add(this.iniciarPropBtnLimpiar(recBtnLimpiar));
	}
	
	public EtiquetaUtil iniciarPropLblEtiqueta(EnumDimensionesComponentes pEnmDimension,
											   EnumEtiquetas pEnmEtiquetaComponente)throws Exception{
		if(this.lblEtiqueta==null){
			
			if(pEnmDimension==null){
				pEnmDimension = EnumDimensionesComponentes.LBL_PNL_DIR_ETIQUETA;
			}
			
			if(pEnmEtiquetaComponente==null){
				pEnmEtiquetaComponente = EnumEtiquetas.LBL_PNL_DIR_ETIQUETA;
			}
			
			this.lblEtiqueta = UtilComponentesGUI.getInstance().crearLabel(pEnmDimension,
																		   "lblEtiquetaDireccion",
																		   pEnmEtiquetaComponente,
																		   true,
																		   null,
																		   true);
		}
		
		return this.lblEtiqueta;
	}
	
	public CajaTextoUtil iniciarPropTxtDescripcion(EnumDimensionesComponentes pEnmDimension)throws Exception{
		
		if(this.txtDescripcion==null){
			
			if(pEnmDimension==null){
				pEnmDimension = EnumDimensionesComponentes.TXT_PNL_DIR_DESCRIPCION;
			}
			
			this.txtDescripcion = UtilComponentesGUI.getInstance().crearTextField(pEnmDimension, 
																				  "txtDescripcionDireccion", 
																				  null, 
																				  true, 
																				  true, 
																				  true, 
																				  this.evaFrmPnlDireccion,
																				  null);
			//this.txtDescripcion.setFocusable(false);
		}
		
		return this.txtDescripcion;
	}
	
	public BotonUtil iniciarPropBtnMantenimiento(EnumDimensionesComponentes pEnmDimension)throws Exception{
		
		if(this.btnMantenimiento==null){
			
			if(pEnmDimension==null){
				pEnmDimension = EnumDimensionesComponentes.BTN_PNL_DIR_MANTENIMIENTO;
			}
			
			this.btnMantenimiento = UtilComponentesGUI.getInstance().crearBoton(pEnmDimension, 
																				"btnMantenimientoDireccion", 
																				null, 
																				true,
																				true,  
																				this.evaFrmPnlDireccion,
																				EnumImagenes.OP_MOSTRAR.ajustarIcono(pEnmDimension));
			
			this.btnMantenimiento.setToolTipText(EnumEtiquetas.TLT_PNL_DIR_BTN_MTO);
		}
		
		return this.btnMantenimiento;
	}
	
	public BotonUtil iniciarPropBtnLimpiar(EnumDimensionesComponentes pEnmDimension)throws Exception{
		
		if(this.btnLimpiar==null){
			
			if(pEnmDimension==null){
				pEnmDimension = EnumDimensionesComponentes.BTN_PNL_DIR_LIMPIAR;
			}
			
			this.btnLimpiar = UtilComponentesGUI.getInstance().crearBoton(pEnmDimension, 
																		  "btnLimpiar", 
																		  null, 
																		  true,
																		  true,  
																		  this.evaFrmPnlDireccion,
																		  EnumImagenes.OP_LIMPIAR.ajustarIcono(pEnmDimension));
			
			this.btnLimpiar.setToolTipText(EnumEtiquetas.TLT_PNL_DIR_BTN_LIMPIAR);
		}
		
		return this.btnLimpiar;
	}

	public EtiquetaUtil getLblEtiqueta() {
		return lblEtiqueta;
	}

	public void setLblEtiqueta(EtiquetaUtil lblEtiqueta) {
		this.lblEtiqueta = lblEtiqueta;
	}

	public CajaTextoUtil getTxtDescripcion() {
		return txtDescripcion;
	}

	public void setTxtDescripcion(CajaTextoUtil txtDescripcion) {
		this.txtDescripcion = txtDescripcion;
	}

	public BotonUtil getBtnMantenimiento() {
		return btnMantenimiento;
	}

	public void setBtnMantenimiento(BotonUtil btnMantenimiento) {
		this.btnMantenimiento = btnMantenimiento;
	}

	public BotonUtil getBtnLimpiar() {
		return btnLimpiar;
	}

	public void setBtnLimpiar(BotonUtil btnLimpiar) {
		this.btnLimpiar = btnLimpiar;
	}

	public EventoFormaPanelDireccion getEvaFrmPnlDireccion() {
		return evaFrmPnlDireccion;
	}

	public void setEvaFrmPnlDireccion(EventoFormaPanelDireccion evaFrmPnlDireccion) {
		this.evaFrmPnlDireccion = evaFrmPnlDireccion;
	}

	public FormaGenerica getFormaPadre() {
		return formaPadre;
	}

	public void setFormaPadre(FormaGenerica formaPadre) {
		this.formaPadre = formaPadre;
	}

	public static void main(String args[]){
		
		try {
			
			JPanel panelContenido = new JPanel ();
			panelContenido.setLayout(null);
			JDialog dialogo = new JDialog((JFrame)null,true);
			
			dialogo.setBounds(0, 0, 900, 500);
			
			FormaPanelDireccion forma;
			
			forma = new FormaPanelDireccion(null,
											null,
											EnumDimensionesComponentes.PNL_MNT_TERC_DIR_DIRECCION,
											null,
											"forma");
			
			forma.setBorder(BorderFactory.createEtchedBorder());
			
			panelContenido.add(forma);
			
			dialogo.add(panelContenido);
			
			dialogo.setVisible(true);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
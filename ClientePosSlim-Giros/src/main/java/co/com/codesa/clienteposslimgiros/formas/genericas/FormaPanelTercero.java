package co.com.codesa.clienteposslimgiros.formas.genericas;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumImagenes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.gui.EnumColores;
import co.com.codesa.clienteposslimgiros.enumeraciones.operaciones.EnumTiposOperaciones;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.eventos.generico.EventoFormaPanelTercero;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.BotonUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionUtil;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;


public class FormaPanelTercero extends SeccionUtil{

	private static final long serialVersionUID = 1L;
	
	private EtiquetaUtil lblEtiqueta;
	private CajaComboUtil cmbEntidadTiposIdentificacion;
	private CajaTextoUtil txtIdentificacion;
	private CajaTextoUtil txtDescripcion;
	private BotonUtil btnMantenimiento;
	
	private EventoAbstracto evaFrmPnlTercero;
	
	private FormaGenerica formaPadre;
	
	public FormaPanelTercero(String pStrNombreComponente,
							 EnumEtiquetas pEnmEtiquetaComponente,
							 FormaGenerica pFormaPadre,
							 EnumDimensionesComponentes pEnmDimensionPanel,
							 EnumDimensionesComponentes pEnmDimensionesComponentes[],
							 String pStrNombresComponentes[],
							 String descripcionTercero,
							 EnumTiposOperaciones pEnmTipoOperacion)throws Exception{
	
		super	(	pEnmDimensionPanel,
					pStrNombreComponente,
					BorderFactory.createEmptyBorder(),
					null,
					null
				);
		
		this.inicializarForma(pFormaPadre,
							  pEnmEtiquetaComponente,
							  pEnmDimensionesComponentes,
							  pStrNombresComponentes,
							  descripcionTercero,
							  pEnmTipoOperacion);
		
		this.iniciarValores();
		
	}
	
	private void iniciarValores()throws Exception{
		this.castEvaFrmTercero().iniciarValores();
	}
	
	private void inicializarForma(FormaGenerica pFormaPadre,
								  EnumEtiquetas pEnmEtiquetaComponente,
								  EnumDimensionesComponentes pEnmDimensiones[],
								  String pStrNombresComponentes[],
								  String descripcionTercero,
								  EnumTiposOperaciones pEnmTipoOperacion)throws Exception{
		
		super.setBooAplicarTransparenciaFondo(true);
		
		this.formaPadre = pFormaPadre;
		
		this.evaFrmPnlTercero = new EventoFormaPanelTercero(this,
														    descripcionTercero,
														    pEnmTipoOperacion); 
		
		EnumDimensionesComponentes enmDimLblTercero = null;
		EnumDimensionesComponentes enmDimCmbEntidadTiposIdentificacion = null;
		EnumDimensionesComponentes enmDimTxtIdentificacion = null;
		EnumDimensionesComponentes enmDimTxtDescripcion = null;
		EnumDimensionesComponentes enmDimBtnMantenimiento = null;
		
		String strNombreCompCmbEntidadTiposIdentificacion = null;
		String strNombreCompTxtIdentificacion = null;
		String strNombreCompTxtDescripcion = null;
		String strNombreCompBtnMantenimiento = null;
		
		if(pEnmDimensiones!=null){
			
			try{
				
				enmDimLblTercero = pEnmDimensiones[0];
				enmDimCmbEntidadTiposIdentificacion = pEnmDimensiones[1];
				enmDimTxtIdentificacion = pEnmDimensiones[2];
				enmDimTxtDescripcion = pEnmDimensiones[3];
				enmDimBtnMantenimiento = pEnmDimensiones[4];
				
			}catch(ArrayIndexOutOfBoundsException aiobe){}
		}
		
		if(pStrNombresComponentes!=null){
			
			try{
				
				strNombreCompCmbEntidadTiposIdentificacion = pStrNombresComponentes[0];
				strNombreCompTxtIdentificacion = pStrNombresComponentes[1];
				strNombreCompTxtDescripcion = pStrNombresComponentes[2];
				strNombreCompBtnMantenimiento = pStrNombresComponentes[3];
				
			}catch(ArrayIndexOutOfBoundsException aiobe){}
			
		}
		
		this.add(this.iniciarPropLblEtiqueta(enmDimLblTercero,
											 pEnmEtiquetaComponente));
		
		this.add(this.iniciarPropCmbEntidadTiposIdentificacion(enmDimCmbEntidadTiposIdentificacion,
														  	   strNombreCompCmbEntidadTiposIdentificacion));
		
		this.add(this.iniciarPropTxtIdentificacion(enmDimTxtIdentificacion,
											  	   strNombreCompTxtIdentificacion));
		
		this.add(this.iniciarPropTxtDescripcion(enmDimTxtDescripcion,
												strNombreCompTxtDescripcion));
		
		this.add(this.iniciarPropBtnMantenimiento(enmDimBtnMantenimiento,
												  strNombreCompBtnMantenimiento));
		
	}
	
	public EtiquetaUtil iniciarPropLblEtiqueta(EnumDimensionesComponentes pEnmDimension,
											   EnumEtiquetas pEnmEtiquetaComponente)throws Exception{
		
		if(this.lblEtiqueta==null){
			
			if(pEnmDimension==null){
				pEnmDimension = EnumDimensionesComponentes.LBL_PNL_TERC_TERCERO;
			}
			
			if(pEnmEtiquetaComponente==null){
				pEnmEtiquetaComponente = EnumEtiquetas.LBL_PNL_TERC_TERCERO;
			}
			
			this.lblEtiqueta = UtilComponentesGUI.getInstance().crearLabel(pEnmDimension,
																		   "lblTercero",
																		   pEnmEtiquetaComponente,
																		   true,
																		   null,
																		   true);
		}
		
		return this.lblEtiqueta;
		
	}
	
	public CajaComboUtil iniciarPropCmbEntidadTiposIdentificacion(EnumDimensionesComponentes pEnmDimension,
														 		  String pStrNombre)throws Exception{

		if(this.cmbEntidadTiposIdentificacion==null){

			if(pEnmDimension==null){
				pEnmDimension = EnumDimensionesComponentes.CMB_PNL_TERC_TIPO_IDENTIFICACION;
			}
			
			if(pStrNombre==null || 
					pStrNombre.trim().isEmpty()){
				pStrNombre = "cmbEntidadTiposIdentificacion";
			}
			
			this.cmbEntidadTiposIdentificacion = UtilComponentesGUI.getInstance().crearComboBox(pEnmDimension, 
																								pStrNombre, 
																								true, 
																								true, 
																								this.evaFrmPnlTercero,
																								EnumEtiquetas.TLT_PNL_TERC_TIPO_DOCUMENTO);
			
			this.cmbEntidadTiposIdentificacion.setToolTipText(EnumEtiquetas.TLT_PNL_TERC_TIPO_DOCUMENTO);
		}

		return this.cmbEntidadTiposIdentificacion;

	}
	
	public CajaTextoUtil iniciarPropTxtIdentificacion(EnumDimensionesComponentes pEnmDimension,
											  		  String pStrNombre)throws Exception{
		
		if(this.txtIdentificacion==null){
			
			if(pEnmDimension==null){
				pEnmDimension = EnumDimensionesComponentes.TXT_PNL_TERC_IDENTIFICACION;
			}
			
			if(pStrNombre==null || 
					pStrNombre.trim().isEmpty()){
				pStrNombre = "txtIdentificacion";
			}
			
			this.txtIdentificacion = UtilComponentesGUI.getInstance().crearTextField(pEnmDimension, 
																					 pStrNombre, 
																					 null, 
																					 true, 
																					 true, 
																					 true, 
																					 this.evaFrmPnlTercero,
																					 null);
			
			this.txtIdentificacion.setToolTipText(EnumEtiquetas.TLT_PNL_TERC_IDENTIFICACION);
		}
		
		return this.txtIdentificacion;
		
	}
	
	public CajaTextoUtil iniciarPropTxtDescripcion(EnumDimensionesComponentes pEnmDimension,
												   String pStrNombre)throws Exception{
		
		if(this.txtDescripcion==null){
			
			if(pEnmDimension==null){
				pEnmDimension = EnumDimensionesComponentes.TXT_PNL_TERC_DESCRIPCION;
			}
			
			if(pStrNombre==null || 
					pStrNombre.trim().isEmpty()){
				pStrNombre = "txtDescripcion";
			}
			
			this.txtDescripcion = UtilComponentesGUI.getInstance().crearTextField(pEnmDimension, 
																				  pStrNombre, 
																				  null, 
																				  true, 
																				  false, 
																				  true, 
																				  this.evaFrmPnlTercero,
																				  null);
			
			this.txtDescripcion.setToolTipText(EnumEtiquetas.TLT_PNL_TERC_NOMBRE);
			this.txtDescripcion.setFocusable(false);
		}
		
		return this.txtDescripcion;
		
	}
	
	public BotonUtil iniciarPropBtnMantenimiento(EnumDimensionesComponentes pEnmDimension,
											   String pStrNombre)throws Exception{
		
		if(this.btnMantenimiento==null){
			
			if(pEnmDimension==null){
				pEnmDimension = EnumDimensionesComponentes.BTN_PNL_TERC_MANTENIMIENTO;
			}
			
			if(pStrNombre==null || 
					pStrNombre.trim().isEmpty()){
				pStrNombre = "btnMantenimiento";
			}
			
			this.btnMantenimiento = UtilComponentesGUI.getInstance().crearBoton(pEnmDimension, 
																				pStrNombre, 
																				null, 
																				true,
																				true,  
																				this.evaFrmPnlTercero,
																				EnumImagenes.OP_CONSULTAR.ajustarIcono(pEnmDimension));
			
			this.btnMantenimiento.setToolTipText(EnumEtiquetas.TLT_PNL_TERC_MANTENIMIENTO);
			this.btnMantenimiento.setFocusable(true);
			this.btnMantenimiento.setBorder(BorderFactory.createEmptyBorder());
		}
		
		return this.btnMantenimiento;
		
	}

	public EventoFormaPanelTercero castEvaFrmTercero()throws Exception{
		return (EventoFormaPanelTercero)this.evaFrmPnlTercero;
	}
	
	public CajaComboUtil getCmbEntidadTiposIdentificacion() {
		return cmbEntidadTiposIdentificacion;
	}

	public void setCmbEntidadTiposIdentificacion(CajaComboUtil cmbEntidadTiposIdentificacion) {
		this.cmbEntidadTiposIdentificacion = cmbEntidadTiposIdentificacion;
	}
	
	public EtiquetaUtil getLblEtiqueta() {
		return lblEtiqueta;
	}

	public void setLblEtiqueta(EtiquetaUtil lblEtiqueta) {
		this.lblEtiqueta = lblEtiqueta;
	}

	public CajaTextoUtil getTxtIdentificacion() {
		return txtIdentificacion;
	}

	public void setTxtIdentificacion(CajaTextoUtil txtIdentificacion) {
		this.txtIdentificacion = txtIdentificacion;
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

	public EventoAbstracto getEvaEventoForma() {
		return evaFrmPnlTercero;
	}

	public void setEvaEventoForma(EventoAbstracto evaEventoForma) {
		this.evaFrmPnlTercero = evaEventoForma;
	}

	public FormaGenerica getFormaPadre() {
		return formaPadre;
	}

	public void setFormaPadre(FormaGenerica formaPadre) {
		this.formaPadre = formaPadre;
	}

	public static void main(String args[]){
		
		try {
			
			TestPruebasInternas.getInstance().iniciarPruebaInterna(null,true, EnumDesplegarFormaConEventos.NO);
			
			JPanel panelContenido = new JPanel ();
			panelContenido.setLayout(null);
			JDialog dialogo = new JDialog();
			
			dialogo.setBounds(0, 0, 900, 500);
			
			FormaPanelTercero forma;
			
			forma = new FormaPanelTercero("forma",
											null,
											null,
											EnumDimensionesComponentes.PNL_PG_TERC_TERCERO_DESTINO,
											null,
											null,
											"descripcion",
											null);
			
			forma.castEvaFrmTercero().setBooTerceroPresente(true);
			
			forma.setBorder(BorderFactory.createEtchedBorder());
			
			panelContenido.add(forma);
			
			dialogo.add(panelContenido);
			
			dialogo.setVisible(true);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
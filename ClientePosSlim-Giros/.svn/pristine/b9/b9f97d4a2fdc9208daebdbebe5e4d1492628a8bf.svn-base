package co.com.codesa.clienteposslimgiros.formas.operacioninusual.paneles;

import javax.swing.BorderFactory;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
//import co.com.codesa.clienteposslimgiros.eventos.envioRemesaInternacional.EventoFormaPanelBeneficiario;
import co.com.codesa.clienteposslimgiros.eventos.operacioninusual.EventoFormaPanelDocumento;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelGenerico;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

public class FormaPanelDocumento extends FormaPanelGenerico{


	private EtiquetaUtil lblTipoDocumento;
	
	private CajaComboUtil cmbTipoDocumento;
	
	private EtiquetaUtil lblDocumento;
	
	private CajaTextoUtil txtNumDocumento;
	
	private EtiquetaUtil lblTipoDocRemitente;

	private EventoFormaPanelDocumento evtFrmDocumento;

	public FormaPanelDocumento(FormaGenerica pFrmPadre,
			EnumDimensionesComponentes pEnmDimension,
			String pStrNombreComponente) throws Exception {

		super(pFrmPadre,
				pEnmDimension,
				pStrNombreComponente,
				BorderFactory.createEmptyBorder(),
				null,
				null);

		this.evtFrmDocumento = new EventoFormaPanelDocumento(this, 
				pFrmPadre);
		this.setEvaControlEventos(this.evtFrmDocumento);

		super.iniciar();

	}

	@Override
	protected void inicializarSeccion() throws Exception {
		
		this.add(this.iniciarPropLblTipoDocumento());
		this.add(this.iniciarPropCmbTipoDocumento());
		this.add(this.iniciarPropLblDocumento());
		this.add(this.iniciarPropTxtNumDocRemitente());
	}
	
	



	
public EtiquetaUtil iniciarPropLblTipoDocumento() throws Exception{
		
		if(this.lblTipoDocumento == null){
			
			this.lblTipoDocumento = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_OII_PNL_TIPO_DOCUMENTO, 
																					 "lbl_oii_pnl_tipo_documento", 
																					 EnumEtiquetas.LBL_OII_TIPO_DOCUMENTO, 
																					 true, 
																					 null, 
																					 true);
		}
		
		return this.lblTipoDocumento;
	}


public EtiquetaUtil iniciarPropLblDocumento() throws Exception{
	
	if(this.lblDocumento == null){
		
		this.lblDocumento = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_OII_PNL_DOCUMENTO, 
																			   "lblDocumento", 
																			   EnumEtiquetas.LBL_OII_DOCUMENTO, 
																			   true, 
																			   null, 
																			   true);
	}
	
	return this.lblDocumento;
}




public CajaComboUtil iniciarPropCmbTipoDocumento() throws Exception{
	
	if(this.cmbTipoDocumento == null){
		
		this.cmbTipoDocumento = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_OII_PNL_TIPO_DOCUMENTO,
																			 "cmbTipoDocumento",
																			 true,
																			 true,
																			 this.evtFrmDocumento,
																			 null);
	}
	
	return this.cmbTipoDocumento;
}

public CajaTextoUtil iniciarPropTxtNumDocRemitente() throws Exception{
	
	if(this.txtNumDocumento == null){
		
		this.txtNumDocumento = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_OII_PNL_DOCUMENTO, 
																			      "txtNumDocumento", 
																			      "", 
																			      true, 
																			      true, 
																			      true, 
																			      this.evtFrmDocumento, 
																			      null);
	}
	
	return this.txtNumDocumento;
}


}

package co.com.codesa.clienteposslimgiros.formas.componentesGUI;

import javax.swing.DefaultComboBoxModel;

import co.com.codesa.clienteposslim.vista.JComboBoxRound;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.gui.EnumColores;
import co.com.codesa.clienteposslimgiros.eventos.componentesGUI.EventoCompComboUtil;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.ComponenteGUI;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.ComponentesObligatorios;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.PropiedadesCombo;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

public class CajaComboUtil extends JComboBoxRound  implements ComponenteGUI, ComponentesObligatorios{
	
	private static final long serialVersionUID = -1284688714974852986L;
	
	private ObligatoriedadUtil lblObligatorio;
	
	private PropiedadesCombo propiedades;
	private EventoCompComboUtil evaCmpComboUtil;
	
	public CajaComboUtil(EnumEtiquetas pEnmEtiNombreCampo,
			   			 String ...pArrStrParametros) throws Exception{
		
		super	();
		
		this.inicializarAspectos(	EnumColores.GNRL_CONTORNO,
									pEnmEtiNombreCampo,
									pArrStrParametros
								);
	}

	private void inicializarAspectos(	EnumColores pEnmColContorno,
										EnumEtiquetas pEnmEtiNombreCampo,
  			 							String ...pArrStrParametros
									)	throws	Exception
	{
		super.setColorContorno(pEnmColContorno.getColColor());
	
		this.setOpaque(false);
		
		this.evaCmpComboUtil = new EventoCompComboUtil(this);
		this.propiedades = this.evaCmpComboUtil;
		
		this.lblObligatorio = new ObligatoriedadUtil(pEnmEtiNombreCampo,
													 pArrStrParametros);
	}
	
	@Override
	public ObligatoriedadUtil getLblObligatorio() {
		return lblObligatorio;
	}

	@Override
	public void setLblObligatorio(ObligatoriedadUtil lblObligatorio) {
		this.lblObligatorio = lblObligatorio;
	}
	
	@Override
	public void setVisible(boolean pBooVisible) {
		
		super.setVisible(pBooVisible);
		
		UtilComponentesGUI.getInstance().activaObligatoriedad(this, 
														  this.lblObligatorio);
	}
	
	@Override
	public void setEnabled(boolean pBooEnabled) {
		
		super.setEnabled(pBooEnabled);
		
		UtilComponentesGUI.getInstance().activaObligatoriedad(this, 
				  										  this.lblObligatorio);
	}
	
	@Override
	public void setEditable(boolean pBooEditable) {
		
		super.setEditable(pBooEditable);
		
		UtilComponentesGUI.getInstance().activaObligatoriedad(this, 
				  										  this.lblObligatorio);
	}
	
	@Override
	public void setValorContenido(Object pObjeto)throws Exception{
	
		this.setSelectedItem(pObjeto);
	}
	
	@Override
	public String toString() {
		
		String strResultado;
		
		if(this.getSelectedItem()!=null){
			strResultado = this.getSelectedItem().toString();
		}else{
			strResultado = null;
		}
		
		return strResultado;
	}
	
	public PropiedadesCombo getPropiedades() {
		return propiedades;
	}
	
	@Deprecated
	@Override
	public void setToolTipText(String text) {
		super.setToolTipText(text);
	}
	
	public DefaultComboBoxModel getDefaultComboBoxModel(){
		return (DefaultComboBoxModel)this.getModel();
	}
	
	@Override
	public void setToolTipText(EnumEtiquetas pEnmEtiquetas,
							   String ...pArrStrParametros){
		
		UtilidadesGiros.getInstance().setToolTipText(this, 
				 									 pEnmEtiquetas, 
				 									 pArrStrParametros);
	}
}

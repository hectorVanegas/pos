package co.com.codesa.clienteposslimgiros.formas.componentesGUI;

import javax.swing.Icon;
import javax.swing.JRadioButton;

import co.com.codesa.clienteposslim.general.InformacionSession;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.eventos.componentesGUI.EventoCompBanderaUtil;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.ComponenteGUI;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.ComponentesObligatorios;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.PropiedadesBandera;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

public class BotonRadioUtil extends JRadioButton  implements ComponenteGUI, 
														  	 ComponentesObligatorios{
	
	private static final long serialVersionUID = -1284688714974852986L;
	
	private ObligatoriedadUtil lblObligatorio;
	
	private PropiedadesBandera propiedades;
	private EventoCompBanderaUtil evaCmpBanderaUtil;
	
	public BotonRadioUtil(EnumDimensionesComponentes pEnmDimension,
			  			  String pStrNombre, 
			  			  EnumEtiquetas pEnmEtiqueta, 
						  boolean pBooAdicionaDosPuntos,
			  			  boolean pBooHabilitado,
			  			  boolean pBooVisible, 
			  			  boolean pBooSeleccionado, 
			  			  Icon pIcono, 
			  			  EventoAbstracto pEvaFuncionalidad) throws Exception{
		
		super();
		
		this.inicializarComponente(pEnmDimension,
								   pStrNombre,
								   pEnmEtiqueta,
								   pBooAdicionaDosPuntos,
								   pBooHabilitado,
								   pBooVisible, 
								   pBooSeleccionado, 
								   pEvaFuncionalidad,
								   pIcono);
		
		this.evaCmpBanderaUtil = new EventoCompBanderaUtil(this);
		this.propiedades = this.evaCmpBanderaUtil;
		this.addKeyListener(this.evaCmpBanderaUtil);
		
		this.lblObligatorio = new ObligatoriedadUtil(null);
	}
	
	private void inicializarComponente(EnumDimensionesComponentes pEnmDimension,
			  						   String pStrNombre,
			  						   EnumEtiquetas pEnmEtiqueta, 
			  						   boolean pBooAdicionaDosPuntos,
			  						   boolean pBooHabilitado,
			  						   boolean pBooVisible, 
			  						   boolean pBooSeleccionado, 
			  						   EventoAbstracto pEvaFuncionalidad,
			  						   Icon pIcono)throws Exception{
		
		String strEtiqueta;
		
		strEtiqueta = pEnmEtiqueta==null?"":pEnmEtiqueta.getValor(pBooAdicionaDosPuntos);
		
		this.setText(strEtiqueta);
		
		this.setOpaque(false);
		
		if(pEnmDimension!=null){
		
			this.setBounds(pEnmDimension.getRectangulo());
		}
		
		this.setFont(InformacionSession.TIPO_LETRA_ETIQUETA_PEQUENA);
		this.setName(pStrNombre);
		this.setEnabled(pBooHabilitado);
		this.setVisible(pBooVisible);
		this.setSelected(pBooSeleccionado);
		
		if(pIcono != null){
			
			this.setIcon(pIcono);
		}
		
		if (pEvaFuncionalidad != null){
			
			this.addKeyListener(pEvaFuncionalidad);
			this.addItemListener(pEvaFuncionalidad);
		}
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
	public void setValorContenido(Object pObjeto)throws Exception{
	
		if(pObjeto!=null &&
				pObjeto instanceof Boolean){
		
			super.setSelected((Boolean)pObjeto);
		}
	}
	
	@Override
	public String toString() {
		return String.valueOf(super.isSelected());
	}
	
	public PropiedadesBandera getPropiedades() {
		return propiedades;
	}
	
	@Deprecated
	@Override
	public void setToolTipText(String text) {
		super.setToolTipText(text);
	}
	
	@Override
	public void setToolTipText(EnumEtiquetas pEnmEtiquetas,
							   String ...pArrStrParametros){
		
		UtilidadesGiros.getInstance().setToolTipText(this, 
				 									 pEnmEtiquetas, 
				 									 pArrStrParametros);
	}
}

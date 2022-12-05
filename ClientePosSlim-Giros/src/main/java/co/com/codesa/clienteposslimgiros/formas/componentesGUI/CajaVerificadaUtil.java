package co.com.codesa.clienteposslimgiros.formas.componentesGUI;

import java.awt.Font;

import javax.swing.JCheckBox;

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

public class CajaVerificadaUtil extends JCheckBox  implements ComponenteGUI, 
															  ComponentesObligatorios{
	
	private static final long serialVersionUID = -1284688714974852986L;
	
	private ObligatoriedadUtil lblObligatorio;
	
	private PropiedadesBandera propiedades;
	private EventoCompBanderaUtil evaCmpBanderaUtil;
	
	public CajaVerificadaUtil(EnumDimensionesComponentes pEnmDimension,
							  String pStrNombre,
							  EnumEtiquetas pEnmEtiqueta,
							  boolean pBooAdicionaDosPuntos,
							  boolean pBooHabilitado,
							  boolean pBooVisible, 
							  boolean pBooSeleccionado, 
							  EventoAbstracto pEvaFuncionalidad,
							  int pIntPosicionEtiqueta, 
							  boolean pBooEtiquetaNegrita) throws Exception{
		
		super();
		
		this.inicializarComponente(pEnmDimension,
								   pStrNombre,
								   pEnmEtiqueta,
								   pBooAdicionaDosPuntos,
								   pBooHabilitado,
								   pBooVisible, 
								   pBooSeleccionado, 
								   pEvaFuncionalidad,
								   pIntPosicionEtiqueta, 
								   pBooEtiquetaNegrita);
		
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
			  						   int pIntPosicionEtiqueta, 
			  						   boolean pBooEtiquetaNegrita)throws Exception{
		
		String strEtiqueta;
		
		strEtiqueta = pEnmEtiqueta==null?"":pEnmEtiqueta.getValor(pBooAdicionaDosPuntos);
		
		this.setText(strEtiqueta);
		
		this.setOpaque(false);
		
		if(pEnmDimension!=null){
		
			this.setBounds(pEnmDimension.getRectangulo());
		}
		
		this.setFont(InformacionSession.TIPO_LETRA_CAJA_TEXTO);
		this.setName(pStrNombre);
		this.setEnabled(pBooHabilitado);
		this.setVisible(pBooVisible);
		this.setSelected(pBooSeleccionado);
		this.setHorizontalTextPosition(pIntPosicionEtiqueta);

		if (pBooEtiquetaNegrita) {
			
			this.setFont(this.getFont().deriveFont(Font.BOLD,13));
			//this.setFont(new Font("Arial", Font.BOLD, 13));
			
		} else {
			
			//this.setFont(new Font("Arial", Font.PLAIN, 13));
			this.setFont(this.getFont().deriveFont(Font.PLAIN,13));
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
	};
	
	@Override
	public void setToolTipText(EnumEtiquetas pEnmEtiquetas,
							   String ...pArrStrParametros){
		
		UtilidadesGiros.getInstance().setToolTipText(this, 
				 									 pEnmEtiquetas, 
				 									 pArrStrParametros);
	}
}

package co.com.codesa.clienteposslimgiros.formas.componentesGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.border.BevelBorder;

import co.com.codesa.clienteposslim.vista.JDateChooserRound;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumImagenes;
import co.com.codesa.clienteposslimgiros.enumeraciones.gui.EnumColores;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.ComponenteGUI;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.ComponentesObligatorios;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 17-abr-2015 
 * @clase CajaFechaUtil
 * 		  Clase encargada de emular el comportamiento de un JDateChooser
 * 		  adicionando una serie de aspectos y/o utilidades de interes
 * @copyright Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class CajaFechaUtil extends JDateChooserRound implements ComponenteGUI, ComponentesObligatorios {
	
	private static final long serialVersionUID = -1284688714974852986L;
	
	private SimpleDateFormat sdfFormato;
	
	private ObligatoriedadUtil lblObligatorio;
	
	/**
  	 * ****************************************************************.
  	 * @metodo CajaIncrementoUtil
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de sus acciones
  	 * @param pEnmEtiNombreCampo
  	 * 		  Etiqueta que identifica el nombre del componente dentro de 
  	 * 		  la funcionalidad en cuestion
  	 * @param pArrStrParametros
  	 * 		  Listado de parametros que alimentan la etiqueta que 	
  	 * 		  identifica el nombre del componente
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaFechaUtil(EnumEtiquetas pEnmEtiNombreCampo,
			   			 String ...pArrStrParametros) throws Exception{
		
		super	();
		
		this.lblObligatorio = new ObligatoriedadUtil(pEnmEtiNombreCampo,
													 pArrStrParametros);
		
		super.setColorContorno(EnumColores.GNRL_CONTORNO.getColColor());
		super.setDateFormatString(UtilidadGiros.getInstancia().getFORMATEADOR_FECHA_SLASH().toPattern());
		
		UtilidadesGiros.getInstance().setTransferHandlerComponet(this);
	}
	
	public SimpleDateFormat getSdfFormato() {
		
		if(this.sdfFormato == null){
			this.sdfFormato = new SimpleDateFormat(this.getDateFormatString());
		}
		
		return this.sdfFormato;
	}

	public void setSdfFormato(SimpleDateFormat sdfFormato){
		
		this.sdfFormato = sdfFormato;
		super.setDateFormatString(this.sdfFormato.toPattern());
	}
	
	@Override
	public void setDateFormatString(String pStrFormato){
		
		this.getSdfFormato().applyPattern(pStrFormato);
		super.setDateFormatString(pStrFormato);
	}
	
	@Override
	public Date getDate(){
		
		Date datFecha = null;
		
		if(super.getDate()!=null){
			
			try {
				datFecha = this.sdfFormato.parse(this.toString());
			} catch (ParseException e) {}
		}
		
		return datFecha;
	}
	
	@Override
	public String toString(){
		
		String strRespuesta = null;
		
		if(super.getDate()!=null){
			strRespuesta = this.sdfFormato.format(super.getDate()); 
		}
		
		return strRespuesta; 
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
	
		this.setDate((Date)pObjeto);
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

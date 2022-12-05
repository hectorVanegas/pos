package co.com.codesa.clienteposslimgiros.formas.componentesGUI;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.*;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumImagenes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.eventos.componentesGUI.EventoCompEtiquetaUtil;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.ComponenteGUI;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.PropiedadesEtiqueta;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.utilidades.html.UtilHtml;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 10-abr-2015 
 * @clase AreaTextoUtil
 * 		  Clase encargada de emular el comportamiento de un JTextField
 * 		  adicionando una serie de aspectos y/o utilidades de interes
 * @copyright Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class EtiquetaUtil extends JLabel implements ComponenteGUI{
	
	private static final long serialVersionUID = -1284688714974852986L;
	
	private EventoCompEtiquetaUtil evaCmpEtiquetaUtil;
	
	private PropiedadesEtiqueta propiedades;
	
	public EtiquetaUtil() throws Exception{
		
		super();
		this.evaCmpEtiquetaUtil = new EventoCompEtiquetaUtil(this);
		this.propiedades = this.evaCmpEtiquetaUtil;
	}
	
	public EtiquetaUtil(String pStrTexto,
						int pIntPosicionHorizontal)throws Exception{
		
		super(pStrTexto,
			  pIntPosicionHorizontal);
		
		this.evaCmpEtiquetaUtil = new EventoCompEtiquetaUtil(this);
		this.propiedades = this.evaCmpEtiquetaUtil; 
	}
	
	public void setTextOriginal(String pStrTexto,
								boolean pBooGenerarRemover){
		
		if(pBooGenerarRemover){
			
			pStrTexto = UtilHtml.generarEstructuraHtml(pStrTexto,
													   this.getHorizontalAlignment());
			
		}else{
			
			pStrTexto = UtilHtml.removerEstructuraHtml(pStrTexto);
		}
		
		super.setText(pStrTexto);
	}
	
	@Override
	public void setText(String pStrTexto) {
		
		if(this.evaCmpEtiquetaUtil != null && 
				this.evaCmpEtiquetaUtil.isBooActivarDesplazamientoAutomatico()){
			
			try{
				
				this.evaCmpEtiquetaUtil.detenerDesplazamientoAutomatico();
				this.evaCmpEtiquetaUtil.setStrTextoDesplazado(pStrTexto);
				this.evaCmpEtiquetaUtil.activarDesplazamientoAutomatico();
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			this.setTextOriginal(pStrTexto,
					 			 false);
			
		}else{
			
			this.setTextOriginal(pStrTexto,
								 true);
		}
	}
	
	public String getTextoOriginal(){
		
		String strResultado;
		
		if(this.evaCmpEtiquetaUtil != null && 
				this.evaCmpEtiquetaUtil.isBooActivarDesplazamientoAutomatico()){
			
			strResultado = this.evaCmpEtiquetaUtil.getStrTextoOriginal();
			
		}
		
		strResultado = UtilHtml.removerEstructuraHtml(super.getText());
		
		return strResultado;
	}

	@Override
	public void setValorContenido(Object pObjeto)throws Exception{
	
		this.setText(pObjeto.toString());
	}
	
	@Override
	public void setHorizontalAlignment(int pIntConstantePosicion) {
		
		//String strTexto;
		
		super.setHorizontalAlignment(pIntConstantePosicion);
		
		/*strTexto = this.calcularHtmlHorizontalAlignment(this.getText(),
											 			pIntConstantePosicion);*/
		
		this.setText(this.getText());
	}
	
	@Deprecated
	/**
	 * Este metodo no es el ideal para recuperar el contenido de la etiqueta, debido a que su contenido tiene
	 * consideraciones <html>, que trabajan de manera transparente, por tal razon es necesario recuperar 
	 * el contenido del metodo getTextoOriginal(), por el contrario este metodo getText, si es de uso 
	 * importante dentro de la decoracion EtiquetaUtil
	 */
	
	@Override
	public String getText() {
		
		return super.getText();
	}
	
	public PropiedadesEtiqueta getPropiedades() {
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
	
	public	void	setImg	(	EnumImagenes pEnmImagen,
								Dimension	pObjDimension
							)	throws	Exception
	{
		if	(	pObjDimension	==	null	)
		{
			pObjDimension	=	this.getSize();
		}
		
		this.setIcon(pEnmImagen.ajustarIcono(pObjDimension));
	}
	
	public	void	setImg	(	EnumImagenes pEnmImagen,
								EnumDimensionesComponentes	pEnmDimension
							)	throws	Exception
	{
		Dimension objDimension;
		
		if	(	pEnmDimension	==	null	)
		{
			objDimension	=	this.getSize();
			
		}	else	{
			
			objDimension	=	pEnmDimension.getRectangulo().getSize();
		}
		
		this.setImg(pEnmImagen, objDimension);
	}
}

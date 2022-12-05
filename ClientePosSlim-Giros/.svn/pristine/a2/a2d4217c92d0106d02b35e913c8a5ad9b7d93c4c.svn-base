package co.com.codesa.clienteposslimgiros.formas.componentesGUI;


import java.awt.Rectangle;
import java.util.Arrays;

import javax.swing.SwingConstants;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;

public class ObligatoriedadUtil extends EtiquetaUtil{
	
	private static final long serialVersionUID = -1284688714974852986L;
	
	private EnumEtiquetas enmEtiNombreCampo;
	
	private String arrStrParametrosNombreCampo[];
	
	private boolean booObligatorio;
	
	public ObligatoriedadUtil(EnumEtiquetas pEnmEtiNombreCampo,
							  String ...pArrStrParametros)throws Exception{
		
		super("",
		      SwingConstants.TRAILING);
		
		super.setVerticalAlignment(SwingConstants.TOP);
		
		this.setEnmEtiNombreCampo(pEnmEtiNombreCampo);
		this.setArrStrParametrosNombreCampo(pArrStrParametros);
		
	}
	
	public void aplicarObligatoriedad(boolean pBooObligatorio){
	
		if(this.booObligatorio != pBooObligatorio){
		
			if(pBooObligatorio){
				
				super.setText("*");
				super.setToolTipText(EnumEtiquetas.TLP_CAMPO_OBLIGATORIO);
				
			}else{
				
				super.setText("");
				super.setToolTipText((EnumEtiquetas)null);
			}
			
			this.booObligatorio = pBooObligatorio;
		}
	}
	
	@Override
	public void setBounds(Rectangle r) {
		
		if(r!=null){
			super.setBounds(r);
		}else{
			return;
		}
	}
	
	@Override
	public void setBounds(int x, 
						  int y, 
						  int width, 
						  int height) {
		
		/*if(EnumParametrosPruebas.PRU_INT_ACTIVA_POSICIONAMIENTO_ABSOLUTO.getPropiedad().equalsIgnoreCase("S")){
		
			x = x-6;
			width = 10;
			height = 20;
			
		}else{*/
			
			x = x-12;
			width = 10;
			height = 10;
		//}
		
		
		super.setBounds(x, 
						y, 
						width, 
						height);
	}

	public boolean validaObligatoriedad() {
		
		return this.isVisible() 
					&& this.getTextoOriginal().trim().equals("*");
	}
	
	public String obtenerNombreCampo()throws Exception{
		
		String strNombreCampo;
		
		if(this.getEnmEtiNombreCampo() == null){
			
			strNombreCampo = null;
			
		}else{
			
			strNombreCampo = this.getEnmEtiNombreCampo().getValor(false, 
	 				  											  this.getArrStrParametrosNombreCampo());
			
			strNombreCampo	=	strNombreCampo.replaceAll("'", "");
		}
		
		return strNombreCampo;
	}

	public EnumEtiquetas getEnmEtiNombreCampo() {
		return enmEtiNombreCampo;
	}

	public void setEnmEtiNombreCampo(EnumEtiquetas enmEtiNombreCampo) {
		this.enmEtiNombreCampo = enmEtiNombreCampo;
	}

	public String[] getArrStrParametrosNombreCampo() {
		
		if	(	this.arrStrParametrosNombreCampo	!=	null	)
		{
			for	(	int i=0	;	i<this.arrStrParametrosNombreCampo.length	;	i++)
			{
				this.arrStrParametrosNombreCampo[i]	=	this.arrStrParametrosNombreCampo[i].toLowerCase();
			}
		}
		
		return arrStrParametrosNombreCampo;
	}

	public void setArrStrParametrosNombreCampo(String[] arrStrParametrosNombreCampo) {
		this.arrStrParametrosNombreCampo = arrStrParametrosNombreCampo;
	}
}

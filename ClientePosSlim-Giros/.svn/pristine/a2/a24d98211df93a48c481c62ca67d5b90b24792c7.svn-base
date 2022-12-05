package co.com.codesa.clienteposslimgiros.formas.componentesGUI;

import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Window;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import co.com.codesa.clienteposslim.general.InformacionSession;
import co.com.codesa.clienteposslim.vista.JScrollPaneRound;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.gui.EnumColores;
import co.com.codesa.clienteposslimgiros.eventos.componentesGUI.EventoCompSeccionDesplazableUtil;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.ComponenteGUI;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.ComponentesObligatorios;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.PropiedadesSeccionDesplazable;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;


public class SeccionDesplazableUtil extends JScrollPaneRound implements ComponenteGUI/*, ComponentesObligatorios*/{
	
	private static final long serialVersionUID = -1284688714974852986L;
	
	//private Image imgImagen = null;
	//private Rectangle objRectangle;
	private PropiedadesSeccionDesplazable propiedadesSeccionDesplazable;
	
	public SeccionDesplazableUtil(EnumDimensionesComponentes pEnmDimension,
			  		   			  String pStrNombreComponente,
			  		   			  Border pBorde,
			  		   			  Integer pIntJustificacionTitulo,
			  		   			  EnumEtiquetas pEnmTitulo,
			  		   			  String ...pArrStrParametrosTitulo) throws Exception{
		super();
		
		this.inicializarAspectos(pEnmDimension,
								 pStrNombreComponente,
								 pBorde,
								 EnumColores.PNL_FONDO,
								 EnumColores.PNL_FONDO_DEGRADADO,
								 EnumColores.GNRL_CONTORNO,
								 pIntJustificacionTitulo,
								 pEnmTitulo,
								 pArrStrParametrosTitulo);
	}
	
	private void inicializarAspectos(EnumDimensionesComponentes pEnmDimension,
	  		   						 String pStrNombreComponente,
	  		   						 Border pBorde,
	  		   						 EnumColores pEnmColFondo,
	  		   						 EnumColores pEnmColFondoDegradado,
	  		   						 EnumColores pEnmColContorno,
	  		   						 Integer pIntJustificacionTitulo,
	  		   						 EnumEtiquetas pEnmTitulo,
	  		   						 String ...pArrStrParametrosTitulo)throws Exception{
		
		this.propiedadesSeccionDesplazable = new EventoCompSeccionDesplazableUtil(this);

		this.setOpaque(false);
		this.getViewport().setOpaque(false);
		this.setName(pStrNombreComponente);
		
		super.setColorContorno(pEnmColContorno.getColColor());
		super.setColorPrimario(pEnmColFondo.getColColor());
		super.setColorSecundario(pEnmColFondoDegradado.getColColor());
		
		super.setBooAplicarTransparenciaFondo(true);
		
		if(pBorde==null){
			
			pBorde=BorderFactory.createEtchedBorder();
			//pBorde=BorderFactory.createEmptyBorder();
		}
		
		if(pEnmTitulo==null){
			
			this.setBorder(pBorde);
			
		}else{
		
			if(pIntJustificacionTitulo == null){
				pIntJustificacionTitulo = TitledBorder.CENTER;
			}
			
			this.setBorder(BorderFactory.createTitledBorder(pBorde, 
															pEnmTitulo.getValor(false, 
																				pArrStrParametrosTitulo),
															pIntJustificacionTitulo, 
															TitledBorder.DEFAULT_POSITION, 
															InformacionSession.TIPO_LETRA_ETIQUETA_PEQUENA));
		}

		if(pEnmDimension!=null){
			
			this.setBounds(pEnmDimension.getRectangulo());
			
			if	(	pEnmDimension.getIntArcoX()	>=	0	)
			{
				super.setArcw(pEnmDimension.getIntArcoX());
			}
			
			if	(	pEnmDimension.getIntArcoY()	>=	0	)
			{
				super.setArch(pEnmDimension.getIntArcoY());
			}
		}		
	}
	
	@Override
	public Component add(Component comp) {
		
		EtiquetaUtil lblObligatorio;
		
		if(comp instanceof ComponentesObligatorios){
			
			lblObligatorio = ((ComponentesObligatorios)comp).getLblObligatorio();
			
			if(lblObligatorio != null){
				this.add(lblObligatorio);
			}
		}
		
		return super.add(comp);
	}
	
	/*@Override
	public void paintComponent(Graphics g){
		
		if(this.imgImagen != null){
		
			if(this.objRectangle!=null){
				
				g.drawImage(this.imgImagen, 
							(int)this.objRectangle.getX(),
							(int)this.objRectangle.getY(), 
							(int)this.objRectangle.getWidth(), 
							(int)this.objRectangle.getHeight(), 
	        				null);
				
			}else{

				g.drawImage(this.imgImagen, 
		        			0,
		        			0, 
		        			super.getWidth(), 
		        			super.getHeight(), 
		        			null);
			}
			
		}else{
		
			super.paintComponent(g);
		}
    }*/
	
	@Override
	public void setBounds(Rectangle r) {
		
		super.setBounds(r);
		this.setPreferredSize(r.getSize());
	};

	/*public Image getImgImagen() {
		return imgImagen;
	}

	public void setImgImagen(Image imgImagen,
							 Window pWinVentana,
							 Rectangle pObjRectangle) {
		
		this.imgImagen = imgImagen;
		this.objRectangle = pObjRectangle;
		pWinVentana.repaint();
	}*/

	@Override
	public void setValorContenido(Object pObjeto)throws Exception{}
	
	public PropiedadesSeccionDesplazable getPropiedadesSeccionDesplazable() {
		return propiedadesSeccionDesplazable;
	}
	
	@Override
	public void setViewportView(Component pObjComponente) {
		
		try{
		
			UtilComponentesGUI.getInstance().validaAdicionComponenteContenedor(pObjComponente,
					   														   this);
		}catch(Exception e){
		
			UtilidadesGiros.getInstance().controlExcepcion(e, 
					   									   null);
		}
		
		super.setViewportView(pObjComponente);
	};
	
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
	
	@Override
	public void setBorder(Border pBorder) 
	{
		if	(	pBorder	instanceof	TitledBorder	)
		{
			((TitledBorder) pBorder).setTitleFont(InformacionSession.TIPO_LETRA_ETIQUETA_PEQUENA);
		}
		
		super.setBorder(pBorder);
	}
}

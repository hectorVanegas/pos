package co.com.codesa.clienteposslimgiros.formas.componentesGUI;

import java.awt.Component;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import co.com.codesa.clienteposslim.general.InformacionSession;
import co.com.codesa.clienteposslim.vista.JpanelRound;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.gui.EnumColores;
import co.com.codesa.clienteposslimgiros.eventos.componentesGUI.EventoCompSeccionUtil;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.ComponenteGUI;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.ComponentesObligatorios;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.PropiedadesSeccion;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

public class SeccionUtil extends JpanelRound implements ComponenteGUI{
	
	private static final long serialVersionUID = -1284688714974852986L;
	
	private PropiedadesSeccion propiedadesSeccion;
	
	public SeccionUtil	(	EnumDimensionesComponentes pEnmDimension,
			  		   		String pStrNombreComponente,
			  		   		Border pBorde,
			  		   		Integer pIntJustificacionTitulo,
			  		   		EnumEtiquetas pEnmTitulo,
			  		   		String ...pArrStrParametrosTitulo
			  		   	)	throws	Exception
	{
		super	();
		
		this.inicializarAspectos(	pEnmDimension,
								 	pStrNombreComponente,
								 	pBorde,
								 	EnumColores.PNL_FONDO,
									EnumColores.PNL_FONDO_DEGRADADO,
									EnumColores.GNRL_CONTORNO,
					  		   		pIntJustificacionTitulo,
					  		   		pEnmTitulo,
					  		   		pArrStrParametrosTitulo
					  		   	);
	}
	
	private void inicializarAspectos(	EnumDimensionesComponentes pEnmDimension,
	  		   						 	String pStrNombreComponente,
	  		   						 	Border pBorde,
	  		   						 	EnumColores pEnmColFondo,
	  		   						 	EnumColores pEnmColFondoDegradado,
	  		   						 	EnumColores pEnmColContorno,
	  		   						 	Integer pIntJustificacionTitulo,
	  		   						 	EnumEtiquetas pEnmTitulo,
	  		   						 	String ...pArrStrParametrosTitulo
	  		   						 )	throws	Exception
	{
		
		this.propiedadesSeccion = new EventoCompSeccionUtil(this);
		
		this.setLayout(null);

		this.setOpaque(false);
		this.setName(pStrNombreComponente);
		
		super.setColorContorno(pEnmColContorno.getColColor());
		super.setColorPrimario(pEnmColFondo.getColColor());
		super.setColorSecundario(pEnmColFondoDegradado.getColColor());
		
		if(pBorde==null){
			
			pBorde=BorderFactory.createEtchedBorder();
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
	public Component add(Component pCmpComponente) {
		
		EtiquetaUtil lblObligatorio = null;
		JScrollPane	scpComp;
		Component cmpValidaObligatorio;
		
		cmpValidaObligatorio	=	pCmpComponente;
		
		if(pCmpComponente instanceof JScrollPane)
		{
			scpComp	=	((JScrollPane)pCmpComponente);
			
			if	(	scpComp.getViewport().getComponentCount()	==	1	)
			{
				cmpValidaObligatorio	=	scpComp.getViewport().getComponents()[0];
				
				if	(	cmpValidaObligatorio	instanceof	ComponentesObligatorios	)
				{
					lblObligatorio = ((ComponentesObligatorios)cmpValidaObligatorio).getLblObligatorio();
					lblObligatorio.setBounds(pCmpComponente.getBounds());
				}
			}
		}	else	if	(	cmpValidaObligatorio	instanceof	ComponentesObligatorios	)
		{
			lblObligatorio = ((ComponentesObligatorios)cmpValidaObligatorio).getLblObligatorio();
		}
		
		if(lblObligatorio != null){
			this.add(lblObligatorio);
		}
		
		try{
		
			UtilComponentesGUI.getInstance().validaAdicionComponenteContenedor(pCmpComponente, 
					   														   this);
		}catch(Exception e){
			
			UtilidadesGiros.getInstance().controlExcepcion(e, 
														   null);
		}
		
		return super.add(pCmpComponente);
	}
	
	@Override
	public void setBounds(Rectangle r) {
		
		super.setBounds(r);
		this.setPreferredSize(r.getSize());
	};

	@Override
	public void setValorContenido(Object pObjeto)throws Exception{}
	
	public PropiedadesSeccion getPropiedadesSeccion() {
		return propiedadesSeccion;
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

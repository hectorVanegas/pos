package co.com.codesa.clienteposslimgiros.formas.componentesGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import co.com.codesa.clienteposslim.general.InformacionSession;
import co.com.codesa.clienteposslim.vista.JButtonRound;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumImagenes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.gui.EnumColores;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.ComponenteGUI;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

/**
 * ********************************************************************
 * @class	BotonUtil
 *		   	Clase que implementa el patron decorator, que permite 
 *			personalizar, redefinir e incrementar, los comportamientos 
 *			y atributos de componentes propios de Java, enfocandose 
 *			principalmente en los componentes graficos de GUI
 * @author 	hector.cuenca
 * @date   	3/11/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class BotonUtil extends JButtonRound implements ComponenteGUI{
	
	/**
	 * @variable serialVersionUID
	 * 			 Variable serialVersionUID
	 */
	private static final long serialVersionUID = -1284688714974852986L;
	
	/**
	 * ********************************************************************
	 * @method 	BotonUtil
	 * 		   	Metodo constructor sobre-escrito que tambien permite materializar 
	 * 			un objeto de esta clase, recibiendo los argumentos principales 
	 * 			requeridos, asi como tambien, los adicionales para contemplar 
	 * 			estilos personalizados que delimitan colores, formas entre otros
	 * 			aspectos graficos
	 * @param 	pEnmDimension
	 * 			Constante de enumeracion que especifica la dimension a la 
	 * 			cual estara sometida el componente grafico en cuestion
	 * @param 	pStrNombre
	 * 			Nombre con el cual se identifica el componente grafico en 
	 * 			cuestion
	 * @param 	pEnmEtiqueta
	 * 			Constante de enumeracion que especifica la etiqueta que 
	 * 			describe y/o nombra el componente en cuestion, sobre la 
	 * 			operacion de negocio
	 * @param 	pBooHabilita
	 * 			Bandera que identifica si el componente grafico en cuestion
	 * 			debe habilitar o deshabilitar su funcionamiento (true y false 
	 * 			respectivamente)
	 * @param 	pBooVisible
	 * 			Bandera que identifica si el componente grafico en cuestion
	 * 			debe estar visible o no sobre la forma u operacion de negocio 
	 * 			(true y false respectivamente)
	 * @param 	pEvaFuncionalidad
	 * 			Referencia a la clase que despliega el control de todos los 
	 * 			eventos de negocio sujetos al componente grafico en cuestion 
	 * @param 	pIcoImagen
	 * 			Imagen que se adiciona al componente grafico en cuestion, 
	 * 			mejorando la asimilacion del componente sobre la operacion de 
	 * 			negocio
	 * @param 	pEnmColFondo
	 * 			Color generado para rellenar el fondo del componente
	 * @param 	pEnmColFondoDegradado
	 * 			Color generado para degradar el fondo del componente
	 * 			en su parte inferior  
	 * @param 	pEnmColContorno
	 * 			Color generado para definir el contorno del componente
	 * @param	pIntArcoXDefecto
	 * 			Entero que especifica el valor que debe tener el arco sobre 
	 * 			el eje X, en caso que el componente no presente una 
	 * 			personalizacion sobre este aspecto
	 * @param	pIntArcoYDefecto
	 * 			Entero que especifica el valor que debe tener el arco sobre 
	 * 			el eje Y, en caso que el componente no presente una 
	 * 			personalizacion sobre este aspecto 
	 * @throws	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	1/11/2016
	 * *********************************************************************
	 */
	public BotonUtil(	EnumDimensionesComponentes pEnmDimension,
		    			String pStrNombre, 
		    			EnumEtiquetas pEnmEtiqueta, 
		    			boolean pBooHabilita, 
		    			boolean pBooVisible,
		    			EventoAbstracto pEvaFuncionalidad, 
		    			Icon pIcoImagen
		    		)	throws	Exception	{
		
		super();
		
		this.inicializarAspectos(	pEnmDimension,
									pStrNombre,
									pEnmEtiqueta,
									pBooHabilita,
									pBooVisible,
									pEvaFuncionalidad,
									pIcoImagen,
									EnumColores.BTN_FONDO,
									EnumColores.BTN_FONDO_DEGRADADO,
									EnumColores.GNRL_CONTORNO
								);
	}
	
	/**
	 * ********************************************************************
	 * @method	inicializarAspectos
	 * 		   	Metodo que permite inicializar todos los aspectos sujetos 
	 * 			a la clase en cuestion
	 * @param 	pEnmDimension
	 * 			Constante de enumeracion que especifica la dimension a la 
	 * 			cual estara sometida el componente grafico en cuestion
	 * @param 	pStrNombre
	 * 			Nombre con el cual se identifica el componente grafico en 
	 * 			cuestion
	 * @param 	pEnmEtiqueta
	 * 			Constante de enumeracion que especifica la etiqueta que 
	 * 			describe y/o nombra el componente en cuestion, sobre la 
	 * 			operacion de negocio
	 * @param 	pBooHabilita
	 * 			Bandera que identifica si el componente grafico en cuestion
	 * 			debe habilitar o deshabilitar su funcionamiento (true y false 
	 * 			respectivamente)
	 * @param 	pBooVisible
	 * 			Bandera que identifica si el componente grafico en cuestion
	 * 			debe estar visible o no sobre la forma u operacion de negocio 
	 * 			(true y false respectivamente)
	 * @param 	pEvaFuncionalidad
	 * 			Referencia a la clase que despliega el control de todos los 
	 * 			eventos de negocio sujetos al componente grafico en cuestion 
	 * @param 	pIcoImagen
	 * 			Imagen que se adiciona al componente grafico en cuestion, 
	 * 			mejorando la asimilacion del componente sobre la operacion de 
	 * 			negocio
	 * @param 	pEnmColFondo
	 * 			Color generado para rellenar el fondo del componente
	 * @param 	pEnmColFondoDegradado
	 * 			Color generado para degradar el fondo del componente
	 * 			en su parte inferior  
	 * @param 	pEnmColContorno
	 * 			Color generado para definir el contorno del componente
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	1/11/2016
	 * *********************************************************************
	 */
	private void inicializarAspectos(	EnumDimensionesComponentes pEnmDimension,
										String pStrNombre, 
										EnumEtiquetas pEnmEtiqueta, 
										boolean pBooHabilita, 
										boolean pBooVisible,
										EventoAbstracto pEvaFuncionalidad, 
										Icon pIcoImagen,
										EnumColores pEnmColFondo,
	  		   						 	EnumColores pEnmColFondoDegradado,
	  		   						 	EnumColores pEnmColContorno
									)	throws	Exception	{
		String strEtiqueta;
		
		this.setName(pStrNombre);
		
		super.setColorContorno(pEnmColContorno.getColColor());
		super.setColorFondo(pEnmColFondo.getColColor());
		super.setColorPresionado(pEnmColFondoDegradado.getColColor());
		
		strEtiqueta = pEnmEtiqueta == null?"":pEnmEtiqueta.toString().trim();
		
		this.setText(strEtiqueta);
		
		this.setFont(InformacionSession.TIPO_LETRA_ETIQUETA_PEQUENA);
		this.setForeground(Color.WHITE);
		
		if(pIcoImagen!=null)
		{
			this.setIcon(pIcoImagen);
			
			if	(	strEtiqueta.isEmpty()	)	
			{
				super.setArcw(0);
				super.setArch(0);
				super.setBooAplicarSinFondo(true);
			}
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
		
		if(pEvaFuncionalidad!=null){
			
			this.addActionListener(pEvaFuncionalidad);
			this.addKeyListener(pEvaFuncionalidad);
			this.addFocusListener(pEvaFuncionalidad);
		}

		//this.setFocusTraversalKeysEnabled(false);
		
		this.setEnabled(pBooHabilita);
		this.setVisible(pBooVisible);
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
	public void setValorContenido(Object pObjeto) throws Exception {
		this.setText(pObjeto.toString());
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

package co.com.codesa.clienteposslimgiros.enumeraciones.gui;

import java.awt.Color;

import co.com.codesa.clienteposslim.enumeraciones.EstadoAplicacionEnum;
import co.com.codesa.clienteposslim.formas.FormaLogin;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumRecursosProperties;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.mensajes.Mensaje;

/**
 * ********************************************************************
 * @class	EnumColores
 *		   	Clase que contiene las constantes de enumeracion que permiten
 *			recuperar los colores relacionados con el producto de giros.
 *
 *			Esta clase dispone el mecanismo para facilitar el acceso a los
 *			colores, pero la especificacion de estos, se encuentra sujeta 
 *			a un archivo de propiedades que relaciona la construccion rgb
 *			de cada color
 *			
 * @author 	hector.cuenca
 * @date   	2/11/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public enum EnumColores {
	
	/**
	 * ***************************************************************************
	 * ********************************* GENERAL *********************************
	 * ***************************************************************************
	 */
	
	/**
	 * @variable	GNRL_CONTORNO
	 * 			 	Constante de enumeracion que representa el color del contorno
	 * 				para un gui
	 */
	GNRL_CONTORNO("gnrl_contorno"),
	
	
	/**
	 * ***************************************************************************
	 * ********************************* BOTON ***********************************
	 * ***************************************************************************
	 */
	
	/**
	 * @variable	BTN_FONDO
	 * 			 	Constante de enumeracion que representa el color de fondo 
	 * 				para un boton
	 */
	BTN_FONDO("btn_fondo"),
	
	/**
	 * @variable	BTN_FONDO_DEGRADADO
	 * 			 	Constante de enumeracion que representa el color de fondo 
	 * 				degradado para un boton
	 */
	BTN_FONDO_DEGRADADO("btn_fondo_degradado"),
	
	
	/**
	 * ***************************************************************************
	 * ******************************** SECCION **********************************
	 * ***************************************************************************
	 */
	
	/**
	 * @variable	PNL_FONDO
	 * 			 	Constante de enumeracion que representa el color de fondo 
	 * 				para un panel
	 */
	PNL_FONDO("pnl_fondo"),
	
	/**
	 * @variable	PNL_FONDO_DEGRADADO
	 * 			 	Constante de enumeracion que representa el color de fondo 
	 * 				degradado para un panel
	 */
	PNL_FONDO_DEGRADADO("pnl_fondo_degradado"),
	
	
	/**
	 * ***************************************************************************
	 * ******************************** GRILLA ***********************************
	 * ***************************************************************************
	 */
	
	/**
	 * @variable	TBL_FONDO_CABECERA
	 * 			 	Constante de enumeracion que representa el color de fondo 
	 * 				para la cabecera de la grilla (TableHeader)
	 */
	TBL_FONDO_CABECERA("tbl_fondo_cabecera"),
	
	/**
	 * @variable	TBL_FONDO_DEGRADADO_CABECERA
	 * 			 	Constante de enumeracion que representa el color de fondo 
	 * 				degradado para la cabecera de la grilla (TableHeader)
	 */
	TBL_FONDO_DEGRADADO_CABECERA("tbl_fondo_degradado_cabecera"),
	
	/**
	 * @variable	TBL_DELINIADO_Y_CONTORNO
	 * 			 	Constante de enumeracion que representa el color de fondo 
	 * 				degradado para la cabecera de la grilla (TableHeader)
	 */
	//TBL_DELINIADO_Y_CONTORNO("tbl_deliniado_y_contorno"),
	
	;
	
	/**
	 * @variable 	strNombrePropiedad
	 * 				Nombre que identifica la propiedad donde se almacena la 
	 * 				especificacion de color RGB
	 */
	private final String strNombrePropiedad;
	
	/**
	 * @variable 	strEspecificacionRGB
	 * 				Especifica los valores RGB, definidos para el color 
	 */
	private String strEspecificacionRGB;
	
	/**
	 * @variable 	colColor
	 * 				Color definido segun la especificacion RGB 
	 */
	private Color colColor;
	
	/**
	 * ********************************************************************
	 * @method	EnumColores
	 * 		   	Inicializacion de la constante de enumeracion
	 * @param 	pStrNombrePropiedad
	 * 			Nombre que identifica la propiedad donde se almacena la 
	 * 			especificacion de color RGB
	 * @author 	hector.cuenca
	 * @date   	3/11/2016
	 * *********************************************************************
	 */
	private EnumColores	(	String pStrNombrePropiedad	){
		
		this.strNombrePropiedad = pStrNombrePropiedad;
	}

	/**
	 * @method getStrEspecificacionRGB
	 * 		   Metodo get del atributo strEspecificacionRGB
	 * @return String
	 *		   Valor del atributo strEspecificacionRGB devuelto
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
	 * 		   presentada
	 * @author hector.cuenca
	 * @date   2/11/2016
	 */
	public String getStrEspecificacionRGB() throws Exception{
		
		if	(	this.strEspecificacionRGB	==	null	){
			
			this.strEspecificacionRGB	=	EnumRecursosProperties.COLORES.getRsbRecurso().getString(this.getStrNombrePropiedad());
		}
		
		return this.strEspecificacionRGB;
	}

	/**
	 * @method setStrEspecificacionRGB
	 * 		   Metodo set del atributo strEspecificacionRGB
	 * @param  pStrEspecificacionRGB
	 *		   Valor que tomara el atributo strEspecificacionRGB
	 * @author hector.cuenca
	 * @date   2/11/2016
	 */
	public void setStrEspecificacionRGB(String pStrEspecificacionRGB) {
		this.strEspecificacionRGB = pStrEspecificacionRGB;
	}

	/**
	 * @method getColColor
	 * 		   Metodo get del atributo colColor
	 * @return Color
	 *		   Valor del atributo colColor devuelto
	 * @author hector.cuenca
	 * @date   2/11/2016
	 */
	public Color getColColor(){
		
		EnumMensajes enmMsgColorMalConfigurada;
		Mensaje objMensaje;
		String	[]	arrStrRGB;
		boolean booAsignarColorError;
		int	intR;
		int	intG;
		int	intB;
		
		if (this.colColor	==	null){
			
			booAsignarColorError	=	true;
			
			try{
				
				if	(	this.getStrEspecificacionRGB().matches(EnumExpresionesRegulares.CMP_GRF_COLOR.getValor())	)
				{
				
					arrStrRGB	=	this.getStrEspecificacionRGB().split(",");
					
					intR		=	Integer.parseInt(arrStrRGB[0]);
					intG		=	Integer.parseInt(arrStrRGB[1]);
					intB		=	Integer.parseInt(arrStrRGB[2]);
					
					if	(		intR	<=	255	&&	intR	>=	0
							&&	intG	<=	255	&&	intG	>=	0
							&&	intB	<=	255	&&	intB	>=	0
						)
					{
						
						this.colColor	=	new Color	(	intR,
															intG,
															intB
														);
						
						booAsignarColorError	=	false;
					}
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			if	(	booAsignarColorError	)
			{
				try{
					
				
					enmMsgColorMalConfigurada	=	EnumMensajes.VERIFICAR_CONFIGURACION_COLOR_COMPONENTE_GRAFICO;
					
					if	(	EstadoAplicacionEnum.DESARROLLO.equals(FormaLogin.estadoAplicacion)	)	{
					
						enmMsgColorMalConfigurada.desplegarMensaje	(	null, 
																		EnumClasesMensaje.ADVERTENCIA,
																		this.getStrNombrePropiedad()
																	);
					}	else	{
						
						objMensaje	=	enmMsgColorMalConfigurada.obtenerMensaje(	EnumClasesMensaje.ADVERTENCIA,
																					this.getStrNombrePropiedad()
								   												);
	
						UtilidadesGiros.getInstance().mostrarEnConsola	(	objMensaje.obtenerMensajeProcesado(),
									   										System.err
									   									);
					}
				
				}catch(Exception e){
					e.printStackTrace();
				}
					
				this.colColor	=	Color.RED;
			}
		}
		
		return this.colColor;
	}

	/**
	 * @method setColColor
	 * 		   Metodo set del atributo colColor
	 * @param  pColColor
	 *		   Valor que tomara el atributo colColor
	 * @author hector.cuenca
	 * @date   2/11/2016
	 */
	public void setColColor(Color pColColor) {
		this.colColor = pColColor;
	}

	/**
	 * @method getStrNombrePropiedad
	 * 		   Metodo get del atributo strNombrePropiedad
	 * @return String
	 *		   Valor del atributo strNombrePropiedad devuelto
	 * @author hector.cuenca
	 * @date   2/11/2016
	 */
	public String getStrNombrePropiedad() {
		return this.strNombrePropiedad;
	}
	
	
}

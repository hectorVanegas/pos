package co.com.codesa.clienteposslimgiros.enumeraciones.serviciosAdicionales;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.FormaPanelServicioAdicional;
import co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.claveSeguridad.FormaPanelClaveSeguridad;

/** 
 * ********************************************************************
 * @class  EnumServiciosAdicionales
 *		   Clase enumerador, que permite configurar la informacion 
 *		   comun y relacionada para los procesos 
 * @author hector.cuenca
 * @date   12/03/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public enum EnumServiciosAdicionales {

	/**
	 * @variable CLAVE_SEGURIDAD
	 * 			 Constante que identifica el proceso relacionado con clave
	 * 			 de seguridad
	 */
	CLAVE_SEGURIDAD(EnumEtiquetas.TTL_SRV_ADI_CLAVE_SEGURIDAD,
					FormaPanelClaveSeguridad.class),
	;
	
	/**
	 * @variable enmEtiNombre
	 * 			 Nombre funcional configurado para el objeto de negocio
	 */
	private final EnumEtiquetas enmEtiNombre;
	
	/**
	 * @variable clsFrmPnlServicioAdicional
	 * 			 Referencia a la clase forma que desplegara todos los 
	 * 			 controles graficos y logicos de un servicio adicional 
	 * 		 	 particular
	 */
	private final Class<? extends FormaPanelServicioAdicional<?>> clsFrmPnlServicioAdicional;
	
	/**
	 * ********************************************************************
	 * @method EnumServiciosAdicionales
	 * 		   Inicializacion de la constante de enumeracion
	 * @param  pEnmEtiNombre
	 * 		   Nombre funcional configurado para el objeto de negocio
	 * @param  pClsFrmPnlServicioAdicional
	 * 		   Referencia a la clase forma que desplegara todos los controles
	 * 		   graficos y logicos de un servicio adicional particular
	 * @author hector.cuenca
	 * @date   2/03/2016
	 * *********************************************************************
	 */
	private EnumServiciosAdicionales(EnumEtiquetas pEnmEtiNombre,
									 Class<? extends FormaPanelServicioAdicional<?>> pClsFrmPnlServicioAdicional){
		
		this.enmEtiNombre = pEnmEtiNombre;
		this.clsFrmPnlServicioAdicional = pClsFrmPnlServicioAdicional;
	}
	
	/** 
	 * ********************************************************************
	 * @method crearFormaPanelServicioAdicional
	 * 		   Metodo que permite crear una forma panel referente a un
	 * 		   servicio adicional particular
	 * @param  pFrmGnrVentana
	 * 		   Representa a la funcionalidad que integra el proceso de token
	 * 		   de validacion
	 * @param  pStrNombreComponente
	 * 		   Nombre que recibira la seccion como tal
	 * @return FormaPanelServicioAdicional
	 * 		   Forma panel servicio adicional particular gestionado
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author hector.cuenca
	 * @date   22/03/2016
	 * *********************************************************************
	 */
	public FormaPanelServicioAdicional<?> crearFormaPanelServicioAdicional(FormaGenerica pFrmGnrVentana,
																		   String pStrNombreComponente)throws Exception{
		
		FormaPanelServicioAdicional<?> objFrmPnlServicioAdicional;
		
		objFrmPnlServicioAdicional = this.getClsFrmPnlServicioAdicional().getDeclaredConstructor(FormaGenerica.class,
																								 String.class).newInstance(pFrmGnrVentana,
																										 				   pStrNombreComponente);
		return objFrmPnlServicioAdicional;
	}
	
	/**
	 * @method getEnmEtiNombre
	 * 		   Metodo get del atributo enmEtiNombre
	 * @return EnumEtiquetas
	 *		   Valor del atributo enmEtiNombre devuelto
	 * @author hector.cuenca
	 * @date   12/03/2016
	 */
	public EnumEtiquetas getEnmEtiNombre() {
		return enmEtiNombre;
	}

	/**
	 * @method getClsFrmPnlServicioAdicional
	 * 		   Metodo get del atributo clsFrmPnlServicioAdicional
	 * @return Class<? extends FormaPanelServicioAdicional>
	 *		   Valor del atributo clsFrmPnlServicioAdicional devuelto
	 * @author hector.cuenca
	 * @date   22/03/2016
	 */
	public Class<? extends FormaPanelServicioAdicional<?>> getClsFrmPnlServicioAdicional() {
		return clsFrmPnlServicioAdicional;
	}
	
}

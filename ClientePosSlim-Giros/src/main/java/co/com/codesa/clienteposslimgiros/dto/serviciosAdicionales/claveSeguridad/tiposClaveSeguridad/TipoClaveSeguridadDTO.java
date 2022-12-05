package co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad;

import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.ConfigOfrecerClaveSeguridadDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.claveSeguridad.FormaOfrecerClaveSeguridad;
import co.com.codesa.clienteposslimgiros.interfaces.serviciosAdicionales.claveSeguridad.IFormasTiposClaveSeguridad;

/**
 * ********************************************************************
 * @class  TipoClaveSeguridadDTO
 *		   Clase DTO encargada de generalizar los atributos y 
 *		   comportamientos comunes a los diferentes tipos de clave de 
 *		   seguridad que se esperan tener disponibles
 * @author hector.cuenca
 * @date   2/03/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public abstract class TipoClaveSeguridadDTO {
	
	/**
	 * @variable enmEtiNombre
	 * 			 Nombre con el cual se identifica y se expone cada tipo de clave
	 * 			 de seguridad
	 */
	private EnumEtiquetas enmEtiNombre;
	
	/**
	 * @variable clsFrmPnlTipoClaveSeguridad
	 * 			 Referencia de clase que permitira construir en un momento dado
	 * 			 la seccion con todos los controles graficos solicitados por el 
	 * 			 tipo de clave de seguridad seleccionada
	 */
	private Class<? extends IFormasTiposClaveSeguridad> clsFrmPnlTipoClaveSeguridad;
	
	/**
	 * @variable iFrmTipoClaveSeguridad
	 * 			 Interface que representa a la forma panel (seccion), particular 
	 * 		 	 de cada tipo de clave de seguridad seleccionada
	 */
	private IFormasTiposClaveSeguridad iFrmTipoClaveSeguridad;
	
	/**
	 * ********************************************************************
	 * @method TipoClaveSeguridadDTO
	 * 		   Metodo constructor que permite la inicializacion de los 
	 * 		   valores y comportamientos necesarios para la construccion de
	 * 		   este objeto
	 * @param  pEnmEtiNombre
	 * 		   Nombre con el cual se identifica y se expone cada tipo de clave
	 * 		   de seguridad
	 * @param  pClsFrmPnlTipoClaveSeguridad
	 * 		   Referencia de clase que permitira construir en un momento dado
	 * 		   la seccion con todos los controles graficos solicitados por el 
	 * 		   tipo de clave de seguridad seleccionada
	 * @author hector.cuenca
	 * @date   2/03/2016
	 * *********************************************************************
	 */
	public TipoClaveSeguridadDTO(EnumEtiquetas pEnmEtiNombre,
								  Class<? extends IFormasTiposClaveSeguridad> pClsFrmPnlTipoClaveSeguridad){
		
		super();
		
		this.setEnmEtiNombre(pEnmEtiNombre);
		this.setClsFrmPnlTipoClaveSeguridad(pClsFrmPnlTipoClaveSeguridad);
	}
	
	@Override
	public String toString() {
	
		return enmEtiNombre.toString();
	}

	/**
	 * ********************************************************************
	 * @method iniciarPropFrmPnlTipoClaveSeguridad
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   iFrmTipoClaveSeguridad
	 * @param  pFrmGnrOfrecerClaveSeguridad
	 * 		   Forma principal que administra todo el despliegue y control
	 * 		   relacionado con el proceso para ofrecer clave de seguridad
	 * @param  pObjConfigOfrecerClaveSeguridadDTO
	 * 		   Objeto ConfigOfrecerClaveSeguridadDTO que contiene el objeto 
	 * 	       factura giro y tercero nuevo para cambio de beneficiario
	 * @return IFormasTiposClaveSeguridad
	 * 		   Forma panel (seccion) gestionada, particular de cada tipo de 
	 * 		   clave de seguridad seleccionada, representada por medio de 
	 * 		   una interface 
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   2/03/2016
	 * *********************************************************************
	 */
	public IFormasTiposClaveSeguridad iniciarPropFrmPnlTipoClaveSeguridad(FormaOfrecerClaveSeguridad pFrmGnrOfrecerClaveSeguridad,
																		  ConfigOfrecerClaveSeguridadDTO pObjConfigOfrecerClaveSeguridadDTO)throws Exception{
		
		if(this.iFrmTipoClaveSeguridad == null){
		
			this.iFrmTipoClaveSeguridad = this.getClsFrmPnlTipoClaveSeguridad().getDeclaredConstructor(FormaOfrecerClaveSeguridad.class).newInstance(pFrmGnrOfrecerClaveSeguridad);
		}
		
		this.iFrmTipoClaveSeguridad.limpiar();
		
		this.iFrmTipoClaveSeguridad.configurar(pFrmGnrOfrecerClaveSeguridad,
											   pObjConfigOfrecerClaveSeguridadDTO, 
											   this);
		
		return this.iFrmTipoClaveSeguridad;
	}

	/** 
	 * ********************************************************************
	 * @method validarDisponibilidad
	 * 		   Metodo encargado de validar la disponibilidad del tipo de 
	 * 		   clave de seguridad
	 * @param  pObjCfgOfrecerClaveSeguridad
	 * 		   Objeto DTO que contiene toda la configuracion relacionada con 
	 * 		   el proceso de ofrecer clave de seguridad
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   7/03/2016
	 * *********************************************************************
	 */
	public abstract void validarDisponibilidad(ConfigOfrecerClaveSeguridadDTO pObjCfgOfrecerClaveSeguridad)throws Exception;
	
	/**
	 * @method getEnmEtiNombre
	 * 		   Metodo get del atributo enmEtiNombre
	 * @return EnumEtiquetas
	 *		   Valor del atributo enmEtiNombre devuelto
	 * @author hector.cuenca
	 * @date   2/03/2016
	 */
	public EnumEtiquetas getEnmEtiNombre() {
		return this.enmEtiNombre;
	}

	/**
	 * @method setEnmEtiNombre
	 * 		   Metodo set del atributo enmEtiNombre
	 * @param  pEnmEtiNombre
	 *		   Valor que tomara el atributo enmEtiNombre
	 * @author hector.cuenca
	 * @date   2/03/2016
	 */
	public void setEnmEtiNombre(EnumEtiquetas pEnmEtiNombre) {
		this.enmEtiNombre = pEnmEtiNombre;
	}

	/**
	 * @method getClsFrmPnlTipoClaveSeguridad
	 * 		   Metodo get del atributo clsFrmPnlTipoClaveSeguridad
	 * @return Class<? extends IFormasTiposClaveSeguridad>
	 *		   Valor del atributo clsFrmPnlTipoClaveSeguridad devuelto
	 * @author hector.cuenca
	 * @date   2/03/2016
	 */
	public Class<? extends IFormasTiposClaveSeguridad> getClsFrmPnlTipoClaveSeguridad() {
		return this.clsFrmPnlTipoClaveSeguridad;
	}

	/**
	 * @method setClsFrmPnlTipoClaveSeguridad
	 * 		   Metodo set del atributo clsFrmPnlTipoClaveSeguridad
	 * @param  pClsFrmPnlTipoClaveSeguridad
	 *		   Valor que tomara el atributo clsFrmPnlTipoClaveSeguridad
	 * @author hector.cuenca
	 * @date   2/03/2016
	 */
	public void setClsFrmPnlTipoClaveSeguridad(
			Class<? extends IFormasTiposClaveSeguridad> pClsFrmPnlTipoClaveSeguridad) {
		this.clsFrmPnlTipoClaveSeguridad = pClsFrmPnlTipoClaveSeguridad;
	}

	/**
	 * @method getiFrmTipoClaveSeguridad
	 * 		   Metodo get del atributo iFrmTipoClaveSeguridad
	 * @return IFormasTiposClaveSeguridad
	 *		   Valor del atributo iFrmTipoClaveSeguridad devuelto
	 * @author hector.cuenca
	 * @date   2/03/2016
	 */
	public IFormasTiposClaveSeguridad getiFrmTipoClaveSeguridad() {
		return this.iFrmTipoClaveSeguridad;
	}

	/**
	 * @method setiFrmTipoClaveSeguridad
	 * 		   Metodo set del atributo iFrmTipoClaveSeguridad
	 * @param  pIFrmTipoClaveSeguridad
	 *		   Valor que tomara el atributo iFrmTipoClaveSeguridad
	 * @author hector.cuenca
	 * @date   2/03/2016
	 */
	public void setiFrmTipoClaveSeguridad(IFormasTiposClaveSeguridad pIFrmTipoClaveSeguridad) {
		this.iFrmTipoClaveSeguridad = pIFrmTipoClaveSeguridad;
	}
	
}

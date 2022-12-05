package co.com.codesa.clienteposslimgiros.enumeraciones.serviciosAdicionales.claveSeguridad;

import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.ConfigOfrecerClaveSeguridadDTO;
import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad.TipoClaveSeguridadAutomaticaDTO;
import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad.TipoClaveSeguridadDTO;
import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad.TipoClaveSeguridadManualDTO;
import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad.TipoClaveSeguridadNoGraciasDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad.FormaPanelTipoClaveSeguridadAutomatica;
import co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad.FormaPanelTipoClaveSeguridadManual;
import co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad.FormaPanelTipoClaveSeguridadNoGracias;
import co.com.codesa.clienteposslimgiros.interfaces.serviciosAdicionales.claveSeguridad.IFormasTiposClaveSeguridad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ClaveSeguridad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ClaveSeguridadAutomatica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ClaveSeguridadManual;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.tokenValidacion.ClaveSeguridadDTO;

/**
 * ********************************************************************
 * @class EnumTiposClaveSeguridad
 *		  Clase enumerador, que permite administrar de forma diciente 
 * 		  los diferentes tipos de clave de seguridad que el sistema 
 * 		  puede reconocer
 * @author hector.cuenca
 * @date 7/03/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public enum EnumTiposClaveSeguridad {
	
	
	/**
	 * @variable MANUAL
	 * 			 Constante que identifica el tipo de clave de seguridad manual
	 */
	MANUAL("M",
		   EnumEtiquetas.TTL_SRV_ADI_CLAVE_SEGURIDAD_MANUAL,
		   TipoClaveSeguridadManualDTO.class,
		   FormaPanelTipoClaveSeguridadManual.class,
		   ClaveSeguridadManual.class),
		   
	/**
	 * @variable AUTOMATICA
	 * 			 Constante que identifica el tipo de clave de seguridad automatica
	 */
	AUTOMATICA("A",
			   EnumEtiquetas.TTL_SRV_ADI_CLAVE_SEGURIDAD_AUTOMATICA,
			   TipoClaveSeguridadAutomaticaDTO.class,
			   FormaPanelTipoClaveSeguridadAutomatica.class,
			   ClaveSeguridadAutomatica.class),
	
	/**
	 * @variable AUTOMATICA
	 * 			 Constante que identifica el tipo de clave de seguridad no gracias
	 */
	NO_GRACIAS("NG",
			   EnumEtiquetas.TTL_SRV_ADI_CLAVE_SEGURIDAD_NO_GRACIAS,
			   TipoClaveSeguridadNoGraciasDTO.class,
			   FormaPanelTipoClaveSeguridadNoGracias.class,
			   null),
	;
	
	
	/**
	 * @variable enmEtiNombre
	 * 			 Nombre representativo del tipo de token de validacion
	 */
	private final EnumEtiquetas enmEtiNombre;
	
	/**
	 * @variable strCodigo
	 * 			 Codigo que identifica a la constante de enumeracion 
	 */
	private final String strCodigo;
	
	/**
	 * @variable clsDtoTipoClaveSeguridad
	 * 			 Referencia a la clase Dto que despliega toda la gestion
	 * 			 del tipo de clave de seguridad especifico
	 */
	private final Class<? extends TipoClaveSeguridadDTO> clsDtoTipoClaveSeguridad;
	
	/**
	 * @variable clsFrmPnlTipoClaveSeguridad
	 * 			 Referencia de clase que permitira construir en un momento dado
	 * 			 la seccion con todos los controles graficos solicitados por el 
	 * 			 tipo de clave de seguridad seleccionada   
	 */
	private final Class<? extends IFormasTiposClaveSeguridad> clsFrmPnlTipoClaveSeguridad;
	
	/**
	 * @variable clsClaveSeguridad
	 * 			 Referencia de clase que permitira construir en un momento dado
	 * 			 el objeto de negocio especifico de clave de seguridad configurada
	 */
	private final Class<? extends ClaveSeguridad> clsClaveSeguridad;
	
	/**
	 * @variable objDtoTipoClaveSeguridad
	 * 			 Objeto DTO gestionado que almacena toda la informacion 
	 * 			 relacionada con el tipo de clave de seguridad configurada
	 */
	private TipoClaveSeguridadDTO objDtoTipoClaveSeguridad;
	
	/**
	 * @variable objDtoClaveSeguridad
	 * 			 Objeto DTO que permite almacenar la informacion relacionada
	 *		   	 para la gestion del objeto de negocio clave de seguridad 
	 */
	private ClaveSeguridadDTO objDtoClaveSeguridad;
	
	/**
	 * ********************************************************************
	 * @method EnumTiposClaveSeguridad
	 * 		   Inicializacion de la constante de enumeracion
	 * @param  pStrCodigo
	 * 		   Codigo que identifica el tipo de clave de seguridad
	 * @param  pEnmEtiNombre
	 * 		   Nombre representativo del tipo de clave de seguridad
	 * @param  pClsDtoTipoClaveSeguridad
	 * 		   Referencia a la clase Dto que despliega toda la gestion del 
	 * 		   tipo de clave de seguridad
	 * @param  pClsFrmPnlTipoClaveSeguridad
	 * 		   Referencia de clase que permitira construir en un momento dado
	 * 		   la seccion con todos los controles graficos solicitados por el 
	 * 		   tipo de clave de seguridad seleccionada
	 * @param  pClsClaveSeguridad
	 * 		   Referencia de clase que permitira construir en un momento dado
	 * 		   el objeto de negocio especifico de clave de seguridad configurada
	 * @author hector.cuenca
	 * @date   2/03/2016
	 * *********************************************************************
	 */
	private EnumTiposClaveSeguridad(String pStrCodigo,
								 	 EnumEtiquetas pEnmEtiNombre,
								 	 Class<? extends TipoClaveSeguridadDTO> pClsDtoTipoClaveSeguridad,
								 	 Class<? extends IFormasTiposClaveSeguridad> pClsFrmPnlTipoClaveSeguridad,
								 	 Class<? extends ClaveSeguridad> pClsClaveSeguridad){
		
		this.strCodigo = pStrCodigo;
		this.enmEtiNombre = pEnmEtiNombre;
		this.clsDtoTipoClaveSeguridad = pClsDtoTipoClaveSeguridad;
		this.clsFrmPnlTipoClaveSeguridad = pClsFrmPnlTipoClaveSeguridad;
		this.clsClaveSeguridad = pClsClaveSeguridad;
	}
	
	@Override
	public String toString() {
		
		return this.getEnmEtiNombre().toString();
	}
	
	/** 
	 * ********************************************************************
	 * @method validarDisponibilidad
	 * 		   Metodo encargado de validar la disponibilidad del tipo de 
	 * 		   clave de seguridad
	 * @param  pObjCfgOfrecerClaveSeguridad
	 * 		   Objeto DTO que contiene toda la configuracion relacionada con 
	 * 		   el proceso de ofrecer el servicio de clave de seguridad
	 * @return TipoClaveSeguridadDTO
	 * 		   Objeto DTO gestionado que almacena toda la informacion 
	 * 		   relacionada con el tipo de clave de seguridad configurada
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   7/03/2016
	 * *********************************************************************
	 */
	public TipoClaveSeguridadDTO validarDisponibilidad(ConfigOfrecerClaveSeguridadDTO pObjCfgOfrecerClaveSeguridad)throws Exception{
		
		this.getObjDtoTipoClaveSeguridad().validarDisponibilidad(pObjCfgOfrecerClaveSeguridad);
		
		return this.getObjDtoTipoClaveSeguridad();
	}
	
	/**
	 * @method getEnmEtiNombre
	 * 		   Metodo get del atributo enmEtiNombre
	 * @return EnumEtiquetas
	 *		   Valor del atributo enmEtiNombre devuelto
	 * @author hector.cuenca
	 * @date   7/03/2016
	 */
	public EnumEtiquetas getEnmEtiNombre() {
		return this.enmEtiNombre;
	}

	/**
	 * @method getStrCodigo
	 * 		   Metodo get del atributo strCodigo
	 * @return String
	 *		   Valor del atributo strCodigo devuelto
	 * @author hector.cuenca
	 * @date   7/03/2016
	 */
	public String getStrCodigo() {
		return this.strCodigo;
	}

	/**
	 * @method getClsDtoTipoClaveSeguridad
	 * 		   Metodo get del atributo clsDtoTipoClaveSeguridad
	 * @return Class<? extends TipoClaveSeguridadDTO>
	 *		   Valor del atributo clsDtoTipoClaveSeguridad devuelto
	 * @author hector.cuenca
	 * @date   7/03/2016
	 */
	public Class<? extends TipoClaveSeguridadDTO> getClsDtoTipoClaveSeguridad() {
		return this.clsDtoTipoClaveSeguridad;
	}

	/**
	 * @method getObjDtoTipoClaveSeguridad
	 * 		   Metodo get del atributo objDtoTipoClaveSeguridad
	 * @return TipoClaveSeguridadDTO
	 *		   Valor del atributo objDtoTipoClaveSeguridad devuelto
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author hector.cuenca
	 * @date   7/03/2016
	 */
	public TipoClaveSeguridadDTO getObjDtoTipoClaveSeguridad() throws Exception{
		
		if(this.objDtoTipoClaveSeguridad == null){
			
			this.objDtoTipoClaveSeguridad = this.getClsDtoTipoClaveSeguridad().getDeclaredConstructor(EnumEtiquetas.class,
																							  this.getClsFrmPnlTipoClaveSeguridad().getClass()).newInstance(this.getEnmEtiNombre(),
																	 								   									this.getClsFrmPnlTipoClaveSeguridad());
		}
		
		return this.objDtoTipoClaveSeguridad;
	}

	/**
	 * @method setObjDtoTipoClaveSeguridad
	 * 		   Metodo set del atributo objDtoTipoClaveSeguridad
	 * @param  pObjDtoTipoClaveSeguridad
	 *		   Valor que tomara el atributo objDtoTipoClaveSeguridad
	 * @author hector.cuenca
	 * @date   7/03/2016
	 */
	public void setObjDtoTipoClaveSeguridad(TipoClaveSeguridadDTO pObjDtoTipoClaveSeguridad) {
		this.objDtoTipoClaveSeguridad = pObjDtoTipoClaveSeguridad;
	}

	/**
	 * @method getClsFrmPnlTipoClaveSeguridad
	 * 		   Metodo get del atributo clsFrmPnlTipoClaveSeguridad
	 * @return Class<? extends IFormasTiposClaveSeguridad>
	 *		   Valor del atributo clsFrmPnlTipoClaveSeguridad devuelto
	 * @author hector.cuenca
	 * @date   7/03/2016
	 */
	public Class<? extends IFormasTiposClaveSeguridad> getClsFrmPnlTipoClaveSeguridad() {
		return clsFrmPnlTipoClaveSeguridad;
	}

	/**
	 * @method getClsClaveSeguridad
	 * 		   Metodo get del atributo clsClaveSeguridad
	 * @return Class<? extends TokenValidacion>
	 *		   Valor del atributo clsClaveSeguridad devuelto
	 * @author hector.cuenca
	 * @date   8/03/2016
	 */
	public Class<? extends ClaveSeguridad> getClsClaveSeguridad() {
		return this.clsClaveSeguridad;
	}

	/**
	 * @method getObjDtoClaveSeguridad
	 * 		   Metodo get del atributo objDtoClaveSeguridad
	 * @return ServicioClaveSeguridadDTO
	 *		   Valor del atributo objDtoClaveSeguridad devuelto
	 * @author hector.cuenca
	 * @date   8/03/2016
	 */
	public ClaveSeguridadDTO getObjDtoClaveSeguridad() {
		
		if(this.objDtoClaveSeguridad == null){
		
			this.objDtoClaveSeguridad = new ClaveSeguridadDTO(this,
															  this.getClsClaveSeguridad());
		}
		
		return this.objDtoClaveSeguridad;
	}

	/**
	 * @method setObjDtoClaveSeguridad
	 * 		   Metodo set del atributo objDtoClaveSeguridad
	 * @param  pObjDtoClaveSeguridad
	 *		   Valor que tomara el atributo objDtoClaveSeguridad
	 * @author hector.cuenca
	 * @date   8/03/2016
	 */
	public void setObjDtoClaveSeguridad(ClaveSeguridadDTO pObjDtoClaveSeguridad) {
		this.objDtoClaveSeguridad = pObjDtoClaveSeguridad;
	}
	
}

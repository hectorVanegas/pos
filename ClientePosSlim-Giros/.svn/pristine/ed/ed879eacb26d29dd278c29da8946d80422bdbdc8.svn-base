package co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad;

import java.util.ArrayList;
import java.util.List;
import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad.TipoClaveSeguridadDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.operaciones.EnumTiposOperaciones;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;

/**
 * ********************************************************************
 * @class  ConfigOfrecerClaveSeguridadDTO
 *		   Clase DTO encargada de almacenar toda la informacion de 
 *		   configuracion relacionada con el proceso de ofrecer clave de 
 *		   seguridad
 * @author hector.cuenca
 * @date   2/03/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class ConfigOfrecerClaveSeguridadDTO {
	
	/**
	 * @variable lstTiposClaveSeguridad
	 * 			 Listado de tipos de clave de seguridad, disponibles para 
	 * 			 ofrecer
	 */
	private List<TipoClaveSeguridadDTO> lstTiposClaveSeguridad;
	
	
	/**
	 * @variable objFacturaGiro
	 * 			 Objeto factura que contiene todo el detalle de la 
	 * 			 transaccion que se esta llevando a cabo 
	 */
	private FacturaGiro objFacturaGiro;
	
	/**
	 * @variable objDtoClaveSeguridad
	 * 			 Objeto DTO que encapsula los atributos adicionales 
	 * 			 requeridos para el proceso de clave de seguridad
	 */
	private ServicioClaveSeguridadDTO objDtoClaveSeguridad;
	
	/**
	 * @variable enmTipoOperacion
	 * 			 Tipo de operacion que se esta llevando a cabo
	 */
	private EnumTiposOperaciones enmTipoOperacion;
	
	/**
	 * ********************************************************************
	 * @method ConfigOfrecerClaveSeguridadDTO
	 * 		   Metodo constructor que se encarga de fabricar la DTO de
	 * 		   configuracion, inicializando los aspectos necesarios para 
	 * 		   ello
	 * @param  pObjFacturaGiro
	 * 		   Objeto factura que contiene todo el detalle de la transaccion 
	 * 		   que se esta llevando a cabo
	 * @param  pEnmTipoOperacion
	 * 		   Tipo de operacion que se esta llevando a cabo
	 * @param  pObjDtoClaveSeguridad
	 * 		   Objeto DTO que encapsula los atributos adicionales requeridos
	 * 		   para el proceso de clave de seguridad
	 * @author hector.cuenca
	 * @date   2/03/2016
	 * *********************************************************************
	 */
	public ConfigOfrecerClaveSeguridadDTO(FacturaGiro pObjFacturaGiro,
										  EnumTiposOperaciones pEnmTipoOperacion,
										  ServicioClaveSeguridadDTO pObjDtoClaveSeguridad){
		
		super();
		
		this.lstTiposClaveSeguridad = new ArrayList<TipoClaveSeguridadDTO>();
		this.setObjFacturaGiro(pObjFacturaGiro);
		this.setEnmTipoOperacion(pEnmTipoOperacion);
		this.setObjDtoClaveSeguridad(pObjDtoClaveSeguridad);
	}

	/**
	 * @method getLstTiposClaveSeguridad
	 * 		   Metodo get del atributo lstTiposClaveSeguridad
	 * @return List<TipoClaveSeguridadDTO>
	 *		   Valor del atributo lstTiposClaveSeguridad devuelto
	 * @author hector.cuenca
	 * @date   2/03/2016
	 */
	public List<TipoClaveSeguridadDTO> getLstTiposClaveSeguridad() {
		return this.lstTiposClaveSeguridad;
	}

	/**
	 * @method setLstTiposClaveSeguridad
	 * 		   Metodo set del atributo lstTiposClaveSeguridad
	 * @param  pLstTiposClaveSeguridad
	 *		   Valor que tomara el atributo lstTiposClaveSeguridad
	 * @author hector.cuenca
	 * @date   2/03/2016
	 */
	public void setLstTiposClaveSeguridad(
			List<TipoClaveSeguridadDTO> pLstTiposClaveSeguridad) {
		this.lstTiposClaveSeguridad = pLstTiposClaveSeguridad;
	}

	/**
	 * @method getObjFacturaGiro
	 * 		   Metodo get del atributo objFacturaGiro
	 * @return FacturaGiro
	 *		   Valor del atributo objFacturaGiro devuelto
	 * @author hector.cuenca
	 * @date   2/03/2016
	 */
	public FacturaGiro getObjFacturaGiro() {
		return this.objFacturaGiro;
	}

	/**
	 * @method setObjFacturaGiro
	 * 		   Metodo set del atributo objFacturaGiro
	 * @param  pObjFacturaGiro
	 *		   Valor que tomara el atributo objFacturaGiro
	 * @author hector.cuenca
	 * @date   2/03/2016
	 */
	public void setObjFacturaGiro(FacturaGiro pObjFacturaGiro) {
		this.objFacturaGiro = pObjFacturaGiro;
	}

	/**
	 * @method getEnmTipoOperacion
	 * 		   Metodo get del atributo enmTipoOperacion
	 * @return EnumTiposOperaciones
	 *		   Valor del atributo enmTipoOperacion devuelto
	 * @author roberth.martinez
	 * @date   8/3/2016
	 */
	public EnumTiposOperaciones getEnmTipoOperacion() {
		return this.enmTipoOperacion;
	}

	/**
	 * @method setEnmTipoOperacion
	 * 		   Metodo set del atributo enmTipoOperacion
	 * @param  pEnmTipoOperacion
	 *		   Valor que tomara el atributo enmTipoOperacion
	 * @author roberth.martinez
	 * @date   8/3/2016
	 */
	public void setEnmTipoOperacion(EnumTiposOperaciones pEnmTipoOperacion) {
		this.enmTipoOperacion = pEnmTipoOperacion;
	}

	/**
	 * @method getObjDtoClaveSeguridad
	 * 		   Metodo get del atributo objDtoClaveSeguridad
	 * @return ServicioClaveSeguridadDTO
	 *		   Valor del atributo objDtoClaveSeguridad devuelto
	 * @author roberth.martinez
	 * @date   18/3/2016
	 */
	public ServicioClaveSeguridadDTO getObjDtoClaveSeguridad() {
		return objDtoClaveSeguridad;
	}

	/**
	 * @method setObjDtoClaveSeguridad
	 * 		   Metodo set del atributo objDtoClaveSeguridad
	 * @param  pObjDtoClaveSeguridad
	 *		   Valor que tomara el atributo objDtoClaveSeguridad
	 * @author roberth.martinez
	 * @date   18/3/2016
	 */
	public void setObjDtoClaveSeguridad(ServicioClaveSeguridadDTO pObjDtoClaveSeguridad) {
		this.objDtoClaveSeguridad = pObjDtoClaveSeguridad;
	}
}

package co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad;

import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.ConfigOfrecerClaveSeguridadDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.interfaces.serviciosAdicionales.claveSeguridad.IFormasTiposClaveSeguridad;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;

/**
 * ********************************************************************
 * @class  TipoClaveSeguridadAutomaticaDTO
 *		   Clase DTO que representa la informacion necesaria para ofrecer 
 *		   un tipo de clave de seguridad automatica
 * @author hector.cuenca
 * @date   2/03/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class TipoClaveSeguridadAutomaticaDTO extends TipoClaveSeguridadDTO{
	
	
	/**
	 * ********************************************************************
	 * @method TipoClaveSeguridadAutomaticaDTO
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
	public TipoClaveSeguridadAutomaticaDTO(EnumEtiquetas pEnmEtiNombre,
			  							   Class<? extends IFormasTiposClaveSeguridad> pClsFrmPnlTipoClaveSeguridad){
		
		super(pEnmEtiNombre,
			  pClsFrmPnlTipoClaveSeguridad);
	}
	
	@Override
	public void validarDisponibilidad(ConfigOfrecerClaveSeguridadDTO pObjCfgOfrecerClaveSeguridad)throws Exception{
		
		EnumParametrosSistema enmParametroSistema;
		boolean booClaveManualObligatoria;
		boolean booServicioSMSActivo;
		
		UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.SOLO_CLAVE_MANUAL_OBLIGATORIA,
													  EnumParametrosSistema.SERVICIO_SMS_BD_ACTIVO);
		
		booClaveManualObligatoria = EnumParametrosSistema.SOLO_CLAVE_MANUAL_OBLIGATORIA.obtenerValorBooleano("N");
		booServicioSMSActivo = EnumParametrosSistema.SERVICIO_SMS_BD_ACTIVO.obtenerValorBooleano("S");
		
		enmParametroSistema = EnumParametrosSistema.SOLO_CLAVE_MANUAL_OBLIGATORIA;
		
		if (booClaveManualObligatoria) {
		
			enmParametroSistema = EnumParametrosSistema.SERVICIO_SMS_BD_ACTIVO;
			
			if (booServicioSMSActivo) {
				enmParametroSistema = null;
			}
		}
		
		if(enmParametroSistema!=null){
		
			throw EnumMensajes.SERVICIO_CLAVE_SEGURIDAD_AUTOMATICA_NO_DISPONIBLE.generarExcepcion(EnumClasesMensaje.ERROR, 
																						  		  enmParametroSistema.name(),
																						  		  enmParametroSistema.getStrCodigo());
		}
	}
	
}

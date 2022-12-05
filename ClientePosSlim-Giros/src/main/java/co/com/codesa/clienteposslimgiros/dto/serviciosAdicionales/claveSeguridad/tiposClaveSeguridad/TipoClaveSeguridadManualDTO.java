package co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad;

import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.ConfigOfrecerClaveSeguridadDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.interfaces.serviciosAdicionales.claveSeguridad.IFormasTiposClaveSeguridad;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;

/**
 * ********************************************************************
 * @class  TipoClaveSeguridadManualDTO
 *		   Clase DTO que representa la informacion necesaria para ofrecer 
 *		   un tipo de clave de seguridad manual 
 * @author hector.cuenca
 * @date   2/03/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class TipoClaveSeguridadManualDTO extends TipoClaveSeguridadDTO{
	
	/**
	 * @variable intLongitudMinimaClave
	 * 			 Longitud de caracteres minima para un ingreso de clave manual 
	 */
	private int intLongitudMinimaClave;
	/**
	 * @variable intLongitudMaximaClave
	 * 			 Longitud de caracteres maxima para un ingreso de clave manual
	 */
	private int intLongitudMaximaClave;
	
	/**
	 * ********************************************************************
	 * @method TipoClaveSeguridadManualDTO
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
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author hector.cuenca
	 * @date   2/03/2016
	 * *********************************************************************
	 */
	public TipoClaveSeguridadManualDTO(EnumEtiquetas pEnmEtiNombre,
									   Class<? extends IFormasTiposClaveSeguridad> pClsFrmPnlTipoClaveSeguridad)throws Exception{
		super(pEnmEtiNombre,
			  pClsFrmPnlTipoClaveSeguridad);
	}

	@Override
	public void validarDisponibilidad(ConfigOfrecerClaveSeguridadDTO pObjCfgOfrecerClaveSeguridad)throws Exception{
		
		int intLongitudMinimaClave;
		int intLongitudMaximaClave;
		
		UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.LONGITUD_MINIMA_CLAVE_SEGURIDAD_MANUAL,
													  EnumParametrosSistema.LONGITUD_MAXIMA_CLAVE_SEGURIDAD_MANUAL);
		
		intLongitudMinimaClave = EnumParametrosSistema.LONGITUD_MINIMA_CLAVE_SEGURIDAD_MANUAL.obtenerValorEntero();
		intLongitudMaximaClave = EnumParametrosSistema.LONGITUD_MAXIMA_CLAVE_SEGURIDAD_MANUAL.obtenerValorEntero();
		
		if	(	intLongitudMinimaClave	<	1)
		{
			UtilParametrosSistema.getInstance().excepcionRevizarConfiguracionParametrosSistema	(	EnumParametrosSistema.LONGITUD_MINIMA_CLAVE_SEGURIDAD_MANUAL	);
		}
		
		if	(	intLongitudMaximaClave	<	1)
		{
			UtilParametrosSistema.getInstance().excepcionRevizarConfiguracionParametrosSistema	(	EnumParametrosSistema.LONGITUD_MAXIMA_CLAVE_SEGURIDAD_MANUAL	);
		}
		
		if	(	intLongitudMaximaClave	<	intLongitudMinimaClave)
		{
			UtilParametrosSistema.getInstance().excepcionRevizarConfiguracionParametrosSistema	(	EnumParametrosSistema.LONGITUD_MINIMA_CLAVE_SEGURIDAD_MANUAL,
																									EnumParametrosSistema.LONGITUD_MAXIMA_CLAVE_SEGURIDAD_MANUAL
																								);
		}
		
		this.setIntLongitudMinimaClave(intLongitudMinimaClave);
		this.setIntLongitudMaximaClave(intLongitudMaximaClave);
	}
	
	/**
	 * @method getIntLongitudMinimaClave
	 * 		   Metodo get del atributo intLongitudMinimaClave
	 * @return int
	 *		   Valor del atributo intLongitudMinimaClave devuelto
	 * @author hector.cuenca
	 * @date   2/03/2016
	 */
	public int getIntLongitudMinimaClave() {
		return this.intLongitudMinimaClave;
	}

	/**
	 * @method setIntLongitudMinimaClave
	 * 		   Metodo set del atributo intLongitudMinimaClave
	 * @param  pIntLongitudMinimaClave
	 *		   Valor que tomara el atributo intLongitudMinimaClave
	 * @author hector.cuenca
	 * @date   2/03/2016
	 */
	public void setIntLongitudMinimaClave(int pIntLongitudMinimaClave) {
		this.intLongitudMinimaClave = pIntLongitudMinimaClave;
	}

	/**
	 * @method getIntLongitudMaximaClave
	 * 		   Metodo get del atributo intLongitudMaximaClave
	 * @return int
	 *		   Valor del atributo intLongitudMaximaClave devuelto
	 * @author hector.cuenca
	 * @date   2/03/2016
	 */
	public int getIntLongitudMaximaClave() {
		return this.intLongitudMaximaClave;
	}

	/**
	 * @method setIntLongitudMaximaClave
	 * 		   Metodo set del atributo intLongitudMaximaClave
	 * @param  pIntLongitudMaximaClave
	 *		   Valor que tomara el atributo intLongitudMaximaClave
	 * @author hector.cuenca
	 * @date   2/03/2016
	 */
	public void setIntLongitudMaximaClave(int pIntLongitudMaximaClave) {
		this.intLongitudMaximaClave = pIntLongitudMaximaClave;
	}
	
}

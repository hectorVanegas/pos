package co.com.codesa.clienteposslimgiros.enumeraciones.biometria.internacional;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Dedo;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Mano;

/** 
 * ********************************************************************
 * @class  	EnumManosInternacional
 *		   	Clase que contiene las constantes de enumeracion que permiten
 *			administrar las diferentes manos con su descripcion.
 *			Elaborada para el proceso de biometria en funcionalidad de giros
 *			internacionales
 * @author 	roberth.martinez
 * @date   	13/02/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public enum EnumManosInternacional {
	
	/**
	 * @variable	DERECHA
	 * 				Constante que representa la mano derecha
	 */
	DERECHA("D", EnumEtiquetas.TTL_MANO_DERECHA),
	
	/**
	 * @variable	IZQUIERDA
	 * 				Constante que representa la mano izquierda
	 */
	IZQUIERDA("I", EnumEtiquetas.TTL_MANO_IZQUIERDA),
	;
	
	/**
	 * @variable strTipoMano
	 * 			 Identifica el tipo de mano
	 */
	private String strTipoMano;
	
	/**
	 * @variable enmDescripcionMano
	 * 			 Descripcion del tipo de mano
	 */
	private EnumEtiquetas enmDescripcionMano;
	
	/** 
	 * ********************************************************************
	 * @method EnumManosInternacional
	 * 		   Inicializacion de la constante de enumeracion
	 * @param  pStrTipoMano
	 * 		   Identifica el tipo de mano
	 * @param  pStrDescripcionMano
	 * 		   Descripcion del tipo de mano
	 * @author roberth.martinez
	 * @date   13/02/2018
	 * *********************************************************************
	 */
	private EnumManosInternacional(String pStrTipoMano, EnumEtiquetas pStrDescripcionMano) {
		this.setStrTipoMano(pStrTipoMano);
		this.setEnmDescripcionMano(pStrDescripcionMano);
	}
	
	@Override
	public String toString() {
		return this.getEnmDescripcionMano().toString();
	};
	
	/**
	 * @method getStrTipoMano
	 * 		   Metodo get del atributo strTipoMano
	 * @return String
	 *		   Valor del atributo strTipoMano devuelto
	 * @author roberth.martinez
	 * @date   13/02/2018
	 */
	public String getStrTipoMano() {
		return strTipoMano;
	}

	/**
	 * @method setStrTipoDedo
	 * 		   Metodo set del atributo strTipoMano
	 * @param  strTipoMano
	 *		   Valor que tomara el atributo strTipoMano
	 * @author roberth.martinez
	 * @date   13/02/2018
	 */
	public void setStrTipoMano(String strTipoMano) {
		this.strTipoMano = strTipoMano;
	}

	/**
	 * @method getEnmDescripcionMano
	 * 		   Metodo get del atributo enmDescripcionMano
	 * @return EnumEtiquetas
	 *		   Valor del atributo enmDescripcionMano devuelto
	 * @author roberth.martinez
	 * @date   13/02/2018
	 */
	public EnumEtiquetas getEnmDescripcionMano() {
		return enmDescripcionMano;
	}

	/**
	 * @method setEnmDescripcionMano
	 * 		   Metodo set del atributo enmDescripcionMano
	 * @param  pStrDescripcionMano
	 *		   Valor que tomara el atributo enmDescripcionMano
	 * @author roberth.martinez
	 * @date   13/02/2018
	 */
	public void setEnmDescripcionMano(EnumEtiquetas pStrDescripcionMano) {
		this.enmDescripcionMano = pStrDescripcionMano;
	}
	
	

}

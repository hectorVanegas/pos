package co.com.codesa.clienteposslimgiros.enumeraciones.biometria.internacional;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;

/** 
 * ********************************************************************
 * @class  	EnumDedosInternacional
 *		   	Clase que contiene las constantes de enumeracion que permiten
 *			administrar los diferentes dedos con su descripcion
 *			Elaborada para el proceso de biometria en funcionalidad de giros
 *			internacionales
 * @author 	roberth.martinez
 * @date   	13/02/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public enum EnumDedosInternacional {
	
	/**
	 * @variable	PULGAR
	 * 				Constante que representa el dedo pulgar
	 */
	PULGAR("P", EnumEtiquetas.TTL_DEDO_PULGAR),
	
	/**
	 * @variable	INDICE
	 * 				Constante que representa el dedo indice
	 */
	INDICE("I", EnumEtiquetas.TTL_DEDO_INDICE),
	
	/**
	 * @variable	CORAZON
	 * 				Constante que representa el dedo corazon
	 */
	CORAZON("M", EnumEtiquetas.TTL_DEDO_CORAZON),
	
	/**
	 * @variable	ANULAR
	 * 				Constante que representa el dedo anular
	 */
	ANULAR("A", EnumEtiquetas.TTL_DEDO_ANULAR),
	
	/**
	 * @variable	MENIQUE
	 * 				Constante que representa el dedo menique
	 */
	MENIQUE("C", EnumEtiquetas.TTL_DEDO_MENIQUE),
	;
	
	/**
	 * @variable strTipoDedo
	 * 			 Identifica el tipo de dedo
	 */
	private String strTipoDedo;
	
	/**
	 * @variable enmDescripcionDedo
	 * 			 Descripcion del tipo de dedo
	 */
	private EnumEtiquetas enmDescripcionDedo;
	
	/** 
	 * ********************************************************************
	 * @method EnumDedosInternacional
	 * 		   Inicializacion de la constante de enumeracion
	 * @param  pStrTipoDedo
	 * 		   Identifica el tipo de dedo
	 * @param  pStrDescripcionDedo
	 * 		   Descripcion del tipo de dedo
	 * @author roberth.martinez
	 * @date   13/02/2018
	 * *********************************************************************
	 */
	private EnumDedosInternacional(String pStrTipoDedo, EnumEtiquetas pStrDescripcionDedo) {
		this.setStrTipoDedo(pStrTipoDedo);
		this.setEnmDescripcionDedo(pStrDescripcionDedo);
	}

	@Override
	public String toString() {
		return this.getEnmDescripcionDedo().toString();
	};
	
	/**
	 * @method getStrTipoDedo
	 * 		   Metodo get del atributo strTipoDedo
	 * @return String
	 *		   Valor del atributo strTipoDedo devuelto
	 * @author roberth.martinez
	 * @date   13/02/2018
	 */
	public String getStrTipoDedo() {
		return strTipoDedo;
	}

	/**
	 * @method setStrTipoDedo
	 * 		   Metodo set del atributo strTipoDedo
	 * @param  strTipoDedo
	 *		   Valor que tomara el atributo strTipoDedo
	 * @author roberth.martinez
	 * @date   13/02/2018
	 */
	public void setStrTipoDedo(String strTipoDedo) {
		this.strTipoDedo = strTipoDedo;
	}

	/**
	 * @method getStrDescripcionDedo
	 * 		   Metodo get del atributo enmDescripcionDedo
	 * @return EnumEtiquetas
	 *		   Valor del atributo enmDescripcionDedo devuelto
	 * @author roberth.martinez
	 * @date   13/02/2018
	 */
	public EnumEtiquetas getEnmDescripcionDedo() {
		return enmDescripcionDedo;
	}

	/**
	 * @method setStrDescripcionDedo
	 * 		   Metodo set del atributo enmDescripcionDedo
	 * @param  pStrDescripcionDedo
	 *		   Valor que tomara el atributo enmDescripcionDedo
	 * @author roberth.martinez
	 * @date   13/02/2018
	 */
	public void setEnmDescripcionDedo(EnumEtiquetas pStrDescripcionDedo) {
		this.enmDescripcionDedo = pStrDescripcionDedo;
	}

}

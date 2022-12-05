package co.com.codesa.clienteposslimgiros.enumeraciones.impresion;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;

/** 
 * ********************************************************************
 * @class	EnumTiposImpresion
 *		 	Enumerador con los tipos de Impresion
 * @author	roberth.martinez
 * @date  	1/11/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public enum EnumTiposImpresion {
	
	/**
	 * @variable	POR_PIN
	 * 				tipo impresion por pin o referencia
	 */
	POR_PIN(EnumEtiquetas.TTL_RMP_CMB_TIPO_REIMPRESION_X_PIN),
	
	/**
	 * @variable	ULTIMA_TRANSACCION
	 * 				tipo impresion por ultima transaccion
	 */
	ULTIMA_TRANSACCION(EnumEtiquetas.TTL_RMP_CMB_TIPO_REIMPRESION_ULTIMA_TRANSACCION),
	
	/**
	 * @variable	OTROS
	 * 				tipo impresion otros
	 */
	OTROS(EnumEtiquetas.TTL_RMP_CMB_TIPO_REIMPRESION_OTRAS)
	
	;
	
	
	/**
	 * @variable	enmTitulo
	 * 				Enumerador de etiquetas con el titulo del tipo de impresion
	 */
	private EnumEtiquetas enmTitulo;
	
	/**
	 * ********************************************************************
	 * @method	EnumTiposImpresion
	 * 		  	Constructor del enumerador
	 * @param 	pEnmTitulo
	 * 			enumerador con el titulo del tipo impresion
	 * @author	roberth.martinez
	 * @date	1/11/2018
	 * *********************************************************************
	 */
	private EnumTiposImpresion(EnumEtiquetas pEnmTitulo) {
		this.setEnmTitulo(pEnmTitulo);
	}

	/**
	 * @method	getEnmTitulo
	 * 		  	Metodo get del atributo enmTitulo
	 * @return	EnumEtiquetas
	 *		  	Valor del atributo enmTitulo devuelto
	 * @author	roberth.martinez
	 * @date  	1/11/2018
	 */
	public EnumEtiquetas getEnmTitulo() {
		return enmTitulo;
	}

	/**
	 * @method	setEnmTitulo
	 * 		  	Metodo set del atributo enmTitulo
	 * @param	pEnmTitulo
	 * 			Valor que tomara el atributo enmTitulo
	 * @author	roberth.martinez
	 * @date	1/11/2018
	 */
	public void setEnmTitulo(EnumEtiquetas pEnmTitulo) {
		this.enmTitulo = pEnmTitulo;
	}

}

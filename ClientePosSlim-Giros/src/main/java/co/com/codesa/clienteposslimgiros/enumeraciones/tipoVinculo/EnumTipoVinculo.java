package co.com.codesa.clienteposslimgiros.enumeraciones.tipoVinculo;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;

/** 
 * ********************************************************************
 * @class  	EnumTipoVinculo
 *		   	Clase que contiene las constantes de enumeracion que permiten
 *			administrar los diferentes tipos de vinculo con su descripcion.
 *			Elaborada para el proceso de operaciones inusuales en funcionalidad de giros
 *			internacionales
 * @author 	didier.silva
 * @date   	26/05/2018
 * @copyright Copyright 1998-2018 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public enum EnumTipoVinculo {
	
	/**
	 * @variable	TIPO_VINCULO_1
	 * 				Constante que representa primer tipo de vinculo
	 */
	TIPO_VINCULO_1(1, EnumEtiquetas.TTL_TIPO_VINCULO_1),
	
	/**
	 * @variable	TIPO_VINCULO_2
	 * 				Constante que representa segundo tipo de vinculo
	 */
	TIPO_VINCULO_2(2, EnumEtiquetas.TTL_TIPO_VINCULO_2),
	
	/**
	 * @variable	TIPO_VINCULO_3
	 * 				Constante que representa tercer tipo de vinculo
	 */
	TIPO_VINCULO_3(3, EnumEtiquetas.TTL_TIPO_VINCULO_3),
	
	/**
	 * @variable	TIPO_VINCULO_4
	 * 				Constante que representa cuarto tipo de vinculo
	 */
	TIPO_VINCULO_4(4, EnumEtiquetas.TTL_TIPO_VINCULO_4),
	
	/**
	 * @variable	TIPO_VINCULO_5
	 * 				Constante que representa quinto tipo de vinculo
	 */
	TIPO_VINCULO_5(5, EnumEtiquetas.TTL_TIPO_VINCULO_5),
	
	/**
	 * @variable	TIPO_VINCULO_6
	 * 				Constante que representa sexto tipo de vinculo
	 */
	TIPO_VINCULO_6(6, EnumEtiquetas.TTL_TIPO_VINCULO_6),
	
	/**
	 * @variable	TIPO_VINCULO_7
	 * 				Constante que representa septimo tipo de vinculo
	 */
	TIPO_VINCULO_7(7, EnumEtiquetas.TTL_TIPO_VINCULO_7),
	
	/**
	 * @variable	TIPO_VINCULO_8
	 * 				Constante que representa octavo tipo de vinculo
	 */
	TIPO_VINCULO_8(8, EnumEtiquetas.TTL_TIPO_VINCULO_8),
	
	/**
	 * @variable	TIPO_VINCULO_9
	 * 				Constante que representa noveno tipo de vinculo
	 */
	TIPO_VINCULO_9(9, EnumEtiquetas.TTL_TIPO_VINCULO_9),
	
	/**
	 * @variable	TIPO_VINCULO_10
	 * 				Constante que representa decimo tipo de vinculo
	 */
	TIPO_VINCULO_10(10, EnumEtiquetas.TTL_TIPO_VINCULO_10),
	
	/**
	 * @variable	TIPO_VINCULO_11
	 * 				Constante que representa once tipo de vinculo
	 */
	TIPO_VINCULO_11(11, EnumEtiquetas.TTL_TIPO_VINCULO_11),
	
	/**
	 * @variable	TIPO_VINCULO_12
	 * 				Constante que representa doce tipo de vinculo
	 */
	TIPO_VINCULO_12(12, EnumEtiquetas.TTL_TIPO_VINCULO_12),
	
	/**
	 * @variable	TIPO_VINCULO_13
	 * 				Constante que representa trece tipo de vinculo
	 */
	TIPO_VINCULO_13(13, EnumEtiquetas.TTL_TIPO_VINCULO_13),
	
	/**
	 * @variable	TIPO_VINCULO_14
	 * 				Constante que representa catorce tipo de vinculo
	 */
	TIPO_VINCULO_14(14, EnumEtiquetas.TTL_TIPO_VINCULO_14),
	;
	
	/**
	 * @variable intNumeroTipoVinculo
	 * 			 Identifica el tipo de vinculo para la operacion inusual
	 */
	private int intNumeroTipoVinculo;
	
	/**
	 * @variable enmDescripcionTipoVinculo
	 * 			 Descripcion para el tipo de vinculo
	 */
	private EnumEtiquetas enmDescripcionTipoVinculo;
	
	private EnumTipoVinculo(int pIntNumeroTipoVinculo,
							EnumEtiquetas pEnmDescripcionTipoVinculo){
		
		this.intNumeroTipoVinculo = pIntNumeroTipoVinculo;
		this.enmDescripcionTipoVinculo = pEnmDescripcionTipoVinculo;
		
	}

	public int getIntNumeroTipoVinculo() {
		return intNumeroTipoVinculo;
	}

	public void setIntNumeroTipoVinculo(int pIntNumeroTipoVinculo) {
		this.intNumeroTipoVinculo = pIntNumeroTipoVinculo;
	}

	public EnumEtiquetas getEnmDescripcionTipoVinculo() {
		return enmDescripcionTipoVinculo;
	}

	public void setEnmDescripcionTipoVinculo(EnumEtiquetas pEnmDescripcionTipoVinculo) {
		this.enmDescripcionTipoVinculo = pEnmDescripcionTipoVinculo;
	}

}

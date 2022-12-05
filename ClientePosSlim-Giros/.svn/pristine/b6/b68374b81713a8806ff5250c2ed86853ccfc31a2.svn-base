package co.com.codesa.clienteposslimgiros.enumeraciones.monedaInternacional;

import org.apache.axis.constants.Enum;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;

/** 
 * ********************************************************************
 * @class  	EnumMonedaInternacional
 *		   	Clase que contiene las constantes de enumeracion que permiten
 *			administrar las monedas internacionales con su descripcion.
 *			Elaborada para el proceso de operaciones inusuales en funcionalidad de giros
 *			internacionales
 * @author 	didier.silva
 * @date   	25/05/2018
 * @copyright Copyright 1998-2018 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public enum EnumMonedaInternacional {
	
	/**
	 * @variable	MONEDA_DOLARES
	 * 				Constante que representa la moneda dolar
	 */
	MONEDA_DOLARES(2, EnumEtiquetas.TTL_MONEDA_DOLARES),
	
	/**
	 * @variable	MONEDA_PESOS_COLOMBIANOS
	 * 				Constante que representa la moneda pesos colombianos
	 */
	MONEDA_PESOS_COLOMBIANOS(1, EnumEtiquetas.TTL_MONEDA_PESOS_COLOMBIANOS),
	;
	
	/**
	 * @variable intNumeroMoneda
	 * 			 Identifica la moneda para la operacion inusual
	 */
	private int intNumeroMoneda;
	
	/**
	 * @variable enmDescripcionMoneda
	 * 			 Descripcion de la moneda
	 */
	private EnumEtiquetas enmDescripcionMoneda;
	
	private EnumMonedaInternacional(int pIntNumeroMoneda,
									EnumEtiquetas pEnmDescripcionMoneda){
		
		this.intNumeroMoneda = pIntNumeroMoneda;
		this.enmDescripcionMoneda = pEnmDescripcionMoneda;
		
	}
	
	@Override
	public String toString(){
		return this.getEnmDescripcionMoneda().toString();
	}

	public int getIntNumeroMoneda() {
		return intNumeroMoneda;
	}

	public void setIntNumeroMoneda(int pIntNumeroMoneda) {
		this.intNumeroMoneda = pIntNumeroMoneda;
	}

	public EnumEtiquetas getEnmDescripcionMoneda() {
		return enmDescripcionMoneda;
	}

	public void setEnmDescripcionMoneda(EnumEtiquetas pEnmDescripcionMoneda) {
		this.enmDescripcionMoneda = pEnmDescripcionMoneda;
	}

}

package co.com.codesa.clienteposslimgiros.enumeraciones.tiposEnvioInternacional;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;

/** 
 * ********************************************************************
 * @class  	EnumOpcionesEnvioInternacional
 *		   	Clase que contiene las constantes de enumeracion que permiten
 *			administrar las diferentes opciones de envio con su descripcion.
 *			Elaborada para el proceso de envio en funcionalidad de giros
 *			internacionales
 * @author 	didier.silva
 * @date   	30/04/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public enum EnumOpcionesEnvioInternacional {

	/**
	 * @variable	OPCION_1
	 * 				Constante que representa la opcion 1
	 */
	OPCION_1(1, EnumEtiquetas.TTL_OPCION_1),
	
	/**
	 * @variable	OPCION_2
	 * 				Constante que representa la opcion 2
	 */
	OPCION_2(2, EnumEtiquetas.TTL_OPCION_2),
	
	/**
	 * @variable	OPCION_3
	 * 				Constante que representa la opcion 3
	 */
	OPCION_3(3, EnumEtiquetas.TTL_OPCION_3),
	;
	
	/**
	 * @variable intNumeroOpcion
	 * 			 Identifica el tipo de opcion de envio
	 */
	private int intNumeroOpcion;
	
	/**
	 * @variable enmDescripcionOpcion
	 * 			 Descripcion de la opcion de envio
	 */
	private EnumEtiquetas enmDescripcionOpcion; 
	
	private EnumOpcionesEnvioInternacional(int pIntNumeroOpcion, EnumEtiquetas pEnmDescripcionOpcion){
		
		this.setIntNumeroOpcion(pIntNumeroOpcion);
		this.setEnmDescripcionOpcion(pEnmDescripcionOpcion);
	}
	
	@Override
	public String toString(){
		return this.getEnmDescripcionOpcion().toString();
	};

	public int getIntNumeroOpcion() {
		return intNumeroOpcion;
	}

	public void setIntNumeroOpcion(int intNumeroOpcion) {
		this.intNumeroOpcion = intNumeroOpcion;
	}

	public EnumEtiquetas getEnmDescripcionOpcion() {
		return enmDescripcionOpcion;
	}

	public void setEnmDescripcionOpcion(EnumEtiquetas enmDescripcionOpcion) {
		this.enmDescripcionOpcion = enmDescripcionOpcion;
	}
}

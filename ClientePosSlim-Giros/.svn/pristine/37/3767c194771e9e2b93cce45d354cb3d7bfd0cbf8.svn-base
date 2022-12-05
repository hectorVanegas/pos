package co.com.codesa.clienteposslimgiros.enumeraciones.productoInternacional;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;

/** 
 * ********************************************************************
 * @class  	EnumProductoInternacional
 *		   	Clase que contiene las constantes de enumeracion que permiten
 *			administrar los diferentes productos internacionales con su descripcion.
 *			Elaborada para el proceso de operaciones inusuales en funcionalidad de giros
 *			internacionales
 * @author 	didier.silva
 * @date   	25/05/2018
 * @copyright Copyright 1998-2018 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public enum EnumProductoInternacional {

	/**
	 * @variable	ENVIO_GIRO_INTERNACIONAL
	 * 				Constante que representa el producto de envio
	 */
	ENVIO_GIRO_INTERNACIONAL(2, EnumEtiquetas.TTL_ENVIO_INTERNACIONAL),
	
	/**
	 * @variable	PAGO_GIRO_INTERNACIONAL
	 * 				Constante que representa el producto de pago
	 */
	PAGO_GIRO_INTERNACIONAL(1, EnumEtiquetas.TTL_PAGO_INTERNACIONAL),
	;
	
	/**
	 * @variable intNumeroProducto
	 * 			 Identifica el producto para la operacion inusual
	 */
	private int intNumeroProducto;
	
	/**
	 * @variable enmDescripcionProducto
	 * 			 Descripcion del producto
	 */
	private EnumEtiquetas enmDescripcionProducto;
	
	private EnumProductoInternacional(int pIntNumeroProducto,
									  EnumEtiquetas pEnmDescripcionProducto){
		
		this.setIntNumeroProducto(pIntNumeroProducto);
		this.setEnmDescripcionProducto(pEnmDescripcionProducto);
		
	}
	
	@Override
	public String toString(){
		return this.getEnmDescripcionProducto().toString();
	};

	public int getIntNumeroProducto() {
		return intNumeroProducto;
	}

	public void setIntNumeroProducto(int pIntNumeroProducto) {
		this.intNumeroProducto = pIntNumeroProducto;
	}

	public EnumEtiquetas getEnmDescripcionProducto() {
		return enmDescripcionProducto;
	}

	public void setEnmDescripcionProducto(EnumEtiquetas pEnmDescripcionProducto) {
		this.enmDescripcionProducto = pEnmDescripcionProducto;
	}
}

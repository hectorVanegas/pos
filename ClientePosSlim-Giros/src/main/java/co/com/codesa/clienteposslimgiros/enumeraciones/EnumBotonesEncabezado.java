/*
 * Andres Cardenas.
 * Copyright  1998-2015 Codesa, Todos los derechos reservados.         
 */
package co.com.codesa.clienteposslimgiros.enumeraciones;


/**
 * ****************************************************************.
 * @autor: Andres Cardenas
 * @fecha: 05-mar-2015
 * @descripcion: Enumeracion que permite tener un dominio para los botones
 * del encabezado de la plantilla general. Ej. guarda,consultar,salir
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public enum EnumBotonesEncabezado {

	BTNGUARDAR("BTNGUARDAR", EnumEtiquetas.TLP_BTN_BH_CONFIRMAR,EnumImagenes.BAR_CONFIRMAR),
	BTNIMPRIMIR("BTNIMPRIMIR",EnumEtiquetas.TLP_BTN_BH_IMPRIMIR,EnumImagenes.BAR_IMPRIMIR),
	BTNCONSULTAR("BTNCONSULTAR",EnumEtiquetas.TLP_BTN_BH_CONSULTAR,EnumImagenes.BAR_CONSULTAR),
	BTNSALIR("BTNSALIR",EnumEtiquetas.TLP_BTN_BH_SALIR,EnumImagenes.BAR_CERRAR),
	BTNVOLVER("BTNVOLVER",EnumEtiquetas.TLP_BTN_BH_VOLVER,EnumImagenes.BAR_VOLVER),
	BTNOPERACION_INUSUAL("BTNOPERACION_INUSUAL",EnumEtiquetas.TLP_BTN_BH_OPERACION_INUSUAL,EnumImagenes.BAR_ANOTACIONES),
	BTN_ANULAR("BTN_ANULAR",EnumEtiquetas.TLP_BTN_BH_ANULAR,EnumImagenes.BAR_ANULAR),
	BTN_AYUDA("BTN_AYUDA",EnumEtiquetas.TLP_BTN_BH_AYUDA,EnumImagenes.BAR_AYUDA),
	BTN_LIMPIAR("BTN_LIMPIAR",EnumEtiquetas.TLP_BTN_BH_LIMPIAR,EnumImagenes.BAR_LIMPIAR)
	;
	
	private String codigo;
	private EnumEtiquetas enmEtiToolTip;
	private EnumImagenes enmImagen;

	private EnumBotonesEncabezado(String pCodigo,
								  EnumEtiquetas pEnmEtiToolTip,
								  EnumImagenes pEnmImagen){
		this.codigo = pCodigo;
		this.enmEtiToolTip = pEnmEtiToolTip;
		this.enmImagen = pEnmImagen;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public EnumEtiquetas getEnmEtiToolTip() {
		return enmEtiToolTip;
	}

	public void setEnmEtiToolTip(EnumEtiquetas enmEtiToolTip) {
		this.enmEtiToolTip = enmEtiToolTip;
	}

	public EnumImagenes getEnmImagen() {
		return enmImagen;
	}

	public void setEnmImagen(EnumImagenes enmImagen) {
		this.enmImagen = enmImagen;
	}
}

package co.com.codesa.clienteposslimgiros.enumeraciones;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 24-oct-2015
 * @Clase EnumEstadoTransaccion 
 * 		  
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public enum EnumEstadoTransaccion {
	
	VERIFICADO("verificado"),
	PIN_EXT("pinEXT"),
	MARCA_CRC("marcaCRC")
	;
	
	private String strPropiedad;
	
	private EnumEstadoTransaccion(String pStrPropiedad){
		
		this.setStrPropiedad(pStrPropiedad);
	}

	public String getStrPropiedad() {
		return strPropiedad;
	}

	public void setStrPropiedad(String strPropiedad) {
		this.strPropiedad = strPropiedad;
	}
}

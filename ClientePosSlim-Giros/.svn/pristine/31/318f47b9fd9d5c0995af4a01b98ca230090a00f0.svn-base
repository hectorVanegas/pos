package co.com.codesa.clienteposslimgiros.enumeraciones;

import co.com.codesa.clienteposslim.controladoretiquetas.ControladorEtiquetas;

public enum EnumConfiguracion{
	
	NOMBRE_IMPRESORA_GIROS_TMU(EnumParametrosApp.ID_NOMBRE_IMPRESORA_TIRILLA),
	NOMBRE_IMPRESORA_GIROS_MC(EnumParametrosApp.ID_NOMBRE_IMPRESORA_MEDIA_CARTA),
	
	DIRECCION_IP_SOCKET_RECEPTOR_INTERNACIONAL(EnumParametrosApp.IP_SOCKET_RECEPTOR_INTERNACIONAL),
	
	/**
	 * Esta propiedad ya no tiene uso, puesto que actualmente SIMS, no controla este dato
	 * por ende ya no es necesario tenerlo funcionando, se puede enviar un valor por defecto
	 * que cumpla con la especificacion de la trama, pero en SIMS este campo no validara 
	 */
	//@Deprecated
	//CODIGO_INICIAL_AGENCIA_SIMS(EnumParametrosApp.CODIGO_INICIAL_AGENCIA_SIMS),
	;
	
	private EnumParametrosApp enmParAppNombrePropiedad;
	
	private EnumConfiguracion(EnumParametrosApp pEnmParAppNombrePropiedad){
		
		this.setEnmParAppNombrePropiedad(pEnmParAppNombrePropiedad);
	}

	public String obtenerValor()throws Exception{
		
		String strValor;
		
		try{
		
			strValor	=	ControladorEtiquetas.configuracion.getString(this.getEnmParAppNombrePropiedad().getValorPropiedad());
			
		}catch(Exception e){
			
			e.printStackTrace();
			strValor	=	null;
		}
		
		return strValor;
	}
	
	public EnumParametrosApp getEnmParAppNombrePropiedad() {
		return enmParAppNombrePropiedad;
	}

	public void setEnmParAppNombrePropiedad(
			EnumParametrosApp enmParAppNombrePropiedad) {
		this.enmParAppNombrePropiedad = enmParAppNombrePropiedad;
	}
}

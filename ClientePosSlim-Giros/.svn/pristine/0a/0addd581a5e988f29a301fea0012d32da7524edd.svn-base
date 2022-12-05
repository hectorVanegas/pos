package co.com.codesa.clienteposslimgiros.dto.parametrosReimpresion;

import co.com.codesa.clienteposslimgiros.utilidades.datosAdicionales.UtilDatosAdicionales;

public class ParametrosReimpresionXPinDTO extends ParametrosReimpresionDTO{
	
	public ParametrosReimpresionXPinDTO(){
		
		super();
	}
	
	@Override
	protected void cargarDatosAdicionales()throws Exception{
		
		UtilDatosAdicionales.incorporarDatosSobre(this, 
					  							  UtilDatosAdicionales.generarPin(true));
	}
}

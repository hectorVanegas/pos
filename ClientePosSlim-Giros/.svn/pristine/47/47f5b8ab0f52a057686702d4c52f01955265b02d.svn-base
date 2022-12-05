package co.com.codesa.clienteposslimgiros.dto.parametrosReimpresion;

import co.com.codesa.clienteposslimgiros.utilidades.datosAdicionales.UtilDatosAdicionales;

public class ParametrosReimpresionXPinRemesasDTO extends ParametrosReimpresionDTO{
	
	public ParametrosReimpresionXPinRemesasDTO(){
		
		super();
	}
	
	@Override
	protected void cargarDatosAdicionales()throws Exception{
		
		UtilDatosAdicionales.incorporarDatosSobre(this, 
					  							  UtilDatosAdicionales.generarPinRemesas(true));
	}
}
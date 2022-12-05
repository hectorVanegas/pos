package co.com.codesa.clienteposslimgiros.dto.parametrosReimpresion;

import java.util.HashMap; 
import java.util.List;

import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DatoAdicional;
import co.com.codesa.codesawrappergiros.modelo.interfaces.giros.iObjetoUsaDatosAdicionales;


public class ParametrosReimpresionDTO implements iObjetoUsaDatosAdicionales{
	
	private HashMap<String,List<String>> hmLLavesDatosAdicionales;
	private HashMap<String,DatoAdicional> hmDatosAdicionales;
	
	public ParametrosReimpresionDTO(){
		
		super();
		
		this.hmDatosAdicionales = new HashMap<String,DatoAdicional>();
		this.hmLLavesDatosAdicionales = new HashMap<String,List<String>>();
		
		try{
		
			this.cargarDatosAdicionales();
			
		}catch(Exception e){
			
			UtilidadesGiros.getInstance().controlExcepcion(e, 
					   									   null);
		}
	}
	
	protected void cargarDatosAdicionales() throws Exception{}

	@Override
	public HashMap<String, DatoAdicional> getHmDatosAdicionales() {
		
		return hmDatosAdicionales;
	}

	@Override
	public void setHmDatosAdicionales(
			HashMap<String, DatoAdicional> hmDatosAdicionales) {
		
		this.hmDatosAdicionales = hmDatosAdicionales;
	}

	@Override
	public HashMap<String, List<String>> getHmLLavesDatosAdicionales() {
		return hmLLavesDatosAdicionales;
	}

	@Override
	public void setHmLLavesDatosAdicionales(
			HashMap<String, List<String>> hmLLavesDatosAdicionales) {
		
		this.hmLLavesDatosAdicionales = hmLLavesDatosAdicionales;
	}
	
}

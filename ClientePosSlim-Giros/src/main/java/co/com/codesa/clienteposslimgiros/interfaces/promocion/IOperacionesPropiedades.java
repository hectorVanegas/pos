package co.com.codesa.clienteposslimgiros.interfaces.promocion;

import java.util.HashMap;

import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Propiedad;

public interface IOperacionesPropiedades {
	
	public void adicionarPropiedades( HashMap<String,Propiedad> pHmPropiedades ) throws Exception;
	
	public void limpiarPropiedades() throws Exception;

}

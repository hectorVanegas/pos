package co.com.codesa.clienteposslimgiros.interfaces.componentesGUI;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;


public interface ComponenteGUI{
	
	/**
	 * metodos de uso comun para todas las decoraciones 
	 */
	public void setValorContenido(Object pObjeto)throws Exception;
	
	public void setToolTipText(EnumEtiquetas pEnmEtiquetas,
			   				   String ...pArrStrParametros);
}

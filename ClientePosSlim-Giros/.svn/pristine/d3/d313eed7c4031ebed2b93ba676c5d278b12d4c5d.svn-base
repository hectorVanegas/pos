package co.com.codesa.clienteposslimgiros.interfaces.componentesGUI;

import java.text.Format;

import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;


public interface PropiedadesTexto{
	
	/**
	 * Propiedad para Desplegar contenido
	 */
	public void activarDesplegarContenido(FormaGenerica pFrmPadre)throws Exception;
	public void setActivaDesplegarContenido(boolean activaDesplegarContenido);
	public boolean isActivaDesplegarContenido();
	
	/**
	 * Propiedad para formatear la presentacion del contenido
	 */
	public void setFormatoSalida(Format pFormat)throws Exception;
	public Format getFormatoSalida();
	
	/**
	 * Propiedad para controlar el ingreso
	 */
	public void setControlFormatoIngreso(String controlFormatoIngreso) throws Exception;
	public String getControlFormatoIngreso();
	
	/**
	 * Propiedad para controlar el formato final
	 */
	public boolean validaFormatoFinal(boolean pBooGeneraExcepcion,
									  String pStrDescripcionCampo)throws Exception;
	
	public void setControlFormatoFinal(String controlFormatoFinal) throws Exception;
	public String getControlFormatoFinal();
	
	/**
	 * Propiedad para formatear ingreso a mayusculas o minusculas
	 */
	public void setActivaMayusculaMinuscula(Boolean activaMayusculaMinuscula);
}

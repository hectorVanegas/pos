package co.com.codesa.clienteposslimgiros.interfaces.componentesGUI;

/**
 * ********************************************************************
 * @class	ComponenteGUITexto
 *		 	Interface que representa los comportamientos que describen
 *			un componente de texto decorado (CajaTextoUtil, AreaTextoUtil,
 *			entre otros)
 * @author	hector.cuenca
 * @date  	28/03/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public interface ComponenteGUITexto{
	
	/**
	 * ********************************************************************
	 * @method	getPropiedades
	 * 		  	Metodo que recupera las propiedades adicionales implementadas
	 * 			a nivel de los componentes de texto
	 * @return	PropiedadesTexto
	 * 			propiedades adicionales implementadas a nivel de los 
	 * 			componentes de texto
	 * @author	hector.cuenca
	 * @date	28/03/2018
	 * *********************************************************************
	 */
	public PropiedadesTexto getPropiedades();
}

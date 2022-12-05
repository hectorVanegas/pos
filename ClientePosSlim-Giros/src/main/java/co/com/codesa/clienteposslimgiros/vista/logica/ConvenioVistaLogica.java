/** 
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
package co.com.codesa.clienteposslimgiros.vista.logica;

public class ConvenioVistaLogica {

	private static ConvenioVistaLogica instancia;
	
	private ConvenioVistaLogica(){}	
	
	public static ConvenioVistaLogica getInstance(){
	
		if (instancia == null){
			instancia= new ConvenioVistaLogica();
		}
			
		return instancia;
	}
}

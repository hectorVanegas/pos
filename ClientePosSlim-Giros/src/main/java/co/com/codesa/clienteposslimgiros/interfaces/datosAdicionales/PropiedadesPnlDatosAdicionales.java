package co.com.codesa.clienteposslimgiros.interfaces.datosAdicionales;

import co.com.codesa.codesawrappergiros.modelo.interfaces.giros.iObjetoUsaDatosAdicionales;


public interface PropiedadesPnlDatosAdicionales{
	
	/**
  	 * ****************************************************************.
  	 * @metodo mostrarDatosAdicionales
  	 * 		   Permite vincular los datos adicionales de un objeto que
  	 * 		   usa estos, sobre la grilla
  	 * @param pObjUsaDatosAdicionales
  	 * 		  Objeto al cual se le vincularan sus datos adicionales 
  	 * 		  sobre la grilla
  	 * @param pBooCargarValoresEnBlanco
  	 * 		  Bandera que identifica si la vinculacion de datos adicionales
  	 * 		  se cargara con sus valores en blanco para diligenciar o
  	 * 		  se cargara con los valores que ya han sido diligenciados
  	 * 		  (true y false respectivamente) 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void mostrarDatosAdicionales(iObjetoUsaDatosAdicionales pObjUsaDatosAdicionales,
										boolean pBooCargarValoresEnBlanco)throws Exception;
	
	/**
  	 * ****************************************************************.
  	 * @metodo validarObligatoriedadDatosAdicionales
  	 * 		   Permite validar la obligatoriedad de los datos adicionales
  	 * 		   vinculados a la grilla, ideal para una operacion de 
  	 * 		   confirmacion de operacion
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void validarDatosAdicionalesIngresados()throws Exception;
}

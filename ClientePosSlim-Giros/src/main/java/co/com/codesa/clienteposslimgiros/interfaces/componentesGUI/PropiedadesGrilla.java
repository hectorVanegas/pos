package co.com.codesa.clienteposslimgiros.interfaces.componentesGUI;


public interface PropiedadesGrilla{
	
	/**
	 * Propiedad para activar un filtro de registros sobre la grilla, segun una cadena dada
	 */
	public void aplicarFiltroSimple(String pStrCadena, 
  	  	    						int pIntColumna)throws Exception;
	
	/**
	 * Propiedad para activar un filtro de registros sobre la grilla, segun una expresion regular dada
	 */
	public void aplicarFiltroExpresion(String pStrFormato, 
		   		   					   int pIntColumna)throws Exception;
	
	public void reiniciarFiltros()
			throws Exception;
	
	public void removerFilaGrilla(int pIntFila)throws Exception;
	
	public void limpiarGrilla()throws Exception;
	
	public void adicionarFilasGrilla(Object filas[][])throws Exception;
	
	public void adicionarFilaGrilla(Object fila[])throws Exception;
	
	public void detectarRegistroGrilla(int pIntFila,
			   						   int pIntColumna)throws Exception;
}

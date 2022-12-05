package co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumTiposImpresora;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumVariablesImpresion;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.VariablesImpresion;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionDTO;


public abstract class ProcesarVariablesImpresion {

	private String strReimpresion;
	private VariablesImpresion objVariablesImpresion;
	private boolean booReimpresion;
	private EnumTiposImpresora enmTipoImpresion;
	
	public ProcesarVariablesImpresion(boolean pBooEsReimpresion,
									  EnumTiposImpresora pEnmTipoImpresion)throws Exception{
		
		this.booReimpresion = pBooEsReimpresion;
		
		this.strReimpresion = pBooEsReimpresion?EnumParametrosApp.ID_REIMPRESION.getObjConstante():null;
		
		this.setEnmTipoImpresion(pEnmTipoImpresion);
		
		this.objVariablesImpresion = new VariablesImpresion(EnumParametrosApp.CNST_IMPR_SEPARADOR.getValorPropiedad(),
				   									   		EnumParametrosApp.CNST_IMPR_IGUAL.getValorPropiedad(),
				   									   	    pBooEsReimpresion);
		
		this.objVariablesImpresion.getHmVariables().put(EnumVariablesImpresion.TIPO_REIMPRESION.getNombre(), this.strReimpresion);
	}

	/**
	 * ********************************************************************
	 * @method obtenerVariablesImpresion
	 * 		   Metodo que permite obtener el listado de variables construido
	 * 		   para el proceso de impresion
	 * @param  pObjDtoVariablesImpresion
	 * 		   Objeto DTO que contiene los valores de negocio de interes a 
	 * 		   tener en cuenta como variables de impresion
	 * @return VariablesImpresion
	 * 		   Listado de variables de impresion
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   18/10/2016
	 * *********************************************************************
	 */
	public abstract VariablesImpresion obtenerVariablesImpresion(VariablesImpresionDTO pObjDtoVariablesImpresion)throws Exception;
	
	/**
	 * ********************************************************************
	 * @method adicionarVariable
	 * 		   Metodo que permite adicionar una nueva variable al proceso
	 * 		   de impresion
	 * @param  pEnmVariableImpresion
	 * 		   Constante de enumeracion que representa la variable de impresion 
	 * 		   a adicionar
	 * @param  pObjValor
	 * 		   Valor asociado a la variable de impresion
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   18/10/2016
	 * *********************************************************************
	 */
	public void adicionarVariable	(	EnumVariablesImpresion pEnmVariableImpresion,
										Object pObjValor
									)	throws	Exception{
		
		this.getObjVariablesImpresion().getHmVariables().put	(	pEnmVariableImpresion.getNombre(),
																	pObjValor
																);
	}
	
	/**
	 * ********************************************************************
	 * @method modificarVariable
	 * 		   Metodo que permite modificar el valor de una variable de 
	 * 		   impresion
	 * @param  pEnmVariableImpresion
	 * 		   Constante de enumeracion que representa la variable de impresion
	 * 		   que sera modificada
	 * @param  pObjValor
	 * 		   Nuevo valor que tendra la variable de impresion 
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   18/10/2016
	 * *********************************************************************
	 */
	public void modificarVariable	(	EnumVariablesImpresion pEnmVariableImpresion,
										Object pObjValor
									)	throws	Exception{
		
		if	(	this.getObjVariablesImpresion().getHmVariables().containsKey(	pEnmVariableImpresion.getNombre()	)	){
		
			this.eliminarVariable(pEnmVariableImpresion);
			this.adicionarVariable	(	pEnmVariableImpresion,
										pObjValor
									);
		}
	}
	
	/**
	 * ********************************************************************
	 * @method eliminarVariable
	 * 		   Metodo que permite eliminar una variable del proceso de 
	 * 		   impresion
	 * @param  pEnmVariableImpresion
	 * 		   Constante de enumeracion que representa la variable de impresion
	 * 		   que sera eliminada
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   18/10/2016
	 * *********************************************************************
	 */
	public void eliminarVariable(	EnumVariablesImpresion pEnmVariableImpresion	)	throws	Exception{
		
		this.getObjVariablesImpresion().getHmVariables().remove(pEnmVariableImpresion.getNombre());
	}

	/**
	 * @method getStrReimpresion
	 * 		   Metodo get del atributo strReimpresion
	 * @return String
	 *		   Valor del atributo strReimpresion devuelto
	 * @author hector.cuenca
	 * @date   18/10/2016
	 */
	public String getStrReimpresion() {
		return this.strReimpresion;
	}

	/**
	 * @method setStrReimpresion
	 * 		   Metodo set del atributo strReimpresion
	 * @param  pStrReimpresion
	 *		   Valor que tomara el atributo strReimpresion
	 * @author hector.cuenca
	 * @date   18/10/2016
	 */
	public void setStrReimpresion(String pStrReimpresion) {
		this.strReimpresion = pStrReimpresion;
	}

	/**
	 * @method getObjVariablesImpresion
	 * 		   Metodo get del atributo objVariablesImpresion
	 * @return VariablesImpresion
	 *		   Valor del atributo objVariablesImpresion devuelto
	 * @author hector.cuenca
	 * @date   18/10/2016
	 */
	public VariablesImpresion getObjVariablesImpresion() {
		return this.objVariablesImpresion;
	}

	/**
	 * @method setObjVariablesImpresion
	 * 		   Metodo set del atributo objVariablesImpresion
	 * @param  pObjVariablesImpresion
	 *		   Valor que tomara el atributo objVariablesImpresion
	 * @author hector.cuenca
	 * @date   18/10/2016
	 */
	public void setObjVariablesImpresion(VariablesImpresion pObjVariablesImpresion) {
		this.objVariablesImpresion = pObjVariablesImpresion;
	}

	/**
	 * @method isBooReimpresion
	 * 		   Metodo get del atributo booReimpresion
	 * @return boolean
	 *		   Valor del atributo booReimpresion devuelto
	 * @author hector.cuenca
	 * @date   18/10/2016
	 */
	public boolean isBooReimpresion() {
		return this.booReimpresion;
	}

	/**
	 * @method setBooReimpresion
	 * 		   Metodo set del atributo booReimpresion
	 * @param  pBooReimpresion
	 *		   Valor que tomara el atributo booReimpresion
	 * @author hector.cuenca
	 * @date   18/10/2016
	 */
	public void setBooReimpresion(boolean pBooReimpresion) {
		this.booReimpresion = pBooReimpresion;
	}

	/**
	 * @method getEnmTipoImpresion
	 * 		   Metodo get del atributo enmTipoImpresion
	 * @return EnumTiposImpresiones
	 *		   Valor del atributo enmTipoImpresion devuelto
	 * @author hector.cuenca
	 * @date   18/10/2016
	 */
	public EnumTiposImpresora getEnmTipoImpresion() {
		return this.enmTipoImpresion;
	}

	/**
	 * @method setEnmTipoImpresion
	 * 		   Metodo set del atributo enmTipoImpresion
	 * @param  pEnmTipoImpresion
	 *		   Valor que tomara el atributo enmTipoImpresion
	 * @author hector.cuenca
	 * @date   18/10/2016
	 */
	public void setEnmTipoImpresion(EnumTiposImpresora pEnmTipoImpresion) {
		this.enmTipoImpresion = pEnmTipoImpresion;
	}
	
	
}

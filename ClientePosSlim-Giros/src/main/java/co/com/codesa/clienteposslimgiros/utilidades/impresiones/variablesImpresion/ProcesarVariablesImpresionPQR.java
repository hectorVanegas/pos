package co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumTiposImpresora;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.VariablesImpresion;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionDTO;

/** 
 * ********************************************************************
 * @class	ProcesarVariablesImpresionPQR
 *		 	Clase ProcesarVariablesImpresionPQR
 * @author	roberth.martinez
 * @date  	2/11/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class ProcesarVariablesImpresionPQR extends ProcesarVariablesImpresion {

	/**
	 * ********************************************************************
	 * @method	ProcesarVariablesImpresionEnvioGiroInternacional
	 * 		  	contrusctor de la clase 
	 * 			ProcesarVariablesImpresionEnvioGiroInternacional
	 * @param 	pBooEsReimpresion
	 * 			Bandera que indica si es una reimpresion
	 * @param 	pEnmTipoImpresion
	 * 			indica el tipo de impresora
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author	didier.silva
	 * @date	16/05/2018
	 * *********************************************************************
	 */
	public ProcesarVariablesImpresionPQR(boolean pBooEsReimpresion,
										 EnumTiposImpresora pEnmTipoImpresion) throws Exception{
		super(pBooEsReimpresion, 
			  pEnmTipoImpresion);
	}
	
	@Override
	public VariablesImpresion obtenerVariablesImpresion(VariablesImpresionDTO pObjDtoVariablesImpresion) throws Exception {

		return super.getObjVariablesImpresion();
	}

}

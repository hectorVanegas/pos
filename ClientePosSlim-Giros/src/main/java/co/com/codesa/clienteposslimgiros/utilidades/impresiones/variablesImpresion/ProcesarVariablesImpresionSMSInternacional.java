package co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumTiposImpresora;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumVariablesImpresion;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TerceroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.VariablesImpresion;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionSMSInternacionalDTO;

/** 
 * ********************************************************************
 * @class	ProcesarVariablesImpresionSMSInternacional
 *		 	Clase para procesar las variables de impresion del sms 
 *			internacional
 * @author	roberth.martinez
 * @date  	10/04/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class ProcesarVariablesImpresionSMSInternacional extends ProcesarVariablesImpresion{

	/**
	 * ********************************************************************
	 * @method	ProcesarVariablesImpresionSMSInternacional
	 * 		  	contrusctor de la clase 
	 * 			ProcesarVariablesImpresionSMSInternacional
	 * @param 	pBooEsReimpresion
	 * 			Bandera que indica si es una reimpresion
	 * @param 	pEnmTipoImpresion
	 * 			indica el tipo de impresora
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author	roberth.martinez
	 * @date	10/04/2018
	 * *********************************************************************
	 */
	public ProcesarVariablesImpresionSMSInternacional(boolean pBooEsReimpresion,
			  									      EnumTiposImpresora pEnmTipoImpresion)throws Exception{
		super(pBooEsReimpresion, 
			  pEnmTipoImpresion);
	}
	
	@Override
	public VariablesImpresion obtenerVariablesImpresion(VariablesImpresionDTO pObjDtoVariablesImpresion)throws Exception{
		
		VariablesImpresionSMSInternacionalDTO objDtoVarImpSMSPostal;
		FacturaGiroInternacional objFacturaGiro;
		TerceroInternacional objTerceroDestino;
		Usuario objusuario;
		
		objDtoVarImpSMSPostal = (VariablesImpresionSMSInternacionalDTO)pObjDtoVariablesImpresion;
		
		objusuario 			=	objDtoVarImpSMSPostal.getObjUsuario();
		objFacturaGiro 		= 	objDtoVarImpSMSPostal.getObjFacturaGiro();
		objTerceroDestino 	= 	objFacturaGiro.getTerceroDestino();
		
		
		super.adicionarVariable(EnumVariablesImpresion.PIN_SEGURO, objFacturaGiro.getFacturaSeguro().getPin());
		super.adicionarVariable(EnumVariablesImpresion.FECHA, objFacturaGiro.getFechaTransaccion());
		super.adicionarVariable(EnumVariablesImpresion.AGENCIA_ORIGEN, objusuario.getAgencia().getNombre());
		super.adicionarVariable(EnumVariablesImpresion.TELEFONO_BENEFICIARIO, objTerceroDestino.getTelefono1());
		
		return super.getObjVariablesImpresion();
	}
	
}

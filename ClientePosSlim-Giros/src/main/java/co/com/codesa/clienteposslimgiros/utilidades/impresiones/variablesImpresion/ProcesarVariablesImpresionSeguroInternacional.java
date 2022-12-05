package co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumTiposImpresora;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumVariablesImpresion;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TerceroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.VariablesImpresion;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionSeguroInternacionalDTO;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

/** 
 * ********************************************************************
 * @class	ProcesarVariablesImpresionSeguroInternacional
 *		 	Clase para procesar las variables de impresion del seguro 
 *			internacional
 * @author	roberth.martinez
 * @date  	09/04/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class ProcesarVariablesImpresionSeguroInternacional extends ProcesarVariablesImpresion{

	/**
	 * ********************************************************************
	 * @method	ProcesarVariablesImpresionSeguroInternacional
	 * 		  	contrusctor de la clase 
	 * 			ProcesarVariablesImpresionSeguroInternacional
	 * @param 	pBooEsReimpresion
	 * 			Bandera que indica si es una reimpresion
	 * @param 	pEnmTipoImpresion
	 * 			indica el tipo de impresora
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author	roberth.martinez
	 * @date	9/04/2018
	 * *********************************************************************
	 */
	public ProcesarVariablesImpresionSeguroInternacional(boolean pBooEsReimpresion,
			  									    	 EnumTiposImpresora pEnmTipoImpresion)throws Exception{
		super(pBooEsReimpresion, 
			  pEnmTipoImpresion);
	}
	
	@Override
	public VariablesImpresion obtenerVariablesImpresion(VariablesImpresionDTO pObjDtoVariablesImpresion)throws Exception{
		
		VariablesImpresionSeguroInternacionalDTO objDtoVarImpPagoGiroPostal;
		FacturaGiroInternacional objFacturaGiro;
		TerceroInternacional objTerceroDestino;
		Usuario objusuario;
		
		objDtoVarImpPagoGiroPostal = (VariablesImpresionSeguroInternacionalDTO)pObjDtoVariablesImpresion;
		
		objusuario 			=	objDtoVarImpPagoGiroPostal.getObjUsuario();
		objFacturaGiro 		= 	objDtoVarImpPagoGiroPostal.getObjFacturaGiro();
		objTerceroDestino 	= 	objFacturaGiro.getTerceroDestino();
		
		
		super.adicionarVariable(EnumVariablesImpresion.PIN_SEGURO, objFacturaGiro.getFacturaSeguro().getPin());
		super.adicionarVariable(EnumVariablesImpresion.FECHA, objFacturaGiro.getFechaTransaccion());
		super.adicionarVariable(EnumVariablesImpresion.NOMBRE_ASEGURADO, objTerceroDestino.toString());
		super.adicionarVariable(EnumVariablesImpresion.CEDULA_ASEGURADO, objTerceroDestino.getIdentificacion());
		super.adicionarVariable(EnumVariablesImpresion.CEDULA_REMITENTE, objTerceroDestino.getIdentificacion());
		super.adicionarVariable(EnumVariablesImpresion.VALOR_PRIMA, UtilidadGiros.getInstancia().formatoPresentacionNumero(objFacturaGiro.getDouValorPrima()));
		super.adicionarVariable(EnumVariablesImpresion.VALOR_ASEGURADO, UtilidadGiros.getInstancia().formatoPresentacionNumero(objFacturaGiro.getFacturaSeguro().getValorAsegurado()));
		super.adicionarVariable(EnumVariablesImpresion.LOGIN_CAJERO, objusuario.getLogin());
		
		return super.getObjVariablesImpresion();
	}
	
}

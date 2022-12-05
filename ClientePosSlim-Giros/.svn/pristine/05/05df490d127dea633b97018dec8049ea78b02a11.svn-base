package co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumTiposImpresora;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumVariablesImpresion;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.integracion.slimGiros.UtilIntegracionSlimGiros;
import co.com.codesa.clienteposslimgiros.utilidades.validaciones.ValidacionesSuperCombo;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Empresa;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaSeguro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.SuperCombo;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.VariablesImpresion;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionSeguroDTO;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

/** 
 * ********************************************************************
 * @class  ProcesarVariablesImpresionSeguro
 *		   Procesa las variables de impresion para la funcionalidad 
 *		   envio de giro
 * @author roberth.martinez
 * @date   2/12/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class ProcesarVariablesImpresionSeguro extends ProcesarVariablesImpresion{

	/** 
	 * ********************************************************************
	 * @method ProcesarVariablesImpresionSeguro
	 * 		   metodo constructor de la clase 
	 * 		   ProcesarVariablesImpresionSeguro
	 * @param  pBooEsReimpresion
	 * 		   bandera indicando si es reeimpresion
	 * @param  pEnmTipoImpresion
	 * 		   objeto enum tipo impresion indicado el tipo de impresion
	 *         TMU o MC
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   2/12/2016
	 * *********************************************************************
	 */
	public ProcesarVariablesImpresionSeguro(boolean pBooEsReimpresion,
			  							    EnumTiposImpresora pEnmTipoImpresion)throws Exception{
		super(pBooEsReimpresion,
			  pEnmTipoImpresion);
	}
	
	@Override
	public VariablesImpresion obtenerVariablesImpresion(VariablesImpresionDTO pObjDtoVariablesImpresion)throws Exception{

		VariablesImpresionSeguroDTO objDtoVarImpSeguro;
		FacturaSeguro objFacturaSeguro;
		Usuario objUsuario;
		String strFechaCompleta;
		SuperCombo objSuperCombo;
		NumberFormat nfFormatoPresentacionDinero;
		String strValorPrimaPresentado;
		String strFechaTransaccionPresentada;
		String strAplicaSignoPesos;
		int intLongitudValorPresentado;
		
		objDtoVarImpSeguro = (VariablesImpresionSeguroDTO)pObjDtoVariablesImpresion;
		
		objUsuario = objDtoVarImpSeguro.getObjUsuario();
		objFacturaSeguro = objDtoVarImpSeguro.getObjFacturaSeguro();
		objSuperCombo = ValidacionesSuperCombo.getObjSuperCombo();
		strFechaCompleta = UtilidadGiros.getInstancia().getFecha(UtilIntegracionSlimGiros.getInstance().obtenerFechaHoraActualPosSlim(),UtilidadGiros.getInstancia().getFORMATEADOR_FECHA_GUION_COMPLETO());
		
		nfFormatoPresentacionDinero = NumberFormat.getNumberInstance(Locale.ENGLISH);
		nfFormatoPresentacionDinero.setMinimumFractionDigits(2);
		
		strAplicaSignoPesos = "";
		if (super.getEnmTipoImpresion().equals(EnumTiposImpresora.TIRILLA)) {
			intLongitudValorPresentado = 15;
		}else{
			intLongitudValorPresentado = 16;
		}
		
		strValorPrimaPresentado = UtilidadesGiros.getInstance().aplicarLongitudCadena	(	strAplicaSignoPesos+nfFormatoPresentacionDinero.format(objFacturaSeguro.getValorPrima()), 
																							intLongitudValorPresentado, 
																							false
																						);
		if	(	super.isBooReimpresion()	)
		{
			strFechaTransaccionPresentada = objFacturaSeguro.getFechaSeguro();
		}else{
			strFechaTransaccionPresentada = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss a").format(new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").parseObject(objFacturaSeguro.getFechaSeguro())).toLowerCase();
			strFechaTransaccionPresentada = strFechaTransaccionPresentada.replaceAll("am", "a.m.").replaceAll("pm", "p.m.");
		}
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.FECHA_SISTEMA.getNombre(), strFechaCompleta);
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_CAJERO.getNombre(), objUsuario.getLogin());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.FECHA_TRANSACCION.getNombre(), strFechaTransaccionPresentada);
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NUMERO_POLIZA.getNombre(), objSuperCombo.getStrPolizaMatriz());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.CERTIFICADO_INDIVIDUAL.getNombre(), objFacturaSeguro.getCertificadoNum());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_ASEGURADORA.getNombre(), objSuperCombo.getStrNombreAseguradora());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NIT_ASEGURADORA.getNombre(), objSuperCombo.getStrNitAseguradora());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_TOMADOR.getNombre(), objSuperCombo.getStrNombreTomador());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NIT_TOMADOR.getNombre(), objSuperCombo.getStrNitTomador());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.IDENTIFICACION_TERCERO_ORIGEN.getNombre(), objFacturaSeguro.getTerceroRemitente().getIdentificacion());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_TERCERO_ORIGEN.getNombre(), objFacturaSeguro.getTerceroRemitente().toString());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.IDENTIFICACION_ASEGURADO.getNombre(), objFacturaSeguro.getTerceroAsegurado().getIdentificacion());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_ASEGURADO.getNombre(), objFacturaSeguro.getTerceroAsegurado().toString());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.VALOR_PRIMA.getNombre(), strValorPrimaPresentado);
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.VALOR_ASEGURADO_HURTO.getNombre(), UtilidadGiros.getInstancia().formatoPresentacionDinero(objFacturaSeguro.getValorAsegurado()));
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.VALOR_TOTAL_FACTURA_SEGURO.getNombre(), UtilidadGiros.getInstancia().formatoPresentacionDinero(objFacturaSeguro.getTotal()));
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.VALOR_ASEGURADO_ACCIDENTE.getNombre(), UtilidadGiros.getInstancia().formatoPresentacionDinero(objFacturaSeguro.getValorAseguradoAccidente()));
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TELEFONOS_NACIONAL.getNombre(), objSuperCombo.getStrTelefonoNacional());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TELEFONOS_CALI.getNombre(), objSuperCombo.getStrTelefonoCali());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TELEFONOS_CELULARES.getNombre(), objSuperCombo.getStrTelefonosCelular());
		//super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.VALOR_SMS.getNombre(), objFacturaSeguro.getValorSms());
				
		return super.getObjVariablesImpresion();
	}
}
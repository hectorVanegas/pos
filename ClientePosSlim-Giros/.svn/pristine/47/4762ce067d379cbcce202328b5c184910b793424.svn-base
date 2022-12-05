package co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumTiposImpresora;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumVariablesImpresion;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGirosInternacional;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ActividadEconomicaInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Corresponsal;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ServicioPeticion;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TerceroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TipoDocumentoInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.VariablesImpresion;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionPagoGiroInternacionalDTO;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

/** 
 * ********************************************************************
 * @class	ProcesarVariablesImpresionPagoGiroInternacional
 *		 	Clase para procesar las variables de impresion del pago 
 *			de giro internacional
 * @author	roberth.martinez
 * @date  	8/04/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class ProcesarVariablesImpresionPagoGiroInternacional extends ProcesarVariablesImpresion{

	/**
	 * ********************************************************************
	 * @method	ProcesarVariablesImpresionPagoGiroInternacional
	 * 		  	contrusctor de la clase 
	 * 			ProcesarVariablesImpresionPagoGiroInternacional
	 * @param 	pBooEsReimpresion
	 * 			Bandera que indica si es una reimpresion
	 * @param 	pEnmTipoImpresion
	 * 			indica el tipo de impresora
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author	roberth.martinez
	 * @date	8/04/2018
	 * *********************************************************************
	 */
	public ProcesarVariablesImpresionPagoGiroInternacional(boolean pBooEsReimpresion,
			  									    	   EnumTiposImpresora pEnmTipoImpresion)throws Exception{
		super(pBooEsReimpresion, 
			  pEnmTipoImpresion);
	}
	
	@Override
	public VariablesImpresion obtenerVariablesImpresion(VariablesImpresionDTO pObjDtoVariablesImpresion)throws Exception{
		
		VariablesImpresionPagoGiroInternacionalDTO objDtoVarImpPagoGiroPostal;
		FacturaGiroInternacional objFacturaGiro;
		TerceroInternacional objTerceroOrigen;
		TerceroInternacional objTerceroDestino;
		ServicioPeticion objServicioPeticion;
		Usuario objUsuario;
		List<TipoDocumentoInternacional> lstTipoDocumentoInternacionals;
		List<Corresponsal> lstCorresponsales;
		List<ActividadEconomicaInternacional> lstActividadEconomicaInternacional;
		String strActividadesLicitas = "";
		int intPosicion;
		
		objDtoVarImpPagoGiroPostal = (VariablesImpresionPagoGiroInternacionalDTO)pObjDtoVariablesImpresion;
		
		objUsuario 			=	objDtoVarImpPagoGiroPostal.getObjUsuario();
		objFacturaGiro 		= 	objDtoVarImpPagoGiroPostal.getObjFacturaGiro();
		objServicioPeticion = 	objDtoVarImpPagoGiroPostal.getObjServicioPeticion();
		objTerceroOrigen 	= 	objFacturaGiro.getTerceroOrigen();
		objTerceroDestino 	= 	objFacturaGiro.getTerceroDestino();
		
		super.modificarVariable(EnumVariablesImpresion.TIPO_REIMPRESION,super.isBooReimpresion());
		
		if (objTerceroDestino.getActividadEconomica()!= null &&
				objTerceroDestino.getActividadEconomica().getCodigo() != null) {
			lstActividadEconomicaInternacional = InformacionSessionGirosInternacional.getInstance(objUsuario).getLstActividadesEconomicasInternacional();
			
			for (ActividadEconomicaInternacional actividadEconomicaInternacional : lstActividadEconomicaInternacional) {
				if(actividadEconomicaInternacional.getCodigo().equals(objTerceroDestino.getActividadEconomica().getCodigo())){
					strActividadesLicitas = actividadEconomicaInternacional.getDescripcion();
				}
			}
		}else{
			strActividadesLicitas = ".-";
		}
					
		if (objTerceroDestino.getTipoIdentificacion().getValor() == null) {
			
			lstTipoDocumentoInternacionals = InformacionSessionGirosInternacional.getInstance(objUsuario).getLstTiposDocumentosInternacional();
			intPosicion = lstTipoDocumentoInternacionals.indexOf(objTerceroDestino.getTipoIdentificacion());
			objTerceroDestino.setTipoIdentificacion(lstTipoDocumentoInternacionals.get(intPosicion));
		}
		
		if (objServicioPeticion.getStrNombre().equals("reimpresion") && objFacturaGiro.getObjCorresponsal().getStrCodigo() != null) {
			
			lstCorresponsales = InformacionSessionGirosInternacional.getInstance(objUsuario).getLstCorresponsales();
			
			for (Corresponsal corresponsal : lstCorresponsales) {
				if(corresponsal.getStrCodigo().equals(objFacturaGiro.getObjCorresponsal().getStrCodigo())){
					objFacturaGiro.getObjCorresponsal().setStrNombre(corresponsal.getStrNombre());
				   }
				}
			}
		
		if (objServicioPeticion.getStrNombre().equals("reimpresion")) {
			if (!objTerceroDestino.getActividadEconomica().getCodigo().equals(EnumGeneralidadesTramasGiros.ASTERISCO.getValor())) {
		
			lstActividadEconomicaInternacional = InformacionSessionGirosInternacional.getInstance(objUsuario).getLstActividadesEconomicasInternacional();
				
				for (ActividadEconomicaInternacional actividadEconomicaInternacional : lstActividadEconomicaInternacional) {
					if(actividadEconomicaInternacional.getCodigo().equals(objTerceroDestino.getActividadEconomica().getCodigo())){
						strActividadesLicitas = actividadEconomicaInternacional.getDescripcion();
					}
				}
			}else{
				strActividadesLicitas = ".-";
			}
		}
			
		NumberFormat nfFormatoDecimalesPagoInter;
		
		nfFormatoDecimalesPagoInter = NumberFormat.getNumberInstance(Locale.ENGLISH);
		nfFormatoDecimalesPagoInter.setMinimumFractionDigits(2);
		
		UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.IDENTIFICADOR_SUPERGIROS_FPISA);
		super.adicionarVariable(EnumVariablesImpresion.PIN_SG, objFacturaGiro.getStrNumeroConsecutivoFPISA());
		super.adicionarVariable(EnumVariablesImpresion.ACTIVIDADES_LICITAS, strActividadesLicitas);
		super.adicionarVariable(EnumVariablesImpresion.NUMERO_OPERACION, "1");
		super.adicionarVariable(EnumVariablesImpresion.OPERACION, "INGRESO");
		super.adicionarVariable(EnumVariablesImpresion.CIUDAD, objUsuario.getAgencia().getTerritorio().getNombre());
		super.adicionarVariable(EnumVariablesImpresion.OFICINA, objUsuario.getAgencia().getNombre());
		super.adicionarVariable(EnumVariablesImpresion.IPTERMINAL, objServicioPeticion.getStrLocalIp());
		super.adicionarVariable(EnumVariablesImpresion.CAJERO, objUsuario.getLogin());
		super.adicionarVariable(EnumVariablesImpresion.FECHA, objFacturaGiro.getFechaTransaccion());
		super.adicionarVariable(EnumVariablesImpresion.CENTRO_COSTO, EnumParametrosSistema.IDENTIFICADOR_SUPERGIROS_FPISA.obtenerValorCadena());
		super.adicionarVariable(EnumVariablesImpresion.CONSECUTIVO_FPISA, objFacturaGiro.getStrNumeroConsecutivoFPISA());
		super.adicionarVariable(EnumVariablesImpresion.REFERENCIA_AUXILIAR, objFacturaGiro.getStrReferenciaControlExterna());
		super.adicionarVariable(EnumVariablesImpresion.CORRESPONSAL, objFacturaGiro.getObjCorresponsal().getStrNombre());
		super.adicionarVariable(EnumVariablesImpresion.COD_CORRESPONSAL, objFacturaGiro.getObjCorresponsal().getStrCodigo());
		super.adicionarVariable(EnumVariablesImpresion.TIPO_DOC_BENEFICIARIO, objTerceroDestino.getTipoIdentificacion().getValor());
		super.adicionarVariable(EnumVariablesImpresion.NO_DOC_BENEFICIARIO, objTerceroDestino.getIdentificacion());
		super.adicionarVariable(EnumVariablesImpresion.NOMBRE_BENEFICIARIO, objTerceroDestino.toString());
		super.adicionarVariable(EnumVariablesImpresion.TELEFONO, objTerceroDestino.getTelefono1());
		super.adicionarVariable(EnumVariablesImpresion.DIRECCION, objTerceroDestino.getDireccion());
		super.adicionarVariable(EnumVariablesImpresion.CODIGO_CIUDAD, objUsuario.getAgencia().getTerritorio().getCodigo());
		super.adicionarVariable(EnumVariablesImpresion.NOMBRE_REMITENTE, objTerceroOrigen.getNombres());
		super.adicionarVariable(EnumVariablesImpresion.VALOR_PESOS, nfFormatoDecimalesPagoInter.format(objFacturaGiro.getTotal()));
		super.adicionarVariable(EnumVariablesImpresion.VALOR_PESOS_LETRAS, UtilidadGiros.getInstancia().convertNumberToLetter(objFacturaGiro.getTotal()));
		super.adicionarVariable(EnumVariablesImpresion.GMF, nfFormatoDecimalesPagoInter.format(objFacturaGiro.getDouGMF()));
		super.adicionarVariable(EnumVariablesImpresion.COSTOS, nfFormatoDecimalesPagoInter.format(Double.parseDouble(objFacturaGiro.getStrGastosAdministrativos())));
		super.adicionarVariable(EnumVariablesImpresion.IVA, "0");
		super.adicionarVariable(EnumVariablesImpresion.FATCA, " ");
		super.adicionarVariable(EnumVariablesImpresion.TIPO_CAMBIO_USD, nfFormatoDecimalesPagoInter.format(objFacturaGiro.getDouTMR()));
		super.adicionarVariable(EnumVariablesImpresion.VALOR_TOTAL_USD, objFacturaGiro.getDouValorEnDolar());
		super.adicionarVariable(EnumVariablesImpresion.NUMERAL, objFacturaGiro.getObjNumeralInternacional().getStrCodigo());
		super.adicionarVariable(EnumVariablesImpresion.VALOR_EN_USD, objFacturaGiro.getDouValorEnDolar());
		super.adicionarVariable(EnumVariablesImpresion.PAGO_REALIZADO_POR_NOMBRE_BE, objTerceroDestino.toString());
		super.adicionarVariable(EnumVariablesImpresion.REFERENCIA, objFacturaGiro.getReferenciaControl());
		
		return super.getObjVariablesImpresion();
	}
	
}

package co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion;

import java.util.List;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumTiposImpresora;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumVariablesImpresion;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGirosInternacional;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ActividadEconomicaInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ServicioPeticion;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TerceroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TipoDocumentoInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.VariablesImpresion;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionEnvioGiroInternacionalDTO;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

public class ProcesarVariablesImpresionEnvioGiroInternacional extends ProcesarVariablesImpresion {

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
	public ProcesarVariablesImpresionEnvioGiroInternacional(boolean pBooEsReimpresion,
															EnumTiposImpresora pEnmTipoImpresion) throws Exception{
		super(pBooEsReimpresion, 
			  pEnmTipoImpresion);
	}
	
	@Override
	public VariablesImpresion obtenerVariablesImpresion(VariablesImpresionDTO pObjDtoVariablesImpresion) throws Exception {
		
		VariablesImpresionEnvioGiroInternacionalDTO objDtoVarImpEnvioInternacional;
		FacturaGiroInternacional objFacturaEnvioInternacional;
		TerceroInternacional objTerceroInterOrigen;
		TerceroInternacional objTerceroInterDestino;
		ServicioPeticion objServicioPeticion;
		Usuario objUsuario;
		List<TipoDocumentoInternacional> lstTipoDocumentoInternacionals;
		List<ActividadEconomicaInternacional> lstActividadEconomicaInternacional;
		String strActividadesLicitas = "";
		int intPosicion;
		
		objDtoVarImpEnvioInternacional = (VariablesImpresionEnvioGiroInternacionalDTO) pObjDtoVariablesImpresion;
		
		objUsuario 					 = objDtoVarImpEnvioInternacional.getObjUsuario();
		objFacturaEnvioInternacional = objDtoVarImpEnvioInternacional.getObjFacturaGiro(); 
		objServicioPeticion			 = objDtoVarImpEnvioInternacional.getObjServicioPeticion();
		objTerceroInterOrigen		 = objFacturaEnvioInternacional.getTerceroOrigen();
		objTerceroInterDestino		 = objFacturaEnvioInternacional.getTerceroDestino();
		
		super.modificarVariable(EnumVariablesImpresion.TIPO_REIMPRESION,super.isBooReimpresion());
	
		if (objTerceroInterOrigen.getActividadEconomica() != null  &&
				objTerceroInterOrigen.getActividadEconomica().getCodigo() != null){
			
			lstActividadEconomicaInternacional = InformacionSessionGirosInternacional.getInstance(objUsuario).getLstActividadesEconomicasInternacional();
			
			for (ActividadEconomicaInternacional actividadEconomicaInternacional : lstActividadEconomicaInternacional) {
				if(actividadEconomicaInternacional.getCodigo().equals(objTerceroInterOrigen.getActividadEconomica().getCodigo())){
					strActividadesLicitas = actividadEconomicaInternacional.getDescripcion();
				}
			}
		}else{
			strActividadesLicitas = ".-";
		}
		
		if (objTerceroInterOrigen.getTipoIdentificacion().getValor() == null) {
			lstTipoDocumentoInternacionals = InformacionSessionGirosInternacional.getInstance(objUsuario).getLstTiposDocumentosInternacional();
			intPosicion = lstTipoDocumentoInternacionals.indexOf(objTerceroInterOrigen.getTipoIdentificacion());
			objTerceroInterOrigen.setTipoIdentificacion(lstTipoDocumentoInternacionals.get(intPosicion));
		}
		
		if (objServicioPeticion.getStrNombre().equals("reimpresion")) {
			if (!objTerceroInterOrigen.getActividadEconomica().getCodigo().equals(EnumGeneralidadesTramasGiros.ASTERISCO.getValor())) {					
			
			lstActividadEconomicaInternacional = InformacionSessionGirosInternacional.getInstance(objUsuario).getLstActividadesEconomicasInternacional();
				
				for (ActividadEconomicaInternacional actividadEconomicaInternacional : lstActividadEconomicaInternacional) {
					if(actividadEconomicaInternacional.getCodigo().equals(objTerceroInterOrigen.getActividadEconomica().getCodigo())){
						strActividadesLicitas = actividadEconomicaInternacional.getDescripcion();
					}
				}
			}else{
				strActividadesLicitas = ".-";
			}
		}
		
		UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.IDENTIFICADOR_SUPERGIROS_FPISA);
        super.adicionarVariable(EnumVariablesImpresion.PIN_SG_ENV, objFacturaEnvioInternacional.getStrNumeroConsecutivoFPISA());
        super.adicionarVariable(EnumVariablesImpresion.ACTIVIDADES_LICITAS_ENV, strActividadesLicitas);
        super.adicionarVariable(EnumVariablesImpresion.NUMERO_OPERACION_ENV, "1");
        super.adicionarVariable(EnumVariablesImpresion.OPERACION_ENV, "EGRESO");
        super.adicionarVariable(EnumVariablesImpresion.CIUDAD_ENV, objUsuario.getAgencia().getTerritorio().getNombre());
        super.adicionarVariable(EnumVariablesImpresion.OFICINA_ENV, objUsuario.getAgencia().getNombre());
        super.adicionarVariable(EnumVariablesImpresion.IPTERMINAL_ENV, objServicioPeticion.getStrLocalIp());
        super.adicionarVariable(EnumVariablesImpresion.CAJERO_ENV, objUsuario.getLogin());
        super.adicionarVariable(EnumVariablesImpresion.FECHA_ENV, objFacturaEnvioInternacional.getFechaTransaccion());
        super.adicionarVariable(EnumVariablesImpresion.CENTRO_COSTO_ENV, EnumParametrosSistema.IDENTIFICADOR_SUPERGIROS_FPISA.obtenerValorCadena());
        super.adicionarVariable(EnumVariablesImpresion.CONSECUTIVO_FPISA_ENV, objFacturaEnvioInternacional.getStrNumeroConsecutivoFPISA());
        super.adicionarVariable(EnumVariablesImpresion.REFERENCIA_AUXILIAR_ENV, objFacturaEnvioInternacional.getReferenciaControl());
        super.adicionarVariable(EnumVariablesImpresion.TIPO_DOCUMENTO_REMITENTE, objTerceroInterOrigen.getTipoIdentificacion().getValor());
        super.adicionarVariable(EnumVariablesImpresion.NUMERO_DOCUMENTO_REMITENTE, objTerceroInterOrigen.getIdentificacion());
        super.adicionarVariable(EnumVariablesImpresion.NOMBRE_RAZON_SOCIAL, objTerceroInterOrigen.toString());
        super.adicionarVariable(EnumVariablesImpresion.TELEFONO_ENV, objTerceroInterOrigen.getTelefono1());
        super.adicionarVariable(EnumVariablesImpresion.DIRECCION_ENV, objTerceroInterOrigen.getDireccion());
        super.adicionarVariable(EnumVariablesImpresion.CODIGO_CIUDAD_ENV, objUsuario.getAgencia().getTerritorio().getCodigo());
        super.adicionarVariable(EnumVariablesImpresion.VALOR_PESOS_ENV, UtilidadGiros.getInstancia().formatearABigDecimal(objFacturaEnvioInternacional.getTotal()));
        super.adicionarVariable(EnumVariablesImpresion.VALOR_PESOS_LETRAS_ENV, UtilidadGiros.getInstancia().convertNumberToLetter(objFacturaEnvioInternacional.getTotal()));
        super.adicionarVariable(EnumVariablesImpresion.GMF_ENV, "0");
        super.adicionarVariable(EnumVariablesImpresion.COSTOS_ENV, "0");
        super.adicionarVariable(EnumVariablesImpresion.IVA_ENV, "0");
        super.adicionarVariable(EnumVariablesImpresion.FATCA_ENV, "0");
        super.adicionarVariable(EnumVariablesImpresion.CODIGO_MONEDA, objFacturaEnvioInternacional.getObjTipoEnvioInternacional().getStrMonedaRecibir());
        super.adicionarVariable(EnumVariablesImpresion.VALOR_MONEDA, objFacturaEnvioInternacional.getObjTipoEnvioInternacional().getStrMontoRecibe());
        super.adicionarVariable(EnumVariablesImpresion.TIPO_CAMBIO_USD_ENV, objFacturaEnvioInternacional.getStrTMR()); 
        super.adicionarVariable(EnumVariablesImpresion.VALOR_TOTAL_USD_ENV, objFacturaEnvioInternacional.getDouValorEnDolar());
        super.adicionarVariable(EnumVariablesImpresion.NUMERAL_ENV, objFacturaEnvioInternacional.getObjNumeralInternacional().getStrCodigo());
        super.adicionarVariable(EnumVariablesImpresion.VALOR_EN_USD_ENV, objFacturaEnvioInternacional.getDouValorEnDolar());
        super.adicionarVariable(EnumVariablesImpresion.CORRESPONSAL_ENV, EnumParametrosSistema.CORRESPONSAL_ENVIO.obtenerValorCadena());
        super.adicionarVariable(EnumVariablesImpresion.NOMBRE_BENEFICIARIO_ENV, objTerceroInterDestino.getNombres());
        super.adicionarVariable(EnumVariablesImpresion.APELLIDO_BENEFICIARIO_ENV, objTerceroInterDestino.getApellido1());
        super.adicionarVariable(EnumVariablesImpresion.NOMBRES_REMITENTE, objTerceroInterOrigen.toString());
        super.adicionarVariable(EnumVariablesImpresion.CONSECUTIVO_SG, objFacturaEnvioInternacional.getStrNumeroConsecutivoSuperGiros());
		
		return super.getObjVariablesImpresion();
	}

}

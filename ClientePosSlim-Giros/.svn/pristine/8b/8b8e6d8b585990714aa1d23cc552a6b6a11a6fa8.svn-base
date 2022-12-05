package co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumTiposImpresora;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumVariablesImpresion;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.integracion.slimGiros.UtilIntegracionSlimGiros;
import co.com.codesa.clienteposslimgiros.utilidades.xml.XmlActividadesEconomicas;
import co.com.codesa.clienteposslimgiros.utilidades.xml.XmlTerritorio;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ActividadEconomica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Agencia;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Factura;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Territorio;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.VariablesImpresion;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionROEDTO;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

public class ProcesarVariablesImpresionROE extends ProcesarVariablesImpresion{

	public ProcesarVariablesImpresionROE(boolean pBooEsReimpresion,
			  						     EnumTiposImpresora pEnmTipoImpresion)throws Exception{
		super(pBooEsReimpresion,
			  pEnmTipoImpresion);
	}
	
	@Override
	public VariablesImpresion obtenerVariablesImpresion(VariablesImpresionDTO pObjDtoVariablesImpresion)throws Exception{
		
		NumberFormat nfFormatoPresentacionDinero;
		VariablesImpresionROEDTO objDtoVarImpROE;
		Factura objFactura;
		Agencia objAgenciaOrigen;
		Agencia objAgenciaDestino;
		Tercero objTercero;
		String strFechaCompleta;
		Territorio objTerrMunicipioAgenciaOrigen;
		ActividadEconomica objActividadEconomicaTercero;
		String strValorEnvioGiroPresentado;
		String strValorTotalOperacionesDiaTercero;
		
		objDtoVarImpROE = (VariablesImpresionROEDTO)pObjDtoVariablesImpresion;
		
		objFactura = objDtoVarImpROE.getObjFactura();
		objAgenciaOrigen = objFactura.getAgenciaOrigen();
		objAgenciaDestino = objFactura.getAgenciaDestino();
		
		if(objFactura.getTerceroTramitador() != null){
		
			objTercero = objFactura.getTerceroTramitador();
		}else{
			
			objTercero = objFactura.getTerceroOrigen();
		}
		
		strFechaCompleta = UtilidadGiros.getInstancia().getFecha(UtilIntegracionSlimGiros.getInstance().obtenerFechaHoraActualPosSlim(),UtilidadGiros.getInstancia().getFORMATEADOR_FECHA_GUION_COMPLETO());
		objTerrMunicipioAgenciaOrigen=XmlTerritorio.getInstance().obtenerMunicipio(objAgenciaOrigen.getTerritorio().getCodigo());
		objActividadEconomicaTercero = XmlActividadesEconomicas.getInstance().obtenerActividadEconomica(objTercero.getActividadEconomica().getCodigo());
		
		nfFormatoPresentacionDinero = NumberFormat.getNumberInstance(Locale.ENGLISH);
		nfFormatoPresentacionDinero.setMinimumFractionDigits(2);
		
		strValorEnvioGiroPresentado = nfFormatoPresentacionDinero.format(objFactura.getTotal());
		
		if (super.getEnmTipoImpresion().equals(EnumTiposImpresora.TIRILLA)) 
		{
			strValorEnvioGiroPresentado = UtilidadesGiros.getInstance().aplicarLongitudCadena	(	strValorEnvioGiroPresentado, 
																									14, 
																									false
																								);
		}
		
		strValorTotalOperacionesDiaTercero = nfFormatoPresentacionDinero.format(objFactura.getTransDia());
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.PIN_GIRO.getNombre(), objFactura.getReferenciaControl());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.FECHA_TRANSACCION.getNombre(), strFechaCompleta);
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TERRITORIO_MUNICIPIO_AGENCIA_ORIGEN.getNombre(), objTerrMunicipioAgenciaOrigen.getNombre());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_AGENCIA_ORIGEN.getNombre(), objAgenciaOrigen.getNombre());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.VALOR_ENVIO_GIRO.getNombre(), strValorEnvioGiroPresentado);
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_AGENCIA_DESTINO.getNombre(), objAgenciaDestino.getNombre());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_TERCERO.getNombre(), objTercero.toString());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.IDENTIFICACION_TERCERO.getNombre(), objTercero.getIdentificacion());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.DIRECCION_TERCERO.getNombre(), objTercero.getDireccion());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TELEFONO_TERCERO.getNombre(), objTercero.getTelefono1());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.CELULAR_TERCERO.getNombre(), objTercero.getTelefono2());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.DESCRIPCION_ACTIVIDAD_ECONOMICA_TERCERO.getNombre(),objActividadEconomicaTercero.getDescripcion());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TOTAL_OPERACIONES_DIA_TERCERO.getNombre(),strValorTotalOperacionesDiaTercero);
		
		return super.getObjVariablesImpresion();
	}	

}

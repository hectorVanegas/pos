package co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion;

import java.util.HashMap;
import java.util.List;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumTiposImpresora;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumVariablesImpresion;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Agencia;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Caja;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Concepto;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Empresa;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.IngresoXDenominacion;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.MedioPago;
import co.com.codesa.codesawrapper.modelo.dominio.ParametroSistema;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.VariablesImpresion;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.caja.arqueo.IngresosXTipoDenominacionDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionCierreCajaDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionDTO;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.giros.EnumTiposDenominacion;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

public class ProcesarVariablesImpresionCierreCaja extends ProcesarVariablesImpresion{

	public ProcesarVariablesImpresionCierreCaja(boolean pBooEsReimpresion,
			  									EnumTiposImpresora pEnmTipoImpresion)throws Exception{
		super(pBooEsReimpresion,
			  pEnmTipoImpresion);
	}
	
	@Override
	public VariablesImpresion obtenerVariablesImpresion(VariablesImpresionDTO pObjDtoVariablesImpresion)throws Exception{
		
		HashMap<String,Concepto> hmIngresosXConcepto;
		HashMap<String,Concepto> hmEgresosXConcepto;
		List<MedioPago> lstMediosPago;
		IngresosXTipoDenominacionDTO objDtoIngresosXBillete;
		IngresosXTipoDenominacionDTO objDtoIngresosXMoneda;
		IngresosXTipoDenominacionDTO objDtoIngresosXCheque;
		IngresosXTipoDenominacionDTO objDtoIngresosXVale;
		Usuario objUsuario;
		Empresa objEmpresa;
		Agencia objAgencia;
		Caja objCaja;
		String strTramaCierreIngresos;
		String strTramaCierreEgresos;
		String strTramaSaldos;
		String strTramaIngresosXBilletes;
		String strTramaIngresosXMonedas;
		String strTramaIngresosXCheques;
		String strTramaIngresosXVales;
		
		VariablesImpresionCierreCajaDTO objDtoVarImpCierreCaja;
		
		objDtoVarImpCierreCaja = (VariablesImpresionCierreCajaDTO)pObjDtoVariablesImpresion;
		
		objUsuario = objDtoVarImpCierreCaja.getObjUsuario();
		objEmpresa = objUsuario.getEmpresa();
		objAgencia = objUsuario.getAgencia();
		objCaja = objDtoVarImpCierreCaja.getObjCaja();
		lstMediosPago = objDtoVarImpCierreCaja.getLstMediosPago();
		
		objDtoIngresosXBillete = objDtoVarImpCierreCaja.getObjDtoIngresosXBillete();
		objDtoIngresosXMoneda = objDtoVarImpCierreCaja.getObjDtoIngresosXMoneda();
		objDtoIngresosXCheque = objDtoVarImpCierreCaja.getObjDtoIngresosXCheque();
		objDtoIngresosXVale = objDtoVarImpCierreCaja.getObjDtoIngresosXVale();
		
		hmIngresosXConcepto = objDtoVarImpCierreCaja.getHmIngresosXConcepto();
		hmEgresosXConcepto = objDtoVarImpCierreCaja.getHmEgresosXConcepto();
		
		strTramaCierreIngresos = this.obtenerTramaTipoMovimientoXConcepto(hmIngresosXConcepto);
		strTramaCierreEgresos = this.obtenerTramaTipoMovimientoXConcepto(hmEgresosXConcepto);
		strTramaSaldos = this.obtenerTramaSaldos(lstMediosPago);
		
		strTramaIngresosXBilletes = this.obtenerTramaIngresosXTipoDenominacion(objDtoIngresosXBillete);
		strTramaIngresosXMonedas = this.obtenerTramaIngresosXTipoDenominacion(objDtoIngresosXMoneda);
		strTramaIngresosXCheques = this.obtenerTramaIngresosXTipoDenominacion(objDtoIngresosXCheque);
		strTramaIngresosXVales = this.obtenerTramaIngresosXTipoDenominacion(objDtoIngresosXVale);
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_EMPRESA.getNombre(), objEmpresa.getNombre());
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_AGENCIA.getNombre(), objAgencia.getNombre());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_CAJERO.getNombre(), objUsuario.getLogin());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.CODIGO_CAJA.getNombre(), objCaja.getCodigo());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.FECHA_APERTURA_CAJA.getNombre(), objCaja.getFechaApertura());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.FECHA_CIERRE_CAJA.getNombre(), objCaja.getFechaCierre());
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.INGRESOS_X_CONCEPTO.getNombre(), strTramaCierreIngresos);
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.EGRESOS_X_CONCEPTO.getNombre(), strTramaCierreEgresos);
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TOTAL_SALDOS_CAJA.getNombre(), strTramaSaldos);
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.INGRESOS_X_DENOMINACION_BILLETES.getNombre(), strTramaIngresosXBilletes);
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TOTAL_INGRESOS_X_DENOMINACION_BILLETES.getNombre(), UtilidadGiros.getInstancia().formatoPresentacionDinero(objDtoIngresosXBillete.getDouTotalAportado()));
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.INGRESOS_X_DENOMINACION_MONEDAS.getNombre(), strTramaIngresosXMonedas);
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TOTAL_INGRESOS_X_DENOMINACION_MONEDAS.getNombre(), UtilidadGiros.getInstancia().formatoPresentacionDinero(objDtoIngresosXMoneda.getDouTotalAportado()));
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.INGRESOS_X_DENOMINACION_CHEQUES.getNombre(), strTramaIngresosXCheques);
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TOTAL_INGRESOS_X_DENOMINACION_CHEQUES.getNombre(), UtilidadGiros.getInstancia().formatoPresentacionDinero(objDtoIngresosXCheque.getDouTotalAportado()));
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.INGRESOS_X_DENOMINACION_VALES.getNombre(), strTramaIngresosXVales);
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TOTAL_INGRESOS_X_DENOMINACION_VALES.getNombre(), UtilidadGiros.getInstancia().formatoPresentacionDinero(objDtoIngresosXVale.getDouTotalAportado()));
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOTAS.getNombre(), objDtoVarImpCierreCaja.getStrNotas());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.FECHA_SISTEMA.getNombre(), objCaja.getFechaSistema());
		
		return super.getObjVariablesImpresion();
	}
	
	private String obtenerTramaSaldos(List<MedioPago> pLstMediosPago)throws Exception{
		
		String strTrama = null;
		double douSaldoInicial;
		double douTotalIngreso;
		double douTotalEgreso;
		double douSaldoFinal;
		
		if(pLstMediosPago!=null &&
				!pLstMediosPago.isEmpty()){
		
			douSaldoInicial = 0;
			douTotalIngreso = 0;
			douTotalEgreso = 0;
			douSaldoFinal = 0;
			
			for(MedioPago objMedioPago : pLstMediosPago){
				
				douSaldoInicial += objMedioPago.getSaldoInicial();
				douTotalIngreso += objMedioPago.getIngreso();
				douTotalEgreso += objMedioPago.getEgreso();
				douSaldoFinal += objMedioPago.getSaldoFinal();
			}
			
			strTrama = "SALDO INICIAL:"+";";
			strTrama += UtilidadGiros.getInstancia().formatoPresentacionDinero(douSaldoInicial)+";";
			strTrama += "TOTAL INGRESO:"+";";
			strTrama += UtilidadGiros.getInstancia().formatoPresentacionDinero(douTotalIngreso)+";";
			strTrama += "TOTAL EGRESO:"+";";
			strTrama += UtilidadGiros.getInstancia().formatoPresentacionDinero(douTotalEgreso)+";";
			strTrama += "SALDO FINAL:"+";";
			strTrama += UtilidadGiros.getInstancia().formatoPresentacionDinero(douSaldoFinal)+";";
		}
		
		return strTrama;
	}
	
	private String obtenerTramaTipoMovimientoXConcepto(HashMap<String,Concepto> lstCierreFacturaXTipoMovimiento)throws Exception{
		
		String strTrama = null;
		
		if(lstCierreFacturaXTipoMovimiento != null){
		
			strTrama = "";
			
			for(Concepto objCierreFactura : lstCierreFacturaXTipoMovimiento.values()){
				
				strTrama += objCierreFactura.getDescripcion()+":"+";";
				strTrama += UtilidadGiros.getInstancia().formatoPresentacionDinero(objCierreFactura.getValor())+";";
			}
		}

		return strTrama;
	}
	
	private String obtenerTramaIngresosXTipoDenominacion(IngresosXTipoDenominacionDTO pObjDtoIngresosXTipoDenominacion)throws Exception{
		
		String strTrama = null;
		ParametroSistema objParSisValeExtraBNet;
		String[] arrStrInfoValeExtraBNet;
		
		if(pObjDtoIngresosXTipoDenominacion.getHmIngresosXDenominacion () !=null){
			
			strTrama = "";
			
			objParSisValeExtraBNet	=	EnumParametrosSistema.INFORMACION_VALE_EXTRA_COMPLETAR_SALDO_SIMS.obtenerObjParametro();
			arrStrInfoValeExtraBNet	=	objParSisValeExtraBNet.getValor ().split ( "\\|" );
			
			for(IngresoXDenominacion objIngresoXDenominacion : ((HashMap<String,IngresoXDenominacion>)pObjDtoIngresosXTipoDenominacion.getHmIngresosXDenominacion().clone ()).values()){
				
				if	(	EnumTiposDenominacion.VALE.equals(objIngresoXDenominacion.getDenominacion().getTipo())	)
				{
					if	(		objIngresoXDenominacion.getNumero ().trim ().equals ( arrStrInfoValeExtraBNet[0].trim () )
							&&	objIngresoXDenominacion.getConceptoGirador ().trim ().equals ( arrStrInfoValeExtraBNet[1].trim () )	
						)
					{
						pObjDtoIngresosXTipoDenominacion.eliminarIngreso ( objIngresoXDenominacion.getIdRegistro () );
						
					}	else	{
						
						strTrama += objIngresoXDenominacion.getNumero()+";";
						strTrama += objIngresoXDenominacion.getFecha()+";";
						
						strTrama += UtilidadGiros.getInstancia().formatoPresentacionDinero(objIngresoXDenominacion.getValorAportado())+";";
					}
					
				}else if(EnumTiposDenominacion.CHEQUE.equals(objIngresoXDenominacion.getDenominacion().getTipo())){
					
					strTrama += objIngresoXDenominacion.getBanco()+";";
					strTrama += objIngresoXDenominacion.getNumero()+";";
					strTrama += UtilidadGiros.getInstancia().formatoPresentacionDinero(objIngresoXDenominacion.getValorAportado())+";";
					
				}else if(EnumTiposDenominacion.BILLETE.equals(objIngresoXDenominacion.getDenominacion().getTipo())
							||EnumTiposDenominacion.MONEDA.equals(objIngresoXDenominacion.getDenominacion().getTipo())){
					
					strTrama += UtilidadGiros.getInstancia().formatoPresentacionDinero(objIngresoXDenominacion.getDenominacion().getValorUnitario())+";";
					strTrama += objIngresoXDenominacion.getValorIngresado()+";";
					strTrama += UtilidadGiros.getInstancia().formatoPresentacionDinero(objIngresoXDenominacion.getValorAportado())+";";
				}
			}
		}
		
		return strTrama;
	}

}

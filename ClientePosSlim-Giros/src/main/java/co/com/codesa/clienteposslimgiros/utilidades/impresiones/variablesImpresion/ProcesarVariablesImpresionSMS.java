package co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumTiposImpresora;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumVariablesImpresion;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Empresa;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.VariablesImpresion;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionSMSDTO;

public class ProcesarVariablesImpresionSMS extends ProcesarVariablesImpresion{

	public ProcesarVariablesImpresionSMS(boolean pBooEsReimpresion,
			  							 EnumTiposImpresora pEnmTipoImpresion)throws Exception{
		super(pBooEsReimpresion,
			  pEnmTipoImpresion);
	}
	
	@Override
	public VariablesImpresion obtenerVariablesImpresion(VariablesImpresionDTO pObjDtoVariablesImpresion)throws Exception{
		
		//Documento objDocumento;
		VariablesImpresionSMSDTO objDtoVarImpSMS;
		FacturaGiro objFacturaGiroSMS;
		Tercero objTerceroNotificado;
		Usuario objUsuario;
		//SuperCombo objSuperCombo;
		Empresa objEmpresa;
		String strFechaTransaccionPresentada;
		
		objDtoVarImpSMS = (VariablesImpresionSMSDTO)pObjDtoVariablesImpresion;
		objFacturaGiroSMS=objDtoVarImpSMS.getObjFacturaGiroSMS();
		objTerceroNotificado=objDtoVarImpSMS.getObjTerceroNotificado();
		//objSuperCombo = ValidacionesSuperCombo.getObjSuperCombo();
		//objDocumento = objSuperCombo.getDocumentoSMS();
		objUsuario = objDtoVarImpSMS.getObjUsuario();
		objEmpresa = objUsuario.getEmpresa(); 
		
		if	(	super.isBooReimpresion()	)
		{
			strFechaTransaccionPresentada = objFacturaGiroSMS.getFechaGiro(); 
		}else{
			strFechaTransaccionPresentada = objFacturaGiroSMS.getFechaBD();
		}
		
		if (super.getEnmTipoImpresion().equals(EnumTiposImpresora.TIRILLA)) {
			super.adicionarVariable(EnumVariablesImpresion.NOMBRE_EMPRESA, objEmpresa.getNombre().substring(0, objEmpresa.getNombre().length()<15?objEmpresa.getNombre().length():15));
		}else{
			super.adicionarVariable(EnumVariablesImpresion.NOMBRE_EMPRESA, objEmpresa.getNombre());
		}
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NIT_EMPRESA.getNombre(), objEmpresa.getNit());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.DIRECCION_EMPRESA.getNombre(), objEmpresa.getDireccion());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.PAGINA_WEB_EMPRESA.getNombre(), objEmpresa.getUrl());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TELEFONO_EMPRESA.getNombre(), objEmpresa.getTelefono());
		
		//super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_REPRESENTANTE_COMERCIAL_EMPRESA.getNombre(), objEmpresa.getRcNombre());
		//super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NIT_REPRESENTANTE_COMERCIAL_EMPRESA.getNombre(), objEmpresa.getRcNit());
		//super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TELEFONO_REPRESENTANTE_COMERCIAL_EMPRESA.getNombre(), objEmpresa.getRcTelefono());
		
		//super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.ABREVIATURA_DOCUMENTO.getNombre(), objDocumento.getAbreviatura());
		//super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.INICIO_DOCUMENTO.getNombre(), objDocumento.getInicio());
		//super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.FIN_DOCUMENTO.getNombre(), objDocumento.getFin());
		//super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.RESOLUCION_DOCUMENTO.getNombre(), objDocumento.getResolucion());
		//super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_PROVEEDOR.getNombre(), objSuperCombo.getStrNombreProveedorSMS());
		//super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NIT_PROVEEDOR.getNombre(), objSuperCombo.getStrNitProveedorSMS());
		//super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.DIRECCION_PROVEEDOR.getNombre(), objSuperCombo.getStrDireccionProveedorSMS());
		//super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TELEFONO_PROVEEDOR.getNombre(), objSuperCombo.getStrTelefonoProveedorSMS());
		//super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NUMERO_FACTURA.getNombre(), objFacturaGiroSMS.getFacturaSMS().getFacturaVenta());
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_AGENCIA.getNombre(), objFacturaGiroSMS.getAgenciaOrigen());
		//super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.CODIGO_CAJA.getNombre(), objUsuario.getCaja().getCodigo());
		//super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.DIRECCION_AGENCIA.getNombre(), objFacturaGiroSMS.getAgenciaOrigen().getDireccion());
		//super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TELEFONO_AGENCIA.getNombre(), objFacturaGiroSMS.getAgenciaOrigen().getTelefonoImpr());
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.PIN_GIRO.getNombre(), objFacturaGiroSMS.getReferenciaControl());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.FECHA_TRANSACCION.getNombre(), strFechaTransaccionPresentada);
		//super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.FECHA_SISTEMA.getNombre(), objFacturaGiroSMS.getFechasys());
		/*
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_TERCERO_ORIGEN.getNombre(), objFacturaGiroSMS.getTerceroOrigen().toString());		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.IDENTIFICACION_TERCERO_ORIGEN.getNombre(), objFacturaGiroSMS.getTerceroOrigen().getIdentificacion());		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.CELULAR_TERCERO_ORIGEN.getNombre(), objFacturaGiroSMS.getTerceroOrigen().getTelefono2());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TELEFONO_TERCERO_ORIGEN.getNombre(), objFacturaGiroSMS.getTerceroOrigen().getTelefono2());
		*/
		//super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_TERCERO_DESTINO.getNombre(), objFacturaGiroSMS.getTerceroOrigen().toString());		
		//super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.IDENTIFICACION_TERCERO_DESTINO.getNombre(), objFacturaGiroSMS.getTerceroOrigen().getIdentificacion());		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.CELULAR_TERCERO_DESTINO.getNombre(), objTerceroNotificado.getTelefono2());
		//super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TELEFONO_TERCERO_DESTINO.getNombre(), objFacturaGiroSMS.getTerceroOrigen().getTelefono2());
		
		//super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.VALOR_SMS.getNombre(), UtilidadGiros.getInstancia().formatoPresentacionDinero(objFacturaGiroSMS.getFacturaSMS().getValorBase()));
		//super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.IVA_SMS.getNombre(), objFacturaGiroSMS.getFacturaSMS().getValorIVA());
		//super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TOTAL_SMS.getNombre(), UtilidadGiros.getInstancia().formatoPresentacionDinero(objFacturaGiroSMS.getFacturaSMS().getValorNeto()));
		
		//super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_CAJERO.getNombre(), objUsuario.getLogin());
	
		// NUEVOS  VALOR_SMS IVA_SMS TOTAL_SMS PIN_SMS
				
		return super.getObjVariablesImpresion();
	}
}
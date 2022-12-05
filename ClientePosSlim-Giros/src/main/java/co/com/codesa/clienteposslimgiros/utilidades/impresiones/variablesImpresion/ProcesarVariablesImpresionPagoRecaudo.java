package co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumTiposImpresora;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumVariablesImpresion;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Agencia;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Caja;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Empresa;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.VariablesImpresion;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionPagoRecaudoDTO;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

public class ProcesarVariablesImpresionPagoRecaudo extends ProcesarVariablesImpresion{

	public ProcesarVariablesImpresionPagoRecaudo(boolean pBooEsReimpresion,
			  								     EnumTiposImpresora pEnmTipoImpresion)throws Exception{
		super(pBooEsReimpresion, 
			  pEnmTipoImpresion);
	}
	
	@Override
	public VariablesImpresion obtenerVariablesImpresion(VariablesImpresionDTO pObjDtoVariablesImpresion)throws Exception{
		
		VariablesImpresionPagoRecaudoDTO objDtoVarImpPagoRecaudo;
		FacturaGiro objFacturaGiro;
		Usuario objUsuario;
		Empresa objEmpresa;
		Agencia objAgenciaOrigen;
		Agencia objAgenciaDestino;
		Agencia objAgenciaPago;
		Caja objCaja;
		Tercero objTerceroOrigen;
		Tercero objTerceroDestino;
		
		objDtoVarImpPagoRecaudo = (VariablesImpresionPagoRecaudoDTO)pObjDtoVariablesImpresion;
		
		objFacturaGiro = objDtoVarImpPagoRecaudo.getObjFacturaGiro();
		objUsuario = objDtoVarImpPagoRecaudo.getObjUsuario();
		
		objEmpresa = objUsuario.getEmpresa();
		objCaja = objUsuario.getCaja();
		objAgenciaOrigen = objFacturaGiro.getAgenciaOrigen();
		objAgenciaDestino = objFacturaGiro.getAgenciaDestino();
		objAgenciaPago = objFacturaGiro.getAgenciaPago();
		objTerceroOrigen = objFacturaGiro.getTerceroOrigen();
		objTerceroDestino = objFacturaGiro.getTerceroDestino();
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_EMPRESA.getNombre(), objEmpresa.getNombre());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NIT_EMPRESA.getNombre(), objEmpresa.getNit());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.DIRECCION_EMPRESA.getNombre(), objEmpresa.getDireccion());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.PAGINA_WEB_EMPRESA.getNombre(), objEmpresa.getUrl());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TELEFONO_EMPRESA.getNombre(), objEmpresa.getTelefono());
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_REPRESENTANTE_COMERCIAL_EMPRESA.getNombre(), objEmpresa.getRcNombre());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NIT_REPRESENTANTE_COMERCIAL_EMPRESA.getNombre(), objEmpresa.getRcNit());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TELEFONO_REPRESENTANTE_COMERCIAL_EMPRESA.getNombre(), objEmpresa.getRcTelefono());
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.PIN_RECAUDO.getNombre(), objFacturaGiro.getReferenciaControl());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.CODIGO_CAJA.getNombre(), objCaja.getCodigo());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.FECHA_TRANSACCION.getNombre(), objFacturaGiro.getFechasys());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.VALOR_PAGO.getNombre(), UtilidadGiros.getInstancia().formatoPresentacionDinero(objFacturaGiro.getTotal()));
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_AGENCIA.getNombre(), objAgenciaPago.getNombre());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.DIRECCION_AGENCIA.getNombre(), objAgenciaPago.getDireccion());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TELEFONO_AGENCIA.getNombre(), objAgenciaPago.getTelefonoImpr());
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_AGENCIA_ORIGEN.getNombre(), objAgenciaOrigen.getNombre());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.DIRECCION_AGENCIA_ORIGEN.getNombre(), objAgenciaOrigen.getDireccion());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TELEFONO_AGENCIA_ORIGEN.getNombre(), objAgenciaOrigen.getTelefonoImpr());
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_TERCERO_ORIGEN.getNombre(), objTerceroOrigen.toString());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.IDENTIFICACION_TERCERO_ORIGEN.getNombre(), objTerceroOrigen.getIdentificacion());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TELEFONO_TERCERO_ORIGEN.getNombre(), objTerceroOrigen.getTelefono1());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.CELULAR_TERCERO_ORIGEN.getNombre(), objTerceroOrigen.getTelefono2());
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_AGENCIA_DESTINO.getNombre(), objAgenciaDestino.getNombre());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.DIRECCION_AGENCIA_DESTINO.getNombre(), objAgenciaDestino.getDireccion());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TELEFONO_AGENCIA_DESTINO.getNombre(), objAgenciaDestino.getTelefonoImpr());
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_TERCERO_DESTINO.getNombre(), objTerceroDestino.toString());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.IDENTIFICACION_TERCERO_DESTINO.getNombre(), objTerceroDestino.getIdentificacion());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TELEFONO_TERCERO_DESTINO.getNombre(), objTerceroDestino.getTelefono1());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.CELULAR_TERCERO_DESTINO.getNombre(), objTerceroDestino.getTelefono2());
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_CAJERO.getNombre(), objUsuario.getLogin());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.FECHA_SISTEMA.getNombre(), objFacturaGiro.getFechaBD());
		
		return super.getObjVariablesImpresion();
	}
}

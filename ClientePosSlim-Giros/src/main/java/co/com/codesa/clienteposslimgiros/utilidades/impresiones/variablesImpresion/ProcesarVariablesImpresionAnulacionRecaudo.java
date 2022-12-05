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
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionAnulacionRecaudoDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionDTO;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

public class ProcesarVariablesImpresionAnulacionRecaudo extends ProcesarVariablesImpresion{

	public ProcesarVariablesImpresionAnulacionRecaudo(boolean pBooEsReimpresion,
													  EnumTiposImpresora pEnmTipoImpresion)throws Exception{
		super(pBooEsReimpresion,
			  pEnmTipoImpresion);
	}
	
	@Override
	public VariablesImpresion obtenerVariablesImpresion(VariablesImpresionDTO pObjDtoVariablesImpresion)throws Exception{
		
		Usuario objUsuario;
		FacturaGiro objFacturaGiro;
		Empresa objEmpresa;
		Caja objCaja;
		Agencia objAgenciaOrigen;
		Agencia objAgenciaPago;
		Tercero objTerceroOrigen;
		
		VariablesImpresionAnulacionRecaudoDTO objDtoVarImpAnulacionRecaudo;
		
		objDtoVarImpAnulacionRecaudo = (VariablesImpresionAnulacionRecaudoDTO)pObjDtoVariablesImpresion;
		
		objUsuario = objDtoVarImpAnulacionRecaudo.getObjUsuario();
		objFacturaGiro = objDtoVarImpAnulacionRecaudo.getObjFacturaGiro();
		objCaja = objUsuario.getCaja();
		
		objEmpresa = objUsuario.getEmpresa();
		objAgenciaOrigen = objFacturaGiro.getAgenciaOrigen();
		objAgenciaPago = objFacturaGiro.getAgenciaPago();
		objTerceroOrigen = objFacturaGiro.getTerceroOrigen();
		
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
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.VALOR_ENTREGADO.getNombre(), UtilidadGiros.getInstancia().formatoPresentacionDinero(objFacturaGiro.getTotal()));
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_AGENCIA_ORIGEN.getNombre(), objAgenciaOrigen.getNombre());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.DIRECCION_AGENCIA_ORIGEN.getNombre(), objAgenciaOrigen.getDireccion());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TELEFONO_AGENCIA_ORIGEN.getNombre(), objAgenciaOrigen.getTelefonoImpr());
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_AGENCIA.getNombre(), objAgenciaPago.getNombre());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.DIRECCION_AGENCIA.getNombre(), objAgenciaPago.getDireccion());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TELEFONO_AGENCIA.getNombre(), objAgenciaPago.getTelefonoImpr());
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_TERCERO_ORIGEN.getNombre(), objTerceroOrigen.toString());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.IDENTIFICACION_TERCERO_ORIGEN.getNombre(), objTerceroOrigen.getIdentificacion());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TELEFONO_TERCERO_ORIGEN.getNombre(), objTerceroOrigen.getTelefono1());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.CELULAR_TERCERO_ORIGEN.getNombre(), objTerceroOrigen.getTelefono2());
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_CAJERO.getNombre(), objUsuario.getLogin());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.FECHA_SISTEMA.getNombre(), objFacturaGiro.getFechaBD());
		
		return super.getObjVariablesImpresion();
	}
}

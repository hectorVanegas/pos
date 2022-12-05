package co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion;

import java.util.Iterator;
import java.util.List;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumTiposImpresora;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumVariablesImpresion;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Agencia;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Caja;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Concepto;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Empresa;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.VariablesImpresion;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionIngresoEgresoDTO;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

public class ProcesarVariablesImpresionIngresoEgreso extends ProcesarVariablesImpresion{

	public ProcesarVariablesImpresionIngresoEgreso(boolean pBooEsReimpresion,
			  								       EnumTiposImpresora pEnmTipoImpresion)throws Exception{
		super(pBooEsReimpresion,
			  pEnmTipoImpresion);
	}
	
	@Override
	public VariablesImpresion obtenerVariablesImpresion(VariablesImpresionDTO pObjDtoVariablesImpresion)throws Exception{
		
		VariablesImpresionIngresoEgresoDTO objDtoVarImpIngresoEgreso;		
		objDtoVarImpIngresoEgreso = (VariablesImpresionIngresoEgresoDTO)pObjDtoVariablesImpresion;
		
		Agencia objAgenciaOrigen = objDtoVarImpIngresoEgreso.getObjUsuario().getAgencia();
		Caja objCaja = objDtoVarImpIngresoEgreso.getObjUsuario().getCaja();
		Tercero objTercero = objDtoVarImpIngresoEgreso.getIngresoEgreso().getTercero();
		Empresa objEmpresa = objDtoVarImpIngresoEgreso.getObjUsuario().getEmpresa();
		
		List<Concepto> conceptos = objDtoVarImpIngresoEgreso.getIngresoEgreso().getListConceptos();

		String concepto = null;
		String valor = null;

		for (Iterator<Concepto> iter = conceptos.iterator(); iter.hasNext();) {
			Concepto element = (Concepto) iter.next();
			concepto = element.getDescripcion().toUpperCase();
			valor =UtilidadGiros.getInstancia().formatoPresentacionDinero(element.getValor());
		}
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_EMPRESA.getNombre(), objEmpresa.getNombre().toUpperCase());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NIT_EMPRESA.getNombre(), objEmpresa.getNit());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_REPRESENTANTE_COMERCIAL_EMPRESA.getNombre(), objEmpresa.getRcNombre());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NIT_REPRESENTANTE_COMERCIAL_EMPRESA.getNombre(), objEmpresa.getRcNit());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TITULO_IMPRESION.getNombre(), objDtoVarImpIngresoEgreso.getIngresoEgreso().getTipo().toUpperCase());
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_AGENCIA_ORIGEN.getNombre(), objAgenciaOrigen.getNombre());
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.DESCRIPCION_CAJA.getNombre(), objCaja.getDescripcion().toUpperCase());
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.REFERENCIA.getNombre(), objDtoVarImpIngresoEgreso.getIngresoEgreso().getRefControl());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.FECHA_TRANSACCION.getNombre(), objDtoVarImpIngresoEgreso.getIngresoEgreso().getFechaReg());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.FECHA_SISTEMA.getNombre(), objDtoVarImpIngresoEgreso.getIngresoEgreso().getFechaBD());
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.DESCRIPCION_CONCEPTO.getNombre(), concepto);
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.VALOR_CONCEPTO.getNombre(), valor);
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.DOCUMENTO_AUXILIAR.getNombre(), objDtoVarImpIngresoEgreso.getIngresoEgreso().getDocAux());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOTAS.getNombre(), objDtoVarImpIngresoEgreso.getIngresoEgreso().getNotas());
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_TERCERO.getNombre(), objTercero.toString());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.IDENTIFICACION_TERCERO.getNombre(), objTercero.getIdentificacion());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TELEFONO_TERCERO.getNombre(), objTercero.getTelefono1());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.CELULAR_TERCERO.getNombre(), objTercero.getTelefono2());
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_CAJERO.getNombre(), objDtoVarImpIngresoEgreso.getObjUsuario().getLogin());
		
		return super.getObjVariablesImpresion();
	}
}

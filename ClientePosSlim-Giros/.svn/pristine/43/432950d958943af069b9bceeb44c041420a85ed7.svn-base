package co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion;

import java.util.Date;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumTiposImpresora;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumVariablesImpresion;
import co.com.codesa.clienteposslimgiros.utilidades.integracion.slimGiros.UtilIntegracionSlimGiros;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.VariablesImpresion;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionPruebaDTO;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

public class ProcesarVariablesImpresionPrueba extends ProcesarVariablesImpresion{

	public ProcesarVariablesImpresionPrueba(boolean pBooEsReimpresion,
			  							    EnumTiposImpresora pEnmTipoImpresion)throws Exception{
		super(pBooEsReimpresion, 
			  pEnmTipoImpresion);
	}
	
	@Override
	public VariablesImpresion obtenerVariablesImpresion(VariablesImpresionDTO pObjDtoVariablesImpresion)throws Exception{
		
		VariablesImpresionPruebaDTO objDtoVarImpPrueba;
		Usuario objusuario;
		String strFechaCompleta;
		
		objDtoVarImpPrueba = (VariablesImpresionPruebaDTO)pObjDtoVariablesImpresion;
		
		objusuario = objDtoVarImpPrueba.getObjUsuario();
		
		strFechaCompleta = UtilidadGiros.getInstancia().getFecha(UtilIntegracionSlimGiros.getInstance().obtenerFechaHoraActualPosSlim(),UtilidadGiros.getInstancia().getFORMATEADOR_FECHA_GUION_COMPLETO());
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.FECHA_SISTEMA.getNombre(), strFechaCompleta);
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_CAJERO.getNombre(), objusuario.getLogin());
				
		return super.getObjVariablesImpresion();
	}
}
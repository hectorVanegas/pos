package co.com.codesa.clienteposslimgiros.dto.impresion;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumTiposImpresora;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.VariablesImpresion;

public class ResultadoImpresion {

	private EnumTiposImpresora enmTipoImpresora;
	private VariablesImpresion objVariablesImpresion;
	private String strCadenaImpresion;
	private boolean booReimpresion;
	private boolean booImprimio;
	
	public ResultadoImpresion(EnumTiposImpresora pEnmTipoImpresora,
							  VariablesImpresion pObjVariablesImpresion,
							  String pStrCadenaImpresion,
							  boolean pBooReimpresion,
							  boolean pBooImprimio)throws Exception{
		super();
		
		this.setEnmTipoImpresora(pEnmTipoImpresora);
		this.setObjVariablesImpresion(pObjVariablesImpresion);
		this.setStrCadenaImpresion(pStrCadenaImpresion);
		this.setBooReimpresion(pBooReimpresion);
		this.setBooImprimio(pBooImprimio);
	}
	
	public void notificar(EnumMensajes pEnmMensaje)throws Exception{
		
		
	}
	
	public boolean isBooImprimio() {
		return booImprimio;
	}

	public void setBooImprimio(boolean booImprimio) {
		this.booImprimio = booImprimio;
	}

	public EnumTiposImpresora getEnmTipoImpresora() {
		return enmTipoImpresora;
	}

	public void setEnmTipoImpresora(EnumTiposImpresora enmTipoImpresora) {
		this.enmTipoImpresora = enmTipoImpresora;
	}

	public VariablesImpresion getObjVariablesImpresion() {
		return objVariablesImpresion;
	}

	public void setObjVariablesImpresion(VariablesImpresion objVariablesImpresion) {
		this.objVariablesImpresion = objVariablesImpresion;
	}

	public String getStrCadenaImpresion() {
		return strCadenaImpresion;
	}

	public void setStrCadenaImpresion(String strCadenaImpresion) {
		this.strCadenaImpresion = strCadenaImpresion;
	}

	public boolean isBooReimpresion() {
		return booReimpresion;
	}

	public void setBooReimpresion(boolean booReimpresion) {
		this.booReimpresion = booReimpresion;
	}
}

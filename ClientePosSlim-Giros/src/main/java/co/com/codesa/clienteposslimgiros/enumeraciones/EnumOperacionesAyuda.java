package co.com.codesa.clienteposslimgiros.enumeraciones;

import java.util.ArrayList;
import java.util.List;

import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionUtil;
import co.com.codesa.clienteposslimgiros.utilidades.ayudas.operaciones.OperacionAyuda;
import co.com.codesa.clienteposslimgiros.utilidades.ayudas.operaciones.OperacionAyudaSuperCombo;

public enum EnumOperacionesAyuda {
	
	//SuperCOMBO
	SUPER_COMBO(EnumEtiquetas.TTL_AYU_SCB_OPERACION_SUPER_COMBO,
				OperacionAyudaSuperCombo.class),
	;
	
	private EnumEtiquetas enmEtiqueta;
	
	private Class<? extends OperacionAyuda> clsOperacionAyuda;
	
	private OperacionAyuda objOperacionAyuda;
	
	private int arrIntFiltroIdSecciones[];
	
	private EnumOperacionesAyuda(EnumEtiquetas pEnmEtiqueta,
								 Class<? extends OperacionAyuda> pClsOperacionAyuda){
		
		this.setEnmEtiqueta(pEnmEtiqueta);
		this.setClsOperacionAyuda(pClsOperacionAyuda);
	}

	public List<SeccionUtil> obtenerSeccionesAyuda()throws Exception{
		
		List<SeccionUtil> lstSeccionesXAyuda;
		
		lstSeccionesXAyuda = null;
		
		if(this.objOperacionAyuda==null){
		
			this.objOperacionAyuda = this.getClsOperacionAyuda().newInstance();
		}
		
		if(this.objOperacionAyuda!=null){
		
			if(this.validarFiltro()){
				
				lstSeccionesXAyuda = this.aplicarFiltro();
				
			}else{
				
				lstSeccionesXAyuda = this.objOperacionAyuda.getLstListadoSecciones();
			}
		}
		
		return lstSeccionesXAyuda;
	}

	private boolean validarFiltro()throws Exception{
		
		boolean booAplicaFiltro;
		
		if(this.objOperacionAyuda!=null
				&& !this.objOperacionAyuda.getLstListadoSecciones().isEmpty()
				&& this.arrIntFiltroIdSecciones!=null){
			
			booAplicaFiltro = true;
			
		}else{
			
			booAplicaFiltro = false;
		}
		
		return booAplicaFiltro;
	}
	
	private List<SeccionUtil> aplicarFiltro()throws Exception{
		
		List<SeccionUtil> lstSeccionesFiltradas; 
		
		lstSeccionesFiltradas = new ArrayList<SeccionUtil>();
		
		for(int intFiltroIdSeccion : this.arrIntFiltroIdSecciones){
			
			lstSeccionesFiltradas.add(this.objOperacionAyuda.getLstListadoSecciones().get(intFiltroIdSeccion));
		}
		
		this.arrIntFiltroIdSecciones = null;
				
		return lstSeccionesFiltradas;
	}
	
	public void filtrarSeccionesXId(int ...pArrIntFiltroIdSecciones)throws Exception{
		
		this.arrIntFiltroIdSecciones = pArrIntFiltroIdSecciones;
	}
	
	@Override
	public String toString() {
		
		return EnumEtiquetas.TTL_AYU_SCB_OPERACION_SUPER_COMBO.getValor(false);
	};

	public OperacionAyuda getObjOperacionAyuda() {
		return objOperacionAyuda;
	}

	public void setObjOperacionAyuda(OperacionAyuda objOperacionAyuda) {
		this.objOperacionAyuda = objOperacionAyuda;
	}
	
	public EnumEtiquetas getEnmEtiqueta() {
		return enmEtiqueta;
	}

	public void setEnmEtiqueta(EnumEtiquetas enmEtiqueta) {
		this.enmEtiqueta = enmEtiqueta;
	}

	public Class<? extends OperacionAyuda> getClsOperacionAyuda() {
		return clsOperacionAyuda;
	}

	public void setClsOperacionAyuda(
			Class<? extends OperacionAyuda> clsOperacionAyuda) {
		this.clsOperacionAyuda = clsOperacionAyuda;
	}
}

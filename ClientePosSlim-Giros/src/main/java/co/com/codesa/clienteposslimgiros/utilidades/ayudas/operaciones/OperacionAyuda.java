package co.com.codesa.clienteposslimgiros.utilidades.ayudas.operaciones;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionUtil;

public abstract class OperacionAyuda {

	private List<SeccionUtil> lstListadoSecciones;
	private Border brdBordeSeccionAyuda;
	
	public OperacionAyuda()throws Exception{
		
		super();
		this.brdBordeSeccionAyuda = BorderFactory.createEmptyBorder();
		this.lstListadoSecciones = new ArrayList<SeccionUtil>();
	}

	public void adicionar(SeccionUtil pSeccionAyuda)throws Exception{
		
		if(pSeccionAyuda!=null){
		
			pSeccionAyuda.setBorder(this.brdBordeSeccionAyuda);
		}
		
		this.lstListadoSecciones.add(pSeccionAyuda);
	}
	
	public List<SeccionUtil> getLstListadoSecciones(){
		return lstListadoSecciones;
	}

	public void setLstListadoSecciones(List<SeccionUtil> lstListadoSecciones) {
		this.lstListadoSecciones = lstListadoSecciones;
	}
}

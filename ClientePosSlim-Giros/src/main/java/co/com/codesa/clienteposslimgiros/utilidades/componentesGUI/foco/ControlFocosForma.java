package co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.foco;

import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.util.ArrayList;
import java.util.List;

public class ControlFocosForma extends FocusTraversalPolicy {
	
    private List<Component> lstComponentes;
    private Component objCmpDefecto;
    
    public ControlFocosForma()throws Exception{
    	
    	this.lstComponentes = new ArrayList<Component>();
    }

    @Override
    public Component getComponentAfter(Container focusCycleRoot,
    								   Component aComponent) {
    	
    	int idx;
    	
    	idx = (this.lstComponentes.indexOf(aComponent) + 1) % this.lstComponentes.size();
    	
    	return this.lstComponentes.get(idx);
    }
    
    @Override
    public Component getComponentBefore(Container focusCycleRoot,
    									Component aComponent) {
    	
    	int idx;
    	
    	idx = this.lstComponentes.indexOf(aComponent) - 1;
      
    	if (idx < 0) {
    		
    		idx = this.lstComponentes.size() - 1;
    	}
    	
      	return this.lstComponentes.get(idx);
    }

    @Override
    public Component getDefaultComponent(Container focusCycleRoot) {
    	
    	Component objCmpDefecto;
    	
    	if(this.objCmpDefecto == null){
    		
    		objCmpDefecto = this.lstComponentes.get(0);
    		
    	}else{
    	
    		objCmpDefecto = this.objCmpDefecto;
    	}
    	
    	return objCmpDefecto;
    }

    @Override
    public Component getLastComponent(Container focusCycleRoot) {
    	
    	Component objCmpUltimo;
    	
    	if(this.lstComponentes.isEmpty()){
    		
    		objCmpUltimo = null;
    		
    	}else{
    		
    		objCmpUltimo = this.lstComponentes.get(this.lstComponentes.size()-1);
    	}
    	
    	return objCmpUltimo;
    }

    @Override
    public Component getFirstComponent(Container focusCycleRoot) {
    	
    	Component objCmpPrimero;
    	
    	if(this.lstComponentes.isEmpty()){
    		
    		objCmpPrimero = null;
    		
    	}else{
    		
    		objCmpPrimero = this.lstComponentes.get(0);
    	}
    	
    	return objCmpPrimero;
    }

	public List<Component> getLstComponentes() {
		return lstComponentes;
	}

	public void setLstComponentes(List<Component> lstComponentes) {
		this.lstComponentes = lstComponentes;
	}

	public Component getObjCmpDefecto() {
		return objCmpDefecto;
	}

	public void setObjCmpDefecto(Component objCmpDefecto) {
		this.objCmpDefecto = objCmpDefecto;
	}

 }

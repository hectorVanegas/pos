/**
 * 
 */
package co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.posicionamiento;

import java.awt.Component;
import java.awt.LayoutManager;


public interface LayoutManagerAbsoluto extends LayoutManager,Cloneable {

	public abstract Object getConstraints( Component comp );
    public abstract void setConstraints( Component comp,Object cons );
    public abstract Object clone();	
}

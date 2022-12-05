package co.com.codesa.clienteposslimgiros.eventos.componentesGUI;

import java.awt.AWTEvent;
import java.awt.Component;
import javax.swing.JToggleButton;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.PropiedadesBandera;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 05-dic-2015 
 * @clase EventoCompBanderaUtil
 * 		  Clase encargada de controlar los eventos de un componente 
 * 		  de tipo JToogleButton (JCheckBox [], JRadioButton O, JToogleButton [] [])
 * @copyright Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class EventoCompBanderaUtil extends EventoAbstracto implements PropiedadesBandera{
	
	/**
	 * @variable cmpBandera
	 * 			 referente al componente de tipo bandera (doble estado) del cual 
	 * 			 se estan controlando los eventos
	 **/
	private JToggleButton cmpBandera;
	
	/**
  	 * ****************************************************************.
  	 * @metodo EventoCompBanderaUtil
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de sus acciones
  	 * @param pComponente
  	 * 		  referencia al componente de texto del cual se estan 
  	 * 		  controlando los eventos
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EventoCompBanderaUtil(JToggleButton pCmpBandera) throws Exception{
		
		this.cmpBandera = pCmpBandera;
	}

	@Override
	public void accionarEjecucion(Component pComponent, AWTEvent pEvtEjecucion)throws Exception {
		
		if(pComponent.equals(this.cmpBandera)){
			
			this.cmpBandera.setSelected(!this.cmpBandera.isSelected());
			
		}else{
		
			super.accionarEjecucion(pComponent, pEvtEjecucion);
		}
	}
	
}

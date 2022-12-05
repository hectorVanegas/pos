/*
 * Andres Cardenas.
 * Copyright  1998-2015 Codesa, Todos los derechos reservados.         
 */
package co.com.codesa.clienteposslimgiros.eventos.principal;

import java.awt.AWTEvent;
import java.awt.Component;
import javax.swing.JFrame;
import co.com.codesa.clienteposslim.vista.logica.AccordionVistaLogica;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.principal.FormaInicioGiros;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGiros;

/**
 * ****************************************************************.
 * @autor: Andres Cardenas
 * @fecha: 10-mar-2015
 * @descripcion: Clase que administra los eventos de la forma llamada
 * FormaInicioGiros
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class EventoFormaInicioGiro  extends EventoAbstracto{

	private FormaInicioGiros formaInicioGiro;	


	public EventoFormaInicioGiro(FormaInicioGiros pFormaPadre){
		this.formaInicioGiro=pFormaPadre;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo accionarEjecucion
  	 * 			Metodo utilizado para centralizar y desacoplar las 
  	 * 			acciones de ejecucion (Enter o confirmar con raton) de 
  	 * 			los eventos 
  	 * @param pComponent 
  	 * 		  Componente grafico por el cual se produce el evento que 
  	 * 		  activa la ejecucion
  	 * @param pEvtEjecucion
  	 * 			Evento AWTEvent.Se usa debido a que el método es usado por diferentes listener
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public void accionarEjecucion(Component pComponent,
								  AWTEvent pEvtEjecucion) throws Exception {
		
		AccordionVistaLogica accordionVistaLogica;
		Class objClsClaseCargar;
		String strNombreClaseInstanciar;
		boolean booExisteClave;
		
		booExisteClave = InformacionSessionGiros.getInstance().getHtMenu().containsKey(pComponent.getName());
		
		if(booExisteClave){
			
			strNombreClaseInstanciar = InformacionSessionGiros.getInstance().getHtMenu().get(pComponent.getName());
			
			objClsClaseCargar=Class.forName(strNombreClaseInstanciar);
			
			objClsClaseCargar.getDeclaredConstructor(JFrame.class,
			   		 								 boolean.class).newInstance(this.formaInicioGiro.getFrmPrincipal()/*getAccordionPanel().getPrincipal()*/,
			   		 										 					true);
		}
		//TODO LIMPIAR
		/*if(pComponent.getName().equals("btnVolver")){
			
			accordionVistaLogica = new AccordionVistaLogica();
			accordionVistaLogica.seleccionaTabAccordion(InformacionSession.ACCORDION_SECUNDARIO, 
														formaInicioGiro.getAccordionPanel().getPrincipal());
			accordionVistaLogica=null;
		}*/
	}
}

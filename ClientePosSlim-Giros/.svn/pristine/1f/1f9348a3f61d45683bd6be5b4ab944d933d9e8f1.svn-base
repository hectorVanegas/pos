package co.com.codesa.clienteposslimgiros.eventos.componentesGUI;

import java.awt.AWTEvent;
import java.awt.Component;

import javax.swing.Timer;

import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.PropiedadesEtiqueta;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 18-jun-2015 
 * @clase EventoCompGrillaUtil
 * 		  Clase encargada de controlar los eventos de un componente de 
 * 		  grilla
 * @copyright Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class EventoCompEtiquetaUtil extends EventoAbstracto implements PropiedadesEtiqueta{
	
	private EtiquetaUtil cmpEtiqueta;
	private boolean booActivarDesplazamientoAutomatico;
	private String strTextoDesplazado;
	private String strTextoOriginal;
	private Timer objTimer;
	
	public EventoCompEtiquetaUtil(EtiquetaUtil pComponente) throws Exception{
		
		this.setCmpEtiqueta(pComponente);
		
		this.inicializarPropiedades();
	}
	
	private void inicializarPropiedades()throws Exception{
		
		this.booActivarDesplazamientoAutomatico = false;
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
	@Override
	public void accionarEjecucion(Component pComponent,
								  AWTEvent pEvtEjecucion) throws Exception {
		
		char firstChar;
		
		if(this.booActivarDesplazamientoAutomatico){
			
			firstChar  = this.strTextoDesplazado.charAt(0);
			this.strTextoDesplazado = this.strTextoDesplazado.substring( 1, this.strTextoDesplazado.length() ) + firstChar;
			this.cmpEtiqueta.setTextOriginal(this.strTextoDesplazado,false);
		}
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void activarDesplazamientoAutomatico()throws Exception{
		
		long lonLongitudEspacios;
		
		this.booActivarDesplazamientoAutomatico = true;
		
		if(this.strTextoDesplazado == null){
			this.setStrTextoDesplazado(this.cmpEtiqueta.getText());
		}
		
		/**
		 * [TODO Q-en-K: deducir la relacion, proporcion o metrica que existe entre el tipo de letra (Font)
		 * y el tamaño que se reserva para el caracter espacio (" "), dentro de un JLabel], de momento la 
		 * relacion toma el valor de 3.0, ideal para el tipo de fuente predefinida y establecida para el
		 * aplicativo de POS
		 */
		lonLongitudEspacios = (long)Math.ceil(this.cmpEtiqueta.getSize().getWidth()/3.0);
		
		this.strTextoDesplazado = String.format("%1$"+lonLongitudEspacios+"s",
											    "")+this.strTextoDesplazado;
		
		if(this.objTimer == null){
			
			this.objTimer = new Timer(200,
    				  				  this);

			this.objTimer.start();
		}else{
			
			this.objTimer.restart();
		}
	}
	
	@Override
	public void detenerDesplazamientoAutomatico()throws Exception{
		
		this.booActivarDesplazamientoAutomatico = false;
		this.objTimer.stop();
	}
	
	public EtiquetaUtil getCmpEtiqueta() {
		return cmpEtiqueta;
	}

	public void setCmpEtiqueta(EtiquetaUtil cmpEtiqueta) {
		this.cmpEtiqueta = cmpEtiqueta;
	}

	public boolean isBooActivarDesplazamientoAutomatico() {
		return booActivarDesplazamientoAutomatico;
	}

	public void setBooActivarDesplazamientoAutomatico(
			boolean booActivarDesplazamientoAutomatico) {
		this.booActivarDesplazamientoAutomatico = booActivarDesplazamientoAutomatico;
	}

	public String getStrTextoDesplazado() {
		return strTextoDesplazado;
	}

	public void setStrTextoDesplazado(String strTextoDesplazado) {
		
		this.strTextoDesplazado = strTextoDesplazado;
		this.strTextoOriginal = this.strTextoDesplazado; 
	}

	public String getStrTextoOriginal() {
		return strTextoOriginal;
	}

	public void setStrTextoOriginal(String strTextoOriginal) {
		this.strTextoOriginal = strTextoOriginal;
	}
}

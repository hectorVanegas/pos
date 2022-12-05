package co.com.codesa.clienteposslimgiros.eventos.mensajes;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.mensajes.FormaMensajeAlerta;
import co.com.codesa.clienteposslimgiros.utilidades.mensajes.Mensaje;

/**
 * ****************************************************************.
 * @autor: Hector Q-en-K
 * @fecha: 25-mar-2015 
 * @descripcion: Clase encargada de controlar los eventos de la 
 * 				 frmMensajeAlerta para alertar mensajes
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class EventoFormaMensajeAlerta extends EventoAbstracto{
	
	private Mensaje mensaje;
	
	/**
  	 * ****************************************************************.
  	 * @metodo: EventoFormaMensajeAlerta (Constructor)
  	 * @descripcion: Constructor que ejecuta la inicializacion de valores 
  	 * 				 y ejecucion de comportamientos inicales requeridos 
  	 * 				 para el despliegue de sus acciones
  	 * @param pForma: referencia a la GUI de la cual se estan controlando 
  	 * 		  los eventos
  	 * @param pMensaje: objeto mensaje que se materializara en pantalla
  	 * @throws Exception: Controla, recupera y escala, cualquier tipo de 
  	 * 		   excepcion presentada 
  	 * @autor: Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EventoFormaMensajeAlerta(FormaGenerica pForma,
									Mensaje pMensaje) throws Exception{
		super(pForma);
		this.mensaje = pMensaje;
	}
	
	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma)throws Exception{
		
		if(this.mensaje!=null){
		
			super.getFrmForma().setTituloForma(this.mensaje.getClase().getEnmEtiTitulo());
			//this.castFrmMensajeAlerta().getLblMensaje().setText(UtilidadesGiros.getInstance().separarTextoEnLineaMultiple(this.mensaje.obtenerMensajeProcesado()));
			this.castFrmMensajeAlerta().getTxaMensaje().setText(this.mensaje.obtenerMensajeProcesado());
			this.castFrmMensajeAlerta().getLblImagen().setImg(this.mensaje.getClase().getEnmImagen(),EnumDimensionesComponentes.LBL_MSG_ALRT_IMAGEN);
			//EnumDimensionesComponentes.LBL_MSG_ALRT_IMAGEN
			this.castFrmMensajeAlerta().getTxaMensaje().setCaretPosition(0);
			
			if(this.mensaje.getClase().getIntIdentificador()==JOptionPane.QUESTION_MESSAGE){
				
				this.castFrmMensajeAlerta().getPnlContenidoPiePagina().add(this.castFrmMensajeAlerta().iniciarPropBtnCancelar());
				this.castFrmMensajeAlerta().getBtnAceptar().setBounds(EnumDimensionesComponentes.BTN_MSG_ALRT_ACEPTAR_OPT.getRectangulo());
			}
		}
	}
	
	@Override
	public void accionarVentanaDesplegada(WindowEvent pEvtWindowOpened)throws Exception{
		
		/**
		 * [TODO - QenK]:
		 * Se anula sobre la funcionalidad, el dejar el foco posicionado 
		 * en una opcion predeterminada debido a que esta situacion no se 
		 * comporta de manera ideal cuando se produce una alerta producto 
		 * de una excepcion sobre la edicion de una celda de grilla, edicion 
		 * administrada por un editor personalizado, para el resto de los 
		 * casos cumple exitosamente
		 */
		
		/*if(this.mensaje.getClase().getIdentificador()==JOptionPane.QUESTION_MESSAGE){
			
			this.castFrmMensajeAlerta().getBtnCancelar().requestFocus();
			
		}else{
			
			this.castFrmMensajeAlerta().getBtnAceptar().requestFocus();
		}*/
	}
	
	@Override
	public void accionarCerrandoVentana(WindowEvent pEvtWindowClosing) throws Exception {
		/**
		 * Normalmente se encuentra implementada la opcion por la que se destruye la 
		 * alerta (aceptar / cancelar), pero solo si es el caso de una alerta de confirmacion,
		 * sin embargo la normalidad del resto de alertas implementadas no manejan esta validacion
		 * 
		 * Razon por la cual se omite la funcionalidad del boton estandar de cerrar la forma,
		 * ya que se debe escoger la opcion que aparezca en la alerta, bien sea aceptar, o para los
		 * casos de cancelar, por ningun motivo puede obviar la opcion y cerrar la alerta, puesto que
		 * como se menciona solo esta implementado para alertas de confirmacion, en otro caso, despues de
		 * cerrar el dialogo, continuara con el proceso, lo cual sugiere un comportamiento no esperado
		 * por el usuario final
		 */
	};
	
	@Override
	public void accionarEjecucion(Component pComponent,
								  AWTEvent pEvtEjecucion) throws Exception {
		
		if (pComponent.equals(this.castFrmMensajeAlerta().getBtnAceptar())) {
			this.aceptarOperacion();
		}else if(pComponent.equals(this.castFrmMensajeAlerta().getBtnCancelar())){
			this.cancelarOperacion();
		}else{
			super.accionarEjecucion(pComponent,pEvtEjecucion);
		}
	}
	
	private void aceptarOperacion()throws Exception{
		this.castFrmMensajeAlerta().setOpcion(true);
		super.getFrmForma().dispose();
	}
	
	private void cancelarOperacion()throws Exception{
		this.castFrmMensajeAlerta().setOpcion(false);
		super.getFrmForma().dispose();
	}

	public FormaMensajeAlerta castFrmMensajeAlerta()throws Exception{
		return (FormaMensajeAlerta)super.getFrmForma();
	}
	
	public Mensaje getMensaje() {
		return mensaje;
	}

	public void setMensaje(Mensaje mensaje) {
		this.mensaje = mensaje;
	}
}

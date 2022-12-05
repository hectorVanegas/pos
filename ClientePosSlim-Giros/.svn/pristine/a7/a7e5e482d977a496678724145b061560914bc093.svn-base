package co.com.codesa.clienteposslimgiros.eventos.sesion;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.mensajes.FormaMensajeAlerta;
import co.com.codesa.clienteposslimgiros.vista.logica.sesion.SesionVistaLogica;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 20-abr-2015 
 * @clase EventoFormaCierreSesion
 * 		  Clase encargada de controlar los eventos de la forma de  
 * 		  cierre de caja
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class EventoFormaCierreSesion extends EventoAbstracto{
	
	/**
  	 * ****************************************************************.
  	 * @metodo EventoFormaCierreSesion
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de sus acciones
  	 * @param pForma 
  	 * 		  referencia a la GUI de la cual se estan controlando los 
  	 * 		  eventos
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EventoFormaCierreSesion(FormaGenerica pForma) throws Exception{
		super(pForma);
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarValores
  	 * 		   Metodo que permite desacoplar y centralizar todo el 
  	 * 		   despliegue logico inicial requerido por la funcionalidad 
  	 * 		   una vez desplegada la GUI
  	 * @param pArrObjParametrosForma
  	 * 		  lista de parametros de forma, para un posible uso por parte
  	 * 		  del despliegue inicial de valores
  	 * 		  [x]: descripcion del valor enviado en la posicion [x]
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void iniciarValores(Object ...pArrObjParametrosForma)throws Exception{
		this.validarCierreSesion();
	}
	
	@Override
	public void actionPerformed(ActionEvent pEvtActionPerformed) {}
	
	@Override
	public void keyReleased(KeyEvent pEvtKeyReleased) {}
	
	@Override
	public void keyTyped(KeyEvent pEvtKeyTyped) {}

	@Override
	public void keyPressed(KeyEvent pEvtKeyPressed) {}

	@Override
	public void itemStateChanged(ItemEvent pEvtItemStateChanged) {}
	
	@Override
	public void focusGained(FocusEvent pEvtFocusGained) {}

	@Override
	public void focusLost(FocusEvent FocusLost) {}

	@Override
	public void mouseClicked(MouseEvent pEvtMouseClicked) {}

	@Override
	public void mousePressed(MouseEvent pEvtMousePressed) {}

	@Override
	public void mouseReleased(MouseEvent pEvtMouseReleased) {}

	@Override
	public void mouseEntered(MouseEvent pEvtMouseEntered) {}

	@Override
	public void mouseExited(MouseEvent pEvtMouseExited) {}
	
	/**
  	 * ****************************************************************.
  	 * @metodo validarCierreSesion
  	 * 		   Metodo que permite validar y confirmar ante el usuario la
  	 * 	  	   intencion de cerrar sesion
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void validarCierreSesion()throws Exception{
		
		FormaMensajeAlerta frmAlerta;
		
		frmAlerta = EnumMensajes.DESEA_CERRAR_SESION.desplegarMensaje(null, 
														  			  EnumClasesMensaje.CONFIRMACION);
		
		if(frmAlerta.isOpcion()){//Aceptar
			this.cerrarSesion();
			super.getObjUsuario().setAutenticado(false);
			//InformacionSessionGiros.getInstance().setAutenticacionValida(false);
			//[TODO Q-en-K: cerrar accordion] 
		}
		
		super.getFrmForma().dispose();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo cerrarSesion
  	 * 		   Metodo que permite ejecutar el cierre de sesion del usuario
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void cerrarSesion()throws Exception{
		SesionVistaLogica.getInstance().cerrarSesion(super.getObjUsuario());
	}
}

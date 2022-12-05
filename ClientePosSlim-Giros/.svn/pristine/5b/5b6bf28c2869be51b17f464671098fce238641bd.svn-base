package co.com.codesa.clienteposslimgiros.eventos.abstracto;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.ItemSelectable;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.JTextComponent;

import com.toedter.calendar.JDateChooser;

import co.com.codesa.clienteposslim.enumeraciones.TeclasEnum;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.eventos.componentesGUI.EventoLimpiarCampos;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGiros;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.formas.UtilFormas;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;

/**
 * ****************************************************************.
 * @autor: Andres Cardenas
 * @fecha: 05-mar-2015
 * @descripcion: Clase que deberan heredar cada una de las clases que
 * administran los eventos.
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public abstract class EventoAbstracto implements KeyListener,
												 ItemListener,
												 ActionListener,
												 FocusListener,
												 MouseListener ,
												 WindowListener,
												 ListSelectionListener{

	/**
	 * @variable frmForma 
	 * 			 referente a la GUI de la cual se estan controlando los 
	 * 			 eventos
	 **/
	private FormaGenerica frmForma;
	
	/**
	 * @variable booFinalizoExitosoValoresPrevio
	 * 			 bandera que permite identificar si el proceso de valores
	 * 			 iniciales posterior a la construccion de la forma finalizo 
	 * 			 exitosamente, valor por defecto false
	 **/
	private boolean booFinalizoExitosoValores;
	
	/**
  	 * ****************************************************************.
  	 * @metodo EventoAbstracto
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de sus acciones
  	 * @param pFrmPadre 
  	 * 		  referencia a la GUI de la cual se estan controlando los 
  	 * 		  eventos
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EventoAbstracto(){
		
		this.inicializarAtributos();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo EventoAbstracto
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de sus acciones
  	 * @param pFrmForma 
  	 * 		  referencia a la GUI de la cual se estan controlando los 
  	 * 		  eventos
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EventoAbstracto(FormaGenerica pFrmForma){		
		this.inicializarAtributos();
		this.setFrmForma(pFrmForma);
	}
	
	private void inicializarAtributos(){
		
		this.booFinalizoExitosoValores=false;
	}

	/**
  	 * ****************************************************************.
  	 * @metodo controlExcepcion
  	 * 		   Metodo utilizado para centralizar el control de cualquier 
  	 * 		   tipo de excepcion generada y su reaccion frente al sistema 
  	 * @param e
  	 * 		  Excepcion general, que puede representar una excepcion
  	 * 		  personalizada o general del sistema
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void controlExcepcion(Exception e){
		
		UtilidadesGiros.getInstance().controlExcepcion(e, 
													   this.frmForma);
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarValores
  	 * 		   Metodo que permite desacoplar y centralizar todo el 
  	 * 		   despliegue logico inicial requerido por la funcionalidad 
  	 * 		   antes del despliegue de la GUI
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
	public void iniciarValores(Object ...pArrObjParametrosForma)throws Exception{}
	
	/**
  	 * ****************************************************************.
  	 * @metodo cerrarForma
  	 * 		   Metodo que permite cerrar la forma de la cual se estan
  	 * 		   controlando los eventos y formas subyacentes enviadas
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public Window cerrarForma()throws Exception{
		
		Window frmVentana;
		
		if(this.frmForma.getFrmPadre()!=null && 
				this.frmForma.getFrmPadre() instanceof FormaGenerica){
			
			frmVentana = ((FormaGenerica)this.frmForma.getFrmPadre()).getEventoForma().cerrarForma();
			
		}else{
			
			frmVentana = this.frmForma.getFrmPadre();
		}
		
		this.frmForma.dispose();
		
		this.finalizarAppXPruebasInternas();
		
		return frmVentana;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo cerrarForma
  	 * 		   Metodo que permite cerrar la forma de la cual se estan
  	 * 		   controlando los eventos y formas subyacentes enviadas
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void regresarFormaPadre()throws Exception{
		
		this.frmForma.dispose();
		
		if(this.frmForma.getFrmPadre()!=null &&
				!this.frmForma.getFrmPadre().isVisible() &&
				this.frmForma.getFrmPadre() instanceof FormaGenerica){
			
			this.frmForma.getFrmPadre().setVisible(true);
			
		}//else{
			//this.finalizarAppXPruebasInternas();
		//}
		
		this.finalizarAppXPruebasInternas();
	}
	
	private void finalizarAppXPruebasInternas()throws Exception{
		
		if	(		this.frmForma.getClass().equals(TestPruebasInternas.CLASS_FORMA_GENERICA)
				&&	(		this.frmForma.getFrmPadre()	!=	null
						&&	!this.frmForma.getFrmPadre().isVisible()
						||	this.frmForma.getFrmPadre()	==	null
					)
			)
		{
			
			System.exit(0);
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarValoresDatosAdicionales
  	 * 		   Metodo que permite desacoplar y centralizar todo el 
  	 * 		   despliegue logico inicial requerido el despliegue de la
  	 * 		   forma de datos adicionales
  	 * @param pnlSeccionAdicional
  	 * 		  seccion de datos adicionales que fue enviada para solicitar
  	 * 		  de manera adicional
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void iniciarValoresDatosAdicionales(JPanel pnlSeccionAdicional)throws Exception{}
	
	/**
  	 * ****************************************************************.
  	 * @metodo validaDatosAdicionales
  	 * 		   Metodo fabricado para realizar las validaciones una vez 
  	 * 		   es efectuado un proceso de solicitud de datos adicionales
  	 * @param pnlSeccionAdicional
  	 * 		  seccion de datos adicionales que fue enviada para solicitar
  	 * 		  de manera adicional
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void validaDatosAdicionales(JPanel pnlSeccionAdicional)throws Exception{
		/**
		 * [TODO Desarrollador: implementacion de validacion de datos adicionales] 
		 */
	}
	
	@Override
	public void valueChanged(ListSelectionEvent pEvtValueChanged) {
		
		ListSelectionModel objLisSelectionModel;
		
		if	(	this.getFrmForma()==null || !this.getFrmForma().isBooAnularEventosXFocusLost()	)
		{
			try{
				
				if(!pEvtValueChanged.getValueIsAdjusting()){
				
					objLisSelectionModel = (ListSelectionModel)pEvtValueChanged.getSource();
					
					if(!objLisSelectionModel.isSelectionEmpty()){
						
						this.accionarCambioRegistro(objLisSelectionModel,
													pEvtValueChanged);
					}
				}
			
			}catch (Exception e) {
				
				this.controlExcepcion(e);
			}
		}
	}
	
	@Override
	public void windowOpened(WindowEvent pEvtWindowOpened) {
		
		Component[]	arrObjCmpOpcionesMenu;
		
		if	(	this.getFrmForma()==null || !this.getFrmForma().isBooAnularEventosXFocusLost()	)
		{
			try {
				
				if	(		this.getFrmForma()	!=	null	
						&&	this.getFrmForma().getPnlBarraHerramientas()	!=null	
					)
				{
					arrObjCmpOpcionesMenu	=	this.getFrmForma().getPnlBarraHerramientas().getComponents();
					arrObjCmpOpcionesMenu[arrObjCmpOpcionesMenu.length-1].transferFocus();
				}
				
				this.accionarVentanaDesplegada(pEvtWindowOpened);
				
			}catch (Exception e) {
				
				this.controlExcepcion(e);
			}
		}
	}
	
	@Override
	public void windowClosing(WindowEvent pEvtWindowClosing) {
		
		if	(	this.getFrmForma()==null || !this.getFrmForma().isBooAnularEventosXFocusLost()	)
		{
			try{
				
				this.accionarCerrandoVentana(pEvtWindowClosing);
				
			}catch(Exception e){
				
				this.controlExcepcion(e);
			}
		}
	}
	
	@Override
	public void windowClosed(WindowEvent pEvtWindowClosed) {
		
		if	(	this.getFrmForma()==null || !this.getFrmForma().isBooAnularEventosXFocusLost()	)
		{
			try{
				
				this.accionarVentanaCerrada(pEvtWindowClosed);
				
			}catch(Exception e){
				
				this.controlExcepcion(e);
			}
		}
	}
	
	@Override
	public void windowIconified(WindowEvent pEvtWindowIconified) {}
	
	@Override
	public void windowDeiconified(WindowEvent pEvtWindowDeiconified) {}
	
	@Override
	public void windowActivated(WindowEvent pEvtWindowActivated) {
		
		if	(	this.getFrmForma()==null || !this.getFrmForma().isBooAnularEventosXFocusLost()	)
		{
			try{
				
				this.accionarVentanaActivada(pEvtWindowActivated);
				
			}catch(Exception e){
				
				this.controlExcepcion(e);
			}
		}
	}
	
	@Override
	public void windowDeactivated(WindowEvent pEvtWindowDeactivated) {
		if	(	this.getFrmForma()==null || !this.getFrmForma().isBooAnularEventosXFocusLost()	)
		{
			try{
				
				this.accionarVentanaDesactivada(pEvtWindowDeactivated);
				
			}catch(Exception e){
				
				this.controlExcepcion(e);
			}
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo actionPerformed
  	 * 			Metodo que controla los eventos producidos por la accion
  	 * 			de ejecutar (Enter o confirmacion con raton)
  	 * @param pEvtActionPerformed 
  	 * 		  Evento recibido
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public void actionPerformed(ActionEvent pEvtActionPerformed){
		
		Component objComponent = null;
		
		if	(	this.getFrmForma()==null || !this.getFrmForma().isBooAnularEventosXFocusLost()	)
		{
			try {
				
				if(pEvtActionPerformed.getSource() instanceof Component){
				
					objComponent = (Component) pEvtActionPerformed.getSource();
					//this.accionarEjecucion(objComponent);
				}
				
				/**
				 * [QenK]: 
				 * Se coloca por fuera del condicional, ya que en caso contrario
				 * se compromete el efecto marquetado de la funcionalidad para 
				 * mostrar comunicados, que se implanto sobre la forma de autenticacion
				 * y la forma que contiene el menu de operaciones de giros, ambas sobre
				 * la parte inferior
				 */
				this.accionarEjecucion	(	objComponent,
						   					pEvtActionPerformed
						   				);
			
			}catch (Exception e) {
				
				this.controlExcepcion(e);
			}
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo keyReleased
  	 * 		   Metodo que controla los eventos producidos por el teclado, 
  	 * 		   cuando es liberada una tecla
  	 * @param pEvtKeyReleased
  	 * 		  Evento recibido
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public void keyReleased(KeyEvent pEvtKeyReleased){
		
		Component componente;
		
		if	(	this.getFrmForma()==null || !this.getFrmForma().isBooAnularEventosXFocusLost()	)
		{
			try {
				
				componente = (Component)pEvtKeyReleased.getSource();
				
				if(pEvtKeyReleased.getKeyCode() == TeclasEnum.ENTER.getCodigoTecla()){
					
					this.accionarEjecucion(componente,
										   pEvtKeyReleased);
					componente.transferFocus();
				/*	
				}	else if	(		pEvtKeyReleased.getKeyCode() == KeyEvent.VK_ESCAPE
								&&	this.frmForma	!=	null
							)
				{
					this.regresar ();
				*/	
				}	else	{
					
					this.accionarIngresoLiberado(componente,
												 pEvtKeyReleased);
				}
				
			}catch(Exception e){
				
				this.controlExcepcion(e);
			}
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo keyTyped
  	 * 		   Metodo que controla los eventos producidos por el teclado, 
  	 * 		   por cada tecla ingresada ejecutandose antes de asociar el
  	 * 		   caracter ingresado al componente
  	 * @param pEvtKeyTyped
  	 * 		  Evento recibido
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public void keyTyped(KeyEvent pEvtKeyTyped){
		
		Component componente;
		
		if	(	this.getFrmForma()==null || !this.getFrmForma().isBooAnularEventosXFocusLost()	)
		{
			try {
				
				componente = (Component)pEvtKeyTyped.getSource();
				
				if	(	this.accionarIngresoXCaracter	(	componente,
									  	 					pEvtKeyTyped.getKeyChar(),
									  	 					pEvtKeyTyped
											  	 		)
							)
				{
					pEvtKeyTyped.consume();
				}
				
			}catch(Exception e){
				
				this.controlExcepcion(e);
			}
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo keyPressed
  	 * 		   Metodo que controla los eventos producidos por el teclado, 
  	 * 		   cuando es presionada una tecla
  	 * @param pEvtKeyPressed
  	 * 		  Evento recibido
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public void keyPressed(KeyEvent pEvtKeyPressed){
		
		Component componente;
		
		if	(	this.getFrmForma()==null || !this.getFrmForma().isBooAnularEventosXFocusLost()	)
		{
			try {
				
				componente = (Component)pEvtKeyPressed.getSource();
				
				this.accionarIngresoPresionado(componente,
											   pEvtKeyPressed);
				
			}catch(Exception e){
				
				this.controlExcepcion(e);
			}
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo itemStateChanged
  	 * 		   Metodo que controla los eventos producidos por el cambio
  	 * 		   de item sobre un componente
  	 * @param pEvtItemStateChanged
  	 * 		  Evento recibido
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public void itemStateChanged(ItemEvent pEvtItemStateChanged){		
		
		Component objComponente;
		
		if	(	this.getFrmForma()==null || !this.getFrmForma().isBooAnularEventosXFocusLost()	)
		{
			try{
				
				objComponente = (Component)pEvtItemStateChanged.getSource();
				
				if(objComponente instanceof JToggleButton){
				
					if(pEvtItemStateChanged.getStateChange() == ItemEvent.SELECTED ||
							pEvtItemStateChanged.getStateChange() == ItemEvent.DESELECTED) {
					
						this.accionarCambioItem(objComponente,
												pEvtItemStateChanged);
					}
					
				}else{
					
					if(pEvtItemStateChanged.getStateChange() == ItemEvent.SELECTED){
						
						this.accionarCambioItem(objComponente, 
												pEvtItemStateChanged);
					}
				}
				
			}catch(Exception e){
				
				this.controlExcepcion(e);
			}
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo focusGained
  	 * 		   Metodo que controla los eventos producidos cuando un
  	 * 		   componente adquiere el foco
  	 * @param pEvtFocusGained
  	 * 		  Evento recibido
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public void focusGained(FocusEvent pEvtFocusGained){
		
		Component objComponente;
		
		if	(	this.getFrmForma()==null || !this.getFrmForma().isBooAnularEventosXFocusLost()	)
		{
			try{
				
				objComponente = (Component)pEvtFocusGained.getSource();
				
				this.accionarFocoAdquirido(objComponente,
										   pEvtFocusGained);
				
			}catch(Exception e){
				
				this.controlExcepcion(e);
			}
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo focusLost
  	 * 		   Metodo que controla los eventos producidos cuando un
  	 * 		   componente sede y/o pierde el foco
  	 * @param pEvtFocusLost
  	 * 		  Evento recibido
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public void focusLost(FocusEvent pEvtFocusLost){
		
		Component objComponente;
		
		try{
		
			objComponente = (Component)pEvtFocusLost.getSource();
			
			this.accionarFocoPerdido(objComponente,
									 pEvtFocusLost);
			
			if	(	this.getFrmForma()!=null && this.getFrmForma().isBooAnularEventosXFocusLost()	)
			{
				new Thread(){
					public void run() {
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
						}
						getFrmForma().setBooAnularEventosXFocusLost(false);
						
					};
				}.start();
			}
			
		}catch(Exception e){
			
			this.controlExcepcion(e);
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo mouseClicked
  	 * 		   Metodo que controla los eventos producidos cuando se 
  	 * 		   clickea sobre el componente
  	 * @param pEvtMouseClicked
  	 * 		  Evento recibido
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public void mouseClicked(MouseEvent pEvtMouseClicked){
		
		Component objComponent;
		
		if	(	this.getFrmForma()==null || !this.getFrmForma().isBooAnularEventosXFocusLost()	)
		{
			try {
				
				objComponent = (Component) pEvtMouseClicked.getSource();
				
				if (pEvtMouseClicked.getClickCount() == 2) {
					
					this.accionarDobleClick(objComponent,
											pEvtMouseClicked);
					
				}else if(pEvtMouseClicked.getClickCount() == 1){
					
					this.accionarUnClick(objComponent,
										 pEvtMouseClicked);
				}
				
			} catch (Exception e) {
				
				this.controlExcepcion(e);
			}
		}
	}

	/**
  	 * ****************************************************************.
  	 * @metodo mousePressed
  	 * 		   Metodo que controla los eventos producidos cuando se 
  	 * 		   presiona con el click un componente
  	 * @param pEvtMousePressed
  	 * 		  Evento recibido
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public void mousePressed(MouseEvent pEvtMousePressed){
		
		Component objComponent;
		
		if	(	this.getFrmForma()==null || !this.getFrmForma().isBooAnularEventosXFocusLost()	)
		{
			try {
				
				objComponent = (Component) pEvtMousePressed.getSource();
				
				this.accionarClickPresionado(objComponent,
											 pEvtMousePressed);
				
			} catch (Exception e) {
				
				this.controlExcepcion(e);
			}
		}
	}

	/**
  	 * ****************************************************************.
  	 * @metodo mouseReleased
  	 * 		   Metodo que controla los eventos producidos cuando se 
  	 * 		   libera el click sobre un componente
  	 * @param pEvtMouseReleased
  	 * 		  Evento recibido
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public void mouseReleased(MouseEvent pEvtMouseReleased){
		
		Component objComponent;
		
		if	(	this.getFrmForma()==null || !this.getFrmForma().isBooAnularEventosXFocusLost()	)
		{
			try {
				
				objComponent = (Component) pEvtMouseReleased.getSource();
				
				this.accionarClickLiberado(objComponent,
										   pEvtMouseReleased);
				
			} catch (Exception e) {
				
				this.controlExcepcion(e);
			}
		}
	}

	/**
  	 * ****************************************************************.
  	 * @metodo mouseEntered
  	 * 		   Metodo que controla los eventos producidos cuando el cursor 
  	 * 		   entra sobre el ambito de un componente
  	 * @param pEvtMouseEntered
  	 * 		  Evento recibido
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public void mouseEntered(MouseEvent pEvtMouseEntered){
		
		Component objComponent;
		
		if	(	this.getFrmForma()==null || !this.getFrmForma().isBooAnularEventosXFocusLost()	)
		{
			try {
				
				objComponent = (Component) pEvtMouseEntered.getSource();
				
				this.accionarCursorIntroducido(objComponent,
											   pEvtMouseEntered);
				
			} catch (Exception e) {
				
				this.controlExcepcion(e);
			}
		}
	}

	/**
  	 * ****************************************************************.
  	 * @metodo mouseExited
  	 * 		   Metodo que controla los eventos producidos cuando el cursor 
  	 * 		   sale del ambito de un componente
  	 * @param pEvtMouseExited
  	 * 		  Evento recibido
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public void mouseExited(MouseEvent pEvtMouseExited){
		
		Component objComponent;
		
		if	(	this.getFrmForma()==null || !this.getFrmForma().isBooAnularEventosXFocusLost()	)
		{
			try {
				
				objComponent = (Component) pEvtMouseExited.getSource();
				
				this.accionarCursorRetirado(objComponent,
											pEvtMouseExited);
				
			} catch (Exception e) {
				
				this.controlExcepcion(e);
			}
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo accionarCambioRegistro
  	 * 		   Metodo utilizado para centralizar y desacoplar la accion
  	 * 		   cuando se produce un cambio de registro sobre un componente
  	 * 		   de seleccion de lista (ListSelectionModel), ideal para
  	 * 		   validar registro seleccionado sobre una grilla 
  	 * @param pObjLisSelectionModel 
  	 * 		  Modelo de lista de seleccion sobre la cual se produce el 
  	 * 		  cambio de registro
  	 * @param pEvtValueChanged
  	 * 			Evento del componente ListSelectionModel
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void accionarCambioRegistro(ListSelectionModel pObjLisSelectionModel,
									   ListSelectionEvent pEvtValueChanged)throws Exception{}
	
	/**
  	 * ****************************************************************.
  	 * @metodo accionarVentanaDesplegada
  	 * 		   Metodo utilizado para centralizar y desacoplar la accion
  	 * 		   inmediatamente despues de hacerse el despliegue de una 
  	 * 		   ventana, ideal para realizar implementaciones de focos
  	 * 		   iniciales
  	 * @param pEvtWindowOpened 
  	 * 		  Evento correspondiente a la ventana, sobre la cual se 
  	 * 		  produce esta accion 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void accionarVentanaDesplegada(WindowEvent pEvtWindowOpened)throws Exception{
		
		Component[]	arrObjCmpOpcionesMenu;
		
		if	(		this.getFrmForma()	!=	null	
				&&	this.getFrmForma().getPnlBarraHerramientas()	!=null	
			)
		{
			arrObjCmpOpcionesMenu	=	this.getFrmForma().getPnlBarraHerramientas().getComponents();
			arrObjCmpOpcionesMenu[arrObjCmpOpcionesMenu.length-1].transferFocus();
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo accionarCerrandoVentana
  	 * 		   Metodo utilizado para centralizar y desacoplar la accion
  	 * 		   cuando se esta cerrando una ventana por la opcion basica 
  	 * 		   de cierre [X: lado superior derecho]
  	 * @param pEvtWindowClosing 
  	 * 		  Evento correspondiente a la ventana, sobre la cual se 
  	 * 		  produce esta accion
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void accionarCerrandoVentana(WindowEvent pEvtWindowClosing)throws Exception{
		
		this.regresar();
		//this.frmForma.setEnmBotEncAccionSolicitada(EnumBotonesEncabezado.BTNVOLVER);
		//this.regresarFormaPadre();
	}
	
	/**
	 * ********************************************************************
	 * @method 	accionarVentanaCerrada
	 * 		   	Metodo utilizado para centralizar y desacoplar la accion
	 * 			cuando se cierra la ventana
	 * @param 	pEvtWindowClosed
	 * 			Evento correspondiente a la ventana, sobre la cual se produce
	 * 			esta accion
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	hector.cuenca
	 * @date   	10/12/2016
	 * *********************************************************************
	 */
	public void accionarVentanaCerrada(WindowEvent pEvtWindowClosed)throws Exception{}
	
	/**
	 * ********************************************************************
	 * @method 	accionarVentanaActivada
	 * 		   	Metodo utilizado para centralizar y desacoplar la accion
	 * 			cuando se esta activando la ventana
	 * @param 	pEvtWindowActivated
	 * 			Evento correspondiente a la ventana, sobre la cual se produce
	 * 			esta accion
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	hector.cuenca
	 * @date   	10/12/2016
	 * *********************************************************************
	 */
	public void accionarVentanaActivada(WindowEvent pEvtWindowActivated)throws Exception{}
	
	/**
	 * ********************************************************************
	 * @method 	accionarVentanaDesactivada
	 * 		   	Metodo utilizado para centralizar y desacoplar la accion
	 * 			cuando se esta desactivando la ventana
	 * @param 	pEvtWindowDeactivated
	 * 			Evento correspondiente a la ventana, sobre la cual se produce
	 * 			esta accion
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	hector.cuenca
	 * @date   	10/12/2016
	 * *********************************************************************
	 */
	public void accionarVentanaDesactivada(WindowEvent pEvtWindowDeactivated)throws Exception{}
	
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
	public void accionarEjecucion(Component pComponent, 
								  AWTEvent pEvtEjecucion)throws Exception{
		
		boolean	booEsUltimaVentanaDesplegada;
		
		if	(	this.getFrmForma()	!=	null
				&& FormaGenerica.lstFormasGenericas.size()>0
			)
		{
			booEsUltimaVentanaDesplegada	=	this.getFrmForma().equals(FormaGenerica.lstFormasGenericas.get(FormaGenerica.lstFormasGenericas.size()-1));
			
			/**
			 * [TODO Desarrollador]: implementacion accionarEjecucion (ActionPerformed o 
			 * KeyReleased (Tecla.ENTER))
			 */
			
			if	(	booEsUltimaVentanaDesplegada	)
			{
				if(pComponent.getName().equals(EnumBotonesEncabezado.BTNGUARDAR.getCodigo())){
					this.confirmar();
				}else if(pComponent.getName().equals(EnumBotonesEncabezado.BTNSALIR.getCodigo())){
					this.salir();
				}else if(pComponent.getName().equals(EnumBotonesEncabezado.BTNVOLVER.getCodigo())){
					this.regresar();
				}else if(pComponent.getName().equals(EnumBotonesEncabezado.BTNCONSULTAR.getCodigo())){
					this.consultar();
				}else if(pComponent.getName().equals(EnumBotonesEncabezado.BTNIMPRIMIR.getCodigo())){
					this.imprimir();
				}else if(pComponent.getName().equals(EnumBotonesEncabezado.BTNOPERACION_INUSUAL.getCodigo())){
					this.anotar();
				}else if(pComponent.getName().equals(EnumBotonesEncabezado.BTN_ANULAR.getCodigo())){
					this.cancelar();
				}else if(pComponent.getName().equals(EnumBotonesEncabezado.BTN_AYUDA.getCodigo())){
					this.ayudar();
				}else if(pComponent.getName().equals(EnumBotonesEncabezado.BTN_LIMPIAR.getCodigo())){
					this.limpiar();
				}
			}
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo accionarIngresoLiberado
  	 * 			Metodo utilizado para centralizar y desacoplar las 
  	 * 			acciones producidas cuando se libera un ingreso por
  	 * 			teclado (keyReleased)
  	 * @param pComponent 
  	 * 		  Componente grafico por el cual se produce el evento
  	 * @param pEvtKeyReleased
  	 * 			Evento del componente gráfico.
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void accionarIngresoLiberado(Component pComponent,
										KeyEvent pEvtKeyReleased)throws Exception{
		/**
		 * [TODO Desarrollador]: implementacion accionarIngresoLiberado (keyReleased) 
		 */
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo accionarIngresoXCaracter
  	 * 		   Metodo utilizado para centralizar y desacoplar las 
  	 * 		   acciones producidas como evento, cuando se va a realizar 
  	 * 		   un ingreso de cualquier caracter por teclado. Este evento
  	 * 		   se activa antes que el caracter ingresado se procese sobre 
  	 * 		   el componente grafico  
  	 * @param pComponent 
  	 * 		  Componente grafico por el cual se produce el evento
  	 * @param pChrIngreso
  	 * 		  caracter que va a hacer asociado al componente grafico y 
  	 * 		  que fue capturado previo a esta asociacion por este evento
  	 * @param pEvtKeyTyped
  	 * 			Evento del componente pComponent 
  	 * @return boolean
  	 * 		   bandera que propone la omision (consume()), o aceptacion del caracter 
  	 * 		   que se intenta adicionar y/o ejecutar
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public boolean accionarIngresoXCaracter(Component pComponent,
										 	char pChrIngreso,
										 	KeyEvent pEvtKeyTyped)throws Exception{
		/**
		 * [TODO Desarrollador]: implementacion accionarIngresoXCaracter (keyTyped) 
		 */
		
		boolean booAnularIngreso;
		booAnularIngreso = false;
		
		return booAnularIngreso;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo accionarIngresoPresionado
  	 * 		   Metodo utilizado para centralizar y desacoplar las 
  	 * 		   acciones producidas cuando se ejecuta un ingreso de 
  	 * 		   teclado presionado
  	 * @param pComponent 
  	 * 		  Componente grafico por el cual se produce el evento
  	 * @param pEvtKeyPressed
  	 * 			Evento del componente gráfico.
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void accionarIngresoPresionado(Component pComponent,
										  KeyEvent pEvtKeyPressed)throws Exception{
		/**
		 * [TODO Desarrollador]: implementacion accionarIngresoPresionado (keyPressed) 
		 */
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo accionarCambioItem
  	 * 		   Metodo utilizado para centralizar y desacoplar las 
  	 * 		   acciones producidas cuando realiza un cambio de item
  	 * 		   sobre un componente (itemStateChanged)
  	 * @param pComponent 
  	 * 		  Componente grafico por el cual se produce el evento
  	 * @param pEvtItemStateChanged
  	 * 			Evento del componente gráfico Component;
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void accionarCambioItem(Component pComponent,
								   ItemEvent pEvtItemStateChanged)throws Exception{
		/**
		 * [TODO Desarrollador]: implementacion accionarCambioItem (itemStateChanged) 
		 */
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo accionarFocoAdquirido
  	 * 		   Metodo utilizado para centralizar y desacoplar las 
  	 * 		   acciones producidas cuando un componente adquire el foco
  	 * @param pComponent 
  	 * 		  Componente grafico por el cual se produce el evento
  	 * @param pEvtFocusGained
  	 * 			Evento del componente gráfico focus
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void accionarFocoAdquirido(Component pComponent,
									  FocusEvent pEvtFocusGained)throws Exception{
		/**
		 * [TODO Desarrollador]: implementacion accionarFocoAdquirido (focusGained) 
		 */
		//System.out.println(pComponent.getClass().getSimpleName()+": "+pComponent.getName());
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo accionarFocoPerdido
  	 * 		   Metodo utilizado para centralizar y desacoplar las 
  	 * 		   acciones producidas cuando un componente sede o pierde 
  	 * 		   el foco
  	 * @param pComponent 
  	 * 		  Componente grafico por el cual se produce el evento
  	 *  @param pEvtFocusLost
  	 * 			Evento del componente gráfico focus
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void accionarFocoPerdido(Component pComponent,
									FocusEvent pEvtFocusLost)throws Exception{
		/**
		 * [TODO Desarrollador]: implementacion accionarFocoPerdido (focusLost) 
		 */
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo accionarDobleClick
  	 * 		   Metodo utilizado para centralizar y desacoplar las 
  	 * 		   acciones producidas cuando se realiza doble-Click sobre 
  	 * 		   un componente grafico
  	 * @param pObjComponent 
  	 * 		  Componente grafico por el cual se produce el evento
  	 * @param pEvtMouseClicked
  	 * 			Evento del componente gráfico.
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void accionarDobleClick(Component pObjComponent,
								   MouseEvent pEvtMouseClicked)throws Exception{
		/**
		 * [TODO Desarrollador]: implementacion accionarDobleClick (mouseClicked {clickCount == 2}) 
		 */
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo accionarUnClick
  	 * 		   Metodo utilizado para centralizar y desacoplar las 
  	 * 		   acciones producidas cuando se realiza un click sobre un
  	 * 		   componente grafico
  	 * @param pObjComponent 
  	 * 		  Componente grafico por el cual se produce el evento
  	 * @param  pEvtMouseClicked
  	 * 			Evento del componente gráfico.
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void accionarUnClick(Component pObjComponent,
								MouseEvent pEvtMouseClicked) throws Exception{
		/**
		 * [TODO Desarrollador]: implementacion accionarUnClick (mouseClicked  {clickCount == 1}) 
		 */
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo accionarClickPresionado
  	 * 		   Metodo utilizado para centralizar y desacoplar las 
  	 * 		   acciones producidas cuando es presionado el click sobre 
  	 * 		   un componente grafico
  	 * @param pObjComponent 
  	 * 		  Componente grafico por el cual se produce el evento
  	 * @param pEvtMousePressed
  	 * 			Evento del componente gráfico.
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void accionarClickPresionado(Component pObjComponent,
										MouseEvent pEvtMousePressed) throws Exception{
		/**
		 * [TODO Desarrollador]: implementacion accionarClickPresionado (mousePressed) 
		 */
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo accionarClickLiberado
  	 * 		   Metodo utilizado para centralizar y desacoplar las 
  	 * 		   acciones producidas cuando es liberado el click sobre 
  	 * 		   un componente grafico
  	 * @param pObjComponent 
  	 * 		  Componente grafico por el cual se produce el evento
  	 * @param  pEvtMouseReleased
  	 * 			Evento del componete gráfico.
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void accionarClickLiberado(Component pObjComponent,
									  MouseEvent pEvtMouseReleased) throws Exception{
		/**
		 * [TODO Desarrollador]: implementacion accionarClickLiberado (mouseReleased) 
		 */
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo accionarCursorIntroducido
  	 * 		   Metodo utilizado para centralizar y desacoplar las 
  	 * 		   acciones producidas cuando el cursor entra a un componente
  	 * 		   grafico
  	 * @param pObjComponent 
  	 * 		  Componente grafico por el cual se produce el evento
  	 * @param pEvtMouseEntered
  	 * 			Evento del componente gráfico
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void accionarCursorIntroducido(Component pObjComponent,
										  MouseEvent pEvtMouseEntered) throws Exception{
		/**
		 * [TODO Desarrollador]: implementacion accionarCursorIntroducido (mouseEntered) 
		 */
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo accionarCursorRetirado
  	 * 		   Metodo utilizado para centralizar y desacoplar las 
  	 * 		   acciones producidas cuando el cursor sale de un componente
  	 * 		   grafico
  	 * @param pObjComponent 
  	 * 		  Componente grafico por el cual se produce el evento
  	 * @param pEvtMouseExited
  	 * 			Evento del componente gráfico.
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void accionarCursorRetirado(Component pObjComponent,
									   MouseEvent pEvtMouseExited) throws Exception{
		/**
		 * [TODO Desarrollador]: implementacion accionarCursorRetirado (mouseExited) 
		 */
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo confirmar
  	 * 		   Metodo que ejecuta las acciones referentes al boton de 
  	 * 		   operacion representativo para confirmar
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void confirmar()throws Exception{
		/**
		 * [TODO Desarrollador]: implementacion de la operacion de confirmar 
		 */
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo confirmar
  	 * 		   Metodo que ejecuta las acciones referentes al boton de 
  	 * 		   operacion representativo para confirmar
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void salir()throws Exception{
		
		/**
		 * [TODO Desarrollador]: implementacion de la operacion de salir 
		 */
		
		this.cerrarForma();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo regresar
  	 * 		   Metodo que ejecuta las acciones referentes al boton de 
  	 * 		   operacion representativo para regresar
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void regresar()throws Exception{
		
		/**
		 * [TODO Desarrollador]: implementacion de la operacion de regresar 
		 */
		
		this.frmForma.setEnmBotEncAccionSolicitada(EnumBotonesEncabezado.BTNVOLVER);
		this.regresarFormaPadre();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo consultar
  	 * 		   Metodo que ejecuta las acciones referentes al boton de 
  	 * 		   operacion representativo para consultar
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void consultar()throws Exception{
		/**
		 * [TODO Desarrollador]: implementacion de la operacion de consultar 
		 */
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo imprimir
  	 * 		   Metodo que ejecuta las acciones referentes al boton de 
  	 * 		   operacion representativo para imprimir
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void imprimir()throws Exception{
		/**
		 * [TODO Desarrollador]: implementacion de la operacion de imprimir 
		 */
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo anotar
  	 * 		   Metodo que ejecuta las acciones referentes al boton de 
  	 * 		   operacion representativo para anotar, normalmente utilizado 
  	 * 		   para la anotacion de operaciones inusuales
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void anotar()throws Exception{
		/**
		 * [TODO Desarrollador]: implementacion de la operacion de anotar 
		 */
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo anular
  	 * 		   Metodo que ejecuta las acciones referentes al boton de 
  	 * 		   operacion representativo para anular y/o cancelar
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void cancelar()throws Exception{
		
		/**
		 * [TODO Desarrollador]: implementacion de la operacion de cancelar 
		 */
		
		this.regresarFormaPadre();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo ayudar
  	 * 		   Metodo que ejecuta las acciones referentes al boton de 
  	 * 		   operacion representativo para ayudar
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public void ayudar()throws Exception{
		
		/**
		 * [TODO Desarrollador]: implementacion de la operacion de ayuda 
		 */
	}
	
	/** 
	 * ********************************************************************
	 * @method 	limpiar
	 * 		   	Metodo que ejecuta las acciones referentes al boton de 
  	 * 		   	operacion representativo para limpiar el contenido del
  	 * 			formulario
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	31/05/2017
	 * *********************************************************************
	 */
	public void limpiar()throws Exception{
		
		/**
		 * [TODO Desarrollador]: implementacion de la operacion de limpiar 
		 */
		
		UtilFormas.getInstancia().limpiarComponente	(	null,
														this.getFrmForma().getPnlContenido()
													);
	}
	
	/** 
	 * ********************************************************************
	 * @method 	limpiar
	 * 		   	Metodo que ejecuta las acciones referentes al boton de 
  	 * 		   	operacion representativo para limpiar el contenido del
  	 * 			formulario, con la posibilidad de excluir o enfocarse en el
  	 * 			listado de componentes recibido
  	 * @param	pBooExceptoOSolamente
  	 * 			Bandera que permite identificar si el conjunto de componentes
  	 * 			recibido, debe excluirse del proceso de limpieza, o debe 
  	 * 			concentrarse exclusivamente en estos
  	 * @param	pArrObjCmpGraficos
  	 * 			Listado de componentes graficos directa o indirectamente 
  	 * 			involucrados en el proceso de limpieza (excluir o exclusivo) 
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	31/05/2017
	 * *********************************************************************
	 */
	public void limpiar	(	boolean pBooExceptoOSolamente,
							Component ...pArrObjCmpGraficos
						)
								throws Exception
	{
		/**
		 * [TODO Desarrollador]: implementacion de la operacion de limpiar 
		 */
		
		List<Component>	lstCmpGraficos;
		
		lstCmpGraficos	=	Arrays.asList (pArrObjCmpGraficos);
		
		if	(	pBooExceptoOSolamente	)
		{
			UtilFormas.getInstancia().limpiarComponente	(	lstCmpGraficos,
															this.getFrmForma().getPnlContenido()
														);
		}	else	{
			UtilFormas.getInstancia().limpiarComponentes(	null,
															pArrObjCmpGraficos
														);
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	limpiarXCampo
	 * 		   	Metodo que ejecuta la limpieza de campos o secciones definidas
	 * 			con respecto a la accion de un campo particular que desencadena 
	 * 			esta limpieza  
	 * @param 	pObjCmpAccionaLimpieza
	 * 			Componente que desencadena la limpieza
	 * @param 	pArrObjCmpALimpiar
	 * 			Listado de componentes a limpiar cuando se accione el proceso
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	8/06/2017
	 * *********************************************************************
	 */
	public void limpiarXCampo	(	Component	pObjCmpAccionaLimpieza,
									Component ... pArrObjCmpALimpiar
								) 
										throws Exception
	{
		UtilFormas.getInstancia().limpiarComponentes(	null,
														pArrObjCmpALimpiar
													);
	}
	
	/** 
	 * ********************************************************************
	 * @method	configurarLimpiarXCampoAccionado
	 * 		   	Metodo que permite configurar desde el evento de la forma
	 * 			el componente que forza la limpieza de un grupo de componentes
	 * 			o secciones del formulario  
	 * @param 	pObjCmpAccionaLimpieza
	 * 			Componente que desencadena la limpieza
	 * @param 	pArrObjCmpALimpiar
	 * 			Listado de componentes a limpiar cuando se accione el proceso
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	8/06/2017
	 * *********************************************************************
	 */
	public void configurarLimpiarXCampoAccionado	(	Component	pObjCmpAccionaLimpieza,
														Component ... pArrObjCmpALimpiar
													)	
															throws Exception
	{
		EventoLimpiarCampos evtLimpiarCampos;
		
		if	(		pObjCmpAccionaLimpieza	instanceof	JTextComponent
				||	pObjCmpAccionaLimpieza	instanceof	ItemSelectable
			)
		{
			evtLimpiarCampos	=	new EventoLimpiarCampos	(	this, 
																pObjCmpAccionaLimpieza, 
																pArrObjCmpALimpiar
															);
			
			if	(	pObjCmpAccionaLimpieza	instanceof	JTextComponent)
			{
				((JTextComponent)pObjCmpAccionaLimpieza).getDocument().addDocumentListener(evtLimpiarCampos);
				
			}	else if	(	pObjCmpAccionaLimpieza	instanceof	ItemSelectable)
			{
				((ItemSelectable)pObjCmpAccionaLimpieza).addItemListener(evtLimpiarCampos);
				
			}
			
		}	else if	(		pObjCmpAccionaLimpieza	instanceof	JDateChooser	
						&&	((JDateChooser)pObjCmpAccionaLimpieza).getDateEditor()	instanceof	JTextComponent
					)
		{
			this.configurarLimpiarXCampoAccionado((JTextComponent)((JDateChooser)pObjCmpAccionaLimpieza).getDateEditor(), pArrObjCmpALimpiar);
		}
	}
	
	public void configurarLimpiarXCamposAccionados	(	Component	pObjCmpALimpiar,
														Component ... pArrObjCmpAccionanLimpieza
													)	
															throws Exception
	{
		for	(	Component	objCmpAccionaLimpieza	:	pArrObjCmpAccionanLimpieza	)
		{
			this.configurarLimpiarXCampoAccionado	(	objCmpAccionaLimpieza,
														pObjCmpALimpiar
													);
		}
		
	}
	
	public FormaGenerica getFrmForma() {
		return frmForma;
	}
	
	public void setFrmForma(FormaGenerica frmForma) {
		
		this.frmForma = frmForma;
		
		/**
		 * Se remueve de este comportamiento la asignacion de los eventos de la forma de tipo ventana 
		 * (WindowsListener), esto debido a que la asignacion de la forma, no es efectuada exclusivamente
		 * por funcionalidades base (GUIs), sino tambien por funcionalidades transversales y/o genericas
		 * normalmente implementadas como secciones (Paneles), quienes tambien asignan la forma atraves de
		 * este metodo, en su mayoria para temas de despliegue de mensajes, sin embargo termina causando 
		 * una duplicidad de los eventos de la forma de tipo ventana, y por ende una irregularidad cuando se
		 * producen sus eventos.
		 * 
		 * El caso fue detectado cuando se produce el evento windowClosing, al presionar la X sobre una forma
		 * que tambien incluye funcionalidades transversales a modo de secciones (Paneles)
		 */
		/*if(this.frmForma!=null){
			
			this.frmForma.addWindowListener(this);
		}*/
	}

	public boolean isBooFinalizoExitosoValores() {
		return booFinalizoExitosoValores;
	}

	public void setBooFinalizoExitosoValores(boolean booFinalizoExitosoValores) {
		this.booFinalizoExitosoValores = booFinalizoExitosoValores;
	}

	public Usuario getObjUsuario(){
		
		return InformacionSessionGiros.getInstance().getObjUsuario();
	}

	public void setObjUsuario(Usuario objUsuario) {
		
		InformacionSessionGiros.getInstance().setObjUsuario(objUsuario);
		
	}
	
}

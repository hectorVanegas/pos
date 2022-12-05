package co.com.codesa.clienteposslimgiros.eventos.componentesGUI;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.text.JTextComponent;

import co.com.codesa.clienteposslim.vista.IComponenteEstiloSwing;
import co.com.codesa.clienteposslimexception.exceptions.ClientePosSlimGirosException;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.ComponentesObligatorios;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.PropiedadesTexto;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;


/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 10-abr-2015 
 * @clase EventoCompTextoUtil
 * 		  Clase encargada de controlar los eventos de un componente de 
 * 		  texto
 * @copyright Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class EventoCompTextoUtil extends EventoAbstracto implements PropiedadesTexto{
	
	/**
	 * @variable controlFormatoIngreso 
	 * 			 cadena donde se configura el control de formato de 
	 * 			 ingreso de caracteres, mediante una expresion regular 
	 **/
	private String controlFormatoIngreso;
	
	/**
	 * @variable controlFormatoFinal 
	 * 			 cadena donde se configura el control de formato de 
	 * 			 final, mediante una expresion regular, que permitira
	 * 			 validar el contenido del componente de texto cuando
	 * 			 este cede el foco
	 **/
	private String controlFormatoFinal;
	
	private boolean activaFormatoFinal;
	
	/**
	 * @variable activaMayusculaMinuscula 
	 * 			 bandera que permite transformar cada ingreso producido
	 * 			 por el teclado en mayuscula (true), minuscula (false) o
	 *			 
	 **/
	private Boolean activaMayusculaMinuscula;
	
	private Format formatoSalida;
	
	/**
	 * @variable activaDesplegarMensaje 
	 * 			 bandera que permite desplegar el contenido de la caja
	 * 			 de texto mediante un mensaje de informacion
	 *			 
	 **/
	private boolean activaDesplegarContenido;
	
	/**
	 * @variable cmpComponenteTexto
	 * 			 referente al componente de texto del cual se estan 
	 * 			 controlando los eventos
	 **/
	private JTextComponent cmpComponenteTexto;
		
	/**
  	 * ****************************************************************.
  	 * @metodo EventoCompTextoUtil (Constructor)
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
	public EventoCompTextoUtil(JTextComponent pComponente) throws Exception{
		
		this.cmpComponenteTexto = pComponente;
		this.inicializarUtilidades();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo inicializarUtilidades (Metodo)
  	 * 		   Metodo encargado de inicializar aspectos relacionados con
  	 * 		   las diferentes utilidades a incorporar
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void inicializarUtilidades()throws Exception{
		
		this.controlFormatoIngreso = EnumExpresionesRegulares.EXP_REG_ADMITE_TODO.getValor();
		this.controlFormatoFinal = EnumExpresionesRegulares.EXP_REG_ADMITE_TODO.getValor();
		this.activaFormatoFinal = true;
		this.activaDesplegarContenido = false;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo keyTyped (Metodo sobre-escrito por implements)
  	 * 		   Metodo que controla los eventos producidos por el 
  	 * 		   teclado, en el instente en que se interactua con una tecla
  	 * @param pEvtKeyTyped 
  	 * 		  evento recibido
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public void keyTyped(KeyEvent pEvtKeyTyped) {
		
		Component objComponent;
		JTextComponent txtCampoTexto;
		String strResultadoMayusculaMinuscula;
		String strFormatoProcesado;
		String strCaracterIngresado;
		int intPosicionCursorNueva;
		
		try{
			
			objComponent = (Component)pEvtKeyTyped.getSource();
			
			if(objComponent instanceof JTextComponent){
				
				txtCampoTexto = (JTextComponent)objComponent;
				
				strCaracterIngresado = String.valueOf(pEvtKeyTyped.getKeyChar());
				
				if(Character.isLetter(pEvtKeyTyped.getKeyChar())){
					
					strResultadoMayusculaMinuscula = this.validaActivacionMayusculaMinusculaIngreso(strCaracterIngresado);
					strCaracterIngresado = strResultadoMayusculaMinuscula;
					pEvtKeyTyped.setKeyChar(strResultadoMayusculaMinuscula.charAt(0));
				}
				
				strFormatoProcesado = this.validaActivacionProcesarFormato(txtCampoTexto,
																		   strCaracterIngresado);
				
				if(this.validaIngreso(strFormatoProcesado,
									  this.controlFormatoIngreso)){
					
					pEvtKeyTyped.consume();
					
				}else{
					
					if(this.formatoSalida != null){
						
						pEvtKeyTyped.consume();
						
						intPosicionCursorNueva = this.establecerPosicionCursor(txtCampoTexto,
								  					  						   strFormatoProcesado);
						txtCampoTexto.setText(strFormatoProcesado);
						txtCampoTexto.setCaretPosition(intPosicionCursorNueva);
					}
				}
			}
			
		}catch(Exception e){
			super.controlExcepcion(e);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent pEvtKeyPressed) 
	{
		if	(		pEvtKeyPressed.getKeyCode()	==	KeyEvent.VK_ENTER	
				||	pEvtKeyPressed.getKeyCode()	==	KeyEvent.VK_TAB
			)
		{
			pEvtKeyPressed.consume();
			
			if	(	pEvtKeyPressed.getKeyCode()	==	KeyEvent.VK_TAB	)	
			{
				pEvtKeyPressed.getComponent().transferFocus();
			}
		}
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
	@Override
	public void accionarDobleClick(Component pObjComponent,
								   MouseEvent pEvtMouseClicked)throws Exception{
		
		if(pObjComponent instanceof JTextComponent){
			
			this.accionarDobleClickCompTexto((JTextComponent)pObjComponent);
		}
	}
	
	private int establecerPosicionCursor(JTextComponent pJTextComponent,
										  String pStrFormatoProcesado)throws Exception{
		
		int intPosicionCursorNueva;
		int intLongitudSeleccionada;
		int intPosicionCursorOriginal;
		int intLongitudTotalOriginal;
		int intPosicionFinSeleccion;
		
		intPosicionCursorOriginal = pJTextComponent.getCaretPosition();
		intLongitudTotalOriginal = pJTextComponent.getText().length();
		intLongitudSeleccionada = pJTextComponent.getSelectionEnd()-pJTextComponent.getSelectionStart();
		intPosicionFinSeleccion = pJTextComponent.getSelectionEnd();
		
		if(this.formatoSalida instanceof NumberFormat){
			
			if(intLongitudSeleccionada==0){
				
				intPosicionCursorNueva = intPosicionCursorOriginal+(pStrFormatoProcesado.length()-intLongitudTotalOriginal);
				
			}else{
				
				intPosicionCursorNueva = intPosicionFinSeleccion-(intLongitudSeleccionada-1);
			}
			
			if(intPosicionCursorNueva<0){
				intPosicionCursorNueva = 0;
			}
			
		}else{
			
			intPosicionCursorNueva = intPosicionCursorOriginal;
			
		}
		
		return intPosicionCursorNueva;
	}
	
	private void validaFormatoFinal(JTextComponent pJTextComponent,
									String pStrDescripcionCampo,
									String pStrFormatoFinal,
									EnumClasesMensaje pEnmClaseMensaje)throws Exception{
		
		if(this.validaIngreso(pJTextComponent.getText(),
							  pStrFormatoFinal)){

			if(pStrDescripcionCampo == null
					|| pStrDescripcionCampo.trim().isEmpty()){
				
				pStrDescripcionCampo = pJTextComponent.getToolTipText();
			}
			
			if	(	(		pStrDescripcionCampo == null
						|| 	pStrDescripcionCampo.trim().isEmpty()
					)
					&&	pJTextComponent instanceof ComponentesObligatorios
				)
			{
				pStrDescripcionCampo = ((ComponentesObligatorios)pJTextComponent).getLblObligatorio().obtenerNombreCampo();
			}
			
			if	(		pStrDescripcionCampo	==	null 
					||	pStrDescripcionCampo.trim().isEmpty()
				)
			{
				throw EnumMensajes.CAMPO_SIN_DESCRIPCION_NO_CUMPLE_CON_FORMATO.generarExcepcion(pEnmClaseMensaje);
				
			}else{
			
				throw EnumMensajes.CAMPO_NO_CUMPLE_CON_FORMATO.generarExcepcion(pEnmClaseMensaje, 
						  										  				pStrDescripcionCampo);
			}
		}
	}
	
	private void accionarDobleClickCompTexto(JTextComponent pJTextComponent)throws Exception{
		
		if(this.activaDesplegarContenido){
			
			this.desplegarContenido(pJTextComponent);
		}
	}
	
	private void desplegarContenido(JTextComponent pJTextComponent)throws Exception{
		
		String strContenido;
		
		strContenido = pJTextComponent.getText().trim();
		
		if(strContenido==null ||
				strContenido.isEmpty()){
			
			EnumMensajes.CONTENIDO_COMPONENTE_TEXTO_VACIO.desplegarMensaje(super.getFrmForma(), 
																		   EnumClasesMensaje.INFORMACION);
		}else{
			
			EnumMensajes.desplegarMensajePersonalizado(super.getFrmForma(), 
					   								   EnumClasesMensaje.INFORMACION, 
					   								   null, 
					   								   "{1}", 
					   								   strContenido);
		}
	}
	
	private String validaActivacionProcesarFormato(JTextComponent pJTextComponent,
												   String pStrCaracterIngresado)throws Exception{
		String strTextoFormateado;
		NumberFormat formatoNumero;
		Object valorFormateado;
		
		strTextoFormateado = pJTextComponent.getText(0,pJTextComponent.getSelectionStart());
		
		if(!Character.isIdentifierIgnorable(pStrCaracterIngresado.charAt(0))){
			strTextoFormateado += pStrCaracterIngresado;
		}
		
		if(pJTextComponent.getSelectionEnd() < pJTextComponent.getText().length()){
			
			strTextoFormateado += pJTextComponent.getText(pJTextComponent.getSelectionEnd(),pJTextComponent.getText().length()-pJTextComponent.getSelectionEnd());
		}
		
		if(this.formatoSalida!=null){
			
			if(this.formatoSalida instanceof NumberFormat){
				
				try{
				
					if(!strTextoFormateado.trim().isEmpty()){
						
						formatoNumero = (NumberFormat)this.formatoSalida;
						valorFormateado = formatoNumero.parse(strTextoFormateado);
						strTextoFormateado = this.formatoSalida.format(valorFormateado);
						
					}else{
						strTextoFormateado = "0";
					}
				
				}catch(ParseException pe){
					strTextoFormateado = "0";
				}
			}
		}
		
		return strTextoFormateado;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo validaActivacionMayusculaMinusculaIngreso (Metodo)
  	 * 		   Metodo que efectua la validacion del ingreso por teclado
  	 * 		   a medida que se va digitando en relacion con el formato
  	 * 		   configurado a manera de expresion regular sobre el 
  	 * 		   atributo controlFormatoIngreso
  	 * @param pStrIngreso 
  	 * 		  cadena a la cual se le realizara el proceso de validacion
  	 * @return String
  	 *		   cadena ingresada validada y formateada a mayuscula o minuscula 
  	 *		   de estar activa la validacion, y de no estar activa retornara
  	 *		   el mismo valor recibido
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private String validaActivacionMayusculaMinusculaIngreso(String pStrIngreso)throws Exception{
		
		if(this.activaMayusculaMinuscula!=null){
			
			if(activaMayusculaMinuscula.booleanValue()){//activar mayuscula
				
				pStrIngreso = pStrIngreso.toUpperCase();
				
			}else{//activar minuscula
				
				pStrIngreso = pStrIngreso.toLowerCase();
			}
		}
		
		return pStrIngreso;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo validaIngreso (Metodo)
  	 * 		   Metodo que efectua la validacion del ingreso por teclado
  	 * 		   a medida que se va digitando en relacion con el formato
  	 * 		   configurado a manera de expresion regular sobre el 
  	 * 		   atributo controlFormatoIngreso
  	 * @param pJTextComponent 
  	 * 		  componente de texto sobre el cual se efectuara el proceso 
  	 * 		  de validacion
  	 * @param pStrCaracterIngresado
  	 * 		  caracter ingresado que se adicionara al texto del componente
  	 * @return boolean
  	 *		   resultado de la validacion de ingreso, confirma si cumple
  	 *		   con el formato configurado para el componente de texto o no
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private boolean validaIngreso(String pStrContenidoFuturo,
								  String pStrFormato)throws Exception{
		
		boolean resultadoValidacion;
		String strValidarCadena;

		resultadoValidacion = false;
		strValidarCadena = pStrContenidoFuturo;
		
		resultadoValidacion = !UtilidadesGiros.getInstance().validaFormato(pStrFormato, 
					   													   strValidarCadena);
		return resultadoValidacion;
	}

	@Override
	public void activarDesplegarContenido(FormaGenerica pFrmPadre)throws Exception{
		
		this.activaDesplegarContenido = true;
		super.setFrmForma(pFrmPadre);
	}
	
	@Override
	public boolean validaFormatoFinal(boolean pBooGeneraExcepcion,
									  String pStrDescripcionCampo)throws Exception{
		
		boolean booResultado = false;
		
		try{
			
			this.validaFormatoFinal(this.cmpComponenteTexto,
									pStrDescripcionCampo,
									this.controlFormatoFinal,
									EnumClasesMensaje.ERROR);
			booResultado = true;
			
		}catch(ClientePosSlimGirosException cpsge){
			
			if(pBooGeneraExcepcion){
				
				this.cmpComponenteTexto.requestFocus();
				this.cmpComponenteTexto.selectAll();
				throw cpsge;
			}
		}
		
		return booResultado;
	}
	
	@Override
	public String getControlFormatoIngreso() {
		return controlFormatoIngreso;
	}

	@Override
	public void setControlFormatoIngreso(String controlFormatoIngreso) throws Exception{
		
		if(controlFormatoIngreso == null){
			controlFormatoIngreso = EnumExpresionesRegulares.EXP_REG_ADMITE_TODO.getValor();
		}
		
		this.controlFormatoIngreso = controlFormatoIngreso;
	}

	@Override
	public String getControlFormatoFinal() {
		return controlFormatoFinal;
	}

	@Override
	public void setControlFormatoFinal(String controlFormatoFinal) throws Exception{
		
		if(controlFormatoFinal == null){
			controlFormatoFinal = EnumExpresionesRegulares.EXP_REG_ADMITE_TODO.getValor();
		}
		
		this.controlFormatoFinal = controlFormatoFinal;
	}

	public JTextComponent getCmpComponenteTexto() {
		return cmpComponenteTexto;
	}

	public void setCmpComponenteTexto(JTextComponent cmpComponenteTexto) {
		this.cmpComponenteTexto = cmpComponenteTexto;
	}

	public Boolean getActivaMayusculaMinuscula() {
		return activaMayusculaMinuscula;
	}

	@Override
	public void setActivaMayusculaMinuscula(Boolean activaMayusculaMinuscula) {
		this.activaMayusculaMinuscula = activaMayusculaMinuscula;
	}

	@Override
	public boolean isActivaDesplegarContenido() {
		return activaDesplegarContenido;
	}
	
	@Override
	public void setActivaDesplegarContenido(boolean activaDesplegarContenido) {
		this.activaDesplegarContenido = activaDesplegarContenido;
	}

	@Override
	public Format getFormatoSalida() {
		return formatoSalida;
	}
	
	@Override
	public void setFormatoSalida(Format formatoSalida) {
		this.formatoSalida = formatoSalida;
	}

	public boolean isActivaFormatoFinal() {
		return activaFormatoFinal;
	}

	public void setActivaFormatoFinal(boolean activaFormatoFinal) {
		this.activaFormatoFinal = activaFormatoFinal;
	}
	
}

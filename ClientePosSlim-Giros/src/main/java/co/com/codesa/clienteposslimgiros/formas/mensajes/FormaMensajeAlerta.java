package co.com.codesa.clienteposslimgiros.formas.mensajes;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.eventos.mensajes.EventoFormaMensajeAlerta;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.AreaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.BotonUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.utilidades.mensajes.Mensaje;

/**
 * ****************************************************************.
 * @autor: Hector Q-en-K
 * @fecha: 09-mar-2015 
 * @descripcion: Clase que genera la forma (GUI) para generar mensajes
 * 				 de alerta
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class FormaMensajeAlerta extends FormaGenerica{

	/**
	 * @variable 	serialVersionUID
	 * 			 	Variable serialVersionUID
	 */
	private static final long serialVersionUID = -1053695296887806591L;
	
	/**
	 * @variable scpTextoMensaje 
	 * 			 componente grafico que permite incluir
	 * 			 barras de desplazamiento para facilitar el despliegue del
	 * 			 mensaje
	 **/
	//private JScrollPane scpTextoMensaje;
	
	/**
	 * @variable txaMensaje 
	 * 			 etiqueta encargada de mostrar la descripcion y especificacion del 
	 * 			 mensaje de alerta
	 **/
	private AreaTextoUtil txaMensaje;
	
	/**
	 * @variable btnAceptar
	 * 			 boton para confirmar la lectura del mensaje de alerta, tambien usado 
	 * 			 para confirmar sobre mensajes de decision
	 **/
	private BotonUtil btnAceptar;
	
	/**
	 * @variable btnCancelar
	 * 			 boton para confirmar la cancelacion sobre mensajes de decision
	 **/
	private BotonUtil btnCancelar;
	
	/**
	 * @variable lblImagen
	 * 			 label para adicionar una imagen representativa del modulo de giros
	 **/
	private EtiquetaUtil lblImagen;
	
	/**
	 * @variable booOpcion
	 * 		 	 bandera que permite establecer si la booOpcion seleccionada
	 * 			 desde el mensaje modal es positiva o negativa, esto aplicaria
	 * 			 para las alertas de confirmacion, donde el usuario puede 
	 * 			 decidir la booOpcion entre aceptar o cancelar, para asi mismo
	 * 			 condicionar el flujo de negocio a implementar
	 **/
	private Boolean booOpcion;

	/**
  	 * ****************************************************************.
  	 * @metodo FormaDireccion
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de la forma
  	 * @param ventana
  	 * 		  ventana sobre la cual se desplegara el mensaje de alerta
  	 * @param mensaje 
  	 * 		  objeto mensaje, que se desarrollara sobre la ventana
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de 
  	 * 		   excepcion presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaMensajeAlerta(JDialog ventana, 
							  Mensaje mensaje) throws Exception{
		
		super(ventana,
			  true);
		
		super.setEventoForma(new EventoFormaMensajeAlerta(this,
				   										  mensaje));
		
		this.inicializarForma();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo FormaDireccion
  	 * 		   sobre-carga el constructor para lograr abarcar las dos 
  	 * 		   posibles opciones de ventana en el sistema
  	 * @param ventana
  	 * 		  ventana sobre la cual se desplegara el mensaje de alerta
  	 * @param mensaje 
  	 * 		  objeto mensaje, que se desarrollara sobre la ventana
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaMensajeAlerta(JFrame ventana, 
							  Mensaje mensaje) throws Exception{
		
		super(ventana,
			  true);
		
		super.setEventoForma(new EventoFormaMensajeAlerta(this,
					  									  mensaje));
		
		this.inicializarForma();		
	}
	
	@Override
	public void inicializarForma(Object... pArrObjParametrosForma)throws Exception {
		
		this.booOpcion=null;
		
		super.setAnchoForma(EnumDimensionesComponentes.GUI_MSG_ALRT_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.GUI_MSG_ALRT_VENTANA.getAlto());
		
		super.iniciar(pArrObjParametrosForma);
	}
	
	@Override
	public JPanel inicializarEncabezado(Object... pArrObjParametrosForma)throws Exception {
		return null;
	}

	@Override
	public JPanel inicializarCuerpo(Object... pArrObjParametrosForma)throws Exception {
		
		SeccionUtil pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_MSG_ALRT_CUERPO, 
																"pnlCuerpo",
																BorderFactory.createEmptyBorder(),
														     	null,
														     	null);
		//pnlCuerpo.add(this.iniciarPropScpTextoMensaje());
		pnlCuerpo.add(this.iniciarPropTxaMensaje().getScpContenedorRound(EnumDimensionesComponentes.SCP_MSG_ALRT_SCROLL_TEXTO_MENSAJE));
		pnlCuerpo.add(this.iniciarPropLblImagen());
		
		pnlCuerpo.setBooAplicarTransparenciaFondo(true);
		
		return pnlCuerpo;
	}

	@Override
	public JPanel inicializarPiePagina(Object... pArrObjParametrosForma)throws Exception {
		
		SeccionUtil pnlPiePagina;
		
		pnlPiePagina = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_MSG_ALRT_PIEPAGINA, 
																   "pnlPiePagina",
		   														   BorderFactory.createEmptyBorder(),
		   														   null,
		   														   null);
		pnlPiePagina.add(this.iniciarPropBtnAceptar());
		
		pnlPiePagina.setBooAplicarTransparenciaFondo(true);
		
		return pnlPiePagina;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropBtnAceptar
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   btnAceptar
  	 * @return BotonUtil
  	 * 		   boton de accion gestionado 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public BotonUtil iniciarPropBtnAceptar() throws Exception{
		
		if(this.btnAceptar==null){
			
			this.btnAceptar = UtilComponentesGUI.getInstance().crearBoton(EnumDimensionesComponentes.BTN_MSG_ALRT_ACEPTAR,
																	  	  "btnAceptar",
																	  	  EnumEtiquetas.BTN_MSG_ALRT_ACEPTAR,
																	  	  true,
																	  	  true,
																	  	  super.getEventoForma(),
																	  	  null);
		}
		
		return this.btnAceptar;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropBtnCancelar 
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   btnCancelar
  	 * @return BotonUtil
  	 * 		   boton de accion gestionado 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public BotonUtil iniciarPropBtnCancelar() throws Exception{
		
		if(this.btnCancelar==null){
			
			this.btnCancelar = UtilComponentesGUI.getInstance().crearBoton(EnumDimensionesComponentes.BTN_MSG_ALRT_CANCELAR_OPT,
																	  	   "btnCancelar",
																	  	   EnumEtiquetas.BTN_MSG_ALRT_CANCELAR,
																	  	   true,
																	  	   true,
																	  	   super.getEventoForma(),
																	  	   null);
		}
		
		return this.btnCancelar;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropScpTextoMensaje
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   scpTextoMensaje
  	 * @return JScrollPane
  	 * 		   Seccion desplazable gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	/*public JScrollPane iniciarPropScpTextoMensaje() throws Exception{
		
		if(this.scpTextoMensaje==null){
			
			this.scpTextoMensaje = UtilComponentesGUI.getInstance().crearScroll("scpTextoMensaje",
													 				  			EnumDimensionesComponentes.SCP_MSG_ALRT_SCROLL_TEXTO_MENSAJE,
													 				  			null);
			
			this.scpTextoMensaje.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			this.scpTextoMensaje.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			this.scpTextoMensaje.setViewportView(this.iniciarPropTxaMensaje());
		}
		
		return this.scpTextoMensaje;
	}*/
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropTxaMensaje
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   txaMensaje
  	 * @return AreaTextoUtil 
  	 * 		   area de texto gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public AreaTextoUtil iniciarPropTxaMensaje()throws Exception {
		
		if(this.txaMensaje==null){
			
			this.txaMensaje = UtilComponentesGUI.getInstance().crearTextArea(EnumDimensionesComponentes.LBL_MSG_ALRT_MENSAJE, 
																		 	 "txaMensaje", 
																		 	 "Descripcion Mensaje", 
																		 	 true, 
																		 	 false, 
																		 	 true, 
																		 	 super.getEventoForma(),
																		 	 null);
			
			this.txaMensaje.setFont(this.txaMensaje.getFont().deriveFont(Font.BOLD));
			this.txaMensaje.setBorder(BorderFactory.createEmptyBorder());
			this.txaMensaje.setBackground(new Color(240, 240, 240));
		}
		
		return this.txaMensaje;
	}

	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblImagen
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblImagen
  	 * @return EtiquetaUtil
  	 * 		   etiqueta gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblImagen() throws Exception{
		
		if(this.lblImagen==null){
			
			this.lblImagen = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_MSG_ALRT_IMAGEN, 
																	 	 "lblImagen", 
																	 	 null,
																	 	 false,
																	 	 null, 
																	 	 true);
					
			this.lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		}
		
		return this.lblImagen;
	}
	
	public EventoFormaMensajeAlerta castEvaFrmMensajeAlerta()throws Exception{
		return (EventoFormaMensajeAlerta)super.getEventoForma();
	}

	public BotonUtil getBtnAceptar() {
		return btnAceptar;
	}

	public void setBtnAceptar(BotonUtil btnAceptar) {
		this.btnAceptar = btnAceptar;
	}

	public BotonUtil getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(BotonUtil btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public EtiquetaUtil getLblImagen() {
		return lblImagen;
	}

	public void setLblImagen(EtiquetaUtil lblImagen) {
		this.lblImagen = lblImagen;
	}

	/**
	 * ********************************************************************
	 * @method	getOpcion
	 * 		  	Metodo get del atributo booOpcion, que retorna el verdadero
	 * 			estado de la variable, asumiendo que es un objeto Boolean,
	 * 			true, false o null
	 * @return	Boolean
	 * 			Valor del atributo booOpcion
	 * @author	hector.cuenca
	 * @date	16/04/2018
	 * *********************************************************************
	 */
	public Boolean getOpcion() {
		return booOpcion;
	}
	
	public Boolean isOpcion() {
		return this.booOpcion == null?false:this.booOpcion;
	}

	public void setOpcion(Boolean opcion) {
		this.booOpcion = opcion;
	}

	public AreaTextoUtil getTxaMensaje() {
		return txaMensaje;
	}

	public void setTxaMensaje(AreaTextoUtil txaMensaje) {
		this.txaMensaje = txaMensaje;
	}
	
	/*public JScrollPane getScpTextoMensaje() {
		return scpTextoMensaje;
	}

	public void setScpTextoMensaje(JScrollPane scpTextoMensaje) {
		this.scpTextoMensaje = scpTextoMensaje;
	}*/

	public static void main(String[] args) {
		
		FormaGenerica objWinForma = null;
		FormaMensajeAlerta	objFrmMsgAlerta;
		
		try{
			
			EnumMensajes
			.desplegarMensajePersonalizado(objWinForma, 
			  EnumClasesMensaje.CONFIRMACION,
			  null,
			  "{1}",
			  "Mensaje personalizado de prueba");
			
			/*objFrmMsgAlerta	=	EnumMensajes.TERCERO_CREADO_EXITOSAMENTE.desplegarMensaje(objWinForma, 
					  EnumClasesMensaje.INFORMACION,
					  "CC. 1144029966");
			
			if(objFrmMsgAlerta.isOpcion()){
				System.out.println("entro");
			}else{
				System.out.println("no entro");
			}*/
			
			/****************************************** MOSTRAR MENSAJE OPCION 1 ******************************************/

			/*objMensaje = ControladorMensajes.getInstance().obtenerMensaje(EnumClasesMensaje.ERROR, 
															 			  EnumMensajes.VALIDA_DIRECCION_TERCERO.getCodigo(),
															 			  new String[]{"Remitente",
																		  			   "CC. 1144029966",
																		  			   "Envio"});
			objMensaje.desplegarMensaje(objWinForma);
			
			/****************************************** MOSTRAR MENSAJE OPCION 2 ******************************************/
			
			/*ControladorMensajes.getInstance().obtenerMensaje(EnumClasesMensaje.ERROR, 
					 										 EnumMensajes.VALIDA_DIRECCION_TERCERO.getCodigo(),
					 										 new String[]{"Remitente",
																		  "CC. 1144029966",
																		  "Envio"}).desplegarMensaje(objWinForma);
			
			/****************************************** MOSTRAR MENSAJE OPCION 3 ******************************************/
			
			/*EnumMensajes.VALIDA_DIRECCION_TERCERO.desplegarMensaje(objWinForma, 
														 		   EnumClasesMensaje.ERROR,
														 		   "Remitente",
														 		   "CC. 1144029966",
														 		   "Envio");
			
			/****************************************** MOSTRAR MENSAJE PERSONALIZADO OPCION 4 ****************************/
			
			/*EnumMensajes.desplegarMensajePersonalizado(objWinForma, 
													   EnumClasesMensaje.INFORMACION, 
													   "codigo", 
													   "Descripcion nuevo {1} mensaje personalizado",
													   "campo 1");*/
			
			/**************************************************************************************************************/
			
			
			/****************************************** GENERAR EXCEPTION OPCION 1 ******************************************/
			
			/*EnumMensajes.VALIDA_DIRECCION_TERCERO.generarExcepcion(EnumClasesMensaje.ERROR, 
																   "Remitente",
																   "CC. 1144029966",
			 		   											   "Envio");
			
			/****************************************** GENERAR EXCEPTION OPCION 2 ******************************************/
			
			/*throw new ClientePosSlimGirosException(EnumClasesMensaje.ERROR, 
												   EnumMensajes.VALIDA_DIRECCION_TERCERO.getCodigo(),
												   new String[]{"Remitente",
																"CC. 1144029966",
																"Envio"});
			
			/**************************************************************************************************************/
			
		} catch (Exception e) {
			
			UtilidadesGiros.getInstance().controlExcepcion(e, 
														   objWinForma);
		}
		
	}
	
}

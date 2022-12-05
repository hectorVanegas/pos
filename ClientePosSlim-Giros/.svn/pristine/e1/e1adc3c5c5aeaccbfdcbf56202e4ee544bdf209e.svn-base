package co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.ConfigOfrecerClaveSeguridadDTO;
import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad.TipoClaveSeguridadAutomaticaDTO;
import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad.TipoClaveSeguridadDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad.EventoFormaPanelTipoClaveSeguridadAutomatica;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelGenerico;
import co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.claveSeguridad.FormaOfrecerClaveSeguridad;
import co.com.codesa.clienteposslimgiros.interfaces.serviciosAdicionales.claveSeguridad.IFormasTiposClaveSeguridad;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

/**********************************************************************
 * @class  FormaPanelTipoClaveSeguridadAutomatica
 *		   Clase forma, que representa una seccion particular que 
 *		   contiene los componentes graficos necesarios para realizar
 *		   un proceso de servicio de clave de seguridad automatica		   
 * @author roberth.martinez
 * @date   4/3/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class FormaPanelTipoClaveSeguridadAutomatica extends FormaPanelGenerico implements IFormasTiposClaveSeguridad {

	/**
	 * @variable serialVersionUID
	 * 			 Variable serialVersionUID
	 */
	private static final long serialVersionUID = 8045507890900879934L;
	
	/**
	 * @variable evtFrmPnlClaveSeguridadAutomatica
	 * 			 Referencia a la clase que controla los eventos de esta forma
	 */
	private EventoFormaPanelTipoClaveSeguridadAutomatica evtFrmPnlClaveSeguridadAutomatica;
	
	/**
	 * @variable pnlDatosRemitente
	 * 			 Seccion que abarca todos los componentes graficos relacionados
	 * 			 con el ingreso de datos del remitente
	 */
	private SeccionUtil pnlDatosRemitente;
	
	/**
	 * @variable pnlDatosDestinatario
	 * 			 SeccionUtil para el panel destinatario
	 */
	private SeccionUtil pnlDatosDestinatario;
	
	/**
	 * @variable txtIngresaCelularRemitente
	 * 			 Campo de texto para ingresar el celular del remitente
	 */
	private CajaTextoUtil txtIngresaCelularRemitente;
	
	/**
	 * @variable txtConfirmaCelularRemitente
	 * 			 Campo de texto para confirmar el celular del remitente
	 */
	private CajaTextoUtil txtConfirmaCelularRemitente;
	
	/**
	 * @variable txtIngresaCelularDestinatario
	 * 			 Campo de texto para ingresar el celular del destinatario
	 */
	private CajaTextoUtil txtIngresaCelularDestinatario;
	
	/**
	 * @variable txtConfirmaCelularDestinatario
	 * 			 Campo de texto para confirmar el celular del destinatario
	 */
	private CajaTextoUtil txtConfirmaCelularDestinatario;
	
	/**
	 * @variable lblDatosSMS
	 * 			 Etiqueta que identifica los componentes graficos definidos para
	 * 			 el proceso de clave de seguridad automatica 
	 */
	private EtiquetaUtil lblDatosSMS;
	
	/**
	 * @variable lblIngresaCelularRemitente
	 * 			 Etiqueta que identifica el campo para ingresar el celular del 
	 * 			 remitente
	 */
	private EtiquetaUtil lblIngresaCelularRemitente;
	
	/**
	 * @variable lblConfirmaCelularRemitente
	 * 			 Etiqueta que identifica el campo para confirmar el celular del 
	 * 			 remitente
	 */
	private EtiquetaUtil lblConfirmaCelularRemitente;
	
	/**
	 * @variable lblIngresaCelularDestinatario
	 * 			 Etiqueta que identifica el campo para ingresar el celular del 
	 * 			 destinatario
	 */
	private EtiquetaUtil lblIngresaCelularDestinatario;
	
	/**
	 * @variable lblConfirmaCelularDestinatario
	 * 			 Etiqueta que identifica el campo para confirmar el celular del 
	 * 			 destinatario
	 */
	private EtiquetaUtil lblConfirmaCelularDestinatario;
	
	/** 
	 * ********************************************************************
	 * @method FormaPanelTipoClaveSeguridadAutomatica
	 * 		   Constructor que ejecuta la inicializacion de valores y 
	 * 		   ejecucion de comportamientos inicales requeridos para
	 *         el despliegue de la forma
	 * @param  pFrmGnrVentana
	 * 		   Forma principal desde donde se controla todo el proceso para
	 * 		   asginar el tipo de clave de seguridad
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   4/3/2016
	 * *********************************************************************
	 */
	public FormaPanelTipoClaveSeguridadAutomatica(FormaOfrecerClaveSeguridad pFrmGnrVentana) throws Exception {
		
		super(pFrmGnrVentana,
			  EnumDimensionesComponentes.PNL_PNL_CSA_TIPO_CLAVE_AUTOMATICA, 
			  "pnlClaveSeguridadAutomatica", 
			  BorderFactory.createEmptyBorder(), 
			  null,
			  null);
		
		this.setEvtFrmPnlClaveSeguridadAutomatica(new EventoFormaPanelTipoClaveSeguridadAutomatica(this));
		
		super.iniciar();
	}
	
	@Override
	protected void inicializarSeccion()throws Exception{
		
		this.add(this.iniciarPropLblDatosSMS());
		this.add(this.iniciarPropPnlDatosRemitente());
		this.add(this.iniciarPropPnlDatosDestinatario());
	}

	@Override
	public void configurar(FormaOfrecerClaveSeguridad pFrmGnrOfrecerClaveSeguridad,
						   ConfigOfrecerClaveSeguridadDTO pConfigOfrecerClaveSeguridadDTO,
			   			   TipoClaveSeguridadDTO pTipoClaveSeguridadDTO)throws Exception{
		
		this.getEvtFrmPnlClaveSeguridadAutomatica().configurar(pFrmGnrOfrecerClaveSeguridad,
															   pConfigOfrecerClaveSeguridadDTO,
												   	   		   pTipoClaveSeguridadDTO);
	}
	
	@Override
	public void ejecutar() throws Exception {
		
		this.getEvtFrmPnlClaveSeguridadAutomatica().ejecutar();
	}
	
	@Override
	public void limpiar() throws Exception {
		
		this.getEvtFrmPnlClaveSeguridadAutomatica().limpiar();
	}
	
	/**
	 * ****************************************************************.
	 * @method iniciarPropPnlDatosRemitente 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   pnlDatosRemitente
	 * @return SeccionUtil 
	 * 		   Seccion gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author roberth.martinez
	 * @date   4/3/2016
	 * ****************************************************************
	 */
	public SeccionUtil iniciarPropPnlDatosRemitente() throws Exception{
		
		if(this.pnlDatosRemitente==null){
			
			this.pnlDatosRemitente = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_PNL_CSA_SECCION_REMITENTE,
				   																 "pnlDatosRemitente",
				   																 null,
				   																 EnumEtiquetas.TTL_PNL_CSA_SECCION_REMITENTE,
				   																 null);
			
			this.pnlDatosRemitente.add(this.iniciarPropLblIngresaCelularRemitente());
			this.pnlDatosRemitente.add(this.iniciarPropTxtIngresaCelularRemitente());
			this.pnlDatosRemitente.add(this.iniciarPropLblConfirmaCelularRemitente());
			this.pnlDatosRemitente.add(this.iniciarPropTxtConfirmaCelularRemitente());
		}
		
		return this.pnlDatosRemitente;
	}
	
	/**
	 * ****************************************************************.
	 * @method iniciarPropPnlDatosDestinatario 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   pnlDatosDestinatario
	 * @return SeccionUtil 
	 * 		   Seccion gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author roberth.martinez
	 * @date   4/3/2016
	 * ****************************************************************
	 */
	public SeccionUtil iniciarPropPnlDatosDestinatario() throws Exception{
		
		if(this.pnlDatosDestinatario==null){
			
			this.pnlDatosDestinatario = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_PNL_CSA_SECCION_DESTINATARIO,
					  															    "pnlDatosDestinatario",
					  															    null,
					  															    EnumEtiquetas.TTL_PNL_CSA_SECCION_DESTINATARIO,
					  															    null);
			
			this.pnlDatosDestinatario.add(this.iniciarPropLblIngresaCelularDestinatario());
			this.pnlDatosDestinatario.add(this.iniciarPropTxtIngresaCelularDestinatario());
			this.pnlDatosDestinatario.add(this.iniciarPropLblConfirmaCelularDestinatario());
			this.pnlDatosDestinatario.add(this.iniciarPropTxtConfirmaCelularDestinatario());
		}
		
		return this.pnlDatosDestinatario;
	}
	
	/**
	 * ****************************************************************.
	 * @method iniciarPropTxtIngresaCelularRemitente 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   txtIngresaCelularRemitente
	 * @return CajaTextoUtil 
	 * 		   Caja de texto gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author roberth.martinez
	 * @date   4/3/2016
	 * ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtIngresaCelularRemitente()throws Exception{
		
		if (this.txtIngresaCelularRemitente == null) {
			
			this.txtIngresaCelularRemitente = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_PNL_CSA_INGRESAR_CELULAR, 
																				       		  "txtIngresaCelularRemitente", 
																				       		  "",
																				       		  true, 
																				       		  true, 
																				       		  true, 
																				       		  super.getEvaControlEventos(),
																				       		  EnumEtiquetas.LBL_PNL_CSA_INGRESAR_CELULAR,
																				       		  EnumEtiquetas.TTL_PNL_CSA_SECCION_REMITENTE.toString());
		}
		
		return this.txtIngresaCelularRemitente;
	}
	
	/**
	 * ****************************************************************.
	 * @method iniciarPropTxtConfirmaCelularRemitente 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   txtConfirmaCelularRemitente
	 * @return CajaTextoUtil 
	 * 		   Caja de texto gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author roberth.martinez
	 * @date   4/3/2016
	 * ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtConfirmaCelularRemitente()throws Exception{
		
		if (this.txtConfirmaCelularRemitente == null) {
			
			this.txtConfirmaCelularRemitente = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_PNL_CSA_CONFIRMAR_CELULAR, 
																				 	  		   "txtConfirmaCelularRemitente", 
																				 	  		   "",
																				 	  		   true, 
																				 	  		   true, 
																				 	  		   true, 
																				 	  		   super.getEvaControlEventos(),
																				 	  		   EnumEtiquetas.LBL_PNL_CSA_CONFIRMAR_CELULAR,
																				 	  		   EnumEtiquetas.TTL_PNL_CSA_SECCION_REMITENTE.toString());
		}
		
		return this.txtConfirmaCelularRemitente;
	}
	
	/**
	 * ****************************************************************.
	 * @method iniciarPropTxtCelularDestinatario 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   txtIngresaCelularDestinatario
	 * @return CajaTextoUtil 
	 * 		   Caja de texto gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author roberth.martinez
	 * @date   4/3/2016
	 * ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtIngresaCelularDestinatario()throws Exception{
		
		if (this.txtIngresaCelularDestinatario == null) {
			
			this.txtIngresaCelularDestinatario = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_PNL_CSA_INGRESAR_CELULAR, 
																					      		 "txtIngresaCelularDestinatario", 
																					      		 "",
																					      		 true, 
																					      		 true, 
																					      		 true, 
																					      		 super.getEvaControlEventos(),
																					      		 EnumEtiquetas.LBL_PNL_CSA_INGRESAR_CELULAR,
																					      		 EnumEtiquetas.TTL_PNL_CSA_SECCION_DESTINATARIO.toString());
		}
		
		return this.txtIngresaCelularDestinatario;
	}
	
	/**
	 * ****************************************************************.
	 * @method iniciarPropTxtConfirmaCelularDestinatario 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   txtConfirmaCelularDestinatario
	 * @return CajaTextoUtil 
	 * 		   Caja de texto gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author roberth.martinez
	 * @date   4/3/2016
	 * ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtConfirmaCelularDestinatario()throws Exception{
		
		if (this.txtConfirmaCelularDestinatario == null) {
			
			this.txtConfirmaCelularDestinatario = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_PNL_CSA_CONFIRMAR_CELULAR, 
																					 			  "txtConfirmaCelularDestinatario",
																					 			  "",
																					 			  true, 
																					 			  true, 
																					 			  true, 
																					 			  super.getEvaControlEventos(),
																					 			  EnumEtiquetas.LBL_PNL_CSA_CONFIRMAR_CELULAR,
																					 			  EnumEtiquetas.TTL_PNL_CSA_SECCION_DESTINATARIO.toString());
		}
		
		return this.txtConfirmaCelularDestinatario;
	}
	
	/**
	 * ****************************************************************.
	 * @method iniciarPropLblDatosSMS 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblDatosSMS
	 * @return EtiquetaUtil 
	 * 		   Etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author roberth.martinez
	 * @date   4/3/2016
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblDatosSMS() throws Exception{
		
		if (this.lblDatosSMS == null) {
			
			this.lblDatosSMS = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PNL_CSA_DATOS_SMS, 
					  													   "lblDatosSMS", 
					  													   EnumEtiquetas.LBL_PNL_CSA_DATOS_SMS,
					  													   true,
					  													   null,
					  													   true);
		}

		return this.lblDatosSMS;
	}
	
	/**
	 * ****************************************************************.
	 * @method iniciarPropLblIngresaCelularRemitente 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblIngresaCelularRemitente
	 * @return EtiquetaUtil 
	 * 		   Etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author roberth.martinez
	 * @date   4/3/2016
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblIngresaCelularRemitente() throws Exception{
		
		if (this.lblIngresaCelularRemitente == null) {
			
			this.lblIngresaCelularRemitente = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PNL_CSA_INGRESAR_CELULAR, 
								   												   		  "lblIngresaCelularRemitente", 
								   												   		  EnumEtiquetas.LBL_PNL_CSA_INGRESAR_CELULAR,
								   												   		  true,
								   												   		  null,
								   												   		  true);
		}
		
		return this.lblIngresaCelularRemitente;
	}
	
	/**
	 * ****************************************************************.
	 * @method iniciarPropLblConfirmaCelularRemitente 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblConfirmaCelularRemitente
	 * @return EtiquetaUtil 
	 * 		   Etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author roberth.martinez
	 * @date   4/3/2016
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblConfirmaCelularRemitente() throws Exception{
		
		if (this.lblConfirmaCelularRemitente == null) {
			
			this.lblConfirmaCelularRemitente = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PNL_CSA_CONFIRMAR_CELULAR, 
					 															  		   "lblConfirmaCelularRemitente", 
					 															  		   EnumEtiquetas.LBL_PNL_CSA_CONFIRMAR_CELULAR,
					 															  		   true,
					 															  		   null,	
					 															  		   true);
		}

		return this.lblConfirmaCelularRemitente;
	}
	
	/**
	 * ****************************************************************.
	 * @method iniciarPropLblIngresaCelularDestinatario 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblIngresaCelularDestinatario
	 * @return EtiquetaUtil 
	 * 		   Etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author roberth.martinez
	 * @date   4/3/2016
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblIngresaCelularDestinatario() throws Exception{
		
		if (this.lblIngresaCelularDestinatario == null) {
			
			this.lblIngresaCelularDestinatario = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PNL_CSA_INGRESAR_CELULAR, 
					   																		 "lblIngresaCelularDestinatario", 
					   																		 EnumEtiquetas.LBL_PNL_CSA_INGRESAR_CELULAR,
					   																		 true,
					   																		 null,
					   																		 true);
		}
		
		return this.lblIngresaCelularDestinatario;
	}
	
	/**
	 * ****************************************************************.
	 * @method iniciarPropLblConfirmaCelularDestinatario 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblConfirmaCelularDestinatario
	 * @return EtiquetaUtil 
	 * 		   Etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author roberth.martinez
	 * @date   4/3/2016
	 * ****************************************************************
	 */	
	public EtiquetaUtil iniciarPropLblConfirmaCelularDestinatario() throws Exception{
		
		if (this.lblConfirmaCelularDestinatario == null) {
			
			this.lblConfirmaCelularDestinatario = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PNL_CSA_CONFIRMAR_CELULAR, 
					 															  			  "lblConfirmaCelularDestinatario", 
					 															  			  EnumEtiquetas.LBL_PNL_CSA_CONFIRMAR_CELULAR,
					 															  			  true,
					 															  			  null,
					 															  			  true);
		}
		
		return this.lblConfirmaCelularDestinatario;
	}

	/**
	 * @method getPnlDatosRemitente
	 * 		   Metodo get del atributo pnlDatosRemitente
	 * @return SeccionUtil
	 *		   Valor del atributo pnlDatosRemitente devuelto
	 * @author hector.cuenca
	 * @date   1/04/2016
	 */
	public SeccionUtil getPnlDatosRemitente() {
		return this.pnlDatosRemitente;
	}

	/**
	 * @method setPnlDatosRemitente
	 * 		   Metodo set del atributo pnlDatosRemitente
	 * @param  pPnlDatosRemitente
	 *		   Valor que tomara el atributo pnlDatosRemitente
	 * @author hector.cuenca
	 * @date   1/04/2016
	 */
	public void setPnlDatosRemitente(SeccionUtil pPnlDatosRemitente) {
		this.pnlDatosRemitente = pPnlDatosRemitente;
	}

	/**
	 * @method getPnlDatosDestinatario
	 * 		   Metodo get del atributo pnlDatosDestinatario
	 * @return SeccionUtil
	 *		   Valor del atributo pnlDatosDestinatario devuelto
	 * @author hector.cuenca
	 * @date   1/04/2016
	 */
	public SeccionUtil getPnlDatosDestinatario() {
		return this.pnlDatosDestinatario;
	}

	/**
	 * @method setPnlDatosDestinatario
	 * 		   Metodo set del atributo pnlDatosDestinatario
	 * @param  pPnlDatosDestinatario
	 *		   Valor que tomara el atributo pnlDatosDestinatario
	 * @author hector.cuenca
	 * @date   1/04/2016
	 */
	public void setPnlDatosDestinatario(SeccionUtil pPnlDatosDestinatario) {
		this.pnlDatosDestinatario = pPnlDatosDestinatario;
	}

	/**
	 * @method getTxtIngresaCelularRemitente
	 * 		   Metodo get del atributo txtIngresaCelularRemitente
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtIngresaCelularRemitente devuelto
	 * @author hector.cuenca
	 * @date   1/04/2016
	 */
	public CajaTextoUtil getTxtIngresaCelularRemitente() {
		return this.txtIngresaCelularRemitente;
	}

	/**
	 * @method setTxtIngresaCelularRemitente
	 * 		   Metodo set del atributo txtIngresaCelularRemitente
	 * @param  pTxtIngresaCelularRemitente
	 *		   Valor que tomara el atributo txtIngresaCelularRemitente
	 * @author hector.cuenca
	 * @date   1/04/2016
	 */
	public void setTxtIngresaCelularRemitente(
			CajaTextoUtil pTxtIngresaCelularRemitente) {
		this.txtIngresaCelularRemitente = pTxtIngresaCelularRemitente;
	}

	/**
	 * @method getTxtConfirmaCelularRemitente
	 * 		   Metodo get del atributo txtConfirmaCelularRemitente
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtConfirmaCelularRemitente devuelto
	 * @author hector.cuenca
	 * @date   1/04/2016
	 */
	public CajaTextoUtil getTxtConfirmaCelularRemitente() {
		return this.txtConfirmaCelularRemitente;
	}

	/**
	 * @method setTxtConfirmaCelularRemitente
	 * 		   Metodo set del atributo txtConfirmaCelularRemitente
	 * @param  pTxtConfirmaCelularRemitente
	 *		   Valor que tomara el atributo txtConfirmaCelularRemitente
	 * @author hector.cuenca
	 * @date   1/04/2016
	 */
	public void setTxtConfirmaCelularRemitente(
			CajaTextoUtil pTxtConfirmaCelularRemitente) {
		this.txtConfirmaCelularRemitente = pTxtConfirmaCelularRemitente;
	}

	/**
	 * @method getTxtIngresaCelularDestinatario
	 * 		   Metodo get del atributo txtIngresaCelularDestinatario
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtIngresaCelularDestinatario devuelto
	 * @author hector.cuenca
	 * @date   1/04/2016
	 */
	public CajaTextoUtil getTxtIngresaCelularDestinatario() {
		return this.txtIngresaCelularDestinatario;
	}

	/**
	 * @method setTxtIngresaCelularDestinatario
	 * 		   Metodo set del atributo txtIngresaCelularDestinatario
	 * @param  pTxtIngresaCelularDestinatario
	 *		   Valor que tomara el atributo txtIngresaCelularDestinatario
	 * @author hector.cuenca
	 * @date   1/04/2016
	 */
	public void setTxtIngresaCelularDestinatario(
			CajaTextoUtil pTxtIngresaCelularDestinatario) {
		this.txtIngresaCelularDestinatario = pTxtIngresaCelularDestinatario;
	}

	/**
	 * @method getTxtConfirmaCelularDestinatario
	 * 		   Metodo get del atributo txtConfirmaCelularDestinatario
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtConfirmaCelularDestinatario devuelto
	 * @author hector.cuenca
	 * @date   1/04/2016
	 */
	public CajaTextoUtil getTxtConfirmaCelularDestinatario() {
		return this.txtConfirmaCelularDestinatario;
	}

	/**
	 * @method setTxtConfirmaCelularDestinatario
	 * 		   Metodo set del atributo txtConfirmaCelularDestinatario
	 * @param  pTxtConfirmaCelularDestinatario
	 *		   Valor que tomara el atributo txtConfirmaCelularDestinatario
	 * @author hector.cuenca
	 * @date   1/04/2016
	 */
	public void setTxtConfirmaCelularDestinatario(
			CajaTextoUtil pTxtConfirmaCelularDestinatario) {
		this.txtConfirmaCelularDestinatario = pTxtConfirmaCelularDestinatario;
	}

	/**
	 * @method getLblDatosSMS
	 * 		   Metodo get del atributo lblDatosSMS
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblDatosSMS devuelto
	 * @author hector.cuenca
	 * @date   1/04/2016
	 */
	public EtiquetaUtil getLblDatosSMS() {
		return this.lblDatosSMS;
	}

	/**
	 * @method setLblDatosSMS
	 * 		   Metodo set del atributo lblDatosSMS
	 * @param  pLblDatosSMS
	 *		   Valor que tomara el atributo lblDatosSMS
	 * @author hector.cuenca
	 * @date   1/04/2016
	 */
	public void setLblDatosSMS(EtiquetaUtil pLblDatosSMS) {
		this.lblDatosSMS = pLblDatosSMS;
	}

	/**
	 * @method getLblIngresaCelularRemitente
	 * 		   Metodo get del atributo lblIngresaCelularRemitente
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblIngresaCelularRemitente devuelto
	 * @author hector.cuenca
	 * @date   1/04/2016
	 */
	public EtiquetaUtil getLblIngresaCelularRemitente() {
		return this.lblIngresaCelularRemitente;
	}

	/**
	 * @method setLblIngresaCelularRemitente
	 * 		   Metodo set del atributo lblIngresaCelularRemitente
	 * @param  pLblIngresaCelularRemitente
	 *		   Valor que tomara el atributo lblIngresaCelularRemitente
	 * @author hector.cuenca
	 * @date   1/04/2016
	 */
	public void setLblIngresaCelularRemitente(
			EtiquetaUtil pLblIngresaCelularRemitente) {
		this.lblIngresaCelularRemitente = pLblIngresaCelularRemitente;
	}

	/**
	 * @method getLblConfirmaCelularRemitente
	 * 		   Metodo get del atributo lblConfirmaCelularRemitente
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblConfirmaCelularRemitente devuelto
	 * @author hector.cuenca
	 * @date   1/04/2016
	 */
	public EtiquetaUtil getLblConfirmaCelularRemitente() {
		return this.lblConfirmaCelularRemitente;
	}

	/**
	 * @method setLblConfirmaCelularRemitente
	 * 		   Metodo set del atributo lblConfirmaCelularRemitente
	 * @param  pLblConfirmaCelularRemitente
	 *		   Valor que tomara el atributo lblConfirmaCelularRemitente
	 * @author hector.cuenca
	 * @date   1/04/2016
	 */
	public void setLblConfirmaCelularRemitente(
			EtiquetaUtil pLblConfirmaCelularRemitente) {
		this.lblConfirmaCelularRemitente = pLblConfirmaCelularRemitente;
	}

	/**
	 * @method getLblIngresaCelularDestinatario
	 * 		   Metodo get del atributo lblIngresaCelularDestinatario
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblIngresaCelularDestinatario devuelto
	 * @author hector.cuenca
	 * @date   1/04/2016
	 */
	public EtiquetaUtil getLblIngresaCelularDestinatario() {
		return this.lblIngresaCelularDestinatario;
	}

	/**
	 * @method setLblIngresaCelularDestinatario
	 * 		   Metodo set del atributo lblIngresaCelularDestinatario
	 * @param  pLblIngresaCelularDestinatario
	 *		   Valor que tomara el atributo lblIngresaCelularDestinatario
	 * @author hector.cuenca
	 * @date   1/04/2016
	 */
	public void setLblIngresaCelularDestinatario(
			EtiquetaUtil pLblIngresaCelularDestinatario) {
		this.lblIngresaCelularDestinatario = pLblIngresaCelularDestinatario;
	}

	/**
	 * @method getLblConfirmaCelularDestinatario
	 * 		   Metodo get del atributo lblConfirmaCelularDestinatario
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblConfirmaCelularDestinatario devuelto
	 * @author hector.cuenca
	 * @date   1/04/2016
	 */
	public EtiquetaUtil getLblConfirmaCelularDestinatario() {
		return this.lblConfirmaCelularDestinatario;
	}

	/**
	 * @method setLblConfirmaCelularDestinatario
	 * 		   Metodo set del atributo lblConfirmaCelularDestinatario
	 * @param  pLblConfirmaCelularDestinatario
	 *		   Valor que tomara el atributo lblConfirmaCelularDestinatario
	 * @author hector.cuenca
	 * @date   1/04/2016
	 */
	public void setLblConfirmaCelularDestinatario(
			EtiquetaUtil pLblConfirmaCelularDestinatario) {
		this.lblConfirmaCelularDestinatario = pLblConfirmaCelularDestinatario;
	}

	/**
	 * @method getEvtFrmPnlClaveSeguridadAutomatica
	 * 		   Metodo get del atributo evtFrmPnlClaveSeguridadAutomatica
	 * @return EventoFormaPanelTipoClaveSeguridadAutomatica
	 *		   Valor del atributo evtFrmPnlClaveSeguridadAutomatica devuelto
	 * @author hector.cuenca
	 * @date   1/04/2016
	 */
	public EventoFormaPanelTipoClaveSeguridadAutomatica getEvtFrmPnlClaveSeguridadAutomatica() {
		return evtFrmPnlClaveSeguridadAutomatica;
	}

	/**
	 * @method setEvtFrmPnlClaveSeguridadAutomatica
	 * 		   Metodo set del atributo evtFrmPnlClaveSeguridadAutomatica
	 * @param  pEvtFrmPnlClaveSeguridadAutomatica
	 *		   Valor que tomara el atributo evtFrmPnlClaveSeguridadAutomatica
	 * @author hector.cuenca
	 * @date   1/04/2016
	 */
	public void setEvtFrmPnlClaveSeguridadAutomatica(
			EventoFormaPanelTipoClaveSeguridadAutomatica pEvtFrmPnlClaveSeguridadAutomatica) {
		
		this.evtFrmPnlClaveSeguridadAutomatica = pEvtFrmPnlClaveSeguridadAutomatica;
		this.setEvaControlEventos(this.evtFrmPnlClaveSeguridadAutomatica);
	}

	/** ********************************************************************
	 * @method main
	 * 		   metodo main para ejecucion
	 * @param  args
	 * 	       argumentos
	 * @author roberth.martinez
	 * @date   4/3/2016
	 * *********************************************************************
	 */
	public static void main(String args[]){
		
		try {
			
			TestPruebasInternas.getInstance().iniciarPruebaInterna(null,true, EnumDesplegarFormaConEventos.NO);
			@SuppressWarnings("unused")
			TipoClaveSeguridadAutomaticaDTO tipoTokenValidaAutomaticolDTO = new TipoClaveSeguridadAutomaticaDTO(null, null);
			//FacturaGiro objFacturaGiro = new FacturaGiro();
			JPanel panelContenido = new JPanel ();
			panelContenido.setLayout(null);
			JDialog dialogo = new JDialog();
			
			dialogo.setBounds(0, 0, 900, 500);
			
			FormaPanelTipoClaveSeguridadAutomatica forma;
			
			forma = new FormaPanelTipoClaveSeguridadAutomatica(null);
			
			panelContenido.add(forma);
			
			dialogo.add(panelContenido);
			
			dialogo.setVisible(true);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

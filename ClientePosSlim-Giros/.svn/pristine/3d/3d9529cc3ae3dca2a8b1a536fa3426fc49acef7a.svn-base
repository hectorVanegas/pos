package co.com.codesa.clienteposslimgiros.eventos.serviciosAdicionales.SMSGiro;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.SMSGiro.FormaPanelSMSGiro;

/**
 * 
 * ********************************************************************
 * @class	EventoFormaPanelSMSGiro
 *		 	Clase que controla los eventos de la seccion dedicada a realizar
 *		   	un proceso de confirmacion de celular
 * @author	hector.cuenca
 * @date  	6/04/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class EventoFormaPanelSMSGiro extends EventoAbstracto {
	
	/**
	 * @variable	frmPnlSMSGiro
	 * 				Seccion de la cual se estan controlando los eventos
	 */
	private FormaPanelSMSGiro frmPnlSMSGiro;
	
	/**
	 * @variable	strTelefonoCelular
	 * 				Telefono celular que se requiere confirmar
	 */
	private String strTelefonoCelular;
	
	/** ********************************************************************
	 * @method 	EventoFormaPanelSMSGiro
	 * 		   	Constructor que ejecuta la inicializacion de valores y 
	 * 		   	ejecucion de comportamientos inicales requeridos para
	 *         	el despliegue del control de eventos de la forma 
	 * @param  	pFrmPnlSMSGiro
	 * 		   	Seccion de la cual se estan controlando los eventos
	 * @throws 	Exception
     * 	       	Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	6/4/2018
	 * *********************************************************************
	 */
	public EventoFormaPanelSMSGiro	(FormaPanelSMSGiro pFrmPnlSMSGiro) 
		throws Exception
	{	
		super(pFrmPnlSMSGiro.getFrmGnrPadre());
		this.setFrmPnlSMSGiro(pFrmPnlSMSGiro);
	}
	
	/** ********************************************************************
	 * @method 	EventoFormaPanelSMSGiro
	 * 		   	Constructor que ejecuta la inicializacion de valores y 
	 * 		   	ejecucion de comportamientos inicales requeridos para
	 *         	el despliegue del control de eventos de la forma 
	 * @param  	pFrmPnlSMSGiro
	 * 		   	Seccion de la cual se estan controlando los eventos
	 * @param	pStrTelefonoCelular
	 * 			Telefono celular propuesto actualmente
	 * @throws 	Exception
     * 	       	Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	6/4/2018
	 * *********************************************************************
	 */
	public EventoFormaPanelSMSGiro	(	FormaPanelSMSGiro pFrmPnlSMSGiro,
										String pStrTelefonoCelular
									) 
		throws Exception
	{	
		this(pFrmPnlSMSGiro);
		this.setStrTelefonoCelular(pStrTelefonoCelular);
	}
	
	@Override
	public void iniciarValores(Object... pArrObjParametrosForma) 
		throws Exception 
	{
		this.configuracionCampoTexto();
		this.cargarFormulario(this.getStrTelefonoCelular());
	}
	
	/**
	 * ********************************************************************
	 * @method	configuracionCampoTexto
	 * 		  	metodo utilizado para inicializar la configuracion de los 
     *		   	campos de texto de la forma/seccion de la cual se estan 
     *		   	controlando los eventos
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	6/04/2018
	 * *********************************************************************
	 */
	private void configuracionCampoTexto()
		throws Exception
	{	
		this.getFrmPnlSMSGiro().getTxtIngresaCelular().getLblObligatorio().aplicarObligatoriedad(true);
		this.getFrmPnlSMSGiro().getTxtIngresaCelular().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_INGRESO_CELULAR.getValor());
		this.getFrmPnlSMSGiro().getTxtIngresaCelular().getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.PNL_CSA_CELULAR_TERCERO.getValor());
		
		this.getFrmPnlSMSGiro().getTxtConfirmaCelular().getLblObligatorio().aplicarObligatoriedad(true);
		this.getFrmPnlSMSGiro().getTxtConfirmaCelular().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_INGRESO_CELULAR.getValor());
		this.getFrmPnlSMSGiro().getTxtConfirmaCelular().getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.PNL_CSA_CELULAR_TERCERO.getValor());
		
		super.configurarLimpiarXCamposAccionados(	this.getFrmPnlSMSGiro().getTxtConfirmaCelular(),
													this.getFrmPnlSMSGiro().getTxtIngresaCelular()
												);
	}
	
	/**
	 * ********************************************************************
	 * @method	cargarFormulario
	 * 		  	metodo utilizado para cargar el formulario segun los datos
     * 		   	e informacion recibidos
	 * @param	pStrTelefonoCelular
	 * 			Telefono celular que se requiere confirmar
     * @throws 	Exception
     * 		   	Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	6/04/2018
	 * *********************************************************************
	 */
	public void cargarFormulario(String pStrTelefonoCelular)
		throws Exception
	{	
		this.getFrmPnlSMSGiro().getTxtIngresaCelular().setText(pStrTelefonoCelular);
		this.getFrmPnlSMSGiro().getTxtConfirmaCelular().setText(null);
		this.setStrTelefonoCelular(null);
	}
	
	/**
	 * ********************************************************************
	 * @method	ejecutar
	 * 		  	Validaciones realizadas al presionar confirmar en la ventana 
	 * 		   	principal para diligenciar un proceso de clave de seguridad
	 * 		   	automatica
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	6/04/2018
	 * *********************************************************************
	 */
	public void ejecutar() 
		throws Exception 
	{	
		this.validarCelularConfirmado();
		this.setStrTelefonoCelular(this.getFrmPnlSMSGiro().getTxtIngresaCelular().getText());
	}
	
	/**
  	 * ****************************************************************
  	 * @method 	validarFormatoCelularXTercero
  	 * 		   	Metodo encargado de realizar las diferentes validaciones
  	 * 			aplicadas a los datos registrados
  	 * @throws 	Exception
  	 * 		   	Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
  	 * @author 	hector.cuenca
  	 * ****************************************************************
  	 */
	private void validarCelularConfirmado() 
		throws Exception 
	{	
		String strCelularIngresado;
		String strCelularConfirmado;
		
		this.getFrmPnlSMSGiro().getTxtIngresaCelular().getPropiedades().validaFormatoFinal	(	true,
				   						   														null
				   						   													);
		
		this.getFrmPnlSMSGiro().getTxtConfirmaCelular().getPropiedades().validaFormatoFinal	(	true,
																								null
																							);
		strCelularIngresado = this.getFrmPnlSMSGiro().getTxtIngresaCelular().getText();
		strCelularConfirmado = this.getFrmPnlSMSGiro().getTxtConfirmaCelular().getText(); 
		
		if	(	!strCelularIngresado.equals(strCelularConfirmado)	) 
		{
			throw EnumMensajes.TELEFONOS_NO_COINCIDEN.generarExcepcion(EnumClasesMensaje.ERROR);
		}
	}

	/**
	 * @method	getFrmPnlSMSGiro
	 * 		  	Metodo get del atributo frmPnlSMSGiro
	 * @return	FormaPanelSMSGiro
	 *		  	Valor del atributo frmPnlSMSGiro devuelto
	 * @author	hector.cuenca
	 * @date  	6/04/2018
	 */
	public FormaPanelSMSGiro getFrmPnlSMSGiro() {
		return frmPnlSMSGiro;
	}

	/**
	 * @method	setFrmPnlSMSGiro
	 * 		  	Metodo set del atributo frmPnlSMSGiro
	 * @param	pFrmPnlSMSGiro
	 * 			Valor que tomara el atributo frmPnlSMSGiro
	 * @author	hector.cuenca
	 * @date	6/04/2018
	 */
	public void setFrmPnlSMSGiro(FormaPanelSMSGiro pFrmPnlSMSGiro) {
		this.frmPnlSMSGiro = pFrmPnlSMSGiro;
	}

	/**
	 * @method	getStrTelefonoCelular
	 * 		  	Metodo get del atributo strTelefonoCelular
	 * @return	String
	 *		  	Valor del atributo strTelefonoCelular devuelto
	 * @author	hector.cuenca
	 * @date  	6/04/2018
	 */
	public String getStrTelefonoCelular() {
		return strTelefonoCelular;
	}

	/**
	 * @method	setStrTelefonoCelular
	 * 		  	Metodo set del atributo strTelefonoCelular
	 * @param	pStrTelefonoCelular
	 * 			Valor que tomara el atributo strTelefonoCelular
	 * @author	hector.cuenca
	 * @date	6/04/2018
	 */
	public void setStrTelefonoCelular(String pStrTelefonoCelular) {
		this.strTelefonoCelular = pStrTelefonoCelular;
	}

	
}

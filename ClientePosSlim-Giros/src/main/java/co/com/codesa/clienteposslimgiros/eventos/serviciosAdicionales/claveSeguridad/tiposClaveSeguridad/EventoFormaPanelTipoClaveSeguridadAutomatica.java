package co.com.codesa.clienteposslimgiros.eventos.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad;

import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.ConfigOfrecerClaveSeguridadDTO;
import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad.TipoClaveSeguridadAutomaticaDTO;
import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad.TipoClaveSeguridadDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.enumeraciones.operaciones.EnumTiposOperaciones;
import co.com.codesa.clienteposslimgiros.enumeraciones.serviciosAdicionales.claveSeguridad.EnumTiposClaveSeguridad;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.claveSeguridad.FormaOfrecerClaveSeguridad;
import co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad.FormaPanelTipoClaveSeguridadAutomatica;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.PropiedadesTexto;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.clienteposslimgiros.utilidades.validaciones.ValidacionesTercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ClaveSeguridadAutomatica;

/** ********************************************************************
 * @class  EventoFormaPanelTipoClaveSeguridadAutomatica
 *		   Clase que controla los eventos de la seccion dedicada a 
 *		   diligenciar un tipo de clave de seguridad automatica
 * @author roberth.martinez
 * @date   4/3/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class EventoFormaPanelTipoClaveSeguridadAutomatica extends EventoAbstracto {
	
	/**
	 * @variable objFacturaGiro
	 * 			 objeto factura giro
	 */
	private FacturaGiro objFacturaGiro;
	
	/**
	 * @variable objTerceroDestino
	 * 			 Objeto tercero destino, almacena el tercero de la factura o 
	 * 			 el tercero nuevo de cambio de beneficiario
	 */
	private Tercero objTerceroDestino;
	/**
	 * @variable tipoClaveSeguridadAutomaticaDTO
	 * 			 objeto que relaciona la dto para clave de seguridad automatica
	 */
	private TipoClaveSeguridadAutomaticaDTO tipoClaveSeguridadAutomaticaDTO;
	
	/**
	 * @variable configOfrecerClaveSeguridadDTO
	 * 			 Dto para manejo de datos necesarios para ofrecer la clave de seguridad
	 */
	private ConfigOfrecerClaveSeguridadDTO configOfrecerClaveSeguridadDTO;
	
	/**
	 * @variable frmPnlTipoClaveSeguridadAutomatica
	 * 			 objeto que referencia a la seccion de la cual se estan controlando
	 * 			 los eventos
	 */
	private FormaPanelTipoClaveSeguridadAutomatica frmPnlTipoClaveSeguridadAutomatica;
	
	/** ********************************************************************
	 * @method EventoFormaPanelTipoClaveSeguridadAutomatica
	 * 		   constructor de la clase EventoFormaPanelTipoClaveSeguridadAutomatica
	 * @param  pFrmPnlTipoClaveSeguridadAutomatica
	 * 		   objeto de la forma clave de seguridad automatica
	 * @author roberth.martinez
	 * @date   4/3/2016
	 * *********************************************************************
	 */
	public EventoFormaPanelTipoClaveSeguridadAutomatica(FormaPanelTipoClaveSeguridadAutomatica pFrmPnlTipoClaveSeguridadAutomatica) {
		
		super(pFrmPnlTipoClaveSeguridadAutomatica.getFrmGnrPadre());
		this.setFrmPnlTipoClaveSeguridadAutomatica(pFrmPnlTipoClaveSeguridadAutomatica);
	}
	
	/**
     * ****************************************************************
     * @metodo configuracionCampoTexto
     *		   metodo utilizado para inicializar la configuracion de los 
     *		   campos de texto de la forma/seccion de la cual se estan 
     *		   controlando los eventos
     * @throws Exception
     * 	       Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */
	private void configuracionCampoTexto()throws Exception{
		
		this.getFrmPnlTipoClaveSeguridadAutomatica().getTxtIngresaCelularRemitente().getLblObligatorio().aplicarObligatoriedad(true);
		this.getFrmPnlTipoClaveSeguridadAutomatica().getTxtIngresaCelularRemitente().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_INGRESO_CELULAR.getValor());
		this.getFrmPnlTipoClaveSeguridadAutomatica().getTxtIngresaCelularRemitente().getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.PNL_CSA_CELULAR_TERCERO.getValor());

		this.getFrmPnlTipoClaveSeguridadAutomatica().getTxtConfirmaCelularRemitente().getLblObligatorio().aplicarObligatoriedad(true);
		this.getFrmPnlTipoClaveSeguridadAutomatica().getTxtConfirmaCelularRemitente().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_INGRESO_CELULAR.getValor());
		this.getFrmPnlTipoClaveSeguridadAutomatica().getTxtConfirmaCelularRemitente().getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.PNL_CSA_CELULAR_TERCERO.getValor());
		
		this.getFrmPnlTipoClaveSeguridadAutomatica().getTxtIngresaCelularDestinatario().getLblObligatorio().aplicarObligatoriedad(true);
		this.getFrmPnlTipoClaveSeguridadAutomatica().getTxtIngresaCelularDestinatario().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_INGRESO_CELULAR.getValor());
		this.getFrmPnlTipoClaveSeguridadAutomatica().getTxtIngresaCelularDestinatario().getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.PNL_CSA_CELULAR_TERCERO.getValor());
		
		this.getFrmPnlTipoClaveSeguridadAutomatica().getTxtConfirmaCelularDestinatario().getLblObligatorio().aplicarObligatoriedad(true);
		this.getFrmPnlTipoClaveSeguridadAutomatica().getTxtConfirmaCelularDestinatario().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_INGRESO_CELULAR.getValor());
		this.getFrmPnlTipoClaveSeguridadAutomatica().getTxtConfirmaCelularDestinatario().getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.PNL_CSA_CELULAR_TERCERO.getValor());
	}
	
	/**
     * ****************************************************************
     * @metodo cargarFormulario
     * 		   metodo utilizado para cargar el formulario segun los datos
     * 		   e informacion recibidos
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */
	private void cargarFormulario()throws Exception{
		
		boolean booEnmParSisNoPermiteConfirmarCelular;
		String strCelularRemitente;
		String strCelularDestinatario;
		
		if (EnumTiposOperaciones.SOLICITUD_CAMBIO_BENEFICIARIO.equals(this.getConfigOfrecerClaveSeguridadDTO().getEnmTipoOperacion())) {
			
			this.setObjTerceroDestino(this.getConfigOfrecerClaveSeguridadDTO().getObjDtoClaveSeguridad().getObjTerceroNuevo());
		}else{
			
			this.setObjTerceroDestino(this.getObjFacturaGiro().getTerceroDestino());
		}
		
		strCelularRemitente = this.getObjFacturaGiro().getTerceroOrigen().getTelefono2();
		strCelularDestinatario = this.getObjTerceroDestino().getTelefono2();
		
		this.getFrmPnlTipoClaveSeguridadAutomatica().getTxtIngresaCelularRemitente().setText(strCelularRemitente);
		this.getFrmPnlTipoClaveSeguridadAutomatica().getTxtIngresaCelularDestinatario().setText(strCelularDestinatario);
		
		UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.PERMITE_CONFIRMACION_CELULAR);
		booEnmParSisNoPermiteConfirmarCelular = EnumParametrosSistema.PERMITE_CONFIRMACION_CELULAR.obtenerValorBooleano("N");
		
		if(booEnmParSisNoPermiteConfirmarCelular){
			
			this.validarCamposNoPermiteConfirmarCelular(true,
														this.getFrmPnlTipoClaveSeguridadAutomatica().getTxtIngresaCelularRemitente(),
														this.getFrmPnlTipoClaveSeguridadAutomatica().getTxtConfirmaCelularRemitente());
			
			this.validarCamposNoPermiteConfirmarCelular(false,
														this.getFrmPnlTipoClaveSeguridadAutomatica().getTxtIngresaCelularDestinatario(),
														this.getFrmPnlTipoClaveSeguridadAutomatica().getTxtConfirmaCelularDestinatario());
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method validarCamposNoPermiteConfirmarCelular
	 * 		   Metodo que permite validar el estado habilitado de los campos
	 * 		   ingresar y confirmar, segun configuracion a nivel de parametro
	 * 		   del sistema
	 * @param  pBooTipoTercero
	 * 		   Bandera que permite identificar el tipo de tercero a validar
	 * 		   (Remitente/Destinatario), true y false respectivamente
	 * @param  pTxtIngresaCelular
	 * 		   Caja de texto en la cual se permite ingresar el celular del
	 * 		   tercero a validar
	 * @param  pTxtConfirmaCelular
	 * 		   Caja de texto en la cual se permite confirmar el celular del
	 * 		   tercero a validar
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   4/4/2016
	 * *********************************************************************
	 */
	private void validarCamposNoPermiteConfirmarCelular(boolean pBooTipoTercero,
														CajaTextoUtil pTxtIngresaCelular,
														CajaTextoUtil pTxtConfirmaCelular)throws Exception{
		try{
			
			this.validarFormatoCelularXTercero(pBooTipoTercero,false);
			
			pTxtConfirmaCelular.setText(pTxtIngresaCelular.getText());
			
		}catch(Exception e){}
	}
	
	/**
  	 * ****************************************************************.
  	 * @method configurar
  	 * 		   Permite realizar la configuracion previa que requiere
  	 * 		   el tipo de clave de seguridad especifico para operar
  	 * @param  pFrmGnrOfrecerClaveSeguridad
	 * 		   Forma principal desde donde se controla todo el proceso para
	 * 		   asginar el tipo de clave de seguridad
  	 * @param  pConfigOfrecerClaveSeguridadDTO
  	 * 		   Objeto DTO que contiene toda la configuracion relacionada con 
	 * 		   el proceso de ofrecer el servicio de clave de seguridad
  	 * @param  pTipoClaveSeguridadDTO
  	 * 		   Objeto DTO que almacena los diferentes datos requeridos
  	 * 		   para el procesamiento del tipo de clave de seguridad 
  	 * 		   especifico
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @author Roberth Martinez Vargas
  	 * @date   29/3/2016
  	 * ****************************************************************
  	 */
	public void configurar(FormaOfrecerClaveSeguridad pFrmGnrOfrecerClaveSeguridad,
						   ConfigOfrecerClaveSeguridadDTO pConfigOfrecerClaveSeguridadDTO,
						   TipoClaveSeguridadDTO pTipoClaveSeguridadDTO)throws Exception{
		
		this.setTipoClaveSeguridadAutomaticaDTO((TipoClaveSeguridadAutomaticaDTO) pTipoClaveSeguridadDTO);
		this.setConfigOfrecerClaveSeguridadDTO(pConfigOfrecerClaveSeguridadDTO);
		this.setObjFacturaGiro(pConfigOfrecerClaveSeguridadDTO.getObjFacturaGiro());
		super.setFrmForma(pFrmGnrOfrecerClaveSeguridad);
		
		this.configuracionCampoTexto();
		this.cargarFormulario();
	}
	
	/** ********************************************************************
	 * @method ejecutar
	 * 		   Validaciones realizadas al presionar confirmar en la ventana 
	 * 		   principal para diligenciar un proceso de clave de seguridad
	 * 		   automatica
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   4/3/2016
	 * *********************************************************************
	 */
	public void ejecutar() throws Exception {
		
		ClaveSeguridadAutomatica objClaveSeguridadAutomatica;
		
		this.validarFormatoCelularXTercero(true,true);
		this.validarFormatoCelularXTercero(false,true);
		this.validarNumerosCelular();
		
		objClaveSeguridadAutomatica = new ClaveSeguridadAutomatica(EnumTiposClaveSeguridad.AUTOMATICA);
		
		this.getObjFacturaGiro().setObjClaveSeguridad(objClaveSeguridadAutomatica);
	}
	
	/** ********************************************************************
	 * @method limpiar
	 * 		   limpia componentes de la forma
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   23/3/2016
	 * *********************************************************************
	 */
	public void limpiar() throws Exception {

		this.getFrmPnlTipoClaveSeguridadAutomatica().getTxtConfirmaCelularRemitente().setText("");
		this.getFrmPnlTipoClaveSeguridadAutomatica().getTxtConfirmaCelularDestinatario().setText("");
	}
	
	/**
  	 * ****************************************************************
  	 * @method validarFormatoCelularXTercero
  	 * 		   Metodo para validar que los campos de telefono celular
  	 * 		   cumplan con el formato
  	 * @param  pBooTipoTercero
  	 * 		   Bandera que identifica el tipo de tercero 
  	 * 		   (Remitente/Destinatario) que pretende validar el formato 
  	 * 		   de celular, true y false respectivamente
  	 * @param  pBooValidarAmbosCampos
  	 * 		   Bandera que permite identificar si la validacion del 
  	 * 		   formato se ejecutara para ambos campos (ingresar y 
  	 * 		   confirmar), o si solo se llevara a cabo para ingresar, 
  	 * 		   true y false respectivamente 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @author Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	private void validarFormatoCelularXTercero(boolean pBooTipoTercero,
											   boolean pBooValidarAmbosCampos) throws Exception {
		
		PropiedadesTexto iPrpTxtIngresar;
		PropiedadesTexto iPrpTxtConfirmar;
		String strNombreCampoIngresar;
		String strNombreCampoConfirmar;
		
		if(pBooTipoTercero){//Remitente
			
			strNombreCampoIngresar = EnumEtiquetas.LBL_PNL_CSA_INGRESAR_CELULAR.getValor(false,
					 																	 EnumEtiquetas.TTL_PNL_CSA_SECCION_REMITENTE.toString());

			iPrpTxtIngresar = this.getFrmPnlTipoClaveSeguridadAutomatica().getTxtIngresaCelularRemitente().getPropiedades();
			
		}else{//Destinatario
		
			strNombreCampoIngresar = EnumEtiquetas.LBL_PNL_CSA_INGRESAR_CELULAR.getValor(false,
					 																	 EnumEtiquetas.TTL_PNL_CSA_SECCION_DESTINATARIO.toString());

			iPrpTxtIngresar = this.getFrmPnlTipoClaveSeguridadAutomatica().getTxtIngresaCelularDestinatario().getPropiedades();
		}
		
		iPrpTxtIngresar.validaFormatoFinal(true,
				   						   strNombreCampoIngresar);
		
		if(pBooValidarAmbosCampos){
			
			if(pBooTipoTercero){//Remitente
				
				strNombreCampoConfirmar = EnumEtiquetas.LBL_PNL_CSA_CONFIRMAR_CELULAR.getValor(false,
						   																	   EnumEtiquetas.TTL_PNL_CSA_SECCION_REMITENTE.toString());

				iPrpTxtConfirmar = this.getFrmPnlTipoClaveSeguridadAutomatica().getTxtConfirmaCelularRemitente().getPropiedades();
				
			}else{//Destinatario
				
				strNombreCampoConfirmar = EnumEtiquetas.LBL_PNL_CSA_CONFIRMAR_CELULAR.getValor(false,
						   																	   EnumEtiquetas.TTL_PNL_CSA_SECCION_DESTINATARIO.toString());

				iPrpTxtConfirmar = this.getFrmPnlTipoClaveSeguridadAutomatica().getTxtConfirmaCelularDestinatario().getPropiedades();
			}
			
			iPrpTxtConfirmar.validaFormatoFinal(true,
												strNombreCampoConfirmar);
		}
	}
	
	/**
  	 * ****************************************************************
  	 * @method validarNumerosCelular
  	 * 		   Metodo para validar las acciones cuando se realiza clave
  	 * 		   automatico
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @author Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	private void validarNumerosCelular() throws Exception {
		
		String strTelRemitente;
		String strTelRemiConfirma;
		String strTelDestinatario;
		String strTelDestiConfirma;
		String strTelRemitenteOld;
		String strTelDestinatarioOld;
		
		strTelRemitente = this.getFrmPnlTipoClaveSeguridadAutomatica().getTxtIngresaCelularRemitente().getText();
		strTelRemiConfirma = this.getFrmPnlTipoClaveSeguridadAutomatica().getTxtConfirmaCelularRemitente().getText();
		strTelDestinatario = this.getFrmPnlTipoClaveSeguridadAutomatica().getTxtIngresaCelularDestinatario().getText();
		strTelDestiConfirma = this.getFrmPnlTipoClaveSeguridadAutomatica().getTxtConfirmaCelularDestinatario().getText();
		
		if (!strTelRemitente.equals(strTelRemiConfirma)) {
			
			throw EnumMensajes.TKN_TELS_REMITENTE_DIFERENTES.generarExcepcion(EnumClasesMensaje.ERROR);
		}
		
		if (!strTelDestinatario.equals(strTelDestiConfirma)) {
			
			throw EnumMensajes.TKN_TELS_DESTINATARIO_DIFERENTES.generarExcepcion(EnumClasesMensaje.ERROR);
		}
		
		strTelRemitenteOld = this.getObjFacturaGiro().getTerceroOrigen().getTelefono2();
		strTelDestinatarioOld = this.getObjTerceroDestino().getTelefono2();
		
		this.getObjFacturaGiro().getTerceroOrigen().setTelefono2(strTelRemitente);
		this.getObjTerceroDestino().setTelefono2(strTelDestinatario);
		
		ValidacionesTercero.getInstance().validaActualizaCelularTercero(strTelRemitenteOld, 
																			 this.getObjFacturaGiro().getTerceroOrigen(), 
																			 super.getFrmForma());
		
		ValidacionesTercero.getInstance().validaActualizaCelularTercero(strTelDestinatarioOld, 
																			 this.getObjTerceroDestino(), 
																			 super.getFrmForma());
		
	}

	/**
	 * @method getObjFacturaGiro
	 * 		   Metodo get del atributo objFacturaGiro
	 * @return FacturaGiro
	 *		   Valor del atributo objFacturaGiro devuelto
	 * @author roberth.martinez
	 * @date   4/3/2016
	 */
	public FacturaGiro getObjFacturaGiro() {
		return this.objFacturaGiro;
	}

	/**
	 * @method setObjFacturaGiro
	 * 		   Metodo set del atributo objFacturaGiro
	 * @param  pObjFacturaGiro
	 *		   Valor que tomara el atributo objFacturaGiro
	 * @author roberth.martinez
	 * @date   4/3/2016
	 */
	public void setObjFacturaGiro(FacturaGiro pObjFacturaGiro) {
		this.objFacturaGiro = pObjFacturaGiro;
	}

	/**
	 * @method getTipoTokenValidaAutomaticoDTO
	 * 		   Metodo get del atributo tipoClaveSeguridadAutomaticaDTO
	 * @return TipoClaveSeguridadAutomaticaDTO
	 *		   Valor del atributo tipoClaveSeguridadAutomaticaDTO devuelto
	 * @author roberth.martinez
	 * @date   4/3/2016
	 */
	public TipoClaveSeguridadAutomaticaDTO getTipoClaveSeguridadAutomaticoDTO() {
		return this.tipoClaveSeguridadAutomaticaDTO;
	}

	/**
	 * @method setTipoClaveSeguridadAutomaticaDTO
	 * 		   Metodo set del atributo tipoClaveSeguridadAutomaticaDTO
	 * @param  pTipoClaveSeguridadAutomaticaDTO
	 *		   Valor que tomara el atributo tipoClaveSeguridadAutomaticaDTO
	 * @author roberth.martinez
	 * @date   4/3/2016
	 */
	public void setTipoClaveSeguridadAutomaticaDTO(TipoClaveSeguridadAutomaticaDTO pTipoClaveSeguridadAutomaticaDTO) {
		this.tipoClaveSeguridadAutomaticaDTO = pTipoClaveSeguridadAutomaticaDTO;
	}

	/**
	 * @method getFrmPnlTipoClaveSeguridadAutomatica
	 * 		   Metodo get del atributo frmPnlTipoClaveSeguridadAutomatica
	 * @return FormaPanelTipoClaveSeguridadAutomatica
	 *		   Valor del atributo frmPnlTipoClaveSeguridadAutomatica devuelto
	 * @author roberth.martinez
	 * @date   4/3/2016
	 */
	public FormaPanelTipoClaveSeguridadAutomatica getFrmPnlTipoClaveSeguridadAutomatica() {
		return this.frmPnlTipoClaveSeguridadAutomatica;
	}

	/**
	 * @method setFrmPnlTipoClaveSeguridadAutomatica
	 * 		   Metodo set del atributo frmPnlTipoClaveSeguridadAutomatica
	 * @param  pFrmPnlTipoClaveSeguridadAutomatica
	 *		   Valor que tomara el atributo frmPnlTipoClaveSeguridadAutomatica
	 * @author roberth.martinez
	 * @date   4/3/2016
	 */
	public void setFrmPnlTipoClaveSeguridadAutomatica(FormaPanelTipoClaveSeguridadAutomatica pFrmPnlTipoClaveSeguridadAutomatica) {
		this.frmPnlTipoClaveSeguridadAutomatica = pFrmPnlTipoClaveSeguridadAutomatica;
	}

	/**
	 * @method getConfigOfrecerClaveSeguridadDTO
	 * 		   Metodo get del atributo configOfrecerClaveSeguridadDTO
	 * @return ConfigOfrecerClaveSeguridadDTO
	 *		   Valor del atributo configOfrecerClaveSeguridadDTO devuelto
	 * @author roberth.martinez
	 * @date   18/3/2016
	 */
	public ConfigOfrecerClaveSeguridadDTO getConfigOfrecerClaveSeguridadDTO() {
		return configOfrecerClaveSeguridadDTO;
	}

	/**
	 * @method setConfigOfrecerClaveSeguridadDTO
	 * 		   Metodo set del atributo configOfrecerClaveSeguridadDTO
	 * @param  pConfigOfrecerClaveSeguridadDTO
	 *		   Valor que tomara el atributo configOfrecerClaveSeguridadDTO
	 * @author roberth.martinez
	 * @date   18/3/2016
	 */
	public void setConfigOfrecerClaveSeguridadDTO(ConfigOfrecerClaveSeguridadDTO pConfigOfrecerClaveSeguridadDTO) {
		this.configOfrecerClaveSeguridadDTO = pConfigOfrecerClaveSeguridadDTO;
	}

	/**
	 * @method getObjTerceroDestino
	 * 		   Metodo get del atributo objTerceroDestino
	 * @return Tercero
	 *		   Valor del atributo objTerceroDestino devuelto
	 * @author roberth.martinez
	 * @date   18/3/2016
	 */
	public Tercero getObjTerceroDestino() {
		return objTerceroDestino;
	}

	/**
	 * @method setObjTerceroDestino
	 * 		   Metodo set del atributo objTerceroDestino
	 * @param  pObjTerceroDestino
	 *		   Valor que tomara el atributo objTerceroDestino
	 * @author roberth.martinez
	 * @date   18/3/2016
	 */
	public void setObjTerceroDestino(Tercero pObjTerceroDestino) {
		this.objTerceroDestino = pObjTerceroDestino;
	}
	
}

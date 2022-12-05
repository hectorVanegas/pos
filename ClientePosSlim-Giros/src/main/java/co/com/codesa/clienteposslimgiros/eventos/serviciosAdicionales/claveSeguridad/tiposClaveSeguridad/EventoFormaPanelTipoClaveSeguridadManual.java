package co.com.codesa.clienteposslimgiros.eventos.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad;

import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.ConfigOfrecerClaveSeguridadDTO;
import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad.TipoClaveSeguridadDTO;
import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad.TipoClaveSeguridadManualDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.cifrados.EnumProcesosCifrado;
import co.com.codesa.clienteposslimgiros.enumeraciones.serviciosAdicionales.claveSeguridad.EnumTiposClaveSeguridad;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.claveSeguridad.FormaOfrecerClaveSeguridad;
import co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad.FormaPanelTipoClaveSeguridadManual;
import co.com.codesa.clienteposslimgiros.utilidades.serviciosAdicionales.claveSeguridad.UtilClaveSeguridad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ClaveSeguridadManual;


/** ********************************************************************
 * @class  EventoFormaPanelTipoClaveSeguridadManual
 *		   Clase que controla los eventos de la seccion dedicada a 
 *		   diligenciar un tipo de clave de seguridad manual
 * @author roberth.martinez
 * @date   4/3/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class EventoFormaPanelTipoClaveSeguridadManual extends EventoAbstracto {
	
	/**
	 * @variable objFacturaGiro
	 * 			 objeto factura giro
	 */
	private FacturaGiro objFacturaGiro;
	/**
	 * @variable tipoClaveSeguridadManualDTO
	 * 			 objeto que relaciona la dto para clave de seguridad manual
	 */
	private TipoClaveSeguridadManualDTO tipoClaveSeguridadManualDTO;
	/**
	 * @variable frmPnlTipoClaveSeguridadManual
	 * 			 objeto que referencia a la seccion de la cual se estan controlando
	 * 			 los eventos
	 */
	private FormaPanelTipoClaveSeguridadManual frmPnlTipoClaveSeguridadManual;
	
	/** ********************************************************************
	 * @method EventoFormaPanelTipoClaveSeguridadManual
	 * 		   constructor de la clase EventoFormaPanelTipoClaveSeguridadManual 
	 * @param  pFrmPnlTipoClaveSeguridadManual
	 * 		   objeto de la forma clave de seguridad manual
	 * @author roberth.martinez
	 * @date   4/3/2016
	 * *********************************************************************
	 */
	public EventoFormaPanelTipoClaveSeguridadManual(FormaPanelTipoClaveSeguridadManual pFrmPnlTipoClaveSeguridadManual) {
		
		super(pFrmPnlTipoClaveSeguridadManual.getFrmGnrPadre());
		this.setFrmPnlTipoClaveSeguridadManual(pFrmPnlTipoClaveSeguridadManual);
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
		
		this.setTipoClaveSeguridadManualDTO((TipoClaveSeguridadManualDTO) pTipoClaveSeguridadDTO);
		this.setObjFacturaGiro(pConfigOfrecerClaveSeguridadDTO.getObjFacturaGiro());
		
		this.configuracionCampoTexto();
	}
	
	/** ********************************************************************
	 * @method ejecutar
	 * 		   Validaciones realizadas al presionar confirmar en la ventana 
	 * 		   principal para diligenciar un proceso de clave de seguridad
	 * 		   manual
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   4/3/2016
	 * *********************************************************************
	 */
	public void ejecutar() throws Exception {
		
		String strClave;
		String strClaveConfirma;
		String strClaveCifrada;
		ClaveSeguridadManual objClaveSeguridadManual;
		
		
		this.getFrmPnlTipoClaveSeguridadManual().getPfiIngresarClave().getPropiedades().validaFormatoFinal(true,
																									   	   EnumEtiquetas.LBL_PNL_CSM_INGRESAR_CLAVE.toString());
		
		this.getFrmPnlTipoClaveSeguridadManual().getPfiConfirmarClave().getPropiedades().validaFormatoFinal(true,
				   																							EnumEtiquetas.LBL_PNL_CSM_CONFIRMAR_CLAVE.toString());
		
		strClave = this.getFrmPnlTipoClaveSeguridadManual().getPfiIngresarClave().getText().toUpperCase();
		strClaveConfirma = this.getFrmPnlTipoClaveSeguridadManual().getPfiConfirmarClave().getText().toUpperCase();
		
		if (strClave.equals(strClaveConfirma)) {
		
			/*
			strClave	=	UtilClaveSeguridad.getInstancia().generarClaveAleatoria	(	this.getTipoClaveSeguridadManualDTO().getIntLongitudMinimaClave(),
																						this.getTipoClaveSeguridadManualDTO().getIntLongitudMaximaClave()
																					);
			*/
			strClaveCifrada = EnumProcesosCifrado.CLAVE_SEGURIDAD.cifrar(strClave);
			objClaveSeguridadManual = new ClaveSeguridadManual(EnumTiposClaveSeguridad.MANUAL);
			objClaveSeguridadManual.setStrClave(strClave);
			objClaveSeguridadManual.setStrClaveCifrada(strClaveCifrada);
			this.getObjFacturaGiro().setObjClaveSeguridad(objClaveSeguridadManual);
			
		}else {
			
			throw EnumMensajes.TKN_CLAVES_DIFERENTES.generarExcepcion(EnumClasesMensaje.ERROR);
		}
		
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
		
		this.getFrmPnlTipoClaveSeguridadManual().getPnlTxtPrtIngresarClave ().limpiar ();
		this.getFrmPnlTipoClaveSeguridadManual().getPnlTxtPrtConfirmarClave ().limpiar ();
		//this.getFrmPnlTipoClaveSeguridadManual().getPfiIngresarClave().setText("");
		//this.getFrmPnlTipoClaveSeguridadManual().getPfiConfirmarClave().setText("");
	}
	
	/**
     * ****************************************************************
     * @metodo  configuracionCampoTexto
     *			metodo utilizado para inicializar la configuracion de los 
     *		   	campos de texto de la forma/seccion de la cual se estan 
     *		   	controlando los eventos
     * @throws  Exception
     * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */
	private void configuracionCampoTexto()throws Exception{
		
		String strExpresionRegularIngreso;
		String strExpresionRegularFinal;
		String longitudMinima = "<longitud_minima>";
		String longitudMaxima = "<longitud_maxima>";
		
		strExpresionRegularIngreso = EnumExpresionesRegulares.PNL_CSM_CLAVE_INGRESO.getValor();
		strExpresionRegularFinal = EnumExpresionesRegulares.PNL_CSM_CLAVE.getValor();
		
		strExpresionRegularIngreso = strExpresionRegularIngreso.replace(longitudMaxima, String.valueOf(this.tipoClaveSeguridadManualDTO.getIntLongitudMaximaClave()));
		strExpresionRegularFinal = strExpresionRegularFinal.replaceAll(longitudMinima, String.valueOf(this.tipoClaveSeguridadManualDTO.getIntLongitudMinimaClave()));
		strExpresionRegularFinal = strExpresionRegularFinal.replaceAll(longitudMaxima, String.valueOf(this.tipoClaveSeguridadManualDTO.getIntLongitudMaximaClave()));
		
		this.getFrmPnlTipoClaveSeguridadManual().getPfiIngresarClave().getLblObligatorio().aplicarObligatoriedad(true);
		this.getFrmPnlTipoClaveSeguridadManual().getPfiIngresarClave().getPropiedades().setControlFormatoIngreso(strExpresionRegularIngreso);
		this.getFrmPnlTipoClaveSeguridadManual().getPfiIngresarClave().getPropiedades().setControlFormatoFinal(strExpresionRegularFinal);
		
		this.getFrmPnlTipoClaveSeguridadManual().getPfiConfirmarClave().getLblObligatorio().aplicarObligatoriedad(true);
		this.getFrmPnlTipoClaveSeguridadManual().getPfiConfirmarClave().getPropiedades().setControlFormatoIngreso(strExpresionRegularIngreso);
		this.getFrmPnlTipoClaveSeguridadManual().getPfiConfirmarClave().getPropiedades().setControlFormatoFinal(strExpresionRegularFinal);

		this.getFrmPnlTipoClaveSeguridadManual().getLblClaveDebe().setText(EnumEtiquetas.LBL_PNL_CSM_CLAVE_DEBE.getValor(false, 
																														 String.valueOf(this.tipoClaveSeguridadManualDTO.getIntLongitudMinimaClave()),
																														 String.valueOf(this.tipoClaveSeguridadManualDTO.getIntLongitudMaximaClave())));
	}

	/**
	 * @method getFrmPnlTipoClaveSeguridadManual
	 * 		   Metodo get del atributo frmPnlTipoClaveSeguridadManual
	 * @return FormaPanelTipoTokenValidaManual
	 *		   Valor del atributo frmPnlTipoClaveSeguridadManual devuelto
	 * @author roberth.martinez
	 * @date   4/3/2016
	 */
	public FormaPanelTipoClaveSeguridadManual getFrmPnlTipoClaveSeguridadManual() {
		return this.frmPnlTipoClaveSeguridadManual;
	}

	/**
	 * @method setFrmPnlTipoClaveSeguridadManual
	 * 		   Metodo set del atributo frmPnlTipoClaveSeguridadManual
	 * @param  pFrmPnlTipoClaveSeguridadManual
	 *		   Valor que tomara el atributo frmPnlTipoClaveSeguridadManual
	 * @author roberth.martinez
	 * @date   4/3/2016
	 */
	public void setFrmPnlTipoClaveSeguridadManual(
			FormaPanelTipoClaveSeguridadManual pFrmPnlTipoClaveSeguridadManual) {
		this.frmPnlTipoClaveSeguridadManual = pFrmPnlTipoClaveSeguridadManual;
	}

	/**
	 * @method getObjFacturaGiro
	 * 		   Metodo get del atributo objFacturaGiro
	 * @return FacturaGiro
	 *		   Valor del atributo objFacturaGiro devuelto
	 * @author roberth.martinez
	 * @date   9/3/2016
	 */
	public FacturaGiro getObjFacturaGiro() {
		return objFacturaGiro;
	}

	/**
	 * @method setObjFacturaGiro
	 * 		   Metodo set del atributo objFacturaGiro
	 * @param  pObjFacturaGiro
	 *		   Valor que tomara el atributo objFacturaGiro
	 * @author roberth.martinez
	 * @date   9/3/2016
	 */
	public void setObjFacturaGiro(FacturaGiro pObjFacturaGiro) {
		this.objFacturaGiro = pObjFacturaGiro;
	}

	/**
	 * @method getTipoClaveSeguridadManualDTO
	 * 		   Metodo get del atributo tipoClaveSeguridadManualDTO
	 * @return TipoClaveSeguridadManualDTO
	 *		   Valor del atributo tipoClaveSeguridadManualDTO devuelto
	 * @author roberth.martinez
	 * @date   29/3/2016
	 */
	public TipoClaveSeguridadManualDTO getTipoClaveSeguridadManualDTO() {
		return this.tipoClaveSeguridadManualDTO;
	}

	/**
	 * @method setTipoClaveSeguridadManualDTO
	 * 		   Metodo set del atributo tipoClaveSeguridadManualDTO
	 * @param  pTipoClaveSeguridadManualDTO
	 *		   Valor que tomara el atributo tipoClaveSeguridadManualDTO
	 * @author roberth.martinez
	 * @date   29/3/2016
	 */
	public void setTipoClaveSeguridadManualDTO(
			TipoClaveSeguridadManualDTO pTipoClaveSeguridadManualDTO) {
		this.tipoClaveSeguridadManualDTO = pTipoClaveSeguridadManualDTO;
	}
}

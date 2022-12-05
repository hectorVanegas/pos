package co.com.codesa.clienteposslimgiros.eventos.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad;

import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.ConfigOfrecerClaveSeguridadDTO;
import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad.TipoClaveSeguridadDTO;
import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad.TipoClaveSeguridadNoGraciasDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.serviciosAdicionales.claveSeguridad.EnumTiposClaveSeguridad;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.claveSeguridad.FormaOfrecerClaveSeguridad;
import co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad.FormaPanelTipoClaveSeguridadNoGracias;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ClaveSeguridadNoGracias;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;

/** ********************************************************************
 * @class  EventoFormaPanelTipoClaveSeguridadNoGracias
 *		   Clase que controla los eventos de la seccion dedicada a 
 *		   diligenciar un tipo de clave de seguridad no gracias
 * @author roberth.martinez
 * @date   4/3/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class EventoFormaPanelTipoClaveSeguridadNoGracias extends EventoAbstracto {
	
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
	 * @variable tipoClaveSeguridadNoGraciasDTO
	 * 			 objeto que relaciona la dto para clave de seguridad no gracias
	 */
	private TipoClaveSeguridadNoGraciasDTO tipoClaveSeguridadNoGraciasDTO;
	
	/**
	 * @variable configOfrecerClaveSeguridadDTO
	 * 			 Dto para manejo de datos necesarios para ofrecer la clave de seguridad
	 */
	private ConfigOfrecerClaveSeguridadDTO configOfrecerClaveSeguridadDTO;
	
	/**
	 * @variable frmPnlTipoClaveSeguridadNoGracias
	 * 			 objeto que referencia a la seccion de la cual se estan controlando
	 * 			 los eventos
	 */
	private FormaPanelTipoClaveSeguridadNoGracias frmPnlTipoClaveSeguridadNoGracias;
	
	/** ********************************************************************
	 * @method EventoFormaPanelTipoClaveSeguridadNoGracias
	 * 		   constructor de la clase EventoFormaPanelTipoClaveSeguridadNoGracias
	 * @param  pFrmPnlTipoClaveSeguridadNoGracias
	 * 		   objeto de la forma clave de seguridad no gracias
	 * @author roberth.martinez
	 * @date   4/3/2016
	 * *********************************************************************
	 */
	public EventoFormaPanelTipoClaveSeguridadNoGracias(FormaPanelTipoClaveSeguridadNoGracias pFrmPnlTipoClaveSeguridadNoGracias) {
		
		super(pFrmPnlTipoClaveSeguridadNoGracias.getFrmGnrPadre());
		this.setFrmPnlTipoClaveSeguridadNoGracias(pFrmPnlTipoClaveSeguridadNoGracias);
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
		
		this.setTipoClaveSeguridadNoGraciasDTO((TipoClaveSeguridadNoGraciasDTO) pTipoClaveSeguridadDTO);
		this.setConfigOfrecerClaveSeguridadDTO(pConfigOfrecerClaveSeguridadDTO);
		this.setObjFacturaGiro(pConfigOfrecerClaveSeguridadDTO.getObjFacturaGiro());
		super.setFrmForma(pFrmGnrOfrecerClaveSeguridad);
	}
	
	/** ********************************************************************
	 * @method ejecutar
	 * 		   Validaciones realizadas al presionar confirmar en la ventana 
	 * 		   principal para diligenciar un proceso de clave de seguridad
	 * 		   no gracias
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   4/3/2016
	 * *********************************************************************
	 */
	public void ejecutar() throws Exception {
		
		ClaveSeguridadNoGracias objClaveSeguridadNoGracias;
		
		objClaveSeguridadNoGracias = new ClaveSeguridadNoGracias(EnumTiposClaveSeguridad.NO_GRACIAS);
		
		this.getObjFacturaGiro().setObjClaveSeguridad(objClaveSeguridadNoGracias);
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
	 * @method getTipoClaveSeguridadNoGraciasDTO
	 * 		   Metodo get del atributo tipoClaveSeguridadNoGraciasDTO
	 * @return TipoClaveSeguridadAutomaticaDTO
	 *		   Valor del atributo tipoClaveSeguridadNoGraciasDTO devuelto
	 * @author roberth.martinez
	 * @date   4/3/2016
	 */
	public TipoClaveSeguridadNoGraciasDTO getTipoClaveSeguridadNoGraciasDTO() {
		return this.tipoClaveSeguridadNoGraciasDTO;
	}

	/**
	 * @method setTipoClaveSeguridadNoGraciasDTO
	 * 		   Metodo set del atributo tipoClaveSeguridadNoGraciasDTO
	 * @param  pTipoClaveSeguridadNoGraciasDTO
	 *		   Valor que tomara el atributo tipoClaveSeguridadNoGraciasDTO
	 * @author roberth.martinez
	 * @date   4/3/2016
	 */
	public void setTipoClaveSeguridadNoGraciasDTO(TipoClaveSeguridadNoGraciasDTO pTipoClaveSeguridadNoGraciasDTO) {
		this.tipoClaveSeguridadNoGraciasDTO = pTipoClaveSeguridadNoGraciasDTO;
	}

	/**
	 * @method getFrmPnlTipoClaveSeguridadNoGracias
	 * 		   Metodo get del atributo frmPnlTipoClaveSeguridadNoGracias
	 * @return FormaPanelTipoClaveSeguridadAutomatica
	 *		   Valor del atributo frmPnlTipoClaveSeguridadNoGracias devuelto
	 * @author roberth.martinez
	 * @date   4/3/2016
	 */
	public FormaPanelTipoClaveSeguridadNoGracias getFrmPnlTipoClaveSeguridadNoGracias() {
		return this.frmPnlTipoClaveSeguridadNoGracias;
	}

	/**
	 * @method setFrmPnlTipoClaveSeguridadNoGracias
	 * 		   Metodo set del atributo frmPnlTipoClaveSeguridadNoGracias
	 * @param  pFrmPnlTipoClaveSeguridadNoGracias
	 *		   Valor que tomara el atributo frmPnlTipoClaveSeguridadNoGracias
	 * @author roberth.martinez
	 * @date   4/3/2016
	 */
	public void setFrmPnlTipoClaveSeguridadNoGracias(FormaPanelTipoClaveSeguridadNoGracias pFrmPnlTipoClaveSeguridadNoGracias) {
		this.frmPnlTipoClaveSeguridadNoGracias = pFrmPnlTipoClaveSeguridadNoGracias;
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

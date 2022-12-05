package co.com.codesa.clienteposslimgiros.eventos.superCombo;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.superCombo.FormaProtegiroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiroInternacional;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

/** 
 * ********************************************************************
 * @class	EventoFormaPagoGiroInternacional
 *		 	Clase encargada de controlar los eventos de la forma de
 * 		  	protegiro en el pago de giro internacional
 * @author	roberth.martinez
 * @date  	22/04/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class EventoFormaProtegiroInternacional extends EventoAbstracto{
	
	/**
	 * @variable	objFacturaGiroInternacional
	 * 				objeto factura giro internacional con los datos del giro
	 */
	private FacturaGiroInternacional objFacturaGiroInternacional;
	
	/**
	 * ********************************************************************
	 * @method	EventoFormaPagoGiroInternacional
	 * 		  	Constructor que ejecuta la inicializacion de valores y 
  	 * 		  	ejecucion de comportamientos inicales requeridos para el 
  	 * 		   	despliegue de sus acciones
	 * @param 	pForma
	 * 			referencia a la GUI de la cual se estan controlando los 
  	 * 		  	eventos
	 * @param 	pObjFacturaGiroInternacional
	 * 			objeto factura del cual se esta llevando a cabo la 
  	 * 		  	transaccion
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	22/04/2018
	 * *********************************************************************
	 */
	public EventoFormaProtegiroInternacional(FormaGenerica pForma,
									   	     FacturaGiroInternacional pObjFacturaGiroInternacional) throws Exception{
		super(pForma);
		
		this.objFacturaGiroInternacional = pObjFacturaGiroInternacional;
	}
	
	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma) throws Exception{
		
		this.llenarInformacionFormulario();
		
		this.configuracionCamposTexto();
	}
	
	@Override
	public void confirmar() throws Exception {
		
		this.validarFormatoCelular();
		super.regresarFormaPadre();
		
	}
	
	@Override
	public void cancelar() throws Exception {

		this.objFacturaGiroInternacional.setDouValorPrima(0);
		//super.cancelar();
		super.regresarFormaPadre();
	}
	
	@Override
	public void accionarCerrandoVentana(java.awt.event.WindowEvent pEvtWindowClosing) throws Exception {
		
	}
	
	/** 
	 * ********************************************************************
	 * @method	llenarInformacionFormulario
	 * 		  	metodo para llenar los datos de la forma Protegiro en el
	 * 		    pago internacional
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	22/04/2018
	 * *********************************************************************
	 */
	private void llenarInformacionFormulario()throws Exception{
		
		String strTelTerceroDestino;
		
		strTelTerceroDestino = this.objFacturaGiroInternacional.getTerceroDestino().getTelefono1().equals("0") ? "" : this.objFacturaGiroInternacional.getTerceroDestino().getTelefono1();	
		
		this.castfrmProtegiroInternacional().getTxtTipoIdentificacion().setText(objFacturaGiroInternacional.getTerceroDestino().getTipoIdentificacion().getId());
		this.castfrmProtegiroInternacional().getTxtIdentificacion().setText(objFacturaGiroInternacional.getTerceroDestino().getIdentificacion());
		this.castfrmProtegiroInternacional().getTxtNombre().setText(objFacturaGiroInternacional.getTerceroDestino().getNombres());
		this.castfrmProtegiroInternacional().getTxtTelefono().setText(strTelTerceroDestino);
		this.castfrmProtegiroInternacional().getLblVlrProtegiro().setText(UtilidadGiros.getInstancia().formatoPresentacionNumero(this.objFacturaGiroInternacional.getDouValorPrima()));
		this.castfrmProtegiroInternacional().getLblVlrPrima().setText(UtilidadGiros.getInstancia().formatoPresentacionNumero(this.objFacturaGiroInternacional.getFacturaSeguro().getValorAsegurado()));
	}
	

	/** 
	 * ********************************************************************
	 * @method	configuracionCamposTexto
	 * 		  	encargado de gestionar la configuracion personalizada
  	 * 		   	para los diferentes campos de texto del formulario
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	23/04/2018
	 * *********************************************************************
	 */
	private void configuracionCamposTexto() throws Exception{
		
		this.castfrmProtegiroInternacional().getTxtTelefono().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_INGRESO_CELULAR.getValor());
		this.castfrmProtegiroInternacional().getTxtTelefono().getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.EXP_REG_FORMATO_CELULAR_TERCERO.getValor());
		
	}
	
	
	
	/** 
	 * ********************************************************************
	 * @method	validarFormatoCelular
	 * 		  	Metodo para validar que los campos de telefono celular
  	 * 		    cumplan con el formato
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	23/04/2018
	 * *********************************************************************
	 */
	private void validarFormatoCelular() throws Exception {
		
		
		this.castfrmProtegiroInternacional().getTxtTelefono().getPropiedades().validaFormatoFinal(true,
																								  this.castfrmProtegiroInternacional().getLblTelefono().getTextoOriginal());
		
		if (this.castfrmProtegiroInternacional().getTxtTelefono().equals("")) {
			this.objFacturaGiroInternacional.getTerceroDestino().setTelefono1("*");
		}
	}
	
	/**
	 * @method	getObjFacturaGiroInternacional
	 * 		  	Metodo get del atributo objFacturaGiroInternacional
	 * @return	FacturaGiroInternacional
	 *		  	Valor del atributo objFacturaGiroInternacional devuelto
	 * @author	roberth.martinez
	 * @date  	30/04/2018
	 */
	public FacturaGiroInternacional getObjFacturaGiroInternacional() {
		return this.objFacturaGiroInternacional;
	}

	/**
	 * @method	setObjFacturaGiroInternacional
	 * 		  	Metodo set del atributo objFacturaGiroInternacional
	 * @param	pObjFacturaGiroInternacional
	 * 			Valor que tomara el atributo objFacturaGiroInternacional
	 * @author	roberth.martinez
	 * @date	30/04/2018
	 */
	public void setObjFacturaGiroInternacional(
			FacturaGiroInternacional pObjFacturaGiroInternacional) {
		this.objFacturaGiroInternacional = pObjFacturaGiroInternacional;
	}

	/** 
	 * ********************************************************************
	 * @method	castFrmPagoGiroInternacional
	 * 		  	Metodo estandar para formatear el tipo de dato general a 
  	 * 		    un tipo especifico ("Casteo"), del atributo 
  	 * 		    FormaProtegiroInternacional
	 * @return	FormaProtegiroInternacional
  	 * 		   	valor especifico recuperado
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	22/04/2018
	 * *********************************************************************
	 */
	public FormaProtegiroInternacional castfrmProtegiroInternacional()throws Exception{
		return (FormaProtegiroInternacional)super.getFrmForma();
	}

}

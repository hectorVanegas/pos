package co.com.codesa.clienteposslimgiros.eventos.superCombo;

import java.awt.event.WindowEvent;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.superCombo.FormaAnulacionProtegiroInternacional;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.vista.logica.GiroInternacionalVistaLogica;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

/** 
 * ********************************************************************
 * @class	EventoFormaAnulacionProtegiroInternacional
 *		 	Clase encargada de controlar los eventos de la forma de
 * 		  	anulacion de protegiro internacional
 * @author	roberth.martinez
 * @date  	30/04/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class EventoFormaAnulacionProtegiroInternacional extends EventoAbstracto{
	
	/**
	 * ********************************************************************
	 * @method	EventoFormaAnulacionProtegiroInternacional
	 * 		  	Constructor que ejecuta la inicializacion de valores y 
  	 * 		  	ejecucion de comportamientos inicales requeridos para el 
  	 * 		   	despliegue de sus acciones
	 * @param 	pForma
	 * 			referencia a la GUI de la cual se estan controlando los 
  	 * 		  	eventos
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	30/04/2018
	 * *********************************************************************
	 */
	public EventoFormaAnulacionProtegiroInternacional(FormaGenerica pForma) throws Exception{
		super(pForma);
	}
	
	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma) throws Exception{
		
		this.configuracionCamposTexto();
	}
	
	@Override
	public void confirmar() throws Exception {
		
		String  strResultadoAnulacion;

		UtilComponentesGUI.getInstance().validarCamposObligatorios (super.getFrmForma(),
																	true,
																	true);
		
		strResultadoAnulacion = GiroInternacionalVistaLogica.getInstancia().anularProtegiroInternacional(getObjUsuario(), 
																				 					     this.castfrmAnulacionProtegiroInternacional().getTxtReferenciaSeguro().getText(), 
																				 					     this.castfrmAnulacionProtegiroInternacional().getTxtvlrDelGiro().getText().replaceAll(",", ""));
		
		EnumMensajes.PROTEGIRO_INTERNACIONAL_ANULADO_EXITOSAMENTE.desplegarMensaje(getFrmForma(), 
																				   EnumClasesMensaje.INFORMACION, 
																				   strResultadoAnulacion);
		
		super.salir();
		
	}
	
	public void accionarVentanaDesplegada(WindowEvent pEvtWindowOpened) throws Exception {
		
		this.castfrmAnulacionProtegiroInternacional().getTxtReferenciaSeguro().getLblObligatorio().aplicarObligatoriedad(true);
		this.castfrmAnulacionProtegiroInternacional().getTxtvlrDelGiro().getLblObligatorio().aplicarObligatoriedad(true);
		
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
	 * @date	30/04/2018
	 * *********************************************************************
	 */
	private void configuracionCamposTexto() throws Exception{
		
		this.castfrmAnulacionProtegiroInternacional().getTxtReferenciaSeguro().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_PIN_GIRO.getValor());
		
		this.castfrmAnulacionProtegiroInternacional().getTxtvlrDelGiro().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_DINERO_GIRO.getValor());
		this.castfrmAnulacionProtegiroInternacional().getTxtvlrDelGiro().getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.EXP_REG_FORMATO_DINERO_GIRO.getValor());
		this.castfrmAnulacionProtegiroInternacional().getTxtvlrDelGiro().getPropiedades().setFormatoSalida(UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO());
		
	}
	
	/** 
	 * ********************************************************************
	 * @method	castFrmPagoGiroInternacional
	 * 		  	Metodo estandar para formatear el tipo de dato general a 
  	 * 		    un tipo especifico ("Casteo"), del atributo 
  	 * 		    FormaAnulacionProtegiroInternacional
	 * @return	FormaAnulacionProtegiroInternacional
  	 * 		   	valor especifico recuperado
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	30/04/2018
	 * *********************************************************************
	 */
	public FormaAnulacionProtegiroInternacional castfrmAnulacionProtegiroInternacional()throws Exception{
		return (FormaAnulacionProtegiroInternacional)super.getFrmForma();
	}

}

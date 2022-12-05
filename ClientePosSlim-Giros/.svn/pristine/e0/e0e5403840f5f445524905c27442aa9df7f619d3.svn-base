package co.com.codesa.clienteposslimgiros.eventos.biometria.internacional;

import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.biometria.internacional.FormaPanelDedoBiometriaSeleccionado;
import co.com.codesa.clienteposslimgiros.utilidades.biometria.internacional.UtilDedosInternacional;
import co.com.codesa.clienteposslimgiros.utilidades.biometria.internacional.UtilManosInternacional;


/**
 * ********************************************************************
 * @class	EventoFormaPanelDedoBiometriaSeleccionado
 *		 	Clase encargada de controlar los eventos de la forma para
 *			seleccionar del dedo a aplicar los procesos de 
 *			biometria
 * @author	hector.cuenca
 * @date  	28/03/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class EventoFormaPanelDedoBiometriaSeleccionado extends EventoAbstracto{

	/**
	 * @variable 	frmPnlDedoBiometriaSeleccionado
	 * 		     	Seccion de tipo forma, de la cual se estan controlando los 
	 * 				eventos
	 **/
	private FormaPanelDedoBiometriaSeleccionado frmPnlDedoBiometriaSeleccionado;
	
	/**
	 * ********************************************************************
	 * @method	EventoFormaPanelDedoBiometriaSeleccionado
	 * 		  	Constructor que ejecuta la inicializacion de valores y 
  	 * 		   	ejecucion de comportamientos iniciales requeridos para el 
  	 * 		   	despliegue de sus acciones
	 * @param 	pFrmPnlDedoBiometriaSeleccionado
	 * 			Referencia a la GUI de la cual se estan controlando los 
  	 * 		  	eventos
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author	hector.cuenca
	 * @date	26/03/2018
	 * *********************************************************************
	 */
	public EventoFormaPanelDedoBiometriaSeleccionado(FormaPanelDedoBiometriaSeleccionado pFrmPnlDedoBiometriaSeleccionado)
		throws Exception
	{
		super(pFrmPnlDedoBiometriaSeleccionado.getFrmGnrPadre());
		this.setFrmPnlDedoBiometriaSeleccionado(pFrmPnlDedoBiometriaSeleccionado);
	}
	
	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma)
		throws Exception
	{
		this.cargarFormulario();
	}
	
	/**
	 * ********************************************************************
	 * @method	cargarFormulario
	 * 		  	Metodo encargado de realizar el cargue del formulario
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author	hector.cuenca
	 * @date	28/03/2018
	 * *********************************************************************
	 */
	private void cargarFormulario()
		throws Exception
	{
		this.getFrmPnlDedoBiometriaSeleccionado().getCmbTipoMano().getPropiedades().cargarCombo(	UtilManosInternacional.getInstancia().getHmObjManos().values().toArray(), 
					   																				true, 
					   																				null
					   																			);
		
		this.getFrmPnlDedoBiometriaSeleccionado().getCmbTipoDedo().getPropiedades().cargarCombo(	UtilDedosInternacional.getInstancia().getHmObjDedos().values().toArray(), 
																									true, 
																									null
																								);	
	}

	/**
	 * @method	getFrmPnlDedoBiometriaSeleccionado
	 * 		  	Metodo get del atributo frmPnlDedoBiometriaSeleccionado
	 * @return	FormaPanelDedoBiometriaSeleccionado
	 *		  	Valor del atributo frmPnlDedoBiometriaSeleccionado devuelto
	 * @author	hector.cuenca
	 * @date  	28/03/2018
	 */
	public FormaPanelDedoBiometriaSeleccionado getFrmPnlDedoBiometriaSeleccionado() {
		return frmPnlDedoBiometriaSeleccionado;
	}

	/**
	 * @method	setFrmPnlDedoBiometriaSeleccionado
	 * 		  	Metodo set del atributo frmPnlDedoBiometriaSeleccionado
	 * @param	pFrmPnlDedoBiometriaSeleccionado
	 * 			Valor que tomara el atributo frmPnlDedoBiometriaSeleccionado
	 * @author	hector.cuenca
	 * @date	28/03/2018
	 */
	public void setFrmPnlDedoBiometriaSeleccionado(
			FormaPanelDedoBiometriaSeleccionado pFrmPnlDedoBiometriaSeleccionado) {
		this.frmPnlDedoBiometriaSeleccionado = pFrmPnlDedoBiometriaSeleccionado;
	}
	
}

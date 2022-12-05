package co.com.codesa.clienteposslimgiros.eventos.generico;

import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelCodigoDescripcion;
import co.com.codesa.clienteposslimgiros.interfaces.genericas.PropiedadesPanelCodigoDescripcion;

/** 
 * ********************************************************************
 * @class  	EventoFormaPanelCodigoDescripcion
 *		   	Clase que controla los eventos de la seccion generica que
 *			representa la informacion basica de una entidad u objeto
 *			(codigo y descripcion)
 * @author 	hector.cuenca
 * @date   	3/05/2017
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class EventoFormaPanelCodigoDescripcion extends EventoAbstracto implements PropiedadesPanelCodigoDescripcion{

	/**
	 * @variable	frmPnlCodigoDescripcion
	 * 			 	Referencia al componente del cual se estan controlando los 
  	 * 		   	 	eventos
	 */
	private FormaPanelCodigoDescripcion frmPnlCodigoDescripcion;
	
	/** 
	 * ********************************************************************
	 * @method 	EventoFormaPanelCodigoDescripcion
	 * 		   	Constructor de la seccion generica, que se encarga de 
	 * 		   	inicializar los atributos y comportamientos en el proceso de
	 * 		   	construccion
	 * @param	pFrmPnlCodigoDescripcion
	 * 			Referencia al componente del cual se estan controlando los 
  	 * 		   	eventos
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author 	hector.cuenca
	 * @date   	3/05/2017
	 * *********************************************************************
	 */
	public EventoFormaPanelCodigoDescripcion	(	FormaPanelCodigoDescripcion pFrmPnlCodigoDescripcion	)
			throws Exception
	{
		super(pFrmPnlCodigoDescripcion.getFrmGnrPadre());
		
		pFrmPnlCodigoDescripcion.setPropiedades(this);
		this.setFrmPnlCodigoDescripcion(pFrmPnlCodigoDescripcion);
	}

	@Override
	public void limpiarCampos	()
			throws Exception
	{
		this.getFrmPnlCodigoDescripcion().getTxtCodigo().setText("");
		this.getFrmPnlCodigoDescripcion().getTxtDescripcion().setText("");
	}
	
	@Override
	public void asignarDatos	(	String pStrCodigo,
									String pStrDescripcion
								)
			throws Exception
	{
		this.getFrmPnlCodigoDescripcion().getTxtCodigo().setText(pStrCodigo);
		this.getFrmPnlCodigoDescripcion().getTxtDescripcion().setText(pStrDescripcion);
	}
	
	/**
	 * @method getFrmPnlCodigoDescripcion
	 * 		   Metodo get del atributo frmPnlCodigoDescripcion
	 * @return FormaPanelCodigoDescripcion
	 *		   Valor del atributo frmPnlCodigoDescripcion devuelto
	 * @author hector.cuenca
	 * @date   3/05/2017
	 */
	public FormaPanelCodigoDescripcion getFrmPnlCodigoDescripcion() {
		return frmPnlCodigoDescripcion;
	}

	/**
	 * @method setFrmPnlCodigoDescripcion
	 * 		   Metodo set del atributo frmPnlCodigoDescripcion
	 * @param  pFrmPnlCodigoDescripcion
	 *		   Valor que tomara el atributo frmPnlCodigoDescripcion
	 * @author hector.cuenca
	 * @date   3/05/2017
	 */
	public void setFrmPnlCodigoDescripcion(FormaPanelCodigoDescripcion pFrmPnlCodigoDescripcion) {
		this.frmPnlCodigoDescripcion = pFrmPnlCodigoDescripcion;
	}
}
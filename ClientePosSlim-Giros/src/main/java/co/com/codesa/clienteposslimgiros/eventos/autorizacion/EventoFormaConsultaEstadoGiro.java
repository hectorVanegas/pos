package co.com.codesa.clienteposslimgiros.eventos.autorizacion;

import java.awt.event.WindowEvent;

import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.autorizacion.FormaConsultaEstadoGiro;

/** 
 * ********************************************************************
 * @class  	EventoFormaConsultaEstadoGiro
 *		   	Clase que representa los eventos de la forma para consultar
 *			el estado de un giro
 * @author 	hector.cuenca
 * @date   	2/05/2017
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
@Deprecated
public class EventoFormaConsultaEstadoGiro extends EventoAbstracto
{
	
	/** 
	 * ********************************************************************
	 * @method 	EventoFormaConsultaEstadoGiro
	 * 		   	Constructor que ejecuta la inicializacion de valores y 
  	 * 		   	ejecucion de comportamientos inicales requeridos para el 
  	 * 		   	despliegue de sus acciones
	 * @param 	pForma
	 * 			Referencia a la GUI de la cual se estan controlando los 
  	 * 		  	eventos
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	2/05/2017
	 * *********************************************************************
	 */
	public EventoFormaConsultaEstadoGiro(	FormaConsultaEstadoGiro pForma	) 
			throws Exception
	{
		super(pForma);
	}
	
	@Override
	public void iniciarValores	(	Object ...pArrObjParametrosForma	)
			throws Exception
	{
		this.cargarFormulario();
	}
	
	@Override
	public void accionarVentanaDesplegada	(	WindowEvent pEvtWindowOpened	) 
			throws Exception 
	{
		/*
		this.castFrmReimpresion().getCmbTipoReimpresion().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmReimpresion().getCmbListaReimpresiones().getLblObligatorio().aplicarObligatoriedad(true);
		
		if(this.enmReimpresionXDefecto != null){
		
			this.castFrmReimpresion().getCmbTipoReimpresion().setEnabled(false);
			this.castFrmReimpresion().getCmbListaReimpresiones().setEnabled(false);
			
			EnumMensajes.VERIFICAR_TRANSACCION_PENDIENTE.desplegarMensaje(super.getFrmForma(), 
					  													  EnumClasesMensaje.ADVERTENCIA);
		}
		*/
	}
	
	/** 
	 * ********************************************************************
	 * @method 	cargarFormulario
	 * 		   	Metodo que se encarga de gestionar el cargue de la 
  	 * 		   	informacion sobre el formulario
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	hector.cuenca
	 * @date   	2/05/2017
	 * *********************************************************************
	 */
	private	void cargarFormulario	()	
			throws Exception
	{
		
	}
	
	/** 
	 * ********************************************************************
	 * @method 	castFrmReimpresion
	 * 		   	Metodo estandar para formatear el tipo de dato general a 
  	 * 		   	un tipo especifico ("Casteo"), del atributo padre frmForma
	 * @return	FormaConsultaEstadoGiro
	 * 			valor especifico recuperado
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	2/05/2017
	 * *********************************************************************
	 */
	public FormaConsultaEstadoGiro castFrmReimpresion	()
			throws Exception
	{
		return (FormaConsultaEstadoGiro)super.getFrmForma(); 
	}
}

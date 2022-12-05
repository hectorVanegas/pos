package co.com.codesa.clienteposslimgiros.eventos.generico;

import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 19-mar-2015 
 * @clase EventoFormaDatosAdicionales
 * 		  Clase encargada de controlar los eventos de la forma para  
 * 		  gestionar datos adicionales
 * @copyright Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class EventoFormaDatosAdicionales extends EventoAbstracto{
	
	/**
  	 * ****************************************************************.
  	 * @metodo EventoFormaDireccion
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de sus acciones
  	 * @param pForma
  	 * 		  referencia a la GUI de la cual se estan controlando los 
  	 * 		  eventos
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EventoFormaDatosAdicionales(FormaGenerica pForma) throws Exception{
		super(pForma);
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarValores
  	 * 		   Metodo que permite desacoplar y centralizar todo el 
  	 * 		   despliegue logico inicial requerido por la funcionalidad 
  	 * 		   una vez desplegada la GUI
  	 * @param pArrObjParametrosForma
  	 * 		  lista de parametros de forma, para un posible uso por parte
  	 * 		  del despliegue inicial de valores
  	 * 		  [x]: descripcion del valor enviado en la posicion [x]
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma) throws Exception{
		
		FormaGenerica frmPadre;
		
		if(super.getFrmForma().getFrmPadre() instanceof FormaGenerica){
			
			frmPadre = (FormaGenerica)super.getFrmForma().getFrmPadre();
			frmPadre.getEventoForma().iniciarValoresDatosAdicionales(super.getFrmForma().getPnlContenidoCuerpo());
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo confirmar
  	 * 		   Metodo que ejecuta las acciones referentes al boton de 
  	 * 		   operacion representativo para confirmar
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public void confirmar() throws Exception{
		
		FormaGenerica frmPadre;
		
		UtilComponentesGUI.getInstance().validarCamposObligatorios	(	super.getFrmForma(), 
				   														true, 
				   														true
				   													);
		
		if(super.getFrmForma().getFrmPadre() instanceof FormaGenerica){
			
			frmPadre = (FormaGenerica)super.getFrmForma().getFrmPadre();
			frmPadre.getEventoForma().validaDatosAdicionales(super.getFrmForma().getPnlContenidoCuerpo());
			super.getFrmForma().dispose();
			
		}else{
			super.getFrmForma().dispose();
		}
	}
}

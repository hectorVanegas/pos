/**
 * 
 */
package co.com.codesa.clienteposslimgiros.eventos.pago;


import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.WindowEvent;

import co.com.codesa.clienteposslim.controladoretiquetas.ControladorEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.facturacion.FormaGicoAutomatico;

/**
 * ****************************************************************.
 * @autor david.marquez
 * @fecha 25-nov-2020
 * @clase EventoFormaGicoAutomatico
 * 		  Clase encargada de controlar los eventos de la forma.
 * @copyright Copyright  1998-2020 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class EventoFormaGicoAutomatico extends EventoAbstracto{
		
	/**
  	 * ****************************************************************.
  	 * @metodo EventoFormaGicoAutomatico
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de sus acciones
  	 * @param  pForma
  	 * 		   referencia a la GUI de la cual se estan controlando los 
  	 * 		   eventos
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor  david.marquez
  	 * ****************************************************************
  	 */
	public EventoFormaGicoAutomatico(FormaGenerica pForma) throws Exception {
		super(pForma);
	}
	
	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma)throws Exception{
		this.validarDespliegueComboGicoAut();
	}
	
	@Override
	public void accionarVentanaDesplegada(WindowEvent pEvtWindowOpened) throws Exception {
		
	}
	
	@Override
	public void accionarCambioItem(Component pComponent,
								   ItemEvent pEvtItemStateChanged)throws Exception{
	}
	
	@Override
	public	void limpiar()	
			throws Exception 
	{		
		super.limpiar();
	}

	@Override
	public void confirmar() throws Exception {
		ValidaAlmacenaSeleccionUsuario();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo ValidaAlmacenaSeleccionUsuario
  	 * 		   Valida que el usuario seleccionó una opcion entre
  	 * 		   remitente o beneficiario. Tambien almancena la seleccion
  	 * 		   para en la forma padre.
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor  david.marquez
  	 * ****************************************************************
  	 */
	private void ValidaAlmacenaSeleccionUsuario() throws Exception {
		String strSeleccionUsuario = "";
		
		strSeleccionUsuario = this.castFrmGicoAutomatico().getcmbSolicitudGico().getSelectedItem().toString();
		
		// Se valida que el usuario seleccione una opción 
		if(!strSeleccionUsuario.equals("") && strSeleccionUsuario != null && 
			(strSeleccionUsuario.equals("REMITENTE") || strSeleccionUsuario.equals("BENEFICIARIO"))) {
			this.castFrmGicoAutomatico().strSeleccionUsuario = strSeleccionUsuario;
			super.regresarFormaPadre();
		}
		else {
			throw EnumMensajes.GICO_AUTOMATICO_SE_DEBE_SELECCIONAR.generarExcepcion(EnumClasesMensaje.ERROR);
		}
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	validarDespliegueComboGicoAut
	 * 		  	Metodo encargado de pintar la opcion de combo para la 
	 * 			funcionalidad de TerceroPeps
	 * @throws  Exception
  	 * 		    Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada 
	 * @author	david.marquez
	 * @date	25/nov/2020
	 * *********************************************************************
	 */
	private void validarDespliegueComboGicoAut() throws Exception{		
		this.cargarComboSolicitudGico();
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	cargarComboSolicitudGico
	 * 		  	Metodo encargado de listar las opciones del combo.
	 * @throws  Exception
  	 * 		    Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada 
	 * @author	david.marquez
	 * @date	25/nov/2019
	 * *********************************************************************
	 */
	private void cargarComboSolicitudGico() throws Exception{
		
		//REMITENTE
		//BENEFICIARIO
		this.castFrmGicoAutomatico().getcmbSolicitudGico().getPropiedades().cargarCombo(new String [] {"REMITENTE",
																									   "BENEFICIARIO"
																									  }, 
																									  true, 
																									  EnumEtiquetas.LBL_NO_SELECCIONADO);
	}
	
	public FormaGicoAutomatico castFrmGicoAutomatico()throws Exception{
		return (FormaGicoAutomatico)super.getFrmForma();
	}

}

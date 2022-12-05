package co.com.codesa.clienteposslimgiros.eventos.ayuda;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.List;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumAyudas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumOperacionesAyuda;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.ayuda.FormaAyuda;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 08-ene-2016 
 * @clase EventoFormaAyuda
 * 		  Clase encargada de controlar los eventos de la forma de  
 * 		  ayuda
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class EventoFormaAyuda extends EventoAbstracto{
	
	/**
	 * @variable enmAyuda 
	 * 			 Constante de enumeracion de ayuda, que contiene toda la 
  	 * 		  	 parametrizacion y administracion necesaria para el despliegue
  	 * 		  	 de las ayudas relacionadas con la funcionalidad
	 **/
	private EnumAyudas enmAyuda;
	
	/**
	 * @variable enmOperacionSeleccionada 
	 * 			 Constante de enumeracion que simboliza la operacion por 
  	 * 		  	 defecto de interes, que debe aparecer seleccionada
	 **/
	private EnumOperacionesAyuda enmOperacionSeleccionada;
	
	/**
	 * @variable lstSeccionesXAyuda 
	 * 			 Listado de secciones disponibles a desplegar por ayuda
	 **/
	private List<SeccionUtil> lstSeccionesXAyuda;
	
	/**
	 * @variable intIdentificadorAyuda
	 * 			 Identifica la posicion de la ayuda desplegada, con respecto al
	 * 			 listado de ayudas obtenidas para la operacion
	 **/
	private int intIdentificadorAyuda;
	
	/**
  	 * ****************************************************************.
  	 * @metodo EventoFormaAyuda
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de sus acciones
  	 * @param pForma 
  	 * 		  referencia a la GUI de la cual se estan controlando los 
  	 * 		  eventos
  	 * @param pEnmAyuda
  	 * 		  Constante de enumeracion de ayuda, que contiene toda la 
  	 * 		  parametrizacion y administracion necesaria para el despliegue
  	 * 		  de las ayudas relacionadas con la funcionalidad
  	 * @param pEnmOperacionSeleccionada
  	 * 		  Constante de enumeracion que simboliza la operacion por 
  	 * 		  defecto de interes, que debe aparecer seleccionada
  	 * @param pIntIdSeccionXDefecto
  	 * 		  Identificador de la seccion de ayuda referente a la operacion
  	 * 		  seleccionada, que debera aparecer al cargar la funcionalidad 
  	 * 		  de ayudas
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EventoFormaAyuda(FormaGenerica pForma,
							EnumAyudas pEnmAyuda,
							EnumOperacionesAyuda pEnmOperacionSeleccionada,
							Integer pIntIdSeccionXDefecto) throws Exception{
		
		super(pForma);
		
		this.enmAyuda = pEnmAyuda;
		this.enmOperacionSeleccionada = pEnmOperacionSeleccionada;
		
		if(pIntIdSeccionXDefecto!=null){
		
			this.intIdentificadorAyuda = pIntIdSeccionXDefecto;
			
		}else{
			
			this.intIdentificadorAyuda = 0;
		}
	}
	
	@Override
	public  void iniciarValores(Object ...pArrObjParametrosForma) throws Exception {
		
		this.castFrmAyuda().getLstOperaciones().setListData(this.enmAyuda.getEnmOperaciones());
		
		this.castFrmAyuda().getLstOperaciones().setSelectedValue(this.enmOperacionSeleccionada, 
																 true);
		
		this.cargarAyudas(this.obtenerOperacionSeleccionada());
	};
	
	@Override
	public void accionarEjecucion(Component pComponent, 
								  AWTEvent pEvtEjecucion) throws Exception {
		
		if(pComponent.equals(this.castFrmAyuda().getLstOperaciones())){
			
			this.cargarAyudas(this.obtenerOperacionSeleccionada());
			
		}else if(pComponent.equals(this.castFrmAyuda().getBtnAtras())){
			
			this.mostrarAyudaResultante(false);
			
		}else if(pComponent.equals(this.castFrmAyuda().getBtnAdelante())){
			
			this.mostrarAyudaResultante(true);
			
		}else{
			
			super.accionarEjecucion(pComponent,
									pEvtEjecucion);
		}
	};
	
	@Override
	public void accionarDobleClick(Component pObjComponent, 
								   MouseEvent pEvtMouseClicked) throws Exception {
		
		if(pObjComponent.equals(this.castFrmAyuda().getLstOperaciones())){

			this.cargarAyudas(this.obtenerOperacionSeleccionada());
			
		}else{
			
			super.accionarDobleClick(pObjComponent,
									 pEvtMouseClicked);
		}
	};
	
	/**
  	 * ****************************************************************.
  	 * @metodo cargarAyudas
  	 * 		   Metodo que permite realizar el cargue de ayudas de una 
  	 * 	       operacion seleccionada de la lista de operaciones
  	 * @param pEnmOperacionSeleccionada 
  	 * 		  Operacion seleccionada del listado de operaciones referentes
  	 * 		  a la funcionalidad
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void cargarAyudas(EnumOperacionesAyuda pEnmOperacionSeleccionada)throws Exception{
		
		SeccionUtil pnlSeccionAyuda;
		
		pnlSeccionAyuda = null;
		
		if(pEnmOperacionSeleccionada!=null){
		
			this.lstSeccionesXAyuda = pEnmOperacionSeleccionada.obtenerSeccionesAyuda();
			
			if(this.lstSeccionesXAyuda!=null 
					&& !this.lstSeccionesXAyuda.isEmpty()){
				
				if(this.intIdentificadorAyuda > this.lstSeccionesXAyuda.size()-1){
					
					this.intIdentificadorAyuda = 0;
				}
				
				pnlSeccionAyuda = this.lstSeccionesXAyuda.get(this.intIdentificadorAyuda); 
			}
			
		}else{
			
			this.lstSeccionesXAyuda = null;
		}
		
		this.desplegarAyuda(pnlSeccionAyuda,
							null);
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo mostrarAyudaResultante
  	 * 		   Metodo que permite avanzar o retroceder sobre la 
  	 * 		   presentacion del listado de ayudas referentes a la operacion
  	 * 		   seleccionada
  	 * @param pBooAvanzarRetroceder 
  	 * 		  Bandera que permite identificar si se debe mostrar la 
  	 * 		  siguiente o la anterior ayuda, dependiendo del interes de
  	 * 		  la accion
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void mostrarAyudaResultante(boolean pBooAvanzarRetroceder)throws Exception{
		
		SeccionUtil pnlSeccionAyudaNueva;
		SeccionUtil pnlSeccionAyudaActual;
		
		pnlSeccionAyudaActual = this.lstSeccionesXAyuda.get(this.intIdentificadorAyuda);
		
		if(pBooAvanzarRetroceder){
			
			this.intIdentificadorAyuda++;
			
		}else{
			
			this.intIdentificadorAyuda--;
		}
		
		pnlSeccionAyudaNueva = this.lstSeccionesXAyuda.get(this.intIdentificadorAyuda); 
		
		this.desplegarAyuda(pnlSeccionAyudaNueva,
							pnlSeccionAyudaActual);
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo desplegarAyuda
  	 * 		   Metodo que permite desplegar una ayuda sobre la seccion
  	 * 		   de presentacion
  	 * @param pPnlSeccionAyudaNueva 
  	 * 		  Seccion que contiene toda la informacion relacionada con
  	 * 		  la ayuda en cuestion que se quiere incorporar sobre la
  	 * 		  seccion de presentacion
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void desplegarAyuda(SeccionUtil pPnlSeccionAyudaNueva,
								SeccionUtil pPnlSeccionAyudaActual)throws Exception{
		
		if(pPnlSeccionAyudaNueva==null){
			
			this.castFrmAyuda().getScpPresentacion().setViewportView(this.castFrmAyuda().iniciarPropPnlAyudaVacia());
			
		}else{
			
			this.castFrmAyuda().getScpPresentacion().setViewportView(pPnlSeccionAyudaNueva);
		}
		
		this.validarDinamicaBotonesControlAyudas();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo validarDinamicaBotonesControlAyudas
  	 * 		   Metodo que permite validar la dinamica de los botones para
  	 * 		   controlar la presentacion de ayudas 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void validarDinamicaBotonesControlAyudas()throws Exception{
		
		boolean booEstadoBotonAtras;
		boolean booEstadoBotonAdelante;
		
		if(this.lstSeccionesXAyuda==null
				|| this.lstSeccionesXAyuda.isEmpty()
				|| this.lstSeccionesXAyuda.size()==1){
			
			booEstadoBotonAtras = false;
			booEstadoBotonAdelante = false;
			
		}else{
			
			if(this.intIdentificadorAyuda == 0){
				
				booEstadoBotonAtras = false;
				booEstadoBotonAdelante = true;
				
			}else if(this.intIdentificadorAyuda==this.lstSeccionesXAyuda.size()-1){
				
				booEstadoBotonAtras = true;
				booEstadoBotonAdelante = false;
				
			}else{
				
				booEstadoBotonAtras = true;
				booEstadoBotonAdelante = true;
			}
		}
		
		this.castFrmAyuda().getBtnAtras().setEnabled(booEstadoBotonAtras);
		this.castFrmAyuda().getBtnAdelante().setEnabled(booEstadoBotonAdelante);
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo obtenerOperacionSeleccionada
  	 * 		   Metodo que permite detectar y obtener la operacion 
  	 * 		   seleccionada del listado de operaciones
  	 * @return EnumOperacionesAyuda
  	 * 		   Operacion seleccionada del listado de operaciones
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private EnumOperacionesAyuda obtenerOperacionSeleccionada()throws Exception{
		
		Object objValorSeleccionado;
		
		objValorSeleccionado = this.castFrmAyuda().getLstOperaciones().getSelectedValue();
		
		if(objValorSeleccionado instanceof EnumOperacionesAyuda){
			
			this.enmOperacionSeleccionada = (EnumOperacionesAyuda)objValorSeleccionado;
			
		}else{
			
			this.enmOperacionSeleccionada = null;
		}
		
		return this.enmOperacionSeleccionada;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo castFrmAyuda
  	 * 		   Metodo estandar para formatear el tipo de dato general a 
  	 * 		   un tipo especifico ("Casteo"), del atributo padre frmForma
  	 * @return FormaAyuda
  	 * 		   valor especifico recuperado
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaAyuda castFrmAyuda()throws Exception{
		return (FormaAyuda)super.getFrmForma(); 
	}

}

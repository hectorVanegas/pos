package co.com.codesa.clienteposslimgiros.eventos.serviciosAdicionales;

import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;

import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.ServicioAdicionalDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.operaciones.EnumTiposOperaciones;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.FormaPanelServicioAdicional;
import co.com.codesa.clienteposslimgiros.interfaces.serviciosAdicionales.IOperacionesServiciosAdicionales;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.objetos.UtilObjeto;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;

/**
 * ********************************************************************
 * @class  EventoFormaPanelServicioAdicional
 *		   Clase encargada de controlar los eventos de la forma panel 
 *		   (seccion), que representa un servicio adicional
 * @param <T> 
 * 		  Representacion generica de objetos DTO del tipo 
 * 		  ServicioAdicionalDTO
 * @author hector.cuenca
 * @date   7/03/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public abstract class EventoFormaPanelServicioAdicional<T extends ServicioAdicionalDTO> extends EventoAbstracto implements IOperacionesServiciosAdicionales<T>{
	
	/**
	 * @variable frmPnlServicioAdicional
	 * 			 Referencia al componente del cual se estan controlando los 
  	 * 		   	 eventos
	 */
	private FormaPanelServicioAdicional<T> frmPnlServicioAdicional;
	
	/**
	 * @variable enmTipoOperacion
	 * 			 Tipo de operacion que se esta llevando a cabo, este 
	 * 			 atributo sera recibido en cada operacion relevante
	 * 			 del servicio adicional
	 */
	private EnumTiposOperaciones enmTipoOperacion;
	
	/**
	 * @variable objFacturaGiro
	 * 			 Objeto factura que contiene todo el detalle de la 
	 * 			 transaccion que se esta llevando a cabo, este 
	 * 			 atributo sera recibido en cada operacion relevante
	 * 			 del servicio adicional
	 */
	private FacturaGiro objFacturaGiro;
	
	/**
	 * @variable booOfrecer
	 * 			 Bandera que permite identificar si la seccion de token de 
	 * 		   	 validacion, esta disponible para ofrecer, para informar 
	 * 		   	 y/o verificar, o no aplica para la situacion (true,false y 
	 * 			 null respectivamnete), este atributo debera ser seteado 
	 * 			 directamente desde la funcionalidad que solitita la 
	 * 		 	 integracion
	 */
	private Boolean objBooOfrecer;
	
	/**
	 * @variable objBooServicioDisponible
	 * 			 Bandera que identifica si el servicio esta configurado y 
	 * 			 habilitado a nivel de BD 
	 */
	private Boolean objBooServicioDisponible;
	
	/**
	 * @variable booEstadoServicioModificado
	 * 			 bandera que permite identificar si la operacion de solicitar 
	 * 		 	 incluir servicio, equivalente a activar la caja verificada
	 * 		  	 es provocada directamente por el usuario o se debe a un 
	 * 			 proceso de deteccion interno, false y true respectivamente
	 */
	private boolean booEstadoServicioModificado;
	
	/**
	 * ********************************************************************
	 * @method EventoFormaOfrecerClaveSeguridad
	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de sus acciones
	 * @param  pFrmPnlServicioAdicional
	 * 		   Referencia al componente del cual se estan controlando los 
  	 * 		   eventos
	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author hector.cuenca
	 * @date   3/03/2016
	 * *********************************************************************
	 */
	public EventoFormaPanelServicioAdicional(FormaPanelServicioAdicional<T> pFrmPnlServicioAdicional) throws Exception{
		
		super(pFrmPnlServicioAdicional.getFrmGnrPadre());
		
		this.setFrmPnlServicioAdicional(pFrmPnlServicioAdicional);
	}
	
	/*
	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma) throws Exception {
		
		this.cargarFormulario();
	}
	*/
	
	@Override
	public void accionarFocoAdquirido(Component pComponent, 
									  FocusEvent pEvtFocusGained) throws Exception {
		
		if(this.getFrmPnlServicioAdicional().getCmbValor().equals(pComponent)){
			
			this.trasladarFocoCmbValor();
			
		}else{
			
			super.accionarFocoAdquirido(pComponent,
										pEvtFocusGained);
		}
	}
	
	@Override
	public void accionarCambioItem(Component pComponent, 
								   ItemEvent pEvtItemStateChanged) throws Exception {
		
		if(this.getFrmPnlServicioAdicional().getChkIncluir().equals(pComponent)){
			
			if(!this.isBooEstadoServicioModificado()){
			
				this.incluirServicio(this.getFrmPnlServicioAdicional().getChkIncluir().isSelected());
				
			}else{
				
				this.setBooEstadoServicioModificado(!this.isBooEstadoServicioModificado());
			}
			
		}else{
		
			super.accionarCambioItem(pComponent, 
									 pEvtItemStateChanged);
		}
	}
	
	@Override
	public void validarEstadoServicio(FacturaGiro pObjFacturaGiro, 
									  EnumTiposOperaciones pEnmTipoOperacion,
									  T pObjDtoServicioAdicional) throws Exception {
		
		if(this.getObjBooServicioDisponible().booleanValue()){
		
			if(this.getObjFacturaGiro() == null 
					||!this.getObjFacturaGiro().equals(pObjFacturaGiro)
					|| this.getEnmTipoOperacion() == null
					|| !this.getEnmTipoOperacion().equals(pEnmTipoOperacion)){
			
				this.setObjFacturaGiro(null);
				this.setEnmTipoOperacion(null);
				
				UtilidadesGiros.getInstance().validarObligatoriedadObjeto(this.frmPnlServicioAdicional.getEnmServicioAdicional().getEnmEtiNombre(), 
																		  this.frmPnlServicioAdicional.getArrStrParametrosNombre(), 
																		  new UtilObjeto<FacturaGiro>(pObjFacturaGiro,
																									  EnumEtiquetas.NMB_OBJ_NEG_FACTURA),
																		  new UtilObjeto<EnumTiposOperaciones>(pEnmTipoOperacion,
																											   EnumEtiquetas.NMB_OBJ_NEG_TIPO_OPERACION));
				this.validarServicio(pObjFacturaGiro,
						 			 pEnmTipoOperacion,
						 			 pObjDtoServicioAdicional);
			}
			
		}else{
			
			this.modificarEstadoServicio(false, 
										 EnumEtiquetas.LBL_NO_DISPONIBLE);
		}
	}
	
	@Override
	public boolean validaEjecucionServicio(FacturaGiro pObjFacturaGiro, 
										   EnumTiposOperaciones pEnmTipoOperacion,
										   T pObjDtoServicioAdicional) throws Exception{
		
		Object objSeleccionado;
		boolean booResultado;
		
		objSeleccionado = this.getFrmPnlServicioAdicional().getCmbValor().getSelectedItem();
		
		if(EnumEtiquetas.LBL_NO_SELECCIONADO.equals(objSeleccionado)
				|| EnumEtiquetas.LBL_NO_DISPONIBLE.equals(objSeleccionado)
				|| EnumEtiquetas.LBL_NO_APLICA.equals(objSeleccionado)){
			
			booResultado = false;
			
		}else{
			
			booResultado = true;
		}
	
		if(booResultado){
		
			booResultado = this.ejecutarServicio(pObjFacturaGiro,
												 pEnmTipoOperacion,
												 pObjDtoServicioAdicional);
		}
		
		return booResultado;
	}
	
	@Override
	public void restablecerEstadoServicio()throws Exception{
		
		EnumEtiquetas enmEtiCargarItem;
		
		if(this.getObjBooServicioDisponible()){
			
			enmEtiCargarItem = EnumEtiquetas.LBL_NO_SELECCIONADO;
			
		}else{
			
			enmEtiCargarItem = EnumEtiquetas.LBL_NO_DISPONIBLE;
		}
		
		this.modificarEstadoServicio(false, 
									 enmEtiCargarItem);
		
		this.setObjFacturaGiro(null);
		this.setEnmTipoOperacion(null);
	}
	
	/**
	 * ********************************************************************
	 * @method cargarFormulario
	 * 		   Metodo que se encarga de gestionar el cargue de la 
  	 * 		   informacion sobre el formulario
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author hector.cuenca
	 * @date   8/03/2016
	 * *********************************************************************
	 */
	private void cargarFormulario()throws Exception{
		
		this.getFrmPnlServicioAdicional().getCmbValor().getPropiedades().cargarCombo(this.obtenerListadoValoresServicio(), 
				 																	 true, 
				 																	 EnumEtiquetas.LBL_NO_SELECCIONADO);
		
		this.getFrmPnlServicioAdicional().getCmbValor().addItem(EnumEtiquetas.LBL_NO_DISPONIBLE);
		this.getFrmPnlServicioAdicional().getCmbValor().addItem(EnumEtiquetas.LBL_NO_APLICA);
	}
	
	/**
	 * ********************************************************************
	 * @method trasladarFocoCmbValor
	 * 		   Metodo que permite trasladar el foco del componente cmbValor, 
	 * 		   a otro componente, con la intencion de evitar el 
	 * 		   diligenciamiento del campo, sin tener que modificar su estado 
	 * 		   de edicion y/o habilitacion, dado que el nuevo componente que 
	 * 		   recuperara el foco, sera el encargado de permitir ese 
	 * 		   diligenciamiento
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author hector.cuenca
	 * @date   9/03/2016
	 * *********************************************************************
	 */
	private void trasladarFocoCmbValor()throws Exception{
		
		Component pComponenteFoco;
		
		if(this.getObjBooOfrecer()){
		
			pComponenteFoco = this.getFrmPnlServicioAdicional().getChkIncluir(); 
			
		}else{
			
			pComponenteFoco = super.getFrmForma().getFocusTraversalPolicy().getComponentAfter(super.getFrmForma(), 
																							  this.getFrmPnlServicioAdicional().getCmbValor());
		}
		
		pComponenteFoco.requestFocus();
	}

	/** 
	 * ********************************************************************
	 * @method accionarInternoChkIncluir
	 * 		   Metodo que permite modificar el estado de la caja verificada 
	 * 		   chkIncluir, sin ejecutar las acciones normales producidas 
	 * 		   por su seleccion, a traves del seteo de la bandera 
	 * 		   booEstadoServicioModificado
	 * @param  pBooActiva
	 * 		   Bandera que identifica si la accion sobre 
	 * 		   chkIncluir causara una activacion o una desactivacion, true y 
	 * 		   false respectivamente
	 * @param  pObjCargarItem
	 * 		   Referencia al objeto que se espera seleccionar sobre el
	 * 		   listado de posibles valores
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   10/03/2016
	 * *********************************************************************
	 */
	public void modificarEstadoServicio(boolean pBooActiva,
										Object pObjCargarItem)throws Exception{
		
		if(this.getFrmPnlServicioAdicional().getChkIncluir().isSelected() != pBooActiva){
		
			this.setBooEstadoServicioModificado(true);
			this.getFrmPnlServicioAdicional().getChkIncluir().setSelected(pBooActiva);
		}
		
		this.getFrmPnlServicioAdicional().getCmbValor().setSelectedItem(pObjCargarItem);
	}
	
	/** 
	 * ********************************************************************
	 * @method obtenerListadoValoresServicio
	 * 		   Metodo que permite obtener el listado de valores disponibles
	 * 		   particular para cada servicio
	 * @return Object[]
	 * 		   Listado de los valores que podra tomar el servicio cuando 
	 * 		   este es tomado
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author hector.cuenca
	 * @date   9/03/2016
	 * *********************************************************************
	 */   
	protected abstract Object[] obtenerListadoValoresServicio()throws Exception;
	
	/** 
	 * ********************************************************************
	 * @method incluirServicio
	 * 		   Metodo que traduce los comportamientos a ejecutar cuando el
	 * 		   usuario esta interesado en incluir el servicio
	 * @param  pBooActivado
	 * 		   Bandera que permite identificar si el componente evaluado
	 * 		   ha sido activado o desactivado, true y false respectivamente
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   9/03/2016
	 * *********************************************************************
	 */
	protected abstract void incluirServicio(boolean pBooActivado)throws Exception;
	
	/** 
	 * ********************************************************************
	 * @method ejecutarServicio
	 * 		   Metodo que permite ejecutar el servicio, este comportamiento 
	 * 		   tiene como intencion desplegar los procesos adicionales 
	 * 		   requeridos, obligatorios y particulares por el servicio para 
	 * 		   completar el objetivo de este, dentro de la transaccion 
	 * 		   efectuada  
	 * @param  pObjFacturaGiro
	 * 		   Objeto factura que contiene todo el detalle de la transaccion 
	 * 		   que se esta llevando a cabo
	 * @param  pEnmTipoOperacion
	 * 		   Tipo de operacion que se esta llevando a cabo
	 * @param  pObjDtoServicioAdicional
	 * 		   Objeto DTO propio del servicio adicional que se esta ejecutando
	 * @return boolean
	 * 		   Bandera que permite identificar si la ejecucion de los procesos 
	 * 		   adicionales desplegados por la inclusion del servicio, se 
	 * 		   llevaron a cabo satisfactoriamente
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   15/03/2016
	 * *********************************************************************
	 */
	protected abstract boolean ejecutarServicio(FacturaGiro pObjFacturaGiro,
		 		   							 	EnumTiposOperaciones pEnmTipoOperacion,
		 		   							 	T pObjDtoServicioAdicional)throws Exception;
	
	/** 
	 * ********************************************************************
	 * @method validarDisponibilidadServicio
	 * 		   Metodo que permite validar la disponibilidad del servicio,
	 * 		   si esta configurado y habilitado a nivel administrativo para
	 * 		   considerarse en los diferentes procesos de negocio
	 * @return boolean
	 * 		   Bandera que permite identificar si el servicio se encuentra
	 * 		   disponible a nivel administrativo (configurado y habilitado)
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   15/03/2016
	 * *********************************************************************
	 */
	protected abstract boolean validarDisponibilidadServicio()throws Exception;
	
	/** 
	 * ********************************************************************
	 * @method validarServicio
	 * 		   Metodo que permite validar y detectar el estado del servicio 
	 * 		   para la transaccion que se encuentra ejecutando el estado se 
	 * 		   otorgara de acuerdo a los parametros de entrada y se notificara 
	 * 		   en pantalla a traves del componente dedicado a contener el 
	 * 		   valor del servicio
	 * @param  pObjFacturaGiro
	 * 		   Objeto factura que contiene todo el detalle de la transaccion 
	 * 		   que se esta llevando a cabo
	 * @param  pEnmTipoOperacion
	 * 		   Tipo de operacion que se esta llevando a cabo
	 * @param  pObjDtoServicioAdicional
	 * 		   Objeto DTO propio del servicio adicional que se esta ejecutando
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   10/03/2016
	 * *********************************************************************
	 */ 
	protected abstract void validarServicio(FacturaGiro pObjFacturaGiro,
										 	EnumTiposOperaciones pEnmTipoOperacion,
										 	T pObjDtoServicioAdicional)throws Exception;

	/**
	 * @method getFrmPnlServicioAdicional
	 * 		   Metodo get del atributo frmPnlServicioAdicional
	 * @return FormaPanelServicioAdicional
	 *		   Valor del atributo frmPnlServicioAdicional devuelto
	 * @author hector.cuenca
	 * @date   11/03/2016
	 */
	public FormaPanelServicioAdicional<T> getFrmPnlServicioAdicional() {
		return this.frmPnlServicioAdicional;
	}

	/**
	 * @method setFrmPnlServicioAdicional
	 * 		   Metodo set del atributo frmPnlServicioAdicional
	 * @param  pFrmPnlServicioAdicional
	 *		   Valor que tomara el atributo frmPnlServicioAdicional
	 * @author hector.cuenca
	 * @date   11/03/2016
	 */
	public void setFrmPnlServicioAdicional(
			FormaPanelServicioAdicional<T> pFrmPnlServicioAdicional) {
		this.frmPnlServicioAdicional = pFrmPnlServicioAdicional;
	}

	/**
	 * @method getObjBooOfrecer
	 * 		   Metodo get del atributo objBooOfrecer
	 * @return Boolean
	 *		   Valor del atributo objBooOfrecer devuelto
	 * @author hector.cuenca
	 * @date   10/03/2016
	 */
	public Boolean getObjBooOfrecer() {
		return objBooOfrecer;
	}

	/**
	 * @method setObjBooOfrecer
	 * 		   Metodo set del atributo objBooOfrecer
	 * @param  pObjBooOfrecer
	 *		   Valor que tomara el atributo objBooOfrecer
	 * @author hector.cuenca
	 * @date   10/03/2016
	 */
	public void setObjBooOfrecer(Boolean pObjBooOfrecer) {
		
		boolean booHabilitarChkIncluyeTokenValidacion;
		boolean booHabilitarCmbTipoTokenValidacionSeleccionado;
		
		this.objBooOfrecer = pObjBooOfrecer;
		
		if(this.getObjBooOfrecer()==null){
			
			booHabilitarChkIncluyeTokenValidacion = false;
			booHabilitarCmbTipoTokenValidacionSeleccionado = false;
			
		}else if(this.getObjBooOfrecer().booleanValue()){
			
			booHabilitarChkIncluyeTokenValidacion = true;
			booHabilitarCmbTipoTokenValidacionSeleccionado = true;
			
		}else{
			
			booHabilitarChkIncluyeTokenValidacion = false;
			booHabilitarCmbTipoTokenValidacionSeleccionado = true;
		}
		
		this.getFrmPnlServicioAdicional().getChkIncluir().setEnabled(booHabilitarChkIncluyeTokenValidacion);
		this.getFrmPnlServicioAdicional().getCmbValor().setEnabled(booHabilitarCmbTipoTokenValidacionSeleccionado);
	}

	/**
	 * @method getObjBooServicioDisponible
	 * 		   Metodo get del atributo objBooServicioDisponible
	 * @return Boolean
	 *		   Valor del atributo objBooServicioDisponible devuelto
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   10/03/2016
	 */
	public Boolean getObjBooServicioDisponible()throws Exception{
		
		if(this.objBooServicioDisponible == null){
			
			this.objBooServicioDisponible = this.validarDisponibilidadServicio();
			this.cargarFormulario();
		}
		
		return this.objBooServicioDisponible;
	}

	/**
	 * @method setObjBooServicioDisponible
	 * 		   Metodo set del atributo objBooServicioDisponible
	 * @param  pObjBooServicioDisponible
	 *		   Valor que tomara el atributo objBooServicioDisponible
	 * @author hector.cuenca
	 * @date   10/03/2016
	 */
	public void setObjBooServicioDisponible(Boolean pObjBooServicioDisponible) {
		this.objBooServicioDisponible = pObjBooServicioDisponible;
	}

	/**
	 * @method isBooEstadoServicioModificado
	 * 		   Metodo get del atributo booEstadoServicioModificado
	 * @return boolean
	 *		   Valor del atributo booAccionarInternoChkIncluir devuelto
	 * @author hector.cuenca
	 * @date   10/03/2016
	 */
	private boolean isBooEstadoServicioModificado() {
		return this.booEstadoServicioModificado;
	}

	/**
	 * @method setBooEstadoServicioModificado
	 * 		   Metodo set del atributo booEstadoServicioModificado
	 * @param  pBooEstadoServicioModificado
	 *		   Valor que tomara el atributo booEstadoServicioModificado
	 * @author hector.cuenca
	 * @date   10/03/2016
	 */
	private void setBooEstadoServicioModificado(
			boolean pBooEstadoServicioModificado) {
		this.booEstadoServicioModificado = pBooEstadoServicioModificado;
	}

	/**
	 * @method getEnmTipoOperacion
	 * 		   Metodo get del atributo enmTipoOperacion
	 * @return EnumTiposOperaciones
	 *		   Valor del atributo enmTipoOperacion devuelto
	 * @author hector.cuenca
	 * @date   15/03/2016
	 */
	public EnumTiposOperaciones getEnmTipoOperacion() {
		return enmTipoOperacion;
	}

	/**
	 * @method setEnmTipoOperacion
	 * 		   Metodo set del atributo enmTipoOperacion
	 * @param  pEnmTipoOperacion
	 *		   Valor que tomara el atributo enmTipoOperacion
	 * @author hector.cuenca
	 * @date   15/03/2016
	 */
	public void setEnmTipoOperacion(EnumTiposOperaciones pEnmTipoOperacion) {
		this.enmTipoOperacion = pEnmTipoOperacion;
	}

	/**
	 * @method getObjFacturaGiro
	 * 		   Metodo get del atributo objFacturaGiro
	 * @return FacturaGiro
	 *		   Valor del atributo objFacturaGiro devuelto
	 * @author hector.cuenca
	 * @date   15/03/2016
	 */
	public FacturaGiro getObjFacturaGiro() {
		return objFacturaGiro;
	}

	/**
	 * @method setObjFacturaGiro
	 * 		   Metodo set del atributo objFacturaGiro
	 * @param  pObjFacturaGiro
	 *		   Valor que tomara el atributo objFacturaGiro
	 * @author hector.cuenca
	 * @date   15/03/2016
	 */
	public void setObjFacturaGiro(FacturaGiro pObjFacturaGiro) {
		this.objFacturaGiro = pObjFacturaGiro;
	}

	
}

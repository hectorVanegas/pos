package co.com.codesa.clienteposslimgiros.eventos.caja;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMediosPago;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.caja.FormaDiligenciarMedioPago;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.utilidades.datosAdicionales.UtilDatosAdicionales;
import co.com.codesa.clienteposslimgiros.utilidades.mediosPago.UtilMediosPago;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.MedioPago;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 16-sep-2015
 * @clase EventoFormaDiligenciarMedioPago
 * 		  Clase encargada de controlar los eventos de la forma para  
 * 		  diligenciar un medio de pago (registro y edicion)
 * @copyright: Copyright  1998-2012 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class EventoFormaDiligenciarMedioPago extends EventoAbstracto{
	
	/**
	 * @variable hmMediosPagoIngresados
	 * 			 Listado de medios de pago que ya fueron cargados sobre 
  	 * 		  	 la funcionalidad base, excluyendo de este el posible 
  	 * 		     medio de pago para edicion; esto lo debe garantizar la 
  	 * 		  	 funcionalidad base
	 **/
	private HashMap<String,MedioPago> hmMediosPagoIngresados;
	
	/**
	 * @variable lstMediosPagoHabilitados
	 * 			 Listado de los medios de pago disponibles para realizar
	 * 			 la operacion de diligenciar, condicionado por la 
	 * 			 funcionalidad base 
	 **/
	private List<MedioPago> lstMediosPagoHabilitados;
	
	/**
	 * @variable objMedioPagoDiligenciado
	 * 			 Medio de pago diligenciado y procesado por la forma
	 **/
	private MedioPago objMedioPagoDiligenciado;
	
	/**
	 * @variable douTotalIngresoXTarjetas
	 * 			 Valor total ingresado por tarjetas como medio de pago, 
  	 * 		  	 recuperado de la funcionalidad base
	 **/
	private double douTotalIngresoXTarjetas;
	
	/**
	 * @variable douValorTotalServicio
	 * 			 Valor total de la operacion que se esta diligenciando
	 * 		  	 por parte de la funcionalidad base
	 **/
	private double douValorTotalServicio;
	
	/**
  	 * ****************************************************************.
  	 * @metodo EventoFormaDiligenciarMedioPago
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de sus acciones
  	 * @param pForma
  	 * 		  referencia a la GUI de la cual se estan controlando los 
  	 * 		  eventos
  	 * @param pObjMedioPagoParaEditar
  	 * 		  Medio de pago recibido para edicion, en caso de ser nulo,
  	 * 		  se asume que sera un proceso de creacion
  	 * @param pHmMediosPagoIngresados
  	 * 		  Listado de medios de pago que ya fueron cargados sobre 
  	 * 		  la funcionalidad base, excluyendo de este el posible medio
  	 * 		  de pago para edicion; esto lo debe garantizar la 
  	 * 		  funcionalidad base
  	 * @param pDouTotalIngresoXTarjetas
  	 * 		  Valor total ingresado por tarjetas como medio de pago, 
  	 * 		  recuperado y procesado por la funcionalidad base
  	 * @param pDouValorTotalServicio
  	 * 		  Valor total de la operacion que se esta diligenciando
	 * 		  por parte de la funcionalidad base, total a cobrar o total 
	 * 		  a pagar, dependiendo de la operacion
	 * @param pLstMediosPagoHabilitados
	 * 		  Listado de los medios de pago autorizados y habilitados 
	 * 		  segun la funcionalidad base, para realizar la operacion 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EventoFormaDiligenciarMedioPago(FormaGenerica pForma,
										   MedioPago pObjMedioPagoParaEditar,
										   HashMap<String,MedioPago> pHmMediosPagoIngresados,
										   double pDouTotalIngresoXTarjetas,
										   double pDouValorTotalServicio,
										   List<MedioPago> pLstMediosPagoHabilitados) throws Exception{
		super(pForma);
		this.objMedioPagoDiligenciado = pObjMedioPagoParaEditar;
		this.hmMediosPagoIngresados = pHmMediosPagoIngresados;
		this.douTotalIngresoXTarjetas = pDouTotalIngresoXTarjetas;
		this.douValorTotalServicio = pDouValorTotalServicio;
		this.lstMediosPagoHabilitados = pLstMediosPagoHabilitados;
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
		
		this.configuracionCampos();
		this.cargarFormulario();
		this.validarIngresoPrevioEfectivo();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo accionarVentanaDesplegada
  	 * 		   Metodo utilizado para centralizar y desacoplar la accion
  	 * 		   inmediatamente despues de hacerse el despliegue de una 
  	 * 		   ventana, ideal para realizar implementaciones de focos
  	 * 		   iniciales
  	 * @param pEvtWindowOpened 
  	 * 		  Evento correspondiente a la ventana, sobre la cual se 
  	 * 		  produce esta accion 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public void accionarVentanaDesplegada(WindowEvent pEvtWindowOpened) throws Exception {
		
		this.castFrmDiligenciarMedioPago().getCmbListaMediosPago().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmDiligenciarMedioPago().getTxtValorMedioPago().getLblObligatorio().aplicarObligatoriedad(true);
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo accionarCambioItem
  	 * 		   Metodo utilizado para centralizar y desacoplar las 
  	 * 		   acciones producidas cuando realiza un cambio de item
  	 * 		   sobre un componente (itemStateChanged)
  	 * @param pComponent 
  	 * 		  Componente grafico por el cual se produce el evento
  	 * @param pEvtItemStateChanged
  	 * 			Evento del componente gráfico Component;
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public void accionarCambioItem(Component pComponent,
								   ItemEvent pEvtItemStateChanged) throws Exception {
		
		if(pComponent.equals(this.castFrmDiligenciarMedioPago().getCmbListaMediosPago())){
			
			this.mostrarDatosAdicionalesXMedioPago();
		}else{
			super.accionarCambioItem(pComponent,pEvtItemStateChanged);
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo regresar
  	 * 		   Metodo que ejecuta las acciones referentes al boton de 
  	 * 		   operacion representativo para regresar
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public void regresar() throws Exception {
		
		if(this.objMedioPagoDiligenciado != null){
			//Esta editando
			
			this.hmMediosPagoIngresados.put(this.objMedioPagoDiligenciado.getStrConsecutivoIngreso(), 
											this.objMedioPagoDiligenciado);
		}
		
		super.regresar();
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
		
		MedioPago objMedioPagoSeleccionado;
		NumberFormat frtFormato;
		
		this.validarCamposObligatorios();
		
		objMedioPagoSeleccionado = (MedioPago)this.castFrmDiligenciarMedioPago().getCmbListaMediosPago().getSelectedItem();
		
		if(this.objMedioPagoDiligenciado == null 
				|| !this.objMedioPagoDiligenciado.equals(objMedioPagoSeleccionado)){
			
			objMedioPagoSeleccionado = (MedioPago)objMedioPagoSeleccionado.clone();
			
		}else{
			
			objMedioPagoSeleccionado = this.objMedioPagoDiligenciado; 
		}
		
		frtFormato = UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO();
		objMedioPagoSeleccionado.setValor(frtFormato.parse(this.castFrmDiligenciarMedioPago().getTxtValorMedioPago().getText()).doubleValue());
		
		this.validarIngresoMedioPago(objMedioPagoSeleccionado);
		
		if(this.objMedioPagoDiligenciado != null){
			//Esta editando
			
			objMedioPagoSeleccionado.setStrConsecutivoIngreso(this.objMedioPagoDiligenciado.getStrConsecutivoIngreso());
			
			this.hmMediosPagoIngresados.put(objMedioPagoSeleccionado.getStrConsecutivoIngreso(), 
											objMedioPagoSeleccionado);
		}
		
		this.objMedioPagoDiligenciado = objMedioPagoSeleccionado;
		
		super.regresarFormaPadre();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo validarIngresoMedioPago
  	 * 		   Permite realizar las validaciones necesarias para completar
  	 * 		   la operacion de diligenciamiento de medio de pago
  	 * @param pObjMedioPagoSeleccionado
  	 * 		  Medio de pago que se encuentra diligenciando y se le requiere
  	 * 		  validar una secuencia de items para finalizar y completar 
  	 * 		  el proceso
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void validarIngresoMedioPago(MedioPago pObjMedioPagoSeleccionado)throws Exception{
		
		UtilDatosAdicionales.validarUnicidad(pObjMedioPagoSeleccionado, 
			 	 							 this.hmMediosPagoIngresados.values());
		
		if(UtilMediosPago.getInstance().isMedioPagoTipoEnum(pObjMedioPagoSeleccionado,
											  				EnumMediosPago.TARJETA_CREDITO,
											  				EnumMediosPago.TARJETA_DEBITO)){
			
			this.validarIngresoMedioPagoXTarjeta(pObjMedioPagoSeleccionado);
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo validarIngresoMedioPagoXTarjeta
  	 * 		   Permite realizar las validaciones exigidas para cuando se
  	 * 		   diligencia un medio del tipo tarjeta
  	 * @param pObjMedioPagoTarjetaSeleccionado
  	 * 		  Medio de pago de tipo tarjeta el cual se validara como parte
  	 * 		  del proceso para completar y finalizar la operacion
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void validarIngresoMedioPagoXTarjeta(MedioPago pObjMedioPagoTarjetaSeleccionado)throws Exception{
		
		double douValorTarjetasNuevo;
		
		douValorTarjetasNuevo = this.douTotalIngresoXTarjetas + pObjMedioPagoTarjetaSeleccionado.getValor();
		
		if(douValorTarjetasNuevo > this.douValorTotalServicio){
		
			this.castFrmDiligenciarMedioPago().getTxtValorMedioPago().requestFocus();
			this.castFrmDiligenciarMedioPago().getTxtValorMedioPago().selectAll();
			
			throw EnumMensajes.TOTAL_INGRESO_X_TARJETA_SUPERA_VALOR_SERVICIO.generarExcepcion(EnumClasesMensaje.ERROR);
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo validarIngresoPrevioEfectivo
  	 * 		   Permite validar si dispone o no del medio de pago efectivo,
  	 * 		   dependiendo si este ya se fue previamente cargado a traves
  	 * 		   del listado de medios de pago ingresados 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void validarIngresoPrevioEfectivo()throws Exception{
		
		MedioPago objMedioPagoEfectivo;
		
		objMedioPagoEfectivo = EnumMediosPago.EFECTIVO.getObjMedioPago();
		
		if(objMedioPagoEfectivo != null 
				&& this.hmMediosPagoIngresados != null
				&& !this.hmMediosPagoIngresados.isEmpty()){
			
			if(this.hmMediosPagoIngresados.containsValue(objMedioPagoEfectivo)){
				
				this.castFrmDiligenciarMedioPago().getCmbListaMediosPago().removeItem(objMedioPagoEfectivo);
			}
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo validarCamposObligatorios
  	 * 		   Permite realizar las validaciones iniciales de campos 
  	 * 		   obligatorios requeridos para completar la operacion
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void validarCamposObligatorios()throws Exception{
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmDiligenciarMedioPago().getCmbListaMediosPago(), 
																this.castFrmDiligenciarMedioPago().getLblMedioPago().getTextoOriginal(), 
																true, 
																true);

		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmDiligenciarMedioPago().getTxtValorMedioPago(), 
																this.castFrmDiligenciarMedioPago().getLblValorMedioPago().getTextoOriginal(), 
																true, 
																true);
		
		this.castFrmDiligenciarMedioPago().getTxtValorMedioPago().getPropiedades().validaFormatoFinal(true,
																									  this.castFrmDiligenciarMedioPago().getLblValorMedioPago().getTextoOriginal());
		
		this.castFrmDiligenciarMedioPago().getPnlDatosAdicionales().getPropiedadesPnlDatosAdicionales().validarDatosAdicionalesIngresados();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo configuracionCampos
  	 * 		   encargado de gestionar la configuracion personalizada
  	 * 		   para los campos del formulario
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void configuracionCampos()throws Exception{
		
		this.castFrmDiligenciarMedioPago().getTxtValorMedioPago().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_DINERO_GIRO.getValor());
		this.castFrmDiligenciarMedioPago().getTxtValorMedioPago().getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.EXP_REG_FORMATO_DINERO_GIRO.getValor());
		this.castFrmDiligenciarMedioPago().getTxtValorMedioPago().getPropiedades().setFormatoSalida(UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO());
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo cargarFormulario
  	 * 		   Metodo que se encarga de gestionar el cargue de la 
  	 * 		   informacion sobre el formulario
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void cargarFormulario()throws Exception{
		
		NumberFormat frtFormato;
		
		if(this.lstMediosPagoHabilitados != null){
		
			this.castFrmDiligenciarMedioPago().getCmbListaMediosPago().getPropiedades().cargarCombo(this.lstMediosPagoHabilitados.toArray(), 
					 								 												true, 
					 								 												null);
		}
		
		if(this.objMedioPagoDiligenciado != null){
			
			this.castFrmDiligenciarMedioPago().getCmbListaMediosPago().setSelectedItem(this.objMedioPagoDiligenciado);
			
			frtFormato = UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO();
			this.castFrmDiligenciarMedioPago().getTxtValorMedioPago().setText(frtFormato.format(this.objMedioPagoDiligenciado.getValor()));
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo mostrarDatosAdicionalesXMedioPago
  	 * 		   Permite, segun el medio de pago seleccionado para diligenciar,
  	 * 		   cargar sobre la grilla los datos adicionales asociados a 
  	 * 		   este
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void mostrarDatosAdicionalesXMedioPago()throws Exception{
		
		Object objValorSeleccionado;
		MedioPago objMedioPago;
		boolean booNuevoMedioPago;
		
		objValorSeleccionado = this.castFrmDiligenciarMedioPago().getCmbListaMediosPago().getSelectedItem();
		
		if(objValorSeleccionado instanceof MedioPago){
			
			this.castFrmDiligenciarMedioPago().getTxtValorMedioPago().setEnabled(true);
			
			booNuevoMedioPago = true;
			objMedioPago = (MedioPago)objValorSeleccionado;
			
			if(this.objMedioPagoDiligenciado != null 
					&& this.objMedioPagoDiligenciado.equals(objMedioPago)){
			
				objMedioPago = this.objMedioPagoDiligenciado;
				booNuevoMedioPago = false;
			}
			
			this.castFrmDiligenciarMedioPago().getPnlDatosAdicionales().getPropiedadesPnlDatosAdicionales().mostrarDatosAdicionales(objMedioPago,
																												 					booNuevoMedioPago);
		}else{
			
			this.castFrmDiligenciarMedioPago().getTxtValorMedioPago().setEnabled(false);
			this.castFrmDiligenciarMedioPago().getTxtValorMedioPago().setText("");
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo castFrmDiligenciarMedioPago
  	 * 		   Metodo estandar para formatear el tipo de dato general a 
  	 * 		   un tipo especifico ("Casteo"), del atributo padre frmForma
  	 * @return FormaDiligenciarMedioPago
  	 * 		   valor especifico recuperado
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private FormaDiligenciarMedioPago castFrmDiligenciarMedioPago()throws Exception{
		return (FormaDiligenciarMedioPago)super.getFrmForma();
	}

	public MedioPago getObjMedioPagoDiligenciado() {
		return objMedioPagoDiligenciado;
	}

	public void setObjMedioPagoDiligenciado(MedioPago objMedioPagoDiligenciado) {
		this.objMedioPagoDiligenciado = objMedioPagoDiligenciado;
	}
}

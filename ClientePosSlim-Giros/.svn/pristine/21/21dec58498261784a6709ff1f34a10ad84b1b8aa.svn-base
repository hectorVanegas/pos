package co.com.codesa.clienteposslimgiros.eventos.pago;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import co.com.codesa.clientecajams.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.operaciones.EnumTiposOperaciones;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.caja.FormaMovimientoCaja;
import co.com.codesa.clienteposslimgiros.formas.declaraionorigenesfondo.FormaDeclaracionOrigenesFondos;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelTercero;
import co.com.codesa.clienteposslimgiros.formas.lector2D.FormaLector2D;
import co.com.codesa.clienteposslimgiros.formas.pago.FormaPagoGiro;
import co.com.codesa.clienteposslimgiros.formas.superCombo.FormaSuperComboDestino;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.utilidades.lector2D.UtilValidacionesLector2D;
import co.com.codesa.clienteposslimgiros.utilidades.terceros.peps.UtilTerceroPeps;
import co.com.codesa.clienteposslimgiros.utilidades.validaciones.ValidacionesSuperCombo;
import co.com.codesa.clienteposslimgiros.utilidades.validaciones.ValidacionesTercero;
import co.com.codesa.clienteposslimgiros.vista.logica.ControlConsultaPasiVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.ControlConsultaTramaVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.GiroVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.TerceroVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.impresion.ImpresionVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.lector2D.Lector2DVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.promocion.PromocionVistaLogica;
import co.com.codesa.codesawrapper.modelo.dominio.ParametroSistema;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Concepto;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Factura;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaSeguro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 24-mar-2015 
 * @clase EventoFormaPagoGiro
 * 		  Clase encargada de controlar los eventos de la forma de
 * 		  pago de giro
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class EventoFormaPagoGiro extends EventoAbstracto{
	
	/**
	 * @variable booHuellaOk
	 * 			 variable para validar si el tercero destino requiere validacion 
	 * 		 	 de huella
	 **/
	private boolean booHuellaOk;
	
	/**
	 * @variable booLectorOk
	 * 			 variable para validar si el pago requiere validacion 
	 * 		 	 del lector2D
	 **/
	private boolean booLectorOk;
	
	/**
	 * @variable booEnrolado
	 * 			 variable para validar si el tercero fue enrolado
	 **/
	private boolean booEnrolado = false;
	
	/**
	 * @variable booContinuarPago
	 * 			 variable para validar si se continua con el pago
	 * 		 	 despues de realizar las validacion del lector2D
	 **/
	private boolean booContinuarPago;
	
	/**
	 * @variable objFacturaGiro
	 * 		     objeto factura del cual se esta llevando a cabo la transaccion
	 **/
	private FacturaGiro objFacturaGiro;
	
	/**
	 * @variable objTerceroApoderado
	 * 		     objeto tercero para el tercero apoderado
	 **/
	private Tercero objTerceroApoderado;
	
	/**
	 * @variable intNumeroItems
	 * 		     numero de items de la factura
	 **/
	private int intNumeroItems;
	
	/**
	 * @variable objFacturaSeguro
	 * 		     objeto factura para el el seguro del cual se esta llevando a cabo la transaccion
	 **/
	private FacturaSeguro objFacturaSeguro;	
	
	/**
	 * @variable douValorGiro
	 * 		     valor del giro en formato double
	 **/
	private double douValorGiro;
	
	/**
	 * @variable booRespuestaCotizacion
	 * 		     valor respuesta cotizacion en el pago
	 **/
	private boolean booRespuestaCotizacion;
	
	/**
  	 * ****************************************************************.
  	 * @metodo EventoFormaPagoGiro
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de sus acciones
  	 * @param pForma 
  	 * 		  referencia a la GUI de la cual se estan controlando los 
  	 * 		  eventos
  	 * @param pObjFacturaGiro
  	 * 		  objeto factura del cual se esta llevando a cabo la 
  	 * 		  transaccion
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EventoFormaPagoGiro(FormaGenerica pForma,
							   FacturaGiro pObjFacturaGiro) throws Exception{
		super(pForma);
		this.objFacturaGiro = pObjFacturaGiro;
		this.booHuellaOk = false;
	}
	
	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma)throws Exception{
		
		this.booHuellaOk = false;
//		this.configuracionCampos();
		this.cargarFormulario();
	}
	
	@Override
	public void accionarVentanaDesplegada(WindowEvent pEvtWindowOpened)throws Exception{
		this.configuracionCampos();
		this.proponerActualizacionTerceroDestino();
	}
	
	@Override
	public void accionarCambioItem(Component pComponent,
								   ItemEvent pEvtItemStateChanged) throws Exception {
		
		if(pComponent.equals(this.castFrmPagoGiro().getChkIncluyeApoderado())){
			
			this.validaCheckApoderado(this.castFrmPagoGiro().getChkIncluyeApoderado().isSelected());
			
		}else{
			
			super.accionarCambioItem(pComponent,
									 pEvtItemStateChanged);
		}
	}
	
	@Override
	public void confirmar() throws Exception{		
		
		//ControlConsultaPasiVistaLogica.getInstance().LlenarMemoriaParametros();
		
		//[start]11/11/2022 cgamboa - se adiciona condiconal para reemplzar el varlo de DOF, cuando es null
		if (objFacturaGiro.getTerceroDestino().getStrMarcaDOF() == null)
		{
			objFacturaGiro.getTerceroDestino().setStrMarcaDOF("N");
		}
		//[End]11/11/2022 cgamboa - se adiciona condiconal para reemplzar el varlo de DOF, cuando es null
		
		if(objFacturaGiro.getTerceroDestino().getStrMarcaDOF().equals("S")) {
			FormaDeclaracionOrigenesFondos dof = new FormaDeclaracionOrigenesFondos(getFrmForma(), true);
			
			objFacturaGiro.setRespuestaDOF(dof.getTxtRespuesta().getText());
		}
		
		
		if(this.validarDatosTerceros()){
			
			if (this.validarMarcacionPeps()) {
				
				this.castFrmPagoGiro().getScpPromociones().getOperaciones().validarPromocionesDiligenciadas(true);
				
				this.validarBiometria();
				
				if (this.booHuellaOk) {
					
					this.validarLector2D();
					
					if (this.booContinuarPago){
						
						this.objFacturaGiro.setObjTerceroApoderado(this.getObjTerceroApoderado());
						
						if (this.castFrmPagoGiro().getChkIncluyeApoderado().isSelected()) {
							
							ImpresionVistaLogica.getInstancia().verificarDobleImpresionTerceroApoderado(this.objFacturaGiro.getTerceroOrigen());
							
						}
						
						/* 
						 * CarlosMora[Codesa]
						 * 27/06/2019
						 * Se v�lida que el giro a pagar no se encuentre asegurado por el tercero remitente 
						 */
						if (!this.objFacturaGiro.isIncluyeSeguro()) {
							
							this.limpiaDatosCambio();
							
							this.procesoSuperCombo();
							
						} else {					
							booRespuestaCotizacion = true;
						}
						/*
						 * CarlosMora[Codesa]
						 * 20/06/2019
						 * booRespuestaCotizacion y isBooRespCotizaProtegiro, son variables implementadas para logica del protegiro
						 */
						if ((booRespuestaCotizacion) || (!booRespuestaCotizacion && objFacturaGiro.isBooRespCotizaProtegiro())) {
							
							this.mostrarMovimientoCaja();
						}
					}
					
				}
				
				
								
			}
		}else{
			
			throw EnumMensajes.PROBLEMAS_CON_TERCEROS_EN_PAGO_GIRO.generarExcepcion(EnumClasesMensaje.ERROR);
		}
	}
	
	@Override
	public void accionarVentanaActivada(WindowEvent pEvtWindowActivated) throws Exception {
		if (this.objFacturaGiro.getObjClaveSeguridad() != null 
				&& this.objFacturaGiro.getObjClaveSeguridad().isBooRevalidar()) {
				this.regresar();
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @method limpiaDatosCambio
  	 * 		   Metodo utilizado para limpiar los datos de la cotizacion
  	 *         cuando algun dato requerido por la cotizacion ha cambiado
  	 * @throws Exception
  	 *   	   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
  	 * @author CarlosMora[Codesa]
  	 * ****************************************************************
  	 */
	private void limpiaDatosCambio() throws Exception{
		
		//this.castFrmPagoGiro().getTblConceptos().getPropiedades().limpiarGrilla();
		this.intNumeroItems = 0;
		booRespuestaCotizacion = false;
		this.castFrmPagoGiro().getTxtNumeroItems().setText("");
		this.castFrmPagoGiro().getTxtTotalXItems().setText("");
	}
	
	/**
     * ****************************************************************
     * @method validaCheckApoderado
     * 		   metodo utilizado para controlar el evento del check de 
     * 	       incluye Apoderado
     * @param  pBooSeleccionado
     * 		   estado del check de Apoderado
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
     * @author Roberth Martinez Vargas
     * ****************************************************************
     */
	private void validaCheckApoderado(boolean pBooSeleccionado) throws Exception{
		
		this.castFrmPagoGiro().getPnlTerceroApoderado().setVisible(pBooSeleccionado);
		
		this.aplicaBiometriaPanelTercero(pBooSeleccionado);
		
		this.booHuellaOk = false;
		//limpia el tercero apoderado 
		this.setObjTerceroApoderado(null);
		this.limpiarPnlTerceroApoderado();
		this.validaProcesoTerceroPeps();
	}
	
	/**
     * ****************************************************************
     * @method limpiarPnlTerceroApoderado
     *         metodo utilizado para el panel tercero apoderado
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
     * @author Roberth Martinez Vargas
     * ****************************************************************
     */
	private void limpiarPnlTerceroApoderado() throws Exception {
		this.castFrmPagoGiro().getPnlTerceroApoderado().castEvaFrmTercero().restablecer(true);
	}
	
	/**
     * ****************************************************************
     * @method aplicaBiometriaPanelTercero
     * 	       metodo ultilizado para activar o desactivar la bandera 
     * 		   al panel tercero para validar biometria
     * @param  pBooAplicaBiometriaPanelTercero
     *    	   bandera para activar biometria al tercero destino o 
     *    	   apoderado
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
     * @author Roberth Martinez Vargas
     * ****************************************************************
     */
	private void aplicaBiometriaPanelTercero(boolean pBooAplicaBiometriaPanelTercero) throws Exception{
		
		this.castFrmPagoGiro().getPnlTerceroDestino().castEvaFrmTercero().setBooAplicaBiometria(!pBooAplicaBiometriaPanelTercero);
		this.castFrmPagoGiro().getPnlTerceroApoderado().castEvaFrmTercero().setBooAplicaBiometria(pBooAplicaBiometriaPanelTercero);
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo proponerActualizacionTerceroDestino
  	 * 		   Metodo que se encargado de proponer la actualizacion de
  	 * 		   la informacion del tercero destino, propuesta que aplica
  	 * 		   para todos los tipos de identificacion excepto NIT  
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void proponerActualizacionTerceroDestino()throws Exception{
		
		Tercero objTerceroDestino;
		
		objTerceroDestino = this.castFrmPagoGiro().getPnlTerceroDestino().castEvaFrmTercero().getObjTercero();
		
		if(!objTerceroDestino.getTipoIdentificacion().getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_NIT.getValorPropiedad())
				&& !objTerceroDestino.isBloqueadoRiesgos()){
		
			EnumMensajes.VERIFICAR_INFORMACION_ACTUALIZADA_TERCERO.desplegarMensaje(super.getFrmForma(), 
																					EnumClasesMensaje.INFORMACION, 
																					objTerceroDestino.getDescripcion(),
																					objTerceroDestino.toStringXDocumento());
			
			//this.castFrmPagoGiro().getPnlTerceroDestino().castEvaFrmTercero().setBooActivaValidacionTerceroPeps(true);

			this.castFrmPagoGiro().getPnlTerceroDestino().castEvaFrmTercero().desplegarMantenimiento();
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method validarLector2D
	 * 		   Metodo que ejecuta las acciones para validar si el pago
	 * 		   requiere lector 2D
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
 	 * 		   presentada
	 * @author Jefferson Ruiz
	 * @date   06/09/2019
	 * *********************************************************************
	 */	   
	public void validarLector2D() throws Exception {
		
		boolean booConvenioLectorOk;
		boolean booConvenioBiometriaLectorOk;
		boolean booPedirLector;
		FormaPanelTercero objApoderado;
		Tercero objTerceroVerificar = null;
		
		this.booContinuarPago = true;
		
		this.booLectorOk = UtilValidacionesLector2D.getInstance().verificarConfiguracionesLector2D(super.getObjUsuario());
		
		if (booLectorOk) {
			
			booConvenioLectorOk = UtilValidacionesLector2D.getInstance().verificarConvenioLector2D(this.objFacturaGiro.getTerceroOrigen());
			
			if (booConvenioLectorOk) {
				
				booPedirLector = true;
							
				/*booConvenioBiometriaLectorOk = UtilValidacionesLector2D.getInstance().verificarConvenioBiometriaLector2D(this.objFacturaGiro.getTerceroOrigen());
				
				if (booConvenioBiometriaLectorOk && this.booEnrolado) {
					
					EnumMensajes.desplegarMensajePersonalizado(super.getFrmForma(), 
															   EnumClasesMensaje.INFORMACION, 
															   null, 
															   "Para este pago se realizar el proceso de Verificacion de la Huella");
					
					if (this.castFrmPagoGiro().getChkIncluyeApoderado().isSelected()) {
						
						this.castFrmPagoGiro().getPnlTerceroApoderado().castEvaFrmTercero().setBooAplicaBiometria(true);
						this.castFrmPagoGiro().getPnlTerceroApoderado().castEvaFrmTercero().getObjTercero().getObjBiometria().setBooValidadoBiometricamente(false);
						this.castFrmPagoGiro().getPnlTerceroApoderado().castEvaFrmTercero().getObjTercero().getObjBiometria().setRequiereBiometria(true);
						this.booHuellaOk = ValidacionesTercero.getInstance().validarBiometria(this.castFrmPagoGiro().getPnlTerceroApoderado());
						
					}else{
						
						this.castFrmPagoGiro().getPnlTerceroDestino().castEvaFrmTercero().setBooAplicaBiometria(true);
						this.castFrmPagoGiro().getPnlTerceroDestino().castEvaFrmTercero().getObjTercero().getObjBiometria().setBooValidadoBiometricamente(false);
						this.castFrmPagoGiro().getPnlTerceroDestino().castEvaFrmTercero().getObjTercero().getObjBiometria().setRequiereBiometria(true);
						this.booHuellaOk = ValidacionesTercero.getInstance().validarBiometria(this.castFrmPagoGiro().getPnlTerceroDestino());
						
					}
					
					booPedirLector = this.booHuellaOk;
					//this.booContinuarPago = this.booHuellaOk;
					
				}*/
				
				if (booPedirLector) {
					
					this.booContinuarPago = false;
					
					if (this.castFrmPagoGiro().getChkIncluyeApoderado().isSelected()) {
						
						objTerceroVerificar = this.castFrmPagoGiro().getPnlTerceroApoderado().castEvaFrmTercero().getObjTercero();
						
					}else {
						
						objTerceroVerificar = this.objFacturaGiro.getTerceroDestino();
						
					}
					
					
					FormaLector2D frmEnrolar = new FormaLector2D(this.castFrmPagoGiro(),
											 					 true,
											 					objTerceroVerificar);
					
					this.booContinuarPago = Lector2DVistaLogica.getInstance().getBooProcesoLectorOk();
					
				}
				
			}
		}
		
	}
	
	/** 
	 * ********************************************************************
	 * @method validarBiometria
	 * 		   Metodo que ejecuta las acciones para validar si al tercero 
 	 * 		   destino requiere biometria
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
 	 * 		   presentada
	 * @author roberth.martinez
	 * @date   25/10/2016
	 * *********************************************************************
	 */	   
	public void validarBiometria()throws Exception{
		
		this.booEnrolado = false;
		FormaPanelTercero objApoderado;
		Tercero objTerceroVerificar = null;
		
		
		if (!this.booHuellaOk) {
			
			if (this.castFrmPagoGiro().getChkIncluyeApoderado().isSelected()) {
				this.booHuellaOk = ValidacionesTercero.getInstance().validarBiometria(this.castFrmPagoGiro().getPnlTerceroApoderado());
				objApoderado = this.castFrmPagoGiro().getPnlTerceroApoderado();
				this.booEnrolado =  objApoderado.castEvaFrmTercero().getObjTercero().getObjBiometria().isBooEnrolado();
				objTerceroVerificar = objApoderado.castEvaFrmTercero().getObjTercero();
			}else{
				this.booHuellaOk = ValidacionesTercero.getInstance().validarBiometria(this.castFrmPagoGiro().getPnlTerceroDestino());
				this.booEnrolado = this.objFacturaGiro.getTerceroDestino().getObjBiometria().isBooEnrolado();
				objTerceroVerificar = this.objFacturaGiro.getTerceroDestino();
			}	
			
			/* 
			 * Jefferson Ruiz[Codesa]
			 * 03/09/2019
			 * Se v�lida que el terero destino se enrolo de manera exitosa para realizar el proceso de verificacion segun corresponda 
			 */

			if (this.booEnrolado) {
				
				this.validarVerificacionHuellaConvenio(objTerceroVerificar);
				
			}
		}
		
		
		
	}
	
	/** 
	 * ********************************************************************
	 * @method validarVerificacionHuellaConvenio
	 * 		   metodo utilizado para validar si el giro a ser pagado se le 
     * 		   debe realizar el proceso de verificacion de huella inmediatemnete
     * 		   despues de enrolarse 
	 * @param  pTercero
	 * 		   Objeto tercero a validar
	 * @param  pUsuario
	 *    	   objeto usuario de la aplicacion
	 * @param  
	 * @return 
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author Jefferson Ruiz
	 * @date   02/09/2019
	 * *********************************************************************
	 */
	
	private void validarVerificacionHuellaConvenio(Tercero pobjTerceroVerificar) throws Exception {
		
		ParametroSistema psPASI;
		String strServicio = "";
		String strTESENRVE = "";
		String strConvenios;
		String strTipoDocumento;
		String strIdentificacion;
		String strValorTrama;
		Boolean booDatoEncontrado = false;
		
		// Se asigna el parametro del servicio a ser validado 
		/*strServicio = "IDSERVEV";
		
		// Se consume la trama 563 para recuperar el parametro general 
		strValorTrama = ConsultarServicioPorColaboradorVistaLogica.getInstance().consultarServicio(super.getObjUsuario(),
																								   strServicio);*/
		
		strValorTrama = ControlConsultaTramaVistaLogica.getInstance().getEstadoServicio();
		
		if (strValorTrama.equals("S")) {
			
			// Se recupera el parametro donde se encuentra los convenios a los que se le realizara el proceo de verificacion
			/*psPASI = UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.TERCEROS_CONVENIO_VERIFICACION_DESPUES_ENROLAMIENTO);
			strTESENRVE = psPASI.getValor();*/
			strTESENRVE = ControlConsultaPasiVistaLogica.getInstance().getTesenrve();
			
			StringTokenizer st = new StringTokenizer(strTESENRVE, EnumGeneralidadesTramasGiros.PUNTO_Y_COMA.getValor());
			
			while (st.hasMoreTokens()) {
				
				strConvenios = st.nextToken();
				
				if (!strConvenios.contains(EnumGeneralidadesTramasGiros.PIPE.getValor())) {
					
					throw EnumMensajes.ESTRUCTURA_PARAMETRO_IDREOPIE.generarExcepcion(EnumClasesMensaje.ERROR);
				}
				
				StringTokenizer st2 = new StringTokenizer(strConvenios, EnumGeneralidadesTramasGiros.PIPE.getValor());
				
				while (st2.hasMoreTokens()) {
					
					strTipoDocumento = st2.nextToken();
					strIdentificacion = st2.nextToken();
					
					// Se valida si el remitente (tercero Origen) esta parametrizado 
					if (strIdentificacion.equals(this.objFacturaGiro.getTerceroOrigen().getIdentificacion()) && 
						strTipoDocumento.equals(this.objFacturaGiro.getTerceroOrigen().getTipoIdentificacion().getId())) {
						
						EnumMensajes.desplegarMensajePersonalizado(super.getFrmForma(), 
								   								   EnumClasesMensaje.INFORMACION, 
																   null, 
																   "Para este pago se realizar el proceso de Verificacion de la Huella");
						
						booDatoEncontrado = true;
						
						//this.objFacturaGiro.getTerceroDestino().getObjBiometria().setObjBooApto(true);
						//ValidacionesBiometria.getInstance().lecturaHuellaPago(pobjTerceroVerificar, super.getObjUsuario(), super.getFrmForma());
						if (this.castFrmPagoGiro().getChkIncluyeApoderado().isSelected()) {
							
							this.castFrmPagoGiro().getPnlTerceroApoderado().castEvaFrmTercero().setBooAplicaBiometria(true);
							this.castFrmPagoGiro().getPnlTerceroApoderado().castEvaFrmTercero().getObjTercero().getObjBiometria().setBooValidadoBiometricamente(false);
							this.castFrmPagoGiro().getPnlTerceroApoderado().castEvaFrmTercero().getObjTercero().getObjBiometria().setRequiereBiometria(true);
							this.booHuellaOk = ValidacionesTercero.getInstance().validarBiometria(this.castFrmPagoGiro().getPnlTerceroApoderado());
							
						}else{
							
							this.castFrmPagoGiro().getPnlTerceroDestino().castEvaFrmTercero().setBooAplicaBiometria(true);
							this.castFrmPagoGiro().getPnlTerceroDestino().castEvaFrmTercero().getObjTercero().getObjBiometria().setBooValidadoBiometricamente(false);
							this.castFrmPagoGiro().getPnlTerceroDestino().castEvaFrmTercero().getObjTercero().getObjBiometria().setRequiereBiometria(true);
							this.booHuellaOk = ValidacionesTercero.getInstance().validarBiometria(this.castFrmPagoGiro().getPnlTerceroDestino());
							
						}

					}
					
				}
				
			}
			
		}
		
	}

	/**
  	 * ****************************************************************.
  	 * @metodo mostrarMovimientoCaja
  	 * 		   Metodo que se encargado de desplegar la ventana pertinente
  	 * 		   a la gestion de movimiento de caja, quien puede proceder 
  	 * 		   a hacer efectiva la transaccion
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void mostrarMovimientoCaja()throws Exception{
		
		if (this.booHuellaOk) {
			this.booHuellaOk = false;
			this.booContinuarPago = false;
			new FormaMovimientoCaja(super.getFrmForma(),
									true, 
									this.objFacturaGiro,
									this.objFacturaSeguro);
			Lector2DVistaLogica.getInstance().setBooProcesoLectorOk(false);
		}
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
		this.castFrmPagoGiro().getChkIncluyeApoderado().setVisible(this.objFacturaGiro.isBooPermiteApoderado());
		this.castFrmPagoGiro().getPnlTerceroApoderado().setVisible(false);
		this.aplicaBiometriaPanelTercero(false);//inicia con valor false, por que el apoderado no esta senalado
		this.castFrmPagoGiro().getPnlTerceroApoderado().castEvaFrmTercero().setBooActivaValidacionTerceroPeps(this.objFacturaGiro.isBooPermiteApoderado());
		this.validarAplicaPepsTerceroDestino();
		
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	validarAplicaPepsTerceroDestino
	 * 		  	Metodo encargado de activar la validacion de tercero peps
	 *          para el tercero destino de la transaccion
	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author	stiven.garcia
	 * @date	3/05/2018
	 * *********************************************************************
	 */
	private void validarAplicaPepsTerceroDestino() throws Exception{
		this.castFrmPagoGiro().getPnlTerceroDestino().castEvaFrmTercero().setBooActivaValidacionTerceroPeps(UtilTerceroPeps.getInstancia().realizarPreguntaTerceroPeps(this.getObjUsuario(), this.objFacturaGiro.getTerceroDestino()));		
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
		
		Tercero objTercetoTemp;
		
		if(!this.objFacturaGiro.isExterno()){//giro interno

			this.consultaDetalleGiroInterno();
			
		}else{//giro externo
			
			this.objFacturaGiro.setAgenciaDestino(super.getObjUsuario().getAgencia());
			
			// Origen
			objTercetoTemp = null;
			
			
			// Antes de proceder a crear al tercero con la evoluci�n de la trama 155 por la
			// trama 568, se consulta el tercero en base de datos
			objTercetoTemp = TerceroVistaLogica.getInstance().consultarTerceroExterno(super.getObjUsuario(),
																					  this.objFacturaGiro.getTerceroOrigen().getTipoIdentificacion(),
																					  this.objFacturaGiro.getTerceroOrigen().getIdentificacion());
			// Si el objeto esta null es porque no existe el tercero consultado de ser asi,
			// se procede a crear el tercero bajo la logica prevista en la trama 568
			if (objTercetoTemp == null) {
				TerceroVistaLogica.getInstance().validaTercero(super.getObjUsuario(),
															   this.objFacturaGiro.
															   getTerceroOrigen(), 
															   true);
			} else {
				// De lo contrario, o sea el tercero ya existe en base de datos, se procede a
				// validar nombre y apellidos
				if (objTercetoTemp.getNombres().trim()
						.equals(this.objFacturaGiro.getTerceroOrigen().getNombres().trim())
						&& objTercetoTemp.getApellido1().trim()
								.equals(this.objFacturaGiro.getTerceroOrigen().getApellido1().trim())
						&& objTercetoTemp.getApellido2().trim()
								.equals(this.objFacturaGiro.getTerceroOrigen().getApellido2().trim())) {

					// De coincidir los nombre y apellido se reemplaza los datos del tercero que
					// viene de matrix por los datos del tercero que se tiene en base de datos
					this.objFacturaGiro.setTerceroOrigen(objTercetoTemp);

				}else {
					
					//Se los datos del tercero no coinciden se procede a validar la marcacion (Campo TERCACTU)
					if (objTercetoTemp.getStrMarcaActualizacionDatos().equals("N")) {
						throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
																   		 "Data-Remi",
																   		 "Los Datos del tercero remitente deben ser verificados",
																   		 "");
					}else if (objTercetoTemp.getStrMarcaActualizacionDatos().equals("S")) {
						this.objFacturaGiro.setTerceroOrigen(objTercetoTemp);
					}else {
						throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
																   		 "Data-Marca",
																   		 "Error al intentar procesar los Datos del tercero remitente para la marca de actualizacion",
																   		 "");
					}
				}
			}

			// Destino
			objTercetoTemp = null;
			
			// Procedo a validar si el beneficiario existe 
			objTercetoTemp = TerceroVistaLogica.getInstance().consultarTerceroExterno(super.getObjUsuario(),
																					  this.objFacturaGiro.getTerceroDestino().getTipoIdentificacion(),
																					  this.objFacturaGiro.getTerceroDestino().getIdentificacion());
			// Si el objeto esta null es porque no existe el tercero consultado de ser asi,
			// se procede a marcar el tercero como nuevo, para que en la actualizacion de 
			// datos del beneficiario se le pidan los datos faltantes
			if (objTercetoTemp == null) {
				this.castFrmPagoGiro().getPnlTerceroDestino().castEvaFrmTercero().setBooTerceroNuevoRedExterna(true);
				this.castFrmPagoGiro().getPnlTerceroDestino().castEvaFrmTercero().setObjTerceroNuevoRedExterna(this.objFacturaGiro.getTerceroDestino());
			} else {
				// De lo contrario, o sea el tercero ya existe en base de datos, se procede a
				// validar nombre y apellidos
				if (objTercetoTemp.getNombres().trim()
						.equals(this.objFacturaGiro.getTerceroDestino().getNombres().trim())
						&& objTercetoTemp.getApellido1().trim()
								.equals(this.objFacturaGiro.getTerceroDestino().getApellido1().trim())
						&& objTercetoTemp.getApellido2().trim()
								.equals(this.objFacturaGiro.getTerceroDestino().getApellido2().trim())) {

					// De coincidir los nombre y apellido se reemplaza los datos del tercero que
					// viene de matrix por los datos del tercero que se tiene en base de datos
					this.objFacturaGiro.setTerceroDestino(objTercetoTemp);

				}else {
					
					if (objTercetoTemp.getStrMarcaActualizacionDatos().equals("N")) {
						throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
																   		 "Data-Bene",
																   		 "Los datos del tercero beneficiario deben ser verificados",
																   		 "");
					}else if (objTercetoTemp.getStrMarcaActualizacionDatos().equals("S")) {
						this.objFacturaGiro.setTerceroDestino(objTercetoTemp);
					}else {
						throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
																   		 "Data-Marca",
																   		 "Error al intentar procesar los Datos del tercero beneficiario para la marca de actualizacion",
																   		 "");
					}
				}
			}

			this.cargarPromociones(this.objFacturaGiro);
		}
		
		this.castFrmPagoGiro().getPnlEncabezadoFactura().getEvaFrmPnlFactura().cargarPanel(this.objFacturaGiro.getProducto(), 
																						   this.objFacturaGiro.getDocumento(), 
																						   this.objFacturaGiro.getNumero());
		
		this.castFrmPagoGiro().getTxtReferencia().setText(this.objFacturaGiro.getReferenciaControl());
		
		this.cargarAgencias(this.objFacturaGiro);
		this.cargarConceptos(this.objFacturaGiro);
		
		this.castFrmPagoGiro().getTxaNotas().setText(this.objFacturaGiro.getObjNota().toString());
		
		this.cargarTerceros(this.objFacturaGiro);
	}
	
	private void cargarPromociones(FacturaGiro pObjFacturaGiro)throws Exception{
		
		PromocionVistaLogica.getInstance().calcularPromociones(super.getObjUsuario(),
															   pObjFacturaGiro, 
															   EnumParametrosApp.TIPO_CONCEPTO_PAGO_GIRO.getValorPropiedad());
		
		this.castFrmPagoGiro().getScpPromociones().getOperaciones().adicionarPromociones(this.objFacturaGiro.getListPromociones());
	}
	
	/** 
	 * ********************************************************************
	 * @method cargarTerceros
	 * 		   Consulta el tercero origen y destino, los carga en los 
	 * 		   paneles correspondientes, los setea en la factura
	 * @param  pObjFacturaGiro
	 * 		   Objeto de la factura giro con la informacion de la factura
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   16/11/2016
	 * *********************************************************************
	 */
	private void cargarTerceros(FacturaGiro pObjFacturaGiro)throws Exception{
		
		Tercero objTerceroOrigen;
		Tercero objTerceroDestino;
		
		objTerceroOrigen = pObjFacturaGiro.getTerceroOrigen();
		this.castFrmPagoGiro().getPnlTerceroOrigen().castEvaFrmTercero().forzarTercero(objTerceroOrigen.getTipoIdentificacion(), 
				   																	   objTerceroOrigen.getIdentificacion());
		
		objTerceroOrigen = this.castFrmPagoGiro().getPnlTerceroOrigen().castEvaFrmTercero().getObjTercero();
		pObjFacturaGiro.setTerceroOrigen(objTerceroOrigen);
		
		objTerceroDestino = pObjFacturaGiro.getTerceroDestino();
		this.castFrmPagoGiro().getPnlTerceroDestino().castEvaFrmTercero().forzarTercero(objTerceroDestino.getTipoIdentificacion(), 
	 																					objTerceroDestino.getIdentificacion());

		objTerceroDestino = this.castFrmPagoGiro().getPnlTerceroDestino().castEvaFrmTercero().getObjTercero();
		pObjFacturaGiro.setTerceroDestino(objTerceroDestino);
	}
	
	private void cargarConceptos(FacturaGiro pObjFacturaGiro)throws Exception{
		
		List<Concepto> lstConceptos;
		
		lstConceptos = pObjFacturaGiro.getListaConceptos();
		
		if(lstConceptos!=null && 
				!lstConceptos.isEmpty()){
			
			for(Concepto concepto : lstConceptos){
				
				if (concepto.isBooAfectaCaja()) {
					
					this.castFrmPagoGiro().getTblConceptos().getPropiedades().adicionarFilaGrilla(new Object[]{concepto.getCodigo(),
																											   concepto.getDescripcion(),
																											   concepto.getValor()});
				}
			}
			
			this.castFrmPagoGiro().getTxtNumeroItems().setText(String.valueOf(lstConceptos.size()));
			this.castFrmPagoGiro().getTxtTotalXItems().setText(UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO_DECIMAL().format(this.objFacturaGiro.getTotal()));
		}
	}
	
	private void cargarAgencias(FacturaGiro pObjFacturaGiro)throws Exception{
		
		pObjFacturaGiro.setAgenciaPago(super.getObjUsuario().getAgencia());
		
		this.castFrmPagoGiro().getPnlTerritorioAgenciaPago().castEventosForma().definirTerritorioBase(pObjFacturaGiro.getAgenciaPago().getTerritorio());
		this.castFrmPagoGiro().getPnlTerritorioAgenciaPago().getCmbAgencia().addItem(pObjFacturaGiro.getAgenciaPago());
		this.castFrmPagoGiro().getPnlTerritorioAgenciaPago().getCmbAgencia().setSelectedItem(pObjFacturaGiro.getAgenciaPago());
		
		this.castFrmPagoGiro().getPnlTerritorioAgenciaOrigen().castEventosForma().definirTerritorioBase(pObjFacturaGiro.getAgenciaOrigen().getTerritorio());
		this.castFrmPagoGiro().getPnlTerritorioAgenciaOrigen().getCmbAgencia().addItem(pObjFacturaGiro.getAgenciaOrigen());
		this.castFrmPagoGiro().getPnlTerritorioAgenciaOrigen().getCmbAgencia().setSelectedItem(pObjFacturaGiro.getAgenciaOrigen());
		
		this.castFrmPagoGiro().getPnlTerritorioAgenciaDestino().castEventosForma().definirTerritorioBase(pObjFacturaGiro.getAgenciaDestino().getTerritorio());
		this.castFrmPagoGiro().getPnlTerritorioAgenciaDestino().getCmbAgencia().addItem(pObjFacturaGiro.getAgenciaDestino());
		this.castFrmPagoGiro().getPnlTerritorioAgenciaDestino().getCmbAgencia().setSelectedItem(pObjFacturaGiro.getAgenciaDestino());
	}
	
	/*private void cargarSeccionEncabeadoFactura(FacturaGiro pObjFacturaGiro)throws Exception{
		
		Producto objProductoGiro;
		
		this.castFrmPagoGiro().getTxtReferencia().setText(pObjFacturaGiro.getReferenciaControl());
		objProductoGiro = super.getObjUsuarioAutenticado().getProductos().get(0);
		
		this.castFrmPagoGiro().getPnlEncabezadoFactura().getEvaFrmPnlFactura().cargarPanel(objProductoGiro, 
																						   objProductoGiro.getDocumentos().get(0), 
																						   pObjFacturaGiro.getNumero());
	}*/
	
	/**
  	 * ****************************************************************.
  	 * @metodo consultaDetalleGiroInterno
  	 * 		   Metodo que se encarga de consultar el detalle de la informacion
  	 * 		   asociada a un giro interno deseado para pago 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void consultaDetalleGiroInterno()throws Exception{
		
		boolean booValidaZona = false;
		String strTipoSeek = "1";
		String strTipoGiro = "1";
		String strProducto = "1";
		boolean booPermiteApoderado;
		
		booPermiteApoderado = this.objFacturaGiro.isBooPermiteApoderado();//guardamos este dato, en la siguiente linea se borra
		
		this.objFacturaGiro = GiroVistaLogica.getInstance().consultaGiroPorReferencia(super.getObjUsuario(),
																					  this.objFacturaGiro.getReferenciaControl(),
																				   	  booValidaZona,
																				   	  strTipoSeek,
																				   	  strTipoGiro,
																				   	  strProducto);
		this.objFacturaGiro.setBooPermiteApoderado(booPermiteApoderado);
		//Solo aplica para giro interno
		this.cargarPromociones(this.objFacturaGiro);
	}
	
	/**
  	 * ****************************************************************.
  	 * @method validarDatosTerceros
  	 * 	       valida que los terceros esten diligenciados y cumplan 
  	 * 		   con los datos obligatorios
  	 * @return boolean, bandera para indicar el estado de la validacion
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
  	 * @author Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	private boolean validarDatosTerceros()throws Exception{
		
		boolean booContinua;
		
		booContinua = false;
		
		Tercero objTerceroDestino;
		Tercero objTerceroOrigen;
		
		this.castFrmPagoGiro().getPnlTerceroDestino().castEvaFrmTercero().setBooRecargarTerceroNuevoRedExterna(true);
		
		//RMV- Se reconsulta el tercero para validar cambios en biometria
		objTerceroDestino = objFacturaGiro.getTerceroDestino();
		this.castFrmPagoGiro().getPnlTerceroDestino().castEvaFrmTercero().reConsultarTercero(objTerceroDestino.getTipoIdentificacion(), 
	 																					     objTerceroDestino.getIdentificacion());

		objTerceroDestino = this.castFrmPagoGiro().getPnlTerceroDestino().castEvaFrmTercero().getObjTercero();
		objFacturaGiro.setTerceroDestino(objTerceroDestino);

		objTerceroOrigen = this.castFrmPagoGiro().getPnlTerceroOrigen().castEvaFrmTercero().getObjTercero();
		
		if(objTerceroDestino!=null &&
				objTerceroOrigen != null){
			
			if(ValidacionesTercero.getInstance().validacionesXTransaccion(objTerceroDestino, 
						 	 	  										  EnumTiposOperaciones.PAGO_FACTURACION, 
						 	 	  										  this,
						 	 	  										  this.castFrmPagoGiro().getPnlTerceroDestino())){
				
				if (this.castFrmPagoGiro().getChkIncluyeApoderado().isSelected()) {
					
					UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmPagoGiro().getPnlTerceroApoderado().getTxtIdentificacion(), 
																				this.castFrmPagoGiro().getPnlTerceroApoderado().getLblEtiqueta().getTextoOriginal(), 
																				true, 
																				true);
					
					this.objTerceroApoderado = this.castFrmPagoGiro().getPnlTerceroApoderado().castEvaFrmTercero().getObjTercero();
					
					if(ValidacionesTercero.getInstance().validacionesXTransaccion(this.objTerceroApoderado, 
																				  EnumTiposOperaciones.PAGO_FACTURACION, 
																				  this,
																				  this.castFrmPagoGiro().getPnlTerceroApoderado())){

						booContinua = true;

					}else{

						this.limpiarPnlTerceroApoderado();
					}
					
				}else{
					booContinua = true;
				}
			}
		}
		
		return booContinua;
	}
	
	private void validaProcesoTerceroPeps() throws Exception {
		
		if ( this.castFrmPagoGiro().getPnlTerceroDestino().castEvaFrmTercero().isBooRealizoProcesoTerceroPeps() ) {
			this.castFrmPagoGiro().getPnlTerceroApoderado().castEvaFrmTercero().setBooActivaValidacionTerceroPeps(false);
		}else{
			this.castFrmPagoGiro().getPnlTerceroApoderado().castEvaFrmTercero().setBooActivaValidacionTerceroPeps(true);
		}			
	
		if ( this.castFrmPagoGiro().getPnlTerceroApoderado().castEvaFrmTercero().isBooRealizoProcesoTerceroPeps() ) {
			this.castFrmPagoGiro().getPnlTerceroDestino().castEvaFrmTercero().setBooActivaValidacionTerceroPeps(false);
		}else{
			this.castFrmPagoGiro().getPnlTerceroDestino().castEvaFrmTercero().setBooActivaValidacionTerceroPeps(true);
		}
		
		if ( this.castFrmPagoGiro().getChkIncluyeApoderado().isSelected() ) {
			this.castFrmPagoGiro().getPnlTerceroDestino().castEvaFrmTercero().setBooActivaValidacionTerceroPeps(false);
		}
	}
	
	/**
  	 * ****************************************************************
  	 * @method procesoSuperCombo
  	 * 		   Metodo que ofrece supercombo si el producto esta activo
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
  	 * @author CarlosMora[Codesa]
  	 * ****************************************************************
  	 */
	private void procesoSuperCombo() throws Exception{
		String strTelRemitente;
		String strTelDestino;
		boolean booValidacionCotizacionSC;
		
		try{
		
			this.objFacturaSeguro = null;
			booValidacionCotizacionSC = ValidacionesSuperCombo.getInstance().validarSuperComboCotizacion(this, 
																										 this.objFacturaGiro.getTerceroOrigen(), 
																										 this.objFacturaGiro.getTerceroDestino(), 
																										 this.objFacturaGiro.getTotal(),
																										 this.objFacturaGiro);
			
			booRespuestaCotizacion = booValidacionCotizacionSC;
			
			if (booValidacionCotizacionSC) {
				
				strTelRemitente = this.objFacturaGiro.getTerceroOrigen().getTelefono2();
				strTelDestino = this.objFacturaGiro.getTerceroDestino().getTelefono2();
				FormaSuperComboDestino objFrmSuperCombo;
				objFrmSuperCombo = new FormaSuperComboDestino(this.getFrmForma(), 
										  					 true, 
										  					 UtilidadGiros.getInstancia().formatoPresentacionNumero(ValidacionesSuperCombo.getObjSuperCombo().getDouVlrSuperCombo()),
										  					 this.objFacturaGiro);
				
				if (objFrmSuperCombo.getEnmBotEncAccionSolicitada().toString().equals(EnumBotonesEncabezado.BTNGUARDAR.toString())){
					
					this.aceptarSuperCombo(strTelRemitente, strTelDestino);
				}else{
					this.eliminarSuperCombo(true);
				}
			}else {				
				this.eliminarSuperComboCotizacion(true);
			}
		
		}catch(Exception e){
			this.eliminarSuperCombo(true);
			super.controlExcepcion(e);
		}
	}
	
	/**
     * ****************************************************************
     * @method aceptarSuperCombo
     * 		   metodo utilizado para realizar el calculo de conceptos
     * 		   del seguro y SMS, llenar los objetos facturagiroSMS, 
     * 		   facturaSeguro.
     * @param  pStrTelRemitente 
     * 		   telefono remitente
     * @param  pStrTelDestino
     * 		   telefono destino
     * @throws Exception
     *         Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
     * @author CarlosMora[Codesa]
     * ****************************************************************
     */
	private void aceptarSuperCombo(String pStrTelRemitente, String pStrTelDestino) throws Exception{
		boolean booCalcularConceptoSeguro;
		double douVlrTotal;
			
		this.objFacturaSeguro = new FacturaSeguro();
		
		ValidacionesSuperCombo.getObjSuperCombo().setBooRealizaSeguro(true);
		//siempre el beneficiario del seguro de vida es el tercero destino
		ValidacionesSuperCombo.getObjSuperCombo().setTerceroBeneficiarioSeguro(this.objFacturaGiro.getTerceroDestino());
		this.objFacturaSeguro.setIdTerceroBene(this.objFacturaGiro.getTerceroDestino().getIdentificacion());
		
		booCalcularConceptoSeguro = ValidacionesSuperCombo.getInstance().cotizarSeguro(this, 
															   					   	   this.douValorGiro, 
															   					   	   ValidacionesSuperCombo.getInstance().obtenerVlrSeguroAccidente(this.douValorGiro), 
															   					   	   this.objFacturaSeguro,
															   					   	   this.objFacturaGiro);
		if (booCalcularConceptoSeguro) {			
			this.removerProtegiro();
			this.adicionarConceptos(this.objFacturaSeguro, false);
			douVlrTotal = this.objFacturaGiro.getTotal() - this.objFacturaSeguro.getTotal();
			this.castFrmPagoGiro().getTxtTotalXItems().setText(UtilidadGiros.getInstancia().formatoPresentacionNumero(douVlrTotal));
			this.calcularNumeroItemsFactura(this.objFacturaSeguro, 1);
			
			EnumMensajes.SPC_MSJ_VTA_PROTEGIRO.desplegarMensaje(getFrmForma(), 
					  EnumClasesMensaje.INFORMACION);
			
			this.objFacturaGiro.setIncluyeSeguroPago(true);
						
		}else{			
			this.eliminarSuperCombo(true);			
		}
	}
	
	/**
     * ****************************************************************
     * @metodo  eliminarSuperCombo
     * 			metodo utilizado para quitar el producto supercombo, 
     * 		    limpia variables
     * @param   pBooReinicia
     * 			bandera indicando si reinicia el valor total de la 
     *   		forma
     * @throws  Exception
     * 		    Controla, recupera y escala, cualquier tipo de excepcion
	 *		    presentada
     * @autor   CarlosMora[Codesa]
     * ****************************************************************
     */
	private void eliminarSuperCombo(boolean pBooReinicia) throws Exception{
		this.objFacturaGiro.setIncluyeSeguroPago(false);
		this.objFacturaSeguro = null;	
		//booRespuestaCotizacion = false;
		ValidacionesSuperCombo.getInstance().reiniciaSuperCombo();
		
		if (pBooReinicia) {
			this.castFrmPagoGiro().getTxtTotalXItems().setText(UtilidadGiros.getInstancia().formatoPresentacionNumero(this.objFacturaGiro.getTotal()));
			this.removerProtegiro();
		}
	}
	
	/**
     * ****************************************************************
     * @metodo  eliminarSuperComboCotizacion
     * 			metodo utilizado para quitar el producto supercombo, 
     * 		    limpia variables
     * @param   pBooReinicia
     * 			bandera indicando si reinicia el valor total de la 
     *   		forma
     * @throws  Exception
     * 		    Controla, recupera y escala, cualquier tipo de excepcion
	 *		    presentada
     * @autor   CarlosMora[Codesa]
     * ****************************************************************
     */
	private void eliminarSuperComboCotizacion(boolean pBooReinicia) throws Exception{
		this.objFacturaGiro.setIncluyeSeguroPago(false);
		this.objFacturaSeguro = null;	
		booRespuestaCotizacion = false;
		ValidacionesSuperCombo.getInstance().reiniciaSuperCombo();
		
		if (pBooReinicia) {
			this.castFrmPagoGiro().getTxtTotalXItems().setText(UtilidadGiros.getInstancia().formatoPresentacionNumero(this.objFacturaGiro.getTotal()));
			this.removerProtegiro();
		}
	}
	 
	/**
     * ****************************************************************
     * @metodo  removerProtegiro
     * 			metodo utilizado para quitar el producto protegiro.
     * @throws  Exception
     * 		    Controla, recupera y escala, cualquier tipo de excepcion
	 *		    presentada
     * @autor   CarlosMora[Codesa]
     * ****************************************************************
     */
	private void removerProtegiro() throws Exception{
		
		for (int i = 0; i < this.castFrmPagoGiro().getTblConceptos().getRowCount(); i++) {
			this.castFrmPagoGiro().getTxtNumeroItems().setText(Integer.toString(this.castFrmPagoGiro().getTblConceptos().getRowCount()));
		
		if (this.castFrmPagoGiro().getTblConceptos().getValueAt(i, 0).equals("211")) {
			
			this.castFrmPagoGiro().getTblConceptos().getPropiedades().removerFilaGrilla(i);
			this.castFrmPagoGiro().getTxtNumeroItems().setText(Integer.toString(this.castFrmPagoGiro().getTblConceptos().getRowCount()));
			
		  }
		}	
	}
	
	/**
  	 * ****************************************************************.
  	 * @method adicionarConceptos
  	 * 		   Metodo que adiciona los conceptos calculados a la grilla
  	 * 		   de conceptos.
  	 * @param  pFactura
  	 * 		   objeto con el detalle de la Factura
  	 * @param  pBoolimpiar
  	 * 	       bandera para limpiar grilla conceptos
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
  	 * @author CarlosMora[Codesa]
  	 * ****************************************************************
  	 */
	private void adicionarConceptos(Factura pFactura, boolean pBoolimpiar) throws Exception{
		Iterator<Concepto> iter = pFactura.getListaConceptos().iterator();
		if(pBoolimpiar){
			this.castFrmPagoGiro().getTblConceptos().getPropiedades().limpiarGrilla();
		}
		
		Concepto concepto = null;

		while (iter.hasNext()) {
			concepto = iter.next();
			if (concepto.getStrIdAfectaCaja().equals(Concepto.ID_AFECTA_CAJA)) {
					
				this.castFrmPagoGiro().getTblConceptos().getPropiedades();
				this.castFrmPagoGiro().getTblConceptos().getPropiedades().adicionarFilaGrilla(getArrayConcepto(concepto));

				if (concepto.getCodigo().equals(EnumParametrosApp.CODIGO_CONCEPTO_PAGO_GIRO_POSTAL.getObjConstante())) {
					
					this.douValorGiro = concepto.getValor(); // El valor del giro es el retornado en la cotizacion 
					
				}
			}
		}
	}
	
	/**
     * ****************************************************************
     * @method calcularNumeroItemsFactura
     * 		   metodo utilizado para calcular el numero de items de 
     * 		   la factura
     * @param  pFactura
     * 		   objeto factura
     * @param  pIntValor
     * 		   indica el valor que acumula al numero de items
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
     * @author CarlosMora[Codesa]
     * ****************************************************************
     */	
	private void calcularNumeroItemsFactura(Factura pFactura, int pIntValor) throws Exception{
		
		for (int i = 0; i < pFactura.getListaConceptos().size(); i++) {
			Concepto concepto = pFactura.getListaConceptos().get(i);
			if (concepto.getStrIdAfectaCaja().equals(Concepto.ID_AFECTA_CAJA)) {
				if (this.intNumeroItems == 0) {
					this.intNumeroItems  = 1;
				}
				this.intNumeroItems += pIntValor;
			}
		}
		this.castFrmPagoGiro().getTxtNumeroItems().setText(this.intNumeroItems+"");
	}
	
	/**
  	 * ****************************************************************.
  	 * @method getArrayConcepto
  	 * 		   Metodo recibe un concepto y lo retorna en forma de array.
  	 * @param  pObjConcepto
  	 * 		   objeto del concepto
  	 * @return Object
  	 * 		   array del concepto
  	 * @author CarlosMora[Codesa]
  	 * ****************************************************************
  	 */
	private Object[] getArrayConcepto(Concepto pObjConcepto){
		
		Object objConcepto[] = new Object[]{pObjConcepto.getCodigo(),
										    pObjConcepto.getDescripcion(),
										    pObjConcepto.getValor()};
		
		return objConcepto;
		
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	validarMarcacionPeps
	 * 		  	metodo encargado de validar si se realizo la validacion de 
	 * 			Tercero Peps para los terceros involucrados en la transacicon
	 * @return
	 * 			Booleano indicando si se realizo o no la validacion.
	 * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author	stiven.garcia
	 * @date	2/05/2018
	 * *********************************************************************
	 */
	private boolean validarMarcacionPeps() throws Exception {
		
		return UtilTerceroPeps.getInstancia().validarContinuarProceso(this.getObjUsuario(), this.castFrmPagoGiro().getPnlTerceroDestino(), this.castFrmPagoGiro().getPnlTerceroApoderado(), this.castFrmPagoGiro());
		
	}

	/**
  	 * ****************************************************************.
  	 * @metodo castFrmPagoGiro
  	 * 		   Metodo estandar para formatear el tipo de dato general a 
  	 * 		   un tipo especifico ("Casteo"), del atributo 
  	 * 		   frmPagoGiro
  	 * @return FormaPagoGiro
  	 * 		   valor especifico recuperado
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaPagoGiro castFrmPagoGiro()throws Exception{
		return (FormaPagoGiro)super.getFrmForma();
	}

	/**
	 * @method getObjFacturaGiro
	 * 		   Metodo get del atributo objFacturaGiro
	 * @return FacturaGiro
	 *		   Valor del atributo objFacturaGiro devuelto
	 * @author roberth.martinez
	 * @date   21/10/2016
	 */
	public FacturaGiro getObjFacturaGiro() {
		return objFacturaGiro;
	}

	/**
	 * @method setObjFacturaGiro
	 * 		   Metodo set del atributo objFacturaGiro
	 * @param  objFacturaGiro
	 *		   Valor que tomara el atributo objFacturaGiro
	 * @author roberth.martinez
	 * @date   21/10/2016
	 */
	public void setObjFacturaGiro(FacturaGiro objFacturaGiro) {
		this.objFacturaGiro = objFacturaGiro;
	}

	/**
	 * @method getObjTerceroApoderado
	 * 		   Metodo get del atributo objTerceroApoderado
	 * @return Tercero
	 *		   Valor del atributo objTerceroApoderado devuelto
	 * @author roberth.martinez
	 * @date   21/10/2016
	 */
	public Tercero getObjTerceroApoderado() {
		return objTerceroApoderado;
	}

	/**
	 * @method setObjTerceroApoderado
	 * 		   Metodo set del atributo objTerceroApoderado
	 * @param  objTerceroApoderado
	 *		   Valor que tomara el atributo objTerceroApoderado
	 * @author roberth.martinez
	 * @date   21/10/2016
	 */
	public void setObjTerceroApoderado(Tercero objTerceroApoderado) {
		this.objTerceroApoderado = objTerceroApoderado;
	}

	public boolean isBooRespuestaCotizacion() {
		return booRespuestaCotizacion;
	}

	public void setBooRespuestaCotizacion(boolean booRespuestaCotizacion) {
		this.booRespuestaCotizacion = booRespuestaCotizacion;
	}
	
	
}

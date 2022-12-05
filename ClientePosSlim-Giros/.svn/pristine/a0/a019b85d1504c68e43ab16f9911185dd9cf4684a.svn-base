package co.com.codesa.clienteposslimgiros.eventos.generico;


import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;

import co.com.codesa.clienteposslimexception.exceptions.ClientePosSlimGirosException;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.operaciones.EnumTiposOperaciones;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelTercero;
import co.com.codesa.clienteposslimgiros.formas.mensajes.FormaMensajeAlerta;
import co.com.codesa.clienteposslimgiros.formas.terceros.FormaMantenimientoTercero;
import co.com.codesa.clienteposslimgiros.utilidades.mensajes.Mensaje;
import co.com.codesa.clienteposslimgiros.utilidades.terceros.peps.UtilTerceroPeps;
import co.com.codesa.clienteposslimgiros.utilidades.validaciones.ValidacionesBiometria;
import co.com.codesa.clienteposslimgiros.utilidades.validaciones.ValidacionesTercero;
import co.com.codesa.clienteposslimgiros.utilidades.xml.XmlDatosEntidades;
import co.com.codesa.clienteposslimgiros.vista.logica.TerceroVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.terceroPeps.TerceroPepsVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DatoEntidad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;


public class EventoFormaPanelTercero extends EventoAbstracto {

	private Tercero objTercero;
	private Tercero objTerceroTmp;
	private Tercero objTerceroNuevoRedExterna;
	private String strDescripcionTercero;
	private String strIdentificacionTmp;
	private boolean booTerceroPresente;
	private boolean booActivaValidacionBloqueadoXRiesgos;
	private boolean booTerceroCreadoRecientemente;
	private boolean booAplicaBiometria;
	private boolean booConsultaTerceroRecaudo;
	private EnumTiposOperaciones enmTipoOperacion;
	private boolean booActivaValidacionTerceroPeps;
	private boolean booRealizoProcesoTerceroPeps;
	private boolean booTerceroNuevoRedExterna;
	private boolean booRecargarTercero;
	private boolean booRecargarTerceroNuevoRedExterna;
	
	
	private FormaPanelTercero pnlTercero;
	
	public EventoFormaPanelTercero(FormaPanelTercero pPnlTercero,
								   String pStrDescripcionTercero,
								   EnumTiposOperaciones pEnmTipoOperacion) throws Exception{
		
		super.setFrmForma(pPnlTercero.getFormaPadre());
		this.pnlTercero = pPnlTercero;
		this.enmTipoOperacion = pEnmTipoOperacion;
		this.strDescripcionTercero = pStrDescripcionTercero;
		this.booTerceroPresente = true;
		this.booActivaValidacionBloqueadoXRiesgos = false;
		this.booAplicaBiometria = false;
		this.booActivaValidacionTerceroPeps = false;
		this.booTerceroNuevoRedExterna = false;
	}
	
	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma)throws Exception{
		
		this.cargarFormulario();
		this.configuracionCampos();
		this.strIdentificacionTmp = this.castPnlTercero().getTxtIdentificacion().getText();
	}
	
	@Override
	public void accionarIngresoLiberado(Component pComponent,
										KeyEvent pEvtKeyReleased)throws Exception{
		
		if(pComponent.equals(this.castPnlTercero().getTxtIdentificacion()) &&
				!this.strIdentificacionTmp.equals(this.castPnlTercero().getTxtIdentificacion().getText())){
			
			this.strIdentificacionTmp = this.castPnlTercero().getTxtIdentificacion().getText();
			this.restablecerComponente();
		}
	}
	
	@Override
	public void accionarCambioItem(Component pComponent,
								   ItemEvent pEvtItemStateChanged)throws Exception{
		
		if	(	pComponent.equals(this.castPnlTercero().getCmbEntidadTiposIdentificacion())	)
		{
			if	(	this.castPnlTercero().getCmbEntidadTiposIdentificacion().isEnabled()	)
			{
				this.restablecerComponente();
				this.castPnlTercero().getTxtIdentificacion().setText("");
				this.configuracionCampoTextoIdentificacion();
			}
		}
	}

	@Override
	public void accionarFocoPerdido(Component pComponent,
									FocusEvent pEvtFocusLost)throws Exception{
		
		if(pComponent.equals(this.castPnlTercero().getTxtIdentificacion())){
			
			super.getFrmForma().setBooAnularEventosXFocusLost(true);
			
			this.focoPerdicoTxtIdentificacion();
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo focoPerdicoTxtIdentificacion
  	 * 		   encargado de realizar las acciones de perdida del foco 
  	 * 		   para la caja de texto de identidficacion
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor  Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	private void focoPerdicoTxtIdentificacion() throws Exception{

		Mensaje objMensaje;
		
		try{
			this.booTerceroCreadoRecientemente = false;
			this.consultarTercero();
			
		}catch(Exception e){
			
			FormaMensajeAlerta alerta;
			super.controlExcepcion(e);
			if(e instanceof ClientePosSlimGirosException){
				
				objMensaje = (Mensaje)((ClientePosSlimGirosException)e).getObjMensaje();
				
				if(objMensaje.getCodigo().equals(EnumMensajes.TERCERO_NO_EXISTE.getCodigo())){
					
					try {
						
						alerta = EnumMensajes.DESEA_CREAR_TERCERO.desplegarMensaje(this.castPnlTercero().getFormaPadre(), 
																		  		   EnumClasesMensaje.CONFIRMACION, 
																		  		   objMensaje.getParametros());
						if(alerta.isOpcion()){//aceptar
							
							this.desplegarMantenimiento();
							
						}else{//cancelar
							this.restablecer(null);
							//this.castPnlTercero().getCmbEntidadTiposIdentificacion().setSelectedIndex(1);
							//this.castPnlTercero().getTxtIdentificacion().setText("");
							
						}
						
					} catch (Exception e1) {
						super.controlExcepcion(e1);
						this.restablecer(null);
					}
				}else{
					this.restablecer(null);
				}
			}else{
				this.restablecer(null);
			}
		}finally{
			
			//this.validaDespliegueBiometria();
			ValidacionesTercero.getInstance().validarBiometria(this.castPnlTercero());
			
		}
	}
	
	
	/** 
	 * ********************************************************************
	 * @method validaDespliegueBiometria
	 * 		   encargado de validar si el panel tercero se le pude 
 	 * 		   validar biometria
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
 	 * 		   presentada
	 * @author roberth.martinez
	 * @date   28/10/2016
	 * *********************************************************************
	 */
	public void validaDespliegueBiometria()throws Exception{
		
		Boolean objBooValidaBio = false;
		
		if (this.getObjTercero() != null) {
			
			this.getObjTercero().getObjBiometria().setObjBooApto(false);
			
			if (this.booAplicaBiometria) {
				
				objBooValidaBio = ValidacionesBiometria.getInstance().validarBiometria(this.getObjTercero(), 
																					   super.getObjUsuario(), 
																					   super.getFrmForma(),
																					   this.enmTipoOperacion);
				
				if (objBooValidaBio == null) {
					
					this.restablecer(true);
				}
			}
		}
		
	}

	@Override
	public void accionarEjecucion(Component pComponent,
								  AWTEvent pEvtEjecucion)throws Exception{
		
		if (pComponent.equals(this.castPnlTercero().getBtnMantenimiento())) {
			
			if(this.objTercero!=null){
				this.desplegarMantenimiento();
			}
			
		}else{
			super.accionarEjecucion(pComponent,pEvtEjecucion);
		}
	}
	
	private void cargarFormulario()throws Exception{
		
		this.cargarTiposIdentificacion(EnumParametrosApp.ENT_TIPOS_IDENTIFICACION.getValorPropiedad());
	}
	
	public void cargarTiposIdentificacion(String pStrIdEntidadTipoIdentificacion)throws Exception{
		
		this.castPnlTercero().getCmbEntidadTiposIdentificacion().getPropiedades().cargarCombo(XmlDatosEntidades.getInstance().obtenerEntidad(pStrIdEntidadTipoIdentificacion).getHmDatos().values().toArray(), 
												 											  true);
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
		this.configuracionCamposTexto();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo configuracionCamposTexto
  	 * 		   encargado de gestionar la configuracion personalizada
  	 * 		   para los diferentes campos de texto del formulario
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void configuracionCamposTexto()throws Exception{
		
		this.castPnlTercero().getTxtIdentificacion().getPropiedades().setActivaMayusculaMinuscula(true);
		
		this.configuracionCampoTextoIdentificacion();
		this.configuracionCampoTextoDescripcion();
	}
	
	private void configuracionCampoTextoDescripcion()throws Exception{
		
		this.castPnlTercero().getTxtDescripcion().getPropiedades().setActivaDesplegarContenido(true);
	}
	
	private void configuracionCampoTextoIdentificacion()throws Exception{
		
		DatoEntidad objDatEntTipoIdentificacion;
		String strFormatoIngreso;
		
		strFormatoIngreso = null;
		objDatEntTipoIdentificacion = this.obtenerTipoIdentificacion();
		
		if(objDatEntTipoIdentificacion != null){
			
			this.castPnlTercero().getTxtIdentificacion().setEnabled(true);
			
			if(objDatEntTipoIdentificacion.getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_CC.getValorPropiedad())){
				
				strFormatoIngreso = EnumExpresionesRegulares.EXP_REG_FORMATO_DOCUMENTO_CC.getValor();
				
			}else if(objDatEntTipoIdentificacion.getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_CE.getValorPropiedad())){
				
				strFormatoIngreso = EnumExpresionesRegulares.EXP_REG_FORMATO_DOCUMENTO_CE.getValor();
				
			}else if(objDatEntTipoIdentificacion.getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_TI.getValorPropiedad())){
				
				strFormatoIngreso = EnumExpresionesRegulares.EXP_REG_FORMATO_DOCUMENTO_TI.getValor();
				
			}else if(objDatEntTipoIdentificacion.getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_NIT.getValorPropiedad())){
				
				strFormatoIngreso = EnumExpresionesRegulares.EXP_REG_FORMATO_DOCUMENTO_NIT.getValor();
				
			}else if(objDatEntTipoIdentificacion.getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_PA.getValorPropiedad())){
				
				strFormatoIngreso = EnumExpresionesRegulares.EXP_REG_FORMATO_DOCUMENTO_PA.getValor();
				
			}else if(objDatEntTipoIdentificacion.getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_CEX.getValorPropiedad())){
				
				strFormatoIngreso = EnumExpresionesRegulares.EXP_REG_FORMATO_DOCUMENTO_CEX.getValor();
			}
			
		}else{
			this.castPnlTercero().getTxtIdentificacion().setEnabled(false);
		}
		
		this.castPnlTercero().getTxtIdentificacion().getPropiedades().setControlFormatoIngreso(strFormatoIngreso);
	}
	
	public void desplegarMantenimiento()throws Exception{
		
		DatoEntidad objDatoEntidadTipoIdentificacion;
		FormaMantenimientoTercero frmMantenimientoTercero = null;
		String strIdentificacion;
		
		if( this.objTercero != null ){
			
			if (this.booRecargarTercero) {
				this.objTercero = TerceroVistaLogica.getInstance().consultarTercero(super.getObjUsuario(),
																					this.objTercero.getTipoIdentificacion(),
																					this.objTercero.getIdentificacion(),
																					false);
				this.booRecargarTercero = false;

			}
			
			if ( evaluarProcesoTerceroPeps() ) {
				this.booActivaValidacionTerceroPeps = UtilTerceroPeps.getInstancia().realizarPreguntaTerceroPeps(this.getObjUsuario(), this.objTercero);
			}
			
			
			frmMantenimientoTercero = new FormaMantenimientoTercero(super.getFrmForma(),
																	true,
																	this.enmTipoOperacion,
																	this.booTerceroPresente,
																	this.objTercero,
																	this.booActivaValidacionTerceroPeps,
																	this.booTerceroNuevoRedExterna);
			
			this.booTerceroNuevoRedExterna = frmMantenimientoTercero.castEvtFrmMantenimientoTercero().isBooTerceroNuevoRedExterna();
			this.booRecargarTercero = frmMantenimientoTercero.castEvtFrmMantenimientoTercero().isBooRecargarTercero();
			if (!this.booTerceroNuevoRedExterna) {
				this.objTerceroNuevoRedExterna = null;
			}
			
			if(frmMantenimientoTercero.getEnmBotEncAccionSolicitada().getCodigo().equals(EnumBotonesEncabezado.BTNGUARDAR.getCodigo())){

				this.forzarTercero(frmMantenimientoTercero.castEvtFrmMantenimientoTercero().getObjTercero());
			}
			
		}else {
		
			objDatoEntidadTipoIdentificacion = this.obtenerTipoIdentificacion();
			strIdentificacion = this.castPnlTercero().getTxtIdentificacion().getText().trim();
			
			if ( evaluarProcesoTerceroPeps() ){
				this.booActivaValidacionTerceroPeps = UtilTerceroPeps.getInstancia().activarValidacionTerceroPeps(objDatoEntidadTipoIdentificacion, strIdentificacion);
			}			
			
			if(objDatoEntidadTipoIdentificacion!=null &&
					!strIdentificacion.isEmpty()){
				
				frmMantenimientoTercero = new FormaMantenimientoTercero(super.getFrmForma(),
																		true,
																		this.booTerceroPresente,
																		this.enmTipoOperacion,
																		objDatoEntidadTipoIdentificacion,
																		strIdentificacion,
																		this.strDescripcionTercero,
																		this.booActivaValidacionTerceroPeps);
				
				if(frmMantenimientoTercero.castEvtFrmMantenimientoTercero().getObjTercero() != null){
					
					if(this.booActivaValidacionBloqueadoXRiesgos){
						
						/*
						 * Forzar la consulta del tercero con el fin de poder detectar si el tercero
						 * esta bloqueado por riesgos y realizar la respectiva validacion
						 */
						this.booTerceroCreadoRecientemente = true;
						this.forzarTercero(objDatoEntidadTipoIdentificacion, strIdentificacion);
						this.objTercero.setStrSexo(frmMantenimientoTercero.castEvtFrmMantenimientoTercero().getObjTercero().getStrSexo());
						this.objTercero.setStrTipoSangre(frmMantenimientoTercero.castEvtFrmMantenimientoTercero().getObjTercero().getStrTipoSangre());
						this.objTerceroTmp.setStrSexo(frmMantenimientoTercero.castEvtFrmMantenimientoTercero().getObjTercero().getStrSexo());
						this.objTerceroTmp.setStrTipoSangre(frmMantenimientoTercero.castEvtFrmMantenimientoTercero().getObjTercero().getStrTipoSangre());
						
					}else{
						
						this.forzarTercero(frmMantenimientoTercero.castEvtFrmMantenimientoTercero().getObjTercero());
					}
					
				}else{
					this.restablecer(true);
				}
			}
		}
		
		if ( frmMantenimientoTercero != null  && this.booActivaValidacionTerceroPeps ) {
			
			if (frmMantenimientoTercero.castEvtFrmMantenimientoTercero().getObjTercero() != null && 
					(frmMantenimientoTercero.getCmbTerceroPeps() != null && !frmMantenimientoTercero.getCmbTerceroPeps().getSelectedItem().equals(EnumEtiquetas.LBL_NO_SELECCIONADO))
			   ) {
				this.booRealizoProcesoTerceroPeps = true;
			}else {
				this.booRealizoProcesoTerceroPeps = false;
			}
		}
		
	}
	
	private void restablecerComponente()throws Exception{
		
		if(this.objTercero!=null){
			
			this.objTercero = null;
			this.castPnlTercero().getTxtDescripcion().setText("");
		}
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	evaluarProcesoTerceroPeps
	 * 		  	Metodo encargado de evaluar desde donde se realiza la peticion de 
	 * 			mantenimiento de terceros 
	 * @return  
	 * 			Si debe consultarse el tercero para conocer si aplica 
	 * 			el tercero de peps
	 * @author	stiven.garcia
	 * @date	14/08/2018
	 * *********************************************************************
	 */
	private boolean evaluarProcesoTerceroPeps(){		
		
		if (this.enmTipoOperacion != null){
		
			if ( !( EnumTiposOperaciones.ENVIO_FACTURACION.equals(this.enmTipoOperacion) && this.strDescripcionTercero.equalsIgnoreCase(EnumEtiquetas.LBL_EGP_BENEFICIARIO.getValor(false)) ) &&
				 !( EnumTiposOperaciones.PAGO_FACTURACION.equals(this.enmTipoOperacion)  && this.strDescripcionTercero.equalsIgnoreCase(EnumEtiquetas.LBL_EGP_REMITENTE.getValor(false)) )    &&
				 !( EnumTiposOperaciones.SOLICITUD_CAMBIO_BENEFICIARIO.equals(this.enmTipoOperacion) )
			   )
		    {
				return true;
			}
		}
		
		return false;		
	}
	
	public void restablecer(Boolean pBooHabilitar)throws Exception{
		String strEntidadTipoId = EnumParametrosApp.ENT_TIPOS_IDENTIFICACION.getValorPropiedad();
		String strDatoEntidadCC = EnumParametrosApp.COD_DAT_ENT_TPDOC_CC.getValorPropiedad();
		
		DatoEntidad deTipoId = XmlDatosEntidades.getInstance().obtenerEntidad(strEntidadTipoId).getHmDatos().get(strDatoEntidadCC);
		
		this.objTercero = null;
		this.objTerceroTmp = null;
		this.castPnlTercero().getTxtDescripcion().setText("");
		this.castPnlTercero().getTxtIdentificacion().setText("");
		this.castPnlTercero().getCmbEntidadTiposIdentificacion().setSelectedItem(deTipoId);
		
		if(pBooHabilitar!=null){
			this.habilitarComponenteCompleto(pBooHabilitar.booleanValue());
		}
	}
	
	public void consultarTercero() throws Exception{
		
		DatoEntidad objDatTipoIdentificacion;
		String strIdentificacion;
		
		objDatTipoIdentificacion = this.obtenerTipoIdentificacion();
		
		if(objDatTipoIdentificacion != null){
			
			strIdentificacion = this.castPnlTercero().getTxtIdentificacion().getText();
			
			if(!strIdentificacion.isEmpty()){
				
				if(this.objTercero==null || 
						!this.objTercero.getTipoIdentificacion().equals(objDatTipoIdentificacion) ||
						!this.objTercero.getIdentificacion().equals(strIdentificacion)){
					
					if(this.objTerceroTmp == null ||
							!this.objTerceroTmp.getTipoIdentificacion().equals(objDatTipoIdentificacion) ||
							!this.objTerceroTmp.getIdentificacion().equals(strIdentificacion)){
						
						if (this.booTerceroNuevoRedExterna && this.objTerceroNuevoRedExterna != null && !this.booRecargarTerceroNuevoRedExterna) {
							this.objTercero = this.objTerceroNuevoRedExterna;
						} else {
							this.booRecargarTerceroNuevoRedExterna = false;
							this.objTercero = TerceroVistaLogica.getInstance().consultarTercero(super.getObjUsuario(),
									objDatTipoIdentificacion, strIdentificacion, this.booConsultaTerceroRecaudo);
						}
												
						this.objTercero.setDescripcion(this.strDescripcionTercero);
						this.objTercero.setTipoIdentificacion((DatoEntidad)this.castPnlTercero().getCmbEntidadTiposIdentificacion().getSelectedItem());
						
						this.objTerceroTmp = this.objTercero;
						
						if(this.booActivaValidacionBloqueadoXRiesgos){
							
							this.validarBloqueadoXRiesgos();
						}		
						
						if(!this.booTerceroCreadoRecientemente){
						
							ValidacionesTercero.getInstance().validacionesPostConsultaTercero(this.objTercero,
									  														  this.enmTipoOperacion,
									  														  this,
									  														  this.castPnlTercero());
						}
						
						if(this.booActivaValidacionTerceroPeps && this.objTercero != null ) {
							booRealizoProcesoTerceroPeps = UtilTerceroPeps.getInstancia().procesarServicioTerceroPeps( this.getObjUsuario(), 
																													   this.objTercero, 
																													   this.getFrmForma(),
																													   true
																													  );
							if ( booRealizoProcesoTerceroPeps ) {
								this.setBooActivaValidacionTerceroPeps(false);
							}
						}
						
					}else{
						this.objTercero = this.objTerceroTmp; 
					}
					
					this.castPnlTercero().getTxtDescripcion().setText(this.objTercero.toString().replace("*", ""));
					
				}
			}
		}
	}
	
	private void validarBloqueadoXRiesgos()throws Exception{
		
		String strPresentacionDocumentoTercero;
		
		if(this.objTercero.isBloqueadoRiesgos()){
			
			strPresentacionDocumentoTercero = this.objTercero.toStringXDocumento();
			
			if(!this.booTerceroCreadoRecientemente){
				
				if (!this.objTercero.getTipoIdentificacion().getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_NIT.getValorPropiedad())) {
					
					EnumMensajes.SISTEMA_REQUIERE_ACTUALIZAR_TERCERO.desplegarMensaje(super.getFrmForma(), 
							  														  EnumClasesMensaje.INFORMACION, 
							  														  strPresentacionDocumentoTercero);
					this.desplegarMantenimiento();
				}
				
				
			}else{
				this.booTerceroCreadoRecientemente = !this.booTerceroCreadoRecientemente;
			}
			
			this.restablecer(null);
			
			throw EnumMensajes.TERCERO_BLOQUEADO_X_CUMPLIMIENTO.generarExcepcion(EnumClasesMensaje.ADVERTENCIA, 
																		         strPresentacionDocumentoTercero);
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method reConsultarTercero
	 * 		   Permite reconsultar el tercero, colocando en null los 
	 * 		   objetos terceros, para poder realizar la consulta
	 * @param  pObjDatTipoIdentificacion
	 * 	 	   tipo de identificacion del tercero
	 * @param  pStrIdentificacion
	 * 		   identificacion del tercero
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   16/11/2016
	 * *********************************************************************
	 */
	public void reConsultarTercero(DatoEntidad pObjDatTipoIdentificacion,
			   					   String pStrIdentificacion)throws Exception{

		this.objTercero = null;
		this.objTerceroTmp = null;
		this.castPnlTercero().getCmbEntidadTiposIdentificacion().setSelectedItem(pObjDatTipoIdentificacion);
		this.castPnlTercero().getTxtIdentificacion().setText(pStrIdentificacion);
		this.consultarTercero();
	
	}
	
	public void forzarTercero(DatoEntidad pObjDatTipoIdentificacion,
			   				   String pStrIdentificacion)throws Exception{

		this.castPnlTercero().getCmbEntidadTiposIdentificacion().setSelectedItem(pObjDatTipoIdentificacion);
		this.castPnlTercero().getTxtIdentificacion().setText(pStrIdentificacion);
		this.consultarTercero();

	}
	
	/**
  	 * ****************************************************************
  	 * @metodo forzarTercero
  	 * 		   Setea la informacion de un tercero sin necesidad de 
  	 * 		   consultarlo en base de datos
  	 * @throws Exception 
  	 * @autor  Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public void forzarTercero(Tercero pTercero)throws Exception{
		
		this.castPnlTercero().getCmbEntidadTiposIdentificacion().setSelectedItem(pTercero.getTipoIdentificacion());
		this.castPnlTercero().getTxtIdentificacion().setText(pTercero.getIdentificacion());
		this.castPnlTercero().getTxtDescripcion().setText(pTercero.toString().replace("*", ""));
		
		this.objTercero = pTercero;
		this.objTerceroTmp = pTercero;
	}
	
	public void habilitarItemComponente(String nombreItem,
										boolean habilitar)throws Exception{

		if(this.validarCmbEntidadTiposIdentificacion() &&
				nombreItem.equals(this.castPnlTercero().getCmbEntidadTiposIdentificacion().getName())){

			this.castPnlTercero().getCmbEntidadTiposIdentificacion().setEnabled(habilitar);

		}else if(this.validarBtnMantenimiento() &&
				nombreItem.equals(this.castPnlTercero().getBtnMantenimiento().getName())){

			this.castPnlTercero().getBtnMantenimiento().setEnabled(habilitar);

		}else if(this.validarTxtIdentificacion() &&
				nombreItem.equals(this.castPnlTercero().getTxtIdentificacion().getName())){

			this.castPnlTercero().getTxtIdentificacion().setEditable(habilitar);
			this.castPnlTercero().getTxtIdentificacion().setFocusable(habilitar);

		}

	}
	
	public void habilitarComponenteCompleto(boolean habilitar)throws Exception{
		
		if(this.validarCmbEntidadTiposIdentificacion()){
			this.castPnlTercero().getCmbEntidadTiposIdentificacion().setEnabled(habilitar);
		}
		
		if(this.validarBtnMantenimiento()){
			this.castPnlTercero().getBtnMantenimiento().setEnabled(habilitar);
		}
		
		if(this.validarTxtIdentificacion()){
			this.castPnlTercero().getTxtIdentificacion().setEditable(habilitar);
			this.castPnlTercero().getTxtIdentificacion().setFocusable(habilitar);
		}
		
	}
	
	public boolean validarCmbEntidadTiposIdentificacion()throws Exception{
		return this.castPnlTercero().getCmbEntidadTiposIdentificacion()!=null && 
					this.castPnlTercero().getCmbEntidadTiposIdentificacion().isVisible(); 
	}
	
	public boolean validarBtnMantenimiento()throws Exception{
		return this.castPnlTercero().getBtnMantenimiento()!=null && 
					this.castPnlTercero().getBtnMantenimiento().isVisible(); 
	}
	
	public boolean validarTxtIdentificacion()throws Exception{
		return this.castPnlTercero().getTxtIdentificacion()!=null && 
					this.castPnlTercero().getTxtIdentificacion().isVisible(); 
	}
	
	private DatoEntidad obtenerTipoIdentificacion()throws Exception{
		
		DatoEntidad objDatEntTipoIdentificacion = null;
		
		if(this.castPnlTercero().getCmbEntidadTiposIdentificacion().getSelectedItem() instanceof DatoEntidad){
			objDatEntTipoIdentificacion = (DatoEntidad) this.castPnlTercero().getCmbEntidadTiposIdentificacion().getSelectedItem();
		}
		
		return objDatEntTipoIdentificacion;
	}

	public void aplicarObligatoriedad(boolean pBooObligatorio)throws Exception{
		
		this.castPnlTercero().getCmbEntidadTiposIdentificacion().getLblObligatorio().aplicarObligatoriedad(pBooObligatorio);
		this.castPnlTercero().getTxtIdentificacion().getLblObligatorio().aplicarObligatoriedad(pBooObligatorio);
	}
	
	public FormaPanelTercero castPnlTercero()throws Exception{
		return (FormaPanelTercero)this.pnlTercero;
	}

	public FormaPanelTercero getPnlTercero() {
		return pnlTercero;
	}

	public void setPnlTercero(FormaPanelTercero pnlTercero) {
		this.pnlTercero = pnlTercero;
	}

	public Tercero getObjTercero() {
		return objTercero;
	}

	public void setObjTercero(Tercero objTercero) {
		this.objTercero = objTercero;
	}

	public String getStrDescripcionTercero() {
		return strDescripcionTercero;
	}

	public void setStrDescripcionTercero(String strDescripcionTercero) {
		this.strDescripcionTercero = strDescripcionTercero;
	}

	public boolean isBooTerceroPresente() {
		return booTerceroPresente;
	}

	public void setBooTerceroPresente(
			boolean booTerceroPresente) {
		this.booTerceroPresente = booTerceroPresente;
	}

	public boolean isBooActivaValidacionBloqueadoXRiesgos() {
		return booActivaValidacionBloqueadoXRiesgos;
	}

	public void setBooActivaValidacionBloqueadoXRiesgos(
			boolean booActivaValidacionBloqueadoXRiesgos) {
		this.booActivaValidacionBloqueadoXRiesgos = booActivaValidacionBloqueadoXRiesgos;
	}

	public boolean isBooAplicaBiometria() {
		return booAplicaBiometria;
	}

	public void setBooAplicaBiometria(boolean booAplicaBiometria) {
		this.booAplicaBiometria = booAplicaBiometria;
	}

	public EnumTiposOperaciones getEnmTipoOperacion() {
		return enmTipoOperacion;
	}

	public void setEnmTipoTransaccion(EnumTiposOperaciones enmTipoOperacion) {
		this.enmTipoOperacion = enmTipoOperacion;
	}

	public boolean isBooConsultaTerceroRecaudo() {
		return booConsultaTerceroRecaudo;
	}

	public void setBooConsultaTerceroRecaudo(boolean booConsultaTerceroRecaudo) throws Exception{
		
		this.booConsultaTerceroRecaudo = booConsultaTerceroRecaudo;
		this.restablecer(null);
	}

	public boolean isBooActivaValidacionTerceroPeps() {
		return booActivaValidacionTerceroPeps;
	}

	public void setBooActivaValidacionTerceroPeps(boolean booActivaValidacionTerceroPeps)
		throws Exception
	{
		if	(	booActivaValidacionTerceroPeps	)
		{
			booActivaValidacionTerceroPeps = UtilTerceroPeps.getInstancia().validarServicioTerceroPeps();
		}
		
		this.booActivaValidacionTerceroPeps = booActivaValidacionTerceroPeps;
		//this.booActivaValidacionTerceroPeps = false;
	}

	public boolean isBooRealizoProcesoTerceroPeps() {
		return this.booRealizoProcesoTerceroPeps;
	}

	public void setBooRealizoProcesoTerceroPeps(
			boolean pBooRealizoProcesoTerceroPeps) {
		this.booRealizoProcesoTerceroPeps = pBooRealizoProcesoTerceroPeps;
	}

	public boolean isBooTerceroNuevoRedExterna() {
		return booTerceroNuevoRedExterna;
	}

	public void setBooTerceroNuevoRedExterna(boolean booTerceroNuevoRedExterna) {
		this.booTerceroNuevoRedExterna = booTerceroNuevoRedExterna;
	}

	public Tercero getObjTerceroNuevoRedExterna() {
		return objTerceroNuevoRedExterna;
	}

	public void setObjTerceroNuevoRedExterna(Tercero objTerceroNuevoRedExterna) {
		this.objTerceroNuevoRedExterna = objTerceroNuevoRedExterna;
	}

	public boolean isBooRecargarTerceroNuevoRedExterna() {
		return booRecargarTerceroNuevoRedExterna;
	}

	public void setBooRecargarTerceroNuevoRedExterna(boolean booRecargarTerceroNuevoRedExterna) {
		this.booRecargarTerceroNuevoRedExterna = booRecargarTerceroNuevoRedExterna;
	}
	
		
	
	
}
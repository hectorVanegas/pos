package co.com.codesa.clienteposslimgiros.eventos.terceros;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import co.com.codesa.clienteposslim.controladoretiquetas.ControladorEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumConfiguracion;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.enumeraciones.biometria.EnumTiposBiometriaCaja;
import co.com.codesa.clienteposslimgiros.enumeraciones.operaciones.EnumTiposOperaciones;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaFechaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.mensajes.FormaMensajeAlerta;
import co.com.codesa.clienteposslimgiros.formas.terceros.FormaMantenimientoTercero;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.utilidades.integracion.libCajaMultiservicio.UtilIntegracionLibCajaMultiservicio;
import co.com.codesa.clienteposslimgiros.utilidades.integracion.slimGiros.UtilIntegracionSlimGiros;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.clienteposslimgiros.utilidades.terceros.peps.UtilTerceroPeps;
import co.com.codesa.clienteposslimgiros.utilidades.xml.XmlActividadesEconomicas;
import co.com.codesa.clienteposslimgiros.utilidades.xml.XmlDatosEntidades;
import co.com.codesa.clienteposslimgiros.vista.logica.TerceroVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.caja.CajaVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.terceroPeps.TerceroPepsVistaLogica;
import co.com.codesa.codesawrapper.modelo.dominio.ParametroSistema;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ActividadEconomica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DatoEntidad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Entidad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TerceroPeps;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Territorio;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 19-mar-2015 
 * @clase EventoFormaMantenimientoTercero
 * 		  Clase encargada de controlar los eventos de la forma para  
 * 		  diligenciar la direccion
 * @copyright Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class EventoFormaMantenimientoTercero extends EventoAbstracto{
	
	private Tercero objTercero;
	
	/**
	 * @variable	objInfoTerceroCapturadaXDocumento
	 * 				Tercero generado a paritr de la informacion capturada automaticamente del documento
	 */
	private Tercero objInfoTerceroCapturadaXDocumento;
	
	private DatoEntidad objDatEntTipoIdentificacion;
	
	private String strIdentificacion;
	
	private TerceroPeps objTerceroPeps;	
	
	private String strDescripcionTercero;
	
	private EnumTiposOperaciones enmTipoOperacion;
	
	private boolean booActivaValidacionTerceroPeps;
	
	private boolean booTerceroPresente;
	
	private boolean booTerceroNuevoRedExterna;
	
	private boolean booRecargarTercero;
	
	/**
  	 * ****************************************************************.
  	 * @metodo EventoFormaMantenimientoTercero
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de sus acciones
  	 * @param pForma
  	 * 		  referencia a la GUI de la cual se estan controlando los 
  	 * 		  eventos
  	 * @param pBooTerceroPresente 
  	 * 		  bandera que permite identificar al momento del proceso de 
  	 * 		  mantenimiento si se habilita y se coloca a disposicion para
  	 * 		  completar la informacion relacionada con el documento del 
  	 * 		  tercero
  	 * @param pObjTercero
  	 * 		  tercero al cual se le efecutara el mantenimiento de su 
  	 * 		  informacion, en este caso su actualizacion
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EventoFormaMantenimientoTercero(FormaGenerica pForma,
										   boolean pBooTerceroPresente,
										   EnumTiposOperaciones pEnmTipoOperacion,
										   Tercero pObjTercero,
										   boolean pBooActivaValidacionTerceroPeps,
										   boolean pBooTerceroNuevoRedExterna) throws Exception{
		super(pForma);
		this.objTercero = pObjTercero;
		this.booTerceroPresente = pBooTerceroPresente;
		this.enmTipoOperacion = pEnmTipoOperacion;
		this.booActivaValidacionTerceroPeps = pBooActivaValidacionTerceroPeps;
		this.booTerceroNuevoRedExterna = pBooTerceroNuevoRedExterna;
		this.booRecargarTercero = false;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo EventoFormaMantenimientoTercero
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de sus acciones
  	 * @param pForma
  	 * 		  referencia a la GUI de la cual se estan controlando los 
  	 * 		  eventos
  	 * @param pBooTerceroPresente 
  	 * 		  bandera que permite identificar al momento del proceso de 
  	 * 		  mantenimiento si se habilita y se coloca a disposicion para
  	 * 		  completar la informacion relacionada con el documento del 
  	 * 		  tercero
  	 * @param pObjDatEntTipoIdentificacion
  	 * 		  tipo de identificacion asociado al tercero con el cual se 
  	 * 		  realizara el proceso de mantenimiento, que para este caso
  	 * 		  corresponde a su creacion
  	 * @param pStrIdentificacion
  	 * 		  identificacion asociada al tercero con la cual se realizara
  	 * 		  el proceso de mantenimiento, que para este caso corresponde 
  	 * 		  a su creacion
  	 * @param pStrDescripcionTercero
  	 * 		  Descripcion asociada al tercero con el fin de identificar 
  	 * 		  si es Remitente, Tramitador
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EventoFormaMantenimientoTercero(FormaGenerica pForma,
										   boolean pBooTerceroPresente,
										   EnumTiposOperaciones pEnmTipoOperacion,
										   DatoEntidad pObjDatEntTipoIdentificacion,
										   String pStrIdentificacion,
										   String pStrDescripcionTercero,
										   boolean pBooActivaValidacionTerceroPeps) throws Exception {
		super(pForma);
		this.booTerceroPresente = pBooTerceroPresente;
		this.objDatEntTipoIdentificacion = pObjDatEntTipoIdentificacion;
		this.strIdentificacion = pStrIdentificacion;
		this.enmTipoOperacion = pEnmTipoOperacion;
		this.strDescripcionTercero = pStrDescripcionTercero;
		this.booActivaValidacionTerceroPeps = pBooActivaValidacionTerceroPeps;
	}
	
	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma)throws Exception{
		
		this.validarDespliegueMantenimiento();
		this.cargarFormulario();
		this.configuracionCampos();
		this.validarDespliegueComboTerceroPeps();
	}
	
	@Override
	public void accionarVentanaDesplegada(WindowEvent pEvtWindowOpened) throws Exception {
		
		this.castFrmMantenimientoTercero().getDtcFechaExpedicion().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmMantenimientoTercero().getDtcFechaEntradaPais().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmMantenimientoTercero().getDtcFechaVencimiento().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmMantenimientoTercero().getTxtNombres().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmMantenimientoTercero().getTxtPrimerApellido().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmMantenimientoTercero().getTxtTelefono().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmMantenimientoTercero().getCmbActividadesEconomicas().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmMantenimientoTercero().getPnlTerritorioExpedicion().getCmbPais().getLblObligatorio().aplicarObligatoriedad(true);
		
		if(this.obtenerTipoIdentificacion().getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_TI.getValorPropiedad())){
			
			this.castFrmMantenimientoTercero().getDtcFechaNacimiento().getLblObligatorio().aplicarObligatoriedad(true);
		}
		
		if(this.booTerceroPresente){
			
			this.castFrmMantenimientoTercero().getPnlDireccion().getTxtDescripcion().getLblObligatorio().aplicarObligatoriedad(true);
			
			if(this.objTercero != null){
			
				this.validarInformacionDocumentoTercero(true);
			}
		}
		
		this.castFrmMantenimientoTercero().getTxtPrimerApellido().requestFocus();
	}
	
	@Override
	public void accionarCambioItem(Component pComponent,
								   ItemEvent pEvtItemStateChanged)throws Exception{
		
		if	(	pComponent.equals(this.castFrmMantenimientoTercero().getCmbTerceroPeps())	) {
			
			if	(	this.castFrmMantenimientoTercero().getCmbTerceroPeps().getSelectedItem().toString().equalsIgnoreCase(ControladorEtiquetas.etiquetasMsg.getString("general_si"))	) {
				this.accionCmbTerceroPeps();
			}else if (	this.castFrmMantenimientoTercero().getCmbTerceroPeps().getSelectedItem().toString().equalsIgnoreCase(ControladorEtiquetas.etiquetasMsg.getString("general_no"))	) {
				objTerceroPeps = new TerceroPeps();
				objTerceroPeps.setBooEsPeps(false);
			}
		}
	}
	
	@Override
	public	void	limpiar()	
			throws Exception 
	{
		CajaFechaUtil dtcCampoFecha;
		
		super.limpiar();
		
		if	(	(dtcCampoFecha	=	this.castFrmMantenimientoTercero().getDtcFechaEntradaPais()).isEnabled()	)
		{
			dtcCampoFecha.setDate(null);
		}
		
		if	(	(dtcCampoFecha	=	this.castFrmMantenimientoTercero().getDtcFechaExpedicion()).isEnabled()	)
		{
			dtcCampoFecha.setDate(null);
		}
		
		if	(	(dtcCampoFecha	=	this.castFrmMantenimientoTercero().getDtcFechaNacimiento()).isEnabled()	)
		{
			dtcCampoFecha.setDate(null);
		}
		
		if	(	(dtcCampoFecha	=	this.castFrmMantenimientoTercero().getDtcFechaVencimiento()).isEnabled()	)
		{
			dtcCampoFecha.setDate(null);
		}
	}
	
	private void validarDespliegueMantenimiento()throws Exception{
		
		if(this.objTercero != null){
			
			if(this.objTercero.getTipoIdentificacion().getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_NIT.getValorPropiedad())){
			
				super.regresarFormaPadre();
				
				throw EnumMensajes.NO_AUTORIZADO_PARA_MANTENIMIENTO_TERCERO_NIT.generarExcepcion(EnumClasesMensaje.ERROR);
			}
		}
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	accionCmbTerceroPeps
	 * 		  	Metodo encargado de realizar la accion del combo PEPS
	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada  	
	 * @author	stiven.garcia
	 * @date	3/05/2018
	 * *********************************************************************
	 */
	private void accionCmbTerceroPeps() throws Exception {
		
		Tercero objTerceroLocal = this.objTercero;
		
		if( objTerceroLocal == null ){
			objTerceroLocal = new Tercero(this.obtenerTipoIdentificacion(), this.obtenerIdentificacion());
			objTerceroLocal.setDescripcion(this.obtenerDescripcionTercero());
		}
		
		boolean booProcesoTerceroPeps = UtilTerceroPeps.getInstancia().procesarServicioTerceroPeps( this.getObjUsuario(), 
																									objTerceroLocal, 
																									this.getFrmForma(), 
																									false
																								  );		
		this.objTerceroPeps = objTerceroLocal.getObjTerceroPeps();
		
		if ( this.objTerceroPeps != null ) {
			if ( booProcesoTerceroPeps && this.objTerceroPeps.isBooEsPeps() ) {
				this.castFrmMantenimientoTercero().getCmbTerceroPeps().setSelectedItem(ControladorEtiquetas.etiquetasMsg.getString("general_si").toUpperCase());
				this.castFrmMantenimientoTercero().getCmbTerceroPeps().setEnabled(false);
			} else if ( booProcesoTerceroPeps && !this.objTerceroPeps.isBooEsPeps() ) {
				this.castFrmMantenimientoTercero().getCmbTerceroPeps().setSelectedItem(ControladorEtiquetas.etiquetasMsg.getString("general_no").toUpperCase());
				this.castFrmMantenimientoTercero().getCmbTerceroPeps().setEnabled(false);
			} else {
				this.castFrmMantenimientoTercero().getCmbTerceroPeps().setSelectedItem(EnumEtiquetas.LBL_NO_SELECCIONADO);
			}
		}
		
	}
	
	@Override
	public void confirmar() throws Exception {
				
		if(this.booTerceroPresente){
			
			this.validarInformacionDocumentoTercero(false);
		}
		
		this.validarInformacionTercero();
		
		if(this.objTercero != null && !this.booTerceroNuevoRedExterna){//actualizacion
			this.actualizarTercero();
		}else if (this.objTercero != null && this.booTerceroNuevoRedExterna) {//crea el tercero nuevo de la red externa tama 568
			this.crearTerceroNuevoRedExterna();
		}else{//creacion
			this.crearTercero();
		}		
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	procesarInformacionTerceroPeps
	 * 		  	Metodo encargado de realizar el procesamiento de informacion PEPS
	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada  			
	 * @author	stiven.garcia
	 * @date	26/04/2018
	 * *********************************************************************
	 */
	private void procesarInformacionTerceroPeps() throws Exception{
		
		if( this.objTerceroPeps != null ){
			
			if ( this.objTerceroPeps.isBooEsPeps() ) {
				TerceroPepsVistaLogica.getInstance().registrarTerceroPeps(	this.getObjUsuario(), 
																			this.objTercero,
																			this.objTerceroPeps.isBooEsPeps(),
																			this.objTerceroPeps.getlPreguntasTerceroPeps().get(0));
			} else {
				TerceroPepsVistaLogica.getInstance().registrarTerceroPeps(	this.getObjUsuario(), 
																			this.objTercero,
																			this.objTerceroPeps.isBooEsPeps()
																		 );
			}
			this.objTercero.setObjTerceroPeps(this.objTerceroPeps);
		}		
	}
	
	/** 
	 * ********************************************************************
	 * @method 	validarCapturaDatosCCXQR
	 * 		   	metodo para validar si se capturan los datos de la cedula 
	 * 		   	mediante el codigo QR
	 * @return	Tercero
	 * 			Tercero creado a partir de la informacion recuperada del
	 * 			documento
	 * @throws 	Exception
	 * 		   	Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author 	roberth.martinez
	 * @date   	22/02/2018
	 * *********************************************************************
	 */
	private Tercero validarCapturaDatosCCXQR() throws Exception{
		
		String [] arrStrDatosCedula;
		Tercero objTercero = null;
		Date datFechaNacimiento;
		
		//<0|1006071500;MARTINEZ;VARGAS;ROBERTH;*;M;19861015;O+>
		if	(		this.objTercero == null 
				&&	this.booTerceroPresente
			) 
		{	
			if	(	EnumTiposBiometriaCaja.MULTISERVICIO.equals(CajaVistaLogica.getInstance ().consultarTipoBiometriaCaja ( super.getObjUsuario() ))	)
			{
				arrStrDatosCedula = UtilIntegracionLibCajaMultiservicio.getInstance().proponerCapturaDatosCedulaCajaMS	(	this.obtenerTipoIdentificacion().getValor(),
																															this.obtenerIdentificacion(),
																															super.getFrmForma()
																														);
				if	(	arrStrDatosCedula	!=	null	)
				{
					objTercero = new Tercero();
					
					objTercero.setNombres(arrStrDatosCedula[4]+" "+arrStrDatosCedula[5].replaceAll("\\*", ""));
					objTercero.setApellido1(arrStrDatosCedula[2]);
					objTercero.setApellido2(arrStrDatosCedula[3]);
					
					datFechaNacimiento = new SimpleDateFormat("yyyyMMdd").parse(arrStrDatosCedula[7]);
					objTercero.setFechaNacimiento(UtilidadGiros.getInstancia().getFORMATEADOR_FECHA_SLASH().format(datFechaNacimiento));
					objTercero.setStrSexo(arrStrDatosCedula[6]);
					objTercero.setStrTipoSangre(arrStrDatosCedula[8]);
				}
			}
		}
		
		return objTercero;
	}
	
	private void validarInformacionDocumentoTercero(boolean pBooAdvertirInconsistenciaRegistrada)throws Exception{
		
		DatoEntidad objDatEntTipoIdentificacion;
		Date datFechaExpedicion;
		Date datFechaNacimiento;
		Date datFechaEntradaPais;
		Date datFechaVencimiento;
		String strDescripcionFechaExpedicion;
		
		objDatEntTipoIdentificacion = this.obtenerTipoIdentificacion();
		
		if(!objDatEntTipoIdentificacion.getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_NIT.getValorPropiedad())){
			
			strDescripcionFechaExpedicion = EnumEtiquetas.LBL_MNT_TERC_FECHA_EXPEDICION.toString()
												+" "+EnumEtiquetas.TTL_MNT_TERC_PNL_EXPEDICION.toString();
			
			datFechaExpedicion = this.validarCampoFechaObligatorio(this.castFrmMantenimientoTercero().getDtcFechaExpedicion(),
																   strDescripcionFechaExpedicion);
			
			datFechaEntradaPais = this.validarCampoFechaObligatorio(this.castFrmMantenimientoTercero().getDtcFechaEntradaPais(),
																	this.castFrmMantenimientoTercero().getLblFechaEntradaPais().getTextoOriginal());
			
			datFechaVencimiento = this.validarCampoFechaObligatorio(this.castFrmMantenimientoTercero().getDtcFechaVencimiento(),
																	this.castFrmMantenimientoTercero().getLblFechaVencimiento().getTextoOriginal());
			
			if(objDatEntTipoIdentificacion.getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_PA.getValorPropiedad())
					|| objDatEntTipoIdentificacion.getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_CE.getValorPropiedad())
					|| objDatEntTipoIdentificacion.getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_CEX.getValorPropiedad())){
				
				UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmMantenimientoTercero().getPnlTerritorioExpedicion().getCmbPais(), 
																		this.castFrmMantenimientoTercero().getPnlTerritorioExpedicion().getLblPais().getTextoOriginal()
																			+" "+EnumEtiquetas.TTL_MNT_TERC_PNL_EXPEDICION.toString(), 
																		true, 
																		true);
			}
			
			if(objDatEntTipoIdentificacion.getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_TI.getValorPropiedad())){
				
				datFechaNacimiento = this.validarCampoFechaObligatorio(this.castFrmMantenimientoTercero().getDtcFechaNacimiento(),
																	   this.castFrmMantenimientoTercero().getLblFechaNacimiento().getTextoOriginal());
				
			}else{
				datFechaNacimiento = this.castFrmMantenimientoTercero().getDtcFechaNacimiento().getDate();
			}
			
			this.validarConsistenciaFechasDocumento(objDatEntTipoIdentificacion,
													datFechaExpedicion,
													datFechaNacimiento,
													datFechaEntradaPais,
													datFechaVencimiento,
													strDescripcionFechaExpedicion,
													pBooAdvertirInconsistenciaRegistrada);
		}
	}
	
	private void validarConsistenciaFechasDocumento(DatoEntidad pObjDatEntTipoIdentificacion,
													Date pDatFechaExpedicion,
													Date pDatFechaNacimiento,
													Date pDatFechaEntradaPais,
													Date pDatFechaVencimiento,
													String pStrDescripcionFechaExpedicion,
													boolean pBooAdvertirInconsistenciaRegistrada)throws Exception{
		Date datFechaActual;
		int intEdadTercero;
		boolean booDetectaInconsistenciaRegistrada = false;
		
		datFechaActual = UtilidadGiros.getInstancia().obtenerFechaSinHora(UtilIntegracionSlimGiros.getInstance().obtenerFechaHoraActualPosSlim());
		
		if(pDatFechaExpedicion!=null && 
				pDatFechaExpedicion.compareTo(datFechaActual)>0){
			
			if(this.castFrmMantenimientoTercero().getDtcFechaExpedicion().isEnabled()){
			
				throw EnumMensajes.FECHA_1_MAYOR_FECHA_2.generarExcepcion(EnumClasesMensaje.ERROR, 
																	pStrDescripcionFechaExpedicion,
																	EnumEtiquetas.LBL_FECHA_ACTUAL.toString());
			}else{
				
				booDetectaInconsistenciaRegistrada = true;
			}
		}
		
		if(pDatFechaNacimiento!=null && 
				pDatFechaExpedicion != null &&
				pDatFechaNacimiento.compareTo(pDatFechaExpedicion)>=0){
			
			if(this.castFrmMantenimientoTercero().getDtcFechaExpedicion().isEnabled() &&
					this.castFrmMantenimientoTercero().getDtcFechaNacimiento().isEnabled()){
			
				throw EnumMensajes.FECHA_1_MAYOR_IGUAL_FECHA_2.generarExcepcion(EnumClasesMensaje.ERROR, 
																		  EnumEtiquetas.LBL_MNT_TERC_FECHA_NACIMIENTO.toString(),
																		  pStrDescripcionFechaExpedicion);
			}else{
				
				booDetectaInconsistenciaRegistrada = true;
			}
		}
		
		if(pDatFechaNacimiento!=null && 
				pDatFechaNacimiento.compareTo(datFechaActual)>=0){
			
			if(this.castFrmMantenimientoTercero().getDtcFechaNacimiento().isEnabled()){
				
				throw EnumMensajes.FECHA_1_MAYOR_IGUAL_FECHA_2.generarExcepcion(EnumClasesMensaje.ERROR, 
																		  EnumEtiquetas.LBL_MNT_TERC_FECHA_NACIMIENTO.toString(),
																		  EnumEtiquetas.LBL_FECHA_ACTUAL.toString());
			}else{
				
				booDetectaInconsistenciaRegistrada = true;
			}
		}
		
		if(pDatFechaEntradaPais!=null && 
				pDatFechaEntradaPais.compareTo(datFechaActual)>0){
			
			if(this.castFrmMantenimientoTercero().getDtcFechaEntradaPais().isEnabled()){
				
				throw EnumMensajes.FECHA_1_MAYOR_FECHA_2.generarExcepcion(EnumClasesMensaje.ERROR, 
																	EnumEtiquetas.LBL_MNT_TERC_FECHA_ENTRADA_PAIS.toString(),
																	EnumEtiquetas.LBL_FECHA_ACTUAL.toString());
			}else{
				
				booDetectaInconsistenciaRegistrada = true;
			}
		}
		
		if(pDatFechaEntradaPais!=null && 
				pDatFechaExpedicion != null &&
				pDatFechaEntradaPais.compareTo(pDatFechaExpedicion)<=0){
			
			if(this.castFrmMantenimientoTercero().getDtcFechaEntradaPais().isEnabled() &&
					this.castFrmMantenimientoTercero().getDtcFechaExpedicion().isEnabled()){
			
				throw EnumMensajes.FECHA_1_MENOR_IGUAL_FECHA_2.generarExcepcion(EnumClasesMensaje.ERROR, 
																		  EnumEtiquetas.LBL_MNT_TERC_FECHA_ENTRADA_PAIS.toString(),
																		  pStrDescripcionFechaExpedicion);
			}else{
				
				booDetectaInconsistenciaRegistrada = true;
			}
		}
		
		if(pDatFechaVencimiento!=null && 
				pDatFechaEntradaPais != null &&
				pDatFechaVencimiento.compareTo(pDatFechaEntradaPais)<0){
			
			if(this.castFrmMantenimientoTercero().getDtcFechaVencimiento().isEnabled() &&
					this.castFrmMantenimientoTercero().getDtcFechaEntradaPais().isEnabled()){
			
				throw EnumMensajes.FECHA_1_MENOR_FECHA_2.generarExcepcion(EnumClasesMensaje.ERROR, 
																		  EnumEtiquetas.LBL_MNT_TERC_FECHA_VENCIMIENTO.toString(),
																		  EnumEtiquetas.LBL_MNT_TERC_FECHA_ENTRADA_PAIS.toString());
			}else{
				
				booDetectaInconsistenciaRegistrada = true;
			}
		}
		
		if(pDatFechaVencimiento!=null && 
				pDatFechaExpedicion != null &&
				pDatFechaVencimiento.compareTo(pDatFechaExpedicion)<=0){
			
			if(this.castFrmMantenimientoTercero().getDtcFechaVencimiento().isEnabled() &&
					this.castFrmMantenimientoTercero().getDtcFechaExpedicion().isEnabled()){
			
				throw EnumMensajes.FECHA_1_MENOR_IGUAL_FECHA_2.generarExcepcion(EnumClasesMensaje.ERROR, 
																		  		EnumEtiquetas.LBL_MNT_TERC_FECHA_VENCIMIENTO.toString(),
																		  		pStrDescripcionFechaExpedicion);
			}else{
				
				booDetectaInconsistenciaRegistrada = true;
			}
		}
		
		if(pDatFechaNacimiento!=null 
				//&& (pObjDatEntTipoIdentificacion.getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_TI.getValorPropiedad()) 
					//	|| pObjDatEntTipoIdentificacion.getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_CC.getValorPropiedad()))
						){

			intEdadTercero = UtilidadesGiros.getInstance().calcularEdad(pDatFechaNacimiento);
			
			if(pObjDatEntTipoIdentificacion.getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_TI.getValorPropiedad()) 
					&& intEdadTercero >= EnumParametrosApp.EDAD_MAYOR.getValorEntero() 
					|| pObjDatEntTipoIdentificacion.getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_CC.getValorPropiedad()) 
					&& intEdadTercero < EnumParametrosApp.EDAD_MAYOR.getValorEntero()
					|| intEdadTercero >= EnumParametrosApp.MAXIMA_EDAD_PERMITIDA_PARA_REGISTRO.getValorEntero()){
				
				if(this.castFrmMantenimientoTercero().getDtcFechaNacimiento().isEnabled()){
					
					throw EnumMensajes.EDAD_INCONSISTENTE_X_TIPO_DOCUMENTO.generarExcepcion(EnumClasesMensaje.ERROR);
				}else{
					
					booDetectaInconsistenciaRegistrada = true;
				}
				
			}
		}
		
		if(booDetectaInconsistenciaRegistrada
				&& pBooAdvertirInconsistenciaRegistrada){
			
			EnumMensajes.DETECTADA_INCONSISTENCA_INFO_DOCUMENTO_TERCERO.desplegarMensaje(super.getFrmForma(), 
																						 EnumClasesMensaje.ADVERTENCIA);
		}
	}
	
	private void validarInformacionTercero()throws Exception{
		
		if(!this.obtenerTipoIdentificacion().getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_NIT.getValorPropiedad())){
		
			UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmMantenimientoTercero().getTxtPrimerApellido(), 
																	this.castFrmMantenimientoTercero().getLblPrimerApellido().getTextoOriginal(), 
																	true, 
																	true);
			
			this.validarCampoTextoObligatorio(this.castFrmMantenimientoTercero().getTxtPrimerApellido(),
											  this.castFrmMantenimientoTercero().getLblPrimerApellido().getTextoOriginal());
			
			if (!this.castFrmMantenimientoTercero().getTxtSegundoApellido().getText().isEmpty()) {
				
				this.validarCampoTextoObligatorio(this.castFrmMantenimientoTercero().getTxtSegundoApellido(),
						  						  this.castFrmMantenimientoTercero().getLblSegundoApellido().getTextoOriginal());
			}
		}
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmMantenimientoTercero().getTxtNombres(), 
																this.castFrmMantenimientoTercero().getLblNombres().getTextoOriginal(), 
																true, 
																true);
		
		this.validarCampoTextoObligatorio(this.castFrmMantenimientoTercero().getTxtNombres(),
										  this.castFrmMantenimientoTercero().getLblNombres().getTextoOriginal());
		
		if(this.booTerceroPresente){
			
			UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmMantenimientoTercero().getPnlDireccion().getTxtDescripcion(), 
																	this.castFrmMantenimientoTercero().getPnlDireccion().getLblEtiqueta().getTextoOriginal(), 
																	true, 
																	true);
		}
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmMantenimientoTercero().getTxtTelefono(), 
																this.castFrmMantenimientoTercero().getLblTelefono().getTextoOriginal(), 
																true, 
																true);
		
		this.validarCampoTextoObligatorio(this.castFrmMantenimientoTercero().getTxtTelefono(),
										  this.castFrmMantenimientoTercero().getLblTelefono().getTextoOriginal());
		
		this.validarCampoTextoObligatorio(this.castFrmMantenimientoTercero().getTxtCelular(),
										  this.castFrmMantenimientoTercero().getLblCelular().getTextoOriginal());
		
		this.validarCampoTextoObligatorio(this.castFrmMantenimientoTercero().getTxtCorreoElectronico(),
										  this.castFrmMantenimientoTercero().getLblCorreoElectronico().getTextoOriginal());
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmMantenimientoTercero().getCmbActividadesEconomicas(), 
															 	this.castFrmMantenimientoTercero().getLblActividadEconomica().getTextoOriginal(), 
															 	true, 
															 	true);
	}
	
	private void actualizarTercero()throws Exception{
		
		FormaMensajeAlerta objFrmAlerta;
		Tercero objTerceroActualizado;
		String strNotificaCamposActualizados;
		List<EnumEtiquetas> lstCamposActualizados;
		
		strNotificaCamposActualizados = "";
		objTerceroActualizado = (Tercero)this.objTercero.clone();
		lstCamposActualizados = new ArrayList<EnumEtiquetas>();
		
		strNotificaCamposActualizados += this.validarCampoFechaNacimientoActualizado(objTerceroActualizado,lstCamposActualizados);
		strNotificaCamposActualizados += this.validarCampoFechaExpedicionActualizado(objTerceroActualizado,lstCamposActualizados);
		strNotificaCamposActualizados += this.validarCampoFechaEntradaPaisActualizado(objTerceroActualizado,lstCamposActualizados);
		strNotificaCamposActualizados += this.validarCampoFechaVencimientoActualizado(objTerceroActualizado,lstCamposActualizados);
		strNotificaCamposActualizados += this.validarCampoPaisExpedicionActualizado(objTerceroActualizado,lstCamposActualizados);
		strNotificaCamposActualizados += this.validarCampoLugarExpedicionActualizado(objTerceroActualizado,lstCamposActualizados);
		strNotificaCamposActualizados += this.validarCampoPrimerApellidoActualizado(objTerceroActualizado,lstCamposActualizados);
		strNotificaCamposActualizados += this.validarCampoSegundoApellidoActualizado(objTerceroActualizado,lstCamposActualizados);
		strNotificaCamposActualizados += this.validarCampoNombresActualizado(objTerceroActualizado,lstCamposActualizados);
		strNotificaCamposActualizados += this.validarCampoDireccionActualizado(objTerceroActualizado,lstCamposActualizados);
		strNotificaCamposActualizados += this.validarCampoTelefonoActualizado(objTerceroActualizado,lstCamposActualizados);
		strNotificaCamposActualizados += this.validarCampoCelularActualizado(objTerceroActualizado,lstCamposActualizados);
		strNotificaCamposActualizados += this.validarCampoCorreoElectronicoActualizado(objTerceroActualizado,lstCamposActualizados);
		strNotificaCamposActualizados += this.validarCampoActividadEconomicaActualizado(objTerceroActualizado,lstCamposActualizados);
		strNotificaCamposActualizados += this.validarCampoAutoRetenedorActualizado(objTerceroActualizado,lstCamposActualizados);
		strNotificaCamposActualizados += this.validarCampoTerceroPeps(lstCamposActualizados);
		strNotificaCamposActualizados = strNotificaCamposActualizados.replace("null", 
																"");
		
		strNotificaCamposActualizados = strNotificaCamposActualizados.replace("\n", 
																"\n\n").trim();
		
		if(strNotificaCamposActualizados.isEmpty()){
			
			objFrmAlerta = EnumMensajes.CONFIRMACION_NO_ACTUALIZO_NINGUN_DATO.desplegarMensaje(super.getFrmForma(), 
																							   EnumClasesMensaje.CONFIRMACION);
		}else{
			
			objFrmAlerta = EnumMensajes.CONFIRMACION_DATOS_A_ACTUALIZAR.desplegarMensaje(super.getFrmForma(), 
																						 EnumClasesMensaje.CONFIRMACION, 
																						 strNotificaCamposActualizados);
		}
		
		if(objFrmAlerta.isOpcion()){//Aceptar
		
			if(objFrmAlerta.castEvaFrmMensajeAlerta().getMensaje().getCodigo().equals(EnumMensajes.CONFIRMACION_DATOS_A_ACTUALIZAR.getCodigo())){
				
				TerceroVistaLogica.getInstance().actualizarTercero(super.getObjUsuario(),
																   objTerceroActualizado);
				
				this.procesarInformacionTerceroPeps();
				
				EnumMensajes.TERCERO_ACTUALIZADO_EXITOSAMENTE.desplegarMensaje(super.getFrmForma(), 
																			   EnumClasesMensaje.INFORMACION, 
																			   objTerceroActualizado.toStringXDocumento());
				
				this.actualizarTercero(objTerceroActualizado,
									   lstCamposActualizados);
				
				super.regresarFormaPadre();
			}
			
		}else{
			
			if(objFrmAlerta.castEvaFrmMensajeAlerta().getMensaje().getCodigo().equals(EnumMensajes.CONFIRMACION_NO_ACTUALIZO_NINGUN_DATO.getCodigo())){
				super.regresarFormaPadre();
			}
		}
	}
	
	private void actualizarTercero(Tercero pObjTerceroActualizado,
								   List<EnumEtiquetas> pLstCamposActualizados)throws Exception{
		
		for(EnumEtiquetas enmEtiCampoActualizado : pLstCamposActualizados){
		
			switch (enmEtiCampoActualizado) {
			
				case LBL_MNT_TERC_FECHA_NACIMIENTO:
					this.objTercero.setFechaNacimiento(pObjTerceroActualizado.getFechaNacimiento());
					break;
					
				case LBL_MNT_TERC_FECHA_EXPEDICION:
					this.objTercero.setFechaExpedicion(pObjTerceroActualizado.getFechaExpedicion());
					break;
					
				case LBL_MNT_TERC_FECHA_ENTRADA_PAIS:
					this.objTercero.setFechaEntrada(pObjTerceroActualizado.getFechaEntrada());
					break;
				
				case LBL_MNT_TERC_FECHA_VENCIMIENTO:
					this.objTercero.setFechaVencimiento(pObjTerceroActualizado.getFechaVencimiento());
					break;
				
				case LBL_PNL_TERR_PAIS:
					this.objTercero.setPaisExpedicion(pObjTerceroActualizado.getPaisExpedicion());
					break;
				
				case LBL_PNL_TERR_MUNICIPIO:
					this.objTercero.setLugarExpedicion(pObjTerceroActualizado.getLugarExpedicion());
					break;
				
				case LBL_MNT_TERC_PRIMER_APELLIDO:
					this.objTercero.setApellido1(pObjTerceroActualizado.getApellido1());
					break;
				
				case LBL_MNT_TERC_SEGUNDO_APELLIDO:
					this.objTercero.setApellido2(pObjTerceroActualizado.getApellido2());
					break;
				
				case LBL_MNT_TERC_NOMBRES:
					this.objTercero.setNombres(pObjTerceroActualizado.getNombres());
					break;
				
				case LBL_PNL_DIR_ETIQUETA:
					this.objTercero.setDireccion(pObjTerceroActualizado.getDireccion());
					break;
				
				case LBL_MNT_TERC_TELEFONO:
					this.objTercero.setTelefono1(pObjTerceroActualizado.getTelefono1());
					break;
				
				case LBL_MNT_TERC_CELULAR:
					this.objTercero.setTelefono2(pObjTerceroActualizado.getTelefono2());
					break;
				
				case LBL_MNT_TERC_CORREO_ELECTRONICO:
					this.objTercero.setMail(pObjTerceroActualizado.getMail());
					break;
				
				case LBL_MNT_TERC_ACTIVIDAD_ECONOMICA:
					this.objTercero.setActividadEconomica(pObjTerceroActualizado.getActividadEconomica());
					break;
					
				case CHK_MNT_TERC_AUTO_RETENEDOR:
					this.objTercero.setAutoretenedor(pObjTerceroActualizado.isAutoretenedor());
					break;

				default:
				break;
			}
		}
	}
	
	private String validarCampoFechaNacimientoActualizado(Tercero pObjTerceroActualizado,
														  List<EnumEtiquetas> pLstCamposActualizados)throws Exception{
		
		String strCajaFechaNacimiento;
		String strNotificaCamposActualizados = "";
		
		strCajaFechaNacimiento = this.castFrmMantenimientoTercero().getDtcFechaNacimiento().toString();	
		
		if(!UtilidadesGiros.getInstance().compararObjetos(pObjTerceroActualizado.getFechaNacimiento(), 
														  strCajaFechaNacimiento)){
			
			strNotificaCamposActualizados = " \u2022 "+EnumEtiquetas.LBL_MNT_TERC_FECHA_NACIMIENTO.getValor(true)+" "+
												pObjTerceroActualizado.getFechaNacimiento()+" por: "+
												strCajaFechaNacimiento+"\n";
			
			pObjTerceroActualizado.setFechaNacimiento(strCajaFechaNacimiento);
			pLstCamposActualizados.add(EnumEtiquetas.LBL_MNT_TERC_FECHA_NACIMIENTO);
		}
		
		return strNotificaCamposActualizados;
	}
	
	private String validarCampoFechaExpedicionActualizado(Tercero pObjTerceroActualizado,
														  List<EnumEtiquetas> pLstCamposActualizados)throws Exception{
		
		String strCajaFechaExpedicion;
		String strNotificaCamposActualizados = "";
		
		strCajaFechaExpedicion = this.castFrmMantenimientoTercero().getDtcFechaExpedicion().toString();
		
		if(!UtilidadesGiros.getInstance().compararObjetos(pObjTerceroActualizado.getFechaExpedicion(), 
														  strCajaFechaExpedicion)){
			
			strNotificaCamposActualizados = " \u2022 "+EnumEtiquetas.LBL_MNT_TERC_FECHA_EXPEDICION.getValor(true)+" "+
												pObjTerceroActualizado.getFechaExpedicion()+" por: "+
												strCajaFechaExpedicion+"\n";
			
			pObjTerceroActualizado.setFechaExpedicion(strCajaFechaExpedicion);
			pLstCamposActualizados.add(EnumEtiquetas.LBL_MNT_TERC_FECHA_EXPEDICION);
		}
		
		return strNotificaCamposActualizados;
	}
	
	private String validarCampoFechaEntradaPaisActualizado(Tercero pObjTerceroActualizado,
														   List<EnumEtiquetas> pLstCamposActualizados)throws Exception{
		
		String strCajaFechaEntradaPais;
		String strNotificaCamposActualizados = "";
		
		strCajaFechaEntradaPais = this.castFrmMantenimientoTercero().getDtcFechaEntradaPais().toString();			
		
		if(!UtilidadesGiros.getInstance().compararObjetos(pObjTerceroActualizado.getFechaEntrada(), 
														  strCajaFechaEntradaPais)){
			
			strNotificaCamposActualizados = " \u2022 "+EnumEtiquetas.LBL_MNT_TERC_FECHA_ENTRADA_PAIS.getValor(true)+" "+
												pObjTerceroActualizado.getFechaEntrada()+" por: "+
												strCajaFechaEntradaPais+"\n";
			
			pObjTerceroActualizado.setFechaEntrada(strCajaFechaEntradaPais);
			pLstCamposActualizados.add(EnumEtiquetas.LBL_MNT_TERC_FECHA_ENTRADA_PAIS);
		}
		
		return strNotificaCamposActualizados;
	}
	
	private String validarCampoFechaVencimientoActualizado(Tercero pObjTerceroActualizado,
														   List<EnumEtiquetas> pLstCamposActualizados)throws Exception{
		
		String strCajaFechaVencimiento;
		String strNotificaCamposActualizados = "";
		
		strCajaFechaVencimiento = this.castFrmMantenimientoTercero().getDtcFechaVencimiento().toString();	
		
		if(!UtilidadesGiros.getInstance().compararObjetos(pObjTerceroActualizado.getFechaVencimiento(), 
														  strCajaFechaVencimiento)){
			
			strNotificaCamposActualizados = " \u2022 "+EnumEtiquetas.LBL_MNT_TERC_FECHA_VENCIMIENTO.getValor(true)+" "+
												pObjTerceroActualizado.getFechaVencimiento()+" por: "+
												strCajaFechaVencimiento+"\n";
			
			pObjTerceroActualizado.setFechaVencimiento(strCajaFechaVencimiento);
			pLstCamposActualizados.add(EnumEtiquetas.LBL_MNT_TERC_FECHA_VENCIMIENTO);
		}
		
		return strNotificaCamposActualizados;
	}
	
	private String validarCampoPaisExpedicionActualizado(Tercero pObjTerceroActualizado,
													   	 List<EnumEtiquetas> pLstCamposActualizados)throws Exception{
		
		Territorio objTerrPaisExpedicion;
		Object objTmp;
		String strNotificaCamposActualizados = "";
		
		objTmp = this.castFrmMantenimientoTercero().getPnlTerritorioExpedicion().getCmbPais().getSelectedItem();
		
		if(objTmp instanceof Territorio){
			objTerrPaisExpedicion = (Territorio)objTmp;
		}else{
			objTerrPaisExpedicion = null;
		}
		
		if(!UtilidadesGiros.getInstance().compararObjetos(pObjTerceroActualizado.getPaisExpedicion(), 
														  objTerrPaisExpedicion)){
			
			strNotificaCamposActualizados = " \u2022 "+EnumEtiquetas.LBL_PNL_TERR_PAIS.toString()+" "+
												EnumEtiquetas.TTL_MNT_TERC_PNL_EXPEDICION.getValor(true)+" "+
												pObjTerceroActualizado.getPaisExpedicion()+" por: "+
												objTerrPaisExpedicion+"\n";
			
			pObjTerceroActualizado.setPaisExpedicion(objTerrPaisExpedicion);
			pLstCamposActualizados.add(EnumEtiquetas.LBL_PNL_TERR_PAIS);
		}
		
		return strNotificaCamposActualizados;
	}
	
	private String validarCampoLugarExpedicionActualizado(Tercero pObjTerceroActualizado,
														  List<EnumEtiquetas> pLstCamposActualizados)throws Exception{
		
		Territorio objTerrLugarExpedicion;
		Object objTmp;
		String strNotificaCamposActualizados = "";
		
		objTmp = this.castFrmMantenimientoTercero().getPnlTerritorioExpedicion().getCmbMunicipio().getSelectedItem();
		
		if(objTmp instanceof Territorio){
			objTerrLugarExpedicion = (Territorio)objTmp;
		}else{
			objTerrLugarExpedicion = null;
		}
		
		if(!UtilidadesGiros.getInstance().compararObjetos(pObjTerceroActualizado.getLugarExpedicion(), 
														  objTerrLugarExpedicion)){
			
			strNotificaCamposActualizados = " \u2022 "+EnumEtiquetas.LBL_PNL_TERR_MUNICIPIO.toString()+
												EnumEtiquetas.TTL_MNT_TERC_PNL_EXPEDICION.getValor(true)+" "+
												pObjTerceroActualizado.getLugarExpedicion()+" por: "+
												objTerrLugarExpedicion+"\n";
			
			pObjTerceroActualizado.setLugarExpedicion(objTerrLugarExpedicion);
			pLstCamposActualizados.add(EnumEtiquetas.LBL_PNL_TERR_MUNICIPIO);
		}
		
		return strNotificaCamposActualizados;
	}
	
	private String validarCampoPrimerApellidoActualizado(Tercero pObjTerceroActualizado,
													   	 List<EnumEtiquetas> pLstCamposActualizados)throws Exception{
		
		String strCajaPrimerApellido;
		String strNotificaCamposActualizados = "";
		
		strCajaPrimerApellido = this.castFrmMantenimientoTercero().getTxtPrimerApellido().getText();
		
		if(!UtilidadesGiros.getInstance().compararObjetos(pObjTerceroActualizado.getApellido1(), 
														  strCajaPrimerApellido)){
			
			strNotificaCamposActualizados = " \u2022 "+EnumEtiquetas.LBL_MNT_TERC_PRIMER_APELLIDO.getValor(true)+" "+
												pObjTerceroActualizado.getApellido1()+" por: "+
												strCajaPrimerApellido+"\n";
			
			pObjTerceroActualizado.setApellido1(strCajaPrimerApellido);
			pLstCamposActualizados.add(EnumEtiquetas.LBL_MNT_TERC_PRIMER_APELLIDO);
		}
		
		return strNotificaCamposActualizados;
	}
	
	private String validarCampoSegundoApellidoActualizado(Tercero pObjTerceroActualizado,
														  List<EnumEtiquetas> pLstCamposActualizados)throws Exception{
		
		String strCajaSegundoApellido;
		String strNotificaCamposActualizados = "";
		
		strCajaSegundoApellido = this.castFrmMantenimientoTercero().getTxtSegundoApellido().getText();
					
		if(!UtilidadesGiros.getInstance().compararObjetos(pObjTerceroActualizado.getApellido2(), 
														  strCajaSegundoApellido)){
			
			strNotificaCamposActualizados = " \u2022 "+EnumEtiquetas.LBL_MNT_TERC_SEGUNDO_APELLIDO.getValor(true)+" "+
												pObjTerceroActualizado.getApellido2()+" por: "+
												strCajaSegundoApellido+"\n";
			
			pObjTerceroActualizado.setApellido2(strCajaSegundoApellido);
			pLstCamposActualizados.add(EnumEtiquetas.LBL_MNT_TERC_SEGUNDO_APELLIDO);
		}
		
		return strNotificaCamposActualizados;
	}
	
	private String validarCampoNombresActualizado(Tercero pObjTerceroActualizado,
												  List<EnumEtiquetas> pLstCamposActualizados)throws Exception{
		
		String strCajaNombres;
		String strNotificaCamposActualizados = "";
		
		strCajaNombres = this.castFrmMantenimientoTercero().getTxtNombres().getText();
		
		if(!UtilidadesGiros.getInstance().compararObjetos(pObjTerceroActualizado.getNombres(), 
														  strCajaNombres)){
			
			strNotificaCamposActualizados = " \u2022 "+EnumEtiquetas.LBL_MNT_TERC_NOMBRES.getValor(true)+" "+
												pObjTerceroActualizado.getNombres()+" por: "+
												strCajaNombres+"\n";
			
			pObjTerceroActualizado.setNombres(strCajaNombres);
			pLstCamposActualizados.add(EnumEtiquetas.LBL_MNT_TERC_NOMBRES);
		}
		
		return strNotificaCamposActualizados;
	}
	
	private String validarCampoDireccionActualizado(Tercero pObjTerceroActualizado,
												  	List<EnumEtiquetas> pLstCamposActualizados)throws Exception{
		
		String strCajaDireccion;
		String strNotificaCamposActualizados = "";
		
		strCajaDireccion = this.castFrmMantenimientoTercero().getPnlDireccion().getTxtDescripcion().getText();
		
		if(!UtilidadesGiros.getInstance().compararObjetos(pObjTerceroActualizado.getDireccion(), 
														  strCajaDireccion)){
			
			strNotificaCamposActualizados = " \u2022 "+EnumEtiquetas.LBL_PNL_DIR_ETIQUETA.getValor(true)+" "+
												pObjTerceroActualizado.getDireccion()+" por: "+
												strCajaDireccion+"\n";
			
			pObjTerceroActualizado.setDireccion(strCajaDireccion);
			pLstCamposActualizados.add(EnumEtiquetas.LBL_PNL_DIR_ETIQUETA);
		}
		
		return strNotificaCamposActualizados;
	}
	
	private String validarCampoTelefonoActualizado(Tercero pObjTerceroActualizado,
												   List<EnumEtiquetas> pLstCamposActualizados)throws Exception{
		
		String strCajaTelefono;
		String strNotificaCamposActualizados = "";
		
		strCajaTelefono = this.castFrmMantenimientoTercero().getTxtTelefono().getText();
		
		if(!UtilidadesGiros.getInstance().compararObjetos(pObjTerceroActualizado.getTelefono1(), 
														  strCajaTelefono)){
			
			strNotificaCamposActualizados = " \u2022 "+EnumEtiquetas.LBL_MNT_TERC_TELEFONO.getValor(true)+" "+
												pObjTerceroActualizado.getTelefono1()+" por: "+
												strCajaTelefono+"\n";
			
			pObjTerceroActualizado.setTelefono1(strCajaTelefono);
			pLstCamposActualizados.add(EnumEtiquetas.LBL_MNT_TERC_TELEFONO);
		}
		
		return strNotificaCamposActualizados;
	}
	
	private String validarCampoCelularActualizado(Tercero pObjTerceroActualizado,
												  List<EnumEtiquetas> pLstCamposActualizados)throws Exception{
		
		String strCajaCelular;
		String strNotificaCamposActualizados = "";
		
		strCajaCelular = this.castFrmMantenimientoTercero().getTxtCelular().getText();
		
		if(!UtilidadesGiros.getInstance().compararObjetos(pObjTerceroActualizado.getTelefono2(), 
														  strCajaCelular)){
			
			strNotificaCamposActualizados = " \u2022 "+EnumEtiquetas.LBL_MNT_TERC_CELULAR.getValor(true)+" "+
												pObjTerceroActualizado.getTelefono2()+" por: "+
												strCajaCelular+"\n";
			
			pObjTerceroActualizado.setTelefono2(strCajaCelular);
			pLstCamposActualizados.add(EnumEtiquetas.LBL_MNT_TERC_CELULAR);
		}
		
		return strNotificaCamposActualizados;
	}
	
	private String validarCampoCorreoElectronicoActualizado(Tercero pObjTerceroActualizado,
														  	List<EnumEtiquetas> pLstCamposActualizados)throws Exception{
		
		String strCajaCorreoElectronico;
		String strNotificaCamposActualizados = "";
		
		strCajaCorreoElectronico = this.castFrmMantenimientoTercero().getTxtCorreoElectronico().getText();
		
		if(!UtilidadesGiros.getInstance().compararObjetos(pObjTerceroActualizado.getMail(), 
				  										  strCajaCorreoElectronico)){
			
			strNotificaCamposActualizados = " \u2022 "+EnumEtiquetas.LBL_MNT_TERC_CORREO_ELECTRONICO.getValor(true)+" "+
												pObjTerceroActualizado.getMail()+" por: "+
												strCajaCorreoElectronico+"\n";
			
			pObjTerceroActualizado.setMail(strCajaCorreoElectronico);
			pLstCamposActualizados.add(EnumEtiquetas.LBL_MNT_TERC_CORREO_ELECTRONICO);
		}
		
		return strNotificaCamposActualizados;
	}
	
	private String validarCampoActividadEconomicaActualizado(Tercero pObjTerceroActualizado,
														   	 List<EnumEtiquetas> pLstCamposActualizados)throws Exception{
		
		ActividadEconomica objActividadEconomica;
		Object objTmp;
		String strNotificaCamposActualizados = "";
		
		objTmp = this.castFrmMantenimientoTercero().getCmbActividadesEconomicas().getSelectedItem();
		
		if(objTmp instanceof ActividadEconomica){
			objActividadEconomica = (ActividadEconomica)objTmp;
		}else{
			objActividadEconomica = null;
		}
		
		if(!UtilidadesGiros.getInstance().compararObjetos(pObjTerceroActualizado.getActividadEconomica(), 
				  										  objActividadEconomica)){
			
			strNotificaCamposActualizados = " \u2022 "+EnumEtiquetas.LBL_MNT_TERC_ACTIVIDAD_ECONOMICA.getValor(true)+" "+
												(pObjTerceroActualizado.getActividadEconomica()==null?
														"":
														pObjTerceroActualizado.getActividadEconomica().getDescripcion())+" Por: "+
												(objActividadEconomica==null?"":objActividadEconomica.getDescripcion())+"\n";
			
			pObjTerceroActualizado.setActividadEconomica(objActividadEconomica);
			pLstCamposActualizados.add(EnumEtiquetas.LBL_MNT_TERC_ACTIVIDAD_ECONOMICA);
		}
		
		return strNotificaCamposActualizados;
	}
	
	private String validarCampoAutoRetenedorActualizado(Tercero pObjTerceroActualizado,
													  	List<EnumEtiquetas> pLstCamposActualizados)throws Exception{
		
		String strNotificaCamposActualizados = "";
		boolean booCajaAutoRetenedor;
		
		booCajaAutoRetenedor = this.castFrmMantenimientoTercero().getChkAutoRetenedor().isSelected();
		
		if(pObjTerceroActualizado.isAutoretenedor() != booCajaAutoRetenedor){
			
			strNotificaCamposActualizados = " \u2022 "+EnumEtiquetas.CHK_MNT_TERC_AUTO_RETENEDOR.getValor(true)+" "+
												(pObjTerceroActualizado.isAutoretenedor()?"S":"N")+" por: "+
												(booCajaAutoRetenedor?"S":"N")+"\n";
			
			pObjTerceroActualizado.setAutoretenedor(booCajaAutoRetenedor);
			pLstCamposActualizados.add(EnumEtiquetas.CHK_MNT_TERC_AUTO_RETENEDOR);
		}
		
		return strNotificaCamposActualizados;
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	validarCampoTerceroPeps
	 * 		  	Metodo encargado de verificar la modificacion del combo
	 * 			correspondiente a tercero Peps
	 * @param pLstCamposActualizados
	 * 			Lista de etiquetas o componentes actualizados o se requieren actualizar
	 * @return
	 * 			Cadena de mensaje del componente actualizado o requerido para actualizar
	 * @throws Exception
	 * 		   	Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author	stiven.garcia
	 * @date	3/05/2018
	 * *********************************************************************
	 */
	private String validarCampoTerceroPeps( List<EnumEtiquetas> pLstCamposActualizados ) throws Exception {
		
		String strNotificaCamposActualizados = "";
		String strSeleccionComboPeps;
		
		if ( this.isBooActivaValidacionTerceroPeps() ) {
			strSeleccionComboPeps = this.castFrmMantenimientoTercero().getCmbTerceroPeps().getSelectedItem().toString();
			
			if ( !strSeleccionComboPeps.equalsIgnoreCase(EnumEtiquetas.LBL_NO_SELECCIONADO.getValor(false)) ) {
				
				strNotificaCamposActualizados = " \u2022 "+EnumEtiquetas.LBL_PPS_MNT_INFORMACION_PEPS.getValor(true)+" "+
						EnumEtiquetas.LBL_NO_SELECCIONADO.getValor(false) +" por: "+
						strSeleccionComboPeps + "\n";
				
				pLstCamposActualizados.add(EnumEtiquetas.LBL_PPS_PREGUNTA_PEPS);
			}			
		}
		
		return strNotificaCamposActualizados;
		
	}
	
	private void crearTercero()throws Exception{
		
		Tercero objTercero;
		Territorio objTerritorioPaisExpedicion;
		Territorio objTerritorioLugarExpedicion;
		DatoEntidad objDatEntTipoTerceroCliente;
		FormaMensajeAlerta objFrmAlerta;
		String strIdEntidadTiposTercero;
		String strIdDatEntTipoTerceroCliente;
		
		strIdEntidadTiposTercero = EnumParametrosApp.ENT_TIPOS_TERCERO.getValorPropiedad();
		strIdDatEntTipoTerceroCliente = EnumParametrosApp.COD_DAT_ENT_TPTERC_CLIENTE.getValorPropiedad();
		objDatEntTipoTerceroCliente = XmlDatosEntidades.getInstance().obtenerEntidad(strIdEntidadTiposTercero).getHmDatos().get(strIdDatEntTipoTerceroCliente);
		
		objTercero = new Tercero();
		
		objTercero.setTipoTecero(objDatEntTipoTerceroCliente);
		objTercero.setTipoIdentificacion(this.objDatEntTipoIdentificacion);
		objTercero.setIdentificacion(this.strIdentificacion);
		objTercero.setTipoPersona((DatoEntidad)this.castFrmMantenimientoTercero().getCmbTipoPersona().getSelectedItem());
		
		objTercero.setFechaNacimiento(UtilidadGiros.getInstancia().getFecha(this.castFrmMantenimientoTercero().getDtcFechaNacimiento().getDate(), 
																			UtilidadGiros.getInstancia().getFORMATEADOR_FECHA_SLASH()));
		
		objTercero.setFechaEntrada(UtilidadGiros.getInstancia().getFecha(this.castFrmMantenimientoTercero().getDtcFechaEntradaPais().getDate(), 
																		 UtilidadGiros.getInstancia().getFORMATEADOR_FECHA_SLASH()));
		
		objTercero.setFechaVencimiento(UtilidadGiros.getInstancia().getFecha(this.castFrmMantenimientoTercero().getDtcFechaVencimiento().getDate(), 
				 														 	 UtilidadGiros.getInstancia().getFORMATEADOR_FECHA_SLASH()));
		
		objTercero.setFechaExpedicion(UtilidadGiros.getInstancia().getFecha(this.castFrmMantenimientoTercero().getDtcFechaExpedicion().getDate(), 
			 	 															UtilidadGiros.getInstancia().getFORMATEADOR_FECHA_SLASH()));
		
		if(this.castFrmMantenimientoTercero().getPnlTerritorioExpedicion().getCmbPais().getSelectedItem() instanceof Territorio){
			
			objTerritorioPaisExpedicion = (Territorio)this.castFrmMantenimientoTercero().getPnlTerritorioExpedicion().getCmbPais().getSelectedItem();
			
		}else{
			
			objTerritorioPaisExpedicion = null;
		}
		
		objTercero.setPaisExpedicion((objTerritorioPaisExpedicion));
		
		if(!objTercero.getTipoIdentificacion().getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_PA.getValorPropiedad()) &&
				!objTercero.getTipoIdentificacion().getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_CE.getValorPropiedad()) &&
				!objTercero.getTipoIdentificacion().getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_CEX.getValorPropiedad()) &&
				this.castFrmMantenimientoTercero().getPnlTerritorioExpedicion().getCmbMunicipio().getSelectedItem() instanceof Territorio){
			
			objTerritorioLugarExpedicion = (Territorio)this.castFrmMantenimientoTercero().getPnlTerritorioExpedicion().getCmbMunicipio().getSelectedItem();
			
		}else{
			
			objTerritorioLugarExpedicion = null;
		}
		
		objTercero.setLugarExpedicion((objTerritorioLugarExpedicion));
		
		objTercero.setApellido1(this.castFrmMantenimientoTercero().getTxtPrimerApellido().getText().trim());
		objTercero.setApellido2(this.castFrmMantenimientoTercero().getTxtSegundoApellido().getText().trim());
		objTercero.setNombres(this.castFrmMantenimientoTercero().getTxtNombres().getText().trim());
		objTercero.setDireccion(this.castFrmMantenimientoTercero().getPnlDireccion().getTxtDescripcion().getText());
		objTercero.setTelefono1(this.castFrmMantenimientoTercero().getTxtTelefono().getText().trim());
		objTercero.setTelefono2(this.castFrmMantenimientoTercero().getTxtCelular().getText().trim());
		objTercero.setMail(this.castFrmMantenimientoTercero().getTxtCorreoElectronico().getText().trim());
		objTercero.setActividadEconomica((ActividadEconomica)this.castFrmMantenimientoTercero().getCmbActividadesEconomicas().getSelectedItem());
		objTercero.setAutoretenedor(this.castFrmMantenimientoTercero().getChkAutoRetenedor().isSelected());
		
		if	(	this.getObjInfoTerceroCapturadaXDocumento()	!=	null	)
		{
			objTercero.setStrSexo(this.getObjInfoTerceroCapturadaXDocumento().getStrSexo());
			objTercero.setStrTipoSangre(this.getObjInfoTerceroCapturadaXDocumento().getStrTipoSangre());
		}
		
		objFrmAlerta = EnumMensajes.CONFIRMAR_REGISTRO_OPERACION.desplegarMensaje(super.getFrmForma(), 
																   				  EnumClasesMensaje.CONFIRMACION);	
		if(objFrmAlerta.isOpcion()){//aceptar
			
			TerceroVistaLogica.getInstance().crearTercero(super.getObjUsuario(),
														  objTercero);
			
			this.objTercero = objTercero;
			
			this.procesarInformacionTerceroPeps();
			
			EnumMensajes.TERCERO_CREADO_EXITOSAMENTE.desplegarMensaje(super.getFrmForma(), 
																	  EnumClasesMensaje.INFORMACION, 
																	  objTercero.toStringXDocumento());
			super.regresarFormaPadre();
		}
	}
	
private void crearTerceroNuevoRedExterna()throws Exception{
		
		Tercero objTercero;
		Territorio objTerritorioPaisExpedicion;
		Territorio objTerritorioLugarExpedicion;
		DatoEntidad objDatEntTipoTerceroCliente;
		FormaMensajeAlerta objFrmAlerta;
		String strIdEntidadTiposTercero;
		String strIdDatEntTipoTerceroCliente;
		DatoEntidad ObjDatEntTipoIdentificacion;
	    String StrIdentificacion;
		
		strIdEntidadTiposTercero = EnumParametrosApp.ENT_TIPOS_TERCERO.getValorPropiedad();
		strIdDatEntTipoTerceroCliente = EnumParametrosApp.COD_DAT_ENT_TPTERC_CLIENTE.getValorPropiedad();
		objDatEntTipoTerceroCliente = XmlDatosEntidades.getInstance().obtenerEntidad(strIdEntidadTiposTercero).getHmDatos().get(strIdDatEntTipoTerceroCliente);
		
		objTercero = new Tercero();
		
		objTercero.setTipoTecero(objDatEntTipoTerceroCliente);
		ObjDatEntTipoIdentificacion = (DatoEntidad)this.castFrmMantenimientoTercero().getCmbTipoIdentificacion().getSelectedItem();
		objTercero.setTipoIdentificacion(ObjDatEntTipoIdentificacion);
		StrIdentificacion = this.castFrmMantenimientoTercero().getTxtIdentificacion().getText().trim();
		objTercero.setIdentificacion(StrIdentificacion);
		objTercero.setTipoPersona((DatoEntidad)this.castFrmMantenimientoTercero().getCmbTipoPersona().getSelectedItem());
		
		objTercero.setFechaNacimiento(UtilidadGiros.getInstancia().getFecha(this.castFrmMantenimientoTercero().getDtcFechaNacimiento().getDate(), 
																			UtilidadGiros.getInstancia().getFORMATEADOR_FECHA_SLASH()));
		
		objTercero.setFechaEntrada(UtilidadGiros.getInstancia().getFecha(this.castFrmMantenimientoTercero().getDtcFechaEntradaPais().getDate(), 
																		 UtilidadGiros.getInstancia().getFORMATEADOR_FECHA_SLASH()));
		
		objTercero.setFechaVencimiento(UtilidadGiros.getInstancia().getFecha(this.castFrmMantenimientoTercero().getDtcFechaVencimiento().getDate(), 
				 														 	 UtilidadGiros.getInstancia().getFORMATEADOR_FECHA_SLASH()));
		
		objTercero.setFechaExpedicion(UtilidadGiros.getInstancia().getFecha(this.castFrmMantenimientoTercero().getDtcFechaExpedicion().getDate(), 
			 	 															UtilidadGiros.getInstancia().getFORMATEADOR_FECHA_SLASH()));
		
		if(this.castFrmMantenimientoTercero().getPnlTerritorioExpedicion().getCmbPais().getSelectedItem() instanceof Territorio){
			
			objTerritorioPaisExpedicion = (Territorio)this.castFrmMantenimientoTercero().getPnlTerritorioExpedicion().getCmbPais().getSelectedItem();
			
		}else{
			
			objTerritorioPaisExpedicion = null;
		}
		
		objTercero.setPaisExpedicion((objTerritorioPaisExpedicion));
		
		if(!objTercero.getTipoIdentificacion().getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_PA.getValorPropiedad()) &&
				!objTercero.getTipoIdentificacion().getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_CE.getValorPropiedad()) &&
				!objTercero.getTipoIdentificacion().getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_CEX.getValorPropiedad()) &&
				this.castFrmMantenimientoTercero().getPnlTerritorioExpedicion().getCmbMunicipio().getSelectedItem() instanceof Territorio){
			
			objTerritorioLugarExpedicion = (Territorio)this.castFrmMantenimientoTercero().getPnlTerritorioExpedicion().getCmbMunicipio().getSelectedItem();
			
		}else{
			
			objTerritorioLugarExpedicion = null;
		}
		
		objTercero.setLugarExpedicion((objTerritorioLugarExpedicion));
		
		objTercero.setApellido1(this.castFrmMantenimientoTercero().getTxtPrimerApellido().getText().trim());
		objTercero.setApellido2(this.castFrmMantenimientoTercero().getTxtSegundoApellido().getText().trim());
		objTercero.setNombres(this.castFrmMantenimientoTercero().getTxtNombres().getText().trim());
		objTercero.setDireccion(this.castFrmMantenimientoTercero().getPnlDireccion().getTxtDescripcion().getText());
		objTercero.setTelefono1(this.castFrmMantenimientoTercero().getTxtTelefono().getText().trim());
		objTercero.setTelefono2(this.castFrmMantenimientoTercero().getTxtCelular().getText().trim());
		objTercero.setMail(this.castFrmMantenimientoTercero().getTxtCorreoElectronico().getText().trim());
		objTercero.setActividadEconomica((ActividadEconomica)this.castFrmMantenimientoTercero().getCmbActividadesEconomicas().getSelectedItem());
		objTercero.setAutoretenedor(this.castFrmMantenimientoTercero().getChkAutoRetenedor().isSelected());
		
		if	(	this.getObjInfoTerceroCapturadaXDocumento()	!=	null	)
		{
			objTercero.setStrSexo(this.getObjInfoTerceroCapturadaXDocumento().getStrSexo());
			objTercero.setStrTipoSangre(this.getObjInfoTerceroCapturadaXDocumento().getStrTipoSangre());
		}
		
		objFrmAlerta = EnumMensajes.CONFIRMAR_REGISTRO_OPERACION.desplegarMensaje(super.getFrmForma(), 
																   				  EnumClasesMensaje.CONFIRMACION);	
		if(objFrmAlerta.isOpcion()){//aceptar
			
			TerceroVistaLogica.getInstance().validaTercero(super.getObjUsuario(),
														   objTercero, 
														   false);

			
			
			//this.objTercero = objTercero;
			
			this.procesarInformacionTerceroPeps();
			
			EnumMensajes.TERCERO_CREADO_EXITOSAMENTE.desplegarMensaje(super.getFrmForma(), 
																	  EnumClasesMensaje.INFORMACION, 
																	  objTercero.toStringXDocumento());
			this.booTerceroNuevoRedExterna = false;
			this.booRecargarTercero = true;
			
			super.regresarFormaPadre();
		}
	}
	
	private void validarCampoTextoObligatorio(CajaTextoUtil pCompCajaTextoUtil,
											  String pStrDescripcionCampo)throws Exception{
		
		if(pCompCajaTextoUtil.isEnabled() &&
				pCompCajaTextoUtil.isEditable()){
			
			pCompCajaTextoUtil.getPropiedades().validaFormatoFinal(true,
																   pStrDescripcionCampo);
		}
		
	}
	
	private Date validarCampoFechaObligatorio(CajaFechaUtil pCompCajaFechaUtil,
											  String pStrDescripcion)throws Exception{
		
		Date datFecha;
		
		datFecha = pCompCajaFechaUtil.getDate();
		
		if(pCompCajaFechaUtil.isEnabled()){
			
			UtilComponentesGUI.getInstance().validarObligatoriedadCampo(pCompCajaFechaUtil, 
																	pStrDescripcion, 
																	true, 
																	true);
			
			
		}
		
		return datFecha;
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
		
		this.castFrmMantenimientoTercero().getTxtNombres().getPropiedades().setActivaMayusculaMinuscula(true);
		this.castFrmMantenimientoTercero().getTxtNombres().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_NOMBRES_TERCERO.getValor());
		this.castFrmMantenimientoTercero().getTxtNombres().getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.EXP_REG_FORMATO_NOMBRES_TERCERO_FINAL.getValor());
		
		this.castFrmMantenimientoTercero().getTxtPrimerApellido().getPropiedades().setActivaMayusculaMinuscula(true);
		this.castFrmMantenimientoTercero().getTxtPrimerApellido().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_PRIMER_APELLIDO_TERCERO.getValor());
		this.castFrmMantenimientoTercero().getTxtPrimerApellido().getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.EXP_REG_FORMATO_PRIMER_APELLIDO_TERCERO_FINAL.getValor());
		
		this.castFrmMantenimientoTercero().getTxtSegundoApellido().getPropiedades().setActivaMayusculaMinuscula(true);
		this.castFrmMantenimientoTercero().getTxtSegundoApellido().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_SEGUNDO_APELLIDO_TERCERO.getValor());
		this.castFrmMantenimientoTercero().getTxtSegundoApellido().getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.EXP_REG_FORMATO_SEGUNDO_APELLIDO_TERCERO_FINAL.getValor());
		
		this.castFrmMantenimientoTercero().getTxtTelefono().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_INGRESO_TELEFONO.getValor());
		this.castFrmMantenimientoTercero().getTxtTelefono().getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.EXP_REG_FORMATO_TELEFONO_TERCERO.getValor());
		
		this.castFrmMantenimientoTercero().getTxtCelular().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_INGRESO_CELULAR.getValor());
		this.castFrmMantenimientoTercero().getTxtCelular().getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.EXP_REG_FORMATO_CELULAR_TERCERO.getValor());
		
		this.castFrmMantenimientoTercero().getTxtCorreoElectronico().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_INGRESO_CORREO_ELECTRONICO.getValor());
		this.castFrmMantenimientoTercero().getTxtCorreoElectronico().getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.EXP_REG_FORMATO_CORREO_ELECTRONICO_TERCERO.getValor());
	}
	
	private void cargarFormulario()throws Exception{
		
		this.cargarTipoIdentificacion();
		this.cargarIdentificacion();
		this.cargarTipoPersona();
		this.cargarActividadEconomica();
		
		if(this.objTercero == null)
		{
			this.setObjInfoTerceroCapturadaXDocumento(this.validarCapturaDatosCCXQR());
			this.objTercero = this.getObjInfoTerceroCapturadaXDocumento();
		}
		
		if(this.objTercero != null){
			
			this.cargarFechaNacimiento();
			this.cargarNombres();
			this.cargarPrimerApellido();
			this.cargarSegundoApellido();
			
			if	(	this.getObjInfoTerceroCapturadaXDocumento()	!= null	)
			{
				this.objTercero = null;
			}else{
				this.cargarFechaExpedicion();
				this.cargarFechaEntradaPais();
				this.cargarFechaVencimiento();
				this.cargarLugarExpedicion();
				this.cargarDireccion();
				this.cargarTelefono();
				this.cargarCelular();
				this.cargarCorreoElectronico();
				this.cargarAutoretenedor();
			}
			
		}else{
			
 			if(this.obtenerTipoIdentificacion().getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_CE.getValorPropiedad()) ||
					this.obtenerTipoIdentificacion().getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_CEX.getValorPropiedad()) ||
					this.obtenerTipoIdentificacion().getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_PA.getValorPropiedad())){
				
				this.castFrmMantenimientoTercero().getPnlTerritorioExpedicion().getCmbPais().setSelectedItem(EnumEtiquetas.LBL_NO_SELECCIONADO);
			}
			
			this.castFrmMantenimientoTercero().getPnlTerritorioExpedicion().getCmbDepartamento().setSelectedItem(EnumEtiquetas.LBL_NO_SELECCIONADO);
			this.castFrmMantenimientoTercero().getPnlTerritorioExpedicion().getCmbMunicipio().setSelectedItem(EnumEtiquetas.LBL_NO_SELECCIONADO);
		}
		
		this.habilitarComponentes();
	}
	
	private void habilitarComponentes()throws Exception{
		
		this.habilitarSeccionInfoBasica();
		this.habilitarSeccionDocumento();
	}
	
	/**
	 * ********************************************************************
	 * @method	habilitarSeccionInfoBasica
	 * 		  	Metodo que permite habilitar del formulario, la seccion de 
	 * 			informacion basica del tercero
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author	hector.cuenca
	 * @date	26/05/2018
	 * *********************************************************************
	 */
	private void habilitarSeccionInfoBasica()
		throws Exception
	{
		if	(	this.objTercero == null	)
		{
			//creacion del tercero
			
			if	(	this.obtenerTipoIdentificacion().getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_NIT.getValorPropiedad())	)
			{
				this.castFrmMantenimientoTercero().getTxtPrimerApellido().setEditable(false);
				this.castFrmMantenimientoTercero().getTxtSegundoApellido().setEditable(false);
			}
		}else{
			//actualizar tercero
			this.castFrmMantenimientoTercero().getTxtPrimerApellido().setEditable(false);
			this.castFrmMantenimientoTercero().getTxtSegundoApellido().setEditable(false);
		}
	}
	
	private void habilitarSeccionDocumento()throws Exception{
		
		DatoEntidad objDatEntTipoIdentificacion;
		
		objDatEntTipoIdentificacion = this.obtenerTipoIdentificacion();
		
		if(objDatEntTipoIdentificacion.getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_NIT.getValorPropiedad())){
			
			UtilComponentesGUI.getInstance().habilitarComponentesContenedorMasivo(this.castFrmMantenimientoTercero().getPnlContenidoCuerpo(), 
																			  false, 
																			  false, 
																			  false);
			
		}else if(objDatEntTipoIdentificacion.getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_CC.getValorPropiedad()) ||
					objDatEntTipoIdentificacion.getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_TI.getValorPropiedad())){
			
			this.castFrmMantenimientoTercero().getDtcFechaEntradaPais().setEnabled(false);
			this.castFrmMantenimientoTercero().getDtcFechaVencimiento().setEnabled(false);
			this.castFrmMantenimientoTercero().getPnlTerritorioExpedicion().getCmbPais().setEnabled(false);
			
		}else if(objDatEntTipoIdentificacion.getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_CE.getValorPropiedad()) ||
					objDatEntTipoIdentificacion.getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_CEX.getValorPropiedad())){
			
			this.castFrmMantenimientoTercero().getDtcFechaEntradaPais().setEnabled(false);
			this.castFrmMantenimientoTercero().getDtcFechaVencimiento().setEnabled(false);
			this.castFrmMantenimientoTercero().getPnlTerritorioExpedicion().getCmbDepartamento().setEnabled(false);
			this.castFrmMantenimientoTercero().getPnlTerritorioExpedicion().getCmbMunicipio().setEnabled(false);
			
		}else if(objDatEntTipoIdentificacion.getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_PA.getValorPropiedad())){
			
			this.castFrmMantenimientoTercero().getPnlTerritorioExpedicion().getCmbDepartamento().setEnabled(false);
			this.castFrmMantenimientoTercero().getPnlTerritorioExpedicion().getCmbMunicipio().setEnabled(false);
		}
		
		if(!this.booTerceroPresente){
			
			UtilComponentesGUI.getInstance().habilitarComponentesContenedorMasivo(this.castFrmMantenimientoTercero().getPnlContenidoCuerpo(), 
																			  this.booTerceroPresente, 
																			  false, 
																			  false);
		}
	}
	
	private void cargarAutoretenedor()throws Exception{
		
		if (!this.booTerceroNuevoRedExterna) {
			this.castFrmMantenimientoTercero().getChkAutoRetenedor().setSelected(this.objTercero.isAutoretenedor());
		}
	}
	
	private void cargarActividadEconomica()throws Exception{
		
		HashMap<String, ActividadEconomica> hmActividadesEconomicas;
		Object objActividadEconomicaTercero;
		String strActividadEconomicaDefault;
		ParametroSistema objParametrosSistemas;
		boolean booEsActividadEconomicaDefault = false;
		
		objParametrosSistemas = UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.CODIGO_ACTIVIDAD_ECONOMICA_DEFAULT);
		strActividadEconomicaDefault = objParametrosSistemas.getValor();
		
		if(this.objTercero != null && !this.booTerceroNuevoRedExterna){
			
			objActividadEconomicaTercero = this.objTercero.getActividadEconomica();
			if (this.objTercero.getActividadEconomica().getCodigo().trim()
					.equals(strActividadEconomicaDefault.trim())) {
				booEsActividadEconomicaDefault = true;
				objActividadEconomicaTercero = EnumEtiquetas.LBL_NO_SELECCIONADO;
			}
			hmActividadesEconomicas = XmlActividadesEconomicas.getInstance().getHmActividadesEconomicas();
			
		}else{
			
			objActividadEconomicaTercero = EnumEtiquetas.LBL_NO_SELECCIONADO;
			hmActividadesEconomicas = XmlActividadesEconomicas.getInstance().getHmActividadesEconomicasResumidas();
		}
		
		this.castFrmMantenimientoTercero().getCmbActividadesEconomicas().getPropiedades().cargarCombo(hmActividadesEconomicas.values().toArray(), 
												 													  true, 
												 													  objActividadEconomicaTercero);
		
		if(this.objTercero != null && !this.booTerceroNuevoRedExterna && !booEsActividadEconomicaDefault){
			
			if(UtilidadesGiros.getInstance().compararObjetos(objActividadEconomicaTercero, 
															 this.castFrmMantenimientoTercero().getCmbActividadesEconomicas().getSelectedItem())){
				
				this.objTercero.setActividadEconomica((ActividadEconomica)this.castFrmMantenimientoTercero().getCmbActividadesEconomicas().getSelectedItem());
			}
		}
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	validarDespliegueComboTerceroPeps
	 * 		  	Metodo encargado de pintar la opcion de combo para la 
	 * 			funcionalidad de TerceroPeps
	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author	stiven.garcia
	 * @date	2/05/2018
	 * *********************************************************************
	 */
	private void validarDespliegueComboTerceroPeps() throws Exception{		
		
		if (this.isBooActivaValidacionTerceroPeps()) {
			Tercero objTercero = new Tercero(this.obtenerTipoIdentificacion(), this.obtenerIdentificacion());
			if( !UtilTerceroPeps.getInstancia().validarServicioTerceroPeps() || !UtilTerceroPeps.getInstancia().validarTipoDocumentoPermitido(objTercero)) {
				this.castFrmMantenimientoTercero().getCmbTerceroPeps().setVisible(false);
				this.castFrmMantenimientoTercero().getLblTerceroPeps().setVisible(false);
			}else {
				this.cargarComboTerceroPeps();
			}
		}else{
			this.castFrmMantenimientoTercero().getCmbTerceroPeps().setVisible(false);
			this.castFrmMantenimientoTercero().getLblTerceroPeps().setVisible(false);
		}
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	cargarComboTerceroPeps
	 * 		  	Metodo encargado de listar las opciones del combo 
	 * 			para la funcionalidad de TerceroPeps
	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author	stiven.garcia
	 * @date	2/05/2018
	 * *********************************************************************
	 */
	private void cargarComboTerceroPeps() throws Exception{
		
		this.castFrmMantenimientoTercero().getCmbTerceroPeps().getPropiedades().cargarCombo(new String [] {ControladorEtiquetas.etiquetasMsg.getString("general_si").toUpperCase(),
																										   ControladorEtiquetas.etiquetasMsg.getString("general_no").toUpperCase()
																										  }, true, EnumEtiquetas.LBL_NO_SELECCIONADO);
		
	}
	
	private void cargarCorreoElectronico()throws Exception{
		
		if (!this.booTerceroNuevoRedExterna) {
			this.castFrmMantenimientoTercero().getTxtCorreoElectronico().setText(this.objTercero.getMail());
		}
	}
	
	private void cargarCelular()throws Exception{
		
		if (!this.booTerceroNuevoRedExterna) {
			this.castFrmMantenimientoTercero().getTxtCelular().setText(this.objTercero.getTelefono2());
		}
	}
	
	private void cargarTelefono()throws Exception{
		
		if(!this.booTerceroNuevoRedExterna) {
			this.castFrmMantenimientoTercero().getTxtTelefono().setText(this.objTercero.getTelefono1());
		}
	}
	
	private void cargarDireccion()throws Exception{
		
		if (!this.booTerceroNuevoRedExterna) {
			this.castFrmMantenimientoTercero().getPnlDireccion().getTxtDescripcion().setText(this.objTercero.getDireccion());
		}
	}
	
	private void cargarSegundoApellido()
		throws Exception
	{
		if	(	this.objTercero.getApellido2() != null	)
		{
			this.castFrmMantenimientoTercero().getTxtSegundoApellido().setText(this.objTercero.getApellido2());
			this.castFrmMantenimientoTercero().getTxtSegundoApellido().setEditable(false);
		}
	}
	
	private void cargarPrimerApellido()
		throws Exception
	{
		if	(	this.objTercero.getApellido1() != null	)
		{
			this.castFrmMantenimientoTercero().getTxtPrimerApellido().setText(this.objTercero.getApellido1());
			this.castFrmMantenimientoTercero().getTxtPrimerApellido().setEditable(false);
		}
	}
	
	private void cargarNombres()
		throws Exception
	{
		if	(	this.objTercero.getNombres() != null	)
		{
			this.castFrmMantenimientoTercero().getTxtNombres().setText(this.objTercero.getNombres());
			this.castFrmMantenimientoTercero().getTxtNombres().setEditable(false);
		}
	}
	
	private void cargarLugarExpedicion()throws Exception{
		
		if(this.objTercero.getLugarExpedicion() != null && !this.booTerceroNuevoRedExterna){
			
			this.castFrmMantenimientoTercero().getPnlTerritorioExpedicion().castEventosForma().definirTerritorioBase(EnumParametrosApp.CODIGO_TIPO_TERRITORIO_MUNICIPIO.getValorEntero(), 
																													 this.objTercero.getLugarExpedicion().getCodigo());
			if(UtilidadesGiros.getInstance().compararObjetos(this.objTercero.getLugarExpedicion(), 
															 this.castFrmMantenimientoTercero().getPnlTerritorioExpedicion().getCmbMunicipio().getSelectedItem())){
				
				this.objTercero.setLugarExpedicion((Territorio)this.castFrmMantenimientoTercero().getPnlTerritorioExpedicion().getCmbMunicipio().getSelectedItem());
				
				this.castFrmMantenimientoTercero().getPnlTerritorioExpedicion().getCmbDepartamento().setEnabled(false);
				this.castFrmMantenimientoTercero().getPnlTerritorioExpedicion().getCmbMunicipio().setEnabled(false);
			}
			
		}else {
			
			if(this.objTercero.getPaisExpedicion() != null && !this.booTerceroNuevoRedExterna){
				
				this.castFrmMantenimientoTercero().getPnlTerritorioExpedicion().castEventosForma().definirTerritorioBase(EnumParametrosApp.CODIGO_TIPO_TERRITORIO_PAIS.getValorEntero(), 
						 																								 this.objTercero.getPaisExpedicion().getCodigo());
				
				if(UtilidadesGiros.getInstance().compararObjetos(this.objTercero.getPaisExpedicion(), 
						 										 this.castFrmMantenimientoTercero().getPnlTerritorioExpedicion().getCmbPais().getSelectedItem())){
					
					this.objTercero.setPaisExpedicion((Territorio)this.castFrmMantenimientoTercero().getPnlTerritorioExpedicion().getCmbPais().getSelectedItem());
					
					this.castFrmMantenimientoTercero().getPnlTerritorioExpedicion().getCmbPais().setEnabled(false);
				}
				
			}else if(this.objTercero.getTipoIdentificacion().getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_CE.getValorPropiedad()) ||
						this.objTercero.getTipoIdentificacion().getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_CEX.getValorPropiedad()) ||
						this.objTercero.getTipoIdentificacion().getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_PA.getValorPropiedad())){
				
				this.castFrmMantenimientoTercero().getPnlTerritorioExpedicion().getCmbPais().setSelectedItem(EnumEtiquetas.LBL_NO_SELECCIONADO);
			}
			
			this.castFrmMantenimientoTercero().getPnlTerritorioExpedicion().getCmbDepartamento().setSelectedItem(EnumEtiquetas.LBL_NO_SELECCIONADO);
			this.castFrmMantenimientoTercero().getPnlTerritorioExpedicion().getCmbMunicipio().setSelectedItem(EnumEtiquetas.LBL_NO_SELECCIONADO);
		}
	}
	
	private void cargarFechaExpedicion()throws Exception{
		
		Date datFechaExpedicion;
		
		datFechaExpedicion = UtilidadGiros.getInstancia().getFecha(this.objTercero.getFechaExpedicion());
		
		if(datFechaExpedicion != null && !this.booTerceroNuevoRedExterna){
		
			this.castFrmMantenimientoTercero().getDtcFechaExpedicion().setDate(datFechaExpedicion);
			this.castFrmMantenimientoTercero().getDtcFechaExpedicion().setEnabled(false);
		}
	}
	
	private void cargarFechaVencimiento()throws Exception{
		
		Date datFechaVencimiento;
		
		datFechaVencimiento = UtilidadGiros.getInstancia().getFecha(this.objTercero.getFechaVencimiento());
		
		if(datFechaVencimiento != null && !this.booTerceroNuevoRedExterna){
		
			this.castFrmMantenimientoTercero().getDtcFechaVencimiento().setDate(datFechaVencimiento);
		}
	}
	
	private void cargarFechaEntradaPais()throws Exception{
		
		Date datFechaEntradaPais;
		
		datFechaEntradaPais = UtilidadGiros.getInstancia().getFecha(this.objTercero.getFechaEntrada());
		
		if(datFechaEntradaPais != null && !this.booTerceroNuevoRedExterna){
		
			this.castFrmMantenimientoTercero().getDtcFechaEntradaPais().setDate(datFechaEntradaPais);
		}
	}
	
	private void cargarFechaNacimiento()throws Exception{
		
		Date datFechaNacimiento;
		
		datFechaNacimiento = UtilidadGiros.getInstancia().getFecha(this.objTercero.getFechaNacimiento());
		
		if(datFechaNacimiento != null && !this.booTerceroNuevoRedExterna){
		
			this.castFrmMantenimientoTercero().getDtcFechaNacimiento().setDate(datFechaNacimiento);
			this.castFrmMantenimientoTercero().getDtcFechaNacimiento().setEnabled(false);
		}
	}
	
	private void cargarTipoPersona()throws Exception{
		
		Entidad objEntTiposPersona;
		DatoEntidad objDatEntTipoIdentificacion;
		DatoEntidad objDatEntTipoPersona;
		String strIdEntidadTiposPersona;
		String strIdDatEntTipoPersona;
		
		strIdEntidadTiposPersona = EnumParametrosApp.ENT_TIPOS_PERSONA.getValorPropiedad();
		objEntTiposPersona = XmlDatosEntidades.getInstance().obtenerEntidad(strIdEntidadTiposPersona);
		
		objDatEntTipoIdentificacion = this.obtenerTipoIdentificacion();
		
		if(objDatEntTipoIdentificacion.getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_NIT.getValorPropiedad())){//Persona Juridica
			
			strIdDatEntTipoPersona = EnumParametrosApp.COD_DAT_ENT_TPPER_JURIDICA.getValorPropiedad();
			
		}else{//Persona natural
			
			strIdDatEntTipoPersona = EnumParametrosApp.COD_DAT_ENT_TPPER_NATURAL.getValorPropiedad();
		}
		
		objDatEntTipoPersona = objEntTiposPersona.getHmDatos().get(strIdDatEntTipoPersona);
		
		this.castFrmMantenimientoTercero().getCmbTipoPersona().addItem(objDatEntTipoPersona);
	}
	
	private void cargarIdentificacion()throws Exception{
		
		String strIdentificacion;
		
		strIdentificacion = this.obtenerIdentificacion();
		
		this.castFrmMantenimientoTercero().getTxtIdentificacion().setText(strIdentificacion);
	}
	
	private void cargarTipoIdentificacion()throws Exception{
		
		DatoEntidad objDatEntTipoIdentificacion;
		
		objDatEntTipoIdentificacion = this.obtenerTipoIdentificacion();
		
		this.castFrmMantenimientoTercero().getCmbTipoIdentificacion().addItem(objDatEntTipoIdentificacion);
	}
	
	private String obtenerIdentificacion()throws Exception{
		
		String strIdentificacion;
		
		if(this.objTercero != null){
			strIdentificacion = this.objTercero.getIdentificacion();
		}else{
			strIdentificacion = this.strIdentificacion;
		}
		
		return strIdentificacion;
	}
	
	private DatoEntidad obtenerTipoIdentificacion()throws Exception{
		
		DatoEntidad objDatEntTipoIdentificacion;
		
		if(this.objTercero != null){
			objDatEntTipoIdentificacion = this.objTercero.getTipoIdentificacion();
		}else{
			objDatEntTipoIdentificacion = this.objDatEntTipoIdentificacion;
		}
		
		return objDatEntTipoIdentificacion;
	}
	
	private String obtenerDescripcionTercero() throws Exception{
		String strDescripcionTercero;
		if(this.objTercero != null){
			strDescripcionTercero = this.objTercero.getDescripcion();
		}else{
			strDescripcionTercero = this.strDescripcionTercero;
		}
		
		return strDescripcionTercero;
	}
	
	public FormaMantenimientoTercero castFrmMantenimientoTercero()throws Exception{
		return (FormaMantenimientoTercero)super.getFrmForma();
	}

	public Tercero getObjTercero() {
		return objTercero;
	}

	public void setObjTercero(Tercero objTercero) {
		this.objTercero = objTercero;
	}

	public DatoEntidad getObjDatEntTipoIdentificacion() {
		return objDatEntTipoIdentificacion;
	}

	public void setObjDatEntTipoIdentificacion(
			DatoEntidad objDatEntTipoIdentificacion) {
		this.objDatEntTipoIdentificacion = objDatEntTipoIdentificacion;
	}

	public String getStrIdentificacion() {
		return strIdentificacion;
	}

	public void setStrIdentificacion(String strIdentificacion) {
		this.strIdentificacion = strIdentificacion;
	}

	public boolean isBooTerceroPresente() {
		return booTerceroPresente;
	}

	public void setBooTerceroPresente(
			boolean booDisponibleInformacionTerceroPresente) {
		this.booTerceroPresente = booDisponibleInformacionTerceroPresente;
	}	

	public boolean isBooActivaValidacionTerceroPeps() {
		return this.booActivaValidacionTerceroPeps;
	}

	public void setBooActivaValidacionTerceroPeps(
			boolean pBooActivaValidacionTerceroPeps) {
		this.booActivaValidacionTerceroPeps = pBooActivaValidacionTerceroPeps;
	}

	/**
	 * @method	getObjInfoTerceroCapturadaXDocumento
	 * 		  	Metodo get del atributo objInfoTerceroCapturadaXDocumento
	 * @return	Tercero
	 *		  	Valor del atributo objInfoTerceroCapturadaXDocumento devuelto
	 * @author	hector.cuenca
	 * @date  	26/05/2018
	 */
	public Tercero getObjInfoTerceroCapturadaXDocumento() {
		return objInfoTerceroCapturadaXDocumento;
	}

	/**
	 * @method	setObjInfoTerceroCapturadaXDocumento
	 * 		  	Metodo set del atributo objInfoTerceroCapturadaXDocumento
	 * @param	pObjInfoTerceroCapturadaXDocumento
	 * 			Valor que tomara el atributo objInfoTerceroCapturadaXDocumento
	 * @author	hector.cuenca
	 * @date	26/05/2018
	 */
	public void setObjInfoTerceroCapturadaXDocumento(
			Tercero pObjInfoTerceroCapturadaXDocumento) {
		this.objInfoTerceroCapturadaXDocumento = pObjInfoTerceroCapturadaXDocumento;
	}

	public boolean isBooTerceroNuevoRedExterna() {
		return booTerceroNuevoRedExterna;
	}

	public void setBooTerceroNuevoRedExterna(boolean booTerceroNuevoRedExterna) {
		this.booTerceroNuevoRedExterna = booTerceroNuevoRedExterna;
	}

	public boolean isBooRecargarTercero() {
		return booRecargarTercero;
	}

	public void setBooRecargarTercero(boolean booRecargarTercero) {
		this.booRecargarTercero = booRecargarTercero;
	}
	
		
	
}

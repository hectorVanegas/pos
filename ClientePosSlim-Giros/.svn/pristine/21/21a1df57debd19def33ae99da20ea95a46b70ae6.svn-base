package co.com.codesa.clienteposslimgiros.eventos.sesion;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import co.com.codesa.client.socketcliente.util.AdministradorPropiedades;
import co.com.codesa.clienteposslim.enumeraciones.EstadoAplicacionEnum;
import co.com.codesa.clienteposslim.formas.FormaLogin;
import co.com.codesa.clienteposslim.general.InformacionSession;
import co.com.codesa.clienteposslimexception.exceptions.ClientePosSlimGirosException;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosPruebas;
import co.com.codesa.clienteposslimgiros.enumeraciones.biometria.EnumTiposBiometriaCaja;
import co.com.codesa.clienteposslimgiros.enumeraciones.operaciones.EnumTiposOperaciones;
import co.com.codesa.clienteposslimgiros.enumeraciones.proveedorServicioProducto.EnumTiposServicios;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.caja.FormaAperturarCaja;
import co.com.codesa.clienteposslimgiros.formas.cambioContrasena.FormaCambioContrasena;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.principal.FormaInicioGiros;
import co.com.codesa.clienteposslimgiros.formas.sesion.FormaAutenticacion;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGiros;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.biometria.UtilWSQ;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.utilidades.integracion.libCajaMultiservicio.UtilIntegracionLibCajaMultiservicio;
import co.com.codesa.clienteposslimgiros.utilidades.mensajes.Mensaje;
import co.com.codesa.clienteposslimgiros.utilidades.proveedorServicioProducto.UtilProveedorServicioProductoGiros;
import co.com.codesa.clienteposslimgiros.utilidades.validaciones.ValidacionesBiometria;
import co.com.codesa.clienteposslimgiros.utilidades.validaciones.ValidacionesSuperCombo;
import co.com.codesa.clienteposslimgiros.vista.logica.ProveedorServiciosVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.TerceroVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.caja.CajaVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.impresion.TipoImpresion;
import co.com.codesa.clienteposslimgiros.vista.logica.sesion.CambiarContrasenaVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.sesion.SesionVistaLogica;
import co.com.codesa.codesawrapper.modelo.dominio.Producto2;
import co.com.codesa.codesawrapper.modelo.dominio.ProveedorServicioProducto;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DatoEntidad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.bnet.ProveedorServicioProductoGirosDTO;

/**
 * ****************************************************************.
 * @autor: Hector Q-en-K
 * @fecha: 09-mar-2015 
 * @descripcion: Clase encargada de controlar los eventos de la 
 * 				 frmAutenticacion de autenticacion al modulo de giros
 * 				 (FormaLoginGiros)
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class EventoFormaAutenticacion extends EventoAbstracto {

	/**
	 * @variable: intValorProgreso, valor referente y asociado a la 
	 * 			  barra de progreso
	 **/
	private int intValorProgreso;
	
	/**
	 * @variable: strNombreEstadoProgreso, variable que dispone del texto 
	 * 			  a imprimir en la etiqueta asociada a la barra de
	 * 			  progreso
	 **/
	private String strNombreEstadoProgreso;
	
	/**
	 * @variable: booProceso, bandera que identifica si el booProceso de 
	 * 			  autenticacion se encuentra ejecutando (true) o no
	 * 			  (false)
	 **/
	private boolean booProceso;
	
	/**
	 * @variable: booUsuarioDetectado, bandera que identifica si la 
	 * 			  credencial de usuario ya viene suministrada por el
	 * 			  sistema, o no, importante para anular la digitacion 
	 * 			  de la credencial de usuario al usuario final
	 **/
	private boolean booUsuarioDetectado;
	
	/**
	 * @variable booDesplegarProducto
	 * 			 Bandera que permite identificar si el proceso de autenticacion
  	 * 		  	 se ejecuta para exponer el producto de giros o se realiza por
  	 * 		  	 otros intereses, que no ameritan el despligue del producto de
  	 * 		  	 giros 
	 **/
	private boolean booDesplegarProducto;
	
	
	
	/**
  	 * ****************************************************************.
  	 * @metodo: EventoFormaAutenticacion (Constructor)
  	 * @descripcion: Constructor que ejecuta la inicializacion de valores 
  	 * 				 y ejecucion de comportamientos inicales requeridos 
  	 * 				 para el despliegue de sus acciones
  	 * @param pForma: referencia a la GUI de la cual se estan controlando 
  	 * 		  los eventos
  	 * @throws Exception: Controla, recupera y escala, cualquier tipo de 
  	 * 		   excepcion presentada 
  	 * @autor: Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EventoFormaAutenticacion(FormaGenerica pForma,
									boolean pBooDesplegarProducto) throws Exception{
		
		super(pForma);
		this.booProceso=false;
		this.booUsuarioDetectado=false;
		this.booDesplegarProducto = pBooDesplegarProducto;
	}	
	
	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma)throws Exception{
		
		String strUsuario;
		String strContrasena;
		
		this.configuracionCampos();
		
		strUsuario = (String)pArrObjParametrosForma[0];
		strContrasena = (String)pArrObjParametrosForma[1];
		
		if(super.getFrmForma().getFrmPadre()!=null){
			super.getFrmForma().getFrmPadre().setEnabled(false);
		}
		
		this.validarPrevioIngreso();
		
		this.activarIngresoInterno(strUsuario,
								   strContrasena);
	}
	
	@Override
	public void accionarVentanaDesplegada(WindowEvent pEvtWindowOpened) throws Exception {
		
		this.castFrmAutenticacion().getTxtUsuario().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmAutenticacion().getPfiContrasena().getLblObligatorio().aplicarObligatoriedad(true);
	}
	
	@Override
	public void accionarEjecucion(Component pComponent,
								  AWTEvent pEvtEjecucion) throws Exception {
		
		if(pComponent.equals(this.castFrmAutenticacion().getBtnIngresar()) ||
				pComponent.equals(this.castFrmAutenticacion().getPfiContrasena())){
			
			this.ingresar();
			
		}else if(pComponent.equals(this.castFrmAutenticacion().getBtnSalir())){
			
			if(super.getFrmForma().getFrmPadre()!=null){
				super.getFrmForma().getFrmPadre().setEnabled(true);
			}
			super.salir();
			
		}else{
			super.accionarEjecucion(pComponent,pEvtEjecucion);
		}
	}
	
	@Override
	public void accionarVentanaCerrada(WindowEvent pEvtWindowClosed)
			throws Exception {
		
		if(super.getObjUsuario().isAutenticado()){
		
			/*
			 * de no haberse llevado a cabo una autenticacion valida, se
			 * interrumpe el proceso elaborado por el evento, y conserva 
			 * el tab de accordion anterior al ejecutar el de giros 
			 */
			if(!super.getObjUsuario().isBooIngresoAppAutomatico()){
				
				CambiarContrasenaVistaLogica.getInstance().cambiarContrasenaSims(InformacionSession.getInstance().getLogin(), 
						InformacionSession.getInstance().getClaveUsuario(), 
						super.getObjUsuario().getLogin(), 
						InformacionSession.getInstance().getUsuPassSims(), 
						super.getObjUsuario().getClave());
			}
		}
		
		super.accionarVentanaCerrada(pEvtWindowClosed);
	}
	
	@Override
	public void accionarCerrandoVentana(WindowEvent pEvtWindowClosing) throws Exception {
		/**
		 * Se omite la funcionalidad del boton estandar de cerrar la forma, ya que esta opcion 
		 * se peude realizar desde el boton preparado en la forma para salir/cancelar/abortar el
		 * proceso, y la opcion estandar estaba repercutiendo en bloqueos de la aplicacion
		 */
	};
	
	/** 
	 * ********************************************************************
	 * @method 	validarPrevioIngreso
	 * 		   	Metodo que permite realizar unas validaciones previas al 
	 * 			ingreso a giros
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	6/05/2017
	 * *********************************************************************
	 */
	private void validarPrevioIngreso	()
			throws Exception
	{
		this.validarTokenD();
		this.validarTipoServicios();
	}
	
	/** 
	 * ********************************************************************
	 * @method 	validarTokenD
	 * 		   	Metodo que permite validar el token D (seguridad en tramas 
	 * 			de SIMS)
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	6/05/2017
	 * *********************************************************************
	 */
	private void validarTokenD	()
			throws Exception
	{
		String strTokenSeguridadSims;
		
		if	(	!(strTokenSeguridadSims = InformacionSession.getInstance().getTokenSeguridadSims()).matches(EnumExpresionesRegulares.TOKEN_D_SEGURIDAD_TRAMAS.getValor())	)
		{
			throw EnumMensajes.TOKEN_D_MAL_CONFIGURADO.generarExcepcion(EnumClasesMensaje.ERROR);
			
		}	else	{
			
			super.getObjUsuario().getEmpresa().setStrTokenDSeguridad(strTokenSeguridadSims);
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method 	validarTipoServicios
	 * 		   	Metodo que permite validar los tipoServicios equivalentes
	 * 			a las operaciones de venta que realiza el cajero, esto es
	 * 			ajeno a los servicios que el cajero presente asociado en su
	 * 			plan
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	6/05/2017
	 * *********************************************************************
	 */
	private void validarTipoServicios	()
			throws Exception
	{
		EnumTiposServicios[]	arrEnmTipoServiciosImplementados;
		EnumTiposServicios	enmTipoServicioImplementado;
		String[] arrStrTipoServiciosVentaSIMS;
		String strTipoServiciosVentaSIMS;
		//String strTipoServicioRecibidoVentaSIMS;
		//String strExpRegCantidadTipoServicios;
		//String strParametrosMalConfigurados;
		//String strListadoTipoServiciosImplementados;
		
		if	(		(strTipoServiciosVentaSIMS	=	InformacionSession.getInstance().getTipoServiciosVentaSims())!=null
				&&	!(strTipoServiciosVentaSIMS	=	strTipoServiciosVentaSIMS.trim()).isEmpty()
			)
		{
			arrEnmTipoServiciosImplementados	=	EnumTiposServicios.values();
			/*
			strExpRegCantidadTipoServicios	=	"(.+)(\\|(.+)){"+(arrEnmTipoServiciosImplementados.length-1)+"}";
			
			if	(	strTipoServiciosVentaSIMS.matches(strExpRegCantidadTipoServicios)	)
			{
			*/
				arrStrTipoServiciosVentaSIMS	=	strTipoServiciosVentaSIMS.split("\\|");
				
				//strListadoTipoServiciosImplementados	=	EnumTiposServicios.obtenerCadenaServiciosImplementados();
			
				//strParametrosMalConfigurados	=	"";
				
				//for	(	int i=0	;	i<arrStrTipoServiciosVentaSIMS.length	;	i++	)
				for	(	int i=0	;	i<arrEnmTipoServiciosImplementados.length	;	i++	)
				{
					//strTipoServicioRecibidoVentaSIMS	=	arrStrTipoServiciosVentaSIMS[i];
					enmTipoServicioImplementado	=	arrEnmTipoServiciosImplementados[i];
					
					/*
					if	(	strTipoServicioRecibidoVentaSIMS.matches(strListadoTipoServiciosImplementados)	)
					{
					*/
						//arrEnmTipoServiciosImplementados[i].setStrClaveNueva(strTipoServicioRecibidoVentaSIMS);
					enmTipoServicioImplementado.setStrClaveNueva(arrStrTipoServiciosVentaSIMS[i]);
					
					/*
					}	else	{
						
						strParametrosMalConfigurados	+=	arrEnmTipoServiciosImplementados[i].getStrNombreParametroEmpresaVentaSIMS()+", ";
					}
					*/
				}
				/*
				if	(	!strParametrosMalConfigurados.isEmpty()	)
				{
					strParametrosMalConfigurados	=	strParametrosMalConfigurados.replaceAll("(, )$", "");
					
					throw EnumMensajes.VALIDAR_CONFIGURACION_PARAMETROS_SISTEMA_TIPOSERVICIO.generarExcepcion	(	EnumClasesMensaje.ERROR,
																													strParametrosMalConfigurados
																												);
				}
				*/
			/*	
			}	else	{
				
				throw EnumMensajes.VALIDAR_PARAMETROS_SISTEMA_TIPOSERVICIO_PLSQL.generarExcepcion(EnumClasesMensaje.ERROR);
			}
			*/
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
		
		this.castFrmAutenticacion().getTxtUsuario().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_AUT_LOGIN_USUARIO.getValor());
		this.castFrmAutenticacion().getPfiContrasena().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_AUT_CONTRASENA_USUARIO.getValor());
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo activarIngresoInterno
  	 * 		   Metodo encargado de activar la peticion de ingreso de 
  	 * 		   manera interna, transparente para el usuario
  	 * @param pStrUsuario
  	 * 		  tipo de credencial para el proceso de autenticacion enviado 
  	 * 		  automaticamente desde InformacionSesionGiros  
  	 * @param pStrContrasena
  	 * 		  tipo de credencial para el proceso de autenticacion enviado 
  	 * 		  automaticamente desde InformacionSesionGiros
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void activarIngresoInterno	(	String pStrUsuario,
			   								String pStrContrasena
			   							) throws Exception{
		if	(		pStrUsuario	==	null 
				|| (pStrUsuario=pStrUsuario.trim()).isEmpty()
				||	pStrUsuario.equals("*")
			)
		{
			pStrUsuario="";

		}	else	{

			this.setBooUsuarioDetectado(true);
		}

		if	(		pStrContrasena	==	null 
				|| (pStrContrasena=pStrContrasena.trim()).isEmpty()
				||	pStrContrasena.equals("*")
			)
		{
			pStrContrasena="";
		}

		this.castFrmAutenticacion().getTxtUsuario().setText(pStrUsuario);
		this.castFrmAutenticacion().getPfiContrasena().setText(pStrContrasena);

		this.ingresar();
	}
	
	@Override
	public void controlExcepcion(Exception e){
		
		if(!super.getFrmForma().isVisible() &&
				!super.getObjUsuario().isAutenticado()){
			
			if(super.getObjUsuario().isRequiereBiometria()){//con biometria
				
				super.controlExcepcion(e);
				
			}else{//sin biometria
				
				super.getFrmForma().setBooVisible(true);
			}
			
		}else{
			
			super.controlExcepcion(e);
			
			this.validarCaducidadContrasena(e);
			
			this.castFrmAutenticacion().getPfiContrasena().setText("");
		}
	}
	
	private void validarCaducidadContrasena(Exception e){
		
		FormaCambioContrasena frmCambioContrasena;
		Mensaje objMensaje;
		
		try{
		
			if(e instanceof ClientePosSlimGirosException){
				
				objMensaje = (Mensaje)((ClientePosSlimGirosException)e).getObjMensaje();
				
				if(objMensaje.getCodigo().equals(EnumMensajes.CONTRASENA_HA_CADUCADO.getCodigo())){
					
					frmCambioContrasena = new FormaCambioContrasena(super.getFrmForma(), 
																	true,
																	super.getObjUsuario().getClave());
					
					if(frmCambioContrasena.getEnmBotEncAccionSolicitada().equals(EnumBotonesEncabezado.BTNGUARDAR)){
						
						this.castFrmAutenticacion().getPfiContrasena().setText(super.getObjUsuario().getClave());
						this.autenticar();
					}
				}
			}
		
		}catch(Exception e1){
			super.controlExcepcion(e1);
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo ingresar
  	 * 		   Metodo que despliega la gestion del booProceso de 
  	 * 		   autenticacion
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void ingresar() throws Exception{
		
		this.booProceso = true;
		this.intValorProgreso=0;
		this.strNombreEstadoProgreso = "";
		
		if(super.getFrmForma().isVisible()){
			this.activarBarraProgresoAutenticacion();
		}
		
		this.validarHiloAutenticacion(super.getFrmForma().isVisible());
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo validarHiloAutenticacion
  	 * 		   Metodo que realiza la validacion si es requerido desplegar 
  	 * 		   el booProceso de autenticacion como un hilo o secuencial
  	 * @param activarHilo
  	 * 		  bandera que permite identificar si el proceso de 
  	 * 		  autenticacion es requerido ejecutarlo como un proceso 
  	 * 		  paralelo (hilo), o de manera secuencial, importante para 
  	 * 		  cuando la frmAutenticacion de autenticacion este visible o 
  	 * 		  no, por motivos de exponer la barra de progreso
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void validarHiloAutenticacion(boolean activarHilo) throws Exception{
		
		if(activarHilo){
			
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					autenticar();
				}
			}).start();
			
		}else{
			this.autenticar();
		}
		
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo autenticar
  	 * 		   Metodo que realiza el booProceso de autenticacion
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void autenticar(){
		
		Usuario objUsuarioSolicitante = null;
		
		try{
		
			objUsuarioSolicitante = super.getObjUsuario();
			
			try{
				
				this.habilitarCampos(false);
				
				this.actualizarInfoBarraProgreso(10,
												 EnumEtiquetas.LBL_AUT_BARRA_PROGRESO_VALIDACION_ENTRADA.toString());
				
				this.validarCamposInicioSesion(objUsuarioSolicitante);
				
				if(FormaLogin.estadoAplicacion.equals(EstadoAplicacionEnum.DESARROLLO)
						&& EnumParametrosPruebas.PRU_INT_ACTIVA_BIOMETRIA_USUARIO.getPropiedad().equalsIgnoreCase("N")){
					
					objUsuarioSolicitante.setRequiereBiometria(false);
					this.actualizarInfoBarraProgreso(25,
							 EnumEtiquetas.LBL_AUT_BARRA_PROGRESO_SESSION.toString());

					SesionVistaLogica.getInstance().iniciarSession(objUsuarioSolicitante);
				}	else	{
					
					this.actualizarInfoBarraProgreso(25,
													 EnumEtiquetas.LBL_AUT_BARRA_PROGRESO_VALIDA_BIOMETRIA.toString());
					
					if	(	EnumTiposBiometriaCaja.MULTISERVICIO.equals(CajaVistaLogica.getInstance ().consultarTipoBiometriaCaja ( objUsuarioSolicitante ))	)
					{
						this.actualizarInfoBarraProgreso(25,
								 EnumEtiquetas.LBL_AUT_BARRA_PROGRESO_SESSION.toString());

						SesionVistaLogica.getInstance().iniciarSession(objUsuarioSolicitante);
						
						objUsuarioSolicitante.setRequiereBiometria(false);
						TerceroVistaLogica.getInstance ().consultarTerceroUsuario ( objUsuarioSolicitante );
						
						this.actualizarInfoBarraProgreso(25,
								 						 EnumEtiquetas.LBL_AUT_BARRA_PROGRESO_SESSION_BIOMETRIA.toString());
						
						boolean booRespuesta	=	UtilIntegracionLibCajaMultiservicio.getInstance().procesarTerceroXCajaMultiservicio	(	objUsuarioSolicitante.getObjTercero(),
																																			EnumTiposOperaciones.AUTENTICAR,
																																			"CAJERO",
																																			super.getFrmForma()
																																		);
						if	(	!booRespuesta	)
						{
							throw EnumMensajes.USUARIO_NO_SUPERO_VALIDACION_BIOMETRIA_MULTISERVICIO.generarExcepcion(EnumClasesMensaje.ERROR);
						}
						
					}	else	{
						SesionVistaLogica.getInstance().validaRequiereBiometria(super.getObjUsuario());
						
						if(objUsuarioSolicitante.isRequiereBiometria()){
							
							//requiere biometria
							this.actualizarInfoBarraProgreso(25,
															 EnumEtiquetas.LBL_AUT_BARRA_PROGRESO_SESSION_BIOMETRIA.toString());
							
							this.autenticarBiometria(objUsuarioSolicitante);
							
						}else{
							//no requiere biometria
			
							this.actualizarInfoBarraProgreso(25,
															 EnumEtiquetas.LBL_AUT_BARRA_PROGRESO_SESSION.toString());
						
							SesionVistaLogica.getInstance().iniciarSession(objUsuarioSolicitante);
						}
					}
				}
				
				/*
				if(FormaLogin.estadoAplicacion.equals(EstadoAplicacionEnum.DESARROLLO)
						&& EnumParametrosPruebas.PRU_INT_ACTIVA_BIOMETRIA_USUARIO.getPropiedad().equalsIgnoreCase("N")){
					
					objUsuarioSolicitante.setRequiereBiometria(false);
				}
				*/
				/*
				if(objUsuarioSolicitante.isRequiereBiometria()){
					
					//requiere biometria
					this.actualizarInfoBarraProgreso(25,
													 EnumEtiquetas.LBL_AUT_BARRA_PROGRESO_SESSION_BIOMETRIA.toString());
					
					this.autenticarBiometria(objUsuarioSolicitante);
					
				}else{
					//no requiere biometria
	
					this.actualizarInfoBarraProgreso(25,
													 EnumEtiquetas.LBL_AUT_BARRA_PROGRESO_SESSION.toString());
				
					SesionVistaLogica.getInstance().iniciarSession(objUsuarioSolicitante);
				}
				*/
				
				this.grabarAutenticacion(objUsuarioSolicitante);
			
			}catch(Exception e){
				objUsuarioSolicitante.setAutenticado(false);
				throw e;
			}
			
			if(this.booDesplegarProducto){
			
				this.actualizarInfoBarraProgreso(10,
						 						 EnumEtiquetas.LBL_AUT_BARRA_PROGRESO_VALIDA_SUPER_COMBO.toString());
				
				ValidacionesSuperCombo.getInstance().validarSuperCombo(null);//this.castFrmAutenticacion().getOwner()
				
				this.actualizarInfoBarraProgreso(20,
						 						 EnumEtiquetas.LBL_AUT_BARRA_PROGRESO_VALIDA_CAJA.toString());

				this.validarCaja();
				
				this.actualizarInfoBarraProgreso(9,
						 						 EnumEtiquetas.LBL_AUT_BARRA_PROGRESO_SESSION_EXITOSA.toString());
			}
			
		}catch(Exception e){
			
			this.habilitarCampos(true);					
			this.controlExcepcion(e);
			super.getFrmForma().setBooVisible(true);
			
		}finally{
			
			this.booProceso=false;
			
			if(objUsuarioSolicitante != null &&
					objUsuarioSolicitante.isAutenticado()){
				
				try {
					Mensaje objMensaje;
					objMensaje = SesionVistaLogica.getInstance().consultarUltimoInicioSesion(objUsuarioSolicitante);
					objMensaje.desplegarMensaje(this.getFrmForma());
				} catch (Exception e) {
					UtilidadesGiros.getInstance().controlExcepcion(e, super.getFrmForma(), false);
				}
				
				if(!objUsuarioSolicitante.getCaja().isAbierta()
						&& this.booDesplegarProducto){
					
					try{
					
						new FormaAperturarCaja(super.getFrmForma(), 
								   			   true);
					}catch(Exception e){
						
						this.controlExcepcion(e);
					}
				}
				
				if(super.getFrmForma().getFrmPadre()!=null){
					super.getFrmForma().getFrmPadre().setEnabled(true);
				}
				
				super.getFrmForma().dispose();
			}
		}
	}
	
	private void cargarProveedoresServicioGiros(Usuario pObjUsuarioAutenticado)throws Exception {

		ProveedorServicioProductoGirosDTO objProveedorServicioProductoGirosDTO = null;
		Tercero objTerceroConvenio;
		EnumTiposServicios enmTipoServicio;
		String strNitProveedor;
		String strCodigoServicio;
		String strClaveTipoServicio;
		String strCodigoProducto;

		if(InformacionSession.getInstance().getlProveedorServicioProductoGiros()==null ||
				InformacionSession.getInstance().getlProveedorServicioProductoGiros().isEmpty()){

			ProveedorServiciosVistaLogica proveedorServicioVistaLogica = new ProveedorServiciosVistaLogica();
			proveedorServicioVistaLogica.ejecutarProveedorServiciosVistaLogica();
			proveedorServicioVistaLogica=null;
		}

		if(InformacionSession.getInstance().getlProveedorServicioProductoGiros() != null 
				&& !InformacionSession.getInstance().getlProveedorServicioProductoGiros().isEmpty()){

			for(String strTipoServicioOriginal : InformacionSessionGiros.getInstance().getHmLstProveedorServicioProductoGiros().keySet()){
				
				for	(	ProveedorServicioProducto tmp : InformacionSessionGiros.getInstance().getHmLstProveedorServicioProductoGiros().get(strTipoServicioOriginal)	)
				{
					for	(	Producto2 prod : tmp.getServicioProductos().get(0).getProductos()	)
					{
						if	(		prod.getEquiGiroTpDoc()!=null 
								&& 	prod.getEquiGiroNit()!=null
							)
						{
							objTerceroConvenio	=	new Tercero	(	new DatoEntidad(prod.getEquiGiroTpDoc()),
																	prod.getEquiGiroNit()
																);
						}	else	{

							objTerceroConvenio = null;
						}
						
						strNitProveedor 		=	tmp.getNitProveedor();
						strCodigoServicio		=	tmp.getServicioProductos().get(0).getCodServicio();
						strClaveTipoServicio	=	tmp.getServicioProductos().get(0).getTipoServicio();
						strCodigoProducto		=	tmp.getServicioProductos().get(0).getProductos().get(0).getCodigo();
						
						enmTipoServicio = UtilProveedorServicioProductoGiros.getInstance().obtenerEnum(strTipoServicioOriginal);
								
						objProveedorServicioProductoGirosDTO = new ProveedorServicioProductoGirosDTO(	objTerceroConvenio, 
																										strNitProveedor, 
																										strCodigoServicio,
																										strTipoServicioOriginal,
																										strClaveTipoServicio,
																										strCodigoProducto,
																										enmTipoServicio.getStrIdReglaComision(),
																										enmTipoServicio.getEnmTipoOperacion().getEnmEtiDescripcion().toString().replaceAll("í", "i")
																									);

						pObjUsuarioAutenticado.adicionarProveedorServicioProducto(objProveedorServicioProductoGirosDTO);
					}
				}
			}
		}
	}

	/**
  	 * ****************************************************************
  	 * 
  	 * @metodo autenticarBiometria
  	 * 		   Metodo realizar el proceso de autenticacion con biometria
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	private void autenticarBiometria(Usuario pObjUsuarioSolicitante)throws Exception{
		
		EnumTiposBiometriaCaja enmTipoBiometriaCaja;
		int intContadorIntentoBiometria;
		String strHuella;
		
		strHuella = "";
		intContadorIntentoBiometria=0;
		
		while (intContadorIntentoBiometria <= EnumParametrosApp.INTENTOS_LECTURA_HUELLA_CAJERO.getValorEntero() 
					&& strHuella.length() < ValidacionesBiometria.getInstance().getIntMaxHuella()){
		
			EnumMensajes.desplegarMensajePersonalizado(super.getFrmForma(), 
													   EnumClasesMensaje.INFORMACION, 
													   null, 
													   AdministradorPropiedades.getMensaje(EnumParametrosApp.SOLICITAR_LEER_HUELLA.getValorPropiedad()));
			
			strHuella = ValidacionesBiometria.getInstance().capturarHuellaIso(EnumParametrosApp.SOLICITAR_LEER_HUELLA.getValorPropiedad());
			
			//if(intContadorIntentoBiometria>0){
				//strHuella = "464D5200203230000000012C0000012C019000C500C501000110572D408600128000406B00270300407E0043000040C500487500403C00579600408C005D7D00404300659B0040DF006FE3008106007AE5004047008CA2008047009E250040AD00A5680040D100A9D400405300AEAA00409000C0BD00409800C2C700406E00C6B80080DF00C8C90040CA00DCC00040FA00E5BD0040D000EA4300401C00EDBD00404F00EEC60040AE00EFB100409000F34300807D00F3D90080A1010D240040BA010DA10040E4011AAC0040C9011CA800408B011F8300407F012F7B00809201388E004097013D96008052013EE30040C301411C00406501476C0080350150650040560157710040B1015D980040490163F800806001697C00806A016A06004098016D140080A4017B13000000";
			//}
			
			
			if (strHuella.equals(EnumParametrosApp.DEDO_NO_DETECTADO.getValorPropiedad()) || strHuella.length() == 0) {
				
				if (intContadorIntentoBiometria < EnumParametrosApp.INTENTOS_LECTURA_HUELLA_CAJERO.getValorEntero()) {
					
					EnumMensajes.desplegarMensajePersonalizado(super.getFrmForma(), 
							   								   EnumClasesMensaje.INFORMACION, 
							   								   null, 
							   								   AdministradorPropiedades.getMensaje(EnumParametrosApp.NO_SE_LOGRO_DETECTAR_HUELLA.getValorPropiedad()));
					try {
						Thread.sleep(5000);	
					} catch (Exception e) {}
				}else{
					
					throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
															   		 EnumMensajes.BIO_ERROR_GENERAL.getCodigo(), 
															   		 AdministradorPropiedades.getMensaje(EnumParametrosApp.NO_SE_LOGRO_DETECTAR_HUELLA.getValorPropiedad()));
				}
			}else if (strHuella.equals(EnumParametrosApp.LECTOR_NO_DETECTADO.getValorPropiedad())) {
				
				if (intContadorIntentoBiometria < EnumParametrosApp.INTENTOS_LECTURA_HUELLA_CAJERO.getValorEntero()) {
					
					EnumMensajes.desplegarMensajePersonalizado(super.getFrmForma(), 
							   								   EnumClasesMensaje.INFORMACION, 
							   								   null, 
							   								   AdministradorPropiedades.getMensaje(EnumParametrosApp.NO_LOGRO_DETECTAR_LECTOR.getValorPropiedad()));
					
				}else {
					
					throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
															   EnumMensajes.BIO_ERROR_GENERAL.getCodigo(), 
															   AdministradorPropiedades.getMensaje(EnumParametrosApp.NO_LOGRO_DETECTAR_LECTOR.getValorPropiedad()));
				}
			}else if (strHuella.equals(EnumParametrosApp.CONEXION_AFIS_ERROR.getValorPropiedad())) {
				
				if (intContadorIntentoBiometria < EnumParametrosApp.INTENTOS_LECTURA_HUELLA_CAJERO.getValorEntero()) {
					
					EnumMensajes.desplegarMensajePersonalizado(super.getFrmForma(), 
							   								   EnumClasesMensaje.INFORMACION, 
							   								   null, 
							   								   AdministradorPropiedades.getMensaje(EnumParametrosApp.CONEXION_AFIS_ERROR.getValorPropiedad()));
				}else {
					
					throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
															   EnumMensajes.BIO_ERROR_GENERAL.getCodigo(), 
															   AdministradorPropiedades.getMensaje(EnumParametrosApp.CONEXION_AFIS_ERROR.getValorPropiedad()));
				}
			}else if (strHuella.length() > ValidacionesBiometria.getInstance().getIntMaxHuella()
					  && !strHuella.equals(EnumParametrosApp.ERROR_IMAGEN_NULA.getValorPropiedad())) {
				
				EnumMensajes.desplegarMensajePersonalizado(super.getFrmForma(), 
						   								   EnumClasesMensaje.INFORMACION, 
						   								   null, 
						   								   AdministradorPropiedades.getMensaje(EnumParametrosApp.CAPTURA_EXITOSA.getValorPropiedad()));
				
				enmTipoBiometriaCaja	=	CajaVistaLogica.getInstance ().consultarTipoBiometriaCaja ( pObjUsuarioSolicitante );
				
				if	(	EnumTiposBiometriaCaja.LOCAL.equals ( enmTipoBiometriaCaja )	)
				{
					pObjUsuarioSolicitante.setRequiereBiometria(false);
				}
				
				pObjUsuarioSolicitante.setStrHuella(strHuella);
				
				try{
				
					SesionVistaLogica.getInstance().iniciarSession(pObjUsuarioSolicitante);
					
					if	(	EnumTiposBiometriaCaja.LOCAL.equals ( enmTipoBiometriaCaja )	)
					{
						pObjUsuarioSolicitante.setAutenticado(false);
						//try{
							
							TerceroVistaLogica.getInstance ().consultarTerceroUsuario ( pObjUsuarioSolicitante );
							
							ValidacionesBiometria.getInstance ().validarBiometriaLocal 	(	pObjUsuarioSolicitante,
							                                                           	 	super.getFrmForma (),
							                                                           	 	pObjUsuarioSolicitante.getObjTercero (), 
							                                                           	 	strHuella
							                                                         	);
							pObjUsuarioSolicitante.setAutenticado(true);
						/*}catch(Exception e){
							pObjUsuarioSolicitante.setAutenticado(false);
							throw e;
						}*/
					}
				
				}catch(Exception e){
					if	(	intContadorIntentoBiometria < EnumParametrosApp.INTENTOS_LECTURA_HUELLA_CAJERO.getValorEntero()	)
					{
						super.controlExcepcion(e);
					}else{
						throw e;
					}
				}
				
			} else {
				if (intContadorIntentoBiometria < EnumParametrosApp.INTENTOS_LECTURA_HUELLA_CAJERO.getValorEntero()) {
					
					EnumMensajes.desplegarMensajePersonalizado(super.getFrmForma(), 
							   								   EnumClasesMensaje.INFORMACION, 
							   								   null, 
							   								   AdministradorPropiedades.getMensaje(EnumParametrosApp.LECTURA_HUELLA_ERR.getValorPropiedad()));
				}else{
					
					throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
															   EnumMensajes.BIO_ERROR_GENERAL.getCodigo(), 
															   AdministradorPropiedades.getMensaje(EnumParametrosApp.LECTURA_HUELLA_ERR.getValorPropiedad()));	
				}
				
			}
		
			intContadorIntentoBiometria+=1;
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo validarCaja 
  	 * 		   Metodo que despliega la validacion del estado de la
  	 * 		   caja, y modifica la disposicion del menu de 
  	 * 		   opciones segun si la caja esta abierta o cerrada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void validarCaja()throws Exception{
		
		try{
			
			CajaVistaLogica.getInstance().validaCaja(super.getObjUsuario(),
													 super.getObjUsuario().getAgencia(),
													 super.getObjUsuario().getCaja());
			
			//GeneralGirosVistaLogica.getInstance().procesarPermisosMenu(true);
			//dsalazar[PlayTech] consulte la version del producto giro
			SesionVistaLogica.getInstance().consultarVersionProductoGiros(super.getObjUsuario());
			
		}catch(Exception e){
			
			super.controlExcepcion(e);
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo habilitarCampos
  	 * 		   Metodo que realiza la habilitacion y disposicion de campos 
  	 * 		   a nivel de la frmAutenticacion con el objetivo de inhabilitar 
  	 * 		   cuando se ejecuta la peticion de ingreso y de habilitar 
  	 * 		   cuando sucede algun problema con la autenticacion y se deba 
  	 * 		   confirmar las credenciales; importante tener presente que la 
  	 * 	 	   credencial de usuario, no se debe permitir habilitar si ya 
  	 * 		   fue proporcionada como credencial equivalente
  	 * @param pBooHabilitar 
  	 * 		  bandera que identifica si los campos deben habilitarse o 
  	 * 		  deshabilitarse
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void habilitarCampos(boolean pBooHabilitar){
		
		if(this.booUsuarioDetectado){
			this.castFrmAutenticacion().getTxtUsuario().setEnabled(false);
		}else{
			this.castFrmAutenticacion().getTxtUsuario().setEnabled(pBooHabilitar);
		}
		
		this.castFrmAutenticacion().getPfiContrasena().setEnabled(pBooHabilitar);
		this.castFrmAutenticacion().getBtnIngresar().setEnabled(pBooHabilitar);
		this.castFrmAutenticacion().getBtnSalir().setEnabled(pBooHabilitar);
		this.castFrmAutenticacion().getPgbBarraProgreso().setVisible(!pBooHabilitar);
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo activarBarraProgresoAutenticacion
  	 * 		   Metodo que realiza la activacion de la barra de progreso 
  	 * 		   para la funcionalidad de autenticacion, mediante la 
  	 * 		   ejecucion de un hilo controlado y sincronizado con el 
  	 * 		   proceso de autenticacion 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void activarBarraProgresoAutenticacion(){
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				
				while (booProceso) {
					
					castFrmAutenticacion().getPgbBarraProgreso().setValue(intValorProgreso);
					castFrmAutenticacion().getLblEtiquetaProgreso().setText(strNombreEstadoProgreso);
					castFrmAutenticacion().getLblPorcentajeBarraProgreso().setText("[ "+intValorProgreso+" % ]");
					castFrmAutenticacion().repaint();
					
				}
				
				castFrmAutenticacion().getLblPorcentajeBarraProgreso().setText("");
				castFrmAutenticacion().getLblEtiquetaProgreso().setText("");
				
			}
		}).start();
		
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo actualizarInfoBarraProgreso
  	 * 		   Metodo que realiza la actualizacion de la informacion
  	 * 		   asociada a la barra de progreso, modificando progresivamente, 
  	 * 		   el valor y la etiqueta, conforme se va completando el 	
  	 * 		   proceso de autenticacion
  	 * @param pDouIncremento
  	 * 		  cantidad a incrementar el valor de progreso
  	 * @param pStrNombreEstadoProgreso
  	 * 		  mensaje con el que se etiquetara el progreso
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void actualizarInfoBarraProgreso(double pDouIncremento,
											 String pStrNombreEstadoProgreso) throws Exception{
		
		this.intValorProgreso += pDouIncremento;
		this.strNombreEstadoProgreso = pStrNombreEstadoProgreso;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo validarCamposInicioSesion 
  	 * 		   Metodo que realiza las validaciones iniciales sobre las 
  	 * 		   credenciales para el booProceso de autenticacion, como por 
  	 * 		   ejemplo temas de obligatoriedad
  	 * @param usuario 
  	 * 		  credencial de usuario ingresada ya sea de manera manual por 
  	 * 		  el usuario o a traves de las equivalencias
  	 * @param contrasena 
  	 * 		  credencial de contrasena, ingresada ya sea de manera maunal 
  	 * 		  por el usuario o a traves de las equivalencias
  	 * @param codigoValidacion	
  	 * 		  credencial de codigo de validacion, ingresada ya sea de manera 
  	 * 		  manual por el usuario o a traves de las equivalencias
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void validarCamposInicioSesion(Usuario pObjUsuarioSolicitante)throws Exception{
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmAutenticacion().getTxtUsuario(), 
																this.castFrmAutenticacion().getLblUsuario().getTextoOriginal(), 
																true, 
																true);
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmAutenticacion().getPfiContrasena(), 
																this.castFrmAutenticacion().getLblContrasena().getTextoOriginal(), 
																true, 
																true);
		
		pObjUsuarioSolicitante.setLogin(this.castFrmAutenticacion().getTxtUsuario().getText().toUpperCase());
		pObjUsuarioSolicitante.setClave(this.castFrmAutenticacion().getPfiContrasena().getText());
		pObjUsuarioSolicitante.setStrLoginGamble(InformacionSession.getInstance().getLogin());
		pObjUsuarioSolicitante.setStrDocumentoGamble(InformacionSession.getInstance().getDocumentoUsuario());
		pObjUsuarioSolicitante.getAgencia().setStrPuntoVenta(InformacionSession.getInstance().getPuntoVenta());
		pObjUsuarioSolicitante.getAgencia().setStrCodigoCentroCosto(InformacionSession.getInstance().getCodigoCentroCosto());
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo grabarAutenticacion
  	 * 		   Metodo que realiza el proceso de registrar el usuario
  	 * 		   autenticado con exito sobre la sesion de la aplicacion
  	 * @param pObjUsuarioAutenticado
  	 * 		  objeto usuario autenticado sobre el sistema SIMS
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void grabarAutenticacion(Usuario pObjUsuarioAutenticado)throws Exception{
		
		if(pObjUsuarioAutenticado!=null &&
				pObjUsuarioAutenticado.isAutenticado()){
			
			InformacionSessionGiros.getInstance().getMnbMenuCompleto().setVisible(true);
			
			if(!super.getFrmForma().isVisible()){
				//InformacionSessionGiros.getInstance().setLoginAutomatico(true);
				pObjUsuarioAutenticado.setBooIngresoAppAutomatico(true);
			}
			
			//Carga el archivo de propiedades de tipo de impresora TMU o MC - RMV
			TipoImpresion.getInstancia().getPropiedades();
			
			FormaInicioGiros.adicionarComunicado(EnumEtiquetas.LBL_CAJERO.getValor(true)+" "+pObjUsuarioAutenticado.getLogin() + " - "+pObjUsuarioAutenticado.getNombre(), true);
			FormaInicioGiros.adicionarComunicado(EnumEtiquetas.LBL_MODO_OPERACION.getValor(true)+" "+FormaLogin.estadoAplicacion.getTipoEstadoAplicacion(), false);
			
			this.cargarProveedoresServicioGiros(pObjUsuarioAutenticado);
			
			UtilWSQ.getInstance ().desplegarHiloTransmisorWSQ();
		}else{
			throw EnumMensajes.PROCESO_AUTENTICACION_INCOMPLETO.generarExcepcion(EnumClasesMensaje.ERROR);
		}
	}

	public FormaAutenticacion castFrmAutenticacion(){
		return (FormaAutenticacion)super.getFrmForma();
	}

	public int getIntValorProgreso() {
		return intValorProgreso;
	}

	public void setIntValorProgreso(int intValorProgreso) {
		this.intValorProgreso = intValorProgreso;
	}

	public String getStrNombreEstadoProgreso() {
		return strNombreEstadoProgreso;
	}

	public void setStrNombreEstadoProgreso(String strNombreEstadoProgreso) {
		this.strNombreEstadoProgreso = strNombreEstadoProgreso;
	}

	public boolean isBooProceso() {
		return booProceso;
	}

	public void setBooProceso(boolean booProceso) {
		this.booProceso = booProceso;
	}

	public boolean isBooUsuarioDetectado() {
		return booUsuarioDetectado;
	}

	public void setBooUsuarioDetectado(boolean booUsuarioDetectado) {
		this.booUsuarioDetectado = booUsuarioDetectado;
	}

	
	
}

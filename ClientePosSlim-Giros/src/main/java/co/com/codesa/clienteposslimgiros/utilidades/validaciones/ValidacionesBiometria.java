package co.com.codesa.clienteposslimgiros.utilidades.validaciones;

import java.util.Date;
import java.util.StringTokenizer;

import co.com.codesa.client.socketcliente.socket.SocketCliente;
import co.com.codesa.client.socketcliente.util.AdministradorPropiedades;
import co.com.codesa.clienteposslim.enumeraciones.EstadoAplicacionEnum;
import co.com.codesa.clienteposslim.formas.FormaLogin;
import co.com.codesa.clienteposslimexception.exceptions.ClientePosSlimGirosException;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosPruebas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.enumeraciones.biometria.EnumTiposBiometriaCaja;
import co.com.codesa.clienteposslimgiros.enumeraciones.operaciones.EnumTiposOperaciones;
import co.com.codesa.clienteposslimgiros.formas.biometria.FormaEnrolarTercero;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.mensajes.FormaMensajeAlerta;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.biometria.UtilBiometria;
import co.com.codesa.clienteposslimgiros.utilidades.biometria.UtilWSQ;
import co.com.codesa.clienteposslimgiros.utilidades.integracion.libCajaMultiservicio.UtilIntegracionLibCajaMultiservicio;
import co.com.codesa.clienteposslimgiros.utilidades.integracion.slimGiros.UtilIntegracionSlimGiros;
import co.com.codesa.clienteposslimgiros.utilidades.mensajes.Mensaje;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.clienteposslimgiros.vista.logica.TerceroVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.caja.CajaVistaLogica;
import co.com.codesa.codesawrapper.modelo.dominio.ParametroSistema;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;


/** 
 * ********************************************************************
 * @class  ValidacionesBiometria
 *		   Clase implementada con patron de diseño singleton, que 
 *	  	   permite acceder a las diferentes funcionalidades del proceso
 *		   de negocio de biometria
 * @author roberth.martinez
 * @date   29/04/2015
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class ValidacionesBiometria {
	

	/**
	 * @variable instancia 
	 *  		 atributo que vuelve estatico los accesos hacia las 
	 *           funciones que agrupa la clase de ValidacionesBiometria
	 */
	private static ValidacionesBiometria instancia;
	
	/**
	 * @variable intMaxHuella
	 * 			 longitud maxima de la huella
	 */
	private int intMaxHuella=0;
	/**
	 * @variable strIdentificacionTerceroValidado
	 * 			 identificacion del ultimo tercero que se valido 
	 * 	         biometricamente de forma exitosa, esto para no volver a 
	 *  		 validar un tercero que ya se valido previamente en la misma transaccion
	 */
	private String strIdentificacionTerceroValidado;
	
	/** 
	 * ********************************************************************
	 * @method ValidacionesBiometria
	 * 		   constructor de la clase ValidacionesBiometria sin parametros
	 * @author roberth.martinez
	 * @date   22/11/2016
	 * *********************************************************************
	 */
	private ValidacionesBiometria() {}
	
	
	/** 
	 * ********************************************************************
	 * @method getInstance
	 * 		   Metodo encargado de controlar e inicializar la  instancia de
	 * 		   la clase, para instanciarla una unica vez durante el 
	 *  	   ciclo de vida de la aplicacion (patron singleton)
	 * @return ValidacionesBiometria
	 * 		   Instancia de la clase
	 * @author roberth.martinez
	 * @date   25/10/2016
	 * *********************************************************************
	 */
	public static ValidacionesBiometria getInstance(){
		
		if(instancia==null){
			instancia = new ValidacionesBiometria();
		}
		
		return instancia;
	}
	
	
	/** 
	 * ********************************************************************
	 * @method validarBiometria
	 * 		   metodo utilizado para validar la solicitud de biometria
     * 		   al tercero, validado la agencia y el tipo de operacion que 
     * 	       se esta ejecutando
	 * @param  pTercero
	 * 		   objeto de tercero que se realizara las validaciones
	 * @param  pUsuario
	 * 		   objeto usuario de la aplicacion
	 * @param  pFrmGenerica
	 * 		   forma desde la cual se realiza la solicitud
	 * @param  pEnmTipoOperacion
	 * 		   Tipo de operacion que se esta ejecutando
	 * @return Boolean
	 * 		   bandera que indica como se valido la biometria, el valor 
	 * 		   null indica que se debe borrar el tercero validado
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author roberth.martinez
	 * @date   25/10/2016
	 * *********************************************************************
	 */
	public Boolean validarBiometria(Tercero pTercero, 
								    Usuario pUsuario, 
								 	FormaGenerica pFrmGenerica,
								 	EnumTiposOperaciones pEnmTipoOperacion) throws Exception{
		
		Boolean objBooResultado;
		
		objBooResultado = true;
		
		if (pTercero != null) {
			
			if(FormaLogin.estadoAplicacion.equals(EstadoAplicacionEnum.DESARROLLO)
					&& EnumParametrosPruebas.PRU_INT_ACTIVA_BIOMETRIA_TERCERO.getPropiedad().equalsIgnoreCase("N")){
				
				pTercero.getObjBiometria().setAgenciaRequiereBiometria(false);
				pTercero.getObjBiometria().setRequiereBiometria(false);
			}
			
			if (pTercero.getObjBiometria().isAgenciaRequiereBiometria()) {
				
				if (pEnmTipoOperacion.equals(EnumTiposOperaciones.ENVIO_FACTURACION)) {
					
					objBooResultado = this.validacionesTransaccionEnvio(pTercero, 
																	 pUsuario, 
																	 pFrmGenerica);
					if (!objBooResultado) {
						
						objBooResultado = null;
					}
					
				}else if (pEnmTipoOperacion.equals(EnumTiposOperaciones.PAGO_FACTURACION)) {
					
					objBooResultado = this.validacionesTransaccionPago(pTercero, 
																    pUsuario, 
																    pFrmGenerica);
					
					if (!objBooResultado && 
							pTercero.getDescripcion().equals(EnumParametrosApp.DESCRIPCION_TERCERO_APODERADO.getValorPropiedad())) {
						
						objBooResultado = null;
					}
				}else if	(		pEnmTipoOperacion.equals(EnumTiposOperaciones.SOLICITUD_CAMBIO_BENEFICIARIO)
								||	pEnmTipoOperacion.equals(EnumTiposOperaciones.SOLICITUD_ANULACION_GIRO)
							)
				{
					
					objBooResultado = this.validacionesSolicitudAutorizacion(pTercero, 
																	   pUsuario, 
																	   pFrmGenerica,
																	   pEnmTipoOperacion);
				}
			}
		}
		return objBooResultado;
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo validacionesCambioBeneficiario
     * 		   metodo utilizado para realizar validaciones de biometria
     * 		   al cambio de beneficiario
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */
	private boolean validacionesSolicitudAutorizacion(Tercero pTercero, 
			 				      	 			   Usuario pUsuario, 
			 				      	 			   FormaGenerica pFrmGenerica,
			 				      	 			   EnumTiposOperaciones pEnmTipoOperacion) throws Exception{
		boolean booRespuesta;
		
		booRespuesta = false;
		
		if	(	EnumTiposBiometriaCaja.MULTISERVICIO.equals(CajaVistaLogica.getInstance ().consultarTipoBiometriaCaja ( pUsuario ))	)
		{
			booRespuesta	=	UtilIntegracionLibCajaMultiservicio.getInstance().procesarTerceroXCajaMultiservicio	(	pTercero,
																														pEnmTipoOperacion,
																														"CLIENTE",
																														pFrmGenerica
																													);
		}	else	{
			if (pTercero.getObjBiometria().isRequiereBiometria()) {
				
				pTercero.getObjBiometria().setObjBooApto(true);
				/*
				EnumMensajes.BIO_TERCERO_VALIDAR_BIOMETRIA.desplegarMensaje(pFrmGenerica, 
																			EnumClasesMensaje.INFORMACION, 
																			pTercero.getDescripcion());
				*/
				booRespuesta = this.lecturaHuellaCambioBeneficiario(pTercero, pUsuario, pFrmGenerica);
			}
		}
		
		return booRespuesta;
	}
	
	
	
	/** 
	 * ********************************************************************
	 * @method validacionesTransaccionPago
	 * 		   metodo utilizado para realizar validaciones de biometria
     * 		   en la transaccion de pago de giro
	 * @param  pTercero
	 * 		   objeto tercero a verificar
	 * @param  pUsuario
	 *   	   objeto usuario de la aplicacion
	 * @param  pFrmGenerica
	 * 	       forma desde se invoca la funcionalidad
	 * @return boolean
	 * 		   bandera indicando si pasa la verificacion biometrica
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author roberth.martinez
	 * @date   25/10/2016
	 * *********************************************************************
	 */
	private boolean validacionesTransaccionPago(Tercero pTercero, 
			 				      	 			Usuario pUsuario, 
			 				      	 			FormaGenerica pFrmGenerica) throws Exception{
		boolean booRespuesta;
		FormaEnrolarTercero frmEnrolar;
		
		booRespuesta = false;
		
		if	(	EnumTiposBiometriaCaja.MULTISERVICIO.equals(CajaVistaLogica.getInstance ().consultarTipoBiometriaCaja ( pUsuario ))	)
		{
			booRespuesta	=	UtilIntegracionLibCajaMultiservicio.getInstance().procesarTerceroXCajaMultiservicio	(	pTercero,
																														EnumTiposOperaciones.PAGO_FACTURACION,
																														"CLIENTE",
																														pFrmGenerica
																													);
		}	else	{
		
			if (pTercero.getObjBiometria().isRequiereBiometria()) {
				
				pTercero.getObjBiometria().setObjBooApto(true);
				
				booRespuesta = this.lecturaHuellaPago(pTercero, pUsuario, pFrmGenerica);
				
			}else if (pTercero.getObjBiometria().getEstadoBiometria().equals(EnumParametrosApp.ESTADO_PENDIENTE_BIOMETRIA_TERCERO.getValorPropiedad()) &&
					  		!pTercero.getObjBiometria().isBooEnrolado()){
				
				if (pUsuario.getCajeroEnrolador() == null || pUsuario.getCajeroEnrolador().equals("S")) {
					//Si el tercero esta pendiente por enrolar y el cajero tiene rol de enrolar clientes, 
					// se muestra la forma de enrolar cliente
					pTercero.getObjBiometria().setObjBooApto(true);
					
					EnumMensajes.TERCERO_PROCESO_ENROLAR.desplegarMensaje(pFrmGenerica, 
						      											  EnumClasesMensaje.INFORMACION, 
						      											  pTercero.getDescripcion());
					
					frmEnrolar = new FormaEnrolarTercero(pFrmGenerica, 
														 true, 
														 pTercero);
					
					if (frmEnrolar.castEvaEnrolarTercero().isBooEnrolado()) {
						
						pTercero.getObjBiometria().setBooValidadoBiometricamente(true);
						pTercero.getObjBiometria().setBooEnrolado(true);// informar que el tercero fue enrolado exitosamente en la transaccion
						booRespuesta = true;
						
					}
				}else {
					if ( pTercero.getDescripcion().equals(EnumParametrosApp.DESCRIPCION_TERCERO_APODERADO.getValorPropiedad()) ){
						EnumMensajes.BIO_CAJERO_SIN_ROL_ENROLA_CLIENTE.desplegarMensaje(pFrmGenerica,EnumClasesMensaje.ERROR, pUsuario.getLogin() );
					} else{
						throw EnumMensajes.BIO_CAJERO_SIN_ROL_ENROLA_CLIENTE.generarExcepcion(	EnumClasesMensaje.ERROR, pUsuario.getLogin() );
					}					
				}
				
			}else {
				
				booRespuesta = true;
			}
		}
		
		return booRespuesta;
	}
	
	
	

	/** 
	 * ********************************************************************
	 * @method validacionesTransaccionEnvio
	 * 		   metodo utilizado para realizar validaciones de biometria
     * 		   en la transaccion de envio de giro
	 * @param  pTercero
	 * 		   objeto tercero a validar
	 * @param  pUsuario
	 * 		   objeto usuario de la aplicacion
	 * @param  pFrmGenerica
	 * 		   forma desde la que se invoca la funcionalidad
	 * @return boolean
	 * 		   bandera indica como la sale de la validacion biometrica,
	 * 		   true si requiere biometria y se captura una huella valida,
	 * 		   true si esta pendiente por enrolar yse enrola exotosamente 
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author roberth.martinez
	 * @date   22/11/2016
	 * *********************************************************************
	 */
	private boolean validacionesTransaccionEnvio(Tercero pTercero, 
			 				      	 			 Usuario pUsuario, 
			 				      	 			 FormaGenerica pFrmGenerica) throws Exception{
		boolean booRespuesta;
		FormaEnrolarTercero frmEnrolar;
		
		booRespuesta = true;
		
		if (!pTercero.getIdentificacion().equals(this.strIdentificacionTerceroValidado) &&
				!pTercero.isBloqueadoRiesgos()) {
			
			if	(	EnumTiposBiometriaCaja.MULTISERVICIO.equals(CajaVistaLogica.getInstance ().consultarTipoBiometriaCaja ( pUsuario ))	)
			{
				booRespuesta	=	UtilIntegracionLibCajaMultiservicio.getInstance().procesarTerceroXCajaMultiservicio	(	pTercero,
																															EnumTiposOperaciones.ENVIO_FACTURACION,
																															"CLIENTE",
																															pFrmGenerica
																														);
			}	else	{
			
				if (pTercero.getObjBiometria().isRequiereBiometria()) {
					
					pTercero.getObjBiometria().setObjBooApto(true);
					
					booRespuesta = this.lecturaHuellaEnv(pTercero, pUsuario, pFrmGenerica);
					
				}else if (pTercero.getObjBiometria().getEstadoBiometria().equals(EnumParametrosApp.ESTADO_PENDIENTE_BIOMETRIA_TERCERO.getValorPropiedad()) &&
							!pTercero.getObjBiometria().isBooEnrolado() ) {					
					
					if (pUsuario.getCajeroEnrolador() == null || pUsuario.getCajeroEnrolador().equals("S")) {
						pTercero.getObjBiometria().setObjBooApto(true);
						//Si el tercero esta pendiente por enrolar y el cajero tiene rol de enrolar clientes, 
						// se muestra la forma de enrolar cliente
						EnumMensajes.TERCERO_PROCESO_ENROLAR.desplegarMensaje(pFrmGenerica, 
																		      EnumClasesMensaje.INFORMACION, 
																		      pTercero.getDescripcion());
						
						frmEnrolar = new FormaEnrolarTercero(pFrmGenerica, 
															 true, 
															 pTercero);
						
						if (!frmEnrolar.castEvaEnrolarTercero().isBooEnrolado()) {
							
							booRespuesta = false;
							
						}else {
							
							pTercero.getObjBiometria().setBooValidadoBiometricamente(true);
							pTercero.getObjBiometria().setBooEnrolado(true);
							
						}						
					}else{
						booRespuesta = false;
						EnumMensajes.BIO_CAJERO_SIN_ROL_ENROLA_CLIENTE.desplegarMensaje(pFrmGenerica, 
																						EnumClasesMensaje.INFORMACION, 
																						pUsuario.getLogin());						
					}					
				}
			}
		}
		
		return booRespuesta;
	}
	
	
	
	
	/** 
	 * ********************************************************************
	 * @method lecturaHuellaEnv
	 * 		   metodo utilizado para realizar el ciclo de la lectura 
     * 		   de huella
	 * @param  pTercero
	 * 		   Objeto tercero a validar
	 * @param  pUsuario
	 *    	   objeto usuario de la aplicacion
	 * @param  pFrmGenerica
	 * 		   Forma desde donde se invoca la app
	 * @return boolean
	 * 		   bandera que indica como sale la lectura de huella
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   10/11/2016
	 * *********************************************************************
	 */
	private boolean lecturaHuellaEnv(Tercero pTercero, 
			 				      	 Usuario pUsuario, 
			 				      	 FormaGenerica pFrmGenerica) throws Exception{
		
		EnumTiposBiometriaCaja enmTipoBiometriaCaja;
		int intContadorIntentos;
		int intCantidadIntentosFallidos;
		int intCantidadIntentosFallidosBio;
		String strRepite;
		String strHuella;
		String strRespuesta;
		boolean booResultado;
		FormaMensajeAlerta fmrMensajeAlerta;
		
		strRespuesta = "";
		intCantidadIntentosFallidos = 0;
		intContadorIntentos = 0;
		intCantidadIntentosFallidosBio = pUsuario.getCantIntentosFallidosBiometria();
		strRepite = "S";
		booResultado = true;
		
		EnumMensajes.BIO_TERCERO_VALIDAR_BIOMETRIA.desplegarMensaje(pFrmGenerica, 
																	EnumClasesMensaje.INFORMACION, 
																	pTercero.getDescripcion());
		
		while (intContadorIntentos <= intCantidadIntentosFallidosBio && strRepite.equals("S")){
			
			EnumMensajes.desplegarMensajePersonalizado(pFrmGenerica, 
													   EnumClasesMensaje.INFORMACION, 
													   null, 
													   AdministradorPropiedades.getMensaje(EnumParametrosApp.SOLICITAR_LEER_HUELLA.getValorPropiedad()));
			
			strHuella = this.capturarHuellaIso(EnumParametrosApp.SOLICITAR_LEER_HUELLA.getValorPropiedad());
			
			if (strHuella.equals(EnumParametrosApp.DEDO_NO_DETECTADO.getValorPropiedad()) || strHuella.length() == 0) {

				fmrMensajeAlerta = EnumMensajes.BIO_NO_HUELLA_SIGUE_INTENTANDO.desplegarMensaje(pFrmGenerica, 
																			 					EnumClasesMensaje.CONFIRMACION);
				if (fmrMensajeAlerta.isOpcion()) {
					try {
						Thread.sleep(5000);	
					} catch (Exception e) {}
				}else{
					strRepite = "N";
					booResultado = false;
				}
				
			}else if (strHuella.equals(EnumParametrosApp.LECTOR_NO_DETECTADO.getValorPropiedad()) ||
						strHuella.equals(EnumParametrosApp.CONEXION_AFIS_ERROR.getValorPropiedad())) {
				
				fmrMensajeAlerta = EnumMensajes.BIO_NO_LECTOR_SIGUE_INTENTANDO.desplegarMensaje(pFrmGenerica, 
																			 					EnumClasesMensaje.CONFIRMACION);
				
				if (!fmrMensajeAlerta.isOpcion()) {
					strRepite = "N";
					booResultado = false;
				}
				
			}else if (strHuella.length() > this.getIntMaxHuella()
					  && !strHuella.equals(EnumParametrosApp.ERROR_IMAGEN_NULA.getValorPropiedad())) {
				
				EnumMensajes.desplegarMensajePersonalizado(pFrmGenerica, 
														   EnumClasesMensaje.INFORMACION, 
														   null, 
														   AdministradorPropiedades.getMensaje(EnumParametrosApp.CAPTURA_EXITOSA.getValorPropiedad()));
				
				enmTipoBiometriaCaja	=	CajaVistaLogica.getInstance ().consultarTipoBiometriaCaja ( pUsuario );
				
				intContadorIntentos += 1;
				intCantidadIntentosFallidos += 1;
				try {

					if (intCantidadIntentosFallidosBio == -1 ||
							intCantidadIntentosFallidos < intCantidadIntentosFallidosBio) {
						
						if	(	EnumTiposBiometriaCaja.LOCAL.equals ( enmTipoBiometriaCaja )	)
						{
							ValidacionesBiometria.getInstance ().validarBiometriaLocal 	(	pUsuario,
							                                                           	 	pFrmGenerica,
							                                                           	 	pTercero, 
							                                                           	 	strHuella
							                                                         	);
							strRespuesta = "OK";
						}	else	{
							strRespuesta = this.validaHuellaBiometriaTercero(pUsuario,
																			 pTercero, 
																			 strHuella, 
																			 "N", 
																			 "");
						}
						
					}else if (intCantidadIntentosFallidos >= intCantidadIntentosFallidosBio) {
						
						if	(	EnumTiposBiometriaCaja.LOCAL.equals ( enmTipoBiometriaCaja )	)
						{
							ValidacionesBiometria.getInstance ().validarBiometriaLocal 	(	pUsuario,
							                                                           	 	pFrmGenerica,
							                                                           	 	pTercero, 
							                                                           	 	strHuella
							                                                         	);
							strRespuesta = "OK";
						}	else	{
							strRespuesta = this.validaHuellaBiometriaTercero(pUsuario,
																			 pTercero, 
									 										 strHuella, 
									 										 "S", 
									 										 "");
						}
					}
					
				} catch (Exception e) {
					if (intCantidadIntentosFallidos < intCantidadIntentosFallidosBio)
					{
						UtilidadesGiros.getInstance().controlExcepcion(e, 
																	   pFrmGenerica);
					}else{
						strRespuesta = "OK";
					}
				}
				
				if (strRespuesta.equals("OK")) {
					
					strRepite = "N";
					intCantidadIntentosFallidos = 0;
					this.strIdentificacionTerceroValidado = pTercero.getIdentificacion();
					pTercero.getObjBiometria().setBooValidadoBiometricamente(true);
				}
				
			}else {
				
				EnumMensajes.desplegarMensajePersonalizado(pFrmGenerica, 
														   EnumClasesMensaje.INFORMACION, 
														   null, 
														   AdministradorPropiedades.getMensaje(EnumParametrosApp.LECTURA_HUELLA_ERR.getValorPropiedad()));
			}
			
			
		}
		return booResultado;
	}
	
	
	/** 
	 * ********************************************************************
	 * @method lecturaHuellaPago
	 * 		   metodo utilizado para realizar el ciclo de la lectura 
     * 		   de huella
	 * @param  pTercero
	 * 		   objeto tercero al que se le captura la huella
 	 * @param  pUsuario
 	 *         objeto usuario de la aplicacion
	 * @param  pFrmGenerica
	 * 		   forma desde la que se invoca el metodo
	 * @return boolean
	 * 		   bandera indica true si se captura una huella exitosa
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   30/11/2016
	 * @trazabilidad
	 * @cambio Se modifica el procedimiento de privado a publico para poder ser accedido desde la clase EventoFormaPagoGiro solucion ticket 485899
	 * @autor Jefferson Ruiz
	 * @fecha 03/09/2019
	 * *********************************************************************
	 */
	public boolean lecturaHuellaPago(Tercero pTercero, 
			 				      	 Usuario pUsuario, 
			 				      	 FormaGenerica pFrmGenerica) throws Exception{
		
		EnumTiposBiometriaCaja enmTipoBiometriaCaja;
		int intNumIntentosBiometria;
		int intContadorIntentos;
		String strHuella;
		String strRespuesta;
		boolean booResultado;
		Mensaje objMensaje;
		
		strRespuesta= "";
		strHuella = "";
		intContadorIntentos = 0;
		booResultado = false;
		UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.NUMERO_INTENTOS_AUTENTICACION_BIOMETRIA);
		intNumIntentosBiometria = EnumParametrosSistema.NUMERO_INTENTOS_AUTENTICACION_BIOMETRIA.obtenerValorEntero();
		
		EnumMensajes.BIO_TERCERO_VALIDAR_BIOMETRIA.desplegarMensaje(pFrmGenerica, 
																	EnumClasesMensaje.INFORMACION, 
																	pTercero.getDescripcion());
		
		do {
			try {
				intNumIntentosBiometria--;
				
				while (intContadorIntentos <= EnumParametrosApp.INTENTOS_LECTURA_HUELLA_CLIENTE.getValorEntero() 
						&& strHuella.length() < this.getIntMaxHuella()){
					
					EnumMensajes.desplegarMensajePersonalizado(pFrmGenerica, 
															   EnumClasesMensaje.INFORMACION, 
															   null, 
															   AdministradorPropiedades.getMensaje(EnumParametrosApp.SOLICITAR_LEER_HUELLA.getValorPropiedad()));
					
					strHuella = this.capturarHuellaIso(EnumParametrosApp.SOLICITAR_LEER_HUELLA.getValorPropiedad());
					
					if (strHuella.equals(EnumParametrosApp.DEDO_NO_DETECTADO.getValorPropiedad()) || strHuella.length() == 0) {

						EnumMensajes.desplegarMensajePersonalizado(pFrmGenerica, 
																   EnumClasesMensaje.INFORMACION, 
																   null, 
																   AdministradorPropiedades.getMensaje(EnumParametrosApp.NO_SE_LOGRO_DETECTAR_HUELLA.getValorPropiedad()));
						
						try {
							Thread.sleep(5000);	
						} catch (Exception e) {}
						
					}else if (strHuella.equals(EnumParametrosApp.LECTOR_NO_DETECTADO.getValorPropiedad())) {
						
						EnumMensajes.desplegarMensajePersonalizado(pFrmGenerica, 
																   EnumClasesMensaje.INFORMACION, 
																   null, 
																   AdministradorPropiedades.getMensaje(EnumParametrosApp.NO_LOGRO_DETECTAR_LECTOR.getValorPropiedad()));
						
					}else if (strHuella.length() > this.getIntMaxHuella()
							  && !strHuella.equals(EnumParametrosApp.ERROR_IMAGEN_NULA.getValorPropiedad())) {
						
						EnumMensajes.desplegarMensajePersonalizado(pFrmGenerica, 
																   EnumClasesMensaje.INFORMACION, 
																   null, 
																   AdministradorPropiedades.getMensaje(EnumParametrosApp.CAPTURA_EXITOSA.getValorPropiedad()));
						
						enmTipoBiometriaCaja	=	CajaVistaLogica.getInstance ().consultarTipoBiometriaCaja ( pUsuario );
						
						if	(	EnumTiposBiometriaCaja.LOCAL.equals ( enmTipoBiometriaCaja )	)
						{
							ValidacionesBiometria.getInstance ().validarBiometriaLocal 	(	pUsuario,
							                                                           	 	pFrmGenerica,
							                                                           	 	pTercero, 
							                                                           	 	strHuella
							                                                         	);
							strRespuesta="OK";
						}	else	{
							//try {
								
								strRespuesta = this.validaHuellaBiometriaTercero(pUsuario,
																				 pTercero, 
																				 strHuella, 
																				 "N", 
																				 EnumTiposOperaciones.PAGO_FACTURACION.getStrValorPropiedad());
									
							/*} catch (Exception e) {
								UtilidadesGiros.getInstance().controlExcepcion(e, 
																			   pFrmGenerica);
							}*/
						}
						
					}else if (strHuella.equals(EnumParametrosApp.CONEXION_AFIS_ERROR.getValorPropiedad())) {
						
						EnumMensajes.desplegarMensajePersonalizado(pFrmGenerica, 
															   	   EnumClasesMensaje.INFORMACION, 
															   	   null, 
															   	   AdministradorPropiedades.getMensaje(EnumParametrosApp.CONEXION_AFIS_ERROR.getValorPropiedad()));
					
					}else {
						
						EnumMensajes.desplegarMensajePersonalizado(pFrmGenerica, 
																   EnumClasesMensaje.INFORMACION, 
																   null, 
																   AdministradorPropiedades.getMensaje(EnumParametrosApp.LECTURA_HUELLA_ERR.getValorPropiedad()));
					}
					
					intContadorIntentos += 1;
				}
				break;
			} catch (ClientePosSlimGirosException cpge) {
				objMensaje = (Mensaje)cpge.getObjMensaje();
				
				if(objMensaje.getCodigo().equals(EnumMensajes.HUELLA_NO_CONICIDE_USUARIO.getCodigo())){
					UtilidadesGiros.getInstance().controlExcepcion(cpge, 
							   									   pFrmGenerica);
					strHuella = "";
				}else{
					UtilidadesGiros.getInstance().controlExcepcion(cpge, 
							   									   pFrmGenerica);
					break;
				}
			} catch (Exception e) {
				UtilidadesGiros.getInstance().controlExcepcion(e, 
						   									   pFrmGenerica);
				break;
			}
		} while (intNumIntentosBiometria>0);
		
		
		if (strRespuesta.equals("OK")) {
			booResultado = true;
			pTercero.getObjBiometria().setBooValidadoBiometricamente(true);
		}
		return booResultado;
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo lecturaHuellaCambioBeneficiario
     * 		   metodo utilizado para realizar el ciclo de la lectura 
     * 		   de huella
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */
	private boolean lecturaHuellaCambioBeneficiario(Tercero pTercero, 
			 				      	 				Usuario pUsuario, 
			 				      	 				FormaGenerica pFrmGenerica) throws Exception{
		
		EnumTiposBiometriaCaja enmTipoBiometriaCaja;
		int intContadorIntentos;
		String strHuella;
		boolean booResultado;
		
		strHuella = "";
		intContadorIntentos = 0;
		booResultado = false;
		
		EnumMensajes.BIO_TERCERO_VALIDAR_BIOMETRIA.desplegarMensaje(pFrmGenerica, 
																	EnumClasesMensaje.INFORMACION, 
																	pTercero.getDescripcion());
		
		EnumMensajes.BIO_SOLICITA_HUELLA_REMITENTE.desplegarMensaje(pFrmGenerica, 
																	EnumClasesMensaje.INFORMACION);
		
		while (intContadorIntentos <= EnumParametrosApp.INTENTOS_LECTURA_HUELLA_CLIENTE.getValorEntero() 
				&& strHuella.length() <this.getIntMaxHuella()){
			
			EnumMensajes.desplegarMensajePersonalizado(pFrmGenerica, 
													   EnumClasesMensaje.INFORMACION, 
													   null, 
													   AdministradorPropiedades.getMensaje(EnumParametrosApp.SOLICITAR_LEER_HUELLA.getValorPropiedad()));
			
			strHuella = this.capturarHuellaIso(EnumParametrosApp.SOLICITAR_LEER_HUELLA.getValorPropiedad());
			
			if (strHuella.equals(EnumParametrosApp.DEDO_NO_DETECTADO.getValorPropiedad()) || 
					strHuella.length() == 0) {

				EnumMensajes.desplegarMensajePersonalizado(pFrmGenerica, 
														   EnumClasesMensaje.INFORMACION, 
														   null, 
														   AdministradorPropiedades.getMensaje(EnumParametrosApp.NO_SE_LOGRO_DETECTAR_HUELLA.getValorPropiedad()));
				try {
					Thread.sleep(5000);	
				} catch (Exception e) {}
				
			}else if (strHuella.equals(EnumParametrosApp.LECTOR_NO_DETECTADO.getValorPropiedad()) ||
						strHuella.equals(EnumParametrosApp.CONEXION_AFIS_ERROR.getValorPropiedad())) {
				
				EnumMensajes.desplegarMensajePersonalizado(pFrmGenerica, 
														   EnumClasesMensaje.INFORMACION, 
														   null, 
														   AdministradorPropiedades.getMensaje(EnumParametrosApp.NO_LOGRO_DETECTAR_LECTOR.getValorPropiedad()));
				
			}else if (strHuella.length() > this.getIntMaxHuella()
					  && !strHuella.equals(EnumParametrosApp.ERROR_IMAGEN_NULA.getValorPropiedad())) {
				
				//booResultado = true;
				pTercero.getObjBiometria().setBooValidadoBiometricamente(true);
				pTercero.getObjBiometria().gestionarHuellaDerecha().setStrIso(strHuella);
				EnumMensajes.desplegarMensajePersonalizado(pFrmGenerica, 
														   EnumClasesMensaje.INFORMACION, 
														   null, 
														   AdministradorPropiedades.getMensaje(EnumParametrosApp.CAPTURA_EXITOSA.getValorPropiedad()));
				
				enmTipoBiometriaCaja	=	CajaVistaLogica.getInstance ().consultarTipoBiometriaCaja ( pUsuario );
				
				if	(	EnumTiposBiometriaCaja.LOCAL.equals ( enmTipoBiometriaCaja )	)
				{
					ValidacionesBiometria.getInstance ().validarBiometriaLocal 	(	pUsuario,
					                                                           	 	pFrmGenerica,
					                                                           	 	pTercero, 
					                                                           	 	pTercero.getObjBiometria().getHuellaDerecha ().getStrIso ()
					                                                         	);
					booResultado = true;
				}	else	{
					booResultado = true;
				}
				
			}else {
				
				EnumMensajes.desplegarMensajePersonalizado(pFrmGenerica, 
														   EnumClasesMensaje.INFORMACION, 
														   null, 
														   AdministradorPropiedades.getMensaje(EnumParametrosApp.LECTURA_HUELLA_ERR.getValorPropiedad()));
			}
			
			intContadorIntentos += 1;
		}
		
		return booResultado;
	}

	
	/** 
	 * ********************************************************************
	 * @method validaHuellaBiometriaTercero
	 * 		   metodo utilizado para realizar el llamado a tercero 
     * 		   vista logica al metodo validaHuellaBiometriaTercero
	 * @param  pObjUsuario
	 * 		   objeto usuario de a aplicacion
	 * @param  pTercero
	 * 		   objeto tercero a validar
	 * @param  pStrhuella
	 * 		   huella del tercero a validar
	 * @param  pStrBloqueado
	 * 		   indicador de la bandera del  1 2 3, S o N dependiendo el 
	 * 		   intento que se esta ejecutando 
	 * @param  pStrAccion
	 * 		   accion
	 * @return String
	 * 	       Respuesta de la trama enviada
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   12/11/2016
	 * *********************************************************************
	 */
	private String validaHuellaBiometriaTercero(Usuario pObjUsuario,
												Tercero pTercero,
											  	String pStrhuella,
											  	String pStrBloqueado,
											  	String pStrAccion) throws Exception{
		
		String strRespuesta;
		
		pTercero.getObjBiometria().gestionarHuellaDerecha().setStrIso(pStrhuella);
		
		strRespuesta = TerceroVistaLogica.getInstance().validaHuellaBiometriaTercero(pObjUsuario,
																					 pTercero,
																					 pStrBloqueado, 
																					 pStrAccion);
		
		return strRespuesta;
	}
	
	
	/** 
	 * ********************************************************************
	 * @method capturarHuellaIso
	 * 		   metodo para capturar el ISO de la huella
	 * @param  strMsn
	 * 		   msn
	 * @return String
	 *		   Iso de la huella 		
	 * @author roberth.martinez
	 * @date   12/11/2016
	 * *********************************************************************
	 */
	public String capturarHuellaIso(String strMsn) {
		String strCapturaHuella = "";
		String strISO = "";
		String strCalidad;
		try {
			strCapturaHuella = SocketCliente.socket_APP_LED_CaptureHuella();
		} catch (Exception e) {
			strCapturaHuella = EnumParametrosApp.CONEXION_AFIS_ERROR.getValorPropiedad();
		}
		
		if (strCapturaHuella != null) {
			
			if (!strCapturaHuella.equals(EnumParametrosApp.DEDO_NO_DETECTADO.getValorPropiedad())
				&& !strCapturaHuella.equals(EnumParametrosApp.LECTOR_NO_DETECTADO.getValorPropiedad())
				&& !strCapturaHuella.equals(EnumParametrosApp.CONEXION_AFIS_ERROR.getValorPropiedad())
				&& !strCapturaHuella.equals(EnumParametrosApp.BIO_FALLIDA.getValorPropiedad())) {
				
				strCapturaHuella = strCapturaHuella.replaceAll("<", "");
				strCapturaHuella = strCapturaHuella.replaceAll(">", "");
				StringTokenizer stk = new StringTokenizer(strCapturaHuella, "|");
				
				if (stk.hasMoreElements()) {
					
					try {
						strISO = stk.nextToken();
						strCalidad = stk.nextToken();
					} catch (Exception e) {
						strCalidad = EnumParametrosApp.BIO_LECTURA_FALLIDA.getValorPropiedad();
					}
					
					if (strCalidad.equals(EnumParametrosApp.BIO_LECTURA_BAJA.getValorPropiedad()) || 
							strCalidad.equals(EnumParametrosApp.BIO_LECTURA_FALLIDA.getValorPropiedad())) {
						
						strISO = EnumParametrosApp.DEDO_NO_DETECTADO.getValorPropiedad();
						
					}
				}
			} else {
				strISO = strCapturaHuella;
			}
		}else{
			strISO = EnumParametrosApp.DEDO_NO_DETECTADO.getValorPropiedad();
		}
		
		return strISO;
	}

	
	/** 
	 * ********************************************************************
	 * @method getIntMaxHuella
	 * 		   obtiene mediante un parametro de sistema la longitud 
     * 		   maxima de una huella
	 * @return int
	 * 		   longitud maxima de huella
	 * @author roberth.martinez
	 * @date   22/11/2016
	 * *********************************************************************
	 */
	public int getIntMaxHuella() {
		boolean booValidTamHuella;
		
		if (this.intMaxHuella==0) {
			booValidTamHuella=true;
			try {
				ParametroSistema objParametro;
				objParametro = UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.LONGITUG_MAXIMA_HUELLA);
				this.intMaxHuella = Integer.parseInt(objParametro.getValor());
			} catch (Exception e) {
				booValidTamHuella=false;
			}
			if (!booValidTamHuella || this.intMaxHuella<=0) {
				try {
					this.intMaxHuella = EnumParametrosApp.BIO_LONGITUD_MAX_HUELLA_DEFECTO.getValorEntero();
				} catch (Exception e) {
					this.intMaxHuella = 180;
				}
			}
		}
		return this.intMaxHuella;
	}

	/**
	 * @method setIntMaxHuella
	 * 		   Metodo set del atributo intMaxHuella
	 * @param  intMaxHuella
	 *		   Valor que tomara el atributo intMaxHuella
	 * @author roberth.martinez
	 * @date   22/11/2016
	 */
	public void setIntMaxHuella(int intMaxHuella) {
		this.intMaxHuella = intMaxHuella;
	}

	/** 
	 * ********************************************************************
	 * @method capturarHuella
	 * 		   metodo utilizado para capturar huella
	 * @param  strMsn
	 * 		   mensaje que indica si se solicita huella derecha o izquierda
	 * @param  pTercero
	 * 		   objeto tercero al que se le captura la huella
	 * @return String
	 * 		   iso huella capturada
	 * @author roberth.martinez
	 * @date   12/11/2016
	 * *********************************************************************
	 */
	public String capturarHuella(String strMsn,
								 Tercero pTercero) {
		String strCapturaHuella;
		String strISO;
		String strCapturaPrimerCaracter;
		String strCalidad;	
		
		strISO = "";
		
		strCapturaHuella = SocketCliente.socket_APP_LED_WSQ_ISO();
		
		if (strCapturaHuella.length() > this.getIntMaxHuella()) {
			strCapturaHuella = strCapturaHuella.replaceAll("<", "");
			strCapturaHuella = strCapturaHuella.replaceAll(">", "");
			String strString = strCapturaHuella;
			
			//strString.substring(3);		
			
			strCapturaPrimerCaracter = strString.substring(1,1);
			
			if (!strCapturaPrimerCaracter.equals("|")) {

				StringTokenizer stk = new StringTokenizer(strCapturaHuella, "|");
				if (stk.hasMoreElements()) {
					String strWsq = stk.nextToken();
					if (stk.hasMoreElements()) {
						strISO = stk.nextToken();
						if (stk.hasMoreElements()) {
							strCalidad = stk.nextToken();	
						}else {
							strCalidad = EnumParametrosApp.BIO_LECTURA_FALLIDA.getValorPropiedad();
						}
					}else {
						strCalidad = EnumParametrosApp.BIO_LECTURA_FALLIDA.getValorPropiedad();
					}
					
					

					if (strMsn.equals(EnumParametrosApp.SOLICITAR_LEER_HUELLA_DER.getValorPropiedad())) {
						
						pTercero.getObjBiometria().gestionarHuellaDerecha().setStrWsq(strWsq);
						pTercero.getObjBiometria().gestionarHuellaDerecha().setStrIso(strISO);
						

					} else if (strMsn.equals(EnumParametrosApp.SOLICITAR_LEER_HUELLA_IZQ.getValorPropiedad())) {
						
						pTercero.getObjBiometria().gestionarHuellaIzquierda().setStrWsq(strWsq);
						pTercero.getObjBiometria().gestionarHuellaIzquierda().setStrIso(strISO);
						
					} else if (strMsn.equals(EnumParametrosApp.SOLICITAR_LEER_HUELLA.getValorPropiedad())) {
						
						pTercero.getObjBiometria().gestionarHuellaCapturada().setStrWsq(strWsq);
						pTercero.getObjBiometria().gestionarHuellaCapturada().setStrIso(strISO);
					}

					if (strCalidad.equals(EnumParametrosApp.BIO_LECTURA_BAJA.getValorPropiedad())) {
						strISO = EnumParametrosApp.BIO_HUELLA_CALIDAD_BAJA.getValorPropiedad();
					}
					
					if (strCalidad.equals(EnumParametrosApp.BIO_LECTURA_FALLIDA.getValorPropiedad())){
						strISO = EnumParametrosApp.BIO_HUELLA_FALLIDA.getValorPropiedad();
					}
					
				}
			} else {
				strISO = EnumParametrosApp.BIO_RESPUESTA_INCOMPLETA.getValorPropiedad();
			}
			
	     }else {
	    	 strISO =  strCapturaHuella;
	     }
		
		return strISO;
	}


	/**
	 * @method setStrIdentificacionTerceroValidado
	 * 		   Metodo set del atributo strIdentificacionTerceroValidado
	 * @param  strIdentificacionTerceroValidado
	 *		   Valor que tomara el atributo strIdentificacionTerceroValidado
	 * @author roberth.martinez
	 * @date   22/11/2016
	 */
	public void setStrIdentificacionTerceroValidado(
			String strIdentificacionTerceroValidado) {
		this.strIdentificacionTerceroValidado = strIdentificacionTerceroValidado;
	}
	
	/** 
	 * ********************************************************************
	 * @method	validarBiometriaLocal
	 * 		  	Metodo que permite validar y ejecutar la dinamica de 
	 * 			biometria local para un tercero
	 * @param	pObjTercero
	 * 			Tercero involucrado en la operacion
	 * @param 	pObjUsuario
	 * 			Usuario cajero que realiza la transaccion
	 * @param 	pFrmGenerica
	 * 			forma desde la cual se realiza la solicitud
	 * @param	pStrHuellaCapturada
	 * 			Huella capturada a traves de la funcionalidad de negocio y 
	 * 			sobre la cual se ejecutaran los procesos de validacion local 
	 * 			de biometria
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author	hector.cuenca
	 * @date	6/09/2017
	 * *********************************************************************
	 */
	public void validarBiometriaLocal(	Usuario pObjUsuario,
	                                  	FormaGenerica pFrmGenerica,
	                                  	Tercero pObjTercero,
	                                  	String pStrHuellaCapturada
									 ) 
			throws Exception
	{
		pObjTercero.getObjBiometria ().gestionarHuellaCapturada ().setStrIso ( pStrHuellaCapturada );
		
		if	(	pObjTercero.getObjBiometria ().getEstadoBiometria ().equals ( EnumParametrosApp.ESTADO_ENROLADO_BIOMETRIA_TERCERO.getValorPropiedad () )	)
		{
			this.validarBiometriaLocalTerceroEnrolado 	(	pObjUsuario,
			                                          	 	pFrmGenerica,
			                                          	 	pObjTercero
														);
			
		}	else if	(	pObjTercero.getObjBiometria ().getEstadoBiometria ().equals ( EnumParametrosApp.ESTADO_PENDIENTE_BIOMETRIA_TERCERO.getValorPropiedad () )	)
		{
			this.validarBiometriaLocalTerceroPendiente	(	pObjUsuario,
			                                          	 	pFrmGenerica,
			                                          	 	pObjTercero
			                                        	);
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	validarBiometriaLocalTerceroEnrolado
	 * 		  	Metodo que permite validar y ejecutar la dinamica de 
	 * 			biometria local para un tercero enrolado
	 * @param	pObjTercero
	 * 			Tercero involucrado en la operacion
	 * @param 	pObjUsuario
	 * 			Usuario cajero que realiza la transaccion
	 * @param 	pFrmGenerica
	 * 			forma desde la cual se realiza la solicitud
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author	hector.cuenca
	 * @date	6/09/2017
	 * *********************************************************************
	 */
	public void validarBiometriaLocalTerceroEnrolado(	Usuario pObjUsuario,
	                                                 	FormaGenerica pFrmGenerica,
	                                                 	Tercero pObjTercero
									 				) 
			throws Exception
	{
		String strRegIdHuellasLocal;
		
		/**
		 * Se consulta el IdHuellas localmente para el tercero en cuestion 
		 */
		
		strRegIdHuellasLocal = SocketCliente.socket_APP_LED_CONSULTAR_UID	(	pObjTercero.getTipoIdentificacion ().getId (), 
		                                                                 	 	pObjTercero.getIdentificacion ()
		                                                         			);
		
		//strRegIdHuellasLocal = "";
		if	(		strRegIdHuellasLocal	==	null
				||	strRegIdHuellasLocal.trim ().isEmpty ()
			)
		{
			/**
			 * Si el IdHuellas no existe localmente
			 */
			
			UtilBiometria.getInstance ().descargarHuellas	(	pObjUsuario, 
			                                             	 	pObjTercero 
															);
			UtilBiometria.getInstance ().enrolarLocal(	pObjUsuario, 
			                                          	pObjTercero 
			                                         );
			UtilBiometria.getInstance ().validarHuellaContraRegistroLocal	(	pObjUsuario, 
			                                                             	 	pObjTercero,
			                                                             	 	pObjTercero.getObjBiometria ().getHuellaCapturada ()
			                                              					);
		}	else	{
			/**
			 * Si el IdHuella existe localmente, es decir que el tercero ya se encuentra 
			 * registrado localmente
			 */
			
			if	(		!strRegIdHuellasLocal.equals ( pObjTercero.getObjBiometria ().getStrIdHuella () )
					||	!UtilBiometria.getInstance ().validarHuellaContraRegistroLocal	(	pObjUsuario, 
				  	 	                                                             	 	pObjTercero,
				  	 	                                                             	 	pObjTercero.getObjBiometria ().getHuellaCapturada ()
				                                              							)
				)
			{
				/**
				 * Si los IdHuellas no coinciden o su validacion de huella contra los registros locales
				 * no es satisfactoria
				 */
				
				UtilBiometria.getInstance ().descargarHuellas	(	pObjUsuario, 
				                                             	 	pObjTercero 
																);
				/**
				 * Se sobreescribe (borra y reemplaza) el registro de huellas local por
				 * las actualizadas desde el sistema central 
				 */
				
				SocketCliente.socket_APP_LED_DESENROLAR_LOCAL	(	pObjTercero.getTipoIdentificacion ().getId (), 
				                                             	 	pObjTercero.getIdentificacion (), 
				                                             	 	strRegIdHuellasLocal
                                                            	);
				
				
				UtilBiometria.getInstance ().enrolarLocal(	pObjUsuario, 
				                                          	pObjTercero 
				                                         );
				
				/**
				 * Insiste nuevamente la validacion de la huella contra los registros locales, al
				 * haber actualizado estos previamente
				 */
				if	(	!UtilBiometria.getInstance ().validarHuellaContraRegistroLocal	(	pObjUsuario, 
				  	 	                                                             	 	pObjTercero,
				  	 	                                                             	 	pObjTercero.getObjBiometria ().getHuellaCapturada ()
				                                              							)	
				    )
				{
					throw EnumMensajes.HUELLAS_TERCERO_NO_COINCIDEN_LOCALMENTE.generarExcepcion(	EnumClasesMensaje.ERROR	);
				}
			}
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	validarBiometriaLocalTerceroPendiente
	 * 		  	Metodo que permite validar y ejecutar la dinamica de 
	 * 			biometria local para un tercero pendiente por enrolar
	 * @param	pObjTercero
	 * 			Tercero involucrado en la operacion
	 * @param 	pObjUsuario
	 * 			Usuario cajero que realiza la transaccion
	 * @param 	pFrmGenerica
	 * 			forma desde la cual se realiza la solicitud
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author	hector.cuenca
	 * @date	6/09/2017
	 * *********************************************************************
	 */
	public void validarBiometriaLocalTerceroPendiente	(	Usuario pObjUsuario,
	                                                 	 	FormaGenerica pFrmGenerica,
	                                                 	 	Tercero pObjTercero
														) 
			throws Exception
	{
		String strRegIdHuellasLocal;
		
		try{
			
			pObjTercero.getObjBiometria ().setStrIdHuella ( UtilidadGiros.getInstancia ().getFORMATEADOR_FECHA_HORA_JUNTO ().format ( UtilIntegracionSlimGiros.getInstance().obtenerFechaHoraActualPosSlim() ) );
			
			UtilWSQ.getInstance ().crearArchivosWSQ ( pObjTercero );
			
			UtilBiometria.getInstance ().enviarHuellas 	(	pObjUsuario, 
			                                           	 	pObjTercero 
			                                       		);
			/**
			 * Se consulta el IdHuellas localmente para el tercero en cuestion 
			 */
			
			strRegIdHuellasLocal = SocketCliente.socket_APP_LED_CONSULTAR_UID	(	pObjTercero.getTipoIdentificacion ().getId (), 
			                                                                 	 	pObjTercero.getIdentificacion ()
	                                                                			);
			
			//strRegIdHuellasLocal = "";
			if	(		strRegIdHuellasLocal	!=	null
					&&	!strRegIdHuellasLocal.trim ().isEmpty ()
				)
			{
				SocketCliente.socket_APP_LED_DESENROLAR_LOCAL	(	pObjTercero.getTipoIdentificacion ().getId (), 
				                                             	 	pObjTercero.getIdentificacion (), 
				                                             	 	strRegIdHuellasLocal
																);
				
			}
			
			UtilBiometria.getInstance ().enrolarLocal(	pObjUsuario, 
			                                          	pObjTercero 
			                                         );
			
			UtilWSQ.getInstance ().finalizarArchivosWSQparaTransmision ( pObjTercero );
			
		}catch(Exception e)
		{
			UtilWSQ.getInstance ().eliminarArchivosWSQ ( pObjTercero );
			throw e;
		}
	}
}

package co.com.codesa.clienteposslimgiros.utilidades.biometria;

import java.util.Date;

import co.com.codesa.client.socketcliente.socket.SocketCliente;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.enumeraciones.biometria.EnumTiposBiometriaCaja;
import co.com.codesa.clienteposslimgiros.enumeraciones.operaciones.EnumTiposOperaciones;
import co.com.codesa.clienteposslimgiros.utilidades.integracion.slimGiros.UtilIntegracionSlimGiros;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.clienteposslimgiros.vista.logica.TerceroVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.biometria.BiometriaVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.caja.CajaVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.HuellaBiometria;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;


/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 14-abr-2017
 * @Clase UtilWSQ 
 * 		  Clase utilitaria relacionada con el objeto de negocio 
 * 		  concepto
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class UtilBiometria 
{
	/**
	 * @variable 	instancia 
	 * 				Referencia estatica de la clase utilitaria, clave para incorporar
	 * 			 	SINGLETON (patron de diseño)
	 **/
	private static UtilBiometria instancia;
	
	/**
  	 * ****************************************************************.
  	 * @metodo UtilWSQ
  	 * 		   Metodo constructor que permite inicializar variables y
  	 * 		   ejecutar comportamientos de interes
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private UtilBiometria() 
			throws Exception
	{}

	/**
  	 * ****************************************************************.
  	 * @metodo getInstance
  	 * 		   Metodo clave para ejecutar el patron singleton sobre la 
  	 * 		   clase, materializando esta por unica vez y manteniendo una 
  	 * 		   sola instancia de esta
  	 * @return UtilMediosPago
  	 * 		   Tipo referente a la misma clase
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public static UtilBiometria getInstance()throws Exception{
		
		if (instancia == null) {
			
			instancia = new UtilBiometria();
		}
		
		return instancia;
	}
	
	/** 
	 * ********************************************************************
	 * @method	enviarHuellas
	 * 		  	Metodo que permite emitir al sistema central las huellas ISO
	 * 			capturadas de forma local
	 * @param 	pObjUsuario
	 * 			Usuario cajero que realiza la transaccion
	 * @param 	pObjTercero
	 * 			Tercero al cual se le notificaran las huellas ISO
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	4/09/2017
	 * *********************************************************************
	 */
	public void enviarHuellas	(	Usuario pObjUsuario,
	                         	 	Tercero pObjTercero
								) 
			throws Exception
	{
		if	(		!BiometriaVistaLogica.getInstance ().emitirISO 	( pObjUsuario, 
		  	 		                                              	  pObjTercero, 
		  	 		                                              	  pObjTercero.getObjBiometria ().getHuellaDerecha () 
		                                            				)
		        ||	!BiometriaVistaLogica.getInstance ().emitirISO 	( pObjUsuario, 
		          	                                              	  pObjTercero, 
		          	                                              	  pObjTercero.getObjBiometria ().getHuellaIzquierda () 
		                                            				)
			)
		{
			UtilWSQ.getInstance ().eliminarArchivosWSQ ( pObjTercero );
			
			throw EnumMensajes.ERROR_ENVIANDO_HUELLAS_ISO_TERCERO.generarExcepcion(	EnumClasesMensaje.ERROR	);
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	descargarHuellas
	 * 		  	Metodo que permite solicitar al sistema central la descarga
	 * 			de las huellas ISO asociadas a un tercero
	 * @param 	pObjUsuario
	 * 			Usuario cajero que realiza la transaccion
	 * @param 	pObjTercero
	 * 			Tercero al cual se le descargaran las huellas ISO
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	4/09/2017
	 * *********************************************************************
	 */
	public void descargarHuellas(	Usuario pObjUsuario,
	                             	Tercero pObjTercero
	                            ) 
			throws Exception
	{
		if	(		!BiometriaVistaLogica.getInstance ().descargarISO(	pObjUsuario, 
		  	 		                                                 	pObjTercero, 
		  	 		                                                 	pObjTercero.getObjBiometria ().gestionarHuellaDerecha () 
		                                             				)
		        ||	!BiometriaVistaLogica.getInstance ().descargarISO(	pObjUsuario, 
		    		                                                  	pObjTercero, 
		    		                                                  	pObjTercero.getObjBiometria ().gestionarHuellaIzquierda () 
		    		                                             	)
		    )
		{
			throw EnumMensajes.ERROR_DESCARGANDO_HUELLAS_ISO_TERCERO.generarExcepcion(	EnumClasesMensaje.ERROR,
			                                                                          	pObjUsuario.getCaja ().getCodigo (),
			                                                                          	pObjUsuario.getCaja ().getDescripcion ()
			                                                                         );
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	enrolarLocal
	 * 		  	Metodo que permite realizar las operaciones de registro y/o
	 * 			enrolamiento a nivel local
	 * @param	pObjUsuario
	 * 			Usuario cajero que realiza la transaccion
	 * @param 	pObjTercero
	 * 			Tercero al cual se le esta realizando el proceso de enrolamiento
	 * 			local en el sistema
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	5/09/2017
	 * *********************************************************************
	 */
	public void enrolarLocal	(	Usuario pObjUsuario,
	                            	Tercero pObjTercero
	                         	) 
			throws Exception
	{
		String strResultadoAfisLocal;
		//String strRespuesta;
		Long lonTiempoInicial;
		
		lonTiempoInicial = System.currentTimeMillis();
		
		strResultadoAfisLocal = SocketCliente.socket_APP_LED_ENROLAR_USR_AFIS_LOCAL (	pObjTercero.getTipoIdentificacion ().getId (), 
		                                                                             	pObjTercero.getIdentificacion (), 
		                                                                             	pObjTercero.getObjBiometria ().getHuellaIzquierda ().getStrIso (), 
		                                                                             	pObjTercero.getObjBiometria ().getHuellaDerecha ().getStrIso (), 
		                                                                             	pObjTercero.getObjBiometria ().getStrIdHuella ()
		                                                                         	);
		
		//strResultadoAfisLocal = "";
		pObjTercero.getObjBiometria ().setStrTiempoRespuestaAfis ( String.valueOf ((System.currentTimeMillis() - lonTiempoInicial)) );
		pObjTercero.getObjBiometria ().setStrTiempoAfis ( UtilidadGiros.getInstancia ().getFORMATEADOR_FECHA_SLASH_COMPLETO ().format ( UtilIntegracionSlimGiros.getInstance().obtenerFechaHoraActualPosSlim() ) );
		
		this.validarRespuestaAfisLocal	(	strResultadoAfisLocal,
		                              	 	true,
		                              	 	false
		                              	);
		
		strResultadoAfisLocal = "IDVC_OK";
		pObjTercero.getObjBiometria ().setStrRespuestaAfis ( strResultadoAfisLocal );
		
		//strResultadoAfisLocal = "IDVC_OK";
		//pObjTercero.getObjBiometria ().setStrIdHuella (  );
		//setIdHuella(strRespuesta);// Si no viene ningun mensaje de error
									// entonces viene el ID del registro
		//strRespuesta = "El Tercero Fue Enrolado Exitosamente";// Enrolado OK
		
		//Factura.setRespuestAfis(resultadoAfisLocal);
	}
	
	/** 
	 * ********************************************************************
	 * @method	validarHuellaContraRegistroLocal
	 * 		  	Metodo que permite validar la huella capturada a traves de la
	 * 			funcionalidad contra el registro local existente
	 * @param 	pObjUsuario
	 * 			Usuario cajero que realiza la transaccion
	 * @param 	pObjTercero
	 * 			Tercero al cual se le esta realizando el proceso de validacion
	 * 			de huella a nivel local
	 * @param	pObjHuellaCapturada
	 * 			Huella capturada que se validara contra las registradas localmente
	 * 			para verificar su grado de coincidencia
	 * @return	boolean
	 * 			Bandera que identifica si la validacion de la huella capturada
	 * 			del tercero fue valida o no con el registro local, true y false
	 * 			respectivamente
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	8/09/2017
	 * *********************************************************************
	 */
	public boolean validarHuellaContraRegistroLocal	(	Usuario pObjUsuario,
	                                               	 	Tercero pObjTercero,
	                                               	 	HuellaBiometria pObjHuellaCapturada
	                              					) 
			throws Exception
	{
		String strResultadoAfisLocal;
		boolean booHuellaOk;
		
		strResultadoAfisLocal = SocketCliente.socket_APP_LED_VER_HUELLA_LOCAL	(	pObjTercero.getTipoIdentificacion ().getId (), 
		                                                                     	 	pObjTercero.getIdentificacion (), 
		                                                                     	 	pObjHuellaCapturada.getStrIso()
		                                                            			);
		
		//strResultadoAfisLocal="";
		this.validarRespuestaAfisLocal	(	strResultadoAfisLocal,
		                              	 	true,
		                              	 	true
		                              	);
		
		booHuellaOk	=	!strResultadoAfisLocal.substring(1, 1).equals("|");
		
		if	(	booHuellaOk	)
		{
			pObjTercero.getObjBiometria ().gestionarHuellaDerecha ().setStrScore ( strResultadoAfisLocal );
			/**
			 * Se ajusta la instruccion para proteger el valor q se tiene de la Iso trabajada, necesario para 
			 * que se pueda llevar a cabo la autorizacion directa de una solicitud, previo a una verificacion
			 * con biometria
			 */
			pObjTercero.getObjBiometria ().getHuellaDerecha ().setStrIso ( "" );//pObjHuellaCapturada.getStrIso()
			strResultadoAfisLocal	=	"IDVC_OK";
		}
		
		pObjTercero.getObjBiometria ().setStrRespuestaAfis ( strResultadoAfisLocal );
		
		return booHuellaOk;
	}
	
	/** 
	 * ********************************************************************
	 * @method	validarRespuestaAfisLocal
	 * 		  	Metodo que permite interpretar y validar las diferentes 
	 * 			respuestas que presenta el modulo de biometria local
	 * @param	pStrRespuestaAfisLocal
	 * 			Respuesta notificada por el modulo de biometria local
	 * @param 	pBooGenerarExcepcion
	 * 			Bandera que identifica si el error detectado como respuesta
	 * 			del modulo de biometria, debe provocar una excepcion al sistema
	 * 			o administrarlo con una bandera booleana, donde false se 
	 * 			identificara como una respuesta con error
	 * @param	pBooOperacionVerificaEnrola
	 * 			Bandera que permite identificar si la operacion solicitada al 
	 * 			modulo de biometria local, es con respecto a la verificacion
	 * 			o enrolamiento de un tercero, true y false respectivamente 
	 * @return	boolean
	 * 			Bandera que identifica el resultado de la validacion e 
	 * 			interpretacion de la respuesta del modulo de biometria local,
	 * 			para la operacion que se este contemplando
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	12/09/2017
	 * *********************************************************************
	 */
	private boolean validarRespuestaAfisLocal	(	String pStrRespuestaAfisLocal,
	                                            	boolean pBooGenerarExcepcion,
	                                            	boolean pBooOperacionVerificaEnrola
	                                        	) 
			throws Exception
	{
		Exception exDetectada;
		boolean booRespuestaValida;
		
		if	(	pStrRespuestaAfisLocal.equals("ERROR_FALTAN_PARAMETROS")	)
		{
			exDetectada	=	EnumMensajes.FALTAN_PARAMETROS_PARA_REALIZAR_OPERACION_AFIS.generarExcepcion(	EnumClasesMensaje.ERROR	);
			
		}	else if	(	pStrRespuestaAfisLocal.equals("ERROR_FORMATO")	) 
		{
			exDetectada	=	EnumMensajes.FORMATO_HUELLA_NO_VALIDA.generarExcepcion(	EnumClasesMensaje.ERROR	);
			
		}	else if	(		pStrRespuestaAfisLocal.equals("USUARIO_YA_EXISTE")
						||	pStrRespuestaAfisLocal.equals("USUARIO_YA_EXISTE_EN_BD_MEM")
					) 
		{
			exDetectada	=	EnumMensajes.HUELLA_YA_EXISTE_EN_SISTEMA.generarExcepcion(	EnumClasesMensaje.ERROR	);
			
		}	else if	(	pStrRespuestaAfisLocal.equals("ERROR_CNX_AFIS")	)
		{
			exDetectada	=	EnumMensajes.NO_HAY_COMUNICACION_CON_AFIS.generarExcepcion(	EnumClasesMensaje.ERROR	);
			
		}	else if	(	pStrRespuestaAfisLocal.equals("-1")	) 
		{
			exDetectada	=	pBooOperacionVerificaEnrola
								?	EnumMensajes.HUELLA_NO_CONICIDE_USUARIO.generarExcepcion	(	EnumClasesMensaje.ERROR	)
								:	EnumMensajes.ERROR_INSERTANDO.generarExcepcion	(	EnumClasesMensaje.ERROR,
					           	 	                                              	 	""
					                                              					);
		}	else	{
			exDetectada = null;
		}
		
		booRespuestaValida	=	exDetectada	==	null;
		
		if	(		pBooGenerarExcepcion
				&&	!booRespuestaValida
			)
		{
			throw exDetectada;
		}
		
		return booRespuestaValida;
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	registrarFirmaBiometricaBiometriaLocal
	 * 		  	Metodo encargado de registra la huella en el sistema
	 * 			con el fin de generar la firma biometrica para el 
	 * 			proceso de 
	 * @param pObjUsuario
	 * 			Usuario cajero que realiza la peticion
	 * @param pObjFactura
	 * 			Objeto factura usado en el proceso 			
	 * @param pEnumTipoOperacion
	 * 			Es el tipo de operacion que se esta efectuando
	 * @throws Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	stiven.garcia
	 * @date	30/05/2018
	 * *********************************************************************
	 */
	public void registrarFirmaBiometricaBiometriaLocal( Usuario pObjUsuario,
														FacturaGiro pObjFactura,
														EnumTiposOperaciones pEnumTipoOperacion
													  ) throws Exception {
		
		Tercero objTercero = null;
		String strEtiqueta = "";
		boolean booProcesarPeticion = false;
		
		UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.ACTIVA_FIRMA_BIOMETRICA_BIOMETRIA_LOCAL,
													  EnumParametrosSistema.ACTIVA_FIRMA_BIOMETRICA_BIOMETRIA_LOCAL_ENVIO,
													  EnumParametrosSistema.ACTIVA_FIRMA_BIOMETRICA_BIOMETRIA_LOCAL_PAGO,
													  EnumParametrosSistema.ACTIVA_FIRMA_BIOMETRICA_BIOMETRIA_LOCAL_CAMBIO_BENEFICIARIO,
													  EnumParametrosSistema.ACTIVA_FIRMA_BIOMETRICA_BIOMETRIA_LOCAL_ANULACION,
													  EnumParametrosSistema.ACTIVA_FIRMA_BIOMETRICA_GENERAL
													  );
		
		EnumTiposBiometriaCaja objEnumTipoBiometria = CajaVistaLogica.getInstance().consultarTipoBiometriaCaja(pObjUsuario);
		
		
		if ( EnumParametrosSistema.ACTIVA_FIRMA_BIOMETRICA_BIOMETRIA_LOCAL.obtenerValorBooleano("A") 
				&& EnumParametrosSistema.ACTIVA_FIRMA_BIOMETRICA_GENERAL.obtenerValorBooleano("S") 
				&& objEnumTipoBiometria.equals(EnumTiposBiometriaCaja.LOCAL)) {		
			
			if ( pEnumTipoOperacion.equals(EnumTiposOperaciones.ENVIO_FACTURACION_GIRO) && pObjFactura.getTerceroTramitador() == null 
					&& EnumParametrosSistema.ACTIVA_FIRMA_BIOMETRICA_BIOMETRIA_LOCAL_ENVIO.obtenerValorBooleano("S") ) {
				
				booProcesarPeticion = true;
				strEtiqueta         = "ENVIO";
				objTercero          = pObjFactura.getTerceroOrigen();
				
			} else if ( pEnumTipoOperacion.equals(EnumTiposOperaciones.PAGO_FACTURACION_GIRO) 
					&& EnumParametrosSistema.ACTIVA_FIRMA_BIOMETRICA_BIOMETRIA_LOCAL_PAGO.obtenerValorBooleano("S") ) {
				
				booProcesarPeticion = true;
				strEtiqueta         = "PAGO";
				
				if ( pObjFactura.getObjTerceroApoderado() != null ) {
					objTercero = pObjFactura.getObjTerceroApoderado();
					pObjFactura.getObjTerceroApoderado().getObjBiometria().gestionarHuellaDerecha().setStrIso("*");
				}else {
					objTercero = pObjFactura.getTerceroDestino();	
					pObjFactura.getTerceroDestino().getObjBiometria().gestionarHuellaDerecha().setStrIso("*");
				}			
				
			} else if ( pEnumTipoOperacion.equals(EnumTiposOperaciones.SOLICITUD_CAMBIO_BENEFICIARIO ) 
					&& EnumParametrosSistema.ACTIVA_FIRMA_BIOMETRICA_BIOMETRIA_LOCAL_CAMBIO_BENEFICIARIO.obtenerValorBooleano("S") ) {
				
				booProcesarPeticion = true;
				strEtiqueta         = "CAMBIOBENEFICIARIO";
				objTercero          = pObjFactura.getTerceroOrigen();
				
			} else if ( pEnumTipoOperacion.equals(EnumTiposOperaciones.SOLICITUD_ANULACION_GIRO ) 
					&& EnumParametrosSistema.ACTIVA_FIRMA_BIOMETRICA_BIOMETRIA_LOCAL_ANULACION.obtenerValorBooleano("S") ) {
				
				booProcesarPeticion = true;
				strEtiqueta         = "ANULACION";
				objTercero          = pObjFactura.getTerceroOrigen();
			}
			
			if ( booProcesarPeticion ) {
				
				if ( objTercero != null && ( objTercero.getObjBiometria() != null && objTercero.getObjBiometria().isRequiereBiometria() && !objTercero.getObjBiometria().getHuellaCapturada().getStrIso().isEmpty() ) ) {
					BiometriaVistaLogica.getInstance().registrarFirmaBiometricaBiometriaLocal(pObjUsuario, objTercero, strEtiqueta);
					/**
					 * Se comentarea instruccion para proteger el valor q se tiene de la Iso trabajada, necesario para 
					 * que se pueda llevar a cabo la autorizacion directa de una solicitud, previo a una verificacion
					 * con biometria
					 */
					pObjFactura.getTerceroOrigen().getObjBiometria().gestionarHuellaDerecha().setStrIso("*");
				}			
			}
		}
		
	}
	
}

package co.com.codesa.clienteposslimgiros.utilidades.serviciosAdicionales.SMSGiro;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.enumeraciones.serviciosAdicionales.claveSeguridad.EnumTiposClaveSeguridad;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaDatosAdicionales;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.mensajes.FormaMensajeAlerta;
import co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.SMSGiro.FormaPanelSMSGiro;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.clienteposslimgiros.utilidades.validaciones.ValidacionesTercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;

/** 
 * ********************************************************************
 * @class	UtilSMSGiro
 *		 	Clase utilitaria relacionada con el envio SMS sujeto a los 
 *			terceros involucrados en una operacion de giro, inicialmente
 *			Envio
 * @author	hector.cuenca
 * @date  	6/04/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class UtilSMSGiro {
	
	/**
	 * @variable instance
	 * 			 Referencia estatica de la clase utilitaria, clave para 
	 * 		 	 incorporar SINGLETON (patron de diseño)
	 **/
	private static UtilSMSGiro instance;

	/**
	 * ********************************************************************
	 * @method UtilSMSGiro
	 * 		   Metodo constructor que permite inicializar variables y
	 * 		   ejecutar comportamientos de interes
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
	 * 		   presentada 
	 * @author hector.cuenca
	 * @date   6/04/2018
	 * ********************************************************************
	 */
	private UtilSMSGiro() throws Exception {

	}

	/** 
	 * ********************************************************************
	 * @method getInstancia
	 * 		   Metodo clave para ejecutar el patron singleton sobre la 
	 * 		   clase, materializando esta por unica vez y manteniendo una 
	 * 		   sola instancia de esta
	 * @return UtilSMSGiro
	 * 		   Tipo referente a la misma clase
	 * @throws Exception
	 *		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author hector.cuenca
	 * @date   6/04/2018
	 * ********************************************************************
	 */
	public static UtilSMSGiro getInstancia() throws Exception {

		if (instance == null) {

			instance = new UtilSMSGiro();
		}

		return instance;
	}
	
	/**
	 * ********************************************************************
	 * @method	validarSMSGiro
	 * 		  	Metodo que permite validar el proceso de notificacacion via
	 * 			SMS a los terceros interesados 
	 * @param	pFrmGnrVentana
	 * 			Forma principal desde donde el cajero se encuentra ejecutando 
	 * 			las operaciones
	 * @param	pObjTercero
	 * 			Tercero al que se le notificara por via SMS
	 * @param	pObjFacturaGiro
	 * 			Objeto que representa la transaccion que se esta llevando a 
	 * 			cabo
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author	hector.cuenca
	 * @date	6/04/2018
	 * *********************************************************************
	 */
	public void validarSMSGiro	(	FormaGenerica pFrmGnrVentana,
									Tercero pObjTercero,
									FacturaGiro pObjFacturaGiro
								)
		throws Exception
	{
		if	(		pObjFacturaGiro.getObjClaveSeguridad() == null 
				||	!EnumTiposClaveSeguridad.AUTOMATICA.equals(pObjFacturaGiro.getObjClaveSeguridad().getEnmTipoClaveSeguridad())
			)
		{
			this.validarSMSGiroEnviado	(	pFrmGnrVentana,
											pObjTercero,
											pObjFacturaGiro
										);
			this.validarSMSAgenciasDisponiblesParaPago	(	pFrmGnrVentana,
															pObjTercero,
															pObjFacturaGiro
														);
		}
	}
	
	/**
	 * ********************************************************************
	 * @method	validarSMSAgenciasDisponiblesParaPago
	 * 		  	Metodo que permite validar si la notificacion via SMS de 
	 * 			agencias para pagos, esta disponible  
	 * @param	pFrmGnrVentana
	 * 			Forma principal desde donde el cajero se encuentra ejecutando 
	 * 			las operaciones
	 * @param	pObjTercero
	 * 			Tercero al que se le notificara por via SMS
	 * @param	pObjFacturaGiro
	 * 			Objeto que representa la transaccion que se esta llevando a 
	 * 			cabo
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author	hector.cuenca
	 * @date	6/04/2018
	 * *********************************************************************
	 */
	public void validarSMSAgenciasDisponiblesParaPago	(	FormaGenerica pFrmGnrVentana,
															Tercero pObjTercero,
															FacturaGiro pObjFacturaGiro
														)
		throws Exception
	{
		boolean booServicioActivo;
		
		UtilParametrosSistema.getInstance().consultar	(	EnumParametrosSistema.ACTIVA_SMS_AGENCIAS_DISPONIBLES_PARA_PAGO_GIRO	);
		
		booServicioActivo = EnumParametrosSistema.ACTIVA_SMS_AGENCIAS_DISPONIBLES_PARA_PAGO_GIRO.obtenerValorBooleano("S");
		
		if	(	booServicioActivo	)
		{
			this.notificarSMS	(	pFrmGnrVentana, 
									pObjTercero,
									//EnumMensajes.NOTIFICAR_SMS_AGENCIAS_DISPONIBLES,
									EnumMensajes.NOTIFICAR_SMS_AGENCIAS_DISPONIBLES_DESEA_ACTUALIZAR_CELULAR
								);
		}
	}
	
	/**
	 * ********************************************************************
	 * @method	validarSMSGiroEnviado
	 * 		  	Metodo que permite validar si la notificacion via SMS de la
	 * 			operacion hacia el tercero de interes, esta disponible 
	 * @param	pFrmGnrVentana
	 * 			Forma principal desde donde el cajero se encuentra ejecutando 
	 * 			las operaciones
	 * @param	pObjTercero
	 * 			Tercero al que se le notificara por via SMS
	 * @param	pObjFacturaGiro
	 * 			Objeto que representa la transaccion que se esta llevando a 
	 * 			cabo
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author	hector.cuenca
	 * @date	6/04/2018
	 * *********************************************************************
	 */
	public void validarSMSGiroEnviado	(	FormaGenerica pFrmGnrVentana,
											Tercero pObjTercero,
											FacturaGiro pObjFacturaGiro
										)
		throws Exception
	{
		boolean booServicioActivo;
		String strLstRemitentesNoNotificanSMS;
		String strLstBeneficiariosNoNotificanSMS;
		String strLstIdsDocumentosNotificanSMS;
		
		UtilParametrosSistema.getInstance().consultar	(	EnumParametrosSistema.SERVICIO_NOTIFICA_SMS_OPERACION_GIRO,
															EnumParametrosSistema.BENEFICIARIOS_EXCLUIDOS_NOTIFICACION_SMS_OPERACION_GIRO,
															EnumParametrosSistema.REMITENTES_EXCLUIDOS_NOTIFICACION_SMS_OPERACION_GIRO,
															EnumParametrosSistema.LISTA_ID_DOCUMENTOS_NOTIFICACION_SMS
														);
		
		booServicioActivo = EnumParametrosSistema.SERVICIO_NOTIFICA_SMS_OPERACION_GIRO.obtenerValorBooleano("S");
		
		if	(	booServicioActivo	)
		{
			strLstIdsDocumentosNotificanSMS = EnumParametrosSistema.LISTA_ID_DOCUMENTOS_NOTIFICACION_SMS.obtenerValorCadena();
			strLstIdsDocumentosNotificanSMS = ("|"+strLstIdsDocumentosNotificanSMS+"|").replaceAll("(\\|)(\\|)+", "|");
			
			if	(	strLstIdsDocumentosNotificanSMS.contains("|"+pObjFacturaGiro.getDocumento().getId()+"|") 	)
			{
				strLstRemitentesNoNotificanSMS = EnumParametrosSistema.REMITENTES_EXCLUIDOS_NOTIFICACION_SMS_OPERACION_GIRO.obtenerValorCadena();
				strLstBeneficiariosNoNotificanSMS = EnumParametrosSistema.BENEFICIARIOS_EXCLUIDOS_NOTIFICACION_SMS_OPERACION_GIRO.obtenerValorCadena();
				
				if	(		!this.terceroBloqueadoEnLista(pObjFacturaGiro.getTerceroOrigen(), strLstRemitentesNoNotificanSMS)
						&&	!this.terceroBloqueadoEnLista(pObjFacturaGiro.getTerceroDestino(), strLstBeneficiariosNoNotificanSMS)
					)
				{
					this.notificarSMS	(	pFrmGnrVentana, 
											pObjTercero,
											//EnumMensajes.NOTIFICAR_SMS_GIRO_ENVIADO,
											EnumMensajes.NOTIFICAR_SMS_GIRO_ENVIADO_DESEA_ACTUALIZAR_CELULAR
										);
				}
			}
		}
		
	}
	
	/**
	 * ********************************************************************
	 * @method	terceroBloqueadoEnLista
	 * 		  	Metodo que permite validar si el tercero en cuestion se 
	 * 			encuentra o no registrado en la lista de quienes no notifican
	 * 			via SMS
	 * @param 	pObjTercero
	 * 			Tercero que se validara si se encuentra en la lista bloqueada
	 * 			para notificar SMS
	 * @param 	pStrLstTercerosNoNotificanSMS
	 * 			Listado de terceros que no notifican via SMS
	 * @return	boolean
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author	hector.cuenca
	 * @date	7/04/2018
	 * *********************************************************************
	 */
	private boolean terceroBloqueadoEnLista	(	Tercero pObjTercero,
												String pStrLstTercerosNoNotificanSMS
											)
		throws Exception
	{
		String strDocTercero;
		
		pStrLstTercerosNoNotificanSMS = ("|"+pStrLstTercerosNoNotificanSMS+"|").replaceAll("(\\|)(\\|)+", "|");
		
		strDocTercero = "|"+pObjTercero.getTipoIdentificacion().getId()+";"+pObjTercero.getIdentificacion()+"|";
		
		return pStrLstTercerosNoNotificanSMS.contains(strDocTercero);
	}
	
	/**
	 * ********************************************************************
	 * @method	notificarSMS
	 * 		  	Metodo que despliega todo el proceso a fin de notificar al 
	 * 			tercero en cuestion de la operacion realizada
	 * @param	pFrmGnrVentana
	 * 			Forma principal desde donde el cajero se encuentra ejecutando 
	 * 			las operaciones
	 * @param	pObjTercero
	 * 			Tercero al que se le notificara por via SMS
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author	hector.cuenca
	 * @date	6/04/2018
	 * *********************************************************************
	 */
	public void notificarSMS(	FormaGenerica pFrmGnrVentana,
								Tercero pObjTercero,
								//EnumMensajes pEnmMsgNotificacionSMS,
								EnumMensajes pEnmMsgProponeActualizarCelular
							)
		throws Exception 
	{
		FormaMensajeAlerta objFrmMsgAlerta;
		
		EnumEtiquetas.PERSONALIZADA.setValor(pObjTercero.getDescripcion());
		
		if	(	!pObjTercero.isBooActualizoCelular()
				/*	pObjTercero.getTelefono2()	==	null
				||	pObjTercero.getTelefono2().trim().isEmpty()
				*/
			)
		{
			/*
			objFrmMsgAlerta = pEnmMsgNotificacionSMS.desplegarMensaje	(	pFrmGnrVentana, 
																			EnumClasesMensaje.INFORMACION, 
																			EnumEtiquetas.PERSONALIZADA.toString()
																		);
		}	else	{
		*/
			objFrmMsgAlerta = pEnmMsgProponeActualizarCelular.desplegarMensaje	(	pFrmGnrVentana, 
																					EnumClasesMensaje.CONFIRMACION, 
																					EnumEtiquetas.PERSONALIZADA.toString(),
																					pObjTercero.getTelefono2()
																				);
			if	(	objFrmMsgAlerta.isOpcion()	)
			{
				this.proponerActualizacionCelular	(	pFrmGnrVentana,
														pObjTercero
													);
			}
		}
	}
	
	/**
	 * ********************************************************************
	 * @method	proponerActualizacionCelular
	 * 		  	Metodo que propone la actualizacion de celular del tercero
	 * 			que se notificara via SMS de la operacion realizada
	 * @param	pFrmGnrVentana
	 * 			Forma principal desde donde el cajero se encuentra ejecutando 
	 * 			las operaciones
	 * @param	pObjTercero
	 * 			Tercero al que se le notificara por via SMS
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author	hector.cuenca
	 * @date	7/04/2018
	 * *********************************************************************
	 */
	private void proponerActualizacionCelular	(	FormaGenerica pFrmGnrVentana,
													Tercero pObjTercero	
												)
		throws Exception 
	{
		FormaPanelSMSGiro pnlSMSGiro;
		FormaDatosAdicionales objFormaDatosAdicionales;
		String strTelefonoInicial;
		
		pnlSMSGiro = new FormaPanelSMSGiro	(	pFrmGnrVentana,
												pObjTercero.getTelefono2(),
												EnumDimensionesComponentes.PNL_PNL_SMS_SECCION,
												EnumEtiquetas.PERSONALIZADA
											);
		
		objFormaDatosAdicionales = new FormaDatosAdicionales(	pFrmGnrVentana, 
																true, 
																pnlSMSGiro
															);
		
		if	(	objFormaDatosAdicionales.getEnmBotEncAccionSolicitada().equals(EnumBotonesEncabezado.BTNGUARDAR)	)
		{
			strTelefonoInicial = pObjTercero.getTelefono2();
			pObjTercero.setTelefono2(pnlSMSGiro.getEvaControlEventos().getStrTelefonoCelular());
			ValidacionesTercero.getInstance().validaActualizaCelularTercero	(	strTelefonoInicial, 
																				pObjTercero, 
																				pFrmGnrVentana
																			);
		}
		
	}
}

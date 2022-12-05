package co.com.codesa.clienteposslimgiros.utilidades.biometria.internacional;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import co.com.codesa.client.socketcliente.util.AdministradorPropiedades;
import co.com.codesa.clienteposslimexception.exceptions.ClientePosSlimGirosException;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.formas.biometria.internacional.FormaPanelDedoBiometriaSeleccionado;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaDatosAdicionales;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.mensajes.FormaMensajeAlerta;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGirosInternacional;
import co.com.codesa.clienteposslimgiros.utilidades.archivo.UtilArchivo;
import co.com.codesa.clienteposslimgiros.utilidades.internacional.UtilTransmisionInternacional;
import co.com.codesa.clienteposslimgiros.utilidades.validaciones.ValidacionesBiometria;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Dedo;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Mano;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TerceroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.transmision.internacional.ArchivoInternacionalDTO;

/** 
 * ********************************************************************
 * @class	UtilBiometriaInternacional
 *		 	Clase utilitaria relacionada con los procesos de biometria
 *			en las funcionalidades de giros internacionales
 * @author	hector.cuenca
 * @date  	2/04/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class UtilBiometriaInternacional {

	/**
	 * @variable intMaxHuella
	 * 			 longitud maxima de la huella
	 */
	private int intMaxHuella;
	
	/**
	 * @variable	pnlDedoBiometriaSeleccionado
	 * 				Seccion que permite especificar el dedo seleccionado para
	 * 				aplicar el proceso de biometria
	 */
	private FormaPanelDedoBiometriaSeleccionado pnlDedoBiometriaSeleccionado;
	
	/**
	 * @variable instance
	 * 			 Referencia estatica de la clase utilitaria, clave para 
	 * 		 	 incorporar SINGLETON (patron de diseño)
	 **/
	private static UtilBiometriaInternacional instance;
	
	/**
	 * ********************************************************************
	 * @method UtilBiometriaInternacional
	 * 		   Metodo constructor que permite inicializar variables y
	 * 		   ejecutar comportamientos de interes
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
	 * 		   presentada 
	 * @author hector.cuenca
	 * @date   2/04/2018
	 * ********************************************************************
	 */
	private UtilBiometriaInternacional() throws Exception {

	}

	/** 
	 * ********************************************************************
	 * @method getInstancia
	 * 		   Metodo clave para ejecutar el patron singleton sobre la 
	 * 		   clase, materializando esta por unica vez y manteniendo una 
	 * 		   sola instancia de esta
	 * @return UtilBiometriaInternacional
	 * 		   Tipo referente a la misma clase
	 * @throws Exception
	 *		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author hector.cuenca
	 * @date   2/04/2018
	 * ********************************************************************
	 */
	public static UtilBiometriaInternacional getInstancia() throws Exception {

		if (instance == null) {

			instance = new UtilBiometriaInternacional();
		}

		return instance;
	}
	
	/**
	 * ********************************************************************
	 * @method	iniciarPropPnlDedoBiometriaSeleccionado
	 * 		  	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	pnlDedoBiometriaSeleccionado
  	 * @param	pFormaContenedor
  	 * 			Forma a la que pertenecera el panel generico
	 * @return	FormaPanelDedoBiometriaSeleccionado
	 * 			Seccion que especifica el dedo seleccionado para
	 * 			aplicar el proceso de biometria, gestionado
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author	hector.cuenca
	 * @date	21/03/2018
	 * *********************************************************************
	 */
	public FormaPanelDedoBiometriaSeleccionado iniciarPropPnlDedoBiometriaSeleccionado(FormaGenerica pFormaContenedor) 
			throws Exception
	{
		if	(	this.pnlDedoBiometriaSeleccionado	==	null	)
		{
			this.pnlDedoBiometriaSeleccionado = new FormaPanelDedoBiometriaSeleccionado	(	pFormaContenedor,
																							EnumDimensionesComponentes.PNL_MNT_TERC_INT_DEDO_BIOMETRIA_SELECCIONADO,
																							"pnlDedoBiometriaSeleccionado"
																						);
		}
		
		return this.pnlDedoBiometriaSeleccionado;
	}

	/**
	 * ********************************************************************
	 * @method	validarBiometria
	 * 		  	Metodo que permite realizar las validaciones de biometria
	 * 			exigidas a un tercero en funcionalidades de giros 
	 * 			internacionales  
	 * @param 	pObjTerceroInternacional
	 * 			Tercero al cual se le ejecutara la validacion de biometria
	 * @param 	pFrmGenerica
	 * 			Forma sobre la cual se esta llevando a cabo el proceso,
	 * @param	pStrIdTransaccion
	 * 			Id de transaccion utilizado en el proceso
	 * @return	boolean
	 * 			Bandera que indica el resultado del proceso de validacion de 
	 * 			biometria realizado para el tercero
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author	hector.cuenca
	 * @date	2/04/2018
	 * *********************************************************************
	 */
	public boolean validarBiometria	(	TerceroInternacional pObjTerceroInternacional,
										FormaGenerica pFrmGenerica,
										String pStrIdTransaccion
									)
		throws Exception
	{
		FormaDatosAdicionales objFormaDatosAdicionales;
		boolean booEnrolarTercero;
		boolean booValidado = false;
		
		if	(	!pObjTerceroInternacional.getObjBiometria().isBooValidadoBiometricamente()	)
		{
			booEnrolarTercero	=		pObjTerceroInternacional.getObjDtoConfigTerceroInternacional().getStrCodigoTipoMano()	==	null
									|| 	pObjTerceroInternacional.getObjDtoConfigTerceroInternacional().getStrCodigoTipoDedo()	==	null
									; 
			this.iniciarPropPnlDedoBiometriaSeleccionado(pFrmGenerica);
			
			if	(	booEnrolarTercero	)
			{
				this.getPnlDedoBiometriaSeleccionado().getCmbTipoMano().setSelectedItem(EnumEtiquetas.LBL_NO_SELECCIONADO);
				this.getPnlDedoBiometriaSeleccionado().getCmbTipoDedo().setSelectedItem(EnumEtiquetas.LBL_NO_SELECCIONADO);
			}	else	{
				this.getPnlDedoBiometriaSeleccionado().getCmbTipoMano().setSelectedItem(new Mano(pObjTerceroInternacional.getObjDtoConfigTerceroInternacional().getStrCodigoTipoMano()));
				this.getPnlDedoBiometriaSeleccionado().getCmbTipoDedo().setSelectedItem(new Dedo(pObjTerceroInternacional.getObjDtoConfigTerceroInternacional().getStrCodigoTipoDedo()));
			}
			
			this.getPnlDedoBiometriaSeleccionado().getCmbTipoMano().setEnabled(booEnrolarTercero);
			this.getPnlDedoBiometriaSeleccionado().getCmbTipoDedo().setEnabled(booEnrolarTercero);
			
			objFormaDatosAdicionales = new FormaDatosAdicionales(	pFrmGenerica, 
																	true, 
																	this.getPnlDedoBiometriaSeleccionado()
																);
			
			if	(	objFormaDatosAdicionales.getEnmBotEncAccionSolicitada().equals(EnumBotonesEncabezado.BTNGUARDAR)	)
			{
				//Continuar operacion biometria
				//if	(	pObjDtoConfigTerceroInternacional.isBooTerceroNuevo()	)
				//{
					this.gestionarCapturaHuella	(	pObjTerceroInternacional,
													pFrmGenerica,
													pStrIdTransaccion
												);
				//}
				if (pObjTerceroInternacional.getObjBiometria().isBooValidadoBiometricamente() ) {
					pObjTerceroInternacional.getObjBiometria().gestionarHuellaCapturada().setStrTipo(((Mano)this.getPnlDedoBiometriaSeleccionado().getCmbTipoMano().getSelectedItem()).getStrCodigo());
					pObjTerceroInternacional.getObjBiometria().gestionarHuellaCapturada().setStrTipoDedo(((Dedo)this.getPnlDedoBiometriaSeleccionado().getCmbTipoDedo().getSelectedItem()).getStrCodigo());
					//pObjTerceroInternacional.getObjBiometria().setBooValidadoBiometricamente(true);
					booValidado = true;
				}
			}
		}	else	{
			booValidado = true;
		}
		
		return booValidado;
	}
	
	private void gestionarCapturaHuella	(	TerceroInternacional pObjTerceroInternacional,
											FormaGenerica pFrmGenerica,
											String pStrIdTransaccion
										)
		throws Exception
	{
		List<ArchivoInternacionalDTO> lstTransmitirArchivos = null;
		FormaMensajeAlerta frmAlerta;
		
		while	(true)
		{
			try{
			
				if	(		pObjTerceroInternacional.getObjDtoConfigTerceroInternacional().isBooEnviarImagenHuella()
						||	pObjTerceroInternacional.getObjDtoConfigTerceroInternacional().isBooTerceroNuevo()
					)
				{
					this.capturarHuella	(	pObjTerceroInternacional,
											pFrmGenerica,
											true
										);
					lstTransmitirArchivos = lstTransmitirArchivos==null?lstTransmitirArchivos = new ArrayList<>():lstTransmitirArchivos;
							
					if	(	pObjTerceroInternacional.getObjDtoConfigTerceroInternacional().isBooEnviarImagenHuella()	)
					{
						this.generarImagenHuellaWSQ	(	pObjTerceroInternacional,
														pFrmGenerica,
														pStrIdTransaccion
													);
						lstTransmitirArchivos.add(new ArchivoInternacionalDTO(pObjTerceroInternacional.getObjBiometria().getHuellaCapturada().getFilArchivoImgHuella()));
						
						//UtilTransmisionInternacional.getInstancia().enviarArchivoInternacional(pObjTerceroInternacional.getObjBiometria().getHuellaCapturada().getFilArchivoImgHuella());
					}
					
					if	(	pObjTerceroInternacional.getObjDtoConfigTerceroInternacional().isBooTerceroNuevo()	)
					{
						this.generarArchivoWSQ	(	pObjTerceroInternacional,
													pFrmGenerica,
													pStrIdTransaccion
												);
						lstTransmitirArchivos.add(new ArchivoInternacionalDTO(pObjTerceroInternacional.getObjBiometria().getHuellaCapturada().getFilArchivoWSQ()));
						
						//UtilTransmisionInternacional.getInstancia().enviarArchivoInternacional(pObjTerceroInternacional.getObjBiometria().getHuellaCapturada().getFilArchivoWSQ());
					}
					
					/**
					 * PENDIENTE_RMV
					 * transmito listado
					 */
					boolean booTransmiteArchivosHuella;
					booTransmiteArchivosHuella = UtilTransmisionInternacional.getInstancia().transmitirArchivosInternacional(pFrmGenerica.getObjUsuario(), 
																															 lstTransmitirArchivos);
					System.err.println("-----booTransmiteArchivosHuella:"+booTransmiteArchivosHuella);
					pObjTerceroInternacional.getObjDtoConfigTerceroInternacional().setBooEnviaTramaActualizaTercero(true);
					
				}	else	{
					this.capturarHuella	(	pObjTerceroInternacional,
											pFrmGenerica,
											false
										);
				}
				
				break;
				
			}catch(ClientePosSlimGirosException cpsge)
			{
				if	(	lstTransmitirArchivos != null	)
				{
					lstTransmitirArchivos.clear();
				}
				
				pFrmGenerica.getEventoForma().controlExcepcion(cpsge);
				frmAlerta = EnumMensajes.PROBLEMA_CAPTURA_HUELLA_DESEA_INSISTIR.desplegarMensaje(	pFrmGenerica, 
																									EnumClasesMensaje.CONFIRMACION
																								);
				if	(	!frmAlerta.isOpcion()	)
				{
					break;
				}
			}
		}
	}
	
	private void generarImagenHuellaWSQ	(	TerceroInternacional pObjTerceroInternacional,
										FormaGenerica pFrmGenerica,
										String pStrIdTransaccion
									)
		throws Exception
	{
		File objFilImagenHuella;
		String strNombreArchivo;
		
		strNombreArchivo = "H_"+pStrIdTransaccion+"_"+pObjTerceroInternacional.getIdentificacion()+".jpg";
		objFilImagenHuella = UtilWSQInternacional.getInstancia().generarImagenWSQ	(	pObjTerceroInternacional.getObjBiometria().getHuellaCapturada().getStrWsq(),
																						strNombreArchivo,
																						pFrmGenerica
																					);
		pObjTerceroInternacional.getObjBiometria().getHuellaCapturada().setFilArchivoImgHuella(objFilImagenHuella);
	}
	
	private void generarArchivoWSQ	(	TerceroInternacional pObjTerceroInternacional,
									FormaGenerica pFrmGenerica,
									String pStrIdTransaccion
								)
		throws Exception
	{
		File objFilArchivoWSQ;
		String strNombreArchivo;
		
		strNombreArchivo = "W_"+pStrIdTransaccion+"_"+pObjTerceroInternacional.getIdentificacion()+".wsq";
		
		objFilArchivoWSQ = UtilArchivo.getInstancia().crearArchivo	(	strNombreArchivo, 
																		InformacionSessionGirosInternacional.getInstance(pFrmGenerica.getObjUsuario()).getStrRutaCapturaInternacional(), 
																		pObjTerceroInternacional.getObjBiometria().getHuellaCapturada().getStrWsq()
																	);
		pObjTerceroInternacional.getObjBiometria().getHuellaCapturada().setFilArchivoWSQ(objFilArchivoWSQ);
		objFilArchivoWSQ.deleteOnExit();
		
		/**
		 * TODO: integrar proceso de transmision wsq
		 */
	}
	
	public void capturarHuella	(	TerceroInternacional pObjTerceroInternacional,
									FormaGenerica pFrmGenerica,
									boolean pBooGeneraWSQ
								)
		throws Exception
	{	
		String strResultadoCaptura;
		
    	/*EnumMensajes.desplegarMensajePersonalizado	(	pFrmGenerica, 
				   										EnumClasesMensaje.INFORMACION, 
				   										null, 
				   										AdministradorPropiedades.getMensaje(EnumParametrosApp.SOLICITAR_LEER_HUELLA_DER.getValorPropiedad())
				   									);*/
		
		EnumMensajes.BIO_COLOCAR_DEDO_LECTOR.desplegarMensaje(	pFrmGenerica, 
																EnumClasesMensaje.INFORMACION);
		
    	if(pBooGeneraWSQ)
    	{
    		strResultadoCaptura	=	ValidacionesBiometria.getInstance().capturarHuella	(	EnumParametrosApp.SOLICITAR_LEER_HUELLA.getValorPropiedad(),
																							pObjTerceroInternacional
																						);
    	}	else	{
    		strResultadoCaptura	=	ValidacionesBiometria.getInstance().capturarHuellaIso(EnumParametrosApp.SOLICITAR_LEER_HUELLA.getValorPropiedad());
    	}
		
		if	(	strResultadoCaptura.equals(EnumParametrosApp.DEDO_NO_DETECTADO.getValorPropiedad())	)
		{
        	

            try {
            	// Espera 5 segundos para que la maquina active el sensor.
				Thread.sleep(5000);
			} catch (Exception e) {}
            
            throw EnumMensajes.generarExcepcionPersonalizada	(	EnumClasesMensaje.ERROR, 
															   		null, 
															   		AdministradorPropiedades.getMensaje(EnumParametrosApp.NO_SE_LOGRO_DETECTAR_HUELLA.getValorPropiedad())
															   	);
            
            
		}	else if	(	strResultadoCaptura.equals(EnumParametrosApp.BIO_RESPUESTA_INCOMPLETA.getValorPropiedad())	)
		{	
			throw EnumMensajes.generarExcepcionPersonalizada	(	EnumClasesMensaje.ERROR, 
															   		null, 
															   		EnumParametrosApp.BIO_REINICIE_IDVERIFY.getValorPropiedad()
															   	);
	        	
		}	else if	(	strResultadoCaptura.equals(EnumParametrosApp.BIO_HUELLA_FALLIDA.getValorPropiedad())	)
		{
			throw EnumMensajes.generarExcepcionPersonalizada	(	EnumClasesMensaje.ERROR, 
															   		null, 
															   		EnumParametrosApp.BIO_RES_FALLA_LECTURA.getValorPropiedad()+"!"
															   	);
        	
		}	else if	(	strResultadoCaptura.equals(EnumParametrosApp.BIO_HUELLA_CALIDAD_BAJA.getValorPropiedad())	)
		{	
			throw EnumMensajes.generarExcepcionPersonalizada	(	EnumClasesMensaje.ERROR, 
															   		null, 
															   		AdministradorPropiedades.getMensaje(EnumParametrosApp.BIO_ADMPRO_CALIDAD_BAJA.getValorPropiedad())
															   	);
		
		}	else if	(	strResultadoCaptura.equals(EnumParametrosApp.LECTOR_NO_DETECTADO.getValorPropiedad())	)
		{
			throw EnumMensajes.generarExcepcionPersonalizada	(	EnumClasesMensaje.ERROR, 
															   		null, 
															   		EnumParametrosApp.BIO_RES_LECTOR_NO_DETECTADO.getValorPropiedad()+"!"
															   	);
		
		}	else if	(		strResultadoCaptura.length() > this.getIntMaxHuella()
						&& 	!strResultadoCaptura.equals(EnumParametrosApp.ERROR_IMAGEN_NULA.getValorPropiedad())
						&&	!strResultadoCaptura.isEmpty()
					) 
		{
			EnumMensajes.desplegarMensajePersonalizado	(	pFrmGenerica, 
													   		EnumClasesMensaje.INFORMACION, 
													   		null, 
													   		AdministradorPropiedades.getMensaje(EnumParametrosApp.CAPTURA_EXITOSA.getValorPropiedad())
													   	);
			pObjTerceroInternacional.getObjBiometria().setBooValidadoBiometricamente(true);
			if	(	!pBooGeneraWSQ	)
			{
				pObjTerceroInternacional.getObjBiometria().gestionarHuellaCapturada().setStrIso(strResultadoCaptura);
			}

        }	else	{

        	throw EnumMensajes.generarExcepcionPersonalizada	(	EnumClasesMensaje.ERROR, 
															   		null, 
															   		EnumParametrosApp.BIO_CAPTURA_NO_EXITOSA_ND.getValorPropiedad()
															   	);
        }
	}
	
	/**
	 * @method	getIntMaxHuella
	 * 		  	Metodo get del atributo intMaxHuella
	 * @return	int
	 *		  	Valor del atributo intMaxHuella devuelto
	 * @author	hector.cuenca
	 * @throws 	Exception 
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @date  	2/04/2018
	 */
	public int getIntMaxHuella() throws Exception 
	{	
		if	(	this.intMaxHuella	==	0	) 
		{
			this.intMaxHuella = EnumParametrosApp.BIO_LONGITUD_MAX_HUELLA_DEFECTO_INTERNACIONAL.getValorEntero();
		}
		return this.intMaxHuella;
	}

	/**
	 * @method	setIntMaxHuella
	 * 		  	Metodo set del atributo intMaxHuella
	 * @param	pIntMaxHuella
	 * 			Valor que tomara el atributo intMaxHuella
	 * @author	hector.cuenca
	 * @date	2/04/2018
	 */
	public void setIntMaxHuella(int pIntMaxHuella) {
		this.intMaxHuella = pIntMaxHuella;
	}

	/**
	 * @method	getPnlDedoBiometriaSeleccionado
	 * 		  	Metodo get del atributo pnlDedoBiometriaSeleccionado
	 * @return	FormaPanelDedoBiometriaSeleccionado
	 *		  	Valor del atributo pnlDedoBiometriaSeleccionado devuelto
	 * @author	hector.cuenca
	 * @date  	3/04/2018
	 */
	public FormaPanelDedoBiometriaSeleccionado getPnlDedoBiometriaSeleccionado() {
		return this.pnlDedoBiometriaSeleccionado;
	}

	/**
	 * @method	setPnlDedoBiometriaSeleccionado
	 * 		  	Metodo set del atributo pnlDedoBiometriaSeleccionado
	 * @param	pPnlDedoBiometriaSeleccionado
	 * 			Valor que tomara el atributo pnlDedoBiometriaSeleccionado
	 * @author	hector.cuenca
	 * @date	3/04/2018
	 */
	public void setPnlDedoBiometriaSeleccionado(
			FormaPanelDedoBiometriaSeleccionado pPnlDedoBiometriaSeleccionado) {
		this.pnlDedoBiometriaSeleccionado = pPnlDedoBiometriaSeleccionado;
	}
	
}

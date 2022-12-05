package co.com.codesa.clienteposslimgiros.utilidades.integracion.libCajaMultiservicio;

import java.awt.Window;

import co.com.codesa.clienteposslimexception.exceptions.ClientePosSlimGirosException;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.operaciones.EnumTiposOperaciones;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clientecajams.dominio.dto.TransaccionCajaMultiservicioDTO;
import co.com.codesa.clientecajams.utilidades.excepciones.CajaMultiservicioException;
import co.com.codesa.clientecajams.utilidades.integracion.UtilIntegracionAccesoCajaMultiservicio;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGiros;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;


/** 
 * ********************************************************************
 * @class	UtilIntegracionLibCajaMultiservicio
 *		 	Clase utilitaria relacionada con la integracion hacia la 
 *			libreria cliente de la caja multiservicio
 * @author	hector.cuenca
 * @date  	28/08/2017
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class UtilIntegracionLibCajaMultiservicio 
{	
	
	/**
	 * @variable 	instancia 
	 * 				Referencia estatica de la clase utilitaria, clave para incorporar
	 * 			 	SINGLETON (patron de diseño)
	 **/
	private static UtilIntegracionLibCajaMultiservicio instancia;
	
	/**
  	 * ****************************************************************.
  	 * @metodo UtilIntegracionLibCajaMultiservicio
  	 * 		   Metodo constructor que permite inicializar variables y
  	 * 		   ejecutar comportamientos de interes
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private UtilIntegracionLibCajaMultiservicio() 
			throws Exception
	{}

	/**
  	 * ****************************************************************.
  	 * @metodo getInstance
  	 * 		   Metodo clave para ejecutar el patron singleton sobre la 
  	 * 		   clase, materializando esta por unica vez y manteniendo una 
  	 * 		   sola instancia de esta
  	 * @return UtilIntegracionLibCajaMultiservicio
  	 * 		   Tipo referente a la misma clase
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public static UtilIntegracionLibCajaMultiservicio getInstance()throws Exception{
		
		if (instancia == null) {
			
			instancia = new UtilIntegracionLibCajaMultiservicio();
		}
		
		return instancia;
	}
	
	/** 
	 * ********************************************************************
	 * @method	procesarTerceroXCajaMultiservicio
	 * 		  	Metodo que permite realizar todo el despliegue e integracion
	 * 			con la lib CajaMultiservicio y el sistema multiservicio
	 * @param 	pobjTercero
	 * 			Tercero que sera procesado por este modelo
	 * @return	String
	 * 			Respuesta de la peticion emitida al sistema biometria 
	 * 			multiservicio
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	4/09/2017
	 * *********************************************************************
	 */
	public	boolean	procesarTerceroXCajaMultiservicio	(	Tercero pobjTercero,
															EnumTiposOperaciones pEnmTipoOperacion,
															String pStrTipoTercero,
															FormaGenerica pObjFrmGnrVentana
														)
		throws Exception
	{
		TransaccionCajaMultiservicioDTO objDtoTransaccionCajaMultiservicio;
		Usuario objUsuario;
		boolean booRespuestaCajaMultiservicio;
		
		try{
			
			objUsuario	=	InformacionSessionGiros.getInstance().getObjUsuario();
			
			objDtoTransaccionCajaMultiservicio	=	new TransaccionCajaMultiservicioDTO	(	";",
																							pobjTercero.getTipoIdentificacion().getValor(),
																							pobjTercero.getIdentificacion(),
																							pStrTipoTercero,
																							"SUPERGIROS",//objUsuario.getEmpresa().getNombre().toUpperCase().replace("S.A.", "").trim().replaceAll("\\s+","_"),
																							objUsuario.getEmpresa().getRcNombre().trim().toUpperCase().replaceAll("\\s+","_"),//"GANE"
																							"VENTA",
																							"BNET_POSSLIM",
																							"GIROS",
																							pEnmTipoOperacion.getStrValorPropiedad(),
																							objUsuario.getStrLoginGamble()
																						);
			
			if (EnumTiposOperaciones.ENVIO_FACTURACION.equals(pEnmTipoOperacion)) {
				objDtoTransaccionCajaMultiservicio.setIntCanIntentosPasaValidacion(3);
			}
			
			//objDtoTransaccionCajaMultiservicio.setStrRutaArchivoImg(System.getProperty("user.dir")+File.separator+"BiometriaMS"+File.separator);
			objDtoTransaccionCajaMultiservicio.setObjWinVentana(pObjFrmGnrVentana);
			objDtoTransaccionCajaMultiservicio.setStrCalidadEnrolar("ALTA");
			objDtoTransaccionCajaMultiservicio.setStrCalidadHuellaValidar("ALTA");
			objDtoTransaccionCajaMultiservicio.setStrFormatoImg("jpg");
			objDtoTransaccionCajaMultiservicio.setStrTamanoImg("640*480");
			objDtoTransaccionCajaMultiservicio.setStrFormatosImg("{jpg;png;tif}");
			objDtoTransaccionCajaMultiservicio.setStrTamanosImg("{176*144;320*240;640*480}");
			objDtoTransaccionCajaMultiservicio.setBooCambiaFormatoImg(false);
			objDtoTransaccionCajaMultiservicio.setBooCambiaRutaImg(false);
			objDtoTransaccionCajaMultiservicio.setBooCambiaTamanoImg(false);
			objDtoTransaccionCajaMultiservicio.setBooUsaMaximaResolucionCam(false);
			objDtoTransaccionCajaMultiservicio.setStrApellido1(pobjTercero.getApellido1());
			objDtoTransaccionCajaMultiservicio.setStrApellido2(pobjTercero.getApellido2());
			objDtoTransaccionCajaMultiservicio.setStrNombres(pobjTercero.getNombres());
			
			/*
			if (pobjTercero.getNombres().contains(" ")) {
				objDtoTransaccionCajaMultiservicio.setStrNombre1(pobjTercero.getNombres().substring(0, pobjTercero.getNombres().indexOf(" ")));
				objDtoTransaccionCajaMultiservicio.setStrNombre2(pobjTercero.getNombres().substring(pobjTercero.getNombres().indexOf(" ")+1));
			}else{
				objDtoTransaccionCajaMultiservicio.setStrNombre1(pobjTercero.getNombres());
			}
			*/
			
			objDtoTransaccionCajaMultiservicio.setStrFechaNacimiento(pobjTercero.getFechaNacimiento());
			objDtoTransaccionCajaMultiservicio.setStrSexo(pobjTercero.getStrSexo());
			objDtoTransaccionCajaMultiservicio.setStrTipoSangre(pobjTercero.getStrTipoSangre());
			objDtoTransaccionCajaMultiservicio.setLngTimeOutCapturaImg(10000);
			objDtoTransaccionCajaMultiservicio.setLngTimeOutCapturaHuellaCC(10000);
			objDtoTransaccionCajaMultiservicio.setLngTimeOutCapturaHuellaViva(10000);
			objDtoTransaccionCajaMultiservicio.setStrEstadoBiometriaTercero(pobjTercero.getObjBiometria().getEstadoBiometria());
			
			booRespuestaCajaMultiservicio	=	UtilIntegracionAccesoCajaMultiservicio.getInstancia().ejecutar	(objDtoTransaccionCajaMultiservicio);
			
			pobjTercero.getObjBiometria().setObjBooApto(objDtoTransaccionCajaMultiservicio.getObjBooApto());
			pobjTercero.getObjBiometria().setBooValidadoBiometricamente(objDtoTransaccionCajaMultiservicio.isBooValidadoBiometricamente());
			
			if	(		booRespuestaCajaMultiservicio
					&&	objDtoTransaccionCajaMultiservicio.getStrIsoVerificada() != null
				)
			{
				pobjTercero.getObjBiometria().gestionarHuellaDerecha().setStrIso(objDtoTransaccionCajaMultiservicio.getStrIsoVerificada());
				pobjTercero.getObjBiometria().setStrRespuestaAfis("OK");
				pobjTercero.getObjBiometria().setStrTiempoAfis( UtilidadGiros.getInstancia().getFORMATEADOR_FECHA_SLASH_COMPLETO().format(objDtoTransaccionCajaMultiservicio.getDatFechaHoraVerificacion()));
				pobjTercero.getObjBiometria().setStrTiempoRespuestaAfis(String.valueOf(objDtoTransaccionCajaMultiservicio.getLonTiempoProcesoVerificacion()));
				//pobjTercero.getObjBiometria().gestionarHuellaDerecha().setStrScore(objDtoTransaccionCajaMultiservicio.getStrPuntajeIsoVerficada());
			}

		}catch(Exception e){
			UtilidadesGiros.getInstance().controlExcepcion(e, pObjFrmGnrVentana);
			booRespuestaCajaMultiservicio = false;
		}
		
		return booRespuestaCajaMultiservicio;
	}
	
	public String [] proponerCapturaDatosCedulaCajaMS	(	String pStrTipoIdentificacion,
															String pStrIdentificacion,
															Window pWinVentana
														) 
		throws Exception
	{	
		String [] arrStrRespuestaDatosCC;
		TransaccionCajaMultiservicioDTO objDtoTransaccionCajaMultiservicio;
		
		objDtoTransaccionCajaMultiservicio	=	new TransaccionCajaMultiservicioDTO();
		objDtoTransaccionCajaMultiservicio.setLngTimeOutCapturaImg(10000);
		objDtoTransaccionCajaMultiservicio.setStrTipoIdentificacion(pStrTipoIdentificacion);
		objDtoTransaccionCajaMultiservicio.setStrIdentificacion(pStrIdentificacion);
		
		arrStrRespuestaDatosCC = UtilIntegracionAccesoCajaMultiservicio.getInstancia().proponerCapturaDatosCedula	(	objDtoTransaccionCajaMultiservicio,
																														pWinVentana
																													);
		return arrStrRespuestaDatosCC;
	}
	
	/**
	 * ********************************************************************
	 * @method	interpretarExceptionNegocioCajaMultiservicio
	 * 		  	Metodo que permite interpretar una excepcion 
	 * @param 	pCme
	 * 			Excepcion de negocio generada por la caja multiservicio
	 * @param 	pBooLanzarExcepcion
	 * 			Bandera que identifica si la excepcion interpretada debe 
	 * 			lanzarse o simplemente retornarse
	 * @return	ClientePosSlimGirosException
	 * 			Excepcion de negocio de PosSlimGiros, traducida de la interpretacion 
	 * 			de la excepcion recibida desde la caja multiservicio 
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	13/04/2018
	 * *********************************************************************
	 */
	public ClientePosSlimGirosException interpretarExceptionNegocioCajaMultiservicio(	CajaMultiservicioException pCme,
																						boolean pBooLanzarExcepcion
																					)
		throws Exception 
	{
		EnumClasesMensaje enmClaseMensaje;
		ClientePosSlimGirosException cpsge;
		co.com.codesa.clientecajams.utilidades.mensajes.Mensaje objMensaje;
		
		objMensaje = (co.com.codesa.clientecajams.utilidades.mensajes.Mensaje)pCme.getObjMensaje();
		
		if	(	(enmClaseMensaje = EnumClasesMensaje.valueOf(objMensaje.getClase().name()))==null	)
		{
			enmClaseMensaje = EnumClasesMensaje.ADVERTENCIA;
		}
		
		cpsge	=	(ClientePosSlimGirosException)EnumMensajes.generarExcepcionPersonalizada(	enmClaseMensaje, 
																								objMensaje.getCodigo(),
																								objMensaje.getMensaje(),
																								objMensaje.getParametros()
																							);
		if	(	pBooLanzarExcepcion	)
		{
			throw cpsge;
		}
		
		return cpsge;
	}
}

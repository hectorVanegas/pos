package co.com.codesa.clienteposslimgiros.utilidades.tercero.internacional;

import co.com.codesa.clienteposslimexception.exceptions.ClientePosSlimGirosException;
import co.com.codesa.clienteposslimgiros.dto.tercero.internacional.ValidarTerceroInternacionalDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.peticionMultiservicio.EnumPeticionesMultiservicio;
import co.com.codesa.clienteposslimgiros.formas.terceros.FormaActualizarCrearTerceroInternacional;
import co.com.codesa.clienteposslimgiros.utilidades.biometria.internacional.UtilBiometriaInternacional;
import co.com.codesa.clienteposslimgiros.utilidades.mensajes.Mensaje;
import co.com.codesa.clienteposslimgiros.vista.logica.Internacional.tercero.TerceroInternacionalVistaLogica;

/** 
 * ********************************************************************
 * @class	UtilTerceroInternacional
 *		 	Clase utilitaria relacionada con el tratamiento de los terceros
 *			en funcionalidades de giros internacionales
 * @author	hector.cuenca
 * @date  	4/04/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class UtilTerceroInternacional {

	/**
	 * @variable instance
	 * 			 Referencia estatica de la clase utilitaria, clave para 
	 * 		 	 incorporar SINGLETON (patron de diseño)
	 **/
	private static UtilTerceroInternacional instance;
	
	/**
	 * @variable	booProcesoValidarTercero
	 * 				bandera que indica que el tercero fue validado
	 */
	private Boolean booProcesoValidarTercero;

	/**
	 * ********************************************************************
	 * @method UtilTerceroInternacional
	 * 		   Metodo constructor que permite inicializar variables y
	 * 		   ejecutar comportamientos de interes
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
	 * 		   presentada 
	 * @author hector.cuenca
	 * @date   4/04/2018
	 * ********************************************************************
	 */
	private UtilTerceroInternacional() throws Exception {

	}

	/** 
	 * ********************************************************************
	 * @method getInstancia
	 * 		   Metodo clave para ejecutar el patron singleton sobre la 
	 * 		   clase, materializando esta por unica vez y manteniendo una 
	 * 		   sola instancia de esta
	 * @return UtilTerceroInternacional
	 * 		   Tipo referente a la misma clase
	 * @throws Exception
	 *		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author hector.cuenca
	 * @date   4/04/2018
	 * ********************************************************************
	 */
	public static UtilTerceroInternacional getInstancia() throws Exception {

		if (instance == null) {

			instance = new UtilTerceroInternacional();
		}

		return instance;
	}
	
	/** 
	 * ********************************************************************
	 * @method	validarTercero
	 * 		  	metodo que valida las configuraciones del tercero, permite 
	 * 			su creacion , actualizacion, validacion biometrica y captura 
	 * 			de imagenes.
	 * @param 	pObjDtoValidarTercero
	 * 			Dto con los datos necesarios para la validación
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author	roberth.martinez
	 * @date	25/05/2018
	 * *********************************************************************
	 */
	public void validarTercero	(	ValidarTerceroInternacionalDTO pObjDtoValidarTercero	)
		throws Exception
	{
		System.out.println("isBooEnviarFotos:"+pObjDtoValidarTercero.getObjTercero().getObjDtoConfigTerceroInternacional().isBooEnviarFotos());
		System.out.println("isBooEnviarHuella:"+pObjDtoValidarTercero.getObjTercero().getObjDtoConfigTerceroInternacional().isBooEnviarHuella());
		System.out.println("isBooEnviarImagenHuella:"+pObjDtoValidarTercero.getObjTercero().getObjDtoConfigTerceroInternacional().isBooEnviarImagenHuella());
		System.out.println("isBooTerceroNuevo:"+pObjDtoValidarTercero.getObjTercero().getObjDtoConfigTerceroInternacional().isBooTerceroNuevo());
		System.out.println("getObjBooActualizaClienteUsuario:"+pObjDtoValidarTercero.getObjTercero().getObjDtoConfigTerceroInternacional().getObjBooActualizaClienteUsuario());
//		pObjDtoValidarTercero.getObjTercero().getObjDtoConfigTerceroInternacional().setObjBooActualizaClienteUsuario(true);
		
		if	(	this.validarDespliegueMantenimientoTercero(pObjDtoValidarTercero)	)
		{
			booProcesoValidarTercero = UtilBiometriaInternacional.getInstancia().validarBiometria	(	pObjDtoValidarTercero.getObjTercero(), 
																										pObjDtoValidarTercero.getFrmForma(), 
																										pObjDtoValidarTercero.getStrIdTransaccion()
																									);
			
			if	(	!booProcesoValidarTercero	)
			{
				/**
				 * TODO GIR_INT
				 * presentar mensaje en pantalla indicando que es necesario realizar este proceso, para continuar con la operacion
				 */
//				pObjDtoValidarTercero.getFrmForma().getEventoForma().regresarFormaPadre();
				throw EnumMensajes.DEBE_REALIZAR_VALIDACION_BIOMETRICA.generarExcepcion(EnumClasesMensaje.ERROR);			
			}
			
		}else if (booProcesoValidarTercero == null) {
			throw EnumMensajes.DEBE_DILIGENCIAR_DATOS_CLIENTE_USUARIO.generarExcepcion(EnumClasesMensaje.ERROR);
		}
		
		/*if	(	booProcesoValidarTercero	&&
				pObjDtoValidarTercero.getObjTercero().getObjDtoConfigTerceroInternacional().isBooEnviaTramaActualizaTercero() &&
				pObjDtoValidarTercero.getObjTercero().getObjDtoConfigTerceroInternacional().getObjBooActualizaClienteUsuario() != null
			)
		{
			//Thread.sleep(3000);
			if (pObjDtoValidarTercero.getObjTercero().getObjDtoConfigTerceroInternacional().getObjBooActualizaClienteUsuario()){
				
				TerceroInternacionalVistaLogica.getInstancia().crearActualizarTerceroCliente(	pObjDtoValidarTercero.getFrmForma().getObjUsuario(), 
																								EnumPeticionesMultiservicio.GIN_CREAR_ACTUALIZAR_TERCERO_CLIENTE.getObjServicioPeticion(), 
																								pObjDtoValidarTercero.getObjTercero(), 
																								pObjDtoValidarTercero.getStrIdTransaccion());
			}else{
				
				TerceroInternacionalVistaLogica.getInstancia().crearActualizarTerceroUsuario(	pObjDtoValidarTercero.getFrmForma().getObjUsuario(), 
																								EnumPeticionesMultiservicio.GIN_CREAR_ACTUALIZAR_TERCERO_USUARIO.getObjServicioPeticion(), 
																								pObjDtoValidarTercero.getObjTercero(), 
																								pObjDtoValidarTercero.getStrIdTransaccion());
			}
			
			
			EnumMensajes.TERCERO_CREADO_ACTUALIZADO_EXITOSO.desplegarMensaje(pObjDtoValidarTercero.getFrmForma(), 
															   	   			 EnumClasesMensaje.INFORMACION);
			
			pObjDtoValidarTercero.getObjTercero().getObjDtoConfigTerceroInternacional().setBooEnviaTramaActualizaTercero(false);
		}*/
		
		
	}
	
	/** 
	 * ********************************************************************
	 * @method	validarDespliegueMantenimientoTercero
	 * 		  	consulta el tercero y valida si es actualizacion o creacion
	 * @param 	pObjDtoValidarTercero
	 * 			Dto con los datos necesarios para la validación
	 * @return	boolean
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author	roberth.martinez
	 * @date	25/05/2018
	 * *********************************************************************
	 */
	private boolean validarDespliegueMantenimientoTercero	(ValidarTerceroInternacionalDTO pObjDtoValidarTercero)
		throws Exception
	{
		FormaActualizarCrearTerceroInternacional frmActualizarCrearTercero;
		boolean booTerceroNuevo;
		boolean booRespuesta = true;
		
		if	(	!pObjDtoValidarTercero.getObjTercero().getObjDtoConfigTerceroInternacional().isBooFormularioDiligenciado())
		{
			booTerceroNuevo = pObjDtoValidarTercero.getObjTercero().getObjDtoConfigTerceroInternacional().isBooTerceroNuevo();
			
			try{
				TerceroInternacionalVistaLogica.getInstancia().consultarTercero	(	pObjDtoValidarTercero.getFrmForma().getObjUsuario(), 
																					EnumPeticionesMultiservicio.GIN_CONSULTAR_TERCERO.getObjServicioPeticion(), 
																					pObjDtoValidarTercero.getObjTercero(), 
																					pObjDtoValidarTercero.getStrIdTransaccion()
																				);
			}catch(ClientePosSlimGirosException cpsge){
				Mensaje objMensaje;
				pObjDtoValidarTercero.getFrmForma().getEventoForma().controlExcepcion(cpsge);
				
				objMensaje = (Mensaje) cpsge.getObjMensaje();
				if (EnumMensajes.TERCERO_INTERNACIONAL_NO_EXISTE.getCodigo().equals(objMensaje.getCodigo())) {
					booTerceroNuevo = true;
				}
			}
			
			if (pObjDtoValidarTercero.getObjTercero().getObjDtoConfigTerceroInternacional().getObjBooActualizaClienteUsuario() != null) {
				booRespuesta = false;
				if	(	booTerceroNuevo	&& !pObjDtoValidarTercero.getObjTercero().getObjDtoConfigTerceroInternacional().isBooNuevoExiste())
				{
					/**
					 * TODO GIR_INT
					 * presentar mensaje en pantalla indicando que se realizara el registro del tercero,
					 * requerido para continuar con el proceso
					 */
					
					frmActualizarCrearTercero = new FormaActualizarCrearTerceroInternacional(	pObjDtoValidarTercero.getFrmForma(), 
																								true, 
																								true, 
																								pObjDtoValidarTercero.getObjTercero().getObjDtoConfigTerceroInternacional(),
																								pObjDtoValidarTercero.getObjTercero().getTipoIdentificacion(),
																								pObjDtoValidarTercero.getObjTercero().getIdentificacion(),
																								pObjDtoValidarTercero.getStrIdTransaccion()
																							);
				}	else	{
					
					/**
					 * TODO GIR_INT
					 * presentar mensaje en pantalla indicando que se realizara la actualizacion de datos del tercero,
					 * requerido para continuar con el proceso
					 */
					
					frmActualizarCrearTercero = new FormaActualizarCrearTerceroInternacional(	pObjDtoValidarTercero.getFrmForma(), 
																								true, 
																								true, 
																								pObjDtoValidarTercero.getObjTercero(),
																								pObjDtoValidarTercero.getStrIdTransaccion()
																							);
				}
				
				if	(	frmActualizarCrearTercero.getEnmBotEncAccionSolicitada().equals(EnumBotonesEncabezado.BTNGUARDAR)	)
				{
					if	(	booTerceroNuevo	)
					{
						pObjDtoValidarTercero.setObjTercero(frmActualizarCrearTercero.getEventoForma().getObjTercero());
						pObjDtoValidarTercero.getObjTercero().getObjDtoConfigTerceroInternacional().setBooFormularioDiligenciado(true);
					}
					pObjDtoValidarTercero.getObjTercero().getObjDtoConfigTerceroInternacional().setBooEnviaTramaActualizaTercero(true);
					
					booProcesoValidarTercero = true;
				}else{
					//debe regresar a la forma anterior
					booProcesoValidarTercero = null;
				}
			}
			
		}	else	{
			booRespuesta = false;
		}
		
		return booRespuesta;
	}
	
}

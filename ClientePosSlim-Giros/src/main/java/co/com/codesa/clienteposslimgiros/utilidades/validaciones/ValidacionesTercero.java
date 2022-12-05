/** 
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
package co.com.codesa.clienteposslimgiros.utilidades.validaciones;

import java.util.Calendar;
import java.util.Date;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.enumeraciones.operaciones.EnumTiposOperaciones;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelTercero;
import co.com.codesa.clienteposslimgiros.formas.mensajes.FormaMensajeAlerta;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.clienteposslimgiros.vista.logica.TerceroVistaLogica;
import co.com.codesa.codesawrapper.modelo.dominio.ParametroSistema;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;


/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 19-mar-2015
 * @clase ValidacionesTercero 
 * 		  Clase encargada de realizar las diferentes validaciones 
 * 		  ejecutadas sobre los terceros en la transaccion
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class ValidacionesTercero {

	private static ValidacionesTercero instancia;

	private ValidacionesTercero(){}	
	
	public static ValidacionesTercero getInstance(){		
		if (instancia == null)
			instancia= new ValidacionesTercero();
		
		return instancia;
	}
	
	public void validacionesPostConsultaTercero(Tercero pObjTerceroValidar,
												EnumTiposOperaciones pEnmTipoOperacion,
												EventoAbstracto pEventoAbstracto,
												FormaPanelTercero pFrmPnlTercero)throws Exception{
		
		boolean booProponeActualizacion = false;
		
		if(EnumTiposOperaciones.ENVIO_FACTURACION.equals(pEnmTipoOperacion)){
		
			if (pObjTerceroValidar.getDescripcion().equals(EnumParametrosApp.DESCRIPCION_TERCERO_REMITENTE.getValorPropiedad()) ||
					pObjTerceroValidar.getDescripcion().equals(EnumParametrosApp.DESCRIPCION_TERCERO_TRAMITADOR.getValorPropiedad())) {
				
				booProponeActualizacion = this.validacionesPostConsultaTerceroRemitenteEnvio(pObjTerceroValidar,
																					 		 pEventoAbstracto,
																					 		 pFrmPnlTercero);
			}
		}
		
		if(booProponeActualizacion){
		
			this.proponerActualizacionInformacionTercero(pObjTerceroValidar,
														 pEventoAbstracto,
														 pFrmPnlTercero);
		}
	}
	
	private boolean validacionesPostConsultaTerceroRemitenteEnvio(Tercero pObjTerceroValidar,
			 													  EventoAbstracto pEventoAbstracto,
			 													  FormaPanelTercero pFrmPnlTercero)throws Exception{
		boolean booProponeActualizacion;
			
		booProponeActualizacion = this.recordarActualizarFechaVencimiento(pObjTerceroValidar,
																  		  pEventoAbstracto,
																  		  pFrmPnlTercero);
		return booProponeActualizacion;
	}
	
	private boolean recordarActualizarFechaVencimiento(Tercero pObjTerceroValidar,
													   EventoAbstracto pEventoAbstracto,
													   FormaPanelTercero pFrmPnlTercero)throws Exception{
		
		boolean booResultado = false;
		
		//aplica solo para documento extranjero PA
		if(pObjTerceroValidar.getTipoIdentificacion().getId().trim().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_PA.getValorPropiedad())){
			
			EnumMensajes.RECORDAR_ACTUALIZAR_FECHAS_PASAPORTE.desplegarMensaje(pEventoAbstracto.getFrmForma(), 
																			   EnumClasesMensaje.INFORMACION,
							   												   pObjTerceroValidar.toStringXDocumento());
			booResultado = true;
		}
		
		return booResultado;
	}
	
	public boolean validacionesXTransaccion(Tercero pObjTerceroValidar, 
									   		EnumTiposOperaciones pEnmTipoOperacion,
									   		EventoAbstracto pEventoAbstracto,
									   		FormaPanelTercero pFrmPnlTercero) throws Exception{
		
		boolean[] arrBooResultado = null;
		boolean booValidado = false;
		boolean booActualizo;
		
		if (pObjTerceroValidar != null 
				&& pObjTerceroValidar.getDescripcion()!=null
				&& !pObjTerceroValidar.getDescripcion().trim().isEmpty()) {
			
			if (pEnmTipoOperacion.equals(EnumTiposOperaciones.ENVIO_FACTURACION)) {
				
				if (pObjTerceroValidar.getDescripcion().equals(EnumParametrosApp.DESCRIPCION_TERCERO_REMITENTE.getValorPropiedad()) ||
						pObjTerceroValidar.getDescripcion().equals(EnumParametrosApp.DESCRIPCION_TERCERO_TRAMITADOR.getValorPropiedad())) {
					
					arrBooResultado = this.validacionesTerceroRemitenteEnvio(pObjTerceroValidar,
   							   												 pEnmTipoOperacion,
   							   												 pEventoAbstracto);
					
				} else if(pObjTerceroValidar.getDescripcion().equals(EnumParametrosApp.DESCRIPCION_TERCERO_BENEFICIARIO.getValorPropiedad())){
					
					arrBooResultado = this.validacionesTerceroBeneficiarioEnvio(pObjTerceroValidar,
									 									   		pEnmTipoOperacion,
									 									   		pEventoAbstracto);
				}
			}else if (pEnmTipoOperacion.equals(EnumTiposOperaciones.PAGO_FACTURACION)) {
				
				if (pObjTerceroValidar.getDescripcion().equals(EnumParametrosApp.DESCRIPCION_TERCERO_REMITENTE.getValorPropiedad())) {
					
					arrBooResultado = this.validacionesTerceroRemitentePago(pObjTerceroValidar,
						   													pEnmTipoOperacion,
						   													pEventoAbstracto);
					
				} else if(pObjTerceroValidar.getDescripcion().equals(EnumParametrosApp.DESCRIPCION_TERCERO_BENEFICIARIO.getValorPropiedad()) ||
							pObjTerceroValidar.getDescripcion().equals(EnumParametrosApp.DESCRIPCION_TERCERO_APODERADO.getValorPropiedad())){
					
					arrBooResultado = this.validacionesTerceroBeneficiarioPago(pObjTerceroValidar,
																			   pEnmTipoOperacion,
																			   pEventoAbstracto);
				}
			}
		}	

		if(arrBooResultado==null || 
				arrBooResultado[0]){//la validacion permite seguir el proceso de pago

			if(arrBooResultado!=null &&
					arrBooResultado[1]){//propone actualizar informacion
				
				booActualizo = this.proponerActualizacionInformacionTercero(pObjTerceroValidar,
																			pEventoAbstracto,
															 				pFrmPnlTercero);
				if(booActualizo){
					
					pObjTerceroValidar = pFrmPnlTercero.castEvaFrmTercero().getObjTercero();
					
					booValidado = this.validacionesXTransaccion(pObjTerceroValidar,
														   		pEnmTipoOperacion,
														   		pEventoAbstracto,
														   		pFrmPnlTercero);
				}
			}else{
				booValidado = true;
			}
			
		}else if(arrBooResultado[1]){//la validacion no permite seguir el proceso de pago, pero ofrece actualizar la informacion
			this.proponerActualizacionInformacionTercero(pObjTerceroValidar,
														 pEventoAbstracto,
														 pFrmPnlTercero);
		}
		
		return booValidado;
	}
	
	private boolean proponerActualizacionInformacionTercero(Tercero pObjTerceroValidar,
															EventoAbstracto pEventoAbstracto,
		 													FormaPanelTercero pFrmPnlTercero)throws Exception{
		FormaMensajeAlerta frmAlerta;

		frmAlerta = EnumMensajes.DESEA_ACTUALIZAR_INFORMACION_TERCERO.desplegarMensaje(pEventoAbstracto.getFrmForma(), 
																		   			   EnumClasesMensaje.CONFIRMACION, 
																		   			   pObjTerceroValidar.getDescripcion(),
																		   			   pObjTerceroValidar.toStringXDocumento());
		if(frmAlerta.isOpcion()){//aceptar mensaje de confirmacion
			
			pFrmPnlTercero.castEvaFrmTercero().desplegarMantenimiento();
		}

		return frmAlerta.isOpcion();
	}
	
	private boolean[] validacionesTerceroBeneficiarioPago(Tercero pObjTerceroValidar, 
														  EnumTiposOperaciones pEnmTipoOperacion,
			   											  EventoAbstracto pEventoAbstracto)throws Exception{
		boolean[] arrBooResultado = null;
		
		
		arrBooResultado = this.validaDireccion(pObjTerceroValidar,
						   					   pEnmTipoOperacion,
						   					   pEventoAbstracto);
		if(arrBooResultado==null){
			arrBooResultado = this.validaFechaExpedicion(pObjTerceroValidar,
						   								 pEnmTipoOperacion,
						   								 pEventoAbstracto);
			if(arrBooResultado==null){
				arrBooResultado = this.validaPaisExpedicion(pObjTerceroValidar,
							 								pEnmTipoOperacion,
							 								pEventoAbstracto);
				if(arrBooResultado==null){
					arrBooResultado = this.validaFechaEntradaPais(pObjTerceroValidar,
																  pEnmTipoOperacion,
																  pEventoAbstracto);
					if(arrBooResultado==null){
						arrBooResultado = this.validaFechaVencimientoDocumento(pObjTerceroValidar,
								  							 				   pEnmTipoOperacion,
								  							 				   pEventoAbstracto);
						if(arrBooResultado==null){
							this.validaFechaNacimientoDocumento(pObjTerceroValidar,
			   													pEnmTipoOperacion,
			   													pEventoAbstracto);
							if(arrBooResultado==null){
								arrBooResultado = this.validaInconsistenciasFechaNacimiento(pObjTerceroValidar,
						 				   													pEnmTipoOperacion,
						 				   													pEventoAbstracto);
								if(arrBooResultado==null){
									arrBooResultado = this.validaCiudadExpedicion(pObjTerceroValidar, 
																				  pEnmTipoOperacion, 
																				  pEventoAbstracto);
									
									if (arrBooResultado==null) {
										arrBooResultado = this.validaActividadEconomica(pObjTerceroValidar, 
																						pEnmTipoOperacion, 
																						pEventoAbstracto);
										
										/*if(arrBooResultado==null){
										//NUEVA VALIDACION
										}*/
									}
								}
							}
						}
					}
				}
			}
		}
		
		return arrBooResultado;
	}
	
	private boolean[] validacionesTerceroRemitentePago(Tercero pObjTerceroValidar, 
													   EnumTiposOperaciones pEnmTipoOperacion,
			   										   EventoAbstracto pEventoAbstracto)throws Exception{
		boolean[] arrBooResultado = null;
		
		//NUEVA_VALIDACION
		
		return arrBooResultado;
	}
	
	private boolean[] validacionesTerceroBeneficiarioEnvio(Tercero pObjTerceroValidar, 
														   EnumTiposOperaciones pEnmTipoOperacion,
														   EventoAbstracto pEventoAbstracto)throws Exception{
		boolean[] arrBooResultado = null;
		
		arrBooResultado = this.validaMenorDeEdadParam(pObjTerceroValidar, 
													  pEnmTipoOperacion,
													  pEventoAbstracto);
		/*if(arrBooResultado == null){
			//NUEVA_VALIDACION
		}*/
		
		return arrBooResultado;
	}
	
	private boolean[] validacionesTerceroRemitenteEnvio(Tercero pObjTerceroValidar, 
														EnumTiposOperaciones pEnmTipoOperacion,
			   											EventoAbstracto pEventoAbstracto)throws Exception{
		boolean[] arrBooResultado = null;
		
		/*arrBooResultado = this.validaMenorEdad(pObjTerceroValidar,
						   					   pStrTipoTransaccion,
						   					   pEventoAbstracto);*/
		if(arrBooResultado==null){
			arrBooResultado = this.validaDireccion(pObjTerceroValidar,
	 				   							   pEnmTipoOperacion,
	 				   							   pEventoAbstracto);
			if(arrBooResultado==null){
				arrBooResultado = this.validaFechaExpedicion(pObjTerceroValidar,
							   								 pEnmTipoOperacion,
							   								 pEventoAbstracto);
				if(arrBooResultado==null){
					arrBooResultado = this.validaPaisExpedicion(pObjTerceroValidar,
								 								pEnmTipoOperacion,
								 								pEventoAbstracto);
					if(arrBooResultado==null){
						arrBooResultado = this.validaFechaEntradaPais(pObjTerceroValidar,
																	  pEnmTipoOperacion,
																	  pEventoAbstracto);
						if(arrBooResultado==null){
							arrBooResultado = this.validaFechaVencimientoDocumento(pObjTerceroValidar,
									  							 				   pEnmTipoOperacion,
									  							 				   pEventoAbstracto);
							if(arrBooResultado==null){
								this.validaFechaNacimientoDocumento(pObjTerceroValidar,
				   													pEnmTipoOperacion,
				   													pEventoAbstracto);
								if(arrBooResultado==null){
									arrBooResultado = this.validaInconsistenciasFechaNacimiento(pObjTerceroValidar,
							 				   													pEnmTipoOperacion,
							 				   													pEventoAbstracto);
									if(arrBooResultado==null){
										arrBooResultado = this.validaCiudadExpedicion(pObjTerceroValidar, 
																					  pEnmTipoOperacion, 
																					  pEventoAbstracto);
										if (arrBooResultado==null) {
											arrBooResultado = this.validaActividadEconomica(pObjTerceroValidar, 
																							pEnmTipoOperacion, 
																							pEventoAbstracto);
											
											/*if(arrBooResultado==null){
											//NUEVA VALIDACION
											}*/
										}
										
									}
								}
							}
						}
					}
				}
			}
		}
		
		return arrBooResultado;
	}
	
	private boolean[] validaDireccion(Tercero pObjTerceroValidar,
									  EnumTiposOperaciones pEnmTipoOperacion,
									  EventoAbstracto pEventoAbstracto)throws Exception{
		
		boolean[] arrBooResultado = null;
		
		if(pObjTerceroValidar.getDireccion()==null ||
				pObjTerceroValidar.getDireccion().trim().isEmpty() ||
				pObjTerceroValidar.getDireccion().trim().equals(EnumParametrosApp.DIRECCION_VACIA.getValorPropiedad())){
			
			EnumMensajes.VALIDA_DIRECCION_TERCERO.desplegarMensaje(pEventoAbstracto.getFrmForma(), 
																   EnumClasesMensaje.ADVERTENCIA, 
																   pObjTerceroValidar.getDescripcion(),
																   pObjTerceroValidar.toStringXDocumento(),
																   pEnmTipoOperacion.toString());
			arrBooResultado = new boolean[] {true, true};
		}
		
		return arrBooResultado;
	}
	
	private boolean[] validaFechaExpedicion(Tercero pObjTerceroValidar,
											EnumTiposOperaciones pEnmTipoOperacion,
											EventoAbstracto pEventoAbstracto)throws Exception{
		
		boolean[] arrBooResultado = null;
		
		//aplica para todos los tipos de documento, excluyendo a NIT
		if(!pObjTerceroValidar.getTipoIdentificacion().getId().trim().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_NIT.getValorPropiedad())){
			
			if(pObjTerceroValidar.getFechaExpedicion()==null ||
					pObjTerceroValidar.getFechaExpedicion().trim().isEmpty() ||
					pObjTerceroValidar.getFechaExpedicion().trim().equals(EnumParametrosApp.FECHA_VACIA.getValorPropiedad())){
				
				EnumMensajes.VALIDA_FECHA_EXPEDICION_DOC_TERCERO.desplegarMensaje(pEventoAbstracto.getFrmForma(), 
																				  EnumClasesMensaje.ADVERTENCIA, 
																				  pObjTerceroValidar.getDescripcion(),
							   													  pObjTerceroValidar.toStringXDocumento(),
							   													  pEnmTipoOperacion.toString());
				arrBooResultado = new boolean[] {true, true};
			}
		}
		
		return arrBooResultado;
	}
	
	private boolean[] validaCiudadExpedicion(Tercero pObjTerceroValidar, 
											 EnumTiposOperaciones pEnmTipoOperacion,
											 EventoAbstracto pEventoAbstracto) throws Exception {

		boolean[] arrBooResultado = null;
		
		// aplica para todos los tipos de documento, excluyendo a CEX, CE, PA
		if (pObjTerceroValidar.getTipoIdentificacion().getId().trim().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_CC.getValorPropiedad()) &&
				pObjTerceroValidar.getTipoIdentificacion().getId().trim().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_TI.getValorPropiedad())) {
			if (pObjTerceroValidar.getLugarExpedicion() == null) {

				EnumMensajes.VALIDA_CIUDAD_EXPEDICION_DOC_TERCERO.desplegarMensaje(pEventoAbstracto.getFrmForma(),
																				  EnumClasesMensaje.ADVERTENCIA, 
																				  pObjTerceroValidar.getDescripcion(),
																				  pObjTerceroValidar.toStringXDocumento(), 
																				  pEnmTipoOperacion.toString());
				arrBooResultado = new boolean[] { true, true };
			}
		}

		

		return arrBooResultado;
	}
	
	private boolean[] validaPaisExpedicion(Tercero pObjTerceroValidar,
										   EnumTiposOperaciones pEnmTipoOperacion,
			  						  	   EventoAbstracto pEventoAbstracto)throws Exception{
		boolean[] arrBooResultado = null;
		
		//aplica solo para documentos extranjeros PA y CE
		if(pObjTerceroValidar.getTipoIdentificacion().getId().trim().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_PA.getValorPropiedad()) ||
				pObjTerceroValidar.getTipoIdentificacion().getId().trim().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_CE.getValorPropiedad())){
			
			if(pObjTerceroValidar.getPaisExpedicion()==null){
				
				EnumMensajes.VALIDA_PAIS_EXPEDICION_DOC_TERCERO.desplegarMensaje(pEventoAbstracto.getFrmForma(), 
																				 EnumClasesMensaje.ADVERTENCIA, 
																				 pObjTerceroValidar.getDescripcion(),
								   												 pObjTerceroValidar.toStringXDocumento(),
								   												 pEnmTipoOperacion.toString());
				arrBooResultado = new boolean[] {true, true};
			}
		}
		
		return arrBooResultado;
	}
	
	private boolean[] validaFechaEntradaPais(Tercero pObjTerceroValidar,
											 EnumTiposOperaciones pEnmTipoOperacion,
		  	   								 EventoAbstracto pEventoAbstracto)throws Exception{
		boolean[] arrBooResultado = null;

		//aplica solo para el documento extranjero PA
		if(pObjTerceroValidar.getTipoIdentificacion().getId().trim().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_PA.getValorPropiedad())){

			if(pObjTerceroValidar.getFechaEntrada()==null ||
					pObjTerceroValidar.getFechaEntrada().trim().isEmpty() ||
					pObjTerceroValidar.getFechaEntrada().trim().equals(EnumParametrosApp.FECHA_VACIA.getValorPropiedad())){

				EnumMensajes.VALIDA_FECHA_ENTRADA_DOC_TERCERO.desplegarMensaje(pEventoAbstracto.getFrmForma(), 
																			   EnumClasesMensaje.ADVERTENCIA, 
																			   pObjTerceroValidar.getDescripcion(),
   												   							   pObjTerceroValidar.toStringXDocumento(),
   												   							   pEnmTipoOperacion.toString());
				arrBooResultado = new boolean[] {true, true};
			}
		}

		return arrBooResultado;
	}
	
	private boolean[] validaFechaVencimientoDocumento(Tercero pObjTerceroValidar,
													  EnumTiposOperaciones pEnmTipoOperacion,
				 								 	  EventoAbstracto pEventoAbstracto)throws Exception{
		boolean[] arrBooResultado = null;

		//aplica solo para el documento extranjero PA
		if(pObjTerceroValidar.getTipoIdentificacion().getId().trim().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_PA.getValorPropiedad())){

			if(pObjTerceroValidar.getFechaVencimiento()==null ||
					pObjTerceroValidar.getFechaVencimiento().trim().isEmpty() ||
					pObjTerceroValidar.getFechaVencimiento().trim().equals(EnumParametrosApp.FECHA_VACIA.getValorPropiedad())){

				EnumMensajes.VALIDA_FECHA_VENCIMIENTO_DOC_TERCERO.desplegarMensaje(pEventoAbstracto.getFrmForma(), 
																				   EnumClasesMensaje.ADVERTENCIA, 
																				   pObjTerceroValidar.getDescripcion(),
						   							   							   pObjTerceroValidar.toStringXDocumento(),
						   							   							   pEnmTipoOperacion.toString());
				arrBooResultado = new boolean[] {true, true};
			}
		}

		return arrBooResultado;
	}
	
	private boolean[] validaInconsistenciasFechaNacimiento(Tercero pObjTerceroValidar,
														   EnumTiposOperaciones pEnmTipoOperacion,
		 	  											   EventoAbstracto pEventoAbstracto)throws Exception{
		boolean[] arrBooResultado = null;
		Calendar calFechaNacimiento;
		Calendar calFechaActual;
		Date datFechaNacimiento;
		int intEdadMayor;

		//aplica solo para los documentos CC y TI
		if(pObjTerceroValidar.getTipoIdentificacion().getId().trim().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_CC.getValorPropiedad()) ||
				pObjTerceroValidar.getTipoIdentificacion().getId().trim().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_TI.getValorPropiedad())){
			
			if(pObjTerceroValidar.getFechaNacimiento()!=null &&
					!pObjTerceroValidar.getFechaNacimiento().trim().isEmpty() &&
					!pObjTerceroValidar.getFechaNacimiento().trim().equals(EnumParametrosApp.FECHA_VACIA.getValorPropiedad())){

				datFechaNacimiento = UtilidadGiros.getInstancia().getFecha((pObjTerceroValidar.getFechaNacimiento()));
				
				calFechaNacimiento=Calendar.getInstance();
				calFechaNacimiento.setTime(datFechaNacimiento);
				
				intEdadMayor = EnumParametrosApp.EDAD_MAYOR.getValorEntero();
				
				calFechaNacimiento.add(Calendar.YEAR,
									   intEdadMayor);
				
				calFechaActual = Calendar.getInstance();
				
				if(pObjTerceroValidar.getTipoIdentificacion().getId().trim().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_CC.getValorPropiedad())){
					
					if(calFechaNacimiento.compareTo(calFechaActual)>0){
						
						arrBooResultado = this.inconsistenciasFechaNacimiento(pObjTerceroValidar,
															  				  pEnmTipoOperacion,
															  				  pEventoAbstracto,
															  				  calFechaActual,
															  				  calFechaNacimiento);
					}
				}else{// tipo documento TI
					
					if(calFechaNacimiento.compareTo(calFechaActual)<=0){
						
						arrBooResultado = this.inconsistenciasFechaNacimiento(pObjTerceroValidar,
				  				  											  pEnmTipoOperacion,
				  				  											  pEventoAbstracto,
				  				  											  calFechaActual,
				  				  											  calFechaNacimiento);
					}
				}
			}
		}

		return arrBooResultado;
	}
	
	private boolean[] validaActividadEconomica(Tercero pObjTerceroValidar, EnumTiposOperaciones pEnmTipoOperacion,
			EventoAbstracto pEventoAbstracto) throws Exception {

		boolean[] arrBooResultado = null;
		String strActividadEconomicaDefault;
		ParametroSistema objParametrosSistemas;

		// solo aplica para los tipos de documentos de  CEX, CE, PA
		if (pObjTerceroValidar.getTipoIdentificacion().getId().trim().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_CEX.getValorPropiedad()) || 
				pObjTerceroValidar.getTipoIdentificacion().getId().trim().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_CE.getValorPropiedad()) || 
					pObjTerceroValidar.getTipoIdentificacion().getId().trim().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_PA.getValorPropiedad()) ||
						pObjTerceroValidar.getTipoIdentificacion().getId().trim().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_NIT.getValorPropiedad())) {
			
			objParametrosSistemas = UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.CODIGO_ACTIVIDAD_ECONOMICA_DEFAULT);
			strActividadEconomicaDefault = objParametrosSistemas.getValor();
			
			if (pObjTerceroValidar.getActividadEconomica().getCodigo().trim().equals(strActividadEconomicaDefault.trim())) {

				EnumMensajes.VALIDA_ACTIVIDAD_ECONOMICA_DOC_TERCERO.desplegarMensaje(pEventoAbstracto.getFrmForma(),
																				   EnumClasesMensaje.ADVERTENCIA, 
																				   pObjTerceroValidar.getDescripcion(),
																				   pObjTerceroValidar.toStringXDocumento(), 
																				   pEnmTipoOperacion.toString());
				
				arrBooResultado = new boolean[] { true, true };
			}
		}

		return arrBooResultado;
	}
	
	private boolean[] inconsistenciasFechaNacimiento(Tercero pObjTerceroValidar,
													 EnumTiposOperaciones pEnmTipoOperacion,
													 EventoAbstracto pEventoAbstracto,
													 Calendar pCalFechaActual,
													 Calendar pCalFechaNacimiento)throws Exception{
		boolean[] arrBooResultado = null;
		ParametroSistema objParCantDiasHabiles;
		int intOlguraPermitida;
		
		
		objParCantDiasHabiles = UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.CANT_DIAS_HABILES_TERCERO_INFO_INCONSISTENTE);
		intOlguraPermitida = Integer.parseInt(objParCantDiasHabiles.getValor());
		
		pCalFechaActual.add(Calendar.DATE, 
						    intOlguraPermitida);
		
		if(pCalFechaNacimiento.compareTo(pCalFechaActual)>0){
			
			EnumMensajes.INCONSISTENCIA_FECHA_NACIMIENTO_DOC_TERCERO.desplegarMensaje(pEventoAbstracto.getFrmForma(), 
																					  EnumClasesMensaje.ERROR, 
																					  pObjTerceroValidar.getDescripcion(),
  									   												  pObjTerceroValidar.toStringXDocumento(),
  									   												  pObjTerceroValidar.getFechaNacimiento(),
  									   												  pEnmTipoOperacion.toString());
			arrBooResultado = new boolean[] {false, false};
			
		}else{
			
			EnumMensajes.PERMITIR_INCONSISTENCIA_FECHA_NACIMIENTO_DOC_TERCERO.desplegarMensaje(pEventoAbstracto.getFrmForma(), 
																							   EnumClasesMensaje.ADVERTENCIA, 
																							   pObjTerceroValidar.getDescripcion(),
											   												   pObjTerceroValidar.toStringXDocumento(),
											   												   pObjTerceroValidar.getFechaNacimiento(),
											   												   String.valueOf(intOlguraPermitida));
			arrBooResultado = new boolean[] {true, false};
		}
		
		return arrBooResultado;
	}
	
	private boolean[] validaFechaNacimientoDocumento(Tercero pObjTerceroValidar,
													 EnumTiposOperaciones pEnmTipoOperacion,
		 	  										 EventoAbstracto pEventoAbstracto)throws Exception{
		boolean[] arrBooResultado = null;

		//aplica solo para el documento TI
		if(pObjTerceroValidar.getTipoIdentificacion().getId().trim().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_TI.getValorPropiedad())){

			if(pObjTerceroValidar.getFechaNacimiento()==null ||
					pObjTerceroValidar.getFechaNacimiento().trim().isEmpty() ||
					pObjTerceroValidar.getFechaNacimiento().trim().equals(EnumParametrosApp.FECHA_VACIA.getValorPropiedad())){

				EnumMensajes.VALIDA_FECHA_NACIMIENTO_DOC_TERCERO.desplegarMensaje(pEventoAbstracto.getFrmForma(), 
																				  EnumClasesMensaje.ADVERTENCIA, 
																				  pObjTerceroValidar.getDescripcion(),
				   							   									  pObjTerceroValidar.toStringXDocumento(),
				   							   									  pEnmTipoOperacion.toString());
				arrBooResultado = new boolean[] {true, true};
			}
		}

		return arrBooResultado;
	}
	
	/*private boolean[] validaMenorEdad(Tercero pObjTerceroValidar,
									  String pStrTipoTransaccion,
									  EventoAbstracto pEventoAbstracto)throws Exception{
		
		boolean[] arrBooResultado = null;
		
		if(pObjTerceroValidar.getTipoIdentificacion().getId().trim().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_TI.getValorCadena())){
			
			EnumMensajes.TIPO_DOC_REMITENTE_NO_VALIDO_PARA_TRANSACCION.desplegarMensaje(pEventoAbstracto.getFrmForma(), 
																					    EnumClasesMensaje.ERROR);
			arrBooResultado = new boolean[] {false, false};
		}
		
		return arrBooResultado;
	}*/
	
	private boolean[] validaMenorDeEdadParam(Tercero pObjTerceroValidar, 
											 EnumTiposOperaciones pEnmTipoOperacion,
											 EventoAbstracto pEventoAbstracto) throws Exception{
		boolean[] arrBooResultado = null;
		ParametroSistema objParEdadMinimaParaReclamarGiro;
		FormaMensajeAlerta frmAlerta;
		Calendar calFechaActual;
		Calendar calFechaNacimiento;
		Date datFechaNacimiento;
		int intEdadMinima;
		
		if(pObjTerceroValidar.getTipoIdentificacion().getId().trim().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_TI.getValorPropiedad())){
			
			objParEdadMinimaParaReclamarGiro = UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.EDAD_MINIMA_PARA_RECLAMAR_GIRO);
			intEdadMinima=Integer.parseInt(objParEdadMinimaParaReclamarGiro.getValor());
			
			if(pObjTerceroValidar.getFechaNacimiento()==null || 
					pObjTerceroValidar.getFechaNacimiento().trim().isEmpty() ||
					pObjTerceroValidar.getFechaNacimiento().equals(EnumParametrosApp.FECHA_VACIA.getValorPropiedad())){
				
				//Exclusivo para TI
				
				frmAlerta = EnumMensajes.VERF_MEN_EDAD_PARAM_SINFECH.desplegarMensaje(pEventoAbstracto.getFrmForma(), 
																		  			  EnumClasesMensaje.CONFIRMACION, 
																		  			  pObjTerceroValidar.getIdentificacion(), 
																		  			  String.valueOf(intEdadMinima));
				if(frmAlerta.isOpcion()){//al aceptar continua la operacion
					arrBooResultado = new boolean[] {true, false};
				}else{//al cancelar, no continua la operacion para que cambie de tercero o verifique la informacion.
					arrBooResultado = new boolean[] {false, false};
				}
				
			}else{//Existe fecha de nacimiento
					
				calFechaActual=Calendar.getInstance();
				
				datFechaNacimiento = UtilidadGiros.getInstancia().getFecha(pObjTerceroValidar.getFechaNacimiento());
										
				calFechaNacimiento=Calendar.getInstance();
				calFechaNacimiento.setTime(datFechaNacimiento);
				
				calFechaNacimiento.add(Calendar.YEAR,intEdadMinima);
				
				if(calFechaNacimiento.compareTo(calFechaActual)>0){
					
					throw EnumMensajes.VERF_MEN_EDAD_PARAM_CONFECH.generarExcepcion(EnumClasesMensaje.ERROR, 
																			  String.valueOf(intEdadMinima));
				}
			}
		}

		return arrBooResultado;
	}
	
	
	/** 
	 * ********************************************************************
	 * @method validarBiometria
	 * 		   metodo utilizado para validacion de biometria al tercero
	 * @param  pFrmPnlTercero
	 * 		   Panel tercero al cual se le validara la biometria
	 * @return boolean
	 *         bandera que indica si el tercero fue validado biometricamente
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author roberth.martinez
	 * @date   25/10/2016
	 * *********************************************************************
	 */
	public boolean validarBiometria(FormaPanelTercero pFrmPnlTercero) throws Exception{
		
		boolean booAptoValidado = false;
		if	(	pFrmPnlTercero.castEvaFrmTercero().getObjTercero() != null	)	
		{
			if (pFrmPnlTercero.castEvaFrmTercero().isBooAplicaBiometria()){
				
				if (pFrmPnlTercero.castEvaFrmTercero().getObjTercero().getObjBiometria().getObjBooApto() == null ||
						(pFrmPnlTercero.castEvaFrmTercero().getObjTercero().getObjBiometria().getObjBooApto() &&
								!pFrmPnlTercero.castEvaFrmTercero().getObjTercero().getObjBiometria().isBooValidadoBiometricamente())) {
					
					pFrmPnlTercero.castEvaFrmTercero().validaDespliegueBiometria();
				}
			}
			
			if	(	pFrmPnlTercero.castEvaFrmTercero().getObjTercero() != null	)	
			{
				if 	(		pFrmPnlTercero.castEvaFrmTercero().getObjTercero().getObjBiometria().getObjBooApto()	!=	null
						&& 	!pFrmPnlTercero.castEvaFrmTercero().getObjTercero().getObjBiometria().getObjBooApto() 
						|| 	pFrmPnlTercero.castEvaFrmTercero().getObjTercero().getObjBiometria().isBooValidadoBiometricamente()
					) 
				{
					booAptoValidado = true;
				}
			}
		}
		
		return booAptoValidado;
	}
	
	/**
     * **************************************************************** 
     * @method validaActualizaCelularTercero
     * 		   metodo utilizado para actualizar el telefono celular
     * 		   del tercero
     * @param  pStrTelefonoInicial
     * 		   telefono original del tercero
     * @param  pTercero
     * 		   objeto tercero a comparar
     * @param  pFrmGenerica
     * 		   Forma desde la que se invoca el metodo
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author Roberth Martinez Vargas
     * ****************************************************************
     */
	public void validaActualizaCelularTercero(String pStrTelefonoInicial, 
											  Tercero pTercero, 
											  FormaGenerica pFrmGenerica) throws Exception{
		
		if (!pTercero.getTelefono2().equals(pStrTelefonoInicial)) {
			
			EnumMensajes.SPC_ACTUALIZA_CEL_TERCERO.desplegarMensaje(pFrmGenerica, 
																	EnumClasesMensaje.INFORMACION, 
																	pTercero.getDescripcion());

			TerceroVistaLogica.getInstance().actualizarTercero(pFrmGenerica.getObjUsuario(),
															   pTercero);
		}
		
		pTercero.setBooActualizoCelular(true);
	}
	
	
	
	
	/**
     * **************************************************************** 
     * @method validaActualizaCelularTerceroCRC
     * 		   metodo utilizado para actualizar el telefono celular
     * 		   del tercero usado solo para CRC
     * @param  pStrTelefonoInicial
     * 		   telefono original del tercero
     * @param  pTercero
     * 		   objeto tercero a comparar
     * @param  pFrmGenerica
     * 		   Forma desde la que se invoca el metodo
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author dsalazar[PlayTech] 
     * @since  09-marzo-2019
     * ****************************************************************
     */
	public void validaActualizaCelularTerceroCRC(String pStrTelefonoInicial, 
											  Tercero pTercero, 
											  FormaGenerica pFrmGenerica) throws Exception{
		
		pTercero.setBooActualizoCelular(false);
		if (!pTercero.getTelefono2().equals(pStrTelefonoInicial)) {
			
			EnumMensajes.SPC_ACTUALIZA_CEL_TERCERO.desplegarMensaje(pFrmGenerica, 
																	EnumClasesMensaje.INFORMACION, 
																	pTercero.getDescripcion());

			TerceroVistaLogica.getInstance().actualizarTercero(pFrmGenerica.getObjUsuario(),
															   pTercero);
			pTercero.setBooActualizoCelular(true);
		}
		
		
	}
}

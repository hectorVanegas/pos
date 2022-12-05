package co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumTiposImpresora;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumVariablesImpresion;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.codesawrapper.modelo.dominio.ParametroSistema;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Agencia;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Concepto;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Empresa;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Promocion;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.VariablesImpresion;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionPagoGiroPostalDTO;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

public class ProcesarVariablesImpresionPagoGiroPostal extends ProcesarVariablesImpresion{

	public ProcesarVariablesImpresionPagoGiroPostal(boolean pBooEsReimpresion,
			  									    EnumTiposImpresora pEnmTipoImpresion)throws Exception{
		super(pBooEsReimpresion, 
			  pEnmTipoImpresion);
	}
	
	@Override
	public VariablesImpresion obtenerVariablesImpresion(VariablesImpresionDTO pObjDtoVariablesImpresion)throws Exception{
		
		VariablesImpresionPagoGiroPostalDTO objDtoVarImpPagoGiroPostal;
		FacturaGiro objFacturaGiro;
		Tercero objTerceroOrigen;
		Tercero objTerceroDestino;
		Tercero objTerceroApoderado;
		Agencia objAgenciaOrigen;
		Agencia objAgenciaDestino;
		Agencia objAgenciaPago;
		Usuario objusuario;
		Empresa objEmpresa;
		
		objDtoVarImpPagoGiroPostal = (VariablesImpresionPagoGiroPostalDTO)pObjDtoVariablesImpresion;
		
		this.evaluaTramaSeguro(objDtoVarImpPagoGiroPostal.getObjFacturaGiro(), 
							   objDtoVarImpPagoGiroPostal.getStrTramaSeguro());
		
		objusuario 			=	objDtoVarImpPagoGiroPostal.getObjUsuario();
		objFacturaGiro 		= 	objDtoVarImpPagoGiroPostal.getObjFacturaGiro();
		objAgenciaOrigen 	= 	objFacturaGiro.getAgenciaOrigen();
		objAgenciaPago 		= 	objFacturaGiro.getAgenciaPago();
		objAgenciaDestino 	= 	objFacturaGiro.getAgenciaDestino();
		objTerceroOrigen 	= 	objFacturaGiro.getTerceroOrigen();
		objTerceroDestino 	= 	objFacturaGiro.getTerceroDestino();
		objTerceroApoderado	=	objFacturaGiro.getObjTerceroApoderado();
		objEmpresa 			= 	objusuario.getEmpresa();
		
		super.modificarVariable(EnumVariablesImpresion.TIPO_REIMPRESION,super.isBooReimpresion());
		
		if (super.getEnmTipoImpresion().equals(EnumTiposImpresora.TIRILLA)) {
			super.adicionarVariable(EnumVariablesImpresion.NOMBRE_EMPRESA, objEmpresa.getNombre().substring(0, objEmpresa.getNombre().length()<15?objEmpresa.getNombre().length():15));
		}else{
			super.adicionarVariable(EnumVariablesImpresion.NOMBRE_EMPRESA, objEmpresa.getNombre());
		}
		super.adicionarVariable(EnumVariablesImpresion.NIT_EMPRESA, objEmpresa.getNit());
		super.adicionarVariable(EnumVariablesImpresion.PAGINA_WEB_EMPRESA, objEmpresa.getUrl());
		super.adicionarVariable(EnumVariablesImpresion.TELEFONO_EMPRESA, objEmpresa.getTelefono());
		super.adicionarVariable(EnumVariablesImpresion.CORREO_ELECTRONICO_EMPRESA, null);
		super.adicionarVariable(EnumVariablesImpresion.DIRECCION_EMPRESA, objEmpresa.getDireccion());
		
		super.adicionarVariable(EnumVariablesImpresion.NOMBRE_REPRESENTANTE_COMERCIAL_EMPRESA, objEmpresa.getRcNombre());
		super.adicionarVariable(EnumVariablesImpresion.NIT_REPRESENTANTE_COMERCIAL_EMPRESA, objEmpresa.getRcNit());
		super.adicionarVariable(EnumVariablesImpresion.TELEFONO_REPRESENTANTE_COMERCIAL_EMPRESA, objEmpresa.getRcTelefono());
		
		super.adicionarVariable(EnumVariablesImpresion.PIN_GIRO, objFacturaGiro.getReferenciaControl());
		
		if	(	super.isBooReimpresion()	)
		{
			super.adicionarVariable(EnumVariablesImpresion.FECHA_TRANSACCION, objFacturaGiro.getFechaGiro());
		}else{
			super.adicionarVariable(EnumVariablesImpresion.FECHA_TRANSACCION, objFacturaGiro.getFechaBD());
		}
		
		super.adicionarVariable(EnumVariablesImpresion.NOTAS, objFacturaGiro.getObjNota().getStrDescripcionImpr());
		super.adicionarVariable(EnumVariablesImpresion.NOMBRE_CAJERO, objusuario.getLogin());
		super.adicionarVariable(EnumVariablesImpresion.FECHA_SISTEMA, objFacturaGiro.getFechaBD());
		
		super.adicionarVariable(EnumVariablesImpresion.NOMBRE_AGENCIA_ORIGEN, objAgenciaOrigen.getNombre());
		super.adicionarVariable(EnumVariablesImpresion.DIRECCION_AGENCIA_ORIGEN, objAgenciaOrigen.getDireccion());
		super.adicionarVariable(EnumVariablesImpresion.TELEFONO_AGENCIA_ORIGEN, objAgenciaOrigen.getTelefonoImpr());
		super.adicionarVariable(EnumVariablesImpresion.NOMBRE_TERCERO_ORIGEN, objTerceroOrigen.toString().toUpperCase());
		super.adicionarVariable(EnumVariablesImpresion.IDENTIFICACION_TERCERO_ORIGEN, objTerceroOrigen.getIdentificacion());
		super.adicionarVariable(EnumVariablesImpresion.TELEFONO_TERCERO_ORIGEN, objTerceroOrigen.getTelefono1());
		super.adicionarVariable(EnumVariablesImpresion.CELULAR_TERCERO_ORIGEN, objTerceroOrigen.getTelefono2());
		
		super.adicionarVariable(EnumVariablesImpresion.NOMBRE_AGENCIA_DESTINO, objAgenciaDestino.getNombre());
		super.adicionarVariable(EnumVariablesImpresion.DIRECCION_AGENCIA_DESTINO, objAgenciaDestino.getDireccion());
		super.adicionarVariable(EnumVariablesImpresion.TELEFONO_AGENCIA_DESTINO, objAgenciaDestino.getTelefonoImpr());
		super.adicionarVariable(EnumVariablesImpresion.NOMBRE_TERCERO_DESTINO, objTerceroDestino.toString().toUpperCase());
		super.adicionarVariable(EnumVariablesImpresion.IDENTIFICACION_TERCERO_DESTINO, objTerceroDestino.getIdentificacion());
		super.adicionarVariable(EnumVariablesImpresion.TELEFONO_TERCERO_DESTINO, objTerceroDestino.getTelefono1());
		super.adicionarVariable(EnumVariablesImpresion.CELULAR_TERCERO_DESTINO, objTerceroDestino.getTelefono2());
		//super.adicionarVariable(EnumVariablesImpresion.MEDIO_ENTREGA, objFacturaGiro.getObjCRCMedioEntrega().getStrTipo()); //Nuevo campo para requerimiento Ticket 471893
		this.medioEntregaInactivo(objFacturaGiro);
		
		super.adicionarVariable(EnumVariablesImpresion.NOMBRE_AGENCIA, objAgenciaPago.getNombre());
		super.adicionarVariable(EnumVariablesImpresion.DIRECCION_AGENCIA, objAgenciaPago.getDireccion());
		super.adicionarVariable(EnumVariablesImpresion.TELEFONO_AGENCIA, objAgenciaPago.getTelefonoImpr());
		super.adicionarVariable(EnumVariablesImpresion.CODIGO_CAJA_ORIGEN, objusuario.getCaja().getCodigo());
		
		this.validaConceptos(objFacturaGiro.getListaConceptos());
		this.validaPromociones(objFacturaGiro.getListPromociones());
		this.validaApoderado(	objTerceroApoderado,
								objTerceroDestino
							);
		this.validaFirmaBiometrica(objFacturaGiro);
		
		this.validaPoliticaTratamientoDatos(objTerceroApoderado, objTerceroDestino);
		
		return super.getObjVariablesImpresion();
	}
	
	/** 
	 * ********************************************************************
	 * @method validaFirmaBiometrica
	 * 		   Valida si en el pago de facturacion se retorno firma 
	 * 	 	   biometrica, y se diligencia la variable para impresion
	 * @param  pObjFacturaGiro
	 * 		   objeto de la facturagiro
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author roberth.martinez
	 * @date   15/11/2016
	 * *********************************************************************
	 */
	private void validaFirmaBiometrica(FacturaGiro pObjFacturaGiro) throws Exception{
		
		String strIdFirmaBiometrica;
		
		if ((pObjFacturaGiro.getTerceroDestino().getObjBiometria().gestionarObjFirmaBiometrica().getStrId().equals("*") && 
				pObjFacturaGiro.getObjTerceroApoderado() == null ) ||
				(pObjFacturaGiro.getObjTerceroApoderado() != null &&
				pObjFacturaGiro.getObjTerceroApoderado().getObjBiometria().gestionarObjFirmaBiometrica().getStrId().equals("*"))) {
			
			super.adicionarVariable(EnumVariablesImpresion.EXISTE_FIRMA_BIOMETRICA, false);
			
		}else{
			
			if (pObjFacturaGiro.getObjTerceroApoderado() != null) {
				
				strIdFirmaBiometrica = pObjFacturaGiro.getObjTerceroApoderado().getObjBiometria().gestionarObjFirmaBiometrica().getStrId();
				
			}else{
				strIdFirmaBiometrica = pObjFacturaGiro.getTerceroDestino().getObjBiometria().gestionarObjFirmaBiometrica().getStrId();
			}
			
			super.adicionarVariable(EnumVariablesImpresion.EXISTE_FIRMA_BIOMETRICA, true);
			super.adicionarVariable(EnumVariablesImpresion.FIRMA_BIOMETRICA, strIdFirmaBiometrica);
		}
	}
	
	private void evaluaTramaSeguro(FacturaGiro pObjFacturaGiro, String strTramaSeguro) throws Exception{
		
		String idConcepMicro;
		
		if	(	!super.isBooReimpresion ()	)
		{
			if (strTramaSeguro != null && !strTramaSeguro.equals("*")) {
				
				idConcepMicro = UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.ID_CONCEPTO_SEGURO_HURTO).getValor();
				
				StringTokenizer stkTramaSeguro = new StringTokenizer(strTramaSeguro, "~");
				while (stkTramaSeguro.hasMoreTokens()) {
					
					StringTokenizer stkSeg2 = new StringTokenizer(stkTramaSeguro.nextToken(), "|");
					stkSeg2.nextToken();
					stkSeg2.nextToken();
					String idConcepto = stkSeg2.nextToken();
					
					if (idConcepto.equals(idConcepMicro)) {
						
						if (pObjFacturaGiro.getObjNota().getStrDescripcion().contains("SIN OBSERVACION")) {
							pObjFacturaGiro.getObjNota().setStrDescripcion(EnumParametrosApp.SPC_GIRO_ASEGURADO_REMITENTE.getObjConstante());
						}
					}
				}
			}
		}
	}
	
	private void validaPromociones(HashMap<String,Promocion> pHmPromociones)throws Exception{
		
		String strGrillaPromociones;
		
		if	(		pHmPromociones == null 
				|| 	pHmPromociones.isEmpty()
			){
		
			super.adicionarVariable(EnumVariablesImpresion.EXISTE_PROMOCIONES, false);
			
		}else{
			
			super.adicionarVariable(EnumVariablesImpresion.EXISTE_PROMOCIONES, true);
			strGrillaPromociones = "";
			
			if (super.getEnmTipoImpresion().equals(EnumTiposImpresora.TIRILLA)) {
				for(Promocion objPromocion : pHmPromociones.values()){
					
					strGrillaPromociones += "LOTERIA;:;"+objPromocion.getAtributo()+";";
					strGrillaPromociones += "NUMERO;:;"+objPromocion.getDato()+";";
				}
			}else{
				for(Promocion objPromocion : pHmPromociones.values()){
					
					strGrillaPromociones += "LOTERIA : "+objPromocion.getAtributo()+" - ";
					strGrillaPromociones += "NUMERO : "+objPromocion.getDato()+";";
				}
			}
			
			super.adicionarVariable(EnumVariablesImpresion.PROMOCIONES, strGrillaPromociones);
		}
	}
	
	private void validaConceptos(List<Concepto> pLstConceptos)throws Exception{
		
		NumberFormat nfFormatoPresentacionDinero;
		String strGrillaConceptos;
		String strValorPresentado;
		String strAplicaSignoPesos;
		double douValorTotal;
		int intLongitudValorPresentado;
		
		if(pLstConceptos!= null 
				&& !pLstConceptos.isEmpty()){
			
			nfFormatoPresentacionDinero = NumberFormat.getNumberInstance(Locale.ENGLISH);
			nfFormatoPresentacionDinero.setMinimumFractionDigits(2);
			
			strGrillaConceptos = "";
			douValorTotal=0;
			
			strAplicaSignoPesos = "";
			if (super.getEnmTipoImpresion().equals(EnumTiposImpresora.TIRILLA)) {
				intLongitudValorPresentado = 15;
			}else{
				intLongitudValorPresentado = 16;
			}
			
			for(Concepto objConcepto : pLstConceptos){
				
				if (objConcepto.isBooAfectaCaja()) {
					
					strGrillaConceptos += objConcepto.getDescripcion()+";:"+";";
					
					strValorPresentado = UtilidadesGiros.getInstance().aplicarLongitudCadena(	strAplicaSignoPesos+nfFormatoPresentacionDinero.format(objConcepto.getValor()), 
																								intLongitudValorPresentado, 
																								false
																							);
					
					strGrillaConceptos += strValorPresentado+";";
					
					douValorTotal += objConcepto.getValor();
				}
			}
			
			strValorPresentado = UtilidadesGiros.getInstance().aplicarLongitudCadena(	strAplicaSignoPesos+nfFormatoPresentacionDinero.format(douValorTotal),
																						intLongitudValorPresentado,
																						false
																					);
			
			strGrillaConceptos = strGrillaConceptos.replaceAll("GIRO POSTAL", "MONTO ENVIADO");
			strGrillaConceptos = strGrillaConceptos.replaceAll("PAGO DE GIRO", "MONTO ENVIADO");
			strGrillaConceptos += "MONTO RECIBIDO;:"+";"+strValorPresentado;
			
			super.adicionarVariable(EnumVariablesImpresion.CONCEPTOS, strGrillaConceptos);
		}
	}
	
	/**
	 * ********************************************************************
	 * @method 	validaApoderado
	 * 		   	Metodo que permite validar la presencia de un tercero 
	 * 		   	apoderado en la operacion de pago de giro
	 * @param 	pObjTerceroApoderado
	 * 			Tercero quien recibe el poder para realizar la operacion de
	 * 			pago de giro en ausencia del tercero destino
	 * @param	pObjTerceroDestino
	 * 			Tercero a quien va dirigido el giro y quien debe presentarse
	 * 			para realizar el pago de este, o tambien puede delegar a otro 
	 * 			tercero para que ejecute esta accion, bajo la figura de 
	 * 			tercero apoderado
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	26/10/2016
	 * *********************************************************************
	 */
	private void validaApoderado(	Tercero pObjTerceroApoderado,
									Tercero pObjTerceroDestino
								)	throws	Exception	{
		
		if	(	pObjTerceroApoderado	==	null	){
			
			super.adicionarVariable(EnumVariablesImpresion.EXISTE_APODERADO, false);
			super.adicionarVariable(EnumVariablesImpresion.NOMBRE_TERCERO, pObjTerceroDestino.toString());
			super.adicionarVariable(EnumVariablesImpresion.IDENTIFICACION_TERCERO, pObjTerceroDestino.getIdentificacion());
			
		}else{
			
			super.adicionarVariable(EnumVariablesImpresion.EXISTE_APODERADO, true);
			super.adicionarVariable(EnumVariablesImpresion.NOMBRE_TERCERO, pObjTerceroApoderado.toString());
			super.adicionarVariable(EnumVariablesImpresion.IDENTIFICACION_TERCERO, pObjTerceroApoderado.getIdentificacion());
		}
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	validaPoliticaTratamientoDatos
	 * 		  	Metodo encargado de realizar la validacion si el proceso se
	 * 			realiza con el APoderado o el Beneficiario con el fin de
	 * 			saber con quien hacer la validacion de imprimir o no texto
	 * 			de tirilla de proteccion de datos
	 * @param pObjTerceroApoderado
	 * 			Tercero apoderado que puede cobrar el giro por el
	 * 			beneficiario real
	 * @param pObjTerceroDestino
	 * 			Tercero Beneficiario del giro 
	 * @throws Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author	stiven.garcia
	 * @date	16/03/2018
	 * *********************************************************************
	 */
	private void validaPoliticaTratamientoDatos(	Tercero pObjTerceroApoderado,
													Tercero pObjTerceroDestino
											   ) 	throws Exception	{
		
		super.adicionarVariable	(	EnumVariablesImpresion.EXISTE_POLITICA,
										(		pObjTerceroDestino.isEstadoPolitica()
											||	(		pObjTerceroApoderado	!=	null
													&&	pObjTerceroApoderado.isEstadoPolitica()
												)
										)
								);	
	}
	
	public void medioEntregaInactivo(FacturaGiro pStrValorParametro) throws Exception {
		
		ParametroSistema psPASI;
		String strSERCOTIR = "";
		
		psPASI = UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.ACTIVA_SERVICIO_PRUEBA_ADMISIONENTREGA_TIRILLA);
		strSERCOTIR = psPASI.getValor();
		
		if (strSERCOTIR.equals("N")) {
			
			pStrValorParametro.getObjCRCMedioEntrega().setStrTipo("");
			super.adicionarVariable(EnumVariablesImpresion.MEDIO_ENTREGA, pStrValorParametro.getObjCRCMedioEntrega().getStrTipo());
			
		} else {
			
			super.adicionarVariable(EnumVariablesImpresion.MEDIO_ENTREGA, pStrValorParametro.getObjCRCMedioEntrega().getStrTipo());
			
		}
		
		if (pStrValorParametro.getObjCRCMedioEntrega().getStrTipo().equals("*")) {
			
			pStrValorParametro.getObjCRCMedioEntrega().setStrTipo("");
			super.adicionarVariable(EnumVariablesImpresion.MEDIO_ENTREGA, pStrValorParametro.getObjCRCMedioEntrega().getStrTipo());
		}
	}

}

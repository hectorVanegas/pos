package co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

import co.com.codesa.clienteposslim.utilidades.Utilidades;
import co.com.codesa.clienteposslim.utilidades.Utilidades;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumTiposImpresora;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumVariablesImpresion;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.clienteposslimgiros.vista.logica.ControlConsultaPasiVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.GiroVistaLogica;
import co.com.codesa.codesawrapper.modelo.dominio.ParametroSistema;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Agencia;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Caja;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ClaveSeguridad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ClaveSeguridadManual;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Concepto;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Documento;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Empresa;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Promocion;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.VariablesImpresion;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionEnvioGiroPostalDTO;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

public class ProcesarVariablesImpresionEnvioGiroPostal extends ProcesarVariablesImpresion{

	public ProcesarVariablesImpresionEnvioGiroPostal(boolean pBooEsReimpresion,
			  									     EnumTiposImpresora pEnmTipoImpresion)throws Exception{
		super(pBooEsReimpresion,
			  pEnmTipoImpresion);
	}
	
	@Override
	public VariablesImpresion obtenerVariablesImpresion(VariablesImpresionDTO pObjDtoVariablesImpresion)throws Exception{
		
		VariablesImpresionEnvioGiroPostalDTO objDtoVarImpEnvioGiroPostal;
		FacturaGiro objFacturaGiro;
		Documento objDocumento;
		Tercero objTerceroOrigen;
		Tercero objTerceroDestino;
		Tercero objTerceroTramitador;
		Agencia objAgenciaOrigen;
		Agencia objAgenciaDestino;
		Caja objCajaOrigen;
		Usuario objUsuario;
		Empresa objEmpresa;
		ClaveSeguridad objClaveSeguridad;
		
		objDtoVarImpEnvioGiroPostal = (VariablesImpresionEnvioGiroPostalDTO)pObjDtoVariablesImpresion;
		
		objUsuario = objDtoVarImpEnvioGiroPostal.getObjUsuario();
		//this.evaluaTramaSeguro(objDtoVarImpEnvioGiroPostal.getObjFacturaGiro(), objDtoVarImpEnvioGiroPostal.getStrTramaSeguro());//En la impresion y reimpresion no se imprime la nota del seguro
		objFacturaGiro = objDtoVarImpEnvioGiroPostal.getObjFacturaGiro();
		objDocumento = objFacturaGiro.getDocumento();
		objAgenciaOrigen = objFacturaGiro.getAgenciaOrigen();
		objAgenciaDestino = objFacturaGiro.getAgenciaDestino();
		objCajaOrigen = objUsuario.getCaja();
		objTerceroOrigen = objFacturaGiro.getTerceroOrigen();
		objTerceroDestino = objFacturaGiro.getTerceroDestino();
		objTerceroTramitador = objFacturaGiro.getTerceroTramitador();
		objEmpresa = objUsuario.getEmpresa();
		objClaveSeguridad = objFacturaGiro.getObjClaveSeguridad();
		
		this.validarReimpresion	(	objUsuario,
									objFacturaGiro
								);
		
		super.modificarVariable(EnumVariablesImpresion.TIPO_REIMPRESION,super.isBooReimpresion());
		
		if (super.getEnmTipoImpresion().equals(EnumTiposImpresora.TIRILLA)) {
			super.adicionarVariable(EnumVariablesImpresion.NOMBRE_EMPRESA, objEmpresa.getNombre().substring(0, objEmpresa.getNombre().length()<15?objEmpresa.getNombre().length():15));
			super.adicionarVariable(EnumVariablesImpresion.NOMBRE_REPRESENTANTE_COMERCIAL_EMPRESA, objEmpresa.getRcNombre().substring(0,objEmpresa.getRcNombre().length()<38?objEmpresa.getRcNombre().length():38));
		}else{
			super.adicionarVariable(EnumVariablesImpresion.NOMBRE_EMPRESA, objEmpresa.getNombre());
			super.adicionarVariable(EnumVariablesImpresion.NOMBRE_REPRESENTANTE_COMERCIAL_EMPRESA, objEmpresa.getRcNombre());
		}
		
		super.adicionarVariable(EnumVariablesImpresion.NIT_EMPRESA, objEmpresa.getNit());
		super.adicionarVariable(EnumVariablesImpresion.PAGINA_WEB_EMPRESA, objEmpresa.getUrl());
		super.adicionarVariable(EnumVariablesImpresion.TELEFONO_EMPRESA, objEmpresa.getTelefono());
		super.adicionarVariable(EnumVariablesImpresion.CORREO_ELECTRONICO_EMPRESA, null);
		super.adicionarVariable(EnumVariablesImpresion.DIRECCION_EMPRESA, objEmpresa.getDireccion());
		
		super.adicionarVariable(EnumVariablesImpresion.NIT_REPRESENTANTE_COMERCIAL_EMPRESA, objEmpresa.getRcNit());
		super.adicionarVariable(EnumVariablesImpresion.TELEFONO_REPRESENTANTE_COMERCIAL_EMPRESA, objEmpresa.getRcTelefono());
		
		super.adicionarVariable(EnumVariablesImpresion.ABREVIATURA_DOCUMENTO, objDocumento.getAbreviatura());
		super.adicionarVariable(EnumVariablesImpresion.INICIO_DOCUMENTO, objDocumento.getInicio());
		super.adicionarVariable(EnumVariablesImpresion.FIN_DOCUMENTO, objDocumento.getFin());
		super.adicionarVariable(EnumVariablesImpresion.RESOLUCION_DOCUMENTO, objDocumento.getResolucion());
		
		super.adicionarVariable(EnumVariablesImpresion.PIN_GIRO, objFacturaGiro.getReferenciaControl());
		super.adicionarVariable(EnumVariablesImpresion.NUMERO_FACTURA, objFacturaGiro.getNumero());
		super.adicionarVariable(EnumVariablesImpresion.FECHA_TRANSACCION, objFacturaGiro.getFechaGiro());
		super.adicionarVariable(EnumVariablesImpresion.NOTAS, objFacturaGiro.getObjNota().getStrDescripcionImpr());
		super.adicionarVariable(EnumVariablesImpresion.NOMBRE_CAJERO, objUsuario.getLogin());
		super.adicionarVariable(EnumVariablesImpresion.FECHA_SISTEMA, objFacturaGiro.getFechaBD());
		
		super.adicionarVariable(EnumVariablesImpresion.NOMBRE_AGENCIA_ORIGEN, objAgenciaOrigen.getNombre());
		super.adicionarVariable(EnumVariablesImpresion.DIRECCION_AGENCIA_ORIGEN, objAgenciaOrigen.getDireccion());
		super.adicionarVariable(EnumVariablesImpresion.TELEFONO_AGENCIA_ORIGEN, objAgenciaOrigen.getTelefonoImpr());
		super.adicionarVariable(EnumVariablesImpresion.CODIGO_CAJA_ORIGEN, objCajaOrigen.getCodigo());
		super.adicionarVariable(EnumVariablesImpresion.NOMBRE_TERCERO_ORIGEN, objTerceroOrigen.toString().toUpperCase());
		super.adicionarVariable(EnumVariablesImpresion.IDENTIFICACION_TERCERO_ORIGEN, objTerceroOrigen.getIdentificacion());
		super.adicionarVariable(EnumVariablesImpresion.TELEFONO_TERCERO_ORIGEN, objTerceroOrigen.getTelefono1());
		super.adicionarVariable(EnumVariablesImpresion.CELULAR_TERCERO_ORIGEN, objTerceroOrigen.getTelefono2());
		//super.adicionarVariable(EnumVariablesImpresion.CORREO_TERCERO_ORIGEN, objTerceroOrigen.getMail());
		
		super.adicionarVariable(EnumVariablesImpresion.NOMBRE_AGENCIA_DESTINO, objAgenciaDestino.getNombre());
		super.adicionarVariable(EnumVariablesImpresion.DIRECCION_AGENCIA_DESTINO, objAgenciaDestino.getDireccion());
		super.adicionarVariable(EnumVariablesImpresion.TELEFONO_AGENCIA_DESTINO, objAgenciaDestino.getTelefonoImpr());
		super.adicionarVariable(EnumVariablesImpresion.NOMBRE_TERCERO_DESTINO, objTerceroDestino.toString().toUpperCase());
		super.adicionarVariable(EnumVariablesImpresion.IDENTIFICACION_TERCERO_DESTINO, objTerceroDestino.getIdentificacion());
		super.adicionarVariable(EnumVariablesImpresion.TELEFONO_TERCERO_DESTINO, objTerceroDestino.getTelefono1());
		super.adicionarVariable(EnumVariablesImpresion.CELULAR_TERCERO_DESTINO, objTerceroDestino.getTelefono2());
		//super.adicionarVariable(EnumVariablesImpresion.CORREO_TERCERO_DESTINO, objTerceroDestino.getMail());
		//super.adicionarVariable(EnumVariablesImpresion.MEDIO_ENTREGA, objFacturaGiro.getObjCRCMedioEntrega().getStrTipo());
		this.medioEntregaInactivo(objFacturaGiro);
		
		this.validaCorreoTerceros(objTerceroOrigen, objTerceroDestino);
		this.validaConceptos(objFacturaGiro.getListaConceptos());
		this.validaPromociones(objFacturaGiro.getListPromociones());
		this.validaClaveSeguridad(objClaveSeguridad);
		this.validaFirmaBiometrica(objFacturaGiro);
		this.validaPoliticaTratamiento(objTerceroTramitador,objTerceroOrigen);
		
		return super.getObjVariablesImpresion();
	}
	
	private void validarReimpresion	(	Usuario pObjUsuario,
										FacturaGiro pObjFacturaGiro
									)
		throws Exception
	{
		boolean booValidaZona;
		String strValidaEstadoGiro;
		String strTipoGiro;
		String strProducto;
		
		if	(	super.isBooReimpresion()	)
		{
			EnumParametrosApp enmParAppEstadoAnulado = EnumParametrosApp.COD_DAT_ENT_ESGI_ANULADO;
			booValidaZona = false;
			strValidaEstadoGiro = "2";
			strTipoGiro = "1";
			strProducto = "1";
			
			pObjFacturaGiro	=	GiroVistaLogica.getInstance().consultaGiroPorReferencia	(	pObjUsuario,
																							pObjFacturaGiro.getReferenciaControl(),
																							booValidaZona,
																							strValidaEstadoGiro,
																							strTipoGiro,
																							strProducto
																						);
			if	(		pObjFacturaGiro.getEstado()	!=	null	
					&&	pObjFacturaGiro.getEstado().getId().equals(enmParAppEstadoAnulado.getValorPropiedad())
				)
			{
				throw EnumMensajes.NO_REIMPRIME_POR_ESTADO_GIRO.generarExcepcion(	EnumClasesMensaje.ERROR, 
																					pObjFacturaGiro.getReferenciaControl(),
																					enmParAppEstadoAnulado.getObjConstante()
																				);
			}
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method validaFirmaBiometrica
	 * 		   Valida si en el envio facturacion se retorno firma 
	 * 	 	   biometrica, y se diligencia la variable para impresion
	 * @param  pObjFacturaGiro
	 * 		   objeto de la facturagiro
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author roberth.martinez
	 * @date   10/11/2016
	 * *********************************************************************
	 */
	private void validaFirmaBiometrica(FacturaGiro pObjFacturaGiro) throws Exception{

		String strIdFirmaBiometrica;

		if	(		pObjFacturaGiro.getTerceroTramitador()!=null
				&&	!pObjFacturaGiro.getTerceroTramitador().equals(pObjFacturaGiro.getTerceroOrigen())
        		||	pObjFacturaGiro.getTerceroOrigen().getObjBiometria().gestionarObjFirmaBiometrica().getStrId().equals("*")
        	)
        {
        	super.adicionarVariable(EnumVariablesImpresion.EXISTE_FIRMA_BIOMETRICA, false);

        }	else	{
        	/*
            if	(	pObjFacturaGiro.getTerceroTramitador() != null 
            		&&	pObjFacturaGiro.getTerceroTramitador().getObjBiometria().isBooValidadoBiometricamente()) 
            {
                strIdFirmaBiometrica = pObjFacturaGiro.getTerceroTramitador().getObjBiometria().gestionarObjFirmaBiometrica().getStrId();
                
            }	else	{
            */
                strIdFirmaBiometrica = pObjFacturaGiro.getTerceroOrigen().getObjBiometria().gestionarObjFirmaBiometrica().getStrId();
            //}

            super.adicionarVariable(EnumVariablesImpresion.EXISTE_FIRMA_BIOMETRICA, true);
            super.adicionarVariable(EnumVariablesImpresion.FIRMA_BIOMETRICA, strIdFirmaBiometrica);
        }
    }
	
	private void validaClaveSeguridad(ClaveSeguridad pObjClaveSeguridad)throws Exception{
		
		if (pObjClaveSeguridad == null 
				||	!(pObjClaveSeguridad instanceof ClaveSeguridadManual)) {
			
			super.adicionarVariable(EnumVariablesImpresion.EXISTE_CLAVE_SEGURIDAD, false);
			
		}else{
			
			super.adicionarVariable(EnumVariablesImpresion.EXISTE_CLAVE_SEGURIDAD, true);
			super.adicionarVariable(EnumVariablesImpresion.CLAVE_SEGURIDAD, ((ClaveSeguridadManual)pObjClaveSeguridad).getStrClave());
		}
	}
	
	private void evaluaTramaSeguro(FacturaGiro pObjFacturaGiro, String strTramaSeguro) throws Exception{
		
		String idConcepMicro;
		
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
		String strResumenTotal;
		double douValorTotal;
		int intLongitudValorPresentado;
		boolean booTodosAplican;
		Concepto objConcepto;
		Concepto objConceptoDomicilio;
		
		nfFormatoPresentacionDinero = NumberFormat.getNumberInstance(Locale.ENGLISH);
		nfFormatoPresentacionDinero.setMinimumFractionDigits(2);
		
		if(pLstConceptos!= null 
				&& !pLstConceptos.isEmpty()){
			
			nfFormatoPresentacionDinero = NumberFormat.getNumberInstance(Locale.ENGLISH);
			nfFormatoPresentacionDinero.setMinimumFractionDigits(2);
			
			strGrillaConceptos = "";
			douValorTotal=0;
			
			if (super.getEnmTipoImpresion().equals(EnumTiposImpresora.TIRILLA)) {
				intLongitudValorPresentado = 15;
				strAplicaSignoPesos = "";
				booTodosAplican=false;
				strResumenTotal = "VALOR RECIBIDO";
			}else{
				intLongitudValorPresentado = 16;
				strAplicaSignoPesos = "$";
				booTodosAplican=true;
				strResumenTotal = "TOTAL";
			}
			
			if	(	super.isBooReimpresion()	)
			{
				for	(	int i=pLstConceptos.size()-1;i>=0;i--	)	
				{
					objConcepto = pLstConceptos.get(i);
					
					if	(		objConcepto.getStrIdAfectaCaja().equals(Concepto.ID_AFECTA_CAJA) 
							&&	(		objConcepto.getValor() > 0
									||	booTodosAplican
								)
						) 
					{
						strGrillaConceptos += objConcepto.getDescripcion()+";:"+";";
						
						strValorPresentado = UtilidadesGiros.getInstance().aplicarLongitudCadena(	strAplicaSignoPesos+nfFormatoPresentacionDinero.format(objConcepto.getValor()), 
																									intLongitudValorPresentado, 
																									false
																								);
						strGrillaConceptos += strValorPresentado+";";
						
						douValorTotal += objConcepto.getValor();
					}
				}
			}	else	{
			
				objConceptoDomicilio = new Concepto();
				objConceptoDomicilio.setCodigo("17");
				objConceptoDomicilio = pLstConceptos.remove(pLstConceptos.indexOf(objConceptoDomicilio));
				pLstConceptos.add(objConceptoDomicilio);
				
				for	(	int i=0;i< pLstConceptos.size();i++	)
				{
					objConcepto = pLstConceptos.get(i);
					
					if	(		objConcepto.getStrIdAfectaCaja().equals(Concepto.ID_AFECTA_CAJA) 
							&&	(		objConcepto.getValor() > 0
									||	booTodosAplican
								)
						) 
					{
						strGrillaConceptos += objConcepto.getDescripcion()+";:"+";";
						
						strValorPresentado = UtilidadesGiros.getInstance().aplicarLongitudCadena(	strAplicaSignoPesos+nfFormatoPresentacionDinero.format(objConcepto.getValor()), 
																									intLongitudValorPresentado, 
																									false
																								);
						strGrillaConceptos += strValorPresentado+";";
						
						douValorTotal += objConcepto.getValor();
					}
				}
			}
			
			strValorPresentado = UtilidadesGiros.getInstance().aplicarLongitudCadena(	strAplicaSignoPesos+nfFormatoPresentacionDinero.format(douValorTotal),
																						intLongitudValorPresentado,
																						false
																					);
			strGrillaConceptos = strGrillaConceptos.replaceAll("GIRO POSTAL", "VALOR DEL GIRO");
			strGrillaConceptos = strGrillaConceptos.replaceAll("FLETE", "VALOR DEl FLETE");
			strGrillaConceptos += strResumenTotal+";:"+";"+strValorPresentado;
			
			super.adicionarVariable(EnumVariablesImpresion.CONCEPTOS, strGrillaConceptos);
		}
	}
	
	/**
	 * ********************************************************************
	 * @method	validaPoliticaTratamiento
	 * 		  	
	 * @param objTerceroTramitador
	 * 			Tercero que realiza el proceso de envio de giro representando a 
	 * 			al tercero remitente real del giro nacional
	 * @param objTerceroOrigen
	 * 			Tercero Remitente de la transaccion 
	 * @throws Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author	stiven.garcia
	 * @date	16/03/2018
	 * *********************************************************************
	 */
	private void validaPoliticaTratamiento(Tercero objTerceroTramitador, Tercero objTerceroOrigen) throws Exception{
		
		super.adicionarVariable	(	EnumVariablesImpresion.EXISTE_POLITICA,
										(		objTerceroOrigen.isEstadoPolitica()
											||	(		objTerceroTramitador	!=	null
													&&	objTerceroTramitador.isEstadoPolitica()
												)
										)
								);
	}
	
	
	/**
	 * ********************************************************************
	 * @method	validaCorreoTerceros
	 * 		  	
	 * @param pObjTerceroOrigen, pObjTerceroDestino
	 * 			Tercero que realiza el proceso de envio de giro representando a 
	 * 			al tercero remitente real del giro nacional
	 * @param objTerceroOrigen
	 * 			Tercero Remitente de la transaccion 
	 * @throws Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author	stiven.garcia
	 * @date	16/03/2018
	 * *********************************************************************
	 */
	private void validaCorreoTerceros(	Tercero pObjTerceroOrigen, 
									  	Tercero pObjTerceroDestino
									 ) throws Exception {
		
		Tercero objTerceroOrigen = pObjTerceroOrigen;
		Tercero objTerceroDestino = pObjTerceroDestino;
		ParametroSistema psPASI;
		String strMARCCODE = "";
		String mail = "";
		
		/*psPASI = UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.VALOR_CORREOS_TERCEROS_NO_SUMINISTRADO_CRC);
		strMARCCODE = psPASI.getValor();*/
		
		strMARCCODE = ControlConsultaPasiVistaLogica.getInstance().getMarccode();
		
		if (objTerceroOrigen.getMail().equals("*") || objTerceroOrigen.getMail().equals("@") || objTerceroOrigen.getMail().equals(""))	{
			
			objTerceroOrigen.setMail(strMARCCODE);
			
		}
					
		if (objTerceroDestino.getMail().equals("*") || objTerceroDestino.getMail().equals("@") || objTerceroDestino.getMail().equals(""))	{
			
			objTerceroDestino.setMail(strMARCCODE);
			
		}
		  
		////En caso que el tercero tenga correo esta sera enmascarado en la tirrilla
		if(!objTerceroOrigen.getMail().equals(strMARCCODE))
		{
			mail = UtilidadesGiros.proteccionInfo(objTerceroOrigen.getMail(), 0);
			objTerceroOrigen.setMail(mail);
		}
		
		if(!objTerceroDestino.getMail().equals(strMARCCODE))
		{
			mail = UtilidadesGiros.proteccionInfo(objTerceroDestino.getMail(), 0);
			objTerceroDestino.setMail(mail);
		}
			
		super.adicionarVariable(EnumVariablesImpresion.CORREO_TERCERO_ORIGEN, objTerceroOrigen.getMail());
		super.adicionarVariable(EnumVariablesImpresion.CORREO_TERCERO_DESTINO, objTerceroDestino.getMail());
		
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

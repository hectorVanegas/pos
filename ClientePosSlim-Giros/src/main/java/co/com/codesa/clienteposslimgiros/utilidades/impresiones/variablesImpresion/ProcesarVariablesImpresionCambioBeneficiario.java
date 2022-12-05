package co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion;

import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import co.com.codesa.clienteposslim.utilidades.Utilidades;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumTiposImpresora;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumVariablesImpresion;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.integracion.slimGiros.UtilIntegracionSlimGiros;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.clienteposslimgiros.vista.logica.ControlConsultaPasiVistaLogica;
import co.com.codesa.codesawrapper.modelo.dominio.ParametroSistema;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Agencia;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ClaveSeguridad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ClaveSeguridadManual;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Concepto;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Empresa;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.VariablesImpresion;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionCambioBeneficiarioDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionDTO;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

public class ProcesarVariablesImpresionCambioBeneficiario extends ProcesarVariablesImpresion{

	public ProcesarVariablesImpresionCambioBeneficiario(boolean pBooEsReimpresion,
														EnumTiposImpresora pEnmTipoImpresion)throws Exception{
		super(pBooEsReimpresion,
			  pEnmTipoImpresion);
	}
	
	@SuppressWarnings("deprecation")
	public VariablesImpresion obtenerVariablesImpresion(VariablesImpresionDTO pObjDtoVariablesImpresion)throws Exception{
		
		VariablesImpresionCambioBeneficiarioDTO objDtoVarImpCambioBeneficiario;
		FacturaGiro objFacturaGiro;
		Agencia objAgenciaOrigen;
		Agencia objAgenciaDestino;
		Tercero objTerceroOrigen;
		Tercero objTerceroDestino;
		Tercero objTerceroNuevo;
		ClaveSeguridad objClaveSeguridad;
		Usuario objusuario;
		Empresa objEmpresa;
		NumberFormat nfFormatoPresentacionDinero;
		String strFechaCompleta;
		String strClaveSeguriad;
		String strValorEnvioGiro;
		String strValorFlete;
		int intLongitudValorPresentado;
		
		objDtoVarImpCambioBeneficiario = (VariablesImpresionCambioBeneficiarioDTO)pObjDtoVariablesImpresion;
		
		objusuario 	=	objDtoVarImpCambioBeneficiario.getObjUsuario();
		objFacturaGiro = objDtoVarImpCambioBeneficiario.getObjFactura();
		objTerceroNuevo = objDtoVarImpCambioBeneficiario.getObjTerceroNuevo();
		objAgenciaOrigen = objFacturaGiro.getAgenciaOrigen();
		objAgenciaDestino = objFacturaGiro.getAgenciaDestino();
		objTerceroOrigen = objFacturaGiro.getTerceroOrigen();
		objTerceroDestino = objFacturaGiro.getTerceroDestino();
		strFechaCompleta = UtilidadGiros.getInstancia().getFecha(UtilIntegracionSlimGiros.getInstance().obtenerFechaHoraActualPosSlim(),UtilidadGiros.getInstancia().getFORMATEADOR_FECHA_GUION_COMPLETO());
		objClaveSeguridad = objFacturaGiro.getObjClaveSeguridad();
		objEmpresa 			= 	objusuario.getEmpresa();
		
		nfFormatoPresentacionDinero = NumberFormat.getNumberInstance(Locale.ENGLISH);
		nfFormatoPresentacionDinero.setMinimumFractionDigits(2);
		
		strValorEnvioGiro = nfFormatoPresentacionDinero.format(objFacturaGiro.getTotal());
		strValorFlete = nfFormatoPresentacionDinero.format(Double.parseDouble(objFacturaGiro.getValorFlete()));
		
		this.validaCorreoTerceros(objTerceroOrigen, objTerceroDestino, objTerceroNuevo);
		
		super.modificarVariable(EnumVariablesImpresion.TIPO_REIMPRESION,super.isBooReimpresion());
		if (super.getEnmTipoImpresion().equals(EnumTiposImpresora.TIRILLA)) {
			super.adicionarVariable(EnumVariablesImpresion.NOMBRE_EMPRESA, objEmpresa.getNombre().substring(0, objEmpresa.getNombre().length()<15?objEmpresa.getNombre().length():15));
			
			intLongitudValorPresentado = 15;
			
			strValorEnvioGiro = UtilidadesGiros.getInstance().aplicarLongitudCadena (	strValorEnvioGiro, 
																						intLongitudValorPresentado, 
																						false
																					);
			strValorFlete = UtilidadesGiros.getInstance().aplicarLongitudCadena (	strValorFlete, 
																					intLongitudValorPresentado, 
																					false
																				);
			
		}else{
			super.adicionarVariable(EnumVariablesImpresion.NOMBRE_EMPRESA, objEmpresa.getNombre());
		}
		super.adicionarVariable(EnumVariablesImpresion.NIT_EMPRESA, objEmpresa.getNit());
		super.adicionarVariable(EnumVariablesImpresion.PAGINA_WEB_EMPRESA, objEmpresa.getUrl());
		super.adicionarVariable(EnumVariablesImpresion.TELEFONO_EMPRESA, objEmpresa.getTelefono());
		super.adicionarVariable(EnumVariablesImpresion.DPR_TELEFONO_EMPRESACB, objEmpresa.getTelefono());
		super.adicionarVariable(EnumVariablesImpresion.CORREO_ELECTRONICO_EMPRESA, null);
		super.adicionarVariable(EnumVariablesImpresion.DIRECCION_EMPRESA, objEmpresa.getDireccion());
		
		super.adicionarVariable(EnumVariablesImpresion.PIN_GIRO, objFacturaGiro.getReferenciaControl());
		super.adicionarVariable(EnumVariablesImpresion.DPR_PIN, objFacturaGiro.getReferenciaControl());
		super.adicionarVariable(EnumVariablesImpresion.NUMERO_FACTURA, objFacturaGiro.getNumero());
		super.adicionarVariable(EnumVariablesImpresion.DPR_FACTURA_VENTA, objFacturaGiro.getNumero());
		super.adicionarVariable(EnumVariablesImpresion.FECHA_TRANSACCION, strFechaCompleta);
		super.adicionarVariable(EnumVariablesImpresion.DPR_FECHA_CAMBIO, strFechaCompleta);
		super.adicionarVariable(EnumVariablesImpresion.NOMBRE_AGENCIA_ORIGEN, objAgenciaOrigen.getNombre());
		super.adicionarVariable(EnumVariablesImpresion.DPR_NOMBRE_OFICINA_ORIGEN, objAgenciaOrigen.getNombre());
		super.adicionarVariable(EnumVariablesImpresion.VALOR_ENVIO_GIRO, strValorEnvioGiro);
		super.adicionarVariable(EnumVariablesImpresion.VALOR_FLETE, strValorFlete);
		super.adicionarVariable(EnumVariablesImpresion.NOMBRE_AGENCIA_DESTINO, objAgenciaDestino.getNombre());
		super.adicionarVariable(EnumVariablesImpresion.DPR_NOMBRE_OFICINA_DESTINO, objAgenciaDestino.getNombre());
		
		super.adicionarVariable(EnumVariablesImpresion.NOMBRE_TERCERO_ORIGEN, objTerceroOrigen.toString());
		super.adicionarVariable(EnumVariablesImpresion.DPR_NOMBRE_TERC_ORIG, objTerceroOrigen.toString());
		super.adicionarVariable(EnumVariablesImpresion.IDENTIFICACION_TERCERO_ORIGEN, objTerceroOrigen.getIdentificacion());
		super.adicionarVariable(EnumVariablesImpresion.DPR_IDENTIFICACION_TERC_ORIG, objTerceroOrigen.getIdentificacion());
		super.adicionarVariable(EnumVariablesImpresion.DIRECCION_TERCERO_ORIGEN, objTerceroOrigen.getDireccion());
		super.adicionarVariable(EnumVariablesImpresion.DPR_DIRECCION_TERC_ORIG, objTerceroOrigen.getDireccion());
		super.adicionarVariable(EnumVariablesImpresion.TELEFONO_TERCERO_ORIGEN, objTerceroOrigen.getTelefono1());
		super.adicionarVariable(EnumVariablesImpresion.DPR_TELEFONO_TERC_ORIG, objTerceroOrigen.getTelefono1());
		super.adicionarVariable(EnumVariablesImpresion.CELULAR_TERCERO_ORIGEN, objTerceroOrigen.getTelefono2());
		super.adicionarVariable(EnumVariablesImpresion.CORREO_TERCERO_ORIGEN, objTerceroOrigen.getMail());		
		super.adicionarVariable(EnumVariablesImpresion.DPR_CELULAR_TERC_ORIG, objTerceroOrigen.getTelefono2());
		
		super.adicionarVariable(EnumVariablesImpresion.NOMBRE_TERCERO_DESTINO, objTerceroDestino.toString());
		super.adicionarVariable(EnumVariablesImpresion.DPR_NOMBRE_TERC_DEST, objTerceroDestino.toString());
		super.adicionarVariable(EnumVariablesImpresion.IDENTIFICACION_TERCERO_DESTINO, objTerceroDestino.getIdentificacion());
		super.adicionarVariable(EnumVariablesImpresion.DPR_IDENTIFICACION_TERC_DEST, objTerceroDestino.getIdentificacion());
		super.adicionarVariable(EnumVariablesImpresion.DIRECCION_TERCERO_DESTINO, objTerceroDestino.getDireccion());
		super.adicionarVariable(EnumVariablesImpresion.DPR_DIRECCION_TERC_DEST, objTerceroDestino.getDireccion());
		super.adicionarVariable(EnumVariablesImpresion.TELEFONO_TERCERO_DESTINO, objTerceroDestino.getTelefono1());
		super.adicionarVariable(EnumVariablesImpresion.DPR_TELEFONO_TERC_DEST, objTerceroDestino.getTelefono1());
		super.adicionarVariable(EnumVariablesImpresion.CELULAR_TERCERO_DESTINO, objTerceroDestino.getTelefono2());
		super.adicionarVariable(EnumVariablesImpresion.CORREO_TERCERO_DESTINO, objTerceroDestino.getMail());
		super.adicionarVariable(EnumVariablesImpresion.DPR_CELULAR_TERC_DEST, objTerceroDestino.getTelefono2());
		
		super.adicionarVariable(EnumVariablesImpresion.NOMBRE_TERCERO_NUEVO, objTerceroNuevo.toString());
		super.adicionarVariable(EnumVariablesImpresion.DPR_NOMBRE_TERC_NUEV, objTerceroNuevo.toString());
		super.adicionarVariable(EnumVariablesImpresion.IDENTIFICACION_TERCERO_NUEVO, objTerceroNuevo.getIdentificacion());
		super.adicionarVariable(EnumVariablesImpresion.DPR_IDENTIFICACION_TERC_NUEV, objTerceroNuevo.getIdentificacion());
		super.adicionarVariable(EnumVariablesImpresion.DIRECCION_TERCERO_NUEVO, objTerceroNuevo.getDireccion());
		super.adicionarVariable(EnumVariablesImpresion.DPR_DIRECCION_TERC_NUEV, objTerceroNuevo.getDireccion());
		super.adicionarVariable(EnumVariablesImpresion.TELEFONO_TERCERO_NUEVO, objTerceroNuevo.getTelefono1());
		super.adicionarVariable(EnumVariablesImpresion.DPR_TELEFONO_TERC_NUEV, objTerceroNuevo.getTelefono1());
		super.adicionarVariable(EnumVariablesImpresion.CELULAR_TERCERO_NUEVO, objTerceroNuevo.getTelefono2());
		super.adicionarVariable(EnumVariablesImpresion.CORREO_TERCERO_NUEVO, objTerceroNuevo.getMail());
		super.adicionarVariable(EnumVariablesImpresion.DPR_CELULAR_TERC_NUEV, objTerceroNuevo.getTelefono2());
		
		
		if (objClaveSeguridad != null &&
				objClaveSeguridad instanceof ClaveSeguridadManual) {
			
			super.adicionarVariable(EnumVariablesImpresion.EXISTE_CLAVE_SEGURIDAD, true);
			
			if (super.getEnmTipoImpresion() == EnumTiposImpresora.TIRILLA) {
				
				strClaveSeguriad = ((ClaveSeguridadManual)objClaveSeguridad).getStrClave();
				
			}else{
				
				strClaveSeguriad = EnumParametrosSistema.TITULO_IMPRESION_CLAVE_SEGURIDAD.obtenerValorCadena() + ": " +
								   ((ClaveSeguridadManual)objClaveSeguridad).getStrClave();
			}
			
			super.adicionarVariable(EnumVariablesImpresion.CLAVE_SEGURIDAD, strClaveSeguriad);
			
		}else{
			
			super.adicionarVariable(EnumVariablesImpresion.EXISTE_CLAVE_SEGURIDAD, false);
		}
		
		this.medioEntregaInactivo(objFacturaGiro);
		this.validaFirmaBiometrica(objFacturaGiro);
		
		return super.getObjVariablesImpresion();
	}
	
	/** 
	 * ********************************************************************
	 * @method validaFirmaBiometrica
	 * 		   Valida si la solicitud de autorizacion se retorno firma 
	 * 	 	   biometrica, y se diligencia la variable para impresion
	 * @param  pObjFacturaGiro
	 * 		   objeto de la factura
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author roberth.martinez
	 * @date   19/11/2016
	 * *********************************************************************
	 */
	private void validaFirmaBiometrica(FacturaGiro pObjFacturaGiro) throws Exception{
		
		String strIdFirmaBiometrica;
		
		if (pObjFacturaGiro.getTerceroOrigen().getObjBiometria().gestionarObjFirmaBiometrica().getStrId().equals("*")) {
			
			super.adicionarVariable(EnumVariablesImpresion.EXISTE_FIRMA_BIOMETRICA, false);
			
		}else{
			
			strIdFirmaBiometrica = pObjFacturaGiro.getTerceroOrigen().getObjBiometria().gestionarObjFirmaBiometrica().getStrId();
			
			if	(	super.getEnmTipoImpresion().equals(EnumTiposImpresora.MEDIA_CARTA)	) 
			{
				strIdFirmaBiometrica = "FIRMA BIOMETRICA : " + strIdFirmaBiometrica;
			}
			
			super.adicionarVariable(EnumVariablesImpresion.EXISTE_FIRMA_BIOMETRICA, true);
			super.adicionarVariable(EnumVariablesImpresion.FIRMA_BIOMETRICA, strIdFirmaBiometrica);
		}
	}
	
	/**
	 * ********************************************************************
	 * @method	validaCorreoTerceros
	 * 		  	
	 * @param pObjTerceroOrigen, pObjTerceroDestino, pObjTerceroNuevo
	 * 			Terceros involucrados en el cambio de beneficiario
	 * @param objTerceroOrigen
	 * 			Tercero Remitente de la transaccion 
	 * @throws Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author	didier.silva
	 * @date	01/03/2019
	 * *********************************************************************
	 */
	private void validaCorreoTerceros(	Tercero pObjTerceroOrigen,
											Tercero pObjTerceroDestino,
											Tercero pObjTerceroNuevo
									 ) throws Exception {
		
		Tercero objTerceroOrigen  = pObjTerceroOrigen;
		Tercero objTerceroDestino  = pObjTerceroDestino;
		Tercero objTerceroNuevo  = pObjTerceroNuevo;
		ParametroSistema psPASI;
		String strMARCCODE = "";
		
		/*psPASI = UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.VALOR_CORREOS_TERCEROS_NO_SUMINISTRADO_CRC);
		strMARCCODE = psPASI.getValor();*/
		
		strMARCCODE = ControlConsultaPasiVistaLogica.getInstance().getMarccode();
		
		if (objTerceroOrigen != null && (objTerceroOrigen.getMail() == null || objTerceroOrigen.getMail().equals("*") || objTerceroOrigen.getMail().equals("@") || objTerceroOrigen.getMail().equals("")) )	{
			
			objTerceroOrigen.setMail(strMARCCODE);
			
		}
		
		if (objTerceroDestino != null && (objTerceroDestino.getMail() == null || objTerceroDestino.getMail().equals("*") || objTerceroDestino.getMail().equals("@") || objTerceroDestino.getMail().equals("")) )	{
			
			objTerceroDestino.setMail(strMARCCODE);
			
		}
		
		if (objTerceroNuevo != null && (objTerceroNuevo.getMail() == null || objTerceroNuevo.getMail().equals("*") || objTerceroNuevo.getMail().equals("@") || objTerceroNuevo.getMail().equals("")) ) 	{
			
			objTerceroNuevo.setMail(strMARCCODE);
			
		}
		
	   if (objTerceroDestino.getMail().equals("*") || objTerceroDestino.getMail().equals("@") || objTerceroDestino.getMail().equals(""))	{
			
			objTerceroDestino.setMail(strMARCCODE);
			
		}
		  
		////En caso que el tercero tenga correo esta sera enmascarado en la tirrilla
		if(!objTerceroOrigen.getMail().equals(strMARCCODE))
		{
			
			objTerceroOrigen.setMail(UtilidadesGiros.proteccionInfo(objTerceroOrigen.getMail(), 0));
		}
		
		if(!objTerceroDestino.getMail().equals(strMARCCODE))
		{
			 
		   objTerceroDestino.setMail(UtilidadesGiros.proteccionInfo(objTerceroDestino.getMail(), 0));
		}
		
		if(!objTerceroNuevo.getMail().equals(strMARCCODE))
		{
			 
			objTerceroNuevo.setMail(UtilidadesGiros.proteccionInfo(objTerceroNuevo.getMail(), 0));
		}
		
	}
	
	public void medioEntregaInactivo(FacturaGiro pStrValorParametro) throws Exception {

		ParametroSistema psPASI;
		String strSERCOTIR = "";

		psPASI = UtilParametrosSistema.getInstance()
				.consultar(EnumParametrosSistema.ACTIVA_SERVICIO_PRUEBA_ADMISIONENTREGA_TIRILLA);
		strSERCOTIR = psPASI.getValor();

		if (strSERCOTIR.equals("N")) {

			pStrValorParametro.getObjCRCMedioEntrega().setStrTipo("");
			super.adicionarVariable(EnumVariablesImpresion.MEDIO_ENTREGA,pStrValorParametro.getObjCRCMedioEntrega().getStrTipo());

		} else {

			super.adicionarVariable(EnumVariablesImpresion.MEDIO_ENTREGA,pStrValorParametro.getObjCRCMedioEntrega().getStrTipo());

		}

		if (pStrValorParametro.getObjCRCMedioEntrega().getStrTipo().equals("*")) {

			pStrValorParametro.getObjCRCMedioEntrega().setStrTipo("");
			super.adicionarVariable(EnumVariablesImpresion.MEDIO_ENTREGA,pStrValorParametro.getObjCRCMedioEntrega().getStrTipo());
		}
	}

}

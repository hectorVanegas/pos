package co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion;

import java.util.List;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumTiposImpresora;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumVariablesImpresion;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Agencia;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Caja;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Concepto;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Empresa;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Factura;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.VariablesImpresion;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionAnulacionGiroAutorizadaDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionDTO;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

public class ProcesarVariablesImpresionAnulacionGiroAutorizada extends ProcesarVariablesImpresion{

	public ProcesarVariablesImpresionAnulacionGiroAutorizada(boolean pBooEsReimpresion,
												   EnumTiposImpresora pEnmTipoImpresion)throws Exception{
		super(pBooEsReimpresion,
			  pEnmTipoImpresion);
	}
	
	@Override
	public VariablesImpresion obtenerVariablesImpresion(VariablesImpresionDTO pObjDtoVariablesImpresion)throws Exception{
		
		VariablesImpresionAnulacionGiroAutorizadaDTO objDtoVarImpAnulacionGiro;
		Factura objFactura;
		Usuario objUsuario;
		Empresa objEmpresa;
		Agencia objAgenciaPago;
		Caja objCajaPago;
		Agencia objAgenciaOrigen;
		Agencia objAgenciaDestino;
		Tercero objTerceroOrigen;
		Tercero objTerceroDestino;
		String strGrillaConceptos;
		
		objDtoVarImpAnulacionGiro = (VariablesImpresionAnulacionGiroAutorizadaDTO)pObjDtoVariablesImpresion;
		
		objUsuario = objDtoVarImpAnulacionGiro.getObjUsuario();
		objFactura = objDtoVarImpAnulacionGiro.getObjFactura();
		objEmpresa = objUsuario.getEmpresa();
		
		/**
		 * Se utiliza como agencia y caja de pago la del usuario, puesto que para este proceso no se requiere re-impresion
		 */
		objAgenciaPago = objUsuario.getAgencia();//objFactura.getAgenciaPago();
		objCajaPago = objUsuario.getCaja();
				
		objAgenciaOrigen = objFactura.getAgenciaOrigen();
		objAgenciaDestino = objFactura.getAgenciaDestino();
		objTerceroOrigen = objFactura.getTerceroOrigen();
		objTerceroDestino = objFactura.getTerceroDestino();
		
		strGrillaConceptos = this.tramaConceptos(objFactura.getListaConceptos());
		
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
		
		super.adicionarVariable(EnumVariablesImpresion.NOMBRE_AGENCIA, objAgenciaPago.getNombre());
		super.adicionarVariable(EnumVariablesImpresion.CODIGO_CAJA, objCajaPago.getCodigo());
		super.adicionarVariable(EnumVariablesImpresion.DIRECCION_AGENCIA, objAgenciaPago.getDireccion());
		super.adicionarVariable(EnumVariablesImpresion.TELEFONO_AGENCIA, objAgenciaPago.getTelefono1());
		
		super.adicionarVariable(EnumVariablesImpresion.ABREVIATURA_DOCUMENTO, objFactura.getDocumento().getAbreviatura());
		super.adicionarVariable(EnumVariablesImpresion.NUMERO_FACTURA, objFactura.getNumero());
		super.adicionarVariable(EnumVariablesImpresion.NOTAS, objFactura.getObjNota().getStrDescripcionImpr());
		super.adicionarVariable(EnumVariablesImpresion.PIN_GIRO, objFactura.getReferenciaControl());
		super.adicionarVariable(EnumVariablesImpresion.FECHA_ENVIO, objFactura.getFechaGiro());
		super.adicionarVariable(EnumVariablesImpresion.FECHA_TRANSACCION, objFactura.getFechasys());
		
		super.adicionarVariable(EnumVariablesImpresion.NOMBRE_AGENCIA_ORIGEN, objAgenciaOrigen.getNombre());
		super.adicionarVariable(EnumVariablesImpresion.DIRECCION_AGENCIA_ORIGEN, objAgenciaOrigen.getDireccion());
		super.adicionarVariable(EnumVariablesImpresion.TELEFONO_AGENCIA_ORIGEN, objAgenciaOrigen.getTelefonoImpr());
		
		super.adicionarVariable(EnumVariablesImpresion.NOMBRE_TERCERO_ORIGEN, objTerceroOrigen.toString());
		super.adicionarVariable(EnumVariablesImpresion.IDENTIFICACION_TERCERO_ORIGEN, objTerceroOrigen.getIdentificacion());
		super.adicionarVariable(EnumVariablesImpresion.DIRECCION_TERCERO_ORIGEN, objTerceroOrigen.getDireccion());
		super.adicionarVariable(EnumVariablesImpresion.TELEFONO_TERCERO_ORIGEN, objTerceroOrigen.getTelefono1());
		super.adicionarVariable(EnumVariablesImpresion.CELULAR_TERCERO_ORIGEN, objTerceroOrigen.getTelefono2());
		
		super.adicionarVariable(EnumVariablesImpresion.NOMBRE_AGENCIA_DESTINO, objAgenciaDestino.getNombre());
		super.adicionarVariable(EnumVariablesImpresion.DIRECCION_AGENCIA_DESTINO, objAgenciaDestino.getDireccion());
		super.adicionarVariable(EnumVariablesImpresion.TELEFONO_AGENCIA_DESTINO, objAgenciaDestino.getTelefonoImpr());
		
		super.adicionarVariable(EnumVariablesImpresion.CONCEPTOS, strGrillaConceptos);
		
		super.adicionarVariable(EnumVariablesImpresion.NOMBRE_TERCERO_DESTINO, objTerceroDestino.toString());
		super.adicionarVariable(EnumVariablesImpresion.IDENTIFICACION_TERCERO_DESTINO, objTerceroDestino.getIdentificacion());
		super.adicionarVariable(EnumVariablesImpresion.DIRECCION_TERCERO_DESTINO, objTerceroDestino.getDireccion());
		super.adicionarVariable(EnumVariablesImpresion.TELEFONO_TERCERO_DESTINO, objTerceroDestino.getTelefono1());
		super.adicionarVariable(EnumVariablesImpresion.CELULAR_TERCERO_DESTINO, objTerceroDestino.getTelefono2());
		
		super.adicionarVariable(EnumVariablesImpresion.NOMBRE_CAJERO, objUsuario.getLogin());
		super.adicionarVariable(EnumVariablesImpresion.FECHA_SISTEMA, objFactura.getFechaBD());
		
		this.validaFirmaBiometrica(objFactura);
		
		return super.getObjVariablesImpresion();
	}
	
	/** 
	 * ********************************************************************
	 * @method validaFirmaBiometrica
	 * 		   Valida si la solicitud de autorizacion se retorno firma 
	 * 	 	   biometrica, y se diligencia la variable para impresion
	 * @param  pObjFactura
	 * 		   objeto de la factura
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author roberth.martinez
	 * @date   19/11/2016
	 * *********************************************************************
	 */
	private void validaFirmaBiometrica(Factura pObjFactura) throws Exception{
		
		String strIdFirmaBiometrica;
		
		if (pObjFactura.getTerceroOrigen().getObjBiometria().gestionarObjFirmaBiometrica().getStrId().equals("*")) {
			
			super.adicionarVariable(EnumVariablesImpresion.EXISTE_FIRMA_BIOMETRICA, false);
			
		}else{
			
			strIdFirmaBiometrica = pObjFactura.getTerceroOrigen().getObjBiometria().gestionarObjFirmaBiometrica().getStrId();
			super.adicionarVariable(EnumVariablesImpresion.EXISTE_FIRMA_BIOMETRICA, true);
			super.adicionarVariable(EnumVariablesImpresion.FIRMA_BIOMETRICA, strIdFirmaBiometrica);
		}
	}
	
	private String tramaConceptos(List<Concepto> pLstConceptos)throws Exception{
		
		String strTrama = "";
		String strValorPresentado;
		double douValorTotal;
		
		if(pLstConceptos!= null 
				&& !pLstConceptos.isEmpty()){
			
			douValorTotal=0;
			
			for(Concepto objConcepto : pLstConceptos){
				
				if (objConcepto.isBooAfectaCaja()) {
				
					if (objConcepto.getValor() > 0) {
						
						strTrama += objConcepto.getDescripcion()+":"+";";
						
						strValorPresentado = UtilidadGiros.getInstancia().formatoPresentacionDinero(objConcepto.getValor());
						
						strTrama += strValorPresentado+";";
						
						douValorTotal += objConcepto.getValor();
					}
				}
			}
			
			strValorPresentado = UtilidadGiros.getInstancia().formatoPresentacionDinero(douValorTotal);
			strTrama = strTrama.replaceAll("GIRO POSTAL", "VALOR DEL GIRO");
			strTrama = strTrama.replaceAll("FLETE", "VALOR DEl FLETE");
			strTrama += "TOTAL:"+";"+strValorPresentado;
		}
		
		return strTrama;
	}

}

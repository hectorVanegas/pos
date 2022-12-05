package co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion;

import java.util.List;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMediosPago;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumTiposImpresora;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumVariablesImpresion;
import co.com.codesa.clienteposslimgiros.utilidades.mediosPago.UtilMediosPago;
import co.com.codesa.clienteposslimgiros.utilidades.xml.XmlDatosEntidades;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Agencia;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Caja;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DatoEntidad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Documento;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Empresa;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.MedioPago;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Sede;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.VariablesImpresion;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Convenio;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DatoAdicional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Propiedad;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionEnvioRecaudoDTO;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

public class ProcesarVariablesImpresionEnvioRecaudo extends ProcesarVariablesImpresion{

	public ProcesarVariablesImpresionEnvioRecaudo(boolean pBooEsReimpresion,
			  								      EnumTiposImpresora pEnmTipoImpresion)throws Exception{
		super(pBooEsReimpresion,
			  pEnmTipoImpresion);
	}
	
	@Override
	public VariablesImpresion obtenerVariablesImpresion(VariablesImpresionDTO pObjDtoVariablesImpresion)throws Exception{
		
		VariablesImpresionEnvioRecaudoDTO objDtoVarImpEnvioRecaudo;
		FacturaGiro objFacturaGiro;
		Documento objDocumento;
		Tercero objTerceroOrigen;
		Tercero objTerceroDestino;
		//Tercero objTerceroConvenio;
		Convenio objConvenio;
		Sede objSede;
		Usuario objUsuario;
		Empresa objEmpresa;
		Agencia objAgenciaOrigen;
		Caja objCajaOrigen;
		DatoEntidad objDeTipoId;
		String strGrillaTotalXMediosPago;
		String strGrillaMediosPago;
		String strGrillaPropiedades;
		String strEntidadTipoId = EnumParametrosApp.ENT_TIPOS_IDENTIFICACION.getValorPropiedad();
		
		objDtoVarImpEnvioRecaudo = (VariablesImpresionEnvioRecaudoDTO)pObjDtoVariablesImpresion;
		
		objUsuario = objDtoVarImpEnvioRecaudo.getObjUsuario();
		objFacturaGiro = objDtoVarImpEnvioRecaudo.getObjFacturaGiro();
		objCajaOrigen = objDtoVarImpEnvioRecaudo.getObjCaja();
		
		objEmpresa = objUsuario.getEmpresa();
		objDocumento = objFacturaGiro.getDocumento();
		objAgenciaOrigen = objFacturaGiro.getAgenciaOrigen();
		objConvenio = objFacturaGiro.getObjConvenio();
		objSede = objConvenio.getObjSedeSeleccionada();
		objTerceroOrigen = objFacturaGiro.getTerceroOrigen();
		objTerceroDestino = objFacturaGiro.getTerceroDestino();
		//objTerceroConvenio = objConvenio.getTercero();
		
		objDeTipoId = XmlDatosEntidades.getInstance().obtenerEntidad(strEntidadTipoId).getHmDatos().get(objTerceroDestino.getTipoIdentificacion().getId());
		objTerceroDestino.setTipoIdentificacion(objDeTipoId);
		
		strGrillaPropiedades = this.tramaPropiedades(objConvenio.getLstPropiedades());
		
		strGrillaMediosPago = this.tramaMediosPago(objFacturaGiro.getListMediosPago());
		strGrillaTotalXMediosPago = "TOTAL:"+";;"+UtilidadGiros.getInstancia().formatoPresentacionDinero(objFacturaGiro.getTotal());
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_EMPRESA.getNombre(), objEmpresa.getNombre());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NIT_EMPRESA.getNombre(), objEmpresa.getNit());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.DIRECCION_EMPRESA.getNombre(), objEmpresa.getDireccion());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.PAGINA_WEB_EMPRESA.getNombre(), objEmpresa.getUrl());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TELEFONO_EMPRESA.getNombre(), objEmpresa.getTelefono());
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.ABREVIATURA_DOCUMENTO.getNombre(), objDocumento.getAbreviatura());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.INICIO_DOCUMENTO.getNombre(), objDocumento.getInicio());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.FIN_DOCUMENTO.getNombre(), objDocumento.getFin());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.RESOLUCION_DOCUMENTO.getNombre(), objDocumento.getResolucion());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NUMERO_FACTURA.getNombre(), objFacturaGiro.getNumero());
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.PIN_RECAUDO.getNombre(), objFacturaGiro.getReferenciaControl());
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_REPRESENTANTE_COMERCIAL_EMPRESA.getNombre(), objEmpresa.getRcNombre());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NIT_REPRESENTANTE_COMERCIAL_EMPRESA.getNombre(), objEmpresa.getRcNit());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TELEFONO_REPRESENTANTE_COMERCIAL_EMPRESA.getNombre(), objEmpresa.getRcTelefono());
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.CODIGO_CAJA.getNombre(), objCajaOrigen.getCodigo());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.FECHA_TRANSACCION.getNombre(), objFacturaGiro.getFechaGiro());
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_AGENCIA_ORIGEN.getNombre(), objAgenciaOrigen.getNombre());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.DIRECCION_AGENCIA_ORIGEN.getNombre(), objAgenciaOrigen.getDireccion());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TELEFONO_AGENCIA_ORIGEN.getNombre(), objAgenciaOrigen.getTelefonoImpr());
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_TERCERO_ORIGEN.getNombre(), objTerceroOrigen.toString());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.IDENTIFICACION_TERCERO_ORIGEN.getNombre(), objTerceroOrigen.getIdentificacion());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TELEFONO_TERCERO_ORIGEN.getNombre(), objTerceroOrigen.getTelefono1());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.CELULAR_TERCERO_ORIGEN.getNombre(), objTerceroOrigen.getTelefono2());
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_TERCERO_DESTINO.getNombre(), objTerceroDestino.toString());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.IDENTIFICACION_TERCERO_DESTINO.getNombre(), objTerceroDestino.getIdentificacion());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TELEFONO_TERCERO_DESTINO.getNombre(), objTerceroDestino.getTelefono1());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.CELULAR_TERCERO_DESTINO.getNombre(), objTerceroDestino.getTelefono2());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TIPO_E_IDENTIFICACION_TERCERO_DESTINO.getNombre(), objTerceroDestino.toStringXDocumento());
		
		/*super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_TERCERO_CONVENIO.getNombre(), objTerceroConvenio.toString());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.IDENTIFICACION_TERCERO_CONVENIO.getNombre(), objTerceroConvenio.getIdentificacion());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TELEFONO_TERCERO_CONVENIO.getNombre(), objTerceroConvenio.getTelefono1());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.CELULAR_TERCERO_CONVENIO.getNombre(), objTerceroConvenio.getTelefono2());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TIPO_E_IDENTIFICACION_TERCERO_CONVENIO.getNombre(), objTerceroConvenio.toStringXDocumento());*/
		
		if(objSede==null){
			
			super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.EXISTE_SEDE.getNombre(), false);
			
		}else{
			
			super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.EXISTE_SEDE.getNombre(), true);
			super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.CODIGO_EXTERNO_RECAUDO.getNombre(), objSede.getStrCodigoExterno());
			super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_SEDE.getNombre(), objSede.getNombre());
			super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.DIRECCION_SEDE.getNombre(), objSede.getDireccion());
			super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TELEFONO_SEDE.getNombre(), objSede.getTelefono());
		}
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.MEDIOS_PAGO.getNombre(), strGrillaMediosPago);
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.TOTAL_MEDIOS_PAGO.getNombre(), strGrillaTotalXMediosPago);
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.PROPIEDADES.getNombre(), strGrillaPropiedades);
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.ID_UNICO.getNombre(), objConvenio.getStrIdHash());
		
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.NOMBRE_CAJERO.getNombre(), objUsuario.getLogin());
		super.getObjVariablesImpresion().getHmVariables().put(EnumVariablesImpresion.FECHA_SISTEMA.getNombre(), objFacturaGiro.getFechaBD());
		
		return super.getObjVariablesImpresion();
	}
	
	private String tramaPropiedades(List<Propiedad> pLstPropiedades)throws Exception{
		
		String strTrama = "";
		
		if(pLstPropiedades!= null 
				&& !pLstPropiedades.isEmpty()){
			
			for(Propiedad objPropiedad : pLstPropiedades){
				
				if(objPropiedad.isBooImprime()){
				
					strTrama += objPropiedad.getStrEtiqueta()+":"+";";
					strTrama += objPropiedad.getStrValor()+";";
				}
			}
		}
		
		return strTrama;
	}
	
	private String tramaMediosPago(List<MedioPago> pLstMediosPago)throws Exception{
		
		DatoAdicional objDatoAdicional;
		EnumMediosPago enmMedioPago;
		String strTrama = "";
		
		if(pLstMediosPago!= null 
				&& !pLstMediosPago.isEmpty()){
			
			for(MedioPago objMedioPago : pLstMediosPago){
				
				enmMedioPago = UtilMediosPago.getInstance().obtenerEnum(objMedioPago);
				
				if(enmMedioPago!=null){
					
					strTrama += enmMedioPago.getStrEtiqueta().toUpperCase()+";";
					
				}else{
					
					strTrama += objMedioPago.getDescripcion()+";";
				}
				
				objDatoAdicional = objMedioPago.getHmDatosAdicionales().get("COD_APROBACION");
				
				if(objDatoAdicional != null){
					
					strTrama += objDatoAdicional.getObjValor().toString()+";";
					
				}else{
					
					strTrama += ";";
				}
				
				strTrama += UtilidadGiros.getInstancia().formatoPresentacionDinero(objMedioPago.getValor())+";";
			}
		}
		
		return strTrama;
	}
}

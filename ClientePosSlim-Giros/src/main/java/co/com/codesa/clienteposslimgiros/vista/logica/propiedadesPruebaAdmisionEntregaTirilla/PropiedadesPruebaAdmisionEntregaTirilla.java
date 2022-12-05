package co.com.codesa.clienteposslimgiros.vista.logica.propiedadesPruebaAdmisionEntregaTirilla;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.clienteposslimgiros.utilidades.vistaLogica.UtilVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.ControlConsultaPasiVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultarPropiedadesConvenio;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarPropiedadesConvenio;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DatoEntidad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Propiedad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;

import java.util.ArrayList;
import java.util.List;

/***
 * Proposito permitir presentar las propiedades correspondientes a Transmision
 * de tirillas
 * 
 * @author dsalazar[PlayTech]
 * @since 14-feb-2019
 * 
 * */
public class PropiedadesPruebaAdmisionEntregaTirilla {

	private static PropiedadesPruebaAdmisionEntregaTirilla instancia;

	private PropiedadesPruebaAdmisionEntregaTirilla() {
	}

	public static PropiedadesPruebaAdmisionEntregaTirilla getInstance()
			throws Exception {

		if (instancia == null) {
			instancia = new PropiedadesPruebaAdmisionEntregaTirilla();
		}

		return instancia;
	}

	/*
	 * Proposito obtener la lista de propiedades correspondientes de entrega de
	 * tirillas
	 * 
	 * @author: dsalazar[PlayTech]
	 * 
	 * @since : 14-feb-2019
	 */

	@SuppressWarnings("unchecked")
	public List<Propiedad> consultarListaPropiedadTransmisionTirillas(Usuario pObjUsuario) throws Exception{

		List<Propiedad> lPropiedadesTransTirillas = new ArrayList<Propiedad>();
		/*UtilParametrosSistema.getInstance().consultar(
				EnumParametrosSistema.TIPO_ID_IDENTIFICACION_TERCERO_PRUEBA_ADMISIONENTREGA_TIRILLA);

		String strParametroConvenio = EnumParametrosSistema.TIPO_ID_IDENTIFICACION_TERCERO_PRUEBA_ADMISIONENTREGA_TIRILLA
				.obtenerValorCadena();*/
		
		String strParametroConvenio = ControlConsultaPasiVistaLogica.getInstance().getIdtecoti();

		Tercero objTercero = new Tercero(new DatoEntidad(
				strParametroConvenio.split("\\"
						+ EnumGeneralidadesTramasGiros.PIPE.getValor())[0]),
				strParametroConvenio.split("\\"
						+ EnumGeneralidadesTramasGiros.PIPE.getValor())[1]);
		
		ConsultarPropiedadesConvenio objEnvioTrama;
		RespuestaConsultarPropiedadesConvenio objRespuestaTrama;
		
		objEnvioTrama = new ConsultarPropiedadesConvenio(pObjUsuario, objTercero);
		objRespuestaTrama = (RespuestaConsultarPropiedadesConvenio)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if(objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
			
			lPropiedadesTransTirillas = (List<Propiedad>)objRespuestaTrama.getValorAtributoObj("listaPropiedadesConvenio");
			
		}else {
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
				   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
				   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}

		return lPropiedadesTransTirillas;

	}

}

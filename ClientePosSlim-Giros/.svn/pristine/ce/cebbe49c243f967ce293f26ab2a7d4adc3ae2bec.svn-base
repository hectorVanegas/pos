package co.com.codesa.clienteposslimgiros.vista.logica.propiedadesPeps;

import java.util.ArrayList;
import java.util.List;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.clienteposslimgiros.utilidades.vistaLogica.UtilVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultarPropiedadesPeps;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarPropiedadesPeps;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DatoEntidad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Propiedad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;

public class PropiedadesPepsVistaLogica {
	
	private static PropiedadesPepsVistaLogica instancia;
	
	private PropiedadesPepsVistaLogica() {}
	
	public static PropiedadesPepsVistaLogica getInstance() throws Exception{
		
		if (instancia == null) {
			instancia = new PropiedadesPepsVistaLogica();
		}
		
		return instancia;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Propiedad> consultarPropiedadesPeps(Usuario pObjUsuario) throws Exception{
		
		List<Propiedad> lPropiedadesPeps = new ArrayList<Propiedad>();
		
		UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.TIPO_ID_IDENTIFICACION_TERCERO_CONVPEPS);
		
		String strParametroConvenioPeps = EnumParametrosSistema.TIPO_ID_IDENTIFICACION_TERCERO_CONVPEPS.obtenerValorCadena();		
		
		Tercero objTercero = new Tercero(new DatoEntidad(strParametroConvenioPeps.split("\\" + EnumGeneralidadesTramasGiros.PIPE.getValor())[0]),
									strParametroConvenioPeps.split("\\" + EnumGeneralidadesTramasGiros.PIPE.getValor())[1]);
		
		ConsultarPropiedadesPeps objEnvioTrama;
		RespuestaConsultarPropiedadesPeps objRespuestaTrama;
		
		objEnvioTrama = new ConsultarPropiedadesPeps(pObjUsuario, objTercero);
		objRespuestaTrama = (RespuestaConsultarPropiedadesPeps)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if(objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
			
			lPropiedadesPeps = (List<Propiedad>)objRespuestaTrama.getValorAtributoObj("listaPropiedadesPeps");
			
		}else {
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
				   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
				   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
		
		return lPropiedadesPeps;		
	}

}

package co.com.codesa.clienteposslimgiros.vista.logica;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.utilidades.vistaLogica.UtilVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.lector2D.Lector2DVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultaConfiguracionPasi564;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultaConfiguracionPasi;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;

public class ControlConfiguracionPasiVistaLogica {
	
	private static ControlConfiguracionPasiVistaLogica instancia;
	
	/**
	 * ****************************************************************.
	 * @metodo: ControlConfiguracionPasiVistaLogica
	 * @descripcion: contructor de la logica.
	 * @autor: Jefferson Ruiz
	 * @date: 16/09/2019
	 * ****************************************************************
	 */
	private ControlConfiguracionPasiVistaLogica(){}
	
	/**
	 * ****************************************************************.
	 * @metodo: getInstance
	 * @descripcion: metodo para cumplir con el patron singleton y tener
	 * una unica instancia de la clase para se accedida.
	 * @autor: Jefferson Ruiz
	 * ****************************************************************
	 */
	public static ControlConfiguracionPasiVistaLogica getInstance(){		
		if (instancia == null)
			instancia= new ControlConfiguracionPasiVistaLogica();
		
		return instancia;
	}
	
	public String consultarConfiguracionPasi(Usuario pobjUsuario) throws Exception {
		
		ConsultaConfiguracionPasi564 objEnvioTrama;
		RespuestaConsultaConfiguracionPasi objRespuestaTrama;
		String strControl;
		
		objEnvioTrama = new ConsultaConfiguracionPasi564(pobjUsuario);
		objRespuestaTrama = (RespuestaConsultaConfiguracionPasi) UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
			
			strControl = objRespuestaTrama.getValorAtributoObj("control").toString();
			
		}else {
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR,
															(String)objRespuestaTrama.getValorAtributoObj("codigoError"), 
															(String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
			
		}
		
		return strControl;
		
	}

}

package co.com.codesa.clienteposslimgiros.vista.logica;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.utilidades.vistaLogica.UtilVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;
import co.com.codesa.codesawrappergiros.utilidades.ConsultarServicioPorColaborador;
import co.com.codesa.codesawrappergiros.utilidades.RespuestaConsultarServicioPorColaborador;

public class ConsultarServicioPorColaboradorVistaLogica {
	
	private static ConsultarServicioPorColaboradorVistaLogica instancia;
	
	/**
	 * ****************************************************************.
	 * @metodo: ConsultarServicioPorColaboradorVistaLogica
	 * @descripcion: contructor de la logica.
	 * @autor: Jefferson Ruiz
	 * @date: 04/09/2019
	 * ****************************************************************
	 */
	private ConsultarServicioPorColaboradorVistaLogica(){}	
	
	/**
	 * ****************************************************************.
	 * @metodo: getInstance
	 * @descripcion: metodo para cumplir con el patron singleton y tener
	 * una unica instancia de la clase para se accedida.
	 * @autor: Jefferson Ruiz
	 * ****************************************************************
	 */
	public static ConsultarServicioPorColaboradorVistaLogica getInstance(){		
		if (instancia == null)
			instancia= new ConsultarServicioPorColaboradorVistaLogica();
		
		return instancia;
	}
	
	public String consultarServicio(Usuario pobjUsuario,
									String strCodigoServicio) throws Exception {
		
		ConsultarServicioPorColaborador objEnvioTrama;
		RespuestaConsultarServicioPorColaborador objRespuestaTrama;
		String strEstadoServicio = null;
		
		objEnvioTrama = new ConsultarServicioPorColaborador(pobjUsuario, 
															strCodigoServicio);
		
		objRespuestaTrama = (RespuestaConsultarServicioPorColaborador)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
			
			strEstadoServicio = objRespuestaTrama.getValorAtributoObj("servicio").toString();
		
		}else {
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR,
															(String)objRespuestaTrama.getValorAtributoObj("codigoError"), 
															(String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
			
		}
		
		return strEstadoServicio;
	}

}

/** 
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
package co.com.codesa.clienteposslimgiros.vista.logica;

import co.com.codesa.clienteposslimcontrolador.conexion.ProcesadorTramas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.utilidades.vistaLogica.UtilVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ActualizaNotasGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultaNotasGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaRealizarAnulacionGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Factura;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaActualizaNotasGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultaNotasGiro;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;

/**
 * ****************************************************************.
 * @autor: CesarO.Rendon
 * @fecha: 19-mar-2015 
 * @descripcion: clase encargada de manejar el llamado a las tramas de
 * notas relacionadas a los giros.
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class NotaVistaLogica {

	private static NotaVistaLogica instancia ;

	/**
	 * ****************************************************************.
	 * @metodo: NotaVistaLogica
	 * @descripcion: contructor de la logica.
	 * @autor: CesarO.Rendon
	 * ****************************************************************
	 */
	private NotaVistaLogica(){}	

	/**
	 * ****************************************************************.
	 * @metodo: getInstance
	 * @descripcion: metodo para cumplir con el patron singleton y tener
	 * una unica instancia de la clase para se accedida.
	 * @autor: CesarO.Rendon
	 * ****************************************************************
	 */
	public static NotaVistaLogica getInstance(){		
		if (instancia == null)
			instancia= new NotaVistaLogica();

		return instancia;
	}


	/**
	 * ****************************************************************.
	 * @metodo: consultaNotasGiro
	 * @descripcion: llama la trama de consultar notas de un giro por 
	 * medio del pin.
	 * @param pStrReferencia
	 * @return RespuestaConsultaNotasGiro
	 * @throws Exception
	 * @autor: CesarO.Rendon
	 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
	 * ****************************************************************
	 */
	public void consultaNotasGiro(Usuario pObjUsuario,
								  Factura pObjFactura) throws Exception{
		
		ConsultaNotasGiro objEnvioTrama;
		RespuestaConsultaNotasGiro objRespuestaTrama;
		
		//se envia la trama y se obtiene respuesta
		objEnvioTrama = new ConsultaNotasGiro(pObjUsuario,
											  pObjFactura);

		//se envia la trama y se obtiene respuesta
		//objRespuestaTrama = (RespuestaConsultaNotasGiro)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaConsultaNotasGiro)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		//se valida que la trama no haya presentado problemas
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())) {
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
													   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
													   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}

	/**
	 * ****************************************************************.
	 * @metodo: consultarParametros
	 * @descripcion: llama la trama de actualizar las notas de un giro.
	 * @param objFactura
	 * @param pNota
	 * @return RespuestaActualizaNotasGiro
	 * @throws Exception
	 * @autor: CesarO.Rendon
	 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
	 * ****************************************************************
	 */
	public RespuestaActualizaNotasGiro actualizaNotasGiro(Usuario pObjUsuario,
														  Factura objFactura, 
														  String pNota) throws Exception{
		ActualizaNotasGiro objEnvioTrama;
		RespuestaActualizaNotasGiro objRespuestaTrama;

		//se crea la entidad de la trama que se va a enviar
		objEnvioTrama = new ActualizaNotasGiro(pObjUsuario,
											   objFactura, 
											   pNota);

		//se envia la trama y se obtiene respuesta
		//objRespuestaTrama = (RespuestaActualizaNotasGiro)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaActualizaNotasGiro)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		//se valida que la trama no haya presentado problemas
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())) {
		
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
		
		return objRespuestaTrama;
	}
}

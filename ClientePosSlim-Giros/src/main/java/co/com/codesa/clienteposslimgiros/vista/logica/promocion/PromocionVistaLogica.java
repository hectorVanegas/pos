package co.com.codesa.clienteposslimgiros.vista.logica.promocion;

import co.com.codesa.clienteposslimcontrolador.conexion.ProcesadorTramas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.utilidades.vistaLogica.UtilVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.CalcularPromociones;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultaFormatoImpresion;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaCalcularPromociones;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;


public class PromocionVistaLogica {

	/**
	 * @variable instancia
	 * 			 atributo que vuelve estatico los accesos hacia las 
	 * 			 funciones que agrupa la clase de PromocionVistaLogica
	 **/
	private static PromocionVistaLogica instancia;

	/**
	 * ****************************************************************.
	 * @metodo PromocionVistaLogica
	 * 		   Metodo constructor que se firma como privado, para 
	 * 		   garantizar que solo se instancie un objeto de la clase, 
	 * 		   a traves del getInstance
	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada  
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	private PromocionVistaLogica() throws Exception{}

	/**
	 * ****************************************************************.
	 * @metodo getInstance
	 * 		   Metodo encargado de controlar e inicializar la instancia 
	 * 		   de la clase, para instanciarla una unica vez durante todo 
	 * 		   el ciclo de vida de la aplicacion (patron singleton)
	 * @return PromocionVistaLogica
	 * 		   tipo de obj que representa a la clase misma
	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada  
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public static PromocionVistaLogica getInstance()throws Exception{

		if(instancia==null){
			instancia = new PromocionVistaLogica();
		}

		return instancia;
	}

	public void calcularPromociones(Usuario pObjUsuario,
									FacturaGiro pObjFacturaGiro,
									String pStrConcepto)throws Exception{
		/**
		 * [Trama 55 | Calcular promociones]
		 */
		
		CalcularPromociones objEnvioTrama;
		RespuestaCalcularPromociones objRespuestaTrama;
		
		objEnvioTrama = new CalcularPromociones(pObjUsuario,
												pObjFacturaGiro,
												pStrConcepto);
		
		//objRespuestaTrama = (RespuestaCalcularPromociones) ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaCalcularPromociones)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())) {
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
				       								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
				       								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
}

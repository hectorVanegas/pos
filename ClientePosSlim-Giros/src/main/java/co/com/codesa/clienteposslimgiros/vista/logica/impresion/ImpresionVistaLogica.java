package co.com.codesa.clienteposslimgiros.vista.logica.impresion;

import java.util.StringTokenizer;

import co.com.codesa.clienteposslimcontrolador.conexion.ProcesadorTramas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumImpresiones;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumRecursosProperties;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumReimpresiones;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumTiposImpresora;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.clienteposslimgiros.utilidades.vistaLogica.UtilVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultaFormatoImpresion;
import co.com.codesa.codesawrapper.modelo.dominio.ParametroSistema;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultaFormatoImpresion;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.VariablesImpresion;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.reimpresion.resultado.ProcesarResultadosReimpresionDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionDTO;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;
import co.com.codesa.codesawrapper.modelo.interfaces.IEntidadTrama;
import co.com.codesa.codesawrapper.modelo.interfaces.IRespuestaTrama;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 27-abr-2015 
 * @clase ImpresionVistaLogica 
 * 		  Clase implementada con patron de diseño singleton, que 
 * 		  permite acceder a las diferentes funcionalidades que invocan 
 * 		  y procesan peticiones de tramas, relacionadas con el proceso 
 * 		  de negocio de sesion, por ejemplo: el proceso de autenticacion
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class ImpresionVistaLogica {

	/**
	 * @variable instancia 
	 * 			 atributo que vuelve estatico los accesos hacia las 
	 * 		   	 funciones que agrupa la clase de ImpresionVistaLogica
	 **/
	private static ImpresionVistaLogica instancia;
	
	/**
	 * @variable booRealizarDobleImpresion 
	 * 			 atributo que vuelve que permite identificar si se realiza 
	 * 			 la doble impresion de la tirilla para un tercero apoderado
	 **/
	private boolean booRealizarDobleImpresion;
	
	/**
  	 * ****************************************************************.
  	 * @metodo ImpresionVistaLogica
  	 * 		   Metodo constructor que se firma como privado, para 
  	 * 		   garantizar que solo se instancie un objeto de la clase, 
  	 * 		   a traves del getInstance 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private ImpresionVistaLogica(){
		
		this.booRealizarDobleImpresion = false;
		
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo getInstancia
  	 * 		   Metodo encargado de controlar e inicializar la instancia 
  	 * 		   de la clase, para instanciarla una unica vez durante todo 
  	 * 		   el ciclo de vida de la aplicacion (patron singleton)
  	 * @return ImpresionVistaLogica
  	 * 		   tipo de obj que representa a la clase misma
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public static ImpresionVistaLogica getInstancia(){
		
		if(instancia==null){
			instancia = new ImpresionVistaLogica();
		}
		
		return instancia;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo generarCadenaImpresion
  	 * 		   Metodo que permite consultar y construir el formato de 
  	 * 		   impresion solicitado, retornando una cadena de impresion
  	 * 		   apta para la salida
  	 * @param pEnmImpresion
  	 * 		  constante de enumerador, que representa al parametro del
  	 * 		  sistema que identifica el nombre de la impresion solicitada
  	 * @param pEnmTipoImpresora
  	 * 		  constente de enumerador, que identifica el tipo de impresora
  	 * 		  sobre la cual se debe generar el formato de impresion
  	 * @param pObjVariablesImpresion
  	 * 		  variables propias, equivalentes al proceso operativo de la 
  	 * 		  transaccion, que se acaba de realizar
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public String generarCadenaImpresion(Usuario pObjUsuario,
										 EnumImpresiones pEnmImpresion,
										 EnumTiposImpresora pEnmTipoImpresora,
								   		 VariablesImpresion pObjVariablesImpresion)throws Exception{
		/**
		 * [Trama 148 | gestionar formato de impresion: Trama utilizada para consultar el
		 * formato y construir la impresion solicitada]
		 */
		
		ParametroSistema objParNombreImpresion;
		ConsultaFormatoImpresion objEnvioTrama;
		RespuestaConsultaFormatoImpresion objRespuestaTrama;
		String strCadenaImpresion = null;
		
		objParNombreImpresion = UtilParametrosSistema.getInstance().consultar(pEnmImpresion.getEnmParSisNombreFormato());
		
		if(objParNombreImpresion.getValor() == null){
			
			throw EnumMensajes.FORMATO_IMPRESION_NO_ENCONTRADO.generarExcepcion(EnumClasesMensaje.ERROR, 
																				"",
																				pEnmTipoImpresora.getStrAbreviatura()); 
		}
		
		objEnvioTrama = new ConsultaFormatoImpresion(pObjUsuario,
													 objParNombreImpresion.getValor(),
													 pEnmTipoImpresora.getStrAbreviatura(),
													 pObjVariablesImpresion);
		
		//objRespuestaTrama = (RespuestaConsultaFormatoImpresion)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaConsultaFormatoImpresion)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {//respuesta positiva
			
			strCadenaImpresion = objRespuestaTrama.getValorAtributoObj("strCadenaImpresion").toString();
			
		}else{//respuesta negativa
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
												       		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
												       		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
		
		return strCadenaImpresion;
	}
	
	public String generarCadenaImpresion(Usuario pObjUsuario,
										 EnumParametrosSistema pEnmImpresion,
										 EnumTiposImpresora pEnmTipoImpresora,
										 VariablesImpresion pObjVariablesImpresion)throws Exception{
		/**
		 * [Trama 148 | gestionar formato de impresion: Trama utilizada para consultar el
		 * formato y construir la impresion solicitada]
		 */

		ParametroSistema objParNombreImpresion;
		ConsultaFormatoImpresion objEnvioTrama;
		RespuestaConsultaFormatoImpresion objRespuestaTrama;
		String strCadenaImpresion = null;

		objParNombreImpresion = UtilParametrosSistema.getInstance().consultar(pEnmImpresion);

		if(objParNombreImpresion.getValor() == null){

			throw EnumMensajes.FORMATO_IMPRESION_NO_ENCONTRADO.generarExcepcion(EnumClasesMensaje.ERROR, 
					"",
					pEnmTipoImpresora.getStrAbreviatura()); 
		}

		objEnvioTrama = new ConsultaFormatoImpresion(pObjUsuario,
				objParNombreImpresion.getValor(),
				pEnmTipoImpresora.getStrAbreviatura(),
				pObjVariablesImpresion);

		//objRespuestaTrama = (RespuestaConsultaFormatoImpresion)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaConsultaFormatoImpresion)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {//respuesta positiva

			strCadenaImpresion = objRespuestaTrama.getValorAtributoObj("strCadenaImpresion").toString();

		}else{//respuesta negativa

			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					(String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					(String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}

		return strCadenaImpresion;
	}
	
	public EnumTiposImpresora obtenerTipoImpresora()throws Exception{
		
		EnumTiposImpresora enmTipoImpresora;
		String strTipoImpresoraConfigurada;
		
		//ControladorEtiquetas.configuracion_impresora.getString(EnumParametrosApp.TIPO_IMPRESION.getValorPropiedad())
		strTipoImpresoraConfigurada = EnumRecursosProperties.CONFIGURACION_IMPRESORA.getRsbRecurso().getString(EnumParametrosApp.TIPO_IMPRESION.getValorPropiedad());
		
		if(EnumTiposImpresora.MEDIA_CARTA.getStrAbreviatura().equals(strTipoImpresoraConfigurada)){
			enmTipoImpresora = EnumTiposImpresora.MEDIA_CARTA;
		}else if(EnumTiposImpresora.TIRILLA.getStrAbreviatura().equals(strTipoImpresoraConfigurada)){
			enmTipoImpresora = EnumTiposImpresora.TIRILLA;
		}else{
			enmTipoImpresora = null;
		}
		
		return enmTipoImpresora;
	}

	public void consultarParaReimpresion(Usuario pObjUsuario,
										 EnumReimpresiones pEnmReimpresion,
										 VariablesImpresionDTO pObjVariablesImpresion,
										 ProcesarResultadosReimpresionDTO pObjResultadosReimpresion)throws Exception{
		
		IEntidadTrama objEnvioTrama;
		IRespuestaTrama objRespuestaTrama;
		if (pEnmReimpresion.getClsEntTrmEnvio()!=null) {
			
			objEnvioTrama = pEnmReimpresion.getClsEntTrmEnvio().getDeclaredConstructor(pObjUsuario.getClass(),
					String.class,
					pObjVariablesImpresion.getClass(),
					pObjResultadosReimpresion.getClass(),
					pEnmReimpresion.getObjParametrosReimpresion().getHmDatosAdicionales().getClass(),
					Object[].class).newInstance(pObjUsuario,
												pEnmReimpresion.getStrCodigo(),
												pObjVariablesImpresion,
												pObjResultadosReimpresion,
											    pEnmReimpresion.getObjParametrosReimpresion().getHmDatosAdicionales(),
											    pEnmReimpresion.getArrObjConstantes());
			//objRespuestaTrama = ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
			objRespuestaTrama = UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
			
			if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())) {
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
				 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
				 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
			}
		}
		
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo verificarDobleImpresionTerceroApoderado
  	 * 		   Metodo que permite verificar si se realiza la doble impresion
  	 * 		   de la tirilla para un pago con apoderado
  	 * @param pObjTercero
  	 * 		  Objeto tercero origen, para saber si es un convenio parametrizado
  	 * 		  para la doble impresion
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Jefferson Ruiz
  	 * ****************************************************************
  	 */
	public void verificarDobleImpresionTerceroApoderado(Tercero pObjTercero) throws Exception {
		
		boolean booDobleImpresion;
		ParametroSistema objParametrosSistemas;
		String strDobleImpresion;
		String strTerceroDobleImpresion;
		StringTokenizer objTokenizerPuntoComa;
		StringTokenizer objTokenizerPipe;
		String strTercerosConvenios;
		String strTipoDocumentoConvenio;
		String strNumeroDocumentoConvenio;
		
		booDobleImpresion = false;
		objParametrosSistemas = UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.CONTROL_DOBLE_IMPRESION_TIRILLA_APODERADO);
		strDobleImpresion = objParametrosSistemas.getValor();
		
		if (strDobleImpresion.equals("S")) {
			
			objParametrosSistemas = UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.TERCERO_CONVENIO_DOBLE_IMPRESION_TIRILLA);
			strTerceroDobleImpresion = objParametrosSistemas.getValor();
			objTokenizerPuntoComa =  new StringTokenizer(strTerceroDobleImpresion,EnumGeneralidadesTramasGiros.PUNTO_Y_COMA.getValor());
			
			while (objTokenizerPuntoComa.hasMoreTokens()) {
				
				strTercerosConvenios = objTokenizerPuntoComa.nextToken();
				
				if (!strTercerosConvenios.contains(EnumGeneralidadesTramasGiros.PIPE.getValor())) {
					
					throw EnumMensajes.ESTRUCTURA_PARAMETRO_IDREOPIE.generarExcepcion(EnumClasesMensaje.ERROR);
				}
				
				objTokenizerPipe = new StringTokenizer(strTercerosConvenios,EnumGeneralidadesTramasGiros.PIPE.getValor());
				
				while (objTokenizerPipe.hasMoreTokens()) {
					
					strTipoDocumentoConvenio = objTokenizerPipe.nextToken();
					strNumeroDocumentoConvenio = objTokenizerPipe.nextToken();
					
					if (strTipoDocumentoConvenio.equals(pObjTercero.getTipoIdentificacion().getId()) &&
							strNumeroDocumentoConvenio.equals(pObjTercero.getIdentificacion())) {
						
						booDobleImpresion = true;
						
					}
					
				}
				
			}
			
		}
		
		
		this.booRealizarDobleImpresion = booDobleImpresion;
	}

	public boolean isBooRealizarDobleImpresion() {
		return booRealizarDobleImpresion;
	}

	public void setBooRealizarDobleImpresion(boolean booRealizarDobleImpresion) {
		this.booRealizarDobleImpresion = booRealizarDobleImpresion;
	}
	
	
	
	
	
}

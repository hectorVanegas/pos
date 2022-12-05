/** 
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
package co.com.codesa.clienteposslimgiros.vista.logica;

import java.util.List;
import java.util.Vector;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.utilidades.integracion.slimGiros.UtilIntegracionSlimGiros;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.clienteposslimgiros.utilidades.vistaLogica.UtilVistaLogica;
import co.com.codesa.clienteposslimgiros.utilidades.xml.XmlDatosEntidades;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ActualizarTercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultarConvenios;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.CreaActualizaTercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DatoEntidad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.EnrolarTerceroCliente;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.InsertarTercero;
import co.com.codesa.codesawrapper.modelo.dominio.ParametroSistema;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultarTercero585;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultarTerceroUsuario;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaActualizarTercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarTerceroUsuario;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaCreaActualizaTercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaEnrolarTerceroCliente;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaInsertarTercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaValidaHuellaBiometriaTercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Sede;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Territorio;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ValidaHuellaBiometriaTercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultaPropiedadesXConvenio;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultaSedesConvenio;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultaPropiedadesXConvenio;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultaSedesConvenio;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarConvenios;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarTercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarTercero577;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarTercero585;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaValidarPropiedadConvenio;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ValidarPropiedadConvenio;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Convenio;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Propiedad;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;


/**
 * ****************************************************************.
 * @autor: CesarO.Rendon
 * @fecha: 19-mar-2015 
 * @descripcion: clase encargada de manejar el llamado a las tramas de tercero.
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class TerceroVistaLogica {

	private static TerceroVistaLogica instancia ;

	/**
	 * ****************************************************************.
	 * @metodo: ValidacionesTercero
	 * @descripcion: contructor de la logica.
	 * @autor: CesarO.Rendon
	 * ****************************************************************
	 */
	private TerceroVistaLogica(){}	
	
	
	/**
	 * ****************************************************************.
	 * @metodo: getInstance
	 * @descripcion: metodo para cumplir con el patron singleton y tener
	 * una unica instancia de la clase para se accedida.
	 * @autor: CesarO.Rendon
	 * ****************************************************************
	 */
	public static TerceroVistaLogica getInstance(){		
		if (instancia == null)
			instancia= new TerceroVistaLogica();
		
		return instancia;
	}
	
	public Tercero consultarTercero(Usuario pObjUsuario,
									DatoEntidad pObjDatTipoDocumento, 
									String pStrDocumento,
									boolean pBooConsultaTerceroRecaudo) throws Exception{
		/**
		 * [Trama 511 | Consultar Informacion de Tercero]
		 * [Trama 443 | Consultar Informacion de Tercero para producto Recaudo]
		 * [Trama 585 | Consultar Tercero con marcaci�n de declaraci�n obligatoria de fondos (DOF)]
		 */

		ConsultarTercero585 objEnvioTrama;
		RespuestaConsultarTercero585 objRespuestaTrama;
		Tercero objTercero;
		String strParametroMensaje;
		
		objEnvioTrama = new ConsultarTercero585(pObjUsuario,
											 pObjDatTipoDocumento.getId(),
											 pStrDocumento,
											 pBooConsultaTerceroRecaudo);
		//objRespuestaTrama = (RespuestaConsultarTercero471)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaConsultarTercero585) UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {//respuesta positiva
			
			objTercero = (Tercero)objRespuestaTrama.getValorAtributoObj("objTercero");
			
			if(pBooConsultaTerceroRecaudo){
			
				this.procesarConsultaTerceroRecaudo(objTercero);
			}
			
		}else{//respuesta negativa
			
			if(EnumMensajes.AGENCIA_SE_ENCUENTRA_INACTIVA.getCodigo().equals((String)objRespuestaTrama.getValorAtributoObj("codigoError"))){
				
				strParametroMensaje = null;
				
			}else{
			
				strParametroMensaje = pObjDatTipoDocumento.getValor()+". "+pStrDocumento;
			}
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"),
					   								   		 strParametroMensaje);
		}
		
		return objTercero;
	}
	
	/**
     ************************************************************************************************
     * @metodo: consultarTerceroExterno
     * @descripcion: metodo utilizado para consultar un tercero proveniente de la red de matrix
     * 				este metodo se usa para consultar un tercero y saber si existe en base de datos 
     * 				o no, tercero que proviene de la red de matrix y asi tomar la decision que logica 
     * 				ejecutar
     * @return: objeto Tercero
     * @autor: Jefferson Ruiz
     *************************************************************************************************
     */		
	public Tercero consultarTerceroExterno(Usuario pObjUsuario, 
										   DatoEntidad pObjDatTipoDocumento, 
										   String pStrDocumento) throws Exception {
		/**
		 * [Trama 577 | Consultar Informacion de Tercero]
		 */

		ConsultarTercero585 objEnvioTrama;
		RespuestaConsultarTercero585 objRespuestaTrama;
		Tercero objTercero;
		String strParametroMensaje;
		boolean booConsultaTerceroRecaudo;
		
		booConsultaTerceroRecaudo = false;

		objEnvioTrama = new ConsultarTercero585(pObjUsuario, 
												pObjDatTipoDocumento.getId(), 
												pStrDocumento,
												booConsultaTerceroRecaudo);

		objRespuestaTrama = (RespuestaConsultarTercero585) UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString()
				.equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {// respuesta positiva

			objTercero = (Tercero) objRespuestaTrama.getValorAtributoObj("objTercero");

		} else {// respuesta negativa

			objTercero = null;
			
		}

		return objTercero;
	}
	
	private void procesarConsultaTerceroRecaudo(Tercero pObjTercero)throws Exception{
		
		ParametroSistema objParSisValidaBloqueadoXRiesgos = null;
		ParametroSistema objParSisValidaRequiereBiometria = null;
		
		if(pObjTercero.isBloqueadoRiesgos() 
				|| pObjTercero.getObjBiometria().isRequiereBiometria()){
			
			UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.VALIDA_TERCERO_RECAUDO_BLOQUEADO_X_RIESGO,
					  									  EnumParametrosSistema.VALIDA_TERCERO_RECAUDO_REQUIERE_BIOMETRIA);
		
			objParSisValidaBloqueadoXRiesgos = EnumParametrosSistema.VALIDA_TERCERO_RECAUDO_BLOQUEADO_X_RIESGO.obtenerObjParametro(); 
			objParSisValidaRequiereBiometria = EnumParametrosSistema.VALIDA_TERCERO_RECAUDO_REQUIERE_BIOMETRIA.obtenerObjParametro();
			
			if(pObjTercero.isBloqueadoRiesgos()
					&& objParSisValidaBloqueadoXRiesgos != null
					&& objParSisValidaBloqueadoXRiesgos.getValor().trim().equalsIgnoreCase("N")){
				
				pObjTercero.setBloqueadoRiesgos(false);
			}
			
			if(pObjTercero.getObjBiometria().isRequiereBiometria()
					&& objParSisValidaRequiereBiometria != null
					&& objParSisValidaRequiereBiometria.getValor().trim().equalsIgnoreCase("N")){
				
				pObjTercero.getObjBiometria().setRequiereBiometria(false);
			}
		}
	}

	public void actualizarTercero(Usuario pObjUsuario,
								  Tercero pObjTercero) throws Exception{
		
		/**
		 * [Trama 142 | Actualizar informacion de tercero]
		 */

		ActualizarTercero objEnvioTrama;
		RespuestaActualizarTercero objRespuestaTrama;
		
		objEnvioTrama = new ActualizarTercero(pObjUsuario,
											  pObjTercero);
		
		//objRespuestaTrama = (RespuestaActualizarTercero)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaActualizarTercero)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())) {//respuesta negativa
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"),
					   								   		 pObjTercero.toStringXDocumento());
		}
	}
	
	public void crearTercero(Usuario pObjUsuario,
							 Tercero pObjTercero) throws Exception{
		/**
		 * [Trama 141 | Crear tercero (insertar)]
		 */

		InsertarTercero objEnvioTrama;
		RespuestaInsertarTercero objRespuestaTrama;
		
		objEnvioTrama = new InsertarTercero(pObjUsuario,
											pObjTercero);
		
		//objRespuestaTrama = (RespuestaInsertarTercero)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaInsertarTercero)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())) {//respuesta negativa
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"),
					   								   		 pObjTercero.toStringXDocumento());
		}
	}
	
	public void validaTercero(Usuario pObjUsuario,
							  Tercero pObjTercero,
							  boolean pBooTipoTercero)throws Exception{
		/**
		 * [Trama 568 | Crea el tercero remitente o beneficiario para matrix]
		 */
		
		CreaActualizaTercero objEnvioTrama;
		RespuestaCreaActualizaTercero objRespuestaTrama;
		ParametroSistema objParDatoDRedExterna;
		
		objParDatoDRedExterna = UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.DATO_D_RED_EXTERNA_ENCABEZADO_TRAMA);
		
		objEnvioTrama = new CreaActualizaTercero(pObjUsuario,
												 objParDatoDRedExterna.getValor(),
												 pObjTercero,
												 pBooTipoTercero);
		
		//objRespuestaTrama = (RespuestaCreaActualizaTercero) ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaCreaActualizaTercero)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())) {//respuesta negativa
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
	/**
     * ****************************************************************
     * @metodo: consultarConvenios
     * @descripcion: metodo utilizado para consultar los terceros convenios
     * @return: Vector<Convenios> vector con los convenios
     * @autor: Roberth Martinez Vargas
     *         ****************************************************************
     */	
	@SuppressWarnings("unchecked")
	public Vector<Convenio> consultarConvenios(Usuario pObjUsuario) throws Exception{
		
		/**
		 * [Trama 139 | Consultar convenios]
		 */
		
		Vector<Convenio> vecConvenios;
		ConsultarConvenios objEnvioTrama;
		RespuestaConsultarConvenios objRespuestaTrama;
		
		objEnvioTrama = new ConsultarConvenios(pObjUsuario);	
		
		//objRespuestaTrama = (RespuestaConsultarConvenios)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaConsultarConvenios)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		vecConvenios = (Vector<Convenio>) objRespuestaTrama.getValorAtributoObj("convenios");
		
		return vecConvenios;
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo consultarSedesConvenio
     * 	       metodo utilizado para consultar las sedes asociadas a un
     * 		   convenio por zona
     * @return List<Sede> lista de sedes del convenio
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */	
	@SuppressWarnings("unchecked")
	public List<Sede> consultarSedesConvenio(Usuario pObjUsuario,
											 Territorio pObjMunicipio, 
											 Territorio pObjZona, 
											 Convenio pObjConvenio) throws Exception{
		/**
		 * [Trama 396 | Consultar Sedes convenio por Zona]
		 */
		
		List<Sede> lstSedes = null;
		ConsultaSedesConvenio objEnvioTrama;
		RespuestaConsultaSedesConvenio objRespuestaTrama;
		
		objEnvioTrama = new ConsultaSedesConvenio(pObjUsuario,
												  pObjMunicipio, 
												  pObjZona, 
												  pObjConvenio);

		//objRespuestaTrama = (RespuestaConsultaSedesConvenio)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaConsultaSedesConvenio)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
		
			lstSedes = (List<Sede>) objRespuestaTrama.getValorAtributoObj("lstSedesConvenio");
			
		}else{
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   	     (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
		
		return lstSedes;
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo consultarPropiedadesConvenio
     * 	       metodo utilizado para consultar las propiedades 
     * 		   asociadas a un convenio
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */	
	public void consultarPropiedadesConvenio(Usuario pObjUsuario,
											 FacturaGiro pFaturaGiro) throws Exception{
		/**
		 * [Trama 436 | Consultar Propiedades de convenio]
		 */
		
		ConsultaPropiedadesXConvenio objEnvioTrama;
		RespuestaConsultaPropiedadesXConvenio objRespuestaTrama;
		
		objEnvioTrama = new ConsultaPropiedadesXConvenio(pObjUsuario,
														 pFaturaGiro);

		//objRespuestaTrama = (RespuestaConsultaPropiedadesXConvenio)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaConsultaPropiedadesXConvenio)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())) {
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   	     (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
	
	/** 
	 * ********************************************************************
	 * @method validarPropiedadConvenio
	 * 		   metodo utilizado para validar el valor de una propiedad 
     * 		   si cumple con la expresion regular
	 * @param  pObjUsuario
	 * 		   Objeto usuario de la aplicacion
	 * @param  pPropiedad
	 * 		   propiedad a evaluar
	 * @param  pStrSubValorPropiedad
	 * 		   valor propiedad
	 * @return String
	 * 		   resultado de la validacion mediante la trama
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   12/11/2016
	 * *********************************************************************
	 */
	public String validarPropiedadConvenio(Usuario pObjUsuario,
										   Propiedad pPropiedad, 
										   String pStrSubValorPropiedad) throws Exception{
		/**
		 * [Trama 437 | Validar Propiedad de convenio]
		 */
		
		ValidarPropiedadConvenio objEnvioTrama;
		RespuestaValidarPropiedadConvenio objRespuestaTrama;
		
		objEnvioTrama = new ValidarPropiedadConvenio(pObjUsuario,
													 pPropiedad, 
													 pStrSubValorPropiedad);

		//objRespuestaTrama = (RespuestaValidarPropiedadConvenio)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaValidarPropiedadConvenio)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())) {
		
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
				   		 								     (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
				   		 								     (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));	
		}
		
		return (String)objRespuestaTrama.getValorAtributoObj("strValorValido");
	}
	
	
	/** 
	 * ********************************************************************
	 * @method validaHuellaBiometriaTercero
	 * 		   metodo utilizado para validar la biometria al tercero 
	 * 		   enviando la trama VALIDA_HUELLA_BIO_TERCERO
	 * @param  pObjUsuario
	 * 	       objeto usuario de a aplicacion
	 * @param  pObjTercero
	 * 		   objeto tercero a validar
	 * @param  pStrBloqueado
	 * 		   indicador de la bandera del  1 2 3, S o N dependiendo el 
	 * 		   intento que se esta ejecutando 
	 * @param  pStrAccion
	 * 		   accion
	 * @return String
	 * 		   Respuesta de la trama enviada
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   11/11/2016
	 * *********************************************************************
	 */
	public String validaHuellaBiometriaTercero(Usuario pObjUsuario,
											   Tercero pObjTercero,
											   String pStrBloqueado,
											   String pStrAccion ) throws Exception{

		long lnTiempoInicial;
		long lnTiempoTotal;
		ValidaHuellaBiometriaTercero objEnvioTrama;
		RespuestaValidaHuellaBiometriaTercero objRespuestaTrama;
		String strRespuestaValidaBiometria = null;
		
		objEnvioTrama = new ValidaHuellaBiometriaTercero(pObjUsuario,
														 pObjTercero, 
													  	 pStrBloqueado, 
													  	 pStrAccion);
		lnTiempoInicial = System.currentTimeMillis();
		//objRespuestaTrama = (RespuestaValidaHuellaBiometriaTercero)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaValidaHuellaBiometriaTercero)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		lnTiempoTotal = System.currentTimeMillis() - lnTiempoInicial;
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
			
			strRespuestaValidaBiometria = (String) objRespuestaTrama.getValorAtributoObj("strRespuestaValidBio");
			pObjTercero.getObjBiometria().setStrRespuestaAfis(strRespuestaValidaBiometria);
			pObjTercero.getObjBiometria().setStrTiempoRespuestaAfis(lnTiempoTotal+"");
			pObjTercero.getObjBiometria().setStrTiempoAfis(UtilidadGiros.getInstancia().getFecha(UtilIntegracionSlimGiros.getInstance().obtenerFechaHoraActualPosSlim(), UtilidadGiros.getInstancia().getFORMATEADOR_FECHA_SLASH_COMPLETO()));

		}else{
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
													   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
													   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
		
		return strRespuestaValidaBiometria;
	}
	
	
	/** 
	 * ********************************************************************
	 * @method registraHuellaEnrolarTercero
	 * 		   metodo utilizado para realizar el enrolamiento al 
     * 		   tercero
	 * @param  pObjUsuario
	 * 		   Objeto usuario de la aplicacion
	 * @param  pObjTercero
	 *         objeto tercero a enrolar
	 * @param  pStrHuellaWsqDerecha
	 *         huella wsq derecha
	 * @param  pStrHuellaWsqIzquierda
	 *         huella wsq izquierda
	 * @param  pStrHuellaDerecha
	 *         iso huella derecha
	 * @param  pStrHuellaIzquierda
	 * 	       iso huella izquierda
	 * @return String
	 *         resultado de la trama enviada
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   12/11/2016
	 * *********************************************************************
	 */
	public String registraHuellaEnrolarTercero(Usuario pObjUsuario,
											   Tercero pObjTercero,
											   String pStrHuellaWsqDerecha,
										  	   String pStrHuellaWsqIzquierda,
										  	   String pStrHuellaDerecha,
										  	   String pStrHuellaIzquierda) throws Exception{
		
		long lnTiempoInicial;
		long lnTiempoTotal;
		EnrolarTerceroCliente objEnvioTrama;
		RespuestaEnrolarTerceroCliente objRespuestaTrama;
		String strRespuestaEnrolaTercero = null;
		
		objEnvioTrama = new EnrolarTerceroCliente(pObjUsuario,
												  pObjTercero, 
												  pStrHuellaWsqDerecha, 
												  pStrHuellaWsqIzquierda, 
												  pStrHuellaDerecha, 
												  pStrHuellaIzquierda);

		lnTiempoInicial = System.currentTimeMillis();
		//objRespuestaTrama = (RespuestaEnrolarTerceroCliente)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaEnrolarTerceroCliente)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		lnTiempoTotal = System.currentTimeMillis() - lnTiempoInicial;
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
			
			strRespuestaEnrolaTercero = (String) objRespuestaTrama.getValorAtributoObj("strResEnrolaTercero");
			pObjTercero.getObjBiometria().setStrRespuestaAfis(strRespuestaEnrolaTercero);
			pObjTercero.getObjBiometria().setStrTiempoRespuestaAfis(lnTiempoTotal+"");
			pObjTercero.getObjBiometria().setStrTiempoAfis(UtilidadGiros.getInstancia().getFecha(UtilIntegracionSlimGiros.getInstance().obtenerFechaHoraActualPosSlim(), UtilidadGiros.getInstancia().getFORMATEADOR_FECHA_SLASH_COMPLETO()));
			
		}else{
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
		
		return strRespuestaEnrolaTercero;
	}
	
	/** 
	 * ********************************************************************
	 * @method	consultarTerceroUsuario
	 * 		  	Metodo que permite consultar el tercero asociado al usuario,
	 * 			en este caso el usuario cajero
	 * @param 	pObjUsuario
	 * 			Usuario cajero que realiza la transaccion
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	5/09/2017
	 * *********************************************************************
	 */
	public void consultarTerceroUsuario(Usuario pObjUsuario) 
			throws Exception
	{
		/**
		 * [Trama 465 | Consultar el tercero asociado al usuario]
		 */
		
		ConsultarTerceroUsuario objEnvioTrama;
		RespuestaConsultarTerceroUsuario objRespuestaTrama;
		String strIdEntidadTipoIdentificacion;
		DatoEntidad objDatEntTipoIdentificacion;
		
		objEnvioTrama = new ConsultarTerceroUsuario(pObjUsuario);
		//objRespuestaTrama = (RespuestaConsultarTerceroUsuario)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaConsultarTerceroUsuario)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) 
		{
			strIdEntidadTipoIdentificacion = EnumParametrosApp.ENT_TIPOS_IDENTIFICACION.getValorPropiedad();
			objDatEntTipoIdentificacion = pObjUsuario.getObjTercero().getTipoIdentificacion();
			
			pObjUsuario.getObjTercero().setTipoIdentificacion(XmlDatosEntidades.getInstance().obtenerEntidad(strIdEntidadTipoIdentificacion).getHmDatos().get(objDatEntTipoIdentificacion.getId()));
			
		}	else	{
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
				   		 									(String)objRespuestaTrama.getValorAtributoObj("codigoError"),
				   		 									(String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
}

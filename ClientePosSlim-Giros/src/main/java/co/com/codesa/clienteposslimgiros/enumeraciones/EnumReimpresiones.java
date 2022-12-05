package co.com.codesa.clienteposslimgiros.enumeraciones;

import java.util.Date;

import co.com.codesa.clienteposslimgiros.dto.parametrosReimpresion.ParametrosReimpresionDTO;
import co.com.codesa.clienteposslimgiros.dto.parametrosReimpresion.ParametrosReimpresionXPinDTO;
import co.com.codesa.clienteposslimgiros.dto.parametrosReimpresion.ParametrosReimpresionXPinRemesasDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.impresion.EnumTiposImpresion;
import co.com.codesa.clienteposslimgiros.enumeraciones.peticionMultiservicio.EnumPeticionesMultiservicio;
import co.com.codesa.clienteposslimgiros.utilidades.integracion.slimGiros.UtilIntegracionSlimGiros;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ControlImpresionPQR;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ReimprimirEnvioGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ReimprimirGiroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ReimprimirIngresoEgreso;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ReimprimirPagoGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ReimprimirPagoInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ReimprimirUltimaPrueba;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ReimprimirUltimoArqueoCaja;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ReimprimirUltimoSMS;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaControlImpresionPQR;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaReimprimirEnvioGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaReimprimirEnvioGiroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaReimprimirIngresoEgreso;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaReimprimirPagoGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaReimprimirPagoInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaReimprimirUltimaPrueba;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaReimprimirUltimoArqueoCaja;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaReimprimirUltimoSMS;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaReimprimirUltimoSeguro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ReimprimirUltimoSeguro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Modulo;
import co.com.codesa.codesawrapper.modelo.interfaces.IEntidadTrama;
import co.com.codesa.codesawrapper.modelo.interfaces.IRespuestaTrama;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 05-oct-2015
 * @Clase EnumReimpresiones 
 * 		  Clase enumerador, que permite administrar de forma diciente 
 * 		  las reimpresiones configuradas para el sistema.
 * 
 * 		  Importante: Esta clase permite almacenar las configuraciones 
 * 		  			  necesarias para ejecutar una reimpresion, ya sea 
 * 					  por Pin o por Ultima Transaccion 
 *  
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public enum EnumReimpresiones {
	
	REIMPRIMIR_X_PIN_ENVIO_GIRO("reimprimir_x_pin_envio_giro",
								new Modulo("60"),
								EnumEtiquetas.TTL_RXP_ENVIO_GIRO,
								EnumImpresiones.ENVIO_GIRO_POSTAL,
								ParametrosReimpresionXPinDTO.class,
								ReimprimirEnvioGiro.class,
								RespuestaReimprimirEnvioGiro.class,
								EnumTiposImpresion.POR_PIN,
								EnumParametrosApp.CONCEPTO_NATURALEZA_INGRESO.getObjConstante(),//datenIdNat
								EnumParametrosApp.TIPO_REIMPRESION_ENVIO_GIRO.getObjConstante(),//tipoReimpresion
								EnumParametrosApp.TIPO_REIMPRESION_CONSTANTE.getObjConstante()),//typeCons
								
	REIMPRIMIR_X_PIN_PAGO_GIRO("reimprimir_x_pin_pago_giro",
							   new Modulo("60"),
							   EnumEtiquetas.TTL_RXP_PAGO_GIRO,
							   EnumImpresiones.PAGO_GIRO_POSTAL,
							   ParametrosReimpresionXPinDTO.class,
							   ReimprimirPagoGiro.class,
							   RespuestaReimprimirPagoGiro.class,
							   EnumTiposImpresion.POR_PIN,
							   EnumParametrosApp.CONCEPTO_NATURALEZA_EGRESO.getObjConstante(),//datenIdNat
							   EnumParametrosApp.TIPO_REIMPRESION_PAGO_GIRO.getObjConstante(),//tipoReimpresion
							   EnumParametrosApp.TIPO_REIMPRESION_CONSTANTE.getObjConstante()),//typeCons
							   
	REIMPRIMIR_X_PIN_INGRESO("reimprimir_x_pin_ingreso",
							 new Modulo("60"),
			 				 EnumEtiquetas.TTL_RXP_INGRESO,
			 				 EnumImpresiones.INGRESO_EGRESO,
			 				 ParametrosReimpresionXPinDTO.class,
			 				 ReimprimirIngresoEgreso.class,
			 				 RespuestaReimprimirIngresoEgreso.class,
			 				 EnumTiposImpresion.POR_PIN,
			 				 EnumParametrosApp.CONCEPTO_NATURALEZA_INGRESO.getObjConstante(),//datenIdNat
			 				 EnumParametrosApp.TIPO_REIMPRESION_INGRESO.getObjConstante(),//tipoReimpresion
			 				 EnumParametrosApp.TIPO_REIMPRESION_CONSTANTE.getObjConstante()),//typeCons
			 				 
	REIMPRIMIR_X_PIN_EGRESO("reimprimir_x_pin_egreso",
							new Modulo("60"),
						    EnumEtiquetas.TTL_RXP_EGRESO,
						    EnumImpresiones.INGRESO_EGRESO,
						    ParametrosReimpresionXPinDTO.class,
						    ReimprimirIngresoEgreso.class,
						    RespuestaReimprimirIngresoEgreso.class,
						    EnumTiposImpresion.POR_PIN,
						    EnumParametrosApp.CONCEPTO_NATURALEZA_EGRESO.getObjConstante(),//datenIdNat
						    EnumParametrosApp.TIPO_REIMPRESION_EGRESO.getObjConstante(),//tipoReimpresion
						    EnumParametrosApp.TIPO_REIMPRESION_CONSTANTE.getObjConstante()),//typeCons
	/*					    
	REIMPRIMIR_X_PIN_ENVIO_RECAUDO("reimprimir_x_pin_envio_recaudo",
								   new Modulo("60"),
						           EnumEtiquetas.TTL_RXP_ENVIO_RECAUDO,
						           EnumImpresiones.ENVIO_RECAUDO,
						           ParametrosReimpresionXPinDTO.class,
						           ReimprimirEnvioRecaudo.class,
						           RespuestaReimprimirEnvioRecaudo.class,
						           EnumReimpresiones.TIPO_REIMPRESION_X_PIN,
						           EnumParametrosApp.CONCEPTO_NATURALEZA_INGRESO.getObjConstante(),//datenIdNat
						           EnumParametrosApp.TIPO_REIMPRESION_ENVIO_RECAUDO.getObjConstante(),//tipoReimpresion
						           EnumParametrosApp.TIPO_REIMPRESION_CONSTANTE.getObjConstante()),//typeCons
	*/						
	REIMPRIMIR_ULTIMO_SEGURO("reimprimir_ultimo_seguro",
							 new Modulo("94"),
							 EnumEtiquetas.TTL_RUT_SEGURO,
							 EnumImpresiones.SEGURO,
							 null,
							 ReimprimirUltimoSeguro.class,
							 RespuestaReimprimirUltimoSeguro.class, 
							 EnumTiposImpresion.ULTIMA_TRANSACCION,
							 EnumParametrosApp.CONCEPTO_NATURALEZA_INGRESO.getObjConstante()),
					
	REIMPRIMIR_ULTIMO_SMS("reimprimir_ultimo_sms",
						  null,
						  EnumEtiquetas.TTL_RUT_SMS,
						  EnumImpresiones.SMS,
						  null,
					 	  ReimprimirUltimoSMS.class,
						  RespuestaReimprimirUltimoSMS.class,
						  EnumTiposImpresion.ULTIMA_TRANSACCION,
						  EnumParametrosApp.CONCEPTO_NATURALEZA_INGRESO.getObjConstante()),
						  
	REIMPRIMIR_ULTIMO_ENVIO_GIRO("reimprimir_ultimo_envio_giro",
							 	 new Modulo("35"),
								 EnumEtiquetas.TTL_RUT_ENVIO_GIRO,
								 EnumImpresiones.ENVIO_GIRO_POSTAL,
								 null,
							 	 ReimprimirEnvioGiro.class,
								 RespuestaReimprimirEnvioGiro.class,
								 EnumTiposImpresion.ULTIMA_TRANSACCION,
								 EnumParametrosApp.CONCEPTO_NATURALEZA_INGRESO.getObjConstante(),//datenIdNat
								 EnumParametrosApp.TIPO_REIMPRESION_ENVIO_GIRO.getObjConstante(),//tipoReimpresion
								 EnumParametrosApp.TIPO_REIMPRESION_CONSTANTE.getObjConstante()),//typeCons
								 
	REIMPRIMIR_ULTIMO_PAGO_GIRO("reimprimir_ultimo_pago_giro",
								new Modulo("36"),
								EnumEtiquetas.TTL_RUT_PAGO_GIRO,
								EnumImpresiones.PAGO_GIRO_POSTAL,
								null,
								ReimprimirPagoGiro.class,
								RespuestaReimprimirPagoGiro.class,
								EnumTiposImpresion.ULTIMA_TRANSACCION,
								EnumParametrosApp.CONCEPTO_NATURALEZA_EGRESO.getObjConstante(),//datenIdNat
								EnumParametrosApp.TIPO_REIMPRESION_PAGO_GIRO.getObjConstante(),//tipoReimpresion
								EnumParametrosApp.TIPO_REIMPRESION_CONSTANTE.getObjConstante()),//typeCons
								
	REIMPRIMIR_ULTIMO_INGRESO("reimprimir_ultimo_ingreso",
							  new Modulo("37"),
							  EnumEtiquetas.TTL_RUT_INGRESO,
							  EnumImpresiones.INGRESO_EGRESO,
							  null,
							  ReimprimirIngresoEgreso.class,
							  RespuestaReimprimirIngresoEgreso.class,
							  EnumTiposImpresion.ULTIMA_TRANSACCION,
							  EnumParametrosApp.CONCEPTO_NATURALEZA_INGRESO.getObjConstante(),//datenIdNat
							  EnumParametrosApp.TIPO_REIMPRESION_INGRESO.getObjConstante(),//tipoReimpresion
							  EnumParametrosApp.TIPO_REIMPRESION_CONSTANTE.getObjConstante()),//typeCons
							  
	REIMPRIMIR_ULTIMO_EGRESO("reimprimir_ultimo_egreso",
							 new Modulo("38"),
							 EnumEtiquetas.TTL_RUT_EGRESO,
							 EnumImpresiones.INGRESO_EGRESO,
							 null,
							 ReimprimirIngresoEgreso.class,
							 RespuestaReimprimirIngresoEgreso.class,
							 EnumTiposImpresion.ULTIMA_TRANSACCION,
							 EnumParametrosApp.CONCEPTO_NATURALEZA_EGRESO.getObjConstante(),//datenIdNat
							 EnumParametrosApp.TIPO_REIMPRESION_EGRESO.getObjConstante(),//tipoReimpresion
							 EnumParametrosApp.TIPO_REIMPRESION_CONSTANTE.getObjConstante()),//typeCons
							 
	REIMPRIMIR_ULTIMO_ARQUEO("reimprimir_ultimo_arqueo",
							 new Modulo("59"),
			                 EnumEtiquetas.TTL_RUT_ARQUEO,
			                 EnumImpresiones.CIERRE_CAJA,
							 null,
							 ReimprimirUltimoArqueoCaja.class,
							 RespuestaReimprimirUltimoArqueoCaja.class,
							 EnumTiposImpresion.ULTIMA_TRANSACCION,
							 EnumParametrosApp.CONCEPTO_NATURALEZA_EGRESO.getObjConstante(),//datenIdNat
							 EnumParametrosApp.TIPO_REIMPRESION_ARQUEO_CAJA.getObjConstante(),//tipoReimpresion
							 EnumParametrosApp.TIPO_REIMPRESION_CONSTANTE.getObjConstante()),//typeCons
	
//Reimpresion Remesas Internacionales
								
 
	REIMPRIMIR_X_PIN_ENVIO_REMESA("reimprimir_x_pin_envio_remesa",
 							new Modulo("60"), //REIMPRIMIR X PIN ENVIO REMESA INTERNACIONAL
 							EnumEtiquetas.TTL_RXP_ENVIO_REMESA,
							EnumImpresiones.ENVIO_GIRO_INTERNACIONAL,
							ParametrosReimpresionXPinRemesasDTO.class,
 							ReimprimirGiroInternacional.class,
							RespuestaReimprimirEnvioGiroInternacional.class,
 							EnumTiposImpresion.POR_PIN,
							EnumParametrosApp.TIPO_REIMPRESION_ENVIO_REMESA.getObjConstante(),//2 TipoOperacion
							EnumParametrosApp.DESCRIPCION_FPISA_ULTIMO_PAGO_INTERNACIONAL.getObjConstante(),//REFERENCIAFPISA
							EnumPeticionesMultiservicio.GIN_REIMPRESION_INTERNACIONAL.getObjServicioPeticionSinThrows()),
							//EnumParametrosSistema.CORRESPONSAL_ENVIO.obtenerValorCadenaSinThrows()),//typeCons	
 
							 							 
							 					 
	REIMPRIMIR_ULTIMO_ENVIO_REMESA("reimprimir_ultimo_envio_remesa",
					 	    new Modulo("20125"), //REIMPRIMIR ULTIMO ENVIO REMESA INTERNACIONAL
							EnumEtiquetas.TTL_RUT_ENVIO_REMESA,
							EnumImpresiones.ENVIO_GIRO_INTERNACIONAL,
							null,
							ReimprimirGiroInternacional.class,
							RespuestaReimprimirEnvioGiroInternacional.class,
							EnumTiposImpresion.ULTIMA_TRANSACCION,
							EnumParametrosApp.TIPO_REIMPRESION_ENVIO_REMESA.getObjConstante(),//2 TipoOperacion
							EnumParametrosApp.DESCRIPCION_FPISA_ULTIMO_PAGO_INTERNACIONAL.getObjConstante(),//REFERENCIAFPISA
							EnumPeticionesMultiservicio.GIN_REIMPRESION_INTERNACIONAL.getObjServicioPeticionSinThrows()),//typeCons		
							 							
							 							
							 							
	REIMPRIMIR_X_PIN_PAGO_REMESA("reimprimir_x_pin_pago_remesa",
 							new Modulo("60"), //REIMPRIMIR X PIN PAGO REMESA INTERNACIONAL
 							EnumEtiquetas.TTL_RXP_PAGO_REMESA,
 							EnumImpresiones.PAGO_GIRO_INTERNACIONAL,
 							ParametrosReimpresionXPinRemesasDTO.class,
 							ReimprimirPagoInternacional.class,
 							RespuestaReimprimirPagoInternacional.class,
 							EnumTiposImpresion.POR_PIN,
 							EnumParametrosApp.TIPO_REIMPRESION_PAGO_REMESA.getObjConstante(),//1 TipoOperacion
 							EnumParametrosApp.DESCRIPCION_FPISA_ULTIMO_PAGO_INTERNACIONAL.getObjConstante(),//REFERENCIAFPISA
 							EnumPeticionesMultiservicio.GIN_REIMPRESION_INTERNACIONAL.getObjServicioPeticionSinThrows()),
 							//InformacionSessionGirosInternacional.getInstanceSinThrows(null).getLstCorresponsales()),//typeCons		
					 												
							 							
							 										 
 	REIMPRIMIR_ULTIMO_PAGO_REMESA("reimprimir_ultimo_pago_remesa",
 							new Modulo("20124"), //REIMPRIMIR ULTIMO PAGO REMESA INTERNACIONAL
 							EnumEtiquetas.TTL_RUT_PAGO_REMESA, 
 							EnumImpresiones.PAGO_GIRO_INTERNACIONAL,
 							null,
 							ReimprimirPagoInternacional.class,
 							RespuestaReimprimirPagoInternacional.class,
 							EnumTiposImpresion.ULTIMA_TRANSACCION,
 							EnumParametrosApp.TIPO_REIMPRESION_PAGO_REMESA.getObjConstante(),//1 TipoOperacion
 							EnumParametrosApp.DESCRIPCION_FPISA_ULTIMO_PAGO_INTERNACIONAL.getObjConstante(),//REFERENCIAFPISA
 							EnumPeticionesMultiservicio.GIN_REIMPRESION_INTERNACIONAL.getObjServicioPeticionSinThrows()),//typeCons	
 							
   IMPRIMIR_PQR("imprimir_pqr",
 				null,
 				EnumEtiquetas.TTL_OTR_PQR,
 				EnumImpresiones.PQR,
 				null,
 				ControlImpresionPQR.class,
 				RespuestaControlImpresionPQR.class,
 				EnumTiposImpresion.OTROS,
 				"N"),
 				
    IMPRIMIR_DUPLICADO_PQR("imprimir_duplicado_pqr",
 		 				   null,
 		 				   EnumEtiquetas.TTL_OTR_DUPLICADO_PQR,
 		 				   EnumImpresiones.DUPLICADO_PQR,
 		 				   null,
 		 				   ControlImpresionPQR.class,
 		 				   RespuestaControlImpresionPQR.class,
 		 				   EnumTiposImpresion.OTROS,
 		 				   "S"),
 
							 
	REIMPRIMIR_ULTIMA_PRUEBA("reimprimir_ultima_prueba",//obligatorio
							 null,
							 EnumEtiquetas.TTL_RUT_PRUEBA,//obligatorio
							 EnumImpresiones.PAGINA_PRUEBA,//obligatorio
							 null,
							 ReimprimirUltimaPrueba.class,//obligatorio
							 RespuestaReimprimirUltimaPrueba.class,//obligatorio
							 null,//obligatorio
							 EnumTiposImpresion.POR_PIN,
							 1,
							 "constante_2",
							 UtilIntegracionSlimGiros.getInstance().obtenerFechaHoraActualPosSlim(),
							 "constante_4"),
	;

	
	/**
	 * @variable strCodigo 
	 * 			 Codigo o identificador de la reimpresion
	 **/
	private String strCodigo;
	
	/**
	 * @variable objOpcionMenu 
	 * 			 Objeto que representa el identificador de menu definido por 
	 * 			 SIMS, configurado sobre la constante para realizar el 
	 * 			 contraste con el listado de operaciones definidas para el 
	 * 			 usuario, que se da en el inicio de sesion
	 **/
	private Modulo objOpcionMenu;
	
	/**
	 * @variable enmEtiNombre 
	 * 			 Nombre de la reimpresion, este sera la etiqueta que se 
	 * 			 adicione al componente grafico para que el usuario pueda
	 * 			 seleccionarla
	 **/
	private EnumEtiquetas enmEtiNombre;
	
	/**
	 * @variable enmImpresion 
	 * 			 Constante de enumeracion que representa la impresion que se
	 * 			 llevara a cabo
	 **/
	private EnumImpresiones enmImpresion;
	
	/**
	 * @variable clsParametrosReimpresion
	 * 			 Clase representativa del objeto DTO que administra los parametros 
	 * 		  	 asociados a la reimpresion 
	 **/
	private Class<? extends ParametrosReimpresionDTO> clsParametrosReimpresion;
	
	/**
	 * @variable clsEntTrmEnvio
	 * 			 Clase representativa de la entidad trama para realizar el 
	 * 			 envio de peticion, y consultar la informacion necesaria 
	 * 			 para realizar la reimpresion 
	 **/
	private Class<? extends IEntidadTrama> clsEntTrmEnvio;
	
	/**
	 * @variable clsEntTrmRespuesta
	 * 			 Clase representativa de la Entidad trama referente a la respuesta 
	 * 			 de peticion, para procesar la informacion retornada necesaria para 
	 * 			 realizar la reimpresion 
	 **/
	private Class<? extends IRespuestaTrama> clsEntTrmRespuesta;
	
	/**
	 * @variable objParametrosReimpresion
	 * 			 Objeto que administra los parametros asociados a la reimpresion
	 **/
	private ParametrosReimpresionDTO objParametrosReimpresion;
	
	/**
	 * @variable arrObjConstantes
	 * 			 Lista de constantes utilizadas y configuradas por el proceso de 
	 * 			 reimpresion
	 **/
	private Object arrObjConstantes[];
	
	/**
	 * @variable	enmTipoImpresion
	 * 				Indica el tipo impresion
	 */
	private EnumTiposImpresion enmTipoImpresion;
	
	/**
  	 * ****************************************************************.
  	 * @metodo EnumReimpresiones
  	 * 		   Inicializacion de la constante de enumeracion
  	 * @param pStrCodigo
  	 * 		  Codigo o identificador de la reimpresion
  	 * @param pObjOpcionMenu
  	 * 		  Objeto que representa el identificador de menu definido por 
	 * 		  SIMS, configurado sobre la constante para realizar el 
	 * 		  contraste con el listado de operaciones definidas para el 
	 * 		  usuario, que se da en el inicio de sesion
  	 * @param pEnmEtiNombre
  	 * 		  Nombre con el cual se identifica la reimpresion, 
  	 * 		  administrado por el enumerador de etiquetas
  	 * @param pEnmImpresion
  	 * 		  EnumImpresiones identifica el parametro de sistema del formato de impresion
  	 * 		  variables dto y el procesador
  	 * @param pClsParametrosReimpresion
  	 * 		  Clase representativa del objeto DTO que administra los 
  	 * 		  parametros asociados a la reimpresion
  	 * @param pClsEntTrmEnvio
  	 * 		  Clase representativa de la entidad trama para realizar el 
  	 * 		  envio de peticion
  	 * @param pClsEntTrmRespuesta
  	 * 		  Clase representativa de la entidad trama referente a la 
  	 * 		  respuesta de peticion 
  	 * @param pEnmTipoImpresion
  	 * 		  permite identificar si la configuracion de 
  	 * 		  reimpresion hace parte de una reimpresion X Pin o reimpresion 
  	 * 		  de Ultima Transaccion
  	 * @param pArrObjConstantes
  	 * 		  Lista de constantes utilizadas y configuradas por el proceso
  	 * 		  de reimpresion
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private EnumReimpresiones(String pStrCodigo,
							  Modulo pObjOpcionMenu,
							  EnumEtiquetas pEnmEtiNombre,
							  EnumImpresiones pEnmImpresion,
							  Class<? extends ParametrosReimpresionDTO> pClsParametrosReimpresion,
							  Class<? extends IEntidadTrama> pClsEntTrmEnvio,
							  Class<? extends IRespuestaTrama> pClsEntTrmRespuesta,
							  EnumTiposImpresion pEnmTipoImpresion,
							  Object ...pArrObjConstantes){
		
		this.setStrCodigo(pStrCodigo);
		this.setObjOpcionMenu(pObjOpcionMenu);
		this.setEnmEtiNombre(pEnmEtiNombre);
		this.setEnmImpresion(pEnmImpresion);
		this.setClsParametrosReimpresion(pClsParametrosReimpresion);
		this.setClsEntTrmEnvio(pClsEntTrmEnvio);
		this.setClsEntTrmRespuesta(pClsEntTrmRespuesta);
		this.setEnmTipoImpresion(pEnmTipoImpresion);
		this.setArrObjConstantes(pArrObjConstantes);
	}
	
	@Override
	public String toString(){
		
		String strResultado = null;
		
		if(this.getEnmEtiNombre()!=null){
			
			strResultado = this.getEnmEtiNombre().toString();
		}
		
		return strResultado;
	}

	public String getStrCodigo() {
		return strCodigo;
	}

	public void setStrCodigo(String strCodigo) {
		this.strCodigo = strCodigo;
	}

	public EnumEtiquetas getEnmEtiNombre() {
		return enmEtiNombre;
	}

	public void setEnmEtiNombre(EnumEtiquetas enmEtiNombre) {
		this.enmEtiNombre = enmEtiNombre;
	}

	public Class<? extends IEntidadTrama> getClsEntTrmEnvio() {
		return clsEntTrmEnvio;
	}

	public void setClsEntTrmEnvio(Class<? extends IEntidadTrama> clsEntTrmEnvio) {
		this.clsEntTrmEnvio = clsEntTrmEnvio;
	}

	public Class<? extends IRespuestaTrama> getClsEntTrmRespuesta() {
		return clsEntTrmRespuesta;
	}

	public void setClsEntTrmRespuesta(
			Class<? extends IRespuestaTrama> clsEntTrmRespuesta) {
		this.clsEntTrmRespuesta = clsEntTrmRespuesta;
	}

	public Object[] getArrObjConstantes() {
		return arrObjConstantes;
	}

	public void setArrObjConstantes(Object[] arrObjConstantes) {
		this.arrObjConstantes = arrObjConstantes;
	}

	public ParametrosReimpresionDTO getObjParametrosReimpresion() throws Exception{
		
		if(this.objParametrosReimpresion == null){
			
			this.objParametrosReimpresion = this.getClsParametrosReimpresion().newInstance();
		}
		
		return this.objParametrosReimpresion;
	}

	public void setObjParametrosReimpresion(
			ParametrosReimpresionDTO objParametrosReimpresion) {
		this.objParametrosReimpresion = objParametrosReimpresion;
	}

	public Class<? extends ParametrosReimpresionDTO> getClsParametrosReimpresion() {
		
		if(this.clsParametrosReimpresion == null){
			
			this.clsParametrosReimpresion = ParametrosReimpresionDTO.class;
		}
		
		return this.clsParametrosReimpresion;
	}

	public void setClsParametrosReimpresion(
			Class<? extends ParametrosReimpresionDTO> clsParametrosReimpresion) {
		this.clsParametrosReimpresion = clsParametrosReimpresion;
	}

	public Modulo getObjOpcionMenu() {
		return objOpcionMenu;
	}

	public void setObjOpcionMenu(Modulo objOpcionMenu) {
		this.objOpcionMenu = objOpcionMenu;
	}

	public EnumImpresiones getEnmImpresion() {
		return enmImpresion;
	}

	public void setEnmImpresion(EnumImpresiones enmImpresion) {
		this.enmImpresion = enmImpresion;
	}

	/**
	 * @method	getEnmTipoImpresion
	 * 		  	Metodo get del atributo enmTipoImpresion
	 * @return	EnumTiposImpresion
	 *		  	Valor del atributo enmTipoImpresion devuelto
	 * @author	roberth.martinez
	 * @date  	1/11/2018
	 */
	public EnumTiposImpresion getEnmTipoImpresion() {
		return this.enmTipoImpresion;
	}

	/**
	 * @method	setEnmTipoImpresion
	 * 		  	Metodo set del atributo enmTipoImpresion
	 * @param	pEnmTipoImpresion
	 * 			Valor que tomara el atributo enmTipoImpresion
	 * @author	roberth.martinez
	 * @date	1/11/2018
	 */
	public void setEnmTipoImpresion(EnumTiposImpresion pEnmTipoImpresion) {
		this.enmTipoImpresion = pEnmTipoImpresion;
	}

}

package co.com.codesa.clienteposslimgiros.enumeraciones;

import co.com.codesa.clienteposslim.enumeraciones.EstadoAplicacionEnum;
import co.com.codesa.clienteposslim.formas.FormaLogin;
import co.com.codesa.clienteposslimexception.exceptions.ClientePosSlimGirosException;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.mensajes.Mensaje;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.codesawrapper.modelo.dominio.ParametroSistema;

/**
 * ****************************************************************.
 * @author Hector Q-en-K
 * @fecha 18-nov-2015
 * @clase EnumParametrosSistema
 * 		  Clase enumerador que permite recuperar los valores 
 * 		  constantes que hacen referencia a parametros del sistema
 * @copyright: Copyright  1998-2012 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public enum EnumParametrosSistema {
	
	//Biometria
	/**
	 * @variable	LONGITUG_MAXIMA_HUELLA
	 * 				Longitud maxima huella
	 */
	LONGITUG_MAXIMA_HUELLA("TAMAHUEL"),
	
	//Biometria Local
	/**
	 * @variable	ACTIVA_TRANSMISION_WSQ
	 * 				Activar servicio transmision archivos WSQ [S] = Si [N] = No 
	 * 				con valor S se activa y N lo inactiva
	 */
	ACTIVA_TRANSMISION_WSQ("ACSTRWSQ",EnumParametrosSistema.SIEMPRE_CONSULTA,EnumExpresionesRegulares.PAR_SIS_BANDERA_S_N),
	
	/**
	 * @variable	CANTIDAD_CARACTERES_ENVIO_HUELLA_WSQ
	 * 				Cantidad de caracteres a enviar de huella wsq por bloque en 
	 * 				trama
	 */
	CANTIDAD_CARACTERES_ENVIO_HUELLA_WSQ("CNCREWSQ",EnumParametrosSistema.SIEMPRE_CONSULTA,EnumExpresionesRegulares.PAR_SIS_NUMERICO_ENTERO),
	
	/**
	 * @variable	TIEMPO_VALIDAR_EXISTENCIA_ARCHIVOS_WSQ_PARA_TRANSMISION
	 * 				Tiempo en segundos para consultar la carpeta de archivos de 
	 * 				huellas wsq para transmitir
	 */
	TIEMPO_VALIDAR_EXISTENCIA_ARCHIVOS_WSQ_PARA_TRANSMISION("TMCTRWSQ",EnumParametrosSistema.SIEMPRE_CONSULTA,EnumExpresionesRegulares.PAR_SIS_NUMERICO_ENTERO),
	
	/**
	 * @variable	NOMBRE_DIRECTORIO_ALMACENAMIENTO_WSQ
	 * 				Nombre de la carpeta donde se almacenan temporalmente las WSQ 
	 * 				de la biometr�a local
	 */
	NOMBRE_DIRECTORIO_ALMACENAMIENTO_WSQ("DIREHUWS",EnumParametrosSistema.SIEMPRE_CONSULTA,EnumExpresionesRegulares.PAR_SIS_NOMBRE_ARCHIVO_DIRECTORIO),
	
	/**
	 * @variable	PESO_MAXIMO_ARCHIVO_WSQ_PERMITIDO_PARA_TRANSMISION_KB
	 * 				Tamano maximo de archivo huella wsq permitido para transmitir 
	 * 				representado en KB
	 */
	PESO_MAXIMO_ARCHIVO_WSQ_PERMITIDO_PARA_TRANSMISION_KB("TAMARWSQ",EnumParametrosSistema.SIEMPRE_CONSULTA,EnumExpresionesRegulares.PAR_SIS_NUMERICO_ENTERO),
	
	/**
	 * @variable	TIMEOUT_CONEXION_SOCKET_TRANSMISOR_WSQ
	 * 				TimeOut de conexion al socket de transmision de archivos wsq 
	 * 				estalbecida desde SIMS
	 */
	//TIMEOUT_CONEXION_SOCKET_TRANSMISOR_WSQ("TIMEOWSQ",EnumParametrosSistema.SIEMPRE_CONSULTA,EnumExpresionesRegulares.PAR_SIS_NUMERICO_ENTERO),
	
	/**
	 * @variable	PUERTO_SOCKET_TRANSMISOR_WSQ
	 * 				Puerto del socket donde se alojaran los WSQ que se transmitan 
	 * 				desde el cliente SIMS
	 */
	//PUERTO_SOCKET_TRANSMISOR_WSQ("PTOSOWSQ",EnumParametrosSistema.SIEMPRE_CONSULTA,EnumExpresionesRegulares.PAR_SIS_NUMERICO_ENTERO),
	
	/**
	 * @variable	TIEMPO_PAUSA_ENTRE_CADA_TRANSMISION_WSQ
	 * 				Tiempo de pausa representado en segundos para transmitir cada 
	 * 				archivo de huellas wsq
	 */
	TIEMPO_PAUSA_ENTRE_CADA_TRANSMISION_WSQ("TIESTRAR",EnumParametrosSistema.SIEMPRE_CONSULTA,EnumExpresionesRegulares.PAR_SIS_NUMERICO_ENTERO),
	
	/**
	 * @variable	MAXIMO_ALMACENAMIENTO_DIRECTORIO_WSQ
	 * 				Capacidad maxima almacenamiento en carpeta permitida para enrolar 
	 * 				localmente representado en MB [Mega Bytes] Con [-1] no aplica control
	 */
	MAXIMO_ALMACENAMIENTO_DIRECTORIO_WSQ("CAMAPEEN",EnumParametrosSistema.SIEMPRE_CONSULTA,EnumExpresionesRegulares.PAR_SIS_CAMAPEEN_CAMIALEL),
	
	/**
	 * @variable	MINIMO_ALMACENAMIENTO_DIRECTORIO_WSQ
	 * 				Capacidad minima almacenamiento en carpeta para lanzar alerta al momento 
	 * 				de enrolar local representado en MB [Mega bytes] Con [-1] no aplica control
	 */
	MINIMO_ALMACENAMIENTO_DIRECTORIO_WSQ_LANZAR_ALERTA("CAMIALEL",EnumParametrosSistema.SIEMPRE_CONSULTA,EnumExpresionesRegulares.PAR_SIS_CAMAPEEN_CAMIALEL),
	
	/**
	 * @variable	DETIENE_ENROLAMIENTO_LOCAL_AL_SUPERAR_PARAMETRO_CAMAPEEN
	 * 				Detiene el proceso de enrolamiento local si cumple con el parametro de sistema 
	 * 				CAMAPEEN S = Si y N = No
	 */
	DETIENE_ENROLAMIENTO_LOCAL_AL_SUPERAR_PARAMETRO_CAMAPEEN("DEPRENLO",EnumParametrosSistema.SIEMPRE_CONSULTA, EnumExpresionesRegulares.PAR_SIS_BANDERA_S_N),
	
	/**
	 * @variable	DETIENE_ENROLAMIENTO_LOCAL_AL_SUPERAR_PARAMETRO_CAMAPEEN
	 * 				Produce alerta si cumple con el parametro de sistema CAMIALEL S = Si y N = No
	 */
	ACTIVA_ALERTA_AL_SUPERAR_PARAMETRO_CAMIALEL("ENALENLO",EnumParametrosSistema.SIEMPRE_CONSULTA, EnumExpresionesRegulares.PAR_SIS_BANDERA_S_N),
	
	/**
	 * @variable	CONEXION_PARAMEMPWS_SOCKET_EMPRESA_EJB
	 * 				Conexion socket empresa-EJB giros: Especifica el proveedor|servicio|destino, utilizado sobre la estructura PARAMEMPWS, para obtener una conexion Ip:puerto
	 */
	CONEXION_PARAMEMPWS_SOCKET_EMPRESA_EJB("CXSEMPEJ",EnumExpresionesRegulares.PAR_SIS_CONEXION_PARAMEMPWS,EnumSistemas.GAMBLE),
	
	/**
	 * @variable	CONEXION_PARAMEMPWS_EJB_SOCKET_SIMS_NEGOCIO
	 * 				Conexion EJB giros-socket SIMS: Especifica el proveedor|servicio|destino, utilizado sobre la estructura PARAMEMPWS, para obtener una conexion Ip:puerto
	 */
	CONEXION_PARAMEMPWS_EJB_SOCKET_SIMS_NEGOCIO("CXEJSNEG",EnumExpresionesRegulares.PAR_SIS_CONEXION_PARAMEMPWS,EnumSistemas.GAMBLE),
	
	/**
	 * @variable	CONEXION_PARAMEMPWS_EJB_SOCKET_SIMS_NEGOCIO
	 * 				Conexion EJB giros-socket Transmisor WSQ: Especifica el proveedor|servicio|destino, utilizado sobre la estructura PARAMEMPWS, para obtener una conexion Ip:puerto
	 */
	CONEXION_PARAMEMPWS_EJB_SOCKET_SIMS_WSQ("CXEJSWSQ",EnumExpresionesRegulares.PAR_SIS_CONEXION_PARAMEMPWS,EnumSistemas.GAMBLE),	
	
	/**
	 * @variable	ACTIVA_FIRMA_BIOMETRICA_BIOMETRIA_LOCAL
	 * 				Activar firma biometrica para biometria local [A] = Activo [I] = Inactivo 
	 */
	ACTIVA_FIRMA_BIOMETRICA_BIOMETRIA_LOCAL("ACFIBILO",EnumParametrosSistema.SIEMPRE_CONSULTA,EnumExpresionesRegulares.PAR_SIS_BANDERA_A_I),
	
	/**
	 * @variable	ACTIVA_FIRMA_BIOMETRICA_GENERAL
	 * 				Activar firma biometrica general [S] = Si [N] = No 
	 */
	ACTIVA_FIRMA_BIOMETRICA_GENERAL("FIRMBIGE",EnumParametrosSistema.SIEMPRE_CONSULTA,EnumExpresionesRegulares.PAR_SIS_BANDERA_S_N),
	
	/**
	 * @variable	ACTIVA_FIRMA_BIOMETRICA_BIOMETRIA_LOCAL_ENVIO
	 * 				Activar firma biometrica para biometria local en proceso 
	 * 				envio [S] = Activo [N] = Inactivo 
	 */
	ACTIVA_FIRMA_BIOMETRICA_BIOMETRIA_LOCAL_ENVIO("FIRMBIEN",EnumParametrosSistema.SIEMPRE_CONSULTA,EnumExpresionesRegulares.PAR_SIS_BANDERA_S_N),
	
	/**
	 * @variable	ACTIVA_FIRMA_BIOMETRICA_BIOMETRIA_LOCAL_ANULACION
	 * 				Activar firma biometrica para biometria local en proceso 
	 * 				anulacion [S] = Activo [N] = Inactivo 
	 */
	ACTIVA_FIRMA_BIOMETRICA_BIOMETRIA_LOCAL_ANULACION("FIRMBIAN",EnumParametrosSistema.SIEMPRE_CONSULTA,EnumExpresionesRegulares.PAR_SIS_BANDERA_S_N),
	
	/**
	 * @variable	ACTIVA_FIRMA_BIOMETRICA_BIOMETRIA_LOCAL_PAGO
	 * 				Activar firma biometrica para biometria local en proceso 
	 * 				pago [S] = Activo [N] = Inactivo 
	 */
	ACTIVA_FIRMA_BIOMETRICA_BIOMETRIA_LOCAL_PAGO("FIRMBIPA",EnumParametrosSistema.SIEMPRE_CONSULTA,EnumExpresionesRegulares.PAR_SIS_BANDERA_S_N),
	
	/**
	 * @variable	ACTIVA_FIRMA_BIOMETRICA_BIOMETRIA_LOCAL_CAMBIO_BENEFICIARIO
	 * 				Activar firma biometrica para biometria local en proceso 
	 * 				cambio de beneficiario [S] = Activo [N] = Inactivo 
	 */
	ACTIVA_FIRMA_BIOMETRICA_BIOMETRIA_LOCAL_CAMBIO_BENEFICIARIO("FIRMBICB",EnumParametrosSistema.SIEMPRE_CONSULTA,EnumExpresionesRegulares.PAR_SIS_BANDERA_S_N),
	
	/**
	 * @variable	CONEXION_SOCKET_SIMS_RECEPTOR
	 * 				ip del socket de receptor de giros internacionales
	 */
	//CONEXION_SOCKET_SIMS_RECEPTOR("SOSIRECE",EnumExpresionesRegulares.GNR_IP,EnumSistemas.GAMBLE),
	
	//Biometria Multiservicio
	/**
	 * @variable	SERVICIO_VALIDAR_TERCERO_BMS
	 * 				Codigo que especifica le servicio para validar tercero hacia el sistema
	 * 				biometria multiservicio
	 */
	SERVICIO_VALIDAR_TERCERO_BMS("VATEBIMU"),
	
	/**
	 * @variable	SERVICIO_ENROLAR_HUELLA_BMS
	 * 				Codigo que especifica le servicio para enrolar huella hacia el sistema
	 * 				biometria multiservicio
	 */
	SERVICIO_ENROLAR_HUELLA_BMS("ENROBIMU"),
	
	/**
	 * @variable	SERVICIO_SOLICITAR_HUELLA_BMS
	 * 				Codigo que especifica le servicio para solicitar huella hacia el sistema
	 * 				biometria multiservicio
	 */
	SERVICIO_SOLICITAR_HUELLA_BMS("SOHUBIMU"),
	
	/**
	 * @variable	SERVICIO_TRANSMITIR_ARCHIVO_BMS
	 * 				Codigo que especifica le servicio para transmitir un archivo hacia el sistema
	 * 				biometria multiservicio
	 */
	SERVICIO_TRANSMITIR_ARCHIVO_BMS("TRARBIMU"),
	
	/**
	 * @variable	SERVICIO_AUTORIZAR_TERCERO_BMS
	 * 				Codigo que especifica le servicio de autorizacion de tercero hacia el sistema
	 * 				biometria multiservicio
	 */
	SERVICIO_AUTORIZAR_TERCERO_BMS("AEICBIMU"),
	
	//Pago externo
	/**
	 * @variable	DATO_D_RED_EXTERNA_ENCABEZADO_TRAMA
	 * 				Dato D que va para red Externa
	 */
	DATO_D_RED_EXTERNA_ENCABEZADO_TRAMA("DATODREX",EnumParametrosSistema.SIEMPRE_CONSULTA),
	
	/**
	 * @variable	CODIGO_ACTIVIDAD_ECONOMICA_DEFAULT
	 * 				Codigo de la actividad economica a grabar por defecto al remitente nuevo de la red externa
	 */
	CODIGO_ACTIVIDAD_ECONOMICA_DEFAULT("CDACTECO",EnumParametrosSistema.SIEMPRE_CONSULTA),
	
	/**
	 * @variable	CODIGOS_MENSAJES_RECONFIRMACION_PAGO_EXTERNO
	 * 				Codigos de mensajes en los cuales un pago de giro externo debe 
	 * 				considerar el proceso de re-confirmacion, formato: |CODIGO_MSG1
	 * 				|CODIGO_MSG2|CODIGO_MSGn|, para no aplicar validacion: N/A
	 */
	CODIGOS_MENSAJES_RECONFIRMACION_PAGO_EXTERNO("MSRECONF",EnumParametrosSistema.SIEMPRE_CONSULTA),
	
	//Tercero
	/**
	 * @variable	CANT_DIAS_HABILES_TERCERO_INFO_INCONSISTENTE
	 * 				Cantidad de dias permitidos por SuperGIROS para permitir a un 
	 * 				tercero tranzar en el sistema con datos inconsistentes
	 */
	CANT_DIAS_HABILES_TERCERO_INFO_INCONSISTENTE("DIHAFETD"),//Cantidad de dias permitidos por SuperGIROS para permitir a un tercero tranzar en el sistema con datos inconsistentes
	
	
	/**
	 * @variable	EDAD_MINIMA_PARA_RECLAMAR_GIRO
	 * 				Edad Minima (a�os) Para reclamar Giro
	 */
	EDAD_MINIMA_PARA_RECLAMAR_GIRO("EDADMINI"),
	
	/**
	 * @variable	VALIDA_TERCERO_RECAUDO_BLOQUEADO_X_RIESGO
	 * 				Permite activar o inactivar la validacion de terceros bloqueados. 
	 * 				S = activo, N = inactivo
	 */
	VALIDA_TERCERO_RECAUDO_BLOQUEADO_X_RIESGO("VATERBLO",EnumParametrosSistema.SIEMPRE_CONSULTA),
	
	/**
	 * @variable	VALIDA_TERCERO_RECAUDO_REQUIERE_BIOMETRIA
	 * 				Permite validar recaudo con biometria, (S) = Si, (N) = No
	 */
	VALIDA_TERCERO_RECAUDO_REQUIERE_BIOMETRIA("VATERBIO",EnumParametrosSistema.SIEMPRE_CONSULTA),
	
	/**
	 * @variable	ID_TIPO_TERCERO_CONVENIO
	 * 				TIPOCONV-id datos entidades para terceros convenios
	 */
	ID_TIPO_TERCERO_CONVENIO("IDTITECO"),
	
	//Formatos de impresion
	/**
	 * @variable	NOMBRE_FORMATO_IMPRESION_CAMBIO_BENEFICIARIO
	 * 				Identificacion o nombre de la impresion de cambio de beneficiario, 
	 * 				sobre la entidad IMPRSION
	 */
	//NOMBRE_FORMATO_IMPRESION_CAMBIO_BENEFICIARIO("IMPRCBMC",EnumEtiquetas.DESC_PS_NOMBRE_FORMATO_IMPRESION_CAMBIO_BENEFICIARIO),
	
	/**
	 * @variable	NOMBRE_FORMATO_IMPRESION_CAMBIO_BENEFICIARIO_CRC
	 * 				Identificacion o nombre de la impresion de cambio de beneficiario, 
	 * 				sobre la entidad IMPRSION para requerimiento CRC
	 */
	//NOMBRE_FORMATO_IMPRESION_CAMBIO_BENEFICIARIO_CRC("CRCIMCBF",EnumEtiquetas.DESC_PS_NOMBRE_FORMATO_IMPRESION_CAMBIO_BENEFICIARIO),
	NOMBRE_FORMATO_IMPRESION_CAMBIO_BENEFICIARIO_CRC("CRCIMCBE",EnumEtiquetas.DESC_PS_NOMBRE_FORMATO_IMPRESION_CAMBIO_BENEFICIARIO),
	/**
	 * @variable	NOMBRE_FORMATO_IMPRESION_ANULACION_GIRO
	 * 				Identificacion o nombre de la impresion de anulacion de giro, sobre 
	 * 				la entidad IMPRSION
	 */
	NOMBRE_FORMATO_IMPRESION_ANULACION_GIRO("IMPRANGI",EnumEtiquetas.DESC_PS_NOMBRE_FORMATO_IMPRESION_ANULACION_GIRO),
	
	/**
	 * @variable	NOMBRE_FORMATO_IMPRESION_ANULACION_GIRO_AUTORIZADA
	 * 				Identificacion o nombre de la impresion de anulacion de giro autorizada, 
	 * 				sobre la entidad IMPRSION
	 */
	NOMBRE_FORMATO_IMPRESION_ANULACION_GIRO_AUTORIZADA("IMPRAGAU",EnumEtiquetas.DESC_PS_NOMBRE_FORMATO_IMPRESION_ANULACION_GIRO_AUTORIZADA),
	
	/**
	 * @variable	NOMBRE_FORMATO_IMPRESION_ENVIO_GIRO_POSTAL
	 * 				Identificacion o nombre de la impresion de envio giro postal, sobre la 
	 * 				entidad IMPRSION
	 */
	//NOMBRE_FORMATO_IMPRESION_ENVIO_GIRO_POSTAL("IMPREVGP",EnumEtiquetas.DESC_PS_NOMBRE_FORMATO_IMPRESION_ENVIO_GIRO_POSTAL),
	
	/**
	 * @variable	NOMBRE_FORMATO_IMPRESION_PAGO_GIRO_POSTAL_CRC
	 * 				Identificacion o nombre de la impresion de envio giro postal, sobre la 
	 * 				entidad IMPRSION para requerimiento CRC
	 */
	NOMBRE_FORMATO_IMPRESION_ENVIO_GIRO_POSTAL_CRC("CRCIMEGP",EnumEtiquetas.DESC_PS_NOMBRE_FORMATO_IMPRESION_ENVIO_GIRO_POSTAL),
	
	/**
	 * @variable	NOMBRE_FORMATO_IMPRESION_PAGO_GIRO_POSTAL
	 * 				Identificacion o nombre de la impresion de pago giro postal, sobre la 
	 * 				entidad IMPRSION
	 */
	//NOMBRE_FORMATO_IMPRESION_PAGO_GIRO_POSTAL("IMPRPGGP",EnumEtiquetas.DESC_PS_NOMBRE_FORMATO_IMPRESION_PAGO_GIRO_POSTAL),
	
	/**
	 * @variable	NOMBRE_FORMATO_IMPRESION_PAGO_GIRO_POSTAL_CRC
	 * 				Identificacion o nombre de la impresion de pago giro postal, sobre la 
	 * 				entidad IMPRSION para requerimiento CRC
	 */
	NOMBRE_FORMATO_IMPRESION_PAGO_GIRO_POSTAL_CRC("CRCIMPGP",EnumEtiquetas.DESC_PS_NOMBRE_FORMATO_IMPRESION_PAGO_GIRO_POSTAL),
	
	/**
	 * @variable	NOMBRE_FORMATO_PRE_IMPRESION_PAGO_GIRO_DOMICILIADO
	 * 				Identificacion o nombre de la pre-impresion de pago giro domiciliado, sobre la 
	 * 				entidad IMPRSION
	 */
	NOMBRE_FORMATO_PRE_IMPRESION_PAGO_GIRO_DOMICILIADO("IMPRFPDO",EnumEtiquetas.DESC_PS_NOMBRE_FORMATO_PRE_IMPRESION_PAGO_GIRO_DOMICILIADO),
	
	/**
	 * @variable	NOMBRE_FORMATO_IMPRESION_ANULACION_RECAUDO
	 * 				Identificacion o nombre de la impresion de anulacion de recaudo, sobre 
	 * 				la entidad IMPRSION
	 */
	NOMBRE_FORMATO_IMPRESION_ANULACION_RECAUDO("IMPRANRC",EnumEtiquetas.DESC_PS_NOMBRE_FORMATO_IMPRESION_ANULACION_RECAUDO),
	
	/**
	 * @variable	NOMBRE_FORMATO_IMPRESION_ENVIO_RECAUDO
	 * 				Identificacion o nombre de la impresion de envio de recaudo, sobre la 
	 * 				entidad IMPRSION
	 */
	NOMBRE_FORMATO_IMPRESION_ENVIO_RECAUDO("IMPREVRC",EnumEtiquetas.DESC_PS_NOMBRE_FORMATO_IMPRESION_ENVIO_RECAUDO),
	
	/**
	 * @variable	NOMBRE_FORMATO_IMPRESION_PAGO_RECAUDO
	 * 				Identificacion o nombre de la impresion de pago de convenio recaudo, 
	 * 				sobre la entidad IMPRSION
	 */
	NOMBRE_FORMATO_IMPRESION_PAGO_RECAUDO("IMPRPGRC",EnumEtiquetas.DESC_PS_NOMBRE_FORMATO_IMPRESION_PAGO_RECAUDO),
	
	/**
	 * @variable	NOMBRE_FORMATO_IMPRESION_CIERRE_CAJA
	 * 				Identificacion o nombre de la impresion de cierre de caja, sobre la 
	 * 				entidad IMPRSION
	 */
	NOMBRE_FORMATO_IMPRESION_CIERRE_CAJA("IMPRCRCJ",EnumEtiquetas.DESC_PS_NOMBRE_FORMATO_IMPRESION_CIERRE_CAJA),
	
	/**
	 * @variable	NOMBRE_FORMATO_IMPRESION_INGRESO_EGRESO
	 * 				Identificacion o nombre de la impresion de ingreso y egreso, sobre la 
	 * 				entidad IMPRSION
	 */
	NOMBRE_FORMATO_IMPRESION_INGRESO_EGRESO("IMPRINEG",EnumEtiquetas.DESC_PS_NOMBRE_FORMATO_IMPRESION_INGRESO_EGRESO),
	
	/**
	 * @variable	NOMBRE_FORMATO_IMPRESION_ROE
	 * 				Identificacion o nombre de la impresion de ROE, sobre la entidad IMPRSION
	 */
	NOMBRE_FORMATO_IMPRESION_ROE("IMPRROE",EnumEtiquetas.DESC_PS_NOMBRE_FORMATO_IMPRESION_ROE),
	
	/**
	 * @variable	NOMBRE_FORMATO_IMPRESION_SEGURO
	 * 				Identificacion o nombre de la impresion del seguro, sobre la entidad IMPRSION
	 */
	NOMBRE_FORMATO_IMPRESION_SEGURO("IMPRSEGU",EnumEtiquetas.DESC_PS_NOMBRE_FORMATO_IMPRESION_SEGURO),
	
	/**
	 * @variable	NOMBRE_FORMATO_IMPRESION_SMS
	 * 				Identificacion o nombre de la impresion del SMS, sobre la entidad IMPRSION
	 */
	NOMBRE_FORMATO_IMPRESION_SMS("IMPRSMS",EnumEtiquetas.DESC_PS_NOMBRE_FORMATO_IMPRESION_SMS),
	
	/**
	 * @variable	NOMBRE_FORMATO_IMPRESION_PAGO_GIRO_INTERNACIONAL
	 * 				Identificacion o nombre de la impresion del pago de giro internacional, sobre la entidad IMPRSION
	 */
	NOMBRE_FORMATO_IMPRESION_PAGO_GIRO_INTERNACIONAL("IMPRPGRI",EnumEtiquetas.DESC_PS_NOMBRE_FORMATO_IMPRESION_PAGO_GIRO_INTERNACIONAL),
	
	/**
	 * @variable	NOMBRE_FORMATO_IMPRESION_ENVIO_GIRO_INTERNACIONAL
	 * 				Identificacion o nombre de la impresion del envio de giro internacional, sobre la entidad IMPRSION
	 */
	NOMBRE_FORMATO_IMPRESION_ENVIO_GIRO_INTERNACIONAL("IMPRENRI",EnumEtiquetas.DESC_PS_NOMBRE_FORMATO_IMPRESION_ENVIO_GIRO_INTERNACIONAL),
	
	NOMBRE_FORMATO_IMPRESION_SEGURO_INTERNACIONAL("IMPRPTRI",EnumEtiquetas.DESC_PS_NOMBRE_FORMATO_IMPRESION_SEGURO_INTERNACIONAL),
	
	NOMBRE_FORMATO_IMPRESION_SMS_INTERNACIONAL("IMPRSMSR",EnumEtiquetas.DESC_PS_NOMBRE_FORMATO_IMPRESION_SMS_INTERNACIONAL),
	
	NOMBRE_FORMATO_IMPRESION_PQR("IMPRFPQR",EnumEtiquetas.DESC_PS_NOMBRE_FORMATO_IMPRESION_PQR),
	
	/**
	 * @variable	CONTROL_DOBLE_IMPRESION_TIRILLA_APODERADO
	 * 				Control de doble impresion permite activar o desactivar la doble impresion de tirillas para el pago de un giro con tercero apoderado
	 */
	CONTROL_DOBLE_IMPRESION_TIRILLA_APODERADO("DBREIMPR",EnumParametrosSistema.SIEMPRE_CONSULTA,EnumExpresionesRegulares.CONTROL_DOBLE_IMPRESION_TIRILLA_APODERADO),
	
	/**
	 * @variable	TERCERO_CONVENIO_DOBLE_IMPRESION_TIRILLA
	 * 				Parametro encargado de almacenar los terceros convenios a solicitar doble impresion de tirilla
	 */
	TERCERO_CONVENIO_DOBLE_IMPRESION_TIRILLA("NUMDOCCV",EnumParametrosSistema.SIEMPRE_CONSULTA,EnumExpresionesRegulares.EXP_VERIFICACION_TERCERO_DOBLE_IMPRESION),
	
	/**
	 * @variable	PAGINA_PRUEBA
	 * 				Parametro para identificar una impresion de pagina de prueba
	 */
	PAGINA_PRUEBA("NOEXISTE",EnumEtiquetas.DESC_PS_PAGINA_PRUEBA),
	
	//SuperCombo
	/**
	 * @variable	ID_CONCEPTO_SEGURO_HURTO
	 * 				CONCEMIC-ID concepto microseguro x hurto
	 */
	ID_CONCEPTO_SEGURO_HURTO("CONCSCSM"),
	
	/**
	 * @variable	ID_CONCEPTO_SEGURO_NO_COMBO
	 * 				Id concepto microseguros no Combo
	 */
	ID_CONCEPTO_SEGURO_NO_COMBO("CONCSGNC"),
	
	/**
	 * @variable	SUPERCOMBO_ACTIVO
	 * 				SUPCOMBO-Validacion general para activar o desactivar supercombo 
	 * 				a todos
	 */
	SUPERCOMBO_ACTIVO("SEGUROSM",EnumParametrosSistema.SIEMPRE_CONSULTA),
	
	/**
	 * @variable	SUPERCOMBO_ACTIVO_PAGO
	 * 				SUPCOMBO-Validacion general para activar o desactivar supercombo 
	 * 				para pago de giro nacional. "SI" para activar, "NO" para inactivar
	 */
	SUPERCOMBO_ACTIVO_PAGO("PRGIROPA",EnumParametrosSistema.SIEMPRE_CONSULTA, EnumExpresionesRegulares.PAR_SIS_BANDERA_SI_NO),
	
	/**
	 * @variable	CODIGO_DOCUMENTO_SEGURO
	 * 				CODMICRO-strCodigo del documento para seguros
	 */
	CODIGO_DOCUMENTO_SEGURO("CODSESMS"),
	
	/**
	 * @variable	ID_DOCUMENTO_SEGURO
	 * 				IDDOCSEG-id documento de seguros
	 */
	ID_DOCUMENTO_SEGURO("IDDOCSSC"),
	
	/**
	 * @variable	VALOR_MAXIMO_SEGURO_ACCIDENTES
	 * 				valor maximo pagado por seguro de accidentes
	 */
	VALOR_MAXIMO_SEGURO_ACCIDENTES("VLRMXSGA"),
	
	/**
	 * @variable	TELEFONOS_ATENCION_COMPANIA_ASEGURADORA
	 * 				Telefonos de atencion compania aseguradora - el valor representa una 
	 * 				trama de 6 telefonos separados por Punto y Coma - en ese mismo orden 
	 * 				se mostraran en pantalla
	 */
	TELEFONOS_ATENCION_COMPANIA_ASEGURADORA("TELESEGU"),
	
	/**
	 * @variable	INFORMACION_SEGURO
	 * 				Informacion del seguro, numero de poliza matriz, nombre y nit aseguradora, 
	 * 				nombre y nit tomador
	 */
	INFORMACION_SEGURO("INFOSEGU"),
	
	/**
	 * @variable	COD_GRUPO_PLAN_TARIFARIO_SEGURO
	 * 				Codigo de grupo del plan tarifario seguro
	 */
	COD_GRUPO_PLAN_TARIFARIO_SEGURO("COGRPTSE"),
	
	/**
	 * @variable	COD_GRUPO_PLAN_TARIFARIO_SEGURO_PAGO
	 * 				Codigo de grupo del plan tarifario seguro
	 * 				para pago de giro nacional
	 */
	COD_GRUPO_PLAN_TARIFARIO_SEGURO_PAGO("COGRPTSP",EnumParametrosSistema.SIEMPRE_CONSULTA, EnumExpresionesRegulares.PAR_SIS_NUMERICO_ENTERO),	
	
	/**
	 * @variable	COD_PRODUCTO_SEGURO_SMS
	 * 				Codigo del Producto para seguros SMS
	 */
	COD_PRODUCTO_SEGURO_SMS("COPROSEG"),
	
	/**
	 * @variable	TOPE_VLR_TOPE_ASEGURADO_SEGURO_FPISA
	 * 				Tope maximo valor asegurado protegiro remesas internacionales
	 */
	TOPE_VLR_TOPE_ASEGURADO_SEGURO_FPISA("TOMAPGRI",EnumParametrosSistema.SIEMPRE_CONSULTA, EnumExpresionesRegulares.PAR_SIS_NUMERICO_ENTERO),
	
	/**
	 * @variable	VALIDA_SERVICIO_PROTEGIRO_INTERNACIONAL
	 * 				Permite Activar o Inactivar el servicio de protegiro internacional
	 * 				a nivel general valores S = Activo N = Inactivo
	 * 				Produce alerta si cumple con el parametro de sistema CAMIALEL S = Si y N = No
	 */
	VALIDA_SERVICIO_PROTEGIRO_INTERNACIONAL("ACSEPGRI", EnumParametrosSistema.SIEMPRE_CONSULTA, EnumExpresionesRegulares.PAR_SIS_BANDERA_S_N),
	
	 
	/**
	 * @variable	COD_PLAN_TERIFARIO_SEGURO_INTERNACIONAL
	 * 				Codigo del plan tarifario correpondiente al seguro internacional parametrizado en forma [GRCC]
	 */
	COD_PLAN_TERIFARIO_SEGURO_INTERNACIONAL("COPTSEIN", EnumExpresionesRegulares.PAR_SIS_NUMERICO_ENTERO),
	
	
	//Codigo del plan tarifario correpondiente al seguro internacional parametrizado en forma [GRCC]
	
	
	//SUPERCOMBO_VENTANA_LOGIN("SUPCLOGI"),//validacion para mostrar la ventana de recordatorio de supercombo despues de iniciar sesion
	//RANGO_VALORES_APLICA_SUPERCOMBO("RANGOSC"),//rango de valores en que aplica supercombo
	//CODIGO_DOCUMENTO_SMS("CODSMS"),//strCodigo del documento sms
	//ID_DOCUMENTO_SMS("IDDOCSMS"),//id del documento sms
	//ID_CONCEPTO_SMS_COMBO("CONSMSTO"),//id del concepto sms combo
	//PORCENTAJE_IVA_SMS("IVASMS"),//porcentaje de iva que se le calculara a la venta de sms
	//ID_CONCEPTO_SEGURO("id_concepto_seguro",true),//id concepto de seguro
	//VALOR_SEGURO_SMS("VALSMSSG"),//valor del seguro y sms
	//MAXIMO_CARACTERES_EN_SMS("MAX_CHAR"),//maximo de caracteres a enviar en sms
	//MENSAJE_DESTINATARIO("MSJDESTI"),//SMS DESTINATARIO
	//MENSAJE_REMITENTE("MSJREMIT"),//MENSAJE PARA EL REMITENTE
	//INFORMACION_SMS("INFOSMS"),// Informacion del SMS, nombre; nit ; direccion; telefono del proveedor del servicio de envio de SMS
	
	//Medios de pago
	/**
	 * @variable	CODIGO_MEDIO_PAGO_TARJETA_DEBITO
	 * 				Codigo del Medio de Pago TARJETA DEBITO
	 */
	CODIGO_MEDIO_PAGO_TARJETA_DEBITO("COMPTADE"),
	
	/**
	 * @variable	CODIGO_MEDIO_PAGO_TARJETA_CREDITO
	 * 				Codigo del Medio de Pago TARJETA CREDITO
	 */
	CODIGO_MEDIO_PAGO_TARJETA_CREDITO("COMPTACR"),
	
	//Conceptos
	/**
	 * @variable	CODIGO_CONCEPTO_RECAUDO_X_EFECTIVO
	 * 				Codigo del concepto recaudo convenio
	 */
	CODIGO_CONCEPTO_RECAUDO_X_EFECTIVO("COCORECO",EnumEtiquetas.DESC_PS_CODIGO_CONCEPTO_RECAUDO_X_EFECTIVO),
	
	/**
	 * @variable	CODIGO_CONCEPTO_RECAUDO_X_TARJETAS
	 * 				Codigo concepto recaudo convenio por tarjetas
	 */
	CODIGO_CONCEPTO_RECAUDO_X_TARJETAS("COCORCTR",EnumEtiquetas.DESC_PS_CODIGO_CONCEPTO_RECAUDO_X_TARJETAS),
	
	/**
	 * @variable	CODIGO_CONCEPTO_PAGO_RECAUDO
	 * 				Codigo del concepto de pago recaudo convenio
	 */
	CODIGO_CONCEPTO_PAGO_RECAUDO("COPARECO",EnumEtiquetas.DESC_PS_CODIGO_CONCEPTO_PAGO_RECAUDO),
	
	/**
	 * @variable	CODIGO_CONCEPTO_ANULACION_RECAUDO
	 * 				Codigo del concepto anulacion de convenio recaudo
	 */
	CODIGO_CONCEPTO_ANULACION_RECAUDO("COANCORE",EnumEtiquetas.DESC_PS_CODIGO_CONCEPTO_ANULACION_RECAUDO),
	
	/**
	 * @variable	ID_CONCEPTO_PAGO_GIRO
	 * 				Id del concepto de pago de giro
	 */
	ID_CONCEPTO_PAGO_GIRO("CONCPAGO",EnumEtiquetas.DESC_PS_ID_CONCEPTO_PAGO_GIRO),
	
	/**
	 * @variable	ID_CONCEPTO_ENVIO_GIRO_INTERNACIONAL
	 * 				Id del concepto de envio de giro internacional
	 */
	ID_CONCEPTO_ENVIO_GIRO_INTERNACIONAL("CONCEGIN",EnumEtiquetas.DESC_PS_ID_CONCEPTO_ENVIO_GIRO_INTERNACIONAL),
	
	/**
	 * @variable	CODIGO_CONCEPTO_PAGO_GIRO_INTERNACIONAL
	 * 				Codigo del concepto de pago de giro internacional
	 */
	CODIGO_CONCEPTO_PAGO_GIRO_INTERNACIONAL("CDCNPGIN",EnumEtiquetas.DESC_PS_CODIGO_CONCEPTO_PAGO_GIRO_INTERNACIONAL),
	
	/**
	 * @variable	ID_CONCEPTO_PROTEGIRO_INTERNACIONAL
	 * 				Id del concepto de protegiro internacional
	 */
	CODIGO_CONCEPTO_PROTEGIRO_INTERNACIONAL("COCOPGRI",EnumEtiquetas.DESC_PS_ID_CONCEPTO_PROTEGIRO_INTERNACIONAL),
	
	/**
	 * @variable	CODIGO_CONCEPTO_ANULACION_PROTEGIRO_INTERNACIONAL
	 * 				codigo del concepto de anulacion protegiro internacional
	 */
	CODIGO_CONCEPTO_ANULACION_PROTEGIRO_INTERNACIONAL("CDCNASGI",EnumEtiquetas.DESC_PS_CODIGO_CONCEPTO_ANULACION_PROTEGIRO_INTERNACIONAL),
	
	/**
	 * @variable	ID_CONCEPTO_ANULACION_GIRO
	 * 				ID del concepto para la anulacion de giros
	 */
	ID_CONCEPTO_ANULACION_GIRO("CONCANUL",EnumEtiquetas.DESC_PS_ID_CONCEPTO_ANULACION_GIRO),
	
	/**
	 * @variable	CODIGO_CONCEPTO_ANULACION_SEGURO
	 * 				Codigo del concepto anulacion seguro
	 */
	CODIGO_CONCEPTO_ANULACION_SEGURO("COCOANSE",EnumEtiquetas.DESC_PS_CODIGO_CONCEPTO_ANULACION_SEGURO),
	
	/**
	 * @variable	CODIGO_CONCEPTO_UTILIDAD_X_SEGURO
	 * 				Codigo del concepto que representa la utilidad del colaborador por la venta 
	 * 				de un seguro
	 */
	CODIGO_CONCEPTO_UTILIDAD_X_SEGURO("COCOUCSG",EnumEtiquetas.DESC_PS_CODIGO_CONCEPTO_UTILIDAD_X_SEGURO),
	
	/**
	 * @variable	CODIGO_CONCEPTO_UTILIDAD_X_PAGO_GIRO
	 * 				Codigo del concepto que representa la utilidad del colaborador por realizar 
	 * 				un pago de giro
	 */
	CODIGO_CONCEPTO_UTILIDAD_X_PAGO_GIRO("COCOUCPG",EnumEtiquetas.DESC_PS_CODIGO_CONCEPTO_UTILIDAD_X_PAGO_GIRO),
	
	/**
	 * @variable	CODIGO_CONCEPTO_UTILIDAD_X_ENVIO_GIRO
	 * 				Codigo del concepto que representa la utilidad del colaborador por realizar 
	 * 				un envio de giro
	 */
	CODIGO_CONCEPTO_UTILIDAD_X_ENVIO_GIRO("COCOUCEG",EnumEtiquetas.DESC_PS_CODIGO_CONCEPTO_UTILIDAD_X_ENVIO_GIRO),
	
	/**
	 * @variable	CODIGO_CONCEPTO_UTILIDAD_X_RECAUDO
	 * 				Codigo del concepto costo convenio recaudo colaborador
	 */
	CODIGO_CONCEPTO_UTILIDAD_X_RECAUDO("COCOCORE",EnumEtiquetas.DESC_PS_CODIGO_CONCEPTO_UTILIDAD_X_RECAUDO),
	
	//Documentos
	//ID_DOCUMENTO_CAPTACION_GIROS("DOCCAPTA"),//ID del Documento para la captacion de giros
	
	//Integracion Tesoreria BNet
	/**
	 * @variable	INFORMACION_VALE_EXTRA_COMPLETAR_SALDO_SIMS
	 * 				Informacion referente al vale extra que enviara BNet para completar el saldo de 
	 * 				SIMS y permitir el cierre de caja. El valor del parametro se compone del numero 
	 * 				y el concepto de vale, separado por PIPE ('|'). Ej: 12345|VALE EXTRA BNET
	 */
	INFORMACION_VALE_EXTRA_COMPLETAR_SALDO_SIMS("INVABNSS"),
	
	//Servicio clave de seguridad
	/**
	 * @variable	ACTIVA_CLAVE_SEGURIDAD
	 * 				Permite token de seguridad a nivel general, S = Si, N = No
	 */
	ACTIVA_CLAVE_SEGURIDAD("PETOSEGE",EnumParametrosSistema.SIEMPRE_CONSULTA),
	
	/**
	 * @variable	LONGITUD_MINIMA_CLAVE_SEGURIDAD_MANUAL
	 * 				Rango inicial generacion de clave de seguridad para pin
	 */
	LONGITUD_MINIMA_CLAVE_SEGURIDAD_MANUAL("RAINCLSE", EnumParametrosSistema.SIEMPRE_CONSULTA),
	
	/**
	 * @variable	LONGITUD_MAXIMA_CLAVE_SEGURIDAD_MANUAL
	 * 				Rango final generacion de clave de seguridad para pin
	 */
	LONGITUD_MAXIMA_CLAVE_SEGURIDAD_MANUAL("RAFICLSE", EnumParametrosSistema.SIEMPRE_CONSULTA),
	
	/**
	 * @variable	PERMITE_CONFIRMACION_CELULAR
	 * 				Permite la confirmacion de celulares para el proceso de clave de seguridad automatica, 
	 * 				aplica por cada tercero (remitente/destinatario), siempre y cuando estos tengan 
	 * 				configurado el numero de celular. (S: SI, N: NO)
	 */
	PERMITE_CONFIRMACION_CELULAR("VICOCERB",EnumParametrosSistema.SIEMPRE_CONSULTA),
	
	/**
	 * @variable	SOLO_CLAVE_MANUAL_OBLIGATORIA
	 * 				Solo el ingreso de clave manual es obligatorio S = SI, N = No.
	 */
	@Deprecated
	SOLO_CLAVE_MANUAL_OBLIGATORIA("INCLAMOB",EnumParametrosSistema.SIEMPRE_CONSULTA),
	
	/**
	 * @variable	SERVICIO_SMS_BD_ACTIVO
	 * 				Permite consultar mensajes de texto a la BD desde el sistema integrador. (S o N)
	 */
	SERVICIO_SMS_BD_ACTIVO("PECOMETE",EnumParametrosSistema.SIEMPRE_CONSULTA),
	
	/**
	 * @variable	ACTIVA_SMS_AGENCIAS_DISPONIBLES_PARA_PAGO_GIRO
	 * 				Parametro que activa servicio de informacion de posibles agencias en donde el beneficiario 
	 * 				puede cobrar un giro dependiendo del rango que fue enviado. S=Activo, N=Inactivo 
	 */
	ACTIVA_SMS_AGENCIAS_DISPONIBLES_PARA_PAGO_GIRO("ACTINFPA",EnumParametrosSistema.SIEMPRE_CONSULTA),
	
	/**
	 * @variable	LLAVE_ALGORITMO_CIFRADO
	 * 				LLave de cifrado
	 */
	LLAVE_ALGORITMO_CIFRADO("KEYSERTO"),
	
	/**
	 * @variable	TITULO_IMPRESION_CLAVE_SEGURIDAD
	 * 				Titulo que se imprime en la tirilla para clave de seguridad
	 */
	TITULO_IMPRESION_CLAVE_SEGURIDAD("LETITOSE"),
	
	
	//Servicio Notificacion SMS operacion Giro
	
	/**
	 * @variable	SERVICIO_NOTIFICA_SMS_OPERACION_GIRO
	 * 				Activa servicio envio SMS beneficiario y remitente - S= Activo, N= Inactivo
	 */
	SERVICIO_NOTIFICA_SMS_OPERACION_GIRO("ACTENSMS",EnumParametrosSistema.SIEMPRE_CONSULTA,EnumExpresionesRegulares.PAR_SIS_BANDERA_S_N),
	
	/**
	 * @variable	BENEFICIARIOS_EXCLUIDOS_NOTIFICACION_SMS_OPERACION_GIRO
	 * 				Listado de tipos de documento y documento, que identifican los terceros excluidos
	 * 				del proceso de notificacion SMS para una operacion de giro, cuando estos son tratados
	 * 				como beneficiario 
	 */
	BENEFICIARIOS_EXCLUIDOS_NOTIFICACION_SMS_OPERACION_GIRO("COTERCON",EnumParametrosSistema.SIEMPRE_CONSULTA,EnumExpresionesRegulares.PAR_SIS_COTERCON_EXMSREMI),
	
	/**
	 * @variable	REMITENTES_EXCLUIDOS_NOTIFICACION_SMS_OPERACION_GIRO
	 * 				Listado de tipos de documento y documento, que identifican los terceros excluidos
	 * 				del proceso de notificacion SMS para una operacion de giro, cuando estos son tratados
	 * 				como remitentes 
	 */
	REMITENTES_EXCLUIDOS_NOTIFICACION_SMS_OPERACION_GIRO("EXMSREMI",EnumParametrosSistema.SIEMPRE_CONSULTA,EnumExpresionesRegulares.PAR_SIS_COTERCON_EXMSREMI),
	
	/**
	 * @variable	LISTA_ID_DOCUMENTOS_NOTIFICACION_SMS
	 * 				ID de  los documentos permitidos para realizar envio del mensaje SMS - (Los ID se 
	 * 				separan por | ) 
	 */
	LISTA_ID_DOCUMENTOS_NOTIFICACION_SMS("CODIDOCU",EnumExpresionesRegulares.PAR_SIS_CODIDOCU),
	
	/**
	 * @variable	ACTIVA_SERVICIO_PEPS
	 * 				Identifica si esta activo o inactivo el servicio general de PEPS 
	 */
	ACTIVA_SERVICIO_PEPS("ACTEPEPS",EnumParametrosSistema.SIEMPRE_CONSULTA,EnumExpresionesRegulares.PAR_SIS_BANDERA_S_N),
	
	/**
	 * @variable	TIPOS_DOCUMENTO_PERMITIDOS_PEPS
	 * 				Tipos de documento permitidos para habilitar o inhabilitar el proceso de PEPS
	 */
	TIPOS_DOCUMENTO_PERMITIDOS_PEPS("TIDOCPER",EnumExpresionesRegulares.PAR_SIS_TIDOCPER),
	
	TIPO_ID_IDENTIFICACION_TERCERO_CONVPEPS("IDTEPROP"),
	
	/**
	 * @variable	VERSIONES_HABILITADAS_GIRO
	 * 				Versiones  habilitadas para realizar transacciones
	 */
	VERSIONES_HABILITADAS_GIRO("VERSHABI"),
	
	//Giros Internacionales
	
	FPISA_CODIGO_CORRESPONSSALES("COCORRES"),
	FPISA_CODIGO_TIPO_DOCUMENTOS("COTIDOCU"),
	FPISA_CODIGO_ACTIVIDADES_ECONOMICAS("COACECON"),
	FPISA_CODIGO_PROFESIONES("CONSPROF"),
	FPISA_CODIGO_PAISES("CONSPAIS"),
	FPISA_CODIGO_PAISES_ENVIO("CONSPAEN"),
	FPISA_CODIGO_DEPARTAMENTOS("CODEPAIS"),
	FPISA_CODIGO_CIUDADES("COCIDEPA"),
	FPISA_CODIGO_TIPOS_MOTIVOS_GIROS("COTIMOGI"),
	FPISA_CODIGO_NUMERALES_ENVIO("CONSNUEN"),
	FPISA_CODIGO_NUMERALES_PAGO("CONSNUPA"),
	FPISA_CODIGO_SENALES_ALERTA("CONSSEAL"),
	FPISA_CODIGO_OPERACIONES_INUSUALES("CONSOPIN"),
	FPISA_CODIGO_MENSAJES("CONSCOME"),
	
	/**
	 * @variable	FPISA_CODIGO_CONSULTA_GIRO_X_REFERENCIA
	 * 				CODIGO DE CONSULTA PARA CONSULTAR GIROS POR REFERENCIA
	 */
	FPISA_CODIGO_CONSULTA_GIRO_X_REFERENCIA("COSECRPG"),
	
	/**
	 * @variable	FPISA_CODIGO_CONSULTA_GIRO_X_BENEFICIARIO
	 * 				CODIGO DE CONSULTA PARA CONSULTAR GIROS POR REFERENCIA
	 */
	FPISA_CODIGO_CONSULTA_GIRO_X_BENEFICIARIO("COGINOBE"),
	
	/**
	 * @variable	FPISA_CODIGO_CONSULTA_TERCERO
	 * 				Codigo del servicio para consultar un tercero en FPISA
	 */
	FPISA_CODIGO_CONSULTA_TERCERO("CODICLUS"),
	
	/**
	 * @variable	FPISA_CODIGO_PAGO_GIRO
	 * 				Codigo del servicio para pagar un giro en FPISA
	 */
	FPISA_CODIGO_PAGO_GIRO("COSEPAPG"),

	/**
	 * @variable	FPISA_CODIGO_ENVIO_GIRO
	 * 				Codigo del servicio para enviar un giro en FPISA
	 */
	FPISA_CODIGO_ENVIO_GIRO("ENVIGIRO"),
	
	/**
	 * @variable	FPISA_CODIGO_COTIZAR_GIRO
	 * 				Codigo del servicio para cotizar un envio de giro en FPISA
	 */
	FPISA_CODIGO_COTIZAR_GIRO("COTIENGI"),
	
	/**
	 * @variable	FPISA_REIMPRESION_INTERNACIONAL
	 * 				Codigo del servicio reimpresion para giros iinternacionales FPISA
	 */
	FPISA_REIMPRESION_INTERNACIONAL("COREIMGI"),
	
	/**
	 * @variable	FPISA_CREAR_ACTUALIZAR_TERCERO_USUARIO
	 * 				Codigo del servicio para crear actualizar tercero usuario en FPISA
	 */
	FPISA_CREAR_ACTUALIZAR_TERCERO_USUARIO("CRACUSUA"),
	
	/**
	 * @variable	FPISA_CREAR_ACTUALIZAR_TERCERO_CLIENTE
	 * 				Codigo del servicio para crear actualizar tercero cliente en FPISA
	 */
	FPISA_CREAR_ACTUALIZAR_TERCERO_CLIENTE("CRACCLIE"),
	
	FPISA_CODIGO_GESTION_RECLAMOS("COREGIIN"),
	FPISA_DESCRIPCION_RECLAMO_1("RECGIIN1"),
	FPISA_DESCRIPCION_RECLAMO_2("RECGIIN2"),
	FPISA_DESCRIPCION_RECLAMO_3("RECGIIN3"),
	FPISA_DESCRIPCION_RECLAMO_4("RECGIIN4"),
	FPISA_DESCRIPCION_RECLAMO_5("RECGIIN5"),
	FPISA_DESCRIPCION_RECLAMO_6("RECGIIN6"),
	FPISA_DESCRIPCION_RECLAMO_7("RECGIIN7"),
	FPISA_DESCRIPCION_RECLAMO_8("RECGIIN8"),
	FPISA_DESCRIPCION_RECLAMO_9("RECGIIN9"),
	FPISA_DESCRIPCION_RECLAMO_10("REGIIN10"),
	FPISA_DESCRIPCION_RECLAMO_11("REGIIN11"),
	FPISA_DESCRIPCION_RECLAMO_12("REGIIN12"),
	
	
	/**
	 * @variable	NOMBRE_DIRECTORIO_ALMACENAMIENTO_CAPTURA_DOCUMENTOS
	 * 				Nombre de la carpeta donde se almacenan temporalmente las
	 * 				imagenes de los documentos para remesas internacionales 
	 */
	NOMBRE_DIRECTORIO_ALMACENAMIENTO_CAPTURA_DOCUMENTOS("DIREIMGI"),
	
	/**
	 * @variable	FORMATO_IMAGENES_DOCUMENTO_INTERNACIONAL
	 * 				Formato de imagenes con las que se capturan las fotos de 
	 * 				capturadas en el proceso de remesas internacionales 
	 */
	FORMATO_IMAGENES_DOCUMENTO_INTERNACIONAL("FOIMDOGI"),
	
	/**
	 * @variable	DIMENSION_IMAGENES_DOCUMENTO_INTERNACIONAL
	 * 				Dimension de las imagines capturadas en el proceso 
	 * 				de remesas internacionales 
	 */
	DIMENSION_IMAGENES_DOCUMENTO_INTERNACIONAL("DIFODOGI"),
	
	/**
	 * @variable	ACTIVA_TRANSMISION_IMAGENES_INTERNACIONAL
	 * 				Activa o inactiva el proceso de transmision de imagenes
	 * 				en el proceso de remesas internacionales 
	 */
	ACTIVA_TRANSMISION_IMAGENES_INTERNACIONAL("ACSTRIGI",EnumParametrosSistema.SIEMPRE_CONSULTA),
	
	/**
	 * @variable	PUERTO_SOCKET_RECEPTOR_INTERNACIONAL
	 * 				Define el puerto del socket encargado de recepcionar
	 * 				las imagenes en el proceso de remesas internacionales 
	 */
	PUERTO_SOCKET_RECEPTOR_INTERNACIONAL("PTSOREGI"),
	
	/**
	 * @variable	TIMEOUT_SOCKET_RECEPTOR_INTERNACIONAL
	 * 				Define el timeout lectura del socket encargado de recepcionar
	 * 				las imagenes en el proceso de remesas internacionales 
	 */
	TIMEOUT_SOCKET_RECEPTOR_INTERNACIONAL("TIMEREGI"),
	
	/**
	 * @variable	TIMEOUT_SOCKET_RECEPTOR_INTERNACIONAL
	 * 				Define el timeout conexion del socket encargado de recepcionar
	 * 				las imagenes en el proceso de remesas internacionales 
	 */
	TIEMPO_ESPERA_TRANSMISION_INTERNACIONAL("TEPTIFPS"),
	
	/**
	 * @variable	IDENTIFICADOR_SUPERGIROS_FPISA
	 * 				Es el idenficador del agente que define
	 * 				a SuperGiros con corresponsal de la Financiera 
	 */
	IDENTIFICADOR_SUPERGIROS_FPISA("AGENTEID"),
	
	/**
	 * @variable	TIPO_PRODUCTO_MONEDA_EXTRANJERA
	 * 				Valores para Tipo de Producto de Moneda Extranjera, 
	 * 				del panel crear/Actualizar Tercero, se insertan pares 
	 * 				de valores con el siguiente formato:
	 * 				CODIGO;VALOR|CODIGO2;VALOR2...|CODIGOn;VALORn
	 */
	TIPO_PRODUCTO_MONEDA_EXTRANJERA("COTIPRME"),
	
	/**
	 * @variable	TIPO_PRODUCTO_MONEDA_EXTRANJERA
	 * 				Valores para el C�digo del Tipo de Moneda Extranjera, 
	 * 				del panel crear/Actualizar Tercero, se insertan pares 
	 * 				de valores con el siguiente formato: 
	 * 				CODIGO;VALOR|CODIGO2;VALOR2...|CODIGOn;VALORn
	 */
	TIPO_MONEDA_EXTRANJERA("COTIMOEX"),
	
	/**
	 * @variable	FPISA_CODIGO_NUMERALES_ENVIO
	 * 				Valores para el C�digo de Numerales de Envio, 
	 * 				del panel Beneficiario para envio remesa, se insertan pares 
	 * 				de valores con el siguiente formato: 
	 * 				CODIGO;VALOR|CODIGO2;VALOR2...|CODIGOn;VALORn
	 */	
	
	
	/**
	 * @variable	CORRESPONSAL_ENVIO
	 * 				Valores para el corresponsal correspondiente a los envios
	 * 				de remesa internacional
	 */
	CORRESPONSAL_ENVIO("CORRENGI"),
	
	/**
	 * @variable	NUMERO_INTENTOS_AUTENTICACION_BIOMETRIA
	 * 				Numero de intentos permitidos para realizar autenticacion 
	 * 				del tercero usando biometria en los procesos 
	 * 				(pago giro, anulacion, cambio beneficiario)
	 */
	NUMERO_INTENTOS_AUTENTICACION_BIOMETRIA("NUMEINBI",EnumParametrosSistema.SIEMPRE_CONSULTA, EnumExpresionesRegulares.PAR_SIS_NUMERICO_ENTERO),
	
	/**
	 * @variable	ACTIVA_SERVICIO_VERIFICACION_DESPUES_ENROLAMIENTO	
	 * 				Identifica si esta activo o inactivo el servicio general de verificacion despues del enrolamiento
	 */
	ACTIVA_SERVICIO_VERIFICACION_DESPUES_ENROLAMIENTO("VERIENRO",EnumParametrosSistema.SIEMPRE_CONSULTA,EnumExpresionesRegulares.PAR_SIS_BANDERA_S_N),
	
	/**
	 * @variable	ACTIVA_SERVICIO_VERIFICACION_DESPUES_ENROLAMIENTO	
	 * 				Listado de terceros convenio a los que aplica la opcion de verificaion despues del enrolamiento 
	 */
	TERCEROS_CONVENIO_VERIFICACION_DESPUES_ENROLAMIENTO("TESENRVE",EnumParametrosSistema.SIEMPRE_CONSULTA,EnumExpresionesRegulares.EXP_VERIFICACION_ENROLAMIENTO),
	
	/**
	 * @variable	TERCEROS_CONVENIO_VERIFICACION_LECTOR2D	
	 * 				Listado de terceros convenio a los que aplica la opcion de el lector 2D 
	 */
	TERCEROS_CONVENIO_VERIFICACION_LECTOR2D("TESOLECD",EnumParametrosSistema.SIEMPRE_CONSULTA,EnumExpresionesRegulares.EXP_VERIFICACION_LECTOR2D),
	
	/**
	 * @variable	TERCEROS_CONVENIO_VERIFICACION_LECTOR2D	
	 * 				Listado de terceros convenio a los que aplica verificacion despues de Biometria 
	 *              en la opcion de el lector 2D 
	 */
	TERCEROS_CONVENIO_VERIFICACION_BIOMETRIA_LECTOR2D("TESOLBIO",EnumParametrosSistema.SIEMPRE_CONSULTA,EnumExpresionesRegulares.EXP_VERIFICACION_LECTOR2D),
	
	/**
	 * @variable	MENSAJE_LECTOR_2D	
	 * 				Mensaje a ser mostrado en la pantalla del lector 2D 
	 */
	MENSAJE_LECTOR_2D("VAINETLD",EnumParametrosSistema.SIEMPRE_CONSULTA),
	/**
	 * @variable	ACTIVA_SERVICIO_VERIFICACION_DESPUES_ENROLAMIENTO	
	 * 				Listado de terceros convenio a los que aplica la opcion de verificaion despues del enrolamiento 
	 */
	VALORES_A_COMPARAR_LECTOR_2D("VACOLEDD",EnumParametrosSistema.SIEMPRE_CONSULTA,EnumExpresionesRegulares.EXP_CAMPOS_A_COMPARAR),
	
	/**
	 * @variable	ACTIVA_SERVICIO_PRUEBA_ADMISIONENTREGA_TIRILLA
	 * 				Identifica si esta activo o inactivo el servicio general de envio de tirillas al correo
	 */
	ACTIVA_SERVICIO_PRUEBA_ADMISIONENTREGA_TIRILLA("SERCOTIR",EnumParametrosSistema.SIEMPRE_CONSULTA,EnumExpresionesRegulares.PAR_SIS_BANDERA_S_N),

	/**
	 * @variable	TIPO_ID_IDENTIFICACION_TERCERO_CORREOTIRILLA
	 * 				Tipos de documento permitidos para habilitar o inhabilitar el proceso de envio de tirillas al correo
	 */
	TIPO_ID_IDENTIFICACION_TERCERO_PRUEBA_ADMISIONENTREGA_TIRILLA("IDTECOTI",EnumParametrosSistema.SIEMPRE_CONSULTA),
	
	/*
	 * @variable	ID_TERCERO_EXCLUIDOS_REMITENTES
	 *              Identificaion de terceros excluidos como remitentes
	 **/
	
	ID_TERCERO_EXCLUIDOS_REMITENTES("IDREMEXC",EnumParametrosSistema.SIEMPRE_CONSULTA),
	/*
	 * @variable	ID_TERCERO_EXCLUIDOS_BENEFICIARIOS
	 *              Identificaion de terceros excluidos como beneficiarios
	 **/
	ID_TERCERO_EXCLUIDOS_BENEFICIARIOS("IDBENEXC",EnumParametrosSistema.SIEMPRE_CONSULTA),
	/*
	 * @variable	ID_PRUEBA_EN_FORMATO_FISICO
	 *              Identificaion del rotulo impresion que hace constancia
	 *              o prueba de entrega fisica. Se entrega la tirilla
	 *              de evidencia a la CRC
	 **/
	ID_PRUEBA_EN_FORMATO_FISICO("CODCRCPR",EnumParametrosSistema.SIEMPRE_CONSULTA),
	
	/*
	 * @variable	ID_PRUEBA_EN_FORMATO_ELECTRONICO
	 *              Identificaion del rotulo impresion que hace constancia
	 *              o prueba de entrega electronica. Se envia la tirilla
	 *              de evidencia a la CRC, mediante un formato de 
	 **/
	ID_PRUEBA_EN_FORMATO_ELECTRONICO("CODCRCEL",EnumParametrosSistema.SIEMPRE_CONSULTA),
	
	/*
	 * @variable	ID_PRUEBA_CRC_CODIGO_ADMSION_ENTREGA
	 *              Identificaion del codigo en PASI que contiene
	 *              Codigo registrado en la tabla DATOS que 
	 *              corresponde a la prueba de admision o entrega
	 **/
	ID_PASI_PRUEBA_CRC_CODIGO_ADMSION_ENTREGA("CODCRCPC",EnumParametrosSistema.SIEMPRE_CONSULTA,EnumExpresionesRegulares.PAR_SIS_NUMERICO_ENTERO),
	
	/*
	 * @variable	ID_PASI_PRUEBA_CRC_SERVICIO_CELULAR_ENVIO
	 *              Identificaion del codigo en PASI que contiene
	 *              Si el servicio para capturar el celular  
	 *              en el envio esta habilitado  S / N
	 **/
	ID_PASI_PRUEBA_CRC_SERVICIO_CELULAR_ENVIO("SERCOENV",EnumParametrosSistema.SIEMPRE_CONSULTA,EnumExpresionesRegulares.PAR_SIS_BANDERA_S_N),
	
	
	/*
	 * @variable	ID_PASI_PRUEBA_CRC_SERVICIO_CELULAR_PAGO
	 *              Identificaion del codigo en PASI que contiene
	 *              Si el servicio para capturar el celular  
	 *              en el pago esta habilitado S / N
	 **/
	ID_PASI_PRUEBA_CRC_SERVICIO_CELULAR_PAGO("SERCOPAG",EnumParametrosSistema.SIEMPRE_CONSULTA,EnumExpresionesRegulares.PAR_SIS_BANDERA_S_N),
	
	/*
	 * @variable	ID_PASI_PRUEBA_CRC_SERVICIO_CELULAR_CAMBIOBENEFICIARIO
	 *              Identificaion del codigo en PASI que contiene
	 *              Si el servicio para capturar el celular  
	 *              en el pago esta habilitado S / N
	 **/
	ID_PASI_PRUEBA_CRC_SERVICIO_CELULAR_CAMBIOBENEFICIARIO("SERCOCBF",EnumParametrosSistema.SIEMPRE_CONSULTA,EnumExpresionesRegulares.PAR_SIS_BANDERA_S_N),
	
	/*
	 * @variable	ID_PASI_PRUEBA_CRC_DATO_ENTIDAD_ENVIO_GIRO
	 *              Identificaion del codigo en PASI que contiene
	 *              el dato entidad para identificar el codigo de
	 *              la operacion de envio de giro
	 **/
	ID_PASI_PRUEBA_CRC_DATO_ENTIDAD_ENVIO_GIRO("CODCRCEN", EnumExpresionesRegulares.PAR_SIS_NUMERICO_ENTERO),
	
	
	/*
	 * @variable	ID_PASI_PRUEBA_CRC_DATO_ENTIDAD_PAGO_GIRO
	 *              Identificaion del codigo en PASI que contiene
	 *              el dato entidad para identificar el codigo de
	 *              la operacion de pago de giro
	 **/
	ID_PASI_PRUEBA_CRC_DATO_ENTIDAD_PAGO_GIRO("CODCRCPG", EnumExpresionesRegulares.PAR_SIS_NUMERICO_ENTERO),
	
	
	
	/*
	 * @variable	ID_PASI_PRUEBA_CRC_DATO_ENTIDAD_CAMBIO_BENEFICIARIO_GIRO
	 *              Identificaion del codigo en PASI que contiene
	 *              el dato entidad para identificar el codigo de
	 *              la operacion de cambio de beneficiario 
	 **/
	ID_PASI_PRUEBA_CRC_DATO_ENTIDAD_CAMBIO_BENEFICIARIO_GIRO("CODCRCCB", EnumExpresionesRegulares.PAR_SIS_NUMERICO_ENTERO),
	
	/*
	 * @variable	VALOR_CORREOS_TERCEROS_NO_SUMINISTRADO_CRC
	 *              Parametro de Sistema que contiene la etiqueta
	 *              por defecto cuando el tercero no tiene correo
	 *              electronico en marca CRC.
	 **/
	
	VALOR_CORREOS_TERCEROS_NO_SUMINISTRADO_CRC("MARCCODE", EnumParametrosSistema.SIEMPRE_CONSULTA),

	/*
	 * @variable	IDENTIFICACIONES_COLABORADORES_RESTRINGIDOS_INGRESOS
	 *              Parametro de sistema que contiene las identificaciones
	 *              de los colaboradores excluidos para las operaciones de
	 *              ingresos.
	 **/
	IDENTIFICACIONES_COLABORADORES_RESTRINGIDOS_INGRESOS("IDREOPIE",EnumParametrosSistema.SIEMPRE_CONSULTA),
	
	
	/**
	 * 
	 * @VARIABLE	ID_DATENID_SOLICITADO_BLOQUEO
	 * 			
	 * 				Id [DATO ENTIDAD]  del nuevo dato SOLICITADO PARA BLOQUEO asociado a la entidad TIPOS DE AUTORIZACIONES
	 */
	
	
	ID_DATENID_SOLICITADO_BLOQUEO("IDDAENLB",EnumParametrosSistema.SIEMPRE_CONSULTA),
	
	/**
	 * 
	 * @VARIABLE	ENT_CAUSAL_SOL_BLOQUEO
	 * 			
	 * 				Parametro que almacena el valor del id de la nueva entidad creada - CAUSAL SOLICITUD PARA BLOQUEO
	 */
	ENT_CAUSAL_SOL_BLOQUEO("IDCAUSBL",EnumParametrosSistema.SIEMPRE_CONSULTA),
	
	
	/**
	 * 
	 * @VARIABLE	PREG_DOFO
	 * 			
	 * 				Parametro de Sistema que contiene la pregunta
	 *              DOF para los terceros marcados a declarar origenes de fondo.
	 */
	PREGUNTA_DECLARACION_ORIGEN_FONDO("PREGDOFO"),
	
	/**
	 * 
	 * @VARIABLE	LONGITUD_RESPUESTA_DECLARACION_ORIGEN_FONDO
	 * 			
	 * 				Longitud maxima para la respuesta de DOF.
	 */
	LONGITUD_RESPUESTA_DECLARACION_ORIGEN_FONDO("LONREDOF"),
	
	/**
	 * 
	 * @VARIABLE	EXPRESION_RESPUESTA_DECLARACION_ORIGEN_FONDO
	 * 			
	 * 				Longitud maxima para la respuesta de DOF.
	 */
	EXPRESION_RESPUESTA_DECLARACION_ORIGEN_FONDO("EXPREDOF"),
	
	/**
	 * 
	 * @VARIABLE	MENSAJE_ALERTA_DECLARACION_NORMATIVA_NATURAL
	 * 			
	 * 				Parametro de Sistema que contiene el mensaje
	 *              para la ventana de alerta en caso que sea
	 *              persona natural
	 */
	MENSAJE_ALERTA_DECLARACION_NORMATIVA_NATURAL("ALERNATU"),
	
	/**
	 * 
	 * @VARIABLE	MENSAJE_ALERTA_DECLARACION_NORMATIVA_JURIDICA
	 * 			
	 * 				Parametro de Sistema que contiene el mensaje
	 *              para la ventana de alerta en caso que sea
	 *              persona juridica
	 */
	MENSAJE_ALERTA_DECLARACION_NORMATIVA_JURIDICA("ALERJURI"),
	
	;
	
	
	
	
	/**
	 * @variable SIEMPRE_CONSULTA 
	 * 			 Bandera positiva (true), utilizada para identificar que 
	 * 			 los parametros de sistema que siempre deberian consultarse
	 * 			 al momento que se solicite, puesto que son parametros de
	 * 			 tiempo real
	 * 
	 * 			 Importante:
	 * 			 El valor de esta variable no se puede inicializar sobre el
	 * 			 bloque estatico de la clase, puesto que las constantes de 
	 * 			 enumeracion, se ejecutan primero que el bloque estatico
	 **/
	public final static boolean SIEMPRE_CONSULTA = true;
	
	/**
	 * @variable SEGUNDOS_DISPONIBLE_VALOR_PARAMETRO_SIEMPRE_CONSULTA 
	 * 			 Cantidad de segundos en los que permanece disponible el valor
	 * 			 del parametro de sistema para aquellos que son de siempre consulta
	 **/
	private final static double SEGUNDOS_DISPONIBLE_VALOR_PARAMETRO_SIEMPRE_CONSULTA;
	
	/**
	 * @variable strCodigo 
	 * 			 Codigo que identifica el parametro de sistema sobre el sistema 
	 * 			 SIMS 
	 **/
	private final String strCodigo;
	
	/**
	 * @variable enmEtiDescripcion 
	 * 			 Constante del enumerador de etiquetas, que permite recuperar 
	 * 			 mediante una etiqueta la descripcion del parametro del sistema
	 **/
	private EnumEtiquetas enmEtiDescripcion;
	
	/**
	 * @variable booSiempreConsulta 
	 * 			 Bandera que identifica si el parametro se debe consultar siempre 
	 * 			 que es invocado 
	 **/
	private boolean booSiempreConsulta;
	
	/**
	 * @variable objParametroSistema 
	 * 			 Objeto parametro del sistema que contiene el valor consultado  
	 * 			 sobre el sistema SIMS
	 **/
	private ParametroSistema objParametroSistema;
	
	/**
	 * @variable lonFechaCreacion 
	 * 			 Tiempo en milisegundos en el cual se realiza la consulta del
	 * 			 parametro de sistema, clave para parametros de SIEMPRE_CONSULTA
	 **/
	private long lonFechaCreacion;
	
	/**
	 * @variable	booProvocoAdvertenciaDeAusencia
	 * 				Bandera que identifica si debe o no provocar una advertencia de ausencia
	 */
	private boolean booProvocoAdvertenciaDeAusencia;
	
	/**
	 * @variable	enmExpRegValidaFormato
	 * 				Constante de enumeracion que identifica una expresion 
  	 * 				regular que permitira validar el formato del valor
  	 * 				asociado al parametro de sistema, cuando este se consulte
	 */
	private EnumExpresionesRegulares enmExpRegValidaFormato;
	
	/**
	 * @variable	enmSistema
	 * 				Constante de enumeracion que representa el sistema sobre el cual se
	 * 				gestionara la informacion referente al parametro, de momento SIMS / Gamble
	 */
	private final EnumSistemas enmSistema;
	
	static{
		
		/*
		 * Importante:
			El valor de la variable SIEMPRE_CONSULTA no se puede inicializar 
			sobre este bloque estatico, puesto que las constantes de enumeracion, 
			se ejecutan primero que el bloque estatico
		 */
		SEGUNDOS_DISPONIBLE_VALOR_PARAMETRO_SIEMPRE_CONSULTA = Double.parseDouble(EnumParametrosApp.SEGUNDOS_DISPONIBLE_VALOR_PARAMETRO_SIEMPRE_CONSULTA.getValorPropiedad())*1000;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo EnumParametrosSistema
  	 * 		   Inicializacion de la constante de enumeracion
  	 * @param pStrCodigo
  	 * 		  Codigo que identifica el parametro de sistema sobre el 
  	 * 		  sistema SIMS
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private EnumParametrosSistema(String pStrCodigo){
		
		this.strCodigo=pStrCodigo;
		this.enmSistema=EnumSistemas.SIMS;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo EnumParametrosSistema
  	 * 		   Inicializacion de la constante de enumeracion
  	 * @param pStrCodigo
  	 * 		  Codigo que identifica el parametro de sistema sobre el 
  	 * 		  sistema SIMS
  	 * @param pEnmEtiDescripcion
  	 * 		  Constante del enumerador de etiquetas, que permite 
  	 * 		  recuperar mediante una etiqueta la descripcion del 
  	 * 		  parametro del sistema
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private EnumParametrosSistema(String pStrCodigo,
								  EnumEtiquetas pEnmEtiDescripcion){
		
		this.strCodigo=pStrCodigo;
		this.enmEtiDescripcion = pEnmEtiDescripcion;
		this.enmSistema=EnumSistemas.SIMS;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo EnumParametrosSistema
  	 * 		   Inicializacion de la constante de enumeracion
  	 * @param pStrCodigo
  	 * 		  Codigo que identifica el parametro de sistema sobre el 
  	 * 		  sistema SIMS
  	 * @param pBooSiempreconsulta
  	 * 		  Bandera que identifica si el parametro se debe consultar 
  	 * 		  siempre que es invocado 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private EnumParametrosSistema(String pStrCodigo,
								  boolean pBooSiempreconsulta){
		
		this.strCodigo=pStrCodigo;
		this.booSiempreConsulta = pBooSiempreconsulta;
		this.enmSistema=EnumSistemas.SIMS;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo EnumParametrosSistema
  	 * 		   Inicializacion de la constante de enumeracion
  	 * @param pStrCodigo
  	 * 		  Codigo que identifica el parametro de sistema sobre el 
  	 * 		  sistema SIMS
  	 * @param pEnmEtiDescripcion
  	 * 		  Constante del enumerador de etiquetas, que permite 
  	 * 		  recuperar mediante una etiqueta la descripcion del 
  	 * 		  parametro del sistema
  	 * @param pBooSiempreconsulta
  	 * 		  Bandera que identifica si el parametro se debe consultar 
  	 * 		  siempre que es invocado 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private EnumParametrosSistema(String pStrCodigo,
								  EnumEtiquetas pEnmEtiDescripcion,
			  					  boolean pBooSiempreconsulta){

		this.strCodigo=pStrCodigo;
		this.booSiempreConsulta = pBooSiempreconsulta;
		this.enmEtiDescripcion = pEnmEtiDescripcion;
		this.enmSistema=EnumSistemas.SIMS;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo EnumParametrosSistema
  	 * 		   Inicializacion de la constante de enumeracion
  	 * @param pStrCodigo
  	 * 		  Codigo que identifica el parametro de sistema sobre el 
  	 * 		  sistema SIMS
  	 * @param	pEnmExpRegValidaFormato
  	 * 			Constante de enumeracion que identifica una expresion 
  	 * 			regular que permitira validar el formato del valor
  	 * 			asociado al parametro de sistema, cuando este se consulte
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private EnumParametrosSistema(String pStrCodigo,
	                              EnumExpresionesRegulares pEnmExpRegValidaFormato){
		
		this.strCodigo=pStrCodigo;
		this.enmExpRegValidaFormato = pEnmExpRegValidaFormato;
		this.enmSistema=EnumSistemas.SIMS;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo EnumParametrosSistema
  	 * 		   Inicializacion de la constante de enumeracion
  	 * @param pStrCodigo
  	 * 		  Codigo que identifica el parametro de sistema sobre el 
  	 * 		  sistema SIMS
  	 * @param pEnmEtiDescripcion
  	 * 		  Constante del enumerador de etiquetas, que permite 
  	 * 		  recuperar mediante una etiqueta la descripcion del 
  	 * 		  parametro del sistema
  	 * @param	pEnmExpRegValidaFormato
  	 * 			Constante de enumeracion que identifica una expresion 
  	 * 			regular que permitira validar el formato del valor
  	 * 			asociado al parametro de sistema, cuando este se consulte
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private EnumParametrosSistema(String pStrCodigo,
								  EnumEtiquetas pEnmEtiDescripcion,
								  EnumExpresionesRegulares pEnmExpRegValidaFormato){
		
		this.strCodigo=pStrCodigo;
		this.enmEtiDescripcion = pEnmEtiDescripcion;
		this.enmExpRegValidaFormato = pEnmExpRegValidaFormato;
		this.enmSistema=EnumSistemas.SIMS;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo EnumParametrosSistema
  	 * 		   Inicializacion de la constante de enumeracion
  	 * @param pStrCodigo
  	 * 		  Codigo que identifica el parametro de sistema sobre el 
  	 * 		  sistema SIMS
  	 * @param pBooSiempreconsulta
  	 * 		  Bandera que identifica si el parametro se debe consultar 
  	 * 		  siempre que es invocado 
  	 * @param	pEnmExpRegValidaFormato
  	 * 			Constante de enumeracion que identifica una expresion 
  	 * 			regular que permitira validar el formato del valor
  	 * 			asociado al parametro de sistema, cuando este se consulte
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private EnumParametrosSistema(String pStrCodigo,
								  boolean pBooSiempreconsulta,
								  EnumExpresionesRegulares pEnmExpRegValidaFormato){
		
		this.strCodigo=pStrCodigo;
		this.booSiempreConsulta = pBooSiempreconsulta;
		this.enmExpRegValidaFormato = pEnmExpRegValidaFormato;
		this.enmSistema=EnumSistemas.SIMS;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo EnumParametrosSistema
  	 * 		   Inicializacion de la constante de enumeracion
  	 * @param pStrCodigo
  	 * 		  Codigo que identifica el parametro de sistema sobre el 
  	 * 		  sistema SIMS
  	 * @param pEnmEtiDescripcion
  	 * 		  Constante del enumerador de etiquetas, que permite 
  	 * 		  recuperar mediante una etiqueta la descripcion del 
  	 * 		  parametro del sistema
  	 * @param pBooSiempreconsulta
  	 * 		  Bandera que identifica si el parametro se debe consultar 
  	 * 		  siempre que es invocado 
  	 * @param	pEnmExpRegValidaFormato
  	 * 			Constante de enumeracion que identifica una expresion 
  	 * 			regular que permitira validar el formato del valor
  	 * 			asociado al parametro de sistema, cuando este se consulte
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private EnumParametrosSistema(String pStrCodigo,
								  EnumEtiquetas pEnmEtiDescripcion,
			  					  boolean pBooSiempreconsulta,
			  					  EnumExpresionesRegulares pEnmExpRegValidaFormato){

		this.strCodigo=pStrCodigo;
		this.booSiempreConsulta = pBooSiempreconsulta;
		this.enmEtiDescripcion = pEnmEtiDescripcion;
		this.enmExpRegValidaFormato = pEnmExpRegValidaFormato;
		this.enmSistema=EnumSistemas.SIMS;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo EnumParametrosSistema
  	 * 		   Inicializacion de la constante de enumeracion
  	 * @param pStrCodigo
  	 * 		  Codigo que identifica el parametro de sistema sobre el
  	 * @param	pEnmSistema
  	 * 			Constante de enumeracion que representa el sistema sobre 
  	 * 			el cual se gestionara la informacion referente al parametro, 
  	 * 			de momento SIMS / Gamble
  	 * 		  sistema SIMS
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private EnumParametrosSistema(String pStrCodigo,
	                              EnumSistemas pEnmSistema){
		
		this.strCodigo=pStrCodigo;
		this.enmSistema=pEnmSistema;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo EnumParametrosSistema
  	 * 		   Inicializacion de la constante de enumeracion
  	 * @param pStrCodigo
  	 * 		  Codigo que identifica el parametro de sistema sobre el 
  	 * 		  sistema SIMS
  	 * @param pEnmEtiDescripcion
  	 * 		  Constante del enumerador de etiquetas, que permite 
  	 * 		  recuperar mediante una etiqueta la descripcion del 
  	 * 		  parametro del sistema
  	 * @param	pEnmSistema
  	 * 			Constante de enumeracion que representa el sistema sobre 
  	 * 			el cual se gestionara la informacion referente al parametro, 
  	 * 			de momento SIMS / Gamble
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private EnumParametrosSistema(String pStrCodigo,
								  EnumEtiquetas pEnmEtiDescripcion,
								  EnumSistemas pEnmSistema){
		
		this.strCodigo=pStrCodigo;
		this.enmEtiDescripcion = pEnmEtiDescripcion;
		this.enmSistema=pEnmSistema;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo EnumParametrosSistema
  	 * 		   Inicializacion de la constante de enumeracion
  	 * @param pStrCodigo
  	 * 		  Codigo que identifica el parametro de sistema sobre el 
  	 * 		  sistema SIMS
  	 * @param pBooSiempreconsulta
  	 * 		  Bandera que identifica si el parametro se debe consultar 
  	 * 		  siempre que es invocado
  	 * @param	pEnmSistema
  	 * 			Constante de enumeracion que representa el sistema sobre 
  	 * 			el cual se gestionara la informacion referente al parametro, 
  	 * 			de momento SIMS / Gamble 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private EnumParametrosSistema(String pStrCodigo,
								  boolean pBooSiempreconsulta,
								  EnumSistemas pEnmSistema){
		
		this.strCodigo=pStrCodigo;
		this.booSiempreConsulta = pBooSiempreconsulta;
		this.enmSistema=pEnmSistema;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo EnumParametrosSistema
  	 * 		   Inicializacion de la constante de enumeracion
  	 * @param pStrCodigo
  	 * 		  Codigo que identifica el parametro de sistema sobre el 
  	 * 		  sistema SIMS
  	 * @param pEnmEtiDescripcion
  	 * 		  Constante del enumerador de etiquetas, que permite 
  	 * 		  recuperar mediante una etiqueta la descripcion del 
  	 * 		  parametro del sistema
  	 * @param pBooSiempreconsulta
  	 * 		  Bandera que identifica si el parametro se debe consultar 
  	 * 		  siempre que es invocado
  	 * @param	pEnmSistema
  	 * 			Constante de enumeracion que representa el sistema sobre 
  	 * 			el cual se gestionara la informacion referente al parametro, 
  	 * 			de momento SIMS / Gamble 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private EnumParametrosSistema(String pStrCodigo,
								  EnumEtiquetas pEnmEtiDescripcion,
			  					  boolean pBooSiempreconsulta,
			  					  EnumSistemas pEnmSistema){

		this.strCodigo=pStrCodigo;
		this.booSiempreConsulta = pBooSiempreconsulta;
		this.enmEtiDescripcion = pEnmEtiDescripcion;
		this.enmSistema=pEnmSistema;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo EnumParametrosSistema
  	 * 		   Inicializacion de la constante de enumeracion
  	 * @param pStrCodigo
  	 * 		  Codigo que identifica el parametro de sistema sobre el 
  	 * 		  sistema SIMS
  	 * @param	pEnmExpRegValidaFormato
  	 * 			Constante de enumeracion que identifica una expresion 
  	 * 			regular que permitira validar el formato del valor
  	 * 			asociado al parametro de sistema, cuando este se consulte
  	 * @param	pEnmSistema
  	 * 			Constante de enumeracion que representa el sistema sobre 
  	 * 			el cual se gestionara la informacion referente al parametro, 
  	 * 			de momento SIMS / Gamble
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private EnumParametrosSistema(String pStrCodigo,
	                              EnumExpresionesRegulares pEnmExpRegValidaFormato,
	                              EnumSistemas pEnmSistema){
		
		this.strCodigo=pStrCodigo;
		this.enmExpRegValidaFormato = pEnmExpRegValidaFormato;
		this.enmSistema=pEnmSistema;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo EnumParametrosSistema
  	 * 		   Inicializacion de la constante de enumeracion
  	 * @param pStrCodigo
  	 * 		  Codigo que identifica el parametro de sistema sobre el 
  	 * 		  sistema SIMS
  	 * @param pEnmEtiDescripcion
  	 * 		  Constante del enumerador de etiquetas, que permite 
  	 * 		  recuperar mediante una etiqueta la descripcion del 
  	 * 		  parametro del sistema
  	 * @param	pEnmExpRegValidaFormato
  	 * 			Constante de enumeracion que identifica una expresion 
  	 * 			regular que permitira validar el formato del valor
  	 * 			asociado al parametro de sistema, cuando este se consulte
  	 * @param	pEnmSistema
  	 * 			Constante de enumeracion que representa el sistema sobre 
  	 * 			el cual se gestionara la informacion referente al parametro, 
  	 * 			de momento SIMS / Gamble
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private EnumParametrosSistema(String pStrCodigo,
								  EnumEtiquetas pEnmEtiDescripcion,
								  EnumExpresionesRegulares pEnmExpRegValidaFormato,
								  EnumSistemas pEnmSistema){
		
		this.strCodigo=pStrCodigo;
		this.enmEtiDescripcion = pEnmEtiDescripcion;
		this.enmExpRegValidaFormato = pEnmExpRegValidaFormato;
		this.enmSistema=pEnmSistema;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo EnumParametrosSistema
  	 * 		   Inicializacion de la constante de enumeracion
  	 * @param pStrCodigo
  	 * 		  Codigo que identifica el parametro de sistema sobre el 
  	 * 		  sistema SIMS
  	 * @param pBooSiempreconsulta
  	 * 		  Bandera que identifica si el parametro se debe consultar 
  	 * 		  siempre que es invocado 
  	 * @param	pEnmExpRegValidaFormato
  	 * 			Constante de enumeracion que identifica una expresion 
  	 * 			regular que permitira validar el formato del valor
  	 * 			asociado al parametro de sistema, cuando este se consulte
  	 * @param	pEnmSistema
  	 * 			Constante de enumeracion que representa el sistema sobre 
  	 * 			el cual se gestionara la informacion referente al parametro, 
  	 * 			de momento SIMS / Gamble
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private EnumParametrosSistema(String pStrCodigo,
								  boolean pBooSiempreconsulta,
								  EnumExpresionesRegulares pEnmExpRegValidaFormato,
								  EnumSistemas pEnmSistema){
		
		this.strCodigo=pStrCodigo;
		this.booSiempreConsulta = pBooSiempreconsulta;
		this.enmExpRegValidaFormato = pEnmExpRegValidaFormato;
		this.enmSistema=pEnmSistema;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo EnumParametrosSistema
  	 * 		   Inicializacion de la constante de enumeracion
  	 * @param pStrCodigo
  	 * 		  Codigo que identifica el parametro de sistema sobre el 
  	 * 		  sistema SIMS
  	 * @param pEnmEtiDescripcion
  	 * 		  Constante del enumerador de etiquetas, que permite 
  	 * 		  recuperar mediante una etiqueta la descripcion del 
  	 * 		  parametro del sistema
  	 * @param pBooSiempreconsulta
  	 * 		  Bandera que identifica si el parametro se debe consultar 
  	 * 		  siempre que es invocado 
  	 * @param	pEnmExpRegValidaFormato
  	 * 			Constante de enumeracion que identifica una expresion 
  	 * 			regular que permitira validar el formato del valor
  	 * 			asociado al parametro de sistema, cuando este se consulte
  	 * @param	pEnmSistema
  	 * 			Constante de enumeracion que representa el sistema sobre 
  	 * 			el cual se gestionara la informacion referente al parametro, 
  	 * 			de momento SIMS / Gamble
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private EnumParametrosSistema(String pStrCodigo,
								  EnumEtiquetas pEnmEtiDescripcion,
			  					  boolean pBooSiempreconsulta,
			  					  EnumExpresionesRegulares pEnmExpRegValidaFormato,
			  					  EnumSistemas pEnmSistema){

		this.strCodigo=pStrCodigo;
		this.booSiempreConsulta = pBooSiempreconsulta;
		this.enmEtiDescripcion = pEnmEtiDescripcion;
		this.enmExpRegValidaFormato = pEnmExpRegValidaFormato;
		this.enmSistema=pEnmSistema;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo obtenerObjParametro
  	 * 		   Metodo que permite obtener el objeto parametro del
  	 * 		   sistema y se encarga de limpiar este de memoria cuando 
  	 * 		   cumple con la condicion necesaria para ello, de aquellos 
  	 * 		   que sean de siempre consulta
  	 * @return ParametroSistema
  	 * 		   Objeto parametro del sistema que contiene el valor 
  	 * 		   consultado sobre el sistema SIMS
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public ParametroSistema obtenerObjParametro()throws Exception{
		
		Mensaje objMensaje;
		EnumMensajes enmMsgParametroConsultaFijaAgotado;
		double douTiempoTranscurrido;
		long lonFechaActual;
		boolean booValidarAusenciaParametroEnBD = true;
		
		if(this.isBooSiempreConsulta()){
			
			lonFechaActual = System.currentTimeMillis();
			douTiempoTranscurrido = lonFechaActual - this.getLonFechaCreacion(); 
			
			if(douTiempoTranscurrido > EnumParametrosSistema.SEGUNDOS_DISPONIBLE_VALOR_PARAMETRO_SIEMPRE_CONSULTA){
				
				booValidarAusenciaParametroEnBD = false;
				this.setObjParametroSistema(null);
				
				enmMsgParametroConsultaFijaAgotado = EnumMensajes.RECOMENDACION_PARA_EVITAR_EXCESO_CONSULTA_PARAMETROS_SISTEMA;
				
				if(EstadoAplicacionEnum.DESARROLLO.equals(FormaLogin.estadoAplicacion)){
				
					enmMsgParametroConsultaFijaAgotado.desplegarMensaje(null, 
							 											EnumClasesMensaje.ADVERTENCIA,
							 											this.getStrCodigo(),
							 											this.name());
				}else{//produccion
					
					objMensaje = enmMsgParametroConsultaFijaAgotado.obtenerMensaje(EnumClasesMensaje.ADVERTENCIA, 
																				   this.getStrCodigo(),
																				   this.name());
					
					UtilidadesGiros.getInstance().mostrarEnConsola(objMensaje.obtenerMensajeProcesado(),
																   System.err);
				}
				
				UtilParametrosSistema.getInstance().consultar(this);
			}
		}
		
		if(booValidarAusenciaParametroEnBD
				&& (this.objParametroSistema == null
					|| this.objParametroSistema.getValor() == null)
				&& !this.isBooProvocoAdvertenciaDeAusencia()//para que el mensaje de advertencia solo se evidencie una vez
				){
			
			this.setBooProvocoAdvertenciaDeAusencia(true);
			
			EnumMensajes.PARAMETRO_SISTEMA_NO_ENCONTRADO_EN_BD.desplegarMensaje(null,
	 																			EnumClasesMensaje.ADVERTENCIA,
	 																			this.getStrCodigo(),
	 																			this.name());
		}
		
		/**
		 * Validar formato del valor del parametro
		 */
		if	(		this.getEnmExpRegValidaFormato ()	!=	null	
				&&	this.objParametroSistema != null
				&& 	this.objParametroSistema.getValor() != null
				&&	!UtilidadesGiros.getInstance ().validaFormato(	this.getEnmExpRegValidaFormato ().getValor (), 
					                                              	this.objParametroSistema.getValor() 
					                                             )
			)
		{
			throw EnumMensajes.PARAMETRO_SISTEMA_FORMATO_NO_VALIDO.generarExcepcion(	EnumClasesMensaje.ERROR, 
			                                                                        	this.getStrCodigo(),
			                                                                        	this.name(),
			                                                                        	this.getEnmExpRegValidaFormato ().getEnmDescripcion ()	==	null
																			  				?	this.getEnmExpRegValidaFormato ().getValor ()
																			  				:	this.getEnmExpRegValidaFormato ().getEnmDescripcion ().toString ()
																			  		);
		}
		
		return this.objParametroSistema;
	}
	
	/** 
	 * ********************************************************************
	 * @method	obtenerValorCadenaSinThrows
	 * 		  	Metodo que se encarga de procesar y obtener el valor del 
	 * 			parametro como una cadena de texto
	 * @return	String
	 * 			Valor del parametro procesado como una cadena de texto
	 * @author	hector.cuenca
	 * @date	1/09/2017
	 * *********************************************************************
	 */
	public String obtenerValorCadenaSinThrows(){
		
		String strResultado;
		
		try{
			strResultado = this.obtenerValorCadena();
		}catch(Exception e){
			strResultado = null;
		}
		
		return strResultado;
	}
	
	/** 
	 * ********************************************************************
	 * @method	obtenerValorCadena
	 * 		  	Metodo que se encarga de procesar y obtener el valor del 
	 * 			parametro como una cadena de texto
	 * @return	String
	 * 			Valor del parametro procesado como una cadena de texto
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	1/09/2017
	 * *********************************************************************
	 */
	public String obtenerValorCadena()throws Exception{
		
		return this.obtenerObjParametro().getValor();
	}
	
	/** 
	 * ********************************************************************
	 * @method	obtenerValorEntero
	 * 		  	Metodo que se encarga de procesar y obtener el valor del 
	 * 			parametro como un numero entero
	 * @return	int
	 * 			Valor del parametro procesado como un valor entero
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	1/09/2017
	 * *********************************************************************
	 */
	public int obtenerValorEntero()throws Exception{
		
		int intResultado;
		
		try{
		
			intResultado = Integer.parseInt(this.obtenerObjParametro().getValor());
			
		}catch(ClientePosSlimGirosException cpsge){
			
			intResultado = 0;
			throw cpsge;
			
		}catch(Exception e){
			
			intResultado = 0;
			throw EnumMensajes.PARAMETRO_SISTEMA_FORMATO_NO_VALIDO.generarExcepcion(EnumClasesMensaje.ERROR, 
																			  		this.getStrCodigo(),
																			  		this.name(),
																			  		EnumEtiquetas.PS_TIPO_DATO_NUMERICO.getValor(false));
		}
		
		return intResultado;
	}
	
	/** 
	 * ********************************************************************
	 * @method obtenerValorBooleano
	 * 		   Metodo que permite obtener el valor tipado del parametro de
	 * 		   sistema, al tipo booleano, realizando una comparacion con una
	 * 		   cadena recibida a traves de equalsIgnoreCase
	 * @param  pStrComparar
	 * 		   Cadena con la cual se comparara el valor del parametro de 
	 * 		   sistema, omitiendo las diferencias en mayusculas/minusculas,
	 * 		   en caso de coincidir o no, true y false respectivamente
	 * @return boolean
	 * 		   Bandera que permite identificar el resultado de la comparacion
	 * 		   entre el valor del parametro de sistema y la cadena recibida
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   4/4/2016
	 * *********************************************************************
	 */
	public boolean obtenerValorBooleano(String pStrComparar)throws Exception{
		
		boolean booResultado;
		
		booResultado = this.obtenerValorCadena().equalsIgnoreCase(pStrComparar);
		
		return booResultado;
	}
	
	/**
	 * @method	getStrCodigo
	 * 		  	Metodo get del atributo strCodigo
	 * @return	String
	 *		  	Valor del atributo strCodigo devuelto
	 * @author	hector.cuenca
	 * @date  	1/09/2017
	 */
	public String getStrCodigo ()
	{
		return this.strCodigo;
	}

	/**
	 * @method	getEnmEtiDescripcion
	 * 		  	Metodo get del atributo enmEtiDescripcion
	 * @return	EnumEtiquetas
	 *		  	Valor del atributo enmEtiDescripcion devuelto
	 * @author	hector.cuenca
	 * @date  	1/09/2017
	 */
	public EnumEtiquetas getEnmEtiDescripcion ()
	{
		return this.enmEtiDescripcion;
	}

	/**
	 * @method	setEnmEtiDescripcion
	 * 		  	Metodo set del atributo enmEtiDescripcion
	 * @param	pEnmEtiDescripcion
	 * 			Valor que tomara el atributo enmEtiDescripcion
	 * @author	hector.cuenca
	 * @date	1/09/2017
	 */
	public void setEnmEtiDescripcion (EnumEtiquetas pEnmEtiDescripcion)
	{
		this.enmEtiDescripcion = pEnmEtiDescripcion;
	}

	/**
	 * @method	isBooSiempreConsulta
	 * 		  	Metodo get del atributo booSiempreConsulta
	 * @return	boolean
	 *		  	Valor del atributo booSiempreConsulta devuelto
	 * @author	hector.cuenca
	 * @date  	1/09/2017
	 */
	public boolean isBooSiempreConsulta ()
	{
		return this.booSiempreConsulta;
	}

	/**
	 * @method	setBooSiempreConsulta
	 * 		  	Metodo set del atributo booSiempreConsulta
	 * @param	pBooSiempreConsulta
	 * 			Valor que tomara el atributo booSiempreConsulta
	 * @author	hector.cuenca
	 * @date	1/09/2017
	 */
	public void setBooSiempreConsulta (boolean pBooSiempreConsulta)
	{
		this.booSiempreConsulta = pBooSiempreConsulta;
	}

	/**
	 * @method	setObjParametroSistema
	 * 		  	Metodo set del atributo objParametroSistema
	 * @param	pObjParametroSistema
	 * 			Valor que tomara el atributo objParametroSistema
	 * @author	hector.cuenca
	 * @date	1/09/2017
	 */
	public void setObjParametroSistema (ParametroSistema pObjParametroSistema)
	{
		this.objParametroSistema = pObjParametroSistema;
		this.setLonFechaCreacion(System.currentTimeMillis());
	}

	/**
	 * @method	getEnmExpRegValidaFormato
	 * 		  	Metodo get del atributo enmExpRegValidaFormato
	 * @return	EnumExpresionesRegulares
	 *		  	Valor del atributo enmExpRegValidaFormato devuelto
	 * @author	hector.cuenca
	 * @date  	30/08/2017
	 */
	public EnumExpresionesRegulares getEnmExpRegValidaFormato ()
	{
		return enmExpRegValidaFormato;
	}

	/**
	 * @method	getLonFechaCreacion
	 * 		  	Metodo get del atributo lonFechaCreacion
	 * @return	long
	 *		  	Valor del atributo lonFechaCreacion devuelto
	 * @author	hector.cuenca
	 * @date  	1/09/2017
	 */
	public long getLonFechaCreacion ()
	{
		return this.lonFechaCreacion;
	}

	/**
	 * @method	setLonFechaCreacion
	 * 		  	Metodo set del atributo lonFechaCreacion
	 * @param	pLonFechaCreacion
	 * 			Valor que tomara el atributo lonFechaCreacion
	 * @author	hector.cuenca
	 * @date	1/09/2017
	 */
	public void setLonFechaCreacion (long pLonFechaCreacion)
	{
		this.lonFechaCreacion = pLonFechaCreacion;
	}

	/**
	 * @method	isBooProvocoAdvertenciaDeAusencia
	 * 		  	Metodo get del atributo booProvocoAdvertenciaDeAusencia
	 * @return	boolean
	 *		  	Valor del atributo booProvocoAdvertenciaDeAusencia devuelto
	 * @author	hector.cuenca
	 * @date  	1/09/2017
	 */
	public boolean isBooProvocoAdvertenciaDeAusencia ()
	{
		return this.booProvocoAdvertenciaDeAusencia;
	}

	/**
	 * @method	setBooProvocoAdvertenciaDeAusencia
	 * 		  	Metodo set del atributo booProvocoAdvertenciaDeAusencia
	 * @param	pBooProvocoAdvertenciaDeAusencia
	 * 			Valor que tomara el atributo booProvocoAdvertenciaDeAusencia
	 * @author	hector.cuenca
	 * @date	1/09/2017
	 */
	public void setBooProvocoAdvertenciaDeAusencia (boolean pBooProvocoAdvertenciaDeAusencia)
	{
		this.booProvocoAdvertenciaDeAusencia = pBooProvocoAdvertenciaDeAusencia;
	}

	/**
	 * @method	setEnmExpRegValidaFormato
	 * 		  	Metodo set del atributo enmExpRegValidaFormato
	 * @param	pEnmExpRegValidaFormato
	 * 			Valor que tomara el atributo enmExpRegValidaFormato
	 * @author	hector.cuenca
	 * @date	30/08/2017
	 */
	public void setEnmExpRegValidaFormato (EnumExpresionesRegulares pEnmExpRegValidaFormato)
	{
		this.enmExpRegValidaFormato = pEnmExpRegValidaFormato;
	}

	/**
	 * @method	getEnmSistema
	 * 		  	Metodo get del atributo enmSistema
	 * @return	EnumSistemas
	 *		  	Valor del atributo enmSistema devuelto
	 * @author	hector.cuenca
	 * @date  	2/09/2017
	 */
	public EnumSistemas getEnmSistema ()
	{
		return this.enmSistema;
	}
}

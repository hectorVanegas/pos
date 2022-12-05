package co.com.codesa.clienteposslimgiros.enumeraciones;

import java.io.File;

/**
 * ****************************************************************.
 * @author: Hector Q-en-K
 * @type: Enumerador
 * @name EnumParametrosApp
 * @description: Clase enumerador que permite recuperar los valores 
 * 				 constantes parametrizados en el archivo de propiedades 
 * 				 parametrosAppGiros.properties
 * @version: 05-03-2015
 * @copyright: Copyright  1998-2012 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public enum EnumParametrosApp {
	
	PLANTILLA_MENSAJE_PROCESADO("plantilla_mensaje_procesado"),
	MENSAJE_NO_DOCUMENTADO("mensaje_no_documentado"),
	PNL_TERR_CANT_SECCIONES("pnl_terr_cant_secciones"),//4
	EDAD_MAYOR("edad_mayor"),//18
	MAXIMA_EDAD_PERMITIDA_PARA_REGISTRO("maxima_edad_permitida_para_registro"),//120
	FECHA_VACIA("fecha_vacia"),//01/01/1920
	DIRECCION_VACIA("direccion_vacia"),//SIN DIRECCION
	MONEDA("moneda"),//1
	CONCEPTO("concepto"),//3
	COMPROBANTE_PROVISION("comprobante_provision"),//4
	COMPROBANTE_DESEMBOLSO("comprobante_desembolso"),
	COMPROBANTE_CAJA("comprobante_caja"),
	DESCRIPCION_ESTADO_GIRO_PENDIENTE("descripcion_estado_giro_pendiente"),//PENDIENTE
	NO_APLICA("no_aplica","N/A"),
	TODO_APLICA("todo_aplica","T/A"),
	ALFANUMERICO("alfanumerico","A"),
	NUMERICO("alfanumerico","N"),
	CONTRASENA_NO_PERMITIDA("contrasena_no_permitida"),//123456
	ANCHO_MAXIMO_FORMAS_RECOMENDADO_X_RESOLUCION("ancho_maximo_formas_recomendado_x_resolucion"),//800
	ALTO_MAXIMO_FORMAS_RECOMENDADO_X_RESOLUCION("alto_maximo_formas_recomendado_x_resolucion"),//670
	RUTA_APP("ruta_app",System.getProperty("user.dir")+File.separator),
	DIRECTORIO_APP("directorio_app", new File(System.getProperty("user.dir"))),
	
	/**
	 * Esta propiedad ya no tiene uso, puesto que actualmente SIMS, no controla este dato
	 * por ende ya no es necesario tenerlo funcionando, se puede enviar un valor por defecto
	 * que cumpla con la especificacion de la trama, pero en SIMS este campo no validara 
	 */
	//@Deprecated
	//CODIGO_INICIAL_AGENCIA_SIMS("codigo_inicial_agencia_sims"),
	
	//Seguridad
	LLAVE_DESCIFRAR_WSQ("llave_descifrar_wsq"),//C0D3S4RR0LL0HWSQ
	
	//Parametros del sistema
	CANTIDAD_PARAMETROS_X_TRAMA_CARGA_INICIAL("cantidad_parametros_x_trama_carga_inicial"),
	SEGUNDOS_DISPONIBLE_VALOR_PARAMETRO_SIEMPRE_CONSULTA("segundos_disponible_valor_parametro_siempre_consulta"),
	
	//Documentos
	DOC_CONVENIO_RECAUDOS("doc_convenio_recaudos","27"), //27
	
	//Impresion
	//Constantes Impresion
	CNST_IMPR_IGUAL("cnst_impr_igual"),//<IGUAL>
	CNST_IMPR_SEPARADOR("cnst_impr_separador"),//<SEPARADOR>
	ID_REIMPRESION("id_reimpresion","**REIMPRESION**"),//Re-Impresi�n
	//Tipos de Impresora
	TIPO_IMPRESION("tipo_impresion"),//tipo
	ID_NOMBRE_IMPRESORA_TIRILLA("id_nombre_impresora_tirilla"),//nombreImpresoraGirosTMU
	ID_NOMBRE_IMPRESORA_MEDIA_CARTA("id_nombre_impresora_media_carta"),//nombreImpresoraGirosMC
	NOMBRE_IMPRESORA_NO_CONFIGURADA("nombre_impresora_no_configurada"),//No configurada
	
	//Tipos de Productos
	NOMBRE_PRODUCTO_GIROS("nombre_producto_giros"),//Giros
	
	//Productos
	PRODUCTO_GIROS_ID("producto_giros_id","1"),//1
	PRODUCTO_MENSAJE_TEXTO("producto_mensaje_texto"),//4
	PRODUCTO_SEGURO_HURTO_MUERTE_ACCIDENTAL("producto_seguro_hurto_muerte_accidental"),//2
	PRODUCTO_RECAUDOS_ID("producto_recaudos_id","5"),//5
	
	//Tipos Naturaleza de Documento
	DOCUMENTO_NATURALEZA_POSITIVA("documento_naturaleza_positiva"),//+
	DOCUMENTO_NATURALEZA_NEGATIVA("documento_naturaleza_negativa"),//-
	
	//Tipos Naturaleza de Conceptos
	CONCEPTO_NATURALEZA_EGRESO("concepto_egreso",34),//34
	CONCEPTO_NATURALEZA_INGRESO("concepto_ingreso",33),//33
		
	//Tipos Descripcion Tercero
	DESCRIPCION_TERCERO_REMITENTE("descripcion_tercero_remitente"),//Remitente
	DESCRIPCION_TERCERO_BENEFICIARIO("descripcion_tercero_beneficiario"),//Beneficiario
	DESCRIPCION_TERCERO_TRAMITADOR("descripcion_tercero_tramitador"),//Tramitador
	DESCRIPCION_TERCERO_APODERADO("descripcion_tercero_apoderado"),//Apoderado
	
	//Tipos denominacion, se guarda el codigo de denominacion en archivo
	TIPO_DENOMINACION_BILLETE("tipo_denominacion_billete"),//47
	TIPO_DENOMINACION_MONEDA("tipo_denominacion_moneda"),//48
	TIPO_DENOMINACION_CHEQUE("tipo_denominacion_cheque"),//49
	TIPO_DENOMINACION_VALE("tipo_denominacion_vale"),//50
	
	//Tipos solicitudes
	TIPO_SOLICITUD_AUTORIZACION("tipo_solicitud_autorizacion"),//1
	TIPO_SOLICITUD_LEVANTAMIENTO("tipo_solicitud_levantamiento"),//2
	TIPO_SOLICITUD_LEVANTAMIENTO_Y_AUTORIZACION("tipo_solicitud_levantamiento_y_autorizacion","3"),//3
	
	//Tipos de conceptos
	TIPO_CONCEPTO_PAGO_GIRO("tipo_concepto_pago_giro"),//1
	
	//Tipos de reimpresion
	TIPO_REIMPRESION_CONSTANTE("tipo_reimpresion", "1"),
	TIPO_REIMPRESION_ENVIO_GIRO("tipo_reimpresion_envio_giro","1"),
	TIPO_REIMPRESION_PAGO_GIRO("tipo_reimpresion_pago_giro","2"),
	TIPO_REIMPRESION_INGRESO("tipo_reimpresion_ingreso","3"),
	TIPO_REIMPRESION_EGRESO("tipo_reimpresion_egreso","4"),
	TIPO_REIMPRESION_ARQUEO_CAJA("tipo_reimpresion_arqueo_caja","5"),
	TIPO_REIMPRESION_ENVIO_RECAUDO("tipo_reimpresion_envio_recaudo","8"),
	
	//Tipos de reimpresion Remesas Internacionales
	TIPO_REIMPRESION_ENVIO_REMESA("tipo_reimpresion_envio_remesa","2"),//2
	TIPO_REIMPRESION_PAGO_REMESA("tipo_reimpresion_pago_remesa","1"),//1
	
	//Constantes reimpresion pago internacional
	REFERENCIA_PAGO_INTERNACIONAL("referencia_pago_internacional","0"),//0
	DESCRIPCION_FPISA_ULTIMO_PAGO_INTERNACIONAL("descripcion_fpisa_pago_internacional","REFERENCIAFPISA"),//REFERENCIAFPISA
			
	//Valores_JSpinner
	SPN_VALOR_INICIAL("spn_valor_inicial"),//1
	SPN_VALOR_MINIMO("spn_valor_minimo"),//1
	SPN_VALOR_MAXIMO("spn_valor_maximo"),//1000000
	SPN_VALOR_INCREMENTO("spn_valor_incremento"),//1
	
	//Archivos de Propiedades
	ESTADO_CFG("estado_cfg"),
	CONFIGURACION_IMPRESORA_PROPERTIES("configuracion_impresora_properties"),
	
	//XMLs
	RUTA_INTERNA_XML_TERRITORIOS("ruta_interna_xml_territorios"),
	RUTA_INTERNA_XML_DATOS_ENTIDADES("ruta_interna_xml_datos_entidades"),
	RUTA_INTERNA_XML_DIRECCIONES("ruta_interna_xml_direcciones"),
	RUTA_INTERNA_XML_ACTIVIDADES_ECONOMICAS("ruta_interna_xml_actividades_economicas"),
	
	//Ids - Codigos
	//Codigo - afectaCaja - Concepto
	//COD_AFECTA_CAJA_CONCEPTO("cod_afecta_caja_concepto","31"),//31
	//COD_NO_AFECTA_CAJA_CONCEPTO("cod_no_afecta_caja_concepto","32"),
	//Codigos Dane
	CODIGO_DANE_COLOMBIA("codigo_dane_colombia"),//56
	CODIGO_DANE_DEPARTAMENTO_X_DEFECTO("codigo_dane_departamento_x_defecto"),//05
	CODIGO_DANE_MUNICIPIO_X_DEFECTO("codigo_dane_municipio_x_defecto"),//05001
	//Codigos Tipos Territorios
	CODIGO_TIPO_TERRITORIO_PAIS("codigo_tipo_territorio_pais"),//1
	CODIGO_TIPO_TERRITORIO_DEPARTAMENTO("codigo_tipo_territorio_departamento"),//2
	CODIGO_TIPO_TERRITORIO_MUNICIPIO("codigo_tipo_territorio_municipio"),//3
	CODIGO_TIPO_TERRITORIO_ZONA("codigo_tipo_territorio_zona"),//6
	//Codigos Conceptos
	CODIGO_CONCEPTO_ENVIO_GIRO_POSTAL("codigo_concepto_envio_giro_postal","2"),
	CODIGO_CONCEPTO_PAGO_GIRO_POSTAL("codigo_concepto_pago_giro_postal","1"),
	
	//Entidades
	ENT_TIPOS_IDENTIFICACION("ent_tipos_identificacion"),//4
	ENT_TIPOS_IDENTIFICACION_INGRESO_EGRSO("ent_tipos_identificacion_ingreso_egreso"),
	ENT_TIPOS_IDENTIFICACION_APODERADO("ent_tipos_identificacion_apoderado"),//023
	ENT_TIPOS_SOLICITUDES_AUTORIZACIONES("ent_tipos_solicitudes_autorizaciones"),//20
	ENT_TIPOS_PERSONA("ent_tipos_persona"),//7
	ENT_TIPOS_TERCERO("ent_tipos_tercero"),//8
	ENT_TIPOS_OPER_INUSUALES("ent_tipos_oper_inusuales","6"),
	ENT_ANOTACIONES_GIRO("ent_anotaciones_giro","28"),//28
	ENT_ESTADOS_GIRO("ent_estados_giro"), //9
	
	//Datos Entidades
	//Tipos Documento Tercero
	COD_DAT_ENT_TPDOC_CC("cod_dat_ent_tpdoc_cc"),//3
	COD_DAT_ENT_TPDOC_CE("cod_dat_ent_tpdoc_ce"),//4
	COD_DAT_ENT_TPDOC_TI("cod_dat_ent_tpdoc_ti"),//5
	COD_DAT_ENT_TPDOC_NIT("cod_dat_ent_tpdoc_nit"),//8
	COD_DAT_ENT_TPDOC_PA("cod_dat_ent_tpdoc_pa"),//7
	COD_DAT_ENT_TPDOC_CEX("cod_dat_ent_tpdoc_cex"),//6
	//Tipo Solicitud Autorizacion
	COD_DAT_ENT_TP_SOL_CAMBIO_BENEFICIARIO("cod_dat_ent_tp_sol_cambio_beneficiario"),//58
	COD_DAT_ENT_TP_SOL_ANULACION("cod_dat_ent_tp_sol_anulacion","56"),//56
	COD_DAT_ENT_TP_SOL_LEVANTAMIENTO_RESTRICCION("cod_dat_ent_tp_sol_levantamiento_restriccion"),//126
	COD_DAT_ENT_TP_SOL_LEVANTAMIENTO_REZAGO("cod_dat_ent_tp_sol_levantamiento_rezago"),//127
	//Tipos Persona
	COD_DAT_ENT_TPPER_NATURAL("cod_dat_ent_tpper_natural"),
	COD_DAT_ENT_TPPER_JURIDICA("cod_dat_ent_tpper_juridica"),
	//Tipos Tercero
	COD_DAT_ENT_TPTERC_CLIENTE("cod_dat_ent_tpterc_cliente"),//11
	//tipo de direccion clase via 
	TIP_DAT_DIRECCION_CLASE_VIA_ESPECIFICACION_ABIERTA("tip_dat_direccion_clase_via_especificacion_abierta"),//A
	//Medio de Pago
	COD_DAT_ENT_MEDIO_PAGO_CREDITO("cod_dat_ent_medio_pago_credito"),
	//Estados Autorizaciones
	DAT_ENT_AUTORIZACION_PENDIENTE("dat_ent_autorizacion_pendiente","56"),
	DAT_ENT_AUTORIZACION_AUTORIZADO("dat_ent_autorizacion_autorizado","57"),
	DAT_ENT_AUTORIZACION_NO_AUTORIZADO("dat_ent_autorizacion_no_autorizado","58"),
	//Direccion
	ENT_DIRECCION_CLASES_VIA("ent_direccion_clases_via"),//D1
	ENT_DIRECCION_CLASES_VIA_INTERNACIONAL("ent_direccion_clases_via_internacional"),//D1
	ENT_DIRECCION_SECTORES_UBICACION("ent_direccion_sectores_ubicacion"),//D2
	ENT_DIRECCION_CARACTERISTICAS_LUGAR("ent_direccion_caracteristicas_lugar"),//D3
	ENT_DIRECCION_ESTRATOS_BARRIO("ent_direccion_estratos_barrio"),//D4
	//Estados Giro
	COD_DAT_ENT_ESGI_REZAGO("cod_dat_ent_esgi_rezago","REZAGO"), //125
	COD_DAT_ENT_ESGI_NO_DISTRIBUIBLE("cod_dat_ent_esgi_no_distribuible","NO DISTRIBUIBLE"), //124
	COD_DAT_ENT_ESGI_ANULADO("cod_dat_ent_esgi_anulado","ANULADO"), //41
	
	// Biometria
	SOLICITAR_LEER_HUELLA("solicitar_leer_huella"),
	NO_SE_LOGRO_DETECTAR_HUELLA("no_se_logro_detectar_huella"),
	NO_LOGRO_DETECTAR_LECTOR("no_logro_detectar_lector"),
	CAPTURA_EXITOSA("captura_exitosa"),
	LECTURA_HUELLA_ERR("lectura_huella_err"),
	INTENTOS_LECTURA_HUELLA_CAJERO("intentos_lectura_huella_cajero"),
	INTENTOS_LECTURA_HUELLA_CLIENTE("intentos_lectura_huella_cliente"),
	DEDO_NO_DETECTADO("dedo_no_detectado"),
	LECTOR_NO_DETECTADO("lector_no_detectado"),
	CONEXION_AFIS_ERROR("conexion_afis_error"),
	ERROR_IMAGEN_NULA("error_imagen_nula"),
	BIO_FALLIDA("bio_fallida"),
	ESTADO_PENDIENTE_BIOMETRIA_TERCERO("estado_pendiente_biometria_tercero"),
	ESTADO_ENROLADO_BIOMETRIA_TERCERO("estado_enrolado_biometria_tercero"),
	SOLICITAR_LEER_HUELLA_DER("solicitar_leer_huella_derecha"),
	SOLICITAR_LEER_HUELLA_IZQ("solicitar_leer_huella_izquierda"),
	BIO_RESPUESTA_INCOMPLETA("respuesta_incompleta"),
	BIO_HUELLA_CALIDAD_BAJA("huella_calidad_baja"),
	BIO_HUELLA_FALLIDA("huella_fallida"),
	BIO_RES_REINICIE_IDVERIFY("bio_res_reinicie_idverify"),
	BIO_RES_FALLA_LECTURA("bio_res_falla_lectura"),
	BIO_RES_CALIDAD_BAJA("bio_res_calidad_baja"),
	BIO_ADMPRO_CALIDAD_BAJA("bio_admpro_calidad_baja"),
	BIO_RES_LECTOR_NO_DETECTADO("bio_res_lector_no_dectectado"),
	BIO_LECTURA_FALLIDA("bio_lectura_fallida"),
	BIO_LECTURA_BAJA("bio_lectura_baja"),
	BIO_LONGITUD_MAX_HUELLA_DEFECTO("bio_longitud_max_huella_defecto"),
	BIO_LONGITUD_MAX_HUELLA_DEFECTO_INTERNACIONAL("bio_longitud_max_huella_defecto_internacional"),
	BIO_REINICIE_IDVERIFY("bio_reinicie_idverify"),
	BIO_CAPTURA_NO_EXITOSA_ND("bio_captura_no_exitosa_nd"),
	MENSAJE_VERIFICA_DESPUES_ENROLAMIENTO("mensaje_verifica_despues_enrolamiento"),
	
	//Constantes
	ID_ENTER("id_enter","<ENTER>"),
	LOCALHOST("localhost","localhost"),	
	DOCP_AGCDESTINO("docp_agdestino","1"),
	DOCP_AGCORIGEN ("docp_agcorigen" ,"2"),
	ACEPTACION_DESEMBOLSO("aceptacion_desembolso" ,"0"),
	ACEPTACION_PROVISION("aceptacion_provision" ,"1"),
	ACEPTAR_DESEMBOLO ("aceptar_desembolso" ,"45"),
	RECHAZAR_DESEMBOLO ("rechazar_desembolso" ,"46"),
	
	CONSULTA_AUTO_DIRZONA("consulta_auto_dirzona","1"),
	CONSULTA_AUTO_CAJERO("consulta_auto_cajero","2"),
	
	//Caracteres 
	SALTO_LINEA("salto_linea"),
	RETORNO_CARRO("retorno_carro"),
	COMILLA_SIMPLE("comilla_simple"),
	COMILLA_DOBLE("comilla_doble"),
	COMILLA_SIMPLE_IZQUIERDA("comilla_simple_izquierda"),
	COMILLA_SIMPLE_DERECHA("comilla_simple_derecha"),
	PUNTO_VINETA("punto_vineta"),
	
	//SuperCombo
	SC_TERCERO_ASEGURABLE("tercero_asegurable"),
	SC_ASEGURADO_EXCEDE_LIMITE_SEGURO("sc_asegurado_excede_limite_seguro"),
	SC_PROBLEMAS_CONSULTANDO_CLIENTE_WS("sc_problemas_consultando_cliente_ws"),
	SC_ILLEGAL_CHARACTER("sc_illegal_character"),
	SC_RESPUESTA_EXTERNO("sc_respuesta_extero"),
	SC_RESPUESTA_WS("sc_respuesta_ws"),
	SPC_SMS_SIN_SMS("spc_sms_sin_sms","CONSMSNO"),
	SPC_SMS_SOLO_REMITENTE("spc_sms_sin_sms","CONSMSRE"),
	SPC_SMS_SOLO_DESTINATARIO("spc_sms_sin_sms","CONSMSDT"),
	SPC_SMS_AMBOS("spc_sms_sin_sms","CONSMSTO"),
	SPC_SMS_SIN_SMS_TRAMA("spc_sms_sin_sms","N"),
	SPC_SMS_SOLO_REMITENTE_TRAMA("spc_sms_sin_sms","R"),
	SPC_SMS_SOLO_DESTINATARIO_TRAMA("spc_sms_sin_sms","D"),
	SPC_SMS_AMBOS_TRAMA("spc_sms_sin_sms","T"),
	SPC_GIRO_ASEGURADO_REMITENTE("spc_giro_asegurado_remitente", "Giro asegurado por el remitente"),
	SPC_GIRO_ASEGURADO_BENEFICIARIO("spc_giro_asegurado_beneficiario", "Giro asegurado por el beneficiario"),
	
	//Servicios adicionales
	//Clave seguridad
	SRV_ADI_CLV_SEG_CLAVE_CORRECTA("srv_adi_clv_seg_clave_correcta"),
	
	//Versiones
	//version del producto giro
	VERSION_GIRO("version_giro"),
	
	//Captura Fotos Documentos Remesas Internacionales
	CDI_DOCUMENTO_ANVERSO("cdi_etiqueta_documento_anverso"),
	CDI_DOCUMENTO_REVERSO("cdi_etiqueta_documento_reverso"),
	IP_SOCKET_RECEPTOR_INTERNACIONAL("ip_socket_internacional"),
	
	//Tipos Documento Tercero
	COD_TPDOC_INTER_CC("cod_tpdoc_inter_cc"),//CC
	COD_TPDOC_INTER_CE("cod_tpdoc_inter_ce"),//CE
	COD_TPDOC_INTER_TI("cod_tpdoc_inter_ti"),//TI
	COD_TPDOC_INTER_PA("cod_tpdoc_inter_pa"),//PA
	COD_TPDOC_INTER_OT("cod_tpdoc_inter_ot"),//OT
	
	OII_NUMERO_TRANSACCIONES_ASOCIADAS("oii_numero_transacciones_asociadas"),
	
	;
	
	private final String strPropiedad;
	private Object objConstante;
	private String strValorPropiedad;
	private boolean procesado;
	
	private EnumParametrosApp(String pStrPropiedad){
		
		this.strPropiedad=pStrPropiedad;
	}
	
	private EnumParametrosApp(String pStrPropiedad,
							  Object pObjConstante){
		
		this.strPropiedad=pStrPropiedad;
		this.objConstante = pObjConstante;
	}
	
	private void validaProcesado(){
		
		if(!this.procesado){
			this.cargar();
			this.procesado=true;
		}
	}
	
	private void cargar(){
		
		try{
			
			this.strValorPropiedad = EnumRecursosProperties.PARAMETROS.getRsbRecurso().getString(this.getStrPropiedad());
			
		}catch(Exception e){
			
			this.strValorPropiedad = null;
		}
	}

	public String getValorPropiedad() {
		
		this.validaProcesado();
		
		return this.strValorPropiedad;
	}
	
	public void setValorPropiedad(String pStrValorPropiedad) {
		this.strValorPropiedad = pStrValorPropiedad;
	}
	
	public int getValorEntero()throws Exception{
		
		String valorCadena;
		int valorEntero;
		
		valorCadena = this.getValorPropiedad();
		valorEntero = Integer.parseInt(valorCadena.trim());
		
		return valorEntero;
	}
	
	public Object castValorPropiedad(Class<?> pObjClass)throws Exception{
		
		return pObjClass.getDeclaredConstructor(String.class).newInstance(this.getValorPropiedad());
	}
	
	public String getObjConstante() {
		return objConstante.toString();
	}

	public void setObjConstante(Object pObjConstante) {
		this.objConstante = pObjConstante;
	}

	public boolean isProcesado() {
		return procesado;
	}

	public void setProcesado(boolean procesado) {
		this.procesado = procesado;
	}
	
	public String getStrPropiedad() {
		return strPropiedad;
	}
}

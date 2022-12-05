package co.com.codesa.clienteposslimgiros.enumeraciones;

import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;

/**
 * ****************************************************************.
 * @author: Hector Q-en-K
 * @type: Enumerador
 * @name EnumEtiquetas
 * @description: Clase enumerador que permite recuperar los valores 
 * 				 constantes parametrizados en el archivo de propiedades 
 * 				 etiquetasMsgGiros.properties
 * @version: 05-03-2015
 * @copyright: Copyright  1998-2012 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public enum EnumEtiquetas{

	/**
	 * @author: Hector Q-en-K
	 * @type: Atributo
	 * @name: N/A
	 * @description: listado de constantes de enumerador 
	 * @version: 05/03/2015
	 */
	
	//General
	PERSONALIZADA("personalizada"),
	TLP_CABECERA_GRILLA("tlp_cabecera_grilla"),
	LBL_NO_SELECCIONADO("lbl_no_seleccionado",false),
	LBL_NO_DISPONIBLE("lbl_no_disponible",false),
	LBL_NO_APLICA("lbl_no_aplica",false),
	LBL_SIN_OBSERVACION("lbl_sin_observacion",false),
	LBL_FECHA_ACTUAL("lbl_fecha_actual"),
	IMP_PAGINA_PRUEBA("imp_pagina_prueba"),
	TLP_CAMPO_OBLIGATORIO("tlp_campo_obligatorio"),
	LBL_CAJERO("lbl_cajero"),
	LBL_MODO_OPERACION("lbl_modo_operacion"),
	LBL_VERSION_JAVA("lbl_version_java"),
	LBL_VER_CONSTRASENA("lbl_ver_constrasena"),
	LBL_TIPO_IMPRESION_TIRILLA("lbl_tipo_impresion_tirilla"),
	LBL_TIPO_IMPRESION_MEDIA_CARTA("lbl_tipo_impresion_media_carta"),
	LBL_CODIGO("lbl_codigo"),
	LBL_DESCRIPCION("lbl_descripcion"),
	LBL_SI("lbl_si"),
	LBL_NO("lbl_no"),
	LBL_VERSION_GIROS("lbl_version_giros"),
	
	//Nombres objetos negocio
	NMB_OBJ_NEG_FACTURA("nmb_obj_neg_factura"),
	NMB_OBJ_NEG_TIPO_OPERACION("nmb_obj_neg_tipo_operacion"),
	
	//Palabras claves de negocio {EnumFormatoPalabrasNegocio}
	//General
	PAL_NEG_NOMBRE_PROVEEDOR_SUPER_GIROS("pal_neg_nombre_proveedor_super_giros",false),
	PAL_NEG_SOCIEDAD_ANONIMA("pal_neg_sociedad_anonima",false),
	PAL_NEG_REFERENCIA("pal_neg_referencia",false),
	//Abreviatura Tipos Documento
	PAL_NEG_ABREVIATURA_TIPO_DOC_CC_SEGUIDO_DOC("pal_neg_abreviatura_tipo_doc_cc_seguido_doc",false),
	PAL_NEG_ABREVIATURA_TIPO_DOC_TI_SEGUIDO_DOC("pal_neg_abreviatura_tipo_doc_ti_seguido_doc",false),
	PAL_NEG_ABREVIATURA_TIPO_DOC_PA_SEGUIDO_DOC("pal_neg_abreviatura_tipo_doc_pa_seguido_doc",false),
	PAL_NEG_ABREVIATURA_TIPO_DOC_CE_SEGUIDO_DOC("pal_neg_abreviatura_tipo_doc_ce_seguido_doc",false),
	PAL_NEG_ABREVIATURA_TIPO_DOC_CEX_SEGUIDO_DOC("pal_neg_abreviatura_tipo_doc_cex_seguido_doc",false),
	PAL_NEG_ABREVIATURA_TIPO_DOC_NIT_SEGUIDO_DOC("pal_neg_abreviatura_tipo_doc_nit_seguido_doc",false),
	PAL_NEG_ABREVIATURA_TIPO_DOC_CC("pal_neg_abreviatura_tipo_doc_cc",false),
	PAL_NEG_ABREVIATURA_TIPO_DOC_TI("pal_neg_abreviatura_tipo_doc_ti",false),
	PAL_NEG_ABREVIATURA_TIPO_DOC_PA("pal_neg_abreviatura_tipo_doc_pa",false),
	PAL_NEG_ABREVIATURA_TIPO_DOC_CE("pal_neg_abreviatura_tipo_doc_ce",false),
	PAL_NEG_ABREVIATURA_TIPO_DOC_CEX("pal_neg_abreviatura_tipo_doc_cex",false),
	PAL_NEG_ABREVIATURA_TIPO_DOC_NIT("pal_neg_abreviatura_tipo_doc_nit",false),
	//Productos
	PAL_NEG_NOMBRE_PRODUCTO_SUPER_COMBO("pal_neg_nombre_producto_super_combo",false),
	//SuperCOMBO
	PAL_NEG_NOMBRE_SMS("pal_neg_nombre_sms",false),
	PAL_NEG_NOMBRE_PROTEGIRO("pal_neg_nombre_protegiro",false),
	
	//Barra de herramientas
	TLP_BTN_BH_CONFIRMAR("tlp_btn_bh_confirmar"),
	TLP_BTN_BH_IMPRIMIR("tlp_btn_bh_imprimir"),
	TLP_BTN_BH_CONSULTAR("tlp_btn_bh_consultar"),
	TLP_BTN_BH_SALIR("tlp_btn_bh_salir"),
	TLP_BTN_BH_VOLVER("tlp_btn_bh_volver"),
	TLP_BTN_BH_OPERACION_INUSUAL("tlp_btn_bh_operacion_inusual"),
	TLP_BTN_BH_ANULAR("tlp_btn_bh_anular"),
	TLP_BTN_BH_AYUDA("tlp_btn_bh_ayuda"),
	TLP_BTN_BH_LIMPIAR("tlp_btn_bh_limpiar"),
	
	//Ventanas alertas
	TTL_VENTANA_INFORMACION("ttl_ventana_informacion"),
	TTL_VENTANA_ERROR("ttl_ventana_error"),
	TTL_VENTANA_ADVERTENCIA("ttl_ventana_advertencia"),
	TTL_VENTANA_CONFIRMACION("ttl_ventana_confirmacion"),
	TTL_VENTANA_EMERGENTE("ttl_ventana_emergente"),
	
	//Tipos de transacciones {EnumTiposOperaciones}
	TTL_TIP_TRA_ENVIO_FACTURACION("ttl_tip_tra_envio_facturacion",false),
	TTL_TIP_TRA_ENVIO_FACTURACION_GIRO("ttl_tip_tra_envio_facturacion_giro",false),
	TTL_TIP_TRA_ENVIO_FACTURACION_SEGURO("ttl_tip_tra_envio_facturacion_seguro",false),
	TTL_TIP_TRA_ENVIO_FACTURACION_RECAUDO("ttl_tip_tra_envio_facturacion_recaudo",false),
	TTL_TIP_TRA_PAGO_FACTURACION("ttl_tip_tra_pago_facturacion",false),
	TTL_TIP_TRA_PAGO_FACTURACION_GIRO("ttl_tip_tra_pago_facturacion_giro",false),
	TTL_TIP_TRA_PAGO_FACTURACION_GIRO_EXTERNO("ttl_tip_tra_pago_facturacion_giro_externo",false),
	TTL_TIP_TRA_ENVIO_FACTURACION_GIRO_INTERNACIONAL("ttl_tip_tra_envio_facturacion_giro_internacional",false),
	TTL_TIP_TRA_PAGO_FACTURACION_GIRO_INTERNACIONAL("ttl_tip_tra_pago_facturacion_giro_internacional",false),
	TTL_TIP_TRA_PROTEGIRO_INTERNACIONAL("ttl_tip_tra_protegiro_internacional",false),
	TTL_TIP_TRA_ANULAR_PROTEGIRO_INTERNACIONAL("ttl_tip_tra_anular_protegiro_internacional",false),
	TTL_TIP_TRA_PAGO_FACTURACION_RECAUDO("ttl_tip_tra_pago_facturacion_recaudo",false),
	TTL_TIP_TRA_SOLICITUD("ttl_tip_tra_solicitud",false),
	TTL_TIP_TRA_SOLICITUD_CAMBIO_BENEFICIARIO("ttl_tip_tra_solicitud_cambio_beneficiario",false),
	TTL_TIP_TRA_SOLICITUD_ANULACION("ttl_tip_tra_solicitud_anulacion",false),
	TTL_TIP_TRA_SOLICITUD_ANULACION_GIRO("ttl_tip_tra_solicitud_anulacion_giro",false),
	TTL_TIP_TRA_SOLICITUD_ANULACION_SEGURO("ttl_tip_tra_solicitud_anulacion_seguro",false),
	TTL_TIP_TRA_SOLICITUD_ANULACION_RECAUDO("ttl_tip_tra_solicitud_anulacion_recaudo",false),
	TTL_TIP_TRA_AUTENTICAR("ttl_tip_tra_autenticar",false),
	
	//Tipos biometria caja {EnumTiposBiometriaCaja}
	TIP_BIO_CAJ_CENTRAL("tip_bio_caj_central"),
	TIP_BIO_CAJ_LOCAL("tip_bio_caj_local"),
	TIP_BIO_CAJ_MULTISERVICIO("tip_bio_caj_multiservicio"),
	
	//Lector 2D
	LBL_LECTOR_LECTURA("lbl_lector_lectura",false),
	LBL_LECTOR_IMAGEN("lbl_lector_imagen"),
	TTL_LECTOR_2D("ttl_Lector_2D"),
	
	//Servicios adicionales
	TTL_SRV_ADI_SCP_SERVICIOS_ADICIONALES("ttl_srv_adi_scp_servicios_adicionales"),
	//{EnumServiciosAdicionales}
	TTL_SRV_ADI_CLAVE_SEGURIDAD("ttl_srv_adi_clave_seguridad"),
	//{EnumTiposClaveSeguridad}
	TTL_SRV_ADI_CLAVE_SEGURIDAD_MANUAL("ttl_srv_adi_clave_seguridad_manual"),
	TTL_SRV_ADI_CLAVE_SEGURIDAD_AUTOMATICA("ttl_srv_adi_clave_seguridad_automatica"),
	TTL_SRV_ADI_CLAVE_SEGURIDAD_NO_GRACIAS("ttl_srv_adi_clave_seguridad_no_gracias"),
	
	//Datos Adicionales
	TTL_PNL_DAT_ADI_VENTANA("ttl_pnl_dat_adi_ventana"),
	TTL_PNL_DAT_ADI_GRILLA_DATOS_ADICIONALES_DATO("ttl_pnl_dat_adi_grilla_datos_adicionales_dato"),
	TTL_PNL_DAT_ADI_GRILLA_DATOS_ADICIONALES_VALOR("ttl_pnl_dat_adi_grilla_datos_adicionales_valor"),
	
	//parametros del sistema
	PS_TIPO_DATO_NUMERICO("ps_tipo_dato_numerico"),
	//Descripcion
	//Formatos de impresion
	DESC_PS_NOMBRE_FORMATO_IMPRESION_CAMBIO_BENEFICIARIO("desc_ps_nombre_formato_impresion_cambio_beneficiario",false),
	DESC_PS_NOMBRE_FORMATO_IMPRESION_ANULACION_GIRO("desc_ps_nombre_formato_impresion_anulacion_giro",false),
	DESC_PS_NOMBRE_FORMATO_IMPRESION_ANULACION_GIRO_AUTORIZADA("desc_ps_nombre_formato_impresion_anulacion_giro_autorizada",false),
	DESC_PS_NOMBRE_FORMATO_IMPRESION_ENVIO_GIRO_POSTAL("desc_ps_nombre_formato_impresion_envio_giro_postal",false),
	DESC_PS_NOMBRE_FORMATO_IMPRESION_PAGO_GIRO_POSTAL("desc_ps_nombre_formato_impresion_pago_giro_postal",false),
	DESC_PS_NOMBRE_FORMATO_PRE_IMPRESION_PAGO_GIRO_DOMICILIADO("desc_ps_nombre_formato_pre_impresion_pago_giro_domiciliado",false),
	DESC_PS_NOMBRE_FORMATO_IMPRESION_ANULACION_RECAUDO("desc_ps_nombre_formato_impresion_anulacion_recaudo",false),
	DESC_PS_NOMBRE_FORMATO_IMPRESION_ENVIO_RECAUDO("desc_ps_nombre_formato_impresion_envio_recaudo",false),
	DESC_PS_NOMBRE_FORMATO_IMPRESION_PAGO_RECAUDO("desc_ps_nombre_formato_impresion_pago_recaudo",false),
	DESC_PS_NOMBRE_FORMATO_IMPRESION_CIERRE_CAJA("desc_ps_nombre_formato_impresion_cierre_caja",false),
	DESC_PS_NOMBRE_FORMATO_IMPRESION_INGRESO_EGRESO("desc_ps_nombre_formato_impresion_ingreso_egreso",false),
	DESC_PS_NOMBRE_FORMATO_IMPRESION_ROE("desc_ps_nombre_formato_impresion_roe",false),
	DESC_PS_NOMBRE_FORMATO_IMPRESION_REIM_ULTIMA_FACTURA("desc_ps_nombre_formato_impresion_reim_ultima_factura",false),
	DESC_PS_NOMBRE_FORMATO_IMPRESION_SEGURO("desc_ps_nombre_formato_impresion_seguro",false),
	DESC_PS_NOMBRE_FORMATO_IMPRESION_SMS("desc_ps_nombre_formato_impresion_sms",false),
	DESC_PS_NOMBRE_FORMATO_IMPRESION_ENVIO_GIRO_INTERNACIONAL("desc_ps_nombre_formato_impresion_envio_giro_internacional",false),
	DESC_PS_NOMBRE_FORMATO_IMPRESION_PAGO_GIRO_INTERNACIONAL("desc_ps_nombre_formato_impresion_pago_giro_internacional",false),
	DESC_PS_NOMBRE_FORMATO_IMPRESION_SEGURO_INTERNACIONAL("desc_ps_nombre_formato_impresion_seguro_internacional",false),
	DESC_PS_NOMBRE_FORMATO_IMPRESION_SMS_INTERNACIONAL("desc_ps_nombre_formato_impresion_sms_internacional",false),
	DESC_PS_NOMBRE_FORMATO_IMPRESION_PQR("desc_ps_nombre_formato_impresion_pqr",false),
	DESC_PS_PAGINA_PRUEBA("desc_ps_pagina_prueba",false),
	//Conceptos
	DESC_PS_CODIGO_CONCEPTO_RECAUDO_X_EFECTIVO("desc_ps_codigo_concepto_recaudo_x_efectivo",false),
	DESC_PS_CODIGO_CONCEPTO_RECAUDO_X_TARJETAS("desc_ps_codigo_concepto_recaudo_x_tarjetas",false),
	DESC_PS_CODIGO_CONCEPTO_PAGO_RECAUDO("desc_ps_codigo_concepto_pago_recaudo",false),
	DESC_PS_CODIGO_CONCEPTO_ANULACION_RECAUDO("desc_ps_codigo_concepto_anulacion_recaudo",false),
	DESC_PS_ID_CONCEPTO_PAGO_GIRO("desc_ps_id_concepto_pago_giro",false),
	DESC_PS_ID_CONCEPTO_ENVIO_GIRO_INTERNACIONAL("desc_ps_id_concepto_envio_giro_internacional",false),
	DESC_PS_CODIGO_CONCEPTO_PAGO_GIRO_INTERNACIONAL("desc_ps_codigo_concepto_pago_giro_internacional",false),
	DESC_PS_ID_CONCEPTO_PROTEGIRO_INTERNACIONAL("desc_ps_id_concepto_protegiro_internacional",false),
	DESC_PS_CODIGO_CONCEPTO_ANULACION_PROTEGIRO_INTERNACIONAL("desc_ps_codigo_concepto_anulacion_protegiro_internacional",false),
	DESC_PS_ID_CONCEPTO_ANULACION_GIRO("desc_ps_id_concepto_anulacion_giro",false),
	DESC_PS_CODIGO_CONCEPTO_ANULACION_SEGURO("desc_ps_codigo_concepto_anulacion_seguro",false),
	DESC_PS_CODIGO_CONCEPTO_UTILIDAD_X_SEGURO("desc_ps_codigo_concepto_utilidad_x_seguro",false),
	DESC_PS_CODIGO_CONCEPTO_UTILIDAD_X_PAGO_GIRO("desc_ps_codigo_concepto_utilidad_x_pago_giro",false),
	DESC_PS_CODIGO_CONCEPTO_UTILIDAD_X_ENVIO_GIRO("desc_ps_codigo_concepto_utilidad_x_envio_giro",false),
	DESC_PS_CODIGO_CONCEPTO_UTILIDAD_X_RECAUDO("desc_ps_codigo_concepto_utilidad_x_recaudo",false),
	
	//Peticiones multiservicio {EnumPeticionesMultiservicio}
	//Biometria
	NOMB_PMS_SERVICIO_VALIDAR_TERCERO_BMS("nomb_pms_servicio_validar_tercero_bms",false),
	NOMB_PMS_SERVICIO_ENROLAR_HUELLA_BMS("nomb_pms_servicio_enrolar_huella_bms",false),
	NOMB_PMS_SERVICIO_SOLICITAR_HUELLA_BMS("nomb_pms_servicio_solicitar_huella_bms",false),
	NOMB_PMS_SERVICIO_TRANSMITIR_ARCHIVO_BMS("nomb_pms_servicio_transmitir_archivo_bms",false),
	NOMB_PMS_SERVICIO_AUTORIZAR_TERCERO_BMS("nomb_pms_servicio_autorizar_tercero_bms",false),
	
	//Reimpresiones
	TTL_RMP_VENTANA("ttl_rmp_ventana"),
	LBL_RMP_TIPO_REIMPRESION("lbl_rmp_tipo_reimpresion"),
	TTL_RMP_CMB_TIPO_REIMPRESION_X_PIN("ttl_rmp_cmb_tipo_reimpresion_x_pin"),
	TTL_RMP_CMB_TIPO_REIMPRESION_ULTIMA_TRANSACCION("ttl_rmp_cmb_tipo_reimpresion_ultima_transaccion"),
	TTL_RMP_CMB_TIPO_REIMPRESION_OTRAS("ttl_rmp_cmb_tipo_reimpresion_otras"),
	LBL_RMP_LISTA_REIMPRESIONES("lbl_rmp_lista_reimpresiones"),
	TTL_RMP_PNL_PARAMETROS("ttl_rmp_pnl_parametros"),
	TTL_RMP_GRILLA_PARAMETROS_DATO("ttl_rmp_grilla_parametros_dato"),
	TTL_RMP_GRILLA_PARAMETROS_VALOR("ttl_rmp_grilla_parametros_valor"),
	TTL_RMP_PARAMETROS("ttl_rmp_parametros"),
	TTL_RMP_PNL_RESULTADO("ttl_rmp_pnl_resultado"),
	TTL_RMP_GRILLA_RESULTADO_DATO("ttl_rmp_grilla_resultado_dato"),
	TTL_RMP_GRILLA_RESULTADO_VALOR("ttl_rmp_grilla_resultado_valor"),
	//X Pin
	TTL_RXP_ENVIO_GIRO("ttl_rxp_envio_giro"),
	TTL_RXP_PAGO_GIRO("ttl_rxp_pago_giro"),
	TTL_RXP_INGRESO("ttl_rxp_ingreso"),
	TTL_RXP_EGRESO("ttl_rxp_egreso"),
	TTL_RXP_ENVIO_RECAUDO("ttl_rxp_envio_recaudo"),
	TTL_RXP_ENVIO_REMESA("ttl_rxp_envio_remesa"),//Remesa Internacional
	TTL_RXP_PAGO_REMESA("ttl_rxp_pago_remesa"),//Pago Internacional
	//Ultima Transaccion
	TTL_RUT_CIERRE_CAJA("ttl_rut_cierre_caja"),
	TTL_RUT_SEGURO("ttl_rut_seguro"),
	TTL_RUT_SMS("ttl_rut_sms"),
	TTL_RUT_ENVIO_GIRO("ttl_rut_envio_giro"),
	TTL_RUT_PAGO_GIRO("ttl_rut_pago_giro"),
	TTL_RUT_INGRESO("ttl_rut_ingreso"),
	TTL_RUT_EGRESO("ttl_rut_egreso"),
	TTL_RUT_ARQUEO("ttl_rut_arqueo"),
	TTL_RUT_PRUEBA("ttl_rut_prueba"),
	TTL_RUT_ENVIO_REMESA("ttl_rut_envio_remesa"),//Remesa Internacional
	TTL_RUT_PAGO_REMESA("ttl_rut_pago_remesa"),//Pago Internacional
	//OTROS
	TTL_OTR_PQR("ttl_otr_pqr",false),
	TTL_OTR_DUPLICADO_PQR("ttl_otr_duplicado_pqr",false),

	//Datos Adicionales
	TTL_DAT_ADI_VENTANA("ttl_dat_adi_ventana"),//Solicitud de datos adicionales
	//Medio pago: Tarjeta
	TTL_DAT_ADI_NOMBRE_BANCO("ttl_dat_adi_nombre_banco"),
	TTL_DAT_ADI_CODIGO_APROBACION("ttl_dat_adi_codigo_aprobacion"),
	TTL_DAT_ADI_TIPO_TARJETA("ttl_dat_adi_tipo_tarjeta"),
	VLR_DAT_ADI_TIPO_TARJETA("vlr_dat_adi_tipo_tarjeta",","),
	//Transaccion
	TTL_DAT_ADI_PIN("ttl_dat_adi_pin"),
	
	//Mensaje Alerta
	BTN_MSG_ALRT_ACEPTAR("btn_msg_alrt_aceptar"),
	BTN_MSG_ALRT_CANCELAR("btn_msg_alrt_cancelar"),
	
	//Panel Encabezado: empresa - agencia - caja
	LBL_PNL_ENC_EMPRESA("lbl_pnl_enc_empresa"),
	LBL_PNL_ENC_AGENCIA("lbl_pnl_enc_agencia"),
	LBL_PNL_ENC_CAJA("lbl_pnl_enc_caja"),
	TLT_PNL_ENC_CAJA_COD("tlt_pnl_enc_caja_cod"),
	TLT_PNL_ENC_CAJA_DESC("tlt_pnl_enc_caja_desc"),
	TLT_PNL_ENC_AGENCIA_COD("tlt_pnl_enc_agencia_cod"),
	TLT_PNL_ENC_AGENCIA_DESC("tlt_pnl_enc_agencia_desc"),
	TLT_PNL_ENC_EMPRESA_COD("tlt_pnl_enc_empresa_cod"),
	TLT_PNL_ENC_EMPRESA_DESC("tlt_pnl_enc_empresa_desc"),
	
	//Panel Factura
	LBL_PNL_FACT_DOCUMENTO("lbl_pnl_fact_documento"),
	LBL_PNL_FACT_NUMERO("lbl_pnl_fact_numero"),
	TLT_PNL_FACT_PRODUCTO("tlt_pnl_fact_producto"),
	TLT_PNL_FACT_DOCUMENTO("tlt_pnl_fact_documento"),
	TLT_PNL_FACT_NUMERO("tlt_pnl_fact_numero"),
	
	//Panel Territorio: Pais - Departamento - Municipio - Zona
	LBL_PNL_TERR_TTL_ETIQUETAS("lbl_pnl_terr_ttl_etiquetas"),
	LBL_PNL_TERR_TTL_COMBOS("lbl_pnl_terr_ttl_combos"),
	LBL_PNL_TERR_PAIS("lbl_pnl_terr_pais"),
	LBL_PNL_TERR_DEPARTAMENTO("lbl_pnl_terr_departamento"),
	LBL_PNL_TERR_MUNICIPIO("lbl_pnl_terr_municipio"),
	LBL_PNL_TERR_ZONA("lbl_pnl_terr_zona"),
	LBL_PNL_TERR_AGENCIA("lbl_pnl_terr_agencia"),
	
	//Panel Tercero: tipo documento, documento, descripcion (nombre completo) y boton para mantenimiento
	LBL_PNL_TERC_TERCERO("lbl_pnl_terc_tercero"),
	TLT_PNL_TERC_IDENTIFICACION("tlt_pnl_terc_identificacion"),
	TLT_PNL_TERC_NOMBRE("tlt_pnl_terc_nombre"),
	TLT_PNL_TERC_MANTENIMIENTO("tlt_pnl_terc_mantenimiento"),
	TLT_PNL_TERC_TIPO_DOCUMENTO("tlt_pnl_terc_tipo_documento"),
	
	//Mantenimiento Tercero
	TTL_MNT_TERC_VENTANA("ttl_mnt_terc_ventana"),
	LBL_MNT_TERC_DOCUMENTO("lbl_mnt_terc_documento"),
	LBL_MNT_TERC_TIPO_PERSONA("lbl_mnt_terc_tipo_persona"),
	LBL_MNT_TERC_FECHA_NACIMIENTO("lbl_mnt_terc_fecha_nacimiento"),
	LBL_MNT_TERC_FECHA_ENTRADA_PAIS("lbl_mnt_terc_fecha_entrada_pais"),
	LBL_MNT_TERC_FECHA_VENCIMIENTO("lbl_mnt_terc_fecha_vencimiento"),
	TTL_MNT_TERC_PNL_EXPEDICION("ttl_mnt_terc_pnl_expedicion"),
	LBL_MNT_TERC_FECHA_EXPEDICION("lbl_mnt_terc_fecha_expedicion"),
	LBL_MNT_TERC_PNL_TERR_DEPARTAMENTO_EXPEDICION("lbl_mnt_terc_pnl_terr_departamento_expedicion"),
	LBL_MNT_TERC_PRIMER_APELLIDO("lbl_mnt_terc_primer_apellido"),
	LBL_MNT_TERC_SEGUNDO_APELLIDO("lbl_mnt_terc_segundo_apellido"),
	LBL_MNT_TERC_NOMBRES("lbl_mnt_terc_nombres"),
	LBL_MNT_TERC_TELEFONO("lbl_mnt_terc_telefono"),
	LBL_MNT_TERC_CELULAR("lbl_mnt_terc_celular"),
	LBL_MNT_TERC_CORREO_ELECTRONICO("lbl_mnt_terc_correo_electronico"),
	LBL_MNT_TERC_ACTIVIDAD_ECONOMICA("lbl_mnt_terc_actividad_economica"),
	CHK_MNT_TERC_AUTO_RETENEDOR("chk_mnt_terc_auto_retenedor"),
	TLT_MNT_TERC_TIPO_DOCUMENTO("tlt_mnt_terc_tipo_documento"),
	LBL_MNT_TERC_TERCERO_PEPS("lbl_mnt_terc_tercero_peps"),
	
	//Mantenimiento Tercero Internacional
	TTL_MNT_TERC_INT_VENTANA("ttl_mnt_terc_int_ventana"),
	TTL_MNT_TERC_INT_PNL_DOCUMENTO("ttl_mnt_terc_int_pnl_documento"),
	TTL_MNT_TERC_INT_PNL_CONTACTO("ttl_mnt_terc_int_pnl_contacto"),
	LBL_MNT_TERC_INT_DOCUMENTO("lbl_mnt_terc_int_documento"),
	LBL_MNT_TERC_INT_TIPO_DOCUMENTO("lbl_mnt_terc_int_tipo_documento"),
	LBL_MNT_TERC_INT_NOMBRES("lbl_mnt_terc_int_nombres"),
	LBL_MNT_TERC_INT_NUMERO_DOCUMENTO("lbl_mnt_terc_int_numero_documento"),
	TXT_MNT_TERC_INT_PRIMER_NOMBRE("txt_mnt_terc_int_primer_nombre"),
	TXT_MNT_TERC_INT_SEGUNDO_NOMBRE("txt_mnt_terc_int_segundo_nombre"),
	LBL_MNT_TERC_INT_APELLIDOS("lbl_mnt_terc_int_apellidos"),
	TXT_MNT_TERC_INT_PRIMER_APELLIDO("txt_mnt_terc_int_primer_apellido"),
	TXT_MNT_TERC_INT_SEGUNDO_APELLIDO("txt_mnt_terc_int_segundo_apellido"),
	TTL_MNT_TERC_INT_PNL_NACIMIENTO("ttl_mnt_terc_int_pnl_nacimiento"),
	LBL_MNT_TERC_INT_FECHA_NACIMIENTO("lbl_mnt_terc_int_fecha_nacimiento"),
	DTC_MNT_TERC_INT_FECHA_NACIMIENTO("dtc_mnt_terc_int_fecha_nacimiento"),
	LBL_MNT_TERC_INT_CIUDAD_NACIMIENTO("lbl_mnt_terc_int_ciudad_nacimiento"),
	TXT_MNT_TERC_INT_CIUDAD_NACIMIENTO("txt_mnt_terc_int_ciudad_nacimiento"),
	LBL_MNT_TERC_INT_TELEFONO_FIJO_CELULAR("lbl_mnt_terc_int_telefono_fijo_celular"),
	TTL_MNT_TERC_INT_PNL_RESIDENCIA("ttl_mnt_terc_int_pnl_residencia"),
	CMB_MNT_TERC_INT_PAIS_RESIDENCIA("cmb_mnt_terc_int_pais_residencia"),
	CMB_MNT_TERC_INT_DEPARTAMENTO_RESIDENCIA("cmb_mnt_terc_int_departamento_residencia"),
	CMB_MNT_TERC_INT_CIUDAD_RESIDENCIA("cmb_mnt_terc_int_ciudad_residencia"),
	TXT_MNT_TERC_INT_DIRECCION_RESIDENCIA("txt_mnt_terc_int_direccion_residencia"),
	TTL_MNT_TERC_INT_PNL_DATO_SOC_ECONO("ttl_mnt_terc_int_pnl_dato_soc_econo"),
	LBL_MNT_TERC_INT_VLR_INGRESO_MENSUAL("lbl_mnt_terc_int_vlr_ingreso_mensual"),
	LBL_MNT_TERC_INT_VLR_EGRESO_MENSUAL_ACTIVOS("lbl_mnt_terc_int_vlr_egreso_mensual_activos"),
	LBL_MNT_TERC_INT_VLR_ACTIVOS("lbl_mnt_terc_int_vlr_activos"),
	LBL_MNT_TERC_INT_VLR_PASIVOS("lbl_mnt_terc_int_vlr_pasivos"),
	LBL_MNT_TERC_INT_ACTV_ECONOMICAS("lbl_mnt_terc_int_actv_economicas"),
	LBL_MNT_TERC_INT_PROFESION("lbl_mnt_terc_int_profesion"),
	BTN_MNT_TERC_INT_EMPRESA_SOC_ECONO("btn_mnt_terc_int_empresa_soc_econo"),
	LBL_MNT_TERC_INT_OPER_MONEDA_EXTRANJERA("lbl_mnt_terc_int_oper_moneda_extranjera"),
	LBL_MNT_TERC_INT_VALOR_INGRESO("lbl_mnt_terc_int_valor_ingreso"),
	LBL_MNT_TERC_INT_MONEDA_EXTRANJERA("lbl_mnt_terc_int_moneda_extranjera"),
	LBL_MNT_TERC_INT_ENTIDAD_EXTRANJERA("lbl_mnt_terc_int_entidad_extranjera"),
	LBL_MNT_TERC_INT_NUMERO_PRODUCTO_EXT("lbl_mnt_terc_int_numero_producto_ext"),
	TTL_MNT_TERC_INT_PNL_EXPEDICION("ttl_mnt_terc_int_pnl_expedicion"),
	LBL_MNT_TERC_INT_FECHA_EXPEDICION("lbl_mnt_terc_int_fecha_expedicion"),
	DTC_MNT_TERC_INT_FECHA_EXPEDICION("dtc_mnt_terc_int_fecha_expedicion"),
	LBL_MNT_TERC_INT_CIUDAD_EXPEDICION("lbl_mnt_terc_int_ciudad_expedicion"),
	TXT_MNT_TERC_INT_CIUDAD_EXPEDICION("txt_mnt_terc_int_ciudad_expedicion"),
	TTL_MNT_TERC_INT_PNL_DATOS_COMPLEMENTARIOS("ttl_mnt_terc_int_pnl_datos_complementarios"),
	LBL_MNT_TERC_INT_PEPS("lbl_mnt_terc_int_fecha_peps",false),
	BTN_MNT_TERC_INT_VER_PEPS("btn_mnt_terc_int_ver_peps",false),
	LBL_MNT_TERC_INT_VLR_OTROS_INGRESOS("lbl_mnt_terc_int_vlr_otros_ingresos"),
	LBL_MNT_TERC_INT_DETALLE_OTROS_INGRESOS("lbl_mnt_terc_int_detalle_otros_ingresos"),
	TTL_MNT_TERC_INT_PNL_DATOS_EMPRESA_DATADD("ttl_mnt_terc_int_pnl_datos_empresa_datadd"),
	LBL_MNT_TERC_INT_NOMBRE_EMPRESA_DATADD("lbl_mnt_terc_int_nombre_empresa_datadd"),
	LBL_MNT_TERC_INT_DIRECCION_EMPRESA_DATADD("lbl_mnt_terc_int_direccion_empresa_datadd"),
	LBL_MNT_TERC_INT_TELEFONO_EMPRESA_DATADD("lbl_mnt_terc_int_telefono_empresa_datadd"),
	LBL_MNT_TERC_INT_CIUDAD_EMPRESA_DATADD("lbl_mnt_terc_int_ciudad_empresa_datadd"),
	LBL_MNT_TERC_INT_CARGO_EMPRESA_DATADD("lbl_mnt_terc_int_cargo_empresa_datadd"),
	LBL_MNT_TERC_INT_CORREO_ELECTRONICO("lbl_mnt_terc_int_correo_electronico"),
	TXT_MNT_TERC_INT_CORREO_ELECTRONICO("txt_mnt_terc_int_correo_electronico"),
	
	//Panel Direccion
	LBL_PNL_DIR_ETIQUETA("lbl_pnl_dir_etiqueta"),
	TLT_PNL_DIR_BTN_MTO("tlt_pnl_dir_btn_mto"),
	TLT_PNL_DIR_BTN_LIMPIAR("tlt_pnl_dir_btn_limpiar"),
	
	//Diligenciar Direccion
	TTL_DIR_VENTANA("ttl_dir_ventana"),
	LBL_DIR_CLASES_VIA("lbl_dir_clases_via"),
	TTL_DIR_PNL_DIRECCION_TRADICIONAL("ttl_dir_pnl_direccion_tradicional"),
	LBL_DIR_ESPECIFICACIONES_DIRECCION_TRADICIONAL("lbl_dir_especificaciones_direccion_tradicional"),
	LBL_DIR_SEPARADOR_INTERSECCION_VIA("lbl_dir_separador_interseccion_via"),
	LBL_DIR_SEPARADOR_LUGAR_INTERSECCION("lbl_dir_separador_lugar_interseccion"),
	TTL_DIR_PNL_UBICACION("ttl_dir_pnl_ubicacion"),
	LBL_DIR_ZONAS_UBICACION("lbl_dir_zonas_ubicacion"),
	TTL_DIR_PNL_LUGAR("ttl_dir_pnl_lugar"),
	LBL_DIR_CARACTERISTICAS_LUGAR("lbl_dir_caracteristicas_lugar"),
	LBL_DIR_ESPECIFICACION_LUGAR("lbl_dir_especificacion_lugar"),
	LBL_DIR_NOMBRE_BARRIO("lbl_dir_nombre_barrio"),
	LBL_DIR_ESTRATOS_BARRIO("lbl_dir_estratos_barrio"),
	LBL_DIR_ESPECIFICACION_ABIERTA("lbl_dir_especificacion_abierta"),
	TLT_DIR_VIA("tlt_dir_via"),
	TLT_DIR_INTERSECCION("tlt_dir_interseccion"),
	TLT_DIR_LUGAR("tlt_dir_lugar"),
	LBL_DIR_DEPARTAMENTO("lbl_dir_departamento"),
	LBL_DIR_MUNICIPIO("lbl_dir_municipio"),
	TTL_DIR_PNL_BARRIO("ttl_dir_pnl_barrio"),
	TTL_DIR_PNL_DEPARTAMENTO("ttl_dir_pnl_departamento"),
	TTL_DIR_PNL_MUNICIPIO("ttl_dir_pnl_municipio"),
	TTL_DIR_PNL_CODIGO_POSTAL("ttl_dir_pnl_codigo_postal"),
	LBL_DIR_CODIGO("lbl_dir_codigo"),
	
	
	
	//Autenticacion
	TTL_AUT_VENTANA("ttl_aut_ventana"),
	LBL_AUT_USUARIO("lbl_aut_usuario"),
	LBL_AUT_CONTRASENA("lbl_aut_contrasena"),
	BTN_AUT_INGRESAR("btn_aut_ingresar"),
	BTN_AUT_SALIR("btn_aut_salir"),
	LBL_AUT_CODIGO_VALIDACION("lbl_aut_codigo_validacion"),
	LBL_AUT_BARRA_PROGRESO_VALIDACION_ENTRADA("lbl_aut_barra_progreso_validacion_entrada"),
	LBL_AUT_BARRA_PROGRESO_VALIDA_BIOMETRIA("lbl_aut_barra_progreso_valida_biometria"),
	LBL_AUT_BARRA_PROGRESO_SESSION_BIOMETRIA("lbl_aut_barra_progreso_session_biometria"),
	LBL_AUT_BARRA_PROGRESO_SESSION("lbl_aut_barra_progreso_session"),
	LBL_AUT_BARRA_PROGRESO_VALIDA_SUPER_COMBO("lbl_aut_barra_progreso_valida_super_combo"),
	LBL_AUT_BARRA_PROGRESO_VALIDA_CAJA("lbl_aut_barra_progreso_valida_caja"),
	LBL_AUT_BARRA_PROGRESO_SESSION_EXITOSA("lbl_aut_barra_progreso_session_exitosa"),
	
	//Cambio de Contrasena
	TTL_CMB_CNTRSN_VENTANA("ttl_cmb_cntrsn_ventana"),
	LBL_CMB_CNTRSN_USUARIO("lbl_cmb_cntrsn_usuario"),
	LBL_CMB_CNTRSN_CONTRASENA_ANTERIOR("lbl_cmb_cntrsn_clave_anterior"),
	LBL_CMB_CNTRSN_CONTRASENA_NUEVA("lbl_cmb_cntrsn_clave_nueva"),
	LBL_CMB_CNTRSN_CONFIRMA_CONTRASENA("lbl_cmb_cntrsn_confirma_clave"),
	
	//Apertura Caja
	TTL_APC_VENTANA("ttl_apc_ventana"),
	TTL_APC_GRILLA_MEDIO_PAGO("ttl_apc_grilla_medio_pago"),
	TTL_APC_GRILLA_MONEDA("ttl_apc_grilla_moneda"),
	TTL_APC_GRILLA_SALDO_INICIAL("ttl_apc_grilla_saldo_inicial"),
	
	//Cierre Caja
	TTL_CC_VENTANA("ttl_cc_ventana"),//Cierre de caja
	TTL_CC_GRILLA_PRODUCTO("ttl_cc_grilla_producto"),//Producto
	TTL_CC_GRILLA_MEDIO_PAGO("ttl_cc_grilla_medio_pago"),//Medio de pago
	TTL_CC_GRILLA_MONEDA("ttl_cc_grilla_moneda"),//Moneda
	TTL_CC_GRILLA_SALDO_INICIAL("ttl_cc_grilla_saldo_inicial"),//Saldo inicial
	TTL_CC_GRILLA_INGRESOS("ttl_cc_grilla_ingresos"),//Ingresos
	TTL_CC_GRILLA_EGRESOS("ttl_cc_grilla_egresos"),//Egresos
	TTL_CC_GRILLA_TRASLADOS("ttl_cc_grilla_traslados"),//Traslados
	TTL_CC_GRILLA_SALDO_FINAL("ttl_cc_grilla_saldo_final"),//Saldo final
	
	//Arqueo Caja
	TTL_AQC_VENTANA("ttl_aqc_ventana"),//Arqueo de caja
	TTL_AQC_PNL_BILLETES("ttl_aqc_pnl_billetes"),//Billetes
	LBL_AQC_LISTA_BILLETES("lbl_aqc_lista_billetes"),//Denominaci�n
	LBL_AQC_CANTIDAD_MONTO_BILLETES("lbl_aqc_cantidad_monto_billetes"),//Cantidad
	BTN_AQC_INGRESAR_CANT_MONTO_BILLETES("btn_aqc_ingresar_cant_monto_billetes"),//Ingresar
	BTN_AQC_ELIMINAR_REGISTRO_BILLETES("btn_aqc_eliminar_registro_billetes"),//Borrar
	TTL_AQC_GRILLA_BILLETES_DENOMINACION("ttl_aqc_grilla_billetes_denominacion"),//Denominaci�n
	TTL_AQC_GRILLA_BILLETES_CANTIDAD("ttl_aqc_grilla_billetes_cantidad"),//Cantidad
	TTL_AQC_GRILLA_BILLETES_TOTAL("ttl_aqc_grilla_billetes_total"),//Total
	TTL_AQC_PNL_MONEDAS("ttl_aqc_pnl_monedas"),//Monedas
	TTL_AQC_GRILLA_MONEDAS_DENOMINACION("ttl_aqc_grilla_monedas_denominacion"),//Denominaci�n
	TTL_AQC_GRILLA_MONEDAS_CANTIDAD("ttl_aqc_grilla_monedas_cantidad"),//Cantidad
	TTL_AQC_GRILLA_MONEDAS_TOTAL("ttl_aqc_grilla_monedas_total"),//Total
	LBL_AQC_LISTA_MONEDAS("lbl_aqc_lista_monedas"),//Denominaci�n
	LBL_AQC_CANTIDAD_MONTO_MONEDAS("lbl_aqc_cantidad_monto_monedas"),//Cantidad
	BTN_AQC_INGRESAR_CANT_MONTO_MONEDAS("btn_aqc_ingresar_cant_monto_monedas"),//Ingresar
	BTN_AQC_ELIMINAR_REGISTRO_MONEDAS("btn_aqc_eliminar_registro_monedas"),//Borrar
	TTL_AQC_PNL_CHEQUES("ttl_aqc_pnl_cheques"),//Cheques
	TTL_AQC_GRILLA_CHEQUES_BANCO("ttl_aqc_grilla_cheques_banco"),//Banco
	TTL_AQC_GRILLA_CHEQUES_NUMERO("ttl_aqc_grilla_cheques_numero"),//No. Cheque
	TTL_AQC_GRILLA_CHEQUES_GIRADOR("ttl_aqc_grilla_cheques_girador"),//Girador
	TTL_AQC_GRILLA_CHEQUES_VALOR("ttl_aqc_grilla_cheques_valor"),//Valor
	LBL_AQC_LISTA_CHEQUES("lbl_aqc_lista_cheques"),//Cheques
	LBL_AQC_VALOR_CHEQUE("lbl_aqc_valor_cheque"),//Valor
	BTN_AQC_INGRESAR_CHEQUE("btn_aqc_ingresar_cheque"),//Ingresar
	BTN_AQC_ELIMINAR_REGISTRO_CHEQUES("btn_aqc_eliminar_registro_cheques"),//Borrar
	TTL_AQC_PNL_VALES("ttl_aqc_pnl_vales"),//Vales
	TTL_AQC_GRILLA_VALES_FECHA("ttl_aqc_grilla_vales_fecha"),//Fecha
	TTL_AQC_GRILLA_VALES_NUMERO("ttl_aqc_grilla_vales_numero"),//No. Vale
	TTL_AQC_GRILLA_VALES_CONCEPTO("ttl_aqc_grilla_vales_concepto"),//Concepto
	TTL_AQC_GRILLA_VALES_VALOR("ttl_aqc_grilla_vales_valor"),//Valor
	BTN_AQC_INGRESAR_VALE("btn_aqc_ingresar_vale"),//Ingresar
	BTN_AQC_ELIMINAR_REGISTRO_VALES("btn_aqc_eliminar_registro_vales"),//Borrar
	LBL_AQC_VALOR_VALE("lbl_aqc_valor_vale"),//Valor
	LBL_AQC_LISTA_VALES("lbl_aqc_lista_vales"),//Vales
	LBL_AQC_FECHA_CHEQUE("lbl_aqc_fecha_cheque"),//Fecha
	LBL_AQC_BANCO_CHEQUE("lbl_aqc_banco_cheque"),//Banco
	LBL_AQC_NUMERO_CHEQUE("lbl_aqc_numero_cheque"),//No.Cheque
	LBL_AQC_GIRADOR_CHEQUE("lbl_aqc_girador_cheque"),//Girador
	LBL_AQC_FECHA_VALE("lbl_aqc_fecha_vale"),//Fecha
	LBL_AQC_NUMERO_VALE("lbl_aqc_numero_vale"),//No. Vale
	LBL_AQC_CONCEPTO_VALE("lbl_aqc_concepto_vale"),//Concepto
	LBL_AQC_NOTAS("lbl_aqc_notas"),//Notas
	TTL_AQC_PNL_CUADRE_CAJA("ttl_aqc_pnl_cuadre_caja"),//Cuadre de caja
	LBL_AQC_TOTAL_CAJA("lbl_aqc_total_caja"),//Total caja
	LBL_AQC_EN_ARQUEO("lbl_aqc_en_arqueo"),//En arqueo
	LBL_AQC_TOTAL_DIFERENCIA_FALTANTE("lbl_aqc_total_diferencia_faltante"),//Falta
	LBL_AQC_TOTAL_DIFERENCIA_SOBRANTE("lbl_aqc_total_diferencia_sobrante"),//Sobra
	LBL_AQC_TOTAL_DIFERENCIA_EXACTA("lbl_aqc_total_diferencia_exacta"),//Exacto
	//TTL_AQC_TOTAL_X_GRILLA("ttl_aqc_total_x_grilla"),//Total
	LBL_AQC_TOTAL_X_BILLETES("lbl_aqc_total_x_billetes"),//Total
	LBL_AQC_TOTAL_X_MONEDAS("lbl_aqc_total_x_monedas"),//Total
	LBL_AQC_TOTAL_X_CHEQUES("lbl_aqc_total_x_cheques"),//Total
	LBL_AQC_TOTAL_X_VALES("lbl_aqc_total_x_vales"),//Total
	
	//Panel Busqueda
	TTL_BUS_VENTANA("ttl_bus_ventana"),
	LBL_BUS_BUSQUEDA_POR("lbl_bus_busqueda_por"),
	LBL_BUS_TIPOS_IDENTIFICACION("lbl_bus_tipos_identificacion"),
	LBL_BUS_IDENTIFICACION("lbl_bus_identificacion"),
	LBL_BUS_REFERENCIA("lbl_bus_referencia"),
	CHK_BUS_DESTINATARIO("chk_bus_destinatario"),
	CHK_BUS_REMITENTE("chk_bus_remitente"),
	DTC_BUS_FECHA_FIN("dtc_bus_fecha_fin"),
	DTC_BUS_FECHA_INI("dtc_bus_fecha_ini"),
	CHK_BUS_EXTERNO("chk_bus_externo"),
	LBL_BUS_ITEM_BUSQUEDA_POR_DOCUMENTO("lbl_bus_item_busqueda_por_documento"),
	LBL_BUS_ITEM_BUSQUEDA_POR_PIN("lbl_bus_item_busqueda_por_pin"),
	TLT_BUS_TIPO_DOCUMENTO("tlt_bus_tipo_documento"),
	
	//Ayuda
	TTL_AYU_VENTANA("ttl_ayu_ventana"),
	TTL_AYU_PNL_OPERACIONES("ttl_ayu_pnl_operaciones"),
	TTL_AYU_PNL_CONTROL_AYUDAS("ttl_ayu_pnl_control_ayudas"),
	LBL_AYU_MENSAJE_AYUDA_VACIA("lbl_ayu_mensaje_ayuda_vacia"),
	BTN_AYU_ATRAS("btn_ayu_atras"),
	BTN_AYU_ADELANTE("btn_ayu_adelante"),
	//RMV
	//Ayuda SuperCombo
	TTL_AYU_SCB_OPERACION_SUPER_COMBO("ttl_ayu_scb_operacion_super_combo"),
	LBL_AYU_SCB_COMI_CAJERO_TITULO("lbl_ayu_scb_comi_cajero_titulo",false),
	LBL_AYU_SCB_COMI_CAJERO_RESUMEN("lbl_ayu_scb_comi_cajero_resumen",false), 
	LBL_AYU_SCB_CAPTAR_CLIENTE_TITULO("lbl_ayu_scb_captar_cliente_titulo"),
	LBL_AYU_SCB_CAPTAR_CLIENTE_DIGAME("lbl_ayu_scb_captar_cliente_digame",false),
	LBL_AYU_SCB_CAPTAR_CLIENTE_PREGUNTELE("lbl_ayu_scb_captar_cliente_preguntele"),
	LBL_AYU_SCB_CAPTAR_CLIENTE_PESITOS("lbl_ayu_scb_captar_cliente_pesitos", false),
	LBL_AYU_SCB_CAPTAR_CLIENTE_DESEA("lbl_ayu_scb_captar_cliente_desea"),
	LBL_AYU_SCB_CAPTAR_CLIENTE_DEPENDIENDO("lbl_ayu_scb_captar_cliente_dependiendo"),
	LBL_AYU_SCB_VAL_TELEFONO_TITULO("lbl_ayu_scb_val_telefono_titulo"),
	LBL_AYU_SCB_VAL_TELEFONO_VALIDE("lbl_ayu_scb_val_telefono_valide"),
	LBL_AYU_SCB_VAL_TELEFONO_MENSAJES("lbl_ayu_scb_val_telefono_mensajes"),
	LBL_AYU_SCB_VAL_TELEFONO_TEL_REM("lbl_ayu_scb_val_telefono_tel_rem"),
	LBL_AYU_SCB_VAL_TELEFONO_TEL_DES("lbl_ayu_scb_val_telefono_tel_des"),
	LBL_AYU_SCB_IMPRESIONES_FINALICE("lbl_ayu_scb_impresiones_finalice"),
	BTN_AYU_SCB_IMPRESIONES_ACEPTAR("btn_ayu_scb_impresiones_aceptar"),
	LBL_AYU_SCB_IMPRESIONES_IMPRIMEN("lbl_ayu_scb_impresiones_imprimen"),
	LBL_AYU_SCB_TELEFONOS_LINEAS("lbl_ayu_scb_telefonos_lineas", false),
	LBL_AYU_SCB_RECUERDE_TITULO("lbl_ayu_scb_recuerde_titulo"),
	LBL_AYU_SCB_RECUERDE_ANULA("lbl_ayu_scb_recuerde_anula"),
	//--
	
	//Consulta Giros Nacional
	TTL_CGN_GRILLA_GIROS_REFERENCIA("ttl_cgn_grilla_giros_referencia"),
	TTL_CGN_GRILLA_GIROS_VALOR("ttl_cgn_grilla_giros_valor"),
	TTL_CGN_GRILLA_GIROS_ID_TERCERO_DESTINO("ttl_cgn_grilla_giros_id_tercero_destino"),
	TTL_CGN_GRILLA_GIROS_NOMBRES_TERCERO_DESTINO("ttl_cgn_grilla_giros_nombres_tercero_destino"),
	TTL_CGN_GRILLA_GIROS_APELLIDOS_TERCERO_DESTINO("ttl_cgn_grilla_giros_apellidos_tercero_destino"),
	TTL_CGN_GRILLA_GIROS_NOMBRE_AGENCIA_ORIGEN("ttl_cgn_grilla_giros_nombre_agencia_origen"),
	TTL_CGN_GRILLA_GIROS_ID_TERCERO_ORIGEN("ttl_cgn_grilla_giros_id_tercero_origen"),
	TTL_CGN_GRILLA_GIROS_NOMBRES_TERCERO_ORIGEN("ttl_cgn_grilla_giros_nombres_tercero_origen"),
	TTL_CGN_GRILLA_GIROS_APELLIDOS_TERCERO_ORIGEN("ttl_cgn_grilla_giros_apellidos_tercero_origen"),
	TTL_CGN_GRILLA_GIROS_DOMICILIO("ttl_cgn_grilla_giros_domicilio"),
	TTL_CGN_GRILLA_GIROS_NOTAS("ttl_cgn_grilla_giros_notas"),
	TTL_CGN_GRILLA_GIROS_ESTADO("ttl_cgn_grilla_giros_estado"),
	
	
	//Pago Giro
	TTL_PG_VENTANA("ttl_pg_ventana"),
	LBL_PG_REFERENCIA("lbl_pg_referencia"),
	LBL_PG_TTL_PNL_TERR_AGE_PAGO("lbl_pg_ttl_pnl_terr_age_pago"),
	LBL_PG_TTL_PNL_TERR_AGE_ORIGEN("lbl_pg_ttl_pnl_terr_age_origen"),
	LBL_PG_TTL_PNL_TERR_AGE_DESTINO("lbl_pg_ttl_pnl_terr_age_destino"),
	LBL_PG_TTL_PNL_TERC_ORIGEN("lbl_pg_ttl_pnl_terc_origen"),
	LBL_PG_TTL_PNL_TERC_DESTINO("lbl_pg_ttl_pnl_terc_destino"),
	LBL_PG_TTL_PNL_TERC_APODERADO("lbl_pg_ttl_pnl_terc_apoderado"),
	LBL_PG_CONCEPTOS("lbl_pg_conceptos"),
	TTL_PG_GRILLA_CONCEPTOS_CODIGO("ttl_pg_grilla_conceptos_codigo"),
	TTL_PG_GRILLA_CONCEPTOS_CONCEPTO("ttl_pg_grilla_conceptos_concepto"),
	TTL_PG_GRILLA_CONCEPTOS_VALOR("ttl_pg_grilla_conceptos_valor"),
	LBL_PG_NUMERO_ITEMS("lbl_pg_numero_items"),
	LBL_PG_TOTAL_X_ITEMS("lbl_pg_total_x_items"),
	LBL_PG_PROMOCIONES("lbl_pg_promociones"),
	TTL_PG_GRILLA_PROMOCIONES_ID("ttl_pg_grilla_promociones_id"),
	TTL_PG_GRILLA_PROMOCIONES_SORTEO("ttl_pg_grilla_promociones_sorteo"),
	TTL_PG_GRILLA_PROMOCIONES_TIPO("ttl_pg_grilla_promociones_tipo"),
	TTL_PG_GRILLA_PROMOCIONES_CIFRAS("ttl_pg_grilla_promociones_cifras"),
	TTL_PG_GRILLA_PROMOCIONES_DATO("ttl_pg_grilla_promociones_dato"),
	CHK_PG_INCLU_APODERADO("chk_pg_inclu_apoderado"),
	LBL_PG_NOTAS("lbl_pg_notas"),
	
	//Solicitud Autorizaciones Transacciones
	TTL_SAT_VENTANA("ttl_sat_ventana"),
	LBL_SAT_TTL_PNL_TERR_AGE_PAGO("lbl_sat_ttl_pnl_terr_age_pago"),
	LBL_SAT_TTL_PNL_TERR_AGE_ORIGEN("lbl_sat_ttl_pnl_terr_age_origen"),
	LBL_SAT_TTL_PNL_TERR_AGE_DESTINO("lbl_sat_ttl_pnl_terr_age_destino"),
	LBL_SAT_TTL_PNL_TERC_ORIGEN("lbl_sat_ttl_pnl_terc_origen"),
	LBL_SAT_TTL_PNL_TERC_DESTINO("lbl_sat_ttl_pnl_terc_destino"),
	LBL_SAT_TTL_PNL_TERC_NUEVO("lbl_sat_ttl_pnl_terc_nuevo"),
	TTL_SAT_PNL_NOTAS("ttl_sat_pnl_notas"),
	TTL_SAT_PNL_NOTAS_ADICIONALES("ttl_sat_pnl_notas_adicionales"),
	LBL_SAT_LISTA_ANOTACIONES("lbl_sat_lista_anotaciones"),
	LBL_SAT_REFERENCIA("lbl_sat_referencia"),
	LBL_SAT_LISTA_SOLICITUDES("lbl_sat_lista_solicitudes"),
	LBL_SAT_CLAVE_SEGURIDAD("lbl_sat_clave_seguridad"),
	
	
	// mauricio garcia
	//Operaciones inusuales internacionales
	TTL_OII_VENTANA("ttl_oii_ventana"),
	TTL_OII_BORD_ORIGEN("ttl_oii_bord_origen"),
	TTL_OII_BORD_PRODUCTO("ttl_oii_bord_producto"),
	TTL_OII_BORD_SENALES("ttl_oii_bord_senales"),
	TTL_OII_BORD_EXISTE_TRANSACCION("ttl_oii_bord_existe_transaccion"),
	LBL_OII_TIPO_DOCUMENTO("lbl_oii_tipo_documento"),
	LBL_OII_DOCUMENTO("lbl_oii_documento"),
	LBL_OII_PRODUCTO("lbl_oii_producto"),
	LBL_OII_CORRESPONSAL("lbl_oii_corresponsal"),
	LBL_OII_NO_DE_OPERACION("lbl_oii_no_de_operacion"),
	LBL_OII_MONEDA("lbl_oii_moneda"),
	LBL_OII_VALOR_OPERACION("lbl_oii_valor_operacion"),
	LBL_OII_DOC_CLIENTE("lbl_oii_doc_cliente"),
	LBL_OII_NO_OPERACION("lbl_oii_no_operacion"),
	LBL_OII_TIPO_VINCULO("lbl_oii_tipo_vinculo"),
	BTN_OII_AGREGAR_TRX_ASOCIADA("btn_oii_agregar_trx_asociada"),
	BTN_OII_ELIMINAR_TRX_ASOCIADA("btn_oii_eliminar_trx_asociada"),
	TTL_OII_GRILLA_CODIGO("ttl_oii_grilla_codigo"),
	TTL_OII_GRILLA_SENAL_ALERTA("ttl_oii_grilla_senal_alerta"),
	TTL_OII_GRILLA_COMENTARIO("ttl_oii_grilla_comentario"),
	LBL_OII_GRILLA_DOC_CLIENTE("lbl_oii_grilla_doc_cliente"),
	LBL_OII_GRILLA_OPERACION("lbl_oii_grilla_operacion"),
	LBL_OII_GRILLA_PRODUCTO("lbl_oii_grilla_producto"),
	LBL_OII_GRILLA_CORRESPONSAL("lbl_oii_grilla_corresponsal"),
	LBL_OII_GRILLA_VINCULO("lbl_oii_grilla_vinculo"),
	TTL_OII_PNL_DOCUMENTO("ttl_oii_pnl_documento"),
	TTL_OII_PNL_PRODUCTO_TRANSACCION("ttl_oii_pnl_producto_transaccion"),
	TTL_OII_PNL_SENALES_ALERTA("ttl_oii_pnl_senales_alerta"),
	TTL_OII_PNL_TRANSACCION_EXISTENTE("ttl_oii_pnl_transaccion_existente"),
	LBL_OII_CAMPOS_OBLIGATORIOS("lbl_oii_campos_obligatorios"),
	
	//Senal alerta
	TTL_OII_GRILLA_SENAL_ALERTA_CODIGO("ttl_oii_grilla_senal_alerta_codigo"),
	TTL_OII_GRILLA_SENAL_ALERTA_SENAL("ttl_oii_grilla_senal_alerta_senal"),
	TTL_OII_GRILLA_SENAL_ALERTA_COMENTARIO("ttl_oii_grilla_senal_alerta_comentario"),
	
	//Existe transaccion
	LBL_OII_EXISTE_TRANS_DOC_CLIENTE("lbl_oii_existe_trans_doc_cliente"),
	LBL_OII_EXISTE_TRANS_NO_OPERACION("lbl_oii_existe_trans_no_operacion"),
	LBL_OII_EXISTE_TRANS_TRANS_PRODUCTO("lbl_oii_existe_trans_producto"),
	LBL_OII_EXISTE_TRANS_CORRESPONSAL("lbl_oii_existe_trans_corresponsal"),
	LBL_OII_EXISTE_TRANS_TIPO_VINCULO("lbl_oii_existe_trans_tipo_vinculo"),
	TTL_OII_GRILLA_EXISTE_TRANS_DOC_CLIENTE("ttl_oii_grilla_existe_trans_doc_cliente"),
	TTL_OII_GRILLA_EXISTE_TRANS_NUM_OPERACION("ttl_oii_grilla_existe_trans_num_operacion"),
	TTL_OII_GRILLA_EXISTE_TRANS_PRODUCTO("ttl_oii_grilla_existe_trans_producto"),
	TTL_OII_GRILLA_EXISTE_TRANS_CORRESPONSAL("ttl_oii_grilla_existe_trans_corresponsal"),
	TTL_OII_GRILLA_EXISTE_TRANS_TIPO_VINCULO("ttl_oii_grilla_existe_trans_tipo_vinculo"),

	
	//Envio giro postal
	TTL_EGP_VENTANA("ttl_egp_ventana"),
	LBL_EGP_AGENCIA_ORG("lbl_egp_agencia_org"),
	LBL_EGP_AGENCIA_DES("lbl_egp_agencia_des"),
	LBL_EGP_REMITENTE("lbl_egp_remitente"),
	LBL_EGP_BENEFICIARIO("lbl_egp_beneficiario"),
	LBL_EGP_VALOR_GIRAR("lbl_egp_valor_girar"),
	LBL_EGP_PLAN_TARIFARIO("lbl_egp_plan_tarifario"),
	CHK_EGP_INCLU_FLETE("chk_egp_inclu_flete"),
	CHK_EGP_INCLU_OTROS("chk_egp_inclu_otros"),
	CHK_EGP_DOMICILIO("chk_egp_domicilio"),
	CHK_EGP_INCLU_DOMICILIO("chk_egp_inclu_domicilio"),
	TTL_EGP_GRILLA_CONCEPTOS_CODIGO("ttl_egp_grilla_conceptos_codigo"),
	TTL_EGP_GRILLA_CONCEPTOS_CONCEPTO("ttl_egp_grilla_conceptos_concepto"),
	TTL_EGP_GRILLA_CONCEPTOS_VALOR("ttl_egp_grilla_conceptos_valor"),
	LBL_EGP_NUMER_ITEMS("lbl_egp_numero_items"),
	LBL_EGP_TOTAL("lbl_egp_total"),
	LBL_EGP_MSG_PREDETERMINADO("lbl_egp_msg_predeterminado"),
	LBL_EGP_PROMOCIONES("lbl_egp_promociones"),
	TTL_EGP_GRILLA_PROMO_ID("ttl_egp_grilla_promo_id"),
	TTL_EGP_GRILLA_PROMO_SORTEO("ttl_egp_grilla_promo_sorteo"),
	TTL_EGP_GRILLA_PROMO_TIPO("ttl_egp_grilla_promo_tipo"),
	TTL_EGP_GRILLA_PROMO_CIFRAS("ttl_egp_grilla_promo_cifras"),
	TTL_EGP_GRILLA_PROMO_DATO("ttl_egp_grilla_promo_dato"),
	LBL_EGP_CONVENIOS("lbl_egp_convenios"),
	LBL_EGP_COTIZAR_GIRO("lbl_egp_cotizar_giro"),
	CHK_EGP_INCLU_TRAMITADOR("chk_egp_inclu_tramitador"),
	TLT_EGP_CODIGO_PLAN_TARIFARIO("tlt_egp_codigo_plan_tarifario"),
	TLT_EGP_DESC_PLAN_TARIFARIO("tlt_egp_desc_plan_tarifario"),
	
	//Movimientos Caja
	TTL_MVC_VENTANA_SALIDA("ttl_mvc_ventana_salida"),
	TTL_MVC_VENTANA_RECAUDO("ttl_mvc_ventana_recaudo"),
	BTN_MVC_ADICIONAR_MEDIO_PAGO("btn_mvc_adicionar_medio_pago"),
	BTN_MVC_ELIMINAR_MEDIO_PAGO("btn_mvc_eliminar_medio_pago"),
	BTN_MVC_EDITAR_MEDIO_PAGO("btn_mvc_editar_medio_pago"),
	TTL_MVC_GRILLA_MEDPAGO("ttl_mvc_medpago",","),
	TTL_MVC_GRILLA_MEDPAGO_FILA("ttl_mvc_grilla_medpago_fila"),
	TTL_MVC_GRILLA_MEDPAGO_ID("ttl_mvc_grilla_medpago_id"),
	TTL_MVC_GRILLA_MEDPAGO_DESCRIPCION("ttl_mvc_grilla_medpago_descripcion"),
	TTL_MVC_GRILLA_MEDPAGO_VALOR("ttl_mvc_grilla_medpago_valor"),
	LBL_MVC_VALOR_PAGAR("lbl_mvc_valor_pagar"),
	LBL_MVC_VALOR_COBRAR("lbl_mvc_valor_cobrar"),
	LBL_MVC_TOTAL_MOVIMIENTO_ENVIO("lbl_mvc_total_movimiento_envio"),
	LBL_MVC_TOTAL_MOVIMIENTO_PAGO("lbl_mvc_total_movimiento_pago"),
	LBL_MVC_CAMBIO_EXACTO("lbl_mvc_cambio_exacto"),
	LBL_MVC_CAMBIO_FALTA("lbl_mvc_cambio_falta"),
	LBL_MVC_CAMBIO_SOBRA("lbl_mvc_cambio_sobra"),
	
	//Diligenciar Medio de Pago
	TTL_DMP_VENTANA("ttl_dmp_ventana"),
	LBL_DMP_MEDIO_PAGO("lbl_dmp_medio_pago"),
	LBL_DMP_VALOR_MEDIO_PAGO("lbl_dmp_valor_medio_pago"),
	LBL_DMP_DATOS_ADICIONALES_X_MEDIO_PAGO("lbl_dmp_datos_adicionales_x_medio_pago"),
	TTL_DMP_GRILLA_DAT_ADI_MEDPAGO_DATO("ttl_dmp_grilla_dat_adi_medpago_dato"),
	TTL_DMP_GRILLA_DAT_ADI_MEDPAGO_VALOR("ttl_dmp_grilla_dat_adi_medpago_valor"),
	
	//Seccion Facturacion giro
	TTL_FCG_VENTANA("ttl_fcg_ventana"),
	LBL_FCG_VALOR("lbl_fcg_valor"),
	LBL_FCG_RECIBIDO("lbl_fcg_recibido"),
	LBL_FCG_CAMBIO_EXACTO("lbl_fcg_cambio_exacto"),
	LBL_FCG_CAMBIO_FALTA("lbl_fcg_cambio_falta"),
	LBL_FCG_CAMBIO_SOBRA("lbl_fcg_cambio_sobra"),

	//Seccion Registro tercero tramitador
	TTL_RTT_VENTANA("ttl_rtt_ventana"),
	LBL_RTT_TRAMITADOR("lbl_rtt_tramitador"),	
	
	
	//Consulta movimientos caja  giros
	TTL_MCG_VENTANA("ttl_mcg_ventana"),
	LBL_MCG_BUSQUEDA("lbl_mcg_busqueda"),
	TTL_MCG_GRILLA_SALDOS_MEDIO_PAGO("ttl_mcg_grilla_saldos_medio_pago"),
	TTL_MCG_GRILLA_SALDOS_MONEDA("ttl_mcg_grilla_saldos_moneda"),
	TTL_MCG_GRILLA_SALDOS_SALDO_INICIAL("ttl_mcg_grilla_saldos_saldo_inicial"),
	TTL_MCG_GRILLA_SALDOS_INGRESOS("ttl_mcg_grilla_saldos_ingresos"),
	TTL_MCG_GRILLA_SALDOS_EGRESOS("ttl_mcg_grilla_saldos_egresos"),
	TTL_MCG_GRILLA_SALDOS_TRASLADOS("ttl_mcg_grilla_saldos_traslados"),
	TTL_MCG_GRILLA_SALDOS_SALDO_FINAL("ttl_mcg_grilla_saldos_saldo_final"),
	PNL_MCG_SALDOSMEDIOPAGO("pnl_mcg_saldosmediopago"),
	PNL_MCG_DETALLE_MOVIMIENTOS("pnl_mcg_detalle_movimientos"),
	TTL_MCG_GRILLA_DETALLE_MOVIMIENTOS_MONEDA("ttl_mcg_grilla_detalle_movimientos_moneda"),
	TTL_MCG_GRILLA_DETALLE_MOVIMIENTOS_MEDIO_PAGO("ttl_mcg_grilla_detalle_movimientos_medio_pago"),
	TTL_MCG_GRILLA_DETALLE_MOVIMIENTOS_CONCEPTO("ttl_mcg_grilla_detalle_movimientos_concepto"),
	TTL_MCG_GRILLA_DETALLE_MOVIMIENTOS_FECHA("ttl_mcg_grilla_detalle_movimientos_fecha"),
	TTL_MCG_GRILLA_DETALLE_MOVIMIENTOS_HORA("ttl_mcg_grilla_detalle_movimientos_hora"),
	TTL_MCG_GRILLA_DETALLE_MOVIMIENTOS_REFERENCIA("ttl_mcg_grilla_detalle_movimientos_referencia"),
	TTL_MCG_GRILLA_DETALLE_MOVIMIENTOS_INGRESOS("ttl_mcg_grilla_detalle_movimientos_ingresos"),
	TTL_MCG_GRILLA_DETALLE_MOVIMIENTOS_EGRESOS("ttl_mcg_grilla_detalle_movimientos_egresos"),
	PNL_MCG_TOTAL_X_CONCEPTO("pnl_mcg_total_x_concepto"),
	TTL_MCG_GRILLA_TOTAL_X_CONCEPTO_NUMERO("ttl_mcg_grilla_total_x_concepto_numero"),
	TTL_MCG_GRILLA_TOTAL_X_CONCEPTO_MEDIO_PAGO("ttl_mcg_grilla_total_x_concepto_medio_pago"),
	TTL_MCG_GRILLA_TOTAL_X_CONCEPTO_CONCEPTO("ttl_mcg_grilla_total_x_concepto_concepto"),
	TTL_MCG_GRILLA_TOTAL_X_CONCEPTO_INGRESOS("ttl_mcg_grilla_total_x_concepto_ingresos"),
	TTL_MCG_GRILLA_TOTAL_X_CONCEPTO_EGRESOS("ttl_mcg_grilla_total_x_concepto_egresos"),
	
	
	//Convenio Sedes
	TTL_CVS_VENTANA("ttl_cvs_ventana"),
	LBL_CVS_CONV_SEDE("lbl_cvs_conv_sede"),
	TTL_CVS_TBL_SEDE_ID("ttl_cvs_tbl_sede_id"),
	TTL_CVS_TBL_SEDE_NOMBRE("ttl_cvs_tbl_sede_nombre"),
	TTL_CVS_TBL_SEDE_DIRECCION("ttl_cvs_tbl_sede_direccion"),
	TTL_CVS_TBL_SEDE_TELEFONOS("ttl_cvs_tbl_sede_telefonos"),
	TTL_CVS_TBL_SEDE_CODIGO_EXTERNO("ttl_cvs_tbl_sede_codigo_externo"),
	TTL_CVS_TBL_SEDE_IDENTIFICACION("ttl_cvs_tbl_sede_identificacion"),
	TTL_CVS_TBL_SEDE_TERCERO("ttl_cvs_tbl_sede_tercero"),
	TTL_CVS_TBL_SEDE_PRECIO("ttl_cvs_tbl_sede_precio"),
	TTL_CVS_PNL_CONVENIO("ttl_cvs_pnl_convenio",false),
	
	//Consulta movimientos provisiones
	TTL_CMP_VENTANA("ttl_cmp_ventana"),
	LBL_CMP_BUSQUEDA("lbl_cmp_busqueda"),
	TTL_CMP_GRILLA_MOV_PROVISIONES_MONEDA("ttl_cmp_grilla_mov_provisiones_moneda"),
	TTL_CMP_GRILLA_MOV_PROVISIONES_MEDIO_PAGO("ttl_cmp_grilla_mov_provisiones_medio_pago"),
	TTL_CMP_GRILLA_MOV_PROVISIONES_CONCEPTO("ttl_cmp_grilla_mov_provisiones_concepto"),
	TTL_CMP_GRILLA_MOV_PROVISIONES_FECHA("ttl_cmp_grilla_mov_provisiones_fecha"),
	TTL_CMP_GRILLA_MOV_PROVISIONES_HORA("ttl_cmp_grilla_mov_provisiones_hora"),
	TTL_CMP_GRILLA_MOV_PROVISIONES_REFERENCIA("ttl_cmp_grilla_mov_provisiones_referencia"),
	TTL_CMP_GRILLA_MOV_PROVISIONES_CAJA_DESTINO("ttl_cmp_grilla_mov_provisiones_caja_destino"),
	TTL_CMP_GRILLA_MOV_PROVISIONES_ESTADO("ttl_cmp_grilla_mov_provisiones_estado"),
	TTL_CMP_GRILLA_MOV_PROVISIONES_OBSERVACIONES("ttl_cmp_grilla_mov_provisiones_observaciones"),
	TTL_CMP_GRILLA_MOV_PROVISIONES_VALOR("ttl_cmp_grilla_mov_provisiones_valor"),
	PNL_CMP_TOTAL_CONCEPTO("pnl_cmp_total_concepto"),
	PNL_CMP_TOTAL_MONEDA("pnl_cmp_total_moneda"),
	TTL_CMP_GRILLA_TOTAL_CONCEPTO_NUMERO("ttl_cmp_grilla_total_concepto_numero"),
	TTL_CMP_GRILLA_TOTAL_CONCEPTO_DESCRIPCION("ttl_cmp_grilla_total_concepto_descripcion"),
	TTL_CMP_GRILLA_TOTAL_CONCEPTO_VALOR("ttl_cmp_grilla_total_concepto_valor"),
	TTL_CMP_GRILLA_TOTAL_MONEDA_DESCRIPCION("ttl_cmp_grilla_total_moneda_descripcion"),
	TTL_CMP_GRILLA_TOTAL_MONEDA_MEDIO_PAGO("ttl_cmp_grilla_total_moneda_medio_pago"),
	TTL_CMP_GRILLA_TOTAL_MONEDA_VALOR("ttl_cmp_grilla_total_moneda_valor"),
	
	//Seccion Reimprimir ultima facturaci�n
	TTL_RUF_VENTANA("ttl_ruf_ventana"),
	LBL_RUF_IDTERCOGN("lbl_ruf_idtercogn"),
	LBL_RUF_TERCOGN("lbl_ruf_tercogn"),
	LBL_RUF_IDTERCDEST("lbl_ruf_terdest"),
	LBL_RUF_TERCDEST("lbl_ruf_tercdest"),
	LBL_RUF_AGNORG("lbl_ruf_agnorg"),
	LBL_RUF_AGNDEST("lbl_ruf_agndest"),
	LBL_RUF_FECHA("lbl_ruf_fecha"),
	
	//Reimpresion
	LBL_RMP_DETREIMP("lbl_rmp_detreimp"),
	LBL_TIPO_DOC("lbl_tipo_doc"),
	LBL_RMP_RMP("lbl_rmp_rmp"),
	LBL_CER_IND("lbl_cer_ind"),
	LBL_NOM_ASG("lbl_nom_asg"),
	LBL_ID_TERC("lbl_id_terc"),
	
	LBL_VLR_PRIMA("lbl_vlr_prima"),
	LBL_VLR_HURTO("lbl_vlr_hurto"),
	LBL_VLR_ACC("lbl_vlr_acc"),

	
	//Seccion provisiones caja
	TTL_PVC_VENTANA("ttl_pvc_ventana"),
	LBL_PVC_AGENCIA_ORG("lbl_pvc_agencia_org"),
	LBL_PVC_CONCEPTO_EGRESO("lbl_pvc_concepto_egreso"),
	LBL_PVC_VALOR_EGRESO("lbl_pvc_valor_egreso"),
	LBL_PVC_MEDIO_PAGO("lbl_pvc_medio_pago"),
	LBL_PVC_DOCUMENTO_AUXILIAR("lbl_pvc_documento_auxiliar"),
	LBL_PVC_NOTAS_EGRESO("lbl_pvc_notas_egreso"),
	LBL_PVC_AGENCIA_DES("lbl_pvc_agencia_des"),
	LBL_PVC_AGENCIA_DESTINO("lbl_pvc_agencia_destino"),
	LBL_PVC_CAJA_DESTINO("lbl_pvc_caja_destino"),
	LBL_PVC_CONCEPTO_INGRESO("lbl_pvc_concepto_ingreso"),
	LBL_PVC_VALOR_INGRESO("lbl_pvc_valor_ingreso"),
	LBL_PVC_NOTAS_INGRESO("lbl_pvc_notas_ingreso"),
	
	//Configurar Tipo Impresora
	TTL_CTI_VENTANA("ttl_cti_ventana"),
	RBT_CTI_TMU("rbt_cti_tmu",false),
	RBT_CTI_MC("rbt_cti_mc",false),
	RBT_CTI_SOCKET("rbt_cti_socket"),
	RBT_CTI_NO_SOCKET("rbt_cti_no_socket"),
	BTN_CTI_PAGINA_PRUEBA("btn_cti_pagina_prueba"),
	TLT_CTI_NOMBRE_IMP("tlt_cti_nombre_imp"),
	
	//Seccion enrolar tercero
	TTL_ETC_VENTANA("ttl_etc_ventana"),
	LBL_ETC_TERCERO("lbl_etc_tercero"),
	LBL_ETC_HUELLA_DERECHA("lbl_etc_huella_derecha"),
	BTN_ETC_HUELLA_DERECHA("btn_etc_huella_derecha"),
	LBL_ETC_HUELLA_DER_EXITO("lbl_etc_huella_der_exito"),
	LBL_ETC_HUELLA_IZQUIERDA("lbl_etc_huella_izquierda"),
	BTN_ETC_HUELLA_IZQUIERDA("btn_etc_huella_izquierda"),
	
	//Seccion FORMA EDICIO NOTAS
	TTL_EDN_VENTANA("ttl_edn_ventana"),
	LBL_EDN_EMPRESA("lbl_edn_empresa"),
	TTL_EDN_PANEL_CUERPO("ttl_edn_panel_cuerpo"),
	LBL_EDN_CAJA("lbl_edn_caja"),
	LBL_EDN_REFERENCIA("lbl_edn_referencia"),
	LBL_EDN_AGENORI("lbl_edn_agenori"),
	LBL_EDN_AGENDES("lbl_edn_agendes"),
	LBL_EDN_REMITENTE("lbl_edn_remitente"),
	LBL_EDN_BENEFICIARIO("lbl_edn_beneficiario"),
	LBL_EDN_FECHAGIRO("lbl_edn_fechagiro"),
	LBL_EDN_NOTAS("lbl_edn_notas"),
	LBL_EDN_ADINOTA("lbl_edn_adinota"),
	LBL_EDN_NUENOTA("lbl_edn_nuenota"),
	TLT_EDN_AGEN_COD("tlt_edn_agen_cod"),
	TLT_EDN_AGEN_DESC("tlt_edn_agen_desc"),
	
	//Ayudas SuperCombo
	TTL_SPR_VENTANA("ttl_spr_ventana",false),
	TXT_SPR_COMBO_P1("txt_spr_combo_p1"),
	LBL_ASC_ANUNCIO_PRINCIPAL_TITULO("txt_spr_combo_p2"),
	LBL_ASC_ANUNCIO_PRINCIPAL_SUBTITULO("txt_spr_combo_p2_1",false),
	LBL_ASC_ANUNCIO_PRINCIPAL_RESUMEN_PROCESO("txt_spr_combo_p2_2"),
	LBL_ASC_ANUNCIO_PRINCIPAL_COSTO_X_SERVICIO("txt_spr_combo_p2_3"),
	LBL_ASC_ANUNCIO_PRINCIPAL_TIPOS_OPCIONES_SERVICIO("txt_spr_combo_p2_4"),
	LBL_ASC_ANUNCIO_PRINCIPAL_DESEA_INCLUIRLO("txt_spr_combo_p2_5"),
	BTN_ASC_ANUNCIO_PRINCIPAL_SIGUIENTE_AYUDA("btn_asc_anuncio_principal_siguiente_ventana"),
	TXT_SPR_COMBO_P3_1("txt_spr_combo_p3_1"),
	TXT_SPR_COMBO_P3_2("txt_spr_combo_p3_2"),
	TXT_SPR_COMBO_P3_3("txt_spr_combo_p3_3"),
	TXT_SPR_COMBO_P3_4("txt_spr_combo_p3_4"),
	TXT_SPR_COMBO_P3_5("txt_spr_combo_p3_5"),
	TXT_SPR_COMBO_P4_1("txt_spr_combo_p4_1"),
	TXT_SPR_COMBO_P4_2("txt_spr_combo_p4_2"),
	
	//Seccion SuperCombo Origen
	TTL_SCO_VENTANA("ttl_sco_ventana"),
	LBL_SCO_DATOS_SMS("lbl_sco_datos_sms"),
	LBL_SCO_TELEFONO_REMITENTE("lbl_sco_telefono_remitente"),
	LBL_SCO_TELEFONO_DESTINO("lbl_sco_telefono_destino"),
	LBL_SCO_DESEA_INCLUIR("lbl_sco_desea_incluir"),
	LBL_SCO_BENEFICIOS("lbl_sco_beneficios",false),
	LBL_SCO_HURTO("lbl_sco_hurto"),
	LBL_SCO_FALLECIMIENTO("lbl_sco_fallecimiento"),
	LBL_SCO_NOTIFICACION("lbl_sco_notificacion"),
	LBL_SCO_VALOR_SUPERCOMBO("lbl_sco_valor_supercombo"),

	//Consultar Documentos Pendientes
	TTL_CDP_VENTANA("ttl_dcp_ventana"),
	LBL_CDP_EMPRESA("lbl_dcp_empresa"),
	LBL_CDP_CAJA("lbl_dcp_caja"),
	LBL_CDP_TIPO_OPERACION("lbl_dcp_tpoperacion"),
	LBL_CDP_ACEPTAR_RECHAZAR_PROVISION("lbl_dcp_aceptar_rechazar_provision",","),
	LBL_CDP_CONFIRMAR_PROVISION_RECIBIDA("lbl_dcp_confirmar_provision_recibida"),
	LBL_CDP_RECHAZAR_PROVISION_ENVIADA("lbl_dcp_rechazar_provision_enviada"),
	TTL_CDP_GRILLA_REFERENCIA("ttl_dcp_grilla_referencia"),
	TTL_CDP_GRILLA_AGENCIA_ORIGEN("ttl_cdp_grilla_agencia_origen"),
	TTL_CDP_GRILLA_AGENCIA_DESTINO("ttl_cdp_grilla_agencia_destino"),
	TTL_CDP_GRILLA_VALOR("ttl_dcp_grilla_valor"),
	TTL_CDP_GRILLA_CONCEPTO("ttl_dcp_grilla_concepto"),

	//CRENDON INGRESOS Y EGRESOS
	TTL_IN_VENTANA("ttl_in_ventana"),
	LBL_IN_TIPO_MOVIMIENTO("lbl_in_tipo_movimiento"),
	LBL_IN_CONCEPTO("lbl_in_concepto"),
	LBL_IN_VALOR("lbl_in_valor"),
	LBL_IN_MEDIPAGO("lbl_in_medipago"),
	LBL_IN_DOCAUX("lbl_in_docaux"),
	LBL_IN_NOTAS("lbl_in_notas"),
	LBL_IN_INGRESO("lbl_in_ingreso",false),
	LBL_IN_EGRESO("lbl_in_egreso",false),
	
	//ACEPTA PROVISIONES
	TTL_ADP_VENTANA("ttl_ap_ventana"),
	LBL_ADP_SECCION_DESTINO("lbl_ap_destino"),
	LBL_AP_AGENCIA("lbl_ap_agencia"),
	LBL_AP_CAJA("lbl_ap_caja"),
	LBL_ADP_REFERENCIA("lbl_ap_referencia"),
	LBL_ADP_CONCEPTO("lbl_ap_concepto"),
	LBL_ADP_MEDIO_PAGO("lbl_ap_medipago"),
	LBL_ADP_VALOR("lbl_ap_valor"),
	LBL_ADP_NOTAS("lbl_ap_notas"),
	LBL_ADP_NOTA_ADICIONAL("lbl_adp_nota_adicional"),
	
	//RECHAZA PROVISIONES
	TTL_RDP_VENTANA("ttl_rd_ventana"),
	TTL_RDP_RECHAZO("ttl_rp_Rechazo"),
	LBL_RDP_SECCION_ORIGEN("lbl_rp_origen"),
	LBL_RDP_REFERENCIA("lbl_rp_referencia"),
	LBL_RDP_CONCEPTO("lbl_rp_concepto"),
	LBL_RDP_MEDIO_PAGO("lbl_rp_medipago"),
	LBL_RDP_VALOR("lbl_rp_valor"),
	LBL_RDP_RAZON("lbl_rp_razon"),
	LBL_RDP_NOTAS("lbl_rp_notas"),
	LBL_RDP_SECCION_DESTINO("lbl_rp_destino"),
	LBL_RDP_AGENCIA_DESTINO("lbl_rp_agencia"),
	LBL_RDP_CAJA_DESTINO("lbl_rp_caja"),
	
	//OPERACIONES INUSUALES
	TTL_OI_VENTANA("ttl_oi_ventana"),
	LBL_OI_OPERINUSUAL("lbl_oi_operinusual"),
	LBL_OI_ANOTACIONES("lbl_oi_anotaciones"),
	
	//Movimiento Desembolso
	TTL_MVD_VENTANA("ttl_mvd_ventana"),
	TTL_MVD_GRILLA_MONEDA("ttl_mvd_grilla_moneda"),
	TTL_MVD_GRILLA_MEDIO_PAGO("ttl_mvd_grilla_medio_pago"),
	TTL_MVD_GRILLA_CONCEPTO("ttl_mvd_grilla_concepto"),
	TTL_MVD_GRILLA_FECHA("ttl_mvd_grilla_fecha"),
	TTL_MVD_GRILLA_HORA("ttl_mvd_grilla_hora"),
	TTL_MVD_GRILLA_REFERENCIA("ttl_mvd_grilla_referencia"),
	TTL_MVD_GRILLA_CAJA_DESTINO("ttl_mvd_grilla_caja_destino"),
	TTL_MVD_GRILLA_ESTADO("ttl_mvd_grilla_estado"),
	TTL_MVD_GRILLA_OBSERVACIONES("ttl_mvd_grilla_observaciones"),
	TTL_MVD_GRILLA_VALOR("ttl_mvd_grilla_valor"),
	
	//RMP
	TT_RMP_REIMPRIMIR_X_PIN("tt_rmp_reimprimir_x_pin"),
	TT_RMP_FACTURACION("tt_rmp_facturacion"),
	TT_RMP_INGRESO("tt_rmp_ingreso"),
	TT_RMP_EGRESO("tt_rmp_egreso"),
	TT_RMP_PAGO("tt_rmp_pago"),
	LBL_RMP_DETALLE_REIMP("lbl_rmp_detalle_reimp"),
	LBL_RMP_TIPO_DOC("lbl_rmp_tipo_doc",false),
	LBL_RMP_REFERENCIA_NO("lbl_rmp_referencia_no",false),
	TT_RMP_REIMPRIMIR_SMS("tt_rmp_reimprimir_sms",false),
	LBL_RMP_PIN("lbl_rmp_pin",false),
	LBL_RMP_TERCERO_ORIGEN("lbl_rmp_tercero_origen",false),
	LBL_RMP_VALOR_MENSAJE("lbl_rmp_valor_mensaje",false),
	LBL_RMP_VALOR_IVA("lbl_rmp_valor_iva",false),
	LBL_RMP_VALOR_TOTAL("lbl_rmp_valor_total",false),
	TTL_RMP_ULTIMO_SEGURO("ttl_rmp_ultimo_seguro",false),
	TTL_RMP_ULTIMO_CIERRE_VENTANA("ttl_rmp_ultimo_cierre_ventana"),
	
	//Historial Autorizacion
	TTL_HAU_VENTANA("ttl_hau_ventana"),
	TTL_HAU_PANEL_CUERPO("ttl_hau_panel_cuerpo"),
	LBL_HAU_FECHA("lbl_hau_fecha"),
	LBL_HAU_FILTRO("lbl_hau_filtro"),
	TTL_HAU_GRILLA_FILA("ttl_hau_grilla_fila"),
	TTL_HAU_GRILLA_HORA("ttl_hau_grilla_hora"),
	TTL_HAU_GRILLA_REFERENCIA("ttl_hau_grilla_referencia"),
	TTL_HAU_GRILLA_SOLICITUD("ttl_hau_grilla_solicitud"),
	TTL_HAU_GRILLA_ORIGEN("ttl_hau_grilla_origen"),
	TTL_HAU_GRILLA_DESTINO("ttl_hau_grilla_destino"),
	TTL_HAU_GRILLA_TERCERO_INICIAL("ttl_hau_grilla_tercero_inicial"),
	TTL_HAU_GRILLA_TERCERO_CAMBIO("ttl_hau_grilla_tercero_cambio"),
	TTL_HAU_GRILLA_ESTADO("ttl_hau_grilla_estado"),
	TTL_HAU_GRILLA_NOTAS("ttl_hau_grilla_notas"),
	
	//Reimprimir ultimo seguro
	LBL_RSG_FECHA_TRANSACCION("lbl_rsg_fecha_transaccion",false),
	
	//Reimprimir ultimo SMS
	LBL_RSM_FECHA_TRANSACCION("lbl_rsm_fecha_transaccion",false),
	
	//Convenio propiedades
	TTL_CVP_VENTANA("ttl_cvp_ventana"),
	TTL_CVP_PNL_CONVENIO("ttl_pnl_convenio"),
	TTL_CVP_PNL_PROPIEDADES("ttl_pnl_propiedad"),
	LBL_CVP_IDENTIFICACION("lbl_cvp_identificacion"),
	LBL_CVP_NOMBRE("lbl_cvp_nombre"),
	TTL_CVP_GRILLA_PROPIEDAD("ttl_cvp_grilla_propiedad"),
	TTL_CVP_GRILLA_LISTAR("ttl_cvp_grilla_listar"),
	TTL_CVP_GRILLA_EJEMPLO("ttl_cvp_grilla_ejemplo"),
	TTL_CVP_GRILLA_DETALLE("ttl_cvp_grilla_detalle"),
	
	//Ofrecer clave seguridad
	TTL_OCS_VENTANA("ttl_ocs_ventana"),
	LBL_OCS_DESEA_INCLUIR("lbl_ocs_desea_incluir"),
	LBL_OCS_TIPO_CLAVE("lbl_ocs_tipo_clave"),
	//Seccion clave seguridad manual
	LBL_PNL_CSM_NOTA("lbl_pnl_csm_nota"),
	LBL_PNL_CSM_INGRESE("lbl_pnl_csm_ingrese", false),
	LBL_PNL_CSM_CLAVE_DEBE("lbl_pnl_csm_clave_debe"),
	LBL_PNL_CSM_INGRESAR_CLAVE("lbl_pnl_csm_ingresar_clave"),
	LBL_PNL_CSM_CONFIRMAR_CLAVE("lbl_pnl_csm_confirmar_clave"),
	//Seccion clave seguridad automatica
	LBL_PNL_CSA_DATOS_SMS("lbl_pnl_csa_datos_sms", false),
	TTL_PNL_CSA_SECCION_REMITENTE("ttl_pnl_csa_seccion_remitente"),
	TTL_PNL_CSA_SECCION_DESTINATARIO("ttl_pnl_csa_seccion_destinatario"),
	LBL_PNL_CSA_INGRESAR_CELULAR("lbl_pnl_csa_ingresar_celular"),
	LBL_PNL_CSA_CONFIRMAR_CELULAR("lbl_pnl_csa_confirmar_celular"),
	//Seccion clave seguridad no gracias
	LBL_PNL_CSNG_NOTA("lbl_pnl_csng_nota"),
	
	//Verificar clave seguridad
	TTL_VCS_VENTANA("ttl_vcs_ventana"),
	LBL_VCS_INGRESA_CLAVE("lbl_vcs_ingresa_clave"),
	LBL_VCS_CLAVE_SEGURIDAD("lbl_vcs_clave_seguridad"),
	
	//Consulta estado giro
	TTL_CEG_VENTANA("ttl_ceg_ventana"),
	LBL_CEG_REFERENCIA("lbl_ceg_referencia"),
	LBL_CEG_ESTADO("lbl_ceg_estado"),
	LBL_CEG_AGENCIA_ORIGEN("lbl_ceg_agencia_origen"),
	LBL_CEG_AGENCIA_DESTINO("lbl_ceg_agencia_destino"),
	
	//Solicitar Huellas Tercero
	TTL_SHT_VENTANA("ttl_sht_ventana"),
	
	//Seccion SMS Giro
	LBL_PNL_SMS_INGRESAR_CELULAR("lbl_pnl_sms_ingresar_celular"),
	LBL_PNL_SMS_CONFIRMAR_CELULAR("lbl_pnl_sms_confirmar_celular"),
	
	//Consulta Pago Giros Internacionales
	TTL_CPI_VENTANA("ttl_cpi_ventana"),
	LBL_CPI_BUSQUEDA_POR("lbl_cpi_busqueda_por"),
	LBL_CPI_TIPOS_IDENTIFICACION("lbl_cpi_tipos_identificacion"),
	LBL_CPI_IDENTIFICACION("lbl_cpi_identificacion"),
	LBL_CPI_REFERENCIA("lbl_cpi_referencia"),
	LBL_CPI_CORRESPONSAL("lbl_cpi_corresponsal"),
	LBL_CPI_TIPO_DOCUMENTO("lbl_cpi_tipo_documento"),
	LBL_CPI_DOCUMENTO("lbl_cpi_documento"),
	LBL_CPI_ESTADO_REMESA("lbl_cpi_estado_remesa"),
	CHK_CPI_DESTINATARIO("chk_cpi_destinatario"),
	CHK_CPI_REMITENTE("chk_cpi_remitente"),
	LBL_CPI_NOMBRE_TERCERO_BEN("lbl_cpi_nombre_tercero_ben"),
	LBL_CPI_APELLIDO_TERCERO_BEN("lbl_cpi_apellido_tercero_ben"),
	LBL_CPI_NOMBRE_TERCERO_REM("lbl_cpi_nombre_tercero_rem"),
	LBL_CPI_APELLIDO_TERCERO_REM("lbl_cpi_apellido_tercero_rem"),
	LBL_CPI_DOCUMENTO_AL_REVES("lbl_cpi_documento_al_reves"),
	LBL_CPI_ITEM_BUSQUEDA_POR_DOCUMENTO("lbl_cpi_item_busqueda_por_documento"),
	LBL_CPI_ITEM_BUSQUEDA_POR_PIN("lbl_cpi_item_busqueda_por_pin"),
	TLT_CPI_TIPO_DOCUMENTO("tlt_cpi_tipo_documento"),
	TTL_CPI_GRILLA_GIROS_BENEFICIARIO("ttl_cpi_grilla_giros_beneficiario"),
	TTL_CPI_GRILLA_GIROS_REMITENTE("ttl_cpi_grilla_giros_remitente"),
	TTL_CPI_GRILLA_GIROS_CORRESPONSAL("ttl_cpi_grilla_giros_corresponsal"),
	TTL_CPI_GRILLA_GIROS_REFERENCIA("ttl_cpi_grilla_giros_referencia"),
	TTL_CPI_GRILLA_GIROS_VLR_PESOS("ttl_cpi_grilla_giros_vlr_pesos"),
	TTL_CPI_GRILLA_GIROS_PAIS("ttl_cpi_grilla_giros_pais"),
	TTL_CPI_PNL_REFERENCIA("ttl_cpi_pnl_referencia"),
	TTL_CPI_PNL_DOCUMENTO_AL_REVES("ttl_cpi_pnl_documento_al_reves"),
	
	//Codigos Servicios Giros Internacionales
	FPISA_CODIGO_CORRESPONSSALES("fpisa_codigo_corresponssales",false),
	FPISA_CODIGO_TIPO_DOCUMENTOS("fpisa_codigo_tipo_documentos",false),
	FPISA_CODIGO_ACTIVIDADES_ECONOMICAS("fpisa_codigo_actividades_economicas",false),
	FPISA_CODIGO_PROFESIONES("fpisa_codigo_profesiones",false),
	FPISA_CODIGO_PAISES("fpisa_codigo_paises",false),
	FPISA_CODIGO_PAISES_ENVIO("fpisa_codigo_paises_envio",false),
	FPISA_CODIGO_DEPARTAMENTOS("fpisa_codigo_departamentos",false),
	FPISA_CODIGO_CIUDADES("fpisa_codigo_ciudades",false),
	FPISA_CODIGO_TIPOS_MOTIVOS_GIROS("fpisa_codigo_tipos_motivos_giros",false),
	FPISA_CODIGO_NUMERALES_ENVIO("fpisa_codigo_numerales_envio",false),
	FPISA_CODIGO_NUMERALES_PAGO("fpisa_codigo_numerales_pago",false),
	FPISA_CODIGO_SENALES_ALERTA("fpisa_codigo_senales_alerta",false),
	FPISA_CODIGO_CONSULTA_GIRO_X_REFERENCIA("fpisa_codigo_consulta_giro_x_referencia",false),
	FPISA_CODIGO_CONSULTA_GIRO_X_BENEFICIARIO("fpisa_codigo_consulta_giro_x_beneficiario",false),
	FPISA_CODIGO_CONSULTA_TERCERO("fpisa_codigo_consulta_tercero",false),
	FPISA_CODIGO_GESTION_RECLAMOS("fpisa_codigo_gestion_reclamos",false),
	FPISA_CODIGO_PAGO_GIRO("fpisa_codigo_pago_giro",false),
	FPISA_CODIGO_CREAR_ACTUALIZAR_TERCERO_USUARIO("fpisa_codigo_crear_actualizar_tercero_usuario",false),
	FPISA_CODIGO_CREAR_ACTUALIZAR_TERCERO_CLIENTE("fpisa_codigo_crear_actualizar_tercero_cliente",false),
	FPISA_CODIGO_COTIZAR_GIRO("fpisa_codigo_cotizar_giro",false),
	FPISA_CODIGO_REIMPRESION_INTERNACIONAL("fpisa_codigo_reimpresion",false),
	FPISA_CODIGO_OPERACIONES_INUSUALES("fpisa_codigo_operacion_inusual",false),
	
	FPISA_CODIGO_ENVIO_GIRO("fpisa_codigo_envio_giro",false),
	
	//Gestion Reclamo Internacional
	TTL_GRI_VENTANA("ttl_gri_ventana"),
	LBL_GRI_MENSAJE("lbl_gri_mensaje"),
	LBL_GRI_COMENTARIO("lbl_gri_comentario"),
	
	//Pago Giro Internacionales
	TTL_PGI_VENTANA("ttl_pgi_ventana"),
	TTL_PGI_PNL_REMITENTE("ttl_pgi_pnl_remitente"),
	TTL_PGI_PNL_BENEFICIARIO("ttl_pgi_pnl_beneficiario"),
	TTL_PGI_PNL_MOTIVOS_NUMERALES("ttl_pgi_pnl_motivos_numerales"),
	TTL_PGI_PNL_HUELLA("ttl_pgi_pnl_huella"),
	LBL_PGI_NOMBRE_TERCERO_REM("lbl_pgi_nombre_tercero_rem"),
	LBL_PGI_TELEFONO_TERCERO_REM("lbl_pgi_telefono_tercero_rem"),
	LBL_PGI_NOMBRE_TERCERO_BEN("lbl_pgi_nombre_tercero_ben"),
	LBL_PGI_TELEFONO_TERCERO_BEN("lbl_pgi_telefono_tercero_ben"),
	LBL_PGI_CLIENTE_TERCERO_BEN("lbl_pgi_cliente_tercero_ben"),
	LBL_PGI_MOTIVO_REMENSA("lbl_pgi_motivo_remensa"),
	LBL_PGI_NUMERALES("lbl_pgi_numerales"),
	LBL_PGI_MANOS("lbl_pgi_manos"),
	LBL_PGI_DEDOS("lbl_pgi_dedos"),
	BTN_PGI_CAPTURA_HUELLA("btn_pgi_captura_huella"),
	BTN_PGI_CAPTURA_FOTOS("btn_pgi_captura_fotos"),
	BTN_PGI_GESTION_RECLAMOS("btn_pgi_gestion_reclamos"),
	BTN_PGI_GESTION_SENALES_ALERTA("btn_pgi_senales_alerta"),
	LBL_PGI_FORMA_PAGO("lbl_pgi_forma_pago"),
	LBL_PGI_NOTAS("lbl_pgi_notas"),
	LBL_PGI_VALOR_PESOS("lbl_pgi_valor_pesos"),
	LBL_PGI_VALOR_DOLARES("lbl_pgi_valor_dolares"),
	LBL_PGI_TASA("lbl_pgi_tasa"),
	LBL_PGI_GMF("lbl_pgi_gmf"),
	LBL_PGI_GASTOS_ADMIN("lbl_pgi_gastos_admin"),
	LBL_PGI_VLR_PROTEGIRO("lbl_pgi_vlr_protegiro"),
	LBL_PGI_VLR_TOTAL_PAGAR("lbl_pgi_vlr_total_pagar"),
	
	//Captura Documento Internacional
	TTL_CDI_VENTANA("ttl_cdi_ventana"),

	//Dedo Biometria Seleccionado
	LBL_PNL_DBS_TIPO_MANO("lbl_pnl_dbs_tipo_mano"),
	LBL_PNL_DBS_TIPO_DEDO("lbl_pnl_dbs_tipo_dedo"),
	
	//Listado Manos {EnumManosInternacional}
	TTL_MANO_DERECHA("ttl_mano_derecha"),
	TTL_MANO_IZQUIERDA("ttl_mano_izquierda"),
	
	//Listado Dedos {EnumDedosInternacional}
	TTL_DEDO_PULGAR("ttl_dedo_pulgar"),
	TTL_DEDO_INDICE("ttl_dedo_indice"),
	TTL_DEDO_CORAZON("ttl_dedo_corazon"),
	TTL_DEDO_ANULAR("ttl_dedo_anular"),
	TTL_DEDO_MENIQUE("ttl_dedo_menique"),
	
	//Gestion Senales Alerta
	TTL_GSA_VENTANA("ttl_gsa_ventana"),
	TTL_GSA_GRILLA_CODIGO("ttl_gsa_grilla_codigo"),
	TTL_GSA_GRILLA_SENAL_ALERTA("ttl_gsa_grilla_senal_alerta"),
	TTL_GSA_GRILLA_COMENTARIO("ttl_gsa_grilla_comentario"),
	
	//Seguro en el pago del giro internacional
	TTL_SPGI_VENTANA("ttl_spgi_ventana"),
	TTL_SPGI_PNL_BENEFICIARIO("ttl_spgi_pnl_beneficiario"),
	LBL_SPGI_TIPO_IDENTIFICACION("lbl_spgi_tipo_identificacion"),
	LBL_SPGI_IDENTIFICACION("lbl_spgi_identificacion"),
	LBL_SPGI_NOMBRE("lbl_spgi_nombre"),
	LBL_SPGI_TELEFONO("lbl_spgi_telefono"),
	LBL_SPGI_VALOR_PRIMA("lbl_spgi_valor_prima"),
	LBL_SPGI_VLR_PRIMA("lbl_spgi_vlr_prima"),
	LBL_SPGI_BENEFICIOS("lbl_spgi_beneficios",false),
	LBL_SPGI_NOTIFICACION("lbl_spgi_notificacion"),
	LBL_SPGI_VALOR_PROTEGIRO("lbl_spgi_valor_protegiro"),
	LBL_SPGI_VLR_PROTEGIRO("lbl_spgi_vlr_protegiro"),
	
	//Anulacion Seguro del giro internacional
	TTL_ASGI_VENTANA("ttl_asgi_ventana"),
	TTL_ASGI_PNL_INFO_REMESA("ttl_asgi_pnl_info_remesa"),
	LBL_ASGI_REFERENCIA_SEGURO("lbl_asgi_referencia_seguro"),
	LBL_ASGI_VALOR_GIRO("lbl_asgi_valor_giro"),
	
	//Seccion Envio Remesa Internacional
	LBL_PNL_COTIZAR_TIPO_DOC_REMITENTE("lbl_pnl_cotizar_tipo_doc_remitente"),
	LBL_PNL_COTIZAR_NUM_DOC_REMITENTE("lbl_pnl_cotizar_num_doc_remitente"),
	LBL_PNL_COTIZAR_OPCION_ENVIO_REMITENTE("lbl_pnl_cotizar_opcion_envio_remitente"),
	LBL_PNL_COTIZAR_PAIS_REMITENTE("lbl_pnl_cotizar_pais_remitente"),
	LBL_PNL_COTIZAR_MONTO_REMITENTE("lbl_pnl_cotizar_monto_remitente"),
	BTN_PNL_COTIZAR_BOTON_COTIZAR("btn_pnl_cotizar_boton_cotizar"),
	BTN_PNL_COTIZAR_BOTON_LIMPIAR("btn_pnl_cotizar_boton_limpiar"),
	TTL_EGI_GRILLA_TIPOS_ENVIO_CODIGO("ttl_egi_grilla_tipos_envio_codigo"),
	TTL_PNL_COTIZAR_INTERNACIONAL("ttl_pnl_cotizar_internacional"),
	TTL_EGI_GRILLA_TIPOS_ENVIO_DESCRIPCION("ttl_egi_grilla_tipos_envio_descripcion"),
	TTL_EGI_GRILLA_TIPOS_ENVIO_NOMBRE_OPCION("ttl_egi_grilla_tipos_envio_nombre_opcion"),
	TTL_EGI_GRILLA_TIPOS_ENVIO_MONEDA_RECIBE("ttl_egi_grilla_tipos_envio_moneda_recibe"),
	TTL_EGI_GRILLA_TIPOS_ENVIO_MONTO_RECIBE("ttl_egi_grilla_tipos_envio_monto_recibe"),
	TTL_EGI_GRILLA_TIPOS_ENVIO_TOTAL_ENVIO("ttl_egi_grilla_tipos_envio_total_envio"),
	TTL_EGI_GRILLA_TIPOS_ENVIO_TOTAL_COMISION("ttl_egi_grilla_tipos_envio_total_comision"),
	TTL_ENVIO_REMESA_INTERNACIONAL_VENTANA("ttl_envio_remesa_internacional_ventana"),
	TTL_EGI_TIPOS_ENVIO_INTERNACIONAL("ttl_egi_tipos_envio_internacional"),
	TTL_EGI_PNL_DOCUMENTO_AL_REVES("ttl_egi_pnl_documento_al_reves"),
	LBL_EGI_DOCUMENTO_AL_REVES("lbl_egi_documento_al_reves"),
	//Seccion Envio Remesa Internacional (FormaPanelBeneficiario)
	TTL_PNL_BENEFICIARIO_INTERNACIONAL("ttl_pnl_beneficiario_internacional"),
	LBL_PNL_BENEFICIARIO_NOMBRE("lbl_pnl_beneficiario_nombre"),
	LBL_PNL_BENEFICIARIO_APELLIDO("lbl_pnl_beneficiario_apellido"),
	CMB_PNL_BENEFICIARIO_NUMERALES_ENVIO("cmb_pnl_beneficiario_numerales_envio"),
	
	//Seccion Envio Remesa Internacional (FormaPanelTomaHuellaRemitenteInternacional)
	TTL_PNL_TOMA_HUELLA_INTERNACIONAL("ttl_pnl_toma_huella_internacional"),
	LBL_PNL_THREMITE_MANO("lbl_pnl_thremite_mano"),
	LBL_PNL_THREMITE_DEDO("lbl_pnl_thremite_dedo"),
	CMB_PNL_THREMITE_MANO("cmb_thremite_mano"),
	CMB_PNL_THREMITE_DEDO("cmb_thremite_dedo"),
	BTN_PNL_THREMITE_TOMA_HUELLA("btn_pnl_thremite_toma_huella"),
	BTN_PNL_THREMITE_TOMA_FOTO("btn_pnl_thremite_toma_foto"),
	
	//Tooltips cajas de texto envio remesa internacional
	TLT_ERI_DOCUMENTO_REMITENTE("tlt_eri_documento_remitente"),
	TLT_ERI_MONTO_ENVIO("tlt_eri_monto_envio"),
	TLT_ERI_NOMBRE_BENEFICIARIO("tlt_eri_nombre_beneficiario"),
	TLT_ERI_APELLIDO_BENEFICIARIO("tlt_eri_apellido_beneficiario"),
	TLT_ERI_BOTON_COTIZAR("tlt_eri_boton_cotizar"),
	TLT_ERI_BOTON_LIMPIAR("tlt_eri_boton_limpiar"),
	TLT_ERI_BOTON_SENALES_ALERTA("tlt_eri_boton_senales_alerta"),
	TLT_ERI_BOTON_FOTOS("tlt_eri_boton_fotos"),
	
	//Tooltips cajas de texto FormaActualizarCrearTerceroInternacional
	TLT_CATI_DOCUMENTO("tlt_cati_documento"),
	TLT_CATI_PRIMER_NOMBRE("tlt_cati_primer_nombre"),
	TLT_CATI_SEGUNDO_NOMBRE("tlt_cati_segundo_nombre"),
	TLT_CATI_PRIMER_APELLIDO("tlt_cati_primer_apellido"),
	TLT_CATI_SEGUNDO_APELLIDO("tlt_cati_segundo_apellido"),
	TLT_CATI_FECHA_NACIMIENTO("tlt_cati_fecha_nacimiento"),
	TLT_CATI_CIUDAD_NACIMIENTO("tlt_cati_ciudad_nacimiento"),
	TLT_CATI_TELEFONO_CELULAR("tlt_cati_telefono_celular"),
	TLT_CATI_DIRECCION("tlt_cati_direccion"),
	TLT_CATI_INGRESO_MENSUAL("tlt_cati_ingreso_mensual"),
	TLT_CATI_EGRESO_MENSUAL("tlt_cati_egreso_mensual"),
	TLT_CATI_ACTIVOS("tlt_cati_activos"),
	TLT_CATI_PASIVOS("tlt_cati_pasivos"),
	TLT_CATI_VALOR_INGRESOS("tlt_cati_valor_ingresos"),
	TLT_CATI_ENTIDAD("tlt_cati_entidad"),
	TLT_CATI_NRO_PRODUCTO("tlt_cati_nro_producto"),
	TLT_CATI_FECHA_EXPEDICION("tlt_cati_fecha_expedicion"),
	TLT_CATI_CIUDAD_EXPEDICION("tlt_cati_ciudad_expedicion"),
	TLT_CATI_VALOR_OTROS_INGRESOS("tlt_cati_valor_otros_ingresos"),
	TLT_CATI_DETALLE_OTROS_INGRESOS("tlt_cati_detalle_otros_ingresos"),
	TLT_CATI_BTN_PEPS("tlt_cati_btn_peps"),
	TLT_CATI_BTN_EMPRESA("tlt_cati_btn_empresa"),
	TLT_CATI_CORREO_ELECTRONICO("tlt_cati_correo_electronico"),
	
	//Tooltips FormaPropiedadesPepsInternacional
	TLT_PEP_NOMBRE_CONYUGUE("tlt_pep_nombre_conyugue"),
	TLT_PEP_NOMBRE_FAMILIAR_CONSANGUINIDAD("tlt_pep_nombre_familiar_consanguinidad"),
	TLT_PEP_NOMBRE_FAMILIAR_AFINIDAD("tlt_pep_nombre_familiar_afinidad"),
	TLT_PEP_NOMBRE_FAMILIAR_CIVIL("tlt_pep_nombre_familiar_civil"),
	
	
	//Listado de opciones de envio para giros internacionales {EnumOpcionesEnvioInternacional}
	TTL_OPCION_1("ttl_opcion_1"),
	TTL_OPCION_2("ttl_opcion_2"),
	TTL_OPCION_3("ttl_opcion_3"),
	
	//PropiedadesPeps
	TTL_PPS_GRILLA_PEPS_CODIGO("ttl_pps_grilla_peps_codigo"),
	TTL_PPS_GRILLA_PEPS_PROPIEDAD("ttl_pps_grilla_peps_propiedad"),
	TTL_PPS_GRILLA_PEPS_OBLIGATORIO("ttl_pps_grilla_peps_obligatorio"),
	TTL_PPS_GRILLA_PEPS_EJEMPLO("ttl_pps_grilla_peps_ejemplo"),
	TTL_PPS_GRILLA_PEPS_DETALLE("ttl_pps_grilla_peps_detalle"),
	TTL_PPS_FORMA_PROPIEDADES_PEPS("ttl_pps_forma_propiedades_peps",false),
	LBL_PPS_PREGUNTA_PEPS("lbl_pps_pregunta_peps",false),
	BTN_PPS_ACEPTAR("btn_pps_aceptar"),
	BTN_PPS_CANCELAR("btn_pps_cancelar"),
	LBL_PPS_MNT_INFORMACION_PEPS("lbl_pps_mnt_informacion_peps",false),
	
	LBL_FIG_VERSION_GIRO("lbl_fig_version_giro"),
	
	//Propiedades PEPS Internacional
	TTL_PPI_VENTANA("ttl_ppi_ventana"),
	TTL_PPI_PNL_CONYUGUE("ttl_ppi_pnl_conyugue"),
	TTL_PPI_PNL_FAMILIAR_CONSAGUINIDAD("ttl_ppi_pnl_familiar_consaguinidad"),
	TTL_PPI_PNL_FAMILIAR_AFINIDAD("ttl_ppi_pnl_familiar_afinidad"),
	TTL_PPI_PNL_FAMILIAR_CIVIL("ttl_ppi_pnl_familiar_civil"),
	CHK_PPI_CONYUGE("chk_ppi_conyuge"),
	LBL_PPI_NOMBRE_CONYUGE("lbl_ppi_nombre_conyuge"),
	TXT_PPI_NOMBRE_CONYUGE("txt_ppi_nombre_conyuge"),
	CHK_PPI_FAMILIAR_CONSAGUINIDAD("chk_ppi_familiar_consaguinidad"),
	LBL_PPI_NOMBRE_FAMILIAR_CONSAGUINIDAD("lbl_ppi_nombre_familiar_consaguinidad"),
	TXT_PPI_NOMBRE_FAMILIAR_CONSAGUINIDAD("txt_ppi_nombre_familiar_consaguinidad"),
	LBL_PPI_PARENTESCO_FAMILIAR_CONSAGUINIDAD("lbl_ppi_parentesco_familiar_consaguinidad"),
	CMB_PPI_PARENTESCO_FAMILIAR_CONSAGUINIDAD("cmb_ppi_parentesco_familiar_consaguinidad"),
	CHK_PPI_FAMILIAR_AFINIDAD("chk_ppi_familiar_afinidad"),
	LBL_PPI_NOMBRE_FAMILIAR_AFINIDAD("lbl_ppi_nombre_familiar_afinidad"),
	TXT_PPI_NOMBRE_FAMILIAR_AFINIDAD("txt_ppi_nombre_familiar_afinidad"),
	LBL_PPI_PARENTESCO_FAMILIAR_AFINIDAD("lbl_ppi_parentesco_familiar_afinidad"),
	CMB_PPI_PARENTESCO_FAMILIAR_AFINIDAD("cmb_ppi_parentesco_familiar_afinidad"),
	CHK_PPI_FAMILIAR_CIVIL("chk_ppi_familiar_civil"),
	LBL_PPI_NOMBRE_FAMILIAR_CIVIL("lbl_ppi_nombre_familiar_civil"),
	TXT_PPI_NOMBRE_FAMILIAR_CIVIL("txt_ppi_nombre_familiar_civil"),
	LBL_PPI_PARENTESCO_FAMILIAR_CIVIL("lbl_ppi_parentesco_familiar_civil"),
	CMB_PPI_PARENTESCO_FAMILIAR_CIVIL("cmb_ppi_parentesco_familiar_civil"),
	LBL_PPI_PARENTESCO_PADRE("lbl_ppi_parentesco_padre"),
	LBL_PPI_PARENTESCO_MADRE("lbl_ppi_parentesco_madre"),
	LBL_PPI_PARENTESCO_ABUELO("lbl_ppi_parentesco_abuelo"),
	LBL_PPI_PARENTESCO_NIETO("lbl_ppi_parentesco_nieto"),
	LBL_PPI_PARENTESCO_HERMANO("lbl_ppi_parentesco_hermano"),
	LBL_PPI_PARENTESCO_BISABUELO("lbl_ppi_parentesco_bisabuelo"),
	LBL_PPI_PARENTESCO_TIO("lbl_ppi_parentesco_tio"),
	LBL_PPI_PARENTESCO_SOBRINO("lbl_ppi_parentesco_sobrino"),
	LBL_PPI_PARENTESCO_PRIMO("lbl_ppi_parentesco_primo"),
	LBL_PPI_PARENTESCO_TIO_ABUELO("lbl_ppi_parentesco_abuelo"),
	LBL_PPI_PARENTESCO_HIJO("lbl_ppi_parentesco_hijo"),
	LBL_PPI_PARENTESCO_YERNO("lbl_ppi_parentesco_yerno"),
	LBL_PPI_PARENTESCO_NUERA("lbl_ppi_parentesco_nuera"),
	LBL_PPI_PARENTESCO_SUEGRO("lbl_ppi_parentesco_suegro"),
	LBL_PPI_PARENTESCO_HERMANO_CONYUGE("lbl_ppi_parentesco_hermano_conyuge"),
	LBL_PPI_PARENTESCO_HIJO_ESPOSO("lbl_ppi_parentesco_hijo_esposo"),
	LBL_PPI_PARENTESCO_ABUELO_CONYUGE("lbl_ppi_parentesco_abuelo_conyuge"),
	LBL_PPI_PARENTESCO_HIJO_ADOPTIVO("lbl_ppi_parentesco_hijo_adoptivo"),
	LBL_PPI_PARENTESCO_HIJO_ADOPTIVO_CONYUGUE("lbl_ppi_parentesco_hijo_adoptivo_conyuge"),
	
	//Grilla Operaciones Inusuales agregar transaccion asociada
	TTL_OII_GRILLA_TRX_ASOCIADAS_NUM_DOC_CLIENTE_USUARIO("ttl_oii_grilla_trx_asociadas_num_doc_cliente_usuario"),
	TTL_OII_GRILLA_TRX_ASOCIADAS_NUM_OPERACION("ttl_oii_grilla_trx_asociadas_num_operacion"),
	TTL_OII_GRILLA_TRX_ASOCIADAS_PRODUCTO("ttl_oii_grilla_trx_asociadas_producto"),
	TTL_OII_GRILLA_TRX_ASOCIADAS_CORRESPONSAL("ttl_oii_grilla_trx_asociadas_corresponsal"),
	TTL_OII_GRILLA_TRX_ASOCIADAS_TIPO_VINCULO("ttl_oii_grilla_trx_asociadas_tipo_vinculo"),
	
	//Productos internacionales para operaciones inusuales
	TTL_ENVIO_INTERNACIONAL("ttl_envio_internacional"),
	TTL_PAGO_INTERNACIONAL("ttl_pago_internacional"),
	
	//Moneda para operaciones inusuales
	TTL_MONEDA_DOLARES("ttl_moneda_dolar"),
	TTL_MONEDA_PESOS_COLOMBIANOS("ttl_moneda_pesos_colombianos"),
	
	//Tipos de vinculo operaciones insuales
	TTL_TIPO_VINCULO_1("ttl_tipo_vinculo_1"),
	TTL_TIPO_VINCULO_2("ttl_tipo_vinculo_2"),
	TTL_TIPO_VINCULO_3("ttl_tipo_vinculo_3"),
	TTL_TIPO_VINCULO_4("ttl_tipo_vinculo_4"),
	TTL_TIPO_VINCULO_5("ttl_tipo_vinculo_5"),
	TTL_TIPO_VINCULO_6("ttl_tipo_vinculo_6"),
	TTL_TIPO_VINCULO_7("ttl_tipo_vinculo_7"),
	TTL_TIPO_VINCULO_8("ttl_tipo_vinculo_8"),
	TTL_TIPO_VINCULO_9("ttl_tipo_vinculo_9"),
	TTL_TIPO_VINCULO_10("ttl_tipo_vinculo_10"),
	TTL_TIPO_VINCULO_11("ttl_tipo_vinculo_11"),
	TTL_TIPO_VINCULO_12("ttl_tipo_vinculo_12"),
	TTL_TIPO_VINCULO_13("ttl_tipo_vinculo_13"),
	TTL_TIPO_VINCULO_14("ttl_tipo_vinculo_14"),
	
	TTL_FOTOS_INFORMACION_CAPTURA("ttl_fotos_informacion_captura"),
	
	//PropiedadesAdmisionEnvioTirilla
	TTL_CRC_GRILLA_ADMENV_CODIGO("ttl_crc_grilla_admenv_codigo"),
	TTL_CRC_GRILLA_ADMENV_PROPIEDAD("ttl_crc_grilla_admenv_propiedad"),
	TTL_CRC_GRILLA_ADMENV_OBLIGATORIO("ttl_crc_grilla_admenv_obligatorio"),
	TTL_CRC_GRILLA_ADMENV_EJEMPLO("ttl_crc_grilla_admenv_ejemplo"),
	TTL_CRC_GRILLA_ADMENV_DETALLE("ttl_crc_grilla_admenv_detalle"),
	TTL_CRC_FORMA_PROPIEDADES_ADMENV("ttl_crc_forma_propiedades_admenv",false),
	LBL_CRC_PREGUNTA_ADMENV("lbl_crc_pregunta_admenv",false),
	BTN_CRC_ACEPTAR("btn_crc_aceptar"),
	BTN_CRC_CANCELAR("btn_crc_cancelar"),
	LBL_CRC_MNT_INFORMACION_ADMENV("lbl_crc_mnt_informacion_admenv",false),
	TLT_CRC_VALOR_PROPIEDAD("tlt_crc_valor_propiedad"),
	
	//Gico automatico
	TLT_GICO_AUTOMATICO("tlt_gico_automatico"),
	LBL_GICO_AUTOMATICO("lbl_gico_automatico",false),	
	
	
	//Declaracion Origenes de Fondo
	TTL_DOF_VENTANA("tlt_dof_respuesta"),
	TLT_DOF_RESPUESTA("txt_respuesta_dof"),
	LBL_DOF_PREGUNTA("lbl_dof_pregunta"),
	TLT_DOF_TXT_RESPUESTA("tlt_dof_txt_respuesta"),
	LBL_DOF_RESPUESTA("lbl_dof_respuesta"),
	
	
	//Normativa SARLAF
	TTL_NORMATIVA("ttl_normativa"),
	LBL_PNL_NORMATIVA_CONFIRMAR_FIJO("lbl_pnl_normativa_confirmar_fijo"),
	;
	
	/**
	 * @author: Hector Q-en-K
	 * @type: Atributo
	 * @name: etiqueta
	 * @description: etiqueta y/o identificador de propiedad
	 * @version: 05/03/2015
	 */
	private final String etiqueta;
	
	private final String separadorEspecial;
	
	private final boolean aplicaPresentacion;
	
	/**
	 * @author: Hector Q-en-K
	 * @type: Atributo
	 * @name: valor
	 * @description: valor de la propiedad
	 * @version: 05/03/2015
	 */
	private String valor;
	
	/**
	 * @author: Hector Q-en-K
	 * @type: Atributo
	 * @name: procesado
	 * @description: bandera que representa si una constante de enumerador ya fue 
	 * 				 procesada, con el objetivo de controlar y evitar un alto consumo 
	 * 				 innecesario 
	 * @version: 05/03/2015
	 */
	private boolean procesado;
	
	private final static String IDENTIFICADOR_ESPACIO = "<espacio>";
	
	/**
	 * @author: Hector Q-en-K
	 * @type: Constructor
	 * @name EnumEtiquetas
	 * @description: Constructor que ejecuta la inicializacion de valores y ejecucion de 
	 * 				 comportamientos inicales requeridos para la materializacion de las 
	 * 				 constantes de enumerador
	 * @param etiqueta: etiqueta y/o identificador de propiedad
	 * @version: 05/03/2015
	 */
	private EnumEtiquetas(String etiqueta, 
						  String separadorEspecial){
		
		this.etiqueta=etiqueta;
		this.separadorEspecial=separadorEspecial;
		this.aplicaPresentacion=true;
		this.procesado=false;
		
	}
	
	private EnumEtiquetas(String etiqueta, 
						  String separadorEspecial,
						  boolean aplicaPresentacion){

		this.etiqueta=etiqueta;
		this.separadorEspecial=separadorEspecial;
		this.aplicaPresentacion=aplicaPresentacion;
		this.procesado=false;

	}
	
	private EnumEtiquetas(String etiqueta){

		this.etiqueta=etiqueta;
		this.separadorEspecial=null;
		this.aplicaPresentacion=true;
		this.procesado=false;

	}
	
	private EnumEtiquetas(String etiqueta,
						  boolean aplicaPresentacion){

		this.etiqueta=etiqueta;
		this.separadorEspecial=null;
		this.aplicaPresentacion=aplicaPresentacion;
		this.procesado=false;

	}
	
	/**
	 * @author: Hector Q-en-K
	 * @type: Comportamiento (Metodo)
	 * @name validaProcesado
	 * @description: Metodo que valida si la constante de enumerador ya fue procesada, de no
	 * 				 ser asi, solicita cargar sus valores funcionales adicionales 
	 * @version: 05/03/2015
	 */
	private void validaProcesado()throws Exception{
		
		if(!this.procesado){
			this.cargar();
			this.procesado=true;
		}
	}
	
	/**
	 * @author: Hector Q-en-K
	 * @type: Comportamiento (Metodo)
	 * @name cargar
	 * @description: Metodo que solicita el cargue del valor de la propiedad asociada a la
	 * 				 etiqueta
	 * @version: 05/03/2015
	 */
	private void cargar()throws Exception{
		
		try{
			
			this.valor = EnumRecursosProperties.ETIQUETAS.getRsbRecurso().getString(this.getEtiqueta());
			this.valor = this.valor.replace(EnumEtiquetas.IDENTIFICADOR_ESPACIO, " ");
			
		}catch(Exception e){
			
			this.valor=etiqueta;
			throw e;
		}
	}
	
	/**
	 * Tratar de no usar este metodo, por temas de diciencia y mantenimiento no es conveniente agrupar 
	 * conjunto de etiquetas en una sola, ya que esto no permite facilitar la comparacion a nivel de 
	 * enumerador (equals)
	 */
	@Deprecated
	public String[] getValorArreglo()throws Exception{
		
		String lista[];
		
		this.validaProcesado();
		
		lista = this.getValor(false).split(this.getSeparadorEspecial());
		
		return lista;
		
	}
	
	public String getEtiqueta() {
		return etiqueta;
	}
	
	public String getValor(boolean pBooAdicionaDosPuntos,
						   String ...pArrStrParametros){
		
		String strValor;
		
		try{
		
			this.validaProcesado();
			
			strValor = this.valor;
			
			strValor = UtilidadesGiros.getInstance().procesarParametrosEnTexto(strValor, 
																			   pArrStrParametros);
			if(this.aplicaPresentacion){
				
				try{
				
					strValor = UtilidadesGiros.getInstance().aplicarPresentacion(strValor,
						     													 this.getSeparadorEspecial());
				}catch(Exception e){
					
					e.printStackTrace();
				}
			}
		
		}catch(Exception e){
			
			e.printStackTrace();
			strValor = this.valor;
		}
		
		if(pBooAdicionaDosPuntos){
			
			strValor += ":";
		}
		
		return strValor;
	}
	
	public void setValor(String pStrValor){
		
		this.procesado=true;
			
		pStrValor = pStrValor.replace(EnumEtiquetas.IDENTIFICADOR_ESPACIO, " ");
	
		this.valor = pStrValor;
	}

	public String getSeparadorEspecial() {
		return separadorEspecial;
	}

	public boolean isAplicaPresentacion() {
		return aplicaPresentacion;
	}
	
	public boolean isProcesado() {
		return this.procesado;
	}

	public void setProcesado(boolean pProcesado) {
		this.procesado = pProcesado;
	}
	
	@Override
	public String toString() {
		
		return this.getValor(false);
	}
	
}

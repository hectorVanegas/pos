package co.com.codesa.clienteposslimgiros.enumeraciones;

import java.awt.Rectangle;

import co.com.codesa.clienteposslim.enumeraciones.EstadoAplicacionEnum;
import co.com.codesa.clienteposslim.formas.FormaLogin;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.mensajes.Mensaje;

/**
 * ****************************************************************.
 * @author: Hector Q-en-K
 * @type: Enumerador
 * @name EnumDimensionesComponentes
 * @description: Clase enumerador que permite recuperar los valores 
 * 				 constantes parametrizados en el archivo de propiedades 
 * 				 dimensionesComponentesGiros.properties
 * @version: 05-03-2015
 * @copyright: Copyright  1998-2012 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public enum EnumDimensionesComponentes {
	
	//General
	GUI_FRM_GNR_FORMA("gui_frm_gnr_forma"),
	PNL_FRM_GNR_BARRA_HERRAMIENTAS("pnl_frm_gnr_barra_herramientas"),
	BTN_FRM_GNR_ACCIONES("btn_frm_gnr_acciones"),
	PNL_FRM_GNR_CUERPO_PLANTILLA("pnl_frm_gnr_cuerpo_plantilla"),
	PNL_FRM_GNR_CONTENIDO("pnl_frm_gnr_contenido"),
	IMG_BTN_CALENDARIO("img_btn_calendario"),
	
	//Inicio giros
	PNL_INI_CUERPO("pnl_ini_cuerpo"),
	PNL_INI_PIE_PAGINA("pnl_ini_pie_pagina"),
	IMG_INI_PRESENTACION("img_ini_presentacion",true),
	LBL_INI_VERSION("lbl_ini_version"),
	
	//Mensaje Alerta
	GUI_MSG_ALRT_VENTANA("gui_msg_alrt_ventana"),
	PNL_MSG_ALRT_CUERPO("pnl_msg_alrt_cuerpo"),
	PNL_MSG_ALRT_PIEPAGINA("pnl_msg_alrt_piepagina"),
	BTN_MSG_ALRT_ACEPTAR("btn_msg_alrt_aceptar"),
	SCP_MSG_ALRT_SCROLL_TEXTO_MENSAJE("scp_msg_alrt_scroll_texto_mensaje"),
	LBL_MSG_ALRT_MENSAJE("lbl_msg_alrt_mensaje"),
	LBL_MSG_ALRT_IMAGEN("lbl_msg_alrt_imagen"),
	BTN_MSG_ALRT_ACEPTAR_OPT("btn_msg_alrt_aceptar_opt"),
	BTN_MSG_ALRT_CANCELAR_OPT("btn_msg_alrt_cancelar_opt"),
	
	//Datos Adicionales
	SCP_PNL_DAT_ADI_GRILLA_DATOS_ADICIONALES("scp_pnl_dat_adi_grilla_datos_adicionales"),
	
	//Autenticacion
	GUI_AUT_VENTANA("gui_aut_ventana"),
	PNL_AUT_CUERPO("pnl_aut_cuerpo"),
	PNL_AUT_PIE_PAGINA("pnl_aut_pie_pagina"),
	LBL_AUT_USUARIO("lbl_aut_usuario"),
	TXT_AUT_USUARIO("txt_aut_usuario"),
	LBL_AUT_CONTRASENA("lbl_aut_contrasena"),
	PFI_AUT_CONTRASENA("pfi_aut_contrasena"),
	BTN_AUT_INGRESAR("btn_aut_ingresar"),
	BTN_AUT_SALIR("btn_aut_salir"),
	PGB_AUT_BARRA_PROGRESO("pgb_aut_barra_progreso"),
	LBL_AUT_PORCENTAJE_BARRA_PROGRESO("lbl_aut_porcentaje_barra_progreso"),
	LBL_AUT_ETIQUETA_PROGRESO("lbl_aut_etiqueta_progreso"),
	LBL_AUT_IMAGEN("lbl_aut_imagen"),
	LBL_AUT_VERSION("lbl_aut_version"),
	
	//Cambio de Contrasena
	GUI_CMB_CNTRSN_VENTANA("gui_cmb_cntrsn_ventana"),
	PNL_CMB_CNTRSN_CUERPO("pnl_cmb_cntrsn_cuerpo"),
	LBL_CMB_CNTRSN_USUARIO("lbl_cmb_cntrsn_usuario"),
	TXT_CMB_CNTRSN_USUARIO("txt_cmb_cntrsn_usuario"),
	LBL_CMB_CNTRSN_CONTRASENA_ANTERIOR("lbl_cmb_cntrsn_contrasena_anterior"),
	PFI_CMB_CNTRSN_CONTRASENA_ANTERIOR("pfi_cmb_cntrsn_contrasena_anterior"),
	LBL_CMB_CNTRSN_CONTRASENA_NUEVA("lbl_cmb_cntrsn_contrasena_nueva"),
	PFI_CMB_CNTRSN_CONTRASENA_NUEVA("pfi_cmb_cntrsn_contrasena_nueva"),
	LBL_CMB_CNTRSN_CONFIRMA_CONTRASENA("lbl_cmb_cntrsn_confirma_contrasena"),
	PFI_CMB_CNTRSN_CONFIRMA_CONTRASENA("pfi_cmb_cntrsn_confirma_contrasena"),
	
	//Reimpresiones
	GUI_RMP_VENTANA("gui_rmp_ventana"),
	PNL_RMP_ENCABEZADO("pnl_rmp_encabezado"),
	PNL_RMP_ENCABEZADO_GENERAL("pnl_rmp_encabezado_general"),
	PNL_RMP_CUERPO("pnl_rmp_cuerpo"),
	PNL_RMP_PIE_PAGINA("pnl_rmp_pie_pagina"),
	LBL_RMP_TIPO_REIMPRESION("lbl_rmp_tipo_reimpresion"),
	CMB_RMP_TIPO_REIMPRESION("cmb_rmp_tipo_reimpresion"),
	LBL_RMP_LISTA_REIMPRESIONES("lbl_rmp_lista_reimpresiones"),
	CMB_RMP_LISTA_REIMPRESIONES("cmb_rmp_lista_reimpresiones"),
	PNL_RMP_PARAMETROS("pnl_rmp_parametros"),
	SCP_RMP_GRILLA_RESULTADO("scp_rmp_grilla_resultado"),
	
	//Panel Encabezado: empresa - agencia - caja
	PNL_ENC_SECCION_XY_11("pnl_enc_seccion_xy_11"),
	PNL_ENC_SECCION_XY_12("pnl_enc_seccion_xy_12"),
	PNL_ENC_SECCION_XY_13("pnl_enc_seccion_xy_13"),
	PNL_ENC_SECCION_XY_21("pnl_enc_seccion_xy_21"),
	PNL_ENC_SECCION_XY_22("pnl_enc_seccion_xy_22"),
	PNL_ENC_SECCION_XY_23("pnl_enc_seccion_xy_23"),
	PNL_ENC_SECCION_XY_31("pnl_enc_seccion_xy_31"),
	PNL_ENC_SECCION_XY_32("pnl_enc_seccion_xy_32"),
	PNL_ENC_SECCION_XY_33("pnl_enc_seccion_xy_33"),
	
	//Panel Factura
	LBL_PNL_FACT_DOCUMENTO("lbl_pnl_fact_documento"),
	TXT_PNL_FACT_DOCUMENTO("txt_pnl_fact_documento"),
	TXT_PNL_FACT_PRODUCTO("txt_pnl_fact_producto"),
	LBL_PNL_FACT_NUMERO("lbl_pnl_fact_numero"),
	TXT_PNL_FACT_NUMERO("txt_pnl_fact_numero"),
	
	//Panel Territorio: Pais - Departamento - Municipio - Zona
	PNL_TERR_SECCION_XY_01("pnl_terr_seccion_xy_01"),
	PNL_TERR_SECCION_XY_02("pnl_terr_seccion_xy_02"),
	PNL_TERR_SECCION_XY_11("pnl_terr_seccion_xy_11"),
	PNL_TERR_SECCION_XY_12("pnl_terr_seccion_xy_12"),
	PNL_TERR_SECCION_XY_21("pnl_terr_seccion_xy_21"),
	PNL_TERR_SECCION_XY_22("pnl_terr_seccion_xy_22"),
	PNL_TERR_SECCION_XY_31("pnl_terr_seccion_xy_31"),
	PNL_TERR_SECCION_XY_32("pnl_terr_seccion_xy_32"),
	PNL_TERR_SECCION_XY_41("pnl_terr_seccion_xy_41"),
	PNL_TERR_SECCION_XY_42("pnl_terr_seccion_xy_42"),
	PNL_TERR_SECCION_XY_51("pnl_terr_seccion_xy_51"),
	PNL_TERR_SECCION_XY_52("pnl_terr_seccion_xy_52"),
	
	//Panel Tercero
	LBL_PNL_TERC_TERCERO("lbl_pnl_terc_tercero"),
	CMB_PNL_TERC_TIPO_IDENTIFICACION("cmb_pnl_terc_tipo_identificacion"),
	TXT_PNL_TERC_IDENTIFICACION("txt_pnl_terc_identificacion"),
	TXT_PNL_TERC_DESCRIPCION("txt_pnl_terc_descripcion"),
	BTN_PNL_TERC_MANTENIMIENTO("btn_pnl_terc_mantenimiento"),
	
	//Panel Caja Clave
	PFI_PCC_CAJA_PROTEGIDA("pfi_pcc_caja_protegida"),
	CHK_PCC_MOSTRAR_CONTENIDO_PROTEGIDO("chk_pcc_mostrar_contenido_protegido"),
	
	//Contenedor servicios adicionales
	PNL_CSA_CONTENEDOR("pnl_csa_contenedor"),
	
	//Panel Servicio Adicional
	PNL_SVA_SECCION("pnl_sva_seccion"),
	PNL_SVA_CHK_INCLUIR("pnl_sva_chk_incluir"),
	PNL_SVA_CMB_VALOR("pnl_sva_cmb_valor"),
	
	//Mantenimiento Tercero
	GUI_MNT_TERC_VENTANA("gui_mnt_terc_ventana"),
	PNL_MNT_TERC_CUERPO("pnl_mnt_terc_cuerpo"),
	PNL_MNT_TERC_PIE_PAGINA("pnl_mnt_terc_pie_pagina"),
	LBL_MNT_TERC_DOCUMENTO("lbl_mnt_terc_documento"),
	CMB_MNT_TERC_TIPO_IDENTIFICACION("cmb_mnt_terc_tipo_identificacion"),
	TXT_MNT_TERC_IDENTIFICACION("txt_mnt_terc_identificacion"),
	LBL_MNT_TERC_TIPO_PERSONA("lbl_mnt_terc_tipo_persona"),
	CMB_MNT_TERC_TIPO_PERSONA("cmb_mnt_terc_tipo_persona"),
	LBL_MNT_TERC_FECHA_NACIMIENTO("lbl_mnt_terc_fecha_nacimiento"),
	DTC_MNT_TERC_FECHA_NACIMIENTO("dtc_mnt_terc_fecha_nacimiento"),
	LBL_MNT_TERC_FECHA_ENTRADA_PAIS("lbl_mnt_terc_fecha_entrada_pais"),
	DTC_MNT_TERC_FECHA_ENTRADA_PAIS("dtc_mnt_terc_fecha_entrada_pais"),
	LBL_MNT_TERC_FECHA_VENCIMIENTO("lbl_mnt_terc_fecha_vencimiento"),
	DTC_MNT_TERC_FECHA_VENCIMIENTO("dtc_mnt_terc_fecha_vencimiento"),
	PNL_MNT_TERC_EXPEDICION("pnl_mnt_terc_expedicion"),
	LBL_MNT_TERC_FECHA_EXPEDICION("lbl_mnt_terc_fecha_expedicion"),
	DTC_MNT_TERC_FECHA_EXPEDICION("dtc_mnt_terc_fecha_expedicion"),
	LBL_MNT_TERC_PAIS_EXPEDICION("lbl_mnt_terc_pais_expedicion"),
	PNL_MNT_TERC_TERR_EXPEDICION("pnl_mnt_terc_terr_expedicion"),
	LBL_MNT_TERC_PRIMER_APELLIDO("lbl_mnt_terc_primer_apellido"),
	TXT_MNT_TERC_PRIMER_APELLIDO("txt_mnt_terc_primer_apellido"),
	LBL_MNT_TERC_SEGUNDO_APELLIDO("lbl_mnt_terc_segundo_apellido"),
	TXT_MNT_TERC_SEGUNDO_APELLIDO("txt_mnt_terc_segundo_apellido"),
	LBL_MNT_TERC_NOMBRES("lbl_mnt_terc_nombres"),
	TXT_MNT_TERC_NOMBRES("txt_mnt_terc_nombres"),
	PNL_MNT_TERC_DIR_DIRECCION("pnl_mnt_terc_dir_direccion"),
	LBL_MNT_TERC_PNL_DIR_ETIQUETA("lbl_mnt_terc_pnl_dir_etiqueta"),
	TXT_MNT_TERC_PNL_DIR_DESCRIPCION("txt_mnt_terc_pnl_dir_descripcion"),
	BTN_MNT_TERC_PNL_DIR_MANTENIMIENTO("btn_mnt_terc_pnl_dir_mantenimiento"),
	BTN_MNT_TERC_PNL_DIR_LIMPIAR("btn_mnt_terc_pnl_dir_limpiar"),
	LBL_MNT_TERC_TELEFONO("lbl_mnt_terc_telefono"),
	TXT_MNT_TERC_TELEFONO("txt_mnt_terc_telefono"),
	LBL_MNT_TERC_CELULAR("lbl_mnt_terc_celular"),
	TXT_MNT_TERC_CELULAR("txt_mnt_terc_celular"),
	LBL_MNT_TERC_CORREO_ELECTRONICO("lbl_mnt_terc_correo_electronico"),
	TXT_MNT_TERC_CORREO_ELECTRONICO("txt_mnt_terc_correo_electronico"),
	LBL_MNT_TERC_ACTIVIDAD_ECONOMICA("lbl_mnt_terc_actividad_economica"),
	CMB_MNT_TERC_ACTIVIDADES_ECONOMICAS("cmb_mnt_terc_actividades_economicas"),
	CHK_MNT_TERC_AUTO_RETENEDOR("chk_mnt_terc_auto_retenedor"),
	CMB_MNT_TERC_TERCERO_PEPS("cmb_mnt_terc_tercero_peps"),
	LBL_MNT_TERC_TERCERO_PEPS("lbl_mnt_terc_tercero_peps"),
	
	//Mantenimiento Tercero Internacional
	GUI_MNT_TERC_INT_VENTANA_USUARIO("gui_mnt_terc_int_ventana_usuario"),
	GUI_MNT_TERC_INT_VENTANA_CLIENTE("gui_mnt_terc_int_ventana_cliente"),
	PNL_MNT_TERC_INT_CUERPO("pnl_mnt_terc_int_cuerpo"),
	PNL_MNT_TERC_INT_PIE("pnl_mnt_terc_int_pie"),
	PNL_MNT_TERC_INT_DOCUMENTO("pnl_mnt_terc_int_documento"),
	LBL_MNT_TERC_INT_DOCUMENTO("lbl_mnt_terc_int_documento"),
	CMB_MNT_TERC_INT_TIPO_DOCUMENTO("cmb_mnt_terc_int_tipo_documento"),
	TXT_MNT_TERC_INT_NUMERO_DOCUMENTO("txt_mnt_terc_int_numero_documento"),
	LBL_MNT_TERC_INT_NOMBRES("lbl_mnt_terc_int_nombres"),
	TXT_MNT_TERC_INT_PRIMER_NOMBRE("txt_mnt_terc_int_primer_nombre"),
	TXT_MNT_TERC_INT_SEGUNDO_NOMBRE("txt_mnt_terc_int_segundo_nombre"),
	LBL_MNT_TERC_INT_APELLIDOS("lbl_mnt_terc_int_apellidos"),
	TXT_MNT_TERC_INT_PRIMER_APELLIDO("txt_mnt_terc_int_primer_apellido"),
	TXT_MNT_TERC_INT_SEGUNDO_APELLIDO("txt_mnt_terc_int_segundo_apellido"),
	PNL_MNT_TERC_INT_NACIMIENTO("pnl_mnt_terc_int_nacimiento"),
	LBL_MNT_TERC_INT_FECHA_NACIMIENTO("lbl_mnt_terc_int_fecha_nacimiento"),
	DTC_MNT_TERC_INT_FECHA_NACIMIENTO("dtc_mnt_terc_int_fecha_nacimiento"),
	LBL_MNT_TERC_INT_CIUDAD_NACIMIENTO("lbl_mnt_terc_int_ciudad_nacimiento"),
	TXT_MNT_TERC_INT_CIUDAD_NACIMIENTO("txt_mnt_terc_int_ciudad_nacimiento"),
	PNL_MNT_TERC_INT_CONTACTO("pnl_mnt_terc_int_contacto"),
	LBL_MNT_TERC_INT_TELEFONO_FIJO_CELULAR("lbl_mnt_terc_int_telefono_fijo_celular"),
	TXT_MNT_TERC_INT_TELEFONO_FIJO_CELULAR("txt_mnt_terc_int_telefono_fijo_celular"),
	PNL_MNT_TERC_INT_RESIDENCIA("pnl_mnt_terc_int_residencia"),
	PNL_MNT_TERC_INT_TERR_RESIDENCIA("pnl_mnt_terc_int_terr_residencia"),
	PNL_MNT_TERC_INT_DIR_DIRECCION("pnl_mnt_terc_int_dir_direccion"),
	LBL_MNT_TERC_INT_PNL_DIR_ETIQUETA("lbl_mnt_terc_int_pnl_dir_etiqueta"),
	TXT_MNT_TERC_INT_PNL_DIR_DESCRIPCION("txt_mnt_terc_int_pnl_dir_descripcion"),
	BTN_MNT_TERC_INT_PNL_DIR_MANTENIMIENTO("btn_mnt_terc_int_pnl_dir_mantenimiento"),
	BTN_MNT_TERC_INT_PNL_DIR_LIMPIAR("btn_mnt_terc_int_pnl_dir_limpiar"),
	PNL_MNT_TERC_INT_DEDO_BIOMETRIA_SELECCIONADO("pnl_mnt_terc_int_dedo_biometria_seleccionado"),
	PNL_MNT_TERC_INT_DATO_SOC_ECONO("pnl_mnt_terc_int_dato_soc_econo"),
	LBL_MNT_TERC_INT_VLR_INGRESO_MENSUAL("lbl_mnt_terc_int_vlr_ingreso_mensual"),
	LBL_MNT_TERC_INT_VLR_EGRESO_MENSUAL_ACTIVOS("lbl_mnt_terc_int_vlr_egreso_mensual_activos"),
	LBL_MNT_TERC_INT_VLR_ACTIVOS("lbl_mnt_terc_int_vlr_activos"),
	LBL_MNT_TERC_INT_VLR_PASIVOS("lbl_mnt_terc_int_vlr_pasivos"),
	TXT_MNT_TERC_INT_VLR_INGRESO_MENSUAL("txt_mnt_terc_int_vlr_ingreso_mensual"),
	TXT_MNT_TERC_INT_VLR_EGRESO_MENSUAL_ACTIVOS("txt_mnt_terc_int_vlr_egreso_mensual_activos"),
	TXT_MNT_TERC_INT_VLR_ACTIVOS("txt_mnt_terc_int_vlr_activos"),
	TXT_MNT_TERC_INT_VLR_PASIVOS("txt_mnt_terc_int_vlr_pasivos"),
	LBL_MNT_TERC_INT_ACTV_ECONOMICAS("lbl_mnt_terc_int_actv_economicas"),
	LBL_MNT_TERC_INT_PROFESION("lbl_mnt_terc_int_profesion"),
	CMB_MNT_TERC_INT_ACTV_ECONOMICAS("cmb_mnt_terc_int_actv_economicas"),
	CMB_MNT_TERC_INT_PROFESION("cmb_mnt_terc_int_profesion"),
	BTN_MNT_TERC_INT_EMPRESA_SOC_ECONO("btn_mnt_terc_int_empresa_soc_econo"),
	LBL_MNT_TERC_INT_OPER_MONEDA_EXTRANJERA("lbl_mnt_terc_int_oper_moneda_extranjera"),
	LBL_MNT_TERC_INT_VALOR_INGRESO("lbl_mnt_terc_int_valor_ingreso"),
	LBL_MNT_TERC_INT_MONEDA_EXTRANJERA("lbl_mnt_terc_int_moneda_extranjera"),
	LBL_MNT_TERC_INT_ENTIDAD_EXTRANJERA("lbl_mnt_terc_int_entidad_extranjera"),
	LBL_MNT_TERC_INT_NUMERO_PRODUCTO_EXT("lbl_mnt_terc_int_numero_producto_ext"),
	CMB_MNT_TERC_INT_MANEJA_OPER_MONEDA_EXTR("cmb_mnt_terc_int_maneja_oper_moneda_extr"),
	CMB_MNT_TERC_INT_OPERACIONES_MONEDA_EXTR("cmb_mnt_terc_int_operaciones_moneda_extr"),
	TXT_MNT_TERC_INT_VLR_INGRESO_EXTR("txt_mnt_terc_int_vlr_ingreso_extr"),
	CMB_MNT_TERC_INT_MONEDA_EXTRANJERA("cmb_mnt_terc_int_moneda_extranjera"),
	TXT_MNT_TERC_INT_ENTIDAD_EXTRANJERA("txt_mnt_terc_int_entidad_extranjera"),
	TXT_MNT_TERC_INT_NUMERO_PRODUCTO("txt_mnt_terc_int_numero_producto"),
	PNL_MNT_TERC_INT_EXPEDICION("pnl_mnt_terc_int_expedicion"),
	LBL_MNT_TERC_INT_FECHA_EXPEDICION("lbl_mnt_terc_int_fecha_expedicion"),
	DTC_MNT_TERC_INT_FECHA_EXPEDICION("dtc_mnt_terc_int_fecha_expedicion"),
	LBL_MNT_TERC_INT_CIUDAD_EXPEDICION("lbl_mnt_terc_int_ciudad_expedicion"),
	TXT_MNT_TERC_INT_CIUDAD_EXPEDICION("txt_mnt_terc_int_ciudad_expedicion"),
	PNL_MNT_TERC_INT_DATOS_COMPLEMENTARIOS("pnl_mnt_terc_int_datos_complementarios"),
	LBL_MNT_TERC_INT_PEPS("lbl_mnt_terc_int_peps"),
	CMB_MNT_TERC_INT_PEPS("cmb_mnt_terc_int_peps"),
	BTN_MNT_TERC_INT_VER_PEPS("btn_mnt_terc_int_ver_peps"),
	LBL_MNT_TERC_INT_VLR_OTROS_INGRESOS("lbl_mnt_terc_int_vlr_otros_ingresos"),
	TXT_MNT_TERC_INT_VLR_OTROS_INGRESOS("txt_mnt_terc_int_vlr_otros_ingresos"),
	LBL_MNT_TERC_INT_DETALLE_OTROS_INGRESOS("lbl_mnt_terc_int_detalle_otros_ingresos"),
	TXT_MNT_TERC_INT_DETALLE_OTROS_INGRESOS("txt_mnt_terc_int_detalle_otros_ingresos"),
	PNL_MNT_TERC_INT_DATOS_EMPRESA_DATADD("pnl_mnt_terc_int_datos_empresa_datadd"),
	LBL_MNT_TERC_INT_NOMBRE_EMPRESA_DATADD("lbl_mnt_terc_int_nombre_empresa_datadd"),
	TXT_MNT_TERC_INT_NOMBRE_EMPRESA_DATADD("txt_mnt_terc_int_nombre_empresa_datadd"),
	LBL_MNT_TERC_INT_DIRECCION_EMPRESA_DATADD("lbl_mnt_terc_int_direccion_empresa_datadd"),
	TXT_MNT_TERC_INT_DIRECCION_EMPRESA_DATADD("txt_mnt_terc_int_direccion_empresa_datadd"),
	LBL_MNT_TERC_INT_TELEFONO_EMPRESA_DATADD("lbl_mnt_terc_int_telefono_empresa_datadd"),
	TXT_MNT_TERC_INT_TELEFONO_EMPRESA_DATADD("txt_mnt_terc_int_telefono_empresa_datadd"),
	LBL_MNT_TERC_INT_CIUDAD_EMPRESA_DATADD("lbl_mnt_terc_int_ciudad_empresa_datadd"),
	TXT_MNT_TERC_INT_CIUDAD_EMPRESA_DATADD("txt_mnt_terc_int_ciudad_empresa_datadd"),
	LBL_MNT_TERC_INT_CARGO_EMPRESA_DATADD("lbl_mnt_terc_int_cargo_empresa_datadd"),
	TXT_MNT_TERC_INT_CARGO_EMPRESA_DATADD("txt_mnt_terc_int_cargo_empresa_datadd"),
	LBL_MNT_TERC_INT_CORREO_ELECTRONICO("lbl_mnt_terc_int_correo_electronico"),
	TXT_MNT_TERC_INT_CORREO_ELECTRONICO("txt_mnt_terc_int_correo_electronico"),
	
	//Panel Direccion
	LBL_PNL_DIR_ETIQUETA("lbl_pnl_dir_etiqueta"),
	TXT_PNL_DIR_DESCRIPCION("txt_pnl_dir_descripcion"),
	BTN_PNL_DIR_MANTENIMIENTO("btn_pnl_dir_mantenimiento"),
	BTN_PNL_DIR_LIMPIAR("btn_pnl_dir_limpiar"),
	
	//Diligenciar Direccion
	GUI_DIR_VENTANA("gui_dir_ventana"),
	PNL_DIR_CUERPO("pnl_dir_cuerpo"),
	LBL_DIR_CLASES_VIA("lbl_dir_clases_via"),
	CMB_DIR_CLASES_VIA("cmb_dir_clases_via"),
	TXT_DIR_ESPECIFICACION_ABIERTA("txt_dir_especificacion_abierta"),
	PNL_DIR_ESPECIFICACION("pnl_dir_especificacion"),
	PNL_DIR_DIRECCION_TRADICIONAL("pnl_dir_direccion_tradicional"),
	LBL_DIR_ESPECIFICACIONES_DIRECCION_TRADICIONAL("lbl_dir_especificaciones_direccion_tradicional"),
	TXT_DIR_NUMERO_VIA("txt_dir_numero_via"),
	LBL_DIR_SEPARADOR_INTERSECCION_VIA("lbl_dir_separador_interseccion_via"),
	TXT_DIR_NUMERO_INTERSECCION("txt_dir_numero_interseccion"),
	LBL_DIR_SEPARADOR_LUGAR_INTERSECCION("lbl_dir_separador_lugar_interseccion"),
	TXT_DIR_NUMERO_LUGAR("txt_dir_numero_lugar"),
	PNL_DIR_UBICACION("pnl_dir_ubicacion"),
	LBL_DIR_ZONAS_UBICACION("lbl_dir_zonas_ubicacion"),
	CMB_DIR_ZONAS_UBICACION("cmb_dir_zonas_ubicacion"),
	PNL_DIR_LUGAR("pnl_dir_lugar"),
	LBL_DIR_CARACTERISTICAS_LUGAR("lbl_dir_caracteristicas_lugar"),
	CMB_DIR_CARACTERISTICAS_LUGAR("cmb_dir_caracteristicas_lugar"),
	LBL_DIR_ESPECIFICACION_LUGAR("lbl_dir_especificacion_lugar"),
	TXT_DIR_ESPECIFICACION_LUGAR("txt_dir_especificacion_lugar"),
	LBL_DIR_NOMBRE_BARRIO("lbl_dir_nombre_barrio"),
	TXT_DIR_NOMBRE_BARRIO("txt_dir_nombre_barrio"),
	LBL_DIR_ESTRATOS_BARRIO("lbl_dir_estratos_barrio"),
	CMB_DIR_ESTRATOS_BARRIO("cmb_dir_estratos_barrio"),
	LBL_DIR_ESPECIFICACION_ABIERTA("lbl_dir_especificacion_abierta"),
	CMB_DIR_DEPARTAMENTO_NOMBRE("cmb_dir_departamento_nombre"),
	CMB_DIR_MUNICIPIO_NOMBRE("cmb_dir_municipio_nombre"),
	PNL_DIR_BARRIO("pnl_dir_barrio"),
	PNL_DIR_DEPARTAMENTO("pnl_dir_departamento"),
	PNL_DIR_MUNICIPIO("pnl_dir_municipio"),
	PNL_DIR_CODIGO_POSTAL("pnl_dir_codigo_postal"),
	LBL_DIR_NOMBRE_DEPARTAMENTO("lbl_dir_nombre_departamento"),
	LBL_DIR_NOMBRE_MUNICIPIO("lbl_dir_nombre_municipio"),
	LBL_DIR_CODIGO_POSTAL("lbl_dir_codigo_postal"),
	TXT_DIR_CODIGO("txt_dir_codigo"),
	
	
	
	//Apertura Caja
	GUI_APC_VENTANA("gui_apc_ventana"),
	PNL_APC_ENCABEZADO("pnl_apc_encabezado"),
	PNL_APC_ENCABEZADO_GENERAL("pnl_apc_encabezado_general"),
	PNL_APC_CUERPO("pnl_apc_cuerpo"),
	SCP_APC_SCROLL_GRILLA("scp_apc_scroll_grilla"),
	
	//Cierre Caja
	GUI_CC_VENTANA("gui_cc_ventana"),
	PNL_CC_ENCABEZADO("pnl_cc_encabezado"),
	PNL_CC_ENCABEZADO_GENERAL("pnl_cc_encabezado_general"),
	PNL_CC_CUERPO("pnl_cc_cuerpo"),
	SCP_CC_SCROLL_GRILLA("scp_cc_scroll_grilla"),
	
	//Arqueo Caja
	GUI_AQC_VENTANA("gui_aqc_ventana"),
	PNL_AQC_ENCABEZADO("pnl_aqc_encabezado"),
	PNL_AQC_CUERPO("pnl_aqc_cuerpo"),
	PNL_AQC_BILLETES("pnl_aqc_billetes"),
	LBL_AQC_LISTA_BILLETES("lbl_aqc_lista_billetes"),
	CMB_AQC_LISTA_BILLETES("cmb_aqc_lista_billetes"),
	LBL_AQC_CANTIDAD_MONTO_BILLETES("lbl_aqc_cantidad_monto_billetes"),
	TXT_AQC_CANTIDAD_MONTO_BILLETES("txt_aqc_cantidad_monto_billetes"),
	BTN_AQC_INGRESAR_CANT_MONTO_BILLETES("btn_aqc_ingresar_cant_monto_billetes"),
	IMG_BTN_AQC_INGRESAR_CANT_MONTO_BILLETES("img_btn_aqc_ingresar_cant_monto_billetes"),
	SCP_AQC_SCROLL_GRILLA_DENOMINACOIN_BILLETES("scp_aqc_scroll_grilla_denominacion_billetes"),
	BTN_AQC_ELIMINAR_REGISTRO_BILLETES("btn_aqc_eliminar_registro_billetes"),
	IMG_BTN_AQC_ELIMINAR_REGISTRO_BILLETES("img_btn_aqc_eliminar_registro_billetes"),
	PNL_AQC_MONEDAS("pnl_aqc_monedas"),
	SCP_AQC_SCROLL_GRILLA_DENOMINACOIN_MONEDAS("scp_aqc_scroll_grilla_denominacion_monedas"),
	LBL_AQC_LISTA_MONEDAS("lbl_aqc_lista_monedas"),
	LBL_AQC_CANTIDAD_MONTO_MONEDAS("lbl_aqc_cantidad_monto_monedas"),
	CMB_AQC_LISTA_MONEDAS("cmb_aqc_lista_monedas"),
	TXT_AQC_CANTIDAD_MONTO_MONEDAS("txt_aqc_cantidad_monto_monedas"),
	BTN_AQC_INGRESAR_CANT_MONTO_MONEDAS("btn_aqc_ingresar_cant_monto_monedas"),
	IMG_BTN_AQC_INGRESAR_CANT_MONTO_MONEDAS("img_btn_aqc_ingresar_cant_monto_monedas"),
	BTN_AQC_ELIMINAR_REGISTRO_MONEDAS("btn_aqc_eliminar_registro_monedas"),
	IMG_BTN_AQC_ELIMINAR_REGISTRO_MONEDAS("img_btn_aqc_eliminar_registro_monedas"),
	PNL_AQC_CHEQUES("pnl_aqc_cheques"),
	SCP_AQC_SCROLL_GRILLA_CHEQUES("scp_aqc_scroll_grilla_cheques"),
	LBL_AQC_LISTA_CHEQUES("lbl_aqc_lista_cheques"),
	LBL_AQC_VALOR_CHEQUE("lbl_aqc_valor_cheque"),
	BTN_AQC_INGRESAR_CHEQUE("btn_aqc_ingresar_cheque"),
	IMG_BTN_AQC_INGRESAR_CHEQUE("img_btn_aqc_ingresar_cheque"),
	BTN_AQC_ELIMINAR_REGISTRO_CHEQUES("btn_aqc_eliminar_registro_cheques"),
	IMG_BTN_AQC_ELIMINAR_REGISTRO_CHEQUES("img_btn_aqc_eliminar_registro_cheques"),
	CMB_AQC_LISTA_CHEQUES("cmb_aqc_lista_cheques"),
	TXT_AQC_VALOR_CHEQUE("txt_aqc_valor_cheque"),
	PNL_AQC_VALES("pnl_aqc_vales"),
	SCP_AQC_SCROLL_GRILLA_VALES("scp_aqc_scroll_grilla_vales"),
	BTN_AQC_INGRESAR_VALE("btn_aqc_ingresar_vale"),
	IMG_BTN_AQC_INGRESAR_VALE("img_btn_aqc_ingresar_vale"),
	BTN_AQC_ELIMINAR_REGISTRO_VALES("btn_aqc_eliminar_registro_vales"),
	IMG_BTN_AQC_ELIMINAR_REGISTRO_VALES("img_btn_aqc_eliminar_registro_vales"),
	CMB_AQC_LISTA_VALES("cmb_aqc_lista_vales"),
	LBL_AQC_VALOR_VALE("lbl_aqc_valor_vale"),
	LBL_AQC_LISTA_VALES("lbl_aqc_lista_vales"),
	TXT_AQC_VALOR_VALE("txt_aqc_valor_vale"),
	PNL_AQC_DAT_ADI_CHEQUE("pnl_aqc_dat_adi_cheque"),
	LBL_AQC_FECHA_CHEQUE("lbl_aqc_fecha_cheque"),
	DTC_AQC_FECHA_CHEQUE("dtc_aqc_fecha_cheque"),
	LBL_AQC_BANCO_CHEQUE("lbl_aqc_banco_cheque"),
	TXT_AQC_BANCO_CHEQUE("txt_aqc_banco_cheque"),
	LBL_AQC_NUMERO_CHEQUE("lbl_aqc_numero_cheque"),
	LBL_AQC_GIRADOR_CHEQUE("lbl_aqc_girador_cheque"),
	TXT_AQC_NUMERO_CHEQUE("txt_aqc_numero_cheque"),
	TXT_AQC_GIRADOR_CHEQUE("txt_aqc_girador_cheque"),
	PNL_AQC_DAT_ADI_VALE("pnl_aqc_dat_adi_vale"),
	LBL_AQC_FECHA_VALE("lbl_aqc_fecha_vale"),
	DTC_AQC_FECHA_VALE("dtc_aqc_fecha_vale"),
	LBL_AQC_NUMERO_VALE("lbl_aqc_numero_vale"),
	TXT_AQC_NUMERO_VALE("txt_aqc_numero_vale"),
	LBL_AQC_CONCEPTO_VALE("lbl_aqc_concepto_vale"),
	TXT_AQC_CONCEPTO_VALE("txt_aqc_concepto_vale"),
	TXA_AQC_NOTAS("txa_aqc_notas"),
	LBL_AQC_NOTAS("lbl_aqc_notas"),
	PNL_AQC_CUADRE_CAJA("pnl_aqc_cuadre_caja"),
	LBL_AQC_TOTAL_CAJA("lbl_aqc_total_caja"),
	TXT_AQC_TOTAL_CAJA("txt_aqc_total_caja"),
	LBL_AQC_EN_ARQUEO("lbl_aqc_en_arqueo"),
	TXT_AQC_EN_ARQUEO("txt_aqc_en_arqueo"),
	LBL_AQC_TOTAL_DIFERENCIA("lbl_aqc_total_diferencia"),
	TXT_AQC_TOTAL_DIFERENCIA("txt_aqc_total_diferencia"),
	LBL_AQC_TOTAL_X_BILLETES("lbl_aqc_total_x_billetes"),
	TXT_AQC_TOTAL_X_BILLETES("txt_aqc_total_x_billetes"),
	LBL_AQC_TOTAL_X_MONEDAS("lbl_aqc_total_x_monedas"),
	TXT_AQC_TOTAL_X_MONEDAS("txt_aqc_total_x_monedas"),
	LBL_AQC_TOTAL_X_CHEQUES("lbl_aqc_total_x_cheques"),
	TXT_AQC_TOTAL_X_CHEQUES("txt_aqc_total_x_cheques"),
	LBL_AQC_TOTAL_X_VALES("lbl_aqc_total_x_vales"),
	TXT_AQC_TOTAL_X_VALES("txt_aqc_total_x_vales"),
	
	//Panel Consulta
	LBL_BUS_BUSQUEDA_POR("lbl_bus_busqueda_por"),
	CMB_BUS_BUSQUEDA("jcb_bus_busqueda"),
	TXT_BUS_REFERENCIA("txt_bus_referencia"),
	TXT_BUS_IDENTIFICACION("txt_bus_identificacion"),
	CHK_BUS_DESTINATARIO("chk_bus_destinatario"),
	CHK_BUS_REMITENTE("chk_bus_remitente"),
	LBL_BUS_FECHA_FINAL("lbl_bus_fecha_fin"),
	LBL_BUS_FECHA_INICIAL("lbl_bus_fecha_ini"),
	DTC_BUS_FECHA_FINAL("dtc_bus_fecha_fin"),
	DTC_BUS_FECHA_INICIAL("dtc_bus_fecha_ini"),
	CMB_BUS_TIPO_IDENTIFICACION("jcb_bus_tipo_documento"),
	CHK_BUS_EXTERNO("chk_bus_externo"),
	
	//Ayuda
	GUI_AYU_VENTANA("gui_ayu_ventana"),
	PNL_AYU_CUERPO("pnl_ayu_cuerpo"),
	PNL_AYU_OPERACIONES("pnl_ayu_operaciones"),
	SCP_AYU_OPERACIONES("scp_ayu_operaciones"),
	PNL_AYU_CONTROL_AYUDAS("pnl_ayu_control_ayudas"),
	SCP_AYU_PRESENTACION("scp_ayu_presentacion"),
	PNL_AYU_AYUDA_VACIA("pnl_ayu_ayuda_vacia"),
	LBL_AYU_MENSAJE_AYUDA_VACIA("lbl_ayu_mensaje_ayuda_vacia"),
	LBL_AYU_IMAGEN_ADVERTENCIA("lbl_ayu_imagen_advertencia"),
	BTN_AYU_ATRAS("btn_ayu_atras"),
	BTN_AYU_ADELANTE("btn_ayu_adelante"),
	
	//Ayuda SuperCombo -rmv
	//Comision cajero
	PNL_AYU_SCM_COMI_CAJERO("pnl_ayu_scm_comi_cajero"),
	PNL_AYU_SCM_COMI_CAJERO_TITULO("pnl_ayu_scm_comi_cajero_titulo"),
	PNL_AYU_SCM_COMI_CAJERO_RESUMEN("pnl_ayu_scm_comi_cajero_resumen"),
	LBL_AYU_SCM_COMI_CAJERO_TITULO("lbl_ayu_scm_comi_cajero_titulo"),
	LBL_AYU_SCM_COMI_CAJERO_IMG_PROMO("lbl_ayu_scm_comi_cajero_img_promo"),
	LBL_AYU_SCM_COMI_CAJERO_IMG_LOGO("lbl_ayu_scm_comi_cajero_img_logo"),
	LBL_AYU_SCM_COMI_CAJERO_RESUMEN("lbl_ayu_scm_comi_cajero_resumen"),
	//Captar Cliente
	PNL_AYU_SCM_CAPTAR_CLIENTE("pnl_ayu_scm_captar_cliente"),
	PNL_AYU_SCM_CAPTAR_CLIENTE_TITULO("pnl_ayu_scm_captar_cliente_titulo"),
	PNL_AYU_SCM_CAPTAR_CLIENTE_RESUMEN("pnl_ayu_scm_captar_cliente_resumen"),
	LBL_AYU_SCM_CAPTAR_CLIENTE_TITULO("lbl_ayu_scm_captar_cliente_titulo"),
	LBL_AYU_SCM_CAPTAR_CLIENTE_TT_DIGAME("lbl_ayu_scm_captar_cliente_tt_digame"),
	LBL_AYU_SCM_CAPTAR_CLIENTE_PREGUNTELE("lbl_ayu_scm_captar_cliente_preguntele"),
	LBL_AYU_SCM_CAPTAR_CLIENTE_PESITOS("lbl_ayu_scm_captar_cliente_pesitos"),
	LBL_AYU_SCM_CAPTAR_CLIENTE_DESEA("lbl_ayu_scm_captar_cliente_desea"),
	LBL_AYU_SCM_CAPTAR_CLIENTE_IMG_ACEPTA("lbl_ayu_scm_captar_cliente_img_acepta"),
	LBL_AYU_SCM_CAPTAR_CLIENTE_IMG_RECHAZA("lbl_ayu_scm_captar_cliente_img_rechaza"),
	LBL_AYU_SCM_CAPTAR_CLIENTE_DEPENDIENDO("lbl_ayu_scm_captar_cliente_dependiendo"),
	//Validar Telefono
	PNL_AYU_SCM_VAL_TELEFONO("pnl_ayu_scm_val_telefono"),
	PNL_AYU_SCM_VAL_TELEFONO_TITULO("pnl_ayu_scm_val_telefono_titulo"),
	PNL_AYU_SCM_VAL_TELEFONO_RESUMEN("pnl_ayu_scm_val_telefono_resumen"),
	LBL_AYU_SCM_VAL_TELEFONO_TITULO("lbl_ayu_scm_val_telefono_titulo"),
	LBL_AYU_SCM_VAL_TELEFONO_VALIDE("lbl_ayu_scm_val_telefono_valide"),
	LBL_AYU_SCM_VAL_TELEFONO_MENSAJES("lbl_ayu_scm_val_telefono_mensajes"),
	LBL_AYU_SCM_VAL_TELEFONO_TEL_REM("lbl_ayu_scm_val_telefono_tel_rem"),
	LBL_AYU_SCM_VAL_TELEFONO_TEL_DES("lbl_ayu_scm_val_telefono_tel_des"),
	TXT_AYU_SCM_VAL_TELEFONO_TEL_REM("txt_ayu_scm_val_telefono_tel_rem"),
	TXT_AYU_SCM_VAL_TELEFONO_TEL_DES("txt_ayu_scm_val_telefono_tel_des"),
	//Impresiones
	PNL_AYU_SCM_IMPRESIONES("pnl_ayu_scm_impresiones"),
	PNL_AYU_SCM_IMPRESIONES_RESUMEN("pnl_ayu_scm_impresiones_resumen"),
	LBL_AYU_SCM_IMPRESIONES_FINALICE("lbl_ayu_scm_impresiones_finalice"),
	BTN_AYU_SCM_IMPRESIONES_ACEPTAR("btn_ayu_scm_impresiones_aceptar"),
	LBL_AYU_SCM_IMPRESIONES_IMPRIMEN("lbl_ayu_scm_impresiones_imprimen"),
	//Lineas Telefonos
	PNL_AYU_SCM_TELE_LINEAS("pnl_ayu_scm_tele_lineas"),
	PNL_AYU_SCM_TELE_LINEAS_RESUMEN("pnl_ayu_scm_tele_lineas_resumen"),
	LBL_AYU_SCM_TELE_LINEAS_EFECTIVO("lbl_ayu_scm_tele_lineas_efectivo"),
	//Validar Telefono
	PNL_AYU_SCM_RECUERDE("pnl_ayu_scm_recuerde"),
	PNL_AYU_SCM_RECUERDE_TITULO("pnl_ayu_scm_recuerde_titulo"),
	PNL_AYU_SCM_RECUERDE_RESUMEN("pnl_ayu_scm_recuerde_resumen"),
	LBL_AYU_SCM_RECUERDE_TITULO("lbl_ayu_scm_recuerde_titulo"),
	LBL_AYU_SCM_RECUERDE_ANULA("lbl_ayu_scm_recuerde_anula"),
		
	//Consulta Giro Nacional
	FRM_CGN_VENTANA("frm_cgn_ventana"),
	PNL_CGN_ENCABEZADO("pnl_cgn_encabezado"),
	PNL_CGN_CUERPO("pnl_cgn_cuerpo"),
	PNL_CGN_PIE_PAGINA("pnl_cgn_pie_pagina"),
	PNL_CGN_BUSQUEDA("pnl_cgn_busqueda"),
	PNL_CGN_ENCABEZADO_GENERAL("pnl_cgn_encabezado_general"),
	SCP_CGN_GIROS_CONSULTADOS("scp_cgn_giros_consultados"),
	
	//Pago Giro
	GUI_PG_VENTANA("gui_pg_ventana"),
	PNL_PG_ENCABEZADO("pnl_pg_encabezado"),
	PNL_PG_CUERPO("pnl_pg_cuerpo"),
	PNL_PG_PIE_PAGINA("pnl_pg_pie_pagina"),
	PNL_PG_ENCABEZADO_GENERAL("pnl_pg_encabezado_general"),
	PNL_PG_ENCABEZADO_FACTURA("pnl_pg_encabezado_factura"),
	LBL_PG_REFERENCIA("lbl_pg_referencia"),
	TXT_PG_REFERENCIA("txt_pg_referencia"),
	PNL_PG_TERR_AGENCIA_PAGO("pnl_pg_terr_agencia_pago"),
	PNL_PG_TERR_AGENCIA_ORIGEN("pnl_pg_terr_agencia_origen"),
	PNL_PG_TERR_AGENCIA_DESTINO("pnl_pg_terr_agencia_destino"),
	PNL_PG_TERC_TERCERO_ORIGEN("pnl_pg_terc_tercero_origen"),
	PNL_PG_TERC_TERCERO_DESTINO("pnl_pg_terc_tercero_destino"),
	PNL_PG_TERC_TERCERO_APODERADO("pnl_pg_terc_tercero_apoderado"),
	LBL_PG_CONCEPTOS("lbl_pg_conceptos"),
	SCP_PG_SCROLL_GRILLA_CONCEPTOS("scp_pg_scroll_grilla_conceptos"),
	LBL_PG_NUMERO_ITEMS("lbl_pg_numero_items"),
	TXT_PG_NUMERO_ITEMS("txt_pg_numero_items"),
	LBL_PG_TOTAL_X_ITEMS("lbl_pg_total_x_items"),
	TXT_PG_TOTAL_X_ITEMS("txt_pg_total_x_items"),
	LBL_PG_PROMOCIONES("lbl_pg_promociones"),
	SCP_PG_SCROLL_GRILLA_PROMOCIONES("scp_pg_scroll_grilla_promociones"),
	CHK_PG_INCLU_APODERADO("chk_pg_inclu_apoderado"),
	LBL_PG_NOTAS("lbl_pg_notas"),
	SCP_PG_SCROLL_AREA_TEXTO_NOTAS("scp_pg_scroll_area_texto_notas"),
	
	//Solicitud Autorizaciones Transacciones
	GUI_SAT_VENTANA("gui_sat_ventana"),
	PNL_SAT_ENCABEZADO("pnl_sat_encabezado"),
	PNL_SAT_CUERPO("pnl_sat_cuerpo"),
	PNL_SAT_PIE_PAGINA("pnl_sat_pie_pagina"),
	PNL_SAT_ENCABEZADO_GENERAL("pnl_sat_encabezado_general"),
	PNL_SAT_ENCABEZADO_FACTURA("pnl_sat_encabezado_factura"),
	LBL_SAT_LISTA_SOLICITUDES("lbl_sat_lista_solicitudes"),
	CMB_SAT_LISTA_SOLICITUDES("cmb_sat_lista_solicitudes"),
	LBL_SAT_REFERENCIA("lbl_sat_referencia"),
	TXT_SAT_REFERENCIA("txt_sat_referencia"),
	PNL_SAT_TERR_AGENCIA_PAGO("pnl_sat_terr_agencia_pago"),
	PNL_SAT_TERR_AGENCIA_ORIGEN("pnl_sat_terr_agencia_origen"),
	PNL_SAT_TERR_AGENCIA_DESTINO("pnl_sat_terr_agencia_destino"),
	PNL_SAT_TERC_TERCERO_ORIGEN("pnl_sat_terc_tercero_origen"),
	PNL_SAT_TERC_TERCERO_DESTINO("pnl_sat_terc_tercero_destino"),
	PNL_SAT_TERC_TERCERO_NUEVO("pnl_sat_terc_tercero_nuevo"),
	LBL_SAT_LISTA_ANOTACIONES("lbl_sat_lista_anotaciones"),
	CMB_SAT_LISTA_ANOTACIONES("cmb_sat_lista_anotaciones"),
	PNL_SAT_NOTAS("pnl_sat_notas"),
	SCP_SAT_SCROLL_AREA_TEXTO_NOTAS("scp_sat_scroll_area_texto_notas"),
	PNL_SAT_NOTAS_ADICIONALES("pnl_sat_notas_adicionales"),
	SCP_SAT_SCROLL_AREA_TEXTO_NOTAS_ADICIONALES("scp_sat_scroll_area_texto_notas_adicionales"),
	SCP_SAT_SERVICIOS_ADICIONALES("scp_sat_servicios_adicionales"),
	
	//Operaciones inusuales internacionales
	FRM_OII_VENTANA("frm_oii_ventana"),
	JPN_OII_PANEL_ENCABEZADO("jpn_oii_panel_encabezado"),
	JPN_OII_PANEL_CUERPO("jpn_oii_panel_cuerpo"),
	JPN_OII_PANEL_PIE("jpn_oii_panel_pie"),
	JPN_OII_PANEL_TIPO_DOCUMENTO("jpn_oii_panel_tipo_documento"),
	CMB_OII_PNL_TIPO_DOCUMENTO("cmb_oii_pnl_tipo_documento"),
	PNL_OII_CUERPO_DOCUMENTO("pnl_oii_cuerpo_documento"),
	PNL_OII_PANEL_DOCUMENTO("pnl_oii_panel_documento"),
	PNL_OII_PANEL_DOCUMENTO_TERCERO("pnl_oii_panel_documento_tercero"),

	PNL_OII_CUERPO_PRODTRANSACCION("pnl_oii_cuerpo_prodtransaccion"),
	PNL_OII_PANEL_PRODTRANSACCION("pnl_oii_panel_prodtransaccion"),
	PNL_OII_PANEL_PRODTRANSACCION_INTERNO("pnl_oii_panel_prodtransaccion_interno"),
	PNL_OII_PANEL_SENALES_ALERTA("pnl_oii_panel_senales_alerta"),
	PNL_OII_PANEL_EXISTE_TRANSACCION("pnl_oii_panel_existe_transaccion"),
	
	
	LBL_OII_PNL_TIPO_DOCUMENTO("lbl_oii_pnl_tipo_documento"),
	LBL_OII_PNL_DOCUMENTO("lbl_oii_pnl_documento"),
	TXT_OII_PNL_DOCUMENTO("txt_oii_pnl_documento"),
	LBL_OII_PNL_CAMPOS_OBLIGATORIOS("lbl_oii_pnl_campos_obligatorios"),
	
	LBL_OII_PNL_PRODUCTO("lbl_oii_pnl_producto"),
	CMB_OII_PNL_PRODUCTO("cmb_oii_pnl_producto"),
	LBL_OII_PNL_CORRESPONSAL("lbl_oii_pnl_corresponsal"),
	CMB_OII_PNL_CORRESPONSAL("cmb_oii_pnl_corresponsal"),
	LBL_OII_PNL_NOOPERACION("lbl_oii_pnl_nooperacion"),
	TXT_OII_PNL_NOOPERACION("txt_oii_pnl_nooperacion"),
	LBL_OII_PNL_VALOROPERACION("lbl_oii_pnl_valoroperacion"),
	TXT_OII_PNL_VALOROPERACION("txt_oii_pnl_valoroperacion"),
	LBL_OII_PNL_MONEDA("lbl_oii_pnl_moneda"),
	CMB_OII_PNL_MONEDA("cmb_oii_pnl_moneda"),
	
	PNL_OII_PANEL_SENALES_ALERTA_INTERNO("pnl_oii_panel_senales_alerta_interno"),
	GRI_OII_GRID_SENALES_ALERTA("gri_oii_grid_senales_alerta"),
    LBL_OII_PNL_SENAL_ALERTA("lbl_oii_pnl_senal_alerta"),
	
    //existe transaccion
    PNL_OII_PANEL_EXISTE_TRANSACCION_INT("pnl_oii_panel_existe_transaccion_int"),
    LBL_OII_PNL_DOC_CLI_USUARIO("lbl_oii_pnl_doc_cli_usuario"),
    TXT_OII_PNL_DOC_CLI_USUARIO("txt_oii_pnl_doc_cli_usuario"),
    LBL_OII_PNL_NO_OPERACION("lbl_oii_pnl_no_operacion"),
    TXT_OII_PNL_NO_OPERACION("txt_oii_pnl_no_operacion"),
    LBL_OII_PNL_TE_PRODUCTO("lbl_oii_pnl_te_producto"),
    CMB_OII_PNL_TE_PRODUCTO("cmb_oii_pnl_te_producto"),
    LBL_OII_PNL_TE_CORRESPONSAL("lbl_oii_pnl_te_corresponsal"),
    CMB_OII_PNL_TE_CORRESPONSAL("cmb_oii_pnl_te_corresponsal"),
    LBL_OII_PNL_TIPO_VINCULO("lbl_oii_pnl_tipo_vinculo"),
    CMB_OII_PNL_TIPO_VINCULO("cmb_oii_pnl_tipo_vinculo"),
    BTN_OII_PNL_TE_AGREGAR("btn_oii_pnl_te_agregar"),
    BTN_OII_PNL_TE_ELIMINAR("btn_oii_pnl_te_eliminar"),
    GRI_OII_GRID_EXISTE_TRANSACCION("gri_oii_grid_existe_transaccion"),
    
    
	
	//Envio giro postal
	FRM_EGP_VENTANA("frm_egp_ventana"),
	JPN_EGP_PANEL_ENCABEZADO("jpn_egp_panel_encabezado"),
	JPN_EGP_PANEL_CUERPO("jpn_egp_panel_cuerpo"),
	JPN_EGP_PANEL_PIE("jpn_egp_panel_pie"),
	JPN_EGP_PANEL_EMPRESACAJA("jpn_egp_panel_empresacaja"),
	JPN_EGP_PANEL_DOCFACTNUM("jpn_egp_panel_docfactnum"),
	LBL_EGP_AGENCIA_ORG("lbl_egp_agencia_org"),
	LBL_EGP_AGENCIA_DES("lbl_egp_agencia_des"),
	LBL_EGP_VALOR_GIRAR("lbl_egp_valor_girar"),
	LBL_EGP_PLAN_TARIFARIO("lbl_egp_plan_tarifario"),
	JPN_EGP_PANEL_AGENCIA_ORG("jpn_egp_panel_agencia_org"),
	JPN_EGP_PANEL_AGENCIA_DES("jpn_egp_panel_agencia_des"),
	JPN_EGP_PANEL_TERCERO_ORG("jpn_egp_panel_tercero_org"),
	JPN_EGP_PNL_TERC_ORG_DESC("jpn_egp_pnl_terc_org_desc"),
	JPN_EGP_PNL_TERC_ORG_MTO("jpn_egp_pnl_terc_org_mto"),
	JPN_EGP_PANEL_TERCERO_DES("jpn_egp_panel_tercero_des"),
	JPN_EGP_PNL_TERC_DES_DESC("jpn_egp_pnl_terc_des_desc"),
	JPN_EGP_PNL_TERC_DES_MTO("jpn_egp_pnl_terc_des_mto"),
	JPN_EGP_PANEL_TERCERO_TRA("jpn_egp_panel_tercero_tra"),
	JPN_EGP_PNL_TERC_TRA_DESC("jpn_egp_pnl_terc_tra_desc"),
	JPN_EGP_PNL_TERC_TRA_MTO("jpn_egp_pnl_terc_tra_mto"),
	TXT_EGP_VALOR_GIRO("txt_egp_valor_giro"),
	TXT_EGP_COD_PLANT("txt_egp_cod_plant"),
	TXT_EGP_DES_PLANT("txt_egp_des_plant"),
	CHK_EGP_INCLU_FLETE("chk_egp_inclu_flete"),
	CHK_EGP_INCLU_OTROS("chk_egp_inclu_otros"),
	CHK_EGP_DOMICILIO("chk_egp_domicilio"),
	CHK_EGP_INCLU_DOMICILIO("chk_egp_inclu_domicilio"),
	GRI_EGP_GRID_CONCEPTOS("gri_egp_grid_conceptos"),
	LBL_EGP_NUMER_ITEMS("lbl_egp_numero_items"),
	TXT_EGP_NUMER_ITEMS("txt_egp_numero_items"),
	LBL_EGP_TOTAL("lbl_egp_total"),
	TXT_EGP_TOTAL("txt_egp_numero_total"),
	LBL_EGP_MSG_PREDETERMINADO("lbl_egp_msg_predeterminado"),
	CMB_EGP_MSG_PREDETERMINADO("cmb_egp_msg_predeterminado"),
	LBL_EGP_PROMOCIONES("lbl_egp_promociones"),
	GRI_EGP_GRID_PROMO("gri_egp_grid_promo"),
	SCR_EGP_LIST_CONVENIO("scr_egp_list_convenio"),
	LBL_EGP_CONVENIOS("lbl_egp_convenios"),
	BTN_EGP_COTIZAR_GIRO("btn_egp_cotizar_giro"),
	LBL_EGP_COTIZAR_GIRO("lbl_egp_cotizar_giro"),
	CHK_EGP_INCLU_TRAMITADOR("chk_egp_inclu_tramitador"),
	
	//Movimientos Caja
	GUI_MVC_VENTANA("frm_mvc_ventana"),
	PNL_MVC_ENCABEZADO("jpn_mvc_panel_encabezado"),
	PNL_MVC_CUERPO("pnl_mvc_cuerpo"),
	PNL_MVC_PIE_PAGINA("pnl_mvc_pie_pagina"),
	PNL_MVC_ENCABEZADO_GENERAL("jpn_mvc_panel_empresacaja"),
	SCP_MVC_SERVICIOS_ADICIONALES("scp_mvc_servicios_adicionales"),
	LBL_MVC_VALOR_PAGAR("lbl_mvc_valor_pagar"),
	TXT_MVC_VALOR_PAGAR("txt_mvc_valor_pagar"),
	BTN_MVC_ADICIONAR_MEDIO_PAGO("btn_mvc_adicionar_medio_pago"),
	IMG_BTN_MVC_ADICIONAR_MEDIO_PAGO("img_btn_mvc_adicionar_medio_pago"),
	BTN_MVC_ELIMINAR_MEDIO_PAGO("btn_mvc_eliminar_medio_pago"),
	IMG_BTN_MVC_ELIMINAR_MEDIO_PAGO("img_btn_mvc_eliminar_medio_pago"),
	BTN_MVC_EDITAR_MEDIO_PAGO("btn_mvc_editar_medio_pago"),
	IMG_BTN_MVC_EDITAR_MEDIO_PAGO("img_btn_mvc_editar_medio_pago"),
	SCP_MVC_GRILLA_MEDIOS_PAGO("scp_mvc_grilla_medios_pago"),
	LBL_MVC_TOTAL_MOVIMIENTO("lbl_mvc_total_movimiento"),
	LBL_MVC_CAMBIO("lbl_mvc_cambio"),
	TXT_MVC_TOTAL_MOVIMIENTO("txt_mvc_total_movimiento"),
	TXT_MVC_TOTAL_FALTANTE("txt_mvc_total_faltante"),
	
	//Diligenciar Medio de Pago
	GUI_DMP_VENTANA("gui_dmp_ventana"),
	PNL_DMP_CUERPO("pnl_dmp_cuerpo"),
	LBL_DMP_MEDIO_PAGO("lbl_dmp_medio_pago"),
	CMB_DMP_LISTA_MEDIOS_PAGO("cmb_dmp_lista_medios_pago"),
	LBL_DMP_VALOR_MEDIO_PAGO("lbl_dmp_valor_medio_pago"),
	TXT_DMP_VALOR_MEDIO_PAGO("txt_dmp_valor_medio_pago"),
	SCP_DMP_GRILLA_DAT_ADI_MEDPAGO("scp_dmp_grilla_dat_adi_medpago"),
	
	//facturacion giro
	FRM_FCG_VENTANA("frm_fcg_ventana"),
	JPN_FCG_PANEL_ENCABEZADO("jpn_fcg_panel_encabezado"),
	LBL_FCG_VALOR("lbl_fcg_valor"),
	TXT_FCG_VALOR_GIRO("txt_fcg_valor_giro"),
	LBL_FCG_RECIBIDO("lbl_fcg_recibido"),
	TXT_FCG_RECIBIDO("txt_fcg_recibido"),
	LBL_FCG_CAMBIO("lbl_fcg_cambio"),
	TXT_FCG_CAMBIO("txt_fcg_cambio"),
	
	//Registro Tercero Tramitador
	FRM_RTT_VENTANA("frm_rtt_ventana"),
	JPN_RTT_PANEL_ENCABEZADO("jpn_rtt_panel_encabezado"),
	JPN_RTT_PANEL_TERCERO_TRAMI("jpn_rtt_panel_tercero_trami"),
	
	//Seccion Consulta movimientos caja  giros
	FRM_MCG_VENTANA("frm_mcg_ventana"),
	PNL_MCG_PANEL_ENCABEZADO("pnl_mcg_panel_encabezado"),
	PNL_MCG_PANEL_PIE("pnl_mcg_panel_pie"),
	PNL_MCG_PANEL_CUERPO("pnl_mcg_panel_cuerpo"),
	PNL_MCG_PANEL_ENCABEZADOGRAL("pnl_mcg_panel_encabezadogral"),
	LBL_MCG_BUSQUEDA("lbl_mcg_busqueda"),
	DTC_MCG_FECHA_BUS("dtc_mcg_fecha_bus"),
	SCP_MCG_GRID_SALDOSMEDIOPAGO("scp_mcg_grid_saldosmediopago"),
	PNL_MCG_SALDOSMEDIOPAGO("pnl_mcg_saldosmediopago"),
	PNL_MCG_DETALLE_MOVIMIENTOS("pnl_mcg_detalle_movimientos"),
	SCP_MCG_GRID_DETALLE_MOVIMIENTOS("scp_mcg_detalle_movimientos"),
	PNL_MCG_TOTAL_X_CONCEPTO("pnl_mcg_total_x_concepto"),
	SCP_MCG_GRID_TOTAL_X_CONCEPTO("scp_mcg_total_x_concepto"),
	
	//Convenio sedes
	FRM_CVS_VENTANA("frm_cvs_ventana"),
	PNL_CVS_ENCABEZADO("jpn_cvs_panel_encabezado"),
	PNL_CVS_TERRI_CONV_SEDE("pnl_cvs_terri_conv_sede"),
	GRI_CVS_SEDES("gri_cvs_sedes"),
	
	//Consulta movimientos provisiones
	FRM_CMP_VENTANA("frm_cmp_ventana"),
	PNL_CMP_PANEL_ENCABEZADO("pnl_cmp_panel_encabezado"),
	PNL_CMP_PANEL_PIE("pnl_cmp_panel_pie"),
	PNL_CMP_PANEL_CUERPO("pnl_cmp_panel_cuerpo"),
	PNL_CMP_PANEL_ENCABEZADOGRAL("pnl_cmp_panel_encabezadogral"),
	LBL_CMP_BUSQUEDA("lbl_cmp_busqueda"),
	DTC_CMP_FECHA_BUS("dtc_cmp_fecha_bus"),
	SCP_CMP_MOVIMIENTOS_PROVISIONES("scp_cmp_movimientos_provisiones"),
	PNL_CMP_TOTAL_CONCEPTO("pnl_cmp_total_concepto"),
	PNL_CMP_TOTAL_MONEDA("pnl_cmp_total_moneda"),
	SCP_CMP_TOTAL_CONCEPTO("scp_cmp_total_concepto"),
	SCP_CMP_TOTAL_MONEDA("scp_cmp_total_moneda"),
	
	//Provision Caja
	FRM_PVC_VENTANA("frm_pvc_ventana"),
	PNL_PVC_PANEL_ENCABEZADO("pnl_pvc_panel_encabezado"),
	PNL_PVC_PANEL_CUERPO("pnl_pvc_panel_cuerpo"),
	PNL_PVC_PANEL_PIE("pnl_pvc_panel_pie"),
	PNL_PVC_ENCABEZADOGRAL("pnl_pvc_encabezadogral"),
	JPN_PVC_PANEL_AGENCIA_ORG("jpn_pvc_panel_agencia_org"),
	LBL_PVC_CONCEPTO_EGRESO("lbl_pvc_concepto_egreso"),
	CMB_PVC_CONCEPTO_EGRESO("cmb_pvc_concepto_egreso"),
	LBL_PVC_VALOR_EGRESO("lbl_pvc_valor_egreso"),
	TXT_PVC_VALOR_EGRESO("txt_pvc_valor_egreso"),
	LBL_PVC_MEDIO_PAGO("lbl_pvc_medio_pago"),
	CMB_PVC_MEDIO_PAGO("cmb_pvc_medio_pago"),
	LBL_PVC_DOCUMENTO_AUXILIAR("lbl_pvc_documento_auxiliar"),
	TXT_PVC_DOCUMENTO_AUXILIAR("txt_pvc_documento_auxiliar"),
	LBL_PVC_NOTAS_EGRESO("lbl_pvc_notas_egreso"),
	SCP_PVC_NOTAS_EGRESO("scp_pvc_notas_egreso"),
	JPN_PVC_PANEL_AGENCIA_DES("jpn_pvc_panel_agencia_des"),
	LBL_PVC_CONCEPTO_INGRESO("lbl_pvc_concepto_ingreso"),
	CMB_PVC_CONCEPTO_INGRESO("cmb_pvc_concepto_ingreso"),
	LBL_PVC_AGENCIA_DESTINO("lbl_pvc_agencia_destino"),
	CMB_PVC_AGENCIA_DESTINO("cmb_pvc_agencia_destino"),
	LBL_PVC_CAJA_DESTINO("lbl_pvc_caja_destino"),
	CMB_PVC_CAJA_DESTINO("cmb_pvc_caja_destino"),
	LBL_PVC_VALOR_INGRESO("lbl_pvc_valor_ingreso"),
	TXT_PVC_VALOR_INGRESO("txt_pvc_valor_ingreso"),
	LBL_PVC_NOTAS_INGRESO("lbl_pvc_notas_ingreso"),
	SCP_PVC_NOTAS_INGRESO("scp_pvc_notas_ingreso"),
	
	//Consulta Documentos Pendientes
	GUI_CDP_VENTANA("gui_cdp_ventana"),
	PNL_CDP_PANEL_ENCABEZADO("pnl_cdp_panel_encabezado"),
	PNL_CDP_PANEL_CUERPO("pnl_cdp_panel_cuerpo"),
	PNL_CDP_ENCABEZADO_GENERAL("pnl_cdp_encabezado_general"),
	LBL_DCP_TIPO_OPERACION("lbl_dcp_tipo_operacion"),
	CMB_DCP_TIPO_OPERACION("cmb_dcp_tipo_operacion"),
	SCP_CDP_GRILLA_CONSULTA("scp_cdp_grilla_consulta"),
	
	//Rechazo Documentos Pendientes
	GUI_RDP_VENTANA("gui_rdp_ventana"),
	PNL_RDP_PANEL_CUERPO("pnl_rdp_panel_cuerpo"),
	PNL_RDP_PANEL_PIE_PAGINA("pnl_rdp_panel_pie_pagina"),
	PNL_RDP_ENCABEZADO_GENERAL_ORIGEN("pnl_rdp_encabezado_general_origen"),
	PNL_RDP_ENCABEZADO_GENERAL_DESTINO("pnl_rdp_encabezado_general_destino"),
	LBL_RDP_REFERENCIA("lbl_rdp_referencia"),
	TXT_RDP_REFERENCIA("txt_rdp_referencia"),
	TXA_RDP_NOTAS("txa_rdp_notas"),
	LBL_RDP_CONCEPTO("lbl_rdp_concepto"),
	CMB_RDP_LISTA_CONCEPTOS("cmb_rdp_lista_conceptos"),
	LBL_RDP_MEDIO_PAGO("lbl_rdp_medio_pago"),
	CMB_RDP_LISTA_MEDIOS_PAGO("cmb_rdp_lista_medios_pago"),
	LBL_RDP_VALOR("lbl_rdp_valor"),
	TXT_RDP_VALOR("txt_rdp_valor"),
	LBL_RDP_RAZON("lbl_rdp_razon"),
	CMB_RDP_LISTA_RAZON("cmb_rdp_lista_razon"),
	LBL_RDP_NOTAS("lbl_rdp_notas"),
	LBL_RDP_AGENCIA_DESTINO("lbl_rdp_agencia_destino"),
	TXT_RDP_CODIGO_AGENCIA_DESTINO("txt_rdp_codigo_agencia_destino"),
	TXT_RDP_DESCRIPCION_AGENCIA_DESTINO("txt_rdp_descripcion_agencia_destino"),
	LBL_RDP_CAJA_DESTINO("lbl_rdp_caja_destino"),
	TXT_RDP_CODIGO_CAJA_DESTINO("txt_rdp_codigo_caja_destino"),
	TXT_RDP_DESCRIPCION_CAJA_DESTINO("txt_rdp_descripcion_caja_destino"),
	
	//Confirmar Documentos Pendientes
	GUI_ADP_VENTANA("gui_adp_ventana"),
	PNL_ADP_PANEL_CUERPO("pnl_adp_panel_cuerpo"),
	PNL_ADP_ENCABEZADO_GENERAL_DESTINO("pnl_adp_encabezado_general_destino"),
	LBL_ADP_REFERENCIA("lbl_adp_referencia"),
	TXT_ADP_REFERENCIA("txt_adp_referencia"),
	LBL_ADP_CONCEPTO("lbl_adp_concepto"),
	CMB_ADP_LISTA_CONCEPTOS("cmb_adp_lista_conceptos"),
	LBL_ADP_MEDIO_PAGO("lbl_adp_medio_pago"),
	CMB_ADP_LISTA_MEDIOS_PAGO("cmb_adp_lista_medios_pago"),
	LBL_ADP_VALOR("lbl_adp_valor"),
	TXT_ADP_VALOR("txt_adp_valor"),
	LBL_ADP_NOTAS("lbl_adp_notas"),
	TXA_ADP_NOTAS("txa_adp_notas"),
	PNL_ADP_SECCION_NOTAS_ADICIONALES("pnl_adp_seccion_notas_adicionales"),
	LBL_ADP_NOTA_ADICIONAL("lbl_adp_nota_adicional"),
	TXA_ADP_NOTA_ADICIONAL("txa_adp_nota_adicional"),
	
	// Seccion Configurar Tipo Impresora
	FRM_CTI_VENTANA("frm_cti_ventana"),
	PNL_CTI_PANEL_ENCABEZADO("pnl_cti_panel_encabezado"),
	PNL_CTI_PANEL_CUERPO("pnl_cti_panel_cuerpo"),
	RBT_CTI_TMU("rbt_cti_tmu"),
	RBT_CTI_MC("rbt_cti_mc"),
	LBL_CTI_TMU("lbl_cti_tmu"),
	LBL_CTI_MC("lbl_cti_mc"),
	RBT_CTI_SOCKET("rbt_cti_socket"),
	RBT_CTI_NO_SOCKET("rbt_cti_no_socket"),
	TXT_CTI_NOMBRE_IMPRESORA_TMU("txt_cti_nombre_impresora_tmu"),
	TXT_CTI_NOMBRE_IMPRESORA_MC("txt_cti_nombre_impresora_mc"),
	BTN_CTI_PAGINA_PRUEBA("btn_cti_pagina_prueba"),
		
	//Seccion Reimpresion
	PNL_REIM_ENCABEZADO("pnl_reim_encabezado"),
	PNL_REIM_ENCABEZADO_C("pnl_reim_encabezado_c"),
	PNL_REIM_ENCABEZADO_CIERRRE("pnl_apc_encabezado_cierre"),
	LBL_RMP_DETREIMP("lbl_rmp_detreimp"),
	LBL_RMP_RMP("lbl_rmp_rmp"),
	LBL_ID_TERC("lbl_id_terc"),
	LBL_ID_PRIMA("lbl_vlr_prima"),
	LBL_ID_HURTO("lbl_vlr_hurto"),
	LBL_ID_ACC("lbl_vlr_acc"),
	
	
	//Seccion Enrolar tercero
	FRM_ETC_VENTANA("frm_etc_ventana"),
	PNL_ETC_PANEL_ENCABEZADO("pnl_etc_panel_encabezado"),
	JPN_ETC_PANEL_TERCERO("jpn_etc_panel_tercero"),
	JPN_ETC_PNL_TERC_LBL("jpn_etc_pnl_terc_lbl"),
	JPN_ETC_PNL_TERC_TIID("jpn_etc_pnl_terc_tiid"),
	JPN_ETC_PNL_TERC_IDEN("jpn_etc_pnl_terc_iden"),
	JPN_ETC_PNL_TERC_DESC("jpn_etc_pnl_terc_desc"),
	JPN_ETC_PNL_TERC_MTO("jpn_etc_pnl_terc_mto"),
	LBL_ETC_HUELLA_DERECHA("lbl_etc_huella_derecha"),
	BTN_ETC_HUELLA_DERECHA("btn_etc_huella_derecha"),
	LBL_ETC_HUELLA_DER_EXITO("lbl_etc_huella_der_exito"),
	LBL_ETC_HUELLA_IZQUIERDA("lbl_etc_huella_izquierda"),
	BTN_ETC_HUELLA_IZQUIERDA("btn_etc_huella_izquierda"),
	LBL_ETC_HUELLA_IZQ_EXITO("lbl_etc_huella_izq_exito"),
	
	//Seccion lector 2D
	FRM_LECTOR_VENTANA("frm_lector_ventana"),
	PNL_LECTOR_PANEL_ENCABEZADO("pnl_lector_panel_encabezado"),
	PNL_LECTOR_PANEL_CUERPO("pnl_lector_panel_cuerpo"),
	PNL_LECTOR_PANEL_PIE_PAGINA("pnl_lector_panel_pie_pagina"),
	TXA_LECTOR_MENSAJE("txa_lector_mensaje"),
	TXA_LECTOR_DATO("txa_lector_dato"),
	LBL_LECTOR_IMAGEN("lbl_lector_imagen"),
	TXA_LECTOR_MENSAJE_ALERTA("txa_lector_mensaje_alerta"),
	
	//Seccion SuperCombo Origen
	FRM_SCO_VENTANA("frm_sco_ventana"),
	PNL_SCO_PANEL_ENCABEZADO("pnl_sco_panel_encabezado"),
	PNL_SCO_PANEL_CUERPO("pnl_sco_panel_cuerpo"),
	LBL_SCO_DATOS_SMS("lbl_sco_datos_sms"),
	LBL_SCO_TELEFONO_REMITENTE("lbl_sco_telefono_remitente"),
	LBL_SCO_TELEFONO_DESTINO("lbl_sco_telefono_destino"),
	TXT_SCO_TELEFONO_REMITENTE("txt_sco_telefono_remitente"),
	TXT_SCO_TELEFONO_DESTINO("txt_sco_telefono_destino"),
	LBL_SCO_DESEA_INCLUIR("lbl_sco_desea_incluir"),
	LBL_SCO_IMG_SUPERCOMBO_LOGO("lbl_sco_img_supercombo_logo"),
	LBL_SCO_BENEFICIOS("lbl_sco_beneficios"),
	LBL_SCO_HURTO("lbl_sco_hurto"),
	LBL_SCO_VLR_HURTO("lbl_sco_vlr_hurto"),
	LBL_SCO_FALLECIMIENTO("lbl_sco_fallecimiento"),
	LBL_SCO_VLR_FALLECIMIENTO("lbl_sco_vlr_fallecimiento"),
	LBL_SCO_NOTIFICACION("lbl_sco_notificacion"),
	LBL_SCO_VALOR_SUPERCOMBO("lbl_sco_valor_supercombo"),
	LBL_SCO_VLR_SUPERCOMBO("lbl_sco_vlr_supercombo"),
	
	//Seccion SuperCombo Destino
	FRM_SCD_VENTANA("frm_scd_ventana"),
	PNL_SCD_PANEL_ENCABEZADO("pnl_scd_panel_encabezado"),
	PNL_SCD_PANEL_CUERPO("pnl_scd_panel_cuerpo"),
	LBL_SCD_DATOS_SMS("lbl_scd_datos_sms"),
	LBL_SCD_TELEFONO_REMITENTE("lbl_scd_telefono_remitente"),
	LBL_SCD_TELEFONO_DESTINO("lbl_scd_telefono_destino"),
	TXT_SCD_TELEFONO_REMITENTE("txt_scd_telefono_remitente"),
	TXT_SCD_TELEFONO_DESTINO("txt_scd_telefono_destino"),
	LBL_SCD_DESEA_INCLUIR("lbl_scd_desea_incluir"),
	LBL_SCD_IMG_SUPERCOMBO_LOGO("lbl_scd_img_supercombo_logo"),
	LBL_SCD_BENEFICIOS("lbl_scd_beneficios"),
	LBL_SCD_HURTO("lbl_scd_hurto"),
	LBL_SCD_VLR_HURTO("lbl_scd_vlr_hurto"),
	LBL_SCD_FALLECIMIENTO("lbl_scd_fallecimiento"),
	LBL_SCD_VLR_FALLECIMIENTO("lbl_scd_vlr_fallecimiento"),
	LBL_SCD_NOTIFICACION("lbl_scd_notificacion"),
	LBL_SCD_VALOR_SUPERCOMBO("lbl_scd_valor_supercombo"),
	LBL_SCD_VLR_SUPERCOMBO("lbl_scd_vlr_supercombo"),
	
	//Ayudas SuperCombo
	GUI_ASC_VENTANA("gui_asc_ventana"),
	PNL_ASC_ENCABEZADO("pnl_asc_encabezado"),
	PNL_ASC_CUERPO("pnl_asc_cuerpo"),
	LBL_ASC_ANUNCIO_PRINCIPAL_TITULO("lbl_asc_anuncio_principal_titulo"),
	LBL_ASC_ANUNCIO_PRINCIPAL_SUBTITULO("lbl_asc_anuncio_principal_subtitulo"),
	LBL_ASC_ANUNCIO_PRINCIPAL_RESUMEN_PROCESO("lbl_asc_anuncio_principal_resumen_proceso"),
	LBL_ASC_ANUNCIO_PRINCIPAL_COSTO_X_SERVICIO("lbl_asc_anuncio_principal_costo_x_servicio"),
	BTN_ASC_ANUNCIO_PRINCIPAL_CANCELAR_SERVICIO("btn_asc_anuncio_principal_cancelar_servicio"),
	BTN_ASC_ANUNCIO_PRINCIPAL_CONFIRMAR_SERVICIO("btn_asc_anuncio_principal_confirmar_servicio"),
	LBL_ASC_ANUNCIO_PRINCIPAL_TIPOS_OPCIONES_SERVICIO("lbl_asc_anuncio_principal_tipos_opciones_servicio"),
	LBL_ASC_ANUNCIO_PRINCIPAL_DESEA_INCLUIRLO("lbl_asc_anuncio_principal_desea_incluirlo"),
	BTN_ASC_ANUNCIO_PRINCIPAL_SIGUIENTE_VENTANA("btn_asc_anuncio_principal_siguiente_ventana"),

	//ingreso y egreso
	JPN_RTT_PANEL_TERCERO_INGEGR("jpn_rtt_panel_tercero_ingegr"),
	GUI_VENTANA_INGEGR("gui_ventana_ingegr"),
	PNL_CONTENCABEZADO_INGEGR("pnl_contencabezado_ingegr"),
	PNL_EMPRESA_INGEGR("pnl_empresa_ingegr"),
	PNL_CONTENCENTRO_INGEGR("pnl_contencentro_ingegr"),
	JRB_INGRESO_INGEGR("jrb_ingreso_ingegr"),
	JRB_EGRESO_INGEGR("jrb_egreso_ingegr"),
	JCB_CONCEPTO_INGEGR("jcb_concepto_ingegr"),
	JCB_MEDIOPAGO_INGEGR("jcb_mediopago_ingegr"),
	LBL_TIPO_MOVIMIENTO_INGEGR("lbl_tipo_movimiento_ingegr"),
	LBL_CONCEPTO_INGEGR("lbl_concepto_ingegr"),
	LBL_VALOR_INGEGR("lbl_valor_ingegr"),
	LBL_MEDIOPAGO_INGEGR("lbl_mediopago_ingegr"),
	LBL_DOCAUX_INGEGR("lbl_docaux_ingegr"),
	LBL_NOTAS_INGEGR("lbl_notas_ingegr"),
	TXT_VALOR_INGEGR("txt_valor_ingegr"),
	TXT_DOCAUX_INGEGR("txt_docaux_ingegr"),
	TXT_NOTAS_INGEGR("txt_notas_ingegr"),
	TXT_SCROLL_INGEGR("txt_scroll_ingegr"),
	
	//Operaciones inusuales
	GUI_VENTANA_OPERINU("gui_ventana_operinu"),
    PNL_CONTENCENTRO_OPERINU("pnl_contencentro_operinu"),
    LBL_OPERINU_OPERINU("lbl_operinu_operinu"),
    JCB_OPERINU_OPERINU("jcb_operinu_operinu"),
    LBL_NOTAS_OPERINU("lbl_notas_operinu"),
    SCR_NOTAS_OPERINU("scr_notas_operinu"),
	
	//Reimpresion Ultimo Seguro
	PNL_RSG_CUERPO("pnl_rsg_cuerpo"),
	PNL_RSG_PIE("pnl_rsg_pie"),
	LBL_RSG_TIPO_DOCUMENTO("lbl_rsg_tipo_documento"),
	
	//Reimpresion Ultimo SMS
	PNL_RSM_ENCABEZADO("pnl_rsm_encabezado"),
	PNL_RSM_PIE("pnl_rsm_pie"),
	
	//Seccion Edicion Notas
	FRM_EDN_VENTANA("frm_edn_ventana"),
	PNL_EDN_PANEL_ENCABEZADO("pnl_edn_panel_encabezado"),
	PNL_EDN_PANEL_CUERPO("pnl_edn_panel_cuerpo"),
	PNL_EDN_PANEL_PIE("pnl_edn_panel_pie"),
	PNL_EDN_ENCABEZADOGRAL("pnl_edn_encabezadogral"),
	LBL_EDN_REFERENCIA("lbl_edn_referencia"),
	TXT_EDN_REFERENCIA("txt_edn_referencia"),
	LBL_EDN_AGENCIA_ORIGEN("lbl_edn_agencia_origen"),
	TXT_EDN_COD_AGEN_ORG("txt_edn_cod_agen_org"),
	TXT_EDN_NOM_AGEN_ORG("txt_edn_nom_agen_org"),
	LBL_EDN_AGENCIA_DESTINO("lbl_edn_agencia_destino"),
	TXT_EDN_COD_AGEN_DEST("txt_edn_cod_agen_dest"),
	TXT_EDN_NOM_AGEN_DEST("txt_edn_nom_agen_dest"),
	LBL_EDN_REMITENTE("lbl_edn_remitente"),
	TXT_EDN_REMITENTE("txt_edn_remitente"),
	LBL_EDN_BENEFICIARIO("lbl_edn_beneficiario"),
	TXT_EDN_BENEFICIARIO("txt_edn_beneficiario"),
	LBL_EDN_FECHA_GIRO("lbl_edn_fecha_giro"),
	TXT_EDN_FECHA_GIRO("txt_edn_fecha_giro"),
	LBL_EDN_NOTAS("lbl_edn_notas"),
	SCP_EDN_NOTAS("scp_edn_notas"),
	TXA_EDN_NOTAS("txa_edn_notas"),
	LBL_EDN_NUEVA_NOTA("lbl_edn_nueva_nota"),
	CMB_EDN_NUEVA_NOTA("cmb_edn_nueva_nota"),
	
	//Seccion Historial de Autorizaciones
	FRM_HAU_VENTANA("frm_hau_ventana"),
	PNL_HAU_PANEL_ENCABEZADO("pnl_hau_panel_encabezado"),
	PNL_HAU_PANEL_CUERPO("pnl_hau_panel_cuerpo"),
	PNL_HAU_PANEL_PIE_PAGINA("pnl_hau_panel_pie_pagina"),
	PNL_HAU_ENCABEZADOGRAL("pnl_hau_encabezadogral"),
	LBL_HAU_FECHA("lbl_hau_fecha"),
	DTC_HAU_FECHA("dtc_hau_fecha"),
	LBL_HAU_FILTRO_SOLICITUD("lbl_hau_filtro_solicitud"),
	CMB_HAU_FILTRO_SOLICITUD("cmb_hau_filtro_solicitud"),
	LBL_HAU_FILTRO_ESTADO("lbl_hau_filtro_estado"),
	CMB_HAU_FILTRO_ESTADO("cmb_hau_filtro_estado"),
	LBL_HAU_FILTRO_REFERENCIA("lbl_hau_filtro_referencia"),
	TXT_HAU_FILTRO_REFERENCIA("txt_hau_filtro_referencia"),
	GRI_HAU_AUTORIZACIONES("gri_hau_autorizaciones"),
	
	//Convenio sedes
	FRM_CVP_VENTANA("frm_cvp_ventana"),
	PNL_CVP_ENCABEZADO("jpn_cvp_panel_encabezado"),
	PNL_CVP_CUERPO("jpn_cvp_panel_cuerpo"),
	LBL_CVP_IDENTIFICACION("lbl_cvp_identificacion"),
	LBL_CVP_NOMBRE("lbl_cvp_nombre"),
	TXT_CVP_IDENTIFICACION("txt_cvp_identificacion"),
	TXT_CVP_NOMBRE("txt_cvp_nombre"),
	GRI_CVP_PROPIEDADES("gri_cvp_propiedades"),
	
	//Ofrecer clave seguridad
	FRM_OCS_VENTANA("frm_ocs_ventana"),
	PNL_OCS_ENCABEZADO("pnl_ocs_encabezado"),
	PNL_OCS_CUERPO("pnl_ocs_cuerpo"),
	LBL_OCS_DESEA_INCLUIR("lbl_ocs_desea_incluir"),
	LBL_OCS_TIPO_CLAVE("lbl_ocs_tipo_clave"),	
	CMB_OCS_TIPO_CLAVE("cmb_ocs_tipo_clave"),
	//Seccion clave seguridad manual
	PNL_PNL_CSM_TIPO_CLAVE_MANUAL("pnl_pnl_csm_tipo_clave_manual"),
	LBL_PNL_CSM_NOTA("lbl_pnl_csm_nota"),
	LBL_PNL_CSM_INGRESE("lbl_pnl_csm_ingrese"),
	LBL_PNL_CSM_CLAVE_DEBE("lbl_pnl_csm_clave_debe"),
	LBL_PNL_CSM_INGRESAR_CLAVE("lbl_pnl_csm_ingresar_clave"),
	PFI_PNL_CSM_INGRESAR_CLAVE("pfi_pnl_csm_ingresar_clave"),
	LBL_PNL_CSM_CONFIRMAR_CLAVE("lbl_pnl_csm_confirmar_clave"),
	PFI_PNL_CSM_CONFIRMAR_CLAVE("pfi_pnl_csm_confirmar_clave"),
	//Seccion clave seguridad automatica
	PNL_PNL_CSA_TIPO_CLAVE_AUTOMATICA("pnl_pnl_csa_tipo_clave_automatica"),
	LBL_PNL_CSA_DATOS_SMS("lbl_pnl_csa_datos_sms"),
	PNL_PNL_CSA_SECCION_REMITENTE("pnl_pnl_csa_seccion_remitente"),
	PNL_PNL_CSA_SECCION_DESTINATARIO("pnl_pnl_csa_seccion_destinatario"),
	LBL_PNL_CSA_INGRESAR_CELULAR("lbl_pnl_csa_ingresar_celular"),
	TXT_PNL_CSA_INGRESAR_CELULAR("txt_pnl_csa_ingresar_celular"),
	LBL_PNL_CSA_CONFIRMAR_CELULAR("lbl_pnl_csa_confirmar_celular"),
	TXT_PNL_CSA_CONFIRMAR_CELULAR("txt_pnl_csa_confirmar_celular"),
	//Seccion clave seguridad no gracias
	PNL_PNL_CSNG_TIPO_CLAVE_NO_GRACIAS("pnl_pnl_csng_tipo_clave_no_gracias"),
	LBL_PNL_CSNG_NOTA("lbl_pnl_csng_nota"),
	
	//Verificar clave seguridad
	FRM_VCT_VENTANA("frm_vct_ventana"),
	PNL_VCT_PANEL_ENCABEZADO("pnl_vct_panel_encabezado"),
	LBL_VCT_INGRESA_CLAVE("lbl_vct_ingresa_clave"),
	LBL_VCT_CLAVE_SEGURIDAD("lbl_vct_clave_seguridad"),
	PFI_VCT_CLAVE_SEGURIDAD("pfi_vct_clave_seguridad"),
	
	//Consulta estado giro
	GUI_CEG_VENTANA("gui_ceg_ventana"),
	PNL_CEG_ENCABEZADO("pnl_ceg_encabezado"),
	PNL_CEG_CUERPO("pnl_ceg_cuerpo"),
	PNL_CEG_PIE_PAGINA("pnl_ceg_pie_pagina"),
	PNL_CEG_ENCABEZADO_GENERAL("pnl_ceg_encabezado_general"),
	LBL_CEG_REFERENCIA("lbl_ceg_referencia"),
	TXT_CEG_REFERENCIA("txt_ceg_referencia"),
	LBL_CEG_ESTADO("lbl_ceg_estado"),
	TXT_CEG_ESTADO("txt_ceg_estado"),
	PNL_CEG_AGENCIA_ORIGEN("pnl_ceg_agencia_origen"),
	PNL_CEG_AGENCIA_DESTINO("pnl_ceg_agencia_destino"),
	
	//Panel codigo descripcion
	LBL_PNL_COD_DESC_NOMBRE("lbl_pnl_cod_desc_nombre"),
	TXT_PNL_COD_DESC_CODIGO("lbl_pnl_cod_desc_codigo"),
	TXT_PNL_COD_DESC_DESCRIPCION("lbl_pnl_cod_desc_descripcion"),
	
	//Solicitar Huellas Tercero
	GUI_SHT_VENTANA("gui_sht_ventana"),
	PNL_SHT_ENCABEZADO("pnl_sht_encabezado"),
	PNL_SHT_CUERPO("pnl_sht_cuerpo"),
	PNL_SHT_PIE_PAGINA("pnl_sht_pie_pagina"),
	IMG_SHT_MANO_DERECHA("img_sht_mano_derecha"),
	IMG_SHT_MANO_IZQUIERDA("img_sht_mano_izquierda"),
	IMG_SHT_MANOS("img_sht_manos"),
	
	//Seccion SMS Giro
	PNL_PNL_SMS_SECCION("pnl_pnl_sms_seccion"),
	LBL_PNL_SMS_INGRESAR_CELULAR("lbl_pnl_sms_ingresar_celular"),
	TXT_PNL_SMS_INGRESAR_CELULAR("txt_pnl_sms_ingresar_celular"),
	LBL_PNL_SMS_CONFIRMAR_CELULAR("lbl_pnl_sms_confirmar_celular"),
	TXT_PNL_SMS_CONFIRMAR_CELULAR("txt_pnl_sms_confirmar_celular"),
	LBL_PNL_SMS_TITULO_FORMA("lbl_pnl_sms_titulo_forma"),
	
	//Consulta Pago Giros Internacionales
	LBL_CPI_BUSQUEDA_POR("lbl_cpi_busqueda_por"),
	CMB_CPI_BUSQUEDA("jcb_cpi_busqueda"),
	LBL_CPI_REFERENCIA("lbl_cpi_referencia"),
	TXT_CPI_REFERENCIA("txt_cpi_referencia"),
	LBL_CPI_CORRESPONSAL("lbl_cpi_corresponsal"),
	CMB_CPI_CORRESPONSAL("cmb_cpi_corresponsal"),
	LBL_CPI_TIPO_DOCUMENTO_BEN_R("lbl_cpi_tipo_documento_ben_r"),
	CMB_CPI_TIPO_DOCUMENTO_BEN_R("cmb_cpi_tipo_documento_ben_r"),
	LBL_CPI_TIPO_DOCUMENTO_BEN_D("lbl_cpi_tipo_documento_ben_d"),
	CMB_CPI_TIPO_DOCUMENTO_BEN_D("cmb_cpi_tipo_documento_ben_d"),
	LBL_CPI_DOCUMENTO_BEN_R("lbl_cpi_documento_ben_r"),
	TXT_CPI_DOCUMENTO_BEN_R("txt_cpi_documento_ben_r"),
	LBL_CPI_DOCUMENTO_BEN_D("lbl_cpi_documento_ben_d"),
	TXT_CPI_DOCUMENTO_BEN_D("txt_cpi_documento_ben_d"),
	LBL_CPI_ESTADO_REMESA("lbl_cpi_estado_remesa"),
	TXT_CPI_ESTADO_REMESA("txt_cpi_estado_remesa"),
	CHK_CPI_DESTINATARIO("chk_cpi_destinatario"),
	CHK_CPI_REMITENTE("chk_cpi_remitente"),
	LBL_CPI_NOMBRE_TERCERO_BEN("lbl_cpi_nombre_tercero_ben"),
	TXT_CPI_NOMBRE_TERCERO_BEN("txt_cpi_nombre_tercero_ben"),
	LBL_CPI_APELLIDO_TERCERO_BEN("lbl_cpi_apellido_tercero_ben"),
	TXT_CPI_APELLIDO_TERCERO_BEN("txt_cpi_apellido_tercero_ben"),
	LBL_CPI_NOMBRE_TERCERO_REM("lbl_cpi_nombre_tercero_rem"),
	TXT_CPI_NOMBRE_TERCERO_REM("txt_cpi_nombre_tercero_rem"),
	LBL_CPI_APELLIDO_TERCERO_REM("lbl_cpi_apellido_tercero_rem"),
	TXT_CPI_APELLIDO_TERCERO_REM("txt_cpi_apellido_tercero_rem"),
	LBL_CPI_DOCUMENTO_AL_REVES("lbl_cpi_documento_al_reves"),
	TXT_CPI_DOCUMENTO_AL_REVES("txt_cpi_documento_al_reves"),
	FRM_CPI_VENTANA("frm_cpi_ventana"),
	PNL_CPI_ENCABEZADO("pnl_cpi_encabezado"),
	PNL_CPI_CUERPO("pnl_cpi_cuerpo"),
	PNL_CPI_PIE_PAGINA("pnl_cpi_pie_pagina"),
	PNL_CPI_BUSQUEDA("pnl_cpi_busqueda"),
	PNL_CPI_ENCABEZADO_GENERAL("pnl_cpi_encabezado_general"),
	SCP_CPI_GIROS_CONSULTADOS("scp_cpi_giros_consultados"),
	PNL_CPI_REMITENTE("pnl_cpi_remitente"),
	PNL_CPI_BENEFICIARIO("pnl_cpi_beneficiario"),
	PNL_CPI_REFERENCIA("pnl_cpi_referencia"),
	PNL_CPI_DOCUMENTO_AL_REVES("pnl_cpi_documento_al_reves"),
	PNL_CPI_CONTENEDOR_DOC_AL_REVES("pnl_cpi_contenedor_doc_al_reves"),
	
	//Pago Giro Internacional
	GUI_PGI_VENTANA("gui_pgi_ventana"),
	PNL_PGI_ENCABEZADO("pnl_pgi_encabezado"),
	PNL_PGI_CUERPO("pnl_pgi_cuerpo"),
	PNL_PGI_PIE_PAGINA("pnl_pgi_pie_pagina"),
	PNL_PGI_REMITENTE("pnl_pgi_remitente"),
	PNL_PGI_BENEFICIARIO("pnl_pgi_beneficiario"),
	PNL_PGI_MOTIVOS_NUMERALES("pnl_pgi_motivos_numerales"),
	PNL_PGI_HUELLA("pnl_pgi_huella"),
	BTN_PGI_GESTION_RECLAMOS("btn_pgi_gestion_reclamos"),
	BTN_PGI_GESTION_SENALES_ALERTA("btn_pgi_gestion_senales_alerta"),
	BTN_EGI_GESTION_SENALES_ALERTA("btn_egi_gestion_senales_alerta"),
	LBL_PGI_NOMBRE_TERCERO_REM("lbl_pgi_nombre_tercero_rem"),
	TXT_PGI_NOMBRE_TERCERO_REM("txt_pgi_nombre_tercero_rem"),
	LBL_PGI_TELEFONO_TERCERO_REM("lbl_pgi_telefono_tercero_rem"),
	TXT_PGI_TELEFONO_TERCERO_REM("txt_pgi_telefono_tercero_rem"),
	LBL_PGI_NOMBRE_TERCERO_BEN("lbl_pgi_nombre_tercero_ben"),
	TXT_PGI_NOMBRE_TERCERO_BEN("txt_pgi_nombre_tercero_ben"),
	LBL_PGI_TELEFONO_TERCERO_BEN("lbl_pgi_telefono_tercero_ben"),
	TXT_PGI_TELEFONO_TERCERO_BEN("txt_pgi_telefono_tercero_ben"),
	LBL_PGI_CLIENTE_TERCERO_BEN("lbl_pgi_cliente_tercero_ben"),
	TXT_PGI_CLIENTE_TERCERO_BEN("txt_pgi_cliente_tercero_ben"),
	LBL_PGI_MOTIVO_REMENSA("lbl_pgi_motivo_remensa"),
	CMB_PGI_MOTIVO_REMENSA("jcb_pgi_motivo_remensa"),
	LBL_PGI_NUMERALES("lbl_pgi_numerales"),
	CMB_PGI_NUMERALES("jcb_pgi_numerales"),
	LBL_PGI_MANOS("lbl_pgi_manos"),
	CMB_PGI_MANOS("jcb_pgi_manos"),
	LBL_PGI_DEDOS("lbl_pgi_dedos"),
	CMB_PGI_DEDOS("jcb_pgi_dedos"),
	BTN_PGI_CAPTURA_HUELLA("btn_pgi_captura_huella"),
	BTN_PGI_CAPTURA_FOTOS("btn_pgi_captura_fotos"),
	BTN_EGI_CAPTURA_FOTOS("btn_egi_captura_fotos"),
	LBL_PGI_FORMA_PAGO("lbl_pgi_forma_pago"),
	TXT_PGI_FORMA_PAGO("txt_pgi_forma_pago"),
	LBL_PGI_NOTAS("lbl_pgi_notas"),
	TXT_PGI_NOTAS("txt_pgi_notas"),
	LBL_PGI_VALOR_PESOS("lbl_pgi_valor_pesos"),
	TXT_PGI_VALOR_PESOS("txt_pgi_valor_pesos"),
	LBL_PGI_VALOR_DOLARES("lbl_pgi_valor_dolares"),
	TXT_PGI_VALOR_DOLARES("txt_pgi_valor_dolares"),
	LBL_PGI_TASA("lbl_pgi_tasa"),
	TXT_PGI_TASA("txt_pgi_tasa"),
	LBL_PGI_GMF("lbl_pgi_gmf"),
	TXT_PGI_GMF("txt_pgi_gmf"),
	LBL_PGI_GASTOS_ADMIN("lbl_pgi_gastos_admin"),
	TXT_PGI_GASTOS_ADMIN("txt_pgi_gastos_admin"),
	LBL_PGI_VLR_PROTEGIRO("lbl_pgi_vlr_protegiro"),
	TXT_PGI_VLR_PROTEGIRO("txt_pgi_vlr_protegiro"),
	LBL_PGI_VLR_TOTAL_PAGAR("lbl_pgi_vlr_total_pagar"),
	TXT_PGI_VLR_TOTAL_PAGAR("txt_pgi_vlr_total_pagar"),
	
	//Gestion Reclamo Internacional
	GUI_GRI_VENTANA("gui_gri_ventana"),
	PNL_GRI_CUERPO("pnl_gri_cuerpo"),
	LBL_GRI_MENSAJE("lbl_gri_mensaje"),
	CMB_GRI_MENSAJE("cmb_gri_mensaje"),
	LBL_GRI_COMENTARIO("lbl_gri_comentario"),
	SCP_GRI_COMENTARIO("scp_gri_comentario"),
	
    //Captura Documento Internacional
    GUI_CDI_VENTANA("gui_cdi_ventana"),
    PNL_CDI_CUERPO("pnl_cdi_cuerpo"),
    CMB_CDI_CAPTURA_IMAGEN("cmb_cdi_captura_img"),
    BTN_CDI_CAPTURA_IMAGEN("btn_cdi_captura_img"),
    TTL_CDI_INFORMACION_CAPTURA("ttl_cdi_informacion_captura"),
    
    //Dedo Biometria Seleccionado
    LBL_PNL_DBS_TIPO_MANO("lbl_pnl_dbs_tipo_mano"),
    CMB_PNL_DBS_TIPO_MANO("cmb_pnl_dbs_tipo_mano"),
    LBL_PNL_DBS_TIPO_DEDO("lbl_pnl_dbs_tipo_dedo"),
    CMB_PNL_DBS_TIPO_DEDO("cmb_pnl_dbs_tipo_dedo"),
    
    //Gestion Senales Alerta
    SCP_GSA_SENALES_ALERTA("scp_gsa_senales_alerta"),
    GUI_GSA_VENTANA("gui_gsa_ventana"),
	PNL_GSA_CUERPO("pnl_gsa_cuerpo"),
	
	//Seguro en el pago del giro internacional
	GUI_SPGI_VENTANA("gui_spgi_ventana"),
	PNL_SPGI_ENCABEZADO("pnl_spgi_encabezado"),
	PNL_SPGI_CUERPO("pnl_spgi_cuerpo"),
	PNL_SPGI_BENEFICIARIO("pnl_spgi_beneficiario"),
	LBL_SPGI_TIPO_IDENTIFICACION("lbl_spgi_tipo_identificacion"),
	TXT_SPGI_TIPO_IDENTIFICACION("txt_spgi_tipo_identificacion"),
	LBL_SPGI_IDENTIFICACION("lbl_spgi_identificacion"),
	TXT_SPGI_IDENTIFICACION("txt_spgi_identificacion"),
	LBL_SPGI_NOMBRE("lbl_spgi_nombre"),
	TXT_SPGI_NOMBRE("txt_spgi_nombre"),
	LBL_SPGI_TELEFONO("lbl_spgi_telefono"),
	TXT_SPGI_TELEFONO("txt_spgi_telefono"),
	LBL_SPGI_VALOR_PRIMA("lbl_spgi_valor_prima"),
	LBL_SPGI_VLR_PRIMA("lbl_spgi_vlr_prima"),
	LBL_SPGI_BENEFICIOS("lbl_spgi_beneficios",false),
	LBL_SPGI_NOTIFICACION("lbl_spgi_notificacion"),
	LBL_SPGI_VALOR_PROTEGIRO("lbl_spgi_valor_protegiro"),
	LBL_SPGI_VLR_PROTEGIRO("lbl_spgi_vlr_protegiro"),
	
	//Anulacion Seguro del giro internacional
	GUI_ASGI_VENTANA("gui_asgi_ventana"),
	PNL_ASGI_ENCABEZADO("pnl_asgi_encabezado"),
	PNL_ASGI_INFO_REMESA("pnl_asgi_info_remesa"),
	LBL_ASGI_REFERENCIA_SEGURO("lbl_asgi_referencia_seguro"),
	LBL_ASGI_VALOR_GIRO("lbl_asgi_valor_giro"),
	TXT_ASGI_REFERENCIA_SEGURO("txt_asgi_referencia_seguro"),
	TXT_ASGI_VALOR_GIRO("txt_asgi_valor_giro"),
	
	//Seccion Envio Remesa Internacional
	LBL_PNL_COTIZAR_TIPO_DOC_REMITENTE("lbl_pnl_cotizar_tipo_doc_remitente"),
	LBL_PNL_COTIZAR_NUM_DOC_REMITENTE("lbl_pnl_cotizar_num_doc_remitente"),
	LBL_PNL_COTIZAR_OPCION_ENVIO_REMITENTE("lbl_pnl_cotizar_opcion_envio_remitente"),
	LBL_PNL_COTIZAR_PAIS_REMITENTE("lbl_pnl_cotizar_pais_remitente"),
	LBL_PNL_COTIZAR_MONTO_REMITENTE("lbl_pnl_cotizar_monto_remitente"),
	TXT_PNL_COTIZAR_NUM_DOC_REMITENTE("txt_pnl_cotizar_num_doc_remitente"),
	TXT_PNL_COTIZAR_MONTO_REMITENTE("txt_pnl_cotizar_monto_remitente"),
	CMB_PNL_COTIZAR_TIPO_DOC_REMITENTE("cmb_pnl_cotizar_tipo_doc_remitente"),
	CMB_PNL_COTIZAR_OPCION_ENVIO_REMITENTE("cmb_pnl_cotizar_opcion_envio_remitente"),
	CMB_PNL_COTIZAR_PAIS_REMITENTE("cmb_pnl_cotizar_pais_remitente"),
	BTN_PNL_COTIZAR_BOTON_COTIZAR("btn_pnl_cotizar_boton_cotizar"),
	BTN_PNL_COTIZAR_BOTON_LIMPIAR("btn_pnl_cotizar_boton_limpiar"),
	PNL_CGI_COTIZAR("pnl_cgi_cotizar"),
	PNL_EGI_COTIZAR_INTER("pnl_egi_cotizar_inter"),
	PNL_CGI_CUERPO_COTIZAR("pnl_cgi_cuerpo_cotizar"),
	PNL_CGI_PIE_PAGINA_INTERNACIONAL("pnl_cgi_pie_pagina_internacional"),
	GRI_EGI_GRID_TIPOS_ENVIO_INTERNACIONAL("gri_egi_grid_tipos_envio_internacional"),
	FRM_EGI_VENTANA("frm_egi_ventana"),
	LBL_OII_PNL_CAMPOS_OBLIGATORIOS_ENVIO("lbl_oii_pnl_campos_obligatorios_envio"),
	PNL_EGI_CONTENEDOR_DOC_AL_REVES("pnl_egi_contenedor_doc_al_reves"),
	PNL_EGI_DOCUMENTO_AL_REVES("pnl_egi_documento_al_reves"),
	LBL_EGI_DOCUMENTO_AL_REVES("lbl_egi_documento_al_reves"),
	TXT_EGI_DOCUMENTO_AL_REVES("txt_egi_documento_al_reves"),
	
	//Seccion Envio Remesa Internacional (FormaPanelBeneficiario)
	PNL_EGI_BENEFICIARIO("pnl_egi_beneficiario"),
	PNL_EGI_BENEFICIARIO_INTER("pnl_egi_beneficiario_inter"),
	TXT_PNL_BENEFICIARIO_NOMBRE("txt_pnl_beneficiario_nombre"),
	TXT_PNL_BENEFICIARIO_APELLIDO("txt_pnl_beneficiario_apellido"),
	CMB_PNL_BENEFICIARIO_NUMERALES_ENVIO("cmb_pnl_beneficiario_numerales_envio"),
	LBL_PNL_BENEFICIARIO_NOMBRE("lbl_pnl_beneficiario_nombre"),
	LBL_PNL_BENEFICIARIO_APELLIDO("lbl_pnl_beneficiario_apellido"),
	LBL_PNL_BENEFICIARIO_NUMERAL_ENVIO("lbl_pnl_beneficiario_numeral_envio"),
	
	//Seccion Envio Remesa Internacional (FormaPanelTomaHuellaBeneficiarioInternacional)
	PNL_EGI_THREMITE("pnl_egi_thremitente"),
	PNL_EGI_THREMITE_INTER("pnl_egi_thremitente_inter"),
	LBL_PNL_THREMITE_MANO("lbl_pnl_thremite_mano"),
	LBL_PNL_THREMITE_DEDO("lbl_pnl_thremite_dedo"),
	CMB_PNL_THREMITE_MANO("cmb_thremite_mano"),
	CMB_PNL_THREMITE_DEDO("cmb_thremite_dedo"),
	BTN_PNL_THREMITE_TOMA_HUELLA("btn_pnl_thremite_toma_huella"),
	BTN_PNL_THREMITE_TOMA_FOTO("btn_pnl_thremite_toma_foto"),
	
	
	//GrillaPropiedadesPeps	
	GRI_PPS_GRID_PEPS("gri_pps_grid_peps"),
	GUI_PPS_VENTANA("gui_pps_ventana"),
	JPN_PPS_PEPS_PANEL_CUERPO("jpn_pps_peps_panel_cuerpo"),
	JPN_PPS_VENTANA("jpn_pps_ventana"),
	LBL_PPS_PREGUNTA_PEPS("lbl_pps_pregunta_peps"),
	BTN_PPS_ACEPTAR("btn_pps_aceptar"),
	BTN_PPS_CANCELAR("btn_pps_cancelar"),
	
	
	
	//Version presentada en FormaInicioGiros
	LBL_FIG_VERSION_GIRO("lbl_fig_version_giro"),
	
	//Propiedades PEPS Internacional
	GUI_PPI_VENTANA("gui_ppi_ventana"),
	PNL_PPI_ENCABEZADO("pnl_ppi_encabezado"),
	PNL_PPI_CONYUGE("pnl_ppi_conyuge"),
	PNL_PPI_FAMILIAR_CONSANGUINIDAD("pnl_ppi_familiar_consanguinidad"),
	PNL_PPI_FAMILIAR_AFINIDAD("pnl_ppi_familiar_afinidad"),
	PNL_PPI_FAMILIAR_CIVIL("pnl_ppi_familiar_civil"),
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
	
	
	//GrillaPropiedadesAdmisionEnvioTirilla	
	GRI_CRC_GRID_ADMENV("gri_crc_grid_admenv"),
	GUI_CRC_VENTANA("gui_crc_ventana"),
	JPN_CRC_ADMENV_PANEL_CUERPO("jpn_crc_admenv_panel_cuerpo"),
	JPN_CRC_VENTANA("jpn_crc_ventana"),
	LBL_CRC_PREGUNTA_ADMENV("lbl_crc_pregunta_admenv"),
	BTN_CRC_ACEPTAR("btn_crc_aceptar"),
	BTN_CRC_CANCELAR("btn_crc_cancelar"),
	TXT_CRC_VALOR_PROPIEDAD("txt_crc_valor_propiedad"),
	
	//Gico automatico
	PNL_GICO_AUTOMATICO_CUERPO_DIMENSIONES("pnl_gico_automatico"),
	GUI_GICO_AUTOMATICO_VENTANA("gui_gico_automatico_ventana"),
	CMB_GICO_AUTOMATICO("cmb_gico_automatico"),
	LBL_GICO_AUTOMATICO("lbl_gico_automatico"),
	
	//Declaracion Origenes de Fondo
	TXT_DOF_RESPUESTA("txt_dof_respuesta"),
	FRM_DOF_VENTANA("frm_dof_ventana"),
	JPN_DOF_PANEL_ENCABEZADO("jpn_dof_panel_encabezado"),
	JPN_DOF_PANEL_CUERPO("jpn_dof_panel_cuerpo"),
	LBL_DOF_PREGUNTA("lbl_dof_pregunta"),
	
	//Confirmacion Normativa
	LBL_PNL_NORMATIVA_TITULO_FORMA("lbl_pnl_normativa_titulo_forma"),
	;
	
	/**
	 * @author: Hector Q-en-K
	 * @type: Atributo
	 * @name: etiqueta
	 * @description: etiqueta y/o identificador de propiedad
	 * @version: 05/03/2015
	 */
	private final String etiqueta;
	
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
	 * @name: x
	 * @description: posicion de ubicacion, eje x 
	 * @version: 05/03/2015
	 */
	private int x;
	
	/**
	 * @author: Hector Q-en-K
	 * @type: Atributo
	 * @name: y
	 * @description: posicion de ubicacion, eje y 
	 * @version: 05/03/2015
	 */
	private int y;
	
	/**
	 * @author: Hector Q-en-K
	 * @type: Atributo
	 * @name: ancho
	 * @description: dimension de ancho 
	 * @version: 05/03/2015
	 */
	private int ancho;
	
	/**
	 * @author: Hector Q-en-K
	 * @type: Atributo
	 * @name: alto
	 * @description: dimension de alto 
	 * @version: 05/03/2015
	 */
	private int alto;
	
	/**
	 * @variable	intArcoX
	 * 				Entero que identifica el valor del arco sobre el eje X que puede 
	 * 				llegar a tomar y necesitar el componente en cuestion, de aplicar 
	 * 				los aspectos Slim
	 */
	private int intArcoX;
	
	/**
	 * @variable	intArcoY
	 * 				Entero que identifica el valor del arco sobre el eje Y que puede 
	 * 				llegar a tomar y necesitar el componente en cuestion, de aplicar 
	 * 				los aspectos Slim
	 */
	private int intArcoY;
	
	/**
	 * @author: Hector Q-en-K
	 * @type: Atributo
	 * @name: rectangulo
	 * @description: objeto que encapsula todos los parametros de dimension
	 * 				 (posicion en x, posicion en y, ancho y alto) 
	 * @version: 05/03/2015
	 */
	private Rectangle rectangulo;
	
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
	
	private static String strSistemaOperativo;
	
	private boolean booConservarDimensionOriginal;

	/**
	 * @author: Hector Q-en-K
	 * @type: Constructor
	 * @name EnumDimensionesComponentes
	 * @description: Constructor que ejecuta la inicializacion de valores y ejecucion de 
	 * 				 comportamientos inicales requeridos para la materializacion de las 
	 * 				 constantes de enumerador
	 * @param etiqueta: etiqueta y/o identificador de propiedad
	 * @version: 05/03/2015
	 */
	private EnumDimensionesComponentes(String etiqueta){
		
		this.etiqueta=etiqueta;
		this.procesado=false;
		
	}
	
	/**
	 * ********************************************************************
	 * @method 	EnumDimensionesComponentes
	 * 		   	Constructor que ejecuta la inicializacion de valores y 
	 * 			ejecucion de comportamientos inicales requeridos para la 
	 * 			materializacion de las constantes de enumerador
	 * @param 	pStrEtiqueta
	 * 			etiqueta y/o identificador de propiedad
	 * @param 	pBooConservarDimensionOriginal
	 * 			Bandera que indica si la dimension recuperada desde el 
	 * 			.properties, se debe mantener constante
	 * @author 	hector.cuenca
	 * @date   	2/06/2017
	 * *********************************************************************
	 */
	private	EnumDimensionesComponentes	(	String pStrEtiqueta,
											boolean pBooConservarDimensionOriginal
										)
	{	
		this.etiqueta=pStrEtiqueta;
		this.procesado=false;
		this.booConservarDimensionOriginal=pBooConservarDimensionOriginal;
	}
	
	/**
	 * @author: Hector Q-en-K
	 * @type: Comportamiento (Metodo)
	 * @name validaProcesado
	 * @description: Metodo que valida si la constante de enumerador ya fue procesada, de no
	 * 				 ser asi, solicita cargar sus valores funcionales adicionales 
	 * @version: 05/03/2015
	 */
	private void validaProcesado(){
		
		if(!this.procesado){
			this.cargar();
			this.procesado=true;
		}
		
	}
	
	/**
	 * @author: Hector Q-en-K
	 * @type: Comportamiento (Metodo)
	 * @name cargar
	 * @description: Metodo que realiza la carga de los valores funcionales adicionales, que
	 * 				 presenta la constante de enumerador 
	 * @version: 05/03/2015
	 */
	private void cargar(){
		
		EnumMensajes enmMsgDimensionMalConfigurada;
		Mensaje objMensaje;
		String parametrosDimensiones[];
		
		//valor = x,y,ancho,alto,arcoX,arcoY
		try{
			
			this.valor	=	EnumRecursosProperties.DIMENSIONES.getRsbRecurso().getString(this.etiqueta);
			
			if	(	!this.valor.matches(EnumExpresionesRegulares.CMP_GRF_DIMENSION.getValor())	)	{
				
				enmMsgDimensionMalConfigurada	=	EnumMensajes.VERIFICAR_CONFIGURACION_DIMENSION_COMPONENTE_GRAFICO;
				
				if	(	EstadoAplicacionEnum.DESARROLLO.equals(FormaLogin.estadoAplicacion)	)	{
				
					enmMsgDimensionMalConfigurada.desplegarMensaje	(	null, 
																		EnumClasesMensaje.ADVERTENCIA,
																		this.getEtiqueta()
																	);
				}	else	{
					
					objMensaje	=	enmMsgDimensionMalConfigurada.obtenerMensaje(	EnumClasesMensaje.ADVERTENCIA, 
																					this.getEtiqueta()
							   													);

					UtilidadesGiros.getInstance().mostrarEnConsola	(	objMensaje.obtenerMensajeProcesado(),
								   										System.err
								   									);
				}
				
				this.valor="0,0,0,0,-1,-1";
			}
			
		}catch(Exception e){
			e.printStackTrace();
			this.valor="0,0,0,0,-1,-1";
		}
		
		parametrosDimensiones=this.valor.replace(" ","").split(",");
		
		this.x			=	Integer.parseInt(parametrosDimensiones[0]);
		this.y			=	Integer.parseInt(parametrosDimensiones[1]);
		this.ancho		=	Integer.parseInt(parametrosDimensiones[2]);
		this.alto		=	Integer.parseInt(parametrosDimensiones[3]);
		
		try{
			
			this.intArcoX 	=	Integer.parseInt(parametrosDimensiones[4]);
			this.intArcoY 	=	Integer.parseInt(parametrosDimensiones[5]);
			
		}catch(Exception e){
			
			this.intArcoX	=	-1;
			this.intArcoY	=	-1;
		}
		
		if	(		!this.isBooConservarDimensionOriginal()
				&&
					(		EnumDimensionesComponentes.getStrSistemaOperativo().contains("nix") 
						|| 	EnumDimensionesComponentes.getStrSistemaOperativo().contains("nux")
						|| 	EnumDimensionesComponentes.getStrSistemaOperativo().contains("aix")
					)
			)
		{
			this.ancho += this.ancho*0.15;
			this.x += this.x*0.15;
		}
		
		this.rectangulo = new Rectangle(this.x,
										this.y,
										this.ancho,
										this.alto);
		
	}

	public String getValor() {
		this.validaProcesado();
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public int getX() {
		this.validaProcesado();
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		this.validaProcesado();
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getAncho() {
		this.validaProcesado();
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		this.validaProcesado();
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	/**
	 * @method getIntArcoX
	 * 		   Metodo get del atributo intArcoX
	 * @return int
	 *		   Valor del atributo intArcoX devuelto
	 * @author hector.cuenca
	 * @date   2/11/2016
	 */
	public int getIntArcoX() {
		this.validaProcesado();
		return this.intArcoX;
	}

	/**
	 * @method setIntArcoX
	 * 		   Metodo set del atributo intArcoX
	 * @param  pIntArcoX
	 *		   Valor que tomara el atributo intArcoX
	 * @author hector.cuenca
	 * @date   2/11/2016
	 */
	public void setIntArcoX(int pIntArcoX) {
		this.intArcoX = pIntArcoX;
	}

	/**
	 * @method getIntArcoY
	 * 		   Metodo get del atributo intArcoY
	 * @return int
	 *		   Valor del atributo intArcoY devuelto
	 * @author hector.cuenca
	 * @date   2/11/2016
	 */
	public int getIntArcoY() {
		this.validaProcesado();
		return this.intArcoY;
	}

	/**
	 * @method setIntArcoY
	 * 		   Metodo set del atributo intArcoY
	 * @param  pIntArcoY
	 *		   Valor que tomara el atributo intArcoY
	 * @author hector.cuenca
	 * @date   2/11/2016
	 */
	public void setIntArcoY(int pIntArcoY) {
		this.intArcoY = pIntArcoY;
	}

	public Rectangle getRectangulo() {
		this.validaProcesado();
		return rectangulo;
	}

	public void setRectangulo(Rectangle rectangulo) {
		this.rectangulo = rectangulo;
	}

	public boolean isProcesado() {
		return procesado;
	}

	public void setProcesado(boolean procesado) {
		this.procesado = procesado;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public static String getStrSistemaOperativo() {
		
		if(EnumDimensionesComponentes.strSistemaOperativo==null){
			
			EnumDimensionesComponentes.strSistemaOperativo = System.getProperty("os.name");
		}
		
		return strSistemaOperativo;
	}

	public static void setStrSistemaOperativo(String strSistemaOperativo) {
		EnumDimensionesComponentes.strSistemaOperativo = strSistemaOperativo;
	}
	
	/**
	 * @method isBooConservarDimensionOriginal
	 * 		   Metodo get del atributo booConservarDimensionOriginal
	 * @return boolean
	 *		   Valor del atributo booConservarDimensionOriginal devuelto
	 * @author hector.cuenca
	 * @date   2/06/2017
	 */
	public boolean isBooConservarDimensionOriginal() {
		return this.booConservarDimensionOriginal;
	}

	/**
	 * @method setBooConservarDimensionOriginal
	 * 		   Metodo set del atributo booConservarDimensionOriginal
	 * @param  pBooConservarDimensionOriginal
	 *		   Valor que tomara el atributo booConservarDimensionOriginal
	 * @author hector.cuenca
	 * @date   2/06/2017
	 */
	public void setBooConservarDimensionOriginal(
			boolean pBooConservarDimensionOriginal) {
		this.booConservarDimensionOriginal = pBooConservarDimensionOriginal;
	}
	
}

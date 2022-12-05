package co.com.codesa.clienteposslimgiros.enumeraciones;

import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;

/**
 * ****************************************************************.
 * @autor: Roberth Martinez Vargas
 * @fecha: 11-mar-2015
 * @descripcion: Enumeracion que permite manejar las expresiones regulares 
 * 				para control de caracteres
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public enum EnumExpresionesRegulares {
	
	//Expresiones regulares
	
	//Genericas
	EXP_REG_ADMITE_TODO("exp_reg_admite_todo"),//.*
	EXP_REG_FORMATO_DINERO("exp_reg_formato_dinero"),//0|([1-9]([0-9]{0,2})((\\,([0-9]{0,3})){0,5}))
	FORMATO_DINERO_SIN_CERO("formato_dinero_sin_cero"),//[1-9]([0-9]{0,2})((\\,([0-9]{0,3})){0,5})
	EXP_REG_FORMATO_LETRAS("exp_reg_formato_letras"),//([a-zA-Z]|\\s)
	EXP_REG_FORMATO_NUMEROS("exp_reg_formato_numeros"),//[0-9]
	EXP_REG_FORMATO_ALFANUMERICO("exp_reg_formato_alfanumerico"),//([a-zA-Z]|[0-9])
	GENERICA_CARACTERES_RESERVADOS("generica_caracteres_reservados"),//[\\[\\]\\{\\}\\(\\)\\+\\*\\?\\|\\.\\^\\$\\\\\\-]
	GNR_DETECTAR_PARAMETROS_MENSAJE_NO_PROCESADOS("gnr_detectar_parametros_mensaje_no_procesados"),//((\\s)*\\:)?(\\s)*\\{[0-9]+\\}
	GRN_DETECTAR_IRREGULARIDADES_PARAMETROS_MENSAJE("grn_detectar_irregularidades_parametros_mensaje"),//:(\\s)*$
	GNR_A_TILDE("gnr_a_tilde"),//�|�
	GNR_E_TILDE("gnr_e_tilde"),//�|�
	GNR_I_TILDE("gnr_i_tilde"),//�|�
	GNR_O_TILDE("gnr_o_tilde"),//�|�
	GNR_U_TILDE("gnr_u_tilde"),//�|�
	GNR_INICIO("gnr_inicio"),//^
	GNR_FIN("gnr_fin"),//$
	GNR_O_LOGICO("grn_o_logico"),//|
	GNR_ESCAPE("grn_escape"),//\\
	GNR_ABRE_PARENTESIS("grn_abre_parentesis"),//(
	GNR_CIERRA_PARENTESIS("grn_cierra_parentesis"),//)
	GNR_IP("gnr_ip"),//\b[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\b
	
	//Componentes Graficos
	CMP_GRF_DIMENSION("cmp_grf_dimension"),
	CMP_GRF_COLOR("cmp_grf_color"),
	
	//Personalizadas
	//General Negocio
	EXP_REG_FORMATO_PIN_GIRO("exp_reg_formato_pin_giro"),//[0-9]{1,25}
	EXP_REG_FORMATO_PIN_GIRO_EXT("exp_reg_formato_pin_giro_ext"),//([0-9]|[a-zA-Z]){1,25}
	EXP_REG_FORMATO_NOTAS("exp_reg_formato_notas"),//([0-9]|[a-zA-Z]|\\s){1,95}
	EXP_REG_FORMATO_INGRESO_TELEFONO("exp_reg_formato_ingreso_telefono"),//[0-9]{1,10}
	EXP_REG_FORMATO_INGRESO_CELULAR("exp_reg_formato_ingreso_celular"),//3[0-9]{0,9}
	EXP_REG_FORMATO_INGRESO_CORREO_ELECTRONICO("exp_reg_formato_ingreso_correo_electronico"),//
	EXP_REG_FORMATO_DINERO_GIRO("exp_reg_formato_dinero_giro"),//([1-9]([0-9]{0,2})((\\,([0-9]{0,3})){0,2}))|[1-9]((\\,([0-9]{0,3})){3})
	DOCUMENTO_AUXILIAR_INGRESO("documento_auxiliar_ingreso"),//([0-9]|[a-zA-Z]){1,239}
	DOCUMENTO_AUXILIAR_SALIDA("documento_auxiliar_salida"), //([0-9]|[a-zA-Z]|\\*){1,239}
	TOKEN_D_SEGURIDAD_TRAMAS("token_d_seguridad_tramas"),//[0-9]{1,6}\\|.{1,35}\\|.{1,100}(\\|)?
	
	//Palabras claves de negocio {EnumFormatoPalabrasNegocio}
	//General
	PAL_NEG_NOMBRE_PROVEEDOR_SUPER_GIROS("pal_neg_nombre_proveedor_super_giros"),//(s|S)(u|U|�|�)(p|P)(e|E|�|�)(r|R)(g|G)(i|I|�|�)(r|R)(o|O|�|�)(s|S)((\\s)*(s|S)(\\.)?(a|A|�|�)(\\.)?)?
	//Abreviatura Tipos Documento
	PAL_NEG_ABREVIATURA_TIPO_DOC_CC_SEGUIDO_DOC("pal_neg_abreviatura_tipo_doc_cc_seguido_doc"),//(\\s)+((c|C){2})(\\.)(\\s)+
	PAL_NEG_ABREVIATURA_TIPO_DOC_TI_SEGUIDO_DOC("pal_neg_abreviatura_tipo_doc_ti_seguido_doc"),//(\\s)+(t|T)(i|I)(\\.)(\\s)+
	PAL_NEG_ABREVIATURA_TIPO_DOC_PA_SEGUIDO_DOC("pal_neg_abreviatura_tipo_doc_pa_seguido_doc"),//(\\s)+(p|P)(a|A)(\\.)(\\s)+
	PAL_NEG_ABREVIATURA_TIPO_DOC_CE_SEGUIDO_DOC("pal_neg_abreviatura_tipo_doc_ce_seguido_doc"),//(\\s)+(c|C)(e|E)(\\.)(\\s)+
	PAL_NEG_ABREVIATURA_TIPO_DOC_CEX_SEGUIDO_DOC("pal_neg_abreviatura_tipo_doc_cex_seguido_doc"),//(\\s)+(c|C)(e|E)(x|X)(\\.)(\\s)+
	PAL_NEG_ABREVIATURA_TIPO_DOC_NIT_SEGUIDO_DOC("pal_neg_abreviatura_tipo_doc_nit_seguido_doc"),//(\\s)+(n|N)(i|I)(t|T)(\\.)(\\s)+
	PAL_NEG_ABREVIATURA_TIPO_DOC_CC("pal_neg_abreviatura_tipo_doc_cc"),//(\\s)+((c|C){2})(\\s)+
	PAL_NEG_ABREVIATURA_TIPO_DOC_TI("pal_neg_abreviatura_tipo_doc_ti"),//(\\s)+(t|T)(i|I)(\\s)+
	PAL_NEG_ABREVIATURA_TIPO_DOC_PA("pal_neg_abreviatura_tipo_doc_pa"),//(\\s)+(p|P)(a|A)(\\s)+
	PAL_NEG_ABREVIATURA_TIPO_DOC_CE("pal_neg_abreviatura_tipo_doc_ce"),//(\\s)+(c|C)(e|E)(\\s)+
	PAL_NEG_ABREVIATURA_TIPO_DOC_CEX("pal_neg_abreviatura_tipo_doc_cex"),//(\\s)+(c|C)(e|E)(x|X)(\\s)+
	PAL_NEG_ABREVIATURA_TIPO_DOC_NIT("pal_neg_abreviatura_tipo_doc_nit"),//(\\s)+(n|N)(i|I)(t|T)(\\s)+
	//Productos
	PAL_NEG_NOMBRE_PRODUCTO_SUPER_COMBO("pal_neg_nombre_producto_super_combo"),//(s|S)(u|U|�|�)(p|P)(e|E|�|�)(r|R)(c|C)(o|O|�|�)(m|M)(b|B)(o|O|�|�)
	
	PAL_NEG_INICIO("pal_neg_inicio"),//(\\s)+('|"|�|`)?
	PAL_NEG_FIN("pal_neg_fin"),//('|"|�|`)?(\\s)+
	
	//Texto
	TXT_CARACTERES_QUE_CAUSAN_INICIO_MAYUSCULA("txt_caracteres_que_causan_inicio_mayuscula"),//\\.|\\?|\\!|\\:(\\s)*(\n)+|\u2022
	TXT_DETECTA_PALABRAS_ORACION("txt_detecta_palabras_oracion"),//[^\\s -]+
	TXT_DETECTA_LETRAS_EN_PALABRA("txt_detecta_letras_en_palabra"),//[aA-zZ �� �� �� �� ��]+
	
	//Autenticacion
	EXP_REG_AUT_LOGIN_USUARIO("exp_reg_formato_login_usuario"),//([0-9]|[_a-zA-Z-\\.]){1,30}
	EXP_REG_AUT_CONTRASENA_USUARIO("exp_reg_formato_contrasena_usuario"),//([0-9]|[_a-zA-Z-]){1,30}
	EXP_REG_AUT_CODIGO_VALIDACION("exp_reg_formato_codigo_validacion"),//(.){1,32767}
	
	//Cambio de Contrasena
	EXP_REG_CMC_CONTRASENA_USUARIO("exp_reg_cmdc_formato_contrasena_usuario"),//([0-9]|[_a-zA-Z-//.]){1,30}
	
	//Tercero
	EXP_REG_FORMATO_NOMBRES_TERCERO("exp_reg_formato_nombres_tercero"),//([a-zA-Z]|\\s){1,65}
	EXP_REG_FORMATO_NOMBRES_TERCERO_FINAL("exp_reg_formato_nombres_tercero_final"),//([a-zA-Z]|\\s){2,65}
	EXP_REG_FORMATO_PRIMER_APELLIDO_TERCERO("exp_reg_formato_primer_apellido_tercero"),//([a-zA-Z]|\\s){1,12}
	EXP_REG_FORMATO_PRIMER_APELLIDO_TERCERO_FINAL("exp_reg_formato_primer_apellido_tercero_final"),//([a-zA-Z]|\\s){2,12}
	EXP_REG_FORMATO_SEGUNDO_APELLIDO_TERCERO("exp_reg_formato_segundo_apellido_tercero"),//([a-zA-Z]|\\s){1,12}
	EXP_REG_FORMATO_SEGUNDO_APELLIDO_TERCERO_FINAL("exp_reg_formato_segundo_apellido_tercero_final"),//([a-zA-Z]|\\s){2,12}
	EXP_REG_FORMATO_TELEFONO_TERCERO("exp_reg_formato_telefono_tercero"),//([0-9]{10})?
	EXP_REG_FORMATO_CELULAR_TERCERO("exp_reg_formato_celular_tercero"),//(3[0-9]{9})?
	EXP_REG_FORMATO_CORREO_ELECTRONICO_TERCERO("exp_reg_formato_correo_electronico_tercero"),//
	
	//Documentos de Identificacion con respecto al tipo de documento
	EXP_REG_FORMATO_DOCUMENTO_CC("exp_reg_formato_documento_cc"),//[0-9]{1,35}
	EXP_REG_FORMATO_DOCUMENTO_TI("exp_reg_formato_documento_ti"),//[0-9]{1,35}
	EXP_REG_FORMATO_DOCUMENTO_NIT("exp_reg_formato_documento_nit"),//[0-9]{1,35}
	EXP_REG_FORMATO_DOCUMENTO_PA("exp_reg_formato_documento_pa"),//([0-9]|[A-Z]){1,35}
	EXP_REG_FORMATO_DOCUMENTO_CE("exp_reg_formato_documento_ce"),//([0-9]|[A-Z]){1,35}
	EXP_REG_FORMATO_DOCUMENTO_CEX("exp_reg_formato_documento_cex"),//([0-9]|[A-Z]){1,35}
	
	//Especificaciones de direccion
	EXP_REG_FORMATO_DIR_COMPLETO("exp_reg_formato_dir_completo"),//
	EXP_REG_FORMATO_DIR_COMPLETO_INTERNACIONAL("exp_reg_formato_dir_completo_internacional"),//
	EXP_REG_FORMATO_DIR_CLASE_VIA("exp_reg_formato_dir_clase_via"),//[a-zA-Z]+
	EXP_REG_FORMATO_DIR_ZONA("exp_reg_formato_dir_zona"),//[a-zA-Z]+
	EXP_REG_FORMATO_DIR_ESTRATO("exp_reg_formato_dir_estrato"),//[1-7]
	EXP_REG_FORMATO_DIR_CARACTERISTICA_LUGAR("exp_reg_formato_dir_caracteristica_lugar"),//[a-zA-Z]+
	EXP_REG_FORMATO_DIR_ESPECIFICACION_ABIERTA("exp_reg_formato_dir_especificacion_abierta"),//([0-9]|[a-zA-Z]|\\s){1,180}
	EXP_REG_FORMATO_DIR_ESPECIFICACION_ABIERTA_FINAL("exp_reg_formato_dir_especificacion_abierta_final"),//([0-9]|[a-zA-Z]|\\s){2,180}
	EXP_REG_FORMATO_DIR_TRADICIONAL_NUMERO_VIA("exp_reg_formato_dir_tradicional_numero_via"),//([0-9]|[a-zA-Z]){1,4}
	EXP_REG_FORMATO_DIR_TRADICIONAL_NUMERO_VIA_INTERNACIONAL("exp_reg_formato_dir_tradicional_numero_via_internacional"),//([0-9]|[a-zA-Z]){1,4}
	EXP_REG_FORMATO_DIR_TRADICIONAL_NUMERO_INTERSECCION("exp_reg_formato_dir_tradicional_numero_interseccion"),//([0-9]|[a-zA-Z]){1,4}
	EXP_REG_FORMATO_DIR_TRADICIONAL_NUMERO_INTERSECCION_INTERNACIONAL("exp_reg_formato_dir_tradicional_numero_interseccion_internacional"),//([0-9]|[a-zA-Z]){1,4}
	EXP_REG_FORMATO_DIR_TRADICIONAL_NUMERO_LUGAR("exp_reg_formato_dir_tradicional_numero_lugar"),//[0-9]{1,4}
	EXP_REG_FORMATO_DIR_TRADICIONAL_NUMERO_LUGAR_INTERNACIONAL("exp_reg_formato_dir_tradicional_numero_lugar_internacional"),//[0-9]{1,4}
	EXP_REG_FORMATO_DIR_ESPECIFICACION_LUGAR("exp_reg_formato_dir_especificacion_lugar"),//([0-9]|[a-zA-Z]|\\s){1,10}
	EXP_REG_FORMATO_DIR_NOMBRE_BARRIO("exp_reg_formato_dir_nombre_barrio"),//([0-9]|[a-zA-Z]|\\s){1,20}
	
	//Arqueo Caja
	EXP_REG_FORMATO_AQC_NUMERO_CHEQUE("exp_reg_formato_aqc_numero_cheque"),//[0-9]{1,10}
	EXP_REG_FORMATO_AQC_NOTAS_ARQUEO("exp_reg_formato_aqc_notas_arqueo"),//([0-9]|[a-zA-Z]|\\s){1,100}
	EXP_REG_FORMATO_AQC_BANCO_CHEQUE("exp_reg_formato_aqc_banco_cheque"),//([0-9]|[a-zA-Z]|\\s){1,100}
	EXP_REG_FORMATO_AQC_GIRADOR_CHEQUE("exp_reg_formato_aqc_girador_cheque"),//([0-9]|[a-zA-Z]|\\s){1,100}
	EXP_REG_FORMATO_AQC_NUMERO_VALE("exp_reg_formato_aqc_numero_vale"),//[0-9]{1,10}
	EXP_REG_FORMATO_AQC_CONCEPTO_VALE("exp_reg_formato_aqc_concepto_vale"),//([0-9]|[a-zA-Z]|\\s){1,100}
	EXP_REG_FORMATO_AQC_CANTIDAD_MONTO_BILLETES("exp_reg_formato_aqc_cantidad_monto_billetes"),//0|[1-9][0-9]{0,5}
	EXP_REG_FORMATO_AQC_CANTIDAD_MONTO_MONEDAS("exp_reg_formato_aqc_cantidad_monto_monedas"),//0|[1-9][0-9]{0,5}
	
	//Provision caja
	EXP_REG_FORMATO_PVC_NUM_LETRA("exp_reg_formato_pvc_num_letra"),//([0-9]|[a-zA-Z]|\\s){1,240}
	
	//Convenio Propiedades
	CVP_VALOR_PROPIEDAD_INGRESO("cvp_valor_propiedad_ingreso"),
	CVP_ALFANUMERICO("cvp_alfanumerico"),//[0-9a-zA-Z-_\\.\\@]
	
	//Datos adicionales
	CODIGO_APROBACION_TARJETAS_INGRESO("codigo_aprobacion_tarjetas_ingreso"),//[0-9a-zA-Z]{0,30}
	CODIGO_APROBACION_TARJETAS_FINAL("codigo_aprobacion_tarjetas_final"),//([0-9a-zA-Z]{6,30})?
	
	//Servicios adicionales
	//Clave de seguridad
	//Seccion clave seguridad manual
	PNL_CSM_CLAVE_INGRESO("pnl_csm_clave_ingreso"), //[0-9a-zA-Z]{1,<longitud_maxima>}
	PNL_CSM_CLAVE("pnl_csm_clave"), //[0-9a-zA-Z]{<longitud_minima>,<longitud_maxima>}
	//Seccion clave seguridad automatica
	PNL_CSA_CELULAR_TERCERO("pnl_csa_celular_tercero"),
	
	//Verificar clave de seguridad
	VCS_CLAVE_VERIFICACION("vcs_clave_verificacion"), //[0-9a-zA-Z]{1,<longitud_maxima>}
	
	//Ingreso y Egreso
	FORMATO_DINERO_SIN_CERO_IED("formato_dinero_sin_cero_ied"),//[1-9]([0-9]{0,1})((\\,([0-9]{0,3})){0,3})
	
	//Biometria
	BIO_TIPO_HUELLA_NOMBRE_ARCHIVO_WSQ("bio_tipo_huella_nombre_archivo_wsq"),//(\\.wsq)|[0-9]
	BIO_CONTENIDO_ARCHIVO_WSQ("bio_contenido_archivo_wsq"),//#|\\|
	
	//Parametros sistema
	//General
	PAR_SIS_NUMERICO_ENTERO("par_sis_numerico_entero",EnumEtiquetas.PS_TIPO_DATO_NUMERICO),//[0-9]{0,9}
	PAR_SIS_BANDERA_S_N("par_sis_bandera_s_n"),//S|N
	PAR_SIS_BANDERA_A_I("par_sis_bandera_a_i"),//A|I
	PAR_SIS_NOMBRE_ARCHIVO_DIRECTORIO("par_sis_nombre_archivo_directorio"),//[^\\\\/?<>*\":|]{0,148}
	PAR_SIS_BANDERA_SI_NO("par_sis_bandera_si_no"),//SI|NO
	//Negocio
	PAR_SIS_CONEXION_PARAMEMPWS("par_sis_conexion_paramempws"),//[0-9-.]{1,13}\\|[0-9]{1,4}
	PAR_SIS_ID_DOCUMENTO("par_sis_id_documento"),//[0-9]{1,6}
	//Especifico
	PAR_SIS_CAMAPEEN_CAMIALEL("par_sis_camapeen_camialel"),//[0-9]{0,9}|-1
	PAR_SIS_COTERCON_EXMSREMI("par_sis_cotercon_exmsremi"),//[0-9]{1,6};[0-9a-zA-Z]{1,35}(\\|[0-9]{1,6};[0-9a-zA-Z]{1,35})*
	PAR_SIS_CODIDOCU("par_sis_codidocu"),//[0-9]{1,6}(\\|[0-9]{1,6})*
	PAR_SIS_TIDOCPER("par_sis_tidocper"),
	PAR_SIS_TIDOTERC("par_sis_tidoterc"), //([0-9]{1,35})\\|([S|N])\\|([S|N])  --> ([0-9]{1,35})\\|([0-9]{1,35})
	
	//Internacionales
	
	//Giros Internacionales
	EXP_REG_FORMATO_PIN_GIRO_INTERNACIONAL("exp_reg_formato_pin_giro_internacional"),//([0-9]|[a-zA-Z-]){1,30}
	EXP_REG_FORMATO_PIN_GIRO_INTERNACIONAL2("exp_reg_formato_pin_giro_internacional2"),//([0-9]|[a-zA-Z-]){1,20}
	
	//Consulta giros internacionales
	CGI_NOMBRE_TERCERO("cgi_nombre_tercero"),//([a-zA-Z]|\\s){1,60}
	CGI_APELLIDO_TERCERO("cgi_apellido_tercero"),//([a-zA-Z]|\\s){1,60}
	
	//Gestion de reclamos
	GRI_COMENTARIO("gri_comentario"),//([0-9]|[a-zA-Z]|\\s){1,200}
	
	//Senales alerta
	INT_COMENTARIO_SENAL_ALERTA("int_comentario_senal_alerta"),//([0-9a-zA-Z]|\\s){0,500}
		
	//Mantenimiento Tercero Internacional
	INT_INGRESO_CIUDAD_NACIMIENTO("int_ingreso_ciudad_nacimiento"),//([a-zA-Z]|\\s){1,35}
	INT_INGRESO_TELEFONO_FIJO_CELULAR("int_ingreso_telefono_fijo_celular"),//[0-9]{1,10}
	INT_TELEFONO_FIJO_CELULAR("int_telefono_fijo_celular"),//[0-9]{6}|[0-9]{7}|[0-9]{10}
	INT_INGRESO_PRIMER_APELLIDO_TERCERO("int_ingreso_primer_apellido_tercero"),//([a-zA-Z]|\\s){1,65}
	INT_INGRESO_SEGUNDO_APELLIDO_TERCERO("int_ingreso_segundo_apellido_tercero"),//([a-zA-Z]|\\s){1,65}
	
	//Documentos de Identificacion con respecto al tipo de documento
	EXP_REG_FORMATO_DOCUMENTO_CC_INTER("exp_reg_formato_documento_cc_inter"),//[0-9]{1,35}
	EXP_REG_FORMATO_DOCUMENTO_TI_INTER("exp_reg_formato_documento_ti_inter"),//[0-9]{1,35}
	EXP_REG_FORMATO_DOCUMENTO_OT_INTER("exp_reg_formato_documento_ot_inter"),//[0-9]{1,35}
	EXP_REG_FORMATO_DOCUMENTO_PA_INTER("exp_reg_formato_documento_pa_inter"),//([0-9]|[A-Z]){1,35}
	EXP_REG_FORMATO_DOCUMENTO_CE_INTER("exp_reg_formato_documento_ce_inter"),//([0-9]|[A-Z]){1,35}
	
	//Enrolamiento
	EXP_VERIFICACION_ENROLAMIENTO("exp_verificacion_enrolamiento"), // (^[0-9]{1,2}\|[0-9]{1,10}\;?$)*
	
	//Lectors 2D
	EXP_VERIFICACION_LECTOR2D("exp_verificacion_lector2d"), // (^[0-9]{1,2}\|[0-9]{1,10}\;?$)*
	EXP_CAMPOS_A_COMPARAR("exp_campos_a_comparar"), // ([a-z0-9]\|?)*
	
	// Doble impresion
	EXP_VERIFICACION_TERCERO_DOBLE_IMPRESION("exp_verificacion_tercero_doble_impresion"),
	CONTROL_DOBLE_IMPRESION_TIRILLA_APODERADO("control_doble_impresion_tirilla_apoderado"),
	
	;
	
	private String codigo;

	private String valor;
	
	private boolean procesado;
	
	private EnumEtiquetas enmDescripcion;

	private EnumExpresionesRegulares(String pCodigo){
		
		this.codigo=pCodigo;
		this.procesado=false;
	}
	
	private EnumExpresionesRegulares(String pCodigo,
	                                 EnumEtiquetas pEnmDescripcion){
		
		this.codigo=pCodigo;
		this.procesado=false;
		this.enmDescripcion = pEnmDescripcion;
	}
	
	private void validaProcesado()throws Exception{
		
		if(!this.procesado){
			this.cargar();
			this.procesado=true;
		}
		
	}
	
	private void cargar()throws Exception{
		
		try{
			
			this.valor=EnumRecursosProperties.EXPRESIONES_REGULARES.getRsbRecurso().getString(this.codigo);
			
		}catch(Exception e){
			this.valor=null;
		}
		
	}

	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getValor() throws Exception{
		this.validaProcesado();
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	/**
	 * @method	getEnmDescripcion
	 * 		  	Metodo get del atributo enmDescripcion
	 * @return	EnumEtiquetas
	 *		  	Valor del atributo enmDescripcion devuelto
	 * @author	hector.cuenca
	 * @date  	31/08/2017
	 */
	public EnumEtiquetas getEnmDescripcion ()
	{
		return this.enmDescripcion;
	}

	/**
	 * @method	setEnmDescripcion
	 * 		  	Metodo set del atributo enmDescripcion
	 * @param	pEnmDescripcion
	 * 			Valor que tomara el atributo enmDescripcion
	 * @author	hector.cuenca
	 * @date	31/08/2017
	 */
	public void setEnmDescripcion (EnumEtiquetas pEnmDescripcion)
	{
		this.enmDescripcion = pEnmDescripcion;
	}

	public static String escaparCaracteresEspeciales(    String pStrCadena    )
            throws Exception
    {
        char[]    arrChrCadena;
        String strCadena = "";
        String strCaracterTemporal;

        arrChrCadena    =    pStrCadena.toCharArray();

        for    (    int i=0    ;    i< arrChrCadena.length ;    i++    )
        {
            strCaracterTemporal = String.valueOf(arrChrCadena[i]);

            if    ( UtilidadesGiros.getInstance().validaFormato(EnumExpresionesRegulares.GENERICA_CARACTERES_RESERVADOS.getValor(),
            													strCaracterTemporal)
            	  )
            {
                strCaracterTemporal = EnumExpresionesRegulares.GNR_ESCAPE.getValor() + strCaracterTemporal;
            }

            strCadena += strCaracterTemporal;
        }

        return strCadena;
    }
	
}

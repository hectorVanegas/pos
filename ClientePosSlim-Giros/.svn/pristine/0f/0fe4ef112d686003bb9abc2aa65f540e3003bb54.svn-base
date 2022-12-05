package co.com.codesa.clienteposslimgiros.enumeraciones;

import java.awt.Window;

import co.com.codesa.clienteposslimgiros.formas.mensajes.FormaMensajeAlerta;
import co.com.codesa.clienteposslimgiros.utilidades.mensajes.Mensaje;

/**
 * ****************************************************************.
 * @autor: Hector Q-en-K
 * @fecha: 09-mar-2015
 * @descripcion: Clase enumerador que permite recuperar los valores 
 * 				 constantes parametrizados en el archivo de propiedades 
 * 				 codigosMensajeGiros.properties
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public enum EnumMensajes{

	/**
    * @variable: listado de constantes de enumerador
    **/
	
	MENSAJE_PERSONALIZADO(EnumCodigosMensaje.MENSAJE_PERSONALIZADO),
	ERROR_GENERAL(EnumCodigosMensaje._99999),//99999: Se ha presentado un error inesperado consulte con el administrador del sistema.
	MENSAJE_NO_DOCUMENTADO(EnumCodigosMensaje._00226),//00226: Mensaje con codigo {1}. No encontrado en el sistema
	CAMPO_OBLIGATORIO(EnumCodigosMensaje._00018),//00018: El campo {1} no puede ser nulo. es obligatorio o hay problemas con su informacion.
	CAMPO_OBLIGATORIO_FORMULARIO(EnumCodigosMensaje._POS_055),//NEW031_Q: El campo {1}, es obligatorio y debe estar diligenciado
	CAMPO_NO_CUMPLE_CON_FORMATO(EnumCodigosMensaje._00019),//00019: El campo {1} tiene problemas con el formato o hay problemas con su informaciï¿½n.
	TERCERO_NO_EXISTE(EnumCodigosMensaje._00011),//00011: El tercero {1} no existe  o hay problemas con su informaciï¿½n.
	NO_CONCEPTO_PENDIENTE_X_ACEPTACION(EnumCodigosMensaje._00117),//00117: No se ha encontrado ninguna transacciï¿½n o concepto pendiente por aceptaciï¿½n.
	MENSAJE_NO_ESPECIFICADO(EnumCodigosMensaje._00000),//00000: No se recibiï¿½ especificaciï¿½n de mensaje
	OPERACION_REALIZADA_CORRECTAMENTE(EnumCodigosMensaje._POS_050),//NEW026_Q: Operaciï¿½n finalizada correctamente
	OPERACION_REALIZADA_CORRECTAMENTE_IMPRESION_ERROR(EnumCodigosMensaje._POS_054),//NEW030_Q: La operaciï¿½n se completï¿½ a nivel de transacciï¿½n, pero el sistema tuvo problemas para generar la impresiï¿½n.\n\nVerifiquï¿½ esta situaciï¿½n y comunï¿½quese con personal tï¿½cnico en el tema
	FORMATO_CAMPO_NO_CUMPLE(EnumCodigosMensaje._POS_063),//NEW039_Q: El campo no cumple con el formato esperado
	CONFIRMAR_REGISTRO_OPERACION(EnumCodigosMensaje._POS_071),//NEW047_Q: Estï¿½ a punto de hacer efectiva la operaciï¿½n.\n\nï¿½Estï¿½ seguro de querer continuar?
	CONFIRMACION_DATOS_A_ACTUALIZAR(EnumCodigosMensaje._POS_073),//NEW049_Q: Datos a actualizar: \n\n{1}\n\nï¿½Desea realizar esta actualizaciï¿½n?
	CONFIRMACION_NO_ACTUALIZO_NINGUN_DATO(EnumCodigosMensaje._POS_074),//NEW050_Q: No se ha editado ningï¿½n dato.\n\nï¿½Desea editar algï¿½n dato?
	NO_AUTORIZADO_PARA_MANTENIMIENTO_TERCERO_NIT(EnumCodigosMensaje._00227),//00227: El ï¿½nico autorizado para actualizar la informaciï¿½n de un tercero NIT es personal administrativo de SuperGIROS S.A.
	TERCERO_BLOQUEADO_X_CUMPLIMIENTO(EnumCodigosMensaje._00211),//00211: El tercero identificado con documento: {1}, se encuentra bloqueado por cumplimiento
	PROBLEMAS_CON_TERCEROS_EN_PAGO_GIRO(EnumCodigosMensaje._00260),//00260: No es posible realizar el pago de giro, debido a que alguno de los terceros involucrados, presenta problemas con su informaciï¿½n
	CAJA_YA_ESTA_ABIERTA(EnumCodigosMensaje._00026),//00026: La caja se encuentra abierta o hay problemas con su informaciï¿½n.
	TRAMA_RECIBIDA_NO_CORRESPONDE_TRAMA_SOLICITADA(EnumCodigosMensaje._00157),//00157: Id de la trama diferente
	PAGO_EXTERNO_REQUIERE_CONFIRMACION_DEL_PROVEEDOR(EnumCodigosMensaje._00247),//00247: La transacciï¿½n de pago externo que se acaba de efectuar no se completï¿½ satisfactoriamente, el sistema ejecutara el proceso "Reimpresiï¿½n - Reimprimir Ultimo Pago", para reconfirmar la transacciï¿½n en el sistema con el proveedor externo.
	FORMATO_IMPRESION_NO_ENCONTRADO(EnumCodigosMensaje._50108),//50108: Formato de impresion [{1} - {2}] no encontrado
	GIRO_EXTERNO_ESTA_PAGADO_SOBRE_SIMS(EnumCodigosMensaje._50122),//50122: El giro con Referencia Externa {1} ya fue pagado
	EJB_ERROR_NO_CONTROLADO(EnumCodigosMensaje._1010), //1010: Se ha presentado un error inesperado sobre la plataforma de integraciï¿½n hacia el proveedor de giros.
	SOCKET_SIMS_AGOTO_TIEMPO_ESPERA_(EnumCodigosMensaje._00137), //00137: Transaccion terminada por cliente por superar el tiempo de espera. Favor reintente la operacion.
	AGENCIA_SE_ENCUENTRA_INACTIVA(EnumCodigosMensaje._00012),//00012: La agencia {1} no existe. se encuentra inactiva o hay problemas con su informaciï¿½n.
	REALIZAR_AUTENTICACION_SIN_DESPLIEGUE_PRODUCTO_GIROS(EnumCodigosMensaje._POS_150),//POS_150: Para continuar con la operaciï¿½n, es necesario realizar el proceso de autenticaciï¿½n con el proveedor del producto giros, con la intenciï¿½n de validar el estado de caja.\n\nï¿½Desea continuar con la operaciï¿½n?
	DETECTA_CAJA_ACTIVA_PROPONER_CIERRE(EnumCodigosMensaje._POS_151),//POS_151: El sistema ha detectado una apertura de caja activa para el producto de giros.\n\nPara continuar con la operaciï¿½n, es necesario proceder inicialmente con el cierre del producto de giros.
	SISTEMA_NO_DETECTO_APERTURA_CAJA_ACTIVA(EnumCodigosMensaje._POS_152),//POS_152: El sistema no ha detectado ninguna apertura de caja activa para el producto de giros.
	NO_SE_LOGRO_COMPLETAR_CIERRE_CAJA_PROCESO_INTEGRACION_CIERRE_PRODUCTOS(EnumCodigosMensaje._POS_153),//POS_153: No se logrï¿½ completar el proceso de cierre del producto de giros.
	CVS_SE_BLOQUEA_PIN_X_TIEMPO(EnumCodigosMensaje._60091),//60091: Se bloquea PIN {1}
	SOCKET_EMPRESA_AGOTO_TIEMPO_ESPERA(EnumCodigosMensaje._SOC_000001),//SOC_000001: No se recibio respuesta por parte del ejb de giros.
	SOCKET_EMPRESA_ERROR_NO_CONTROLADO(EnumCodigosMensaje._SOC_000002),//SOC_000002: Se ha presentado un error en el Socket de venta. Por favor comuniquese con el area de soporte.
	EJB_ERROR_NO_CONTROLADO2(EnumCodigosMensaje._EJB_GIR_9999),//EJB_GIR_9999: Se ha presentado un error en el componente EJB. Por favor comuniquese con el area de soporte.
	EJB_AGOTO_TIEMPO_ESPERA(EnumCodigosMensaje._EJB_GIR_0009),//EJB_GIR_0009: No se recibe respuesta por parte del proveedor SIMS
	CONFIRMACION_ESTADO_SOLICITUD(EnumCodigosMensaje._POS_168),//POS_168: Se ha completado el proceso de solicitud, puede verificar su estado a travï¿½s de la funcionalidad de historial autorizaciones.\n\nï¿½Desea trasladarse a esta opciï¿½n para confirmar el estado de su solicitud?
	VERIFICAR_ESTADO_SOLICITUD_ANULACION(EnumCodigosMensaje._POS_169),//POS_169: Solicitud de anulaciï¿½n satisfactoria, verifique estado autorizaciï¿½n en historial autorizaciones, una vez aprobada imprima la anulaciï¿½n y verifique egreso.
	NO_HAY_COMUNICACION_CON_AFIS(EnumCodigosMensaje._47113),//47113: No Hay Comunicaciï¿½n con el AFIS
	FORMATO_HUELLA_NO_VALIDA(EnumCodigosMensaje._50051),//50051: Formato Huella no Valida
	ERROR_INSERTANDO(EnumCodigosMensaje._60142),//60142: ERROR INSERTANDO {1}
	HUELLA_YA_EXISTE_EN_SISTEMA(EnumCodigosMensaje._60077),//60077: No fue posible registrar la huella ya existe en el sistema Por favor comunï¿½quese con Super Giros
	
	//rmv
	CRITERIO_NO_SELECCIONADO(EnumCodigosMensaje._POS_001),//NEW001: Debe seleccionar un criterio de bï¿½squeda - rmv
	FECH_INI_MEN_ACT(EnumCodigosMensaje._POS_002),//NEW002: La fecha inicial debe ser menor o igual a la fecha actual. - rmv
	FECH_FIN_MEN_ACT(EnumCodigosMensaje._POS_003),//NEW003: La fecha final debe ser menor o igual a la fecha actual. - rmv
	FECH_INI_MENIG_FIN(EnumCodigosMensaje._POS_004),//NEW003: La fecha inicial debe ser menor o igual a la fecha fin. - rmv
	INGRESE_VALOR(EnumCodigosMensaje._POS_005),//NEW005: Ingrese valor. - rmv
	SEL_AGENCIA_DESTINO(EnumCodigosMensaje._POS_006),//NEW006: Seleccione la agencia destino. - rmv
	FAVOR_COTICE(EnumCodigosMensaje._POS_007),//NEW007: Por favor cotice. - rmv
	VALOR_RECIBIDO_INFERIOR_VALOR_COBRADO(EnumCodigosMensaje._POS_008),//NEW008: El total de monto ingresado debe cubrir el valor total del servicio.
	VERIFIQUE_TRANSACCION(EnumCodigosMensaje._POS_009),//NEW009: Por favor verifique si se generï¿½ el documento reimprimiendo ï¿½ltima facturaciï¿½n. - rmv
	TERCERO_TRAMITADOR_NOVALIDO(EnumCodigosMensaje._POS_012),//NEW012: Debe diligenciar un tercero tramitador valido. - rmv
	VERF_MEN_EDAD_PARAM_SINFECH(EnumCodigosMensaje._POS_013),//NEW013: El tercero beneficiario ingresado con documento {1},  es un menor de edad, verifique con el cliente, si la edad del tercero es mayor o igual a {2} aï¿½os, de lo contrario no se le podrï¿½ pagar el giro. ï¿½Desea continuar con la operaciï¿½n?. - rmv
	DILIGENCIAR_TERCERO(EnumCodigosMensaje._POS_014),//NEW014: Por favor ingrese algï¿½n tercero. - rmv
	VERF_MEN_EDAD_PARAM_CONFECH(EnumCodigosMensaje._POS_015),//NEW014: El usuario beneficiario es menor de {1} aï¿½os, razï¿½n por la cual la transacciï¿½n no puede ser realizada. - rmv
	VAL_GIRO_ERRONEO(EnumCodigosMensaje._POS_016),//NEW016: Valor giro incorrecto. El valor del plan convenio es incorrecto o no existe
	DEBE_SELECCIONAR_REGISTRO(EnumCodigosMensaje._POS_017),//NEW017: Debe seleccionar un registro valido.
	CONFIRMA_REALIZA_PROVISION(EnumCodigosMensaje._POS_018),//NEW018: ï¿½Esta seguro de registrar operacion de provision caja? Por concepto de {1}
	TRANSACCION_EXITOSA_PROVISION(EnumCodigosMensaje._POS_019),//NEW019: Transacciï¿½n realizada. \nPendiente de aceptaciï¿½n.
	PRIMERO_DEBE_CONSULTAR(EnumCodigosMensaje._POS_021), //NEW021: Primero debe realizar la consulta
	SOLO_SOLICITUD_ANULACION_AUTORIZADA(EnumCodigosMensaje._POS_022), ////NEW021: Esta operaci\u00F3n es exclusiva para solicitudes de anulaci\u00F3n autorizadas.
	DOCUMENTO_NO_DISPONIBLE_AGENCIA(EnumCodigosMensaje._POS_023), //NEW023: No esta disponible el documento {1} para esta agencia
	PRODUCTO_NO_DISPONIBLE_AGENCIA(EnumCodigosMensaje._POS_024), //NEW024: No esta disponible el producto {1} para esta agencia
	NO_HAY_DATOS(EnumCodigosMensaje._00046),//00046: No hay datos.
	TIPO_DOC_REMITENTE_NO_VALIDO_PARA_TRANSACCION(EnumCodigosMensaje._50089),//50089: Tipo de documento de usuario remitente no valido para realizar la transaccion.
	CAJA_NO_EXISTE_O_PROBLEMA_INFO(EnumCodigosMensaje._00013),//00013: La caja {1} no existe  o hay problemas con su informacion.
	TERRITORIO_SIN_AGENCIAS(EnumCodigosMensaje._00028),//00028: El territorio no tiene agencias o hay problemas con su informaciï¿½n.
	HUELLA_NO_CONICIDE_USUARIO(EnumCodigosMensaje._47112),//47112: Huella no coincide con la del usuario.
	BIO_ERROR_GENERAL(EnumCodigosMensaje._BIO_001),//BIO001
	BIO_NO_HUELLA_SIGUE_INTENTANDO(EnumCodigosMensaje._BIO_002),//BIO002: No se logrï¿½ detectar la huella. \n ï¿½Desea seguir intentando?
	BIO_NO_LECTOR_SIGUE_INTENTANDO(EnumCodigosMensaje._BIO_003),//BIO003: No se logrï¿½ detectar el lector. \n ï¿½Desea continuar?
	BIO_CAJERO_SIN_ROL_ENROLA_CLIENTE(EnumCodigosMensaje._BIO_004), //BIO004: El usuario con login {1}, no tiene configurado el rol para enrolar clientes.\n Por favor, comunï¿½quese con el ï¿½rea administrativa de SuperGIROS S.A.
	BIO_SOLICITA_HUELLA_REMITENTE(EnumCodigosMensaje._BIO_005),//BIO005: Por favor solicitar huella de remitente
	BIO_TERCERO_VALIDAR_BIOMETRIA(EnumCodigosMensaje._BIO_006),//BIO006: El tercero {1} sera validado biometricamente.
	BIO_DEBE_VALIDAR_BIOMETRIA(EnumCodigosMensaje._BIO_006),
	TERCERO_PROCESO_ENROLAR(EnumCodigosMensaje._BIO_007),//BIO007: El tercero {1} serï¿½ enrolado.
	DEBE_REALIZAR_VALIDACION_BIOMETRICA(EnumCodigosMensaje._BIO_009), //BIO_009: Debe realizar el proceso de biometria.
	SPC_TERCERO_NO_ASEGURABLE(EnumCodigosMensaje._SPC_001),//SPC001: El cliente {1} no puede ser asegurable
	SPC_NO_CONEXION_WS_SEGUROS_PROVEEDOR(EnumCodigosMensaje._SPC_002),//SPC002: No hay conexiï¿½n con el servicio web de seguros del proveedor
	SPC_NO_CONEXION_WS_SEGUROS_CODESA(EnumCodigosMensaje._SPC003),//SPC003: No hay conexiï¿½n con el servicio web de seguros de CODESA
	SPC_ERROR_CONSULTANDO_LISTA_NEGRA_SEGURO(EnumCodigosMensaje._SPC_004),//SPC004: Problema consultando lista negra
	SPC_SMS_NO_RECUERDE_ACTUALIZAR_NUMEROS(EnumCodigosMensaje._SPC_005),//SPC005:Seï¿½or usuario.\n Recuerde  actualizar  su  nï¿½mero  de  telï¿½fono  celular \n y el del beneficiario, asï¿½ podrï¿½ obtener los beneficios\n de los mensajes de texto.
	SPC_ACTUALIZA_CEL_TERCERO(EnumCodigosMensaje._SPC_006),//SPC006:La informaciï¿½n del telï¿½fono celular del tercero {1} ha cambiado, se procede a actualizarla.
	SPC_MSJ_REMITENTE_BENEFICIARIO_RECLAMA_GIRO(EnumCodigosMensaje._SPC_007),//SPC007:Se enviarï¿½ mensaje solo al remitente cuando el beneficiario reclame el giro.
	SPC_MSJ_BENEFICIARIO_INFORMACION_GIRO(EnumCodigosMensaje._SPC_008),//SPC008: Se enviarï¿½ mensaje solo al beneficiario con informaciï¿½n para reclamar el giro
	SPC_MSJ_REMITENTE_BENEFICIARIO_INFO_GIRO(EnumCodigosMensaje._SPC_009),//SPC009: Se enviarï¿½n mensajes al remitente y beneficiario informando el estado del giro.
	SPC_MSJ_NO_SE_ENVIA_MENSAJE(EnumCodigosMensaje._SPC_010),//SPC010: No se enviara ningï¿½n mensaje.
	SPC_ERROR_FACTURANDO_SEGURO_SIMS(EnumCodigosMensaje._SPC_011),//SPC011: No se pudo realizar la facturaciï¿½n del Seguro en SIMS.
	SPC_IMPRIMIR_CONTRATO_SEGURO(EnumCodigosMensaje._SPC_012),//SPC012: Se va a Imprimir Contrato Del Seguro.
	SPC_GIRO_EXITOSO_ERROR_SEGURO(EnumCodigosMensaje._SPC_013),//SPC013: El giro se guardï¿½ exitosamente. Pero no fue posible hacer el SuperCOMBO.\n Favor retornar el dinero del SuperCOMBO al cliente.
	SPC_GIRO_EXITOSO_ERROR_SMS(EnumCodigosMensaje._SPC_014),//SPC014: El giro se guardï¿½ exitosamente. Pero no fue posible enviar el mensaje de texto al destinatario.
	SPC_GIRO_ASEGURADO_REMITENTE(EnumCodigosMensaje._SPC_015),//SPC015: Giro asegurado por el remitente
	SPC_ERROR_FORMATO_VALOR_SEGURO(EnumCodigosMensaje._SPC_016),//SPC016: El valor del seguro no se encuentra configurado correctamente.
	SPC_MSJ_VTA_PROTEGIRO(EnumCodigosMensaje._SPC_017),//El valor del seguro será descontado del giro a pagar.
	SPC_GIRO_ASEGURADO_BENEFICIARIO(EnumCodigosMensaje._SPC_018),//SPC018: Giro asegurado por el beneficiario
	CNV_DOC_RECAUDO_CNV_NO_DISPONIBLE(EnumCodigosMensaje._CNV_001), //CNV001: No esta disponible el documento recaudo convenio para esta agencia.
	CNV_REVISAR_VALOR_ETIQUETA(EnumCodigosMensaje._CNV_002), //CNV002: Por favor revise el valor ingresado para la etiqueta {1}
	CNV_ERROR_CONSULTA_PROPIEDADES_CONVENIO(EnumCodigosMensaje._CNV_003), //CNV003: No se puede consultar las propiedades del convenio
	SAU_SOL_AUT_REFERENCIA_NO_CORRESPONDE(EnumCodigosMensaje._POS_149), //POS_148: La referencia consultada no corresponde a la solicitud seleccionada
	TKN_TELS_REMITENTE_DIFERENTES(EnumCodigosMensaje._POS_156), //POS_156: Los telefonos del remitente no coinciden.
	TKN_TELS_DESTINATARIO_DIFERENTES(EnumCodigosMensaje._POS_157), //POS_157: Los telefonos del destinatario no coinciden.
	TKN_CLAVES_DIFERENTES(EnumCodigosMensaje._POS_158), //POS_158: Las claves no coniciden.
	PARAMETRO_SISTEMA_FORMATO_NO_VALIDO(EnumCodigosMensaje._POS_159), //POS_159: El parametro {1}({2}) no cumple con el formato {3}
	SERVICIO_CLAVE_SEGURIDAD_AUTOMATICA_NO_DISPONIBLE(EnumCodigosMensaje._POS_160), //POS_160: El servicio de clave de seguridad de tipo automï¿½tico no estï¿½ disponible. Configuraciï¿½n de parï¿½metro {1} ({2}).
	
	/**
	 * @variable CLAVE_SEGURIDAD_MANUAL_INGRESADA_CORRECTA
	 * 			 Mensaje clave ingresada correcta
	 */
	CLAVE_SEGURIDAD_MANUAL_INGRESADA_CORRECTA(EnumCodigosMensaje._POS_161), //POS_161: La clave de seguridad ingresada es correcta
	
	/**
	 * @variable CLAVE_SEGURIDAD_MANUAL_INGRESADA_INCORRECTA
	 * 			 Mensaje clave ingresada incorrecta
	 */
	CLAVE_SEGURIDAD_MANUAL_INGRESADA_INCORRECTA(EnumCodigosMensaje._POS_162), //POS_162: La clave de seguridad ingresada es incorrecta
	DESEA_CANCELAR_SERVICIO_CLAVE_SEGURIDAD(EnumCodigosMensaje._POS_163), //POS_163: ï¿½Desea cancelar el servicio de clave de seguridad?
	REVISAR_CONFIGURACION_PARAMETRO_SISTEMA(EnumCodigosMensaje._POS_165),//POS_165: Se detectaron irregularidades de configuraciï¿½n a nivel administrativo, en el(s) siguiente(s) parï¿½metro(s) de sistema: \n{1}\nPor favor comunï¿½quese con personal administrativo para validar este suceso.
	VALOR_EXCEDE_LIMITE(EnumCodigosMensaje._POS_166),//POS_166: No se permite registro de la transaccion ya que el valor excede el limite, rectifique el valor y vuelva a intentar
	GIRO_CON_CLAVE_SEGURIDAD(EnumCodigosMensaje._POS_167),//POS_167: El giro se genero con clave de seguridad {1}
	DOCUMENTO_IDEN_DIFERENTE_CC_QR(EnumCodigosMensaje._POS_199),//POS_199:El documento de identidad digitado no corresponde al documento de identidad capturado de la cedula.
	SENALES_ALERTA_NULA(EnumCodigosMensaje._POS_192), //POS_192: Por favor ingresar un comentario.
	SENALES_ALERTA_MAX_8(EnumCodigosMensaje._POS_193), //POS_193: Solo se pueden enviar maximo 8 senales de alerta.
	SENALES_ALERTA_COMENTARIO_TAMANO(EnumCodigosMensaje._POS_OI_194),//POS_194 El comentario de señal de alerta de codigo {1} debe ser mayor a 10 caracteres y menor de 500."
	SENALES_ALERTA_CARACTERES_ESPECIALES(EnumCodigosMensaje._POS_OI_195),//POS_195 Por favor verificar el comentario de la señal de alerta de codigo {1} No se permiten caracteres especiales
	GIRO_INTERNACIONAL_ESTADO_PAGADO(EnumCodigosMensaje._POS_196), //POS_196: El numero de referencia consultado ya se encuentra pagado.
	BIO_COLOCAR_DEDO_LECTOR(EnumCodigosMensaje._BIO_008), //BIO_008: Ponga el dedo en el lector y pulse aceptar.
	DEBE_CAPTURAR_IMG_DOC_ANV_REV(EnumCodigosMensaje._POS_197), //POS_197: Debe capturar las fotos del documento, Anverso y Reverso.
	TERCERO_INTERNACIONAL_NO_EXISTE(EnumCodigosMensaje._FPISA_26666),//FPISA-26666: 
	TERCERO_CREADO_ACTUALIZADO_EXITOSO(EnumCodigosMensaje._POS_201), //POS_201: Tercero creado/actualizado exitosamente.
	SENALES_ALERTA_CONSULTA(EnumCodigosMensaje._FPISA_00000), //_FPISA_00000: {}
	PROTEGIRO_INTERNACIONAL_ANULADO_EXITOSAMENTE(EnumCodigosMensaje._POS_202), //POS_202: Anulacion de protegiro internacional exitoso {1}.
	DEBE_DILIGENCIAR_DATOS_EMPRESA(EnumCodigosMensaje._POS_203), //POS_203: Debe diligenciar los datos de empresa.
	DEBE_DILIGENCIAR_DATOS_CLIENTE_USUARIO(EnumCodigosMensaje._POS_204), //POS_204: Debe diligenciar los datos del cliente/usuario.
	ULTIMO_INICIO_SESION(EnumCodigosMensaje._POS_207), //POS_207: Se inicio sesion con {1} por ultima vez en la Agencia: {2} con la Caja: {3} el dia: {4}
	NUMEROS_DOCUMENTOS_NO_CONINCIDEN(EnumCodigosMensaje._POS_208), //POS_208: No coninciden los numero de documento 
	//rmv

	
	//<QenK>
	CAJA_APERTURADA_CORRECTAMENTE(EnumCodigosMensaje._POS_025),//NEW001_Q: La Caja ha sido correctamente aperturada
	DOC_XML_NO_EXISTE(EnumCodigosMensaje._POS_026),//NEW002_Q: El sistema no logro encontrar el documento XML \n\n{1}
	DESEA_CREAR_TERCERO(EnumCodigosMensaje._POS_027),//NEW003_Q: ï¿½Desea crear el tercero {1}?
	GIRO_PAGADO_EXITOSAMENTE(EnumCodigosMensaje._POS_028),//NEW004_Q: El giro con referencia: {1}, fue pagado exitosamente.\n\n{2}
	GIRO_PAGADO_PERO_IMPRESION_ERROR(EnumCodigosMensaje._POS_052),//NEW028_Q: El giro con referencia: {1}, fue pagado, pero no se logrï¿½ realizar el proceso de impresiï¿½n.\n\n{2}
	VALIDA_DIRECCION_TERCERO(EnumCodigosMensaje._POS_029),//NEW005_Q: El tercero {1}, ingresado con documento {2}, no presenta diligenciada la direccion.\n\n Sin la actualizacion de esta no es posible completar el proceso de {3} de giro postal
	VERIFICAR_INFORMACION_ACTUALIZADA_TERCERO(EnumCodigosMensaje._POS_030),//NEW006_Q: Verifique que la informaciï¿½n del tercero {1}, identificado con documento {2}, este actualizada
	DESEA_ACTUALIZAR_INFORMACION_TERCERO(EnumCodigosMensaje._POS_031),//NEW007_Q: ï¿½Desea actualizar la informaciï¿½n por parte del tercero {1}, identificado con el documento: {2}?
	VALIDA_FECHA_EXPEDICION_DOC_TERCERO(EnumCodigosMensaje._POS_032),//NEW008_Q: El tercero {1}, ingresado con documento {2}, no presenta diligenciada la fecha de expediciï¿½n.\n\n Sin la actualizaciï¿½n de esta no es posible completar el proceso de {3} de giro postal
	VALIDA_PAIS_EXPEDICION_DOC_TERCERO(EnumCodigosMensaje._POS_033),//NEW009_Q: El tercero {1}, ingresado con documento {2}, no presenta diligenciado el paï¿½s de expediciï¿½n.\n\n Sin la actualizaciï¿½n de esta no es posible completar el proceso de {3} de giro postal
	VALIDA_FECHA_ENTRADA_DOC_TERCERO(EnumCodigosMensaje._POS_034),//NEW010_Q: El tercero {1}, ingresado con documento {2}, no presenta diligenciada la fecha de entrada.\n\n Sin la actualizaciï¿½n de esta no es posible completar el proceso de {3} de giro postal
	VALIDA_FECHA_VENCIMIENTO_DOC_TERCERO(EnumCodigosMensaje._POS_035),//NEW011_Q: El tercero {1}, ingresado con documento {2}, no presenta diligenciada la fecha de vencimiento.\n\n Sin la actualizaciï¿½n de esta no es posible completar el proceso de {3} de giro postal
	INCONSISTENCIA_FECHA_NACIMIENTO_DOC_TERCERO(EnumCodigosMensaje._POS_036),//NEW012_Q: El tercero {1}, ingresado con documento {2}, presenta informaciï¿½n inconsistente con respecto a su fecha de nacimiento ({3}), en relaciï¿½n con el tipo de documento {4}, razï¿½n por la cual no es posible completar el proceso de {5} de giro postal.\n\nPor favor, comunï¿½quese con el ï¿½rea administrativa de SuperGIROS S.A.
	PERMITIR_INCONSISTENCIA_FECHA_NACIMIENTO_DOC_TERCERO(EnumCodigosMensaje._POS_037),//NEW013_Q: El tercero {1}, ingresado con documento {2}, presenta informaciï¿½n inconsistente con respecto a su fecha de nacimiento ({3}), en relaciï¿½n con el tipo de documento {4}; sin embargo se le permitirï¿½ realizar operaciones por {5} dï¿½as, a partir de la fecha, tiempo suficiente para corregir su situaciï¿½n.\n\nPor favor, remita al tercero con el personal de atenciï¿½n al cliente en SuperGIROS S.A. quienes le ayudaran a solucionar esta situaciï¿½n.
	VALIDA_FECHA_NACIMIENTO_DOC_TERCERO(EnumCodigosMensaje._POS_038),//NEW014_Q: El tercero {1}, ingresado con documento {2}, no presenta diligenciada la fecha de nacimiento.\n\n Sin la actualizaciï¿½n de esta no es posible completar el proceso de {3} de giro postal
	CONTENIDO_COMPONENTE_TEXTO_VACIO(EnumCodigosMensaje._POS_039),//NEW015_Q: Contenido no diligenciado
	CARGUE_INCOMPLETO_NO_PERMITE_CONTINUAR_OPERACION(EnumCodigosMensaje._POS_040),//NEW016_Q: El sistema no puede continuar con la operaciï¿½n, debido a que no se logrï¿½ completar un cargue de la informaciï¿½n exitoso.\n\nIntente ingresar nuevamente hasta la opciï¿½n deseada, y si persiste el problema consulte con el administrador acerca del tema
	DEBE_SELECCIONAR_DENOMINACION(EnumCodigosMensaje._POS_041),//NEW017_Q: Para realizar esta operaciï¿½n debe antes seleccionar una denominaciï¿½n valida de {1}
	EXISTE_DENOMINACION_CARGADA_DEL_MISMO_TIPO(EnumCodigosMensaje._POS_042),//NEW018_Q: Ya se encuentra cargada sobre la grilla un registro de este tipo
	DEBE_SELECCIONAR_REGISTRO_PARA_OPERACION(EnumCodigosMensaje._POS_043),//NEW019_Q: Debe seleccionar un registro de la grilla para proceder a ejecutar esta operaciï¿½n
	CUADRE_CAJA_INCONSISTENTE(EnumCodigosMensaje._POS_044),//NEW020_Q: El cuadre de caja es inconsistente, el valor total de caja, debe corresponder al valor total arqueado, sin ninguna diferencia
	CAJA_CERRADA_CORRECTAMENTE(EnumCodigosMensaje._POS_045),//NEW021_Q: La caja ha sido cerrada correctamente
	DESEA_CERRAR_SESION(EnumCodigosMensaje._POS_046),//NEW022_Q: ï¿½Estï¿½ seguro de querer cerrar la aplicaciï¿½n?
	DEBE_REALIZAR_CONSULTA_PARA_OPERACION(EnumCodigosMensaje._POS_047),//NEW023_Q: Debe realizar primero la operaciï¿½n de consulta para proceder con esta operaciï¿½n
	NO_INGRESO_CAMPO_DESEA_INGRESAR(EnumCodigosMensaje._POS_048),//NEW024_Q: No diligencio el campo {1}.\n\nï¿½Desea Diligenciarlo?
	CONFIRMACION_SOLICITUD_AUTORIZACION(EnumCodigosMensaje._POS_049),//NEW025_Q: Giro {1}, va a hacer: {2}.\n\nï¿½Desea continuar?
	TERCERO_BENEFICIARIO_NUEVO_IGUAL_DESTINO(EnumCodigosMensaje._POS_051),//NEW027_Q: El tercero {1} nuevo ingresado ({2}), debe ser diferente al tercero {3} actual ({4})
	VALOR_NO_VALIDO_PARA_CAMPO(EnumCodigosMensaje._POS_053),//NEW029_Q: El valor del campo: {1}, no es vï¿½lido para continuar con la operaciï¿½n
	DIRECCION_NO_CUMPLE_CON_FORMATO(EnumCodigosMensaje._POS_056),//NEW032_Q: La direcciï¿½n recibida como: {1}, no cumple con el formato esperado
	ZONA_DIRECCION_NO_ENCONTRADA(EnumCodigosMensaje._POS_057),//NEW033_Q: Zona recibida como: {1}, no fue reconocido por el sistema
	ESTRATO_DIRECCION_NO_ENCONTRADO(EnumCodigosMensaje._POS_058),//NEW034_Q: Estrato de barrio recibido como: {1}, no fue reconocido por el sistema
	CARACTERISTICA_LUGAR_DIRECCION_NO_ENCONTRADA(EnumCodigosMensaje._POS_059),//NEW035_Q: Caracterï¿½stica de lugar recibida como: {1}, no fue reconocida por el sistema
	CLASE_VIA_DIRECCION_NO_ENCONTRADA(EnumCodigosMensaje._POS_060),//NEW036_Q: Clase vï¿½a recibida como: {1}, no fue reconocida por el sistema
	CLASE_VIA_INCONSISTENTE_ABIERTA_ESPECIFICA(EnumCodigosMensaje._POS_061),//NEW037_Q: Clase vï¿½a recibida como abierta ({1}), pero estï¿½ configurada en el sistema, para diligenciarse de manera especifica
	CLASE_VIA_INCONSISTENTE_ESPECIFICA_ABIERTA(EnumCodigosMensaje._POS_062),//NEW038_Q: Clase vï¿½a recibida como especifica ({1}), pero estï¿½ configurada en el sistema, para diligenciarse de manera abierta
	TERCERO_CREADO_EXITOSAMENTE(EnumCodigosMensaje._POS_064),//NEW040_Q: El tercero identificado con documento {1}, fue creado exitosamente
	FECHA_1_MAYOR_IGUAL_FECHA_2(EnumCodigosMensaje._POS_065),//NEW041_Q: La {1}, debe ser un valor inferior a la {2}
	FECHA_1_MAYOR_FECHA_2(EnumCodigosMensaje._POS_066),//NEW042_Q: La {1}, debe ser un valor inferior o igual a la {2}
	FECHA_1_IGUAL_FECHA_2(EnumCodigosMensaje._POS_067),//NEW043_Q: La {1}, debe ser un valor inferior o superior a la {2}
	FECHA_1_MENOR_IGUAL_FECHA_2(EnumCodigosMensaje._POS_068),//NEW044_Q: La {1}, debe ser un valor superior a la {2}
	FECHA_1_MENOR_FECHA_2(EnumCodigosMensaje._POS_069),//NEW045_Q: La {1}, debe ser un valor superior o igual a la {2}
	EDAD_INCONSISTENTE_X_TIPO_DOCUMENTO(EnumCodigosMensaje._POS_070),//NEW046_Q: La edad del tercero es inconsistente con respecto al tipo de documento
	DETECTADA_INCONSISTENCA_INFO_DOCUMENTO_TERCERO(EnumCodigosMensaje._POS_072),//NEW048_Q: Se detectaron inconsistencias en la informaciï¿½n del documento del tercero. Informaciï¿½n que fue previamente diligenciada y no se considera apta para modificar una vez es ingresada.\n\nPor favor, remita al tercero con el personal de atenciï¿½n al cliente en SuperGIROS S.A. quienes le ayudaran a solucionar esta situaciï¿½n
	TERCERO_ACTUALIZADO_EXITOSAMENTE(EnumCodigosMensaje._POS_075),//NEW051_Q: El tercero identificado con documento {1}, fue actualizado exitosamente
	SISTEMA_REQUIERE_ACTUALIZAR_TERCERO(EnumCodigosMensaje._POS_076),//NEW052_Q: El sistema requiere actualizar la informaciï¿½n del tercero identificado con documento {1}
	TERCERO_BENEFICIARIO_NUEVO_NO_DILIGENCIADO(EnumCodigosMensaje._POS_077),//NEW053_Q: No se ha diligenciado el tercero beneficiario nuevo, para poder continuar con la operaciï¿½n
	ERROR_IMPRESION_VERIFIQUE_CONFIGURACIONES_LOCALES(EnumCodigosMensaje._POS_078),//NEW054_Q: Error ejecutando la impresiï¿½n.\n\nVerifique las configuraciones locales de la impresora.
	VERIFIQUE_ANTES_DE_IMPRIMIR(EnumCodigosMensaje._POS_079),//NEW055_Q: {1}\n\nAntes de imprimir, verifique los siguientes ï¿½tems y confirme: \n\n1. La disponibilidad de la impresora. \n\n2. La impresora seleccionada para la operaciï¿½n sea del tipo {2}.\n\n3. La papelerï¿½a de impresiï¿½n estï¿½ correctamente colocada. \n\n4. La papelerï¿½a sea la adecuada para la operaciï¿½n, que se encuentra realizando
	TIPO_IMPRESORA_NO_CONFIGURADA(EnumCodigosMensaje._POS_080),//NEW056_Q: El sistema no logro reconocer el tipo de impresora configurada sobre la aplicaciï¿½n
	IMPRESORA_NO_ENCONTRADA_IMPRIMIRA_PREDETERMINADA(EnumCodigosMensaje._POS_081),//NEW057_Q: El sistema no logro reconocer la impresora con nombre: "{1}", se procederï¿½ a imprimir en el recurso predeterminado
	IMPRESORA_NO_CONFIGURADA_IMPRIMIRA_PREDETERMINADA(EnumCodigosMensaje._POS_082),//NEW058_Q: El sistema no logro reconocer la configuraciï¿½n para el nombre de la impresora, se procederï¿½ a imprimir en el recurso predeterminado
	USUARIO_RECIBIDO_NO_CORRESPONDE_USUARIO_SOLICITANTE(EnumCodigosMensaje._POS_083),//NEW059_Q: La informaciï¿½n recibida no corresponde a la solicitada por el usuario
	DEBE_SELECCIONAR_UN_GIRO_PARA_PAGO(EnumCodigosMensaje._POS_084),//NEW060_Q: Para continuar con la operaciï¿½n debe en primera instancia consultar y seleccionar un giro de la grilla
	GIRO_DEBE_ESTAR_PENDIENTE_PARA_CONTINUAR(EnumCodigosMensaje._POS_085),//NEW061_Q: Para continuar con la operaciï¿½n, el giro seleccionado debe estar en estado pendiente
	PROMOCION_NO_DILIGENCIADA(EnumCodigosMensaje._POS_086),//NEW062_Q: Para continuar con la operaciï¿½n, se deben diligenciar los datos de la(s) promociï¿½n(s)
	SEGURO_REALIZADO_EXITOSAMENTE(EnumCodigosMensaje._POS_087),//NEW063_Q: El seguro con numero de pï¿½liza: {1}, fue realizado exitosamente
	SEGURO_REALIZADO_PERO_IMPRESION_ERROR(EnumCodigosMensaje._POS_088),//NEW064_Q: El seguro con numero de pï¿½liza: {1}, fue realizado, pero no se logrï¿½ generar su impresiï¿½n
	SMS_REALIZADO_EXITOSAMENTE(EnumCodigosMensaje._POS_089),//NEW065_Q: El mensaje `smsï¿½, fue enviado exitosamente
	SMS_REALIZADO_PERO_IMPRESION_ERROR(EnumCodigosMensaje._POS_090),//NEW066_Q: El mensaje `smsï¿½, fue enviado, pero no se logrï¿½ generar su impresiï¿½n
	GIRO_REALIZADO_EXITOSAMENTE(EnumCodigosMensaje._POS_091),//NEW067_Q: El giro fue realizado exitosamente, se generï¿½ el documento:  {1} - {2} nï¿½mero de referencia: {3}
	GIRO_REALIZADO_PERO_IMPRESION_ERROR(EnumCodigosMensaje._POS_092),//NEW068_Q: El giro fue realizado, con numero de referencia: {1}, pero no se logrï¿½ generar su impresiï¿½n
	DESEA_IMPRIMIR_PAGINA_PRUEBA(EnumCodigosMensaje._POS_093),//NEW069_Q: ï¿½Desea imprimir pï¿½gina de prueba?
	SE_NECESITAN_REGISTROS_EN_TABLA(EnumCodigosMensaje._POS_094),//NEW070_Q: Se necesitan registros sobre la tabla para proceder con la operaciï¿½n
	DUPLICIDAD_EN_DATOS_ADICIONALES(EnumCodigosMensaje._POS_095),//NEW071_Q: Ya existe informaciï¿½n cargada para los datos adicionales: {1}
	TOTAL_INGRESO_X_TARJETA_SUPERA_VALOR_SERVICIO(EnumCodigosMensaje._POS_096),//NEW072_Q: Valor ingresado por concepto de tarjeta supera el monto del valor del servicio
	RECAUDO_REALIZADO_EXITOSAMENTE(EnumCodigosMensaje._POS_097),//NEW073_Q: El recaudo fue realizado exitosamente, se generï¿½ el documento:  {1} - {2} nï¿½mero de referencia: {3}
	RECAUDO_REALIZADO_PERO_IMPRESION_ERROR(EnumCodigosMensaje._POS_098),//NEW074_Q: El recaudo fue realizado, con numero de referencia: {1}, pero no se logrï¿½ generar su impresiï¿½n
	RECAUDO_PAGADO_EXITOSAMENTE(EnumCodigosMensaje._POS_099),//NEW075_Q: El recaudo con referencia: {1}, fue pagado exitosamente
	RECAUDO_PAGADO_PERO_IMPRESION_ERROR(EnumCodigosMensaje._POS_100),//NEW076_Q: El recaudo con referencia: {1}, fue pagado, pero no se logrï¿½ realizar el proceso de impresiï¿½n
	CONFIRMAR_IMPRESION_COMPROBANTE(EnumCodigosMensaje._POS_101),//NEW077_Q: ï¿½Desea continuar con la impresiï¿½n del comprobante?
	SE_IMPRIMIRA_ULTIMO_PAGO_DE_GIRO_INTERNO(EnumCodigosMensaje._POS_102),//NEW078_Q: El sistema continuara con la impresiï¿½n del ï¿½ltimo pago de giro interno
	VERIFICAR_TRANSACCION_PENDIENTE(EnumCodigosMensaje._POS_103),//NEW079_Q: Existe una transacciï¿½n pendiente por confirmar, debe ejecutar el proceso de reimpresiï¿½n establecido
	RECOMENDACION_PARA_EVITAR_EXCESO_CONSULTA_PARAMETROS_SISTEMA(EnumCodigosMensaje._DES_002),//DES_002: Se recomienda a nivel de desarrollo ejecutar como buena prï¿½ctica, recuperar el valor del parï¿½metro: {1} ({2}), en una variable durante el proceso de negocio que se encuentra ejecutando, debido a que dicho parï¿½metro estï¿½ configurado para siempre consultarse, lo cual causa un consumo excesivo de la trama para consultar parï¿½metros de sistema
	VERIFICAR_CONFIGURACION_DIMENSION_COMPONENTE_GRAFICO(EnumCodigosMensaje._DES_004),//DES_004: Verifique la configuraciï¿½n realizada sobre la dimensiï¿½n identificada como: {1}, no cumple con la especificaciï¿½n esperada para una dimensiï¿½n
	VERIFICAR_CONFIGURACION_COLOR_COMPONENTE_GRAFICO(EnumCodigosMensaje._DES_005),//DES_005: Verifique la configuraciï¿½n realizada sobre el color identificado como: {1}, al parecer presenta problemas y/o no cumple con la especificaciï¿½n esperada para un color
	PARAMETRO_SISTEMA_NO_ENCONTRADO_EN_BD(EnumCodigosMensaje._POS_105),//NEW081_Q: El parï¿½metro: {1} ({2}), no se encontrï¿½ disponible en el sistema. Esta advertencia solo se presentara una sola vez, en pro para su comodidad; pero en caso que alguna operaciï¿½n se comporte irregularmente, no olvide mencionar esta advertencia al personal tï¿½cnico cuando remita la irregularidad.
	OPERACION_NO_CONFIGURADA_COMO_PROVEEDOR_SERVICIO_PRODUCTO(EnumCodigosMensaje._POS_106),//POS_106:No se encontrï¿½ configuraciï¿½n adecuada de la operacion {1} en productos virtuales, por favor revisar su configuraciï¿½n
	RECORDAR_ACTUALIZAR_FECHAS_PASAPORTE(EnumCodigosMensaje._POS_107),//NEW083_Q: Recuerde actualizar la fecha de entrada al pais y el vencimiento del tercero remitente con documento: {1}
	CAMPO_SIN_DESCRIPCION_NO_CUMPLE_CON_FORMATO(EnumCodigosMensaje._POS_147),//POS_147: Se ha detectado un campo sobre el formulario que no cumple con el formato esperado, serï¿½ seï¿½alado una vez se acepte este mensaje
	FECHA_NO_PERMITIDA_POR_EL_SISTEMA(EnumCodigosMensaje._POS_148),//POS_148: La fecha ingresada en: {1}, es una fecha no permitida por el sistema
	RESOLUCION_FORMA_SUPERA_MAXIMO_RECOMENDADO(EnumCodigosMensaje._POS_155),//POS_155: El tamaï¿½o de la forma, supera los temas de resoluciï¿½n recomendados: \n\n\u2022 Resoluciï¿½n actual: [{1},{2}] \n\u2022 Resoluciï¿½n mï¿½xima recomendada: [{3},{4}]
	COMPONENTE_SUPERA_MARCO_DE_CONTENEDOR_DESPLAZABLE(EnumCodigosMensaje._DES_001),//DES_001: El componente con nombre: [{1}], supera el marco establecido por el panel: [{2}].\n\nValide las dimensiones de ancho y alto de ambos componentes, dado que se recomienda que los componentes se adapten de manera ideal.\n\n{2}: [{3} X {4}].\n{1}: [{5} X {6}].
	LLAVE_CIFRADO_NO_TIENE_CANT_CARACTERES_REQUERIDA(EnumCodigosMensaje._48014),//48014: La llave de encriptacion de clave no se encuentra con la cantidad de caracteres permitida
	SE_REQUIERE_OBTENER_INFORMACION_PREVIA_PARA_EJECUTAR_PROCESO(EnumCodigosMensaje._DES_003),//DES_003: El proceso que se intenta ejecutar, identificado como: {1}, requiere obtener la informaciï¿½n relacionada con el(s) / la(s) {2}; sin esta informaciï¿½n no puede finalizar exitosamente dicho proceso, lo cual puede llegar a repercutir en la operaciï¿½n que se encuentra realizando
	TOKEN_D_MAL_CONFIGURADO(EnumCodigosMensaje._POS_164),//POS_164: La zona del vendedor {1} no se encuentra configurada dentro del parï¿½metro del sistema 'ZONASIMS' o parï¿½metro no existe. Por favor configurarlo en el Bnet Administrativo
	VALIDAR_PARAMETROS_SISTEMA_TIPOSERVICIO_PLSQL(EnumCodigosMensaje._DES_006),//DES_006: Validar en la funciï¿½n PL/SQL pkgn_businessnetintegragiros.func_validaplansims, involucrada en la trama 932, la inclusiï¿½n de todos los parï¿½metros de sistema que representan la consolidaciï¿½n de las operaciones de venta bajo un tipo servicio.\n\nPuede validar los parï¿½metros requeridos observando la configuraciï¿½n de las constantes de enumeraciï¿½n definidas en la clase EnumTiposServicios en su atributo strNombreParametroEmpresaVentaSIMS
	VALIDAR_CONFIGURACION_PARAMETROS_SISTEMA_TIPOSERVICIO(EnumCodigosMensaje._POS_170),//POS_170: Se ha detectado una configuraciï¿½n irregular en los parï¿½metros de sistema que reflejan los tipo servicios con los que consolidan las operaciones de venta relacionadas con el mï¿½dulo de giros.\n\nVerificar los valores de los siguientes parï¿½metros y que estos cumplan con los tipo servicios definidos para giros: {1}
	SOLICITAR_HUELLA_HUMEDA(EnumCodigosMensaje._POS_171),//POS_171: Por favor solicite al cliente la huella hï¿½meda para el comprobante de impresiï¿½n
	VALIDAR_PARAMETRO_TIPO_SERVICIO(EnumCodigosMensaje._POS_172),//POS_172: No es posible reconocer el tipo servicio asociado a la operaciï¿½n {1}. Validar la existencia y/o configuraciï¿½n del parï¿½metro de sistema {2}, a travï¿½s del 'Bnet Administrativo'
	NO_REALIZA_SEGURO_X_GIRO_NO_CONFIRMADO(EnumCodigosMensaje._POS_173),//POS_173: No fue posible registrar el PROTEGIRO, proceda a devolver el dinero de este seguro
	ERROR_GENERANDO_ARCHIVOS_WSQ_HUELLAS_TERCERO(EnumCodigosMensaje._POS_174),//POS_174: No fue posible almacenar las huellas del tercero
	DIRECTORIO_WSQ_SUPERO_PESO_MAXIMO_PERMITIDO_BIOMETRIA_LOCAL_DETENIDO(EnumCodigosMensaje._POS_175),//POS_175: La capacidad del folder de las huellas WSQ igualo o supero el tamaï¿½o mï¿½ximo permitido, no es posible realizar proceso de enrolamiento con biometrï¿½a local.\n\nTamaï¿½o permitido:   {1} Mb \u2013 Tamaï¿½o actual: {2} Mb
	PESO_DIRECTORIO_WSQ_ESTA_LLEGANDO_A_MAXIMO_PERMITIDO(EnumCodigosMensaje._POS_176),//POS_176: El folder de las huellas WSQ estï¿½ llegando a la capacidad mï¿½xima permitida, verificar proceso de transmisiï¿½n de huellas WSQ. \n\nTamaï¿½o mï¿½ximo permitido: {1} Mb - Tamaï¿½o actual: {2} Mb
	ERROR_DESCARGANDO_HUELLAS_ISO_TERCERO(EnumCodigosMensaje._POS_177),//POS_177: La caja identificada como: {1} - {2}, se encuentra configurada con biometrï¿½a local en la Forma [BICA] y se presentï¿½ un problema al descargar las huellas ISO por favor comunicarse con el administrador del sistema
	ERROR_ENVIANDO_HUELLAS_ISO_TERCERO(EnumCodigosMensaje._POS_178),//POS_178: Error enviando ISO de huellas en el procesamiento de la Biometrï¿½a Local
	HUELLAS_TERCERO_NO_COINCIDEN_LOCALMENTE(EnumCodigosMensaje._POS_179),//POS_179: Comunï¿½quese con el administrador del Sistema para gestionar una soluciï¿½n de este inconveniente, se descargaron las huellas de BD Central pero no coinciden con las del tercero
	FALTAN_PARAMETROS_PARA_REALIZAR_OPERACION_AFIS(EnumCodigosMensaje._POS_180),//POS_180: No se pudo completar la operaciï¿½n a nivel del AFIS, se detecta ausencia de parï¿½metros requeridos.
	ENTIDADES_TRAMA_PETICION_CON_MULTIPLES_CONEXIONES_CONFIGURADAS(EnumCodigosMensaje._POS_181),//POS_181: La entidad trama peticiï¿½n con nombre '{1}', se encuentra definida en el producto con mï¿½s de una conexiï¿½n particular para solicitar al proveedor, validar esto a nivel de desarrollo en la clase '{2}' del producto de giros.
	MULTIPLES_CONEXIONES_NEGOCIO(EnumCodigosMensaje._POS_182),//POS_182: Existe mï¿½s de una conexiï¿½n de negocio definida en el producto, validar esto a nivel de desarrollo en la clase '{1}' del producto de giros.
	USUARIO_NO_SUPERO_VALIDACION_BIOMETRIA_MULTISERVICIO(EnumCodigosMensaje._POS_198),//POS_198: El usuario no supero los controles biomï¿½tricos exigidos por la seguridad del sistema.
	PROBLEMA_CAPTURA_HUELLA_DESEA_INSISTIR(EnumCodigosMensaje._POS_190),//POS_190: Se presentï¿½ un problema en el sistema capturando la huella, ï¿½desea continuar intentï¿½ndolo?
	PROBLEMA_GENERANDO_IMAGEN_HUELLA(EnumCodigosMensaje._POS_191),//POS_190: No fue posible generar la imagen de la huella, por favor intente capturarla nuevamente
	TELEFONOS_NO_COINCIDEN(EnumCodigosMensaje._POS_183), //POS_183: El telï¿½fono ingresado no coincide con el confirmado
	NOTIFICAR_SMS_GIRO_ENVIADO_DESEA_ACTUALIZAR_CELULAR(EnumCodigosMensaje._POS_184),//POS_184: Como parte del proceso, el sistema notificara vï¿½a SMS al tercero {1} del giro.\n\nActualmente el tercero {1}, presenta el nï¿½mero de celular: {2}. ï¿½Desea actualizarlo?
	//NOTIFICAR_SMS_GIRO_ENVIADO(EnumCodigosMensaje._POS_185),//POS_185: Como parte del proceso, el sistema notificara vï¿½a SMS al tercero {1} del giro.
	NOTIFICAR_SMS_AGENCIAS_DISPONIBLES_DESEA_ACTUALIZAR_CELULAR(EnumCodigosMensaje._POS_209),//POS_209: Se notifica envió de SMS al tercero {1} con listado de posibles agencias para el cobro del giro según su valor.\n\nActualmente el tercero {1}, presenta el n\u00FAmero de celular\: {2}. \u00BFDesea actualizarlo?
	//NOTIFICAR_SMS_AGENCIAS_DISPONIBLES(EnumCodigosMensaje._POS_210),//POS_210: Se notifica envió de SMS al tercero {1} con listado de posibles agencias para el cobro del giro según su valor.
	PROCESO_AUTENTICACION_INCOMPLETO(EnumCodigosMensaje._POS_206),//POS_206: El sistema no logro completar el proceso de autenticación requerido para ingresar al producto de giros, razón por la cual se restringe el menú de opciones del producto
	NO_REIMPRIME_POR_ESTADO_GIRO(EnumCodigosMensaje._POS_211),//POS_211: El giro con referencia: {1}, se encuentra con estado {2}, no se permite reimprimir.
	TERCERO_ENROLADO_SATISFACTORAMENTE(EnumCodigosMensaje._POS_212),//POS_212: El tercero {1}, ha sido enrolado satisfactoriamente
	VALIDA_CIUDAD_EXPEDICION_DOC_TERCERO(EnumCodigosMensaje._POS_213),//NEW008_Q: El tercero {1}, ingresado con documento {2}, no presenta diligenciada la ciudad de expediciï¿½n.\n\n Sin la actualizaciï¿½n de esta no es posible completar el proceso de {3} de giro postal
	VALIDA_ACTIVIDAD_ECONOMICA_DOC_TERCERO(EnumCodigosMensaje._POS_214),//NEW008_Q: El tercero {1}, ingresado con documento {2}, no presenta diligenciada la actividad economica Sin la actualizaciï¿½n de esta no es posible completar el proceso de {3} de giro postal

	//</QenK>
	
	//vet
	DOC_TRANSAC_NO_EXISTE(EnumCodigosMensaje._00036),//00036: La transacciï¿½n del documento {1} no existe en transacciones x documento o hay problemas con su informaciï¿½n
	DLG_PREPARAR_IMPRESORA(EnumCodigosMensaje._POS_108),
	DLG_CONSULTA_FACTURA(EnumCodigosMensaje._POS_109),
	DLG_ASEGURA_ULTIMO_GIRO(EnumCodigosMensaje._POS_110),
	PAGO_GIROEXT_INCONVENIENTE(EnumCodigosMensaje._00261),   //APP||El sistema presenta giros externos con inconvenientes, procedera a reconfirmar la transaccion sobre los sistemas externo y el cliente de giros, y posterior a esto efectuara la reimpresion de la misma.
	PAGO_GIRO_EXTERNO_RESPUESTA_INCORRECTA_PROVEEDOR(EnumCodigosMensaje._00248),
	NO_TRANSAC_SEGURO(EnumCodigosMensaje._00207),//No hay Transacciones de Seguro
	NO_TRANSAC_SMS(EnumCodigosMensaje._00209),//No Hay Transacciones de SMS
	NO_ULTIMO_CIERRE(EnumCodigosMensaje._POS_111),
	NO_REFERENCIA_CONTROL(EnumCodigosMensaje._POS_112),//Por favor ingrese el nï¿½mero de referencia control
	CAMBIO_CONTRASENA_OK(EnumCodigosMensaje._POS_113),
	CONTRASENA_CONTIENE_CARACTERES_REPETIDOS(EnumCodigosMensaje._POS_114),
	CONTRASENA_MAYOR_CARACTERES(EnumCodigosMensaje._POS_115),
	CONTRASENA_DIFERENTE_ANTERIOR(EnumCodigosMensaje._POS_116),
	CONTRASENA_NO_PERMITIDA(EnumCodigosMensaje._POS_117),
	CONTRASENA_ERROR_CONFIRMACION(EnumCodigosMensaje._POS_118),
	CAMPOS_OBLIGATORIOS(EnumCodigosMensaje._POS_119),
	CONTRASENA_HA_CADUCADO(EnumCodigosMensaje._00110),
	CONTRASENA_NO_CAMBIO(EnumCodigosMensaje._POS_120),
	USUARIO_BLOQUEADO_X_INACTIVO(EnumCodigosMensaje._50045),
	CLAVE_YA_UTILIZADA(EnumCodigosMensaje._00202),
	DLG_CONSULTA_FACTURA_PAGO(EnumCodigosMensaje._POS_121),
	DLG_CONSULTA_FACTURA_SEGURO(EnumCodigosMensaje._POS_122),
	DLG_CONSULTA_FACTURA_SMS(EnumCodigosMensaje._POS_123),
	PAGO_GIRO_EXTERNO_X_VALIDAR(EnumCodigosMensaje._POS_124),
	CONTINUAR_REIMPRESION(EnumCodigosMensaje._POS_125),
	E_COMUNICACION_GIRO_IMPRESION(EnumCodigosMensaje._POS_126),//Se ha presentado un problema de Comunicaciï¿½n. Confirme el enviï¿½ del Giro en Modo Reimpresiï¿½n
	DLG_CONSULTA_FACTURA_INGRESO(EnumCodigosMensaje._POS_127),
	DLG_CONSULTA_FACTURA_EGRESO(EnumCodigosMensaje._POS_128),
	//CRENDON
	CONFIRMAR_RECHAZAR_DOCUMENTO(EnumCodigosMensaje._POS_129),
	CONFIRMAR_ACEPTAR_DOCUMENTO(EnumCodigosMensaje._POS_154),
	DOCUMENTO_RECHAZADO(EnumCodigosMensaje._POS_130),
	DOCUMENTO_ACEPTADO(EnumCodigosMensaje._POS_131),
	SELECCIONAR_REGISTRO(EnumCodigosMensaje._POS_132),
	INGRESAR_NOTA(EnumCodigosMensaje._POS_133),
	INGRESAR_TERCERO(EnumCodigosMensaje._POS_134),
	SELECCIONAR_CONCEPTO(EnumCodigosMensaje._POS_135),
	SELECCIONAR_MEDIOPAGO(EnumCodigosMensaje._POS_136),
	INGRESAR_VALOR(EnumCodigosMensaje._POS_137),
	SELECCIONAR_INGREGRE(EnumCodigosMensaje._POS_138),
	EXITO_INGRESO_EGRESO(EnumCodigosMensaje._POS_139),
	IMPRIMIR_COMPROBANTE_INGRESO_EGRESO(EnumCodigosMensaje._POS_140),
	NO_TRANSACCION_DOCUMENTO(EnumCodigosMensaje._00058),
	NOTAS_ADICION_PREGUNTA(EnumCodigosMensaje._POS_144),
	NOTAS_INSERTADA_EXITO(EnumCodigosMensaje._POS_145),
	NOTAS_CONFIRMA_SALIR(EnumCodigosMensaje._POS_146),
	
	PREGUNTA_PEPS(EnumCodigosMensaje._POS_SG_186),
	VERSION_NO_HABILITADA(EnumCodigosMensaje._POS_SG_187),
	
	REGISTRO_RECLAMOS(EnumCodigosMensaje._POS_200),
	
	TOMA_FOTO_EXITOSA(EnumCodigosMensaje._POS_186),
	TOMA_FOTO_ERRONEA(EnumCodigosMensaje._POS_187),
	TOMA_FOTO_ADVERTENCIA(EnumCodigosMensaje._POS_188),
	TOMA_FOTO_TERMINADA(EnumCodigosMensaje._POS_189),
	DEBE_SELECCIONAR_TIPO_IMAGEN(EnumCodigosMensaje._POS_205), //POS_205: Debe seleccionar un tipo de imagen.
	
	//Transmision de archivos
	TIMEOUT_NO_CONEXION_SOCKET_RECEPTOR(EnumCodigosMensaje._POS_194),
	ARCHIVO_NO_EXISTE(EnumCodigosMensaje._POS_195),
	
	//PEPS
	ALERTA_INGRESO_MARCA_PEPS(EnumCodigosMensaje._POS_SG_188),
	SELECCIONE_UNA_RESPUESTA_PEPS(EnumCodigosMensaje._POS_SG_189),
	
	//Envio de remesa internacional
	GIRO_ENVIADO_EXITOSAMENTE(EnumCodigosMensaje._POS_SG_190),
	FORMATO_FECHA_INVALIDO(EnumCodigosMensaje._POS_SG_196),
	FORMATO_FECHA_EXPEDICION_INVALIDO(EnumCodigosMensaje._POS_SG_197),
	
	//Operaciones Inusuales Remesas Internacionales
	TRANSACCION_ASOCIADA_BOTON_ELIMINAR(EnumCodigosMensaje._POS_SG_191),
	TRANSACCION_ASOCIADAS_PERMITIDAS(EnumCodigosMensaje._POS_SG_192),
	TRANSACCION_ASOCIADA_AGREGAR_VACIO(EnumCodigosMensaje._POS_SG_193),
	OPERACION_INUSUAL_EXITOSA(EnumCodigosMensaje._POS_SG_194),
	OPERACION_INUSUAL_MINIMO_TX_ASOCIADA(EnumCodigosMensaje._POS_SG_195),
	
	//CRC Prueba admision entrega de tirilla
	SELECCIONE_UNA_RESPUESTA_CRC(EnumCodigosMensaje._POS_SG_198),
	VALOR_NO_VALIDO(EnumCodigosMensaje._40212),
	ERROR_NUMEROS_CELULAR_CRC(EnumCodigosMensaje._POS_SG_199),
	PENDIENTES_NUMEROS_CELULAR_CRC(EnumCodigosMensaje._POS_SG_200),
	
	VALOR_TOKEN_INGRESOS_PARAM_IDREOPIE(EnumCodigosMensaje._POS_SG_201),//El valor del token de impresion de Ingresos en el parametro IDREOPIE debe ser S o N. Verificar forma PASI
	VALOR_TOKEN_EGRESOS_PARAM_IDREOPIE(EnumCodigosMensaje._POS_SG_202),//El valor del token de impresion de Egresos en el parametro IDREOPIE debe ser S o N. Verificar forma PASI
	ESTRUCTURA_PARAMETRO_IDREOPIE(EnumCodigosMensaje._POS_SG_203),//El valor del token de impresion de Ingresos en el parametro IDREOPIE debe ser S o N. Verificar forma PASI
	TOKEN_DE_PARAMETRO_VACIO(EnumCodigosMensaje._POS_SG_204),//Token del parametro IDREOPIE esta vacio. Por favor verificar forma PASI
	
	//Gico automatico
	GICO_AUTOMATICO_SE_DEBE_SELECCIONAR(EnumCodigosMensaje._POS_215),//Es necesario seleccionar el solicitante del pago.
	;
	
	
	private final EnumCodigosMensaje enmCodigoMensaje;
	
	private EnumMensajes(EnumCodigosMensaje pEnmCodigoMensaje){
		
		this.enmCodigoMensaje = pEnmCodigoMensaje;
	}
	
	public static Mensaje obtenerMensajePersonalizado(EnumClasesMensaje pEnmClaseMensaje,
		   	  										  String pStrCodigo,
		   	  										  String pStrDescripcion,
		   	  										  String ... pArrStrParametros)throws Exception{

		return EnumCodigosMensaje.obtenerMensajePersonalizado(pEnmClaseMensaje, 
															  pStrCodigo, 
															  pStrDescripcion, 
															  pArrStrParametros);
	}
	
	public static FormaMensajeAlerta desplegarMensajePersonalizado(Window pWinVentana,
			   													   EnumClasesMensaje pEnmClaseMensaje,
			   													   String pStrCodigo,
			   													   String pStrDescripcion,
			   													   String ... pArrStrParametros)throws Exception{

		return EnumCodigosMensaje.desplegarMensajePersonalizado(pWinVentana, 
																pEnmClaseMensaje, 
																pStrCodigo, 
																pStrDescripcion, 
																pArrStrParametros);
	}	
	
	public static Exception generarExcepcionPersonalizada(EnumClasesMensaje pEnmClaseMensaje,
			 										 	  String pStrCodigo,
			 										 	  String pStrDescripcion,
			 										 	  String ... pArrStrParametros)throws Exception{
		
		return EnumCodigosMensaje.generarExcepcionPersonalizada(pEnmClaseMensaje, 
														 		pStrCodigo, 
														 		pStrDescripcion, 
														 		pArrStrParametros);
	}
	
	public FormaMensajeAlerta desplegarMensaje(Window pWinVentana,
											   EnumClasesMensaje pEnmClaseMensaje,
											   String ... pArrStrParametros)throws Exception{
	
		return this.enmCodigoMensaje.desplegarMensaje(pWinVentana, 
													  pEnmClaseMensaje, 
													  pArrStrParametros);
	}
	
	public Mensaje obtenerMensaje(EnumClasesMensaje pEnmClaseMensaje,
			  					  String ... pArrStrParametros)throws Exception{
		
		return this.enmCodigoMensaje.obtenerMensaje(pEnmClaseMensaje,
													pArrStrParametros);
	}
	
	public Exception generarExcepcion(EnumClasesMensaje pEnmClaseMensaje,
			 					 	  String ... pArrStrParametros)throws Exception{
		
		return this.enmCodigoMensaje.generarExcepcion(pEnmClaseMensaje,
											   		 pArrStrParametros);
	}
	
	public String getCodigo() {
		
		return this.enmCodigoMensaje.getCodigo();
	}

	public String getMensaje() {
		
		return this.enmCodigoMensaje.getStrDescripcion();
	}

	public EnumCodigosMensaje getEnmCodigoMensaje() {
		return enmCodigoMensaje;
	}
}

package co.com.codesa.clienteposslimgiros.enumeraciones;

import java.awt.Window;
import co.com.codesa.clienteposslimexception.exceptions.ClientePosSlimGirosException;
import co.com.codesa.clienteposslimgiros.formas.mensajes.FormaMensajeAlerta;
import co.com.codesa.clienteposslimgiros.utilidades.mensajes.ControladorMensajes;
import co.com.codesa.clienteposslimgiros.utilidades.mensajes.Mensaje;

/**
 * ****************************************************************.
 * @autor: Hector Q-en-K
 * @fecha: 09-mar-2015
 * @strDescripcion: Clase enumerador que permite recuperar los valores 
 * 				 constantes parametrizados en el archivo de propiedades 
 * 				 codigosMensajeGiros.properties
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public enum EnumCodigosMensaje{

	/**
	 * Actualizar mensajes de BD:
	 * 
	 * Select '_'||M.CODIGO||'("'||M.CODIGO||'"),//'||M.CODIGO||': '||REPLACE(REPLACE(REPLACE(REPLACE(M.TEXTO,CHR(13),CHR(10)),CHR(10)||CHR(10),'\n\n'),CHR(10),' '),'  ',' ') 
	 * From MENSAJES M
	 * Order by M.CODIGO ASC
	 */
	
	/**
    * @variable: listado de constantes de enumerador
    **/
	
	_XXXXX("XXXXX"),//XXXXX: No se recibiï¿½ especificaciï¿½n de mensaje
	_00000("00000"),//00000: No se recibiï¿½ especificaciï¿½n de mensaje
	_99999("99999"),//99999: Se ha presentado un error inesperado consulte con el administrador del sistema.
	
	NO_DOCUMENTADO(null),
	MENSAJE_PERSONALIZADO(null),
	
	//<Equipo [BNet - CLiente Giros]>
	
	
	//Propios del producto [BNet - Cliente - Giros] (Prefijo POS, hace referencia a App Venta)
	
	_POS_001("POS_001"),//NEW001: Debe seleccionar un criterio de bï¿½squeda - rmv
	_POS_002("POS_002"),//NEW002: La fecha inicial debe ser menor o igual a la fecha actual. - rmv
	_POS_003("POS_003"),//NEW003: La fecha final debe ser menor o igual a la fecha actual. - rmv
	_POS_004("POS_004"),//NEW004: La fecha inicial debe ser menor o igual a la fecha final. - rmv
	_POS_005("POS_005"),//NEW005: Ingrese valor. - rmv
	_POS_006("POS_006"),//NEW006: Seleccione la agencia destino. - rmv
	_POS_007("POS_007"),//NEW007: Por favor cotice. - rmv
	_POS_008("POS_008"),//NEW008: El total de monto ingresado debe cubrir el valor total del servicio.
	_POS_009("POS_009"),//NEW009: Por favor verifique si se generï¿½ el documento reimprimiendo ï¿½ltima facturaciï¿½n. - rmv
	_POS_010("POS_010"),//NEW010: El proceso se realizï¿½ exitosamente, se generï¿½ el documento:  {1} - {2} nï¿½mero de referencia: {3} - rmv
	_POS_011("POS_011"),//NEW011: No se pudo imprimir el documento, valide movimiento en caja e intente de nuevo. Nï¿½mero de referencia: {1} - rmv
	_POS_012("POS_012"),//NEW012: Debe diligenciar un tercero tramitador valido. - rmv
	_POS_013("POS_013"),//NEW012: El tercero beneficiario ingresado con documento {1}, es un menor de edad, verifique con el cliente, si la edad del tercero es mayor o igual a {2} aï¿½os, de lo contrario no se le podrï¿½ pagar el giro. ï¿½Desea continuar con la operaciï¿½n? - rmv
	_POS_014("POS_014"),//NEW014: Por favor ingrese algï¿½n tercero. - rmv
	_POS_015("POS_015"),//NEW015: El usuario beneficiario es menor de {1} aï¿½os, razï¿½n por la cual la transacciï¿½n no puede ser realizada. - rmv
	_POS_016("POS_016"),//NEW016: Valor giro incorrecto. El valor del plan convenio es incorrecto o no existe. - rmv
	_POS_017("POS_017"),//NEW017: Debe seleccionar un registro valido. - rmv
	_POS_018("POS_018"),//NEW018: ï¿½Estï¿½ seguro de registrar operaciï¿½n de provisiï¿½n caja? \nPor concepto de {1}. - rmv
	_POS_019("POS_019"),//NEW019: ï¿½Estï¿½ seguro de registrar operaciï¿½n de provisiï¿½n caja? \nPor concepto de {1}. - rmv
	_POS_021("POS_021"),//NEW021: Primero debe realizar la consulta
	_POS_022("POS_022"),//NEW022: Esta operaci\u00F3n es exclusiva para solicitudes de anulaci\u00F3n autorizadas.
	_POS_023("POS_023"),//NEW023: No esta disponible el documento {1} para esta agencia
	_POS_024("POS_024"),//NEW024: No esta disponible el producto {1} para esta agencia
	_POS_025("POS_025"),//POS_025: La Caja ha sido correctamente aperturada
	_POS_026("POS_026"),//POS_026: El sistema no logro encontrar el documento XML \n\n{1}
	_POS_027("POS_027"),//POS_027: ï¿½Desea crear el tercero {1}?
	_POS_028("POS_028"),//POS_028: El giro con referencia: {1}, fue pagado exitosamente.\n\n{2}
	_POS_029("POS_029"),//POS_029: El tercero {1}, ingresado con documento {2}, no presenta diligenciada la direccion.\n\n Sin la actualizacion de esta no es posible completar el proceso de {3} de giro postal
	_POS_030("POS_030"),//POS_030: Verifique que la informaciï¿½n del tercero {1}, identificado con documento {2}, este actualizada
	_POS_031("POS_031"),//POS_031: ï¿½Desea actualizar la informaciï¿½n por parte del tercero {1}, identificado con el documento: {2}?
	_POS_032("POS_032"),//POS_032: El tercero {1}, ingresado con documento {2}, no presenta diligenciada la fecha de expedicion.\n\n Sin la actualizacion de esta no es posible completar el proceso de {3} de giro postal
	_POS_033("POS_033"),//POS_033: El tercero {1}, ingresado con documento {2}, no presenta diligenciado el paï¿½s de expediciï¿½n.\n\n Sin la actualizaciï¿½n de esta no es posible completar el proceso de {3} de giro postal
	_POS_034("POS_034"),//POS_034: El tercero {1}, ingresado con documento {2}, no presenta diligenciada la fecha de entrada.\n\n Sin la actualizaciï¿½n de esta no es posible completar el proceso de {3} de giro postal
	_POS_035("POS_035"),//POS_035: El tercero {1}, ingresado con documento {2}, no presenta diligenciada la fecha de vencimiento.\n\n Sin la actualizaciï¿½n de esta no es posible completar el proceso de {3} de giro postal
	_POS_036("POS_036"),//POS_036: El tercero {1}, ingresado con documento {2}, presenta informaciï¿½n inconsistente con respecto a su fecha de nacimiento ({3}), en relaciï¿½n con el tipo de documento {4}, razï¿½n por la cual no es posible completar el proceso de {5} de giro postal.\n\nPor favor, comunï¿½quese con el ï¿½rea administrativa de SuperGIROS S.A.
	_POS_037("POS_037"),//POS_037: El tercero {1}, ingresado con documento {2}, presenta informaciï¿½n inconsistente con respecto a su fecha de nacimiento ({3}), en relaciï¿½n con el tipo de documento {4}; sin embargo se le permitirï¿½ realizar operaciones por {5} dï¿½as, a partir de la fecha, tiempo suficiente para corregir su situaciï¿½n.\n\nPor favor, remita al tercero con el personal de atenciï¿½n al cliente en SuperGIROS S.A. quienes le ayudaran a solucionar esta situaciï¿½n.
	_POS_038("POS_038"),//POS_038: El tercero {1}, ingresado con documento {2}, no presenta diligenciada la fecha de nacimiento.\n\n Sin la actualizaciï¿½n de esta no es posible completar el proceso de {3} de giro postal
	_POS_039("POS_039"),//POS_039: Contenido no diligenciado
	_POS_040("POS_040"),//POS_040: El sistema no puede continuar con la operaciï¿½n, debido a que no se logrï¿½ completar un cargue de la informaciï¿½n exitoso.\n\nIntente ingresar nuevamente hasta la opciï¿½n deseada, y si persiste el problema consulte con el administrador acerca del tema
	_POS_041("POS_041"),//POS_041: Para realizar esta operaciï¿½n debe antes seleccionar una denominaciï¿½n valida de {1}
	_POS_042("POS_042"),//POS_042: Ya se encuentra cargada sobre la grilla un registro de este tipo
	_POS_043("POS_043"),//POS_043: Debe seleccionar un registro de la grilla para proceder a ejecutar esta operaciï¿½n
	_POS_044("POS_044"),//POS_044: El cuadre de caja es inconsistente, el valor total de caja, debe corresponder al valor total arqueado, sin ninguna diferencia
	_POS_045("POS_045"),//POS_045: La caja ha sido cerrada correctamente
	_POS_046("POS_046"),//POS_046: ï¿½Estï¿½ seguro de querer cerrar la aplicaciï¿½n?
	_POS_047("POS_047"),//POS_047: Debe realizar primero la operaciï¿½n de consulta para proceder con esta operaciï¿½n
	_POS_048("POS_048"),//POS_048: No diligencio el campo {1}.\n\nï¿½Desea Diligenciarlo?
	_POS_049("POS_049"),//POS_049: Giro {1}, va a hacer: {2}.\n\nï¿½Desea continuar?
	_POS_050("POS_050"),//POS_050: Operaciï¿½n finalizada correctamente
	_POS_051("POS_051"),//POS_051: El tercero {1} nuevo ingresado ({2}), debe ser diferente al tercero {3} actual ({4})
	_POS_052("POS_052"),//POS_052: El giro con referencia: {1}, fue pagado, pero no se logrï¿½ realizar el proceso de impresiï¿½n.\n\n{2}
	_POS_053("POS_053"),//POS_053: El valor del campo: {1}, no es vï¿½lido para continuar con la operaciï¿½n
	_POS_054("POS_054"),//POS_054: La operaciï¿½n se completï¿½ a nivel de transacciï¿½n, pero el sistema tuvo problemas para generar la impresiï¿½n.\n\nVerifiquï¿½ esta situaciï¿½n y comunï¿½quese con personal tï¿½cnico en el tema
	_POS_055("POS_055"),//POS_055: El campo {1}, es obligatorio y debe estar diligenciado
	_POS_056("POS_056"),//POS_056: La direcciï¿½n recibida como: {1}, no cumple con el formato esperado
	_POS_057("POS_057"),//POS_057: Zona recibida como: {1}, no fue reconocido por el sistema
	_POS_058("POS_058"),//POS_058: Estrato de barrio recibido como: {1}, no fue reconocido por el sistema
	_POS_059("POS_059"),//POS_059: Caracterï¿½stica de lugar recibida como: {1}, no fue reconocida por el sistema
	_POS_060("POS_060"),//POS_060: Clase vï¿½a recibida como: {1}, no fue reconocida por el sistema
	_POS_061("POS_061"),//POS_061: Clase vï¿½a recibida como abierta ({1}), pero estï¿½ configurada en el sistema, para diligenciarse de manera especifica
	_POS_062("POS_062"),//POS_062: Clase vï¿½a recibida como especifica ({1}), pero estï¿½ configurada en el sistema, para diligenciarse de manera abierta
	_POS_063("POS_063"),//POS_063: El campo no cumple con el formato esperado
	_POS_064("POS_064"),//POS_064: El tercero identificado con documento {1}, fue creado exitosamente
	_POS_065("POS_065"),//POS_065: La {1}, debe ser un valor inferior a la {2}
	_POS_066("POS_066"),//POS_066: La {1}, debe ser un valor inferior o igual a la {2}
	_POS_067("POS_067"),//POS_067: La {1}, debe ser un valor inferior o superior a la {2}
	_POS_068("POS_068"),//POS_068: La {1}, debe ser un valor superior a la {2}
	_POS_069("POS_069"),//POS_069: La {1}, debe ser un valor superior o igual a la {2}
	_POS_070("POS_070"),//POS_070: La edad del tercero es inconsistente con respecto al tipo de documento
	_POS_071("POS_071"),//POS_071: Estï¿½ a punto de hacer efectiva la operaciï¿½n.\n\nï¿½Estï¿½ seguro de querer continuar?
	_POS_072("POS_072"),//POS_072: Se detectaron inconsistencias en la informaciï¿½n del documento del tercero. Informaciï¿½n que fue previamente diligenciada y no se considera apta para modificar una vez es ingresada.\n\nPor favor, remita al tercero con el personal de atenciï¿½n al cliente en SuperGIROS S.A. quienes le ayudaran a solucionar esta situaciï¿½n
	_POS_073("POS_073"),//POS_073: Datos a actualizar: \n\n{1}\n\nï¿½Desea realizar esta actualizaciï¿½n?
	_POS_074("POS_074"),//POS_074: No se ha editado ningï¿½n dato.\n\nï¿½Desea editar algï¿½n dato?
	_POS_075("POS_075"),//POS_075: El tercero identificado con documento {1}, fue actualizado exitosamente
	_POS_076("POS_076"),//POS_076: El sistema requiere actualizar la informaciï¿½n del tercero identificado con documento {1}
	_POS_077("POS_077"),//POS_077: No se ha diligenciado el tercero beneficiario nuevo, para poder continuar con la operaciï¿½n
	_POS_078("POS_078"),//POS_078: Error ejecutando la impresiï¿½n.\n\nVerifique las configuraciones locales de la impresora.
	_POS_079("POS_079"),//POS_079: {1}\n\nAntes de imprimir, verifique los siguientes ï¿½tems y confirme: \n\n1. La disponibilidad de la impresora. \n\n2. La impresora seleccionada para la operaciï¿½n sea del tipo {2}.\n\n3. La papelerï¿½a de impresiï¿½n estï¿½ correctamente colocada. \n\n4. La papelerï¿½a sea la adecuada para la operaciï¿½n, que se encuentra realizando
	_POS_080("POS_080"),//POS_080: El sistema no logro reconocer el tipo de impresora configurada sobre la aplicaciï¿½n
	_POS_081("POS_081"),//POS_081: El sistema no logro reconocer la impresora con nombre: "{1}", se procederï¿½ a imprimir en el recurso predeterminado
	_POS_082("POS_082"),//POS_082: El sistema no logro reconocer la configuraciï¿½n para el nombre de la impresora, se procederï¿½ a imprimir en el recurso predeterminado
	_POS_083("POS_083"),//POS_083: La informaciï¿½n recibida no corresponde a la solicitada por el usuario
	_POS_084("POS_084"),//POS_084: Para continuar con la operaciï¿½n debe en primera instancia consultar y seleccionar un giro de la grilla
	_POS_085("POS_085"),//POS_085: Para continuar con la operaciï¿½n, el giro seleccionado debe estar en estado pendiente
	_POS_086("POS_086"),//POS_086: Para continuar con la operaciï¿½n, se deben diligenciar los datos de la(s) promociï¿½n(s)
	_POS_087("POS_087"),//POS_087: El seguro con numero de pï¿½liza: {1}, fue realizado exitosamente
	_POS_088("POS_088"),//POS_088: El seguro con numero de pï¿½liza: {1}, fue realizado, pero no se logrï¿½ generar su impresiï¿½n
	_POS_089("POS_089"),//POS_089: El mensaje `smsï¿½, fue enviado exitosamente
	_POS_090("POS_090"),//POS_090: El mensaje `smsï¿½, fue enviado, pero no se logrï¿½ generar su impresiï¿½n
	_POS_091("POS_091"),//POS_091: El giro fue realizado exitosamente, se generï¿½ el documento:  {1} - {2} nï¿½mero de referencia: {3}
	_POS_092("POS_092"),//POS_092: El giro fue realizado, con numero de referencia: {1}, pero no se logrï¿½ generar su impresiï¿½n
	_POS_093("POS_093"),//POS_093: ï¿½Desea imprimir pï¿½gina de prueba?
	_POS_094("POS_094"),//POS_094: Se necesitan registros sobre la tabla para proceder con la operaciï¿½n
	_POS_095("POS_095"),//POS_095: Ya existe informaciï¿½n cargada para los datos adicionales: {1}
	_POS_096("POS_096"),//POS_096: Valor ingresado por concepto de tarjeta supera el monto del valor del servicio
	_POS_097("POS_097"),//POS_097: El recaudo fue realizado exitosamente, se generï¿½ el documento:  {1} - {2} nï¿½mero de referencia: {3}
	_POS_098("POS_098"),//POS_098: El recaudo fue realizado, con numero de referencia: {1}, pero no se logrï¿½ generar su impresiï¿½n
	_POS_099("POS_099"),//POS_099: El recaudo con referencia: {1}, fue pagado exitosamente
	_POS_100("POS_100"),//POS_100: El recaudo con referencia: {1}, fue pagado, pero no se logrï¿½ realizar el proceso de impresiï¿½n
	_POS_101("POS_101"),//POS_101: ï¿½Desea continuar con la impresiï¿½n del comprobante?
	_POS_102("POS_102"),//POS_102: El sistema continuara con la impresiï¿½n del ï¿½ltimo pago de giro interno
	_POS_103("POS_103"),//POS_103: Existe una transacciï¿½n pendiente por confirmar, debe ejecutar el proceso de reimpresiï¿½n establecido
	//_POS_104("POS_104"),//POS_104: El valor del parï¿½metro de consulta fija: {1} ({2}), debe re-consultarse, dejo de estar disponible por superar el tiempo estipulado para obtener su valor
	_POS_105("POS_105"),//POS_105: El parï¿½metro: {1} ({2}), no se encontrï¿½ disponible en el sistema. Esta advertencia solo se presentara una sola vez, en pro para su comodidad; pero en caso que alguna operaciï¿½n se comporte irregularmente, no olvide mencionar esta advertencia al personal tï¿½cnico cuando remita la irregularidad.
	_POS_106("POS_106"),//POS_106: No se encontrï¿½ configuraciï¿½n adecuada de la operacion {1} en productos virtuales, por favor revisar su configuraciï¿½n
	_POS_107("POS_107"),//POS_107: Recuerde actualizar la fecha de entrada al pais y el vencimiento del tercero remitente con documento: {1}
	_POS_108("POS_108"),
	_POS_109("POS_109"),
	_POS_110("POS_110"),
	_POS_111("POS_111"),
	_POS_112("POS_112"),
	_POS_113("POS_113"),
	_POS_114("POS_114"),
	_POS_115("POS_115"),
	_POS_116("POS_116"),
	_POS_117("POS_117"),
	_POS_118("POS_118"),
	_POS_119("POS_119"),
	_POS_120("POS_120"),
	_POS_121("POS_121"),
	_POS_122("POS_122"),
	_POS_123("POS_123"),
	_POS_124("POS_124"),
	_POS_125("POS_125"),
	_POS_126("POS_126"),
	_POS_127("POS_127"),
	_POS_128("POS_128"),
	_POS_129("POS_129"),
	_POS_130("POS_130"),
	_POS_131("POS_131"),
	_POS_132("POS_132"),
	_POS_133("POS_133"),
	_POS_134("POS_134"),
	_POS_135("POS_135"),
	_POS_136("POS_136"),
	_POS_137("POS_137"),
	_POS_138("POS_138"),
	_POS_139("POS_139"),
	_POS_140("POS_140"),
	_POS_141("POS_141"),
	_POS_142("POS_142"),
	_POS_143("POS_143"),
	_POS_144("POS_144"),
	_POS_145("POS_145"),
	_POS_146("POS_146"),
	_POS_147("POS_147"),//POS_147: Se ha detectado un campo sobre el formulario que no cumple con el formato esperado, serï¿½ seï¿½alado una vez se acepte este mensaje
	_POS_148("POS_148"),//POS_148: La fecha ingresada en: {1}, es una fecha no permitida por el sistema
	_POS_149("POS_149"),//POS_149: La referencia consultada no corresponde a la solicitud seleccionada
	_POS_150("POS_150"),//POS_150: Para continuar con la operaciï¿½n, es necesario realizar el proceso de autenticaciï¿½n con el proveedor del producto giros, con la intenciï¿½n de validar el estado de caja.\n\nï¿½Desea continuar con la operaciï¿½n?
	_POS_151("POS_151"),//POS_151: El sistema ha detectado una apertura de caja activa para el producto de giros.\n\nPara continuar con la operaciï¿½n, es necesario proceder inicialmente con el cierre del producto de giros.
	_POS_152("POS_152"),//POS_152: El sistema no ha detectado ninguna apertura de caja activa para el producto de giros.
	_POS_153("POS_153"),//POS_153: No se logrï¿½ completar el proceso de cierre del producto de giros.
	_POS_154("POS_154"),//POS_154: Estï¿½ seguro de aceptar la provisiï¿½n por concepto de {1}
	_POS_155("POS_155"),//POS_155: El tamaï¿½o de la forma, supera los temas de resoluciï¿½n recomendados: \n\n\u2022 Resoluciï¿½n actual: [{1},{2}] \n\u2022 Resoluciï¿½n mï¿½xima recomendada: [{3},{4}]
	_POS_156("POS_156"),//POS_156: Los telefonos del remitente no coinciden.
	_POS_157("POS_157"),//POS_157: Los telefonos del destinatario no coinciden.
	_POS_158("POS_158"),//POS_158: Las claves no coniciden
	_POS_159("POS_159"),//POS_159: El parï¿½metro {1}({2}) no cumple con el formato {3}
	_POS_160("POS_160"),//POS_160: Servicio token de validaciï¿½n automï¿½tico no disponible. Configuraciï¿½n de parï¿½metro {1}({2}).
	_POS_161("POS_161"),//POS_161: La clave ingresada es correcta
	_POS_162("POS_162"),//POS_162: La clave ingresada es incorrecta
	_POS_163("POS_163"),//POS_163: ï¿½Desea cancelar el token de validaciï¿½n?
	_POS_164("POS_164"),//POS_164: La zona del vendedor {1} no se encuentra configurada dentro del parï¿½metro del sistema 'ZONASIMS' o parï¿½metro no existe. Por favor configurarlo en el Bnet Administrativo
	_POS_165("POS_165"),//POS_165: Se detectaron irregularidades de configuraciï¿½n a nivel administrativo, en el(s) siguiente(s) parï¿½metro(s) de sistema: \n{1}\nPor favor comunï¿½quese con personal administrativo para validar este suceso.
	_POS_166("POS_166"),//POS_166: No se permite registro de la transaccion ya que el valor excede el limite, rectifique el valor y vuelva a intentar
	_POS_167("POS_167"),//POS_167: El giro se genero con clave de seguridad {1}
	_POS_168("POS_168"),//POS_168: Se ha completado el proceso de solicitud, puede verificar su estado a travï¿½s de la funcionalidad de historial autorizaciones.\n\nï¿½Desea trasladarse a esta opciï¿½n para confirmar el estado de su solicitud?
	_POS_169("POS_169"),//POS_169: Solicitud de anulaciï¿½n satisfactoria, verifique estado autorizaciï¿½n en historial autorizaciones, una vez aprobada imprima la anulaciï¿½n y verifique egreso.
	_POS_170("POS_170"),//POS_170: Se ha detectado una configuraciï¿½n irregular en los parï¿½metros de sistema que reflejan los tipo servicios con los que consolidan las operaciones de venta relacionadas con el mï¿½dulo de giros.\n\nVerificar los valores de los siguientes parï¿½metros y que estos cumplan con los tipo servicios definidos para giros: {1}
	_POS_171("POS_171"),//POS_171: Por favor solicite al cliente la huella hï¿½meda para el comprobante de impresiï¿½n
	_POS_172("POS_172"),//POS_172: No es posible reconocer el tipo servicio asociado a la operaciï¿½n {1}. Validar la existencia y/o configuraciï¿½n del parï¿½metro de sistema {2}, a travï¿½s del 'Bnet Administrativo'
	_POS_173("POS_173"),//POS_173: No fue posible registrar el PROTEGIRO, proceda a devolver el dinero de este seguro
	_POS_174("POS_174"),//POS_174: No fue posible almacenar las huellas del tercero
	_POS_175("POS_175"),//POS_175: La capacidad del folder de las huellas WSQ igualo o supero el tamaï¿½o mï¿½ximo permitido, no es posible realizar proceso de enrolamiento con biometrï¿½a local.\n\nTamaï¿½o permitido:   {1} Mb \u2013 Tamaï¿½o actual: {2} Mb
	_POS_176("POS_176"),//POS_176: El folder de las huellas WSQ estï¿½ llegando a la capacidad mï¿½xima permitida, verificar proceso de transmisiï¿½n de huellas WSQ. \n\nTamaï¿½o mï¿½ximo permitido: {1} Mb - Tamaï¿½o actual: {2} Mb
	_POS_177("POS_177"),//POS_177: La caja identificada como: {1} - {2}, se encuentra configurada con biometrï¿½a local en la Forma [BICA] y se presentï¿½ un problema al descargar las huellas ISO por favor comunicarse con el administrador del sistema
	_POS_178("POS_178"),//POS_178: Error enviando ISO de huellas en el procesamiento de la Biometrï¿½a Local
	_POS_179("POS_179"),//POS_179: Comunï¿½quese con el administrador del Sistema para gestionar una soluciï¿½n de este inconveniente, se descargaron las huellas de BD Central pero no coinciden con las del tercero
	_POS_180("POS_180"),//POS_180: No se pudo completar la operaciï¿½n a nivel del AFIS, se detecta ausencia de parï¿½metros requeridos.
	_POS_181("POS_181"),//POS_181: La entidad trama peticiï¿½n con nombre '{1}', se encuentra definida en el producto con mï¿½s de una conexiï¿½n particular para solicitar al proveedor, validar esto a nivel de desarrollo en la clase '{2}' del producto de giros.
	_POS_182("POS_182"),//POS_182: Existe mï¿½s de una conexiï¿½n de negocio definida en el producto, validar esto a nivel de desarrollo en la clase '{1}' del producto de giros.
	_POS_183("POS_183"),//POS_183: El telï¿½fono ingresado no coincide con el confirmado
	_POS_184("POS_184"),//POS_184: Como parte del proceso, el sistema notificara vï¿½a SMS al tercero {1} del giro.\n\nActualmente el tercero {1}, presenta el nï¿½mero de celular: {2}. ï¿½Desea actualizarlo?
	//_POS_185("POS_185"),//POS_185: Como parte del proceso, el sistema notificara vï¿½a SMS al tercero {1} del giro.
	_POS_186("POS_186"),//POS_186: La imagen fue guardada exitosamente
	_POS_187("POS_187"),//POS_187: Ocurrio un error al intentan almacenar la imagen
	_POS_188("POS_188"),//POS_188: Por favor capture las fotos del documento para continuar
	_POS_189("POS_189"),//POS_189: la captura de fotos ha finalizado con exito por favor continuar
	_POS_190("POS_190"),//POS_190: Se presentï¿½ un problema en el sistema capturando la huella.\n\nï¿½Desea continuar intentï¿½ndolo?
	_POS_191("POS_191"),//POS_191: No fue posible generar la imagen de la huella, por favor intente capturarla nuevamente
	_POS_192("POS_192"),//POS_192: Por favor ingresar un comentario.
	_POS_193("POS_193"),//POS_193: Solo se pueden enviar maximo 8 senales de alerta.
	_POS_OI_194("POS_OI_194"),//POS_OI_194 POS_194 El comentario de señal de alerta de codigo {1} debe ser mayor a 10 caracteres y menor de 500."
	_POS_OI_195("POS_OI_195"),//POS_195 Por favor verificar el comentario de la señal de alerta de codigo {1} No se permiten caracteres especiales
	_POS_194("POS_194"),//POS_194: No fue posible establecer conexion con el SocketReceptor de imagenes internacionales
	_POS_195("POS_195"),//POS_195: El archivo {1} no existe, por favor verificar la ubicacion del archivo
	_POS_196("POS_196"),//POS_196: El numero de referencia consultado ya se encuentra pagado.
	_POS_197("POS_197"),//POS_197: Debe capturar las fotos del documento, Anverso y Reverso.
	_POS_198("POS_198"),//POS_198: El usuario no supero los controles biomï¿½tricos exigidos por la seguridad del sistema.
	_POS_199("POS_199"),//POS_199: El documento de identidad digitado no corresponde al documento de identidad capturado de la cedula.
	_POS_200("POS_200"),//POS_200: Proceso Exitoso {1}.
	_POS_201("POS_201"),//POS_201: Tercero creado/actualizado exitosamente.
	_POS_202("POS_202"),//POS_202: Anulacion de protegiro internacional exitoso {1}.
	_POS_203("POS_203"),//POS_203: Debe diligenciar los datos de empresa.
	_POS_204("POS_204"),//POS_204: Debe diligenciar los datos del cliente/usuario.
	_POS_205("POS_205"),//POS_205: Debe seleccionar un tipo de imagen.
	_POS_206("POS_206"),//POS_206: El sistema no logro completar el proceso de autenticación requerido para ingresar al producto de giros, razón por la cual se restringe el menú de opciones del producto
	_POS_207("POS_207"),//POS_207: Se inicio sesion con {1} por ultima vez en la Agencia: {2} con la Caja: {3} el dia: {4}
	_POS_208("POS_208"),//POS_208: No coninciden los numero de documento 
	_POS_SG_186("POS_SG_186"),//POS_SG_186: Â¿Persona Expuesta Politicamente?
	_POS_SG_187("POS_SG_187"),//POS_SG_187: La versiï¿½n {1} NO estï¿½ habilitada. 
	_POS_SG_188("POS_SG_188"),//POS_SG_188: Aún no se ha ingresado información sobre marcación PEP
	_POS_SG_189("POS_SG_189"),//POS_SG_189: Seleccione una respuesta afirmativa para continuar.
	_POS_209("POS_209"),//POS_209: Se notifica envió de SMS al tercero {1} con listado de posibles agencias para el cobro del giro según su valor.\n\nActualmente el tercero {1}, presenta el n\u00FAmero de celular\: {2}. \u00BFDesea actualizarlo?
	//_POS_210("POS_210"),//POS_210: Se notifica envió de SMS al tercero {1} con listado de posibles agencias para el cobro del giro según su valor.
	_POS_211("POS_211"),//POS_211: El giro con referencia: {1}, se encuentra con estado {2}, no se permite reimprimir.
	_POS_212("POS_212"),//POS_212: El tercero {1}, ha sido enrolado satisfactoriamente
	_POS_213("POS_213"),//POS_032: El tercero {1}, ingresado con documento {2}, no presenta diligenciada la ciudad de expedicion.\n\n Sin la actualizacion de esta no es posible completar el proceso de {3} de giro postal
	_POS_214("POS_214"),//POS_032: El tercero {1}, ingresado con documento {2}, no presenta diligenciada la actividad economica Sin la actualizacion de esta no es posible completar el proceso de {3} de giro postal
	_POS_215("POS_215"),//POS_215: Es necesario seleccionar el solicitante del pago..
	
	//Envio de remesa internacional
	_POS_SG_190("POS_SG_190"),//POS_SG_190: El giro con referencia: {1}, fue enviado exitosamente.\n\n{2}
	_POS_SG_191("POS_SG_191"),//APP||Debe seleccionar un registro de la grilla para eliminar.
	_POS_SG_192("POS_SG_192"),//APP||Solo se permiten 8 transacciones asociadas.
	_POS_SG_193("POS_SG_193"),//APP||Para agregar una transaccion, los campos deben estar llenos.
	_POS_SG_194("POS_SG_194"),//APP||Operacion inusual registrada con exito.
	_POS_SG_195("POS_SG_195"),//APP||Debe asignar al menos una transaccion asociada.
	_POS_SG_196("POS_SG_196"),//APP||La fecha de nacimiento no es valida.
	_POS_SG_197("POS_SG_197"),//APP||La fecha de expedicion del documento no es valida.
	_POS_SG_198("POS_SG_198"),//APP||Seleccione una opci\u00F3n con el formato requerido.
	_POS_SG_199("POS_SG_199"),//APP||Se presento un error al intentar validar la informacion de numeros de celular ingresados.
	_POS_SG_200("POS_SG_200"),//APP||Quedo pendiente validar la informacion de numeros de celular ingresados.
	_POS_SG_201("POS_SG_201"),//El valor del token de impresion de Ingresos en el parametro IDREOPIE debe ser S o N. Verificar forma PASI
	_POS_SG_202("POS_SG_202"),//El valor del token de impresion de Egresos en el parametro IDREOPIE debe ser S o N. Verificar forma PASI
	_POS_SG_203("POS_SG_203"),//La estructura del parametro IDREOPIE es inconsistente. por favor verificar forma PASI
	_POS_SG_204("POS_SG_204"),//Token del parametro IDREOPIE esta vacio. Por favor verificar forma PASI
	
	//Emitidos por integracion con aplicacion de biometria [Lib: IdVerifyClient] (Prefijo BIO, hace referencia a biometria)
	_BIO_001("BIO_001"), //BIO_001: Error general.
	_BIO_002("BIO_002"), //BIO_002: Huella no coincide con la del usuario.
	_BIO_003("BIO_003"), //BIO_003: No se logrï¿½ detectar el lector. \n ï¿½Desea continuar?
	_BIO_004("BIO_004"), //BIO_004: El usuario con login {1}, no tiene configurado el rol para enrolar clientes.\n Por favor, comunï¿½quese con el ï¿½rea administrativa de SuperGIROS S.A.
	_BIO_005("BIO_005"), //BIO_005: Por favor solicitar huella de remitente
	_BIO_006("BIO_006"), //BIO_006: El tercero {1} sera validado biometricamente.
	_BIO_007("BIO_007"), //BIO_007: El tercero {1} serï¿½ enrolado.
	_BIO_008("BIO_008"), //BIO_008: Ponga el dedo en el lector y pulse aceptar.
	_BIO_009("BIO_009"), //BIO_009: Debe realizar el proceso de biometria.
	
	//Exclusivos para un ambiente de desarrollo
	_DES_001("DES_001"),//DES_001: El componente con nombre: [{1}], supera el marco establecido por el panel: [{2}].\n\nValide las dimensiones de ancho y alto de ambos componentes, dado que se recomienda que los componentes se adapten de manera ideal.\n\n{2}: [{3} X {4}].\n{1}: [{5} X {6}].
	_DES_002("DES_002"),//DES_002: Se recomienda a nivel de desarrollo ejecutar como buena prï¿½ctica, recuperar el valor del parï¿½metro: {1} ({2}), en una variable durante el proceso de negocio que se encuentra ejecutando, debido a que dicho parï¿½metro estï¿½ configurado para siempre consultarse, lo cual causa un consumo excesivo de la trama para consultar parï¿½metros de sistema
	_DES_003("DES_003"),//DES_003: El proceso que se intenta ejecutar, identificado como: {1}, requiere obtener la informaciï¿½n relacionada con el(s) / la(s) {2}; sin esta informaciï¿½n no puede finalizar exitosamente dicho proceso, lo cual puede llegar a repercutir en la operaciï¿½n que se encuentra realizando
	_DES_004("DES_004"),//DES_004: Verifique la configuraciï¿½n realizada sobre la dimensiï¿½n identificada como: {1}, no cumple con la especificaciï¿½n esperada para una dimensiï¿½n
	_DES_005("DES_005"),//DES_005: Verifique la configuraciï¿½n realizada sobre el color identificado como: {1}, al parecer presenta problemas y/o no cumple con la especificaciï¿½n esperada para un color
	_DES_006("DES_006"),//DES_006: Validar en la funciï¿½n PL/SQL pkgn_businessnetintegragiros.func_validaplansims, involucrada en la trama 932, la inclusiï¿½n de todos los parï¿½metros de sistema que representan la consolidaciï¿½n de las operaciones de venta bajo un tipo servicio.\n\nPuede validar los parï¿½metros requeridos observando la configuraciï¿½n de las constantes de enumeraciï¿½n definidas en la clase EnumTiposServicios en su atributo strNombreParametroEmpresaVentaSIMS
	
	//Emitidos por integracion con SuperCombo (Prefijo SPC, hace referencia a SuperCombo)
	
	_SPC_001("SPC_001"), //SPC001: El cliente {1} no puede ser asegurable.
	_SPC_002("SPC_002"), //SPC003: No hay conexiï¿½n con el servicio web de seguros del proveedor
	_SPC003("SPC_003"), //SPC003: No hay conexiï¿½n con el servicio web de seguros de CODESA
	_SPC_004("SPC_004"), //SPC004: Problema consultando lista negra
	_SPC_005("SPC_005"), //SPC005: Seï¿½or usuario.\n Recuerde  actualizar  su  nï¿½mero  de  telï¿½fono  celular \n y el del beneficiario, asï¿½ podrï¿½ obtener los beneficios\n de los mensajes de texto.
	_SPC_006("SPC_006"), //SPC006: La informaciï¿½n del telï¿½fono celular del tercero {1} ha cambiado, se procede a actualizarla.
	_SPC_007("SPC_007"), //SPC007: Se enviarï¿½ mensaje solo al remitente cuando el beneficiario reclame el giro.
	_SPC_008("SPC_008"), //SPC008: Se enviarï¿½ mensaje solo al beneficiario con informaciï¿½n para reclamar el giro.
	_SPC_009("SPC_009"), //SPC009: Se enviarï¿½n mensajes al remitente y beneficiario informando el estado del giro.
	_SPC_010("SPC_010"), //SPC010: No se enviara ningï¿½n mensaje.
	_SPC_011("SPC_011"), //SPC011: No se pudo realizar la facturaciï¿½n del Seguro en SIMS.
	_SPC_012("SPC_012"), //SPC012: Se va a Imprimir Contrato Del Seguro.
	_SPC_013("SPC_013"), //SPC013: El giro se guardï¿½ exitosamente. Pero no fue posible hacer el SuperCOMBO.\n Favor retornar el dinero del SuperCOMBO al cliente.
	_SPC_014("SPC_014"), //SPC014: El giro se guardï¿½ exitosamente. Pero no fue posible enviar el mensaje de texto al destinatario.
	_SPC_015("SPC_015"), //SPC015: Giro asegurado por el remitente.
	_SPC_016("SPC_016"), //SPC016: El valor del seguro no se encuentra configurado correctamente.
	_SPC_017("SPC_017"), //SPC017: El valor del seguro será descontado del giro
	_SPC_018("SPC_018"), //SPC018: Giro asegurado por el beneficiario.
	
	//Emitidos por integracion con Convenios (Prefijo CNV, hace referencia a Convenio)
	
	_CNV_001("CNV_001"), //CNV001: No esta disponible el documento recaudo convenio para esta agencia.
	_CNV_002("CNV_002"), //CNV002: Por favor revise el valor ingresado para la etiqueta {1}
	_CNV_003("CNV_003"), //CNV003: No se puede consultar las propiedades del convenio

		
	//Emitidos por EJB de giros (Prefijo EJB_GIR, hace referencia al componente EJB de giros)
	
	_1010("1010"),//1010: Se ha presentado un error inesperado sobre la plataforma de integraciï¿½n hacia el proveedor de giros.
	_2222("2222"),//2222: Por cambios administrativos debe reiniciar la aplicaciï¿½n
	_EJB_GIR_001("EJB_GIR_001"),//EJB_GIR_001: El sistema no pudo completar la operaciï¿½n, no logro encontrar la referencia (PIN), del lado del colaborador
	_EJB_GIR_9999("EJB_GIR_9999"),//EJB_GIR_9999: Se ha presentado un error en el componente EJB. Por favor comuniquese con el area de soporte.
	_EJB_GIR_0009("EJB_GIR_0009"),//EJB_GIR_0009: No se recibe respuesta por parte del proveedor SIMS
	
	
	//Emitidos por el Socket de la Empresa (Prefijo SOC, hace referencia al componente Socket de la empresa)
	
	_SOC_000001("SOC_000001"),//SOC_000001: No se recibio respuesta por parte del ejb de giros.
	_SOC_000002("SOC_000002"),//SOC_000002: Se ha presentado un error en el Socket de venta. Por favor comuniquese con el area de soporte.
	
	
	//Emitidos por la integracion con FPISA
	_FPISA_26666("FPISA-26666"),// Tercero no existe
	_FPISA_00000("FPISA-00000"),//_FPISA_00000:{}
	
	//</Equipo [BNet - CLiente Giros]>
	
	
	
	//Originales de BD: <<Recordar remover del listado generado el mensaje de error inesperado [99999]>>
	
	_00001("00001"),//00001: El usuario {1} no existe o hay problemas con su informaciï¿½n.
	_00002("00002"),//00002: La entidad {1} (Datos - Entidades) no existe o hay problemas con su informaciï¿½n.
	_00003("00003"),//00003: El dato {1} (Datos - Entidades) no existe o hay problemas con su informaciï¿½n.
	_00004("00004"),//00004: El rol {1} no existe o hay problemas con su informaciï¿½n.
	_00005("00005"),//00005: El modulo {1} no existe o hay problemas con su informaciï¿½n.
	_00006("00006"),//00006: Lista de valores ha sido cancelada.
	_00007("00007"),//00007: El tipo de territorio {1} no existe o hay problemas con su informaciï¿½n.
	_00008("00008"),//00008: El territorio {1} no existe o hay problemas con su informaciï¿½n.
	_00009("00009"),//00009: La moneda {1} no existe o hay problemas con su informaciï¿½n.
	_00010("00010"),//00010: La actividad econï¿½mica {1} no existe o hay problemas con su informaciï¿½n.
	_00011("00011"),//00011: El tercero {1} no existe o hay problemas con su informaciï¿½n.
	_00012("00012"),//00012: La agencia {1} no existe. se encuentra inactiva o hay problemas con su informaciï¿½n.
	_00013("00013"),//00013: La caja {1} no existe o hay problemas con su informaciï¿½n.
	_00014("00014"),//00014: La caja padre {1} no existe o hay problemas con su informaciï¿½n.
	_00015("00015"),//00015: El medio de pago {1} no existe o hay problemas con su informaciï¿½n.
	_00016("00016"),//00016: El concepto {1} no existe o hay problemas con su informaciï¿½n.
	_00017("00017"),//00017: El plan {1} no existe o hay problemas con su informaciï¿½n.
	_00018("00018"),//00018: El campo {1} no puede ser nulo. es obligatorio o hay problemas con su informaciï¿½n.
	_00019("00019"),//00019: El campo {1} tiene problemas con el formato o hay problemas con su informaciï¿½n.
	_00020("00020"),//00020: El campo {1} ha sido seleccionado de uso obligatorio y no tiene valor. asigne un valor o cambie su condiciï¿½n.
	_00021("00021"),//00021: El producto {1} no existe o hay problemas con su informaciï¿½n.
	_00022("00022"),//00022: La entidad financiera {1} no existe o hay problemas con su informaciï¿½n.
	_00023("00023"),//00023: El usuario no tiene un turno asignado o hay problemas con su informaciï¿½n.
	_00024("00024"),//00024: Existen problemas con la estructura de la trama. consulte con el administrador del sistema.
	_00025("00025"),//00025: El usuario ya tiene asignado este turno o las horas se traslapan con un turno existente.
	_00026("00026"),//00026: La caja se encuentra abierta o hay problemas con su informaciï¿½n.
	_00027("00027"),//00027: La caja se encuentra cerrada o hay problemas con su informaciï¿½n.
	_00028("00028"),//00028: El territorio no tiene agencias o hay problemas con su informaciï¿½n.
	_00029("00029"),//00029: La tarifa {1} no existe o hay problemas con su informaciï¿½n.
	_00030("00030"),//00030: El comando asociado a esta operaciï¿½n no existe o existe problemas con su informaciï¿½n.
	_00031("00031"),//00031: El documento concepto no existe o hay problemas con su informaciï¿½n.
	_00032("00032"),//00032: El documento {1} no existe o hay problemas con su informaciï¿½n.
	_00033("00033"),//00033: El plan tarifario {1} no existe o hay problemas con su informaciï¿½n.
	_00034("00034"),//00034: El consecutivo de documento {1} no existe o hay problemas con su informaciï¿½n.
	_00035("00035"),//00035: El numeral cambiario {1} no existe o hay problemas con su informaciï¿½n.
	_00036("00036"),//00036: La transacciï¿½n del documento {1} no existe en transacciones x documento o hay problemas con su informaciï¿½n.
	_00037("00037"),//00037: No existen movimientos por concepto para el documento.
	_00038("00038"),//00038: No existe un estado para el documento {1}.
	_00039("00039"),//00039: El estado del documento debe ser PENDIENTE para ejecutar esta operaciï¿½n.
	_00040("00040"),//00040: La agencia destino pertenece a una zona diferente a la zona de la agencia origen.
	_00041("00041"),//00041: La caja no se encuentra abierta para este dï¿½a o hay problemas con su informaciï¿½n.
	_00042("00042"),//00042: El concepto usado para operaciï¿½n no ha sido hallado o hay problemas con su informaciï¿½n.
	_00043("00043"),//00043: El medio de pago bancario {1} no tiene una cuenta y un banco asociado o hay problemas con su informaciï¿½n.
	_00044("00044"),//00044: El consecutivo de la chequera para el medio de pago {1} no existe o hay problemas con su informaciï¿½n.
	_00045("00045"),//00045: El consecutivo del sistema no coincide con el consecutivo fï¿½sico del cheque o hay problemas con su informaciï¿½n.
	_00046("00046"),//00046: No hay informacion disponible para la consulta
	_00047("00047"),//00047: El documento no tiene conceptos asociados o hay problemas con su informaciï¿½n.
	_00048("00048"),//00048: No hay disponibilidad para la salida de caja en el medio de pago dado.
	_00049("00049"),//00049: Existen movimientos pendientes por aceptar en otra caja.
	_00050("00050"),//00050: Existen movimientos pendientes por aceptar en esta caja.
	_00051("00051"),//00051: El medio de pago es diferente a EFECTIVO por lo tanto debe tener un documento auxiliar.
	_00052("00052"),//00052: El medio de pago CHEQUE no tiene cuenta y chequera asignada.
	_00053("00053"),//00053: Ingrese un valor valido.
	_00054("00054"),//00054: La caja origen no tiene autorizado el realizar desembolsos o traslados a cajas principales de otra agencia o asï¿½ misma. o hay problemas con su informaciï¿½n.
	_00055("00055"),//00055: La caja no puede realizar la operaciï¿½n ya que sus cajas auxiliares aun se encuentran abiertas.
	_00056("00056"),//00056: No se ha encontrado informaciï¿½n en DENOMINACIONES o hay problemas con su informaciï¿½n.
	_00058("00058"),//00058: No se ha encontrado ninguna transacciï¿½n o concepto pendiente de aceptar para la agencia.
	_00059("00059"),//00059: La caja origen no tiene autorizado realizar provisiones a cajas de la misma agencia o hay problemas con su informaciï¿½n.
	_00060("00060"),//00060: Los campos no estan completos.
	_00061("00061"),//00061: El medio de pago no ha sido aperturado el dia de hoy o hay problemas con su informacion.
	_00062("00062"),//00062: La agencia tiene asignado un documento en dos grupos o mas de agencias. por lo tanto no es posible asignar el prï¿½ximo consecutivo para el documento.
	_00063("00063"),//00063: Excedio el numero de caracteres.
	_00064("00064"),//00064: El concepto de autorizaciones para transacciones (Datos Entidades) no ha sido hallado o hay problemas con su informaciï¿½n.
	_00065("00065"),//00065: El usuario no tiene privilegios para ejecutar del software.
	_00066("00066"),//00066: El estado del documento debe ser CONGELADO para ejecutar esta operaciï¿½n.
	_00067("00067"),//00067: ï¿½Esta seguro(a) de anular la transaccion?. recuerde que este proceso no tiene REVERSA!!!.
	_00068("00068"),//00068: ï¿½Esta seguro(a) de rechazar la solicitud de autorizacï¿½n?.
	_00069("00069"),//00069: ï¿½Esta seguro(a) de cambiar la agencia pagadora?. la transacciï¿½n quedarï¿½ disponible para pago.
	_00070("00070"),//00070: ï¿½Esta seguro(a) de cambiar el tercero destino o beneficiario de la transacciï¿½n?. la transacciï¿½n quedarï¿½ disponible para pago.
	_00071("00071"),//00071: El campo {1} no puede ser nulo.
	_00072("00072"),//00072: El tipo de comunicaciï¿½n o llamada no ha sido encontrado o hay problemas con su informaciï¿½n.
	_00073("00073"),//00073: El usuario se encuentra bloqueado por la administraciï¿½n. favor comunicarse a la lï¿½nea 018000221321.
	_00074("00074"),//00074: El tercero tiene un homï¿½nimo (Nombres y Apellidos iguales) en la lista clinton.
	_00075("00075"),//00075: No se encontrï¿½ ninguna configuraciï¿½n de formulaciï¿½n o hay problemas con su informaciï¿½n.
	_00076("00076"),//00076: Problemas con la conexiï¿½n Intente nuevamente.
	_00077("00077"),//00077: No se pudo encontrar el servidor\n\n  Soluciones:\n\n  1.Revise la direcciï¿½n del servidor.\n\n  2.Verifique que el servidor este conectado a la red.
	_00078("00078"),//00078: El tercero {1} ya existe o hay problemas con su informaciï¿½n.
	_00079("00079"),//00079: La empresa no existe en FINANZAS PLUS.
	_00080("00080"),//00080: La agencia {1} ya existe o hay problemas con su informaciï¿½n.
	_00081("00081"),//00081: La cuenta contable no existe en FINANZAS PLUS.
	_00082("00082"),//00082: El tipo de comprobante no existe o hay problemas con su informaciï¿½n.
	_00083("00083"),//00083: El centro de costo no existe o hay problemas con su informaciï¿½n.
	_00084("00084"),//00084: El tipo de documento no existe en FINANZAS PLUS.
	_00085("00085"),//00085: El Tipo de Documento no esta activo en FINANZAS PLUS.
	_00086("00086"),//00086: Documento no maneja contabilidad en FINANZAS PLUS.
	_00087("00087"),//00087: El Documento existe en FINANZAS PLUS.
	_00088("00088"),//00088: Secuencia numï¿½rica no esta activa en FINANZAS PLUS.
	_00089("00089"),//00089: El Documento debe manejar numeraciï¿½n automï¿½tica. verificar en FINANZAS PLUS.
	_00090("00090"),//00090: El lapso y periodo no fueron encontrados en FINANZAS PLUS.
	_00091("00091"),//00091: El tercero {1} es de un TIPO TERCERO no permitido para este dato o no existe.
	_00092("00092"),//00092: El concepto {1} ya se encuentra configurado en otro tipo de comprobante.
	_00093("00093"),//00093: No existe configuraciï¿½n contable para el concepto(s) que esta intentando registrar.
	_00094("00094"),//00094: No existe el DESTINO (CENTRO DE COSTO) {1} en FINANZAS PLUS.
	_00095("00095"),//00095: La configuraciï¿½n contable exige un tercero especï¿½fico. revise la configuraciï¿½n.
	_00096("00096"),//00096: Esta solicitud solo es valida para giros enviados por la agencia.
	_00097("00097"),//00097: Esta hora esta fuera del horario de acceso permitido.
	_00098("00098"),//00098: La caja se encuentra abierta para otro usuario.
	_00099("00099"),//00099: El movimiento contable que se intenta reclasificar NO EXISTE.
	_00100("00100"),//00100: La fecha inicial es demasiado antigua para el rango de consulta permitido.
	_00101("00101"),//00101: La fecha no puede ser igual al dia de proceso.
	_00102("00102"),//00102: Desea generar los saldos de cartera para la fecha {1}.
	_00103("00103"),//00103: Se generarï¿½n los saldos de cartera para el {1}.
	_00104("00104"),//00104: No existe un plan tarifario definido.
	_00105("00105"),//00105: Uno de los terceros se encuentra bloqueado desde direccion general
	_00106("00106"),//00106: El valor suministrado de la transaccion no coincide con el plan tarifario de la sede convenio.
	_00107("00107"),//00107: El estado del documento debe ser RESTRINGIDO O CADUCADO para ejecutar esta operaciï¿½n.
	_00108("00108"),//00108: El tercero ya existe.
	_00109("00109"),//00109: El usuario se encuentra inactivo.
	_00110("00110"),//00110: La contrasena ha caducado. Cambie contrasena.
	_00111("00111"),//00111: Registro de comunicacion no existe.
	_00112("00112"),//00112: El registro de comunicacion se encuentra reservado por otro usuario.
	_00113("00113"),//00113: Ya se establecio comunicacion con el beneficiario.
	_00114("00114"),//00114: Error intentando obtener de la peticiï¿½n el campo: {1} a travï¿½s de su identificador: {2}
	_00115("00115"),//00115: No se encuentra configurado Zonas para el usuario consultado.
	_00117("00117"),//00117: No se ha encontrado ninguna transacciï¿½n o concepto pendiente por aceptaciï¿½n.
	_00118("00118"),//00118: El saldo de caja es inferior al monto del giro a anular.
	_00119("00119"),//00119: El movimiento no existe o no se encuentra pendiente por aceptacion.
	_00120("00120"),//00120: Alerta el usuario ha realizado operaciones sobre el limite establecido.
	_00121("00121"),//00121: Existen movimientos por anular pendientes por aceptar.
	_00122("00122"),//00122: Esta intentando aceptar un desembolso con un concepto cuya naturaleza es diferente a INGRESO
	_00123("00123"),//00123: Esta intentando rechazar un desembolso con un concepto cuya naturaleza es diferente a EGRESO
	_00124("00124"),//00124: El tipo de Contabilidad {1} no existe o hay problemas con su informaciï¿½n.
	_00125("00125"),//00125: El tipo de grupo consecutivos no existe o hay problemas con su informaciï¿½n.
	_00126("00126"),//00126: El valor de Solicitud Desembolso debe ser mayor a [0] cero
	_00127("00127"),//00127: El valor del Detalle Desembolso Debe Ser Igual al de Solicitud Desembolso
	_00128("00128"),//00128: El valor del Detalle Desembolso debe ser mayor a [0] cero
	_00129("00129"),//00129: Solo es permitido editar notas desde la oficina origen.
	_00130("00130"),//00130: Usuario No tiene asignado Rol especifico para realizar esta operacion.
	_00131("00131"),//00131: Solo la oficina de origen puede realizar este proceso.
	_00132("00132"),//00132: Transaccion terminada por servidor por superar el tiempo de espera. Favor reintente la operacion.
	_00133("00133"),//00133: El pin {1} no corresponde con una transacciï¿½n de seguro
	_00134("00134"),//00134: ï¿½Esta seguro(a) de levantar un Giro Vencido?. recuerde que este proceso no tiene REVERSA!!!.
	_00135("00135"),//00135: El tipo de identificacion del tercero no es correcto.
	_00136("00136"),//00136: No se puede registrar en transacciones x trama por llave primaria.
	_00137("00137"),//00137: Transaccion terminada por cliente por superar el tiempo de espera. Favor reintente la operacion.
	_00138("00138"),//00138: El consecutivo del documento {1} se ha terminado. favor configurar la numeraciï¿½n.
	_00139("00139"),//00139: El usuario no se encuentra registrado en el sistema.
	_00140("00140"),//00140: La hora debe estar dentro del rango 0 y 235959
	_00141("00141"),//00141: El Usuario no tiene permisos para esta opciï¿½n
	_00142("00142"),//00142: El usuario no esta dentro las zonas que puede administrar.
	_00143("00143"),//00143: El saldo del arqueo no corresponde al saldo de la caja.
	_00144("00144"),//00144: (APP-00144) Cierre Automatico de Cajas
	_00145("00145"),//00145: El estado del documento debe ser RESTRINGIDO para ejecutar esta operaci?n.
	_00146("00146"),//00146: La fecha y hora de cierre es igual a la fecha y hora de apertura. Por favor intente de nuevo el proceso.
	_00147("00147"),//00147: La Direcciï¿½n MAC {1} no esta registrada
	_00148("00148"),//00148: La Direcciï¿½n MAC {1} no esta se encuentra activa
	_00149("00149"),//00149: La Direcciï¿½n MAC {1} no pertenece a la agencia
	_00150("00150"),//00150: ï¿½Esta seguro(a) de Autorizar el monto del Giro?.
	_00151("00151"),//00151: El concepto con cï¿½digo {1} ({2}) no se encuentra habilitado para realizar procesos de consulta x ID de transacciï¿½n
	_00152("00152"),//00152: Usuario Bloqueado por Sesiones
	_00153("00153"),//00153: El parï¿½metro de sistema con cï¿½digo {1} no se encuentra correctamente configurado y es indispensable para continuar con la operaciï¿½n
	_00154("00154"),//00154: Verifique configuracion virtual
	_00155("00155"),//00155: Error plataforma Codesa
	_00156("00156"),//00156: Verifique Equivalencia virtuales Cajero
	_00157("00157"),//00157: Id de la trama diferente
	_00158("00158"),//00158: Login Invalido
	_00159("00159"),//00159: Error Consulta Serie Virtual
	_00160("00160"),//00160: El formulario a reimprimir no es el ultimo realizado
	_00161("00161"),//00161: Use reimpresion Seguro
	_00162("00162"),//00162: No hay conexion con el servidor de integracion
	_00163("00163"),//00163: No Existe URL Servicio Codesa
	_00164("00164"),//00164: Usuario Excede limite Seguro
	_00165("00165"),//00165: Sin Certificados Vigentes
	_00166("00166"),//00166: Asegurado no Tiene Siniestros Pendientes
	_00167("00167"),//00167: Asegurado ya tiene un aviso.
	_00168("00168"),//00168: No se efectuo el pago intente de nuevo
	_00169("00169"),//00169: La sede {1} no pertenece al tercero beneficiario suministrado.
	_00170("00170"),//00170: No se encontrï¿½ en el sistema el proceso: {1} configurado en el parï¿½metro de sistema {2} necesario para continuar con la operaciï¿½n
	_00171("00171"),//00171: El proceso: {1} configurado en el parï¿½metro de sistema: {2} no cumple con las especificaciones esperadas para su ejecuciï¿½n
	_00172("00172"),//00172: Se presento problema de timeout en transaccion enviando ref_control-> {1}
	_00173("00173"),//00173: No fue posible reconocer y/o interpretar el formato de validacion para el campo {1}. Por favor revisar la expresion regular configurada en la Forma [DATE] para el Dato con codigo: {2}
	_00174("00174"),//00174: El campo: {2} - {3} recibido en la trama ({1}) no corresponde con el formato esperado. Las configuraciones asociadas a esta validacion pueden encontrarse en la forma: [DATE]
	_00175("00175"),//00175: El campo: {2} - {4} recibido en la trama {1} no corresponde con el formato esperado. Por favor revisar la expresion regular configurada en la Forma [DATE] para el Dato con codigo: {3}
	_00176("00176"),//00176: No fue posible reconocer y/o interpretar el formato de validacion para el campo {2} - {1}. Por favor revisar la expresion regular configurada en la Forma [DATE] para el Dato con codigo: {3}
	_00177("00177"),//00177: Definicion de trama inconsistente
	_00200("00200"),//00200: Ya existe una configuracion de promocion igual para esta agencia
	_00201("00201"),//00201: El usuario ya se encuentra Enrolado
	_00202("00202"),//00202: El Password ya fue utilizado por el usuario
	_00203("00203"),//00203: La cedula del colaborador no esta enrolada
	_00204("00204"),//00204: La cedula del colaborador no esta registrada
	_00206("00206"),//00206: La Agencia No tiene permiso para Captar esa Cantidad
	_00207("00207"),//00207: No hay Transacciones de Seguro
	_00208("00208"),//00208: Los Valores de Seguros han sido modificados
	_00209("00209"),//00209: No Hay Transacciones de SMS
	_00210("00210"),//00210: No Hay Comunicacion con el Web Service de Seguro
	_00211("00211"),//00211: El Tercero {1} se encuentra bloqueado por cumplimiento
	_00212("00212"),//00212: El usuario se encuentra en estado EXONERADO
	_00213("00213"),//00213: Error formateando la trama entrante
	_00214("00214"),//00214: Tiempo de Espera Agotado con el Proveedor de Seguros
	_00215("00215"),//00215: No se Puede Crear el Seguro en el Proveedor
	_00216("00216"),//00216: No Hay Comunicacion con el Web Service de SMS
	_00217("00217"),//00217: Error al enviar mensaje al sistema QUEUE de Seguros
	_00218("00218"),//00218: Formato de MAC incorrecto
	_00219("00219"),//00219: Pais de expedicion no valido o no existe
	_00220("00220"),//00220: Fecha de entrada al pais no valida
	_00221("00221"),//00221: Fecha de vencimiento del documento no valida
	_00222("00222"),//00222: No se pudo obtener la MAC de la maquina
	_00223("00223"),//00223: No se pudo obtener el Hash Code de la maquina
	_00224("00224"),//00224: Lugar de expedicion no valido o no existe
	_00225("00225"),//00225: Error en la trama {1}
	_00226("00226"),//00226: Mensaje con codigo {1}. No encontrado en el sistema
	_00227("00227"),//00227: El unico autorizado para actualizar la informacion de un tercero NIT es personal administrativo de SuperGIROS S.A.
	_00228("00228"),//00228: Departamento no valido para Consulta y/o Pago del Giro
	_00238("00238"),//00238: No se recibio respuesta del SIRE
	_00239("00239"),//00239: Tercero propietario externo no encontrado
	_00240("00240"),//00240: El territorio que solicita la transaccion con codigo Dane: {1} no se encuentra configurado en la tabla de homologacion
	_00241("00241"),//00241: Inconsistencia encontrando el departamento destino hacia el cual fue dirigido el giro
	_00242("00242"),//00242: El territorio relacionado a la agencia no se encuentra autorizado para consultar este giro
	_00243("00243"),//00243: El territorio que solicita la operacion no se encuentra registrado en SIMS
	_00244("00244"),//00244: La consulta de este giro no se encuentra autorizada para este territorio
	_00245("00245"),//00245: Departamento no autorizado para realizar esta operacion
	_00246("00246"),//00246: Parametros de consulta no validos
	_00247("00247"),//00247: La transaccion de pago externo que se acaba de efectuar no se completo satisfactoriamente, el sistema ejecutara el proceso "Reimpresion - Reimprimir Ultimo Pago", para reconfirmar la transaccion en el sistema con el proveedor externo.
	_00248("00248"),//00248: El sistema no logro recibir respuesta satisfactoria del lado del proveedor, con respecto a la confirmacion de la transaccion incompleta de pago \n\nï¿½Desea seguir intentando la operacion de confirmacion de esta transaccion o desea abortar este proceso?. 
	_00249("00249"),//00249: La transaccion de pago Externo se efectuo correctamente en el proveedor externo. pero no se registro en SIMS
	_00250("00250"),//00250: La transaccion ya fue pagada por otra agencia
	_00251("00251"),//00251: No se encuentra activa la salida de SIMS al Sistema Externo
	_00252("00252"),//00252: No se encuentra activa la entrada del Sistema Externo a SIMS
	_00253("00253"),//00253: El sistema SIMS no logro completar efectivamente la operacion de pago de giro efecutada por el sistema externo
	_00254("00254"),//00254: El tercero propietario no presenta una configuracion de comunicacion hacia el sistema externo.\n\nNotifique este comportamiento a personal administrativo de SuperGIROS S.A. para verificar estas configuraciones.
	_00255("00255"),//00255: SIRE_TIME_OUT
	_00256("00256"),//00256: No hay conexion con Red MIA
	_00257("00257"),//00257: SIRE_ERROR_GENERAL
	_00258("00258"),//00258: SIRE_ERROR EN LLAMADO A METODO DE ENVIO DE TRAMA
	_00259("00259"),//00259: SIRE_ERROR EN FORMATO DE TRAMA
	_00260("00260"),//00260: No es posible realizar el pago de giro, debido a que alguno de los terceros involucrados, presenta problemas con su informacion
	_00261("00261"),//00261: El sistema presenta giros externos con inconvenientes, procedera a reconfirmar la transaccion sobre los sistemas externo y SIMS, y posterior a esto efectuara la reimpresion de la misma.
	_02292("02292"),//02292: El registro no puede ser eliminado por que tiene registros asociados
	_10201("10201"),//10201: No se requieren parï¿½metros
	_10202("10202"),//10202: Ha seleccionado muchas opciones. regrese al menï¿½ principal.
	_10203("10203"),//10203: Ha seleccionado una opciï¿½n no permitida.
	_10204("10204"),//10204: No puede seleccionar ese menï¿½.
	_10205("10205"),//10205: Menï¿½ no encontrado.
	_10206("10206"),//10206: ERROR de memoria. Contacte su DBA.
	_10207("10207"),//10207: No hay menï¿½ anterior.
	_10208("10208"),//10208: No existe parï¿½metro.
	_10209("10209"),//10209: No hay menï¿½ posterior.
	_10210("10210"),//10210: Se requiere una respuesta.
	_10211("10211"),//10211: El campo debe ser llenado completamente.
	_10212("10212"),//10212: No se puede conectar con ese usuario y clave.
	_10213("10213"),//10213: Proceso de conexiï¿½n terminado.
	_10214("10214"),//10214: No esta autorizado para ejecutar algun programa
	_10215("10215"),//10215: No existe ayuda disponible.
	_10216("10216"),//10216: No se puede enviar el comando al sistema operacional.
	_10217("10217"),//10217: No esta autorizado para usar esta opciï¿½n.
	_10218("10218"),//10218: ERROR en el menï¿½.
	_10219("10219"),//10219: Nï¿½mero de opciï¿½n no es vï¿½lida.
	_10220("10220"),//10220: No existe ayuda detallada para este ï¿½tem.
	_10221("10221"),//10221: No se puede leer el archivo
	_10222("10222"),//10222: Mï¿½dulo creado con una versiï¿½n anterior de ORACLE FORMS
	_10223("10223"),//10223: No existe parï¿½metro del mï¿½dulo.
	_10224("10224"),//10224: No existe variable del mï¿½dulo.
	_10225("10225"),//10225: No se pueden leer los datos del parï¿½metro.
	_10226("10226"),//10226: No se pueden leer los datos de la variable.
	_10227("10227"),//10227: Muchos parï¿½metros para el menï¿½
	_10228("10228"),//10228: No se puede leer texto de ayuda
	_10229("10229"),//10229: No se puede cerrar el archivo
	_10230("10230"),//10230: No existe procedimiento del mï¿½dulo.
	_10231("10231"),//10231: No se puede leer datos del procedimiento.
	_10233("10233"),//10233: Macros de navegaciï¿½n no validas.
	_10234("10234"),//10234: ERROR de sintaxis en macro.
	_10235("10235"),//10235: Macro no encontrada.
	_10236("10236"),//10236: No se especificï¿½ macro.
	_10237("10237"),//10237: No se permeation arguments en esta macro.
	_10238("10238"),//10238: ERROR de ejecuciï¿½n de comando
	_10239("10239"),//10239: No se puede leer una forma con ese nombre.
	_10240("10240"),//10240: Forma no especificada.
	_10241("10241"),//10241: Llamado ilegal de macro.
	_10242("10242"),//10242: No se puede llamar un FORMA encadenada.
	_10243("10243"),//10243: ERROR en llamado de ORACLE FORMS.
	_10244("10244"),//10244: No existe la aplicaciï¿½n.
	_10245("10245"),//10245: En el primer ï¿½tem.
	_10246("10246"),//10246: ERROR ejecutando un procedimiento. Forma inactiva.
	_10247("10247"),//10247: No hay opciones activas en el menï¿½ principal.
	_10248("10248"),//10248: No se puede seleccionar directamente cuando se usa el menï¿½ principal.
	_10249("10249"),//10249: No esta autorizado para ejecutar la aplicaciï¿½n.
	_10250("10250"),//10250: ERROR en inicializaciï¿½n de ORACLE FORMS.
	_10253("10253"),//10253: Debe digitar un nombre de archivo.
	_10254("10254"),//10254: No se puede abrir el archivo desde esta pantalla.
	_10255("10255"),//10255: ERROR de impresiï¿½n de la pantalla.
	_10256("10256"),//10256: No esta autorizado para ejecutar ORACLE FORMS MENU.
	_10257("10257"),//10257: No esta autorizado para seleccionar la opciï¿½n.
	_10258("10258"),//10258: El menï¿½ ya estï¿½ activo.
	_10259("10259"),//10259: Argumento nulo NO valido para la funciï¿½n.
	_10260("10260"),//10260: No hay opciones activas en el menï¿½.
	_10261("10261"),//10261: Mï¿½dulo creado con una versiï¿½n mas nueva de ORACLE FORMS
	_10262("10262"),//10262: Tipos de opciï¿½n no vï¿½lidos en este tipo de menï¿½.
	_10263("10263"),//10263: No existe el icono para el menï¿½.
	_10264("10264"),//10264: No existe la opciï¿½n.
	_10265("10265"),//10265: Librerï¿½a creada con una versiï¿½n anterior de ORACLE FORMS
	_10266("10266"),//10266: Librerï¿½a creada con una versiï¿½n mas nueva de ORACLE FORMS
	_10268("10268"),//10268: ERROR: Programas no compilados.
	_10269("10269"),//10269: ALERTA: Programas no compilados.
	_40001("40001"),//40001: Faltan arguments en la lï¿½nea de comandos.
	_40003("40003"),//40003: Sobran arguments en la lï¿½nea de comandos.
	_40006("40006"),//40006: Conexiï¿½n de red desconocida.
	_40007("40007"),//40007: Usuario o clave NO vï¿½lidas. Intente de nuevo.
	_40008("40008"),//40008: Usuario o clave NO validas. Intente de nuevo.
	_40009("40009"),//40009: No se puede conectar en esta red.
	_40010("40010"),//40010: No se puede leer la forma
	_40011("40011"),//40011: Forma creada con una versiï¿½n anterior de ORACLE FORMS
	_40012("40012"),//40012: Forma creada con una versiï¿½n mas nueva de ORACLE FORMS
	_40013("40013"),//40013: ERROR de programa mientras se leï¿½a la forma.
	_40014("40014"),//40014: No hay memoria para cargar la forma.
	_40015("40015"),//40015: Fin de archivo inesperado.
	_40019("40019"),//40019: Nï¿½mero de pantalla desconocido.
	_40020("40020"),//40020: Pï¿½gina muy pequeï¿½a para esta forma.
	_40021("40021"),//40021: Item muy largo en el archivo.
	_40023("40023"),//40023: ERROR creando el manejador del registro.
	_40024("40024"),//40024: Memoria agotada.
	_40025("40025"),//40025: No se puede eliminar la pantalla si un archivo de entrada.
	_40026("40026"),//40026: ERROR abriendo el archivo de teclas.
	_40027("40027"),//40027: ERROR abriendo el archivo de salida de pantallas.
	_40028("40028"),//40028: ERROR abriendo el archivo de MENSAJES2
	_40029("40029"),//40029: Ya estï¿½ conectado. debe desconectarse si desea volverse a conectar.
	_40030("40030"),//40030: El archivo no es de ORACLE FORMS..
	_40031("40031"),//40031: El archivo no es una FORMA..
	_40032("40032"),//40032: ERROR INTERNO: Archivo con tamaï¿½o errado.
	_40033("40033"),//40033: ERROR INTERNO: Archivo con tabla errada.
	_40034("40034"),//40034: No se puede ligar la librerï¿½a.
	_40035("40035"),//40035: ERROR creando el "per-block" del manejador del registro.
	_40036("40036"),//40036: Librerï¿½a creada con una versiï¿½n mas nueva de ORACLE FORMS
	_40037("40037"),//40037: Librerï¿½a creada con una versiï¿½n anterior de ORACLE FORMS
	_40038("40038"),//40038: No se pudo encontrar el control VBX.
	_40100("40100"),//40100: Se Encuentra en el Primer Registro.
	_40101("40101"),//40101: No se puede ubicar en un ï¿½tem no navegable.
	_40102("40102"),//40102: Complete los datos del registro o Lï¿½mpielo.
	_40103("40103"),//40103: No se puede ubicar en un ï¿½tem no actualizable.
	_40104("40104"),//40104: No Encuentra el Bloque.
	_40105("40105"),//40105: Deshabilitado para Referenciar el Campo.
	_40106("40106"),//40106: No hay ï¿½tems navegables en el bloque.
	_40107("40107"),//40107: No se puede ubicar en un ï¿½tem oculto.
	_40108("40108"),//40108: No existe la forma
	_40109("40109"),//40109: Navegaciï¿½n no permitida en modo consulta.
	_40110("40110"),//40110: Se encuentra en el primer bloque.
	_40111("40111"),//40111: Se encuentra en el ï¿½ltimo bloque.
	_40200("40200"),//40200: Campo No Actualizable.
	_40201("40201"),//40201: El campo es nulo. no puede escribir nada sobre ï¿½l.
	_40202("40202"),//40202: Campo obligatorio.
	_40203("40203"),//40203: El campo debe ser llenado completamente.
	_40204("40204"),//40204: El cursor estï¿½ al principio del valor del campo.
	_40205("40205"),//40205: El cursor estï¿½ al principio del valor del campo.
	_40206("40206"),//40206: El caracter anterior estï¿½ oculto.
	_40207("40207"),//40207: El dato debe estar en el rango permitido.
	_40208("40208"),//40208: No se pueden cambiar datos. la forma es de solo consulta.
	_40209("40209"),//40209: El campo debe tener el formato correcto:
	_40210("40210"),//40210: Texto buscado no encontrado.
	_40211("40211"),//40211: ALERTA: Este campo no es multilinea.
	_40212("40212"),//40212: Valor NO valido.
	_40213("40213"),//40213: No hay nada marcado para copiar.
	_40214("40214"),//40214: No se puede copiar o cortar. no hay portapapeles.
	_40215("40215"),//40215: No se puede escribir en el portapapeles.
	_40216("40216"),//40216: No se puede abrir el portapapeles.
	_40217("40217"),//40217: No se puede obtener el tamaï¿½o de datos del portapapeles.
	_40218("40218"),//40218: No se puede leer el portapapeles.
	_40219("40219"),//40219: No se pueden formatear los datos del portapapeles.
	_40220("40220"),//40220: No se puede pasar del portapapeles. valor muy largo.
	_40252("40252"),//40252: Ultimo registro de la consulta recuperado
	_40301("40301"),//40301: La consulta NO encontrï¿½ registros. Verifique.
	_40302("40302"),//40302: No se puede ingresar criterio de consulta. no hay campos consultables.
	_40303("40303"),//40303: No hay campos de tabla en este bloque.
	_40350("40350"),//40350: La consulta NO encontrï¿½ registros.
	_40352("40352"),//40352: Se Encuentra en el ï¿½ltimo Registro.
	_40353("40353"),//40353: Consulta cancelada.
	_40355("40355"),//40355: La consulta traerï¿½ No. registros.
	_40356("40356"),//40356: Nï¿½mero invï¿½lido en el registro de criterio. no se ejecutï¿½ la consulta.
	_40357("40357"),//40357: Cadena de texto invï¿½lida en el registro de criterio. no se ejecutï¿½ la consulta.
	_40358("40358"),//40358: Fecha invï¿½lida en el registro de criterio. no se ejecutï¿½ la consulta.
	_40359("40359"),//40359: Hora o fecha invï¿½lida en el registro de criterio. no se ejecutï¿½ la consulta.
	_40360("40360"),//40360: No se pueden Consultar Registros aquï¿½.
	_40361("40361"),//40361: Operaciï¿½n de consulta no soporta el tipo de datos de tiempo.
	_40400("40400"),//40400: Registro(s) guardado(s) correctamente
	_40401("40401"),//40401: No hay cambios para guardar.
	_40402("40402"),//40402: Grabaciï¿½n Cancelada.
	_40403("40403"),//40403: Hay cambios no guardados aï¿½n. no se permite guardar.
	_40404("40404"),//40404: Transacciï¿½n en la base completa. Registro Marcado para guardar.
	_40405("40405"),//40405: No hay cambios que guardar.
	_40406("40406"),//40406: Transacciï¿½n Completa. Registros guardados.
	_40407("40407"),//40407: Transacciï¿½n Completa. Registro Guardado
	_40501("40501"),//40501: ERROR ORACLE: No se puede reservar este registro para actualizarlo o borrarlo. Contacte su DBA.
	_40502("40502"),//40502: ERROR ORACLE: No se puede leer la lista de valores.Contacte su DBA.
	_40504("40504"),//40504: ERROR ORACLE: No se puede ejecutar un tipo de subprograma. Contacte su DBA.
	_40505("40505"),//40505: ERROR ORACLE: No es posible ejecutar Consulta. Contacte su DBA.
	_40506("40506"),//40506: ERROR ORACLE: No es posible ejecutar Consulta. Contacte su DBA.
	_40507("40507"),//40507: ERROR ORACLE: No es posible ejecutar Consulta. Contacte su DBA.
	_40508("40508"),//40508: ERROR ORACLE: No es posibleINSERTar el Registro. Contacte su DBA.
	_40509("40509"),//40509: ERROR ORACLE: No es posible Modificar el Registro. Contacte su DBA.
	_40510("40510"),//40510: ERROR ORACLE: No es posible Borrar el Registro. Contacte su DBA.
	_40511("40511"),//40511: ERROR ORACLE: No se puede ejecutar un subprograma. Contacte su DBA.
	_40512("40512"),//40512: ERROR ORACLE: No se puede colocar un SAVEPOINT. Contacte su DBA.
	_40513("40513"),//40513: ERROR ORACLE: No se puede obtener la fecha del sistema. Contacte su DBA.
	_40514("40514"),//40514: Se requiere estar conectado a la base de datos.
	_40515("40515"),//40515: ERROR ORACLE: No se puede abrir un cursor. Contactesu DBA.
	_40600("40600"),//40600: Este Registro Ya Existe.
	_40602("40602"),//40602: No se puedeINSERTar o actualizar en una vista (view).
	_40603("40603"),//40603: No se pueden reservar registros para actualizaciï¿½n.Vuelva a consultar.
	_40652("40652"),//40652: No se puede reservar la tabla.
	_40653("40653"),//40653: El registro no estï¿½ reservado para actualizaciï¿½n. Intente despuï¿½s.
	_40654("40654"),//40654: Este Registro ha sido actualizado. vuelva a consultar para ver los cambios.
	_40655("40655"),//40655: Un ERROR de SQL obligo a descartar los cambios. limpie la forma e ingrese los cambios de nuevo.
	_40656("40656"),//40656: No se puede actualizar el registro por una operaciï¿½n para descartar los cambios. Limpie el registro.
	_40657("40657"),//40657: Este Registro ha sido actualizado. vuelva a consultar para ver los cambios.
	_40659("40659"),//40659: Ya se trajo el ultimo registro de la consulta. Vuelva a consultar para traer los que faltan.
	_40700("40700"),//40700: No existe el subprograma
	_40702("40702"),//40702: No se puede llamar a una forma antes de guardar los datos.
	_40703("40703"),//40703: No se pueden cambiar datos. si la forma estï¿½ en modo de consulta.
	_40704("40704"),//40704: ERROR en programa SQL.
	_40705("40705"),//40705: ERROR en programa SQL.
	_40714("40714"),//40714: Funciï¿½n no habilitada.
	_40720("40720"),//40720: ERROR en subprograma de versiï¿½n anterior (V2).
	_40721("40721"),//40721: ERROR en subprograma de versiï¿½n anterior (V2).
	_40722("40722"),//40722: ERROR en programa SQL. No existe una funciï¿½n.
	_40723("40723"),//40723: ERROR en programa SQL. Faltan arguments para una funciï¿½n.
	_40724("40724"),//40724: ERROR en programa SQL.
	_40725("40725"),//40725: ERROR en programa SQL.
	_40726("40726"),//40726: ERROR en programa SQL.
	_40727("40727"),//40727: ERROR en programa SQL.
	_40728("40728"),//40728: ERROR en programa SQL. Sobran arguments para una funciï¿½n.
	_40729("40729"),//40729: ERROR en programa SQL. Falta punto y coma.
	_40730("40730"),//40730: ERROR en programa SQL. Nivel de mensaje invï¿½lido.
	_40731("40731"),//40731: ERROR en programa SQL. Falta INTO.
	_40732("40732"),//40732: ERROR en programa SQL. Falta rï¿½tulo en GOTO.
	_40733("40733"),//40733: ERROR en programa SQL. Contacte su DBA.
	_40734("40734"),//40734: ERROR INTERNO PL/SQL. Contacte su DBA.
	_40735("40735"),//40735: ERROR de programa. Excepciï¿½n no manejada. Contacte su DBA.
	_40736("40736"),//40736: ERROR INTERNO PL/SQL. Contacte su DBA.
	_40737("40737"),//40737: ERROR en programa SQL. Uso indebido de suprogramas restringidos
	_40738("40738"),//40738: ERROR en programa SQL. Argumento no puede ser nulo.
	_40739("40739"),//40739: ERROR en programa SQL.
	_40740("40740"),//40740: ERROR en programa SQL. Uso indebido de suprogramas restringidos
	_40741("40741"),//40741: No existe el nï¿½mero de registro especificado.
	_40742("40742"),//40742: ERROR en programa SQL.
	_40743("40743"),//40743: ERROR en programa SQL.
	_40744("40744"),//40744: Se truncarï¿½ el texto si se usa ese editor.
	_40745("40745"),//40745: Se truncarï¿½ el texto.
	_40746("40746"),//40746: ERROR en programa SQL.
	_40747("40747"),//40747: ERROR en programa SQL.
	_40748("40748"),//40748: Ha interrumpido el subprograma.
	_40800("40800"),//40800: No existe la funciï¿½n externa (USER-EXIST).
	_40801("40801"),//40801: Memoria agotada. Contacte su DBA.
	_40804("40804"),//40804: ERROR en programa SQL.
	_40805("40805"),//40805: ERROR en programa SQL.
	_40807("40807"),//40807: ERROR en programa SQL. No hay comando.
	_40808("40808"),//40808: No se pudo ejecutar el comando. ERROR en sistema operacional. Contacte su DBA.
	_40809("40809"),//40809: El comando terminï¿½ con MENSAJES2.
	_40811("40811"),//40811: El comando terminï¿½ con MENSAJES2.
	_40814("40814"),//40814: Funciï¿½n no habilitada.
	_40815("40815"),//40815: No existe la variable global
	_40816("40816"),//40816: ERROR INTERNO: No hay memoria. Contacte su DBA.
	_40817("40817"),//40817: ERROR INTERNO: No hay memoria. Contacte su DBA.
	_40818("40818"),//40818: No existe variable del sistema.
	_40819("40819"),//40819: La variable del sistema no se puede modificar.
	_40820("40820"),//40820: ERROR INTERNO: No hay memoria. Contacte su DBA.
	_40822("40822"),//40822: ERROR en programa.
	_40823("40823"),//40823: ERROR en programa.
	_40824("40824"),//40824: ERROR en programa.
	_40825("40825"),//40825: ERROR en programa.
	_40826("40826"),//40826: ERROR en programa.
	_40827("40827"),//40827: ERROR en programa.
	_40828("40828"),//40828: ERROR en programa.
	_40829("40829"),//40829: ERROR en programa.
	_40830("40830"),//40830: ERROR en programa.
	_40831("40831"),//40831: Se ha truncado un dato muy largo para el campo
	_40900("40900"),//40900: No hay memoria suficiente o el disco estï¿½ lleno. Limpie la forma e intente de nuevo.
	_40901("40901"),//40901: ERROR INTERNO: No hay memoria. Contacte su DBA.
	_40902("40902"),//40902: ERROR en programa SQL.
	_40903("40903"),//40903: No se puede crear un archivo de salida.
	_40904("40904"),//40904: ERROR INTERNO: Operaciï¿½n desconocida. Contacte su DBA.
	_40905("40905"),//40905: ERROR INTERNO: No se pueden poner mas registros en el disco. Contacte su DBA.
	_40906("40906"),//40906: ERROR FATAL: No se puede escribir en el disco. Contacte si DBA.
	_40907("40907"),//40907: ERROR FATAL: No se puede leer del disco. Contacte si DBA.
	_40908("40908"),//40908: ERROR FATAL: ERROR interno de memoria. Contacte si DBA.
	_40909("40909"),//40909: ERROR INTERNO: ERROR desconocido. Contacte su DBA.
	_40910("40910"),//40910: ERROR INTERNO: ERROR en PL/SQL. Contacte su DBA.
	_40911("40911"),//40911: ERROR INTERNO: ERROR en generaciï¿½n de secuencia. Contacte su DBA.
	_40912("40912"),//40912: ERROR en programa SQL. Contacte su DBA.
	_40913("40913"),//40913: ERROR en programa SQL.
	_40914("40914"),//40914: ERROR INTERNO: ERROR de memoria. Contacte su DBA.
	_40915("40915"),//40915: ERROR INTERNO: ERROR de memoria. Contacte su DBA.
	_40916("40916"),//40916: ERROR INTERNO: ERROR de memoria. Contacte su DBA.
	_40917("40917"),//40917: ERROR INTERNO: ERROR de memoria. Contacte su DBA.
	_40918("40918"),//40918: ERROR INTERNO. Contacte su DBA.
	_40919("40919"),//40919: ERROR en sentencia SQL. Revise e intente de nuevo.
	_40920("40920"),//40920: ERROR INTERNO. Contacte su DBA.
	_40921("40921"),//40921: ERROR INTERNO. Contacte su DBA.
	_41000("41000"),//41000: Tecla no definida o funciï¿½n no disponible.
	_41001("41001"),//41001: Funciï¿½n no permitida.
	_41002("41002"),//41002: Por favor haga una selecciï¿½n correcta.
	_41003("41003"),//41003: Esta funciï¿½n no esta permitida en este sitio.
	_41004("41004"),//41004: Esta funciï¿½n no esta permitida en este modo.
	_41005("41005"),//41005: Tecla no definida o funciï¿½n no disponible.
	_41006("41006"),//41006: Tecla no definida o funciï¿½n no disponible.
	_41007("41007"),//41007: Funciï¿½n no habilitada.
	_41008("41008"),//41008: Tecla no disponible.
	_41009("41009"),//41009: Tecla no disponible.
	_41010("41010"),//41010: ERROR en programa SQL.
	_41011("41011"),//41011: ERROR en programa SQL. Atributo no definido.
	_41012("41012"),//41012: ERROR en programa SQL. Item o variable no definido.
	_41013("41013"),//41013: ERROR en programa SQL. Item no definido.
	_41014("41014"),//41014: ERROR en programa SQL. Atributo de canvas nulo.
	_41015("41015"),//41015: ERROR en programa SQL.
	_41016("41016"),//41016: ERROR en programa SQL.
	_41017("41017"),//41017: ERROR en programa SQL.
	_41018("41018"),//41018: ERROR en programa SQL.
	_41019("41019"),//41019: ERROR en programa SQL.
	_41020("41020"),//41020: ERROR en programa SQL.
	_41021("41021"),//41021: ERROR en programa SQL.
	_41022("41022"),//41022: ERROR en programa SQL.
	_41023("41023"),//41023: ERROR en programa SQL.
	_41024("41024"),//41024: ERROR en programa SQL.
	_41025("41025"),//41025: ERROR en programa SQL. Pï¿½gina no existe.
	_41026("41026"),//41026: Operaciï¿½n NO valida.
	_41027("41027"),//41027: ERROR en programa SQL. Debe definir llave primaria.
	_41028("41028"),//41028: ERROR en programa SQL. Propiedad invï¿½lida.
	_41029("41029"),//41029: ERROR en programa SQL. Parï¿½metro invï¿½lido.
	_41030("41030"),//41030: ERROR en programa SQL.
	_41031("41031"),//41031: ERROR en programa SQL.
	_41032("41032"),//41032: ERROR en programa SQL.
	_41033("41033"),//41033: ERROR en programa SQL.
	_41034("41034"),//41034: ERROR en programa SQL.
	_41035("41035"),//41035: ERROR en programa SQL.
	_41036("41036"),//41036: ERROR en programa SQL. Checkbox no consultable.
	_41037("41037"),//41037: ERROR en programa SQL. Radio group no consultable.
	_41038("41038"),//41038: ERROR en programa SQL. El ï¿½tem no es de chequeo.
	_41039("41039"),//41039: ERROR en programa SQL. No existe la Alerta.
	_41040("41040"),//41040: ERROR en programa SQL. No existe el ratio button.
	_41041("41041"),//41041: ERROR en programa SQL. No existe el mï¿½dulo.
	_41042("41042"),//41042: ERROR en programa SQL. No existe la propiedad.
	_41043("41043"),//41043: ERROR en programa SQL. No existe el timer.
	_41044("41044"),//41044: ERROR en programa SQL. ERROR borrando un timer.
	_41045("41045"),//41045: ERROR en programa SQL. No existe el Item.
	_41046("41046"),//41046: ERROR en programa SQL. Parï¿½metro invï¿½lido.
	_41047("41047"),//41047: ERROR en programa SQL. No se puede navegar en modo consulta.
	_41048("41048"),//41048: ERROR en programa SQL. Procedimiento no vï¿½lido.
	_41049("41049"),//41049: Este registro NO se puede borrar.
	_41050("41050"),//41050: ERROR en programa SQL. No se puede actualizar el registro.
	_41051("41051"),//41051: No se pueden crear registros.
	_41052("41052"),//41052: ERROR en programa SQL. No existe la ventana.
	_41053("41053"),//41053: ERROR en programa SQL. No existe el canvas.
	_41054("41054"),//41054: ERROR en programa SQL. No existe la propiedad.
	_41055("41055"),//41055: ERROR en programa SQL. No existe la propiedad.
	_41056("41056"),//41056: No existe el bloque.
	_41057("41057"),//41057: ERROR en programa SQL. No existe la propiedad.
	_41058("41058"),//41058: ERROR en programa SQL. No existe la propiedad.
	_41059("41059"),//41059: ERROR en programa SQL. No existe la propiedad.
	_41060("41060"),//41060: No se puede deshabilitar la llave primaria.
	_41061("41061"),//41061: ERROR en programa SQL. No existe la propiedad.
	_41062("41062"),//41062: No se encontrï¿½ el editor.
	_41063("41063"),//41063: No se puede crear el editor.
	_41064("41064"),//41064: No se puede crear el timer.
	_41065("41065"),//41065: No existe el menï¿½.
	_41066("41066"),//41066: Propiedad de FORMA incorrecta
	_41067("41067"),//41067: No existe la opciï¿½n del Menï¿½
	_41068("41068"),//41068: Propiedad de MENU incorrecta
	_41069("41069"),//41069: Propiedad de MENU incorrecta
	_41070("41070"),//41070: Propiedad de MENU incorrecta
	_41071("41071"),//41071: Propiedad de MENU incorrecta
	_41072("41072"),//41072: No se puede crear el grupo
	_41073("41073"),//41073: No existe el grupo
	_41074("41074"),//41074: No se encuentra el grupo o la columna
	_41075("41075"),//41075: ERROR borrando el grupo
	_41076("41076"),//41076: ERROR poblando el grupo
	_41077("41077"),//41077: ERROR borrando las filas del grupo
	_41078("41078"),//41078: ERROR reconstruyendo la selecciï¿½n del grupo
	_41079("41079"),//41079: ERROR adicionando columnas al grupo
	_41080("41080"),//41080: ERROR adicionando filas al grupo
	_41081("41081"),//41081: No se puede mover el ï¿½tem. posiciï¿½n invï¿½lida
	_41082("41082"),//41082: No se puede redimensionar el ï¿½tem. posiciï¿½n fuera del canvas
	_41083("41083"),//41083: Propiedad de FORMA incorrecta
	_41084("41084"),//41084: ERROR recuperando celda del grupo
	_41085("41085"),//41085: ERROR recuperando conteo de filas del grupo
	_41086("41086"),//41086: ERROR recuperando conteo de selecciï¿½n del grupo
	_41087("41087"),//41087: ERROR recuperando selecciï¿½n del grupo
	_41088("41088"),//41088: No se puede actualizar la selecciï¿½n del grupo.
	_41089("41089"),//41089: No se puede mover la vista. posiciï¿½n invï¿½lida
	_41090("41090"),//41090: Item invï¿½lido para navegaciï¿½n.
	_41091("41091"),//41091: No existe lista de valores. identificaciï¿½n invï¿½lida.
	_41092("41092"),//41092: No hay registros en el bloque
	_41093("41093"),//41093: ERROR actualizando atributo de ï¿½tem
	_41094("41094"),//41094: Propiedad de VISTA incorrecta
	_41095("41095"),//41095: Propiedad de CANVAS incorrecta
	_41096("41096"),//41096: No se puede redimensionar la vista. tamaï¿½o invï¿½lido
	_41097("41097"),//41097: No se puede redimensionar el canvas. tamaï¿½o invï¿½lido
	_41098("41098"),//41098: No se puede modificar la posiciï¿½n de despliegue de una vista de contenido.
	_41099("41099"),//41099: No se puede modificar el tamaï¿½o de una vista de contenido.
	_41100("41100"),//41100: No existe la relaciï¿½n
	_41101("41101"),//41101: Propiedad de RELACIï¿½N incorrecta
	_41102("41102"),//41102: Propiedad de RELACIï¿½N incorrecta
	_41103("41103"),//41103: Valor de propiedad de RELACIï¿½N incorrecto
	_41104("41104"),//41104: No existe la relaciï¿½n
	_41105("41105"),//41105: No puede hacer consultas sin haber salvado antes.
	_41106("41106"),//41106: No se pueden crear registros dependientes si tener un registro padre.
	_41200("41200"),//41200: ERROR DE INTEGRACIï¿½N: producto invï¿½lido
	_41201("41201"),//41201: ERROR DE INTEGRACIï¿½N: el modo de comunicaciï¿½n debe ser SYNCHRONOUS o ASYNCHRONOUS.
	_41202("41202"),//41202: ERROR DE INTEGRACIï¿½N: lista de parï¿½metros vacï¿½a
	_41203("41203"),//41203: ERROR DE INTEGRACIï¿½N: lista de parï¿½metros invï¿½lida.
	_41204("41204"),//41204: ERROR DE INTEGRACIï¿½N: ERROR de memoria. Contacte su DBA.
	_41205("41205"),//41205: ERROR DE INTEGRACIï¿½N: El ï¿½tem no es de tipo caracter.
	_41206("41206"),//41206: ERROR DE INTEGRACIï¿½N: Item ambiguo
	_41207("41207"),//41207: ERROR DE INTEGRACIï¿½N: No existe el ï¿½tem
	_41208("41208"),//41208: ERROR DE INTEGRACIï¿½N: El modo de ejecuciï¿½n debe serBATCH o RUNTIME
	_41209("41209"),//41209: ERROR DE INTEGRACIï¿½N: La localizaciï¿½n del documento debe ser FILESYSTEM o DB
	_41210("41210"),//41210: ERROR DE INTEGRACIï¿½N: Item nulo
	_41211("41211"),//41211: ERROR DE INTEGRACIï¿½N: Falla SSL ejecutando otro producto
	_41212("41212"),//41212: ERROR DE INTEGRACIï¿½N: Modo de comunicaciï¿½n de intercambio de datos invï¿½lido
	_41300("41300"),//41300: Parï¿½metro invï¿½lido.
	_41301("41301"),//41301: Parï¿½metro invï¿½lido.
	_41302("41302"),//41302: Parï¿½metro invï¿½lido.
	_41303("41303"),//41303: Propiedad invï¿½lida.
	_41304("41304"),//41304: Propiedad invï¿½lida.
	_41305("41305"),//41305: Propiedad invï¿½lida.
	_41306("41306"),//41306: Parï¿½metro invï¿½lido.
	_41307("41307"),//41307: Parï¿½metro invï¿½lido.
	_41308("41308"),//41308: ERROR actualizando selecciï¿½n de grupo.
	_41309("41309"),//41309: Propiedad invï¿½lida.
	_41310("41310"),//41310: Propiedad invï¿½lida.
	_41311("41311"),//41311: Arguments invï¿½lidos
	_41312("41312"),//41312: Debe tener por lo menos un ï¿½tem actualizable en el bloque
	_41313("41313"),//41313: Propiedad invï¿½lida.
	_41314("41314"),//41314: No se puede modificar una propiedad.
	_41315("41315"),//41315: No se puede modificar una propiedad.
	_41316("41316"),//41316: No se puede modificar una propiedad.
	_41317("41317"),//41317: El ï¿½tem no es un "radio button"
	_41318("41318"),//41318: El ï¿½tem no es un "VBX"
	_41319("41319"),//41319: Propiedad invï¿½lida.
	_41320("41320"),//41320: Propiedad invï¿½lida.
	_41321("41321"),//41321: Propiedad invï¿½lida.
	_41322("41322"),//41322: Evento invï¿½lido.
	_41323("41323"),//41323: Muchos parï¿½metros.
	_41324("41324"),//41324: Pocos parï¿½metros.
	_41325("41325"),//41325: El evento VBX debe ser una cadena.
	_41326("41326"),//41326: Falla entregando un evento al ï¿½tem VBX.
	_41327("41327"),//41327: Propiedad invï¿½lida en un ï¿½tem VBX.
	_41328("41328"),//41328: Propiedad invï¿½lida en un ï¿½tem VBX.
	_41329("41329"),//41329: No es un ï¿½tem de tipo lista.
	_41330("41330"),//41330: No se puedeINSERTar un elemento en una lista.
	_41331("41331"),//41331: No se puede borrar un elemento en una lista.
	_41332("41332"),//41332: Elemento de lista fuera de rango.
	_41333("41333"),//41333: No se puede convertir el valor del elemento de la lista.
	_41334("41334"),//41334: Grupo invï¿½lido durante la poblaciï¿½n de una lista.
	_41335("41335"),//41335: Tipo invï¿½lido para la columna 1 durante la poblaciï¿½n de una lista.
	_41336("41336"),//41336: Tipo invï¿½lido para la columna 2 durante la poblaciï¿½n de una lista.
	_41337("41337"),//41337: No se puede poblar la lista desde el grupo.
	_41338("41338"),//41338: No se puede recuperar la lista en el grupo.
	_41339("41339"),//41339: No se puede limpiar la lista
	_41340("41340"),//41340: Propiedad invï¿½lida.
	_41341("41341"),//41341: Tamaï¿½o de cursor invï¿½lido.
	_41342("41342"),//41342: Parï¿½metro invï¿½lido.
	_41343("41343"),//41343: El ï¿½tem no es un objeto OLE.
	_41344("41344"),//41344: Objeto OLE no definido.
	_41345("41345"),//41345: No existe el verbo para este servidor.
	_41346("41346"),//41346: No existe el verbo de conteo para el objeto OLE.
	_41347("41347"),//41347: Verbo invï¿½lido para el objeto OLE
	_41348("41348"),//41348: ERROR de servidor OLE.
	_41349("41349"),//41349: El objeto OLE no puede ejecutar el verbo
	_41350("41350"),//41350: El objeto OLE no esta siendo mostrado
	_41351("41351"),//41351: No se puede navegar fuera de la forma corriente.
	_41352("41352"),//41352: No se puede crear una nueva sesiï¿½n.
	_41353("41353"),//41353: No se puede llamar otra forma.
	_41354("41354"),//41354: No se puede cerrar la forma
	_41355("41355"),//41355: No se puede navegar a la forma
	_41356("41356"),//41356: Mï¿½todo invï¿½lido.
	_41357("41357"),//41357: Nï¿½mero de arguments incorrecto para el mï¿½todo del ï¿½tem VBX
	_41358("41358"),//41358: El mï¿½todo fallï¿½ para el ï¿½tem VBX
	_41359("41359"),//41359: No se puede crear una nueva sesiï¿½n.
	_41360("41360"),//41360: Valor de propiedad de VENTANA incorrecto
	_41361("41361"),//41361: No se puede navegar fuera de la forma corriente.
	_41362("41362"),//41362: Propiedad invï¿½lida.
	_41363("41363"),//41363: Propiedad invï¿½lida.
	_41364("41364"),//41364: Nï¿½mero de columna invï¿½lido
	_41385("41385"),//41385: Mï¿½ximo nï¿½mero de registros de consulta excedidos
	_41800("41800"),//41800: No hay Lista de Valores para este Campo.
	_41801("41801"),//41801: ï¿½ltimo valor alcanzado.
	_41802("41802"),//41802: Solo se puede duplicar sobre registros nuevos
	_41803("41803"),//41803: No hay registros anteriores para duplicar
	_41804("41804"),//41804: La variable no fue ingresada
	_41805("41805"),//41805: Nombre de ï¿½tem invï¿½lido
	_41806("41806"),//41806: Muchas variables usadas
	_41809("41809"),//41809: ERROR iniciando menï¿½.
	_41810("41810"),//41810: ERROR creando menï¿½.
	_41811("41811"),//41811: ERROR removiendo menï¿½.
	_41812("41812"),//41812: ERROR reiniciando menï¿½.
	_41813("41813"),//41813: Saliendo de la forma por el modo debug.
	_41814("41814"),//41814: Posiciï¿½n de pï¿½gina invï¿½lido
	_41815("41815"),//41815: Propiedad invï¿½lida.
	_41816("41816"),//41816: Se intento crear un timer existente.
	_41817("41817"),//41817: No existe el timer
	_41818("41818"),//41818: ERROR INTERNO: ERROR de memoria. no se puede crear el timer. Contacte su DBA.
	_41819("41819"),//41819: Los timer no son soportados por esta plataforma
	_41820("41820"),//41820: No se puede borrar el timer
	_41821("41821"),//41821: Nombre de timer invï¿½lido
	_41822("41822"),//41822: Nombre de timer invï¿½lido
	_41823("41823"),//41823: Intervalo de timer NO valido
	_41824("41824"),//41824: Fallï¿½ la operaciï¿½n de fecha
	_41825("41825"),//41825: Propiedad invï¿½lida.
	_41826("41826"),//41826: No se puede reemplazar el grupo
	_41827("41827"),//41827: El grupo no existe
	_41828("41828"),//41828: La lista de valores no existe
	_41829("41829"),//41829: Registro no creado.
	_41830("41830"),//41830: La lista de valores esta vacï¿½a
	_41832("41832"),//41832: ERROR: Programas no compilados.
	_41833("41833"),//41833: ERROR: Programas no compilados.
	_41834("41834"),//41834: No se puede crear la clase PECS
	_41900("41900"),//41900: Ejecuciï¿½n cancelada por un ERROR fatal.
	_41901("41901"),//41901: ERROR: cursores no cerrados
	_41902("41902"),//41902: Total de cursores usados
	_41903("41903"),//41903: Ejecuciï¿½n cancelada por fin de archivo
	_42015("42015"),//42015: Debe especificar un archivo de teclas en un modo no interactivo.
	_42016("42016"),//42016: Los archivos de lectura y de escritura no se pueden nombrar igual.
	_42017("42017"),//42017: Se debe especificar el nombre de un mï¿½dulo.
	_42100("42100"),//42100: No se han encontrado MENSAJES2 recientemente.
	_42400("42400"),//42400: Ejecutando el "even trigger"
	_42401("42401"),//42401: Ejecutando el "program trigger"
	_42402("42402"),//42402: La fecha de expedicion del documento. no puede superar a la fecha actual del sistema.
	_47000("47000"),//47000: ERROR INTERNO: No se puede crear la lista de parï¿½metros.
	_47001("47001"),//47001: Lista de parï¿½metros ya existe.
	_47002("47002"),//47002: Lista de parï¿½metros no existe.
	_47003("47003"),//47003: ERROR INTERNO: No se puede crear la lista de parï¿½metros.
	_47004("47004"),//47004: Parï¿½metro no existe
	_47005("47005"),//47005: ERROR INTERNO: No se puede validar el parï¿½metro.
	_47006("47006"),//47006: No se puede crear la lista de parï¿½metros. nombre NO vï¿½lido.
	_47007("47007"),//47007: Lista de parï¿½metros no existe.
	_47008("47008"),//47008: ERROR INTERNO: No se pueden adicionar parï¿½metros.
	_47009("47009"),//47009: Lista de parï¿½metros no existe.
	_47010("47010"),//47010: Lista de parï¿½metros no existe.
	_47011("47011"),//47011: Tipo de parï¿½metro incorrecto.
	_47012("47012"),//47012: Grupo no existe
	_47013("47013"),//47013: El parï¿½metro ya existe.
	_47014("47014"),//47014: ERROR INTERNO: No se puede borrar la lista de parï¿½metros.
	_47015("47015"),//47015: Lista de parï¿½metros no existe.
	_47016("47016"),//47016: Lista de parï¿½metros no existe.
	_47017("47017"),//47017: Lista de parï¿½metros no existe.
	_47018("47018"),//47018: ERROR INTERNO: No se puede borrar la lista de parï¿½metros.
	_47019("47019"),//47019: Lista de parï¿½metros no existe.
	_47020("47020"),//47020: Parï¿½metro no existe
	_47021("47021"),//47021: Parï¿½metro no existe
	_47022("47022"),//47022: No se puede crear la lista de parï¿½metros. nombre reservado.
	_47023("47023"),//47023: Parï¿½metro no existe
	_47024("47024"),//47024: Tipo de parï¿½metro incorrecto.
	_47025("47025"),//47025: Atributo no existe
	_47026("47026"),//47026: Parï¿½metro no existe
	_47027("47027"),//47027: Lista de parï¿½metros no existe.
	_47028("47028"),//47028: Grupo no existe
	_47029("47029"),//47029: Lista de parï¿½metros no existe.
	_47030("47030"),//47030: Valor del parï¿½metro muy largo
	_47100("47100"),//47100: No puede leer el archivo de imagen
	_47101("47101"),//47101: No puede escribir el archivo de imagen
	_47102("47102"),//47102: Operaciï¿½n invï¿½lida
	_47103("47103"),//47103: No se puede acercar o alejar la imagen
	_47104("47104"),//47104: Tipo incorrecto de imagen
	_47105("47105"),//47105: Falta nombre de imagen
	_47106("47106"),//47106: Falta tipo de imagen
	_47107("47107"),//47107: Factor de escalamiento incorrecto
	_47108("47108"),//47108: No es un ï¿½tem de tipo imagen.
	_47109("47109"),//47109: No puede localizar el archivo de imagen
	_47110("47110"),//47110: No hay imagen para redimensionar.
	_47111("47111"),//47111: No se puede copiar el valor al ï¿½tem
	_47112("47112"),//47112: Huella no coincide con la del Usuario 
	_47113("47113"),//47113: No Hay Comunicaciï¿½n con el AFIS
	_47114("47114"),//47114: No hay comunicacion con el WEB SERVICE BIOMETRIA
	_47115("47115"),//47115: El documento suministrado no es una solicitud de desembolso
	_47116("47116"),//47116: El nombre del documento suministrado no coincide con: SOLICITUD DE DESEMBOLSO
	_47117("47117"),//47117: El nombre concepto origen suministrado no coincide con el almacenado en SIMS
	_47118("47118"),//47118: El nombre concepto destino suministrado no coincide con el almacenado en SIMS
	_47119("47119"),//47119: La entidad financiera suministrada no coincide con la almacenada en SIMS
	_47120("47120"),//47120: La cuenta contable {1} no existe o hay problemas con su informacion
	_47121("47121"),//47121: La cuenta suministrada no pertenece al tercero asociado a la entidad financiera
	_47122("47122"),//47122: La suma de los valores ingresados a las cuentas de los terceros no concuerdan con el valor total del desembolso
	_47123("47123"),//47123: La solicitud transaccion no exixste o hay problemas con su informacion
	_47124("47124"),//47124: La transaccion ya existe pero tiene datos inconsistentes {1}
	_47125("47125"),//47125: Uno de los terceros. origen o destino debe ser Super Giros
	_47126("47126"),//47126: La caja origen no puede ser igual a la caja destino
	_47127("47127"),//47127: Password invalido.
	_47128("47128"),//47128: El tipo de identificacion del tercero origen es incorrecto o no existe en el sistema
	_47129("47129"),//47129: El tipo de identificacion del tercero destino es incorrecto o no existe en el sistema
	_47130("47130"),//47130: El nombre del tercero origen ingresado es incorrecto, debe ser {1}
	_47131("47131"),//47131: El nombre del tercero destino ingresado es incorrecto, debe ser {1}
	_48001("48001"),//48001: La clave ingresada para su giro no es correcta
	_48005("48005"),//48005: El usuario supero el numero de reenvios permitidos
	_48006("48006"),//48006: El sistema se encuentra procesando su mensaje de texto
	_48007("48007"),//48007: El pin se encuentra en un estado que no permite generar reenvio de mensaje de texto
	_48008("48008"),//48008: El mensaje de texto ha sido reenviado
	_48009("48009"),//48009: La sentencia SQL ingresada compila correctamente
	_48010("48010"),//48010: La sentencia SQL no indica el parametro de ejecuccion (:x)
	_48011("48011"),//48011: La sentencia debe retornar un unico registro y en una columna
	_48012("48012"),//48012: La sentencia SQL ingresada no compila correctamente
	_48013("48013"),//48013: No se permite la ejecuccion de la sentencia ingresada
	_48014("48014"),//48014: La llave de encriptacion de clave no se encuentra con la cantidad de caracteres permitida
	_48015("48015"),//48015: La clave ingresada no es valida para el pin
	_50001("50001"),//50001: Los caracteres vï¿½lidos son a..z. A..Z y el espacio
	_50002("50002"),//50002: El mes debe estar entre 1 y 12
	_50003("50003"),//50003: El aï¿½o debe estar entre 00..99 o 1000..4712
	_50004("50004"),//50004: El dï¿½a debe estar entre 1 y el ï¿½ltimo dï¿½a del mes.
	_50006("50006"),//50006: Campo Numï¿½rico.
	_50007("50007"),//50007: Muchos dï¿½gitos despuï¿½s del punto decimal.
	_50009("50009"),//50009: Muchos puntos decimales.
	_50010("50010"),//50010: El formato de moneda es: [+-]9999999.99
	_50011("50011"),//50011: No es un nombre de mes vï¿½lido
	_50012("50012"),//50012: El formato de la fecha es DD-MES-AA
	_50013("50013"),//50013: El mï¿½s o el menos debe estar en la primera posiciï¿½n.
	_50014("50014"),//50014: Exponente incorrecto.
	_50016("50016"),//50016: Campo Numï¿½rico.
	_50017("50017"),//50017: La hora debe estar entre 0 y 23
	_50018("50018"),//50018: Los minutos deben estar entre 0 y 59
	_50019("50019"),//50019: Los segundos deben estar entre 0 y 59
	_50020("50020"),//50020: Falta exponente.
	_50021("50021"),//50021: El formato de la fecha es DD/MM/AA
	_50022("50022"),//50022: El formato de la hora es HH:MM[:SS]
	_50023("50023"),//50023: Las fechas deben tener el formato correcto: DD/MM/AA
	_50024("50024"),//50024: Los espacios solo se permeation en las posiciones iniciales.
	_50025("50025"),//50025: El formato de fecha con hora es DD-MON-YYYY HH:MM[:SS].
	_50026("50026"),//50026: El formato de la fecha es DD/MM/YYYY
	_50027("50027"),//50027: Formato incorrecto para el tipo de dato.
	_50028("50028"),//50028: El formato no se permite para el tipo de dato.
	_50029("50029"),//50029: El seguro no se puede anular en el proveedor.
	_50030("50030"),//50030: El Enrolador no tiene permiso para enrolar el usuario.
	_50031("50031"),//50031: Ya existen registros con atributos diferentes e igual configuraciï¿½n para la fecha; revise las promociones existentes. corrï¿½jalas e intente nuevamente.
	_50032("50032"),//50032: Consecutivo en Uso. Intente nuevamente
	_50036("50036"),//50036: El tercero ya se encuetra enrolado
	_50037("50037"),//50037: Las Huellas del Indice derecho e Izquierdo Son Iguales
	_50038("50038"),//50038: No Hay Comunicacion con el AFIS
	_50039("50039"),//50039: No hay comunicacion con el WEB SERVICE BIOMETRIA
	_50040("50040"),//50040: Las huellas coinciden con las de otro colaborador
	_50041("50041"),//50041: La solicitud ya se encuentra pendiente por autorizar
	_50042("50042"),//50042: El Usuario no tiene permisos para Enrolar al Cliente
	_50043("50043"),//50043: El Tercero debe estar con estado Pendiente por Enrolar
	_50044("50044"),//50044: Se debe Declarar el parametro del Sistema {1} 
	_50045("50045"),//50045: El usuario esta bloqueado por inactividad 
	_50047("50047"),//50047: El Tercero Propietario No existe
	_50048("50048"),//50048: Se requiere enviar la Identificaciï¿½n del Cajero Colaborador
	_50049("50049"),//50049: El tercero propietario Colaborador no esta configurado en TERCDEPR
	_50050("50050"),//50050: El Cliente {1} se encuentra en Lista Clinton
	_50051("50051"),//50051: Formato Huella no Valida
	_50052("50052"),//50052: Usuario Colaborador no esta configurado como Usuario con multilpes Cajeros TERCDEPR
	_50053("50053"),//50053: Error AFIS {1}
	_50054("50054"),//50054: Cliente bloqueado por Cumplimiento
	_50055("50055"),//50055: Hora Final Job biometria
	_50056("50056"),//50056: El usuario ya se encuentra Desvinculado
	_50057("50057"),//50057: El usuario a desvincular no existe
	_50058("50058"),//50058: Tercero asociado al usuario a desvincular no existe
	_50059("50059"),//50059: Usuario administrador no existe
	_50060("50060"),//50060: Tercero asociado al usuario administrador no existe
	_50061("50061"),//50061: Error insertando en tabla auditoria AUDIDEUS
	_50062("50062"),//50062: Trama Excede el numero de Consultas en el dia
	_50063("50063"),//50063: La Trama Para el Tercero Propietario esta Inactiva 
	_50064("50064"),//50064: Hora no permitida para consultar Trama
	_50065("50065"),//50065: Clave de Tercero Propietario No Valida
	_50066("50066"),//50066: Usuario no pertenece al tercero Propietario
	_50067("50067"),//50067: Tercero Propietario No Tiene Usuario Asignado
	_50068("50068"),//50068: Tercero Propietario Debe ser enviado en la trama
	_50069("50069"),//50069: Tercero Propietario no Valido
	_50070("50070"),//50070: Tercero Bloqueado Por Huella
	_50071("50071"),//50071: Tercero menor de Edad. No Puede realizar operacion
	_50072("50072"),//50072: Para este tercero es requerida la fecha de Nacimiento
	_50073("50073"),//50073: El Remitente no tiene configurado Pais de Expedicion en el Documento
	_50074("50074"),//50074: El Beneficiario no tiene configurado Pais de Expediciï¿½n en el Documento
	_50075("50075"),//50075: El Remitente no tiene configurado Fecha de Entrada al Pais
	_50076("50076"),//50076: El Beneficiario no tiene configurado Fecha de Entrada al Pais
	_50077("50077"),//50077: La fecha de Vencimiento es obligatoria para el documento del Remitente
	_50078("50078"),//50078: La fecha de Vencimiento es obligatoria para el documento del Beneficiario
	_50079("50079"),//50079: El Remitente no puede realizar operaciones en esta Oficina
	_50080("50080"),//50080: El Beneficiario no puede realizar operaciones en esta Oficina
	_50081("50081"),//50081: El Terriroio ID es necesario para este tipo de documento
	_50082("50082"),//50082: El Remitente no tiene configurado Lugar de Expediciï¿½n en el Documento
	_50083("50083"),//50083: El Beneficiario no tiene configurado Lugar de Expediciï¿½n en el Documento
	_50084("50084"),//50084: La fecha de entrada al Pais no puede ser mayor a la fecha actual
	_50085("50085"),//50085: La fecha de entrada al Pais no puede ser mayor a la fecha de vencimiento del documento
	_50086("50086"),//50086: La fecha de vencimiento del documento ha expirado
	_50087("50087"),//50087: El tercero remitente con tipo de documento Pasaporte (PA). No puede realizar transacciones despues de {1} dias de entrar al pais
	_50088("50088"),//50088: El tercero debe ser mayor a {1} anios para enviar un giro
	_50089("50089"),//50089: Tipo de documento de usuario remitente no valido para realizar la transaccion
	_50090("50090"),//50090: El tipo de documento pasaporte no es valido para que un ciudadano colombiano realice transacciones. por favor presente su documento de identidad
	_50091("50091"),//50091: Tipo de documento de usuario tramitador remitente no valido para realizar la transaccion
	_50092("50092"),//50092: El Remitente tramitador no tiene configurado Pais de Expediciï¿½n en el Documento
	_50093("50093"),//50093: El Remitente tramitador no puede realizar operaciones en esta Oficina
	_50094("50094"),//50094: La fecha de Vencimiento es obligatoria para el documento del Remitente tramitador
	_50095("50095"),//50095: El Remitente tramitador no tiene configurado Pais de Expedicion en el Documento
	_50096("50096"),//50096: El Remitente tramitador no tiene configurado Fecha de Entrada al Pais
	_50097("50097"),//50097: Fecha de nacimiento errada para el tipo de documento
	_50098("50098"),//50098: La fecha de Nacimiento debe ser inferior a la fecha actual
	_50099("50099"),//50099: La fecha de nacimiento debe ser inferior a la fecha de expedicion
	_50100("50100"),//50100: La fecha de nacimiento debe ser inferior a la fecha de entrada al pais
	_50101("50101"),//50101: La fecha de nacimiento debe ser inferior a la fecha de Vencimiento
	_50102("50102"),//50102: La fecha de expedicion debe ser inferior o igual a la fecha actual
	_50103("50103"),//50103: La fecha de expedicion debe ser inferior o igual a la fecha de entrada al pais
	_50104("50104"),//50104: La fecha de expedicion debe ser inferior o igual a la fecha de Vencimiento
	_50105("50105"),//50105: La fecha de entrada al pais debe ser inferior o igual a la fecha actual
	_50106("50106"),//50106: La fecha de entrada al pais debe ser inferior o igual a la fecha de Vencimiento
	_50107("50107"),//50107: El tercero beneficiario con tipo de documento Pasaporte (PA). No puede realizar transacciones despues de {1} dias de entrar al pais
	_50108("50108"),//50108: Formato de impresion [{1} - {2}] no encontrado
	_50109("50109"),//50109: Formato de impresion no configurado
	_50110("50110"),//50110: El sistema no logro encontrar el numero de referencia o pin ingresado.
	_50111("50111"),//50111: El tercero aliado nuevo, ya presenta una configuracion previa al proceso actual de duplicacion, en la cual ya relaciona el tipo de contabilidad seleccionada
	_50112("50112"),//50112: No se crearon registros en tipos comprobantes, asi como tampoco en cuentas por conceptos (general)
	_50113("50113"),//50113: El tercero aliado nuevo ya presenta una configuracion previa al proceso actual de duplicacion, en la cual ya relaciona una configuracion de distribucion de conceptos que se cruza e interviene con el proceso de duplicacion propuesto por el tercero aliado base
	_50114("50114"),//50114: El tercero aliado nuevo ya presenta una configuracion previa al proceso actual de duplicacion, en la cual ya relaciona una configuracion de distribucion de terceros que se cruza e interviene con el proceso de duplicacion propuesto por el tercero aliado base
	_50115("50115"),//50115: El tercero aliado nuevo ya presenta una configuracion previa al proceso actual de duplicacion, en la cual ya relaciona una configuracion de diferencial, que se cruza e interviene con el proceso de duplicacion propuesto por el tercero aliado base
	_50116("50116"),//50116: El tercero aliado nuevo ya presenta una configuracion previa al proceso actual de duplicacion, en la cual ya relaciona una configuracion de contabilidad, que se cruza e interviene con el proceso de duplicacion propuesto por el tercero aliado base
	_50117("50117"),//50117: No se puede actualizar el campo Nombre del tercero con identificacion {1}
	_50118("50118"),//50118: No se puede actualizar el campo Apellido1 del tercero con identificacion {1}
	_50119("50119"),//50119: No se puede actualizar el campo Apellido2 del tercero con identificacion {1}
	_50120("50120"),//50120: No se puede actualizar el campo TipoTercero del tercero con identificacion {1}
	_50121("50121"),//50121: No se puede actualizar el campo TipoPersona del tercero con identificacion {1}
	_50122("50122"),//50122: El giro con Referencia Externa {1} ya fue pagado
	_50123("50123"),//50123: No existen datos de {1} 
	_50124("50124"),//50124: La Informaciï¿½n {1} 
	_50126("50126"),//50126: Tiempo de espera por transaccion superado reintente de nuevo
	_50127("50127"),//50127: El Id de la transaccion ya ha sido utilizado
	_50128("50128"),//50128: El usuario no es valido para realizar la operacion de creacion
	_50129("50129"),//50129: El usuario no es valido para realizar la operacion de consulta
	_50130("50130"),//50130: Direccion de correo electronico no valida
	_50131("50131"),//50131: El valor del campo pin excede el limite aceptado
	_50132("50132"),//50132: El campo runt excede el limite aceptado
	_50133("50133"),//50133: El valor del campo telefono no es un numero valido
	_50134("50134"),//50134: El campo numero de documento excede el limite aceptado
	_50135("50135"),//50135: El campo numero de referencia excede el limite aceptado
	_50136("50136"),//50136: El valor del campo email excede el limite aceptado
	_50137("50137"),//50137: El numero de telefono no es de tipo numerico
	_50138("50138"),//50138: El codigo runt no es de tipo numerico
	_50139("50139"),//50139: El numero de PIN no es de tipo numerico
	_50140("50140"),//50140: El numero de celular no corresponde a operadores vigentes
	_50141("50141"),//50141: El campo estado no se encuentra dentro de los parametros
	_50142("50142"),//50142: El valor del PIN no es valido o no es de tipo numerico
	_50143("50143"),//50143: El campo documento no se encuentra dentro de los parametros
	_50144("50144"),//50144: El tipo documento no esta dentro de los parametros
	_50145("50145"),//50145: No existe un socket de salida activo para el convenio
	_50146("50146"),//50146: El tercero beneficiario pertenece a un convenio y debe ser pagado desde la agencia principal
	_50147("50147"),//50147: El tercero beneficiario pertenece a un convenio y no es posible realizar este tipo de autorizacion
	_50148("50148"),//50148:  El Tercero no esta exonerado en listas de desmovilizados para el pago de un giro
	_50149("50149"),//50149: No se permite pago tercero bloqueado LN
	_50150("50150"),//50150: El tipo de documento o numero de documento son incorrectos por favor verifique sus datos.
	_50151("50151"),//50151: El tipo de documento del usuario no es correcto
	_50152("50152"),//50152: El tipo de documento del remitente no es correcto
	_50153("50153"),//50153: El numero documento del remitente no es correcto
	_50154("50154"),//50154: El tercero remitente no tiene asociado esa referencia control
	_50155("50155"),//50155: El valor del giro no coincide con el pagado
	_50156("50156"),//50156: La estructura de datos es incorrecta para la trama {1} 
	_50157("50157"),//50157: El codigo runt ingresado o la referencia control son incorrectas
	_50158("50158"),//50158: Opcion no valida para tercero beneficiario de tipo convenio
	_50159("50159"),//50159: Opcion no valida para tercero convenio {1}
	_50160("50160"),//50160: No existe la referencia control en ENVISIOL
	_50161("50161"),//50161: Estado para pagar Giro convenio no Valido. Validar estado Pago Giro Masivo Convenio - Convenio Nombre Corto {1}
	_50162("50162"),//50162: El giro de un Convenio solo puede ser pagado por un usuario Administrativo
	_50163("50163"),//50163: El usuario pertenece a una agencia diferente a donde se puede pagar el convenio
	_50164("50164"),//50164: El giro con referencia {1} no se encuentra en un estado valido
	_50165("50165"),//50165: El proceso historico no existe
	_50166("50166"),//50166: La fecha de corte no puede ser mayor a la fecha actual
	_50167("50167"),//50167: El estado para generar el proceso historico debe ser ESPERA
	_50168("50168"),//50168: La entidad {1} no se encuentra relacionada al proceso historico y tiene relacion con TRANSACCIONES_X_DOCUMENTOS
	_50169("50169"),//50169: La fecha de inicio no puede ser mayor a la fecha fin
	_50170("50170"),//50170: La fecha de corte no puede ser inferior a {1}
	_50171("50171"),//50171: La hora de inicio de ejecucion del proceso historico debe ser mayor a {1}
	_50172("50172"),//50172: La hora de fin de ejecucion del proceso historico debe ser menor a {1}
	_50173("50173"),//50173: Historico {1}
	_50175("50175"),//50175: No es posible asignar el nuevo password, {1}
	_50176("50176"),//50176: No es posible autorizar la solicitud con el pin {1} por la agencia {2}
	_50177("50177"),//50177: El usuario es administrador y valor del token de la caja debe ser -1
	_50178("50178"),//50178: No existe una solicitud para autorizar con esta informacion
	_50179("50179"),//50179: No existe una solicitud para rechazar con esta informacion
	_50180("50180"),//50180: El valor del dato {1} no es de tipo numerico
	_60001("60001"),//60001: El login {1} ya existe, intente nuevamente
	_60002("60002"),//60002: El usuario {1} no puede ser modificado, tipo de usuario es {2}.
	_60003("60003"),//60003: El codigo de estado enviado para el usuario no es valido
	_60004("60004"),//60004: El parametro {1} no se encuentra parametrizado en el sistema
	_60005("60005"),//60005: El tipo de usuario no esta permitido para registrar la caja
	_60006("60006"),//60006: El usuario {1} no se encuentra asociado a la agencia {2} 
	_60007("60007"),//60007: El campo {1} no puede ser actualizado por el tercero identificado con {2}
	_60008("60008"),//60008: La agencia {1} no se encuentra relacionada con el Tercero propietario {2}
	_60009("60009"),//60009: El tercero con identificacion {1} ya tiene asociado un usuario en el sistema 
	_60010("60010"),//60010: El dato {1} contiene caracteres especiales.
	_60011("60011"),//60011: El dato {1} se encuentra vacio.
	_60012("60012"),//60012: La longitud para el dato {1} no es valido, dato demasiado extenso
	_60013("60013"),//60013: El Colaborado con identificacion {1} no tiene permisos para modificar el campo o columna {2} de la tabla {3}
	_60014("60014"),//60014: La Caja {1} no se encuentra asociada a la agencia
	_60015("60015"),//60015: El codigo de estado y la descripcion de esatdo son inconsistentes
	_60016("60016"),//60016: El tipo de docuemtno para el tercero asociado al usaurio cajero no es valido
	_60017("60017"),//60017: La estructura para el token de seguridad que comprende la trama no es valido.
	_60018("60018"),//60018: El tercero {1} se encuentra bloqueado
	_60019("60019"),//60019: El tipo de tercero no es permitido para asociar a un usuario cajero colaborador
	_60020("60020"),//60020: Valor para token {1} inavalido
	_60021("60021"),//60021: El usuario {1} no tiene una agencia valida asociada
	_60022("60022"),//60022: El formato de la fecha debe ser DD/MM/YYYY.
	_60023("60023"),//60023: Formato de impresion no valido para {1}.
	_60024("60024"),//60024: Los conceptos soportados para la oprracion de colaboradores debe ser 1 o 2.
	_60025("60025"),//60025: Solo es posible reestablecer la contrasena a usuarios adminitradores
	_60026("60026"),//60026: Los tipos de constantes deben ser 1 o 2
	_60027("60027"),//60027: El usuario {1} no se encuentra asociado al tercero propietario.
	_60028("60028"),//60028: La operacion inusual es invalida, el valor para el token de operacion inusual debe ser *
	_60029("60029"),//60029: Promocion invalida para tercero colaborador, el valor para el token de promocion debe ser * 
	_60030("60030"),//60030: La identificacion del tercero para cambio de solicitud no es correcta 
	_60031("60031"),//60031: El valor para tipo de identificacion e identificacion en la solicitud de anulacion deben ser -1
	_60032("60032"),//60032: El estado de la caja {1} no se encuentra activo
	_60033("60033"),//60033: El usuario {1} no se encuentra en la agencia asignada
	_60038("60038"),//60038: El usuario {1} no se encuentra asociado al tercero
	_60039("60039"),//60039: El Tipo de Dato para el parametro del sistema {1} Debe ser Numerico
	_60040("60040"),//60040: El tercero debe ser mayor a {1} anios para enviar un giro
	_60041("60041"),//60041: El valor del token {1} se encuentra vacio
	_60042("60042"),//60042: La longitud minima para crear la identificacion de un tercero es de {1} caracteres
	_60043("60043"),//60043: Los conceptos soportados para la operacion de colaboradores debe ser 33 o 34.
	_60044("60044"),//60044: El giro no puede ser consultado o pagado en este municipio
	_60045("60045"),//60045: El Id de transaccion {1} no existe para el colaborador o hay problemas con su informacion
	_60046("60046"),//60046: El tercero propietario con identificacion {1} no existe
	_60047("60047"),//60047: El Tercero tramitador debe ser mayor a {1} anios para enviar un giro
	_60048("60048"),//60048: La transaccion {1} no existe para el colaborador o hay problemas con su informacion
	_60049("60049"),//60049: No existen transacciones para el dia {1} con los datos suministrados
	_60050("60050"),//60050: El dato {1} debe ser mayor a 0
	_60051("60051"),//60051: El codigo PINESACTI de la entidad CONFPIAC No existe
	_60053("60053"),//60053: No existe Hora Final para la entidad CONFPIAC
	_60054("60054"),//60054: No existe Fecha Inicio proceso para la entidad CONFPIAC
	_60055("60055"),//60055: No existe Fecha Final para la entidad CONFPIAC
	_60058("60058"),//60058: El tipo de datos debe ser numerico para la hora Final de la entidad CONFPIAC
	_60059("60059"),//60059: La hora Final de la entidad CONFPIAC debe estar en el rango de las 000000 y las 235959 HORAS
	_60060("60060"),//60060: El tercero origen NO corresponde a COLOMBIA MAYOR
	_60061("60061"),//60061: No existe una propiedad registrada con el codigo {1}
	_60062("60062"),//60062: Existen valores de propiedades no validados
	_60063("60063"),//60063: Esta operacion solo es valida para transacciones 100% en efectivo
	_60064("60064"),//60064: El documento inicial no coincide para realizar esta operacion
	_60065("60065"),//60065: El campo: {1} recibido en la trama no corresponde con el formato esperado. Valor recibido [{2}]
	_60066("60066"),//60066: El Estado Pendiente para pago de este convenio debe ser el ID {1}
	_60067("60067"),//60067: El pin debe haber sido pagado de manera mixta
	_60068("60068"),//60068: El pin debe pertenecer a un recaudo
	_60069("60069"),//60069: Los conceptos soportados para la operacion de colaboradores debe ser {1} o {2}
	_60070("60070"),//60070: La agencia por la que se quiere pagar no es permitida para este convenio
	_60071("60071"),//60071: Transaccion no permitida el convenio esta configurado como {1} 
	_60072("60072"),//60072: El estado de pago del convenio no puede ser pendiente
	_60073("60073"),//60073: La suma de los valores ingresados de conceptos no concuerdan con el valor total de los medios de pago
	_60074("60074"),//60074: No existe un filtro de consulta valido, por favor verifique
	_60075("60075"),//60075: Error de filtro de consulta por {1}
	_60076("60076"),//60076: El valor suministrado no coincide con el de la transaccion
	_60077("60077"),//60077: No fue posible registrar la huella ya existe en el sistema Por favor comunï¿½quese con Super Giros
	_60078("60078"),//60078: El Formato de la fecha debe ser {1}
	_60079("60079"),//60079: No se debe enviar clave ya que no se solicita codigo de Seguridad
	_60080("60080"),//60080: La clave del codigo de seguridad debe esta entre {1}
	_60081("60081"),//60081: Solo se permiten los siguientes valores para el paremetro {1}
	_60082("60082"),//60082: El dato {1} contiene espacios o caracteres especiales
	_60083("60083"),//60083: El Formato de encriptacion del token de seguridad no es valido
	_60084("60084"),//60084: Solo se permiten los siguientes datos para {1}
	_60085("60085"),//60085: El Mensaje de Texto para el pin {1} no se puede reenviar ya que el giro no tiene codigo de seguridad Automatico
	_60086("60086"),//60086: Solo se permiten reenvio de mensaje de texto para pines activos
	_60087("60087"),//60087: Usuario supero la cantidad de reenvios permitidos
	_60088("60088"),//60088: La Funcionalidad de envios de mensaje de texto se encuentra inactiva [PECOMETE]
	_60089("60089"),//60089: La Funcionalidad de Token a Nivel General se encuentra inactiva [PETOSEGE]
	_60090("60090"),//60090: El pin {1} no tiene clave de seguridad asociada
	_60091("60091"),//60091: Se bloquea PIN {1}
	_60092("60092"),//60092: Es necesario que el Tercero convenio este configurado en en fomulario GACO
	_60093("60093"),//60093: El Tercero Colaborador Id {1}
	_60094("60094"),//60094: Es necesario que el Tercero convenio id {1},este configurado en en fomulario GACO
	_60095("60095"),//60095: El codigo grupo contabilidad para SuperCombo no existe en FORMA [GRCC]
	_60096("60096"),//60096: El codigo grupo contabilidad distribuccion conceptos no tiene vigencia asignada
	_60099("60099"),//60099: los Codigos de conceptos permitidos para convenios son {1}
	_60100("60100"),//60100: El Codigo del medio de pago {1} no es permitido para recaudo convenio
	_60101("60101"),//60101: El tipo de documento {1}
	_60102("60102"),//60102: La Identificacion {1}
	_60103("60103"),//60103: El password enviado {1}
	_60104("60104"),//60104: El tercero enviado {1}
	_60105("60105"),//60105: El usuario {1} no tiene asociado turno
	_60106("60106"),//60106: El codigo RUNT enviado para la consulta no pertenece al recaudo o no existe en el sistema
	_60107("60107"),//60107: La agencia no tiene configurado ningun Codigo Externo (RUNT), comuniquese con SuperGiros
	_60108("60108"),//60108: El Convenio ingresado no existe para el Pin consultado
	_60109("60109"),//60109: No existe un tercero con el ID del Convenio, verifique e intente de nuevo
	_60110("60110"),//60110: El Convenio ingresado es diferente al convenio registrado para el Pin consultado
	_60111("60111"),//60111: El tipo de documento ingresado NO tiene configurada una equivalencia en la forma administrativa EQCO.
	_60112("60112"),//60112: El Parametro {1}
	_60113("60113"),//60113: El Numero Celular {1}
	_60114("60114"),//60114: No se genero envï¿½o de mensaje de texto
	_60115("60115"),//60115: El estado del Documento debe ser PENDIENTE {1}
	_60116("60116"),//60116: El convenio {1}
	_60117("60117"),//60117: El Codigo {1}
	_60118("60118"),//60118: Revisar [MOREAGCO] no existe modulo en forma [USRM] - Modulos
	_60119("60119"),//60119: El usuario NO tiene configurado el ROL para usar el Modulo de recaudo agil, informe a su administrador
	_60120("60120"),//60120: El convenio configurado para la caja NO existe por favor valide en la forma administrativa [CCCA]
	_60121("60121"),//60121: El Tercero convenio NO existe como tercero comuniquese con su administrador
	_60122("60122"),//60122: La caja no tiene configuracion de recaudo agil, valide con su administrador
	_60123("60123"),//60123: El convenio NO esta configurado como recaudo valide la configuracion de la forma administrativa [CFCV] para este convenio
	_60124("60124"),//60124: El convenio se encuentra en estado INACTIVO y no se puede continuar por favor valide con su administrador, 
	_60125("60125"),//60125: La Sede desde la cual esta ingresando se encuetra en estado INACTIVO y no se puede continuar por favor valide con su administrador
	_60126("60126"),//60126: La Sede desde la cual esta ingresando NO existe y no se puede continuar por favor valide con su administrador en la forma administrativo [SECO]
	_60127("60127"),//60127: El detalle para el convenio se encuentra en estado INACTIVO y no se puede continuar por favor informe a su administrador
	_60128("60128"),//60128: La fecha inicial de la consulta es muy antigua segun la configuracion del parametro del sistema [RAFECORE] valide e intente de nuevo
	_60129("60129"),//60129: No se han recibido datos para la reimpresion del convenio verifique e intente de nuevo
	_60130("60130"),//60130: El beneficiario del recaudo para este convenio es la sede pero no existen sedes configuradas para el convenio por favor valide la configuracion de la forma [CFCV] para este convenio
	_60131("60131"),//60131: No se encontro un valor configurado para el plan tarifario del convenio verifique la configuracion de la forma [CFCV] para este convenio
	_60132("60132"),//60132: El tercero Origen no puede ser igual al tercero Destino
	_60133("60133"),//60133: El documento {1}
	_60134("60134"),//60134: El concepto {1}
	_60135("60135"),//60135: El tercero {1}
	_60136("60136"),//60136: El tercero propietario de la sede NO esta activo y no se puede continuar valide con su administrador
	_60137("60137"),//60137: El tercero Convenio NO esta activo y no se puede continuar valide con su administrador
	_60138("60138"),//60138: El plan tarifario para la sede del convenio se encuentra vencido valide la configuracion para este convenio en la forma [CFCV]
	_60139("60139"),//60139: La caja {1}
	_60140("60140"),//60140: La Agencia {1}
	_60141("60141"),//60141: El Usuario {1}
	_60142("60142"),//60142: ERROR INSERTANDO {1}
	_60143("60143"),//60143: La solicitud {1}
	_60144("60144"),//60144: No existe una configuracion de plan tarifario por propiedades convenio con codigo {1} en la forma administrativa [FOTP]
	_60145("60145"),//60145: No existe detalle convenio configurado para la combinacion {1}
	_60146("60146"),//60146: El estado del documento debe ser PENDIENTE o CONFIRMADO OPERATIVAMENTE para ejecutar esta operaciï¿½n.
	_60147("60147"),//60147: El valor ingresado para la propiedad {1} no es valido
	_60148("60148"),//60148: El pin {1} no se encuentra registrado en la entidad CONVPINE
	_60149("60149"),//60149: No se permite realizar el proceso de anulacion verificar el tiempo configurado al convenio {1} en la forma [CFCV]
	_60150("60150"),//60150: El tiempo limite para permitir anulacion de recaudo del convenio {1} ha vencido no es posible anular el recaudo {2}
	_60151("60151"),//60151: El convenio {1} no se encuentra habilitado para permitir el proceso de anulacion verificar forma [CFCV]
	_60153("60153"),//60153: La configuracion en la forma [GACO] {1}
	_60154("60154"),//60154: Verificar las propiedades y/o su obligatoriedad para el convenio {1} con relacion a las propiedades de la formulacion {2}
	_60155("60155"),//60155: La formulacion de tarifa recaudo {1} contiene errores de sintaxis por favor verificar FORMA [FOTP]
	_60156("60156"),//60156: La estructura del registro esta incompleta revise los datos importados en la forma [COIM]
	_60157("60157"),//60157: No se encontro una equivalencia configurada para PIN {1}
	_60158("60158"),//60158: Revisar [{1}] no existe, o se encuentra mal configurado en forma [{2}]
	_60159("60159"),//60159: Operacion no permitida para [{1}]
	_60160("60160"),//60160: El valor formulado con codigo {1} excede el monto maximo permitido por favor verificar forma administrativa [FOTP] 
	_60161("60161"),//60161: No se encontro una configuracion de DATO ENTIDAD {1}
	_60162("60162"),//60162: El PIN {1} no tiene configuracion de pago a tercero apoderado
	_60163("60163"),//60163: NO se puede realizar el pago del giro porque la cantidad de pagos con poder ha llegado al maximo permitido segun la forma [CTRA] para el remitente {1}
	_60164("60164"),//60164: No existe configuracion de tercero con id {1} asociado a proceso cartera revisar forma administrativa con codigo [PRCT] 
	_60165("60165"),//60165: El proceso cartera con codigo {1} no existe
	_60166("60166"),//60166: El concepto con codigo {1} para la agencia con codigo {2} contiene asociado mas de un documento
	_60167("60167"),//60167: El concepto con codigo {1} no tiene configurado documento en la agencia con codigo {2} por favor verificar la Forma [DOCU]
	_60168("60168"),//60168: La cantidad de datos para el token [infoTercero] no es correcta verificar estructura {id|tipoId|Identificacion}
	_60169("60169"),//60169: El IdTercero no corresponde al TipoIdentificacion y numero de identificacion enviados en token [infoTercero]
	_60170("60170"),//60170: El token de [infoTercero] no contiene datos validos para efectuar la consulta de tercero
	_60171("60171"),//60171: El tercero Colaborador {1} no tiene opciones de biometria configuradas en la Forma [BICA] valide e intente de nuevo
	_60172("60172"),//60172: La caja con codigo {1} no tiene opciones de biometria configuradas en la Forma [BICA] valide e intente de nuevo
	_60173("60173"),//60173: La configuracion biometrica de la caja con codigo {1} en la Forma [BICA] es incorrecta valide e intente de nuevo 
	_60174("60174"),//60174: La estructura de la trama [467] para la solcitud de la operacion [ENVIO HUELLA ISO] no es correcta comuniquese con el administrador del sistema
	_60175("60175"),//60175: El tipo de huella recibido en la trama [467] no es correcto valide e intente de nuevo de lo contrario comuniquese con el administrador del sistema
	_60176("60176"),//60176: El tercero NO pudo ser enrolado dado que {1}
	_60177("60177"),//60177: La huella ISO solicitada {1}
	_60178("60178"),//60178: La transaccion que esta solicitando no puede realizarse dado que la caja con codigo {1} no tiene configuracion de biometria local valide e intente de nuevo
	_60179("60179"),//60179: SUPERTOKEN: [{1}] No se puede realizar con Token {2} por favor revisar la configuracion en la Forma [TOCO] para el tercero con ID: {3}
	_60180("60180"),//60180: No hay comunicacion con el SOCKET BIOMETRIA por TimeOut o desconexion
	_60181("60181"),//60181: No existen pines de registraduria disponibles por favor cargar nuevamente
	_60182("60182"),//60182: Pin de registraduria se encuentra en uso por favor intente nuevamente
	_60183("60183"),//60183: El pin {1} ya se encuentrado registrado en {2}
	_60184("60184"),//60184: El convenio con ID {1} no tiene permitido realizar la reimpresion.
	_60185("60185"),//60185: La Trama {1}
	_60186("60186"),//60186: SUPERTOKEN: [{1}] No se puede realizar sin Token por favor revisar la configuracion en la Forma [TOCO] para el tercero con ID: {2}
	_60187("60187"),//60187: La clave del codigo de seguridad no se pudo generar por favor revisar en la Forma [PASI] el valor de los parametros del sistema [RAINCLSE] y [RAFICLSE]
	_60188("60188"),//60188: Hora no permitida para la Trama [493] realizar consulta del tercero en el Web Service por favor revisar la configuracion en la Forma [TRIN] para el colaborador con Identificacion: {1} 
	_60194("60194"),//60194: El Rango {1}
	_60195("60195"),//60195: La Propiedad {1}
	_60196("60196"),//60196: El concepto enviado para FNSV debe ser el codigo {1} 
	_60197("60197"),//60197: El valor del concepto FNSV debe ser mayor a cero
	_60198("60198"),//60198: El modelo {1} del vehiculo no se encuentra dentro del rango establecido en la entidad [RAMOVEHI] para impuesto FNSV
	_60199("60199"),//60199: El valor {1} 
	_60200("60200"),//60200: El pin {1} no tiene autorizaciones pendientes para anular
	_60201("60201"),//60201: Se requiere activar biometria general central para realizar enrolamiento local por favor revisar configuracion en la Forma [ACBI]
	_60202("60202"),//60202: Actualmente hay problemas de conexion o timeout con AFIS sin servicio para realizar enrolamiento por favor comunicarse con el administrador del sistema
	_91109("91109"),//91109: ERROR INTERNO: Falla al inicio de la aplicaciï¿½n. consulte su DBA
	_91110("91110"),//91110: ERROR INTERNO: No se encuentra el archivo
	_91111("91111"),//91111: ERROR INTERNO: Falla al inicio del sistema de ventanas. consulte su DBA
	_91112("91112"),//91112: ERROR INTERNO: Falla al inicio del manejador de arranque. consulte su DBA
	_91113("91113"),//91113: ERROR INTERNO: No se puede obtener el nombre del archivo de recursos. consulte su DBA
	_91115("91115"),//91115: ERROR INTERNO: Falla en la tabla. consulte su DBA
	_91116("91116"),//91116: ERROR INTERNO: Falla al inicio de Oracle*Image. consulte su DBA
	_91117("91117"),//91117: ERROR INTERNO: Falla al inicio de la medida del tipo de letra. consulte su DBA
	_91118("91118"),//91118: ERROR INTERNO: Falla al inicio de la ventana. consulte su DBA
	_91119("91119"),//91119: ERROR INTERNO: Falla al inicio de Oracle*VGS. consulte su DBA
	_91120("91120"),//91120: El usuario ha expirado su fecha limite (Fecha Final) para interactuar con el sistema
	_91121("91121"),//91121: El modulo al que intenta acceder no se encuentra configurado en el sistema.
	_91122("91122"),//91122: El usuario no tiene asignado los permisos para acceder a este modulo
	_99993("99993"),//99993: El socket de entrada del convenio no esta activo
	_99994("99994"),//99994: El socket de salida del convenio no esta activo
	_60285("60285"),//El pin referencia consultado se encuentra bloqueado, comuníquese con el Administrador. Revisar en forma [PRAD].
	_60286("60286"),//El parametro IDROLBTR no se encuentra parametrizado  o bien configurado en la Forma [PASI]
	_60287("60287"),//El parametro IDDAENLB no se encuentra parametrizado  o bien configurado en la Forma [PASI]
	_60288("60288"),//El parametro IDSERVBT no se encuentra parametrizado  o bien configurado en la Forma [PASI]
	_60289("60289"),//'Por favor valide la configuración correspondiente para el servicio bloqueo transaccion [IDSERVBT]
	_60290("60290"),//por favor verifique el valor configurado para el parametro [IDDAENLB]
	_60291("60291"),//por favor verifique el valor configurado para el parametro [IDSERVBT]
	_60292("60292"),//El parametro de sistema [IDDAENBL] no existe o se encuentra mal configurado.
	_60293("60293"),//por favor verifique el valor configurado para el parametro [IDDAENBL]
	
	;
	
	private String codigo;
	
	private String strDescripcion;
	
	private String tipo;
	
	/**
    * @variable: bandera que representa si una constante de enumerador ya fue 
    * 			 procesada, con el objetivo de controlar y evitar un alto consumo 
    * 			 innecesario 
    **/
	private boolean booProcesado;
	
	/**
	 * ****************************************************************.
     * @param etiqueta: etiqueta y/o identificador de propiedad
     * @metodo: EnumCodigosMensaje (Constructor)
     * @strDescripcion: Constructor que ejecuta la inicializacion de valores y ejecucion de 
	 * 				 comportamientos inicales requeridos para la materializacion de las 
	 * 				 constantes de enumerador
     * @autor: Hector Q-en-K
     * ****************************************************************
     */
	private EnumCodigosMensaje(String codigo){
		
		this.codigo=codigo;
		this.booProcesado=false;
		
	}
	
	/**
	 * ****************************************************************.
     * @metodo: validaProcesado
     * @strDescripcion: Metodo que valida si la constante de enumerador ya 
     * 				 fue procesada, de no ser asi, solicita cargar sus 
     * 				 valores funcionales adicionales 
     * @autor: Hector Q-en-K
     * ****************************************************************
     */
	private void validaProcesado(){
		
		if(!this.booProcesado){
			this.cargar();
			this.booProcesado=true;
		}
	}
	
	/**
	 * ****************************************************************.
     * @metodo: cargar
     * @strDescripcion: Metodo que solicita el cargue del valor de la 
     * 				 propiedad asociada a la etiqueta 
     * @autor: Hector Q-en-K
     * ****************************************************************
     */
	private void cargar(){
		
		String parametros[];
		
		try{
			
			parametros = EnumRecursosProperties.MENSAJES.getRsbRecurso().getString(this.codigo).split("\\|\\|");
		
			this.tipo = parametros[0];
			this.strDescripcion = parametros[1];
			
		}catch(Exception e){
			this.strDescripcion=null;
			this.tipo = "APP";
		}
		
	}
	
	public static Mensaje obtenerMensajePersonalizado(EnumClasesMensaje pEnmClaseMensaje,
												   	  String pStrCodigo,
												   	  String pStrDescripcion,
												   	  String ... pArrStrParametros)throws Exception{
		
		EnumCodigosMensaje enmCodigoMensajePersonalizado = EnumCodigosMensaje.MENSAJE_PERSONALIZADO;
		
		enmCodigoMensajePersonalizado.setCodigo(pStrCodigo);
		enmCodigoMensajePersonalizado.setStrDescripcion(pStrDescripcion);
		
		return ControladorMensajes.getInstance().obtenerMensaje(pEnmClaseMensaje,
																pStrCodigo,
																pStrDescripcion,
																pArrStrParametros);		
	}
	
	public static FormaMensajeAlerta desplegarMensajePersonalizado(Window pWinVentana,
			   													   EnumClasesMensaje pEnmClaseMensaje,
			   													   String pStrCodigo,
			   													   String pStrDescripcion,
			   													   String ... pArrStrParametros)throws Exception{
		Mensaje objMensaje;
		
		objMensaje = EnumCodigosMensaje.obtenerMensajePersonalizado(pEnmClaseMensaje, 
																    pStrCodigo, 
																    pStrDescripcion, 
																    pArrStrParametros);
		return objMensaje.desplegarMensaje(pWinVentana);
	}
	
	public static Exception generarExcepcionPersonalizada(EnumClasesMensaje pEnmClaseMensaje,
													 	  String pStrCodigo,
													 	  String pStrDescripcion,
													 	  String ... pArrStrParametros)throws Exception{
		Mensaje objMensaje;
		
		objMensaje = EnumCodigosMensaje.obtenerMensajePersonalizado(pEnmClaseMensaje, 
				  												    pStrCodigo, 
				  												    pStrDescripcion, 
				  												    pArrStrParametros);
		return new ClientePosSlimGirosException(objMensaje);
	}
	
	public Mensaje obtenerMensaje(EnumClasesMensaje pEnmClaseMensaje,
			  					  String ... pArrStrParametros)throws Exception{

		return ControladorMensajes.getInstance().obtenerMensaje(pEnmClaseMensaje,
																this.codigo,
																pArrStrParametros);
	}
	
	public FormaMensajeAlerta desplegarMensaje(Window pWinVentana,
											   EnumClasesMensaje pEnmClaseMensaje,
											   String ... pArrStrParametros)throws Exception{
		Mensaje objMensaje;
		
		this.validaProcesado();
		
		objMensaje = this.obtenerMensaje(pEnmClaseMensaje,
										 pArrStrParametros);
		
		return objMensaje.desplegarMensaje(pWinVentana);
	}
	
	public Exception generarExcepcion(EnumClasesMensaje pEnmClaseMensaje,
								 	  String ... pArrStrParametros)throws Exception{
		
		Mensaje objMensaje;
		
		objMensaje = this.obtenerMensaje(pEnmClaseMensaje, 
				   						 pArrStrParametros);
		
		return new ClientePosSlimGirosException(objMensaje);
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getStrDescripcion() {
		this.validaProcesado();
		return strDescripcion;
	}

	public void setStrDescripcion(String pStrDescripcion) {
		this.strDescripcion = pStrDescripcion;
	}

	public String getTipo() {
		this.validaProcesado();
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public EnumCodigosMensaje validarMensaje(String pStrCodigo,
										     String pStrDescripcion,
										     String ...pArrStrParametros){
		
		EnumCodigosMensaje enmCodigoMensaje;
		
		try{
			
			enmCodigoMensaje = EnumCodigosMensaje.valueOf("_"+pStrCodigo.trim());
			
		}catch(Exception e){
			
			enmCodigoMensaje = EnumCodigosMensaje.NO_DOCUMENTADO;
			enmCodigoMensaje.setCodigo(pStrCodigo);
		}
		
		return enmCodigoMensaje;
	}
	
	
}

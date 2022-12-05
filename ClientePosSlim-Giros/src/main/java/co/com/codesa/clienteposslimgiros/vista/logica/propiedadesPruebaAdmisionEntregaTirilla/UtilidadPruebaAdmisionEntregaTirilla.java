package co.com.codesa.clienteposslimgiros.vista.logica.propiedadesPruebaAdmisionEntregaTirilla;

import java.util.StringTokenizer;

import co.com.codesa.clienteposslimexception.exceptions.ClientePosSlimGirosException;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.enumeraciones.operaciones.EnumTiposOperaciones;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.pruebaadmisionentregatirilla.FormaPropiedadesAdmisionEntregaTirilla;
import co.com.codesa.clienteposslimgiros.utilidades.mensajes.Mensaje;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.clienteposslimgiros.vista.logica.ControlConsultaPasiVistaLogica;
import co.com.codesa.codesawrapper.modelo.dominio.ParametroSistema;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.PruebaCRCAdmisionEntrega;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.pruebacrcadmisionentrega.PruebaCRC;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;

/**
 * 
 * ********************************************************************
 * 
 * @class UtilidadTransmisionTirillas Singleton encargado de la gestion del
 *        proceso de transmision tirillas
 * @author dsalazar[PlayTech]
 * @date 15-feb-2019
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 *            *********
 *            ************************************************************
 */
public class UtilidadPruebaAdmisionEntregaTirilla {

	/**
	 * @variable instance Referencia estatica de la clase utilitaria, clave para
	 *           incorporar SINGLETON (patron de diseno)
	 **/
	private static UtilidadPruebaAdmisionEntregaTirilla instance;

	
	
	/**
	 * @propiedad String constante que almacena la descripcion del tipo 
	 *                   de prueba de admision o entrega de tirilla 
	 **/
	private static String ETIQUETA_PRUEBA_CRC = "PRUEBA_ADMISION_ENTREGA_TIRILLA";

	/**
	 * ********************************************************************
	 * 
	 * @method UtilidadTransmisionTirillas Metodo constructor que permite
	 *         inicializar variables y ejecutar comportamientos de interes
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author dsalazar[PlayTech]
	 * @date 15-feb-2019
	 *       ********************************************************
	 *       ************
	 */
	private UtilidadPruebaAdmisionEntregaTirilla() throws Exception {

	}

	/**
	 * ********************************************************************
	 * 
	 * @method getInstancia Metodo clave para ejecutar el patron singleton sobre
	 *         la clase, materializando esta por unica vez y manteniendo una
	 *         sola instancia de esta
	 * @return UtilidadTransmisionTirillas Tipo referente a la misma clase
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author dsalazar[PlayTech]
	 * @date 15-feb-2019
	 *       ********************************************************
	 *       ************
	 */
	public static UtilidadPruebaAdmisionEntregaTirilla getInstancia()
			throws Exception {

		if (instance == null) {

			instance = new UtilidadPruebaAdmisionEntregaTirilla();
		}

		return instance;
	}

	/**
	 * 
	 * ********************************************************************
	 * 
	 * @method realizarPreguntaPruebaAdmisionEnvioTirilla Se encarga de validar
	 *         si se debe presentar la pantalla de Admision o Envio de tirilla
	 *         de giros postal
	 * @return Variable booleana indicando si se realiza la pregunta al tercero
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author dsalazar[PlayTech]
	 * @date 19-feb-2019
	 *       ********************************************************
	 *       *************
	 */
	public PruebaCRC  realizarPreguntaPruebaAdmisionEnvioTirilla(
			FormaGenerica pFrmGnrVentana, Usuario pObjUsuario,
			Tercero pTercero, PruebaCRCAdmisionEntrega pobjPruebaCRC, EnumTiposOperaciones pEnmTipoOperacion)
			throws Exception {
		boolean booRealizarPregunta = false;
		PruebaCRC objPruebaCRC = new PruebaCRC();
		String strFormatoPrueba;
		String strFormatoFisica;
		ParametroSistema psPASI;
		try {
			booRealizarPregunta = this.validarServicioAdmisionEntregaTirilla(
					pTercero, pEnmTipoOperacion);

			if (booRealizarPregunta) {
				/*UtilParametrosSistema.getInstance().consultar(
                        EnumParametrosSistema.ID_PASI_PRUEBA_CRC_CODIGO_ADMSION_ENTREGA);*/
				//Se obtiene informacion de prueba de formato electronico
				FormaPropiedadesAdmisionEntregaTirilla objFrmPropAdmEntTirilla;
				objFrmPropAdmEntTirilla = new FormaPropiedadesAdmisionEntregaTirilla(
						pFrmGnrVentana, true, pObjUsuario, pobjPruebaCRC,
						pTercero, true,pEnmTipoOperacion);                  
				/*psPASI = UtilParametrosSistema.getInstance().consultar(
						EnumParametrosSistema.ID_PRUEBA_EN_FORMATO_ELECTRONICO);
				strFormatoPrueba = psPASI.getValor();*/
				strFormatoPrueba = ControlConsultaPasiVistaLogica.getInstance().getCodcrcel();
				objPruebaCRC.setStrRespuesta(objFrmPropAdmEntTirilla
						.getStrRespuetaCRC());
				//Validar si en la cadena retornada existe la propiedad 
				//FISICA como seleccionada 
				if (objFrmPropAdmEntTirilla!=null &&
						objFrmPropAdmEntTirilla.getStrRespuetaCRC()!=null &&	
						objFrmPropAdmEntTirilla.getStrRespuetaCRC().contains( 
						"FISICA")
						|| objFrmPropAdmEntTirilla
								.getStrRespuetaCRC()
								.contains(
										UtilParametrosSistema
												.getInstance()
												.consultar(
														EnumParametrosSistema.ID_PRUEBA_EN_FORMATO_FISICO)
												.getValor())) {
					/*psPASI = UtilParametrosSistema.getInstance().consultar(
							EnumParametrosSistema.ID_PRUEBA_EN_FORMATO_FISICO);
					strFormatoPrueba = psPASI.getValor(); */
					strFormatoPrueba = ControlConsultaPasiVistaLogica.getInstance().getCodcrcpr();
					objPruebaCRC.setStrTipo(strFormatoPrueba);
				}
				objPruebaCRC.setStrTipo(strFormatoPrueba);	
				
			} else {
				
				boolean booRespuesta = true;
				
				/*booRespuesta = EnumParametrosSistema.ACTIVA_SERVICIO_PRUEBA_ADMISIONENTREGA_TIRILLA
						.obtenerValorBooleano("S"); */
				
				booRespuesta = ControlConsultaPasiVistaLogica.getInstance().getSercotir();
				
				if (booRespuesta && booRealizarPregunta) {
					
					//Se obtiene informacion de prueba de formato fisico TIRILLA
					psPASI = UtilParametrosSistema.getInstance().consultar(
							EnumParametrosSistema.ID_PRUEBA_EN_FORMATO_FISICO);
					strFormatoFisica = psPASI.getValor();
				
					objPruebaCRC.setStrTipo(strFormatoFisica);
					
					//Construyendo evidencia fisica
					/*psPASI = UtilParametrosSistema.getInstance().consultar(
							EnumParametrosSistema.ID_PASI_PRUEBA_CRC_CODIGO_ADMSION_ENTREGA);
					strFormatoPrueba = psPASI.getValor();*/
					strFormatoPrueba = ControlConsultaPasiVistaLogica.getInstance().getCodcrcpc();
					objPruebaCRC.setStrRespuesta(strFormatoPrueba
							+ EnumGeneralidadesTramasGiros.PIPE.getValor()
						    +  ETIQUETA_PRUEBA_CRC
						    + EnumGeneralidadesTramasGiros.PIPE.getValor()
							+ strFormatoFisica
							+ EnumGeneralidadesTramasGiros.VIGURILLA.getValor());
				
				} else {
					
					objPruebaCRC.setStrTipo(EnumGeneralidadesTramasGiros.ASTERISCO.getValor());
					objPruebaCRC.setStrRespuesta(EnumGeneralidadesTramasGiros.ASTERISCO.getValor());
					
				}
				
			}
		} catch (Exception e) {
			if (e instanceof ClientePosSlimGirosException) {
				Mensaje objMensaje = (Mensaje) ((ClientePosSlimGirosException) e)
						.getObjMensaje();
				if (objMensaje.getCodigo().equals(
						EnumMensajes.TERCERO_NO_EXISTE.getCodigo())) {
					booRealizarPregunta = true;
				} else {
					throw e;
				}
			}
		}
		return objPruebaCRC;
	}

	/**
	 * 
	 * ********************************************************************
	 * 
	 * @method validarTipoDocumentoPermitido Metodo encargado de validar si el
	 *         tipo de documento del tercero recibido como parametro es valido
	 *         para realizar proceso de Persona Politicamente Expuesta
	 * @param pObjTercero
	 *            Tercero cliente al cual se le debe realizar la pregunta de
	 *            Persona Politicamente Expuesta
	 * @return Variable boolean que indica si el tipo de documento es valido
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author dsalazar[PlayTech]
	 * @date 21-feb-2019
	 *       *********************************************************
	 *       ************
	 */
	public boolean validarTipoDocumentoPermitido(Tercero pObjTercero)
			throws Exception {

		boolean booTipoDocumentoPermitido = false;

		UtilParametrosSistema.getInstance().consultar(
				EnumParametrosSistema.TIPOS_DOCUMENTO_PERMITIDOS_PEPS);

		String strTiposDocumento = EnumParametrosSistema.TIPOS_DOCUMENTO_PERMITIDOS_PEPS
				.obtenerValorCadena();

		StringTokenizer stkTiposDocumento = new StringTokenizer(
				strTiposDocumento, EnumGeneralidadesTramasGiros.PIPE.getValor());

		while (stkTiposDocumento.hasMoreElements()) {
			String strElemento = stkTiposDocumento.nextToken();
			if (strElemento.equalsIgnoreCase(String.valueOf(pObjTercero
					.getTipoIdentificacion().getId()))) {
				return true;
			}
		}

		return booTipoDocumentoPermitido;

	}

	/**
	 * 
	 * ********************************************************************
	 * 
	 * @method validarServicioTerceroPeps Metodo encargado de validar si el
	 *         servicio de transmision de tirllas se encuentra activo
	 * @return Booleano indicando si se encuentra activo o inactivo el servicio
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author dsalazar[PlayTech]
	 * @date 15-feb-2019
	 *       ********************************************************
	 *       *************
	 */
	private boolean validarServicioAdmisionEntregaTirilla(Tercero pObjTercero,
			EnumTiposOperaciones pEnmTipoOperacion) throws Exception {
		boolean booRespuesta;
		// Consulta si el servicio esta activo
		/*UtilParametrosSistema
				.getInstance()
				.consultar(
						EnumParametrosSistema.ACTIVA_SERVICIO_PRUEBA_ADMISIONENTREGA_TIRILLA);*/
		// Consulta si existe el parametro de tercero tipo no tercero para el
		// convenio
		/*UtilParametrosSistema
				.getInstance()
				.consultar(
						EnumParametrosSistema.TIPO_ID_IDENTIFICACION_TERCERO_PRUEBA_ADMISIONENTREGA_TIRILLA);*/
		// Consulta si existe el parametro de terceros excluidos remitentes
		/*UtilParametrosSistema.getInstance().consultar(
				EnumParametrosSistema.ID_TERCERO_EXCLUIDOS_REMITENTES);		*/
		// Consulta si existe el parametro de terceros excluidos beneficiarios
		/*UtilParametrosSistema.getInstance().consultar(
				EnumParametrosSistema.ID_TERCERO_EXCLUIDOS_BENEFICIARIOS);*/
		/*booRespuesta = EnumParametrosSistema.ACTIVA_SERVICIO_PRUEBA_ADMISIONENTREGA_TIRILLA
				.obtenerValorBooleano("S");*/
		booRespuesta = ControlConsultaPasiVistaLogica.getInstance().getSercotir();
		
		String strTerceroExcluido = "";
		StringTokenizer stkTiposDocumento;
		String strElemento;
		String infoTercero; //contiene informacion de tipo idtipo|numeroidentificacion
		boolean encontrExcluido = false;
		if (booRespuesta) {
			// Valide si hay exclusion del tercero
			if (pEnmTipoOperacion == EnumTiposOperaciones.ENVIO_FACTURACION_GIRO) {
				/*strTerceroExcluido = EnumParametrosSistema.ID_TERCERO_EXCLUIDOS_REMITENTES
						.obtenerValorCadena();*/
				strTerceroExcluido = ControlConsultaPasiVistaLogica.getInstance().getIdremexc();
				
			} else if (pEnmTipoOperacion == EnumTiposOperaciones.PAGO_FACTURACION_GIRO
					|| pEnmTipoOperacion == EnumTiposOperaciones.PAGO_FACTURACION_GIRO_EXTERNO) {
				/*strTerceroExcluido = EnumParametrosSistema.ID_TERCERO_EXCLUIDOS_BENEFICIARIOS
						.obtenerValorCadena();*/
				strTerceroExcluido = ControlConsultaPasiVistaLogica.getInstance().getIdbenexc();
				
			} else if (pEnmTipoOperacion == EnumTiposOperaciones.SOLICITUD_CAMBIO_BENEFICIARIO) {
				/*strTerceroExcluido = EnumParametrosSistema.ID_TERCERO_EXCLUIDOS_BENEFICIARIOS
						.obtenerValorCadena();*/
				strTerceroExcluido = ControlConsultaPasiVistaLogica.getInstance().getIdbenexc();
				
			}
			//Se INICIA asumiendo que NO esta excluido. Debe entonces presentar pantalla prueba
			//Admision entrega de tirilla 
			encontrExcluido = true; 
			if (strTerceroExcluido != null && !strTerceroExcluido.isEmpty()) {
				stkTiposDocumento = new StringTokenizer(strTerceroExcluido,
						EnumGeneralidadesTramasGiros.PUNTO_Y_COMA.getValor());

				while (stkTiposDocumento.hasMoreElements()) {
					strElemento = stkTiposDocumento.nextToken();
					infoTercero = pObjTercero
							.getTipoIdentificacion().getId()
							+ EnumGeneralidadesTramasGiros.PIPE.getValor() 
							+pObjTercero.getIdentificacion();
					if (strElemento.equalsIgnoreCase(infoTercero)) {
						encontrExcluido = false; // Si esta excluido. NO debe
													// entonces presentar la
													// pantalla prueba admision
													// entrega
					}
				}
			}
			booRespuesta = encontrExcluido;
		} else {
			// El servicio esta deshabilitado. Tiene que imprimir fisico
			booRespuesta = false;
		}
		return booRespuesta;
	}

}

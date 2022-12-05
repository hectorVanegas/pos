package co.com.codesa.clienteposslimgiros.eventos.solicitud;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import co.com.codesa.clienteposslimexception.exceptions.ClientePosSlimGirosException;
import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.ServicioClaveSeguridadDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDocumentos;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumImpresiones;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumProductos;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.operaciones.EnumTiposOperaciones;
import co.com.codesa.clienteposslimgiros.enumeraciones.serviciosAdicionales.EnumServiciosAdicionales;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.autorizacion.FormaHistorialAutorizacion;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.mensajes.FormaMensajeAlerta;
import co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.SMSGiro.FormaPanelSMSGiro;
import co.com.codesa.clienteposslimgiros.formas.solicitud.FormaSolicitudAutorizacion;
import co.com.codesa.clienteposslimgiros.interfaces.serviciosAdicionales.claveSeguridad.IOperacionesClaveSeguridad;
import co.com.codesa.clienteposslimgiros.utilidades.biometria.UtilBiometria;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.utilidades.documentos.UtilDocumentos;
import co.com.codesa.clienteposslimgiros.utilidades.mensajes.Mensaje;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.clienteposslimgiros.utilidades.productos.UtilProductos;
import co.com.codesa.clienteposslimgiros.utilidades.serviciosAdicionales.SMSGiro.UtilSMSGiro;
import co.com.codesa.clienteposslimgiros.utilidades.validaciones.ValidacionesTercero;
import co.com.codesa.clienteposslimgiros.utilidades.xml.XmlDatosEntidades;
import co.com.codesa.clienteposslimgiros.vista.logica.ControlConsultaPasiVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.DatoEntidadVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.GiroVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.RecaudoVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.SolicitudVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.propiedadesPruebaAdmisionEntregaTirilla.UtilidadPruebaAdmisionEntregaTirilla;
import co.com.codesa.codesawrapper.modelo.dominio.ParametroSistema;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DatoEntidad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Giros;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Nota;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.PruebaCRCAdmisionEntrega;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.pruebacrcadmisionentrega.PruebaCRC;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 19-abr-2015 
 * @clase EventoFormaSolicitudAutorizacion
 * 		  Clase encargada de controlar los eventos de la forma de  
 * 		  solicitudes
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
/**
 * ****************************************************************. resumen:
 * 
 * Esta forma es la combinacion de las formas de solicitudes autorizaciones
 * transacciones y solicitudes de levantamiento, del aplicativo de Cliente Sims,
 * utilizado como referencia.
 * 
 * para lograr combinar estas dos opciones en una, se elaboraron las siguientes
 * estrategias:
 * 
 * implementacion de la trama 24 para ser lanzada (2 veces), por cada tipo de
 * solicitud (autorizacion y levantamiento), esto recupera dos listados de datos
 * entidades, los cuales se combinan manualmente en uno solo --> identificado
 * como listado de solicitudes consultadas.
 * 
 * se cruza este listado de solicitudes consultadas con respecto a la entidad
 * 'TIPOS DE SOLICITUDES', mapeada en el archivo de manejo interno de datos
 * entidades, la cual contiene los tipos de solicitudes implementados por la
 * aplicacion, creando un nuevo listado de tipo de solicitudes verificadas.
 * 
 * estas solicitudes verificadas, tienen un valor adicional configurado bajo el
 * item de <tipodato>, proporcionado por el archivo de mapeo interno, que hace
 * referencia a un codigo de entidad configurado quien contiene las anotaciones
 * y/o causales de solicitud, las cuales son obligatorias para seleccionar,
 * siempre y cuando exista un listado de causales, en caso de no tener un
 * listado, se permite realizar el proceso con respecto al item 'SELECCIONAR',
 * quien actuaria como 'SIN OBSERVACION'
 * 
 * y son estas solicitudes verificadas las disponibles para operar sobre la
 * forma
 * 
 * ****************************************************************.
 */
public class EventoFormaSolicitudAutorizacion extends EventoAbstracto {

	/**
	 * @variable objFacturaGiro objeto factura que referencia el giro consultado
	 *           para efectuar un proceso de solicitud
	 **/
	private FacturaGiro objFacturaGiro;

	/**
	 * @variable objFacturaGiroTmp objeto temporal de factura sincronizado
	 *           manual y estrategicamente con el objeto objFacturaGiro
	 **/
	private FacturaGiro objFacturaGiroTmp;

	/**
	 * @variable hmAnotacionesXSolicitud estructura de datos en memoria, para
	 *           almacenar las anotaciones consultadas por solicitud, con el fin
	 *           de validar primero en la estructura esta informacion antes de
	 *           realizar la peticion formal de consulta
	 **/
	private HashMap<String, List<DatoEntidad>> hmAnotacionesXSolicitud;

	/**
	 * @variable booAptoValidadoBiometria variable para validar si el tercero no
	 *           es apto biometricamente o se valido biometricamente
	 **/
	private boolean booAptoValidadoBiometria;

	/**
	 * @variable enmTipoOperacion Tipo de operacion que se esta llevando a cabo
	 */
	private EnumTiposOperaciones enmTipoOperacion;

	/**
	 * @variable operacionesClaveSeguridad interfaz de operaciones relacionadas
	 *           con el servicio de clave de seguridad
	 */
	private IOperacionesClaveSeguridad operacionesClaveSeguridad;

	/**
	 * @variable strCRCAdmisionEntregaTirilla objeto pruebacrc que contiene el
	 *           tipo [FISICO, ELECTRONICO ...] y datos multiregistro con el
	 *           formato IDPropiedad|DescripcionPropiedad|Respuesta1~ ...
	 *           proceso de venta
	 */
	private PruebaCRC objCRCAdmisionEntregaTirilla;

	/**
	 * ****************************************************************.
	 * 
	 * @method EventoFormaSolicitudAutorizacion Constructor que ejecuta la
	 *         inicializacion de valores y ejecucion de comportamientos inicales
	 *         requeridos para el despliegue de sus acciones
	 * @param pForma
	 *            referencia a la GUI de la cual se estan controlando los
	 *            eventos
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author Hector Q-en-K
	 *         ****************************************************************
	 */
	public EventoFormaSolicitudAutorizacion(FormaGenerica pForma)
			throws Exception {

		super(pForma);
		this.hmAnotacionesXSolicitud = new HashMap<String, List<DatoEntidad>>();
		this.booAptoValidadoBiometria = false;
	}

	@Override
	public void iniciarValores(Object... pArrObjParametrosForma)
			throws Exception {

		this.cargarFormulario();
		this.configuracionCampos();
	}

	@Override
	public void accionarVentanaDesplegada(WindowEvent pEvtWindowOpened)
			throws Exception {

		this.castFrmSolicitudes().getCmbListaSolicitudes().getLblObligatorio()
				.aplicarObligatoriedad(true);
		this.castFrmSolicitudes().getTxtReferencia().getLblObligatorio()
				.aplicarObligatoriedad(true);
		this.castFrmSolicitudes().getPnlTerceroNuevo().castEvaFrmTercero()
				.aplicarObligatoriedad(true);
		this.castFrmSolicitudes().getCmbListaAnotaciones().getLblObligatorio()
				.aplicarObligatoriedad(true);
	}

	@Override
	public void accionarCambioItem(Component pComponent,
			ItemEvent pEvtItemStateChanged) throws Exception {

		if (pComponent.equals(this.castFrmSolicitudes()
				.getCmbListaSolicitudes())) {

			this.seleccionarSolicitud();
		}
	}

	@Override
	public void accionarIngresoLiberado(Component pComponent,
			KeyEvent pEvtKeyReleased) throws Exception {

		if (pComponent.getName().equals(
				this.castFrmSolicitudes().getTxtReferencia().getName())) {

			if (this.objFacturaGiro != null) {

				if (!this.objFacturaGiro.getReferenciaControl().equals(
						this.castFrmSolicitudes().getTxtReferencia().getText())) {
					this.restablecerPantalla(true);
				}
			}
		}
	}

	@Override
	public void validaDatosAdicionales(JPanel pnlSeccionAdicional)
			throws Exception {
		if (pnlSeccionAdicional instanceof FormaPanelSMSGiro) {
			((FormaPanelSMSGiro) pnlSeccionAdicional).getEvaControlEventos()
					.ejecutar();
		}
	}

	@Override
	public void confirmar() throws Exception {

		this.validarOperacion();
	}

	@Override
	public void consultar() throws Exception {

		this.consultarGiroXReferencia();
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo cargarFormulario Metodo que se encarga de gestionar el cargue de
	 *         la informacion sobre el formulario
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private void cargarFormulario() throws Exception {

		this.castFrmSolicitudes().getPnlTerceroOrigen().castEvaFrmTercero()
				.setBooAplicaBiometria(true);
		this.cargarSolicitudes();
		this.cargarAgenciaPago();

		this.operacionesClaveSeguridad = this
				.castFrmSolicitudes()
				.getScpServiciosAdicionales()
				.getOperaciones()
				.adicionarServicio(EnumServiciosAdicionales.CLAVE_SEGURIDAD,
						"pnlClaveSeguridad");
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo configuracionCampos encargado de gestionar la configuracion
	 *         personalizada para los campos del formulario
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private void configuracionCampos() throws Exception {
		this.configuracionCamposTexto();
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo configuracionCamposTexto encargado de gestionar la configuracion
	 *         personalizada para los diferentes campos de texto del formulario
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private void configuracionCamposTexto() throws Exception {

		this.castFrmSolicitudes()
				.getTxtReferencia()
				.getPropiedades()
				.setControlFormatoIngreso(
						EnumExpresionesRegulares.EXP_REG_FORMATO_PIN_GIRO
								.getValor());

		this.castFrmSolicitudes()
				.getTxaNotaAdicional()
				.getPropiedades()
				.setControlFormatoIngreso(
						EnumExpresionesRegulares.EXP_REG_FORMATO_NOTAS
								.getValor());
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo cargarSolicitudes metodo que permite cargar los diferentes tipos
	 *         de solicitudes, tanto de autorizacion como de levantamiento
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private void cargarSolicitudes() throws Exception {

		List<DatoEntidad> lstSolicitudesConsultadas;
		List<DatoEntidad> objDatEntSolicitudesVerificadas;
		Object arrObjSolicitudesVerificadas[] = null;
		HashMap<String, DatoEntidad> hmSolicitudes;
		String strIdEntidad;
		
		/**
		 * @autor brayan.rojas
		 * @fecha 16/10/2019
		 *  variables para el nuevo tipo de solicitud 'SOLICITADO PARA BLOQUEO'
		 */
		String strTipoAutorizaBlo;
		String strValor;
		String idCausalBlo;

		strIdEntidad = EnumParametrosApp.ENT_TIPOS_SOLICITUDES_AUTORIZACIONES
				.getValorPropiedad();
		hmSolicitudes = XmlDatosEntidades.getInstance()
				.obtenerEntidad(strIdEntidad).getHmDatos();

		lstSolicitudesConsultadas = this.consultarSolicitudes();
 
		/**
		 * @autor brayan.rojas
		 * @metodo agregar la nueva autorizacion 'SOLICITADO PARA BLOQUEO' tk 465784
		 * @fecha 16/10/2019
		 */
		
		strTipoAutorizaBlo = UtilParametrosSistema.getInstance().
				consultar(EnumParametrosSistema.ID_DATENID_SOLICITADO_BLOQUEO).getValor();
		
		idCausalBlo = UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.ENT_CAUSAL_SOL_BLOQUEO).getValor();
		
		for (int i = 0; i < lstSolicitudesConsultadas.size(); i++) {
			if (lstSolicitudesConsultadas.get(i).toString().contains(strTipoAutorizaBlo)) {
				strValor = lstSolicitudesConsultadas.get(i).getValor();
				DatoEntidad daten = new DatoEntidad();
				daten.setId(strTipoAutorizaBlo);
				daten.setTipoDato(idCausalBlo);
				daten.setValor(strValor);
				hmSolicitudes.put(strTipoAutorizaBlo, daten);
			}	
		}
		
		objDatEntSolicitudesVerificadas = new ArrayList<DatoEntidad>();

		for (DatoEntidad objDatEntSolicitud : lstSolicitudesConsultadas) {

			if (hmSolicitudes.containsKey(objDatEntSolicitud.getId())) {
				objDatEntSolicitudesVerificadas.add(hmSolicitudes
						.get(objDatEntSolicitud.getId()));
			}/*
			 * else{ objDatEntSolicitudesVerificadas.add(objDatEntSolicitud); }
			 */
		}

		if (!objDatEntSolicitudesVerificadas.isEmpty()) {
			arrObjSolicitudesVerificadas = objDatEntSolicitudesVerificadas
					.toArray();
		}

		this.castFrmSolicitudes()
				.getCmbListaSolicitudes()
				.getPropiedades()
				.cargarCombo(arrObjSolicitudesVerificadas, true,
						EnumEtiquetas.LBL_NO_SELECCIONADO);
		this.seleccionarSolicitud();

	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo consultarSolicitudes metodo que permite consultar los tipos de
	 *         solicitudes tanto de autorizacion como de levantamiento y agrupar
	 *         ambos resultados bajo un mismo listado
	 * @return List<DatoEntidad> listado de solicitudes configuradas para
	 *         autorizacion y levantamiento
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private List<DatoEntidad> consultarSolicitudes() throws Exception {

		List<DatoEntidad> lstSolicitudesConsultadas;

		lstSolicitudesConsultadas = new ArrayList<DatoEntidad>();

		this.adicionarSolicitudesXTipo(
				EnumParametrosApp.TIPO_SOLICITUD_AUTORIZACION,
				lstSolicitudesConsultadas);

		this.adicionarSolicitudesXTipo(
				EnumParametrosApp.TIPO_SOLICITUD_LEVANTAMIENTO,
				lstSolicitudesConsultadas);

		return lstSolicitudesConsultadas;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo adicionarSolicitudesXTipo metodo que permite centralizar la
	 *         consulta de cualquier tipo de solicitud y sumarla a un unico
	 *         listado
	 * @param enmPapTipoSolicitud
	 *            constante de enumerador que representa el tipo de solicitud
	 *            sobre la cual se realizara la consulta y se integrara a un
	 *            unico listado
	 * @param pLstSolicitudesConsultadas
	 *            listado que representa los tipos de solicitudes recibidos del
	 *            proceso de consulta
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private void adicionarSolicitudesXTipo(
			EnumParametrosApp enmPapTipoSolicitud,
			List<DatoEntidad> pLstSolicitudesConsultadas) throws Exception {

		List<DatoEntidad> lstSolicitudes;

		lstSolicitudes = DatoEntidadVistaLogica.getInstance()
				.consultarConceptosEnDatoEntidad(super.getObjUsuario(),
						enmPapTipoSolicitud.getValorPropiedad());

		for (DatoEntidad objDatEntSolicitud : lstSolicitudes) {
			pLstSolicitudesConsultadas.add(objDatEntSolicitud);
		}
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo seleccionarSolicitud metodo que permite accionar las acciones
	 *         respectivas cuando es seleccionado un item del listado de
	 *         solicitudes
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private void seleccionarSolicitud() throws Exception {

		DatoEntidad objDatEntSolicitud = null;
		String strIdDatEntCambioBeneficiario;
		String strIdDatEntAnulacion;
		
		/**
		 * @autor brayan.rojas
		 * @fecha 16/10/2019
		 * variable para procesar solicitud de bloqueo pin.
		 */
		String strIdDatEntBloqueo;

		if (this.castFrmSolicitudes().getCmbListaSolicitudes()
				.getSelectedItem() instanceof DatoEntidad) {

			objDatEntSolicitud = (DatoEntidad) this.castFrmSolicitudes()
					.getCmbListaSolicitudes().getSelectedItem();

			strIdDatEntCambioBeneficiario = EnumParametrosApp.COD_DAT_ENT_TP_SOL_CAMBIO_BENEFICIARIO
					.getValorPropiedad();
			strIdDatEntAnulacion = EnumParametrosApp.COD_DAT_ENT_TP_SOL_ANULACION
					.getValorPropiedad();

			strIdDatEntBloqueo = UtilParametrosSistema.getInstance().
					consultar(EnumParametrosSistema.ID_DATENID_SOLICITADO_BLOQUEO).getValor();
			
			if (objDatEntSolicitud.getId()
					.equals(strIdDatEntCambioBeneficiario)) {// Solicitud de
																// cambio de
																// beneficiario
				this.castFrmSolicitudes().getPnlTerceroNuevo().setVisible(true);
				this.enmTipoOperacion = EnumTiposOperaciones.SOLICITUD_CAMBIO_BENEFICIARIO;
				this.castFrmSolicitudes()
						.getPnlTerceroOrigen()
						.castEvaFrmTercero()
						.setEnmTipoTransaccion(
								EnumTiposOperaciones.SOLICITUD_CAMBIO_BENEFICIARIO);
			} else {
				if (objDatEntSolicitud.getId().equals(strIdDatEntAnulacion)) {
					this.castFrmSolicitudes()
							.getPnlTerceroOrigen()
							.castEvaFrmTercero()
							.setEnmTipoTransaccion(
									EnumTiposOperaciones.SOLICITUD_ANULACION_GIRO);
				} else {
					this.castFrmSolicitudes()
							.getPnlTerceroOrigen()
							.castEvaFrmTercero()
							.setEnmTipoTransaccion(
									EnumTiposOperaciones.SOLICITUD);
				}

				this.castFrmSolicitudes().getPnlTerceroNuevo()
						.setVisible(false);
				this.enmTipoOperacion = EnumTiposOperaciones.SOLICITUD;
			}
			
			if (objDatEntSolicitud.getId().equals(strIdDatEntBloqueo)) {
				this.castFrmSolicitudes().getPnlTerceroNuevo().setVisible(false);
				this.enmTipoOperacion = EnumTiposOperaciones.SOLICITUD;
			}

		} else {
			this.castFrmSolicitudes().getPnlTerceroNuevo().setVisible(false);
		}

		this.cargarAnotaciones(objDatEntSolicitud);

		this.restablecerPantalla(true);
		this.objFacturaGiroTmp = null;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo cargarAnotaciones metodo que permite cargar las anotaciones o
	 *         mensajes predeterminados, propios por cada tipo de solicitud
	 *         seleccionada
	 * @param pObjDatEntSolicitud
	 *            objeto DatoEntidad que representa el tipo de solicitud
	 *            seleccionada del listado de solicitudes
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private void cargarAnotaciones(DatoEntidad pObjDatEntSolicitud)
			throws Exception {

		List<DatoEntidad> lstAnotaciones;
		Object arrAnotaciones[] = null;

		if (pObjDatEntSolicitud != null
				&& pObjDatEntSolicitud.getTipoDato() != null
				&& !pObjDatEntSolicitud.getTipoDato().trim().isEmpty()) {

			lstAnotaciones = this
					.consultarAnotacionesXSolicitud(pObjDatEntSolicitud);
			arrAnotaciones = lstAnotaciones.toArray();
		}

		this.castFrmSolicitudes().getCmbListaAnotaciones().getPropiedades()
				.cargarCombo(arrAnotaciones, true, null);// EnumEtiquetas.LBL_NO_SELECCIONADO
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo cargarAgenciaPago metodo que permite cargar la informacion
	 *         asociada a la agencia de pago (agencia a la cual pertenece el
	 *         usuario)
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private void cargarAgenciaPago() throws Exception {

		this.castFrmSolicitudes()
				.getPnlTerritorioAgenciaPago()
				.castEventosForma()
				.definirTerritorioBase(
						super.getObjUsuario().getAgencia().getTerritorio());
		this.castFrmSolicitudes().getPnlTerritorioAgenciaPago().getCmbAgencia()
				.addItem(super.getObjUsuario().getAgencia());
		this.castFrmSolicitudes().getPnlTerritorioAgenciaPago().getCmbAgencia()
				.setSelectedItem(super.getObjUsuario().getAgencia());
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo consultarAnotacionesXSolicitud metodo que permite verificar sobre
	 *         una estructura en memoria, las anotaciones refrentes al tipo de
	 *         solicitud seleccionada, en caso de no encontrarlas sobre la
	 *         estructura redirige a los procesos necesarios para realizar la
	 *         peticion de consulta cuyo resultado se escalara inmediatamente a
	 *         la estructura de memoria para un posterior interes de consulta
	 * @param pObjDatEntSolicitud
	 *            objeto DatoEntidad que representa el tipo de solicitud
	 *            seleccionada del listado de solicitudes
	 * @return List<DatoEntidad> Listado de anotaciones x tipo de solicitud
	 *         seleccionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private List<DatoEntidad> consultarAnotacionesXSolicitud(
			DatoEntidad pObjDatEntSolicitud) throws Exception {

		List<DatoEntidad> lstAnotaciones;

		if (this.hmAnotacionesXSolicitud.containsKey(pObjDatEntSolicitud
				.getId())) {
			lstAnotaciones = this.hmAnotacionesXSolicitud
					.get(pObjDatEntSolicitud.getId());
		} else {
			lstAnotaciones = DatoEntidadVistaLogica.getInstance()
					.consultarDatosPorEntidad(super.getObjUsuario(),
							pObjDatEntSolicitud.getTipoDato());
			this.hmAnotacionesXSolicitud.put(pObjDatEntSolicitud.getId(),
					lstAnotaciones);
		}

		return lstAnotaciones;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo validarOperacion metodo que permite validar la solicitud de
	 *         operacion completa, desde la previa consulta de un giro, la
	 *         validacion correspondiente del tipo de solicitud y la anotacion
	 *         seleccionada, asi como la deteccion del no ingreso de notas
	 *         adicionales y la confirmacion de la operacion frente al usuario
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private void validarOperacion() throws Exception {

		DatoEntidad objDatEntSolicitud;
		DatoEntidad objDatEntAnotacion;
		FormaMensajeAlerta frmAlerta;

		if (this.objFacturaGiro != null) {

			objDatEntAnotacion = this.validarAnotacion();
			objDatEntSolicitud = this.validarSolicitud();

			if (this.castFrmSolicitudes().getTxaNotaAdicional().getText()
					.trim().isEmpty()) {

				frmAlerta = EnumMensajes.NO_INGRESO_CAMPO_DESEA_INGRESAR
						.desplegarMensaje(super.getFrmForma(),
								EnumClasesMensaje.CONFIRMACION,
								EnumEtiquetas.TTL_SAT_PNL_NOTAS_ADICIONALES
										.toString());
				if (frmAlerta.isOpcion()) {// aceptar
					this.castFrmSolicitudes().getTxaNotaAdicional()
							.requestFocus();
					return;
				}
			}
			/*
			 * frmAlerta =
			 * EnumMensajes.CONFIRMACION_SOLICITUD_AUTORIZACION.desplegarMensaje
			 * (super.getFrmForma(), EnumClasesMensaje.CONFIRMACION,
			 * this.objFacturaGiro.getReferenciaControl(),
			 * objDatEntSolicitud.getValor()); if(frmAlerta.isOpcion()){
			 */
			this.realizarSolicitud(objDatEntSolicitud, objDatEntAnotacion);
			/*
			 * }else{ return; }
			 */

		} else {

			throw EnumMensajes.DEBE_REALIZAR_CONSULTA_PARA_OPERACION
					.generarExcepcion(EnumClasesMensaje.ERROR);
		}
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo validarAnotacion metodo que permite validar la anotacion o
	 *         mensaje predeterminado seleccionado. En caso que el tipo de
	 *         solicitud no tenga anotaciones configuradas, se permitira
	 *         considerar como apta la prensencia del valor 'SELECCIONAR', como
	 *         equivalente de 'SIN OBSERVACION', pero si la solicitud tiene al
	 *         menos una anotacion configurada, el usuario debera seleccionar el
	 *         tipo de anotacion que se ajuste al caso
	 * @return Anotacion anotacion seleccionada por el usuario
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private DatoEntidad validarAnotacion() throws Exception {

		DatoEntidad objDatEntAnotacion = null;

		if (this.castFrmSolicitudes().getCmbListaAnotaciones().getItemCount() > 1) {

			UtilComponentesGUI.getInstance().validarObligatoriedadCampo(
					this.castFrmSolicitudes().getCmbListaAnotaciones(),
					EnumEtiquetas.LBL_SAT_LISTA_ANOTACIONES.toString(), true,
					true);
		}

		if (this.castFrmSolicitudes().getCmbListaAnotaciones()
				.getSelectedItem() instanceof DatoEntidad) {
			objDatEntAnotacion = (DatoEntidad) this.castFrmSolicitudes()
					.getCmbListaAnotaciones().getSelectedItem();
		}

		return objDatEntAnotacion;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo validarSolicitud metodo que permite validar la solicitud
	 *         seleccionada, la cual es obligatoria para el proceso y debera ser
	 *         un valor apto de solicitud, no se acepta el valor 'SELECCIONAR'
	 * @return DatoEntidad solicitud seleccionada por el usuario
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private DatoEntidad validarSolicitud() throws Exception {

		DatoEntidad objDatEntSolicitud;

		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(
				this.castFrmSolicitudes().getCmbListaSolicitudes(),
				EnumEtiquetas.LBL_SAT_LISTA_SOLICITUDES.toString(), true, true);

		objDatEntSolicitud = (DatoEntidad) this.castFrmSolicitudes()
				.getCmbListaSolicitudes().getSelectedItem();

		return objDatEntSolicitud;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo realizarSolicitud metodo que permite realizar una solicitud de
	 *         autorizacion y/o levantamiento, dependiendo del tipo de solicitud
	 *         seleccionada
	 * @param pObjDatEntSolicitud
	 *            objeto DatoEntidad que representa el tipo de solicitud
	 *            seleccionada del listado de solicitudes
	 * @param pObjDatEntAnotacion
	 *            anotacion o mensaje predeterminado seleccionado
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private void realizarSolicitud(DatoEntidad pObjDatEntSolicitud,
			DatoEntidad pObjDatEntAnotacion) throws Exception {

		int intNumIntentosBiometria;
		String strValorAnotacion;
		Nota objNota;
		Mensaje objMensaje;
		String strPasiSolBloqueo;

		if (pObjDatEntAnotacion != null) {

			strValorAnotacion = pObjDatEntAnotacion.getValor();

		} else {

			strValorAnotacion = EnumEtiquetas.LBL_SIN_OBSERVACION.toString();
		}
		
		strPasiSolBloqueo = UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.ID_DATENID_SOLICITADO_BLOQUEO).getValor();
		
		objNota = (Nota) this.objFacturaGiro.getObjNota().clone();

		objNota.adicionarNota(strValorAnotacion, this.castFrmSolicitudes()
				.getTxaNotaAdicional().getText());
		
		
		// si solictiud es de bloqueo mandar nota sin informacion basura adicional.
		
		if (pObjDatEntSolicitud.getId().equals(strPasiSolBloqueo)) {
			
			this.objFacturaGiro.getObjNota().setStrDescripcion("");
			objNota.setStrDescripcion("");
			objNota.adicionarNota(strValorAnotacion, this.castFrmSolicitudes().getTxaNotaAdicional().getText());

		}

		UtilParametrosSistema.getInstance().consultar(
				EnumParametrosSistema.NUMERO_INTENTOS_AUTENTICACION_BIOMETRIA);
		intNumIntentosBiometria = EnumParametrosSistema.NUMERO_INTENTOS_AUTENTICACION_BIOMETRIA
				.obtenerValorEntero();
		do {
			try {
				intNumIntentosBiometria--;
				if (pObjDatEntSolicitud
						.getId()
						.equals(EnumParametrosApp.COD_DAT_ENT_TP_SOL_CAMBIO_BENEFICIARIO
								.getValorPropiedad())) {

					this.solicitarCambioBeneficiario(pObjDatEntSolicitud,
							objNota);

				} else {

					this.solicitarGenerico(pObjDatEntSolicitud, objNota);
				}
				break;
			} catch (ClientePosSlimGirosException cpge) {
				objMensaje = (Mensaje) cpge.getObjMensaje();

				if (objMensaje.getCodigo().equals(
						EnumMensajes.HUELLA_NO_CONICIDE_USUARIO.getCodigo())) {
					super.controlExcepcion(cpge);
				} else {
					throw cpge;
				}
			} catch (Exception e) {
				throw e;
			}
		} while (intNumIntentosBiometria > 0);

		if (intNumIntentosBiometria == 0) {
			this.restablecerPantalla(true);
		}

	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo solicitarCambioBeneficiario metodo encargado de realizar la
	 *         solicitud de cambio de beneficiario, cuando es gestionado su tipo
	 *         de solicitud, confirmado por parte del usuario, y validado
	 *         previamente por el sistema
	 * @param pObjDatEntSolicitud
	 *            tipo solicitud seleccionada, correspondiente al tipo de
	 *            solicitud de cambio de beneficiario
	 * @param pObjNota
	 *            Nota que se remitira sobre la operacion de solicitud y se
	 *            adicionara sobre la factura una vez se complete la operacion
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private void solicitarCambioBeneficiario(DatoEntidad pObjDatEntSolicitud,
			Nota pObjNota) throws Exception {

		Tercero objTerceroNuevo;
		boolean booImprimio;
		boolean blnImpresionFisicaTirilla = true;
		
		// se consume la trama 38 para recuperar el numero de factura, Ticket 489623 
		GiroVistaLogica.getInstance().consultarActualizacionGiroReferencia(super.getObjUsuario(), this.objFacturaGiro);

		this.objFacturaGiro.setTerceroOrigen(this.castFrmSolicitudes()
				.getPnlTerceroOrigen().castEvaFrmTercero().getObjTercero());
		this.objFacturaGiro.setTerceroDestino(this.castFrmSolicitudes()
				.getPnlTerceroDestino().castEvaFrmTercero().getObjTercero());

		objTerceroNuevo = this.castFrmSolicitudes().getPnlTerceroNuevo()
				.castEvaFrmTercero().getObjTercero();

		if (objTerceroNuevo != null) {

			if (objTerceroNuevo.toStringXDocumento().equals(
					this.objFacturaGiro.getTerceroDestino()
							.toStringXDocumento())) {

				this.castFrmSolicitudes().getPnlTerceroNuevo()
						.getTxtIdentificacion().requestFocus();

				throw EnumMensajes.TERCERO_BENEFICIARIO_NUEVO_IGUAL_DESTINO
						.generarExcepcion(EnumClasesMensaje.ERROR,
								objTerceroNuevo.getDescripcion(),
								objTerceroNuevo.toStringXDocumento(),
								this.objFacturaGiro.getTerceroDestino()
										.getDescripcion(), this.objFacturaGiro
										.getTerceroDestino()
										.toStringXDocumento());
			} else {

				if (ValidacionesTercero.getInstance().validacionesXTransaccion(
						objTerceroNuevo,
						EnumTiposOperaciones.ENVIO_FACTURACION, this,
						this.castFrmSolicitudes().getPnlTerceroNuevo())) {

					this.validarBiometria();

					if (this.booAptoValidadoBiometria) {

						if (this.validaVerificarClaveSegurida(objTerceroNuevo)) {

							UtilBiometria
									.getInstance()
									.registrarFirmaBiometricaBiometriaLocal(
											super.getObjUsuario(),
											this.objFacturaGiro,
											EnumTiposOperaciones.SOLICITUD_CAMBIO_BENEFICIARIO);

							UtilSMSGiro.getInstancia().validarSMSGiro(
									super.getFrmForma(), objTerceroNuevo,
									this.objFacturaGiro);

							// Imprimir la tirilla
							// Obtenga el valor definido en PASI como fisico
							/*ParametroSistema psPASI = UtilParametrosSistema
									.getInstance()
									.consultar(
											EnumParametrosSistema.ID_PRUEBA_EN_FORMATO_FISICO);
							String strFormatoFisico = psPASI.getValor();*/
							String strFormatoFisico = ControlConsultaPasiVistaLogica.getInstance().getCodcrcpr();

							/*
							 * if
							 * (this.objFacturaGiro.getTerceroTramitador()!=null
							 * ){ tercero =
							 * this.objFacturaGiro.getTerceroTramitador();
							 * }else{ tercero =
							 * this.objFacturaGiro.getTerceroOrigen();. }
							 */
							Tercero tercero;
							if (this.objFacturaGiro.getTerceroTramitador() != null) {
								tercero = this.objFacturaGiro.getTerceroTramitador();
							} else {
								tercero = this.objFacturaGiro.getTerceroOrigen();
							}

							PruebaCRCAdmisionEntrega pobjPruebaCRC = new PruebaCRCAdmisionEntrega();
							this.objCRCAdmisionEntregaTirilla = UtilidadPruebaAdmisionEntregaTirilla
									.getInstancia()
									.realizarPreguntaPruebaAdmisionEnvioTirilla(
											this.getFrmForma(),
											super.getObjUsuario(),
											tercero,
											pobjPruebaCRC,
											EnumTiposOperaciones.SOLICITUD_CAMBIO_BENEFICIARIO);

							if (this.objCRCAdmisionEntregaTirilla != null
									&& this.objCRCAdmisionEntregaTirilla
											.getStrRespuesta() != null
									&& this.objCRCAdmisionEntregaTirilla
											.getStrTipo() != null) {

								this.objFacturaGiro
										.setObjCRCMedioEntrega(objCRCAdmisionEntregaTirilla);
							}

							if (this.objCRCAdmisionEntregaTirilla != null
									&& this.objCRCAdmisionEntregaTirilla
											.getStrRespuesta() != null
									&& this.objCRCAdmisionEntregaTirilla
											.getStrTipo() != null
									&& !this.objCRCAdmisionEntregaTirilla
											.getStrTipo().equalsIgnoreCase(
													strFormatoFisico)
									&& !this.objCRCAdmisionEntregaTirilla
									.getStrTipo().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ASTERISCO.getValor()) ) {
								blnImpresionFisicaTirilla = false;
							}

							// Validar si obtuvo una respuesta por parte de la
							// prueba CRC
							if (this.objCRCAdmisionEntregaTirilla != null
									&& this.objCRCAdmisionEntregaTirilla
											.getStrRespuesta() != null
									&& this.objCRCAdmisionEntregaTirilla
											.getStrTipo() != null) {
								if (this.confirmarSolicitudAutorizacion(
										this.objFacturaGiro,
										pObjDatEntSolicitud)) {
									SolicitudVistaLogica
											.getInstance()
											.realizarSolicitudAutorizacion(
													super.getObjUsuario(),
													this.objFacturaGiro,
													objTerceroNuevo,
													pObjDatEntSolicitud,
													pObjNota,
													this.objCRCAdmisionEntregaTirilla
															.getStrRespuesta());
									// dsalazar[PlayTech]
									// Implementacion mejoras cliente:
									// 6-SuperVoucher(mensaje huella humeda)
									// 02-may-2018
									if (!this.objFacturaGiro.getTerceroOrigen()
											.getObjBiometria()
											.isBooValidadoBiometricamente()
											|| this.objFacturaGiro
													.getTerceroOrigen()
													.getObjBiometria()
													.gestionarObjFirmaBiometrica()
													.getStrId().equals("*")) {
										if (blnImpresionFisicaTirilla) {
											EnumMensajes.SOLICITAR_HUELLA_HUMEDA
													.desplegarMensaje(
															super.getFrmForma(),
															EnumClasesMensaje.INFORMACION);
										}
									}

									booImprimio = true;
									if (blnImpresionFisicaTirilla) {
										booImprimio = EnumImpresiones.CAMBIO_BENEFICIARIO
												.ejecutarImpresion(
														super.getFrmForma(),
														false,
														this.objFacturaGiro,
														objTerceroNuevo,
														super.getObjUsuario());
										
										
									}
									
									
									this.notificarOperacion(
											pObjDatEntSolicitud,
											booImprimio);
									
								}
							}
						}
					}
				}
			}
		} else {

			throw EnumMensajes.TERCERO_BENEFICIARIO_NUEVO_NO_DILIGENCIADO
					.generarExcepcion(EnumClasesMensaje.ERROR);
		}
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo confirmarSolicitudAutorizacion metodo encargado de realizar la
	 *         confirmacion para continuar con la operacion
	 * @param pObjFacturaGiro
	 *            Objeto factura giro que representa la transaccion
	 * @param pObjDatEntSolicitud
	 *            tipo solicitud seleccionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private boolean confirmarSolicitudAutorizacion(FacturaGiro pObjFacturaGiro,
			DatoEntidad pObjDatEntSolicitud) throws Exception {
		FormaMensajeAlerta frmAlerta;

		frmAlerta = EnumMensajes.CONFIRMACION_SOLICITUD_AUTORIZACION
				.desplegarMensaje(super.getFrmForma(),
						EnumClasesMensaje.CONFIRMACION,
						this.objFacturaGiro.getReferenciaControl(),
						pObjDatEntSolicitud.getValor());
		return frmAlerta.isOpcion();
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo validarBiometria metodo encargado de realizar la validacion de
	 *         biometria al tercero remitente, solo se obtiene la huella si
	 *         requiere biometria.
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Roberth Martinez Vargas
	 *        ****************************************************************
	 */
	private void validarBiometria() throws Exception {

		this.objFacturaGiro.getTerceroOrigen().getObjBiometria()
				.setBooValidadoBiometricamente(false);
		this.objFacturaGiro.getTerceroOrigen().getObjBiometria()
				.gestionarHuellaDerecha().setStrIso("");
		this.booAptoValidadoBiometria = ValidacionesTercero.getInstance()
				.validarBiometria(
						this.castFrmSolicitudes().getPnlTerceroOrigen());

	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo solicitarGenerico metodo encargado de realizar cualquiera de las
	 *         solicitudes, que no presentan datos especificos para adicionar al
	 *         proceso de solicitud
	 * @param pObjDatEntSolicitud
	 *            tipo solicitud seleccionada
	 * @param pObjNota
	 *            Nota que se remitira sobre la operacion de solicitud y se
	 *            adicionara sobre la factura una vez se complete la operacion
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private void solicitarGenerico(DatoEntidad pObjDatEntSolicitud,
			Nota pObjNota) throws Exception {
		EnumImpresiones enmImpresion = null;
		Object arrObjParametrosVariablesImpresion[] = null;
		Boolean booImprimio = null;
		boolean booRealizoSolicitud = false;

		try {

			if (pObjDatEntSolicitud.getId().equals(
					EnumParametrosApp.COD_DAT_ENT_TP_SOL_ANULACION
							.getValorPropiedad())) {

				if (UtilProductos.isProductoTipoEnum(
						this.objFacturaGiro.getProducto(), EnumProductos.GIRO)) {

					this.validarBiometria();

					if (this.booAptoValidadoBiometria) {

						UtilBiometria
								.getInstance()
								.registrarFirmaBiometricaBiometriaLocal(
										super.getObjUsuario(),
										this.objFacturaGiro,
										EnumTiposOperaciones.SOLICITUD_ANULACION_GIRO);

						if (this.confirmarSolicitudAutorizacion(
								this.objFacturaGiro, pObjDatEntSolicitud)) {
							SolicitudVistaLogica
									.getInstance()
									.realizarSolicitudAutorizacion(
											super.getObjUsuario(),
											this.objFacturaGiro, null,
											pObjDatEntSolicitud, pObjNota, null);
							enmImpresion = EnumImpresiones.ANULACION_GIRO;
							arrObjParametrosVariablesImpresion = new Object[] {
									this.objFacturaGiro, super.getObjUsuario() };

							GiroVistaLogica.getInstance()
									.consultarUltimaActualizacionGiro(
											super.getObjUsuario(),
											this.objFacturaGiro);

							// dsalazar[PlayTech]
							// Implementacion mejoras cliente:
							// 6-SuperVoucher(mensaje huella humeda)
							// 02-may-2018
							// if
							// (UtilProductos.isProductoTipoEnum(this.objFacturaGiro.getProducto(),
							// EnumProductos.GIRO))
							// {
							if (!this.objFacturaGiro.getTerceroOrigen()
									.getObjBiometria()
									.isBooValidadoBiometricamente()
									|| this.objFacturaGiro.getTerceroOrigen()
											.getObjBiometria()
											.gestionarObjFirmaBiometrica()
											.getStrId().equals("*")) {
								EnumMensajes.SOLICITAR_HUELLA_HUMEDA
										.desplegarMensaje(super.getFrmForma(),
												EnumClasesMensaje.INFORMACION);
							}
							// }

							booRealizoSolicitud = true;
						}
					}

				} else if (UtilProductos.isProductoTipoEnum(
						this.objFacturaGiro.getProducto(),
						EnumProductos.RECAUDO)) {

					if (this.confirmarSolicitudAutorizacion(
							this.objFacturaGiro, pObjDatEntSolicitud)) {
						RecaudoVistaLogica.getInstance()
								.realizarAnulacionRecaudo(this.objFacturaGiro,
										null, pObjDatEntSolicitud, pObjNota,
										super.getObjUsuario());
						enmImpresion = EnumImpresiones.ANULACION_RECAUDO;
						arrObjParametrosVariablesImpresion = new Object[] {
								this.objFacturaGiro, super.getObjUsuario() };
						booRealizoSolicitud = true;
					}
				}

				if (arrObjParametrosVariablesImpresion != null) {
					booImprimio = enmImpresion.ejecutarImpresion(
							super.getFrmForma(), false,
							arrObjParametrosVariablesImpresion);
				}

			} else {

				if (this.confirmarSolicitudAutorizacion(this.objFacturaGiro,
						pObjDatEntSolicitud)) {

					this.validarBiometria();

					SolicitudVistaLogica.getInstance()
							.realizarSolicitudAutorizacion(
									super.getObjUsuario(), this.objFacturaGiro,
									null, pObjDatEntSolicitud, pObjNota, null);
					booRealizoSolicitud = true;
				}
			}

			if (booRealizoSolicitud) {
				this.notificarOperacion(pObjDatEntSolicitud, booImprimio);
			}

		} catch (Exception e) {
			// this.restablecerPantalla(true);
			throw e;
		}
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo notificarOperacion metodo encargado de notificar la finalizacion
	 *         de la operacion, adicional de la notificacion, restablece los
	 *         controles graficos y logicos utilizados en la gestion de la
	 *         solicitud
	 * @param pObjDatEntSolicitud
	 *            tipo solicitud seleccionada
	 * @param pBooImpresion
	 *            bandera que permite identificar si el proceso realizado
	 *            comprendio un proceso de impresion y cual fue su resultado
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private void notificarOperacion(DatoEntidad pObjDatEntSolicitud,
			Boolean pBooImpresion) throws Exception {
		FormaMensajeAlerta frmMsgAlrOpcion;
		
		String strTipoAutorizaBlo;

		if (pBooImpresion != null && !pBooImpresion.booleanValue()) {
			EnumMensajes.OPERACION_REALIZADA_CORRECTAMENTE_IMPRESION_ERROR
					.desplegarMensaje(super.getFrmForma(),
							EnumClasesMensaje.ADVERTENCIA);
		}

		if (pObjDatEntSolicitud.getId().equals(
				EnumParametrosApp.COD_DAT_ENT_TP_SOL_ANULACION
						.getValorPropiedad())) {
			EnumMensajes.VERIFICAR_ESTADO_SOLICITUD_ANULACION.desplegarMensaje(
					super.getFrmForma(), EnumClasesMensaje.INFORMACION);
			this.redirigirHistorialAutorizaciones();

		}else {
			strTipoAutorizaBlo = UtilParametrosSistema.getInstance().
					consultar(EnumParametrosSistema.ID_DATENID_SOLICITADO_BLOQUEO).getValor();
			
			if (pObjDatEntSolicitud.getId().equals(strTipoAutorizaBlo)) {
				
				EnumMensajes.OPERACION_REALIZADA_CORRECTAMENTE.desplegarMensaje(super.getFrmForma(), 
						EnumClasesMensaje.INFORMACION);
				this.restablecerPantalla(false);
				super.cerrarForma();
				
			}else {

				frmMsgAlrOpcion = EnumMensajes.CONFIRMACION_ESTADO_SOLICITUD
						.desplegarMensaje(super.getFrmForma(),
								EnumClasesMensaje.CONFIRMACION);
				if (frmMsgAlrOpcion.isOpcion()) {
					this.redirigirHistorialAutorizaciones();

				} else {

					this.objFacturaGiroTmp = null;
					this.restablecerPantalla(false);
				}
			}
		}
				
	}

	/**
	 * ********************************************************************
	 * 
	 * @method redirigirHistorialAutorizaciones Metodo que permite redirigir el
	 *         proceso a la funcionalidad de historial autorizaciones
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author hector.cuenca
	 * @date 4/05/2017
	 *       **********************************************************
	 *       ***********
	 */
	private void redirigirHistorialAutorizaciones() throws Exception {
		Window frmVentana = this.cerrarForma();

		new FormaHistorialAutorizacion((JFrame) frmVentana, true,
				this.objFacturaGiro.getReferenciaControl());
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo consultarGiroXReferencia metodo encargado de consultar la
	 *         informacion detallada del giro a traves de su referencia. Ademas
	 *         presenta como comportamiento especial, previo a la peticion de
	 *         consulta, una verificacion sobre un objeto temporal de factura,
	 *         sincronizado con el objeto factura consultado exitosamente, para
	 *         en caso de ser la misma referencia consultada exitosamente con
	 *         anterioridad, recuperar la informacion del objeto temporal y no
	 *         realizar la peticion de consulta
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private void consultarGiroXReferencia() throws Exception {

		DatoEntidad objDatEntSolicitud;
		String strReferencia;
		String strTipoSeek;
		String strTipoGiro;
		String strProductoGiro;
		boolean validaZona;

		try {

			objDatEntSolicitud = this.validarSolicitud();
			strReferencia = this.validarReferencia();

			validaZona = false;
			strProductoGiro = "1";

			if (objDatEntSolicitud
					.getId()
					.equals(EnumParametrosApp.COD_DAT_ENT_TP_SOL_LEVANTAMIENTO_RESTRICCION
							.getValorPropiedad())
					|| objDatEntSolicitud
							.getId()
							.equals(EnumParametrosApp.COD_DAT_ENT_TP_SOL_LEVANTAMIENTO_REZAGO
									.getValorPropiedad())) {

				strTipoSeek = "3";
				strTipoGiro = "1";

			} else {// los demas tipos de solicitud

				strTipoSeek = "1";
				strTipoGiro = "2";
			}

			if (objFacturaGiroTmp != null
					&& objFacturaGiroTmp.getReferenciaControl().equals(
							strReferencia)) {

				this.objFacturaGiro = this.objFacturaGiroTmp;

			} else {

				this.objFacturaGiro = GiroVistaLogica.getInstance()
						.consultaGiroPorReferencia(super.getObjUsuario(),
								strReferencia, validaZona, strTipoSeek,
								strTipoGiro, strProductoGiro);
				if (!UtilDocumentos.isDocumentoTipoEnum(this.objFacturaGiro.getDocumento(), EnumDocumentos.FACTURA) &&
					!this.objFacturaGiro.getDocumento().getDescripcion().equals("FACTURACION VIRTUAL")) {
					throw EnumMensajes.NO_HAY_DATOS
							.generarExcepcion(EnumClasesMensaje.ERROR);
				}
				this.objFacturaGiroTmp = this.objFacturaGiro;
			}

			this.validarSolicitud(this.objFacturaGiro, objDatEntSolicitud);
			this.cargarFactura(this.objFacturaGiro);

		} catch (Exception e) {

			this.restablecerPantalla(true);
			throw e;
		}
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo validarReferencia metodo que permite validar la referencia
	 *         ingresada, la cual es obligatoria para para la operacion que se
	 *         esta intentando ejecutar, por ende generar una excepcion en caso
	 *         que el campo no este diligenciado
	 * @return String referencia del giro validada y recuperada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private String validarReferencia() throws Exception {

		String strReferencia;

		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(
				this.castFrmSolicitudes().getTxtReferencia(),
				EnumEtiquetas.LBL_SAT_REFERENCIA.toString(), true, true);

		strReferencia = this.castFrmSolicitudes().getTxtReferencia().getText();

		return strReferencia;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo validarSolicitud valida si la el estado de la refencia consultada
	 *         pertenece a la solicitud seleccionada
	 * @param pObjFacturaGiro
	 *            objeto factura previamente consultado que se cargara sobre la
	 *            forma
	 * @param pObjDatEntSolicitud
	 *            objeto
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Roberth Martinez Vargas
	 *        ****************************************************************
	 */
	private void validarSolicitud(FacturaGiro pObjFacturaGiro,
			DatoEntidad pObjDatEntSolicitud) throws Exception {

		if (pObjFacturaGiro
				.getEstado()
				.getId()
				.equals(EnumParametrosApp.COD_DAT_ENT_ESGI_REZAGO
						.getValorPropiedad())
				&& !pObjDatEntSolicitud
						.getId()
						.equals(EnumParametrosApp.COD_DAT_ENT_TP_SOL_LEVANTAMIENTO_REZAGO
								.getValorPropiedad())) {

			this.objFacturaGiro = null;
			throw EnumMensajes.SAU_SOL_AUT_REFERENCIA_NO_CORRESPONDE
					.generarExcepcion(EnumClasesMensaje.ERROR);

		} else if (pObjFacturaGiro
				.getEstado()
				.getId()
				.equals(EnumParametrosApp.COD_DAT_ENT_ESGI_NO_DISTRIBUIBLE
						.getValorPropiedad())
				&& !pObjDatEntSolicitud
						.getId()
						.equals(EnumParametrosApp.COD_DAT_ENT_TP_SOL_LEVANTAMIENTO_RESTRICCION
								.getValorPropiedad())) {

			this.objFacturaGiro = null;
			throw EnumMensajes.SAU_SOL_AUT_REFERENCIA_NO_CORRESPONDE
					.generarExcepcion(EnumClasesMensaje.ERROR);
		}
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo cargarFactura metodo que permite cargar un objeto factura
	 *         consultado, sobre los controles graficos de la forma
	 * @param pObjFacturaGiro
	 *            objeto factura previamente consultado que se cargara sobre la
	 *            forma
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	private void cargarFactura(FacturaGiro pObjFacturaGiro) throws Exception {

		Tercero objTerceroOrigen;
		Tercero objTerceroDestino;

		this.castFrmSolicitudes()
				.getPnlEncabezadoFactura()
				.getEvaFrmPnlFactura()
				.cargarPanel(pObjFacturaGiro.getProducto(),
						pObjFacturaGiro.getDocumento(),
						pObjFacturaGiro.getNumero());

		pObjFacturaGiro.setAgenciaPago(super.getObjUsuario().getAgencia());

		this.castFrmSolicitudes()
				.getPnlTerritorioAgenciaOrigen()
				.castEventosForma()
				.definirTerritorioBase(
						pObjFacturaGiro.getAgenciaOrigen().getTerritorio());
		this.castFrmSolicitudes().getPnlTerritorioAgenciaOrigen()
				.getCmbAgencia().addItem(pObjFacturaGiro.getAgenciaOrigen());
		this.castFrmSolicitudes().getPnlTerritorioAgenciaOrigen()
				.getCmbAgencia()
				.setSelectedItem(pObjFacturaGiro.getAgenciaOrigen());

		this.castFrmSolicitudes()
				.getPnlTerritorioAgenciaDestino()
				.castEventosForma()
				.definirTerritorioBase(
						pObjFacturaGiro.getAgenciaDestino().getTerritorio());
		this.castFrmSolicitudes().getPnlTerritorioAgenciaDestino()
				.getCmbAgencia().addItem(pObjFacturaGiro.getAgenciaDestino());
		this.castFrmSolicitudes().getPnlTerritorioAgenciaDestino()
				.getCmbAgencia()
				.setSelectedItem(pObjFacturaGiro.getAgenciaDestino());

		objTerceroOrigen = pObjFacturaGiro.getTerceroOrigen();
		this.castFrmSolicitudes()
				.getPnlTerceroOrigen()
				.castEvaFrmTercero()
				.forzarTercero(objTerceroOrigen.getTipoIdentificacion(),
						objTerceroOrigen.getIdentificacion());
		pObjFacturaGiro.setTerceroOrigen(this.castFrmSolicitudes()
				.getPnlTerceroOrigen().castEvaFrmTercero().getObjTercero());

		objTerceroDestino = pObjFacturaGiro.getTerceroDestino();
		this.castFrmSolicitudes()
				.getPnlTerceroDestino()
				.castEvaFrmTercero()
				.forzarTercero(objTerceroDestino.getTipoIdentificacion(),
						objTerceroDestino.getIdentificacion());
		pObjFacturaGiro.setTerceroDestino(this.castFrmSolicitudes()
				.getPnlTerceroDestino().castEvaFrmTercero().getObjTercero());

		this.castFrmSolicitudes().getTxaNotas()
				.setText(pObjFacturaGiro.getObjNota().toString());

		// Valida clave seguridad

		this.operacionesClaveSeguridad.validarEstadoServicio(
				this.objFacturaGiro, this.enmTipoOperacion, null);
	}

	/**
	 * ********************************************************************
	 * 
	 * @method validaVerificarClaveSegurida metodo para validar si tiene clave
	 *         de seguridad, y verifica la clave asignada.
	 * @param pObjTerceroNuevo
	 *            objeto tercero para el nuevo tercero en cambio de beneficiario
	 * @return boolean resultado de validacion
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 11/3/2016
	 *       **********************************************************
	 *       ***********
	 */
	private boolean validaVerificarClaveSegurida(Tercero pObjTerceroNuevo)
			throws Exception {

		boolean booVerificar;

		if (this.objFacturaGiro.getObjClaveSeguridad() == null) {

			booVerificar = true;
		} else {

			booVerificar = this.operacionesClaveSeguridad
					.validaEjecucionServicio(this.objFacturaGiro,
							this.enmTipoOperacion,
							new ServicioClaveSeguridadDTO(pObjTerceroNuevo));
			if (this.objFacturaGiro.getObjClaveSeguridad().isBooRevalidar()) {
				this.objFacturaGiroTmp = null;
				this.restablecerPantalla(false);
			}
		}

		return booVerificar;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @method restablecerPantalla metodo que permite restablecer o limpiar los
	 *         controles graficos y logicos de la forma
	 * @param pBooExcluirControlesParaDiligenciar
	 *            Bandera para identificar la exclusion de ciertos controles
	 *            graficos que no necesitan limpiarse
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author Hector Q-en-K
	 *         ****************************************************************
	 */
	private void restablecerPantalla(boolean pBooExcluirControlesParaDiligenciar)
			throws Exception {

		this.castFrmSolicitudes().getPnlEncabezadoFactura().limpiarForma();
		this.castFrmSolicitudes().getPnlTerritorioAgenciaOrigen()
				.castEventosForma().reestablecerFormaTerritorios();
		this.castFrmSolicitudes().getPnlTerritorioAgenciaDestino()
				.castEventosForma().reestablecerFormaTerritorios();
		this.castFrmSolicitudes().getPnlTerceroOrigen().castEvaFrmTercero()
				.restablecer(null);
		this.castFrmSolicitudes().getPnlTerceroDestino().castEvaFrmTercero()
				.restablecer(null);
		this.castFrmSolicitudes().getPnlTerceroNuevo().castEvaFrmTercero()
				.restablecer(null);
		this.castFrmSolicitudes().getTxaNotas().setText("");

		if (this.operacionesClaveSeguridad != null) {

			this.operacionesClaveSeguridad.restablecerEstadoServicio();
		}

		this.objFacturaGiro = null;

		if (!pBooExcluirControlesParaDiligenciar) {

			// this.castFrmSolicitudes().getPnlTerceroNuevo().setVisible(false);

			// if(!this.castFrmSolicitudes().getCmbListaSolicitudes().getSelectedItem().equals(EnumEtiquetas.LBL_NO_SELECCIONADO.getValor())){

			// UtilComponentesGUI.getInstance().restablecerComponentes(this.castFrmSolicitudes().getCmbListaSolicitudes());
			// }

			UtilComponentesGUI.getInstance().restablecerComponentes(
					this.castFrmSolicitudes().getCmbListaAnotaciones(),
					this.castFrmSolicitudes().getTxaNotaAdicional(),
					this.castFrmSolicitudes().getTxtReferencia());
		}
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo castFrmSolicitudes Metodo estandar para formatear el tipo de dato
	 *         general a un tipo especifico ("Casteo"), del atributo padre
	 *         frmForma
	 * @return FormaSolicitudAutorizacion valor especifico recuperado
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	public FormaSolicitudAutorizacion castFrmSolicitudes() throws Exception {
		return (FormaSolicitudAutorizacion) super.getFrmForma();
	}

	/**
	 * @method getEnmTipoOperacion Metodo get del atributo enmTipoOperacion
	 * @return EnumTiposOperaciones Valor del atributo enmTipoOperacion devuelto
	 * @author roberth.martinez
	 * @date 12/3/2016
	 */
	public EnumTiposOperaciones getEnmTipoOperacion() {
		return enmTipoOperacion;
	}

	/**
	 * @method setEnmTipoOperacion Metodo set del atributo enmTipoOperacion
	 * @param pEnmTipoOperacion
	 *            Valor que tomara el atributo enmTipoOperacion
	 * @author roberth.martinez
	 * @date 12/3/2016
	 */
	public void setEnmTipoOperacion(EnumTiposOperaciones pEnmTipoOperacion) {
		this.enmTipoOperacion = pEnmTipoOperacion;
	}

	/**
	 * @method getOperacionesClaveSeguridad Metodo get del atributo
	 *         operacionesClaveSeguridad
	 * @return IOperacionesClaveSeguridad Valor del atributo
	 *         operacionesClaveSeguridad devuelto
	 * @author roberth.martinez
	 * @date 23/3/2016
	 */
	public IOperacionesClaveSeguridad getOperacionesClaveSeguridad() {
		return operacionesClaveSeguridad;
	}

	/**
	 * @method setOperacionesClaveSeguridad Metodo set del atributo
	 *         operacionesClaveSeguridad
	 * @param pOperacionesClaveSeguridad
	 *            Valor que tomara el atributo operacionesClaveSeguridad
	 * @author roberth.martinez
	 * @date 23/3/2016
	 */
	public void setOperacionesClaveSeguridad(
			IOperacionesClaveSeguridad pOperacionesClaveSeguridad) {
		this.operacionesClaveSeguridad = pOperacionesClaveSeguridad;
	}

}

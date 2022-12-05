package co.com.codesa.clienteposslimgiros.formas.terceros;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import co.com.codesa.clienteposslimgiros.dto.direccion.ConfigDireccionDTO;
import co.com.codesa.clienteposslimgiros.dto.territorio.ConfigTerritorioDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.eventos.terceros.EventoFormaActualizarCrearTerceroInternacional;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.BotonUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaFechaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelDireccion;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelTerritorio;
import co.com.codesa.clienteposslimgiros.formas.operacioninusual.FormaSenalAlertaInternacional;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGirosInternacional;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TerceroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TipoDocumentoInternacional;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.tercero.internacional.ConfigTerceroInternacionalDTO;

/**
 * ********************************************************************
 * 
 * @class FormaActualizarCrearTerceroInternacional Clase que representa la forma
 *        para actualizar y/o crear un tercero internacional
 * @author hector.cuenca
 * @date 20/03/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 *            *********************************************************************
 */
public class FormaActualizarCrearTerceroInternacional extends FormaGenerica {

	/**
	 * @variable serialVersionUID Variable serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @variable pnlInfoDocumento Seccion que contiene la informacion del documento
	 *           del tercero
	 */
	private SeccionUtil pnlInfoDocumento;

	/**
	 * @variable pnlNacimiento Seccion que contiene la informacion del documento del
	 *           tercero
	 */
	private SeccionUtil pnlNacimiento;

	/**
	 * @variable pnlInfoContacto Seccion que contiene la informacion de contacto del
	 *           tercero
	 */
	private SeccionUtil pnlInfoContacto;

	/**
	 * @variable pnlResidencia Seccion que contiene la informacion de residencia del
	 *           tercero
	 */
	private SeccionUtil pnlResidencia;

	/**
	 * @variable pnlDatosSocioEconomicos Seccion que contiene la informacion delos
	 *           datos socio economicos
	 */
	private SeccionUtil pnlDatosSocioEconomicos;

	/**
	 * @variable pnlExpedicion Seccion que contiene la informacion de lugar
	 *           expedicion del tercero
	 */
	private SeccionUtil pnlExpedicion;

	/**
	 * @variable pnlDatosComplementarios Seccion que contiene la informacion de
	 *           datos complementarios PEPS del tercero
	 */
	private SeccionUtil pnlDatosComplementarios;

	/**
	 * @variable pnlEmpresaDatAdd Seccion que contiene la informacion de datos de la
	 *           empresa, en forma datos adicionales
	 */
	private SeccionUtil pnlEmpresaDatAdd;

	/**
	 * @variable pnlTerritorioResidencia Seccion que contiene los controles graficos
	 *           para determinar una zona
	 */
	private FormaPanelTerritorio pnlTerritorioResidencia;

	/**
	 * @variable pnlDireccionResidencia Seccion que contiene los controles graficos
	 *           que especifican la direccion de residencia asociada al tercero
	 */
	private FormaPanelDireccion pnlDireccionResidencia;

	/**
	 * @variable pnlDedoBiometriaSeleccionado Seccion que permite especificar el
	 *           dedo seleccionado para aplicar el proceso de biometria
	 */
	// private FormaPanelDedoBiometriaSeleccionado pnlDedoBiometriaSeleccionado;

	/**
	 * @variable lblDocumento Etiqueta que identifica el documento asociado al
	 *           tercero
	 */
	private EtiquetaUtil lblDocumento;

	/**
	 * @variable lblNombres Etiqueta que identifica los nombres asociados al tercero
	 */
	private EtiquetaUtil lblNombres;

	/**
	 * @variable lblApellidos Etiqueta que identifica los apellidos asociados al
	 *           tercero
	 */
	private EtiquetaUtil lblApellidos;

	/**
	 * @variable lblFechaNacimiento Etiqueta que senala el componente para
	 *           especificar la fecha de nacimiento asociada al tercero
	 */
	private EtiquetaUtil lblFechaNacimiento;

	/**
	 * @variable lblCiudadNacimiento Etiqueta que senala el componente para
	 *           especificar la ciudad de nacimiento asociada al tercero
	 */
	private EtiquetaUtil lblCiudadNacimiento;

	/**
	 * @variable lblTelefonoFijoCelular Etiqueta que senala el componente para
	 *           especificar el telefono fijo o celular asociado al tercero
	 */
	private EtiquetaUtil lblTelefonoFijoCelular;

	/**
	 * @variable lblVlrIngresoMensual Etiqueta que identifica el valor ingreso
	 *           mensual
	 */
	private EtiquetaUtil lblVlrIngresoMensual;

	/**
	 * @variable lblVlrEgresoMensualActivos Etiqueta que identifica el valor egreso
	 *           mensual activos
	 */
	private EtiquetaUtil lblVlrEgresoMensualActivos;

	/**
	 * @variable lblVlrActivos Etiqueta que identifica el valor de activos
	 */
	private EtiquetaUtil lblVlrActivos;

	/**
	 * @variable lblVlrPasivos Etiqueta que identifica el valor de pasivos
	 */
	private EtiquetaUtil lblVlrPasivos;

	/**
	 * @variable lblActvEconomicas Etiqueta que identifica el valor de las
	 *           actividades economicas
	 */
	private EtiquetaUtil lblActvEconomicas;

	/**
	 * @variable lblProfesion Etiqueta que identifica el valor de prefesion
	 */
	private EtiquetaUtil lblProfesion;

	/**
	 * @variable lblOperMonedaExtranjera Etiqueta que identifica operaciones moneda
	 *           extranjera
	 */
	private EtiquetaUtil lblOperMonedaExtranjera;

	/**
	 * @variable lblVlrIngresoOperMonExtr Etiqueta que identifica el valor ingreso
	 *           de operaciones moneda extranjera
	 */
	private EtiquetaUtil lblVlrIngresoOperMonExtr;

	/**
	 * @variable lblMonedaExtranjera Etiqueta que identifica el tipo de moneda
	 *           extranjera
	 */
	private EtiquetaUtil lblMonedaExtranjera;

	/**
	 * @variable lblEntidadExtranjera Etiqueta que identifica la entidad extranjera
	 */
	private EtiquetaUtil lblEntidadExtranjera;

	/**
	 * @variable lblNumProductoExtranjera Etiqueta que identifica el numero de
	 *           producto extranjero
	 */
	private EtiquetaUtil lblNumProductoExtranjera;

	/**
	 * @variable lblFechaExpedicion Etiqueta que senala el componente para
	 *           especificar la fecha de expedicion del documento asociado al
	 *           tercero
	 */
	private EtiquetaUtil lblFechaExpedicion;

	/**
	 * @variable lblCiudadExpedicion Etiqueta que senala el componente para
	 *           especificar la ciudad de Expedicion del documento asociado al
	 *           tercero
	 */
	private EtiquetaUtil lblCiudadExpedicion;

	/**
	 * @variable lblPEPS Etiqueta que senala el componente para especificar PEPS
	 *           asociado al tercero
	 */
	private EtiquetaUtil lblPEPS;

	/**
	 * @variable lblVlrOtrosIngresos Etiqueta que senala el componente para
	 *           especificar el valor otros ingresos
	 */
	private EtiquetaUtil lblVlrOtrosIngresos;

	/**
	 * @variable lblVlrDetalleOtrosIngresos Etiqueta que senala el componente para
	 *           especificar el detalle del valor otros ingresos
	 */
	private EtiquetaUtil lblVlrDetalleOtrosIngresos;

	/**
	 * @variable lblNombreEmpresa Etiqueta que senala el componente para especificar
	 *           el nombre de la empresa
	 */
	private EtiquetaUtil lblNombreEmpresa;

	/**
	 * @variable lblDireccionEmpresa Etiqueta que senala el componente para
	 *           especificar la Direccion de la empresa
	 */
	private EtiquetaUtil lblDireccionEmpresa;

	/**
	 * @variable lblTelefonoEmpresa Etiqueta que senala el componente para
	 *           especificar el Telefono de la empresa
	 */
	private EtiquetaUtil lblTelefonoEmpresa;

	/**
	 * @variable lblCiudadEmpresa Etiqueta que senala el componente para especificar
	 *           la Ciudad de la empresa
	 */
	private EtiquetaUtil lblCiudadEmpresa;
	/**
	 * @variable lblCargoEmpresa Etiqueta que senala el componente para especificar
	 *           el Cargo de la empresa
	 */
	private EtiquetaUtil lblCargoEmpresa;

	/**
	 * @variable lblcorreoElectronico Etiqueta que identifica el correo asociado al
	 *           tercero Internacional
	 */
	private EtiquetaUtil lblcorreoElectronico;

	/**
	 * @variable txtCorreoElectronico campo de texto sobre la forma para diligenciar
	 *           el correo electronico asociado al tercero Internacional
	 **/
	private CajaTextoUtil txtCorreoElectronico;

	/**
	 * @variable cmbTipoDocumento Lista de valores (combo), que contendra el tipo de
	 *           documento asociado al tercero
	 */
	private CajaComboUtil cmbTipoDocumento;

	/**
	 * @variable cmbActvEconomicas componente de combo que identifica el listado de
	 *           las actividades economicas
	 */
	private CajaComboUtil cmbActvEconomicas;

	/**
	 * @variable cmbProfesion componente de combo que identifica el listado de
	 *           prefesiones
	 */
	private CajaComboUtil cmbProfesion;

	/**
	 * @variable cmbManejaOperMonedaExtranjera componente de combo que identifica si
	 *           el tercero maneja operaciones en moneda extranjera (S-N)
	 */
	private CajaComboUtil cmbManejaOperMonedaExtranjera;

	/**
	 * @variable cmbOperacionesMonedaExtranjera componente de combo que identifica
	 *           la operacion en moneda extranjera que maneja el tercero
	 */
	private CajaComboUtil cmbOperacionesMonedaExtranjera;

	/**
	 * @variable cmbMonedaExtranjera componente de combo que identifica la moneda
	 *           extranjera que maneja el tercero
	 */
	private CajaComboUtil cmbMonedaExtranjera;

	/**
	 * @variable cmbPEPS componente de combo que identifica el tercero es PEPS
	 */
	private CajaComboUtil cmbPEPS;

	/**
	 * @variable txtDocumento Caja de texto que especifica la identificacion del
	 *           tercero
	 */
	private CajaTextoUtil txtDocumento;

	/**
	 * @variable txtPrimerNombre Caja de texto que especifica el primer nombre
	 *           asociado al tercero
	 */
	private CajaTextoUtil txtPrimerNombre;

	/**
	 * @variable txtPrimerApellido Caja de texto que especifica el primer apellido
	 *           asociado al tercero
	 */
	private CajaTextoUtil txtPrimerApellido;

	/**
	 * @variable txtSegundoApellido Caja de texto que especifica el segundo apellido
	 *           asociado al tercero
	 */
	private CajaTextoUtil txtSegundoApellido;

	/**
	 * @variable txtSegundoNombre Caja de texto que especifica el segundo nombre
	 *           asociado al tercero
	 */
	private CajaTextoUtil txtSegundoNombre;

	/**
	 * @variable txtCiudadNacimiento Caja de texto que especifica la ciudad de
	 *           nacimiento asociada al tercero
	 */
	private CajaTextoUtil txtCiudadNacimiento;

	/**
	 * @variable txtTelefonoFijoCelular Caja de texto que especifica el telefono
	 *           fijo o celular asociado al tercero
	 */
	private CajaTextoUtil txtTelefonoFijoCelular;

	/**
	 * @variable txtVlrIngresoMensual Caja de texto que identifica el valor ingreso
	 *           mensual
	 */
	private CajaTextoUtil txtVlrIngresoMensual;

	/**
	 * @variable txtVlrEgresoMensualActivos Caja de texto que identifica el valor
	 *           egreso mensual activos
	 */
	private CajaTextoUtil txtVlrEgresoMensualActivos;

	/**
	 * @variable txtVlrActivos Caja de texto que identifica el valor de activos
	 */
	private CajaTextoUtil txtVlrActivos;

	/**
	 * @variable txtVlrPasivos Caja de texto que identifica el valor de pasivos
	 */
	private CajaTextoUtil txtVlrPasivos;

	/**
	 * @variable txtValorIngresoExt Caja de texto que identifica el valor ingreso
	 *           extranjero
	 */
	private CajaTextoUtil txtValorIngresoExt;

	/**
	 * @variable txtEntidadExtranjera Caja de texto que identifica la entidad
	 *           extranjera
	 */
	private CajaTextoUtil txtEntidadExtranjera;

	/**
	 * @variable txtNumProductoExtranjera Caja de texto que identifica el numero de
	 *           producto extranjera
	 */
	private CajaTextoUtil txtNumProductoExtranjera;

	/**
	 * @variable txtCiudadExpedicion Caja de texto que especifica la ciudad de
	 *           expedicion del documento asociado al tercero
	 */
	private CajaTextoUtil txtCiudadExpedicion;

	/**
	 * @variable txtVlrOtrosIngresos Caja de texto que especifica el valor de otros
	 *           ingresos
	 */
	private CajaTextoUtil txtVlrOtrosIngresos;

	/**
	 * @variable txtDetaVlrOtrosIngresos Caja de texto que especifica el detalle del
	 *           valor de otros ingresos
	 */
	private CajaTextoUtil txtDetaVlrOtrosIngresos;

	/**
	 * @variable txtNombreEmpresa Caja de texto que especifica el nombre de la
	 *           empresa
	 */
	private CajaTextoUtil txtNombreEmpresa;

	/**
	 * @variable txtDireccionEmpresa Caja de texto que especifica la Direccion de la
	 *           empresa
	 */
	private CajaTextoUtil txtDireccionEmpresa;

	/**
	 * @variable txtTelefonoEmpresa Caja de texto que especifica el Telefono de la
	 *           empresa
	 */
	private CajaTextoUtil txtTelefonoEmpresa;

	/**
	 * @variable txtCiudadEmpresa Caja de texto que especifica la Ciudad de la
	 *           empresa
	 */
	private CajaTextoUtil txtCiudadEmpresa;
	/**
	 * @variable txtCargoEmpresa Caja de texto que especifica el Cargo de la empresa
	 */
	private CajaTextoUtil txtCargoEmpresa;

	/**
	 * @variable dtcFechaNacimiento Caja de calendario para diligenciar la fecha de
	 *           nacimiento asociada al tercero
	 */
	private CajaFechaUtil dtcFechaNacimiento;

	/**
	 * @variable dtcFechaExpedicion Caja de calendario para diligenciar la fecha de
	 *           Expedicion del documento asociado al tercero
	 */
	private CajaFechaUtil dtcFechaExpedicion;

	/**
	 * @variable btnVerInfoPEPS componente boton sobre la forma para manejar la
	 *           funcionalida de informacion PEPS
	 **/
	private BotonUtil btnVerInfoPEPS;

	/**
	 * @variable btnEmpresaSocEcono componente boton sobre la forma para manejar la
	 *           funcionalida de la informacion de la empresa de la actividad
	 *           economica
	 **/
	private BotonUtil btnEmpresaSocEcono;

	/**
	 * ********************************************************************
	 * 
	 * @method FormaActualizarCrearTerceroInternacional Constructor que ejecuta la
	 *         inicializacion de valores y ejecucion de comportamientos inicales
	 *         requeridos para el despliegue de la forma
	 * @param pFrmPadre
	 *            Ventana de la cual extiende esta forma
	 * @param pBooModal
	 *            Bandera que permite efectuar la forma de manera modal sobre la
	 *            ventana de la cual extiende
	 * @param pBooTerceroPresente
	 *            Bandera que identifica si el tercero a procesar se encuentra
	 *            presente en la operacion o no, true o false respectivamente
	 * @param pObjDatEntTipoId
	 *            Tipo de identificacion asociado al tercero
	 * @param pStrIdentificacion
	 *            Identificacion asociada al tercero
	 * @param pObjDtoConfigTercero
	 *            Objeto DTO encargado de almacenar toda la configuracion
	 *            relacionada con un tercero internacional
	 * @param pStrIdTransaccion
	 *            id transaccion
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author hector.cuenca
	 * @date 20/03/2018
	 *       *********************************************************************
	 */
	public FormaActualizarCrearTerceroInternacional(FormaGenerica pFrmPadre, boolean pBooModal,
			boolean pBooTerceroPresente, ConfigTerceroInternacionalDTO pObjDtoConfigTercero,
			TipoDocumentoInternacional pObjDatEntTipoId, String pStrIdentificacion, String pStrIdTransaccion)
			throws Exception {
		super(pFrmPadre, pBooModal);

		super.setEventoForma(new EventoFormaActualizarCrearTerceroInternacional(this, pBooTerceroPresente,
				pObjDtoConfigTercero, pObjDatEntTipoId, pStrIdentificacion, pStrIdTransaccion));
		this.inicializarForma();
	}

	/**
	 * ********************************************************************
	 * 
	 * @method FormaActualizarCrearTerceroInternacional Constructor que ejecuta la
	 *         inicializacion de valores y ejecucion de comportamientos inicales
	 *         requeridos para el despliegue de la forma
	 * @param pFrmPadre
	 *            Ventana de la cual extiende esta forma
	 * @param pBooModal
	 *            Bandera que permite efectuar la forma de manera modal sobre la
	 *            ventana de la cual extiende
	 * @param pBooTerceroPresente
	 *            Bandera que identifica si el tercero a procesar se encuentra
	 *            presente en la operacion o no, true o false respectivamente
	 * @param pObjTercero
	 *            objeto tercero con la informacion
	 * @param pStrIdTransaccion
	 *            id transaccion
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 18/04/2018
	 *       *********************************************************************
	 */
	public FormaActualizarCrearTerceroInternacional(FormaGenerica pFrmPadre, boolean pBooModal,
			boolean pBooTerceroPresente, TerceroInternacional pObjTercero, String pStrIdTransaccion) throws Exception {
		super(pFrmPadre, pBooModal);

		super.setEventoForma(new EventoFormaActualizarCrearTerceroInternacional(this, pBooTerceroPresente, pObjTercero,
				pStrIdTransaccion));
		this.inicializarForma();
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo inicializarForma Metodo propuesto por la forma generica, para
	 *         inicializar todos los aspectos de la forma
	 * @param pArrObjParametrosForma
	 *            lista de posibles parametros a incluir sobre la inicializacion de
	 *            la forma [x]: descripcion del valor enviado en la posicion [x]
	 *            [0]: direccion previamente diligenciada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	@Override
	public void inicializarForma(Object... pArrObjParametrosForma) throws Exception {

		super.setAnchoForma(EnumDimensionesComponentes.GUI_MNT_TERC_INT_VENTANA_USUARIO.getAncho());

		if (this.getEventoForma().getObjDtoConfigTercero().getObjBooActualizaClienteUsuario() != null
				&& this.getEventoForma().getObjDtoConfigTercero().getObjBooActualizaClienteUsuario()) {

			super.setTituloForma(EnumEtiquetas.TTL_MNT_TERC_INT_VENTANA, "Cliente");
			super.setAltoForma(EnumDimensionesComponentes.GUI_MNT_TERC_INT_VENTANA_CLIENTE.getAlto());

		} else {

			super.setTituloForma(EnumEtiquetas.TTL_MNT_TERC_INT_VENTANA, "Usuario");
			super.setAltoForma(EnumDimensionesComponentes.GUI_MNT_TERC_INT_VENTANA_USUARIO.getAlto());
		}

		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR, EnumBotonesEncabezado.BTNVOLVER,
				EnumBotonesEncabezado.BTN_LIMPIAR);

		super.iniciar(pArrObjParametrosForma);
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo inicializarEncabezado Metodo dedicado a inicializar y gestionar el
	 *         encabezado de la forma (seccion superior)
	 * @param pArrObjParametrosForma
	 *            lista de posibles parametros a incluir sobre la inicializacion de
	 *            la seccion del encabezado [x]: descripcion del valor enviado en la
	 *            posicion [x]
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	@Override
	public JPanel inicializarEncabezado(Object... pArrObjParametrosForma) throws Exception {
		return null;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo inicializarCuerpo Metodo dedicado a inicializar y gestionar el cuerpo
	 *         de la forma (seccion central)
	 * @param pArrObjParametrosCuerpo
	 *            lista de posibles parametros a incluir sobre la inicializacion de
	 *            la seccion del cuerpo [x]: descripcion del valor enviado en la
	 *            posicion [x]
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	@Override
	public JPanel inicializarCuerpo(Object... pArrObjParametrosCuerpo) throws Exception {

		JPanel pnlCuerpo;

		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_MNT_TERC_INT_CUERPO,
				"pnlCuerpo", BorderFactory.createEmptyBorder(), null, null);
		pnlCuerpo.add(this.iniciarPropPnlDocumento());
		pnlCuerpo.add(this.iniciarPropPnlContacto());

		return pnlCuerpo;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo inicializarPiePagina Metodo dedicado a inicializar y gestionar el pie
	 *         de pagina de la forma (seccion inferior)
	 * @param pArrObjParametrosPiePagina
	 *            lista de posibles parametros a incluir sobre la inicializacion de
	 *            la seccion de pie de pagina [x]: descripcion del valor enviado en
	 *            la posicion [x]
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	@Override
	public JPanel inicializarPiePagina(Object... pArrObjParametrosPiePagina) throws Exception {

		JPanel pnlPiePagina = null;

		if (this.getEventoForma().getObjDtoConfigTercero().getObjBooActualizaClienteUsuario() != null
				&& this.getEventoForma().getObjDtoConfigTercero().getObjBooActualizaClienteUsuario()) {

			pnlPiePagina = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_MNT_TERC_INT_PIE,
					"pnlPiePagina", BorderFactory.createEmptyBorder(), null, null);

			pnlPiePagina.add(this.iniciarPropPnlDatosSocioEconomicos());
			pnlPiePagina.add(this.iniciarPropPnlExpedicion());
			pnlPiePagina.add(this.iniciarPropPnlDatosComplementarios());
		}

		return pnlPiePagina;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropPnlDocumento Metodo estandar para autogestionar el valor
	 *         del atributo pnlInfoDocumento
	 * @return SeccionUtil Seccion gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author hector.cuenca
	 * @date 20/03/2018
	 *       *********************************************************************
	 */
	public SeccionUtil iniciarPropPnlDocumento() throws Exception {
		if (this.pnlInfoDocumento == null) {
			this.pnlInfoDocumento = UtilComponentesGUI.getInstance().crearPanel(
					EnumDimensionesComponentes.PNL_MNT_TERC_INT_DOCUMENTO, "pnlInfoDocumento", null,
					EnumEtiquetas.TTL_MNT_TERC_INT_PNL_DOCUMENTO, null);
			this.pnlInfoDocumento.add(this.iniciarPropLblDocumento());
			this.pnlInfoDocumento.add(this.iniciarPropCmbTipoDocumento());
			this.pnlInfoDocumento.add(this.iniciarPropTxtDocumento());
			this.pnlInfoDocumento.add(this.iniciarPropLblNombres());
			this.pnlInfoDocumento.add(this.iniciarPropTxtPrimerNombre());
			this.pnlInfoDocumento.add(this.iniciarPropTxtSegundoNombre());
			this.pnlInfoDocumento.add(this.iniciarPropLblApellidos());
			this.pnlInfoDocumento.add(this.iniciarPropTxtPrimerApellido());
			this.pnlInfoDocumento.add(this.iniciarPropTxtSegundoApellido());
			this.pnlInfoDocumento.add(this.iniciarPropPnlNacimiento());
		}

		return this.pnlInfoDocumento;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropPnlContacto Metodo estandar para autogestionar el valor
	 *         del atributo pnlInfoContacto
	 * @return SeccionUtil Seccion gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author hector.cuenca
	 * @date 20/03/2018
	 *       *********************************************************************
	 */
	public SeccionUtil iniciarPropPnlContacto() throws Exception {
		if (this.pnlInfoContacto == null) {
			this.pnlInfoContacto = UtilComponentesGUI.getInstance().crearPanel(
					EnumDimensionesComponentes.PNL_MNT_TERC_INT_CONTACTO, "pnlInfoContacto", null,
					EnumEtiquetas.TTL_MNT_TERC_INT_PNL_CONTACTO, null);
			this.pnlInfoContacto.add(this.iniciarPropLblTelefonoFijoCelular());
			this.pnlInfoContacto.add(this.iniciarPropTxtTelefonoFijoCelular());
			this.pnlInfoContacto.add(this.iniciarPropPnlResidencia());
			
			if (this.getEventoForma().getObjDtoConfigTercero().getObjBooActualizaClienteUsuario() != null
					&& this.getEventoForma().getObjDtoConfigTercero().getObjBooActualizaClienteUsuario()) {
			this.pnlInfoContacto.add(this.iniciarPropLblCorreoElectronico());
			this.pnlInfoContacto.add(this.iniciarPropTxtCorreoElectronico());
			
			}
			
		}

		return this.pnlInfoContacto;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropPnlResidencia Metodo estandar para autogestionar el valor
	 *         del atributo pnlResidencia
	 * @return SeccionUtil Seccion gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author hector.cuenca
	 * @date 20/03/2018
	 *       *********************************************************************
	 */
	public SeccionUtil iniciarPropPnlResidencia() throws Exception {
		if (this.pnlResidencia == null) {
			this.pnlResidencia = UtilComponentesGUI.getInstance().crearPanel(
					EnumDimensionesComponentes.PNL_MNT_TERC_INT_RESIDENCIA, "pnlResidencia", null,
					EnumEtiquetas.TTL_MNT_TERC_INT_PNL_RESIDENCIA, TitledBorder.LEFT);
			this.pnlResidencia.setBooAplicarTransparenciaFondo(true);

			this.pnlResidencia.add(this.iniciarPropPnlTerritorioResidencia());
			this.pnlResidencia.add(this.iniciarPropPnlDireccionResidencia());
		}

		return this.pnlResidencia;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropPnlTerritorioResidencia Metodo estandar para autogestionar
	 *         el valor del atributo pnlTerritorioResidencia
	 * @return FormaPanelTerritorio Seccion de territorio gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author hector.cuenca
	 * @date 21/03/2018
	 *       *********************************************************************
	 */
	public FormaPanelTerritorio iniciarPropPnlTerritorioResidencia() throws Exception {
		ConfigTerritorioDTO objDtoConfigTerritorio;

		if (this.pnlTerritorioResidencia == null) {
			objDtoConfigTerritorio = new ConfigTerritorioDTO();
			objDtoConfigTerritorio
					.setTmPais(InformacionSessionGirosInternacional.getInstance(super.getObjUsuario()).getTmPaises());

			this.pnlTerritorioResidencia = new FormaPanelTerritorio("pnlTerritorioResidencia", false, // pTitulos
					true, // pTituloCombo
					new String[] { "cmbPaisResidencia", "cmbDepartamentoResidencia", "cmbMunicipioResidencia" }, 2, // pCategoria
					false, // pAPartir
					false, // pActivaAgencia
					EnumDimensionesComponentes.PNL_MNT_TERC_INT_TERR_RESIDENCIA, // rectangulo
					null, objDtoConfigTerritorio);// deptoBase
			// this.pnlTerritorioResidencia.setBorder(BorderFactory.createEtchedBorder());
			this.pnlTerritorioResidencia.getCmbPais().setSelectedItem(EnumEtiquetas.LBL_NO_SELECCIONADO);
			this.pnlTerritorioResidencia.getCmbPais().getLblObligatorio()
					.setEnmEtiNombreCampo(EnumEtiquetas.CMB_MNT_TERC_INT_PAIS_RESIDENCIA);
			this.pnlTerritorioResidencia.getCmbDepartamento().getLblObligatorio()
					.setEnmEtiNombreCampo(EnumEtiquetas.CMB_MNT_TERC_INT_DEPARTAMENTO_RESIDENCIA);
			this.pnlTerritorioResidencia.getCmbMunicipio().getLblObligatorio()
					.setEnmEtiNombreCampo(EnumEtiquetas.CMB_MNT_TERC_INT_CIUDAD_RESIDENCIA);
		}

		return this.pnlTerritorioResidencia;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropPnlDireccionResidencia Metodo estandar para autogestionar
	 *         el valor del atributo pnlDireccionResidencia
	 * @return FormaPanelDireccion Seccion de direccion gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author hector.cuenca
	 * @date 21/03/2018
	 *       *********************************************************************
	 */
	public FormaPanelDireccion iniciarPropPnlDireccionResidencia() throws Exception {
		ConfigDireccionDTO objDtoConfigDireccion;

		if (this.pnlDireccionResidencia == null) {
			this.pnlDireccionResidencia = new FormaPanelDireccion(null, this,
					EnumDimensionesComponentes.PNL_MNT_TERC_INT_DIR_DIRECCION,
					new EnumDimensionesComponentes[] { EnumDimensionesComponentes.LBL_MNT_TERC_INT_PNL_DIR_ETIQUETA,
							EnumDimensionesComponentes.TXT_MNT_TERC_INT_PNL_DIR_DESCRIPCION,
							EnumDimensionesComponentes.BTN_MNT_TERC_INT_PNL_DIR_MANTENIMIENTO,
							EnumDimensionesComponentes.BTN_MNT_TERC_INT_PNL_DIR_LIMPIAR },
					"pnlDireccionResidencia");
			// this.pnlDireccionResidencia.setBorder(BorderFactory.createEtchedBorder());
			objDtoConfigDireccion = new ConfigDireccionDTO();
			objDtoConfigDireccion
					.setStrEntLstClaseVia(EnumParametrosApp.ENT_DIRECCION_CLASES_VIA_INTERNACIONAL.getValorPropiedad());
			objDtoConfigDireccion.setBooHabilitarUbicacion(false);
			objDtoConfigDireccion.setBooHabilitarLugar(false);
			objDtoConfigDireccion.setEnmExpRegCtrlFrmDireccionCompleto(
					EnumExpresionesRegulares.EXP_REG_FORMATO_DIR_COMPLETO_INTERNACIONAL);
			objDtoConfigDireccion.setEnmExpRegCtrFrmIngresoNumeroVia(
					EnumExpresionesRegulares.EXP_REG_FORMATO_DIR_TRADICIONAL_NUMERO_VIA_INTERNACIONAL);
			objDtoConfigDireccion.setEnmExpRegCtrlFrmIngresoNumeroInterseccion(
					EnumExpresionesRegulares.EXP_REG_FORMATO_DIR_TRADICIONAL_NUMERO_INTERSECCION_INTERNACIONAL);
			objDtoConfigDireccion.setEnmExpRegCtrlFrmIngresoNumeroLugar(
					EnumExpresionesRegulares.EXP_REG_FORMATO_DIR_TRADICIONAL_NUMERO_LUGAR_INTERNACIONAL);
			this.pnlDireccionResidencia.getTxtDescripcion().getLblObligatorio()
					.setEnmEtiNombreCampo(EnumEtiquetas.TXT_MNT_TERC_INT_DIRECCION_RESIDENCIA);
			this.pnlDireccionResidencia.getEvaFrmPnlDireccion().setObjDtoConfigDireccion(objDtoConfigDireccion);
		}

		return this.pnlDireccionResidencia;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropPnlDedoBiometriaSeleccionado Metodo estandar para
	 *         autogestionar el valor del atributo pnlDedoBiometriaSeleccionado
	 * @return FormaPanelDedoBiometriaSeleccionado Seccion que especifica el dedo
	 *         seleccionado para aplicar el proceso de biometria, gestionado
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author hector.cuenca
	 * @date 21/03/2018
	 *       *********************************************************************
	 */
	/*
	 * public FormaPanelDedoBiometriaSeleccionado
	 * iniciarPropPnlDedoBiometriaSeleccionado() throws Exception { if (
	 * this.pnlDedoBiometriaSeleccionado == null ) {
	 * this.pnlDedoBiometriaSeleccionado = new FormaPanelDedoBiometriaSeleccionado (
	 * this,
	 * EnumDimensionesComponentes.PNL_MNT_TERC_INT_DEDO_BIOMETRIA_SELECCIONADO,
	 * "pnlDedoBiometriaSeleccionado" ); }
	 * 
	 * return this.pnlDedoBiometriaSeleccionado; }
	 */

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropPnlNacimiento Metodo estandar para autogestionar el valor
	 *         del atributo pnlNacimiento
	 * @return SeccionUtil Seccion gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author hector.cuenca
	 * @date 20/03/2018
	 *       *********************************************************************
	 */
	public SeccionUtil iniciarPropPnlNacimiento() throws Exception {
		if (this.pnlNacimiento == null) {
			this.pnlNacimiento = UtilComponentesGUI.getInstance().crearPanel(
					EnumDimensionesComponentes.PNL_MNT_TERC_INT_NACIMIENTO, "pnlNacimiento", null,
					EnumEtiquetas.TTL_MNT_TERC_INT_PNL_NACIMIENTO, TitledBorder.LEFT);
			this.pnlNacimiento.setBooAplicarTransparenciaFondo(true);

			this.pnlNacimiento.add(this.iniciarPropLblFechaNacimiento());
			this.pnlNacimiento.add(this.iniciarPropDtcFechaNacimiento());
			this.pnlNacimiento.add(this.iniciarPropLblCiudadNacimiento());
			this.pnlNacimiento.add(this.iniciarPropTxtCiudadNacimiento());

		}

		return this.pnlNacimiento;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropPnlDatosSocioEconomicos Metodo estandar para autogestionar
	 *         el valor del atributo pnlDatosSocioEconomicos
	 * @return SeccionUtil Seccion gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 16/04/2018
	 *       *********************************************************************
	 */
	public SeccionUtil iniciarPropPnlDatosSocioEconomicos() throws Exception {
		if (this.pnlDatosSocioEconomicos == null) {
			this.pnlDatosSocioEconomicos = UtilComponentesGUI.getInstance().crearPanel(
					EnumDimensionesComponentes.PNL_MNT_TERC_INT_DATO_SOC_ECONO, "pnlDatosSocioEconomicos", null,
					EnumEtiquetas.TTL_MNT_TERC_INT_PNL_DATO_SOC_ECONO, null);
			this.pnlDatosSocioEconomicos.add(this.iniciarPropLblVlrIngresoMensual());
			this.pnlDatosSocioEconomicos.add(this.iniciarPropLblVlrEgresoMensualActivos());
			this.pnlDatosSocioEconomicos.add(this.iniciarPropLblVlrActivos());
			this.pnlDatosSocioEconomicos.add(this.iniciarPropLblVlrPasivos());
			this.pnlDatosSocioEconomicos.add(this.iniciarPropTxtVlrIngresoMensual());
			this.pnlDatosSocioEconomicos.add(this.iniciarPropTxtVlrEgresoMensualActivos());
			this.pnlDatosSocioEconomicos.add(this.iniciarPropTxtVlrActivos());
			this.pnlDatosSocioEconomicos.add(this.iniciarPropTxtVlrPasivos());
			this.pnlDatosSocioEconomicos.add(this.iniciarPropLblActvEconomicas());
			this.pnlDatosSocioEconomicos.add(this.iniciarPropLblProfesion());
			this.pnlDatosSocioEconomicos.add(this.iniciarPropCmbActvEconomicas());
			this.pnlDatosSocioEconomicos.add(this.iniciarPropCmbProfesion());
			this.pnlDatosSocioEconomicos.add(this.iniciarPropBtnVerInfoPEPS());
			this.pnlDatosSocioEconomicos.add(this.iniciarPropBtnEmpresaSocEcono());
			this.pnlDatosSocioEconomicos.add(this.iniciarPropLblOperMonedaExtranjera());
			this.pnlDatosSocioEconomicos.add(this.iniciarPropLblVlrIngresoOperMonExtr());
			this.pnlDatosSocioEconomicos.add(this.iniciarPropLblMonedaExtranjera());
			this.pnlDatosSocioEconomicos.add(this.iniciarPropLblEntidadExtranjera());
			this.pnlDatosSocioEconomicos.add(this.iniciarPropLblNumProductoExtranjera());
			this.pnlDatosSocioEconomicos.add(this.iniciarPropCmbManejaOperMonedaExtranjera());
			this.pnlDatosSocioEconomicos.add(this.iniciarPropCmbOperacionesMonedaExtranjera());
			this.pnlDatosSocioEconomicos.add(this.iniciarPropTxtValorIngresoExt());
			this.pnlDatosSocioEconomicos.add(this.iniciarPropCmbMonedaExtranjera());
			this.pnlDatosSocioEconomicos.add(this.iniciarPropTxtEntidadExtranjera());
			this.pnlDatosSocioEconomicos.add(this.iniciarPropTxtNumProductoExtranjera());
		}

		return this.pnlDatosSocioEconomicos;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropPnlExpedicion Metodo estandar para autogestionar el valor
	 *         del atributo pnlExpedicion
	 * @return SeccionUtil Seccion gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 18/04/2018
	 *       *********************************************************************
	 */
	public SeccionUtil iniciarPropPnlExpedicion() throws Exception {
		if (this.pnlExpedicion == null) {
			this.pnlExpedicion = UtilComponentesGUI.getInstance().crearPanel(
					EnumDimensionesComponentes.PNL_MNT_TERC_INT_EXPEDICION, "pnlExpedicion", null,
					EnumEtiquetas.TTL_MNT_TERC_INT_PNL_EXPEDICION, TitledBorder.LEFT);
			this.pnlExpedicion.add(this.iniciarPropLblFechaExpedicion());
			this.pnlExpedicion.add(this.iniciarPropDtcFechaExpedicion());
			this.pnlExpedicion.add(this.iniciarPropLblCiudadExpedicion());
			this.pnlExpedicion.add(this.iniciarPropTxtCiudadExpedicion());
			this.pnlExpedicion.setBooAplicarTransparenciaFondo(true);

		}

		return this.pnlExpedicion;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropPnlDatosComplementarios Metodo estandar para autogestionar
	 *         el valor del atributo pnlDatosComplementarios
	 * @return SeccionUtil Seccion gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 18/04/2018
	 *       *********************************************************************
	 */
	public SeccionUtil iniciarPropPnlDatosComplementarios() throws Exception {
		if (this.pnlDatosComplementarios == null) {
			this.pnlDatosComplementarios = UtilComponentesGUI.getInstance().crearPanel(
					EnumDimensionesComponentes.PNL_MNT_TERC_INT_DATOS_COMPLEMENTARIOS, "pnlDatosComplementarios", null,
					EnumEtiquetas.TTL_MNT_TERC_INT_PNL_DATOS_COMPLEMENTARIOS, TitledBorder.LEFT);
			this.pnlDatosComplementarios.add(this.iniciarPropLblPEPS());
			this.pnlDatosComplementarios.add(this.iniciarPropCmbPEPS());
			this.pnlDatosComplementarios.add(this.iniciarPropBtnVerInfoPEPS());
			this.pnlDatosComplementarios.add(this.iniciarPropLblVlrOtrosIngresos());
			this.pnlDatosComplementarios.add(this.iniciarPropTxtVlrOtrosIngresos());
			this.pnlDatosComplementarios.add(this.iniciarPropLblVlrDetalleOtrosIngresos());
			this.pnlDatosComplementarios.add(this.iniciarPropTxtDetaVlrOtrosIngresos());

			this.pnlDatosComplementarios.setBooAplicarTransparenciaFondo(true);

		}
		return this.pnlDatosComplementarios;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropPnlEmpresaDatAdd Metodo estandar para autogestionar el
	 *         valor del atributo pnlEmpresaDatAdd
	 * @return SeccionUtil Seccion gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 18/04/2018
	 *       *********************************************************************
	 */
	public SeccionUtil iniciarPropPnlEmpresaDatAdd() throws Exception {
		if (this.pnlEmpresaDatAdd == null) {
			this.pnlEmpresaDatAdd = UtilComponentesGUI.getInstance().crearPanel(
					EnumDimensionesComponentes.PNL_MNT_TERC_INT_DATOS_EMPRESA_DATADD, "pnlEmpresaDatAdd", null,
					EnumEtiquetas.TTL_MNT_TERC_INT_PNL_DATOS_EMPRESA_DATADD, TitledBorder.LEFT);

			this.pnlEmpresaDatAdd.add(this.iniciarPropLblNombreEmpresa());
			this.pnlEmpresaDatAdd.add(this.iniciarPropTxtNombreEmpresa());
			this.pnlEmpresaDatAdd.add(this.iniciarPropLblDireccionEmpresa());
			this.pnlEmpresaDatAdd.add(this.iniciarPropTxtDireccionEmpresa());
			this.pnlEmpresaDatAdd.add(this.iniciarPropLblTelefonoEmpresa());
			this.pnlEmpresaDatAdd.add(this.iniciarPropTxtTelefonoEmpresa());
			this.pnlEmpresaDatAdd.add(this.iniciarPropLblCiudadEmpresa());
			this.pnlEmpresaDatAdd.add(this.iniciarPropTxtCiudadEmpresa());
			this.pnlEmpresaDatAdd.add(this.iniciarPropLblCargoEmpresa());
			this.pnlEmpresaDatAdd.add(this.iniciarPropTxtCargoEmpresa());

			this.pnlEmpresaDatAdd.setBooAplicarTransparenciaFondo(true);

		}

		return this.pnlEmpresaDatAdd;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropLblDocumento Metodo estandar para autogestionar el valor
	 *         del atributo lblDocumento
	 * @return EtiquetaUtil Etiqueta gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 3/03/2016
	 *       *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblDocumento() throws Exception {
		if (this.lblDocumento == null) {
			this.lblDocumento = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_MNT_TERC_INT_DOCUMENTO, "lblDocumento",
					EnumEtiquetas.LBL_MNT_TERC_INT_DOCUMENTO, true, null, true);
		}

		return this.lblDocumento;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropLblNombres Metodo estandar para autogestionar el valor del
	 *         atributo lblNombres
	 * @return EtiquetaUtil Etiqueta gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 3/03/2016
	 *       *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblNombres() throws Exception {
		if (this.lblNombres == null) {
			this.lblNombres = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_MNT_TERC_INT_NOMBRES, "lblNombres",
					EnumEtiquetas.LBL_MNT_TERC_INT_NOMBRES, true, null, true);
		}

		return this.lblNombres;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropLblApellidos Metodo estandar para autogestionar el valor
	 *         del atributo lblApellidos
	 * @return EtiquetaUtil Etiqueta gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 3/03/2016
	 *       *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblApellidos() throws Exception {
		if (this.lblApellidos == null) {
			this.lblApellidos = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_MNT_TERC_INT_APELLIDOS, "lblApellidos",
					EnumEtiquetas.LBL_MNT_TERC_INT_APELLIDOS, true, null, true);
		}

		return this.lblApellidos;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropLblFechaNacimiento Metodo estandar para autogestionar el
	 *         valor del atributo lblFechaNacimiento
	 * @return EtiquetaUtil Etiqueta gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 3/03/2016
	 *       *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblFechaNacimiento() throws Exception {
		if (this.lblFechaNacimiento == null) {
			this.lblFechaNacimiento = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_MNT_TERC_INT_FECHA_NACIMIENTO, "lblFechaNacimiento",
					EnumEtiquetas.LBL_MNT_TERC_INT_FECHA_NACIMIENTO, true, null, true);
		}

		return this.lblFechaNacimiento;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropLblCiudadNacimiento Metodo estandar para autogestionar el
	 *         valor del atributo lblCiudadNacimiento
	 * @return EtiquetaUtil Etiqueta gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 3/03/2016
	 *       *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblCiudadNacimiento() throws Exception {
		if (this.lblCiudadNacimiento == null) {
			this.lblCiudadNacimiento = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_MNT_TERC_INT_CIUDAD_NACIMIENTO, "lblCiudadNacimiento",
					EnumEtiquetas.LBL_MNT_TERC_INT_CIUDAD_NACIMIENTO, true, null, true);
		}

		return this.lblCiudadNacimiento;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropLblTelefonoFijoCelular Metodo estandar para autogestionar
	 *         el valor del atributo lblTelefonoFijoCelular
	 * @return EtiquetaUtil Etiqueta gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 3/03/2016
	 *       *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblTelefonoFijoCelular() throws Exception {
		if (this.lblTelefonoFijoCelular == null) {
			this.lblTelefonoFijoCelular = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_MNT_TERC_INT_TELEFONO_FIJO_CELULAR, "lblTelefonoFijoCelular",
					EnumEtiquetas.LBL_MNT_TERC_INT_TELEFONO_FIJO_CELULAR, true, null, true);
		}

		return this.lblTelefonoFijoCelular;
	}

	/**
	 ********************************************************************
	 * @method iniciarPropTxtCorreoElectronico Metodo estandar para autogestionar el
	 *         valor del atributo lblCorreoElectronico
	 * @return EtiquetaUtil Etiqueta gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author Monica llano
	 * @date 19/11/2019
	 *       *********************************************************************
	 */

	public CajaTextoUtil iniciarPropTxtCorreoElectronico() throws Exception {
		if (this.txtCorreoElectronico == null) {
			this.txtCorreoElectronico = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_MNT_TERC_INT_CORREO_ELECTRONICO, 
	 		  		"txtCorreoElectronico", 
	 		  		"", 
	 		  		true, 
	 		  		true, 
	 		  		true, 
	 		  		super.getEventoForma(),
	 		  		null);	
		}

		return this.txtCorreoElectronico;

	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropLblCorreoElectronico Metodo estandar para autogestionar el
	 *         valor del atributo lblCorreoElectronico
	 * @return EtiquetaUtil Etiqueta gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author Monica Llano
	 * @date 19/11/2019
	 *       *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblCorreoElectronico() throws Exception {
		if (this.lblcorreoElectronico == null) {
			this.lblcorreoElectronico = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_MNT_TERC_INT_CORREO_ELECTRONICO, "lblCorreoElectronico",
					EnumEtiquetas.LBL_MNT_TERC_INT_CORREO_ELECTRONICO, true, null, true);
		}

		return this.lblcorreoElectronico;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropCmbTipoDocumento Metodo estandar para autogestionar el
	 *         valor del atributo cmbTipoDocumento
	 * @return CajaComboUtil Lista de valores gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 3/03/2016
	 *       *********************************************************************
	 */
	public CajaComboUtil iniciarPropCmbTipoDocumento() throws Exception {
		if (this.cmbTipoDocumento == null) {
			this.cmbTipoDocumento = UtilComponentesGUI.getInstance().crearComboBox(
					EnumDimensionesComponentes.CMB_MNT_TERC_INT_TIPO_DOCUMENTO, "cmbTipoDocumento", false, true,
					super.getEventoForma(), EnumEtiquetas.LBL_MNT_TERC_INT_TIPO_DOCUMENTO);
		}

		return cmbTipoDocumento;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @method iniciarPropTxtDocumento Metodo estandar para autogestionar el valor
	 *         del atributo txtDocumento
	 * @return CajaTextoUtil Caja de texto gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 4/3/2016
	 *       ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtDocumento() throws Exception {
		if (this.txtDocumento == null) {
			this.txtDocumento = UtilComponentesGUI.getInstance().crearTextField(
					EnumDimensionesComponentes.TXT_MNT_TERC_INT_NUMERO_DOCUMENTO, "txtDocumento", "", true, false, true,
					super.getEventoForma(), EnumEtiquetas.LBL_MNT_TERC_INT_NUMERO_DOCUMENTO);

			this.txtDocumento.setToolTipText(EnumEtiquetas.TLT_CATI_DOCUMENTO);
		}

		return this.txtDocumento;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @method iniciarPropTxtPrimerNombre Metodo estandar para autogestionar el
	 *         valor del atributo txtPrimerNombre
	 * @return CajaTextoUtil Caja de texto gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 4/3/2016
	 *       ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtPrimerNombre() throws Exception {
		if (this.txtPrimerNombre == null) {
			this.txtPrimerNombre = UtilComponentesGUI.getInstance().crearTextField(
					EnumDimensionesComponentes.TXT_MNT_TERC_INT_PRIMER_NOMBRE, "txtPrimerNombre", "", true, true, true,
					super.getEventoForma(), EnumEtiquetas.TXT_MNT_TERC_INT_PRIMER_NOMBRE);
			this.txtPrimerNombre.getPropiedades().setActivaMayusculaMinuscula(true);
			this.txtPrimerNombre.getPropiedades()
					.setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_NOMBRES_TERCERO.getValor());
			this.txtPrimerNombre.getPropiedades()
					.setControlFormatoFinal(EnumExpresionesRegulares.EXP_REG_FORMATO_NOMBRES_TERCERO_FINAL.getValor());
			this.txtPrimerNombre.setToolTipText(EnumEtiquetas.TLT_CATI_PRIMER_NOMBRE);
		}

		return this.txtPrimerNombre;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @method iniciarPropTxtPrimerApellido Metodo estandar para autogestionar el
	 *         valor del atributo txtPrimerApellido
	 * @return CajaTextoUtil Caja de texto gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 4/3/2016
	 *       ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtPrimerApellido() throws Exception {
		if (this.txtPrimerApellido == null) {
			this.txtPrimerApellido = UtilComponentesGUI.getInstance().crearTextField(
					EnumDimensionesComponentes.TXT_MNT_TERC_INT_PRIMER_APELLIDO, "txtPrimerApellido", "", true, true,
					true, super.getEventoForma(), EnumEtiquetas.TXT_MNT_TERC_INT_PRIMER_APELLIDO);
			this.txtPrimerApellido.getPropiedades().setActivaMayusculaMinuscula(true);
			this.txtPrimerApellido.getPropiedades()
					.setControlFormatoIngreso(EnumExpresionesRegulares.INT_INGRESO_PRIMER_APELLIDO_TERCERO.getValor());
			// this.txtPrimerApellido.getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.EXP_REG_FORMATO_PRIMER_APELLIDO_TERCERO_FINAL.getValor());
			this.txtPrimerApellido.setToolTipText(EnumEtiquetas.TLT_CATI_PRIMER_APELLIDO);
		}

		return this.txtPrimerApellido;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @method iniciarPropTxtSegundoApellido Metodo estandar para autogestionar el
	 *         valor del atributo txtSegundoApellido
	 * @return CajaTextoUtil Caja de texto gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 4/3/2016
	 *       ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtSegundoApellido() throws Exception {
		if (this.txtSegundoApellido == null) {
			this.txtSegundoApellido = UtilComponentesGUI.getInstance().crearTextField(
					EnumDimensionesComponentes.TXT_MNT_TERC_INT_SEGUNDO_APELLIDO, "txtSegundoApellido", "", true, true,
					true, super.getEventoForma(), EnumEtiquetas.TXT_MNT_TERC_INT_SEGUNDO_APELLIDO);
			this.txtSegundoApellido.getPropiedades().setActivaMayusculaMinuscula(true);
			this.txtSegundoApellido.getPropiedades()
					.setControlFormatoIngreso(EnumExpresionesRegulares.INT_INGRESO_SEGUNDO_APELLIDO_TERCERO.getValor());
			// this.txtSegundoApellido.getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.EXP_REG_FORMATO_SEGUNDO_APELLIDO_TERCERO_FINAL.getValor());
			this.txtSegundoApellido.setToolTipText(EnumEtiquetas.TLT_CATI_SEGUNDO_APELLIDO);
		}

		return this.txtSegundoApellido;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @method iniciarPropTxtSegundoNombre Metodo estandar para autogestionar el
	 *         valor del atributo txtSegundoNombre
	 * @return CajaTextoUtil Caja de texto gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 4/3/2016
	 *       ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtSegundoNombre() throws Exception {
		if (this.txtSegundoNombre == null) {
			this.txtSegundoNombre = UtilComponentesGUI.getInstance().crearTextField(
					EnumDimensionesComponentes.TXT_MNT_TERC_INT_SEGUNDO_NOMBRE, "txtSegundoNombre", "", true, true,
					true, super.getEventoForma(), EnumEtiquetas.TXT_MNT_TERC_INT_SEGUNDO_NOMBRE);
			this.txtSegundoNombre.getPropiedades().setActivaMayusculaMinuscula(true);
			this.txtSegundoNombre.getPropiedades()
					.setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_NOMBRES_TERCERO.getValor());
			// this.txtSegundoNombre.getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.EXP_REG_FORMATO_NOMBRES_TERCERO_FINAL.getValor());
			this.txtSegundoNombre.setToolTipText(EnumEtiquetas.TLT_CATI_SEGUNDO_NOMBRE);
		}

		return this.txtSegundoNombre;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @method iniciarPropTxtCiudadNacimiento Metodo estandar para autogestionar el
	 *         valor del atributo txtCiudadNacimiento
	 * @return CajaTextoUtil Caja de texto gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 4/3/2016
	 *       ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtCiudadNacimiento() throws Exception {
		if (this.txtCiudadNacimiento == null) {
			this.txtCiudadNacimiento = UtilComponentesGUI.getInstance().crearTextField(
					EnumDimensionesComponentes.TXT_MNT_TERC_INT_CIUDAD_NACIMIENTO, "txtCiudadNacimiento", "", true,
					true, true, super.getEventoForma(), EnumEtiquetas.TXT_MNT_TERC_INT_CIUDAD_NACIMIENTO);
			this.txtCiudadNacimiento.getPropiedades().setActivaMayusculaMinuscula(true);
			this.txtCiudadNacimiento.getPropiedades()
					.setControlFormatoIngreso(EnumExpresionesRegulares.INT_INGRESO_CIUDAD_NACIMIENTO.getValor());
			this.txtCiudadNacimiento.setToolTipText(EnumEtiquetas.TLT_CATI_CIUDAD_NACIMIENTO);
		}

		return this.txtCiudadNacimiento;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @method iniciarPropTxtTelefonoFijoCelular Metodo estandar para autogestionar
	 *         el valor del atributo txtTelefonoFijoCelular
	 * @return CajaTextoUtil Caja de texto gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 4/3/2016
	 *       ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtTelefonoFijoCelular() throws Exception {
		if (this.txtTelefonoFijoCelular == null) {
			this.txtTelefonoFijoCelular = UtilComponentesGUI.getInstance().crearTextField(
					EnumDimensionesComponentes.TXT_MNT_TERC_INT_TELEFONO_FIJO_CELULAR, "txtTelefonoFijoCelular", "",
					true, true, true, super.getEventoForma(), EnumEtiquetas.LBL_MNT_TERC_INT_TELEFONO_FIJO_CELULAR);
			this.txtTelefonoFijoCelular.getPropiedades()
					.setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_INGRESO_TELEFONO.getValor());
			this.txtTelefonoFijoCelular.getPropiedades()
					.setControlFormatoFinal(EnumExpresionesRegulares.INT_TELEFONO_FIJO_CELULAR.getValor());
			this.txtTelefonoFijoCelular.setToolTipText(EnumEtiquetas.TLT_CATI_TELEFONO_CELULAR);
		}

		return this.txtTelefonoFijoCelular;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropDtcFechaNacimiento Metodo estandar para autogestionar el
	 *         valor del atributo dtcFechaNacimiento
	 * @return CajaFechaUtil Caja para fecha gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author hector.cuenca
	 * @date 20/03/2018
	 *       *********************************************************************
	 */
	public CajaFechaUtil iniciarPropDtcFechaNacimiento() throws Exception {

		if (this.dtcFechaNacimiento == null) {

			this.dtcFechaNacimiento = UtilComponentesGUI.getInstance().crearCalendar(
					EnumDimensionesComponentes.DTC_MNT_TERC_INT_FECHA_NACIMIENTO, "dtcFechaNacimiento", null, true,
					super.getEventoForma(), EnumEtiquetas.DTC_MNT_TERC_INT_FECHA_NACIMIENTO);

			this.dtcFechaNacimiento.setToolTipText(EnumEtiquetas.TLT_CATI_FECHA_NACIMIENTO);
		}

		return this.dtcFechaNacimiento;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropLblVlrIngresoMensual Metodo estandar para autogestionar el
	 *         valor del atributo lblVlrIngresoMensual
	 * @return EtiquetaUtil Etiqueta gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 16/04/2016
	 *       *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblVlrIngresoMensual() throws Exception {
		if (this.lblVlrIngresoMensual == null) {
			this.lblVlrIngresoMensual = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_MNT_TERC_INT_VLR_INGRESO_MENSUAL, "lblVlrIngresoMensual",
					EnumEtiquetas.LBL_MNT_TERC_INT_VLR_INGRESO_MENSUAL, true, null, true);
		}

		return this.lblVlrIngresoMensual;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropLblVlrEgresoMensualActivos Metodo estandar para
	 *         autogestionar el valor del atributo lblVlrEgresoMensualActivos
	 * @return EtiquetaUtil Etiqueta gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 16/04/2016
	 *       *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblVlrEgresoMensualActivos() throws Exception {
		if (this.lblVlrEgresoMensualActivos == null) {
			this.lblVlrEgresoMensualActivos = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_MNT_TERC_INT_VLR_EGRESO_MENSUAL_ACTIVOS,
					"lblVlrEgresoMensualActivos", EnumEtiquetas.LBL_MNT_TERC_INT_VLR_EGRESO_MENSUAL_ACTIVOS, true, null,
					true);
		}

		return this.lblVlrEgresoMensualActivos;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropLblVlrActivos Metodo estandar para autogestionar el valor
	 *         del atributo lblVlrActivos
	 * @return EtiquetaUtil Etiqueta gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 16/04/2016
	 *       *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblVlrActivos() throws Exception {
		if (this.lblVlrActivos == null) {
			this.lblVlrActivos = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_MNT_TERC_INT_VLR_ACTIVOS, "lblVlrActivos",
					EnumEtiquetas.LBL_MNT_TERC_INT_VLR_ACTIVOS, true, null, true);
		}

		return this.lblVlrActivos;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropLblVlrPasivos Metodo estandar para autogestionar el valor
	 *         del atributo lblVlrPasivos
	 * @return EtiquetaUtil Etiqueta gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 16/04/2016
	 *       *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblVlrPasivos() throws Exception {
		if (this.lblVlrPasivos == null) {
			this.lblVlrPasivos = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_MNT_TERC_INT_VLR_PASIVOS, "lblVlrPasivos",
					EnumEtiquetas.LBL_MNT_TERC_INT_VLR_PASIVOS, true, null, true);
		}

		return this.lblVlrPasivos;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @method iniciarPropTxtVlrIngresoMensual Metodo estandar para autogestionar el
	 *         valor del atributo txtVlrIngresoMensual
	 * @return CajaTextoUtil Caja de texto gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 16/04/2016
	 *       ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtVlrIngresoMensual() throws Exception {
		if (this.txtVlrIngresoMensual == null) {
			this.txtVlrIngresoMensual = UtilComponentesGUI.getInstance().crearTextField(
					EnumDimensionesComponentes.TXT_MNT_TERC_INT_VLR_INGRESO_MENSUAL, "txtVlrIngresoMensual", "", true,
					true, true, super.getEventoForma(), EnumEtiquetas.LBL_MNT_TERC_INT_VLR_INGRESO_MENSUAL);

			this.txtVlrIngresoMensual.setHorizontalAlignment(SwingConstants.TRAILING);
			this.txtVlrIngresoMensual.setToolTipText(EnumEtiquetas.TLT_CATI_INGRESO_MENSUAL);
		}

		return this.txtVlrIngresoMensual;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @method iniciarPropTxtVlrEgresoMensualActivos Metodo estandar para
	 *         autogestionar el valor del atributo txtVlrEgresoMensualActivos
	 * @return CajaTextoUtil Caja de texto gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 17/04/2016
	 *       ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtVlrEgresoMensualActivos() throws Exception {
		if (this.txtVlrEgresoMensualActivos == null) {
			this.txtVlrEgresoMensualActivos = UtilComponentesGUI.getInstance().crearTextField(
					EnumDimensionesComponentes.TXT_MNT_TERC_INT_VLR_EGRESO_MENSUAL_ACTIVOS,
					"txtVlrEgresoMensualActivos", "", true, true, true, super.getEventoForma(),
					EnumEtiquetas.LBL_MNT_TERC_INT_VLR_EGRESO_MENSUAL_ACTIVOS);

			this.txtVlrEgresoMensualActivos.setHorizontalAlignment(SwingConstants.TRAILING);
			this.txtVlrEgresoMensualActivos.setToolTipText(EnumEtiquetas.TLT_CATI_EGRESO_MENSUAL);
		}

		return this.txtVlrEgresoMensualActivos;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @method iniciarPropTxtVlrActivos Metodo estandar para autogestionar el valor
	 *         del atributo txtVlrActivos
	 * @return CajaTextoUtil Caja de texto gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 17/04/2016
	 *       ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtVlrActivos() throws Exception {
		if (this.txtVlrActivos == null) {
			this.txtVlrActivos = UtilComponentesGUI.getInstance().crearTextField(
					EnumDimensionesComponentes.TXT_MNT_TERC_INT_VLR_ACTIVOS, "txtVlrActivos", "", true, true, true,
					super.getEventoForma(), EnumEtiquetas.LBL_MNT_TERC_INT_VLR_ACTIVOS);

			this.txtVlrActivos.setHorizontalAlignment(SwingConstants.TRAILING);
			this.txtVlrActivos.setToolTipText(EnumEtiquetas.TLT_CATI_ACTIVOS);
		}

		return this.txtVlrActivos;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @method iniciarPropTxtVlrPasivos Metodo estandar para autogestionar el valor
	 *         del atributo txtVlrPasivos
	 * @return CajaTextoUtil Caja de texto gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 17/04/2016
	 *       ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtVlrPasivos() throws Exception {
		if (this.txtVlrPasivos == null) {
			this.txtVlrPasivos = UtilComponentesGUI.getInstance().crearTextField(
					EnumDimensionesComponentes.TXT_MNT_TERC_INT_VLR_PASIVOS, "txtVlrPasivos", "", true, true, true,
					super.getEventoForma(), EnumEtiquetas.LBL_MNT_TERC_INT_VLR_PASIVOS);

			this.txtVlrPasivos.setHorizontalAlignment(SwingConstants.TRAILING);
			this.txtVlrPasivos.setToolTipText(EnumEtiquetas.TLT_CATI_PASIVOS);
		}

		return this.txtVlrPasivos;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropLblActvEconomicas Metodo estandar para autogestionar el
	 *         valor del atributo lblActvEconomicas
	 * @return EtiquetaUtil Etiqueta gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 16/04/2016
	 *       *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblActvEconomicas() throws Exception {
		if (this.lblActvEconomicas == null) {
			this.lblActvEconomicas = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_MNT_TERC_INT_ACTV_ECONOMICAS, "lblActvEconomicas",
					EnumEtiquetas.LBL_MNT_TERC_INT_ACTV_ECONOMICAS, true, null, true);
		}

		return this.lblActvEconomicas;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropLblProfesion Metodo estandar para autogestionar el valor
	 *         del atributo lblProfesion
	 * @return EtiquetaUtil Etiqueta gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 16/04/2016
	 *       *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblProfesion() throws Exception {
		if (this.lblProfesion == null) {
			this.lblProfesion = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_MNT_TERC_INT_PROFESION, "lblProfesion",
					EnumEtiquetas.LBL_MNT_TERC_INT_PROFESION, true, null, true);
		}

		return this.lblProfesion;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropCmbActvEconomicas Metodo estandar para autogestionar el
	 *         valor del atributo cmbActvEconomicas
	 * @return CajaComboUtil Lista de valores gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 17/04/2018
	 *       *********************************************************************
	 */
	public CajaComboUtil iniciarPropCmbActvEconomicas() throws Exception {

		if (this.cmbActvEconomicas == null) {

			this.cmbActvEconomicas = UtilComponentesGUI.getInstance().crearComboBox(
					EnumDimensionesComponentes.CMB_MNT_TERC_INT_ACTV_ECONOMICAS, "cmbActvEconomicas", true, true,
					this.getEventoForma(), EnumEtiquetas.LBL_MNT_TERC_INT_ACTV_ECONOMICAS);
		}

		return this.cmbActvEconomicas;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropCmbProfesion Metodo estandar para autogestionar el valor
	 *         del atributo cmbProfesion
	 * @return CajaComboUtil Lista de valores gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 17/04/2018
	 *       *********************************************************************
	 */
	public CajaComboUtil iniciarPropCmbProfesion() throws Exception {

		if (this.cmbProfesion == null) {

			this.cmbProfesion = UtilComponentesGUI.getInstance().crearComboBox(
					EnumDimensionesComponentes.CMB_MNT_TERC_INT_PROFESION, "cmbProfesion", true, true,
					this.getEventoForma(), EnumEtiquetas.LBL_MNT_TERC_INT_PROFESION);
		}

		return this.cmbProfesion;
	}

	/**
	 * ****************************************************************
	 * 
	 * @method iniciarPropBtnEmpresaSocEcono metodo utilizado para inicializar el
	 *         componente BotonUtil para ver info empresa
	 * @return BotonUtil componente BotonUtil
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 03/05/2018
	 *       ****************************************************************
	 */
	public BotonUtil iniciarPropBtnEmpresaSocEcono() throws Exception {

		if (this.btnEmpresaSocEcono == null) {
			this.btnEmpresaSocEcono = UtilComponentesGUI.getInstance().crearBoton(
					EnumDimensionesComponentes.BTN_MNT_TERC_INT_EMPRESA_SOC_ECONO, "btnEmpresaSocEcono",
					EnumEtiquetas.BTN_MNT_TERC_INT_EMPRESA_SOC_ECONO, true, true, super.getEventoForma(), null);

			this.btnEmpresaSocEcono.setBorder(BorderFactory.createEmptyBorder());
			this.btnEmpresaSocEcono.setToolTipText(EnumEtiquetas.TLT_CATI_BTN_EMPRESA);
		}

		return this.btnEmpresaSocEcono;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropLblOperMonedaExtranjera Metodo estandar para autogestionar
	 *         el valor del atributo lblOperMonedaExtranjera
	 * @return EtiquetaUtil Etiqueta gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 17/04/2016
	 *       *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblOperMonedaExtranjera() throws Exception {
		if (this.lblOperMonedaExtranjera == null) {
			this.lblOperMonedaExtranjera = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_MNT_TERC_INT_OPER_MONEDA_EXTRANJERA, "lblOperMonedaExtranjera",
					EnumEtiquetas.LBL_MNT_TERC_INT_OPER_MONEDA_EXTRANJERA, true, null, true);
		}

		return this.lblOperMonedaExtranjera;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropLblVlrIngresoOperMonExtr Metodo estandar para
	 *         autogestionar el valor del atributo lblVlrIngresoOperMonExtr
	 * @return EtiquetaUtil Etiqueta gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 17/04/2016
	 *       *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblVlrIngresoOperMonExtr() throws Exception {
		if (this.lblVlrIngresoOperMonExtr == null) {
			this.lblVlrIngresoOperMonExtr = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_MNT_TERC_INT_VALOR_INGRESO, "lblVlrIngresoOperMonExtr",
					EnumEtiquetas.LBL_MNT_TERC_INT_VALOR_INGRESO, true, null, true);
		}

		return this.lblVlrIngresoOperMonExtr;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropLblMonedaExtranjera Metodo estandar para autogestionar el
	 *         valor del atributo lblMonedaExtranjera
	 * @return EtiquetaUtil Etiqueta gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 17/04/2016
	 *       *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblMonedaExtranjera() throws Exception {
		if (this.lblMonedaExtranjera == null) {
			this.lblMonedaExtranjera = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_MNT_TERC_INT_MONEDA_EXTRANJERA, "lblMonedaExtranjera",
					EnumEtiquetas.LBL_MNT_TERC_INT_MONEDA_EXTRANJERA, true, null, true);
		}

		return this.lblMonedaExtranjera;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropLblEntidadExtranjera Metodo estandar para autogestionar el
	 *         valor del atributo lblEntidadExtranjera
	 * @return EtiquetaUtil Etiqueta gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 17/04/2016
	 *       *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblEntidadExtranjera() throws Exception {
		if (this.lblEntidadExtranjera == null) {
			this.lblEntidadExtranjera = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_MNT_TERC_INT_ENTIDAD_EXTRANJERA, "lblEntidadExtranjera",
					EnumEtiquetas.LBL_MNT_TERC_INT_ENTIDAD_EXTRANJERA, true, null, true);
		}

		return this.lblEntidadExtranjera;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropLblNumProductoExtranjera Metodo estandar para
	 *         autogestionar el valor del atributo lblNumProductoExtranjera
	 * @return EtiquetaUtil Etiqueta gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 17/04/2016
	 *       *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblNumProductoExtranjera() throws Exception {
		if (this.lblNumProductoExtranjera == null) {
			this.lblNumProductoExtranjera = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_MNT_TERC_INT_NUMERO_PRODUCTO_EXT, "lblNumProductoExtranjera",
					EnumEtiquetas.LBL_MNT_TERC_INT_NUMERO_PRODUCTO_EXT, true, null, true);
		}

		return this.lblNumProductoExtranjera;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropCmbManejaOperMonedaExtranjera Metodo estandar para
	 *         autogestionar el valor del atributo cmbManejaOperMonedaExtranjera
	 * @return CajaComboUtil Lista de valores gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 17/04/2018
	 *       *********************************************************************
	 */
	public CajaComboUtil iniciarPropCmbManejaOperMonedaExtranjera() throws Exception {

		if (this.cmbManejaOperMonedaExtranjera == null) {

			this.cmbManejaOperMonedaExtranjera = UtilComponentesGUI.getInstance().crearComboBox(
					EnumDimensionesComponentes.CMB_MNT_TERC_INT_MANEJA_OPER_MONEDA_EXTR,
					"cmbManejaOperMonedaExtranjera", true, true, this.getEventoForma(),
					EnumEtiquetas.LBL_MNT_TERC_INT_OPER_MONEDA_EXTRANJERA);
		}

		return this.cmbManejaOperMonedaExtranjera;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropCmbOperacionesMonedaExtranjera Metodo estandar para
	 *         autogestionar el valor del atributo cmbOperacionesMonedaExtranjera
	 * @return CajaComboUtil Lista de valores gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 17/04/2018
	 *       *********************************************************************
	 */
	public CajaComboUtil iniciarPropCmbOperacionesMonedaExtranjera() throws Exception {

		if (this.cmbOperacionesMonedaExtranjera == null) {

			this.cmbOperacionesMonedaExtranjera = UtilComponentesGUI.getInstance().crearComboBox(
					EnumDimensionesComponentes.CMB_MNT_TERC_INT_OPERACIONES_MONEDA_EXTR,
					"cmbOperacionesMonedaExtranjera", true, true, this.getEventoForma(),
					EnumEtiquetas.LBL_MNT_TERC_INT_OPER_MONEDA_EXTRANJERA);
		}

		return this.cmbOperacionesMonedaExtranjera;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @method iniciarPropTxtValorIngresoExt Metodo estandar para autogestionar el
	 *         valor del atributo txtValorIngresoExt
	 * @return CajaTextoUtil Caja de texto gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 17/04/2016
	 *       ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtValorIngresoExt() throws Exception {
		if (this.txtValorIngresoExt == null) {
			this.txtValorIngresoExt = UtilComponentesGUI.getInstance().crearTextField(
					EnumDimensionesComponentes.TXT_MNT_TERC_INT_VLR_INGRESO_EXTR, "txtValorIngresoExt", "", true, true,
					true, super.getEventoForma(), EnumEtiquetas.LBL_MNT_TERC_INT_VALOR_INGRESO);

			this.txtValorIngresoExt.setToolTipText(EnumEtiquetas.TLT_CATI_VALOR_INGRESOS);
			this.txtValorIngresoExt.setHorizontalAlignment(SwingConstants.TRAILING);
		}

		return this.txtValorIngresoExt;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropCmbMonedaExtranjera Metodo estandar para autogestionar el
	 *         valor del atributo cmbMonedaExtranjera
	 * @return CajaComboUtil Lista de valores gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 17/04/2018
	 *       *********************************************************************
	 */
	public CajaComboUtil iniciarPropCmbMonedaExtranjera() throws Exception {

		if (this.cmbMonedaExtranjera == null) {

			this.cmbMonedaExtranjera = UtilComponentesGUI.getInstance().crearComboBox(
					EnumDimensionesComponentes.CMB_MNT_TERC_INT_MONEDA_EXTRANJERA, "cmbMonedaExtranjera", true, true,
					this.getEventoForma(), EnumEtiquetas.LBL_MNT_TERC_INT_OPER_MONEDA_EXTRANJERA);
		}

		return this.cmbMonedaExtranjera;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @method iniciarPropTxtEntidadExtranjera Metodo estandar para autogestionar el
	 *         valor del atributo txtEntidadExtranjera
	 * @return CajaTextoUtil Caja de texto gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 17/04/2016
	 *       ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtEntidadExtranjera() throws Exception {
		if (this.txtEntidadExtranjera == null) {
			this.txtEntidadExtranjera = UtilComponentesGUI.getInstance().crearTextField(
					EnumDimensionesComponentes.TXT_MNT_TERC_INT_ENTIDAD_EXTRANJERA, "txtEntidadExtranjera", "", true,
					true, true, super.getEventoForma(), EnumEtiquetas.LBL_MNT_TERC_INT_ENTIDAD_EXTRANJERA);

			this.txtEntidadExtranjera.setToolTipText(EnumEtiquetas.TLT_CATI_ENTIDAD);
		}

		return this.txtEntidadExtranjera;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @method iniciarPropTxtNumProductoExtranjera Metodo estandar para
	 *         autogestionar el valor del atributo txtNumProductoExtranjera
	 * @return CajaTextoUtil Caja de texto gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 17/04/2016
	 *       ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtNumProductoExtranjera() throws Exception {
		if (this.txtNumProductoExtranjera == null) {
			this.txtNumProductoExtranjera = UtilComponentesGUI.getInstance().crearTextField(
					EnumDimensionesComponentes.TXT_MNT_TERC_INT_NUMERO_PRODUCTO, "txtNumProductoExtranjera", "", true,
					true, true, super.getEventoForma(), EnumEtiquetas.LBL_MNT_TERC_INT_NUMERO_PRODUCTO_EXT);

			this.txtNumProductoExtranjera.setToolTipText(EnumEtiquetas.TLT_CATI_NRO_PRODUCTO);
		}

		return this.txtNumProductoExtranjera;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropLblFechaExpedicion Metodo estandar para autogestionar el
	 *         valor del atributo lblFechaExpedicion
	 * @return EtiquetaUtil Etiqueta gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 18/04/2016
	 *       *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblFechaExpedicion() throws Exception {
		if (this.lblFechaExpedicion == null) {
			this.lblFechaExpedicion = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_MNT_TERC_INT_FECHA_EXPEDICION, "lblFechaExpedicion",
					EnumEtiquetas.LBL_MNT_TERC_INT_FECHA_EXPEDICION, true, null, true);
		}

		return this.lblFechaExpedicion;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropLblCiudadExpedicion Metodo estandar para autogestionar el
	 *         valor del atributo lblCiudadExpedicion
	 * @return EtiquetaUtil Etiqueta gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 18/04/2016
	 *       *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblCiudadExpedicion() throws Exception {
		if (this.lblCiudadExpedicion == null) {
			this.lblCiudadExpedicion = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_MNT_TERC_INT_CIUDAD_EXPEDICION, "lblCiudadExpedicion",
					EnumEtiquetas.LBL_MNT_TERC_INT_CIUDAD_EXPEDICION, true, null, true);
		}

		return this.lblCiudadExpedicion;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropDtcFechaExpedicion Metodo estandar para autogestionar el
	 *         valor del atributo dtcFechaExpedicion
	 * @return CajaFechaUtil Caja para fecha gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 18/04/2016
	 *       *********************************************************************
	 */
	public CajaFechaUtil iniciarPropDtcFechaExpedicion() throws Exception {

		if (this.dtcFechaExpedicion == null) {

			this.dtcFechaExpedicion = UtilComponentesGUI.getInstance().crearCalendar(
					EnumDimensionesComponentes.DTC_MNT_TERC_INT_FECHA_EXPEDICION, "dtcFechaExpedicion", null, true,
					super.getEventoForma(), EnumEtiquetas.DTC_MNT_TERC_INT_FECHA_EXPEDICION);

			this.dtcFechaExpedicion.setToolTipText(EnumEtiquetas.TLT_CATI_FECHA_EXPEDICION);
		}

		return this.dtcFechaExpedicion;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @method iniciarPropTxtCiudadExpedicion Metodo estandar para autogestionar el
	 *         valor del atributo txtCiudadExpedicion
	 * @return CajaTextoUtil Caja de texto gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 18/04/2017
	 *       ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtCiudadExpedicion() throws Exception {
		if (this.txtCiudadExpedicion == null) {
			this.txtCiudadExpedicion = UtilComponentesGUI.getInstance().crearTextField(
					EnumDimensionesComponentes.TXT_MNT_TERC_INT_CIUDAD_EXPEDICION, "txtCiudadExpedicion", "", true,
					true, true, super.getEventoForma(), EnumEtiquetas.TXT_MNT_TERC_INT_CIUDAD_EXPEDICION);
			this.txtCiudadExpedicion.getPropiedades().setActivaMayusculaMinuscula(true);
			// this.txtCiudadExpedicion.getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.INT_INGRESO_CIUDAD_NACIMIENTO.getValor());
			this.txtCiudadExpedicion.setToolTipText(EnumEtiquetas.TLT_CATI_CIUDAD_EXPEDICION);
		}

		return this.txtCiudadExpedicion;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropLblPEPS Metodo estandar para autogestionar el valor del
	 *         atributo lblPEPS
	 * @return EtiquetaUtil Etiqueta gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 18/04/2016
	 *       *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblPEPS() throws Exception {
		if (this.lblPEPS == null) {
			this.lblPEPS = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_MNT_TERC_INT_PEPS,
					"lblPEPS", EnumEtiquetas.LBL_MNT_TERC_INT_PEPS, true, null, true);
		}

		return this.lblPEPS;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropCmbPEPS Metodo estandar para autogestionar el valor del
	 *         atributo cmbPEPS
	 * @return CajaComboUtil Lista de valores gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 19/04/2018
	 *       *********************************************************************
	 */
	public CajaComboUtil iniciarPropCmbPEPS() throws Exception {

		if (this.cmbPEPS == null) {

			this.cmbPEPS = UtilComponentesGUI.getInstance().crearComboBox(
					EnumDimensionesComponentes.CMB_MNT_TERC_INT_PEPS, "cmbPEPS", true, true, this.getEventoForma(),
					EnumEtiquetas.LBL_MNT_TERC_INT_PEPS);
		}

		return this.cmbPEPS;
	}

	/**
	 * ****************************************************************
	 * 
	 * @method iniciarPropBtnVerInfoPEPS metodo utilizado para inicializar el
	 *         componente BotonUtil para ver info peps
	 * @return BotonUtil componente BotonUtil
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 19/04/2018
	 *       ****************************************************************
	 */
	public BotonUtil iniciarPropBtnVerInfoPEPS() throws Exception {

		if (this.btnVerInfoPEPS == null) {
			this.btnVerInfoPEPS = UtilComponentesGUI.getInstance().crearBoton(
					EnumDimensionesComponentes.BTN_MNT_TERC_INT_VER_PEPS, "btnVerInfoPEPS",
					EnumEtiquetas.BTN_MNT_TERC_INT_VER_PEPS, true, true, super.getEventoForma(), null);

			this.btnVerInfoPEPS.setBorder(BorderFactory.createEmptyBorder());
			this.btnVerInfoPEPS.setToolTipText(EnumEtiquetas.TLT_CATI_BTN_PEPS);

		}

		return this.btnVerInfoPEPS;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropLblVlrOtrosIngresos Metodo estandar para autogestionar el
	 *         valor del atributo lblVlrOtrosIngresos
	 * @return EtiquetaUtil Etiqueta gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 19/04/2016
	 *       *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblVlrOtrosIngresos() throws Exception {
		if (this.lblVlrOtrosIngresos == null) {
			this.lblVlrOtrosIngresos = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_MNT_TERC_INT_VLR_OTROS_INGRESOS, "lblVlrOtrosIngresos",
					EnumEtiquetas.LBL_MNT_TERC_INT_VLR_OTROS_INGRESOS, true, null, true);
		}

		return this.lblVlrOtrosIngresos;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @method iniciarPropTxtVlrOtrosIngresos Metodo estandar para autogestionar el
	 *         valor del atributo txtVlrOtrosIngresos
	 * @return CajaTextoUtil Caja de texto gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 19/04/2017
	 *       ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtVlrOtrosIngresos() throws Exception {
		if (this.txtVlrOtrosIngresos == null) {
			this.txtVlrOtrosIngresos = UtilComponentesGUI.getInstance().crearTextField(
					EnumDimensionesComponentes.TXT_MNT_TERC_INT_VLR_OTROS_INGRESOS, "txtVlrOtrosIngresos", "", true,
					true, true, super.getEventoForma(), EnumEtiquetas.LBL_MNT_TERC_INT_VLR_OTROS_INGRESOS);
			this.txtVlrOtrosIngresos.getPropiedades().setActivaMayusculaMinuscula(true);
			this.txtVlrOtrosIngresos.setHorizontalAlignment(SwingConstants.TRAILING);
			this.txtVlrOtrosIngresos.setToolTipText(EnumEtiquetas.TLT_CATI_VALOR_OTROS_INGRESOS);
		}

		return this.txtVlrOtrosIngresos;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropLblVlrDetalleOtrosIngresos Metodo estandar para
	 *         autogestionar el valor del atributo lblVlrDetalleOtrosIngresos
	 * @return EtiquetaUtil Etiqueta gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 19/04/2016
	 *       *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblVlrDetalleOtrosIngresos() throws Exception {
		if (this.lblVlrDetalleOtrosIngresos == null) {
			this.lblVlrDetalleOtrosIngresos = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_MNT_TERC_INT_DETALLE_OTROS_INGRESOS, "lblVlrDetalleOtrosIngresos",
					EnumEtiquetas.LBL_MNT_TERC_INT_DETALLE_OTROS_INGRESOS, true, null, true);
		}

		return this.lblVlrDetalleOtrosIngresos;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @method iniciarPropTxtDetaVlrOtrosIngresos Metodo estandar para autogestionar
	 *         el valor del atributo txtDetaVlrOtrosIngresos
	 * @return CajaTextoUtil Caja de texto gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 19/04/2017
	 *       ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtDetaVlrOtrosIngresos() throws Exception {
		if (this.txtDetaVlrOtrosIngresos == null) {
			this.txtDetaVlrOtrosIngresos = UtilComponentesGUI.getInstance().crearTextField(
					EnumDimensionesComponentes.TXT_MNT_TERC_INT_DETALLE_OTROS_INGRESOS, "txtDetaVlrOtrosIngresos", "",
					true, false, true, super.getEventoForma(), EnumEtiquetas.LBL_MNT_TERC_INT_DETALLE_OTROS_INGRESOS);
			this.txtDetaVlrOtrosIngresos.getPropiedades().setActivaMayusculaMinuscula(true);
			this.txtDetaVlrOtrosIngresos.setHorizontalAlignment(SwingConstants.TRAILING);
			this.txtDetaVlrOtrosIngresos.setToolTipText(EnumEtiquetas.TLT_CATI_DETALLE_OTROS_INGRESOS);
		}

		return this.txtDetaVlrOtrosIngresos;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropLblNombreEmpresa Metodo estandar para autogestionar el
	 *         valor del atributo lblNombreEmpresa
	 * @return EtiquetaUtil Etiqueta gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 03/05/2018
	 *       *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblNombreEmpresa() throws Exception {
		if (this.lblNombreEmpresa == null) {
			this.lblNombreEmpresa = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_MNT_TERC_INT_NOMBRE_EMPRESA_DATADD, "lblNombreEmpresa",
					EnumEtiquetas.LBL_MNT_TERC_INT_NOMBRE_EMPRESA_DATADD, true, null, true);
		}

		return this.lblNombreEmpresa;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @method iniciarPropTxtNombreEmpresa Metodo estandar para autogestionar el
	 *         valor del atributo txtNombreEmpresa
	 * @return CajaTextoUtil Caja de texto gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 03/05/2017
	 *       ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtNombreEmpresa() throws Exception {
		if (this.txtNombreEmpresa == null) {
			this.txtNombreEmpresa = UtilComponentesGUI.getInstance().crearTextField(
					EnumDimensionesComponentes.TXT_MNT_TERC_INT_NOMBRE_EMPRESA_DATADD, "txtNombreEmpresa", "", true,
					true, true, super.getEventoForma(), EnumEtiquetas.LBL_MNT_TERC_INT_NOMBRE_EMPRESA_DATADD);
			this.txtNombreEmpresa.getPropiedades().setActivaMayusculaMinuscula(true);
		}

		return this.txtNombreEmpresa;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropLblDireccionEmpresa Metodo estandar para autogestionar el
	 *         valor del atributo lblDireccionEmpresa
	 * @return EtiquetaUtil Etiqueta gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 03/05/2018
	 *       *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblDireccionEmpresa() throws Exception {
		if (this.lblDireccionEmpresa == null) {
			this.lblDireccionEmpresa = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_MNT_TERC_INT_DIRECCION_EMPRESA_DATADD, "lblDireccionEmpresa",
					EnumEtiquetas.LBL_MNT_TERC_INT_DIRECCION_EMPRESA_DATADD, true, null, true);
		}

		return this.lblDireccionEmpresa;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @method iniciarPropTxtDireccionEmpresa Metodo estandar para autogestionar el
	 *         valor del atributo txtDireccionEmpresa
	 * @return CajaTextoUtil Caja de texto gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 03/05/2017
	 *       ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtDireccionEmpresa() throws Exception {
		if (this.txtDireccionEmpresa == null) {
			this.txtDireccionEmpresa = UtilComponentesGUI.getInstance().crearTextField(
					EnumDimensionesComponentes.TXT_MNT_TERC_INT_DIRECCION_EMPRESA_DATADD, "txtDireccionEmpresa", "",
					true, true, true, super.getEventoForma(), EnumEtiquetas.LBL_MNT_TERC_INT_DIRECCION_EMPRESA_DATADD);
			this.txtDireccionEmpresa.getPropiedades().setActivaMayusculaMinuscula(true);
		}

		return this.txtDireccionEmpresa;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropLblTelefonoEmpresa Metodo estandar para autogestionar el
	 *         valor del atributo lblTelefonoEmpresa
	 * @return EtiquetaUtil Etiqueta gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 03/05/2018
	 *       *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblTelefonoEmpresa() throws Exception {
		if (this.lblTelefonoEmpresa == null) {
			this.lblTelefonoEmpresa = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_MNT_TERC_INT_TELEFONO_EMPRESA_DATADD, "lblTelefonoEmpresa",
					EnumEtiquetas.LBL_MNT_TERC_INT_TELEFONO_EMPRESA_DATADD, true, null, true);
		}

		return this.lblTelefonoEmpresa;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @method iniciarPropTxtTelefonoEmpresa Metodo estandar para autogestionar el
	 *         valor del atributo txtDireccionEmpresa
	 * @return CajaTextoUtil Caja de texto gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 03/05/2017
	 *       ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtTelefonoEmpresa() throws Exception {
		if (this.txtTelefonoEmpresa == null) {
			this.txtTelefonoEmpresa = UtilComponentesGUI.getInstance().crearTextField(
					EnumDimensionesComponentes.TXT_MNT_TERC_INT_TELEFONO_EMPRESA_DATADD, "txtTelefonoEmpresa", "", true,
					true, true, super.getEventoForma(), EnumEtiquetas.LBL_MNT_TERC_INT_TELEFONO_EMPRESA_DATADD);
			this.txtTelefonoEmpresa.getPropiedades().setActivaMayusculaMinuscula(true);
		}

		return this.txtTelefonoEmpresa;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropLblCiudadEmpresa Metodo estandar para autogestionar el
	 *         valor del atributo lblCiudadEmpresa
	 * @return EtiquetaUtil Etiqueta gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 03/05/2018
	 *       *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblCiudadEmpresa() throws Exception {
		if (this.lblCiudadEmpresa == null) {
			this.lblCiudadEmpresa = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_MNT_TERC_INT_CIUDAD_EMPRESA_DATADD, "lblCiudadEmpresa",
					EnumEtiquetas.LBL_MNT_TERC_INT_CIUDAD_EMPRESA_DATADD, true, null, true);
		}

		return this.lblCiudadEmpresa;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @method iniciarPropTxtCiudadEmpresa Metodo estandar para autogestionar el
	 *         valor del atributo txtCiudadEmpresa
	 * @return CajaTextoUtil Caja de texto gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 03/05/2017
	 *       ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtCiudadEmpresa() throws Exception {
		if (this.txtCiudadEmpresa == null) {
			this.txtCiudadEmpresa = UtilComponentesGUI.getInstance().crearTextField(
					EnumDimensionesComponentes.TXT_MNT_TERC_INT_CIUDAD_EMPRESA_DATADD, "txtCiudadEmpresa", "", true,
					true, true, super.getEventoForma(), EnumEtiquetas.LBL_MNT_TERC_INT_CIUDAD_EMPRESA_DATADD);
			this.txtCiudadEmpresa.getPropiedades().setActivaMayusculaMinuscula(true);
		}

		return this.txtCiudadEmpresa;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method iniciarPropLblCargoEmpresa Metodo estandar para autogestionar el
	 *         valor del atributo lblCargoEmpresa
	 * @return EtiquetaUtil Etiqueta gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 03/05/2018
	 *       *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblCargoEmpresa() throws Exception {
		if (this.lblCargoEmpresa == null) {
			this.lblCargoEmpresa = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_MNT_TERC_INT_CARGO_EMPRESA_DATADD, "lblCargoEmpresa",
					EnumEtiquetas.LBL_MNT_TERC_INT_CARGO_EMPRESA_DATADD, true, null, true);
		}

		return this.lblCargoEmpresa;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @method iniciarPropTxtCargoEmpresa Metodo estandar para autogestionar el
	 *         valor del atributo txtCargoEmpresa
	 * @return CajaTextoUtil Caja de texto gestionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author roberth.martinez
	 * @date 03/05/2017
	 *       ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtCargoEmpresa() throws Exception {
		if (this.txtCargoEmpresa == null) {
			this.txtCargoEmpresa = UtilComponentesGUI.getInstance().crearTextField(
					EnumDimensionesComponentes.TXT_MNT_TERC_INT_CARGO_EMPRESA_DATADD, "txtCargoEmpresa", "", true, true,
					true, super.getEventoForma(), EnumEtiquetas.LBL_MNT_TERC_INT_CARGO_EMPRESA_DATADD);
			this.txtCargoEmpresa.getPropiedades().setActivaMayusculaMinuscula(true);
		}

		return this.txtCargoEmpresa;
	}

	/**
	 * @method getPnlInfoDocumento Metodo get del atributo pnlInfoDocumento
	 * @return SeccionUtil Valor del atributo pnlInfoDocumento devuelto
	 * @author hector.cuenca
	 * @date 20/03/2018
	 */
	public SeccionUtil getPnlInfoDocumento() {
		return pnlInfoDocumento;
	}

	/**
	 * @method setPnlInfoDocumento Metodo set del atributo pnlInfoDocumento
	 * @param pPnlInfoDocumento
	 *            Valor que tomara el atributo pnlInfoDocumento
	 * @author hector.cuenca
	 * @date 20/03/2018
	 */
	public void setPnlInfoDocumento(SeccionUtil pPnlInfoDocumento) {
		this.pnlInfoDocumento = pPnlInfoDocumento;
	}

	/**
	 * @method getLblDocumento Metodo get del atributo lblDocumento
	 * @return EtiquetaUtil Valor del atributo lblDocumento devuelto
	 * @author hector.cuenca
	 * @date 20/03/2018
	 */
	public EtiquetaUtil getLblDocumento() {
		return lblDocumento;
	}

	/**
	 * @method setLblDocumento Metodo set del atributo lblDocumento
	 * @param pLblDocumento
	 *            Valor que tomara el atributo lblDocumento
	 * @author hector.cuenca
	 * @date 20/03/2018
	 */
	public void setLblDocumento(EtiquetaUtil pLblDocumento) {
		this.lblDocumento = pLblDocumento;
	}

	/**
	 * @method getCmbTipoDocumento Metodo get del atributo cmbTipoDocumento
	 * @return CajaComboUtil Valor del atributo cmbTipoDocumento devuelto
	 * @author hector.cuenca
	 * @date 20/03/2018
	 */
	public CajaComboUtil getCmbTipoDocumento() {
		return cmbTipoDocumento;
	}

	/**
	 * @method setCmbTipoDocumento Metodo set del atributo cmbTipoDocumento
	 * @param pCmbTipoDocumento
	 *            Valor que tomara el atributo cmbTipoDocumento
	 * @author hector.cuenca
	 * @date 20/03/2018
	 */
	public void setCmbTipoDocumento(CajaComboUtil pCmbTipoDocumento) {
		this.cmbTipoDocumento = pCmbTipoDocumento;
	}

	/**
	 * @method getTxtDocumento Metodo get del atributo txtDocumento
	 * @return CajaTextoUtil Valor del atributo txtDocumento devuelto
	 * @author hector.cuenca
	 * @date 20/03/2018
	 */
	public CajaTextoUtil getTxtDocumento() {
		return txtDocumento;
	}

	/**
	 * @method setTxtDocumento Metodo set del atributo txtDocumento
	 * @param pTxtDocumento
	 *            Valor que tomara el atributo txtDocumento
	 * @author hector.cuenca
	 * @date 20/03/2018
	 */
	public void setTxtDocumento(CajaTextoUtil pTxtDocumento) {
		this.txtDocumento = pTxtDocumento;
	}

	/**
	 * @method getLblNombres Metodo get del atributo lblNombres
	 * @return EtiquetaUtil Valor del atributo lblNombres devuelto
	 * @author hector.cuenca
	 * @date 20/03/2018
	 */
	public EtiquetaUtil getLblNombres() {
		return lblNombres;
	}

	/**
	 * @method setLblNombres Metodo set del atributo lblNombres
	 * @param pLblNombres
	 *            Valor que tomara el atributo lblNombres
	 * @author hector.cuenca
	 * @date 20/03/2018
	 */
	public void setLblNombres(EtiquetaUtil pLblNombres) {
		this.lblNombres = pLblNombres;
	}

	/**
	 * @method getTxtPrimerNombre Metodo get del atributo txtPrimerNombre
	 * @return CajaTextoUtil Valor del atributo txtPrimerNombre devuelto
	 * @author hector.cuenca
	 * @date 20/03/2018
	 */
	public CajaTextoUtil getTxtPrimerNombre() {
		return txtPrimerNombre;
	}

	/**
	 * @method setTxtPrimerNombre Metodo set del atributo txtPrimerNombre
	 * @param pTxtPrimerNombre
	 *            Valor que tomara el atributo txtPrimerNombre
	 * @author hector.cuenca
	 * @date 20/03/2018
	 */
	public void setTxtPrimerNombre(CajaTextoUtil pTxtPrimerNombre) {
		this.txtPrimerNombre = pTxtPrimerNombre;
	}

	/**
	 * @method getTxtSegundoNombre Metodo get del atributo txtSegundoNombre
	 * @return CajaTextoUtil Valor del atributo txtSegundoNombre devuelto
	 * @author hector.cuenca
	 * @date 20/03/2018
	 */
	public CajaTextoUtil getTxtSegundoNombre() {
		return txtSegundoNombre;
	}

	/**
	 * @method setTxtSegundoNombre Metodo set del atributo txtSegundoNombre
	 * @param pTxtSegundoNombre
	 *            Valor que tomara el atributo txtSegundoNombre
	 * @author hector.cuenca
	 * @date 20/03/2018
	 */
	public void setTxtSegundoNombre(CajaTextoUtil pTxtSegundoNombre) {
		this.txtSegundoNombre = pTxtSegundoNombre;
	}

	/**
	 * @method getLblApellidos Metodo get del atributo lblApellidos
	 * @return EtiquetaUtil Valor del atributo lblApellidos devuelto
	 * @author hector.cuenca
	 * @date 20/03/2018
	 */
	public EtiquetaUtil getLblApellidos() {
		return lblApellidos;
	}

	/**
	 * @method setLblApellidos Metodo set del atributo lblApellidos
	 * @param pLblApellidos
	 *            Valor que tomara el atributo lblApellidos
	 * @author hector.cuenca
	 * @date 20/03/2018
	 */
	public void setLblApellidos(EtiquetaUtil pLblApellidos) {
		this.lblApellidos = pLblApellidos;
	}

	/**
	 * @method getTxtPrimerApellido Metodo get del atributo txtPrimerApellido
	 * @return CajaTextoUtil Valor del atributo txtPrimerApellido devuelto
	 * @author hector.cuenca
	 * @date 20/03/2018
	 */
	public CajaTextoUtil getTxtPrimerApellido() {
		return txtPrimerApellido;
	}

	/**
	 * @method setTxtPrimerApellido Metodo set del atributo txtPrimerApellido
	 * @param pTxtPrimerApellido
	 *            Valor que tomara el atributo txtPrimerApellido
	 * @author hector.cuenca
	 * @date 20/03/2018
	 */
	public void setTxtPrimerApellido(CajaTextoUtil pTxtPrimerApellido) {
		this.txtPrimerApellido = pTxtPrimerApellido;
	}

	/**
	 * @method getTxtSegundoApellido Metodo get del atributo txtSegundoApellido
	 * @return CajaTextoUtil Valor del atributo txtSegundoApellido devuelto
	 * @author hector.cuenca
	 * @date 20/03/2018
	 */
	public CajaTextoUtil getTxtSegundoApellido() {
		return txtSegundoApellido;
	}

	/**
	 * @method setTxtSegundoApellido Metodo set del atributo txtSegundoApellido
	 * @param pTxtSegundoApellido
	 *            Valor que tomara el atributo txtSegundoApellido
	 * @author hector.cuenca
	 * @date 20/03/2018
	 */
	public void setTxtSegundoApellido(CajaTextoUtil pTxtSegundoApellido) {
		this.txtSegundoApellido = pTxtSegundoApellido;
	}

	/**
	 * @method getPnlNacimiento Metodo get del atributo pnlNacimiento
	 * @return SeccionUtil Valor del atributo pnlNacimiento devuelto
	 * @author hector.cuenca
	 * @date 20/03/2018
	 */
	public SeccionUtil getPnlNacimiento() {
		return pnlNacimiento;
	}

	/**
	 * @method setPnlNacimiento Metodo set del atributo pnlNacimiento
	 * @param pPnlNacimiento
	 *            Valor que tomara el atributo pnlNacimiento
	 * @author hector.cuenca
	 * @date 20/03/2018
	 */
	public void setPnlNacimiento(SeccionUtil pPnlNacimiento) {
		this.pnlNacimiento = pPnlNacimiento;
	}

	/**
	 * @method getDtcFechaNacimiento Metodo get del atributo dtcFechaNacimiento
	 * @return CajaFechaUtil Valor del atributo dtcFechaNacimiento devuelto
	 * @author hector.cuenca
	 * @date 20/03/2018
	 */
	public CajaFechaUtil getDtcFechaNacimiento() {
		return dtcFechaNacimiento;
	}

	/**
	 * @method setDtcFechaNacimiento Metodo set del atributo dtcFechaNacimiento
	 * @param pDtcFechaNacimiento
	 *            Valor que tomara el atributo dtcFechaNacimiento
	 * @author hector.cuenca
	 * @date 20/03/2018
	 */
	public void setDtcFechaNacimiento(CajaFechaUtil pDtcFechaNacimiento) {
		this.dtcFechaNacimiento = pDtcFechaNacimiento;
	}

	/**
	 * @method getLblFechaNacimiento Metodo get del atributo lblFechaNacimiento
	 * @return EtiquetaUtil Valor del atributo lblFechaNacimiento devuelto
	 * @author hector.cuenca
	 * @date 21/03/2018
	 */
	public EtiquetaUtil getLblFechaNacimiento() {
		return lblFechaNacimiento;
	}

	/**
	 * @method setLblFechaNacimiento Metodo set del atributo lblFechaNacimiento
	 * @param pLblFechaNacimiento
	 *            Valor que tomara el atributo lblFechaNacimiento
	 * @author hector.cuenca
	 * @date 21/03/2018
	 */
	public void setLblFechaNacimiento(EtiquetaUtil pLblFechaNacimiento) {
		this.lblFechaNacimiento = pLblFechaNacimiento;
	}

	/**
	 * @method getLblCiudadNacimiento Metodo get del atributo lblCiudadNacimiento
	 * @return EtiquetaUtil Valor del atributo lblCiudadNacimiento devuelto
	 * @author hector.cuenca
	 * @date 21/03/2018
	 */
	public EtiquetaUtil getLblCiudadNacimiento() {
		return lblCiudadNacimiento;
	}

	/**
	 * @method setLblCiudadNacimiento Metodo set del atributo lblCiudadNacimiento
	 * @param pLblCiudadNacimiento
	 *            Valor que tomara el atributo lblCiudadNacimiento
	 * @author hector.cuenca
	 * @date 21/03/2018
	 */
	public void setLblCiudadNacimiento(EtiquetaUtil pLblCiudadNacimiento) {
		this.lblCiudadNacimiento = pLblCiudadNacimiento;
	}

	/**
	 * @method getTxtCiudadNacimiento Metodo get del atributo txtCiudadNacimiento
	 * @return CajaTextoUtil Valor del atributo txtCiudadNacimiento devuelto
	 * @author hector.cuenca
	 * @date 21/03/2018
	 */
	public CajaTextoUtil getTxtCiudadNacimiento() {
		return txtCiudadNacimiento;
	}

	/**
	 * @method setTxtCiudadNacimiento Metodo set del atributo txtCiudadNacimiento
	 * @param pTxtCiudadNacimiento
	 *            Valor que tomara el atributo txtCiudadNacimiento
	 * @author hector.cuenca
	 * @date 21/03/2018
	 */
	public void setTxtCiudadNacimiento(CajaTextoUtil pTxtCiudadNacimiento) {
		this.txtCiudadNacimiento = pTxtCiudadNacimiento;
	}

	/**
	 * @method getLblTelefonoFijoCelular Metodo get del atributo
	 *         lblTelefonoFijoCelular
	 * @return EtiquetaUtil Valor del atributo lblTelefonoFijoCelular devuelto
	 * @author hector.cuenca
	 * @date 21/03/2018
	 */
	public EtiquetaUtil getLblTelefonoFijoCelular() {
		return lblTelefonoFijoCelular;
	}

	/**
	 * @method setLblCorreoElectronico Metodo set del atributo
	 *         lblCorreoElectronico
	 * @param pLblCorreoElectronico
	 *         Valor que tomara el atributo lblCorreoElectronico
	 * @author Monica.llano
	 * @date 19/11/2019
	 */
	public void setLblCorreoElectronico(EtiquetaUtil pLblCorreoElectronico) {
		this.lblcorreoElectronico = pLblCorreoElectronico;
	}

	/**
	 * @method getTxtCorreoElectronico Metodo get del atributo
	 *         txtCorreoElectronico
	 * @return CajaTextoUtil Valor del atributo txtCorreoElectronico devuelto
	 * @author Monica.llano
	 * @date   19/11/2019
	 */
	public CajaTextoUtil getTxtCorreoElectronico() {
		return txtCorreoElectronico;
	}

	/**
	 * @method setTxtCorreoElectronico Metodo set del atributo
	 *         txtCorreoElectronico
	 * @param pTxtCorreoElectronico
	 *            Valor que tomara el atributo txtCorreoElectronico
	 * @author Monica.llano
	 * @date 19/11/2019
	 */
	public void setTxtCorreoElectronico(CajaTextoUtil pTxtCorreoElectronico) {
		this.txtCorreoElectronico = pTxtCorreoElectronico;
	}
	
	/**
	 * @method getLblCorreoElectronico Metodo get del atributo
	 *         lblCorreoElectronico
	 * @return EtiquetaUtil Valor del atributo lblCorreoElectronico devuelto
	 * @author Monica.llano
	 * @date 19/11/2019
	 */
	public EtiquetaUtil getLblCorreoElectronico() {
		return lblcorreoElectronico;
	}

	/**
	 * @method setLblTelefonoFijoCelular Metodo set del atributo
	 *         lblTelefonoFijoCelular
	 * @param pLblTelefonoFijoCelular
	 *            Valor que tomara el atributo lblTelefonoFijoCelular
	 * @author hector.cuenca
	 * @date 21/03/2018
	 */
	public void setLblTelefonoFijoCelular(EtiquetaUtil pLblTelefonoFijoCelular) {
		this.lblTelefonoFijoCelular = pLblTelefonoFijoCelular;
	}

	/**
	 * @method getTxtTelefonoFijoCelular Metodo get del atributo
	 *         txtTelefonoFijoCelular
	 * @return CajaTextoUtil Valor del atributo txtTelefonoFijoCelular devuelto
	 * @author hector.cuenca
	 * @date 21/03/2018
	 */
	public CajaTextoUtil getTxtTelefonoFijoCelular() {
		return txtTelefonoFijoCelular;
	}

	/**
	 * @method setTxtTelefonoFijoCelular Metodo set del atributo
	 *         txtTelefonoFijoCelular
	 * @param pTxtTelefonoFijoCelular
	 *            Valor que tomara el atributo txtTelefonoFijoCelular
	 * @author hector.cuenca
	 * @date 21/03/2018
	 */
	public void setTxtTelefonoFijoCelular(CajaTextoUtil pTxtTelefonoFijoCelular) {
		this.txtTelefonoFijoCelular = pTxtTelefonoFijoCelular;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/**
	 * @method getPnlResidencia Metodo get del atributo pnlResidencia
	 * @return SeccionUtil Valor del atributo pnlResidencia devuelto
	 * @author hector.cuenca
	 * @date 21/03/2018
	 */
	public SeccionUtil getPnlResidencia() {
		return pnlResidencia;
	}

	/**
	 * @method setPnlResidencia Metodo set del atributo pnlResidencia
	 * @param pPnlResidencia
	 *            Valor que tomara el atributo pnlResidencia
	 * @author hector.cuenca
	 * @date 21/03/2018
	 */
	public void setPnlResidencia(SeccionUtil pPnlResidencia) {
		this.pnlResidencia = pPnlResidencia;
	}

	/**
	 * @method getPnlTerritorioResidencia Metodo get del atributo
	 *         pnlTerritorioResidencia
	 * @return FormaPanelTerritorio Valor del atributo pnlTerritorioResidencia
	 *         devuelto
	 * @author hector.cuenca
	 * @date 21/03/2018
	 */
	public FormaPanelTerritorio getPnlTerritorioResidencia() {
		return pnlTerritorioResidencia;
	}

	/**
	 * @method setPnlTerritorioResidencia Metodo set del atributo
	 *         pnlTerritorioResidencia
	 * @param pPnlTerritorioResidencia
	 *            Valor que tomara el atributo pnlTerritorioResidencia
	 * @author hector.cuenca
	 * @date 21/03/2018
	 */
	public void setPnlTerritorioResidencia(FormaPanelTerritorio pPnlTerritorioResidencia) {
		this.pnlTerritorioResidencia = pPnlTerritorioResidencia;
	}

	/**
	 * @method getPnlDireccionResidencia Metodo get del atributo
	 *         pnlDireccionResidencia
	 * @return FormaPanelDireccion Valor del atributo pnlDireccionResidencia
	 *         devuelto
	 * @author hector.cuenca
	 * @date 21/03/2018
	 */
	public FormaPanelDireccion getPnlDireccionResidencia() {
		return pnlDireccionResidencia;
	}

	/**
	 * @method setPnlDireccionResidencia Metodo set del atributo
	 *         pnlDireccionResidencia
	 * @param pPnlDireccionResidencia
	 *            Valor que tomara el atributo pnlDireccionResidencia
	 * @author hector.cuenca
	 * @date 21/03/2018
	 */
	public void setPnlDireccionResidencia(FormaPanelDireccion pPnlDireccionResidencia) {
		this.pnlDireccionResidencia = pPnlDireccionResidencia;
	}

	/**
	 * @method getPnlDedoBiometriaSeleccionado Metodo get del atributo
	 *         pnlDedoBiometriaSeleccionado
	 * @return FormaPanelDedoBiometriaSeleccionado Valor del atributo
	 *         pnlDedoBiometriaSeleccionado devuelto
	 * @author hector.cuenca
	 * @date 31/03/2018
	 */
	/*
	 * public FormaPanelDedoBiometriaSeleccionado getPnlDedoBiometriaSeleccionado()
	 * { return pnlDedoBiometriaSeleccionado; }
	 */

	/**
	 * @method getPnlDatosSocioEconomicos Metodo get del atributo
	 *         pnlDatosSocioEconomicos
	 * @return SeccionUtil Valor del atributo pnlDatosSocioEconomicos devuelto
	 * @author roberth.martinez
	 * @date 16/04/2018
	 */
	public SeccionUtil getPnlDatosSocioEconomicos() {
		return pnlDatosSocioEconomicos;
	}

	/**
	 * @method setPnlDatosSocioEconomicos Metodo set del atributo
	 *         pnlDatosSocioEconomicos
	 * @param pPnlDatosSocioEconomicos
	 *            Valor que tomara el atributo pnlDatosSocioEconomicos
	 * @author roberth.martinez
	 * @date 16/04/2018
	 */
	public void setPnlDatosSocioEconomicos(SeccionUtil pPnlDatosSocioEconomicos) {
		this.pnlDatosSocioEconomicos = pPnlDatosSocioEconomicos;
	}

	/**
	 * @method getPnlInfoContacto Metodo get del atributo pnlInfoContacto
	 * @return SeccionUtil Valor del atributo pnlInfoContacto devuelto
	 * @author roberth.martinez
	 * @date 16/04/2018
	 */
	public SeccionUtil getPnlInfoContacto() {
		return this.pnlInfoContacto;
	}

	/**
	 * @method setPnlInfoContacto Metodo set del atributo pnlInfoContacto
	 * @param pPnlInfoContacto
	 *            Valor que tomara el atributo pnlInfoContacto
	 * @author roberth.martinez
	 * @date 16/04/2018
	 */
	public void setPnlInfoContacto(SeccionUtil pPnlInfoContacto) {
		this.pnlInfoContacto = pPnlInfoContacto;
	}

	/**
	 * @method getLblVlrIngresoMensual Metodo get del atributo lblVlrIngresoMensual
	 * @return EtiquetaUtil Valor del atributo lblVlrIngresoMensual devuelto
	 * @author roberth.martinez
	 * @date 16/04/2018
	 */
	public EtiquetaUtil getLblVlrIngresoMensual() {
		return this.lblVlrIngresoMensual;
	}

	/**
	 * @method setLblVlrIngresoMensual Metodo set del atributo lblVlrIngresoMensual
	 * @param pLblVlrIngresoMensual
	 *            Valor que tomara el atributo lblVlrIngresoMensual
	 * @author roberth.martinez
	 * @date 16/04/2018
	 */
	public void setLblVlrIngresoMensual(EtiquetaUtil pLblVlrIngresoMensual) {
		this.lblVlrIngresoMensual = pLblVlrIngresoMensual;
	}

	/**
	 * @method getLblVlrEgresoMensualActivos Metodo get del atributo
	 *         lblVlrEgresoMensualActivos
	 * @return EtiquetaUtil Valor del atributo lblVlrEgresoMensualActivos devuelto
	 * @author roberth.martinez
	 * @date 16/04/2018
	 */
	public EtiquetaUtil getLblVlrEgresoMensualActivos() {
		return this.lblVlrEgresoMensualActivos;
	}

	/**
	 * @method setLblVlrEgresoMensualActivos Metodo set del atributo
	 *         lblVlrEgresoMensualActivos
	 * @param pLblVlrEgresoMensualActivos
	 *            Valor que tomara el atributo lblVlrEgresoMensualActivos
	 * @author roberth.martinez
	 * @date 16/04/2018
	 */
	public void setLblVlrEgresoMensualActivos(EtiquetaUtil pLblVlrEgresoMensualActivos) {
		this.lblVlrEgresoMensualActivos = pLblVlrEgresoMensualActivos;
	}

	/**
	 * @method getLblVlrActivos Metodo get del atributo lblVlrActivos
	 * @return EtiquetaUtil Valor del atributo lblVlrActivos devuelto
	 * @author roberth.martinez
	 * @date 16/04/2018
	 */
	public EtiquetaUtil getLblVlrActivos() {
		return this.lblVlrActivos;
	}

	/**
	 * @method setLblVlrActivos Metodo set del atributo lblVlrActivos
	 * @param pLblVlrActivos
	 *            Valor que tomara el atributo lblVlrActivos
	 * @author roberth.martinez
	 * @date 16/04/2018
	 */
	public void setLblVlrActivos(EtiquetaUtil pLblVlrActivos) {
		this.lblVlrActivos = pLblVlrActivos;
	}

	/**
	 * @method getLblVlrPasivos Metodo get del atributo lblVlrPasivos
	 * @return EtiquetaUtil Valor del atributo lblVlrPasivos devuelto
	 * @author roberth.martinez
	 * @date 16/04/2018
	 */
	public EtiquetaUtil getLblVlrPasivos() {
		return this.lblVlrPasivos;
	}

	/**
	 * @method setLblVlrPasivos Metodo set del atributo lblVlrPasivos
	 * @param pLblVlrPasivos
	 *            Valor que tomara el atributo lblVlrPasivos
	 * @author roberth.martinez
	 * @date 16/04/2018
	 */
	public void setLblVlrPasivos(EtiquetaUtil pLblVlrPasivos) {
		this.lblVlrPasivos = pLblVlrPasivos;
	}

	/**
	 * @method getTxtVlrIngresoMensual Metodo get del atributo txtVlrIngresoMensual
	 * @return CajaTextoUtil Valor del atributo txtVlrIngresoMensual devuelto
	 * @author roberth.martinez
	 * @date 16/04/2018
	 */
	public CajaTextoUtil getTxtVlrIngresoMensual() {
		return this.txtVlrIngresoMensual;
	}

	/**
	 * @method setTxtVlrIngresoMensual Metodo set del atributo txtVlrIngresoMensual
	 * @param pTxtVlrIngresoMensual
	 *            Valor que tomara el atributo txtVlrIngresoMensual
	 * @author roberth.martinez
	 * @date 16/04/2018
	 */
	public void setTxtVlrIngresoMensual(CajaTextoUtil pTxtVlrIngresoMensual) {
		this.txtVlrIngresoMensual = pTxtVlrIngresoMensual;
	}

	/**
	 * @method getTxtVlrEgresoMensualActivos Metodo get del atributo
	 *         txtVlrEgresoMensualActivos
	 * @return CajaTextoUtil Valor del atributo txtVlrEgresoMensualActivos devuelto
	 * @author roberth.martinez
	 * @date 16/04/2018
	 */
	public CajaTextoUtil getTxtVlrEgresoMensualActivos() {
		return this.txtVlrEgresoMensualActivos;
	}

	/**
	 * @method setTxtVlrEgresoMensualActivos Metodo set del atributo
	 *         txtVlrEgresoMensualActivos
	 * @param pTxtVlrEgresoMensualActivos
	 *            Valor que tomara el atributo txtVlrEgresoMensualActivos
	 * @author roberth.martinez
	 * @date 16/04/2018
	 */
	public void setTxtVlrEgresoMensualActivos(CajaTextoUtil pTxtVlrEgresoMensualActivos) {
		this.txtVlrEgresoMensualActivos = pTxtVlrEgresoMensualActivos;
	}

	/**
	 * @method getTxtVlrActivos Metodo get del atributo txtVlrActivos
	 * @return CajaTextoUtil Valor del atributo txtVlrActivos devuelto
	 * @author roberth.martinez
	 * @date 16/04/2018
	 */
	public CajaTextoUtil getTxtVlrActivos() {
		return this.txtVlrActivos;
	}

	/**
	 * @method setTxtVlrActivos Metodo set del atributo txtVlrActivos
	 * @param pTxtVlrActivos
	 *            Valor que tomara el atributo txtVlrActivos
	 * @author roberth.martinez
	 * @date 16/04/2018
	 */
	public void setTxtVlrActivos(CajaTextoUtil pTxtVlrActivos) {
		this.txtVlrActivos = pTxtVlrActivos;
	}

	/**
	 * @method getTxtVlrPasivos Metodo get del atributo txtVlrPasivos
	 * @return CajaTextoUtil Valor del atributo txtVlrPasivos devuelto
	 * @author roberth.martinez
	 * @date 16/04/2018
	 */
	public CajaTextoUtil getTxtVlrPasivos() {
		return this.txtVlrPasivos;
	}

	/**
	 * @method setTxtVlrPasivos Metodo set del atributo txtVlrPasivos
	 * @param pTxtVlrPasivos
	 *            Valor que tomara el atributo txtVlrPasivos
	 * @author roberth.martinez
	 * @date 16/04/2018
	 */
	public void setTxtVlrPasivos(CajaTextoUtil pTxtVlrPasivos) {
		this.txtVlrPasivos = pTxtVlrPasivos;
	}

	/**
	 * @method getLblActvEconomicas Metodo get del atributo lblActvEconomicas
	 * @return EtiquetaUtil Valor del atributo lblActvEconomicas devuelto
	 * @author roberth.martinez
	 * @date 17/04/2018
	 */
	public EtiquetaUtil getLblActvEconomicas() {
		return this.lblActvEconomicas;
	}

	/**
	 * @method setLblActvEconomicas Metodo set del atributo lblActvEconomicas
	 * @param pLblActvEconomicas
	 *            Valor que tomara el atributo lblActvEconomicas
	 * @author roberth.martinez
	 * @date 17/04/2018
	 */
	public void setLblActvEconomicas(EtiquetaUtil pLblActvEconomicas) {
		this.lblActvEconomicas = pLblActvEconomicas;
	}

	/**
	 * @method getLblProfesion Metodo get del atributo lblProfesion
	 * @return EtiquetaUtil Valor del atributo lblProfesion devuelto
	 * @author roberth.martinez
	 * @date 17/04/2018
	 */
	public EtiquetaUtil getLblProfesion() {
		return this.lblProfesion;
	}

	/**
	 * @method setLblProfesion Metodo set del atributo lblProfesion
	 * @param pLblProfesion
	 *            Valor que tomara el atributo lblProfesion
	 * @author roberth.martinez
	 * @date 17/04/2018
	 */
	public void setLblProfesion(EtiquetaUtil pLblProfesion) {
		this.lblProfesion = pLblProfesion;
	}

	/**
	 * @method getCmbActvEconomicas Metodo get del atributo cmbActvEconomicas
	 * @return CajaComboUtil Valor del atributo cmbActvEconomicas devuelto
	 * @author roberth.martinez
	 * @date 17/04/2018
	 */
	public CajaComboUtil getCmbActvEconomicas() {
		return this.cmbActvEconomicas;
	}

	/**
	 * @method setCmbActvEconomicas Metodo set del atributo cmbActvEconomicas
	 * @param pCmbActvEconomicas
	 *            Valor que tomara el atributo cmbActvEconomicas
	 * @author roberth.martinez
	 * @date 17/04/2018
	 */
	public void setCmbActvEconomicas(CajaComboUtil pCmbActvEconomicas) {
		this.cmbActvEconomicas = pCmbActvEconomicas;
	}

	/**
	 * @method getCmbProfesion Metodo get del atributo cmbProfesion
	 * @return CajaComboUtil Valor del atributo cmbProfesion devuelto
	 * @author roberth.martinez
	 * @date 17/04/2018
	 */
	public CajaComboUtil getCmbProfesion() {
		return this.cmbProfesion;
	}

	/**
	 * @method setCmbProfesion Metodo set del atributo cmbProfesion
	 * @param pCmbProfesion
	 *            Valor que tomara el atributo cmbProfesion
	 * @author roberth.martinez
	 * @date 17/04/2018
	 */
	public void setCmbProfesion(CajaComboUtil pCmbProfesion) {
		this.cmbProfesion = pCmbProfesion;
	}

	/**
	 * @method getLblOperMonedaExtranjera Metodo get del atributo
	 *         lblOperMonedaExtranjera
	 * @return EtiquetaUtil Valor del atributo lblOperMonedaExtranjera devuelto
	 * @author roberth.martinez
	 * @date 17/04/2018
	 */
	public EtiquetaUtil getLblOperMonedaExtranjera() {
		return this.lblOperMonedaExtranjera;
	}

	/**
	 * @method setLblOperMonedaExtranjera Metodo set del atributo
	 *         lblOperMonedaExtranjera
	 * @param pLblOperMonedaExtranjera
	 *            Valor que tomara el atributo lblOperMonedaExtranjera
	 * @author roberth.martinez
	 * @date 17/04/2018
	 */
	public void setLblOperMonedaExtranjera(EtiquetaUtil pLblOperMonedaExtranjera) {
		this.lblOperMonedaExtranjera = pLblOperMonedaExtranjera;
	}

	/**
	 * @method getLblVlrIngresoOperMonExtr Metodo get del atributo
	 *         lblVlrIngresoOperMonExtr
	 * @return EtiquetaUtil Valor del atributo lblVlrIngresoOperMonExtr devuelto
	 * @author roberth.martinez
	 * @date 17/04/2018
	 */
	public EtiquetaUtil getLblVlrIngresoOperMonExtr() {
		return this.lblVlrIngresoOperMonExtr;
	}

	/**
	 * @method setLblVlrIngresoOperMonExtr Metodo set del atributo
	 *         lblVlrIngresoOperMonExtr
	 * @param pLblVlrIngresoOperMonExtr
	 *            Valor que tomara el atributo lblVlrIngresoOperMonExtr
	 * @author roberth.martinez
	 * @date 17/04/2018
	 */
	public void setLblVlrIngresoOperMonExtr(EtiquetaUtil pLblVlrIngresoOperMonExtr) {
		this.lblVlrIngresoOperMonExtr = pLblVlrIngresoOperMonExtr;
	}

	/**
	 * @method getLblMonedaExtranjera Metodo get del atributo lblMonedaExtranjera
	 * @return EtiquetaUtil Valor del atributo lblMonedaExtranjera devuelto
	 * @author roberth.martinez
	 * @date 17/04/2018
	 */
	public EtiquetaUtil getLblMonedaExtranjera() {
		return this.lblMonedaExtranjera;
	}

	/**
	 * @method setLblMonedaExtranjera Metodo set del atributo lblMonedaExtranjera
	 * @param pLblMonedaExtranjera
	 *            Valor que tomara el atributo lblMonedaExtranjera
	 * @author roberth.martinez
	 * @date 17/04/2018
	 */
	public void setLblMonedaExtranjera(EtiquetaUtil pLblMonedaExtranjera) {
		this.lblMonedaExtranjera = pLblMonedaExtranjera;
	}

	/**
	 * @method getLblEntidadExtranjera Metodo get del atributo lblEntidadExtranjera
	 * @return EtiquetaUtil Valor del atributo lblEntidadExtranjera devuelto
	 * @author roberth.martinez
	 * @date 17/04/2018
	 */
	public EtiquetaUtil getLblEntidadExtranjera() {
		return this.lblEntidadExtranjera;
	}

	/**
	 * @method setLblEntidadExtranjera Metodo set del atributo lblEntidadExtranjera
	 * @param pLblEntidadExtranjera
	 *            Valor que tomara el atributo lblEntidadExtranjera
	 * @author roberth.martinez
	 * @date 17/04/2018
	 */
	public void setLblEntidadExtranjera(EtiquetaUtil pLblEntidadExtranjera) {
		this.lblEntidadExtranjera = pLblEntidadExtranjera;
	}

	/**
	 * @method getLblNumProductoExtranjera Metodo get del atributo
	 *         lblNumProductoExtranjera
	 * @return EtiquetaUtil Valor del atributo lblNumProductoExtranjera devuelto
	 * @author roberth.martinez
	 * @date 17/04/2018
	 */
	public EtiquetaUtil getLblNumProductoExtranjera() {
		return this.lblNumProductoExtranjera;
	}

	/**
	 * @method setLblNumProductoExtranjera Metodo set del atributo
	 *         lblNumProductoExtranjera
	 * @param pLblNumProductoExtranjera
	 *            Valor que tomara el atributo lblNumProductoExtranjera
	 * @author roberth.martinez
	 * @date 17/04/2018
	 */
	public void setLblNumProductoExtranjera(EtiquetaUtil pLblNumProductoExtranjera) {
		this.lblNumProductoExtranjera = pLblNumProductoExtranjera;
	}

	/**
	 * @method getCmbManejaOperMonedaExtranjera Metodo get del atributo
	 *         cmbManejaOperMonedaExtranjera
	 * @return CajaComboUtil Valor del atributo cmbManejaOperMonedaExtranjera
	 *         devuelto
	 * @author roberth.martinez
	 * @date 17/04/2018
	 */
	public CajaComboUtil getCmbManejaOperMonedaExtranjera() {
		return this.cmbManejaOperMonedaExtranjera;
	}

	/**
	 * @method setCmbManejaOperMonedaExtranjera Metodo set del atributo
	 *         cmbManejaOperMonedaExtranjera
	 * @param pCmbManejaOperMonedaExtranjera
	 *            Valor que tomara el atributo cmbManejaOperMonedaExtranjera
	 * @author roberth.martinez
	 * @date 17/04/2018
	 */
	public void setCmbManejaOperMonedaExtranjera(CajaComboUtil pCmbManejaOperMonedaExtranjera) {
		this.cmbManejaOperMonedaExtranjera = pCmbManejaOperMonedaExtranjera;
	}

	/**
	 * @method getCmbOperacionesMonedaExtranjera Metodo get del atributo
	 *         cmbOperacionesMonedaExtranjera
	 * @return CajaComboUtil Valor del atributo cmbOperacionesMonedaExtranjera
	 *         devuelto
	 * @author roberth.martinez
	 * @date 17/04/2018
	 */
	public CajaComboUtil getCmbOperacionesMonedaExtranjera() {
		return this.cmbOperacionesMonedaExtranjera;
	}

	/**
	 * @method setCmbOperacionesMonedaExtranjera Metodo set del atributo
	 *         cmbOperacionesMonedaExtranjera
	 * @param pCmbOperacionesMonedaExtranjera
	 *            Valor que tomara el atributo cmbOperacionesMonedaExtranjera
	 * @author roberth.martinez
	 * @date 17/04/2018
	 */
	public void setCmbOperacionesMonedaExtranjera(CajaComboUtil pCmbOperacionesMonedaExtranjera) {
		this.cmbOperacionesMonedaExtranjera = pCmbOperacionesMonedaExtranjera;
	}

	/**
	 * @method getCmbMonedaExtranjera Metodo get del atributo cmbMonedaExtranjera
	 * @return CajaComboUtil Valor del atributo cmbMonedaExtranjera devuelto
	 * @author roberth.martinez
	 * @date 17/04/2018
	 */
	public CajaComboUtil getCmbMonedaExtranjera() {
		return this.cmbMonedaExtranjera;
	}

	/**
	 * @method setCmbMonedaExtranjera Metodo set del atributo cmbMonedaExtranjera
	 * @param pCmbMonedaExtranjera
	 *            Valor que tomara el atributo cmbMonedaExtranjera
	 * @author roberth.martinez
	 * @date 17/04/2018
	 */
	public void setCmbMonedaExtranjera(CajaComboUtil pCmbMonedaExtranjera) {
		this.cmbMonedaExtranjera = pCmbMonedaExtranjera;
	}

	/**
	 * @method getTxtEntidadExtranjera Metodo get del atributo txtEntidadExtranjera
	 * @return CajaTextoUtil Valor del atributo txtEntidadExtranjera devuelto
	 * @author roberth.martinez
	 * @date 17/04/2018
	 */
	public CajaTextoUtil getTxtEntidadExtranjera() {
		return this.txtEntidadExtranjera;
	}

	/**
	 * @method setTxtEntidadExtranjera Metodo set del atributo txtEntidadExtranjera
	 * @param pTxtEntidadExtranjera
	 *            Valor que tomara el atributo txtEntidadExtranjera
	 * @author roberth.martinez
	 * @date 17/04/2018
	 */
	public void setTxtEntidadExtranjera(CajaTextoUtil pTxtEntidadExtranjera) {
		this.txtEntidadExtranjera = pTxtEntidadExtranjera;
	}

	/**
	 * @method getTxtNumProductoExtranjera Metodo get del atributo
	 *         txtNumProductoExtranjera
	 * @return CajaTextoUtil Valor del atributo txtNumProductoExtranjera devuelto
	 * @author roberth.martinez
	 * @date 17/04/2018
	 */
	public CajaTextoUtil getTxtNumProductoExtranjera() {
		return this.txtNumProductoExtranjera;
	}

	/**
	 * @method setTxtNumProductoExtranjera Metodo set del atributo
	 *         txtNumProductoExtranjera
	 * @param pTxtNumProductoExtranjera
	 *            Valor que tomara el atributo txtNumProductoExtranjera
	 * @author roberth.martinez
	 * @date 17/04/2018
	 */
	public void setTxtNumProductoExtranjera(CajaTextoUtil pTxtNumProductoExtranjera) {
		this.txtNumProductoExtranjera = pTxtNumProductoExtranjera;
	}

	/**
	 * @method getTxtValorIngresoExt Metodo get del atributo txtValorIngresoExt
	 * @return CajaTextoUtil Valor del atributo txtValorIngresoExt devuelto
	 * @author roberth.martinez
	 * @date 17/04/2018
	 */
	public CajaTextoUtil getTxtValorIngresoExt() {
		return txtValorIngresoExt;
	}

	/**
	 * @method setTxtValorIngresoExt Metodo set del atributo txtValorIngresoExt
	 * @param pTxtValorIngresoExt
	 *            Valor que tomara el atributo txtValorIngresoExt
	 * @author roberth.martinez
	 * @date 17/04/2018
	 */
	public void setTxtValorIngresoExt(CajaTextoUtil pTxtValorIngresoExt) {
		this.txtValorIngresoExt = pTxtValorIngresoExt;
	}

	/**
	 * @method getPnlExpedicion Metodo get del atributo pnlExpedicion
	 * @return SeccionUtil Valor del atributo pnlExpedicion devuelto
	 * @author roberth.martinez
	 * @date 18/04/2018
	 */
	public SeccionUtil getPnlExpedicion() {
		return pnlExpedicion;
	}

	/**
	 * @method setPnlExpedicion Metodo set del atributo pnlExpedicion
	 * @param pPnlExpedicion
	 *            Valor que tomara el atributo pnlExpedicion
	 * @author roberth.martinez
	 * @date 18/04/2018
	 */
	public void setPnlExpedicion(SeccionUtil pPnlExpedicion) {
		this.pnlExpedicion = pPnlExpedicion;
	}

	/**
	 * @method getPnlDatosComplementarios Metodo get del atributo
	 *         pnlDatosComplementarios
	 * @return SeccionUtil Valor del atributo pnlDatosComplementarios devuelto
	 * @author roberth.martinez
	 * @date 18/04/2018
	 */
	public SeccionUtil getPnlDatosComplementarios() {
		return pnlDatosComplementarios;
	}

	/**
	 * @method setPnlDatosComplementarios Metodo set del atributo
	 *         pnlDatosComplementarios
	 * @param pPnlDatosComplementarios
	 *            Valor que tomara el atributo pnlDatosComplementarios
	 * @author roberth.martinez
	 * @date 18/04/2018
	 */
	public void setPnlDatosComplementarios(SeccionUtil pPnlDatosComplementarios) {
		this.pnlDatosComplementarios = pPnlDatosComplementarios;
	}

	/**
	 * @method getLblFechaExpedicion Metodo get del atributo lblFechaExpedicion
	 * @return EtiquetaUtil Valor del atributo lblFechaExpedicion devuelto
	 * @author roberth.martinez
	 * @date 18/04/2018
	 */
	public EtiquetaUtil getLblFechaExpedicion() {
		return this.lblFechaExpedicion;
	}

	/**
	 * @method setLblFechaExpedicion Metodo set del atributo lblFechaExpedicion
	 * @param pLblFechaExpedicion
	 *            Valor que tomara el atributo lblFechaExpedicion
	 * @author roberth.martinez
	 * @date 18/04/2018
	 */
	public void setLblFechaExpedicion(EtiquetaUtil pLblFechaExpedicion) {
		this.lblFechaExpedicion = pLblFechaExpedicion;
	}

	/**
	 * @method getLblCiudadExpedicion Metodo get del atributo lblCiudadExpedicion
	 * @return EtiquetaUtil Valor del atributo lblCiudadExpedicion devuelto
	 * @author roberth.martinez
	 * @date 18/04/2018
	 */
	public EtiquetaUtil getLblCiudadExpedicion() {
		return this.lblCiudadExpedicion;
	}

	/**
	 * @method setLblCiudadExpedicion Metodo set del atributo lblCiudadExpedicion
	 * @param pLblCiudadExpedicion
	 *            Valor que tomara el atributo lblCiudadExpedicion
	 * @author roberth.martinez
	 * @date 18/04/2018
	 */
	public void setLblCiudadExpedicion(EtiquetaUtil pLblCiudadExpedicion) {
		this.lblCiudadExpedicion = pLblCiudadExpedicion;
	}

	/**
	 * @method getLblPEPS Metodo get del atributo lblPEPS
	 * @return EtiquetaUtil Valor del atributo lblPEPS devuelto
	 * @author roberth.martinez
	 * @date 18/04/2018
	 */
	public EtiquetaUtil getLblPEPS() {
		return this.lblPEPS;
	}

	/**
	 * @method setLblPEPS Metodo set del atributo lblPEPS
	 * @param pLblPEPS
	 *            Valor que tomara el atributo lblPEPS
	 * @author roberth.martinez
	 * @date 18/04/2018
	 */
	public void setLblPEPS(EtiquetaUtil pLblPEPS) {
		this.lblPEPS = pLblPEPS;
	}

	/**
	 * @method getLblVlrOtrosIngresos Metodo get del atributo lblVlrOtrosIngresos
	 * @return EtiquetaUtil Valor del atributo lblVlrOtrosIngresos devuelto
	 * @author roberth.martinez
	 * @date 18/04/2018
	 */
	public EtiquetaUtil getLblVlrOtrosIngresos() {
		return this.lblVlrOtrosIngresos;
	}

	/**
	 * @method setLblVlrOtrosIngresos Metodo set del atributo lblVlrOtrosIngresos
	 * @param pLblVlrOtrosIngresos
	 *            Valor que tomara el atributo lblVlrOtrosIngresos
	 * @author roberth.martinez
	 * @date 18/04/2018
	 */
	public void setLblVlrOtrosIngresos(EtiquetaUtil pLblVlrOtrosIngresos) {
		this.lblVlrOtrosIngresos = pLblVlrOtrosIngresos;
	}

	/**
	 * @method getLblVlrDetalleOtrosIngresos Metodo get del atributo
	 *         lblVlrDetalleOtrosIngresos
	 * @return EtiquetaUtil Valor del atributo lblVlrDetalleOtrosIngresos devuelto
	 * @author roberth.martinez
	 * @date 18/04/2018
	 */
	public EtiquetaUtil getLblVlrDetalleOtrosIngresos() {
		return this.lblVlrDetalleOtrosIngresos;
	}

	/**
	 * @method setLblVlrDetalleOtrosIngresos Metodo set del atributo
	 *         lblVlrDetalleOtrosIngresos
	 * @param pLblVlrDetalleOtrosIngresos
	 *            Valor que tomara el atributo lblVlrDetalleOtrosIngresos
	 * @author roberth.martinez
	 * @date 18/04/2018
	 */
	public void setLblVlrDetalleOtrosIngresos(EtiquetaUtil pLblVlrDetalleOtrosIngresos) {
		this.lblVlrDetalleOtrosIngresos = pLblVlrDetalleOtrosIngresos;
	}

	/**
	 * @method getCmbPEPS Metodo get del atributo cmbPEPS
	 * @return CajaComboUtil Valor del atributo cmbPEPS devuelto
	 * @author roberth.martinez
	 * @date 18/04/2018
	 */
	public CajaComboUtil getCmbPEPS() {
		return this.cmbPEPS;
	}

	/**
	 * @method setCmbPEPS Metodo set del atributo cmbPEPS
	 * @param pCmbPEPS
	 *            Valor que tomara el atributo cmbPEPS
	 * @author roberth.martinez
	 * @date 18/04/2018
	 */
	public void setCmbPEPS(CajaComboUtil pCmbPEPS) {
		this.cmbPEPS = pCmbPEPS;
	}

	/**
	 * @method getTxtCiudadExpedicion Metodo get del atributo txtCiudadExpedicion
	 * @return CajaTextoUtil Valor del atributo txtCiudadExpedicion devuelto
	 * @author roberth.martinez
	 * @date 18/04/2018
	 */
	public CajaTextoUtil getTxtCiudadExpedicion() {
		return this.txtCiudadExpedicion;
	}

	/**
	 * @method setTxtCiudadExpedicion Metodo set del atributo txtCiudadExpedicion
	 * @param pTxtCiudadExpedicion
	 *            Valor que tomara el atributo txtCiudadExpedicion
	 * @author roberth.martinez
	 * @date 18/04/2018
	 */
	public void setTxtCiudadExpedicion(CajaTextoUtil pTxtCiudadExpedicion) {
		this.txtCiudadExpedicion = pTxtCiudadExpedicion;
	}

	/**
	 * @method getTxtVlrOtrosIngresos Metodo get del atributo txtVlrOtrosIngresos
	 * @return CajaTextoUtil Valor del atributo txtVlrOtrosIngresos devuelto
	 * @author roberth.martinez
	 * @date 18/04/2018
	 */
	public CajaTextoUtil getTxtVlrOtrosIngresos() {
		return this.txtVlrOtrosIngresos;
	}

	/**
	 * @method setTxtVlrOtrosIngresos Metodo set del atributo txtVlrOtrosIngresos
	 * @param pTxtVlrOtrosIngresos
	 *            Valor que tomara el atributo txtVlrOtrosIngresos
	 * @author roberth.martinez
	 * @date 18/04/2018
	 */
	public void setTxtVlrOtrosIngresos(CajaTextoUtil pTxtVlrOtrosIngresos) {
		this.txtVlrOtrosIngresos = pTxtVlrOtrosIngresos;
	}

	/**
	 * @method getTxtDetaVlrOtrosIngresos Metodo get del atributo
	 *         txtDetaVlrOtrosIngresos
	 * @return CajaTextoUtil Valor del atributo txtDetaVlrOtrosIngresos devuelto
	 * @author roberth.martinez
	 * @date 18/04/2018
	 */
	public CajaTextoUtil getTxtDetaVlrOtrosIngresos() {
		return this.txtDetaVlrOtrosIngresos;
	}

	/**
	 * @method setTxtDetaVlrOtrosIngresos Metodo set del atributo
	 *         txtDetaVlrOtrosIngresos
	 * @param pTxtDetaVlrOtrosIngresos
	 *            Valor que tomara el atributo txtDetaVlrOtrosIngresos
	 * @author roberth.martinez
	 * @date 18/04/2018
	 */
	public void setTxtDetaVlrOtrosIngresos(CajaTextoUtil pTxtDetaVlrOtrosIngresos) {
		this.txtDetaVlrOtrosIngresos = pTxtDetaVlrOtrosIngresos;
	}

	/**
	 * @method getDtcFechaExpedicion Metodo get del atributo dtcFechaExpedicion
	 * @return CajaFechaUtil Valor del atributo dtcFechaExpedicion devuelto
	 * @author roberth.martinez
	 * @date 18/04/2018
	 */
	public CajaFechaUtil getDtcFechaExpedicion() {
		return this.dtcFechaExpedicion;
	}

	/**
	 * @method setDtcFechaExpedicion Metodo set del atributo dtcFechaExpedicion
	 * @param pDtcFechaExpedicion
	 *            Valor que tomara el atributo dtcFechaExpedicion
	 * @author roberth.martinez
	 * @date 18/04/2018
	 */
	public void setDtcFechaExpedicion(CajaFechaUtil pDtcFechaExpedicion) {
		this.dtcFechaExpedicion = pDtcFechaExpedicion;
	}

	/**
	 * @method getBtnVerInfoPEPS Metodo get del atributo btnVerInfoPEPS
	 * @return BotonUtil Valor del atributo btnVerInfoPEPS devuelto
	 * @author roberth.martinez
	 * @date 18/04/2018
	 */
	public BotonUtil getBtnVerInfoPEPS() {
		return btnVerInfoPEPS;
	}

	/**
	 * @method setBtnVerInfoPEPS Metodo set del atributo btnVerInfoPEPS
	 * @param pBtnVerInfoPEPS
	 *            Valor que tomara el atributo btnVerInfoPEPS
	 * @author roberth.martinez
	 * @date 18/04/2018
	 */
	public void setBtnVerInfoPEPS(BotonUtil pBtnVerInfoPEPS) {
		this.btnVerInfoPEPS = pBtnVerInfoPEPS;
	}

	/**
	 * @method getBtnEmpresaSocEcono Metodo get del atributo btnEmpresaSocEcono
	 * @return BotonUtil Valor del atributo btnEmpresaSocEcono devuelto
	 * @author roberth.martinez
	 * @date 18/04/2018
	 */
	public BotonUtil getBtnEmpresaSocEcono() {
		return btnEmpresaSocEcono;
	}

	/**
	 * @method setBtnEmpresaSocEcono Metodo set del atributo btnEmpresaSocEcono
	 * @param pBtnEmpresaSocEcono
	 *            Valor que tomara el atributo btnEmpresaSocEcono
	 * @author roberth.martinez
	 * @date 18/04/2018
	 */
	public void setBtnEmpresaSocEcono(BotonUtil pBtnEmpresaSocEcono) {
		this.btnEmpresaSocEcono = pBtnEmpresaSocEcono;
	}

	/**
	 * @method getPnlEmpresaDatAdd Metodo get del atributo pnlEmpresaDatAdd
	 * @return SeccionUtil Valor del atributo pnlEmpresaDatAdd devuelto
	 * @author roberth.martinez
	 * @date 3/05/2018
	 */
	public SeccionUtil getPnlEmpresaDatAdd() {
		return pnlEmpresaDatAdd;
	}

	/**
	 * @method setPnlEmpresaDatAdd Metodo set del atributo pnlEmpresaDatAdd
	 * @param pPnlEmpresaDatAdd
	 *            Valor que tomara el atributo pnlEmpresaDatAdd
	 * @author roberth.martinez
	 * @date 3/05/2018
	 */
	public void setPnlEmpresaDatAdd(SeccionUtil pPnlEmpresaDatAdd) {
		this.pnlEmpresaDatAdd = pPnlEmpresaDatAdd;
	}

	/**
	 * @method getLblNombreEmpresa Metodo get del atributo lblNombreEmpresa
	 * @return EtiquetaUtil Valor del atributo lblNombreEmpresa devuelto
	 * @author roberth.martinez
	 * @date 3/05/2018
	 */
	public EtiquetaUtil getLblNombreEmpresa() {
		return this.lblNombreEmpresa;
	}

	/**
	 * @method setLblNombreEmpresa Metodo set del atributo lblNombreEmpresa
	 * @param pLblNombreEmpresa
	 *            Valor que tomara el atributo lblNombreEmpresa
	 * @author roberth.martinez
	 * @date 3/05/2018
	 */
	public void setLblNombreEmpresa(EtiquetaUtil pLblNombreEmpresa) {
		this.lblNombreEmpresa = pLblNombreEmpresa;
	}

	/**
	 * @method getLblDireccionEmpresa Metodo get del atributo lblDireccionEmpresa
	 * @return EtiquetaUtil Valor del atributo lblDireccionEmpresa devuelto
	 * @author roberth.martinez
	 * @date 3/05/2018
	 */
	public EtiquetaUtil getLblDireccionEmpresa() {
		return this.lblDireccionEmpresa;
	}

	/**
	 * @method setLblDireccionEmpresa Metodo set del atributo lblDireccionEmpresa
	 * @param pLblDireccionEmpresa
	 *            Valor que tomara el atributo lblDireccionEmpresa
	 * @author roberth.martinez
	 * @date 3/05/2018
	 */
	public void setLblDireccionEmpresa(EtiquetaUtil pLblDireccionEmpresa) {
		this.lblDireccionEmpresa = pLblDireccionEmpresa;
	}

	/**
	 * @method getLblTelefonoEmpresa Metodo get del atributo lblTelefonoEmpresa
	 * @return EtiquetaUtil Valor del atributo lblTelefonoEmpresa devuelto
	 * @author roberth.martinez
	 * @date 3/05/2018
	 */
	public EtiquetaUtil getLblTelefonoEmpresa() {
		return this.lblTelefonoEmpresa;
	}

	/**
	 * @method setLblTelefonoEmpresa Metodo set del atributo lblTelefonoEmpresa
	 * @param pLblTelefonoEmpresa
	 *            Valor que tomara el atributo lblTelefonoEmpresa
	 * @author roberth.martinez
	 * @date 3/05/2018
	 */
	public void setLblTelefonoEmpresa(EtiquetaUtil pLblTelefonoEmpresa) {
		this.lblTelefonoEmpresa = pLblTelefonoEmpresa;
	}

	/**
	 * @method getLblCiudadEmpresa Metodo get del atributo lblCiudadEmpresa
	 * @return EtiquetaUtil Valor del atributo lblCiudadEmpresa devuelto
	 * @author roberth.martinez
	 * @date 3/05/2018
	 */
	public EtiquetaUtil getLblCiudadEmpresa() {
		return this.lblCiudadEmpresa;
	}

	/**
	 * @method setLblCiudadEmpresa Metodo set del atributo lblCiudadEmpresa
	 * @param pLblCiudadEmpresa
	 *            Valor que tomara el atributo lblCiudadEmpresa
	 * @author roberth.martinez
	 * @date 3/05/2018
	 */
	public void setLblCiudadEmpresa(EtiquetaUtil pLblCiudadEmpresa) {
		this.lblCiudadEmpresa = pLblCiudadEmpresa;
	}

	/**
	 * @method getLblCargoEmpresa Metodo get del atributo lblCargoEmpresa
	 * @return EtiquetaUtil Valor del atributo lblCargoEmpresa devuelto
	 * @author roberth.martinez
	 * @date 3/05/2018
	 */
	public EtiquetaUtil getLblCargoEmpresa() {
		return this.lblCargoEmpresa;
	}

	/**
	 * @method setLblCargoEmpresa Metodo set del atributo lblCargoEmpresa
	 * @param pLblCargoEmpresa
	 *            Valor que tomara el atributo lblCargoEmpresa
	 * @author roberth.martinez
	 * @date 3/05/2018
	 */
	public void setLblCargoEmpresa(EtiquetaUtil pLblCargoEmpresa) {
		this.lblCargoEmpresa = pLblCargoEmpresa;
	}

	/**
	 * @method getTxtNombreEmpresa Metodo get del atributo txtNombreEmpresa
	 * @return CajaTextoUtil Valor del atributo txtNombreEmpresa devuelto
	 * @author roberth.martinez
	 * @date 3/05/2018
	 */
	public CajaTextoUtil getTxtNombreEmpresa() {
		return this.txtNombreEmpresa;
	}

	/**
	 * @method setTxtNombreEmpresa Metodo set del atributo txtNombreEmpresa
	 * @param pTxtNombreEmpresa
	 *            Valor que tomara el atributo txtNombreEmpresa
	 * @author roberth.martinez
	 * @date 3/05/2018
	 */
	public void setTxtNombreEmpresa(CajaTextoUtil pTxtNombreEmpresa) {
		this.txtNombreEmpresa = pTxtNombreEmpresa;
	}

	/**
	 * @method getTxtDireccionEmpresa Metodo get del atributo txtDireccionEmpresa
	 * @return CajaTextoUtil Valor del atributo txtDireccionEmpresa devuelto
	 * @author roberth.martinez
	 * @date 3/05/2018
	 */
	public CajaTextoUtil getTxtDireccionEmpresa() {
		return this.txtDireccionEmpresa;
	}

	/**
	 * @method setTxtDireccionEmpresa Metodo set del atributo txtDireccionEmpresa
	 * @param pTxtDireccionEmpresa
	 *            Valor que tomara el atributo txtDireccionEmpresa
	 * @author roberth.martinez
	 * @date 3/05/2018
	 */
	public void setTxtDireccionEmpresa(CajaTextoUtil pTxtDireccionEmpresa) {
		this.txtDireccionEmpresa = pTxtDireccionEmpresa;
	}

	/**
	 * @method getTxtTelefonoEmpresa Metodo get del atributo txtTelefonoEmpresa
	 * @return CajaTextoUtil Valor del atributo txtTelefonoEmpresa devuelto
	 * @author roberth.martinez
	 * @date 3/05/2018
	 */
	public CajaTextoUtil getTxtTelefonoEmpresa() {
		return this.txtTelefonoEmpresa;
	}

	/**
	 * @method setTxtTelefonoEmpresa Metodo set del atributo txtTelefonoEmpresa
	 * @param pTxtTelefonoEmpresa
	 *            Valor que tomara el atributo txtTelefonoEmpresa
	 * @author roberth.martinez
	 * @date 3/05/2018
	 */
	public void setTxtTelefonoEmpresa(CajaTextoUtil pTxtTelefonoEmpresa) {
		this.txtTelefonoEmpresa = pTxtTelefonoEmpresa;
	}

	/**
	 * @method getTxtCiudadEmpresa Metodo get del atributo txtCiudadEmpresa
	 * @return CajaTextoUtil Valor del atributo txtCiudadEmpresa devuelto
	 * @author roberth.martinez
	 * @date 3/05/2018
	 */
	public CajaTextoUtil getTxtCiudadEmpresa() {
		return this.txtCiudadEmpresa;
	}

	/**
	 * @method setTxtCiudadEmpresa Metodo set del atributo txtCiudadEmpresa
	 * @param pTxtCiudadEmpresa
	 *            Valor que tomara el atributo txtCiudadEmpresa
	 * @author roberth.martinez
	 * @date 3/05/2018
	 */
	public void setTxtCiudadEmpresa(CajaTextoUtil pTxtCiudadEmpresa) {
		this.txtCiudadEmpresa = pTxtCiudadEmpresa;
	}

	/**
	 * @method getTxtCargoEmpresa Metodo get del atributo txtCargoEmpresa
	 * @return CajaTextoUtil Valor del atributo txtCargoEmpresa devuelto
	 * @author roberth.martinez
	 * @date 3/05/2018
	 */
	public CajaTextoUtil getTxtCargoEmpresa() {
		return this.txtCargoEmpresa;
	}

	/**
	 * @method setTxtCargoEmpresa Metodo set del atributo txtCargoEmpresa
	 * @param pTxtCargoEmpresa
	 *            Valor que tomara el atributo txtCargoEmpresa
	 * @author roberth.martinez
	 * @date 3/05/2018
	 */
	public void setTxtCargoEmpresa(CajaTextoUtil pTxtCargoEmpresa) {
		this.txtCargoEmpresa = pTxtCargoEmpresa;
	}

	@Override
	public EventoFormaActualizarCrearTerceroInternacional getEventoForma() {
		return (EventoFormaActualizarCrearTerceroInternacional) super.getEventoForma();
	};

	/**
	 * ********************************************************************
	 * 
	 * @method main main
	 * @param args
	 *            args
	 * @author roberth.martinez
	 * @date 16/04/2018
	 *       *********************************************************************
	 */
	public static void main(String[] args) {

		try {

			TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaSenalAlertaInternacional.class, true,
					EnumDesplegarFormaConEventos.SI);

			TipoDocumentoInternacional objTpoDocInt = new TipoDocumentoInternacional();
			objTpoDocInt.setId("1");
			objTpoDocInt.setValor("CECULA CIUDADANIA");

			ConfigTerceroInternacionalDTO configTerceroInternacionalDTO = new ConfigTerceroInternacionalDTO();
			configTerceroInternacionalDTO.setObjBooActualizaClienteUsuario(true);

			new FormaActualizarCrearTerceroInternacional(null, true, true, configTerceroInternacionalDTO, objTpoDocInt,
					"1144029966", "464648486");

		} catch (Exception e) {

			UtilidadesGiros.getInstance().controlExcepcion(e, null);
		}
	}
}

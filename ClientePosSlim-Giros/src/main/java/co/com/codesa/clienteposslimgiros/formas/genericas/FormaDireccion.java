package co.com.codesa.clienteposslimgiros.formas.genericas;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import co.com.codesa.clienteposslimgiros.dto.direccion.ConfigDireccionDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.generico.EventoFormaDireccion;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

/**
 * ****************************************************************.
 * 
 * @autor Hector Q-en-K
 * @fecha 09-abr-2015
 * @Clase FormaDireccion Clase que genera la forma (GUI) para gestionar y/o
 *        diligenciar una direccion
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados.
 *            ****************************************************************
 */
public class FormaDireccion extends FormaGenerica {

	/**
	 * @variable serialVersionUID Variable serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @variable pnlEspecificacion seccion que agrupa los componentes graficos
	 *           dise�ados para la especificacion de la direccion
	 **/
	private JPanel pnlEspecificacion;

	/**
	 * @variable pnlDireccionTradicional seccion que agrupa los componentes graficos
	 *           para especificar la direccion tradicional (numero de via, numero de
	 *           interseccion y numero de lugar)
	 **/
	private JPanel pnlDireccionTradicional;

	/**
	 * @variable pnlUbicacion seccion que agrupa los componentes graficos para
	 *           especificar la ubicacion de la direccion (sector)
	 **/
	private JPanel pnlUbicacion;

	/**
	 * @variable pnlLugar seccion que agrupa los componentes graficos para
	 *           especificar el lugar (caracteristica y especificacion)
	 **/
	private JPanel pnlLugar;

	/**
	 * @variable pnlUbicacion seccion que agrupa los componentes graficos para
	 *           especificar la ubicacion de la direccion (sector)
	 **/
	private JPanel pnlBarrio;

	/**
	 * @variable pnlUbicacion seccion que agrupa los componentes graficos para
	 *           especificar la ubicacion de la direccion (sector)
	 **/
	private JPanel pnlDepartamento;

	/**
	 * @variable pnlUbicacion seccion que agrupa los componentes graficos para
	 *           especificar la ubicacion de la direccion (sector)
	 **/
	private JPanel pnlMunicipio;

	/**
	 * @variable pnlUbicacion seccion que agrupa los componentes graficos para
	 *           especificar la ubicacion de la direccion (sector)
	 **/
	private JPanel pnlCodigo;

	/**
	 * @variable lblClasesVia etiqueta para indicar el componente grafico sobre la
	 *           forma para seleccionar la clase de via
	 **/
	private EtiquetaUtil lblClasesVia;

	/**
	 * @variable lblEspecificacionAbierta etiqueta para indicar el componente
	 *           grafico sobre la forma para diligenciar una especificacion abierta
	 **/
	private EtiquetaUtil lblEspecificacionAbierta;

	/**
	 * @variable lblEspecificacionesDireccionTradicional etiqueta para indicar los
	 *           componentes graficos sobre la forma que permiten el ingreso de la
	 *           direccion tradicional
	 **/
	private EtiquetaUtil lblEspecificacionesDireccionTradicional;

	/**
	 * @variable lblSeparadorInterseccionVia etiqueta que realiza la separacion e
	 *           identificacion del numero de interseccion con respecto al numero de
	 *           via
	 **/
	private EtiquetaUtil lblSeparadorInterseccionVia;

	/**
	 * @variable lblSeparadorLugarInterseccion etiqueta que realiza la separacion e
	 *           identificacion del numero de lugar con respecto al numero de
	 *           interseccion
	 **/
	private EtiquetaUtil lblSeparadorLugarInterseccion;

	/**
	 * @variable lblZonasUbicacion etiqueta que identifica el componente grafico
	 *           sobre la forma para seleccionar la zona geografica de la ubicacion
	 **/
	private EtiquetaUtil lblZonasUbicacion;

	/**
	 * @variable lblCaracteristicasLugar etiqueta que identifica el componente
	 *           grafico sobre la forma para seleccionar el sector geografico de la
	 *           ubicacion
	 **/
	private EtiquetaUtil lblCaracteristicasLugar;

	/**
	 * @variable lblEspecificacionLugar etiqueta que identifica el componente
	 *           grafico sobre la forma para diligenciar la especificacion del lugar
	 **/
	private EtiquetaUtil lblEspecificacionLugar;

	/**
	 * @variable lblNombreBarrio etiqueta que identifica el componente grafico sobre
	 *           la forma para especificar el nombre del barrio
	 **/
	private EtiquetaUtil lblNombreBarrio;

	/**
	 * @variable lblEstratosBarrio etiqueta que identifica el componente grafico
	 *           sobre la forma para seleccionar el estrato
	 **/
	private EtiquetaUtil lblEstratosBarrio;

	/**
	 * @variable lblEstratosBarrio etiqueta que identifica el componente grafico
	 *           sobre la forma para seleccionar el estrato
	 **/
	private EtiquetaUtil lblCodigoPostal;

	/**
	 * @variable lblEstratosBarrio etiqueta que identifica el componente grafico
	 *           sobre la forma para seleccionar el estrato
	 **/
	private EtiquetaUtil lblDepartamentoNombre;

	/**
	 * @variable cmbEstratosBarrio lista de valores a contener los diferentes
	 *           estratos asociados al barrio, configuradas sobre la aplicacion
	 **/
	private CajaComboUtil cmbDepartamento;

	/**
	 * @variable lblEstratosBarrio etiqueta que identifica el componente grafico
	 *           sobre la forma para seleccionar el estrato
	 **/
	private EtiquetaUtil lblMunicipioNombre;

	/**
	 * @variable cmbEstratosBarrio lista de valores a contener los diferentes
	 *           estratos asociados al barrio, configuradas sobre la aplicacion
	 **/
	private CajaComboUtil cmbMunicipio;

	/**
	 * @variable cmbClasesVia lista de valores a contener las diferentes clases de
	 *           via configuradas sobre la aplicacion
	 **/
	private CajaComboUtil cmbClasesVia;

	/**
	 * @variable cmbZonasUbicacion lista de valores a contener las diferentes zonas
	 *           asociadas a la ubicacion geografica configuradas sobre la
	 *           aplicacion
	 **/
	private CajaComboUtil cmbZonasUbicacion;

	/**
	 * @variable cmbCaracteristicasLugar lista de valores a contener las diferentes
	 *           caracteristicas asociadas al lugar, configuradas sobre la
	 *           aplicacion
	 **/
	private CajaComboUtil cmbCaracteristicasLugar;

	/**
	 * @variable cmbEstratosBarrio lista de valores a contener los diferentes
	 *           estratos asociados al barrio, configuradas sobre la aplicacion
	 **/
	private CajaComboUtil cmbEstratosBarrio;

	/**
	 * @variable txtEspecificacionAbierta caja de texto para ingresar la
	 *           especificacion de la direccion de manera abierta, aplica de momento
	 *           para vereda
	 **/
	private CajaTextoUtil txtEspecificacionAbierta;

	/**
	 * @variable txtNumeroVia caja de texto para ingresar la especificacion del
	 *           numero de via sobre la direccion tradicional
	 **/
	private CajaTextoUtil txtNumeroVia;

	/**
	 * @variable txtNumeroInterseccion caja de texto para ingresar la especificacion
	 *           del numero de interseccion sobre la direccion tradicional
	 **/
	private CajaTextoUtil txtNumeroInterseccion;

	/**
	 * @variable txtNumeroLugar caja de texto para ingresar la especificacion del
	 *           numero de lugar sobre la direccion tradicional
	 **/
	private CajaTextoUtil txtNumeroLugar;

	/**
	 * @variable txtEspecificacionLugar caja de texto para ingresar la
	 *           especificacion del lugar
	 **/
	private CajaTextoUtil txtEspecificacionLugar;

	/**
	 * @variable txtNombreBarrio caja de texto para ingresar el nombre del barrio
	 **/
	private CajaTextoUtil txtNombreBarrio;

	/**
	 * @variable txtEspecificacionAbierta caja de texto para ingresar la
	 *           especificacion de la direccion de manera abierta, aplica de momento
	 *           para vereda
	 **/
	private CajaTextoUtil txtCodigo;

	/**
	 * ****************************************************************.
	 * 
	 * @metodo FormaDireccion Constructor que ejecuta la inicializacion de valores y
	 *         ejecucion de comportamientos inicales requeridos para el despliegue
	 *         de la forma
	 * @param pFrmPadre            ventana de la cual extiende esta forma
	 * @param pBooModal            bandera que permite efectuar la forma de manera
	 *                             modal sobre la ventana de la cual extiende
	 * @param pStrEntradaDireccion cadena que representa una direccion posiblemente
	 *                             ya diligenciada, a la cual se le validara si
	 *                             cumple con el formato de direccion contemplado
	 *                             por la forma, de ser asi se cargara sobre los
	 *                             diferentes componentes graficos para su
	 *                             administracion
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	public FormaDireccion(FormaGenerica pFrmPadre, boolean pBooModal, String pStrEntradaDireccion) throws Exception {

		super(pFrmPadre, pBooModal);

		super.setEventoForma(new EventoFormaDireccion(this, null));

		this.inicializarForma(pStrEntradaDireccion);
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo FormaDireccion Constructor que ejecuta la inicializacion de valores y
	 *         ejecucion de comportamientos inicales requeridos para el despliegue
	 *         de la forma
	 * @param pFrmPadre              ventana de la cual extiende esta forma
	 * @param pBooModal              bandera que permite efectuar la forma de manera
	 *                               modal sobre la ventana de la cual extiende
	 * @param pStrEntradaDireccion   cadena que representa una direccion
	 *                               posiblemente ya diligenciada, a la cual se le
	 *                               validara si cumple con el formato de direccion
	 *                               contemplado por la forma, de ser asi se cargara
	 *                               sobre los diferentes componentes graficos para
	 *                               su administracion
	 * @param pObjDtoConfigDireccion Objeto DTO encargado de almacenar toda la
	 *                               configuracion relacionada con el formulario
	 *                               para diligenciar la direccion
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	public FormaDireccion(FormaGenerica pFrmPadre, boolean pBooModal, String pStrEntradaDireccion,
			ConfigDireccionDTO pObjDtoConfigDireccion) throws Exception {
		super(pFrmPadre, pBooModal);

		super.setEventoForma(new EventoFormaDireccion(this, pObjDtoConfigDireccion));

		this.inicializarForma(pStrEntradaDireccion);
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo inicializarForma Metodo propuesto por la forma generica, para
	 *         inicializar todos los aspectos de la forma
	 * @param pArrObjParametrosForma lista de posibles parametros a incluir sobre la
	 *                               inicializacion de la forma [x]: descripcion del
	 *                               valor enviado en la posicion [x] [0]: direccion
	 *                               previamente diligenciada
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	@Override
	public void inicializarForma(Object... pArrObjParametrosForma) throws Exception {

		super.setTituloForma(EnumEtiquetas.TTL_DIR_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.GUI_DIR_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.GUI_DIR_VENTANA.getAlto());

		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR, EnumBotonesEncabezado.BTN_LIMPIAR,
				EnumBotonesEncabezado.BTNVOLVER);

		super.iniciar(pArrObjParametrosForma);
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo inicializarEncabezado Metodo dedicado a inicializar y gestionar el
	 *         encabezado de la forma (seccion superior)
	 * @param pArrObjParametrosForma lista de posibles parametros a incluir sobre la
	 *                               inicializacion de la seccion del encabezado
	 *                               [x]: descripcion del valor enviado en la
	 *                               posicion [x]
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
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
	 * @param pArrObjParametrosCuerpo lista de posibles parametros a incluir sobre
	 *                                la inicializacion de la seccion del cuerpo
	 *                                [x]: descripcion del valor enviado en la
	 *                                posicion [x]
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	@Override
	public JPanel inicializarCuerpo(Object... pArrObjParametrosCuerpo) throws Exception {

		JPanel pnlCuerpo;

		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_DIR_CUERPO, "pnlCuerpo",
				null, null, null);
		pnlCuerpo.add(this.iniciarPropLblClasesVia());
		pnlCuerpo.add(this.iniciarPropCmbClasesVia());
		pnlCuerpo.add(this.iniciarPropLblEspecificacionAbierta());
		pnlCuerpo.add(this.iniciarPropTxtEspecificacionAbierta());
		pnlCuerpo.add(this.iniciarPropPnlEspecificacion());

		return pnlCuerpo;

	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo inicializarPiePagina Metodo dedicado a inicializar y gestionar el pie
	 *         de pagina de la forma (seccion inferior)
	 * @param pArrObjParametrosPiePagina lista de posibles parametros a incluir
	 *                                   sobre la inicializacion de la seccion de
	 *                                   pie de pagina [x]: descripcion del valor
	 *                                   enviado en la posicion [x]
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	@Override
	public JPanel inicializarPiePagina(Object... pArrObjParametrosPiePagina) throws Exception {
		return null;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo iniciarPropLblClasesVia Metodo estandar para autogestionar el valor
	 *         del atributo lblClasesVia
	 * @return EtiquetaUtil etiqueta gestionada
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblClasesVia() throws Exception {

		if (this.lblClasesVia == null) {

			this.lblClasesVia = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_DIR_CLASES_VIA, "lblClasesVia", EnumEtiquetas.LBL_DIR_CLASES_VIA,
					true, null, true);
		}

		return this.lblClasesVia;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo iniciarPropLblEspecificacionAbierta Metodo estandar para
	 *         autogestionar el valor del atributo lblEspecificacionAbierta
	 * @return EtiquetaUtil etiqueta gestionada
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblEspecificacionAbierta() throws Exception {

		if (this.lblEspecificacionAbierta == null) {

			this.lblEspecificacionAbierta = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_DIR_ESPECIFICACION_ABIERTA, "lblEspecificacionAbierta",
					EnumEtiquetas.LBL_DIR_ESPECIFICACION_ABIERTA, true, null, true);
		}
		return this.lblEspecificacionAbierta;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo iniciarPropCmbClasesVia Metodo estandar para autogestionar el valor
	 *         del atributo cmbClasesVia
	 * @return CajaComboUtil lista de valores gestionada
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	public CajaComboUtil iniciarPropCmbClasesVia() throws Exception {

		if (this.cmbClasesVia == null) {

			this.cmbClasesVia = UtilComponentesGUI.getInstance().crearComboBox(
					EnumDimensionesComponentes.CMB_DIR_CLASES_VIA, "cmbClasesVia", true, true, super.getEventoForma(),
					EnumEtiquetas.LBL_DIR_CLASES_VIA);
		}

		return this.cmbClasesVia;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo iniciarPropCmbZonasUbicacion Metodo estandar para autogestionar el
	 *         valor del atributo cmbZonasUbicacion
	 * @return CajaComboUtil lista de valores gestionada
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	public CajaComboUtil iniciarPropCmbZonasUbicacion() throws Exception {

		if (this.cmbZonasUbicacion == null) {

			this.cmbZonasUbicacion = UtilComponentesGUI.getInstance().crearComboBox(
					EnumDimensionesComponentes.CMB_DIR_ZONAS_UBICACION, "cmbZonasUbicacion", true, true,
					super.getEventoForma(), EnumEtiquetas.LBL_DIR_ZONAS_UBICACION);
		}
		return this.cmbZonasUbicacion;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo iniciarPropCmbCaracteristicasLugar Metodo estandar para autogestionar
	 *         el valor del atributo cmbCaracteristicasLugar
	 * @return CajaComboUtil lista de valores gestionada
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	public CajaComboUtil iniciarPropCmbCaracteristicasLugar() throws Exception {

		if (this.cmbCaracteristicasLugar == null) {

			this.cmbCaracteristicasLugar = UtilComponentesGUI.getInstance().crearComboBox(
					EnumDimensionesComponentes.CMB_DIR_CARACTERISTICAS_LUGAR, "cmbCaracteristicasLugar", true, true,
					super.getEventoForma(), EnumEtiquetas.LBL_DIR_CARACTERISTICAS_LUGAR);
		}
		return this.cmbCaracteristicasLugar;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo iniciarPropCmbEstratosBarrio Metodo estandar para autogestionar el
	 *         valor del atributo cmbEstratosBarrio
	 * @return CajaComboUtil lista de valores gestionada
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	public CajaComboUtil iniciarPropCmbEstratosBarrio() throws Exception {

		if (this.cmbEstratosBarrio == null) {

			this.cmbEstratosBarrio = UtilComponentesGUI.getInstance().crearComboBox(
					EnumDimensionesComponentes.CMB_DIR_ESTRATOS_BARRIO, "cmbEstratosBarrio", true, true,
					super.getEventoForma(), EnumEtiquetas.LBL_DIR_ESTRATOS_BARRIO);
		}
		return this.cmbEstratosBarrio;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo iniciarPropCmbEstratosBarrio Metodo estandar para autogestionar el
	 *         valor del atributo cmbEstratosBarrio
	 * @return CajaComboUtil lista de valores gestionada
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	public CajaComboUtil iniciarPropCmbDepartamento() throws Exception {

		if (this.cmbDepartamento == null) {

			this.cmbDepartamento = UtilComponentesGUI.getInstance().crearComboBox(
					EnumDimensionesComponentes.CMB_DIR_DEPARTAMENTO_NOMBRE, "cmbDepartamento", true, true,
					super.getEventoForma(), EnumEtiquetas.LBL_DIR_DEPARTAMENTO);
		}
		return this.cmbDepartamento;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo iniciarPropCmbEstratosBarrio Metodo estandar para autogestionar el
	 *         valor del atributo cmbEstratosBarrio
	 * @return CajaComboUtil lista de valores gestionada
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	public CajaComboUtil iniciarPropCmbMunicipio() throws Exception {

		if (this.cmbMunicipio == null) {

			this.cmbMunicipio = UtilComponentesGUI.getInstance().crearComboBox(
					EnumDimensionesComponentes.CMB_DIR_MUNICIPIO_NOMBRE, "cmbMunicipio", true, true,
					super.getEventoForma(), EnumEtiquetas.LBL_DIR_MUNICIPIO);
		}
		return this.cmbMunicipio;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo iniciarPropCmbEstratosBarrio Metodo estandar para autogestionar el
	 *         valor del atributo cmbEstratosBarrio
	 * @return CajaComboUtil lista de valores gestionada
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	public CajaComboUtil iniciarPropCmbMunicipios() throws Exception {

		if (this.cmbMunicipio == null) {

			this.cmbMunicipio = UtilComponentesGUI.getInstance().crearComboBox(
					EnumDimensionesComponentes.CMB_DIR_MUNICIPIO_NOMBRE, "cmbMunicipio", true, true,
					super.getEventoForma(), EnumEtiquetas.LBL_DIR_MUNICIPIO);
		}
		return this.cmbMunicipio;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo iniciarPropTxtEspecificacionAbierta Metodo estandar para
	 *         autogestionar el valor del atributo txtEspecificacionAbierta
	 * @return CajaTextoUtil caja de texto gestionada
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtEspecificacionAbierta() throws Exception {

		if (this.txtEspecificacionAbierta == null) {

			this.txtEspecificacionAbierta = UtilComponentesGUI.getInstance().crearTextField(
					EnumDimensionesComponentes.TXT_DIR_ESPECIFICACION_ABIERTA, "txtEspecificacionAbierta", "", false,
					true, true, super.getEventoForma(), EnumEtiquetas.LBL_DIR_ESPECIFICACION_ABIERTA);
		}
		return this.txtEspecificacionAbierta;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo iniciarPropPnlEspecificacion Metodo estandar para autogestionar el
	 *         valor del atributo pnlEspecificacion
	 * @return JPanel seccion de cuerpo gestionada
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	public JPanel iniciarPropPnlEspecificacion() throws Exception {

		if (this.pnlEspecificacion == null) {

			this.pnlEspecificacion = UtilComponentesGUI.getInstance().crearPanel(
					EnumDimensionesComponentes.PNL_DIR_ESPECIFICACION, "pnlEspecificacion",
					BorderFactory.createEmptyBorder(), null, null);
			this.pnlEspecificacion.add(this.iniciarPropPnlDireccionTradicional());
			this.pnlEspecificacion.add(this.iniciarPropPnlUbicacion());
			this.pnlEspecificacion.add(this.iniciarPropPnlLugar());
			this.pnlEspecificacion.add(this.iniciarPropPnlDepartamento());
			this.pnlEspecificacion.add(this.iniciarPropPnlMunicipio());
			this.pnlEspecificacion.add(this.iniciarPropPnlBarrio());
			this.pnlEspecificacion.add(this.iniciarPropPnlCodigoPostal());
		}

		return this.pnlEspecificacion;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo iniciarPropPnlDireccionTradicional Metodo estandar para autogestionar
	 *         el valor del atributo pnlDireccionTradicional
	 * @return JPanel seccion de cuerpo gestionada
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	public JPanel iniciarPropPnlDireccionTradicional() throws Exception {

		if (this.pnlDireccionTradicional == null) {

			this.pnlDireccionTradicional = UtilComponentesGUI.getInstance().crearPanel(
					EnumDimensionesComponentes.PNL_DIR_DIRECCION_TRADICIONAL, "pnlDireccionTradicional", null,
					EnumEtiquetas.TTL_DIR_PNL_DIRECCION_TRADICIONAL, null);

			this.pnlDireccionTradicional.add(this.iniciarPropLblEspecificacionesDireccionTradicional());
			this.pnlDireccionTradicional.add(this.iniciarPropTxtNumeroVia());
			this.pnlDireccionTradicional.add(this.iniciarPropLblSeparadorInterseccionVia());
			this.pnlDireccionTradicional.add(this.iniciarPropTxtNumeroInterseccion());
			this.pnlDireccionTradicional.add(this.iniciarPropLblSeparadorLugarInterseccion());
			this.pnlDireccionTradicional.add(this.iniciarPropTxtNumeroLugar());
		}

		return this.pnlDireccionTradicional;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo iniciarPropPnlUbicacion Metodo estandar para autogestionar el valor
	 *         del atributo pnlUbicacion
	 * @return JPanel seccion de cuerpo gestionada
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	public JPanel iniciarPropPnlUbicacion() throws Exception {

		if (this.pnlUbicacion == null) {

			this.pnlUbicacion = UtilComponentesGUI.getInstance().crearPanel(
					EnumDimensionesComponentes.PNL_DIR_UBICACION, "pnlUbicacion", null,
					EnumEtiquetas.TTL_DIR_PNL_UBICACION, null);
			this.pnlUbicacion.add(this.iniciarPropLblSectoresUbicacion());
			this.pnlUbicacion.add(this.iniciarPropCmbZonasUbicacion());
		}

		return this.pnlUbicacion;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo iniciarPropPnlLugar Metodo estandar para autogestionar el valor del
	 *         atributo pnlLugar
	 * @return JPanel seccion de cuerpo gestionada
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	public JPanel iniciarPropPnlLugar() throws Exception {

		if (this.pnlLugar == null) {

			this.pnlLugar = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_DIR_LUGAR,
					"pnlLugar", null, EnumEtiquetas.TTL_DIR_PNL_LUGAR, null);
			this.pnlLugar.add(this.iniciarPropLblCaracteristicasLugar());
			this.pnlLugar.add(this.iniciarPropCmbCaracteristicasLugar());
			this.pnlLugar.add(this.iniciarPropLblEspecificacionLugar());
			this.pnlLugar.add(this.iniciarPropTxtEspecificacionLugar());
		}

		return this.pnlLugar;
	}

	public JPanel iniciarPropPnlBarrio() throws Exception {

		if (this.pnlBarrio == null) {
			this.pnlBarrio = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_DIR_BARRIO,
					"pnlDireccion", null, EnumEtiquetas.TTL_DIR_PNL_BARRIO, null);
		}

		this.pnlBarrio.add(this.iniciarPropLblNombreBarrio());
		this.pnlBarrio.add(this.iniciarPropTxtNombreBarrio());
		this.pnlBarrio.add(this.iniciarPropLblEstratosBarrio());
		this.pnlBarrio.add(this.iniciarPropCmbEstratosBarrio());

		return this.pnlBarrio;
	}

	public JPanel iniciarPropPnlDepartamento() throws Exception {
		if (this.pnlDepartamento == null) {
			this.pnlDepartamento = UtilComponentesGUI.getInstance().crearPanel(
					EnumDimensionesComponentes.PNL_DIR_DEPARTAMENTO, "pnlDepartamento", null,
					EnumEtiquetas.TTL_DIR_PNL_DEPARTAMENTO, null);
		}

		this.pnlDepartamento.add(this.iniciarPropLblNombreDepartamento());
		this.pnlDepartamento.add(this.iniciarPropCmbDepartamento());

		return this.pnlDepartamento;
	}

	public JPanel iniciarPropPnlMunicipio() throws Exception {
		if (this.pnlMunicipio == null) {
			this.pnlMunicipio = UtilComponentesGUI.getInstance().crearPanel(
					EnumDimensionesComponentes.PNL_DIR_MUNICIPIO, "pnlMunicipio", null,
					EnumEtiquetas.TTL_DIR_PNL_MUNICIPIO, null);
		}

		this.pnlMunicipio.add(this.iniciarPropLblNombreMunicipio());
		this.pnlMunicipio.add(this.iniciarPropCmbMunicipio());

		return this.pnlMunicipio;
	}

	public JPanel iniciarPropPnlCodigoPostal() throws Exception {
		if (this.pnlCodigo == null) {
			this.pnlCodigo = UtilComponentesGUI.getInstance().crearPanel(
					EnumDimensionesComponentes.PNL_DIR_CODIGO_POSTAL, "pnlCodigo", null,
					EnumEtiquetas.TTL_DIR_PNL_CODIGO_POSTAL, null);
		}

		this.pnlCodigo.add(this.iniciarPropLblCodigoPostal());
		this.pnlCodigo.add(this.iniciarPropTxtCodigo());

		return this.pnlCodigo;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo iniciarPropLblEspecificacionesDireccionTradicional Metodo estandar
	 *         para autogestionar el valor del atributo
	 *         lblEspecificacionesDireccionTradicional
	 * @return EtiquetaUtil etiqueta gestionada
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblEspecificacionesDireccionTradicional() throws Exception {

		if (this.lblEspecificacionesDireccionTradicional == null) {

			this.lblEspecificacionesDireccionTradicional = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_DIR_ESPECIFICACIONES_DIRECCION_TRADICIONAL,
					"lblEspecificacionesDireccionTradicional",
					EnumEtiquetas.LBL_DIR_ESPECIFICACIONES_DIRECCION_TRADICIONAL, false, null, true);

			this.lblEspecificacionesDireccionTradicional.setHorizontalAlignment(SwingConstants.CENTER);
		}

		return this.lblEspecificacionesDireccionTradicional;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo iniciarPropLblSectoresUbicacion Metodo estandar para autogestionar el
	 *         valor del atributo lblZonasUbicacion
	 * @return EtiquetaUtil etiqueta gestionada
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblSectoresUbicacion() throws Exception {

		if (this.lblZonasUbicacion == null) {

			this.lblZonasUbicacion = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_DIR_ZONAS_UBICACION, "lblZonasUbicacion",
					EnumEtiquetas.LBL_DIR_ZONAS_UBICACION, false, null, true);

			this.lblZonasUbicacion.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return this.lblZonasUbicacion;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo iniciarPropLblCaracteristicasLugar Metodo estandar para autogestionar
	 *         el valor del atributo lblCaracteristicasLugar
	 * @return EtiquetaUtil etiqueta gestionada
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblCaracteristicasLugar() throws Exception {

		if (this.lblCaracteristicasLugar == null) {

			this.lblCaracteristicasLugar = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_DIR_CARACTERISTICAS_LUGAR, "lblCaracteristicasLugar",
					EnumEtiquetas.LBL_DIR_CARACTERISTICAS_LUGAR, false, null, true);

			this.lblCaracteristicasLugar.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return this.lblCaracteristicasLugar;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo iniciarPropLblEspecificacionLugar Metodo estandar para autogestionar
	 *         el valor del atributo lblEspecificacionLugar
	 * @return EtiquetaUtil etiqueta gestionada
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblEspecificacionLugar() throws Exception {

		if (this.lblEspecificacionLugar == null) {

			this.lblEspecificacionLugar = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_DIR_ESPECIFICACION_LUGAR, "lblEspecificacionLugar",
					EnumEtiquetas.LBL_DIR_ESPECIFICACION_LUGAR, false, null, true);

			this.lblEspecificacionLugar.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return this.lblEspecificacionLugar;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo iniciarPropLblNombreBarrio Metodo estandar para autogestionar el
	 *         valor del atributo lblNombreBarrio
	 * @return EtiquetaUtil etiqueta gestionada
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblNombreBarrio() throws Exception {

		if (this.lblNombreBarrio == null) {

			this.lblNombreBarrio = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_DIR_NOMBRE_BARRIO, "lblNombreBarrio",
					EnumEtiquetas.LBL_DIR_NOMBRE_BARRIO, false, null, true);

			this.lblNombreBarrio.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return this.lblNombreBarrio;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo iniciarPropLblEstratosBarrio Metodo estandar para autogestionar el
	 *         valor del atributo lblEstratosBarrio
	 * @return EtiquetaUtil etiqueta gestionada
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblEstratosBarrio() throws Exception {

		if (this.lblEstratosBarrio == null) {

			this.lblEstratosBarrio = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_DIR_ESTRATOS_BARRIO, "lblEstratosBarrio",
					EnumEtiquetas.LBL_DIR_ESTRATOS_BARRIO, false, null, true);

			this.lblEstratosBarrio.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return this.lblEstratosBarrio;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo iniciarPropLblNombreBarrio Metodo estandar para autogestionar el
	 *         valor del atributo lblNombreBarrio
	 * @return EtiquetaUtil etiqueta gestionada
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblNombreDepartamento() throws Exception {

		if (this.lblDepartamentoNombre == null) {

			this.lblDepartamentoNombre = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_DIR_NOMBRE_DEPARTAMENTO, "lblNombreDepartamento",
					EnumEtiquetas.LBL_DIR_DEPARTAMENTO, false, null, true);

			this.lblDepartamentoNombre.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return this.lblDepartamentoNombre;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo iniciarPropLblNombreBarrio Metodo estandar para autogestionar el
	 *         valor del atributo lblNombreBarrio
	 * @return EtiquetaUtil etiqueta gestionada
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblNombreMunicipio() throws Exception {

		if (this.lblMunicipioNombre == null) {

			this.lblMunicipioNombre = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_DIR_NOMBRE_MUNICIPIO, "lblNombreMunicipio",
					EnumEtiquetas.LBL_DIR_MUNICIPIO, false, null, true);

			this.lblMunicipioNombre.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return this.lblMunicipioNombre;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo iniciarPropLblNombreBarrio Metodo estandar para autogestionar el
	 *         valor del atributo lblNombreBarrio
	 * @return EtiquetaUtil etiqueta gestionada
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblCodigoPostal() throws Exception {

		if (this.lblCodigoPostal == null) {

			this.lblCodigoPostal = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_DIR_CODIGO_POSTAL, "lblCodigoPostal", EnumEtiquetas.LBL_DIR_CODIGO,
					false, null, true);

			this.lblCodigoPostal.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return this.lblCodigoPostal;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo iniciarPropLblSeparadorInterseccionVia Metodo estandar para
	 *         autogestionar el valor del atributo lblSeparadorInterseccionVia
	 * @return EtiquetaUtil etiqueta gestionada
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblSeparadorInterseccionVia() throws Exception {

		if (this.lblSeparadorInterseccionVia == null) {

			this.lblSeparadorInterseccionVia = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_DIR_SEPARADOR_INTERSECCION_VIA, "lblSeparadorInterseccionVia",
					EnumEtiquetas.LBL_DIR_SEPARADOR_INTERSECCION_VIA, false, null, true);

			this.lblSeparadorInterseccionVia.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return this.lblSeparadorInterseccionVia;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo iniciarPropLblSeparadorLugarInterseccion Metodo estandar para
	 *         autogestionar el valor del atributo lblSeparadorLugarInterseccion
	 * @return EtiquetaUtil etiqueta gestionada
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblSeparadorLugarInterseccion() throws Exception {

		if (this.lblSeparadorLugarInterseccion == null) {

			this.lblSeparadorLugarInterseccion = UtilComponentesGUI.getInstance().crearLabel(
					EnumDimensionesComponentes.LBL_DIR_SEPARADOR_LUGAR_INTERSECCION, "lblSeparadorLugarInterseccion",
					EnumEtiquetas.LBL_DIR_SEPARADOR_LUGAR_INTERSECCION, false, null, true);

			this.lblSeparadorLugarInterseccion.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return this.lblSeparadorLugarInterseccion;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo iniciarPropTxtNumeroVia Metodo estandar para autogestionar el valor
	 *         del atributo txtNumeroVia
	 * @return CajaTextoUtil caja de texto gestionada
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtNumeroVia() throws Exception {

		if (this.txtNumeroVia == null) {

			this.txtNumeroVia = UtilComponentesGUI.getInstance().crearTextField(
					EnumDimensionesComponentes.TXT_DIR_NUMERO_VIA, "txtNumeroVia", "", true, true, true,
					super.getEventoForma(), EnumEtiquetas.TLT_DIR_VIA);

			this.txtNumeroVia.setToolTipText(EnumEtiquetas.TLT_DIR_VIA);
		}
		return this.txtNumeroVia;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo iniciarPropTxtNumeroInterseccion Metodo estandar para autogestionar
	 *         el valor del atributo txtNumeroInterseccion
	 * @return CajaTextoUtil caja de texto gestionada
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtNumeroInterseccion() throws Exception {

		if (this.txtNumeroInterseccion == null) {

			this.txtNumeroInterseccion = UtilComponentesGUI.getInstance().crearTextField(
					EnumDimensionesComponentes.TXT_DIR_NUMERO_INTERSECCION, "txtNumeroInterseccion", "", true, true,
					true, super.getEventoForma(), EnumEtiquetas.TLT_DIR_INTERSECCION);

			this.txtNumeroInterseccion.setToolTipText(EnumEtiquetas.TLT_DIR_INTERSECCION);
		}
		return this.txtNumeroInterseccion;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo iniciarPropTxtNumeroLugar Metodo estandar para autogestionar el valor
	 *         del atributo txtNumeroLugar
	 * @return CajaTextoUtil caja de texto gestionada
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtNumeroLugar() throws Exception {

		if (this.txtNumeroLugar == null) {

			this.txtNumeroLugar = UtilComponentesGUI.getInstance().crearTextField(
					EnumDimensionesComponentes.TXT_DIR_NUMERO_LUGAR, "txtNumeroLugar", "", true, true, true,
					super.getEventoForma(), EnumEtiquetas.TLT_DIR_LUGAR);

			this.txtNumeroLugar.setToolTipText(EnumEtiquetas.TLT_DIR_LUGAR);
		}
		return this.txtNumeroLugar;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo iniciarPropTxtEspecificacionLugar Metodo estandar para autogestionar
	 *         el valor del atributo txtEspecificacionLugar
	 * @return CajaTextoUtil caja de texto gestionada
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtEspecificacionLugar() throws Exception {

		if (this.txtEspecificacionLugar == null) {

			this.txtEspecificacionLugar = UtilComponentesGUI.getInstance().crearTextField(
					EnumDimensionesComponentes.TXT_DIR_ESPECIFICACION_LUGAR, "txtEspecificacionLugar", "", true, true,
					true, super.getEventoForma(), EnumEtiquetas.LBL_DIR_ESPECIFICACION_LUGAR);
		}
		return this.txtEspecificacionLugar;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo iniciarPropTxtNombreBarrio Metodo estandar para autogestionar el
	 *         valor del atributo txtNombreBarrio
	 * @return CajaTextoUtil caja de texto gestionada
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtNombreBarrio() throws Exception {

		if (this.txtNombreBarrio == null) {

			this.txtNombreBarrio = UtilComponentesGUI.getInstance().crearTextField(
					EnumDimensionesComponentes.TXT_DIR_NOMBRE_BARRIO, "txtNombreBarrio", "", true, true, true,
					super.getEventoForma(), EnumEtiquetas.LBL_DIR_NOMBRE_BARRIO);
		}
		return this.txtNombreBarrio;
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo iniciarPropTxtNombreBarrio Metodo estandar para autogestionar el
	 *         valor del atributo txtNombreBarrio
	 * @return CajaTextoUtil caja de texto gestionada
	 * @throws Exception Controla, recupera y escala, cualquier tipo de excepcion
	 *                   presentada
	 * @autor Hector Q-en-K
	 *        ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtCodigo() throws Exception {

		if (this.txtCodigo == null) {

			this.txtCodigo = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_DIR_CODIGO,
					"txtCodigo", "", true, true, true, super.getEventoForma(), EnumEtiquetas.LBL_DIR_CODIGO);
		}
		return this.txtCodigo;
	}

	public EventoFormaDireccion castEvtFrmDireccion() throws Exception {
		return (EventoFormaDireccion) super.getEventoForma();
	}

	public JPanel getPnlEspecificacion() {
		return pnlEspecificacion;
	}

	public void setPnlEspecificacion(JPanel pnlEspecificacion) {
		this.pnlEspecificacion = pnlEspecificacion;
	}

	public JPanel getPnlDireccionTradicional() {
		return pnlDireccionTradicional;
	}

	public void setPnlDireccionTradicional(JPanel pnlDireccionTradicional) {
		this.pnlDireccionTradicional = pnlDireccionTradicional;
	}

	public JPanel getPnlUbicacion() {
		return pnlUbicacion;
	}

	public void setPnlUbicacion(JPanel pnlUbicacion) {
		this.pnlUbicacion = pnlUbicacion;
	}

	public JPanel getPnlLugar() {
		return pnlLugar;
	}

	public void setPnlLugar(JPanel pnlLugar) {
		this.pnlLugar = pnlLugar;
	}

	public EtiquetaUtil getLblClasesVia() {
		return lblClasesVia;
	}

	public void setLblClasesVia(EtiquetaUtil lblClasesVia) {
		this.lblClasesVia = lblClasesVia;
	}

	public EtiquetaUtil getLblEspecificacionAbierta() {
		return lblEspecificacionAbierta;
	}

	public void setLblEspecificacionAbierta(EtiquetaUtil lblEspecificacionAbierta) {
		this.lblEspecificacionAbierta = lblEspecificacionAbierta;
	}

	public EtiquetaUtil getLblEspecificacionesDireccionTradicional() {
		return lblEspecificacionesDireccionTradicional;
	}

	public void setLblEspecificacionesDireccionTradicional(EtiquetaUtil lblEspecificacionesDireccionTradicional) {
		this.lblEspecificacionesDireccionTradicional = lblEspecificacionesDireccionTradicional;
	}

	public EtiquetaUtil getLblSeparadorInterseccionVia() {
		return lblSeparadorInterseccionVia;
	}

	public void setLblSeparadorInterseccionVia(EtiquetaUtil lblSeparadorInterseccionVia) {
		this.lblSeparadorInterseccionVia = lblSeparadorInterseccionVia;
	}

	public EtiquetaUtil getLblSeparadorLugarInterseccion() {
		return lblSeparadorLugarInterseccion;
	}

	public void setLblSeparadorLugarInterseccion(EtiquetaUtil lblSeparadorLugarInterseccion) {
		this.lblSeparadorLugarInterseccion = lblSeparadorLugarInterseccion;
	}

	public EtiquetaUtil getLblZonasUbicacion() {
		return lblZonasUbicacion;
	}

	public void setLblZonasUbicacion(EtiquetaUtil lblZonasUbicacion) {
		this.lblZonasUbicacion = lblZonasUbicacion;
	}

	public EtiquetaUtil getLblCaracteristicasLugar() {
		return lblCaracteristicasLugar;
	}

	public void setLblCaracteristicasLugar(EtiquetaUtil lblCaracteristicasLugar) {
		this.lblCaracteristicasLugar = lblCaracteristicasLugar;
	}

	public EtiquetaUtil getLblEspecificacionLugar() {
		return lblEspecificacionLugar;
	}

	public void setLblEspecificacionLugar(EtiquetaUtil lblEspecificacionLugar) {
		this.lblEspecificacionLugar = lblEspecificacionLugar;
	}

	public EtiquetaUtil getLblNombreBarrio() {
		return lblNombreBarrio;
	}

	public void setLblNombreBarrio(EtiquetaUtil lblNombreBarrio) {
		this.lblNombreBarrio = lblNombreBarrio;
	}

	public EtiquetaUtil getLblEstratosBarrio() {
		return lblEstratosBarrio;
	}

	public void setLblEstratosBarrio(EtiquetaUtil lblEstratosBarrio) {
		this.lblEstratosBarrio = lblEstratosBarrio;
	}

	public CajaComboUtil getCmbClasesVia() {
		return cmbClasesVia;
	}

	public void setCmbClasesVia(CajaComboUtil cmbClasesVia) {
		this.cmbClasesVia = cmbClasesVia;
	}

	public CajaComboUtil getCmbZonasUbicacion() {
		return cmbZonasUbicacion;
	}

	public void setCmbZonasUbicacion(CajaComboUtil cmbZonasUbicacion) {
		this.cmbZonasUbicacion = cmbZonasUbicacion;
	}

	public CajaComboUtil getCmbCaracteristicasLugar() {
		return cmbCaracteristicasLugar;
	}

	public void setCmbCaracteristicasLugar(CajaComboUtil cmbCaracteristicasLugar) {
		this.cmbCaracteristicasLugar = cmbCaracteristicasLugar;
	}

	public CajaComboUtil getCmbEstratosBarrio() {
		return cmbEstratosBarrio;
	}

	public void setCmbEstratosBarrio(CajaComboUtil cmbEstratosBarrio) {
		this.cmbEstratosBarrio = cmbEstratosBarrio;
	}

	public CajaTextoUtil getTxtEspecificacionAbierta() {
		return txtEspecificacionAbierta;
	}

	public void setTxtEspecificacionAbierta(CajaTextoUtil txtEspecificacionAbierta) {
		this.txtEspecificacionAbierta = txtEspecificacionAbierta;
	}

	public CajaTextoUtil getTxtNumeroVia() {
		return txtNumeroVia;
	}

	public void setTxtNumeroVia(CajaTextoUtil txtNumeroVia) {
		this.txtNumeroVia = txtNumeroVia;
	}

	public CajaTextoUtil getTxtNumeroInterseccion() {
		return txtNumeroInterseccion;
	}

	public void setTxtNumeroInterseccion(CajaTextoUtil txtNumeroInterseccion) {
		this.txtNumeroInterseccion = txtNumeroInterseccion;
	}

	public CajaTextoUtil getTxtNumeroLugar() {
		return txtNumeroLugar;
	}

	public void setTxtNumeroLugar(CajaTextoUtil txtNumeroLugar) {
		this.txtNumeroLugar = txtNumeroLugar;
	}

	public CajaTextoUtil getTxtEspecificacionLugar() {
		return txtEspecificacionLugar;
	}

	public void setTxtEspecificacionLugar(CajaTextoUtil txtEspecificacionLugar) {
		this.txtEspecificacionLugar = txtEspecificacionLugar;
	}

	public CajaTextoUtil getTxtNombreBarrio() {
		return txtNombreBarrio;
	}

	public void setTxtNombreBarrio(CajaTextoUtil txtNombreBarrio) {
		this.txtNombreBarrio = txtNombreBarrio;
	}

	public JPanel getPnlBarrio() {
		return pnlBarrio;
	}

	public void setPnlBarrio(JPanel pnlBarrio) {
		this.pnlBarrio = pnlBarrio;
	}

	public EtiquetaUtil getLblCodigoPostal() {
		return lblCodigoPostal;
	}

	public void setLblCodigoPostal(EtiquetaUtil lblCodigoPostal) {
		this.lblCodigoPostal = lblCodigoPostal;
	}

	public EtiquetaUtil getLblDepartamentoNombre() {
		return lblDepartamentoNombre;
	}

	public void setLblDepartamentoNombre(EtiquetaUtil lblDepartamentoNombre) {
		this.lblDepartamentoNombre = lblDepartamentoNombre;
	}

	public CajaComboUtil getCmbDepartamento() {
		return cmbDepartamento;
	}

	public void setCmbDepartamento(CajaComboUtil cmbDepartamento) {
		this.cmbDepartamento = cmbDepartamento;
	}

	public EtiquetaUtil getLblMunicipioNombre() {
		return lblMunicipioNombre;
	}

	public void setLblMunicipioNombre(EtiquetaUtil lblMunicipioNombre) {
		this.lblMunicipioNombre = lblMunicipioNombre;
	}

	public CajaComboUtil getCmbMunicipio() {
		return cmbMunicipio;
	}

	public void setCmbMunicipio(CajaComboUtil cmbMunicipio) {
		this.cmbMunicipio = cmbMunicipio;
	}

	public CajaTextoUtil getTxtCodigo() {
		return txtCodigo;
	}

	public void setTxtCodigo(CajaTextoUtil txtCodigo) {
		this.txtCodigo = txtCodigo;
	}

	public static void main(String[] args) {
		// String direccionEspecifica = "Calle 25B # 25 - 211. Zona: Sur. Apartamento:
		// 201. Barrio: COLSEGUROS. Estrato: 6.";
		// String direccionAbierta = "Vereda: descripcion abierta de vereda";

		// String direccionEspecifica = "CALLE 12 # 34 - 56. ZONA: NORTE. APARTAMENTO:
		// APTO 201.";
		// String direccionEspecifica = "Transversal 21 # 321S - 221. Zona: Centro.
		// Centro Comercial: UNICENTRO.";
		// String direccionEspecifica = null;
		try {

			new FormaDireccion(null, true, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
package co.com.codesa.clienteposslimgiros.formas.pruebaadmisionentregatirilla;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.operaciones.EnumTiposOperaciones;
import co.com.codesa.clienteposslimgiros.eventos.gridpropiedadesconvenios.EventoFormaPropiedadesAdmisionEntregaTirilla;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.AreaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.BotonUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelPropiedadesAdmisionEntregaTirilla;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DatoEntidad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.PruebaCRCAdmisionEntrega;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;

/**
 * 
 * ********************************************************************
 * 
 * @class FormaPropiedadesPeps Forma encargada de visualizar las preguntas para
 *        los terceros PEPS
 * @author dsalazar [PlayTech]
 * @date 20-feb-2019
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 *            *********
 *            ************************************************************
 */
public class FormaPropiedadesAdmisionEntregaTirilla extends FormaGenerica {

	/**
	 * @variable: pnlPropiedadesPeps Panel encargado de pintar la grilla de
	 *            propiedades peps
	 */
	private FormaPanelPropiedadesAdmisionEntregaTirilla pnlPropiedadesAdmEntTirillas;

	/**
	 * @variable: txtPreguntaPruebaAdmisionEntrega Texto con pregunta que se
	 *            realiza al tercero cliente
	 */
	private AreaTextoUtil txtPreguntaPruebaAdmisionEntrega;

	/**
	 * @variable: objTerceroPeps Objeto TerceroPeps correspondiente a la
	 *            funcionalidad PEPS
	 */
	private PruebaCRCAdmisionEntrega objPruebaAdmisionEntrega;

	/**
	 * @variable: objUsuario Objeto Usuario cajero que efectua la peticion
	 */
	private Usuario objUsuario;

	/**
	 * @variable txtValorPropiedad campo de texto sobre la forma que contiene el
	 *           valor que va ha ser enviado.
	 */
	private CajaTextoUtil txtValorPropiedad;

	

	/**
	 * @variable: btnAceptar
	 */
	private BotonUtil btnAceptar;

	/**
	 * @variable: btnCancelar
	 */
	private BotonUtil btnCancelar;

	/**
	 * 
	 */
	private boolean booSeleccionaDiferenteFisica;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String strRespuetaCRC;
	
	
	private boolean blnSeleccionDiferenteFisica;

	/**
	 * 
	 * ********************************************************************
	 * 
	 * @method FormaPropiedadesPeps Constructor de la forma Propiedades PEPS
	 * @param pFrmPadre
	 *            Forma principal que invoca el llamado de la forma
	 * @param pBooModal
	 *            Variable modal
	 * @param pObjUsuario
	 *            Usuario cajero que realiza la peticion
	 * @param pObjTercero
	 *            Tercero al cual se le realiza el proceso de PEPS
	 * @param pBooProcesarPeticion
	 *            Bandera que indica si se debe enviarse la trama de registrar
	 *            informacion 
	 * @param pIntOperacion operacion registrada en PASI como envio, pago,
	 *            cambio de operacion               
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author dsalazar [PlayTech]
	 * @date 20-feb-2019
	 *       *********************************************************
	 *       ************
	 */
	public FormaPropiedadesAdmisionEntregaTirilla(FormaGenerica pFrmPadre,
			boolean pBooModal, Usuario pObjUsuario, PruebaCRCAdmisionEntrega pobjPruebaCRC, 
			Tercero pObjTercero,
			boolean pBooProcesarPeticion,
			EnumTiposOperaciones pEnmTipoOperacion) throws Exception {

		super(pFrmPadre, pBooModal);

		super.setEventoForma(new EventoFormaPropiedadesAdmisionEntregaTirilla(
				this, pobjPruebaCRC, pObjTercero, pBooProcesarPeticion, pEnmTipoOperacion));
		this.iniciarTituloForma(pObjTercero);

		super.setTituloForma(EnumEtiquetas.TTL_CRC_FORMA_PROPIEDADES_ADMENV);

		this.setObjUsuario(pObjUsuario);

		this.iniciarPropTxtValorPropiedad();
		this.inicializarForma();
	}

	@Override
	public void inicializarForma(Object... pArrObjParametrosForma)
			throws Exception {

		super.setAnchoForma(EnumDimensionesComponentes.GUI_PPS_VENTANA
				.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.GUI_PPS_VENTANA.getAlto());

		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
				EnumBotonesEncabezado.BTNVOLVER);

		super.iniciar(pArrObjParametrosForma);

	}

	/**
	 * 
	 * ********************************************************************
	 * 
	 * @method iniciarPropPnlPropiedadesPeps Inicia el panel que contiene la
	 *         grilla de propiedades PEPS
	 * @return Panel con grilla de propiedades peps consultada en base de datos
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author dsalazar[PlayTech]
	 * @date 19-feb-2019
	 *       ********************************************************
	 *       *************
	 */
	private FormaPanelPropiedadesAdmisionEntregaTirilla iniciarPropPnlPropiedadesAdmEntTirilla()
			throws Exception {

		return getPnlPropiedadesAdmEntTirillas();

	}

	/**
	 * 
	 * ********************************************************************
	 * 
	 * @method iniciarPropAreaTextoPreguntaPeps Metodo encargado de incializar
	 *         el area de texto que contiene la pregunta a realizar al Tercero
	 *         presente en una de las transacciones core del sistema
	 * @return AreaTexto con la pregunta formulada tomada desde una etiqueta del
	 *         sistema
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author dsalazar [PlayTech]
	 * @date 20-feb-2019
	 *       *********************************************************
	 *       ************
	 */
	private AreaTextoUtil iniciarPropAreaTextoPreguntaPeps() throws Exception {

		if (txtPreguntaPruebaAdmisionEntrega == null) {

			txtPreguntaPruebaAdmisionEntrega = UtilComponentesGUI.getInstance()
					.crearTextArea(
							EnumDimensionesComponentes.LBL_CRC_PREGUNTA_ADMENV,
							"areaTextoPregunta",
							EnumEtiquetas.LBL_CRC_PREGUNTA_ADMENV
									.getValor(false), false, false, true, null,
							EnumEtiquetas.LBL_CRC_PREGUNTA_ADMENV);
		}

		return txtPreguntaPruebaAdmisionEntrega;

	}

	/**
	 * 
	 * ********************************************************************
	 * 
	 * @method iniciarTituloForma Metodo encargado de establecer el titulo de la
	 *         forma
	 * @param pObjTercero
	 *            Objeto tercero al cual se le realiza el proceso PEPS
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author dsalazar[PlayTech]
	 * @date 19-feb-2019
	 *       ********************************************************
	 *       *************
	 */
	private void iniciarTituloForma(Tercero pObjTercero) throws Exception {

		EnumEtiquetas.TTL_CRC_FORMA_PROPIEDADES_ADMENV.setProcesado(false);

		String strNombres = "";
		String strApellido1 = "";
		String strApellido2 = "";

		if (pObjTercero.getNombres() != null) {
			strNombres = pObjTercero.getNombres().toUpperCase();
		}

		if (pObjTercero.getApellido1() != null) {
			strApellido1 = pObjTercero.getApellido1().toUpperCase();
		}

		if (pObjTercero.getApellido2() != null) {
			strApellido2 = pObjTercero.getApellido2().toUpperCase();
		}

		String strTitulo = EnumEtiquetas.TTL_CRC_FORMA_PROPIEDADES_ADMENV
				.toString()
				+ " - "
				+ pObjTercero.getDescripcion()
				+ " "
				+ pObjTercero.getIdentificacion()
				+ " "
				+ strNombres
				+ " "
				+ strApellido1 + " " + strApellido2;

		EnumEtiquetas.TTL_CRC_FORMA_PROPIEDADES_ADMENV.setValor(strTitulo);
	}

	@Override
	public JPanel inicializarEncabezado(Object... pArrObjParametrosForma)
			throws Exception {
		return null;
	}

	@Override
	public JPanel inicializarCuerpo(Object... pArrObjParametrosForma)
			throws Exception {

		JPanel pnlCuerpo;

		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(
				EnumDimensionesComponentes.JPN_PPS_VENTANA, "pnlCuerpo", null,
				null, null);
		pnlCuerpo.add(this.iniciarPropPnlPropiedadesAdmEntTirilla());
		pnlCuerpo.add(this.iniciarPropAreaTextoPreguntaPeps());
		pnlCuerpo.add(this.getBtnAceptar());
		pnlCuerpo.add(this.getBtnCancelar());
		return pnlCuerpo;
	}

	@Override
	public JPanel inicializarPiePagina(Object... pArrObjParametrosForma)
			throws Exception {
		return null;
	}

	/**
	 * 
	 * ********************************************************************
	 * 
	 * @method getPnlPropiedadesPeps Metodo get del panel propiedadesPeps
	 * @return PanelPropiedadesPeps
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author dsalazar[PlayTech]
	 * @date 19-feb-2019
	 *       ********************************************************
	 *       *************
	 */
	public FormaPanelPropiedadesAdmisionEntregaTirilla getPnlPropiedadesAdmEntTirillas()
			throws Exception {

		if (pnlPropiedadesAdmEntTirillas == null) {

			pnlPropiedadesAdmEntTirillas = new FormaPanelPropiedadesAdmisionEntregaTirilla(
					this, EnumDimensionesComponentes.JPN_PPS_PEPS_PANEL_CUERPO,
					"pnlPropiedadesPeps");

		}

		return pnlPropiedadesAdmEntTirillas;
	}

	/**
	 * 
	 * ********************************************************************
	 * 
	 * @method getBtnAceptar [TODO - DOC]: Descripcion del metodo, cual es su
	 *         uso, la necesidad y su aporte y como se integra con la
	 *         funcionalidad
	 * @return Objeto BotonUtil
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author dsalazar [PlayTech]
	 * @date 20-feb-2019
	 *       *********************************************************
	 *       ************
	 */
	public BotonUtil getBtnAceptar() throws Exception {
		if (btnAceptar == null) {

			btnAceptar = UtilComponentesGUI.getInstance().crearBoton(
					EnumDimensionesComponentes.BTN_CRC_ACEPTAR,
					"btn_crc_aceptar", EnumEtiquetas.BTN_CRC_ACEPTAR, true,
					true, super.getEventoForma(), null);
		}

		return btnAceptar;
	}

	/**
	 * 
	 * ********************************************************************
	 * 
	 * @method getBtnCancelar Metodo get del boton cancelar
	 * @return Bonton Util Cancelar
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author dsalazar [PlayTech]
	 * @date 20-feb-2019
	 *       *********************************************************
	 *       ************
	 */
	public BotonUtil getBtnCancelar() throws Exception {
		if (btnCancelar == null) {

			btnCancelar = UtilComponentesGUI.getInstance().crearBoton(
					EnumDimensionesComponentes.BTN_CRC_CANCELAR,
					"btn_crc_cancelar", EnumEtiquetas.BTN_CRC_CANCELAR, true,
					true, super.getEventoForma(), null);
		}

		return btnCancelar;
	}

	/**
	 * 
	 * ********************************************************************
	 * 
	 * @method setPnlPropiedadesPeps metodo set del atributo pnlPropiedadesPeps
	 * @param pnlPropiedadesPeps
	 *            Panel con las preguntas correspondientes a PEPS
	 * @author dsalazar [PlayTech]
	 * @date 20-feb-2019
	 *       *********************************************************
	 *       ************
	 */
	/*
	 * public void
	 * setPnlPropiedadesPeps(FormaPanelPropiedadesAdmisionEntregaTirilla
	 * pnlPropiedadesAdmEntTirillas) { this.pnlPropiedadesAdmEntTirillas =
	 * pnlPropiedadesAdmEntTirillas; }
	 */

	/**
	 * 
	 * ********************************************************************
	 * 
	 * @method getTxtPreguntaPeps Metodo get del componente areaTexto
	 * @return componente areaTexto con la pregunta formulada
	 * @author dsalazar [PlayTech]
	 * @date 20-feb-2019
	 *       *********************************************************
	 *       ************
	 */
	public AreaTextoUtil getTxtPreguntaPeps() {
		return txtPreguntaPruebaAdmisionEntrega;
	}

	/**
	 * 
	 * ********************************************************************
	 * 
	 * @method setTxtPreguntaPeps Metodo set del componente areaTextoUtil
	 * @param txtPreguntaPeps
	 *            componente areaTexto pregunta peps
	 * @author dsalazar [PlayTech]
	 * @date 20-feb-2019
	 *       *********************************************************
	 *       ************
	 */
	public void setTxtPreguntaPeps(AreaTextoUtil txtPreguntaPeps) {
		this.txtPreguntaPruebaAdmisionEntrega = txtPreguntaPeps;
	}

	public Usuario getObjUsuario() {
		return objUsuario;
	}

	public void setObjUsuario(Usuario objUsuario) {
		this.objUsuario = objUsuario;
	}

	

	/**
	 * @return the objPruebaAdmisionEntrega
	 */
	public PruebaCRCAdmisionEntrega getObjPruebaAdmisionEntrega() {
		return objPruebaAdmisionEntrega;
	}

	/**
	 * @param objPruebaAdmisionEntrega the objPruebaAdmisionEntrega to set
	 */
	public void setObjPruebaAdmisionEntrega(
			PruebaCRCAdmisionEntrega objPruebaAdmisionEntrega) {
		this.objPruebaAdmisionEntrega = objPruebaAdmisionEntrega;
	}
	


	/**
	 * @return the booSeleccionaDiferenteFisica
	 */
	public boolean isBooSeleccionaDiferenteFisica() {
		return booSeleccionaDiferenteFisica;
	}

	/**
	 * @param booSeleccionaDiferenteFisica the booSeleccionaDiferenteFisica to set
	 */
	public void setBooSeleccionaDiferenteFisica(boolean booSeleccionaDiferenteFisica) {
		this.booSeleccionaDiferenteFisica = booSeleccionaDiferenteFisica;
	}
	
	
	

	public static void main(String[] args) {

		DatoEntidad objDatEntTipoIdentificacion;

		try {

			TestPruebasInternas.getInstance().iniciarPruebaInterna(null, true,
					EnumDesplegarFormaConEventos.SI);

			InformacionSessionGiros.getInstance().getObjUsuario().getEmpresa()
					.setId("1");

			objDatEntTipoIdentificacion = new DatoEntidad("3");

			Tercero tercero = new Tercero(objDatEntTipoIdentificacion, "45");
			PruebaCRCAdmisionEntrega pobjPruebaCRC = null;

			new FormaPropiedadesAdmisionEntregaTirilla(null, true,
					InformacionSessionGiros.getInstance().getObjUsuario(),
					pobjPruebaCRC,
					tercero, false,EnumTiposOperaciones.ENVIO_FACTURACION_GIRO);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param pnlPropiedadesAdmEntTirillas
	 *            the pnlPropiedadesAdmEntTirillas to set
	 */
	public void setPnlPropiedadesAdmEntTirillas(
			FormaPanelPropiedadesAdmisionEntregaTirilla pnlPropiedadesAdmEntTirillas) {
		this.pnlPropiedadesAdmEntTirillas = pnlPropiedadesAdmEntTirillas;
	}
	
	
	/*
	 * Iniciando componente para digitar valor de la propiedad
	 */
	public CajaTextoUtil iniciarPropTxtValorPropiedad() throws Exception {

		if (this.txtValorPropiedad == null) {

			this.txtValorPropiedad = UtilComponentesGUI
					.getInstance()
					.crearTextField(
							EnumDimensionesComponentes.TXT_CRC_VALOR_PROPIEDAD,
							"txtValorPropiedad", "", true, true, true,
							this.getEventoForma(), null);
			this.txtValorPropiedad
					.setHorizontalAlignment(SwingConstants.TRAILING);
			this.txtValorPropiedad.setForeground(new java.awt.Color(0, 0, 0));
			this.txtValorPropiedad.setBackground(new java.awt.Color(164, 164,
					255));
			this.txtValorPropiedad
					.setToolTipText(EnumEtiquetas.TLT_CRC_VALOR_PROPIEDAD);
		}

		return this.txtValorPropiedad;
	}

	/**
	 * @return the strRespuetaCRC
	 */
	public String getStrRespuetaCRC() {
		return strRespuetaCRC;
	}

	/**
	 * @param strRespuetaCRC the strRespuetaCRC to set
	 */
	public void setStrRespuetaCRC(String strRespuetaCRC) {
		this.strRespuetaCRC = strRespuetaCRC;
	}

	/**
	 * @return the blnSeleccionDiferenteFisica
	 */
	public boolean isBlnSeleccionDiferenteFisica() {
		return blnSeleccionDiferenteFisica;
	}

	/**
	 * @param blnSeleccionDiferenteFisica the blnSeleccionDiferenteFisica to set
	 */
	public void setBlnSeleccionDiferenteFisica(boolean blnSeleccionDiferenteFisica) {
		this.blnSeleccionDiferenteFisica = blnSeleccionDiferenteFisica;
	}
	
	
	

}

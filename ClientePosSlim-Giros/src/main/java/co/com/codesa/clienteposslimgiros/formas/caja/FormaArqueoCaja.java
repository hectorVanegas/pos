package co.com.codesa.clienteposslimgiros.formas.caja;

import java.awt.Font;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import co.com.codesa.clienteposslim.logger.Logger;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumImagenes;
import co.com.codesa.clienteposslimgiros.eventos.caja.EventoFormaArqueoCaja;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.AreaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.BotonUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaFechaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.GrillaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.utilidades.integracion.slimGiros.UtilIntegracionSlimGiros;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.caja.arqueo.InfoCierreCajaDTO;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 14-abr-2015
 * @Clase FormaArqueoCaja 
 * 		  Clase que genera la forma (GUI) para el proceso de
 *        arqueo de caja
 * @copyright: Copyright 1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class FormaArqueoCaja extends FormaGenerica {

	/**
	 * @variable 	serialVersionUID
	 * 			 	Variable serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @variable pnlSeccionBilletes 
	 * 			 seccion que agrupa los componentes graficos para el ingreso 
	 * 			 de cantidad por monto de tipo de billete
	 **/
	private JPanel pnlSeccionBilletes;

	/**
	 * @variable pnlSeccionCheques 
	 * 			 seccion que agrupa los componentes graficos para el ingreso 
	 * 			 de cheques
	 **/
	private JPanel pnlSeccionCheques;

	/**
	 * @variable pnlSeccionVales 
	 * 			 seccion que agrupa los componentes graficos para el ingreso 
	 * 			 de vales
	 **/
	private JPanel pnlSeccionVales;

	/**
	 * @variable pnlSeccionMonedas 
	 * 			 seccion que agrupa los componentes graficos para el ingreso 
	 * 			 de cantidad por monto de tipo de moneda
	 **/
	private JPanel pnlSeccionMonedas;

	/**
	 * @variable pnlDatAdiCheque 
	 * 			 seccion que agrupa los componentes graficos para la solicitud 
	 * 			 de datos adicionales para el ingreso de cheque
	 **/
	private JPanel pnlDatAdiCheque;

	/**
	 * @variable pnlDatAdiVale 
	 * 			 seccion que agrupa los componentes graficos para la solicitud 
	 * 			 de datos adicionales para el ingreso de vale
	 **/
	private JPanel pnlDatAdiVale;

	/**
	 * @variable pnlSeccionCuadreCaja 
	 * 			 seccion que agrupa los componentes graficos donde se consolida 
	 * 			 el cuadre de caja
	 **/
	private JPanel pnlSeccionCuadreCaja;

	/**
	 * @variable scpGrillaDenominacionBilletes 
	 * 			 componente grafico que permite incluir barras de desplazamiento 
	 * 			 para facilitar el despliegue de la grilla
	 **/
	private JScrollPane scpGrillaDenominacionBilletes;

	/**
	 * @variable scpGrillaCheques 
	 * 			 componente grafico que permite incluir barras de desplazamiento 
	 * 			 para facilitar el despliegue de la grilla
	 **/
	private JScrollPane scpGrillaCheques;

	/**
	 * @variable scpGrillaVales 
	 * 			 componente grafico que permite incluir barras de desplazamiento 
	 * 			 para facilitar el despliegue de la grilla
	 **/
	private JScrollPane scpGrillaVales;

	/**
	 * @variable scpGrillaDenominacionMonedas 
	 * 			 componente grafico que permite incluir barras de desplazamiento 
	 * 			 para facilitar el despliegue de la grilla
	 **/
	private JScrollPane scpGrillaDenominacionMonedas;

	/**
	 * @variable tblDenominacionBilletes 
	 * 			 grilla donde se relaciona la informacion asociada a a la 
	 * 			 denominacion de billetes
	 **/
	private GrillaUtil tblDenominacionBilletes;

	/**
	 * @variable tblCheques 
	 * 			 grilla donde se relaciona la informacion asociada a al ingreso 
	 * 			 de cheques
	 **/
	private GrillaUtil tblCheques;

	/**
	 * @variable tblVales 
	 * 			 grilla donde se relaciona la informacion asociada a al ingreso 
	 * 			 de vales
	 **/
	private GrillaUtil tblVales;

	/**
	 * @variable tblDenominacionMonedas 
	 * 			 grilla donde se relaciona la informacion asociada a a la 
	 * 			 denominacion de monedas
	 **/
	private GrillaUtil tblDenominacionMonedas;

	/**
	 * @variable lblListaBilletes 
	 * 			 etiqueta para indicar el componente grafico sobre la forma para 
	 * 			 seleccionar un monto de billetes especifico
	 **/
	private EtiquetaUtil lblListaBilletes;

	/**
	 * @variable lblListaCheques 
	 * 			 etiqueta para indicar el componente grafico sobre la forma para 
	 * 			 seleccionar un Cheque
	 **/
	private EtiquetaUtil lblListaCheques;

	/**
	 * @variable lblListaVales 
	 * 			 etiqueta para indicar el componente grafico sobre la forma para 
	 * 			 seleccionar un Vale
	 **/
	private EtiquetaUtil lblListaVales;

	/**
	 * @variable lblListaMonedas 
	 * 			 etiqueta para indicar el componente grafico sobre la forma para 
	 * 			 seleccionar un monto de monedas especifico
	 **/
	private EtiquetaUtil lblListaMonedas;

	/**
	 * @variable lblCantidadMontoBilletes 
	 * 			 etiqueta para indicar el componente grafico sobre la forma para 
	 * 			 diligenciar la cantidad de monto de billetes especifico
	 **/
	private EtiquetaUtil lblCantidadMontoBilletes;

	/**
	 * @variable lblValorCheque 
	 * 			 etiqueta para indicar el componente grafico sobre la forma para 
	 * 			 diligenciar el valor del cheque
	 **/
	private EtiquetaUtil lblValorCheque;

	/**
	 * @variable lblValorVale 
	 * 			 etiqueta para indicar el componente grafico sobre la forma para 
	 * 			 diligenciar el valor del vale
	 **/
	private EtiquetaUtil lblValorVale;

	/**
	 * @variable lblCantidadMontoMonedas 
	 * 			 etiqueta para indicar el componente grafico sobre la forma para 
	 * 			 diligenciar la cantidad de monto de monedas especifico
	 **/
	private EtiquetaUtil lblCantidadMontoMonedas;

	/**
	 * @variable lblFechaCheque 
	 * 			 etiqueta para indicar el componente grafico sobre la forma para 
	 * 			 diligenciar la fecha del cheque
	 **/
	private EtiquetaUtil lblFechaCheque;

	/**
	 * @variable lblFechaVale 
	 * 			 etiqueta para indicar el componente grafico sobre la forma para 
	 * 			 diligenciar la fecha del vale
	 **/
	private EtiquetaUtil lblFechaVale;

	/**
	 * @variable lblBancoCheque 
	 * 			 etiqueta para indicar el componente grafico sobre la forma para 
	 * 			 diligenciar el banco al cual pertenece el cheque
	 **/
	private EtiquetaUtil lblBancoCheque;

	/**
	 * @variable lblNumeroCheque 
	 * 			 etiqueta para indicar el componente grafico sobre la forma para 
	 * 			 diligenciar el numero del cheque
	 **/
	private EtiquetaUtil lblNumeroCheque;

	/**
	 * @variable lblNumeroVale 
	 * 			 etiqueta para indicar el componente grafico sobre la forma para 
	 * 			 diligenciar el numero del vale
	 **/
	private EtiquetaUtil lblNumeroVale;

	/**
	 * @variable lblGiradorCheque 
	 * 			 etiqueta para indicar el componente grafico sobre la forma para 
	 * 			 diligenciar el girador del cheque
	 **/
	private EtiquetaUtil lblGiradorCheque;

	/**
	 * @variable lblConceptoVale 
	 * 			 etiqueta para indicar el componente grafico sobre la forma para 
	 * 			 diligenciar el concepto del vale
	 **/
	private EtiquetaUtil lblConceptoVale;

	/**
	 * @variable lblNotas 
	 * 			 etiqueta para indicar el componente grafico sobre la forma para 
	 * 			 diligenciar las notas asociadas al proceso de arqueo
	 **/
	private EtiquetaUtil lblNotas;

	/**
	 * @variable lblTotalCaja 
	 * 			 etiqueta para indicar el componente grafico sobre la forma donde 
	 * 			 se consolida el total en caja
	 **/
	private EtiquetaUtil lblTotalCaja;

	/**
	 * @variable lblEnArqueo 
	 * 			 etiqueta para indicar el componente grafico sobre la forma donde 
	 * 			 se consolida el total en arqueo
	 **/
	private EtiquetaUtil lblEnArqueo;

	/**
	 * @variable lblTotalDiferencia 
	 * 			 etiqueta para indicar el componente grafico sobre la forma donde 
	 * 			 se consolida el total que hace falta o sobra (diferencia) para 
	 * 			 realizar el cuadre
	 **/
	private EtiquetaUtil lblTotalDiferencia;

	/**
	 * @variable lblTotalBilletes 
	 * 			 etiqueta para indicar el componente grafico sobre la forma donde 
	 * 			 se consolida el total cargado para la seccion de billetes
	 **/
	private EtiquetaUtil lblTotalXBilletes;

	/**
	 * @variable lblTotalMonedas 
	 * 			 etiqueta para indicar el componente grafico sobre la forma donde 
	 * 			 se consolida el total cargado para la seccion de monedas
	 **/
	private EtiquetaUtil lblTotalXMonedas;

	/**
	 * @variable lblTotalXCheques 
	 * 			 etiqueta para indicar el componente grafico sobre la forma donde 
	 * 			 se consolida el total cargado para la seccion de cheques
	 **/
	private EtiquetaUtil lblTotalXCheques;

	/**
	 * @variable lblTotalXVales 
	 * 			 etiqueta para indicar el componente grafico sobre la forma donde 
	 * 			 se consolida el total cargado para la seccion de vales
	 **/
	private EtiquetaUtil lblTotalXVales;

	/**
	 * @variable dtcFechaCheque etiqueta para indicar el componente grafico
	 *           sobre la forma para diligenicar la fecha del cheque
	 **/
	private CajaFechaUtil dtcFechaCheque;

	/**
	 * @variable dtcFechaVale 
	 * 			 etiqueta para indicar el componente grafico sobre la forma para 
	 * 			 diligenicar la fecha del vale
	 **/
	private CajaFechaUtil dtcFechaVale;

	/**
	 * @variable cmbListaBilletes 
	 * 			 lista de valores a contener las diferentes montos de billetes 
	 * 			 configurados para seleccionar
	 **/
	private CajaComboUtil cmbListaBilletes;

	/**
	 * @variable cmbListaCheques 
	 * 			 lista de valores a contener las diferentes tipos de cheque
	 **/
	private CajaComboUtil cmbListaCheques;

	/**
	 * @variable cmbListaVales 
	 * 			 lista de valores a contener las diferentes tipos de vales
	 **/
	private CajaComboUtil cmbListaVales;

	/**
	 * @variable cmbListaMonedas 
	 * 			 lista de valores a contener las diferentes montos de monedas 
	 * 			 configurados para seleccionar
	 **/
	private CajaComboUtil cmbListaMonedas;

	/**
	 * @variable txtCantidadMontoBilletes 
	 * 			 campo de texto para diligenciar la cantidad por monto de billetes
	 **/
	private CajaTextoUtil txtCantidadMontoBilletes;

	/**
	 * @variable txtValorCheque 
	 * 			 caja de texto para ingresar el valor del cheque
	 **/
	private CajaTextoUtil txtValorCheque;

	/**
	 * @variable txtValorVale 
	 * 			 caja de texto para ingresar el valor del vale
	 **/
	private CajaTextoUtil txtValorVale;

	/**
	 * @variable txtBancoCheque 
	 * 			 caja de texto para ingresar el banco al que pertenece el cheque
	 **/
	private CajaTextoUtil txtBancoCheque;

	/**
	 * @variable txtNumeroCheque 
	 * 			 caja de texto para ingresar el numero del cheque
	 **/
	private CajaTextoUtil txtNumeroCheque;

	/**
	 * @variable txtNumeroVale 
	 * 			 caja de texto para ingresar el numero del vale
	 **/
	private CajaTextoUtil txtNumeroVale;

	/**
	 * @variable txtGiradorCheque 
	 * 			 caja de texto para ingresar el girador del cheque
	 **/
	private CajaTextoUtil txtGiradorCheque;

	/**
	 * @variable txtConceptoVale 
	 * 			 caja de texto para ingresar el concepto del vale
	 **/
	private CajaTextoUtil txtConceptoVale;

	/**
	 * @variable txtTotalCaja 
	 * 			 caja de texto sobre la cual se muestra el total de caja 
	 * 			 consolidado
	 **/
	private CajaTextoUtil txtTotalCaja;

	/**
	 * @variable txtEnArqueo 
	 * 			 caja de texto sobre la cual se muestra el total en arqueo 
	 * 			 consolidado
	 **/
	private CajaTextoUtil txtEnArqueo;

	/**
	 * @variable txtTotalDiferencia 
	 * 			 caja de texto sobre la cual se muestra el total de diferencia para 
	 * 			 realizar el cuadre de caja
	 **/
	private CajaTextoUtil txtTotalDiferencia;

	/**
	 * @variable txtTotalXBilletes 
	 * 			 caja de texto sobre la cual se muestra el total ingresado por la 
	 * 			 seccion de billetes
	 **/
	private CajaTextoUtil txtTotalXBilletes;

	/**
	 * @variable txtTotalXMonedas 
	 * 			 caja de texto sobre la cual se muestra el total ingresado por la 
	 * 			 seccion de monedas
	 **/
	private CajaTextoUtil txtTotalXMonedas;

	/**
	 * @variable txtTotalXCheques 
	 * 			 caja de texto sobre la cual se muestra el total ingresado por la 
	 * 			 seccion de cheques
	 **/
	private CajaTextoUtil txtTotalXCheques;

	/**
	 * @variable txtTotalXVales 
	 * 			 caja de texto sobre la cual se muestra el total ingresado por la 
	 * 			 seccion de vales
	 **/
	private CajaTextoUtil txtTotalXVales;

	/**
	 * @variable txtCantidadMontoMonedas 
	 * 			 campo de texto, para diligenciar la cantidad por monto de monedas
	 **/
	private CajaTextoUtil txtCantidadMontoMonedas;

	/**
	 * @variable txaNotas
	 * 			 campo de texto donde se relacionara la informacion de las notas 
	 * 			 asociadas al arqueo de caja
	 **/
	private AreaTextoUtil txaNotas;

	/**
	 * @variable btnIngresarCantidadMontoBilletes 
	 * 			 boton para ejecutar la confirmacion de ingreso por cantidad de 
	 * 			 monto de billetes al arqueo de caja
	 **/
	private BotonUtil btnIngresarCantidadMontoBilletes;

	/**
	 * @variable btnIngresarCheque 
	 * 			 boton para ejecutar la confirmacion de ingreso de cheque al arqueo 
	 * 			 de caja
	 **/
	private BotonUtil btnIngresarCheque;

	/**
	 * @variable btnIngresarVale 
	 * 			 boton para ejecutar la confirmacion de ingreso de vale al arqueo de 
	 * 			 caja
	 **/
	private BotonUtil btnIngresarVale;

	/**
	 * @variable btnIngresarCantidadMontoMonedas 
	 * 			 boton para ejecutar la confirmacion de ingreso por cantidad de monto 
	 * 			 de monedas al arqueo de caja
	 **/
	private BotonUtil btnIngresarCantidadMontoMonedas;

	/**
	 * @variable btnEliminarRegistroIngresadoBilletes 
	 * 			 boton para eliminar el registro seleccionado de la grilla de billetes, 
	 * 			 para deshacer un ingreso previo
	 **/
	private BotonUtil btnEliminarRegistroIngresadoBilletes;

	/**
	 * @variable btnEliminarRegistroIngresadoCheques 
	 * 			 boton para eliminar el registro seleccionado de la grilla de cheques, 
	 * 			 para deshacer un ingreso previo
	 **/
	private BotonUtil btnEliminarRegistroIngresadoCheques;

	/**
	 * @variable btnEliminarRegistroIngresadoVales 
	 * 			 boton para eliminar el registro seleccionado de la grilla de vales, para 
	 * 			 deshacer un ingreso previo
	 **/
	private BotonUtil btnEliminarRegistroIngresadoVales;

	/**
	 * @variable btnEliminarRegistroIngresadoMonedas 
	 * 			 boton para eliminar el registro seleccionado de la grilla de monedas, 
	 * 			 para deshacer un ingreso previo
	 **/
	private BotonUtil btnEliminarRegistroIngresadoMonedas;

	/**
	 * ****************************************************************.
	 * @metodo FormaArqueoCaja 
	 * 		   Constructor que ejecuta la inicializacion de valores y 
	 * 		   ejecucion de comportamientos inicales requeridos para
	 *         el despliegue de la forma
	 * @param pFrmPadre
	 *        ventana de la cual extiende esta forma
	 * @param pBooModal
	 *        bandera que permite efectuar la forma de manera modal sobre 
	 *        la ventana de la cual extiende
	 * @param pObjInfoCierreCajaDTO
	 *        objeto que contiene informacion adicional y requerida para 
	 *        el proceso de cierre de caja
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public FormaArqueoCaja(FormaGenerica pFrmPadre, 
						   boolean pBooModal,
						   InfoCierreCajaDTO pObjInfoCierreCajaDTO) throws Exception {

		super(pFrmPadre, 
			  pBooModal);

		super.setBooDesaparecerVentanaPadre(true);

		super.setEventoForma(new EventoFormaArqueoCaja(this,
													   pObjInfoCierreCajaDTO));
		
		this.inicializarForma();
	}

	@Override
	public void inicializarForma(Object... pArrObjParametrosForma)throws Exception {

		super.setTituloForma(EnumEtiquetas.TTL_AQC_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.GUI_AQC_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.GUI_AQC_VENTANA.getAlto());

		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
								EnumBotonesEncabezado.BTN_LIMPIAR,
								EnumBotonesEncabezado.BTNVOLVER, 
								EnumBotonesEncabezado.BTNSALIR);

		super.iniciar(pArrObjParametrosForma);
	}

	@Override
	public JPanel inicializarEncabezado(Object... pArrObjParametrosForma)throws Exception {

		JPanel pnlEncabezado;

		pnlEncabezado = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_AQC_ENCABEZADO,
																	"pnlEncabezado",
																	null,
																	null,
																	null);
		pnlEncabezado.add(this.iniciarPropPnlSeccionBilletes());
		pnlEncabezado.add(this.iniciarPropPnlSeccionMonedas());
		pnlEncabezado.add(this.iniciarPropPnlSeccionCheques());
		pnlEncabezado.add(this.iniciarPropPnlSeccionVales());

		return pnlEncabezado;
	}

	@Override
	public JPanel inicializarCuerpo(Object... pArrObjParametrosForma)throws Exception {

		JPanel pnlCuerpo;

		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_AQC_CUERPO, 
																"pnlCuerpo",
																null,
																null,
																null);
		pnlCuerpo.add(this.iniciarPropLblNotas());
		pnlCuerpo.add(this.iniciarPropTxaNotas().getScpContenedor());
		pnlCuerpo.add(this.iniciarPropPnlSeccionCuadreCaja());

		return pnlCuerpo;
	}

	@Override
	public JPanel inicializarPiePagina(Object... pArrObjParametrosForma)throws Exception {
		return null;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropPnlSeccionBilletes 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   pnlSeccionBilletes
	 * @return JPanel 
	 * 		   seccion de cuerpo gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public JPanel iniciarPropPnlSeccionBilletes() throws Exception {

		if (this.pnlSeccionBilletes == null) {

			this.pnlSeccionBilletes = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_AQC_BILLETES, 
																				  "pnlSeccionBilletes",
																				  null,
																				  EnumEtiquetas.TTL_AQC_PNL_BILLETES,
																				  null);
			
			this.pnlSeccionBilletes.add(this.iniciarPropLblListaBilletes());
			this.pnlSeccionBilletes.add(this.iniciarPropCmbListaBilletes());
			this.pnlSeccionBilletes.add(this.iniciarPropLblCantidadMontoBilletes());
			this.pnlSeccionBilletes.add(this.iniciarPropTxtCantidadMontoBilletes());
			this.pnlSeccionBilletes.add(this.iniciarPropBtnIngresarCantidadMontoBilletes());
			this.pnlSeccionBilletes.add(this.iniciarPropScpGrillaDenominacionBilletes());
			this.pnlSeccionBilletes.add(this.iniciarPropLblTotalXBilletes());
			this.pnlSeccionBilletes.add(this.iniciarPropTxtTotalXBilletes());
			this.pnlSeccionBilletes.add(this.iniciarPropBtnEliminarRegistroIngresadoBilletes());
		}

		return this.pnlSeccionBilletes;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropPnlSeccionCheques 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   pnlSeccionCheques
	 * @return JPanel 
	 * 		   seccion de cuerpo gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public JPanel iniciarPropPnlSeccionCheques() throws Exception {

		if (this.pnlSeccionCheques == null) {

			this.pnlSeccionCheques = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_AQC_CHEQUES, 
																				 "pnlSeccionCheques",
																				 null,
																				 EnumEtiquetas.TTL_AQC_PNL_CHEQUES,
																				 null);
			
			this.pnlSeccionCheques.add(this.iniciarPropScpGrillaCheques());
			this.pnlSeccionCheques.add(this.iniciarPropLblListaCheques());
			this.pnlSeccionCheques.add(this.iniciarPropLblValorCheque());
			this.pnlSeccionCheques.add(this.iniciarPropBtnIngresarCheque());
			this.pnlSeccionCheques.add(this.iniciarPropBtnEliminarRegistroIngresadoCheques());
			this.pnlSeccionCheques.add(this.iniciarPropLblTotalXCheques());
			this.pnlSeccionCheques.add(this.iniciarPropTxtTotalXCheques());
			this.pnlSeccionCheques.add(this.iniciarPropCmbListaCheques());
			this.pnlSeccionCheques.add(this.iniciarPropTxtValorCheque());
		}

		return this.pnlSeccionCheques;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropPnlSeccionVales 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   pnlSeccionVales
	 * @return JPanel 
	 * 		   seccion de cuerpo gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public JPanel iniciarPropPnlSeccionVales() throws Exception {

		if (this.pnlSeccionVales == null) {

			this.pnlSeccionVales = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_AQC_VALES, 
																			   "pnlSeccionVales",
																			   null,
																			   EnumEtiquetas.TTL_AQC_PNL_VALES,
																			   null);
			this.pnlSeccionVales.add(this.iniciarPropScpGrillaVales());
			this.pnlSeccionVales.add(this.iniciarPropBtnIngresarVale());
			this.pnlSeccionVales.add(this.iniciarPropBtnEliminarRegistroIngresadoVales());
			this.pnlSeccionVales.add(this.iniciarPropLblTotalXVales());
			this.pnlSeccionVales.add(this.iniciarPropTxtTotalXVales());
			this.pnlSeccionVales.add(this.iniciarPropCmbListaVales());
			this.pnlSeccionVales.add(this.iniciarPropLblValorVale());
			this.pnlSeccionVales.add(this.iniciarPropLblListaVales());
			this.pnlSeccionVales.add(this.iniciarPropTxtValorVale());
		}

		return this.pnlSeccionVales;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropPnlSeccionMonedas 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   pnlSeccionMonedas
	 * @return JPanel 
	 * 		   seccion de cuerpo gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public JPanel iniciarPropPnlSeccionMonedas() throws Exception {

		if (this.pnlSeccionMonedas == null) {

			this.pnlSeccionMonedas = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_AQC_MONEDAS, 
																				 "pnlSeccionMonedas",
																				 null,
																				 EnumEtiquetas.TTL_AQC_PNL_MONEDAS,
																				 null);

			this.pnlSeccionMonedas.add(this.iniciarPropScpGrillaDenominacionMonedas());
			this.pnlSeccionMonedas.add(this.iniciarPropLblListaMonedas());
			this.pnlSeccionMonedas.add(this.iniciarPropLblCantidadMontoMonedas());
			this.pnlSeccionMonedas.add(this.iniciarPropCmbListaMonedas());
			this.pnlSeccionMonedas.add(this.iniciarPropTxtCantidadMontoMonedas());
			this.pnlSeccionMonedas.add(this.iniciarPropBtnIngresarCantidadMontoMonedas());
			this.pnlSeccionMonedas.add(this.iniciarPropLblTotalXMonedas());
			this.pnlSeccionMonedas.add(this.iniciarPropTxtTotalXMonedas());
			this.pnlSeccionMonedas.add(this.iniciarPropBtnEliminarRegistroIngresadoMonedas());
		}

		return this.pnlSeccionMonedas;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropPnlDatAdiCheque 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   pnlDatAdiCheque
	 * @return JPanel 
	 * 		   seccion de cuerpo gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public JPanel iniciarPropPnlDatAdiCheque() throws Exception {

		if (this.pnlDatAdiCheque == null) {

			this.pnlDatAdiCheque = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_AQC_DAT_ADI_CHEQUE, 
																			   "pnlDatAdiCheque",
																			   null,
																			   null,
																			   null);
			this.pnlDatAdiCheque.add(this.iniciarPropLblFechaCheque());
			this.pnlDatAdiCheque.add(this.iniciarPropDtcFechaCheque());
			this.pnlDatAdiCheque.add(this.iniciarPropLblBancoCheque());
			this.pnlDatAdiCheque.add(this.iniciarPropTxtBancoCheque());
			this.pnlDatAdiCheque.add(this.iniciarPropLblNumeroCheque());
			this.pnlDatAdiCheque.add(this.iniciarPropTxtNumeroCheque());
			this.pnlDatAdiCheque.add(this.iniciarPropLblGiradorCheque());
			this.pnlDatAdiCheque.add(this.iniciarPropTxtGiradorCheque());
		}

		return this.pnlDatAdiCheque;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropPnlDatAdiVale 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   pnlDatAdiVale
	 * @return JPanel 
	 * 		   seccion de cuerpo gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public JPanel iniciarPropPnlDatAdiVale() throws Exception {

		if (this.pnlDatAdiVale == null) {

			this.pnlDatAdiVale = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_AQC_DAT_ADI_VALE, 
																			 "pnlDatAdiVale",
																			 null,
																			 null,
																			 null);
			this.pnlDatAdiVale.add(this.iniciarPropLblFechaVale());
			this.pnlDatAdiVale.add(this.iniciarPropDtcFechaVale());
			this.pnlDatAdiVale.add(this.iniciarPropLblNumeroVale());
			this.pnlDatAdiVale.add(this.iniciarPropTxtNumeroVale());
			this.pnlDatAdiVale.add(this.iniciarPropLblConceptoVale());
			this.pnlDatAdiVale.add(this.iniciarPropTxtConceptoVale());
		}

		return this.pnlDatAdiVale;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropPnlSeccionCuadreCaja 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   pnlSeccionCuadreCaja
	 * @return JPanel 
	 * 		   seccion de cuerpo gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public JPanel iniciarPropPnlSeccionCuadreCaja() throws Exception {

		if (this.pnlSeccionCuadreCaja == null) {

			this.pnlSeccionCuadreCaja = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_AQC_CUADRE_CAJA, 
																					"pnlSeccionCuadreCaja",
																					null,
																					EnumEtiquetas.TTL_AQC_PNL_CUADRE_CAJA,
																					null);
			this.pnlSeccionCuadreCaja.add(this.iniciarPropLblTotalCaja());
			this.pnlSeccionCuadreCaja.add(this.iniciarPropTxtTotalCaja());
			this.pnlSeccionCuadreCaja.add(this.iniciarPropLblEnArqueo());
			this.pnlSeccionCuadreCaja.add(this.iniciarPropTxtEnArqueo());
			this.pnlSeccionCuadreCaja.add(this.iniciarPropLblTotalDiferencia());
			this.pnlSeccionCuadreCaja.add(this.iniciarPropTxtTotalDiferencia());
		}

		return this.pnlSeccionCuadreCaja;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropScpGrillaDenominacionBilletes 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   scpGrillaDenominacionBilletes
	 * @return JScrollPane 
	 * 		   contenedor para el despliegue de grilla gestionado
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public JScrollPane iniciarPropScpGrillaDenominacionBilletes()throws Exception {

		if (this.scpGrillaDenominacionBilletes == null) {

			this.scpGrillaDenominacionBilletes = UtilComponentesGUI.getInstance().crearScroll("scpGrillaDenominacionBilletes",
																							  EnumDimensionesComponentes.SCP_AQC_SCROLL_GRILLA_DENOMINACOIN_BILLETES,
																							  null);

			this.scpGrillaDenominacionBilletes.setViewportView(this.iniciarPropTblDenominacionBilletes());
		}

		return this.scpGrillaDenominacionBilletes;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropScpGrillaCheques 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   scpGrillaCheques
	 * @return JScrollPane 
	 * 		   contenedor para el despliegue de grilla gestionado
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public JScrollPane iniciarPropScpGrillaCheques() throws Exception {

		if (this.scpGrillaCheques == null) {

			this.scpGrillaCheques = UtilComponentesGUI.getInstance().crearScroll("scpGrillaCheques",
																				 EnumDimensionesComponentes.SCP_AQC_SCROLL_GRILLA_CHEQUES,
																				 null);

			this.scpGrillaCheques.setViewportView(this.iniciarPropTblCheques());
		}

		return this.scpGrillaCheques;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropScpGrillaVales 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   scpGrillaVales
	 * @return JScrollPane 
	 * 		   contenedor para el despliegue de grilla gestionado
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public JScrollPane iniciarPropScpGrillaVales() throws Exception {

		if (this.scpGrillaVales == null) {

			this.scpGrillaVales = UtilComponentesGUI.getInstance().crearScroll("scpGrillaVales",
																			   EnumDimensionesComponentes.SCP_AQC_SCROLL_GRILLA_VALES,
																			   null);

			this.scpGrillaVales.setViewportView(this.iniciarPropTblVales());
		}

		return this.scpGrillaVales;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropScpGrillaDenominacionMonedas 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   scpGrillaDenominacionMonedas
	 * @return JScrollPane 
	 * 		   contenedor para el despliegue de grilla gestionado
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public JScrollPane iniciarPropScpGrillaDenominacionMonedas()throws Exception {

		if (this.scpGrillaDenominacionMonedas == null) {

			this.scpGrillaDenominacionMonedas = UtilComponentesGUI.getInstance().crearScroll("scpGrillaDenominacionMonedas",
																							 EnumDimensionesComponentes.SCP_AQC_SCROLL_GRILLA_DENOMINACOIN_MONEDAS,
																							 null);

			this.scpGrillaDenominacionMonedas.setViewportView(this.iniciarPropTblDenominacionMonedas());
		}

		return this.scpGrillaDenominacionMonedas;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropTblDenominacionBilletes 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   tblDenominacionBilletes
	 * @return GrillaUtil 
	 * 		   grilla gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public GrillaUtil iniciarPropTblDenominacionBilletes() throws Exception {

		if (this.tblDenominacionBilletes == null) {

			this.tblDenominacionBilletes = UtilComponentesGUI.getInstance().crearGrilla("tblDenominacionBilletes",
																						new EnumEtiquetas[] {EnumEtiquetas.TTL_AQC_GRILLA_BILLETES_DENOMINACION,
																									  		 EnumEtiquetas.TTL_AQC_GRILLA_BILLETES_CANTIDAD,
																									  		 EnumEtiquetas.TTL_AQC_GRILLA_BILLETES_TOTAL}, 
																						null, 
																						null,
																						null, 
																						super.getEventoForma());
		}

		return this.tblDenominacionBilletes;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropTblCheques 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   tblCheques
	 * @return GrillaUtil 
	 * 		   grilla gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public GrillaUtil iniciarPropTblCheques() throws Exception {

		if (this.tblCheques == null) {

			this.tblCheques = UtilComponentesGUI.getInstance().crearGrilla("tblCheques",
																		   new EnumEtiquetas[] {EnumEtiquetas.TTL_AQC_GRILLA_CHEQUES_BANCO,
																						 		EnumEtiquetas.TTL_AQC_GRILLA_CHEQUES_NUMERO,
																						 		EnumEtiquetas.TTL_AQC_GRILLA_CHEQUES_GIRADOR,
																						 		EnumEtiquetas.TTL_AQC_GRILLA_CHEQUES_VALOR}, 
																		   null, 
																		   null, 
																		   null,
																		   super.getEventoForma());
		}

		return this.tblCheques;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropTblVales 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   tblVales
	 * @return GrillaUtil 
	 * 		   grilla gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public GrillaUtil iniciarPropTblVales() throws Exception {

		if (this.tblVales == null) {

			this.tblVales = UtilComponentesGUI.getInstance().crearGrilla("tblVales",
																		 new EnumEtiquetas[] {EnumEtiquetas.TTL_AQC_GRILLA_VALES_FECHA,
																					   		  EnumEtiquetas.TTL_AQC_GRILLA_VALES_NUMERO,
																					   		  EnumEtiquetas.TTL_AQC_GRILLA_VALES_CONCEPTO,
																					   		  EnumEtiquetas.TTL_AQC_GRILLA_VALES_VALOR}, 
																		 null, 
																		 null,
																		 null, 
																		 super.getEventoForma());
		}

		return this.tblVales;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropTblDenominacionMonedas 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   tblDenominacionMonedas
	 * @return GrillaUtil 
	 * 		   grilla gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public GrillaUtil iniciarPropTblDenominacionMonedas() throws Exception {

		if (this.tblDenominacionMonedas == null) {

			this.tblDenominacionMonedas = UtilComponentesGUI.getInstance().crearGrilla("tblDenominacionMonedas",
																					   new EnumEtiquetas[] {EnumEtiquetas.TTL_AQC_GRILLA_MONEDAS_DENOMINACION,
																									 		EnumEtiquetas.TTL_AQC_GRILLA_MONEDAS_CANTIDAD,
																									 		EnumEtiquetas.TTL_AQC_GRILLA_MONEDAS_TOTAL}, 
																					   null, 
																					   null,
																					   null, 
																					   super.getEventoForma());
		}

		return this.tblDenominacionMonedas;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropLblListaBilletes 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblListaBilletes
	 * @return EtiquetaUtil 
	 * 		   etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblListaBilletes() throws Exception {

		if (this.lblListaBilletes == null) {

			this.lblListaBilletes = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AQC_LISTA_BILLETES, 
																				"lblListaBilletes",
																				EnumEtiquetas.LBL_AQC_LISTA_BILLETES,
																				false,
																				null, 
																				true);
		}
		
		return this.lblListaBilletes;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropLblListaCheques 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblListaCheques
	 * @return EtiquetaUtil 
	 * 		   etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblListaCheques() throws Exception {

		if (this.lblListaCheques == null) {

			this.lblListaCheques = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AQC_LISTA_CHEQUES, 
																			   "lblListaCheques",
																			   EnumEtiquetas.LBL_AQC_LISTA_CHEQUES,
																			   false,
																			   null, 
																			   true);
		}
		
		return this.lblListaCheques;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropLblListaVales 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblListaVales
	 * @return EtiquetaUtil 
	 * 		   etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblListaVales() throws Exception {

		if (this.lblListaVales == null) {

			this.lblListaVales = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AQC_LISTA_VALES, 
																			 "lblListaVales",
																			 EnumEtiquetas.LBL_AQC_LISTA_VALES,
																			 false,
																			 null, 
																			 true);
		}
		
		return this.lblListaVales;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropLblListaMonedas 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblListaMonedas
	 * @return EtiquetaUtil 
	 * 		   etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblListaMonedas() throws Exception {

		if (this.lblListaMonedas == null) {

			this.lblListaMonedas = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AQC_LISTA_MONEDAS, 
																			   "lblListaMonedas",
																			   EnumEtiquetas.LBL_AQC_LISTA_MONEDAS,
																			   false,
																			   null, 
																			   true);
		}
		
		return this.lblListaMonedas;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropLblCantidadMontoBilletes 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblCantidadMontoBilletes
	 * @return EtiquetaUtil 
	 * 		   etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblCantidadMontoBilletes() throws Exception {

		if (this.lblCantidadMontoBilletes == null) {

			this.lblCantidadMontoBilletes = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AQC_CANTIDAD_MONTO_BILLETES,
																						"lblCantidadMontoBilletes",
																						EnumEtiquetas.LBL_AQC_CANTIDAD_MONTO_BILLETES,
																						false,
																						null, 
																						true);
		}
		
		return this.lblCantidadMontoBilletes;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropLblValorCheque 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblValorCheque
	 * @return EtiquetaUtil 
	 * 		   etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblValorCheque() throws Exception {

		if (this.lblValorCheque == null) {

			this.lblValorCheque = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AQC_VALOR_CHEQUE, 
																			  "lblValorCheque",
																			  EnumEtiquetas.LBL_AQC_VALOR_CHEQUE,
																			  false,
																			  null, 
																			  true);
		}
		
		return this.lblValorCheque;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropLblValorVale 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblValorVale
	 * @return EtiquetaUtil 
	 * 		   etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblValorVale() throws Exception {

		if (this.lblValorVale == null) {

			this.lblValorVale = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AQC_VALOR_VALE, 
																			"lblValorVale",
																			EnumEtiquetas.LBL_AQC_VALOR_VALE,
																			false,
																			null, 
																			true);
		}
		
		return this.lblValorVale;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropLblCantidadMontoMonedas 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblCantidadMontoMonedas
	 * @return EtiquetaUtil 
	 * 		   etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblCantidadMontoMonedas() throws Exception {

		if (this.lblCantidadMontoMonedas == null) {

			this.lblCantidadMontoMonedas = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AQC_CANTIDAD_MONTO_MONEDAS,
																					   "lblCantidadMontoMonedas",
																					   EnumEtiquetas.LBL_AQC_CANTIDAD_MONTO_MONEDAS,
																					   false,
																					   null, 
																					   true);
		}
		
		return this.lblCantidadMontoMonedas;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropLblFechaCheque 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblFechaCheque
	 * @return EtiquetaUtil 
	 * 		   etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblFechaCheque() throws Exception {

		if (this.lblFechaCheque == null) {

			this.lblFechaCheque = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AQC_FECHA_CHEQUE, 
																			  "lblFechaCheque",
																			  EnumEtiquetas.LBL_AQC_FECHA_CHEQUE,
																			  true,
																			  null,
																			  true);
		}
		
		return this.lblFechaCheque;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropLblFechaVale 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblFechaVale
	 * @return EtiquetaUtil 
	 * 		   etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblFechaVale() throws Exception {

		if (this.lblFechaVale == null) {

			this.lblFechaVale = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AQC_FECHA_VALE, 
																			"lblFechaVale",
																			EnumEtiquetas.LBL_AQC_FECHA_VALE,
																			true,
																			null,
																			true);
		}
		
		return this.lblFechaVale;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropLblBancoCheque 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblBancoCheque
	 * @return EtiquetaUtil 
	 * 		   etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblBancoCheque() throws Exception {

		if (this.lblBancoCheque == null) {

			this.lblBancoCheque = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AQC_BANCO_CHEQUE, 
																			  "lblBancoCheque",
																			  EnumEtiquetas.LBL_AQC_BANCO_CHEQUE,
																			  true,
																			  null,
																			  true);
		}
		
		return this.lblBancoCheque;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropLblNumeroCheque 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblNumeroCheque
	 * @return EtiquetaUtil 
	 * 		   etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblNumeroCheque() throws Exception {

		if (this.lblNumeroCheque == null) {

			this.lblNumeroCheque = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AQC_NUMERO_CHEQUE, 
																			   "lblNumeroCheque",
																			   EnumEtiquetas.LBL_AQC_NUMERO_CHEQUE,
																			   true,
																			   null,
																			   true);
		}
		
		return this.lblNumeroCheque;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropLblNumeroVale 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblNumeroVale
	 * @return EtiquetaUtil 
	 * 		   etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblNumeroVale() throws Exception {

		if (this.lblNumeroVale == null) {

			this.lblNumeroVale = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AQC_NUMERO_VALE, 
																			 "lblNumeroVale",
																			 EnumEtiquetas.LBL_AQC_NUMERO_VALE,
																			 true,
																			 null,
																			 true);
		}
		
		return this.lblNumeroVale;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropLblGiradorCheque 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblGiradorCheque
	 * @return EtiquetaUtil 
	 * 		   etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblGiradorCheque() throws Exception {

		if (this.lblGiradorCheque == null) {

			this.lblGiradorCheque = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AQC_GIRADOR_CHEQUE,
																				"lblGiradorCheque",
																				EnumEtiquetas.LBL_AQC_GIRADOR_CHEQUE,
																				true,
																				null, 
																				true);
		}
		
		return this.lblGiradorCheque;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropLblConceptoVale 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblConceptoVale
	 * @return EtiquetaUtil 
	 * 		   etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblConceptoVale() throws Exception {

		if (this.lblConceptoVale == null) {

			this.lblConceptoVale = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AQC_CONCEPTO_VALE, 
																			   "lblConceptoVale",
																			   EnumEtiquetas.LBL_AQC_CONCEPTO_VALE,
																			   true,
																			   null,
																			   true);
		}
		
		return this.lblConceptoVale;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropLblNotas 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblNotas
	 * @return EtiquetaUtil 
	 * 		   etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblNotas() throws Exception {

		if (this.lblNotas == null) {

			this.lblNotas = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AQC_NOTAS,
																		"lblNotas", 
																		EnumEtiquetas.LBL_AQC_NOTAS,
																		true,
																		null, 
																		true);
		}
		
		return this.lblNotas;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropLblTotalCaja 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblTotalCaja
	 * @return EtiquetaUtil 
	 * 		   etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblTotalCaja() throws Exception {

		if (this.lblTotalCaja == null) {

			this.lblTotalCaja = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AQC_TOTAL_CAJA, 
																			"lblTotalCaja",
																			EnumEtiquetas.LBL_AQC_TOTAL_CAJA,
																			true,
																			null,
																			true);
		}
		
		return this.lblTotalCaja;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropLblEnArqueo 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblEnArqueo
	 * @return EtiquetaUtil 
	 * 		   etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblEnArqueo() throws Exception {

		if (this.lblEnArqueo == null) {

			this.lblEnArqueo = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AQC_EN_ARQUEO, 
																		   "lblEnArqueo",
																		   EnumEtiquetas.LBL_AQC_EN_ARQUEO,
																		   true,
																		   null,
																		   true);
		}
		
		return this.lblEnArqueo;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropLblTotalDiferencia 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblTotalDiferencia
	 * @return EtiquetaUtil 
	 * 		   etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblTotalDiferencia() throws Exception {

		if (this.lblTotalDiferencia == null) {

			this.lblTotalDiferencia = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AQC_TOTAL_DIFERENCIA,
																				  "lblTotalDiferencia",
																				  EnumEtiquetas.LBL_AQC_TOTAL_DIFERENCIA_EXACTA,
																				  true,
																				  null, 
																				  true);
		}
		
		return this.lblTotalDiferencia;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropLblTotalXBilletes 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblTotalXBilletes
	 * @return EtiquetaUtil 
	 * 		   etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblTotalXBilletes() throws Exception {

		if (this.lblTotalXBilletes == null) {

			this.lblTotalXBilletes = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AQC_TOTAL_X_BILLETES,
																				 "lblTotalXBilletes",
																				 EnumEtiquetas.LBL_AQC_TOTAL_X_BILLETES,
																				 true,
																				 null, 
																				 true);
		}
		
		return this.lblTotalXBilletes;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropLblTotalXMonedas 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblTotalXMonedas
	 * @return EtiquetaUtil 
	 * 		   etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblTotalXMonedas() throws Exception {

		if (this.lblTotalXMonedas == null) {

			this.lblTotalXMonedas = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AQC_TOTAL_X_MONEDAS,
																				"lblTotalXMonedas",
																				EnumEtiquetas.LBL_AQC_TOTAL_X_MONEDAS,
																				true,
																				null, 
																				true);
		}
		
		return this.lblTotalXMonedas;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropLblTotalXCheques 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblTotalXCheques
	 * @return EtiquetaUtil 
	 * 		   etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblTotalXCheques() throws Exception {

		if (this.lblTotalXCheques == null) {

			this.lblTotalXCheques = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AQC_TOTAL_X_CHEQUES,
																				"lblTotalXCheques",
																				EnumEtiquetas.LBL_AQC_TOTAL_X_CHEQUES,
																				true,
																				null, 
																				true);
		}
		
		return this.lblTotalXCheques;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropLblTotalXVales 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblTotalXVales
	 * @return EtiquetaUtil 
	 * 		   etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblTotalXVales() throws Exception {

		if (this.lblTotalXVales == null) {

			this.lblTotalXVales = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AQC_TOTAL_X_VALES, 
																			  "lblTotalXVales",
																			  EnumEtiquetas.LBL_AQC_TOTAL_X_VALES,
																			  true,
																			  null,
																			  true);
		}
		
		return this.lblTotalXVales;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropDtcFechaCheque 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   dtcFechaCheque
	 * @return CajaFechaUtil 
	 * 		   Caja para fecha gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public CajaFechaUtil iniciarPropDtcFechaCheque() throws Exception {

		if (this.dtcFechaCheque == null) {

			this.dtcFechaCheque = UtilComponentesGUI.getInstance().crearCalendar(EnumDimensionesComponentes.DTC_AQC_FECHA_CHEQUE, 	
																				 "dtcFechaCheque",
																				 UtilIntegracionSlimGiros.getInstance().obtenerFechaHoraActualPosSlim(), 
																				 true, 
																				 super.getEventoForma(),
																				 EnumEtiquetas.LBL_AQC_FECHA_CHEQUE);
			this.dtcFechaCheque.getLblObligatorio().aplicarObligatoriedad(true);
		}
		
		return this.dtcFechaCheque;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropDtcFechaVale 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   dtcFechaVale
	 * @return CajaFechaUtil 
	 * 		   Caja para fecha gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public CajaFechaUtil iniciarPropDtcFechaVale() throws Exception {

		if (this.dtcFechaVale == null) {

			this.dtcFechaVale = UtilComponentesGUI.getInstance().crearCalendar(EnumDimensionesComponentes.DTC_AQC_FECHA_VALE, 
																			   "dtcFechaVale", 
																			   UtilIntegracionSlimGiros.getInstance().obtenerFechaHoraActualPosSlim(), 
																			   true,
																			   super.getEventoForma(),
																			   EnumEtiquetas.LBL_AQC_FECHA_VALE);
			this.dtcFechaVale.getLblObligatorio().aplicarObligatoriedad(true);
		}
		
		return this.dtcFechaVale;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropCmbListaBilletes 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   cmbListaBilletes
	 * @return CajaComboUtil 
	 * 		   lista de valores gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public CajaComboUtil iniciarPropCmbListaBilletes() throws Exception {

		if (this.cmbListaBilletes == null) {

			this.cmbListaBilletes = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_AQC_LISTA_BILLETES, 
																				   "cmbListaBilletes", 
																				   true,
																				   true, 
																				   super.getEventoForma(),
																				   EnumEtiquetas.LBL_AQC_LISTA_BILLETES);
		}
		
		return this.cmbListaBilletes;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropCmbListaCheques 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   cmbListaCheques
	 * @return CajaComboUtil 
	 * 		   lista de valores gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public CajaComboUtil iniciarPropCmbListaCheques() throws Exception {

		if (this.cmbListaCheques == null) {

			this.cmbListaCheques = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_AQC_LISTA_CHEQUES, 
																				  "cmbListaCheques", 
																				  true,
																				  true, 
																				  super.getEventoForma(),
																				  EnumEtiquetas.LBL_AQC_LISTA_CHEQUES);
		}
		
		return this.cmbListaCheques;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropCmbListaVales 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   cmbListaVales
	 * @return CajaComboUtil 
	 * 		   lista de valores gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public CajaComboUtil iniciarPropCmbListaVales() throws Exception {

		if (this.cmbListaVales == null) {

			this.cmbListaVales = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_AQC_LISTA_VALES, 
																				"cmbListaVales", 
																				true,
																				true, 
																				super.getEventoForma(),
																				EnumEtiquetas.LBL_AQC_LISTA_VALES);
		}

		return this.cmbListaVales;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropCmbListaMonedas 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   cmbListaMonedas
	 * @return CajaComboUtil 
	 * 		   lista de valores gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public CajaComboUtil iniciarPropCmbListaMonedas() throws Exception {

		if (this.cmbListaMonedas == null) {

			this.cmbListaMonedas = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_AQC_LISTA_MONEDAS, 
																				  "cmbListaMonedas", 
																				  true,
																				  true, 
																				  super.getEventoForma(),
																				  EnumEtiquetas.LBL_AQC_LISTA_MONEDAS);
		}
		
		return this.cmbListaMonedas;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropTxtCantidadMontoMonedas 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   txtCantidadMontoMonedas
	 * @return CajaTextoUtil 
	 * 		   caja de texto gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtCantidadMontoMonedas() throws Exception {

		if (this.txtCantidadMontoMonedas == null) {

			this.txtCantidadMontoMonedas = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_AQC_CANTIDAD_MONTO_MONEDAS,
																						   "txtCantidadMontoMonedas", 
																						   "", 
																						   true, 
																						   true, 
																						   true,
																						   super.getEventoForma(),
																						   EnumEtiquetas.LBL_AQC_CANTIDAD_MONTO_MONEDAS);

			this.txtCantidadMontoMonedas.setHorizontalAlignment(SwingConstants.TRAILING);
		}

		return this.txtCantidadMontoMonedas;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropTxtCantidadMontoBilletes 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   txtCantidadMontoBilletes
	 * @return CajaTextoUtil 
	 * 		   caja de texto gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtCantidadMontoBilletes() throws Exception {

		if (this.txtCantidadMontoBilletes == null) {

			this.txtCantidadMontoBilletes = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_AQC_CANTIDAD_MONTO_BILLETES,
																							"txtCantidadMontoBilletes", 
																							"", 
																							true, 
																							true, 
																							true,
																							super.getEventoForma(),
																							EnumEtiquetas.LBL_AQC_CANTIDAD_MONTO_BILLETES);

			this.txtCantidadMontoBilletes.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		
		return this.txtCantidadMontoBilletes;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropTxtValorCheque 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   txtValorCheque
	 * @return CajaTextoUtil 
	 * 		   caja de texto gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtValorCheque() throws Exception {

		if (this.txtValorCheque == null) {

			this.txtValorCheque = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_AQC_VALOR_CHEQUE, 
																				  "txtValorCheque", 
																				  "",
																				  true, 
																				  true, 
																				  true, 
																				  super.getEventoForma(),
																				  EnumEtiquetas.LBL_AQC_VALOR_CHEQUE);

			this.txtValorCheque.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		
		return this.txtValorCheque;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropTxtValorVale 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   txtValorVale
	 * @return CajaTextoUtil 
	 * 		   caja de texto gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtValorVale() throws Exception {

		if (this.txtValorVale == null) {

			this.txtValorVale = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_AQC_VALOR_VALE, 
																				"txtValorVale", 
																				"", 
																				true,
																				true, 
																				true, 
																				super.getEventoForma(),
																				EnumEtiquetas.LBL_AQC_VALOR_VALE);

			this.txtValorVale.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		
		return this.txtValorVale;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropTxtBancoCheque 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   txtBancoCheque
	 * @return CajaTextoUtil 
	 * 		   caja de texto gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtBancoCheque() throws Exception {

		if (this.txtBancoCheque == null) {

			this.txtBancoCheque = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_AQC_BANCO_CHEQUE, 
																				  "txtBancoCheque", 
																				  "",
																				  true, 
																				  true, 
																				  true, 
																				  super.getEventoForma(),
																				  EnumEtiquetas.LBL_AQC_BANCO_CHEQUE);
			this.txtBancoCheque.getLblObligatorio().aplicarObligatoriedad(true);
		}
		
		return this.txtBancoCheque;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropTxtNumeroCheque 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   txtNumeroCheque
	 * @return CajaTextoUtil 
	 * 		   caja de texto gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtNumeroCheque() throws Exception {

		if (this.txtNumeroCheque == null) {

			this.txtNumeroCheque = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_AQC_NUMERO_CHEQUE, 
																				   "txtNumeroCheque", 
																				   "",
																				   true, 
																				   true, 
																				   true, 
																				   super.getEventoForma(),
																				   EnumEtiquetas.LBL_AQC_NUMERO_CHEQUE);
			this.txtNumeroCheque.getLblObligatorio().aplicarObligatoriedad(true);
		}
		
		return this.txtNumeroCheque;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropTxtNumeroVale 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   txtNumeroVale
	 * @return CajaTextoUtil 
	 * 		   caja de texto gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtNumeroVale() throws Exception {

		if (this.txtNumeroVale == null) {

			this.txtNumeroVale = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_AQC_NUMERO_VALE, 
																				 "txtNumeroVale", 
																				 "",
																				 true, 
																				 true, 
																				 true, 
																				 super.getEventoForma(),
																				 EnumEtiquetas.LBL_AQC_NUMERO_VALE);
			this.txtNumeroVale.getLblObligatorio().aplicarObligatoriedad(true);
		}
		
		return this.txtNumeroVale;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropTxtGiradorCheque 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   txtGiradorCheque
	 * @return CajaTextoUtil 
	 * 		   caja de texto gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtGiradorCheque() throws Exception {

		if (this.txtGiradorCheque == null) {

			this.txtGiradorCheque = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_AQC_GIRADOR_CHEQUE, 
																					"txtGiradorCheque", 
																					"",
																					true, 
																					true, 
																					true, 
																					super.getEventoForma(),
																					EnumEtiquetas.LBL_AQC_GIRADOR_CHEQUE);
			this.txtGiradorCheque.getLblObligatorio().aplicarObligatoriedad(true);
		}
		
		return this.txtGiradorCheque;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropTxtConceptoVale 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   txtConceptoVale
	 * @return CajaTextoUtil 
	 * 		   caja de texto gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtConceptoVale() throws Exception {

		if (this.txtConceptoVale == null) {

			this.txtConceptoVale = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_AQC_CONCEPTO_VALE, 
																				   "txtConceptoVale", 
																				   "",
																				   true, 
																				   true, 
																				   true, 
																				   super.getEventoForma(),
																				   EnumEtiquetas.LBL_AQC_CONCEPTO_VALE);
			this.txtConceptoVale.getLblObligatorio().aplicarObligatoriedad(true);
		}

		return this.txtConceptoVale;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropTxtTotalCaja 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   txtTotalCaja
	 * @return CajaTextoUtil 
	 * 		   caja de texto gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtTotalCaja() throws Exception {

		if (this.txtTotalCaja == null) {

			this.txtTotalCaja = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_AQC_TOTAL_CAJA, 
																				"txtTotalCaja", 
																				"", 
																				true,
																				false, 
																				true, 
																				super.getEventoForma(),
																				EnumEtiquetas.LBL_AQC_TOTAL_CAJA);

			this.txtTotalCaja.setFont(this.txtTotalCaja.getFont().deriveFont(Font.BOLD, 
																			 25));
			this.txtTotalCaja.setHorizontalAlignment(SwingConstants.TRAILING);
			this.txtTotalCaja.setFocusable(false);
		}
		
		return this.txtTotalCaja;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropTxtEnArqueo 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   txtEnArqueo
	 * @return CajaTextoUtil 
	 * 		   caja de texto gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtEnArqueo() throws Exception {

		if (this.txtEnArqueo == null) {

			this.txtEnArqueo = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_AQC_EN_ARQUEO, 
																			   "txtEnArqueo", 
																			   "", 
																			   true, 
																			   false,
																			   true, 
																			   super.getEventoForma(),
																			   EnumEtiquetas.LBL_AQC_EN_ARQUEO);

			this.txtEnArqueo.setFont(this.txtEnArqueo.getFont().deriveFont(Font.BOLD, 
																		   25));
			
			this.txtEnArqueo.setHorizontalAlignment(SwingConstants.TRAILING);
			this.txtEnArqueo.setFocusable(false);
		}
		
		return this.txtEnArqueo;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropTxtTotalDiferencia 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   txtTotalDiferencia
	 * @return CajaTextoUtil 
	 * 		   caja de texto gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtTotalDiferencia() throws Exception {

		if (this.txtTotalDiferencia == null) {

			this.txtTotalDiferencia = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_AQC_TOTAL_DIFERENCIA, 
																					  "txtTotalDiferencia", 
																					  "",
																					  true, 
																					  false, 
																					  true, 
																					  super.getEventoForma(),
																					  EnumEtiquetas.LBL_AQC_TOTAL_DIFERENCIA_EXACTA);

			this.txtTotalDiferencia.setFont(this.txtTotalDiferencia.getFont().deriveFont(Font.BOLD, 
																						 25));
			this.txtTotalDiferencia.setHorizontalAlignment(SwingConstants.TRAILING);
			this.txtTotalDiferencia.setFocusable(false);
		}
		
		return this.txtTotalDiferencia;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropTxtTotalXBilletes 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   txtTotalXBilletes
	 * @return CajaTextoUtil 
	 * 		   caja de texto gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtTotalXBilletes() throws Exception {

		if (this.txtTotalXBilletes == null) {

			this.txtTotalXBilletes = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_AQC_TOTAL_X_BILLETES, 
																					 "txtTotalXBilletes", 
																					 "",
																					 true, 
																					 false, 
																					 true, 
																					 super.getEventoForma(),
																					 EnumEtiquetas.LBL_AQC_TOTAL_X_BILLETES);
			this.txtTotalXBilletes.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		
		return this.txtTotalXBilletes;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropTxtTotalXMonedas 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   txtTotalXMonedas
	 * @return CajaTextoUtil 
	 * 		   caja de texto gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtTotalXMonedas() throws Exception {

		if (this.txtTotalXMonedas == null) {

			this.txtTotalXMonedas = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_AQC_TOTAL_X_MONEDAS, 
																					"txtTotalXMonedas", 
																					"",
																					true, 
																					false, 
																					true, 
																					super.getEventoForma(),
																					EnumEtiquetas.LBL_AQC_TOTAL_X_MONEDAS);
			this.txtTotalXMonedas.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		
		return this.txtTotalXMonedas;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropTxtTotalXCheques 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   txtTotalXCheques
	 * @return CajaTextoUtil 
	 * 		   caja de texto gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtTotalXCheques() throws Exception {

		if (this.txtTotalXCheques == null) {

			this.txtTotalXCheques = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_AQC_TOTAL_X_CHEQUES, 
																					"txtTotalXCheques", 
																					"",
																					true, 
																					false, 
																					true, 
																					super.getEventoForma(),
																					EnumEtiquetas.LBL_AQC_TOTAL_X_CHEQUES);
			this.txtTotalXCheques.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		
		return this.txtTotalXCheques;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropTxtTotalXVales 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   txtTotalXVales
	 * @return CajaTextoUtil 
	 * 		   caja de texto gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtTotalXVales() throws Exception {

		if (this.txtTotalXVales == null) {

			this.txtTotalXVales = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_AQC_TOTAL_X_VALES, 
																				  "txtTotalXVales", 
																				  "",
																				  true, 
																				  false, 
																				  true, 
																				  super.getEventoForma(),
																				  EnumEtiquetas.LBL_AQC_TOTAL_X_VALES);
			this.txtTotalXVales.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		
		return this.txtTotalXVales;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropTxaNotas 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   txaNotas
	 * @return AreaTextoUtil 
	 * 		   area de texto gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public AreaTextoUtil iniciarPropTxaNotas() throws Exception {

		if (this.txaNotas == null) {

			this.txaNotas = UtilComponentesGUI.getInstance().crearTextArea(null,
																		   "txaNotas", 
																		   "", 
																		   true, 
																		   true, 
																		   true, 
																		   super.getEventoForma(),
																		   EnumEtiquetas.LBL_AQC_NOTAS);
			
			this.txaNotas.setBorder(BorderFactory.createEmptyBorder());
			
			this.txaNotas.getScpContenedorRound(EnumDimensionesComponentes.TXA_AQC_NOTAS);
		}
		
		return this.txaNotas;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropBtnIngresarCantidadMontoBilletes 
	 * 		   Metodo estandar para autogestionar el valor del atributo
	 *         btnIngresarCantidadMontoBilletes
	 * @return BotonUtil 
	 * 		   boton de accion gestionado
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public BotonUtil iniciarPropBtnIngresarCantidadMontoBilletes()
			throws Exception {

		if (this.btnIngresarCantidadMontoBilletes == null) {

			this.btnIngresarCantidadMontoBilletes = UtilComponentesGUI.getInstance().crearBoton(EnumDimensionesComponentes.BTN_AQC_INGRESAR_CANT_MONTO_BILLETES,
																								"btnIngresarCantidadMontoBilletes",
																								EnumEtiquetas.BTN_AQC_INGRESAR_CANT_MONTO_BILLETES, 
																								true, 
																								true,
																								super.getEventoForma(), 
																								EnumImagenes.OP_INGRESAR.ajustarIcono(EnumDimensionesComponentes.IMG_BTN_AQC_INGRESAR_CANT_MONTO_BILLETES));
		}

		return btnIngresarCantidadMontoBilletes;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropBtnIngresarCheque 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   btnIngresarCheque
	 * @return BotonUtil 
	 * 		   boton de accion gestionado
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public BotonUtil iniciarPropBtnIngresarCheque() throws Exception {

		if (this.btnIngresarCheque == null) {

			this.btnIngresarCheque = UtilComponentesGUI.getInstance().crearBoton(EnumDimensionesComponentes.BTN_AQC_INGRESAR_CHEQUE, 
																				 "btnIngresarCheque",
																				 EnumEtiquetas.BTN_AQC_INGRESAR_CHEQUE,
																				 true, 
																				 true, 
																				 super.getEventoForma(), 
																				 EnumImagenes.OP_INGRESAR.ajustarIcono(EnumDimensionesComponentes.IMG_BTN_AQC_INGRESAR_CHEQUE));
		}

		return btnIngresarCheque;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropBtnIngresarVale 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   btnIngresarVale
	 * @return BotonUtil 
	 * 		   boton de accion gestionado
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public BotonUtil iniciarPropBtnIngresarVale() throws Exception {

		if (this.btnIngresarVale == null) {

			this.btnIngresarVale = UtilComponentesGUI.getInstance().crearBoton(EnumDimensionesComponentes.BTN_AQC_INGRESAR_VALE, 
																			   "btnIngresarVale",
																			   EnumEtiquetas.BTN_AQC_INGRESAR_VALE, 
																			   true, 
																			   true,
																			   super.getEventoForma(), 
																			   EnumImagenes.OP_INGRESAR.ajustarIcono(EnumDimensionesComponentes.IMG_BTN_AQC_INGRESAR_VALE));
		}

		return btnIngresarVale;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropBtnIngresarCantidadMontoMonedas 
	 * 		   Metodo estandar para autogestionar el valor del atributo
	 *         btnIngresarCantidadMontoMonedas
	 * @return BotonUtil 
	 * 		   boton de accion gestionado
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public BotonUtil iniciarPropBtnIngresarCantidadMontoMonedas()throws Exception {

		if (this.btnIngresarCantidadMontoMonedas == null) {

			this.btnIngresarCantidadMontoMonedas = UtilComponentesGUI.getInstance().crearBoton(EnumDimensionesComponentes.BTN_AQC_INGRESAR_CANT_MONTO_MONEDAS,
																							   "btnIngresarCantidadMontoMonedas",
																							   EnumEtiquetas.BTN_AQC_INGRESAR_CANT_MONTO_MONEDAS, 
																							   true, 
																							   true,
																							   super.getEventoForma(), 
																							   EnumImagenes.OP_INGRESAR.ajustarIcono(EnumDimensionesComponentes.IMG_BTN_AQC_INGRESAR_CANT_MONTO_MONEDAS));
		}

		return btnIngresarCantidadMontoMonedas;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropBtnEliminarRegistroIngresadoBilletes 
	 * 		   Metodo estandar para autogestionar el valor del atributo
	 *         btnEliminarRegistroIngresadoBilletes
	 * @return BotonUtil 
	 * 		   boton de accion gestionado
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public BotonUtil iniciarPropBtnEliminarRegistroIngresadoBilletes()
			throws Exception {

		if (this.btnEliminarRegistroIngresadoBilletes == null) {

			this.btnEliminarRegistroIngresadoBilletes = UtilComponentesGUI.getInstance().crearBoton(EnumDimensionesComponentes.BTN_AQC_ELIMINAR_REGISTRO_BILLETES,
																									"btnEliminarRegistroIngresadoBilletes",
																									EnumEtiquetas.BTN_AQC_ELIMINAR_REGISTRO_BILLETES, 
																									true, 
																									true,
																									super.getEventoForma(), 
																									EnumImagenes.OP_ELIMINAR.ajustarIcono(EnumDimensionesComponentes.IMG_BTN_AQC_ELIMINAR_REGISTRO_BILLETES));
		}

		return btnEliminarRegistroIngresadoBilletes;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropBtnEliminarRegistroIngresadoCheques 
	 * 		   Metodo estandar para autogestionar el valor del atributo
	 *         btnEliminarRegistroIngresadoCheques
	 * @return BotonUtil 
	 * 		   boton de accion gestionado
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public BotonUtil iniciarPropBtnEliminarRegistroIngresadoCheques()throws Exception {

		if (this.btnEliminarRegistroIngresadoCheques == null) {

			this.btnEliminarRegistroIngresadoCheques = UtilComponentesGUI.getInstance().crearBoton(EnumDimensionesComponentes.BTN_AQC_ELIMINAR_REGISTRO_CHEQUES,
																								   "btnEliminarRegistroIngresadoCheques",
																								   EnumEtiquetas.BTN_AQC_ELIMINAR_REGISTRO_CHEQUES, 
																								   true, 
																								   true,
																								   super.getEventoForma(), 
																								   EnumImagenes.OP_ELIMINAR.ajustarIcono(EnumDimensionesComponentes.IMG_BTN_AQC_ELIMINAR_REGISTRO_CHEQUES));
		}

		return btnEliminarRegistroIngresadoCheques;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropBtnEliminarRegistroIngresadoVales 
	 * 		   Metodo estandar para autogestionar el valor del atributo
	 *         btnEliminarRegistroIngresadoVales
	 * @return BotonUtil 
	 * 		   boton de accion gestionado
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public BotonUtil iniciarPropBtnEliminarRegistroIngresadoVales()throws Exception {

		if (this.btnEliminarRegistroIngresadoVales == null) {

			this.btnEliminarRegistroIngresadoVales = UtilComponentesGUI.getInstance().crearBoton(EnumDimensionesComponentes.BTN_AQC_ELIMINAR_REGISTRO_VALES,
																								 "btnEliminarRegistroIngresadoVales",
																								 EnumEtiquetas.BTN_AQC_ELIMINAR_REGISTRO_VALES, 
																								 true, 
																								 true,
																								 super.getEventoForma(), 
																								 EnumImagenes.OP_ELIMINAR.ajustarIcono(EnumDimensionesComponentes.IMG_BTN_AQC_ELIMINAR_REGISTRO_VALES));
		}

		return btnEliminarRegistroIngresadoVales;
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarPropBtnEliminarRegistroIngresadoMonedas 
	 * 		   Metodo estandar para autogestionar el valor del atributo
	 *         btnEliminarRegistroIngresadoMonedas
	 * @return BotonUtil 
	 * 		   boton de accion gestionado
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public BotonUtil iniciarPropBtnEliminarRegistroIngresadoMonedas()throws Exception {

		if (this.btnEliminarRegistroIngresadoMonedas == null) {

			this.btnEliminarRegistroIngresadoMonedas = UtilComponentesGUI.getInstance().crearBoton(EnumDimensionesComponentes.BTN_AQC_ELIMINAR_REGISTRO_MONEDAS,
																								   "btnEliminarRegistroIngresadoMonedas",
																								   EnumEtiquetas.BTN_AQC_ELIMINAR_REGISTRO_MONEDAS, 
																								   true, 
																								   true,
																								   super.getEventoForma(), 
																								   EnumImagenes.OP_ELIMINAR.ajustarIcono(EnumDimensionesComponentes.IMG_BTN_AQC_ELIMINAR_REGISTRO_MONEDAS));
		}
		
		return btnEliminarRegistroIngresadoMonedas;
	}
	
	/*public JPanel getPnlSeccionBilletes() {
		return pnlSeccionBilletes;
	}

	public void setPnlSeccionBilletes(JPanel pnlSeccionBilletes) {
		this.pnlSeccionBilletes = pnlSeccionBilletes;
	}

	public JPanel getPnlSeccionCheques() {
		return pnlSeccionCheques;
	}

	public void setPnlSeccionCheques(JPanel pnlSeccionCheques) {
		this.pnlSeccionCheques = pnlSeccionCheques;
	}

	public JPanel getPnlSeccionVales() {
		return pnlSeccionVales;
	}

	public void setPnlSeccionVales(JPanel pnlSeccionVales) {
		this.pnlSeccionVales = pnlSeccionVales;
	}

	public JPanel getPnlSeccionMonedas() {
		return pnlSeccionMonedas;
	}

	public void setPnlSeccionMonedas(JPanel pnlSeccionMonedas) {
		this.pnlSeccionMonedas = pnlSeccionMonedas;
	}

	public JPanel getPnlDatAdiCheque() {
		return pnlDatAdiCheque;
	}

	public void setPnlDatAdiCheque(JPanel pnlDatAdiCheque) {
		this.pnlDatAdiCheque = pnlDatAdiCheque;
	}

	public JPanel getPnlDatAdiVale() {
		return pnlDatAdiVale;
	}

	public void setPnlDatAdiVale(JPanel pnlDatAdiVale) {
		this.pnlDatAdiVale = pnlDatAdiVale;
	}

	public JPanel getPnlSeccionCuadreCaja() {
		return pnlSeccionCuadreCaja;
	}

	public void setPnlSeccionCuadreCaja(JPanel pnlSeccionCuadreCaja) {
		this.pnlSeccionCuadreCaja = pnlSeccionCuadreCaja;
	}

	public JScrollPane getScpGrillaDenominacionBilletes() {
		return scpGrillaDenominacionBilletes;
	}

	public void setScpGrillaDenominacionBilletes(
			JScrollPane scpGrillaDenominacionBilletes) {
		this.scpGrillaDenominacionBilletes = scpGrillaDenominacionBilletes;
	}

	public JScrollPane getScpGrillaCheques() {
		return scpGrillaCheques;
	}

	public void setScpGrillaCheques(JScrollPane scpGrillaCheques) {
		this.scpGrillaCheques = scpGrillaCheques;
	}

	public JScrollPane getScpGrillaVales() {
		return scpGrillaVales;
	}

	public void setScpGrillaVales(JScrollPane scpGrillaVales) {
		this.scpGrillaVales = scpGrillaVales;
	}

	public JScrollPane getScpGrillaDenominacionMonedas() {
		return scpGrillaDenominacionMonedas;
	}

	public void setScpGrillaDenominacionMonedas(
			JScrollPane scpGrillaDenominacionMonedas) {
		this.scpGrillaDenominacionMonedas = scpGrillaDenominacionMonedas;
	}

	public GrillaUtil getTblDenominacionBilletes() {
		return tblDenominacionBilletes;
	}

	public void setTblDenominacionBilletes(GrillaUtil tblDenominacionBilletes) {
		this.tblDenominacionBilletes = tblDenominacionBilletes;
	}

	public GrillaUtil getTblCheques() {
		return tblCheques;
	}

	public void setTblCheques(GrillaUtil tblCheques) {
		this.tblCheques = tblCheques;
	}

	public GrillaUtil getTblVales() {
		return tblVales;
	}

	public void setTblVales(GrillaUtil tblVales) {
		this.tblVales = tblVales;
	}

	public GrillaUtil getTblDenominacionMonedas() {
		return tblDenominacionMonedas;
	}

	public void setTblDenominacionMonedas(GrillaUtil tblDenominacionMonedas) {
		this.tblDenominacionMonedas = tblDenominacionMonedas;
	}

	public EtiquetaUtil getLblListaBilletes() {
		return lblListaBilletes;
	}

	public void setLblListaBilletes(EtiquetaUtil lblListaBilletes) {
		this.lblListaBilletes = lblListaBilletes;
	}

	public EtiquetaUtil getLblListaCheques() {
		return lblListaCheques;
	}

	public void setLblListaCheques(EtiquetaUtil lblListaCheques) {
		this.lblListaCheques = lblListaCheques;
	}

	public EtiquetaUtil getLblListaVales() {
		return lblListaVales;
	}

	public void setLblListaVales(EtiquetaUtil lblListaVales) {
		this.lblListaVales = lblListaVales;
	}

	public EtiquetaUtil getLblListaMonedas() {
		return lblListaMonedas;
	}

	public void setLblListaMonedas(EtiquetaUtil lblListaMonedas) {
		this.lblListaMonedas = lblListaMonedas;
	}

	public EtiquetaUtil getLblCantidadMontoBilletes() {
		return lblCantidadMontoBilletes;
	}

	public void setLblCantidadMontoBilletes(EtiquetaUtil lblCantidadMontoBilletes) {
		this.lblCantidadMontoBilletes = lblCantidadMontoBilletes;
	}

	public EtiquetaUtil getLblValorCheque() {
		return lblValorCheque;
	}

	public void setLblValorCheque(EtiquetaUtil lblValorCheque) {
		this.lblValorCheque = lblValorCheque;
	}

	public EtiquetaUtil getLblValorVale() {
		return lblValorVale;
	}

	public void setLblValorVale(EtiquetaUtil lblValorVale) {
		this.lblValorVale = lblValorVale;
	}

	public EtiquetaUtil getLblCantidadMontoMonedas() {
		return lblCantidadMontoMonedas;
	}

	public void setLblCantidadMontoMonedas(EtiquetaUtil lblCantidadMontoMonedas) {
		this.lblCantidadMontoMonedas = lblCantidadMontoMonedas;
	}

	public EtiquetaUtil getLblFechaCheque() {
		return lblFechaCheque;
	}

	public void setLblFechaCheque(EtiquetaUtil lblFechaCheque) {
		this.lblFechaCheque = lblFechaCheque;
	}

	public EtiquetaUtil getLblFechaVale() {
		return lblFechaVale;
	}

	public void setLblFechaVale(EtiquetaUtil lblFechaVale) {
		this.lblFechaVale = lblFechaVale;
	}

	public EtiquetaUtil getLblBancoCheque() {
		return lblBancoCheque;
	}

	public void setLblBancoCheque(EtiquetaUtil lblBancoCheque) {
		this.lblBancoCheque = lblBancoCheque;
	}

	public EtiquetaUtil getLblNumeroCheque() {
		return lblNumeroCheque;
	}

	public void setLblNumeroCheque(EtiquetaUtil lblNumeroCheque) {
		this.lblNumeroCheque = lblNumeroCheque;
	}

	public EtiquetaUtil getLblNumeroVale() {
		return lblNumeroVale;
	}

	public void setLblNumeroVale(EtiquetaUtil lblNumeroVale) {
		this.lblNumeroVale = lblNumeroVale;
	}

	public EtiquetaUtil getLblGiradorCheque() {
		return lblGiradorCheque;
	}

	public void setLblGiradorCheque(EtiquetaUtil lblGiradorCheque) {
		this.lblGiradorCheque = lblGiradorCheque;
	}

	public EtiquetaUtil getLblConceptoVale() {
		return lblConceptoVale;
	}

	public void setLblConceptoVale(EtiquetaUtil lblConceptoVale) {
		this.lblConceptoVale = lblConceptoVale;
	}

	public EtiquetaUtil getLblNotas() {
		return lblNotas;
	}

	public void setLblNotas(EtiquetaUtil lblNotas) {
		this.lblNotas = lblNotas;
	}

	public EtiquetaUtil getLblTotalCaja() {
		return lblTotalCaja;
	}

	public void setLblTotalCaja(EtiquetaUtil lblTotalCaja) {
		this.lblTotalCaja = lblTotalCaja;
	}

	public EtiquetaUtil getLblEnArqueo() {
		return lblEnArqueo;
	}

	public void setLblEnArqueo(EtiquetaUtil lblEnArqueo) {
		this.lblEnArqueo = lblEnArqueo;
	}

	public EtiquetaUtil getLblTotalDiferencia() {
		return lblTotalDiferencia;
	}

	public void setLblTotalDiferencia(EtiquetaUtil lblTotalDiferencia) {
		this.lblTotalDiferencia = lblTotalDiferencia;
	}

	public EtiquetaUtil getLblTotalXBilletes() {
		return lblTotalXBilletes;
	}

	public void setLblTotalXBilletes(EtiquetaUtil lblTotalXBilletes) {
		this.lblTotalXBilletes = lblTotalXBilletes;
	}

	public EtiquetaUtil getLblTotalXMonedas() {
		return lblTotalXMonedas;
	}

	public void setLblTotalXMonedas(EtiquetaUtil lblTotalXMonedas) {
		this.lblTotalXMonedas = lblTotalXMonedas;
	}

	public EtiquetaUtil getLblTotalXCheques() {
		return lblTotalXCheques;
	}

	public void setLblTotalXCheques(EtiquetaUtil lblTotalXCheques) {
		this.lblTotalXCheques = lblTotalXCheques;
	}

	public EtiquetaUtil getLblTotalXVales() {
		return lblTotalXVales;
	}

	public void setLblTotalXVales(EtiquetaUtil lblTotalXVales) {
		this.lblTotalXVales = lblTotalXVales;
	}

	public CajaFechaUtil getDtcFechaCheque() {
		return dtcFechaCheque;
	}

	public void setDtcFechaCheque(CajaFechaUtil dtcFechaCheque) {
		this.dtcFechaCheque = dtcFechaCheque;
	}

	public CajaFechaUtil getDtcFechaVale() {
		return dtcFechaVale;
	}

	public void setDtcFechaVale(CajaFechaUtil dtcFechaVale) {
		this.dtcFechaVale = dtcFechaVale;
	}

	public CajaComboUtil getCmbListaBilletes() {
		return cmbListaBilletes;
	}

	public void setCmbListaBilletes(CajaComboUtil cmbListaBilletes) {
		this.cmbListaBilletes = cmbListaBilletes;
	}

	public CajaComboUtil getCmbListaCheques() {
		return cmbListaCheques;
	}

	public void setCmbListaCheques(CajaComboUtil cmbListaCheques) {
		this.cmbListaCheques = cmbListaCheques;
	}

	public CajaComboUtil getCmbListaVales() {
		return cmbListaVales;
	}

	public void setCmbListaVales(CajaComboUtil cmbListaVales) {
		this.cmbListaVales = cmbListaVales;
	}

	public CajaComboUtil getCmbListaMonedas() {
		return cmbListaMonedas;
	}

	public void setCmbListaMonedas(CajaComboUtil cmbListaMonedas) {
		this.cmbListaMonedas = cmbListaMonedas;
	}

	public CajaTextoUtil getTxtCantidadMontoBilletes() {
		return txtCantidadMontoBilletes;
	}

	public void setTxtCantidadMontoBilletes(
			CajaTextoUtil txtCantidadMontoBilletes) {
		this.txtCantidadMontoBilletes = txtCantidadMontoBilletes;
	}

	public CajaTextoUtil getTxtValorCheque() {
		return txtValorCheque;
	}

	public void setTxtValorCheque(CajaTextoUtil txtValorCheque) {
		this.txtValorCheque = txtValorCheque;
	}

	public CajaTextoUtil getTxtValorVale() {
		return txtValorVale;
	}

	public void setTxtValorVale(CajaTextoUtil txtValorVale) {
		this.txtValorVale = txtValorVale;
	}

	public CajaTextoUtil getTxtBancoCheque() {
		return txtBancoCheque;
	}

	public void setTxtBancoCheque(CajaTextoUtil txtBancoCheque) {
		this.txtBancoCheque = txtBancoCheque;
	}

	public CajaTextoUtil getTxtNumeroCheque() {
		return txtNumeroCheque;
	}

	public void setTxtNumeroCheque(CajaTextoUtil txtNumeroCheque) {
		this.txtNumeroCheque = txtNumeroCheque;
	}

	public CajaTextoUtil getTxtNumeroVale() {
		return txtNumeroVale;
	}

	public void setTxtNumeroVale(CajaTextoUtil txtNumeroVale) {
		this.txtNumeroVale = txtNumeroVale;
	}

	public CajaTextoUtil getTxtGiradorCheque() {
		return txtGiradorCheque;
	}

	public void setTxtGiradorCheque(CajaTextoUtil txtGiradorCheque) {
		this.txtGiradorCheque = txtGiradorCheque;
	}

	public CajaTextoUtil getTxtConceptoVale() {
		return txtConceptoVale;
	}

	public void setTxtConceptoVale(CajaTextoUtil txtConceptoVale) {
		this.txtConceptoVale = txtConceptoVale;
	}

	public CajaTextoUtil getTxtTotalCaja() {
		return txtTotalCaja;
	}

	public void setTxtTotalCaja(CajaTextoUtil txtTotalCaja) {
		this.txtTotalCaja = txtTotalCaja;
	}

	public CajaTextoUtil getTxtEnArqueo() {
		return txtEnArqueo;
	}

	public void setTxtEnArqueo(CajaTextoUtil txtEnArqueo) {
		this.txtEnArqueo = txtEnArqueo;
	}

	public CajaTextoUtil getTxtTotalDiferencia() {
		return txtTotalDiferencia;
	}

	public void setTxtTotalDiferencia(CajaTextoUtil txtTotalDiferencia) {
		this.txtTotalDiferencia = txtTotalDiferencia;
	}

	public CajaTextoUtil getTxtTotalXBilletes() {
		return txtTotalXBilletes;
	}

	public void setTxtTotalXBilletes(CajaTextoUtil txtTotalXBilletes) {
		this.txtTotalXBilletes = txtTotalXBilletes;
	}

	public CajaTextoUtil getTxtTotalXMonedas() {
		return txtTotalXMonedas;
	}

	public void setTxtTotalXMonedas(CajaTextoUtil txtTotalXMonedas) {
		this.txtTotalXMonedas = txtTotalXMonedas;
	}

	public CajaTextoUtil getTxtTotalXCheques() {
		return txtTotalXCheques;
	}

	public void setTxtTotalXCheques(CajaTextoUtil txtTotalXCheques) {
		this.txtTotalXCheques = txtTotalXCheques;
	}

	public CajaTextoUtil getTxtTotalXVales() {
		return txtTotalXVales;
	}

	public void setTxtTotalXVales(CajaTextoUtil txtTotalXVales) {
		this.txtTotalXVales = txtTotalXVales;
	}

	public AreaTextoUtil getTxaNotas() {
		return txaNotas;
	}

	public void setTxaNotas(AreaTextoUtil txaNotas) {
		this.txaNotas = txaNotas;
	}

	public BotonUtil getBtnIngresarCantidadMontoBilletes() {
		return btnIngresarCantidadMontoBilletes;
	}

	public void setBtnIngresarCantidadMontoBilletes(
			BotonUtil btnIngresarCantidadMontoBilletes) {
		this.btnIngresarCantidadMontoBilletes = btnIngresarCantidadMontoBilletes;
	}

	public BotonUtil getBtnIngresarCheque() {
		return btnIngresarCheque;
	}

	public void setBtnIngresarCheque(BotonUtil btnIngresarCheque) {
		this.btnIngresarCheque = btnIngresarCheque;
	}

	public BotonUtil getBtnIngresarVale() {
		return btnIngresarVale;
	}

	public void setBtnIngresarVale(BotonUtil btnIngresarVale) {
		this.btnIngresarVale = btnIngresarVale;
	}

	public BotonUtil getBtnIngresarCantidadMontoMonedas() {
		return btnIngresarCantidadMontoMonedas;
	}

	public void setBtnIngresarCantidadMontoMonedas(
			BotonUtil btnIngresarCantidadMontoMonedas) {
		this.btnIngresarCantidadMontoMonedas = btnIngresarCantidadMontoMonedas;
	}

	public BotonUtil getBtnEliminarRegistroIngresadoBilletes() {
		return btnEliminarRegistroIngresadoBilletes;
	}

	public void setBtnEliminarRegistroIngresadoBilletes(
			BotonUtil btnEliminarRegistroIngresadoBilletes) {
		this.btnEliminarRegistroIngresadoBilletes = btnEliminarRegistroIngresadoBilletes;
	}

	public BotonUtil getBtnEliminarRegistroIngresadoCheques() {
		return btnEliminarRegistroIngresadoCheques;
	}

	public void setBtnEliminarRegistroIngresadoCheques(
			BotonUtil btnEliminarRegistroIngresadoCheques) {
		this.btnEliminarRegistroIngresadoCheques = btnEliminarRegistroIngresadoCheques;
	}

	public BotonUtil getBtnEliminarRegistroIngresadoVales() {
		return btnEliminarRegistroIngresadoVales;
	}

	public void setBtnEliminarRegistroIngresadoVales(
			BotonUtil btnEliminarRegistroIngresadoVales) {
		this.btnEliminarRegistroIngresadoVales = btnEliminarRegistroIngresadoVales;
	}

	public BotonUtil getBtnEliminarRegistroIngresadoMonedas() {
		return btnEliminarRegistroIngresadoMonedas;
	}

	public void setBtnEliminarRegistroIngresadoMonedas(
			BotonUtil btnEliminarRegistroIngresadoMonedas) {
		this.btnEliminarRegistroIngresadoMonedas = btnEliminarRegistroIngresadoMonedas;
	}

	public CajaTextoUtil getTxtCantidadMontoMonedas() {
		return txtCantidadMontoMonedas;
	}

	public void setTxtCantidadMontoMonedas(CajaTextoUtil txtCantidadMontoMonedas) {
		this.txtCantidadMontoMonedas = txtCantidadMontoMonedas;
	}*/

	/**
	 * @method getPnlSeccionBilletes
	 * 		   Metodo get del atributo pnlSeccionBilletes
	 * @return JPanel
	 *		   Valor del atributo pnlSeccionBilletes devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public JPanel getPnlSeccionBilletes() {
		return this.pnlSeccionBilletes;
	}

	/**
	 * @method setPnlSeccionBilletes
	 * 		   Metodo set del atributo pnlSeccionBilletes
	 * @param  pPnlSeccionBilletes
	 *		   Valor que tomara el atributo pnlSeccionBilletes
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setPnlSeccionBilletes(JPanel pPnlSeccionBilletes) {
		this.pnlSeccionBilletes = pPnlSeccionBilletes;
	}

	/**
	 * @method getPnlSeccionCheques
	 * 		   Metodo get del atributo pnlSeccionCheques
	 * @return JPanel
	 *		   Valor del atributo pnlSeccionCheques devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public JPanel getPnlSeccionCheques() {
		return this.pnlSeccionCheques;
	}

	/**
	 * @method setPnlSeccionCheques
	 * 		   Metodo set del atributo pnlSeccionCheques
	 * @param  pPnlSeccionCheques
	 *		   Valor que tomara el atributo pnlSeccionCheques
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setPnlSeccionCheques(JPanel pPnlSeccionCheques) {
		this.pnlSeccionCheques = pPnlSeccionCheques;
	}

	/**
	 * @method getPnlSeccionVales
	 * 		   Metodo get del atributo pnlSeccionVales
	 * @return JPanel
	 *		   Valor del atributo pnlSeccionVales devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public JPanel getPnlSeccionVales() {
		return this.pnlSeccionVales;
	}

	/**
	 * @method setPnlSeccionVales
	 * 		   Metodo set del atributo pnlSeccionVales
	 * @param  pPnlSeccionVales
	 *		   Valor que tomara el atributo pnlSeccionVales
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setPnlSeccionVales(JPanel pPnlSeccionVales) {
		this.pnlSeccionVales = pPnlSeccionVales;
	}

	/**
	 * @method getPnlSeccionMonedas
	 * 		   Metodo get del atributo pnlSeccionMonedas
	 * @return JPanel
	 *		   Valor del atributo pnlSeccionMonedas devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public JPanel getPnlSeccionMonedas() {
		return this.pnlSeccionMonedas;
	}

	/**
	 * @method setPnlSeccionMonedas
	 * 		   Metodo set del atributo pnlSeccionMonedas
	 * @param  pPnlSeccionMonedas
	 *		   Valor que tomara el atributo pnlSeccionMonedas
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setPnlSeccionMonedas(JPanel pPnlSeccionMonedas) {
		this.pnlSeccionMonedas = pPnlSeccionMonedas;
	}

	/**
	 * @method getPnlDatAdiCheque
	 * 		   Metodo get del atributo pnlDatAdiCheque
	 * @return JPanel
	 *		   Valor del atributo pnlDatAdiCheque devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public JPanel getPnlDatAdiCheque() {
		return this.pnlDatAdiCheque;
	}

	/**
	 * @method setPnlDatAdiCheque
	 * 		   Metodo set del atributo pnlDatAdiCheque
	 * @param  pPnlDatAdiCheque
	 *		   Valor que tomara el atributo pnlDatAdiCheque
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setPnlDatAdiCheque(JPanel pPnlDatAdiCheque) {
		this.pnlDatAdiCheque = pPnlDatAdiCheque;
	}

	/**
	 * @method getPnlDatAdiVale
	 * 		   Metodo get del atributo pnlDatAdiVale
	 * @return JPanel
	 *		   Valor del atributo pnlDatAdiVale devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public JPanel getPnlDatAdiVale() {
		return this.pnlDatAdiVale;
	}

	/**
	 * @method setPnlDatAdiVale
	 * 		   Metodo set del atributo pnlDatAdiVale
	 * @param  pPnlDatAdiVale
	 *		   Valor que tomara el atributo pnlDatAdiVale
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setPnlDatAdiVale(JPanel pPnlDatAdiVale) {
		this.pnlDatAdiVale = pPnlDatAdiVale;
	}

	/**
	 * @method getPnlSeccionCuadreCaja
	 * 		   Metodo get del atributo pnlSeccionCuadreCaja
	 * @return JPanel
	 *		   Valor del atributo pnlSeccionCuadreCaja devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public JPanel getPnlSeccionCuadreCaja() {
		return this.pnlSeccionCuadreCaja;
	}

	/**
	 * @method setPnlSeccionCuadreCaja
	 * 		   Metodo set del atributo pnlSeccionCuadreCaja
	 * @param  pPnlSeccionCuadreCaja
	 *		   Valor que tomara el atributo pnlSeccionCuadreCaja
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setPnlSeccionCuadreCaja(JPanel pPnlSeccionCuadreCaja) {
		this.pnlSeccionCuadreCaja = pPnlSeccionCuadreCaja;
	}

	/**
	 * @method getScpGrillaDenominacionBilletes
	 * 		   Metodo get del atributo scpGrillaDenominacionBilletes
	 * @return JScrollPane
	 *		   Valor del atributo scpGrillaDenominacionBilletes devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public JScrollPane getScpGrillaDenominacionBilletes() {
		return this.scpGrillaDenominacionBilletes;
	}

	/**
	 * @method setScpGrillaDenominacionBilletes
	 * 		   Metodo set del atributo scpGrillaDenominacionBilletes
	 * @param  pScpGrillaDenominacionBilletes
	 *		   Valor que tomara el atributo scpGrillaDenominacionBilletes
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setScpGrillaDenominacionBilletes(
			JScrollPane pScpGrillaDenominacionBilletes) {
		this.scpGrillaDenominacionBilletes = pScpGrillaDenominacionBilletes;
	}

	/**
	 * @method getScpGrillaCheques
	 * 		   Metodo get del atributo scpGrillaCheques
	 * @return JScrollPane
	 *		   Valor del atributo scpGrillaCheques devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public JScrollPane getScpGrillaCheques() {
		return this.scpGrillaCheques;
	}

	/**
	 * @method setScpGrillaCheques
	 * 		   Metodo set del atributo scpGrillaCheques
	 * @param  pScpGrillaCheques
	 *		   Valor que tomara el atributo scpGrillaCheques
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setScpGrillaCheques(JScrollPane pScpGrillaCheques) {
		this.scpGrillaCheques = pScpGrillaCheques;
	}

	/**
	 * @method getScpGrillaVales
	 * 		   Metodo get del atributo scpGrillaVales
	 * @return JScrollPane
	 *		   Valor del atributo scpGrillaVales devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public JScrollPane getScpGrillaVales() {
		return this.scpGrillaVales;
	}

	/**
	 * @method setScpGrillaVales
	 * 		   Metodo set del atributo scpGrillaVales
	 * @param  pScpGrillaVales
	 *		   Valor que tomara el atributo scpGrillaVales
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setScpGrillaVales(JScrollPane pScpGrillaVales) {
		this.scpGrillaVales = pScpGrillaVales;
	}

	/**
	 * @method getScpGrillaDenominacionMonedas
	 * 		   Metodo get del atributo scpGrillaDenominacionMonedas
	 * @return JScrollPane
	 *		   Valor del atributo scpGrillaDenominacionMonedas devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public JScrollPane getScpGrillaDenominacionMonedas() {
		return this.scpGrillaDenominacionMonedas;
	}

	/**
	 * @method setScpGrillaDenominacionMonedas
	 * 		   Metodo set del atributo scpGrillaDenominacionMonedas
	 * @param  pScpGrillaDenominacionMonedas
	 *		   Valor que tomara el atributo scpGrillaDenominacionMonedas
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setScpGrillaDenominacionMonedas(
			JScrollPane pScpGrillaDenominacionMonedas) {
		this.scpGrillaDenominacionMonedas = pScpGrillaDenominacionMonedas;
	}

	/**
	 * @method getTblDenominacionBilletes
	 * 		   Metodo get del atributo tblDenominacionBilletes
	 * @return GrillaUtil
	 *		   Valor del atributo tblDenominacionBilletes devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public GrillaUtil getTblDenominacionBilletes() {
		return this.tblDenominacionBilletes;
	}

	/**
	 * @method setTblDenominacionBilletes
	 * 		   Metodo set del atributo tblDenominacionBilletes
	 * @param  pTblDenominacionBilletes
	 *		   Valor que tomara el atributo tblDenominacionBilletes
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setTblDenominacionBilletes(GrillaUtil pTblDenominacionBilletes) {
		this.tblDenominacionBilletes = pTblDenominacionBilletes;
	}

	/**
	 * @method getTblCheques
	 * 		   Metodo get del atributo tblCheques
	 * @return GrillaUtil
	 *		   Valor del atributo tblCheques devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public GrillaUtil getTblCheques() {
		return this.tblCheques;
	}

	/**
	 * @method setTblCheques
	 * 		   Metodo set del atributo tblCheques
	 * @param  pTblCheques
	 *		   Valor que tomara el atributo tblCheques
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setTblCheques(GrillaUtil pTblCheques) {
		this.tblCheques = pTblCheques;
	}

	/**
	 * @method getTblVales
	 * 		   Metodo get del atributo tblVales
	 * @return GrillaUtil
	 *		   Valor del atributo tblVales devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public GrillaUtil getTblVales() {
		return this.tblVales;
	}

	/**
	 * @method setTblVales
	 * 		   Metodo set del atributo tblVales
	 * @param  pTblVales
	 *		   Valor que tomara el atributo tblVales
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setTblVales(GrillaUtil pTblVales) {
		this.tblVales = pTblVales;
	}

	/**
	 * @method getTblDenominacionMonedas
	 * 		   Metodo get del atributo tblDenominacionMonedas
	 * @return GrillaUtil
	 *		   Valor del atributo tblDenominacionMonedas devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public GrillaUtil getTblDenominacionMonedas() {
		return this.tblDenominacionMonedas;
	}

	/**
	 * @method setTblDenominacionMonedas
	 * 		   Metodo set del atributo tblDenominacionMonedas
	 * @param  pTblDenominacionMonedas
	 *		   Valor que tomara el atributo tblDenominacionMonedas
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setTblDenominacionMonedas(GrillaUtil pTblDenominacionMonedas) {
		this.tblDenominacionMonedas = pTblDenominacionMonedas;
	}

	/**
	 * @method getLblListaBilletes
	 * 		   Metodo get del atributo lblListaBilletes
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblListaBilletes devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public EtiquetaUtil getLblListaBilletes() {
		return this.lblListaBilletes;
	}

	/**
	 * @method setLblListaBilletes
	 * 		   Metodo set del atributo lblListaBilletes
	 * @param  pLblListaBilletes
	 *		   Valor que tomara el atributo lblListaBilletes
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setLblListaBilletes(EtiquetaUtil pLblListaBilletes) {
		this.lblListaBilletes = pLblListaBilletes;
	}

	/**
	 * @method getLblListaCheques
	 * 		   Metodo get del atributo lblListaCheques
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblListaCheques devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public EtiquetaUtil getLblListaCheques() {
		return this.lblListaCheques;
	}

	/**
	 * @method setLblListaCheques
	 * 		   Metodo set del atributo lblListaCheques
	 * @param  pLblListaCheques
	 *		   Valor que tomara el atributo lblListaCheques
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setLblListaCheques(EtiquetaUtil pLblListaCheques) {
		this.lblListaCheques = pLblListaCheques;
	}

	/**
	 * @method getLblListaVales
	 * 		   Metodo get del atributo lblListaVales
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblListaVales devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public EtiquetaUtil getLblListaVales() {
		return this.lblListaVales;
	}

	/**
	 * @method setLblListaVales
	 * 		   Metodo set del atributo lblListaVales
	 * @param  pLblListaVales
	 *		   Valor que tomara el atributo lblListaVales
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setLblListaVales(EtiquetaUtil pLblListaVales) {
		this.lblListaVales = pLblListaVales;
	}

	/**
	 * @method getLblListaMonedas
	 * 		   Metodo get del atributo lblListaMonedas
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblListaMonedas devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public EtiquetaUtil getLblListaMonedas() {
		return this.lblListaMonedas;
	}

	/**
	 * @method setLblListaMonedas
	 * 		   Metodo set del atributo lblListaMonedas
	 * @param  pLblListaMonedas
	 *		   Valor que tomara el atributo lblListaMonedas
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setLblListaMonedas(EtiquetaUtil pLblListaMonedas) {
		this.lblListaMonedas = pLblListaMonedas;
	}

	/**
	 * @method getLblCantidadMontoBilletes
	 * 		   Metodo get del atributo lblCantidadMontoBilletes
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblCantidadMontoBilletes devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public EtiquetaUtil getLblCantidadMontoBilletes() {
		return this.lblCantidadMontoBilletes;
	}

	/**
	 * @method setLblCantidadMontoBilletes
	 * 		   Metodo set del atributo lblCantidadMontoBilletes
	 * @param  pLblCantidadMontoBilletes
	 *		   Valor que tomara el atributo lblCantidadMontoBilletes
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setLblCantidadMontoBilletes(EtiquetaUtil pLblCantidadMontoBilletes) {
		this.lblCantidadMontoBilletes = pLblCantidadMontoBilletes;
	}

	/**
	 * @method getLblValorCheque
	 * 		   Metodo get del atributo lblValorCheque
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblValorCheque devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public EtiquetaUtil getLblValorCheque() {
		return this.lblValorCheque;
	}

	/**
	 * @method setLblValorCheque
	 * 		   Metodo set del atributo lblValorCheque
	 * @param  pLblValorCheque
	 *		   Valor que tomara el atributo lblValorCheque
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setLblValorCheque(EtiquetaUtil pLblValorCheque) {
		this.lblValorCheque = pLblValorCheque;
	}

	/**
	 * @method getLblValorVale
	 * 		   Metodo get del atributo lblValorVale
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblValorVale devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public EtiquetaUtil getLblValorVale() {
		return this.lblValorVale;
	}

	/**
	 * @method setLblValorVale
	 * 		   Metodo set del atributo lblValorVale
	 * @param  pLblValorVale
	 *		   Valor que tomara el atributo lblValorVale
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setLblValorVale(EtiquetaUtil pLblValorVale) {
		this.lblValorVale = pLblValorVale;
	}

	/**
	 * @method getLblCantidadMontoMonedas
	 * 		   Metodo get del atributo lblCantidadMontoMonedas
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblCantidadMontoMonedas devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public EtiquetaUtil getLblCantidadMontoMonedas() {
		return this.lblCantidadMontoMonedas;
	}

	/**
	 * @method setLblCantidadMontoMonedas
	 * 		   Metodo set del atributo lblCantidadMontoMonedas
	 * @param  pLblCantidadMontoMonedas
	 *		   Valor que tomara el atributo lblCantidadMontoMonedas
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setLblCantidadMontoMonedas(EtiquetaUtil pLblCantidadMontoMonedas) {
		this.lblCantidadMontoMonedas = pLblCantidadMontoMonedas;
	}

	/**
	 * @method getLblFechaCheque
	 * 		   Metodo get del atributo lblFechaCheque
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblFechaCheque devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public EtiquetaUtil getLblFechaCheque() {
		return this.lblFechaCheque;
	}

	/**
	 * @method setLblFechaCheque
	 * 		   Metodo set del atributo lblFechaCheque
	 * @param  pLblFechaCheque
	 *		   Valor que tomara el atributo lblFechaCheque
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setLblFechaCheque(EtiquetaUtil pLblFechaCheque) {
		this.lblFechaCheque = pLblFechaCheque;
	}

	/**
	 * @method getLblFechaVale
	 * 		   Metodo get del atributo lblFechaVale
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblFechaVale devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public EtiquetaUtil getLblFechaVale() {
		return this.lblFechaVale;
	}

	/**
	 * @method setLblFechaVale
	 * 		   Metodo set del atributo lblFechaVale
	 * @param  pLblFechaVale
	 *		   Valor que tomara el atributo lblFechaVale
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setLblFechaVale(EtiquetaUtil pLblFechaVale) {
		this.lblFechaVale = pLblFechaVale;
	}

	/**
	 * @method getLblBancoCheque
	 * 		   Metodo get del atributo lblBancoCheque
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblBancoCheque devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public EtiquetaUtil getLblBancoCheque() {
		return this.lblBancoCheque;
	}

	/**
	 * @method setLblBancoCheque
	 * 		   Metodo set del atributo lblBancoCheque
	 * @param  pLblBancoCheque
	 *		   Valor que tomara el atributo lblBancoCheque
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setLblBancoCheque(EtiquetaUtil pLblBancoCheque) {
		this.lblBancoCheque = pLblBancoCheque;
	}

	/**
	 * @method getLblNumeroCheque
	 * 		   Metodo get del atributo lblNumeroCheque
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblNumeroCheque devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public EtiquetaUtil getLblNumeroCheque() {
		return this.lblNumeroCheque;
	}

	/**
	 * @method setLblNumeroCheque
	 * 		   Metodo set del atributo lblNumeroCheque
	 * @param  pLblNumeroCheque
	 *		   Valor que tomara el atributo lblNumeroCheque
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setLblNumeroCheque(EtiquetaUtil pLblNumeroCheque) {
		this.lblNumeroCheque = pLblNumeroCheque;
	}

	/**
	 * @method getLblNumeroVale
	 * 		   Metodo get del atributo lblNumeroVale
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblNumeroVale devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public EtiquetaUtil getLblNumeroVale() {
		return this.lblNumeroVale;
	}

	/**
	 * @method setLblNumeroVale
	 * 		   Metodo set del atributo lblNumeroVale
	 * @param  pLblNumeroVale
	 *		   Valor que tomara el atributo lblNumeroVale
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setLblNumeroVale(EtiquetaUtil pLblNumeroVale) {
		this.lblNumeroVale = pLblNumeroVale;
	}

	/**
	 * @method getLblGiradorCheque
	 * 		   Metodo get del atributo lblGiradorCheque
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblGiradorCheque devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public EtiquetaUtil getLblGiradorCheque() {
		return this.lblGiradorCheque;
	}

	/**
	 * @method setLblGiradorCheque
	 * 		   Metodo set del atributo lblGiradorCheque
	 * @param  pLblGiradorCheque
	 *		   Valor que tomara el atributo lblGiradorCheque
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setLblGiradorCheque(EtiquetaUtil pLblGiradorCheque) {
		this.lblGiradorCheque = pLblGiradorCheque;
	}

	/**
	 * @method getLblConceptoVale
	 * 		   Metodo get del atributo lblConceptoVale
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblConceptoVale devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public EtiquetaUtil getLblConceptoVale() {
		return this.lblConceptoVale;
	}

	/**
	 * @method setLblConceptoVale
	 * 		   Metodo set del atributo lblConceptoVale
	 * @param  pLblConceptoVale
	 *		   Valor que tomara el atributo lblConceptoVale
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setLblConceptoVale(EtiquetaUtil pLblConceptoVale) {
		this.lblConceptoVale = pLblConceptoVale;
	}

	/**
	 * @method getLblNotas
	 * 		   Metodo get del atributo lblNotas
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblNotas devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public EtiquetaUtil getLblNotas() {
		return this.lblNotas;
	}

	/**
	 * @method setLblNotas
	 * 		   Metodo set del atributo lblNotas
	 * @param  pLblNotas
	 *		   Valor que tomara el atributo lblNotas
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setLblNotas(EtiquetaUtil pLblNotas) {
		this.lblNotas = pLblNotas;
	}

	/**
	 * @method getLblTotalCaja
	 * 		   Metodo get del atributo lblTotalCaja
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblTotalCaja devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public EtiquetaUtil getLblTotalCaja() {
		return this.lblTotalCaja;
	}

	/**
	 * @method setLblTotalCaja
	 * 		   Metodo set del atributo lblTotalCaja
	 * @param  pLblTotalCaja
	 *		   Valor que tomara el atributo lblTotalCaja
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setLblTotalCaja(EtiquetaUtil pLblTotalCaja) {
		this.lblTotalCaja = pLblTotalCaja;
	}

	/**
	 * @method getLblEnArqueo
	 * 		   Metodo get del atributo lblEnArqueo
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblEnArqueo devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public EtiquetaUtil getLblEnArqueo() {
		return this.lblEnArqueo;
	}

	/**
	 * @method setLblEnArqueo
	 * 		   Metodo set del atributo lblEnArqueo
	 * @param  pLblEnArqueo
	 *		   Valor que tomara el atributo lblEnArqueo
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setLblEnArqueo(EtiquetaUtil pLblEnArqueo) {
		this.lblEnArqueo = pLblEnArqueo;
	}

	/**
	 * @method getLblTotalDiferencia
	 * 		   Metodo get del atributo lblTotalDiferencia
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblTotalDiferencia devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public EtiquetaUtil getLblTotalDiferencia() {
		return this.lblTotalDiferencia;
	}

	/**
	 * @method setLblTotalDiferencia
	 * 		   Metodo set del atributo lblTotalDiferencia
	 * @param  pLblTotalDiferencia
	 *		   Valor que tomara el atributo lblTotalDiferencia
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setLblTotalDiferencia(EtiquetaUtil pLblTotalDiferencia) {
		this.lblTotalDiferencia = pLblTotalDiferencia;
	}

	/**
	 * @method getLblTotalXBilletes
	 * 		   Metodo get del atributo lblTotalXBilletes
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblTotalXBilletes devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public EtiquetaUtil getLblTotalXBilletes() {
		return this.lblTotalXBilletes;
	}

	/**
	 * @method setLblTotalXBilletes
	 * 		   Metodo set del atributo lblTotalXBilletes
	 * @param  pLblTotalXBilletes
	 *		   Valor que tomara el atributo lblTotalXBilletes
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setLblTotalXBilletes(EtiquetaUtil pLblTotalXBilletes) {
		this.lblTotalXBilletes = pLblTotalXBilletes;
	}

	/**
	 * @method getLblTotalXMonedas
	 * 		   Metodo get del atributo lblTotalXMonedas
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblTotalXMonedas devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public EtiquetaUtil getLblTotalXMonedas() {
		return this.lblTotalXMonedas;
	}

	/**
	 * @method setLblTotalXMonedas
	 * 		   Metodo set del atributo lblTotalXMonedas
	 * @param  pLblTotalXMonedas
	 *		   Valor que tomara el atributo lblTotalXMonedas
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setLblTotalXMonedas(EtiquetaUtil pLblTotalXMonedas) {
		this.lblTotalXMonedas = pLblTotalXMonedas;
	}

	/**
	 * @method getLblTotalXCheques
	 * 		   Metodo get del atributo lblTotalXCheques
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblTotalXCheques devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public EtiquetaUtil getLblTotalXCheques() {
		return this.lblTotalXCheques;
	}

	/**
	 * @method setLblTotalXCheques
	 * 		   Metodo set del atributo lblTotalXCheques
	 * @param  pLblTotalXCheques
	 *		   Valor que tomara el atributo lblTotalXCheques
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setLblTotalXCheques(EtiquetaUtil pLblTotalXCheques) {
		this.lblTotalXCheques = pLblTotalXCheques;
	}

	/**
	 * @method getLblTotalXVales
	 * 		   Metodo get del atributo lblTotalXVales
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblTotalXVales devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public EtiquetaUtil getLblTotalXVales() {
		return this.lblTotalXVales;
	}

	/**
	 * @method setLblTotalXVales
	 * 		   Metodo set del atributo lblTotalXVales
	 * @param  pLblTotalXVales
	 *		   Valor que tomara el atributo lblTotalXVales
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setLblTotalXVales(EtiquetaUtil pLblTotalXVales) {
		this.lblTotalXVales = pLblTotalXVales;
	}

	/**
	 * @method getDtcFechaCheque
	 * 		   Metodo get del atributo dtcFechaCheque
	 * @return CajaFechaUtil
	 *		   Valor del atributo dtcFechaCheque devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public CajaFechaUtil getDtcFechaCheque() {
		return this.dtcFechaCheque;
	}

	/**
	 * @method setDtcFechaCheque
	 * 		   Metodo set del atributo dtcFechaCheque
	 * @param  pDtcFechaCheque
	 *		   Valor que tomara el atributo dtcFechaCheque
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setDtcFechaCheque(CajaFechaUtil pDtcFechaCheque) {
		this.dtcFechaCheque = pDtcFechaCheque;
	}

	/**
	 * @method getDtcFechaVale
	 * 		   Metodo get del atributo dtcFechaVale
	 * @return CajaFechaUtil
	 *		   Valor del atributo dtcFechaVale devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public CajaFechaUtil getDtcFechaVale() {
		return this.dtcFechaVale;
	}

	/**
	 * @method setDtcFechaVale
	 * 		   Metodo set del atributo dtcFechaVale
	 * @param  pDtcFechaVale
	 *		   Valor que tomara el atributo dtcFechaVale
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setDtcFechaVale(CajaFechaUtil pDtcFechaVale) {
		this.dtcFechaVale = pDtcFechaVale;
	}

	/**
	 * @method getCmbListaBilletes
	 * 		   Metodo get del atributo cmbListaBilletes
	 * @return CajaComboUtil
	 *		   Valor del atributo cmbListaBilletes devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public CajaComboUtil getCmbListaBilletes() {
		return this.cmbListaBilletes;
	}

	/**
	 * @method setCmbListaBilletes
	 * 		   Metodo set del atributo cmbListaBilletes
	 * @param  pCmbListaBilletes
	 *		   Valor que tomara el atributo cmbListaBilletes
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setCmbListaBilletes(CajaComboUtil pCmbListaBilletes) {
		this.cmbListaBilletes = pCmbListaBilletes;
	}

	/**
	 * @method getCmbListaCheques
	 * 		   Metodo get del atributo cmbListaCheques
	 * @return CajaComboUtil
	 *		   Valor del atributo cmbListaCheques devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public CajaComboUtil getCmbListaCheques() {
		return this.cmbListaCheques;
	}

	/**
	 * @method setCmbListaCheques
	 * 		   Metodo set del atributo cmbListaCheques
	 * @param  pCmbListaCheques
	 *		   Valor que tomara el atributo cmbListaCheques
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setCmbListaCheques(CajaComboUtil pCmbListaCheques) {
		this.cmbListaCheques = pCmbListaCheques;
	}

	/**
	 * @method getCmbListaVales
	 * 		   Metodo get del atributo cmbListaVales
	 * @return CajaComboUtil
	 *		   Valor del atributo cmbListaVales devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public CajaComboUtil getCmbListaVales() {
		return this.cmbListaVales;
	}

	/**
	 * @method setCmbListaVales
	 * 		   Metodo set del atributo cmbListaVales
	 * @param  pCmbListaVales
	 *		   Valor que tomara el atributo cmbListaVales
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setCmbListaVales(CajaComboUtil pCmbListaVales) {
		this.cmbListaVales = pCmbListaVales;
	}

	/**
	 * @method getCmbListaMonedas
	 * 		   Metodo get del atributo cmbListaMonedas
	 * @return CajaComboUtil
	 *		   Valor del atributo cmbListaMonedas devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public CajaComboUtil getCmbListaMonedas() {
		return this.cmbListaMonedas;
	}

	/**
	 * @method setCmbListaMonedas
	 * 		   Metodo set del atributo cmbListaMonedas
	 * @param  pCmbListaMonedas
	 *		   Valor que tomara el atributo cmbListaMonedas
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setCmbListaMonedas(CajaComboUtil pCmbListaMonedas) {
		this.cmbListaMonedas = pCmbListaMonedas;
	}

	/**
	 * @method getTxtCantidadMontoBilletes
	 * 		   Metodo get del atributo txtCantidadMontoBilletes
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtCantidadMontoBilletes devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public CajaTextoUtil getTxtCantidadMontoBilletes() {
		return this.txtCantidadMontoBilletes;
	}

	/**
	 * @method setTxtCantidadMontoBilletes
	 * 		   Metodo set del atributo txtCantidadMontoBilletes
	 * @param  pTxtCantidadMontoBilletes
	 *		   Valor que tomara el atributo txtCantidadMontoBilletes
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setTxtCantidadMontoBilletes(CajaTextoUtil pTxtCantidadMontoBilletes) {
		this.txtCantidadMontoBilletes = pTxtCantidadMontoBilletes;
	}

	/**
	 * @method getTxtValorCheque
	 * 		   Metodo get del atributo txtValorCheque
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtValorCheque devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public CajaTextoUtil getTxtValorCheque() {
		return this.txtValorCheque;
	}

	/**
	 * @method setTxtValorCheque
	 * 		   Metodo set del atributo txtValorCheque
	 * @param  pTxtValorCheque
	 *		   Valor que tomara el atributo txtValorCheque
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setTxtValorCheque(CajaTextoUtil pTxtValorCheque) {
		this.txtValorCheque = pTxtValorCheque;
	}

	/**
	 * @method getTxtValorVale
	 * 		   Metodo get del atributo txtValorVale
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtValorVale devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public CajaTextoUtil getTxtValorVale() {
		return this.txtValorVale;
	}

	/**
	 * @method setTxtValorVale
	 * 		   Metodo set del atributo txtValorVale
	 * @param  pTxtValorVale
	 *		   Valor que tomara el atributo txtValorVale
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setTxtValorVale(CajaTextoUtil pTxtValorVale) {
		this.txtValorVale = pTxtValorVale;
	}

	/**
	 * @method getTxtBancoCheque
	 * 		   Metodo get del atributo txtBancoCheque
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtBancoCheque devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public CajaTextoUtil getTxtBancoCheque() {
		return this.txtBancoCheque;
	}

	/**
	 * @method setTxtBancoCheque
	 * 		   Metodo set del atributo txtBancoCheque
	 * @param  pTxtBancoCheque
	 *		   Valor que tomara el atributo txtBancoCheque
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setTxtBancoCheque(CajaTextoUtil pTxtBancoCheque) {
		this.txtBancoCheque = pTxtBancoCheque;
	}

	/**
	 * @method getTxtNumeroCheque
	 * 		   Metodo get del atributo txtNumeroCheque
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtNumeroCheque devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public CajaTextoUtil getTxtNumeroCheque() {
		return this.txtNumeroCheque;
	}

	/**
	 * @method setTxtNumeroCheque
	 * 		   Metodo set del atributo txtNumeroCheque
	 * @param  pTxtNumeroCheque
	 *		   Valor que tomara el atributo txtNumeroCheque
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setTxtNumeroCheque(CajaTextoUtil pTxtNumeroCheque) {
		this.txtNumeroCheque = pTxtNumeroCheque;
	}

	/**
	 * @method getTxtNumeroVale
	 * 		   Metodo get del atributo txtNumeroVale
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtNumeroVale devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public CajaTextoUtil getTxtNumeroVale() {
		return this.txtNumeroVale;
	}

	/**
	 * @method setTxtNumeroVale
	 * 		   Metodo set del atributo txtNumeroVale
	 * @param  pTxtNumeroVale
	 *		   Valor que tomara el atributo txtNumeroVale
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setTxtNumeroVale(CajaTextoUtil pTxtNumeroVale) {
		this.txtNumeroVale = pTxtNumeroVale;
	}

	/**
	 * @method getTxtGiradorCheque
	 * 		   Metodo get del atributo txtGiradorCheque
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtGiradorCheque devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public CajaTextoUtil getTxtGiradorCheque() {
		return this.txtGiradorCheque;
	}

	/**
	 * @method setTxtGiradorCheque
	 * 		   Metodo set del atributo txtGiradorCheque
	 * @param  pTxtGiradorCheque
	 *		   Valor que tomara el atributo txtGiradorCheque
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setTxtGiradorCheque(CajaTextoUtil pTxtGiradorCheque) {
		this.txtGiradorCheque = pTxtGiradorCheque;
	}

	/**
	 * @method getTxtConceptoVale
	 * 		   Metodo get del atributo txtConceptoVale
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtConceptoVale devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public CajaTextoUtil getTxtConceptoVale() {
		return this.txtConceptoVale;
	}

	/**
	 * @method setTxtConceptoVale
	 * 		   Metodo set del atributo txtConceptoVale
	 * @param  pTxtConceptoVale
	 *		   Valor que tomara el atributo txtConceptoVale
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setTxtConceptoVale(CajaTextoUtil pTxtConceptoVale) {
		this.txtConceptoVale = pTxtConceptoVale;
	}

	/**
	 * @method getTxtTotalCaja
	 * 		   Metodo get del atributo txtTotalCaja
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtTotalCaja devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public CajaTextoUtil getTxtTotalCaja() {
		return this.txtTotalCaja;
	}

	/**
	 * @method setTxtTotalCaja
	 * 		   Metodo set del atributo txtTotalCaja
	 * @param  pTxtTotalCaja
	 *		   Valor que tomara el atributo txtTotalCaja
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setTxtTotalCaja(CajaTextoUtil pTxtTotalCaja) {
		this.txtTotalCaja = pTxtTotalCaja;
	}

	/**
	 * @method getTxtEnArqueo
	 * 		   Metodo get del atributo txtEnArqueo
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtEnArqueo devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public CajaTextoUtil getTxtEnArqueo() {
		return this.txtEnArqueo;
	}

	/**
	 * @method setTxtEnArqueo
	 * 		   Metodo set del atributo txtEnArqueo
	 * @param  pTxtEnArqueo
	 *		   Valor que tomara el atributo txtEnArqueo
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setTxtEnArqueo(CajaTextoUtil pTxtEnArqueo) {
		this.txtEnArqueo = pTxtEnArqueo;
	}

	/**
	 * @method getTxtTotalDiferencia
	 * 		   Metodo get del atributo txtTotalDiferencia
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtTotalDiferencia devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public CajaTextoUtil getTxtTotalDiferencia() {
		return this.txtTotalDiferencia;
	}

	/**
	 * @method setTxtTotalDiferencia
	 * 		   Metodo set del atributo txtTotalDiferencia
	 * @param  pTxtTotalDiferencia
	 *		   Valor que tomara el atributo txtTotalDiferencia
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setTxtTotalDiferencia(CajaTextoUtil pTxtTotalDiferencia) {
		this.txtTotalDiferencia = pTxtTotalDiferencia;
	}

	/**
	 * @method getTxtTotalXBilletes
	 * 		   Metodo get del atributo txtTotalXBilletes
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtTotalXBilletes devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public CajaTextoUtil getTxtTotalXBilletes() {
		return this.txtTotalXBilletes;
	}

	/**
	 * @method setTxtTotalXBilletes
	 * 		   Metodo set del atributo txtTotalXBilletes
	 * @param  pTxtTotalXBilletes
	 *		   Valor que tomara el atributo txtTotalXBilletes
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setTxtTotalXBilletes(CajaTextoUtil pTxtTotalXBilletes) {
		this.txtTotalXBilletes = pTxtTotalXBilletes;
	}

	/**
	 * @method getTxtTotalXMonedas
	 * 		   Metodo get del atributo txtTotalXMonedas
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtTotalXMonedas devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public CajaTextoUtil getTxtTotalXMonedas() {
		return this.txtTotalXMonedas;
	}

	/**
	 * @method setTxtTotalXMonedas
	 * 		   Metodo set del atributo txtTotalXMonedas
	 * @param  pTxtTotalXMonedas
	 *		   Valor que tomara el atributo txtTotalXMonedas
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setTxtTotalXMonedas(CajaTextoUtil pTxtTotalXMonedas) {
		this.txtTotalXMonedas = pTxtTotalXMonedas;
	}

	/**
	 * @method getTxtTotalXCheques
	 * 		   Metodo get del atributo txtTotalXCheques
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtTotalXCheques devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public CajaTextoUtil getTxtTotalXCheques() {
		return this.txtTotalXCheques;
	}

	/**
	 * @method setTxtTotalXCheques
	 * 		   Metodo set del atributo txtTotalXCheques
	 * @param  pTxtTotalXCheques
	 *		   Valor que tomara el atributo txtTotalXCheques
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setTxtTotalXCheques(CajaTextoUtil pTxtTotalXCheques) {
		this.txtTotalXCheques = pTxtTotalXCheques;
	}

	/**
	 * @method getTxtTotalXVales
	 * 		   Metodo get del atributo txtTotalXVales
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtTotalXVales devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public CajaTextoUtil getTxtTotalXVales() {
		return this.txtTotalXVales;
	}

	/**
	 * @method setTxtTotalXVales
	 * 		   Metodo set del atributo txtTotalXVales
	 * @param  pTxtTotalXVales
	 *		   Valor que tomara el atributo txtTotalXVales
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setTxtTotalXVales(CajaTextoUtil pTxtTotalXVales) {
		this.txtTotalXVales = pTxtTotalXVales;
	}

	/**
	 * @method getTxtCantidadMontoMonedas
	 * 		   Metodo get del atributo txtCantidadMontoMonedas
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtCantidadMontoMonedas devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public CajaTextoUtil getTxtCantidadMontoMonedas() {
		return this.txtCantidadMontoMonedas;
	}

	/**
	 * @method setTxtCantidadMontoMonedas
	 * 		   Metodo set del atributo txtCantidadMontoMonedas
	 * @param  pTxtCantidadMontoMonedas
	 *		   Valor que tomara el atributo txtCantidadMontoMonedas
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setTxtCantidadMontoMonedas(CajaTextoUtil pTxtCantidadMontoMonedas) {
		this.txtCantidadMontoMonedas = pTxtCantidadMontoMonedas;
	}

	/**
	 * @method getTxaNotas
	 * 		   Metodo get del atributo txaNotas
	 * @return AreaTextoUtil
	 *		   Valor del atributo txaNotas devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public AreaTextoUtil getTxaNotas() {
		return this.txaNotas;
	}

	/**
	 * @method setTxaNotas
	 * 		   Metodo set del atributo txaNotas
	 * @param  pTxaNotas
	 *		   Valor que tomara el atributo txaNotas
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setTxaNotas(AreaTextoUtil pTxaNotas) {
		this.txaNotas = pTxaNotas;
	}

	/**
	 * @method getBtnIngresarCantidadMontoBilletes
	 * 		   Metodo get del atributo btnIngresarCantidadMontoBilletes
	 * @return BotonUtil
	 *		   Valor del atributo btnIngresarCantidadMontoBilletes devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public BotonUtil getBtnIngresarCantidadMontoBilletes() {
		return this.btnIngresarCantidadMontoBilletes;
	}

	/**
	 * @method setBtnIngresarCantidadMontoBilletes
	 * 		   Metodo set del atributo btnIngresarCantidadMontoBilletes
	 * @param  pBtnIngresarCantidadMontoBilletes
	 *		   Valor que tomara el atributo btnIngresarCantidadMontoBilletes
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setBtnIngresarCantidadMontoBilletes(
			BotonUtil pBtnIngresarCantidadMontoBilletes) {
		this.btnIngresarCantidadMontoBilletes = pBtnIngresarCantidadMontoBilletes;
	}

	/**
	 * @method getBtnIngresarCheque
	 * 		   Metodo get del atributo btnIngresarCheque
	 * @return BotonUtil
	 *		   Valor del atributo btnIngresarCheque devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public BotonUtil getBtnIngresarCheque() {
		return this.btnIngresarCheque;
	}

	/**
	 * @method setBtnIngresarCheque
	 * 		   Metodo set del atributo btnIngresarCheque
	 * @param  pBtnIngresarCheque
	 *		   Valor que tomara el atributo btnIngresarCheque
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setBtnIngresarCheque(BotonUtil pBtnIngresarCheque) {
		this.btnIngresarCheque = pBtnIngresarCheque;
	}

	/**
	 * @method getBtnIngresarVale
	 * 		   Metodo get del atributo btnIngresarVale
	 * @return BotonUtil
	 *		   Valor del atributo btnIngresarVale devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public BotonUtil getBtnIngresarVale() {
		return this.btnIngresarVale;
	}

	/**
	 * @method setBtnIngresarVale
	 * 		   Metodo set del atributo btnIngresarVale
	 * @param  pBtnIngresarVale
	 *		   Valor que tomara el atributo btnIngresarVale
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setBtnIngresarVale(BotonUtil pBtnIngresarVale) {
		this.btnIngresarVale = pBtnIngresarVale;
	}

	/**
	 * @method getBtnIngresarCantidadMontoMonedas
	 * 		   Metodo get del atributo btnIngresarCantidadMontoMonedas
	 * @return BotonUtil
	 *		   Valor del atributo btnIngresarCantidadMontoMonedas devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public BotonUtil getBtnIngresarCantidadMontoMonedas() {
		return this.btnIngresarCantidadMontoMonedas;
	}

	/**
	 * @method setBtnIngresarCantidadMontoMonedas
	 * 		   Metodo set del atributo btnIngresarCantidadMontoMonedas
	 * @param  pBtnIngresarCantidadMontoMonedas
	 *		   Valor que tomara el atributo btnIngresarCantidadMontoMonedas
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setBtnIngresarCantidadMontoMonedas(
			BotonUtil pBtnIngresarCantidadMontoMonedas) {
		this.btnIngresarCantidadMontoMonedas = pBtnIngresarCantidadMontoMonedas;
	}

	/**
	 * @method getBtnEliminarRegistroIngresadoBilletes
	 * 		   Metodo get del atributo btnEliminarRegistroIngresadoBilletes
	 * @return BotonUtil
	 *		   Valor del atributo btnEliminarRegistroIngresadoBilletes devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public BotonUtil getBtnEliminarRegistroIngresadoBilletes() {
		return this.btnEliminarRegistroIngresadoBilletes;
	}

	/**
	 * @method setBtnEliminarRegistroIngresadoBilletes
	 * 		   Metodo set del atributo btnEliminarRegistroIngresadoBilletes
	 * @param  pBtnEliminarRegistroIngresadoBilletes
	 *		   Valor que tomara el atributo btnEliminarRegistroIngresadoBilletes
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setBtnEliminarRegistroIngresadoBilletes(
			BotonUtil pBtnEliminarRegistroIngresadoBilletes) {
		this.btnEliminarRegistroIngresadoBilletes = pBtnEliminarRegistroIngresadoBilletes;
	}

	/**
	 * @method getBtnEliminarRegistroIngresadoCheques
	 * 		   Metodo get del atributo btnEliminarRegistroIngresadoCheques
	 * @return BotonUtil
	 *		   Valor del atributo btnEliminarRegistroIngresadoCheques devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public BotonUtil getBtnEliminarRegistroIngresadoCheques() {
		return this.btnEliminarRegistroIngresadoCheques;
	}

	/**
	 * @method setBtnEliminarRegistroIngresadoCheques
	 * 		   Metodo set del atributo btnEliminarRegistroIngresadoCheques
	 * @param  pBtnEliminarRegistroIngresadoCheques
	 *		   Valor que tomara el atributo btnEliminarRegistroIngresadoCheques
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setBtnEliminarRegistroIngresadoCheques(
			BotonUtil pBtnEliminarRegistroIngresadoCheques) {
		this.btnEliminarRegistroIngresadoCheques = pBtnEliminarRegistroIngresadoCheques;
	}

	/**
	 * @method getBtnEliminarRegistroIngresadoVales
	 * 		   Metodo get del atributo btnEliminarRegistroIngresadoVales
	 * @return BotonUtil
	 *		   Valor del atributo btnEliminarRegistroIngresadoVales devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public BotonUtil getBtnEliminarRegistroIngresadoVales() {
		return this.btnEliminarRegistroIngresadoVales;
	}

	/**
	 * @method setBtnEliminarRegistroIngresadoVales
	 * 		   Metodo set del atributo btnEliminarRegistroIngresadoVales
	 * @param  pBtnEliminarRegistroIngresadoVales
	 *		   Valor que tomara el atributo btnEliminarRegistroIngresadoVales
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setBtnEliminarRegistroIngresadoVales(
			BotonUtil pBtnEliminarRegistroIngresadoVales) {
		this.btnEliminarRegistroIngresadoVales = pBtnEliminarRegistroIngresadoVales;
	}

	/**
	 * @method getBtnEliminarRegistroIngresadoMonedas
	 * 		   Metodo get del atributo btnEliminarRegistroIngresadoMonedas
	 * @return BotonUtil
	 *		   Valor del atributo btnEliminarRegistroIngresadoMonedas devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public BotonUtil getBtnEliminarRegistroIngresadoMonedas() {
		return this.btnEliminarRegistroIngresadoMonedas;
	}

	/**
	 * @method setBtnEliminarRegistroIngresadoMonedas
	 * 		   Metodo set del atributo btnEliminarRegistroIngresadoMonedas
	 * @param  pBtnEliminarRegistroIngresadoMonedas
	 *		   Valor que tomara el atributo btnEliminarRegistroIngresadoMonedas
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setBtnEliminarRegistroIngresadoMonedas(
			BotonUtil pBtnEliminarRegistroIngresadoMonedas) {
		this.btnEliminarRegistroIngresadoMonedas = pBtnEliminarRegistroIngresadoMonedas;
	}

	/** 
	 * ********************************************************************
	 * @method 	main
	 * 		   	Metodo principal (main), para realizar una prueba de unidad
	 * 			de la forma
	 * @param 	args
	 * 			Cadena de argumentos demandada por el metodo principal (main)
	 * @author 	hector.cuenca
	 * @date   	23/11/2016
	 * *********************************************************************
	 */
	public static void main(String[] args) {

		JFrame jframe = null;

		try {

			jframe = TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaCierreCaja.class,
																			true, 
																			EnumDesplegarFormaConEventos.SI);
			new FormaCierreCaja(jframe, true);

		} catch (Exception e) {

			e.printStackTrace();
			Logger.getInstance().error(e.getMessage());

		}
	}
}

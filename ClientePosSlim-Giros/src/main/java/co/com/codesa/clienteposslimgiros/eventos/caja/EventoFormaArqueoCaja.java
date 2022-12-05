package co.com.codesa.clienteposslimgiros.eventos.caja;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Component;
import java.text.Format;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.List;
import javax.swing.table.TableColumn;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.IngresoXDenominacion;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumImpresiones;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.caja.FormaArqueoCaja;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.GrillaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaDatosAdicionales;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.vista.logica.GeneralGirosVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.caja.CajaVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Denominacion;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.caja.arqueo.InfoCierreCajaDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.caja.arqueo.IngresosXTipoDenominacionDTO;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.giros.EnumTiposDenominacion;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 13-abr-2015 
 * @clase EventoFormaArqueoCaja
 * 		  Clase encargada de controlar los eventos de la forma de  
 * 		  cierre de caja
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class EventoFormaArqueoCaja extends EventoAbstracto{
	
	private IngresosXTipoDenominacionDTO objDtoIngresosXBillete;
	private IngresosXTipoDenominacionDTO objDtoIngresosXMoneda;
	private IngresosXTipoDenominacionDTO objDtoIngresosXVale;
	private IngresosXTipoDenominacionDTO objDtoIngresosXCheque;
	
	private InfoCierreCajaDTO objInfoCierreCajaDTO;
	
	private double douTotalCaja;
	private double douTotalArqueo;
	private double douTotalFaltante;
	
	/**
  	 * ****************************************************************.
  	 * @metodo EventoFormaArqueoCaja
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de sus acciones
  	 * @param pForma 
  	 * 		  referencia a la GUI de la cual se estan controlando los 
  	 * 		  eventos
  	 * @param pObjInfoCierreCajaDTO
  	 * 		  objeto que contiene informacion adicional y requerida para 
  	 * 		  el proceso de cierre de caja
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EventoFormaArqueoCaja(FormaGenerica pForma,
								 InfoCierreCajaDTO pObjInfoCierreCajaDTO) throws Exception{
		
		super(pForma);
		
		this.douTotalCaja = super.getObjUsuario().getCaja().getDouTotalSaldoTesoreria();
		this.objInfoCierreCajaDTO = pObjInfoCierreCajaDTO;
		
		this.objDtoIngresosXBillete = new IngresosXTipoDenominacionDTO(EnumTiposDenominacion.BILLETE,new LinkedHashMap<String,IngresoXDenominacion>());
		this.objDtoIngresosXMoneda = new IngresosXTipoDenominacionDTO(EnumTiposDenominacion.MONEDA,new LinkedHashMap<String,IngresoXDenominacion>());
		this.objDtoIngresosXCheque = new IngresosXTipoDenominacionDTO(EnumTiposDenominacion.CHEQUE,new LinkedHashMap<String,IngresoXDenominacion>());
		this.objDtoIngresosXVale = new IngresosXTipoDenominacionDTO(EnumTiposDenominacion.VALE,new LinkedHashMap<String,IngresoXDenominacion>());
	}
	
	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma)throws Exception{
		
		this.cargarFormulario();
		this.configuracionCampos();
	}
	
	@Override
	public void accionarEjecucion(Component pComponent,
								  AWTEvent pEvtEjecucion)throws Exception{
		
		if(pComponent.equals(this.castFrmArqueoCaja().getBtnIngresarCantidadMontoBilletes())){
			
			this.ingresarMontoBilletes();
			
		}else if(pComponent.equals(this.castFrmArqueoCaja().getBtnIngresarCantidadMontoMonedas())){
			
			this.ingresarMontoMonedas();
			
		}else if(pComponent.equals(this.castFrmArqueoCaja().getBtnIngresarCheque())){
			
			this.ingresarCheque();
			
		}else if(pComponent.equals(this.castFrmArqueoCaja().getBtnIngresarVale())){
			
			this.ingresarVale();
			
		}else if(pComponent.equals(this.castFrmArqueoCaja().getBtnEliminarRegistroIngresadoBilletes())){
			
			this.eliminarIngresoBillete();
			
		}else if(pComponent.equals(this.castFrmArqueoCaja().getBtnEliminarRegistroIngresadoMonedas())){
			
			this.eliminarIngresoMoneda();
			
		}else if(pComponent.equals(this.castFrmArqueoCaja().getBtnEliminarRegistroIngresadoCheques())){
			
			this.eliminarIngresoCheque();
			
		}else if(pComponent.equals(this.castFrmArqueoCaja().getBtnEliminarRegistroIngresadoVales())){
			
			this.eliminarIngresoVale();
			
		}else{
			
			super.accionarEjecucion(pComponent,pEvtEjecucion);
		}
	}
	
	@Override
	public void confirmar() throws Exception{
		
		if(this.isBooFinalizoExitosoValores()){
			
			this.gestionarCierreCaja();
			
		}else{
			
			throw EnumMensajes.CARGUE_INCOMPLETO_NO_PERMITE_CONTINUAR_OPERACION.generarExcepcion(EnumClasesMensaje.ERROR);
		}
	}
	
	@Override
	public	void	limpiar	() 
			throws Exception 
	{
		super.limpiar();
		
		this.objDtoIngresosXBillete.limpiar();
		this.objDtoIngresosXMoneda.limpiar();
		this.objDtoIngresosXCheque.limpiar();
		this.objDtoIngresosXVale.limpiar();
		
		this.actualizarTotalSeccion();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo gestionarCierreCaja
  	 * 		   Metodo que se encarga de gestionar el cierre de caja, 
  	 * 		   validar y ejecutar
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void gestionarCierreCaja()throws Exception{
		
		this.validaCuadreRealizado(true);
		this.realizarCierreCaja();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo realizarCierreCaja
  	 * 		   Metodo que se encarga de realizar el cierre de caja
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void realizarCierreCaja()throws Exception{
		
		boolean booImprimio;
		
		CajaVistaLogica.getInstance().cerrarCaja(super.getObjUsuario(),
												 this.objDtoIngresosXBillete.getHmIngresosXDenominacion(),
												 this.objDtoIngresosXMoneda.getHmIngresosXDenominacion(),
												 this.objDtoIngresosXCheque.getHmIngresosXDenominacion(),
												 this.objDtoIngresosXVale.getHmIngresosXDenominacion(),
												 this.castFrmArqueoCaja().getTxaNotas().getText());
		
		GeneralGirosVistaLogica.getInstance().procesarPermisosMenu(false);
		
		booImprimio = this.generarImpresionCierreCaja();
		
		if(booImprimio){
		
			EnumMensajes.OPERACION_REALIZADA_CORRECTAMENTE.desplegarMensaje(super.getFrmForma(), 
																			EnumClasesMensaje.INFORMACION);
			
		}else{
			
			EnumMensajes.OPERACION_REALIZADA_CORRECTAMENTE_IMPRESION_ERROR.desplegarMensaje(super.getFrmForma(), 
																							EnumClasesMensaje.ADVERTENCIA);		
		}
		
		super.cerrarForma();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo cargarFormulario
  	 * 		   Metodo que se encarga de gestionar el cargue de la 
  	 * 		   informacion sobre el formulario
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void cargarFormulario()throws Exception{
		
		NumberFormat frtFormato;
		
		this.cargarComboDenominaciones(this.castFrmArqueoCaja().getCmbListaBilletes(),
									   EnumTiposDenominacion.BILLETE);
		
		this.cargarComboDenominaciones(this.castFrmArqueoCaja().getCmbListaMonedas(),
									   EnumTiposDenominacion.MONEDA);
		
		this.cargarComboDenominaciones(this.castFrmArqueoCaja().getCmbListaCheques(),
									   EnumTiposDenominacion.CHEQUE);
		
		this.cargarComboDenominaciones(this.castFrmArqueoCaja().getCmbListaVales(),
									   EnumTiposDenominacion.VALE);
		
		frtFormato = UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO();
		
		this.castFrmArqueoCaja().getTxtTotalCaja().setText(frtFormato.format(this.douTotalCaja));
		this.douTotalCaja = frtFormato.parse(this.castFrmArqueoCaja().getTxtTotalCaja().getText()).doubleValue();
		
		this.actualizarTotalXSeccion(EnumTiposDenominacion.BILLETE);
		this.actualizarTotalXSeccion(EnumTiposDenominacion.MONEDA);
		this.actualizarTotalXSeccion(EnumTiposDenominacion.CHEQUE);
		this.actualizarTotalXSeccion(EnumTiposDenominacion.VALE);
		
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo cargarComboDenominaciones
  	 * 		   metodo general que permite cargar la lista de valores 
  	 * 		   de los diferentes tipos de denominacion
  	 * @param pComboDenominacion
  	 * 		  lista de valores (combo), sobre la cual se cargara la 
  	 * 		  informacion
  	 * @param pStrCodigoDenominacion
  	 * 		  codigo representativo del tipo de denominacion
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void cargarComboDenominaciones(CajaComboUtil pComboDenominacion,
			   							   EnumTiposDenominacion pEnmTipoDenominacion)throws Exception{

		List<Denominacion> lstDenominacion;
		
		lstDenominacion = super.getObjUsuario().getCaja().obtenerDenominacionXTipo(pEnmTipoDenominacion);

		pComboDenominacion.getPropiedades().cargarCombo(lstDenominacion.toArray(), 
					 							 	    true,
					 							 	    null);
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo configuracionCampos
  	 * 		   encargado de gestionar la configuracion personalizada
  	 * 		   para los campos del formulario
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void configuracionCampos()throws Exception{
		this.configuracionCamposTexto();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo configuracionCamposTexto
  	 * 		   encargado de gestionar la configuracion personalizada
  	 * 		   para los diferentes campos de texto del formulario
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void configuracionCamposTexto()throws Exception{
		
		this.castFrmArqueoCaja().getTxtCantidadMontoBilletes().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_AQC_CANTIDAD_MONTO_BILLETES.getValor());
		this.castFrmArqueoCaja().getTxtCantidadMontoMonedas().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_AQC_CANTIDAD_MONTO_MONEDAS.getValor());
		
		this.configuracionCamposTextoSeccionCheque();
		this.configuracionCamposTextoSeccionVale();
		
		this.castFrmArqueoCaja().getTxaNotas().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_AQC_NOTAS_ARQUEO.getValor());
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo configuracionCamposTextoSeccionCheque
  	 * 		   encargado de gestionar la configuracion personalizada
  	 * 		   para los diferentes campos de texto del formulario para
  	 * 		   la seccion cheque
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void configuracionCamposTextoSeccionCheque()throws Exception{
		
		this.castFrmArqueoCaja().getTxtValorCheque().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_DINERO.getValor());
		this.castFrmArqueoCaja().getTxtValorCheque().getPropiedades().setFormatoSalida(UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO());
		
		this.castFrmArqueoCaja().iniciarPropTxtBancoCheque().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_AQC_BANCO_CHEQUE.getValor());
		
		this.castFrmArqueoCaja().iniciarPropTxtNumeroCheque().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_AQC_NUMERO_CHEQUE.getValor());
		
		this.castFrmArqueoCaja().iniciarPropTxtGiradorCheque().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_AQC_GIRADOR_CHEQUE.getValor());
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo configuracionCamposTextoSeccionVale
  	 * 		   encargado de gestionar la configuracion personalizada
  	 * 		   para los diferentes campos de texto del formulario para
  	 * 		   la seccion vale
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void configuracionCamposTextoSeccionVale()throws Exception{
		
		this.castFrmArqueoCaja().getTxtValorVale().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_DINERO.getValor());
		this.castFrmArqueoCaja().getTxtValorVale().getPropiedades().setFormatoSalida(UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO());
		
		this.castFrmArqueoCaja().iniciarPropTxtNumeroVale().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_AQC_NUMERO_VALE.getValor());

		this.castFrmArqueoCaja().iniciarPropTxtConceptoVale().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_AQC_CONCEPTO_VALE.getValor());
	}

	/*@Override
	public void validaDatosAdicionales(JPanel pnlSeccionAdicional)throws Exception{
		
		if(pnlSeccionAdicional.equals(this.castFrmArqueoCaja().getPnlDatAdiCheque())){
			
			UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmArqueoCaja().getDtcFechaCheque(), 
																	EnumEtiquetas.LBL_AQC_FECHA_CHEQUE.toString(), 
																	true,
																	true);
			
			UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmArqueoCaja().getTxtBancoCheque(), 
																	EnumEtiquetas.LBL_AQC_BANCO_CHEQUE.toString(), 
																	true,
																	true);
			
			UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmArqueoCaja().getTxtNumeroCheque(), 
																	EnumEtiquetas.LBL_AQC_NUMERO_CHEQUE.toString(), 
																	true,
																	true);
			
			UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmArqueoCaja().getTxtGiradorCheque(), 
																	EnumEtiquetas.LBL_AQC_GIRADOR_CHEQUE.toString(), 
																	true,
																	true);
			
		}else if(pnlSeccionAdicional.equals(this.castFrmArqueoCaja().getPnlDatAdiVale())){
			
			UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmArqueoCaja().getDtcFechaVale(), 
																	EnumEtiquetas.LBL_AQC_FECHA_VALE.toString(), 
																	true,
																	true);
			
			UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmArqueoCaja().getTxtNumeroVale(), 
																	EnumEtiquetas.LBL_AQC_NUMERO_VALE.toString(), 
																	true,
																	true);
			
			UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmArqueoCaja().getTxtConceptoVale(), 
																	EnumEtiquetas.LBL_AQC_CONCEPTO_VALE.toString(), 
																	true,
																	true);
		}
	}*/
	
	/**
  	 * ****************************************************************.
  	 * @metodo ingresarMontoBilletes
  	 * 		   Permite realizar el proceso de ingreso bajo la  denominacion 
  	 * 		   de billetes, solicitando las validaciones propias que 
  	 * 		   demanda el ingreso, asi como actualizar el valor total
  	 * 		   de la seccion
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void ingresarMontoBilletes()throws Exception{
		
		IngresoXDenominacion objIngresoXDenominacion;
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmArqueoCaja().getCmbListaBilletes(), 
																this.castFrmArqueoCaja().getLblListaBilletes().getTextoOriginal(), 
																true,
																true);
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmArqueoCaja().getTxtCantidadMontoBilletes(), 
																this.castFrmArqueoCaja().getLblCantidadMontoBilletes().getTextoOriginal(), 
																true,
																true);
		
		objIngresoXDenominacion = new IngresoXDenominacion((Denominacion)this.castFrmArqueoCaja().getCmbListaBilletes().getSelectedItem(),
															Integer.parseInt(this.castFrmArqueoCaja().getTxtCantidadMontoBilletes().getText())); 
		
		this.cargarIngresoDenominacion(this.objDtoIngresosXBillete,
				  					   this.castFrmArqueoCaja().getTblDenominacionBilletes(),
				  					   objIngresoXDenominacion);
		
		this.actualizarTotalXSeccion(EnumTiposDenominacion.BILLETE);
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo ingresarMontoMonedas
  	 * 		   Permite realizar el proceso de ingreso bajo la  denominacion 
  	 * 		   de monedas, solicitando las validaciones propias que 
  	 * 		   demanda el ingreso, asi como actualizar el valor total
  	 * 		   de la seccion
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void ingresarMontoMonedas()throws Exception{
		
		IngresoXDenominacion objIngresoXDenominacion;
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmArqueoCaja().getCmbListaMonedas(), 
																this.castFrmArqueoCaja().getLblListaMonedas().getTextoOriginal(), 
																true,
																true);

		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmArqueoCaja().getTxtCantidadMontoMonedas(), 
																this.castFrmArqueoCaja().getLblCantidadMontoMonedas().getTextoOriginal(), 
																true,
																true);
		
		objIngresoXDenominacion = new IngresoXDenominacion((Denominacion)this.castFrmArqueoCaja().getCmbListaMonedas().getSelectedItem(),
														   Integer.parseInt(this.castFrmArqueoCaja().getTxtCantidadMontoMonedas().getText())); 
		
		this.cargarIngresoDenominacion(this.objDtoIngresosXMoneda,
				  					   this.castFrmArqueoCaja().getTblDenominacionMonedas(),
				  					   objIngresoXDenominacion);
		
		this.actualizarTotalXSeccion(EnumTiposDenominacion.MONEDA);
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo ingresarCheque
  	 * 		   Permite realizar el proceso de ingreso bajo la  denominacion 
  	 * 		   de cheques, solicitando las validaciones propias que 
  	 * 		   demanda el ingreso, asi como actualizar el valor total
  	 * 		   de la seccion
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void ingresarCheque()throws Exception{
		
		FormaDatosAdicionales objFormaDatosAdicionales;
		IngresoXDenominacion objIngresoXDenominacion;
		NumberFormat frtFormato;
		double douValorCheque;
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmArqueoCaja().getCmbListaCheques(), 
																EnumEtiquetas.LBL_AQC_LISTA_CHEQUES.toString(), 
																true,
																true);
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmArqueoCaja().getTxtValorCheque(), 
																EnumEtiquetas.LBL_AQC_VALOR_CHEQUE.toString(), 
																true,
																true);
		
		frtFormato = UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO();
		
		douValorCheque = frtFormato.parse(this.castFrmArqueoCaja().getTxtValorCheque().getText()).doubleValue();
		
		if(douValorCheque<=0){
			
			throw EnumMensajes.VALOR_NO_VALIDO_PARA_CAMPO.generarExcepcion(EnumClasesMensaje.ERROR,
																	 EnumEtiquetas.LBL_AQC_VALOR_CHEQUE.toString());
		}
		
		objFormaDatosAdicionales = new FormaDatosAdicionales(super.getFrmForma(), 
				  				  							 true, 
				  				  							 this.castFrmArqueoCaja().iniciarPropPnlDatAdiCheque());
		
		if(objFormaDatosAdicionales.getEnmBotEncAccionSolicitada().equals(EnumBotonesEncabezado.BTNGUARDAR)){
			
			objIngresoXDenominacion = new IngresoXDenominacion((Denominacion)this.castFrmArqueoCaja().getCmbListaCheques().getSelectedItem(),
															   douValorCheque,
															   this.castFrmArqueoCaja().getDtcFechaCheque().toString(),
															   this.castFrmArqueoCaja().getTxtNumeroCheque().getText(),
															   this.castFrmArqueoCaja().getTxtGiradorCheque().getText(),
															   this.castFrmArqueoCaja().getTxtBancoCheque().getText());

			this.cargarIngresoDenominacion(this.objDtoIngresosXCheque,
										   this.castFrmArqueoCaja().getTblCheques(),
										   objIngresoXDenominacion);
			
			this.actualizarTotalXSeccion(EnumTiposDenominacion.CHEQUE);
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo ingresarVale
  	 * 		   Permite realizar el proceso de ingreso bajo la  denominacion 
  	 * 		   de vales, solicitando las validaciones propias que 
  	 * 		   demanda el ingreso, asi como actualizar el valor total
  	 * 		   de la seccion
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void ingresarVale()throws Exception{
		
		FormaDatosAdicionales objFormaDatosAdicionales;
		IngresoXDenominacion objIngresoXDenominacion;
		NumberFormat frtFormato;
		double douValorVale;
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmArqueoCaja().getCmbListaVales(), 
																EnumEtiquetas.LBL_AQC_LISTA_VALES.toString(), 
																true,
																true);

		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmArqueoCaja().getTxtValorVale(), 
																EnumEtiquetas.LBL_AQC_VALOR_VALE.toString(), 
																true,
																true);
		
		frtFormato = UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO();
		
		douValorVale = frtFormato.parse(this.castFrmArqueoCaja().getTxtValorVale().getText()).doubleValue();
		
		if(douValorVale<=0){
			
			throw EnumMensajes.VALOR_NO_VALIDO_PARA_CAMPO.generarExcepcion(EnumClasesMensaje.ERROR, 
																	 EnumEtiquetas.LBL_AQC_VALOR_VALE.toString());
		}
		
		objFormaDatosAdicionales = new FormaDatosAdicionales(super.getFrmForma(), 
				  				  							 true, 
				  				  							 this.castFrmArqueoCaja().iniciarPropPnlDatAdiVale());
		
		if(objFormaDatosAdicionales.getEnmBotEncAccionSolicitada().equals(EnumBotonesEncabezado.BTNGUARDAR)){
			
			objIngresoXDenominacion = new IngresoXDenominacion((Denominacion)this.castFrmArqueoCaja().getCmbListaVales().getSelectedItem(),
															   douValorVale,
															   this.castFrmArqueoCaja().getDtcFechaVale().toString(),
															   this.castFrmArqueoCaja().getTxtNumeroVale().getText(),
															   this.castFrmArqueoCaja().getTxtConceptoVale().getText());
			
			this.cargarIngresoDenominacion(this.objDtoIngresosXVale,
		   								   this.castFrmArqueoCaja().getTblVales(),
		   								   objIngresoXDenominacion);
			
			this.actualizarTotalXSeccion(EnumTiposDenominacion.VALE);
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	actualizarTotalSeccion
	 * 		   	Metodo que permite actualizar el total de todas las secciones
	 * 			de arqueo
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	13/06/2017
	 * *********************************************************************
	 */
	private	void	actualizarTotalSeccion	()
			throws Exception
	{
		Format frtFormato;
		
		frtFormato = UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO();
		
		this.castFrmArqueoCaja().getTxtTotalXBilletes().setText(frtFormato.format(this.objDtoIngresosXBillete.getDouTotalAportado()));
		this.castFrmArqueoCaja().getTxtTotalXMonedas().setText(frtFormato.format(this.objDtoIngresosXMoneda.getDouTotalAportado()));
		this.castFrmArqueoCaja().getTxtTotalXCheques().setText(frtFormato.format(this.objDtoIngresosXCheque.getDouTotalAportado()));
		this.castFrmArqueoCaja().getTxtTotalXVales().setText(frtFormato.format(this.objDtoIngresosXVale.getDouTotalAportado()));
		
		this.actualizarTotalesCuadre();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo actualizarTotalXSeccion
  	 * 		   metodo que permite actualizar el total x seccion
  	 * @param pEnmPapTipoIngreso
  	 * 		  constante de enumerador que identifica el tipo de ingreso
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void actualizarTotalXSeccion(EnumTiposDenominacion pEnmPapTipoIngreso)throws Exception{
		
		Format frtFormato;
		
		frtFormato = UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO();
		
		switch (pEnmPapTipoIngreso) {
		
			case BILLETE:
				
				this.castFrmArqueoCaja().getTxtTotalXBilletes().setText(frtFormato.format(this.objDtoIngresosXBillete.getDouTotalAportado()));
				break;
	
			case MONEDA:
				
				this.castFrmArqueoCaja().getTxtTotalXMonedas().setText(frtFormato.format(this.objDtoIngresosXMoneda.getDouTotalAportado()));
				break;
			
			case CHEQUE:
				
				this.castFrmArqueoCaja().getTxtTotalXCheques().setText(frtFormato.format(this.objDtoIngresosXCheque.getDouTotalAportado()));
				break;
			
			case VALE:
				
				this.castFrmArqueoCaja().getTxtTotalXVales().setText(frtFormato.format(this.objDtoIngresosXVale.getDouTotalAportado()));
				break;
				
			default:
				break;
		}
		
		this.actualizarTotalesCuadre();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo actualizarTotalesCuadre
  	 * 		   metodo que permite actualizar el total en el cuadre, 
  	 * 		   teniendo en cuenta los totales ingresados en cada seccion
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void actualizarTotalesCuadre()throws Exception{
		
		Format frtFormato;
		
		frtFormato = UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO();
		
		this.douTotalArqueo = this.objDtoIngresosXBillete.getDouTotalAportado()+
							  this.objDtoIngresosXCheque.getDouTotalAportado()+
							  this.objDtoIngresosXMoneda.getDouTotalAportado()+
							  this.objDtoIngresosXVale.getDouTotalAportado();
		
		this.douTotalFaltante = this.douTotalCaja-douTotalArqueo;
		
		this.castFrmArqueoCaja().getTxtEnArqueo().setText(frtFormato.format(this.douTotalArqueo));
		this.castFrmArqueoCaja().getTxtTotalDiferencia().setText(frtFormato.format(Math.abs(this.douTotalFaltante)));
		
		this.validaCuadreRealizado(false);
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo cargarIngresoDenominacion
  	 * 		   metodo general que permite cargar el ingreso efectuado
  	 * 		   sobre la seccion que se especifica 
  	 * @param pLstIdRegistrosCargados
  	 * 		  listado especifico de la denominacion, de ids de registros 
  	 * 		  que ya fueron cargados, por motivos de validacion que 	
  	 * 		  garantizan que el registro sea unico
  	 * @param pTblGrilla
  	 * 		  tabla sobre la cual se efectuara el ingreso, segun el tipo
  	 * 		  de ingreso
  	 * @param pDouTotalXGrilla
  	 * 		  valor total que de momento tiene la seccion sobre la cual se 
  	 * 		  realizara el nuevo ingreso, para motivos de incremento
  	 * @param pObjIngresoXDenominacion
  	 * 		  objeto DTO, que represente generalmente cualquiera de los
  	 * 		  tipos de ingreso, representando a los objetos: IngresoVale, 
  	 * 		  IngresoCheque e IngresoDinero (represente al ingreso x billetes
  	 * 		  o monedas)
  	 * @return double
  	 * 		   devuelve el valor incrementado despues de completarse el 
  	 * 		   acertadamente el ingreso
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void cargarIngresoDenominacion(IngresosXTipoDenominacionDTO pObjDtoIngresosXTipoDenominacion,
										   GrillaUtil pTblGrilla,
										   IngresoXDenominacion pObjIngresoXDenominacion)throws Exception{
		Object arrObjFilaIngreso[];
		
		arrObjFilaIngreso = this.obtenerFilaIngreso(pObjIngresoXDenominacion);
		
		if(pObjDtoIngresosXTipoDenominacion.getHmIngresosXDenominacion().containsKey(pObjIngresoXDenominacion.getIdRegistro())){
			
			throw EnumMensajes.EXISTE_DENOMINACION_CARGADA_DEL_MISMO_TIPO.generarExcepcion(EnumClasesMensaje.ERROR, 
																					 	   pObjIngresoXDenominacion.getDenominacion().getDescripcion());
		}else{
			
			pTblGrilla.getPropiedades().adicionarFilaGrilla(arrObjFilaIngreso);
			
			pObjDtoIngresosXTipoDenominacion.adicionarIngreso(pObjIngresoXDenominacion);
			
			this.restablecerSeccion(pObjIngresoXDenominacion);
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo obtenerFilaIngreso
  	 * 		   metodo general que permite obtener la fila que se registrara
  	 * 		   sobre la grilla especifica segun el tipo de ingreso
  	 * @param pObjIngresoXDenominacion
  	 * 		  objeto DTO, que representa generalmente cualquiera de los
  	 * 		  tipos de ingreso, representando a los objetos: IngresoVale, 
  	 * 		  IngresoCheque e IngresoDinero (represente al ingreso x billetes
  	 * 		  o monedas)
  	 * @return Object[]
  	 * 		   devuelve la fila generada segun el tipo de ingreso efectuado
  	 * 		   para proceder a cargar en la grillla especifica
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private Object[] obtenerFilaIngreso(IngresoXDenominacion pObjIngresoXDenominacion)throws Exception{
		
		Object arrObjFilaIngreso[]=null;
		
		if(EnumTiposDenominacion.BILLETE.equals(pObjIngresoXDenominacion.getDenominacion().getTipo())
				||EnumTiposDenominacion.MONEDA.equals(pObjIngresoXDenominacion.getDenominacion().getTipo())){
			
			arrObjFilaIngreso = new Object[]{pObjIngresoXDenominacion.getDenominacion().getDescripcion(),
											 pObjIngresoXDenominacion.getValorIngresado(),
											 pObjIngresoXDenominacion.getValorAportado()};
			
		}else if(EnumTiposDenominacion.CHEQUE.equals(pObjIngresoXDenominacion.getDenominacion().getTipo())){
				
			arrObjFilaIngreso = new Object[]{pObjIngresoXDenominacion.getBanco(),
											 pObjIngresoXDenominacion.getNumero(),
											 pObjIngresoXDenominacion.getConceptoGirador(),
											 pObjIngresoXDenominacion.getValorAportado()};
				
		}else if(EnumTiposDenominacion.VALE.equals(pObjIngresoXDenominacion.getDenominacion().getTipo())){
			
			arrObjFilaIngreso = new Object[]{pObjIngresoXDenominacion.getFecha(),
											 pObjIngresoXDenominacion.getNumero(),
											 pObjIngresoXDenominacion.getConceptoGirador(),
											 pObjIngresoXDenominacion.getValorAportado()};
		}
		
		return arrObjFilaIngreso;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo restablecerSeccion
  	 * 		   metodo general que permite restablecer la seccion de la 
  	 * 		   cual se produjo el ingreso satisfactoriamente
  	 * @param pObjIngresoXDenominacion
  	 * 		  objeto DTO, que representa generalmente cualquiera de los
  	 * 		  tipos de ingreso, representando a los objetos: IngresoVale, 
  	 * 		  IngresoCheque e IngresoDinero (represente al ingreso x billetes
  	 * 		  o monedas)
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void restablecerSeccion(IngresoXDenominacion pObjIngresoXDenominacion)throws Exception{
		
		if(EnumTiposDenominacion.BILLETE.equals(pObjIngresoXDenominacion.getDenominacion().getTipo())){
			
			UtilComponentesGUI.getInstance().restablecerComponentes(this.castFrmArqueoCaja().getTxtCantidadMontoBilletes(),
																	this.castFrmArqueoCaja().getCmbListaBilletes());
			
		}else if(EnumTiposDenominacion.MONEDA.equals(pObjIngresoXDenominacion.getDenominacion().getTipo())){
			
			UtilComponentesGUI.getInstance().restablecerComponentes(this.castFrmArqueoCaja().getTxtCantidadMontoMonedas(),
																	this.castFrmArqueoCaja().getCmbListaMonedas());
			
		}else if(EnumTiposDenominacion.CHEQUE.equals(pObjIngresoXDenominacion.getDenominacion().getTipo())){
			
			UtilComponentesGUI.getInstance().restablecerComponentes(this.castFrmArqueoCaja().getTxtValorCheque(),
																	this.castFrmArqueoCaja().getTxtBancoCheque(),
																	this.castFrmArqueoCaja().getTxtNumeroCheque(),
																	this.castFrmArqueoCaja().getTxtGiradorCheque(),
																	this.castFrmArqueoCaja().getDtcFechaCheque(),
																	this.castFrmArqueoCaja().getCmbListaCheques());
			
		}else if(EnumTiposDenominacion.VALE.equals(pObjIngresoXDenominacion.getDenominacion().getTipo())){
			
			UtilComponentesGUI.getInstance().restablecerComponentes(this.castFrmArqueoCaja().getTxtValorVale(),
																	this.castFrmArqueoCaja().getTxtNumeroVale(),
																	this.castFrmArqueoCaja().getTxtConceptoVale(),
																	this.castFrmArqueoCaja().getDtcFechaVale(),
																	this.castFrmArqueoCaja().getCmbListaVales());
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo eliminarIngresoBillete
  	 * 		   metodo que permite eliminar un ingreso especifico 
  	 * 		   registrado por la seccion de billetes
  	 * @param pEnmPapTipoIngreso
  	 * 		  constante de enumerador que identifica el tipo de ingreso
  	 * @param pTblGrillaSeccion
  	 * 		  grilla sobre la cual se realizara el proceso de eliminacion
  	 * 		  de ingreso
  	 * @param pLstIdRegistrosCargados
  	 * 		  lista de registros cargados, referentes al tipo de ingreso
  	 * 		  del cual se realizara el proceso de eliminacion
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void eliminarIngresoXSeccion(EnumTiposDenominacion pEnmTipoIngreso,
										   GrillaUtil pTblGrillaSeccion,
										   IngresosXTipoDenominacionDTO pObjDtoIngresosXTipoDenominacion)throws Exception {
		TableColumn columna;
		String strIdRegistroFilaGrilla;
		int intFilaSeleccionada;

		
		if(pTblGrillaSeccion.getRowCount()>0){
			
			intFilaSeleccionada = pTblGrillaSeccion.getSelectedRow();
			
			if (intFilaSeleccionada > -1) {

				switch (pEnmTipoIngreso) {
				
					case BILLETE:
						
						columna = pTblGrillaSeccion.getColumn(EnumEtiquetas.TTL_AQC_GRILLA_BILLETES_DENOMINACION.toString());
						strIdRegistroFilaGrilla = pTblGrillaSeccion.getValueAt(intFilaSeleccionada, columna.getModelIndex()).toString();
						break;
		
					case MONEDA:
						
						columna = pTblGrillaSeccion.getColumn(EnumEtiquetas.TTL_AQC_GRILLA_MONEDAS_DENOMINACION.toString());
						strIdRegistroFilaGrilla = pTblGrillaSeccion.getValueAt(intFilaSeleccionada, columna.getModelIndex()).toString();
						break;
						
					case CHEQUE:
						
						columna = pTblGrillaSeccion.getColumn(EnumEtiquetas.TTL_AQC_GRILLA_CHEQUES_BANCO.toString());
						strIdRegistroFilaGrilla = (pTblGrillaSeccion.getValueAt(intFilaSeleccionada, columna.getModelIndex())).toString().trim().toUpperCase();
						
						columna = pTblGrillaSeccion.getColumn(EnumEtiquetas.TTL_AQC_GRILLA_CHEQUES_NUMERO.toString());
						strIdRegistroFilaGrilla += (pTblGrillaSeccion.getValueAt(intFilaSeleccionada, columna.getModelIndex())).toString().trim().toUpperCase();
						break;
					
					case VALE:
						
						columna = pTblGrillaSeccion.getColumn(EnumEtiquetas.TTL_AQC_GRILLA_VALES_NUMERO.toString());
						strIdRegistroFilaGrilla = pTblGrillaSeccion.getValueAt(intFilaSeleccionada, columna.getModelIndex()).toString();
						break;
						
					default:
						strIdRegistroFilaGrilla = null;
						break;
				}

				if (strIdRegistroFilaGrilla != null
						&& !strIdRegistroFilaGrilla.trim().isEmpty()) {

					pTblGrillaSeccion.getPropiedades().removerFilaGrilla(intFilaSeleccionada);
					pObjDtoIngresosXTipoDenominacion.eliminarIngreso(strIdRegistroFilaGrilla);
				}
				
			}else{
				
				throw EnumMensajes.DEBE_SELECCIONAR_REGISTRO_PARA_OPERACION.generarExcepcion(EnumClasesMensaje.ERROR);
			}
		
		} else {
			
			throw EnumMensajes.SE_NECESITAN_REGISTROS_EN_TABLA.generarExcepcion(EnumClasesMensaje.ERROR);
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo eliminarIngresoBillete
  	 * 		   metodo que permite eliminar un ingreso especifico 
  	 * 		   registrado por la seccion de billetes
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void eliminarIngresoBillete()throws Exception{
		
		this.eliminarIngresoXSeccion(EnumTiposDenominacion.BILLETE,
									 this.castFrmArqueoCaja().getTblDenominacionBilletes(),
									 this.objDtoIngresosXBillete);
		
		this.actualizarTotalXSeccion(EnumTiposDenominacion.BILLETE);
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo eliminarIngresoMoneda
  	 * 		   metodo que permite eliminar un ingreso especifico 
  	 * 		   registrado por la seccion de monedas
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void eliminarIngresoMoneda()throws Exception{
		
		this.eliminarIngresoXSeccion(EnumTiposDenominacion.MONEDA,
		 							 this.castFrmArqueoCaja().getTblDenominacionMonedas(),
		 							 this.objDtoIngresosXMoneda);
		
		this.actualizarTotalXSeccion(EnumTiposDenominacion.MONEDA);
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo eliminarIngresoCheque
  	 * 		   metodo que permite eliminar un ingreso especifico 
  	 * 		   registrado por la seccion de cheques
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void eliminarIngresoCheque()throws Exception{
		
		this.eliminarIngresoXSeccion(EnumTiposDenominacion.CHEQUE,
		 							 this.castFrmArqueoCaja().getTblCheques(),
		 							 this.objDtoIngresosXCheque);
		
		this.actualizarTotalXSeccion(EnumTiposDenominacion.CHEQUE);
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo eliminarIngresoVale
  	 * 		   metodo que permite eliminar un ingreso especifico 
  	 * 		   registrado por la seccion de vales
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void eliminarIngresoVale()throws Exception{
		
		this.eliminarIngresoXSeccion(EnumTiposDenominacion.VALE,
		 							 this.castFrmArqueoCaja().getTblVales(),
		 							 this.objDtoIngresosXVale);
		
		this.actualizarTotalXSeccion(EnumTiposDenominacion.VALE);
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo validaCuadreRealizado
  	 * 		   metodo que permite validar si el cuadre de caja ha sido
  	 * 		   correctamente diligenciado
  	 * @param booActivarExcepcion
  	 * 		  bandera que permite una vez realizada la validacion del 
  	 * 		  cuadre generar o no una excepcion siempre y cuando este 
  	 * 		  sea inconsistente 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void validaCuadreRealizado(boolean booActivarExcepcion)throws Exception{
		
		if(this.douTotalArqueo != this.douTotalCaja){
			
			if(this.douTotalArqueo>this.douTotalCaja){
				
				this.castFrmArqueoCaja().getLblTotalDiferencia().setText(EnumEtiquetas.LBL_AQC_TOTAL_DIFERENCIA_SOBRANTE.getValor(true));
				this.castFrmArqueoCaja().getTxtTotalDiferencia().setForeground(Color.blue);
			}else{
				this.castFrmArqueoCaja().getLblTotalDiferencia().setText(EnumEtiquetas.LBL_AQC_TOTAL_DIFERENCIA_FALTANTE.getValor(true));
				this.castFrmArqueoCaja().getTxtTotalDiferencia().setForeground(Color.red);
			}
			
			if(booActivarExcepcion){
				
				throw EnumMensajes.CUADRE_CAJA_INCONSISTENTE.generarExcepcion(EnumClasesMensaje.ERROR);
			}
			
		}else{
			this.castFrmArqueoCaja().getLblTotalDiferencia().setText(EnumEtiquetas.LBL_AQC_TOTAL_DIFERENCIA_EXACTA.getValor(true));
			this.castFrmArqueoCaja().getTxtTotalDiferencia().setForeground(Color.black);
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo generarImpresionCierreCaja
  	 * 		   metodo encargado de solicitar la ejecucion de la impresion
  	 * 		   de cierre de caja
  	 * @return boolean
  	 * 		   bandera que permite identificar si el proceso de impresion
  	 * 		   fue llevado a cabo correctamente
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private boolean generarImpresionCierreCaja()throws Exception{
		
		boolean booImprimio;
			
		booImprimio = EnumImpresiones.CIERRE_CAJA.ejecutarImpresion(super.getFrmForma(), 
																	false,
																	super.getObjUsuario(),
																	super.getObjUsuario().getCaja(),
																	super.getObjUsuario().getMediosPago(),
																	this.objInfoCierreCajaDTO.getHmIngresosXConcepto(),
																	this.objInfoCierreCajaDTO.getHmEgresosXConcepto(),
																	this.objDtoIngresosXBillete,
																	this.objDtoIngresosXMoneda,
																	this.objDtoIngresosXCheque,
																	this.objDtoIngresosXVale,
																	this.castFrmArqueoCaja().getTxaNotas().getText());
		return booImprimio;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo castFrmArqueoCaja
  	 * 		   Metodo estandar para formatear el tipo de dato general a 
  	 * 		   un tipo especifico ("Casteo"), del atributo padre frmForma
  	 * @return FormaArqueoCaja
  	 * 		   valor especifico recuperado
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaArqueoCaja castFrmArqueoCaja()throws Exception{
		return (FormaArqueoCaja)super.getFrmForma();
	}
	
}

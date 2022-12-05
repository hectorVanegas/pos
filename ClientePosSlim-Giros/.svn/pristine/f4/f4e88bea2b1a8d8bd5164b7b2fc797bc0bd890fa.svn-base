package co.com.codesa.clienteposslimgiros.formas.caja;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumImagenes;
import co.com.codesa.clienteposslimgiros.eventos.caja.EventoFormaMovimientoCaja;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.BotonUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.GrillaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelEncabezadoGeneral;
import co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.FormaPanelDesplazableServiciosAdicionales;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Documento;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaSeguro;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 24-sep-2015
 * @Clase FormaMovimientoCaja 
 * 		  Clase que genera la forma (GUI) para la funcionalidad de 
 * 		  movimiento de caja, referenciada por las operaciones de
 * 		  envio y pago
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class FormaMovimientoCaja extends FormaGenerica{

	/**
	 * @variable serialVersionUID
	 * 			 Variable serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @variable pnlEncabezadoGeneral
	 * 			 seccion que aloja el encabezado general para las formas, que contiene 
	 * 			 los valores de agencia, empresa y caja, normalmente recuperados del 
	 * 			 usuario autenticado
	 **/
	private FormaPanelEncabezadoGeneral pnlEncabezadoGeneral;
	
	/**
	 * @variable scpServiciosAdicionales
	 * 			 contenedor de servicios adicionales
	 */
	private FormaPanelDesplazableServiciosAdicionales scpServiciosAdicionales;
	
	/**
	 * @variable scpGrillaMediosPago
	 * 			 componente de scroll que contiene la grilla de medios de pago 
	 **/
	private JScrollPane scpGrillaMediosPago;
	
	/**
	 * @variable tblMediosPago
	 * 			 grilla que contiene los medios de pago 
	 **/
	private GrillaUtil tblMediosPago;
	
	/**
	 * @variable txtValorPagar
	 * 			 caja de texto utilizada para mostrar el valor a pagar
	 **/
	private CajaTextoUtil txtValorPagar;
	
	/**
	 * @variable txtFaltante
	 * 			 caja de texto utilizada para mostrar el valor faltante
	 **/
	private CajaTextoUtil txtFaltante;
	
	/**
	 * @variable txtTotalMovimiento
	 * 			 caja de texto utilizada para mostrar el valor total del movimiento
	 **/
	private CajaTextoUtil txtTotalMovimiento;	
	
	/**
	 * @variable btnAdicionarMedioPago
	 * 			 boton para adicionar un medio de pago a la grilla
	 **/
	private BotonUtil btnAdicionarMedioPago;
	
	/**
	 * @variable btnEliminarMedioPago
	 * 			 boton para eliminar un medio de pago previamente
	 * 			 adicionado a la grilla
	 **/
	private BotonUtil btnEliminarMedioPago;
	
	/**
	 * @variable btnVerEditarMedioPago
	 * 			 boton para ver y/o editar un medio de pago previamente
	 * 			 adicionado a la grilla
	 **/
	private BotonUtil btnVerEditarMedioPago;
	
	/**
	 * @variable lblValorPagar
	 * 			 etiqueta que identifica el componnete grafico que contiene el valor a
	 * 			 a pagar
	 **/
	private EtiquetaUtil lblValorPagar;
	
	/**
	 * @variable lblTotalMovimiento
	 * 			 etiqueta que identifica el componente grafico que contiene el total de
	 * 			 movimiento a registrar
	 **/
	private EtiquetaUtil lblTotalMovimiento;
	
	/**
	 * @variable lblCambio
	 * 			 etiqueta que identifica el componnete grafico que contiene el valor 
	 * 			 de diferencia entre el valor recibido y valor del servicio que se puede 
	 * 			 entender como el cambio o el regreso al cliente  
	 **/
	private EtiquetaUtil lblCambio;
	
	
	
	/**
  	 * ****************************************************************.
  	 * @method FormaMovimientoCaja
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de la forma
  	 * @param  pFrmPadre
  	 * 		   ventana de la cual extiende esta forma
  	 * @param  pBooModal 
  	 * 		   bandera que permite efectuar la forma de manera modal sobre 
  	 * 		   la ventana de la cual extiende
  	 * @param  pObjFacturaGiro
  	 * 		   objeto factura procesado generado previamente
  	 * @param  pObjFacturaSeguro
  	 * 		   objeto FacturaSeguro con el detalle del Seguro
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @author Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaMovimientoCaja(FormaGenerica pFrmPadre, 
							   boolean pBooModal, 
							   FacturaGiro pObjFacturaGiro,
							   FacturaSeguro pObjFacturaSeguro) throws Exception{
		
		super(pFrmPadre,
			  pBooModal);
		
		super.setBooDesaparecerVentanaPadre(true);
		
		super.setEventoForma(new EventoFormaMovimientoCaja(this,
				 			 							   pObjFacturaGiro,
				 			 							   pObjFacturaSeguro));
		this.inicializarForma(pObjFacturaGiro);
	}
	
	@Override
	public void inicializarForma(Object ...pArrObjParametrosForma) throws Exception {
		
		super.setTituloForma(EnumEtiquetas.TTL_MVC_VENTANA_RECAUDO);
		super.setAnchoForma(EnumDimensionesComponentes.GUI_MVC_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.GUI_MVC_VENTANA.getAlto());
        
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR, 
								EnumBotonesEncabezado.BTNVOLVER,
								EnumBotonesEncabezado.BTNOPERACION_INUSUAL,
								EnumBotonesEncabezado.BTNSALIR);
		
		super.iniciar(pArrObjParametrosForma);
	}
	
	@Override
	public JPanel inicializarEncabezado(Object ...pArrObjParametrosForma) throws Exception {
		
		JPanel pnlEncabezado;
		
		pnlEncabezado = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_MVC_ENCABEZADO,
																	"pnlEncabezado",
	  														 	 	BorderFactory.createEtchedBorder(),
	  														 	 	null,
	  														 	 	null);
		pnlEncabezado.add(this.iniciarPropPnlEncabezadoGeneral());
		
		return pnlEncabezado;
	}

	@Override
	public JPanel inicializarCuerpo(Object ...arrObjParametrosCuerpo) throws Exception {
		
		JPanel pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_MVC_CUERPO,
																"pnlCuerpo",
			 												 	BorderFactory.createEtchedBorder(),
			 												 	null,
			 												 	null);

		pnlCuerpo.add(this.iniciarPropBtnAdicionarMedioPago());
		pnlCuerpo.add(this.iniciarPropScrollGrillaMediosPago());
		pnlCuerpo.add(this.iniciarPropBtnEliminarMedioPago());
		pnlCuerpo.add(this.iniciarPropBtnVerEditarMedioPago());
		pnlCuerpo.add(this.iniciarPropLblValorPagar());
		pnlCuerpo.add(this.iniciarPropTxtValorPagar());
		pnlCuerpo.add(this.iniciarPropLblTotalMovimiento());
		pnlCuerpo.add(this.iniciarPropTxtTotalMovimiento());
		pnlCuerpo.add(this.iniciarPropLblCambio());
		pnlCuerpo.add(this.iniciarPropTxtFaltante());
		
		return pnlCuerpo;
	}

	@Override
	public JPanel inicializarPiePagina(Object ...arrObjParametrosPiePagina) throws Exception {
		
		JPanel pnlPiePagina;
		
		pnlPiePagina = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_MVC_PIE_PAGINA,
																   "pnlPiePagina",
	 															   BorderFactory.createEmptyBorder(),
	 															   null,
	 															   null);
		
		pnlPiePagina.add(this.iniciarPropScpServiciosAdicionales());
		
		return pnlPiePagina;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropPnlEncabezadoGeneral 
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pnlEncabezadoGeneral
  	 * @return FormaPanelEncabezadoGeneral
  	 * 		   seccion de encabezado general gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor  hector.cuenca
  	 * @date   9/03/2016
  	 * ****************************************************************
  	 */
	public FormaPanelEncabezadoGeneral iniciarPropPnlEncabezadoGeneral() throws Exception{
		
		if(this.pnlEncabezadoGeneral==null){
			
			this.pnlEncabezadoGeneral = new FormaPanelEncabezadoGeneral(null, 
																	   super.getObjUsuario().getAgencia(), 
																	   super.getObjUsuario().getCaja(), 
																	   EnumDimensionesComponentes.PNL_MVC_ENCABEZADO_GENERAL,
																	   "pnlEncabezadoGeneral");
		}
		
		return this.pnlEncabezadoGeneral;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropScpServiciosAdicionales 
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   scpServiciosAdicionales
  	 * @return FormaPanelDesplazableServiciosAdicionales
  	 * 		   contenedor de servicios adicionales
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor  hector.cuenca
  	 * @date   9/03/2016
  	 * ****************************************************************
  	 */
	public FormaPanelDesplazableServiciosAdicionales iniciarPropScpServiciosAdicionales()throws Exception{
		
		if(this.scpServiciosAdicionales == null){
			
			this.scpServiciosAdicionales = new FormaPanelDesplazableServiciosAdicionales(this,
																			   			 EnumDimensionesComponentes.SCP_MVC_SERVICIOS_ADICIONALES,
																			   			 2,
																			   			 "scpServiciosAdicionales",
																			   			 null,
																			   			 null,
																			   			 EnumEtiquetas.TTL_SRV_ADI_SCP_SERVICIOS_ADICIONALES);
		}
		
		return this.scpServiciosAdicionales;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblValorPagar
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblValorPagar
  	 * @return EtiquetaUtil
  	 * 		   etiqueta gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblValorPagar() throws Exception{
		
		if (this.lblValorPagar == null) {
			
				this.lblValorPagar = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_MVC_VALOR_PAGAR, 
																			 	 "lblValorPagar",
																			 	 EnumEtiquetas.LBL_MVC_VALOR_COBRAR,
																			 	 true,
																			 	 null,
																			 	 true);
				
			this.lblValorPagar.setFont(this.lblValorPagar.getFont().deriveFont(Font.BOLD,16));
			this.lblValorPagar.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		
		return this.lblValorPagar;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropTxtValorPagar
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   txtValorPagar
  	 * @return CajaTextoUtil
  	 * 		   caja de texto gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaTextoUtil iniciarPropTxtValorPagar()throws Exception{
		
		if(this.txtValorPagar==null){
			
			this.txtValorPagar = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_MVC_VALOR_PAGAR, 
																			 	 "txtValorPagar", 
																			 	 "",
																			 	 true, 
																			 	 false, 
																			 	 true, 
																			 	 null,
																			 	 EnumEtiquetas.LBL_MVC_VALOR_COBRAR);
			
			this.txtValorPagar.setBackground(new Color(164, 164, 255));
			this.txtValorPagar.setForeground(new Color(0, 0, 0));
			this.txtValorPagar.setHorizontalAlignment(SwingConstants.TRAILING);
			
			this.txtValorPagar.setFont(this.txtValorPagar.getFont().deriveFont(Font.BOLD,14));
		}
		
		return this.txtValorPagar;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropBtnAdicionarMedioPago
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   btnAdicionarMedioPago
  	 * @return BotonUtil
  	 * 		   boton de accion gestionado 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public BotonUtil iniciarPropBtnAdicionarMedioPago() throws Exception{
		
		if(this.btnAdicionarMedioPago==null){
			
			this.btnAdicionarMedioPago = UtilComponentesGUI.getInstance().crearBoton(	EnumDimensionesComponentes.BTN_MVC_ADICIONAR_MEDIO_PAGO,
													   					    	 	 	"btnAdicionarMedioPago",
													   					    	 	 	EnumEtiquetas.BTN_MVC_ADICIONAR_MEDIO_PAGO,
													   					    	 	 	true,
													   					    	 	 	true,
													   					    	 	 	super.getEventoForma(),
													   					    	 	 	EnumImagenes.OP_INGRESAR.ajustarIcono(EnumDimensionesComponentes.IMG_BTN_MVC_ADICIONAR_MEDIO_PAGO));
		}
		
		return btnAdicionarMedioPago;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropBtnEliminarMedioPago
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   btnEliminarMedioPago
  	 * @return BotonUtil
  	 * 		   boton de accion gestionado 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public BotonUtil iniciarPropBtnEliminarMedioPago() throws Exception{
		
		if(this.btnEliminarMedioPago==null){
			
			this.btnEliminarMedioPago = UtilComponentesGUI.getInstance().crearBoton	(	EnumDimensionesComponentes.BTN_MVC_ELIMINAR_MEDIO_PAGO,
													   					    	 		"btnEliminarMedioPago",
													   					    	 		EnumEtiquetas.BTN_MVC_ELIMINAR_MEDIO_PAGO,
													   					    	 		true,
													   					    	 		true,
													   					    	 		super.getEventoForma(),
													   					    	 		EnumImagenes.OP_ELIMINAR.ajustarIcono(EnumDimensionesComponentes.IMG_BTN_MVC_ELIMINAR_MEDIO_PAGO)
													   					    	 	);
		}
		
		return btnEliminarMedioPago;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropBtnVerEditarMedioPago
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   btnVerEditarMedioPago
  	 * @return BotonUtil
  	 * 		   boton de accion gestionado 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public BotonUtil iniciarPropBtnVerEditarMedioPago() throws Exception{
		
		if(this.btnVerEditarMedioPago==null){
			
			this.btnVerEditarMedioPago = UtilComponentesGUI.getInstance().crearBoton(	EnumDimensionesComponentes.BTN_MVC_EDITAR_MEDIO_PAGO,
													   					    	 	 	"btnVerEditarMedioPago",
													   					    	 	 	EnumEtiquetas.BTN_MVC_EDITAR_MEDIO_PAGO,
													   					    	 	 	true,
													   					    	 	 	true,
													   					    	 	 	super.getEventoForma(),
													   					    	 	 	EnumImagenes.OP_EDITAR.ajustarIcono(EnumDimensionesComponentes.IMG_BTN_MVC_EDITAR_MEDIO_PAGO)
													   					    	 	 );
		}
		
		return btnVerEditarMedioPago;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropScrollGrillaMediosPago
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   scpGrillaMediosPago
  	 * @return JScrollPane
  	 * 		   contenedor para el despliegue de grilla gestionado
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public JScrollPane iniciarPropScrollGrillaMediosPago() throws Exception{
		
		if(this.scpGrillaMediosPago==null){
			
			this.scpGrillaMediosPago = UtilComponentesGUI.getInstance().crearScroll("scpGrillaMediosPago",
													 					 			EnumDimensionesComponentes.SCP_MVC_GRILLA_MEDIOS_PAGO,
													 					 			null);
			
			this.scpGrillaMediosPago.setViewportView(this.iniciarPropGrillaMediosPago());
		}
		
		return this.scpGrillaMediosPago;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropGrillaMediosPago
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   tblMediosPago
  	 * @return GrillaUtil 
  	 * 		   grilla gestionada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public GrillaUtil iniciarPropGrillaMediosPago() throws Exception{
		
		if(this.tblMediosPago==null){
			
			this.tblMediosPago = UtilComponentesGUI.getInstance().crearGrilla("tblMediosPago",
															   			  	  new EnumEtiquetas[]{EnumEtiquetas.TTL_MVC_GRILLA_MEDPAGO_FILA,
																					   	   		  EnumEtiquetas.TTL_MVC_GRILLA_MEDPAGO_ID,
																					   	   		  EnumEtiquetas.TTL_MVC_GRILLA_MEDPAGO_DESCRIPCION,
																					   	   		  EnumEtiquetas.TTL_MVC_GRILLA_MEDPAGO_VALOR},
															   			      new EnumEtiquetas[]{EnumEtiquetas.TTL_MVC_GRILLA_MEDPAGO_FILA},//invisibles
															   			      new boolean[] {false, 
																						 	 false, 
																						 	 false,
																						 	 false},//editable por columna
															   			      new int[] {5,
																					 	 230,
																					 	 115},//dimensiones
															   			      null);
		}
		
		return this.tblMediosPago;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblTotalMovimiento
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblTotalMovimiento
  	 * @return EtiquetaUtil
  	 * 		   etiqueta gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblTotalMovimiento() throws Exception{
		
		if (this.lblTotalMovimiento == null) {
			
			this.lblTotalMovimiento = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_MVC_TOTAL_MOVIMIENTO, 
																			  	  "lblTotalMovimiento",
																			  	  EnumEtiquetas.LBL_MVC_TOTAL_MOVIMIENTO_ENVIO,
																			  	  true,
																			  	  null,
																			  	  true);
			
			this.lblTotalMovimiento.setFont(this.lblTotalMovimiento.getFont().deriveFont(Font.BOLD,16));
			this.lblTotalMovimiento.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		
		return this.lblTotalMovimiento;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblCambio
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblCambio
  	 * @return EtiquetaUtil
  	 * 		   etiqueta gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblCambio() throws Exception{
		
		if (this.lblCambio == null) {
			
			this.lblCambio = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_MVC_CAMBIO, 
																	 	 "lblCambio",
																	 	 EnumEtiquetas.LBL_MVC_CAMBIO_FALTA,
																	 	 true,
																	 	 null,
																	 	 true);
			
			this.lblCambio.setFont(this.lblCambio.getFont().deriveFont(Font.BOLD,16));
			this.lblCambio.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		
		return this.lblCambio;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropTxtTotalMovimiento
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   txtTotalMovimiento
  	 * @return CajaTextoUtil 
  	 * 		   caja de texto gestionada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaTextoUtil iniciarPropTxtTotalMovimiento()throws Exception{
		
		if(this.txtTotalMovimiento==null){
			
			this.txtTotalMovimiento = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_MVC_TOTAL_MOVIMIENTO, 
																				  	  "txtTotalMovimiento", 
																				  	  "",
																				  	  true, 
																				  	  false, 
																				  	  true, 
																				  	  null,
																				  	  EnumEtiquetas.LBL_MVC_TOTAL_MOVIMIENTO_ENVIO);
			
			this.txtTotalMovimiento.setBackground(new Color(164, 164, 255));
			this.txtTotalMovimiento.setForeground(new Color(0, 0, 0));
			this.txtTotalMovimiento.setHorizontalAlignment(SwingConstants.TRAILING);
			
			this.txtTotalMovimiento.setFont(this.txtTotalMovimiento.getFont().deriveFont(Font.BOLD,14));
		}
		
		return this.txtTotalMovimiento;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropTxtFaltante
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   txtFaltante
  	 * @return CajaTextoUtil 
  	 * 		   caja de texto gestionada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaTextoUtil iniciarPropTxtFaltante()throws Exception{
		
		if(this.txtFaltante==null){
			
			this.txtFaltante = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_MVC_TOTAL_FALTANTE, 
																		   	   "txtFaltante", 
																		   	   "",
																		   	   true, 
																		   	   false, 
																		   	   true, 
																		   	   null,
																		   	   EnumEtiquetas.LBL_MVC_CAMBIO_FALTA);
			
			this.txtFaltante.setBackground(new Color(164, 164, 255));
			this.txtFaltante.setForeground(new Color(0, 0, 0));
			this.txtFaltante.setHorizontalAlignment(SwingConstants.TRAILING);
			
			this.txtFaltante.setFont(this.txtFaltante.getFont().deriveFont(Font.BOLD,14));
		}
		
		return this.txtFaltante;
	}

	/**
	 * @method getPnlEncabezadoGeneral
	 * 		   Metodo get del atributo pnlEncabezadoGeneral
	 * @return FormaPanelEncabezadoGeneral
	 *		   Valor del atributo pnlEncabezadoGeneral devuelto
	 * @author hector.cuenca
	 * @date   9/03/2016
	 */
	public FormaPanelEncabezadoGeneral getPnlEncabezadoGeneral() {
		return this.pnlEncabezadoGeneral;
	}

	/**
	 * @method setPnlEncabezadoGeneral
	 * 		   Metodo set del atributo pnlEncabezadoGeneral
	 * @param  pPnlEncabezadoGeneral
	 *		   Valor que tomara el atributo pnlEncabezadoGeneral
	 * @author hector.cuenca
	 * @date   9/03/2016
	 */
	public void setPnlEncabezadoGeneral(
			FormaPanelEncabezadoGeneral pPnlEncabezadoGeneral) {
		this.pnlEncabezadoGeneral = pPnlEncabezadoGeneral;
	}

	/**
	 * @method getScpGrillaMediosPago
	 * 		   Metodo get del atributo scpGrillaMediosPago
	 * @return JScrollPane
	 *		   Valor del atributo scpGrillaMediosPago devuelto
	 * @author roberth.martinez
	 * @date   17/3/2016
	 */
	public JScrollPane getScpGrillaMediosPago() {
		return this.scpGrillaMediosPago;
	}

	/**
	 * @method setScpGrillaMediosPago
	 * 		   Metodo set del atributo scpGrillaMediosPago
	 * @param  pScpGrillaMediosPago
	 *		   Valor que tomara el atributo scpGrillaMediosPago
	 * @author roberth.martinez
	 * @date   17/3/2016
	 */
	public void setScpGrillaMediosPago(JScrollPane pScpGrillaMediosPago) {
		this.scpGrillaMediosPago = pScpGrillaMediosPago;
	}

	/**
	 * @method getTblMediosPago
	 * 		   Metodo get del atributo tblMediosPago
	 * @return GrillaUtil
	 *		   Valor del atributo tblMediosPago devuelto
	 * @author roberth.martinez
	 * @date   17/3/2016
	 */
	public GrillaUtil getTblMediosPago() {
		return this.tblMediosPago;
	}

	/**
	 * @method setTblMediosPago
	 * 		   Metodo set del atributo tblMediosPago
	 * @param  pTblMediosPago
	 *		   Valor que tomara el atributo tblMediosPago
	 * @author roberth.martinez
	 * @date   17/3/2016
	 */
	public void setTblMediosPago(GrillaUtil pTblMediosPago) {
		this.tblMediosPago = pTblMediosPago;
	}

	/**
	 * @method getTxtValorPagar
	 * 		   Metodo get del atributo txtValorPagar
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtValorPagar devuelto
	 * @author roberth.martinez
	 * @date   17/3/2016
	 */
	public CajaTextoUtil getTxtValorPagar() {
		return this.txtValorPagar;
	}

	/**
	 * @method setTxtValorPagar
	 * 		   Metodo set del atributo txtValorPagar
	 * @param  pTxtValorPagar
	 *		   Valor que tomara el atributo txtValorPagar
	 * @author roberth.martinez
	 * @date   17/3/2016
	 */
	public void setTxtValorPagar(CajaTextoUtil pTxtValorPagar) {
		this.txtValorPagar = pTxtValorPagar;
	}

	/**
	 * @method getTxtFaltante
	 * 		   Metodo get del atributo txtFaltante
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtFaltante devuelto
	 * @author roberth.martinez
	 * @date   17/3/2016
	 */
	public CajaTextoUtil getTxtFaltante() {
		return this.txtFaltante;
	}

	/**
	 * @method setTxtFaltante
	 * 		   Metodo set del atributo txtFaltante
	 * @param  pTxtFaltante
	 *		   Valor que tomara el atributo txtFaltante
	 * @author roberth.martinez
	 * @date   17/3/2016
	 */
	public void setTxtFaltante(CajaTextoUtil pTxtFaltante) {
		this.txtFaltante = pTxtFaltante;
	}

	/**
	 * @method getTxtTotalMovimiento
	 * 		   Metodo get del atributo txtTotalMovimiento
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtTotalMovimiento devuelto
	 * @author roberth.martinez
	 * @date   17/3/2016
	 */
	public CajaTextoUtil getTxtTotalMovimiento() {
		return this.txtTotalMovimiento;
	}

	/**
	 * @method setTxtTotalMovimiento
	 * 		   Metodo set del atributo txtTotalMovimiento
	 * @param  pTxtTotalMovimiento
	 *		   Valor que tomara el atributo txtTotalMovimiento
	 * @author roberth.martinez
	 * @date   17/3/2016
	 */
	public void setTxtTotalMovimiento(CajaTextoUtil pTxtTotalMovimiento) {
		this.txtTotalMovimiento = pTxtTotalMovimiento;
	}

	/**
	 * @method getBtnAdicionarMedioPago
	 * 		   Metodo get del atributo btnAdicionarMedioPago
	 * @return BotonUtil
	 *		   Valor del atributo btnAdicionarMedioPago devuelto
	 * @author roberth.martinez
	 * @date   17/3/2016
	 */
	public BotonUtil getBtnAdicionarMedioPago() {
		return this.btnAdicionarMedioPago;
	}

	/**
	 * @method setBtnAdicionarMedioPago
	 * 		   Metodo set del atributo btnAdicionarMedioPago
	 * @param  pBtnAdicionarMedioPago
	 *		   Valor que tomara el atributo btnAdicionarMedioPago
	 * @author roberth.martinez
	 * @date   17/3/2016
	 */
	public void setBtnAdicionarMedioPago(BotonUtil pBtnAdicionarMedioPago) {
		this.btnAdicionarMedioPago = pBtnAdicionarMedioPago;
	}

	/**
	 * @method getBtnEliminarMedioPago
	 * 		   Metodo get del atributo btnEliminarMedioPago
	 * @return BotonUtil
	 *		   Valor del atributo btnEliminarMedioPago devuelto
	 * @author roberth.martinez
	 * @date   17/3/2016
	 */
	public BotonUtil getBtnEliminarMedioPago() {
		return this.btnEliminarMedioPago;
	}

	/**
	 * @method setBtnEliminarMedioPago
	 * 		   Metodo set del atributo btnEliminarMedioPago
	 * @param  pBtnEliminarMedioPago
	 *		   Valor que tomara el atributo btnEliminarMedioPago
	 * @author roberth.martinez
	 * @date   17/3/2016
	 */
	public void setBtnEliminarMedioPago(BotonUtil pBtnEliminarMedioPago) {
		this.btnEliminarMedioPago = pBtnEliminarMedioPago;
	}

	/**
	 * @method getBtnVerEditarMedioPago
	 * 		   Metodo get del atributo btnVerEditarMedioPago
	 * @return BotonUtil
	 *		   Valor del atributo btnVerEditarMedioPago devuelto
	 * @author roberth.martinez
	 * @date   17/3/2016
	 */
	public BotonUtil getBtnVerEditarMedioPago() {
		return this.btnVerEditarMedioPago;
	}

	/**
	 * @method setBtnVerEditarMedioPago
	 * 		   Metodo set del atributo btnVerEditarMedioPago
	 * @param  pBtnVerEditarMedioPago
	 *		   Valor que tomara el atributo btnVerEditarMedioPago
	 * @author roberth.martinez
	 * @date   17/3/2016
	 */
	public void setBtnVerEditarMedioPago(BotonUtil pBtnVerEditarMedioPago) {
		this.btnVerEditarMedioPago = pBtnVerEditarMedioPago;
	}

	/**
	 * @method getLblValorPagar
	 * 		   Metodo get del atributo lblValorPagar
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblValorPagar devuelto
	 * @author roberth.martinez
	 * @date   17/3/2016
	 */
	public EtiquetaUtil getLblValorPagar() {
		return this.lblValorPagar;
	}

	/**
	 * @method setLblValorPagar
	 * 		   Metodo set del atributo lblValorPagar
	 * @param  pLblValorPagar
	 *		   Valor que tomara el atributo lblValorPagar
	 * @author roberth.martinez
	 * @date   17/3/2016
	 */
	public void setLblValorPagar(EtiquetaUtil pLblValorPagar) {
		this.lblValorPagar = pLblValorPagar;
	}

	/**
	 * @method getLblTotalMovimiento
	 * 		   Metodo get del atributo lblTotalMovimiento
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblTotalMovimiento devuelto
	 * @author roberth.martinez
	 * @date   17/3/2016
	 */
	public EtiquetaUtil getLblTotalMovimiento() {
		return this.lblTotalMovimiento;
	}

	/**
	 * @method setLblTotalMovimiento
	 * 		   Metodo set del atributo lblTotalMovimiento
	 * @param  pLblTotalMovimiento
	 *		   Valor que tomara el atributo lblTotalMovimiento
	 * @author roberth.martinez
	 * @date   17/3/2016
	 */
	public void setLblTotalMovimiento(EtiquetaUtil pLblTotalMovimiento) {
		this.lblTotalMovimiento = pLblTotalMovimiento;
	}

	/**
	 * @method getLblCambio
	 * 		   Metodo get del atributo lblCambio
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblCambio devuelto
	 * @author roberth.martinez
	 * @date   17/3/2016
	 */
	public EtiquetaUtil getLblCambio() {
		return this.lblCambio;
	}

	/**
	 * @method setLblCambio
	 * 		   Metodo set del atributo lblCambio
	 * @param  pLblCambio
	 *		   Valor que tomara el atributo lblCambio
	 * @author roberth.martinez
	 * @date   17/3/2016
	 */
	public void setLblCambio(EtiquetaUtil pLblCambio) {
		this.lblCambio = pLblCambio;
	}

	/**
	 * @method getScpServiciosAdicionales
	 * 		   Metodo get del atributo scpServiciosAdicionales
	 * @return FormaPanelDesplazableServiciosAdicionales
	 *		   Valor del atributo scpServiciosAdicionales devuelto
	 * @author roberth.martinez
	 * @date   23/3/2016
	 */
	public FormaPanelDesplazableServiciosAdicionales getScpServiciosAdicionales() {
		return this.scpServiciosAdicionales;
	}

	/**
	 * @method setScpServiciosAdicionales
	 * 		   Metodo set del atributo scpServiciosAdicionales
	 * @param  pScpServiciosAdicionales
	 *		   Valor que tomara el atributo scpServiciosAdicionales
	 * @author roberth.martinez
	 * @date   23/3/2016
	 */
	public void setScpServiciosAdicionales(
			FormaPanelDesplazableServiciosAdicionales pScpServiciosAdicionales) {
		this.scpServiciosAdicionales = pScpServiciosAdicionales;
	}

	/** 
	 * ********************************************************************
	 * @method main
	 * 		   metodo main para pruebas
	 * @param  args
	 * 		   argumentos
	 * @author roberth.martinez
	 * @date   17/3/2016
	 * *********************************************************************
	 */
	public static void main(String[] args) {
		
		try{
	        
			TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaMovimientoCaja.class,
																   true, 
																   EnumDesplegarFormaConEventos.SI);
			FacturaGiro factG = new FacturaGiro();
			factG.setTotal(100000);
			Documento doc = new Documento();
			doc.setNaturaleza("+");
			doc.setCodigo("27");
			factG.setDocumento(doc);
			new FormaMovimientoCaja(null,
									true,  
									factG,
									null);
			
		} catch (Exception e) {
			
			UtilidadesGiros.getInstance().controlExcepcion(e, 
														   null);
		}
	}
}

package co.com.codesa.clienteposslimgiros.formas.pago;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.pago.EventoFormaPagoGiroInternacional;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.BotonUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Agencia;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Corresponsal;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.MedioPago;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Moneda;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Nota;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TerceroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TerritorioInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TipoDocumentoInternacional;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.tercero.internacional.ConfigTerceroInternacionalDTO;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;

/** 
 * ********************************************************************
 * @class  FormaPagoGiroInternacional
 *		   Forma para realizar las acciones necesarias a un giro 
 *		   internacional para su pago
 * @author roberth.martinez
 * @date   25/03/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class FormaPagoGiroInternacional extends FormaGenerica{

	/**
	 * @variable serialVersionUID
	 * 			 variable serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @variable	pnlRemitente
	 * 				panel remitente
	 */
	private SeccionUtil pnlRemitente;
	
	/**
	 * @variable	pnlBeneficiario
	 * 				panel beneficiario
	 */
	private SeccionUtil pnlBeneficiario;
	
	/**
	 * @variable	pnlMotivosNumerales
	 * 				panel motivos numerales
	 */
	private SeccionUtil pnlMotivosNumerales;
	
	/**
	 * @variable btnGestionReclamos
	 * 			 componente boton sobre la forma para manejar la funcionalida de gestionar reclamos
	 **/
	private BotonUtil btnGestionReclamos;
	
	/**
	 * @variable btnGestionSenalesAlerta
	 * 			 componente boton sobre la forma para manejar la funcionalida de gestionar senales alerta
	 **/
	private BotonUtil btnGestionSenalesAlerta;
	
	/**
	 * @variable btnCapturarFotos
	 * 			 componente boton sobre la forma para manejar la funcionalida de Capturar Foto
	 **/
	private BotonUtil btnCapturarFotos;
	
	/**
	 * @variable lblNombreTerceroRem
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 indica label de nombre del tercero remitente
	 **/
	private EtiquetaUtil lblNombreTerceroRem;
	
	/**
	 * @variable lblTelefonoTerceroRem
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 indica label de telefono del tercero remitente
	 **/
	private EtiquetaUtil lblTelefonoTerceroRem;
	
	/**
	 * @variable lblNombreTerceroBen
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 indica label de nombre del tercero beneficiario
	 **/
	private EtiquetaUtil lblNombreTerceroBen;
	
	/**
	 * @variable lblTelefonoTerceroBen
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 indica label de telefono del tercero beneficiario
	 **/
	private EtiquetaUtil lblTelefonoTerceroBen;
	
	/**
	 * @variable lblClienteTerceroBen
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 indica label de cliente del tercero beneficiario
	 **/
	private EtiquetaUtil lblClienteTerceroBen;
	
	/**
	 * @variable lblMotivoRemensa
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 indica label de motivo remensa
	 **/
	private EtiquetaUtil lblMotivoRemensa;
	
	/**
	 * @variable lblNumerales
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 indica label de numerales
	 **/
	private EtiquetaUtil lblNumerales;
	
	/**
	 * @variable lblFormaPago
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 indica label de FormaPago
	 **/
	private EtiquetaUtil lblFormaPago;
	
	/**
	 * @variable lblNotas
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 indica label de Notas
	 **/
	private EtiquetaUtil lblNotas;
	
	/**
	 * @variable lblVlrPesos
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 indica label de Vlr Pesos
	 **/
	private EtiquetaUtil lblVlrPesos;
	
	/**
	 * @variable lblVlrDolares
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 indica label de Vlr Dolares
	 **/
	private EtiquetaUtil lblVlrDolares;
	
	/**
	 * @variable lblVlrTasa
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 indica label de Tasa de cambio
	 **/
	private EtiquetaUtil lblTasa;
	
	/**
	 * @variable lblVlrGMF
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 indica label de GMF
	 **/
	private EtiquetaUtil lblGMF;
	
	/**
	 * @variable lblGastosAdmin
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 indica label de GastosAdministrativos
	 **/
	private EtiquetaUtil lblGastosAdmin;
	
	/**
	 * @variable lblVlrProtegiro
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 indica label de valor protegiro
	 **/
	private EtiquetaUtil lblVlrProtegiro;
	
	/**
	 * @variable lblVlrTotalPagar
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 indica label de valor total a pagar
	 **/
	private EtiquetaUtil lblVlrTotalPagar;
	
	/**
	 * @variable txtNombreTerceroRem
	 * 			 campo de texto sobre la forma para diligenciar la indicar el nombre del tercero remitente
	 **/
	private CajaTextoUtil txtNombreTerceroRem;
	
	/**
	 * @variable txtTelefonoTerceroRem
	 * 			 campo de texto sobre la forma para diligenciar la indicar el telefono del tercero remitente
	 **/
	private CajaTextoUtil txtTelefonoTerceroRem;
	
	/**
	 * @variable txtNombreTerceroBen
	 * 			 campo de texto sobre la forma para diligenciar la indicar el nombre del tercero beneficiario
	 **/
	private CajaTextoUtil txtNombreTerceroBen;
	
	/**
	 * @variable txtTelefonoTerceroBen
	 * 			 campo de texto sobre la forma para diligenciar la indicar el telefono del tercero beneficiario
	 **/
	private CajaTextoUtil txtTelefonoTerceroBen;
	
	/**
	 * @variable txtClienteTerceroBen
	 * 			 campo de texto sobre la forma para diligenciar la indicar el cliente del tercero beneficiario
	 **/
	private CajaTextoUtil txtClienteTerceroBen;
	
	/**
	 * @variable txtFormaPago
	 * 			 campo de texto sobre la forma para diligenciar la indicar el FormaPago
	 **/
	private CajaTextoUtil txtFormaPago;
	
	/**
	 * @variable txtNotas
	 * 			 campo de texto sobre la forma para diligenciar la indicar el Notas
	 **/
	private CajaTextoUtil txtNotas;
	
	/**
	 * @variable txtVlrPesos
	 * 			 campo de texto sobre la forma para diligenciar la indicar el VlrPesos
	 **/
	private CajaTextoUtil txtVlrPesos;
	
	/**
	 * @variable txtVlrDolares
	 * 			 campo de texto sobre la forma para diligenciar la indicar el VlrDolares
	 **/
	private CajaTextoUtil txtVlrDolares;
	
	/**
	 * @variable txtTasa
	 * 			 campo de texto sobre la forma para diligenciar la indicar el Tasa
	 **/
	private CajaTextoUtil txtTasa;
	
	/**
	 * @variable txtGMF
	 * 			 campo de texto sobre la forma para diligenciar la indicar el GMF
	 **/
	private CajaTextoUtil txtGMF;
	
	/**
	 * @variable txtGastosAdmin
	 * 			 campo de texto sobre la forma para diligenciar la indicar el GastosAdmin
	 **/
	private CajaTextoUtil txtGastosAdmin;
	
	/**
	 * @variable txtVlrProtegiro
	 * 			 campo de texto sobre la forma para diligenciar valor del protegiro
	 **/
	private CajaTextoUtil txtVlrProtegiro;
	
	/**
	 * @variable txtVlrTotalPagar
	 * 			 campo de texto sobre la forma para diligenciar valor da pagar
	 **/
	private CajaTextoUtil txtVlrTotalPagar;
	
	/**
	 * @variable cmbMotivoRemesa
	 * 			 componente de combo sobre la forma que  contiene el listado 
	 * 		     de los motivos de remesa
	 **/
	private CajaComboUtil cmbMotivoRemesa;
	
	/**
	 * @variable cmbNumerales
	 * 			 componente de combo sobre la forma que  contiene el listado 
	 * 		     de los numerales internacionales
	 **/
	private CajaComboUtil cmbNumerales;
	
	/**
	 * ********************************************************************
	 * @method	FormaPagoGiroInternacional
	 * 		  	Constructor que ejecuta la inicializacion de valores y 
  	 * 		   	ejecucion de comportamientos inicales requeridos para el 
  	 * 		   	despliegue de la forma
	 * @param 	pFrmPadre
	 * 			ventana de la cual extiende esta forma
	 * @param 	pBooModal
	 * 			bandera que permite efectuar la forma de manera modal sobre 
  	 * 		  	la ventana de la cual extiende
  	 * @param	pObjFacturaGiroInternacional
  	 * 			objeto factura giro internacional con los datos del giro
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	25/03/2018
	 * *********************************************************************
	 */
	public FormaPagoGiroInternacional(FormaGenerica pFrmPadre,
						 			  boolean pBooModal,
						 			  FacturaGiroInternacional pObjFacturaGiroInternacional) throws Exception{
		
		super(pFrmPadre,
			  pBooModal);
		
		super.setBooDesaparecerVentanaPadre(true);
		
		super.setEventoForma(new EventoFormaPagoGiroInternacional(this,
																  pObjFacturaGiroInternacional));
		this.inicializarForma();
	}

	@Override
	public void inicializarForma(Object ...pArrObjParametrosForma) throws Exception{
		
		super.setTituloForma(EnumEtiquetas.TTL_PGI_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.GUI_PGI_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.GUI_PGI_VENTANA.getAlto());
		
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
								EnumBotonesEncabezado.BTNVOLVER,
						  		EnumBotonesEncabezado.BTNSALIR);
		
		super.iniciar(pArrObjParametrosForma);		
	}

	@Override
	public JPanel inicializarEncabezado(Object ...pArrObjParametrosEncabezado) throws Exception {
		return null;
	}

	@Override
	public JPanel inicializarCuerpo(Object ...pArrObjParametrosCuerpo) throws Exception{
		
		JPanel pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_PGI_CUERPO,
																"pnlCuerpo",
			  													null,
			  													null,
			  													null);
		
		pnlCuerpo.add(this.iniciarPropPnlRemitente());
		pnlCuerpo.add(this.iniciarPropPnlBeneficiario());
		pnlCuerpo.add(this.iniciarPropPnlMotivosNumerales());
		pnlCuerpo.add(this.iniciarPropBtnGestionReclamos());
		pnlCuerpo.add(this.iniciarPropBtnGestionSenalesAlerta());
		pnlCuerpo.add(this.iniciarPropBtnCapturarFotos());
		
		return pnlCuerpo;
	}

	@Override
	public JPanel inicializarPiePagina(Object ...pArrObjParametrosPiePagina) throws Exception{
		
		JPanel pnlPiePagina;
		
		pnlPiePagina = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_PGI_PIE_PAGINA,
																   "pnlPiePagina",
	  	 														   null,
	  	 														   null,
	  	 														   null);
		
		pnlPiePagina.add(this.iniciarPropLblFormaPago());
		pnlPiePagina.add(this.iniciarPropTxtFormaPago());
		pnlPiePagina.add(this.iniciarPropLblNotas());
		pnlPiePagina.add(this.iniciarPropTxtNotas());
		pnlPiePagina.add(this.iniciarPropLblVlrPesos());
		pnlPiePagina.add(this.iniciarPropTxtVlrPesos());
		pnlPiePagina.add(this.iniciarPropLblVlrDolares());
		pnlPiePagina.add(this.iniciarPropTxtVlrDolares());
		pnlPiePagina.add(this.iniciarPropLblTasa());
		pnlPiePagina.add(this.iniciarPropTxtTasa());
		pnlPiePagina.add(this.iniciarPropLblGMF());
		pnlPiePagina.add(this.iniciarPropTxtGMF());
		pnlPiePagina.add(this.iniciarPropLblGastosAdmin());
		pnlPiePagina.add(this.iniciarPropTxtGastosAdmin());
		pnlPiePagina.add(this.iniciarPropLblVlrProtegiro());
		pnlPiePagina.add(this.iniciarPropTxtVlrProtegiro());
		pnlPiePagina.add(this.iniciarPropLblVlrTotalPagar());
		pnlPiePagina.add(this.iniciarPropTxtVlrTotalPagar());

		return pnlPiePagina;
	}
	
	/** 
	 * ********************************************************************
	 * @method	iniciarPropPnlRemitente
	 * 		  	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	pnlRemitente
	 * @return	SeccionUtil
	 * 			seccion de cuerpo gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	25/03/2018
	 * *********************************************************************
	 */
	public SeccionUtil iniciarPropPnlRemitente() throws Exception{
		
		if(this.pnlRemitente==null){
			
			this.pnlRemitente = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_PGI_REMITENTE,
																			"pnlRemitente",
																  		  	null,
																  		  	EnumEtiquetas.TTL_PGI_PNL_REMITENTE,
																  		  	null);
			this.pnlRemitente.add(this.iniciarPropLblNombreTerceroRem());
			this.pnlRemitente.add(this.iniciarPropTxtNombreTerceroRem());
			this.pnlRemitente.add(this.iniciarPropLblTelefonoTerceroRem());
			this.pnlRemitente.add(this.iniciarPropTxtTelefonoTerceroRem());
			
		}
		
		return this.pnlRemitente;
	}
	
	/** 
	 * ********************************************************************
	 * @method	iniciarPropPnlBeneficiario
	 * 		  	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	pnlBeneficiario
	 * @return	SeccionUtil
	 * 			seccion de cuerpo gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	25/03/2018
	 * *********************************************************************
	 */
	public SeccionUtil iniciarPropPnlBeneficiario() throws Exception{
		
		if(this.pnlBeneficiario==null){
			
			this.pnlBeneficiario = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_PGI_BENEFICIARIO,
																			   "pnlBeneficiario",
																  		  		null,
																  		  		EnumEtiquetas.TTL_PGI_PNL_BENEFICIARIO,
																  		  		null);
			this.pnlBeneficiario.add(this.iniciarPropLblNombreTerceroBen());
			this.pnlBeneficiario.add(this.iniciarPropTxtNombreTerceroBen());
			this.pnlBeneficiario.add(this.iniciarPropLblTelefonoTerceroBen());
			this.pnlBeneficiario.add(this.iniciarPropTxtTelefonoTerceroBen());
			this.pnlBeneficiario.add(this.iniciarPropLblClienteTerceroBen());
			this.pnlBeneficiario.add(this.iniciarPropTxtClienteTerceroBen());
			
		}
		
		return this.pnlBeneficiario;
	}
	
	/** 
	 * ********************************************************************
	 * @method	iniciarPropPnlMotivosNumerales
	 * 		  	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	pnlMotivosNumerales
	 * @return	SeccionUtil
	 * 			seccion de cuerpo gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	25/03/2018
	 * *********************************************************************
	 */
	public SeccionUtil iniciarPropPnlMotivosNumerales() throws Exception{
		
		if(this.pnlMotivosNumerales==null){
			
			this.pnlMotivosNumerales = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_PGI_MOTIVOS_NUMERALES,
																			   	   "pnlMotivosNumerales",
																			   	   null,
																			   	   EnumEtiquetas.TTL_PGI_PNL_MOTIVOS_NUMERALES,
																			   	   null);
			
			this.pnlMotivosNumerales.add(this.iniciarPropLblMotivoRemensa());
			this.pnlMotivosNumerales.add(this.iniciarPropCmbMotivoRemesa());
			this.pnlMotivosNumerales.add(this.iniciarPropLblNumerales());
			this.pnlMotivosNumerales.add(this.iniciarPropCmbNumerales());
			
		}
		
		return this.pnlMotivosNumerales;
	}
	
	/**
     * ****************************************************************
     * @method iniciarPropBtnGestionReclamos
     * 		   metodo utilizado para inicializar el componente BotonUtil 
     * 		   para gestiosn de reclamos
     * @return BotonUtil
     *         componente BotonUtil
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   25/03/2018
     * ****************************************************************
     */	
	public BotonUtil iniciarPropBtnGestionReclamos() throws Exception{
		
		if (this.btnGestionReclamos == null) {
			this.btnGestionReclamos = UtilComponentesGUI.getInstance().crearBoton(EnumDimensionesComponentes.BTN_PGI_GESTION_RECLAMOS, 
																	  	  		  "btnGestionReclamos", 
																	  	  		  EnumEtiquetas.BTN_PGI_GESTION_RECLAMOS, 
																	  	  		  true, 
																	  	  		  true, 
																	  	  		  super.getEventoForma(),  
																	  	  		  null);
			
			this.btnGestionReclamos.setBorder(BorderFactory.createEmptyBorder());
		}

		return this.btnGestionReclamos;
	}
	
	/**
     * ****************************************************************
     * @method iniciarPropBtnGestionSenalesAlerta
     * 		   metodo utilizado para inicializar el componente BotonUtil 
     * 		   para gestion de senales de alerta
     * @return BotonUtil
     *         componente BotonUtil
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   26/03/2018
     * ****************************************************************
     */	
	public BotonUtil iniciarPropBtnGestionSenalesAlerta() throws Exception{
		if (this.btnGestionSenalesAlerta == null) {
			this.btnGestionSenalesAlerta = UtilComponentesGUI.getInstance().crearBoton(EnumDimensionesComponentes.BTN_PGI_GESTION_SENALES_ALERTA, 
																	  	  			   "btnGestionSenalesAlerta", 
																	  	  			   EnumEtiquetas.BTN_PGI_GESTION_SENALES_ALERTA, 
																	  	  			   true, 
																	  	  			   true, 
																	  	  			   super.getEventoForma(),  
																	  	  			   null);
			this.btnGestionSenalesAlerta.setBorder(BorderFactory.createEmptyBorder());
		}

		return this.btnGestionSenalesAlerta;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblNombreTerceroRem
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblNombreTerceroRem
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	26/03/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblNombreTerceroRem() throws Exception{
		
		if (this.lblNombreTerceroRem == null) {
			
			this.lblNombreTerceroRem = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PGI_NOMBRE_TERCERO_REM, 
																	   	       	   "lblNombreTerceroRem", 
																	   	       	   EnumEtiquetas.LBL_PGI_NOMBRE_TERCERO_REM,
																	   	       	   false,
																	   	       	   null,
																	   	       	   true);
		}

		return this.lblNombreTerceroRem;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropTxtNombreTerceroRem
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtNombreTerceroRem
	 * @return	CajaTextoUtil
	 * 			Caja de texto gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	20/03/2018
	 * *********************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtNombreTerceroRem() throws Exception{
		
		if (this.txtNombreTerceroRem == null) {
			
			this.txtNombreTerceroRem = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_PGI_NOMBRE_TERCERO_REM, 
																			 	       "txtNombreTerceroRem", 
																			 	       "", 
																			 	       true, 
																			 	       false, 
																			 	       true,
																			 	       this.getEventoForma(),
																			 	       EnumEtiquetas.LBL_PGI_NOMBRE_TERCERO_REM);
		}

		return this.txtNombreTerceroRem;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblTelefonoTerceroRem
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblTelefonoTerceroRem
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	26/03/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblTelefonoTerceroRem() throws Exception{
		
		if (this.lblTelefonoTerceroRem == null) {
			
			this.lblTelefonoTerceroRem = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PGI_TELEFONO_TERCERO_REM, 
																	   	       	   	 "lblTelefonoTerceroRem", 
																	   	       	   	 EnumEtiquetas.LBL_PGI_TELEFONO_TERCERO_REM,
																	   	       	   	 false,
																	   	       	   	 null,
																	   	       	   	 true);
		}

		return this.lblTelefonoTerceroRem;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropTxtTelefonoTerceroRem
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtTelefonoTerceroRem
	 * @return	CajaTextoUtil
	 * 			Caja de texto gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	20/03/2018
	 * *********************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtTelefonoTerceroRem() throws Exception{
		
		if (this.txtTelefonoTerceroRem == null) {
			
			this.txtTelefonoTerceroRem = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_PGI_TELEFONO_TERCERO_REM, 
																			 	       "txtTelefonoTerceroRem", 
																			 	       "", 
																			 	       true, 
																			 	       false, 
																			 	       true,
																			 	       this.getEventoForma(),
																			 	       EnumEtiquetas.LBL_PGI_TELEFONO_TERCERO_REM);
		}

		return this.txtTelefonoTerceroRem;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblNombreTerceroBen
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblNombreTerceroBen
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	26/03/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblNombreTerceroBen() throws Exception{
		
		if (this.lblNombreTerceroBen == null) {
			
			this.lblNombreTerceroBen = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PGI_NOMBRE_TERCERO_BEN, 
																	   	       	   "lblNombreTerceroBen", 
																	   	       	   EnumEtiquetas.LBL_PGI_NOMBRE_TERCERO_BEN,
																	   	       	   false,
																	   	       	   null,
																	   	       	   true);
		}

		return this.lblNombreTerceroBen;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropTxtNombreTerceroBen
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtNombreTerceroBen
	 * @return	CajaTextoUtil
	 * 			Caja de texto gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	20/03/2018
	 * *********************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtNombreTerceroBen() throws Exception{
		
		if (this.txtNombreTerceroBen == null) {
			
			this.txtNombreTerceroBen = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_PGI_NOMBRE_TERCERO_BEN, 
																			 	       "txtNombreTerceroBen", 
																			 	       "", 
																			 	       true, 
																			 	       false, 
																			 	       true,
																			 	       this.getEventoForma(),
																			 	       EnumEtiquetas.LBL_PGI_NOMBRE_TERCERO_BEN);
		}

		return this.txtNombreTerceroBen;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblTelefonoTerceroBen
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblTelefonoTerceroBen
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	26/03/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblTelefonoTerceroBen() throws Exception{
		
		if (this.lblTelefonoTerceroBen == null) {
			
			this.lblTelefonoTerceroBen = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PGI_TELEFONO_TERCERO_BEN, 
																	   	       	   	 "lblTelefonoTerceroBen", 
																	   	       	   	 EnumEtiquetas.LBL_PGI_TELEFONO_TERCERO_BEN,
																	   	       	   	 false,
																	   	       	   	 null,
																	   	       	   	 true);
		}

		return this.lblTelefonoTerceroBen;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropTxtTelefonoTerceroBen
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtTelefonoTerceroBen
	 * @return	CajaTextoUtil
	 * 			Caja de texto gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	20/03/2018
	 * *********************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtTelefonoTerceroBen() throws Exception{
		
		if (this.txtTelefonoTerceroBen == null) {
			
			this.txtTelefonoTerceroBen = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_PGI_TELEFONO_TERCERO_BEN, 
																			 	         "txtTelefonoTerceroBen", 
																			 	         "", 
																			 	         true, 
																			 	         false, 
																			 	         true,
																			 	         this.getEventoForma(),
																			 	         EnumEtiquetas.LBL_PGI_TELEFONO_TERCERO_BEN);
		}

		return this.txtTelefonoTerceroBen;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblClienteTerceroBen
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblClienteTerceroBen
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	26/03/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblClienteTerceroBen() throws Exception{
		
		if (this.lblClienteTerceroBen == null) {
			
			this.lblClienteTerceroBen = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PGI_CLIENTE_TERCERO_BEN, 
																	   	       	   	"lblClienteTerceroBen", 
																	   	       	   	EnumEtiquetas.LBL_PGI_CLIENTE_TERCERO_BEN,
																	   	       	   	false,
																	   	       	   	null,
																	   	       	   	true);
		}

		return this.lblClienteTerceroBen;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropTxtClienteTerceroBen
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtClienteTerceroBen
	 * @return	CajaTextoUtil
	 * 			Caja de texto gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	20/03/2018
	 * *********************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtClienteTerceroBen() throws Exception{
		
		if (this.txtClienteTerceroBen == null) {
			
			this.txtClienteTerceroBen = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_PGI_CLIENTE_TERCERO_BEN, 
																			 	        "txtClienteTerceroBen", 
																			 	        "", 
																			 	        true, 
																			 	        false, 
																			 	        true,
																			 	        this.getEventoForma(),
																			 	        EnumEtiquetas.LBL_PGI_CLIENTE_TERCERO_BEN);
		}

		return this.txtClienteTerceroBen;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblMotivoRemensa
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblMotivoRemensa
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	26/03/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblMotivoRemensa() throws Exception{
		
		if (this.lblMotivoRemensa == null) {
			
			this.lblMotivoRemensa = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PGI_MOTIVO_REMENSA, 
																	   	       	"lblMotivoRemensa", 
																	   	       	EnumEtiquetas.LBL_PGI_MOTIVO_REMENSA,
																	   	       	false,
																	   	       	null,
																	   	       	true);
		}

		return this.lblMotivoRemensa;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropCmbMotivoRemesa
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	cmbMotivoRemesa
	 * @return	CajaComboUtil
	 * 			Lista de valores gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	26/03/2018
	 * *********************************************************************
	 */
	public CajaComboUtil iniciarPropCmbMotivoRemesa() throws Exception{
		
		if (this.cmbMotivoRemesa == null) {
			
			this.cmbMotivoRemesa = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_PGI_MOTIVO_REMENSA, 
																		  	      "cmbMotivoRemesa", 
																		  	      true, 
																		  	      true, 
																		  	      this.getEventoForma(),
																		  	  	  EnumEtiquetas.LBL_PGI_MOTIVO_REMENSA);
		}
		
		return cmbMotivoRemesa;
	}

	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblNumerales
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblNumerales
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	26/03/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblNumerales() throws Exception{
		
		if (this.lblNumerales == null) {
			
			this.lblNumerales = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PGI_NUMERALES, 
																	   	    "lblNumerales", 
																	   	    EnumEtiquetas.LBL_PGI_NUMERALES,
																	   	    false,
																	   	    null,
																	   	    true);
		}

		return this.lblNumerales;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropCmbNumerales
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	cmbNumerales
	 * @return	CajaComboUtil
	 * 			Lista de valores gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	26/03/2018
	 * *********************************************************************
	 */
	public CajaComboUtil iniciarPropCmbNumerales() throws Exception{
		
		if (this.cmbNumerales == null) {
			
			this.cmbNumerales = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_PGI_NUMERALES, 
																			   "cmbNumerales", 
																			   true, 
																			   true, 
																			   this.getEventoForma(),
																			   EnumEtiquetas.LBL_PGI_NUMERALES);
		}
		
		return cmbNumerales;
	}
	
	/**
     * ****************************************************************
     * @method iniciarPropBtnCapturarFotos
     * 		   metodo utilizado para inicializar el componente BotonUtil 
     * 		   para Captura Fotos
     * @return BotonUtil
     *         componente BotonUtil
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   26/03/2018
     * ****************************************************************
     */	
	public BotonUtil iniciarPropBtnCapturarFotos() throws Exception{
		
		if (this.btnCapturarFotos == null) {
			this.btnCapturarFotos = UtilComponentesGUI.getInstance().crearBoton(EnumDimensionesComponentes.BTN_PGI_CAPTURA_FOTOS, 
																	  	  		 "btnCapturarFotos", 
																	  	  		 EnumEtiquetas.BTN_PGI_CAPTURA_FOTOS, 
																	  	  		 false, 
																	  	  		 true, 
																	  	  		 super.getEventoForma(),  
																	  	  		 null);
			
			this.btnCapturarFotos.setBorder(BorderFactory.createEmptyBorder());
		}

		return this.btnCapturarFotos;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblFormaPago
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblFormaPago
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	27/03/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblFormaPago() throws Exception{
		
		if (this.lblFormaPago == null) {
			
			this.lblFormaPago = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PGI_FORMA_PAGO, 
																	   		"lblFormaPago", 
																	   		EnumEtiquetas.LBL_PGI_FORMA_PAGO,
																	   		true,
																	   		null,
																	   		true);
		}

		return this.lblFormaPago;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropTxtFormaPago
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtFormaPago
	 * @return	CajaTextoUtil
	 * 			Caja de texto gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	27/03/2018
	 * *********************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtFormaPago() throws Exception{
		
		if (this.txtFormaPago == null) {
			
			this.txtFormaPago = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_PGI_FORMA_PAGO, 
																			 	"txtFormaPago", 
																			 	"", 
																			 	true, 
																			 	false, 
																			 	true,
																			 	this.getEventoForma(),
																			 	EnumEtiquetas.LBL_PGI_FORMA_PAGO);
			this.txtFormaPago.setHorizontalAlignment(SwingConstants.LEFT);
		}

		return this.txtFormaPago;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblNotas
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblNotas
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	27/03/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblNotas() throws Exception{
		
		if (this.lblNotas == null) {
			
			this.lblNotas = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PGI_NOTAS, 
																	   	"lblNotas", 
																	   	EnumEtiquetas.LBL_PGI_NOTAS,
																	   	true,
																	   	null,
																	   	true);
		}

		return this.lblNotas;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropTxtNotas
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtNotas
	 * @return	CajaTextoUtil
	 * 			Caja de texto gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	27/03/2018
	 * *********************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtNotas() throws Exception{
		
		if (this.txtNotas == null) {
			
			this.txtNotas = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_PGI_NOTAS, 
																			"txtNotas", 
																			"", 
																			true, 
																			false, 
																			true,
																			this.getEventoForma(),
																			EnumEtiquetas.LBL_PGI_NOTAS);
		}

		return this.txtNotas;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblVlrPesos
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblVlrPesos
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	27/03/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblVlrPesos() throws Exception{
		
		if (this.lblVlrPesos == null) {
			
			this.lblVlrPesos = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PGI_VALOR_PESOS, 
																	   	   "lblVlrPesos", 
																	   	   EnumEtiquetas.LBL_PGI_VALOR_PESOS,
																	   	   true,
																	   	   null,
																	   	   true);
		}

		return this.lblVlrPesos;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropTxtVlrPesos
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtVlrPesos
	 * @return	CajaTextoUtil
	 * 			Caja de texto gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	27/03/2018
	 * *********************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtVlrPesos() throws Exception{
		
		if (this.txtVlrPesos == null) {
			
			this.txtVlrPesos = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_PGI_VALOR_PESOS, 
																			   "txtVlrPesos", 
																			   "", 
																			   true, 
																			   false, 
																			   true,
																			   this.getEventoForma(),
																			   EnumEtiquetas.LBL_PGI_VALOR_PESOS);
			this.txtVlrPesos.setHorizontalAlignment(SwingConstants.RIGHT);
		}

		return this.txtVlrPesos;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblVlrDolares
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblVlrDolares
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	27/03/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblVlrDolares() throws Exception{
		
		if (this.lblVlrDolares == null) {
			
			this.lblVlrDolares = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PGI_VALOR_DOLARES, 
																	   	     "lblVlrDolares", 
																	   	     EnumEtiquetas.LBL_PGI_VALOR_DOLARES,
																	   	     true,
																	   	     null,
																	   	     true);
		}

		return this.lblVlrDolares;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropTxtVlrDolares
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtVlrDolares
	 * @return	CajaTextoUtil
	 * 			Caja de texto gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	27/03/2018
	 * *********************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtVlrDolares() throws Exception{
		
		if (this.txtVlrDolares == null) {
			
			this.txtVlrDolares = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_PGI_VALOR_DOLARES, 
																			   "txtVlrDolares", 
																			   "", 
																			   true, 
																			   false, 
																			   true,
																			   this.getEventoForma(),
																			   EnumEtiquetas.LBL_PGI_VALOR_DOLARES);
			this.txtVlrDolares.setHorizontalAlignment(SwingConstants.RIGHT);
		}

		return this.txtVlrDolares;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblTasa
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblTasa
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	27/03/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblTasa() throws Exception{
		
		if (this.lblTasa == null) {
			
			this.lblTasa = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PGI_TASA, 
																	   "lblTasa", 
																	   EnumEtiquetas.LBL_PGI_TASA,
																	   true,
																	   null,
																	   true);
		}

		return this.lblTasa;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropTxtTasa
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtTasa
	 * @return	CajaTextoUtil
	 * 			Caja de texto gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	27/03/2018
	 * *********************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtTasa() throws Exception{
		
		if (this.txtTasa == null) {
			
			this.txtTasa = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_PGI_TASA, 
																		   "txtTasa", 
																		   "", 
																		   true, 
																		   false, 
																		   true,
																		   this.getEventoForma(),
																		   EnumEtiquetas.LBL_PGI_TASA);
			this.txtTasa.setHorizontalAlignment(SwingConstants.RIGHT);
		}

		return this.txtTasa;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblGMF
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblGMF
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	27/03/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblGMF() throws Exception{
		
		if (this.lblGMF == null) {
			
			this.lblGMF = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PGI_GMF, 
																	  "lblGMF", 
																	  EnumEtiquetas.LBL_PGI_GMF,
																	  true,
																	  null,
																	  true);
		}

		return this.lblGMF;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropTxtGMF
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtGMF
	 * @return	CajaTextoUtil
	 * 			Caja de texto gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	27/03/2018
	 * *********************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtGMF() throws Exception{
		
		if (this.txtGMF == null) {
			
			this.txtGMF = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_PGI_GMF, 
																		   "txtGMF", 
																		   "", 
																		   true, 
																		   false, 
																		   true,
																		   this.getEventoForma(),
																		   EnumEtiquetas.LBL_PGI_GMF);
			this.txtGMF.setHorizontalAlignment(SwingConstants.RIGHT);
		}

		return this.txtGMF;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblGastosAdmin
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblGastosAdmin
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	27/03/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblGastosAdmin() throws Exception{
		
		if (this.lblGastosAdmin == null) {
			
			this.lblGastosAdmin = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PGI_GASTOS_ADMIN, 
																	  		  "lblGastosAdmin", 
																	  		  EnumEtiquetas.LBL_PGI_GASTOS_ADMIN,
																	  		  true,
																	  		  null,
																	  		  true);
		}

		return this.lblGastosAdmin;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropTxtGastosAdmin
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtGastosAdmin
	 * @return	CajaTextoUtil
	 * 			Caja de texto gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	27/03/2018
	 * *********************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtGastosAdmin() throws Exception{
		
		if (this.txtGastosAdmin == null) {
			
			this.txtGastosAdmin = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_PGI_GASTOS_ADMIN, 
																		   "txtGastosAdmin", 
																		   "", 
																		   true, 
																		   false, 
																		   true,
																		   this.getEventoForma(),
																		   EnumEtiquetas.LBL_PGI_GASTOS_ADMIN);
			this.txtGastosAdmin.setHorizontalAlignment(SwingConstants.RIGHT);
		}

		return this.txtGastosAdmin;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblVlrProtegiro
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblVlrProtegiro
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	08/04/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblVlrProtegiro() throws Exception{
		
		if (this.lblVlrProtegiro == null) {
			
			this.lblVlrProtegiro = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PGI_VLR_PROTEGIRO, 
																	  		   "lblVlrProtegiro", 
																	  		   EnumEtiquetas.LBL_PGI_VLR_PROTEGIRO,
																	  		   true,
																	  		   null,
																	  		   true);
		}

		return this.lblVlrProtegiro;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropTxtVlrProtegiro
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtVlrProtegiro
	 * @return	CajaTextoUtil
	 * 			Caja de texto gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	08/04/2018
	 * *********************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtVlrProtegiro() throws Exception{
		
		if (this.txtVlrProtegiro == null) {
			
			this.txtVlrProtegiro = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_PGI_VLR_PROTEGIRO, 
																		   		   "txtVlrProtegiro", 
																		   		   "", 
																		   		   true, 
																		   		   false, 
																		   		   true,
																		   		   this.getEventoForma(),
																		   		   EnumEtiquetas.LBL_PGI_VLR_PROTEGIRO);
			this.txtVlrProtegiro.setHorizontalAlignment(SwingConstants.RIGHT);
		}

		return this.txtVlrProtegiro;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblVlrTotalPagar
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblVlrTotalPagar
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	08/04/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblVlrTotalPagar() throws Exception{
		
		if (this.lblVlrTotalPagar == null) {
			
			this.lblVlrTotalPagar = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PGI_VLR_TOTAL_PAGAR, 
																	  		    "lblVlrTotalPagar", 
																	  		    EnumEtiquetas.LBL_PGI_VLR_TOTAL_PAGAR,
																	  		    true,
																	  		    null,
																	  		    true);
		}

		return this.lblVlrTotalPagar;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropTxtVlrTotalPagar
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtVlrTotalPagar
	 * @return	CajaTextoUtil
	 * 			Caja de texto gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	08/04/2018
	 * *********************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtVlrTotalPagar() throws Exception{
		
		if (this.txtVlrTotalPagar == null) {
			
			this.txtVlrTotalPagar = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_PGI_VLR_TOTAL_PAGAR, 
																		   		   	"txtVlrTotalPagar", 
																		   		   	"", 
																		   		   	true, 
																		   		   	false, 
																		   		   	true,
																		   		   	this.getEventoForma(),
																		   		   	EnumEtiquetas.LBL_PGI_VLR_TOTAL_PAGAR);
			this.txtVlrTotalPagar.setHorizontalAlignment(SwingConstants.RIGHT);
		}

		return this.txtVlrTotalPagar;
	}
	
	/**
	 * @method	getPnlRemitente
	 * 		  	Metodo get del atributo pnlRemitente
	 * @return	SeccionUtil
	 *		  	Valor del atributo pnlRemitente devuelto
	 * @author	roberth.martinez
	 * @date  	25/03/2018
	 */
	public SeccionUtil getPnlRemitente() {
		return pnlRemitente;
	}

	/**
	 * @method	setPnlRemitente
	 * 		  	Metodo set del atributo pnlRemitente
	 * @param	pPnlRemitente
	 * 			Valor que tomara el atributo pnlRemitente
	 * @author	roberth.martinez
	 * @date	25/03/2018
	 */
	public void setPnlRemitente(SeccionUtil pPnlRemitente) {
		pnlRemitente = pPnlRemitente;
	}

	/**
	 * @method	getPnlBeneficiario
	 * 		  	Metodo get del atributo pnlBeneficiario
	 * @return	SeccionUtil
	 *		  	Valor del atributo pnlBeneficiario devuelto
	 * @author	roberth.martinez
	 * @date  	25/03/2018
	 */
	public SeccionUtil getPnlBeneficiario() {
		return pnlBeneficiario;
	}

	/**
	 * @method	setPnlBeneficiario
	 * 		  	Metodo set del atributo pnlBeneficiario
	 * @param	pPnlBeneficiario
	 * 			Valor que tomara el atributo pnlBeneficiario
	 * @author	roberth.martinez
	 * @date	25/03/2018
	 */
	public void setPnlBeneficiario(SeccionUtil pPnlBeneficiario) {
		pnlBeneficiario = pPnlBeneficiario;
	}

	/**
	 * @method	getPnlMotivosNumerales
	 * 		  	Metodo get del atributo pnlMotivosNumerales
	 * @return	SeccionUtil
	 *		  	Valor del atributo pnlMotivosNumerales devuelto
	 * @author	roberth.martinez
	 * @date  	25/03/2018
	 */
	public SeccionUtil getPnlMotivosNumerales() {
		return pnlMotivosNumerales;
	}

	/**
	 * @method	setPnlMotivosNumerales
	 * 		  	Metodo set del atributo pnlMotivosNumerales
	 * @param	pPnlMotivosNumerales
	 * 			Valor que tomara el atributo pnlMotivosNumerales
	 * @author	roberth.martinez
	 * @date	25/03/2018
	 */
	public void setPnlMotivosNumerales(SeccionUtil pPnlMotivosNumerales) {
		pnlMotivosNumerales = pPnlMotivosNumerales;
	}

	/**
	 * @method	getBtnGestionReclamos
	 * 		  	Metodo get del atributo btnGestionReclamos
	 * @return	BotonUtil
	 *		  	Valor del atributo btnGestionReclamos devuelto
	 * @author	roberth.martinez
	 * @date  	25/03/2018
	 */
	public BotonUtil getBtnGestionReclamos() {
		return btnGestionReclamos;
	}

	/**
	 * @method	setBtnGestionReclamos
	 * 		  	Metodo set del atributo btnGestionReclamos
	 * @param	pBtnGestionReclamos
	 * 			Valor que tomara el atributo btnGestionReclamos
	 * @author	roberth.martinez
	 * @date	25/03/2018
	 */
	public void setBtnGestionReclamos(BotonUtil pBtnGestionReclamos) {
		btnGestionReclamos = pBtnGestionReclamos;
	}

	/**
	 * @method	getBtnGestionSenalesAlerta
	 * 		  	Metodo get del atributo btnGestionSenalesAlerta
	 * @return	BotonUtil
	 *		  	Valor del atributo btnGestionSenalesAlerta devuelto
	 * @author	roberth.martinez
	 * @date  	25/03/2018
	 */
	public BotonUtil getBtnGestionSenalesAlerta() {
		return btnGestionSenalesAlerta;
	}

	/**
	 * @method	setBtnGestionSenalesAlerta
	 * 		  	Metodo set del atributo btnGestionSenalesAlerta
	 * @param	pBtnGestionSenalesAlerta
	 * 			Valor que tomara el atributo btnGestionSenalesAlerta
	 * @author	roberth.martinez
	 * @date	25/03/2018
	 */
	public void setBtnGestionSenalesAlerta(BotonUtil pBtnGestionSenalesAlerta) {
		btnGestionSenalesAlerta = pBtnGestionSenalesAlerta;
	}

	/**
	 * @method	getLblNombreTerceroRem
	 * 		  	Metodo get del atributo lblNombreTerceroRem
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblNombreTerceroRem devuelto
	 * @author	roberth.martinez
	 * @date  	26/03/2018
	 */
	public EtiquetaUtil getLblNombreTerceroRem() {
		return this.lblNombreTerceroRem;
	}

	/**
	 * @method	setLblNombreTerceroRem
	 * 		  	Metodo set del atributo lblNombreTerceroRem
	 * @param	pLblNombreTerceroRem
	 * 			Valor que tomara el atributo lblNombreTerceroRem
	 * @author	roberth.martinez
	 * @date	26/03/2018
	 */
	public void setLblNombreTerceroRem(EtiquetaUtil pLblNombreTerceroRem) {
		this.lblNombreTerceroRem = pLblNombreTerceroRem;
	}

	/**
	 * @method	getLblTelefonoTerceroRem
	 * 		  	Metodo get del atributo lblTelefonoTerceroRem
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblTelefonoTerceroRem devuelto
	 * @author	roberth.martinez
	 * @date  	26/03/2018
	 */
	public EtiquetaUtil getLblTelefonoTerceroRem() {
		return this.lblTelefonoTerceroRem;
	}

	/**
	 * @method	setLblTelefonoTerceroRem
	 * 		  	Metodo set del atributo lblTelefonoTerceroRem
	 * @param	pLblTelefonoTerceroRem
	 * 			Valor que tomara el atributo lblTelefonoTerceroRem
	 * @author	roberth.martinez
	 * @date	26/03/2018
	 */
	public void setLblTelefonoTerceroRem(EtiquetaUtil pLblTelefonoTerceroRem) {
		this.lblTelefonoTerceroRem = pLblTelefonoTerceroRem;
	}

	/**
	 * @method	getLblNombreTerceroBen
	 * 		  	Metodo get del atributo lblNombreTerceroBen
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblNombreTerceroBen devuelto
	 * @author	roberth.martinez
	 * @date  	26/03/2018
	 */
	public EtiquetaUtil getLblNombreTerceroBen() {
		return this.lblNombreTerceroBen;
	}

	/**
	 * @method	setLblNombreTerceroBen
	 * 		  	Metodo set del atributo lblNombreTerceroBen
	 * @param	pLblNombreTerceroBen
	 * 			Valor que tomara el atributo lblNombreTerceroBen
	 * @author	roberth.martinez
	 * @date	26/03/2018
	 */
	public void setLblNombreTerceroBen(EtiquetaUtil pLblNombreTerceroBen) {
		this.lblNombreTerceroBen = pLblNombreTerceroBen;
	}

	/**
	 * @method	getLblTelefonoTerceroBen
	 * 		  	Metodo get del atributo lblTelefonoTerceroBen
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblTelefonoTerceroBen devuelto
	 * @author	roberth.martinez
	 * @date  	26/03/2018
	 */
	public EtiquetaUtil getLblTelefonoTerceroBen() {
		return this.lblTelefonoTerceroBen;
	}

	/**
	 * @method	setLblTelefonoTerceroBen
	 * 		  	Metodo set del atributo lblTelefonoTerceroBen
	 * @param	pLblTelefonoTerceroBen
	 * 			Valor que tomara el atributo lblTelefonoTerceroBen
	 * @author	roberth.martinez
	 * @date	26/03/2018
	 */
	public void setLblTelefonoTerceroBen(EtiquetaUtil pLblTelefonoTerceroBen) {
		this.lblTelefonoTerceroBen = pLblTelefonoTerceroBen;
	}

	/**
	 * @method	getTxtNombreTerceroRem
	 * 		  	Metodo get del atributo txtNombreTerceroRem
	 * @return	CajaTextoUtil
	 *		  	Valor del atributo txtNombreTerceroRem devuelto
	 * @author	roberth.martinez
	 * @date  	26/03/2018
	 */
	public CajaTextoUtil getTxtNombreTerceroRem() {
		return this.txtNombreTerceroRem;
	}

	/**
	 * @method	setTxtNombreTerceroRem
	 * 		  	Metodo set del atributo txtNombreTerceroRem
	 * @param	pTxtNombreTerceroRem
	 * 			Valor que tomara el atributo txtNombreTerceroRem
	 * @author	roberth.martinez
	 * @date	26/03/2018
	 */
	public void setTxtNombreTerceroRem(CajaTextoUtil pTxtNombreTerceroRem) {
		this.txtNombreTerceroRem = pTxtNombreTerceroRem;
	}

	/**
	 * @method	getTxtTelefonoTerceroRem
	 * 		  	Metodo get del atributo txtTelefonoTerceroRem
	 * @return	CajaTextoUtil
	 *		  	Valor del atributo txtTelefonoTerceroRem devuelto
	 * @author	roberth.martinez
	 * @date  	26/03/2018
	 */
	public CajaTextoUtil getTxtTelefonoTerceroRem() {
		return this.txtTelefonoTerceroRem;
	}

	/**
	 * @method	setTxtTelefonoTerceroRem
	 * 		  	Metodo set del atributo txtTelefonoTerceroRem
	 * @param	pTxtTelefonoTerceroRem
	 * 			Valor que tomara el atributo txtTelefonoTerceroRem
	 * @author	roberth.martinez
	 * @date	26/03/2018
	 */
	public void setTxtTelefonoTerceroRem(CajaTextoUtil pTxtTelefonoTerceroRem) {
		this.txtTelefonoTerceroRem = pTxtTelefonoTerceroRem;
	}

	/**
	 * @method	getTxtNombreTerceroBen
	 * 		  	Metodo get del atributo txtNombreTerceroBen
	 * @return	CajaTextoUtil
	 *		  	Valor del atributo txtNombreTerceroBen devuelto
	 * @author	roberth.martinez
	 * @date  	26/03/2018
	 */
	public CajaTextoUtil getTxtNombreTerceroBen() {
		return this.txtNombreTerceroBen;
	}

	/**
	 * @method	setTxtNombreTerceroBen
	 * 		  	Metodo set del atributo txtNombreTerceroBen
	 * @param	pTxtNombreTerceroBen
	 * 			Valor que tomara el atributo txtNombreTerceroBen
	 * @author	roberth.martinez
	 * @date	26/03/2018
	 */
	public void setTxtNombreTerceroBen(CajaTextoUtil pTxtNombreTerceroBen) {
		this.txtNombreTerceroBen = pTxtNombreTerceroBen;
	}

	/**
	 * @method	getTxtTelefonoTerceroBen
	 * 		  	Metodo get del atributo txtTelefonoTerceroBen
	 * @return	CajaTextoUtil
	 *		  	Valor del atributo txtTelefonoTerceroBen devuelto
	 * @author	roberth.martinez
	 * @date  	26/03/2018
	 */
	public CajaTextoUtil getTxtTelefonoTerceroBen() {
		return this.txtTelefonoTerceroBen;
	}

	/**
	 * @method	setTxtTelefonoTerceroBen
	 * 		  	Metodo set del atributo txtTelefonoTerceroBen
	 * @param	pTxtTelefonoTerceroBen
	 * 			Valor que tomara el atributo txtTelefonoTerceroBen
	 * @author	roberth.martinez
	 * @date	26/03/2018
	 */
	public void setTxtTelefonoTerceroBen(CajaTextoUtil pTxtTelefonoTerceroBen) {
		this.txtTelefonoTerceroBen = pTxtTelefonoTerceroBen;
	}
	
	/**
	 * @method	getLblClienteTerceroBen
	 * 		  	Metodo get del atributo lblClienteTerceroBen
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblClienteTerceroBen devuelto
	 * @author	roberth.martinez
	 * @date  	26/03/2018
	 */
	public EtiquetaUtil getLblClienteTerceroBen() {
		return this.lblClienteTerceroBen;
	}

	/**
	 * @method	setLblClienteTerceroBen
	 * 		  	Metodo set del atributo lblClienteTerceroBen
	 * @param	pLblClienteTerceroBen
	 * 			Valor que tomara el atributo lblClienteTerceroBen
	 * @author	roberth.martinez
	 * @date	26/03/2018
	 */
	public void setLblClienteTerceroBen(EtiquetaUtil pLblClienteTerceroBen) {
		this.lblClienteTerceroBen = pLblClienteTerceroBen;
	}

	/**
	 * @method	getTxtClienteTerceroBen
	 * 		  	Metodo get del atributo txtClienteTerceroBen
	 * @return	CajaTextoUtil
	 *		  	Valor del atributo txtClienteTerceroBen devuelto
	 * @author	roberth.martinez
	 * @date  	26/03/2018
	 */
	public CajaTextoUtil getTxtClienteTerceroBen() {
		return this.txtClienteTerceroBen;
	}

	/**
	 * @method	setTxtClienteTerceroBen
	 * 		  	Metodo set del atributo txtClienteTerceroBen
	 * @param	pTxtClienteTerceroBen
	 * 			Valor que tomara el atributo txtClienteTerceroBen
	 * @author	roberth.martinez
	 * @date	26/03/2018
	 */
	public void setTxtClienteTerceroBen(CajaTextoUtil pTxtClienteTerceroBen) {
		this.txtClienteTerceroBen = pTxtClienteTerceroBen;
	}

	/**
	 * @method	getCmbMotivoRemesa
	 * 		  	Metodo get del atributo cmbMotivoRemesa
	 * @return	CajaComboUtil
	 *		  	Valor del atributo cmbMotivoRemesa devuelto
	 * @author	roberth.martinez
	 * @date  	26/03/2018
	 */
	public CajaComboUtil getCmbMotivoRemesa() {
		return cmbMotivoRemesa;
	}

	/**
	 * @method	setCmbMotivoRemesa
	 * 		  	Metodo set del atributo cmbMotivoRemesa
	 * @param	pCmbMotivoRemesa
	 * 			Valor que tomara el atributo cmbMotivoRemesa
	 * @author	roberth.martinez
	 * @date	26/03/2018
	 */
	public void setCmbMotivoRemesa(CajaComboUtil pCmbMotivoRemesa) {
		this.cmbMotivoRemesa = pCmbMotivoRemesa;
	}

	/**
	 * @method	getCmbNumerales
	 * 		  	Metodo get del atributo cmbNumerales
	 * @return	CajaComboUtil
	 *		  	Valor del atributo cmbNumerales devuelto
	 * @author	roberth.martinez
	 * @date  	26/03/2018
	 */
	public CajaComboUtil getCmbNumerales() {
		return cmbNumerales;
	}

	/**
	 * @method	setCmbNumerales
	 * 		  	Metodo set del atributo cmbNumerales
	 * @param	pCmbNumerales
	 * 			Valor que tomara el atributo cmbNumerales
	 * @author	roberth.martinez
	 * @date	26/03/2018
	 */
	public void setCmbNumerales(CajaComboUtil pCmbNumerales) {
		this.cmbNumerales = pCmbNumerales;
	}

	/**
	 * @method	getLblMotivoRemensa
	 * 		  	Metodo get del atributo lblMotivoRemensa
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblMotivoRemensa devuelto
	 * @author	roberth.martinez
	 * @date  	26/03/2018
	 */
	public EtiquetaUtil getLblMotivoRemensa() {
		return lblMotivoRemensa;
	}

	/**
	 * @method	setLblMotivoRemensa
	 * 		  	Metodo set del atributo lblMotivoRemensa
	 * @param	pLblMotivoRemensa
	 * 			Valor que tomara el atributo lblMotivoRemensa
	 * @author	roberth.martinez
	 * @date	26/03/2018
	 */
	public void setLblMotivoRemensa(EtiquetaUtil pLblMotivoRemensa) {
		this.lblMotivoRemensa = pLblMotivoRemensa;
	}

	/**
	 * @method	getLblNumerales
	 * 		  	Metodo get del atributo lblNumerales
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblNumerales devuelto
	 * @author	roberth.martinez
	 * @date  	26/03/2018
	 */
	public EtiquetaUtil getLblNumerales() {
		return lblNumerales;
	}

	/**
	 * @method	setLblNumerales
	 * 		  	Metodo set del atributo lblNumerales
	 * @param	pLblNumerales
	 * 			Valor que tomara el atributo lblNumerales
	 * @author	roberth.martinez
	 * @date	26/03/2018
	 */
	public void setLblNumerales(EtiquetaUtil pLblNumerales) {
		this.lblNumerales = pLblNumerales;
	}

	/**
	 * @method	getBtnCapturarFotos
	 * 		  	Metodo get del atributo btnCapturarFotos
	 * @return	BotonUtil
	 *		  	Valor del atributo btnCapturarFotos devuelto
	 * @author	roberth.martinez
	 * @date  	26/03/2018
	 */
	public BotonUtil getBtnCapturarFotos() {
		return btnCapturarFotos;
	}

	/**
	 * @method	setBtnCapturarFotos
	 * 		  	Metodo set del atributo btnCapturarFotos
	 * @param	pBtnCapturarFotos
	 * 			Valor que tomara el atributo btnCapturarFotos
	 * @author	roberth.martinez
	 * @date	26/03/2018
	 */
	public void setBtnCapturarFotos(BotonUtil pBtnCapturarFotos) {
		btnCapturarFotos = pBtnCapturarFotos;
	}

	/**
	 * @method	getLblFormaPago
	 * 		  	Metodo get del atributo lblFormaPago
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblFormaPago devuelto
	 * @author	roberth.martinez
	 * @date  	26/03/2018
	 */
	public EtiquetaUtil getLblFormaPago() {
		return lblFormaPago;
	}

	/**
	 * @method	setLblFormaPago
	 * 		  	Metodo set del atributo lblFormaPago
	 * @param	pLblFormaPago
	 * 			Valor que tomara el atributo lblFormaPago
	 * @author	roberth.martinez
	 * @date	26/03/2018
	 */
	public void setLblFormaPago(EtiquetaUtil pLblFormaPago) {
		lblFormaPago = pLblFormaPago;
	}

	/**
	 * @method	getLblNotas
	 * 		  	Metodo get del atributo lblNotas
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblNotas devuelto
	 * @author	roberth.martinez
	 * @date  	26/03/2018
	 */
	public EtiquetaUtil getLblNotas() {
		return lblNotas;
	}

	/**
	 * @method	setLblNotas
	 * 		  	Metodo set del atributo lblNotas
	 * @param	pLblNotas
	 * 			Valor que tomara el atributo lblNotas
	 * @author	roberth.martinez
	 * @date	26/03/2018
	 */
	public void setLblNotas(EtiquetaUtil pLblNotas) {
		lblNotas = pLblNotas;
	}

	/**
	 * @method	getLblVlrPesos
	 * 		  	Metodo get del atributo lblVlrPesos
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblVlrPesos devuelto
	 * @author	roberth.martinez
	 * @date  	26/03/2018
	 */
	public EtiquetaUtil getLblVlrPesos() {
		return lblVlrPesos;
	}

	/**
	 * @method	setLblVlrPesos
	 * 		  	Metodo set del atributo lblVlrPesos
	 * @param	pLblVlrPesos
	 * 			Valor que tomara el atributo lblVlrPesos
	 * @author	roberth.martinez
	 * @date	26/03/2018
	 */
	public void setLblVlrPesos(EtiquetaUtil pLblVlrPesos) {
		lblVlrPesos = pLblVlrPesos;
	}

	/**
	 * @method	getLblVlrDolares
	 * 		  	Metodo get del atributo lblVlrDolares
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblVlrDolares devuelto
	 * @author	roberth.martinez
	 * @date  	26/03/2018
	 */
	public EtiquetaUtil getLblVlrDolares() {
		return lblVlrDolares;
	}

	/**
	 * @method	setLblVlrDolares
	 * 		  	Metodo set del atributo lblVlrDolares
	 * @param	pLblVlrDolares
	 * 			Valor que tomara el atributo lblVlrDolares
	 * @author	roberth.martinez
	 * @date	26/03/2018
	 */
	public void setLblVlrDolares(EtiquetaUtil pLblVlrDolares) {
		lblVlrDolares = pLblVlrDolares;
	}

	/**
	 * @method	getLblTasa
	 * 		  	Metodo get del atributo lblTasa
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblTasa devuelto
	 * @author	roberth.martinez
	 * @date  	26/03/2018
	 */
	public EtiquetaUtil getLblTasa() {
		return lblTasa;
	}

	/**
	 * @method	setLblTasa
	 * 		  	Metodo set del atributo lblTasa
	 * @param	pLblTasa
	 * 			Valor que tomara el atributo lblTasa
	 * @author	roberth.martinez
	 * @date	26/03/2018
	 */
	public void setLblTasa(EtiquetaUtil pLblTasa) {
		lblTasa = pLblTasa;
	}

	/**
	 * @method	getLblGMF
	 * 		  	Metodo get del atributo lblGMF
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblGMF devuelto
	 * @author	roberth.martinez
	 * @date  	26/03/2018
	 */
	public EtiquetaUtil getLblGMF() {
		return lblGMF;
	}

	/**
	 * @method	setLblGMF
	 * 		  	Metodo set del atributo lblGMF
	 * @param	pLblGMF
	 * 			Valor que tomara el atributo lblGMF
	 * @author	roberth.martinez
	 * @date	26/03/2018
	 */
	public void setLblGMF(EtiquetaUtil pLblGMF) {
		lblGMF = pLblGMF;
	}

	/**
	 * @method	getLblGastosAdmin
	 * 		  	Metodo get del atributo lblGastosAdmin
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblGastosAdmin devuelto
	 * @author	roberth.martinez
	 * @date  	26/03/2018
	 */
	public EtiquetaUtil getLblGastosAdmin() {
		return lblGastosAdmin;
	}

	/**
	 * @method	setLblGastosAdmin
	 * 		  	Metodo set del atributo lblGastosAdmin
	 * @param	pLblGastosAdmin
	 * 			Valor que tomara el atributo lblGastosAdmin
	 * @author	roberth.martinez
	 * @date	26/03/2018
	 */
	public void setLblGastosAdmin(EtiquetaUtil pLblGastosAdmin) {
		lblGastosAdmin = pLblGastosAdmin;
	}

	/**
	 * @method	getTxtFormaPago
	 * 		  	Metodo get del atributo txtFormaPago
	 * @return	CajaTextoUtil
	 *		  	Valor del atributo txtFormaPago devuelto
	 * @author	roberth.martinez
	 * @date  	26/03/2018
	 */
	public CajaTextoUtil getTxtFormaPago() {
		return txtFormaPago;
	}

	/**
	 * @method	setTxtFormaPago
	 * 		  	Metodo set del atributo txtFormaPago
	 * @param	pTxtFormaPago
	 * 			Valor que tomara el atributo txtFormaPago
	 * @author	roberth.martinez
	 * @date	26/03/2018
	 */
	public void setTxtFormaPago(CajaTextoUtil pTxtFormaPago) {
		txtFormaPago = pTxtFormaPago;
	}

	/**
	 * @method	getTxtNotas
	 * 		  	Metodo get del atributo txtNotas
	 * @return	CajaTextoUtil
	 *		  	Valor del atributo txtNotas devuelto
	 * @author	roberth.martinez
	 * @date  	26/03/2018
	 */
	public CajaTextoUtil getTxtNotas() {
		return txtNotas;
	}

	/**
	 * @method	setTxtNotas
	 * 		  	Metodo set del atributo txtNotas
	 * @param	pTxtNotas
	 * 			Valor que tomara el atributo txtNotas
	 * @author	roberth.martinez
	 * @date	26/03/2018
	 */
	public void setTxtNotas(CajaTextoUtil pTxtNotas) {
		txtNotas = pTxtNotas;
	}

	/**
	 * @method	getTxtVlrPesos
	 * 		  	Metodo get del atributo txtVlrPesos
	 * @return	CajaTextoUtil
	 *		  	Valor del atributo txtVlrPesos devuelto
	 * @author	roberth.martinez
	 * @date  	26/03/2018
	 */
	public CajaTextoUtil getTxtVlrPesos() {
		return txtVlrPesos;
	}

	/**
	 * @method	setTxtVlrPesos
	 * 		  	Metodo set del atributo txtVlrPesos
	 * @param	pTxtVlrPesos
	 * 			Valor que tomara el atributo txtVlrPesos
	 * @author	roberth.martinez
	 * @date	26/03/2018
	 */
	public void setTxtVlrPesos(CajaTextoUtil pTxtVlrPesos) {
		txtVlrPesos = pTxtVlrPesos;
	}

	/**
	 * @method	getTxtVlrDolares
	 * 		  	Metodo get del atributo txtVlrDolares
	 * @return	CajaTextoUtil
	 *		  	Valor del atributo txtVlrDolares devuelto
	 * @author	roberth.martinez
	 * @date  	26/03/2018
	 */
	public CajaTextoUtil getTxtVlrDolares() {
		return txtVlrDolares;
	}

	/**
	 * @method	setTxtVlrDolares
	 * 		  	Metodo set del atributo txtVlrDolares
	 * @param	pTxtVlrDolares
	 * 			Valor que tomara el atributo txtVlrDolares
	 * @author	roberth.martinez
	 * @date	26/03/2018
	 */
	public void setTxtVlrDolares(CajaTextoUtil pTxtVlrDolares) {
		txtVlrDolares = pTxtVlrDolares;
	}

	/**
	 * @method	getTxtTasa
	 * 		  	Metodo get del atributo txtTasa
	 * @return	CajaTextoUtil
	 *		  	Valor del atributo txtTasa devuelto
	 * @author	roberth.martinez
	 * @date  	26/03/2018
	 */
	public CajaTextoUtil getTxtTasa() {
		return txtTasa;
	}

	/**
	 * @method	setTxtTasa
	 * 		  	Metodo set del atributo txtTasa
	 * @param	pTxtTasa
	 * 			Valor que tomara el atributo txtTasa
	 * @author	roberth.martinez
	 * @date	26/03/2018
	 */
	public void setTxtTasa(CajaTextoUtil pTxtTasa) {
		txtTasa = pTxtTasa;
	}

	/**
	 * @method	getTxtGMF
	 * 		  	Metodo get del atributo txtGMF
	 * @return	CajaTextoUtil
	 *		  	Valor del atributo txtGMF devuelto
	 * @author	roberth.martinez
	 * @date  	26/03/2018
	 */
	public CajaTextoUtil getTxtGMF() {
		return txtGMF;
	}

	/**
	 * @method	setTxtGMF
	 * 		  	Metodo set del atributo txtGMF
	 * @param	pTxtGMF
	 * 			Valor que tomara el atributo txtGMF
	 * @author	roberth.martinez
	 * @date	26/03/2018
	 */
	public void setTxtGMF(CajaTextoUtil pTxtGMF) {
		txtGMF = pTxtGMF;
	}

	/**
	 * @method	getTxtGastosAdmin
	 * 		  	Metodo get del atributo txtGastosAdmin
	 * @return	CajaTextoUtil
	 *		  	Valor del atributo txtGastosAdmin devuelto
	 * @author	roberth.martinez
	 * @date  	26/03/2018
	 */
	public CajaTextoUtil getTxtGastosAdmin() {
		return txtGastosAdmin;
	}

	/**
	 * @method	setTxtGastosAdmin
	 * 		  	Metodo set del atributo txtGastosAdmin
	 * @param	pTxtGastosAdmin
	 * 			Valor que tomara el atributo txtGastosAdmin
	 * @author	roberth.martinez
	 * @date	26/03/2018
	 */
	public void setTxtGastosAdmin(CajaTextoUtil pTxtGastosAdmin) {
		txtGastosAdmin = pTxtGastosAdmin;
	}

	/**
	 * @method	getLblVlrProtegiro
	 * 		  	Metodo get del atributo lblVlrProtegiro
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblVlrProtegiro devuelto
	 * @author	roberth.martinez
	 * @date  	8/04/2018
	 */
	public EtiquetaUtil getLblVlrProtegiro() {
		return lblVlrProtegiro;
	}

	/**
	 * @method	setLblVlrProtegiro
	 * 		  	Metodo set del atributo lblVlrProtegiro
	 * @param	pLblVlrProtegiro
	 * 			Valor que tomara el atributo lblVlrProtegiro
	 * @author	roberth.martinez
	 * @date	8/04/2018
	 */
	public void setLblVlrProtegiro(EtiquetaUtil pLblVlrProtegiro) {
		lblVlrProtegiro = pLblVlrProtegiro;
	}

	/**
	 * @method	getLblVlrTotalPagar
	 * 		  	Metodo get del atributo lblVlrTotalPagar
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblVlrTotalPagar devuelto
	 * @author	roberth.martinez
	 * @date  	8/04/2018
	 */
	public EtiquetaUtil getLblVlrTotalPagar() {
		return lblVlrTotalPagar;
	}

	/**
	 * @method	setLblVlrTotalPagar
	 * 		  	Metodo set del atributo lblVlrTotalPagar
	 * @param	pLblVlrTotalPagar
	 * 			Valor que tomara el atributo lblVlrTotalPagar
	 * @author	roberth.martinez
	 * @date	8/04/2018
	 */
	public void setLblVlrTotalPagar(EtiquetaUtil pLblVlrTotalPagar) {
		lblVlrTotalPagar = pLblVlrTotalPagar;
	}

	/**
	 * @method	getTxtVlrProtegiro
	 * 		  	Metodo get del atributo txtVlrProtegiro
	 * @return	CajaTextoUtil
	 *		  	Valor del atributo txtVlrProtegiro devuelto
	 * @author	roberth.martinez
	 * @date  	8/04/2018
	 */
	public CajaTextoUtil getTxtVlrProtegiro() {
		return txtVlrProtegiro;
	}

	/**
	 * @method	setTxtVlrProtegiro
	 * 		  	Metodo set del atributo txtVlrProtegiro
	 * @param	pTxtVlrProtegiro
	 * 			Valor que tomara el atributo txtVlrProtegiro
	 * @author	roberth.martinez
	 * @date	8/04/2018
	 */
	public void setTxtVlrProtegiro(CajaTextoUtil pTxtVlrProtegiro) {
		txtVlrProtegiro = pTxtVlrProtegiro;
	}

	/**
	 * @method	getTxtVlrTotalPagar
	 * 		  	Metodo get del atributo txtVlrTotalPagar
	 * @return	CajaTextoUtil
	 *		  	Valor del atributo txtVlrTotalPagar devuelto
	 * @author	roberth.martinez
	 * @date  	8/04/2018
	 */
	public CajaTextoUtil getTxtVlrTotalPagar() {
		return txtVlrTotalPagar;
	}

	/**
	 * @method	setTxtVlrTotalPagar
	 * 		  	Metodo set del atributo txtVlrTotalPagar
	 * @param	pTxtVlrTotalPagar
	 * 			Valor que tomara el atributo txtVlrTotalPagar
	 * @author	roberth.martinez
	 * @date	8/04/2018
	 */
	public void setTxtVlrTotalPagar(CajaTextoUtil pTxtVlrTotalPagar) {
		txtVlrTotalPagar = pTxtVlrTotalPagar;
	}

	/** 
	 * ********************************************************************
	 * @method 	main
	 * 		   	Metodo principal (main), para realizar una prueba de unidad
	 * 			de la forma
	 * @param 	args
	 * 			Cadena de argumentos demandada por el metodo principal (main)
	 * @author 	roberth.martinez
	 * @date   	25/03/2018
	 * *********************************************************************
	 */
	public static void main(String[] args) {
		
		try{
			FacturaGiroInternacional objFacturaGiroInternacional = new FacturaGiroInternacional();
			//A,B,C,D,508,0,91111056868,1|5209|SARA ISABEL OLANO RODRIGUEZ|*|*|*|MORTICIA LINA OLANO ANDRADE|COL|CLO|3114521171|CALI|EFE|17/03/2018 00:00:00|COP|121845|45|2721|30A32F9880|*|*|U|S|S|0|*|*|32|*|S|*|*|600|N|32-500384|2000|*|S
			String pStrTramaGiroXReferencia;
			TipoDocumentoInternacional objTipoDocumento = new TipoDocumentoInternacional();
			objTipoDocumento.setId("CC");
			objTipoDocumento.setValor("CEDULA DE CIUDADANIA");
			String strIdentificacion = "1006071500";
			
			
			pStrTramaGiroXReferencia = "1|5309|SARA ISABEL OLANO RODRIGUEZ|*|*|*|MORTICIA LINA OLANO ANDRADE|COL|CLO|3114521171|CALI|EFE|17/03/2018 00:00:00|COP|121845|45|2721|30A32F9880|*|*|U|S|S|0|*|*|32|*|S|*|*|600|N|32-500384|2000|*|S";
			
			
			StringTokenizer stkElementosTramaConsultaGiroXReferencia;
			Agencia objAgenciaPago;
			Corresponsal objCorresponsal;
			TerceroInternacional objTreceroRem;
			TerceroInternacional objTreceroBen;
			TerritorioInternacional objTerritorioCiudadRem;
			TerritorioInternacional objTerritorioPaisRem;
			TerritorioInternacional objTerritorioCiudadBen;
			TerritorioInternacional objTerritorioPaisBen;
			MedioPago objMedioPago;
			Moneda objMonedaPago;
			String strActualizaClienteUsuario;
			
			List<MedioPago> lstMedioPago = new ArrayList<>();
			//pStrTramaGiroXReferencia = "1|5178|SARA ISABEL OLANO RODRIGUEZ|*|*|*|MORTICIA LINA OLANO ANDRADE|COL|CLO|3114521171|CALI|EFE|17/03/2018 00:00:00|COP|121845|45|2721|30A32F9880|*|*|N|S|S|0|*|*|32|*|S|D|I|600|N|32-500384|2000|*|S";
			stkElementosTramaConsultaGiroXReferencia = new StringTokenizer	(pStrTramaGiroXReferencia,
			                                                   	 			 EnumGeneralidadesTramasGiros.PIPE.getValor());
			
			objFacturaGiroInternacional = new FacturaGiroInternacional();
			objFacturaGiroInternacional.setStrCodEstadoGiro(stkElementosTramaConsultaGiroXReferencia.nextToken());
			objFacturaGiroInternacional.setStrIdTtransaccion(stkElementosTramaConsultaGiroXReferencia.nextToken());
			
			objTreceroRem = new TerceroInternacional();
			objTreceroRem.setNombres(stkElementosTramaConsultaGiroXReferencia.nextToken());
			objTreceroRem.setTelefono1(stkElementosTramaConsultaGiroXReferencia.nextToken());
			objTerritorioCiudadRem = new TerritorioInternacional();
			objTerritorioCiudadRem.setCodigo(stkElementosTramaConsultaGiroXReferencia.nextToken());
			objTerritorioPaisRem = new TerritorioInternacional();
			objTerritorioPaisRem.setCodigo(stkElementosTramaConsultaGiroXReferencia.nextToken());
			objTerritorioCiudadRem.setTerritorioPadre(new TerritorioInternacional());//Departamento
			objTerritorioCiudadRem.getTerritorioPadre().setTerritorioPadre(objTerritorioPaisRem);
			objTreceroRem.setObjTrrCiudadResidencia(objTerritorioCiudadRem);
			//objTreceroRem.setObjTrrPaisResidencia(objTerritorioPaisRem);
			objFacturaGiroInternacional.setTerceroOrigen(objTreceroRem);
			
			objTreceroBen = new TerceroInternacional();
			objTreceroBen.setNombres(stkElementosTramaConsultaGiroXReferencia.nextToken());
			objTerritorioPaisBen = new TerritorioInternacional();
			objTerritorioPaisBen.setCodigo(stkElementosTramaConsultaGiroXReferencia.nextToken());
			objTerritorioCiudadBen = new TerritorioInternacional();
			objTerritorioCiudadBen.setCodigo(stkElementosTramaConsultaGiroXReferencia.nextToken());
			objTerritorioCiudadBen.setTerritorioPadre(new TerritorioInternacional());//Departamento
			objTerritorioCiudadBen.getTerritorioPadre().setTerritorioPadre(objTerritorioPaisBen);
			objTreceroBen.setObjTrrCiudadResidencia(objTerritorioCiudadBen);
			//objTreceroBen.setObjTrrPaisResidencia(objTerritorioPaisBen);
			objTreceroBen.setTelefono1(stkElementosTramaConsultaGiroXReferencia.nextToken());
			objTreceroBen.setTipoIdentificacion(objTipoDocumento);
			objTreceroBen.setIdentificacion(strIdentificacion);
			
			objFacturaGiroInternacional.setObjNota(new Nota(stkElementosTramaConsultaGiroXReferencia.nextToken()));
			objMedioPago = new MedioPago();
			objMedioPago.setCodigo(stkElementosTramaConsultaGiroXReferencia.nextToken());
			
			objFacturaGiroInternacional.setFechaGiro(stkElementosTramaConsultaGiroXReferencia.nextToken());
			
			objMonedaPago = new Moneda();
			objMonedaPago.setCodigo(stkElementosTramaConsultaGiroXReferencia.nextToken());
			objMedioPago.setMoneda(objMonedaPago);
			lstMedioPago.add(objMedioPago);
			objFacturaGiroInternacional.setListMediosPago(lstMedioPago);
			
			objFacturaGiroInternacional.setTotal(Double.parseDouble(stkElementosTramaConsultaGiroXReferencia.nextToken()));
			objFacturaGiroInternacional.setDouValorEnDolar(Double.parseDouble(stkElementosTramaConsultaGiroXReferencia.nextToken()));
			objFacturaGiroInternacional.setStrTMR(stkElementosTramaConsultaGiroXReferencia.nextToken());
			objFacturaGiroInternacional.setReferenciaControl(stkElementosTramaConsultaGiroXReferencia.nextToken());
			
			objAgenciaPago = new Agencia();
			objAgenciaPago.setCodigo(stkElementosTramaConsultaGiroXReferencia.nextToken());
			objFacturaGiroInternacional.setAgenciaDestino(objAgenciaPago);
			
			objTreceroBen.setObjDtoConfigTerceroInternacional(new ConfigTerceroInternacionalDTO());
			
			objFacturaGiroInternacional.setStrFechaPago(stkElementosTramaConsultaGiroXReferencia.nextToken());
			strActualizaClienteUsuario = stkElementosTramaConsultaGiroXReferencia.nextToken();
			if(strActualizaClienteUsuario.matches("C|U")){
				objTreceroBen.getObjDtoConfigTerceroInternacional().setObjBooActualizaClienteUsuario(strActualizaClienteUsuario.equals("C")?true:false);	
			}
			
			//objTreceroBen.setStrActualizaClienteUsuario(stkElementosTramaConsultaGiroXReferencia.nextToken());
			objTreceroBen.getObjDtoConfigTerceroInternacional().setBooEnviarFotos(stkElementosTramaConsultaGiroXReferencia.nextToken().equals("S"));
			//objFacturaGiroInternacional.setBooEnviarFotos(stkElementosTramaConsultaGiroXReferencia.nextToken().equals("S"));
			objTreceroBen.getObjDtoConfigTerceroInternacional().setBooEnviarHuella(stkElementosTramaConsultaGiroXReferencia.nextToken().equals("S"));
			//objFacturaGiroInternacional.setBooEnviaHuella(stkElementosTramaConsultaGiroXReferencia.nextToken().equals("S"));
			objFacturaGiroInternacional.setDouGMF(Double.parseDouble(stkElementosTramaConsultaGiroXReferencia.nextToken()));
			objFacturaGiroInternacional.setStrUrlGiroExterno(stkElementosTramaConsultaGiroXReferencia.nextToken());
			objFacturaGiroInternacional.setStrTimeOut(stkElementosTramaConsultaGiroXReferencia.nextToken());
			
			objCorresponsal = new Corresponsal(stkElementosTramaConsultaGiroXReferencia.nextToken());
			objFacturaGiroInternacional.setObjCorresponsal(objCorresponsal);
			stkElementosTramaConsultaGiroXReferencia.nextToken();
			objFacturaGiroInternacional.setLstSenalesAlerta(null);
			objTreceroBen.getObjDtoConfigTerceroInternacional().setBooEnviarImagenHuella(stkElementosTramaConsultaGiroXReferencia.nextToken().equals("S"));
			//objFacturaGiroInternacional.setBooEnviaImgHuella(stkElementosTramaConsultaGiroXReferencia.nextToken().equals("S"));
			
			objTreceroBen.getObjDtoConfigTerceroInternacional().setStrCodigoTipoMano(stkElementosTramaConsultaGiroXReferencia.nextToken());
			objTreceroBen.getObjDtoConfigTerceroInternacional().setStrCodigoTipoDedo(stkElementosTramaConsultaGiroXReferencia.nextToken());
			//objHuellaCapturar = new HuellaBiometria();
			//objHuellaCapturar.setStrTipo(stkElementosTramaConsultaGiroXReferencia.nextToken());//codigo mano
			//objHuellaCapturar.setStrTipoDedo(stkElementosTramaConsultaGiroXReferencia.nextToken());//codigo dedo
			//objTreceroBen.getObjBiometria().setHuellaCapturada(objHuellaCapturar);
			
			objFacturaGiroInternacional.setStrGastosAdministrativos(stkElementosTramaConsultaGiroXReferencia.nextToken());
			objTreceroBen.getObjDtoConfigTerceroInternacional().setBooTerceroNuevo(stkElementosTramaConsultaGiroXReferencia.nextToken().equals("N"));
			//objTreceroBen.setStrClienteUsuarioNuevoAntiguo(stkElementosTramaConsultaGiroXReferencia.nextToken());
			objFacturaGiroInternacional.setTerceroDestino(objTreceroBen);
			objFacturaGiroInternacional.setStrNumeroConsecutivoFPISA(stkElementosTramaConsultaGiroXReferencia.nextToken());
			objFacturaGiroInternacional.setDouValorPrima(Double.parseDouble(stkElementosTramaConsultaGiroXReferencia.nextToken()));
			objFacturaGiroInternacional.setStrDescripcionProtegiro(stkElementosTramaConsultaGiroXReferencia.nextToken());
			objFacturaGiroInternacional.setStrProtegiroInducido(stkElementosTramaConsultaGiroXReferencia.nextToken());
			
			objFacturaGiroInternacional.setBooConsultaXReferencia(true);
	        
			TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaPagoGiroInternacional.class,
																   true, 
																   EnumDesplegarFormaConEventos.NO);
			new FormaPagoGiroInternacional(null,
							  			   true,
							  			   objFacturaGiroInternacional);
			
		} catch (Exception e) {
			
			UtilidadesGiros.getInstance().controlExcepcion(e, 
														   null);
		}
	}
}

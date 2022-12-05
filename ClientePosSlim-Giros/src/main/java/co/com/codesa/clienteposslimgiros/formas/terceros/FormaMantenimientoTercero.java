package co.com.codesa.clienteposslimgiros.formas.terceros;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import co.com.codesa.client.tangibles.ParametrosAplicacion;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.operaciones.EnumTiposOperaciones;
import co.com.codesa.clienteposslimgiros.eventos.terceros.EventoFormaMantenimientoTercero;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaFechaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaVerificadaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelTerritorio;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelDireccion;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.utilidades.xml.XmlDatosEntidades;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DatoEntidad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 19-may-2015 
 * @Clase FormaMantenimientoTercero
 * 		  Clase que genera la forma (GUI) para gestionar y/o 
 * 		  diligenciar el mantenimiento de la informacion relacionada
 * 		  con el tercero, permitiendo la creacion o actualizacion del
 * 		  objeto de negocio tercero
 * @copyright Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class FormaMantenimientoTercero extends FormaGenerica{

	private static final long serialVersionUID = 1L;
	
	private JPanel pnlExpedicion;
	
	private FormaPanelTerritorio pnlTerritorioExpedicion;
	
	private FormaPanelDireccion pnlDireccion;
	
	private CajaComboUtil cmbTipoIdentificacion;
	
	private CajaComboUtil cmbTipoPersona;

	private CajaComboUtil cmbActividadesEconomicas;
	
	private CajaTextoUtil txtIdentificacion;
	
	private CajaTextoUtil txtPrimerApellido;
	
	private CajaTextoUtil txtSegundoApellido;
	
	private CajaTextoUtil txtNombres;
	
	private CajaTextoUtil txtTelefono;
	
	private CajaTextoUtil txtCelular;
	
	private CajaTextoUtil txtCorreoElectronico;
	
	private CajaFechaUtil dtcFechaNacimiento;
	
	private CajaFechaUtil dtcFechaEntradaPais;
	
	private CajaFechaUtil dtcFechaVencimiento;
	
	private CajaFechaUtil dtcFechaExpedicion;
	
	private CajaVerificadaUtil chkAutoRetenedor;
	
	private EtiquetaUtil lblDocumento;
	
	private EtiquetaUtil lblTipoPersona;
	
	private EtiquetaUtil lblFechaNacimiento;
	
	private EtiquetaUtil lblFechaEntradaPais;
	
	private EtiquetaUtil lblFechaVencimiento;
	
	private EtiquetaUtil lblFechaExpedicion;
	
	private EtiquetaUtil lblPrimerApellido;
	
	private EtiquetaUtil lblSegundoApellido;
	
	private EtiquetaUtil lblNombres;
	
	private EtiquetaUtil lblTelefono;
	
	private EtiquetaUtil lblCelular;
	
	private EtiquetaUtil lblCorreoElectronico;
	
	private EtiquetaUtil lblActividadEconomica;
	
	private CajaComboUtil cmbTerceroPeps;
	
	private EtiquetaUtil lblTerceroPeps;
	
	/**
  	 * ****************************************************************.
  	 * @metodo FormaMantenimientoTercero
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de la forma
  	 * @param pFrmPadre 
  	 * 		  ventana de la cual extiende esta forma
  	 * @param pBooModal 
  	 * 		  bandera que permite efectuar la forma de manera modal sobre 
  	 * 		  la ventana de la cual extiende
  	 * @param pBooTerceroPresente 
  	 * 		  bandera que permite identificar al momento del proceso de 
  	 * 		  mantenimiento si se habilita y se coloca a disposicion para
  	 * 		  completar la informacion relacionada con el documento del 
  	 * 		  tercero
  	 * @param pObjTercero
  	 * 		  tercero al cual se le efecutara el mantenimiento de su 
  	 * 		  informacion, en este caso su actualizacion
  	 * @param pEnmTipoOperacion
  	 * 		  tipoOperacion
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaMantenimientoTercero(FormaGenerica pFrmPadre,
						  			 boolean pBooModal,
						  			 EnumTiposOperaciones pEnmTipoOperacion,
						  			 boolean pBooTerceroPresente,
						  			 Tercero pObjTercero,
						  			 boolean pBooActivaValidacionTerceroPeps,
						  			 boolean pBooTerceroNuevoRedExterna) throws Exception{
		super(pFrmPadre,
			  pBooModal);
		
		super.setEventoForma(new EventoFormaMantenimientoTercero(this,
																 pBooTerceroPresente,
																 pEnmTipoOperacion,
																 pObjTercero,
																 pBooActivaValidacionTerceroPeps,
																 pBooTerceroNuevoRedExterna));
		this.inicializarForma();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo FormaMantenimientoTercero
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de la forma
  	 * @param pFrmPadre 
  	 * 		  ventana de la cual extiende esta forma
  	 * @param pBooModal 
  	 * 		  bandera que permite efectuar la forma de manera modal sobre 
  	 * 		  la ventana de la cual extiende
  	 * @param pBooDisponibleInformacionDocumento 
  	 * 		  bandera que permite identificar al momento del proceso de 
  	 * 		  mantenimiento si se habilita y se coloca a disposicion para
  	 * 		  completar la informacion relacionada con el documento del 
  	 * 		  tercero
  	 * @param pObjDatEntTipoId
  	 * 		  tipo de identificacion asociado al tercero con el cual se 
  	 * 		  realizara el proceso de mantenimiento, que para este caso
  	 * 		  corresponde a su creacion
  	 * @param pStrIdentificacion
  	 * 		  identificacion asociada al tercero con la cual se realizara
  	 * 		  el proceso de mantenimiento, que para este caso corresponde 
  	 * 		  a su creacion
  	 * @param pEnmTipoOperacion
  	 * 		  Tipo Operacion que se esta realizando para procesar la peticion
  	 * 		  del mantenimiento tercero
  	 * @param pStrDescripcionTercero
  	 * 		  Descripcion del tipo de tercero que se va registrar en el sistema
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaMantenimientoTercero(FormaGenerica pFrmPadre,
						  			 boolean pBooModal,
						  			 boolean pBooDisponibleInformacionDocumento,
						  			 EnumTiposOperaciones pEnmTipoOperacion,
						  			 DatoEntidad pObjDatEntTipoId,
						  			 String pStrIdentificacion,
						  			 String pStrDescripcionTercero,
						  			boolean pBooActivaValidacionTerceroPeps) throws Exception{
		super(pFrmPadre,				
			  pBooModal);
		
		super.setEventoForma(new EventoFormaMantenimientoTercero(this,
																 pBooDisponibleInformacionDocumento,
																 pEnmTipoOperacion,
																 pObjDatEntTipoId,
																 pStrIdentificacion,
																 pStrDescripcionTercero,
																 pBooActivaValidacionTerceroPeps));
		
		this.inicializarForma();
	}

	/**
  	 * ****************************************************************.
  	 * @metodo inicializarForma
  	 * 		   Metodo propuesto por la forma generica, para inicializar 
  	 * 		   todos los aspectos de la forma
  	 * @param pArrObjParametrosForma 
  	 * 		  lista de posibles parametros a incluir sobre la inicializacion 
  	 * 		  de la forma
  	 * 		  [x]: descripcion del valor enviado en la posicion [x]
  	 * 		  [0]: direccion previamente diligenciada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public void inicializarForma(Object ...pArrObjParametrosForma) throws Exception{
		
		super.setTituloForma(EnumEtiquetas.TTL_MNT_TERC_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.GUI_MNT_TERC_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.GUI_MNT_TERC_VENTANA.getAlto());
		
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
								EnumBotonesEncabezado.BTN_LIMPIAR,
						  		EnumBotonesEncabezado.BTNVOLVER
						  		);
		
		super.iniciar(pArrObjParametrosForma);
	}

	/**
  	 * ****************************************************************.
  	 * @metodo inicializarEncabezado
  	 * 		   Metodo dedicado a inicializar y gestionar el encabezado 
  	 * 		   de la forma (seccion superior)
  	 * @param pArrObjParametrosForma
  	 * 		  lista de posibles parametros a incluir sobre la inicializacion 
  	 * 		  de la seccion del encabezado
  	 * 		  [x]: descripcion del valor enviado en la posicion [x]
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public JPanel inicializarEncabezado(Object ...pArrObjParametrosForma) throws Exception {
		return null;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo inicializarCuerpo
  	 * 		   Metodo dedicado a inicializar y gestionar el cuerpo 
  	 * 		   de la forma (seccion central)
  	 * @param pArrObjParametrosCuerpo
  	 * 		  lista de posibles parametros a incluir sobre la inicializacion 
  	 * 		  de la seccion del cuerpo
  	 * 		  [x]: descripcion del valor enviado en la posicion [x]
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public JPanel inicializarCuerpo(Object ...pArrObjParametrosCuerpo) throws Exception{
		
		JPanel pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_MNT_TERC_CUERPO,
																"pnlCuerpo",
																null,
																null,
																null);
		pnlCuerpo.add(this.iniciarPropLblDocumento());
		pnlCuerpo.add(this.iniciarPropCmbTipoIdentificacion());
		pnlCuerpo.add(this.iniciarPropTxtIdentificacion());
		pnlCuerpo.add(this.iniciarPropLblTipoPersona());
		pnlCuerpo.add(this.iniciarPropCmbTipoPersona());
		pnlCuerpo.add(this.iniciarPropLblFechaNacimiento());
		pnlCuerpo.add(this.iniciarPropDtcFechaNacimiento());
		pnlCuerpo.add(this.iniciarPropLblFechaEntradaPais());
		pnlCuerpo.add(this.iniciarPropDtcFechaEntradaPais());
		pnlCuerpo.add(this.iniciarPropLblFechaVencimiento());
		pnlCuerpo.add(this.iniciarPropDtcFechaVencimiento());
		pnlCuerpo.add(this.iniciarPropPnlExpedicion());
		
		return pnlCuerpo;
	}

	/**
  	 * ****************************************************************.
  	 * @metodo inicializarPiePagina
  	 * 		   Metodo dedicado a inicializar y gestionar el pie de pagina 
  	 * 		   de la forma (seccion inferior)
  	 * @param pArrObjParametrosPiePagina
  	 * 		  lista de posibles parametros a incluir sobre la inicializacion 
  	 * 		  de la seccion de pie de pagina
  	 * 		  [x]: descripcion del valor enviado en la posicion [x]
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public JPanel inicializarPiePagina(Object ...pArrObjParametrosPiePagina) throws Exception{
		
		JPanel pnlPiePagina;
		
		pnlPiePagina = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_MNT_TERC_PIE_PAGINA,
																   "pnlPiePagina",
																   null,
																   null,
																   null);
		pnlPiePagina.add(this.iniciarPropLblPrimerApellido());
		pnlPiePagina.add(this.iniciarPropTxtPrimerApellido());
		pnlPiePagina.add(this.iniciarPropLblSegundoApellido());
		pnlPiePagina.add(this.iniciarPropTxtSegundoApellido());
		pnlPiePagina.add(this.iniciarPropLblNombres());
		pnlPiePagina.add(this.iniciarPropTxtNombres());
		pnlPiePagina.add(this.iniciarPropPnlDireccion());
		pnlPiePagina.add(this.iniciarPropLblTelefono());
		pnlPiePagina.add(this.iniciarPropTxtTelefono());
		pnlPiePagina.add(this.iniciarPropLblCelular());
		pnlPiePagina.add(this.iniciarPropTxtCelular());
		pnlPiePagina.add(this.iniciarPropLblCorreoElectronico());
		pnlPiePagina.add(this.iniciarPropTxtCorreoElectronico());
		pnlPiePagina.add(this.iniciarPropLblActividadEconomica());
		pnlPiePagina.add(this.iniciarPropCmbActividadesEconomicas());
		pnlPiePagina.add(this.iniciarPropChkAutoRetenedor());
		pnlPiePagina.add(this.iniciarPropLblTerceroPeps());
		pnlPiePagina.add(this.iniciarPropCmbTerceroPeps());
		
		return pnlPiePagina;
	}

	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropPnlExpedicion
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pnlExpedicion
  	 * @return JPanel 
  	 * 		   seccion de cuerpo gestionada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public JPanel iniciarPropPnlExpedicion() throws Exception{
		
		if(this.pnlExpedicion==null){
			
			this.pnlExpedicion = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_MNT_TERC_EXPEDICION,
																			 "pnlExpedicion",
																  		  	 null,
																  		  	 EnumEtiquetas.TTL_MNT_TERC_PNL_EXPEDICION,
																  		  	 null
																  		  	 );
			this.pnlExpedicion.add(this.iniciarPropLblFechaExpedicion());
			this.pnlExpedicion.add(this.iniciarPropDtcFechaExpedicion());
			this.pnlExpedicion.add(this.iniciarPropPnlTerritorioExpedicion());
		}
		
		return this.pnlExpedicion;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropPnlTerritorioExpedicion
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pnlTerritorioExpedicion
  	 * @return FormaPanelTerritorio 
  	 * 		   seccion de territorio de expedicion gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaPanelTerritorio iniciarPropPnlTerritorioExpedicion() throws Exception{
		
		if(this.pnlTerritorioExpedicion==null){
			
			this.pnlTerritorioExpedicion = new FormaPanelTerritorio("pnlTerritorioExpedicion",
																	false,//pTitulos
					 											    true,//pTituloCombo
					 											    new String[]{"cmbPaisExpedicion",
																			     "cmbDepartamentoExpedicion",
																			     "cmbMunicipioExpedicion"},
				 												    2,//pCategoria
				 												    false,//pAPartir
				 												    false,//pActivaAgencia
				 												    EnumDimensionesComponentes.PNL_MNT_TERC_TERR_EXPEDICION,//rectangulo
				 												    null);//deptoBase
		}
		
		return this.pnlTerritorioExpedicion;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropPnlDireccion
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pnlTerritorioExpedicion
  	 * @return FormaPanelDireccion 
  	 * 		   seccion de direccion gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaPanelDireccion iniciarPropPnlDireccion() throws Exception{
		
		if(this.pnlDireccion==null){
			
			this.pnlDireccion = new FormaPanelDireccion(null,
														this,
														EnumDimensionesComponentes.PNL_MNT_TERC_DIR_DIRECCION,
														new EnumDimensionesComponentes[]{EnumDimensionesComponentes.LBL_MNT_TERC_PNL_DIR_ETIQUETA,
																						 EnumDimensionesComponentes.TXT_MNT_TERC_PNL_DIR_DESCRIPCION,
																						 EnumDimensionesComponentes.BTN_MNT_TERC_PNL_DIR_MANTENIMIENTO,
																						 EnumDimensionesComponentes.BTN_MNT_TERC_PNL_DIR_LIMPIAR},
														"pnlDireccion");
		}
		
		return this.pnlDireccion;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropCmbTipoIdentificacion
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   cmbTipoIdentificacion
  	 * @return CajaComboUtil 
  	 * 		   lista de valores gestionada 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaComboUtil iniciarPropCmbTipoIdentificacion()throws Exception{

		if(this.cmbTipoIdentificacion==null){

			this.cmbTipoIdentificacion = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_MNT_TERC_TIPO_IDENTIFICACION,
																	  		   	    	"cmbTipoIdentificacion",
																	  		   	    	false,
																	  		   	    	true, 
																	  		   	    	super.getEventoForma(),
																	  		   	    	EnumEtiquetas.TLT_MNT_TERC_TIPO_DOCUMENTO);
			
			this.cmbTipoIdentificacion.setToolTipText(EnumEtiquetas.TLT_MNT_TERC_TIPO_DOCUMENTO);
		}
		
		return this.cmbTipoIdentificacion;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropCmbTipoPersona
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   cmbTipoPersona
  	 * @return CajaComboUtil 
  	 * 		   lista de valores gestionada 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaComboUtil iniciarPropCmbTipoPersona()throws Exception{

		if(this.cmbTipoPersona==null){

			this.cmbTipoPersona = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_MNT_TERC_TIPO_PERSONA,
															  		   	     	 "cmbTipoPersona",
															  		   	     	 false,
															  		   	     	 true, 
															  		   	     	 super.getEventoForma(),
															  		   	     	 EnumEtiquetas.LBL_MNT_TERC_TIPO_PERSONA);
		}
		
		return this.cmbTipoPersona;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropCmbActividadesEconomicas
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   cmbActividadesEconomicas
  	 * @return CajaComboUtil 
  	 * 		   lista de valores gestionada 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaComboUtil iniciarPropCmbActividadesEconomicas()throws Exception{

		if(this.cmbActividadesEconomicas==null){

			this.cmbActividadesEconomicas = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_MNT_TERC_ACTIVIDADES_ECONOMICAS,
																			 		   	   "cmbActividadesEconomicas",
																			 		   	   true,
																			 		   	   true, 
																			 		   	   super.getEventoForma(),
																			 		   	   EnumEtiquetas.LBL_MNT_TERC_ACTIVIDAD_ECONOMICA);
		}
		
		return this.cmbActividadesEconomicas;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropTxtIdentificacion
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   txtIdentificacion
  	 * @return CajaTextoUtil 
  	 * 		   caja de texto gestionada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaTextoUtil iniciarPropTxtIdentificacion()throws Exception{
		
		if(this.txtIdentificacion==null){
			
			this.txtIdentificacion = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_MNT_TERC_IDENTIFICACION, 
																	 		  	 	 "txtIdentificacion", 
																	 		  	 	 "", 
																	 		  	 	 true, 
																	 		  	 	 false, 
																	 		  	 	 true, 
																	 		  	 	 super.getEventoForma(),
																	 		  	 	 null);
			
			this.txtIdentificacion.setToolTipText(EnumEtiquetas.LBL_MNT_TERC_DOCUMENTO);
		}
		
		return this.txtIdentificacion;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropTxtPrimerApellido
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   txtPrimerApellido
  	 * @return CajaTextoUtil 
  	 * 		   caja de texto gestionada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaTextoUtil iniciarPropTxtPrimerApellido()throws Exception{
		
		if(this.txtPrimerApellido==null){
			
			this.txtPrimerApellido = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_MNT_TERC_PRIMER_APELLIDO, 
																	 		  	 	 "txtPrimerApellido", 
																	 		  	 	 "", 
																	 		  	 	 true, 
																	 		  	 	 true, 
																	 		  	 	 true, 
																	 		  	 	 super.getEventoForma(),
																	 		  	 	 null);
		}
		
		return this.txtPrimerApellido;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropTxtSegundoApellido
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   txtSegundoApellido
  	 * @return CajaTextoUtil 
  	 * 		   caja de texto gestionada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaTextoUtil iniciarPropTxtSegundoApellido()throws Exception{
		
		if(this.txtSegundoApellido==null){
			
			this.txtSegundoApellido = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_MNT_TERC_SEGUNDO_APELLIDO, 
																	 		  	  	  "txtSegundoApellido", 
																	 		  	  	  "", 
																	 		  	  	  true, 
																	 		  	  	  true, 
																	 		  	  	  true, 
																	 		  	  	  super.getEventoForma(),
																	 		  	  	  null);
		}
		
		return this.txtSegundoApellido;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropTxtNombres
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   txtNombres
  	 * @return CajaTextoUtil 
  	 * 		   caja de texto gestionada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaTextoUtil iniciarPropTxtNombres()throws Exception{
		
		if(this.txtNombres==null){
			
			this.txtNombres = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_MNT_TERC_NOMBRES, 
															 		  	  	  "txtNombres", 
															 		  	  	  "", 
															 		  	  	  true, 
															 		  	  	  true, 
															 		  	  	  true, 
															 		  	  	  super.getEventoForma(),
															 		  	  	  null);
		}
		
		return this.txtNombres;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropTxtTelefono
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   txtTelefono
  	 * @return CajaTextoUtil 
  	 * 		   caja de texto gestionada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaTextoUtil iniciarPropTxtTelefono()throws Exception{
		
		if(this.txtTelefono==null){
			
			this.txtTelefono = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_MNT_TERC_TELEFONO, 
															 		  	   	   "txtTelefono", 
															 		  	   	   "", 
															 		  	   	   true, 
															 		  	   	   true, 
															 		  	   	   true, 
															 		  	   	   super.getEventoForma(),
															 		  	   	   null);
		}
		
		return this.txtTelefono;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropTxtCelular
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   txtCelular
  	 * @return CajaTextoUtil 
  	 * 		   caja de texto gestionada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaTextoUtil iniciarPropTxtCelular()throws Exception{
		
		if(this.txtCelular==null){
			
			this.txtCelular = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_MNT_TERC_CELULAR,
															 		  	  	  "txtCelular", 
															 		  	  	  "", 
															 		  	  	  true, 
															 		  	  	  true, 
															 		  	  	  true, 
															 		  	  	  super.getEventoForma(),
															 		  	  	  null);
		}
		
		return this.txtCelular;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropTxtCorreoElectronico
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   txtCorreoElectronico
  	 * @return CajaTextoUtil 
  	 * 		   caja de texto gestionada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaTextoUtil iniciarPropTxtCorreoElectronico()throws Exception{
		
		if(this.txtCorreoElectronico==null){
			
			this.txtCorreoElectronico = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_MNT_TERC_CORREO_ELECTRONICO, 
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
  	 * ****************************************************************.
  	 * @metodo iniciarPropDtcFechaNacimiento
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   dtcFechaNacimiento
  	 * @return CajaFechaUtil 
  	 * 		   Caja para fecha gestionada 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaFechaUtil iniciarPropDtcFechaNacimiento() throws Exception{
		
		if (this.dtcFechaNacimiento == null) {
			
			this.dtcFechaNacimiento = UtilComponentesGUI.getInstance().crearCalendar(EnumDimensionesComponentes.DTC_MNT_TERC_FECHA_NACIMIENTO,
																				 	 "dtcFechaNacimiento", 
																				 	 null, 
																				 	 true, 
																				 	 super.getEventoForma(),
																				 	 EnumEtiquetas.LBL_MNT_TERC_FECHA_NACIMIENTO);
		}
		
		return this.dtcFechaNacimiento;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropDtcFechaEntradaPais
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   dtcFechaEntradaPais
  	 * @return CajaFechaUtil 
  	 * 		   Caja para fecha gestionada 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaFechaUtil iniciarPropDtcFechaEntradaPais() throws Exception{
		
		if (this.dtcFechaEntradaPais == null) {
			
			this.dtcFechaEntradaPais = UtilComponentesGUI.getInstance().crearCalendar(EnumDimensionesComponentes.DTC_MNT_TERC_FECHA_ENTRADA_PAIS,
																				  	  "dtcFechaEntradaPais", 
																				  	  null, 
																				  	  true, 
																				  	  super.getEventoForma(),
																				  	  EnumEtiquetas.LBL_MNT_TERC_FECHA_ENTRADA_PAIS);
		}
		
		return this.dtcFechaEntradaPais;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropDtcFechaVencimiento
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   dtcFechaVencimiento
  	 * @return CajaFechaUtil 
  	 * 		   Caja para fecha gestionada 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaFechaUtil iniciarPropDtcFechaVencimiento() throws Exception{
		
		if (this.dtcFechaVencimiento == null) {
			
			this.dtcFechaVencimiento = UtilComponentesGUI.getInstance().crearCalendar(EnumDimensionesComponentes.DTC_MNT_TERC_FECHA_VENCIMIENTO,
																				  	  "dtcFechaVencimiento", 
																				  	  null, 
																				  	  true, 
																				  	  super.getEventoForma(),
																				  	  EnumEtiquetas.LBL_MNT_TERC_FECHA_VENCIMIENTO);
		}
		
		return this.dtcFechaVencimiento;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropDtcFechaExpedicion
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   dtcFechaExpedicion
  	 * @return CajaFechaUtil 
  	 * 		   Caja para fecha gestionada 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaFechaUtil iniciarPropDtcFechaExpedicion() throws Exception{
		
		if (this.dtcFechaExpedicion == null) {
			
			this.dtcFechaExpedicion = UtilComponentesGUI.getInstance().crearCalendar(EnumDimensionesComponentes.DTC_MNT_TERC_FECHA_EXPEDICION,
																				 	 "dtcFechaExpedicion", 
																				 	 null, 
																				 	 true, 
																				 	 super.getEventoForma(),
																				 	 EnumEtiquetas.LBL_MNT_TERC_FECHA_EXPEDICION,
																				 	 EnumEtiquetas.TTL_MNT_TERC_PNL_EXPEDICION.toString());
		}
		
		return this.dtcFechaExpedicion;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropChkAutoRetenedor
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   chkAutoRetenedor
  	 * @return CajaVerificadaUtil 
  	 * 		   caja de chequeo gestionada 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaVerificadaUtil iniciarPropChkAutoRetenedor()throws Exception{
		
		if(this.chkAutoRetenedor==null){
			
			this.chkAutoRetenedor = UtilComponentesGUI.getInstance().crearCheckBox(EnumDimensionesComponentes.CHK_MNT_TERC_AUTO_RETENEDOR, 
																				   "chkAutoRetenedor", 
																				   EnumEtiquetas.CHK_MNT_TERC_AUTO_RETENEDOR,
																				   false,
																				   true, 
																				   true, 
																				   false, 
																				   super.getEventoForma(), 
																				   SwingConstants.TRAILING, 
																				   true);
		}
		
		return this.chkAutoRetenedor;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblDocumento
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblDocumento
  	 * @return EtiquetaUtil 
  	 * 		   etiqueta gestionada 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblDocumento()throws Exception{

		if(this.lblDocumento==null){

			this.lblDocumento = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_MNT_TERC_DOCUMENTO,
																   			"lblDocumento",
																   			EnumEtiquetas.LBL_MNT_TERC_DOCUMENTO,
																   			true,
																   			null,
																   			true);
		}
		
		return this.lblDocumento;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblTipoPersona
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblTipoPersona
  	 * @return EtiquetaUtil 
  	 * 		   etiqueta gestionada 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblTipoPersona()throws Exception{

		if(this.lblTipoPersona==null){

			this.lblTipoPersona = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_MNT_TERC_TIPO_PERSONA,
																   		  	  "lblTipoPersona",
																   		  	  EnumEtiquetas.LBL_MNT_TERC_TIPO_PERSONA,
																   		  	  true,
																   		  	  null,
																   		  	  true);
		}
		
		return this.lblTipoPersona;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblFechaNacimiento
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblFechaNacimiento
  	 * @return EtiquetaUtil 
  	 * 		   etiqueta gestionada 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblFechaNacimiento()throws Exception{

		if(this.lblFechaNacimiento==null){

			this.lblFechaNacimiento = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_MNT_TERC_FECHA_NACIMIENTO,
																	   		  	  "lblFechaNacimiento",
																	   		  	  EnumEtiquetas.LBL_MNT_TERC_FECHA_NACIMIENTO,
																	   		  	  true,
																	   		  	  null,
																	   		  	  true);
		}
		
		return this.lblFechaNacimiento;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblFechaEntradaPais
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblFechaEntradaPais
  	 * @return EtiquetaUtil 
  	 * 		   etiqueta gestionada 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblFechaEntradaPais()throws Exception{

		if(this.lblFechaEntradaPais==null){

			this.lblFechaEntradaPais = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_MNT_TERC_FECHA_ENTRADA_PAIS,
																	   		   	   "lblFechaEntradaPais",
																	   		   	   EnumEtiquetas.LBL_MNT_TERC_FECHA_ENTRADA_PAIS,
																	   		   	   true,
																	   		   	   null,
																	   		   	   true);
		}
		
		return this.lblFechaEntradaPais;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblFechaVencimiento
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblFechaVencimiento
  	 * @return EtiquetaUtil 
  	 * 		   etiqueta gestionada 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblFechaVencimiento()throws Exception{

		if(this.lblFechaVencimiento==null){

			this.lblFechaVencimiento = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_MNT_TERC_FECHA_VENCIMIENTO,
																	   		   	   "lblFechaVencimiento",
																	   		   	   EnumEtiquetas.LBL_MNT_TERC_FECHA_VENCIMIENTO,
																	   		   	   true,
																	   		   	   null,
																	   		   	   true);
		}
		
		return this.lblFechaVencimiento;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblFechaExpedicion
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblFechaExpedicion
  	 * @return EtiquetaUtil 
  	 * 		   etiqueta gestionada 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblFechaExpedicion()throws Exception{

		if(this.lblFechaExpedicion==null){

			this.lblFechaExpedicion = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_MNT_TERC_FECHA_EXPEDICION,
																	   		  	  "lblFechaExpedicion",
																	   		  	  EnumEtiquetas.LBL_MNT_TERC_FECHA_EXPEDICION,
																	   		  	  true,
																	   		  	  null,
																	   		  	  true);
		}
		
		return this.lblFechaExpedicion;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblPrimerApellido
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblPrimerApellido
  	 * @return EtiquetaUtil 
  	 * 		   etiqueta gestionada 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblPrimerApellido()throws Exception{

		if(this.lblPrimerApellido==null){

			this.lblPrimerApellido = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_MNT_TERC_PRIMER_APELLIDO,
																	   		 	 "lblPrimerApellido",
																	   		 	 EnumEtiquetas.LBL_MNT_TERC_PRIMER_APELLIDO,
																	   		 	 true,
																	   		 	 null,
																	   		 	 true);
		}
		
		return this.lblPrimerApellido;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblSegundoApellido
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblSegundoApellido
  	 * @return EtiquetaUtil 
  	 * 		   etiqueta gestionada 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblSegundoApellido()throws Exception{

		if(this.lblSegundoApellido==null){

			this.lblSegundoApellido = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_MNT_TERC_SEGUNDO_APELLIDO,
																	   		  	  "lblSegundoApellido",
																	   		  	  EnumEtiquetas.LBL_MNT_TERC_SEGUNDO_APELLIDO,
																	   		  	  true,
																	   		  	  null,
																	   		  	  true);
		}
		
		return this.lblSegundoApellido;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblNombres
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblNombres
  	 * @return EtiquetaUtil 
  	 * 		   etiqueta gestionada 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblNombres()throws Exception{

		if(this.lblNombres==null){

			this.lblNombres = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_MNT_TERC_NOMBRES,
															   		  	  "lblNombres",
															   		  	  EnumEtiquetas.LBL_MNT_TERC_NOMBRES,
															   		  	  true,
															   		  	  null,
															   		  	  true);
		}
		
		return this.lblNombres;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblTelefono
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblTelefono
  	 * @return EtiquetaUtil 
  	 * 		   etiqueta gestionada 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblTelefono()throws Exception{

		if(this.lblTelefono==null){

			this.lblTelefono = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_MNT_TERC_TELEFONO,
															   		   	   "lblTelefono",
															   		   	   EnumEtiquetas.LBL_MNT_TERC_TELEFONO,
															   		   	   true,
															   		   	   null,
															   		   	   true);
		}
		
		return this.lblTelefono;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblCelular
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblCelular
  	 * @return EtiquetaUtil 
  	 * 		   etiqueta gestionada 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblCelular()throws Exception{

		if(this.lblCelular==null){

			this.lblCelular = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_MNT_TERC_CELULAR,
															   		  	  "lblCelular",
															   		  	  EnumEtiquetas.LBL_MNT_TERC_CELULAR,
															   		  	  true,
															   		  	  null,
															   		  	  true);
		}
		
		return this.lblCelular;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblCorreoElectronico
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblCorreoElectronico
  	 * @return EtiquetaUtil 
  	 * 		   etiqueta gestionada 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblCorreoElectronico()throws Exception{

		if(this.lblCorreoElectronico==null){

			this.lblCorreoElectronico = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_MNT_TERC_CORREO_ELECTRONICO,
																		   			"lblCorreoElectronico",
																		   			EnumEtiquetas.LBL_MNT_TERC_CORREO_ELECTRONICO,
																		   			true,
																		   			null,
																		   			true);
		}
		
		return this.lblCorreoElectronico;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblActividadEconomica
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblActividadEconomica
  	 * @return EtiquetaUtil 
  	 * 		   etiqueta gestionada 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblActividadEconomica()throws Exception{

		if(this.lblActividadEconomica==null){

			this.lblActividadEconomica = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_MNT_TERC_ACTIVIDAD_ECONOMICA,
																		   		 	 "lblActividadEconomica",
																		   		 	 EnumEtiquetas.LBL_MNT_TERC_ACTIVIDAD_ECONOMICA,
																		   		 	 true,
																		   		 	 null,
																		   		 	 true);
		}
		
		return this.lblActividadEconomica;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropCmbTerceroPeps
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   cmbTerceroPeps
  	 * @return CajaComboUtil 
  	 * 		   lista de valores gestionada 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor StivenGarcia
  	 * ****************************************************************
  	 */
	public CajaComboUtil iniciarPropCmbTerceroPeps()throws Exception{

		if(this.cmbTerceroPeps==null){

			this.cmbTerceroPeps = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_MNT_TERC_TERCERO_PEPS,
																			 		   	   "cmbTerceroPeps",
																			 		   	   true,
																			 		   	   true, 
																			 		   	   super.getEventoForma(),
																			 		   	   EnumEtiquetas.LBL_MNT_TERC_TERCERO_PEPS);
		}
		
		return this.cmbTerceroPeps;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblActividadEconomica
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblActividadEconomica
  	 * @return EtiquetaUtil 
  	 * 		   etiqueta gestionada 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblTerceroPeps()throws Exception{

		if(this.lblTerceroPeps == null){

			this.lblTerceroPeps = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_MNT_TERC_TERCERO_PEPS,
																   		 	 "lblTerceroPeps",
																   		 	 EnumEtiquetas.LBL_MNT_TERC_TERCERO_PEPS,
																   		 	 true,
																   		 	 null,
																   		 	 true);
		}
		
		return this.lblTerceroPeps;
	}
	
	public EventoFormaMantenimientoTercero castEvtFrmMantenimientoTercero()throws Exception{
		return (EventoFormaMantenimientoTercero)super.getEventoForma();
	}
	
	public JPanel getPnlExpedicion() {
		return pnlExpedicion;
	}

	public void setPnlExpedicion(JPanel pnlExpedicion) {
		this.pnlExpedicion = pnlExpedicion;
	}

	public FormaPanelTerritorio getPnlTerritorioExpedicion() {
		return pnlTerritorioExpedicion;
	}

	public void setPnlTerritorioExpedicion(
			FormaPanelTerritorio pnlTerritorioExpedicion) {
		this.pnlTerritorioExpedicion = pnlTerritorioExpedicion;
	}

	public FormaPanelDireccion getPnlDireccion() {
		return pnlDireccion;
	}

	public void setPnlDireccion(FormaPanelDireccion pnlDireccion) {
		this.pnlDireccion = pnlDireccion;
	}

	public CajaComboUtil getCmbTipoIdentificacion() {
		return cmbTipoIdentificacion;
	}

	public void setCmbTipoIdentificacion(CajaComboUtil cmbTipoIdentificacion) {
		this.cmbTipoIdentificacion = cmbTipoIdentificacion;
	}

	public CajaComboUtil getCmbTipoPersona() {
		return cmbTipoPersona;
	}

	public void setCmbTipoPersona(CajaComboUtil cmbTipoPersona) {
		this.cmbTipoPersona = cmbTipoPersona;
	}

	public CajaComboUtil getCmbActividadesEconomicas() {
		return cmbActividadesEconomicas;
	}

	public void setCmbActividadesEconomicas(CajaComboUtil cmbActividadesEconomicas) {
		this.cmbActividadesEconomicas = cmbActividadesEconomicas;
	}

	public CajaTextoUtil getTxtIdentificacion() {
		return txtIdentificacion;
	}

	public void setTxtIdentificacion(CajaTextoUtil txtIdentificacion) {
		this.txtIdentificacion = txtIdentificacion;
	}

	public CajaTextoUtil getTxtPrimerApellido() {
		return txtPrimerApellido;
	}

	public void setTxtPrimerApellido(CajaTextoUtil txtPrimerApellido) {
		this.txtPrimerApellido = txtPrimerApellido;
	}

	public CajaTextoUtil getTxtSegundoApellido() {
		return txtSegundoApellido;
	}

	public void setTxtSegundoApellido(CajaTextoUtil txtSegundoApellido) {
		this.txtSegundoApellido = txtSegundoApellido;
	}

	public CajaTextoUtil getTxtNombres() {
		return txtNombres;
	}

	public void setTxtNombres(CajaTextoUtil txtNombres) {
		this.txtNombres = txtNombres;
	}

	public CajaTextoUtil getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(CajaTextoUtil txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public CajaTextoUtil getTxtCelular() {
		return txtCelular;
	}

	public void setTxtCelular(CajaTextoUtil txtCelular) {
		this.txtCelular = txtCelular;
	}

	public CajaTextoUtil getTxtCorreoElectronico() {
		return txtCorreoElectronico;
	}

	public void setTxtCorreoElectronico(CajaTextoUtil txtCorreoElectronico) {
		this.txtCorreoElectronico = txtCorreoElectronico;
	}

	public CajaFechaUtil getDtcFechaNacimiento() {
		return dtcFechaNacimiento;
	}

	public void setDtcFechaNacimiento(CajaFechaUtil dtcFechaNacimiento) {
		this.dtcFechaNacimiento = dtcFechaNacimiento;
	}

	public CajaFechaUtil getDtcFechaEntradaPais() {
		return dtcFechaEntradaPais;
	}

	public void setDtcFechaEntradaPais(CajaFechaUtil dtcFechaEntradaPais) {
		this.dtcFechaEntradaPais = dtcFechaEntradaPais;
	}

	public CajaFechaUtil getDtcFechaVencimiento() {
		return dtcFechaVencimiento;
	}

	public void setDtcFechaVencimiento(CajaFechaUtil dtcFechaVencimiento) {
		this.dtcFechaVencimiento = dtcFechaVencimiento;
	}

	public CajaFechaUtil getDtcFechaExpedicion() {
		return dtcFechaExpedicion;
	}

	public void setDtcFechaExpedicion(CajaFechaUtil dtcFechaExpedicion) {
		this.dtcFechaExpedicion = dtcFechaExpedicion;
	}

	public CajaVerificadaUtil getChkAutoRetenedor() {
		return chkAutoRetenedor;
	}

	public void setChkAutoRetenedor(CajaVerificadaUtil chkAutoRetenedor) {
		this.chkAutoRetenedor = chkAutoRetenedor;
	}

	public EtiquetaUtil getLblDocumento() {
		return lblDocumento;
	}

	public void setLblDocumento(EtiquetaUtil lblDocumento) {
		this.lblDocumento = lblDocumento;
	}

	public EtiquetaUtil getLblTipoPersona() {
		return lblTipoPersona;
	}

	public void setLblTipoPersona(EtiquetaUtil lblTipoPersona) {
		this.lblTipoPersona = lblTipoPersona;
	}

	public EtiquetaUtil getLblFechaNacimiento() {
		return lblFechaNacimiento;
	}

	public void setLblFechaNacimiento(EtiquetaUtil lblFechaNacimiento) {
		this.lblFechaNacimiento = lblFechaNacimiento;
	}

	public EtiquetaUtil getLblFechaEntradaPais() {
		return lblFechaEntradaPais;
	}

	public void setLblFechaEntradaPais(EtiquetaUtil lblFechaEntradaPais) {
		this.lblFechaEntradaPais = lblFechaEntradaPais;
	}

	public EtiquetaUtil getLblFechaVencimiento() {
		return lblFechaVencimiento;
	}

	public void setLblFechaVencimiento(EtiquetaUtil lblFechaVencimiento) {
		this.lblFechaVencimiento = lblFechaVencimiento;
	}

	public EtiquetaUtil getLblFechaExpedicion() {
		return lblFechaExpedicion;
	}

	public void setLblFechaExpedicion(EtiquetaUtil lblFechaExpedicion) {
		this.lblFechaExpedicion = lblFechaExpedicion;
	}

	public EtiquetaUtil getLblPrimerApellido() {
		return lblPrimerApellido;
	}

	public void setLblPrimerApellido(EtiquetaUtil lblPrimerApellido) {
		this.lblPrimerApellido = lblPrimerApellido;
	}

	public EtiquetaUtil getLblSegundoApellido() {
		return lblSegundoApellido;
	}

	public void setLblSegundoApellido(EtiquetaUtil lblSegundoApellido) {
		this.lblSegundoApellido = lblSegundoApellido;
	}

	public EtiquetaUtil getLblNombres() {
		return lblNombres;
	}

	public void setLblNombres(EtiquetaUtil lblNombres) {
		this.lblNombres = lblNombres;
	}

	public EtiquetaUtil getLblTelefono() {
		return lblTelefono;
	}

	public void setLblTelefono(EtiquetaUtil lblTelefono) {
		this.lblTelefono = lblTelefono;
	}

	public EtiquetaUtil getLblCelular() {
		return lblCelular;
	}

	public void setLblCelular(EtiquetaUtil lblCelular) {
		this.lblCelular = lblCelular;
	}

	public EtiquetaUtil getLblCorreoElectronico() {
		return lblCorreoElectronico;
	}

	public void setLblCorreoElectronico(EtiquetaUtil lblCorreoElectronico) {
		this.lblCorreoElectronico = lblCorreoElectronico;
	}

	public EtiquetaUtil getLblActividadEconomica() {
		return lblActividadEconomica;
	}

	public void setLblActividadEconomica(EtiquetaUtil lblActividadEconomica) {
		this.lblActividadEconomica = lblActividadEconomica;
	}	

	public CajaComboUtil getCmbTerceroPeps() {
		return cmbTerceroPeps;
	}

	public void setCmbTerceroPeps(CajaComboUtil cmbTerceroPeps) {
		this.cmbTerceroPeps = cmbTerceroPeps;
	}	

	public EtiquetaUtil getLblTerceroPeps() {
		return lblTerceroPeps;
	}

	public void setLblTerceroPeps(EtiquetaUtil lblTerceroPeps) {
		this.lblTerceroPeps = lblTerceroPeps;
	}

	public static void main(String[] args) {
		
		DatoEntidad objDatEntTipoIdentificacion;
		
		try {
			
			InformacionSessionGiros.getInstance().getObjUsuario().getEmpresa().setId("1");
			
			objDatEntTipoIdentificacion = XmlDatosEntidades.getInstance().
											obtenerEntidad("4").
												getHmDatos().
													get("3");
			
			new FormaMantenimientoTercero(null,
										  true,
										  true,
										  EnumTiposOperaciones.ENVIO_FACTURACION,
										  objDatEntTipoIdentificacion,
										  "68",
										  EnumParametrosApp.DESCRIPCION_TERCERO_TRAMITADOR.getValorPropiedad(),
										  true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

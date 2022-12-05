package co.com.codesa.clienteposslimgiros.formas.pago;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import co.com.codesa.clienteposslim.logger.Logger;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.pago.EventoFormaConsultaGiroInternacional;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.GrillaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelEncabezadoGeneral;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;


/** 
 * ********************************************************************
 * @class  FormaConsultaGiroInternacional
 *		   Forma para consultar los giros internacionales
 * @author roberth.martinez
 * @date   15/03/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class FormaConsultaGiroInternacional extends FormaGenerica{
	
	/**
	 * @variable serialVersionUID
	 * 			 variable
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @variable pnlEncabezadoGeneral
	 * 			 seccion que aloja el encabezado general para las formas, que 
	 * 			 contiene los valores de agencia, empresa y caja, normalmente 
	 * 			 recuperados del usuario autenticado
	 **/
	private FormaPanelEncabezadoGeneral pnlEncabezadoGeneral;
	
	/**
	 * @variable scpGrillaGiros
	 * 			 componente grafico que permite incluir barras de desplazamiento 
	 * 			 para facilitar el despliegue de la grilla
	 **/
	private JScrollPane scpGrillaGiros;
	
	/**
	 * @variable lblBusqueda
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 indica label de busqueda
	 **/
	private EtiquetaUtil lblBusqueda;
	
	/**
	 * @variable lblReferencia
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 indica label de referencia a buscar
	 **/
	private EtiquetaUtil lblReferencia;
	
	/**
	 * @variable lblCorresponsal
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 indica label de corresponsal
	 **/
	private EtiquetaUtil lblCorresponsal;
	
	/**
	 * @variable lblTipoDocumentoBen
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 indica label de tipo de documento beneficiario
	 **/
	private EtiquetaUtil lblTipoDocumentoBen;
	
	/**
	 * @variable lblDocumentoBen
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 indica label de documento beneficiario
	 **/
	private EtiquetaUtil lblDocumentoBen;
	
	/**
	 * @variable lblEstadoRemesa
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 indica label de estado remesa 
	 **/
	private EtiquetaUtil lblEstadoRemesa;
	
	/**
	 * @variable lblNombreTerceroBen
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 indica label de nombre del tercero beneficiario
	 **/
	private EtiquetaUtil lblNombreTerceroBen;
	
	/**
	 * @variable lblApellidoTerceroBen
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 indica label de apellido del tercero beneficiario
	 **/
	private EtiquetaUtil lblApellidoTerceroBen;
	
	/**
	 * @variable lblNombreTerceroRem
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 indica label de nombre del tercero remitente
	 **/
	private EtiquetaUtil lblNombreTerceroRem;
	
	/**
	 * @variable lblApellidoTerceroRem
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 indica label de apellido del tercero remitente
	 **/
	private EtiquetaUtil lblApellidoTerceroRem;
	
	/**
	 * @variable lblNumeroDocAlReves
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 indica label de numero de documento al reves
	 **/
	private EtiquetaUtil lblNumeroDocAlReves;
	
	/**
	 * @variable txtNumeroDocAlReves
	 * 			 campo de texto sobre la forma que contiene el la referencia o
	 * 			 la identificacion a buscar
	 **/
	private CajaTextoUtil txtNumeroDocAlReves;
	
	/**
	 * @variable txtReferencia
	 * 			 campo de texto sobre la forma que contiene el la referencia o
	 * 			 la identificacion a buscar
	 **/
	private CajaTextoUtil txtReferencia;
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																							/**
	/**
	 * @variable txtDocumentoBen
	 * 			 campo de texto sobre la forma para diligenciar la identificacion
	 * 			 del tercero beneficiario
	 **/
	private CajaTextoUtil txtDocumentoBen;
	
	/**
	 * @variable txtEstadoRemesa
	 * 			 campo de texto sobre la forma para diligenciar el estado de Remsa
	 **/
	private CajaTextoUtil txtEstadoRemesa;
	
	/**
	 * @variable txtNombreTerceroBen
	 * 			 campo de texto sobre la forma para diligenciar la indicar el nombre del tercero beneficiario
	 **/
	private CajaTextoUtil txtNombreTerceroBen;
	
	/**
	 * @variable txtApellidoTerceroBen
	 * 			 campo de texto sobre la forma para diligenciar la indicar el apellido del tercero beneficiario
	 **/
	private CajaTextoUtil txtApellidoTerceroBen;
	
	/**
	 * @variable txtNombreTerceroRem
	 * 			 campo de texto sobre la forma para diligenciar la indicar el nombre del tercero remitente
	 **/
	private CajaTextoUtil txtNombreTerceroRem;
	
	/**
	 * @variable txtApellidoTerceroRem
	 * 			 campo de texto sobre la forma para diligenciar la indicar el apellido del tercero remitente
	 **/
	private CajaTextoUtil txtApellidoTerceroRem;
	
	/**
	 * @variable cmbBusqueda
	 * 			 componente de combo sobre la forma que  contiene el listado 
	 * 		     de opciones de busqueda
	 **/
	private CajaComboUtil cmbBusqueda;
	
	/**
	 * @variable cmbTipoDocumentoBen
	 * 			 componente de combo sobre la forma que  contiene el listado 
	 * 		     de tipos de documento de identidad beneficiario
	 **/
	private CajaComboUtil cmbTipoDocumentoBen;
	
	/**
	 * @variable cmbTiposIdentificacion
	 * 			 componente de combo sobre la forma que  contiene el listado 
	 * 		     de tipos de documento de identidad
	 **/
	private CajaComboUtil cmbCorresponsales;
	
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
	 * @variable	pnlReferencia
	 * 				panel Referencias
	 */
	private SeccionUtil pnlReferencia;
	
	/**
	 * @variable	pnlContenedorDocAlRevesDatAdd
	 * 				Seccion que contiene la informacion el panel de documento al reves
	 */
	private SeccionUtil pnlContenedorDocAlRevesDatAdd;
	
	/**
	 * @variable	pnlDocumentoAlRevesDatAdd
	 * 				Seccion que contiene la informacion del documento al reves, en forma datos adicionales
	 */
	private SeccionUtil pnlDocumentoAlRevesDatAdd;
	
	/**
	 * @variable tblGiros
	 * 			 grilla donde se relaciona la informacion asociada a los giros 
	 * 			 que cumplen la condicion filtrada en el panel de busqueda
	 **/
	private GrillaUtil tblGiros;

	/**
	 * ********************************************************************
	 * @method	FormaConsultaGiroInternacional
	 * 		  	Constructor que ejecuta la inicializacion de valores y 
  	 * 		   	ejecucion de comportamientos inicales requeridos para el 
  	 * 		   	despliegue de la forma
	 * @param 	pFrmPadre
	 * 			ventana de la cual extiende esta forma
	 * @param 	pBooModal
	 * 			bandera que permite efectuar la forma de manera modal sobre 
  	 * 		  	la ventana de la cual extiende
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	25/03/2018
	 * *********************************************************************
	 */
	public FormaConsultaGiroInternacional(JFrame pFrmPadre,
							 			  boolean pBooModal) throws Exception {
		
		super(pFrmPadre,
			  pBooModal);
		
		super.setEventoForma(new EventoFormaConsultaGiroInternacional(this));
		this.inicializarForma();
	}

	@Override
	public void inicializarForma(Object ...pArrObjParametrosForma) throws Exception{
		
		super.setTituloForma(EnumEtiquetas.TTL_CPI_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.FRM_CPI_VENTANA.getAncho());//AJUSTAR DIMENSION
		super.setAltoForma(EnumDimensionesComponentes.FRM_CPI_VENTANA.getAlto());//AJUSTAR DIMENSION
        
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
								EnumBotonesEncabezado.BTNCONSULTAR,
						  		EnumBotonesEncabezado.BTNSALIR,
						  		EnumBotonesEncabezado.BTN_LIMPIAR
						  		);
		
		super.iniciar(pArrObjParametrosForma);
	}

	@Override
	public JPanel inicializarEncabezado(Object ...pArrObjParametrosForma) throws Exception{
		
		JPanel pnlEncabezado;
		
		pnlEncabezado = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_CPI_ENCABEZADO,//AJUSTAR DIMENSION
																	"pnlEncabezado",
		  														 	null,
		  														 	null,
		  														 	null);
		pnlEncabezado.add(this.iniciarPropPnlEncabezadoGeneral());
		
		return pnlEncabezado;
	}

	@Override
	public JPanel inicializarCuerpo(Object ...pArrObjParametrosCuerpo) throws Exception{
		
		JPanel pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_CPI_CUERPO,//AJUSTAR DIMENSION
																"pnlCuerpo",
	  													 	 	null,
	  													 	 	null,
	  													 	 	null);
		
		pnlCuerpo.add(this.iniciarPropLblBusqueda());
		pnlCuerpo.add(this.iniciarPropCmbBusqueda());
		
		pnlCuerpo.add(this.iniciarPropPnlBeneficiario());
		pnlCuerpo.add(this.iniciarPropPnlRemitente());
		pnlCuerpo.add(this.iniciarPropPnlReferencia());
		
		return pnlCuerpo;
	}

	@Override
	public JPanel inicializarPiePagina(Object ...pArrObjParametrosPiePagina) throws Exception{
		
		JPanel pnlPiePagina;
		
		pnlPiePagina = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_CPI_PIE_PAGINA,//AJUSTAR DIMENSION
																   "pnlPiePagina",
			 	 												   BorderFactory.createEmptyBorder(),
			 	 												   null,
			 	 												   null);
		pnlPiePagina.add(this.iniciarPropTblGiros().getScpContenedor());
		
		return pnlPiePagina;
	}
	
	/**
  	 * ****************************************************************.
  	 * @method iniciarPropPnlEncabezadoGeneral
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pnlEncabezadoGeneral
  	 * @return JPanel
  	 * 		   seccion de encabezado general gestionada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @author roberth.martinez
  	 * ****************************************************************
  	 */
	public FormaPanelEncabezadoGeneral iniciarPropPnlEncabezadoGeneral() throws Exception{
		
		if(this.pnlEncabezadoGeneral==null){
			
			this.pnlEncabezadoGeneral = new FormaPanelEncabezadoGeneral(super.getObjUsuario().getEmpresa(),
														  			   null,
														  			   super.getObjUsuario().getCaja(),
														  			   EnumDimensionesComponentes.PNL_CPI_ENCABEZADO_GENERAL,//AJUSTAR DIMENSION
														  			   "pnlEncabezadoGeneral");
		}
		
		return this.pnlEncabezadoGeneral;
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
	 * @date	30/03/2018
	 * *********************************************************************
	 */
	public SeccionUtil iniciarPropPnlBeneficiario() throws Exception{
		
		if(this.pnlBeneficiario==null){
			
			this.pnlBeneficiario = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_CPI_BENEFICIARIO,
																			   "pnlBeneficiario",
																  		  		null,
																  		  		EnumEtiquetas.TTL_PGI_PNL_BENEFICIARIO,
																  		  		null);
			
			this.pnlBeneficiario.add(this.iniciarPropLblTipoDocumento());
			this.pnlBeneficiario.add(this.iniciarPropCmbTipoDocumento());
			this.pnlBeneficiario.add(this.iniciarPropLblDocumento());
			this.pnlBeneficiario.add(this.iniciarPropTxtDocumento());
			this.pnlBeneficiario.add(this.iniciarPropLblNombreTerceroBen());
			this.pnlBeneficiario.add(this.iniciarPropTxtNombreTerceroBen());
			this.pnlBeneficiario.add(this.iniciarPropLblApellidoTerceroBen());
			this.pnlBeneficiario.add(this.iniciarPropTxtApellidoTerceroBen());	
			
		}
		
		return this.pnlBeneficiario;
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
	 * @date	30/03/2018
	 * *********************************************************************
	 */
	public SeccionUtil iniciarPropPnlRemitente() throws Exception{
		
		if(this.pnlRemitente==null){
			
			this.pnlRemitente = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_CPI_REMITENTE,
																			"pnlRemitente",
																  		  	null,
																  		  	EnumEtiquetas.TTL_PGI_PNL_REMITENTE,
																  		  	null);
			this.pnlRemitente.add(this.iniciarPropLblNombreTerceroRem());
			this.pnlRemitente.add(this.iniciarPropTxtNombreTerceroRem());
			this.pnlRemitente.add(this.iniciarPropLblApellidoTerceroRem());
			this.pnlRemitente.add(this.iniciarPropTxtApellidoTerceroRem());
			
		}
		
		return this.pnlRemitente;
	}
	
	/** 
	 * ********************************************************************
	 * @method	iniciarPropPnlReferencia
	 * 		  	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	pnlBeneficiario
	 * @return	SeccionUtil
	 * 			seccion de cuerpo gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	30/03/2018
	 * *********************************************************************
	 */
	public SeccionUtil iniciarPropPnlReferencia() throws Exception{
		
		if(this.pnlReferencia==null){
			
			this.pnlReferencia = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_CPI_REFERENCIA,
																			 "pnlReferencia",
																  		  	 null,
																  		  	 EnumEtiquetas.TTL_CPI_PNL_REFERENCIA,
																  		  	 null);
			
			this.pnlReferencia.add(this.iniciarPropLblTipoDocumento());
			this.pnlReferencia.add(this.iniciarPropCmbTipoDocumento());
			this.pnlReferencia.add(this.iniciarPropLblDocumento());
			this.pnlReferencia.add(this.iniciarPropTxtDocumento());
			this.pnlReferencia.add(this.iniciarPropLblReferencia());
			this.pnlReferencia.add(this.iniciarPropTxtReferencia());
			this.pnlReferencia.add(this.iniciarPropLblCorresponsal());
			this.pnlReferencia.add(this.iniciarPropCmbCorresponsales());
			this.pnlReferencia.add(this.iniciarPropLblEstadoRemesa());
			this.pnlReferencia.add(this.iniciarPropTxtEstadoRemesa());
			
			
		}
		
		return this.pnlReferencia;
	}
	
	/**
	 * ********************************************************************
	 * @method	iniciarPropPnlContenedorDocAlRevesDatAdd
	 * 		  	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	pnlContenedorDocAlRevesDatAdd
	 * @return	SeccionUtil
	 * 			Seccion gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author	roberth.martinez
	 * @date	09/10/2018
	 * *********************************************************************
	 */
	public SeccionUtil iniciarPropPnlContenedorDocAlRevesDatAdd() 
			throws Exception
	{
		if	(	this.pnlContenedorDocAlRevesDatAdd	==	null	)
		{	
			this.pnlContenedorDocAlRevesDatAdd = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_CPI_CONTENEDOR_DOC_AL_REVES,
																		 				 	 "pnlContenedorDocAlRevesDatAdd",
																		 				 	 BorderFactory.createEmptyBorder(),
																		 				 	 null,
																		 				 	 TitledBorder.LEFT);
			
			this.pnlContenedorDocAlRevesDatAdd.add(this.iniciarPropPnlDocumentoAlRevesDatAdd());
			
			
			
			this.pnlContenedorDocAlRevesDatAdd.setBooAplicarTransparenciaFondo(true);
			
		}
		
		return this.pnlContenedorDocAlRevesDatAdd;
	}
	
	/**
	 * ********************************************************************
	 * @method	iniciarPropPnlDocumentoAlRevesDatAdd
	 * 		  	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	pnlDocumentoAlRevesDatAdd
	 * @return	SeccionUtil
	 * 			Seccion gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author	roberth.martinez
	 * @date	09/10/2018
	 * *********************************************************************
	 */
	public SeccionUtil iniciarPropPnlDocumentoAlRevesDatAdd() 
			throws Exception
	{
		if	(	this.pnlDocumentoAlRevesDatAdd	==	null	)
		{	
			this.pnlDocumentoAlRevesDatAdd = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_CPI_DOCUMENTO_AL_REVES,
																		 				 "pnlDocumentoAlRevesDatAdd",
																		 				 null,
																		 				 EnumEtiquetas.TTL_CPI_PNL_DOCUMENTO_AL_REVES,
																		 				 TitledBorder.LEFT);
			
			this.pnlDocumentoAlRevesDatAdd.add(this.iniciarPropLblNumeroDocAlReves());
			this.pnlDocumentoAlRevesDatAdd.add(this.iniciarPropTxtNumeroDocAlReves());
			
			
			this.pnlDocumentoAlRevesDatAdd.setBooAplicarTransparenciaFondo(true);
			
		}
		
		return this.pnlDocumentoAlRevesDatAdd;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblBusqueda
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblBusqueda
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	16/03/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblBusqueda() throws Exception{
		
		if (this.lblBusqueda == null) {
			
			this.lblBusqueda = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_CPI_BUSQUEDA_POR, 
																	   	   "lblBusqueda", 
																	   	   EnumEtiquetas.LBL_CPI_BUSQUEDA_POR,
																	   	   false,
																	   	   null,
																	   	   true);
		}

		return this.lblBusqueda;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropCmbBusqueda
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	cmbBusqueda
	 * @return	CajaComboUtil
	 * 			Lista de valores gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	16/03/2018
	 * *********************************************************************
	 */
	public CajaComboUtil iniciarPropCmbBusqueda() throws Exception{
		
		if (this.cmbBusqueda == null) {
			
			this.cmbBusqueda = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_CPI_BUSQUEDA, 
																		  	  "cmbBusqueda", 
																		  	  true, 
																		  	  true, 
																		  	  this.getEventoForma(),
																		  	  EnumEtiquetas.LBL_CPI_BUSQUEDA_POR);
		}
		
		return cmbBusqueda;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblReferencia
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblReferencia
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	16/03/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblReferencia() throws Exception{
		
		if (this.lblReferencia == null) {
			
			this.lblReferencia = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_CPI_REFERENCIA, 
																	   	     "lblReferencia", 
																	   	     EnumEtiquetas.LBL_CPI_REFERENCIA,
																	   	     true,
																	   	     null,
																	   	     true);
		}

		return this.lblReferencia;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropTxtReferencia
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtReferencia
	 * @return	CajaTextoUtil
	 * 			Caja de texto gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	16/03/2018
	 * *********************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtReferencia() throws Exception{
		
		if (this.txtReferencia == null) {
			
			this.txtReferencia = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_CPI_REFERENCIA, 
																			 	 "txtReferencia", 
																			 	 "", 
																			 	 true, 
																			 	 true, 
																			 	 true,
																			 	 this.getEventoForma(),
																			 	 EnumEtiquetas.LBL_CPI_REFERENCIA);
			this.txtReferencia.getPropiedades().setActivaMayusculaMinuscula(true);
		}

		return this.txtReferencia;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblCorresponsal
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblCorresponsal
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	16/03/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblCorresponsal() throws Exception{
		
		if (this.lblCorresponsal == null) {
			
			this.lblCorresponsal = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_CPI_CORRESPONSAL, 
																	   	       "lblCorresponsal", 
																	   	       EnumEtiquetas.LBL_CPI_CORRESPONSAL,
																	   	       true,
																	   	       null,
																	   	       true);
		}

		return this.lblCorresponsal;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropCmbCorresponsales
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	cmbCorresponsales
	 * @return	CajaComboUtil
	 * 			Lista de valores gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	16/03/2018
	 * *********************************************************************
	 */
	public CajaComboUtil iniciarPropCmbCorresponsales() throws Exception{
		
		if (this.cmbCorresponsales == null) {
			
			this.cmbCorresponsales = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_CPI_CORRESPONSAL, 
																		  	  		"cmbCorresponsales", 
																		  	  		true, 
																		  	  		true, 
																		  	  		this.getEventoForma(),
																		  	  		EnumEtiquetas.LBL_CPI_CORRESPONSAL);
		}
		
		return this.cmbCorresponsales;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblTipoDocumento
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblTipoDocumento
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	16/03/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblTipoDocumento() throws Exception{
		
		if (this.lblTipoDocumentoBen == null) {
			
			this.lblTipoDocumentoBen = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_CPI_TIPO_DOCUMENTO_BEN_R, 
																	   	           "lblTipoDocumento", 
																	   	           EnumEtiquetas.LBL_CPI_TIPO_DOCUMENTO,
																	   	           true,
																	   	           null,
																	   	           true);
		}

		return this.lblTipoDocumentoBen;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropCmbTipoDocumento
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	cmbTipoDocumento
	 * @return	CajaComboUtil
	 * 			Lista de valores gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	16/03/2018
	 * *********************************************************************
	 */
	public CajaComboUtil iniciarPropCmbTipoDocumento() throws Exception{
		
		if (this.cmbTipoDocumentoBen == null) {
			
			this.cmbTipoDocumentoBen = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_CPI_TIPO_DOCUMENTO_BEN_R, 
																		  	  	      "cmbTipoDocumento", 
																		  	  	      true, 
																		  	  	      true, 
																		  	  	      this.getEventoForma(),
																		  	  	      EnumEtiquetas.LBL_CPI_TIPO_DOCUMENTO);
		}
		
		return this.cmbTipoDocumentoBen;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblDocumento
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblDocumento
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	20/03/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblDocumento() throws Exception{
		
		if (this.lblDocumentoBen == null) {
			
			this.lblDocumentoBen = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_CPI_DOCUMENTO_BEN_R, 
																	   	       "lblDocumento", 
																	   	       EnumEtiquetas.LBL_CPI_DOCUMENTO,
																	   	       true,
																	   	       null,
																	   	       true);
		}

		return this.lblDocumentoBen;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropTxtDocumento
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtDocumento
	 * @return	CajaTextoUtil
	 * 			Caja de texto gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	20/03/2018
	 * *********************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtDocumento() throws Exception{
		
		if (this.txtDocumentoBen == null) {
			
			this.txtDocumentoBen = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_CPI_DOCUMENTO_BEN_R, 
																			 	   "txtDocumento", 
																			 	   "", 
																			 	   false, 
																			 	   true, 
																			 	   true,
																			 	   this.getEventoForma(),
																			 	   EnumEtiquetas.LBL_CPI_DOCUMENTO);
		}

		return this.txtDocumentoBen;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblEstadoRemesa
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblEstadoRemesa
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	20/03/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblEstadoRemesa() throws Exception{
		
		if (this.lblEstadoRemesa == null) {
			
			this.lblEstadoRemesa = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_CPI_ESTADO_REMESA, 
																	   	       "lblEstadoRemesa", 
																	   	       EnumEtiquetas.LBL_CPI_ESTADO_REMESA,
																	   	       true,
																	   	       null,
																	   	       false);
		}

		return this.lblEstadoRemesa;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropTxtEstadoRemesa
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtEstadoRemesa
	 * @return	CajaTextoUtil
	 * 			Caja de texto gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	20/03/2018
	 * *********************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtEstadoRemesa() throws Exception{
		
		if (this.txtEstadoRemesa == null) {
			
			this.txtEstadoRemesa = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_CPI_ESTADO_REMESA, 
																			 	   "txtEstadoRemesa", 
																			 	   "", 
																			 	   true, 
																			 	   false, 
																			 	   false,
																			 	   this.getEventoForma(),
																			 	   EnumEtiquetas.LBL_CPI_ESTADO_REMESA);
		}

		return this.txtEstadoRemesa;
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
	 * @date   	20/03/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblNombreTerceroBen() throws Exception{
		
		if (this.lblNombreTerceroBen == null) {
			
			this.lblNombreTerceroBen = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_CPI_NOMBRE_TERCERO_BEN, 
																	   	       	   "lblNombreTerceroBen", 
																	   	       	   EnumEtiquetas.LBL_CPI_NOMBRE_TERCERO_BEN,
																	   	       	   true,
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
			
			this.txtNombreTerceroBen = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_CPI_NOMBRE_TERCERO_BEN, 
																			 	       "txtNombreTerceroBen", 
																			 	       "", 
																			 	       true, 
																			 	       true, 
																			 	       true,
																			 	       this.getEventoForma(),
																			 	       EnumEtiquetas.LBL_CPI_NOMBRE_TERCERO_BEN);
		}

		return this.txtNombreTerceroBen;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblApellidoTerceroBen
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblApellidoTerceroBen
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	20/03/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblApellidoTerceroBen() throws Exception{
		
		if (this.lblApellidoTerceroBen == null) {
			
			this.lblApellidoTerceroBen = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_CPI_APELLIDO_TERCERO_BEN, 
																	   	       	     "lblApellidoTerceroBen", 
																	   	       	     EnumEtiquetas.LBL_CPI_APELLIDO_TERCERO_BEN,
																	   	       	     true,
																	   	       	     null,
																	   	       	     true);
		}

		return this.lblApellidoTerceroBen;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropTxtApellidoTerceroBen
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtApellidoTerceroBen
	 * @return	CajaTextoUtil
	 * 			Caja de texto gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	20/03/2018
	 * *********************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtApellidoTerceroBen() throws Exception{
		
		if (this.txtApellidoTerceroBen == null) {
			
			this.txtApellidoTerceroBen = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_CPI_APELLIDO_TERCERO_BEN, 
																			 	         "txtApellidoTerceroBen", 
																			 	         "", 
																			 	         true, 
																			 	         true, 
																			 	         true,
																			 	         this.getEventoForma(),
																			 	         EnumEtiquetas.LBL_CPI_APELLIDO_TERCERO_BEN);
		}

		return this.txtApellidoTerceroBen;
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
	 * @date   	20/03/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblNombreTerceroRem() throws Exception{
		
		if (this.lblNombreTerceroRem == null) {
			
			this.lblNombreTerceroRem = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_CPI_NOMBRE_TERCERO_REM, 
																	   	       	   "lblNombreTerceroRem", 
																	   	       	   EnumEtiquetas.LBL_CPI_NOMBRE_TERCERO_REM,
																	   	       	   true,
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
			
			this.txtNombreTerceroRem = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_CPI_NOMBRE_TERCERO_REM, 
																			 	       "txtNombreTerceroRem", 
																			 	       "", 
																			 	       true, 
																			 	       true, 
																			 	       true,
																			 	       this.getEventoForma(),
																			 	       EnumEtiquetas.LBL_CPI_NOMBRE_TERCERO_REM);
		}

		return this.txtNombreTerceroRem;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblApellidoTerceroRem
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblApellidoTerceroRem
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	20/03/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblApellidoTerceroRem() throws Exception{
		
		if (this.lblApellidoTerceroRem == null) {
			
			this.lblApellidoTerceroRem = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_CPI_APELLIDO_TERCERO_REM, 
																	   	       	     "lblApellidoTerceroRem", 
																	   	       	     EnumEtiquetas.LBL_CPI_APELLIDO_TERCERO_REM,
																	   	       	     true,
																	   	       	     null,
																	   	       	     true);
		}

		return this.lblApellidoTerceroRem;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblNumeroDocAlReves
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblNumeroDocAlReves
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	09/10/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblNumeroDocAlReves() throws Exception{
		
		if (this.lblNumeroDocAlReves == null) {
			
			this.lblNumeroDocAlReves = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_CPI_DOCUMENTO_AL_REVES, 
																	   	       	   "lblNumeroDocAlReves", 
																	   	       	   EnumEtiquetas.LBL_CPI_DOCUMENTO_AL_REVES,
																	   	       	   true,
																	   	       	   null,
																	   	       	   true);
		}

		return this.lblNumeroDocAlReves;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropTxtNumeroDocAlReves
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtNumeroDocAlReves
	 * @return	CajaTextoUtil
	 * 			Caja de texto gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	09/10/2018
	 * *********************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtNumeroDocAlReves() throws Exception{
		
		if (this.txtNumeroDocAlReves == null) {
			
			this.txtNumeroDocAlReves = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_CPI_DOCUMENTO_AL_REVES, 
																			 	       "txtNumeroDocAlReves", 
																			 	       "", 
																			 	       true, 
																			 	       true, 
																			 	       true,
																			 	       this.getEventoForma(),
																			 	       EnumEtiquetas.LBL_CPI_DOCUMENTO_AL_REVES);
		}

		return this.txtNumeroDocAlReves;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropTxtApellidoTerceroRem
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtApellidoTerceroRem
	 * @return	CajaTextoUtil
	 * 			Caja de texto gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	20/03/2018
	 * *********************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtApellidoTerceroRem() throws Exception{
		
		if (this.txtApellidoTerceroRem == null) {
			
			this.txtApellidoTerceroRem = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_CPI_APELLIDO_TERCERO_REM, 
																			 	         "txtApellidoTerceroRem", 
																			 	         "", 
																			 	         true, 
																			 	         true, 
																			 	         true,
																			 	         this.getEventoForma(),
																			 	         EnumEtiquetas.LBL_CPI_APELLIDO_TERCERO_REM);
		}

		return this.txtApellidoTerceroRem;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropScrGrillaGiros
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   scpGrillaGiros
  	 * @return JScrollPane
  	 * 		   contenedor para el despliegue de grilla gestionado
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public JScrollPane iniciarPropScpGrillaGiros() throws Exception{
		
		if(this.scpGrillaGiros==null){
			
			this.scpGrillaGiros = UtilComponentesGUI.getInstance().crearScroll("scrGrillaGiros",
													 					   	   EnumDimensionesComponentes.SCP_CPI_GIROS_CONSULTADOS,
													 					   	   null);
			
			this.scpGrillaGiros.setViewportView(this.iniciarPropTblGiros());
		}
		
		return this.scpGrillaGiros;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropTblGiros
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   tblGiros
  	 * @return GrillaUtil
  	 * 		   grilla gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public GrillaUtil iniciarPropTblGiros() throws Exception{
		
		if(this.tblGiros==null){
			
			this.tblGiros = UtilComponentesGUI.getInstance().crearGrilla("tblGiros",
															   		 	 new EnumEtiquetas[]{EnumEtiquetas.TTL_CPI_GRILLA_GIROS_BENEFICIARIO,
																				  	  		 EnumEtiquetas.TTL_CPI_GRILLA_GIROS_REMITENTE,
																				  	  		 EnumEtiquetas.TTL_CPI_GRILLA_GIROS_CORRESPONSAL,
																				  	  		 EnumEtiquetas.TTL_CPI_GRILLA_GIROS_REFERENCIA,
																				  	  		 EnumEtiquetas.TTL_CPI_GRILLA_GIROS_VLR_PESOS,
																				  	  		 EnumEtiquetas.TTL_CPI_GRILLA_GIROS_PAIS},//visibles
															   		     null,//invisibles
																	     null,/*new boolean []{false,
																						false,
																						false,
																						false,
																						false,
																						false,
																						false,
																						false,
																						false,
																						false,
																						false,	
																						false}*///editable por columna
																	     new int[] {120,
																				    120,
																				    30,
																				    20,
																				    20,
																				    5},//dimensiones
															   		     super.getEventoForma());
			this.tblGiros.getScpContenedorRound(EnumDimensionesComponentes.SCP_CPI_GIROS_CONSULTADOS);
		}
		
		return this.tblGiros;
	}
	
	/**
	 * @method getPnlEncabezadoGeneral
	 * 		   Metodo get del atributo pnlEncabezadoGeneral
	 * @return FormaPanelEncabezadoGeneral
	 *		   Valor del atributo pnlEncabezadoGeneral devuelto
	 * @author roberth.martinez
	 * @date   8/6/2016
	 */
	public FormaPanelEncabezadoGeneral getPnlEncabezadoGeneral() {
		return this.pnlEncabezadoGeneral;
	}

	/**
	 * @method setPnlEncabezadoGeneral
	 * 		   Metodo set del atributo pnlEncabezadoGeneral
	 * @param  pPnlEncabezadoGeneral
	 *		   Valor que tomara el atributo pnlEncabezadoGeneral
	 * @author roberth.martinez
	 * @date   8/6/2016
	 */
	public void setPnlEncabezadoGeneral(
			FormaPanelEncabezadoGeneral pPnlEncabezadoGeneral) {
		this.pnlEncabezadoGeneral = pPnlEncabezadoGeneral;
	}
	
	/**
	 * @method getScpGrillaGiros
	 * 		   Metodo get del atributo scpGrillaGiros
	 * @return JScrollPane
	 *		   Valor del atributo scpGrillaGiros devuelto
	 * @author roberth.martinez
	 * @date   8/6/2016
	 */
	public JScrollPane getScpGrillaGiros() {
		return this.scpGrillaGiros;
	}

	/**
	 * @method setScpGrillaGiros
	 * 		   Metodo set del atributo scpGrillaGiros
	 * @param  pScpGrillaGiros
	 *		   Valor que tomara el atributo scpGrillaGiros
	 * @author roberth.martinez
	 * @date   8/6/2016
	 */
	public void setScpGrillaGiros(JScrollPane pScpGrillaGiros) {
		this.scpGrillaGiros = pScpGrillaGiros;
	}

	/**
	 * @method getTblGiros
	 * 		   Metodo get del atributo tblGiros
	 * @return GrillaUtil
	 *		   Valor del atributo tblGiros devuelto
	 * @author roberth.martinez
	 * @date   8/6/2016
	 */
	public GrillaUtil getTblGiros() {
		return this.tblGiros;
	}

	/**
	 * @method setTblGiros
	 * 		   Metodo set del atributo tblGiros
	 * @param  pTblGiros
	 *		   Valor que tomara el atributo tblGiros
	 * @author roberth.martinez
	 * @date   8/6/2016
	 */
	public void setTblGiros(GrillaUtil pTblGiros) {
		this.tblGiros = pTblGiros;
	}
	
	/**
	 * @method	getCmbBusqueda
	 * 		  	Metodo get del atributo cmbBusqueda
	 * @return	CajaComboUtil
	 *		  	Valor del atributo cmbBusqueda devuelto
	 * @author	roberth.martinez
	 * @date  	20/03/2018
	 */
	public CajaComboUtil getCmbBusqueda() {
		return this.cmbBusqueda;
	}

	/**
	 * @method	setCmbBusqueda
	 * 		  	Metodo set del atributo cmbBusqueda
	 * @param	pCmbBusqueda
	 * 			Valor que tomara el atributo cmbBusqueda
	 * @author	roberth.martinez
	 * @date	20/03/2018
	 */
	public void setCmbBusqueda(CajaComboUtil pCmbBusqueda) {
		this.cmbBusqueda = pCmbBusqueda;
	}

	
	/**
	 * @method	getLblBusqueda
	 * 		  	Metodo get del atributo lblBusqueda
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblBusqueda devuelto
	 * @author	roberth.martinez
	 * @date  	20/03/2018
	 */
	public EtiquetaUtil getLblBusqueda() {
		return this.lblBusqueda;
	}

	/**
	 * @method	setLblBusqueda
	 * 		  	Metodo set del atributo lblBusqueda
	 * @param	pLblBusqueda
	 * 			Valor que tomara el atributo lblBusqueda
	 * @author	roberth.martinez
	 * @date	20/03/2018
	 */
	public void setLblBusqueda(EtiquetaUtil pLblBusqueda) {
		this.lblBusqueda = pLblBusqueda;
	}

	/**
	 * @method	getLblReferencia
	 * 		  	Metodo get del atributo lblReferencia
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblReferencia devuelto
	 * @author	roberth.martinez
	 * @date  	20/03/2018
	 */
	public EtiquetaUtil getLblReferencia() {
		return this.lblReferencia;
	}

	/**
	 * @method	setLblReferencia
	 * 		  	Metodo set del atributo lblReferencia
	 * @param	pLblReferencia
	 * 			Valor que tomara el atributo lblReferencia
	 * @author	roberth.martinez
	 * @date	20/03/2018
	 */
	public void setLblReferencia(EtiquetaUtil pLblReferencia) {
		this.lblReferencia = pLblReferencia;
	}

	/**
	 * @method	getLblCorresponsal
	 * 		  	Metodo get del atributo lblCorresponsal
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblCorresponsal devuelto
	 * @author	roberth.martinez
	 * @date  	20/03/2018
	 */
	public EtiquetaUtil getLblCorresponsal() {
		return this.lblCorresponsal;
	}

	/**
	 * @method	setLblCorresponsal
	 * 		  	Metodo set del atributo lblCorresponsal
	 * @param	pLblCorresponsal
	 * 			Valor que tomara el atributo lblCorresponsal
	 * @author	roberth.martinez
	 * @date	20/03/2018
	 */
	public void setLblCorresponsal(EtiquetaUtil pLblCorresponsal) {
		this.lblCorresponsal = pLblCorresponsal;
	}

	/**
	 * @method	getLblEstadoRemesa
	 * 		  	Metodo get del atributo lblEstadoRemesa
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblEstadoRemesa devuelto
	 * @author	roberth.martinez
	 * @date  	20/03/2018
	 */
	public EtiquetaUtil getLblEstadoRemesa() {
		return this.lblEstadoRemesa;
	}

	/**
	 * @method	setLblEstadoRemesa
	 * 		  	Metodo set del atributo lblEstadoRemesa
	 * @param	pLblEstadoRemesa
	 * 			Valor que tomara el atributo lblEstadoRemesa
	 * @author	roberth.martinez
	 * @date	20/03/2018
	 */
	public void setLblEstadoRemesa(EtiquetaUtil pLblEstadoRemesa) {
		this.lblEstadoRemesa = pLblEstadoRemesa;
	}

	/**
	 * @method	getTxtReferencia
	 * 		  	Metodo get del atributo txtReferencia
	 * @return	CajaTextoUtil
	 *		  	Valor del atributo txtReferencia devuelto
	 * @author	roberth.martinez
	 * @date  	20/03/2018
	 */
	public CajaTextoUtil getTxtReferencia() {
		return this.txtReferencia;
	}

	/**
	 * @method	setTxtReferencia
	 * 		  	Metodo set del atributo txtReferencia
	 * @param	pTxtReferencia
	 * 			Valor que tomara el atributo txtReferencia
	 * @author	roberth.martinez
	 * @date	20/03/2018
	 */
	public void setTxtReferencia(CajaTextoUtil pTxtReferencia) {
		this.txtReferencia = pTxtReferencia;
	}

	/**
	 * @method	getTxtEstadoRemesa
	 * 		  	Metodo get del atributo txtEstadoRemesa
	 * @return	CajaTextoUtil
	 *		  	Valor del atributo txtEstadoRemesa devuelto
	 * @author	roberth.martinez
	 * @date  	20/03/2018
	 */
	public CajaTextoUtil getTxtEstadoRemesa() {
		return this.txtEstadoRemesa;
	}

	/**
	 * @method	setTxtEstadoRemesa
	 * 		  	Metodo set del atributo txtEstadoRemesa
	 * @param	pTxtEstadoRemesa
	 * 			Valor que tomara el atributo txtEstadoRemesa
	 * @author	roberth.martinez
	 * @date	20/03/2018
	 */
	public void setTxtEstadoRemesa(CajaTextoUtil pTxtEstadoRemesa) {
		this.txtEstadoRemesa = pTxtEstadoRemesa;
	}

	/**
	 * @method	getCmbCorresponsales
	 * 		  	Metodo get del atributo cmbCorresponsales
	 * @return	CajaComboUtil
	 *		  	Valor del atributo cmbCorresponsales devuelto
	 * @author	roberth.martinez
	 * @date  	20/03/2018
	 */
	public CajaComboUtil getCmbCorresponsales() {
		return this.cmbCorresponsales;
	}

	/**
	 * @method	setCmbCorresponsales
	 * 		  	Metodo set del atributo cmbCorresponsales
	 * @param	pCmbCorresponsales
	 * 			Valor que tomara el atributo cmbCorresponsales
	 * @author	roberth.martinez
	 * @date	20/03/2018
	 */
	public void setCmbCorresponsales(CajaComboUtil pCmbCorresponsales) {
		this.cmbCorresponsales = pCmbCorresponsales;
	}
	
	/**
	 * @method	getLblTipoDocumentoBen
	 * 		  	Metodo get del atributo lblTipoDocumentoBen
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblTipoDocumentoBen devuelto
	 * @author	roberth.martinez
	 * @date  	21/03/2018
	 */
	public EtiquetaUtil getLblTipoDocumentoBen() {
		return this.lblTipoDocumentoBen;
	}

	/**
	 * @method	setLblTipoDocumentoBen
	 * 		  	Metodo set del atributo lblTipoDocumentoBen
	 * @param	pLblTipoDocumentoBen
	 * 			Valor que tomara el atributo lblTipoDocumentoBen
	 * @author	roberth.martinez
	 * @date	21/03/2018
	 */
	public void setLblTipoDocumentoBen(EtiquetaUtil pLblTipoDocumentoBen) {
		this.lblTipoDocumentoBen = pLblTipoDocumentoBen;
	}

	/**
	 * @method	getLblDocumentoBen
	 * 		  	Metodo get del atributo lblDocumentoBen
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblDocumentoBen devuelto
	 * @author	roberth.martinez
	 * @date  	21/03/2018
	 */
	public EtiquetaUtil getLblDocumentoBen() {
		return this.lblDocumentoBen;
	}

	/**
	 * @method	setLblDocumentoBen
	 * 		  	Metodo set del atributo lblDocumentoBen
	 * @param	pLblDocumentoBen
	 * 			Valor que tomara el atributo lblDocumentoBen
	 * @author	roberth.martinez
	 * @date	21/03/2018
	 */
	public void setLblDocumentoBen(EtiquetaUtil pLblDocumentoBen) {
		this.lblDocumentoBen = pLblDocumentoBen;
	}

	/**
	 * @method	getLblNombreTerceroBen
	 * 		  	Metodo get del atributo lblNombreTerceroBen
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblNombreTerceroBen devuelto
	 * @author	roberth.martinez
	 * @date  	21/03/2018
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
	 * @date	21/03/2018
	 */
	public void setLblNombreTerceroBen(EtiquetaUtil pLblNombreTerceroBen) {
		this.lblNombreTerceroBen = pLblNombreTerceroBen;
	}

	/**
	 * @method	getLblApellidoTerceroBen
	 * 		  	Metodo get del atributo lblApellidoTerceroBen
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblApellidoTerceroBen devuelto
	 * @author	roberth.martinez
	 * @date  	21/03/2018
	 */
	public EtiquetaUtil getLblApellidoTerceroBen() {
		return this.lblApellidoTerceroBen;
	}

	/**
	 * @method	setLblApellidoTerceroBen
	 * 		  	Metodo set del atributo lblApellidoTerceroBen
	 * @param	pLblApellidoTerceroBen
	 * 			Valor que tomara el atributo lblApellidoTerceroBen
	 * @author	roberth.martinez
	 * @date	21/03/2018
	 */
	public void setLblApellidoTerceroBen(EtiquetaUtil pLblApellidoTerceroBen) {
		this.lblApellidoTerceroBen = pLblApellidoTerceroBen;
	}

	/**
	 * @method	getTxtDocumentoBen
	 * 		  	Metodo get del atributo txtDocumentoBen
	 * @return	CajaTextoUtil
	 *		  	Valor del atributo txtDocumentoBen devuelto
	 * @author	roberth.martinez
	 * @date  	21/03/2018
	 */
	public CajaTextoUtil getTxtDocumentoBen() {
		return this.txtDocumentoBen;
	}

	/**
	 * @method	setTxtDocumentoBen
	 * 		  	Metodo set del atributo txtDocumentoBen
	 * @param	pTxtDocumentoBen
	 * 			Valor que tomara el atributo txtDocumentoBen
	 * @author	roberth.martinez
	 * @date	21/03/2018
	 */
	public void setTxtDocumentoBen(CajaTextoUtil pTxtDocumentoBen) {
		this.txtDocumentoBen = pTxtDocumentoBen;
	}

	/**
	 * @method	getTxtNombreTerceroBen
	 * 		  	Metodo get del atributo txtNombreTerceroBen
	 * @return	CajaTextoUtil
	 *		  	Valor del atributo txtNombreTerceroBen devuelto
	 * @author	roberth.martinez
	 * @date  	21/03/2018
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
	 * @date	21/03/2018
	 */
	public void setTxtNombreTerceroBen(CajaTextoUtil pTxtNombreTerceroBen) {
		this.txtNombreTerceroBen = pTxtNombreTerceroBen;
	}

	/**
	 * @method	getTxtApellidoTerceroBen
	 * 		  	Metodo get del atributo txtApellidoTerceroBen
	 * @return	CajaTextoUtil
	 *		  	Valor del atributo txtApellidoTerceroBen devuelto
	 * @author	roberth.martinez
	 * @date  	21/03/2018
	 */
	public CajaTextoUtil getTxtApellidoTerceroBen() {
		return this.txtApellidoTerceroBen;
	}

	/**
	 * @method	setTxtApellidoTerceroBen
	 * 		  	Metodo set del atributo txtApellidoTerceroBen
	 * @param	pTxtApellidoTerceroBen
	 * 			Valor que tomara el atributo txtApellidoTerceroBen
	 * @author	roberth.martinez
	 * @date	21/03/2018
	 */
	public void setTxtApellidoTerceroBen(CajaTextoUtil pTxtApellidoTerceroBen) {
		this.txtApellidoTerceroBen = pTxtApellidoTerceroBen;
	}

	/**
	 * @method	getCmbTipoDocumentoBen
	 * 		  	Metodo get del atributo cmbTipoDocumentoBen
	 * @return	CajaComboUtil
	 *		  	Valor del atributo cmbTipoDocumentoBen devuelto
	 * @author	roberth.martinez
	 * @date  	21/03/2018
	 */
	public CajaComboUtil getCmbTipoDocumentoBen() {
		return this.cmbTipoDocumentoBen;
	}

	/**
	 * @method	setCmbTipoDocumentoBen
	 * 		  	Metodo set del atributo cmbTipoDocumentoBen
	 * @param	pCmbTipoDocumentoBen
	 * 			Valor que tomara el atributo cmbTipoDocumentoBen
	 * @author	roberth.martinez
	 * @date	21/03/2018
	 */
	public void setCmbTipoDocumentoBen(CajaComboUtil pCmbTipoDocumentoBen) {
		this.cmbTipoDocumentoBen = pCmbTipoDocumentoBen;
	}

	/**
	 * @method	getLblNombreTerceroRem
	 * 		  	Metodo get del atributo lblNombreTerceroRem
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblNombreTerceroRem devuelto
	 * @author	roberth.martinez
	 * @date  	21/03/2018
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
	 * @date	21/03/2018
	 */
	public void setLblNombreTerceroRem(EtiquetaUtil pLblNombreTerceroRem) {
		this.lblNombreTerceroRem = pLblNombreTerceroRem;
	}

	/**
	 * @method	getLblApellidoTerceroRem
	 * 		  	Metodo get del atributo lblApellidoTerceroRem
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblApellidoTerceroRem devuelto
	 * @author	roberth.martinez
	 * @date  	21/03/2018
	 */
	public EtiquetaUtil getLblApellidoTerceroRem() {
		return this.lblApellidoTerceroRem;
	}

	/**
	 * @method	setLblApellidoTerceroRem
	 * 		  	Metodo set del atributo lblApellidoTerceroRem
	 * @param	pLblApellidoTerceroRem
	 * 			Valor que tomara el atributo lblApellidoTerceroRem
	 * @author	roberth.martinez
	 * @date	21/03/2018
	 */
	public void setLblApellidoTerceroRem(EtiquetaUtil pLblApellidoTerceroRem) {
		this.lblApellidoTerceroRem = pLblApellidoTerceroRem;
	}

	/**
	 * @method	getTxtNombreTerceroRem
	 * 		  	Metodo get del atributo txtNombreTerceroRem
	 * @return	CajaTextoUtil
	 *		  	Valor del atributo txtNombreTerceroRem devuelto
	 * @author	roberth.martinez
	 * @date  	21/03/2018
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
	 * @date	21/03/2018
	 */
	public void setTxtNombreTerceroRem(CajaTextoUtil pTxtNombreTerceroRem) {
		this.txtNombreTerceroRem = pTxtNombreTerceroRem;
	}
	
	/**
	 * @method	getTxtApellidoTerceroRem
	 * 		  	Metodo get del atributo txtApellidoTerceroRem
	 * @return	CajaTextoUtil
	 *		  	Valor del atributo txtApellidoTerceroRem devuelto
	 * @author	roberth.martinez
	 * @date  	21/03/2018
	 */
	public CajaTextoUtil getTxtApellidoTerceroRem() {
		return this.txtApellidoTerceroRem;
	}

	/**
	 * @method	setTxtApellidoTerceroRem
	 * 		  	Metodo set del atributo txtApellidoTerceroRem
	 * @param	pTxtApellidoTerceroRem
	 * 			Valor que tomara el atributo txtApellidoTerceroRem
	 * @author	roberth.martinez
	 * @date	21/03/2018
	 */
	public void setTxtApellidoTerceroRem(CajaTextoUtil pTxtApellidoTerceroRem) {
		this.txtApellidoTerceroRem = pTxtApellidoTerceroRem;
	}

	/**
	 * @method	getPnlRemitente
	 * 		  	Metodo get del atributo pnlRemitente
	 * @return	SeccionUtil
	 *		  	Valor del atributo pnlRemitente devuelto
	 * @author	roberth.martinez
	 * @date  	30/03/2018
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
	 * @date	30/03/2018
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
	 * @date  	30/03/2018
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
	 * @date	30/03/2018
	 */
	public void setPnlBeneficiario(SeccionUtil pPnlBeneficiario) {
		pnlBeneficiario = pPnlBeneficiario;
	}

	/**
	 * @method	getPnlReferencia
	 * 		  	Metodo get del atributo pnlReferencia
	 * @return	SeccionUtil
	 *		  	Valor del atributo pnlReferencia devuelto
	 * @author	user
	 * @date  	30/03/2018
	 */
	public SeccionUtil getPnlReferencia() {
		return pnlReferencia;
	}

	/**
	 * @method	setPnlReferencia
	 * 		  	Metodo set del atributo pnlReferencia
	 * @param	pPnlReferencia
	 * 			Valor que tomara el atributo pnlReferencia
	 * @author	user
	 * @date	30/03/2018
	 */
	public void setPnlReferencia(SeccionUtil pPnlReferencia) {
		pnlReferencia = pPnlReferencia;
	}

	/**
	 * @method	getLblNumeroDocAlReves
	 * 		  	Metodo get del atributo lblNumeroDocAlReves
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblNumeroDocAlReves devuelto
	 * @author	roberth.martinez
	 * @date  	9/10/2018
	 */
	public EtiquetaUtil getLblNumeroDocAlReves() {
		return lblNumeroDocAlReves;
	}

	/**
	 * @method	setLblNumeroDocAlReves
	 * 		  	Metodo set del atributo lblNumeroDocAlReves
	 * @param	pLblNumeroDocAlReves
	 * 			Valor que tomara el atributo lblNumeroDocAlReves
	 * @author	roberth.martinez
	 * @date	9/10/2018
	 */
	public void setLblNumeroDocAlReves(EtiquetaUtil pLblNumeroDocAlReves) {
		this.lblNumeroDocAlReves = pLblNumeroDocAlReves;
	}

	/**
	 * @method	getTxtNumeroDocAlReves
	 * 		  	Metodo get del atributo txtNumeroDocAlReves
	 * @return	CajaTextoUtil
	 *		  	Valor del atributo txtNumeroDocAlReves devuelto
	 * @author	roberth.martinez
	 * @date  	9/10/2018
	 */
	public CajaTextoUtil getTxtNumeroDocAlReves() {
		return txtNumeroDocAlReves;
	}

	/**
	 * @method	setTxtNumeroDocAlReves
	 * 		  	Metodo set del atributo txtNumeroDocAlReves
	 * @param	pTxtNumeroDocAlReves
	 * 			Valor que tomara el atributo txtNumeroDocAlReves
	 * @author	roberth.martinez
	 * @date	9/10/2018
	 */
	public void setTxtNumeroDocAlReves(CajaTextoUtil pTxtNumeroDocAlReves) {
		this.txtNumeroDocAlReves = pTxtNumeroDocAlReves;
	}

	/**
	 * @method	getPnlDocumentoAlRevesDatAdd
	 * 		  	Metodo get del atributo pnlDocumentoAlRevesDatAdd
	 * @return	SeccionUtil
	 *		  	Valor del atributo pnlDocumentoAlRevesDatAdd devuelto
	 * @author	roberth.martinez
	 * @date  	9/10/2018
	 */
	public SeccionUtil getPnlDocumentoAlRevesDatAdd() {
		return pnlDocumentoAlRevesDatAdd;
	}

	/**
	 * @method	setPnlDocumentoAlRevesDatAdd
	 * 		  	Metodo set del atributo pnlDocumentoAlRevesDatAdd
	 * @param	pPnlDocumentoAlRevesDatAdd
	 * 			Valor que tomara el atributo pnlDocumentoAlRevesDatAdd
	 * @author	roberth.martinez
	 * @date	9/10/2018
	 */
	public void setPnlDocumentoAlRevesDatAdd(SeccionUtil pPnlDocumentoAlRevesDatAdd) {
		this.pnlDocumentoAlRevesDatAdd = pPnlDocumentoAlRevesDatAdd;
	}

	/**
	 * @method	getPnlContenedorDocAlRevesDatAdd
	 * 		  	Metodo get del atributo pnlContenedorDocAlRevesDatAdd
	 * @return	SeccionUtil
	 *		  	Valor del atributo pnlContenedorDocAlRevesDatAdd devuelto
	 * @author	roberth.martinez
	 * @date  	10/10/2018
	 */
	public SeccionUtil getPnlContenedorDocAlRevesDatAdd() {
		return pnlContenedorDocAlRevesDatAdd;
	}

	/**
	 * @method	setPnlContenedorDocAlRevesDatAdd
	 * 		  	Metodo set del atributo pnlContenedorDocAlRevesDatAdd
	 * @param	pPnlContenedorDocAlRevesDatAdd
	 * 			Valor que tomara el atributo pnlContenedorDocAlRevesDatAdd
	 * @author	roberth.martinez
	 * @date	10/10/2018
	 */
	public void setPnlContenedorDocAlRevesDatAdd(
			SeccionUtil pPnlContenedorDocAlRevesDatAdd) {
		this.pnlContenedorDocAlRevesDatAdd = pPnlContenedorDocAlRevesDatAdd;
	}

	/** 
	 * ********************************************************************
	 * @method main
	 * 		   metodo para ejcutar la forma
	 * @param  args
	 * 		   parametros entrada
	 * @author roberth.martinez
	 * @date   8/6/2016
	 * *********************************************************************
	 */
	public static void main(String[] args) {
		
		JFrame jframe = null;
		
		try{
	        
			jframe = TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaConsultaGiroInternacional.class,
																		    true, 
																		    EnumDesplegarFormaConEventos.SI);
			new FormaConsultaGiroInternacional(jframe,true);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			Logger.getInstance().error(e.getMessage());
			
		}
	}

	
	
}

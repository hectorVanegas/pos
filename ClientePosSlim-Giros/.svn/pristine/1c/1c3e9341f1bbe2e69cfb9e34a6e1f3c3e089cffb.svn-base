package co.com.codesa.clienteposslimgiros.formas.envioRemesaInternacional;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.envioRemesaInternacional.EventoFormaEnvioRemesaInternacional;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.BotonUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.GrillaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionDesplazableUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

/**
 * ***********************************************************************
 * @autor: Didier Silva
 * @fecha: 18-abr-2018
 * @descripcion: Clase que realiza la correspondiente gestion para enviar
 * 				 giros internacionales.
 * @copyright: Copyright  1998-2012 Codesa, Todos los derechos reservados.
 * ***********************************************************************
 */
public class FormaEnvioRemesaInternacional extends FormaGenerica {
	
	/**
	 *  @variable	serialVersionUID
	 *  			Variable serialVersionUID
	 */
	private static final long serialVersionUID = -5656404902873073148L;		
	
	/**
	 *  @variable lblTipoDocRemitente
	 *  		  etiqueta para indicar el componente grafico sobre la forma
	 *  		  que contiene el tipo de documento del remitente
	 */
	private EtiquetaUtil lblTipoDocRemitente;
	
	/**
	 * @variable  lblNumDocRemitente
	 *  		  etiqueta para indicar el componente grafico sobre la forma
	 *  		  que contiene el numero de documento del remitente
	 */
	private EtiquetaUtil lblNumDocRemitente;
	
	/**
	 * @variable  lblOpcionEnvio
	 *  		  etiqueta para indicar el componente grafico sobre la forma
	 *  		  que contiene la opcion de envio de remesa.
	 */
	private EtiquetaUtil lblOpcionEnvio;
	
	/**
	 * @variable  lblPais
	 *  		  etiqueta para indicar el componente grafico sobre la forma
	 *  		  que contiene el pais a donde va envada la remesa.
	 */
	private EtiquetaUtil lblPais;
	
	/**
	 * @variable  lblMonto
	 *  		  etiqueta para indicar el componente grafico sobre la forma
	 *  		  que contiene el monto a enviar.
	 */
	private EtiquetaUtil lblMonto;
	
	/**
	 * @variable txtNumDocRemitente
	 * 			 campo de texto sobre la forma que  contiene el numero de 
	 * 			 documento del remitente.
	 */
	private CajaTextoUtil txtNumDocRemitente;
	
	/**
	 * @variable txtMonto
	 * 			 campo de texto sobre la forma que  contiene el monto que
	 * 			 va ser enviado.
	 */
	private CajaTextoUtil txtMonto;
	
	/**
	 * @variable cmbTipoDocumentoRemitente
	 * 			 componente de combo sobre la forma que  contiene el listado 
	 * 		     de tipos de documentos.
	 **/
	private CajaComboUtil cmbTipoDocumentoRemitente;
	
	/**
	 * @variable cmbOpcion
	 * 			 componente de combo sobre la forma que  contiene el listado 
	 * 		     de los tipos de envio de remesa internacional.
	 **/
	private CajaComboUtil cmbOpcionEnvio;
	
	/**
	 * @variable cmbPais
	 * 			 componente de combo sobre la forma que  contiene el listado 
	 * 		     de paises a los cuales se pueden realizar envios de remesas.
	 **/
	private CajaComboUtil cmbPais;
	
	/**
	 * @variable btnCotizar
	 * 			 componente boton sobre la forma para manejar la funcionalida cotizar
	 **/
	private BotonUtil btnCotizar;
	
	/**
	 * @variable btnLimpiar
	 * 			 componente boton sobre la forma para manejar la funcionalida
	 * 			 de limpiar cada uno de los componentes
	 **/
	private BotonUtil btnLimpiar;
	
	/**
	 * @variable  lblNombreBeneficiario
	 *  		  etiqueta para indicar el componente grafico sobre la forma
	 *  		  que contiene el nombre del tercero destino.
	 */
	private EtiquetaUtil lblNombreBeneficiario;
	
	/**
	 * @variable  lblApellidoBeneficiario
	 *  		  etiqueta para indicar el componente grafico sobre la forma
	 *  		  que contiene el apellido del tercero destino.
	 */
	private EtiquetaUtil lblApellidoBeneficiario;
	
	/**
	 * @variable  lblNumeralesEnvio
	 *  		  etiqueta para indicar el componente grafico sobre la forma
	 *  		  que contiene el numeral de envio de la remesa.
	 */
	private EtiquetaUtil lblNumeralesEnvio;
	
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
	 * @variable txtNombreBeneficiario
	 * 			 campo de texto sobre la forma para diligenciar en nombre
	 * 			 del tercero a quien va dirigida la remesa
	 **/
	private CajaTextoUtil txtNombreBeneficiario;
	
	/**
	 * @variable txtApellidoBeneficiario
	 * 			 campo de texto sobre la forma para diligenciar el apellido
	 * 			 del tercero a quien va dirigida la remesa
	 **/
	private CajaTextoUtil txtApellidoBeneficiario;
	
	/**
	 * @variable cmbNumeralEnvio
	 * 			 componente de combo sobre la forma que  contiene el listado 
	 * 		     de numerales de envio de remesa
	 **/
	private CajaComboUtil cmbNumeralEnvio;
	
	/**
	 *  @variable lblMano
	 *  		  etiqueta para indicar el componente grafico sobre la forma
	 *  		  que contiene la mano a la que se le va tomar la huella.
	 */
	private EtiquetaUtil lblMano;
	
	/**
	 *  @variable lblDedo
	 *  		  etiqueta para indicar el componente grafico sobre la forma
	 *  		  que contiene el dedo especifico que se le va tomar la huella.
	 */
	private EtiquetaUtil lblDedo;
	
	/**
	 * @variable cmbMano
	 * 			 componente de combo sobre la forma que  contiene especificacion
	 * 			 de las dos manos.
	 **/
	private CajaComboUtil cmbMano;
	
	/**
	 * @variable cmbDedo
	 * 			 componente de combo sobre la forma que  contiene el listado 
	 * 		     de los dedos de la mano.
	 **/
	private CajaComboUtil cmbDedo;
	
	/**
	 * @variable btnTomarHuella
	 * 			 componente boton sobre la forma para manejar la funcionalida de
	 * 			 la toma de huella.
	 **/
	private BotonUtil btnTomarHuella;
	
	/**
	 * @variable btnSenalesAlerta
	 * 			 componente boton sobre la forma para manejar la funcionalida de
	 * 			 gestion de senales de alerta
	 **/
	private BotonUtil btnSenalesAlerta;
	
	/**
	 * @variable btnCapturarFotos
	 * 			 componente boton sobre la forma para manejar la funcionalida de Capturar Foto
	 **/
	private BotonUtil btnCapturarFotos;
	
	private SeccionUtil pnlCotizar;
	
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
	
	private JPanel pnlInfoBeneficiario;
	
	/**
	 * @variable lblCamposObligatorios
	 */
	private EtiquetaUtil lblCamposObligatorios;
	
	/**
	 * @variable grillaTiposEnvio
	 * 			 componente grilla sobre la forma que contiene el listado 
	 * 	   	     de los tipos de envio que se carga luego de realizar una
	 * 			 cotizacion.
	 **/
	private GrillaUtil grillaTiposEnvio;
	
	/**
	 * @variable scrollGrillaTiposEnvio
	 * 			 componente scrol sobre la forma para manejar el scroll 
	 * 			 del listado de tipos de envio.
	 **/
	private SeccionDesplazableUtil scrollGrillaTiposEnvio;

	public FormaEnvioRemesaInternacional(JFrame pFrmPadre,
										boolean pBooModal) throws Exception{
		
		super(pFrmPadre, 
			  pBooModal);
		
//		super.setBooDesaparecerVentanaPadre(true);
		
		super.setEventoForma(new EventoFormaEnvioRemesaInternacional(this));
		
		this.inicializarForma();
	}

	@Override
	public void inicializarForma(Object... pArrObjParametrosForma) throws Exception {
		
		super.setTituloForma(EnumEtiquetas.TTL_ENVIO_REMESA_INTERNACIONAL_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.FRM_EGI_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.FRM_EGI_VENTANA.getAlto());
		
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
		  						EnumBotonesEncabezado.BTNSALIR);
		
		super.iniciar(pArrObjParametrosForma);
	}

	@Override
	public JPanel inicializarEncabezado(Object... pArrObjParametrosForma)
			throws Exception {
		return null;
	}

	@Override
	public JPanel inicializarCuerpo(Object... pArrObjParametrosForma) throws Exception {
		
		JPanel pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_CGI_CUERPO_COTIZAR, 
																"pnlCotizar", 
																null, 
																null, 
																null);
		pnlCuerpo.add(this.iniciarPropLblCamposObligatorios());
		pnlCuerpo.add(this.iniciarPropPnlCotizar());
		pnlCuerpo.add(this.iniciarPropPnlInfoBeneficiario());
		pnlCuerpo.add(this.iniciarPropBtnSenalesAlerta());
		pnlCuerpo.add(this.iniciarPropBtnCapturarFotos());
		
		return pnlCuerpo;
	}

	@Override
	public JPanel inicializarPiePagina(Object... pArrObjParametrosForma)
			throws Exception {
		
		JPanel pnlPiePagina;
		
		pnlPiePagina = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_CGI_PIE_PAGINA_INTERNACIONAL, 
																   "pnlPiePagina", 
																   null, 
																   EnumEtiquetas.TTL_EGI_TIPOS_ENVIO_INTERNACIONAL, 
																   TitledBorder.LEFT);
		
		pnlPiePagina.add(this.iniciarPropScrollGrillaTiposEnvio());
//		pnlPiePagina.add(this.iniciarPropGrillaTiposEnvio());
		
		return pnlPiePagina;
	}
	
	public SeccionUtil iniciarPropPnlCotizar() throws Exception{
		
		if(this.pnlCotizar == null){
			
			this.pnlCotizar = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_EGI_COTIZAR_INTER, 
																		  "pnlCotizarInter", 
																		  null, 
																		  EnumEtiquetas.TTL_PNL_COTIZAR_INTERNACIONAL, 
																		  TitledBorder.LEFT);
			
			this.pnlCotizar.add(iniciarPropLblTipoDocRemitente());
			this.pnlCotizar.add(iniciarPropLblNumDocRemitente());
			this.pnlCotizar.add(iniciarPropLblOpcionEnvio());
			this.pnlCotizar.add(iniciarPropLblPais());
			this.pnlCotizar.add(iniciarPropLblMonto());
			this.pnlCotizar.add(iniciarPropTxtNumDocRemitente());
			this.pnlCotizar.add(iniciarPropCmbTipoDocumentoRemitente());
			this.pnlCotizar.add(iniciarPropCmbOpcionEnvio());
			this.pnlCotizar.add(iniciarPropCmbPais());
			this.pnlCotizar.add(iniciarPropTxtMonto());
			this.pnlCotizar.add(iniciarPropBtnCotizar());
			this.pnlCotizar.add(iniciarPropBtnLimpiar());
			//this.pnlCotizar.add(this.iniciarPropPnlCotizarEnvioRemesa());
		}
		
		return this.pnlCotizar;
	}
	
	public JPanel iniciarPropPnlInfoBeneficiario() throws Exception{
		
		if(this.pnlInfoBeneficiario == null){
			
			this.pnlInfoBeneficiario = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_EGI_BENEFICIARIO_INTER, 
																				   "pnlInfoBeneficiario", 
																				   null, 
																				   EnumEtiquetas.TTL_PNL_BENEFICIARIO_INTERNACIONAL,//enum 
																				   TitledBorder.LEFT);//int
			this.pnlInfoBeneficiario.add(this.iniciarPropLblNombreBeneficiario());
			this.pnlInfoBeneficiario.add(this.iniciarPropLblApellidoBeneficiario());
			this.pnlInfoBeneficiario.add(this.iniciarPropLblNumeralesEnvio());
			this.pnlInfoBeneficiario.add(this.iniciarPropTxtNombreBeneficiario());
			this.pnlInfoBeneficiario.add(this.iniciarPropTxtApellidoBeneficiario());
			this.pnlInfoBeneficiario.add(this.iniciarPropCmbNumeralEnvio());
			
//			this.pnlInfoBeneficiario.add(this.iniciaPropBeneficiarioInternacional());
		}
		
		return this.pnlInfoBeneficiario;
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
			this.pnlContenedorDocAlRevesDatAdd = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_EGI_CONTENEDOR_DOC_AL_REVES,
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
			this.pnlDocumentoAlRevesDatAdd = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_EGI_DOCUMENTO_AL_REVES,
																		 				 "pnlDocumentoAlRevesDatAdd",
																		 				 null,
																		 				 EnumEtiquetas.TTL_EGI_PNL_DOCUMENTO_AL_REVES,
																		 				 TitledBorder.LEFT);
			
			this.pnlDocumentoAlRevesDatAdd.add(this.iniciarPropLblNumeroDocAlReves());
			this.pnlDocumentoAlRevesDatAdd.add(this.iniciarPropTxtNumeroDocAlReves());
			
			
			this.pnlDocumentoAlRevesDatAdd.setBooAplicarTransparenciaFondo(true);
			
		}
		
		return this.pnlDocumentoAlRevesDatAdd;
	}
	
	public SeccionDesplazableUtil iniciarPropScrollGrillaTiposEnvio() throws Exception{
		
		if(this.scrollGrillaTiposEnvio == null){
			
			this.scrollGrillaTiposEnvio = UtilComponentesGUI.getInstance().crearScroll("scrGrillaTiposEnvio", 
																					   EnumDimensionesComponentes.GRI_EGI_GRID_TIPOS_ENVIO_INTERNACIONAL, 
																					   null);
			
			this.scrollGrillaTiposEnvio.setViewportView(this.iniciarPropGrillaTiposEnvio());
		}
		
		return this.scrollGrillaTiposEnvio;
	}
	
	public GrillaUtil iniciarPropGrillaTiposEnvio() throws Exception{
		
		if(this.grillaTiposEnvio == null){
			
			this.grillaTiposEnvio = UtilComponentesGUI.getInstance().crearGrilla("tblGrillaTiposEnvio", 
																				 new EnumEtiquetas []{EnumEtiquetas.TTL_EGI_GRILLA_TIPOS_ENVIO_CODIGO,
																									  EnumEtiquetas.TTL_EGI_GRILLA_TIPOS_ENVIO_DESCRIPCION,
																									  EnumEtiquetas.TTL_EGI_GRILLA_TIPOS_ENVIO_NOMBRE_OPCION,
																									  EnumEtiquetas.TTL_EGI_GRILLA_TIPOS_ENVIO_MONEDA_RECIBE,
																									  EnumEtiquetas.TTL_EGI_GRILLA_TIPOS_ENVIO_MONTO_RECIBE,
																									  EnumEtiquetas.TTL_EGI_GRILLA_TIPOS_ENVIO_TOTAL_ENVIO,
																									  EnumEtiquetas.TTL_EGI_GRILLA_TIPOS_ENVIO_TOTAL_COMISION}, 
																				 null,//invisibles
																				 new boolean[] {false,
																								false,
																								false},//editable por columna 
																				 new int[]{40,
																						   80,
																						   80,
																						   80,
																						   80,
																						   100,
																						   100},//Dimensiones 
																				 null);//evento
		}
		
		return this.grillaTiposEnvio;
	}
	
	public EtiquetaUtil iniciarPropLblTipoDocRemitente() throws Exception{
		
		if(this.lblTipoDocRemitente == null){
			
			this.lblTipoDocRemitente = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PNL_COTIZAR_TIPO_DOC_REMITENTE, 
																				   "lblTipoDocRemitente", 
																				   EnumEtiquetas.LBL_PNL_COTIZAR_TIPO_DOC_REMITENTE, 
																				   true, 
																				   null, 
																				   true);
		}
		
		return this.lblTipoDocRemitente;
	}
	
	public EtiquetaUtil iniciarPropLblNumDocRemitente() throws Exception{
		
		if(this.lblNumDocRemitente == null){
			
			this.lblNumDocRemitente = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PNL_COTIZAR_NUM_DOC_REMITENTE,
																				  "lblNumDocRemitente",
																				   EnumEtiquetas.LBL_PNL_COTIZAR_NUM_DOC_REMITENTE,
																				   true,
																				   null,
																				   true);
		}
		
		return this.lblNumDocRemitente;
	}
	
	public EtiquetaUtil iniciarPropLblOpcionEnvio() throws Exception{
		
		if(this.lblOpcionEnvio == null){
			
			this.lblOpcionEnvio = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PNL_COTIZAR_OPCION_ENVIO_REMITENTE, 
																			  "lblOpcionEnvio", 
																			  EnumEtiquetas.LBL_PNL_COTIZAR_OPCION_ENVIO_REMITENTE, 
																			  true, 
																			  null, 
																			  true);
		}
		
		return this.lblOpcionEnvio;
	}
	
	public EtiquetaUtil iniciarPropLblPais() throws Exception{
		
		if(this.lblPais == null){
			
			this.lblPais = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PNL_COTIZAR_PAIS_REMITENTE,
																	   "lblPais",
																	   EnumEtiquetas.LBL_PNL_COTIZAR_PAIS_REMITENTE,
																	   true,
																	   null,
																	   true);
		}
		
		return this.lblPais;
	}
	
	public EtiquetaUtil iniciarPropLblMonto() throws Exception{
		
		if(this.lblMonto == null){
			
			this.lblMonto = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PNL_COTIZAR_MONTO_REMITENTE,
																		"lblMonto",
																		EnumEtiquetas.LBL_PNL_COTIZAR_MONTO_REMITENTE,
																		true,
																		null,
																		true);
		}
		
		return this.lblMonto;
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
			
			this.lblNumeroDocAlReves = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_EGI_DOCUMENTO_AL_REVES, 
																	   	       	   "lblNumeroDocAlReves", 
																	   	       	   EnumEtiquetas.LBL_EGI_DOCUMENTO_AL_REVES,
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
			
			this.txtNumeroDocAlReves = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_EGI_DOCUMENTO_AL_REVES, 
																			 	       "txtNumeroDocAlReves", 
																			 	       "", 
																			 	       true, 
																			 	       true, 
																			 	       true,
																			 	       this.getEventoForma(),
																			 	       EnumEtiquetas.LBL_EGI_DOCUMENTO_AL_REVES);
		}

		return this.txtNumeroDocAlReves;
	}
	
	public CajaTextoUtil iniciarPropTxtNumDocRemitente() throws Exception{
		
		if(this.txtNumDocRemitente == null){
			
			this.txtNumDocRemitente = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_PNL_COTIZAR_NUM_DOC_REMITENTE, 
																				      "Nro documento remitente", 
																				      "", 
																				      true, 
																				      true, 
																				      true,
																				      this.getEventoForma(), 
																				      null);
			
			this.txtNumDocRemitente.setToolTipText(EnumEtiquetas.TLT_ERI_DOCUMENTO_REMITENTE);
		}
		
		return this.txtNumDocRemitente;
	}
	
	public CajaTextoUtil iniciarPropTxtMonto() throws Exception{
		
		if(this.txtMonto == null){
			
			this.txtMonto = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_PNL_COTIZAR_MONTO_REMITENTE, 
																				      "Monto", 
																				      "", 
																				      true, 
																				      true, 
																				      true,
																				      this.getEventoForma(), 
																				      null);
			this.txtMonto.setHorizontalAlignment(SwingConstants.TRAILING);
			this.txtMonto.setForeground(new java.awt.Color(0, 0, 0));
			this.txtMonto.setBackground(new java.awt.Color(164, 164, 255));
			this.txtMonto.setToolTipText(EnumEtiquetas.TLT_ERI_MONTO_ENVIO);
		}
		
		return this.txtMonto;
	}
	
	public CajaComboUtil iniciarPropCmbTipoDocumentoRemitente() throws Exception{
		
		if(this.cmbTipoDocumentoRemitente == null){
			
			this.cmbTipoDocumentoRemitente = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_PNL_COTIZAR_TIPO_DOC_REMITENTE,
																							"Tipo documento remitente",
																							true,
																							true,
																							this.getEventoForma(),
																							null);
		}
		
		return this.cmbTipoDocumentoRemitente;
	}
	
	public CajaComboUtil iniciarPropCmbOpcionEnvio() throws Exception{
		
		if(this.cmbOpcionEnvio == null){
			
			this.cmbOpcionEnvio = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_PNL_COTIZAR_OPCION_ENVIO_REMITENTE,
																				 "Opcion envio",
																				 true,
																				 true,
																				 this.getEventoForma(),
																				 null);
		}
		
		return this.cmbOpcionEnvio;
	}
	
	public CajaComboUtil iniciarPropCmbPais() throws Exception{
		
		if(this.cmbPais == null){
			
			this.cmbPais = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_PNL_COTIZAR_PAIS_REMITENTE,
																				 "Pais",
																				 true,
																				 true,
																				 this.getEventoForma(),
																				 null);
		}
		
		return this.cmbPais;
	}
	
	public BotonUtil iniciarPropBtnCotizar() throws Exception{
		
		if(this.btnCotizar == null){
			
			this.btnCotizar = UtilComponentesGUI.getInstance().crearBoton(EnumDimensionesComponentes.BTN_PNL_COTIZAR_BOTON_COTIZAR, 
																		  "btnCotizar", 
																		  EnumEtiquetas.BTN_PNL_COTIZAR_BOTON_COTIZAR, 
																		  true, 
																		  true,
																		  this.getEventoForma(), 
																		  null);
			
			this.btnCotizar.setToolTipText(EnumEtiquetas.TLT_ERI_BOTON_COTIZAR);
		}
		
		return this.btnCotizar;
	}
	
	public BotonUtil iniciarPropBtnLimpiar() throws Exception{
		
		if(this.btnLimpiar == null){
			
			this.btnLimpiar = UtilComponentesGUI.getInstance().crearBoton(EnumDimensionesComponentes.BTN_PNL_COTIZAR_BOTON_LIMPIAR, 
																		  "btnLimpiar", 
																		  EnumEtiquetas.BTN_PNL_COTIZAR_BOTON_LIMPIAR, 
																		  true, 
																		  true,
																		  this.getEventoForma(), 
																		  null);
			
			this.btnLimpiar.setToolTipText(EnumEtiquetas.TLT_ERI_BOTON_LIMPIAR);
		}
		
		return this.btnLimpiar;
	}
	
	public EtiquetaUtil iniciarPropLblNombreBeneficiario() throws Exception{
		
		if(this.lblNombreBeneficiario == null){
			
			this.lblNombreBeneficiario = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PNL_BENEFICIARIO_NOMBRE, 
																					 "lblNombreBeneficiario", 
																					 EnumEtiquetas.LBL_PNL_BENEFICIARIO_NOMBRE, 
																					 true, 
																					 null, 
																					 true);
		}
		
		return this.lblNombreBeneficiario;
	}

	public BotonUtil iniciarPropBtnSenalesAlerta() throws Exception{
	
	if(this.btnSenalesAlerta == null){
		
		this.btnSenalesAlerta = UtilComponentesGUI.getInstance().crearBoton(EnumDimensionesComponentes.BTN_EGI_GESTION_SENALES_ALERTA, 
																	  "btnSenalesAlerta", 
																	  EnumEtiquetas.BTN_PGI_GESTION_SENALES_ALERTA, 
																	  false, 
																	  true,
																	  this.getEventoForma(), 
																	  null);
		
		this.btnSenalesAlerta.setToolTipText(EnumEtiquetas.TLT_ERI_BOTON_SENALES_ALERTA);
	}
	
	return this.btnSenalesAlerta;
}
	
	public EtiquetaUtil iniciarPropLblApellidoBeneficiario() throws Exception{
		
		if(this.lblApellidoBeneficiario == null){
			
			this.lblApellidoBeneficiario = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PNL_BENEFICIARIO_APELLIDO, 
																					   "lblApellidoBeneficiario", 
																					   EnumEtiquetas.LBL_PNL_BENEFICIARIO_APELLIDO, 
																					   true, 
																					   null, 
																					   true);
		}
		
		return this.lblApellidoBeneficiario;
	}
	
	public EtiquetaUtil iniciarPropLblNumeralesEnvio() throws Exception{
		
		if(this.lblNumeralesEnvio == null){
			
			this.lblNumeralesEnvio = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PNL_BENEFICIARIO_NUMERAL_ENVIO, 
																					   "lblNumeralesEnvio", 
																					   EnumEtiquetas.CMB_PNL_BENEFICIARIO_NUMERALES_ENVIO, 
																					   true, 
																					   null, 
																					   true);
		}
		
		return this.lblNumeralesEnvio;
	}
	
	public CajaTextoUtil iniciarPropTxtNombreBeneficiario() throws Exception{
		
		if(this.txtNombreBeneficiario == null){
			
			this.txtNombreBeneficiario = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_PNL_BENEFICIARIO_NOMBRE, 
																						 "Nombre beneficiario", 
																						 "", 
																						 false, 
																						 true, 
																						 true, 
																						 this.getEventoForma(), 
																						 null);
			
			this.txtNombreBeneficiario.setToolTipText(EnumEtiquetas.TLT_ERI_NOMBRE_BENEFICIARIO);
			this.txtNombreBeneficiario.getPropiedades().setActivaMayusculaMinuscula(true);
		}
		
		return this.txtNombreBeneficiario;
	}
	
	public CajaTextoUtil iniciarPropTxtApellidoBeneficiario() throws Exception{
		
		if(this.txtApellidoBeneficiario == null){
			
			this.txtApellidoBeneficiario = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_PNL_BENEFICIARIO_APELLIDO, 
																						 "Apellido beneficiario", 
																						 "", 
																						 false, 
																						 true, 
																						 true, 
																						 this.getEventoForma(), 
																						 null);
			
			this.txtApellidoBeneficiario.setToolTipText(EnumEtiquetas.TLT_ERI_APELLIDO_BENEFICIARIO);
			this.txtApellidoBeneficiario.getPropiedades().setActivaMayusculaMinuscula(true);
		}
		
		return this.txtApellidoBeneficiario;
	}
	
	public CajaComboUtil iniciarPropCmbNumeralEnvio() throws Exception{
		
		if(this.cmbNumeralEnvio == null){
			
			this.cmbNumeralEnvio = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_PNL_BENEFICIARIO_NUMERALES_ENVIO, 
																				  "Numerales envio", 
																				  false, 
																				  true, 
																				  this.getEventoForma(), 
																				  null);
		}
		
		return this.cmbNumeralEnvio;
	}
	
	public EtiquetaUtil iniciarPropLblMano() throws Exception{
		
		if(this.lblMano == null){
			
			this.lblMano = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PNL_THREMITE_MANO, 
																	   "lblMano", 
																	   EnumEtiquetas.LBL_PNL_THREMITE_MANO, 
																	   true, 
																	   null, 
																	   true);
		}
		
		return this.lblMano;
	}
	
	public EtiquetaUtil iniciarPropLblDedo() throws Exception{
		
		if(this.lblDedo == null){
			
			this.lblDedo = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PNL_THREMITE_DEDO, 
																	   "lblDedo", 
																	   EnumEtiquetas.LBL_PNL_THREMITE_DEDO, 
																	   true, 
																	   null, 
																	   true);
		}
		
		return this.lblDedo;
	}
	
	public CajaComboUtil iniciarPropCmbMano() throws Exception{
		
		if(this.cmbMano == null){
			
			this.cmbMano = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_PNL_THREMITE_MANO, 
																		  "cmbMano", 
																		  false, 
																		  true, 
																		  this.getEventoForma(), 
																		  null);
		}
		
		return this.cmbMano;
	}
	
	public CajaComboUtil iniciarPropCmbDedo() throws Exception{
		
		if(this.cmbDedo == null){
			
			this.cmbDedo = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_PNL_THREMITE_DEDO, 
																		  "cmbDedo", 
																		  false, 
																		  true, 
																		  this.getEventoForma(), 
																		  null);
		}
		
		return this.cmbDedo;
	}
	
	public BotonUtil iniciarPropBtnTomarHuella() throws Exception{
		
		if(this.btnTomarHuella == null){
			
			this.btnTomarHuella = UtilComponentesGUI.getInstance().crearBoton(EnumDimensionesComponentes.BTN_PNL_THREMITE_TOMA_HUELLA, 
																			  "btnTomarHuella", 
																			  EnumEtiquetas.BTN_PNL_THREMITE_TOMA_HUELLA, 
																			  false, 
																			  true, 
																			  this.getEventoForma(), 
																			  null);
		}
		
		return this.btnTomarHuella;
	}
	
	private EtiquetaUtil iniciarPropLblCamposObligatorios() throws Exception{
		
		if(this.lblCamposObligatorios == null){
		
			this.lblCamposObligatorios = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_OII_PNL_CAMPOS_OBLIGATORIOS_ENVIO, 
																			   "lblCamposObligatorios", 
																			   EnumEtiquetas.LBL_OII_CAMPOS_OBLIGATORIOS, 
																			   false, 
																			   null, 
																			   true);
		}
	
		return this.lblCamposObligatorios;
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
			this.btnCapturarFotos = UtilComponentesGUI.getInstance().crearBoton(EnumDimensionesComponentes.BTN_EGI_CAPTURA_FOTOS, 
																	  	  		 "btnCapturarFotos", 
																	  	  		 EnumEtiquetas.BTN_PGI_CAPTURA_FOTOS, 
																	  	  		 false, 
																	  	  		 true, 
																	  	  		 this.getEventoForma(),  
																	  	  		 null);
			
//			this.btnCapturarFotos.setBorder(BorderFactory.createEmptyBorder());
			this.btnCapturarFotos.setToolTipText(EnumEtiquetas.TLT_ERI_BOTON_FOTOS);
		}

		return this.btnCapturarFotos;
	}
	
	public SeccionUtil getPnlCotizar() {
		return pnlCotizar;
	}

	public void setPnlCotizar(SeccionUtil pnlCotizar) {
		this.pnlCotizar = pnlCotizar;
	}

	public JPanel getPnlInfoBeneficiario() {
		return pnlInfoBeneficiario;
	}

	public void setPnlInfoBeneficiario(JPanel pnlInfoBeneficiario) {
		this.pnlInfoBeneficiario = pnlInfoBeneficiario;
	}

	public SeccionDesplazableUtil getScrollGrillaTiposEnvio() {
		return scrollGrillaTiposEnvio;
	}

	public void setScrollGrillaTiposEnvio(
			SeccionDesplazableUtil scrollGrillaTiposEnvio) {
		this.scrollGrillaTiposEnvio = scrollGrillaTiposEnvio;
	}

	public GrillaUtil getGrillaTiposEnvio() {
		return grillaTiposEnvio;
	}

	public void setGrillaTiposEnvio(GrillaUtil grillaTiposEnvio) {
		this.grillaTiposEnvio = grillaTiposEnvio;
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

		try{
			
			jframe = TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaEnvioRemesaInternacional.class,
																			true, 
																			EnumDesplegarFormaConEventos.SI);
			new FormaEnvioRemesaInternacional(null,
									  		  true);//COMPLETAR OBJETO
			
		} catch (Exception e) {
			
			UtilidadesGiros.getInstance().controlExcepcion(e, 
														   null);
		}
	}

	public EtiquetaUtil getLblTipoDocRemitente() {
		return lblTipoDocRemitente;
	}

	public void setLblTipoDocRemitente(EtiquetaUtil lblTipoDocRemitente) {
		this.lblTipoDocRemitente = lblTipoDocRemitente;
	}

	public EtiquetaUtil getLblNumDocRemitente() {
		return lblNumDocRemitente;
	}

	public void setLblNumDocRemitente(EtiquetaUtil lblNumDocRemitente) {
		this.lblNumDocRemitente = lblNumDocRemitente;
	}

	public EtiquetaUtil getLblOpcionEnvio() {
		return lblOpcionEnvio;
	}

	public void setLblOpcionEnvio(EtiquetaUtil lblOpcionEnvio) {
		this.lblOpcionEnvio = lblOpcionEnvio;
	}

	public EtiquetaUtil getLblPais() {
		return lblPais;
	}

	public void setLblPais(EtiquetaUtil lblPais) {
		this.lblPais = lblPais;
	}

	public EtiquetaUtil getLblMonto() {
		return lblMonto;
	}

	public void setLblMonto(EtiquetaUtil lblMonto) {
		this.lblMonto = lblMonto;
	}

	public CajaTextoUtil getTxtNumDocRemitente() {
		return txtNumDocRemitente;
	}

	public void setTxtNumDocRemitente(CajaTextoUtil txtNumDocRemitente) {
		this.txtNumDocRemitente = txtNumDocRemitente;
	}

	public CajaTextoUtil getTxtMonto() {
		return txtMonto;
	}

	public void setTxtMonto(CajaTextoUtil txtMonto) {
		this.txtMonto = txtMonto;
	}

	public CajaComboUtil getCmbTipoDocumentoRemitente() {
		return cmbTipoDocumentoRemitente;
	}

	public void setCmbTipoDocumentoRemitente(CajaComboUtil cmbTipoDocumentoRemitente) {
		this.cmbTipoDocumentoRemitente = cmbTipoDocumentoRemitente;
	}

	public CajaComboUtil getCmbOpcionEnvio() {
		return cmbOpcionEnvio;
	}

	public void setCmbOpcionEnvio(CajaComboUtil cmbOpcionEnvio) {
		this.cmbOpcionEnvio = cmbOpcionEnvio;
	}

	public CajaComboUtil getCmbPais() {
		return cmbPais;
	}

	public void setCmbPais(CajaComboUtil cmbPais) {
		this.cmbPais = cmbPais;
	}

	public BotonUtil getBtnCotizar() {
		return btnCotizar;
	}

	public void setBtnCotizar(BotonUtil btnCotizar) {
		this.btnCotizar = btnCotizar;
	}

	public BotonUtil getBtnLimpiar() {
		return btnLimpiar;
	}

	public void setBtnLimpiar(BotonUtil btnLimpiar) {
		this.btnLimpiar = btnLimpiar;
	}
	
	public CajaTextoUtil getTxtNombreBeneficiario() {
		return txtNombreBeneficiario;
	}

	public void setTxtNombreBeneficiario(CajaTextoUtil txtNombreBeneficiario) {
		this.txtNombreBeneficiario = txtNombreBeneficiario;
	}

	public CajaTextoUtil getTxtApellidoBeneficiario() {
		return txtApellidoBeneficiario;
	}

	public void setTxtApellidoBeneficiario(CajaTextoUtil txtApellidoBeneficiario) {
		this.txtApellidoBeneficiario = txtApellidoBeneficiario;
	}

	public CajaComboUtil getCmbNumeralEnvio() {
		return cmbNumeralEnvio;
	}

	public void setCmbNumeralEnvio(CajaComboUtil cmbNumeralEnvio) {
		this.cmbNumeralEnvio = cmbNumeralEnvio;
	}

	public EtiquetaUtil getLblNombreBeneficiario() {
		return lblNombreBeneficiario;
	}

	public void setLblNombreBeneficiario(EtiquetaUtil lblNombreBeneficiario) {
		this.lblNombreBeneficiario = lblNombreBeneficiario;
	}

	public EtiquetaUtil getLblApellidoBeneficiario() {
		return lblApellidoBeneficiario;
	}

	public void setLblApellidoBeneficiario(EtiquetaUtil lblApellidoBeneficiario) {
		this.lblApellidoBeneficiario = lblApellidoBeneficiario;
	}

	public EtiquetaUtil getLblNumeralesEnvio() {
		return lblNumeralesEnvio;
	}

	public void setLblNumeralesEnvio(EtiquetaUtil lblNumeralesEnvio) {
		this.lblNumeralesEnvio = lblNumeralesEnvio;
	}
	
	public EtiquetaUtil getLblMano() {
		return lblMano;
	}

	public void setLblMano(EtiquetaUtil lblMano) {
		this.lblMano = lblMano;
	}

	public EtiquetaUtil getLblDedo() {
		return lblDedo;
	}

	public void setLblDedo(EtiquetaUtil lblDedo) {
		this.lblDedo = lblDedo;
	}

	public CajaComboUtil getCmbMano() {
		return cmbMano;
	}

	public void setCmbMano(CajaComboUtil cmbMano) {
		this.cmbMano = cmbMano;
	}

	public CajaComboUtil getCmbDedo() {
		return cmbDedo;
	}

	public void setCmbDedo(CajaComboUtil cmbDedo) {
		this.cmbDedo = cmbDedo;
	}

	public BotonUtil getBtnTomarHuella() {
		return btnTomarHuella;
	}

	public void setBtnTomarHuella(BotonUtil btnTomarHuella) {
		this.btnTomarHuella = btnTomarHuella;
	}

	public BotonUtil getBtnSenalesAlerta() {
		return btnSenalesAlerta;
	}

	public void setBtnSenalesAlerta(BotonUtil pBtnSenalesAlerta) {
		this.btnSenalesAlerta = pBtnSenalesAlerta;
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
	 * @method	getLblNumeroDocAlReves
	 * 		  	Metodo get del atributo lblNumeroDocAlReves
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblNumeroDocAlReves devuelto
	 * @author	roberth.martinez
	 * @date  	11/10/2018
	 */
	public EtiquetaUtil getLblNumeroDocAlReves() {
		return this.lblNumeroDocAlReves;
	}

	/**
	 * @method	setLblNumeroDocAlReves
	 * 		  	Metodo set del atributo lblNumeroDocAlReves
	 * @param	pLblNumeroDocAlReves
	 * 			Valor que tomara el atributo lblNumeroDocAlReves
	 * @author	roberth.martinez
	 * @date	11/10/2018
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
	 * @date  	11/10/2018
	 */
	public CajaTextoUtil getTxtNumeroDocAlReves() {
		return this.txtNumeroDocAlReves;
	}

	/**
	 * @method	setTxtNumeroDocAlReves
	 * 		  	Metodo set del atributo txtNumeroDocAlReves
	 * @param	pTxtNumeroDocAlReves
	 * 			Valor que tomara el atributo txtNumeroDocAlReves
	 * @author	roberth.martinez
	 * @date	11/10/2018
	 */
	public void setTxtNumeroDocAlReves(CajaTextoUtil pTxtNumeroDocAlReves) {
		this.txtNumeroDocAlReves = pTxtNumeroDocAlReves;
	}

	/**
	 * @method	getPnlContenedorDocAlRevesDatAdd
	 * 		  	Metodo get del atributo pnlContenedorDocAlRevesDatAdd
	 * @return	SeccionUtil
	 *		  	Valor del atributo pnlContenedorDocAlRevesDatAdd devuelto
	 * @author	roberth.martinez
	 * @date  	11/10/2018
	 */
	public SeccionUtil getPnlContenedorDocAlRevesDatAdd() {
		return this.pnlContenedorDocAlRevesDatAdd;
	}

	/**
	 * @method	setPnlContenedorDocAlRevesDatAdd
	 * 		  	Metodo set del atributo pnlContenedorDocAlRevesDatAdd
	 * @param	pPnlContenedorDocAlRevesDatAdd
	 * 			Valor que tomara el atributo pnlContenedorDocAlRevesDatAdd
	 * @author	roberth.martinez
	 * @date	11/10/2018
	 */
	public void setPnlContenedorDocAlRevesDatAdd(
			SeccionUtil pPnlContenedorDocAlRevesDatAdd) {
		this.pnlContenedorDocAlRevesDatAdd = pPnlContenedorDocAlRevesDatAdd;
	}

	/**
	 * @method	getPnlDocumentoAlRevesDatAdd
	 * 		  	Metodo get del atributo pnlDocumentoAlRevesDatAdd
	 * @return	SeccionUtil
	 *		  	Valor del atributo pnlDocumentoAlRevesDatAdd devuelto
	 * @author	roberth.martinez
	 * @date  	11/10/2018
	 */
	public SeccionUtil getPnlDocumentoAlRevesDatAdd() {
		return this.pnlDocumentoAlRevesDatAdd;
	}

	/**
	 * @method	setPnlDocumentoAlRevesDatAdd
	 * 		  	Metodo set del atributo pnlDocumentoAlRevesDatAdd
	 * @param	pPnlDocumentoAlRevesDatAdd
	 * 			Valor que tomara el atributo pnlDocumentoAlRevesDatAdd
	 * @author	roberth.martinez
	 * @date	11/10/2018
	 */
	public void setPnlDocumentoAlRevesDatAdd(SeccionUtil pPnlDocumentoAlRevesDatAdd) {
		this.pnlDocumentoAlRevesDatAdd = pPnlDocumentoAlRevesDatAdd;
	}
}

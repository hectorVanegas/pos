package co.com.codesa.clienteposslimgiros.formas.superCombo;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.superCombo.EventoFormaProtegiroInternacional;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TerceroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TipoDocumentoInternacional;


/** 
 * ********************************************************************
 * @class	FormaProtegiroInternacional
 *		 	Clase para ofrecer el protegiro internacional 
 * @author	roberth.martinez
 * @date  	22/04/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class FormaProtegiroInternacional extends FormaGenerica{

	/**
	 * @variable serialVersionUID
	 * 			 variable serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @variable	pnlBeneficiario
	 * 				panel beneficiario
	 */
	private SeccionUtil pnlBeneficiario;
	
	/**
	 * @variable	lblTipoIdentificacion
	 * 				etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 	indica label de Tipo de identificacion del beneficiario
	 */
	private EtiquetaUtil lblTipoIdentificacion;
	
	/**
	 * @variable	lblIdentificacion
	 * 				etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 	indica label de identificacion del beneficiario
	 */
	private EtiquetaUtil lblIdentificacion;
	
	/**
	 * @variable	lblNombre
	 * 				etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 	indica label de nombre del beneficiario
	 */
	private EtiquetaUtil lblNombre;
	
	/**
	 * @variable	lblTelefono
	 * 				etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 	indica label de telefono del beneficiario
	 */
	private EtiquetaUtil lblTelefono;
	
	/**
	 * @variable	lblValorPrima
	 * 				[etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 	indica label de valor de prima del seguro
	 */
	private EtiquetaUtil lblValorPrima;
	
	/**
	 * @variable	lblVlrPrima
	 * 				etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 	indica label de vlr prima en pesos
	 */
	private EtiquetaUtil lblVlrPrima;
	
	/**
	 * @variable	lblBeneficios
	 * 				etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 	indica label de beneficios
	 */
	private EtiquetaUtil lblBeneficios;
	
	/**
	 * @variable	lblNotificacion
	 * 				etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 	indica label de notificacion via sms al beneficiario
	 */
	private EtiquetaUtil lblNotificacion;
	
	/**
	 * @variable	lblValorProtegiro
	 * 				etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 	indica label de valor del protegiro
	 */
	private EtiquetaUtil lblValorProtegiro;
	
	/**
	 * @variable	lblVlrProtegiro
	 * 				etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 	indica label de vlr del protegiro en pesos
	 */
	private EtiquetaUtil lblVlrProtegiro;
	
	/**
	 * @variable	txtTipoIdentificacion
	 * 				campo de texto sobre la forma para diligenciar el tipo 
	 * 				de identificacion del beneficiario
	 */
	private CajaTextoUtil txtTipoIdentificacion;
	
	/**
	 * @variable	txtIdentificacion
	 * 				campo de texto sobre la forma para diligenciar la identificacion
	 * 				del beneficiario
	 */
	private CajaTextoUtil txtIdentificacion;
	
	/**
	 * @variable	txtNombre
	 * 				campo de texto sobre la forma para diligenciar nombre del 
	 *				beneficiario
	 */
	private CajaTextoUtil txtNombre;
	
	/**
	 * @variable	txtTelefonoBeneficiario
	 * 				campo de texto sobre la forma para diligenciar el telefono
	 * 				del beneficiario
	 */
	private CajaTextoUtil txtTelefono;

	/**
	 * ********************************************************************
	 * @method	FormaProtegiroInternacional
	 * 		  	Constructor que ejecuta la inicializacion de valores y 
  	 * 		   	ejecucion de comportamientos inicales requeridos para el 
  	 * 		   	despliegue de la forma FormaProtegiroInternacional
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
	 * @date	22/04/2018
	 * *********************************************************************
	 */
	public FormaProtegiroInternacional(FormaGenerica pFrmPadre, 
								 	   boolean pBooModal,
								 	   FacturaGiroInternacional pObjFacturaGiroInternacional) throws Exception {
		
		super(pFrmPadre, 
			  pBooModal);
		
		super.setEventoForma(new EventoFormaProtegiroInternacional(this,
													 			   pObjFacturaGiroInternacional));
		
		this.inicializarForma();
	}

	@Override
	public void inicializarForma(Object... pArrObjParametrosForma) throws Exception {
		super.setTituloForma(EnumEtiquetas.TTL_SPGI_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.GUI_SPGI_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.GUI_SPGI_VENTANA.getAlto());
		
		if (this.castEvtfrmProtegiroInternacional().getObjFacturaGiroInternacional().isProtegiroInducido()) {
			super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR);
		}else{
			super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
									EnumBotonesEncabezado.BTN_ANULAR);
		}
		
		super.iniciar(pArrObjParametrosForma);
	}

	@Override
	public JPanel inicializarEncabezado(Object... pArrObjParametrosForma) throws Exception {
		
		JPanel pnlEncabezado;
		
		pnlEncabezado = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_SPGI_ENCABEZADO,
																	"pnlEncabezado",
		  														 	BorderFactory.createEmptyBorder(),
		  														 	null,
		  														 	null);
		
		pnlEncabezado.add(this.iniciarPropPnlBeneficiario());
		
		return pnlEncabezado;
	}

	@Override
	public JPanel inicializarCuerpo(Object... pArrObjParametrosForma) throws Exception {
		
		JPanel pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_SPGI_CUERPO,
																"pnlCuerpo",
		  													 	null,
		  													 	null,
		  													 	null);
		pnlCuerpo.add(this.iniciarPropLblValorPrima());
		pnlCuerpo.add(this.iniciarPropLblVlrPrima());
		pnlCuerpo.add(this.iniciarPropLblBeneficios());
		pnlCuerpo.add(this.iniciarPropLblNotificacion());
		pnlCuerpo.add(this.iniciarPropLblValorProtegiro());
		pnlCuerpo.add(this.iniciarPropLblVlrProtegiro());
		
		
		return pnlCuerpo;
	}

	@Override
	public JPanel inicializarPiePagina(Object... pArrObjParametrosForma) throws Exception {
		return null;
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
			
			this.pnlBeneficiario = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_SPGI_BENEFICIARIO,
																			   "pnlBeneficiario",
																  		  		null,
																  		  		EnumEtiquetas.TTL_PGI_PNL_BENEFICIARIO,
																  		  		null);
			
			this.pnlBeneficiario.add(iniciarPropLblTipoIdentificacion());
			this.pnlBeneficiario.add(iniciarPropTxtTipoIdentificacion());
			this.pnlBeneficiario.add(iniciarPropLblIdentificacion());
			this.pnlBeneficiario.add(iniciarPropTxtIdentificacion());
			this.pnlBeneficiario.add(iniciarPropLblNombre());
			this.pnlBeneficiario.add(iniciarPropTxtNombre());
			this.pnlBeneficiario.add(iniciarPropLblTelefono());
			this.pnlBeneficiario.add(iniciarPropTxtTelefono());
			
		}
		
		return this.pnlBeneficiario;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblTipoIdentificacion
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblTipoIdentificacion
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	22/04/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblTipoIdentificacion() throws Exception{
		
		this.lblTipoIdentificacion = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_SPGI_TIPO_IDENTIFICACION, 
				   												   	   			 "lblTipoIdentificacion", 
				   												   	   			 EnumEtiquetas.LBL_SPGI_TIPO_IDENTIFICACION,
				   												   	   			 false,
				   												   	   			 null,
				   												   	   			 true);
		
		return this.lblTipoIdentificacion;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropTxtTipoIdentificacion
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtTipoIdentificacion
	 * @return	CajaTextoUtil
	 * 			Caja de texto gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	22/04/2018
	 * *********************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtTipoIdentificacion()throws Exception{
		
		this.txtTipoIdentificacion = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_SPGI_TIPO_IDENTIFICACION, 
																					 "txtTipoIdentificacion", 
																					 "",
																					 true, 
																					 false, 
																					 true, 
																					 super.getEventoForma(),
																					 null);
		return this.txtTipoIdentificacion;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblIdentificacion
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblIdentificacion
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	22/04/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblIdentificacion() throws Exception{
		
		this.lblIdentificacion = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_SPGI_IDENTIFICACION, 
																			 "lblIdentificacion", 
																			 EnumEtiquetas.LBL_SPGI_IDENTIFICACION,
																			 false,
																			 null,
																			 true);
		
		return this.lblIdentificacion;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropTxtIdentificacion
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtIdentificacion
	 * @return	CajaTextoUtil
	 * 			Caja de texto gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	22/04/2018
	 * *********************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtIdentificacion()throws Exception{
		
		this.txtIdentificacion = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_SPGI_IDENTIFICACION, 
																					 "txtIdentificacion", 
																					 "",
																					 true, 
																					 false, 
																					 true, 
																					 super.getEventoForma(),
																					 null);
		return this.txtIdentificacion;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblNombre
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblNombre
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	22/04/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblNombre() throws Exception{
		
		this.lblNombre = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_SPGI_NOMBRE, 
																	 "lblNombre", 
																	 EnumEtiquetas.LBL_SPGI_NOMBRE,
																	 false,
																	 null,
																	 true);
		
		return this.lblNombre;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropTxtNombre
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtNombre
	 * @return	CajaTextoUtil
	 * 			Caja de texto gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	22/04/2018
	 * *********************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtNombre()throws Exception{
		
		this.txtNombre = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_SPGI_NOMBRE, 
																		 "txtNombre", 
																		 "",
																		 true, 
																		 false, 
																		 true, 
																		 super.getEventoForma(),
																		 null);
		return this.txtNombre;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblTelefono
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblTelefono
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	22/04/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblTelefono() throws Exception{
		
		this.lblTelefono = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_SPGI_TELEFONO, 
																	   "lblTelefono", 
																	   EnumEtiquetas.LBL_SPGI_TELEFONO,
																	   false,
																	   null,
																	   true);
		
		return this.lblTelefono;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropTxtTelefono
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtTelefono
	 * @return	CajaTextoUtil
	 * 			Caja de texto gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	22/04/2018
	 * *********************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtTelefono()throws Exception{
		
		this.txtTelefono = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_SPGI_TELEFONO, 
				  														   "txtTelefono", 
				  														   "",
				  														   true, 
				  														   true, 
				  														   true, 
				  														   super.getEventoForma(),
				  														   null);
		return this.txtTelefono;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblValorPrima
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblValorPrima
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	22/04/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblValorPrima() throws Exception{
		
		this.lblValorPrima = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_SPGI_VALOR_PRIMA, 
																	 	 "lblValorPrima", 
																	 	 EnumEtiquetas.LBL_SPGI_VALOR_PRIMA,
																	 	 false,
																	 	 null,
																	 	 true);
		
		return this.lblValorPrima;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblVlrPrima
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblVlrPrima
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	22/04/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblVlrPrima() throws Exception{
		
		this.lblVlrPrima = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_SPGI_VLR_PRIMA, 
																	   "lblVlrPrima", 
																	   null,
																	   false,
																	   null,
																	   true);
		
		return this.lblVlrPrima;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblBeneficios
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblBeneficios
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	22/04/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblBeneficios() throws Exception{
		
		this.lblBeneficios = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_SPGI_BENEFICIOS, 
																	     "lblBeneficios", 
																	     EnumEtiquetas.LBL_SPGI_BENEFICIOS,
																	     false,
																	     null,
																	     true);
		
		return this.lblBeneficios;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblNotificacion
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblNotificacion
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	22/04/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblNotificacion() throws Exception{
		
		this.lblNotificacion = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_SPGI_NOTIFICACION, 
																	   	   "lblNotificacion", 
																	   	   EnumEtiquetas.LBL_SPGI_NOTIFICACION,
																	   	   false,
																	   	   null,
																	   	   true);
		
		this.lblNotificacion.setFont(this.lblNotificacion.getFont().deriveFont(Font.BOLD,12));
		
		return this.lblNotificacion;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblValorProtegiro
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblValorProtegiro
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	22/04/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblValorProtegiro() throws Exception{
		
		this.lblValorProtegiro = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_SPGI_VALOR_PROTEGIRO, 
																	   	  	 "lblValorProtegiro", 
																	   	  	 EnumEtiquetas.LBL_SPGI_VALOR_PROTEGIRO,
																	   	  	 false,
																	   	  	 null,
																	   	  	 true);
		
		return this.lblValorProtegiro;
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
	 * @date   	22/04/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblVlrProtegiro() throws Exception{
		
		this.lblVlrProtegiro = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_SPGI_VLR_PROTEGIRO, 
																	   	   "lblVlrProtegiro", 
																	   	   null,
																	   	   false,
																	   	   null,
																	   	   true);
		
		return this.lblVlrProtegiro;
	}

	/**
	 * @method	getLblTipoIdentificacion
	 * 		  	Metodo get del atributo lblTipoIdentificacion
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblTipoIdentificacion devuelto
	 * @author	roberth.martinez
	 * @date  	22/04/2018
	 */
	public EtiquetaUtil getLblTipoIdentificacion() {
		return lblTipoIdentificacion;
	}

	/**
	 * @method	setLblTipoIdentificacion
	 * 		  	Metodo set del atributo lblTipoIdentificacion
	 * @param	pLblTipoIdentificacion
	 * 			Valor que tomara el atributo lblTipoIdentificacion
	 * @author	roberth.martinez
	 * @date	22/04/2018
	 */
	public void setLblTipoIdentificacion(EtiquetaUtil pLblTipoIdentificacion) {
		lblTipoIdentificacion = pLblTipoIdentificacion;
	}

	/**
	 * @method	getLblIdentificacion
	 * 		  	Metodo get del atributo lblIdentificacion
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblIdentificacion devuelto
	 * @author	roberth.martinez
	 * @date  	22/04/2018
	 */
	public EtiquetaUtil getLblIdentificacion() {
		return lblIdentificacion;
	}

	/**
	 * @method	setLblIdentificacion
	 * 		  	Metodo set del atributo lblIdentificacion
	 * @param	pLblIdentificacion
	 * 			Valor que tomara el atributo lblIdentificacion
	 * @author	roberth.martinez
	 * @date	22/04/2018
	 */
	public void setLblIdentificacion(EtiquetaUtil pLblIdentificacion) {
		lblIdentificacion = pLblIdentificacion;
	}

	/**
	 * @method	getPnlBeneficiario
	 * 		  	Metodo get del atributo pnlBeneficiario
	 * @return	SeccionUtil
	 *		  	Valor del atributo pnlBeneficiario devuelto
	 * @author	roberth.martinez
	 * @date  	22/04/2018
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
	 * @date	22/04/2018
	 */
	public void setPnlBeneficiario(SeccionUtil pPnlBeneficiario) {
		pnlBeneficiario = pPnlBeneficiario;
	}

	/**
	 * @method	getLblValorPrima
	 * 		  	Metodo get del atributo lblValorPrima
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblValorPrima devuelto
	 * @author	roberth.martinez
	 * @date  	22/04/2018
	 */
	public EtiquetaUtil getLblValorPrima() {
		return lblValorPrima;
	}

	/**
	 * @method	setLblValorPrima
	 * 		  	Metodo set del atributo lblValorPrima
	 * @param	pLblValorPrima
	 * 			Valor que tomara el atributo lblValorPrima
	 * @author	roberth.martinez
	 * @date	22/04/2018
	 */
	public void setLblValorPrima(EtiquetaUtil pLblValorPrima) {
		lblValorPrima = pLblValorPrima;
	}

	/**
	 * @method	getLblVlrPrima
	 * 		  	Metodo get del atributo lblVlrPrima
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblVlrPrima devuelto
	 * @author	roberth.martinez
	 * @date  	22/04/2018
	 */
	public EtiquetaUtil getLblVlrPrima() {
		return lblVlrPrima;
	}

	/**
	 * @method	setLblVlrPrima
	 * 		  	Metodo set del atributo lblVlrPrima
	 * @param	pLblVlrPrima
	 * 			Valor que tomara el atributo lblVlrPrima
	 * @author	roberth.martinez
	 * @date	22/04/2018
	 */
	public void setLblVlrPrima(EtiquetaUtil pLblVlrPrima) {
		lblVlrPrima = pLblVlrPrima;
	}

	/**
	 * @method	getLblBeneficios
	 * 		  	Metodo get del atributo lblBeneficios
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblBeneficios devuelto
	 * @author	roberth.martinez
	 * @date  	22/04/2018
	 */
	public EtiquetaUtil getLblBeneficios() {
		return lblBeneficios;
	}

	/**
	 * @method	setLblBeneficios
	 * 		  	Metodo set del atributo lblBeneficios
	 * @param	pLblBeneficios
	 * 			Valor que tomara el atributo lblBeneficios
	 * @author	roberth.martinez
	 * @date	22/04/2018
	 */
	public void setLblBeneficios(EtiquetaUtil pLblBeneficios) {
		lblBeneficios = pLblBeneficios;
	}

	/**
	 * @method	getLblNotificacion
	 * 		  	Metodo get del atributo lblNotificacion
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblNotificacion devuelto
	 * @author	roberth.martinez
	 * @date  	22/04/2018
	 */
	public EtiquetaUtil getLblNotificacion() {
		return lblNotificacion;
	}

	/**
	 * @method	setLblNotificacion
	 * 		  	Metodo set del atributo lblNotificacion
	 * @param	pLblNotificacion
	 * 			Valor que tomara el atributo lblNotificacion
	 * @author	roberth.martinez
	 * @date	22/04/2018
	 */
	public void setLblNotificacion(EtiquetaUtil pLblNotificacion) {
		lblNotificacion = pLblNotificacion;
	}

	/**
	 * @method	getLblValorProtegiro
	 * 		  	Metodo get del atributo lblValorProtegiro
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblValorProtegiro devuelto
	 * @author	roberth.martinez
	 * @date  	22/04/2018
	 */
	public EtiquetaUtil getLblValorProtegiro() {
		return lblValorProtegiro;
	}

	/**
	 * @method	setLblValorProtegiro
	 * 		  	Metodo set del atributo lblValorProtegiro
	 * @param	pLblValorProtegiro
	 * 			Valor que tomara el atributo lblValorProtegiro
	 * @author	roberth.martinez
	 * @date	22/04/2018
	 */
	public void setLblValorProtegiro(EtiquetaUtil pLblValorProtegiro) {
		lblValorProtegiro = pLblValorProtegiro;
	}

	/**
	 * @method	getLblVlrProtegiro
	 * 		  	Metodo get del atributo lblVlrProtegiro
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblVlrProtegiro devuelto
	 * @author	roberth.martinez
	 * @date  	22/04/2018
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
	 * @date	22/04/2018
	 */
	public void setLblVlrProtegiro(EtiquetaUtil pLblVlrProtegiro) {
		lblVlrProtegiro = pLblVlrProtegiro;
	}

	/**
	 * @method	getLblNombre
	 * 		  	Metodo get del atributo lblNombre
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblNombre devuelto
	 * @author	roberth.martinez
	 * @date  	22/04/2018
	 */
	public EtiquetaUtil getLblNombre() {
		return lblNombre;
	}

	/**
	 * @method	setLblNombre
	 * 		  	Metodo set del atributo lblNombre
	 * @param	pLblNombre
	 * 			Valor que tomara el atributo lblNombre
	 * @author	roberth.martinez
	 * @date	22/04/2018
	 */
	public void setLblNombre(EtiquetaUtil pLblNombre) {
		lblNombre = pLblNombre;
	}

	/**
	 * @method	getLblTelefono
	 * 		  	Metodo get del atributo lblTelefono
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblTelefono devuelto
	 * @author	roberth.martinez
	 * @date  	22/04/2018
	 */
	public EtiquetaUtil getLblTelefono() {
		return lblTelefono;
	}

	/**
	 * @method	setLblTelefono
	 * 		  	Metodo set del atributo lblTelefono
	 * @param	pLblTelefono
	 * 			Valor que tomara el atributo lblTelefono
	 * @author	roberth.martinez
	 * @date	22/04/2018
	 */
	public void setLblTelefono(EtiquetaUtil pLblTelefono) {
		lblTelefono = pLblTelefono;
	}

	/**
	 * @method	getTxtTipoIdentificacion
	 * 		  	Metodo get del atributo txtTipoIdentificacion
	 * @return	CajaTextoUtil
	 *		  	Valor del atributo txtTipoIdentificacion devuelto
	 * @author	roberth.martinez
	 * @date  	22/04/2018
	 */
	public CajaTextoUtil getTxtTipoIdentificacion() {
		return txtTipoIdentificacion;
	}

	/**
	 * @method	setTxtTipoIdentificacion
	 * 		  	Metodo set del atributo txtTipoIdentificacion
	 * @param	pTxtTipoIdentificacion
	 * 			Valor que tomara el atributo txtTipoIdentificacion
	 * @author	roberth.martinez
	 * @date	22/04/2018
	 */
	public void setTxtTipoIdentificacion(CajaTextoUtil pTxtTipoIdentificacion) {
		txtTipoIdentificacion = pTxtTipoIdentificacion;
	}

	/**
	 * @method	getTxtIdentificacion
	 * 		  	Metodo get del atributo txtIdentificacion
	 * @return	CajaTextoUtil
	 *		  	Valor del atributo txtIdentificacion devuelto
	 * @author	roberth.martinez
	 * @date  	22/04/2018
	 */
	public CajaTextoUtil getTxtIdentificacion() {
		return txtIdentificacion;
	}

	/**
	 * @method	setTxtIdentificacion
	 * 		  	Metodo set del atributo txtIdentificacion
	 * @param	pTxtIdentificacion
	 * 			Valor que tomara el atributo txtIdentificacion
	 * @author	roberth.martinez
	 * @date	22/04/2018
	 */
	public void setTxtIdentificacion(CajaTextoUtil pTxtIdentificacion) {
		txtIdentificacion = pTxtIdentificacion;
	}

	/**
	 * @method	getTxtNombre
	 * 		  	Metodo get del atributo txtNombre
	 * @return	CajaTextoUtil
	 *		  	Valor del atributo txtNombre devuelto
	 * @author	roberth.martinez
	 * @date  	22/04/2018
	 */
	public CajaTextoUtil getTxtNombre() {
		return txtNombre;
	}

	/**
	 * @method	setTxtNombre
	 * 		  	Metodo set del atributo txtNombre
	 * @param	pTxtNombre
	 * 			Valor que tomara el atributo txtNombre
	 * @author	roberth.martinez
	 * @date	22/04/2018
	 */
	public void setTxtNombre(CajaTextoUtil pTxtNombre) {
		txtNombre = pTxtNombre;
	}

	/**
	 * @method	getTxtTelefono
	 * 		  	Metodo get del atributo txtTelefonoBeneficiario
	 * @return	CajaTextoUtil
	 *		  	Valor del atributo txtTelefonoBeneficiario devuelto
	 * @author	roberth.martinez
	 * @date  	22/04/2018
	 */
	public CajaTextoUtil getTxtTelefono() {
		return txtTelefono;
	}

	/**
	 * @method	setTxtTelefono
	 * 		  	Metodo set del atributo txtTelefonoBeneficiario
	 * @param	pTxtTelefono
	 * 			Valor que tomara el atributo txtTelefonoBeneficiario
	 * @author	roberth.martinez
	 * @date	22/04/2018
	 */
	public void setTxtTelefono(CajaTextoUtil pTxtTelefono) {
		txtTelefono = pTxtTelefono;
	}
	
	/** 
	 * ********************************************************************
	 * @method	castEvtfrmProtegiroInternacional
	 * 		  	Metodo estandar para formatear el tipo de dato general a 
  	 * 		    un tipo especifico ("Casteo"), del atributo 
  	 * 		    EventoFormaProtegiroInternacional
	 * @return	EventoFormaProtegiroInternacional
  	 * 		   	valor especifico recuperado
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	30/04/2018
	 * *********************************************************************
	 */
	public EventoFormaProtegiroInternacional castEvtfrmProtegiroInternacional()throws Exception{
		return (EventoFormaProtegiroInternacional)this.getEventoForma();
	}

	/** 
	 * ********************************************************************
	 * @method	main
	 * 		  	main
	 * @param 	args
	 * 			args
	 * @author	roberth.martinez
	 * @date	22/04/2018
	 * *********************************************************************
	 */
	public static void main(String[] args) {
		
		try {
			
			/*TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaProtegiroInternacional.class,
																   true, 
																   EnumDesplegarFormaConEventos.NO);*/
			
			
			TerceroInternacional to = new TerceroInternacional();
			to.setTelefono1("3122222608");
			
			TerceroInternacional td = new TerceroInternacional();
			td.setTelefono1("3166913788");
			
			td.setTipoIdentificacion(new TipoDocumentoInternacional());
			td.setIdentificacion("123456");
			td.setNombres("ole");
			
			FacturaGiroInternacional factura = new FacturaGiroInternacional();
			
			factura.setTerceroDestino(td);
			factura.setTerceroOrigen(to);
			factura.setStrProtegiroInducido("S");
			
			factura.setDouValorPrima(1000);
			factura.getFacturaSeguro().setValorAsegurado(10000D);
			
			new FormaProtegiroInternacional(null, 
									  		true,
									  		factura);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

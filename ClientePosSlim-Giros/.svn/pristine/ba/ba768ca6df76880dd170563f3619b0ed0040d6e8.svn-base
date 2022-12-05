package co.com.codesa.clienteposslimgiros.formas.genericas;

import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.generico.EventoFormaPanelBusqueda;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaFechaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaVerificadaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.utilidades.integracion.slimGiros.UtilIntegracionSlimGiros;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

/**
 * ****************************************************************.
 * @autor: Roberth Martinez Vargas
 * @fecha: 04-mar-2014
 * @descripcion: Clase que representa el panel de busqueda por pin o documento
 * @copyright: Copyright  1998-2012 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class FormaPanelBusqueda extends FormaPanelGenerico{

	/**
	 * @variable serialVersionUID
	 * 			 Variable serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @variable lblBusqueda
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 indica label de busqueda
	 **/
	private EtiquetaUtil lblBusqueda;
	
	/**
	 * @variable lblFechaInicial
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 indica la fecha inicial
	 **/
	private EtiquetaUtil lblFechaInicial;
	
	/**
	 * @variable lblFechaInicial
	 * 			 etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 indica la fecha final
	 **/
	private EtiquetaUtil lblFechaFinal;
	
	/**
	 * @variable txtReferencia
	 * 			 campo de texto sobre la forma que contiene el la referencia o
	 * 			 la identificacion a buscar
	 **/
	private CajaTextoUtil txtReferencia;
	
	/**
	 * @variable txtIdentificacion
	 * 			 campo de texto sobre la forma para diligenciar la identificacion
	 * 			 del tercero
	 **/
	private CajaTextoUtil txtIdentificacion;
	
	/**
	 * @variable chkRemitente
	 * 			 comoponente de chequeo sobre la forma para buscar por remitente
	 **/
	private CajaVerificadaUtil chkRemitente;
	
	/**
	 * @variable chkExterno
	 * 			 comoponente de chequeo sobre la forma para buscar por red externa
	 **/
	private CajaVerificadaUtil chkExterno;
	
	/**
	 * @variable chkDestinatario
	 * 			 comoponente de chequeo sobre la forma para buscar por destinatario
	 **/
	private CajaVerificadaUtil chkDestinatario;
	
	/**
	 * @variable grupoBusqueda
	 * 			 comoponente grupo de chequeo sobre la forma para agrupar los 
	 * 			 componentes check
	 **/
	private ButtonGroup grupoBusqueda;
	
	/**
	 * @variable dtcFechaInicial
	 * 			 comoponente de fecha sobre la forma para diligenciar la fecha inicial
	 * 			 para realizar la busquedad
	 **/
	private CajaFechaUtil dtcFechaInicial;
	
	/**
	 * @variable dtcFechaFinal
	 * 			 comoponente de fecha sobre la forma para diligenciar la fecha final
	 * 			 para realizar la busquedad
	 **/
	private CajaFechaUtil dtcFechaFinal;
	
	/**
	 * @variable cmbBusqueda
	 * 			 componente de combo sobre la forma que  contiene el listado 
	 * 		     de opciones de busqueda
	 **/
	private CajaComboUtil cmbBusqueda;
	
	/**
	 * @variable cmbTiposIdentificacion
	 * 			 componente de combo sobre la forma que  contiene el listado 
	 * 		     de tipos de documento de identidad
	 **/
	private CajaComboUtil cmbTiposIdentificacion;
	
	/**
	 * @variable evtFrmBusqueda
	 * 			 objeto EventoFormaPanelBusqueda para manejos de eventos del panel
	 **/
	private EventoFormaPanelBusqueda evtFrmBusqueda;

	/** 
	 * ********************************************************************
	 * @method 	FormaPanelBusqueda
	 * 		   	[TODO - DOC]: Descripcion del metodo constructor, importante 
	 *		   	mencionar la intencion de una sobrecarga, el despliegue de 
	 *		   	comportamientos de interes y otros
	 * @param 	pFormaPadre
	 * 			Referencia a la forma generica que contiene la seccion
	 * @param 	pEnmDimension
	 * 			Especificaciones de dimension que tendra la seccion
	 * @param 	pStrNombreComponente
	 * 			Nombre tecnico con el cual se identificara la seccion
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	5/06/2017
	 * *********************************************************************
	 */
	public FormaPanelBusqueda(FormaGenerica pFormaPadre,
							  EnumDimensionesComponentes pEnmDimension,
						 	  String pStrNombreComponente) throws Exception{
		
		super	(	pFormaPadre,
					pEnmDimension,
					pStrNombreComponente,
					BorderFactory.createEmptyBorder(),
					null,
					null
				);		
		
		this.evtFrmBusqueda = new EventoFormaPanelBusqueda(this, 
				   										   pFormaPadre);
		this.setEvaControlEventos(this.evtFrmBusqueda);
		
		super.iniciar();
	}

	@Override
	protected void inicializarSeccion()throws Exception{
		
		this.grupoBusqueda = new ButtonGroup();
		this.add(iniciarPropLblBusqueda());
		this.add(iniciarPropCmbBusqueda());
		this.add(iniciarPropTxtReferencia());
		this.add(iniciarPropTxtIdentificacion());
		this.add(iniciarPropChkDestinatario());
		this.add(iniciarPropChkRemitente());
		this.add(iniciarPropLblFechaFinal());
		this.add(iniciarPropLblFechaInicial());
		this.add(iniciarPropCmbTipoIdentificacion());
		this.add(iniciarPropDtcFechaFinal());
		this.add(iniciarPropDtcFechaInicial());
		this.add(iniciarPropChkExterno());
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
	 * @author 	hector.cuenca
	 * @date   	5/06/2017
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblBusqueda() throws Exception{
		
		if (this.lblBusqueda == null) {
			
			this.lblBusqueda = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_BUS_BUSQUEDA_POR, 
																	   	   "lblBusqueda", 
																	   	   EnumEtiquetas.LBL_BUS_BUSQUEDA_POR,
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
	 * @author 	hector.cuenca
	 * @date   	5/06/2017
	 * *********************************************************************
	 */
	public CajaComboUtil iniciarPropCmbBusqueda() throws Exception{
		
		if (this.cmbBusqueda == null) {
			
			this.cmbBusqueda = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_BUS_BUSQUEDA, 
																		  	  "cmbBusqueda", 
																		  	  true, 
																		  	  true, 
																		  	  this.evtFrmBusqueda,
																		  	  EnumEtiquetas.LBL_BUS_BUSQUEDA_POR);
		}
		
		return cmbBusqueda;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropCmbTipoIdentificacion
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	cmbTiposIdentificacion
	 * @return	CajaComboUtil
	 * 			Lista de valores gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	hector.cuenca
	 * @date   	5/06/2017
	 * *********************************************************************
	 */
	public CajaComboUtil iniciarPropCmbTipoIdentificacion() throws Exception{
		
		if (this.cmbTiposIdentificacion == null) {
			
			this.cmbTiposIdentificacion = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_BUS_TIPO_IDENTIFICACION, 
																		  			 	 "cmbTiposIdentificacion", 
																		  			 	 true, 
																		  			 	 true, 
																		  			 	 this.evtFrmBusqueda,
																		  			 	 EnumEtiquetas.TLT_BUS_TIPO_DOCUMENTO);
			
			this.cmbTiposIdentificacion.setToolTipText(EnumEtiquetas.TLT_BUS_TIPO_DOCUMENTO);
		}
		
		return cmbTiposIdentificacion;
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
	 * @author 	hector.cuenca
	 * @date   	5/06/2017
	 * *********************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtReferencia() throws Exception{
		
		if (this.txtReferencia == null) {
			
			this.txtReferencia = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_BUS_REFERENCIA, 
																			 	 "txtReferencia", 
																			 	 "", 
																			 	 true, 
																			 	 true, 
																			 	 false,
																			 	 this.evtFrmBusqueda,
																			 	 EnumEtiquetas.LBL_BUS_ITEM_BUSQUEDA_POR_PIN);
		}

		return this.txtReferencia;
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
	 * @author 	hector.cuenca
	 * @date   	5/06/2017
	 * *********************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtIdentificacion() throws Exception{
		
		if (this.txtIdentificacion == null) {
			
			this.txtIdentificacion = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_BUS_IDENTIFICACION, 
																			 	 	 "txtIdentificacion", 
																			 	 	 "", 
																			 	 	 true, 
																			 	 	 true, 
																			 	 	 false,
																			 	 	 this.evtFrmBusqueda,
																			 	 	 EnumEtiquetas.LBL_BUS_ITEM_BUSQUEDA_POR_DOCUMENTO);
		}

		return this.txtIdentificacion;
	}

	/** 
	 * ********************************************************************
	 * @method 	iniciarPropChkDestinatario
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	chkDestinatario
	 * @return	CajaVerificadaUtil
	 * 			Caja de verificacion gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	hector.cuenca
	 * @date   	5/06/2017
	 * *********************************************************************
	 */
	public CajaVerificadaUtil iniciarPropChkDestinatario() throws Exception{
		
		if (this.chkDestinatario == null) {
			
				this.chkDestinatario = UtilComponentesGUI.getInstance().crearCheckBox(EnumDimensionesComponentes.CHK_BUS_DESTINATARIO, 
																					  "chkDestinatario", 
																					  EnumEtiquetas.CHK_BUS_DESTINATARIO,
																					  false,
																					  true, 
																					  false, 
																					  true, 
																					  this.evtFrmBusqueda,
																					  SwingConstants.TRAILING,
																					  true);
				
			this.grupoBusqueda.add(this.chkDestinatario);
			
		}

		return this.chkDestinatario;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropChkRemitente
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	chkRemitente
	 * @return	CajaVerificadaUtil
	 * 			Caja de verificacion gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	hector.cuenca
	 * @date   	5/06/2017
	 * *********************************************************************
	 */
	public CajaVerificadaUtil iniciarPropChkRemitente() throws Exception{
		
		if (this.chkRemitente == null) {
			
			this.chkRemitente = UtilComponentesGUI.getInstance().crearCheckBox(EnumDimensionesComponentes.CHK_BUS_REMITENTE, 
																			   "chkRemitente", 
																			   EnumEtiquetas.CHK_BUS_REMITENTE, 
																			   false,
																			   true, 
																			   false, 
																			   false, 
																			   this.evtFrmBusqueda,
																			   SwingConstants.TRAILING,
																			   true);	
			this.grupoBusqueda.add(this.chkRemitente);
		}

		return this.chkRemitente;
	}

	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblFechaFinal
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblFechaFinal
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	hector.cuenca
	 * @date   	5/06/2017
	 * *********************************************************************
	 */
	private EtiquetaUtil iniciarPropLblFechaFinal()throws Exception {
		
		if (this.lblFechaFinal == null) {
			
			this.lblFechaFinal = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_BUS_FECHA_FINAL, 
																	     	 "lblFechaFinal", 
																	     	 EnumEtiquetas.DTC_BUS_FECHA_FIN,
																	     	 true,
																	     	 null,
																	     	 false);
		}
		
		return this.lblFechaFinal;
	}

	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblFechaInicial
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblFechaInicial
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	hector.cuenca
	 * @date   	5/06/2017
	 * *********************************************************************
	 */
	private EtiquetaUtil iniciarPropLblFechaInicial() throws Exception{
		
		if (this.lblFechaInicial == null) {
			
			this.lblFechaInicial = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_BUS_FECHA_INICIAL, 
																		   	   "lblFechaInicial", 
																		   	   EnumEtiquetas.DTC_BUS_FECHA_INI,
																		   	   true,
																		   	   null,
																		   	   false);
		}
		
		return this.lblFechaInicial;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropDtcFechaFinal
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	dtcFechaFinal
	 * @return	CajaFechaUtil
	 * 			Caja de fecha gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	hector.cuenca
	 * @date   	5/06/2017
	 * *********************************************************************
	 */
	public CajaFechaUtil iniciarPropDtcFechaFinal()throws Exception {
		
		if (this.dtcFechaFinal == null) {
			
			this.dtcFechaFinal = UtilComponentesGUI.getInstance().crearCalendar(EnumDimensionesComponentes.DTC_BUS_FECHA_FINAL, 
																		  		"dtcFechaFinal", 
																		  		UtilIntegracionSlimGiros.getInstance().obtenerFechaHoraActualPosSlim(), 
																		  		true, 
																		  		this.evtFrmBusqueda,
																		  		EnumEtiquetas.DTC_BUS_FECHA_FIN);
			
			this.dtcFechaFinal.setSdfFormato(UtilidadGiros.getInstancia().getFORMATEADOR_FECHA_GUION());
			this.dtcFechaFinal.setVisible(false);
		}
		
		return this.dtcFechaFinal;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropDtcFechaInicial
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	dtcFechaInicial
	 * @return	CajaFechaUtil
	 * 			Caja de fecha gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	hector.cuenca
	 * @date   	5/06/2017
	 * *********************************************************************
	 */
	public CajaFechaUtil iniciarPropDtcFechaInicial()throws Exception {
		
		if (this.dtcFechaInicial == null) {
			
			this.dtcFechaInicial = UtilComponentesGUI.getInstance().crearCalendar(EnumDimensionesComponentes.DTC_BUS_FECHA_INICIAL, 
																			  	  "dtcFechaInicial", 
																			  	  UtilIntegracionSlimGiros.getInstance().obtenerFechaHoraActualPosSlim(), 
																			  	  true, 
																			  	  this.evtFrmBusqueda,
																			  	  EnumEtiquetas.DTC_BUS_FECHA_INI);
				
			this.dtcFechaInicial.setSdfFormato(UtilidadGiros.getInstancia().getFORMATEADOR_FECHA_GUION());
			this.dtcFechaInicial.setVisible(false);
		}
		
		return this.dtcFechaInicial;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropChkExterno
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	chkExterno
	 * @return	CajaVerificadaUtil
	 * 			Caja de verificacion gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	hector.cuenca
	 * @date   	5/06/2017
	 * *********************************************************************
	 */
	public CajaVerificadaUtil iniciarPropChkExterno() throws Exception{
		
		if (this.chkExterno == null) {
			
			this.chkExterno = UtilComponentesGUI.getInstance().crearCheckBox(EnumDimensionesComponentes.CHK_BUS_EXTERNO, 
																			 "chkExterno", 
																			 EnumEtiquetas.CHK_BUS_EXTERNO,
																			 false,
																			 true, 
																			 false, 
																			 false, 
																			 this.evtFrmBusqueda,
																			 SwingConstants.TRAILING,
																			 true);
		}
		
		return this.chkExterno;
	}

	/**
	 * @method getLblBusqueda
	 * 		   Metodo get del atributo lblBusqueda
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblBusqueda devuelto
	 * @author hector.cuenca
	 * @date   5/06/2017
	 */
	public EtiquetaUtil getLblBusqueda() {
		return this.lblBusqueda;
	}

	/**
	 * @method setLblBusqueda
	 * 		   Metodo set del atributo lblBusqueda
	 * @param  pLblBusqueda
	 *		   Valor que tomara el atributo lblBusqueda
	 * @author hector.cuenca
	 * @date   5/06/2017
	 */
	public void setLblBusqueda(EtiquetaUtil pLblBusqueda) {
		this.lblBusqueda = pLblBusqueda;
	}

	/**
	 * @method getLblFechaInicial
	 * 		   Metodo get del atributo lblFechaInicial
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblFechaInicial devuelto
	 * @author hector.cuenca
	 * @date   5/06/2017
	 */
	public EtiquetaUtil getLblFechaInicial() {
		return this.lblFechaInicial;
	}

	/**
	 * @method setLblFechaInicial
	 * 		   Metodo set del atributo lblFechaInicial
	 * @param  pLblFechaInicial
	 *		   Valor que tomara el atributo lblFechaInicial
	 * @author hector.cuenca
	 * @date   5/06/2017
	 */
	public void setLblFechaInicial(EtiquetaUtil pLblFechaInicial) {
		this.lblFechaInicial = pLblFechaInicial;
	}

	/**
	 * @method getLblFechaFinal
	 * 		   Metodo get del atributo lblFechaFinal
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblFechaFinal devuelto
	 * @author hector.cuenca
	 * @date   5/06/2017
	 */
	public EtiquetaUtil getLblFechaFinal() {
		return this.lblFechaFinal;
	}

	/**
	 * @method setLblFechaFinal
	 * 		   Metodo set del atributo lblFechaFinal
	 * @param  pLblFechaFinal
	 *		   Valor que tomara el atributo lblFechaFinal
	 * @author hector.cuenca
	 * @date   5/06/2017
	 */
	public void setLblFechaFinal(EtiquetaUtil pLblFechaFinal) {
		this.lblFechaFinal = pLblFechaFinal;
	}

	/**
	 * @method getTxtReferencia
	 * 		   Metodo get del atributo txtReferencia
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtReferencia devuelto
	 * @author hector.cuenca
	 * @date   5/06/2017
	 */
	public CajaTextoUtil getTxtReferencia() {
		return this.txtReferencia;
	}

	/**
	 * @method setTxtReferencia
	 * 		   Metodo set del atributo txtReferencia
	 * @param  pTxtReferencia
	 *		   Valor que tomara el atributo txtReferencia
	 * @author hector.cuenca
	 * @date   5/06/2017
	 */
	public void setTxtReferencia(CajaTextoUtil pTxtReferencia) {
		this.txtReferencia = pTxtReferencia;
	}

	/**
	 * @method getChkRemitente
	 * 		   Metodo get del atributo chkRemitente
	 * @return CajaVerificadaUtil
	 *		   Valor del atributo chkRemitente devuelto
	 * @author hector.cuenca
	 * @date   5/06/2017
	 */
	public CajaVerificadaUtil getChkRemitente() {
		return this.chkRemitente;
	}

	/**
	 * @method setChkRemitente
	 * 		   Metodo set del atributo chkRemitente
	 * @param  pChkRemitente
	 *		   Valor que tomara el atributo chkRemitente
	 * @author hector.cuenca
	 * @date   5/06/2017
	 */
	public void setChkRemitente(CajaVerificadaUtil pChkRemitente) {
		this.chkRemitente = pChkRemitente;
	}

	/**
	 * @method getChkExterno
	 * 		   Metodo get del atributo chkExterno
	 * @return CajaVerificadaUtil
	 *		   Valor del atributo chkExterno devuelto
	 * @author hector.cuenca
	 * @date   5/06/2017
	 */
	public CajaVerificadaUtil getChkExterno() {
		return this.chkExterno;
	}

	/**
	 * @method setChkExterno
	 * 		   Metodo set del atributo chkExterno
	 * @param  pChkExterno
	 *		   Valor que tomara el atributo chkExterno
	 * @author hector.cuenca
	 * @date   5/06/2017
	 */
	public void setChkExterno(CajaVerificadaUtil pChkExterno) {
		this.chkExterno = pChkExterno;
	}

	/**
	 * @method getChkDestinatario
	 * 		   Metodo get del atributo chkDestinatario
	 * @return CajaVerificadaUtil
	 *		   Valor del atributo chkDestinatario devuelto
	 * @author hector.cuenca
	 * @date   5/06/2017
	 */
	public CajaVerificadaUtil getChkDestinatario() {
		return this.chkDestinatario;
	}

	/**
	 * @method setChkDestinatario
	 * 		   Metodo set del atributo chkDestinatario
	 * @param  pChkDestinatario
	 *		   Valor que tomara el atributo chkDestinatario
	 * @author hector.cuenca
	 * @date   5/06/2017
	 */
	public void setChkDestinatario(CajaVerificadaUtil pChkDestinatario) {
		this.chkDestinatario = pChkDestinatario;
	}

	/**
	 * @method getGrupoBusqueda
	 * 		   Metodo get del atributo grupoBusqueda
	 * @return ButtonGroup
	 *		   Valor del atributo grupoBusqueda devuelto
	 * @author hector.cuenca
	 * @date   5/06/2017
	 */
	public ButtonGroup getGrupoBusqueda() {
		return this.grupoBusqueda;
	}

	/**
	 * @method setGrupoBusqueda
	 * 		   Metodo set del atributo grupoBusqueda
	 * @param  pGrupoBusqueda
	 *		   Valor que tomara el atributo grupoBusqueda
	 * @author hector.cuenca
	 * @date   5/06/2017
	 */
	public void setGrupoBusqueda(ButtonGroup pGrupoBusqueda) {
		this.grupoBusqueda = pGrupoBusqueda;
	}

	/**
	 * @method getDtcFechaInicial
	 * 		   Metodo get del atributo dtcFechaInicial
	 * @return CajaFechaUtil
	 *		   Valor del atributo dtcFechaInicial devuelto
	 * @author hector.cuenca
	 * @date   5/06/2017
	 */
	public CajaFechaUtil getDtcFechaInicial() {
		return this.dtcFechaInicial;
	}

	/**
	 * @method setDtcFechaInicial
	 * 		   Metodo set del atributo dtcFechaInicial
	 * @param  pDtcFechaInicial
	 *		   Valor que tomara el atributo dtcFechaInicial
	 * @author hector.cuenca
	 * @date   5/06/2017
	 */
	public void setDtcFechaInicial(CajaFechaUtil pDtcFechaInicial) {
		this.dtcFechaInicial = pDtcFechaInicial;
	}

	/**
	 * @method getDtcFechaFinal
	 * 		   Metodo get del atributo dtcFechaFinal
	 * @return CajaFechaUtil
	 *		   Valor del atributo dtcFechaFinal devuelto
	 * @author hector.cuenca
	 * @date   5/06/2017
	 */
	public CajaFechaUtil getDtcFechaFinal() {
		return this.dtcFechaFinal;
	}

	/**
	 * @method setDtcFechaFinal
	 * 		   Metodo set del atributo dtcFechaFinal
	 * @param  pDtcFechaFinal
	 *		   Valor que tomara el atributo dtcFechaFinal
	 * @author hector.cuenca
	 * @date   5/06/2017
	 */
	public void setDtcFechaFinal(CajaFechaUtil pDtcFechaFinal) {
		this.dtcFechaFinal = pDtcFechaFinal;
	}

	/**
	 * @method getCmbBusqueda
	 * 		   Metodo get del atributo cmbBusqueda
	 * @return CajaComboUtil
	 *		   Valor del atributo cmbBusqueda devuelto
	 * @author hector.cuenca
	 * @date   5/06/2017
	 */
	public CajaComboUtil getCmbBusqueda() {
		return this.cmbBusqueda;
	}

	/**
	 * @method setCmbBusqueda
	 * 		   Metodo set del atributo cmbBusqueda
	 * @param  pCmbBusqueda
	 *		   Valor que tomara el atributo cmbBusqueda
	 * @author hector.cuenca
	 * @date   5/06/2017
	 */
	public void setCmbBusqueda(CajaComboUtil pCmbBusqueda) {
		this.cmbBusqueda = pCmbBusqueda;
	}

	/**
	 * @method getCmbTiposIdentificacion
	 * 		   Metodo get del atributo cmbTiposIdentificacion
	 * @return CajaComboUtil
	 *		   Valor del atributo cmbTiposIdentificacion devuelto
	 * @author hector.cuenca
	 * @date   5/06/2017
	 */
	public CajaComboUtil getCmbTiposIdentificacion() {
		return this.cmbTiposIdentificacion;
	}

	/**
	 * @method setCmbTiposIdentificacion
	 * 		   Metodo set del atributo cmbTiposIdentificacion
	 * @param  pCmbTiposIdentificacion
	 *		   Valor que tomara el atributo cmbTiposIdentificacion
	 * @author hector.cuenca
	 * @date   5/06/2017
	 */
	public void setCmbTiposIdentificacion(CajaComboUtil pCmbTiposIdentificacion) {
		this.cmbTiposIdentificacion = pCmbTiposIdentificacion;
	}

	/**
	 * @method getTxtIdentificacion
	 * 		   Metodo get del atributo txtIdentificacion
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtIdentificacion devuelto
	 * @author hector.cuenca
	 * @date   5/06/2017
	 */
	public CajaTextoUtil getTxtIdentificacion() {
		return this.txtIdentificacion;
	}

	/**
	 * @method setTxtIdentificacion
	 * 		   Metodo set del atributo txtIdentificacion
	 * @param  pTxtIdentificacion
	 *		   Valor que tomara el atributo txtIdentificacion
	 * @author hector.cuenca
	 * @date   5/06/2017
	 */
	public void setTxtIdentificacion(CajaTextoUtil pTxtIdentificacion) {
		this.txtIdentificacion = pTxtIdentificacion;
	}

	/**
	 * @method getEvtFrmBusqueda
	 * 		   Metodo get del atributo evtFrmBusqueda
	 * @return EventoFormaPanelBusqueda
	 *		   Valor del atributo evtFrmBusqueda devuelto
	 * @author hector.cuenca
	 * @date   5/06/2017
	 */
	public EventoFormaPanelBusqueda getEvtFrmBusqueda() {
		return this.evtFrmBusqueda;
	}

	/**
	 * @method setEvtFrmBusqueda
	 * 		   Metodo set del atributo evtFrmBusqueda
	 * @param  pEvtFrmBusqueda
	 *		   Valor que tomara el atributo evtFrmBusqueda
	 * @author hector.cuenca
	 * @date   5/06/2017
	 */
	public void setEvtFrmBusqueda(EventoFormaPanelBusqueda pEvtFrmBusqueda) {
		this.evtFrmBusqueda = pEvtFrmBusqueda;
	}

	public static void main(String args[]){
	
		try {
			
			TestPruebasInternas.getInstance().iniciarPruebaInterna(null,true, EnumDesplegarFormaConEventos.NO);
			
			JPanel panelContenido = new JPanel ();
			panelContenido.setLayout(null);
			JDialog dialogo = new JDialog();
			
			dialogo.setBounds(0, 0, 900, 500);
			
			FormaPanelBusqueda forma;
			
			forma = new FormaPanelBusqueda(null,
									       EnumDimensionesComponentes.PNL_CGN_BUSQUEDA,
									       "forma");
			
			forma.setBorder(BorderFactory.createEtchedBorder());
			
			panelContenido.add(forma);
			
			dialogo.add(panelContenido);
			
			dialogo.setVisible(true);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}

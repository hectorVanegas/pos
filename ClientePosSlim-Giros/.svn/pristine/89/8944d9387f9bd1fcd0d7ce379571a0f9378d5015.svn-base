package co.com.codesa.clienteposslimgiros.formas.terceros;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.terceros.EventoFormaPropiedadesPepsInternacional;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaVerificadaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TerceroInternacional;


/** 
 * ********************************************************************
 * @class	FormaPropiedadesPepsInternacional
 *		 	Clase para ofrecer el protegiro internacional 
 * @author	roberth.martinez
 * @date  	09/05/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class FormaPropiedadesPepsInternacional extends FormaGenerica{

	/**
	 * @variable serialVersionUID
	 * 			 variable serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @variable	pnlConyuge
	 * 				panel conyuge
	 */
	private SeccionUtil pnlConyuge;
	
	/**
	 * @variable	pnlFamiliarConsaguinidad
	 * 				panel Familiar Consaguinidad
	 */
	private SeccionUtil pnlFamiliarConsaguinidad;
	
	/**
	 * @variable	pnlFamiliarAfinidad
	 * 				panel Familiar Afinidad
	 */
	private SeccionUtil pnlFamiliarAfinidad;
	
	/**
	 * @variable	pnlFamiliarCivil
	 * 				panel Familiar Civil
	 */
	private SeccionUtil pnlFamiliarCivil;
	
	/**
	 * @variable	lblNombreConyuge
	 * 				etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 	indica label de nombre conyuge
	 */
	private EtiquetaUtil lblNombreConyuge;
	
	/**
	 * @variable	lblNombreFamiliarConsaguinidad
	 * 				etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 	indica label de Nombre Familiar Consaguinidad
	 */
	private EtiquetaUtil lblNombreFamiliarConsaguinidad;
	
	/**
	 * @variable	lblParentescoFamiliarConsaguinidad
	 * 				etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 	indica label de parentesco Familiar Consaguinidad
	 */
	private EtiquetaUtil lblParentescoFamiliarConsaguinidad;
	
	/**
	 * @variable	lblNombreFamiliarAfinidad
	 * 				etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 	indica label de Nombre Familiar Afinidad
	 */
	private EtiquetaUtil lblNombreFamiliarAfinidad;
	
	/**
	 * @variable	lblParentescoFamiliarAfinidad
	 * 				etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 	indica label de parentesco Familiar Afinidad
	 */
	private EtiquetaUtil lblParentescoFamiliarAfinidad;
	
	/**
	 * @variable	lblNombreFamiliarCivil
	 * 				etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 	indica label de Nombre Familiar Civil
	 */
	private EtiquetaUtil lblNombreFamiliarCivil;
	
	/**
	 * @variable	lblParentescoFamiliarCivil
	 * 				etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 	indica label de parentesco Familiar Civil
	 */
	private EtiquetaUtil lblParentescoFamiliarCivil;
	
	/**
	 * @variable	txtNombreConyuge
	 * 				campo de texto sobre la forma para diligenciar el Nombre Conyuge
	 */
	private CajaTextoUtil txtNombreConyuge;
	
	/**
	 * @variable	txtIdentificacion
	 * 				campo de texto sobre la forma para diligenciar la identificacion
	 * 				del beneficiario
	 */
	private CajaTextoUtil txtNombreFamiliarConsaguinidad;
	
	/**
	 * @variable	txtNombre
	 * 				campo de texto sobre la forma para diligenciar nombre del 
	 *				beneficiario
	 */
	private CajaTextoUtil txtNombreFamiliarAfinidad;
	
	/**
	 * @variable	txtTelefonoBeneficiario
	 * 				campo de texto sobre la forma para diligenciar el telefono
	 * 				del beneficiario
	 */
	private CajaTextoUtil txtNombreFamiliarCivil;
	
	/**
	 * @variable chkConyuge
	 * 			 comoponente de chequeo sobre la forma para incluir conyugue
	 **/
	private CajaVerificadaUtil chkConyuge;
	
	/**
	 * @variable chkFamiliarConsanguinidad
	 * 			 comoponente de chequeo sobre la forma para incluir Familiar Consanguinidad
	 **/
	private CajaVerificadaUtil chkFamiliarConsanguinidad;
	
	/**
	 * @variable chkFamiliarAfinidad
	 * 			 comoponente de chequeo sobre la forma para incluir Familiar Afinidad
	 **/
	private CajaVerificadaUtil chkFamiliarAfinidad;
	
	/**
	 * @variable chkFamiliarCivil
	 * 			 comoponente de chequeo sobre la forma para incluir Familiar Civil
	 **/
	private CajaVerificadaUtil chkFamiliarCivil;
	
	/**
	 * @variable cmbParentescoFamiliarConsanguinidad
	 * 			 componente de combo sobre la forma que  contiene el listado 
	 * 		     de Parentesco
	 **/
	private CajaComboUtil cmbParentescoFamiliarConsanguinidad;
	
	/**
	 * @variable cmbParentescoFamiliarAfinidad
	 * 			 componente de combo sobre la forma que  contiene el listado 
	 * 		     de Parentesco
	 **/
	private CajaComboUtil cmbParentescoFamiliarAfinidad;
	
	/**
	 * @variable cmbParentescoFamiliarCivil
	 * 			 componente de combo sobre la forma que  contiene el listado 
	 * 		     de Parentesco
	 **/
	private CajaComboUtil cmbParentescoFamiliarCivil;

	/**
	 * ********************************************************************
	 * @method	FormaPropiedadesPepsInternacional
	 * 		  	Constructor que ejecuta la inicializacion de valores y 
  	 * 		   	ejecucion de comportamientos inicales requeridos para el 
  	 * 		   	despliegue de la forma FormaPropiedadesPepsInternacional
	 * @param 	pFrmPadre
	 * 			ventana de la cual extiende esta forma
	 * @param 	pBooModal
	 * 			bandera que permite efectuar la forma de manera modal sobre 
  	 * 		  	la ventana de la cual extiende
  	 * @param	pObjTercero
  	 * 			objeto tercero internacional
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	09/05/2018
	 * *********************************************************************
	 */
	public FormaPropiedadesPepsInternacional(FormaGenerica pFrmPadre, 
								 	   		 boolean pBooModal,
								 	   		 TerceroInternacional pObjTercero) throws Exception {
		
		super(pFrmPadre, 
			  pBooModal);
		
		super.setEventoForma(new EventoFormaPropiedadesPepsInternacional(this,
																		 pObjTercero));
		
		this.inicializarForma();
	}

	@Override
	public void inicializarForma(Object... pArrObjParametrosForma) throws Exception {
		super.setTituloForma(EnumEtiquetas.TTL_PPI_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.GUI_PPI_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.GUI_PPI_VENTANA.getAlto());
		
		
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
								EnumBotonesEncabezado.BTN_ANULAR);
		
		
		super.iniciar(pArrObjParametrosForma);
	}

	@Override
	public JPanel inicializarEncabezado(Object... pArrObjParametrosForma) throws Exception {
		
		JPanel pnlEncabezado;
		
		pnlEncabezado = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_PPI_ENCABEZADO,
																	"pnlEncabezado",
		  														 	BorderFactory.createEmptyBorder(),
		  														 	null,
		  														 	null);
		
		pnlEncabezado.add(this.iniciarPropPnlConyuge());
		pnlEncabezado.add(this.iniciarPropPnlFamiliarConsaguinidad());
		pnlEncabezado.add(this.iniciarPropPnlFamiliarAfinidad());
		pnlEncabezado.add(this.iniciarPropPnlFamiliarCivil());
		
		return pnlEncabezado;
	}

	@Override
	public JPanel inicializarCuerpo(Object... pArrObjParametrosForma) throws Exception {
		return null;
	}

	@Override
	public JPanel inicializarPiePagina(Object... pArrObjParametrosForma) throws Exception {
		return null;
	}
	
	/** 
	 * ********************************************************************
	 * @method	iniciarPropPnlConyuge
	 * 		  	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	pnlConyuge
	 * @return	SeccionUtil
	 * 			seccion de cuerpo gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	10/05/2018
	 * *********************************************************************
	 */
	public SeccionUtil iniciarPropPnlConyuge() throws Exception{
		
		if(this.pnlConyuge==null){
			
			this.pnlConyuge = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_PPI_CONYUGE,
																		  "pnlConyuge",
																  		  null,
																  		  null,
																  		  null);
			this.pnlConyuge.add(iniciarPropChkConyuge());
			this.pnlConyuge.add(iniciarPropLblNombreConyuge());
			this.pnlConyuge.add(iniciarPropTxtNombreConyuge());
		}
		
		return this.pnlConyuge;
	}
	
	/** 
	 * ********************************************************************
	 * @method	iniciarPropPnlFamiliarConsaguinidad
	 * 		  	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	pnlFamiliarConsaguinidad
	 * @return	SeccionUtil
	 * 			seccion de cuerpo gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	10/05/2018
	 * *********************************************************************
	 */
	public SeccionUtil iniciarPropPnlFamiliarConsaguinidad() throws Exception{
		
		if(this.pnlFamiliarConsaguinidad==null){
			
			this.pnlFamiliarConsaguinidad = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_PPI_FAMILIAR_CONSANGUINIDAD,
																		  				"pnlFamiliarConsaguinidad",
																		  				null,
																		  				null,
																		  				null);
			this.pnlFamiliarConsaguinidad.add(iniciarPropChkFamiliarConsanguinidad());
			this.pnlFamiliarConsaguinidad.add(iniciarPropLblNombreFamiliarConsaguinidad());
			this.pnlFamiliarConsaguinidad.add(iniciarPropTxtNombreFamiliarConsaguinidad());
			this.pnlFamiliarConsaguinidad.add(iniciarPropLblParentescoFamiliarConsaguinidad());
			this.pnlFamiliarConsaguinidad.add(iniciarPropCmbParentescoFamiliarConsanguinidad());
		}
		
		return this.pnlFamiliarConsaguinidad;
	}
	
	/** 
	 * ********************************************************************
	 * @method	iniciarPropPnlFamiliarAfinidad
	 * 		  	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	pnlFamiliarAfinidad
	 * @return	SeccionUtil
	 * 			seccion de cuerpo gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	10/05/2018
	 * *********************************************************************
	 */
	public SeccionUtil iniciarPropPnlFamiliarAfinidad() throws Exception{
		
		if(this.pnlFamiliarAfinidad==null){
			
			this.pnlFamiliarAfinidad = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_PPI_FAMILIAR_AFINIDAD,
																		  		   "pnlFamiliarAfinidad",
																		  		   null,
																		  		   null,
																		  		   null);
			
			this.pnlFamiliarAfinidad.add(iniciarPropChkFamiliarAfinidad());
			this.pnlFamiliarAfinidad.add(iniciarPropLblNombreFamiliarAfinidad());
			this.pnlFamiliarAfinidad.add(iniciarPropTxtNombreFamiliarAfinidad());
			this.pnlFamiliarAfinidad.add(iniciarPropLblParentescoFamiliarAfinidad());
			this.pnlFamiliarAfinidad.add(iniciarPropCmbParentescoFamiliarAfinidad());
		}
		
		return this.pnlFamiliarAfinidad;
	}
	
	/** 
	 * ********************************************************************
	 * @method	iniciarPropPnlFamiliarCivil
	 * 		  	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	pnlFamiliarCivil
	 * @return	SeccionUtil
	 * 			seccion de cuerpo gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	10/05/2018
	 * *********************************************************************
	 */
	public SeccionUtil iniciarPropPnlFamiliarCivil() throws Exception{
		
		if(this.pnlFamiliarCivil==null){
			
			this.pnlFamiliarCivil = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_PPI_FAMILIAR_CIVIL,
																		  		"pnlFamiliarCivil",
																		  		null,
																		  		null,
																		  		null);
			
			this.pnlFamiliarCivil.add(iniciarPropChkFamiliarCivil());
			this.pnlFamiliarCivil.add(iniciarPropLblNombreFamiliarCivil());
			this.pnlFamiliarCivil.add(iniciarPropTxtNombreFamiliarCivil());
			this.pnlFamiliarCivil.add(iniciarPropLblParentescoFamiliarCivil());
			this.pnlFamiliarCivil.add(iniciarPropCmbParentescoFamiliarCivil());
		}
		
		return this.pnlFamiliarCivil;
	}
	
	/**
     * ****************************************************************
     * @method  iniciarPropChkConyuge
     * 		    metodo utilizado para inicializar el componente 
     * 		    CajaVerificadaUtil para seleccionar si el tercero tiene 
     * 		    Conyuge peps
     * @return  CajaVerificadaUtil 
     * 		    componente CajaVerificadaUtil
     * @throws  Exception
     * 		    Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
     * @author  roberth.martinez
     * @date    10/05/2018
     * ****************************************************************
     */	
	public CajaVerificadaUtil iniciarPropChkConyuge() throws Exception{
		if (this.chkConyuge == null) {
			this.chkConyuge = UtilComponentesGUI.getInstance().crearCheckBox(EnumDimensionesComponentes.CHK_PPI_CONYUGE, 
																	  	  	 "chkConyuge", 
																	  	  	 EnumEtiquetas.CHK_PPI_CONYUGE,
																	  	  	 false,
																	  	  	 true, 
																	  	  	 true, 
																	  	  	 false, 
																	  	  	 super.getEventoForma(),
																	  	  	 SwingConstants.RIGHT,
																	  	  	 true);
		}

		return this.chkConyuge;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblNombreConyuge
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblNombreConyuge
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	10/05/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblNombreConyuge() throws Exception{
		
		this.lblNombreConyuge = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PPI_NOMBRE_CONYUGE, 
				   												   	   		"lblNombreConyuge", 
				   												   	   		EnumEtiquetas.LBL_PPI_NOMBRE_CONYUGE,
				   												   	   		false,
				   												   	   		null,
				   												   	   		true);
		
		return this.lblNombreConyuge;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropTxtNombreConyuge
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtNombreConyuge
	 * @return	CajaTextoUtil
	 * 			Caja de texto gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	10/05/2018
	 * *********************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtNombreConyuge()throws Exception{
		
		this.txtNombreConyuge = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_PPI_NOMBRE_CONYUGE, 
																				"txtNombreConyuge", 
																				"",
																				true, 
																				false, 
																				true, 
																				super.getEventoForma(),
																				EnumEtiquetas.TXT_PPI_NOMBRE_CONYUGE);
		
		this.txtNombreConyuge.setToolTipText(EnumEtiquetas.TLT_PEP_NOMBRE_CONYUGUE);
		return this.txtNombreConyuge;
	}
	
	/**
     * ****************************************************************
     * @method  iniciarPropChkCFamiliarConsanguinidad
     * 		    metodo utilizado para inicializar el componente 
     * 		    CajaVerificadaUtil para seleccionar si el tercero tiene 
     * 		    Familiar Consanguinidad peps
     * @return  CajaVerificadaUtil 
     * 		    componente CajaVerificadaUtil
     * @throws  Exception
     * 		    Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
     * @author  roberth.martinez
     * @date    10/05/2018
     * ****************************************************************
     */	
	public CajaVerificadaUtil iniciarPropChkFamiliarConsanguinidad() throws Exception{
		if (this.chkFamiliarConsanguinidad == null) {
			this.chkFamiliarConsanguinidad = UtilComponentesGUI.getInstance().crearCheckBox(EnumDimensionesComponentes.CHK_PPI_FAMILIAR_CONSAGUINIDAD, 
																							"chkFamiliarConsanguinidad", 
																							EnumEtiquetas.CHK_PPI_FAMILIAR_CONSAGUINIDAD,
																							false,
																							true, 
																							true, 
																							false, 
																							super.getEventoForma(),
																							SwingConstants.RIGHT,
																							true);
		}

		return this.chkFamiliarConsanguinidad;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblNombreFamiliarConsaguinidad
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblNombreFamiliarConsaguinidad
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	10/05/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblNombreFamiliarConsaguinidad() throws Exception{
		
		this.lblNombreFamiliarConsaguinidad = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PPI_NOMBRE_FAMILIAR_CONSAGUINIDAD, 
																			 			  "lblNombreFamiliarConsaguinidad", 
																			 			  EnumEtiquetas.LBL_PPI_NOMBRE_FAMILIAR_CONSAGUINIDAD,
																			 			  false,
																			 			  null,
																			 			  true);
		
		return this.lblNombreFamiliarConsaguinidad;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropTxtFamiliarConsaguinidad
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtFamiliarConsaguinidad
	 * @return	CajaTextoUtil
	 * 			Caja de texto gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	10/05/2018
	 * *********************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtNombreFamiliarConsaguinidad()throws Exception{
		
		this.txtNombreFamiliarConsaguinidad = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_PPI_NOMBRE_FAMILIAR_CONSAGUINIDAD, 
																					 		  "txtFamiliarConsaguinidad", 
																					 		  "",
																					 		  true, 
																					 		  false, 
																					 		  true, 
																					 		  super.getEventoForma(),
																					 		  EnumEtiquetas.TXT_PPI_NOMBRE_FAMILIAR_CONSAGUINIDAD);
		
		this.txtNombreFamiliarConsaguinidad.setToolTipText(EnumEtiquetas.TLT_PEP_NOMBRE_FAMILIAR_CONSANGUINIDAD);
		return this.txtNombreFamiliarConsaguinidad;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblParentescoFamiliarConsaguinidad
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblParentescoFamiliarConsaguinidad
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	10/05/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblParentescoFamiliarConsaguinidad() throws Exception{
		
		this.lblParentescoFamiliarConsaguinidad= UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PPI_PARENTESCO_FAMILIAR_CONSAGUINIDAD, 
																			 			  	 "lblParentescoFamiliarConsaguinidad", 
																			 			  	 EnumEtiquetas.LBL_PPI_PARENTESCO_FAMILIAR_CONSAGUINIDAD,
																			 			  	 false,
																			 			  	 null,
																			 			  	 true);
		
		return this.lblParentescoFamiliarConsaguinidad;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropCmbParentescoFamiliarConsanguinidad
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	cmbParentescoFamiliarConsanguinidad
	 * @return	CajaComboUtil
	 * 			Lista de valores gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	10/05/2018
	 * *********************************************************************
	 */
	public CajaComboUtil iniciarPropCmbParentescoFamiliarConsanguinidad() throws Exception{
		
		if (this.cmbParentescoFamiliarConsanguinidad == null) {
			
			this.cmbParentescoFamiliarConsanguinidad = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_PPI_PARENTESCO_FAMILIAR_CONSAGUINIDAD, 
																		  	  						  "cmbParentescoFamiliarConsanguinidad", 
																		  	  						  false, 
																		  	  						  true, 
																		  	  						  this.getEventoForma(),
																		  	  						  EnumEtiquetas.CMB_PPI_PARENTESCO_FAMILIAR_CONSAGUINIDAD);
		}
		
		return this.cmbParentescoFamiliarConsanguinidad;
	}
	
	/**
     * ****************************************************************
     * @method  iniciarPropChkCFamiliarAfinidad
     * 		    metodo utilizado para inicializar el componente 
     * 		    CajaVerificadaUtil para seleccionar si el tercero tiene 
     * 		    Familiar Afinidad peps
     * @return  chkFamiliarAfinidad 
     * 		    componente CajaVerificadaUtil
     * @throws  Exception
     * 		    Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
     * @author  roberth.martinez
     * @date    10/05/2018
     * ****************************************************************
     */	
	public CajaVerificadaUtil iniciarPropChkFamiliarAfinidad() throws Exception{
		if (this.chkFamiliarAfinidad == null) {
			this.chkFamiliarAfinidad = UtilComponentesGUI.getInstance().crearCheckBox(EnumDimensionesComponentes.CHK_PPI_FAMILIAR_AFINIDAD, 
																					  "chkFamiliarAfinidad", 
																					  EnumEtiquetas.CHK_PPI_FAMILIAR_AFINIDAD,
																					  false,
																					  true, 
																					  true, 
																					  false, 
																					  super.getEventoForma(),
																					  SwingConstants.RIGHT,
																					  true);
		}

		return this.chkFamiliarAfinidad;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblNombreFamiliarAfinidad
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblNombreFamiliarAfinidad
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	10/05/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblNombreFamiliarAfinidad() throws Exception{
		
		this.lblNombreFamiliarAfinidad = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PPI_NOMBRE_FAMILIAR_AFINIDAD, 
																	 				 "lblNombreFamiliarAfinidad", 
																	 				 EnumEtiquetas.LBL_PPI_NOMBRE_FAMILIAR_AFINIDAD,
																	 				 false,
																	 				 null,
																	 				 true);
		
		return this.lblNombreFamiliarAfinidad;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropTxtNombreFamiliarAfinidad
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtNombreFamiliarAfinidad
	 * @return	CajaTextoUtil
	 * 			Caja de texto gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	10/05/2018
	 * *********************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtNombreFamiliarAfinidad()throws Exception{
		
		this.txtNombreFamiliarAfinidad = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_PPI_NOMBRE_FAMILIAR_AFINIDAD, 
																		 				 "txtNombreFamiliarAfinidad", 
																		 				 "",
																		 				 true, 
																		 				 false, 
																		 				 true, 
																		 				 super.getEventoForma(),
																		 				 EnumEtiquetas.TXT_PPI_NOMBRE_FAMILIAR_AFINIDAD);
		
		this.txtNombreFamiliarAfinidad.setToolTipText(EnumEtiquetas.TLT_PEP_NOMBRE_FAMILIAR_AFINIDAD);
		return this.txtNombreFamiliarAfinidad;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblParentescoFamiliarAfinidad
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblParentescoFamiliarAfinidad
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	10/05/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblParentescoFamiliarAfinidad() throws Exception{
		
		this.lblParentescoFamiliarAfinidad= UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PPI_PARENTESCO_FAMILIAR_AFINIDAD, 
																			 			"lblParentescoFamiliarAfinidad", 
																			 			EnumEtiquetas.LBL_PPI_PARENTESCO_FAMILIAR_AFINIDAD,
																			 			false,
																			 			null,
																			 			true);

		return this.lblParentescoFamiliarAfinidad;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropCmbParentescoFamiliarAfinidad
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	cmbParentescoFamiliarAfinidad
	 * @return	CajaComboUtil
	 * 			Lista de valores gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	10/05/2018
	 * *********************************************************************
	 */
	public CajaComboUtil iniciarPropCmbParentescoFamiliarAfinidad() throws Exception{
		
		if (this.cmbParentescoFamiliarAfinidad == null) {
			
			this.cmbParentescoFamiliarAfinidad = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_PPI_PARENTESCO_FAMILIAR_AFINIDAD, 
																  	  						  	"cmbParentescoFamiliarAfinidad", 
																  	  						  	false, 
																  	  						  	true, 
																  	  						  	this.getEventoForma(),
																  	  						  	EnumEtiquetas.CMB_PPI_PARENTESCO_FAMILIAR_AFINIDAD);
		}
		
		return this.cmbParentescoFamiliarAfinidad;
	}
	
	/**
     * ****************************************************************
     * @method  iniciarPropChkCFamiliarCivil
     * 		    metodo utilizado para inicializar el componente 
     * 		    CajaVerificadaUtil para seleccionar si el tercero tiene 
     * 		    Familiar Civil peps
     * @return  chkFamiliarCivil 
     * 		    componente CajaVerificadaUtil
     * @throws  Exception
     * 		    Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
     * @author  roberth.martinez
     * @date    10/05/2018
     * ****************************************************************
     */	
	public CajaVerificadaUtil iniciarPropChkFamiliarCivil() throws Exception{
		if (this.chkFamiliarCivil == null) {
			this.chkFamiliarCivil = UtilComponentesGUI.getInstance().crearCheckBox(EnumDimensionesComponentes.CHK_PPI_FAMILIAR_CIVIL, 
																					  "chkFamiliarCivil", 
																					  EnumEtiquetas.CHK_PPI_FAMILIAR_CIVIL,
																					  false,
																					  true, 
																					  true, 
																					  false, 
																					  super.getEventoForma(),
																					  SwingConstants.RIGHT,
																					  true);
		}

		return this.chkFamiliarCivil;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblNombreFamiliarCivil
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblNombreFamiliarCivil
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	10/05/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblNombreFamiliarCivil() throws Exception{
		
		this.lblNombreFamiliarCivil = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PPI_NOMBRE_FAMILIAR_CIVIL, 
																	   			  "lblNombreFamiliarCivil", 
																	   			  EnumEtiquetas.LBL_PPI_NOMBRE_FAMILIAR_CIVIL,
																	   			  false,
																	   			  null,
																	   			  true);
		
		return this.lblNombreFamiliarCivil;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropTxtNombreFamiliarCivil
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtNombreFamiliarCivil
	 * @return	CajaTextoUtil
	 * 			Caja de texto gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	10/05/2018
	 * *********************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtNombreFamiliarCivil()throws Exception{
		
		this.txtNombreFamiliarCivil = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_PPI_NOMBRE_FAMILIAR_CIVIL, 
				  														   			  "txtNombreFamiliarCivil", 
				  														   			  "",
				  														   			  true, 
				  														   			  false, 
				  														   			  true, 
				  														   			  super.getEventoForma(),
				  														   			  EnumEtiquetas.TXT_PPI_NOMBRE_FAMILIAR_CIVIL);
		
		this.txtNombreFamiliarCivil.setToolTipText(EnumEtiquetas.TLT_PEP_NOMBRE_FAMILIAR_CIVIL);
		return this.txtNombreFamiliarCivil;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblParentescoFamiliarCivil
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblParentescoFamiliarCivil
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	10/05/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblParentescoFamiliarCivil() throws Exception{
		
		this.lblParentescoFamiliarCivil= UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PPI_PARENTESCO_FAMILIAR_CIVIL, 
																			 		 "lblParentescoFamiliarCivil", 
																			 		 EnumEtiquetas.LBL_PPI_PARENTESCO_FAMILIAR_CIVIL,
																			 		 false,
																			 		 null,
																			 		 true);

		return this.lblParentescoFamiliarCivil;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropCmbParentescoFamiliarCivil
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	cmbParentescoFamiliarCivil
	 * @return	CajaComboUtil
	 * 			Lista de valores gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	10/05/2018
	 * *********************************************************************
	 */
	public CajaComboUtil iniciarPropCmbParentescoFamiliarCivil() throws Exception{
		
		if (this.cmbParentescoFamiliarCivil == null) {
			
			this.cmbParentescoFamiliarCivil = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_PPI_PARENTESCO_FAMILIAR_CIVIL, 
														  	  						  		 "cmbParentescoFamiliarCivil", 
														  	  						  		 false, 
														  	  						  		 true, 
														  	  						  		 this.getEventoForma(),
														  	  						  		 EnumEtiquetas.CMB_PPI_PARENTESCO_FAMILIAR_CIVIL);
		}
		
		return this.cmbParentescoFamiliarCivil;
	}
	
	/**
	 * @method	getPnlConyuge
	 * 		  	Metodo get del atributo pnlConyuge
	 * @return	SeccionUtil
	 *		  	Valor del atributo pnlConyuge devuelto
	 * @author	roberth.martinez
	 * @date  	10/05/2018
	 */
	public SeccionUtil getPnlConyuge() {
		return this.pnlConyuge;
	}

	/**
	 * @method	setPnlConyuge
	 * 		  	Metodo set del atributo pnlConyuge
	 * @param	pPnlConyuge
	 * 			Valor que tomara el atributo pnlConyuge
	 * @author	roberth.martinez
	 * @date	10/05/2018
	 */
	public void setPnlConyuge(SeccionUtil pPnlConyuge) {
		this.pnlConyuge = pPnlConyuge;
	}

	/**
	 * @method	getPnlFamiliarConsaguinidad
	 * 		  	Metodo get del atributo pnlFamiliarConsaguinidad
	 * @return	SeccionUtil
	 *		  	Valor del atributo pnlFamiliarConsaguinidad devuelto
	 * @author	roberth.martinez
	 * @date  	10/05/2018
	 */
	public SeccionUtil getPnlFamiliarConsaguinidad() {
		return this.pnlFamiliarConsaguinidad;
	}

	/**
	 * @method	setPnlFamiliarConsaguinidad
	 * 		  	Metodo set del atributo pnlFamiliarConsaguinidad
	 * @param	pPnlFamiliarConsaguinidad
	 * 			Valor que tomara el atributo pnlFamiliarConsaguinidad
	 * @author	roberth.martinez
	 * @date	10/05/2018
	 */
	public void setPnlFamiliarConsaguinidad(SeccionUtil pPnlFamiliarConsaguinidad) {
		this.pnlFamiliarConsaguinidad = pPnlFamiliarConsaguinidad;
	}

	/**
	 * @method	getPnlFamiliarAfinidad
	 * 		  	Metodo get del atributo pnlFamiliarAfinidad
	 * @return	SeccionUtil
	 *		  	Valor del atributo pnlFamiliarAfinidad devuelto
	 * @author	roberth.martinez
	 * @date  	10/05/2018
	 */
	public SeccionUtil getPnlFamiliarAfinidad() {
		return this.pnlFamiliarAfinidad;
	}

	/**
	 * @method	setPnlFamiliarAfinidad
	 * 		  	Metodo set del atributo pnlFamiliarAfinidad
	 * @param	pPnlFamiliarAfinidad
	 * 			Valor que tomara el atributo pnlFamiliarAfinidad
	 * @author	roberth.martinez
	 * @date	10/05/2018
	 */
	public void setPnlFamiliarAfinidad(SeccionUtil pPnlFamiliarAfinidad) {
		this.pnlFamiliarAfinidad = pPnlFamiliarAfinidad;
	}

	/**
	 * @method	getPnlFamiliarCivil
	 * 		  	Metodo get del atributo pnlFamiliarCivil
	 * @return	SeccionUtil
	 *		  	Valor del atributo pnlFamiliarCivil devuelto
	 * @author	roberth.martinez
	 * @date  	10/05/2018
	 */
	public SeccionUtil getPnlFamiliarCivil() {
		return this.pnlFamiliarCivil;
	}

	/**
	 * @method	setPnlFamiliarCivil
	 * 		  	Metodo set del atributo pnlFamiliarCivil
	 * @param	pPnlFamiliarCivil
	 * 			Valor que tomara el atributo pnlFamiliarCivil
	 * @author	roberth.martinez
	 * @date	10/05/2018
	 */
	public void setPnlFamiliarCivil(SeccionUtil pPnlFamiliarCivil) {
		this.pnlFamiliarCivil = pPnlFamiliarCivil;
	}

	/**
	 * @method	getLblNombreConyuge
	 * 		  	Metodo get del atributo lblNombreConyuge
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblNombreConyuge devuelto
	 * @author	roberth.martinez
	 * @date  	10/05/2018
	 */
	public EtiquetaUtil getLblNombreConyuge() {
		return this.lblNombreConyuge;
	}

	/**
	 * @method	setLblNombreConyuge
	 * 		  	Metodo set del atributo lblNombreConyuge
	 * @param	pLblNombreConyuge
	 * 			Valor que tomara el atributo lblNombreConyuge
	 * @author	roberth.martinez
	 * @date	10/05/2018
	 */
	public void setLblNombreConyuge(EtiquetaUtil pLblNombreConyuge) {
		this.lblNombreConyuge = pLblNombreConyuge;
	}

	/**
	 * @method	getLblNombreFamiliarConsaguinidad
	 * 		  	Metodo get del atributo lblNombreFamiliarConsaguinidad
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblNombreFamiliarConsaguinidad devuelto
	 * @author	roberth.martinez
	 * @date  	10/05/2018
	 */
	public EtiquetaUtil getLblNombreFamiliarConsaguinidad() {
		return this.lblNombreFamiliarConsaguinidad;
	}

	/**
	 * @method	setLblNombreFamiliarConsaguinidad
	 * 		  	Metodo set del atributo lblNombreFamiliarConsaguinidad
	 * @param	pLblNombreFamiliarConsaguinidad
	 * 			Valor que tomara el atributo lblNombreFamiliarConsaguinidad
	 * @author	roberth.martinez
	 * @date	10/05/2018
	 */
	public void setLblNombreFamiliarConsaguinidad(
			EtiquetaUtil pLblNombreFamiliarConsaguinidad) {
		this.lblNombreFamiliarConsaguinidad = pLblNombreFamiliarConsaguinidad;
	}

	/**
	 * @method	getLblNombreFamiliarAfinidad
	 * 		  	Metodo get del atributo lblNombreFamiliarAfinidad
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblNombreFamiliarAfinidad devuelto
	 * @author	roberth.martinez
	 * @date  	10/05/2018
	 */
	public EtiquetaUtil getLblNombreFamiliarAfinidad() {
		return this.lblNombreFamiliarAfinidad;
	}

	/**
	 * @method	setLblNombreFamiliarAfinidad
	 * 		  	Metodo set del atributo lblNombreFamiliarAfinidad
	 * @param	pLblNombreFamiliarAfinidad
	 * 			Valor que tomara el atributo lblNombreFamiliarAfinidad
	 * @author	roberth.martinez
	 * @date	10/05/2018
	 */
	public void setLblNombreFamiliarAfinidad(EtiquetaUtil pLblNombreFamiliarAfinidad) {
		this.lblNombreFamiliarAfinidad = pLblNombreFamiliarAfinidad;
	}

	/**
	 * @method	getLblNombreFamiliarCivil
	 * 		  	Metodo get del atributo lblNombreFamiliarCivil
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblNombreFamiliarCivil devuelto
	 * @author	roberth.martinez
	 * @date  	10/05/2018
	 */
	public EtiquetaUtil getLblNombreFamiliarCivil() {
		return this.lblNombreFamiliarCivil;
	}

	/**
	 * @method	setLblNombreFamiliarCivil
	 * 		  	Metodo set del atributo lblNombreFamiliarCivil
	 * @param	pLblNombreFamiliarCivil
	 * 			Valor que tomara el atributo lblNombreFamiliarCivil
	 * @author	roberth.martinez
	 * @date	10/05/2018
	 */
	public void setLblNombreFamiliarCivil(EtiquetaUtil pLblNombreFamiliarCivil) {
		this.lblNombreFamiliarCivil = pLblNombreFamiliarCivil;
	}

	/**
	 * @method	getTxtNombreConyuge
	 * 		  	Metodo get del atributo txtNombreConyuge
	 * @return	CajaTextoUtil
	 *		  	Valor del atributo txtNombreConyuge devuelto
	 * @author	roberth.martinez
	 * @date  	10/05/2018
	 */
	public CajaTextoUtil getTxtNombreConyuge() {
		return this.txtNombreConyuge;
	}

	/**
	 * @method	setTxtNombreConyuge
	 * 		  	Metodo set del atributo txtNombreConyuge
	 * @param	pTxtNombreConyuge
	 * 			Valor que tomara el atributo txtNombreConyuge
	 * @author	roberth.martinez
	 * @date	10/05/2018
	 */
	public void setTxtNombreConyuge(CajaTextoUtil pTxtNombreConyuge) {
		this.txtNombreConyuge = pTxtNombreConyuge;
	}

	/**
	 * @method	getTxtNombreFamiliarConsaguinidad
	 * 		  	Metodo get del atributo txtNombreFamiliarConsaguinidad
	 * @return	CajaTextoUtil
	 *		  	Valor del atributo txtNombreFamiliarConsaguinidad devuelto
	 * @author	roberth.martinez
	 * @date  	10/05/2018
	 */
	public CajaTextoUtil getTxtNombreFamiliarConsaguinidad() {
		return this.txtNombreFamiliarConsaguinidad;
	}

	/**
	 * @method	setTxtNombreFamiliarConsaguinidad
	 * 		  	Metodo set del atributo txtNombreFamiliarConsaguinidad
	 * @param	pTxtNombreFamiliarConsaguinidad
	 * 			Valor que tomara el atributo txtNombreFamiliarConsaguinidad
	 * @author	roberth.martinez
	 * @date	10/05/2018
	 */
	public void setTxtNombreFamiliarConsaguinidad(
			CajaTextoUtil pTxtNombreFamiliarConsaguinidad) {
		this.txtNombreFamiliarConsaguinidad = pTxtNombreFamiliarConsaguinidad;
	}

	/**
	 * @method	getTxtNombreFamiliarAfinidad
	 * 		  	Metodo get del atributo txtNombreFamiliarAfinidad
	 * @return	CajaTextoUtil
	 *		  	Valor del atributo txtNombreFamiliarAfinidad devuelto
	 * @author	roberth.martinez
	 * @date  	10/05/2018
	 */
	public CajaTextoUtil getTxtNombreFamiliarAfinidad() {
		return this.txtNombreFamiliarAfinidad;
	}

	/**
	 * @method	setTxtNombreFamiliarAfinidad
	 * 		  	Metodo set del atributo txtNombreFamiliarAfinidad
	 * @param	pTxtNombreFamiliarAfinidad
	 * 			Valor que tomara el atributo txtNombreFamiliarAfinidad
	 * @author	roberth.martinez
	 * @date	10/05/2018
	 */
	public void setTxtNombreFamiliarAfinidad(
			CajaTextoUtil pTxtNombreFamiliarAfinidad) {
		this.txtNombreFamiliarAfinidad = pTxtNombreFamiliarAfinidad;
	}

	/**
	 * @method	getTxtNombreFamiliarCivil
	 * 		  	Metodo get del atributo txtNombreFamiliarCivil
	 * @return	CajaTextoUtil
	 *		  	Valor del atributo txtNombreFamiliarCivil devuelto
	 * @author	roberth.martinez
	 * @date  	10/05/2018
	 */
	public CajaTextoUtil getTxtNombreFamiliarCivil() {
		return this.txtNombreFamiliarCivil;
	}

	/**
	 * @method	setTxtNombreFamiliarCivil
	 * 		  	Metodo set del atributo txtNombreFamiliarCivil
	 * @param	pTxtNombreFamiliarCivil
	 * 			Valor que tomara el atributo txtNombreFamiliarCivil
	 * @author	roberth.martinez
	 * @date	10/05/2018
	 */
	public void setTxtNombreFamiliarCivil(CajaTextoUtil pTxtNombreFamiliarCivil) {
		this.txtNombreFamiliarCivil = pTxtNombreFamiliarCivil;
	}

	/**
	 * @method	getChkConyuge
	 * 		  	Metodo get del atributo chkConyuge
	 * @return	CajaVerificadaUtil
	 *		  	Valor del atributo chkConyuge devuelto
	 * @author	roberth.martinez
	 * @date  	10/05/2018
	 */
	public CajaVerificadaUtil getChkConyuge() {
		return this.chkConyuge;
	}

	/**
	 * @method	setChkConyuge
	 * 		  	Metodo set del atributo chkConyuge
	 * @param	pChkConyuge
	 * 			Valor que tomara el atributo chkConyuge
	 * @author	roberth.martinez
	 * @date	10/05/2018
	 */
	public void setChkConyuge(CajaVerificadaUtil pChkConyuge) {
		this.chkConyuge = pChkConyuge;
	}

	/**
	 * @method	getChkFamiliarConsanguinidad
	 * 		  	Metodo get del atributo chkFamiliarConsanguinidad
	 * @return	CajaVerificadaUtil
	 *		  	Valor del atributo chkFamiliarConsanguinidad devuelto
	 * @author	roberth.martinez
	 * @date  	10/05/2018
	 */
	public CajaVerificadaUtil getChkFamiliarConsanguinidad() {
		return this.chkFamiliarConsanguinidad;
	}

	/**
	 * @method	setChkFamiliarConsanguinidad
	 * 		  	Metodo set del atributo chkFamiliarConsanguinidad
	 * @param	pChkFamiliarConsanguinidad
	 * 			Valor que tomara el atributo chkFamiliarConsanguinidad
	 * @author	roberth.martinez
	 * @date	10/05/2018
	 */
	public void setChkFamiliarConsanguinidad(
			CajaVerificadaUtil pChkFamiliarConsanguinidad) {
		this.chkFamiliarConsanguinidad = pChkFamiliarConsanguinidad;
	}

	/**
	 * @method	getChkFamiliarAfinidad
	 * 		  	Metodo get del atributo chkFamiliarAfinidad
	 * @return	CajaVerificadaUtil
	 *		  	Valor del atributo chkFamiliarAfinidad devuelto
	 * @author	roberth.martinez
	 * @date  	10/05/2018
	 */
	public CajaVerificadaUtil getChkFamiliarAfinidad() {
		return this.chkFamiliarAfinidad;
	}

	/**
	 * @method	setChkFamiliarAfinidad
	 * 		  	Metodo set del atributo chkFamiliarAfinidad
	 * @param	pChkFamiliarAfinidad
	 * 			Valor que tomara el atributo chkFamiliarAfinidad
	 * @author	roberth.martinez
	 * @date	10/05/2018
	 */
	public void setChkFamiliarAfinidad(CajaVerificadaUtil pChkFamiliarAfinidad) {
		this.chkFamiliarAfinidad = pChkFamiliarAfinidad;
	}

	/**
	 * @method	getChkFamiliarCivil
	 * 		  	Metodo get del atributo chkFamiliarCivil
	 * @return	CajaVerificadaUtil
	 *		  	Valor del atributo chkFamiliarCivil devuelto
	 * @author	roberth.martinez
	 * @date  	10/05/2018
	 */
	public CajaVerificadaUtil getChkFamiliarCivil() {
		return this.chkFamiliarCivil;
	}

	/**
	 * @method	setChkFamiliarCivil
	 * 		  	Metodo set del atributo chkFamiliarCivil
	 * @param	pChkFamiliarCivil
	 * 			Valor que tomara el atributo chkFamiliarCivil
	 * @author	roberth.martinez
	 * @date	10/05/2018
	 */
	public void setChkFamiliarCivil(CajaVerificadaUtil pChkFamiliarCivil) {
		this.chkFamiliarCivil = pChkFamiliarCivil;
	}

	/**
	 * @method	getLblParentescoFamiliarConsaguinidad
	 * 		  	Metodo get del atributo lblParentescoFamiliarConsaguinidad
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblParentescoFamiliarConsaguinidad devuelto
	 * @author	roberth.martinez
	 * @date  	10/05/2018
	 */
	public EtiquetaUtil getLblParentescoFamiliarConsaguinidad() {
		return this.lblParentescoFamiliarConsaguinidad;
	}

	/**
	 * @method	setLblParentescoFamiliarConsaguinidad
	 * 		  	Metodo set del atributo lblParentescoFamiliarConsaguinidad
	 * @param	pLblParentescoFamiliarConsaguinidad
	 * 			Valor que tomara el atributo lblParentescoFamiliarConsaguinidad
	 * @author	roberth.martinez
	 * @date	10/05/2018
	 */
	public void setLblParentescoFamiliarConsaguinidad(
			EtiquetaUtil pLblParentescoFamiliarConsaguinidad) {
		this.lblParentescoFamiliarConsaguinidad = pLblParentescoFamiliarConsaguinidad;
	}

	/**
	 * @method	getLblParentescoFamiliarAfinidad
	 * 		  	Metodo get del atributo lblParentescoFamiliarAfinidad
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblParentescoFamiliarAfinidad devuelto
	 * @author	roberth.martinez
	 * @date  	10/05/2018
	 */
	public EtiquetaUtil getLblParentescoFamiliarAfinidad() {
		return this.lblParentescoFamiliarAfinidad;
	}

	/**
	 * @method	setLblParentescoFamiliarAfinidad
	 * 		  	Metodo set del atributo lblParentescoFamiliarAfinidad
	 * @param	pLblParentescoFamiliarAfinidad
	 * 			Valor que tomara el atributo lblParentescoFamiliarAfinidad
	 * @author	roberth.martinez
	 * @date	10/05/2018
	 */
	public void setLblParentescoFamiliarAfinidad(
			EtiquetaUtil pLblParentescoFamiliarAfinidad) {
		this.lblParentescoFamiliarAfinidad = pLblParentescoFamiliarAfinidad;
	}

	/**
	 * @method	getLblParentescoFamiliarCivil
	 * 		  	Metodo get del atributo lblParentescoFamiliarCivil
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblParentescoFamiliarCivil devuelto
	 * @author	roberth.martinez
	 * @date  	10/05/2018
	 */
	public EtiquetaUtil getLblParentescoFamiliarCivil() {
		return this.lblParentescoFamiliarCivil;
	}

	/**
	 * @method	setLblParentescoFamiliarCivil
	 * 		  	Metodo set del atributo lblParentescoFamiliarCivil
	 * @param	pLblParentescoFamiliarCivil
	 * 			Valor que tomara el atributo lblParentescoFamiliarCivil
	 * @author	roberth.martinez
	 * @date	10/05/2018
	 */
	public void setLblParentescoFamiliarCivil(
			EtiquetaUtil pLblParentescoFamiliarCivil) {
		this.lblParentescoFamiliarCivil = pLblParentescoFamiliarCivil;
	}

	/**
	 * @method	getCmbParentescoFamiliarConsanguinidad
	 * 		  	Metodo get del atributo cmbParentescoFamiliarConsanguinidad
	 * @return	CajaComboUtil
	 *		  	Valor del atributo cmbParentescoFamiliarConsanguinidad devuelto
	 * @author	roberth.martinez
	 * @date  	10/05/2018
	 */
	public CajaComboUtil getCmbParentescoFamiliarConsanguinidad() {
		return this.cmbParentescoFamiliarConsanguinidad;
	}

	/**
	 * @method	setCmbParentescoFamiliarConsanguinidad
	 * 		  	Metodo set del atributo cmbParentescoFamiliarConsanguinidad
	 * @param	pCmbParentescoFamiliarConsanguinidad
	 * 			Valor que tomara el atributo cmbParentescoFamiliarConsanguinidad
	 * @author	roberth.martinez
	 * @date	10/05/2018
	 */
	public void setCmbParentescoFamiliarConsanguinidad(
			CajaComboUtil pCmbParentescoFamiliarConsanguinidad) {
		this.cmbParentescoFamiliarConsanguinidad = pCmbParentescoFamiliarConsanguinidad;
	}

	/**
	 * @method	getCmbParentescoFamiliarAfinidad
	 * 		  	Metodo get del atributo cmbParentescoFamiliarAfinidad
	 * @return	CajaComboUtil
	 *		  	Valor del atributo cmbParentescoFamiliarAfinidad devuelto
	 * @author	roberth.martinez
	 * @date  	10/05/2018
	 */
	public CajaComboUtil getCmbParentescoFamiliarAfinidad() {
		return this.cmbParentescoFamiliarAfinidad;
	}

	/**
	 * @method	setCmbParentescoFamiliarAfinidad
	 * 		  	Metodo set del atributo cmbParentescoFamiliarAfinidad
	 * @param	pCmbParentescoFamiliarAfinidad
	 * 			Valor que tomara el atributo cmbParentescoFamiliarAfinidad
	 * @author	roberth.martinez
	 * @date	10/05/2018
	 */
	public void setCmbParentescoFamiliarAfinidad(
			CajaComboUtil pCmbParentescoFamiliarAfinidad) {
		this.cmbParentescoFamiliarAfinidad = pCmbParentescoFamiliarAfinidad;
	}

	/**
	 * @method	getCmbParentescoFamiliarCivil
	 * 		  	Metodo get del atributo cmbParentescoFamiliarCivil
	 * @return	CajaComboUtil
	 *		  	Valor del atributo cmbParentescoFamiliarCivil devuelto
	 * @author	roberth.martinez
	 * @date  	10/05/2018
	 */
	public CajaComboUtil getCmbParentescoFamiliarCivil() {
		return this.cmbParentescoFamiliarCivil;
	}

	/**
	 * @method	setCmbParentescoFamiliarCivil
	 * 		  	Metodo set del atributo cmbParentescoFamiliarCivil
	 * @param	pCmbParentescoFamiliarCivil
	 * 			Valor que tomara el atributo cmbParentescoFamiliarCivil
	 * @author	roberth.martinez
	 * @date	10/05/2018
	 */
	public void setCmbParentescoFamiliarCivil(
			CajaComboUtil pCmbParentescoFamiliarCivil) {
		this.cmbParentescoFamiliarCivil = pCmbParentescoFamiliarCivil;
	}
	
	/** 
	 * ********************************************************************
	 * @method	castEvtfrmPropiedadesPepsInternacional
	 * 		  	Metodo estandar para formatear el tipo de dato general a 
  	 * 		    un tipo especifico ("Casteo"), del atributo 
  	 * 		    EventoFormaPropiedadesPepsInternacional
	 * @return	EventoFormaPropiedadesPepsInternacional
  	 * 		   	valor especifico recuperado
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	10/05/2018
	 * *********************************************************************
	 */
	public EventoFormaPropiedadesPepsInternacional castEvtfrmPropiedadesPepsInternacional()throws Exception{
		return (EventoFormaPropiedadesPepsInternacional)super.getEventoForma();
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
			
			TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaPropiedadesPepsInternacional.class,
																   true, 
																   EnumDesplegarFormaConEventos.SI);
			
			
			TerceroInternacional to = new TerceroInternacional();
			
			to.setBooConyugePEPs(true);
			to.setStrNombreCompletoConyugePEPs("kim");
			
			to.setBooFamiliarConsanguinidad(true);
			to.setStrNombreFamiliarConsaguinidad("Roberth");
			to.setStrParentescoFamiliarConsaguinidad("02");
			
			to.setBooFamiliarAfinidad(true);
			to.setStrNombreFamiliarAfinidad("maria");
			to.setStrParentescoFamiliarAfinidad("05");
			
			to.setBooFamiliarCivil(true);
			to.setStrNombreFamiliarCivil("laura");
			to.setStrParentescoFamiliarCivil("20");
			
			new FormaPropiedadesPepsInternacional(null, 
									  			  true,
									  			  to);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

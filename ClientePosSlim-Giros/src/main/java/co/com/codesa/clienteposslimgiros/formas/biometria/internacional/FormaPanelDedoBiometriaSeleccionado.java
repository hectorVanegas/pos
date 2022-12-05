package co.com.codesa.clienteposslimgiros.formas.biometria.internacional;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.biometria.internacional.EventoFormaPanelDedoBiometriaSeleccionado;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelGenerico;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;


/**
 * 
 * ********************************************************************
 * @class	FormaPanelDedoBiometriaSeleccionado
 *		 	Seccion que agrupa los controles graficos para identificar
 *			el dedo seleccionado para un proceso de biometria
 * @author	hector.cuenca
 * @date  	28/03/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class FormaPanelDedoBiometriaSeleccionado extends FormaPanelGenerico{

	/**
	 * @variable 	serialVersionUID
	 * 			 	Variable serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @variable	lblTipoMano
	 * 				Etiqueta que identifica el componente sobre el cual se
	 * 				puede seleccionar el tipo de mano
	 */
	private EtiquetaUtil lblTipoMano;
	
	/**
	 * @variable	lblTipoDedo
	 * 				Etiqueta que identifica el componente sobre el cual se
	 * 				puede seleccionar el tipo de dedo
	 */
	private EtiquetaUtil lblTipoDedo;
	
	/**
	 * @variable	cmbTipoMano
	 * 				Lista de valores (combo), para seleccionar el tipo de mano
	 */
	private CajaComboUtil cmbTipoMano;
	
	/**
	 * @variable	cmbTipoDedo
	 * 				Lista de valores (combo), para seleccionar el tipo de mano
	 */
	private CajaComboUtil cmbTipoDedo;
	
	/**
	 * @variable 	evtFrmPnlDedoBiometriaSeleccionado
	 * 			 	objeto EventoFormaPanelDedoBiometriaSeleccionado para manejos de 
	 * 				eventos del panel
	 **/
	private EventoFormaPanelDedoBiometriaSeleccionado evtFrmPnlDedoBiometriaSeleccionado;

	/** 
	 * ********************************************************************
	 * @method 	FormaPanelDedoBiometriaSeleccionado
	 * 		   	Metodo constructor que permite la inicializacion de los 
	 * 		   	valores y comportamientos necesarios para la construccion de
	 * 			la forma
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
	public FormaPanelDedoBiometriaSeleccionado	(	FormaGenerica pFormaPadre,
							  						EnumDimensionesComponentes pEnmDimension,
							  						String pStrNombreComponente
							  					) 
		throws Exception
	{	
		super	(	pFormaPadre,
					pEnmDimension,
					pStrNombreComponente,
					BorderFactory.createEmptyBorder(),
					null,
					null
				);		
		
		this.evtFrmPnlDedoBiometriaSeleccionado = new EventoFormaPanelDedoBiometriaSeleccionado	(this);
		this.setEvaControlEventos(this.evtFrmPnlDedoBiometriaSeleccionado);
		
		super.iniciar();
	}

	@Override
	protected void inicializarSeccion()
		throws Exception
	{	
		this.add(this.iniciarPropLblTipoMano());
		this.add(this.iniciarPropCmbTipoMano());
		this.add(this.iniciarPropLblTipoDedo());
		this.add(this.iniciarPropCmbTipoDedo());
	}
	
	/**
	 * ********************************************************************
	 * @method iniciarPropLblTipoMano
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblTipoMano
	 * @return EtiquetaUtil
	 * 		   Etiqueta gestionada
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author roberth.martinez
	 * @date   3/03/2016
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblTipoMano() 
			throws Exception
	{	
		if	(	this.lblTipoMano	==	null	) 
		{	
			this.lblTipoMano = UtilComponentesGUI.getInstance().crearLabel	(	EnumDimensionesComponentes.LBL_PNL_DBS_TIPO_MANO, 
															   	   	   			"lblTipoMano", 
															   	   	   			EnumEtiquetas.LBL_PNL_DBS_TIPO_MANO,
															   	   	   			true,
															   	   	   			null,
															   	   	   			true
															   	   			);
		}

		return this.lblTipoMano;
	}
	
	/**
	 * ********************************************************************
	 * @method iniciarPropLblTipoDedo
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblTipoDedo
	 * @return EtiquetaUtil
	 * 		   Etiqueta gestionada
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author roberth.martinez
	 * @date   3/03/2016
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblTipoDedo() 
			throws Exception
	{	
		if	(	this.lblTipoDedo	==	null	) 
		{	
			this.lblTipoDedo = UtilComponentesGUI.getInstance().crearLabel	(	EnumDimensionesComponentes.LBL_PNL_DBS_TIPO_DEDO, 
															   	   	   			"lblTipoDedo", 
															   	   	   			EnumEtiquetas.LBL_PNL_DBS_TIPO_DEDO,
															   	   	   			true,
															   	   	   			null,
															   	   	   			true
															   	   			);
		}

		return this.lblTipoDedo;
	}
	
	/**
	 * ********************************************************************
	 * @method iniciarPropCmbTipoMano
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   cmbTipoMano
	 * @return CajaComboUtil
	 * 		   Lista de valores gestionada
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author roberth.martinez
	 * @date   3/03/2016
	 * *********************************************************************
	 */
	public CajaComboUtil iniciarPropCmbTipoMano() 
			throws Exception
	{
		if	(	this.cmbTipoMano	==	null	) 
		{	
			this.cmbTipoMano = UtilComponentesGUI.getInstance().crearComboBox	(	EnumDimensionesComponentes.CMB_PNL_DBS_TIPO_MANO, 
																	  	   			"cmbTipoMano", 
																	  	   			true, 
																	  	   			true, 
																	  	   			super.getEvaControlEventos(),
																	  	   			EnumEtiquetas.LBL_PNL_DBS_TIPO_MANO
																	  	   		);
			this.cmbTipoMano.getLblObligatorio().aplicarObligatoriedad(true);
		}
		
		return cmbTipoMano;
	}
	
	/**
	 * ********************************************************************
	 * @method iniciarPropCmbTipoDedo
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   cmbTipoDedo
	 * @return CajaComboUtil
	 * 		   Lista de valores gestionada
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author roberth.martinez
	 * @date   3/03/2016
	 * *********************************************************************
	 */
	public CajaComboUtil iniciarPropCmbTipoDedo() 
			throws Exception
	{
		if	(	this.cmbTipoDedo	==	null	) 
		{	
			this.cmbTipoDedo = UtilComponentesGUI.getInstance().crearComboBox	(	EnumDimensionesComponentes.CMB_PNL_DBS_TIPO_DEDO, 
																	  	   			"cmbTipoDedo", 
																	  	   			true, 
																	  	   			true, 
																	  	   			super.getEvaControlEventos(),
																	  	   			EnumEtiquetas.LBL_PNL_DBS_TIPO_DEDO
																	  	   		);
			this.cmbTipoDedo.getLblObligatorio().aplicarObligatoriedad(true);
		}
		
		return cmbTipoDedo;
	}
	
	/**
	 * @method	getLblTipoMano
	 * 		  	Metodo get del atributo lblTipoMano
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblTipoMano devuelto
	 * @author	hector.cuenca
	 * @date  	28/03/2018
	 */
	public EtiquetaUtil getLblTipoMano() {
		return lblTipoMano;
	}

	/**
	 * @method	setLblTipoMano
	 * 		  	Metodo set del atributo lblTipoMano
	 * @param	pLblTipoMano
	 * 			Valor que tomara el atributo lblTipoMano
	 * @author	hector.cuenca
	 * @date	28/03/2018
	 */
	public void setLblTipoMano(EtiquetaUtil pLblTipoMano) {
		this.lblTipoMano = pLblTipoMano;
	}

	/**
	 * @method	getLblTipoDedo
	 * 		  	Metodo get del atributo lblTipoDedo
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblTipoDedo devuelto
	 * @author	hector.cuenca
	 * @date  	28/03/2018
	 */
	public EtiquetaUtil getLblTipoDedo() {
		return lblTipoDedo;
	}

	/**
	 * @method	setLblTipoDedo
	 * 		  	Metodo set del atributo lblTipoDedo
	 * @param	pLblTipoDedo
	 * 			Valor que tomara el atributo lblTipoDedo
	 * @author	hector.cuenca
	 * @date	28/03/2018
	 */
	public void setLblTipoDedo(EtiquetaUtil pLblTipoDedo) {
		this.lblTipoDedo = pLblTipoDedo;
	}

	/**
	 * @method	getCmbTipoDedo
	 * 		  	Metodo get del atributo cmbTipoDedo
	 * @return	CajaComboUtil
	 *		  	Valor del atributo cmbTipoDedo devuelto
	 * @author	hector.cuenca
	 * @date  	28/03/2018
	 */
	public CajaComboUtil getCmbTipoDedo() {
		return cmbTipoDedo;
	}

	/**
	 * @method	setCmbTipoDedo
	 * 		  	Metodo set del atributo cmbTipoDedo
	 * @param	pCmbTipoDedo
	 * 			Valor que tomara el atributo cmbTipoDedo
	 * @author	hector.cuenca
	 * @date	28/03/2018
	 */
	public void setCmbTipoDedo(CajaComboUtil pCmbTipoDedo) {
		this.cmbTipoDedo = pCmbTipoDedo;
	}

	/**
	 * @method	getCmbTipoMano
	 * 		  	Metodo get del atributo cmbTipoMano
	 * @return	CajaComboUtil
	 *		  	Valor del atributo cmbTipoMano devuelto
	 * @author	hector.cuenca
	 * @date  	28/03/2018
	 */
	public CajaComboUtil getCmbTipoMano() {
		return cmbTipoMano;
	}

	/**
	 * @method	setCmbTipoMano
	 * 		  	Metodo set del atributo cmbTipoMano
	 * @param	pCmbTipoMano
	 * 			Valor que tomara el atributo cmbTipoMano
	 * @author	hector.cuenca
	 * @date	28/03/2018
	 */
	public void setCmbTipoMano(CajaComboUtil pCmbTipoMano) {
		this.cmbTipoMano = pCmbTipoMano;
	}

	public static void main(String args[]){
	
		try {
			
			TestPruebasInternas.getInstance().iniciarPruebaInterna(null,true, EnumDesplegarFormaConEventos.NO);
			
			JPanel panelContenido = new JPanel ();
			panelContenido.setLayout(null);
			JDialog dialogo = new JDialog();
			
			dialogo.setBounds(0, 0, 900, 500);
			
			FormaPanelDedoBiometriaSeleccionado forma;
			
			forma = new FormaPanelDedoBiometriaSeleccionado(null,
									       EnumDimensionesComponentes.PNL_MNT_TERC_INT_DEDO_BIOMETRIA_SELECCIONADO,
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

package co.com.codesa.clienteposslimgiros.formas.pruebaadmisionentregatirilla;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;

import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad.TipoClaveSeguridadAutomaticaDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.serviciosAdicionalesCRC.EventoFormaPanelCelularCRC;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelGenerico;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

/**
 * 
 * ********************************************************************
 * @class  FormaPanelSMSGiro
 *		   Clase forma, que representa una seccion particular que 
 *		   contiene los componentes graficos necesarios para realizar
 *		   un proceso de confirmacion de celular
 * @author hector.cuenca
 * @date  	6/04/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class FormaPanelCelularCRC extends FormaPanelGenerico {

	/**
	 * @variable	serialVersionUID
	 * 			 	Variable serialVersionUID
	 */
	private static final long serialVersionUID = 8045507890900879934L;	
	
	/**
	 * @variable txtIngresaCelular
	 * 			 Campo de texto para ingresar el celular
	 */
	private CajaTextoUtil txtIngresaCelular;
	
	/**
	 * @variable txtConfirmaCelular
	 * 			 Campo de texto para confirmar el celular
	 */
	private CajaTextoUtil txtConfirmaCelular;
	
	/**
	 * @variable lblIngresaCelular
	 * 			 Etiqueta que identifica el campo para ingresar el celular
	 */
	private EtiquetaUtil lblIngresaCelular;
	
	/**
	 * @variable lblConfirmaCelular
	 * 			 Etiqueta que identifica el campo para confirmar el celular
	 */
	private EtiquetaUtil lblConfirmaCelular;	
	
	/**
	 * @variable lblTituloForma
	 * 			 Etiqueta que establece el titulo de la forma
	 */
	private EtiquetaUtil lblTituloForma;
	
	/**
	 * @variable	enmEtiTitulo
	 * 				Constante de enumeracion que representa la etiqueta describe
	 * 				la seccion que contiene el formulario a diligenciar
	 */
	private EnumEtiquetas enmEtiTitulo;
	
	/**
	 * ********************************************************************
	 * @method	FormaPanelSMSGiro
	 * 		  	Constructor que ejecuta la inicializacion de valores y 
	 * 		   	ejecucion de comportamientos inicales requeridos para
	 *         	el despliegue de la seccion 
	 * @param 	pFrmGnrVentana
	 * 			Forma principal desde donde el cajero se encuentra ejecutando 
	 * 			las operaciones
	 * @param	pEnmDimension
	 * 			Constante que especifica la dimension que la seccion tendra
	 * 			sobre la ventana que la esta adicionando
	 * @param	pEnmEtiTitulo
	 * 			Constante de enumeracion que representa la etiqueta describe
	 * 			la seccion que contiene el formulario a diligenciar
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	6/04/2018
	 * *********************************************************************
	 */
	public FormaPanelCelularCRC(	FormaGenerica pFrmGnrVentana,
								EnumDimensionesComponentes pEnmDimension,
								EnumEtiquetas pEnmEtiTitulo
							) 
		throws Exception 
	{	
		this(	pFrmGnrVentana,
				null,
				pEnmDimension,
				pEnmEtiTitulo
			);
	}
	
	/**
	 * ********************************************************************
	 * @method	FormaPanelCelularCRC
	 * 		  	Constructor que ejecuta la inicializacion de valores y 
	 * 		   	ejecucion de comportamientos inicales requeridos para
	 *         	el despliegue de la seccion 
	 * @param 	pFrmGnrVentana
	 * 			Forma principal desde donde el cajero se encuentra ejecutando 
	 * 			las operaciones
	 * @param	pStrTelefonoCelular
	 * 			Telefono celular propuesto actualmente
	 * @param	pEnmDimension
	 * 			Constante que especifica la dimension que la seccion tendra
	 * 			sobre la ventana que la esta adicionando
	 * @param	pEnmEtiTitulo
	 * 			Constante de enumeracion que representa la etiqueta describe
	 * 			la seccion que contiene el formulario a diligenciar
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	6/04/2018
	 * *********************************************************************
	 */
	public FormaPanelCelularCRC(	FormaGenerica pFrmGnrVentana,
								String pStrTelefonoCelular,
								EnumDimensionesComponentes pEnmDimension,
								EnumEtiquetas pEnmEtiTitulo
							) 
		throws Exception 
	{	
		super	(	pFrmGnrVentana,
					EnumDimensionesComponentes.PNL_PNL_SMS_SECCION, 
					"pnlSMSCelularCRC", 
					BorderFactory.createEmptyBorder(), 
					null,
					null//pEnmEtiTitulo
				);
		
		this.setLocation(	pEnmDimension.getX(), 
							pEnmDimension.getY()
						);
		
		this.setEnmEtiTitulo(pEnmEtiTitulo);
		
		super.setEvaControlEventos(new EventoFormaPanelCelularCRC(this,
																pStrTelefonoCelular));
		
		super.iniciar();
	}
	
	@Override
	protected void inicializarSeccion()
		throws Exception
	{	
		this.add(this.iniciarPropLbltituloForma());
		this.add(this.iniciarPropLblIngresaCelular());
		this.add(this.iniciarPropTxtIngresaCelular());
		this.add(this.iniciarPropLblConfirmaCelular());
		this.add(this.iniciarPropTxtConfirmaCelular());
	}
	
	/**
	 * ****************************************************************.
	 * @method iniciarPropTxtIngresaCelular 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   txtIngresaCelular
	 * @return CajaTextoUtil 
	 * 		   Caja de texto gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author roberth.martinez
	 * @date   4/3/2016
	 * ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtIngresaCelular()
		throws Exception
	{	
		if	(	this.txtIngresaCelular == null	) 
		{
			this.txtIngresaCelular = UtilComponentesGUI.getInstance().crearTextField(	EnumDimensionesComponentes.TXT_PNL_SMS_INGRESAR_CELULAR, 
																						"txtIngresaCelular", 
																					    "",
																					    true, 
																					    true, 
																					    true, 
																					    super.getEvaControlEventos(),
																					    EnumEtiquetas.LBL_PNL_SMS_INGRESAR_CELULAR,
																					    this.getEnmEtiTitulo().toString()
																					);
		}
		
		return this.txtIngresaCelular;
	}
	
	/**
	 * ****************************************************************.
	 * @method iniciarPropTxtConfirmaCelular 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   txtConfirmaCelular
	 * @return CajaTextoUtil 
	 * 		   Caja de texto gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author roberth.martinez
	 * @date   4/3/2016
	 * ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtConfirmaCelular()
		throws Exception
	{	
		if	(	this.txtConfirmaCelular == null	) 
		{	
			this.txtConfirmaCelular = UtilComponentesGUI.getInstance().crearTextField(	EnumDimensionesComponentes.TXT_PNL_SMS_CONFIRMAR_CELULAR, 
																					 	"txtConfirmaCelular",
																					 	"",
																					 	true, 
																					 	true, 
																					 	true, 
																					 	super.getEvaControlEventos(),
																					 	EnumEtiquetas.LBL_PNL_SMS_CONFIRMAR_CELULAR,
																					 	this.getEnmEtiTitulo().toString()
																					 );
		}
		
		return this.txtConfirmaCelular;
	}
	
	/**
	 * ****************************************************************.
	 * @method iniciarPropLblIngresaCelular 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblIngresaCelular
	 * @return EtiquetaUtil 
	 * 		   Etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author roberth.martinez
	 * @date   4/3/2016
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblIngresaCelular() 
		throws Exception
	{	
		if	(	this.lblIngresaCelular == null	) 
		{	
			this.lblIngresaCelular = UtilComponentesGUI.getInstance().crearLabel(	EnumDimensionesComponentes.LBL_PNL_SMS_INGRESAR_CELULAR, 
					   																"lblIngresaCelular", 
					   																EnumEtiquetas.LBL_PNL_SMS_INGRESAR_CELULAR,
					   																true,
					   																null,
					   																true
					   															);
		}
		
		return this.lblIngresaCelular;
	}
	
	/**
	 * ****************************************************************.
	 * @method iniciarPropLblConfirmaCelular 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblConfirmaCelular
	 * @return EtiquetaUtil 
	 * 		   Etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author roberth.martinez
	 * @date   4/3/2016
	 * ****************************************************************
	 */	
	public EtiquetaUtil iniciarPropLblConfirmaCelular() 
		throws Exception
	{	
		if	(	this.lblConfirmaCelular == null	) 
		{	
			this.lblConfirmaCelular = UtilComponentesGUI.getInstance().crearLabel	(	EnumDimensionesComponentes.LBL_PNL_SMS_CONFIRMAR_CELULAR, 
					 																	"lblConfirmaCelular", 
					 															  		EnumEtiquetas.LBL_PNL_SMS_CONFIRMAR_CELULAR,
					 															  		true,
					 															  		null,
					 															  		true
					 																);
		}
		
		return this.lblConfirmaCelular;
	}
	
	/**
	 * ****************************************************************.
	 * @method iniciarPropLbltituloForma 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblTituloForma
	 * @return EtiquetaUtil 
	 * 		   Etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author stiven.garcia
	 * @date   4/3/2016
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLbltituloForma() 
		throws Exception
	{	
		if	(	this.lblTituloForma == null	) 
		{	
			
			this.lblTituloForma = UtilComponentesGUI.getInstance().crearLabel(	EnumDimensionesComponentes.LBL_PNL_SMS_TITULO_FORMA, 
				   																"lblTituloForma", 
				   																enmEtiTitulo,
				   																false,
				   																null,
				   																true
					   															);
		}
		
		return this.lblTituloForma;
	}

	/**
	 * @method	getTxtIngresaCelular
	 * 		  	Metodo get del atributo txtIngresaCelular
	 * @return	CajaTextoUtil
	 *		  	Valor del atributo txtIngresaCelular devuelto
	 * @author	hector.cuenca
	 * @date  	6/04/2018
	 */
	public CajaTextoUtil getTxtIngresaCelular() {
		return this.txtIngresaCelular;
	}

	/**
	 * @method	setTxtIngresaCelular
	 * 		  	Metodo set del atributo txtIngresaCelular
	 * @param	pTxtIngresaCelular
	 * 			Valor que tomara el atributo txtIngresaCelular
	 * @author	hector.cuenca
	 * @date	6/04/2018
	 */
	public void setTxtIngresaCelular(CajaTextoUtil pTxtIngresaCelular) {
		this.txtIngresaCelular = pTxtIngresaCelular;
	}

	/**
	 * @method	getTxtConfirmaCelular
	 * 		  	Metodo get del atributo txtConfirmaCelular
	 * @return	CajaTextoUtil
	 *		  	Valor del atributo txtConfirmaCelular devuelto
	 * @author	hector.cuenca
	 * @date  	6/04/2018
	 */
	public CajaTextoUtil getTxtConfirmaCelular() {
		return this.txtConfirmaCelular;
	}

	/**
	 * @method	setTxtConfirmaCelular
	 * 		  	Metodo set del atributo txtConfirmaCelular
	 * @param	pTxtConfirmaCelular
	 * 			Valor que tomara el atributo txtConfirmaCelular
	 * @author	hector.cuenca
	 * @date	6/04/2018
	 */
	public void setTxtConfirmaCelular(CajaTextoUtil pTxtConfirmaCelular) {
		this.txtConfirmaCelular = pTxtConfirmaCelular;
	}

	/**
	 * @method	getLblIngresaCelular
	 * 		  	Metodo get del atributo lblIngresaCelular
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblIngresaCelular devuelto
	 * @author	hector.cuenca
	 * @date  	6/04/2018
	 */
	public EtiquetaUtil getLblIngresaCelular() {
		return this.lblIngresaCelular;
	}

	/**
	 * @method	setLblIngresaCelular
	 * 		  	Metodo set del atributo lblIngresaCelular
	 * @param	pLblIngresaCelular
	 * 			Valor que tomara el atributo lblIngresaCelular
	 * @author	hector.cuenca
	 * @date	6/04/2018
	 */
	public void setLblIngresaCelular(EtiquetaUtil pLblIngresaCelular) {
		this.lblIngresaCelular = pLblIngresaCelular;
	}

	/**
	 * @method	getLblConfirmaCelular
	 * 		  	Metodo get del atributo lblConfirmaCelular
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblConfirmaCelular devuelto
	 * @author	hector.cuenca
	 * @date  	6/04/2018
	 */
	public EtiquetaUtil getLblConfirmaCelular() {
		return this.lblConfirmaCelular;
	}

	/**
	 * @method	setLblConfirmaCelular
	 * 		  	Metodo set del atributo lblConfirmaCelular
	 * @param	pLblConfirmaCelular
	 * 			Valor que tomara el atributo lblConfirmaCelular
	 * @author	hector.cuenca
	 * @date	6/04/2018
	 */
	public void setLblConfirmaCelular(EtiquetaUtil pLblConfirmaCelular) {
		this.lblConfirmaCelular = pLblConfirmaCelular;
	}

	/**
	 * @method	getEnmEtiTitulo
	 * 		  	Metodo get del atributo enmEtiTitulo
	 * @return	EnumEtiquetas
	 *		  	Valor del atributo enmEtiTitulo devuelto
	 * @author	hector.cuenca
	 * @date  	6/04/2018
	 */
	public EnumEtiquetas getEnmEtiTitulo() {
		return this.enmEtiTitulo;
	}

	/**
	 * @method	setEnmEtiTitulo
	 * 		  	Metodo set del atributo enmEtiTitulo
	 * @param	pEnmEtiTitulo
	 * 			Valor que tomara el atributo enmEtiTitulo
	 * @author	hector.cuenca
	 * @date	6/04/2018
	 */
	public void setEnmEtiTitulo(EnumEtiquetas pEnmEtiTitulo) {
		this.enmEtiTitulo = pEnmEtiTitulo;
	}	
	
	/**
	 * 
	 * ********************************************************************
	 * @method	getLblTituloForma
	 * 		  	Metodo get del atributo lblTituloForma
	 * @return  lblTituloForma
	 * @author	stiven.garcia
	 * @date	24/08/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil getLblTituloForma() {
		return this.lblTituloForma;
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	setLblTituloForma
	 * 		  	Metodo set del atributo TituloForma
	 * @param pLblTituloForma
	 * 			Valor de la etiqueta
	 * @author	stiven.garcia
	 * @date	24/08/2018
	 * *********************************************************************
	 */
	public void setLblTituloForma(EtiquetaUtil pLblTituloForma) {
		this.lblTituloForma = pLblTituloForma;
	}

	@Override
	public EventoFormaPanelCelularCRC getEvaControlEventos() 
	{
		return (EventoFormaPanelCelularCRC)super.getEvaControlEventos();
	};

	/** ********************************************************************
	 * @method main
	 * 		   metodo main para ejecucion
	 * @param  args
	 * 	       argumentos
	 * @author roberth.martinez
	 * @date   4/3/2016
	 * *********************************************************************
	 */
	public static void main(String args[]){
		
		try {
			
			TestPruebasInternas.getInstance().iniciarPruebaInterna(null,true, EnumDesplegarFormaConEventos.NO);
			@SuppressWarnings("unused")
			TipoClaveSeguridadAutomaticaDTO tipoTokenValidaAutomaticolDTO = new TipoClaveSeguridadAutomaticaDTO(null, null);
			//FacturaGiro objFacturaGiro = new FacturaGiro();
			JPanel panelContenido = new JPanel ();
			panelContenido.setLayout(null);
			JDialog dialogo = new JDialog();
			
			dialogo.setBounds(0, 0, 900, 500);
			
			FormaPanelCelularCRC forma;
			
			forma = new FormaPanelCelularCRC(null,
					EnumDimensionesComponentes.PNL_PNL_SMS_SECCION,
					EnumEtiquetas.TTL_PNL_CSA_SECCION_DESTINATARIO);
			
			panelContenido.add(forma);
			
			dialogo.add(panelContenido);
			
			dialogo.setVisible(true);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

package co.com.codesa.clienteposslimgiros.formas.autorizacion;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import co.com.codesa.clienteposslim.logger.Logger;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.autorizacion.EventoFormaConsultaEstadoGiro;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelCodigoDescripcion;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelEncabezadoGeneral;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

/** 
 * ********************************************************************
 * @class  	FormaConsultaEstadoGiro
 *		   	Forma que permite consultar el estado de un giro, aunque 
 *			originalmente tiene la intencion de ser una funcionalidad
 *			administrativa, se coloca a disposicion en el modulo de venta
 *			de manera controlada, para validar especificamente un giro
 *			con previa solicitud de anulacion, y confirmar su estado de 
 *			anulado para proceder tanto operativa como sistematicamente
 *			con la devolucion del dinero.
 * @author 	hector.cuenca
 * @date   	2/05/2017
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
@Deprecated
public class FormaConsultaEstadoGiro extends FormaGenerica{
	
	/**
	 * @variable 	serialVersionUID
	 * 			 	Variable serialVersionUID
	 */
	private static final long serialVersionUID = -6008766807282397749L;

	/**
	 * @variable	pnlEncabezadoGeneral
	 * 			 	Seccion que aloja el encabezado general para las formas, que contiene 
	 * 			 	los valores de agencia, empresa y caja, normalmente recuperados del 
	 * 			 	usuario autenticado
	 **/
	private FormaPanelEncabezadoGeneral pnlEncabezadoGeneral;
	
	/**
	 * @variable 	pnlAgenciaOrigen
	 * 			 	Seccion dedicada a representar la informacion de la agencia origen
	 */
	private FormaPanelCodigoDescripcion pnlAgenciaOrigen;
	
	/**
	 * @variable 	pnlAgenciaDestino
	 * 			 	Seccion dedicada a representar la informacion de la agencia destino
	 */
	private FormaPanelCodigoDescripcion pnlAgenciaDestino;
	
	/**
	 * @variable 	txtReferencia
	 * 			 	Caja de texto para diligenciar la referencia del giro interesado
	 * 			 	en realizar la consulta de su estado
	 **/
	private CajaTextoUtil txtReferencia;
	
	/**
	 * @variable 	txtEstado
	 * 			 	Caja de texto donde se colocara el estado consultado del giro 
	 **/
	private CajaTextoUtil txtEstado;
	
	/**
	 * @variable 	lblReferencia
	 * 			 	Etiqueta que identifica el componente grafico para diligenciar 
	 * 			 	la referencia o pin del giro
	 **/
	private EtiquetaUtil lblReferencia;
	
	/**
	 * @variable 	lblEstado
	 * 			 	Etiqueta que identifica el componente grafico sobre la forma, que
	 * 				muestra el estado del giro
	 **/
	private EtiquetaUtil lblEstado;
	
	/**
  	 * ****************************************************************.
  	 * @metodo FormaConsultaEstadoGiro
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de la forma
  	 * @param pFrmPadre
  	 * 		  ventana de la cual extiende esta forma
  	 * @param pBooModal 
  	 * 		  bandera que permite efectuar la forma de manera modal sobre 
  	 * 		  la ventana de la cual extiende
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaConsultaEstadoGiro	(	JFrame pFrmPadre,
										boolean pBooModal
									)
											throws Exception 
	{
		super(pFrmPadre,
			  pBooModal);
		
		super.setEventoForma(new EventoFormaConsultaEstadoGiro(this));
		this.inicializarForma();
	}

	@Override
	public void inicializarForma	(	Object ...pArrObjParametrosForma) 
			throws Exception
	{
		super.setTituloForma(EnumEtiquetas.TTL_CEG_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.GUI_CEG_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.GUI_CEG_VENTANA.getAlto());
        
		super.adicionarAcciones(EnumBotonesEncabezado.BTNCONSULTAR,
						  		EnumBotonesEncabezado.BTNSALIR);
		
		super.iniciar(pArrObjParametrosForma);
	}

	@Override
	public JPanel inicializarEncabezado	(	Object ...pArrObjParametrosForma	) 
			throws Exception
	{	
		JPanel pnlEncabezado;
		
		pnlEncabezado = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_CEG_ENCABEZADO,
																	"pnlEncabezado",
		  														 	BorderFactory.createEtchedBorder(),
		  														 	null,
		  														 	null);
		pnlEncabezado.add(this.iniciarPropPnlEncabezadoGeneral());
		
		return pnlEncabezado;
	}

	@Override
	public JPanel inicializarCuerpo	(	Object ...pArrObjParametrosCuerpo	) 
			throws Exception
	{
		JPanel pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel	(	EnumDimensionesComponentes.PNL_CEG_CUERPO,
																	"pnlCuerpo",
																	BorderFactory.createEtchedBorder(),
																	null,
																	null
																);
		
		pnlCuerpo.add(this.iniciarPropLblReferencia());
		pnlCuerpo.add(this.iniciarPropTxtReferencia());
		pnlCuerpo.add(this.iniciarPropLblEstado());
		pnlCuerpo.add(this.iniciarPropTxtEstado());
		
		return pnlCuerpo;
	}

	@Override
	public JPanel inicializarPiePagina	(	Object ...pArrObjParametrosPiePagina	) 
			throws Exception
	{
		JPanel pnlPiePagina;
		
		pnlPiePagina = UtilComponentesGUI.getInstance().crearPanel	(	EnumDimensionesComponentes.PNL_CEG_PIE_PAGINA,
																		"pnlPiePagina",
																		BorderFactory.createEtchedBorder(),
																		null,
																		null
																	);
		
		pnlPiePagina.add(this.iniciarPropPnlAgenciaOrigen());
		pnlPiePagina.add(this.iniciarPropPnlAgenciaDestino());
		
		return pnlPiePagina;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropPnlEncabezadoGeneral
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	pnlEncabezadoGeneral
	 * @return	FormaPanelEncabezadoGeneral
	 * 			Seccion de encabezado general gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	hector.cuenca
	 * @date   	2/05/2017
	 * *********************************************************************
	 */
	public FormaPanelEncabezadoGeneral iniciarPropPnlEncabezadoGeneral	() 
			throws Exception
	{
		if	(	this.pnlEncabezadoGeneral	==	null	)
		{
			this.pnlEncabezadoGeneral = new FormaPanelEncabezadoGeneral	(	super.getObjUsuario().getEmpresa(),
														  			   		null,
														  			   		super.getObjUsuario().getCaja(),
														  			   		EnumDimensionesComponentes.PNL_CEG_ENCABEZADO_GENERAL,
														  			   		"pnlEncabezadoGeneral"
														  			   	);
		}
		
		return this.pnlEncabezadoGeneral;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropPnlAgenciaOrigen
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	pnlAgenciaOrigen
	 * @return	PropiedadesPanelCodigoDescripcion
	 * 			Seccion codigo descripcion gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	hector.cuenca
	 * @date   	2/05/2017
	 * *********************************************************************
	 */
	public FormaPanelCodigoDescripcion iniciarPropPnlAgenciaOrigen	() 
			throws Exception
	{
		if	(	this.pnlAgenciaOrigen	==	null	)
		{
			this.pnlAgenciaOrigen = new FormaPanelCodigoDescripcion	(	this,
																		"pnlAgenciaOrigen",
																		EnumDimensionesComponentes.PNL_CEG_AGENCIA_ORIGEN,
																		100,
																		EnumEtiquetas.LBL_CEG_AGENCIA_ORIGEN
																	);
			this.pnlAgenciaOrigen.getPropiedades().asignarDatos("CODIGO", "DESCRIPCION");
		}
		
		return this.pnlAgenciaOrigen;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropPnlAgenciaDestino
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	pnlAgenciaDestino
	 * @return	PropiedadesPanelCodigoDescripcion
	 * 			Seccion codigo descripcion gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	hector.cuenca
	 * @date   	2/05/2017
	 * *********************************************************************
	 */
	public FormaPanelCodigoDescripcion iniciarPropPnlAgenciaDestino	() 
			throws Exception
	{
		if	(	this.pnlAgenciaDestino	==	null	)
		{
			this.pnlAgenciaDestino = new FormaPanelCodigoDescripcion	(	this,
																			"pnlAgenciaDestino",
																			EnumDimensionesComponentes.PNL_CEG_AGENCIA_DESTINO,
																			100,
																			EnumEtiquetas.LBL_CEG_AGENCIA_DESTINO
																		);
		}
		
		return this.pnlAgenciaDestino;
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
	 * @date   	2/05/2017
	 * *********************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtReferencia	()
			throws Exception
	{
		if	(	this.txtReferencia	==	null	)
		{
			this.txtReferencia = UtilComponentesGUI.getInstance().crearTextField(	EnumDimensionesComponentes.TXT_CEG_REFERENCIA, 
																		   			"txtReferencia", 
																		   			"", 
																		   			true, 
																		   			true, 
																		   			true, 
																		   			super.getEventoForma(),
																		   			null
																		   		);
		}
		
		return this.txtReferencia;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropTxtEstado
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtEstado
	 * @return	CajaTextoUtil
	 * 			Caja de texto gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	2/05/2017
	 * *********************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtEstado	()
			throws Exception
	{
		if	(	this.txtEstado	==	null	)
		{
			this.txtEstado = UtilComponentesGUI.getInstance().crearTextField(	EnumDimensionesComponentes.TXT_CEG_ESTADO, 
																		   		"txtEstado", 
																		   		"", 
																		   		false, 
																		   		true, 
																		   		true, 
																		   		super.getEventoForma(),
																		   		null
																		   	);
		}
		
		return this.txtEstado;
	}
	
	/** 
	 * ********************************************************************
	 * @method	iniciarPropLblReferencia
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblReferencia
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	2/05/2017
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblReferencia	()	
			throws Exception
	{
		if	(	this.lblReferencia	==	null	)
		{
			this.lblReferencia = UtilComponentesGUI.getInstance().crearLabel(	EnumDimensionesComponentes.LBL_CEG_REFERENCIA,
																		 		"lblReferencia",
																		 		EnumEtiquetas.LBL_CEG_REFERENCIA,
																		 		true,
																		 		null,
																		 		true
																		 	);
		}
		
		return this.lblReferencia;
	}
	
	/** 
	 * ********************************************************************
	 * @method	iniciarPropLblEstado
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblEstado
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	2/05/2017
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblEstado	()	
			throws Exception
	{
		if	(	this.lblEstado	==	null	)
		{
			this.lblEstado = UtilComponentesGUI.getInstance().crearLabel(	EnumDimensionesComponentes.LBL_CEG_ESTADO,
																		 	"lblReferencia",
																		 	EnumEtiquetas.LBL_CEG_ESTADO,
																		 	true,
																		 	null,
																		 	true
																		 );
		}
		
		return this.lblEstado;
	}
	
	/**
	 * @method getPnlEncabezadoGeneral
	 * 		   Metodo get del atributo pnlEncabezadoGeneral
	 * @return FormaPanelEncabezadoGeneral
	 *		   Valor del atributo pnlEncabezadoGeneral devuelto
	 * @author hector.cuenca
	 * @date   3/12/2016
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
	 * @date   3/12/2016
	 */
	public void setPnlEncabezadoGeneral(
			FormaPanelEncabezadoGeneral pPnlEncabezadoGeneral) {
		this.pnlEncabezadoGeneral = pPnlEncabezadoGeneral;
	}

	/**
	 * @method getLblReferencia
	 * 		   Metodo get del atributo lblReferencia
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblReferencia devuelto
	 * @author hector.cuenca
	 * @date   2/05/2017
	 */
	public EtiquetaUtil getLblReferencia() {
		return lblReferencia;
	}

	/**
	 * @method setLblReferencia
	 * 		   Metodo set del atributo lblReferencia
	 * @param  pLblReferencia
	 *		   Valor que tomara el atributo lblReferencia
	 * @author hector.cuenca
	 * @date   2/05/2017
	 */
	public void setLblReferencia(EtiquetaUtil pLblReferencia) {
		this.lblReferencia = pLblReferencia;
	}

	/**
	 * @method getTxtReferencia
	 * 		   Metodo get del atributo txtReferencia
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtReferencia devuelto
	 * @author hector.cuenca
	 * @date   2/05/2017
	 */
	public CajaTextoUtil getTxtReferencia() {
		return txtReferencia;
	}

	/**
	 * @method setTxtReferencia
	 * 		   Metodo set del atributo txtReferencia
	 * @param  pTxtReferencia
	 *		   Valor que tomara el atributo txtReferencia
	 * @author hector.cuenca
	 * @date   2/05/2017
	 */
	public void setTxtReferencia(CajaTextoUtil pTxtReferencia) {
		this.txtReferencia = pTxtReferencia;
	}

	/**
	 * @method getTxtEstado
	 * 		   Metodo get del atributo txtEstado
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtEstado devuelto
	 * @author hector.cuenca
	 * @date   2/05/2017
	 */
	public CajaTextoUtil getTxtEstado() {
		return txtEstado;
	}

	/**
	 * @method setTxtEstado
	 * 		   Metodo set del atributo txtEstado
	 * @param  pTxtEstado
	 *		   Valor que tomara el atributo txtEstado
	 * @author hector.cuenca
	 * @date   2/05/2017
	 */
	public void setTxtEstado(CajaTextoUtil pTxtEstado) {
		this.txtEstado = pTxtEstado;
	}

	/**
	 * @method getLblEstado
	 * 		   Metodo get del atributo lblEstado
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblEstado devuelto
	 * @author hector.cuenca
	 * @date   2/05/2017
	 */
	public EtiquetaUtil getLblEstado() {
		return lblEstado;
	}

	/**
	 * @method setLblEstado
	 * 		   Metodo set del atributo lblEstado
	 * @param  pLblEstado
	 *		   Valor que tomara el atributo lblEstado
	 * @author hector.cuenca
	 * @date   2/05/2017
	 */
	public void setLblEstado(EtiquetaUtil pLblEstado) {
		this.lblEstado = pLblEstado;
	}

	/**
	 * @method getPnlAgenciaOrigen
	 * 		   Metodo get del atributo pnlAgenciaOrigen
	 * @return FormaPanelCodigoDescripcion
	 *		   Valor del atributo pnlAgenciaOrigen devuelto
	 * @author hector.cuenca
	 * @date   2/05/2017
	 */
	public FormaPanelCodigoDescripcion getPnlAgenciaOrigen() {
		return pnlAgenciaOrigen;
	}

	/**
	 * @method setPnlAgenciaOrigen
	 * 		   Metodo set del atributo pnlAgenciaOrigen
	 * @param  pPnlAgenciaOrigen
	 *		   Valor que tomara el atributo pnlAgenciaOrigen
	 * @author hector.cuenca
	 * @date   2/05/2017
	 */
	public void setPnlAgenciaOrigen(FormaPanelCodigoDescripcion pPnlAgenciaOrigen) {
		this.pnlAgenciaOrigen = pPnlAgenciaOrigen;
	}

	/**
	 * @method getPnlAgenciaDestino
	 * 		   Metodo get del atributo pnlAgenciaDestino
	 * @return FormaPanelCodigoDescripcion
	 *		   Valor del atributo pnlAgenciaDestino devuelto
	 * @author hector.cuenca
	 * @date   2/05/2017
	 */
	public FormaPanelCodigoDescripcion getPnlAgenciaDestino() {
		return pnlAgenciaDestino;
	}

	/**
	 * @method setPnlAgenciaDestino
	 * 		   Metodo set del atributo pnlAgenciaDestino
	 * @param  pPnlAgenciaDestino
	 *		   Valor que tomara el atributo pnlAgenciaDestino
	 * @author hector.cuenca
	 * @date   2/05/2017
	 */
	public void setPnlAgenciaDestino(FormaPanelCodigoDescripcion pPnlAgenciaDestino) {
		this.pnlAgenciaDestino = pPnlAgenciaDestino;
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
	        
			jframe = TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaConsultaEstadoGiro.class,
																			true, 
																			EnumDesplegarFormaConEventos.SI);
			new FormaConsultaEstadoGiro(jframe,
								 true
								 );
			
		} catch (Exception e) {
			
			e.printStackTrace();
			Logger.getInstance().error(e.getMessage());
			
		}
	}
	
}

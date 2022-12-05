package co.com.codesa.clienteposslimgiros.formas.genericas;

import java.awt.Rectangle;

import javax.swing.BorderFactory;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.generico.EventoFormaPanelCodigoDescripcion;
import co.com.codesa.clienteposslimgiros.eventos.serviciosAdicionales.EventoFormaPanelDesplazableServiciosAdicionales;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.interfaces.genericas.PropiedadesPanelCodigoDescripcion;
import co.com.codesa.clienteposslimgiros.interfaces.serviciosAdicionales.IOperacionesContenedorServiciosAdicionales;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

/** 
 * ********************************************************************
 * @class  	FormaPanelCodigoDescripcion
 *		   	Clase forma, que representa una seccion comun y describe los 
 *		   	aspectos graficos, para una entidad u objeto que presente
 *			codigo y descripcion
 * @author 	hector.cuenca
 * @date   	2/05/2017
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class FormaPanelCodigoDescripcion extends FormaPanelGenerico{

	/**
	 * @variable 	serialVersionUID
	 * 			 	Variable serialVersionUID
	 */
	private static final long serialVersionUID = -2212220800038299504L;

	/**
	 * @variable 	lblNombre
	 * 			 	Etiqueta que representa el nombre de la entidad u objeto
	 * 				a representar
	 **/
	private EtiquetaUtil lblNombre;
	
	/**
	 * @variable 	txtCodigo
	 * 			 	Caja de texto que contiene el codigo de la entidad u objeto
	 * 				a representar 
	 **/
	private CajaTextoUtil txtCodigo;
	
	/**
	 * @variable 	txtDescripcion
	 * 			 	Caja de texto que contiene la descripcion de la entidad u objeto
	 * 				a representar 
	 **/
	private CajaTextoUtil txtDescripcion;
	
	/**
	 * @variable 	enmDimensionEtiqueta
	 * 			 	Constante de enmeracion que describe la dimension de la 
	 * 				etiqueta que representa el nombre de la entidad u objeto
	 */
	private EnumDimensionesComponentes enmDimensionEtiqueta;
	
	/**
	 * @variable 	enmDimensionCodigo
	 * 			 	Constante de enmeracion que describe la dimension del 
	 * 				campo que representa el codigo de la entidad u objeto
	 */
	private EnumDimensionesComponentes enmDimensionCodigo;
	
	/**
	 * @variable 	enmDimensionDescripcion
	 * 			 	Constante de enmeracion que describe la dimension del 
	 * 				campo que representa la descripcion de la entidad u objeto
	 */
	private EnumDimensionesComponentes enmDimensionDescripcion;
	
	/**
	 * @variable 	enmEtiquetaNombre
	 * 			 	Constante de enumeracion que representa la etiqueta que define
	 * 				el nombre de la entidad u objeto
	 */
	private EnumEtiquetas enmEtiquetaNombre;
	
	/**
	 * @variable 	arrStrParametrosEtiquetaNombre
	 * 			 	Posibles parametros requeridos por la etiqueta que describe
	 * 				la entidad u objeto
	 */
	private String[] arrStrParametrosEtiquetaNombre;
	
	/**
	 * @variable 	intAnchoEtiqueta
	 * 			 	Ancho de la dimension que tendra la etiqueta que describe
	 * 				la entidad u objeto
	 */
	private Integer intAnchoEtiqueta;
	
	/**
	 * @variable 	propiedades
	 * 			 	Conjunto de operaciones disponibles, desde las funcionalidades 
	 * 				hacia este componente
	 */
	private PropiedadesPanelCodigoDescripcion propiedades;
	
	/** 
	 * ********************************************************************
	 * @method	FormaPanelCodigoDescripcion
	 * 		   	Constructor de la seccion generica, que se encarga de 
	 * 		   	inicializar los atributos y comportamientos en el proceso de
	 * 		   	construccion
	 * @param 	pFrmGnrVentana
	 * 			Referencia a la forma generica que contiene la seccion 
	 * @param 	pStrNombreComponente
	 * 			Nombre tecnico con el cual se identificara la seccion
	 * @param 	pEnmDimension
	 * 			Constante de enumeracion que describe la dimension que tendra
	 * 			el componente
	 * @param	pIntAnchoEtiqueta
	 * 			Ancho de la dimension que tendra la etiqueta que describe
	 * 			la entidad u objeto
	 * @param 	pEnmEtiquetaNombre
	 * 			Constante de enumeracion que representa la etiqueta que define
	 * 			el nombre de la entidad u objeto
	 * @param 	pArrStrParametrosEtiquetaNombre
	 * 			Posibles parametros requeridos por la etiqueta que describe
	 * 			la entidad u objeto
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author 	hector.cuenca
	 * @date   	2/05/2017
	 * *********************************************************************
	 */
	public FormaPanelCodigoDescripcion	(	FormaGenerica pFrmGnrVentana,
	   		   								String pStrNombreComponente,
	   		   								EnumDimensionesComponentes pEnmDimension,
	   		   								Integer pIntAnchoEtiqueta,
	   		   								EnumEtiquetas pEnmEtiquetaNombre,
	   		   								String ...pArrStrParametrosEtiquetaNombre
									  	) 
									  			throws Exception
	{
		super	(	pFrmGnrVentana,
					pEnmDimension,
					pStrNombreComponente,
					BorderFactory.createEmptyBorder(),
					null,
					null
				);
		
		super.setEvaControlEventos(new EventoFormaPanelCodigoDescripcion(this));
		
		super.setBooAplicarTransparenciaFondo(true);
		
		this.setEnmEtiquetaNombre(pEnmEtiquetaNombre);
		this.setArrStrParametrosEtiquetaNombre(pArrStrParametrosEtiquetaNombre);
		this.setIntAnchoEtiqueta(pIntAnchoEtiqueta);
		
		super.iniciar();
	}

	@Override
	protected void inicializarSeccion	() 
			throws Exception 
	{
		this.add(this.iniciarPropLblNombre());
		this.add(this.iniciarPropTxtCodigo());
		this.add(this.iniciarPropTxtDescripcion());
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropTxtCodigo
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtCodigo
	 * @return	CajaTextoUtil
	 * 			Caja de texto gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	2/05/2017
	 * *********************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtCodigo	()
			throws Exception
	{
		if	(	this.txtCodigo	==	null	)
		{
			this.txtCodigo = UtilComponentesGUI.getInstance().crearTextField(	this.getEnmDimensionCodigo(), 
																		   		"txtCodigo", 
																		   		"", 
																		   		false, 
																		   		true, 
																		   		true, 
																		   		super.getEvaControlEventos(),
																		   		null
																		   	);
		}
		
		return this.txtCodigo;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropTxtDescripcion
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtDescripcion
	 * @return	CajaTextoUtil
	 * 			Caja de texto gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	2/05/2017
	 * *********************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtDescripcion	()
			throws Exception
	{
		if	(	this.txtDescripcion	==	null	)
		{
			this.txtDescripcion = UtilComponentesGUI.getInstance().crearTextField	(	this.getEnmDimensionDescripcion(), 
																		   				"txtDescripcion", 
																		   				"", 
																		   				false, 
																		   				true, 
																		   				true, 
																		   				super.getEvaControlEventos(),
																		   				null
																		   			);
		}
		
		return this.txtDescripcion;
	}
	
	/** 
	 * ********************************************************************
	 * @method	iniciarPropLblNombre
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblNombre
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	2/05/2017
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblNombre	()	
			throws Exception
	{
		if	(	this.lblNombre	==	null	)
		{
			this.lblNombre = UtilComponentesGUI.getInstance().crearLabel(	this.getEnmDimensionEtiqueta(),
																		 	"lblNombre",
																		 	this.getEnmEtiquetaNombre(),
																		 	true,
																		 	null,
																		 	true
																		 );
		}
		
		return this.lblNombre;
	}
	
	/**
	 * @method getEnmEtiquetaNombre
	 * 		   Metodo get del atributo enmEtiquetaNombre
	 * @return EnumEtiquetas
	 *		   Valor del atributo enmEtiquetaNombre devuelto
	 * @author hector.cuenca
	 * @date   2/05/2017
	 */
	public EnumEtiquetas getEnmEtiquetaNombre() {
		return enmEtiquetaNombre;
	}

	/**
	 * @method setEnmEtiquetaNombre
	 * 		   Metodo set del atributo enmEtiquetaNombre
	 * @param  pEnmEtiquetaNombre
	 *		   Valor que tomara el atributo enmEtiquetaNombre
	 * @author hector.cuenca
	 * @date   2/05/2017
	 */
	public void setEnmEtiquetaNombre(EnumEtiquetas pEnmEtiquetaNombre) {
		this.enmEtiquetaNombre = pEnmEtiquetaNombre;
	}

	/**
	 * @method getArrStrParametrosEtiquetaNombre
	 * 		   Metodo get del atributo arrStrParametrosEtiquetaNombre
	 * @return String []
	 *		   Valor del atributo arrStrParametrosEtiquetaNombre devuelto
	 * @author hector.cuenca
	 * @date   2/05/2017
	 */
	public String[] getArrStrParametrosEtiquetaNombre() {
		return arrStrParametrosEtiquetaNombre;
	}

	/**
	 * @method setArrStrParametrosEtiquetaNombre
	 * 		   Metodo set del atributo arrStrParametrosEtiquetaNombre
	 * @param  pArrStrParametrosEtiquetaNombre
	 *		   Valor que tomara el atributo arrStrParametrosEtiquetaNombre
	 * @author hector.cuenca
	 * @date   2/05/2017
	 */
	public void setArrStrParametrosEtiquetaNombre(
			String[] pArrStrParametrosEtiquetaNombre) {
		this.arrStrParametrosEtiquetaNombre = pArrStrParametrosEtiquetaNombre;
	}

	/**
	 * @method getLblNombre
	 * 		   Metodo get del atributo lblNombre
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblNombre devuelto
	 * @author hector.cuenca
	 * @date   2/05/2017
	 */
	public EtiquetaUtil getLblNombre() {
		return lblNombre;
	}

	/**
	 * @method setLblNombre
	 * 		   Metodo set del atributo lblNombre
	 * @param  pLblNombre
	 *		   Valor que tomara el atributo lblNombre
	 * @author hector.cuenca
	 * @date   2/05/2017
	 */
	public void setLblNombre(EtiquetaUtil pLblNombre) {
		this.lblNombre = pLblNombre;
	}

	/**
	 * @method getTxtCodigo
	 * 		   Metodo get del atributo txtCodigo
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtCodigo devuelto
	 * @author hector.cuenca
	 * @date   2/05/2017
	 */
	public CajaTextoUtil getTxtCodigo() {
		return txtCodigo;
	}

	/**
	 * @method setTxtCodigo
	 * 		   Metodo set del atributo txtCodigo
	 * @param  pTxtCodigo
	 *		   Valor que tomara el atributo txtCodigo
	 * @author hector.cuenca
	 * @date   2/05/2017
	 */
	public void setTxtCodigo(CajaTextoUtil pTxtCodigo) {
		this.txtCodigo = pTxtCodigo;
	}

	/**
	 * @method getTxtDescripcion
	 * 		   Metodo get del atributo txtDescripcion
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtDescripcion devuelto
	 * @author hector.cuenca
	 * @date   2/05/2017
	 */
	public CajaTextoUtil getTxtDescripcion() {
		return txtDescripcion;
	}

	/**
	 * @method setTxtDescripcion
	 * 		   Metodo set del atributo txtDescripcion
	 * @param  pTxtDescripcion
	 *		   Valor que tomara el atributo txtDescripcion
	 * @author hector.cuenca
	 * @date   2/05/2017
	 */
	public void setTxtDescripcion(CajaTextoUtil pTxtDescripcion) {
		this.txtDescripcion = pTxtDescripcion;
	}

	/**
	 * @method getIntAnchoEtiqueta
	 * 		   Metodo get del atributo intAnchoEtiqueta
	 * @return Integer
	 *		   Valor del atributo intAnchoEtiqueta devuelto
	 * @author hector.cuenca
	 * @date   2/05/2017
	 */
	public Integer getIntAnchoEtiqueta() {
		return intAnchoEtiqueta;
	}

	/**
	 * @method setIntAnchoEtiqueta
	 * 		   Metodo set del atributo intAnchoEtiqueta
	 * @param  pIntAnchoEtiqueta
	 *		   Valor que tomara el atributo intAnchoEtiqueta
	 * @author hector.cuenca
	 * @date   2/05/2017
	 */
	public void setIntAnchoEtiqueta(Integer pIntAnchoEtiqueta) {
		this.intAnchoEtiqueta = pIntAnchoEtiqueta;
	}

	/**
	 * @method getEnmDimensionEtiqueta
	 * 		   Metodo get del atributo enmDimensionEtiqueta
	 * @return EnumDimensionesComponentes
	 *		   Valor del atributo enmDimensionEtiqueta devuelto
	 * @author hector.cuenca
	 * @date   2/05/2017
	 */
	public EnumDimensionesComponentes getEnmDimensionEtiqueta(){
		
		if	(	this.enmDimensionEtiqueta	==	null)
		{
			this.enmDimensionEtiqueta	=	EnumDimensionesComponentes.LBL_PNL_COD_DESC_NOMBRE;
			
			if	(	this.intAnchoEtiqueta	!=	null	)
			{
				this.enmDimensionEtiqueta.getRectangulo().width	=	this.intAnchoEtiqueta;
			}
		}
		
		return enmDimensionEtiqueta;
	}

	/**
	 * @method setEnmDimensionEtiqueta
	 * 		   Metodo set del atributo enmDimensionEtiqueta
	 * @param  pEnmDimensionEtiqueta
	 *		   Valor que tomara el atributo enmDimensionEtiqueta
	 * @author hector.cuenca
	 * @date   2/05/2017
	 */
	public void setEnmDimensionEtiqueta(EnumDimensionesComponentes pEnmDimensionEtiqueta) {
		this.enmDimensionEtiqueta = pEnmDimensionEtiqueta;
	}

	/**
	 * @method getEnmDimensionCodigo
	 * 		   Metodo get del atributo enmDimensionCodigo
	 * @return EnumDimensionesComponentes
	 *		   Valor del atributo enmDimensionCodigo devuelto
	 * @author hector.cuenca
	 * @date   2/05/2017
	 */
	public EnumDimensionesComponentes getEnmDimensionCodigo() {
		
		Rectangle recEtiqueta;
		
		if	(	this.enmDimensionCodigo	==	null	)
		{
			this.enmDimensionCodigo	=	EnumDimensionesComponentes.TXT_PNL_COD_DESC_CODIGO;
			
			recEtiqueta	=	this.getEnmDimensionEtiqueta().getRectangulo();
			
			this.enmDimensionCodigo.getRectangulo().x	=	recEtiqueta.x+recEtiqueta.width+10;
		}
		
		return enmDimensionCodigo;
	}

	/**
	 * @method setEnmDimensionCodigo
	 * 		   Metodo set del atributo enmDimensionCodigo
	 * @param  pEnmDimensionCodigo
	 *		   Valor que tomara el atributo enmDimensionCodigo
	 * @author hector.cuenca
	 * @date   2/05/2017
	 */
	public void setEnmDimensionCodigo(EnumDimensionesComponentes pEnmDimensionCodigo) {
		this.enmDimensionCodigo = pEnmDimensionCodigo;
	}

	/**
	 * @method getEnmDimensionDescripcion
	 * 		   Metodo get del atributo enmDimensionDescripcion
	 * @return EnumDimensionesComponentes
	 *		   Valor del atributo enmDimensionDescripcion devuelto
	 * @author hector.cuenca
	 * @date   2/05/2017
	 */
	public EnumDimensionesComponentes getEnmDimensionDescripcion() 
	{
		Rectangle recCodigo;	
		
		if	(	this.enmDimensionDescripcion	==	null	)
		{
			this.enmDimensionDescripcion	=	EnumDimensionesComponentes.TXT_PNL_COD_DESC_DESCRIPCION;
			
			recCodigo	=	this.getEnmDimensionCodigo().getRectangulo();
			
			this.enmDimensionDescripcion.getRectangulo().x	=	recCodigo.x+recCodigo.width+5;
			
			this.enmDimensionDescripcion.getRectangulo().width	=	this.getBounds().width - this.enmDimensionDescripcion.getRectangulo().x;
		}
		
		return enmDimensionDescripcion;
	}

	/**
	 * @method setEnmDimensionDescripcion
	 * 		   Metodo set del atributo enmDimensionDescripcion
	 * @param  pEnmDimensionDescripcion
	 *		   Valor que tomara el atributo enmDimensionDescripcion
	 * @author hector.cuenca
	 * @date   2/05/2017
	 */
	public void setEnmDimensionDescripcion(EnumDimensionesComponentes pEnmDimensionDescripcion) {
		this.enmDimensionDescripcion = pEnmDimensionDescripcion;
	}

	/**
	 * @method getPropiedades
	 * 		   Metodo get del atributo propiedades
	 * @return PropiedadesPanelCodigoDescripcion
	 *		   Valor del atributo propiedades devuelto
	 * @author hector.cuenca
	 * @date   2/05/2017
	 */
	public PropiedadesPanelCodigoDescripcion getPropiedades() {
		return propiedades;
	}

	/**
	 * @method setPropiedades
	 * 		   Metodo set del atributo propiedades
	 * @param  pPropiedades
	 *		   Valor que tomara el atributo propiedades
	 * @author hector.cuenca
	 * @date   2/05/2017
	 */
	public void setPropiedades(PropiedadesPanelCodigoDescripcion pPropiedades) {
		this.propiedades = pPropiedades;
	}
}
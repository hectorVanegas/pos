package co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales;

import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.ServicioAdicionalDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.serviciosAdicionales.EnumServiciosAdicionales;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaVerificadaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelGenerico;
import co.com.codesa.clienteposslimgiros.interfaces.serviciosAdicionales.IOperacionesServiciosAdicionales;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

/** 
 * ********************************************************************
 * @class  FormaPanelServicioAdicional
 *		   Clase forma, que representa una seccion comun y describe los 
 *		   aspectos graficos correspondientes a un servicio adicional
 * @param <T>
 * 		  Representacion generica de objetos DTO del tipo 
 * 		  ServicioAdicionalDTO  
 * @author hector.cuenca
 * @date   7/03/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public abstract class FormaPanelServicioAdicional<T extends ServicioAdicionalDTO> extends FormaPanelGenerico{

	/**
	 * @variable serialVersionUID
	 * 			 Serial de identificacion de clase
	 */
	private static final long serialVersionUID = -7734858279144273094L;
	
	/**
	 * @variable cmbValor
	 * 			 Lista desplegable que permite identificar el valor determinado
	 * 			 para el servicio
	 **/
	private CajaComboUtil cmbValor;
	
	/**
	 * @variable chkIncluir
	 * 			 Componente de verificacion que permite Identificar, si el 
	 * 			 servicio esta o no incluido en el proceso
	 **/
	private CajaVerificadaUtil chkIncluir;
	
	/**
	 * @variable enmServicioAdicional
	 * 			 Constante de enumeracion que representa informacion basica 
	 * 			 del servicio
	 */
	private EnumServiciosAdicionales enmServicioAdicional;
	
	/**
	 * @variable arrStrParametrosNombre
	 * 			 Posibles parametros requeridos por la etiqueta que referencia el
	 * 		   	 nombre del servicio
	 */
	private String[] arrStrParametrosNombre;
	
	/**
	 * @variable operaciones
	 * 			 Interface que representa el conjunto de operaciones disponibles,
	 * 			 para ejecutar por parte del servicio adicional particular que se
	 * 			 esta llevando a cabo
	 */
	private IOperacionesServiciosAdicionales<T> operaciones;
	
	/** 
	 * ********************************************************************
	 * @method FormaPanelServicioAdicional
	 * 		   Constructor que ejecuta la inicializacion de valores y 
	 * 		   ejecucion de comportamientos inicales requeridos para
	 *         el despliegue de la seccion general
	 * @param  pFrmGnrVentana
	 * 		   Representa a la funcionalidad que integra la posible 
	 * 		   inclusion del servicio adicional
	 * @param  pStrNombreComponente
	 * 		   Nombre que recibira la seccion como tal
	 * @param  pEnmServicioAdicional
	 * 		   Constante de enumeracion que representa informacion basica del 
	 * 		   servicio
	 * @param  pArrStrParametrosNombre
	 * 		   Posibles parametros requeridos por la etiqueta que 
	 * 		   referencia el nombre del servicio
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author hector.cuenca
	 * @date   7/03/2016
	 * *********************************************************************
	 */
	public FormaPanelServicioAdicional(FormaGenerica pFrmGnrVentana,
							   		   String pStrNombreComponente,
							   		   EnumServiciosAdicionales pEnmServicioAdicional,
							   		   String ...pArrStrParametrosNombre) throws Exception {
		
		super(pFrmGnrVentana,
			  EnumDimensionesComponentes.PNL_SVA_SECCION,
			  pStrNombreComponente,
			  BorderFactory.createEtchedBorder(),
			  TitledBorder.LEFT,
			  pEnmServicioAdicional.getEnmEtiNombre(),
			  pArrStrParametrosNombre);
		
		super.setBooAplicarTransparenciaFondo(true);
		
		this.setEnmServicioAdicional(pEnmServicioAdicional);
		this.setArrStrParametrosNombre(pArrStrParametrosNombre);
	}
	
	@Override
	protected void inicializarSeccion()throws Exception{
		
		this.add(this.iniciarPropChkIncluir());
		this.add(this.iniciarPropCmbValor());
	}

	/**
	 * ********************************************************************
	 * @method iniciarPropCmbValor
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   cmbValor
	 * @return CajaComboUtil
	 * 		   Lista de valores gestionada
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author hector.cuenca
	 * @date   7/03/2016
	 * *********************************************************************
	 */
	public CajaComboUtil iniciarPropCmbValor() throws Exception{
		
		Rectangle recDimensionSeccion;
		Rectangle recDimensionCmbValor;
		int intMargenSeparador;
		
		if (this.cmbValor == null) {
			
			recDimensionSeccion = super.getEnmDimensionSeccion().getRectangulo();
			recDimensionCmbValor = EnumDimensionesComponentes.PNL_SVA_CMB_VALOR.getRectangulo();
			intMargenSeparador = 10;
			
			recDimensionCmbValor.setBounds(new Rectangle(recDimensionCmbValor.x,
														 recDimensionCmbValor.y,
	 							 						 recDimensionSeccion.width-(recDimensionCmbValor.x+intMargenSeparador),
	 							 						 recDimensionCmbValor.height));
			
			this.cmbValor = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.PNL_SVA_CMB_VALOR,
																		   "cmbValor", 
																		   false, 
																		   true, 
																		   super.getEvaControlEventos(),
																		   this.getEnmServicioAdicional().getEnmEtiNombre(),
																		   this.getArrStrParametrosNombre());
		}
		
		return cmbValor;
	}
	
	/**
	 * ********************************************************************
	 * @method iniciarPropChkIncluir
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   chkIncluir
	 * @return CajaVerificadaUtil
	 * 		   Caja de verificacion gestionada
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author hector.cuenca
	 * @date   7/03/2016
	 * *********************************************************************
	 */
	public CajaVerificadaUtil iniciarPropChkIncluir() throws Exception{
		
		if (this.chkIncluir == null) {
			
			this.chkIncluir = UtilComponentesGUI.getInstance().crearCheckBox(EnumDimensionesComponentes.PNL_SVA_CHK_INCLUIR, 
																			 "chkIncluir", 
																			 null,
																			 true, 
																			 false, 
																			 true,
																			 false,
																			 super.getEvaControlEventos(),
																			 SwingConstants.LEFT,
																			 true);
		}
		 
		return chkIncluir;
	}

	/**
	 * @method getCmbValor
	 * 		   Metodo get del atributo cmbValor
	 * @return CajaComboUtil
	 *		   Valor del atributo cmbValor devuelto
	 * @author hector.cuenca
	 * @date   11/03/2016
	 */
	public CajaComboUtil getCmbValor() {
		return this.cmbValor;
	}

	/**
	 * @method setCmbValor
	 * 		   Metodo set del atributo cmbValor
	 * @param  pCmbValor
	 *		   Valor que tomara el atributo cmbValor
	 * @author hector.cuenca
	 * @date   11/03/2016
	 */
	public void setCmbValor(CajaComboUtil pCmbValor) {
		this.cmbValor = pCmbValor;
	}

	/**
	 * @method getChkIncluir
	 * 		   Metodo get del atributo chkIncluir
	 * @return CajaVerificadaUtil
	 *		   Valor del atributo chkIncluir devuelto
	 * @author hector.cuenca
	 * @date   11/03/2016
	 */
	public CajaVerificadaUtil getChkIncluir() {
		return this.chkIncluir;
	}

	/**
	 * @method setChkIncluir
	 * 		   Metodo set del atributo chkIncluir
	 * @param  pChkIncluir
	 *		   Valor que tomara el atributo chkIncluir
	 * @author hector.cuenca
	 * @date   11/03/2016
	 */
	public void setChkIncluir(CajaVerificadaUtil pChkIncluir) {
		this.chkIncluir = pChkIncluir;
	}

	/**
	 * @method getEnmServicioAdicional
	 * 		   Metodo get del atributo enmServicioAdicional
	 * @return EnumServiciosAdicionales
	 *		   Valor del atributo enmServicioAdicional devuelto
	 * @author hector.cuenca
	 * @date   16/03/2016
	 */
	public EnumServiciosAdicionales getEnmServicioAdicional() {
		return this.enmServicioAdicional;
	}

	/**
	 * @method setEnmServicioAdicional
	 * 		   Metodo set del atributo enmServicioAdicional
	 * @param  pEnmServicioAdicional
	 *		   Valor que tomara el atributo enmServicioAdicional
	 * @author hector.cuenca
	 * @date   16/03/2016
	 */
	public void setEnmServicioAdicional(
			EnumServiciosAdicionales pEnmServicioAdicional) {
		this.enmServicioAdicional = pEnmServicioAdicional;
	}

	/**
	 * @method getArrStrParametrosNombre
	 * 		   Metodo get del atributo arrStrParametrosNombre
	 * @return String[]
	 *		   Valor del atributo arrStrParametrosNombre devuelto
	 * @author hector.cuenca
	 * @date   11/03/2016
	 */
	public String[] getArrStrParametrosNombre() {
		return this.arrStrParametrosNombre;
	}

	/**
	 * @method setArrStrParametrosNombre
	 * 		   Metodo set del atributo arrStrParametrosNombre
	 * @param  pArrStrParametrosNombre
	 *		   Valor que tomara el atributo arrStrParametrosNombre
	 * @author hector.cuenca
	 * @date   11/03/2016
	 */
	public void setArrStrParametrosNombre(String[] pArrStrParametrosNombre) {
		this.arrStrParametrosNombre = pArrStrParametrosNombre;
	}

	/**
	 * @method getOperaciones
	 * 		   Metodo get del atributo operaciones
	 * @return IOperacionesServiciosAdicionales<T>
	 *		   Valor del atributo operaciones devuelto
	 * @author hector.cuenca
	 * @date   22/03/2016
	 */
	public IOperacionesServiciosAdicionales<T> getOperaciones() {
		return operaciones;
	}

	/**
	 * @method setOperaciones
	 * 		   Metodo set del atributo operaciones
	 * @param  pOperaciones
	 *		   Valor que tomara el atributo operaciones
	 * @author hector.cuenca
	 * @date   22/03/2016
	 */
	public void setOperaciones(IOperacionesServiciosAdicionales<T> pOperaciones) {
		this.operaciones = pOperaciones;
	}
}

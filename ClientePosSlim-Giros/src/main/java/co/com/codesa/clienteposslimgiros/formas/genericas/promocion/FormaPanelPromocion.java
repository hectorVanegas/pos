package co.com.codesa.clienteposslimgiros.formas.genericas.promocion;

import java.awt.Font;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.eventos.generico.promocion.EventoFormaPanelPromocion;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.GrillaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelDesplazableGenerico;
import co.com.codesa.clienteposslimgiros.interfaces.promocion.IOperacionesPromocion;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Promocion;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

/**
 * ********************************************************************
 * @class  	FormaPanelPromocion
 *		   	Clase que genera la forma de la funcionalidad transversal 
 *			para la gestion de promociones, a manera de una seccion 
 *			desplazable, disenada para ser incluida sobre funcionalidades 
 *			principales 
 * @author 	hector.cuenca
 * @date   	6/12/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class FormaPanelPromocion extends FormaPanelDesplazableGenerico{
	
	/**
	 * @variable 	serialVersionUID
	 * 			 	Variable serialVersionUID
	 */
	private static final long serialVersionUID = -9166562617306487595L;
	
	/**
	 * @variable 	tblPromociones
	 * 			 	Grilla donde se concentra la gestion de promociones
	 */
	private	GrillaUtil	tblPromociones;
	
	/**
	 * @variable	txtDatoPromocion
	 * 			 	Caja de texto para ingresar el dato de cada promocion
	 */
	private CajaTextoUtil txtDatoPromocion;
	
	/**
	 * @variable 	operaciones
	 * 			 	conjunto de operaciones disponibles a traves de la 
	 * 				funcionalidad que gestiona las promociones, para ser 
	 * 				asimiladas dentro de la logica de negocio de las 
	 * 				funcionalidades principales
	 */
	private IOperacionesPromocion operaciones;
	
	/**
	 * ********************************************************************
	 * @method 	FormaPanelPromocion
	 * 		   	Constructor que ejecuta la inicializacion de valores y 
  	 * 		   	ejecucion de comportamientos inicales requeridos para el 
  	 * 		   	despliegue de la forma, relacionada con la funcionalidad en 
  	 * 			cuestion
	 * @param 	pFrmPadre
	 * 			Forma principal que contiene la funcionalidad transversal
	 * @param 	pEnmDimensionPanel
	 * 			Especifica las dimensiones que tendra la funcionalidad 
	 * 			transversal
	 * @param 	pStrNombreComponente
	 * 			Nombre tecnico que permite identificar el componente 
	 * 			transversal que se generara
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	hector.cuenca
	 * @date   	6/12/2016
	 * *********************************************************************
	 */
	public FormaPanelPromocion	(	FormaGenerica pFrmPadre,
							   		EnumDimensionesComponentes pEnmDimensionPanel,
							   		String pStrNombreComponente
							   	)	throws	Exception
	{
		super	(	pFrmPadre,
					pEnmDimensionPanel,
					pStrNombreComponente,
					null,
					null,
					null
				);
		
		super.setEvaControlEventos	(	new EventoFormaPanelPromocion	(	this	)	);
		this.setOperaciones(this.getEvaControlEventos());
		
		super.iniciar();
	}
	
	@Override
	protected void inicializarSeccionDesplazable() throws Exception 
	{
		super.setBooAplicarTransparenciaFondo(true);
		this.setViewportView(this.iniciarPropTblPromociones());
	}
	
	/**
     * ****************************************************************
     * @method	iniciarPropTblPromociones
     * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	tblPromociones
     * @return 	GrillaUtil
     * 		   	Tabla gestionada
     * @throws 	Exception
     * 		   	Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
     * @author 	hector.cuenca
     * @date   	4/3/2015
     * ****************************************************************
     */
	public GrillaUtil iniciarPropTblPromociones() throws Exception
	{
		if	(	this.tblPromociones	==	null	)
		{
			
			this.tblPromociones	=	UtilComponentesGUI.getInstance().crearGrilla	(	"tblPromociones",
															   							new EnumEtiquetas[]{EnumEtiquetas.TTL_EGP_GRILLA_PROMO_ID,
																					 	 					EnumEtiquetas.TTL_EGP_GRILLA_PROMO_SORTEO,
																					 	 					EnumEtiquetas.TTL_EGP_GRILLA_PROMO_TIPO,
																					 	 					EnumEtiquetas.TTL_EGP_GRILLA_PROMO_CIFRAS,
																					 	 					EnumEtiquetas.TTL_EGP_GRILLA_PROMO_DATO},
																					 	null,//invisibles
																					 	new boolean[] {	false, 
																				   	   	   				false, 
																				   	   	   				false,
																				   	   	   				false,
																				   	   	   				true},//editable por columna
																				   	   	new int[] {	20,
																			   	   	   				150,
																			   	   	   				100,
																			   	   	   				20,
																			   	   	   				40},//dimensiones
																			   	   	   	super.getEvaControlEventos()//evento
																	    			);
		}
		
		return this.tblPromociones;
	}
	
	/**
     * ****************************************************************
     * @method	iniciarPropTxtDatoPromocion
     * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtDatoPromocion
     * @return 	CajaTextoUtil
     * 		   	Caja de texto gestionada
     * @throws 	Exception
     * 		   	Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
     * @author 	hector.cuenca
     * @date   	4/3/2015
     * ****************************************************************
     */
	public	CajaTextoUtil	iniciarPropTxtDatoPromocion	()	throws	Exception
	{
		//if	(	this.txtDatoPromocion	==	null	)
		//{
			this.txtDatoPromocion	=	UtilComponentesGUI.getInstance().crearTextField	(	null, 
																	     		 	 		"txtDatoPromocion", 
																	     		 	 		"",
																	     		 	 		true, 
																	     		 	 		true, 
																	     		 	 		true, 
																	     		 	 		super.getEvaControlEventos(),
																	     		 	 		null
																	     		 	 	);
			this.txtDatoPromocion.setBorder(BorderFactory.createEmptyBorder());
			
			/**
			 * La fuente (Font) recuperada de la grilla no funciona como se espera, sobre
			 * la caja de texto, por tal razon, para estandarizar la visual de las celdas,
			 * se personaliza la fuente de la caja de texto que se adjuntara a la celda de 
			 * ingreso, con 11 puntos como el equivalente al propuesto por la grilla
			 */
			this.txtDatoPromocion.setFont(this.txtDatoPromocion.getFont().deriveFont(Font.PLAIN, 11));
			
			this.txtDatoPromocion.setHorizontalAlignment(SwingConstants.CENTER);
		//}
		
		return this.txtDatoPromocion;
	}
	
	/**
	 * @method getTblPromociones
	 * 		   Metodo get del atributo tblPromociones
	 * @return GrillaUtil
	 *		   Valor del atributo tblPromociones devuelto
	 * @author hector.cuenca
	 * @date   7/12/2016
	 */
	public GrillaUtil getTblPromociones() {
		return this.tblPromociones;
	}

	/**
	 * @method setTblPromociones
	 * 		   Metodo set del atributo tblPromociones
	 * @param  pTblPromociones
	 *		   Valor que tomara el atributo tblPromociones
	 * @author hector.cuenca
	 * @date   7/12/2016
	 */
	public void setTblPromociones(GrillaUtil pTblPromociones) {
		this.tblPromociones = pTblPromociones;
	}

	/**
	 * @method getTxtDatoPromocion
	 * 		   Metodo get del atributo txtDatoPromocion
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtDatoPromocion devuelto
	 * @author hector.cuenca
	 * @date   9/12/2016
	 */
	public CajaTextoUtil getTxtDatoPromocion() {
		return txtDatoPromocion;
	}

	/**
	 * @method setTxtDatoPromocion
	 * 		   Metodo set del atributo txtDatoPromocion
	 * @param  pTxtDatoPromocion
	 *		   Valor que tomara el atributo txtDatoPromocion
	 * @author hector.cuenca
	 * @date   9/12/2016
	 */
	public void setTxtDatoPromocion(CajaTextoUtil pTxtDatoPromocion) {
		this.txtDatoPromocion = pTxtDatoPromocion;
	}
	
	/**
	 * @method getOperaciones
	 * 		   Metodo get del atributo operaciones
	 * @return IOperacionesPromocion
	 *		   Valor del atributo operaciones devuelto
	 * @author hector.cuenca
	 * @date   7/12/2016
	 */
	public IOperacionesPromocion getOperaciones() {
		return this.operaciones;
	}

	/**
	 * @method setOperaciones
	 * 		   Metodo set del atributo operaciones
	 * @param  pOperaciones
	 *		   Valor que tomara el atributo operaciones
	 * @author hector.cuenca
	 * @date   7/12/2016
	 */
	public void setOperaciones(EventoAbstracto pOperaciones) {
		this.operaciones = (IOperacionesPromocion)pOperaciones;
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
	public static void main(String args[]){
		
		HashMap<String,Promocion> lstPromociones;
		String[] arrPromociones;
		String[] datosPromociones;
		
		Promocion objPromocion;
		String strTrmPromociones;
		
		FormaPanelPromocion frmScpServiciosAdicionales;
		JFrame frm;
		
		try {
			
			//TestPruebasInternas.getInstance().iniciarPruebaInterna(null,true, EnumDesplegarFormaConEventos.NO);
			
			strTrmPromociones	=	"7|PROMOCION SUPERGIROS|Loteria de Medellin|N|3|1|300000|31-12-2016|220000|01-12-2016|31-12-2016~"	+
									"8|PROMOCION SUPERGIROS8|Loteria prueba|N|4|1|300000|31-12-2016|220000|01-12-2016|31-12-2016~"	
									;
			
			lstPromociones= new HashMap<String,Promocion>();
			
			arrPromociones = strTrmPromociones.split("~");
			
			for (int i = 0; i < arrPromociones.length; i++) {

				datosPromociones = arrPromociones[i].split("\\|");
				
				if(datosPromociones.length>1){
					
					objPromocion = new Promocion();
					objPromocion.setId(datosPromociones[0]);
					objPromocion.setDescripcion(datosPromociones[1]);
					objPromocion.setAtributo(datosPromociones[2]);
					objPromocion.setTipoDato(datosPromociones[3]);
					objPromocion.setLongitud(datosPromociones[4]);
					objPromocion.setMontoInicial(datosPromociones[5]);
					objPromocion.setMontoFinal(datosPromociones[6]);
					objPromocion.setFechaSorteo(UtilidadGiros.getInstancia().getFecha(datosPromociones[7]));
					objPromocion.setHoraSorteo(datosPromociones[8]);
					
					objPromocion.setFechaInicial(datosPromociones[9]);
					objPromocion.setFechaFinal(datosPromociones[10]);
					
					lstPromociones.put(objPromocion.getId(),objPromocion);
				}
			}
			
			frmScpServiciosAdicionales = new FormaPanelPromocion	(	null,
																		EnumDimensionesComponentes.JPN_EGP_PANEL_CUERPO,
																		"frmScpServiciosAdicionales"
																	);
			
			frmScpServiciosAdicionales.getOperaciones().adicionarPromociones(lstPromociones);
			
			/*operacionesClaveSeguridad = frmScpServiciosAdicionales.getOperaciones().adicionarServicio(EnumServiciosAdicionales.CLAVE_SEGURIDAD, 
																		  "pnlClaveSeguridad");
			
			frmScpServiciosAdicionales.getOperaciones().adicionarServicio(EnumServiciosAdicionales.CLAVE_SEGURIDAD, 
					  "pnlClaveSeguridad2");
			
			frmScpServiciosAdicionales.getOperaciones().adicionarServicio(EnumServiciosAdicionales.CLAVE_SEGURIDAD, 
					  "pnlClaveSeguridad3");
			
			frmScpServiciosAdicionales.getOperaciones().adicionarServicio(EnumServiciosAdicionales.CLAVE_SEGURIDAD, 
					  "pnlClaveSeguridad4");*/
			
			frm	=	new JFrame();
			frm.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
			frm.setLayout(null);
			frm.setSize(765,600);
			frm.add(frmScpServiciosAdicionales);
			
			frm.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
package co.com.codesa.clienteposslimgiros.formas.genericas;

import javax.swing.JDialog;
import javax.swing.JPanel;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.generico.EventoFormaPanelDatosAdicionales;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.GrillaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionDesplazableUtil;
import co.com.codesa.clienteposslimgiros.interfaces.datosAdicionales.PropiedadesPnlDatosAdicionales;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 04-oct-2015
 * @clase FormaPanelDatosAdicionales
 * 		  Forma para disponer de una seccion de datos adicionales
 * @copyright: Copyright  1998-2012 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class FormaPanelDatosAdicionales extends SeccionDesplazableUtil{
	
	/**
	 * @variable 	serialVersionUID
	 * 			 	Variable serialVersionUID
	 */
	private static final long serialVersionUID = -5360076150519942675L;

	/**
	 * @variable scpGrillaDatosAdicionales
	 * 			 componente de scroll que contiene la grilla de datos adicionales
	 **/
	//private JScrollPane scpGrillaDatosAdicionales;
	
	/**
	 * @variable tblDatosAdicionales
	 * 			 grilla que contiene los datos adicionales
	 **/
	private GrillaUtil tblDatosAdicionales;
	
	private PropiedadesPnlDatosAdicionales propiedadesPnlDatosAdicionales;
	
	private FormaGenerica formaPadre;
	
	private EventoFormaPanelDatosAdicionales evaFrmPnlDatosAdicionales;
	
	/**
	 * ********************************************************************
	 * @method 	FormaPanelDatosAdicionales
	 * 		   	Constructor que ejecuta la inicializacion de valores y 
  	 * 		   	ejecucion de comportamientos inicales requeridos para el 
  	 * 		   	despliegue de la forma
	 * @param 	pFormaPadre
	 * 			ventana de la cual extiende esta forma
	 * @param 	pEnmDimensionPanel
	 * 			Dimensiones especificadas para delimitar la seccion
	 * @param 	pIntJustificacionTitulo
	 * 			Tipo de justificacion que tendra el titulo de datos adicionales.
	 * 		  	Se recomienda el manejo de TitledBorder, y sus constantes
	 * 		  	CENTER, RIGTH, LEFT, entre otras
	 * @param 	pStrNombreComponente
	 * 			Nombre tecnico con el cual se identifica el componente
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	2/12/2016
	 * *********************************************************************
	 */
	public FormaPanelDatosAdicionales(FormaGenerica pFormaPadre,
							 		  EnumDimensionesComponentes pEnmDimensionPanel,
							 		  Integer pIntJustificacionTitulo,
							 		  String pStrNombreComponente) throws Exception{
		super	(	pEnmDimensionPanel,
					pStrNombreComponente,
					null,
					pIntJustificacionTitulo,
					EnumEtiquetas.TTL_PNL_DAT_ADI_VENTANA
				);
		
		this.inicializarForma(pFormaPadre,
							  pEnmDimensionPanel);
	}
	
	/**
	 * ********************************************************************
	 * @method 	FormaPanelDatosAdicionales
	 * 		   	Constructor que ejecuta la inicializacion de valores y 
  	 * 		   	ejecucion de comportamientos inicales requeridos para el 
  	 * 		   	despliegue de la forma
	 * @param 	pFormaPadre
	 * 			ventana de la cual extiende esta forma
	 * @param 	pEnmDimensionPanel
	 * 			Dimensiones especificadas para delimitar la seccion
	 * @param 	pIntJustificacionTitulo
	 * 			Tipo de justificacion que tendra el titulo de datos adicionales.
	 * 		  	Se recomienda el manejo de TitledBorder, y sus constantes
	 * 		  	CENTER, RIGTH, LEFT, entre otras
	 * @param 	pStrNombreComponente
	 * 			Nombre tecnico con el cual se identifica el componente
	 * @param	pEnmTitulo
	 * 			Constante de enumeracion que representa una etiqueta para el
	 * 			titulo de la seccion adicional
	 * @param	pArrStrParametrosTitulo
	 * 			Parametros asociados al titulo
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	2/12/2016
	 * *********************************************************************
	 */
	public	FormaPanelDatosAdicionales	(	FormaGenerica pFormaPadre,
	 		  								EnumDimensionesComponentes pEnmDimensionPanel,
	 		  								Integer pIntJustificacionTitulo,
	 		  								String pStrNombreComponente,
	 		  								EnumEtiquetas	pEnmTitulo,
	 		  								String	...pArrStrParametrosTitulo
	 		  							)	throws	Exception
	{
		super	(	pEnmDimensionPanel,
					pStrNombreComponente,
					null,
					pIntJustificacionTitulo,
					pEnmTitulo,
					pArrStrParametrosTitulo
				);

		this.inicializarForma	(	pFormaPadre,
									pEnmDimensionPanel
								);
	}

	/**
	 * ****************************************************************.
	 * @metodo inicializarForma
	 * 		   Permite inicializar todos los aspectos graficos de la forma
	 * @param pEnmDimensionPanel
	 * 		  Dimensiones especificadas para delimitar la seccion
	 * @throws Exception 
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
	 * 		   presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	private void inicializarForma(FormaGenerica pFormaPadre,
								  EnumDimensionesComponentes pEnmDimensionPanel)throws Exception{

		this.formaPadre = pFormaPadre;
		this.evaFrmPnlDatosAdicionales = new EventoFormaPanelDatosAdicionales(this);
		this.propiedadesPnlDatosAdicionales = this.evaFrmPnlDatosAdicionales;
		this.setBooAplicarTransparenciaFondo(false);
		
		//this.add(this.iniciarPropScrollGrillaDatosAdicionales(pEnmDimensionPanel));
		this.setViewportView(this.iniciarPropGrillaDatosAdicionales());
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropScrollGrillaDatosAdicionales
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   scpGrillaDatosAdicionales
  	 * @return JScrollPane
  	 * 		   contenedor para el despliegue de grilla gestionado
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	/*public JScrollPane iniciarPropScrollGrillaDatosAdicionales(EnumDimensionesComponentes pEnmDimensionPanel) throws Exception{
		
		Rectangle recGrillaDatosAdicionales;
		
		if(this.scpGrillaDatosAdicionales == null){
			
			recGrillaDatosAdicionales = EnumDimensionesComponentes.SCP_PNL_DAT_ADI_GRILLA_DATOS_ADICIONALES.getRectangulo();
			
			recGrillaDatosAdicionales.setSize(pEnmDimensionPanel.getRectangulo().width-20, 
											  pEnmDimensionPanel.getRectangulo().height-40);
			
			this.scpGrillaDatosAdicionales = UtilComponentesGUI.getInstance().crearScroll("scpGrillaDatosAdicionales",
													 					 			  	  EnumDimensionesComponentes.SCP_PNL_DAT_ADI_GRILLA_DATOS_ADICIONALES,
													 					 			  	  null);
			
			this.scpGrillaDatosAdicionales.setViewportView(this.iniciarPropGrillaDatosAdicionales());			
		}
		
		return this.scpGrillaDatosAdicionales;
	}*/
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropGrillaDatosAdicionales
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   tblDatosAdicionales
  	 * @return GrillaUtil 
  	 * 		   grilla gestionada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public GrillaUtil iniciarPropGrillaDatosAdicionales() throws Exception{
		
		if(this.tblDatosAdicionales == null){
			
			this.tblDatosAdicionales = UtilComponentesGUI.getInstance().crearGrilla("tblDatosAdicionales",
														  				  			new EnumEtiquetas[]{EnumEtiquetas.TTL_PNL_DAT_ADI_GRILLA_DATOS_ADICIONALES_DATO,
																	   				   		 	 		EnumEtiquetas.TTL_PNL_DAT_ADI_GRILLA_DATOS_ADICIONALES_VALOR},
																	   				null,//invisibles
																	   				new boolean[] {false, 
																		 				 	   	   true},//editable por columna
																		 		    new int[] {20,
																	 			     	   	   50},//dimensiones
																	 			    this.evaFrmPnlDatosAdicionales);
		}
		
		return this.tblDatosAdicionales;
	}

	/**
	 * @method getTblDatosAdicionales
	 * 		   Metodo get del atributo tblDatosAdicionales
	 * @return GrillaUtil
	 *		   Valor del atributo tblDatosAdicionales devuelto
	 * @author hector.cuenca
	 * @date   2/12/2016
	 */
	public GrillaUtil getTblDatosAdicionales() {
		return this.tblDatosAdicionales;
	}

	/**
	 * @method setTblDatosAdicionales
	 * 		   Metodo set del atributo tblDatosAdicionales
	 * @param  pTblDatosAdicionales
	 *		   Valor que tomara el atributo tblDatosAdicionales
	 * @author hector.cuenca
	 * @date   2/12/2016
	 */
	public void setTblDatosAdicionales(GrillaUtil pTblDatosAdicionales) {
		this.tblDatosAdicionales = pTblDatosAdicionales;
	}

	/**
	 * @method getPropiedadesPnlDatosAdicionales
	 * 		   Metodo get del atributo propiedadesPnlDatosAdicionales
	 * @return PropiedadesPnlDatosAdicionales
	 *		   Valor del atributo propiedadesPnlDatosAdicionales devuelto
	 * @author hector.cuenca
	 * @date   2/12/2016
	 */
	public PropiedadesPnlDatosAdicionales getPropiedadesPnlDatosAdicionales() {
		return this.propiedadesPnlDatosAdicionales;
	}

	/**
	 * @method setPropiedadesPnlDatosAdicionales
	 * 		   Metodo set del atributo propiedadesPnlDatosAdicionales
	 * @param  pPropiedadesPnlDatosAdicionales
	 *		   Valor que tomara el atributo propiedadesPnlDatosAdicionales
	 * @author hector.cuenca
	 * @date   2/12/2016
	 */
	public void setPropiedadesPnlDatosAdicionales(
			PropiedadesPnlDatosAdicionales pPropiedadesPnlDatosAdicionales) {
		this.propiedadesPnlDatosAdicionales = pPropiedadesPnlDatosAdicionales;
	}

	/**
	 * @method getFormaPadre
	 * 		   Metodo get del atributo formaPadre
	 * @return FormaGenerica
	 *		   Valor del atributo formaPadre devuelto
	 * @author hector.cuenca
	 * @date   2/12/2016
	 */
	public FormaGenerica getFormaPadre() {
		return this.formaPadre;
	}

	/**
	 * @method setFormaPadre
	 * 		   Metodo set del atributo formaPadre
	 * @param  pFormaPadre
	 *		   Valor que tomara el atributo formaPadre
	 * @author hector.cuenca
	 * @date   2/12/2016
	 */
	public void setFormaPadre(FormaGenerica pFormaPadre) {
		this.formaPadre = pFormaPadre;
	}

	/**
	 * @method getEvaFrmPnlDatosAdicionales
	 * 		   Metodo get del atributo evaFrmPnlDatosAdicionales
	 * @return EventoFormaPanelDatosAdicionales
	 *		   Valor del atributo evaFrmPnlDatosAdicionales devuelto
	 * @author hector.cuenca
	 * @date   2/12/2016
	 */
	public EventoFormaPanelDatosAdicionales getEvaFrmPnlDatosAdicionales() {
		return this.evaFrmPnlDatosAdicionales;
	}

	/**
	 * @method setEvaFrmPnlDatosAdicionales
	 * 		   Metodo set del atributo evaFrmPnlDatosAdicionales
	 * @param  pEvaFrmPnlDatosAdicionales
	 *		   Valor que tomara el atributo evaFrmPnlDatosAdicionales
	 * @author hector.cuenca
	 * @date   2/12/2016
	 */
	public void setEvaFrmPnlDatosAdicionales(
			EventoFormaPanelDatosAdicionales pEvaFrmPnlDatosAdicionales) {
		this.evaFrmPnlDatosAdicionales = pEvaFrmPnlDatosAdicionales;
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
		
		try{
			
			TestPruebasInternas.getInstance().iniciarPruebaInterna(null,true, EnumDesplegarFormaConEventos.NO);
			
			JPanel panelContenido = new JPanel ();
			panelContenido.setLayout(null);
			JDialog dialogo = new JDialog();
			
			dialogo.setBounds(0, 0, 900, 500);
			
			FormaPanelDatosAdicionales forma;
			
			//15,70,320,140
			
			forma = new FormaPanelDatosAdicionales(null,
												   EnumDimensionesComponentes.SCP_PNL_DAT_ADI_GRILLA_DATOS_ADICIONALES,
												  null,
												  "forma");
			
			panelContenido.add(forma);
			
			dialogo.add(panelContenido);
			
			dialogo.setVisible(true);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
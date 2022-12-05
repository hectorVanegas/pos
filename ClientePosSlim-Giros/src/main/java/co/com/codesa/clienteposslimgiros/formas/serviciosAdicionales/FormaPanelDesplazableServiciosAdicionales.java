package co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.Border;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.serviciosAdicionales.EnumServiciosAdicionales;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.eventos.serviciosAdicionales.EventoFormaPanelDesplazableServiciosAdicionales;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelDesplazableGenerico;
import co.com.codesa.clienteposslimgiros.interfaces.serviciosAdicionales.IOperacionesContenedorServiciosAdicionales;
import co.com.codesa.clienteposslimgiros.interfaces.serviciosAdicionales.claveSeguridad.IOperacionesClaveSeguridad;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

/** 
 * ********************************************************************
 * @class  FormaPanelDesplazableServiciosAdicionales
 *		   Clase forma, que representa una seccion desplazable comun y 
 *		   describe los aspectos graficos correspondientes a un 
 *		   componente que permite gestionar, alojar y/o contener 
 *		   servicios adicionales de interes para una operacion en 
 *		   particular 
 * @author hector.cuenca
 * @date   7/03/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class FormaPanelDesplazableServiciosAdicionales extends FormaPanelDesplazableGenerico{

	/**
	 * @variable serialVersionUID
	 * 			 Serial de identificacion de clase
	 */
	private static final long serialVersionUID = -7734858279144273094L;
	
	/**
	 * @variable pnlContenedorServiciosAdicionales
	 * 			 Seccion que describe el contenedor de servicios adicionales
	 * 			 en el cual se alojaran y dispondran los diferentes tipos de
	 * 			 servicios que se pueden incluir
	 */
	private SeccionUtil pnlContenedorServiciosAdicionales;
	
	/**
	 * @variable operaciones
	 * 			 conjunto de operaciones disponibles a traves del contenedor 
	 * 			 que gestiona los servicios adicionales
	 */
	private IOperacionesContenedorServiciosAdicionales operaciones;
	
	/** 
	 * ********************************************************************
	 * @method FormaPanelDesplazableServiciosAdicionales
	 * 		   Constructor que ejecuta la inicializacion de valores y 
	 * 		   ejecucion de comportamientos inicales requeridos para
	 *         el despliegue de la seccion desplazable general
	 * @param  pFrmGnrVentana
	 * 		   Representa a la funcionalidad que integra la posible inclusion 
	 * 		   de servicios adicionales
	 * @param  pEnmDimension
	 * 		   Especificaciones de dimension que tendra el contenedor de 
	 * 		   servicios adicionales
	 * @param  pIntCantColumnas
	 * 		   Cantidad de columnas en las que se organizaran las diferentes 
	 * 		   secciones adicionadas 
	 * @param  pStrNombreComponente
	 * 		   Nombre tecnico con el cual se identifica el contenedor de 
	 * 		   servicios adicionales 
	 * @param  pBorde
	 * 		   Especificacion del tipo de borde que tendra el contenedor de
	 * 		   servicios adicionales 
	 * @param  pIntJustificacionTitulo
	 * 		   Tipo de Justificacion para el titulo que tendra el contenedor 
	 * 		   de servicios adicionales, aplica solo en caso de recibir un 
	 * 		   titulo para la seccion
	 * @param  pEnmEtiNombre
	 * 		   Constante de enumeracion que representa la etiqueta o nombre
	 * 		   que recibira el contenedor de servicios adicionales
	 * @param  pArrStrParametrosNombre
	 * 		   Posibles parametros requeridos por la etiqueta que 
	 * 		   referencia el nombre del contenedor de servicios adicionales
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author hector.cuenca
	 * @date   7/03/2016
	 * *********************************************************************
	 */
	public FormaPanelDesplazableServiciosAdicionales(FormaGenerica pFrmGnrVentana,
													 EnumDimensionesComponentes pEnmDimension,
													 int pIntCantColumnas,
							   		   				 String pStrNombreComponente,
							   		   				 Border pBorde,
							   		   				 Integer pIntJustificacionTitulo,
							   		   				 EnumEtiquetas pEnmEtiNombre,
							   		   				 String ...pArrStrParametrosNombre) throws Exception {
		
		super(pFrmGnrVentana,
			  pEnmDimension,
			  pStrNombreComponente,
			  pBorde,
			  pIntJustificacionTitulo,
			  pEnmEtiNombre,
			  pArrStrParametrosNombre);
		
		super.setEvaControlEventos(new EventoFormaPanelDesplazableServiciosAdicionales(this,
																					   pIntCantColumnas));
		this.setOperaciones(super.getEvaControlEventos()); 
		
		super.iniciar();
	}
	
	@Override
	protected void inicializarSeccionDesplazable()throws Exception{
		
		this.setViewportView(this.iniciarPropPnlContenedorServiciosAdicionales());
	}

	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropPnlContenedorServiciosAdicionales 
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pnlContenedorServiciosAdicionales
  	 * @return SeccionUtil
  	 * 		   seccion gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor  hector.cuenca
  	 * @date   9/03/2016
  	 * ****************************************************************
  	 */
	public SeccionUtil iniciarPropPnlContenedorServiciosAdicionales()throws Exception{
		
		if(this.pnlContenedorServiciosAdicionales==null){
			
			this.pnlContenedorServiciosAdicionales = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_CSA_CONTENEDOR, 
																								 "pnlContenedorServiciosAdicionales", 
																								 BorderFactory.createEmptyBorder(), 
																								 null, 
																								 null);
		}
		
		return this.pnlContenedorServiciosAdicionales;
		
	}
	
	/**
	 * @method getPnlContenedorServiciosAdicionales
	 * 		   Metodo get del atributo pnlContenedorServiciosAdicionales
	 * @return SeccionUtil
	 *		   Valor del atributo pnlContenedorServiciosAdicionales devuelto
	 * @author hector.cuenca
	 * @date   18/03/2016
	 */
	public SeccionUtil getPnlContenedorServiciosAdicionales() {
		return pnlContenedorServiciosAdicionales;
	}

	/**
	 * @method setPnlContenedorServiciosAdicionales
	 * 		   Metodo set del atributo pnlContenedorServiciosAdicionales
	 * @param  pPnlContenedorServiciosAdicionales
	 *		   Valor que tomara el atributo pnlContenedorServiciosAdicionales
	 * @author hector.cuenca
	 * @date   18/03/2016
	 */
	public void setPnlContenedorServiciosAdicionales(
			SeccionUtil pPnlContenedorServiciosAdicionales) {
		this.pnlContenedorServiciosAdicionales = pPnlContenedorServiciosAdicionales;
	}

	/**
	 * @method getOperaciones
	 * 		   Metodo get del atributo operaciones
	 * @return IOperacionesContenedorServiciosAdicionales
	 *		   Valor del atributo operaciones devuelto
	 * @author hector.cuenca
	 * @date   18/03/2016
	 */
	public IOperacionesContenedorServiciosAdicionales getOperaciones() {
		return operaciones;
	}

	/**
	 * @method setOperaciones
	 * 		   Metodo set del atributo operaciones
	 * @param  pOperaciones
	 *		   Valor que tomara el atributo operaciones
	 * @author hector.cuenca
	 * @date   18/03/2016
	 */
	public void setOperaciones(EventoAbstracto pOperaciones) {
		this.operaciones = (IOperacionesContenedorServiciosAdicionales)pOperaciones;
	}
	
	/** 
	 * ********************************************************************
	 * @method main
	 * 		   Metodo principal para ejecucion de pruebas internas
	 * @param  args
	 * 		   Argumentos requeridos por el metodo principal
	 * @author hector.cuenca
	 * @date   4/03/2016
	 * *********************************************************************
	 */
	public static void main(String args[]){
		
		@SuppressWarnings("unused")
		IOperacionesClaveSeguridad operacionesClaveSeguridad;
		
		try {
			
			//TestPruebasInternas.getInstance().iniciarPruebaInterna(null,true, EnumDesplegarFormaConEventos.NO);
			
			JPanel panelContenido = new JPanel ();
			panelContenido.setLayout(null);
			JDialog dialogo = new JDialog();
			
			dialogo.setBounds(0, 0, 900, 500);
			
			FormaPanelDesplazableServiciosAdicionales frmScpServiciosAdicionales;
			
			frmScpServiciosAdicionales = new FormaPanelDesplazableServiciosAdicionales(null,
																					   EnumDimensionesComponentes.SCP_MVC_SERVICIOS_ADICIONALES,
																					   3,
												  									   "frmScpServiciosAdicionales",
												  									   null,
												  									   null,
												  									   EnumEtiquetas.TTL_SRV_ADI_SCP_SERVICIOS_ADICIONALES);
			
			//forma.setBorder(BorderFactory.createEtchedBorder());
			
			panelContenido.add(frmScpServiciosAdicionales);
			
			dialogo.add(panelContenido);
			
			operacionesClaveSeguridad = frmScpServiciosAdicionales.getOperaciones().adicionarServicio(EnumServiciosAdicionales.CLAVE_SEGURIDAD, 
																		  "pnlClaveSeguridad");
			
			frmScpServiciosAdicionales.getOperaciones().adicionarServicio(EnumServiciosAdicionales.CLAVE_SEGURIDAD, 
					  "pnlClaveSeguridad2");
			
			frmScpServiciosAdicionales.getOperaciones().adicionarServicio(EnumServiciosAdicionales.CLAVE_SEGURIDAD, 
					  "pnlClaveSeguridad3");
			
			frmScpServiciosAdicionales.getOperaciones().adicionarServicio(EnumServiciosAdicionales.CLAVE_SEGURIDAD, 
					  "pnlClaveSeguridad4");
			
			//frmScpServiciosAdicionales.getHorizontalScrollBar().repaint();
			
			dialogo.setVisible(true);
		
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

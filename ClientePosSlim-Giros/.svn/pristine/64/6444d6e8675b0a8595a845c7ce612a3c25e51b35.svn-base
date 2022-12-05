package co.com.codesa.clienteposslimgiros.eventos.serviciosAdicionales;

import java.awt.Rectangle;

import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.ServicioAdicionalDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.serviciosAdicionales.EnumServiciosAdicionales;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.FormaPanelDesplazableServiciosAdicionales;
import co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.FormaPanelServicioAdicional;
import co.com.codesa.clienteposslimgiros.interfaces.serviciosAdicionales.IOperacionesContenedorServiciosAdicionales;
import co.com.codesa.clienteposslimgiros.interfaces.serviciosAdicionales.IOperacionesServiciosAdicionales;

/**
 * ********************************************************************
 * @class  EventoFormaPanelDesplazableServiciosAdicionales
 *		   Clase encargada de controlar los eventos de la forma panel 
 *		   (seccion) desplazable, quien representa un componente que 
 *		   permite gestionar, alojar y/o contener servicios adicionales
 *		   de interes para una operacion en particular
 * @author hector.cuenca
 * @date   7/03/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class EventoFormaPanelDesplazableServiciosAdicionales extends EventoAbstracto implements IOperacionesContenedorServiciosAdicionales{
	
	/**
	 * @variable frmScpServiciosAdicionales
	 * 			 Referencia al componente del cual se estan controlando los 
  	 * 		   	 eventos
	 */
	private FormaPanelDesplazableServiciosAdicionales frmScpServiciosAdicionales;
	
	/**
	 * @variable intCantColumnas
	 * 			 Cantidad de columnas en las que se organizaran las diferentes 
	 * 			 secciones adicionadas
	 */
	private int intCantColumnas;
	
	/**
	 * @variable intColumnaPreparada
	 * 			 Numero que identifica la columna virtual sobre la cual se 
	 * 			 adicionara una nueva seccion de servicio adicional
	 */
	private int intColumnaPreparada;
	
	/**
	 * @variable intFilaPreparada
	 * 			 Numero que identifica la fila virtual sobre la cual se 
	 * 			 adicionara una nueva seccion de servicio adicional
	 */
	private int intFilaPreparada;
	
	/**
	 * @variable intCantServiciosAdicionados
	 * 			 Numero de servicios adicionales agregados al contenedor 
	 */
	private int intCantServiciosAdicionados;
	
	/**
	 * ********************************************************************
	 * @method EventoFormaPanelDesplazableServiciosAdicionales
	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de sus acciones
	 * @param  pFrmScpServiciosAdicionales
	 * 		   Referencia al componente del cual se estan controlando los 
  	 * 		   eventos
  	 * @param  pIntCantColumnas
	 * 		   Cantidad de columnas en las que se organizaran las diferentes 
	 * 		   secciones adicionadas 
	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author hector.cuenca
	 * @date   3/03/2016
	 * *********************************************************************
	 */
	public EventoFormaPanelDesplazableServiciosAdicionales(FormaPanelDesplazableServiciosAdicionales pFrmScpServiciosAdicionales,
														   int pIntCantColumnas) throws Exception{
		
		super(pFrmScpServiciosAdicionales.getFrmGnrPadre());
		
		this.setFrmScpServiciosAdicionales(pFrmScpServiciosAdicionales);
		this.setIntCantColumnas(pIntCantColumnas);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T extends IOperacionesServiciosAdicionales<? extends ServicioAdicionalDTO>> T adicionarServicio(EnumServiciosAdicionales pEnmServicioAdicional,
																											String pStrNombreComponente)throws Exception{
		
		FormaPanelServicioAdicional<?> objFrmPnlServicioAdicional;
		
		objFrmPnlServicioAdicional = pEnmServicioAdicional.crearFormaPanelServicioAdicional(super.getFrmForma(), 
															   								pStrNombreComponente);
		
		this.calcularPosicion(objFrmPnlServicioAdicional);
		this.setIntCantServiciosAdicionados(this.getIntCantServiciosAdicionados()+1);
		this.redefinirDimensionContenedor(objFrmPnlServicioAdicional.getBounds());
		
		this.getFrmScpServiciosAdicionales().getPnlContenedorServiciosAdicionales().add(objFrmPnlServicioAdicional);
		
		this.prepararSiguientePosicion();
		
		return (T) objFrmPnlServicioAdicional.getOperaciones();
	}
	
	/** 
	 * ********************************************************************
	 * @method redefinirDimensionContenedor
	 * 		   Metodo que permite redefinir la dimension del contenedor de
	 * 		   servicios adicionales conforme se van incorporando estos
	 * 
	 * 		   Importante:
	 * 		   Este metodo solo aplica para cuando se incorpora un servicio
	 * 		   al contenedor, pero no cuando se remueve de este, en caso de
	 * 		   necesitar esto, estaria pendiente por implementar
	 * 
	 * @param  pObjRecDimensionServicioAdicional
	 * 		   Dimension calculada para el servicio adicional que se esta
	 * 		   incorporando
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author hector.cuenca
	 * @date   23/03/2016
	 * *********************************************************************
	 */
	private void redefinirDimensionContenedor(Rectangle pObjRecDimensionServicioAdicional)throws Exception{
		
		int intAnchoNetoContenedor;
		int intAltoNetoContenedor;
		int intAnchoNetoServicioAdicional;
		int intAltoNetoServicioAdicional;
		int intNuevoAnchoContenedor;
		int intNuevoAltoContenedor;
		Rectangle objRecDimensionContenedor;
		
		objRecDimensionContenedor = this.getFrmScpServiciosAdicionales().getPnlContenedorServiciosAdicionales().getBounds();
		
		intAnchoNetoContenedor = objRecDimensionContenedor.x + objRecDimensionContenedor.width;
		intAltoNetoContenedor = objRecDimensionContenedor.y + objRecDimensionContenedor.height;
		
		intAnchoNetoServicioAdicional = pObjRecDimensionServicioAdicional.x + pObjRecDimensionServicioAdicional.width;
		intAltoNetoServicioAdicional = pObjRecDimensionServicioAdicional.y + pObjRecDimensionServicioAdicional.height;
		
		if(intAnchoNetoContenedor < intAnchoNetoServicioAdicional
				|| intAltoNetoContenedor < intAltoNetoServicioAdicional){
		
			if(intAnchoNetoContenedor < intAnchoNetoServicioAdicional){
				
				intNuevoAnchoContenedor = intAnchoNetoServicioAdicional+5;
			}else{
				intNuevoAnchoContenedor = objRecDimensionContenedor.width;
			}
			
			if(intAltoNetoContenedor < intAltoNetoServicioAdicional){
				
				intNuevoAltoContenedor = intAltoNetoServicioAdicional+5;
			}else{
				intNuevoAltoContenedor = objRecDimensionContenedor.height;
			}
			
			this.getFrmScpServiciosAdicionales().getPnlContenedorServiciosAdicionales().setBounds(new Rectangle(objRecDimensionContenedor.x,
					  																							objRecDimensionContenedor.y,
					  																							intNuevoAnchoContenedor,
					  																							intNuevoAltoContenedor));
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method calcularPosicion
	 * 		   Metodo que permite calcular la posicion en la cual se ubicara 
	 * 		   el servicio adicionado
	 * @param  pObjFrmPnlServicioAdicional
	 * 		   Objeto que representa la seccion de servicio adicional a la 
	 * 		   cual se le redefinira su posicionamiento en el contenedor
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author hector.cuenca
	 * @date   23/03/2016
	 * *********************************************************************
	 */
	private void calcularPosicion(FormaPanelServicioAdicional<?> pObjFrmPnlServicioAdicional)throws Exception{
		
		Rectangle objDimension;
		int intPosX;
		int intPosY;
		
		objDimension = pObjFrmPnlServicioAdicional.getBounds();
		
		intPosX = objDimension.x + this.getIntColumnaPreparada()*(objDimension.width+5);
		intPosY = objDimension.y + this.getIntFilaPreparada()*(objDimension.height+5);
		
		pObjFrmPnlServicioAdicional.setBounds(new Rectangle(intPosX,
															intPosY,
											  				objDimension.width,
											  				objDimension.height));
	}
	
	/** 
	 * ********************************************************************
	 * @method prepararSiguientePosicion
	 * 		   Metodo que permite calcular la siguiente columna en la cual
	 * 		   se podra adicionar un nuevo servicio
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   23/03/2016
	 * *********************************************************************
	 */
	private void prepararSiguientePosicion()throws Exception{
		
		int intSiguienteColumna;
		
		intSiguienteColumna = this.getIntColumnaPreparada();
		
		intSiguienteColumna++;
		
		if(intSiguienteColumna>=this.getIntCantColumnas()){
			
			intSiguienteColumna = 0;
			this.setIntFilaPreparada(this.getIntFilaPreparada()+1);
		}
		
		this.setIntColumnaPreparada(intSiguienteColumna);
	}
	
	/**
	 * @method getFrmScpServiciosAdicionales
	 * 		   Metodo get del atributo frmScpServiciosAdicionales
	 * @return FormaPanelDesplazableServiciosAdicionales
	 *		   Valor del atributo frmScpServiciosAdicionales devuelto
	 * @author hector.cuenca
	 * @date   18/03/2016
	 */
	public FormaPanelDesplazableServiciosAdicionales getFrmScpServiciosAdicionales() {
		return frmScpServiciosAdicionales;
	}

	/**
	 * @method setFrmScpServiciosAdicionales
	 * 		   Metodo set del atributo frmScpServiciosAdicionales
	 * @param  pFrmScpServiciosAdicionales
	 *		   Valor que tomara el atributo frmScpServiciosAdicionales
	 * @author hector.cuenca
	 * @date   18/03/2016
	 */
	public void setFrmScpServiciosAdicionales(
			FormaPanelDesplazableServiciosAdicionales pFrmScpServiciosAdicionales) {
		this.frmScpServiciosAdicionales = pFrmScpServiciosAdicionales;
	}

	/**
	 * @method getIntCantColumnas
	 * 		   Metodo get del atributo intCantColumnas
	 * @return int
	 *		   Valor del atributo intCantColumnas devuelto
	 * @author hector.cuenca
	 * @date   23/03/2016
	 */
	public int getIntCantColumnas() {
		
		if(this.intCantColumnas <=0){
			this.intCantColumnas = 1;
		}
		
		return intCantColumnas;
	}

	/**
	 * @method setIntCantColumnas
	 * 		   Metodo set del atributo intCantColumnas
	 * @param  pIntCantColumnas
	 *		   Valor que tomara el atributo intCantColumnas
	 * @author hector.cuenca
	 * @date   23/03/2016
	 */
	public void setIntCantColumnas(int pIntCantColumnas) {
		this.intCantColumnas = pIntCantColumnas;
	}

	/**
	 * @method getIntCantServiciosAdicionados
	 * 		   Metodo get del atributo intCantServiciosAdicionados
	 * @return int
	 *		   Valor del atributo intCantServiciosAdicionados devuelto
	 * @author hector.cuenca
	 * @date   23/03/2016
	 */
	public int getIntCantServiciosAdicionados() {
		return intCantServiciosAdicionados;
	}

	/**
	 * @method setIntCantServiciosAdicionados
	 * 		   Metodo set del atributo intCantServiciosAdicionados
	 * @param  pIntCantServiciosAdicionados
	 *		   Valor que tomara el atributo intCantServiciosAdicionados
	 * @author hector.cuenca
	 * @date   23/03/2016
	 */
	public void setIntCantServiciosAdicionados(int pIntCantServiciosAdicionados) {
		this.intCantServiciosAdicionados = pIntCantServiciosAdicionados;
	}

	/**
	 * @method getIntColumnaPreparada
	 * 		   Metodo get del atributo intColumnaPreparada
	 * @return int
	 *		   Valor del atributo intColumnaPreparada devuelto
	 * @author hector.cuenca
	 * @date   23/03/2016
	 */
	public int getIntColumnaPreparada() {
		return intColumnaPreparada;
	}

	/**
	 * @method setIntColumnaPreparada
	 * 		   Metodo set del atributo intColumnaPreparada
	 * @param  pIntColumnaPreparada
	 *		   Valor que tomara el atributo intColumnaPreparada
	 * @author hector.cuenca
	 * @date   23/03/2016
	 */
	public void setIntColumnaPreparada(int pIntColumnaPreparada) {
		this.intColumnaPreparada = pIntColumnaPreparada;
	}

	/**
	 * @method getIntFilaPreparada
	 * 		   Metodo get del atributo intFilaPreparada
	 * @return int
	 *		   Valor del atributo intFilaPreparada devuelto
	 * @author hector.cuenca
	 * @date   23/03/2016
	 */
	public int getIntFilaPreparada() {
		return intFilaPreparada;
	}

	/**
	 * @method setIntFilaPreparada
	 * 		   Metodo set del atributo intFilaPreparada
	 * @param  pIntFilaPreparada
	 *		   Valor que tomara el atributo intFilaPreparada
	 * @author hector.cuenca
	 * @date   23/03/2016
	 */
	public void setIntFilaPreparada(int pIntFilaPreparada) {
		this.intFilaPreparada = pIntFilaPreparada;
	}

	

	
	
}

package co.com.codesa.clienteposslimgiros.vista.logica;

import java.util.ArrayList;
import java.util.List;

import co.com.codesa.clienteposslimgiros.vista.logica.lector2D.Lector2DVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.propiedadesPruebaAdmisionEntregaTirilla.PropiedadesPruebaAdmisionEntregaTirilla;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Propiedad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;

public class ControlConsultaTramaVistaLogica {
	
	private static ControlConsultaTramaVistaLogica instancia; 
	public static Boolean booCargueInicial = false;
	
	/**
	 * @variable lPropiedadesTransTirillas
	 * 			 Variable para almacenar el valor de la respuesta de la trama 533
	 */
 	private List<Propiedad> lstPropiedadesTransTirillas = new ArrayList<Propiedad>();
 	
 	/**
	 * @variable arrListadoServicios
	 * 			 Variable para almacenar el valor de la respuesta de la trama 561
	 */
 	private String[] arrListadoServicios = new String[3];
 	
 	/**
	 * @variable strEstadoServicio
	 * 			 Variable para almacenar el valor de la respuesta de la trama 563
	 */
 	private String strEstadoServicio;
 	
	/**
	 * ****************************************************************.
	 * @metodo: ControlConfiguracionPasiVistaLogica
	 * @descripcion: contructor de la logica.
	 * @autor: Jefferson Ruiz
	 * @date: 17/09/2019
	 * ****************************************************************
	 */
	public ControlConsultaTramaVistaLogica(){}
	
	/**
	 * ****************************************************************.
	 * @metodo: getInstance
	 * @descripcion: metodo para cumplir con el patron singleton y tener
	 * una unica instancia de la clase para se accedida.
	 * @autor: Jefferson Ruiz
	 * ****************************************************************
	 */
	public static ControlConsultaTramaVistaLogica getInstance(){		
		if (instancia == null){
			booCargueInicial = true;
			instancia= new ControlConsultaTramaVistaLogica();
		}else {
			booCargueInicial = false;
		}
			
		
		return instancia;
	}
	
	public void llenarMemoriaTramas(Usuario pobjUsuario, 
									String pstrCodigoServicio) throws Exception {
		
		//Cargue en memoria de la trama 533
		this.setPropiedadesTransTirillas(PropiedadesPruebaAdmisionEntregaTirilla.getInstance().consultarListaPropiedadTransmisionTirillas(pobjUsuario));
		
		//Cargue en memoria de la trama 561
		this.setListadoServicios(Lector2DVistaLogica.getInstance().consultarConfiguracion(pobjUsuario));
		
		//Cargue en memoria de la trama 563
		this.setEstadoServicio(ConsultarServicioPorColaboradorVistaLogica.getInstance().consultarServicio(pobjUsuario, pstrCodigoServicio));
				
	}
	
	/**
	 * @method getPropiedadesTransTirillas
	 * 		   Metodo get del atributo lstPropiedadesTransTirillas
	 * @return lstPropiedadesTransTirillas
	 *		   Valor del atributo lstPropiedadesTransTirillas devuelto
	 * @author Jefferson Ruiz
	 * @date   18/09/2019
	 */
	public List<Propiedad> getPropiedadesTransTirillas() {
		return this.lstPropiedadesTransTirillas;
	}

	/**
	 * @method setPropiedadesTransTirillas
	 * 		   Metodo set del atributo lstPropiedadesTransTirillas
	 * @param  lstPropiedadesTransTirillas
	 *		   Valor que tomara el atributo lstPropiedadesTransTirillas
	 * @author Jefferson Ruiz
	 * @date   18/09/2019
	 */
	public void setPropiedadesTransTirillas(List<Propiedad> plstPropiedadesTransTirillas) {
		this.lstPropiedadesTransTirillas = plstPropiedadesTransTirillas;
	}
	
	/**
	 * @method getEstadoServicio
	 * 		   Metodo get del atributo strEstadoServicio
	 * @return strEstadoServicio
	 *		   Valor del atributo strEstadoServicio devuelto
	 * @author Jefferson Ruiz
	 * @date   18/09/2019
	 */
	public String getEstadoServicio() {
		return this.strEstadoServicio;
	}

	/**
	 * @method setEstadoServicio
	 * 		   Metodo set del atributo strEstadoServicio
	 * @param  strEstadoServicio
	 *		   Valor que tomara el atributo strEstadoServicio
	 * @author Jefferson Ruiz
	 * @date   18/09/2019
	 */
	public void setEstadoServicio(String pstrEstadoServicio) {
		this.strEstadoServicio = pstrEstadoServicio;
	}
	
	/**
	 * @method getListadoServicios
	 * 		   Metodo get del atributo arrListadoServicios
	 * @return arrListadoServicios
	 *		   Valor del atributo arrListadoServicios devuelto
	 * @author Jefferson Ruiz
	 * @date   18/09/2019
	 */
	public String[] getListadoServicios() {
		return this.arrListadoServicios;
	}

	/**
	 * @method setListadoServicios
	 * 		   Metodo set del atributo arrListadoServicios
	 * @param  arrListadoServicios
	 *		   Valor que tomara el atributo arrListadoServicios
	 * @author Jefferson Ruiz
	 * @date   18/09/2019
	 */
	public void setListadoServicios(String[] parrListadoServicios) {
		this.arrListadoServicios = parrListadoServicios;
	}
	
	
}

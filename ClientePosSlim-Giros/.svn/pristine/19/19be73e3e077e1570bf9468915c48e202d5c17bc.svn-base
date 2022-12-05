package co.com.codesa.clienteposslimgiros.utilidades.proveedorServicioProducto;

import java.util.HashMap;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMediosPago;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.operaciones.EnumTiposOperaciones;
import co.com.codesa.clienteposslimgiros.enumeraciones.proveedorServicioProducto.EnumTiposServicios;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.bnet.ProveedorServicioProductoGirosDTO;

/** 
 * ********************************************************************
 * @class  UtilProveedorServicioProductoGiros
 *		   Clase utilitaria relacionada con la estructura de negocio
 *		   Proveedor, Servicio, producto
 * @author roberth.martinez
 * @date   27/5/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class UtilProveedorServicioProductoGiros {
	
	/**
	 * @variable hmEnmTiposServicios
	 * 			 Estructura de facil acceso para administrar las constantes de enumeracion
	 * 		   	 referentes a los tipos de servicio
	 */
	private HashMap<String, EnumTiposServicios> hmEnmTiposServicios;
	
	/**
	 * @variable instancia 
	 * 			 Referencia estatica de la clase utilitaria, clave para incorporar
	 * 			 SINGLETON (patron de diseño)
	 **/
	private static UtilProveedorServicioProductoGiros instancia;
	
	/** 
	 * ********************************************************************
	 * @method UtilProveedorServicioProductoGiros
	 * 		   Metodo constructor que permite inicializar variables y
  	 * 		   ejecutar comportamientos de interes
	 * @throws Exception
	 * 	       Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   27/5/2016
	 * *********************************************************************
	 */
	private UtilProveedorServicioProductoGiros() throws Exception{
		
		this.cargarHashEnumTiposServicios();
	}
	
	/**
  	 * ****************************************************************.
  	 * @method getInstance
  	 * 		   Metodo clave para ejecutar el patron singleton sobre la 
  	 * 		   clase, materializando esta por unica vez y manteniendo una 
  	 * 		   sola instancia de esta
  	 * @return UtilProveedorServicioProductoGiros
  	 * 		   Tipo referente a la misma clase
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @author Hector Q-en-K
  	 * ****************************************************************
  	 */
	public static UtilProveedorServicioProductoGiros getInstance()throws Exception{
		
		if (instancia == null) {
			
			instancia = new UtilProveedorServicioProductoGiros();
		}
		
		return instancia;
	}

	/**
	 * ********************************************************************
	 * @method cargarHashEnumTiposServicios
	 * 		   Metodo que permite cargar en una estructura hash las constantes
	 * 		   de enumeracion registradas en EnumTiposServicios indexandolos 
	 * 		   por su clave
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author hector.cuenca
	 * @date   19/08/2016
	 * *********************************************************************
	 */
	private void cargarHashEnumTiposServicios()throws Exception{
	
		this.hmEnmTiposServicios = new HashMap<String, EnumTiposServicios>();
		
		for	(	EnumTiposServicios enmTipoServicio	:	EnumTiposServicios.values()	){
			
			if	(	!this.hmEnmTiposServicios.containsKey(enmTipoServicio.getStrClave())	){
				
				this.hmEnmTiposServicios.put(enmTipoServicio.getStrClave(), enmTipoServicio);
			}
		}
	}
	
	/**
	 * ********************************************************************
	 * @method obtenerEnum
	 * 		   Metodo que permite obtener la constante de enumeracion 
	 * 		   EnumTiposServicios correspondiente a la clave de tipo servicio
	 * 		   recibida
	 * @param  pStrClaveTipoServicio
	 * 		   Clave que identifica al tipo de servicio
	 * @return EnumTiposServicios
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   19/08/2016
	 * *********************************************************************
	 */
	public EnumTiposServicios obtenerEnum(String pStrClaveTipoServicio)throws Exception{
		
		return this.hmEnmTiposServicios.get(pStrClaveTipoServicio);
	}
	
	private void validarAusenciaProveedorServicioProducto(ProveedorServicioProductoGirosDTO pObjDtoProveedorServicioProducto,
														  EnumTiposOperaciones pEnmTipoOperacion)throws Exception{
		
		if(pObjDtoProveedorServicioProducto == null){
			
			throw EnumMensajes.OPERACION_NO_CONFIGURADA_COMO_PROVEEDOR_SERVICIO_PRODUCTO.generarExcepcion(EnumClasesMensaje.ERROR,
																										  pEnmTipoOperacion.getEnmEtiDescripcion().toString());
		}
	}
	
	public ProveedorServicioProductoGirosDTO validarProveedorServicioProductoXTercero(Tercero pObjTercero,
			   																   		  EnumTiposServicios pEnmTipoServicio,
			   																   		  Usuario pObjUsuario,
			   																   		  EnumTiposOperaciones pEnmTipoOperacion)throws Exception{

		ProveedorServicioProductoGirosDTO objDtoProveedorServicioProducto = null;
		
		//Necesario validar que exista configurado el proveedor - servicio - producto, referente al convenio que se va a ejecutar
		if(!pObjUsuario.getLstProveedorServicioProducto().isEmpty()){
		
			objDtoProveedorServicioProducto = pObjUsuario.buscarProveedorServicioProductoXTercero(pObjTercero,
											  													  pEnmTipoServicio.getStrClave());
		}
		
		this.validarAusenciaProveedorServicioProducto(objDtoProveedorServicioProducto,
													  pEnmTipoOperacion);
		
		return objDtoProveedorServicioProducto;
	}
	
	public ProveedorServicioProductoGirosDTO validarProveedorServicioProductoXTipoServicio(EnumTiposServicios pEnmTipoServicio,
		   		   																		   Usuario pObjUsuario,
		   		   																		   EnumTiposOperaciones pEnmTipoOperacion)throws Exception{
	
		ProveedorServicioProductoGirosDTO objDtoProveedorServicioProducto = null;
		
		//Necesario validar que exista configurado el proveedor - servicio - producto, referente al tipo de servicio que se va a ejecutar
		if(!pObjUsuario.getLstProveedorServicioProducto().isEmpty()){
			
			if	(		pEnmTipoServicio.getStrClaveNueva()	==	null
					||	pEnmTipoServicio.getStrClaveNueva().trim().isEmpty()
					||	pEnmTipoServicio.getStrClaveNueva().trim().equals("*")
				)
			{
				throw EnumMensajes.VALIDAR_PARAMETRO_TIPO_SERVICIO.generarExcepcion	(	EnumClasesMensaje.ERROR,
						  																pEnmTipoOperacion.getEnmEtiDescripcion().toString(),
						  																pEnmTipoServicio.getStrNombreParametroEmpresaVentaSIMS()
						  															);
			}
			
			objDtoProveedorServicioProducto = pObjUsuario.buscarProveedorServicioProductoXTipoServicio(pEnmTipoServicio.getStrClave(),
																										pEnmTipoServicio.getStrClaveNueva());
		}
		
		this.validarAusenciaProveedorServicioProducto(objDtoProveedorServicioProducto,
													  pEnmTipoOperacion);
		
		return objDtoProveedorServicioProducto;
	}

	/**
	 * @method getHmEnmTiposServicios
	 * 		   Metodo get del atributo hmEnmTiposServicios
	 * @return HashMap<String,EnumTiposServicios>
	 *		   Valor del atributo hmEnmTiposServicios devuelto
	 * @author hector.cuenca
	 * @date   19/08/2016
	 */
	public HashMap<String, EnumTiposServicios> getHmEnmTiposServicios() {
		return hmEnmTiposServicios;
	}

	/**
	 * @method setHmEnmTiposServicios
	 * 		   Metodo set del atributo hmEnmTiposServicios
	 * @param  pHmEnmTiposServicios
	 *		   Valor que tomara el atributo hmEnmTiposServicios
	 * @author hector.cuenca
	 * @date   19/08/2016
	 */
	public void setHmEnmTiposServicios(HashMap<String, EnumTiposServicios> pHmEnmTiposServicios) {
		this.hmEnmTiposServicios = pHmEnmTiposServicios;
	}
	
}

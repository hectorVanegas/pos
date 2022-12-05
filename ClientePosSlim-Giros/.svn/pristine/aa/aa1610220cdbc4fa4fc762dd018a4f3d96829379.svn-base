package co.com.codesa.clienteposslimgiros.utilidades.productos;

import java.util.Arrays;
import java.util.List;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumProductos;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.codesawrapper.modelo.dominio.ParametroSistema;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Producto;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 14-abr-2015
 * @Clase UtilProductos 
 * 		  Clase utilitaria relacionada con el objeto de negocio 
 * 		  producto 
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class UtilProductos {
	
	/**
  	 * ****************************************************************.
  	 * @metodo isProductoTipoEnum
  	 * 		   Valida si el producto ingresado coincide con alguno de 
  	 * 		   los objetos producto que presenta el listado de enumeracion  
  	 * @param pObjProductoValidar
  	 * 		  Objeto producto a validar sobre el listado de enumeracion
  	 * @param pArrEnmProductos
  	 * 		  Listado de enumeradores de productos sobre el cual se 
  	 * 		  realizara la validacion  
  	 * @return boolean
  	 * 		   Retorna una bandera que identifica si el producto ingresado
  	 * 		   se encuentra referenciado por alguno de los enumeradores [true],
  	 * 		   en caso contrario [false]
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 		  
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public static boolean isProductoTipoEnum(Producto pObjProductoValidar,
											 EnumProductos ... pArrEnmProductos)throws Exception{
		boolean booResultado = false;
		
		if(pObjProductoValidar != null
				&& pArrEnmProductos != null){
			
			for(EnumProductos objEnmProducto : pArrEnmProductos){
				
				if(pObjProductoValidar.equals(objEnmProducto.getObjProducto())){
					
					booResultado = true;
					break;
				}
			}
		}
		
		return booResultado;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo procesarProductosUsuario
  	 * 		   Procesa el listado de productos recibidos del usuario,
  	 * 		   posterior al proceso de autenticacion (idealmente), para 
  	 * 		   buscar y referenciar por cada producto del usuario
  	 * 		   la constante de enumeracion de producto especifica que
  	 * 		   coincida segun la configuracion que presente esta
  	 * @param pLstProductos
  	 * 		  Listado de productos del usuario
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 		  
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public static void procesarProductosUsuario(List<Producto> pLstProductos)throws Exception{
		
		List<EnumProductos> lstEnmProductos;
		ParametroSistema objParametroSistema;
		EnumProductos enmProductoEncontrado;
		EnumParametrosSistema enmParametroSistema;
		String strValorBusqueda;
		boolean booTipoBusqueda;
		
		lstEnmProductos = Arrays.asList(EnumProductos.values());
		
		//lstEnmMediosPago = Arrays.asList(EnumMediosPago.values().clone());
		//lstEnmMediosPago.remove(EnumMediosPago.MEDIO_PAGO_X_DEFECTO);
		//lstEnmMediosPago.remove(EnumMediosPago.MEDIO_PAGO_TARJETA);
		
		for(Producto objProducto : pLstProductos){
			
			if(objProducto.getCodigo() != null){
				booTipoBusqueda = true;
			}else if(objProducto.getId() != null){
				booTipoBusqueda = false;
			}else{
				continue;
			}
			
			enmProductoEncontrado = null;
			
			for(EnumProductos enmProducto : lstEnmProductos){
				
				if(enmProducto.getObjValorBusqueda() != null
						&& enmProducto.getBooTipoBusqueda() == booTipoBusqueda){
					
					if(enmProducto.getObjValorBusqueda() instanceof EnumParametrosSistema){
						
						enmParametroSistema = (EnumParametrosSistema)enmProducto.getObjValorBusqueda(); 
						objParametroSistema = UtilParametrosSistema.getInstance().consultar(enmParametroSistema);
						strValorBusqueda = objParametroSistema.getValor();
						
					}else{
						
						strValorBusqueda = enmProducto.getObjValorBusqueda().toString();
					}
					
					if(enmProducto.getBooTipoBusqueda()){//por codigo
						
						if(objProducto.getCodigo().equals(strValorBusqueda)){
							
							enmProductoEncontrado = enmProducto;
						}
						
					}else{//por id
						
						if(objProducto.getId().equals(strValorBusqueda)){
							
							enmProductoEncontrado = enmProducto;
						}
					}
					
					if(enmProductoEncontrado != null){
						
						enmProducto.setObjProducto(objProducto);
						objProducto.setStrTipoProducto(enmProducto.name());
						break;
					}
				}
			}
			
			//if(enmMedioPagoEncontrado != null){
				
				//lstEnmMediosPago.remove(enmMedioPagoEncontrado);
			//}
		}
	}
	
}

package co.com.codesa.clienteposslimgiros.utilidades.objetos;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;

/** 
 * ********************************************************************
 * @class  UtilObjeto
 *		   Clase utilitaria que representa a todos los objetos y agrupa
 *		   el conjunto de utilidades relacionadas con los objetos del
 *		   sistema
 * @param  <T> 
 * 		   Representacion generica de objetos
 * @author hector.cuenca
 * @date   12/03/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class UtilObjeto<T> {

	/**
	 * @variable genObjeto
	 * 			 Representa al objeto generico que se esta procesando
	 */
	private final T genObjeto;
	
	/**
	 * @variable enmEtiNombreObj
	 * 			 Constante de enumeracion que representa el nombre funcional 
	 * 			 del objeto que se esta procesando  
	 */
	private final EnumEtiquetas enmEtiNombreObj;
	
	/**
	 * @variable arrStrParametrosNombreObj
	 * 			 Conjunto de posibles parametros que pueda llegar a presentar
	 * 			 el nombre del objeto que se esta procesando 
	 */
	private final String[] arrStrParametrosNombreObj;
	
	/** 
	 * ********************************************************************
	 * @method UtilObjeto
	 * 		   Metodo constructor que se encarga de inicializar los atributos
	 * 		   y comportamientos necesarios para disponer de las operaciones
	 * 		   y utilidades que presenta
	 * @param  pGenObjeto
	 * 		   Representa al objeto generico que se esta procesando
	 * @param  pEnmEtiNombreObj
	 * 		   Constante de enumeracion que representa el nombre funcional 
	 * 		   del objeto que se esta procesando  
	 * @param  pArrStrParametrosNombreObj
	 * 		   Conjunto de posibles parametros que pueda llegar a presentar
	 * 		   el nombre del objeto que se esta procesando 
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   12/03/2016
	 * *********************************************************************
	 */
	public UtilObjeto(T pGenObjeto,
				  EnumEtiquetas pEnmEtiNombreObj,
				  String ...pArrStrParametrosNombreObj)throws Exception{
		
		this.genObjeto = pGenObjeto;
		this.enmEtiNombreObj = pEnmEtiNombreObj;
		this.arrStrParametrosNombreObj = pArrStrParametrosNombreObj;
	}
	
	/** 
	 * ********************************************************************
	 * @method requeridoParaProceso
	 * 		   Metodo que permite validar la obligatoriedad del objeto 
	 * 		   representado, para el proceso en cuestion
	 * @param  pEnmEtiNombreProceso
	 * 		   Constante de enumeracion que representa el nombre del proceso
	 * @param  pArrStrParametrosNombreProceso
	 * 		   Conjunto de posibles parametros que pueda llegar a presentar
	 * 		   el nombre del proceso objeto que se esta llevando a cabo 
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   12/03/2016
	 * *********************************************************************
	 */
	public void requeridoParaProceso(EnumEtiquetas pEnmEtiNombreProceso,
								  	 String ...pArrStrParametrosNombreProceso)throws Exception{
		
		String strNombreProceso;
		String strNombreObjeto;
		
		if(this.getGenObjeto()==null){
			
			strNombreProceso = pEnmEtiNombreProceso.getValor(false, pArrStrParametrosNombreProceso);
			strNombreObjeto = this.getEnmEtiNombreObj().getValor(false, this.getArrStrParametrosNombreObj());
			
			throw EnumMensajes.SE_REQUIERE_OBTENER_INFORMACION_PREVIA_PARA_EJECUTAR_PROCESO.generarExcepcion(EnumClasesMensaje.ERROR, 
																											 strNombreProceso,
																											 strNombreObjeto);
		}
	}

	/**
	 * @method getGenObjeto
	 * 		   Metodo get del atributo genObjeto
	 * @return T
	 *		   Valor del atributo genObjeto devuelto
	 * @author hector.cuenca
	 * @date   12/03/2016
	 */
	public T getGenObjeto() {
		return genObjeto;
	}

	/**
	 * @method getEnmEtiNombreObj
	 * 		   Metodo get del atributo enmEtiNombreObj
	 * @return EnumEtiquetas
	 *		   Valor del atributo enmEtiNombreObj devuelto
	 * @author hector.cuenca
	 * @date   12/03/2016
	 */
	public EnumEtiquetas getEnmEtiNombreObj() {
		return enmEtiNombreObj;
	}

	/**
	 * @method getArrStrParametrosNombreObj
	 * 		   Metodo get del atributo arrStrParametrosNombreObj
	 * @return String []
	 *		   Valor del atributo arrStrParametrosNombreObj devuelto
	 * @author hector.cuenca
	 * @date   12/03/2016
	 */
	public String[] getArrStrParametrosNombreObj() {
		return arrStrParametrosNombreObj;
	}

	/** 
	 * ********************************************************************
	 * @method main
	 * 		   Metodo principal utilizado para pruebas
	 * @param  args
	 * 		   Argumentos exigidos por el metodo principal
	 * @author hector.cuenca
	 * @date   12/03/2016
	 * *********************************************************************
	 */
	/*public static void main(String args[]){
		
		Factura objFactura;
		
		try{
			
			objFactura = null;
			
			new UtilObjeto<Factura>(objFactura,
									EnumEtiquetas.NMB_OBJ_NEG_FACTURA).requeridoParaProceso(EnumProcesos.CLAVE_SEGURIDAD);
			
			System.out.println("paso bien");
			
		}catch(Exception e){
			UtilidadesGiros.getInstance().controlExcepcion(e, 
														   null);
			e.printStackTrace();
		}
		
	}*/
	
}

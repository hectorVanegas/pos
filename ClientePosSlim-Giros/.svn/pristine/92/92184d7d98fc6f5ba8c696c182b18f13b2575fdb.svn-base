package co.com.codesa.clienteposslimgiros.utilidades.reimpresiones;

import java.util.ArrayList;
import java.util.List;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumReimpresiones;
import co.com.codesa.clienteposslimgiros.enumeraciones.impresion.EnumTiposImpresion;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGiros;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Modulo;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 14-abr-2015
 * @Clase UtilReimpresiones 
 * 		  Clase utilitaria relacionada con el objeto de negocio 
 * 		  producto 
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class UtilReimpresiones {
	
	private List<EnumReimpresiones> lstEnmReimpresionesXPin;
	private List<EnumReimpresiones> lstEnmReimpresionesXUltimaTransaccion;
	/**
	 * @variable	lstEnmReimpresionesOtras
	 * 				listado de reimpresiones otras
	 */
	private List<EnumReimpresiones> lstEnmReimpresionesOtras;
	
	/**
	 * @variable instancia 
	 * 			 Referencia estatica de la clase utilitaria, clave para incorporar
	 * 			 SINGLETON (patron de diseño)
	 **/
	private static UtilReimpresiones instancia;
	
	/**
  	 * ****************************************************************.
  	 * @metodo UtilReimpresiones
  	 * 		   Metodo constructor que permite inicializar variables y
  	 * 		   ejecutar comportamientos de interes
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private UtilReimpresiones(){}
	
	/**
  	 * ****************************************************************.
  	 * @metodo getInstance
  	 * 		   Metodo clave para ejecutar el patron singleton sobre la 
  	 * 		   clase, materializando esta por unica vez y manteniendo una 
  	 * 		   sola instancia de esta
  	 * @return UtilReimpresiones
  	 * 		   Tipo referente a la misma clase
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public static UtilReimpresiones getInstance(){
		
		if (instancia == null){
			
			instancia= new UtilReimpresiones();
		}
			
		return instancia;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo clasificarTiposReimpresion
  	 * 		   Permite clasificar segun las configuraciones almacenadas 
  	 * 		   sobre el enumerador, el listado de reimpresiones x pin y
  	 * 		   el listado de reimpresiones por ultima transaccion, que 
  	 * 		   estaran disponibles para ejecutar sobre la funcionalidad  
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 		  
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void clasificarTiposReimpresion()throws Exception{
		
		List<Modulo> lstOpcionesPermitidas = InformacionSessionGiros.getInstance().getObjUsuario().getModulos();
		
		this.lstEnmReimpresionesXPin = new ArrayList<EnumReimpresiones>();
		this.lstEnmReimpresionesXUltimaTransaccion = new ArrayList<EnumReimpresiones>();
		this.lstEnmReimpresionesOtras = new ArrayList<EnumReimpresiones>();
		
		for(EnumReimpresiones enmReimpresion : EnumReimpresiones.values()){
			
			if(enmReimpresion.getStrCodigo() != null 
					&& enmReimpresion.getEnmEtiNombre() != null 
					&& enmReimpresion.getEnmImpresion() != null
					//&& enmReimpresion.getClsEntTrmEnvio() != null
					//&& enmReimpresion.getClsEntTrmRespuesta() != null
					&& enmReimpresion.getEnmTipoImpresion() != null){
				
				if(enmReimpresion.getObjOpcionMenu() == null ||
						 lstOpcionesPermitidas.contains(enmReimpresion.getObjOpcionMenu())){
				
					if(enmReimpresion.getEnmTipoImpresion().equals(EnumTiposImpresion.POR_PIN)){//.getObjBooTipo().equals(EnumReimpresiones.TIPO_REIMPRESION_X_PIN)){
						
						this.lstEnmReimpresionesXPin.add(enmReimpresion);
						
					}else if(enmReimpresion.getEnmTipoImpresion().equals(EnumTiposImpresion.ULTIMA_TRANSACCION)){//.getObjBooTipo().equals(EnumReimpresiones.TIPO_REIMPRESION_ULTIMA_TRANSACCION)){
						
						this.lstEnmReimpresionesXUltimaTransaccion.add(enmReimpresion);
						
					}else if(enmReimpresion.getEnmTipoImpresion().equals(EnumTiposImpresion.OTROS)){
						
						this.lstEnmReimpresionesOtras.add(enmReimpresion);
					}
				}
			}
		}
	}

	public List<EnumReimpresiones> getLstEnmReimpresionesXPin() throws Exception {
		
		if(this.lstEnmReimpresionesXPin == null){
			
			this.clasificarTiposReimpresion();
		}
		
		return this.lstEnmReimpresionesXPin;
	}

	public void setLstEnmReimpresionesXPin(
			List<EnumReimpresiones> lstEnmReimpresionesXPin) {
		this.lstEnmReimpresionesXPin = lstEnmReimpresionesXPin;
	}

	public List<EnumReimpresiones> getLstEnmReimpresionesXUltimaTransaccion() throws Exception{
		
		if(this.lstEnmReimpresionesXUltimaTransaccion == null){
			
			this.clasificarTiposReimpresion();
		}
		
		return this.lstEnmReimpresionesXUltimaTransaccion;
	}

	public void setLstEnmReimpresionesXUltimaTransaccion(
			List<EnumReimpresiones> lstEnmReimpresionesXUltimaTransaccion) {
		this.lstEnmReimpresionesXUltimaTransaccion = lstEnmReimpresionesXUltimaTransaccion;
	}

	/**
	 * @method	getLstEnmReimpresionesOtras
	 * 		  	Metodo get del atributo lstEnmReimpresionesOtras
	 * @return	List<EnumReimpresiones>
	 *		  	Valor del atributo lstEnmReimpresionesOtras devuelto
	 * @author	roberth.martinez
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada 
	 * @date  	2/11/2018
	 */
	public List<EnumReimpresiones> getLstEnmReimpresionesOtras() throws Exception {

		if(this.lstEnmReimpresionesOtras == null){
			
			this.clasificarTiposReimpresion();
		}
		return this.lstEnmReimpresionesOtras;
	}

	/**
	 * @method	setLstEnmReimpresionesOtras
	 * 		  	Metodo set del atributo lstEnmReimpresionesOtras
	 * @param	pLstEnmReimpresionesOtras
	 * 			Valor que tomara el atributo lstEnmReimpresionesOtras
	 * @author	roberth.martinez
	 * @date	2/11/2018
	 */
	public void setLstEnmReimpresionesOtras(
			List<EnumReimpresiones> pLstEnmReimpresionesOtras) {
		this.lstEnmReimpresionesOtras = pLstEnmReimpresionesOtras;
	}
}

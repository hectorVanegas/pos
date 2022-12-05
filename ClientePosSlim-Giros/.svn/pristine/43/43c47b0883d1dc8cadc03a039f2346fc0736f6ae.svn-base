package co.com.codesa.clienteposslimgiros.utilidades.mediosPago;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMediosPago;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Factura;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.MedioPago;
import co.com.codesa.codesawrapper.modelo.dominio.ParametroSistema;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 14-abr-2015
 * @Clase UtilMediosPago 
 * 		  Clase utilitaria relacionada con el objeto de negocio 
 * 		  medioPago 
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class UtilMediosPago {
	
	/**
	 * @variable hmEnmMediosPago 
	 * 			 Estructura de facil acceso para administrar las constantes de enumeracion
	 * 		   	 referentes a medios de pago
	 **/
	private HashMap<String, EnumMediosPago> hmEnmMediosPago;
	
	/**
	 * @variable strLLaveHashXCodigo 
	 * 			 LLave construida en base al codigo del medio de pago con la cual se adicionara 
	 * 			 una constante de enumeracion sobre la estructura de facil acceso para 
	 * 			 administracion (hash)
	 **/
	private String strLLaveHashXCodigo;
	
	/**
	 * @variable strLLaveHashXID 
	 * 			 LLave construida en base al ID del medio de pago con la cual se adicionara 
	 * 			 una constante de enumeracion sobre la estructura de facil acceso para 
	 * 			 administracion (hash)
	 **/
	private String strLLaveHashXID;
	
	/**
	 * @variable instancia 
	 * 			 Referencia estatica de la clase utilitaria, clave para incorporar
	 * 			 SINGLETON (patron de diseño)
	 **/
	private static UtilMediosPago instancia;
	
	/**
  	 * ****************************************************************.
  	 * @metodo UtilMediosPago
  	 * 		   Metodo constructor que permite inicializar variables y
  	 * 		   ejecutar comportamientos de interes
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private UtilMediosPago() throws Exception{
		
		this.cargarHashEnumMediosPago();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo getInstance
  	 * 		   Metodo clave para ejecutar el patron singleton sobre la 
  	 * 		   clase, materializando esta por unica vez y manteniendo una 
  	 * 		   sola instancia de esta
  	 * @return UtilMediosPago
  	 * 		   Tipo referente a la misma clase
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public static UtilMediosPago getInstance()throws Exception{
		
		if (instancia == null) {
			
			instancia = new UtilMediosPago();
		}
		
		return instancia;
	}
	
	private void cargarHashEnumMediosPago() throws Exception{
		
		ParametroSistema objParametroSistema;
		EnumParametrosSistema enmParametroSistema;
		String strValorBusqueda;
		String strLLaveHash;
		
		this.strLLaveHashXCodigo = "COD_";
		this.strLLaveHashXID = "ID_";
		this.hmEnmMediosPago = new HashMap<String, EnumMediosPago>();
		
		for(EnumMediosPago enmMedioPago : EnumMediosPago.values()){
			
			if(enmMedioPago.getObjValorBusqueda() != null){
				
				if(enmMedioPago.getObjValorBusqueda() instanceof EnumParametrosSistema){
					
					enmParametroSistema = (EnumParametrosSistema)enmMedioPago.getObjValorBusqueda(); 
					objParametroSistema = UtilParametrosSistema.getInstance().consultar(enmParametroSistema);
					strValorBusqueda = objParametroSistema.getValor();
					
					enmMedioPago.setObjValorBusqueda(strValorBusqueda);
					
				}else{
					
					strValorBusqueda = enmMedioPago.getObjValorBusqueda().toString();
				}
				
				if(enmMedioPago.isBooTipoBusqueda() == EnumMediosPago.VALIDA_X_CODIGO){
					
					strLLaveHash = this.strLLaveHashXCodigo;
					
				}else if(enmMedioPago.isBooTipoBusqueda() == EnumMediosPago.VALIDA_X_ID){
					
					strLLaveHash = this.strLLaveHashXID;
					
				}else{
					
					strLLaveHash = null;
				}
				
				if(strLLaveHash != null){
					
					strLLaveHash += strValorBusqueda;
					
					this.hmEnmMediosPago.put(strLLaveHash, 
											 enmMedioPago);
				}
			}
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo isMedioPagoTipoEnum
  	 * 		   Valida si el medioPago ingresado coincide con alguno de 
  	 * 		   los objetos mediosPago que presenta el listado de enumeracion  
  	 * @param pObjMedioPagoValidar
  	 * 		  Objeto medioPago a validar sobre el listado de enumeracion
  	 * @param pArrEnmMediosPago
  	 * 		  Listado de enumeradores de mediosPago sobre el cual se 
  	 * 		  realizara la validacion  
  	 * @return boolean
  	 * 		   Retorna una bandera que identifica si el medioPago ingresado
  	 * 		   se encuentra referenciado por alguno de los enumeradores [true],
  	 * 		   en caso contrario [false]
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 		  
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public boolean isMedioPagoTipoEnum(MedioPago pObjMedioPagoValidar,
											  EnumMediosPago ...pArrEnmMediosPago)throws Exception{
		boolean booResultado = false;
		
		if(pObjMedioPagoValidar != null
				&& pArrEnmMediosPago != null){
			
			for(EnumMediosPago objEnmMedioPago : pArrEnmMediosPago){
				
				if(pObjMedioPagoValidar.equals(objEnmMedioPago.getObjMedioPago())){
					
					booResultado = true;
					break;
				}
			}
		}
		
		return booResultado;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo pObjMedioPagoValidar
  	 * 		   Encuentra el enumerador asociado al medio de pago 
  	 * 		   ingresado  
  	 * @param pObjMedioPago
  	 * 		  Objeto medioPago por el cual se realizara la busqueda de
  	 * 		  la constante de enumeracion
  	 * @return EnumMediosPago
  	 * 		   Constante de enumeracion de medio de pago encontrada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 		  
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EnumMediosPago obtenerEnum(MedioPago pObjMedioPago)throws Exception{
		
		EnumMediosPago enmMedioPagoEncontrado = null;
		
		if(pObjMedioPago != null){
			
			if(pObjMedioPago.getCodigo() != null 
					|| pObjMedioPago.getId() != null){
				
				if(pObjMedioPago.getCodigo() != null){
					
					enmMedioPagoEncontrado = this.hmEnmMediosPago.get(this.strLLaveHashXCodigo+pObjMedioPago.getCodigo());
				}
				
				if(enmMedioPagoEncontrado == null &&
						pObjMedioPago.getId() != null){
					
					enmMedioPagoEncontrado = this.hmEnmMediosPago.get(this.strLLaveHashXID+pObjMedioPago.getId());
				}
			}
		}
		
		return enmMedioPagoEncontrado;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo procesarMediosPagoUsuario
  	 * 		   Procesa el listado de mediosPago recibidos del usuario,
  	 * 		   posterior al proceso de autenticacion (idealmente), para 
  	 * 		   buscar y referenciar por cada medioPago del usuario
  	 * 		   la constante de enumeracion de medioPago especifica que
  	 * 		   coincida segun la configuracion que presente esta.
  	 * 
  	 * 		   Nota: Un medio de pago no reportado por el proveedor giros
  	 * 		   que no se encuentre configurado en EnumMediosPago, no estara
  	 * 		   habilitado para el manejo del usuario (se omite del listado
  	 * 		   de medios de pago del cajero remitido a este proceso) 
  	 * @param  pLstMediosPago
  	 * 		   Listado de mediosPago del usuario
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 		  
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void procesarMediosPagoUsuario(List<MedioPago> pLstMediosPago)throws Exception{
		
		EnumMediosPago enmMedioPagoEncontrado;
		String strLLaveHash;
		List<MedioPago> lstMediosPagoNoConfigurados;
		
		lstMediosPagoNoConfigurados = new ArrayList<MedioPago>();
		
		for(MedioPago objMedioPago : pLstMediosPago){
			
			enmMedioPagoEncontrado = this.obtenerEnum(objMedioPago);
			
			if(enmMedioPagoEncontrado != null){
				
				enmMedioPagoEncontrado.setObjMedioPago(objMedioPago);
				
				if	(	enmMedioPagoEncontrado.isBooTipoBusqueda()	== EnumMediosPago.VALIDA_X_CODIGO){
					
					strLLaveHash	=	this.strLLaveHashXID+objMedioPago.getId();
					
					if	(	!this.hmEnmMediosPago.containsKey(strLLaveHash)	){
						
						this.hmEnmMediosPago.put(strLLaveHash, enmMedioPagoEncontrado);
					}
					
				}else{
					//VALIDA_X_ID
					
					strLLaveHash	=	this.strLLaveHashXCodigo+objMedioPago.getCodigo();
					
					if	(	!this.hmEnmMediosPago.containsKey(strLLaveHash)	){
						
						this.hmEnmMediosPago.put(strLLaveHash, enmMedioPagoEncontrado);
					}
				}
				
			}else{
				
				lstMediosPagoNoConfigurados.add(objMedioPago);
				continue;
			}
		}
		
		for	(MedioPago objMedioPago	:	lstMediosPagoNoConfigurados){
			
			pLstMediosPago.remove(objMedioPago);
		}
	}

	/**
	 * ********************************************************************
	 * @method gestionarMediosPagoXFactura
	 * 		   Metodo que permite gestionar el listado de medios de pago
	 * 		   para un objeto factura quien representa debe estar 
	 * 		   representando una transaccion en el sistema 
	 * @param  pObjFactura
	 * 		   objeto factura que contiene el detalle de una transaccion en
	 * 		   el sistema
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   18/8/2016
	 * *********************************************************************
	 */
	public void gestionarMediosPagoXFactura(Factura pObjFactura)throws Exception{
		
		MedioPago objMedioPago;
		EnumMediosPago enmMedioPago;
		
		if	(	pObjFactura.gestionarListMediosPago().isEmpty()	){
			
			objMedioPago	=	(MedioPago)EnumMediosPago.EFECTIVO.getObjMedioPago().clone();
			objMedioPago.setValor(pObjFactura.getTotal());
			pObjFactura.getListMediosPago().add(objMedioPago);
			
		}else{
			
			for(MedioPago objTmpMedioPago : pObjFactura.getListMediosPago()){
				
				if	(	objTmpMedioPago.getCodigo() == null	){
				
					enmMedioPago = UtilMediosPago.getInstance().obtenerEnum(objTmpMedioPago);
					objTmpMedioPago.setCodigo(enmMedioPago.getObjMedioPago().getCodigo());
				}
			}
		}
	}
	
	public HashMap<String, EnumMediosPago> getHmEnmMediosPago() {
		return hmEnmMediosPago;
	}

	public void setHmEnmMediosPago(HashMap<String, EnumMediosPago> hmEnmMediosPago) {
		this.hmEnmMediosPago = hmEnmMediosPago;
	}

	public String getStrLLaveHashXCodigo() {
		return strLLaveHashXCodigo;
	}

	public void setStrLLaveHashXCodigo(String strLLaveHashXCodigo) {
		this.strLLaveHashXCodigo = strLLaveHashXCodigo;
	}

	public String getStrLLaveHashXID() {
		return strLLaveHashXID;
	}

	public void setStrLLaveHashXID(String strLLaveHashXID) {
		this.strLLaveHashXID = strLLaveHashXID;
	}
}

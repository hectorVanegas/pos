package co.com.codesa.clienteposslimgiros.utilidades.conceptos;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMediosPago;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Concepto;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Factura;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.MedioPago;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.giros.EnumTiposIdentificadorConcepto;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 14-abr-2015
 * @Clase UtilConceptos 
 * 		  Clase utilitaria relacionada con el objeto de negocio 
 * 		  concepto
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class UtilConceptos {
	

	/**
	 * @variable instancia 
	 * 			 Referencia estatica de la clase utilitaria, clave para incorporar
	 * 			 SINGLETON (patron de diseño)
	 **/
	private static UtilConceptos instancia;
	
	/**
  	 * ****************************************************************.
  	 * @metodo UtilConceptos
  	 * 		   Metodo constructor que permite inicializar variables y
  	 * 		   ejecutar comportamientos de interes
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private UtilConceptos() throws Exception{}

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
	public static UtilConceptos getInstance()throws Exception{
		
		if (instancia == null) {
			
			instancia = new UtilConceptos();
		}
		
		return instancia;
	}
	
	/**
	 * ********************************************************************
	 * @method generarConcepto
	 * 		   Metodo que permite generar un concepto con sus atributos 
	 * 		   basicos a partir de un identificador recuperado a traves de un
	 * 		   parametro de sistema
	 * @param  pEnmParSisIdentificadorConcepto
	 * 		   Constante de enumeracion que representa al parametro de sistema
	 * 		   del cual se recuperar el valor de identificacion del concepto a 
	 * 		   generar
	 * @param  pEnmTipoIdentificador
	 * 		   Tipo con el cual se identificara el concepto, indica si el valor
	 * 		   de identificacion (valor parametro sistema), corresponde al id
	 * 		   o codigo del concepto a generar
	 * @param  pBooAfectaCaja
	 * 		   bandera para indicar si el concepto a generar afecta o no caja
	 * @return Concepto
	 * 		   Concepto generado
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   11/08/2016
	 * *********************************************************************
	 */
	public Concepto generarConcepto(EnumParametrosSistema pEnmParSisIdentificadorConcepto,
									EnumTiposIdentificadorConcepto pEnmTipoIdentificador,
									boolean pBooAfectaCaja)throws Exception{
		
		Concepto objConcepto = null;
		String strIdConcepto = null;
		String strCodigoConcepto = null;
		String strValorIdentificador;
		
		if	(
					pEnmParSisIdentificadorConcepto!=null
				&& 	pEnmTipoIdentificador!=null
			){
			
			strValorIdentificador = pEnmParSisIdentificadorConcepto.obtenerValorCadena();
			
			if	(
						strValorIdentificador!=null
					&& 	!(strValorIdentificador = strValorIdentificador.trim()).isEmpty()
				){
			
				switch (pEnmTipoIdentificador) {
				case ID:
					strIdConcepto = strValorIdentificador;
					break;

				case CODIGO:
					strCodigoConcepto =	strValorIdentificador;
					break;
				}
			
				objConcepto = new Concepto	(	
												strIdConcepto,
												strCodigoConcepto,
												pEnmParSisIdentificadorConcepto.getEnmEtiDescripcion().toString(),
												0,
												null,
												pBooAfectaCaja,
												1
											);
			}
		}
		
		return objConcepto;
	}
	
	/**
	 * ********************************************************************
	 * @method gestionarConceptoUtilidadXFactura
	 * 		   Metodo que permite gestionar el concepto de utilidad para la
	 * 		   transaccion representada por el objeto factura
	 * @param  pObjFactura
	 * 		   objeto factura que contiene el detalle de una transaccion en
	 * 		   el sistema
	 * @param  pEnmParSisCodConceptoUtilidad
	 * 		   Constante de enumeracion que representa el parametro de sistema
	 * 		   que contiene el codigo del concepto de utilidad a gestionar
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   20/08/2016
	 * *********************************************************************
	 */
	public void gestionarConceptoUtilidadXFactura	(	Factura pObjFactura,
										  				EnumParametrosSistema pEnmParSisCodConceptoUtilidad
										  			)	throws Exception{
		
		Concepto objConceptoUtilidad;
		
		objConceptoUtilidad	=	this.generarConcepto	(
															pEnmParSisCodConceptoUtilidad, 
															EnumTiposIdentificadorConcepto.CODIGO,
															Concepto.NO_AFECTA_CAJA
														);

		pObjFactura.gestionarListConceptos().add(objConceptoUtilidad);
		
	}
	
	/**
	 * ********************************************************************
	 * @method gestionarConceptosYMediosPago
	 * 		   Metodo que permite gestionar los conceptos y los medios de 
	 * 		   pago asociados a una transaccion en caso que esta carezca de
	 * 		   ellos 
	 * @param  pObjFactura
	 * 		   Objeto factura que representa una transaccion que se esta 
	 * 		   llevando a cabo
	 * @param  pEnmParSisIdentificadorConcepto
	 * 		   Constante de enumeracion que representa al parametro de sistema
	 * 		   del cual se recuperar el valor de identificacion del concepto a 
	 * 		   generar
	 * @param  pEnmTipoIdentificador
	 * 		   Tipo con el cual se identificara el concepto, indica si el valor
	 * 		   de identificacion (valor parametro sistema), corresponde al id
	 * 		   o codigo del concepto a generar
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de 
  	 * 		   excepcion presentada
	 * @author hector.cuenca
	 * @date   12/08/2016
	 * *********************************************************************
	 */
	public void gestionarConceptosYMediosPago	(	Factura pObjFactura,
													EnumParametrosSistema pEnmParSisIdentificadorConcepto,
													EnumTiposIdentificadorConcepto pEnmTipoIdentificador
												)	throws Exception{
		
		MedioPago objMedioPago;
		Concepto objConceptoRepresentativo;
		double douValorTotalTransaccion;
		
		objConceptoRepresentativo	=	UtilConceptos.getInstance().generarConcepto	(	
																						pEnmParSisIdentificadorConcepto, 
																						pEnmTipoIdentificador,
																						Concepto.AFECTA_CAJA
																					);
		pObjFactura.setObjConceptoRepresentativo(objConceptoRepresentativo);
		
		if	(	pObjFactura.gestionarListConceptos().isEmpty()	){
			
			douValorTotalTransaccion = pObjFactura.getTotal();
			objConceptoRepresentativo.setValor(douValorTotalTransaccion);
			pObjFactura.getListaConceptos().add(objConceptoRepresentativo);
			
		}else{
			
			douValorTotalTransaccion = 0;
			
			for(Concepto objConcepto : pObjFactura.getListaConceptos()){
				
				if (objConcepto.isBooAfectaCaja()) {
				
					douValorTotalTransaccion	+=	objConcepto.getValor();
				}
			}
		}
		
		if	(	pObjFactura.gestionarListMediosPago().isEmpty()	){
			
			objMedioPago	=	(MedioPago)EnumMediosPago.EFECTIVO.getObjMedioPago().clone();
			objMedioPago.setValor(douValorTotalTransaccion);
			
			pObjFactura.getListMediosPago().add(objMedioPago);
		}
	}
	
}

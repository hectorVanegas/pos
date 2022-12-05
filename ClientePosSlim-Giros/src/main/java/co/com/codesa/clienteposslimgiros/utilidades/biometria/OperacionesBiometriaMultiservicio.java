package co.com.codesa.clienteposslimgiros.utilidades.biometria;

import co.com.codesa.clienteposslimgiros.enumeraciones.peticionMultiservicio.EnumPeticionesMultiservicio;
import co.com.codesa.clientecajams.interfaces.IOperacionesBiometriaMultiservicio;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGiros;
import co.com.codesa.clienteposslimgiros.vista.logica.biometria.BiometriaVistaLogica;

/** 
 * ********************************************************************
 * @class  	OperacionesBiometriaMultiservicio
 *		   	Clase que implementa las operaciones e integracion hacia el 
 *			sistema biometria multiservicio
 * @author 	hector.cuenca
 * @date   	01/02/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class OperacionesBiometriaMultiservicio implements IOperacionesBiometriaMultiservicio
{
	/**
	 * @variable 	instancia 
	 * 				Referencia estatica de la clase utilitaria, clave para incorporar
	 * 			 	SINGLETON (patron de diseño)
	 **/
	private static OperacionesBiometriaMultiservicio instancia;
	
	/**
  	 * ****************************************************************.
  	 * @metodo OperacionesBiometriaMultiservicio
  	 * 		   Metodo constructor que permite inicializar variables y
  	 * 		   ejecutar comportamientos de interes
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private OperacionesBiometriaMultiservicio() 
			throws Exception
	{}

	/**
  	 * ****************************************************************.
  	 * @metodo getInstance
  	 * 		   Metodo clave para ejecutar el patron singleton sobre la 
  	 * 		   clase, materializando esta por unica vez y manteniendo una 
  	 * 		   sola instancia de esta
  	 * @return OperacionesBiometriaMultiservicio
  	 * 		   Tipo referente a la misma clase
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public static OperacionesBiometriaMultiservicio getInstance()throws Exception{
		
		if (instancia == null) {
			
			instancia = new OperacionesBiometriaMultiservicio();
		}
		
		return instancia;
	}
	
	@Override
	public	String	validarTercero	(String pStrPeticion)	
			throws Exception
	{
		return BiometriaVistaLogica.getInstance().realizarPeticionSistemaMultiservicio	(	InformacionSessionGiros.getInstance().getObjUsuario(),
																							EnumPeticionesMultiservicio.BMS_VALIDAR_TERCERO.getObjServicioPeticion(),
																							pStrPeticion
																						);
	}
	
	@Override
	public	String	enrolarHuella	(String pStrPeticion)	
			throws Exception
	{
		return BiometriaVistaLogica.getInstance().realizarPeticionSistemaMultiservicio	(	InformacionSessionGiros.getInstance().getObjUsuario(),
																							EnumPeticionesMultiservicio.BMS_ENROLAR_HUELLA.getObjServicioPeticion(),
																							pStrPeticion
																						);
	}
	
	@Override
	public	String	solicitarHuella	(String pStrPeticion)	
			throws Exception
	{
		return BiometriaVistaLogica.getInstance().realizarPeticionSistemaMultiservicio	(	InformacionSessionGiros.getInstance().getObjUsuario(),
																							EnumPeticionesMultiservicio.BMS_SOLICITAR_HUELLA.getObjServicioPeticion(),
																							pStrPeticion
																						);
	}
	
	@Override
	public String transmitirArchivo(String pStrPeticion) throws Exception {

		return BiometriaVistaLogica.getInstance().realizarPeticionSistemaMultiservicio	(	InformacionSessionGiros.getInstance().getObjUsuario(),
																							EnumPeticionesMultiservicio.BMS_TRANSMITIR_ARCHIVO.getObjServicioPeticion(),
																							pStrPeticion
																						);
	}
	
	
	public	String	autorizarTercero	(String pStrPeticion)	
		throws Exception
	{
		return BiometriaVistaLogica.getInstance().realizarPeticionSistemaMultiservicio	(	InformacionSessionGiros.getInstance().getObjUsuario(),
																							EnumPeticionesMultiservicio.BMS_AUTORIZAR_TERCERO.getObjServicioPeticion(),
																							pStrPeticion
																						);
	}

	
	public void imprimir(String arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
}

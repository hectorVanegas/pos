package co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumSistemas;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGiros;
import co.com.codesa.clienteposslimgiros.vista.logica.ParametroSistemaVistaLogica;
import co.com.codesa.codesawrapper.modelo.dominio.ParametroSistema;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 18-nov-2015
 * @Clase UtilParametrosSistema 
 * 		  Clase utilitaria relacionada con el objeto de negocio 
 * 		  parametro de sistema
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class UtilParametrosSistema {
	
	/**
	 * @variable hmParametrosSistema 
	 * 			 Listado de parametros del sistema consultados sobre SIMS y que
	 * 			 no son de SIEMPRE_CONSULTA, clave para mantener los valores de
	 * 			 parametros de este tipo, y no ser solicitados nuevamente al 
	 * 			 sistema SIMS, mejorando el performance de la App y del sistema
	 * 			 SIMS, al consumir menos peticiones
	 **/
	private HashMap<String,ParametroSistema> hmParametrosSistema;
	
	private Usuario objUsuario;
	
	/**
	 * @variable instancia 
	 * 			 Referencia estatica de la clase utilitaria, clave para incorporar
	 * 			 SINGLETON (patron de diseño)
	 **/
	private static UtilParametrosSistema instancia;
	
	/**
  	 * ****************************************************************.
  	 * @metodo UtilParametrosSistema
  	 * 		   Metodo constructor que permite inicializar variables y
  	 * 		   ejecutar comportamientos de interes
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private UtilParametrosSistema() throws Exception{
		
		this.hmParametrosSistema = new HashMap<String,ParametroSistema>();
		this.setObjUsuario(InformacionSessionGiros.getInstance().getObjUsuario());
		
		//this.cargaInicialParametros();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo getInstance
  	 * 		   Metodo clave para ejecutar el patron singleton sobre la 
  	 * 		   clase, materializando esta por unica vez y manteniendo una 
  	 * 		   sola instancia de esta
  	 * @return UtilParametrosSistema
  	 * 		   Tipo referente a la misma clase
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public static UtilParametrosSistema getInstance()throws Exception{
		
		if (instancia == null) {
			
			instancia = new UtilParametrosSistema();
		}
		
		return instancia;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo cargaInicialParametros
  	 * 		   Metodo que realiza la carga masiva inicial de parametros 
  	 * 		   de sistema, de aquellos que no son de SIEMPRE_CONSULTA, 
  	 * 		   realizando peticiones sucesivas, donde cada peticion se 
  	 * 		   compone de n parametros a consultar, donde n, es un valor
  	 * 		   configurado como parametro de aplicacion 
  	 * 		   (CANTIDAD_PARAMETROS_X_TRAMA_CARGA_INICIAL) 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	 public void cargaInicialParametros()throws Exception{
	        
	        List<EnumParametrosSistema> lstEnmParametrosSistema;
	        EnumParametrosSistema arrEnmParametrosSistema[];
	        EnumParametrosSistema enmParametroSistema;
	        int intCantidadParametrosXTrama;
	        
	        lstEnmParametrosSistema = new ArrayList<EnumParametrosSistema>();
	        intCantidadParametrosXTrama = Integer.parseInt(EnumParametrosApp.CANTIDAD_PARAMETROS_X_TRAMA_CARGA_INICIAL.getValorPropiedad());
	        
	        arrEnmParametrosSistema = EnumParametrosSistema.values();
	        
	        for(int i=0;i<arrEnmParametrosSistema.length;i++){
	            
	            enmParametroSistema = arrEnmParametrosSistema[i];
	            
	            if(!enmParametroSistema.isBooSiempreConsulta()
	                    //&& enmParametroSistema.obtenerValor() == null //Se omite debido a que la funcion obtenerValor, produce advertencia cuando el valor del parametro es nulo
	                    ){
	                
	                lstEnmParametrosSistema.add(enmParametroSistema);
	                System.out.println("pARAMETRO:"+enmParametroSistema.name());
	                if(lstEnmParametrosSistema.size() == intCantidadParametrosXTrama
	                        || (i+1) == arrEnmParametrosSistema.length){
	                    System.out.println("CONSULTADOS:"+lstEnmParametrosSistema);
	                    this.consultar(lstEnmParametrosSistema.toArray(new EnumParametrosSistema[lstEnmParametrosSistema.size()]));
	                    
	                    lstEnmParametrosSistema.clear();
	                }
	                
	            }
	        }
	        if(!lstEnmParametrosSistema.isEmpty()){
	            System.out.println("CONSULTADOS:"+lstEnmParametrosSistema);
	            this.consultar(lstEnmParametrosSistema.toArray(new EnumParametrosSistema[lstEnmParametrosSistema.size()]));
	            
	            lstEnmParametrosSistema.clear();
	        }
	    }
	
	/**
  	 * ****************************************************************.
  	 * @metodo consultar
  	 * 		   Metodo que permite realizar el proceso de consulta de 
  	 * 		   un solo parametro de sistema, descrito a traves de 
  	 * 		   una constante de enumeracion
  	 * @param pEnmParametroSistema
  	 * 		  Constante de enumeracion que representa el parametro de 
  	 * 		  sistema de interes a consultar
  	 * @return ParametroSistema
  	 * 		   Parametro de sistema consultado
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public ParametroSistema consultar(EnumParametrosSistema pEnmParametroSistema)throws Exception{
		
		ParametroSistema objParametroSistema;
		
		this.consultarParametros(pEnmParametroSistema);
		
		objParametroSistema = pEnmParametroSistema.obtenerObjParametro();
		
		return objParametroSistema;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo consultar
  	 * 		   Metodo que permite realizar el proceso de consulta de 
  	 * 		   un conjunto de parametros de sistema, descritos a traves
  	 * 		   de constantes de enumeracion
  	 * @param pEnmParametrosSistema
  	 * 		  Listado de constantes de enumeracion que representan los 
  	 * 		  parametros de sistema de interes a consultar
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void consultar(EnumParametrosSistema ...pEnmParametrosSistema)throws Exception{
		
		this.consultarParametros(pEnmParametrosSistema);
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo consultarParametros
  	 * 		   Metodo que permite realizar el proceso de consulta de 
  	 * 		   un conjunto de parametros de sistema, descritos a traves
  	 * 		   de constantes de enumeracion.
  	 * 
  	 * 		   Este metodo fue diseñado para centralizar el proceso
  	 * 		   de consulta de las operaciones publicas de consultar
  	 * 		   (uno o varios parametros)
  	 * @param pEnmParametrosSistema
  	 * 		  Listado de constantes de enumeracion que representan los 
  	 * 		  parametros de sistema de interes a consultar
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void consultarParametros(EnumParametrosSistema ...pEnmParametrosSistema)throws Exception{
		
		HashMap<String,ParametroSistema> hmParametrosSistema = null;
		HashMap<String,ParametroSistema> hmParametrosSistemaXSistema = null;
		List<String> lstParametrosSolicitados;
		List<String> lstParametrosSolicitadosGamble;
		List<String> lstParametrosConsultaFija;
		List<String> lstParametrosYaConsultados;
		
		lstParametrosSolicitados = new ArrayList<String>();
		lstParametrosSolicitadosGamble = new ArrayList<String>();
		lstParametrosYaConsultados = new ArrayList<String>();
		lstParametrosConsultaFija = new ArrayList<String>();
		
		this.verificarParametros(lstParametrosSolicitados,
		                         lstParametrosSolicitadosGamble,
								 lstParametrosYaConsultados,
								 lstParametrosConsultaFija,
								 pEnmParametrosSistema);
		
		if	(		!lstParametrosSolicitados.isEmpty()
				||	!lstParametrosSolicitadosGamble.isEmpty()
			)
		{
			hmParametrosSistema = new HashMap<String,ParametroSistema>();
			
			if	(	!lstParametrosSolicitados.isEmpty()	)
			{
				//Solo se consultan los parametros de sims que no hayan sido previamente consultados a nivel de sesion de App
				hmParametrosSistemaXSistema = ParametroSistemaVistaLogica.getInstance().consultarParametrosBD	(	this.getObjUsuario(),
				                                                                                             	 	lstParametrosSolicitados
																									 			);
				if	(	hmParametrosSistemaXSistema	!=	null	)
				{
					hmParametrosSistema.putAll ( hmParametrosSistemaXSistema );
				}
			}
			
			if	(	!lstParametrosSolicitadosGamble.isEmpty()	)
			{
				//Solo se consultan los parametros de gamble que no hayan sido previamente consultados a nivel de sesion de App
				hmParametrosSistemaXSistema = ParametroSistemaVistaLogica.getInstance().consultarParametrosGamble	(	this.getObjUsuario(),
				                                                                                                 	 	lstParametrosSolicitadosGamble
				                                                                                         			);
				if	(	hmParametrosSistemaXSistema	!=	null	)
				{
					hmParametrosSistema.putAll ( hmParametrosSistemaXSistema );
				}
			}
			
			if(hmParametrosSistema!=null){
				
				//se alimenta la estructura general de almacenamiento de parametros con los nuevos parametros consultados a BD
				for(ParametroSistema objParametroSistema: hmParametrosSistema.values()){
					
					//excluye aquellos parametros que estan configurados para siempre realizar la consulta
					if(!lstParametrosConsultaFija.contains(objParametroSistema.getCodigo())){
						
						this.hmParametrosSistema.put(objParametroSistema.getCodigo(), 
													 objParametroSistema);
					}
				}
			}
		}
		
		if(!lstParametrosYaConsultados.isEmpty()){//se han identificado parametros que se habian consultado con anterioridad
			
			if(hmParametrosSistema==null){
				
				//en caso que la estructura de respuesta no se haya creado por parte de la consulta de parametros en BD, se crea
				hmParametrosSistema = new HashMap<String,ParametroSistema>();
			}
			
			//se incorpora a la estructura de respuesta los parametros detectados como ya consultados
			for(String strCodigoParametro : lstParametrosYaConsultados){
				
				hmParametrosSistema.put(strCodigoParametro, 
										this.hmParametrosSistema.get(strCodigoParametro));
			}
		}
		
		if(hmParametrosSistema!=null){
		
			this.alimentarEnumParametros(hmParametrosSistema,
										 pEnmParametrosSistema);
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo verificarParametros
  	 * 		   Metodo que permite verificar los parametros solicitados
  	 * 		   para procesar, y se encarga de delimitar, cuales de las
  	 * 		   solicitudes pueden omitirse por previa consulta
  	 * @param pLstParametrosSolicitados
  	 * 		  Listado de parametros que deben ser solicitados al sistema
  	 * 		  SIMS
  	 * @param pLstParametrosYaConsultados
  	 * 		  Listado de parametros que ya han sido consultados 
  	 * 		  previamente, con la intencion de omitir su solicitud de
  	 * 		  consulta, solo aplica para aquellos parametros que no
  	 * 		  estan configurados como SIEMPRE_CONSULTA
  	 * @param pLstParametrosConsultaFija
  	 * 		  Listado de parametros identificados como de SIEMPRE_CONSULTA,
  	 * 		  para no incluir su resultado dentro del listado de consultados
  	 * 		  previamente 
  	 * @param pEnmParametros
  	 * 		  Listado de constantes de enumeracion que representan los 
  	 * 		  parametros de sistema de interes a consultar
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void verificarParametros(List<String> pLstParametrosSolicitados,
	                                 List<String> pLstParametrosSolicitadosGamble,
									 List<String> pLstParametrosYaConsultados,
									 List<String> pLstParametrosConsultaFija,
									 EnumParametrosSistema pEnmParametros[])throws Exception{
		
		for(EnumParametrosSistema enmParametroSistema : pEnmParametros){
			
			if	(	!enmParametroSistema.equals(EnumParametrosSistema.PAGINA_PRUEBA)	)
			{
				if	(	this.hmParametrosSistema.containsKey(enmParametroSistema.getStrCodigo())	)
				{
					pLstParametrosYaConsultados.add(enmParametroSistema.getStrCodigo());
					
				}	else	{
					
					if	(	EnumSistemas.GAMBLE.equals ( enmParametroSistema.getEnmSistema () )	)
					{
						pLstParametrosSolicitadosGamble.add(enmParametroSistema.getStrCodigo());
					}	else	{
						pLstParametrosSolicitados.add(enmParametroSistema.getStrCodigo());
					}
					
					if	(	enmParametroSistema.isBooSiempreConsulta()	)
					{
						pLstParametrosConsultaFija.add(enmParametroSistema.getStrCodigo());
					}
				}
			}
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo alimentarEnumParametros
  	 * 		   
  	 * @param hmParametrosSistema
  	 * 		  
  	 * @param pLstParametrosYaConsultados
  	 * 		  Listado de parametros que ya han sido consultados 
  	 * 		  previamente, con la intencion de omitir su solicitud de
  	 * 		  consulta, solo aplica para aquellos parametros que no
  	 * 		  estan configurados como SIEMPRE_CONSULTA
  	 * @param pEnmParametrosSistema
  	 * 		  Listado de constantes de enumeracion que representan los 
  	 * 		  parametros de sistema de interes a consultar, por parte 
  	 * 		  de la funcionalidad
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void alimentarEnumParametros(HashMap<String,ParametroSistema> hmParametrosSistema,
			 							 EnumParametrosSistema ...pParametros)throws Exception{
		
		ParametroSistema objParametroSistema;
		
		for(EnumParametrosSistema enmParametroSistema : pParametros){
			
			objParametroSistema = hmParametrosSistema.get(enmParametroSistema.getStrCodigo());
			enmParametroSistema.setObjParametroSistema(objParametroSistema);
		}
	}
	
	/**
	 * ********************************************************************
	 * @method 	excepcionRevizarConfiguracionParametrosSistema
	 * 		   	Metodo que permite generar la alerta a traves de una excepcion
	 * 			para validar las configuraciones realizadas sobre parametros
	 * 			de sistema especificos
	 * @param	pArrEnmParametrosSistemas
	 * 			Listado de parametros de sistema que se adjuntaran a la alerta
	 * 			como parametros para revision
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	hector.cuenca
	 * @date   	6/03/2017
	 * *********************************************************************
	 */
	public	void	excepcionRevizarConfiguracionParametrosSistema	(	EnumParametrosSistema ... pArrEnmParametrosSistemas 	)	
			throws	Exception
	{
		String strParametrosRevision;
		
		if	(		pArrEnmParametrosSistemas	!=	null	
				&&	pArrEnmParametrosSistemas.length	>	0	
			)
		{
			strParametrosRevision	=	"";
			
			for	(	EnumParametrosSistema enmParametroSistema	:	pArrEnmParametrosSistemas	)
			{
				strParametrosRevision	+=	" \u2022 "+enmParametroSistema.getStrCodigo()+"("+enmParametroSistema.name()+").\n";
			}
			
			
			throw	EnumMensajes.REVISAR_CONFIGURACION_PARAMETRO_SISTEMA.generarExcepcion	(	EnumClasesMensaje.ERROR, 
																								strParametrosRevision
																							);
		}
	}

	public Usuario getObjUsuario() {
		return objUsuario;
	}

	public void setObjUsuario(Usuario objUsuario) {
		this.objUsuario = objUsuario;
	}
}

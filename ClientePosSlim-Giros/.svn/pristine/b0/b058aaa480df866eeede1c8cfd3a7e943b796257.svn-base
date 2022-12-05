package co.com.codesa.clienteposslimgiros.utilidades.documentos;

import java.util.Arrays;
import java.util.List;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDocumentos;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Documento;
import co.com.codesa.codesawrapper.modelo.dominio.ParametroSistema;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 14-abr-2015
 * @Clase UtilDocumentos 
 * 		  Clase utilitaria relacionada con el objeto de negocio 
 * 		  documento
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class UtilDocumentos {
	
	/**
  	 * ****************************************************************.
  	 * @metodo isDocumentoTipoEnum
  	 * 		   Valida si el documento ingresado coincide con alguno de 
  	 * 		   los objetos documento que presenta el listado de enumeracion  
  	 * @param pObjDocumentoValidar
  	 * 		  Objeto documento a validar sobre el listado de enumeracion
  	 * @param pArrEnmDocumentos
  	 * 		  Listado de enumeradores de documentos sobre el cual se 
  	 * 		  realizara la validacion  
  	 * @return boolean
  	 * 		   Retorna una bandera que identifica si el documento ingresado
  	 * 		   se encuentra referenciado por alguno de los enumeradores [true],
  	 * 		   en caso contrario [false]
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 		  
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public static boolean isDocumentoTipoEnum(Documento pObjDocumentoValidar,
											  EnumDocumentos ... pArrEnmDocumentos)throws Exception{
		boolean booResultado = false;
		
		if(pObjDocumentoValidar != null
				&& pArrEnmDocumentos != null){
			
			for(EnumDocumentos objEnmDocumento : pArrEnmDocumentos){
				
				if(pObjDocumentoValidar.equals(objEnmDocumento.getObjDocumento())){
					
					booResultado = true;
					break;
				}
			}
		}
		
		return booResultado;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo procesarDocumentosUsuario
  	 * 		   Procesa el listado de documentos recibidos del usuario,
  	 * 		   posterior al proceso de autenticacion (idealmente), para 
  	 * 		   buscar y referenciar por cada documento del usuario
  	 * 		   la constante de enumeracion de documento especifica que
  	 * 		   coincida segun la configuracion que presente esta
  	 * @param pLstDocumentos
  	 * 		  Listado de documentos del usuario
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 		  
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public static void procesarDocumentosUsuario(List<Documento> pLstDocumentos)throws Exception{
		
		List<EnumDocumentos> lstEnmDocumentos;
		ParametroSistema objParametroSistema;
		EnumDocumentos enmDocumentosEncontrado;
		EnumParametrosSistema enmParametroSistema;
		String strValorBusqueda;
		boolean booTipoBusqueda;
		
		lstEnmDocumentos = Arrays.asList(EnumDocumentos.values());
		
		for(Documento objDocumento : pLstDocumentos){
			
			if(objDocumento.getCodigo() != null){
				booTipoBusqueda = true;
			}else if(objDocumento.getId() != null){
				booTipoBusqueda = false;
			}else{
				continue;
			}
			
			enmDocumentosEncontrado = null;
			
			for(EnumDocumentos enmDocumento : lstEnmDocumentos){
				
				if(enmDocumento.getObjValorBusqueda() != null
						&& enmDocumento.getBooTipoBusqueda() == booTipoBusqueda){
					
					if(enmDocumento.getObjValorBusqueda() instanceof EnumParametrosSistema){
						
						enmParametroSistema = (EnumParametrosSistema)enmDocumento.getObjValorBusqueda(); 
						objParametroSistema = UtilParametrosSistema.getInstance().consultar(enmParametroSistema);
						strValorBusqueda = objParametroSistema.getValor();
						
					}else{
						
						strValorBusqueda = enmDocumento.getObjValorBusqueda().toString();
					}
					
					if(enmDocumento.getBooTipoBusqueda()){//por codigo
						
						if(objDocumento.getCodigo().equals(strValorBusqueda)){
							
							enmDocumentosEncontrado = enmDocumento;
						}
						
					}else{//por id
						
						if(objDocumento.getId().equals(strValorBusqueda)){
							
							enmDocumentosEncontrado = enmDocumento;
						}
					}
					
					if(enmDocumentosEncontrado != null){
						
						enmDocumento.setObjDocumento(objDocumento);
						objDocumento.setStrTipoDocumento(enmDocumento.name());
						break;
					}
				}
			}
		}
	}
	
}

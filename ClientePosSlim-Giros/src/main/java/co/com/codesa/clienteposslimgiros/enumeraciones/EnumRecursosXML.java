package co.com.codesa.clienteposslimgiros.enumeraciones;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;

public enum EnumRecursosXML{

	EJEMPLO(EnumRecursosProperties.CONFIG_XML_EJEMPLO),
	
	;
	
	private EnumRecursosProperties enmConfigXml;
	private DocumentBuilder objDocumentBuilder;
	private InputStream ipsUrl;
	private Document objDocument;
	private String strNombreRecursoXML;
	
	private List<Object> lstListado;
	
	private EnumRecursosXML(EnumRecursosProperties pEnmConfigXml){
		
		this.setEnmConfigXml(pEnmConfigXml);
	}
	
	private void procesarXML()throws Exception{
		
		this.procesarNodosXML(this.getObjDocument().getDocumentElement(),
					  		  null,
					  		  null
					  		  //""
					  		  );
	}
	
	private void procesarNodosXML(Node pObjNodo,
								  Node pObjNodoPadre,
						  		  Object pObjPadre
						  		  //String pStrTab
						  		  )throws Exception{
		
		Object objClaseNodo;
		String strNombreClaseNodo;
		String strNombreMetodoCargarListado;
		
		if(pObjNodo!=null &&
				!pObjNodo.getNodeName().equals("#text")){
			
			//System.out.println(pStrTab+"<"+pObjNodo.getNodeName()+">");
			
			strNombreClaseNodo = this.enmConfigXml.getRsbRecurso().getString("TAG_"+pObjNodo.getNodeName());
			
			objClaseNodo = UtilidadesGiros.getInstance().ejecutarMetodo(strNombreClaseNodo, 
														 				null);
			this.procesarAtributos(pObjNodo, 
								   objClaseNodo
								   //pStrTab
								   );

			this.procesarHijos(pObjNodo,
							   objClaseNodo
					  		   //pStrTab
							   );
			
			if(pObjPadre == null){
				
				this.getLstListado().add(objClaseNodo);
				
			}else{
				
				strNombreMetodoCargarListado = this.enmConfigXml.getRsbRecurso().getString("CARGAR_"+pObjNodoPadre.getNodeName());
				
				UtilidadesGiros.getInstance().ejecutarMetodo(pObjPadre,
															 strNombreMetodoCargarListado,
						 									 objClaseNodo);
			}
		}
	}
	
	private void procesarAtributos(Node pObjNodo,
								   Object pObjClaseNodo
								   //String pStrTab
								   )throws Exception{
		
		NamedNodeMap objNnmAtributosNodo;
		Node objAtributoNodo;
		String strNombreMetodoSetAtributoClaseNodo;
		
		objNnmAtributosNodo = pObjNodo.getAttributes();

		if(objNnmAtributosNodo!=null
				&& objNnmAtributosNodo.getLength()>0){

			for(int j = 0; j < objNnmAtributosNodo.getLength(); j++){

				objAtributoNodo = objNnmAtributosNodo.item(j);
				//System.err.print(pStrTab+"\t"+objAtributoNodo.getNodeName()+": "+objAtributoNodo.getNodeValue());
				
				strNombreMetodoSetAtributoClaseNodo = this.enmConfigXml.getRsbRecurso().getString("ATRIBUTO_"+pObjNodo.getNodeName()+"_"+objAtributoNodo.getNodeName());
				
				UtilidadesGiros.getInstance().ejecutarMetodo(pObjClaseNodo,
															 strNombreMetodoSetAtributoClaseNodo,
															 objAtributoNodo.getNodeValue());
			}
		}
	}
	
	private void procesarHijos(Node pObjNodoPadre,
							   Object pObjPadre
							   //String pStrTab
							   )throws Exception{
		Node objNodo;
		String strNombreMetodoSetDatoClaseNodo;
		
		if(pObjNodoPadre.getChildNodes()!=null
				&& pObjNodoPadre.getChildNodes().getLength()>1){

			//System.err.println("");

			for(int i = 0; i < pObjNodoPadre.getChildNodes().getLength(); i++){

				objNodo = pObjNodoPadre.getChildNodes().item(i);
				
				this.procesarNodosXML(objNodo,
									  pObjNodoPadre,
							  		  pObjPadre
							  		  //pStrTab+"\t"
							  		  );
			}

		}else{

			//System.out.print(" -->  "+pObjNodoPadre.getTextContent());

			//System.err.println("");
			
			strNombreMetodoSetDatoClaseNodo = this.enmConfigXml.getRsbRecurso().getString("DATO_"+pObjNodoPadre.getNodeName());
			
			UtilidadesGiros.getInstance().ejecutarMetodo(pObjPadre,
														 strNombreMetodoSetDatoClaseNodo,
														 pObjNodoPadre.getTextContent());
		}
	}
	
	public EnumRecursosProperties getEnmConfigXml() {
		return enmConfigXml;
	}

	public void setEnmConfigXml(EnumRecursosProperties enmConfigXml) {
		this.enmConfigXml = enmConfigXml;
	}

	public DocumentBuilder getObjDocumentBuilder() throws Exception{
		
		if(this.objDocumentBuilder == null){
		
			this.objDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		}
		
		return objDocumentBuilder;
	}

	public void setObjDocumentBuilder(DocumentBuilder objDocumentBuilder) {
		this.objDocumentBuilder = objDocumentBuilder;
	}

	public InputStream getIpsUrl() throws Exception{
		
		if(this.ipsUrl == null){
			
			this.ipsUrl = this.getClass().getResourceAsStream(this.getStrNombreRecursoXML());
			
			if(this.ipsUrl==null
					|| this.ipsUrl.equals("")){
				
				throw EnumMensajes.DOC_XML_NO_EXISTE.generarExcepcion(EnumClasesMensaje.ERROR, 
																	  this.getStrNombreRecursoXML());
			}
		}
		
		return ipsUrl;
	}

	public void setIpsUrl(InputStream ipsUrl) {
		this.ipsUrl = ipsUrl;
	}

	public Document getObjDocument() throws Exception{
		
		if(this.objDocument == null){
			
			this.objDocument = this.getObjDocumentBuilder().parse(this.getIpsUrl());
		}
		
		return objDocument;
	}

	public void setObjDocument(Document objDocument) {
		this.objDocument = objDocument;
	}

	public String getStrNombreRecursoXML() throws Exception{
		
		if(this.strNombreRecursoXML == null){
			
			this.strNombreRecursoXML = this.getEnmConfigXml().getRsbRecurso().getString("NOMBRE_RECURSO");
		}
		
		return strNombreRecursoXML;
	}

	public void setStrNombreRecursoXML(String strNombreRecursoXML) {
		this.strNombreRecursoXML = strNombreRecursoXML;
	}

	public List<Object> getLstListado() throws Exception{
		
		if(this.lstListado == null){
			
			this.lstListado = new ArrayList<Object>();
			this.procesarXML();
		}
		
		return lstListado;
	}

	public void setLstListado(List<Object> lstListado) {
		this.lstListado = lstListado;
	}

	/*public static void main(String args[]){
		
		List<Object> lstListado;
		
		try{
			
			lstListado = EnumRecursosXML.EJEMPLO.getLstListado();
			
			System.out.println("termino");
			
		}catch(Exception e){
			e.printStackTrace();
			UtilidadesGiros.getInstance().controlExcepcion(e, null);
		}
	}*/
}

package co.com.codesa.clienteposslimgiros.utilidades.xml;

import java.io.InputStream;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ActividadEconomica;


public class XmlActividadesEconomicas{
	
	private static XmlActividadesEconomicas instancia;
	
	private Document objDocument;
	private String strNombreArchivo;
	private HashMap<String,ActividadEconomica> hmActividadesEconomicas;
	private HashMap<String,ActividadEconomica> hmActividadesEconomicasResumidas;
	private final String ID_SECCION_NORMAL = "1";
	private final String ID_SECCION_RESUMIDA = "2";

	private XmlActividadesEconomicas()throws Exception{
		
		super();
		
		this.strNombreArchivo = EnumParametrosApp.RUTA_INTERNA_XML_ACTIVIDADES_ECONOMICAS.getValorPropiedad();
		this.hmActividadesEconomicas = new HashMap<String, ActividadEconomica>();
		this.hmActividadesEconomicasResumidas = new HashMap<String, ActividadEconomica>();
		this.instanceDocument();
		
		this.hmActividadesEconomicas = this.cargarActividadesEconomicas(ID_SECCION_NORMAL);
		this.hmActividadesEconomicasResumidas = this.cargarActividadesEconomicas(ID_SECCION_RESUMIDA);
	}

	public static XmlActividadesEconomicas getInstance()throws Exception{
		
		if (instancia == null){
			instancia = new XmlActividadesEconomicas();
		}
			
		return instancia;
	}
	
	private void instanceDocument()throws Exception{
		
		DocumentBuilderFactory dbf;
		DocumentBuilder db;
		InputStream url;
		
		if (this.getObjDocument() == null) {
			
			dbf = DocumentBuilderFactory.newInstance();
			db = dbf.newDocumentBuilder();

			url = this.getClass().getResourceAsStream(this.strNombreArchivo);

			if (url!=null && 
					!url.equals("")) {
				this.setObjDocument(db.parse(url));
			}else{
				
				throw EnumMensajes.DOC_XML_NO_EXISTE.generarExcepcion(EnumClasesMensaje.ERROR, 
																this.strNombreArchivo);
			}
		}
	}
	
	private HashMap<String,ActividadEconomica> cargarActividadesEconomicas(String pStrCodigoSeccion)throws Exception{
		
		HashMap<String, ActividadEconomica> hmActividadesEconomicas;
		NodeList lstNodosHijos;
		Node objNodoPadre;
		Node objNodoEmpresa;
		NamedNodeMap objNnmAtributosNodoEmpresa;
		NodeList lstNodosHijosEmpresa;
		Node objNodoActividadEconomica;
		NamedNodeMap objNnmAtributosNodoActividadEconomica;
		ActividadEconomica objActividadEconomica;
		
		hmActividadesEconomicas = new HashMap<String, ActividadEconomica>();
		
		if (this.objDocument != null){
				
			objNodoPadre = this.objDocument.getDocumentElement();
			lstNodosHijos = objNodoPadre.getChildNodes();
			
			for (int i = 0; i < lstNodosHijos.getLength(); i++){
				
				objNodoEmpresa = lstNodosHijos.item(i);
				
				if (objNodoEmpresa.getNodeName().equals("EMPRESA")){
						
					objNnmAtributosNodoEmpresa = objNodoEmpresa.getAttributes();
					
					if (objNnmAtributosNodoEmpresa.getLength() == 2
							&& objNnmAtributosNodoEmpresa.getNamedItem("codigo").getNodeValue().equals(pStrCodigoSeccion)){
						
						lstNodosHijosEmpresa = objNodoEmpresa.getChildNodes();
						
						for (int id = 0; id < lstNodosHijosEmpresa.getLength(); id++){
							
							objNodoActividadEconomica = lstNodosHijosEmpresa.item(id);
							
							if (objNodoActividadEconomica.getNodeName().equals("actividadeconomica")){
								
								objNnmAtributosNodoActividadEconomica = objNodoActividadEconomica.getAttributes();
								
								if (objNnmAtributosNodoActividadEconomica.getLength() == 1){
									
									objActividadEconomica = new ActividadEconomica(objNnmAtributosNodoActividadEconomica.getNamedItem("codigo").getNodeValue());
									objActividadEconomica.setDescripcion(objNodoActividadEconomica.getTextContent());
									objActividadEconomica.setEmpresa(pStrCodigoSeccion);
									
									hmActividadesEconomicas.put(objActividadEconomica.getCodigo(), 
																objActividadEconomica);
								}
							}
						}
					}else{
						continue;
					}
				}
			}
		}
		
		return hmActividadesEconomicas;
	}
	
	public ActividadEconomica obtenerActividadEconomica(String strCodigoActividadEconomica)throws Exception{
		return this.hmActividadesEconomicas.get(strCodigoActividadEconomica);
	}
	
	public ActividadEconomica obtenerActividadEconomicaResumida(String strCodigoActividadEconomica)throws Exception{
		return this.hmActividadesEconomicasResumidas.get(strCodigoActividadEconomica);
	}
	
	public Document getObjDocument() {
		return objDocument;
	}

	public void setObjDocument(Document objDocument) {
		this.objDocument = objDocument;
	}

	public String getStrNombreArchivo() {
		return strNombreArchivo;
	}

	public void setStrNombreArchivo(String strNombreArchivo) {
		this.strNombreArchivo = strNombreArchivo;
	}

	public HashMap<String, ActividadEconomica> getHmActividadesEconomicas() {
		return hmActividadesEconomicas;
	}

	public void setHmActividadesEconomicas(HashMap<String, ActividadEconomica> hmActividadesEconomicas) {
		this.hmActividadesEconomicas = hmActividadesEconomicas;
	}
	
	public HashMap<String, ActividadEconomica> getHmActividadesEconomicasResumidas() {
		return hmActividadesEconomicasResumidas;
	}

	public void setHmActividadesEconomicasResumidas(HashMap<String, ActividadEconomica> hmActividadesEconomicasResumidas) {
		this.hmActividadesEconomicasResumidas = hmActividadesEconomicasResumidas;
	}
	
	public static void main(String args[]){
		
		HashMap<String,ActividadEconomica> listado;
		
		try{
			
			listado = XmlActividadesEconomicas.getInstance().getHmActividadesEconomicas();
			
			for(ActividadEconomica objActividadEconomica : listado.values()){
				System.out.println(objActividadEconomica);
			}
			
			listado = XmlActividadesEconomicas.getInstance().getHmActividadesEconomicasResumidas();
			
			for(ActividadEconomica objActividadEconomica : listado.values()){
				System.out.println(objActividadEconomica);
			}
		
		}catch(Exception e){
			
			UtilidadesGiros.getInstance().controlExcepcion(e, 
														   null);
		}
		
	}

}


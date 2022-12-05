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
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGiros;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DatoEntidad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Entidad;


public class XmlDatosEntidades{
	
	private static XmlDatosEntidades instancia;
	
	private Document objDocument;
	private String strNombreArchivo;
	private HashMap<String,Entidad> hmEntidades;


	private XmlDatosEntidades()throws Exception{
		
		super();
		
		this.strNombreArchivo = EnumParametrosApp.RUTA_INTERNA_XML_DATOS_ENTIDADES.getValorPropiedad();
		this.hmEntidades = new HashMap<String, Entidad>();
		this.instanceDocument();
		
		this.cargarEntidades(InformacionSessionGiros.getInstance().getObjUsuario().getEmpresa().getId());
	}

	public static XmlDatosEntidades getInstance()throws Exception{
		
		if (instancia == null){
			instancia = new XmlDatosEntidades();
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
	
	private void cargarEntidades(String pStrCodigoEmpresa)throws Exception{
		
		HashMap<String, Entidad> hmEntidades;
		NodeList lstNodosHijos;
		Node objNodoPadre;
		Node objNodoEmpresa;
		NamedNodeMap objNnmAtributosNodoEmpresa;
		NodeList lstNodosHijosEmpresa;
		Node objNodoEntidad;
		NamedNodeMap objNnmAtributosNodoEntidad;
		NodeList lstNodosHijosEntidad;
		Node objNodoDato;
		NamedNodeMap objNnmAtributosNodoDato;
		Entidad entidad;
		DatoEntidad datoEntidad;
		
		hmEntidades = new HashMap<String, Entidad>();
		
		if (this.objDocument != null){
				
			objNodoPadre = this.objDocument.getDocumentElement();
			lstNodosHijos = objNodoPadre.getChildNodes();
			
			for (int i = 0; i < lstNodosHijos.getLength(); i++){
				
				objNodoEmpresa = lstNodosHijos.item(i);
				
				if (objNodoEmpresa.getNodeName().equals("EMPRESA")){
						
					objNnmAtributosNodoEmpresa = objNodoEmpresa.getAttributes();
					
					if (objNnmAtributosNodoEmpresa.getLength() == 2
							&& objNnmAtributosNodoEmpresa.getNamedItem("codigo").getNodeValue().equals(pStrCodigoEmpresa)){
						
						lstNodosHijosEmpresa = objNodoEmpresa.getChildNodes();
						
						for (int id = 0; id < lstNodosHijosEmpresa.getLength(); id++){
							
							objNodoEntidad = lstNodosHijosEmpresa.item(id);
							
							if (objNodoEntidad.getNodeName().equals("ENTIDAD")){
								
								objNnmAtributosNodoEntidad = objNodoEntidad.getAttributes();
								
								if (objNnmAtributosNodoEntidad.getLength() == 2){
									
									entidad = new Entidad(objNnmAtributosNodoEntidad.getNamedItem("codigo").getNodeValue(),
														  objNnmAtributosNodoEntidad.getNamedItem("nombre").getNodeValue());
											
									lstNodosHijosEntidad = objNodoEntidad.getChildNodes();
									
									for (int im = 0; im < lstNodosHijosEntidad.getLength(); im++){
										
										objNodoDato = lstNodosHijosEntidad.item(im);
										
										if (objNodoDato.getNodeName().equals("DATO")){
											
											objNnmAtributosNodoDato = objNodoDato.getAttributes();
											
											if (objNnmAtributosNodoDato.getLength() == 2){
											
												datoEntidad = new DatoEntidad();
								
												datoEntidad.setTipoDato(objNodoDato.getAttributes().getNamedItem("tipodato").getNodeValue());
												datoEntidad.setId(objNodoDato.getAttributes().getNamedItem("codigo").getNodeValue());
												datoEntidad.setValor(objNodoDato.getTextContent());
												
												entidad.getHmDatos().put(datoEntidad.getId(), datoEntidad);
												
												hmEntidades.put(entidad.getId(), entidad);
												
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		if(!hmEntidades.isEmpty()){
			this.hmEntidades = hmEntidades; 
		}

	}
	
	public Entidad obtenerEntidad(String strCodigoEntidad)throws Exception{
		return this.hmEntidades.get(strCodigoEntidad);
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

	public HashMap<String, Entidad> getHmEntidades() {
		return hmEntidades;
	}

	public void setHmEntidades(HashMap<String, Entidad> hmEntidades) {
		this.hmEntidades = hmEntidades;
	}
	
	public static void main(String args[]){
		
		HashMap<String,Entidad> listado;
		Entidad entidadSeleccionado;
		
		try{
	        
			TestPruebasInternas.getInstance().iniciarPruebaInterna(null,
																   true, 
																   EnumDesplegarFormaConEventos.SI);
			
			listado = XmlDatosEntidades.getInstance().getHmEntidades();
			
			for(Entidad entidad : listado.values()){
				System.out.println(entidad);
			}
			
			entidadSeleccionado = XmlDatosEntidades.getInstance().obtenerEntidad("4");
			
			for(DatoEntidad datoEntidad : entidadSeleccionado.getHmDatos().values()){
				
				System.out.println(datoEntidad);
				
			}
			
		} catch (Exception e) {
			
			UtilidadesGiros.getInstance().controlExcepcion(e, 
														   null);
		}
	}

}

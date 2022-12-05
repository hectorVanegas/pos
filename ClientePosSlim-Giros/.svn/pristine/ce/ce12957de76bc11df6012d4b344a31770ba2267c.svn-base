package co.com.codesa.clienteposslimgiros.utilidades.xml;

import java.io.InputStream;
import java.util.TreeMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Territorio;

/**
 * @author Administrador Esta clase se encarga de leer y analizar el archivo XML
 *         s de territorios
 */
public class XmlTerritorio {
	
	private static XmlTerritorio instancia;
	
	private Document doc;
	private String nombreArchivo;
	
	private TreeMap<String, Territorio> tmZona;
	private TreeMap<String, Territorio> tmPais;
	private TreeMap<String, Territorio> tmDepartamento;
	private TreeMap<String, Territorio> tmMunicipio;
	
	private XmlTerritorio() throws Exception{
		super();

		this.nombreArchivo = EnumParametrosApp.RUTA_INTERNA_XML_TERRITORIOS.getValorPropiedad();
		this.tmZona = new TreeMap<String, Territorio>();
		this.tmPais = new TreeMap<String, Territorio>();
		this.tmDepartamento = new TreeMap<String, Territorio>();
		this.tmMunicipio = new TreeMap<String, Territorio>();
		
		this.instanceDocument();
		this.processDoc();
	}
	
	public static XmlTerritorio getInstance()throws Exception{
		
		if(instancia == null){
			instancia = new XmlTerritorio();
		}
		
		return instancia;
	}
	
	private void instanceDocument() throws Exception{
		
		DocumentBuilderFactory dbf;
		DocumentBuilder db;
		InputStream url;
		
		if (this.getDoc() == null) {
			
			dbf = DocumentBuilderFactory.newInstance();
			db = dbf.newDocumentBuilder();

			url = this.getClass().getResourceAsStream(this.nombreArchivo);

			if (url!=null && 
					!url.equals("")) {
				this.setDoc(db.parse(url));
			}else{
				
				throw EnumMensajes.DOC_XML_NO_EXISTE.generarExcepcion(EnumClasesMensaje.ERROR, 
																this.nombreArchivo);
			}
		}
	}

	private void processDoc() throws Exception{
		
		Node nodo;
		NodeList listaNodos = this.getDoc().getElementsByTagName("TERRITORIOS");

		for (int i = 0; i < listaNodos.getLength(); i++) {
			nodo = listaNodos.item(i);
			this.procesarTerritoriosBase(nodo);
		}
		
	}

	private Territorio addTerritorio(int tipo, 
								 	 Territorio territorioPadre, 
								 	 Node nodoHijo) throws Exception{
		
		Territorio territorio;
		String codigo;
		String nombre;
		
		codigo = nodoHijo.getAttributes().getNamedItem("dane").getNodeValue();
		
		territorio = new Territorio();
		territorio.setType(tipo);
		territorio.setCodigo(codigo);
		territorio.setTerritorioPadre(territorioPadre);
		
		if (tipo == EnumParametrosApp.CODIGO_TIPO_TERRITORIO_ZONA.getValorEntero()){
			
			nombre = nodoHijo.getAttributes().getNamedItem("nombre").getNodeValue();
			territorio.setNombre(nombre);
			this.tmZona.put(territorio.getCodigo(), territorio);
			
		}else if (tipo == EnumParametrosApp.CODIGO_TIPO_TERRITORIO_PAIS.getValorEntero()) {
			
			nombre = nodoHijo.getAttributes().getNamedItem("nombre").getNodeValue();
			territorio.setNombre(nombre);
			this.tmPais.put(territorio.getCodigo(), territorio);
			
		} else if (tipo == EnumParametrosApp.CODIGO_TIPO_TERRITORIO_DEPARTAMENTO.getValorEntero()) {
			
			nombre = nodoHijo.getAttributes().getNamedItem("nombre").getNodeValue();
			territorio.setNombre(nombre);
			this.tmDepartamento.put(territorio.getCodigo(), territorio);
			
		} else if (tipo == EnumParametrosApp.CODIGO_TIPO_TERRITORIO_MUNICIPIO.getValorEntero()) {
			
			territorio.setNombre(nodoHijo.getTextContent());
			this.tmMunicipio.put(territorio.getCodigo(), territorio);
			
		}

		return territorio;
	}

	private void procesarTerritoriosBase(Node nodo)throws Exception {
		
		NodeList listaNodos;
		Node nodoHijo;
		String nombreNodo;
		Territorio pais;
		
		listaNodos = nodo.getChildNodes();

		for (int i = 0; i < listaNodos.getLength(); i++) {
			
			nodoHijo = listaNodos.item(i);
			nombreNodo = nodoHijo.getNodeName();
			
			if(nombreNodo!=null){
			
				if (nombreNodo.equals("ZONA")){
					
					this.addTerritorio(EnumParametrosApp.CODIGO_TIPO_TERRITORIO_ZONA.getValorEntero(), 
								  	   null,
								  	   nodoHijo);
					
				}else if (nombreNodo.equals("PAIS")) {
					
					pais = this.addTerritorio(EnumParametrosApp.CODIGO_TIPO_TERRITORIO_PAIS.getValorEntero(), 
											  null,
											  nodoHijo);
					
					this.procesarDepartamentos(pais, 
										 nodoHijo);
				}	
			}
		}
	}

	private void procesarDepartamentos(Territorio pais, 
								 	   Node nodo) throws Exception{
		
		Node nodoHijo;
		NodeList listaNodos;
		Territorio departamento;
		String nombreNodo;
		
		listaNodos = nodo.getChildNodes();

		for (int i = 0; i < listaNodos.getLength(); i++) {
			
			nodoHijo = listaNodos.item(i);
			nombreNodo = nodoHijo.getNodeName();
			
			if (nombreNodo != null && 
					nombreNodo.equals("DEPARTAMENTO")) {
				
				departamento = this.addTerritorio(EnumParametrosApp.CODIGO_TIPO_TERRITORIO_DEPARTAMENTO.getValorEntero(), 
												  pais, 
												  nodoHijo);

				pais.gestionarTerritoriosHijos().put(departamento.getCodigo(), departamento);
				
				this.procesarMunicipios(departamento, 
								  nodoHijo);
			}
		}
		
	}

	private void procesarMunicipios(Territorio departamento, 
							  		Node nodo) throws Exception{
		
		NodeList list;
		Node nodoHijo;
		Territorio municipio;
		String nombreNodo;
		
		list = nodo.getChildNodes();
		
		for (int i = 0; i < list.getLength(); i++) {
			
			nodoHijo = list.item(i);
			nombreNodo = nodoHijo.getNodeName();

			if (nombreNodo != null && 
					nombreNodo.equals("MUNICIPIO")) {
				
				municipio = this.addTerritorio(EnumParametrosApp.CODIGO_TIPO_TERRITORIO_MUNICIPIO.getValorEntero(), 
								   			   departamento,
								   			   nodoHijo);
				
				departamento.gestionarTerritoriosHijos().put(municipio.getCodigo(), municipio);
			}
		}
		
	}

	public Territorio obtenerPais(String codigoPais)throws Exception{
		return tmPais.get(codigoPais);
	}
	
	public Territorio obtenerDepartamento(String codigoDepartamento)throws Exception{
		return tmDepartamento.get(codigoDepartamento);
	}
	
	public Territorio obtenerMunicipio(String codigoMunicipio) throws Exception{
		return tmMunicipio.get(codigoMunicipio);
	}
	
	public Territorio obtenerZona(String codeZona)throws Exception{
		return tmZona.get(codeZona);
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	private void setDoc(Document doc) {
		this.doc = doc;
	}

	private Document getDoc() {
		return doc;
	}
	
	public TreeMap<String, Territorio> getTmZona() {
		return tmZona;
	}

	public TreeMap<String, Territorio> getTmPais() {
		return tmPais;
	}
	
	public TreeMap<String, Territorio> getTmDepartamento() {
		return tmDepartamento;
	}

	public TreeMap<String, Territorio> getTmMunicipio() {
		return tmMunicipio;
	}

	public static void main(String args[]){
		
		TreeMap<String, Territorio> listado;
		Territorio departamentoSeleccionado;
		
		try{
		
		departamentoSeleccionado = XmlTerritorio.getInstance().obtenerDepartamento("13");
		
		listado = departamentoSeleccionado.getTerritoriosHijos();
		
		for(Territorio territorioHijo : listado.values()){
			
			System.out.println(territorioHijo
									+" | "+territorioHijo.getTerritorioPadre()
									+" | "+territorioHijo.getTerritorioPadre().getTerritorioPadre()
									);
			
		}
		
		}catch(Exception e){
			
			UtilidadesGiros.getInstance().controlExcepcion(e, 
														   null);
		}
		
	}
	
}

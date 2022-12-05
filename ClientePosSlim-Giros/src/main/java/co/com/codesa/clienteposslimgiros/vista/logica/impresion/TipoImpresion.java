package co.com.codesa.clienteposslimgiros.vista.logica.impresion;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumRecursosProperties;

/**
 * ****************************************************************.
 * @autor: Roberth Martinez Vargas
 * @fecha: 29-abril-2015
 * @descripcion: Clase que representa el manejo de tipo de impresora
 * 				 mediante un archivo de propiedades
 * @copyright: Copyright  1998-2012 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class TipoImpresion {
	
	private Properties propiedades;
	
	private static TipoImpresion instancia;
	
	//private String strRutaBnet = System.getProperty("user.home")+File.separator+"businessnet"+File.separator;
	private String strRutaBnet = System.getProperty("user.dir")+File.separator;
	
	private TipoImpresion() {
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo: getInstancia
     * @descripcion: metodo utilizado para crear una instancia de la clase
     * @autor: Roberth Martinez Vargas
     * ****************************************************************
     */
	public static TipoImpresion getInstancia() {
		if (instancia == null) {
			instancia = new TipoImpresion();
		}
		return instancia;
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo: cargarArchivoConfiguracionImpresora
     * @descripcion: metodo utilizado para cargar las propiedades que 
     * 				 estan en el archivo de propiedades ubicado en el 
     * 				 home de la aplicacion dentro de la carpeta businessnet
     * @autor: Roberth Martinez Vargas
     * ****************************************************************
     */
	private Properties cargarArchivoConfiguracionImpresora() throws Exception{
		
		Properties pro = new Properties();
		String strArchivo;
		
		
		strArchivo = this.strRutaBnet + EnumParametrosApp.CONFIGURACION_IMPRESORA_PROPERTIES.getValorPropiedad();
		File file = new File(strArchivo);
		
		if(!file.exists()){
			this.crearArchivoTipoImpresora(file);
		}
		
		pro.load(new FileInputStream(strArchivo));
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		pro.store(out,"");
		ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
		//ControladorEtiquetas.configuracion_impresora = new PropertyResourceBundle(in);
		EnumRecursosProperties.CONFIGURACION_IMPRESORA.setStrRutaRecurso(strArchivo);
		EnumRecursosProperties.CONFIGURACION_IMPRESORA.setRsbRecurso(new PropertyResourceBundle(in));
		
		//pro=null;
		out=null;
		in=null;
		return pro;
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @param pArchivo
     * 		  Archivo consultado, para ser creado 
     * @metodo: crearArchivoTipoImpresora
     * @descripcion: crea el archivo de tipo impresora con las configuraciones
     * 				 que estan en el archivo del proyecto
     * @autor: Roberth Martinez Vargas
     * ****************************************************************
     */
	public void crearArchivoTipoImpresora(File pArchivo) throws Exception{
		String strCadenaArchivo;
		ResourceBundle resourceBundle;
		PrintWriter prwDatosArchivo;
		
		strCadenaArchivo = "";
		resourceBundle = ResourceBundle.getBundle("co/com/codesa/clienteposslimgiros/config/configuracion_impresora");
		
		for (String ie : resourceBundle.keySet()) {
			strCadenaArchivo = ie+"="+resourceBundle.getString(ie)+"\n";
		}
		pArchivo.createNewFile();
		
		prwDatosArchivo = new PrintWriter(new BufferedWriter(new FileWriter(pArchivo)));

		prwDatosArchivo.println(strCadenaArchivo);
		prwDatosArchivo.close();
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @param pStrTipoImpresora
     * 		  tipo impresora TMU o MCM 
     * @metodo: modificarArchivoConfiguracionImpresora
     * @descripcion: metodo utilizado modificar la propiedad tipo del 
     * 				 archivo de propiedades de tipos de impresora
     * @autor: Roberth Martinez Vargas
     * ****************************************************************
     */
	public void modificarArchivoConfiguracionImpresora(String pStrTipoImpresora) throws Exception{
		
		String strArchivo;

		strArchivo = this.strRutaBnet + EnumParametrosApp.CONFIGURACION_IMPRESORA_PROPERTIES.getValorPropiedad();
		
		OutputStream salida = null;
		salida = new FileOutputStream(strArchivo);
		this.getPropiedades().setProperty("tipo", pStrTipoImpresora);
		this.getPropiedades().store(salida,null);
		salida.close();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		this.getPropiedades().store(out,null);
		ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());			
		//ControladorEtiquetas.configuracion_impresora = new PropertyResourceBundle(in);
		EnumRecursosProperties.CONFIGURACION_IMPRESORA.setStrRutaRecurso(strArchivo);
		EnumRecursosProperties.CONFIGURACION_IMPRESORA.setRsbRecurso(new PropertyResourceBundle(in));

		//pro=null;
		out=null;
		in=null;
	}

	public Properties getPropiedades() throws Exception {
		if (this.propiedades == null) {
			this.propiedades = this.cargarArchivoConfiguracionImpresora();
			
		}
		return this.propiedades;
	}

	public void setPropiedades(Properties propiedades) {
		this.propiedades = propiedades;
	}

	public static void main(String[] args) {
		
		
		try {
			TipoImpresion.getInstancia().crearArchivoTipoImpresora(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

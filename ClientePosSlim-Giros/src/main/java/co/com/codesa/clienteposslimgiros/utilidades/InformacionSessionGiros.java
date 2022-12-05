package co.com.codesa.clienteposslimgiros.utilidades;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.conexion.EnumConexiones;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.codesawrapper.modelo.dominio.ProveedorServicioProducto;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

/**
 * ****************************************************************.
 * @autor: CesarO.Rendon
 * @fecha: 06/03/2015
 * @descripcion: Clase encargada de brinda atributos en session de giros
 * durante la ejecucion del aplicativo
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class InformacionSessionGiros {
	
	private Hashtable<String, String> htMenu;
	private Hashtable<String, JMenuItem>htIdMenu;
	private HashMap<String,List<ProveedorServicioProducto>> hmLstProveedorServicioProductoGiros;
	
	/**
	 * @variable	mnbMenuCompleto
	 * 				Menu general de todas las funcionalidades de giros
	 */
	private JMenuBar mnbMenuCompleto;
	
	private Usuario objUsuario;
	
	/**
	 * @variable 	PROCESO_ANULACION_EN_DESARROLLO
	 * 			 	bandera temporal, para condicionar cambios parciales
	 * 				para el nuevo proceso de anulacion propuesto
	 */
	//public static final boolean PROCESO_ANULACION_EN_DESARROLLO;
	
	private static InformacionSessionGiros instance;
	/*
	static{
		PROCESO_ANULACION_EN_DESARROLLO	=	FormaLogin.estadoAplicacion == null 
												|| FormaLogin.estadoAplicacion.equals(EstadoAplicacionEnum.DESARROLLO);
	}
	*/
	
	private void inicializarInformacionSessionGiros() {
		
		try{
		
			this.setObjUsuario(UtilidadGiros.getInstancia().crearUsuario(null,
																		 null,//EnumConfiguracion.CODIGO_INICIAL_AGENCIA_SIMS.obtenerValor(),
																		 null,
																		 null,//EnumConexiones.NEGOCIO_EMPRESA.getStrParametrosPARAMEMPWS (),
																		 null,//EnumConexiones.NEGOCIO_PROVEEDOR.getStrParametrosPARAMEMPWS (),
																		 true));
			
			this.hmLstProveedorServicioProductoGiros	=	new HashMap<String,List<ProveedorServicioProducto>>();
			
			UtilParametrosSistema.getInstance().consultar(	EnumConexiones.NEGOCIO_EMPRESA.getpEnmParSisEspecificacionPARAMEMPWS (),
															EnumConexiones.NEGOCIO_PROVEEDOR.getpEnmParSisEspecificacionPARAMEMPWS ()
			                                             );
			
			this.getObjUsuario ().setObjConexionSocketGEjb ( EnumConexiones.NEGOCIO_EMPRESA.getStrParametrosPARAMEMPWS () );
			this.getObjUsuario ().setObjConexionEjbSocketS ( EnumConexiones.NEGOCIO_PROVEEDOR.getStrParametrosPARAMEMPWS () );
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static InformacionSessionGiros getInstance() {
		
		if(instance==null){
			
			instance = new InformacionSessionGiros();
			instance.inicializarInformacionSessionGiros();
		}
		
		return instance;
	}

	public EtiquetaUtil iniciarPropLblVersion(EnumDimensionesComponentes pEnmDimensionEtiqueta) throws Exception{
		
		EtiquetaUtil lblVersion = null;
		
		lblVersion = UtilComponentesGUI.getInstance().crearLabel(pEnmDimensionEtiqueta, 
															 	 "lblVersion", 
															 	  null,
															 	  false,
															 	  null,
															 	  true);
		
		lblVersion.setText(EnumEtiquetas.LBL_VERSION_JAVA.getValor(true)+" "+System.getProperty("java.runtime.version"));
		
		lblVersion.getPropiedades().activarDesplazamientoAutomatico();
		
		//System.err.println(lblVersion.getTextoOriginal());
		
		return lblVersion;
	}
	
	public EtiquetaUtil iniciarPropLblVersionProductoGiros(EnumDimensionesComponentes pEnmDimensionEtiqueta) throws Exception{
		
		EtiquetaUtil lblVersion = null;
		
		lblVersion = UtilComponentesGUI.getInstance().crearLabel(pEnmDimensionEtiqueta, 
															 	 "lblVersion", 
															 	  null,
															 	  false,
															 	  null,
															 	  true);
		
		lblVersion.setText(EnumEtiquetas.LBL_VERSION_GIROS + EnumParametrosApp.VERSION_GIRO.getValorPropiedad());
		
		
		return lblVersion;
	}

	public Hashtable<String, String> getHtMenu() {
		return htMenu;
	}

	public void setHtMenu(Hashtable<String, String> htMenu) {
		this.htMenu = htMenu;
	}
	
	public Hashtable<String, JMenuItem> getHtIdMenu() {
		return htIdMenu;
	}

	public void setHtIdMenu(Hashtable<String, JMenuItem> htIdMenu) {
		this.htIdMenu = htIdMenu;
	}

	public Usuario getObjUsuario() {
		return objUsuario;
	}

	public void setObjUsuario(Usuario objUsuario) {
		this.objUsuario = objUsuario;
	}

	/**
	 * @method getHmLstProveedorServicioProductoGiros
	 * 		   Metodo get del atributo hmLstProveedorServicioProductoGiros
	 * @return HashMap<String,List<ProveedorServicioProducto>>
	 *		   Valor del atributo hmLstProveedorServicioProductoGiros devuelto
	 * @author hector.cuenca
	 * @date   8/05/2017
	 */
	public HashMap<String,List<ProveedorServicioProducto>> getHmLstProveedorServicioProductoGiros() {
		return hmLstProveedorServicioProductoGiros;
	}

	/**
	 * @method setHmLstProveedorServicioProductoGiros
	 * 		   Metodo set del atributo hmLstProveedorServicioProductoGiros
	 * @param  pHmLstProveedorServicioProductoGiros
	 *		   Valor que tomara el atributo hmLstProveedorServicioProductoGiros
	 * @author hector.cuenca
	 * @date   8/05/2017
	 */
	public void setHmLstProveedorServicioProductoGiros(
			HashMap<String,List<ProveedorServicioProducto>> pHmLstProveedorServicioProductoGiros) {
		this.hmLstProveedorServicioProductoGiros = pHmLstProveedorServicioProductoGiros;
	}

	/**
	 * @method	getMnbMenuCompleto
	 * 		  	Metodo get del atributo mnbMenuCompleto
	 * @return	JMenuBar
	 *		  	Valor del atributo mnbMenuCompleto devuelto
	 * @author	hector.cuenca
	 * @date  	24/04/2018
	 */
	public JMenuBar getMnbMenuCompleto() {
		return mnbMenuCompleto;
	}

	/**
	 * @method	setMnbMenuCompleto
	 * 		  	Metodo set del atributo mnbMenuCompleto
	 * @param	pMnbMenuCompleto
	 * 			Valor que tomara el atributo mnbMenuCompleto
	 * @author	hector.cuenca
	 * @date	24/04/2018
	 */
	public void setMnbMenuCompleto(JMenuBar pMnbMenuCompleto) {
		this.mnbMenuCompleto = pMnbMenuCompleto;
	}
}

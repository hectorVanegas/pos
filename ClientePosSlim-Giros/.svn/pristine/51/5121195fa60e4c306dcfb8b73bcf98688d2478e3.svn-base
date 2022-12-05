package co.com.codesa.clienteposslimgiros.pruebas;

import javax.swing.JFrame;

import co.com.codesa.clienteposslim.general.InformacionSession;
import co.com.codesa.clienteposslim.utilidades.Utilidades;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosPruebas;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.principal.FormaInicioGiros;
import co.com.codesa.clienteposslimgiros.formas.sesion.FormaAutenticacion;
import co.com.codesa.codesawrapper.modelo.enumeraciones.EnumPropiedades;

public class TestPruebasInternas{

	private static TestPruebasInternas testPruebasInternas;
	
	private JFrame jframe;
	
	public static boolean ACTIVADO_PRUEBAS_INTERNAS;
	
	public static Class<? extends FormaGenerica> CLASS_FORMA_GENERICA;
	
	public static EnumDesplegarFormaConEventos DESPLEGAR_FORMA_CON_EVENTOS;
	
	private TestPruebasInternas() throws Exception{
		
		FormaInicioGiros	pnlMenu;
		
		this.cargarInformacionInicial();
		
		this.jframe = new JFrame();
		this.jframe.setName(EnumParametrosPruebas.PRU_INT_NOMBRE_FRAME.getPropiedad());
		this.jframe.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		this.jframe.setLayout(null);
		this.jframe.setSize(900,415);
		this.jframe.setLocationRelativeTo(null);
		
		pnlMenu	=	new FormaInicioGiros(jframe);
		pnlMenu.setSize(this.jframe.getSize());
		this.jframe.add(pnlMenu);
	}
	
	public void cargarInformacionInicial()throws Exception{
		
		InformacionSession.getInstance().setLogin(EnumParametrosPruebas.PRU_INT_LOGIN_GAMBLE.getPropiedad());
		InformacionSession.getInstance().setDocumentoUsuario(EnumParametrosPruebas.PRU_INT_DOCUMENTO_USUARIO_GAMBLE.getPropiedad());
		InformacionSession.getInstance().setPuntoVenta(EnumParametrosPruebas.PRU_INT_PUNTO_VENTA_GAMBLE.getPropiedad());
		InformacionSession.getInstance().setCodigoCentroCosto(EnumParametrosPruebas.PRU_INT_CODIGO_CENTRO_COSTO_GAMBLE.getPropiedad());
		InformacionSession.getInstance().setClaveUsuario(EnumParametrosPruebas.PRU_INT_CLAVE_USUARIO_GAMBLE.getPropiedad());
		InformacionSession.getInstance().setTokenSeguridadSims(EnumParametrosPruebas.PRU_INT_TOKEN_D_GAMBLE.getPropiedad());
		
		InformacionSession.getInstance().setIpSocket(EnumParametrosPruebas.PRU_INT_IP_SOCKET_GAMBLE.getPropiedad());
		InformacionSession.getInstance().setPuertoSocket(EnumParametrosPruebas.PRU_INT_PUERTO_SOCKET_GAMBLE.getPropiedad());
		EnumPropiedades.TIME_OUT.setContenidoParametro(EnumParametrosPruebas.PRU_INT_TIME_OUT_SOCKET_GAMBLE.getPropiedad());
		EnumPropiedades.MAC.setContenidoParametro(Utilidades.getIpMac().split(",")[1].split(";")[0]);
	}
	
	public static TestPruebasInternas getInstance() throws Exception{
		
		if (testPruebasInternas == null) {
			
			testPruebasInternas = new TestPruebasInternas();
		}
		
		return testPruebasInternas;
	}
	
	public JFrame iniciarPruebaInterna(Class<? extends FormaGenerica> pClsFormaGenerica,
									   boolean pBooAutenticar,
									   EnumDesplegarFormaConEventos pEnmConfDesplegarFormaConEventos)throws Exception{
		
		TestPruebasInternas.ACTIVADO_PRUEBAS_INTERNAS = true;
		TestPruebasInternas.DESPLEGAR_FORMA_CON_EVENTOS = pEnmConfDesplegarFormaConEventos;
		TestPruebasInternas.CLASS_FORMA_GENERICA = pClsFormaGenerica;
		
		if(pBooAutenticar){
			
			this.autenticacionInterna();
		}
		
		return this.jframe;
	}
	
	private void autenticacionInterna()throws Exception{
        
		new FormaAutenticacion(this.jframe, 
							   false, 
							   EnumParametrosPruebas.PRU_INT_LOGIN_SIMS.getPropiedad(), 
							   EnumParametrosPruebas.PRU_INT_CLAVE_SIMS.getPropiedad(),
							   true);
	}
	
	public enum EnumDesplegarFormaConEventos {
		
		SI,
		NO,
	}
}

package co.com.codesa.clienteposslimgiros.utilidades.lector2D;

import java.util.StringTokenizer;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.clienteposslimgiros.utilidades.validaciones.ValidacionesBiometria;
import co.com.codesa.clienteposslimgiros.vista.logica.ControlConsultaPasiVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.ControlConsultaTramaVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.lector2D.Lector2DVistaLogica;
import co.com.codesa.codesawrapper.modelo.dominio.ParametroSistema;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;

public class UtilValidacionesLector2D {
	
	private static UtilValidacionesLector2D instancia;
	
	/**
	 * ****************************************************************.
	 * @metodo: getInstance
	 * @descripcion: metodo para cumplir con el patron singleton y tener
	 * una unica instancia de la clase para se accedida.
	 * @autor: Jefferson Ruiz
	 * ****************************************************************
	 */
	public static UtilValidacionesLector2D getInstance(){		
		if (instancia == null)
			instancia= new UtilValidacionesLector2D();
		
		return instancia;
	}
	
	
	/** 
	 * ********************************************************************
	 * @method verificarConfiguracionesLector2D
	 * 		   Metodo que permite verificar si los servicios de configuracion del lector2D
	 * 		   se encuentran activados
	 * @param  pObjUsuario
	 * 		   objeto usuario
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author Jefferson Ruiz
	 * @date   06/09/2019
	 * *********************************************************************
	 */
	public Boolean verificarConfiguracionesLector2D(Usuario pobjUsuario) throws Exception { 
	
		Boolean booServicios = false;
		String[] arrDatosConfiguracion = new String[3];
		
		//arrDatosConfiguracion = Lector2DVistaLogica.getInstance().consultarConfiguracion(pobjUsuario);
		arrDatosConfiguracion = ControlConsultaTramaVistaLogica.getInstance().getListadoServicios();
		
		// Se valida si el servicios general se encuentra activo
		if (arrDatosConfiguracion[1].equals("S")) {
			
			// Se valida si la caja tiene el lector 2D
			if (arrDatosConfiguracion[2].equals("S")) {
				
				booServicios = true;
				
			}
			
		}
		
		return booServicios;
		
	}
	
	
	/** 
	 * ********************************************************************
	 * @method verificarConvenioLector2D
	 * 		   Metodo que permite verificar si el remitente es un convenio
	 * 		   parametrizado para realizar verificacion lector 2D 
	 * @param  pObjRemitente
	 * 		   objeto tercero remitente
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author Jefferson Ruiz
	 * @date   06/09/2019
	 * *********************************************************************
	 */
	public Boolean verificarConvenioLector2D(Tercero pObjRemitente) throws Exception { 
	
		Boolean booConvenioParametrizado = false;
		ParametroSistema psPASI;
		String strTESOLECD = "";
		String strConvenios;
		String strTipoDocumento;
		String strIdentificacion;
		
		// Se recupera el parametro donde se encuentra los convenios a los que se le realizara el proceo de verificacion
		/*psPASI = UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.TERCEROS_CONVENIO_VERIFICACION_LECTOR2D);
		strTESOLECD = psPASI.getValor();*/
		
		strTESOLECD = ControlConsultaPasiVistaLogica.getInstance().getTesolecd();
		
		StringTokenizer st = new StringTokenizer(strTESOLECD, EnumGeneralidadesTramasGiros.PUNTO_Y_COMA.getValor());
		
		while (st.hasMoreTokens() && (!booConvenioParametrizado)) {
			
			strConvenios = st.nextToken();
			
			if (!strConvenios.contains(EnumGeneralidadesTramasGiros.PIPE.getValor())) {
				
				throw EnumMensajes.ESTRUCTURA_PARAMETRO_IDREOPIE.generarExcepcion(EnumClasesMensaje.ERROR);
			}
			
			StringTokenizer st2 = new StringTokenizer(strConvenios, EnumGeneralidadesTramasGiros.PIPE.getValor());
			
			while (st2.hasMoreTokens()) {
				
				strTipoDocumento = st2.nextToken();
				strIdentificacion = st2.nextToken();
				
				// Se valida si el remitente (tercero Origen) esta parametrizado 
				if (strIdentificacion.equals(pObjRemitente.getIdentificacion()) && 
					strTipoDocumento.equals(pObjRemitente.getTipoIdentificacion().getId())) {
					
					booConvenioParametrizado = true;
					
				}
				
			}
			
		}
		
		return booConvenioParametrizado;
		
	}
	
	/** 
	 * ********************************************************************
	 * @method verificarConvenioBiometriaLector2D
	 * 		   Metodo que permite verificar si el remitente es un convenio
	 * 		   parametrizado para realizar verificacion despues del enrolamiento
	 *         con lector 2D 
	 * @param  pObjRemitente
	 * 		   objeto tercero remitente
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author Jefferson Ruiz
	 * @date   06/09/2019
	 * *********************************************************************
	 */
	
	public Boolean verificarConvenioBiometriaLector2D(Tercero pObjRemitente) throws Exception { 
		
		Boolean booConvenioBiometria = false;
		ParametroSistema psPASI;
		String strTESOLBIO = "";
		String strConvenios;
		String strTipoDocumento;
		String strIdentificacion;
		
		// Se recupera el parametro donde se encuentra los convenios a los que se le realizara el proceo de verificacion
		/*psPASI = UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.TERCEROS_CONVENIO_VERIFICACION_BIOMETRIA_LECTOR2D);
		strTESOLBIO = psPASI.getValor();*/
		
		strTESOLBIO = ControlConsultaPasiVistaLogica.getInstance().getTesolbio();
		
		StringTokenizer st = new StringTokenizer(strTESOLBIO, EnumGeneralidadesTramasGiros.PUNTO_Y_COMA.getValor());
		
		while (st.hasMoreTokens() && (!booConvenioBiometria)) {
			
			strConvenios = st.nextToken();
			
			if (!strConvenios.contains(EnumGeneralidadesTramasGiros.PIPE.getValor())) {
				
				throw EnumMensajes.ESTRUCTURA_PARAMETRO_IDREOPIE.generarExcepcion(EnumClasesMensaje.ERROR);
			}
			
			StringTokenizer st2 = new StringTokenizer(strConvenios, EnumGeneralidadesTramasGiros.PIPE.getValor());
			
			while (st2.hasMoreTokens()) {
				
				strTipoDocumento = st2.nextToken();
				strIdentificacion = st2.nextToken();
				
				// Se valida si el remitente (tercero Origen) esta parametrizado 
				if (strIdentificacion.equals(pObjRemitente.getIdentificacion()) && 
					strTipoDocumento.equals(pObjRemitente.getTipoIdentificacion().getId())) {
					
					booConvenioBiometria = true;
					
				}
				
			}
			
		}
		
		return booConvenioBiometria;
		
	}

	

}

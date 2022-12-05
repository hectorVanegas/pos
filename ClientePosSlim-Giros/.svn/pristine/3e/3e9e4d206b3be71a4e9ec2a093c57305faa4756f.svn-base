package co.com.codesa.clienteposslimgiros.vista.logica.lector2D;

import java.util.StringTokenizer;

import javax.naming.LimitExceededException;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.clienteposslimgiros.utilidades.vistaLogica.UtilVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.ConsultarServicioPorColaboradorVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.ControlConsultaPasiVistaLogica;
import co.com.codesa.codesawrapper.modelo.dominio.ParametroSistema;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ObjetoBasico;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;
import co.com.codesa.codesawrappergiros.utilidades.ConsultarServicioPorColaborador;
import co.com.codesa.codesawrappergiros.utilidades.RespuestaConsultarServicioPorColaborador;
import co.com.codesa.codesawrappergiros.utilidades.lector2D.ConsultarConfiguracionLector2D;
import co.com.codesa.codesawrappergiros.utilidades.lector2D.RespuestaConsultarConfiguracionLector2D;
import co.com.codesa.lectorcedula.dominio.DatosCedula;
import co.com.codesa.lectorcedula.servicio.LectorCedula;

public class Lector2DVistaLogica {
	
	private static Lector2DVistaLogica instancia;
	
	/**
	 * @variable booProcesoLectorOk
	 * 			 variable para validar si se el proceso del lector2D
	 * 			 termino de manera exitosa 
	 **/
	private boolean booProcesoLectorOk = false;
	
	/**
	 * @variable strMensaje
	 * 			 variable para alojar los mensajes de error par el lector2D			 
	 **/
	private String strMensaje = null;
	
	/**
	 * ****************************************************************.
	 * @metodo: ConsultarServicioPorColaboradorVistaLogica
	 * @descripcion: contructor de la logica.
	 * @autor: Jefferson Ruiz
	 * @date: 06/09/2019
	 * ****************************************************************
	 */
	private Lector2DVistaLogica(){}	
	
	/**
	 * ****************************************************************.
	 * @metodo: getInstance
	 * @descripcion: metodo para cumplir con el patron singleton y tener
	 * una unica instancia de la clase para se accedida.
	 * @autor: Jefferson Ruiz
	 * ****************************************************************
	 */
	public static Lector2DVistaLogica getInstance(){		
		if (instancia == null)
			instancia= new Lector2DVistaLogica();
		
		return instancia;
	}
	
	
	/** 
	 * ********************************************************************
	 * @method consultarConfiguracion
	 * 		   Metodo que permite consumir la trama 561
	 * @param  pObjUsuario
	 * 		   objeto usuario
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author Jefferson Ruiz
	 * @date   06/09/2019
	 * *********************************************************************
	 */
	public String[] consultarConfiguracion(Usuario pobjUsuario) throws Exception {
		
		ConsultarConfiguracionLector2D objEnvioTrama;
		RespuestaConsultarConfiguracionLector2D objRespuestaTrama;
		String[] arrListadoServicios = new String[3];
		
		objEnvioTrama = new ConsultarConfiguracionLector2D(pobjUsuario);
		
		objRespuestaTrama = (RespuestaConsultarConfiguracionLector2D)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
			
			arrListadoServicios[0] = objRespuestaTrama.getValorAtributoObj("codigoCaja").toString();
			arrListadoServicios[1] = objRespuestaTrama.getValorAtributoObj("servicioGenral").toString();
			arrListadoServicios[2] = objRespuestaTrama.getValorAtributoObj("servicioCaja").toString();
		
		}else {
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR,
															(String)objRespuestaTrama.getValorAtributoObj("codigoError"), 
															(String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
			
		}
		
		return arrListadoServicios;
		
	}
	
	/** 
	 * ********************************************************************
	 * @method verificarInformacionLector2D
	 * 		   Metodo que permite Validar la informacion del lector contra
	 * 		   la informacion del tercero
	 * @param  pObjTercero
	 * 		   objeto tercero
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author Jefferson Ruiz
	 * @date   06/09/2019
	 * *********************************************************************
	 */
	public void verificarInformacionLector2D(Tercero pobjTercero,
											 String  pstrCadena) throws Exception {
		
		ParametroSistema psPasi;
		String strVACOLEDD;
		StringTokenizer stkParametro;
		String []  arrCamposValidos = {"documento","nombres","apellido1","apellido2"};
		String strValorCampo;
		String strMensaje = " ";
		Boolean booCampoValido = false;
		Boolean booInformacionValida;
		Boolean booLectorOk = true;
		Boolean booSalida = false;
		DatosCedula objInfoCedula;
		
		// Se recupera el parametro donde se encuentra los campos a comprar del lector 2D
		/*psPasi = UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.VALORES_A_COMPARAR_LECTOR_2D);
		strVACOLEDD = psPasi.getValor();*/
		
		strVACOLEDD = ControlConsultaPasiVistaLogica.getInstance().getVacoledd();
		
		stkParametro = new StringTokenizer(strVACOLEDD, 
										   EnumGeneralidadesTramasGiros.PIPE.getValor());
		booInformacionValida = true;
		
		this.setMensaje(strMensaje);
		
		try {
			
			objInfoCedula = LectorCedula.lectorScanner(pstrCadena.trim());
			
			pstrCadena = "";
			
			if (objInfoCedula != null) {
				
				while (stkParametro.hasMoreElements() && (!booSalida)) {
					
					strValorCampo = stkParametro.nextToken();
					booCampoValido = false;
					
					// Se recorre el array de valores validos
					for (int i = 0; i < arrCamposValidos.length && (!booCampoValido); i++) {
						
						// se compara si el valor recuperado del parametro es uno valido 
						if (strValorCampo.equals(arrCamposValidos[i])) {
							
							booCampoValido = true;
												
						}/*else {
							booSalida = true;
						}*/
						
					}
					
					
					
					
					if (booCampoValido) {
						
						switch (strValorCampo) {
						case "documento":
							if (!pobjTercero.getIdentificacion().equals(objInfoCedula.getDocumento().toString())) {
								booInformacionValida = false;
								booSalida = true;
							}
							break;
						case "nombres":
							if (!pobjTercero.getNombres().trim().equals(objInfoCedula.getNombres().replace("Ñ", "N").trim())) {
								booInformacionValida = false;
								booSalida = true;
							}
							break;
						case "apellido1":
							if (!pobjTercero.getApellido1().equals(objInfoCedula.getApellido1().replace("Ñ", "N").trim())) {
								booInformacionValida = false;
								booSalida = true;
							}
							break;
						case "apellido2":
							if (!pobjTercero.getApellido2().equals(objInfoCedula.getApellido2().replace("Ñ", "N").trim())) {
								booInformacionValida = false;
								booSalida = true;
							}
							break;

						default:
							booInformacionValida = false;
							booSalida = true;
							break;
						}
						
					}else {
						booSalida = true;
					}
					
				}		
				
			}
			
		} catch (Exception e) {
			throw e;
			//e.printStackTrace();
		}
		
		
		if (!booCampoValido) {
			
			booLectorOk = false;
			this.setBooProcesoLectorOk(booLectorOk);
			strMensaje = "";
			strMensaje = "El parametro [VACOLEDD] se encuentra mal configurado o no cuenta con los siguientes valores de comparacion: " + "\n" +
					     "(documento|nombres|apellido1,apellido2)." + "\n" + "Por favor configurar en forma PASI.";
			
			this.setMensaje(strMensaje);
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
			   		 										"CAMPO_LECTOR",
			   		 										strMensaje);

		}else if (!booInformacionValida) {
			
			booLectorOk = false;
			this.setBooProcesoLectorOk(booLectorOk);
			strMensaje = "";
			strMensaje = "La informacion del docuemento: " + pobjTercero.getIdentificacion() + "\n" +
					     "no corresponde a la informacion del lector BENEFICIARIO: " + objInfoCedula.getDocumento() ;
			
			this.setMensaje(strMensaje);
		
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
			   		 										"INFO_LECTOR",
			   		 										strMensaje);
			 

		}
		
		this.setBooProcesoLectorOk(booLectorOk);
		this.setMensaje(strMensaje);
		
	}
	
	/**
	 * @method getBooProcesoLectorOk
	 * 		   Metodo get del atributo booProcesoLectorOk
	 * @return booProcesoLectorOk
	 *		   Valor del atributo booProcesoLectorOk devuelto
	 * @author Jefferson Ruiz
	 * @date   10/09/2019
	 */
	public Boolean getBooProcesoLectorOk() {
		return this.booProcesoLectorOk;
	}
	
	/**
	 * @method setBooProcesoLectorOk
	 * 		   Metodo set del atributo booProcesoLectorOk
	 * @param  objUsuario
	 *		   Valor que tomara el atributo booProcesoLectorOk
	 * @author Jefferson Ruiz
	 * @date   10/09/2019
	 */
	public void setBooProcesoLectorOk(Boolean pbooProcesoLectorOk) {
		this.booProcesoLectorOk = pbooProcesoLectorOk;
	}
	
	/**
	 * @method getMensaje
	 * 		   Metodo get del atributo strMensaje
	 * @return strMensaje
	 *		   Valor del atributo strMensaje devuelto
	 * @author Jefferson Ruiz
	 * @date   10/09/2019
	 */
	public String getMensaje() {
		return this.strMensaje;
	}
	
	/**
	 * @method setBooProcesoLectorOk
	 * 		   Metodo set del atributo booProcesoLectorOk
	 * @param  objUsuario
	 *		   Valor que tomara el atributo booProcesoLectorOk
	 * @author Jefferson Ruiz
	 * @date   10/09/2019
	 */
	public void setMensaje(String pstrMensaje) {
		this.strMensaje = pstrMensaje;
	}
	
	

}

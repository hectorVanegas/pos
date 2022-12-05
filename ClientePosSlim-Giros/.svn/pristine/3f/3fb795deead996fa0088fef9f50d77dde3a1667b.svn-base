package co.com.codesa.clienteposslimgiros.vista.logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.codesawrapper.modelo.dominio.ParametroSistema;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.utilidades.RespuestaTramaGiros;

public class ControlConsultaPasiVistaLogica {

	private static ControlConsultaPasiVistaLogica instancia;
	public static Boolean booCargueInicial = false;
	
	/**
	 * @variable strIdremexc
	 * 			 Variable para almacenar el valor del parametro de sistema IDREMEXC
	 */
	private String strIdremexc;
	/**
	 * @variable strIdbenexc
	 * 			 Variable para almacenar el valor del parametro de sistema IDBENEXC
	 */
	private String strIdbenexc;
	/**
	 * @variable booSercotir
	 * 			 Variable para almacenar el valor del parametro de sistema SERCOTIR
	 */
	private Boolean booSercotir;
	/**
	 * @variable strIdtecoti
	 * 			 Variable para almacenar el valor del parametro de sistema IDTECOTI
	 */
	private String strIdtecoti;
	/**
	 * @variable strCodcrcpr
	 * 			 Variable para almacenar el valor del parametro de sistema CODCRCPR
	 */
	private String strCodcrcpr;
	/**
	 * @variable strCodcrcel
	 * 			 Variable para almacenar el valor del parametro de sistema CODCRCEL
	 */
	private String strCodcrcel;
	/**
	 * @variable booSercoenv
	 * 			 Variable para almacenar el valor del parametro de sistema SERCOENV
	 */
	private Boolean booSercoenv;
	/**
	 * @variable booSercopag
	 * 			 Variable para almacenar el valor del parametro de sistema SERCOPAG
	 */
	private Boolean booSercopag;
	/**
	 * @variable booSercocbf
	 * 			 Variable para almacenar el valor del parametro de sistema SERCOCBF
	 */
	private Boolean booSercocbf;
	/**
	 * @variable strCodcrcpc
	 * 			 Variable para almacenar el valor del parametro de sistema CODCRCPC
	 */
	private String strCodcrcpc;
	/**
	 * @variable strtesenrve
	 * 			 Variable para almacenar el valor del parametro de sistema TESENRVE
	 */
	private String strTesenrve;
	/**
	 * @variable strtesolecd
	 * 			 Variable para almacenar el valor del parametro de sistema TESOLECD
	 */
	private String strTesolecd;
	/**
	 * @variable strTesolbio
	 * 			 Variable para almacenar el valor del parametro de sistema TESOLBIO
	 */
	private String strTesolbio;
	/**
	 * @variable strVacoledd
	 * 			 Variable para almacenar el valor del parametro de sistema VACOLEDD
	 */
	private String strVacoledd;
	/**
	 * @variable strVainetld
	 * 			 Variable para almacenar el valor del parametro de sistema VAINETLD
	 */
	private String strVainetld;
	/**
	 * @variable strMarccode
	 * 			 Variable para almacenar el valor del parametro de sistema MARCCODE
	 */
	private String strMarccode;


	
	/**
	 * ****************************************************************.
	 * @metodo: ControlConfiguracionPasiVistaLogica
	 * @descripcion: contructor de la logica.
	 * @autor: Jefferson Ruiz
	 * @date: 16/09/2019
	 * ****************************************************************
	 */
	public ControlConsultaPasiVistaLogica(){}
	
	/**
	 * ****************************************************************.
	 * @metodo: getInstance
	 * @descripcion: metodo para cumplir con el patron singleton y tener
	 * una unica instancia de la clase para se accedida.
	 * @autor: Jefferson Ruiz
	 * ****************************************************************
	 */
	public static ControlConsultaPasiVistaLogica getInstance(){		
		if (instancia == null){
			booCargueInicial = true;
			instancia= new ControlConsultaPasiVistaLogica();
		}else {
			booCargueInicial = false;
		}
			
		
		return instancia;
	}
	
	public void LlenarMemoriaParametros(Usuario pobjUsuario) throws Exception{
		
		List<String> lstParametros;
		HashMap<String,ParametroSistema> hmParametrosSistema = null;
		String strParametro;
		
		lstParametros = new ArrayList<String>();
		
		lstParametros.add(EnumParametrosSistema.ID_TERCERO_EXCLUIDOS_REMITENTES.getStrCodigo());
		lstParametros.add(EnumParametrosSistema.ID_TERCERO_EXCLUIDOS_BENEFICIARIOS.getStrCodigo());
		lstParametros.add(EnumParametrosSistema.ACTIVA_SERVICIO_PRUEBA_ADMISIONENTREGA_TIRILLA.getStrCodigo());
		lstParametros.add(EnumParametrosSistema.TIPO_ID_IDENTIFICACION_TERCERO_PRUEBA_ADMISIONENTREGA_TIRILLA.getStrCodigo());
		lstParametros.add(EnumParametrosSistema.ID_PRUEBA_EN_FORMATO_FISICO.getStrCodigo());
		lstParametros.add(EnumParametrosSistema.ID_PRUEBA_EN_FORMATO_ELECTRONICO.getStrCodigo());
		lstParametros.add(EnumParametrosSistema.ID_PASI_PRUEBA_CRC_SERVICIO_CELULAR_ENVIO.getStrCodigo());
		lstParametros.add(EnumParametrosSistema.ID_PASI_PRUEBA_CRC_SERVICIO_CELULAR_PAGO.getStrCodigo());
		lstParametros.add(EnumParametrosSistema.ID_PASI_PRUEBA_CRC_SERVICIO_CELULAR_CAMBIOBENEFICIARIO.getStrCodigo());
		lstParametros.add(EnumParametrosSistema.ID_PASI_PRUEBA_CRC_CODIGO_ADMSION_ENTREGA.getStrCodigo());
		lstParametros.add(EnumParametrosSistema.TERCEROS_CONVENIO_VERIFICACION_DESPUES_ENROLAMIENTO.getStrCodigo());
		lstParametros.add(EnumParametrosSistema.TERCEROS_CONVENIO_VERIFICACION_LECTOR2D.getStrCodigo());
		//lstParametros.add(EnumParametrosSistema.TERCEROS_CONVENIO_VERIFICACION_BIOMETRIA_LECTOR2D.getStrCodigo());
		lstParametros.add(EnumParametrosSistema.VALORES_A_COMPARAR_LECTOR_2D.getStrCodigo());
		lstParametros.add(EnumParametrosSistema.MENSAJE_LECTOR_2D.getStrCodigo());
		lstParametros.add(EnumParametrosSistema.VALOR_CORREOS_TERCEROS_NO_SUMINISTRADO_CRC.getStrCodigo());
		
		hmParametrosSistema = ParametroSistemaVistaLogica.getInstance().consultarParametrosBD(pobjUsuario,
																							 lstParametros);
		
		if (hmParametrosSistema != null) {
			
			for(ParametroSistema objParametroSistema: hmParametrosSistema.values()){
				
				switch (objParametroSistema.getCodigo()) {
				case "SERCOPAG":
					if (objParametroSistema.getValor().equals("S")) {
						this.setSercopag(true);
					}else {
						this.setSercopag(false);
					}
					break;
				case "IDREMEXC":
					this.setIdremexc(objParametroSistema.getValor());
					break;
				case "SERCOENV":
					if (objParametroSistema.getValor().equals("S")) {
						this.setSercoenv(true);
					}else {
						this.setSercoenv(false);
					}
					break;
				case "IDBENEXC":
					this.setIdbenexc(objParametroSistema.getValor());
					break;
				case "SERCOTIR":
					if (objParametroSistema.getValor().equals("S")) {
						this.setSercotir(true);
					}else {
						this.setSercotir(false);
					}
					break;
				case "CODCRCPC":
					this.setCodcrcpc(objParametroSistema.getValor());
					break;
				case "CODCRCPR":
					this.setCodcrcpr(objParametroSistema.getValor());
					break;
				case "SERCOCBF":
					if (objParametroSistema.getValor().equals("S")) {
						this.setSercocbf(true);
					}else {
						this.setSercocbf(false);
					}
					break;
				case "CODCRCEL":
					this.setCodcrcel(objParametroSistema.getValor());
					break;
				case "IDTECOTI":
					this.setIdtecotir(objParametroSistema.getValor());
					break;
				case "TESENRVE":
					this.setTesenrve(objParametroSistema.getValor());
					break;
				case "TESOLECD":
					this.setTesolecd(objParametroSistema.getValor());
					break;
				case "TESOLBIO":
					this.setTesolbio(objParametroSistema.getValor());
					break;
				case "VACOLEDD":
					this.setVacoledd(objParametroSistema.getValor());
					break;
				case "VAINETLD":
					this.setVainetld(objParametroSistema.getValor());
					break;
				case "MARCCODE":
					this.setMarccode(objParametroSistema.getValor());
					break;
					
				default:
					break;
				}
				
			}
			
		}else {
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
															"CAMPO_PASI",
															"No se encontraron los parametros de sistemas especificados");
			
		}
		
	}
	
	
	/**
	 * @method getIdremexc
	 * 		   Metodo get del atributo strIdremexc
	 * @return strIdremexc
	 *		   Valor del atributo strIdremexc devuelto
	 * @author Jefferson Ruiz
	 * @date   16/09/2019
	 */
	public String getIdremexc() {
		return strIdremexc;
	}

	/**
	 * @method setIdremexc
	 * 		   Metodo set del atributo strIdremexc
	 * @param  setIdremexc
	 *		   Valor que tomara el atributo strIdremexc
	 * @author Jefferson Ruiz
	 * @date   16/09/2019
	 */
	public void setIdremexc(String pstrIdremexc) {
		this.strIdremexc = pstrIdremexc;
	}
	
	/**
	 * @method getIdbenexc
	 * 		   Metodo get del atributo strIdbenexc
	 * @return strIdremexc
	 *		   Valor del atributo strIdbenexc devuelto
	 * @author Jefferson Ruiz
	 * @date   16/09/2019
	 */
	public String getIdbenexc() {
		return this.strIdbenexc;
	}

	/**
	 * @method setIdbenexc
	 * 		   Metodo set del atributo strIdbenexc
	 * @param  setIdbenexc
	 *		   Valor que tomara el atributo strIdbenexc
	 * @author Jefferson Ruiz
	 * @date   16/09/2019
	 */
	public void setIdbenexc(String pstrIdbenexc) {
		this.strIdbenexc = pstrIdbenexc;
	}
	
	/**
	 * @method getSercotir
	 * 		   Metodo get del atributo strSercotir
	 * @return strIdremexc
	 *		   Valor del atributo strSercotir devuelto
	 * @author Jefferson Ruiz
	 * @date   16/09/2019
	 */
	public Boolean getSercotir() {
		return this.booSercotir;
	}

	/**
	 * @method setSercotir
	 * 		   Metodo set del atributo strSercotir
	 * @param  setSercotir
	 *		   Valor que tomara el atributo strSercotir
	 * @author Jefferson Ruiz
	 * @date   16/09/2019
	 */
	public void setSercotir(Boolean pbooSercotir) {
		this.booSercotir = pbooSercotir;
	}
	
	/**
	 * @method getIdtecoti
	 * 		   Metodo get del atributo strIdtecoti
	 * @return strIdtecoti
	 *		   Valor del atributo strIdtecoti devuelto
	 * @author Jefferson Ruiz
	 * @date   16/09/2019
	 */
	public String getIdtecoti() {
		return this.strIdtecoti;
	}

	/**
	 * @method setIdtecoti
	 * 		   Metodo set del atributo strIdtecoti
	 * @param  setIdtecotir
	 *		   Valor que tomara el atributo strIdtecoti
	 * @author Jefferson Ruiz
	 * @date   16/09/2019
	 */
	public void setIdtecotir(String pstrIdtecoti) {
		this.strIdtecoti = pstrIdtecoti;
	}
	
	/**
	 * @method getCodcrcpr
	 * 		   Metodo get del atributo strCodcrcpr
	 * @return strCodcrcpr
	 *		   Valor del atributo strCodcrcpr devuelto
	 * @author Jefferson Ruiz
	 * @date   16/09/2019
	 */
	public String getCodcrcpr() {
		return this.strCodcrcpr;
	}

	/**
	 * @method setCodcrcpr
	 * 		   Metodo set del atributo strCodcrcpr
	 * @param  setCodcrcpr
	 *		   Valor que tomara el atributo strCodcrcpr
	 * @author Jefferson Ruiz
	 * @date   16/09/2019
	 */
	public void setCodcrcpr(String pstrCodcrcpr) {
		this.strCodcrcpr = pstrCodcrcpr;
	}
	
	/**
	 * @method getCodcrcel
	 * 		   Metodo get del atributo strCodcrcel
	 * @return strCodcrcel
	 *		   Valor del atributo strCodcrcel devuelto
	 * @author Jefferson Ruiz
	 * @date   16/09/2019
	 */
	public String getCodcrcel() {
		return this.strCodcrcel;
	}

	/**
	 * @method setCodcrcel
	 * 		   Metodo set del atributo strCodcrcel
	 * @param  setCodcrcel
	 *		   Valor que tomara el atributo strCodcrcel
	 * @author Jefferson Ruiz
	 * @date   16/09/2019
	 */
	public void setCodcrcel(String pstrCodcrcel) {
		this.strCodcrcel = pstrCodcrcel;
	}
	
	/**
	 * @method getSercoenv
	 * 		   Metodo get del atributo strSercoenv
	 * @return strSercoenv
	 *		   Valor del atributo strSercoenv devuelto
	 * @author Jefferson Ruiz
	 * @date   16/09/2019
	 */
	public Boolean getSercoenv() {
		return this.booSercoenv;
	}

	/**
	 * @method setSercoenv
	 * 		   Metodo set del atributo strSercoenv
	 * @param  setSercoenv
	 *		   Valor que tomara el atributo strSercoenv
	 * @author Jefferson Ruiz
	 * @date   16/09/2019
	 */
	public void setSercoenv(Boolean pbooSercoenv) {
		this.booSercoenv = pbooSercoenv;
	}
	
	/**
	 * @method getSercopag
	 * 		   Metodo get del atributo strSercopag
	 * @return strSercopag
	 *		   Valor del atributo strSercopag devuelto
	 * @author Jefferson Ruiz
	 * @date   16/09/2019
	 */
	public Boolean getSercopag() {
		return this.booSercopag;
	}

	/**
	 * @method setSercopag
	 * 		   Metodo set del atributo strSercopag
	 * @param  setSercopag
	 *		   Valor que tomara el atributo strSercopag
	 * @author Jefferson Ruiz
	 * @date   16/09/2019
	 */
	public void setSercopag(Boolean pbooSercopag) {
		this.booSercopag = pbooSercopag;
	}
	
	/**
	 * @method getSercocbf
	 * 		   Metodo get del atributo strSercocbf
	 * @return strSercocbf
	 *		   Valor del atributo strSercocbf devuelto
	 * @author Jefferson Ruiz
	 * @date   16/09/2019
	 */
	public Boolean getSercocbf() {
		return this.booSercocbf;
	}

	/**
	 * @method setSercocbf
	 * 		   Metodo set del atributo strSercocbf
	 * @param  setSercocbf
	 *		   Valor que tomara el atributo strSercocbf
	 * @author Jefferson Ruiz
	 * @date   16/09/2019
	 */
	public void setSercocbf(Boolean pbooSercocbf) {
		this.booSercocbf = pbooSercocbf;
	}
	
	/**
	 * @method getCodcrcpc
	 * 		   Metodo get del atributo strCodcrcpc
	 * @return strCodcrcpc
	 *		   Valor del atributo strSercocbf devuelto
	 * @author Jefferson Ruiz
	 * @date   16/09/2019
	 */
	public String getCodcrcpc() {
		return this.strCodcrcpc;
	}

	/**
	 * @method setCodcrcpc
	 * 		   Metodo set del atributo strCodcrcpc
	 * @param  setCodcrcpc
	 *		   Valor que tomara el atributo strCodcrcpc
	 * @author Jefferson Ruiz
	 * @date   16/09/2019
	 */
	public void setCodcrcpc(String pstrCodcrcpc) {
		this.strCodcrcpc = pstrCodcrcpc;
	}
	
	/**
	 * @method getTesenrve
	 * 		   Metodo get del atributo strTesenrve
	 * @return strTesenrve
	 *		   Valor del atributo strTesenrve devuelto
	 * @author Jefferson Ruiz
	 * @date   16/09/2019
	 */
	public String getTesenrve() {
		return this.strTesenrve;
	}

	/**
	 * @method setTesenrve
	 * 		   Metodo set del atributo strTesenrve
	 * @param  setTesenrve
	 *		   Valor que tomara el atributo strTesenrve
	 * @author Jefferson Ruiz
	 * @date   16/09/2019
	 */
	public void setTesenrve(String pstrTesenrve) {
		this.strTesenrve = pstrTesenrve;
	}
	
	/**
	 * @method getTesolecd
	 * 		   Metodo get del atributo strTesolecd
	 * @return strTesolecd
	 *		   Valor del atributo strTesenrve devuelto
	 * @author Jefferson Ruiz
	 * @date   16/09/2019
	 */
	public String getTesolecd() {
		return this.strTesolecd;
	}

	/**
	 * @method setTesolecd
	 * 		   Metodo set del atributo strTesolecd
	 * @param  setTesenrve
	 *		   Valor que tomara el atributo strTesolecd
	 * @author Jefferson Ruiz
	 * @date   16/09/2019
	 */
	public void setTesolecd(String pstrTesolecd) {
		this.strTesolecd = pstrTesolecd;
	}
	
	/**
	 * @method getTesolbio
	 * 		   Metodo get del atributo strTesolbio
	 * @return strTesolbio
	 *		   Valor del atributo strTesolbio devuelto
	 * @author Jefferson Ruiz
	 * @date   16/09/2019
	 */
	public String getTesolbio() {
		return this.strTesolbio;
	}

	/**
	 * @method setTesolbio
	 * 		   Metodo set del atributo strTesolbio
	 * @param  setTesolbio
	 *		   Valor que tomara el atributo strTesolbio
	 * @author Jefferson Ruiz
	 * @date   16/09/2019
	 */
	public void setTesolbio(String pstrTesolbio) {
		this.strTesolbio = pstrTesolbio;
	}
	
	/**
	 * @method getVacoledd
	 * 		   Metodo get del atributo strVacoledd
	 * @return strVacoledd
	 *		   Valor del atributo strVacoledd devuelto
	 * @author Jefferson Ruiz
	 * @date   16/09/2019
	 */
	public String getVacoledd() {
		return this.strVacoledd;
	}

	/**
	 * @method setVacoledd
	 * 		   Metodo set del atributo strVacoledd
	 * @param  setVacoledd
	 *		   Valor que tomara el atributo strVacoledd
	 * @author Jefferson Ruiz
	 * @date   16/09/2019
	 */
	public void setVacoledd(String pstrVacoledd) {
		this.strVacoledd = pstrVacoledd;
	}
	
	/**
	 * @method getVainetld
	 * 		   Metodo get del atributo strVainetld
	 * @return strVainetld
	 *		   Valor del atributo strVainetld devuelto
	 * @author Jefferson Ruiz
	 * @date   16/09/2019
	 */
	public String getVainetld() {
		return this.strVainetld;
	}

	/**
	 * @method setVainetld
	 * 		   Metodo set del atributo strVainetld
	 * @param  setVainetld
	 *		   Valor que tomara el atributo strVainetld
	 * @author Jefferson Ruiz
	 * @date   16/09/2019
	 */
	public void setVainetld(String pstrVainetld) {
		this.strVainetld = pstrVainetld;
	}
	
	/**
	 * @method getMarccode
	 * 		   Metodo get del atributo strMarccode
	 * @return strMarccode
	 *		   Valor del atributo strMarccode devuelto
	 * @author Jefferson Ruiz
	 * @date   16/09/2019
	 */
	public String getMarccode() {
		return this.strMarccode;
	}

	/**
	 * @method setMarccode
	 * 		   Metodo set del atributo strMarccode
	 * @param  setMarccode
	 *		   Valor que tomara el atributo strMarccode
	 * @author Jefferson Ruiz
	 * @date   16/09/2019
	 */
	public void setMarccode(String pstrMarccode) {
		this.strMarccode = pstrMarccode;
	}
	
}

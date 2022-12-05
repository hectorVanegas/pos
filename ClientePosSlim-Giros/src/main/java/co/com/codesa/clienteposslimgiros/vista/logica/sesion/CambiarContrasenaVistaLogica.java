package co.com.codesa.clienteposslimgiros.vista.logica.sesion;

import co.com.codesa.clienteposslim.general.InformacionSession;
import co.com.codesa.clienteposslimcontrolador.conexion.ProcesadorTramas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.utilidades.vistaLogica.UtilVistaLogica;
import co.com.codesa.codesawrapper.modelo.dominio.CambiarClaveSims;
import co.com.codesa.codesawrapper.modelo.dominio.RespuestaCambiarClaveSims;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.CambiarContrasena;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaCambiarContrasena;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaVerificaClaveSeguridad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;

public class CambiarContrasenaVistaLogica {

	/**
	 * ****************************************************************.
	 * 
	 * @autor: VictorE Torres
	 * @fecha: 31-mar-2015
	 * @descripcion: clase encargada del cambio de contraseña vista logica .
	 * @copyright: Copyright 1998-2015 Codesa, Todos los derechos reservados.
	 *             ***
	 *             *************************************************************
	 */

	private static CambiarContrasenaVistaLogica instancia;

	/**
	 * ****************************************************************.
	 * 
	 * @metodo: AgenciaVistaLogica
	 * @descripcion: contructor de la logica.
	 * @autor: Victor.Torres
	 *         ****************************************************************
	 */
	private CambiarContrasenaVistaLogica() {
	}

	/**
	 * ****************************************************************.
	 * 
	 * @metodo: getInstance
	 * @descripcion: metodo para cumplir con el patron singleton y tener una
	 *               unica instancia de la clase para se accedida.
	 * @autor: Victor.Torres
	 *         ****************************************************************
	 */
	public static CambiarContrasenaVistaLogica getInstance() {
		if (instancia == null)
			instancia = new CambiarContrasenaVistaLogica();

		return instancia;
	}

	public String cambiarContrasena(Usuario pObjUsuarioSistema,
									String pStrContrasenaAntigua, 
									String pStrContrasenaNueva,
									String pStrLogin, 
									boolean pBooSincronizarEquivalencia)throws Exception {

		CambiarContrasena objEnvioTrama;
		RespuestaCambiarContrasena objRespuestaTrama;
		String strFechaCambio = null;

		objEnvioTrama = new CambiarContrasena(pObjUsuarioSistema,
											  pStrContrasenaAntigua,
											  pStrContrasenaNueva);

		//objRespuestaTrama = (RespuestaCambiarContrasena) ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaCambiarContrasena)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama
				.getValorAtributoObj("tipoResultado")
				.toString()
				.equalsIgnoreCase(
						EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA
								.getValor())) {

			strFechaCambio = (String) objRespuestaTrama
					.getValorAtributoObj("fechaCambio");

			if (pBooSincronizarEquivalencia) {

				this.cambiarContrasenaSims(InformacionSession.getInstance()
						.getLogin(), InformacionSession.getInstance()
						.getClaveUsuario(), pStrLogin, pStrContrasenaAntigua,
						pStrContrasenaNueva);
			}

		} else {

			throw EnumMensajes.generarExcepcionPersonalizada(
					EnumClasesMensaje.ERROR, (String) objRespuestaTrama
							.getValorAtributoObj("codigoError"),
					(String) objRespuestaTrama
							.getValorAtributoObj("descripcionError"));
		}

		return strFechaCambio;
	}

	public void cambiarContrasenaSims(String loginSlim, String passSlim,
			String loginSims, String passOldSims, String passNewSims)
			throws Exception {

		if (loginSims != null && !loginSims.equals("") && passOldSims != null
				&& !passOldSims.equals("")) {
			CambiarClaveSims cambiarClaveSims = new CambiarClaveSims(loginSlim,
					passSlim, loginSims, passOldSims, passNewSims);

			//RespuestaCambiarClaveSims respuestaCambiarClaveSims = (RespuestaCambiarClaveSims) ProcesadorTramas.getInstance().procesarPeticion(cambiarClaveSims);
			RespuestaCambiarClaveSims respuestaCambiarClaveSims = (RespuestaCambiarClaveSims)UtilVistaLogica.getInstance().realizarPeticion(cambiarClaveSims);

			if ((respuestaCambiarClaveSims.getValorAtributo("tipoRespuesta")
					.toString()).equals("1")) {
				throw new Exception(
						(String)respuestaCambiarClaveSims
								.getValorAtributo("error"));

			} else {
				InformacionSession.getInstance().setUsuLoginSims(loginSims);
				InformacionSession.getInstance().setUsuPassSims(passNewSims);
			}
		}

	}
}

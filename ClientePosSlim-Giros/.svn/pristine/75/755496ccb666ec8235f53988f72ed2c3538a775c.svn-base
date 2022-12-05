package co.com.codesa.clienteposslimgiros.enumeraciones;

import javax.print.PrintException;

import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion.ProcesarVariablesImpresion;
import co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion.ProcesarVariablesImpresionAnulacionGiro;
import co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion.ProcesarVariablesImpresionAnulacionGiroAutorizada;
import co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion.ProcesarVariablesImpresionAnulacionRecaudo;
import co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion.ProcesarVariablesImpresionCambioBeneficiario;
import co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion.ProcesarVariablesImpresionCierreCaja;
import co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion.ProcesarVariablesImpresionEnvioGiroInternacional;
import co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion.ProcesarVariablesImpresionEnvioGiroPostal;
import co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion.ProcesarVariablesImpresionEnvioRecaudo;
import co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion.ProcesarVariablesImpresionIngresoEgreso;
import co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion.ProcesarVariablesImpresionPQR;
import co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion.ProcesarVariablesImpresionPagoGiroInternacional;
import co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion.ProcesarVariablesImpresionPagoGiroPostal;
import co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion.ProcesarVariablesImpresionPagoRecaudo;
import co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion.ProcesarVariablesImpresionPrueba;
import co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion.ProcesarVariablesImpresionROE;
import co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion.ProcesarVariablesImpresionSMS;
import co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion.ProcesarVariablesImpresionSMSInternacional;
import co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion.ProcesarVariablesImpresionSeguro;
import co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion.ProcesarVariablesImpresionSeguroInternacional;
import co.com.codesa.clienteposslimgiros.utilidades.impresiones.variablesImpresion.ProcesarVariablesPreImpresionPagoGiroDomiciliado;
import co.com.codesa.clienteposslimgiros.vista.logica.impresion.ImpresionVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.VariablesImpresion;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionAnulacionGiroAutorizadaDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionAnulacionGiroDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionAnulacionRecaudoDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionCambioBeneficiarioDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionCierreCajaDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionEnvioGiroInternacionalDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionEnvioGiroPostalDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionEnvioRecaudoDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionIngresoEgresoDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionPQRDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionPagoGiroInternacionalDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionPagoGiroPostalDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionPagoRecaudoDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionPruebaDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionROEDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionSMSDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionSMSInternacionalDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionSeguroDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionSeguroInternacionalDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesPreImpresionPagoGiroDomiciliadoDTO;

public enum EnumImpresiones {

	PAGINA_PRUEBA(EnumParametrosSistema.PAGINA_PRUEBA,
			VariablesImpresionPruebaDTO.class,
			ProcesarVariablesImpresionPrueba.class),

	ENVIO_GIRO_POSTAL(
			EnumParametrosSistema.NOMBRE_FORMATO_IMPRESION_ENVIO_GIRO_POSTAL_CRC,
			VariablesImpresionEnvioGiroPostalDTO.class,
			ProcesarVariablesImpresionEnvioGiroPostal.class),

	PAGO_GIRO_POSTAL(
			EnumParametrosSistema.NOMBRE_FORMATO_IMPRESION_PAGO_GIRO_POSTAL_CRC,
			VariablesImpresionPagoGiroPostalDTO.class,
			ProcesarVariablesImpresionPagoGiroPostal.class),

	PRE_IMPRESION_PAGO_GIRO_DOMICILIADO(
			EnumParametrosSistema.NOMBRE_FORMATO_PRE_IMPRESION_PAGO_GIRO_DOMICILIADO,
			VariablesPreImpresionPagoGiroDomiciliadoDTO.class,
			ProcesarVariablesPreImpresionPagoGiroDomiciliado.class),

	ANULACION_GIRO(
			EnumParametrosSistema.NOMBRE_FORMATO_IMPRESION_ANULACION_GIRO,
			VariablesImpresionAnulacionGiroDTO.class,
			ProcesarVariablesImpresionAnulacionGiro.class),

	ANULACION_GIRO_AUTORIZADA(
			EnumParametrosSistema.NOMBRE_FORMATO_IMPRESION_ANULACION_GIRO_AUTORIZADA,
			VariablesImpresionAnulacionGiroAutorizadaDTO.class,
			ProcesarVariablesImpresionAnulacionGiroAutorizada.class),

	CAMBIO_BENEFICIARIO(
			EnumParametrosSistema.NOMBRE_FORMATO_IMPRESION_CAMBIO_BENEFICIARIO_CRC,
			VariablesImpresionCambioBeneficiarioDTO.class,
			ProcesarVariablesImpresionCambioBeneficiario.class),

	ROE(EnumParametrosSistema.NOMBRE_FORMATO_IMPRESION_ROE,
			VariablesImpresionROEDTO.class, ProcesarVariablesImpresionROE.class),

	SEGURO(EnumParametrosSistema.NOMBRE_FORMATO_IMPRESION_SEGURO,
			VariablesImpresionSeguroDTO.class,
			ProcesarVariablesImpresionSeguro.class),

	SMS(EnumParametrosSistema.NOMBRE_FORMATO_IMPRESION_SMS,
			VariablesImpresionSMSDTO.class, ProcesarVariablesImpresionSMS.class),

	ENVIO_RECAUDO(EnumParametrosSistema.NOMBRE_FORMATO_IMPRESION_ENVIO_RECAUDO,
			VariablesImpresionEnvioRecaudoDTO.class,
			ProcesarVariablesImpresionEnvioRecaudo.class),

	PAGO_RECAUDO(EnumParametrosSistema.NOMBRE_FORMATO_IMPRESION_PAGO_RECAUDO,
			VariablesImpresionPagoRecaudoDTO.class,
			ProcesarVariablesImpresionPagoRecaudo.class),

	ANULACION_RECAUDO(
			EnumParametrosSistema.NOMBRE_FORMATO_IMPRESION_ANULACION_RECAUDO,
			VariablesImpresionAnulacionRecaudoDTO.class,
			ProcesarVariablesImpresionAnulacionRecaudo.class),

	INGRESO_EGRESO(
			EnumParametrosSistema.NOMBRE_FORMATO_IMPRESION_INGRESO_EGRESO,
			VariablesImpresionIngresoEgresoDTO.class,
			ProcesarVariablesImpresionIngresoEgreso.class),

	CIERRE_CAJA(EnumParametrosSistema.NOMBRE_FORMATO_IMPRESION_CIERRE_CAJA,
			VariablesImpresionCierreCajaDTO.class,
			ProcesarVariablesImpresionCierreCaja.class),

	PAGO_GIRO_INTERNACIONAL(
			EnumParametrosSistema.NOMBRE_FORMATO_IMPRESION_PAGO_GIRO_INTERNACIONAL,
			VariablesImpresionPagoGiroInternacionalDTO.class,
			ProcesarVariablesImpresionPagoGiroInternacional.class),

	SEGURO_INTERNACIONAL(
			EnumParametrosSistema.NOMBRE_FORMATO_IMPRESION_SEGURO_INTERNACIONAL,
			VariablesImpresionSeguroInternacionalDTO.class,
			ProcesarVariablesImpresionSeguroInternacional.class),

	SMS_INTERNACIONAL(
			EnumParametrosSistema.NOMBRE_FORMATO_IMPRESION_SMS_INTERNACIONAL,
			VariablesImpresionSMSInternacionalDTO.class,
			ProcesarVariablesImpresionSMSInternacional.class),

	ENVIO_GIRO_INTERNACIONAL(
			EnumParametrosSistema.NOMBRE_FORMATO_IMPRESION_ENVIO_GIRO_INTERNACIONAL,
			VariablesImpresionEnvioGiroInternacionalDTO.class,
			ProcesarVariablesImpresionEnvioGiroInternacional.class),

	PQR(EnumParametrosSistema.NOMBRE_FORMATO_IMPRESION_PQR,
			VariablesImpresionPQRDTO.class, ProcesarVariablesImpresionPQR.class),

	DUPLICADO_PQR(EnumParametrosSistema.NOMBRE_FORMATO_IMPRESION_PQR,
			VariablesImpresionPQRDTO.class, ProcesarVariablesImpresionPQR.class);

	/**
	 * @variable enmParSisNombreFormato Parametro del sistema que contiene el
	 *           nombre del formato de impresion
	 **/
	private EnumParametrosSistema enmParSisNombreFormato;

	/**
	 * @variable clsVariablesImpresion Clase representativa del objeto DTO que
	 *           administrara las variables de impresion que se relacionaran
	 *           sobre el formato, este objeto debe ser diligenciado durante el
	 *           procesamiento de la trama, idealmente deberia ser enviado como
	 *           parametro sobre la entidadTrama envio y ser diligenciado por la
	 *           entidadTrama respuesta
	 **/
	private Class<? extends VariablesImpresionDTO> clsVariablesImpresionDTO;

	/**
	 * @variable clsProcesarVariablesImpresion Clase representativa del objeto
	 *           encargado de procesar las variables de impresion
	 **/
	private Class<? extends ProcesarVariablesImpresion> clsProcesarVariablesImpresion;

	private EnumImpresiones(
			EnumParametrosSistema pEnmParSisNombreFormato,
			Class<? extends VariablesImpresionDTO> pClsVariablesImpresionDTO,
			Class<? extends ProcesarVariablesImpresion> pClsProcesarVariablesImpresion) {

		this.setEnmParSisNombreFormato(pEnmParSisNombreFormato);
		this.setClsVariablesImpresionDTO(pClsVariablesImpresionDTO);
		this.setClsProcesarVariablesImpresion(pClsProcesarVariablesImpresion);
	}

	public boolean ejecutarImpresion(FormaGenerica pFrmGnrVentana,
			boolean pBooReimpresion, Object... pArrObjetos) throws Exception {

		return this.ejecutarImpresion(pFrmGnrVentana, pBooReimpresion, null,
				pArrObjetos);
	}

	public boolean ejecutarImpresion(FormaGenerica pFrmGnrVentana,
			boolean pBooReimpresion,
			VariablesImpresionDTO pObjDtoVariablesImpresion,
			Object... pArrObjetos) throws Exception {

		Class<?> arrClsObjetos[];
		EnumTiposImpresora enmTipoImpresora;
		VariablesImpresion objVariablesImpresion;
		// ResultadoImpresion objResultadoImpresion;
		String strCadenaImpresion;
		String strNombreImpresoraConfigurada;
		String strNombreImpresora;
		String strTipoReimpresion;
		boolean booResultado;

		try {

			objVariablesImpresion = null;
			enmTipoImpresora = ImpresionVistaLogica.getInstancia()
					.obtenerTipoImpresora();

			if (enmTipoImpresora == null) {

				throw EnumMensajes.TIPO_IMPRESORA_NO_CONFIGURADA
						.generarExcepcion(EnumClasesMensaje.ERROR);
			}

			strNombreImpresoraConfigurada = enmTipoImpresora
					.getEnmCnfNombreImpresora().obtenerValor();

			strNombreImpresora = (strNombreImpresoraConfigurada == null || strNombreImpresoraConfigurada
					.isEmpty()) ? "Predeterminada"
					: strNombreImpresoraConfigurada;

			strTipoReimpresion = "";

			if (this.equals(EnumImpresiones.PAGINA_PRUEBA)) {

				strCadenaImpresion = enmTipoImpresora.getEnmEtiDescripcion()
						.toString()
						+ "["
						+ enmTipoImpresora.getStrAbreviatura()
						+ "]: "
						+ strNombreImpresora
						+ EnumParametrosApp.SALTO_LINEA.getValorPropiedad()
						+ EnumParametrosApp.SALTO_LINEA.getValorPropiedad()
						+ EnumEtiquetas.IMP_PAGINA_PRUEBA.toString()
						+ EnumParametrosApp.SALTO_LINEA.getValorPropiedad();
			} else {

				arrClsObjetos = UtilidadesGiros.getInstance()
						.obtenerArrayClasesObjetos(pArrObjetos);

				if (pObjDtoVariablesImpresion == null) {

					pObjDtoVariablesImpresion = this
							.getClsVariablesImpresionDTO()
							.getDeclaredConstructor(arrClsObjetos)
							.newInstance(pArrObjetos);
				}

				objVariablesImpresion = this
						.getClsProcesarVariablesImpresion()
						.getDeclaredConstructor(boolean.class,
								EnumTiposImpresora.class)
						.newInstance(pBooReimpresion, enmTipoImpresora)
						.obtenerVariablesImpresion(pObjDtoVariablesImpresion);

				strCadenaImpresion = ImpresionVistaLogica.getInstancia()
						.generarCadenaImpresion(pFrmGnrVentana.getObjUsuario(),
								this, enmTipoImpresora, objVariablesImpresion);
				if (objVariablesImpresion.isBooTipoReImpresion()) {

					strTipoReimpresion = EnumParametrosApp.ID_REIMPRESION
							.getValorPropiedad();
				}
			}

			EnumMensajes.VERIFIQUE_ANTES_DE_IMPRIMIR.desplegarMensaje(
					pFrmGnrVentana, EnumClasesMensaje.INFORMACION,
					strTipoReimpresion
							+ this.getEnmParSisNombreFormato()
									.getEnmEtiDescripcion().toString(),
					enmTipoImpresora.getEnmEtiDescripcion().toString(),
					strNombreImpresora);

			booResultado = this.enviarAImpresion(pFrmGnrVentana,
					strCadenaImpresion, strNombreImpresoraConfigurada);

			/*
			 * objResultadoImpresion = new ResultadoImpresion(enmTipoImpresora,
			 * objVariablesImpresion, strCadenaImpresion, pBooReimpresion,
			 * booResultado);
			 */

		} catch (Exception e) {

			UtilidadesGiros.getInstance().controlExcepcion(e, pFrmGnrVentana);

			booResultado = false;
		}

		return booResultado;
	}

	private boolean enviarAImpresion(FormaGenerica pFrmGnrVentana,
			String pStrCadenaImpresion, String pStrNombreImpresora)
			throws Exception {

		boolean booResultado = false;

		UtilidadesGiros.getInstance().mostrarEnConsola(
				EnumParametrosApp.SALTO_LINEA.getValorPropiedad()
						+ pStrCadenaImpresion, System.out);

		try {

			booResultado = UtilidadesGiros.getInstance().imprimir(
					pStrCadenaImpresion, pStrNombreImpresora, pFrmGnrVentana);
			// booResultado = true;

		} catch (PrintException pe) {

			pe.printStackTrace();

			throw EnumMensajes.ERROR_IMPRESION_VERIFIQUE_CONFIGURACIONES_LOCALES
					.generarExcepcion(EnumClasesMensaje.ERROR);
		}

		return booResultado;
	}

	public EnumParametrosSistema getEnmParSisNombreFormato() {
		return enmParSisNombreFormato;
	}

	public void setEnmParSisNombreFormato(
			EnumParametrosSistema enmParSisNombreFormato) {
		this.enmParSisNombreFormato = enmParSisNombreFormato;
	}

	public Class<? extends VariablesImpresionDTO> getClsVariablesImpresionDTO() {
		return clsVariablesImpresionDTO;
	}

	public void setClsVariablesImpresionDTO(
			Class<? extends VariablesImpresionDTO> clsVariablesImpresionDTO) {
		this.clsVariablesImpresionDTO = clsVariablesImpresionDTO;
	}

	public Class<? extends ProcesarVariablesImpresion> getClsProcesarVariablesImpresion() {
		return clsProcesarVariablesImpresion;
	}

	public void setClsProcesarVariablesImpresion(
			Class<? extends ProcesarVariablesImpresion> clsProcesarVariablesImpresion) {
		this.clsProcesarVariablesImpresion = clsProcesarVariablesImpresion;
	}
}

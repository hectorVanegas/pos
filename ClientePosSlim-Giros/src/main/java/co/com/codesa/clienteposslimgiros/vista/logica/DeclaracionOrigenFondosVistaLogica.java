package co.com.codesa.clienteposslimgiros.vista.logica;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.codesawrapper.modelo.dominio.ParametroSistema;

public class DeclaracionOrigenFondosVistaLogica {

	
	
	private static DeclaracionOrigenFondosVistaLogica instancia;
	
	private DeclaracionOrigenFondosVistaLogica() {}
	
	public static DeclaracionOrigenFondosVistaLogica getInstance() {
		if(instancia == null) {
			instancia = new DeclaracionOrigenFondosVistaLogica();
		}
		
		return instancia;
	}
	
	public String consultarPreguntaDOF() throws Exception {
		ParametroSistema parametroSistema = UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.PREGUNTA_DECLARACION_ORIGEN_FONDO);
		
		return parametroSistema.getValor();
	}
	
	public int consultarLongitudDOF() throws Exception {
		ParametroSistema parametroSistema = UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.LONGITUD_RESPUESTA_DECLARACION_ORIGEN_FONDO);
		
		return Integer.parseInt( parametroSistema.getValor());
	}
	
	public String consultarExpresionDOF() throws Exception {
		ParametroSistema parametroSistema = UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.EXPRESION_RESPUESTA_DECLARACION_ORIGEN_FONDO);
		
		return parametroSistema.getValor();
	}
}

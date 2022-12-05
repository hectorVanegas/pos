package co.com.codesa.clienteposslimgiros.utilidades.mensajes;

import java.text.SimpleDateFormat;
import java.util.Date;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;

public class ValidacionesGiros {

	public static void validarDateFormatoFecha(String pLabel, Date pValue, String pFormato, boolean pObligatorio)throws Exception{

		SimpleDateFormat sdf = new SimpleDateFormat(pFormato);

		if (pObligatorio) {
			if(pValue==null || pValue.equals(""))
				throw EnumMensajes.CAMPO_OBLIGATORIO.generarExcepcion(EnumClasesMensaje.ERROR, 
																pLabel);
		}

		if(pValue!=null && !pValue.equals("")){
			try {
				sdf.format(pValue);
			} catch (Exception e) {
				
				throw EnumMensajes.CAMPO_NO_CUMPLE_CON_FORMATO.generarExcepcion(EnumClasesMensaje.ERROR, 
															pLabel);
			}
		}
	}
}

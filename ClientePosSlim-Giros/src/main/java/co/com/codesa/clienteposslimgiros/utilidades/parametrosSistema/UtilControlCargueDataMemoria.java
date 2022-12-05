package co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema;

import org.apache.commons.lang.ObjectUtils.Null;

import co.com.codesa.clienteposslimgiros.vista.logica.ControlConfiguracionPasiVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.ControlConsultaPasiVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.ControlConsultaTramaVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;

public class UtilControlCargueDataMemoria {
	
private static UtilControlCargueDataMemoria instancia;
	
	private String strControl;

	/**
	 * ****************************************************************.
	 * @metodo: getInstance
	 * @descripcion: metodo para cumplir con el patron singleton y tener
	 * una unica instancia de la clase para se accedida.
	 * @autor: Jefferson Ruiz
	 * ****************************************************************
	 */
	public static UtilControlCargueDataMemoria getInstance(){		
		if (instancia == null){
			instancia= new UtilControlCargueDataMemoria();
		}
		return instancia;
	}
	
	
	public void verificarControlConfiguracionPasi(Usuario pobjUsuario,
												  String pstrCodigoServicio) throws Exception{
		
		
		this.setControl(ControlConfiguracionPasiVistaLogica.getInstance().consultarConfiguracionPasi(pobjUsuario));
		
		if (this.getControl().equals("S")) {
			
			ControlConsultaPasiVistaLogica.getInstance().LlenarMemoriaParametros(pobjUsuario);
			ControlConsultaTramaVistaLogica.getInstance().llenarMemoriaTramas(pobjUsuario, pstrCodigoServicio);
			
		}else if (this.getControl().equals("N") && ControlConsultaPasiVistaLogica.getInstance().booCargueInicial) {
			
			ControlConsultaPasiVistaLogica.getInstance().LlenarMemoriaParametros(pobjUsuario);
			ControlConsultaTramaVistaLogica.getInstance().llenarMemoriaTramas(pobjUsuario, pstrCodigoServicio);
			
		}
		
	}
	
	/**
	 * @method getControl
	 * 		   Metodo get del atributo strControl
	 * @return strControl
	 *		   Valor del atributo strControl devuelto
	 * @author Jefferson Ruiz
	 * @date   18/09/2019
	 */
	public String getControl() {
		return this.strControl;
	}

	/**
	 * @method setControl
	 * 		   Metodo set del atributo strControl
	 * @param  strControl
	 *		   Valor que tomara el atributo strControl
	 * @author Jefferson Ruiz
	 * @date   18/09/2019
	 */
	public void setControl(String pstrControl) {
		this.strControl = pstrControl;
	}

}

package co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.claveSeguridad;

import javax.swing.JDialog;
import javax.swing.JPanel;

import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.ServicioClaveSeguridadDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.serviciosAdicionales.EnumServiciosAdicionales;
import co.com.codesa.clienteposslimgiros.eventos.serviciosAdicionales.claveSeguridad.EventoFormaPanelClaveSeguridad;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.FormaPanelServicioAdicional;
import co.com.codesa.clienteposslimgiros.interfaces.serviciosAdicionales.claveSeguridad.IOperacionesClaveSeguridad;

/** 
 * ********************************************************************
 * @class  FormaPanelClaveSeguridad
 *		   Clase forma, que representa una seccion particular para 
 *		   identificar y facilitar la integracion de todo el proceso  
 *		   relacionado con clave de seguridad, hacia las funcionalidades
 *		   que lo requieran  
 * @author hector.cuenca
 * @date   7/03/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class FormaPanelClaveSeguridad extends FormaPanelServicioAdicional<ServicioClaveSeguridadDTO>{

	/**
	 * @variable serialVersionUID
	 * 			 Variable serialVersionUID
	 */
	private static final long serialVersionUID = -7734858279144273094L;
	
	/** 
	 * ********************************************************************
	 * @method FormaPanelClaveSeguridad
	 * 		   Constructor que ejecuta la inicializacion de valores y 
	 * 		   ejecucion de comportamientos inicales requeridos para
	 *         el despliegue de la forma 
	 * @param  pFrmGnrVentana
	 * 		   Representa a la funcionalidad que integra el proceso de clave
	 * 		   de seguridad
	 * @param  pStrNombreComponente
	 * 		   Nombre que recibira la seccion como tal
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author hector.cuenca
	 * @date   7/03/2016
	 * *********************************************************************
	 */
	public FormaPanelClaveSeguridad(FormaGenerica pFrmGnrVentana,
							   		String pStrNombreComponente) throws Exception {
		
		super(pFrmGnrVentana,
			  pStrNombreComponente,
			  EnumServiciosAdicionales.CLAVE_SEGURIDAD);
		
		super.setEvaControlEventos(new EventoFormaPanelClaveSeguridad(this));
		super.setOperaciones((IOperacionesClaveSeguridad)super.getEvaControlEventos());
		
		super.iniciar();
	}

	/** 
	 * ********************************************************************
	 * @method main
	 * 		   Metodo principal para ejecucion de pruebas internas
	 * @param  args
	 * 		   Argumentos requeridos por el metodo principal
	 * @author hector.cuenca
	 * @date   4/03/2016
	 * *********************************************************************
	 */
	public static void main(String args[]){
		
		try {
			
			//TestPruebasInternas.getInstance().iniciarPruebaInterna(null,true, EnumDesplegarFormaConEventos.NO);
			
			JPanel panelContenido = new JPanel ();
			panelContenido.setLayout(null);
			JDialog dialogo = new JDialog();
			
			dialogo.setBounds(0, 0, 900, 500);
			
			FormaPanelClaveSeguridad forma;
			
			forma = new FormaPanelClaveSeguridad(null,
												 "FormaPanelClaveSeguridad");
			
			//forma.setBorder(BorderFactory.createEtchedBorder());
			
			panelContenido.add(forma);
			
			dialogo.add(panelContenido);
			
			dialogo.setVisible(true);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

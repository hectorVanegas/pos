package co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.ConfigOfrecerClaveSeguridadDTO;
import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad.TipoClaveSeguridadDTO;
import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad.TipoClaveSeguridadNoGraciasDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad.EventoFormaPanelTipoClaveSeguridadNoGracias;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelGenerico;
import co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.claveSeguridad.FormaOfrecerClaveSeguridad;
import co.com.codesa.clienteposslimgiros.interfaces.serviciosAdicionales.claveSeguridad.IFormasTiposClaveSeguridad;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

/**********************************************************************
 * @class  	FormaPanelTipoClaveSeguridadNoGracias
 *		   	Clase forma, que representa una seccion particular que 
 *		   	contiene los componentes graficos necesarios para realizar
 *		   	un proceso de servicio de clave de seguridad, aunque para
 *			este caso no se presenten controles graficos, dado que el
 *			tipo de clave de seguridad que se representa es la no 
 *			consideracion del servicio "No gracias"		   
 * @author 	hector.cuenca
 * @date   	4/3/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class FormaPanelTipoClaveSeguridadNoGracias extends FormaPanelGenerico implements IFormasTiposClaveSeguridad {

	/**
	 * @variable serialVersionUID
	 * 			 Variable serialVersionUID
	 */
	private static final long serialVersionUID = 8045507890900879934L;
	
	/**
	 * @variable evtFrmPnlClaveSeguridadNoGracias
	 * 			 Referencia a la clase que controla los eventos de esta forma
	 */
	private EventoFormaPanelTipoClaveSeguridadNoGracias evtFrmPnlClaveSeguridadNoGracias;
	
	/**
	 * @variable 	lblNota
	 * 			 	Etiqueta que se coloca como nota aclaratoria del tipo de
	 * 				clave de seguridad no gracias, donde socializa que este tipo
	 * 				de clave hace referencia a rechazar este servicio
	 */
	private EtiquetaUtil lblNota;
	
	/** 
	 * ********************************************************************
	 * @method FormaPanelTipoClaveSeguridadNoGracias
	 * 		   Constructor que ejecuta la inicializacion de valores y 
	 * 		   ejecucion de comportamientos inicales requeridos para
	 *         el despliegue de la forma
	 * @param  pFrmGnrVentana
	 * 		   Forma principal desde donde se controla todo el proceso para
	 * 		   asginar el tipo de clave de seguridad
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   4/3/2016
	 * *********************************************************************
	 */
	public FormaPanelTipoClaveSeguridadNoGracias(FormaOfrecerClaveSeguridad pFrmGnrVentana) throws Exception {
		
		super(pFrmGnrVentana,
			  EnumDimensionesComponentes.PNL_PNL_CSNG_TIPO_CLAVE_NO_GRACIAS, 
			  "pnlClaveSeguridadNoGracias", 
			  BorderFactory.createEmptyBorder(), 
			  null,
			  null);
		
		this.setEvtFrmPnlClaveSeguridadNoGracias(new EventoFormaPanelTipoClaveSeguridadNoGracias(this));
		
		super.iniciar();
	}
	
	@Override
	protected void inicializarSeccion()throws Exception{
		this.add(this.iniciarPropLblNota());
	}

	@Override
	public void configurar(FormaOfrecerClaveSeguridad pFrmGnrOfrecerClaveSeguridad,
						   ConfigOfrecerClaveSeguridadDTO pConfigOfrecerClaveSeguridadDTO,
			   			   TipoClaveSeguridadDTO pTipoClaveSeguridadDTO)throws Exception{
		
		this.getEvtFrmPnlClaveSeguridadNoGracias().configurar(pFrmGnrOfrecerClaveSeguridad,
															   pConfigOfrecerClaveSeguridadDTO,
												   	   		   pTipoClaveSeguridadDTO);
	}
	
	@Override
	public void ejecutar() throws Exception {
		
		this.getEvtFrmPnlClaveSeguridadNoGracias().ejecutar();
	}
	
	@Override
	public void limpiar() throws Exception {
		
		this.getEvtFrmPnlClaveSeguridadNoGracias().limpiar();
	}

	/**
	 * ****************************************************************.
	 * @method iniciarPropLblNota 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblClaveAleatoriaGeneradaAutomaticamente
	 * @return EtiquetaUtil 
	 * 		   Etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author roberth.martinez
	 * @date   4/3/2016
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblNota() throws Exception{
		
		if (this.lblNota == null) {
			
			this.lblNota = UtilComponentesGUI.getInstance().crearLabel	(	EnumDimensionesComponentes.LBL_PNL_CSNG_NOTA, 
										  									"lblNota", 
										  									EnumEtiquetas.LBL_PNL_CSNG_NOTA,
										  									false,
										  									null,
										  									true
										  								);
			this.lblNota.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblNota.setFont(this.lblNota.getFont().deriveFont(Font.ITALIC));
		}

		return this.lblNota;
	}
	
	/**
	 * @method getEvtFrmPnlClaveSeguridadNoGracias
	 * 		   Metodo get del atributo evtFrmPnlClaveSeguridadNoGracias
	 * @return EventoFormaPanelTipoClaveSeguridadAutomatica
	 *		   Valor del atributo evtFrmPnlClaveSeguridadNoGracias devuelto
	 * @author hector.cuenca
	 * @date   1/04/2016
	 */
	public EventoFormaPanelTipoClaveSeguridadNoGracias getEvtFrmPnlClaveSeguridadNoGracias() {
		return evtFrmPnlClaveSeguridadNoGracias;
	}

	/**
	 * @method setEvtFrmPnlClaveSeguridadNoGracias
	 * 		   Metodo set del atributo evtFrmPnlClaveSeguridadNoGracias
	 * @param  pEvtFrmPnlClaveSeguridadNoGracias
	 *		   Valor que tomara el atributo evtFrmPnlClaveSeguridadNoGracias
	 * @author hector.cuenca
	 * @date   1/04/2016
	 */
	public void setEvtFrmPnlClaveSeguridadNoGracias(
			EventoFormaPanelTipoClaveSeguridadNoGracias pEvtFrmPnlClaveSeguridadNoGracias) {
		
		this.evtFrmPnlClaveSeguridadNoGracias = pEvtFrmPnlClaveSeguridadNoGracias;
		this.setEvaControlEventos(this.evtFrmPnlClaveSeguridadNoGracias);
	}

	/**
	 * @method getLblNota
	 * 		   Metodo get del atributo lblNota
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblNota devuelto
	 * @author hector.cuenca
	 * @date   30/05/2017
	 */
	public EtiquetaUtil getLblNota() {
		return lblNota;
	}

	/**
	 * @method setLblNota
	 * 		   Metodo set del atributo lblNota
	 * @param  pLblNota
	 *		   Valor que tomara el atributo lblNota
	 * @author hector.cuenca
	 * @date   30/05/2017
	 */
	public void setLblNota(EtiquetaUtil pLblNota) {
		this.lblNota = pLblNota;
	}

	/** ********************************************************************
	 * @method main
	 * 		   metodo main para ejecucion
	 * @param  args
	 * 	       argumentos
	 * @author roberth.martinez
	 * @date   4/3/2016
	 * *********************************************************************
	 */
	public static void main(String args[]){
		
		try {
			
			TestPruebasInternas.getInstance().iniciarPruebaInterna(null,true, EnumDesplegarFormaConEventos.NO);
			@SuppressWarnings("unused")
			TipoClaveSeguridadNoGraciasDTO tipoTokenValidaNoGraciaslDTO = new TipoClaveSeguridadNoGraciasDTO(null, null);
			//FacturaGiro objFacturaGiro = new FacturaGiro();
			JPanel panelContenido = new JPanel ();
			panelContenido.setLayout(null);
			JDialog dialogo = new JDialog();
			
			dialogo.setBounds(0, 0, 900, 500);
			
			FormaPanelTipoClaveSeguridadNoGracias forma;
			
			forma = new FormaPanelTipoClaveSeguridadNoGracias(null);
			
			panelContenido.add(forma);
			
			dialogo.add(panelContenido);
			
			dialogo.setVisible(true);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

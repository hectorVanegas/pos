package co.com.codesa.clienteposslimgiros.eventos.impresion;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumImpresiones;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumTiposImpresora;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.impresion.FormaConfigurarTipoImpresora;
import co.com.codesa.clienteposslimgiros.formas.mensajes.FormaMensajeAlerta;
import co.com.codesa.clienteposslimgiros.vista.logica.impresion.ImpresionVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.impresion.TipoImpresion;

/**
 * ****************************************************************.
 * @autor: Roberth Martinez Vargas
 * @fecha: 28-abril-2015
 * @descripcion: Clase que representa los eventos de forma Configurar 
 * 				 tipo impresora
 * @copyright: Copyright  1998-2012 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class EventoFormaConfigurarTipoImpresora extends EventoAbstracto{
	
	public EventoFormaConfigurarTipoImpresora(FormaGenerica pForma) throws Exception {
		super(pForma);
	}
	
	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma) throws Exception{
		
		this.configuracionCamposTexto();
		this.llenarInformacionFormulario();
	}
	
	@Override
	public void confirmar()throws Exception{
		
		FormaMensajeAlerta frmAlerta;
		
		if (this.castfrmConfigurarTipoImpresora().getRbtTMU().isSelected()) {
			
			TipoImpresion.getInstancia().modificarArchivoConfiguracionImpresora(EnumTiposImpresora.TIRILLA.getStrAbreviatura());
			
		}else{
			
			TipoImpresion.getInstancia().modificarArchivoConfiguracionImpresora(EnumTiposImpresora.MEDIA_CARTA.getStrAbreviatura());
		}
		
		frmAlerta = EnumMensajes.DESEA_IMPRIMIR_PAGINA_PRUEBA.desplegarMensaje(super.getFrmForma(), 
																   			   EnumClasesMensaje.CONFIRMACION);
		
		if(frmAlerta.isOpcion()){//aceptar
			
			EnumImpresiones.PAGINA_PRUEBA.ejecutarImpresion(super.getFrmForma(), 
															false,
															null);
		}
		
		super.cerrarForma();
	}
	
	private void configuracionCamposTexto()throws Exception{
		
		this.castfrmConfigurarTipoImpresora().getTxtNombreImpresoraTMU().getPropiedades().setActivaDesplegarContenido(true);
		this.castfrmConfigurarTipoImpresora().getTxtNombreImpresoraMC().getPropiedades().setActivaDesplegarContenido(true);
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo  llenarInformacionFormulario
     * 			metodo utilizado para inicializar los datos de la 
     * 			forma configuracion tipo impresion
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */
	private void llenarInformacionFormulario()throws Exception{
		
		EnumTiposImpresora enmTipoImpresora;
		String strNombreImpresoraTMU;
		String strNombreImpresoraMC;
		
		enmTipoImpresora = ImpresionVistaLogica.getInstancia().obtenerTipoImpresora();
		
		if (EnumTiposImpresora.TIRILLA.equals(enmTipoImpresora)) {
			this.castfrmConfigurarTipoImpresora().getRbtTMU().setSelected(true);
		}else{
			this.castfrmConfigurarTipoImpresora().getRbtMC().setSelected(true);
		}
		
		try{
			
			strNombreImpresoraTMU = EnumTiposImpresora.TIRILLA.getEnmCnfNombreImpresora().obtenerValor();
			
			this.castfrmConfigurarTipoImpresora().getTxtNombreImpresoraTMU().setText(strNombreImpresoraTMU);
			
			strNombreImpresoraMC = EnumTiposImpresora.MEDIA_CARTA.getEnmCnfNombreImpresora().obtenerValor();
			
			this.castfrmConfigurarTipoImpresora().getTxtNombreImpresoraMC().setText(strNombreImpresoraMC);
		
		}catch(Exception e){
			
			super.controlExcepcion(e);
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo: castfrmConfigurarTipoImpresora (Metodo)
  	 * @descripcion: Metodo estandar para formatear el tipo de dato 
  	 * 				 general a un tipo especifico ("Casteo"), del atributo
  	 * 				 super.getFrmForma()
  	 * @return: FormaConfigurarTipoImpresora, valor especifico recuperado
  	 * @throws Exception: Controla, recupera y escala, cualquier tipo de 
  	 * 		   excepcion presentada
  	 * @autor: Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public FormaConfigurarTipoImpresora castfrmConfigurarTipoImpresora()throws Exception{
		return (FormaConfigurarTipoImpresora)super.getFrmForma();
	}
}

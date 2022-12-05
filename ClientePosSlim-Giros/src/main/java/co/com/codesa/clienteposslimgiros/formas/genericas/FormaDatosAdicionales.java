package co.com.codesa.clienteposslimgiros.formas.genericas;

import javax.swing.JPanel;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.generico.EventoFormaDatosAdicionales;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.FormaPanelConfirmarNormativa;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 15-abr-2015 
 * @Clase FormaDatosAdicionales
 * 		  Clase que genera la forma (GUI) para gestionar y/o 
 * 		  diligenciar datos adicionales
 * @copyright Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class FormaDatosAdicionales extends FormaGenerica{
	
	/**
	 * @variable 	serialVersionUID
	 * 			 	Variable serialVersionUID
	 */
	private static final long serialVersionUID = 5085029796166445662L;

	/**
  	 * ****************************************************************.
  	 * @metodo 	FormaDatosAdicionales
  	 * 		   	Constructor que ejecuta la inicializacion de valores y 
  	 * 		   	ejecucion de comportamientos inicales requeridos para el 
  	 * 		   	despliegue de la forma
  	 * @param 	pFrmPadre 
  	 * 		  	ventana de la cual extiende esta forma
  	 * @param 	pBooModal 
  	 * 		  	bandera que permite efectuar la forma de manera modal sobre 
  	 * 		  	la ventana de la cual extiende
  	 * @param 	pPnlDatosAdicionales
  	 * 			Especifica la seccion que se contemplara de manera adicional
  	 * @throws 	Exception 
  	 * 		   	Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
  	 * @autor 	Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaDatosAdicionales(FormaGenerica pFrmPadre,
						  		 boolean pBooModal,
						  		 JPanel pPnlDatosAdicionales) throws Exception{
		
		super(pFrmPadre,
			  pBooModal);
		
		super.setEventoForma(new EventoFormaDatosAdicionales(this));
		
		this.inicializarForma(pPnlDatosAdicionales);
	}

	/**
  	 * ****************************************************************.
  	 * @metodo inicializarForma
  	 * 		   Metodo propuesto por la forma generica, para inicializar 
  	 * 		   todos los aspectos de la forma
  	 * @param pArrObjParametrosForma 
  	 * 		  lista de posibles parametros a incluir sobre la inicializacion 
  	 * 		  de la forma
  	 * 		  [x]: descripcion del valor enviado en la posicion [x]
  	 * 		  [0]: panel de datos adicionales
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public void inicializarForma(Object ...pArrObjParametrosForma) throws Exception{
		
		JPanel pnlDatosAdicionales;
		
		pnlDatosAdicionales = (JPanel)pArrObjParametrosForma[0];
		
		super.setTituloForma(EnumEtiquetas.TTL_DAT_ADI_VENTANA);
		super.setAnchoForma(pnlDatosAdicionales.getSize().width);
		super.setAltoForma(pnlDatosAdicionales.getSize().height+EnumDimensionesComponentes.PNL_FRM_GNR_BARRA_HERRAMIENTAS.getAlto()+1);
		
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
						  		EnumBotonesEncabezado.BTNVOLVER);
		
		super.iniciar(pArrObjParametrosForma);
	}

	/**
  	 * ****************************************************************.
  	 * @metodo inicializarEncabezado
  	 * 		   Metodo dedicado a inicializar y gestionar el encabezado 
  	 * 		   de la forma (seccion superior)
  	 * @param pArrObjParametrosForma
  	 * 		  lista de posibles parametros a incluir sobre esta etapa
  	 * 		  [x]: descripcion del valor enviado en la posicion [x]
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public JPanel inicializarEncabezado(Object ...pArrObjParametrosForma) throws Exception {
		return null;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo inicializarCuerpo
  	 * 		   Metodo dedicado a inicializar y gestionar el cuerpo 
  	 * 		   de la forma (seccion central)
  	 * @param pArrObjParametrosForma
  	 * 		  lista de posibles parametros a incluir sobre esta etapa
  	 * 		  [x]: descripcion del valor enviado en la posicion [x]
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public JPanel inicializarCuerpo(Object ...pArrObjParametrosForma) throws Exception{
		
		JPanel pnlDatosAdicionales;
		
		pnlDatosAdicionales = (JPanel)pArrObjParametrosForma[0];
		
		return pnlDatosAdicionales;
	}

	/**
  	 * ****************************************************************.
  	 * @metodo inicializarPiePagina
  	 * 		   Metodo dedicado a inicializar y gestionar el pie de pagina 
  	 * 		   de la forma (seccion inferior)
  	 * @param pArrObjParametrosForma
  	 * 		  lista de posibles parametros a incluir sobre esta etapa
  	 * 		  [x]: descripcion del valor enviado en la posicion [x]
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public JPanel inicializarPiePagina(Object ...pArrObjParametrosForma) throws Exception{
		return null;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo castEvaFrmDatosAdicionales
  	 * 		   Metodo estandar para formatear el tipo de dato general a
  	 * 		   un tipo especifico ("Casteo"), del atributo padre: 
  	 * 		   eventoForma
  	 * @return EventoFormaDatosAdicionales 
  	 * 		   valor especifico recuperado
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EventoFormaDatosAdicionales castEvaFrmDatosAdicionales()throws Exception{
		return (EventoFormaDatosAdicionales)super.getEventoForma();
	}
	
	/** 
	 * ********************************************************************
	 * @method 	main
	 * 		   	Metodo principal (main), para realizar una prueba de unidad
	 * 			de la forma
	 * @param 	args
	 * 			Cadena de argumentos demandada por el metodo principal (main)
	 * @author 	hector.cuenca
	 * @date   	23/11/2016
	 * *********************************************************************
	 */
	public static void main(String[] args) {
		
		try {
		
			/*FormaPanelConfirmarNormativa frmNormativa = new FormaPanelConfirmarNormativa(null,
					"3177965738",
					"3665658",
					EnumDimensionesComponentes.PNL_PNL_SMS_SECCION, EnumEtiquetas.TTL_NORMATIVA);
			
			new FormaDatosAdicionales(null, 
									  true, 
									  frmNormativa);*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

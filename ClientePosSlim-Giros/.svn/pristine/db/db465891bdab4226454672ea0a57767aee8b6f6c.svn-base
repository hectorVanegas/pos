package co.com.codesa.clienteposslimgiros.formas.sesion;


import javax.swing.JFrame;
import javax.swing.JPanel;

import co.com.codesa.clienteposslimgiros.eventos.sesion.EventoFormaCierreSesion;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 20-abr-2015
 * @Clase FormaCierreSesion 
 * 		  Clase que genera la forma (GUI) para el proceso de salir o
 * 		  cierre de sesion
 * @copyright Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class FormaCierreSesion extends FormaGenerica{

	private static final long serialVersionUID = 1L;
	
	/**
  	 * ****************************************************************.
  	 * @metodo FormaCierreSesion
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de la forma
  	 * @param pFrmPadre
  	 * 		  ventana de la cual extiende esta forma
  	 * @param pBooModal 
  	 * 		  bandera que permite efectuar la forma de manera modal sobre 
  	 * 		  la ventana de la cual extiende
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaCierreSesion(JFrame pFrmPadre,
					  		 boolean pBooModal) throws Exception{
		
		super(pFrmPadre,
			  pBooModal,
			  false);
		
		super.setEventoForma(new EventoFormaCierreSesion(this));
		this.inicializarForma();
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
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public void inicializarForma(Object ...pArrObjParametrosForma) throws Exception{
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
		return null;
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

	public static void main(String[] args) {
		
		JFrame jframe = null;
		
		try{
	        
			jframe = TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaCierreSesion.class,
																			true, 
																			EnumDesplegarFormaConEventos.SI);
			new FormaCierreSesion(jframe,true);
			
		} catch (Exception e) {
			
			UtilidadesGiros.getInstance().controlExcepcion(e, 
														   null);
		}
	}
}

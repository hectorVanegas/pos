package co.com.codesa.clienteposslimgiros.formas.componentesGUI;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.ComponenteGUI;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.ComponentesObligatorios;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 10-abr-2015 
 * @clase CajaIncrementoUtil
 * 		  Clase encargada de emular el comportamiento de un JSpinner
 * 		  adicionando una serie de aspectos y/o utilidades de interes
 * @copyright Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class CajaIncrementoUtil extends JSpinner implements ComponenteGUI, ComponentesObligatorios {
	
	private static final long serialVersionUID = -1284688714974852986L;
	
	private int valorInicial;
	private int valorMinimo;
	private int valorMaximo;
	private int valorIncremento;
	
	private SpinnerNumberModel modelo;
	
	private ObligatoriedadUtil lblObligatorio;
	
	/**
  	 * ****************************************************************.
  	 * @metodo CajaIncrementoUtil
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de sus acciones
  	 * @param pIntValorInicial
  	 * 		  cantidad que tomara en principio el componente 
  	 * @param pIntValorMinimo
  	 * 		  cantidad minima al que puede llegar el componente
  	 * @param pIntValorMaximo
  	 * 		  cantidad maxima a la que puede llegar el componente
  	 * @param pIntValorIncremento
  	 * 		  nivel de incremento o saltos
  	 * @param pEnmEtiNombreCampo
  	 * 		  Etiqueta que identifica el nombre del componente dentro de 
  	 * 		  la funcionalidad en cuestion
  	 * @param pArrStrParametros
  	 * 		  Listado de parametros que alimentan la etiqueta que 	
  	 * 		  identifica el nombre del componente
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaIncrementoUtil(int pIntValorInicial,
							  int pIntValorMinimo,
							  int pIntValorMaximo,
							  int pIntValorIncremento,
							  EnumEtiquetas pEnmEtiNombreCampo,
				   	 		  String ...pArrStrParametros) throws Exception{
		super();
		
		this.valorInicial = pIntValorInicial;
		this.valorMinimo = pIntValorMinimo;
		this.valorMaximo = pIntValorMaximo;
		this.valorIncremento = pIntValorIncremento;
		
		this.inicializarAtributos(pEnmEtiNombreCampo,
								  pArrStrParametros);
	}
	
	private void inicializarAtributos(EnumEtiquetas pEnmEtiNombreCampo,
 	 		  						  String ...pArrStrParametros)throws Exception{
		
		this.modelo = new SpinnerNumberModel(this.valorInicial,
				 							 this.valorMinimo,
				 							 this.valorMaximo,
				 							 this.valorIncremento);
		
		super.setModel(this.modelo);
		this.lblObligatorio = new ObligatoriedadUtil(pEnmEtiNombreCampo,
													 pArrStrParametros);
	}

	public int getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(int valorInicial) {
		this.valorInicial = valorInicial;
	}

	public int getValorMinimo() {
		return valorMinimo;
	}

	public void setValorMinimo(int valorMinimo) {
		this.valorMinimo = valorMinimo;
	}

	public int getValorMaximo() {
		return valorMaximo;
	}

	public void setValorMaximo(int valorMaximo) {
		this.valorMaximo = valorMaximo;
	}

	public int getValorIncremento() {
		return valorIncremento;
	}

	public void setValorIncremento(int valorIncremento) {
		this.valorIncremento = valorIncremento;
	}

	public SpinnerNumberModel getModelo() {
		return modelo;
	}

	public void setModelo(SpinnerNumberModel modelo) {
		this.modelo = modelo;
	}
	
	@Override
	public ObligatoriedadUtil getLblObligatorio() {
		return lblObligatorio;
	}

	@Override
	public void setLblObligatorio(ObligatoriedadUtil lblObligatorio) {
		this.lblObligatorio = lblObligatorio;
	}
	
	@Override
	public void setVisible(boolean pBooVisible) {
		
		super.setVisible(pBooVisible);
		
		UtilComponentesGUI.getInstance().activaObligatoriedad(this, 
														  this.lblObligatorio);
	}
	
	@Override
	public void setEnabled(boolean pBooEnabled) {
		
		super.setEnabled(pBooEnabled);
		
		UtilComponentesGUI.getInstance().activaObligatoriedad(this, 
				  										  this.lblObligatorio);
	}
	
	@Override
	public void setValorContenido(Object pObjeto)throws Exception{
	
		this.setValue(pObjeto);
	}
	
	@Deprecated
	@Override
	public void setToolTipText(String text) {
		super.setToolTipText(text);
	}
	
	@Override
	public void setToolTipText(EnumEtiquetas pEnmEtiquetas,
							   String ...pArrStrParametros){
		
		UtilidadesGiros.getInstance().setToolTipText(this, 
				 									 pEnmEtiquetas, 
				 									 pArrStrParametros);
	}
}

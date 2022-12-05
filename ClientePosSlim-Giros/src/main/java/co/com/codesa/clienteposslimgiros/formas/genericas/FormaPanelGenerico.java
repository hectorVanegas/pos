package co.com.codesa.clienteposslimgiros.formas.genericas;

import javax.swing.border.Border;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionUtil;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;

/** 
 * ********************************************************************
 * @class  FormaPanelGenerico
 *		   Clase que permite generalizar los comportamientos y atributos
 *		   de una forma concebida como una seccion, similar al proposito
 *		   de la FormaGenerica para las funcionalidades basicas del 
 *		   sistema
 * @author hector.cuenca
 * @date   8/03/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public abstract class FormaPanelGenerico extends SeccionUtil{

	/**
	 * @variable serialVersionUID
	 * 			 Variable serialVersionUID
	 */
	private static final long serialVersionUID = 47625970132087093L;
	
	/**
	* @variable evaControlEventos
	* 			Referencia generalizada de la clase que controlara los eventos
	* 			de la forma seccion que se esta construyendo
	**/
	private EventoAbstracto evaControlEventos;
	
	/**
	 * @variable frmGnrPadre
	 * 			 Referencia a la forma generica que contiene la seccion 
	 */
	private FormaGenerica frmGnrPadre;
	
	/**
	 * @variable enmDimensionSeccion
	 * 			 Especificaciones de dimension que tendra la seccion 
	 */
	private EnumDimensionesComponentes enmDimensionSeccion;
	
	/**
	 * 
	 * ********************************************************************
	 * @method FormaPanelGenerico
	 * 		   Constructor de la seccion generica, que se encarga de 
	 * 		   inicializar los atributos y comportamientos en el proceso de
	 * 		   construccion
	 * @param  pFrmGnrPadre
	 * 		   Referencia a la forma generica que contiene la seccion 
	 * @param  pEnmDimension
	 * 		   Especificaciones de dimension que tendra la seccion 
	 * @param  pStrNombreComponente
	 * 		   Nombre tecnico con el cual se identificara la seccion
	 * @param  pBorde
	 * 		   Especificacion del tipo de borde que tendra la seccion
	 * @param  pIntJustificacionTitulo
	 * 		   Tipo de Justificacion para el titulo, aplica solo en caso de
	 * 		   recibir un titulo para la seccion
	 * @param  pEnmTitulo
	 * 		   Titulo de la seccion
	 * @param  pArrStrParametrosTitulo
	 * 		   Posibles parametros requeridos por el titulo de la seccion
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   8/03/2016
	 * *********************************************************************
	 */
	public FormaPanelGenerico(FormaGenerica pFrmGnrPadre,
							  EnumDimensionesComponentes pEnmDimension,
	  		   				  String pStrNombreComponente,
	  		   				  Border pBorde,
	  		   				  Integer pIntJustificacionTitulo,
	  		   				  EnumEtiquetas pEnmTitulo,
	  		   				  String ...pArrStrParametrosTitulo) throws Exception{
	
		super	(	pEnmDimension,
					pStrNombreComponente,
					pBorde,
					pIntJustificacionTitulo,
					pEnmTitulo,
					pArrStrParametrosTitulo
				);
		
		this.inicializarAtributos(pFrmGnrPadre,
								  pEnmDimension,
								  pStrNombreComponente,
								  pBorde,
								  pIntJustificacionTitulo,
								  pEnmTitulo,
								  pArrStrParametrosTitulo);
	}
	
	/** 
	 * ********************************************************************
	 * @method inicializarAtributos
	 * 		   Metodo encargado de recibir y centralizar todos los posibles 
	 * 		   atributos para la construccion de una forma seccion, y 
	 * 		   proceder con la ejecucion de sentencias propias de 
	 * 		   inicializacion  
	 * @param  pFrmGnrPadre
	 * 		   Referencia a la forma generica que contiene la seccion 
	 * @param  pEnmDimension
	 * 		   Especificaciones de dimension que tendra la seccion 
	 * @param  pStrNombreComponente
	 * 		   Nombre tecnico con el cual se identificara la seccion
	 * @param  pBorde
	 * 		   Especificacion del tipo de borde que tendra la seccion
	 * @param  pIntJustificacionTitulo
	 * 		   Tipo de Justificacion para el titulo, aplica solo en caso de
	 * 		   recibir un titulo para la seccion
	 * @param  pEnmTitulo
	 * 		   Titulo de la seccion
	 * @param  pArrStrParametrosTitulo
	 * 		   Posibles parametros requeridos por el titulo de la seccion
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   8/03/2016
	 * *********************************************************************
	 */
	private void inicializarAtributos(FormaGenerica pFrmGnrPadre,
			  						  EnumDimensionesComponentes pEnmDimension,
			  						  String pStrNombreComponente,
			  						  Border pBorde,
			  						  Integer pIntJustificacionTitulo,
			  						  EnumEtiquetas pEnmTitulo,
			  						  String ...pArrStrParametrosTitulo)throws Exception{
		
		this.setFrmGnrPadre(pFrmGnrPadre);
		this.setEnmDimensionSeccion(pEnmDimension);
	}
	
	/**
	 * ********************************************************************
	 * @method inicializarSeccion
	 * 		   Metodo que permite ejecutar las sentencias particulares 
	 * 		   de inicializacion de la seccion
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
	 * 		   presentada
	 * @author hector.cuenca
	 * @date   8/03/2016
	 * *********************************************************************
	 */
	protected abstract void inicializarSeccion() throws Exception;
	
	/**
	 * ********************************************************************
	 * @method iniciar
	 * 		   Metodo propuesto por la seccion generica, para centralizar 
	 * 		   las acciones que permiten dar inicio a todo su despliegue
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   8/03/2016
	 * *********************************************************************
	 */
	public void iniciar() throws Exception{
		
		this.inicializarSeccion();
		this.iniciarValores();
	}
	
	/** 
	 * ********************************************************************
	 * @method iniciarValores
	 * 		   Metodo que valida, inicializa y solicita los aspectos logicos
	 * 		   del lado de la capa de eventos  
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   8/03/2016
	 * *********************************************************************
	 */
	private void iniciarValores()throws Exception{
	
		boolean booDesplegarControlEventos;
		
		if(this.getEvaControlEventos()!=null){
			
			booDesplegarControlEventos = true;
			
			if(this.getFrmGnrPadre()!=null 
					&& this.getFrmGnrPadre().getClass().equals(TestPruebasInternas.CLASS_FORMA_GENERICA)){
				
				if(EnumDesplegarFormaConEventos.NO.equals(TestPruebasInternas.DESPLEGAR_FORMA_CON_EVENTOS)){
			
					booDesplegarControlEventos = false;
				}
			}
			
			if(booDesplegarControlEventos){
				
				this.getEvaControlEventos().iniciarValores();
				this.getEvaControlEventos().setBooFinalizoExitosoValores(true);
			}
		}
	}
	
	/**
	 * @method getEvaControlEventos
	 * 		   Metodo get del atributo evaControlEventos
	 * @return EventoAbstracto
	 *		   Valor del atributo evaControlEventos devuelto
	 * @author hector.cuenca
	 * @date   8/03/2016
	 */
	public EventoAbstracto getEvaControlEventos() {
		return evaControlEventos;
	}

	/**
	 * @method setEvaControlEventos
	 * 		   Metodo set del atributo evaControlEventos
	 * @param  pEvaControlEventos
	 *		   Valor que tomara el atributo evaControlEventos
	 * @author hector.cuenca
	 * @date   8/03/2016
	 */
	public void setEvaControlEventos(EventoAbstracto pEvaControlEventos) {
		this.evaControlEventos = pEvaControlEventos;
	}

	/**
	 * @method getFrmGnrPadre
	 * 		   Metodo get del atributo frmGnrPadre
	 * @return FormaGenerica
	 *		   Valor del atributo frmGnrPadre devuelto
	 * @author hector.cuenca
	 * @date   8/03/2016
	 */
	public FormaGenerica getFrmGnrPadre() {
		return frmGnrPadre;
	}

	/**
	 * @method setFrmGnrPadre
	 * 		   Metodo set del atributo frmGnrPadre
	 * @param  pFrmGnrPadre
	 *		   Valor que tomara el atributo frmGnrPadre
	 * @author hector.cuenca
	 * @date   8/03/2016
	 */
	public void setFrmGnrPadre(FormaGenerica pFrmGnrPadre) {
		this.frmGnrPadre = pFrmGnrPadre;
	}


	/**
	 * @method getEnmDimensionSeccion
	 * 		   Metodo get del atributo enmDimensionSeccion
	 * @return EnumDimensionesComponentes
	 *		   Valor del atributo enmDimensionSeccion devuelto
	 * @author hector.cuenca
	 * @date   8/03/2016
	 */
	public EnumDimensionesComponentes getEnmDimensionSeccion() {
		return enmDimensionSeccion;
	}


	/**
	 * @method setEnmDimensionSeccion
	 * 		   Metodo set del atributo enmDimensionSeccion
	 * @param  pEnmDimensionSeccion
	 *		   Valor que tomara el atributo enmDimensionSeccion
	 * @author hector.cuenca
	 * @date   8/03/2016
	 */
	public void setEnmDimensionSeccion(EnumDimensionesComponentes pEnmDimensionSeccion) {
		this.enmDimensionSeccion = pEnmDimensionSeccion;
	}

}

package co.com.codesa.clienteposslimgiros.eventos.caja;

import java.awt.event.WindowEvent;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.caja.FormaArqueoCaja;
import co.com.codesa.clienteposslimgiros.formas.caja.FormaCierreCaja;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.vista.logica.caja.CajaVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.caja.arqueo.InfoCierreCajaDTO;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 13-abr-2015 
 * @clase EventoFormaCierreCaja
 * 		  Clase encargada de controlar los eventos de la forma de  
 * 		  cierre de caja
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class EventoFormaCierreCaja extends EventoAbstracto{
	
	/**
	 * @variable objInfoCierreCajaDTO
	 * 			 objeto que contiene informacion adicional y requerida para el
	 * 			 proceso de cierre de caja
	 **/
	private InfoCierreCajaDTO objInfoCierreCajaDTO;
	
	/**
  	 * ****************************************************************.
  	 * @metodo EventoFormaAperturarCaja
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de sus acciones
  	 * @param pForma 
  	 * 		  referencia a la GUI de la cual se estan controlando los 
  	 * 		  eventos
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EventoFormaCierreCaja(FormaGenerica pForma) throws Exception{
		super(pForma);
	}
	
	@Override
	public	void	accionarVentanaDesplegada	(	WindowEvent pEvtWindowOpened	) 
			throws Exception 
	{
		this.getFrmForma().getPnlBarraHerramientas().getComponents()[0].requestFocus();
	}
	
	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma)throws Exception{
		this.cargarFormulario();
	}
	
	@Override
	public void confirmar() throws Exception{
		
		if(this.isBooFinalizoExitosoValores()){
			
			new FormaArqueoCaja(super.getFrmForma(),
								true,
								this.objInfoCierreCajaDTO);
			
		}else{
			
			throw EnumMensajes.CARGUE_INCOMPLETO_NO_PERMITE_CONTINUAR_OPERACION.generarExcepcion(EnumClasesMensaje.ERROR);
		}
	}

	/**
  	 * ****************************************************************.
  	 * @metodo cargarFormulario
  	 * 		   Metodo que se encarga de gestionar el cargue de la 
  	 * 		   informacion sobre el formulario
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void cargarFormulario()throws Exception{
		this.cargarGrillaMediosPago();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo cargarGrillaMediosPago
  	 * 		   Metodo encargado de solicitar a la vista logica de caja, 
  	 * 		   la consulta de saldos, para desplegar la informacion sobre 
  	 * 		   la pantalla de apertura de caja al ser esta desplegada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void cargarGrillaMediosPago()throws Exception{
		
		String strTipoOperacion;
		String strFechaApertura;
		boolean booUltimoCierreCaja;
		
		strTipoOperacion = "1";
		strFechaApertura = null;
		booUltimoCierreCaja = true;
		
		this.objInfoCierreCajaDTO = CajaVistaLogica.getInstance().consultarCuadreCaja(super.getObjUsuario(),
																					  strTipoOperacion, 
																					  booUltimoCierreCaja, 
																					  strFechaApertura);
		
		this.castFrmCierreCaja().getTblMediosPago().getPropiedades().adicionarFilasGrilla(this.objInfoCierreCajaDTO.getMtrObjMediosPago());
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo castFrmCierreCaja
  	 * 		   Metodo estandar para formatear el tipo de dato general a 
  	 * 		   un tipo especifico ("Casteo"), del atributo frmCierreCaja
  	 * @return FormaCierreCaja
  	 * 		   valor especifico recuperado
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaCierreCaja castFrmCierreCaja()throws Exception{
		return (FormaCierreCaja)super.getFrmForma();
	}
	
}

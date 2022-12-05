package co.com.codesa.clienteposslimgiros.evento.lector2D;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.event.KeyEvent;

import org.apache.tools.ant.taskdefs.Sleep;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.envioRemesaInternacional.FormaEnvioRemesaInternacional;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.lector2D.FormaLector2D;
import co.com.codesa.clienteposslimgiros.vista.logica.lector2D.Lector2DVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;

public class EventoFormaLector2D extends EventoAbstracto {
	
	/**
	 * @variable objTercero
	 * 			 objeto de tipo tercero a quien se le debe realizar las operaciones
	 */
	private Tercero objTercero;
	/**
	 * @variable strCadenaLector
	 * 			 cadena tomada del lector 2D
	 */
	private String strCadenaLector;
	/**
  	 * ****************************************************************.
  	 * @metodo EventoFormaLector2D
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de sus acciones
  	 * @param pForma 
  	 * 		  referencia a la GUI de la cual se estan controlando los 
  	 * 		  eventos
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Jefferson Ruiz
  	 * @date  06/09/2019
  	 * ****************************************************************
  	 */
	
	
	public EventoFormaLector2D(FormaGenerica pForma, 
							   Tercero pobjTercero) throws Exception {
		
		super(pForma);
		this.objTercero = pobjTercero;
		
	}
	
	@Override
	public void keyPressed(KeyEvent e){
		
		if(e.getKeyCode() == e.VK_END) {
			
			try {
				if(e.getSource() ==  this.castFrmLector2D().getTxaLector2D()){
					
					this.strCadenaLector = ""; 
					
					this.castFrmLector2D().getTxaMensajeALerta().setText("");
					
					this.strCadenaLector = this.castFrmLector2D().getTxaLector2D().getText();
					
					this.castFrmLector2D().getTxaLector2D().setText("");
					
					this.castFrmLector2D().getTxaLector2D().requestFocus();
					
					if (strCadenaLector.trim().equals("") || strCadenaLector.trim().length() < 11) {
						
						throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
																		"ERR_LECTOR",
																		"Cadena no valida para lector de cedula, intente de nuevo.");
						
					}else{
						
						Lector2DVistaLogica.getInstance().verificarInformacionLector2D(this.objTercero,
								   													   this.strCadenaLector.trim());
						
						this.strCadenaLector = "";

						if (Lector2DVistaLogica.getInstance().getBooProcesoLectorOk()) {
							
							this.castFrmLector2D().dispose();
						
						}
															
					}
				}
			} catch (Exception e1) {
				
				super.controlExcepcion(e1);
				
			}
		}
	}
	
	
	
	
	@Override
	public void accionarEjecucion(Component pComponent,
								  AWTEvent pEvtEjecucion)throws Exception{
		
		if( pComponent.equals(this.castFrmLector2D().getTxaLector2D()) ){
			
			this.castFrmLector2D().getTxaMensajeALerta().setText("Presione la tecla Fin/End para continuar con la validacion");
			
		}
		
	/*	if( pComponent.equals(this.castFrmLector2D().getTxaLector2D()) ){
			
			this.strCadenaLector = "";
			
			this.strCadenaLector = this.castFrmLector2D().getTxaLector2D().getText();
			
			this.castFrmLector2D().getTxaLector2D().setText("");
			
			this.castFrmLector2D().getTxaLector2D().requestFocus();
			
			if (strCadenaLector.trim().equals("") || strCadenaLector.trim().length() < 11) {
				
				throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
																"ERR_LECTOR",
																"Cadena no valida para lector de cedula, intente de nuevo.");
				
			}else{
				
				Lector2DVistaLogica.getInstance().verificarInformacionLector2D(this.objTercero,
						   													   this.strCadenaLector.trim());
				
				this.strCadenaLector = "";

				if (Lector2DVistaLogica.getInstance().getBooProcesoLectorOk()) {
					
					System.err.println("--------------->");
					
					Thread.sleep(1000);
				
					this.castFrmLector2D().dispose();
				
				}
													
			}
			
			
			
		}else{
			super.accionarEjecucion(pComponent, pEvtEjecucion);
		}*/
		
	}
	
	
	
	
	public FormaLector2D castFrmLector2D() throws Exception{
		return (FormaLector2D) super.getFrmForma();
	}

	
	
	
	
}

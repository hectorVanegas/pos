package co.com.codesa.clienteposslimgiros.eventos.componentesGUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JComponent;

import co.com.codesa.clienteposslim.enumeraciones.EstadoAplicacionEnum;
import co.com.codesa.clienteposslim.formas.FormaLogin;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionUtil;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.PropiedadesSeccion;

public class EventoCompSeccionUtil extends EventoAbstracto implements PropiedadesSeccion {
	
	private SeccionUtil cmpSeccion;
	
	public EventoCompSeccionUtil(SeccionUtil pComponente) throws Exception{
		
		this.setCmpSeccion(pComponente);
		
		this.inicializarPropiedades();
	}
	
	private void inicializarPropiedades()throws Exception{
		
		this.adicionarAspectosXModo(FormaLogin.estadoAplicacion);
	}
	
	public void adicionarAspectosXModo(EstadoAplicacionEnum pEnmModoAplicacion) throws Exception{
		
		if(pEnmModoAplicacion == EstadoAplicacionEnum.DESARROLLO){
			
			this.cmpSeccion.addMouseMotionListener(new MouseMotionAdapter(){
				
				@Override
				public void mouseMoved(MouseEvent evt) {
					
					JComponent cmpComponente;
					
					if(evt.getComponent() instanceof JComponent){
						
						cmpComponente = (JComponent)evt.getComponent();
						
						cmpComponente.setToolTipText(cmpComponente.getName()+": ["+evt.getPoint().x+" , "+evt.getPoint().y+"]");
					}
	            }
			});
		}
	}
	
	public SeccionUtil getCmpSeccion() {
		return cmpSeccion;
	}

	public void setCmpSeccion(SeccionUtil cmpSeccion) {
		this.cmpSeccion = cmpSeccion;
	}

	
}

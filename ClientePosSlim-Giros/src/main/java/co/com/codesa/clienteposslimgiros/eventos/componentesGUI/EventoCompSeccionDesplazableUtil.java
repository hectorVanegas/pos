package co.com.codesa.clienteposslimgiros.eventos.componentesGUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JComponent;
import co.com.codesa.clienteposslim.enumeraciones.EstadoAplicacionEnum;
import co.com.codesa.clienteposslim.formas.FormaLogin;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionDesplazableUtil;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.PropiedadesSeccionDesplazable;

public class EventoCompSeccionDesplazableUtil extends EventoAbstracto implements PropiedadesSeccionDesplazable {
	
	private SeccionDesplazableUtil cmpSeccionDesplazable;
	
	public EventoCompSeccionDesplazableUtil(SeccionDesplazableUtil pComponente) throws Exception{
		
		this.setCmpSeccionDesplazable(pComponente);
		
		this.inicializarPropiedades();
	}
	
	private void inicializarPropiedades()throws Exception{
		
		this.adicionarAspectosXModo(FormaLogin.estadoAplicacion);
	}
	
	public void adicionarAspectosXModo(EstadoAplicacionEnum pEnmModoAplicacion) throws Exception{
		
		if(pEnmModoAplicacion == EstadoAplicacionEnum.DESARROLLO){
			
			this.cmpSeccionDesplazable.addMouseMotionListener(new MouseMotionAdapter(){
				
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
	
	public SeccionDesplazableUtil getCmpSeccionDesplazable() {
		return cmpSeccionDesplazable;
	}

	public void setCmpSeccionDesplazable(SeccionDesplazableUtil cmpSeccion) {
		this.cmpSeccionDesplazable = cmpSeccion;
	}

	
}

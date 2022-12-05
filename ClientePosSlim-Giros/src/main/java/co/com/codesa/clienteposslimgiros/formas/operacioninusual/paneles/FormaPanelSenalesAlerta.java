package co.com.codesa.clienteposslimgiros.formas.operacioninusual.paneles;

import javax.swing.BorderFactory;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.operacioninusual.EventoFormaPanelDocumento;
import co.com.codesa.clienteposslimgiros.eventos.operacioninusual.EventoFormaSenalAlertaInternacional;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.GrillaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionDesplazableUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelGenerico;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

public class FormaPanelSenalesAlerta extends FormaPanelGenerico {
	
	
	
	
	private GrillaUtil grillaSenalesAlerta;
	
	private SeccionDesplazableUtil scrollGrillaSenalesAlerta;
	
	private EventoFormaSenalAlertaInternacional evtFrmSenalAlerta;

	public FormaPanelSenalesAlerta(FormaGenerica pFrmPadre,
			EnumDimensionesComponentes pEnmDimension,
			String pStrNombreComponente) throws Exception {

		super(pFrmPadre,
				pEnmDimension,
				pStrNombreComponente,
				BorderFactory.createEmptyBorder(),
				null,
				null);

		/*this.evtFrmSenalAlerta = new EventoFormaSenalAlertaInternacional(this, 
				pFrmPadre);
		//this.setEvaControlEventos(this.evtFrmSenalAlerta);*/

		super.iniciar();

	}

	@Override
	protected void inicializarSeccion() throws Exception {
		// TODO Auto-generated method stub
		this.add(iniciarPropScrollGrillaSenalesAlerta());
	}
	
	
public SeccionDesplazableUtil iniciarPropScrollGrillaSenalesAlerta() throws Exception{
		
		if(this.scrollGrillaSenalesAlerta == null){
			
			this.scrollGrillaSenalesAlerta = UtilComponentesGUI.getInstance().crearScroll("scrollGrillaSenalesAlerta", 
																					   EnumDimensionesComponentes.GRI_OII_GRID_SENALES_ALERTA, 
																					   null);
			
			this.scrollGrillaSenalesAlerta.setViewportView(this.iniciarPropGrillaSenalesAlerta());
		}
		
		return this.scrollGrillaSenalesAlerta;
	}
	
	public GrillaUtil iniciarPropGrillaSenalesAlerta() throws Exception{
		
		if(this.grillaSenalesAlerta == null){
			
			this.grillaSenalesAlerta = UtilComponentesGUI.getInstance().crearGrilla("tblGrillaSenalesAlerta", 
																				 new EnumEtiquetas []{EnumEtiquetas.TTL_OII_GRILLA_SENAL_ALERTA_CODIGO,
																								      EnumEtiquetas.TTL_OII_GRILLA_SENAL_ALERTA_SENAL,
																								      EnumEtiquetas.TTL_OII_GRILLA_SENAL_ALERTA_COMENTARIO
																									 }, 
																				 null,//invisibles
																				 new boolean[] {false,
																								false,
																								false},//editable por columna 
																				 new int[]{40,
																						   80,
																						   80,
																						   80,
																						   80,
																						   100,
																						   100},//Dimensiones 
																				 null);//evento
		}
		
		return this.grillaSenalesAlerta;
	}
	
	
	
}

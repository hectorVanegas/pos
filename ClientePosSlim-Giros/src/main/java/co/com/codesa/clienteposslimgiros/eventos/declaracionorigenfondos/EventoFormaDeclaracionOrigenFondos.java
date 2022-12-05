package co.com.codesa.clienteposslimgiros.eventos.declaracionorigenfondos;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.declaraionorigenesfondo.FormaDeclaracionOrigenesFondos;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.vista.logica.DeclaracionOrigenFondosVistaLogica;

public class EventoFormaDeclaracionOrigenFondos extends EventoAbstracto {

	
	private int longitudRespuestaDOF;
	
	
	public EventoFormaDeclaracionOrigenFondos(FormaGenerica pFrmPadre) {
		super(pFrmPadre);
	}
	
	@Override
	public void iniciarValores(Object... pArrObjParametrosForma) throws Exception {
		this.configurarParametrosDOF();
	}
	
	private void configurarParametrosDOF() throws Exception {
		this.castfrmDeclaracionOrigenFondo().getLblPregunta().setText(
				DeclaracionOrigenFondosVistaLogica.getInstance().consultarPreguntaDOF());
		
		this.castfrmDeclaracionOrigenFondo().getTxtRespuesta().getPropiedades()
		.setControlFormatoIngreso(DeclaracionOrigenFondosVistaLogica.getInstance().consultarExpresionDOF());
		
		
		this.castfrmDeclaracionOrigenFondo().getTxtRespuesta().getPropiedades().validaFormatoFinal(true, "^[\\s\\S]{0,25}$");
		
		
		this.castfrmDeclaracionOrigenFondo().getTxtRespuesta().setColumns(30);
		
		
		longitudRespuestaDOF = DeclaracionOrigenFondosVistaLogica.getInstance().consultarLongitudDOF();
		
	}
	
	@Override
	public void confirmar() throws Exception {
		if(longitudRespuestaDOF >= this.castfrmDeclaracionOrigenFondo().getTxtRespuesta().getText().length())
			castfrmDeclaracionOrigenFondo().dispose();
		else
			EnumMensajes.MENSAJE_PERSONALIZADO
			.desplegarMensajePersonalizado(getFrmForma(), EnumClasesMensaje.INFORMACION, "0", "Ha superado la cantidad de caracteres ({1}) permitidos para la respuesta", longitudRespuestaDOF+"");
	}
	
	public FormaDeclaracionOrigenesFondos castfrmDeclaracionOrigenFondo() throws Exception {
		return (FormaDeclaracionOrigenesFondos)super.getFrmForma();
	}
}

package control.acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ParaUI;

public class ActionDeserializar implements ActionListener{
private ParaUI paraUI;
	

	public ActionDeserializar(ParaUI paraUI) {
		this.paraUI = paraUI;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		paraUI.deserializarPersona();
		paraUI.visualizarDireccion();
		paraUI.getTextoDireccion().setText("por fin");
		
	}
}

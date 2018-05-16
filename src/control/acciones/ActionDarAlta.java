package control.acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ParaUI;

public class ActionDarAlta implements ActionListener{
	private ParaUI paraUI;
	

	public ActionDarAlta(ParaUI paraUI) {
		this.paraUI = paraUI;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		paraUI.agregarCliente();
		paraUI.añadirPersonaAlCombo();
		paraUI.inicializarCampos();
	}

}

package control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import control.acciones.ActionDarAlta;
import control.acciones.ActionDeserializar;
import modelo.MyObjectOutputStream;
import modelo.Persona;
import vista.UI;

public class ParaUI extends UI {
	
	private String path = "archivoDeGuardado.data";
	private File file = new File(path);
	private FileInputStream flujoR = null;
	private ObjectInputStream adaptadorR = null;
	private FileOutputStream flujoW = null;
	private ObjectOutputStream adaptadorW = null;

	public ParaUI() {
		botonAlta.addActionListener(new ActionDarAlta(this));
		comboBox.addItemListener(new ActionDeserializar(this));
	}

	public void agregarCliente() {
		if (comprobarCampos()) {
			serializar(new Persona(getNombre().getText(), getDireccion().getText()));
		}
	}

	public boolean serializar(Object obj) {
		boolean retorno = false;
		boolean existe = file.exists();
		try {
			flujoW = new FileOutputStream(file, true);
			if (!existe) {
				adaptadorW = new ObjectOutputStream(flujoW);
			}
			else{
				adaptadorW = new MyObjectOutputStream(flujoW);
			}
			adaptadorW.writeObject(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			adaptadorW.close();
			flujoW.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return retorno;
	}

	public Object deserializar(int posicion) {

		Object obj = null;
		try {
			flujoR = new FileInputStream(this.file);
			adaptadorR = new ObjectInputStream(flujoR);
			//como es secuencial y no se el tamano de cada objeto no me queda mas remedio que leer los anteriores
			for (int i = 0; i < posicion; i++) {
				obj = adaptadorR.readObject();
				System.out.println("Leyendo...: " + ((Persona) obj).getNombre());
			}
			obj = adaptadorR.readObject();
			System.out.println("Leyendo...: " + ((Persona) obj).getNombre());
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			adaptadorR.close();
			flujoR.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return obj;
	}

	public void visualizarDireccion(Persona p) {
		textoDireccion.setText(p.getDireccion());
	}

	public void añadirPersonaAlCombo() {
		comboBox.addItem(nombre.getText());
	}

	private boolean comprobarCampos() {
		return !getDireccion().getText().isEmpty() && !getNombre().getText().isEmpty();
	}
	
	public void inicializarCampos() {
		nombre.setText("");
		direccion.setText("c/");
	}
	

}

package vista;

import javax.swing.JPanel;

import contenedores.RegistroAnimal;
import java.awt.FlowLayout;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import org.json.JSONException;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollBar;

public class ListaAnimales extends JPanel {

	/**
	 * Create the panel.
	 */
	RegistroAnimal reg;
	public ListaAnimales(RegistroAnimal reg) {
		this.reg = reg;
		setLayout(null);
		try {
			reg.levantarJson();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(433, 11, 17, 278);
		add(scrollBar);
		
		JFormattedTextField formattedTextField = new JFormattedTextField(reg.listar());
		formattedTextField.setEditable(false);
		formattedTextField.setBounds(10, 11, 413, 278);
		add(formattedTextField);
		
	}
}

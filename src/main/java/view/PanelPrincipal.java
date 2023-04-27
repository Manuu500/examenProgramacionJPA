package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;

import controller.ControladorAsignatura;
import controller.ControladorDocente;
import model.Asignatura;
import model.Asignaturaspordocente;
import model.Docente;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.List;
import java.awt.event.ActionEvent;

public class PanelPrincipal extends JPanel {
	private JTextField textField;
	JComboBox comboBox;
	JList list;
	JList list_1; 
	private DefaultListModel<Asignatura> listModelAsignaturas;
	private DefaultListModel<Asignatura> listModelAsignaturas2;
	private List<Asignatura> asignaturas =  ControladorAsignatura.findAll();



	/**
	 * Create the panel.
	 */
	public PanelPrincipal() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 225, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Docentes y asignaturas");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridwidth = 8;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 2;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Filtrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.removeAllItems();
				cargarJCombo();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 2;
		add(btnNewButton, gbc_btnNewButton);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 4;
		gbc_comboBox.gridy = 3;
		add(comboBox, gbc_comboBox);
		
		JButton btnNewButton_1 = new JButton("Cargar materias");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listModelAsignaturas.removeAllElements();
				cargarMateriasMaestro();
				
				
			}

			
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 5;
		gbc_btnNewButton_1.gridy = 3;
		add(btnNewButton_1, gbc_btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Asignaturas no selecionadas");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 4;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Asignaturas selecionadas");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 5;
		gbc_lblNewLabel_2.gridy = 4;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		list = new JList(this.getDefaultListModel());
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 7;
		gbc_list.gridwidth = 3;
		gbc_list.insets = new Insets(0, 0, 0, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 1;
		gbc_list.gridy = 5;
		add(list, gbc_list);
		
		list_1 = new JList(this.getDefaultListModel2());
		GridBagConstraints gbc_list_1 = new GridBagConstraints();
		gbc_list_1.gridheight = 7;
		gbc_list_1.insets = new Insets(0, 0, 0, 5);
		gbc_list_1.fill = GridBagConstraints.BOTH;
		gbc_list_1.gridx = 5;
		gbc_list_1.gridy = 5;
		add(list_1, gbc_list_1);
		
		JButton btnNewButton_2 = new JButton("<<");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAllItems();
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 4;
		gbc_btnNewButton_2.gridy = 6;
		add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("<");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerProvincia();
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 4;
		gbc_btnNewButton_3.gridy = 7;
		add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton(">");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarProvincia2();
			}
		});
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 4;
		gbc_btnNewButton_4.gridy = 8;
		add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton(">>");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAllItems2();
			}
		});
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_5.gridx = 4;
		gbc_btnNewButton_5.gridy = 9;
		add(btnNewButton_5, gbc_btnNewButton_5);
		
		
		
	}
	
	
	/**
	 * 
	 */
	private void cargarJCombo() {
		List<Docente> lista = ControladorDocente.findByLikeDescripcion(textField.getText());
		for (Docente m : lista) {
			comboBox.addItem(m);
		}
	}
	
	
	/**
	 * M�todo que construye el modelo de JList, a utilizar para agregar y eliminar provincias
	 */
	private DefaultListModel getDefaultListModel () {
		this.listModelAsignaturas = new DefaultListModel<Asignatura>();
		return this.listModelAsignaturas;
	}
	
	
	/**
	 * M�todo que construye el modelo de JList, a utilizar para agregar y eliminar provincias
	 */
	private DefaultListModel getDefaultListModel2 () {
		this.listModelAsignaturas2 = new DefaultListModel<Asignatura>();
		return this.listModelAsignaturas2;
	}
	

	/**
	 * 
	 */
	private void agregarProvincia2() {
		listModelAsignaturas2.addElement((Asignatura) list.getSelectedValue());
		listModelAsignaturas.removeElement(list.getSelectedValue());
	}
	
	
	/**
	 * 
	 */
	private void removeAllItems() {
		listModelAsignaturas.removeAllElements();
		for (Asignatura estudiante : asignaturas) {
			this.listModelAsignaturas.addElement(estudiante);
			this.listModelAsignaturas2.removeAllElements();
		}
	}
	
	
	/**
	 * 
	 */
	private void removerProvincia() {
		listModelAsignaturas.addElement((Asignatura) list_1.getSelectedValue());
		listModelAsignaturas2.removeElement(list_1.getSelectedValue());
		
	}
	
	
	/**
	 * 
	 */
	private void agregarProvincia() {
		for (Asignatura a : asignaturas) {			
			this.listModelAsignaturas.addElement(a);
			for (int i = 0; i < listModelAsignaturas.size(); i++) {
				for (int j = 0; j < listModelAsignaturas2.size(); j++) {
					if(asignaturas.get(i) == listModelAsignaturas2.getElementAt(j)) {
						listModelAsignaturas.removeElement(a);
					}
				}
			}
		}	
	}
	
	
	/**
	 * 
	 */
	private void removeAllItems2() {
		listModelAsignaturas2.removeAllElements();
		for (Asignatura a : asignaturas) {
			this.listModelAsignaturas2.addElement(a);
			this.listModelAsignaturas.removeAllElements();
		}
	}
	
	
	/**
	 * 
	 */
	private void cargarMateriasMaestro() {	
		
		Docente d = (Docente) comboBox.getSelectedItem();
		List<Asignatura> pr = ControladorAsignatura.findById(d.getId());
			
		listModelAsignaturas2.removeAllElements();
		this.listModelAsignaturas2.addAll(pr);	
				
		agregarProvincia();	
		
		
	}
}

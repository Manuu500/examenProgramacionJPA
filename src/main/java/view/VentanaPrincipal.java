package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class VentanaPrincipal extends JFrame {
	public static String TITULO_APLICACION = "el titulito wapo amono";
	public static BufferedImage iconoApp;

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		VentanaPrincipal v = new VentanaPrincipal();
		v.setVisible(true);
	
	
	}
		
	/**
	 * 
	 */
	public VentanaPrincipal () {
		
		
		JTabbedPane tabedPane = new JTabbedPane();
		
		tabedPane.add("profesoresymaterias", new PanelPrincipal());
		this.setMinimumSize(new Dimension(800, 400));
		
		this.setContentPane(tabedPane);
	}
}

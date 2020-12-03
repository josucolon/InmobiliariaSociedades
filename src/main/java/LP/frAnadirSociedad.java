package LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class frAnadirSociedad extends JFrame {

	private JPanel contentPane;
	private JTextField textNom;
	private JTextField textCap;
	private JTextField textDir;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public frAnadirSociedad() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 553);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNom = new JTextField();
		textNom.setBounds(54, 118, 146, 26);
		contentPane.add(textNom);
		textNom.setColumns(10);
		
		textCap = new JTextField();
		textCap.setBounds(258, 118, 146, 26);
		contentPane.add(textCap);
		textCap.setColumns(10);
		
		textDir = new JTextField();
		textDir.setBounds(165, 224, 146, 26);
		contentPane.add(textDir);
		textDir.setColumns(10);
		
		JButton btnAna = new JButton("Anadir");
		btnAna.setBounds(74, 383, 115, 29);
		contentPane.add(btnAna);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(268, 383, 115, 29);
		contentPane.add(btnVolver);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(54, 85, 69, 20);
		contentPane.add(lblNombre);
		
		JLabel lblCapacidadMxima = new JLabel("Capacidad máxima");
		lblCapacidadMxima.setBounds(258, 82, 146, 20);
		contentPane.add(lblCapacidadMxima);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(165, 193, 69, 20);
		contentPane.add(lblDireccion);
		
		btnVolver.addActionListener( new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				InicioSesion ventana = null;
				try {
					ventana = new InicioSesion();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ventana.setVisible(true);
				dispose();
			}
		});
		
		btnAna.addActionListener( new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showInputDialog(this, "Anadido Correctamente!");
				textNom.setText("");
				textCap.setText("");
				textDir.setText("");
			}

		});
		

	}
}

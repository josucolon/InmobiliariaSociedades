package LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LN.Alquiler;
import LN.Usuario;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class frModificarReserva extends JFrame {

	private JPanel contentPane;
	private JTextField txtFecha;
	private JTextField txtHora;
	private JTextField txtPersonas;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public frModificarReserva(Alquiler reserva, Usuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 553);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(238, 224, 69, 20);
		contentPane.add(lblHora);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(15, 224, 69, 20);
		contentPane.add(lblFecha);
		
		JLabel lblPersonas = new JLabel("Personas");
		lblPersonas.setBounds(171, 322, 69, 20);
		contentPane.add(lblPersonas);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(15, 260, 146, 26);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		
		txtHora = new JTextField();
		txtHora.setBounds(237, 260, 146, 26);
		contentPane.add(txtHora);
		txtHora.setColumns(10);
		
		txtPersonas = new JTextField();
		txtPersonas.setBounds(161, 358, 146, 26);
		contentPane.add(txtPersonas);
		txtPersonas.setColumns(10);
		
		JButton btnAnadirReserva = new JButton("Modificar Reserva");
		btnAnadirReserva.setBounds(46, 427, 153, 29);
		contentPane.add(btnAnadirReserva);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(268, 427, 115, 29);
		contentPane.add(btnVolver);
		
		btnAnadirReserva.addActionListener( new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showInputDialog(this, "Reserva realizada!");
			}
		});
		
		btnVolver.addActionListener( new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				frPrincipal ventana = new frPrincipal(user);
				ventana.setVisible(true);
				dispose();
			}
		});
	}

}

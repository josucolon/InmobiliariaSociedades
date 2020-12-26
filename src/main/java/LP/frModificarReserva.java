package LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.DAO;
import LN.Alquiler;
import LN.Usuario;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class frModificarReserva extends JFrame {

	private JPanel contentPane;
	private JTextField textMes;
	private JTextField textAnyo;
	

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
		
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setBounds(15, 224, 69, 20);
		contentPane.add(lblDia);
		
		JTextField txtDia = new JTextField();
		txtDia.setBounds(15, 260, 43, 26);
		contentPane.add(txtDia);
		txtDia.setColumns(10);
		
		JLabel lblPersonas = new JLabel("Personas");
		lblPersonas.setBounds(15, 299, 69, 20);
		contentPane.add(lblPersonas);
		
		JTextField txtPersonas = new JTextField();
		txtPersonas.setBounds(15, 332, 146, 26);
		contentPane.add(txtPersonas);
		txtPersonas.setColumns(10);
		
		JLabel lblMes = new JLabel("Mes");
		lblMes.setBounds(83, 226, 56, 16);
		contentPane.add(lblMes);
		
		textMes = new JTextField();
		textMes.setBounds(80, 260, 43, 26);
		contentPane.add(textMes);
		textMes.setColumns(10);
		
		JLabel lblNewAnyo = new JLabel("A\u00F1o");
		lblNewAnyo.setBounds(143, 226, 56, 16);
		contentPane.add(lblNewAnyo);
		
		textAnyo = new JTextField();
		textAnyo.setBounds(143, 260, 53, 26);
		contentPane.add(textAnyo);
		textAnyo.setColumns(10);
		
		JComboBox comboBoxHora = new JComboBox();
		comboBoxHora.setBounds(243, 262, 90, 22);
		contentPane.add(comboBoxHora);
		comboBoxHora.addItem("13:00");
		comboBoxHora.addItem("14:00");
		comboBoxHora.addItem("21:00");
		comboBoxHora.addItem("22:00");
		
		JButton btnAnadirReserva = new JButton("Modificar Reserva");
		btnAnadirReserva.setBounds(46, 427, 153, 29);
		contentPane.add(btnAnadirReserva);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(268, 427, 115, 29);
		contentPane.add(btnVolver);
		
		JLabel lblerror = new JLabel("Porfavor, rellene todos los campos para modificar la reserva.");
		lblerror.setEnabled(false);
		lblerror.setForeground(Color.RED);
		lblerror.setBounds(15, 371, 440, 16);
		contentPane.add(lblerror);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(InicioSesion.class.getResource("/images/logo.png")));
		lblNewLabel.setBounds(137, 28, 217, 130);
		contentPane.add(lblNewLabel);
		
		btnAnadirReserva.addActionListener( new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				
				String diaS = txtDia.getText();
				int dia = Integer.parseInt(diaS);
				String mesS = textMes.getText();
				int mes = Integer.parseInt(mesS);
				String anyoS = textAnyo.getText();
				int anyo = Integer.parseInt(anyoS);
				String personas = txtPersonas.getText();
				int pers = Integer.parseInt(personas);
				int item = comboBoxHora.getSelectedIndex();
				int hora = 0;
				
				switch (item)
				{
				case 0: 
					hora=1;
					break;
					
				case 1:
					hora=2;
					break;
					
				case 2: 
					hora=9;
					break;
					
				case 3: 
					hora=10;
					break;
					
				case -1:
					hora =0;
					
				}
				
				if (dia != 0 || mes != 0 || anyo!=0 || pers != 0 || hora != 0)
				{
					DAO.modificarAlquiler(reserva.getId(), hora, dia, mes, anyo, user.getDni(), reserva.getIdSociedad());
				}else
				{
					lblerror.setVisible(true);
				}
				
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

package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LN.Usuario;
import javax.swing.JButton;

public class frPrincipal extends JFrame {

	private JPanel contentPane;
	private Usuario usuario;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public frPrincipal(Usuario user) 
	{
		usuario = user;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnReserva = new JButton("Reservar Sociedad");
		btnReserva.setBounds(117, 65, 166, 29);
		contentPane.add(btnReserva);
		
		JButton btnListaReservas = new JButton("Ver Reservas");
		btnListaReservas.setBounds(117, 110, 166, 29);
		contentPane.add(btnListaReservas);
		
		JButton btnModDatos = new JButton("Modificar Datos");
		btnModDatos.setBounds(117, 155, 166, 29);
		contentPane.add(btnModDatos);
		
		JButton btnVolver = new JButton("Salir");
		btnVolver.setBounds(117, 200, 166, 29);
		contentPane.add(btnVolver);
		
		btnReserva.addActionListener( new ActionListener() 
		{
				
			public void actionPerformed(ActionEvent e) 
			{
				frReservar ventana = new frReservar (user);
				ventana.setVisible(true);
				dispose();
			}
	
		});
		
		btnListaReservas.addActionListener( new ActionListener() 
		{
				
			public void actionPerformed(ActionEvent e) 
			{
				frListaReservas ventana = new frListaReservas (user);
				ventana.setVisible(true);
				dispose();
			}
	
		});
		
		btnModDatos.addActionListener( new ActionListener() 
		{
				
			public void actionPerformed(ActionEvent e) 
			{
				frModificarDatos ventana = new frModificarDatos (user);
				ventana.setVisible(true);
				dispose();
			}
	
		});
		
		btnVolver.addActionListener( new ActionListener() 
		{
				
			public void actionPerformed(ActionEvent e) 
			{
				InicioSesion ventana = null;
				try {
					ventana = new InicioSesion ();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ventana.setVisible(true);
				dispose();
			}
	
		});
	}
}

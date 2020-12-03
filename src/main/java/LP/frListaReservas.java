package LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LN.Alquiler;
import LN.Usuario;
import javax.swing.JButton;

public class frListaReservas extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public frListaReservas(Usuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 553);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnModificarReserva = new JButton("Modificar Reserva");
		btnModificarReserva.setBounds(51, 329, 178, 29);
		contentPane.add(btnModificarReserva);
		
		JButton btnEliminarReserva = new JButton("Eliminar Reserva");
		btnEliminarReserva.setBounds(291, 329, 157, 29);
		contentPane.add(btnEliminarReserva);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(194, 393, 115, 29);
		contentPane.add(btnVolver);
		
		btnModificarReserva.addActionListener( new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				Alquiler reserva = null;
				frModificarReserva ventana = new frModificarReserva(reserva , user);
				ventana.setVisible(true);
				dispose();
			}
		});
		
		btnEliminarReserva.addActionListener( new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showInputDialog(this, "Reserva eliminada!");
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

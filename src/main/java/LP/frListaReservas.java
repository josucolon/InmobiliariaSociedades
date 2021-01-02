package LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.DAO;
import LN.Alquiler;
import LN.Usuario;

import javax.swing.JButton;
import javax.swing.JTextField;
/**
 * Esta es la ventana donde se muestran las reservas que tiene el usuario. 
 * @author GrupoAmuntValencia
 *
 */
public class frListaReservas extends JFrame {

	private JPanel contentPane;
	ArrayList<Alquiler> Lista = new ArrayList<Alquiler> ();
	private DefaultListModel mdl = new DefaultListModel();
	private JTextField textId;
	private int id;
	private String idS;

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
		
		JList listReservas = new JList();
		listReservas.setBounds(12, 30, 461, 196);
		contentPane.add(listReservas);
		
		Lista = DAO.LeerAlquiler(user.getDni());
		
		for (int i=0; i < Lista.size(); i++)
		{
			mdl.addElement(Lista.get(i).getId());
		}
		
		listReservas.setModel(mdl);
		
		JLabel lblReservas = new JLabel("Reservas");
		lblReservas.setBounds(12, 13, 56, 16);
		contentPane.add(lblReservas);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(12, 252, 56, 16);
		contentPane.add(lblId);
		
		textId = new JTextField();
		textId.setBounds(12, 275, 116, 22);
		contentPane.add(textId);
		textId.setColumns(10);
		
		JLabel lblerror = new JLabel("Porfavor, introduzca el id de la reserva.");
		lblerror.setForeground(Color.RED);
		lblerror.setEnabled(false);
		lblerror.setBounds(12, 300, 436, 16);
		contentPane.add(lblerror);
		
		/**
		 * Funcionalidad del boton modificar la reserva. Se recogen los datos de la reserva que se quiere modificar y se pasan a la siguiente ventana, la de modificar la reserva.
		 */
		btnModificarReserva.addActionListener( new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				
				idS = textId.getText();
				id = Integer.parseInt(idS);
				Alquiler reserva = null; 
				
				for (int i=0; i < Lista.size(); i++)
				{
					if(Lista.get(i).getId()==id)
					{
						reserva = Lista.get(i);
					}
					
				}
			
				frModificarReserva ventana = new frModificarReserva( reserva , user);
				ventana.setVisible(true);
				dispose();
			}
		});
		
		/**
		 * Funcionalidad del boton eliminar la reserva. Recoge el id de la reserva que se quiere eliminar y se llama al metodo que borra la reserva de la BD.
		 */
		btnEliminarReserva.addActionListener( new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				idS = textId.getText();
				id = Integer.parseInt(idS);
				
				if (id == 0)
				{
					lblerror.setVisible(true);
				}else 
				{
				DAO.eliminarAlquiler(id);
				
				JOptionPane.showInputDialog(this, "Reserva eliminada!");
				}
				
			}
		});
		
		/**
		 * Funcionalidad del boton Volver. Lo que se hace es volver a la ventana anterior, en este caso a la del menu principal.
		 */
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

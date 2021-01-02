package LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.DAO;
import LN.Alquiler;
import LN.Sociedad;
import LN.Usuario;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * Esta es la ventana de Reserva.
 * @author GrupoAmuntValencia
 *
 */
public class frReservar extends JFrame {

	private JPanel contentPane;
	private JTextField textMes;
	private JTextField textAnyo;
	ArrayList<Sociedad> Lista = new ArrayList<Sociedad> ();
	private DefaultListModel mdl = new DefaultListModel();
	private JTextField textID;


	/**
	 * Create the frame.
	 */
	public frReservar(Usuario user) {
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
		
		JButton btnAnadirReserva = new JButton("Anadir Reserva");
		btnAnadirReserva.setBounds(46, 427, 153, 29);
		contentPane.add(btnAnadirReserva);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(268, 427, 115, 29);
		contentPane.add(btnVolver);
		
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
		
		JList listSociedades = new JList();
		listSociedades.setBounds(12, 13, 461, 194);
		contentPane.add(listSociedades);

		Lista = DAO.LeerSociedades();
		
		for (int i=0; i < Lista.size(); i++)
		{
			mdl.addElement(Lista.get(i).getNombre() + Lista.get(i).getId());
		}
		
		listSociedades.setModel(mdl);
		
		JLabel lblIdSociedad = new JLabel("ID Sociedad");
		lblIdSociedad.setBounds(360, 226, 75, 16);
		contentPane.add(lblIdSociedad);
		
		textID = new JTextField();
		textID.setBounds(357, 262, 84, 22);
		contentPane.add(textID);
		textID.setColumns(10);
		
		JLabel lblerror = new JLabel("Porfavor, rellene todos los datos para continuar.");
		lblerror.setEnabled(false);
		lblerror.setForeground(Color.RED);
		lblerror.setBounds(15, 390, 447, 20);
		contentPane.add(lblerror);
		
		/**
		 * Funcionalidad del boton añadir una reserva. Recoge los datos introducidos por el usuario y los guarda en la base de datos en forma de reserva.
		 */
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
				String IDs = textID.getText();
				int IDS = Integer.parseInt(IDs);
				
				
				ArrayList<Alquiler> reser = new ArrayList <Alquiler> ();
				reser= DAO.LeerAlquiler(user.getDni());
				int id =0;
				for(int i=0; i<reser.size(); i++)
				{
					 id=reser.get(i).getId() ;
				}
				
				
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
					DAO.addAlquiler(id, hora, dia, mes, anyo, user.getDni(), IDS);
				}else
				{
					lblerror.setVisible(true);
				}
				
				JOptionPane.showInputDialog(this, "Reserva realizada!");
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

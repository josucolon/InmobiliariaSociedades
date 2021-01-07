package LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import DAO.DAO;
import LN.Sociedad;

/**
 * Esta es la ventana para añadir una sociedad nueva.
 * @author GrupoAmuntValencia
 *
 */
public class frAnadirSociedad extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textCapa;
	private JTextField textDir;
	


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
		
		
		JButton btnAna = new JButton("A\u00F1adir");
		btnAna.setBounds(268, 340, 115, 51);
		contentPane.add(btnAna);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(12, 462, 92, 31);
		contentPane.add(btnVolver);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(54, 214, 69, 20);
		contentPane.add(lblNombre);
		
		JLabel lblCapacidadMxima = new JLabel("Capacidad M\u00E1xima");
		lblCapacidadMxima.setBounds(268, 214, 146, 20);
		contentPane.add(lblCapacidadMxima);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(54, 282, 69, 20);
		contentPane.add(lblDireccion);
		
		textNombre = new JTextField();
		textNombre.setBounds(54, 247, 116, 22);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textCapa = new JTextField();
		textCapa.setBounds(267, 247, 116, 22);
		contentPane.add(textCapa);
		textCapa.setColumns(10);
		
		textDir = new JTextField();
		textDir.setBounds(54, 315, 116, 22);
		contentPane.add(textDir);
		textDir.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		//lblNewLabel.setIcon(new ImageIcon(InicioSesion.class.getResource("/images/logo.png")));
		lblNewLabel.setBounds(137, 28, 217, 130);
		lblNewLabel.setIcon(new ImageIcon("images/logo.png"));
		contentPane.add(lblNewLabel);
		
		JLabel lblerror = new JLabel("Porfavor, rellene todos los datos para poder continuar.");
		lblerror.setEnabled(false);
		lblerror.setForeground(Color.RED);
		lblerror.setBounds(12, 424, 461, 16);
		contentPane.add(lblerror);
		
		
		/**
		 * Funcionalidad del boton Volver. Lo que se hace es volver a la ventana anterior, en este caso a la de inicio de sesion.
		 */
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
		
		/**
		 * Funcionalidad del boton Añadir sociedad. Lo que realiza es recoger los datos de la nueva sociedad y guardarlos en la base de datos.
		 */
		btnAna.addActionListener( new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				
				String nombre = textNombre.getText();
				String capa = textCapa.getText();
				int cap = Integer.parseInt(capa);
				String direc = textDir.getText();
				
				ArrayList<Sociedad> socis = new ArrayList <Sociedad> ();
				socis = DAO.LeerSociedades();
				int id =0;
				for(int i=0; i<socis.size(); i++)
				{
					 id=socis.get(i).getId() ;
				}
				
				
				
				
				if (nombre!= null || cap != 0 || direc!= null)
				{
					id ++;
					DAO.addSociedad(id, nombre, cap, direc);
					JOptionPane.showInputDialog(this, "Anadido Correctamente!");
					textNombre.setText("");
					textCapa.setText("");
					textDir.setText("");
				}else 
				{
					lblerror.setVisible(true);
				}
			}

		});
		

	}
}

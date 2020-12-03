package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.DropMode;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import LN.Usuario;
import DAO.DAO;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class InicioSesion extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField pwdPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

//					BD.initBD("CINESA");
//					BD.crearTablaPeliculas();
//					BD.crearTablaValoraciones();
//					BD.crearTablaUsuarios();
//					BD.crearTablaCompras();
					
					
					InicioSesion frame = new InicioSesion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public InicioSesion() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 553);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(173, 265, 132, 22);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setBounds(173, 329, 132, 22);
		contentPane.add(pwdPassword);
		
		JButton btnIniciarSesin = new JButton("Iniciar sesion");
		btnIniciarSesin.setBounds(173, 375, 132, 25);
		contentPane.add(btnIniciarSesin);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(173, 228, 89, 25);
		contentPane.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(173, 300, 113, 16);
		contentPane.add(lblPassword);
		
		//JLabel lblNewLabel = new JLabel("New label");
//		lblNewLabel.setIcon(new ImageIcon(InicioSesion.class.getResource("/images/logo.png")));
//		lblNewLabel.setBounds(137, 28, 217, 130);
//		contentPane.add(lblNewLabel);
		
		JButton bRegistro = new JButton("Registrarse");
		bRegistro.setBounds(173, 449, 132, 25);
		contentPane.add(bRegistro);
		
		JButton bAnadirSociedad = new JButton("Anadir Sociedad");
		bAnadirSociedad.setBounds(330, 449, 132, 25);
		contentPane.add(bAnadirSociedad);
		
		JLabel lblElUsuarioO = new JLabel("El usuario o la contrasena son erroneos");
		lblElUsuarioO.setVisible(false);
		lblElUsuarioO.setForeground(new Color(204, 0, 0));
		lblElUsuarioO.setBounds(118, 413, 258, 16);
		contentPane.add(lblElUsuarioO);
		
	
	btnIniciarSesin.addActionListener( new ActionListener() 
	{
			
			public void actionPerformed(ActionEvent e) 
			{
				
				Usuario user = null;
				frPrincipal ventana = new frPrincipal(user);
				ventana.setVisible(true);
				dispose();
//				String usuario = txtUsuario.getText();
//				usuario = usuario.toUpperCase();
//				String contrasenya = String.valueOf(pwdPassword.getPassword());
////				contrasenya = contrasenya.toUpperCase();
//				Usuario user = DAO.getUser(usuario);
////				try 
////				{
//				if (contrasenya.equals(user.getPassword()) )
//				{
//					frPrincipal ventana1 = new frPrincipal(user);
//					ventana1.setVisible(true);
//					dispose();
//				}
//				else
//				{
//					lblElUsuarioO.setVisible(true);
//					txtUsuario.setText("");
//					pwdPassword.setText("");
//				}
					
				
//				} 
//				catch (ClassNotFoundException e1) 
//				{
//					e1.printStackTrace();
//				}
			}
			
	});
	
	bRegistro.addActionListener( new ActionListener()
	{
		
		public void actionPerformed(ActionEvent e) 
		{
			Registro ventana = new Registro();
			ventana.setVisible(true);
			dispose();
		}
	});
	
	bAnadirSociedad.addActionListener( new ActionListener()
	{
		
		public void actionPerformed(ActionEvent e) 
		{
			frAnadirSociedad ventana = new frAnadirSociedad();
			ventana.setVisible(true);
			dispose();
		}
	});
	
	
	
	
	this.addWindowListener(new WindowListener()
	{
		public void windowClosing(WindowEvent arg0)
		{
			//BD.close();
			
		}

		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void windowDeactivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		
		public void windowDeiconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		
		public void windowIconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		
		public void windowOpened(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	});
	
	
	
	
	}
}



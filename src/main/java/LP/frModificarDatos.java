package LP;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import COMUN.clsUsuarioRepetido;
import DAO.DAO;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import LN.Alquiler;
import LN.Usuario;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.logging.Logger;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;

/**
 * Esta es la ventana para modificar los datos del usuario.
 * @author GrupoAmuntValencia
 *
 */
public class frModificarDatos extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textCorreo;
	private JTextField textApellido;
	private JTextField textContrasenya;
	private JTextField textAnyoN;
	private JTextField texttlf;
	
	private Logger logger = Logger.getLogger(this.getClass().getName());
	

	/**
	 * Create the frame.
	 */
	public frModificarDatos(Usuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 553);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(43, 69, 116, 16);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(43, 133, 116, 16);
		contentPane.add(lblApellido);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(43, 197, 116, 16);
		contentPane.add(lblContrasea);
		
		JButton bVolver = new JButton("Volver");
		bVolver.setBounds(12, 456, 98, 25);
		contentPane.add(bVolver);
		
		JButton bAceptar = new JButton("Modificar");
		bAceptar.setBounds(161, 316, 152, 43);
		contentPane.add(bAceptar);
		
		JLabel lblRegistro = new JLabel("Modificar Datos");
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblRegistro.setBounds(12, 13, 461, 43);
		contentPane.add(lblRegistro);
		
		JLabel lblMonedero = new JLabel("Tlf:");
		lblMonedero.setBounds(257, 69, 70, 16);
		contentPane.add(lblMonedero);
		
		JLabel lblEmail = new JLabel("Correo:");
		lblEmail.setBounds(257, 133, 56, 16);
		contentPane.add(lblEmail);
		
		JLabel lblAoDeNacimiento = new JLabel("A\u00F1o de Nacimiento:");
		lblAoDeNacimiento.setBounds(256, 197, 152, 16);
		contentPane.add(lblAoDeNacimiento);
		
		textNombre = new JTextField();
		textNombre.setBounds(43, 98, 116, 22);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textCorreo = new JTextField();
		textCorreo.setText("");
		textCorreo.setBounds(256, 162, 116, 22);
		contentPane.add(textCorreo);
		textCorreo.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setBounds(43, 162, 116, 22);
		contentPane.add(textApellido);
		textApellido.setColumns(10);
		
		textContrasenya = new JTextField();
		textContrasenya.setBounds(43, 226, 116, 22);
		contentPane.add(textContrasenya);
		textContrasenya.setColumns(10);
		
		textAnyoN = new JTextField();
		textAnyoN.setBounds(256, 226, 116, 22);
		contentPane.add(textAnyoN);
		textAnyoN.setColumns(10);
		
		texttlf = new JTextField();
		texttlf.setBounds(256, 98, 116, 22);
		contentPane.add(texttlf);
		texttlf.setColumns(10);
		
		
		// Escuchadores de botones
		/**
		 * Funcionalidad del boton de aceptar los cambios. Se recogen los nuevos datos del usuario y se modifican en la BD.
		 */
				bAceptar.addActionListener( new ActionListener() 
				{
					
					public void actionPerformed(ActionEvent e) 
					{
						
						try
						{
							String Nombre = textNombre.getText();
							Nombre = Nombre.toUpperCase();
							String Apellido = textApellido.getText();
							Apellido = Apellido.toUpperCase();							
							String Contrasenya = textContrasenya.getText();
							String tlf = texttlf.getText();
							int telefono = 0;
							try
							{
								 telefono = Integer.parseInt(tlf);
							}catch (NumberFormatException e1)
							{
								System.out.println(tlf + " no es un numero");
							}
							
							String correo = textCorreo.getText();
							String aoNac = textAnyoN.getText();
							int aoNacimiento = Integer.parseInt(aoNac);

							if (Nombre != null || Apellido != null || Contrasenya !=null || telefono !=0 || aoNacimiento != 0 || correo != null)	
							{
								DAO.modificarUsuario(user.getDni(), Contrasenya, Nombre, Apellido, aoNacimiento, correo, telefono);
							
								
				
								frPrincipal ventana = new frPrincipal (user);
								ventana.setVisible(true);
								dispose();
							}
							
						} 
						catch (Exception b)
						{
							error(b);
						}
						
						
						JOptionPane.showInputDialog(this, "Datos Cambiados!");
					}
				});
				
				/**
				 * Funcionalidad del boton Volver. Lo que se hace es volver a la ventana anterior, en este caso a la del menu principal.
				 */
				bVolver.addActionListener( new ActionListener() 
				{
					
					public void actionPerformed(ActionEvent e) 
					{
						frPrincipal ventana = new frPrincipal(user);
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
				}
		
						);

	}
			
				protected void errorUsuario(clsUsuarioRepetido a)
				{
					JOptionPane.showMessageDialog(this, a.getMessage());
				}
				
				protected void error(Exception b)
				{
					JOptionPane.showMessageDialog(this, b.getStackTrace());
				}

				public Logger getLogger() {
					return logger;
				}

				public void setLogger(Logger logger) {
					this.logger = logger;
				}
	}
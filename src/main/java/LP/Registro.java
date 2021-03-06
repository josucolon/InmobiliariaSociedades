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
 * Esta es la ventana de registro.
 * @author GrupoAmuntValencia
 *
 */
public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	private Logger logger = Logger.getLogger(this.getClass().getName());
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;


	/**
	 * Create the frame.
	 */
	public Registro() {
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
		
		textField = new JTextField();
		textField.setBounds(43, 98, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(43, 133, 116, 16);
		contentPane.add(lblApellido);
		
		textField_1 = new JTextField();
		textField_1.setBounds(43, 162, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblUsuario = new JLabel("DNI:");
		lblUsuario.setBounds(43, 197, 56, 16);
		contentPane.add(lblUsuario);
		
		textField_2 = new JTextField();
		textField_2.setBounds(43, 226, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(43, 263, 116, 16);
		contentPane.add(lblContrasea);
		
		textField_3 = new JTextField();
		textField_3.setBounds(43, 292, 116, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton bVolver = new JButton("Volver");
		bVolver.setBounds(12, 456, 98, 25);
		contentPane.add(bVolver);
		
		JRadioButton rdbtnAceptoLosTrminos = new JRadioButton("Acepto los t\u00E9rminos de uso de pol\u00EDtica y privacidad de la plataforma");
		rdbtnAceptoLosTrminos.setBackground(Color.LIGHT_GRAY);
		rdbtnAceptoLosTrminos.setBounds(43, 375, 420, 53);
		contentPane.add(rdbtnAceptoLosTrminos);
		
		JButton bAceptar = new JButton("Registrar");
		bAceptar.setBounds(256, 282, 152, 43);
		contentPane.add(bAceptar);
		
		JLabel lblRegistro = new JLabel("REGISTRO");
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblRegistro.setBounds(12, 13, 461, 43);
		contentPane.add(lblRegistro);
		
		JLabel lblDebeDeAceptar = new JLabel("Debe de aceptar los t\u00E9rminos de uso y la pol\u00EDtica de privacidad");
		lblDebeDeAceptar.setForeground(Color.RED);
		lblDebeDeAceptar.setBounds(65, 422, 420, 22);
		contentPane.add(lblDebeDeAceptar);
		
		JLabel lblMonedero = new JLabel("Tlf:");
		lblMonedero.setBounds(257, 69, 70, 16);
		contentPane.add(lblMonedero);
		
		JLabel lblEmail = new JLabel("Correo:");
		lblEmail.setBounds(257, 133, 56, 16);
		contentPane.add(lblEmail);
		
		textField_4 = new JTextField();
		textField_4.setBounds(257, 162, 116, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(257, 101, 116, 22);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblAoDeNacimiento = new JLabel("A\u00F1o de Nacimiento:");
		lblAoDeNacimiento.setBounds(256, 197, 152, 16);
		contentPane.add(lblAoDeNacimiento);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(257, 226, 116, 22);
		contentPane.add(textField_6);
		
		lblDebeDeAceptar.setVisible(false);
		
		/**
		 * Funcionalidad del boton aceptar. Se realizan las acciones para recoger los datos de los nuevos usuarios y añadirlos a la base de datos. 
		 */
		// Escuchadores de botones
				bAceptar.addActionListener( new ActionListener() 
				{
					
					public void actionPerformed(ActionEvent e) 
					{
						int telefono = 0;
						int aoNacimiento = 0;
//						System.out.println("prueba");
						try
						{
							
							String Nombre = textField.getText();
//							System.out.println(Nombre);
							Nombre = Nombre.toUpperCase();
							String Apellido = textField_1.getText();
//							System.out.println(Apellido);
							Apellido = Apellido.toUpperCase();
							String dni = textField_2.getText();
//							System.out.println(dni);
							dni = dni.toUpperCase();
							String Contrasea = textField_3.getText();
//							System.out.println(Contrasea);
							String tlf = textField_5.getText();
//							System.out.println("prueba5");
							try
							{
								 telefono = Integer.parseInt(tlf);
							}catch (NumberFormatException e1)
							{
								System.out.println(tlf + " no es un numero");
							}
//							System.out.println("prueba6");
							String correo = textField_4.getText();
							System.out.println(correo);
							String aoNac = textField_6.getText();
							try
							{
								 aoNacimiento = Integer.parseInt(aoNac);
							}catch (NumberFormatException e1)
							{
								System.out.println(aoNac + " no es un numero");
								
							}
//							System.out.println("prueba3");
							if (rdbtnAceptoLosTrminos.isSelected())	
							{
								boolean a = DAO.addUsuario(dni,Contrasea,Nombre,Apellido, aoNacimiento, correo, telefono);
								Usuario user = DAO.getUser(dni);
				
								frPrincipal ventana = new frPrincipal (user);
								ventana.setVisible(true);
								dispose();
							}
							else 
							{
								lblDebeDeAceptar.setVisible(true);
							}
							
							
						} 
						catch (Exception b)
						{
							error(b);
						}
					}
				});
				
				/**
				 * Funcionalidad del boton Volver. Lo que se hace es volver a la ventana anterior, en este caso a la de inicio de sesion. 
				 */
				bVolver.addActionListener( new ActionListener() 
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
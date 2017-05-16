package ui;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.TrayIcon.MessageType;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login {

	private JFrame 			frame;
	private JTextField	 	txt_usuario;
	private JPasswordField 	txt_password;
	private JLabel 			lb_usuario;
	private JLabel 			lb_password;
	private JButton 		btn_entrar;
	private JLabel 			lb_imagen;
	private ImageIcon 		i;
	private JLabel 			lblEdmodo;
	private final String	usuario = "ale";
	private final String	password = "al3";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		frame = new JFrame();
		lb_usuario = new JLabel("Usuario");                          
		lb_password = new JLabel("Password");    
		txt_usuario = new JTextField();
		txt_password = new JPasswordField();
		btn_entrar = new JButton("Entrar");                        

		lb_imagen = new JLabel("");                                
		i = new ImageIcon(Login.class.getResource("/res/icono.PNG"));
		lblEdmodo = new JLabel("Edmodo");       
		
		initialize();
		adds();
		setComponentAdapters();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setResizable(false);
		frame.setBounds(100, 100, 273, 251);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lb_usuario.setBounds(10, 53, 86, 14);
		
		txt_usuario.setBounds(10, 79, 86, 20);
		txt_usuario.setColumns(10);
		
		lb_password.setBounds(10, 110, 86, 14);
		
		txt_password.setBounds(10, 135, 86, 20);
		txt_password.setColumns(10);
		
		btn_entrar.setBounds(10, 176, 86, 23);
		
		i = new ImageIcon(i.getImage().getScaledInstance(146, 146, Image.SCALE_SMOOTH));
		lb_imagen.setIcon(i);
		lb_imagen.setBounds(106, 53, 146, 146);
		
		lblEdmodo.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		lblEdmodo.setBounds(10, 11, 158, 42);
	}
	
	/**
	 * Adds the components to the frame.
	 */
	private void adds(){
		frame.getContentPane().add(lb_usuario);
		frame.getContentPane().add(txt_usuario);
		frame.getContentPane().add(lb_password);
		frame.getContentPane().add(txt_password);
		frame.getContentPane().add(btn_entrar);
		frame.getContentPane().add(lb_imagen);
		frame.getContentPane().add(lblEdmodo);
	}
	
	/**
	 * Sets the adapters of the components
	 */
	private void setComponentAdapters() {
		btn_entrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (checkUserPass(txt_usuario.getText(), txt_password.getPassword())){
					correcto();
				}else {
					incorrecto();
				}
					
			}
		});
	}
	
	private boolean checkUserPass(String usuario, char[] password){
		String aux = new String(password, 0, password.length);
		return (usuario.equals(this.usuario) && aux.equals(this.password));
	}
	
	private void correcto(){
		i = new ImageIcon(Login.class.getResource("/res/iconoFeliz.PNG"));
		i = new ImageIcon(i.getImage().getScaledInstance(146, 146, Image.SCALE_SMOOTH));
		lb_imagen.setIcon(i);
		new JOptionPane("Aviso").showMessageDialog(null, "Usuario y contraseña correctas", "Bien", 
				JOptionPane.INFORMATION_MESSAGE);

		frame.dispose();
		GestionFrame.iniciar();
	}
	private void incorrecto() {
		i = new ImageIcon(Login.class.getResource("/res/iconoTriste.PNG"));
		i = new ImageIcon(i.getImage().getScaledInstance(146, 146, Image.SCALE_SMOOTH));
		lb_imagen.setIcon(i);
		new JOptionPane("Aviso").showMessageDialog(null, "Usuario o contraseña erróneos", "Error", 
				JOptionPane.ERROR_MESSAGE);
	}
	
}

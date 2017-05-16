package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeListener;

import exceptions.NoRellenadoException;
import models.Empleado;
import models.Empleado.Tipo;

import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionFrame {

	private JFrame frame;
	private JTextField txt_c_Nombre;
	private JTextField txt_c_Apellidos;
	private JTextField txt_c_Antiguedad;
	private JTextField txt_l_Nombre;
	private JTextField txt_l_Apellidos;
	private JTextField txt_l_Antiguedad;
	private JTabbedPane tabbedPane;
	private JPanel panelCrear;
	private JLabel lb_c_gestion;
	private JLabel lb_c_modo;
	private JLabel lb_c_nombre;
	private JLabel lb_c_apellidos;
	private JLabel lb_c_antiguedad;
	private JList list_c_Puesto;
	private JLabel lb_c_puesto;
	private JLabel lb_c_hombre;
	private JRadioButton rdbtn_c_Mujer;
	private JRadioButton rdbtn_c_Hombre;
	private ButtonGroup rdbtn_c_grp;
	private JLabel lb_c_mujer;
	private JSeparator separator_c;
	private JLabel lb_c_sueldo;
	private JSlider slider_c;
	private JLabel lb_c_mes;
	private JLabel lb_c_comentarios;
	private JScrollPane scrollPane_c;
	private JTextArea txtr_c_Comentarios;
	private JButton btn_c_crear;
	private JToggleButton tglbtn_c_Vacaciones;
	private JPanel panel_c_euros;
	private JLabel lb_c_euros;
	private JPanel panelLeer;
	private JLabel lb_l_gestion;
	private JLabel lb_l_modo;
	private JLabel lb_l_nombre;
	private JLabel lb_l_apellidos;
	private JLabel lb_l_antiguedad;
	private JList list_l_Puesto;
	private JLabel lb_l_puesto;
	private JLabel lb_l_hombre;
	private JRadioButton rdbtn_l_Mujer;
	private JRadioButton rdbtn_l_Hombre;
	private ButtonGroup rdbtn_l_grp;
	private JLabel lb_l_mujer;
	private JSeparator separator_l;
	private JLabel lb_l_sueldo;
	private JLabel lb_l_comentarios;
	private JScrollPane scrollPane_l;
	private JTextArea txtr_l_comentarios;
	private JToggleButton tglbtn_l_Vacaciones;
	private JLabel lb_l_euros;
	private JButton btn_l_Anterior;
	private JButton btn_l_Siguiente;
	private JButton btn_l_Editar;
	private JLabel lb_l_cantidadEmpleados;
	private JButton btn_l_Despedir;
	private JSlider slider_l;
	private JMenuBar menuBar;
	private JMenu mnMenu;
	JMenuItem mntmBorrartodo;
	private JMenuItem mntmAyuda;
	private LinkedList<Empleado> empleados;
	private ListIterator<Empleado> iterador;
	private int index;

	/**
	 * Launch the application.
	 */
	public static void iniciar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionFrame window = new GestionFrame();
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
	public GestionFrame() {
		initialize_frame();
		initialize_crear();
		initialize_leer();
		adds_crear();
		adds_leer();
		adapters_frame();
		adapters_crear();
		adapters_leer();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize_frame() {
		frame = new JFrame();
		menuBar = new JMenuBar();
		mnMenu = new JMenu("Ayuda");
		mntmBorrartodo = new JMenuItem("Borrar todo");

		mntmAyuda = new JMenuItem("Acerca...");
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		panelCrear = new JPanel();
		panelLeer = new JPanel();
		empleados = new LinkedList<>();

		frame.setBounds(100, 100, 565, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setJMenuBar(menuBar);

		menuBar.add(mnMenu);

		mnMenu.add(mntmBorrartodo);

		mnMenu.add(mntmAyuda);

		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		tabbedPane.addTab("Crear",
				new ImageIcon(GestionFrame.class
						.getResource("/com/sun/javafx/scene/web/skin/FontBackgroundColor_16x16_JFX.png")),
				panelCrear, null);
		tabbedPane.addTab("Leer",
				new ImageIcon(GestionFrame.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")),
				panelLeer, null);

	}

	private void initialize_crear() {
		lb_c_gestion = new JLabel("Gesti\u00F3n de Personal");
		lb_c_modo = new JLabel("Modo: Crear");
		lb_c_nombre = new JLabel("Nombre:");
		txt_c_Nombre = new JTextField();
		lb_c_apellidos = new JLabel("Apellidos:");
		txt_c_Apellidos = new JTextField();
		lb_c_antiguedad = new JLabel("Antiguedad:");
		txt_c_Antiguedad = new JTextField();
		list_c_Puesto = new JList();
		lb_c_puesto = new JLabel("Puesto:");
		lb_c_hombre = new JLabel("Hombre:");
		lb_c_mujer = new JLabel("Mujer:");
		rdbtn_c_Mujer = new JRadioButton("");
		rdbtn_c_Hombre = new JRadioButton("");
		separator_c = new JSeparator();
		lb_c_sueldo = new JLabel("Sueldo [0-10.000] euros.");
		slider_c = new JSlider();
		lb_c_mes = new JLabel("Al mes:");
		lb_c_comentarios = new JLabel("Comentarios:");
		scrollPane_c = new JScrollPane((Component) null);
		txtr_c_Comentarios = new JTextArea();
		btn_c_crear = new JButton("Crear Empleado");
		tglbtn_c_Vacaciones = new JToggleButton("Est\u00E1 de vacaciones");

		rdbtn_c_grp = new ButtonGroup();

		panelCrear.setLayout(null);
		lb_c_gestion.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lb_c_gestion.setBounds(20, 11, 228, 42);
		lb_c_modo.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lb_c_modo.setBounds(20, 64, 145, 42);
		lb_c_nombre.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_c_nombre.setBounds(29, 136, 73, 14);
		txt_c_Nombre.setColumns(10);
		txt_c_Nombre.setBounds(103, 133, 145, 20);
		lb_c_apellidos.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_c_apellidos.setBounds(29, 167, 73, 14);
		txt_c_Apellidos.setColumns(10);
		txt_c_Apellidos.setBounds(103, 164, 145, 20);
		lb_c_antiguedad.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_c_antiguedad.setBounds(29, 198, 73, 14);

		txt_c_Antiguedad.setColumns(10);
		txt_c_Antiguedad.setBounds(103, 195, 145, 20);

		list_c_Puesto.setModel(new AbstractListModel() {
			String[] values = new String[] { "Jefe Supremo", "Currante", "Programador", "Becario" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_c_Puesto.setBounds(103, 223, 145, 73);

		lb_c_puesto.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_c_puesto.setBounds(29, 224, 73, 14);

		lb_c_hombre.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_c_hombre.setBounds(29, 307, 73, 14);

		rdbtn_c_Mujer.setBounds(103, 329, 109, 23);

		rdbtn_c_Hombre.setBounds(103, 303, 109, 23);
		rdbtn_c_grp.add(rdbtn_c_Hombre);
		rdbtn_c_grp.add(rdbtn_c_Mujer);

		lb_c_mujer.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_c_mujer.setBounds(56, 332, 46, 14);

		separator_c.setOrientation(SwingConstants.VERTICAL);
		separator_c.setBounds(275, 136, 2, 265);

		lb_c_sueldo.setBounds(306, 136, 145, 14);

		slider_c.setToolTipText("");
		slider_c.setMinorTickSpacing(1000);
		slider_c.setPaintTicks(true);

		slider_c.setMaximum(10000);
		slider_c.setValue(1000);

		slider_c.setBounds(306, 155, 200, 26);

		lb_c_mes.setBounds(306, 198, 46, 14);

		lb_c_comentarios.setBounds(306, 224, 109, 14);

		scrollPane_c.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_c.setBounds(306, 249, 228, 152);
		scrollPane_c.setViewportView(txtr_c_Comentarios);

		txtr_c_Comentarios.setWrapStyleWord(true);
		txtr_c_Comentarios.setLineWrap(true);

		btn_c_crear.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btn_c_crear.setBounds(306, 25, 207, 81);

		tglbtn_c_Vacaciones.setFont(new Font("Segoe UI", Font.BOLD, 18));
		tglbtn_c_Vacaciones.setBounds(20, 359, 228, 42);
	}

	private void initialize_leer() {
		panelLeer.setLayout(null);
		lb_l_gestion = new JLabel("Gesti\u00F3n de Personal");
		lb_l_modo = new JLabel("Modo: Leer");
		lb_l_nombre = new JLabel("Nombre:");
		txt_l_Nombre = new JTextField();
		txt_l_Nombre.setEditable(false);
		lb_l_apellidos = new JLabel("Apellidos:");
		txt_l_Apellidos = new JTextField();
		txt_l_Apellidos.setEditable(false);
		lb_l_antiguedad = new JLabel("Antiguedad:");
		txt_l_Antiguedad = new JTextField();
		txt_l_Antiguedad.setEditable(false);
		list_l_Puesto = new JList();
		list_l_Puesto.setEnabled(false);
		lb_l_puesto = new JLabel("Puesto:");
		lb_l_hombre = new JLabel("Hombre:");
		lb_l_mujer = new JLabel("Mujer:");
		rdbtn_l_Mujer = new JRadioButton("");
		rdbtn_l_Mujer.setEnabled(false);
		rdbtn_l_Hombre = new JRadioButton("");
		rdbtn_l_Hombre.setEnabled(false);
		separator_l = new JSeparator();
		lb_l_sueldo = new JLabel("Sueldo [0-10.000]: ");
		lb_l_comentarios = new JLabel("Comentarios:");
		scrollPane_l = new JScrollPane((Component) null);
		txtr_l_comentarios = new JTextArea();
		txtr_l_comentarios.setEditable(false);
		tglbtn_l_Vacaciones = new JToggleButton("Est\u00E1 de vacaciones");
		tglbtn_l_Vacaciones.setEnabled(false);
		panel_c_euros = new JPanel();
		panel_c_euros.setBackground(Color.GREEN);
		lb_l_euros = new JLabel("0");
		btn_l_Anterior = new JButton("Anterior");
		btn_l_Siguiente = new JButton("Siguiente");
		lb_l_cantidadEmpleados = new JLabel("0/0");
		rdbtn_l_grp = new ButtonGroup();
		btn_l_Despedir = new JButton("Despedir");
		btn_l_Editar = new JButton("Editar");
		slider_l = new JSlider();
		slider_l.setValue(0);
		slider_l.setMaximum(0);

		lb_l_gestion.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lb_l_gestion.setBounds(20, 11, 228, 42);
		lb_l_modo.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lb_l_modo.setBounds(20, 64, 130, 42);
		lb_l_nombre.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_l_nombre.setBounds(29, 136, 73, 14);
		txt_l_Nombre.setColumns(10);
		txt_l_Nombre.setBounds(103, 133, 145, 20);
		lb_l_apellidos.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_l_apellidos.setBounds(29, 167, 73, 14);
		txt_l_Apellidos.setColumns(10);
		txt_l_Apellidos.setBounds(103, 164, 145, 20);

		lb_l_antiguedad.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_l_antiguedad.setBounds(29, 198, 73, 14);

		txt_l_Antiguedad.setColumns(10);
		txt_l_Antiguedad.setBounds(103, 195, 145, 20);

		list_l_Puesto.setModel(new AbstractListModel() {
			String[] values = new String[] { "Jefe Supremo", "Currante", "Programador", "Becario" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_l_Puesto.setBounds(103, 223, 145, 73);

		lb_l_puesto.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_l_puesto.setBounds(29, 224, 73, 14);

		lb_l_hombre.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_l_hombre.setBounds(29, 307, 73, 14);

		rdbtn_l_Mujer.setBounds(103, 329, 109, 23);

		rdbtn_l_Hombre.setBounds(103, 303, 109, 23);
		rdbtn_l_grp.add(rdbtn_l_Hombre);
		rdbtn_l_grp.add(rdbtn_l_Mujer);

		lb_l_mujer.setHorizontalAlignment(SwingConstants.TRAILING);
		lb_l_mujer.setBounds(56, 332, 46, 14);

		separator_l.setOrientation(SwingConstants.VERTICAL);
		separator_l.setBounds(275, 136, 2, 265);

		lb_l_sueldo.setBounds(306, 201, 130, 14);

		lb_l_comentarios.setBounds(306, 224, 109, 14);

		scrollPane_l.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_l.setBounds(306, 249, 228, 152);

		txtr_l_comentarios.setWrapStyleWord(true);
		txtr_l_comentarios.setLineWrap(true);
		txtr_l_comentarios.setText("Comentarios");
		scrollPane_l.setViewportView(txtr_l_comentarios);

		tglbtn_l_Vacaciones.setFont(new Font("Segoe UI", Font.BOLD, 18));
		tglbtn_l_Vacaciones.setBounds(20, 359, 228, 42);

		panel_c_euros.setBounds(362, 192, 144, 26);
		panel_c_euros.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		lb_c_euros = new JLabel("1000");
		panel_c_euros.add(lb_c_euros);
		lb_l_euros.setBounds(410, 201, 46, 14);

		btn_l_Anterior.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btn_l_Anterior.setBounds(306, 22, 109, 48);

		btn_l_Siguiente.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btn_l_Siguiente.setBounds(425, 22, 109, 48);

		slider_l.setBounds(306, 99, 228, 26);

		btn_l_Editar.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btn_l_Editar.setBounds(306, 136, 109, 58);

		btn_l_Despedir.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btn_l_Despedir.setBounds(425, 136, 109, 58);

		lb_l_cantidadEmpleados.setHorizontalAlignment(SwingConstants.CENTER);
		lb_l_cantidadEmpleados.setFont(new Font("Consolas", Font.BOLD, 15));
		lb_l_cantidadEmpleados.setBounds(383, 81, 73, 20);
	}

	private void adds_crear() {
		panelCrear.add(lb_c_gestion);
		panelCrear.add(lb_c_modo);
		panelCrear.add(lb_c_nombre);
		panelCrear.add(txt_c_Nombre);
		panelCrear.add(lb_c_apellidos);
		panelCrear.add(txt_c_Apellidos);
		panelCrear.add(lb_c_antiguedad);
		panelCrear.add(txt_c_Antiguedad);
		panelCrear.add(list_c_Puesto);
		panelCrear.add(lb_c_puesto);
		panelCrear.add(lb_c_hombre);
		panelCrear.add(rdbtn_c_Mujer);
		panelCrear.add(rdbtn_c_Hombre);
		panelCrear.add(lb_c_mujer);
		panelCrear.add(separator_c);
		panelCrear.add(lb_c_sueldo);
		panelCrear.add(slider_c);
		panelCrear.add(lb_c_mes);
		panelCrear.add(lb_c_comentarios);
		panelCrear.add(scrollPane_c);
		panelCrear.add(btn_c_crear);
		panelCrear.add(tglbtn_c_Vacaciones);
		panelCrear.add(panel_c_euros);
	}

	private void adds_leer() {
		panelLeer.add(lb_l_gestion);
		panelLeer.add(lb_l_modo);
		panelLeer.add(lb_l_nombre);
		panelLeer.add(txt_l_Nombre);
		panelLeer.add(lb_l_apellidos);
		panelLeer.add(txt_l_Apellidos);
		panelLeer.add(lb_l_antiguedad);
		panelLeer.add(txt_l_Antiguedad);
		panelLeer.add(list_l_Puesto);
		panelLeer.add(lb_l_puesto);
		panelLeer.add(lb_l_hombre);
		panelLeer.add(rdbtn_l_Mujer);
		panelLeer.add(rdbtn_l_Hombre);
		panelLeer.add(lb_l_mujer);
		panelLeer.add(separator_l);
		panelLeer.add(lb_l_sueldo);
		panelLeer.add(lb_l_comentarios);
		panelLeer.add(scrollPane_l);
		panelLeer.add(tglbtn_l_Vacaciones);
		panelLeer.add(lb_l_euros);
		panelLeer.add(btn_l_Anterior);
		panelLeer.add(btn_l_Siguiente);
		panelLeer.add(lb_l_cantidadEmpleados);
		panelLeer.add(btn_l_Despedir);
		panelLeer.add(btn_l_Editar);
		panelLeer.add(slider_l);

	}

	private void adapters_frame() {
		mntmBorrartodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "¿Desea eliminar todos los empleados?", "Aviso",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0) {
					empleados.clear();
					cargarEmpleado(true);
				}
			}
		});

		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "", "Creado por Alex, 2017", JOptionPane.INFORMATION_MESSAGE,
						new ImageIcon(Login.class.getResource("/res/pumpgirl.gif")));
			}
		});
	}

	private void adapters_crear() {
		slider_c.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int valor = slider_c.getValue();
				lb_c_euros.setForeground(Color.black);

				if (valor <= 1000)
					panel_c_euros.setBackground(Color.GREEN);
				else if (valor <= 2500)
					panel_c_euros.setBackground(Color.YELLOW);
				else if (valor <= 5000)
					panel_c_euros.setBackground(Color.ORANGE);
				else if (valor <= 8000)
					panel_c_euros.setBackground(Color.PINK);
				else if (valor <= 10000) {
					panel_c_euros.setBackground(Color.RED);
					lb_c_euros.setForeground(Color.white);
				}

				lb_c_euros.setText(valor + " Euros.");
			}
		});

		btn_c_crear.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					if (empleados.add(nuevoEmpleado())) {
						new JOptionPane("Información").showMessageDialog(null, "Empleado creado con éxito",
								"Información", JOptionPane.INFORMATION_MESSAGE);
						iterador = empleados.listIterator();
					}
				} catch (NoRellenadoException e2) {
					new JOptionPane("Error").showMessageDialog(null, e2.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				for (Empleado empleado : empleados) {
					System.out.println(empleado);
				}
			}
		});
	}

	private void adapters_leer() {
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (tabbedPane.getSelectedIndex() == 1)
					cargarEmpleado(true);
			}
		});

		btn_l_Anterior.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cargarEmpleado(false);
			}
		});

		btn_l_Siguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cargarEmpleado(true);
			}
		});

		slider_l.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (slider_l.hasFocus())
					cargarEmpleado(slider_l.getValue());
			}
		});

		btn_l_Despedir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "¿Desea despedir a este empleado?", "Aviso",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0) {
					// Despedir 1
					if (!empleados.isEmpty()) {
						iterador.remove();
						cargarEmpleado(true);
					}
				}
			}
		});

		btn_l_Editar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Mi papá aun no me ha dotado de funcionalidad", ":(",
						JOptionPane.INFORMATION_MESSAGE,
						new ImageIcon(Login.class.getResource("/res/iconoTriste.PNG")));
			}
		});
	}

	private Empleado nuevoEmpleado() {
		String nombre, apellidos;
		String antiguedad;
		Tipo puesto;
		boolean hombre;
		boolean vacaciones;
		int sueldo;
		String comentarios;

		// VALIDACION
		// Nombre
		if (!txt_c_Nombre.getText().trim().isEmpty())
			nombre = txt_c_Nombre.getText();
		else
			throw new NoRellenadoException("El campo 'Nombre' está vacío.");

		// Apellidos
		if (!txt_c_Apellidos.getText().trim().isEmpty())
			apellidos = txt_c_Apellidos.getText();
		else
			throw new NoRellenadoException("El campo 'Apellidos' está vacío.");
		// Antiguedad
		if (!txt_c_Antiguedad.getText().trim().isEmpty())
			antiguedad = txt_c_Antiguedad.getText();
		else
			throw new NoRellenadoException("El campo 'Antiguedad' está vacío.");

		// Puesto
		switch (list_c_Puesto.getSelectedIndex()) {
		case 0:
			puesto = Tipo.JEFE_SUPREMO;
			break;
		case 1:
			puesto = Tipo.CURRANTE;
			break;
		case 2:
			puesto = Tipo.PROGRAMADOR;
			break;
		case 3:
			puesto = Tipo.BECARIO;
			break;
		default:
			puesto = Tipo.BECARIO;
			throw new NoRellenadoException("El campo 'Puesto' no está seleccionado.");
		}

		// Sexo
		if (rdbtn_c_Hombre.isSelected())
			hombre = true;
		else if (rdbtn_c_Mujer.isSelected())
			hombre = false;
		else {
			hombre = true;
			throw new NoRellenadoException("No hay género seleccionado.");
		}

		// Vacaciones
		if (tglbtn_c_Vacaciones.isSelected())
			vacaciones = true;
		else
			vacaciones = false;

		// Sueldo
		sueldo = slider_c.getValue();

		// Comentarios
		comentarios = txtr_c_Comentarios.getText();

		return new Empleado(nombre, apellidos, antiguedad, puesto, hombre, vacaciones, sueldo, comentarios);
	}

	private void cargarEmpleado(boolean siguiente) {
		if (!empleados.isEmpty()) {
			Empleado e;
			if (siguiente) {
				if (iterador.hasNext()) {
					e = iterador.next();
				} else {
					iterador = empleados.listIterator(0);
					e = iterador.next();
				}

			} else {
				if (iterador.hasPrevious()) {
					e = iterador.previous();
				} else {
					iterador = empleados.listIterator(empleados.size());
					e = iterador.previous();
				}
			}
			txt_l_Nombre.setText(e.getNombre());
			txt_l_Apellidos.setText(e.getApellidos());
			txt_l_Antiguedad.setText(e.getAntiguedad());
			list_l_Puesto.setSelectedIndex((e.getPuestoSeleccionado()));
			if (e.isHombre()) {
				rdbtn_l_Hombre.setSelected(true);
				rdbtn_l_Mujer.setSelected(false);
			} else {
				rdbtn_l_Hombre.setSelected(false);
				rdbtn_l_Mujer.setSelected(true);
			}
			if (e.isVacaciones())
				tglbtn_l_Vacaciones.setSelected(true);
			else
				tglbtn_l_Vacaciones.setSelected(false);
			// Cantidad
			slider_l.setValue(iterador.nextIndex() - 1);
			slider_l.setMinimum(0);
			slider_l.setMaximum(empleados.size());
			lb_l_cantidadEmpleados.setText(iterador.nextIndex() + " / " + empleados.size());

			int sueldo = e.getSueldo();
			lb_l_euros.setText(Integer.toString(sueldo));
			if (sueldo <= 1000)
				lb_l_euros.setForeground(Color.GREEN);
			else if (sueldo <= 2500)
				lb_l_euros.setForeground(Color.YELLOW);
			else if (sueldo <= 5000)
				lb_l_euros.setForeground(Color.ORANGE);
			else if (sueldo <= 8000)
				lb_l_euros.setForeground(Color.PINK);
			else if (sueldo <= 10000) {
				lb_l_euros.setForeground(Color.RED);
			}

			if (!e.getComentarios().trim().isEmpty())
				txtr_l_comentarios.setText(e.getComentarios());
			else
				txtr_l_comentarios.setText("");
		} else {
			// Poner todo vacío
			txt_l_Nombre.setText("");
			txt_l_Apellidos.setText("");
			txt_l_Antiguedad.setText("");
			list_l_Puesto.clearSelection();
			rdbtn_l_Hombre.setSelected(false);
			rdbtn_l_Mujer.setSelected(false);
			tglbtn_l_Vacaciones.setSelected(false);
			lb_l_cantidadEmpleados.setText("0/0");
			lb_l_euros.setText("0");
			lb_l_euros.setForeground(Color.BLACK);
			txtr_l_comentarios.setText("");
		}
	}

	private void cargarEmpleado(int index) {
		if (!empleados.isEmpty()) {
			Empleado e = empleados.get(index - 1);
			txt_l_Nombre.setText(e.getNombre());
			txt_l_Apellidos.setText(e.getApellidos());
			txt_l_Antiguedad.setText(e.getAntiguedad());
			list_l_Puesto.setSelectedIndex((e.getPuestoSeleccionado()));
			if (e.isHombre()) {
				rdbtn_l_Hombre.setSelected(true);
				rdbtn_l_Mujer.setSelected(false);
			} else {
				rdbtn_l_Hombre.setSelected(false);
				rdbtn_l_Mujer.setSelected(true);
			}
			if (e.isVacaciones())
				tglbtn_l_Vacaciones.setSelected(true);
			else
				tglbtn_l_Vacaciones.setSelected(false);
			// Cantidad
			slider_l.setMinimum(0);
			slider_l.setMaximum(empleados.size());
			lb_l_cantidadEmpleados.setText(slider_l.getValue() + " / " + empleados.size());

			int sueldo = e.getSueldo();
			lb_l_euros.setText(Integer.toString(sueldo));
			if (sueldo <= 1000)
				lb_l_euros.setForeground(Color.GREEN);
			else if (sueldo <= 2500)
				lb_l_euros.setForeground(Color.YELLOW);
			else if (sueldo <= 5000)
				lb_l_euros.setForeground(Color.ORANGE);
			else if (sueldo <= 8000)
				lb_l_euros.setForeground(Color.PINK);
			else if (sueldo <= 10000) {
				lb_l_euros.setForeground(Color.RED);
			}

			if (!e.getComentarios().trim().isEmpty())
				txtr_l_comentarios.setText(e.getComentarios());
			else
				txtr_l_comentarios.setText("");
		}
	}
}

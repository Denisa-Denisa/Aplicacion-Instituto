package Instituto;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class VentanaPrincipal1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JButton botonBuscar;
	private JButton botonAlta;
	private JLabel lblNewLabel_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal1 frame = new VentanaPrincipal1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPrincipal1() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("/img2/images.png"));
		setTitle("MENÚ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 494);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		botonBuscar = new JButton("Buscar ");
		botonBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botonBuscar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int idEstudiante = Integer.parseInt(textField.getText());
				try {
					InstitutoModel institute = new InstitutoModel();

					Estudiante estudiante = institute.obtenerEstudiantePorId(idEstudiante);

					if (estudiante != null) {
						VentanaInformacion ventanaInformacion = new VentanaInformacion(estudiante, institute);
						ventanaInformacion.setVisible(true);
						dispose();

					} else {
						JOptionPane.showMessageDialog(null, "No se encontró el estudiante con el ID especificado",
								"Error", JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Error al consultar el estudiante en la base de datos", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

				try {
					InstitutoModel institute = new InstitutoModel();
					List<Asignatura> asignaturas = institute.obtenerAsignaturasPorEstudiante(idEstudiante);
					if (!asignaturas.isEmpty()) {
						VentanaAsignaturas ventanaAsignaturas = new VentanaAsignaturas(asignaturas);
						ventanaAsignaturas.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "No hay asignaturas asignados a este estudiante",
								"Informacion", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Error al obtener las asignaturas del estudiante", "Error",
							JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				}
			}
		});

		botonBuscar.setBounds(550, 30, 104, 25);
		contentPane.add(botonBuscar);

		JButton botonAlta = new JButton("Alta nueva");
		botonAlta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAlta ventanaAlta = new VentanaAlta();
				ventanaAlta.setVisible(true);
				dispose();
			}
		});

		botonAlta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botonAlta.setBounds(663, 30, 104, 25);
		contentPane.add(botonAlta);

		textField = new JTextField();
		textField.setBounds(314, 30, 227, 25);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Buscar Id: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(201, 34, 118, 17);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(117, 88, 774, 303);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] { { "8", "Lucia", "Gomez", "Mujer", "666612345", "2010-01-01", "5" },
						{ "9", "Fernando", "Alonso", "Hombre", "666234567", "2010-02-02", "6" },
						{ "10", "Marta", "Alvarez", "Mujer", "666345678", "2009-03-03", "2" },
						{ "11", "Carlos", "Martin", "Hombre", "666567896", "2009-04-04", "8" },
						{ "12", "Elena", "Hernandez", "Mujer", "666678945", "2008-05-05", "7" },
						{ "13", "Sol", "Gomez", "Mujer", "666789456", "2008-06-06", "1" },
						{ "13", "Sol", "Gomez", "Mujer", "666789456", "2008-06-06", "1" },
						{ "14", "Marcos", "Rufo", "Hombre", "666369745", "2007-07-07", "4" },
						{ "15", "Maria", "Poc", "Mujer", "666328941", "2007-08-08", "3" },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, },
				new String[] { "ID", "NOMBRE", "APELLIDO", "SEXO", "TEL\u00C9FONO", "FECHA NACIMIENTO", "CURSO" }));

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(0, 0, 975, 535);

		ImageIcon ico3 = new ImageIcon(getClass().getResource("/img2/Captura1234.PNG"));
		ImageIcon img3 = new ImageIcon(ico3.getImage().getScaledInstance(lblNewLabel_5.getWidth(),
				lblNewLabel_5.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel_5.setIcon(img3);
		contentPane.add(lblNewLabel_5);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				mostrarConfirmacionSalir();
			}
		});

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarConfirmacionSalir();
			}
		});
		btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setBackground(new Color(255, 62, 62));
		btnSalir.setBounds(569, 364, 113, 37);
		contentPane.add(btnSalir);

		setLocationRelativeTo(null);
	}

	private void mostrarConfirmacionSalir() {
		int option = JOptionPane.showConfirmDialog(VentanaPrincipal1.this, "¿Estás seguro de que deseas salir?",
				"Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (option == JOptionPane.YES_OPTION) {
			dispose();
			System.exit(0);
		}
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

}

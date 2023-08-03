package Instituto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

public class VentanaAlta extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private BaseDatos baseDatos;
	private JComboBox comboBox;
	private JRadioButton rdbtnNewRadioButton;
	private JCalendar calendar;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAlta frame = new VentanaAlta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaAlta() {
		setTitle("CREAR ALUMNO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 480);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("DATOS GENERALES");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(20, 11, 115, 14);
		contentPane.add(lblNewLabel);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Hombre");
		rdbtnNewRadioButton.setBounds(10, 119, 86, 32);
		contentPane.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Mujer");
		rdbtnNewRadioButton_1.setBounds(112, 119, 86, 32);
		contentPane.add(rdbtnNewRadioButton_1);

		JLabel lblNewLabel_1 = new JLabel("Nombre: ");
		lblNewLabel_1.setBounds(10, 61, 56, 14);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(66, 55, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Apellido:");
		lblNewLabel_2.setBounds(10, 86, 56, 14);
		contentPane.add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setBounds(66, 80, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(82, 158, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Teléfono:");
		lblNewLabel_3.setBounds(10, 161, 73, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Fecha nacimiento:");
		lblNewLabel_4.setBounds(10, 224, 125, 14);
		contentPane.add(lblNewLabel_4);

		JCalendar calendar = new JCalendar();
		calendar.setBounds(153, 201, 306, 144);
		contentPane.add(calendar);

		JLabel lblNewLabel_5 = new JLabel("Clase:");
		lblNewLabel_5.setBounds(10, 352, 46, 14);
		contentPane.add(lblNewLabel_5);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "1a", "1b", "2a", "2b", "3a", "3c", "4a", "4b" }));
		comboBox.setBounds(53, 348, 73, 22);
		contentPane.add(comboBox);

		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(360, 2, 151, 144);

		ImageIcon ico4 = new ImageIcon(getClass().getResource("/img2/Capturap.PNG"));
		ImageIcon img4 = new ImageIcon(ico4.getImage().getScaledInstance(lblNewLabel_6.getWidth(),
				lblNewLabel_6.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel_6.setIcon(img4);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(108, 11, 339, 190);
		ImageIcon ico8 = new ImageIcon(getClass().getResource("/img2/Captura666.PNG"));
		ImageIcon img8 = new ImageIcon(ico8.getImage().getScaledInstance(lblNewLabel_8.getWidth(),
				lblNewLabel_8.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel_8.setIcon(img8);
		contentPane.add(lblNewLabel_8);

		JButton btnNewButton = new JButton("GUARDAR");
		btnNewButton.setBounds(436, 382, 125, 22);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("ATRÁS");
		btnNewButton_1.setBounds(319, 382, 107, 22);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_7 = new JLabel("ID:");
		lblNewLabel_7.setBounds(20, 36, 46, 14);
		contentPane.add(lblNewLabel_7);

		textField_3 = new JTextField();
		textField_3.setBounds(66, 33, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String idEstudianteText = textField_3.getText();
					String selectedCurso = comboBox.getSelectedItem().toString();
					String numericPart = selectedCurso.substring(0, selectedCurso.length() - 1);
					java.util.Date utilDate = calendar.getDate();
					java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

					if (!idEstudianteText.isEmpty()) {
						int idEstudiante = Integer.parseInt(idEstudianteText);
						Estudiante estudiante = new Estudiante();
						estudiante.setIdEstudiante(idEstudiante);
						estudiante.setNombreEstudiante(textField.getText());
						estudiante.setApellido(textField_1.getText());
						estudiante.setSexo(rdbtnNewRadioButton.isSelected() ? "Hombre" : "Mujer");
						estudiante.setTelefono(textField_2.getText());
						estudiante.setFechaNacimiento(sqlDate);
						estudiante.setIdCurso(Integer.parseInt(numericPart));

						crearEstudiante(estudiante);
					} else {
						JOptionPane.showMessageDialog(null, "Introduce un ID válido", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "ID inválido", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (SQLException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error al crear el estudiante en la base de datos", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal1 ventanaPrincipal = new VentanaPrincipal1();
				ventanaPrincipal.setVisible(true);
				dispose();
			}
		});
	}

	private void crearEstudiante(Estudiante estudiante) throws SQLException {
		BaseDatos bd = new BaseDatos();

		String sql = "INSERT INTO estudiante (idEstudiante, nombreEstudiante, apellido, sexo, telefono, fechaNacimiento, idCurso) VALUES (?, ?, ?, ?, ?, ?, ?)";
		Object[] params = new Object[7];
		params[0] = estudiante.getIdEstudiante();
		params[1] = estudiante.getNombreEstudiante();
		params[2] = estudiante.getApellido();
		params[3] = estudiante.getSexo();
		params[4] = estudiante.getTelefono();
		params[5] = estudiante.getFechaNacimiento();
		params[6] = estudiante.getIdCurso();
		int n = bd.execute(sql, params);

		if (n > 0) {
			JOptionPane.showMessageDialog(null, "Estudiante creado correctamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "No se pudo crear el estudiante", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private static class __Tmp {
		private static void __tmp() {
			javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}

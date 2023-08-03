package Instituto;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class VentanaInformacion extends JFrame {

	private JPanel contentPane;
	private Estudiante estudiante;
	private JTextField txtIdEstudiante;
	private JTextField textField;
	private InstitutoModel institute;

	public VentanaInformacion(Estudiante estudiante, InstitutoModel institute) {
		this.estudiante = estudiante;
		this.institute = institute;

		setBackground(new Color(255, 255, 255));
		setTitle("INFORMACION");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 429);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		txtIdEstudiante = new JTextField();

		textField = new JTextField();
		textField.setBounds(66, 39, 86, 20);
		contentPane.add(textField);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("Información del Estudiante");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(-72, 11, 414, 25);
		contentPane.add(lblTitulo);

		JLabel lblId = new JLabel("ID: " + estudiante.getIdEstudiante());
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(30, 60, 200, 20);
		contentPane.add(lblId);

		JLabel lblNombre = new JLabel("Nombre: " + estudiante.getNombreEstudiante());
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(30, 90, 200, 20);
		contentPane.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido: " + estudiante.getApellido());
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido.setBounds(30, 120, 200, 20);
		contentPane.add(lblApellido);

		JLabel lblSexo = new JLabel("Sexo: " + estudiante.getSexo());
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSexo.setBounds(30, 150, 200, 20);
		contentPane.add(lblSexo);

		JLabel lblTelefono = new JLabel("Teléfono: " + estudiante.getTelefono());
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefono.setBounds(30, 180, 200, 20);
		contentPane.add(lblTelefono);

		JLabel lblFechaNacimiento = new JLabel("Fecha de Nacimiento: " + estudiante.getFechaNacimiento());
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaNacimiento.setBounds(30, 210, 250, 20);
		contentPane.add(lblFechaNacimiento);

		try {
			Curso curso = estudiante.getCurso();
			if (curso != null) {
				JLabel lblCurso = new JLabel("Curso: " + curso.getNumero() + curso.getLetra());
				lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblCurso.setBounds(30, 240, 300, 20);
				contentPane.add(lblCurso);
			} else {
				JLabel lblCurso = new JLabel("Curso: No asignado");
				lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblCurso.setBounds(30, 240, 300, 20);
				contentPane.add(lblCurso);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(40, 83, 359, 240);
		ImageIcon ico3 = new ImageIcon(getClass().getResource("/img2/Captura666.PNG"));
		ImageIcon img3 = new ImageIcon(ico3.getImage().getScaledInstance(lblNewLabel_4.getWidth(),
				lblNewLabel_4.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel_4.setIcon(img3);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(398, 11, 151, 144);

		ImageIcon ico4 = new ImageIcon(getClass().getResource("/img2/Capturap.PNG"));
		ImageIcon img4 = new ImageIcon(ico4.getImage().getScaledInstance(lblNewLabel_6.getWidth(),
				lblNewLabel_6.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel_6.setIcon(img4);
		contentPane.add(lblNewLabel_6);

		JButton btnNewButton = new JButton("ACTUALIZAR");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(10, 342, 115, 23);
		contentPane.add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaActualizarAlumno VentanaActualizarAlumno = new VentanaActualizarAlumno();
				VentanaActualizarAlumno.setVisible(true);
				dispose();
			}
		});

		JButton btnNewButton_1 = new JButton("ELIMINAR");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBounds(136, 342, 103, 23);
		contentPane.add(btnNewButton_1);

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idEstudianteText = textField.getText().trim();
				if (!idEstudianteText.isEmpty()) {
					try {
						int idEstudiante = Integer.parseInt(idEstudianteText);
						institute.eliminarEstudiante(idEstudiante);
						JOptionPane.showMessageDialog(null, "Estudiante eliminado correctamente", "Informacion",
								JOptionPane.INFORMATION_MESSAGE);
						textField.setText("");
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "ID de estudiante no valido", "Error",
								JOptionPane.ERROR_MESSAGE);
						ex.printStackTrace();
					} catch (SQLException ex) {
						JOptionPane.showMessageDialog(null, "Error al eliminar el estudiante", "Error",
								JOptionPane.ERROR_MESSAGE);
						ex.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Por favor, ingrese un ID de estudiante", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JButton btnNewButton_2 = new JButton("ATRÁS");
		btnNewButton_2.setBounds(249, 342, 104, 23);
		contentPane.add(btnNewButton_2);

		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal1 ventanaPrincipal = new VentanaPrincipal1();
				ventanaPrincipal.setVisible(true);
				dispose();
			}
		});
	}

	private void eliminarEstudiante(int idEstudiante) throws SQLException {
		BaseDatos bd = new BaseDatos();

		String sql = "DELETE FROM estudiante WHERE idEstudiante=?";
		Object[] params = new Object[1];
		int n = bd.execute(sql, params);

		if (n > 0) {
			JOptionPane.showMessageDialog(null, "Estudiante actualizado correctamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "No se pudo actualizar el estudiante", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}

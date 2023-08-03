package Instituto;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaLogin extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin frame = new VentanaLogin();
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
	public VentanaLogin() {
		setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage("/img2/images.png"));
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 502);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("USUARIO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(350, 92, 123, 20);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("CONTRASEÑA");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(350, 187, 147, 27);
		contentPane.add(lblNewLabel_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(351, 214, 221, 27);
		contentPane.add(passwordField);

		textField = new JTextField();
		textField.setBounds(351, 119, 221, 27);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("ENTRAR");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = textField.getText();
				String contrasena = new String(passwordField.getPassword());

				if (usuario.equals("instituto") && contrasena.equals("cervantes")) {
					VentanaPrincipal1 ventanaPrincipal = new VentanaPrincipal1();
					ventanaPrincipal.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 62, 62));
		btnNewButton.setBounds(569, 364, 113, 37);
		contentPane.add(btnNewButton);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Mostrar contraseña");
		chckbxNewCheckBox.setBounds(351, 248, 140, 23);
		contentPane.add(chckbxNewCheckBox);

		chckbxNewCheckBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					passwordField.setEchoChar((char) 0);
				} else {
					passwordField.setEchoChar('\u25cf');
				}
			}
		});

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 318, 474);

		ImageIcon ico = new ImageIcon(getClass().getResource("/img2/1200px-Logotipo_del_Instituto_Cervantes.svg.png"));
		ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(lblNewLabel_2.getWidth(),
				lblNewLabel_2.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel_2.setIcon(img);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(445, 73, 36, 39);

		ImageIcon ico1 = new ImageIcon(getClass().getResource("/img2/images.png"));
		ImageIcon img1 = new ImageIcon(ico1.getImage().getScaledInstance(lblNewLabel_3.getWidth(),
				lblNewLabel_3.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel_3.setIcon(img1);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(479, 173, 46, 37);

		ImageIcon ico2 = new ImageIcon(getClass().getResource("/img2/Captura.PNG"));
		ImageIcon img2 = new ImageIcon(ico2.getImage().getScaledInstance(lblNewLabel_4.getWidth(),
				lblNewLabel_4.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel_4.setIcon(img2);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(267, 0, 521, 535);

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
		int option = JOptionPane.showConfirmDialog(VentanaLogin.this, "¿Estás seguro de que deseas salir?",
				"Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (option == JOptionPane.YES_OPTION) {
			dispose();
			System.exit(0);
		}
	}
}

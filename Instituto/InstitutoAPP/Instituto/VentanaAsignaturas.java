package Instituto;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VentanaAsignaturas extends JFrame {

	private JTextArea txtAreaAsignaturas;

	public VentanaAsignaturas(List<Asignatura> asignaturas) {
		super("Lista de Asignaturas");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		txtAreaAsignaturas = new JTextArea();
		txtAreaAsignaturas.setEditable(false);

		StringBuilder sb = new StringBuilder();
		for (Asignatura asignatura : asignaturas) {
			sb.append("ID: ").append(asignatura.getIdAsignatura()).append("\n");
			sb.append("Nombre: ").append(asignatura.getNombreAsignatura()).append("\n");
		}
		txtAreaAsignaturas.setText(sb.toString());

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		add(new JScrollPane(txtAreaAsignaturas), BorderLayout.CENTER);
		add(btnCerrar, BorderLayout.SOUTH);
	}
}

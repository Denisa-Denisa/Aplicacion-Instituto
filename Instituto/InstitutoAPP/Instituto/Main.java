package Instituto;

import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		try {
			BaseDatos bd = new BaseDatos();
			InstitutoModel institutoModel = new InstitutoModel();
			VentanaLogin VentanaLogin = new VentanaLogin();
			VentanaLogin.setVisible(true);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos", "Error",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();

		}
	}

}

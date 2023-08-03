package Instituto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDatos {

	private Connection conn;
	private final String url;
	private final String user;
	private final String password;

	public BaseDatos() throws SQLException {
		super();
		String db_ip = System.getenv().get("DB_IP") != null ? System.getenv().get("DB_IP") : "localhost";
		String db_port = System.getenv().get("DB_PORT") != null ? System.getenv().get("DB_PORT") : "3306";
		String db_name = System.getenv().get("DB_NAME") != null ? System.getenv().get("DB_NAME") : "instituto";
		String db_user = System.getenv().get("DB_USER") != null ? System.getenv().get("DB_USER") : "user";
		String db_password = System.getenv().get("DB_PASSWORD") != null ? System.getenv().get("DB_PASSWORD")
				: "password";
		url = "jdbc:mysql://" + db_ip + ":" + db_port + "/" + db_name;
		user = db_user;
		password = db_password;
		conn = DriverManager.getConnection(url, user, password);
	}

	public ResultSet query(String sql, Object[] parametros) throws SQLException {

		PreparedStatement stm = conn.prepareStatement(sql);
		for (int i = 0; i < parametros.length; i++) {
			stm.setObject(i + 1, parametros[i]);
		}
		return stm.executeQuery();
	}

	public int execute(String sql, Object[] parametros) throws SQLException {

		PreparedStatement stm = conn.prepareStatement(sql);
		for (int i = 0; i < parametros.length; i++) {
			stm.setObject(i + 1, parametros[i]);
		}
		return stm.executeUpdate();
	}

}

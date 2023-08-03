package Instituto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstitutoModel {

	private BaseDatos bd;

	public InstitutoModel() throws SQLException {
		super();
		bd = new BaseDatos();
	}

	public Estudiante obtenerEstudiantePorId(int idEstudiante) throws SQLException {

		String sql = "SELECT * FROM estudiante WHERE idEstudiante=?";
		Object[] params = new Object[1];
		params[0] = idEstudiante;
		ResultSet resultSet = bd.query(sql, params);

		Estudiante estudiante = null;

		if (resultSet.next()) {
			estudiante = new Estudiante(resultSet.getInt("idEstudiante"), resultSet.getString("nombreEstudiante"),
					resultSet.getString("apellido"), resultSet.getString("sexo"), resultSet.getString("telefono"),
					resultSet.getDate("fechaNacimiento"), resultSet.getInt("idCurso"));
		}

		return estudiante;
	}

	public int crearEstudiante(Estudiante estudiante) throws SQLException {

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
		return n;

	}

	public int actualizarEstudiante(Estudiante estudiante) throws SQLException {

		String sql = "UPDATE estudiante SET nombreEstudiante=?, apellido=?, sexo=?, telefono=?, fechaNacimiento=?, idCurso=? WHERE idEstudiante=?";
		Object[] params = new Object[7];
		params[0] = estudiante.getNombreEstudiante();
		params[1] = estudiante.getApellido();
		params[2] = estudiante.getSexo();
		params[3] = estudiante.getTelefono();
		params[4] = estudiante.getFechaNacimiento();
		params[5] = estudiante.getIdCurso();
		params[6] = estudiante.getIdEstudiante();
		int n = bd.execute(sql, params);
		return n;

	}

	public int eliminarEstudiante(int idEstudiante) throws SQLException {

		String sql = "DELETE FROM estudiante WHERE idEstudiante=?";
		Object[] params = new Object[1];
		int n = bd.execute(sql, params);
		return n;

	}

	public List<Estudiante> obtenerTodosLosEstudiante() throws SQLException {

		String sql = "SELECT * FROM estudiante";
		Object[] params = new Object[0];
		ResultSet resultSet = bd.query(sql, params);

		List<Estudiante> estudiantes = new ArrayList<>();

		while (resultSet.next()) {
			Estudiante estudiante = new Estudiante(resultSet.getInt("idEstudiante"), resultSet.getString("nombre"),
					resultSet.getString("apellido"), resultSet.getString("sexo"), resultSet.getString("telefono"),
					resultSet.getDate("fechaNacimiento"), resultSet.getInt("idCurso"));
			estudiantes.add(estudiante);
		}

		return estudiantes;

	}

	public List<Asignatura> obtenerTodasLasAsignaturas() throws SQLException {

		String sql = "SELECT * FROM asignatura";
		Object[] params = new Object[0];
		ResultSet resultSet = bd.query(sql, params);

		List<Asignatura> asignaturas = new ArrayList<>();

		while (resultSet.next()) {
			Asignatura asignatura = new Asignatura(resultSet.getInt("idAsignatura"), resultSet.getString("nombre"));
			asignaturas.add(asignatura);
		}

		return asignaturas;
	}

	public List<Asignatura> obtenerAsignaturasPorEstudiante(int idEstudiante) throws SQLException {

		String sql = "SELECT a.* FROM asignatura a INNER JOIN asignatura_has_estudiante ea ON a.idAsignatura = asignatura_IdAsignatura WHERE estudiante_IdEstudiante=?";
		Object[] params = new Object[1];
		params[0] = idEstudiante;
		ResultSet resultSet = bd.query(sql, params);

		List<Asignatura> asignaturas = new ArrayList<>();

		while (resultSet.next()) {
			Asignatura asignatura = new Asignatura(resultSet.getInt("idAsignatura"),
					resultSet.getString("nombreAsignatura"));
			asignaturas.add(asignatura);
		}

		return asignaturas;
	}

	public int crearAsignatura(Asignatura asignatura) throws SQLException {

		String sql = "INSERT INTO asignatura (idAsignatura, nombreAsignatura) VALUES (?, ?)";
		Object[] params = new Object[2];
		params[0] = asignatura.getIdAsignatura();
		params[1] = asignatura.getNombreAsignatura();
		int n = bd.execute(sql, params);
		return n;
	}

	public List<Curso> obtenerTodosLosCursos() throws SQLException {

		String sql = "SELECT * FROM curso";
		Object[] params = new Object[0];
		ResultSet resultSet = bd.query(sql, params);

		List<Curso> cursos = new ArrayList<>();

		while (resultSet.next()) {
			Curso curso = new Curso(resultSet.getInt("idCurso"), resultSet.getInt("numero"),
					resultSet.getString("letra"));
			cursos.add(curso);
		}

		return cursos;
	}

	public Curso obtenerCursoPorEstudiante(int idEstudiante) throws SQLException {

		String sql = "SELECT c.* FROM curso c INNER JOIN estudiante e ON c.idCurso = e.idCurso WHERE e.idEstudiante=?";
		Object[] params = new Object[1];
		params[0] = idEstudiante;
		ResultSet resultSet = bd.query(sql, params);

		Curso curso = null;
		if (resultSet.next()) {
			curso = new Curso(resultSet.getInt("idCurso"), resultSet.getInt("numero"), resultSet.getString("letra"));
		}

		return curso;
	}

}

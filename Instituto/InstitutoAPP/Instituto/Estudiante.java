package Instituto;

import java.sql.Date;
import java.sql.SQLException;

public class Estudiante {

	private int idEstudiante;
	private String nombreEstudiante;
	private String apellido;
	private String sexo;
	private String telefono;
	private java.util.Date fechaNacimiento;
	private int idCurso;

	public Estudiante() {
	}

	public Estudiante(int idEstudiante, String nombreEstudiante, String apellido, String sexo, String telefono,
			java.util.Date fechaNacimiento2, int idCurso) {
		this.idEstudiante = idEstudiante;
		this.nombreEstudiante = nombreEstudiante;
		this.apellido = apellido;
		this.sexo = sexo;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento2;
		this.idCurso = idCurso;
	}

	public int getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public String getNombreEstudiante() {
		return nombreEstudiante;
	}

	public void setNombreEstudiante(String nombreEstudiante) {
		this.nombreEstudiante = nombreEstudiante;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public java.util.Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	@Override
	public String toString() {
		return "Estudiante{" + "idEstudiante=" + idEstudiante + ", nombre='" + nombreEstudiante + '\'' + ", apellido='"
				+ apellido + '\'' + ", sexo='" + sexo + '\'' + ", telefono='" + telefono + '\'' + ", fechaNacimiento="
				+ fechaNacimiento + ", idCurso=" + idCurso + '}';
	}

	public Curso getCurso() throws SQLException {
		InstitutoModel institute = new InstitutoModel();
		return institute.obtenerCursoPorEstudiante(idCurso);
	}

}

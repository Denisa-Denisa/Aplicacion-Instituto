package Instituto;

public class Asignatura {

	private int idAsignatura;
	private String nombreAsignatura;

	public Asignatura(int idAsignatura, String nombreAsignatura) {
		this.idAsignatura = idAsignatura;
		this.nombreAsignatura = nombreAsignatura;
	}

	public int getIdAsignatura() {
		return idAsignatura;
	}

	public void setIdAsignatura(int idAsignatura) {
		this.idAsignatura = idAsignatura;
	}

	public String getNombreAsignatura() {
		return nombreAsignatura;
	}

	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}
}

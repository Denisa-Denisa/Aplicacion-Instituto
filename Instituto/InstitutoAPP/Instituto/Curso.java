package Instituto;

public class Curso {

	private int idCurso;
	private int numero;
	private String letra;

	public Curso(int idCurso, int numero, String letra) {
		this.idCurso = idCurso;
		this.numero = numero;
		this.letra = letra;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

}

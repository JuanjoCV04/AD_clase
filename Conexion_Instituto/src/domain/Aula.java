package domain;


public class Aula {
	
	private String num_aula;
	private String cod_edificio;
	
	public Aula() {
		
	}
	
	public Aula(String num_aula, String cod_edificio) {
		super();
		this.num_aula = num_aula;
		this.cod_edificio = cod_edificio;
	}

	public String getNum_aula() {
		return num_aula;
	}

	public void setNum_aula(String num_aula) {
		this.num_aula = num_aula;
	}

	public String getCod_edificio() {
		return cod_edificio;
	}

	public void setCod_edificio(String cod_edificio) {
		this.cod_edificio = cod_edificio;
	}

	@Override
	public String toString() {
		return "Aula [num_aula=" + num_aula + ", cod_edificio=" + cod_edificio + "]";
	}
	
	
	
}

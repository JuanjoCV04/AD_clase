package domain;

public class CodigoPostal {

	private String cp;
	private String poblacion;
	private String provincia;
	
	
	public CodigoPostal() {
		
	}

	public CodigoPostal(String cp, String poblacion, String provincia) {
		super();
		this.cp = cp;
		this.poblacion = poblacion;
		this.provincia = provincia;
	}
	
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@Override
	public String toString() {
		return "CodigoPostal [cp=" + cp + ", poblacion=" + poblacion + ", provincia=" + provincia + "]";
	}
	
}

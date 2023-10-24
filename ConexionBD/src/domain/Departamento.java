package domain;

public class Departamento {

	private String codDepto;
	private String nombreDpto;
	private String ciudad;
	private String codDirector;
	
	
	public Departamento() {
		
	}
	
	public Departamento(String codDepto, String nombreDpto, String ciudad, String codDirector) {
		super();
		this.codDepto = codDepto;
		this.nombreDpto = nombreDpto;
		this.ciudad = ciudad;
		this.codDirector = codDirector;
	}
	
	


	public Departamento(String codDepto) {
		super();
		this.codDepto = codDepto;
	}

	public String getCodDepto() {
		return codDepto;
	}
	public void setCodDepto(String codDepto) {
		this.codDepto = codDepto;
	}
	public String getNombreDepto() {
		return nombreDpto;
	}
	public void setNombreDepto(String nombreDepto) {
		this.nombreDpto = nombreDepto;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getCodDirector() {
		return codDirector;
	}
	public void setCodDirector(String codDirector) {
		this.codDirector = codDirector;
	}

	@Override
	public String toString() {
		return "Departamento [codDepto=" + codDepto + ", nombreDpto=" + nombreDpto + ", ciudad=" + ciudad
				+ ", codDirector=" + codDirector + "]";
	}
	
	
	

}

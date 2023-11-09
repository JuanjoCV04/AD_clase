package domain;

public class Departamento {

	private String cod_departamento;
	private String nombre;
	private String deescripcion;
	
	public Departamento() {
		
	}
	
	public Departamento(String cod_departamento, String nombre, String deescripcion) {
		super();
		this.cod_departamento = cod_departamento;
		this.nombre = nombre;
		this.deescripcion = deescripcion;
	}
	
	public String getCod_departamento() {
		return cod_departamento;
	}
	public void setCod_departamento(String cod_departamento) {
		this.cod_departamento = cod_departamento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDeescripcion() {
		return deescripcion;
	}
	public void setDeescripcion(String deescripcion) {
		this.deescripcion = deescripcion;
	}
	
	
	@Override
	public String toString() {
		return "Departamento [cod_departamento=" + cod_departamento + ", nombre=" + nombre + ", deescripcion="
				+ deescripcion + "]";
	}
	
	
	
	
	
	
	
}

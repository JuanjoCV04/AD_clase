package polimorf;

public class Animal {

	int health = 100;
	String tipo = null;

	
	
	public Animal(int health, String tipo) {
		this.health = health;
		this.tipo = tipo;
	}
	
	public Animal() {
		tipo="Animal";
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public String aCadena() {
		return "Clase del objeto: " + this.getClass().getName() +
	               "\nTipo: " + tipo +
	               "\nSalud: " + health+"\n"; 
	}
	public void visualiza() {
        System.out.println(aCadena());
    }
	
}

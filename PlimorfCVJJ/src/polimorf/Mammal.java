package polimorf;

public class Mammal extends Animal {

	public Mammal() {
	tipo="Mamifero";
	}

	public Mammal(int health, String tipo) {
		super(health, tipo);
	}
	public Mammal(String tipo) {
        super();
        this.setTipo(tipo);
    }
	
	
	
}

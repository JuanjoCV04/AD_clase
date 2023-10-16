package polimorf;

public class Cat extends Mammal {

	int lifes = 7;

	public Cat() {
		tipo = "Cat";
	}

	public Cat(int health, String tipo, int lifes) {
		super(health, tipo);
		this.lifes = lifes;
	}

	public String aCadena() {
		return super.aCadena() +
	               "Vidas:" + lifes + "\n"; 
		
	}

}

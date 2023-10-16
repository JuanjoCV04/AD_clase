package polimorf;

public class Dog extends Mammal {

	String size = null;

	public Dog(String size) {
		tipo ="Dog";
        this.size = size;
    }

	
	public String aCadena() {
		return super.aCadena() + "Size:" + size + "\n"; 
	}
	
}

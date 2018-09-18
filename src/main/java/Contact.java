public class Contact{
	
	//VARIABLES
	
	private String name;
	
	//CONSTRUCTEUR
	public Contact() {
		this.name = null;
	}
	
	public Contact(String nom) {
		this.name = nom;
	}
	
	//METH PUBLIC
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String nom) {
		this.name = nom;
	}
	
	
	
}
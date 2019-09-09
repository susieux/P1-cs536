
public class Sym {
	private String symType;
//	The Sym class must be in a file named Sym.java. You must implement the following Sym constructor and public methods (and no other public or protected methods):

	//This is the constructor; it should initialize the Sym to have the given type.
	public Sym(String type) {
		this.symType = type;
	}
	
	//Return this Sym's type.
	public String getType() {
		return symType;
	}
	
	//Return this Sym's type. (This method will be changed later in a future project when more information is stored in a Sym.)
	public String toString() {
		return getType();
	}
}

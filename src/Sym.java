/**
 * This class implements the Sym constructor and simple public methods-
 * getType() and toString().
 * 
 * @author Susie
 */
public class Sym {
	private String symType;

	/**
	 * The constructor initializes the field symType to the defined type.
	 *
	 * @param type is the identifier represented by a String
	 */
	public Sym(String type) {
		this.symType = type;
	}

	/**
	 * getType() returns the Sym's given type.
	 *
	 * @return type of Sym.
	 */
	public String getType() {
		return symType;
	}

	/**
	 * toString() presently returns the Sym's type, although it will be changed
	 * in a future project.
	 *
	 * @return type of Sym.
	 */
	public String toString() {
		return getType();
	}
}

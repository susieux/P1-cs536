import java.util.*;

public class SymTable {
	private List<HashMap<String, Sym>> symList;
	
	
	//This is the constructor; it should initialize the�SymTable's List field to contain a single, empty�HashMap.
	public SymTable () {
		symList = new LinkedList<HashMap<String, Sym>>();
		symList.add(new HashMap<String, Sym>());
	}
	
	//If this�SymTable's list is empty, throw an�EmptySymTableException. 
	//If either�name�or�sym�(or both) is�null, throw a�NullPointerException. 
	//If the first�HashMap�in the list already contains the given name as a key, throw a�DuplicateSymException. 
	//Otherwise, add the given�name�and�sym�to the first�HashMap�in the list.
	public void addDecl(String name, Sym sym) throws DuplicateSymException, EmptySymTableException {
		if (symList.isEmpty()) {
			throw new EmptySymTableException();
		}
		
		if (name == null || sym == null) {
			throw new NullPointerException();
		}
		
		if (symList.get(0).containsKey(name)) {
			throw new DuplicateSymException();
		}
		
		symList.get(0).put(name, sym);
		
	}
	
	//Add a new, empty�HashMap�to the front of the list.
	public void addScope() {
		symList.add(0, new HashMap<String, Sym>());
		
	}
	
	//If this�SymTable's list is empty,�throw an�EmptySymTableException. 
	//Otherwise, if the first�HashMap�in the list contains name as a key, return the associated�Sym; otherwise, return�null.
	public Sym lookupLocal(String name) throws EmptySymTableException {
		if (symList.isEmpty()) {
			throw new EmptySymTableException();
		} else if (symList.get(0).containsKey(name)) {
			return symList.get(0).get(name);
		} else {
			return null;
		}
	}
	
	//If this�SymTable's list is empty, throw an�EmptySymTableException. If�any�HashMap�in the list contains�name�as a key, 
	//return the first associated�Sym�(i.e., the one from the�HashMap�that is closest to the front of the list); otherwise, return�null.
	public Sym lookupGlobal(String name) throws EmptySymTableException {
		if (symList.isEmpty()) {
			throw new EmptySymTableException();
		}
		
		for (HashMap<String, Sym> it : symList) {
			if (it.containsKey(name)) {
				return it.get(name);
			}
		}
		return null;
	}
	
	//If this�SymTable's list is empty, throw an�EmptySymTableException; otherwise, remove the�HashMap�from the front of the list. 
	//To clarify, throw an exception only if�before attempting to remove, the list is empty (i.e. there are no�HashMaps to remove).
	public void removeScope() throws EmptySymTableException {
		if (symList.isEmpty()) {
			throw new EmptySymTableException();
		} else {
			symList.remove(0);
		}
	}
	
	//This method is for debugging. First, print��\nSym Table\n�. 
	//Then, for each�HashMap M�in the list, print�M.toString()�followed by a newline. 
	//Finally, print one more newline. All output should go to�System.out.
	public void print() {
		System.out.println("\nSym Table\n");
		for (HashMap<String, Sym> M : symList) {
			System.out.println(M.toString());
		}
		System.out.println();
	}
	
	

}

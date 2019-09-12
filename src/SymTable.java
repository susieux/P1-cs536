///////////////////////////////////////////////////////////////////////////////
//
// Title:            P1
// Files:            P1.java
//                   Sym.java
//                   SymTable.java
//                   DuplicateSymException.java
//					 EmptySymTableException.java
// Semester:         CS536 Fall 2019
//
// Author:           Susie Chongthaweephol
// Email:            chongthaweep@wisc.edu
// CS Login:         susie
// Lecturer's Name:  Aws Albarghouthi
//
///////////////////////////////////////////////////////////////////////////////
import java.util.*;

/**
 * This class implements a symbol table, which stores identifiers and
 * information declared in the program. The symbol table uses
 * a list of HashMaps.
 * 
 * @author Susie */
public class SymTable {
	private List<HashMap<String, Sym>> symList;
	
	/**
	 * The constructor initializes the SymTable's List field to contain 
	 * a single, empty HashMap.
	 *
	 */
	public SymTable () {
		symList = new LinkedList<HashMap<String, Sym>>();
		symList.add(new HashMap<String, Sym>());
	}
	

	/**
	 * This method adds the name and sym defined to the first HashMap in
	 * the list.
	 * If the list is empty, EmptySymTableException is thrown
	 * If any of the param is null, NullPointerException is thrown
	 * If there are duplicates, DuplicateSymException this thrown
	 *
	 * @param name is the name of the Sym
	 * @param sym is the type
	 */
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
	
	/**
	 * This method adds an empty HashMap to the front of the list
	 *
	 */
	public void addScope() {
		symList.add(0, new HashMap<String, Sym>());
	}
	
	/**
	 * This method checks if the first HashMap contains name(key) and
	 * will return the associated Sym.
	 * 
	 * If the list is empty, EmptySymTableException is thrown.
	 *
	 * @param name is the name of the Sym
	 * @return return the associated Sym if HashMap contains key
	 * @return return null if nothing is found
	 */
	public Sym lookupLocal(String name) throws EmptySymTableException {
		if (symList.isEmpty()) {
			throw new EmptySymTableException();
		} else if (symList.get(0).containsKey(name)) {
			return symList.get(0).get(name);
		} else {
			return null;
		}
	}

	/**
	 * This method checks if any HashMap contains name(key) and
	 * will return the associated Sym (HashMap closest to front of list).
	 * 
	 * If the list is empty, EmptySymTableException is thrown.
	 *
	 * @param name is the name of the Sym
	 * @return return the associated Sym if HashMap contains key
	 * @return return null if nothing is found
	 */
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
	
	/**
	 * This method removes the first HashMap from the front of the list.
	 * 
	 * If the list is empty, EmptySymTableException is thrown.
	 *
	 */
	public void removeScope() throws EmptySymTableException {
		if (symList.isEmpty()) {
			throw new EmptySymTableException();
		} else {
			symList.remove(0);
		}
	}
	
	/**
	 * This method is used for debugging. It prints out HashMaps in the
	 * Sym Table.
	 * 
	 */
	public void print() {
		System.out.println("\nSym Table\n");
		for (HashMap<String, Sym> M : symList) {
			System.out.println(M.toString());
		}
		System.out.println();
	}
}

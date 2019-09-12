///////////////////////////////////////////////////////////////////////////////
//
// Title:            P1
// Files:            P1.java
//                   Sym.java
//                   SymTable.java
//                   DuplicateSymException.java
//                   EmptySymTableException.java
// Semester:         CS536 Fall 2019
//
// Author:           Susie Chongthaweephol
// Email:            chongthaweep@wisc.edu
// CS Login:         susie
// Lecturer's Name:  Aws Albarghouthi
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class checks the implementation of Sym.java, SymTable.java,
 * DuplicateSymException.java, and EmptySymTableException.java.
 * 
 * @author Susie
 */
public class P1 {

	/**
	 * This class checks the implementation of all the classes in this program.
	 * 
	 * @author Susie
	 */
	public static void main(String[] args) {

		System.out.println("Should only print exceptions when thrown. "
				+ "Will also print which files are tested before test.");
		
		// testing Sym.java file
		System.out.println("Testing Sym.java file methods.");
		String[] symString = { "int", "double", "float", "char" };
		for (int i = 0; i < symString.length; i++) {
			Sym sym = new Sym(new String(symString[i]));

			if (!(sym.getType().equals(symString[i]))) {
				System.out.println("Wrong result at SymTest (getType).");
			}

			if (!(sym.toString().equals(symString[i]))) {
				System.out.println("Wrong result at SymTest (toString).");
			}
		}

		// testing SymTable.java file
		System.out.println("Testing SymTable.java file methods.");
		SymTable symTab = new SymTable(); // create the Sym Table

		// testing removeScope and SymTable constructor
		try {
			symTab.removeScope(); // removes constructor HashMap
			symTab.removeScope(); // should throw EmptySymTableException
		} catch (EmptySymTableException e) {
			// expected.
		}
		
		// testing addScope
		try {
			symTab.addScope();
			symTab.removeScope(); // shouldn't not throw EmptySymTableException
		} catch (Exception ex) {
			System.out.println("Exception thrown when adding and removing "
					+ "a scope immediately. This should not happen.");
		}

		// testing addDecl exceptions
		try {
			symTab.addDecl("name", new Sym("sym"));
		} catch (DuplicateSymException e) {
			System.out.println("DuplicateSymException thrown. This "
					+ "shouldn't happen.");
		} catch (EmptySymTableException ex) {
			// expected
		}
		
		//adding more scope for addDecl testing
		symTab.addScope();
		symTab.addScope();

		try {
			symTab.addDecl("name", new Sym("sym"));
			symTab.addDecl("name", new Sym("sym"));
		} catch (DuplicateSymException e) {
			// expected
		} catch (EmptySymTableException ex) {
			System.out.println(
					"EmptySymTableException thrown when trying addDecl to "
					+ "populated sym table. This shouldn't happen.");
		}

		// testing addDecl null
		try {
			
			//removing scopes from last test
			symTab.removeScope();
			symTab.removeScope();
			
			//adding scope to test addDecl null
			symTab.addScope();
			symTab.addDecl("name", null);

		} catch (NullPointerException e) {
			// expected
		} catch (DuplicateSymException e) {
			System.out.println(
					"DuplicateSymException thrown on attempt to add null "
					+ "objects to test addDecl scopes. "
					+ "This shouldn't happen.");
		} catch (EmptySymTableException ey) {
			System.out.println(
					"EmptySymTableException thrown on attempt to remove "
					+ "test addDecl scopes. This shouldn't happen.");
		}

		try {
			//removing scope from last test
			symTab.removeScope();
			
			//adding scope to test addDecl null
			symTab.addScope();
			symTab.addDecl(null, null);

		} catch (NullPointerException e) {
			// expected
		} catch (DuplicateSymException e) {
			System.out.println(
					"DuplicateSymException thrown on attempt to add "
					+ "null objects to test addDecl scopes. "
					+ "This shouldn't happen.");
		} catch (EmptySymTableException ey) {
			System.out.println(
					"EmptySymTableException thrown on attempt to remove "
					+ "test addDecl scopes. This shouldn't happen.");
		}

		try {
			//removing scope from last test
			symTab.removeScope();
			
			//adding scope to test addDecl null
			symTab.addScope();
			symTab.addDecl(null, new Sym("sym"));

		} catch (NullPointerException e) {
			// expected
		} catch (DuplicateSymException e) {
			System.out.println(
					"DuplicateSymException thrown on attempt to add "
					+ "null objects to test addDecl scopes. "
					+ "This shouldn't happen.");
		} catch (EmptySymTableException ey) {
			System.out.println(
					"EmptySymTableException thrown on attempt to remove "
					+ "test addDecl scopes. This shouldn't happen.");
		}

		// testing addDecl DuplicateSymException
		try {
			//removing scope from last test
			symTab.removeScope();
			
			//adding duplicates
			symTab.addScope();
			symTab.addScope();
			symTab.addDecl("name", new Sym("sym"));
			symTab.addDecl("name", new Sym("sym"));

		} catch (NullPointerException e) {
			System.out.println(
					"NullPointerException thrown on attempt test "
					+ "DuplicateSymException. This shouldn't happen.");
		} catch (DuplicateSymException e) {
			// expected
		} catch (EmptySymTableException ey) {
			System.out.println(
					"EmptySymTableException thrown on attempt to remove test "
					+ "addDecl scopes. This shouldn't happen.");
		}

		// testing lookupLocal and lookupGlobal
		// testing lookupLocal exception
		try {
			//removing scopes from last test
			symTab.removeScope();
			symTab.removeScope();
			
			symTab.lookupLocal("Test");
		} catch (EmptySymTableException ex) {
			// expected 
		}

		// testing lookupGlobal exception
		try {
			symTab.lookupGlobal("Test");
		} catch (EmptySymTableException ex) {
			// expected
		}

		symTab.addScope();
		// testing lookupLocal null test
		try {
			if (symTab.lookupLocal("Test") == null) {
				// expected
			} else {
				System.out.println("Failed lookupLocal null test");
			}
		} catch (EmptySymTableException ex) {
			System.out.println("EmptySymTableException thrown on null test. "
					+ "(lookupLocal). This shouldn't happen.");
		}

		// testing lookupGlobal null test
		try {
			if (symTab.lookupGlobal("Test") == null) {
				// expected
			} else {
				System.out.println("Failed lookupLocal null test");
			}
		} catch (EmptySymTableException ex) {
			System.out.println("EmptySymTableException thrown on null test. "
					+ "(lookupGlobal). This shouldn't happen.");
		}

		// testing addDecl() and lookupLocal and lookupGlobal search functions
		try {
			symTab.addDecl("name", new Sym("sym"));
			
			//testing lookupLocal and lookupGlobal by console output.
			System.out.println();
			System.out.println("Expected and actual result printed here. "
					+ "Please check manually.");
			System.out.println("lookupLocal should print out \"sym\". "
					+ "Actual result: " + symTab.lookupLocal("name"));
			System.out.println("lookupGlobal should print out \"sym\"."
					+ " Actual result: " + symTab.lookupGlobal("name"));

		} catch (NullPointerException e) {
			System.out.println(
					"NullPointerException thrown on attempt test "
					+ "DuplicateSymException. This shouldn't happen.");
		} catch (DuplicateSymException e) {
			// expected
		} catch (EmptySymTableException ey) {
			System.out.println(
					"EmptySymTableException thrown on attempt to remove test "
					+ "addDecl scopes. This shouldn't happen.");
		}

		// testing print empty sym table
		try {
			//removing scopes from last test
			symTab.removeScope();
			System.out.println();
			System.out.print("Following SymTable should be empty. "
					+ "No scope.");
			symTab.print();
			
		} catch (NullPointerException e) {
			System.out.println(
					"NullPointerException thrown on attempt test print. "
					+ "This shouldn't happen.");
		} catch (EmptySymTableException ey) {
			System.out.println(
					"EmptySymTableException thrown on attempt to test print. "
					+ "This shouldn't happen.");
		}
		
		// testing print with scope no addDecl
		try {
			symTab.addScope();
			
			System.out.print("Following SymTable should be empty. "
					+ "With scope. No addDecl.");
			symTab.print();
			
		} catch (NullPointerException e) {
			System.out.println(
					"NullPointerException thrown on attempt test print. "
					+ "This shouldn't happen.");
		}

		// testing print on populated sym table
		try {
			System.out.print("Following SymTable should be populated.");
			symTab.addDecl("name", new Sym("sym"));
			symTab.print();
		} catch (NullPointerException e) {
			System.out.println(
					"NullPointerException thrown on attempt test print. "
							+ "This shouldn't happen.");
		} catch (DuplicateSymException e) {
			// expected
		} catch (EmptySymTableException ey) {
			System.out.println(
					"EmptySymTableException thrown on attempt to test print. "
							+ "This shouldn't happen.");
		}
		
		System.out.println("All tests completed.");
	}
}

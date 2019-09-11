
public class P1 {

	public static void main(String[] args) {

		// testing Sym.java file
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
		SymTable symTab = new SymTable();

		// testing removeScope and SymTable constructor
		try {
			symTab.removeScope(); // this should not fail. It is removing the constructor HashMap
			symTab.removeScope(); // should throw EmptySymTableException
		} catch (EmptySymTableException e) {
			// expected.

			// testing addScope
			try {
				symTab.addScope();
				symTab.removeScope(); // should not throw EmptySymTableException, if addScope did it's job
			} catch (Exception ex) {
				System.out.println(
						"Exception thrown when adding and removing a scope immediately. This should not happen.");
			}
		}

		// testing addDecl exceptions
		try {
			symTab.addDecl("name", new Sym("sym"));
		} catch (DuplicateSymException e) {
			System.out.println("DuplicateSymException thrown. This shouldn't happen.");

		} catch (EmptySymTableException ex) {
			// expected
		}
		symTab.addScope();
		symTab.addScope();

		try {
			symTab.addDecl("name", new Sym("sym"));
			symTab.addDecl("name", new Sym("sym"));
		} catch (DuplicateSymException e) {
			// expected

		} catch (EmptySymTableException ex) {
			System.out.println(
					"EmptySymTableException thrown when trying addDecl to populated sym table. This shouldn't happen.");
		}

		// testing addDecl null
		try {
			symTab.removeScope();
			symTab.removeScope();
			symTab.addScope();
			symTab.addDecl("name", null);

		} catch (NullPointerException e) {
			//expected
		} catch (DuplicateSymException e) {
			System.out.println(
					"DuplicateSymException thrown on attempt to add null objects to test addDecl scopes. This shouldn't happen.");
		} catch (EmptySymTableException ey) {
			System.out.println(
					"EmptySymTableException thrown on attempt to remove test addDecl scopes. This shouldn't happen.");
		}
		
		try {
			symTab.removeScope();
			symTab.addScope();
			symTab.addDecl(null, null);

		} catch (NullPointerException e) {
			//expected
		} catch (DuplicateSymException e) {
			System.out.println(
					"DuplicateSymException thrown on attempt to add null objects to test addDecl scopes. This shouldn't happen.");
		} catch (EmptySymTableException ey) {
			System.out.println(
					"EmptySymTableException thrown on attempt to remove test addDecl scopes. This shouldn't happen.");
		}
		
		try {
			symTab.removeScope();
			symTab.addScope();
			symTab.addDecl(null, new Sym("sym"));

		} catch (NullPointerException e) {
			//expected
		} catch (DuplicateSymException e) {
			System.out.println(
					"DuplicateSymException thrown on attempt to add null objects to test addDecl scopes. This shouldn't happen.");
		} catch (EmptySymTableException ey) {
			System.out.println(
					"EmptySymTableException thrown on attempt to remove test addDecl scopes. This shouldn't happen.");
		}
		
		//testing addDecl DuplicateSymException
		try {
			symTab.removeScope();
			symTab.addScope();
			symTab.addScope();
			symTab.addDecl("name", new Sym("sym"));
			symTab.addDecl("name", new Sym("sym"));

		} catch (NullPointerException e) {
			System.out.println(
					"NullPointerException thrown on attempt test DuplicateSymException. This shouldn't happen.");
		} catch (DuplicateSymException e) {
			//expected
		} catch (EmptySymTableException ey) {
			System.out.println(
					"EmptySymTableException thrown on attempt to remove test addDecl scopes. This shouldn't happen.");
		}

	// TESTING LOOKUPLOCAL AND LOOKUPGLOBAL. ALL SCOPE SHOULD BE REMOVED.
	// testing lookupLocal exception
	try
	{
		symTab.lookupLocal("Test");
	}catch(
	EmptySymTableException ex)
	{
		// expected
	}

	// testing lookupGlobal exception
	try
	{
		symTab.lookupGlobal("Test");
	}catch(
	EmptySymTableException ex)
	{
		// expected
	}

	symTab.addScope();
	// testing lookupLocal null test
	try
	{
		if (symTab.lookupLocal("Test") == null) {
			// expected
		} else {
			System.out.println("Failed lookupLocal null test");
		}
	}catch(
	EmptySymTableException ex)
	{
		System.out.println("EmptySymTableException thrown on null test. (lookupLocal). This shouldn't happen.");
	}

	// testing lookupGlobal null test
	try
	{
		if (symTab.lookupGlobal("Test") == null) {
			// expected
		} else {
			System.out.println("Failed lookupLocal null test");
		}
	}catch(
	EmptySymTableException ex)
	{
		System.out.println("EmptySymTableException thrown on null test. (lookupGlobal). This shouldn't happen.");
	}

	
	//testing addDecl() and lookupLocal and lookupGlobal search functions
	try{
		
	} catch (NullPointerException e) {
		System.out.println(
				"NullPointerException thrown on attempt test DuplicateSymException. This shouldn't happen.");
	} catch (DuplicateSymException e) {
		//expected
	} catch (EmptySymTableException ey) {
		System.out.println(
				"EmptySymTableException thrown on attempt to remove test addDecl scopes. This shouldn't happen.");
	}
	// lookupLocal(String name),
	// lookupGlobal(String name),
	// print()

}}

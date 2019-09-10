
public class P1 {
//	private static SymTable symTab;
//	Be sure that your P1.java tests all of the Sym and SymTable operations and all situations under which exceptions are thrown. 
//	Also think about testing both “boundary” and “non-boundary” cases.
	
//	It is up to you how your program works. A suggested approach is to write your program so that output is only produced if one 
//	of the methods that it is testing does not work as expected (e.g., if the lookupLocal method of the SymTable class returns 
//	null when you expect it to return a non-null value). This will make it much easier to determine whether your test 
//	succeeds or fails. The one exception to this approach is that P1.java will need to test the print method of the SymTable 
//	class and that will cause output to be produced.
//	To help you understand better the kind of code you would write using this suggested approach, look at TestList.java. 
//	This file contains a main program designed to test a (fictional) List class whose methods are documented in TestList.java. 
//	You are being asked to write something similar (in a file called P1.java) to test the Sym and SymTable classes. 
//	You should be able to write P1.java before you write the classes that it's designed to test.

	
	
	public static void main(String[] args) {
		
		//testing sym.java file
		String[] symString = {"int", "double", "float", "char"};
		for (int i=0; i<symString.length;i++) {
			Sym sym = new Sym(new String(symString[i]));
		
		
			if (!(sym.getType().equals(symString[i]))) {
			System.out.println("Wrong result at SymTest (getType), when symString" + symString[i]);
			}
		
			if (!(sym.toString().equals(symString[i]))) {
			System.out.println("Wrong result at SymTest (toString), when symString" + symString[i]);
			}
		}
		
		//testing symtable.java file
		
		SymTableTest();
		
		
	}
	
	//addDecl((String name, Sym sym) throws DuplicateSymException, EmptySymTableException), 
	//addScope(), 
	//lookupLocal(String name), 
	//lookupGlobal(String name),
	//print()
	private static void SymTableTest() {
		SymTable symTab = new SymTable();
		try {
			symTab.removeScope(); //should throw EmptySymTableException
//			//add something here to check removal of scope.
			symTab.removeScope(); //should NOT throw EmptySymTableException
			
//		} catch (EmptySymTableException e) { 
//			System.out.println("EmptySymTableException thrown on attempt to remove item from empty table");
//		
//		
//		} catch (DuplicateSymException e) { 
//			System.out.println("DuplicateSymException thrown on attempt when first HashMap in the list "
//				+ "already contains the given name as a key,");
//		
//		} catch (NullPointerException e) { 
//			System.out.println("NullPointerException thrown on attempt to add null items to HashMap");
//		}
	}
		}
	}


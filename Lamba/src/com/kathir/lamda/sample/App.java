package com.kathir.lamda.sample;

interface Executable {
	Integer execute(Integer a, Integer b);
}

interface StringExecutable {
	Integer execute(String a);
}

class Runner {
	public void run(Executable e){

		System.out.println("Entered into run method");
		Integer value = e.execute(12,11);
		System.out.println("Return Value is"+ value);
	}
	
	public void run(StringExecutable e){

		System.out.println("Entered into run method");
		Integer value = e.execute("Hello");
		System.out.println("Return Value is"+ value);
	}
}

// LAMDA EXPRESSIONS () -> System.out.println("Hello there")

/*
 * () -> { 
			System.out.println("This is code passed in a lamda expression");
			System.out.println("Hello there"); 
		}
*/

/*
 * () -> { 
			System.out.println("This is code passed in a lamda expression");
			System.out.println("Hello there"); 
			return 8;
		}
*/

/*
 * () -> { 
			return 8;
		}
 */

//() -> 8

//(Integer a) -> 8+a

//(a) -> 8+a

//a -> 8+a

//(a,b) -> 8+a+b

public class App {

	public static void main(String[] args) {
		
		int d = 10;
		Runner runner = new Runner();
		
		/* runner.run(new Executable() {
			public Integer execute(Integer a,Integer b) {
				// can do this methods of annonumous classes int d=8;
				System.out.println("Value of D is"+d);;
				System.out.println("Hello There");
				return a+b;
			}
		}); */
		
		System.out.println("==========================");
		//runner.run(() -> System.out.println("Hello there"));
		runner.run((a,b) -> { 
			// cannot do this; no new scope. int d=10;
			return 8+a+b; 
			});
		
		System.out.println("==========================");
		
		Executable ex =  (a,b) -> { 
			// cannot do this; no new scope. int d=10;
			System.out.println("ooh");
			return 8+a+b; 
			};
			
		runner.run(ex);
		
		System.out.println("==========================");
		
		Object codeBlock = (Executable ) (a,b) -> { 
			// cannot do this; no new scope. int d=10;
			System.out.println("ooh");
			return 8+a+b; 
			};
			System.out.println("codeBlock"+codeBlock);
		//runner.run(codeBlock);	
	}
}

package xxTypingTest;

public class ConsoleGUI {
	void title() {
		System.out.println("\033[33m++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("+                                                                        +");
		System.out.println("+                           TYPING TEST CONSOLE                          +");
		System.out.println("+                                                                        +");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println();
		System.out.println("                        [S]Start   [X]Exit\033[0m");
	}
	
	void message() {
		System.out.println("\033[36m++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("+                                                                        +");
		System.out.println("+                                MESSAGE                                 +");
		System.out.println("+                                                                        +");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\033[0m");
	}
	
	void usertype() {
		System.out.println();
		System.out.println("\033[36m++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("+                                                                        +");
		System.out.println("+                           TYPE FOLLOWING TEXT                          +");
		System.out.println("+                                                                        +");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\033[0m");
	}
	
	void resultUI() {
		System.out.println("\033[36m++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("+                                                                        +");
		System.out.println("+                                  RESULT                                +");
		System.out.println("+                                                                        +");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\033[0m");
	}
	
	void exitUI() {
		System.out.println("\033[36m++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("+                                                                        +");
		System.out.println("+                            PROGRAM FINISHED                            +");
		System.out.println("+                                                                        +");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\033[0m");
	}
}

package xxTypingTest;

import java.util.concurrent.TimeUnit;

public class CounterGUI {
	void displaycount() throws InterruptedException {
		countThree();
		TimeUnit.SECONDS.sleep(1);
		cls();
		countTwo();
		TimeUnit.SECONDS.sleep(1);
		cls();
		countOne();
		TimeUnit.SECONDS.sleep(1);
	}
	
	void countOne() {
		System.out.println("\033[31m        []");
		System.out.println("        []");
		System.out.println("        []");
		System.out.println("        []");
		System.out.println("        []");
		System.out.println("        []");
		System.out.println("        []");
		System.out.println("        []");
		System.out.println("        []");
		System.out.println("        []\033[0m");
	}
	
	void countTwo() {
		System.out.println("\033[32m  [][][]");
		System.out.println("        []");
		System.out.println("        []");
		System.out.println("        []");
		System.out.println("        []");
		System.out.println("  [][][]");
		System.out.println("[]");
		System.out.println("[]");
		System.out.println("[]");
		System.out.println("  [][][]\033[0m");
	}
	
	void countThree() {
		System.out.println("\033[34m  [][][]");
		System.out.println("        []");
		System.out.println("        []");
		System.out.println("        []");
		System.out.println("        []");
		System.out.println("  [][][]");
		System.out.println("        []");
		System.out.println("        []");
		System.out.println("        []");
		System.out.println("        []");
		System.out.println("  [][][]\033[0m");
	}
	
	void cls() {		
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

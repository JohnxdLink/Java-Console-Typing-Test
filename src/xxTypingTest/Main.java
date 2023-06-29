package xxTypingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
	Project: Java Typing Test Console
	Developer: Castro John Christian
	Message:
	Date Created: 04/19/2023
*/

public class Main {
	
	//Defining Static String
	static String origtext;
	
	public static void main(String[] args) throws InterruptedException {
		ConsoleGUI cnlGUI = new ConsoleGUI();
		CounterGUI cntGUI = new CounterGUI();
		BufferedReader bfrd_reader = new BufferedReader(new InputStreamReader(System.in));
		Random rand = new Random();
		
		String[] infotext = {"Science is the never-ending journey towards understanding the world around us. Through observation, experimentation, and analysis, scientists strive to uncover the mysteries of the universe and make sense of the natural phenomena that shape our lives. From the tiniest particles that make up matter to the vast expanse of the cosmos, science provides us with a deeper understanding of our place in the universe and helps us make informed decisions that impact our lives and the world we live in. The quest for understanding is what drives science forward, and it is a pursuit that will never cease.", "Science is the never-ending journey towards understanding the world around us. Through observation, experimentation, and analysis, scientists strive to uncover the mysteries of the universe and make sense of the natural phenomena that shape our lives. From the tiniest particles that make up matter to the vast expanse of the cosmos, science provides us with a deeper understanding of our place in the universe and helps us make informed decisions that impact our lives and the world we live in. The quest for understanding is what drives science forward, and it is a pursuit that will never cease.", "Science has the power to change our world, but it also comes with great responsibility. As scientists uncover new knowledge and develop new technologies, they must consider the ethical implications of their work. Issues such as the use of animal testing, the safety of genetically modified organisms, and the impact of technology on society must be carefully considered. Scientists must also ensure that their work is conducted with integrity and transparency, and that the results are communicated accurately and honestly. Ethical considerations are a vital part of the scientific process, and they help ensure that science is used for the benefit of all."};
		
		String start;
		String usertypedtext;
		
		try {
			
			do {
				cls();
				cnlGUI.title();
				System.out.print("Input: ");
				start = bfrd_reader.readLine();
				
				if(start.equals("S")|| start.equals("s")) {
				cls();
				cntGUI.displaycount();
				
				double starttime = System.currentTimeMillis();
				
				cls();
				//Get the text to be typed by the user.
				cnlGUI.message();
				int rndindex = rand.nextInt(infotext.length);
				origtext = infotext[rndindex];
				System.out.println("\033[32m" + origtext + "\033[0m");
				
				cnlGUI.usertype();
				usertypedtext = bfrd_reader.readLine();
				
				double endtime = System.currentTimeMillis();
				
				Map<String, Double> results = typingtestfunction(starttime, usertypedtext, endtime);
				
				cls();
				cnlGUI.resultUI();
				System.out.printf("\033[33mTime taken             :\033[0m %d seconds\n", results.get("seconds").intValue());
				System.out.printf("\033[33mCorrect characters     :\033[0m %d\n", results.get("correctcharacters").intValue());
				System.out.printf("\033[33mIncorrect characters   :\033[0m %d\n", results.get("incorrectcharacters").intValue());
				System.out.printf("\033[33mGross typing speed     :\033[0m %.2f CPM\n", results.get("grosstypespeed"));
				System.out.printf("\033[33mNet typing speed       :\033[0m %.2f CPM\n", results.get("nettypespeed"));
				System.out.printf("\033[33mWords Per Minute       :\033[0m %d WPM\n", results.get("wpm").intValue());
				System.out.printf("\033[33mAccuracy               :\033[0m %.2f%%\n", results.get("accuracy"));
				
				System.out.println("\033[33m                         \n[Y]Try Again?   [X]Exit\033[0m");
				System.out.print("Input: ");
				start = bfrd_reader.readLine();
				
				if(start.equals("Y") || start.equals("y")) {
					continue;
				} else if(start.equals("X") || start.equals("x")) {
					cls();
					cnlGUI.exitUI();
					break;
				} else {
					System.out.println("\033[31mWarning!: Invalid Input\033[0m");
					break;
				}
				
			} else if(start.equals("X") || start.equals("x")) {
				cls();
				cnlGUI.exitUI();
				break;
			} else {
				System.out.println("\033[31mWarning!: Invalid Input\033[0m");
			}
				
			} while(start != "X" || start != "x");
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Map<String, Double> typingtestfunction(double starttime, String usertypedtext, double endtime) {
		
		int correctcharacters = 0;
		int incorrectcharacters = 0;
		int typewwords = usertypedtext.split("\\s+").length;
		
		//Compare each character typed by the user with the corresponding character in the original text
		for(int i = 0; i < origtext.length() && i < usertypedtext.length(); i++) {
			if(origtext.charAt(i) == usertypedtext.charAt(i)) {
				correctcharacters++;
			} else {
				incorrectcharacters++;
			}
		}
		double timetaken = endtime - starttime;
		double seconds = timetaken / 1000;
		double minutes = timetaken / 60000.0;
		double grosstypespeed = ((double) correctcharacters / timetaken) * 60000 / 5;
		double nettypespeed = ((double) (correctcharacters - incorrectcharacters) / timetaken) * 60000 / 5;
		double accuracy = ((double) correctcharacters / (correctcharacters + incorrectcharacters)) * 100;
		
		int wpm = (int) Math.round(typewwords / minutes);
		
		
		Map<String, Double> results = new HashMap<>();
		results.put("starttime", (double) starttime);
		results.put("endtime", (double ) endtime);
		results.put("correctcharacters", (double) correctcharacters);
		results.put("incorrectcharacters", (double) incorrectcharacters);
		results.put("seconds", seconds);
		results.put("grosstypespeed", grosstypespeed);
		results.put("nettypespeed", nettypespeed);
		results.put("wpm", (double) wpm);
		results.put("accuracy", accuracy);
		
		return results;
		
	}
	
	public static void cls() {
		
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
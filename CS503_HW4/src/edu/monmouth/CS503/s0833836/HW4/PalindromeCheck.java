package edu.monmouth.CS503.s0833836.HW4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import java.util.Stack;

public class PalindromeCheck {

	public static Stack<Character> stack = new Stack();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(args.length);
		if (args.length != StackPalindromeConstants.REQUIRED_PARAMETERS) {
			System.err.println("Supply a name of a properties file and a word to check");
			System.exit(StackPalindromeConstants.PARAMETERS_EXIT);
		}
		
		String logFileName = null;
		final String PROPERTIES_FILE_NAME = args[0];
		
		Properties properties = new Properties();
		
		try {
			properties.load(new FileInputStream(PROPERTIES_FILE_NAME));
		} catch (IOException ioe) {
			System.err.println("Cannot open properties file " + PROPERTIES_FILE_NAME);
			System.exit(StackPalindromeConstants.NO_PROPERTY_EXIT);
		}
		
		properties.list(System.out);
		
		logFileName = properties.getProperty(StackPalindromeConstants.LOG_FILE_PROPERTY_NAME);
		
		if (logFileName == null) {
			System.err.println(StackPalindromeConstants.LOG_FILE_PROPERTY_NAME + " property not found");
			System.exit(StackPalindromeConstants.NO_PROPERTY_EXIT);
		}
		
		System.err.println("log_file_name: " + logFileName);
		
		try {
			PrintStream st = new PrintStream(logFileName);
			System.setOut(st);
			System.setErr(st);
		} catch (FileNotFoundException ioe) {
			System.err.println("Cannot redirect stderr and stdout " + ioe.getMessage());
			ioe.printStackTrace();
			System.exit(StackPalindromeConstants.REDIRECT_FAILED_EXIT);
		}
		System.out.println("Program started");
		
		for (int i = 0; i < StackPalindromeConstants.WORDCHECK.length(); i++) {
			char character = StackPalindromeConstants.WORDCHECK.charAt(i);
			stack.push(character);
		}//for
		
		StringBuilder sb = new StringBuilder();
		
		for (int j = 0; j < StackPalindromeConstants.WORDCHECK.length(); j++) {
			char character = StackPalindromeConstants.WORDCHECK.charAt(j);
			sb.append(stack.pop());
		}//for
		
		if (StackPalindromeConstants.WORDCHECK.equals(sb)) {
			System.out.println("String is palindrome");
		} else {
			System.out.println("String is not palindrome");
		}//else
		
//		public String compareTo() {
//			int compareValue = 0;
//			if (this.stack )
//		}//compareTo
	}//main

}//class

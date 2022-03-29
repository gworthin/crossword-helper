package crosswordHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * In a crossword puzzle, you may run across a space where you know some of the letters
 * but not others. For example: you may have a space with "r", "a", a bank space, and then
 * "h". With this program, you would type in ra?h, with a question mark to signify a 
 * blank space, and it would print "rach rash rath", signifying these are the only three
 * possible words that could fill this space.
 */
 
public class CrosswordHelper {

	/* 
	 * Method findWords takes a String parameter called space. Space is a string 
	 * representing a space in a crossword puzzle, where ?s represent empty boxes.
	 * findWords returns an ArrayList of strings containing all possible words that
	 * could go in that space. 
	 */
	public static ArrayList<String> findWords(String space) throws FileNotFoundException{
		
		// Length of the string
		int length = space.length();
		
		// Text file with all English words
		File allWordsFile = new File("allwords.txt");
		Scanner fileReader = new Scanner(allWordsFile);
		
		// ArrayList to store all possible words that could fit in space
		ArrayList<String> words = new ArrayList<String>();
		String curWord;
		
		// Add all words of the same length as space to the ArrayList
		while(fileReader.hasNext()) {
			curWord = fileReader.nextLine();
			if(curWord.length() == length) {
				words.add(curWord);
			}
		} // words ArrayList now stores words in the English language with the same number of characters as the space string
		
		// Fill ArrayList indices with the indices of the space parameter with non-? characters
		ArrayList<Integer> indices = new ArrayList<Integer>();
		for(int m = 0; m < length; m++) {
			if(!space.substring(m, m+1).equals("?")) {
				indices.add(m);
			}
		}
		
		// Loop through all words the same length as space
		for(int i = 0; i < words.size(); i++) {
			// Loop through all indices with non-? characters
			for(int j = 0; j < indices.size(); j++) {
				// If the character at index j in the word from the words array is not equal to the character at index j of space
				if(!space.substring(indices.get(j), indices.get(j)+1).equals(words.get(i).substring(indices.get(j), indices.get(j)+1))) {
					words.remove(i); // Remove the current word from the words array
					i--; // Decrement i as to not skip words
					break; // Break out of the inner loop to avoid checking more indices
				} 
			}
		} // words ArrayList now only contains words that have the same non-? characters as space in the same spots
		
		// Return the words array
		return words;
		
	}
	
	/*
	 * main method handles user input for the space parameter, calls findWords, and
	 * prints all possible words that could fill that space. 
	 */
	public static void main(String[] args) throws IOException, FileNotFoundException {

		// Scanner to handle user input
		Scanner inReader = new Scanner(System.in);

		// Repeat unless the user doesn't type in a word
		while(true) {
			// Prompt user input
			System.out.println("Input the space with known letters and ?s for unknown boxes: ");
			String space = inReader.nextLine();
			space = space.toLowerCase(); // Convert to lower case
			
			// If there is no word, exit the program
			if(space.length() == 0) {
				break;
			}

			// Find all words possible in that space
			ArrayList<String> words = findWords(space);
			
			// Calculate the number of words to print in a line
			int wordsPerLine = (140 / (space.length() + 1));
			
			// Iterate through all possible words and print
			for(int k = 0; k < words.size(); k++) {
				System.out.print(words.get(k) + " ");
				if((k+1) % wordsPerLine == 0) {
					System.out.print("\n");
				}
			}
			System.out.println("\n");
		}		
	}
}

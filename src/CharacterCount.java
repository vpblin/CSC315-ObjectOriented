import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class CharacterCount {
//This file includes two methods to check the occurrence of a character in a string
//One Recursive function and an iterative function

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to character count");
		System.out.println("We are searching for the character 'H' in the HUCKLEBERRY FINN text file");
		
	    FileReader in1 = null;
	    FileReader in2 = null;

		try 
		{
			in1 = new FileReader("HuckleberryFinnASCII.txt");
			in2 = new FileReader("HuckleberryFinnASCII.txt");

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

	    BufferedReader reader1 = new BufferedReader(in1);
	    BufferedReader reader2 = new BufferedReader(in2);

	    int recursive_count= recursiveCharacterCount('H',reader1);
	    int iterative_count= iterativeCharacterCount('H',reader2);

	    System.out.println("We have your results");
	    System.out.println("Recursive " + recursive_count);
	    System.out.println("Iterative " + iterative_count);


		
	}
	
	
	public static int recursiveCharacterCount(char character_search,BufferedReader reader){
		int total = 0;
	    String line;
	    try 
	    {
			while ((line = reader.readLine()) != null) {
			    char [] char_list = line.toCharArray();
			    for(int i = 0; i < char_list.length; i++){
			    	if(char_list[i] == character_search){
			    		total++;
			    	}
			    }
			    
			}
		} catch (IOException e) 
	    {
			e.printStackTrace();
		}
	    return total;
	}
	
	public static int iterativeCharacterCount(char character_search,BufferedReader reader2){
		int total = 0;
	    String line;
	    try 
	    {
			while ((line = reader2.readLine()) != null) {

			    char [] char_list = line.toCharArray();
			    total += iterateThroughCharArray(char_list, character_search, char_list.length);
			    			    
			}
		} catch (IOException e) 
	    {
			e.printStackTrace();
		}
	    return total;
	}
	
	public static int iterateThroughCharArray(char [] char_list, char character_search, int length){
		if(length == 0){
			return 0;
		}
		
		if(char_list[length-1] == character_search){
			return 1 + iterateThroughCharArray(char_list, character_search, (length -1));
			
		}else{
			return iterateThroughCharArray(char_list, character_search, (length -1));
		}
	}
}

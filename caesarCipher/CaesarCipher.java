package caesarCipher;

import java.util.Scanner;


public class CaesarCipher {

	
	
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("What message would you like to encrypt?");
		String messageToEncrypt = scanner.nextLine();
		
		System.out.println("How many time would you like to shift the letter to the right?");
		int timesToShift = scanner.nextInt();
		
		
		
		System.out.println(encryptWord(messageToEncrypt, timesToShift));
		
}
	
	public static char encryptLetter(char unicode, int shiftKey)
	{
		
		int i = (int) unicode;
		
		if (i >= 65 && i <= 90)
		{
			if (i + shiftKey > 90)
			{
				unicode = (char) (unicode + shiftKey-26);
			}
			
			else unicode = (char) (unicode + shiftKey);	
		}
		
		if (i >= 97 && i <= 122)
 		{
		if (i + shiftKey > 122)
		{
				unicode = (char) (unicode + shiftKey-26);
			}
			else unicode = (char) (unicode + shiftKey);
			
	}
		
		
		char otherLetter = (char) unicode;
		return otherLetter;
	}
	
	public static String encryptWord(String word, int key)
	{
		String phrase = "";
		
		for (int i = 0; i < word.length(); i++)
		{
	   	 phrase += encryptLetter(word.charAt(i), key);
	   	 
		}
		return phrase;
		
	}
	
}
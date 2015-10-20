import java.io.File;
import java.util.Scanner;

public class TextThreatAssessment {
	
	public static String reverseIt(String source) {
	    int i, len = source.length();
	    StringBuilder dest = new StringBuilder(len);

	    for (i = (len - 1); i >= 0; i--){
	        dest.append(source.charAt(i));
	    }

	    return dest.toString();
	}
	public static String everyOtherLetter(String source) {
		String newString = "";
		int len = source.length();
		for (int i = 1; i < len; i += 2) {
			newString += source.charAt(i);
		}
		return newString;
	}
	public static int substringChecker(String source, String substring) {
		 int lastIndex = 0;
		 int count = 0;

		    while (lastIndex != -1) {
		           
		    	lastIndex = source.indexOf(substring,lastIndex);

		        if( lastIndex != -1){
		              count++;
		              lastIndex += substring.length();
		        }
		    }

		return count;
	}
	
	public static void main(String[] args) {
		boolean cont = true;
		while (cont){
		System.out.print("Enter the UFID of the person who wrote the message: ");
		
		Scanner input = new Scanner(System.in);
		String ufid = input.next();
		String fileName = ufid + ".txt";
		
		//checks for errors in UFID entry
		
		int length = ufid.length();
		char ufidCheck = ufid.charAt(0);
		if (length != 8) {
			System.out.println("Error: UFID must be 8 digits. Now Exiting.");
			System.exit(0);
		}
		else if(ufidCheck == '0') {
			System.out.println("Error UFID must not begin with 0. Now Exiting.");
			System.exit(0);
		}
		
		
		
		//gets text from file
		System.out.println("Opening file: " + fileName);
		
		String encryptedString = "";
	    
		try {
	        File file = new File(fileName);
	        Scanner sc = new Scanner(file);
	       	while (sc.hasNextLine()) {
	       		encryptedString+=sc.nextLine();
	       	}
	       	sc.close();
	       	}
		
	    catch (Exception ex) {
	       	ex.printStackTrace();
	       	}
		
		
		//Reverses string then takes every other character.
		String reversedString = reverseIt(encryptedString);
		String finalString = everyOtherLetter(reversedString);
		
		
		
	    //Asks for Keyword
		System.out.print("Enter a word (or phrase) of interest: ");
	    String keyword = input.next();
	    
	    
	    //Gets number of times keyword appears
	    int substringcount = substringChecker(finalString,keyword);
	    
	    
	    
	    //Sets Threat Level
	    String threatLevel = "";
	    
	    if (substringcount >= 4) {
	    	threatLevel = "Highly Threatening";
	    }
	    else if (substringcount >= 3) {
	    	threatLevel = "Threatening";
	    }
	    else if (substringcount >= 2) {
	    	threatLevel = "Somewhat Threatening";
	    }
	    else {
	    	threatLevel = "Safe";
	    }
	    
	    
	    
	    //Prints number of times the keyword appears
	    System.out.println("The word " + keyword + " was found " + substringcount + " time(s).");
	    
	    System.out.println("Messages from student " + ufid + " were found to be: " + threatLevel);
	    
	    //Exit prompt for program.
	    System.out.print("Press (y) to continue or (n) to exit. ");
	    String exitPrompt = input.next();
	    
	    
	    boolean condition = true;
	    while(condition){
	    	condition = false;
	    	if (exitPrompt.substring(0,1).equals("n") ) {
	    		cont = false;
	    	}
	    	else if (exitPrompt.substring(0,1).equals("y")) {
	    		break;
	    	}
	    	else{
	    		condition = true;
	    	}
	    }
		} 
		
	       
	}

}

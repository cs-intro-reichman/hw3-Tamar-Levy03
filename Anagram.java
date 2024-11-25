/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(onlyLowerCaseString("Tom Marvolo Riddle"));
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  


	public static String onlyLowerCaseString(String str){
		// function that get a string input and return him with only lower case and without spaces or punctuation marks.
		String newString = "";
		char newLettar;
		for(int i = 0; i<str.length(); i++){
			if (((int)str.charAt(i)) < 97 || ((int)str.charAt(i))>122) {
				if (((int)str.charAt(i)) > 64 && (int)str.charAt(i) < 96) {
					newLettar = (char)(((int)str.charAt(i))+32);
					newString = newString + newLettar;
				}
			}
			else{
				newString = newString + str.charAt(i);
			}
		}
			return newString;
	} 

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		// Replace the following statement with your code
		
		str1 = onlyLowerCaseString(str1);
		str2 = onlyLowerCaseString(str2);

		if (str1.length() != str2.length()) {
			return false;
		}

		int i = 0 , j=0;;
		boolean checkChar = true;
		boolean checkChar2 = false;
		while (i<str1.length() && checkChar==true) {
			while (j<str2.length() && checkChar2==false) {
				if (str1.charAt(i) == str2.charAt(j)) {
					checkChar2 = true;
				}
				j++;
			}
			if (checkChar2==false) {
				checkChar = false;
			}
			else{
				i++;
				checkChar2 = false;
				j=0;
			}
		}
		if (checkChar == true) {
			return true;
		}
		return false;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		// Replace the following statement with your code

		String newString = "";
		char newLettar;
		for(int i = 0; i<str.length(); i++){
			if ((((int)str.charAt(i)) < 97 || ((int)str.charAt(i))>122)) {
				if (((int)str.charAt(i)) > 64 && (int)str.charAt(i) < 96) {
					newLettar = (char)(((int)str.charAt(i))+32);
					newString = newString + newLettar;
				}
				if ((int)str.charAt(i) == 32){
					newString = newString + str.charAt(i);
				}
			}

			else{
				newString = newString + str.charAt(i);
			}
		}
			return newString;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		// Replace the following statement with your code
		String newStr = "";
		double randnum = Math.random()*str.length();
		for(int i = 0; i<str.length(); i++)
		{
			if (str.charAt((int)randnum) != ' ') {
				newStr = newStr + str.charAt((int) randnum);
				str = str.replace(str.charAt((int)randnum), ' ');
			}
			else{
				while (str.charAt((int)randnum) == ' ') {
					randnum = Math.random()*str.length();
				}
				newStr = newStr + str.charAt((int) randnum);
			}
			randnum = Math.random()*str.length();
		}

		return newStr;
		
		//return "";
	}
}



		/* isAnagram without external function.
		
		
		String newStr1 = "";
		String newStr2 = "";
		char newLettar;
		for(int x = 0; x<str1.length(); x++){
			if (((int)str1.charAt(x)) < 97 || ((int)str1.charAt(x))>122) {
				if (((int)str1.charAt(x)) != 32) {
					newLettar = (char)(((int)str1.charAt(x))+32);
					newStr1 = newStr1 + newLettar;
				}
			}
			else{
				newStr1 = newStr1 + str1.charAt(x);
			}
		}

		for(int y = 0; y<str2.length(); y++){
			if (((int)str2.charAt(y)) < 97 || ((int)str2.charAt(y))>122) {
				if (((int)str2.charAt(y)) != 32) {
					newLettar = (char)(((int)str2.charAt(y))+32);
					newStr2 = newStr2 + newLettar;
				}
			}
			else{
				newStr2 = newStr2 + str2.charAt(y);
			}
		}
		
		
		if (newStr1.length()!= newStr2.length()) {
			return false;
		}

		else{
		char c1; //check 2 string without spaces and upper letter.
		char c2;
		int i = 0 , j=0;;
		boolean checkChar = true;
		boolean checkChar2 = false;
		while (i<newStr1.length() && checkChar==true) {
			while (j<newStr2.length() && checkChar2==false) {
				if (newStr1.charAt(i) == newStr2.charAt(j)) {
					checkChar2 = true;
				}
				j++;
			}
			if (checkChar2==false) {
				checkChar = false;
			}
			else{
				i++;
				checkChar2 = false;
				j=0;
			}
		}
		if (checkChar == true) {
			return true;
		}
		return false;
	}
}*/
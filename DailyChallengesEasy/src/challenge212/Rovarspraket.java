package challenge212;

public class Rovarspraket {

	public static void main(String[] args) {

		String sentenceToParse = "Tre kronor är världens bästa ishockeylag.";

		String newSentence = encode(sentenceToParse);
		decode(newSentence);
		
	}

	private static String decode(String sentenceToParse) {
		StringBuilder newString = new StringBuilder();

		for (int i = 0; i < sentenceToParse.length();) {

			char tmp = sentenceToParse.charAt(i);

			if (Character.isAlphabetic(tmp)) {
				if (isVowel(Character.toLowerCase(tmp))) {
					newString.append(tmp);
					i++;
					continue;
				}
				
				if(sentenceToParse.charAt(i+1) == 'o' && sentenceToParse.charAt(i+2) == Character.toLowerCase(tmp))
				{
					newString.append(tmp);
					i += 3;
					continue;
				}
				else
				{
					System.out.println("Invalid String");
					return null;
				}
			} else {
				newString.append(tmp);
				i++;
			}
		}

		System.out.println(newString);
		return newString.toString();

	}

	private static String encode(String sentenceToParse) {
		StringBuilder newString = new StringBuilder();

		for (int i = 0; i < sentenceToParse.length(); i++) {

			char tmp = sentenceToParse.charAt(i);

			if (Character.isAlphabetic(tmp)) {
				if (isVowel(Character.toLowerCase(tmp))) {
					newString.append(tmp);
					continue;
				}
				newString.append(tmp + "o");
				if (Character.isUpperCase(tmp)) {
					tmp = Character.toLowerCase(tmp);
				}
				newString.append(tmp);
			} else {
				newString.append(tmp);
			}
		}

		System.out.println(newString);
		return newString.toString();
	}

	private static boolean isVowel(char tmp) {

		if (tmp == 'a' || tmp == 'e' || tmp == 'i' || tmp == 'o' || tmp == 'u'
				|| tmp == 'y' || tmp == 'å' || tmp == 'ä' || tmp == 'ö') {
			return true;
		}

		return false;
	}
}

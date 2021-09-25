package helpers;

public class Encoder {

	public static String encodePass(String pass) {

		char array[] = pass.toCharArray();

		for (int i = 0; i < array.length; i++) {

			array[i] = (char) (array[i] + (char) 5);

		}
		return String.valueOf(array);
	}

}

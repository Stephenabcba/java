import java.util.ArrayList;
import java.util.Random;
public class TestPuzzle {
    
	public static void main(String[] args) {
		PuzzleJava generator = new PuzzleJava();
		ArrayList<Integer> randomRolls = generator.getTenRolls();
		System.out.println(randomRolls);
		
    	//..
		// Write your other test cases here.
		//..
        char randomLetter = generator.getRandomLetter();
        System.out.println(randomLetter);

        String password = generator.generatePassword();
        System.out.println(password);

        ArrayList<String> passwordSet = generator.getNewPasswordSet(10);
        System.out.println(passwordSet);

        ArrayList<Integer> intArray = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            intArray.add(i);
        }
        generator.shuffleArray(intArray);
        System.out.println(intArray);
	}
}

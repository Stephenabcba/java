import java.util.Random;
import java.util.ArrayList;
public class PuzzleJava {
    Random randMachine = new Random();

    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> randomIntArray = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            randomIntArray.add(randMachine.nextInt(20) + 1);
        }
        return randomIntArray;
    }

    public char getRandomLetter() {
        char[] allLetters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int randomNumber = randMachine.nextInt(26);
        return allLetters[randomNumber];
    }

    public String generatePassword() {
        String password = "";
        for (int i = 0; i < 8; i++) {
            password += getRandomLetter();
        }
        return password;
    }

    public ArrayList<String> getNewPasswordSet(int passwordCount) {
        ArrayList<String> passwordArray = new ArrayList<String>();
        for (int i = 0; i < passwordCount; i++) {
            passwordArray.add(generatePassword());
        }
        return passwordArray;
    }

    public void shuffleArray(ArrayList<Integer> inputArray) {
        for (int i = 0; i < inputArray.size(); i++) {
            int index1 = randMachine.nextInt(inputArray.size());
            int index2 = randMachine.nextInt(inputArray.size());
            int temp = inputArray.get(index1);
            inputArray.set(index1, inputArray.get(index2));
            inputArray.set(index2, temp);
        }
    }
}
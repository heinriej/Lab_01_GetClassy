import java.util.Scanner;

public class OBJInputTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SafeInputOBJ inputHelper = new SafeInputOBJ(scanner);

        String nonZeroString = inputHelper.getNonZeroLenString("Enter a non-empty string");
        System.out.println("You entered: " + nonZeroString);

        int intValue = inputHelper.getInt("Enter an integer");
        System.out.println("You entered: " + intValue);

        double doubleValue = inputHelper.getDouble("Enter a double");
        System.out.println("You entered: " + doubleValue);

        int rangedInt = inputHelper.getRangedInt("Enter an integer between 1 and 10", 1, 10);
        System.out.println("You entered: " + rangedInt);

        double rangedDouble = inputHelper.getRangedDouble("Enter a double between 1.0 and 10.0", 1.0, 10.0);
        System.out.println("You entered: " + rangedDouble);

        boolean confirm = inputHelper.getYNConfirm("Do you want to continue? ");
        System.out.println("You answered: " + (confirm ? "Yes" : "No"));

        String regExString = inputHelper.getRegExString("Enter a word containing only letters: ", "[A-Za-z]+$");
        System.out.println("You entered: " + regExString);

        inputHelper.prettyHeader("Test Header");

        scanner.close();
    }
}

import java.util.Scanner;

public class SafeInputOBJ {
    private Scanner pipe;

    public SafeInputOBJ() {
        this.pipe = new Scanner(System.in);
    }

    public SafeInputOBJ(Scanner scanner) {
        this.pipe = scanner;
    }

    /**
     * gets a String value from the user which must be at least one character
     *
     * @param prompt prompt to tell the user what to input
     * @return String that is at least one character
     */
    public String getNonZeroLenString(String prompt) {
        String retVal = "";

        do {
            System.out.print(prompt + ": ");
            retVal = pipe.nextLine();
            if (retVal.isEmpty()) {
                System.out.println("You must enter at least one character!");
            }
        } while (retVal.isEmpty());

        return retVal;
    }

    /**
     * gets an unconstrained int value from the user
     *
     * @param prompt prompt to tell the user what to input
     * @return an unconstrained int value
     */
    public int getInt(String prompt) {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid integer not " + trash + ".");
            }
        } while (!done);

        return retVal;
    }

    /**
     * gets an unconstrained double value from the user
     *
     * @param prompt prompt to tell the user what to input
     * @return an unconstrained double value
     */
    public double getDouble(String prompt) {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid double not " + trash + ".");
            }
        } while (!done);

        return retVal;
    }

    /**
     * gets an int value from the user within the specified inclusive range
     *
     * @param prompt prompt to tell the user what to input
     * @param low    lower bound of the range
     * @param high   upper bound of the range
     * @return an int value within the specified range
     */
    public int getRangedInt(String prompt, int low, int high) {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("You must enter a valid int in range [" + low + " - " + high + "]: ");
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid integer not " + trash + ".");
            }
        } while (!done);

        return retVal;
    }

    /**
     * gets a double value from the user within the specified inclusive range
     *
     * @param prompt prompt to tell the user what to input
     * @param low    lower bound of the range
     * @param high   upper bound of the range
     * @return a double value within the specified range
     */
    public double getRangedDouble(String prompt, double low, double high) {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("You must enter a valid double in range [" + low + " - " + high + "]: ");
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid double not " + trash + ".");
            }
        } while (!done);

        return retVal;
    }

    /**
     * get a string value from the user of [Yy/Nn]
     *
     * @param prompt prompt to tell the user what to input
     * @return true for Yy (yes) and false for Nn (no)
     */
    public boolean getYNConfirm(String prompt) {
        String input = "";
        boolean retVal = false;
        boolean done = false;

        do {
            System.out.print(prompt + "[Yy/Nn]: ");
            input = pipe.nextLine();
            if (input.isEmpty()) {
                System.out.println("You must enter Yy or Nn!");
            } else if (input.equalsIgnoreCase("Y")) {
                retVal = true;
                done = true;
            } else if (input.equalsIgnoreCase("N")) {
                retVal = false;
                done = true;
            } else {
                System.out.println("You must enter Yy or Nn! Not: " + input + ".");
            }
        } while (!done);

        return retVal;
    }

    /**
     * create a pretty header for some text
     *
     * @param msg the text that will be in the header
     */
    public void prettyHeader(String msg) {
        final int totalWidth = 60;
        final int starsCount = 3;

        int messageLength = msg.length();
        int availableWidth = totalWidth - (starsCount * 2);
        int padding = (availableWidth - messageLength) / 2;

        for (int i = 0; i < totalWidth; i++) {
            System.out.print("*");
        }
        System.out.println();

        System.out.print("*".repeat(starsCount));
        for (int i = 0; i < padding; i++) {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < padding; i++) {
            System.out.print(" ");
        }
        System.out.print("*".repeat(starsCount));
        System.out.println();

        for (int i = 0; i < totalWidth; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    /**
     * returns a string value that matches a regular expression
     *
     * @param prompt tells the user what to input
     * @param regEx  String - regular expression pattern to match
     * @return a string value that matches the regular expression
     */
    public String getRegExString(String prompt, String regEx) {
        boolean done = false;
        String retVal = "";

        do {
            System.out.print(prompt + regEx + ": ");
            retVal = pipe.nextLine();
            if (retVal.matches(regEx)) {
                done = true;
            } else {
                System.out.println("You must enter a value that matches pattern " + regEx + " not " + retVal);
            }
        } while (!done);

        return retVal;
    }
}
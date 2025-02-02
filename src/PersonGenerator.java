import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {
    public static void main(String[] args) {
        boolean doneInput = false;

        String ID = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        int yearOfBirth = 0;

        ArrayList<Person> people = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        SafeInputOBJ safeInput = new SafeInputOBJ(in);

        do {
            ID = safeInput.getNonZeroLenString("Enter ID [000000]");
            firstName = safeInput.getNonZeroLenString("Enter first name");
            lastName = safeInput.getNonZeroLenString("Enter last name");
            title = safeInput.getNonZeroLenString("Enter title");
            yearOfBirth = safeInput.getRangedInt("Enter year of birth", 1940, 2000);

            try {
                Person person = new Person(firstName, lastName, ID, title, yearOfBirth);
                people.add(person);

                System.out.println(person.toCSVDataRecord());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid data: " + e.getMessage());
            }

            doneInput = safeInput.getYNConfirm("Are you done");
        } while (!doneInput);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\PersonTestData.txt");

        try {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            for (Person person : people) {
                String csvRecord = person.toCSVDataRecord();
                writer.write(csvRecord, 0, csvRecord.length());
                writer.newLine();
            }

            writer.close();
            System.out.println("Data file written!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
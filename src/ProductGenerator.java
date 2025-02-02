import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductGenerator {
    public static void main(String[] args) {
        boolean doneInput = false;

        String ID = "";
        String name = "";
        String description = "";
        double cost = 0.0;

        ArrayList<Product> products = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        SafeInputOBJ safeInput = new SafeInputOBJ(in);

        do {
            ID = safeInput.getNonZeroLenString("Enter ID [000000]");
            name = safeInput.getNonZeroLenString("Enter product name");
            description = safeInput.getNonZeroLenString("Enter product description");
            cost = safeInput.getDouble("Enter product cost");

            try {
                Product product = new Product(name, description, ID, cost);
                products.add(product);

                System.out.println(product.toCSV());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid data: " + e.getMessage());
            }

            doneInput = safeInput.getYNConfirm("Are you done");
        } while (!doneInput);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\ProductTestData.txt");

        try {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            for (Product product : products) {
                String csvRecord = product.toCSV();
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